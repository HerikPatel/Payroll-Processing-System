

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Used to run the Payroll Processing system
 * @author Malav Doshi and Herik Patel
 */

public class PayrollProcessing {

    /**
     * User input
     */
    public String input;

    /**
     * Command to be input by the user
     */
    public String command;

    /**
     * Name of the employee
     */
    public String name;

    /**
     * Department of the employee
     */
    public String dept;

    /**
     * Date input by the user
     */
    public String dateIn;

    /**
     * Date object
     */
    Date date;

    /**
     * Hourly pay rate of a part-time employee
     */
    public double hourlyPayRate;

    /**
     * Working Hours of a part-time employee
     */
    public int hours;

    /**
     * Salary of a full time employee
     */
    public double salary;

    /**
     * Role of a full-time employee in Management
     */
    public int role;

    /**
     * Used to run the Payroll processing system by taking in different commands and executing them
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Payroll Processing starts.");

        Company company = new Company();

        for(;;){
            input = sc.nextLine();

            if(input.equals("Q")){ // Checks for 'Q' to quit the session
                System.out.print("Payroll Processing completed.");
                return;
            }
            if(input.equals("")){
                System.out.println("Empty line: Invalid command!");
                continue;
            }
            StringTokenizer st = new StringTokenizer(input," ",false);

            if(st.countTokens() == 0){
                System.out.println("Invalid command!");
                continue;
            }

            if(st.hasMoreTokens()){ //Check and Set command
                command = st.nextToken();
                if(!checkCommand(st)){

                    if (!command.equals("AP") && !command.equals("AF") && !command.equals("AM") && !command.equals("R") && !command.equals("C") && !command.equals("S") && !command.equals("PA") && !command.equals("PH") && !command.equals("PD") && !command.equals("Q")) {
                        System.out.println("Command '" + command + "' not supported!");
                    }
                    else {
                        System.out.println("Invalid command!");
                    }

                    continue;
                }
            }
            if(st.hasMoreTokens()){// Check and Set name of the employee
                name = st.nextToken();
                if(!checkName()){
                    System.out.println("Invalid name format!");
                    continue;
                }
            }
            if(st.hasMoreTokens()){ //Check and Set Department
                dept = st.nextToken();
                if(!checkDept()){
                    System.out.println("'" + dept + "' is not a valid department code!");
                    continue;
                }
            }
            if(st.hasMoreTokens()){ //Check and Set Date
                dateIn = st.nextToken();
                date = new Date(dateIn);

                if(date.getMonth() == 0 || date.getDay() == 0 || date.getYear() == 0){
                    System.out.println("Invalid Date!");
                    continue;
                }

                if(!date.isValid()){//If date not valid give a warning
                    System.out.println("Invalid Date!");
                    continue;
                }
            }
            if(st.hasMoreTokens()){ //Set salary or hours or hourly pay rate
                switch (command) {

                    case "AP" -> hourlyPayRate = Double.parseDouble(st.nextToken()); //set part-time hourly rate

                    case "AF", "AM" -> salary = Double.parseDouble(st.nextToken()); //Set annual salary for full time

                    case "S" -> hours = Integer.parseInt(st.nextToken()); // Set hours for part-time employee
                }

                if(hours < 0 || hourlyPayRate < 0 || salary < 0){
                    System.out.println("Hours or Salary or Hourly pay rate cannot be negative!");
                    continue;
                }
            }
            if(st.hasMoreTokens()){
                if(command.equals("AM")){
                    role = Integer.parseInt(st.nextToken());
                    if(role < 0 || role > 3){
                        System.out.println("Invalid management code.");
                        continue;
                    }
                }
            }

            if(command.equals("AF")){

                Profile profile = new Profile(name, dept, date);

                Fulltime fullTime = new Fulltime(profile, salary);

                if(company.add(fullTime)){
                    System.out.println("Employee added.");
                }
                else{
                    System.out.println("Employee is already in the list.");
                }
            }
            else if(command.equals("AP")){

                Profile profile = new Profile(name, dept, date);

                Parttime partTime = new Parttime(profile, hourlyPayRate);

                if(company.add(partTime)){
                    System.out.println("Employee added.");
                }
                else{
                    System.out.println("Employee is already in the list.");
                }
            }
            else if(command.equals("AM")){

                if(role < 1 || role > 3){
                    System.out.println("Invalid management code.");
                    continue;
                }

                Profile profile = new Profile(name, dept, date);

                Fulltime management = new Management(profile, salary, role);

                if(company.add(management)){
                    System.out.println("Employee added.");
                }
                else{
                    System.out.println("Employee is already in the list.");
                }
            }
            else if(command.equals("C")){

                if(company.getNumEmployee() == 0){
                    System.out.println("Employee database empty.");
                    continue;
                }
                company.processPayments();
                System.out.println("Calculation of employee payments done.");
            }
            else if(command.equals("S")){

                if(hours < 0 || hours > 100){
                    System.out.println("Hours cannot be less than 0 and greater than 100");
                    continue;
                }

                if(company.getNumEmployee() == 0){
                    System.out.println("Employee database empty!");
                    continue;
                }

                Profile profile = new Profile(name, dept, date);

                Parttime partEmp = new Parttime();

                partEmp.profile = profile; //Set profile
                partEmp.setHours(hours); // Set hours

                if(company.setHours(partEmp)){
                    System.out.println("Working hours set.");
                }
                else{
                    System.out.println("Employee not found.");
                }
            }
            else if(command.equals("R")){

                if(company.getNumEmployee() == 0){
                    System.out.println("Employee database empty!");
                    continue;
                }

                Profile profile = new Profile(name, dept, date);
                Fulltime management = new Management(profile, 0, 0);
                Parttime partTime = new Parttime(profile, 0);

                if(!company.remove(management)){
                    company.remove(partTime);
                }
                else{
                    company.remove(management);
                }

                System.out.println("Employee removed.");

            }
            else if(command.equals("PA")){

                if(company.getNumEmployee() == 0){
                    System.out.println("Employee database empty!");
                    continue;
                }

                company.print();
            }
            else if(command.equals("PD")){

                if(company.getNumEmployee() == 0){
                    System.out.println("Employee database empty!");
                    continue;
                }

                company.printByDepartment();
            }
            else if(command.equals("PH")){

                if(company.getNumEmployee() == 0){
                    System.out.println("Employee database empty!");
                    continue;
                }

                company.printByDate();
            }

        }
    }

    /**
     * Used to check if a given command is valid or not
     * @param st Takes the String Tokenizer object which contains the user-input command
     * @return True if command is valid. False otherwise.
     */
    public boolean checkCommand(StringTokenizer st) {

        int tokensLeftAdd = 4;
        int tokensLeftAM = 5;
        int tokensLeftR = 3;
        int tokensLeftS = 4;

        if (command.equals("AP") || command.equals("AF") || command.equals("AM") || command.equals("R") || command.equals("C") || command.equals("S") || command.equals("PA") || command.equals("PH") || command.equals("PD") || command.equals("Q")) {

            if ((command.equals("AP") || command.equals("AF")) && st.countTokens() != tokensLeftAdd) {
                    return false;
            } else if (command.equals("AM") && st.countTokens() != tokensLeftAM) {
                return false;
            } else if (command.equals("R") && st.countTokens() != tokensLeftR) {
                return false;
            } else if (command.equals("S") && st.countTokens() != tokensLeftS) {
                return false;
            } else return (!command.equals("PA") && !command.equals("PH") && !command.equals("PD")) || st.countTokens() == 0;
        }
        return false;
    }

    /**
     * Used to check if the Department of the employee is valid or not
     * @return True if valid department. False otherwise.
     */
    public boolean checkDept(){
        return dept.equals("ECE") || dept.equals("CS") || dept.equals("IT");
    }

    /**
     * Used to check if the name is in valid format
     * @return True if valid name format. False otherwise.
     */
    public boolean checkName(){
        StringTokenizer st = new StringTokenizer(name,",",false);
        return st.countTokens() == 2;
    }

}

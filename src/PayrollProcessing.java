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
    public double hourly_pay_rate;

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
     * @author Malav Doshi and Herik Patel
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Payroll Processing running.");

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

            if(st.hasMoreTokens()){ //Check and Set command
                command = st.nextToken();
                if(!checkCommand(st)){
                    System.out.println("Invalid command!");
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
                    System.out.println("Invalid department!");
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

                    case "AP" -> hourly_pay_rate = Double.parseDouble(st.nextToken()); //set part-time hourly rate

                    case "AF", "AM" -> salary = Double.parseDouble(st.nextToken()); //Set annual salary for full time

                    case "S" -> hours = Integer.parseInt(st.nextToken()); // Set hours for part-time employee
                }
            }
            if(st.hasMoreTokens()){
                if(command.equals("AM")){
                    role = Integer.parseInt(st.nextToken());
                    if(role < 0 || role > 3){
                        System.out.println("Invalid role!");
                        continue;
                    }
                }
            }
        }
    }

    /**
     * Used to check if a given command is valid or not
     * @author Malav Doshi and Herik Patel
     * @param st Takes the String Tokenizer object which contains the user-input command
     * @return True if command is valid. False otherwise.
     */
    public boolean checkCommand(StringTokenizer st) {

        int tokens_left_Add = 4;
        int tokens_left_AM = 5;
        int tokens_left_R = 3;
        int tokens_left_S = 4;

        if (command.equals("AP") || command.equals("AF") || command.equals("AM") || command.equals("R") || command.equals("C") || command.equals("S") || command.equals("PA") || command.equals("PH") || command.equals("PD") || command.equals("Q")) {

            if ((command.equals("AP") || command.equals("AF")) && st.countTokens() != tokens_left_Add) {
                    return false;
            } else if (command.equals("AM") && st.countTokens() != tokens_left_AM) {
                return false;
            } else if (command.equals("R") && st.countTokens() != tokens_left_R) {
                return false;
            } else if (command.equals("S") && st.countTokens() != tokens_left_S) {
                return false;
            } else return (!command.equals("PA") && !command.equals("PH") && !command.equals("PD")) || st.countTokens() == 0;
        }
        return false;
    }

    /**
     * Used to check if the Department of the employee is valid or not
     * @author Malav Doshi and Herik Patel
     * @return True if valid department. False otherwise.
     */
    public boolean checkDept(){
        return dept.equals("ECE") || dept.equals("CS") || dept.equals("IT");
    }

    /**
     * Used to check if the name is in valid format
     * @author Malav Doshi and Herik Patel
     * @return True if valid name format. False otherwise.
     */
    public boolean checkName(){
        StringTokenizer st = new StringTokenizer(name,",",false);
        return st.countTokens() == 2;
    }

}

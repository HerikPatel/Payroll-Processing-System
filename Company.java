public class Company {

    /**
     * Array that stores data about Employees
     */
    private Employee[] emplist;

    /**
     * Integer value to keep track length of emplist
     */
    private int numEmployee;

    /**
     * Constructor which is used to instantiate emplist array which stores Employee data
     */
    public Company(){
        emplist = new Employee[4];
        numEmployee = 0;
    }

    /**
     * This method is used to find index for data type Employee which is stored in the array
     * @param employee An Employee data type which we want to locate in array
     * @return index of the result or -1 if the element is not in the array
     */
    private int find(Employee employee) {
        int i;
        for(i=0;i<numEmployee;i++){
            if(emplist[i].equals(employee)){
                return i;
            }
        }

        return -1; //This means book not found in the lib.
    }

    /**
     * This methods is used to increase the size of the array by 4
     */
    private void grow() {

        Employee[] temp = new Employee[emplist.length + 4]; //Declare and initialize a temp array of length +4 than original one
        int i;

        for(i=0;i < emplist.length;i++){
            temp[i] = emplist[i]; //Transfer elements to the new array
        }

         emplist = temp; //Give the reference of the new array to the original array
    }

    /**
     * This method is used to add employee to the array which data for all employees
     * @param employee It is of type Employee which has to be added to the array
     * @return true is employee is added to the array or returns false which means employee is already in the array
     */
    public boolean add(Employee employee) { //check the profile before adding

//        Fulltime fObj = new Fulltime();
//        if(fObj.equals(emplist[numEmployee])){
//            System.out.println("A FT");
//        }
//        Fulltime f = (Fulltime) emplist[numEmployee];
//        System.out.println(f.salary);

        if(numEmployee == 0){
            emplist[0] = employee;
            numEmployee++;
            return true;
        }

        int index = find(employee);


        if(index!=-1 && ((emplist[index].equals(employee)))){
            return false;
        }

        if(numEmployee == emplist.length){
            grow();
        }

        emplist[numEmployee]  = employee;
        numEmployee++;

        return true;
    }

    /**
     *Removes an Employee from the the array if employee is not in the array it returns false
     * @param employee Employee object which has to be removed
     * @return True if employee is removed form the array else returns False
     */
    public boolean remove(Employee employee) {//maintain the original sequence

        int NOT_FOUND = -1;

        int index = find(employee);

        if(index == NOT_FOUND){
            return false;
        }
        if (index==numEmployee-1) {
            numEmployee--;
            return true;
        }
        for(int i=index;i<numEmployee-1;i++)   // Overwriting the values in the array to remove particular book
        {
            Employee tempEmployee = new Employee();
            tempEmployee=emplist[i+1];
            emplist[i]=tempEmployee;
        }
        numEmployee--;

        return true;
    }

    /**
     * This method is used to set working hours for employee
     * @param employee Employee whose hours we need to set
     * @return true after hours are set for employee or returns false if employee is not in the array
     */

    public boolean setHours(Employee employee) { //set working hours for a part time

        int NOT_FOUND = -1;
        int index = find(employee);

        if(index == NOT_FOUND){
            return false;
        }

        Parttime temp = (Parttime) employee;

        Parttime parttime = (Parttime) emplist[index];
        parttime.setHours(temp.getHours());

        return true;
    }

    /**
     *
     */
    public void processPayments() { //process payments for all employees
        int i;

        for(i = 0; i < numEmployee; i++){
            emplist[i].calculatePayment();
        }
    }

    /**
     *
     */
    public void print() { } //print earning statements for all employees

    /**
     *
     */
    public void printByDepartment() { } //print earning statements by department

    /**
     *
     */
    public void printByDate() { }

    /**
     *
     * @return
     */
    public int getNumEmployee(){
        return numEmployee;
    }
}

public class Company {

    /**
     *
     */
    private Employee[] emplist;

    /**
     *
     */
    private int numEmployee;

    /**
     *
     */
    public Company(){
        emplist = new Employee[4];
        numEmployee = 0;
    }

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
     *
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
     *
     * @param employee
     * @return
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

        if(emplist[index].equals(employee)){
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
     *
     * @param employee
     * @return
     */
    public boolean remove(Employee employee) {//maintain the original sequence

        int NOT_FOUND = -1;

        int index = find(employee);

        if(index == NOT_FOUND){
            return false;
        }

        return true;
    }

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

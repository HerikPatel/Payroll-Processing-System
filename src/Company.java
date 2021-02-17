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

    //private int find(Employee employee) { }

    private void grow() { }

    /**
     *
     * @param employee
     * @return
     */
    public boolean add(Employee employee) {

//        Fulltime fObj = new Fulltime();
//        if(fObj.equals(emplist[numEmployee])){
//            System.out.println("A FT");
//        }
//        Fulltime f = (Fulltime) emplist[numEmployee];
//        System.out.println(f.salary);

        emplist[numEmployee]  = employee;
        numEmployee++;

        return true;
    } //check the profile before adding

    //public boolean remove(Employee employee) { } //maintain the original sequence

    //public boolean setHours(Employee employee) { } //set working hours for a part time

    /**
     *
     */
    public void processPayments() { } //process payments for all employees

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
}

public class Fulltime extends Employee{

    /**
     * Represents salary of the employee
     */
    public double salary;
    /**
     * Represents Payment given to employee
     */
    public double payment = 0;
    /**
     *Constructor for class Fulltime
     */
    public Fulltime(){
    }

    /**
     *
     * @param profile
     * @param salary
     */
    public Fulltime(Profile profile, double salary){

        super(profile);
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    /**
     *This method is used to calculate to payment for salary of the employee
     */
    @Override
    public void calculatePayment() {

        payment = salary / 26;
        payment = Math.round(payment * 100.0) / 100.0; //Round off to two decimal places

    }

    /**
     * This method is used to compare objects to see if the employee is already present in the database
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){

        if(obj instanceof Fulltime){
            return super.equals(obj);
        }
        return false;
    }

    /**
     * This method is used to convert fields such as name, department and date hired to string
     * @return string value which is fields such as name, department and date hired
     */
    @Override
    public String toString(){
        return profile.getName() + "::" + profile.getDepartment() + "::" + profile.getDateHired();
    }
}

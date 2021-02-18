public class Management extends Fulltime{
    /**
     * Represents Payment given to employee
     */
    private double payment = 0;
    /**
     * Represents role of the employee
     */
    private int role;
    /**
     * Represents compensation given to employee
     */
    private double compensation;

    /**
     *Constructor for the class Management
     */
    public Management(){
    }

    /**
     *Constructor used to instantiate values
     * @param profile profile of the employee
     * @param salary Salary of the employee
     * @param role Role of the employee
     */
    public Management(Profile profile, double salary, int role) {
        super(profile, salary);
        this.role = role;
    }

    /**
     *This method is used to round off the salary to nearest whole number
     * @param number Value which we want to round off
     * @return value after rounding off the number
     */
    public double roundOff(double number){ //rounds off a number to two decimal places
        return Math.round(number * 100.0) / 100.0;
    }

    /**
     * This method is used to calculate compensation for employee
     */
    @Override
    public void calculatePayment() {

        double salary = super.getSalary();
        payment = salary / 26;
        payment = Math.round(payment * 100.0) / 100.0; //Round off to two decimal places

        if(role == 1){
            compensation = roundOff(5000.0 / 26);
            payment += compensation;
        }
        else if(role == 2){
            compensation = roundOff(9500.0 / 26);
            payment += compensation;
        }
        else{
            compensation = roundOff(12000.0 / 26);
            payment += compensation;
        }
    }

    @Override
    public boolean equals(Object obj){

        if(obj instanceof Management){
            return super.equals(obj);
        }
        return false;
    }

    @Override
    public String toString(){
        return null;
    }
}

public class Parttime extends Employee{

    /**
     * Represents hourly wage for an employee
     */
    private double hourlyPayRate;
    /**
     * Represents payment for the an employee
     */
    private double payment = 0;
    /**
     * Represents total hours an employee worked
     */
    private int hours;
    /**
     * Represents how many extra hours an employee worked
     */
    private int extra_hours;
    /**
     * Constructor for the class Parttime
     */
    public Parttime(){
    }

    /**
     * Constructor for the class Parttime used to instantiate values
     */
    public Parttime(Profile profile, double hourlyPayRate){
        super(profile);
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * This method is used to set hours for part time employee
     * @param hours time which we want to set for an employee
     */
    public void setHours(int hours){
        this.hours = hours;
    }

    /**
     * This method is used to get number of hours an employee worked
     * @return
     */
    public int getHours(){
        return hours;
    }

    /**
     * This method is used to calculate payment for the part-time employee
     */
    @Override
    public void calculatePayment() {

        double extra_payment;

        if(hours > 80){ //Extra hours to be paid 1.5x hourly rate
            extra_hours = hours - 80;
            extra_payment = extra_hours * 1.5 * hourlyPayRate;
            payment += extra_payment;
            return;
        }

        payment = hours * hourlyPayRate;
    }

    @Override
    public boolean equals(Object obj){

        if(obj instanceof Parttime){
            return super.equals(obj);
        }
        return false;
    }

    @Override
    public String toString(){
        return null;
    }
}

public class Parttime extends Employee{

    /**
     *
     */
    private double hourlyPayRate;
    private double payment = 0;
    private int hours;
    private int extra_hours;
    /**
     *
     */
    public Parttime(){
    }


    public Parttime(Profile profile, double hourlyPayRate){
        super(profile);
        this.hourlyPayRate = hourlyPayRate;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public int getHours(){
        return hours;
    }

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

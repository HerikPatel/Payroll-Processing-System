public class Parttime extends Employee{

    /**
     *
     */
    private double hourlyPayRate;

    /**
     *
     */
    public Parttime(){
    }


    public Parttime(Profile profile, double hourlyPayRate){
        super(profile);
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public void calculatePayment() { }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Parttime){
            return true;
        }

        return false;
    }

    @Override
    public String toString(){
        return null;
    }
}

public class Management extends Fulltime{

    private double payment = 0;
    private int role;
    private double compensation;

    /**
     *
     */
    public Management(){
    }

    public Management(Profile profile, double salary, int role) {
        super(profile, salary);
        this.role = role;
    }

    /**
     *
     * @param number
     * @return
     */
    public double roundOff(double number){ //rounds off a number to two decimal places
        return Math.round(number * 100.0) / 100.0;
    }

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

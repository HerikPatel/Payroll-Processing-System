public class Fulltime extends Employee{

    /**
     *
     */
    public double salary;
    public double payment = 0;
    /**
     *
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
     *
     */
    @Override
    public void calculatePayment() {

        payment = salary / 26;
        payment = Math.round(payment * 100.0) / 100.0; //Round off to two decimal places

    }

    /**
     *
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
     *
     * @return
     */
    @Override
    public String toString(){
        return profile.getName() + "::" + profile.getDepartment() + "::" + profile.getDateHired();
    }
}

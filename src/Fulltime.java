public class Fulltime extends Employee{


    public double salary;

    public Fulltime(){
    }

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
    public void calculatePayment() { }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){

        if(obj instanceof Fulltime){
            return true;
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

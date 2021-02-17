public class Employee {

    /**
     *
     */
    Profile profile;

    /**
     *
     */
    public Employee(){
    }


    /**
     *
     * @param profileIn
     */
    public Employee(Profile profileIn){
        profile = new Profile(profileIn.getName(), profileIn.getDepartment(), profileIn.getDateHired());
    }

    /**
     *
     */
    public void calculatePayment() { }


    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){

        if(obj == null){
            return false;
        }

        if(!(obj instanceof Employee)){
            return false;
        }

        Employee emp = (Employee) obj;

        if((emp.profile.getName().equals(this.profile.getName())) && (emp.profile.getDepartment().equals(this.profile.getDepartment())) && (emp.profile.getDateHired().compareTo(this.profile.getDateHired())) == 0){
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

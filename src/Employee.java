public class Employee {

    /**
     * Object of type Profile
     */
    Profile profile;

    /**
     * Constructor for class Employee
     */
    public Employee(){
    }


    /**
     *Constructor for class Employee used to instantiate values
     * @param profileIn Profile which we want to assign the object to
     */
    public Employee(Profile profileIn){
        profile = new Profile(profileIn.getName(), profileIn.getDepartment(), profileIn.getDateHired());
    }

    /**
     *
     */
    public void calculatePayment() { }


    /**
     * This method is used to check that we are not entering a employee multiple times
     * @param obj Object which we want to compare to see is employee already exist
     * @return true if employee already exist else return false
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
     * Used to convert fields like name, department, date hired to string
     * @return String value of fields like name,department and date hired
     */
    @Override
    public String toString(){
        return profile.getName() + "::" + profile.getDepartment() + "::" + profile.getDateHired();
    }
}

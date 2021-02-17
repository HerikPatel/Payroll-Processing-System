public class Employee {

    Profile profile;

    /**
     *
     */
    public Employee(){
    }


    public Employee(Profile profileIn){
        profile = new Profile(profileIn.getName(), profileIn.getDepartment(), profileIn.getDateHired());
    }

    public void calculatePayment() { }


    @Override
    public boolean equals(Object obj){

        if(obj == null){
            return false;
        }

        if(obj instanceof Employee){
            return true;
        }

        return false;
    }

    @Override
    public String toString(){
        return profile.getName() + "::" + profile.getDepartment() + "::" + profile.getDateHired();
    }
}

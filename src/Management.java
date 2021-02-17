public class Management extends Fulltime{

    /**
     *
     */
    public Management(){
    }

    public Management(Profile profile, double salary, int role) {
        super(profile, salary);
    }

    @Override
    public void calculatePayment() { }

    @Override
    public boolean equals(Object obj){
        return true;
    }

    @Override
    public String toString(){
        return null;
    }
}

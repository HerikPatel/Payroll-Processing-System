import org.junit.Test;

import static org.junit.Assert.*;

public class ManagementTest {

    @Test
    public void calculatePayment() {
        //Test Case1 Calculating payment for full time employee
        Company company = new Company();
        Date date = new Date("12/12/2012");
        Profile profile = new Profile("Bob,Jack", "CS", date);
        Fulltime fulltime = new Fulltime(profile, 50000.0);
        company.add(fulltime);
        fulltime.calculatePayment();
        assertEquals(fulltime.getPayment(),1923.08,0.0);

        //Test Case2 Calculating payment for "Manager"
        date = new Date("1/2/2010");
        profile = new Profile("Jazzy,Johnson", "IT", date);
        Fulltime management = new Management(profile, 60000.0,1);
        company.add(management);
        management.calculatePayment();
        assertEquals(management.getPayment(),2500.0,0.0);

        //Test Case3 Calculating payment for "Department Head"
        date = new Date("5/2/2019");
        profile = new Profile("Jackson,Scarlett", "ECE", date);
        management = new Management(profile, 70000.0,2);
        company.add(management);
        management.calculatePayment();
        assertEquals(management.getPayment(),3057.69,0.0);

        //Test Case4 Calculating payment for "Director"
        date = new Date("6/6/2020");
        profile = new Profile("Emily,Johnson", "ECE", date);
        management = new Management(profile, 80000.0,3);
        company.add(management);
        management.calculatePayment();
        assertEquals(management.getPayment(),3538.46,0.0);

        //Test Case5 testing for incorrect payment for "Manager"
        date = new Date("1/2/2009");
        profile = new Profile("Kathy,Rodriguez", "ECE", date);
        management = new Management(profile, 60000.0,1);
        company.add(management);
        management.calculatePayment();
        assertNotEquals(management.getPayment(),250.0,0.0);
    }
}
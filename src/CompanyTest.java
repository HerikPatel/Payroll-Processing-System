import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyTest {

    @Test
    public void add() {
        // Test-Case1 Adding a full-time employee with the role “Director”
        Company company = new Company();
        Date date = new Date("12/12/2012");
        Profile profile = new Profile("Bob,Jack", "CS", date);
        Fulltime management = new Management(profile, 50000.0, 3);
        assertTrue(company.add(management));

        // Test-Case2 Adding a part-time employee
        date = new Date("12/12/2011");
        profile = new Profile("Ryan,Howard", "CS", date);
        Parttime parttime = new Parttime(profile, 30);
        assertTrue(company.add(parttime));

        // Test-Case3 Adding employee already in the system it should return false
        date = new Date("12/12/2012");
        profile = new Profile("Bob,Jack", "CS", date);
        management = new Management(profile, 50000.0, 3);
        assertFalse(company.add(management));

        // Test-Case4 Adding a full-time employee with the role “Department Head”
        date = new Date("1/1/2013");
        profile = new Profile("Kathy,James", "IT", date);
        management = new Management(profile, 45000.0, 2);
        assertTrue(company.add(management));

        // Test-Case5 Adding a full-time employee with the role “Manager”
        date = new Date("1/1/2013");
        profile = new Profile("Dwight,Schrute", "ECE", date);
        management = new Management(profile, 45000.0, 1);
        assertTrue(company.add(management));

        // Test-Case6 Adding a full-time employee
        date = new Date("5/2/2014");
        profile = new Profile("Creed,Bratton", "ECE", date);
        Fulltime fulltime = new Fulltime(profile, 40000);
        assertTrue(company.add(fulltime));
    }

    @Test
    public void remove() {
        // Test-Case1 Removing a full-time employee
        Company company = new Company();
        Date date = new Date("1/1/2013");
        Profile profile = new Profile("Kathy,James", "IT", date);
        Fulltime management = new Management(profile, 45000.0, 2);
        company.add(management);

        profile = new Profile("Kathy,James", "IT", date);
        Fulltime fulltime = new Fulltime(profile, 0);
        assertTrue(company.remove(management));

        // Test-Case2 Removing a full-time employee that does not exist it should return false
        date = new Date("6/5/2015");
        profile = new Profile("Raj,Patel", "IT", date);
        management = new Management(profile, 45000.0, 1);
        company.add(management);

        profile = new Profile("Jack,Shah", "IT", date);
        fulltime = new Fulltime(profile, 0);
        assertFalse(company.remove(fulltime));

        // Test-Case3 Removing a part-time employee
        date = new Date("2/2/2018");
        profile = new Profile("Ryan,Kapoor", "ECE", date);
        Parttime parttime = new Parttime(profile, 30);
        company.add(parttime);

        profile = new Profile("Ryan,Kapoor", "ECE", date);
        parttime = new Parttime(profile, 0);
        assertTrue(company.remove(parttime));

        // Test-Case4 Removing a part-time employee with incorrect order of name
        date = new Date("2/2/2018");
        profile = new Profile("Jack,Kapoor", "ECE", date);
        parttime = new Parttime(profile, 30);
        company.add(parttime);

        profile = new Profile("Kapoor,Jack", "ECE", date);
        parttime = new Parttime(profile, 0);
        assertFalse(company.remove(parttime));

    }

    @Test
    public void setHours() {
        // Test-Case1 Setting hours for part time employee
        Company company = new Company();
        Date date = new Date("12/12/2012");
        Profile profile = new Profile("Bob,Jack", "CS", date);
        Parttime parttime = new Parttime(profile, 30);
        company.add(parttime);
        Parttime part_emp = new Parttime();
        part_emp.profile = profile;
        part_emp.setHours(40);
        assertTrue(company.setHours(part_emp));

        // Test-Case2 Setting hours for part time employee not in the array false value will be returned
        date = new Date("2/1/2015");
        profile = new Profile("Johnson,Nova", "CS", date);
        part_emp = new Parttime();
        part_emp.profile = profile;
        part_emp.setHours(40);
        assertFalse(company.setHours(part_emp));
    }
}
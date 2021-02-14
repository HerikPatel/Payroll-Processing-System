import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollProcessing {

    public String input;

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Library Kiosk running.");

        for(;;){
            input = sc.nextLine();

            if(input.equals("Q")){ // Checks for 'Q' to quit the session
                System.out.print("Payroll Processing completed.");
                return;
            }
            if(input.equals("")){
                System.out.println("Empty line: Invalid command!");
                continue;
            }
        }
    }

}

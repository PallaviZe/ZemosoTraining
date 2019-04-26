package  Gruber.CompileCode;

//// This is the main program that loops to allow users to enter the Anniversary and SignUp Dates. It displays a success message after Date Window is shown.
//// The number of entries is limited to 5 , but can be changed as needed.

public class GruberHealthCareKYCSignUpDateWindow {

    public static void main(String[] args) throws Exception {


        for (int custNo = 0; custNo < 7; custNo++) {
            String message = " ";
            message = readInputDatesForDateWindowCalculation.scanInput();
            System.out.println(message);
        }
    }

}


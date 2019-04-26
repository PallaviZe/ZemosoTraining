package Gruber.CompileCode;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Arrays;


public class readInputDatesForDateWindowCalculation {

    public static String scanInput() throws IOException {

        String anniversaryDate = null;
        String signupDate = null;

   ///Reading Input File containing Anniversary Date and SignUp Date for Submitting KYC form using scanner

        Scanner sc = new Scanner(System.in);

        String InputDate = String.valueOf(sc.useDelimiter("\\n"));

        System.out.println("Enter the Anniversary Date  " + "and" + "   Enter the SignUp Date");

        String[] inputDateArray = sc.next().trim().split("\\s");

  ///Input Dates split intp Anniversary Date and SignUp Date for Submitting KYC form

        String message = null;
        try {
            inputDateArray = Arrays.stream(inputDateArray).filter(s -> (s != null && s.length() > 0)).toArray(String[]::new);
            LocalDate inputDateWindowStartDate = null;
            LocalDate inputDateWindowEndDate = null;

            LocalDate[] finalDateWindowStartEndDate = new LocalDate[2];
            message = " ";

            for (int inputDateCounter = 1; inputDateCounter < inputDateArray.length; inputDateCounter++) {
                anniversaryDate = inputDateArray[inputDateCounter - 1];
                signupDate = inputDateArray[inputDateCounter];

                System.out.println("Anniversary Date Entered" + anniversaryDate);
                System.out.println("SignUpDate Entered" + signupDate);

   ///Calls the Date Format Validation method

                inputDateWindowStartDate = dateFormatValidation.convertToDate(anniversaryDate);
                inputDateWindowEndDate = dateFormatValidation.convertToDate(signupDate);

   ///Calls the Date Window Calculation method. Display Date Window Start and End Dates upon success else returns an error message

                finalDateWindowStartEndDate = dateWindowForKYCSignup.calculateDateWindow(inputDateWindowStartDate, inputDateWindowEndDate);
                if (finalDateWindowStartEndDate[0].compareTo(LocalDate.ofEpochDay(0)) == 0) {
                    System.out.println("Invalid Dates entered: Enter Dates where Form Date is less than SignUp Date and Dates are less than current date");
                    message = "Correct format of Dates have to be entered again";
                } else {
                    System.out.println(" Date Window Start Date for KYC SignUp :" + finalDateWindowStartEndDate[0]);
                    System.out.println(" Date Window End Date for KYC SignUp :" + finalDateWindowStartEndDate[1]);
                    message = "Date Window Displayed Successfully";
                }
            }
        } finally {
            if (message == " ") {
                message = "Please enter correct values for dates and in correct format - dd-mm-yyyy";
            }
            return message;
        }
    }
}


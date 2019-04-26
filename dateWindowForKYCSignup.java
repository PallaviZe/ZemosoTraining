package Gruber.CompileCode;

import com.sun.media.sound.InvalidDataException;

import java.time.LocalDate;

/// This Method formats the Input Dates entered by the user to Local Date format. Calculates the Date Window Start and End Dates for Display. Throws an error
/// in case of invalid values. Returns back the DateWindow values.

public class dateWindowForKYCSignup {

    public static LocalDate[]  calculateDateWindow(LocalDate inputDateWindowStartDate, LocalDate inputDateWindowEndDate) throws InvalidDataException {

        LocalDate       finalDateForSignUpWindow       = null;
        LocalDate       finalStartDateForSignUpWindow  = null;
        LocalDate       finalEndDateForSignUpWindow    = null;
        LocalDate[]     finalStartEndDateWindow        = new LocalDate[2];

        //Calculating DateWindow for Signing Up the KYC Form:
        // Using the SimpleDateFormat to get the Month and Day of the Anniversary Date (AnniversaryDateArray) + Year of the Sign Up Date
        //Calculating the PresentYears(TodaysDateArray= SignUpYear) - Anniversary Day and Month  =    DateWindowYearAnniMonthDay


        finalDateForSignUpWindow = LocalDate.of(inputDateWindowEndDate.getYear(), inputDateWindowStartDate.getMonth(), inputDateWindowStartDate.getDayOfMonth());
        finalStartDateForSignUpWindow = finalDateForSignUpWindow.minusDays(30);
        finalEndDateForSignUpWindow = finalDateForSignUpWindow.plusDays(30);

        finalStartEndDateWindow[0] = finalStartDateForSignUpWindow;
        finalStartEndDateWindow[1] = finalEndDateForSignUpWindow;

        if (finalEndDateForSignUpWindow.compareTo(inputDateWindowEndDate) > 0) {
            finalEndDateForSignUpWindow = inputDateWindowEndDate;
            finalStartEndDateWindow[1] = inputDateWindowEndDate;
        }
        try {
            if ((finalStartDateForSignUpWindow).compareTo((finalEndDateForSignUpWindow)) == 0) {
                finalStartEndDateWindow[0] = LocalDate.ofEpochDay(00-00-0000);
                throw new InvalidDataException("SignUpDate");
            }
        } catch (InvalidDataException e) {
           System.out.println("Invalid Signup Date entered:: Date Window Start Date should be less than the Date Window End Date");

        }

        if ((finalStartDateForSignUpWindow.compareTo(inputDateWindowEndDate) > 0)) {
            finalStartEndDateWindow[0] = LocalDate.ofEpochDay(00-00-0000);

        }

        try {

            if (((finalStartDateForSignUpWindow.compareTo(LocalDate.now()) > 0) &&  ( (finalStartDateForSignUpWindow.compareTo(finalEndDateForSignUpWindow)) < 0)) || ((finalEndDateForSignUpWindow.compareTo(LocalDate.now()) > 0) && ((finalStartDateForSignUpWindow.compareTo(finalEndDateForSignUpWindow)) < 0)))
        {
                finalStartEndDateWindow[0] = LocalDate.ofEpochDay(00 - 00 - 0000);

                System.out.println("Invalid Dates entered:: Form Date and SignUp date cannot be greater than todays date");
                throw new InvalidDataException("Dates Entered");
            }
        } catch (InvalidDataException e) {
            finalStartEndDateWindow[0] = LocalDate.ofEpochDay(00-00-0000);
            System.out.println( "Invalid Dates entered:: Form Date and SignUp date cannot be greater than todays date");

        }


    return  finalStartEndDateWindow;

    }}

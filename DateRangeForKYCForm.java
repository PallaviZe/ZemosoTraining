 package Com.CleanCodeTest;

    import java.io.*;
    import java.text.DateFormat;
    import java.util.*;
    import java.text.SimpleDateFormat;

    import java.lang.String;
    import java.util.Scanner;
    import java.util.Calendar;


 public class DateRangeForKYCForm {


        public static void main(String[] args) {

             try {

            ///Reading Input File containing Anniversary Date and SignUp Date for Submitting KYC form

                 String FileName = "/home/user/IdeaProjects/CleanCodeTest/InputDatesforScanner.txt";
                 Scanner DateFile = new Scanner(new File(FileName)).useDelimiter( "dd-mm-yyyy");

            //Creating an ArrayList(DatasLine) of Input Data

                 ArrayList<String> DatasLine = new ArrayList<String>();
                 while (DateFile.hasNext())
                 {
                       String str = DateFile.next().trim();
                       DatasLine.add(str);
                 }

             //Closing the Input File

                DateFile.close();

             // Copying the Data in the ArrayList(DatasLine) to a String Array (strArrDates) to obtain the Input Dates in a line sequence

                Object[] DateRecord = DatasLine.toArray();
                String[] strArrDates = null;
                for (Object o : DateRecord )
                {
                    strArrDates = o.toString().trim().split("\\s");

                    for (String os : strArrDates );

                }
             // Creating Two Seperate Arrays for identifying the Anniversary Date and SignUp Date using java.util.Date :
             // Initializing the Arrays and counters for adding/indexing dates
             // Formatting Dates in the "dd-MM-yyyy" format

                   int TodayDateCntr = 0;
                   int AnniDateCntr = 0;
                   java.util.Date[] AnniversaryDateArray = new java.util.Date[5];
                   java.util.Date[] TodaysDateArray = new java.util.Date[5];

                   for (int DateFields = 0; DateFields < strArrDates.length; DateFields++)
                   {
                     if(DateFields%2==0)
                       {
                        AnniversaryDateArray[AnniDateCntr] = new SimpleDateFormat("dd-MM-yyyy").parse(strArrDates[DateFields].trim());
                        AnniDateCntr=AnniDateCntr+1;
                       }
                     else
                       {
                        TodaysDateArray[TodayDateCntr]= new SimpleDateFormat("dd-MM-yyyy").parse(strArrDates[DateFields].trim());
                        TodayDateCntr=TodayDateCntr+1;
                       }
                    }

             //Calculating DateWindow for Signing Up the KYC Form:
             // Using the SimpleDateFormat to get the Month and Day of the Anniversary Date (AnniversaryDateArray) + Year of the Sign Up Date
             //Calculating the PresentYears(TodaysDateArray= SignUpYear) - Anniversary Day and Month  =    DateWindowYearAnniMonthDay

                 for (int DtWincntr = 0; DtWincntr < AnniversaryDateArray.length; DtWincntr++)
                {
                    String Pattern = "d-MM-yyyy";
                    DateFormat AnniMonthAndDay = new SimpleDateFormat("d-MM-");
                    DateFormat WindowYear      =    new SimpleDateFormat("yyyy")      ;
                    String AnniversaryMonthAndDay =  AnniMonthAndDay.format(AnniversaryDateArray[DtWincntr]) ;
                    String DtWindowYear = WindowYear.format(TodaysDateArray[DtWincntr]);
                    String DateWindowYearAnniMonthDay =  AnniversaryMonthAndDay + DtWindowYear;

                //Fetching the Calendar Instance to Add and Substract 30 Days for arriving at the Date Window of Anniversary SignUp Date needed for KYC

                    Calendar Cal = Calendar.getInstance();

                //Calculate End Date Window
                    Cal.setTime(new SimpleDateFormat(Pattern).parse(DateWindowYearAnniMonthDay));
                    Cal.add(Calendar.DAY_OF_MONTH,30);
                    String DateWindowEndDate = new SimpleDateFormat(Pattern).format(Cal.getTime());

                //Calculate Start Date Window
                    Cal.setTime(new SimpleDateFormat(Pattern).parse(DateWindowYearAnniMonthDay));
                    Cal.add(Calendar.DAY_OF_MONTH,-30);
                    String DateWindowStartDate = new SimpleDateFormat(Pattern).format(Cal.getTime());

                //Displaying the +/- 30 Day Window for the KYC form fill up
                    System.out.println("KYC Sign Up Window - Startdate: " + DateWindowStartDate);
                    System.out.println("KYC Sign Up Window - Enddate: " + DateWindowEndDate);

                }

         }catch(Exception ex)
             {
                 System.out.println(ex);
             }
        }

 }

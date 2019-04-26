package  Gruber.CompileCode;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/////This program lists all the input date formats entered by the user and validates them for a format accepted by Local Date. Throws an error if not valid date format.

public class dateFormatValidation {

    public static LocalDate convertToDate(String inputDate)   {

        String[] datePatterns = { "yyyy-MM-dd",
                                                 "yyyy/MM/dd",
                                                 "dd/MM/yyyy",
                                                 "dd-MM-yyyy",
                                                 "yyyy MMM dd",
                                                 "yyyy dd MMM",
                                                 "dd MMM yyyy",
                                                 "dd MMM yyyy"  };

        LocalDate formattedDate = null;
        String message = " ";

        for (String patternForFormat : datePatterns)
        {
           try
           {

            formattedDate  = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern(patternForFormat));


          } catch(Exception e) {
             message =   "Please enter dates in valid format : dd-mm-yyyy";
          }  finally
        {
           // System.out.println("date formatted successfully");
            message =  "Please enter dates in valid format : dd-mm-yyyy";
        }}

        return formattedDate;
    }  }






package com.example.kyc;

import java.time.LocalDate;

public class KYCDateRangeCalculator {

    public DateRange getAllowedDateRange(LocalDate signupDate, LocalDate currentDate) {
        LocalDate signUpAnnivThisYear = LocalDate.of(currentDate.getYear(), signupDate.getMonth(),
                signupDate.getDayOfMonth());
        LocalDate signUpAnnivNextYear = LocalDate.of(currentDate.getYear() + 1, signupDate.getMonth(),
                signupDate.getDayOfMonth());
        LocalDate signUpAnnivLastYear = LocalDate.of(currentDate.getYear() - 1, signupDate.getMonth(),
                signupDate.getDayOfMonth());

        LocalDate allowedStartDate = null;
        LocalDate allowedEndDate = null;
        
        if (signUpAnnivThisYear.isBefore(currentDate)) {
            if (signUpAnnivNextYear.minusDays(30).isBefore(currentDate)) {
                allowedStartDate = signUpAnnivNextYear.minusDays(30);
                allowedEndDate = currentDate;
                // We are in next year sign up window
            } else {
                allowedStartDate = signUpAnnivThisYear.minusDays(30);
                if (signUpAnnivThisYear.plusDays(30).isAfter(currentDate)) {
                    allowedEndDate = currentDate;
                } else {
                    allowedEndDate = signUpAnnivThisYear.plusDays(30);
                }
            }
        } else if (signUpAnnivThisYear.isAfter(currentDate)) {
            // Is it in the 30 day window?
            if (signUpAnnivThisYear.minusDays(30).isBefore(currentDate)) {
                // yes it is in the window.
                allowedStartDate = signUpAnnivThisYear.minusDays(30);
                allowedEndDate = currentDate;
            } else {
                allowedStartDate = signUpAnnivLastYear.minusDays(30);
                if (signUpAnnivLastYear.plusDays(30).isBefore(currentDate)) {
                    allowedEndDate = signUpAnnivLastYear.plusDays(30);
                } else {
                    allowedEndDate = currentDate;
                }
            }
        } else {
            // Current Date and Anniv match
            allowedStartDate = signUpAnnivThisYear.minusDays(30);
            allowedEndDate = currentDate;
        }
        return new DateRange(allowedStartDate, allowedEndDate);
    }
}

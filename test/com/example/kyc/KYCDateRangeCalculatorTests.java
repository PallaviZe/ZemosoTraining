package com.example.kyc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class KYCDateRangeCalculatorTests {

    @ParameterizedTest(name = "Signup:{0}, Current:{1} >> Range Expected:{2}")
    @CsvSource({
            "2001-01-01, 2019-01-01, 2018-12-02:2019-01-01",
            "2001-01-01, 2019-04-01, 2018-12-02:2019-01-31"
    })
    void checkRanges(String signup, String current, 
                     String expectedRange) {
        KYCDateRangeCalculator calculator = new KYCDateRangeCalculator();
        DateRange range = calculator.getAllowedDateRange(LocalDate.parse(signup),
                LocalDate.parse(current));
        String datesExpected[] = expectedRange.split(":");
        assertEquals(LocalDate.parse(datesExpected[0]), range.getStartDate(),
                "Range Start Check");
        assertEquals(LocalDate.parse(datesExpected[1]), range.getEndDate(),
                "Range End Check");
    }
}

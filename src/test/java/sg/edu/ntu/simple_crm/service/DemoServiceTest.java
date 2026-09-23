package sg.edu.ntu.simple_crm.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoServiceTest {

    DemoService demoService;

    @BeforeEach
    public void init() {
        demoService = new DemoService();
    }

    @Test
    public void calculateAge_validYear_returnsCorrectAge() {
        // 1. ARRANGE
        int expectedAge = 35;

        // 2. ACT
        int actualAge = demoService.calculateAge(1990, 2025);

        // 3. ASSERT
        assertEquals(expectedAge, actualAge, "Age should be current year minus year of birth");
    }

    @ParameterizedTest
    @CsvSource({
            "1990, 2025, 35",
            "1965, 2025, 60",
            "2000, 2025, 25",
            "2025, 2025, 0"
    })
    public void calculateAge_variousYears_returnsCorrectAge(int yearOfBirth, int currentYear, int expectedAge) {
        // 1. ACT
        int actualAge = demoService.calculateAge(yearOfBirth, currentYear);

        // 2. ASSERT
        assertEquals(expectedAge, actualAge);
    }

    @Test
    public void formatFullName_validNames_returnsCorrectFullName() {
        // 1. ARRANGE
        String firstName = "John";
        String lastName = "Doe";
        String expectedFullName = "John Doe";

        // 2. ACT
        String actualFullName = demoService.formatFullName(firstName, lastName);

        // 3. ASSERT
        assertEquals(expectedFullName, actualFullName);
    }

    @ParameterizedTest
    @CsvSource({
            "1950, 2025, true", // 75 years old
            "1965, 2025, true", // exactly 60 — the boundary
            "1966, 2025, false", // 59 — just under
            "1990, 2025, false" // 35 years old
    })
    public void isSeniorCustomer_variousYears_returnsCorrectStatus(int yearOfBirth, int currentYear,
            boolean expectedResult) {
        // 1. ACT
        boolean actualResult = demoService.isSeniorCustomer(yearOfBirth, currentYear);

        // 2. ASSERT
        assertEquals(expectedResult, actualResult);
    }

}


    
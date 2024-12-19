package br.com.neurotech.challenge.model.entity.enums;


import br.com.neurotech.challenge.model.entity.NeurotechClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleModelTest {

    @ParameterizedTest
    @DisplayName("Should correctly evaluate eligibility for HATCH vehicle model")
    @CsvSource({
            "5000.00, 23, true",
            "10000.00, 30, true",
            "15000.00, 50, true",
            "4000.00, 25, false",
            "16000.00, 25, false"
    })
    void shouldEvaluateEligibilityForHatch(BigDecimal income, int age, boolean expectedEligibility) {
        var client = new NeurotechClient();
        client.setIncome(income);
        client.setAge(age);

        var isEligible = VehicleModel.HATCH.isEligible(client);

        assertEquals(expectedEligibility, isEligible);
    }

    @ParameterizedTest
    @DisplayName("Should correctly evaluate eligibility for SUV vehicle model")
    @CsvSource({
            "8000.01, 21, true",
            "12000.00, 30, true",
            "20000.00, 25, true",
            "8000.00, 25, false",
            "7000.00, 25, false",
            "10000.00, 18, false"
    })
    void shouldEvaluateEligibilityForSUV(BigDecimal income, int age, boolean expectedEligibility) {
        var client = new NeurotechClient();
        client.setIncome(income);
        client.setAge(age);

        var isEligible = VehicleModel.SUV.isEligible(client);

        assertEquals(expectedEligibility, isEligible);
    }
}
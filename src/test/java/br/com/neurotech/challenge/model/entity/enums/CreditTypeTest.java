package br.com.neurotech.challenge.model.entity.enums;

import br.com.neurotech.challenge.model.entity.NeurotechClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditTypeTest {

    @ParameterizedTest
    @DisplayName("Should correctly evaluate eligibility for FIXED_INTEREST credit type with age constraints")
    @CsvSource({
            "18, true",
            "22, true",
            "25, true",
            "17, false",
            "26, false"
    })
    void shouldEvaluateEligibilityForFixedInterest(int age, boolean expectedEligibility) {
        var client = new NeurotechClient();
        client.setAge(age);

        var isEligible = CreditType.FIXED_INTEREST.isEligible(client);

        assertEquals(expectedEligibility, isEligible);
    }

    @ParameterizedTest
    @DisplayName("Should correctly evaluate eligibility for VARIABLE_INTEREST credit type with age and income constraints")
    @CsvSource({
            "21, 4999.99, false",
            "21, 5000.00, true",
            "30, 10000.00, true",
            "65, 15000.00, true",
            "20, 5000.00, false",
            "66, 15000.00, false",
            "30, 20000.00, false"
    })
    void shouldEvaluateEligibilityForVariableInterest(int age, BigDecimal income, boolean expectedEligibility) {
        var client = new NeurotechClient();
        client.setAge(age);
        client.setIncome(income);

        var isEligible = CreditType.VARIABLE_INTEREST.isEligible(client);

        assertEquals(expectedEligibility, isEligible);
    }

    @ParameterizedTest
    @DisplayName("Should correctly evaluate eligibility for CONSIGNED credit type with age constraint")
    @CsvSource({
            "66, true",
            "70, true",
            "65, false"
    })
    void shouldEvaluateEligibilityForConsigned(int age, boolean expectedEligibility) {
        var client = new NeurotechClient();
        client.setAge(age);

        var isEligible = CreditType.CONSIGNED.isEligible(client);

        assertEquals(expectedEligibility, isEligible);
    }

}
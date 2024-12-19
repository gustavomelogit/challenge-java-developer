package br.com.neurotech.challenge.model.entity.enums;

import br.com.neurotech.challenge.model.entity.NeurotechClient;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum CreditType {

    FIXED_INTEREST {
        @Override
        public boolean isEligible(NeurotechClient client) {
            return (client.getAge() >= 18 && client.getAge() <= 25);
        }
    },
    VARIABLE_INTEREST {
        @Override
        public boolean isEligible(NeurotechClient client) {
            return (client.getAge() >= 21 && client.getAge() <= 65) &&
                    (client.getIncome().compareTo(new BigDecimal("5000.00")) >= 0 &&
                            client.getIncome().compareTo(new BigDecimal("15000.00")) <= 0);
        }
    },
    CONSIGNED {
        @Override
        public boolean isEligible(NeurotechClient client) {
            return (client.getAge() > 65);
        }
    };

    public abstract boolean isEligible(NeurotechClient client);

    public static List<CreditType> getEligibleCreditTypes(NeurotechClient client) {
        return Arrays.stream(CreditType.values()).filter(creditType -> creditType.isEligible(client)).toList();
    }
}
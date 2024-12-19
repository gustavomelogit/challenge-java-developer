package br.com.neurotech.challenge.model.entity.enums;

import br.com.neurotech.challenge.model.entity.NeurotechClient;

import java.math.BigDecimal;

public enum VehicleModel {
    HATCH {
        @Override
        public boolean isEligible(NeurotechClient client) {
            return client.getIncome().compareTo(new BigDecimal("5000.00")) >= 0 &&
                    client.getIncome().compareTo(new BigDecimal("15000.00")) <= 0;
        }
    },
    SUV {
        @Override
        public boolean isEligible(NeurotechClient client) {
            return client.getIncome().compareTo(new BigDecimal("8000.00")) > 0 &&
                    client.getAge() > 20;
        }
    };

    public abstract boolean isEligible(NeurotechClient client);
}
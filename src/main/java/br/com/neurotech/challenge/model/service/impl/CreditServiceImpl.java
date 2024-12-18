package br.com.neurotech.challenge.model.service.impl;

import br.com.neurotech.challenge.model.entity.VehicleModel;
import br.com.neurotech.challenge.model.service.CreditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {
    @Override
    public boolean checkCredit(String clientId, VehicleModel model) {
        return false;
    }
}

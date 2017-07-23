package com.worldticket.recruitment.service;

import com.worldticket.recruitment.model.ExchangeRate;
import org.springframework.stereotype.Service;

@Service("ExchangeRateService")
public class ExchangeRateServiceImpl implements ExchangeRateService {

    public ExchangeRate findByCurrency(String currency) {
        return null;
    }

    public void saveExchangeRate(ExchangeRate exchangeRate) {
    }
}

package com.worldticket.recruitment.service;

import com.worldticket.recruitment.model.ExchangeRate;

public interface ExchangeRateService {
    ExchangeRate findByCurrency(String currency);
    void saveExchangeRate(ExchangeRate exchangeRate);
}

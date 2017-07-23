package com.worldticket.recruitment.service;

import java.util.ArrayList;
import java.util.List;

import com.worldticket.recruitment.model.ExchangeRate;
import org.springframework.stereotype.Service;

@Service("ExchangeRateService")
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private static List<ExchangeRate> exchangeRates;

    static {
        exchangeRates = populateDummyRates();
    }

    public ExchangeRate findByCurrency(String currency) {
        for (ExchangeRate exchangeRate : exchangeRates) {
            //if(exchangeRate.getCurrency() == currency && exchangeRate.getDenomination() >= denomination && exchangeRate.getDenomination()<=denomination){
            if (exchangeRate.getCurrency().equals(currency)) {
                System.out.println("currency " + currency);
                return exchangeRate;
            }
        }
        return null;
    }

    public void saveExchangeRate(ExchangeRate exchangeRate) {
        ExchangeRate exchange = new ExchangeRate();
        exchange.setCurrency(exchangeRate.getCurrency());
        exchange.setDenomination(exchangeRate.getDenomination());
        exchange.setBuying(exchangeRate.getBuying());
        exchange.setSelling(exchangeRate.getSelling());

        exchangeRates.add(exchange);
    }

    private static List<ExchangeRate> populateDummyRates() {
        List<ExchangeRate> exchangeRates = new ArrayList<ExchangeRate>();
        ExchangeRate exchange = new ExchangeRate();
        exchange.setCurrency("USD");
        exchange.setDenomination("100");
        exchange.setBuying(33.45);
        exchange.setSelling(33.45);
        exchangeRates.add(exchange);
        exchange.setCurrency("USD");
        exchange.setDenomination("50");
        exchange.setBuying(33.30);
        exchange.setSelling(33.45);
        exchangeRates.add(exchange);
        exchange.setCurrency("HKD");
        exchange.setDenomination("1000-10");
        exchange.setBuying(4.27);
        exchange.setSelling(4.3);
        exchangeRates.add(exchange);
        exchange.setCurrency("JPY");
        exchange.setDenomination("1000-100");
        exchange.setBuying(0.299);
        exchange.setSelling(0.30);
        exchangeRates.add(exchange);
        return exchangeRates;
    }
}

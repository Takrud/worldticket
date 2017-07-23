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
        System.out.println("hello ");
        for (ExchangeRate exchangeRate : exchangeRates) {
            System.out.println("hello1 " + exchangeRate.getCurrency());
            System.out.println("hello2 " + currency);
            //if(exchangeRate.getCurrency() == currency && exchangeRate.getDenomination() >= denomination && exchangeRate.getDenomination()<=denomination){
            if (exchangeRate.getCurrency().equals(currency)) {
                System.out.println("currency " + currency);
                return exchangeRate;
            }
        }
        return null;
    }

    public void saveExchangeRate(ExchangeRate exchangeRate) {
        exchangeRates.add(new ExchangeRate(exchangeRate.getCurrency(), exchangeRate.getDenomination(), exchangeRate.getBuying(), exchangeRate.getSelling()));
    }

    private static List<ExchangeRate> populateDummyRates() {
        List<ExchangeRate> exchangeRates = new ArrayList<ExchangeRate>();
        exchangeRates.add(new ExchangeRate("USD", "100", 33.45, 33.45));
        exchangeRates.add(new ExchangeRate("USD", "50", 33.30, 33.45));
        exchangeRates.add(new ExchangeRate("JPY", "1000-100", 0.299, 0.30));
        exchangeRates.add(new ExchangeRate("HKD", "1000-10", 4.27, 4.3));
        return exchangeRates;
    }
}

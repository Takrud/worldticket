package com.worldticket.recruitment;

import java.net.URI;
import com.worldticket.recruitment.model.ExchangeRate;
import org.springframework.web.client.RestTemplate;

public class ExchangeRateRestClientTest {

    public static final String REST_SERVICE_URI = "http://localhost:8080/worldTicket";

    /* GET */
    private static void getExchangeRate(){
        System.out.println("Testing get exchange rate API----------");
        RestTemplate restTemplate = new RestTemplate();
        ExchangeRate exchangeRate = restTemplate.getForObject(REST_SERVICE_URI+"/exchangeRate/USD", ExchangeRate.class);
        System.out.println(exchangeRate);
    }

    /* POST */
    private static void createExchangeRate() {
        System.out.println("Testing create exchange rate API----------");
        RestTemplate restTemplate = new RestTemplate();
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setCurrency("USD");
        exchangeRate.setDenomination(100);
        exchangeRate.setBuying(33.45);
        exchangeRate.setSelling(33.4);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/exchangeRate/", exchangeRate, ExchangeRate.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    public static void main(String args[]){
        getExchangeRate();
        createExchangeRate();
    }
}
package com.worldticket.recruitment.controller;

import com.worldticket.recruitment.model.ExchangeRate;
import com.worldticket.recruitment.service.ExchangeRateService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ExchangeRateRestController {
    @Autowired
    ExchangeRateService exchangeRateService;

    @RequestMapping(value = "/exchangeRate/{currency}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExchangeRate> getExchangeRate(@PathVariable("currency") String currency) {
        System.out.println("Fetching Exchange Rate with currency code " + currency);
        ExchangeRate exchangeRate = exchangeRateService.findByCurrency(currency);
        if (exchangeRate == null) {
            System.out.println("Exchange Rate with currency code " + currency + " not found");
            return new ResponseEntity<ExchangeRate>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ExchangeRate>(exchangeRate, HttpStatus.OK);
    }

    @RequestMapping(value = "/exchangeRate/", method = RequestMethod.POST)
    public ResponseEntity<Void> createExchangeRate(@RequestBody ExchangeRate exchangeRate, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Exchange Rate " + exchangeRate.getCurrency());

        exchangeRateService.saveExchangeRate(exchangeRate);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/exchangeRate/{currency}").buildAndExpand(exchangeRate.getCurrency()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


}


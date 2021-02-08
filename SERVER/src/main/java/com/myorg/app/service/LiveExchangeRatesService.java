package com.myorg.app.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LiveExchangeRatesService {
	
	 private final RestTemplate restTemplate;
	 private ExchangeRates exchangeRates ; 
	 @Value("${app.fx.url}")
     private String fxUrl;
  
	    /* Build a RestTemplate to connect and fetch exchange rates*/
	    public LiveExchangeRatesService(RestTemplateBuilder restTemplateBuilder) {
	        this.restTemplate = restTemplateBuilder.build();
	    }

	    /* Marshal json response from 3rd party in to ExchangeRates java object*/
	    public ExchangeRates getPostsPlainJSON() throws JsonMappingException, JsonProcessingException {
	        ObjectMapper om = new ObjectMapper();
	        String jsonString = this.restTemplate.getForObject(fxUrl, String.class);
	        exchangeRates = om.readValue(jsonString, ExchangeRates.class);
	        return exchangeRates;
	    }
	    
	    /* Use ExchangeRates object to retrieve exchange rates for interested currencies*/
	    public BigDecimal convert(String fromCurrencyType, String toCurrencyType, BigDecimal amount) throws JsonMappingException, 
	    					JsonProcessingException, NoSuchMethodException, SecurityException, 
	    					IllegalAccessException, InvocationTargetException {
	    	ExchangeRates exchangeRates = getPostsPlainJSON();
	    	/* Rates object holds the exchange rates as its properties*/
	    	Rates rates = exchangeRates.getRates();
	 
	    	/* Exchange Rates is in three character currency codes (USD,GBP), corresponding 
	    	 * get() methods for each currency types gives the current value.*/
	    	String toCurrencyTypeMethodName = "get" + toCurrencyType.toUpperCase();
	    	String fromCurrencyTypeMethodName = "get" + fromCurrencyType.toUpperCase();
	    	
	    	/* Use reflection to get the method names for two currency types*/
	    	Method fromCurrency = Rates.class.getMethod(fromCurrencyTypeMethodName);
	    	Method toCurrency = Rates.class.getMethod(toCurrencyTypeMethodName);

	    	/* Obtain the values from the exchangeRates.getRates()*/
	    	Double fromCurrencyRates = (Double) fromCurrency.invoke(rates);
	    	Double toCurrencyRates =  (Double) toCurrency.invoke(rates);
	 
	    	/* This is the amount we want to convert*/
	    	Double fromCurrencyAmt = amount.doubleValue();
	    	
	    	/* Do the calculation making Euro as the base*/
	    	Double totalEuro = fromCurrencyAmt / fromCurrencyRates;
	    	Double toCurrencyAmt = totalEuro * toCurrencyRates; 

	    	return new BigDecimal(toCurrencyAmt);
	    }
}


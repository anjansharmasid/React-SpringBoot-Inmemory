package com.myorg.app.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Convertcurrency {
	BigDecimal value = new BigDecimal(-1);
	String fromCurrency ;
	String toCurrency ;
	BigDecimal amount;
	BigDecimal convertedAmount;
}

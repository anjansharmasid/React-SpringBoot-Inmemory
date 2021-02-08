// This is a Auto generate class for json response marshaling 
package com.myorg.app.service;
import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

public class ExchangeRates {
	@JsonProperty("rates")
	public Rates getRates() {
		return this.rates;
	}
	
	public void setRates(Rates rates) {
		this.rates = rates;
	}
	Rates rates;
	
	@JsonProperty("base")
	public String getBase() {
		return this.base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	String base;

	@JsonProperty("date")
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	String date;
}

class Rates {
	@JsonProperty("CAD")
	public double getCAD() {
		return this.cAD;
	}

	public void setCAD(double cAD) {
		this.cAD = cAD;
	}

	double cAD;

	@JsonProperty("HKD")
	public double getHKD() {
		return this.hKD;
	}

	public void setHKD(double hKD) {
		this.hKD = hKD;
	}

	double hKD;

	@JsonProperty("ISK")
	public double getISK() {
		return this.iSK;
	}

	public void setISK(double iSK) {
		this.iSK = iSK;
	}

	double iSK;

	@JsonProperty("PHP")
	public double getPHP() {
		return this.pHP;
	}

	public void setPHP(double pHP) {
		this.pHP = pHP;
	}

	double pHP;

	@JsonProperty("DKK")
	public double getDKK() {
		return this.dKK;
	}

	public void setDKK(double dKK) {
		this.dKK = dKK;
	}

	double dKK;

	@JsonProperty("HUF")
	public double getHUF() {
		return this.hUF;
	}

	public void setHUF(double hUF) {
		this.hUF = hUF;
	}

	double hUF;

	@JsonProperty("CZK")
	public double getCZK() {
		return this.cZK;
	}

	public void setCZK(double cZK) {
		this.cZK = cZK;
	}

	double cZK;

	@JsonProperty("AUD")
	public double getAUD() {
		return this.aUD;
	}

	public void setAUD(double aUD) {
		this.aUD = aUD;
	}

	double aUD;

	@JsonProperty("RON")
	public double getRON() {
		return this.rON;
	}

	public void setRON(double rON) {
		this.rON = rON;
	}

	double rON;

	@JsonProperty("SEK")
	public double getSEK() {
		return this.sEK;
	}

	public void setSEK(double sEK) {
		this.sEK = sEK;
	}

	double sEK;

	@JsonProperty("IDR")
	public double getIDR() {
		return this.iDR;
	}

	public void setIDR(double iDR) {
		this.iDR = iDR;
	}

	double iDR;

	@JsonProperty("INR")
	public double getINR() {
		return this.iNR;
	}

	public void setINR(double iNR) {
		this.iNR = iNR;
	}

	double iNR;

	@JsonProperty("BRL")
	public double getBRL() {
		return this.bRL;
	}

	public void setBRL(double bRL) {
		this.bRL = bRL;
	}

	double bRL;

	@JsonProperty("RUB")
	public double getRUB() {
		return this.rUB;
	}

	public void setRUB(double rUB) {
		this.rUB = rUB;
	}

	double rUB;

	@JsonProperty("HRK")
	public double getHRK() {
		return this.hRK;
	}

	public void setHRK(double hRK) {
		this.hRK = hRK;
	}

	double hRK;

	@JsonProperty("JPY")
	public double getJPY() {
		return this.jPY;
	}

	public void setJPY(double jPY) {
		this.jPY = jPY;
	}

	double jPY;

	@JsonProperty("THB")
	public double getTHB() {
		return this.tHB;
	}

	public void setTHB(double tHB) {
		this.tHB = tHB;
	}

	double tHB;

	@JsonProperty("CHF")
	public double getCHF() {
		return this.cHF;
	}

	public void setCHF(double cHF) {
		this.cHF = cHF;
	}

	double cHF;

	@JsonProperty("SGD")
	public double getSGD() {
		return this.sGD;
	}

	public void setSGD(double sGD) {
		this.sGD = sGD;
	}

	double sGD;

	@JsonProperty("PLN")
	public double getPLN() {
		return this.pLN;
	}

	public void setPLN(double pLN) {
		this.pLN = pLN;
	}

	double pLN;

	@JsonProperty("BGN")
	public double getBGN() {
		return this.bGN;
	}

	public void setBGN(double bGN) {
		this.bGN = bGN;
	}

	double bGN;

	@JsonProperty("TRY")
	public double getTRY() {
		return this.tRY;
	}

	public void setTRY(double tRY) {
		this.tRY = tRY;
	}

	double tRY;

	@JsonProperty("CNY")
	public double getCNY() {
		return this.cNY;
	}

	public void setCNY(double cNY) {
		this.cNY = cNY;
	}

	double cNY;

	@JsonProperty("NOK")
	public double getNOK() {
		return this.nOK;
	}

	public void setNOK(double nOK) {
		this.nOK = nOK;
	}

	double nOK;

	@JsonProperty("NZD")
	public double getNZD() {
		return this.nZD;
	}

	public void setNZD(double nZD) {
		this.nZD = nZD;
	}

	double nZD;

	@JsonProperty("ZAR")
	public double getZAR() {
		return this.zAR;
	}

	public void setZAR(double zAR) {
		this.zAR = zAR;
	}

	double zAR;

	@JsonProperty("USD")
	public double getUSD() {
		return this.uSD;
	}

	public void setUSD(double uSD) {
		this.uSD = uSD;
	}

	double uSD;

	@JsonProperty("MXN")
	public double getMXN() {
		return this.mXN;
	}

	public void setMXN(double mXN) {
		this.mXN = mXN;
	}

	double mXN;

	@JsonProperty("ILS")
	public double getILS() {
		return this.iLS;
	}

	public void setILS(double iLS) {
		this.iLS = iLS;
	}

	double iLS;

	@JsonProperty("GBP")
	public double getGBP() {
		return this.gBP;
	}

	public void setGBP(double gBP) {
		this.gBP = gBP;
	}

	double gBP;

	@JsonProperty("KRW")
	public double getKRW() {
		return this.kRW;
	}

	public void setKRW(double kRW) {
		this.kRW = kRW;
	}

	double kRW;

	@JsonProperty("MYR")
	public double getMYR() {
		return this.mYR;
	}

	public void setMYR(double mYR) {
		this.mYR = mYR;
	}

	double mYR;
}

package com.gkalogiros.supermarket;

/**
 * This class represents the price of
 * an item in the Super Market.
 */
public class Price {

    private double value;

    private Currency currency;

    public Price(Currency currency, double value) {
        this.value = value;
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}

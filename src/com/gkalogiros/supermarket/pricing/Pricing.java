package com.gkalogiros.supermarket.pricing;

import com.gkalogiros.supermarket.Price;

public abstract class Pricing {

    public double calculate(double quantity, Price price){
        return quantity * price.getValue();
    }

}

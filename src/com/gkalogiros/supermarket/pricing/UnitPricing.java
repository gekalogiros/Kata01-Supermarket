package com.gkalogiros.supermarket.pricing;

import com.gkalogiros.supermarket.Price;

/**
 * Unit pricing e.g Cheese £1.99 per 100g
 */
public class UnitPricing extends Pricing
{
    double unitQuantity;

    public UnitPricing(double unitQuantity)
    {
        this.unitQuantity = unitQuantity;
    }

    @Override
    public double calculate(double quantity, Price price)
    {
        return quantity / unitQuantity * price.getValue();
    }
}

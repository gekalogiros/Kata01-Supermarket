package com.gkalogiros.supermarket.pricing;

import com.gkalogiros.supermarket.Price;

/**
 * 3 for fixed price e.g discount 3 for £1
 */
public class DiscountPricing extends Pricing {

    private int bundleSize;
    private double bundlePrice;

    public DiscountPricing(int bundleSize, double bundlePrice)
    {
        this.bundlePrice = bundlePrice;
        this.bundleSize = bundleSize;
    }

    @Override
    public double calculate(double quantity, Price price)
    {
        return calculateOffer(quantity) + (quantity % bundleSize * price.getValue());

    }

    private double calculateOffer(double quantity)
    {
        double offerSum = 0;

        if (quantity > bundleSize)
        {
            offerSum = (int)quantity / bundleSize * bundlePrice;
        }

        return offerSum;
    }
}

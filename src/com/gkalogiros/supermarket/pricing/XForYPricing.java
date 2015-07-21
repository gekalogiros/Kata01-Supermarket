package com.gkalogiros.supermarket.pricing;

import com.gkalogiros.supermarket.Price;

/**
 * 3 for 2 Pricing e.g 3 Fizzy Drinks for the price of two
 */
public class XForYPricing extends Pricing {

    private int bundle, payingBundle;

    public XForYPricing(int totalBundle, int payingBundle)
    {
        this.bundle = totalBundle;
        this.payingBundle = payingBundle;
    }

    @Override
    public double calculate(double quantity, Price price)
    {
        double offerPrice = price.getValue() * payingBundle;

        double offerSum = 0;

        if (quantity > bundle)
        {

            offerSum =  (int)quantity / bundle * offerPrice;
        }

        return offerSum + (quantity % bundle * price.getValue());
    }

}

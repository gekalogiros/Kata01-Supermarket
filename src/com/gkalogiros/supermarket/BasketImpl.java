package com.gkalogiros.supermarket;

import com.gkalogiros.supermarket.interfaces.Basket;
import com.gkalogiros.supermarket.pricing.Pricing;
import com.gkalogiros.supermarket.interfaces.ProductStore;

import java.util.*;

/**
 * This is an implementation of {@link com.gkalogiros.supermarket.interfaces.Basket.class}
 */
public class BasketImpl implements Basket {

    private Map<Long, Double> basketStore = null;
    private ProductStore<Long> store;

    public BasketImpl(ProductStore<Long> store) {
        this.basketStore = new HashMap<Long, Double>();
        this.store = store;
    }

    public double getTotal()
    {
        double sum = 0l;
        for (Long id : basketStore.keySet())
        {
            double amount = basketStore.get(id);
            sum += calculateSumForThisProduct(id, amount);
        }

        return sum;
    }

    public void add(Long productID, double quantity)
    {
        if (null == basketStore.get(productID))
        {
            basketStore.put(productID, quantity);
        }
        else
        {
            double currQuantity = basketStore.get(productID);
            basketStore.put(productID, currQuantity + quantity);
        }
    }

    private double calculateSumForThisProduct(Long productID, double amount)
    {
        Product product = store.get(productID);
        Pricing pricing = product.getPricing();
        Price   price   = product.getPrice();

        return pricing.calculate(amount,price);
    }

}

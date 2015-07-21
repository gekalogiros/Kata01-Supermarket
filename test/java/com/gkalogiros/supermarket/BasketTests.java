package com.gkalogiros.supermarket;

import com.gkalogiros.supermarket.interfaces.Basket;
import com.gkalogiros.supermarket.pricing.DiscountPricing;
import com.gkalogiros.supermarket.pricing.SinglePricing;
import com.gkalogiros.supermarket.pricing.UnitPricing;
import com.gkalogiros.supermarket.pricing.XForYPricing;
import com.gkalogiros.supermarket.interfaces.ProductStore;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTests {

    private static final ProductStore<Long> store = ProductStoreImpl.getInstance();

    private static final long PHILADELPHIA_ID = 0;
    private static final long PIZZA_ID = 1;
    private static final long BEN_AND_JERRYS_ID = 2;
    private static final long CHEDDAR_ID = 3;

    private static final double PHILADELPHIA_PRICE = 3.00;
    private static final double PIZZA_PRICE = 5.00;
    private static final double BEN_AND_JERRYS_PRICE = 6.00;
    private static final double CHEDDAR_PRICE_PER_300 = 10.00;

    private static final int GRAMS_300 = 300;


    @BeforeClass
    public static void fixture()
    {
        long id = 0;
        Product philadelphia =
                new ProductBuilder<Long>()
                        .productID(id)
                        .name("Philadelphia cheese")
                        .description("The most tasty cheese ever")
                        .price(new Price(Currency.GBP, PHILADELPHIA_PRICE))
                        .pricing(new SinglePricing()).build();

        Product pizza =
                new ProductBuilder<Long>()
                        .productID(++id)
                        .name("Pepperoni Pizza")
                        .description("Pizza with Pepperoni and mushrooms")
                        .price(new Price(Currency.GBP, PIZZA_PRICE))
                        .pricing(new XForYPricing(3, 2))
                        .build();

        Product benAndJerrys =
                new ProductBuilder<Long>()
                        .productID(++id)
                        .name("Ben & Jerrys")
                        .description("Ben & Jerrys ice cream")
                        .price(new Price(Currency.GBP, BEN_AND_JERRYS_PRICE))
                        .pricing(new DiscountPricing(3, 5.0))
                        .build();

        Product cheddarCheese =
                new ProductBuilder<Long>()
                        .productID(++id)
                        .name("Cheddar Cheese")
                        .description("Soft and Light cheddar cheese")
                        .price(new Price(Currency.GBP, CHEDDAR_PRICE_PER_300))
                        .pricing(new UnitPricing(GRAMS_300))
                        .build();

        store.add(philadelphia);
        store.add(pizza);
        store.add(benAndJerrys);
        store.add(cheddarCheese);
    }

    @Test
    public void thatCalculationOfSinglePricingIsCorrect()
    {
        double delta = 0.001;
        double quantity = 4;

        Basket basket = new BasketImpl(store);
        basket.add(PHILADELPHIA_ID, quantity);

        assertEquals(quantity * PHILADELPHIA_PRICE, basket.getTotal(), delta);
    }

    @Test
    public void thatCalculationOfXForYPricingIsCorrect()
    {
        double delta = 0.001;
        double quantity = 4;

        Basket basket = new BasketImpl(store);
        basket.add(PIZZA_ID, quantity);

        assertEquals((quantity - 1) * PIZZA_PRICE, basket.getTotal(), delta);
    }

    @Test
    public void thatCalculationOfDiscountPricingIsCorrect()
    {
        double delta = 0.001;
        double quantity = 4;

        Basket basket = new BasketImpl(store);
        basket.add(BEN_AND_JERRYS_ID, quantity);

        assertEquals(11.0, basket.getTotal(), delta);
    }

    @Test
    public void thatCalculationOfUnitPricingIsCorrect()
    {
        double delta = 0.001;
        double quantity = 600;

        Basket basket = new BasketImpl(store);
        basket.add(CHEDDAR_ID, quantity);

        assertEquals(CHEDDAR_PRICE_PER_300 * (600/GRAMS_300), basket.getTotal(), delta);
    }
}

package com.gkalogiros.supermarket;

import com.gkalogiros.supermarket.*;
import com.gkalogiros.supermarket.pricing.SinglePricing;
import com.gkalogiros.supermarket.interfaces.ProductStore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductStoreTests {

    @Test
    public void thatCanAddToProductStore()
    {

        Product<Long> product =
                new ProductBuilder()
                        .productID(1l)
                        .description("Test Description")
                        .name("Pizza")
                        .price(new Price(Currency.GBP, 10))
                        .pricing(new SinglePricing()).build();

        ProductStore<Long> store = ProductStoreImpl.getInstance();
        store.add(product);

        assertNotNull(store.get(product.getId()));

    }

}

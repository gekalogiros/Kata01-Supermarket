package com.gkalogiros.supermarket;

import com.gkalogiros.supermarket.pricing.Pricing;

/**
 * A Builder class for building product objects.
 * A product can be associated with an id of any
 * type.
 *
 * @param <T>
 */
public class ProductBuilder<T> {

        private Product<T> product;

        public ProductBuilder()
        {
            product = new Product();
        }

        public ProductBuilder productID(T id)
        {
            product.setId(id);
            return this;
        }

        public ProductBuilder name(String name)
        {
            product.setName(name);
            return this;
        }

        public ProductBuilder description(String description)
        {
            product.setDescription(description);
            return this;
        }

        public ProductBuilder price(Price price)
        {
            product.setPrice(price);
            return this;
        }

        public ProductBuilder pricing(Pricing pricing)
        {
            product.setPricing(pricing);
            return this;
        }

        public Product<T> build()
        {
            return product;
        }
}

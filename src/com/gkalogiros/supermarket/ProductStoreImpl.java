package com.gkalogiros.supermarket;

import com.gkalogiros.supermarket.interfaces.ProductStore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A synchronized cache that can be used as a product
 * store. This is an implementation of the
 * {@link com.gkalogiros.supermarket.interfaces.ProductStore.class}
 * class.
 */
public class ProductStoreImpl implements ProductStore<Long> {


    private static ProductStore instance;

    private Map<Long, Product> products;

    static {
        synchronized (ProductStoreImpl.class) {
            if (ProductStoreImpl.instance == null) {
                ProductStoreImpl.instance = new ProductStoreImpl();
            }
        }
    }

    private ProductStoreImpl() {
        this.products = new ConcurrentHashMap<Long, Product>();
    }

    public static ProductStore getInstance(){
        return instance;
    }

    public Product get(Long t) {
        return (null != products.get(t)) ? products.get(t) : new Product();
    }

    public void add(Product<Long> product) {
        if (null != product) products.put(product.getId(), product);
    }
}

package com.gkalogiros.supermarket.interfaces;

import com.gkalogiros.supermarket.Product;

public interface ProductStore<T> {

    public Product get(T t);

    public void add(Product<T> product);

}

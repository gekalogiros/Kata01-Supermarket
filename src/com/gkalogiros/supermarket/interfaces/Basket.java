package com.gkalogiros.supermarket.interfaces;

public interface Basket {
    public double getTotal();
    public void add(Long productID, double amount);
}

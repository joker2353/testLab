package com.malkinfo.rentalapp;

/**
 * The Rental interface represents the contract for renting items.
 * Classes that implement this interface should provide the implementation for the rent method.
 */
public interface Rental {

    /**
     * Initiates the rental process for an item.
     * The specific behavior of this method should be defined in the implementing class.
     */
    void rent();
}

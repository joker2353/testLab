package com.malkinfo.rentalapp;

/**
 * The HomeModal class represents a model for a home listing.
 */
public class HomeModal {
    /** The price of the home. */
    public String price;

    /** The ID of the home. */
    public Integer id;

    /** The location of the home. */
    public String location;

    /** The detailed description of the home. */
    public String description;

    /** A short description of the home. */
    public String shortDescription;

    /** The URL of the image representing the home. */
    public String image;

    /**
     * Constructs a new HomeModal object.
     * @param id The ID of the home.
     * @param price The price of the home.
     * @param location The location of the home.
     * @param description The detailed description of the home.
     * @param shortDescription A short description of the home.
     * @param image The URL of the image representing the home.
     */
    public HomeModal(Integer id, String price, String location, String description, String shortDescription, String image) {
        this.price = price;
        this.id = id;
        this.location = location;
        this.description = description;
        this.shortDescription = shortDescription;
        this.image = image;
    }

    /**
     * Default constructor for HomeModal.
     */
    public HomeModal() {
    }

    /**
     * Retrieves the price of the home.
     * @return The price of the home.
     */
    public String getPrice() {
        return price;
    }

    /**
     * Retrieves the ID of the home.
     * @return The ID of the home.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Retrieves the location of the home.
     * @return The location of the home.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Retrieves the detailed description of the home.
     * @return The detailed description of the home.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the short description of the home.
     * @return A short description of the home.
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Retrieves the URL of the image representing the home.
     * @return The URL of the image representing the home.
     */
    public String getImage() {
        return image;
    }
}

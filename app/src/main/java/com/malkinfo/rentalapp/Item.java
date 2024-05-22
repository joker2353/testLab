package com.malkinfo.rentalapp;

/**
 * The Item class represents an item in the rental application.
 * Each item has attributes such as location, price, description, and image.
 */
public class Item {

    private String location;
    private String price;
    private String description;
    private String shortDescription;
    private String image;

    /**
     * Constructs an Item object with the specified attributes.
     *
     * @param location       The location of the item.
     * @param price          The price of the item.
     * @param description    The description of the item.
     * @param shortDescription The short description of the item.
     * @param image          The image URL of the item.
     */
    public Item(String location, String price, String description, String shortDescription, String image) {
        this.location = location;
        this.price = price;
        this.description = description;
        this.shortDescription = shortDescription;
        this.image = image;
    }

    /**
     * Retrieves the image URL of the item.
     *
     * @return The image URL of the item.
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image URL of the item.
     *
     * @param image The image URL of the item.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Sets the location of the item.
     *
     * @param location The location of the item.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the price of the item.
     *
     * @param price The price of the item.
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Sets the description of the item.
     *
     * @param description The description of the item.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the short description of the item.
     *
     * @param shortDescription The short description of the item.
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Default constructor for the Item class.
     */
    public Item() {
    }

    /**
     * Constructs an Item object with location, price, and short description.
     *
     * @param location       The location of the item.
     * @param price          The price of the item.
     * @param shortDescription The short description of the item.
     */
    public Item(String location, String price, String shortDescription) {
        this.location = location;
        this.price = price;
        this.shortDescription = shortDescription;
    }

    /**
     * Retrieves the location of the item.
     *
     * @return The location of the item.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Retrieves the price of the item.
     *
     * @return The price of the item.
     */
    public String getPrice() {
        return price;
    }

    /**
     * Retrieves the description of the item.
     *
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the short description of the item.
     *
     * @return The short description of the item.
     */
    public String getShortDescription() {
        return shortDescription;
    }
}

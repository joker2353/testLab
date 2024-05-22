package com.malkinfo.rentalapp;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

import org.junit.Test;

public class ItemTest extends TestCase {
    void testGetLocation() {
        String location = "Location";
        Item item = new Item(location, "100", "Description", "Short Description", "image_url");
        assertEquals(location, item.getLocation(), "Location should match the one provided in the constructor");
    }

    @Test
    void testGetPrice() {
        String price = "100";
        Item item = new Item("Location", price, "Description", "Short Description", "image_url");
        assertEquals(price, item.getPrice(), "Price should match the one provided in the constructor");
    }

    @Test
    void testGetDescription() {
        String description = "Description";
        Item item = new Item("Location", "100", description, "Short Description", "image_url");
        assertEquals(description, item.getDescription(), "Description should match the one provided in the constructor");
    }

    @Test
    void testGetShortDescription() {
        String shortDescription = "Short Description";
        Item item = new Item("Location", "100", "Description", shortDescription, "image_url");
        assertEquals(shortDescription, item.getShortDescription(), "Short description should match the one provided in the constructor");
    }

    @Test
    void testGetImage() {
        String imageUrl = "image_url";
        Item item = new Item("Location", "100", "Description", "Short Description", imageUrl);
        assertEquals(imageUrl, item.getImage(), "Image URL should match the one provided in the constructor");
    }

    @Test
    void testSetLocation() {
        String location = "New Location";
        Item item = new Item();
        item.setLocation(location);
        assertEquals(location, item.getLocation(), "Location should be set correctly");
    }

    @Test
    void testSetPrice() {
        String price = "200";
        Item item = new Item();
        item.setPrice(price);
        assertEquals(price, item.getPrice(), "Price should be set correctly");
    }

    @Test
    void testSetDescription() {
        String description = "New Description";
        Item item = new Item();
        item.setDescription(description);
        assertEquals(description, item.getDescription(), "Description should be set correctly");
    }

    @Test
    void testSetShortDescription() {
        String shortDescription = "New Short Description";
        Item item = new Item();
        item.setShortDescription(shortDescription);
        assertEquals(shortDescription, item.getShortDescription(), "Short description should be set correctly");
    }

    @Test
    void testSetImage() {
        String imageUrl = "new_image_url";
        Item item = new Item();
        item.setImage(imageUrl);
        assertEquals(imageUrl, item.getImage(), "Image URL should be set correctly");
    }

}
package com.malkinfo.rentalapp;

/**
 * The UserClass represents a user in the rental app.
 * It contains information about the user's name, email, username, password, and profile image.
 */
public class UserClass {

    private String name;
    private String email;
    private String password;
    private String username;
    private String image;

    /**
     * Constructs a new UserClass with the specified name, email, username, and password.
     *
     * @param name     the name of the user
     * @param email    the email of the user
     * @param username the username of the user
     * @param password the password of the user
     */
    public UserClass(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    /**
     * Default constructor.
     */
    public UserClass() {
    }

    /**
     * Returns the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the new name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the new email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the new password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the username of the user.
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the new username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the profile image of the user.
     *
     * @return the profile image of the user
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the profile image of the user.
     *
     * @param image the new profile image of the user
     */
    public void setImage(String image) {
        this.image = image;
    }
}

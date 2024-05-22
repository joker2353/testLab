package com.malkinfo.rentalapp;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Singleton class for managing the Firebase Database instance.
 */
public class Firebase {

    private static FirebaseDatabase database;

    // Private constructor to prevent instantiation
    private Firebase() {
    }

    /**
     * Get the Firebase Database instance.
     *
     * @return The Firebase Database instance
     */
    public static FirebaseDatabase getFirebase() {
        if (database == null) {
            database = FirebaseDatabase.getInstance();
        }
        return database;
    }
}

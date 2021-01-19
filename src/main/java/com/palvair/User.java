package com.palvair;

public record User(String firstname, String lastname) {

    public User {
        if (firstname == null) {
            throw new NullPointerException();
        }
    }

    public String getName() {
        return firstname + "-" + lastname;
    }

    public static User unknown() {
        return new User("John", "Doe");
    }
}

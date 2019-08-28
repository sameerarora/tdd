package com.xyz.training.legacy;

public class UserSession {

    public static UserSession getInstance() {
        return new UserSession();
    }

    public User getLoggedInUser() {
        throw new DependentClassInvokedException();
    }
}

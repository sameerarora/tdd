package com.xyz.training.legacy;

public class DependentClassInvokedException extends RuntimeException {
    public DependentClassInvokedException(String message) {
        super(message);
    }

    public DependentClassInvokedException() {
        this("You are not allowed to invoke code from dependencies");
    }
}

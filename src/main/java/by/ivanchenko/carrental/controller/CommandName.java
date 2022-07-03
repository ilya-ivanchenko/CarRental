package by.ivanchenko.carrental.controller;

public enum CommandName {
    REGISTRATION("registration");
        // another
    String name;
    CommandName(String name) {
        this.name = name;
    }
}

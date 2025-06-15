package com.activation.integral.app.UI.model;

public enum Unit {
    MM("мм"),
    SM("см");

    private final String displayName;

    Unit(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

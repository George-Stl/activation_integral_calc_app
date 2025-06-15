package com.activation.integral.app.UI.model;

public enum ModelElement {
    ALUMINIUM("Алюминий"),
    INDIUM("Индий"),
    FLUOROPLAST("Фторопласт");

    private final String displayName;

    ModelElement(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

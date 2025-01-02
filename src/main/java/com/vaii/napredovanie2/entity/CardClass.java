package com.vaii.napredovanie2.entity;

public enum CardClass {
    card_bg_skauti("Skauti/Rangeri"),
    card_bg_vlcata("Vĺčatá"),
    card_bg_roveri("Roveri");

    private final String displayName;

    CardClass(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
package com.xiaomi.smarthome.newui.card;

public enum State {
    NOR("normal"),
    SELECTED("selected"),
    UNABLE("unable");
    
    String desc;

    private State(String str) {
        this.desc = str;
    }

    public final String toString() {
        return this.desc;
    }
}

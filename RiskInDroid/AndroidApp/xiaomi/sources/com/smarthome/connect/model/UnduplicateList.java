package com.smarthome.connect.model;

import java.util.ArrayList;

public class UnduplicateList<String> extends ArrayList<String> {
    public boolean add(String string) {
        return contains(string) || super.add(string);
    }
}

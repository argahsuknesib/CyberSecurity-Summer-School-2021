package com.payu.sdk;

import java.util.HashMap;

public class Params extends HashMap<String, String> {
    public String get(String str) {
        String str2 = (String) super.get((Object) str);
        return str2 == null ? "" : str2;
    }
}

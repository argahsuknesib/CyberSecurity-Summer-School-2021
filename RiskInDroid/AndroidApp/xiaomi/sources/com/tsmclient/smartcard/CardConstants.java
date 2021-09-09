package com.tsmclient.smartcard;

import java.util.HashMap;
import java.util.Map;

public class CardConstants {
    public static Map<String, Integer> sCurrencyCodeMap;

    static {
        HashMap hashMap = new HashMap();
        sCurrencyCodeMap = hashMap;
        hashMap.put("0156", 1);
        sCurrencyCodeMap.put("0344", 2);
        sCurrencyCodeMap.put("0356", 3);
        sCurrencyCodeMap.put("0392", 4);
        sCurrencyCodeMap.put("0410", 5);
        sCurrencyCodeMap.put("0446", 6);
        sCurrencyCodeMap.put("0702", 7);
        sCurrencyCodeMap.put("0458", 8);
        sCurrencyCodeMap.put("0840", 9);
        sCurrencyCodeMap.put("0901", 10);
    }

    private CardConstants() {
    }
}

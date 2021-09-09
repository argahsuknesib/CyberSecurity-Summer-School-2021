package com.tsmclient.smartcard;

import android.content.Context;
import android.nfc.tech.IsoDep;
import com.tsmclient.smartcard.handler.BMACCardHandler;
import com.tsmclient.smartcard.handler.CityUCardHandler;
import com.tsmclient.smartcard.handler.ISmartCardHandler;
import com.tsmclient.smartcard.handler.LingNanCardHandler;
import com.tsmclient.smartcard.handler.SZTCardHandler;
import com.tsmclient.smartcard.handler.WHTCardHandler;

public class ReaderUtil {
    public static String invertString(String str, int i) {
        char[] charArray = str.toCharArray();
        int length = str.length();
        int i2 = 0;
        while (i2 < length / 2) {
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i2 + i3;
                char c = charArray[i4];
                int i5 = ((length - i) - i2) + i3;
                charArray[i4] = charArray[i5];
                charArray[i5] = c;
            }
            i2 += i;
        }
        return new String(charArray);
    }

    public static String getFromSharedPrefs(Context context, String str) {
        return context.getSharedPreferences("nfc_read_card", 0).getString(str, null);
    }

    public static ISmartCardHandler<IsoDep> getHandlerById(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("BMAC")) {
            return new BMACCardHandler();
        }
        if (str.equals("SZT")) {
            return new SZTCardHandler();
        }
        if (str.equals("WHT")) {
            return new WHTCardHandler();
        }
        if (str.equals("LNT")) {
            return new LingNanCardHandler();
        }
        return new CityUCardHandler(str);
    }
}

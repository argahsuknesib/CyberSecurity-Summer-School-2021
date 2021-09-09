package com.mobikwik.sdk.lib.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

public class CardUtils {
    public static String detectType(String str) {
        int i = 0;
        int parseInt = str.length() > 0 ? Integer.parseInt(str.substring(0, 1)) : 0;
        int parseInt2 = str.length() > 1 ? Integer.parseInt(str.substring(0, 2)) : 0;
        int parseInt3 = str.length() > 3 ? Integer.parseInt(str.substring(0, 4)) : 0;
        if (str.length() > 5) {
            i = Integer.parseInt(str.substring(0, 6));
        }
        return parseInt == 4 ? "visa" : (parseInt2 < 51 || parseInt2 > 55) ? (parseInt2 == 34 || parseInt2 == 37 || parseInt3 == 3528 || parseInt3 == 3589) ? "amex" : (i < 300000 || i > 305999) ? (i < 309500 || i > 309599) ? (i < 360000 || i > 369999) ? (i < 380000 || i > 389999) ? (i < 601100 || i > 601109) ? (i < 601120 || i > 601149) ? (i < 601174 || i > 601174) ? (i < 601177 || i > 601179) ? (i < 601186 || i > 601199) ? (i < 644000 || i > 659999) ? (i < 508500 || i > 508999) ? (i < 606985 || i > 607384) ? (i < 607385 || i > 607484) ? (i < 607485 || i > 607984) ? (i < 608001 || i > 608100) ? (i < 608101 || i > 608200) ? (i < 608201 || i > 608300) ? (i < 608301 || i > 608350) ? (i < 608351 || i > 608500) ? (i < 652150 || i > 652849) ? (i < 652850 || i > 653049) ? (i < 653050 || i > 653149) ? (str.matches("(508125|508126|508159|508192|508227|504437|504681|5018|5020|5038|5612|5893|6304|6759|6761|6762|6763|0604|6390|50|63|66|5[6-8]|6[8-9]|600[0-9]|6010|601[2-9]|60[2-9]|61|620|621|6220|6221[0-1])([0-9]*)") || str.length() > 16) ? "maestro" : "Unsupported Card" : "rupay" : "rupay" : "rupay" : "rupay" : "rupay" : "rupay" : "rupay" : "rupay" : "rupay" : "rupay" : "rupay" : "rupay" : "discover" : "discover" : "discover" : "discover" : "discover" : "discover" : "diners" : "diners" : "diners" : "diners" : "mastercard";
    }

    static String encryptField(String str, String str2) {
        String str3 = "";
        for (int i = 0; i < str.length(); i++) {
            str3 = str3 + (str.charAt(i) + str2.charAt(i % str2.length())) + ",";
        }
        return str3;
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            String str = nextElement.getHostAddress().toString();
                            Utils.print("IP : ".concat(String.valueOf(str)));
                            return str;
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean validateCardNumber(String str) {
        int i = 0;
        boolean z = false;
        for (int length = str.length() - 1; length >= 0; length--) {
            int parseInt = Integer.parseInt(str.substring(length, length + 1));
            if (z && (parseInt = parseInt * 2) > 9) {
                parseInt = (parseInt % 10) + 1;
            }
            i += parseInt;
            z = !z;
        }
        return i % 10 == 0;
    }
}

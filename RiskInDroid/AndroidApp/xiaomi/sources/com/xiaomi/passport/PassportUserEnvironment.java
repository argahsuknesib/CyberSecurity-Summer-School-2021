package com.xiaomi.passport;

import android.annotation.SuppressLint;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.hasheddeviceidlib.HardwareInfo;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.CloudCoder;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class PassportUserEnvironment {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final PassportUserEnvironment f6190O000000o;
        private static PassportUserEnvironment O00000Oo;

        static {
            PassportUserEnvironment passportUserEnvironment = new PassportUserEnvironment();
            f6190O000000o = passportUserEnvironment;
            O00000Oo = passportUserEnvironment;
        }

        public static void O000000o(PassportUserEnvironment passportUserEnvironment) {
            O00000Oo = passportUserEnvironment;
        }

        public static PassportUserEnvironment O000000o() {
            return O00000Oo;
        }
    }

    public enum TelePhonyInfo {
        SUBSCRIBE_ID("getSubscriberIdForSlot"),
        SERIAL_NUMBER("getSimSerialNumberForSlot"),
        OPERATOR("getSimOperatorForSlot"),
        DEVICE_ID_LIST("getDeviceIdList");
        
        String methodToGetValue;

        private TelePhonyInfo(String str) {
            this.methodToGetValue = str;
        }
    }

    private static String O000000o() {
        Application applicationContext = XMPassportSettings.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        try {
            WifiManager wifiManager = (WifiManager) applicationContext.getSystemService("wifi");
            if (wifiManager.getConnectionInfo() != null) {
                return wifiManager.getConnectionInfo().getSSID();
            }
            return null;
        } catch (SecurityException e) {
            AccountLog.i("PassportUserEnvironment", "failed to get SSID with SecurityException " + e.getMessage());
            return null;
        }
    }

    private static List<String> O00000Oo() {
        Application applicationContext = XMPassportSettings.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        try {
            List<WifiConfiguration> configuredNetworks = ((WifiManager) applicationContext.getSystemService("wifi")).getConfiguredNetworks();
            if (configuredNetworks == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(configuredNetworks.size());
            for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                arrayList.add(wifiConfiguration.SSID);
            }
            return arrayList;
        } catch (SecurityException e) {
            AccountLog.i("PassportUserEnvironment", "failed to get configuredSSIDs with SecurityException " + e.getMessage());
            return null;
        }
    }

    private static String O00000Oo(Application application) {
        if (application == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) application.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getBSSID();
            }
        } catch (SecurityException e) {
            AccountLog.i("PassportUserEnvironment", "failed to get BSSID with SecurityException " + e.getMessage());
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private static int O00000o0(Application application) {
        if (application == null) {
            return -1;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) application.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType();
            }
        } catch (SecurityException e) {
            AccountLog.i("PassportUserEnvironment", "failed to getNetWorkType with SecurityException " + e.getMessage());
        }
        return -1;
    }

    private static String O00000o0() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                return defaultAdapter.getName();
            }
            return null;
        } catch (SecurityException e) {
            AccountLog.i("PassportUserEnvironment", "failed to get bluetooth id with SecurityException " + e.getMessage());
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static List<String> O000000o(Application application, TelePhonyInfo telePhonyInfo) {
        if (application == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) application.getSystemService("phone");
            ArrayList arrayList = new ArrayList();
            int i = AnonymousClass1.f6189O000000o[telePhonyInfo.ordinal()];
            if (i == 1) {
                arrayList.add(telephonyManager.getSimOperator());
            } else if (i == 2) {
                arrayList.add(telephonyManager.getSimSerialNumber());
            } else if (i == 3) {
                arrayList.add(telephonyManager.getSubscriberId());
            } else if (i == 4) {
                arrayList.add(telephonyManager.getDeviceId());
            } else {
                throw new IllegalStateException("not here");
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (SecurityException e) {
            AccountLog.i("PassportUserEnvironment", "failed to get SubscriberId with SecurityException " + e.getMessage());
            return null;
        }
    }

    /* renamed from: com.xiaomi.passport.PassportUserEnvironment$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f6189O000000o = new int[TelePhonyInfo.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f6189O000000o[TelePhonyInfo.OPERATOR.ordinal()] = 1;
            f6189O000000o[TelePhonyInfo.SERIAL_NUMBER.ordinal()] = 2;
            f6189O000000o[TelePhonyInfo.SUBSCRIBE_ID.ordinal()] = 3;
            try {
                f6189O000000o[TelePhonyInfo.DEVICE_ID_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private List<String> O000000o(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String O000000o2 : list) {
            arrayList.add(O000000o(O000000o2));
        }
        return arrayList;
    }

    private static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String hash4SHA1 = CloudCoder.hash4SHA1(str);
        if (6 > hash4SHA1.length()) {
            return hash4SHA1;
        }
        return hash4SHA1.substring(0, 6);
    }

    private static List<String> O00000Oo(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String O00000Oo : list) {
            arrayList.add(O00000Oo(O00000Oo));
        }
        return arrayList;
    }

    private static String O00000Oo(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Base64.encodeToString(str.getBytes("utf-8"), 10);
        } catch (UnsupportedEncodingException e) {
            AccountLog.e("PassportUserEnvironment", "base64 failed: ", e);
            return null;
        }
    }

    public final String[] O000000o(Application application) {
        String str;
        Application application2 = application;
        String O000000o2 = O000000o(O000000o());
        String O000000o3 = O000000o(O00000Oo(application));
        List<String> O00000Oo = O00000Oo();
        if (O00000Oo != null && O00000Oo.size() > 50) {
            O00000Oo = O00000Oo.subList(0, 50);
        }
        List<String> O000000o4 = O000000o(O00000Oo);
        String O00000Oo2 = O00000Oo(String.valueOf(O00000o0(application)));
        String O00000Oo3 = O00000Oo(Build.MODEL);
        String O00000Oo4 = O00000Oo(Build.SERIAL);
        if (application2 == null) {
            str = null;
        } else {
            str = Settings.Secure.getString(application.getContentResolver(), "android_id");
        }
        String O000000o5 = O000000o(str);
        List<String> O000000o6 = O000000o(O000000o(application2, TelePhonyInfo.DEVICE_ID_LIST));
        String O000000o7 = O000000o(HardwareInfo.getBluetoothMacAddress(application));
        String O000000o8 = O000000o(HardwareInfo.getWifiMacAddress(application));
        List<String> O00000Oo5 = O00000Oo(O000000o(application2, TelePhonyInfo.SUBSCRIBE_ID));
        List<String> O00000Oo6 = O00000Oo(O000000o(application2, TelePhonyInfo.SERIAL_NUMBER));
        List<String> O00000Oo7 = O00000Oo((List<String>) null);
        List<String> O00000Oo8 = O00000Oo(O000000o(application2, TelePhonyInfo.OPERATOR));
        List<String> O000000o9 = O000000o((List<String>) null);
        String O00000Oo9 = O00000Oo(O00000o0());
        LinkedList linkedList = new LinkedList();
        linkedList.add(O000000o2);
        linkedList.add(O000000o3);
        linkedList.add(O000000o4);
        linkedList.add(O00000Oo2);
        linkedList.add(O00000Oo3);
        linkedList.add(O00000Oo4);
        linkedList.add(O000000o5);
        linkedList.add(O000000o6);
        linkedList.add(O000000o7);
        linkedList.add(O000000o8);
        linkedList.add(O00000Oo5);
        linkedList.add(O00000Oo6);
        linkedList.add(O00000Oo7);
        linkedList.add(O00000Oo8);
        linkedList.add(O000000o9);
        linkedList.add(O00000Oo9);
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String str2 = "";
            if (next != null) {
                if (next instanceof List) {
                    List list = (List) next;
                    if (!(list == null || list.size() == 0)) {
                        str2 = TextUtils.join("#", list);
                    }
                } else if (next instanceof String) {
                    str2 = (String) next;
                } else {
                    throw new IllegalStateException("not here");
                }
            }
            arrayList.add(str2);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}

package com.mi.global.shop.buy.payu;

import _m_j.bzi;
import _m_j.bzn;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.payu.sdk.Params;
import com.payu.sdk.Payment;
import com.payu.sdk.exceptions.HashException;
import com.payu.sdk.exceptions.MissingParameterException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class PayU {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f4867O000000o;
    public static JSONObject O00000Oo;
    public static JSONObject O00000o;
    public static JSONObject O00000o0;
    public static List<bzn> O00000oO;
    public static JSONObject O00000oo;
    public static ArrayList<bzi.O00000Oo> O0000O0o = new ArrayList<>();
    public static String O0000OOo;
    public static String O0000Oo;
    public static String O0000Oo0;
    public static String O0000OoO;
    public static PaymentMode[] O0000Ooo = null;
    public static Set<String> O0000o0 = new HashSet();
    public static boolean O0000o00 = false;
    static final Map<PaymentMode, String> O0000o0O;
    private static PayU O0000o0o;
    private static final String[] O0000oO = {"ccnum", "ccexpmon", "ccexpyr", "ccname"};
    private static final String[] O0000oOO = {"ccvv"};
    private static final String[] O0000oOo = {"bankcode"};
    private Activity O0000o;
    private String O0000oO0 = null;

    public enum PaymentMode {
        CC,
        DC,
        NB,
        EMI,
        PAYU_MONEY,
        STORED_CARDS,
        CASH,
        UPI
    }

    static {
        HashMap hashMap = new HashMap();
        O0000o0O = hashMap;
        hashMap.put(PaymentMode.CC, "Credit Card");
        O0000o0O.put(PaymentMode.DC, "Debit Card");
        O0000o0O.put(PaymentMode.NB, "Net Banking");
        O0000o0O.put(PaymentMode.EMI, "EMI");
        O0000o0O.put(PaymentMode.PAYU_MONEY, "PayUMoney");
        O0000o0O.put(PaymentMode.STORED_CARDS, "Stored Cards");
        O0000o0O.put(PaymentMode.CASH, "Cash Card");
    }

    private PayU(Activity activity) {
        this.O0000o = activity;
    }

    public static synchronized PayU O000000o(Activity activity) {
        PayU payU;
        synchronized (PayU.class) {
            O0000o0o = null;
            try {
                Bundle bundle = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
                O0000o0o = new PayU(activity);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("PayU", "Failed to load meta-data, NameNotFound: " + e.getMessage());
            } catch (NullPointerException e2) {
                Log.e("PayU", "Failed to load meta-data, NullPointer: " + e2.getMessage());
            }
            payU = O0000o0o;
        }
        return payU;
    }

    public static Intent O000000o(double d, HashMap<String, String> hashMap, PaymentMode[] paymentModeArr) {
        Intent intent = new Intent();
        intent.putExtra("amount", d);
        if (hashMap == null) {
            return intent;
        }
        for (String next : hashMap.keySet()) {
            intent.putExtra(next, hashMap.get(next));
        }
        intent.putExtra("key", f4867O000000o);
        if (hashMap.containsKey("drop_category")) {
            O0000OOo = hashMap.get("drop_category").replaceAll("\\s+", "");
        }
        if (hashMap.containsKey("enforce_paymethod")) {
            O0000Oo0 = hashMap.get("enforce_paymethod");
        }
        if (hashMap.containsKey("user_credentials")) {
            O0000Oo = hashMap.get("user_credentials");
        }
        int[] iArr = new int[5];
        int i = 0;
        int i2 = 0;
        while (i < 5) {
            iArr[i2] = paymentModeArr[i].ordinal();
            i++;
            i2++;
        }
        intent.putExtra("payment_options", iArr);
        return intent;
    }

    public final String O000000o(Payment payment, Params params) throws MissingParameterException, HashException {
        params.put("pg", payment.getMode().toString());
        params.put("device_type", "1");
        params.put("instrument_id", Settings.Secure.getString(this.O0000o.getContentResolver(), "android_id"));
        params.put("instrument_type", "Manufacturer: " + Build.MANUFACTURER + " Model: " + Build.MODEL + "  Product: " + Build.PRODUCT);
        int i = AnonymousClass1.f4868O000000o[payment.getMode().ordinal()];
        if (i == 1) {
            params.put("bankcode", "CC");
            O000000o(O0000oOO, params);
            if (params.get("store_card_token").length() <= 1) {
                if (params.get("ccvv").length() < 3) {
                    params.put("ccvv", "123");
                    params.put("ccexpmon", "12");
                    params.put("ccexpyr", "2090");
                } else {
                    O000000o(O0000oO, params);
                }
            }
        } else if (i == 2) {
            O000000o(O0000oOo, params);
        } else if (i == 3) {
            params.put("bankcode", "payuw");
            params.put("pg", "wallet");
        } else if (i == 4) {
            O000000o(O0000oO, params);
            O000000o(O0000oOO, params);
        } else if (i == 5) {
            params.put("pg", "UPI");
            params.put("enforce_paymethod", params.get("bankcode"));
        }
        new StringBuffer();
        try {
            String str = "";
            for (String str2 : params.keySet()) {
                if (!str2.contentEquals("surl")) {
                    if (!str2.contentEquals("furl")) {
                        if (str2.contentEquals("amount")) {
                            DecimalFormat decimalFormat = new DecimalFormat("#.00");
                            str = str + str2 + "=" + decimalFormat.format(Double.valueOf(params.get(str2))) + "&";
                        } else {
                            str = str + str2 + "=" + params.get(str2) + "&";
                        }
                    }
                }
                str = str + str2 + "=" + URLEncoder.encode(params.get(str2), "UTF-8") + "&";
            }
            return str + "hash=" + O0000OoO;
        } catch (NoSuchAlgorithmException unused) {
            throw new HashException();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: com.mi.global.shop.buy.payu.PayU$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f4868O000000o = new int[PaymentMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f4868O000000o[PaymentMode.CC.ordinal()] = 1;
            f4868O000000o[PaymentMode.NB.ordinal()] = 2;
            f4868O000000o[PaymentMode.PAYU_MONEY.ordinal()] = 3;
            f4868O000000o[PaymentMode.EMI.ordinal()] = 4;
            f4868O000000o[PaymentMode.UPI.ordinal()] = 5;
        }
    }

    private static void O000000o(String[] strArr, Params params) throws MissingParameterException {
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            if (params.containsKey(str)) {
                i++;
            } else {
                throw new MissingParameterException("Parameter " + str + " is missing");
            }
        }
        if (O0000OoO == null) {
            throw new MissingParameterException("Parameter Hash is missing");
        }
    }
}

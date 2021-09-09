package _m_j;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.buy.payu.PayU;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.pay.payparam.NewPayGoResult;
import com.mi.multimonitor.CrashReport;
import com.payu.sdk.Params;
import com.payu.sdk.Payment;
import com.payu.sdk.ProcessPaymentActivity;
import com.payu.sdk.exceptions.HashException;
import com.payu.sdk.exceptions.MissingParameterException;
import com.xiaomi.smarthome.R;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class bzt {
    public static void O000000o(String str, String str2, String str3, ConfirmActivity confirmActivity, PayU.PaymentMode paymentMode, Params params, String str4, String str5, String str6, String str7, String str8) {
        Request request;
        Uri.Builder buildUpon = Uri.parse(cav.O000Oooo()).buildUpon();
        buildUpon.appendQueryParameter("id", str);
        buildUpon.appendQueryParameter("bank", str2);
        buildUpon.appendQueryParameter("type", str3);
        if (!TextUtils.isEmpty(str5)) {
            buildUpon.appendQueryParameter("emibank", str5);
        }
        String str9 = params.get("bankcode");
        if (!TextUtils.isEmpty(str9)) {
            buildUpon.appendQueryParameter("bankcode", str9);
        }
        if (!TextUtils.isEmpty(str6)) {
            buildUpon.appendQueryParameter("terms", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            buildUpon.appendQueryParameter("pg", str7);
        }
        if (!TextUtils.isEmpty(str8)) {
            buildUpon.appendQueryParameter("vpa", str8);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("checkcode", O00000o0(str4));
        final ConfirmActivity confirmActivity2 = confirmActivity;
        final String str10 = str3;
        final PayU.PaymentMode paymentMode2 = paymentMode;
        final Params params2 = params;
        final String str11 = str;
        final String str12 = str2;
        final String str13 = str4;
        final String str14 = str5;
        final String str15 = str6;
        final String str16 = str7;
        final String str17 = str8;
        AnonymousClass1 r2 = new cak<NewPayGoResult>() {
            /* class _m_j.bzt.AnonymousClass1 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                JSONObject jSONObject;
                NewPayGoResult newPayGoResult = (NewPayGoResult) baseResult;
                confirmActivity2.hideLoading();
                if (newPayGoResult.data != null) {
                    ConfirmActivity confirmActivity = confirmActivity2;
                    String str = newPayGoResult.data.params;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            jSONObject = new JSONObject(str);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            if (!cad.O0000o0()) {
                                CrashReport.postCrash(Thread.currentThread(), e);
                            }
                            bzt.O000000o("");
                            jSONObject = null;
                        }
                        if (jSONObject != null) {
                            Iterator<String> keys = jSONObject.keys();
                            HashMap hashMap = new HashMap();
                            PayU.O0000OoO = null;
                            while (keys.hasNext()) {
                                String obj = keys.next().toString();
                                try {
                                    if (obj.equals("hash")) {
                                        PayU.O0000OoO = jSONObject.getString("hash");
                                    } else if (obj.equals("supportStoreCards")) {
                                        PayU.O0000o00 = Boolean.parseBoolean(jSONObject.getString("supportStoreCards"));
                                    } else if (obj.equals("key")) {
                                        PayU.f4867O000000o = jSONObject.getString("key");
                                    }
                                    hashMap.put(obj, jSONObject.getString(obj));
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            confirmActivity.setpayParam(hashMap);
                        }
                    }
                    if (!"tezapp".equalsIgnoreCase(str10)) {
                        bzt.O000000o(confirmActivity2, paymentMode2, params2);
                    } else if (TextUtils.isEmpty(newPayGoResult.data.ext)) {
                        bzt.O000000o(str11, str12, "upi", confirmActivity2, paymentMode2, params2, str13, str14, str15, str16, str17);
                    } else {
                        ConfirmActivity confirmActivity2 = confirmActivity2;
                        try {
                            JSONObject jSONObject2 = new JSONObject(newPayGoResult.data.ext);
                            jSONObject2.optString("type");
                            String optString = jSONObject2.optString("mcc");
                            String optString2 = jSONObject2.optString("payeeVpa");
                            String optString3 = jSONObject2.optString("payeeName");
                            jSONObject2.optString("tokenType");
                            jSONObject2.optString("totalPriceStatus");
                            jSONObject2.optString("currencyCode");
                            if (confirmActivity2 != null && confirmActivity2.getpayParam() != null) {
                                String str2 = confirmActivity2.getpayParam().get("referenceId");
                                bze bze = new bze();
                                StringBuilder sb = new StringBuilder();
                                sb.append(confirmActivity2.getAmount());
                                String O000000o2 = bze.O000000o(str2, sb.toString(), optString, optString2, optString3, confirmActivity2.getpayParam().get("txnid"));
                                bze.O00000o0 = confirmActivity2;
                                try {
                                    Log.d(bze.O00000Oo, O000000o2);
                                    bze.f13456O000000o.loadPaymentData(bze.O00000o0, O000000o2, 258);
                                } catch (NoSuchAlgorithmException e3) {
                                    e3.printStackTrace();
                                    Log.e(bze.O00000Oo, "Unable to check Tez signature.", e3);
                                    Toast.makeText(bze.O00000o0, "An error has occurred within the Tez SDK. Please check the log for more details.", 0).show();
                                }
                            }
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                            if (!cad.O0000o0()) {
                                CrashReport.postCrash(Thread.currentThread(), e4);
                            }
                            bzt.O000000o("");
                        }
                    }
                }
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                ccr.O00000Oo("PayUtil", "getOrderViewInfo Exception:".concat(String.valueOf(str)));
                confirmActivity2.hideLoading();
                bzt.O000000o(str);
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(buildUpon.toString(), NewPayGoResult.class, cbh.O000000o(hashMap), r2);
        } else {
            request = new cal(buildUpon.toString(), NewPayGoResult.class, cbh.O000000o(hashMap), r2);
        }
        request.setTag("PayUtil");
        ced.f13683O000000o.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(15000, 0, 1.0f));
        confirmActivity.showLoading();
    }

    public static void O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            cec.O000000o(byl.O00000oO(), (int) R.string.buy_confirm_order_payfailed, 1);
        } else {
            cec.O000000o(byl.O00000oO(), str, 1);
        }
    }

    public static void O000000o(ConfirmActivity confirmActivity, PayU.PaymentMode paymentMode, Params params) {
        try {
            Intent paymentIntent = confirmActivity.getPaymentIntent();
            Payment payment = new Payment();
            payment.getClass();
            Payment.Builder builder = new Payment.Builder();
            builder.set("mode", String.valueOf(paymentMode));
            for (String next : paymentIntent.getExtras().keySet()) {
                builder.set(next, String.valueOf(paymentIntent.getExtras().get(next)));
                params.put(next, builder.get(next));
            }
            String O000000o2 = PayU.O000000o(confirmActivity).O000000o(builder.create(), params);
            Intent intent = new Intent(confirmActivity, ProcessPaymentActivity.class);
            intent.putExtra("postData", O000000o2);
            intent.addFlags(67108864);
            confirmActivity.startActivityForResult(intent, 100);
        } catch (MissingParameterException e) {
            e.printStackTrace();
        } catch (HashException e2) {
            e2.printStackTrace();
        }
    }

    public static String O00000Oo(String str) {
        DecimalFormat decimalFormat;
        if (cad.O00000o()) {
            decimalFormat = new DecimalFormat(",###");
        } else if (cad.O0000O0o()) {
            decimalFormat = new DecimalFormat(".###");
        } else {
            decimalFormat = new DecimalFormat(",###");
        }
        try {
            return decimalFormat.format(Double.parseDouble(str));
        } catch (Exception e) {
            ccr.O00000Oo("PayUtil", "format " + str + " failed:" + e.toString());
            return "";
        }
    }

    private static String O00000o0(String str) {
        try {
            return cbm.O00000Oo(ccn.O0000o00().O00000Oo() + "_card_" + str);
        } catch (Exception unused) {
            return "";
        }
    }
}

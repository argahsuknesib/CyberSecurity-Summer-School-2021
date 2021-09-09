package _m_j;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.apps.nbu.paisa.inapp.client.api.PaymentsClient;
import com.google.android.apps.nbu.paisa.inapp.client.api.Wallet;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bze {
    public static final String O00000Oo = "bze";

    /* renamed from: O000000o  reason: collision with root package name */
    public PaymentsClient f13456O000000o = Wallet.getPaymentsClient();
    public Activity O00000o0;

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    public final boolean O000000o() throws PackageManager.NameNotFoundException {
        try {
            return Wallet.getPaymentsClient().isGooglePayInstalled(this.O00000o0, 2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String O000000o(String str, String str2, String str3, String str4, String str5, String str6) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("currencyCode", "INR");
        jSONObject.put("totalPriceStatus", "FINAL");
        jSONObject.put("totalPrice", str2);
        if (!TextUtils.isEmpty("")) {
            jSONObject.put("transactionNote", "");
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("payeeVpa", str4);
        jSONObject2.put("payeeName", str5);
        jSONObject2.put("transactionReferenceId", str);
        jSONObject2.put("mcc", str3);
        if (!TextUtils.isEmpty("")) {
            jSONObject2.put("referenceUrl", "");
        }
        if (!TextUtils.isEmpty(str6)) {
            jSONObject2.put("transactionId", str6);
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("type", "DIRECT");
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("type", "UPI");
        jSONObject4.put("parameters", jSONObject2);
        jSONObject4.put("tokenizationSpecification", jSONObject3);
        List asList = Arrays.asList(jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("apiVersion", 2);
        jSONObject5.put("apiVersionMinor", 0);
        jSONObject5.put("transactionInfo", jSONObject);
        jSONObject5.put("allowedPaymentMethods", new JSONArray((Collection<?>) asList));
        return jSONObject5.toString();
    }
}

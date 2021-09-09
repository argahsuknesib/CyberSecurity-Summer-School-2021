package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.CookieManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fuc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f17154O000000o = null;
    public static Random O00000Oo = null;
    public static String O00000o0 = "a2ffa5c9be07488bbb04a3a47d3c5f6a";
    private static volatile fuc O00000oO;
    private static final Object O00000oo = new Object();
    public OkHttpClient O00000o = gse.O000000o();
    private OkHttpClient O0000O0o;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f17161O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f17162O000000o;
        public String O00000Oo;
    }

    public fuc() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        this.O0000O0o = builder.dispatcher(new Dispatcher(goq.O000000o())).connectTimeout(4, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).cookieJar(new JavaNetCookieJar(new CookieManager())).build();
    }

    public static fuc O000000o() {
        if (O00000oO == null) {
            synchronized (O00000oo) {
                if (O00000oO == null) {
                    O00000oO = new fuc();
                }
            }
        }
        return O00000oO;
    }

    public static String O000000o(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(O00000Oo(str));
            return String.format("%1$040x", new BigInteger(1, instance.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] O00000Oo(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static String O00000Oo() {
        DhcpInfo dhcpInfo;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1 || (dhcpInfo = ((WifiManager) CommonApplication.getAppContext().getApplicationContext().getSystemService("wifi")).getDhcpInfo()) == null) {
            return null;
        }
        return Formatter.formatIpAddress(dhcpInfo.gateway);
    }

    public final fsn O000000o(Context context, ArrayList<String> arrayList, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("dids", jSONArray);
        } catch (JSONException unused) {
        }
        arrayList2.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/get_recommend_list").O000000o(arrayList2).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fuc.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }
}

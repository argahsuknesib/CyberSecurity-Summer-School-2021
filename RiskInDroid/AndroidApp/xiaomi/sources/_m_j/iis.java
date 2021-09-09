package _m_j;

import _m_j.iit;
import android.content.Context;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.model.token.AccessToken;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class iis {
    private static iis O00000oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public AccessToken f1323O000000o;
    public Context O00000Oo;
    public String O00000o;
    iit.O00000Oo O00000o0;
    public String O00000oO;

    private iis() {
    }

    public static iis O000000o() {
        if (O00000oo == null) {
            synchronized (iis.class) {
                if (O00000oo == null) {
                    O00000oo = new iis();
                }
            }
        }
        return O00000oo;
    }

    private static String O0000Oo() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 9; i++) {
            stringBuffer.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(36)));
        }
        return stringBuffer.toString();
    }

    public final void O000000o(Context context) {
        this.O00000Oo = context.getApplicationContext();
        this.O00000o = ilp.O000000o(this.O00000Oo).O00000o0("simple_sso_code");
        this.O00000oO = ilp.O000000o(this.O00000Oo).O00000o0("simple_redirect_uri");
        O0000O0o().O00000oo = ilp.O000000o(this.O00000Oo).O00000o0("xm_thirdUid");
        O0000O0o().O0000O0o = ilp.O000000o(this.O00000Oo).O00000o0("xm_thirdToken");
        if (!ilp.O000000o(this.O00000Oo).O0000O0o("access_token_pref") || !ilp.O000000o(this.O00000Oo).O0000O0o("expire_in_pref")) {
            O00000o0();
            return;
        }
        O0000O0o().f12179O000000o = ilp.O000000o(this.O00000Oo).O00000o0("access_token_pref");
        O0000O0o().O00000Oo = ilp.O000000o(this.O00000Oo).O000000o("expire_in_pref");
        O0000O0o().O00000o = ilp.O000000o(this.O00000Oo).O000000o("current_time_pref");
        O0000O0o().O00000o0 = ilp.O000000o(this.O00000Oo).O00000o0("auth2uid");
        O0000O0o().O00000oO = ilp.O000000o(this.O00000Oo).O00000o0("refresh_token_pref");
        if (!TextUtils.isEmpty(this.f1323O000000o.f12179O000000o)) {
            if (!((System.currentTimeMillis() - this.f1323O000000o.O00000o) / 1000 > this.f1323O000000o.O00000Oo)) {
                return;
            }
        }
        O00000o0();
    }

    public static Map<String, String> O00000Oo() throws XimalayaException {
        HashMap hashMap = new HashMap();
        hashMap.put("client_id", iit.O000000o().O00000Oo());
        hashMap.put("grant_type", "client_credentials");
        hashMap.put("device_id", iit.O000000o().O00000o());
        hashMap.put("nonce", O0000Oo());
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        hashMap.put("timestamp", sb.toString());
        hashMap.put("sig", iji.O000000o(iit.O000000o().O00000Oo, hashMap));
        return hashMap;
    }

    public final void O00000o0() {
        iit.O00000Oo o00000Oo = this.O00000o0;
        boolean O00000Oo2 = o00000Oo != null ? o00000Oo.O00000Oo() : false;
        if (this.O00000o0 != null && !O00000Oo2) {
            O00000oO();
            this.O00000o0.O00000o0();
        } else if (this.O00000o0 == null || !O00000Oo2) {
            O00000oO();
            if (O0000OOo()) {
                O0000OoO();
                return;
            }
            Request.Builder builder = null;
            try {
                O000000o();
                builder = iiy.O00000Oo("http://api.ximalaya.com/oauth2/secure_access_token", O00000Oo());
            } catch (XimalayaException unused) {
            }
            if (builder != null) {
                iiz.O000000o().O000000o(builder.build(), new ijf() {
                    /* class _m_j.iis.AnonymousClass1 */

                    public final void O000000o(int i, String str) {
                    }

                    public final void O000000o(Response response) {
                        if (response.code() == 200) {
                            try {
                                JSONObject jSONObject = new JSONObject(response.body().string());
                                iis.this.O000000o(jSONObject.optString("access_token"), jSONObject.optLong("expires_in"));
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        } else {
                            iis.this.O00000oO();
                        }
                    }
                });
            }
        }
    }

    public final synchronized String O00000o() {
        if (this.f1323O000000o != null) {
            if (!TextUtils.isEmpty(this.f1323O000000o.f12179O000000o)) {
                return this.f1323O000000o.f12179O000000o;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String str, long j) {
        O00000oO();
        if (!TextUtils.isEmpty(str) && j > 0) {
            O0000O0o().f12179O000000o = str;
            O0000O0o().O00000Oo = j;
            long currentTimeMillis = System.currentTimeMillis();
            O0000O0o().O00000o = currentTimeMillis;
            ilp.O000000o(this.O00000Oo).O000000o("access_token_pref", str);
            ilp.O000000o(this.O00000Oo).O000000o("expire_in_pref", j);
            ilp.O000000o(this.O00000Oo).O000000o("current_time_pref", currentTimeMillis);
            ikd.O000000o(this.O00000Oo).O000000o(O0000O0o());
        }
    }

    public final void O000000o(String str, long j, String str2) {
        if (!TextUtils.isEmpty(str) && j > 0 && !TextUtils.isEmpty(str2)) {
            O0000O0o().f12179O000000o = str;
            O0000O0o().O00000Oo = j;
            O0000O0o().O00000o0 = str2;
            O0000O0o().O00000oO = null;
            long currentTimeMillis = System.currentTimeMillis();
            O0000O0o().O00000o = currentTimeMillis;
            ilp.O000000o(this.O00000Oo).O000000o("access_token_pref", str);
            ilp.O000000o(this.O00000Oo).O000000o("expire_in_pref", j);
            ilp.O000000o(this.O00000Oo).O000000o("current_time_pref", currentTimeMillis);
            ilp.O000000o(this.O00000Oo).O000000o("auth2uid", str2);
            ilp.O000000o(this.O00000Oo).O000000o("refresh_token_pref", (String) null);
            ikd.O000000o(this.O00000Oo).O000000o(O0000O0o());
        }
    }

    public final void O000000o(String str, long j, String str2, String str3) {
        ilp.O000000o(this.O00000Oo).O000000o("xm_thirdToken", str3);
        ilp.O000000o(this.O00000Oo).O000000o("xm_thirdUid", str2);
        O0000O0o().O0000O0o = str3;
        O0000O0o().O00000oo = str2;
        O000000o(str, j, str2);
    }

    public final void O00000oO() {
        this.f1323O000000o = null;
        ilp.O000000o(this.O00000Oo).O00000oo("access_token_pref");
        ilp.O000000o(this.O00000Oo).O00000oo("expire_in_pref");
        ilp.O000000o(this.O00000Oo).O00000oo("current_time_pref");
        ilp.O000000o(this.O00000Oo).O00000oo("auth2uid");
        ilp.O000000o(this.O00000Oo).O00000oo("refresh_token_pref");
    }

    public final String O00000oo() {
        AccessToken accessToken = this.f1323O000000o;
        return accessToken != null ? accessToken.O00000o0 : "";
    }

    public final AccessToken O0000O0o() {
        AccessToken accessToken = this.f1323O000000o;
        if (accessToken != null) {
            return accessToken;
        }
        AccessToken accessToken2 = new AccessToken();
        this.f1323O000000o = accessToken2;
        return accessToken2;
    }

    public static boolean O0000OOo() {
        return !TextUtils.isEmpty(O000000o().O0000O0o().O0000O0o) && !TextUtils.isEmpty(O000000o().O0000O0o().O00000oo);
    }

    private static void O0000OoO() {
        HashMap hashMap = new HashMap();
        hashMap.put("grant_type", "token_exchange");
        long currentTimeMillis = System.currentTimeMillis();
        hashMap.put("nonce", imd.O000000o(String.valueOf(currentTimeMillis)));
        hashMap.put("timestamp", String.valueOf(currentTimeMillis));
        hashMap.put("third_uid", O000000o().O0000O0o().O00000oo);
        hashMap.put("third_token", O000000o().O0000O0o().O0000O0o);
        try {
            hashMap.put("client_id", iit.O000000o().O00000Oo());
        } catch (XimalayaException e) {
            e.printStackTrace();
        }
        iit.O00000Oo("http://api.ximalaya.com/oauth2/exchange_access_token", hashMap, new iiw<String>() {
            /* class _m_j.iis.AnonymousClass2 */

            public final void O000000o(int i, String str) {
            }

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                if (str != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        iis.O000000o().O000000o(jSONObject.optString("access_token"), jSONObject.optLong("expires_in"), iis.O000000o().O0000O0o().O00000oo, iis.O000000o().O0000O0o().O0000O0o);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new iit.O000000o<String>() {
            /* class _m_j.iis.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ Object O000000o(String str) throws Exception {
                return str;
            }
        });
    }

    public static void O0000Oo0() throws XimalayaException {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("grant_type", "token_exchange");
            long currentTimeMillis = System.currentTimeMillis();
            hashMap.put("nonce", imd.O000000o(String.valueOf(currentTimeMillis)));
            hashMap.put("timestamp", String.valueOf(currentTimeMillis));
            hashMap.put("third_uid", O000000o().O0000O0o().O00000oo);
            hashMap.put("third_token", O000000o().O0000O0o().O0000O0o);
            try {
                hashMap.put("client_id", iit.O000000o().O00000Oo());
            } catch (XimalayaException e) {
                e.printStackTrace();
            }
            Response response = null;
            try {
                response = iiz.O000000o().O00000Oo(iiy.O00000Oo(iit.O00000Oo("http://api.ximalaya.com/oauth2/exchange_access_token"), iit.O000000o(hashMap), iit.O000000o().O00000Oo).build());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (response == null) {
                throw XimalayaException.getExceptionByCode(1010);
            } else if (new ija(response).f1355O000000o.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string());
                    O000000o().O000000o(jSONObject.optString("access_token"), jSONObject.optLong("expires_in"), O000000o().O0000O0o().O00000oo, O000000o().O0000O0o().O0000O0o);
                } catch (Exception unused) {
                    throw XimalayaException.getExceptionByCode(1009);
                }
            } else {
                throw XimalayaException.getExceptionByCode(1010);
            }
        } catch (Exception unused2) {
            throw XimalayaException.getExceptionByCode(1010);
        }
    }
}

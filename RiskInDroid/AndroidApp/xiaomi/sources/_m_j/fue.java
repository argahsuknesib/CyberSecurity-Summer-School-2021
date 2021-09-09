package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Pair;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public final class fue {
    private static Pair<List<gsi>, String> O0000O0o = Pair.create(null, null);
    private static volatile fue O0000OOo = null;
    private static final Object O0000Oo0 = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    final String f17163O000000o = "/api/xqdatacenter/download";
    protected OkHttpClient O00000Oo = gse.O000000o();
    ArrayList<WeakReference<fsm<Void, fso>>> O00000o = new ArrayList<>();
    boolean O00000o0 = false;
    public String O00000oO = "";
    public O00000Oo O00000oo;
    private String O0000Oo;
    private String O0000OoO;

    public interface O000000o<T> {
        T O000000o(JSONObject jSONObject) throws JSONException;
    }

    private fue() {
    }

    public static fue O000000o() {
        if (O0000OOo == null) {
            synchronized (O0000Oo0) {
                if (O0000OOo == null) {
                    O0000OOo = new fue();
                }
            }
        }
        return O0000OOo;
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        gsy.O000000o(3, "RouterLocalApi", "notifySuccess");
        this.O00000o0 = false;
        Iterator<WeakReference<fsm<Void, fso>>> it = this.O00000o.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            if (!(next == null || next.get() == null)) {
                ((fsm) next.get()).sendSuccessMessage(null);
            }
        }
        this.O00000o.clear();
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        gsy.O000000o(3, "RouterLocalApi", "notifyFail");
        this.O00000o0 = false;
        Iterator<WeakReference<fsm<Void, fso>>> it = this.O00000o.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            if (!(next == null || next.get() == null)) {
                ((fsm) next.get()).sendFailureMessage(new fso(ErrorCode.ERROR_UNKNOWN_ERROR.getCode(), ""));
            }
        }
        this.O00000o.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a3  */
    public final void O000000o(final String str, fsm<Void, fso> fsm) {
        String str2;
        gsy.O000000o(3, "RouterLocalApi", "checkLocalRouterInfo");
        if (this.O00000o0) {
            this.O00000o.add(new WeakReference(fsm));
            return;
        }
        boolean z = true;
        this.O00000o0 = true;
        this.O00000o.add(new WeakReference(fsm));
        O00000Oo o00000Oo = this.O00000oo;
        if (o00000Oo == null || !o00000Oo.O00000o.equals(str)) {
            this.O00000oo = null;
            this.O0000OoO = null;
            this.O0000Oo = null;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                z = false;
            }
            if (z) {
                WifiManager wifiManager = (WifiManager) CommonApplication.getAppContext().getApplicationContext().getSystemService("wifi");
                this.O0000Oo = Formatter.formatIpAddress(wifiManager.getDhcpInfo().gateway);
                this.O0000OoO = "http://" + this.O0000Oo + "/cgi-bin/luci";
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    str2 = connectionInfo.getSSID();
                    if (!TextUtils.isEmpty(str2)) {
                        O00000o0();
                        return;
                    }
                    gsy.O000000o(3, "RouterLocalApi", "simpleHandle");
                    final AnonymousClass1 r0 = new O000000o<O00000Oo>() {
                        /* class _m_j.fue.AnonymousClass1 */

                        public final /* synthetic */ Object O000000o(JSONObject jSONObject) throws JSONException {
                            O00000Oo o00000Oo = new O00000Oo();
                            o00000Oo.f17168O000000o = jSONObject.getInt("inited");
                            o00000Oo.O00000Oo = jSONObject.getInt("bound");
                            o00000Oo.O00000o0 = jSONObject.getString("id");
                            o00000Oo.O00000o = jSONObject.optString("routerId");
                            o00000Oo.O00000oO = jSONObject.optString("hardware", "R1D");
                            return o00000Oo;
                        }
                    };
                    final AnonymousClass2 r1 = new fsm<O00000Oo, fso>() {
                        /* class _m_j.fue.AnonymousClass2 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, boolean, _m_j.fss, _m_j.fsm):_m_j.fsn
                         arg types: [android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, int, _m_j.fuf$1, _m_j.fue$2$1]
                         candidates:
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm, boolean):_m_j.fsn
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, int, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, boolean, _m_j.fss, _m_j.fsm):_m_j.fsn */
                        public final /* synthetic */ void onSuccess(Object obj) {
                            O00000Oo o00000Oo = (O00000Oo) obj;
                            if (o00000Oo == null || !str.equals(o00000Oo.O00000o)) {
                                fue.this.O00000o0();
                                return;
                            }
                            fue.this.O00000oo = o00000Oo;
                            fuf O000000o2 = fuf.O000000o();
                            Context appContext = CommonApplication.getAppContext();
                            String str = str;
                            AnonymousClass1 r6 = new fsm<String, fso>() {
                                /* class _m_j.fue.AnonymousClass2.AnonymousClass1 */

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    fue.this.O00000oO = (String) obj;
                                    fue.this.O00000Oo();
                                }

                                public final void onFailure(fso fso) {
                                    fue.this.O00000o0();
                                }
                            };
                            CoreApi.O000000o().O000000o(appContext, new NetRequest.O000000o().O000000o("GET").O00000Oo("/api/xqsystem/renew_token").O000000o(new ArrayList()).O000000o(), str, false, (fss) new fss<String>() {
                                /* class _m_j.fuf.AnonymousClass1 */

                                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                                    return jSONObject.getString("token");
                                }
                            }, (fsm) r6);
                        }

                        public final void onFailure(fso fso) {
                            fue.this.O00000o0();
                        }
                    };
                    String O000000o2 = O000000o("/api/xqsystem/init_info");
                    final Pair<List<gsi>, String> pair = O0000O0o;
                    if (pair == null) {
                        r1.sendFailureMessage(new fso(-1, ""));
                        new fsn(null);
                        return;
                    }
                    Call newCall = this.O00000Oo.newCall(new Request.Builder().url(gst.O000000o(O000000o2, (List) pair.first)).build());
                    newCall.enqueue(new Callback() {
                        /* class _m_j.fue.AnonymousClass3 */

                        public final void onFailure(Call call, IOException iOException) {
                            String str;
                            fsm fsm = r1;
                            if (fsm != null) {
                                int code = ErrorCode.INVALID.getCode();
                                if (iOException == null) {
                                    str = "request failure";
                                } else {
                                    str = iOException.getMessage();
                                }
                                fsm.sendFailureMessage(new fso(code, str));
                            }
                        }

                        public final void onResponse(Call call, Response response) throws IOException {
                            fue.O000000o(response, r0, r1);
                        }
                    });
                    new fsn(newCall);
                    return;
                }
            }
            str2 = null;
            if (!TextUtils.isEmpty(str2)) {
            }
        } else {
            this.O00000o0 = false;
            O00000Oo();
        }
    }

    public String O000000o(String str) {
        if (TextUtils.isEmpty(this.O0000OoO)) {
            return "http://192.168.31.1/cgi-bin/luci".concat(String.valueOf(str));
        }
        String str2 = this.O00000oO;
        if (TextUtils.isEmpty(str2)) {
            return this.O0000OoO + str;
        }
        return this.O0000OoO + "/;stok=" + str2 + str;
    }

    public static <T> void O000000o(Response response, O000000o<T> o000000o, fsm<T, fso> fsm) {
        if (response == null) {
            if (fsm != null) {
                fsm.sendFailureMessage(new fso(-1, "response is null"));
            }
        } else if (response.isSuccessful()) {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string());
                    if (jSONObject.optInt("code") == 0) {
                        T t = null;
                        if (o000000o != null) {
                            t = o000000o.O000000o(jSONObject);
                        }
                        if (fsm != null) {
                            fsm.sendSuccessMessage(t);
                            return;
                        }
                        return;
                    }
                    throw new Exception("failure");
                } catch (Exception unused) {
                    if (fsm != null) {
                        fsm.sendFailureMessage(new fso(-1, "wrong response format"));
                    }
                }
            } catch (Exception unused2) {
                if (fsm != null) {
                    fsm.sendFailureMessage(new fso(-1, "response is null"));
                }
            }
        } else if (fsm != null) {
            fsm.sendFailureMessage(new fso(response.code(), "request failure"));
        }
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f17168O000000o;
        public int O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;

        O00000Oo() {
        }
    }
}

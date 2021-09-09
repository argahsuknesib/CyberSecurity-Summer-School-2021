package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.account.RefreshServiceTokenResult;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.io.IOException;
import java.net.CookieManager;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class fdo {
    private static Object O00000o = new Object();
    private static volatile fdo O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public Object f16114O000000o = new Object();
    public boolean O00000Oo = false;
    private OkHttpClient O00000oO;
    private CookieManager O00000oo;
    private MiServiceTokenInfo O0000O0o;
    private boolean O0000OOo = false;

    private fdo() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        OkHttpClient.Builder writeTimeout = builder.dispatcher(new Dispatcher(goq.O000000o())).connectTimeout(20, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS);
        CookieManager cookieManager = new CookieManager();
        this.O00000oo = cookieManager;
        this.O00000oO = writeTimeout.cookieJar(new JavaNetCookieJar(cookieManager)).build();
    }

    public static fdo O000000o() {
        if (O00000o0 == null) {
            synchronized (O00000o) {
                if (O00000o0 == null) {
                    O00000o0 = new fdo();
                }
            }
        }
        return O00000o0;
    }

    private boolean O00000o0() {
        boolean z;
        synchronized (O00000o) {
            z = this.O0000OOo;
        }
        return z;
    }

    public final void O000000o(boolean z) {
        synchronized (O00000o) {
            this.O0000OOo = z;
        }
    }

    private static String O000000o(NetRequest netRequest, boolean z) {
        if (z) {
            return "https://api.miwifi.com" + netRequest.O00000Oo;
        }
        return "https://api.miwifi.com/r" + netRequest.O00000Oo;
    }

    private static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public final String O000000o(String str, String str2) throws SecurityException {
        try {
            String valueOf = String.valueOf(grs.O000000o(grx.O000000o(O000000o(grs.O000000o(this.O0000O0o.O00000o), grs.O000000o(str2)))));
            if (valueOf == null) {
                return null;
            }
            return new grz(valueOf).O000000o(false, str);
        } catch (Exception | InvalidKeyException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public final void O00000Oo() {
        boolean z;
        String O00000Oo2 = fcn.O000000o().O00000Oo();
        boolean O00000oO2 = fcn.O000000o().O00000oO();
        String O00000oo2 = fcn.O000000o().O00000oo();
        synchronized (this.f16114O000000o) {
            z = true;
            if (!this.O00000Oo) {
                this.O00000Oo = true;
                z = false;
            }
        }
        if (!z) {
            if (O00000oO2) {
                try {
                    fcn.O000000o().O000000o("xiaoqiang");
                } catch (Exception unused) {
                    synchronized (this.f16114O000000o) {
                        this.O00000Oo = false;
                        if (O00000oO2) {
                            fcn.O000000o().O000000o("xiaoqiang");
                        }
                        O000000o(false);
                        return;
                    }
                }
            }
            fcn.O000000o().O000000o("xiaoqiang", O00000Oo2, O00000oO2, O00000oo2, new fdh<Bundle, Error>() {
                /* class _m_j.fdo.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    Bundle bundle = (Bundle) obj;
                    synchronized (fdo.this.f16114O000000o) {
                        fdo.this.O00000Oo = false;
                    }
                    bundle.setClassLoader(RefreshServiceTokenResult.class.getClassLoader());
                    RefreshServiceTokenResult refreshServiceTokenResult = (RefreshServiceTokenResult) bundle.getParcelable("result");
                    fcn.O000000o().O000000o("xiaoqiang", refreshServiceTokenResult.O00000o, refreshServiceTokenResult.O00000Oo, refreshServiceTokenResult.O00000oO, "api.gorouter.info", refreshServiceTokenResult.O00000oo);
                    fcn.O000000o().O0000Oo();
                    fdo.this.O000000o(false);
                }

                public final void onFailure(Error error) {
                    synchronized (fdo.this.f16114O000000o) {
                        fdo.this.O00000Oo = false;
                    }
                    fdo.this.O000000o(false);
                }
            });
        }
    }

    public final fdi O000000o(NetRequest netRequest, String str, boolean z, fdh<NetResult, NetError> fdh) {
        Request request;
        NetRequest netRequest2 = netRequest;
        final fdh<NetResult, NetError> fdh2 = fdh;
        if (netRequest2 == null) {
            if (fdh2 != null) {
                fdh2.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
            }
            return new fdi(null);
        } else if (fju.O000000o().O00000oO()) {
            if (fdh2 != null) {
                fdh2.onFailure(new NetError(ErrorCode.INVALID.getCode(), "international not support router-api"));
            }
            return new fdi(null);
        } else {
            String O000000o2 = O000000o(netRequest2, z);
            if (!O00000o0()) {
                if (!fcn.O000000o().O0000OOo()) {
                    if (fdh2 != null) {
                        fdh2.onFailure(new NetError(ErrorCode.INVALID.getCode(), "not loggedin"));
                    }
                    return new fdi(null);
                }
                String O00000Oo2 = fcn.O000000o().O00000Oo();
                this.O0000O0o = fcn.O000000o().O00000Oo("xiaoqiang");
                if (TextUtils.isEmpty(O00000Oo2) || this.O0000O0o == null) {
                    O00000Oo();
                    if (fdh2 != null) {
                        fdh2.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
                    }
                    return new fdi(null);
                }
                gsr.O000000o(this.O00000oo);
                gsr.O000000o(this.O00000oo, "https://api.miwifi.com", "userId", O00000Oo2, "api.gorouter.info", "/");
                gsr.O000000o(this.O00000oo, "https://api.miwifi.com", "serviceToken", this.O0000O0o.O00000o0, this.O0000O0o.O00000oo, "/");
                O000000o(true);
            }
            final Pair<List<KeyValuePair>, String> O000000o3 = O000000o(netRequest, str, z);
            if (O000000o3 == null) {
                if (fdh2 != null) {
                    fdh2.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
                }
                return new fdi(null);
            }
            if (netRequest2.f6729O000000o.equals("POST")) {
                request = new Request.Builder().url(O000000o2).headers(flj.O000000o(netRequest2.O00000o)).post(flj.O00000Oo((List) O000000o3.first)).build();
            } else {
                request = netRequest2.f6729O000000o.equals("GET") ? new Request.Builder().url(flj.O000000o(O000000o2, (List) O000000o3.first)).headers(flj.O000000o(netRequest2.O00000o)).build() : null;
            }
            if (request == null) {
                if (fdh2 != null) {
                    fdh2.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
                }
                return new fdi(null);
            }
            Call newCall = this.O00000oO.newCall(request);
            newCall.enqueue(new Callback() {
                /* class _m_j.fdo.AnonymousClass2 */

                public final void onFailure(Call call, IOException iOException) {
                    fdh fdh = fdh2;
                    if (fdh != null) {
                        fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), iOException == null ? "net request failure" : iOException.getMessage()));
                    }
                }

                public final void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        if (response.code() == 401) {
                            fdo.this.O00000Oo();
                        }
                        fdh fdh = fdh2;
                        if (fdh != null) {
                            fdh.onFailure(new NetError(response.code(), ""));
                            return;
                        }
                        return;
                    }
                    try {
                        String O000000o2 = fdo.this.O000000o(response.body().string(), (String) O000000o3.second);
                        NetResult netResult = new NetResult();
                        netResult.O00000o0 = O000000o2;
                        fdh fdh2 = fdh2;
                        if (fdh2 != null) {
                            fdh2.onSuccess(netResult);
                        }
                    } catch (Exception e) {
                        fdh fdh3 = fdh2;
                        if (fdh3 != null) {
                            fdh3.onFailure(new NetError(ErrorCode.INVALID.getCode(), e.getMessage()));
                        }
                    }
                }
            });
            return new fdi(newCall);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    private Pair<List<KeyValuePair>, String> O000000o(NetRequest netRequest, String str, boolean z) {
        String str2;
        String str3 = z ? "" : "/r";
        String str4 = str3 + netRequest.O00000Oo;
        String O000000o2 = grt.O000000o(this.O0000O0o.O00000oO);
        try {
            str2 = String.valueOf(grs.O000000o(grx.O000000o(O000000o(grs.O000000o(this.O0000O0o.O00000o), grs.O000000o(O000000o2)))));
        } catch (NoSuchAlgorithmException unused) {
            gsy.O000000o(3, "RouterApi", "generate sessionSecurity fail:NoSuchAlgorithmException");
            str2 = null;
            if (str2 != null) {
            }
        } catch (InvalidKeyException unused2) {
            gsy.O000000o(3, "RouterApi", "generate sessionSecurity fail:InvalidKeyException");
            str2 = null;
            if (str2 != null) {
            }
        } catch (Exception unused3) {
            gsy.O000000o(3, "RouterApi", "generate sessionSecurity fail");
            str2 = null;
            if (str2 != null) {
            }
        }
        if (str2 != null) {
            return null;
        }
        TreeMap treeMap = new TreeMap();
        TreeMap treeMap2 = new TreeMap();
        ArrayList arrayList = new ArrayList();
        grz grz = new grz(str2);
        List<KeyValuePair> list = netRequest.O00000oO;
        if (list != null) {
            for (KeyValuePair next : list) {
                if (!TextUtils.isEmpty(next.f6728O000000o) && !TextUtils.isEmpty(next.O00000Oo)) {
                    treeMap2.put(next.f6728O000000o, next.O00000Oo);
                }
            }
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str)) {
            if (str.startsWith("miwifi.")) {
                str = str.substring(7);
            }
            if (list != null) {
                Iterator<KeyValuePair> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    KeyValuePair next2 = it.next();
                    if (next2.f6728O000000o.equalsIgnoreCase("deviceId")) {
                        str = next2.O00000Oo;
                        break;
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                treeMap2.put("deviceId", str);
            }
        }
        treeMap2.put("rc4_hash__", grt.O000000o(netRequest.f6729O000000o, str4, treeMap2, str2));
        for (Map.Entry entry : treeMap2.entrySet()) {
            String O000000o3 = grz.O000000o((String) entry.getValue());
            treeMap.put(entry.getKey(), O000000o3);
            arrayList.add(new KeyValuePair((String) entry.getKey(), O000000o3));
        }
        arrayList.add(new KeyValuePair("signature", grt.O000000o(netRequest.f6729O000000o, str4, treeMap, str2)));
        arrayList.add(new KeyValuePair("_nonce", O000000o2));
        return Pair.create(arrayList, O000000o2);
    }
}

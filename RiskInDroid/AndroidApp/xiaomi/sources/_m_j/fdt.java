package _m_j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.CookieManager;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class fdt {
    private static volatile fdt O00000oO;
    private static final Object O00000oo = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    long f16129O000000o = 0;
    long O00000Oo = 10000;
    public Context O00000o;
    Object O00000o0 = new Object();
    private volatile boolean O0000O0o = false;
    private OkHttpClient O0000OOo;
    private MiServiceTokenInfo O0000Oo;
    private CookieManager O0000Oo0;
    private Dispatcher O0000OoO;

    private fdt(Context context) {
        this.O00000o = context;
        String str = this.O00000o.getFilesDir().getPath() + File.separator + "okhttp3" + File.separator + "cache";
        ArrayList arrayList = new ArrayList();
        arrayList.add(Protocol.HTTP_1_1);
        if (Build.VERSION.SDK_INT > 20) {
            arrayList.add(Protocol.HTTP_2);
        }
        this.O0000OoO = new Dispatcher(goq.O000000o());
        this.O0000OoO.setMaxRequestsPerHost(gpy.O000000o(context, "SP_THREADPOOL_AB_CONFIG", "SP_THREADPOOL_MAX_REQUESTS_PER_HOST", 10));
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        OkHttpClient.Builder protocols = builder.dispatcher(this.O0000OoO).connectTimeout(20, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).retryOnConnectionFailure(false).protocols(arrayList);
        CookieManager cookieManager = new CookieManager();
        this.O0000Oo0 = cookieManager;
        this.O0000OOo = protocols.cookieJar(new JavaNetCookieJar(cookieManager)).addNetworkInterceptor(new Interceptor() {
            /* class _m_j.fdt.AnonymousClass1 */

            public final Response intercept(Interceptor.Chain chain) throws IOException {
                return chain.proceed(chain.request().newBuilder().removeHeader("User-Agent").removeHeader("ssecurity").addHeader("MIOT-ACCEPT-ENCODING", "GZIP").addHeader("User-Agent", fln.O000000o(fdt.this.O00000o)).build());
            }
        }).cache(new Cache(new File(str), 104857600)).sslSocketFactory(fkb.O000000o(), fkb.O00000Oo()).build();
        O00000Oo();
    }

    public static fdt O000000o() {
        if (O00000oO == null) {
            synchronized (fdt.class) {
                if (O00000oO == null) {
                    O00000oO = new fdt(CommonApplication.getAppContext());
                }
            }
        }
        return O00000oO;
    }

    private boolean O00000o0() {
        boolean z;
        synchronized (O00000oo) {
            z = this.O0000O0o;
        }
        return z;
    }

    public final void O000000o(boolean z) {
        synchronized (O00000oo) {
            this.O0000O0o = z;
        }
    }

    private String O00000o() {
        String str;
        ServerBean O00000o2 = fju.O000000o().O00000o();
        String O00000oo2 = fju.O000000o().O00000oo();
        if (O00000o2 == null || ftn.O00000o0(O00000o2)) {
            str = (TextUtils.isEmpty(O00000oo2) || O00000oo2.equalsIgnoreCase("release") || !O00000oo2.equalsIgnoreCase("preview")) ? "api.io.mi.com" : "pv.api.io.mi.com";
        } else if (TextUtils.isEmpty(O00000oo2) || O00000oo2.equalsIgnoreCase("release") || !O00000oo2.equalsIgnoreCase("preview")) {
            str = O00000o2.f7546O000000o + ".api.io.mi.com";
        } else {
            str = "pv-" + O00000o2.f7546O000000o + ".api.io.mi.com";
        }
        return "https://" + O00000Oo(str);
    }

    private static String O00000Oo(String str) {
        if ((!fcn.O000000o().O00000o0() && !fcn.O000000o().O00000o()) || O00000o0(str)) {
            return str;
        }
        ServerBean O00000o2 = fju.O000000o().O00000o();
        if (str.startsWith("pv.") || str.startsWith("pv-")) {
            return str;
        }
        if (O00000o2 == null || ftn.O00000o0(O00000o2)) {
            return "pv.".concat(String.valueOf(str));
        }
        return "pv-" + O00000o2.f7546O000000o + "." + str;
    }

    private static boolean O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ServerBean O00000o2 = fju.O000000o().O00000o();
        if (!str.startsWith("processor.smartcamera") && !str.startsWith("business.smartcamera") && !str.startsWith("camera") && !str.startsWith("connect.camera")) {
            if (O00000o2 == null || TextUtils.isEmpty(O00000o2.f7546O000000o)) {
                return false;
            }
            if (!str.startsWith(O00000o2.f7546O000000o + ".processor.smartcamera")) {
                if (!str.startsWith(O00000o2.f7546O000000o + ".business.smartcamera")) {
                    if (!str.startsWith(O00000o2.f7546O000000o + ".camera")) {
                        if (str.startsWith(O00000o2.f7546O000000o + ".connect.camera")) {
                            return true;
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static String O000000o(String str, String str2) {
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(grs.O000000o(str2), "HmacSHA256"));
            return String.valueOf(grs.O000000o(instance.doFinal(str.getBytes("UTF-8"))));
        } catch (Exception unused) {
            return "";
        }
    }

    protected static String O000000o(MiServiceTokenInfo miServiceTokenInfo, String str, String str2, String str3) throws SecurityException {
        try {
            String valueOf = String.valueOf(grs.O000000o(grx.O000000o(O000000o(grs.O000000o(miServiceTokenInfo.O00000o), grs.O000000o(str3)))));
            if (valueOf == null) {
                return null;
            }
            return new grz(valueOf).O000000o("GZIP".equals(str), str2);
        } catch (Exception | InvalidKeyException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static void O000000o(Request request, long j, boolean z) {
        if (j >= 600 && (gfr.O0000Ooo || gfr.O0000OOo)) {
            try {
                String str = request.url().toString() + " takes " + j + "ms to get response";
                gsy.O00000o0(LogType.NETWORK, "SmartHomeApi", str);
                gsy.O000000o(3, "forceUpdateAllData", str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        boolean z2 = true;
        if (!gfr.O0000o0o && !gfr.O0000OOo) {
            z2 = false;
        }
        if (z2) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("PATH:");
            stringBuffer.append(request.url().encodedPath());
            stringBuffer.append("||delta:");
            stringBuffer.append(j);
            stringBuffer.append("||succ:");
            stringBuffer.append(z);
            gsy.O00000o0(LogType.REQUEST_OUTPUT, "SmartHomeApi", stringBuffer.toString());
        }
    }

    public static void O000000o(fdh<NetResult, NetError> fdh, Response response) {
        if (fdh == null) {
            return;
        }
        if (response.request() == null || TextUtils.isEmpty(response.request().url().toString())) {
            fdh.onFailure(new NetError(response.code(), response.message()));
        } else {
            fdh.onFailure(new NetError(response.code(), response.message(), response.request().url().toString()));
        }
    }

    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        while (true) {
            try {
                int indexOf = sb.indexOf("token\":\"", i);
                if (indexOf <= 0) {
                    break;
                }
                i = indexOf + 8;
                int indexOf2 = sb.indexOf(jdn.f1779O000000o, i);
                if (indexOf2 > 0) {
                    sb.replace(i, indexOf2, "*");
                    i += 2;
                }
            } catch (Exception unused) {
            }
        }
        return sb.toString();
    }

    public final void O00000Oo() {
        synchronized (this.O00000o0) {
            this.f16129O000000o = 0;
            this.O00000Oo = 10000;
        }
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f16134O000000o = false;

        O000000o() {
        }

        /* access modifiers changed from: package-private */
        public final synchronized void O000000o() {
            this.f16134O000000o = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    private static Pair<List<KeyValuePair>, String> O000000o(MiServiceTokenInfo miServiceTokenInfo, NetRequest netRequest) {
        String str;
        netRequest.O00000o.add(new KeyValuePair("X-XIAOMI-PROTOCAL-FLAG-CLI", "PROTOCAL-HTTP2"));
        String O00000Oo2 = grt.O00000Oo(System.currentTimeMillis() + miServiceTokenInfo.O00000oO);
        try {
            str = String.valueOf(grs.O000000o(grx.O000000o(O000000o(grs.O000000o(miServiceTokenInfo.O00000o), grs.O000000o(O00000Oo2)))));
        } catch (NoSuchAlgorithmException unused) {
            gsy.O000000o(3, "SmartHomeApi", "generate sessionSecurity fail:NoSuchAlgorithmException");
            str = null;
            if (str != null) {
            }
        } catch (InvalidKeyException unused2) {
            gsy.O000000o(3, "SmartHomeApi", "generate sessionSecurity fail:InvalidKeyException");
            str = null;
            if (str != null) {
            }
        } catch (Exception unused3) {
            gsy.O000000o(3, "SmartHomeApi", "generate sessionSecurity fail");
            str = null;
            if (str != null) {
            }
        }
        if (str != null) {
            return null;
        }
        TreeMap treeMap = new TreeMap();
        ArrayList arrayList = new ArrayList();
        List<KeyValuePair> list = netRequest.O00000oO;
        if (list != null) {
            for (KeyValuePair next : list) {
                if (!TextUtils.isEmpty(next.f6728O000000o) && !TextUtils.isEmpty(next.O00000Oo)) {
                    treeMap.put(next.f6728O000000o, next.O00000Oo);
                }
            }
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (netRequest.O00000Oo != null) {
            arrayList2.add(netRequest.O00000Oo);
        }
        arrayList2.add(str);
        arrayList2.add(O00000Oo2);
        boolean z = true;
        if (!treeMap.isEmpty()) {
            for (Map.Entry entry : new TreeMap((SortedMap) treeMap).entrySet()) {
                arrayList2.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
            }
        } else {
            arrayList2.add("data=");
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList2) {
            if (!z) {
                sb.append('&');
            }
            sb.append(str2);
            z = false;
        }
        arrayList.add(new KeyValuePair("signature", O000000o(sb.toString(), str)));
        arrayList.add(new KeyValuePair("_nonce", O00000Oo2));
        arrayList.addAll(netRequest.O00000oO);
        return Pair.create(arrayList, O00000Oo2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006e  */
    private Pair<List<KeyValuePair>, String> O00000Oo(MiServiceTokenInfo miServiceTokenInfo, NetRequest netRequest) {
        String str;
        List<KeyValuePair> list = netRequest.O00000o;
        if (this.O0000OOo.protocols().contains(Protocol.HTTP_2)) {
            list.add(new KeyValuePair("X-XIAOMI-PROTOCAL-FLAG-CLI", "PROTOCAL-HTTP2"));
        }
        list.add(new KeyValuePair("MIOT-ENCRYPT-ALGORITHM", "ENCRYPT-RC4"));
        list.add(new KeyValuePair("Accept-Encoding", "identity"));
        String O000000o2 = grt.O000000o(miServiceTokenInfo.O00000oO);
        try {
            str = String.valueOf(grs.O000000o(grx.O000000o(O000000o(grs.O000000o(miServiceTokenInfo.O00000o), grs.O000000o(O000000o2)))));
        } catch (NoSuchAlgorithmException unused) {
            gsy.O000000o(3, "SmartHomeApi", "generate sessionSecurity fail:NoSuchAlgorithmException");
            str = null;
            if (str != null) {
            }
        } catch (InvalidKeyException unused2) {
            gsy.O000000o(3, "SmartHomeApi", "generate sessionSecurity fail:InvalidKeyException");
            str = null;
            if (str != null) {
            }
        } catch (Exception unused3) {
            gsy.O000000o(3, "SmartHomeApi", "generate sessionSecurity fail");
            str = null;
            if (str != null) {
            }
        }
        if (str != null) {
            return null;
        }
        TreeMap treeMap = new TreeMap();
        TreeMap treeMap2 = new TreeMap();
        ArrayList arrayList = new ArrayList();
        grz grz = new grz(str);
        List<KeyValuePair> list2 = netRequest.O00000oO;
        if (list2 != null) {
            for (KeyValuePair next : list2) {
                if (!TextUtils.isEmpty(next.f6728O000000o) && !TextUtils.isEmpty(next.O00000Oo)) {
                    treeMap2.put(next.f6728O000000o, next.O00000Oo);
                }
            }
        }
        treeMap2.put("rc4_hash__", grt.O000000o(netRequest.f6729O000000o, netRequest.O00000Oo, treeMap2, str));
        for (Map.Entry entry : treeMap2.entrySet()) {
            String O000000o3 = grz.O000000o((String) entry.getValue());
            treeMap.put(entry.getKey(), O000000o3);
            arrayList.add(new KeyValuePair((String) entry.getKey(), O000000o3));
        }
        arrayList.add(new KeyValuePair("signature", grt.O000000o(netRequest.f6729O000000o, netRequest.O00000Oo, treeMap, str)));
        arrayList.add(new KeyValuePair("_nonce", O000000o2));
        arrayList.add(new KeyValuePair("ssecurity", miServiceTokenInfo.O00000o));
        return Pair.create(arrayList, O000000o2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0375  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x03f2  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0505  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x051d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0311 A[SYNTHETIC, Splitter:B:99:0x0311] */
    public final fdi O000000o(NetRequest netRequest, fdh<NetResult, NetError> fdh) {
        String str;
        MiServiceTokenInfo miServiceTokenInfo;
        final MiServiceTokenInfo miServiceTokenInfo2;
        final boolean z;
        final Pair<List<KeyValuePair>, String> pair;
        final Request request;
        Request request2;
        MultipartBody multipartBody;
        String str2;
        int i;
        boolean z2;
        String str3;
        String str4;
        String str5;
        NetRequest netRequest2 = netRequest;
        fdh<NetResult, NetError> fdh2 = fdh;
        if (gfr.O0000Ooo || gfr.O0000OOo) {
            try {
                int queuedCallsCount = this.O0000OoO.queuedCallsCount();
                if (queuedCallsCount >= 15) {
                    int runningCallsCount = this.O0000OoO.runningCallsCount();
                    gsy.O00000o0(LogType.NETWORK, "SmartHomeApi", "okhttp queuedCallsCount=" + queuedCallsCount + ",runningCallsCount=" + runningCallsCount);
                    gsy.O000000o(3, "forceUpdateAllData", "okhttp queuedCallsCount=" + queuedCallsCount + ",runningCallsCount=" + runningCallsCount);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (netRequest2 == null) {
            if (fdh2 != null) {
                fdh2.onFailure(new NetError(ErrorCode.INVALID.getCode(), "netRequest is null"));
            }
            return new fdi(null);
        }
        if (netRequest2 == null || TextUtils.isEmpty(netRequest2.O00000o0)) {
            str = O00000o() + "/app" + netRequest2.O00000Oo;
        } else {
            StringBuilder sb = new StringBuilder();
            String str6 = netRequest2.O00000o0;
            ServerBean O00000o2 = fju.O000000o().O00000o();
            String O00000oo2 = fju.O000000o().O00000oo();
            if (TextUtils.isEmpty(str6)) {
                str6 = "";
            } else if (!str6.endsWith(".")) {
                str6 = str6 + ".";
            }
            if (O00000o2 == null || ftn.O00000o0(O00000o2)) {
                if (TextUtils.isEmpty(O00000oo2) || O00000oo2.equalsIgnoreCase("release") || !O00000oo2.equalsIgnoreCase("preview")) {
                    str5 = str6 + "api.io.mi.com";
                } else {
                    str5 = "pv." + str6 + "api.io.mi.com";
                }
            } else if (TextUtils.isEmpty(O00000oo2) || O00000oo2.equalsIgnoreCase("release") || !O00000oo2.equalsIgnoreCase("preview")) {
                str5 = O00000o2.f7546O000000o + "." + str6 + "api.io.mi.com";
            } else {
                str5 = "pv-" + O00000o2.f7546O000000o + "." + str6 + "api.io.mi.com";
            }
            sb.append("https://" + O00000Oo(str5));
            sb.append(netRequest2.O00000Oo);
            str = sb.toString();
        }
        final String str7 = str;
        synchronized (O00000oo) {
            if (O00000o0()) {
                miServiceTokenInfo = this.O0000Oo;
            } else if (!fcn.O000000o().O0000OOo()) {
                if (fdh2 != null) {
                    fdh2.onFailure(new NetError(ErrorCode.INVALID.getCode(), "not loggedin"));
                }
                fdi fdi = new fdi(null);
                return fdi;
            } else {
                String O00000Oo2 = fcn.O000000o().O00000Oo();
                if (!ftn.O0000Oo0(fju.O000000o().O00000o()) || ((str4 = netRequest2.O00000o0) != null && (str4.startsWith("connect.camera") || str4.startsWith("processor.smartcamera") || str4.startsWith("business.smartcamera") || str4.startsWith("camera")))) {
                    miServiceTokenInfo = fcn.O000000o().O00000Oo("xiaomiio");
                } else {
                    miServiceTokenInfo = fcn.O000000o().O00000Oo("miot-third-test");
                }
                if (!TextUtils.isEmpty(O00000Oo2)) {
                    if (miServiceTokenInfo != null) {
                        gsr.O000000o(this.O0000Oo0);
                        if (TextUtils.isEmpty(miServiceTokenInfo.O00000Oo)) {
                            gsr.O000000o(this.O0000Oo0, O00000o(), "userId", O00000Oo2, ".io.mi.com", "/");
                            gsy.O00000Oo(LogType.LOGIN, "SmartHomeApi", "cannot get cUserId");
                            fcn.O000000o().O0000Ooo();
                        } else {
                            gsr.O000000o(this.O0000Oo0, O00000o(), "cUserId", miServiceTokenInfo.O00000Oo, ".io.mi.com", "/");
                        }
                        gsr.O000000o(this.O0000Oo0, O00000o(), "yetAnotherServiceToken", miServiceTokenInfo.O00000o0, miServiceTokenInfo.O00000oo, "/");
                        gsr.O000000o(this.O0000Oo0, O00000o(), "serviceToken", miServiceTokenInfo.O00000o0, miServiceTokenInfo.O00000oo, "/");
                        ServerBean O000000o2 = ftn.O000000o(this.O00000o);
                        if (O000000o2 != null) {
                            gsr.O000000o(this.O0000Oo0, O00000o(), "countryCode", O000000o2.O00000Oo, ".io.mi.com", "/");
                        }
                        Locale O0000O0o2 = fju.O000000o().O0000O0o();
                        if (O0000O0o2 == null) {
                            Locale O00000Oo3 = flk.O00000Oo();
                            gsy.O000000o(4, "SmartHomeApi", "setLocaleCookie locale=null getDefault:".concat(String.valueOf(O00000Oo3)));
                            gsr.O000000o(this.O0000Oo0, O00000o(), "locale", flk.O000000o(O00000Oo3), ".io.mi.com", "/");
                        } else {
                            gsy.O000000o(4, "SmartHomeApi", "setLocaleCookie:".concat(String.valueOf(O0000O0o2)));
                            gsr.O000000o(this.O0000Oo0, O00000o(), "locale", flk.O000000o(O0000O0o2), ".io.mi.com", "/");
                        }
                        String str8 = "";
                        TimeZone timeZone = TimeZone.getDefault();
                        try {
                            grr.O000000o();
                            str8 = URLEncoder.encode(grr.O0000o0o(), "UTF-8");
                            z2 = timeZone.useDaylightTime();
                            try {
                                i = timeZone.getDSTSavings();
                                str2 = str8;
                            } catch (UnsupportedEncodingException unused) {
                                str2 = str8;
                                i = 0;
                                if (timeZone != null) {
                                }
                                gsr.O000000o(this.O0000Oo0, O00000o(), "timezone", str2, ".io.mi.com", "/");
                                gsr.O000000o(this.O0000Oo0, O00000o(), "is_daylight", z2 ? "1" : "0", ".io.mi.com", "/");
                                gsr.O000000o(this.O0000Oo0, O00000o(), "dst_offset", String.valueOf(i), ".io.mi.com", "/");
                                str3 = fcn.O000000o().O0000o00();
                                if (!TextUtils.isEmpty(str3)) {
                                }
                                gsr.O000000o(this.O0000Oo0, O00000o(), "channel", gfr.O0000o0O, ".io.mi.com", "/");
                                O000000o(true);
                                this.O0000Oo = miServiceTokenInfo;
                                miServiceTokenInfo2 = miServiceTokenInfo;
                                if (!gfr.O0000Oo0 || !gpy.O00000o0(this.O00000o, "developer_setting", "rn_debug_force_plaintext_transmission", false)) {
                                    pair = O00000Oo(miServiceTokenInfo2, netRequest2);
                                    z = false;
                                } else {
                                    pair = O000000o(miServiceTokenInfo2, netRequest2);
                                    z = true;
                                }
                                if (pair != null) {
                                    if (fdh2 != null) {
                                        fdh2.onFailure(new NetError(ErrorCode.INVALID.getCode(), "pair == null"));
                                    }
                                    return new fdi(null);
                                }
                                if (!netRequest2.f6729O000000o.equals("POST")) {
                                    if (netRequest2.f6729O000000o.equals("GET")) {
                                        request2 = new Request.Builder().url(flj.O000000o(str7, (List) pair.first)).headers(flj.O000000o(netRequest2.O00000o)).build();
                                    }
                                    request = null;
                                    if (request == null) {
                                    }
                                } else if (netRequest2.O00000oo == null || netRequest2.O00000oo.size() <= 0) {
                                    request2 = new Request.Builder().url(str7).headers(flj.O000000o(netRequest2.O00000o)).post(flj.O00000Oo((List) pair.first)).tag(miServiceTokenInfo2.O00000o).build();
                                } else {
                                    MultipartBody.Builder builder = new MultipartBody.Builder();
                                    builder.setType(MultipartBody.FORM);
                                    try {
                                        List<KeyValuePair> list = netRequest2.O00000oo;
                                        if (list != null && list.size() > 0) {
                                            for (KeyValuePair keyValuePair : list) {
                                                File file = new File(keyValuePair.O00000Oo);
                                                if (file.exists()) {
                                                    String name = file.getName();
                                                    builder.addFormDataPart("img", name, MultipartBody.create(MediaType.parse(gtb.O000000o(gtb.O00000o0(name))), file));
                                                }
                                            }
                                        }
                                        multipartBody = builder.build();
                                    } catch (Exception e2) {
                                        gsy.O000000o(6, "SmartHomeApi", "MultipartBody exception:" + e2.getLocalizedMessage());
                                        multipartBody = null;
                                    }
                                    if (multipartBody != null) {
                                        request2 = new Request.Builder().url(str7 + flj.O00000o0((List) pair.first)).headers(flj.O000000o(netRequest2.O00000o)).post(multipartBody).tag(miServiceTokenInfo2.O00000o).build();
                                    }
                                    request = null;
                                    if (request == null) {
                                        if (fdh2 != null) {
                                            fdh2.onFailure(new NetError(ErrorCode.INVALID.getCode(), "request == null"));
                                        }
                                        return new fdi(null);
                                    }
                                    if (gfr.O0000OOo || gfr.O0000Oo) {
                                        gsy.O000000o(3, "BootRequestCheck", System.currentTimeMillis() + " SmartHomeRc4Api.sendRequest " + request.toString() + " " + fcn.O000000o().O000000o(this.O00000o));
                                    }
                                    final O000000o o000000o = new O000000o();
                                    Call newCall = this.O0000OOo.newCall(request);
                                    final long currentTimeMillis = System.currentTimeMillis();
                                    final NetRequest netRequest3 = netRequest;
                                    final fdh<NetResult, NetError> fdh3 = fdh;
                                    newCall.enqueue(new Callback() {
                                        /* class _m_j.fdt.AnonymousClass2 */

                                        public final void onFailure(Call call, IOException iOException) {
                                            fdt.O000000o(request, Math.abs(System.currentTimeMillis() - currentTimeMillis), false);
                                            o000000o.O000000o();
                                            if (gfr.O0000OOo || gfr.O0000Oo) {
                                                StringBuilder sb = new StringBuilder("host:");
                                                sb.append(request.url() == null ? null : request.url().host());
                                                sb.append(" ");
                                                sb.append(netRequest3.toString());
                                                gsy.O000000o(6, "MIIO", sb.toString());
                                                if (iOException != null) {
                                                    gsy.O000000o(6, "MIIO", iOException.toString());
                                                }
                                            }
                                            if ((iOException instanceof SocketTimeoutException) && fka.O000000o(CommonApplication.getAppContext())) {
                                                fdt fdt = fdt.this;
                                                if (fka.O00000Oo(fdt.O00000o)) {
                                                    synchronized (fdt.O00000o0) {
                                                        long currentTimeMillis = System.currentTimeMillis();
                                                        if (fdt.f16129O000000o == 0 || currentTimeMillis >= fdt.f16129O000000o + fdt.O00000Oo) {
                                                            fdt.f16129O000000o = System.currentTimeMillis();
                                                            fdt.O00000Oo *= 2;
                                                        }
                                                    }
                                                }
                                            }
                                            fdh fdh = fdh3;
                                            if (fdh != null) {
                                                fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), iOException == null ? "net request failure" : iOException.getMessage()));
                                            }
                                        }

                                        public final void onResponse(Call call, final Response response) throws IOException {
                                            String str;
                                            fdt.O000000o(request, Math.abs(System.currentTimeMillis() - currentTimeMillis), true);
                                            o000000o.O000000o();
                                            fdt.this.O00000Oo();
                                            String header = response.header("Request-Id");
                                            String header2 = response.header("MIOT-CONTENT-ENCODING");
                                            String str2 = null;
                                            if (!response.isSuccessful()) {
                                                if (gfr.O0000OOo || gfr.O0000Oo) {
                                                    StringBuilder sb = new StringBuilder("Request-Id:");
                                                    sb.append(header);
                                                    sb.append("host:");
                                                    if (request.url() != null) {
                                                        str2 = request.url().host();
                                                    }
                                                    sb.append(str2);
                                                    sb.append(" ");
                                                    sb.append(netRequest3.toString());
                                                    gsy.O000000o(6, "MIIO", sb.toString());
                                                    gsy.O000000o(6, "MIIO", response.toString());
                                                }
                                                try {
                                                    str = response.body().string();
                                                } catch (Exception unused) {
                                                    str = "responseBody.string() exception";
                                                }
                                                if (response.code() == 401) {
                                                    gsy.O000000o(6, "MIIO", pair.toString());
                                                    fcn.O000000o().O000000o(miServiceTokenInfo2, netRequest3.O00000Oo, str, new fdh<MiServiceTokenInfo, Error>() {
                                                        /* class _m_j.fdt.AnonymousClass2.AnonymousClass1 */

                                                        public final void onFailure(Error error) {
                                                            fdt.O000000o(fdh3, response);
                                                            LogType logType = LogType.NETWORK;
                                                            gsy.O00000o0(logType, "SmartHomeApi", "processUnAuthorized onFailure " + str7);
                                                        }

                                                        public final /* synthetic */ void onSuccess(Object obj) {
                                                            fdt.this.O000000o(netRequest3, fdh3);
                                                            LogType logType = LogType.NETWORK;
                                                            gsy.O00000o0(logType, "SmartHomeApi", "processUnAuthorized onSuccess " + str7);
                                                        }
                                                    });
                                                } else {
                                                    fdt.O000000o(fdh3, response);
                                                }
                                                try {
                                                    LogType logType = LogType.NETWORK;
                                                    gsy.O00000o0(logType, "SmartHomeApi", "http request fail: path=" + netRequest3.O00000Oo + "\n,httpcode=" + response.code() + "\n,responseStr=" + str);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                if (response.body() != null) {
                                                    response.close();
                                                    return;
                                                }
                                                return;
                                            }
                                            ResponseBody body = response.body();
                                            try {
                                                String string = body.string();
                                                if (body != null) {
                                                    body.close();
                                                }
                                                if (!z) {
                                                    try {
                                                        string = fdt.O000000o(miServiceTokenInfo2, header2, string, (String) pair.second);
                                                    } catch (Exception e2) {
                                                        fdh fdh = fdh3;
                                                        if (fdh != null) {
                                                            fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), Log.getStackTraceString(e2)));
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                }
                                                if ((gfr.O0000OOo || gfr.O0000Oo) && !TextUtils.isEmpty(string)) {
                                                    StringBuilder sb2 = new StringBuilder("Request-Id:");
                                                    sb2.append(header);
                                                    sb2.append(" host:");
                                                    if (request.url() != null) {
                                                        str2 = request.url().host();
                                                    }
                                                    sb2.append(str2);
                                                    sb2.append(" ");
                                                    sb2.append(netRequest3.toString());
                                                    gsy.O00000Oo("MIIO", sb2.toString());
                                                    gsy.O00000Oo("MIIO", fdt.O000000o(string));
                                                }
                                                NetResult netResult = new NetResult();
                                                netResult.O00000o0 = string;
                                                fdh fdh2 = fdh3;
                                                if (fdh2 != null) {
                                                    fdh2.onSuccess(netResult);
                                                }
                                            } catch (Exception e3) {
                                                if (fdh3 != null) {
                                                    fdh3.onFailure(new NetError(ErrorCode.INVALID.getCode(), Log.getStackTraceString(e3)));
                                                }
                                                if (body != null) {
                                                    body.close();
                                                }
                                            } catch (Throwable th) {
                                                if (body != null) {
                                                    body.close();
                                                }
                                                throw th;
                                            }
                                        }
                                    });
                                    fdi fdi2 = new fdi(newCall);
                                    CommonApplication.getGlobalWorkerHandler().postDelayed(new Runnable() {
                                        /* class _m_j.fdt.AnonymousClass3 */

                                        public final void run() {
                                            fcn.O000000o().O0000OoO();
                                        }
                                    }, 1000);
                                    return fdi2;
                                }
                                request = request2;
                                if (request == null) {
                                }
                            }
                        } catch (UnsupportedEncodingException unused2) {
                            z2 = false;
                            str2 = str8;
                            i = 0;
                            if (timeZone != null) {
                            }
                            gsr.O000000o(this.O0000Oo0, O00000o(), "timezone", str2, ".io.mi.com", "/");
                            gsr.O000000o(this.O0000Oo0, O00000o(), "is_daylight", z2 ? "1" : "0", ".io.mi.com", "/");
                            gsr.O000000o(this.O0000Oo0, O00000o(), "dst_offset", String.valueOf(i), ".io.mi.com", "/");
                            str3 = fcn.O000000o().O0000o00();
                            if (!TextUtils.isEmpty(str3)) {
                            }
                            gsr.O000000o(this.O0000Oo0, O00000o(), "channel", gfr.O0000o0O, ".io.mi.com", "/");
                            O000000o(true);
                            this.O0000Oo = miServiceTokenInfo;
                            miServiceTokenInfo2 = miServiceTokenInfo;
                            if (!gfr.O0000Oo0) {
                            }
                            pair = O00000Oo(miServiceTokenInfo2, netRequest2);
                            z = false;
                            if (pair != null) {
                            }
                        }
                        if (timeZone != null) {
                            gsr.O000000o(this.O0000Oo0, O00000o(), "timezone_id", timeZone.getID(), ".io.mi.com", "/");
                        }
                        gsr.O000000o(this.O0000Oo0, O00000o(), "timezone", str2, ".io.mi.com", "/");
                        gsr.O000000o(this.O0000Oo0, O00000o(), "is_daylight", z2 ? "1" : "0", ".io.mi.com", "/");
                        gsr.O000000o(this.O0000Oo0, O00000o(), "dst_offset", String.valueOf(i), ".io.mi.com", "/");
                        try {
                            str3 = fcn.O000000o().O0000o00();
                        } catch (Exception unused3) {
                            str3 = null;
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            gsr.O000000o(this.O0000Oo0, O00000o(), "PassportDeviceId", str3, ".io.mi.com", "/");
                        }
                        gsr.O000000o(this.O0000Oo0, O00000o(), "channel", gfr.O0000o0O, ".io.mi.com", "/");
                        O000000o(true);
                        this.O0000Oo = miServiceTokenInfo;
                    }
                }
                if (fdh2 != null) {
                    fdh2.onFailure(new NetError(ErrorCode.INVALID.getCode(), "uid or serviceToken is null!"));
                }
                fdi fdi3 = new fdi(null);
                return fdi3;
            }
            miServiceTokenInfo2 = miServiceTokenInfo;
        }
    }
}

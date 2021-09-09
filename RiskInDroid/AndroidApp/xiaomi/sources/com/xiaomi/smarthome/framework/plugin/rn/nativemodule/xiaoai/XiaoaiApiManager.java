package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai;

import _m_j.fkb;
import _m_j.fyc;
import _m_j.gar;
import _m_j.gdt;
import _m_j.gdv;
import _m_j.goq;
import _m_j.gtx;
import _m_j.gty;
import _m_j.ibh;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Dispatcher;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class XiaoaiApiManager {
    private static volatile XiaoaiApiManager O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile boolean f8449O000000o;
    public Map<String, AccountInfo> O00000Oo = new ConcurrentHashMap();
    public List<gar> O00000o0 = new ArrayList();
    private volatile OkHttpClient O00000oO;
    private CookieJar O00000oo = new O00000o0();

    private XiaoaiApiManager() {
        ((gdt) gdv.f17570O000000o.getServiceInterface()).O00000o();
    }

    public static XiaoaiApiManager O000000o() {
        if (O00000o == null) {
            synchronized (XiaoaiApiManager.class) {
                if (O00000o == null) {
                    O00000o = new XiaoaiApiManager();
                }
            }
        }
        return O00000o;
    }

    static class O00000o0 implements CookieJar {

        /* renamed from: O000000o  reason: collision with root package name */
        private Map<String, List<Cookie>> f8459O000000o = new ConcurrentHashMap();

        O00000o0() {
        }

        public final void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            this.f8459O000000o.put(httpUrl.scheme() + "://" + httpUrl.host(), list);
        }

        public final List<Cookie> loadForRequest(HttpUrl httpUrl) {
            return this.f8459O000000o.get(httpUrl.scheme() + "://" + httpUrl.host());
        }
    }

    static class O000000o implements Interceptor {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder newBuilder = request.newBuilder();
            if (request.method().equals("GET")) {
                newBuilder.url(request.url().newBuilder().addQueryParameter("requestId", XiaoaiApiManager.O00000Oo()).build());
            } else if (request.method().equals("POST") || request.method().equals("PUT")) {
                RequestBody body = request.body();
                if (body instanceof FormBody) {
                    FormBody.Builder builder = new FormBody.Builder();
                    FormBody formBody = (FormBody) body;
                    for (int i = 0; i < formBody.size(); i++) {
                        builder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
                    }
                    newBuilder.post(builder.addEncoded("requestId", XiaoaiApiManager.O00000Oo()).build());
                }
            }
            return chain.proceed(newBuilder.build());
        }
    }

    public static String O00000Oo() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    private OkHttpClient O00000o0() {
        if (this.O00000oO == null) {
            synchronized ("XiaoaiApiManager") {
                if (this.O00000oO == null) {
                    Dispatcher dispatcher = new Dispatcher(goq.O000000o());
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    fkb.O000000o(builder);
                    this.O00000oO = builder.dispatcher(dispatcher).retryOnConnectionFailure(true).connectTimeout(5, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).addInterceptor(new O000000o((byte) 0)).addInterceptor(new O00000Oo()).cookieJar(this.O00000oo).build();
                }
            }
        }
        return this.O00000oO;
    }

    class InvalidAuthTokenException extends IOException {
        private InvalidAuthTokenException() {
        }

        /* synthetic */ InvalidAuthTokenException(XiaoaiApiManager xiaoaiApiManager, byte b) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public final Observable<Response> O000000o(Request request, String str, Map<String, Object> map) {
        final HttpUrl url = request.url();
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        return O000000o(url, str, map).flatMap(new Function(url, atomicInteger, request) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.$$Lambda$XiaoaiApiManager$sZ38zwywyAe1DaAaRxUjgogaNM */
            private final /* synthetic */ HttpUrl f$1;
            private final /* synthetic */ AtomicInteger f$2;
            private final /* synthetic */ Request f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object apply(Object obj) {
                return XiaoaiApiManager.this.O000000o(this.f$1, this.f$2, this.f$3, (List) obj);
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.XiaoaiApiManager.AnonymousClass1 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                return ((Observable) obj).flatMap(new Function<Throwable, ObservableSource<?>>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.XiaoaiApiManager.AnonymousClass1.AnonymousClass1 */

                    public final /* synthetic */ Object apply(Object obj) throws Exception {
                        Throwable th = (Throwable) obj;
                        if (!(th instanceof InvalidAuthTokenException) || atomicInteger.getAndDecrement() <= 0) {
                            fyc.O00000Oo("XiaoaiApiManager", "sendRequest error,needn't retry,retryCounts:" + atomicInteger.get() + ",error:" + Log.getStackTraceString(th));
                            return Observable.error(th);
                        }
                        fyc.O00000Oo("XiaoaiApiManager", "need retry sendRequest, try refreshAccountInfoCache");
                        if (!XiaoaiApiManager.this.f8449O000000o) {
                            return Observable.create(new ObservableOnSubscribe<MiServiceTokenInfo>(XiaoaiApiManager.O000000o(url)) {
                                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.XiaoaiApiManager.AnonymousClass3 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ String f8453O000000o;

                                {
                                    this.f8453O000000o = r2;
                                }

                                public final void subscribe(final ObservableEmitter<MiServiceTokenInfo> observableEmitter) throws Exception {
                                    if (CoreApi.O000000o().O0000oO0()) {
                                        fyc.O00000Oo("XiaoaiApiManager", "systemAccount,do refreshAccountInfoCache");
                                        XiaoaiApiManager.this.f8449O000000o = true;
                                        ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o(this.f8453O000000o, CoreApi.O000000o().O000000o(this.f8453O000000o), new MessageCallback() {
                                            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.XiaoaiApiManager.AnonymousClass3.AnonymousClass1 */

                                            public final void onSuccess(Intent intent) {
                                                XiaoaiApiManager.this.O00000Oo.clear();
                                                XiaoaiApiManager.this.f8449O000000o = false;
                                                MiServiceTokenInfo miServiceTokenInfo = new MiServiceTokenInfo();
                                                miServiceTokenInfo.O00000o0 = intent.getStringExtra("serviceToken");
                                                miServiceTokenInfo.O00000Oo = intent.getStringExtra("cUserId");
                                                miServiceTokenInfo.O00000o = intent.getStringExtra("ssecurity");
                                                observableEmitter.onNext(miServiceTokenInfo);
                                                observableEmitter.onComplete();
                                            }

                                            public final void onFailure(int i, String str) {
                                                XiaoaiApiManager.this.O00000Oo.clear();
                                                XiaoaiApiManager.this.f8449O000000o = false;
                                                fyc.O00000o0("XiaoaiApiManager", "refreshAccountInfoCache,refreshServiceTokenBySystemAccountNew: onFailure ".concat(String.valueOf(str)));
                                                observableEmitter.onNext(null);
                                                observableEmitter.onComplete();
                                            }
                                        });
                                        return;
                                    }
                                    XiaoaiApiManager.this.O00000Oo.clear();
                                    observableEmitter.onNext(null);
                                    observableEmitter.onComplete();
                                }
                            });
                        }
                        fyc.O00000Oo("XiaoaiApiManager", "need retry sendRequest, wait then retry");
                        return Observable.timer(3, TimeUnit.SECONDS);
                    }
                });
            }
        }).subscribeOn(Schedulers.io());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O000000o(HttpUrl httpUrl, AtomicInteger atomicInteger, Request request, List list) throws Exception {
        OkHttpClient O00000o02 = O00000o0();
        O00000o02.cookieJar().saveFromResponse(httpUrl, list);
        return Observable.create(new ObservableOnSubscribe(atomicInteger, httpUrl, O00000o02, request) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.$$Lambda$XiaoaiApiManager$HN1574rQDuy4ZWOpIXXgGZ8oBUY */
            private final /* synthetic */ AtomicInteger f$1;
            private final /* synthetic */ HttpUrl f$2;
            private final /* synthetic */ OkHttpClient f$3;
            private final /* synthetic */ Request f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                XiaoaiApiManager.this.O000000o(this.f$1, this.f$2, this.f$3, this.f$4, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(AtomicInteger atomicInteger, HttpUrl httpUrl, OkHttpClient okHttpClient, Request request, final ObservableEmitter observableEmitter) throws Exception {
        if (atomicInteger.get() == 0) {
            fyc.O000000o("XiaoaiApiManager", "retry sendRequest:" + httpUrl.host());
        }
        okHttpClient.newCall(request).enqueue(new Callback() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.XiaoaiApiManager.AnonymousClass2 */

            public final void onFailure(Call call, IOException iOException) {
                observableEmitter.onError(iOException);
            }

            public final void onResponse(Call call, Response response) throws IOException {
                if (response == null || response.code() != 401) {
                    observableEmitter.onNext(response);
                    observableEmitter.onComplete();
                    return;
                }
                fyc.O00000o0("XiaoaiApiManager", "sendRequest error: 401");
                response.close();
                observableEmitter.onError(new InvalidAuthTokenException(XiaoaiApiManager.this, (byte) 0));
            }
        });
    }

    public static String O000000o(HttpUrl httpUrl) {
        String sid = XiaoaiServer.fromUrl(httpUrl.scheme() + "://" + httpUrl.host()).getSid();
        return TextUtils.isEmpty(sid) ? XiaoaiServer.NORMAL.getSid() : sid;
    }

    public static Map<String, Object> O000000o(Map<String, Object> map) {
        Map<String, Object> map2 = null;
        if (map != null && map.containsKey("cookie")) {
            Object obj = map.get("cookie");
            if (obj instanceof Map) {
                map2 = (Map) obj;
            }
            map.remove("cookie");
        }
        return map2;
    }

    public final Observable<Response> O000000o(String str, String str2, Map<String, Object> map, String str3, Map<String, Object> map2) {
        HttpUrl.Builder builder;
        if (TextUtils.isEmpty(str2)) {
            builder = HttpUrl.parse(str).newBuilder();
        } else if (str2.startsWith("/")) {
            builder = HttpUrl.parse(str + str2).newBuilder();
        } else {
            builder = HttpUrl.parse(str + "/" + str2).newBuilder();
        }
        if (map != null && !map.isEmpty()) {
            O000000o(builder, map);
        }
        HttpUrl build = builder.build();
        Request.Builder builder2 = new Request.Builder();
        builder2.url(build);
        builder2.get();
        return O000000o(builder2.build(), str3, map2);
    }

    static RequestBody O00000Oo(Map<String, Object> map) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if (obj != null) {
                builder.add(next, obj.toString());
            }
        }
        return builder.build();
    }

    private Observable<List<Cookie>> O000000o(HttpUrl httpUrl, String str, Map<String, Object> map) {
        Observable observable;
        ArrayList arrayList = new ArrayList();
        final String O000000o2 = O000000o(httpUrl);
        Cookie.Builder builder = new Cookie.Builder();
        builder.domain(httpUrl.host());
        if (httpUrl.isHttps()) {
            builder.secure();
        }
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = map.get(next);
                if (obj != null) {
                    builder.name(next).value(obj.toString());
                    arrayList.add(builder.build());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (TextUtils.isEmpty(O000000o2)) {
            observable = Observable.just(null);
        } else {
            observable = Observable.create(new ObservableOnSubscribe<AccountInfo>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.XiaoaiApiManager.AnonymousClass4 */

                public final void subscribe(final ObservableEmitter<AccountInfo> observableEmitter) throws Exception {
                    AccountInfo accountInfo = XiaoaiApiManager.this.O00000Oo.get(O000000o2);
                    if (accountInfo != null) {
                        observableEmitter.onNext(accountInfo);
                        observableEmitter.onComplete();
                        return;
                    }
                    gtx O000000o2 = gty.O000000o();
                    if (O000000o2 != null) {
                        O000000o2.getAccount(CommonApplication.getAppContext(), O000000o2, new ibh<AccountInfo, Error>() {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.XiaoaiApiManager.AnonymousClass4.AnonymousClass1 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                AccountInfo accountInfo = (AccountInfo) obj;
                                XiaoaiApiManager.this.O00000Oo.put(O000000o2, accountInfo);
                                observableEmitter.onNext(accountInfo);
                                observableEmitter.onComplete();
                            }

                            public final void onFailure(Error error) {
                                fyc.O00000o0("XiaoaiApiManager", "request account info error,code:" + error.f12083O000000o + "msg:" + error.O00000Oo);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("code", error.f12083O000000o);
                                    jSONObject.put("message", error.O00000Oo);
                                } catch (JSONException e) {
                                    fyc.O000000o("XiaoaiApiManager", "request account info,set errorJson error:", e);
                                }
                                observableEmitter.onError(new IOException(jSONObject.toString()));
                            }
                        });
                    }
                }
            });
        }
        return observable.flatMap(new Function(arrayList2, builder, str) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.$$Lambda$XiaoaiApiManager$hoiegY47NjYEmF1To6C0mSxPY0M */
            private final /* synthetic */ List f$1;
            private final /* synthetic */ Cookie.Builder f$2;
            private final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object apply(Object obj) {
                return XiaoaiApiManager.this.O000000o(this.f$1, this.f$2, this.f$3, (AccountInfo) obj);
            }
        }).map(new Function(arrayList2, arrayList) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.$$Lambda$XiaoaiApiManager$W82W9edxX3NMny3FFV7VflHoQcI */
            private final /* synthetic */ List f$1;
            private final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object apply(Object obj) {
                return XiaoaiApiManager.O000000o(Cookie.Builder.this, this.f$1, this.f$2, (gar) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O000000o(List list, Cookie.Builder builder, String str, AccountInfo accountInfo) throws Exception {
        Observable<R> observable;
        list.clear();
        if (accountInfo != null) {
            String userId = accountInfo.getUserId();
            if (TextUtils.isEmpty(userId)) {
                userId = XmPluginHostApi.instance().getAccountId();
            }
            if (!TextUtils.isEmpty(userId)) {
                builder.name("userId").value(userId);
                list.add(builder.build());
            }
            String encryptedUserId = accountInfo.getEncryptedUserId();
            if (!TextUtils.isEmpty(encryptedUserId)) {
                builder.name("cUserId").value(encryptedUserId);
                list.add(builder.build());
            }
            String serviceToken = accountInfo.getServiceToken();
            if (!TextUtils.isEmpty(serviceToken)) {
                builder.name("serviceToken").value(serviceToken);
                list.add(builder.build());
            }
        }
        if (TextUtils.isEmpty(str)) {
            return Observable.just(gar.f17470O000000o);
        }
        if (this.O00000o0.size() > 0) {
            observable = Observable.just(new ArrayList(this.O00000o0));
        } else {
            observable = O000000o(XiaoaiServer.NORMAL.getUrl(), "admin/v2/device_list", (Map<String, Object>) null, "", (Map<String, Object>) null).map(new Function<Response, List<gar>>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.XiaoaiApiManager.AnonymousClass5 */

                public final /* synthetic */ Object apply(Object obj) throws Exception {
                    JSONArray jSONArray = new JSONObject(((Response) obj).body().string()).getJSONArray("data");
                    ArrayList arrayList = new ArrayList();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(gar.O000000o(jSONArray.getJSONObject(i)));
                    }
                    XiaoaiApiManager.this.O00000o0 = new ArrayList(arrayList);
                    return arrayList;
                }
            });
        }
        return observable.map(new Function(str) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.$$Lambda$XiaoaiApiManager$K_NFfKnhLDP3aIAs2t4fb9Z2nmw */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return XiaoaiApiManager.O000000o(this.f$0, (List) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List O000000o(Cookie.Builder builder, List list, List list2, gar gar) throws Exception {
        if (gar != gar.f17470O000000o) {
            if (!TextUtils.isEmpty(gar.O00000Oo)) {
                builder.name("deviceId").value(gar.O00000Oo);
                list.add(builder.build());
            }
            if (!TextUtils.isEmpty(gar.O00000o)) {
                builder.name("sn").value(gar.O00000o);
                list.add(builder.build());
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        arrayList.addAll(list);
        return arrayList;
    }

    private static int O000000o(HttpUrl.Builder builder, Map<String, Object> map) {
        int i = 0;
        if (builder == null) {
            return 0;
        }
        if (map != null && !map.isEmpty()) {
            for (String next : map.keySet()) {
                String obj = map.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(obj)) {
                    builder.addEncodedQueryParameter(next, obj);
                    i++;
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ gar O000000o(String str, List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            gar gar = (gar) it.next();
            if (str.equalsIgnoreCase(gar.O00000o0)) {
                return gar;
            }
        }
        return gar.f17470O000000o;
    }

    public static class O00000Oo implements Interceptor {

        /* renamed from: O000000o  reason: collision with root package name */
        private final String f8458O000000o = ("MICO/AndroidApp/" + "mijia" + "/" + O000000o());

        public final Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().header("User-Agent", this.f8458O000000o).build());
        }

        private static String O000000o() {
            try {
                return CommonApplication.getAppContext().getPackageManager().getPackageInfo(CommonApplication.getAppContext().getPackageName(), 0).versionName;
            } catch (Exception unused) {
                return "";
            }
        }
    }
}

package com.xiaomi.mico.api;

import _m_j.ahg;
import _m_j.ahh;
import _m_j.fkb;
import _m_j.goq;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.adapter.rxjava.RxJavaEnqueueCallAdapterFactory;
import com.xiaomi.mico.api.interceptor.LoggingInterceptor;
import com.xiaomi.mico.api.interceptor.ParamsInterceptor;
import com.xiaomi.mico.api.interceptor.UAInterceptor;
import com.xiaomi.mico.api.logger.AndroidAccountLog;
import com.xiaomi.mico.api.logger.AndroidApiLogger;
import com.xiaomi.mico.api.logger.ApiLogger;
import com.xiaomi.mico.api.model.MinaResponse;
import com.xiaomi.mico.api.service.MiHomeService;
import com.xiaomi.mico.api.service.MinaService;
import com.xiaomi.smarthome.application.CommonApplication;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApiManager {
    public static final HttpLoggingInterceptor HTTP_LOGGING_INTERCEPTOR = new HttpLoggingInterceptor($$Lambda$ApiManager$MMMwL50g4bcxXNq9h3QycoY1emY.INSTANCE).setLevel(HttpLoggingInterceptor.Level.HEADERS);
    private static final ahg LOGGER_NEW = new ahg();
    @SuppressLint({"StaticFieldLeak"})
    private static ApiManager sInstance;
    @SuppressLint({"StaticFieldLeak"})
    private static ThirdPartyApiManager sThirdPartyInstance;
    private Gson gson;
    private CookieJar mApiCookieJar;
    private final ApiLogger mApiLogger;
    private final Context mContext;
    private final Scheduler mDispatcherScheduler;
    private final LoginManager mLoginManager;
    private OkHttpClient mOkHttpClient;
    private ConcurrentHashMap<String, Object> mServiceMap = new ConcurrentHashMap<>();

    public static void init(Context context, AccountLog accountLog, ApiLogger apiLogger) {
        if (sInstance == null) {
            if (accountLog == null) {
                accountLog = new AndroidAccountLog("Mico-Account");
            }
            if (apiLogger == null) {
                apiLogger = new AndroidApiLogger("Mico-Api");
            }
            sInstance = new ApiManager(context, apiLogger, accountLog);
            sThirdPartyInstance = new ThirdPartyApiManager(context, apiLogger);
        }
    }

    public static boolean isInited() {
        return sInstance != null;
    }

    public static ApiManager getInstance() {
        if (sInstance == null) {
            init(CommonApplication.getAppContext(), null, null);
        }
        return sInstance;
    }

    public static ThirdPartyApiManager getThirdPartyInstance() {
        ThirdPartyApiManager thirdPartyApiManager = sThirdPartyInstance;
        if (thirdPartyApiManager != null) {
            return thirdPartyApiManager;
        }
        throw new IllegalStateException("ApiManager has not been initialized.");
    }

    private ApiManager(Context context, ApiLogger apiLogger, AccountLog accountLog) {
        this.mContext = context;
        this.mApiLogger = apiLogger;
        DispatcherThread dispatcherThread = new DispatcherThread();
        dispatcherThread.start();
        Looper looper = dispatcherThread.getLooper();
        this.mDispatcherScheduler = AndroidSchedulers.from(looper);
        this.mLoginManager = LoginManager.init(this.mContext, this.mDispatcherScheduler, new Handler(looper), accountLog);
        Dispatcher dispatcher = new Dispatcher(goq.O000000o());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        this.mOkHttpClient = builder.dispatcher(dispatcher).retryOnConnectionFailure(true).connectTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS).readTimeout(25, TimeUnit.SECONDS).addInterceptor(new UAInterceptor(context)).addInterceptor(new ParamsInterceptor()).addInterceptor(new LoggingInterceptor(this.mApiLogger)).cookieJar(this.mLoginManager).build();
        this.gson = new GsonBuilder().serializeNulls().create();
    }

    public OkHttpClient getOkHttpClient() {
        return this.mOkHttpClient;
    }

    public void switchMinaEnv(int i) {
        if (ApiConstants.switchServerEnv(i)) {
            this.mLoginManager.onServerEnvSwitched();
        }
    }

    public LoginManager getLoginManager() {
        return this.mLoginManager;
    }

    public <T, S> ApiRequest<T> enqueue(ApiProviderV2<T, S> apiProviderV2, Class<S> cls, ApiRequest.Listener<T> listener) {
        return doEnqueue(apiProviderV2.observable(getService(cls)), listener);
    }

    private <T> ApiRequest<T> doEnqueue(final Observable<Response<MinaResponse<T>>> observable, ApiRequest.Listener<T> listener) {
        final ApiRequest<T> apiRequest = new ApiRequest<>(this.mApiLogger, this.mLoginManager, listener);
        Observable.create(new Observable.OnSubscribe<Object>() {
            /* class com.xiaomi.mico.api.ApiManager.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super Object>) ((Subscriber) obj));
            }

            public void call(Subscriber<? super Object> subscriber) {
                try {
                    apiRequest.setObservable(observable);
                    if (!apiRequest.isCanceled()) {
                        apiRequest.subscribe();
                    }
                    subscriber.onNext(null);
                    subscriber.onCompleted();
                } catch (Throwable th) {
                    subscriber.onError(th);
                }
            }
        }).subscribeOn(this.mDispatcherScheduler).subscribe();
        return apiRequest;
    }

    public <S> S getService(Class<S> cls) {
        String str = ApiConstants.isProductionEnv() ? "" : "preview";
        if (TextUtils.equals(cls.getSimpleName(), MiHomeService.class.getSimpleName()) && MiHomeService.CC.usingStgDev()) {
            str = "st";
        }
        String format = String.format("%s_%s", cls.getSimpleName(), str);
        S s = this.mServiceMap.get(format);
        if (s != null) {
            return s;
        }
        ApiConstants.ServiceConfig serviceConfigByCls = ApiConstants.getServiceConfigByCls(cls);
        Retrofit.Builder builder = new Retrofit.Builder();
        String baseUrl = ApiConstants.isProductionEnv() ? serviceConfigByCls.getBaseUrl() : serviceConfigByCls.getPreviewUrl();
        if (cls.getSimpleName().equals(MiHomeService.class.getSimpleName())) {
            baseUrl = MiHomeService.CC.getHostUrl();
        }
        builder.baseUrl(baseUrl);
        S create = builder.client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create(this.gson)).addCallAdapterFactory(RxJavaEnqueueCallAdapterFactory.create()).build().create(cls);
        this.mServiceMap.put(format, create);
        return create;
    }

    public void clearService() {
        this.mServiceMap.clear();
    }

    public <T> ApiRequest<T> enqueue(ApiProvider<T> apiProvider, ApiRequest.Listener<T> listener) {
        return doEnqueue(apiProvider.observable((MinaService) getService(MinaService.class)), listener);
    }

    public static class DispatcherThread extends HandlerThread {
        public DispatcherThread() {
            super("dispatcher", 10);
        }
    }

    public static class ThirdPartyApiManager {
        private final ApiLogger mApiLogger;
        private final CookieJar mCookieJar;
        private final OkHttpClient mOkHttpClient;
        private ConcurrentHashMap<String, Object> mServiceMap;

        private ThirdPartyApiManager(Context context, ApiLogger apiLogger) {
            this.mServiceMap = new ConcurrentHashMap<>();
            this.mApiLogger = apiLogger;
            this.mCookieJar = new DefaultCookiJar();
            Dispatcher dispatcher = new Dispatcher(goq.O000000o());
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            fkb.O000000o(builder);
            OkHttpClient.Builder cookieJar = builder.dispatcher(dispatcher).retryOnConnectionFailure(true).connectTimeout(5, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).addInterceptor(new UAInterceptor(context)).addInterceptor(new LoggingInterceptor(this.mApiLogger)).cookieJar(this.mCookieJar);
            cookieJar.addInterceptor(ApiManager.HTTP_LOGGING_INTERCEPTOR);
            this.mOkHttpClient = cookieJar.build();
        }

        public void setCookie(String str, Cookie cookie) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(cookie);
            setCookie(str, arrayList);
        }

        public void setCookie(String str, List<Cookie> list) {
            HttpUrl httpUrl = HttpUrl.get(URI.create(str));
            if (httpUrl == null) {
                new Object[1][0] = "cannot set cookie for " + str + ", failed to parse as HttpUrl";
                return;
            }
            this.mCookieJar.saveFromResponse(httpUrl, list);
        }

        public <T> T getService(Class<T> cls, String str) {
            String simpleName = cls.getSimpleName();
            T t = this.mServiceMap.get(simpleName);
            if (t != null) {
                return t;
            }
            Retrofit.Builder builder = new Retrofit.Builder();
            if (!TextUtils.isEmpty(str)) {
                builder.baseUrl(str);
            } else {
                builder.baseUrl(ApiConstants.getMicoBaseUrl());
            }
            T create = builder.client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io())).build().create(cls);
            this.mServiceMap.put(simpleName, create);
            return create;
        }

        public OkHttpClient getHttpClient() {
            return this.mOkHttpClient;
        }
    }

    public static class DefaultCookiJar implements CookieJar {
        private Set<CacheCookie> mCacheCookies = Collections.synchronizedSet(new HashSet());
        private Object mCookieLock = new Object();

        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            for (CacheCookie next : CacheCookie.decorateCookies(list)) {
                this.mCacheCookies.remove(next);
                this.mCacheCookies.add(next);
            }
        }

        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            Set<CacheCookie> set = this.mCacheCookies;
            if (set == null || set.isEmpty()) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<CacheCookie> it = this.mCacheCookies.iterator();
            while (it.hasNext()) {
                Cookie cookie = it.next().getCookie();
                if (cookie.expiresAt() < System.currentTimeMillis()) {
                    it.remove();
                } else if (cookie.matches(httpUrl)) {
                    arrayList.add(cookie);
                }
            }
            return arrayList;
        }
    }

    static {
        new ahh();
    }
}

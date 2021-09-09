package com.miui.tsmclient.common.net.internal.okhttp;

import _m_j.fkb;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.miui.tsmclient.account.AccountInfo;
import com.miui.tsmclient.account.AccountManagerFactory;
import com.miui.tsmclient.account.IAccountManager;
import com.miui.tsmclient.common.net.ErrorInfo;
import com.miui.tsmclient.common.net.HttpLifecycleManager;
import com.miui.tsmclient.common.net.IHttpClient;
import com.miui.tsmclient.common.net.RequestCallback;
import com.miui.tsmclient.common.net.host.Host;
import com.miui.tsmclient.common.net.request.BaseRequest;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.IOUtils;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.StringUtils;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.SecureRequest;
import com.xiaomi.accountsdk.utils.AESCoder;
import com.xiaomi.accountsdk.utils.CryptCoder;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpClientImpl implements IHttpClient {
    private IAccountManager mAccountManager;
    public ThreadLocalAuthInfo mAuthInfo = new ThreadLocalAuthInfo();
    private OkHttpClient mClient;
    private Context mContext;
    public Handler mHandler = new Handler(Looper.getMainLooper());

    class ThreadLocalAuthInfo extends ThreadLocal<AuthInfo> {
        private ThreadLocalAuthInfo() {
        }

        /* access modifiers changed from: protected */
        public AuthInfo initialValue() {
            return new AuthInfo();
        }

        public void setAccountInfo(AccountInfo accountInfo) {
            AuthInfo authInfo = (AuthInfo) get();
            authInfo.mAccountInfo = accountInfo;
            if (accountInfo == null || TextUtils.isEmpty(accountInfo.getSecurity())) {
                authInfo.mCoder = null;
            } else {
                authInfo.mCoder = new AESCoder(accountInfo.getSecurity());
            }
        }

        public AccountInfo getAccountInfo() {
            return ((AuthInfo) get()).mAccountInfo;
        }

        public CryptCoder getCoder() {
            return ((AuthInfo) get()).mCoder;
        }
    }

    static final class AuthInfo {
        public AccountInfo mAccountInfo;
        public CryptCoder mCoder;

        private AuthInfo() {
        }
    }

    public OkHttpClientImpl(Context context) {
        this.mContext = context;
        this.mAccountManager = AccountManagerFactory.createAccountManager();
        Cache cache = new Cache(context.getCacheDir(), 314572800);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        this.mClient = builder.cache(cache).addInterceptor(new HttpMonitorInterceptor()).addInterceptor(new TimeoutInterceptor()).addInterceptor(new RetryInterceptor(2)).addInterceptor(new CryptInterceptor()).addNetworkInterceptor(new CookieInterceptor()).addNetworkInterceptor(new PersistenceInterceptor()).build();
    }

    public <T> void enqueue(final BaseRequest<T> baseRequest) {
        this.mClient.newCall(getOkRequest(baseRequest)).enqueue(new Callback() {
            /* class com.miui.tsmclient.common.net.internal.okhttp.OkHttpClientImpl.AnonymousClass1 */

            public void onFailure(Call call, final IOException iOException) {
                LogUtils.v("Callback onFailure:" + baseRequest.getUrl());
                final RequestCallback callback = baseRequest.getCallback();
                if (callback != null) {
                    OkHttpClientImpl.this.mHandler.post(new Runnable() {
                        /* class com.miui.tsmclient.common.net.internal.okhttp.OkHttpClientImpl.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            IOException iOException = iOException;
                            callback.onFailed(new ErrorInfo(iOException instanceof InternalIOException ? ((InternalIOException) iOException).getErrorCode() : -1, iOException.getMessage()));
                        }
                    });
                }
            }

            public void onResponse(Call call, final Response response) throws IOException {
                LogUtils.v("Callback onResponse:" + baseRequest.getUrl() + "\n" + baseRequest.getResponse());
                final RequestCallback callback = baseRequest.getCallback();
                if (callback != null) {
                    OkHttpClientImpl.this.mHandler.post(new Runnable() {
                        /* class com.miui.tsmclient.common.net.internal.okhttp.OkHttpClientImpl.AnonymousClass1.AnonymousClass2 */

                        public void run() {
                            if (!response.isSuccessful() || baseRequest.getResult() == null) {
                                callback.onFailed(new ErrorInfo(-1, response.message()));
                            } else {
                                callback.onResponse(baseRequest.getResult());
                            }
                        }
                    });
                }
            }
        });
    }

    public <T> com.miui.tsmclient.common.net.Response<T> execute(BaseRequest<T> baseRequest) throws IOException {
        Response execute = this.mClient.newCall(getOkRequest(baseRequest)).execute();
        if (execute != null) {
            try {
                execute.close();
            } catch (Exception e) {
                LogUtils.e("close response failed on execute", e);
            }
        }
        return baseRequest.getResponse();
    }

    public void cancel(BaseRequest baseRequest) {
        Dispatcher dispatcher = this.mClient.dispatcher();
        for (Call next : dispatcher.queuedCalls()) {
            if (baseRequest == next.request().tag()) {
                next.cancel();
            }
        }
        for (Call next2 : dispatcher.runningCalls()) {
            if (baseRequest == next2.request().tag()) {
                next2.cancel();
            }
        }
    }

    public static BaseRequest<?> getBaseRequest(Request request) throws IOException {
        if (request != null) {
            Object tag = request.tag();
            if (tag instanceof BaseRequest) {
                return (BaseRequest) tag;
            }
        }
        throw new IOException("getBaseRequest failed");
    }

    public static boolean isAuthRequired(Request request) throws IOException {
        return getBaseRequest(request).isAuth();
    }

    public static boolean isCryptRequired(Request request) throws IOException {
        return getBaseRequest(request).isCrypt();
    }

    private Request getOkRequest(BaseRequest baseRequest) {
        return new Request.Builder().url(baseRequest.getUrl()).tag(baseRequest).build();
    }

    public void doPreRetry() {
        AccountInfo accountInfo = this.mAuthInfo.getAccountInfo();
        this.mAccountManager.resetAccount(this.mContext, accountInfo == null ? null : accountInfo.getAuthToken());
        this.mAuthInfo.setAccountInfo(null);
    }

    public void loadAccountInfo(Host host) throws IOException {
        AccountInfo loadAccountInfo = this.mAccountManager.loadAccountInfo(this.mContext, host.getServiceId());
        if (loadAccountInfo == null || !loadAccountInfo.isValid()) {
            throw new InternalIOException(14, "Getting account info failed");
        }
        this.mAuthInfo.setAccountInfo(loadAccountInfo);
    }

    static class TimeoutInterceptor implements Interceptor {
        private TimeoutInterceptor() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            BaseRequest<?> baseRequest = OkHttpClientImpl.getBaseRequest(request);
            int connectTimeout = baseRequest.getConnectTimeout() >= 0 ? baseRequest.getConnectTimeout() : C.MSG_CUSTOM_BASE;
            int i = 60000;
            int readTimeout = baseRequest.getReadTimeout() >= 0 ? baseRequest.getReadTimeout() : 60000;
            if (baseRequest.getWriteTimeout() >= 0) {
                i = baseRequest.getWriteTimeout();
            }
            return chain.withConnectTimeout(connectTimeout, TimeUnit.MILLISECONDS).withReadTimeout(readTimeout, TimeUnit.MILLISECONDS).withWriteTimeout(i, TimeUnit.MILLISECONDS).proceed(request);
        }
    }

    class RetryInterceptor implements Interceptor {
        private final int maxRetry;

        RetryInterceptor(int i) {
            this.maxRetry = i;
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            Response proceed = chain.proceed(request);
            int i = 1;
            if (OkHttpClientImpl.isAuthRequired(request)) {
                while (needRetry(i, proceed)) {
                    try {
                        proceed.close();
                    } catch (Exception e) {
                        LogUtils.e("close HTTP_UNAUTHORIZED response failed on RetryInterceptor", e);
                    }
                    i++;
                    OkHttpClientImpl.this.doPreRetry();
                    proceed = chain.proceed(request);
                }
            }
            LogUtils.t("RetryInterceptor requestCount:".concat(String.valueOf(i)));
            return proceed;
        }

        private boolean needRetry(int i, Response response) {
            return response != null && response.code() == 401 && i < this.maxRetry;
        }
    }

    class CryptInterceptor implements Interceptor {
        private CryptInterceptor() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request;
            String str;
            Request request2 = chain.request();
            BaseRequest<?> baseRequest = OkHttpClientImpl.getBaseRequest(request2);
            boolean isAuthRequired = OkHttpClientImpl.isAuthRequired(request2);
            boolean isCryptRequired = OkHttpClientImpl.isCryptRequired(request2);
            baseRequest.addExtraParams();
            Map<String, String> params = baseRequest.getParams();
            if (isAuthRequired) {
                OkHttpClientImpl.this.loadAccountInfo(baseRequest.getHost());
                AccountInfo accountInfo = OkHttpClientImpl.this.mAuthInfo.getAccountInfo();
                String userId = accountInfo.getUserId();
                if (!TextUtils.isEmpty(userId)) {
                    params.put("userId", userId);
                    String ph = accountInfo.getPh();
                    if (!TextUtils.isEmpty(ph)) {
                        params.put(baseRequest.getHost().getServiceId() + "_ph", ph);
                    } else {
                        LogUtils.i("CryptInterceptor: ph is null");
                    }
                    if (!TextUtils.isEmpty(EnvironmentConfig.getClientId())) {
                        params.put("clientId", EnvironmentConfig.getClientId());
                        params.put("token", accountInfo.getAuthToken());
                    }
                    if (isCryptRequired) {
                        try {
                            params = SecureRequest.encryptParams(baseRequest.getMethod() == 0 ? "GET" : "POST", baseRequest.getUrl(), params, accountInfo.getSecurity(), OkHttpClientImpl.this.mAuthInfo.getCoder());
                        } catch (CipherException e) {
                            throw new IOException(e);
                        }
                    }
                } else {
                    LogUtils.e("CryptInterceptor: userId is null");
                    throw new InternalIOException(14, "userId is null");
                }
            }
            if (baseRequest.getMethod() == 0) {
                HttpUrl.Builder newBuilder = request2.url().newBuilder();
                for (Map.Entry next : params.entrySet()) {
                    newBuilder.addQueryParameter((String) next.getKey(), (String) next.getValue());
                }
                request = request2.newBuilder().url(newBuilder.build()).build();
            } else {
                FormBody.Builder builder = new FormBody.Builder();
                for (Map.Entry next2 : params.entrySet()) {
                    builder.add((String) next2.getKey(), (String) next2.getValue());
                }
                request = request2.newBuilder().post(builder.build()).build();
            }
            Response proceed = chain.proceed(request);
            StringBuilder sb = new StringBuilder();
            sb.append(request.method());
            sb.append(": ");
            sb.append(baseRequest.getUrl());
            sb.append("\nResponseStatus: ");
            if (proceed == null) {
                str = null;
            } else {
                str = proceed.toString();
            }
            sb.append(str);
            LogUtils.t(sb.toString());
            return processResponse(request, proceed);
        }

        private Response processResponse(Request request, Response response) throws IOException {
            if (response == null || !response.isSuccessful()) {
                return response;
            }
            BaseRequest<?> baseRequest = OkHttpClientImpl.getBaseRequest(request);
            ResponseBody body = response.body();
            if (body == null) {
                return response;
            }
            if (baseRequest.isStringResponse()) {
                String string = body.string();
                if (OkHttpClientImpl.isCryptRequired(request)) {
                    try {
                        string = ((AuthInfo) OkHttpClientImpl.this.mAuthInfo.get()).mCoder.decrypt(string);
                    } catch (CipherException e) {
                        LogUtils.e("error occurred on CryptInterceptor", e);
                        throw new IOException(e);
                    }
                }
                LogUtils.t("bodyStr: ".concat(String.valueOf(string)));
                LogUtils.t("----------");
                baseRequest.setResponse(string);
            } else {
                InputStream inputStream = null;
                try {
                    LogUtils.t("start parsing inputStream");
                    inputStream = body.byteStream();
                    if (inputStream != null) {
                        baseRequest.setResponse(inputStream, body.contentLength());
                    } else {
                        LogUtils.e("byteStream is null");
                        throw new IOException("byteStream failed");
                    }
                } finally {
                    IOUtils.closeQuietly(inputStream);
                }
            }
            return response;
        }
    }

    class CookieInterceptor implements Interceptor {
        private CookieInterceptor() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            if (OkHttpClientImpl.isAuthRequired(request)) {
                BaseRequest<?> baseRequest = OkHttpClientImpl.getBaseRequest(request);
                AccountInfo accountInfo = ((AuthInfo) OkHttpClientImpl.this.mAuthInfo.get()).mAccountInfo;
                baseRequest.addCookie("userId", accountInfo.getUserId());
                baseRequest.addCookie("serviceToken", accountInfo.getServiceToken());
                baseRequest.addCookie(baseRequest.getHost().getServiceId() + "_ph", accountInfo.getPh());
                request = request.newBuilder().header("Cookie", StringUtils.join(baseRequest.getCookies(), "; ")).build();
            }
            return chain.proceed(request);
        }
    }

    class PersistenceInterceptor implements Interceptor {
        private PersistenceInterceptor() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            BaseRequest<?> baseRequest = OkHttpClientImpl.getBaseRequest(request);
            Response proceed = chain.proceed(request);
            return (proceed == null || !baseRequest.isPersistence()) ? proceed : proceed.newBuilder().header("Cache-Control", "immutable").build();
        }
    }

    class HttpMonitorInterceptor implements Interceptor {
        private HttpMonitorInterceptor() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            boolean isConnected = OkHttpClientImpl.this.isConnected();
            Request request = chain.request();
            String httpUrl = request.url().toString();
            if (isConnected) {
                HttpLifecycleManager.getInstance().onStart(httpUrl);
            }
            Response proceed = chain.proceed(request);
            if (isConnected) {
                int code = proceed.code();
                HttpLifecycleManager.getInstance().onStop(httpUrl, code);
                LogUtils.t("request_url:" + httpUrl + " response_code: " + code);
            }
            return proceed;
        }
    }

    public boolean isConnected() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

package com.facebook.react.modules.network;

import _m_j.jbe;
import _m_j.jbg;
import android.net.Uri;
import android.util.Base64;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.StandardCharsets;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;

@ReactModule(name = "Networking")
public final class NetworkingModule extends ReactContextBaseJavaModule {
    private static CustomClientBuilder customClientBuilder;
    public final OkHttpClient mClient;
    private final ForwardingCookieHandler mCookieHandler;
    private final CookieJarContainer mCookieJarContainer;
    private final String mDefaultUserAgent;
    private final List<RequestBodyHandler> mRequestBodyHandlers;
    private final Set<Integer> mRequestIds;
    public final List<ResponseHandler> mResponseHandlers;
    public boolean mShuttingDown;
    private final List<UriHandler> mUriHandlers;
    private NetRequestReporter netRequestReporter;
    private NetworkModuleProxy networkModuleProxy;

    public interface CustomClientBuilder {
        void apply(OkHttpClient.Builder builder);
    }

    public interface NetworkModuleProxy {
        boolean doProxy(String str, String str2, OkHttpClient okHttpClient, Request request, RequestBody requestBody, DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i, Callback callback);
    }

    public interface RequestBodyHandler {
        boolean supports(ReadableMap readableMap);

        RequestBody toRequestBody(ReadableMap readableMap, String str);
    }

    public interface ResponseHandler {
        boolean supports(String str);

        WritableMap toResponseData(ResponseBody responseBody) throws IOException;
    }

    public interface UriHandler {
        WritableMap fetch(Uri uri) throws IOException;

        boolean supports(Uri uri, String str);
    }

    public static boolean shouldDispatch(long j, long j2) {
        return j2 + 100000000 < j;
    }

    public final String getName() {
        return "Networking";
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, String str, OkHttpClient okHttpClient, List<NetworkInterceptorCreator> list) {
        super(reactApplicationContext);
        this.mRequestBodyHandlers = new ArrayList();
        this.mUriHandlers = new ArrayList();
        this.mResponseHandlers = new ArrayList();
        this.netRequestReporter = null;
        this.networkModuleProxy = null;
        if (list != null) {
            OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
            for (NetworkInterceptorCreator create : list) {
                newBuilder.addNetworkInterceptor(create.create());
            }
            okHttpClient = newBuilder.build();
        }
        this.mClient = okHttpClient;
        this.mCookieHandler = new ForwardingCookieHandler(reactApplicationContext);
        this.mCookieJarContainer = (CookieJarContainer) this.mClient.cookieJar();
        this.mShuttingDown = false;
        this.mDefaultUserAgent = str;
        this.mRequestIds = new HashSet();
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, String str, OkHttpClient okHttpClient) {
        this(reactApplicationContext, str, okHttpClient, null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, null, OkHttpClientProvider.createClient(reactApplicationContext), null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, List<NetworkInterceptorCreator> list) {
        this(reactApplicationContext, null, OkHttpClientProvider.createClient(reactApplicationContext), list);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, String str) {
        this(reactApplicationContext, str, OkHttpClientProvider.createClient(reactApplicationContext), null);
    }

    public static void setCustomClientBuilder(CustomClientBuilder customClientBuilder2) {
        customClientBuilder = customClientBuilder2;
    }

    private static void applyCustomBuilder(OkHttpClient.Builder builder) {
        CustomClientBuilder customClientBuilder2 = customClientBuilder;
        if (customClientBuilder2 != null) {
            customClientBuilder2.apply(builder);
        }
    }

    public final void initialize() {
        this.mCookieJarContainer.setCookieJar(new JavaNetCookieJar(this.mCookieHandler));
    }

    public final void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
        cancelAllRequests();
        this.mCookieHandler.destroy();
        this.mCookieJarContainer.removeCookieJar();
        this.mRequestBodyHandlers.clear();
        this.mResponseHandlers.clear();
        this.mUriHandlers.clear();
    }

    public final void addUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.add(uriHandler);
    }

    public final void addRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.add(requestBodyHandler);
    }

    public final void addResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.add(responseHandler);
    }

    public final void removeUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.remove(uriHandler);
    }

    public final void removeRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.remove(requestBodyHandler);
    }

    public final void removeResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.remove(responseHandler);
    }

    public final void setNetRequestReporter(NetRequestReporter netRequestReporter2) {
        if (this.netRequestReporter == null) {
            this.netRequestReporter = netRequestReporter2;
        }
    }

    @ReactMethod
    public final void sendRequest(String str, String str2, int i, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z, int i2, boolean z2) {
        try {
            if (this.netRequestReporter != null) {
                this.netRequestReporter.reportNetRequest(str2);
            }
            sendRequestInternal(str, str2, i, readableArray, readableMap, str3, z, i2, z2);
        } catch (Throwable th) {
            FLog.e("NetworkingModule", "Failed to send url request: ".concat(String.valueOf(str2)), th);
            ResponseUtil.onRequestError(getEventEmitter(), i, th.getMessage(), th);
        }
    }

    public final void sendRequestInternal(String str, String str2, int i, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z, int i2, boolean z2) {
        RequestBodyHandler requestBodyHandler;
        RequestBody requestBody;
        OkHttpClient okHttpClient;
        AnonymousClass2 r2;
        Charset charset;
        final int i3 = i;
        ReadableMap readableMap2 = readableMap;
        final String str4 = str3;
        int i4 = i2;
        final DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter();
        try {
            Uri parse = Uri.parse(str2);
            for (UriHandler next : this.mUriHandlers) {
                if (next.supports(parse, str4)) {
                    ResponseUtil.onDataReceived(eventEmitter, i3, next.fetch(parse));
                    ResponseUtil.onRequestSuccess(eventEmitter, i3);
                    return;
                }
            }
            try {
                Request.Builder url = new Request.Builder().url(str2);
                if (i3 != 0) {
                    url.tag(Integer.valueOf(i));
                }
                OkHttpClient.Builder newBuilder = this.mClient.newBuilder();
                applyCustomBuilder(newBuilder);
                if (!z2) {
                    newBuilder.cookieJar(CookieJar.NO_COOKIES);
                }
                if (z) {
                    newBuilder.addNetworkInterceptor(new Interceptor() {
                        /* class com.facebook.react.modules.network.NetworkingModule.AnonymousClass1 */

                        public Response intercept(Interceptor.Chain chain) throws IOException {
                            Response proceed = chain.proceed(chain.request());
                            return proceed.newBuilder().body(new ProgressResponseBody(proceed.body(), new ProgressListener() {
                                /* class com.facebook.react.modules.network.NetworkingModule.AnonymousClass1.AnonymousClass1 */
                                long last = System.nanoTime();

                                public void onProgress(long j, long j2, boolean z) {
                                    long nanoTime = System.nanoTime();
                                    if ((z || NetworkingModule.shouldDispatch(nanoTime, this.last)) && !str4.equals("text")) {
                                        ResponseUtil.onDataReceivedProgress(eventEmitter, i3, j, j2);
                                        this.last = nanoTime;
                                    }
                                }
                            })).build();
                        }
                    });
                }
                if (i4 != this.mClient.connectTimeoutMillis()) {
                    newBuilder.connectTimeout((long) i4, TimeUnit.MILLISECONDS);
                }
                OkHttpClient build = newBuilder.build();
                Headers extractHeaders = extractHeaders(readableArray, readableMap2);
                if (extractHeaders == null) {
                    ResponseUtil.onRequestError(eventEmitter, i3, "Unrecognized headers format", null);
                    return;
                }
                String str5 = extractHeaders.get("content-type");
                String str6 = extractHeaders.get("content-encoding");
                url.headers(extractHeaders);
                if (readableMap2 != null) {
                    Iterator<RequestBodyHandler> it = this.mRequestBodyHandlers.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        requestBodyHandler = it.next();
                        if (requestBodyHandler.supports(readableMap2)) {
                            break;
                        }
                    }
                }
                requestBodyHandler = null;
                if (readableMap2 == null || str.toLowerCase().equals("get") || str.toLowerCase().equals("head")) {
                    requestBody = RequestBodyUtil.getEmptyBody(str);
                } else if (requestBodyHandler != null) {
                    requestBody = requestBodyHandler.toRequestBody(readableMap2, str5);
                } else if (readableMap2.hasKey("string")) {
                    if (str5 == null) {
                        ResponseUtil.onRequestError(eventEmitter, i3, "Payload is set but no content-type header specified", null);
                        return;
                    }
                    String string = readableMap2.getString("string");
                    MediaType parse2 = MediaType.parse(str5);
                    if (RequestBodyUtil.isGzipEncoding(str6)) {
                        requestBody = RequestBodyUtil.createGzip(parse2, string);
                        if (requestBody == null) {
                            ResponseUtil.onRequestError(eventEmitter, i3, "Failed to gzip request body", null);
                            return;
                        }
                    } else {
                        if (parse2 == null) {
                            charset = StandardCharsets.UTF_8;
                        } else {
                            charset = parse2.charset(StandardCharsets.UTF_8);
                        }
                        requestBody = RequestBody.create(parse2, string.getBytes(charset));
                    }
                } else if (readableMap2.hasKey("base64")) {
                    if (str5 == null) {
                        ResponseUtil.onRequestError(eventEmitter, i3, "Payload is set but no content-type header specified", null);
                        return;
                    } else {
                        requestBody = RequestBody.create(MediaType.parse(str5), ByteString.O00000Oo(readableMap2.getString("base64")));
                    }
                } else if (readableMap2.hasKey("uri")) {
                    if (str5 == null) {
                        ResponseUtil.onRequestError(eventEmitter, i3, "Payload is set but no content-type header specified", null);
                        return;
                    }
                    String string2 = readableMap2.getString("uri");
                    InputStream fileInputStream = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), string2);
                    if (fileInputStream == null) {
                        ResponseUtil.onRequestError(eventEmitter, i3, "Could not retrieve file for uri ".concat(String.valueOf(string2)), null);
                        return;
                    }
                    requestBody = RequestBodyUtil.create(MediaType.parse(str5), fileInputStream);
                } else if (readableMap2.hasKey("formData")) {
                    if (str5 == null) {
                        str5 = "multipart/form-data";
                    }
                    MultipartBody.Builder constructMultipartBody = constructMultipartBody(readableMap2.getArray("formData"), str5, i3);
                    if (constructMultipartBody != null) {
                        requestBody = constructMultipartBody.build();
                    } else {
                        return;
                    }
                } else {
                    requestBody = RequestBodyUtil.getEmptyBody(str);
                }
                url.method(str, wrapRequestBodyWithProgressEmitter(requestBody, eventEmitter, i3));
                addRequest(i3);
                final int i5 = i;
                final DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = eventEmitter;
                final String str7 = str3;
                final boolean z3 = z;
                AnonymousClass2 r1 = new Callback() {
                    /* class com.facebook.react.modules.network.NetworkingModule.AnonymousClass2 */

                    public void onFailure(Call call, IOException iOException) {
                        String str;
                        if (!NetworkingModule.this.mShuttingDown) {
                            NetworkingModule.this.removeRequest(i5);
                            if (iOException.getMessage() != null) {
                                str = iOException.getMessage();
                            } else {
                                str = "Error while executing request: " + iOException.getClass().getSimpleName();
                            }
                            ResponseUtil.onRequestError(rCTDeviceEventEmitter, i5, str, iOException);
                        }
                    }

                    public void onResponse(Call call, Response response) throws IOException {
                        if (!NetworkingModule.this.mShuttingDown) {
                            NetworkingModule.this.removeRequest(i5);
                            ResponseUtil.onResponseReceived(rCTDeviceEventEmitter, i5, response.code(), NetworkingModule.translateHeaders(response.headers()), response.request().url().toString());
                            try {
                                ResponseBody body = response.body();
                                if ("gzip".equalsIgnoreCase(response.header("Content-Encoding")) && body != null) {
                                    jbe jbe = new jbe(body.source());
                                    String header = response.header("Content-Type");
                                    body = ResponseBody.create(header != null ? MediaType.parse(header) : null, -1, jbg.O000000o(jbe));
                                }
                                for (ResponseHandler next : NetworkingModule.this.mResponseHandlers) {
                                    if (next.supports(str7)) {
                                        ResponseUtil.onDataReceived(rCTDeviceEventEmitter, i5, next.toResponseData(body));
                                        ResponseUtil.onRequestSuccess(rCTDeviceEventEmitter, i5);
                                        return;
                                    }
                                }
                                if (z3) {
                                    if (str7.equals("text")) {
                                        NetworkingModule.this.readWithProgress(rCTDeviceEventEmitter, i5, body);
                                        ResponseUtil.onRequestSuccess(rCTDeviceEventEmitter, i5);
                                        return;
                                    }
                                }
                                String str = "";
                                if (str7.equals("text")) {
                                    try {
                                        str = body.string();
                                    } catch (IOException e) {
                                        if (!response.request().method().equalsIgnoreCase("HEAD")) {
                                            ResponseUtil.onRequestError(rCTDeviceEventEmitter, i5, e.getMessage(), e);
                                        }
                                    }
                                } else if (str7.equals("base64")) {
                                    str = Base64.encodeToString(body.bytes(), 2);
                                }
                                ResponseUtil.onDataReceived(rCTDeviceEventEmitter, i5, str);
                                ResponseUtil.onRequestSuccess(rCTDeviceEventEmitter, i5);
                            } catch (IOException e2) {
                                ResponseUtil.onRequestError(rCTDeviceEventEmitter, i5, e2.getMessage(), e2);
                            }
                        }
                    }
                };
                Request build2 = url.build();
                NetworkModuleProxy networkModuleProxy2 = this.networkModuleProxy;
                if (networkModuleProxy2 != null) {
                    r2 = r1;
                    okHttpClient = build;
                    if (networkModuleProxy2.doProxy(str, str2, build, build2, requestBody, eventEmitter, i, r2)) {
                        return;
                    }
                } else {
                    r2 = r1;
                    okHttpClient = build;
                }
                okHttpClient.newCall(build2).enqueue(r2);
            } catch (Exception e) {
                ResponseUtil.onRequestError(eventEmitter, i3, e.getMessage(), null);
            }
        } catch (IOException e2) {
            ResponseUtil.onRequestError(eventEmitter, i3, e2.getMessage(), e2);
        }
    }

    public final void setNetworkModuleProxy(NetworkModuleProxy networkModuleProxy2) {
        this.networkModuleProxy = networkModuleProxy2;
    }

    public final Request makeRNRequest(Request request, String str, RequestBody requestBody, DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i) {
        return request.newBuilder().method(str, wrapRequestBodyWithProgressEmitter(requestBody, rCTDeviceEventEmitter, i)).build();
    }

    private RequestBody wrapRequestBodyWithProgressEmitter(RequestBody requestBody, final DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, final int i) {
        if (requestBody == null) {
            return null;
        }
        return RequestBodyUtil.createProgressRequest(requestBody, new ProgressListener() {
            /* class com.facebook.react.modules.network.NetworkingModule.AnonymousClass3 */
            long last = System.nanoTime();

            public void onProgress(long j, long j2, boolean z) {
                long nanoTime = System.nanoTime();
                if (z || NetworkingModule.shouldDispatch(nanoTime, this.last)) {
                    ResponseUtil.onDataSend(rCTDeviceEventEmitter, i, j, j2);
                    this.last = nanoTime;
                }
            }
        });
    }

    public final void readWithProgress(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i, ResponseBody responseBody) throws IOException {
        long j;
        Charset charset;
        long j2 = -1;
        try {
            ProgressResponseBody progressResponseBody = (ProgressResponseBody) responseBody;
            j = progressResponseBody.totalBytesRead();
            try {
                j2 = progressResponseBody.contentLength();
            } catch (ClassCastException unused) {
            }
        } catch (ClassCastException unused2) {
            j = -1;
        }
        if (responseBody.contentType() == null) {
            charset = StandardCharsets.UTF_8;
        } else {
            charset = responseBody.contentType().charset(StandardCharsets.UTF_8);
        }
        ProgressiveStringDecoder progressiveStringDecoder = new ProgressiveStringDecoder(charset);
        InputStream byteStream = responseBody.byteStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = byteStream.read(bArr);
                if (read != -1) {
                    ResponseUtil.onIncrementalDataReceived(rCTDeviceEventEmitter, i, progressiveStringDecoder.decodeNext(bArr, read), j, j2);
                } else {
                    return;
                }
            }
        } finally {
            byteStream.close();
        }
    }

    private synchronized void addRequest(int i) {
        this.mRequestIds.add(Integer.valueOf(i));
    }

    public final synchronized void removeRequest(int i) {
        this.mRequestIds.remove(Integer.valueOf(i));
    }

    private synchronized void cancelAllRequests() {
        for (Integer intValue : this.mRequestIds) {
            cancelRequest(intValue.intValue());
        }
        this.mRequestIds.clear();
    }

    public static WritableMap translateHeaders(Headers headers) {
        WritableMap createMap = Arguments.createMap();
        for (int i = 0; i < headers.size(); i++) {
            String name = headers.name(i);
            if (createMap.hasKey(name)) {
                createMap.putString(name, createMap.getString(name) + ", " + headers.value(i));
            } else {
                createMap.putString(name, headers.value(i));
            }
        }
        return createMap;
    }

    @ReactMethod
    public final void abortRequest(int i) {
        cancelRequest(i);
        removeRequest(i);
    }

    private void cancelRequest(final int i) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.facebook.react.modules.network.NetworkingModule.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                OkHttpCallUtil.cancelTag(NetworkingModule.this.mClient, Integer.valueOf(i));
            }
        }.execute(new Void[0]);
    }

    @ReactMethod
    public final void clearCookies(com.facebook.react.bridge.Callback callback) {
        this.mCookieHandler.clearCookies(callback);
    }

    private MultipartBody.Builder constructMultipartBody(ReadableArray readableArray, String str, int i) {
        MediaType mediaType;
        DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter();
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MediaType.parse(str));
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map = readableArray.getMap(i2);
            Headers extractHeaders = extractHeaders(map.getArray("headers"), null);
            if (extractHeaders == null) {
                ResponseUtil.onRequestError(eventEmitter, i, "Missing or invalid header format for FormData part.", null);
                return null;
            }
            String str2 = extractHeaders.get("content-type");
            if (str2 != null) {
                mediaType = MediaType.parse(str2);
                extractHeaders = extractHeaders.newBuilder().removeAll("content-type").build();
            } else {
                mediaType = null;
            }
            if (map.hasKey("string")) {
                builder.addPart(extractHeaders, RequestBody.create(mediaType, map.getString("string")));
            } else if (!map.hasKey("uri")) {
                ResponseUtil.onRequestError(eventEmitter, i, "Unrecognized FormData part.", null);
            } else if (mediaType == null) {
                ResponseUtil.onRequestError(eventEmitter, i, "Binary FormData part needs a content-type header.", null);
                return null;
            } else {
                String string = map.getString("uri");
                InputStream fileInputStream = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), string);
                if (fileInputStream == null) {
                    ResponseUtil.onRequestError(eventEmitter, i, "Could not retrieve file for uri ".concat(String.valueOf(string)), null);
                    return null;
                }
                builder.addPart(extractHeaders, RequestBodyUtil.create(mediaType, fileInputStream));
            }
        }
        return builder;
    }

    private Headers extractHeaders(ReadableArray readableArray, ReadableMap readableMap) {
        String str;
        if (readableArray == null) {
            return null;
        }
        Headers.Builder builder = new Headers.Builder();
        int size = readableArray.size();
        boolean z = false;
        int i = 0;
        while (i < size) {
            ReadableArray array = readableArray.getArray(i);
            if (array != null && array.size() == 2) {
                String stripHeaderName = HeaderUtil.stripHeaderName(array.getString(0));
                String stripHeaderValue = HeaderUtil.stripHeaderValue(array.getString(1));
                if (!(stripHeaderName == null || stripHeaderValue == null)) {
                    builder.add(stripHeaderName, stripHeaderValue);
                    i++;
                }
            }
            return null;
        }
        if (builder.get("user-agent") == null && (str = this.mDefaultUserAgent) != null) {
            builder.add("user-agent", str);
        }
        if (readableMap != null && readableMap.hasKey("string")) {
            z = true;
        }
        if (!z) {
            builder.removeAll("content-encoding");
        }
        return builder.build();
    }

    private DeviceEventManagerModule.RCTDeviceEventEmitter getEventEmitter() {
        return (DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }
}

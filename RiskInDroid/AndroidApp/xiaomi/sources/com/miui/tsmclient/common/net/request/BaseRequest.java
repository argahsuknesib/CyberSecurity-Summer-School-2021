package com.miui.tsmclient.common.net.request;

import android.text.TextUtils;
import com.miui.tsmclient.common.net.RequestCallback;
import com.miui.tsmclient.common.net.Response;
import com.miui.tsmclient.common.net.host.BaseHost;
import com.miui.tsmclient.common.net.host.Host;
import com.miui.tsmclient.util.EnvironmentConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseRequest<T> {
    private RequestCallback<T> mCallback;
    private int mConnectTimeout = -1;
    private final Map<String, String> mCookies = new HashMap();
    private final Map<String, String> mHeaders = new HashMap();
    protected Host mHost = onCreateHost();
    private boolean mIsPersistence;
    private int mMethod = 0;
    private final Map<String, String> mParams = new HashMap();
    protected String mPath;
    private int mReadTimeout = -1;
    protected RequestType mRequestType = RequestType.NORMAL;
    private Response<T> mResponse = Response.error(-1, null);
    private int mWriteTimeout = -1;

    public enum RequestType {
        NORMAL,
        AUTH,
        SECURE
    }

    public void addExtraParams() throws IOException {
    }

    public boolean isStringResponse() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract T parseBody(InputStream inputStream, long j) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract T parseBody(String str) throws IOException;

    public final class Method {
        private Method() {
        }
    }

    protected BaseRequest(int i, String str, RequestCallback<T> requestCallback) {
        this.mMethod = i;
        this.mPath = str;
        this.mCallback = requestCallback;
    }

    public BaseRequest<T> addParams(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.mParams.put(str, str2);
        }
        return this;
    }

    public BaseRequest<T> addCookie(String str, String str2) {
        this.mCookies.put(str, str2);
        return this;
    }

    public BaseRequest<T> addHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
        return this;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public Map<String, String> getCookies() {
        return this.mCookies;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public String getUrl() {
        return EnvironmentConfig.isStaging() ? this.mHost.getStagingHost() : this.mHost.getOnlineHost();
    }

    public RequestType getRequestType() {
        return this.mRequestType;
    }

    public boolean isAuth() {
        return this.mRequestType.compareTo(RequestType.AUTH) >= 0;
    }

    public boolean isCrypt() {
        return this.mRequestType == RequestType.SECURE;
    }

    public int getMethod() {
        return this.mMethod;
    }

    public Response<T> getResponse() {
        return this.mResponse;
    }

    public T getResult() {
        return this.mResponse.getResult();
    }

    public RequestCallback<T> getCallback() {
        return this.mCallback;
    }

    public BaseRequest<T> setCallback(RequestCallback<T> requestCallback) {
        this.mCallback = requestCallback;
        return this;
    }

    public BaseRequest<T> setResponse(InputStream inputStream, long j) throws IOException {
        this.mResponse = Response.success(parseBody(inputStream, j));
        return this;
    }

    public BaseRequest<T> setResponse(String str) throws IOException {
        this.mResponse = Response.success(parseBody(str));
        return this;
    }

    public boolean isSuccess() {
        return this.mResponse.isSuccess();
    }

    public Host getHost() {
        return this.mHost;
    }

    public int getConnectTimeout() {
        return this.mConnectTimeout;
    }

    public BaseRequest<T> setConnectTimeout(int i) {
        this.mConnectTimeout = i;
        return this;
    }

    public int getReadTimeout() {
        return this.mReadTimeout;
    }

    public BaseRequest<T> setReadTimeout(int i) {
        this.mReadTimeout = i;
        return this;
    }

    public int getWriteTimeout() {
        return this.mWriteTimeout;
    }

    public BaseRequest<T> setWriteTimeout(int i) {
        this.mWriteTimeout = i;
        return this;
    }

    public BaseRequest<T> setPersistence() {
        this.mIsPersistence = true;
        return this;
    }

    public boolean isPersistence() {
        return this.mIsPersistence;
    }

    public Host onCreateHost() {
        return new BaseHost() {
            /* class com.miui.tsmclient.common.net.request.BaseRequest.AnonymousClass1 */

            public String getServiceId() {
                return null;
            }

            public String getStagingHost() {
                return BaseRequest.this.mPath;
            }

            public String getOnlineHost() {
                return BaseRequest.this.mPath;
            }
        };
    }
}

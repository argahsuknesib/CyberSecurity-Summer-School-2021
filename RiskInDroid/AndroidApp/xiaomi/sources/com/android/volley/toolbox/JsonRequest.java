package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

public abstract class JsonRequest<T> extends Request<T> {
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", "utf-8");
    protected Response.Listener<T> mListener;
    private final String mRequestBody;

    public abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);

    public JsonRequest(String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(-1, str, str2, listener, errorListener);
    }

    public JsonRequest(int i, String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.mListener = listener;
        this.mRequestBody = str2;
    }

    public void deliverResponse(T t) {
        this.mListener.onResponse(t);
    }

    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    public byte[] getPostBody() {
        return getBody();
    }

    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    public byte[] getBody() {
        try {
            if (this.mRequestBody == null) {
                return null;
            }
            return this.mRequestBody.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", this.mRequestBody, "utf-8");
            return null;
        }
    }
}

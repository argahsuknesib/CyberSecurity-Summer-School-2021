package _m_j;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

public abstract class cer<T> extends Request<T> {
    private final Response.Listener<T> mListener;
    private final String mRequestBody;

    public String getBodyContentType() {
        return "application/x-protobuf";
    }

    public abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);

    public cer(int i, String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.mListener = listener;
        this.mRequestBody = str2;
    }

    public void deliverResponse(T t) {
        this.mListener.onResponse(t);
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

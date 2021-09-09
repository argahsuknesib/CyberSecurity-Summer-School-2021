package _m_j;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ceo extends JsonRequest<JSONObject> {
    public abstract String getCookies();

    public ceo(int i, String str, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this(i, str, null, listener, errorListener);
    }

    public ceo(int i, String str, String str2, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(i, str, str2, listener, errorListener);
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap hashMap = new HashMap();
        String cookies = getCookies();
        if (!TextUtils.isEmpty(cookies)) {
            hashMap.put("Cookie", cookies);
        }
        return hashMap;
    }

    public Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(new JSONObject(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers))), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException e2) {
            return Response.error(new ParseError(e2));
        }
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }
}

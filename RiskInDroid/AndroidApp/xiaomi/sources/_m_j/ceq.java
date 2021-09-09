package _m_j;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import java.util.HashMap;
import java.util.Map;

public class ceq extends cer<byte[]> {
    public String getCookies() {
        return null;
    }

    public ceq(int i, String str, String str2, Response.Listener<byte[]> listener, Response.ErrorListener errorListener) {
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

    public Response<byte[]> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            byte b = networkResponse.data[networkResponse.data.length - 1];
            byte[] bArr = new byte[(networkResponse.data.length - 1)];
            System.arraycopy(networkResponse.data, 0, bArr, 0, networkResponse.data.length - 1);
            if (2 != b && 1 != b) {
                return Response.error(new ParseError(new Exception("Protobuf Format Incorrect!")));
            }
            if (2 == b) {
                bArr = cdv.O000000o(bArr);
            }
            return Response.success(bArr, HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Exception e) {
            return Response.error(new ParseError(e));
        }
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }
}

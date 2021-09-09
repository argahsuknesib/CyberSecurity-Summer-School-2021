package _m_j;

import android.text.TextUtils;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.json.JSONObject;

public final class caj extends cah {
    private final List<String> O00000o;
    private MultipartEntity O00000o0 = new MultipartEntity();
    private final Map<String, String> O00000oO;

    public caj(String str, Map<String, String> map, List<String> list, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(1, str, null, listener, errorListener);
        this.O00000o = list;
        this.O00000oO = map;
        List<String> list2 = this.O00000o;
        if (list2 != null) {
            for (String next : list2) {
                if (!TextUtils.isEmpty(next)) {
                    File file = new File(next);
                    if (file.exists()) {
                        this.O00000o0.addPart("file[]", new FileBody(file));
                    }
                }
            }
        }
        Map<String, String> map2 = this.O00000oO;
        if (map2 != null) {
            for (Map.Entry next2 : map2.entrySet()) {
                try {
                    this.O00000o0.addPart((String) next2.getKey(), new StringBody((String) next2.getValue(), Charset.forName("UTF-8")));
                } catch (UnsupportedEncodingException unused) {
                    VolleyLog.e("UnsupportedEncodingException", new Object[0]);
                }
            }
        }
    }

    public final String getBodyContentType() {
        return this.O00000o0.getContentType().getValue();
    }

    public final byte[] getBody() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.O00000o0.writeTo(byteArrayOutputStream);
        } catch (IOException unused) {
            VolleyLog.e("IOException writing to ByteArrayOutputStream", new Object[0]);
        }
        return byteArrayOutputStream.toByteArray();
    }
}

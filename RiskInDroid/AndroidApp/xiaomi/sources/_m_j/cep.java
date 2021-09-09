package _m_j;

import com.android.volley.Response;
import org.json.JSONObject;

public final class cep extends ceo {
    public final String getCookies() {
        return null;
    }

    public cep(String str, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this(0, str, listener, errorListener);
    }

    private cep(int i, String str, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(0, str, null, listener, errorListener);
    }
}

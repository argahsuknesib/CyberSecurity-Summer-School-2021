package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public final class iak {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f1106O000000o;

    public iak(JSONObject jSONObject) throws JSONException {
        this.f1106O000000o = jSONObject.getString("ticket");
    }

    public final String toString() {
        return "UpLinkVerifyResult{, ticket='" + this.f1106O000000o + '\'' + '}';
    }
}

package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public interface fdv<T> {
    T parse(JSONObject jSONObject) throws JSONException;
}

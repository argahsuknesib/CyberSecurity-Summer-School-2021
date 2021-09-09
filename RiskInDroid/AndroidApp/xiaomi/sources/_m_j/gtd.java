package _m_j;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gtd extends JSONObject {

    /* renamed from: O000000o  reason: collision with root package name */
    private JSONObject f18229O000000o;
    private boolean O00000Oo = false;

    public gtd() {
    }

    public gtd(String str) throws JSONException {
        super(str);
    }

    public gtd(JSONObject jSONObject) {
        this.f18229O000000o = jSONObject;
    }

    public gtd(JSONObject jSONObject, boolean z) {
        this.f18229O000000o = jSONObject;
        this.O00000Oo = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000Oo */
    public gtc getJSONArray(String str) throws JSONException {
        JSONArray jSONArray;
        try {
            jSONArray = this.f18229O000000o == null ? super.getJSONArray(str) : this.f18229O000000o.getJSONArray(str);
        } catch (JSONException e) {
            if (this.O00000Oo) {
                e.printStackTrace();
                jSONArray = null;
            } else {
                throw e;
            }
        }
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        return new gtc(jSONArray, this.O00000Oo);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public gtd getJSONObject(String str) throws JSONException {
        JSONObject jSONObject;
        try {
            jSONObject = this.f18229O000000o == null ? super.getJSONObject(str) : this.f18229O000000o.getJSONObject(str);
        } catch (JSONException e) {
            if (this.O00000Oo) {
                e.printStackTrace();
                jSONObject = null;
            } else {
                throw e;
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return new gtd(jSONObject, this.O00000Oo);
    }

    /* renamed from: O000000o */
    public final gtd optJSONObject(String str) {
        JSONObject jSONObject = this.f18229O000000o;
        JSONObject optJSONObject = jSONObject == null ? super.optJSONObject(str) : jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        return new gtd(optJSONObject, this.O00000Oo);
    }

    public final Iterator<String> keys() {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.keys() : jSONObject.keys();
    }

    public final String toString() {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.toString() : jSONObject.toString();
    }

    public final String toString(int i) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.toString(i) : jSONObject.toString(i);
    }

    public final int hashCode() {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.hashCode() : jSONObject.hashCode();
    }

    public final boolean equals(Object obj) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.equals(obj) : jSONObject.equals(obj);
    }

    public final int length() {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.length() : jSONObject.length();
    }

    /* renamed from: O000000o */
    public final gtd put(String str, Object obj) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        JSONObject put = jSONObject == null ? super.put(str, obj) : jSONObject.put(str, obj);
        if (put == null) {
            put = new JSONObject();
        }
        return new gtd(put);
    }

    public final Object remove(String str) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.remove(str) : jSONObject.remove(str);
    }

    public final boolean isNull(String str) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.isNull(str) : jSONObject.isNull(str);
    }

    public final boolean has(String str) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.has(str) : jSONObject.has(str);
    }

    public final Object get(String str) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.get(str) : jSONObject.get(str);
    }

    public final Object opt(String str) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.opt(str) : jSONObject.opt(str);
    }

    @Deprecated
    public final boolean getBoolean(String str) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.getBoolean(str) : jSONObject.getBoolean(str);
    }

    @Deprecated
    public final boolean optBoolean(String str) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.optBoolean(str) : jSONObject.optBoolean(str);
    }

    public final boolean optBoolean(String str, boolean z) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.optBoolean(str, z) : jSONObject.optBoolean(str, z);
    }

    @Deprecated
    public final double getDouble(String str) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.getDouble(str) : jSONObject.getDouble(str);
    }

    @Deprecated
    public final double optDouble(String str) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.optDouble(str) : jSONObject.optDouble(str);
    }

    public final double optDouble(String str, double d) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.optDouble(str, d) : jSONObject.optDouble(str, d);
    }

    @Deprecated
    public final int getInt(String str) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.getInt(str) : jSONObject.getInt(str);
    }

    @Deprecated
    public final int optInt(String str) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.optInt(str) : jSONObject.optInt(str);
    }

    public final int optInt(String str, int i) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.optInt(str, i) : jSONObject.optInt(str, i);
    }

    @Deprecated
    public final long getLong(String str) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.getLong(str) : jSONObject.getLong(str);
    }

    @Deprecated
    public final long optLong(String str) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.optLong(str) : jSONObject.optLong(str);
    }

    public final long optLong(String str, long j) {
        JSONObject jSONObject = this.f18229O000000o;
        return jSONObject == null ? super.optLong(str, j) : jSONObject.optLong(str, j);
    }

    public final String getString(String str) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        String string = jSONObject == null ? super.getString(str) : jSONObject.getString(str);
        return string == null ? "" : string;
    }

    public final String optString(String str) {
        JSONObject jSONObject = this.f18229O000000o;
        String optString = jSONObject == null ? super.optString(str) : jSONObject.optString(str);
        return optString == null ? "" : optString;
    }

    public final String optString(String str, String str2) {
        JSONObject jSONObject = this.f18229O000000o;
        String optString = jSONObject == null ? super.optString(str, str2) : jSONObject.optString(str, str2);
        return optString == null ? "" : optString;
    }

    public final /* synthetic */ JSONArray names() {
        JSONObject jSONObject = this.f18229O000000o;
        JSONArray names = jSONObject == null ? super.names() : jSONObject.names();
        if (names == null) {
            names = new JSONArray();
        }
        return new gtc(names);
    }

    public final /* synthetic */ JSONArray toJSONArray(JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        JSONArray jSONArray2 = jSONObject == null ? super.toJSONArray(jSONArray) : jSONObject.toJSONArray(jSONArray);
        if (jSONArray2 == null) {
            jSONArray2 = new JSONArray();
        }
        return new gtc(jSONArray2);
    }

    public final /* synthetic */ JSONArray optJSONArray(String str) {
        JSONObject jSONObject = this.f18229O000000o;
        JSONArray optJSONArray = jSONObject == null ? super.optJSONArray(str) : jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        return new gtc(optJSONArray, this.O00000Oo);
    }

    public final /* synthetic */ JSONObject accumulate(String str, Object obj) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        JSONObject accumulate = jSONObject == null ? super.accumulate(str, obj) : jSONObject.accumulate(str, obj);
        if (accumulate == null) {
            accumulate = new JSONObject();
        }
        return new gtd(accumulate);
    }

    public final /* synthetic */ JSONObject putOpt(String str, Object obj) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        JSONObject put = jSONObject == null ? super.put(str, obj) : jSONObject.put(str, obj);
        if (put == null) {
            put = new JSONObject();
        }
        return new gtd(put);
    }

    public final /* synthetic */ JSONObject put(String str, long j) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        JSONObject put = jSONObject == null ? super.put(str, j) : jSONObject.put(str, j);
        if (put == null) {
            put = new JSONObject();
        }
        return new gtd(put);
    }

    public final /* synthetic */ JSONObject put(String str, int i) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        JSONObject put = jSONObject == null ? super.put(str, i) : jSONObject.put(str, i);
        if (put == null) {
            put = new JSONObject();
        }
        return new gtd(put);
    }

    public final /* synthetic */ JSONObject put(String str, double d) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        JSONObject put = jSONObject == null ? super.put(str, d) : jSONObject.put(str, d);
        if (put == null) {
            put = new JSONObject();
        }
        return new gtd(put);
    }

    public final /* synthetic */ JSONObject put(String str, boolean z) throws JSONException {
        JSONObject jSONObject = this.f18229O000000o;
        JSONObject put = jSONObject == null ? super.put(str, z) : jSONObject.put(str, z);
        if (put == null) {
            put = new JSONObject();
        }
        return new gtd(put);
    }
}

package _m_j;

import android.annotation.TargetApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gtc extends JSONArray {

    /* renamed from: O000000o  reason: collision with root package name */
    private JSONArray f18228O000000o;
    private boolean O00000Oo = false;

    public gtc() {
    }

    public gtc(JSONArray jSONArray) {
        this.f18228O000000o = jSONArray;
    }

    public gtc(JSONArray jSONArray, boolean z) {
        this.f18228O000000o = jSONArray;
        this.O00000Oo = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public gtc getJSONArray(int i) throws JSONException {
        JSONArray jSONArray;
        try {
            jSONArray = this.f18228O000000o == null ? super.getJSONArray(i) : this.f18228O000000o.getJSONArray(i);
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
    /* renamed from: O00000Oo */
    public gtd getJSONObject(int i) throws JSONException {
        JSONObject jSONObject;
        try {
            jSONObject = this.f18228O000000o == null ? super.getJSONObject(i) : this.f18228O000000o.getJSONObject(i);
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

    public final int length() {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.length() : jSONArray.length();
    }

    /* renamed from: O000000o */
    public final gtc put(Object obj) {
        JSONArray jSONArray = this.f18228O000000o;
        JSONArray put = jSONArray == null ? super.put(obj) : jSONArray.put(obj);
        if (put == null) {
            put = new JSONArray();
        }
        return new gtc(put);
    }

    public final boolean isNull(int i) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.isNull(i) : jSONArray.isNull(i);
    }

    public final Object get(int i) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.get(i) : jSONArray.get(i);
    }

    public final Object opt(int i) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.opt(i) : jSONArray.opt(i);
    }

    @TargetApi(19)
    public final Object remove(int i) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.remove(i) : jSONArray.remove(i);
    }

    @Deprecated
    public final boolean getBoolean(int i) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.getBoolean(i) : jSONArray.getBoolean(i);
    }

    @Deprecated
    public final boolean optBoolean(int i) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.optBoolean(i) : jSONArray.optBoolean(i);
    }

    public final boolean optBoolean(int i, boolean z) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.optBoolean(i, z) : jSONArray.optBoolean(i, z);
    }

    @Deprecated
    public final double getDouble(int i) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.getDouble(i) : jSONArray.getDouble(i);
    }

    @Deprecated
    public final double optDouble(int i) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.optDouble(i) : jSONArray.optDouble(i);
    }

    public final double optDouble(int i, double d) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.optDouble(i, d) : jSONArray.optDouble(i, d);
    }

    @Deprecated
    public final int getInt(int i) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.getInt(i) : jSONArray.getInt(i);
    }

    @Deprecated
    public final int optInt(int i) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.optInt(i) : jSONArray.optInt(i);
    }

    public final int optInt(int i, int i2) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.optInt(i, i2) : jSONArray.optInt(i, i2);
    }

    @Deprecated
    public final long getLong(int i) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.getLong(i) : jSONArray.getLong(i);
    }

    @Deprecated
    public final long optLong(int i) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.optLong(i) : jSONArray.optLong(i);
    }

    public final long optLong(int i, long j) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.optLong(i, j) : jSONArray.optLong(i, j);
    }

    public final String getString(int i) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        String string = jSONArray == null ? super.getString(i) : jSONArray.getString(i);
        return string == null ? "" : string;
    }

    public final String optString(int i) {
        JSONArray jSONArray = this.f18228O000000o;
        String optString = jSONArray == null ? super.optString(i) : jSONArray.optString(i);
        return optString == null ? "" : optString;
    }

    public final String optString(int i, String str) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.optString(i, str) : jSONArray.optString(i, str);
    }

    public final String join(String str) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        String join = jSONArray == null ? super.join(str) : jSONArray.join(str);
        return join == null ? "" : join;
    }

    public final String toString() {
        JSONArray jSONArray = this.f18228O000000o;
        String jSONArray2 = jSONArray == null ? super.toString() : jSONArray.toString();
        return jSONArray2 == null ? "" : jSONArray2;
    }

    public final String toString(int i) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        String jSONArray2 = jSONArray == null ? super.toString(i) : jSONArray.toString(i);
        return jSONArray2 == null ? "" : jSONArray2;
    }

    public final boolean equals(Object obj) {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.equals(obj) : jSONArray.equals(obj);
    }

    public final int hashCode() {
        JSONArray jSONArray = this.f18228O000000o;
        return jSONArray == null ? super.hashCode() : jSONArray.hashCode();
    }

    public final /* synthetic */ JSONObject toJSONObject(JSONArray jSONArray) throws JSONException {
        JSONArray jSONArray2 = this.f18228O000000o;
        JSONObject jSONObject = jSONArray2 == null ? super.toJSONObject(jSONArray) : jSONArray2.toJSONObject(jSONArray);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return new gtd(jSONObject);
    }

    public final /* synthetic */ JSONObject optJSONObject(int i) {
        JSONArray jSONArray = this.f18228O000000o;
        JSONObject optJSONObject = jSONArray == null ? super.optJSONObject(i) : jSONArray.optJSONObject(i);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        return new gtd(optJSONObject, this.O00000Oo);
    }

    public final /* synthetic */ JSONArray optJSONArray(int i) {
        JSONArray jSONArray = this.f18228O000000o;
        JSONArray optJSONArray = jSONArray == null ? super.optJSONArray(i) : jSONArray.optJSONArray(i);
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        return new gtc(optJSONArray, this.O00000Oo);
    }

    public final /* synthetic */ JSONArray put(int i, Object obj) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        JSONArray put = jSONArray == null ? super.put(i, obj) : jSONArray.put(i, obj);
        if (put == null) {
            put = new JSONArray();
        }
        return new gtc(put);
    }

    public final /* synthetic */ JSONArray put(int i, long j) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        JSONArray put = jSONArray == null ? super.put(i, j) : jSONArray.put(i, j);
        if (put == null) {
            put = new JSONArray();
        }
        return new gtc(put);
    }

    public final /* synthetic */ JSONArray put(int i, int i2) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        JSONArray put = jSONArray == null ? super.put(i, i2) : jSONArray.put(i, i2);
        if (put == null) {
            put = new JSONArray();
        }
        return new gtc(put);
    }

    public final /* synthetic */ JSONArray put(int i, double d) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        JSONArray put = jSONArray == null ? super.put(i, d) : jSONArray.put(i, d);
        if (put == null) {
            put = new JSONArray();
        }
        return new gtc(put);
    }

    public final /* synthetic */ JSONArray put(int i, boolean z) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        JSONArray put = jSONArray == null ? super.put(i, z) : jSONArray.put(i, z);
        if (put == null) {
            put = new JSONArray();
        }
        return new gtc(put);
    }

    public final /* synthetic */ JSONArray put(long j) {
        JSONArray jSONArray = this.f18228O000000o;
        JSONArray put = jSONArray == null ? super.put(j) : jSONArray.put(j);
        if (put == null) {
            put = new JSONArray();
        }
        return new gtc(put);
    }

    public final /* synthetic */ JSONArray put(int i) {
        JSONArray jSONArray = this.f18228O000000o;
        JSONArray put = jSONArray == null ? super.put(i) : jSONArray.put(i);
        if (put == null) {
            put = new JSONArray();
        }
        return new gtc(put);
    }

    public final /* synthetic */ JSONArray put(double d) throws JSONException {
        JSONArray jSONArray = this.f18228O000000o;
        JSONArray put = jSONArray == null ? super.put(d) : jSONArray.put(d);
        if (put == null) {
            put = new JSONArray();
        }
        return new gtc(put);
    }

    public final /* synthetic */ JSONArray put(boolean z) {
        JSONArray jSONArray = this.f18228O000000o;
        JSONArray put = jSONArray == null ? super.put(z) : jSONArray.put(z);
        if (put == null) {
            put = new JSONArray();
        }
        return new gtc(put);
    }
}

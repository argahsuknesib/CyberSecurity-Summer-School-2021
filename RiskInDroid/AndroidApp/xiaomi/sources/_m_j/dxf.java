package _m_j;

import com.xiaomi.miio.MiioLocalErrorCode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dxf {

    /* renamed from: O000000o  reason: collision with root package name */
    public MiioLocalErrorCode f15024O000000o;
    public String O00000Oo;
    public int O00000o;
    public long O00000o0;
    public String O00000oO;
    public String O00000oo;

    public dxf(MiioLocalErrorCode miioLocalErrorCode) {
        this.f15024O000000o = miioLocalErrorCode;
    }

    public dxf(MiioLocalErrorCode miioLocalErrorCode, String str, long j, int i, String str2, String str3) {
        this.f15024O000000o = miioLocalErrorCode;
        this.O00000Oo = str;
        this.O00000o0 = j;
        this.O00000o = i;
        this.O00000oO = str2;
        this.O00000oo = str3;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:6|7|8|(2:10|11)|12|13|(1:15)|16|(2:18|19)(1:(2:21|22)(2:23|24))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x003c */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043 A[Catch:{ JSONException -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d A[Catch:{ JSONException -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ JSONException -> 0x006a }] */
    public final String O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f15024O000000o.getCode());
            jSONObject.put("message", this.f15024O000000o.getMessage());
            if (this.f15024O000000o != MiioLocalErrorCode.SUCCESS) {
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject(this.O00000Oo);
            if (jSONObject2.getInt("result") == 0) {
                return jSONObject.toString();
            }
            JSONObject optJSONObject = jSONObject2.optJSONObject("result");
            JSONArray jSONArray = null;
            if (optJSONObject == null) {
                jSONArray = jSONObject2.optJSONArray("result");
            }
            int i = jSONObject2.getInt("id");
            if (optJSONObject == null) {
                jSONObject.put("result", optJSONObject);
                jSONObject.put("id", i);
                return jSONObject.toString();
            } else if (jSONArray == null) {
                return jSONObject2.toString();
            } else {
                jSONObject.put("result", jSONArray);
                jSONObject.put("id", i);
                return jSONObject.toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject.toString();
        }
    }
}

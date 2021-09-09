package _m_j;

import android.text.TextUtils;
import com.miot.spec.entity.SpecValueType;
import com.miot.spec.exception.NotSupportValueException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cmg {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14124O000000o;
    public int O00000Oo;
    private List<cmh> O00000o0;

    private cmg(int i, int i2, List<cmh> list) {
        this.f14124O000000o = i2;
        this.O00000Oo = i;
        this.O00000o0 = list;
    }

    public final List<cmh> O000000o() {
        List<cmh> list = this.O00000o0;
        return list != null ? list : Collections.EMPTY_LIST;
    }

    public static cmg O000000o(String str) throws NotSupportValueException {
        int i = 0;
        cnd.O000000o("SepcAction", "parseJson ,json =".concat(String.valueOf(str)), new Object[0]);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("siid", -1);
            if (optInt <= 0 || optInt > 255) {
                throw new NotSupportValueException(-1009, "parse action json, but service id out of [1,255]!!!");
            }
            int optInt2 = jSONObject.optInt("aiid", -1);
            if (optInt2 <= 0 || optInt2 > 255) {
                throw new NotSupportValueException(-1012, "parse action json, but action id out of [1,255]!!!");
            }
            JSONArray jSONArray = jSONObject.getJSONArray("objects");
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                while (i < length) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    int optInt3 = jSONObject2.optInt("piid", -1);
                    if (optInt3 <= 0 || ((long) optInt3) > SpecValueType.UINT16.getMaxValue()) {
                        throw new NotSupportValueException(-1010, "parse action json, but property id out of [1,65535]!!!");
                    }
                    int optInt4 = jSONObject2.optInt("type", -1);
                    if (optInt4 != -1) {
                        SpecValueType convert2ValueType = SpecValueType.convert2ValueType(optInt4);
                        Object opt = jSONObject2.opt("value");
                        if (opt != null) {
                            if (opt instanceof String) {
                                if (TextUtils.isEmpty((String) opt)) {
                                    throw new NotSupportValueException(-1014, "parse action json, but data value  is empty!!!");
                                }
                            }
                            arrayList.add(cmh.O000000o(optInt, optInt3, convert2ValueType, cmh.O000000o(opt, convert2ValueType)));
                            i++;
                        } else {
                            throw new NotSupportValueException(-1014, "parse action json, but data value  is empty!!!");
                        }
                    } else {
                        throw new NotSupportValueException(-1013, "parse action json, but data type  is empty!!!");
                    }
                }
            }
            return new cmg(optInt, optInt2, arrayList);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("siid=");
        sb.append(this.O00000Oo);
        sb.append(",aiid=");
        sb.append(this.f14124O000000o);
        List<cmh> list = this.O00000o0;
        if (list == null || list.isEmpty()) {
            sb.append("property size =0");
        } else {
            sb.append(",property size=");
            sb.append(this.O00000o0.size());
            sb.append("{\n");
            for (cmh cmh : this.O00000o0) {
                sb.append(cmh.toString());
                sb.append("\n");
            }
            sb.append("}");
        }
        return sb.toString();
    }
}

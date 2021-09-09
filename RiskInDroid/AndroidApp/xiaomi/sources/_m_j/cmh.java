package _m_j;

import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.miot.spec.entity.SpecValueType;
import com.miot.spec.exception.NotSupportValueException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cmh {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14125O000000o;
    public int O00000Oo;
    public SpecValueType O00000o;
    public Object O00000o0;
    public int O00000oO = -1;

    private cmh(int i, int i2, SpecValueType specValueType, Object obj) {
        this.f14125O000000o = i;
        this.O00000Oo = i2;
        this.O00000o = specValueType;
        this.O00000o0 = obj;
    }

    private cmh(int i, int i2) {
        this.f14125O000000o = i;
        this.O00000Oo = i2;
    }

    public static cmh O000000o(int i, int i2, SpecValueType specValueType, Object obj) {
        return new cmh(i, i2, specValueType, obj);
    }

    public static List<cmh> O000000o(String str) throws NotSupportValueException {
        cnd.O000000o("SpecProperty", "parseJson4SetProperties json=".concat(String.valueOf(str)), new Object[0]);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("objects");
            int length = jSONArray != null ? jSONArray.length() : 0;
            if (length > 0) {
                int i = 0;
                while (i < length) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    int optInt = jSONObject.optInt("siid", -1);
                    if (optInt <= 0 || optInt > 255) {
                        throw new NotSupportValueException(-1009, "parse set property json, but service id is out of [1,255]!!!");
                    }
                    int optInt2 = jSONObject.optInt("piid", -1);
                    if (optInt2 <= 0 || ((long) optInt2) > SpecValueType.UINT16.getMaxValue()) {
                        throw new NotSupportValueException(-1010, "parse set property json,but property id is out of [1,65535]!!!");
                    }
                    int optInt3 = jSONObject.optInt("type", -1);
                    if (optInt3 != -1) {
                        SpecValueType convert2ValueType = SpecValueType.convert2ValueType(optInt3);
                        Object opt = jSONObject.opt("value");
                        if (opt != null) {
                            if (opt instanceof String) {
                                if (TextUtils.isEmpty((String) opt)) {
                                    throw new NotSupportValueException(-1014, String.format("parse set property json,piid(%d)'s value is null", Integer.valueOf(optInt2)));
                                }
                            }
                            arrayList.add(O000000o(optInt, optInt2, convert2ValueType, O000000o(opt, convert2ValueType)));
                            i++;
                        } else {
                            throw new NotSupportValueException(-1014, String.format("parse set property json,piid(%d)'s value is null", Integer.valueOf(optInt2)));
                        }
                    } else {
                        throw new NotSupportValueException(-1013, "parse set property json,but data type is empty!!!");
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static List<cmh> O00000Oo(String str) throws NotSupportValueException {
        cnd.O000000o("SpecProperty", "parseJson4GetProperties json =".concat(String.valueOf(str)), new Object[0]);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("objects");
            int length = jSONArray != null ? jSONArray.length() : 0;
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    int optInt = jSONObject.optInt("siid", -1);
                    if (optInt <= 0 || optInt > 255) {
                        throw new NotSupportValueException(-1009, "parse get property json, but service id is out of [1,255]!!!");
                    }
                    int optInt2 = jSONObject.optInt("piid", -1);
                    if (optInt2 <= 0 || ((long) optInt2) > SpecValueType.UINT16.getMaxValue()) {
                        throw new NotSupportValueException(-1010, "parse get property json,but property id is out of [1,65535]!!!");
                    }
                    arrayList.add(new cmh(optInt, optInt2));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00db A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0112 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0113  */
    public static Object O000000o(Object obj, SpecValueType specValueType) throws NotSupportValueException {
        Object obj2;
        if (O000000o(specValueType) && (obj instanceof String)) {
            specValueType.isValueValid(Long.valueOf(Long.parseLong((String) obj)));
        }
        Object obj3 = null;
        switch (AnonymousClass1.f14126O000000o[specValueType.ordinal()]) {
            case 1:
                if (!(obj instanceof Boolean)) {
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if ("true".equalsIgnoreCase(str)) {
                            obj2 = Boolean.TRUE;
                        } else if ("false".equalsIgnoreCase(str)) {
                            obj2 = Boolean.FALSE;
                        }
                        if (obj2 != null) {
                            return obj2;
                        }
                        throw new NotSupportValueException("NotSupportValue:value type is " + specValueType.name() + ",but value is " + obj);
                    }
                    obj2 = obj3;
                    if (obj2 != null) {
                    }
                }
                obj2 = obj;
                if (obj2 != null) {
                }
            case 2:
                if (obj instanceof String) {
                    obj2 = Byte.valueOf(Byte.parseByte((String) obj));
                    if (obj2 != null) {
                    }
                }
                if (!(obj instanceof Byte)) {
                    obj3 = obj;
                } else if (obj instanceof String) {
                    obj2 = Byte.valueOf((byte) ((int) (Long.parseLong((String) obj) & 255)));
                    if (obj2 != null) {
                    }
                }
                if (obj instanceof String) {
                    obj2 = Short.valueOf(Short.parseShort((String) obj));
                    if (obj2 != null) {
                    }
                }
                if (!(obj instanceof Short)) {
                    obj3 = obj;
                } else if (obj instanceof String) {
                    obj2 = Short.valueOf((short) ((int) (Long.parseLong((String) obj) & 65535)));
                    if (obj2 != null) {
                    }
                }
                if (obj instanceof String) {
                    obj2 = Integer.valueOf(Integer.parseInt((String) obj));
                    if (obj2 != null) {
                    }
                }
                if (!(obj instanceof Integer)) {
                    return obj;
                }
                if (obj instanceof String) {
                    obj2 = Integer.valueOf((int) (Long.parseLong((String) obj) & -1));
                    if (obj2 != null) {
                    }
                }
                if (obj instanceof String) {
                    obj2 = Long.valueOf(Long.parseLong((String) obj));
                    if (obj2 != null) {
                    }
                }
                if (obj instanceof Long) {
                    return obj;
                }
                if (obj instanceof String) {
                    obj2 = Long.valueOf(cnb.O000000o((String) obj));
                    if (obj2 != null) {
                    }
                }
                obj2 = obj3;
                if (obj2 != null) {
                }
                break;
            case 3:
                if (!(obj instanceof Byte)) {
                }
                if (obj instanceof String) {
                }
                if (!(obj instanceof Short)) {
                }
                if (obj instanceof String) {
                }
                if (!(obj instanceof Integer)) {
                }
                break;
            case 4:
                if (obj instanceof String) {
                }
                if (!(obj instanceof Short)) {
                }
                if (obj instanceof String) {
                }
                if (!(obj instanceof Integer)) {
                }
                break;
            case 5:
                if (!(obj instanceof Short)) {
                }
                if (obj instanceof String) {
                }
                if (!(obj instanceof Integer)) {
                }
                break;
            case 6:
                if (obj instanceof String) {
                }
                if (!(obj instanceof Integer)) {
                }
                break;
            case 7:
                if (!(obj instanceof Integer)) {
                }
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                if (obj instanceof String) {
                }
                if (obj instanceof Long) {
                }
                break;
            case 9:
                if (obj instanceof Long) {
                }
                break;
            case 10:
                if (!(obj instanceof Float)) {
                    if (obj instanceof String) {
                        obj2 = Float.valueOf(Float.parseFloat((String) obj));
                        if (obj2 != null) {
                        }
                    }
                    obj2 = obj3;
                    if (obj2 != null) {
                    }
                }
                obj2 = obj;
                if (obj2 != null) {
                }
                break;
            case 11:
                obj2 = obj.toString();
                if (obj2 != null) {
                }
                break;
            default:
                obj2 = obj3;
                if (obj2 != null) {
                }
                break;
        }
    }

    /* renamed from: _m_j.cmh$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f14126O000000o = new int[SpecValueType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f14126O000000o[SpecValueType.BOOL.ordinal()] = 1;
            f14126O000000o[SpecValueType.INT8.ordinal()] = 2;
            f14126O000000o[SpecValueType.UINT8.ordinal()] = 3;
            f14126O000000o[SpecValueType.INT16.ordinal()] = 4;
            f14126O000000o[SpecValueType.UINT16.ordinal()] = 5;
            f14126O000000o[SpecValueType.INT32.ordinal()] = 6;
            f14126O000000o[SpecValueType.UINT32.ordinal()] = 7;
            f14126O000000o[SpecValueType.INT64.ordinal()] = 8;
            f14126O000000o[SpecValueType.UINT64.ordinal()] = 9;
            f14126O000000o[SpecValueType.FLOAT.ordinal()] = 10;
            try {
                f14126O000000o[SpecValueType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static JSONArray O000000o(List<cmh> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (cmh O000000o2 : list) {
                jSONArray.put(O000000o(O000000o2));
            }
        }
        return jSONArray;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
     arg types: [java.lang.String, byte]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject */
    private static JSONObject O000000o(cmh cmh) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("siid", cmh.f14125O000000o);
        jSONObject.put("piid", cmh.O00000Oo);
        jSONObject.put("type", (int) cmh.O00000o.value());
        jSONObject.put("value", O000000o(cmh.O00000o) ? cmh.O000000o() : cmh.O00000o0);
        jSONObject.put("code", cmh.O00000oO);
        return jSONObject;
    }

    private static boolean O000000o(SpecValueType specValueType) {
        switch (AnonymousClass1.f14126O000000o[specValueType.ordinal()]) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private Object O000000o() {
        switch (AnonymousClass1.f14126O000000o[this.O00000o.ordinal()]) {
            case 2:
                return Byte.valueOf(((Byte) this.O00000o0).byteValue());
            case 3:
                return Integer.valueOf(cnb.O00000Oo(((Byte) this.O00000o0).byteValue()));
            case 4:
                return Short.valueOf(((Short) this.O00000o0).shortValue());
            case 5:
                return Integer.valueOf(cnb.O000000o((int) ((Short) this.O00000o0).shortValue()));
            case 6:
                return Integer.valueOf(((Integer) this.O00000o0).intValue());
            case 7:
                return Long.valueOf(cnb.O00000o0(((Integer) this.O00000o0).intValue()));
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return Long.valueOf(((Long) this.O00000o0).longValue());
            case 9:
                return cnb.O000000o(((Long) this.O00000o0).longValue());
            default:
                return this.O00000o0;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("property:{siid=");
        sb.append(this.f14125O000000o);
        sb.append(",piid=");
        sb.append(this.O00000Oo);
        sb.append(",status=");
        sb.append(this.O00000oO);
        if (this.O00000o != null) {
            sb.append(",valueType=");
            SpecValueType specValueType = this.O00000o;
            sb.append(specValueType != null ? specValueType.name() : "None");
            sb.append(",value=");
            sb.append(O000000o(this.O00000o) ? O000000o() : this.O00000o0);
        }
        sb.append("}");
        return sb.toString();
    }
}

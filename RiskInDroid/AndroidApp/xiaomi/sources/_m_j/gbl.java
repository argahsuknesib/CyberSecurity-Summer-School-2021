package _m_j;

import com.facebook.react.bridge.ReadableMap;

public final class gbl {

    /* renamed from: O000000o  reason: collision with root package name */
    private ReadableMap f17498O000000o;

    public gbl(ReadableMap readableMap) {
        this.f17498O000000o = readableMap;
    }

    public final boolean O000000o(String str, boolean z) {
        try {
            return this.f17498O000000o.getBoolean(str);
        } catch (Exception unused) {
            return z;
        }
    }

    public final int O000000o(String str) {
        try {
            return this.f17498O000000o.getInt(str);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final String O000000o(String str, String str2) {
        ReadableMap readableMap = this.f17498O000000o;
        if (readableMap == null || !readableMap.hasKey(str)) {
            return str2;
        }
        try {
            switch (this.f17498O000000o.getType(str)) {
                case Map:
                    return fyf.O000000o(this.f17498O000000o.getMap(str));
                case Null:
                    return str2;
                case Array:
                    return this.f17498O000000o.getArray(str).toString();
                case Number:
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.f17498O000000o.getDouble(str));
                        return sb.toString();
                    } catch (Exception e) {
                        gbu.O00000Oo(e.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.f17498O000000o.getInt(str));
                        return sb2.toString();
                    }
                case String:
                    return this.f17498O000000o.getString(str);
                case Boolean:
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.f17498O000000o.getBoolean(str2));
                    return sb3.toString();
                default:
                    return str2;
            }
        } catch (Exception e2) {
            gbu.O00000Oo(e2.toString());
            return str2;
        }
        gbu.O00000Oo(e2.toString());
        return str2;
    }
}

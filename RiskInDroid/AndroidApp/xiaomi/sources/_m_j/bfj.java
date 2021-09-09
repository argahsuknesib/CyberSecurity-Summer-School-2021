package _m_j;

import com.imi.fastjson.JSONException;
import com.imi.fastjson.parser.Feature;
import java.lang.reflect.Type;

public final class bfj implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfj f12925O000000o = new bfj();

    public final int O000000o() {
        return 12;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 8) {
            O0000O0o.O000000o();
            return null;
        } else if (O0000O0o.O00000o0() == 12 || O0000O0o.O00000o0() == 16) {
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            while (true) {
                String O000000o2 = O0000O0o.O000000o(bdo.O00000Oo());
                if (O000000o2 == null) {
                    if (O0000O0o.O00000o0() == 13) {
                        O0000O0o.O000000o(16);
                        break;
                    } else if (O0000O0o.O00000o0() == 16 && O0000O0o.O000000o(Feature.AllowArbitraryCommas)) {
                    }
                }
                O0000O0o.O00000Oo(4);
                if (O000000o2 == "className") {
                    if (O0000O0o.O00000o0() == 8) {
                        str = null;
                    } else if (O0000O0o.O00000o0() == 4) {
                        str = O0000O0o.O0000oO0();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (O000000o2 == "methodName") {
                    if (O0000O0o.O00000o0() == 8) {
                        str2 = null;
                    } else if (O0000O0o.O00000o0() == 4) {
                        str2 = O0000O0o.O0000oO0();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (O000000o2 == "fileName") {
                    if (O0000O0o.O00000o0() == 8) {
                        str3 = null;
                    } else if (O0000O0o.O00000o0() == 4) {
                        str3 = O0000O0o.O0000oO0();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (O000000o2 == "lineNumber") {
                    if (O0000O0o.O00000o0() == 8) {
                        i = 0;
                    } else if (O0000O0o.O00000o0() == 2) {
                        i = O0000O0o.O0000o0O();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (O000000o2 == "nativeMethod") {
                    if (O0000O0o.O00000o0() == 8) {
                        O0000O0o.O000000o(16);
                    } else if (O0000O0o.O00000o0() == 6) {
                        O0000O0o.O000000o(16);
                    } else if (O0000O0o.O00000o0() == 7) {
                        O0000O0o.O000000o(16);
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (O000000o2 != bdf.f12884O000000o) {
                    throw new JSONException("syntax error : ".concat(String.valueOf(O000000o2)));
                } else if (O0000O0o.O00000o0() == 4) {
                    String O0000oO0 = O0000O0o.O0000oO0();
                    if (!O0000oO0.equals("java.lang.StackTraceElement")) {
                        throw new JSONException("syntax error : ".concat(String.valueOf(O0000oO0)));
                    }
                } else if (O0000O0o.O00000o0() != 8) {
                    throw new JSONException("syntax error");
                }
                if (O0000O0o.O00000o0() == 13) {
                    O0000O0o.O000000o(16);
                    break;
                }
            }
            return new StackTraceElement(str, str2, str3, i);
        } else {
            throw new JSONException("syntax error: " + bdr.O000000o(O0000O0o.O00000o0()));
        }
    }
}

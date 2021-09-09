package org.json.alipay;

import com.google.android.exoplayer2.C;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f15441a = new a((byte) 0);
    private Map b;

    static final class a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Object clone() {
            return this;
        }

        public final boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public final String toString() {
            return "null";
        }
    }

    public b() {
        this.b = new HashMap();
    }

    public b(String str) {
        this(new c(str));
    }

    public b(Map map) {
        this.b = map == null ? new HashMap() : map;
    }

    public b(c cVar) {
        this();
        if (cVar.c() == '{') {
            while (true) {
                char c = cVar.c();
                if (c == 0) {
                    throw cVar.a("A JSONObject text must end with '}'");
                } else if (c != '}') {
                    cVar.a();
                    String obj = cVar.d().toString();
                    char c2 = cVar.c();
                    if (c2 == '=') {
                        if (cVar.b() != '>') {
                            cVar.a();
                        }
                    } else if (c2 != ':') {
                        throw cVar.a("Expected a ':' after a key");
                    }
                    Object d = cVar.d();
                    if (obj != null) {
                        if (d != null) {
                            b(d);
                            this.b.put(obj, d);
                        } else {
                            this.b.remove(obj);
                        }
                        char c3 = cVar.c();
                        if (c3 == ',' || c3 == ';') {
                            if (cVar.c() != '}') {
                                cVar.a();
                            } else {
                                return;
                            }
                        } else if (c3 != '}') {
                            throw cVar.a("Expected a ',' or '}'");
                        } else {
                            return;
                        }
                    } else {
                        throw new JSONException("Null key.");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw cVar.a("A JSONObject text must begin with '{'");
        }
    }

    static String a(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (!(obj instanceof Number)) {
            return ((obj instanceof Boolean) || (obj instanceof b) || (obj instanceof a)) ? obj.toString() : obj instanceof Map ? new b((Map) obj).toString() : obj instanceof Collection ? new a((Collection) obj).toString() : obj.getClass().isArray() ? new a(obj).toString() : c(obj.toString());
        }
        Number number = (Number) obj;
        if (number != null) {
            b(number);
            String obj2 = number.toString();
            if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
                return obj2;
            }
            while (obj2.endsWith("0")) {
                obj2 = obj2.substring(0, obj2.length() - 1);
            }
            return obj2.endsWith(".") ? obj2.substring(0, obj2.length() - 1) : obj2;
        }
        throw new JSONException("Null pointer");
    }

    private static void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.isInfinite() || d.isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        } else if (obj instanceof Float) {
            Float f = (Float) obj;
            if (f.isInfinite() || f.isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
        if (r4 == '<') goto L_0x0086;
     */
    public static String c(String str) {
        String str2;
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append('\"');
        int i = 0;
        char c = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                str2 = "\\f";
            } else if (charAt != 13) {
                if (charAt != '\"') {
                    if (charAt != '/') {
                        if (charAt != '\\') {
                            switch (charAt) {
                                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                    str2 = "\\b";
                                    break;
                                case 9:
                                    str2 = "\\t";
                                    break;
                                case 10:
                                    str2 = "\\n";
                                    break;
                                default:
                                    if (charAt < ' ' || ((charAt >= 128 && charAt < 160) || (charAt >= 8192 && charAt < 8448))) {
                                        String str3 = "000" + Integer.toHexString(charAt);
                                        str2 = "\\u" + str3.substring(str3.length() - 4);
                                        break;
                                    }
                                    stringBuffer.append(charAt);
                                    i++;
                                    c = charAt;
                            }
                        }
                    }
                }
                stringBuffer.append('\\');
                stringBuffer.append(charAt);
                i++;
                c = charAt;
            } else {
                str2 = "\\r";
            }
            stringBuffer.append(str2);
            i++;
            c = charAt;
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    public final Object a(String str) {
        Object obj = str == null ? null : this.b.get(str);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONObject[" + c(str) + "] not found.");
    }

    public final Iterator a() {
        return this.b.keySet().iterator();
    }

    public final boolean b(String str) {
        return this.b.containsKey(str);
    }

    public String toString() {
        try {
            Iterator a2 = a();
            StringBuffer stringBuffer = new StringBuffer("{");
            while (a2.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = a2.next();
                stringBuffer.append(c(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(a(this.b.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}

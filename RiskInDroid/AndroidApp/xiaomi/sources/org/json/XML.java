package org.json;

import _m_j.jdn;
import java.util.Iterator;

public class XML {
    public static final Character AMP = '&';
    public static final Character APOS = '\'';
    public static final Character BANG = '!';
    public static final Character EQ = '=';
    public static final Character GT = '>';
    public static final Character LT = '<';
    public static final Character QUEST = '?';
    public static final Character QUOT = '\"';
    public static final Character SLASH = '/';

    private static Iterable<Integer> codePointIterator(final String str) {
        return new Iterable<Integer>() {
            /* class org.json.XML.AnonymousClass1 */

            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    /* class org.json.XML.AnonymousClass1.AnonymousClass1 */
                    private int length = str.length();
                    private int nextIndex = 0;

                    public boolean hasNext() {
                        return this.nextIndex < this.length;
                    }

                    public Integer next() {
                        int codePointAt = str.codePointAt(this.nextIndex);
                        this.nextIndex += Character.charCount(codePointAt);
                        return Integer.valueOf(codePointAt);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public static String escape(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (Integer intValue : codePointIterator(str)) {
            int intValue2 = intValue.intValue();
            if (intValue2 == 34) {
                sb.append("&quot;");
            } else if (intValue2 == 60) {
                sb.append("&lt;");
            } else if (intValue2 == 62) {
                sb.append("&gt;");
            } else if (intValue2 == 38) {
                sb.append("&amp;");
            } else if (intValue2 == 39) {
                sb.append("&apos;");
            } else if (mustEscape(intValue2)) {
                sb.append("&#x");
                sb.append(Integer.toHexString(intValue2));
                sb.append(';');
            } else {
                sb.appendCodePoint(intValue2);
            }
        }
        return sb.toString();
    }

    private static boolean mustEscape(int i) {
        if (Character.isISOControl(i) && i != 9 && i != 10 && i != 13) {
            return true;
        }
        if (i >= 32 && i <= 55295) {
            return false;
        }
        if (i < 57344 || i > 65533) {
            return i < 65536 || i > 1114111;
        }
        return false;
    }

    public static String unescape(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '&') {
                int indexOf = str.indexOf(59, i);
                if (indexOf > i) {
                    String substring = str.substring(i + 1, indexOf);
                    sb.append(XMLTokener.unescapeEntity(substring));
                    i += substring.length() + 1;
                } else {
                    sb.append(charAt);
                }
            } else {
                sb.append(charAt);
            }
            i++;
        }
        return sb.toString();
    }

    public static void noSpace(String str) throws JSONException {
        int length = str.length();
        if (length != 0) {
            int i = 0;
            while (i < length) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    i++;
                } else {
                    throw new JSONException("'" + str + "' contains a space character.");
                }
            }
            return;
        }
        throw new JSONException("Empty string.");
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e5, code lost:
        r7 = r10.nextToken();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00eb, code lost:
        if ((r7 instanceof java.lang.String) == false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ed, code lost:
        if (r13 == false) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ef, code lost:
        r7 = (java.lang.String) r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f2, code lost:
        r7 = stringToValue((java.lang.String) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0102, code lost:
        throw r10.syntaxError("Missing value");
     */
    private static boolean parse(XMLTokener xMLTokener, JSONObject jSONObject, String str, boolean z) throws JSONException {
        String str2;
        Object obj;
        Object nextToken = xMLTokener.nextToken();
        int i = 1;
        if (nextToken == BANG) {
            char next = xMLTokener.next();
            if (next == '-') {
                if (xMLTokener.next() == '-') {
                    xMLTokener.skipPast("-->");
                    return false;
                }
                xMLTokener.back();
            } else if (next == '[') {
                if (!"CDATA".equals(xMLTokener.nextToken()) || xMLTokener.next() != '[') {
                    throw xMLTokener.syntaxError("Expected 'CDATA['");
                }
                String nextCDATA = xMLTokener.nextCDATA();
                if (nextCDATA.length() > 0) {
                    jSONObject.accumulate("content", nextCDATA);
                }
                return false;
            }
            do {
                Object nextMeta = xMLTokener.nextMeta();
                if (nextMeta == null) {
                    throw xMLTokener.syntaxError("Missing '>' after '<!'.");
                } else if (nextMeta == LT) {
                    i++;
                    continue;
                } else if (nextMeta == GT) {
                    i--;
                    continue;
                } else {
                    continue;
                }
            } while (i > 0);
            return false;
        } else if (nextToken == QUEST) {
            xMLTokener.skipPast("?>");
            return false;
        } else if (nextToken == SLASH) {
            Object nextToken2 = xMLTokener.nextToken();
            if (str == null) {
                throw xMLTokener.syntaxError("Mismatched close tag ".concat(String.valueOf(nextToken2)));
            } else if (!nextToken2.equals(str)) {
                throw xMLTokener.syntaxError("Mismatched " + str + " and " + nextToken2);
            } else if (xMLTokener.nextToken() == GT) {
                return true;
            } else {
                throw xMLTokener.syntaxError("Misshaped close tag");
            }
        } else if (!(nextToken instanceof Character)) {
            String str3 = (String) nextToken;
            JSONObject jSONObject2 = new JSONObject();
            while (true) {
                Object obj2 = null;
                while (true) {
                    if (obj2 == null) {
                        obj2 = xMLTokener.nextToken();
                    }
                    if (obj2 instanceof String) {
                        str2 = (String) obj2;
                        Object nextToken3 = xMLTokener.nextToken();
                        if (nextToken3 == EQ) {
                            break;
                        }
                        jSONObject2.accumulate(str2, "");
                        obj2 = nextToken3;
                    } else if (obj2 == SLASH) {
                        if (xMLTokener.nextToken() == GT) {
                            if (jSONObject2.length() > 0) {
                                jSONObject.accumulate(str3, jSONObject2);
                            } else {
                                jSONObject.accumulate(str3, "");
                            }
                            return false;
                        }
                        throw xMLTokener.syntaxError("Misshaped tag");
                    } else if (obj2 == GT) {
                        while (true) {
                            Object nextContent = xMLTokener.nextContent();
                            if (nextContent == null) {
                                if (str3 == null) {
                                    return false;
                                }
                                throw xMLTokener.syntaxError("Unclosed tag ".concat(String.valueOf(str3)));
                            } else if (nextContent instanceof String) {
                                String str4 = (String) nextContent;
                                int length = str4.length();
                                Object obj3 = str4;
                                if (length > 0) {
                                    if (!z) {
                                        obj3 = stringToValue(str4);
                                    }
                                    jSONObject2.accumulate("content", obj3);
                                }
                            } else if (nextContent == LT && parse(xMLTokener, jSONObject2, str3, z)) {
                                if (jSONObject2.length() == 0) {
                                    jSONObject.accumulate(str3, "");
                                } else if (jSONObject2.length() != 1 || jSONObject2.opt("content") == null) {
                                    jSONObject.accumulate(str3, jSONObject2);
                                } else {
                                    jSONObject.accumulate(str3, jSONObject2.opt("content"));
                                }
                                return false;
                            }
                        }
                    } else {
                        throw xMLTokener.syntaxError("Misshaped tag");
                    }
                }
                jSONObject2.accumulate(str2, obj);
            }
        } else {
            throw xMLTokener.syntaxError("Misshaped tag");
        }
    }

    public static Object stringToValue(String str) {
        if (str.equals("")) {
            return str;
        }
        if (str.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (str.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        if (str.equalsIgnoreCase("null")) {
            return JSONObject.NULL;
        }
        char charAt = str.charAt(0);
        if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
            try {
                if (str.indexOf(46) < 0 && str.indexOf(101) < 0 && str.indexOf(69) < 0) {
                    if (!"-0".equals(str)) {
                        Long valueOf = Long.valueOf(str);
                        if (str.equals(valueOf.toString())) {
                            return valueOf.longValue() == ((long) valueOf.intValue()) ? Integer.valueOf(valueOf.intValue()) : valueOf;
                        }
                    }
                }
                Double valueOf2 = Double.valueOf(str);
                return (valueOf2.isInfinite() || valueOf2.isNaN()) ? str : valueOf2;
            } catch (Exception unused) {
            }
        }
    }

    public static JSONObject toJSONObject(String str) throws JSONException {
        return toJSONObject(str, false);
    }

    public static JSONObject toJSONObject(String str, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        XMLTokener xMLTokener = new XMLTokener(str);
        while (xMLTokener.more()) {
            xMLTokener.skipPast("<");
            if (xMLTokener.more()) {
                parse(xMLTokener, jSONObject, null, z);
            }
        }
        return jSONObject;
    }

    public static String toString(Object obj) throws JSONException {
        return toString(obj, null);
    }

    public static String toString(Object obj, String str) throws JSONException {
        String str2;
        JSONArray jSONArray;
        StringBuilder sb = new StringBuilder();
        if (obj instanceof JSONObject) {
            if (str != null) {
                sb.append('<');
                sb.append(str);
                sb.append('>');
            }
            JSONObject jSONObject = (JSONObject) obj;
            for (String next : jSONObject.keySet()) {
                Object opt = jSONObject.opt(next);
                if (opt == null) {
                    opt = "";
                } else if (opt.getClass().isArray()) {
                    opt = new JSONArray(opt);
                }
                if ("content".equals(next)) {
                    if (opt instanceof JSONArray) {
                        JSONArray jSONArray2 = (JSONArray) opt;
                        int length = jSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            if (i > 0) {
                                sb.append(10);
                            }
                            sb.append(escape(jSONArray2.opt(i).toString()));
                        }
                    } else {
                        sb.append(escape(opt.toString()));
                    }
                } else if (opt instanceof JSONArray) {
                    JSONArray jSONArray3 = (JSONArray) opt;
                    int length2 = jSONArray3.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        Object opt2 = jSONArray3.opt(i2);
                        if (opt2 instanceof JSONArray) {
                            sb.append('<');
                            sb.append(next);
                            sb.append('>');
                            sb.append(toString(opt2));
                            sb.append("</");
                            sb.append(next);
                            sb.append('>');
                        } else {
                            sb.append(toString(opt2, next));
                        }
                    }
                } else if ("".equals(opt)) {
                    sb.append('<');
                    sb.append(next);
                    sb.append("/>");
                } else {
                    sb.append(toString(opt, next));
                }
            }
            if (str != null) {
                sb.append("</");
                sb.append(str);
                sb.append('>');
            }
            return sb.toString();
        } else if (obj == null || (!(obj instanceof JSONArray) && !obj.getClass().isArray())) {
            if (obj == null) {
                str2 = "null";
            } else {
                str2 = escape(obj.toString());
            }
            if (str == null) {
                return jdn.f1779O000000o + str2 + jdn.f1779O000000o;
            } else if (str2.length() == 0) {
                return "<" + str + "/>";
            } else {
                return "<" + str + ">" + str2 + "</" + str + ">";
            }
        } else {
            if (obj.getClass().isArray()) {
                jSONArray = new JSONArray(obj);
            } else {
                jSONArray = (JSONArray) obj;
            }
            int length3 = jSONArray.length();
            for (int i3 = 0; i3 < length3; i3++) {
                sb.append(toString(jSONArray.opt(i3), str == null ? "array" : str));
            }
            return sb.toString();
        }
    }
}

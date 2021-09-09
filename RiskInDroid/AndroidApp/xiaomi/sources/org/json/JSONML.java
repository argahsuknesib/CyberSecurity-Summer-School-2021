package org.json;

public class JSONML {
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0114, code lost:
        r6 = r8.nextToken();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x011a, code lost:
        if ((r6 instanceof java.lang.String) == false) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x011c, code lost:
        if (r11 == false) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x011e, code lost:
        r6 = (java.lang.String) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0121, code lost:
        r6 = org.json.XML.stringToValue((java.lang.String) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0131, code lost:
        throw r8.syntaxError("Missing value");
     */
    private static Object parse(XMLTokener xMLTokener, boolean z, JSONArray jSONArray, boolean z2) throws JSONException {
        String str;
        Object obj;
        loop0:
        while (xMLTokener.more()) {
            Object nextContent = xMLTokener.nextContent();
            if (nextContent == XML.LT) {
                Object nextToken = xMLTokener.nextToken();
                if (nextToken instanceof Character) {
                    if (nextToken == XML.SLASH) {
                        Object nextToken2 = xMLTokener.nextToken();
                        if (!(nextToken2 instanceof String)) {
                            throw new JSONException("Expected a closing name instead of '" + nextToken2 + "'.");
                        } else if (xMLTokener.nextToken() == XML.GT) {
                            return nextToken2;
                        } else {
                            throw xMLTokener.syntaxError("Misshaped close tag");
                        }
                    } else if (nextToken == XML.BANG) {
                        char next = xMLTokener.next();
                        if (next == '-') {
                            if (xMLTokener.next() == '-') {
                                xMLTokener.skipPast("-->");
                            } else {
                                xMLTokener.back();
                            }
                        } else if (next != '[') {
                            int i = 1;
                            do {
                                Object nextMeta = xMLTokener.nextMeta();
                                if (nextMeta == null) {
                                    throw xMLTokener.syntaxError("Missing '>' after '<!'.");
                                } else if (nextMeta == XML.LT) {
                                    i++;
                                    continue;
                                } else if (nextMeta == XML.GT) {
                                    i--;
                                    continue;
                                } else {
                                    continue;
                                }
                            } while (i > 0);
                        } else if (!xMLTokener.nextToken().equals("CDATA") || xMLTokener.next() != '[') {
                            throw xMLTokener.syntaxError("Expected 'CDATA['");
                        } else if (jSONArray != null) {
                            jSONArray.put(xMLTokener.nextCDATA());
                        }
                    } else if (nextToken == XML.QUEST) {
                        xMLTokener.skipPast("?>");
                    } else {
                        throw xMLTokener.syntaxError("Misshaped tag");
                    }
                } else if (nextToken instanceof String) {
                    String str2 = (String) nextToken;
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    if (z) {
                        jSONArray2.put(str2);
                        if (jSONArray != null) {
                            jSONArray.put(jSONArray2);
                        }
                    } else {
                        jSONObject.put("tagName", str2);
                        if (jSONArray != null) {
                            jSONArray.put(jSONObject);
                        }
                    }
                    while (true) {
                        Object obj2 = null;
                        while (true) {
                            if (obj2 == null) {
                                obj2 = xMLTokener.nextToken();
                            }
                            if (obj2 == null) {
                                throw xMLTokener.syntaxError("Misshaped tag");
                            } else if (obj2 instanceof String) {
                                str = (String) obj2;
                                if (z || (!"tagName".equals(str) && !"childNode".equals(str))) {
                                    Object nextToken3 = xMLTokener.nextToken();
                                    if (nextToken3 == XML.EQ) {
                                        break;
                                    }
                                    jSONObject.accumulate(str, "");
                                    obj2 = nextToken3;
                                }
                            } else {
                                if (z && jSONObject.length() > 0) {
                                    jSONArray2.put(jSONObject);
                                }
                                if (obj2 == XML.SLASH) {
                                    if (xMLTokener.nextToken() != XML.GT) {
                                        throw xMLTokener.syntaxError("Misshaped tag");
                                    } else if (jSONArray == null) {
                                        return z ? jSONArray2 : jSONObject;
                                    }
                                } else if (obj2 == XML.GT) {
                                    String str3 = (String) parse(xMLTokener, z, jSONArray2, z2);
                                    if (str3 == null) {
                                        continue;
                                    } else if (str3.equals(str2)) {
                                        if (!z && jSONArray2.length() > 0) {
                                            jSONObject.put("childNodes", jSONArray2);
                                        }
                                        if (jSONArray == null) {
                                            return z ? jSONArray2 : jSONObject;
                                        }
                                    } else {
                                        throw xMLTokener.syntaxError("Mismatched '" + str2 + "' and '" + str3 + "'");
                                    }
                                } else {
                                    throw xMLTokener.syntaxError("Misshaped tag");
                                }
                            }
                        }
                        jSONObject.accumulate(str, obj);
                    }
                    throw xMLTokener.syntaxError("Reserved attribute.");
                } else {
                    throw xMLTokener.syntaxError("Bad tagName '" + nextToken + "'.");
                }
            } else if (jSONArray != null) {
                if (nextContent instanceof String) {
                    nextContent = z2 ? XML.unescape((String) nextContent) : XML.stringToValue((String) nextContent);
                }
                jSONArray.put(nextContent);
            }
        }
        throw xMLTokener.syntaxError("Bad XML");
    }

    public static JSONArray toJSONArray(String str) throws JSONException {
        return (JSONArray) parse(new XMLTokener(str), true, null, false);
    }

    public static JSONArray toJSONArray(String str, boolean z) throws JSONException {
        return (JSONArray) parse(new XMLTokener(str), true, null, z);
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener, boolean z) throws JSONException {
        return (JSONArray) parse(xMLTokener, true, null, z);
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener) throws JSONException {
        return (JSONArray) parse(xMLTokener, true, null, false);
    }

    public static JSONObject toJSONObject(String str) throws JSONException {
        return (JSONObject) parse(new XMLTokener(str), false, null, false);
    }

    public static JSONObject toJSONObject(String str, boolean z) throws JSONException {
        return (JSONObject) parse(new XMLTokener(str), false, null, z);
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener) throws JSONException {
        return (JSONObject) parse(xMLTokener, false, null, false);
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener, boolean z) throws JSONException {
        return (JSONObject) parse(xMLTokener, false, null, z);
    }

    public static String toString(JSONArray jSONArray) throws JSONException {
        int i;
        StringBuilder sb = new StringBuilder();
        String string = jSONArray.getString(0);
        XML.noSpace(string);
        String escape = XML.escape(string);
        sb.append('<');
        sb.append(escape);
        Object opt = jSONArray.opt(1);
        if (opt instanceof JSONObject) {
            i = 2;
            JSONObject jSONObject = (JSONObject) opt;
            for (String next : jSONObject.keySet()) {
                Object opt2 = jSONObject.opt(next);
                XML.noSpace(next);
                if (opt2 != null) {
                    sb.append(' ');
                    sb.append(XML.escape(next));
                    sb.append('=');
                    sb.append('\"');
                    sb.append(XML.escape(opt2.toString()));
                    sb.append('\"');
                }
            }
        } else {
            i = 1;
        }
        int length = jSONArray.length();
        if (i >= length) {
            sb.append('/');
            sb.append('>');
        } else {
            sb.append('>');
            do {
                Object obj = jSONArray.get(i);
                i++;
                if (obj != null) {
                    if (obj instanceof String) {
                        sb.append(XML.escape(obj.toString()));
                        continue;
                    } else if (obj instanceof JSONObject) {
                        sb.append(toString((JSONObject) obj));
                        continue;
                    } else if (obj instanceof JSONArray) {
                        sb.append(toString((JSONArray) obj));
                        continue;
                    } else {
                        sb.append(obj.toString());
                        continue;
                    }
                }
            } while (i < length);
            sb.append('<');
            sb.append('/');
            sb.append(escape);
            sb.append('>');
        }
        return sb.toString();
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder();
        String optString = jSONObject.optString("tagName");
        if (optString == null) {
            return XML.escape(jSONObject.toString());
        }
        XML.noSpace(optString);
        String escape = XML.escape(optString);
        sb.append('<');
        sb.append(escape);
        for (String next : jSONObject.keySet()) {
            if (!"tagName".equals(next) && !"childNodes".equals(next)) {
                XML.noSpace(next);
                Object opt = jSONObject.opt(next);
                if (opt != null) {
                    sb.append(' ');
                    sb.append(XML.escape(next));
                    sb.append('=');
                    sb.append('\"');
                    sb.append(XML.escape(opt.toString()));
                    sb.append('\"');
                }
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("childNodes");
        if (optJSONArray == null) {
            sb.append('/');
            sb.append('>');
        } else {
            sb.append('>');
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj = optJSONArray.get(i);
                if (obj != null) {
                    if (obj instanceof String) {
                        sb.append(XML.escape(obj.toString()));
                    } else if (obj instanceof JSONObject) {
                        sb.append(toString((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        sb.append(toString((JSONArray) obj));
                    } else {
                        sb.append(obj.toString());
                    }
                }
            }
            sb.append('<');
            sb.append('/');
            sb.append(escape);
            sb.append('>');
        }
        return sb.toString();
    }
}

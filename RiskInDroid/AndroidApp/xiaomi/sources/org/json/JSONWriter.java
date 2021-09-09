package org.json;

import _m_j.jdn;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

public class JSONWriter {
    private boolean comma = false;
    protected char mode = 'i';
    private final JSONObject[] stack = new JSONObject[200];
    private int top = 0;
    protected Appendable writer;

    public JSONWriter(Appendable appendable) {
        this.writer = appendable;
    }

    private JSONWriter append(String str) throws JSONException {
        if (str != null) {
            char c = this.mode;
            if (c == 'o' || c == 'a') {
                try {
                    if (this.comma && this.mode == 'a') {
                        this.writer.append(',');
                    }
                    this.writer.append(str);
                    if (this.mode == 'o') {
                        this.mode = 'k';
                    }
                    this.comma = true;
                    return this;
                } catch (IOException e) {
                    throw new JSONException(e);
                }
            } else {
                throw new JSONException("Value out of sequence.");
            }
        } else {
            throw new JSONException("Null pointer");
        }
    }

    public JSONWriter array() throws JSONException {
        char c = this.mode;
        if (c == 'i' || c == 'o' || c == 'a') {
            push(null);
            append("[");
            this.comma = false;
            return this;
        }
        throw new JSONException("Misplaced array.");
    }

    private JSONWriter end(char c, char c2) throws JSONException {
        if (this.mode != c) {
            throw new JSONException(c == 'a' ? "Misplaced endArray." : "Misplaced endObject.");
        }
        pop(c);
        try {
            this.writer.append(c2);
            this.comma = true;
            return this;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    public JSONWriter endArray() throws JSONException {
        return end('a', ']');
    }

    public JSONWriter endObject() throws JSONException {
        return end('k', '}');
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public JSONWriter key(String str) throws JSONException {
        if (str == null) {
            throw new JSONException("Null key.");
        } else if (this.mode == 'k') {
            try {
                JSONObject jSONObject = this.stack[this.top - 1];
                if (!jSONObject.has(str)) {
                    jSONObject.put(str, true);
                    if (this.comma) {
                        this.writer.append(',');
                    }
                    this.writer.append(JSONObject.quote(str));
                    this.writer.append(':');
                    this.comma = false;
                    this.mode = 'o';
                    return this;
                }
                throw new JSONException("Duplicate key \"" + str + jdn.f1779O000000o);
            } catch (IOException e) {
                throw new JSONException(e);
            }
        } else {
            throw new JSONException("Misplaced key.");
        }
    }

    public JSONWriter object() throws JSONException {
        if (this.mode == 'i') {
            this.mode = 'o';
        }
        char c = this.mode;
        if (c == 'o' || c == 'a') {
            append("{");
            push(new JSONObject());
            this.comma = false;
            return this;
        }
        throw new JSONException("Misplaced object.");
    }

    private void pop(char c) throws JSONException {
        int i = this.top;
        if (i > 0) {
            char c2 = 'a';
            if ((this.stack[i + -1] == null ? 'a' : 'k') == c) {
                this.top--;
                int i2 = this.top;
                if (i2 == 0) {
                    c2 = 'd';
                } else if (this.stack[i2 - 1] != null) {
                    c2 = 'k';
                }
                this.mode = c2;
                return;
            }
            throw new JSONException("Nesting error.");
        }
        throw new JSONException("Nesting error.");
    }

    private void push(JSONObject jSONObject) throws JSONException {
        int i = this.top;
        if (i < 200) {
            this.stack[i] = jSONObject;
            this.mode = jSONObject == null ? 'a' : 'k';
            this.top++;
            return;
        }
        throw new JSONException("Nesting too deep.");
    }

    public static String valueToString(Object obj) throws JSONException {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (obj instanceof JSONString) {
            try {
                String jSONString = ((JSONString) obj).toJSONString();
                if (jSONString instanceof String) {
                    return jSONString;
                }
                throw new JSONException("Bad value from toJSONString: ".concat(String.valueOf(jSONString)));
            } catch (Exception e) {
                throw new JSONException(e);
            }
        } else if (obj instanceof Number) {
            String numberToString = JSONObject.numberToString((Number) obj);
            try {
                new BigDecimal(numberToString);
                return numberToString;
            } catch (NumberFormatException unused) {
                return JSONObject.quote(numberToString);
            }
        } else if ((obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj.toString();
        } else {
            if (obj instanceof Map) {
                return new JSONObject((Map<?, ?>) ((Map) obj)).toString();
            }
            if (obj instanceof Collection) {
                return new JSONArray((Collection<?>) ((Collection) obj)).toString();
            }
            if (obj.getClass().isArray()) {
                return new JSONArray(obj).toString();
            }
            if (obj instanceof Enum) {
                return JSONObject.quote(((Enum) obj).name());
            }
            return JSONObject.quote(obj.toString());
        }
    }

    public JSONWriter value(boolean z) throws JSONException {
        return append(z ? "true" : "false");
    }

    public JSONWriter value(double d) throws JSONException {
        return value(Double.valueOf(d));
    }

    public JSONWriter value(long j) throws JSONException {
        return append(Long.toString(j));
    }

    public JSONWriter value(Object obj) throws JSONException {
        return append(valueToString(obj));
    }
}

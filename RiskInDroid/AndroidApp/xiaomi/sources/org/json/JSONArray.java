package org.json;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSONArray implements Iterable<Object> {
    private final ArrayList<Object> myArrayList;

    public JSONArray() {
        this.myArrayList = new ArrayList<>();
    }

    public JSONArray(JSONTokener jSONTokener) throws JSONException {
        this();
        if (jSONTokener.nextClean() == '[') {
            char nextClean = jSONTokener.nextClean();
            if (nextClean == 0) {
                throw jSONTokener.syntaxError("Expected a ',' or ']'");
            } else if (nextClean != ']') {
                jSONTokener.back();
                while (true) {
                    if (jSONTokener.nextClean() == ',') {
                        jSONTokener.back();
                        this.myArrayList.add(JSONObject.NULL);
                    } else {
                        jSONTokener.back();
                        this.myArrayList.add(jSONTokener.nextValue());
                    }
                    char nextClean2 = jSONTokener.nextClean();
                    if (nextClean2 == 0) {
                        throw jSONTokener.syntaxError("Expected a ',' or ']'");
                    } else if (nextClean2 == ',') {
                        char nextClean3 = jSONTokener.nextClean();
                        if (nextClean3 == 0) {
                            throw jSONTokener.syntaxError("Expected a ',' or ']'");
                        } else if (nextClean3 != ']') {
                            jSONTokener.back();
                        } else {
                            return;
                        }
                    } else if (nextClean2 != ']') {
                        throw jSONTokener.syntaxError("Expected a ',' or ']'");
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw jSONTokener.syntaxError("A JSONArray text must start with '['");
        }
    }

    public JSONArray(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    public JSONArray(Collection<?> collection) {
        if (collection == null) {
            this.myArrayList = new ArrayList<>();
            return;
        }
        this.myArrayList = new ArrayList<>(collection.size());
        for (Object wrap : collection) {
            this.myArrayList.add(JSONObject.wrap(wrap));
        }
    }

    public JSONArray(Object obj) throws JSONException {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            this.myArrayList.ensureCapacity(length);
            for (int i = 0; i < length; i++) {
                put(JSONObject.wrap(Array.get(obj, i)));
            }
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }

    public Iterator<Object> iterator() {
        return this.myArrayList.iterator();
    }

    public Object get(int i) throws JSONException {
        Object opt = opt(i);
        if (opt != null) {
            return opt;
        }
        throw new JSONException("JSONArray[" + i + "] not found.");
    }

    public boolean getBoolean(int i) throws JSONException {
        Object obj = get(i);
        if (obj.equals(Boolean.FALSE)) {
            return false;
        }
        boolean z = obj instanceof String;
        if (z && ((String) obj).equalsIgnoreCase("false")) {
            return false;
        }
        if (obj.equals(Boolean.TRUE)) {
            return true;
        }
        if (z && ((String) obj).equalsIgnoreCase("true")) {
            return true;
        }
        throw new JSONException("JSONArray[" + i + "] is not a boolean.");
    }

    public double getDouble(int i) throws JSONException {
        Object obj = get(i);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).doubleValue();
            }
            return Double.parseDouble((String) obj);
        } catch (Exception e) {
            throw new JSONException("JSONArray[" + i + "] is not a number.", e);
        }
    }

    public float getFloat(int i) throws JSONException {
        Object obj = get(i);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).floatValue();
            }
            return Float.parseFloat(obj.toString());
        } catch (Exception e) {
            throw new JSONException("JSONArray[" + i + "] is not a number.", e);
        }
    }

    public Number getNumber(int i) throws JSONException {
        Object obj = get(i);
        try {
            if (obj instanceof Number) {
                return (Number) obj;
            }
            return JSONObject.stringToNumber(obj.toString());
        } catch (Exception e) {
            throw new JSONException("JSONArray[" + i + "] is not a number.", e);
        }
    }

    public <E extends Enum<E>> E getEnum(Class<E> cls, int i) throws JSONException {
        E optEnum = optEnum(cls, i);
        if (optEnum != null) {
            return optEnum;
        }
        throw new JSONException("JSONArray[" + i + "] is not an enum of type " + JSONObject.quote(cls.getSimpleName()) + ".");
    }

    public BigDecimal getBigDecimal(int i) throws JSONException {
        try {
            return new BigDecimal(get(i).toString());
        } catch (Exception e) {
            throw new JSONException("JSONArray[" + i + "] could not convert to BigDecimal.", e);
        }
    }

    public BigInteger getBigInteger(int i) throws JSONException {
        try {
            return new BigInteger(get(i).toString());
        } catch (Exception e) {
            throw new JSONException("JSONArray[" + i + "] could not convert to BigInteger.", e);
        }
    }

    public int getInt(int i) throws JSONException {
        Object obj = get(i);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
            return Integer.parseInt((String) obj);
        } catch (Exception e) {
            throw new JSONException("JSONArray[" + i + "] is not a number.", e);
        }
    }

    public JSONArray getJSONArray(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw new JSONException("JSONArray[" + i + "] is not a JSONArray.");
    }

    public JSONObject getJSONObject(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw new JSONException("JSONArray[" + i + "] is not a JSONObject.");
    }

    public long getLong(int i) throws JSONException {
        Object obj = get(i);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            return Long.parseLong((String) obj);
        } catch (Exception e) {
            throw new JSONException("JSONArray[" + i + "] is not a number.", e);
        }
    }

    public String getString(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new JSONException("JSONArray[" + i + "] not a string.");
    }

    public boolean isNull(int i) {
        return JSONObject.NULL.equals(opt(i));
    }

    public String join(String str) throws JSONException {
        int length = length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(str);
            }
            sb.append(JSONObject.valueToString(this.myArrayList.get(i)));
        }
        return sb.toString();
    }

    public int length() {
        return this.myArrayList.size();
    }

    public Object opt(int i) {
        if (i < 0 || i >= length()) {
            return null;
        }
        return this.myArrayList.get(i);
    }

    public boolean optBoolean(int i) {
        return optBoolean(i, false);
    }

    public boolean optBoolean(int i, boolean z) {
        try {
            return getBoolean(i);
        } catch (Exception unused) {
            return z;
        }
    }

    public double optDouble(int i) {
        return optDouble(i, Double.NaN);
    }

    public double optDouble(int i, double d) {
        Object opt = opt(i);
        if (JSONObject.NULL.equals(opt)) {
            return d;
        }
        if (opt instanceof Number) {
            return ((Number) opt).doubleValue();
        }
        if (opt instanceof String) {
            try {
                return Double.parseDouble((String) opt);
            } catch (Exception unused) {
            }
        }
        return d;
    }

    public float optFloat(int i) {
        return optFloat(i, Float.NaN);
    }

    public float optFloat(int i, float f) {
        Object opt = opt(i);
        if (JSONObject.NULL.equals(opt)) {
            return f;
        }
        if (opt instanceof Number) {
            return ((Number) opt).floatValue();
        }
        if (opt instanceof String) {
            try {
                return Float.parseFloat((String) opt);
            } catch (Exception unused) {
            }
        }
        return f;
    }

    public int optInt(int i) {
        return optInt(i, 0);
    }

    public int optInt(int i, int i2) {
        Object opt = opt(i);
        if (JSONObject.NULL.equals(opt)) {
            return i2;
        }
        if (opt instanceof Number) {
            return ((Number) opt).intValue();
        }
        if (opt instanceof String) {
            try {
                return new BigDecimal(opt.toString()).intValue();
            } catch (Exception unused) {
            }
        }
        return i2;
    }

    public <E extends Enum<E>> E optEnum(Class<E> cls, int i) {
        return optEnum(cls, i, null);
    }

    public <E extends Enum<E>> E optEnum(Class<E> cls, int i, E e) {
        try {
            E opt = opt(i);
            if (JSONObject.NULL.equals(opt)) {
                return e;
            }
            if (cls.isAssignableFrom(opt.getClass())) {
                return (Enum) opt;
            }
            return Enum.valueOf(cls, opt.toString());
        } catch (IllegalArgumentException | NullPointerException unused) {
            return e;
        }
    }

    public BigInteger optBigInteger(int i, BigInteger bigInteger) {
        Object opt = opt(i);
        if (JSONObject.NULL.equals(opt)) {
            return bigInteger;
        }
        if (opt instanceof BigInteger) {
            return (BigInteger) opt;
        }
        if (opt instanceof BigDecimal) {
            return ((BigDecimal) opt).toBigInteger();
        }
        if ((opt instanceof Double) || (opt instanceof Float)) {
            return new BigDecimal(((Number) opt).doubleValue()).toBigInteger();
        }
        if ((opt instanceof Long) || (opt instanceof Integer) || (opt instanceof Short) || (opt instanceof Byte)) {
            return BigInteger.valueOf(((Number) opt).longValue());
        }
        try {
            String obj = opt.toString();
            if (JSONObject.isDecimalNotation(obj)) {
                return new BigDecimal(obj).toBigInteger();
            }
            return new BigInteger(obj);
        } catch (Exception unused) {
            return bigInteger;
        }
    }

    public BigDecimal optBigDecimal(int i, BigDecimal bigDecimal) {
        Object opt = opt(i);
        if (JSONObject.NULL.equals(opt)) {
            return bigDecimal;
        }
        if (opt instanceof BigDecimal) {
            return (BigDecimal) opt;
        }
        if (opt instanceof BigInteger) {
            return new BigDecimal((BigInteger) opt);
        }
        if ((opt instanceof Double) || (opt instanceof Float)) {
            return new BigDecimal(((Number) opt).doubleValue());
        }
        if ((opt instanceof Long) || (opt instanceof Integer) || (opt instanceof Short) || (opt instanceof Byte)) {
            return new BigDecimal(((Number) opt).longValue());
        }
        try {
            return new BigDecimal(opt.toString());
        } catch (Exception unused) {
            return bigDecimal;
        }
    }

    public JSONArray optJSONArray(int i) {
        Object opt = opt(i);
        if (opt instanceof JSONArray) {
            return (JSONArray) opt;
        }
        return null;
    }

    public JSONObject optJSONObject(int i) {
        Object opt = opt(i);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    public long optLong(int i) {
        return optLong(i, 0);
    }

    public long optLong(int i, long j) {
        Object opt = opt(i);
        if (JSONObject.NULL.equals(opt)) {
            return j;
        }
        if (opt instanceof Number) {
            return ((Number) opt).longValue();
        }
        if (opt instanceof String) {
            try {
                return new BigDecimal(opt.toString()).longValue();
            } catch (Exception unused) {
            }
        }
        return j;
    }

    public Number optNumber(int i) {
        return optNumber(i, null);
    }

    public Number optNumber(int i, Number number) {
        Object opt = opt(i);
        if (JSONObject.NULL.equals(opt)) {
            return number;
        }
        if (opt instanceof Number) {
            return (Number) opt;
        }
        if (opt instanceof String) {
            try {
                return JSONObject.stringToNumber((String) opt);
            } catch (Exception unused) {
            }
        }
        return number;
    }

    public String optString(int i) {
        return optString(i, "");
    }

    public String optString(int i, String str) {
        Object opt = opt(i);
        if (JSONObject.NULL.equals(opt)) {
            return str;
        }
        return opt.toString();
    }

    public JSONArray put(boolean z) {
        put(z ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    public JSONArray put(Collection<?> collection) {
        put(new JSONArray(collection));
        return this;
    }

    public JSONArray put(double d) throws JSONException {
        Double valueOf = Double.valueOf(d);
        JSONObject.testValidity(valueOf);
        put(valueOf);
        return this;
    }

    public JSONArray put(int i) {
        put(Integer.valueOf(i));
        return this;
    }

    public JSONArray put(long j) {
        put(new Long(j));
        return this;
    }

    public JSONArray put(Map<?, ?> map) {
        put(new JSONObject(map));
        return this;
    }

    public JSONArray put(Object obj) {
        this.myArrayList.add(obj);
        return this;
    }

    public JSONArray put(int i, boolean z) throws JSONException {
        put(i, z ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    public JSONArray put(int i, Collection<?> collection) throws JSONException {
        put(i, new JSONArray(collection));
        return this;
    }

    public JSONArray put(int i, double d) throws JSONException {
        put(i, Double.valueOf(d));
        return this;
    }

    public JSONArray put(int i, int i2) throws JSONException {
        put(i, Integer.valueOf(i2));
        return this;
    }

    public JSONArray put(int i, long j) throws JSONException {
        put(i, new Long(j));
        return this;
    }

    public JSONArray put(int i, Map<?, ?> map) throws JSONException {
        put(i, new JSONObject(map));
        return this;
    }

    public JSONArray put(int i, Object obj) throws JSONException {
        JSONObject.testValidity(obj);
        if (i >= 0) {
            if (i < length()) {
                this.myArrayList.set(i, obj);
            } else if (i == length()) {
                put(obj);
            } else {
                this.myArrayList.ensureCapacity(i + 1);
                while (i != length()) {
                    put(JSONObject.NULL);
                }
                put(obj);
            }
            return this;
        }
        throw new JSONException("JSONArray[" + i + "] not found.");
    }

    public Object query(String str) {
        return query(new JSONPointer(str));
    }

    public Object query(JSONPointer jSONPointer) {
        return jSONPointer.queryFrom(this);
    }

    public Object optQuery(String str) {
        return optQuery(new JSONPointer(str));
    }

    public Object optQuery(JSONPointer jSONPointer) {
        try {
            return jSONPointer.queryFrom(this);
        } catch (JSONPointerException unused) {
            return null;
        }
    }

    public Object remove(int i) {
        if (i < 0 || i >= length()) {
            return null;
        }
        return this.myArrayList.remove(i);
    }

    public boolean similar(Object obj) {
        if (!(obj instanceof JSONArray)) {
            return false;
        }
        int length = length();
        JSONArray jSONArray = (JSONArray) obj;
        if (length != jSONArray.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            Object obj2 = this.myArrayList.get(i);
            Object obj3 = jSONArray.myArrayList.get(i);
            if (obj2 != obj3) {
                if (obj2 == null) {
                    return false;
                }
                if (obj2 instanceof JSONObject) {
                    if (!((JSONObject) obj2).similar(obj3)) {
                        return false;
                    }
                } else if (obj2 instanceof JSONArray) {
                    if (!((JSONArray) obj2).similar(obj3)) {
                        return false;
                    }
                } else if (!obj2.equals(obj3)) {
                    return false;
                }
            }
        }
        return true;
    }

    public JSONObject toJSONObject(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0 || length() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            jSONObject.put(jSONArray.getString(i), opt(i));
        }
        return jSONObject;
    }

    public String toString() {
        try {
            return toString(0);
        } catch (Exception unused) {
            return null;
        }
    }

    public String toString(int i) throws JSONException {
        String obj;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            obj = write(stringWriter, i, 0).toString();
        }
        return obj;
    }

    public Writer write(Writer writer) throws JSONException {
        return write(writer, 0, 0);
    }

    public Writer write(Writer writer, int i, int i2) throws JSONException {
        int i3;
        try {
            int length = length();
            writer.write(91);
            i3 = 0;
            if (length == 1) {
                JSONObject.writeValue(writer, this.myArrayList.get(0), i, i2);
            } else if (length != 0) {
                int i4 = i2 + i;
                boolean z = false;
                while (i3 < length) {
                    if (z) {
                        writer.write(44);
                    }
                    if (i > 0) {
                        writer.write(10);
                    }
                    JSONObject.indent(writer, i4);
                    JSONObject.writeValue(writer, this.myArrayList.get(i3), i, i4);
                    i3++;
                    z = true;
                }
                if (i > 0) {
                    writer.write(10);
                }
                JSONObject.indent(writer, i2);
            }
            writer.write(93);
            return writer;
        } catch (Exception e) {
            throw new JSONException("Unable to write JSONArray value at index: ".concat(String.valueOf(i3)), e);
        } catch (Exception e2) {
            throw new JSONException("Unable to write JSONArray value at index: 0", e2);
        } catch (IOException e3) {
            throw new JSONException(e3);
        }
    }

    public List<Object> toList() {
        ArrayList arrayList = new ArrayList(this.myArrayList.size());
        Iterator<Object> it = this.myArrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next == null || JSONObject.NULL.equals(next)) {
                arrayList.add(null);
            } else if (next instanceof JSONArray) {
                arrayList.add(((JSONArray) next).toList());
            } else if (next instanceof JSONObject) {
                arrayList.add(((JSONObject) next).toMap());
            } else {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}

package org.json;

import _m_j.jdn;
import com.google.android.exoplayer2.C;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class JSONObject {
    public static final Object NULL = new Null();
    private final Map<String, Object> map;

    static final class Null {
        /* access modifiers changed from: protected */
        public final Object clone() {
            return this;
        }

        public final boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "null";
        }

        private Null() {
        }
    }

    public JSONObject() {
        this.map = new HashMap();
    }

    public JSONObject(JSONObject jSONObject, String[] strArr) {
        this(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            try {
                putOnce(strArr[i], jSONObject.opt(strArr[i]));
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject(JSONTokener jSONTokener) throws JSONException {
        this();
        if (jSONTokener.nextClean() == '{') {
            while (true) {
                char nextClean = jSONTokener.nextClean();
                if (nextClean == 0) {
                    throw jSONTokener.syntaxError("A JSONObject text must end with '}'");
                } else if (nextClean != '}') {
                    jSONTokener.back();
                    String obj = jSONTokener.nextValue().toString();
                    if (jSONTokener.nextClean() == ':') {
                        if (obj != null) {
                            if (opt(obj) == null) {
                                Object nextValue = jSONTokener.nextValue();
                                if (nextValue != null) {
                                    put(obj, nextValue);
                                }
                            } else {
                                throw jSONTokener.syntaxError("Duplicate key \"" + obj + jdn.f1779O000000o);
                            }
                        }
                        char nextClean2 = jSONTokener.nextClean();
                        if (nextClean2 == ',' || nextClean2 == ';') {
                            if (jSONTokener.nextClean() != '}') {
                                jSONTokener.back();
                            } else {
                                return;
                            }
                        } else if (nextClean2 != '}') {
                            throw jSONTokener.syntaxError("Expected a ',' or '}'");
                        } else {
                            return;
                        }
                    } else {
                        throw jSONTokener.syntaxError("Expected a ':' after a key");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw jSONTokener.syntaxError("A JSONObject text must begin with '{'");
        }
    }

    public JSONObject(Map<?, ?> map2) {
        if (map2 == null) {
            this.map = new HashMap();
            return;
        }
        this.map = new HashMap(map2.size());
        for (Map.Entry next : map2.entrySet()) {
            Object value = next.getValue();
            if (value != null) {
                this.map.put(String.valueOf(next.getKey()), wrap(value));
            }
        }
    }

    public JSONObject(Object obj) {
        this();
        populateMap(obj);
    }

    public JSONObject(Object obj, String[] strArr) {
        this(strArr.length);
        Class<?> cls = obj.getClass();
        for (String str : strArr) {
            try {
                putOpt(str, cls.getField(str).get(obj));
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    public JSONObject(String str, Locale locale) throws JSONException {
        this();
        ResourceBundle bundle = ResourceBundle.getBundle(str, locale, Thread.currentThread().getContextClassLoader());
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            if (nextElement != null) {
                String str2 = nextElement;
                String[] split = str2.split("\\.");
                int length = split.length - 1;
                JSONObject jSONObject = this;
                for (int i = 0; i < length; i++) {
                    String str3 = split[i];
                    JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                        jSONObject.put(str3, optJSONObject);
                    }
                    jSONObject = optJSONObject;
                }
                jSONObject.put(split[length], bundle.getString(str2));
            }
        }
    }

    protected JSONObject(int i) {
        this.map = new HashMap(i);
    }

    public JSONObject accumulate(String str, Object obj) throws JSONException {
        testValidity(obj);
        Object opt = opt(str);
        if (opt == null) {
            if (obj instanceof JSONArray) {
                obj = new JSONArray().put(obj);
            }
            put(str, obj);
        } else if (opt instanceof JSONArray) {
            ((JSONArray) opt).put(obj);
        } else {
            put(str, new JSONArray().put(opt).put(obj));
        }
        return this;
    }

    public JSONObject append(String str, Object obj) throws JSONException {
        testValidity(obj);
        Object opt = opt(str);
        if (opt == null) {
            put(str, new JSONArray().put(obj));
        } else if (opt instanceof JSONArray) {
            put(str, ((JSONArray) opt).put(obj));
        } else {
            throw new JSONException("JSONObject[" + str + "] is not a JSONArray.");
        }
        return this;
    }

    public static String doubleToString(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            return "null";
        }
        String d2 = Double.toString(d);
        if (d2.indexOf(46) <= 0 || d2.indexOf(101) >= 0 || d2.indexOf(69) >= 0) {
            return d2;
        }
        while (d2.endsWith("0")) {
            d2 = d2.substring(0, d2.length() - 1);
        }
        return d2.endsWith(".") ? d2.substring(0, d2.length() - 1) : d2;
    }

    public Object get(String str) throws JSONException {
        if (str != null) {
            Object opt = opt(str);
            if (opt != null) {
                return opt;
            }
            throw new JSONException("JSONObject[" + quote(str) + "] not found.");
        }
        throw new JSONException("Null key.");
    }

    public <E extends Enum<E>> E getEnum(Class<E> cls, String str) throws JSONException {
        E optEnum = optEnum(cls, str);
        if (optEnum != null) {
            return optEnum;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] is not an enum of type " + quote(cls.getSimpleName()) + ".");
    }

    public boolean getBoolean(String str) throws JSONException {
        Object obj = get(str);
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
        throw new JSONException("JSONObject[" + quote(str) + "] is not a Boolean.");
    }

    public BigInteger getBigInteger(String str) throws JSONException {
        try {
            return new BigInteger(get(str).toString());
        } catch (Exception e) {
            throw new JSONException("JSONObject[" + quote(str) + "] could not be converted to BigInteger.", e);
        }
    }

    public BigDecimal getBigDecimal(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        try {
            return new BigDecimal(obj.toString());
        } catch (Exception e) {
            throw new JSONException("JSONObject[" + quote(str) + "] could not be converted to BigDecimal.", e);
        }
    }

    public double getDouble(String str) throws JSONException {
        Object obj = get(str);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).doubleValue();
            }
            return Double.parseDouble(obj.toString());
        } catch (Exception e) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not a number.", e);
        }
    }

    public float getFloat(String str) throws JSONException {
        Object obj = get(str);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).floatValue();
            }
            return Float.parseFloat(obj.toString());
        } catch (Exception e) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not a number.", e);
        }
    }

    public Number getNumber(String str) throws JSONException {
        Object obj = get(str);
        try {
            if (obj instanceof Number) {
                return (Number) obj;
            }
            return stringToNumber(obj.toString());
        } catch (Exception e) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not a number.", e);
        }
    }

    public int getInt(String str) throws JSONException {
        Object obj = get(str);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
            return Integer.parseInt((String) obj);
        } catch (Exception e) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not an int.", e);
        }
    }

    public JSONArray getJSONArray(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] is not a JSONArray.");
    }

    public JSONObject getJSONObject(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] is not a JSONObject.");
    }

    public long getLong(String str) throws JSONException {
        Object obj = get(str);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            return Long.parseLong((String) obj);
        } catch (Exception e) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not a long.", e);
        }
    }

    public static String[] getNames(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length == 0) {
            return null;
        }
        return (String[]) jSONObject.keySet().toArray(new String[length]);
    }

    public static String[] getNames(Object obj) {
        Field[] fields;
        int length;
        if (obj == null || (length = (fields = obj.getClass().getFields()).length) == 0) {
            return null;
        }
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = fields[i].getName();
        }
        return strArr;
    }

    public String getString(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] not a string.");
    }

    public boolean has(String str) {
        return this.map.containsKey(str);
    }

    public JSONObject increment(String str) throws JSONException {
        Object opt = opt(str);
        if (opt == null) {
            put(str, 1);
        } else if (opt instanceof BigInteger) {
            put(str, ((BigInteger) opt).add(BigInteger.ONE));
        } else if (opt instanceof BigDecimal) {
            put(str, ((BigDecimal) opt).add(BigDecimal.ONE));
        } else if (opt instanceof Integer) {
            put(str, ((Integer) opt).intValue() + 1);
        } else if (opt instanceof Long) {
            put(str, ((Long) opt).longValue() + 1);
        } else if (opt instanceof Double) {
            put(str, ((Double) opt).doubleValue() + 1.0d);
        } else if (opt instanceof Float) {
            put(str, ((Float) opt).floatValue() + 1.0f);
        } else {
            throw new JSONException("Unable to increment [" + quote(str) + "].");
        }
        return this;
    }

    public boolean isNull(String str) {
        return NULL.equals(opt(str));
    }

    public Iterator<String> keys() {
        return keySet().iterator();
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    /* access modifiers changed from: protected */
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public int length() {
        return this.map.size();
    }

    public JSONArray names() {
        if (this.map.isEmpty()) {
            return null;
        }
        return new JSONArray((Collection<?>) this.map.keySet());
    }

    public static String numberToString(Number number) throws JSONException {
        if (number != null) {
            testValidity(number);
            String obj = number.toString();
            if (obj.indexOf(46) <= 0 || obj.indexOf(101) >= 0 || obj.indexOf(69) >= 0) {
                return obj;
            }
            while (obj.endsWith("0")) {
                obj = obj.substring(0, obj.length() - 1);
            }
            return obj.endsWith(".") ? obj.substring(0, obj.length() - 1) : obj;
        }
        throw new JSONException("Null pointer");
    }

    public Object opt(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str);
    }

    public <E extends Enum<E>> E optEnum(Class<E> cls, String str) {
        return optEnum(cls, str, null);
    }

    public <E extends Enum<E>> E optEnum(Class<E> cls, String str, E e) {
        try {
            E opt = opt(str);
            if (NULL.equals(opt)) {
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

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            return z;
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        try {
            return getBoolean(str);
        } catch (Exception unused) {
            return z;
        }
    }

    public BigDecimal optBigDecimal(String str, BigDecimal bigDecimal) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
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

    public BigInteger optBigInteger(String str, BigInteger bigInteger) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
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
            if (isDecimalNotation(obj)) {
                return new BigDecimal(obj).toBigInteger();
            }
            return new BigInteger(obj);
        } catch (Exception unused) {
            return bigInteger;
        }
    }

    public double optDouble(String str) {
        return optDouble(str, Double.NaN);
    }

    public double optDouble(String str, double d) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
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

    public float optFloat(String str) {
        return optFloat(str, Float.NaN);
    }

    public float optFloat(String str, float f) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
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

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            return i;
        }
        if (opt instanceof Number) {
            return ((Number) opt).intValue();
        }
        if (opt instanceof String) {
            try {
                return new BigDecimal((String) opt).intValue();
            } catch (Exception unused) {
            }
        }
        return i;
    }

    public JSONArray optJSONArray(String str) {
        Object opt = opt(str);
        if (opt instanceof JSONArray) {
            return (JSONArray) opt;
        }
        return null;
    }

    public JSONObject optJSONObject(String str) {
        Object opt = opt(str);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    public long optLong(String str) {
        return optLong(str, 0);
    }

    public long optLong(String str, long j) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            return j;
        }
        if (opt instanceof Number) {
            return ((Number) opt).longValue();
        }
        if (opt instanceof String) {
            try {
                return new BigDecimal((String) opt).longValue();
            } catch (Exception unused) {
            }
        }
        return j;
    }

    public Number optNumber(String str) {
        return optNumber(str, null);
    }

    public Number optNumber(String str, Number number) {
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            return number;
        }
        if (opt instanceof Number) {
            return (Number) opt;
        }
        if (opt instanceof String) {
            try {
                return stringToNumber((String) opt);
            } catch (Exception unused) {
            }
        }
        return number;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        Object opt = opt(str);
        return NULL.equals(opt) ? str2 : opt.toString();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[ExcHandler: IllegalAccessException | IllegalArgumentException | InvocationTargetException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:44:0x00cd] */
    private void populateMap(Object obj) {
        Method[] methodArr;
        String str;
        Class<?> cls = obj.getClass();
        if (cls.getClassLoader() != null) {
            methodArr = cls.getMethods();
        } else {
            methodArr = cls.getDeclaredMethods();
        }
        for (Method method : methodArr) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers) && method.getParameterTypes().length == 0 && !method.isBridge() && method.getReturnType() != Void.TYPE) {
                String name = method.getName();
                if (name.startsWith("get")) {
                    if (!"getClass".equals(name) && !"getDeclaringClass".equals(name)) {
                        str = name.substring(3);
                    }
                } else if (name.startsWith("is")) {
                    str = name.substring(2);
                }
                if (str.length() > 0 && Character.isUpperCase(str.charAt(0))) {
                    if (str.length() == 1) {
                        str = str.toLowerCase(Locale.ROOT);
                    } else if (!Character.isUpperCase(str.charAt(1))) {
                        str = str.substring(0, 1).toLowerCase(Locale.ROOT) + str.substring(1);
                    }
                    Object invoke = method.invoke(obj, new Object[0]);
                    if (invoke != null) {
                        this.map.put(str, wrap(invoke));
                        if (invoke instanceof Closeable) {
                            try {
                                ((Closeable) invoke).close();
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                            }
                        }
                    }
                }
            }
        }
    }

    public JSONObject put(String str, boolean z) throws JSONException {
        put(str, z ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    public JSONObject put(String str, Collection<?> collection) throws JSONException {
        put(str, new JSONArray(collection));
        return this;
    }

    public JSONObject put(String str, double d) throws JSONException {
        put(str, Double.valueOf(d));
        return this;
    }

    public JSONObject put(String str, float f) throws JSONException {
        put(str, Float.valueOf(f));
        return this;
    }

    public JSONObject put(String str, int i) throws JSONException {
        put(str, Integer.valueOf(i));
        return this;
    }

    public JSONObject put(String str, long j) throws JSONException {
        put(str, Long.valueOf(j));
        return this;
    }

    public JSONObject put(String str, Map<?, ?> map2) throws JSONException {
        put(str, new JSONObject(map2));
        return this;
    }

    public JSONObject put(String str, Object obj) throws JSONException {
        if (str != null) {
            if (obj != null) {
                testValidity(obj);
                this.map.put(str, obj);
            } else {
                remove(str);
            }
            return this;
        }
        throw new NullPointerException("Null key.");
    }

    public JSONObject putOnce(String str, Object obj) throws JSONException {
        if (!(str == null || obj == null)) {
            if (opt(str) == null) {
                put(str, obj);
            } else {
                throw new JSONException("Duplicate key \"" + str + jdn.f1779O000000o);
            }
        }
        return this;
    }

    public JSONObject putOpt(String str, Object obj) throws JSONException {
        if (!(str == null || obj == null)) {
            put(str, obj);
        }
        return this;
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

    public static String quote(String str) {
        String obj;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            try {
                obj = quote(str, stringWriter).toString();
            } catch (IOException unused) {
                return "";
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public static Writer quote(String str, Writer writer) throws IOException {
        if (str == null || str.length() == 0) {
            writer.write("\"\"");
            return writer;
        }
        int length = str.length();
        writer.write(34);
        int i = 0;
        char c = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                writer.write("\\f");
            } else if (charAt != 13) {
                if (charAt != '\"') {
                    if (charAt != '/') {
                        if (charAt != '\\') {
                            switch (charAt) {
                                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                    writer.write("\\b");
                                    break;
                                case 9:
                                    writer.write("\\t");
                                    break;
                                case 10:
                                    writer.write("\\n");
                                    break;
                                default:
                                    if (charAt < ' ' || ((charAt >= 128 && charAt < 160) || (charAt >= 8192 && charAt < 8448))) {
                                        writer.write("\\u");
                                        String hexString = Integer.toHexString(charAt);
                                        writer.write("0000", 0, 4 - hexString.length());
                                        writer.write(hexString);
                                        break;
                                    }
                                    writer.write(charAt);
                                    break;
                            }
                        }
                    } else {
                        if (c == '<') {
                            writer.write(92);
                        }
                        writer.write(charAt);
                    }
                }
                writer.write(92);
                writer.write(charAt);
            } else {
                writer.write("\\r");
            }
            i++;
            c = charAt;
        }
        writer.write(34);
        return writer;
    }

    public Object remove(String str) {
        return this.map.remove(str);
    }

    public boolean similar(Object obj) {
        if (!(obj instanceof JSONObject)) {
            return false;
        }
        try {
            if (!keySet().equals(((JSONObject) obj).keySet())) {
                return false;
            }
            for (Map.Entry next : entrySet()) {
                Object value = next.getValue();
                Object obj2 = ((JSONObject) obj).get((String) next.getKey());
                if (value != obj2) {
                    if (value == null) {
                        return false;
                    }
                    if (value instanceof JSONObject) {
                        if (!((JSONObject) value).similar(obj2)) {
                            return false;
                        }
                    } else if (value instanceof JSONArray) {
                        if (!((JSONArray) value).similar(obj2)) {
                            return false;
                        }
                    } else if (!value.equals(obj2)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    protected static boolean isDecimalNotation(String str) {
        return str.indexOf(46) >= 0 || str.indexOf(101) >= 0 || str.indexOf(69) >= 0 || "-0".equals(str);
    }

    protected static Number stringToNumber(String str) throws NumberFormatException {
        char charAt = str.charAt(0);
        if ((charAt < '0' || charAt > '9') && charAt != '-') {
            throw new NumberFormatException("val [" + str + "] is not a valid number.");
        } else if (!isDecimalNotation(str)) {
            BigInteger bigInteger = new BigInteger(str);
            if (bigInteger.bitLength() <= 31) {
                return Integer.valueOf(bigInteger.intValue());
            }
            return bigInteger.bitLength() <= 63 ? Long.valueOf(bigInteger.longValue()) : bigInteger;
        } else if (str.length() > 14) {
            return new BigDecimal(str);
        } else {
            Double valueOf = Double.valueOf(str);
            if (valueOf.isInfinite() || valueOf.isNaN()) {
                return new BigDecimal(str);
            }
            return valueOf;
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
            return NULL;
        }
        char charAt = str.charAt(0);
        if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
            try {
                if (isDecimalNotation(str)) {
                    Double valueOf = Double.valueOf(str);
                    if (valueOf.isInfinite() || valueOf.isNaN()) {
                        return str;
                    }
                    return valueOf;
                }
                Long valueOf2 = Long.valueOf(str);
                if (str.equals(valueOf2.toString())) {
                    return valueOf2.longValue() == ((long) valueOf2.intValue()) ? Integer.valueOf(valueOf2.intValue()) : valueOf2;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static void testValidity(Object obj) throws JSONException {
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

    public JSONArray toJSONArray(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            jSONArray2.put(opt(jSONArray.getString(i)));
        }
        return jSONArray2;
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

    public static String valueToString(Object obj) throws JSONException {
        return JSONWriter.valueToString(obj);
    }

    public static Object wrap(Object obj) {
        if (obj == null) {
            try {
                return NULL;
            } catch (Exception unused) {
                return null;
            }
        } else if ((obj instanceof JSONObject) || (obj instanceof JSONArray) || NULL.equals(obj) || (obj instanceof JSONString) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof BigInteger) || (obj instanceof BigDecimal)) {
            return obj;
        } else {
            if (obj instanceof Enum) {
                return obj;
            }
            if (obj instanceof Collection) {
                return new JSONArray((Collection<?>) ((Collection) obj));
            }
            if (obj.getClass().isArray()) {
                return new JSONArray(obj);
            }
            if (obj instanceof Map) {
                return new JSONObject((Map<?, ?>) ((Map) obj));
            }
            Package packageR = obj.getClass().getPackage();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.startsWith("java.") && !name.startsWith("javax.")) {
                if (obj.getClass().getClassLoader() != null) {
                    return new JSONObject(obj);
                }
            }
            return obj.toString();
        }
    }

    public Writer write(Writer writer) throws JSONException {
        return write(writer, 0, 0);
    }

    static final Writer writeValue(Writer writer, Object obj, int i, int i2) throws JSONException, IOException {
        if (obj == null || obj.equals(null)) {
            writer.write("null");
        } else if (obj instanceof JSONString) {
            try {
                String jSONString = ((JSONString) obj).toJSONString();
                writer.write(jSONString != null ? jSONString.toString() : quote(obj.toString()));
            } catch (Exception e) {
                throw new JSONException(e);
            }
        } else if (obj instanceof Number) {
            String numberToString = numberToString((Number) obj);
            try {
                new BigDecimal(numberToString);
                writer.write(numberToString);
            } catch (NumberFormatException unused) {
                quote(numberToString, writer);
            }
        } else if (obj instanceof Boolean) {
            writer.write(obj.toString());
        } else if (obj instanceof Enum) {
            writer.write(quote(((Enum) obj).name()));
        } else if (obj instanceof JSONObject) {
            ((JSONObject) obj).write(writer, i, i2);
        } else if (obj instanceof JSONArray) {
            ((JSONArray) obj).write(writer, i, i2);
        } else if (obj instanceof Map) {
            new JSONObject((Map<?, ?>) ((Map) obj)).write(writer, i, i2);
        } else if (obj instanceof Collection) {
            new JSONArray((Collection<?>) ((Collection) obj)).write(writer, i, i2);
        } else if (obj.getClass().isArray()) {
            new JSONArray(obj).write(writer, i, i2);
        } else {
            quote(obj.toString(), writer);
        }
        return writer;
    }

    static final void indent(Writer writer, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            writer.write(32);
        }
    }

    public Writer write(Writer writer, int i, int i2) throws JSONException {
        String str;
        String str2;
        boolean z = false;
        try {
            int length = length();
            writer.write(123);
            if (length == 1) {
                Map.Entry next = entrySet().iterator().next();
                str2 = (String) next.getKey();
                writer.write(quote(str2));
                writer.write(58);
                if (i > 0) {
                    writer.write(32);
                }
                writeValue(writer, next.getValue(), i, i2);
            } else if (length != 0) {
                int i3 = i2 + i;
                for (Map.Entry next2 : entrySet()) {
                    if (z) {
                        writer.write(44);
                    }
                    if (i > 0) {
                        writer.write(10);
                    }
                    indent(writer, i3);
                    str = (String) next2.getKey();
                    writer.write(quote(str));
                    writer.write(58);
                    if (i > 0) {
                        writer.write(32);
                    }
                    writeValue(writer, next2.getValue(), i, i3);
                    z = true;
                }
                if (i > 0) {
                    writer.write(10);
                }
                indent(writer, i2);
            }
            writer.write(125);
            return writer;
        } catch (Exception e) {
            throw new JSONException("Unable to write JSONObject value for key: ".concat(String.valueOf(str)), e);
        } catch (Exception e2) {
            throw new JSONException("Unable to write JSONObject value for key: ".concat(String.valueOf(str2)), e2);
        } catch (IOException e3) {
            throw new JSONException(e3);
        }
    }

    public Map<String, Object> toMap() {
        Object obj;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : entrySet()) {
            if (next.getValue() == null || NULL.equals(next.getValue())) {
                obj = null;
            } else if (next.getValue() instanceof JSONObject) {
                obj = ((JSONObject) next.getValue()).toMap();
            } else {
                obj = next.getValue() instanceof JSONArray ? ((JSONArray) next.getValue()).toList() : next.getValue();
            }
            hashMap.put(next.getKey(), obj);
        }
        return hashMap;
    }
}

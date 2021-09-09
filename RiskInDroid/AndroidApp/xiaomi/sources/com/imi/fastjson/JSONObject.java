package com.imi.fastjson;

import _m_j.bdf;
import _m_j.bdg;
import _m_j.bdk;
import _m_j.bdu;
import _m_j.bih;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JSONObject extends bdf implements bdg, Serializable, Cloneable, InvocationHandler, Map<String, Object> {
    private static final long serialVersionUID = 1;
    private final Map<String, Object> map;

    public JSONObject() {
        this(16, (byte) 0);
    }

    public JSONObject(Map<String, Object> map2) {
        this.map = map2;
    }

    public JSONObject(int i) {
        this(i, (byte) 0);
    }

    private JSONObject(int i, byte b) {
        this.map = new HashMap(i);
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Object get(Object obj) {
        return this.map.get(obj);
    }

    /* renamed from: O000000o */
    public final Object put(String str, Object obj) {
        return this.map.put(str, obj);
    }

    public void putAll(Map<? extends String, ? extends Object> map2) {
        this.map.putAll(map2);
    }

    public void clear() {
        this.map.clear();
    }

    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public Collection<Object> values() {
        return this.map.values();
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public Object clone() {
        return new JSONObject(new HashMap(this.map));
    }

    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Class<?>[] parameterTypes = method.getParameterTypes();
        String str = null;
        if (parameterTypes.length == 1) {
            if (method.getReturnType() == Void.TYPE) {
                bdk bdk = (bdk) method.getAnnotation(bdk.class);
                String O000000o2 = (bdk == null || bdk.O000000o().length() == 0) ? null : bdk.O000000o();
                if (O000000o2 == null) {
                    String name = method.getName();
                    if (name.startsWith("set")) {
                        String substring = name.substring(3);
                        if (substring.length() != 0) {
                            O000000o2 = Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
                        } else {
                            throw new JSONException("illegal setter");
                        }
                    } else {
                        throw new JSONException("illegal setter");
                    }
                }
                this.map.put(O000000o2, objArr[0]);
                return null;
            }
            throw new JSONException("illegal setter");
        } else if (parameterTypes.length != 0) {
            throw new UnsupportedOperationException(method.toGenericString());
        } else if (method.getReturnType() != Void.TYPE) {
            bdk bdk2 = (bdk) method.getAnnotation(bdk.class);
            if (!(bdk2 == null || bdk2.O000000o().length() == 0)) {
                str = bdk2.O000000o();
            }
            if (str == null) {
                String name2 = method.getName();
                if (name2.startsWith("get")) {
                    String substring2 = name2.substring(3);
                    if (substring2.length() != 0) {
                        str = Character.toLowerCase(substring2.charAt(0)) + substring2.substring(1);
                    } else {
                        throw new JSONException("illegal getter");
                    }
                } else if (name2.startsWith("is")) {
                    String substring3 = name2.substring(2);
                    if (substring3.length() != 0) {
                        str = Character.toLowerCase(substring3.charAt(0)) + substring3.substring(1);
                    } else {
                        throw new JSONException("illegal getter");
                    }
                } else {
                    throw new JSONException("illegal getter");
                }
            }
            return bih.O000000o(this.map.get(str), method.getGenericReturnType(), bdu.O000000o());
        } else {
            throw new JSONException("illegal getter");
        }
    }
}

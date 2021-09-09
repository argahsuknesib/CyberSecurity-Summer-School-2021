package com.mibi.sdk.common;

import java.io.Serializable;
import java.util.TreeMap;

public class SortedParameter implements Serializable {
    protected TreeMap<String, Object> mParams;

    public SortedParameter() {
        this.mParams = new TreeMap<>();
    }

    public SortedParameter(String str, Object obj) {
        this();
        add(str, obj);
    }

    public SortedParameter add(String str, Object obj) {
        if (obj == null) {
            obj = "";
        }
        this.mParams.put(str, obj);
        return this;
    }

    public SortedParameter addAll(SortedParameter sortedParameter) {
        if (sortedParameter != null) {
            this.mParams.putAll(sortedParameter.mParams);
        }
        return this;
    }

    private Object innerGet(String str) {
        return this.mParams.get(str);
    }

    public TreeMap<String, Object> getParams() {
        return this.mParams;
    }

    public <T> T get(String str) {
        try {
            return this.mParams.get(str);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        Object innerGet = innerGet(str);
        if (innerGet == null) {
            return z;
        }
        try {
            if (innerGet.equals(Boolean.FALSE)) {
                return false;
            }
            if ((innerGet instanceof String) && ((String) innerGet).equalsIgnoreCase("false")) {
                return false;
            }
            if (innerGet.equals(Boolean.TRUE)) {
                return true;
            }
            if (!(innerGet instanceof String) || !((String) innerGet).equalsIgnoreCase("true")) {
                return z;
            }
            return true;
        } catch (Exception unused) {
            return z;
        }
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public double getDouble(String str, double d) {
        Object innerGet = innerGet(str);
        try {
            if (innerGet instanceof Number) {
                return ((Number) innerGet).doubleValue();
            }
            return Double.parseDouble((String) innerGet);
        } catch (Exception unused) {
            return d;
        }
    }

    public long getLong(String str) {
        return getLong(str, 0);
    }

    public long getLong(String str, long j) {
        Object innerGet = innerGet(str);
        try {
            if (innerGet instanceof Number) {
                return ((Number) innerGet).longValue();
            }
            return Long.parseLong((String) innerGet);
        } catch (Exception unused) {
            return j;
        }
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        Object innerGet = innerGet(str);
        try {
            if (innerGet instanceof Number) {
                return ((Number) innerGet).intValue();
            }
            return Integer.parseInt((String) innerGet);
        } catch (Exception unused) {
            return i;
        }
    }

    public String getString(String str) {
        return getString(str, null);
    }

    public String getString(String str, String str2) {
        Object innerGet = innerGet(str);
        if (innerGet == null) {
            return str2;
        }
        return innerGet.toString();
    }

    public <T extends Serializable> T getSerializable(String str) {
        T innerGet = innerGet(str);
        if (innerGet == null) {
            return null;
        }
        try {
            return (Serializable) innerGet;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public boolean has(String str) {
        return this.mParams.containsKey(str);
    }

    public boolean isEmpty() {
        return this.mParams.isEmpty();
    }

    public String toString() {
        return this.mParams.toString();
    }
}

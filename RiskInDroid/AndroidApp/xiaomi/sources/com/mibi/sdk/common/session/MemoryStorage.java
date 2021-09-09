package com.mibi.sdk.common.session;

import android.os.Parcel;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStorage {
    private ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> mStorage = new ConcurrentHashMap<>();

    private MemoryStorage() {
    }

    public static MemoryStorage newMemoryStorage() {
        return new MemoryStorage();
    }

    public MemoryStorage remove(String str) {
        return remove("MEMORY_STORAGE_DEFAULT_GROUP", str);
    }

    public MemoryStorage remove(String str, String str2) {
        ConcurrentHashMap concurrentHashMap = this.mStorage.get(str);
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(str2);
        }
        return this;
    }

    public MemoryStorage removeGroup(String str) {
        this.mStorage.remove(str);
        return this;
    }

    /* access modifiers changed from: package-private */
    public MemoryStorage update(MemoryStorage memoryStorage) {
        this.mStorage = copy(memoryStorage.mStorage);
        return this;
    }

    public boolean has(String str) {
        return has("MEMORY_STORAGE_DEFAULT_GROUP", str);
    }

    public boolean has(String str, String str2) {
        ConcurrentHashMap concurrentHashMap = this.mStorage.get(str);
        return (concurrentHashMap == null || concurrentHashMap.get(str2) == null) ? false : true;
    }

    public MemoryStorage put(String str, Object obj) {
        return put("MEMORY_STORAGE_DEFAULT_GROUP", str, obj);
    }

    public MemoryStorage put(String str, String str2, Object obj) {
        if (obj == null) {
            obj = "";
        }
        ConcurrentHashMap concurrentHashMap = this.mStorage.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap();
            this.mStorage.put(str, concurrentHashMap);
        }
        concurrentHashMap.put(str2, obj);
        return this;
    }

    private Object innerGet(String str, String str2) {
        ConcurrentHashMap concurrentHashMap = this.mStorage.get(str);
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str2);
    }

    public <T> T get(String str, String str2) {
        try {
            return innerGet(str, str2);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean("MEMORY_STORAGE_DEFAULT_GROUP", str);
    }

    public boolean getBoolean(String str, String str2) {
        return getBoolean(str, str2, false);
    }

    public boolean getBoolean(String str, String str2, boolean z) {
        Object innerGet = innerGet(str, str2);
        if (innerGet == null) {
            return z;
        }
        if (innerGet.equals(Boolean.FALSE)) {
            return false;
        }
        boolean z2 = innerGet instanceof String;
        if (z2 && ((String) innerGet).equalsIgnoreCase("false")) {
            return false;
        }
        if (innerGet.equals(Boolean.TRUE)) {
            return true;
        }
        if (!z2 || !((String) innerGet).equalsIgnoreCase("true")) {
            return z;
        }
        return true;
    }

    public double getDouble(String str) {
        return getDouble("MEMORY_STORAGE_DEFAULT_GROUP", str);
    }

    public double getDouble(String str, String str2) {
        return getDouble(str, str2, 0.0d);
    }

    public double getDouble(String str, String str2, double d) {
        Object innerGet = innerGet(str, str2);
        if (innerGet == null) {
            return d;
        }
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
        return getLong("MEMORY_STORAGE_DEFAULT_GROUP", str);
    }

    public long getLong(String str, String str2) {
        return getLong(str, str2, 0);
    }

    public long getLong(String str, String str2, long j) {
        Object innerGet = innerGet(str, str2);
        if (innerGet == null) {
            return j;
        }
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
        return getInt("MEMORY_STORAGE_DEFAULT_GROUP", str);
    }

    public int getInt(String str, String str2) {
        return getInt(str, str2, 0);
    }

    public int getInt(String str, String str2, int i) {
        Object innerGet = innerGet(str, str2);
        if (innerGet == null) {
            return i;
        }
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
        return getString("MEMORY_STORAGE_DEFAULT_GROUP", str);
    }

    public String getString(String str, String str2) {
        return getString(str, str2, null);
    }

    public String getString(String str, String str2, String str3) {
        Object innerGet = innerGet(str, str2);
        if (innerGet == null) {
            return str3;
        }
        return innerGet.toString();
    }

    public <T extends Serializable> T getSerializable(String str) {
        return getSerializable("MEMORY_STORAGE_DEFAULT_GROUP", str);
    }

    public <T extends Serializable> T getSerializable(String str, String str2) {
        T innerGet = innerGet(str, str2);
        if (innerGet == null) {
            return null;
        }
        try {
            return (Serializable) innerGet;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public void writeToParcel(Parcel parcel) {
        parcel.writeSerializable(copy(this.mStorage));
    }

    public void readFromParcel(Parcel parcel) {
        this.mStorage = (ConcurrentHashMap) parcel.readSerializable();
    }

    private ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> copy(ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> concurrentHashMap) {
        if (concurrentHashMap == null) {
            return null;
        }
        ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> concurrentHashMap2 = new ConcurrentHashMap<>();
        for (String next : concurrentHashMap.keySet()) {
            ConcurrentHashMap concurrentHashMap3 = concurrentHashMap.get(next);
            for (String str : concurrentHashMap3.keySet()) {
                Object obj = concurrentHashMap3.get(str);
                if (obj instanceof Serializable) {
                    ConcurrentHashMap concurrentHashMap4 = concurrentHashMap2.get(next);
                    if (concurrentHashMap4 == null) {
                        concurrentHashMap4 = new ConcurrentHashMap();
                        concurrentHashMap2.put(next, concurrentHashMap4);
                    }
                    concurrentHashMap4.put(str, obj);
                }
            }
        }
        return concurrentHashMap2;
    }
}

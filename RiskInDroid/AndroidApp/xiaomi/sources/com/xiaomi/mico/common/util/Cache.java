package com.xiaomi.mico.common.util;

import _m_j.ahg;
import _m_j.ahh;
import _m_j.bnf;
import com.google.gson.Gson;
import com.xiaomi.accountsdk.utils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Cache {
    public static ahg loggerNew = new ahg();
    private static DiskCache mCache;

    enum SerializeType {
        OBJECT,
        JSON,
        STR
    }

    public static synchronized void init(File file, int i, long j) throws IOException {
        synchronized (Cache.class) {
            if (mCache == null) {
                mCache = new DiskCache(file, i, j);
            }
        }
    }

    public static boolean contains(String str) {
        try {
            return mCache.contains(str);
        } catch (Exception e) {
            ahg.O000000o(e);
            return false;
        }
    }

    public static void put(String str, Object obj) {
        put(str, obj, -1);
    }

    public static void put(String str, Object obj, long j) {
        put(str, obj, j, null);
    }

    public static void put(String str, Object obj, long j, HashMap<String, Serializable> hashMap) {
        Metadata metadata;
        if (j > 0) {
            try {
                metadata = new Metadata(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(j), hashMap);
            } catch (Exception e) {
                ahg.O000000o(e);
                return;
            }
        } else {
            metadata = new Metadata(-1, hashMap);
        }
        mCache.put(str, obj, metadata);
    }

    public static String get(String str) {
        return (String) get(str, String.class);
    }

    public static <T> T get(String str, Class<T> cls) {
        Pair<T, HashMap<String, Serializable>> pair = getPair(str, cls);
        if (pair != null) {
            return pair.key;
        }
        return null;
    }

    public static <T> Pair<T, HashMap<String, Serializable>> getPair(String str, Class<T> cls) {
        try {
            return mCache.get(str, cls);
        } catch (Exception e) {
            ahg.O000000o(e);
            return null;
        }
    }

    public static void delete(String str) {
        try {
            mCache.delete(str);
        } catch (Exception e) {
            ahg.O000000o(e);
        }
    }

    public static void deleteAll() {
        mCache.deleteAll();
        mCache = null;
    }

    static class DiskCache {
        private bnf mDiskCache;

        public DiskCache(File file, int i, long j) throws IOException {
            this.mDiskCache = bnf.O000000o(file, i, 2, j);
        }

        /* access modifiers changed from: package-private */
        public boolean contains(String str) throws IOException {
            bnf.O00000o0 O000000o2 = this.mDiskCache.O000000o(safeKey(str));
            if (O000000o2 == null) {
                return false;
            }
            O000000o2.close();
            return true;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T
         arg types: [java.lang.String, java.lang.Class<T>]
         candidates:
          com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.Class):T
          com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.reflect.Type):T
          com.google.gson.Gson.fromJson(com.google.gson.stream.JsonReader, java.lang.reflect.Type):T
          com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T
          com.google.gson.Gson.fromJson(java.io.Reader, java.lang.reflect.Type):T
          com.google.gson.Gson.fromJson(java.lang.String, java.lang.reflect.Type):T
          com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T */
        public <T> Pair<T, HashMap<String, Serializable>> get(String str, Class<T> cls) throws IOException, ClassNotFoundException {
            String safeKey = safeKey(str);
            bnf.O00000o0 O000000o2 = this.mDiskCache.O000000o(safeKey);
            if (O000000o2 == null) {
                return null;
            }
            ObjectInputStream objectInputStream = new ObjectInputStream(O000000o2.f13131O000000o[0]);
            ObjectInputStream objectInputStream2 = new ObjectInputStream(O000000o2.f13131O000000o[1]);
            Metadata metadata = (Metadata) objectInputStream.readObject();
            if (metadata.expire <= 0 || metadata.expire >= System.currentTimeMillis()) {
                int i = AnonymousClass1.$SwitchMap$com$xiaomi$mico$common$util$Cache$SerializeType[metadata.serializeType.ordinal()];
                if (i == 1) {
                    return new Pair<>(objectInputStream2.readObject(), metadata.extra);
                }
                if (i != 2) {
                    return null;
                }
                return new Pair<>(new Gson().fromJson(objectInputStream2.readUTF(), (Class) cls), metadata.extra);
            }
            O000000o2.close();
            this.mDiskCache.O00000o0(safeKey);
            return null;
        }

        public void put(String str, Object obj, Metadata metadata) throws IOException {
            bnf.O000000o o000000o = null;
            try {
                bnf.O000000o O00000Oo = this.mDiskCache.O00000Oo(safeKey(str));
                if (O00000Oo != null) {
                    writeValueData(obj, O00000Oo, metadata);
                    writeMetadata(metadata, O00000Oo);
                    O00000Oo.O000000o();
                }
            } catch (IOException e) {
                ahg ahg = Cache.loggerNew;
                ahg.O000000o(e);
                if (o000000o != null) {
                    o000000o.O00000Oo();
                }
            }
        }

        public void delete(String str) throws IOException {
            this.mDiskCache.O00000o0(safeKey(str));
        }

        public void deleteAll() {
            try {
                this.mDiskCache.O00000oO();
            } catch (IOException e) {
                ahg ahg = Cache.loggerNew;
                ahg.O000000o(e);
            }
        }

        private void writeMetadata(Metadata metadata, bnf.O000000o o000000o) throws IOException {
            ObjectOutputStream objectOutputStream = null;
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(o000000o.O000000o(0));
                try {
                    objectOutputStream2.writeObject(metadata);
                    IOUtils.closeQuietly(objectOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    IOUtils.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(objectOutputStream);
                throw th;
            }
        }

        private void writeValueData(Object obj, bnf.O000000o o000000o, Metadata metadata) throws IOException {
            ObjectOutputStream objectOutputStream;
            try {
                objectOutputStream = new ObjectOutputStream(o000000o.O000000o(1));
                try {
                    if (obj instanceof Serializable) {
                        objectOutputStream.writeObject(obj);
                        metadata.serializeType = SerializeType.OBJECT;
                    } else {
                        objectOutputStream.writeUTF(new Gson().toJson(obj));
                        metadata.serializeType = SerializeType.JSON;
                    }
                    IOUtils.closeQuietly(objectOutputStream);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = null;
                IOUtils.closeQuietly(objectOutputStream);
                throw th;
            }
        }

        private String safeKey(String str) {
            return MD5.MD5_16(str);
        }
    }

    /* renamed from: com.xiaomi.mico.common.util.Cache$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaomi$mico$common$util$Cache$SerializeType = new int[SerializeType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$xiaomi$mico$common$util$Cache$SerializeType[SerializeType.OBJECT.ordinal()] = 1;
            $SwitchMap$com$xiaomi$mico$common$util$Cache$SerializeType[SerializeType.JSON.ordinal()] = 2;
            try {
                $SwitchMap$com$xiaomi$mico$common$util$Cache$SerializeType[SerializeType.STR.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static class Metadata implements Serializable {
        private static final long serialVersionUID = 862397375458034278L;
        public final long expire;
        public final HashMap<String, Serializable> extra;
        public SerializeType serializeType;

        public Metadata(long j, HashMap<String, Serializable> hashMap) {
            this.expire = j;
            this.extra = hashMap;
        }
    }

    static class Pair<K, V> {
        public K key;
        public V value;

        public Pair(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    static {
        new ahh();
    }
}

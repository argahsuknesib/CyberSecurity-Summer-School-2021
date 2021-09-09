package com.tencent.mmkv;

import _m_j.dis;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MMKV implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: O000000o  reason: collision with root package name */
    private static EnumMap<MMKVRecoverStrategic, Integer> f5861O000000o;
    private static EnumMap<MMKVLogLevel, Integer> O00000Oo;
    private static HashSet<Long> O00000o = new HashSet<>();
    private static MMKVLogLevel[] O00000o0 = {MMKVLogLevel.LevelDebug, MMKVLogLevel.LevelInfo, MMKVLogLevel.LevelWarning, MMKVLogLevel.LevelError, MMKVLogLevel.LevelNone};
    private static String O00000oO = null;
    private static final HashMap<String, Parcelable.Creator<?>> O00000oo = new HashMap<>();
    private static dis O0000O0o;
    private static boolean O0000OOo = false;
    public long nativeHandle;

    private static native boolean checkProcessMode(long j);

    private native boolean containsKey(long j, String str);

    private native long count(long j);

    private static native long createNB(int i);

    private native byte[] decodeBytes(long j, String str);

    private native double decodeDouble(long j, String str, double d);

    private native float decodeFloat(long j, String str, float f);

    private native int decodeInt(long j, String str, int i);

    private native long decodeLong(long j, String str, long j2);

    private native String decodeString(long j, String str, String str2);

    private native String[] decodeStringSet(long j, String str);

    private static native void destroyNB(long j, int i);

    private native boolean encodeBool(long j, String str, boolean z);

    private native boolean encodeBytes(long j, String str, byte[] bArr);

    private native boolean encodeDouble(long j, String str, double d);

    private native boolean encodeFloat(long j, String str, float f);

    private native boolean encodeInt(long j, String str, int i);

    private native boolean encodeLong(long j, String str, long j2);

    private native boolean encodeSet(long j, String str, String[] strArr);

    private native boolean encodeString(long j, String str, String str2);

    private static native long getDefaultMMKV(int i, String str);

    private static native long getMMKVWithAshmemFD(String str, int i, int i2, String str2);

    private static native long getMMKVWithID(String str, int i, String str2, String str3);

    private static native long getMMKVWithIDAndSize(String str, int i, int i2, String str2);

    public static native boolean isFileValid(String str);

    private static native void jniInitialize(String str, int i);

    private static void onContentChangedByOuterProcess(String str) {
    }

    public static native void onExit();

    public static native int pageSize();

    private native void removeValueForKey(long j, String str);

    private static native void setCallbackHandler(boolean z, boolean z2);

    private static native void setLogLevel(int i);

    private static native void setWantsContentChangeNotify(boolean z);

    private native void sync(boolean z);

    private native long totalSize(long j);

    private native int valueSize(long j, String str, boolean z);

    private native int writeValueToNB(long j, String str, long j2, int i);

    public native String[] allKeys();

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(String str);

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    public native String cryptKey();

    public native boolean decodeBool(long j, String str, boolean z);

    public SharedPreferences.Editor edit() {
        return this;
    }

    public native void lock();

    public native String mmapID();

    public native boolean reKey(String str);

    public native void removeValuesForKeys(String[] strArr);

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.tencent.mmkv.MMKVRecoverStrategic, int]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Object, java.lang.Object):java.lang.Object}
      ClspMth{java.util.AbstractMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.tencent.mmkv.MMKVLogLevel, int]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Object, java.lang.Object):java.lang.Object}
      ClspMth{java.util.AbstractMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    static {
        EnumMap<MMKVRecoverStrategic, Integer> enumMap = new EnumMap<>(MMKVRecoverStrategic.class);
        f5861O000000o = enumMap;
        enumMap.put(MMKVRecoverStrategic.OnErrorDiscard, (Integer) 0);
        f5861O000000o.put(MMKVRecoverStrategic.OnErrorRecover, (Integer) 1);
        EnumMap<MMKVLogLevel, Integer> enumMap2 = new EnumMap<>(MMKVLogLevel.class);
        O00000Oo = enumMap2;
        enumMap2.put((MMKVRecoverStrategic) MMKVLogLevel.LevelDebug, (Integer) 0);
        O00000Oo.put((MMKVRecoverStrategic) MMKVLogLevel.LevelInfo, (Integer) 1);
        O00000Oo.put((MMKVRecoverStrategic) MMKVLogLevel.LevelWarning, (Integer) 2);
        O00000Oo.put((MMKVRecoverStrategic) MMKVLogLevel.LevelError, (Integer) 3);
        O00000Oo.put((MMKVRecoverStrategic) MMKVLogLevel.LevelNone, (Integer) 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0037, code lost:
        if (r0 != 5) goto L_0x0039;
     */
    public static String O000000o(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + "/mmkv";
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
        System.loadLibrary("mmkv");
        O00000oO = str;
        int i = AnonymousClass1.f5862O000000o[mMKVLogLevel.ordinal()];
        int i2 = 4;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    i2 = 2;
                } else if (i == 4) {
                    i2 = 3;
                }
            }
            i2 = 1;
        } else {
            i2 = 0;
        }
        jniInitialize(str, i2);
        return str;
    }

    /* renamed from: com.tencent.mmkv.MMKV$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5862O000000o = new int[MMKVLogLevel.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f5862O000000o[MMKVLogLevel.LevelDebug.ordinal()] = 1;
            f5862O000000o[MMKVLogLevel.LevelInfo.ordinal()] = 2;
            f5862O000000o[MMKVLogLevel.LevelWarning.ordinal()] = 3;
            f5862O000000o[MMKVLogLevel.LevelError.ordinal()] = 4;
            f5862O000000o[MMKVLogLevel.LevelNone.ordinal()] = 5;
        }
    }

    public static MMKV O000000o(String str) {
        if (O00000oO != null) {
            return O000000o(getMMKVWithID(str, 2, null, null), str, 2);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV O000000o(String str, String str2) {
        if (O00000oO != null) {
            return O000000o(getMMKVWithID(str, 2, str2, null), str, 2);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV O000000o(Context context, String str, int i, int i2, String str2) {
        if (O00000oO != null) {
            String O000000o2 = MMKVContentProvider.O000000o(context, Process.myPid());
            MMKV mmkv = null;
            if (O000000o2 == null || O000000o2.length() == 0) {
                O000000o(MMKVLogLevel.LevelError, "process name detect fail, try again later");
                return null;
            } else if (O000000o2.contains(":")) {
                Uri O000000o3 = MMKVContentProvider.O000000o(context);
                if (O000000o3 == null) {
                    O000000o(MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
                    return null;
                }
                O000000o(MMKVLogLevel.LevelInfo, "getting parcelable mmkv in process, Uri = ".concat(String.valueOf(O000000o3)));
                Bundle bundle = new Bundle();
                bundle.putInt("KEY_SIZE", i);
                bundle.putInt("KEY_MODE", i2);
                if (str2 != null) {
                    bundle.putString("KEY_CRYPT", str2);
                }
                Bundle call = context.getContentResolver().call(O000000o3, "mmkvFromAshmemID", str, bundle);
                if (call != null) {
                    call.setClassLoader(ParcelableMMKV.class.getClassLoader());
                    ParcelableMMKV parcelableMMKV = (ParcelableMMKV) call.getParcelable("KEY");
                    if (parcelableMMKV != null) {
                        if (parcelableMMKV.O00000Oo >= 0 && parcelableMMKV.O00000o0 >= 0) {
                            mmkv = new MMKV(getMMKVWithAshmemFD(parcelableMMKV.f5864O000000o, parcelableMMKV.O00000Oo, parcelableMMKV.O00000o0, parcelableMMKV.O00000o));
                        }
                        if (mmkv != null) {
                            MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
                            O000000o(mMKVLogLevel, mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                        }
                    }
                }
                return mmkv;
            } else {
                O000000o(MMKVLogLevel.LevelInfo, "getting mmkv in main process");
                return new MMKV(getMMKVWithIDAndSize(str, i, i2 | 8, str2));
            }
        } else {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
    }

    public static MMKV O000000o() {
        if (O00000oO != null) {
            return O000000o(getDefaultMMKV(1, null), "DefaultMMKV", 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static MMKV O000000o(long j, String str, int i) {
        String str2;
        if (j == 0) {
            return null;
        }
        if (!O00000o.contains(Long.valueOf(j))) {
            if (!checkProcessMode(j)) {
                if (i == 1) {
                    str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                } else {
                    str2 = "Opening a single-process MMKV instance [" + str + "] with MULTI_PROCESS_MODE!";
                }
                throw new IllegalArgumentException(str2);
            }
            O00000o.add(Long.valueOf(j));
        }
        return new MMKV(j);
    }

    public final boolean O000000o(String str, boolean z) {
        return encodeBool(this.nativeHandle, str, z);
    }

    public final boolean O00000Oo(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public final boolean O000000o(String str, int i) {
        return encodeInt(this.nativeHandle, str, i);
    }

    public final int O00000Oo(String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    public final boolean O000000o(String str, double d) {
        return encodeDouble(this.nativeHandle, str, d);
    }

    public final boolean O00000Oo(String str, String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public final String O00000Oo(String str) {
        return decodeString(this.nativeHandle, str, null);
    }

    public final String O00000o0(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    public final boolean O000000o(String str, Set<String> set) {
        return encodeSet(this.nativeHandle, str, (String[]) set.toArray(new String[0]));
    }

    public final Set<String> O00000Oo(String str, Set<String> set) {
        return O000000o(str, set, HashSet.class);
    }

    private Set<String> O000000o(String str, Set<String> set, Class<? extends Set> cls) {
        String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (decodeStringSet == null) {
            return set;
        }
        try {
            Set<String> set2 = (Set) cls.newInstance();
            set2.addAll(Arrays.asList(decodeStringSet));
            return set2;
        } catch (IllegalAccessException | InstantiationException unused) {
            return set;
        }
    }

    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    public String getString(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    public SharedPreferences.Editor putString(String str, String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return O00000Oo(str, set);
    }

    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        O000000o(str, set);
        return this;
    }

    public int getInt(String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        encodeInt(this.nativeHandle, str, i);
        return this;
    }

    public long getLong(String str, long j) {
        return decodeLong(this.nativeHandle, str, j);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        encodeLong(this.nativeHandle, str, j);
        return this;
    }

    public float getFloat(String str, float f) {
        return decodeFloat(this.nativeHandle, str, f);
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        encodeFloat(this.nativeHandle, str, f);
        return this;
    }

    public boolean getBoolean(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        encodeBool(this.nativeHandle, str, z);
        return this;
    }

    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public boolean commit() {
        sync(true);
        return true;
    }

    public void apply() {
        sync(false);
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    private static int onMMKVCRCCheckFail(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        dis dis = O0000O0o;
        if (dis != null) {
            mMKVRecoverStrategic = dis.O000000o();
        }
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
        O000000o(mMKVLogLevel, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = f5861O000000o.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        dis dis = O0000O0o;
        if (dis != null) {
            mMKVRecoverStrategic = dis.O00000Oo();
        }
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
        O000000o(mMKVLogLevel, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = f5861O000000o.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static void mmkvLogImp(int i, String str, int i2, String str2, String str3) {
        if (O0000O0o == null || !O0000OOo) {
            int i3 = AnonymousClass1.f5862O000000o[O00000o0[i].ordinal()];
            if (i3 == 1) {
                Log.d("MMKV", str3);
            } else if (i3 == 2) {
                Log.i("MMKV", str3);
            } else if (i3 == 3) {
                Log.w("MMKV", str3);
            } else if (i3 == 4) {
                Log.e("MMKV", str3);
            }
        }
    }

    private static void O000000o(MMKVLogLevel mMKVLogLevel, String str) {
        int i;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[stackTrace.length - 1];
        Integer num = O00000Oo.get(mMKVLogLevel);
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        mmkvLogImp(i, stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    private MMKV(long j) {
        this.nativeHandle = j;
    }

    public SharedPreferences.Editor remove(String str) {
        removeValueForKey(this.nativeHandle, str);
        return this;
    }

    public boolean contains(String str) {
        return containsKey(this.nativeHandle, str);
    }
}

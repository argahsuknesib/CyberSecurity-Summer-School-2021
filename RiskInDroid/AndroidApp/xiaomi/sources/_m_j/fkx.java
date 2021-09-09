package _m_j;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fkx {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final O00000o<String> f16554O000000o = $$Lambda$hZC4BmrFCj6c1zTAdjcnNbWjoc8.INSTANCE;
    private static final O00000o0<String> O00000Oo = $$Lambda$wPW8VCpXW7Rm0Rmc1OHkaen7JU.INSTANCE;

    public interface O000000o<K, V> extends O00000o0<V> {
        K O000000o(Parcel parcel);

        Map<K, V> O000000o();
    }

    public interface O00000Oo<K, V> extends O00000o<V> {
        void O000000o(Parcel parcel, K k);
    }

    public interface O00000o<V> {
        void writeValue(Parcel parcel, V v);
    }

    public interface O00000o0<V> {
        V readValue(Parcel parcel);
    }

    public static final void O000000o(Parcel parcel, Map<String, String> map) {
        O000000o(parcel, map, f16554O000000o);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fkx.O000000o(android.os.Parcel, java.util.Map, _m_j.fkx$O00000Oo):void
     arg types: [android.os.Parcel, java.util.Map<java.lang.String, V>, _m_j.fkx$1]
     candidates:
      _m_j.fkx.O000000o(android.os.Parcel, java.lang.ClassLoader, _m_j.fkx$O000000o):java.util.Map<K, V>
      _m_j.fkx.O000000o(android.os.Parcel, java.util.Map, _m_j.fkx$O00000o0):java.util.Map<java.lang.String, V>
      _m_j.fkx.O000000o(android.os.Parcel, java.util.List, _m_j.fkx$O00000o):void
      _m_j.fkx.O000000o(android.os.Parcel, java.util.Map, _m_j.fkx$O00000o):void
      _m_j.fkx.O000000o(android.os.Parcel, java.util.Map, _m_j.fkx$O00000Oo):void */
    public static final <V> void O000000o(Parcel parcel, Map<String, V> map, final O00000o<V> o00000o) {
        O000000o(parcel, (Map) map, (O00000Oo) new O00000Oo<String, V>() {
            /* class _m_j.fkx.AnonymousClass1 */

            public final /* synthetic */ void O000000o(Parcel parcel, Object obj) {
                parcel.writeString((String) obj);
            }

            public final void writeValue(Parcel parcel, V v) {
                o00000o.writeValue(parcel, v);
            }
        });
    }

    private static <K, V> void O000000o(Parcel parcel, Map<K, V> map, O00000Oo<K, V> o00000Oo) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        Set<Map.Entry<K, V>> entrySet = map.entrySet();
        parcel.writeInt(entrySet.size());
        for (Map.Entry next : entrySet) {
            if (o00000Oo == null) {
                O000000o(parcel, next.getKey());
                O000000o(parcel, next.getValue());
            } else {
                o00000Oo.O000000o(parcel, next.getKey());
                o00000Oo.writeValue(parcel, next.getValue());
            }
        }
    }

    public static final void O000000o(Parcel parcel, Object obj) {
        if (obj == null) {
            parcel.writeInt(-1);
        } else if (obj instanceof String) {
            parcel.writeInt(0);
            parcel.writeString((String) obj);
        } else if (obj instanceof Integer) {
            parcel.writeInt(1);
            parcel.writeInt(((Integer) obj).intValue());
        } else if (obj instanceof Map) {
            parcel.writeInt(2);
            O000000o(parcel, (Map) obj, (O00000Oo) null);
        } else if (obj instanceof Bundle) {
            parcel.writeInt(3);
            parcel.writeBundle((Bundle) obj);
        } else if (Build.VERSION.SDK_INT >= 21 && (obj instanceof PersistableBundle)) {
            parcel.writeInt(25);
            parcel.writePersistableBundle((PersistableBundle) obj);
        } else if (obj instanceof Parcelable) {
            parcel.writeInt(4);
            parcel.writeParcelable((Parcelable) obj, 0);
        } else if (obj instanceof Short) {
            parcel.writeInt(5);
            parcel.writeInt(((Short) obj).intValue());
        } else if (obj instanceof Long) {
            parcel.writeInt(6);
            parcel.writeLong(((Long) obj).longValue());
        } else if (obj instanceof Float) {
            parcel.writeInt(7);
            parcel.writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            parcel.writeInt(8);
            parcel.writeDouble(((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            parcel.writeInt(9);
            parcel.writeInt(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof CharSequence) {
            parcel.writeInt(10);
            TextUtils.writeToParcel((CharSequence) obj, parcel, 0);
        } else if (obj instanceof List) {
            parcel.writeInt(11);
            parcel.writeList((List) obj);
        } else if (obj instanceof SparseArray) {
            parcel.writeInt(12);
            parcel.writeSparseArray((SparseArray) obj);
        } else if (obj instanceof boolean[]) {
            parcel.writeInt(23);
            parcel.writeBooleanArray((boolean[]) obj);
        } else if (obj instanceof byte[]) {
            parcel.writeInt(13);
            parcel.writeByteArray((byte[]) obj);
        } else if (obj instanceof String[]) {
            parcel.writeInt(14);
            parcel.writeStringArray((String[]) obj);
        } else if (obj instanceof CharSequence[]) {
            parcel.writeInt(24);
            O000000o(parcel, (CharSequence[]) obj);
        } else if (obj instanceof IBinder) {
            parcel.writeInt(15);
            parcel.writeStrongBinder((IBinder) obj);
        } else if (obj instanceof Parcelable[]) {
            parcel.writeInt(16);
            parcel.writeParcelableArray((Parcelable[]) obj, 0);
        } else if (obj instanceof int[]) {
            parcel.writeInt(18);
            parcel.writeIntArray((int[]) obj);
        } else if (obj instanceof long[]) {
            parcel.writeInt(19);
            parcel.writeLongArray((long[]) obj);
        } else if (obj instanceof Byte) {
            parcel.writeInt(20);
            parcel.writeInt(((Byte) obj).byteValue());
        } else if (Build.VERSION.SDK_INT >= 21 && (obj instanceof Size)) {
            parcel.writeInt(26);
            parcel.writeSize((Size) obj);
        } else if (Build.VERSION.SDK_INT >= 21 && (obj instanceof SizeF)) {
            parcel.writeInt(27);
            parcel.writeSizeF((SizeF) obj);
        } else if (obj instanceof double[]) {
            parcel.writeInt(28);
            parcel.writeDoubleArray((double[]) obj);
        } else if (obj instanceof JSONArray) {
            parcel.writeInt(29);
            parcel.writeString(((JSONArray) obj).toString());
        } else if (obj instanceof JSONObject) {
            parcel.writeInt(30);
            parcel.writeString(((JSONObject) obj).toString());
        } else {
            Class<?> cls = obj.getClass();
            if (cls.isArray() && cls.getComponentType() == Object.class) {
                parcel.writeInt(17);
                parcel.writeArray((Object[]) obj);
            } else if (obj instanceof Serializable) {
                parcel.writeInt(21);
                parcel.writeSerializable((Serializable) obj);
            } else {
                Log.e("ParcelUtils", "fatal", new RuntimeException("Parcel: unable to marshal value " + obj + obj.getClass()));
            }
        }
    }

    private static void O000000o(Parcel parcel, CharSequence[] charSequenceArr) {
        if (charSequenceArr != null) {
            parcel.writeInt(r0);
            for (CharSequence writeToParcel : charSequenceArr) {
                TextUtils.writeToParcel(writeToParcel, parcel, 0);
            }
            return;
        }
        parcel.writeInt(-1);
    }

    public static Map<String, String> O00000Oo(Parcel parcel, Map<String, String> map) {
        return O000000o(parcel, map, O00000Oo);
    }

    public static <V> Map<String, V> O000000o(Parcel parcel, final Map<String, V> map, final O00000o0<V> o00000o0) {
        return O000000o(parcel, (ClassLoader) null, new O000000o<String, V>() {
            /* class _m_j.fkx.AnonymousClass2 */

            public final V readValue(Parcel parcel) {
                return o00000o0.readValue(parcel);
            }

            public final Map<String, V> O000000o() {
                return map;
            }

            public final /* synthetic */ Object O000000o(Parcel parcel) {
                return parcel.readString();
            }
        });
    }

    private static <K, V> Map<K, V> O000000o(Parcel parcel, ClassLoader classLoader, O000000o<K, V> o000000o) throws RuntimeException {
        Map<K, V> map;
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        if (o000000o == null) {
            map = new HashMap<>();
        } else {
            map = o000000o.O000000o();
            if (map == null) {
                map = new HashMap<>();
            }
        }
        while (readInt > 0) {
            if (o000000o == null) {
                map.put(O000000o(parcel, classLoader), O000000o(parcel, classLoader));
            } else {
                try {
                    map.put(o000000o.O000000o(parcel), o000000o.readValue(parcel));
                } catch (Exception e) {
                    Log.e("ParcelUtils", "fatal", e);
                }
            }
            readInt--;
        }
        return map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043  */
    public static <K, V> Object O000000o(Parcel parcel, ClassLoader classLoader) throws RuntimeException {
        int readInt = parcel.readInt();
        int i = 0;
        Object[] objArr = null;
        switch (readInt) {
            case -1:
                return null;
            case 0:
                return parcel.readString();
            case 1:
                return Integer.valueOf(parcel.readInt());
            case 2:
                return O000000o(parcel, classLoader, (O000000o) null);
            case 3:
                return parcel.readBundle(classLoader);
            case 4:
                return parcel.readParcelable(classLoader);
            case 5:
                return Short.valueOf((short) parcel.readInt());
            case 6:
                return Long.valueOf(parcel.readLong());
            case 7:
                return Float.valueOf(parcel.readFloat());
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return Double.valueOf(parcel.readDouble());
            case 9:
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 10:
                return O00000o0(parcel);
            case 11:
                return parcel.readArrayList(classLoader);
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                return parcel.readSparseArray(classLoader);
            case 13:
                return parcel.createByteArray();
            case 14:
                int readInt2 = parcel.readInt();
                if (readInt2 >= 0) {
                    objArr = new String[readInt2];
                    while (i < readInt2) {
                        objArr[i] = parcel.readString();
                        i++;
                    }
                }
                return objArr;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return parcel.readStrongBinder();
            case 16:
                return parcel.readParcelableArray(classLoader);
            case 17:
                return parcel.readArray(classLoader);
            case 18:
                return parcel.createIntArray();
            case 19:
                return parcel.createLongArray();
            case 20:
                return Byte.valueOf(parcel.readByte());
            case 21:
                return parcel.readSerializable();
            case 22:
                return parcel.readSparseBooleanArray();
            case 23:
                return parcel.createBooleanArray();
            case 24:
                int readInt3 = parcel.readInt();
                if (readInt3 >= 0) {
                    objArr = new CharSequence[readInt3];
                    while (i < readInt3) {
                        objArr[i] = O00000o0(parcel);
                        i++;
                    }
                }
                return objArr;
            case 25:
                if (Build.VERSION.SDK_INT >= 21) {
                    return parcel.readPersistableBundle(classLoader);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    return parcel.readSize();
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    return parcel.readSizeF();
                }
                return parcel.createDoubleArray();
            case 26:
                if (Build.VERSION.SDK_INT >= 21) {
                }
                if (Build.VERSION.SDK_INT >= 21) {
                }
                return parcel.createDoubleArray();
            case 27:
                if (Build.VERSION.SDK_INT >= 21) {
                }
                return parcel.createDoubleArray();
            case 28:
                return parcel.createDoubleArray();
            case 29:
                String readString = parcel.readString();
                try {
                    return new JSONArray(readString);
                } catch (JSONException e) {
                    Log.e("ParcelUtils", readString, e);
                    break;
                }
            case 30:
                String readString2 = parcel.readString();
                try {
                    return new JSONObject(readString2);
                } catch (JSONException e2) {
                    Log.e("ParcelUtils", readString2, e2);
                    break;
                }
            default:
                StringBuilder sb = new StringBuilder("Parcel ");
                sb.append(parcel);
                sb.append(": Unmarshalling unknown type code ");
                sb.append(readInt);
                sb.append(" at offset ");
                sb.append(parcel.dataPosition() - 4);
                throw new RuntimeException(sb.toString());
        }
    }

    private static CharSequence O00000o0(Parcel parcel) {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fkx.O000000o(android.os.Parcel, _m_j.fkx$O00000o0):java.util.ArrayList<V>
     arg types: [android.os.Parcel, _m_j.-$$Lambda$fkx$bFJGVS_5xkf-YbX3jrONEYXVeRQ]
     candidates:
      _m_j.fkx.O000000o(android.os.Parcel, java.lang.ClassLoader):java.lang.Object
      _m_j.fkx.O000000o(android.os.Parcel, android.os.Parcel):java.lang.String
      _m_j.fkx.O000000o(android.os.Parcel, java.lang.Object):void
      _m_j.fkx.O000000o(android.os.Parcel, java.util.List<java.lang.Integer>):void
      _m_j.fkx.O000000o(android.os.Parcel, java.util.Map<java.lang.String, java.lang.String>):void
      _m_j.fkx.O000000o(android.os.Parcel, java.lang.CharSequence[]):void
      _m_j.fkx.O000000o(android.os.Parcel, _m_j.fkx$O00000o0):java.util.ArrayList<V> */
    public static ArrayList<Integer> O000000o(Parcel parcel) {
        return O000000o(parcel, (O00000o0) new O00000o0(parcel) {
            /* class _m_j.$$Lambda$fkx$bFJGVS_5xkfYbX3jrONEYXVeRQ */
            private final /* synthetic */ Parcel f$0;

            {
                this.f$0 = r1;
            }

            public final Object readValue(Parcel parcel) {
                return Integer.valueOf(this.f$0.readInt());
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fkx.O000000o(android.os.Parcel, _m_j.fkx$O00000o0):java.util.ArrayList<V>
     arg types: [android.os.Parcel, _m_j.-$$Lambda$fkx$D0dhaPXpFodNPUvwTrrautGnJyY]
     candidates:
      _m_j.fkx.O000000o(android.os.Parcel, java.lang.ClassLoader):java.lang.Object
      _m_j.fkx.O000000o(android.os.Parcel, android.os.Parcel):java.lang.String
      _m_j.fkx.O000000o(android.os.Parcel, java.lang.Object):void
      _m_j.fkx.O000000o(android.os.Parcel, java.util.List<java.lang.Integer>):void
      _m_j.fkx.O000000o(android.os.Parcel, java.util.Map<java.lang.String, java.lang.String>):void
      _m_j.fkx.O000000o(android.os.Parcel, java.lang.CharSequence[]):void
      _m_j.fkx.O000000o(android.os.Parcel, _m_j.fkx$O00000o0):java.util.ArrayList<V> */
    public static ArrayList<String> O00000Oo(Parcel parcel) {
        return O000000o(parcel, (O00000o0) new O00000o0(parcel) {
            /* class _m_j.$$Lambda$fkx$D0dhaPXpFodNPUvwTrrautGnJyY */
            private final /* synthetic */ Parcel f$0;

            {
                this.f$0 = r1;
            }

            public final Object readValue(Parcel parcel) {
                return this.f$0.readString();
            }
        });
    }

    private static <V> ArrayList<V> O000000o(Parcel parcel, O00000o0 o00000o0) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList<V> arrayList = new ArrayList<>(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(o00000o0.readValue(parcel));
        }
        return arrayList;
    }

    public static void O000000o(Parcel parcel, List<Integer> list) {
        O000000o(parcel, list, $$Lambda$kLR35n1dbp9gSAmE4AfhpesLTi0.INSTANCE);
    }

    public static void O00000Oo(Parcel parcel, List<String> list) {
        O000000o(parcel, list, $$Lambda$hZC4BmrFCj6c1zTAdjcnNbWjoc8.INSTANCE);
    }

    private static <V> void O000000o(Parcel parcel, List<V> list, O00000o<V> o00000o) {
        if (list == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(list.size());
        for (int i = 0; i < list.size(); i++) {
            o00000o.writeValue(parcel, list.get(i));
        }
    }
}

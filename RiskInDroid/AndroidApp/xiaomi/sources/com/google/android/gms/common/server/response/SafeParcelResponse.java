package com.google.android.gms.common.server.response;

import _m_j.jdn;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "SafeParcelResponseCreator")
@VisibleForTesting
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new SafeParcelResponseCreator();
    private final String mClassName;
    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getFieldMappingDictionary", id = 3)
    private final FieldMappingDictionary zzwn;
    @SafeParcelable.Field(getter = "getParcel", id = 2)
    private final Parcel zzxq;
    private final int zzxr;
    private int zzxs;
    private int zzxt;

    @SafeParcelable.Constructor
    SafeParcelResponse(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Parcel parcel, @SafeParcelable.Param(id = 3) FieldMappingDictionary fieldMappingDictionary) {
        this.zzal = i;
        this.zzxq = (Parcel) Preconditions.checkNotNull(parcel);
        this.zzxr = 2;
        this.zzwn = fieldMappingDictionary;
        FieldMappingDictionary fieldMappingDictionary2 = this.zzwn;
        this.mClassName = fieldMappingDictionary2 == null ? null : fieldMappingDictionary2.getRootClassName();
        this.zzxs = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary fieldMappingDictionary, String str) {
        this.zzal = 1;
        this.zzxq = Parcel.obtain();
        safeParcelable.writeToParcel(this.zzxq, 0);
        this.zzxr = 1;
        this.zzwn = (FieldMappingDictionary) Preconditions.checkNotNull(fieldMappingDictionary);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zzxs = 2;
    }

    public SafeParcelResponse(FieldMappingDictionary fieldMappingDictionary) {
        this(fieldMappingDictionary, fieldMappingDictionary.getRootClassName());
    }

    public SafeParcelResponse(FieldMappingDictionary fieldMappingDictionary, String str) {
        this.zzal = 1;
        this.zzxq = Parcel.obtain();
        this.zzxr = 0;
        this.zzwn = (FieldMappingDictionary) Preconditions.checkNotNull(fieldMappingDictionary);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zzxs = 0;
    }

    public static HashMap<String, String> convertBundleToStringMap(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String next : bundle.keySet()) {
            hashMap.put(next, bundle.getString(next));
        }
        return hashMap;
    }

    public static Bundle convertStringMapToBundle(HashMap<String, String> hashMap) {
        Bundle bundle = new Bundle();
        for (String next : hashMap.keySet()) {
            bundle.putString(next, hashMap.get(next));
        }
        return bundle;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new SafeParcelResponse((SafeParcelable) t, zza(t), canonicalName);
    }

    public static FieldMappingDictionary generateDictionary(Class<? extends FastJsonResponse> cls) {
        try {
            return zza((FastJsonResponse) cls.newInstance());
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(cls.getCanonicalName());
            throw new IllegalStateException(valueOf.length() != 0 ? "Could not instantiate an object of type ".concat(valueOf) : new String("Could not instantiate an object of type "), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(cls.getCanonicalName());
            throw new IllegalStateException(valueOf2.length() != 0 ? "Could not access object of type ".concat(valueOf2) : new String("Could not access object of type "), e2);
        }
    }

    private static FieldMappingDictionary zza(FastJsonResponse fastJsonResponse) {
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        zza(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.copyInternalFieldMappings();
        fieldMappingDictionary.linkFields();
        return fieldMappingDictionary;
    }

    private static void zza(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (!fieldMappingDictionary.hasFieldMappingForClass(cls)) {
            Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
            fieldMappingDictionary.put(cls, fieldMappings);
            for (String str : fieldMappings.keySet()) {
                FastJsonResponse.Field field = fieldMappings.get(str);
                Class<? extends FastJsonResponse> concreteType = field.getConcreteType();
                if (concreteType != null) {
                    try {
                        zza(fieldMappingDictionary, (FastJsonResponse) concreteType.newInstance());
                    } catch (InstantiationException e) {
                        String valueOf = String.valueOf(field.getConcreteType().getCanonicalName());
                        throw new IllegalStateException(valueOf.length() != 0 ? "Could not instantiate an object of type ".concat(valueOf) : new String("Could not instantiate an object of type "), e);
                    } catch (IllegalAccessException e2) {
                        String valueOf2 = String.valueOf(field.getConcreteType().getCanonicalName());
                        throw new IllegalStateException(valueOf2.length() != 0 ? "Could not access object of type ".concat(valueOf2) : new String("Could not access object of type "), e2);
                    }
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append(jdn.f1779O000000o);
                sb.append(JsonUtils.escapeString(obj.toString()));
                sb.append(jdn.f1779O000000o);
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                sb.append(jdn.f1779O000000o);
                sb.append(Base64Utils.encode((byte[]) obj));
                sb.append(jdn.f1779O000000o);
                return;
            case 9:
                sb.append(jdn.f1779O000000o);
                sb.append(Base64Utils.encodeUrlSafe((byte[]) obj));
                sb.append(jdn.f1779O000000o);
                return;
            case 10:
                MapUtils.writeStringMapToJson(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    private final void zza(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        Object obj;
        String str;
        String str2;
        Object obj2;
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry next : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) next.getValue()).getSafeParcelableFieldId(), next);
        }
        sb.append('{');
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            Map.Entry entry = (Map.Entry) sparseArray.get(SafeParcelReader.getFieldId(readHeader));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry.getValue();
                sb.append(jdn.f1779O000000o);
                sb.append((String) entry.getKey());
                sb.append("\":");
                if (field.hasConverter()) {
                    switch (field.getTypeOut()) {
                        case 0:
                            obj2 = Integer.valueOf(SafeParcelReader.readInt(parcel, readHeader));
                            break;
                        case 1:
                            obj2 = SafeParcelReader.createBigInteger(parcel, readHeader);
                            break;
                        case 2:
                            obj2 = Long.valueOf(SafeParcelReader.readLong(parcel, readHeader));
                            break;
                        case 3:
                            obj2 = Float.valueOf(SafeParcelReader.readFloat(parcel, readHeader));
                            break;
                        case 4:
                            obj2 = Double.valueOf(SafeParcelReader.readDouble(parcel, readHeader));
                            break;
                        case 5:
                            obj2 = SafeParcelReader.createBigDecimal(parcel, readHeader);
                            break;
                        case 6:
                            obj2 = Boolean.valueOf(SafeParcelReader.readBoolean(parcel, readHeader));
                            break;
                        case 7:
                            obj2 = SafeParcelReader.createString(parcel, readHeader);
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        case 9:
                            obj2 = SafeParcelReader.createByteArray(parcel, readHeader);
                            break;
                        case 10:
                            obj2 = convertBundleToStringMap(SafeParcelReader.createBundle(parcel, readHeader));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            int typeOut = field.getTypeOut();
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(typeOut);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                    zzb(sb, field, getOriginalValue(field, obj2));
                } else {
                    if (field.isTypeOutArray()) {
                        sb.append("[");
                        switch (field.getTypeOut()) {
                            case 0:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createIntArray(parcel, readHeader));
                                break;
                            case 1:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createBigIntegerArray(parcel, readHeader));
                                break;
                            case 2:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createLongArray(parcel, readHeader));
                                break;
                            case 3:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createFloatArray(parcel, readHeader));
                                break;
                            case 4:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createDoubleArray(parcel, readHeader));
                                break;
                            case 5:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createBigDecimalArray(parcel, readHeader));
                                break;
                            case 6:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createBooleanArray(parcel, readHeader));
                                break;
                            case 7:
                                ArrayUtils.writeStringArray(sb, SafeParcelReader.createStringArray(parcel, readHeader));
                                break;
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            case 9:
                            case 10:
                                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            case 11:
                                Parcel[] createParcelArray = SafeParcelReader.createParcelArray(parcel, readHeader);
                                int length = createParcelArray.length;
                                for (int i = 0; i < length; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    createParcelArray[i].setDataPosition(0);
                                    zza(sb, field.getConcreteTypeFieldMappingFromDictionary(), createParcelArray[i]);
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out.");
                        }
                        str2 = "]";
                    } else {
                        switch (field.getTypeOut()) {
                            case 0:
                                sb.append(SafeParcelReader.readInt(parcel, readHeader));
                                break;
                            case 1:
                                obj = SafeParcelReader.createBigInteger(parcel, readHeader);
                                sb.append(obj);
                                break;
                            case 2:
                                sb.append(SafeParcelReader.readLong(parcel, readHeader));
                                break;
                            case 3:
                                sb.append(SafeParcelReader.readFloat(parcel, readHeader));
                                break;
                            case 4:
                                sb.append(SafeParcelReader.readDouble(parcel, readHeader));
                                break;
                            case 5:
                                obj = SafeParcelReader.createBigDecimal(parcel, readHeader);
                                sb.append(obj);
                                break;
                            case 6:
                                sb.append(SafeParcelReader.readBoolean(parcel, readHeader));
                                break;
                            case 7:
                                String createString = SafeParcelReader.createString(parcel, readHeader);
                                sb.append(jdn.f1779O000000o);
                                str = JsonUtils.escapeString(createString);
                                sb.append(str);
                                sb.append(jdn.f1779O000000o);
                                break;
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                byte[] createByteArray = SafeParcelReader.createByteArray(parcel, readHeader);
                                sb.append(jdn.f1779O000000o);
                                str = Base64Utils.encode(createByteArray);
                                sb.append(str);
                                sb.append(jdn.f1779O000000o);
                                break;
                            case 9:
                                byte[] createByteArray2 = SafeParcelReader.createByteArray(parcel, readHeader);
                                sb.append(jdn.f1779O000000o);
                                str = Base64Utils.encodeUrlSafe(createByteArray2);
                                sb.append(str);
                                sb.append(jdn.f1779O000000o);
                                break;
                            case 10:
                                Bundle createBundle = SafeParcelReader.createBundle(parcel, readHeader);
                                Set<String> keySet = createBundle.keySet();
                                keySet.size();
                                sb.append("{");
                                boolean z2 = true;
                                for (String next2 : keySet) {
                                    if (!z2) {
                                        sb.append(",");
                                    }
                                    sb.append(jdn.f1779O000000o);
                                    sb.append(next2);
                                    sb.append(jdn.f1779O000000o);
                                    sb.append(":");
                                    sb.append(jdn.f1779O000000o);
                                    sb.append(JsonUtils.escapeString(createBundle.getString(next2)));
                                    sb.append(jdn.f1779O000000o);
                                    z2 = false;
                                }
                                str2 = "}";
                                break;
                            case 11:
                                Parcel createParcel = SafeParcelReader.createParcel(parcel, readHeader);
                                createParcel.setDataPosition(0);
                                zza(sb, field.getConcreteTypeFieldMappingFromDictionary(), createParcel);
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out");
                        }
                    }
                    sb.append(str2);
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(validateObjectHeader);
        throw new SafeParcelReader.ParseException(sb3.toString(), parcel);
    }

    private final void zzb(FastJsonResponse.Field<?, ?> field) {
        if (field.isValidSafeParcelableFieldId()) {
            Parcel parcel = this.zzxq;
            if (parcel != null) {
                int i = this.zzxs;
                if (i == 0) {
                    this.zzxt = SafeParcelWriter.beginObjectHeader(parcel);
                    this.zzxs = 1;
                } else if (i == 1) {
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
                    }
                    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                }
            } else {
                throw new IllegalStateException("Internal Parcel object is null.");
            }
        } else {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
    }

    private final void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.isTypeInArray()) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                zza(sb, field.getTypeIn(), arrayList.get(i));
            }
            sb.append("]");
            return;
        }
        zza(sb, field.getTypeIn(), obj);
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        zzb(field);
        ArrayList arrayList2 = new ArrayList();
        arrayList.size();
        ArrayList arrayList3 = arrayList;
        int size = arrayList3.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            arrayList2.add(((SafeParcelResponse) ((FastJsonResponse) obj)).getParcel());
        }
        SafeParcelWriter.writeParcelList(this.zzxq, field.getSafeParcelableFieldId(), arrayList2, true);
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        zzb(field);
        SafeParcelWriter.writeParcel(this.zzxq, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t).getParcel(), true);
    }

    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        FieldMappingDictionary fieldMappingDictionary = this.zzwn;
        if (fieldMappingDictionary == null) {
            return null;
        }
        return fieldMappingDictionary.getFieldMapping(this.mClassName);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        if (r0 != 1) goto L_0x001a;
     */
    public Parcel getParcel() {
        int i = this.zzxs;
        if (i == 0) {
            this.zzxt = SafeParcelWriter.beginObjectHeader(this.zzxq);
        }
        SafeParcelWriter.finishObjectHeader(this.zzxq, this.zzxt);
        this.zzxs = 2;
        return this.zzxq;
    }

    public Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int getVersionCode() {
        return this.zzal;
    }

    public <T extends SafeParcelable> T inflate(Parcelable.Creator<T> creator) {
        Parcel parcel = getParcel();
        parcel.setDataPosition(0);
        return (SafeParcelable) creator.createFromParcel(parcel);
    }

    public boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    public void setBigDecimalInternal(FastJsonResponse.Field<?, ?> field, String str, BigDecimal bigDecimal) {
        zzb(field);
        SafeParcelWriter.writeBigDecimal(this.zzxq, field.getSafeParcelableFieldId(), bigDecimal, true);
    }

    /* access modifiers changed from: protected */
    public void setBigDecimalsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        zzb(field);
        int size = arrayList.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i = 0; i < size; i++) {
            bigDecimalArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeBigDecimalArray(this.zzxq, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    /* access modifiers changed from: protected */
    public void setBigIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, BigInteger bigInteger) {
        zzb(field);
        SafeParcelWriter.writeBigInteger(this.zzxq, field.getSafeParcelableFieldId(), bigInteger, true);
    }

    /* access modifiers changed from: protected */
    public void setBigIntegersInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        zzb(field);
        int size = arrayList.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegerArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeBigIntegerArray(this.zzxq, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    /* access modifiers changed from: protected */
    public void setBooleanInternal(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
        zzb(field);
        SafeParcelWriter.writeBoolean(this.zzxq, field.getSafeParcelableFieldId(), z);
    }

    /* access modifiers changed from: protected */
    public void setBooleansInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        zzb(field);
        int size = arrayList.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = arrayList.get(i).booleanValue();
        }
        SafeParcelWriter.writeBooleanArray(this.zzxq, field.getSafeParcelableFieldId(), zArr, true);
    }

    /* access modifiers changed from: protected */
    public void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        zzb(field);
        SafeParcelWriter.writeByteArray(this.zzxq, field.getSafeParcelableFieldId(), bArr, true);
    }

    /* access modifiers changed from: protected */
    public void setDoubleInternal(FastJsonResponse.Field<?, ?> field, String str, double d) {
        zzb(field);
        SafeParcelWriter.writeDouble(this.zzxq, field.getSafeParcelableFieldId(), d);
    }

    /* access modifiers changed from: protected */
    public void setDoublesInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        zzb(field);
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = arrayList.get(i).doubleValue();
        }
        SafeParcelWriter.writeDoubleArray(this.zzxq, field.getSafeParcelableFieldId(), dArr, true);
    }

    /* access modifiers changed from: protected */
    public void setFloatInternal(FastJsonResponse.Field<?, ?> field, String str, float f) {
        zzb(field);
        SafeParcelWriter.writeFloat(this.zzxq, field.getSafeParcelableFieldId(), f);
    }

    /* access modifiers changed from: protected */
    public void setFloatsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        zzb(field);
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = arrayList.get(i).floatValue();
        }
        SafeParcelWriter.writeFloatArray(this.zzxq, field.getSafeParcelableFieldId(), fArr, true);
    }

    /* access modifiers changed from: protected */
    public void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i) {
        zzb(field);
        SafeParcelWriter.writeInt(this.zzxq, field.getSafeParcelableFieldId(), i);
    }

    /* access modifiers changed from: protected */
    public void setIntegersInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        zzb(field);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        SafeParcelWriter.writeIntArray(this.zzxq, field.getSafeParcelableFieldId(), iArr, true);
    }

    /* access modifiers changed from: protected */
    public void setLongInternal(FastJsonResponse.Field<?, ?> field, String str, long j) {
        zzb(field);
        SafeParcelWriter.writeLong(this.zzxq, field.getSafeParcelableFieldId(), j);
    }

    /* access modifiers changed from: protected */
    public void setLongsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        zzb(field);
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = arrayList.get(i).longValue();
        }
        SafeParcelWriter.writeLongArray(this.zzxq, field.getSafeParcelableFieldId(), jArr, true);
    }

    /* access modifiers changed from: protected */
    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        zzb(field);
        SafeParcelWriter.writeString(this.zzxq, field.getSafeParcelableFieldId(), str2, true);
    }

    /* access modifiers changed from: protected */
    public void setStringMapInternal(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        zzb(field);
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            bundle.putString(next, map.get(next));
        }
        SafeParcelWriter.writeBundle(this.zzxq, field.getSafeParcelableFieldId(), bundle, true);
    }

    /* access modifiers changed from: protected */
    public void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        zzb(field);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeStringArray(this.zzxq, field.getSafeParcelableFieldId(), strArr, true);
    }

    public String toString() {
        Preconditions.checkNotNull(this.zzwn, "Cannot convert to JSON on client side.");
        Parcel parcel = getParcel();
        parcel.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zza(sb, this.zzwn.getFieldMapping(this.mClassName), parcel);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        FieldMappingDictionary fieldMappingDictionary;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVersionCode());
        SafeParcelWriter.writeParcel(parcel, 2, getParcel(), false);
        int i2 = this.zzxr;
        if (i2 == 0) {
            fieldMappingDictionary = null;
        } else if (i2 == 1 || i2 == 2) {
            fieldMappingDictionary = this.zzwn;
        } else {
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid creation type: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        SafeParcelWriter.writeParcelable(parcel, 3, fieldMappingDictionary, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

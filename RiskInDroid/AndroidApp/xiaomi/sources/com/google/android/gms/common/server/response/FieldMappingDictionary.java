package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SafeParcelable.Class(creator = "FieldMappingDictionaryCreator")
public class FieldMappingDictionary extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FieldMappingDictionary> CREATOR = new FieldMappingDictionaryCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzxk;
    @SafeParcelable.Field(getter = "getSerializedDictionary", id = 2)
    private final ArrayList<Entry> zzxl;
    @SafeParcelable.Field(getter = "getRootClassName", id = 3)
    private final String zzxm;

    @SafeParcelable.Class(creator = "FieldMappingDictionaryEntryCreator")
    public static class Entry extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Entry> CREATOR = new FieldMappingDictionaryEntryCreator();
        @SafeParcelable.Field(id = 2)
        final String className;
        @SafeParcelable.VersionField(id = 1)
        private final int versionCode;
        @SafeParcelable.Field(id = 3)
        final ArrayList<FieldMapPair> zzxn;

        @SafeParcelable.Constructor
        Entry(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) ArrayList<FieldMapPair> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.zzxn = arrayList;
        }

        Entry(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
            ArrayList<FieldMapPair> arrayList;
            this.versionCode = 1;
            this.className = str;
            if (map == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>();
                for (String next : map.keySet()) {
                    arrayList.add(new FieldMapPair(next, map.get(next)));
                }
            }
            this.zzxn = arrayList;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
            SafeParcelWriter.writeString(parcel, 2, this.className, false);
            SafeParcelWriter.writeTypedList(parcel, 3, this.zzxn, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @SafeParcelable.Class(creator = "FieldMapPairCreator")
    public static class FieldMapPair extends AbstractSafeParcelable {
        public static final Parcelable.Creator<FieldMapPair> CREATOR = new FieldMapPairCreator();
        @SafeParcelable.VersionField(id = 1)
        private final int versionCode;
        @SafeParcelable.Field(id = 2)
        final String zzxo;
        @SafeParcelable.Field(id = 3)
        final FastJsonResponse.Field<?, ?> zzxp;

        @SafeParcelable.Constructor
        FieldMapPair(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) FastJsonResponse.Field<?, ?> field) {
            this.versionCode = i;
            this.zzxo = str;
            this.zzxp = field;
        }

        FieldMapPair(String str, FastJsonResponse.Field<?, ?> field) {
            this.versionCode = 1;
            this.zzxo = str;
            this.zzxp = field;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
            SafeParcelWriter.writeString(parcel, 2, this.zzxo, false);
            SafeParcelWriter.writeParcelable(parcel, 3, this.zzxp, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @SafeParcelable.Constructor
    FieldMappingDictionary(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList<Entry> arrayList, @SafeParcelable.Param(id = 3) String str) {
        this.zzal = i;
        this.zzxl = null;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Entry entry = arrayList.get(i2);
            String str2 = entry.className;
            HashMap hashMap2 = new HashMap();
            int size2 = entry.zzxn.size();
            for (int i3 = 0; i3 < size2; i3++) {
                FieldMapPair fieldMapPair = entry.zzxn.get(i3);
                hashMap2.put(fieldMapPair.zzxo, fieldMapPair.zzxp);
            }
            hashMap.put(str2, hashMap2);
        }
        this.zzxk = hashMap;
        this.zzxm = (String) Preconditions.checkNotNull(str);
        linkFields();
    }

    public FieldMappingDictionary(Class<? extends FastJsonResponse> cls) {
        this.zzal = 1;
        this.zzxl = null;
        this.zzxk = new HashMap<>();
        this.zzxm = cls.getCanonicalName();
    }

    public void copyInternalFieldMappings() {
        for (String next : this.zzxk.keySet()) {
            Map map = this.zzxk.get(next);
            HashMap hashMap = new HashMap();
            for (String str : map.keySet()) {
                hashMap.put(str, ((FastJsonResponse.Field) map.get(str)).copyForDictionary());
            }
            this.zzxk.put(next, hashMap);
        }
    }

    @VisibleForTesting
    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMapping(Class<? extends FastJsonResponse> cls) {
        return this.zzxk.get(cls.getCanonicalName());
    }

    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMapping(String str) {
        return this.zzxk.get(str);
    }

    public String getRootClassName() {
        return this.zzxm;
    }

    public boolean hasFieldMappingForClass(Class<? extends FastJsonResponse> cls) {
        return this.zzxk.containsKey(cls.getCanonicalName());
    }

    public void linkFields() {
        for (String str : this.zzxk.keySet()) {
            Map map = this.zzxk.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).setFieldMappingDictionary(this);
            }
        }
    }

    public void put(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.zzxk.put(cls.getCanonicalName(), map);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.zzxk.keySet()) {
            sb.append(next);
            sb.append(":\n");
            Map map = this.zzxk.get(next);
            for (String str : map.keySet()) {
                sb.append("  ");
                sb.append(str);
                sb.append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        ArrayList arrayList = new ArrayList();
        for (String next : this.zzxk.keySet()) {
            arrayList.add(new Entry(next, this.zzxk.get(next)));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.writeString(parcel, 3, getRootClassName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

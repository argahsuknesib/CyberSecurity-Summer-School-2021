package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

@SafeParcelable.Class(creator = "StringToIntConverterCreator")
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new StringToIntConverterCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    private final HashMap<String, Integer> zzwe;
    private final SparseArray<String> zzwf;
    @SafeParcelable.Field(getter = "getSerializedMap", id = 2)
    private final ArrayList<Entry> zzwg;

    @SafeParcelable.Class(creator = "StringToIntConverterEntryCreator")
    public static final class Entry extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Entry> CREATOR = new StringToIntConverterEntryCreator();
        @SafeParcelable.VersionField(id = 1)
        private final int versionCode;
        @SafeParcelable.Field(id = 2)
        final String zzwh;
        @SafeParcelable.Field(id = 3)
        final int zzwi;

        @SafeParcelable.Constructor
        Entry(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2) {
            this.versionCode = i;
            this.zzwh = str;
            this.zzwi = i2;
        }

        Entry(String str, int i) {
            this.versionCode = 1;
            this.zzwh = str;
            this.zzwi = i;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
            SafeParcelWriter.writeString(parcel, 2, this.zzwh, false);
            SafeParcelWriter.writeInt(parcel, 3, this.zzwi);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    public StringToIntConverter() {
        this.zzal = 1;
        this.zzwe = new HashMap<>();
        this.zzwf = new SparseArray<>();
        this.zzwg = null;
    }

    @SafeParcelable.Constructor
    StringToIntConverter(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList<Entry> arrayList) {
        this.zzal = i;
        this.zzwe = new HashMap<>();
        this.zzwf = new SparseArray<>();
        this.zzwg = null;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            Entry entry = (Entry) obj;
            add(entry.zzwh, entry.zzwi);
        }
    }

    public final StringToIntConverter add(String str, int i) {
        this.zzwe.put(str, Integer.valueOf(i));
        this.zzwf.put(i, str);
        return this;
    }

    public final Integer convert(String str) {
        Integer num = this.zzwe.get(str);
        return num == null ? this.zzwe.get("gms_unknown") : num;
    }

    public final String convertBack(Integer num) {
        String str = this.zzwf.get(num.intValue());
        return (str != null || !this.zzwe.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public final int getTypeIn() {
        return 7;
    }

    public final int getTypeOut() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        ArrayList arrayList = new ArrayList();
        for (String next : this.zzwe.keySet()) {
            arrayList.add(new Entry(next, this.zzwe.get(next).intValue()));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
public final class zzjx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjx> CREATOR = new zzjy();
    @SafeParcelable.Field(id = 2)
    public final String name;
    @SafeParcelable.Field(id = 7)
    public final String origin;
    @SafeParcelable.Field(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(id = 6)
    private final String zzajf;
    @SafeParcelable.Field(id = 3)
    public final long zzaqz;
    @SafeParcelable.Field(id = 4)
    private final Long zzara;
    @SafeParcelable.Field(id = 5)
    private final Float zzarb;
    @SafeParcelable.Field(id = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    private final Double zzarc;

    @SafeParcelable.Constructor
    zzjx(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) Long l, @SafeParcelable.Param(id = 5) Float f, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) Double d) {
        this.versionCode = i;
        this.name = str;
        this.zzaqz = j;
        this.zzara = l;
        Double d2 = null;
        this.zzarb = null;
        if (i == 1) {
            this.zzarc = f != null ? Double.valueOf(f.doubleValue()) : d2;
        } else {
            this.zzarc = d;
        }
        this.zzajf = str2;
        this.origin = str3;
    }

    zzjx(zzjz zzjz) {
        this(zzjz.name, zzjz.zzaqz, zzjz.value, zzjz.origin);
    }

    zzjx(String str, long j, Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.versionCode = 2;
        this.name = str;
        this.zzaqz = j;
        this.origin = str2;
        if (obj == null) {
            this.zzara = null;
            this.zzarb = null;
            this.zzarc = null;
            this.zzajf = null;
        } else if (obj instanceof Long) {
            this.zzara = (Long) obj;
            this.zzarb = null;
            this.zzarc = null;
            this.zzajf = null;
        } else if (obj instanceof String) {
            this.zzara = null;
            this.zzarb = null;
            this.zzarc = null;
            this.zzajf = (String) obj;
        } else if (obj instanceof Double) {
            this.zzara = null;
            this.zzarb = null;
            this.zzarc = (Double) obj;
            this.zzajf = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object getValue() {
        Long l = this.zzara;
        if (l != null) {
            return l;
        }
        Double d = this.zzarc;
        if (d != null) {
            return d;
        }
        String str = this.zzajf;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzaqz);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzara, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzajf, false);
        SafeParcelWriter.writeString(parcel, 7, this.origin, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzarc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

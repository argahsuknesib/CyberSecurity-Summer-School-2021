package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "WordBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzad();
    @SafeParcelable.Field(id = 6)
    private final float zzcm;
    @SafeParcelable.Field(id = 7)
    public final String zzcy;
    @SafeParcelable.Field(id = 3)
    public final zzn zzde;
    @SafeParcelable.Field(id = 4)
    private final zzn zzdf;
    @SafeParcelable.Field(id = 5)
    public final String zzdh;
    @SafeParcelable.Field(id = 2)
    private final zzx[] zzdn;
    @SafeParcelable.Field(id = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    private final boolean zzdo;

    @SafeParcelable.Constructor
    public zzac(@SafeParcelable.Param(id = 2) zzx[] zzxArr, @SafeParcelable.Param(id = 3) zzn zzn, @SafeParcelable.Param(id = 4) zzn zzn2, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) float f, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z) {
        this.zzdn = zzxArr;
        this.zzde = zzn;
        this.zzdf = zzn2;
        this.zzdh = str;
        this.zzcm = f;
        this.zzcy = str2;
        this.zzdo = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzdn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzde, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdf, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzdh, false);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzcm);
        SafeParcelWriter.writeString(parcel, 7, this.zzcy, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

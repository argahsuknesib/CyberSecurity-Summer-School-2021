package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@SafeParcelable.Class(creator = "LineBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();
    @SafeParcelable.Field(id = 7)
    private final float zzcm;
    @SafeParcelable.Field(id = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String zzcy;
    @SafeParcelable.Field(id = 2)
    public final zzac[] zzdd;
    @SafeParcelable.Field(id = 3)
    public final zzn zzde;
    @SafeParcelable.Field(id = 4)
    private final zzn zzdf;
    @SafeParcelable.Field(id = 5)
    private final zzn zzdg;
    @SafeParcelable.Field(id = 6)
    public final String zzdh;
    @SafeParcelable.Field(id = 9)
    private final int zzdi;
    @SafeParcelable.Field(id = 10)
    public final boolean zzdj;
    @SafeParcelable.Field(id = 11)
    public final int zzdk;
    @SafeParcelable.Field(id = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final int zzdl;

    @SafeParcelable.Constructor
    public zzt(@SafeParcelable.Param(id = 2) zzac[] zzacArr, @SafeParcelable.Param(id = 3) zzn zzn, @SafeParcelable.Param(id = 4) zzn zzn2, @SafeParcelable.Param(id = 5) zzn zzn3, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) float f, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) int i, @SafeParcelable.Param(id = 10) boolean z, @SafeParcelable.Param(id = 11) int i2, @SafeParcelable.Param(id = 12) int i3) {
        this.zzdd = zzacArr;
        this.zzde = zzn;
        this.zzdf = zzn2;
        this.zzdg = zzn3;
        this.zzdh = str;
        this.zzcm = f;
        this.zzcy = str2;
        this.zzdi = i;
        this.zzdj = z;
        this.zzdk = i2;
        this.zzdl = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzdd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzde, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzdg, i, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzdh, false);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzcm);
        SafeParcelWriter.writeString(parcel, 8, this.zzcy, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzdi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzdj);
        SafeParcelWriter.writeInt(parcel, 11, this.zzdk);
        SafeParcelWriter.writeInt(parcel, 12, this.zzdl);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

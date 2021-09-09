package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@UsedByNative("wrapper.cc")
@SafeParcelable.Class(creator = "FaceParcelCreator")
public class FaceParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FaceParcel> CREATOR = new zzb();
    @SafeParcelable.Field(id = 3)
    public final float centerX;
    @SafeParcelable.Field(id = 4)
    public final float centerY;
    @SafeParcelable.Field(id = 6)
    public final float height;
    @SafeParcelable.Field(id = 2)
    public final int id;
    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(id = 5)
    public final float width;
    @SafeParcelable.Field(id = 7)
    public final float zzbx;
    @SafeParcelable.Field(id = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final float zzby;
    @SafeParcelable.Field(id = 9)
    public final LandmarkParcel[] zzbz;
    @SafeParcelable.Field(id = 10)
    public final float zzca;
    @SafeParcelable.Field(id = 11)
    public final float zzcb;
    @SafeParcelable.Field(id = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final float zzcc;

    @SafeParcelable.Constructor
    public FaceParcel(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) float f, @SafeParcelable.Param(id = 4) float f2, @SafeParcelable.Param(id = 5) float f3, @SafeParcelable.Param(id = 6) float f4, @SafeParcelable.Param(id = 7) float f5, @SafeParcelable.Param(id = 8) float f6, @SafeParcelable.Param(id = 9) LandmarkParcel[] landmarkParcelArr, @SafeParcelable.Param(id = 10) float f7, @SafeParcelable.Param(id = 11) float f8, @SafeParcelable.Param(id = 12) float f9) {
        this.versionCode = i;
        this.id = i2;
        this.centerX = f;
        this.centerY = f2;
        this.width = f3;
        this.height = f4;
        this.zzbx = f5;
        this.zzby = f6;
        this.zzbz = landmarkParcelArr;
        this.zzca = f7;
        this.zzcb = f8;
        this.zzcc = f9;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.id);
        SafeParcelWriter.writeFloat(parcel, 3, this.centerX);
        SafeParcelWriter.writeFloat(parcel, 4, this.centerY);
        SafeParcelWriter.writeFloat(parcel, 5, this.width);
        SafeParcelWriter.writeFloat(parcel, 6, this.height);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzbx);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzby);
        SafeParcelWriter.writeTypedArray(parcel, 9, this.zzbz, i, false);
        SafeParcelWriter.writeFloat(parcel, 10, this.zzca);
        SafeParcelWriter.writeFloat(parcel, 11, this.zzcb);
        SafeParcelWriter.writeFloat(parcel, 12, this.zzcc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

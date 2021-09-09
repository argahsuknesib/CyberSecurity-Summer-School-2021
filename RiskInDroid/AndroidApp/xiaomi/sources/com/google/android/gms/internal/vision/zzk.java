package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.Frame;

@SafeParcelable.Class(creator = "FrameMetadataParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();
    @SafeParcelable.Field(id = 3)
    public int height;
    @SafeParcelable.Field(id = 4)
    private int id;
    @SafeParcelable.Field(id = 6)
    public int rotation;
    @SafeParcelable.Field(id = 2)
    public int width;
    @SafeParcelable.Field(id = 5)
    private long zzck;

    public zzk() {
    }

    @SafeParcelable.Constructor
    public zzk(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) long j, @SafeParcelable.Param(id = 6) int i4) {
        this.width = i;
        this.height = i2;
        this.id = i3;
        this.zzck = j;
        this.rotation = i4;
    }

    public static zzk zzc(Frame frame) {
        zzk zzk = new zzk();
        zzk.width = frame.getMetadata().getWidth();
        zzk.height = frame.getMetadata().getHeight();
        zzk.rotation = frame.getMetadata().getRotation();
        zzk.id = frame.getMetadata().getId();
        zzk.zzck = frame.getMetadata().getTimestampMillis();
        return zzk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.width);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.id);
        SafeParcelWriter.writeLong(parcel, 5, this.zzck);
        SafeParcelWriter.writeInt(parcel, 6, this.rotation);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

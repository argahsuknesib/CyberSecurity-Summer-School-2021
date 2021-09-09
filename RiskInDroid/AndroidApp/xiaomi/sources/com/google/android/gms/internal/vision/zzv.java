package com.google.android.gms.internal.vision;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RecognitionOptionsCreator")
@SafeParcelable.Reserved({1})
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();
    @SafeParcelable.Field(id = 2)
    public final Rect zzdm;

    public zzv() {
        this.zzdm = new Rect();
    }

    @SafeParcelable.Constructor
    public zzv(@SafeParcelable.Param(id = 2) Rect rect) {
        this.zzdm = rect;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdm, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

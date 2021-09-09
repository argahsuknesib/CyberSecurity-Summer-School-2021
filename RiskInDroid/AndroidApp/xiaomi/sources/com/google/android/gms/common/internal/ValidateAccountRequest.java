package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ValidateAccountRequestCreator")
@Deprecated
public class ValidateAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new ValidateAccountRequestCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;

    @SafeParcelable.Constructor
    ValidateAccountRequest(@SafeParcelable.Param(id = 1) int i) {
        this.zzal = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

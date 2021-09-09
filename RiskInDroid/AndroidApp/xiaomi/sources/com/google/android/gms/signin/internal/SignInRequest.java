package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInRequestCreator")
public class SignInRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInRequest> CREATOR = new SignInRequestCreator();
    @SafeParcelable.Field(getter = "getResolveAccountRequest", id = 2)
    private final ResolveAccountRequest zzadt;
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;

    @SafeParcelable.Constructor
    SignInRequest(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ResolveAccountRequest resolveAccountRequest) {
        this.zzal = i;
        this.zzadt = resolveAccountRequest;
    }

    public SignInRequest(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public ResolveAccountRequest getResolveAccountRequest() {
        return this.zzadt;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, getResolveAccountRequest(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

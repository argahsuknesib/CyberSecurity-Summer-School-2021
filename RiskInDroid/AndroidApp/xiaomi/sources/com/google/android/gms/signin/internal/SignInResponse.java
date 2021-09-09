package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInResponseCreator")
public class SignInResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInResponse> CREATOR = new SignInResponseCreator();
    @SafeParcelable.Field(getter = "getResolveAccountResponse", id = 3)
    private final ResolveAccountResponse zzadu;
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getConnectionResult", id = 2)
    private final ConnectionResult zzeu;

    public SignInResponse(int i) {
        this(new ConnectionResult(i, null), null);
    }

    @SafeParcelable.Constructor
    SignInResponse(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ConnectionResult connectionResult, @SafeParcelable.Param(id = 3) ResolveAccountResponse resolveAccountResponse) {
        this.zzal = i;
        this.zzeu = connectionResult;
        this.zzadu = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public ConnectionResult getConnectionResult() {
        return this.zzeu;
    }

    public ResolveAccountResponse getResolveAccountResponse() {
        return this.zzadu;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, getConnectionResult(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getResolveAccountResponse(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

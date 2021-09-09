package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ResolveAccountResponseCreator")
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new ResolveAccountResponseCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getConnectionResult", id = 3)
    private ConnectionResult zzeu;
    @SafeParcelable.Field(getter = "getSaveDefaultAccount", id = 4)
    private boolean zzhs;
    @SafeParcelable.Field(id = 2)
    private IBinder zzqv;
    @SafeParcelable.Field(getter = "isFromCrossClientAuth", id = 5)
    private boolean zzuv;

    public ResolveAccountResponse(int i) {
        this(new ConnectionResult(i, null));
    }

    @SafeParcelable.Constructor
    ResolveAccountResponse(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) ConnectionResult connectionResult, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2) {
        this.zzal = i;
        this.zzqv = iBinder;
        this.zzeu = connectionResult;
        this.zzhs = z;
        this.zzuv = z2;
    }

    public ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, null, connectionResult, false, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.zzeu.equals(resolveAccountResponse.zzeu) && getAccountAccessor().equals(resolveAccountResponse.getAccountAccessor());
    }

    public IAccountAccessor getAccountAccessor() {
        return IAccountAccessor.Stub.asInterface(this.zzqv);
    }

    public ConnectionResult getConnectionResult() {
        return this.zzeu;
    }

    public boolean getSaveDefaultAccount() {
        return this.zzhs;
    }

    public boolean isFromCrossClientAuth() {
        return this.zzuv;
    }

    public ResolveAccountResponse setAccountAccessor(IAccountAccessor iAccountAccessor) {
        this.zzqv = iAccountAccessor == null ? null : iAccountAccessor.asBinder();
        return this;
    }

    public ResolveAccountResponse setIsFromCrossClientAuth(boolean z) {
        this.zzuv = z;
        return this;
    }

    public ResolveAccountResponse setSaveDefaultAccount(boolean z) {
        this.zzhs = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzqv, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getConnectionResult(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, getSaveDefaultAccount());
        SafeParcelWriter.writeBoolean(parcel, 5, isFromCrossClientAuth());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "ScopeCreator")
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzd();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getScopeUri", id = 2)
    private final String zzdp;

    @SafeParcelable.Constructor
    Scope(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str) {
        Preconditions.checkNotEmpty(str, "scopeUri must not be null or empty");
        this.zzal = i;
        this.zzdp = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.zzdp.equals(((Scope) obj).zzdp);
    }

    @KeepForSdk
    public final String getScopeUri() {
        return this.zzdp;
    }

    public final int hashCode() {
        return this.zzdp.hashCode();
    }

    public final String toString() {
        return this.zzdp;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeString(parcel, 2, getScopeUri(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

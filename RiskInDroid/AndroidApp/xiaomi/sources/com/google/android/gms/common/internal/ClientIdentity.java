package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ClientIdentityCreator")
@SafeParcelable.Reserved({1000})
public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new ClientIdentityCreator();
    @SafeParcelable.Field(defaultValueUnchecked = "null", id = 2)
    public final String packageName;
    @SafeParcelable.Field(defaultValueUnchecked = "0", id = 1)
    public final int uid;

    @SafeParcelable.Constructor
    public ClientIdentity(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str) {
        this.uid = i;
        this.packageName = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ClientIdentity)) {
            ClientIdentity clientIdentity = (ClientIdentity) obj;
            return clientIdentity.uid == this.uid && Objects.equal(clientIdentity.packageName, this.packageName);
        }
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        int i = this.uid;
        String str = this.packageName;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.uid);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

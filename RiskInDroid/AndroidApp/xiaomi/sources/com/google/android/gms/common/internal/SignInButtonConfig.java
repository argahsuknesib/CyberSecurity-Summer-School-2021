package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInButtonConfigCreator")
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new SignInButtonConfigCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getScopes", id = 4)
    @Deprecated
    private final Scope[] zzqw;
    @SafeParcelable.Field(getter = "getButtonSize", id = 2)
    private final int zzux;
    @SafeParcelable.Field(getter = "getColorScheme", id = 3)
    private final int zzuy;

    @SafeParcelable.Constructor
    SignInButtonConfig(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) Scope[] scopeArr) {
        this.zzal = i;
        this.zzux = i2;
        this.zzuy = i3;
        this.zzqw = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, null);
    }

    public int getButtonSize() {
        return this.zzux;
    }

    public int getColorScheme() {
        return this.zzuy;
    }

    @Deprecated
    public Scope[] getScopes() {
        return this.zzqw;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeInt(parcel, 2, getButtonSize());
        SafeParcelWriter.writeInt(parcel, 3, getColorScheme());
        SafeParcelWriter.writeTypedArray(parcel, 4, getScopes(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

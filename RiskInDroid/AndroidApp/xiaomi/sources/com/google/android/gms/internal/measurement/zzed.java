package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@SafeParcelable.Class(creator = "ConditionalUserPropertyParcelCreator")
public final class zzed extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzed> CREATOR = new zzee();
    @SafeParcelable.Field(id = 6)
    public boolean active;
    @SafeParcelable.Field(id = 5)
    public long creationTimestamp;
    @SafeParcelable.Field(id = 3)
    public String origin;
    @SafeParcelable.Field(id = 2)
    public String packageName;
    @SafeParcelable.Field(id = 11)
    public long timeToLive;
    @SafeParcelable.Field(id = 7)
    public String triggerEventName;
    @SafeParcelable.Field(id = 9)
    public long triggerTimeout;
    @SafeParcelable.Field(id = 4)
    public zzjx zzaep;
    @SafeParcelable.Field(id = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public zzeu zzaeq;
    @SafeParcelable.Field(id = 10)
    public zzeu zzaer;
    @SafeParcelable.Field(id = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public zzeu zzaes;

    zzed(zzed zzed) {
        Preconditions.checkNotNull(zzed);
        this.packageName = zzed.packageName;
        this.origin = zzed.origin;
        this.zzaep = zzed.zzaep;
        this.creationTimestamp = zzed.creationTimestamp;
        this.active = zzed.active;
        this.triggerEventName = zzed.triggerEventName;
        this.zzaeq = zzed.zzaeq;
        this.triggerTimeout = zzed.triggerTimeout;
        this.zzaer = zzed.zzaer;
        this.timeToLive = zzed.timeToLive;
        this.zzaes = zzed.zzaes;
    }

    @SafeParcelable.Constructor
    zzed(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) zzjx zzjx, @SafeParcelable.Param(id = 5) long j, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) zzeu zzeu, @SafeParcelable.Param(id = 9) long j2, @SafeParcelable.Param(id = 10) zzeu zzeu2, @SafeParcelable.Param(id = 11) long j3, @SafeParcelable.Param(id = 12) zzeu zzeu3) {
        this.packageName = str;
        this.origin = str2;
        this.zzaep = zzjx;
        this.creationTimestamp = j;
        this.active = z;
        this.triggerEventName = str3;
        this.zzaeq = zzeu;
        this.triggerTimeout = j2;
        this.zzaer = zzeu2;
        this.timeToLive = j3;
        this.zzaes = zzeu3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.origin, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzaep, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.creationTimestamp);
        SafeParcelWriter.writeBoolean(parcel, 6, this.active);
        SafeParcelWriter.writeString(parcel, 7, this.triggerEventName, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzaeq, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.triggerTimeout);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzaer, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.timeToLive);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzaes, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

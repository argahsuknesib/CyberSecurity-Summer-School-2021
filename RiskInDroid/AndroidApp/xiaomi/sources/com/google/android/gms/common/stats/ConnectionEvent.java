package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@SafeParcelable.Class(creator = "ConnectionEventCreator")
public final class ConnectionEvent extends StatsEvent {
    public static final Parcelable.Creator<ConnectionEvent> CREATOR = new ConnectionEventCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getTimeMillis", id = 2)
    private final long zzxv;
    @SafeParcelable.Field(getter = "getEventType", id = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    private int zzxw;
    @SafeParcelable.Field(getter = "getCallingProcess", id = 4)
    private final String zzxx;
    @SafeParcelable.Field(getter = "getCallingService", id = 5)
    private final String zzxy;
    @SafeParcelable.Field(getter = "getTargetProcess", id = 6)
    private final String zzxz;
    @SafeParcelable.Field(getter = "getTargetService", id = 7)
    private final String zzya;
    @SafeParcelable.Field(getter = "getStackTrace", id = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    private final String zzyb;
    @SafeParcelable.Field(getter = "getEventKey", id = 13)
    private final String zzyc;
    @SafeParcelable.Field(getter = "getElapsedRealtime", id = 10)
    private final long zzyd;
    @SafeParcelable.Field(getter = "getHeapAlloc", id = 11)
    private final long zzye;
    private long zzyf;

    @SafeParcelable.Constructor
    ConnectionEvent(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 12) int i2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) String str4, @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 13) String str6, @SafeParcelable.Param(id = 10) long j2, @SafeParcelable.Param(id = 11) long j3) {
        this.zzal = i;
        this.zzxv = j;
        this.zzxw = i2;
        this.zzxx = str;
        this.zzxy = str2;
        this.zzxz = str3;
        this.zzya = str4;
        this.zzyf = -1;
        this.zzyb = str5;
        this.zzyc = str6;
        this.zzyd = j2;
        this.zzye = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public ConnectionEvent(ConnectionEvent connectionEvent) {
        this(connectionEvent.zzal, connectionEvent.getTimeMillis(), connectionEvent.getEventType(), connectionEvent.getCallingProcess(), connectionEvent.getCallingService(), connectionEvent.getTargetProcess(), connectionEvent.getTargetService(), connectionEvent.getStackTrace(), connectionEvent.getEventKey(), connectionEvent.getElapsedRealtime(), connectionEvent.getHeapAlloc());
    }

    public static boolean checkEventType(StatsEvent statsEvent) {
        return 2 == statsEvent.getEventType() || 3 == statsEvent.getEventType() || 4 == statsEvent.getEventType() || 1 == statsEvent.getEventType() || 6 == statsEvent.getEventType() || 13 == statsEvent.getEventType() || 14 == statsEvent.getEventType() || 15 == statsEvent.getEventType();
    }

    public final StatsEvent ReconstructCloseEvent(StatsEvent statsEvent) {
        if (!(statsEvent instanceof ConnectionEvent)) {
            return statsEvent;
        }
        ConnectionEvent connectionEvent = (ConnectionEvent) statsEvent;
        return (ConnectionEvent) ((ConnectionEvent) new ConnectionEvent(connectionEvent).setEventType(getEventType())).setDurationMillis(getElapsedRealtime() - connectionEvent.getElapsedRealtime());
    }

    public final String getCallingProcess() {
        return this.zzxx;
    }

    public final String getCallingService() {
        return this.zzxy;
    }

    public final long getDurationMillis() {
        return this.zzyf;
    }

    public final long getElapsedRealtime() {
        return this.zzyd;
    }

    public final String getEventKey() {
        return this.zzyc;
    }

    public final int getEventType() {
        return this.zzxw;
    }

    public final long getHeapAlloc() {
        return this.zzye;
    }

    public final String getSpecificString() {
        String callingProcess = getCallingProcess();
        String callingService = getCallingService();
        String targetProcess = getTargetProcess();
        String targetService = getTargetService();
        String str = this.zzyb;
        if (str == null) {
            str = "";
        }
        long heapAlloc = getHeapAlloc();
        StringBuilder sb = new StringBuilder(String.valueOf(callingProcess).length() + 26 + String.valueOf(callingService).length() + String.valueOf(targetProcess).length() + String.valueOf(targetService).length() + String.valueOf(str).length());
        sb.append("\t");
        sb.append(callingProcess);
        sb.append("/");
        sb.append(callingService);
        sb.append("\t");
        sb.append(targetProcess);
        sb.append("/");
        sb.append(targetService);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(heapAlloc);
        return sb.toString();
    }

    public final String getStackTrace() {
        return this.zzyb;
    }

    public final String getTargetProcess() {
        return this.zzxz;
    }

    public final String getTargetService() {
        return this.zzya;
    }

    public final long getTimeMillis() {
        return this.zzxv;
    }

    public final long getTimeout() {
        return 0;
    }

    public final ConnectionEvent markTimeOut() {
        this.zzxw = 6;
        return this;
    }

    public final ConnectionEvent setDurationMillis(long j) {
        this.zzyf = j;
        return this;
    }

    public final ConnectionEvent setEventType(int i) {
        this.zzxw = i;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeLong(parcel, 2, getTimeMillis());
        SafeParcelWriter.writeString(parcel, 4, getCallingProcess(), false);
        SafeParcelWriter.writeString(parcel, 5, getCallingService(), false);
        SafeParcelWriter.writeString(parcel, 6, getTargetProcess(), false);
        SafeParcelWriter.writeString(parcel, 7, getTargetService(), false);
        SafeParcelWriter.writeString(parcel, 8, getStackTrace(), false);
        SafeParcelWriter.writeLong(parcel, 10, getElapsedRealtime());
        SafeParcelWriter.writeLong(parcel, 11, getHeapAlloc());
        SafeParcelWriter.writeInt(parcel, 12, getEventType());
        SafeParcelWriter.writeString(parcel, 13, getEventKey(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

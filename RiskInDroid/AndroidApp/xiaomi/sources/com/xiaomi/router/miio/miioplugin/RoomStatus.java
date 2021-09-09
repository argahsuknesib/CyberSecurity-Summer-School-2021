package com.xiaomi.router.miio.miioplugin;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.RoomStat;
import java.util.Collections;
import java.util.List;

public class RoomStatus implements Parcelable {
    public static final Parcelable.Creator<RoomStatus> CREATOR = new Parcelable.Creator<RoomStatus>() {
        /* class com.xiaomi.router.miio.miioplugin.RoomStatus.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RoomStatus[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RoomStatus(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6613O000000o = "";
    public String O00000Oo = "";
    public String O00000o = "";
    public String O00000o0 = "";
    public String O00000oO = "";
    public int O00000oo = 0;
    public volatile List<String> O0000O0o = Collections.emptyList();
    public String O0000OOo = "";

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return this.O00000o0.hashCode();
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return (obj instanceof RoomStatus) && (str = ((RoomStatus) obj).O00000o0) != null && (str2 = this.O00000o0) != null && str2.equalsIgnoreCase(str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6613O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeInt(this.O00000oo);
        parcel.writeStringList(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
    }

    public RoomStatus(Parcel parcel) {
        this.f6613O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readInt();
        this.O0000O0o = parcel.createStringArrayList();
        this.O0000OOo = parcel.readString();
    }

    public final RoomStat O000000o() {
        RoomStat roomStat = new RoomStat();
        roomStat.bssid = this.f6613O000000o;
        roomStat.desc = this.O00000Oo;
        roomStat.dids = this.O0000O0o;
        roomStat.icon = this.O0000OOo;
        roomStat.id = this.O00000o0;
        roomStat.name = this.O00000o;
        roomStat.parentid = this.O00000oO;
        roomStat.shareflag = this.O00000oo;
        return roomStat;
    }

    public RoomStatus() {
    }
}

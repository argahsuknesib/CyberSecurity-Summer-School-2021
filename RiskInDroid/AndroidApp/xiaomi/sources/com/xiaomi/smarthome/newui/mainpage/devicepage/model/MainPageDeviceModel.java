package com.xiaomi.smarthome.newui.mainpage.devicepage.model;

import _m_j.faw;
import _m_j.fno;
import _m_j.fqw;
import _m_j.ggb;
import _m_j.gzt;
import _m_j.hcc;
import _m_j.hcg;
import _m_j.hgf;
import _m_j.iuf;
import _m_j.iuo;
import _m_j.ixe;
import _m_j.iyo;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.util.Pair;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.newui.card.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 C2\u00020\u0001:\u0001CB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B§\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0015HÆ\u0003J\t\u0010/\u001a\u00020\u000bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\t\u00106\u001a\u00020\u000bHÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J«\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001J\b\u0010:\u001a\u00020\u0015H\u0016J\u0013\u0010;\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\u0015HÖ\u0001J\t\u0010?\u001a\u00020\u000bHÖ\u0001J\u0018\u0010@\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0015H\u0016R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010 R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010 R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010 R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001b¨\u0006D"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "isIRDevice", "", "isBleDevice", "isBlePropValid", "isNew", "model", "", "did", "deviceName", "isOnline", "roomName", "iconUrl", "switchIcon", "orderTimeJString", "freqFlag", "pinCode", "", "propText", "deviceStatus", "Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/SwitcherStatus;", "(ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/SwitcherStatus;)V", "getDeviceName", "()Ljava/lang/String;", "getDeviceStatus", "()Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/SwitcherStatus;", "getDid", "getFreqFlag", "()Z", "getIconUrl", "getModel", "getOrderTimeJString", "getPinCode", "()I", "getPropText", "getRoomName", "getSwitchIcon", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MainPageDeviceModel implements Parcelable {
    public static final O000000o CREATOR = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    public final boolean f10251O000000o;
    public final boolean O00000Oo;
    public final boolean O00000o;
    public final boolean O00000o0;
    public final String O00000oO;
    public final String O00000oo;
    public final String O0000O0o;
    public final boolean O0000OOo;
    public final String O0000Oo;
    public final String O0000Oo0;
    public final String O0000OoO;
    public final String O0000Ooo;
    public final int O0000o0;
    public final boolean O0000o00;
    public final String O0000o0O;
    public final hgf O0000o0o;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel.<init>(boolean, boolean, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, java.lang.String, int):void
     arg types: [int, int, int, int, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int, int, ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel.<init>(boolean, boolean, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, java.lang.String, _m_j.hgf):void
      com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel.<init>(boolean, boolean, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, java.lang.String, int):void */
    public MainPageDeviceModel() {
        this(false, false, false, false, (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, false, 0, (String) null, 65535);
    }

    public static final MainPageDeviceModel O000000o(Device device) {
        return CREATOR.O000000o(device);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MainPageDeviceModel)) {
            return false;
        }
        MainPageDeviceModel mainPageDeviceModel = (MainPageDeviceModel) obj;
        return this.f10251O000000o == mainPageDeviceModel.f10251O000000o && this.O00000Oo == mainPageDeviceModel.O00000Oo && this.O00000o0 == mainPageDeviceModel.O00000o0 && this.O00000o == mainPageDeviceModel.O00000o && ixe.O000000o(this.O00000oO, mainPageDeviceModel.O00000oO) && ixe.O000000o(this.O00000oo, mainPageDeviceModel.O00000oo) && ixe.O000000o(this.O0000O0o, mainPageDeviceModel.O0000O0o) && this.O0000OOo == mainPageDeviceModel.O0000OOo && ixe.O000000o(this.O0000Oo0, mainPageDeviceModel.O0000Oo0) && ixe.O000000o(this.O0000Oo, mainPageDeviceModel.O0000Oo) && ixe.O000000o(this.O0000OoO, mainPageDeviceModel.O0000OoO) && ixe.O000000o(this.O0000Ooo, mainPageDeviceModel.O0000Ooo) && this.O0000o00 == mainPageDeviceModel.O0000o00 && this.O0000o0 == mainPageDeviceModel.O0000o0 && ixe.O000000o(this.O0000o0O, mainPageDeviceModel.O0000o0O) && ixe.O000000o(this.O0000o0o, mainPageDeviceModel.O0000o0o);
    }

    public final int hashCode() {
        boolean z = this.f10251O000000o;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.O00000Oo;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.O00000o0;
        if (z4) {
            z4 = true;
        }
        int i3 = (i2 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.O00000o;
        if (z5) {
            z5 = true;
        }
        int hashCode = (((((((i3 + (z5 ? 1 : 0)) * 31) + this.O00000oO.hashCode()) * 31) + this.O00000oo.hashCode()) * 31) + this.O0000O0o.hashCode()) * 31;
        boolean z6 = this.O0000OOo;
        if (z6) {
            z6 = true;
        }
        int hashCode2 = (((((((((hashCode + (z6 ? 1 : 0)) * 31) + this.O0000Oo0.hashCode()) * 31) + this.O0000Oo.hashCode()) * 31) + this.O0000OoO.hashCode()) * 31) + this.O0000Ooo.hashCode()) * 31;
        boolean z7 = this.O0000o00;
        if (!z7) {
            z2 = z7;
        }
        int hashCode3 = (((((hashCode2 + (z2 ? 1 : 0)) * 31) + Integer.valueOf(this.O0000o0).hashCode()) * 31) + this.O0000o0O.hashCode()) * 31;
        hgf hgf = this.O0000o0o;
        return hashCode3 + (hgf == null ? 0 : hgf.hashCode());
    }

    public final String toString() {
        return "MainPageDeviceModel(isIRDevice=" + this.f10251O000000o + ", isBleDevice=" + this.O00000Oo + ", isBlePropValid=" + this.O00000o0 + ", isNew=" + this.O00000o + ", model=" + this.O00000oO + ", did=" + this.O00000oo + ", deviceName=" + this.O0000O0o + ", isOnline=" + this.O0000OOo + ", roomName=" + this.O0000Oo0 + ", iconUrl=" + this.O0000Oo + ", switchIcon=" + this.O0000OoO + ", orderTimeJString=" + this.O0000Ooo + ", freqFlag=" + this.O0000o00 + ", pinCode=" + this.O0000o0 + ", propText=" + this.O0000o0O + ", deviceStatus=" + this.O0000o0o + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    private /* synthetic */ MainPageDeviceModel(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2, String str3, boolean z5, String str4, String str5, String str6, String str7, boolean z6, int i, String str8, int i2) {
        this((r0 & 1) != 0 ? false : z, (r0 & 2) != 0 ? false : z2, (r0 & 4) != 0 ? false : z3, (r0 & 8) != 0 ? false : z4, (r0 & 16) != 0 ? "" : str, (r0 & 32) != 0 ? "" : str2, (r0 & 64) != 0 ? "" : str3, (r0 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0 ? false : z5, (r0 & 256) != 0 ? "" : str4, (r0 & 512) != 0 ? "" : str5, (r0 & 1024) != 0 ? "" : str6, (r0 & 2048) != 0 ? "" : str7, (r0 & 4096) != 0 ? false : z6, (r0 & 8192) != 0 ? 0 : i, (r0 & 16384) != 0 ? "" : str8, (hgf) null);
        int i3 = i2;
    }

    public MainPageDeviceModel(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2, String str3, boolean z5, String str4, String str5, String str6, String str7, boolean z6, int i, String str8, hgf hgf) {
        String str9 = str2;
        String str10 = str3;
        String str11 = str4;
        String str12 = str5;
        String str13 = str6;
        String str14 = str7;
        String str15 = str8;
        ixe.O00000o(str, "model");
        ixe.O00000o(str9, "did");
        ixe.O00000o(str10, "deviceName");
        ixe.O00000o(str11, "roomName");
        ixe.O00000o(str12, "iconUrl");
        ixe.O00000o(str13, "switchIcon");
        ixe.O00000o(str14, "orderTimeJString");
        ixe.O00000o(str15, "propText");
        this.f10251O000000o = z;
        this.O00000Oo = z2;
        this.O00000o0 = z3;
        this.O00000o = z4;
        this.O00000oO = str;
        this.O00000oo = str9;
        this.O0000O0o = str10;
        this.O0000OOo = z5;
        this.O0000Oo0 = str11;
        this.O0000Oo = str12;
        this.O0000OoO = str13;
        this.O0000Ooo = str14;
        this.O0000o00 = z6;
        this.O0000o0 = i;
        this.O0000o0O = str15;
        this.O0000o0o = hgf;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MainPageDeviceModel(Parcel parcel) {
        this(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, 32768);
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ixe.O00000o(parcel, "parcel");
        boolean z = parcel.readByte() != 0;
        boolean z2 = parcel.readByte() != 0;
        boolean z3 = parcel.readByte() != 0;
        boolean z4 = parcel.readByte() != 0;
        String readString = parcel.readString();
        String str8 = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        if (readString2 == null) {
            str = "";
        } else {
            str = readString2;
        }
        String readString3 = parcel.readString();
        if (readString3 == null) {
            str2 = "";
        } else {
            str2 = readString3;
        }
        boolean z5 = parcel.readByte() != 0;
        String readString4 = parcel.readString();
        if (readString4 == null) {
            str3 = "";
        } else {
            str3 = readString4;
        }
        String readString5 = parcel.readString();
        if (readString5 == null) {
            str4 = "";
        } else {
            str4 = readString5;
        }
        String readString6 = parcel.readString();
        if (readString6 == null) {
            str5 = "";
        } else {
            str5 = readString6;
        }
        String readString7 = parcel.readString();
        if (readString7 == null) {
            str6 = "";
        } else {
            str6 = readString7;
        }
        boolean z6 = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        String readString8 = parcel.readString();
        if (readString8 == null) {
            str7 = "";
        } else {
            str7 = readString8;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ixe.O00000o(parcel, "parcel");
        parcel.writeByte(this.f10251O000000o ? (byte) 1 : 0);
        parcel.writeByte(this.O00000Oo ? (byte) 1 : 0);
        parcel.writeByte(this.O00000o0 ? (byte) 1 : 0);
        parcel.writeByte(this.O00000o ? (byte) 1 : 0);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeByte(this.O0000OOo ? (byte) 1 : 0);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeString(this.O0000OoO);
        parcel.writeString(this.O0000Ooo);
        parcel.writeByte(this.O0000o00 ? (byte) 1 : 0);
        parcel.writeInt(this.O0000o0);
        parcel.writeString(this.O0000o0O);
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016JL\u0010\n\u001a2\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f0\u000bj\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f`\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001d\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;", "()V", "convert", "device", "Lcom/xiaomi/smarthome/device/Device;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getDeviceStatus", "Ljava/util/ArrayList;", "Landroid/util/Pair;", "Lcom/xiaomi/smarthome/newui/card/State;", "", "Lkotlin/collections/ArrayList;", "cardItem", "Lcom/xiaomi/smarthome/newui/card/Card$CardType;", "getDeviceStatusIcon", "isBlePropValid", "", "propText", "isStatusCacheTimeValid", "newArray", "", "size", "", "(I)[Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o implements Parcelable.Creator<MainPageDeviceModel> {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            ixe.O00000o(parcel, "parcel");
            return new MainPageDeviceModel(parcel);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: java.lang.String} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
        /* JADX WARNING: Multi-variable type inference failed */
        public final MainPageDeviceModel O000000o(Device device) {
            hgf hgf;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            hgf hgf2;
            State state;
            Device device2 = device;
            String str9 = null;
            if (device2 == null || device.isHideMainList()) {
                return null;
            }
            hcc gridCard = faw.O00000o0().getGridCard(device2);
            boolean z = device.isOnlineAdvance() || (device2 instanceof BleDevice) || (gridCard != null && gridCard.O00000o0());
            ArrayList<Pair> deviceRenderData = faw.O00000o0().getDeviceRenderData(device2, gridCard);
            if (!(deviceRenderData instanceof ArrayList)) {
                deviceRenderData = null;
            }
            if (gridCard == null || deviceRenderData == null) {
                hgf = null;
                str2 = "";
                str = str2;
            } else {
                Pair O000000o2 = gzt.O000000o(device2, deviceRenderData);
                if (!(O000000o2 instanceof Pair)) {
                    O000000o2 = null;
                }
                if (!device2.isOnline || O000000o2 == null || (state = (State) O000000o2.first) == null) {
                    hgf2 = null;
                    str9 = "";
                } else {
                    Object obj = O000000o2.second;
                    if (obj instanceof String) {
                        str9 = obj;
                    }
                    if (str9 == null) {
                        str9 = "";
                    }
                    Object obj2 = gridCard.O000000o().get(0);
                    if (obj2 != null) {
                        Collection arrayList = new ArrayList();
                        for (Object next : O000000o(device2, (hcc.O000000o) obj2)) {
                            Pair pair = (Pair) next;
                            if ((pair.first == null || pair.second == null) ? false : true) {
                                arrayList.add(next);
                            }
                        }
                        Iterable<Pair> iterable = (List) arrayList;
                        Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
                        for (Pair pair2 : iterable) {
                            State state2 = (State) pair2.first;
                            ixe.O000000o(state2);
                            String str10 = (String) pair2.second;
                            ixe.O000000o((Object) str10);
                            arrayList2.add(iuf.O000000o(state2, str10));
                        }
                        hgf2 = new hgf(state, (List) arrayList2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.newui.card.Card.CardType<*>");
                    }
                }
                str2 = gzt.O000000o(device2.model, deviceRenderData);
                if (str2 == null) {
                    str2 = "";
                }
                str = str9;
                hgf = hgf2;
            }
            boolean O000000o3 = fqw.O000000o(device2.did);
            boolean z2 = device2 instanceof BleDevice;
            boolean O000000o4 = O000000o(str2, device2);
            boolean O000000o5 = ixe.O000000o((Object) fno.O000000o().O0000o0o(), (Object) device2.did);
            String str11 = device2.model;
            if (str11 == null) {
                str3 = "";
            } else {
                str3 = str11;
            }
            String str12 = device2.did;
            if (str12 == null) {
                str4 = "";
            } else {
                str4 = str12;
            }
            String str13 = device2.name;
            if (str13 == null) {
                str5 = "";
            } else {
                str5 = str13;
            }
            String O0000o0O = ggb.O00000Oo().O0000o0O(device2.did);
            if (O0000o0O == null) {
                str6 = "";
            } else {
                str6 = O0000o0O;
            }
            String O0000oOO = DeviceFactory.O0000oOO(device2.model);
            if (O0000oOO == null) {
                str7 = "";
            } else {
                str7 = O0000oOO;
            }
            String str14 = device2.orderTimeJString;
            if (str14 == null) {
                str8 = "";
            } else {
                str8 = str14;
            }
            return new MainPageDeviceModel(O000000o3, z2, O000000o4, O000000o5, str3, str4, str5, z, str6, str7, str, str8, device2.freqFlag, device2.isSetPinCode, str2, hgf);
        }

        private static ArrayList<Pair<State, String>> O000000o(Device device, hcc.O000000o<?> o000000o) {
            ArrayList<Pair<State, String>> arrayList = new ArrayList<>();
            Pair<State, String> buttonDrawable = faw.O00000o0().getButtonDrawable(device, 0, o000000o, false);
            Pair<State, String> buttonDrawable2 = faw.O00000o0().getButtonDrawable(device, 0, o000000o, true);
            if (buttonDrawable != null) {
                arrayList.add(buttonDrawable);
            }
            if (buttonDrawable2 != null) {
                arrayList.add(buttonDrawable2);
            }
            return arrayList;
        }

        private static boolean O000000o(String str, Device device) {
            if (!(device instanceof BleDevice) || faw.O00000o0().getGridCard(device) == null || ((BleDevice) device).isNetGateConnected) {
                return true;
            }
            CharSequence charSequence = str;
            if (!(!(charSequence == null || iyo.O000000o(charSequence))) || !O00000Oo(device)) {
                return false;
            }
            return true;
        }

        private static boolean O00000Oo(Device device) {
            ArrayList<Long> deviceDataUpdateTime = faw.O00000o0().getDeviceDataUpdateTime(device);
            if (deviceDataUpdateTime == null) {
                return true;
            }
            Iterator<Long> it = deviceDataUpdateTime.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                if (next == null || next.longValue() != 0) {
                    ixe.O00000Oo(next, "time");
                    if (!hcg.O000000o(next.longValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MainPageDeviceModel[i];
        }
    }
}

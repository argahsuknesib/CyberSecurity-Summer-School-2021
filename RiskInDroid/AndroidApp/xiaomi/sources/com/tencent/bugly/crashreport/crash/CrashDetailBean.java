package com.tencent.bugly.crashreport.crash;

import _m_j.dif;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.util.Map;
import java.util.UUID;

public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() {
        /* class com.tencent.bugly.crashreport.crash.CrashDetailBean.AnonymousClass1 */

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CrashDetailBean[i];
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public long f5815O000000o = -1;
    public int O00000Oo = 0;
    public boolean O00000o = false;
    public String O00000o0 = UUID.randomUUID().toString();
    public String O00000oO = "";
    public String O00000oo = "";
    public String O0000O0o = "";
    public Map<String, PlugInBean> O0000OOo = null;
    public boolean O0000Oo = false;
    public Map<String, PlugInBean> O0000Oo0 = null;
    public boolean O0000OoO = false;
    public int O0000Ooo = 0;
    public String O0000o = "";
    public String O0000o0 = "";
    public String O0000o00 = "";
    public String O0000o0O = "";
    public String O0000o0o = "";
    public String O0000oO = null;
    public long O0000oO0 = -1;
    public int O0000oOO = 0;
    public String O0000oOo = "";
    public String O0000oo = null;
    public String O0000oo0 = "";
    public byte[] O0000ooO = null;
    public Map<String, String> O0000ooo = null;
    public long O000O00o = -1;
    public long O000O0OO = -1;
    public long O000O0Oo = -1;
    public long O000O0o = -1;
    public long O000O0o0 = -1;
    public String O000O0oO = "";
    public String O000O0oo = "";
    public long O000OO = -1;
    public String O000OO00 = "";
    public String O000OO0o = "";
    public boolean O000OOOo = false;
    public int O000OOo = -1;
    public Map<String, String> O000OOo0 = null;
    public int O000OOoO = -1;
    public Map<String, String> O000OOoo = null;
    public byte[] O000Oo0 = null;
    public Map<String, String> O000Oo00 = null;
    public String O000Oo0O = null;
    public String O000Oo0o = null;
    private String O000OoO0 = "";
    public long O00oOoOo = -1;
    public String O00oOooO = "";
    public String O00oOooo = "";

    public int describeContents() {
        return 0;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        CrashDetailBean crashDetailBean = (CrashDetailBean) obj;
        if (crashDetailBean == null) {
            return 1;
        }
        long j = this.O0000oO0 - crashDetailBean.O0000oO0;
        if (j <= 0) {
            return j < 0 ? -1 : 0;
        }
        return 1;
    }

    public CrashDetailBean() {
    }

    public CrashDetailBean(Parcel parcel) {
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readString();
        boolean z = true;
        this.O00000o = parcel.readByte() == 1;
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000Oo = parcel.readByte() == 1;
        this.O0000OoO = parcel.readByte() == 1;
        this.O0000Ooo = parcel.readInt();
        this.O0000o00 = parcel.readString();
        this.O0000o0 = parcel.readString();
        this.O0000o0O = parcel.readString();
        this.O0000o0o = parcel.readString();
        this.O0000o = parcel.readString();
        this.O0000oO0 = parcel.readLong();
        this.O0000oO = parcel.readString();
        this.O0000oOO = parcel.readInt();
        this.O0000oOo = parcel.readString();
        this.O0000oo0 = parcel.readString();
        this.O0000oo = parcel.readString();
        this.O0000ooo = dif.O00000Oo(parcel);
        this.O00oOooO = parcel.readString();
        this.O00oOooo = parcel.readString();
        this.O000O00o = parcel.readLong();
        this.O000O0OO = parcel.readLong();
        this.O000O0Oo = parcel.readLong();
        this.O00oOoOo = parcel.readLong();
        this.O000O0o0 = parcel.readLong();
        this.O000O0o = parcel.readLong();
        this.O000O0oO = parcel.readString();
        this.O000OoO0 = parcel.readString();
        this.O000O0oo = parcel.readString();
        this.O000OO00 = parcel.readString();
        this.O000OO0o = parcel.readString();
        this.O000OO = parcel.readLong();
        this.O000OOOo = parcel.readByte() != 1 ? false : z;
        this.O000OOo0 = dif.O00000Oo(parcel);
        this.O0000OOo = dif.O000000o(parcel);
        this.O0000Oo0 = dif.O000000o(parcel);
        this.O000OOo = parcel.readInt();
        this.O000OOoO = parcel.readInt();
        this.O000OOoo = dif.O00000Oo(parcel);
        this.O000Oo00 = dif.O00000Oo(parcel);
        this.O000Oo0 = parcel.createByteArray();
        this.O0000ooO = parcel.createByteArray();
        this.O000Oo0O = parcel.readString();
        this.O000Oo0o = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeByte(this.O00000o ? (byte) 1 : 0);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeByte(this.O0000Oo ? (byte) 1 : 0);
        parcel.writeByte(this.O0000OoO ? (byte) 1 : 0);
        parcel.writeInt(this.O0000Ooo);
        parcel.writeString(this.O0000o00);
        parcel.writeString(this.O0000o0);
        parcel.writeString(this.O0000o0O);
        parcel.writeString(this.O0000o0o);
        parcel.writeString(this.O0000o);
        parcel.writeLong(this.O0000oO0);
        parcel.writeString(this.O0000oO);
        parcel.writeInt(this.O0000oOO);
        parcel.writeString(this.O0000oOo);
        parcel.writeString(this.O0000oo0);
        parcel.writeString(this.O0000oo);
        dif.O00000Oo(parcel, this.O0000ooo);
        parcel.writeString(this.O00oOooO);
        parcel.writeString(this.O00oOooo);
        parcel.writeLong(this.O000O00o);
        parcel.writeLong(this.O000O0OO);
        parcel.writeLong(this.O000O0Oo);
        parcel.writeLong(this.O00oOoOo);
        parcel.writeLong(this.O000O0o0);
        parcel.writeLong(this.O000O0o);
        parcel.writeString(this.O000O0oO);
        parcel.writeString(this.O000OoO0);
        parcel.writeString(this.O000O0oo);
        parcel.writeString(this.O000OO00);
        parcel.writeString(this.O000OO0o);
        parcel.writeLong(this.O000OO);
        parcel.writeByte(this.O000OOOo ? (byte) 1 : 0);
        dif.O00000Oo(parcel, this.O000OOo0);
        dif.O000000o(parcel, this.O0000OOo);
        dif.O000000o(parcel, this.O0000Oo0);
        parcel.writeInt(this.O000OOo);
        parcel.writeInt(this.O000OOoO);
        dif.O00000Oo(parcel, this.O000OOoo);
        dif.O00000Oo(parcel, this.O000Oo00);
        parcel.writeByteArray(this.O000Oo0);
        parcel.writeByteArray(this.O0000ooO);
        parcel.writeString(this.O000Oo0O);
        parcel.writeString(this.O000Oo0o);
    }
}

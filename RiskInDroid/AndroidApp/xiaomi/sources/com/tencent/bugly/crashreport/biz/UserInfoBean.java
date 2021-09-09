package com.tencent.bugly.crashreport.biz;

import _m_j.dif;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() {
        /* class com.tencent.bugly.crashreport.biz.UserInfoBean.AnonymousClass1 */

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new UserInfoBean[i];
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public long f5810O000000o;
    public int O00000Oo;
    public String O00000o;
    public String O00000o0;
    public long O00000oO;
    public long O00000oo;
    public long O0000O0o;
    public long O0000OOo;
    public String O0000Oo;
    public long O0000Oo0;
    public long O0000OoO;
    public boolean O0000Ooo;
    public int O0000o;
    public String O0000o0;
    public String O0000o00;
    public int O0000o0O;
    public int O0000o0o;
    public Map<String, String> O0000oO;
    public Map<String, String> O0000oO0;

    public int describeContents() {
        return 0;
    }

    public UserInfoBean() {
        this.O0000OoO = 0;
        this.O0000Ooo = false;
        this.O0000o00 = "unknown";
        this.O0000o0o = -1;
        this.O0000o = -1;
        this.O0000oO0 = null;
        this.O0000oO = null;
    }

    public UserInfoBean(Parcel parcel) {
        this.O0000OoO = 0;
        boolean z = false;
        this.O0000Ooo = false;
        this.O0000o00 = "unknown";
        this.O0000o0o = -1;
        this.O0000o = -1;
        this.O0000oO0 = null;
        this.O0000oO = null;
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readLong();
        this.O00000oo = parcel.readLong();
        this.O0000O0o = parcel.readLong();
        this.O0000OOo = parcel.readLong();
        this.O0000Oo0 = parcel.readLong();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readLong();
        this.O0000Ooo = parcel.readByte() == 1 ? true : z;
        this.O0000o00 = parcel.readString();
        this.O0000o0o = parcel.readInt();
        this.O0000o = parcel.readInt();
        this.O0000oO0 = dif.O00000Oo(parcel);
        this.O0000oO = dif.O00000Oo(parcel);
        this.O0000o0 = parcel.readString();
        this.O0000o0O = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeLong(this.O00000oO);
        parcel.writeLong(this.O00000oo);
        parcel.writeLong(this.O0000O0o);
        parcel.writeLong(this.O0000OOo);
        parcel.writeLong(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeLong(this.O0000OoO);
        parcel.writeByte(this.O0000Ooo ? (byte) 1 : 0);
        parcel.writeString(this.O0000o00);
        parcel.writeInt(this.O0000o0o);
        parcel.writeInt(this.O0000o);
        dif.O00000Oo(parcel, this.O0000oO0);
        dif.O00000Oo(parcel, this.O0000oO);
        parcel.writeString(this.O0000o0);
        parcel.writeInt(this.O0000o0O);
    }
}

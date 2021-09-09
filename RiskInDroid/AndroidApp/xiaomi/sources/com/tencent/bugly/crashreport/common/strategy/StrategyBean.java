package com.tencent.bugly.crashreport.common.strategy;

import _m_j.dif;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import java.util.Map;

public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() {
        /* class com.tencent.bugly.crashreport.common.strategy.StrategyBean.AnonymousClass1 */

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new StrategyBean[i];
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f5812O000000o = "http://rqd.uu.qq.com/rqd/sync";
    public static String O00000Oo = "http://android.bugly.qq.com/rqd/async";
    public static String O00000o = null;
    public static String O00000o0 = "http://android.bugly.qq.com/rqd/async";
    public long O00000oO;
    public long O00000oo;
    public boolean O0000O0o;
    public boolean O0000OOo;
    public boolean O0000Oo;
    public boolean O0000Oo0;
    public boolean O0000OoO;
    public boolean O0000Ooo;
    public long O0000o;
    public boolean O0000o0;
    public boolean O0000o00;
    public boolean O0000o0O;
    public long O0000o0o;
    public String O0000oO;
    public String O0000oO0;
    public String O0000oOO;
    public String O0000oOo;
    public int O0000oo;
    public Map<String, String> O0000oo0;
    public long O0000ooO;
    public long O0000ooo;

    public int describeContents() {
        return 0;
    }

    public StrategyBean() {
        this.O00000oO = -1;
        this.O00000oo = -1;
        this.O0000O0o = true;
        this.O0000OOo = true;
        this.O0000Oo0 = true;
        this.O0000Oo = true;
        this.O0000OoO = false;
        this.O0000Ooo = true;
        this.O0000o00 = true;
        this.O0000o0 = true;
        this.O0000o0O = true;
        this.O0000o = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        this.O0000oO0 = O00000Oo;
        this.O0000oO = O00000o0;
        this.O0000oOO = f5812O000000o;
        this.O0000oo = 10;
        this.O0000ooO = 300000;
        this.O0000ooo = -1;
        this.O00000oo = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L@)");
        O00000o = sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K@!");
        this.O0000oOo = sb.toString();
    }

    public StrategyBean(Parcel parcel) {
        this.O00000oO = -1;
        this.O00000oo = -1;
        boolean z = true;
        this.O0000O0o = true;
        this.O0000OOo = true;
        this.O0000Oo0 = true;
        this.O0000Oo = true;
        this.O0000OoO = false;
        this.O0000Ooo = true;
        this.O0000o00 = true;
        this.O0000o0 = true;
        this.O0000o0O = true;
        this.O0000o = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        this.O0000oO0 = O00000Oo;
        this.O0000oO = O00000o0;
        this.O0000oOO = f5812O000000o;
        this.O0000oo = 10;
        this.O0000ooO = 300000;
        this.O0000ooo = -1;
        try {
            O00000o = "S(@L@L@)";
            this.O00000oo = parcel.readLong();
            this.O0000O0o = parcel.readByte() == 1;
            this.O0000OOo = parcel.readByte() == 1;
            this.O0000Oo0 = parcel.readByte() == 1;
            this.O0000oO0 = parcel.readString();
            this.O0000oO = parcel.readString();
            this.O0000oOo = parcel.readString();
            this.O0000oo0 = dif.O00000Oo(parcel);
            this.O0000Oo = parcel.readByte() == 1;
            this.O0000OoO = parcel.readByte() == 1;
            this.O0000o0 = parcel.readByte() == 1;
            this.O0000o0O = parcel.readByte() == 1;
            this.O0000o = parcel.readLong();
            this.O0000Ooo = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.O0000o00 = z;
            this.O0000o0o = parcel.readLong();
            this.O0000oo = parcel.readInt();
            this.O0000ooO = parcel.readLong();
            this.O0000ooo = parcel.readLong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.O00000oo);
        parcel.writeByte(this.O0000O0o ? (byte) 1 : 0);
        parcel.writeByte(this.O0000OOo ? (byte) 1 : 0);
        parcel.writeByte(this.O0000Oo0 ? (byte) 1 : 0);
        parcel.writeString(this.O0000oO0);
        parcel.writeString(this.O0000oO);
        parcel.writeString(this.O0000oOo);
        dif.O00000Oo(parcel, this.O0000oo0);
        parcel.writeByte(this.O0000Oo ? (byte) 1 : 0);
        parcel.writeByte(this.O0000OoO ? (byte) 1 : 0);
        parcel.writeByte(this.O0000o0 ? (byte) 1 : 0);
        parcel.writeByte(this.O0000o0O ? (byte) 1 : 0);
        parcel.writeLong(this.O0000o);
        parcel.writeByte(this.O0000Ooo ? (byte) 1 : 0);
        parcel.writeByte(this.O0000o00 ? (byte) 1 : 0);
        parcel.writeLong(this.O0000o0o);
        parcel.writeInt(this.O0000oo);
        parcel.writeLong(this.O0000ooO);
        parcel.writeLong(this.O0000ooo);
    }
}

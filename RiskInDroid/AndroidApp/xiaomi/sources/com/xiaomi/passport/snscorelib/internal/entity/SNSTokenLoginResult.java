package com.xiaomi.passport.snscorelib.internal.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class SNSTokenLoginResult implements Parcelable {
    public static final Parcelable.Creator<SNSTokenLoginResult> CREATOR = new Parcelable.Creator<SNSTokenLoginResult>() {
        /* class com.xiaomi.passport.snscorelib.internal.entity.SNSTokenLoginResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SNSTokenLoginResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SNSTokenLoginResult(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f6209O000000o;
    public final String O00000Oo;
    public final String O00000o;
    public final String O00000o0;
    public final String O00000oO;
    public final String O00000oo;
    public final String O0000O0o;
    public final String O0000OOo;
    public final String O0000Oo;
    public final String O0000Oo0;
    public String O0000OoO;
    public boolean O0000Ooo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f6210O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;
        public String O0000OOo;
        public String O0000Oo;
        public String O0000Oo0;
        public String O0000OoO;
        public boolean O0000Ooo;
    }

    public int describeContents() {
        return 0;
    }

    /* synthetic */ SNSTokenLoginResult(Parcel parcel, byte b) {
        this(parcel);
    }

    public /* synthetic */ SNSTokenLoginResult(O000000o o000000o, byte b) {
        this(o000000o);
    }

    private SNSTokenLoginResult(O000000o o000000o) {
        this.f6209O000000o = o000000o.f6210O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
        this.O00000oO = o000000o.O00000oO;
        this.O00000oo = o000000o.O00000oo;
        this.O0000O0o = o000000o.O0000O0o;
        this.O0000OOo = o000000o.O0000OOo;
        this.O0000Oo0 = o000000o.O0000Oo0;
        this.O0000Oo = o000000o.O0000Oo;
        this.O0000OoO = o000000o.O0000OoO;
        this.O0000Ooo = o000000o.O0000Ooo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6209O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeString(this.O0000OoO);
        parcel.writeByte(this.O0000Ooo ? (byte) 1 : 0);
    }

    private SNSTokenLoginResult(Parcel parcel) {
        this.f6209O000000o = parcel.readInt();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readString();
        this.O0000Ooo = parcel.readByte() != 0;
    }
}

package com.xiaomi.passport.snscorelib.internal.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class SNSLoginParameter implements Parcelable {
    public static final Parcelable.Creator<SNSLoginParameter> CREATOR = new Parcelable.Creator<SNSLoginParameter>() {
        /* class com.xiaomi.passport.snscorelib.internal.entity.SNSLoginParameter.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SNSLoginParameter[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SNSLoginParameter(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f6207O000000o;
    public final String O00000Oo;
    public final String O00000o;
    public final String O00000o0;
    public final String O00000oO;
    public final String O00000oo;
    public final String O0000O0o;
    public final String O0000OOo;
    public String O0000Oo;
    public boolean O0000Oo0;
    public boolean O0000OoO;
    public final String O0000Ooo;
    public final String O0000o0;
    public final String O0000o00;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ SNSLoginParameter(Parcel parcel, byte b) {
        this(parcel);
    }

    /* synthetic */ SNSLoginParameter(O000000o o000000o, byte b) {
        this(o000000o);
    }

    private SNSLoginParameter(O000000o o000000o) {
        this.f6207O000000o = o000000o.f6208O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
        this.O00000oO = o000000o.O00000oO;
        this.O00000oo = o000000o.O00000oo;
        this.O0000O0o = o000000o.O0000O0o;
        this.O0000OOo = o000000o.O0000OOo;
        this.O0000Oo0 = o000000o.O0000Oo;
        this.O0000Oo = o000000o.O0000Oo0;
        this.O0000OoO = o000000o.O0000OoO;
        this.O0000Ooo = o000000o.O0000Ooo;
        this.O0000o00 = o000000o.O0000o00;
        this.O0000o0 = o000000o.O0000o0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6207O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo);
        parcel.writeByte(this.O0000Oo0 ? (byte) 1 : 0);
        parcel.writeByte(this.O0000OoO ? (byte) 1 : 0);
        parcel.writeString(this.O0000Ooo);
        parcel.writeString(this.O0000o00);
        parcel.writeString(this.O0000o0);
    }

    private SNSLoginParameter(Parcel parcel) {
        this.f6207O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo = parcel.readString();
        boolean z = true;
        this.O0000Oo0 = parcel.readByte() != 0;
        this.O0000OoO = parcel.readByte() == 0 ? false : z;
        this.O0000Ooo = parcel.readString();
        this.O0000o00 = parcel.readString();
        this.O0000o0 = parcel.readString();
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f6208O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;
        public String O0000OOo;
        public boolean O0000Oo = true;
        public String O0000Oo0;
        public boolean O0000OoO = true;
        public String O0000Ooo;
        public String O0000o0;
        public String O0000o00;

        public final O000000o O000000o(String str) {
            this.f6208O000000o = str;
            return this;
        }

        public final O000000o O00000Oo(String str) {
            this.O00000Oo = str;
            return this;
        }

        public final O000000o O00000o0(String str) {
            this.O00000o = str;
            return this;
        }

        public final O000000o O00000o(String str) {
            this.O00000oo = str;
            return this;
        }

        public final O000000o O00000oO(String str) {
            this.O0000Oo0 = str;
            return this;
        }

        public final SNSLoginParameter O000000o() {
            return new SNSLoginParameter(this, (byte) 0);
        }
    }
}

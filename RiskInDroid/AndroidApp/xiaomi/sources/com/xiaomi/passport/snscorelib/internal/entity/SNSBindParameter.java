package com.xiaomi.passport.snscorelib.internal.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class SNSBindParameter implements Parcelable {
    public static final Parcelable.Creator<SNSBindParameter> CREATOR = new Parcelable.Creator<SNSBindParameter>() {
        /* class com.xiaomi.passport.snscorelib.internal.entity.SNSBindParameter.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SNSBindParameter[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SNSBindParameter(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f6205O000000o;
    public final String O00000Oo;
    public final String O00000o;
    public final String O00000o0;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ SNSBindParameter(Parcel parcel, byte b) {
        this(parcel);
    }

    /* synthetic */ SNSBindParameter(O000000o o000000o, byte b) {
        this(o000000o);
    }

    private SNSBindParameter(O000000o o000000o) {
        this.f6205O000000o = o000000o.f6206O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6205O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
    }

    private SNSBindParameter(Parcel parcel) {
        this.f6205O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f6206O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;

        public final SNSBindParameter O000000o() {
            return new SNSBindParameter(this, (byte) 0);
        }
    }
}

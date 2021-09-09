package com.xiaomi.smarthome.core.entity;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;

public class Error implements Parcelable {
    public static final Parcelable.Creator<Error> CREATOR = new Parcelable.Creator<Error>() {
        /* class com.xiaomi.smarthome.core.entity.Error.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Error[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Error(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f6718O000000o;
    public String O00000Oo;
    public String O00000o0;

    public int describeContents() {
        return 0;
    }

    public Error(int i, String str, String str2) {
        this.f6718O000000o = i;
        this.O00000Oo = str;
        this.O00000o0 = str2;
    }

    public Error(int i, String str) {
        this.f6718O000000o = i;
        this.O00000Oo = str;
    }

    public final int O000000o() {
        return this.f6718O000000o;
    }

    public final String O00000Oo() {
        return this.O00000Oo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6718O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
    }

    protected Error(Parcel parcel) {
        this.f6718O000000o = parcel.readInt();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
    }

    public String toString() {
        return "Error{mCode=" + this.f6718O000000o + ", mDetail='" + this.O00000Oo + '\'' + ", mExtraMsg='" + this.O00000o0 + '\'' + '}';
    }

    public String O000000o(Context context) {
        int i = this.f6718O000000o;
        switch (i) {
            case -99:
                return context.getString(R.string.code_infonull_error);
            case -98:
                return context.getString(R.string.code_modelnull_error);
            case -97:
                return context.getString(R.string.code_streammuch_error);
            default:
                switch (i) {
                    case -6:
                        return context.getString(R.string.code_cancel_error);
                    case -5:
                        return context.getString(R.string.code_whitelist_error);
                    case -4:
                        return context.getString(R.string.code_offline_error);
                    case -3:
                        return context.getString(R.string.code_permissiondeny_error);
                    case -2:
                        return context.getString(R.string.code_serviceregister_error);
                    case -1:
                        return context.getString(R.string.code_unknown_error);
                    default:
                        return context.getString(R.string.code_default_error);
                }
        }
    }
}

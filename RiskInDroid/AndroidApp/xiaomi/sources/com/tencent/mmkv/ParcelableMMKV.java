package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;

public final class ParcelableMMKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new Parcelable.Creator<ParcelableMMKV>() {
        /* class com.tencent.mmkv.ParcelableMMKV.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ParcelableMMKV[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            String readString2 = parcel.readString();
            if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                return null;
            }
            return new ParcelableMMKV(readString, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), readString2, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    String f5864O000000o;
    int O00000Oo;
    String O00000o;
    int O00000o0;

    public final int describeContents() {
        return 1;
    }

    /* synthetic */ ParcelableMMKV(String str, int i, int i2, String str2, byte b) {
        this(str, i, i2, str2);
    }

    public ParcelableMMKV(MMKV mmkv) {
        this.O00000Oo = -1;
        this.O00000o0 = -1;
        this.O00000o = null;
        this.f5864O000000o = mmkv.mmapID();
        this.O00000Oo = mmkv.ashmemFD();
        this.O00000o0 = mmkv.ashmemMetaFD();
        this.O00000o = mmkv.cryptKey();
    }

    private ParcelableMMKV(String str, int i, int i2, String str2) {
        this.O00000Oo = -1;
        this.O00000o0 = -1;
        this.O00000o = null;
        this.f5864O000000o = str;
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeString(this.f5864O000000o);
            ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.O00000Oo);
            ParcelFileDescriptor fromFd2 = ParcelFileDescriptor.fromFd(this.O00000o0);
            int i2 = i | 1;
            fromFd.writeToParcel(parcel, i2);
            fromFd2.writeToParcel(parcel, i2);
            if (this.O00000o != null) {
                parcel.writeString(this.O00000o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

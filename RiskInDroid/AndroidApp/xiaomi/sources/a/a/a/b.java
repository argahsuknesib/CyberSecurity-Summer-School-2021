package a.a.a;

import android.os.Parcel;
import android.os.Parcelable;

public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f2610O000000o;
    public final String O00000Oo;
    public final boolean O00000o;
    public final boolean O00000o0;

    public b(Parcel parcel) {
        this.f2610O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        boolean z = true;
        this.O00000o0 = parcel.readByte() != 0;
        this.O00000o = parcel.readByte() == 0 ? false : z;
    }

    public b(String str, Object obj, boolean z) {
        this(str, String.valueOf(obj), z, false);
    }

    public b(String str, Object obj, boolean z, boolean z2) {
        this.f2610O000000o = str;
        this.O00000Oo = String.valueOf(obj);
        this.O00000o0 = z;
        this.O00000o = z2;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.O00000Oo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2610O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeByte(this.O00000o0 ? (byte) 1 : 0);
        parcel.writeByte(this.O00000o ? (byte) 1 : 0);
    }

    public class O000000o implements Parcelable.Creator<b> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new b[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new b(parcel);
        }
    }
}

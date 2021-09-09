package cn.com.xm.bt.profile.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* class cn.com.xm.bt.profile.nfc.a.AnonymousClass1 */

        /* renamed from: a */
        public final a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: a */
        public final a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3108a;
    private int b;
    private boolean c;

    public int describeContents() {
        return 0;
    }

    public a(byte[] bArr, int i, boolean z) {
        this.f3108a = bArr;
        this.b = i;
        this.c = z;
    }

    private a(Parcel parcel) {
        this.f3108a = parcel.createByteArray();
        this.b = parcel.readInt();
        this.c = parcel.readByte() != 0;
    }

    public byte[] a() {
        return this.f3108a;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public String toString() {
        return "ApduRequest{data=" + Arrays.toString(this.f3108a) + ", dataLen=" + this.b + ", encrypt=" + this.c + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.f3108a);
        parcel.writeInt(this.b);
        parcel.writeByte(this.c ? (byte) 1 : 0);
    }
}

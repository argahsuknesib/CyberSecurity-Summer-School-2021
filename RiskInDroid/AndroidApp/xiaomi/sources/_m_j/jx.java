package _m_j;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.versionedparcelable.VersionedParcel;
import java.lang.reflect.Method;

public final class jx extends VersionedParcel {
    private final SparseIntArray O00000o;
    private final Parcel O00000oO;
    private final int O00000oo;
    private final int O0000O0o;
    private final String O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;

    public jx(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new o0O0OOO0(), new o0O0OOO0(), new o0O0OOO0());
    }

    private jx(Parcel parcel, int i, int i2, String str, o0O0OOO0<String, Method> o0o0ooo0, o0O0OOO0<String, Method> o0o0ooo02, o0O0OOO0<String, Class> o0o0ooo03) {
        super(o0o0ooo0, o0o0ooo02, o0o0ooo03);
        this.O00000o = new SparseIntArray();
        this.O0000Oo0 = -1;
        this.O0000Oo = 0;
        this.O0000OoO = -1;
        this.O00000oO = parcel;
        this.O00000oo = i;
        this.O0000O0o = i2;
        this.O0000Oo = this.O00000oo;
        this.O0000OOo = str;
    }

    public final boolean O00000Oo(int i) {
        while (this.O0000Oo < this.O0000O0o) {
            int i2 = this.O0000OoO;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.O00000oO.setDataPosition(this.O0000Oo);
            int readInt = this.O00000oO.readInt();
            this.O0000OoO = this.O00000oO.readInt();
            this.O0000Oo += readInt;
        }
        return this.O0000OoO == i;
    }

    public final void O00000o0(int i) {
        O000000o();
        this.O0000Oo0 = i;
        this.O00000o.put(i, this.O00000oO.dataPosition());
        O000000o(0);
        O000000o(i);
    }

    public final void O000000o() {
        int i = this.O0000Oo0;
        if (i >= 0) {
            int i2 = this.O00000o.get(i);
            int dataPosition = this.O00000oO.dataPosition();
            this.O00000oO.setDataPosition(i2);
            this.O00000oO.writeInt(dataPosition - i2);
            this.O00000oO.setDataPosition(dataPosition);
        }
    }

    public final VersionedParcel O00000Oo() {
        Parcel parcel = this.O00000oO;
        int dataPosition = parcel.dataPosition();
        int i = this.O0000Oo;
        if (i == this.O00000oo) {
            i = this.O0000O0o;
        }
        int i2 = i;
        return new jx(parcel, dataPosition, i2, this.O0000OOo + "  ", this.f3026O000000o, this.O00000Oo, this.O00000o0);
    }

    public final void O000000o(byte[] bArr) {
        if (bArr != null) {
            this.O00000oO.writeInt(bArr.length);
            this.O00000oO.writeByteArray(bArr);
            return;
        }
        this.O00000oO.writeInt(-1);
    }

    public final void O000000o(int i) {
        this.O00000oO.writeInt(i);
    }

    public final void O000000o(String str) {
        this.O00000oO.writeString(str);
    }

    public final void O000000o(Parcelable parcelable) {
        this.O00000oO.writeParcelable(parcelable, 0);
    }

    public final void O000000o(boolean z) {
        this.O00000oO.writeInt(z ? 1 : 0);
    }

    public final void O000000o(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.O00000oO, 0);
    }

    public final CharSequence O00000oo() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.O00000oO);
    }

    public final int O00000o0() {
        return this.O00000oO.readInt();
    }

    public final String O00000o() {
        return this.O00000oO.readString();
    }

    public final byte[] O00000oO() {
        int readInt = this.O00000oO.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.O00000oO.readByteArray(bArr);
        return bArr;
    }

    public final <T extends Parcelable> T O0000O0o() {
        return this.O00000oO.readParcelable(getClass().getClassLoader());
    }

    public final boolean O0000OOo() {
        return this.O00000oO.readInt() != 0;
    }
}

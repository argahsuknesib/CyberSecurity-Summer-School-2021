package no.nordicsemi.android.support.v18.scanner;

import android.os.Parcel;
import android.os.Parcelable;

public final class ScanSettings implements Parcelable {
    public static final Parcelable.Creator<ScanSettings> CREATOR = new Parcelable.Creator<ScanSettings>() {
        /* class no.nordicsemi.android.support.v18.scanner.ScanSettings.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ScanSettings[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ScanSettings(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final long f15417O000000o;
    public final long O00000Oo;
    public int O00000o;
    public int O00000o0;
    public long O00000oO;
    public int O00000oo;
    public int O0000O0o;
    public boolean O0000OOo;
    public boolean O0000Oo;
    public boolean O0000Oo0;
    public long O0000OoO;
    public long O0000Ooo;
    public int O0000o0;
    public boolean O0000o00;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ ScanSettings(int i, int i2, long j, int i3, int i4, boolean z, int i5, boolean z2, boolean z3, boolean z4, long j2, long j3, long j4, long j5, byte b) {
        this(i, i2, j, i3, i4, z, i5, z2, z3, z4, j2, j3, j4, j5);
    }

    /* synthetic */ ScanSettings(Parcel parcel, byte b) {
        this(parcel);
    }

    private ScanSettings(int i, int i2, long j, int i3, int i4, boolean z, int i5, boolean z2, boolean z3, boolean z4, long j2, long j3, long j4, long j5) {
        this.O00000o0 = i;
        this.O00000o = i2;
        this.O00000oO = j;
        this.O0000O0o = i4;
        this.O00000oo = i3;
        this.O0000o00 = z;
        this.O0000o0 = i5;
        this.O0000OOo = z2;
        this.O0000Oo0 = z3;
        this.O0000Oo = z4;
        this.O0000OoO = 1000000 * j2;
        this.O0000Ooo = j3;
        this.f15417O000000o = j4;
        this.O00000Oo = j5;
    }

    private ScanSettings(Parcel parcel) {
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readLong();
        this.O00000oo = parcel.readInt();
        this.O0000O0o = parcel.readInt();
        boolean z = false;
        this.O0000o00 = parcel.readInt() != 0;
        this.O0000o0 = parcel.readInt();
        this.O0000OOo = parcel.readInt() == 1;
        this.O0000Oo0 = parcel.readInt() == 1 ? true : z;
        this.f15417O000000o = parcel.readLong();
        this.O00000Oo = parcel.readLong();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeLong(this.O00000oO);
        parcel.writeInt(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O0000o00 ? 1 : 0);
        parcel.writeInt(this.O0000o0);
        parcel.writeInt(this.O0000OOo ? 1 : 0);
        parcel.writeInt(this.O0000Oo0 ? 1 : 0);
        parcel.writeLong(this.f15417O000000o);
        parcel.writeLong(this.O00000Oo);
    }

    public final boolean O000000o() {
        return this.O00000Oo > 0 && this.f15417O000000o > 0;
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f15418O000000o = 1;
        long O00000Oo = 0;
        int O00000o = 3;
        int O00000o0 = 1;
        boolean O00000oO = true;
        int O00000oo = 255;
        boolean O0000O0o = true;
        public boolean O0000OOo = true;
        long O0000Oo = 10000;
        boolean O0000Oo0 = true;
        long O0000OoO = 10000;
        private int O0000Ooo = 0;
        private long O0000o0 = 0;
        private long O0000o00 = 0;

        public final O000000o O000000o(int i) {
            if (i < -1 || i > 2) {
                throw new IllegalArgumentException("invalid scan mode ".concat(String.valueOf(i)));
            }
            this.O0000Ooo = i;
            return this;
        }

        public final ScanSettings O000000o() {
            if (this.O0000o00 == 0 && this.O0000o0 == 0) {
                O00000Oo();
            }
            return new ScanSettings(this.O0000Ooo, this.f15418O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o, this.O0000OOo, this.O0000Oo0, this.O0000Oo, this.O0000OoO, this.O0000o0, this.O0000o00, (byte) 0);
        }

        private void O00000Oo() {
            int i = this.O0000Ooo;
            if (i == 1) {
                this.O0000o0 = 2000;
                this.O0000o00 = 3000;
            } else if (i != 2) {
                this.O0000o0 = 500;
                this.O0000o00 = 4500;
            } else {
                this.O0000o0 = 0;
                this.O0000o00 = 0;
            }
        }
    }
}

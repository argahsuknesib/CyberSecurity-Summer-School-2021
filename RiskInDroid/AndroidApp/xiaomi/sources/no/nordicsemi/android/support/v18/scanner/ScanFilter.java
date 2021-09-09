package no.nordicsemi.android.support.v18.scanner;

import _m_j.jar;
import _m_j.jau;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public final class ScanFilter implements Parcelable {
    public static final Parcelable.Creator<ScanFilter> CREATOR = new Parcelable.Creator<ScanFilter>() {
        /* class no.nordicsemi.android.support.v18.scanner.ScanFilter.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ScanFilter[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            O000000o o000000o = new O000000o();
            if (parcel.readInt() == 1) {
                o000000o.f15415O000000o = parcel.readString();
            }
            if (parcel.readInt() == 1) {
                o000000o.O000000o(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                o000000o.O00000Oo = parcelUuid;
                o000000o.O00000o0 = null;
                if (parcel.readInt() == 1) {
                    o000000o.O000000o(parcelUuid, (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                if (parcel.readInt() == 1) {
                    byte[] bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    if (parcel.readInt() != 0) {
                        byte[] bArr2 = new byte[parcel.readInt()];
                        parcel.readByteArray(bArr2);
                        o000000o.O000000o(parcelUuid2, bArr, bArr2);
                    } else if (parcelUuid2 != null) {
                        o000000o.O00000o = parcelUuid2;
                        o000000o.O00000oO = bArr;
                        o000000o.O00000oo = null;
                    } else {
                        throw new IllegalArgumentException("serviceDataUuid is null!");
                    }
                }
            }
            int readInt = parcel.readInt();
            if (parcel.readInt() == 1) {
                byte[] bArr3 = new byte[parcel.readInt()];
                parcel.readByteArray(bArr3);
                if (parcel.readInt() != 0) {
                    byte[] bArr4 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr4);
                    o000000o.O000000o(readInt, bArr3, bArr4);
                } else if (readInt >= 0) {
                    o000000o.O0000O0o = readInt;
                    o000000o.O0000OOo = bArr3;
                    o000000o.O0000Oo0 = null;
                } else {
                    throw new IllegalArgumentException("invalid manufacture id");
                }
            }
            return o000000o.O000000o();
        }
    };
    private static final ScanFilter O0000OoO = new O000000o().O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f15414O000000o;
    public final String O00000Oo;
    public final ParcelUuid O00000o;
    public final ParcelUuid O00000o0;
    public final ParcelUuid O00000oO;
    public final byte[] O00000oo;
    public final byte[] O0000O0o;
    public final int O0000OOo;
    public final byte[] O0000Oo;
    public final byte[] O0000Oo0;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ ScanFilter(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte b) {
        this(str, str2, parcelUuid, parcelUuid2, parcelUuid3, bArr, bArr2, i, bArr3, bArr4);
    }

    private ScanFilter(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        this.f15414O000000o = str;
        this.O00000o0 = parcelUuid;
        this.O00000o = parcelUuid2;
        this.O00000Oo = str2;
        this.O00000oO = parcelUuid3;
        this.O00000oo = bArr;
        this.O0000O0o = bArr2;
        this.O0000OOo = i;
        this.O0000Oo0 = bArr3;
        this.O0000Oo = bArr4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeInt(this.f15414O000000o == null ? 0 : 1);
        String str = this.f15414O000000o;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.O00000Oo == null ? 0 : 1);
        String str2 = this.O00000Oo;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        parcel.writeInt(this.O00000o0 == null ? 0 : 1);
        ParcelUuid parcelUuid = this.O00000o0;
        if (parcelUuid != null) {
            parcel.writeParcelable(parcelUuid, i);
            parcel.writeInt(this.O00000o == null ? 0 : 1);
            ParcelUuid parcelUuid2 = this.O00000o;
            if (parcelUuid2 != null) {
                parcel.writeParcelable(parcelUuid2, i);
            }
        }
        parcel.writeInt(this.O00000oO == null ? 0 : 1);
        ParcelUuid parcelUuid3 = this.O00000oO;
        if (parcelUuid3 != null) {
            parcel.writeParcelable(parcelUuid3, i);
            parcel.writeInt(this.O00000oo == null ? 0 : 1);
            byte[] bArr = this.O00000oo;
            if (bArr != null) {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(this.O00000oo);
                parcel.writeInt(this.O0000O0o == null ? 0 : 1);
                byte[] bArr2 = this.O0000O0o;
                if (bArr2 != null) {
                    parcel.writeInt(bArr2.length);
                    parcel.writeByteArray(this.O0000O0o);
                }
            }
        }
        parcel.writeInt(this.O0000OOo);
        parcel.writeInt(this.O0000Oo0 == null ? 0 : 1);
        byte[] bArr3 = this.O0000Oo0;
        if (bArr3 != null) {
            parcel.writeInt(bArr3.length);
            parcel.writeByteArray(this.O0000Oo0);
            if (this.O0000Oo != null) {
                i2 = 1;
            }
            parcel.writeInt(i2);
            byte[] bArr4 = this.O0000Oo;
            if (bArr4 != null) {
                parcel.writeInt(bArr4.length);
                parcel.writeByteArray(this.O0000Oo);
            }
        }
    }

    private static boolean O000000o(ParcelUuid parcelUuid, ParcelUuid parcelUuid2, List<ParcelUuid> list) {
        UUID uuid;
        if (parcelUuid == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        for (ParcelUuid next : list) {
            if (parcelUuid2 == null) {
                uuid = null;
            } else {
                uuid = parcelUuid2.getUuid();
            }
            if (O000000o(parcelUuid.getUuid(), uuid, next.getUuid())) {
                return true;
            }
        }
        return false;
    }

    private static boolean O000000o(UUID uuid, UUID uuid2, UUID uuid3) {
        if (uuid2 == null) {
            return uuid.equals(uuid3);
        }
        if ((uuid.getLeastSignificantBits() & uuid2.getLeastSignificantBits()) != (uuid3.getLeastSignificantBits() & uuid2.getLeastSignificantBits())) {
            return false;
        }
        if ((uuid.getMostSignificantBits() & uuid2.getMostSignificantBits()) == (uuid2.getMostSignificantBits() & uuid3.getMostSignificantBits())) {
            return true;
        }
        return false;
    }

    private static boolean O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            return bArr3 != null;
        }
        if (bArr3 == null || bArr3.length < bArr.length) {
            return false;
        }
        if (bArr2 == null) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr3[i] != bArr[i]) {
                    return false;
                }
            }
            return true;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if ((bArr2[i2] & bArr3[i2]) != (bArr2[i2] & bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        return "BluetoothLeScanFilter [deviceName=" + this.f15414O000000o + ", deviceAddress=" + this.O00000Oo + ", mUuid=" + this.O00000o0 + ", uuidMask=" + this.O00000o + ", serviceDataUuid=" + jar.O000000o(this.O00000oO) + ", serviceData=" + Arrays.toString(this.O00000oo) + ", serviceDataMask=" + Arrays.toString(this.O0000O0o) + ", manufacturerId=" + this.O0000OOo + ", manufacturerData=" + Arrays.toString(this.O0000Oo0) + ", manufacturerDataMask=" + Arrays.toString(this.O0000Oo) + "]";
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f15414O000000o, this.O00000Oo, Integer.valueOf(this.O0000OOo), Integer.valueOf(Arrays.hashCode(this.O0000Oo0)), Integer.valueOf(Arrays.hashCode(this.O0000Oo)), this.O00000oO, Integer.valueOf(Arrays.hashCode(this.O00000oo)), Integer.valueOf(Arrays.hashCode(this.O0000O0o)), this.O00000o0, this.O00000o});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ScanFilter scanFilter = (ScanFilter) obj;
            return jar.O00000Oo(this.f15414O000000o, scanFilter.f15414O000000o) && jar.O00000Oo(this.O00000Oo, scanFilter.O00000Oo) && this.O0000OOo == scanFilter.O0000OOo && jar.O000000o(this.O0000Oo0, scanFilter.O0000Oo0) && jar.O000000o(this.O0000Oo, scanFilter.O0000Oo) && jar.O00000Oo(this.O00000oO, scanFilter.O00000oO) && jar.O000000o(this.O00000oo, scanFilter.O00000oo) && jar.O000000o(this.O0000O0o, scanFilter.O0000O0o) && jar.O00000Oo(this.O00000o0, scanFilter.O00000o0) && jar.O00000Oo(this.O00000o, scanFilter.O00000o);
        }
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f15415O000000o;
        ParcelUuid O00000Oo;
        ParcelUuid O00000o;
        ParcelUuid O00000o0;
        byte[] O00000oO;
        byte[] O00000oo;
        int O0000O0o = -1;
        byte[] O0000OOo;
        private String O0000Oo;
        byte[] O0000Oo0;

        public final O000000o O000000o(String str) {
            if (str == null || BluetoothAdapter.checkBluetoothAddress(str)) {
                this.O0000Oo = str;
                return this;
            }
            throw new IllegalArgumentException("invalid device address ".concat(String.valueOf(str)));
        }

        public final O000000o O000000o(ParcelUuid parcelUuid, ParcelUuid parcelUuid2) {
            if (parcelUuid2 == null || parcelUuid != null) {
                this.O00000Oo = parcelUuid;
                this.O00000o0 = parcelUuid2;
                return this;
            }
            throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
        }

        public final O000000o O000000o(ParcelUuid parcelUuid, byte[] bArr, byte[] bArr2) {
            if (parcelUuid != null || bArr == null) {
                if (bArr2 != null) {
                    if (bArr == null) {
                        throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                    } else if (bArr.length != bArr2.length) {
                        throw new IllegalArgumentException("size mismatch for service data and service data mask");
                    }
                }
                this.O00000o = parcelUuid;
                this.O00000oO = bArr;
                this.O00000oo = bArr2;
                return this;
            }
            throw new IllegalArgumentException("serviceDataUuid is null");
        }

        public final O000000o O000000o(int i, byte[] bArr, byte[] bArr2) {
            if (bArr == null || i >= 0) {
                if (bArr2 != null) {
                    if (bArr == null) {
                        throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                    } else if (bArr.length != bArr2.length) {
                        throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                    }
                }
                this.O0000O0o = i;
                this.O0000OOo = bArr;
                this.O0000Oo0 = bArr2;
                return this;
            }
            throw new IllegalArgumentException("invalid manufacture id");
        }

        public final ScanFilter O000000o() {
            return new ScanFilter(this.f15415O000000o, this.O0000Oo, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o, this.O0000OOo, this.O0000Oo0, (byte) 0);
        }
    }

    public final boolean O000000o(ScanResult scanResult) {
        if (scanResult == null) {
            return false;
        }
        BluetoothDevice bluetoothDevice = scanResult.f15416O000000o;
        String str = this.O00000Oo;
        if (str != null && !str.equals(bluetoothDevice.getAddress())) {
            return false;
        }
        jau jau = scanResult.O00000Oo;
        if (jau == null && (this.f15414O000000o != null || this.O00000o0 != null || this.O0000Oo0 != null || this.O00000oo != null)) {
            return false;
        }
        String str2 = this.f15414O000000o;
        if (str2 != null && !str2.equals(jau.O00000Oo)) {
            return false;
        }
        ParcelUuid parcelUuid = this.O00000o0;
        if (parcelUuid != null && !O000000o(parcelUuid, this.O00000o, jau.f1714O000000o)) {
            return false;
        }
        ParcelUuid parcelUuid2 = this.O00000oO;
        if (parcelUuid2 != null && jau != null && !O000000o(this.O00000oo, this.O0000O0o, jau.O000000o(parcelUuid2))) {
            return false;
        }
        int i = this.O0000OOo;
        if (i < 0 || jau == null || O000000o(this.O0000Oo0, this.O0000Oo, jau.O000000o(i))) {
            return true;
        }
        return false;
    }
}

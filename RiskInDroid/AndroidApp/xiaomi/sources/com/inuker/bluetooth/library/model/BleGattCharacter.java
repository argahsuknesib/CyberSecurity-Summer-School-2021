package com.inuker.bluetooth.library.model;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

public class BleGattCharacter implements Parcelable {
    public static final Parcelable.Creator<BleGattCharacter> CREATOR = new Parcelable.Creator<BleGattCharacter>() {
        /* class com.inuker.bluetooth.library.model.BleGattCharacter.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BleGattCharacter[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BleGattCharacter(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private UUID f4489O000000o;
    private int O00000Oo;
    private int O00000o0;

    public int describeContents() {
        return 0;
    }

    protected BleGattCharacter(Parcel parcel) {
        this.f4489O000000o = (UUID) parcel.readSerializable();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readInt();
    }

    public BleGattCharacter(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f4489O000000o = bluetoothGattCharacteristic.getUuid();
        this.O00000Oo = bluetoothGattCharacteristic.getProperties();
        this.O00000o0 = bluetoothGattCharacteristic.getPermissions();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f4489O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
    }

    public String toString() {
        return "BleGattCharacter{uuid=" + this.f4489O000000o + ", property=" + this.O00000Oo + ", permissions=" + this.O00000o0 + '}';
    }
}

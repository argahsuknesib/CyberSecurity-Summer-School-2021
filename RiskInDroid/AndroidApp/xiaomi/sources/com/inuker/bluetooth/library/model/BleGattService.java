package com.inuker.bluetooth.library.model;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BleGattService implements Parcelable, Comparable {
    public static final Parcelable.Creator<BleGattService> CREATOR = new Parcelable.Creator<BleGattService>() {
        /* class com.inuker.bluetooth.library.model.BleGattService.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BleGattService[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BleGattService(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private UUID f4491O000000o;
    private List<BleGattCharacter> O00000Oo;

    public int describeContents() {
        return 0;
    }

    public BleGattService(UUID uuid, Map<UUID, BluetoothGattCharacteristic> map) {
        this.f4491O000000o = uuid;
        for (BluetoothGattCharacteristic bleGattCharacter : map.values()) {
            O000000o().add(new BleGattCharacter(bleGattCharacter));
        }
    }

    protected BleGattService(Parcel parcel) {
        this.f4491O000000o = (UUID) parcel.readSerializable();
        parcel.readTypedList(O000000o(), BleGattCharacter.CREATOR);
    }

    private List<BleGattCharacter> O000000o() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new ArrayList();
        }
        return this.O00000Oo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f4491O000000o);
        parcel.writeTypedList(O000000o());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Service: %s\n", this.f4491O000000o));
        List<BleGattCharacter> O000000o2 = O000000o();
        int size = O000000o2.size();
        for (int i = 0; i < size; i++) {
            sb.append(String.format(">>> Character: %s", O000000o2.get(i)));
            if (i != size - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        }
        return this.f4491O000000o.compareTo(((BleGattService) obj).f4491O000000o);
    }
}

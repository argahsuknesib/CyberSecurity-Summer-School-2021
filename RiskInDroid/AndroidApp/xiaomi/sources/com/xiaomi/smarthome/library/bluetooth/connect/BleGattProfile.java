package com.xiaomi.smarthome.library.bluetooth.connect;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BleGattProfile implements Parcelable {
    public static final Parcelable.Creator<BleGattProfile> CREATOR = new Parcelable.Creator<BleGattProfile>() {
        /* class com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BleGattProfile[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BleGattProfile(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private List<BleGattService> f9074O000000o = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public BleGattProfile(Map<UUID, Map<UUID, BluetoothGattCharacteristic>> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            Map map2 = (Map) next.getValue();
            BleGattService bleGattService = new BleGattService((UUID) next.getKey());
            if (!arrayList.contains(bleGattService)) {
                arrayList.add(bleGattService);
                bleGattService.O000000o(map2.keySet());
            }
        }
        Collections.sort(arrayList);
        O000000o().addAll(arrayList);
    }

    public BleGattProfile(Parcel parcel) {
        parcel.readTypedList(O000000o(), BleGattService.CREATOR);
    }

    public final List<BleGattService> O000000o() {
        if (this.f9074O000000o == null) {
            this.f9074O000000o = new ArrayList();
        }
        return this.f9074O000000o;
    }

    public final BleGattService O000000o(UUID uuid) {
        for (BleGattService next : O000000o()) {
            if (next.f9075O000000o.equals(uuid)) {
                return next;
            }
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(O000000o());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BleGattService append : O000000o()) {
            sb.append(append);
            sb.append("\n");
        }
        return sb.toString();
    }
}

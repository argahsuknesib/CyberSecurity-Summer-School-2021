package com.inuker.bluetooth.library.model;

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
        /* class com.inuker.bluetooth.library.model.BleGattProfile.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BleGattProfile[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BleGattProfile(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private List<BleGattService> f4490O000000o;

    public int describeContents() {
        return 0;
    }

    public BleGattProfile(Map<UUID, Map<UUID, BluetoothGattCharacteristic>> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            BleGattService bleGattService = new BleGattService((UUID) next.getKey(), (Map) next.getValue());
            if (!arrayList.contains(bleGattService)) {
                arrayList.add(bleGattService);
            }
        }
        Collections.sort(arrayList);
        O000000o().addAll(arrayList);
    }

    public BleGattProfile(Parcel parcel) {
        parcel.readTypedList(O000000o(), BleGattService.CREATOR);
    }

    private List<BleGattService> O000000o() {
        if (this.f4490O000000o == null) {
            this.f4490O000000o = new ArrayList();
        }
        return this.f4490O000000o;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(O000000o());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BleGattService append : this.f4490O000000o) {
            sb.append(append);
            sb.append("\n");
        }
        return sb.toString();
    }
}

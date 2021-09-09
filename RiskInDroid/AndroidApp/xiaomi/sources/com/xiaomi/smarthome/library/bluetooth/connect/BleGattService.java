package com.xiaomi.smarthome.library.bluetooth.connect;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class BleGattService implements Parcelable, Comparable {
    public static final Parcelable.Creator<BleGattService> CREATOR = new Parcelable.Creator<BleGattService>() {
        /* class com.xiaomi.smarthome.library.bluetooth.connect.BleGattService.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BleGattService[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BleGattService(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public UUID f9075O000000o;
    private List<ParcelUuid> O00000Oo;

    public int describeContents() {
        return 0;
    }

    public BleGattService(UUID uuid) {
        this.f9075O000000o = uuid;
        this.O00000Oo = new ArrayList();
    }

    public final void O000000o(Set<UUID> set) {
        for (UUID parcelUuid : set) {
            O000000o().add(new ParcelUuid(parcelUuid));
        }
    }

    protected BleGattService(Parcel parcel) {
        this.f9075O000000o = (UUID) parcel.readSerializable();
        parcel.readTypedList(O000000o(), ParcelUuid.CREATOR);
    }

    public final List<ParcelUuid> O000000o() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new ArrayList();
        }
        return this.O00000Oo;
    }

    public final boolean O000000o(UUID uuid) {
        for (ParcelUuid uuid2 : O000000o()) {
            if (uuid2.getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f9075O000000o);
        parcel.writeTypedList(O000000o());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Service: %s\n", this.f9075O000000o));
        List<ParcelUuid> O000000o2 = O000000o();
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
        return this.f9075O000000o.compareTo(((BleGattService) obj).f9075O000000o);
    }
}

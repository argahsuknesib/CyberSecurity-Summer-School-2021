package com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo;

import _m_j.fte;
import _m_j.gnk;
import _m_j.got;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BleComboWifiConfig implements Parcelable {
    public static final Parcelable.Creator<BleComboWifiConfig> CREATOR = new Parcelable.Creator<BleComboWifiConfig>() {
        /* class com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BleComboWifiConfig[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BleComboWifiConfig(parcel);
        }
    };
    private static final String O0000o0 = "com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig";

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6885O000000o = "";
    public String O00000Oo = "";
    public int O00000o;
    public String O00000o0 = "";
    public String O00000oO = "";
    public String O00000oo = "";
    public String O0000O0o = "";
    public String O0000OOo = "";
    public String O0000Oo = "";
    public String O0000Oo0 = "";
    public String O0000OoO = "";
    public String O0000Ooo = "";
    public long O0000o00;

    public int describeContents() {
        return 0;
    }

    public BleComboWifiConfig() {
    }

    public BleComboWifiConfig(Parcel parcel) {
        this.f6885O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readString();
        this.O0000Ooo = parcel.readString();
        this.O0000o00 = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6885O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeString(this.O0000OoO);
        parcel.writeString(this.O0000Ooo);
        parcel.writeLong(this.O0000o00);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x004b  */
    public final byte[] O000000o() {
        long j;
        ByteBuffer order = ByteBuffer.allocate(1024).order(ByteOrder.LITTLE_ENDIAN);
        fte.O00000Oo(String.format(O0000o0 + " sendUserId = %s", this.f6885O000000o));
        order.put((byte) 0);
        if (!TextUtils.isEmpty(this.f6885O000000o)) {
            try {
                j = Long.parseLong(this.f6885O000000o);
            } catch (Throwable th) {
                gnk.O000000o(th);
            }
            if (j < 0) {
                j = 0;
            }
            byte[] O000000o2 = got.O000000o(j);
            order.put((byte) 8);
            order.put(O000000o2);
            order.put((byte) 1);
            if (!TextUtils.isEmpty(this.O00000Oo)) {
                order.put((byte) 0);
            } else {
                order.put((byte) this.O00000Oo.getBytes().length);
                order.put(this.O00000Oo.getBytes());
            }
            order.put((byte) 2);
            if (!TextUtils.isEmpty(this.O00000o0)) {
                order.put((byte) 0);
            } else {
                order.put((byte) this.O00000o0.getBytes().length);
                order.put(this.O00000o0.getBytes());
            }
            fte.O00000Oo(String.format(O0000o0 + " gmt_offset = %d", Integer.valueOf(this.O00000o)));
            order.put((byte) 5);
            order.put((byte) 4);
            order.put(got.O000000o(this.O00000o));
            fte.O00000Oo(String.format(O0000o0 + " country_domain = %s", this.O00000oO));
            order.put((byte) 6);
            order.put((byte) 3);
            byte[] bArr = {0, 0, 0};
            if (!TextUtils.isEmpty(this.O00000oO)) {
                got.O000000o(bArr, this.O00000oO.getBytes(), 0, 0);
            }
            order.put(bArr);
            fte.O00000Oo(String.format(O0000o0 + " timezone = %s", this.O00000oo));
            order.put((byte) 7);
            if (!TextUtils.isEmpty(this.O00000oo)) {
                order.put((byte) 0);
            } else {
                order.put((byte) this.O00000oo.getBytes().length);
                order.put(this.O00000oo.getBytes());
            }
            fte.O00000Oo(String.format(O0000o0 + " config_type = %s", this.O0000O0o));
            order.put((byte) 8);
            if (!TextUtils.isEmpty(this.O0000O0o)) {
                order.put((byte) 0);
            } else {
                order.put((byte) this.O0000O0o.getBytes().length);
                order.put(this.O0000O0o.getBytes());
            }
            fte.O00000Oo(String.format(O0000o0 + " bind_key = %s", this.O0000OOo));
            order.put((byte) 9);
            if (!TextUtils.isEmpty(this.O0000OOo)) {
                order.put((byte) 0);
            } else {
                order.put((byte) this.O0000OOo.getBytes().length);
                order.put(this.O0000OOo.getBytes());
            }
            fte.O00000Oo(String.format(O0000o0 + " country_code = %s", this.O0000Oo0));
            order.put((byte) 10);
            if (!TextUtils.isEmpty(this.O0000Oo0)) {
                order.put((byte) 0);
            } else {
                order.put((byte) this.O0000Oo0.getBytes().length);
                order.put(this.O0000Oo0.getBytes());
            }
            fte.O00000Oo(String.format(O0000o0 + " passportUrl = %s", this.O0000Oo));
            if (!TextUtils.isEmpty(this.O0000Oo)) {
                order.put((byte) 11);
                order.put((byte) this.O0000Oo.getBytes().length);
                order.put(this.O0000Oo.getBytes());
            }
            fte.O00000Oo(String.format(O0000o0 + " ble token = %s", this.O0000OoO));
            if (!TextUtils.isEmpty(this.O0000OoO)) {
                order.put((byte) 12);
                byte[] O000000o3 = got.O000000o(this.O0000OoO);
                order.put((byte) O000000o3.length);
                order.put(O000000o3);
            }
            fte.O00000Oo(String.format(O0000o0 + " bindIndex = %s", this.O0000Ooo));
            if (!TextUtils.isEmpty(this.O0000Ooo)) {
                order.put((byte) 13);
                byte[] bytes = this.O0000Ooo.getBytes();
                order.put((byte) bytes.length);
                order.put(bytes);
            }
            fte.O00000Oo(String.format(O0000o0 + " bindTimestamp = %s", Long.valueOf(this.O0000o00)));
            if (this.O0000o00 > 0) {
                order.put((byte) 14);
                byte[] O000000o4 = got.O000000o(this.O0000o00);
                order.put((byte) 8);
                order.put(O000000o4);
            }
            byte[] bArr2 = new byte[order.position()];
            System.arraycopy(order.array(), 0, bArr2, 0, bArr2.length);
            return bArr2;
        }
        j = 0;
        if (j < 0) {
        }
        byte[] O000000o22 = got.O000000o(j);
        order.put((byte) 8);
        order.put(O000000o22);
        order.put((byte) 1);
        if (!TextUtils.isEmpty(this.O00000Oo)) {
        }
        order.put((byte) 2);
        if (!TextUtils.isEmpty(this.O00000o0)) {
        }
        fte.O00000Oo(String.format(O0000o0 + " gmt_offset = %d", Integer.valueOf(this.O00000o)));
        order.put((byte) 5);
        order.put((byte) 4);
        order.put(got.O000000o(this.O00000o));
        fte.O00000Oo(String.format(O0000o0 + " country_domain = %s", this.O00000oO));
        order.put((byte) 6);
        order.put((byte) 3);
        byte[] bArr3 = {0, 0, 0};
        if (!TextUtils.isEmpty(this.O00000oO)) {
        }
        order.put(bArr3);
        fte.O00000Oo(String.format(O0000o0 + " timezone = %s", this.O00000oo));
        order.put((byte) 7);
        if (!TextUtils.isEmpty(this.O00000oo)) {
        }
        fte.O00000Oo(String.format(O0000o0 + " config_type = %s", this.O0000O0o));
        order.put((byte) 8);
        if (!TextUtils.isEmpty(this.O0000O0o)) {
        }
        fte.O00000Oo(String.format(O0000o0 + " bind_key = %s", this.O0000OOo));
        order.put((byte) 9);
        if (!TextUtils.isEmpty(this.O0000OOo)) {
        }
        fte.O00000Oo(String.format(O0000o0 + " country_code = %s", this.O0000Oo0));
        order.put((byte) 10);
        if (!TextUtils.isEmpty(this.O0000Oo0)) {
        }
        fte.O00000Oo(String.format(O0000o0 + " passportUrl = %s", this.O0000Oo));
        if (!TextUtils.isEmpty(this.O0000Oo)) {
        }
        fte.O00000Oo(String.format(O0000o0 + " ble token = %s", this.O0000OoO));
        if (!TextUtils.isEmpty(this.O0000OoO)) {
        }
        fte.O00000Oo(String.format(O0000o0 + " bindIndex = %s", this.O0000Ooo));
        if (!TextUtils.isEmpty(this.O0000Ooo)) {
        }
        fte.O00000Oo(String.format(O0000o0 + " bindTimestamp = %s", Long.valueOf(this.O0000o00)));
        if (this.O0000o00 > 0) {
        }
        byte[] bArr22 = new byte[order.position()];
        System.arraycopy(order.array(), 0, bArr22, 0, bArr22.length);
        return bArr22;
    }
}

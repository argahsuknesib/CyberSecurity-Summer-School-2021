package com.xiaomi.aiot.mibeacon.bluetooth;

import android.annotation.TargetApi;
import com.xiaomi.aiot.mibeacon.utils.ByteUtils;

public class Pdu {
    private int mActualLength;
    private byte[] mBytes;
    private int mDeclaredLength;
    private int mType;

    @TargetApi(9)
    public static Pdu parse(byte[] bArr, int i) {
        byte b;
        if (bArr.length - i >= 2 && (b = bArr[i]) > 0) {
            byte b2 = bArr[i + 1];
            int i2 = i + 2;
            if (i2 < bArr.length) {
                Pdu pdu = new Pdu();
                int i3 = i + b;
                if (i3 >= bArr.length) {
                    i3 = bArr.length - 1;
                }
                pdu.mType = b2 & 255;
                pdu.mDeclaredLength = b;
                pdu.mBytes = ByteUtils.getBytes(bArr, i2, i3);
                pdu.mActualLength = (i3 - i) + 1;
                return pdu;
            }
        }
        return null;
    }

    public int getType() {
        return this.mType;
    }

    public int getDeclaredLength() {
        return this.mDeclaredLength;
    }

    public int getActualLength() {
        return this.mActualLength;
    }

    public byte[] getBytes() {
        return this.mBytes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Type: 0x%02x, ", Integer.valueOf(this.mType)));
        sb.append(String.format("Len: %d, ", Integer.valueOf(this.mDeclaredLength)));
        int i = this.mType;
        String str = (i == 8 || i == 9) ? "%c" : "%02x ";
        try {
            byte[] bArr = this.mBytes;
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format(str, Byte.valueOf(bArr[i2])));
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public String rawString() {
        StringBuilder sb = new StringBuilder();
        int i = this.mType;
        String str = (i == 8 || i == 9) ? "%c" : "%02x";
        try {
            byte[] bArr = this.mBytes;
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format(str, Byte.valueOf(bArr[i2])));
            }
        } catch (Throwable unused) {
        }
        return sb.toString().toUpperCase();
    }
}

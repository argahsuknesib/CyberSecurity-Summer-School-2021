package _m_j;

import android.os.ParcelUuid;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

final class jaq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ParcelUuid f1712O000000o = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");

    static ParcelUuid O000000o(byte[] bArr) {
        long j;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                throw new IllegalArgumentException("uuidBytes length invalid - ".concat(String.valueOf(length)));
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                if (length == 2) {
                    j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
                } else {
                    j = ((long) ((bArr[3] & 255) << 24)) + ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16));
                }
                return new ParcelUuid(new UUID(f1712O000000o.getUuid().getMostSignificantBits() + (j << 32), f1712O000000o.getUuid().getLeastSignificantBits()));
            }
        } else {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
    }
}

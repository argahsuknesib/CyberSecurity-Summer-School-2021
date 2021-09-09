package com.tsmclient.smartcard.tlv;

import android.support.v4.app.NotificationCompat;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.exception.InvalidTLVException;
import java.util.ArrayList;

public class TLVParser {
    private static final ByteArray APP_DISCRETIONARY_TAG = ByteArray.wrap(new byte[]{-90});

    private TLVParser() {
    }

    public static ITLVObject parse(ByteArray byteArray) throws InvalidTLVException {
        int i;
        if (byteArray.length() >= 2) {
            if ((byteArray.get(0) & 31) == 31) {
                int i2 = 1;
                i = 2;
                while ((byteArray.get(i2) & 128) == 128) {
                    i2++;
                    i++;
                }
            } else {
                i = 1;
            }
            ByteArray duplicate = byteArray.duplicate(0, i);
            int[] tLVLength = getTLVLength(byteArray, i);
            ByteArray duplicate2 = byteArray.duplicate(i, tLVLength[1]);
            int i3 = i + tLVLength[1];
            if ((byteArray.get(0) & 32) == 0 || APP_DISCRETIONARY_TAG.contains(byteArray.get(0))) {
                return new DefaultTLVObject(duplicate, duplicate2, new PrimitiveTLVValue(byteArray.duplicate(i3, byteArray.length() - i3)));
            }
            return new DefaultTLVObject(duplicate, duplicate2, parseTLVValue(byteArray.duplicate(i3, byteArray.length() - i3)));
        }
        throw new InvalidTLVException("data too small");
    }

    public static ITLVValue parseTLVValue(ByteArray byteArray) throws InvalidTLVException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < byteArray.length()) {
            int i2 = (byteArray.get(i) & 31) == 31 ? 2 : 1;
            int[] tLVLength = getTLVLength(byteArray, i + i2);
            int i3 = tLVLength[0];
            int i4 = i2 + tLVLength[1];
            if ((byteArray.length() - i) - i4 >= i3) {
                int i5 = i3 + i4;
                arrayList.add(parse(byteArray.duplicate(i, i5)));
                i += i5;
            } else {
                throw new InvalidTLVException("insufficient len when parsing value, len: ".concat(String.valueOf(i3)));
            }
        }
        return new ArrayTLVValue(byteArray, arrayList);
    }

    private static int[] getTLVLength(ByteArray byteArray, int i) throws InvalidTLVException {
        int i2 = byteArray.get(i) & 255;
        if (i2 == 128) {
            throw new InvalidTLVException("find infinite tag length");
        } else if ((i2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            int i3 = i2 & 127;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                i4 <<= 8;
                int i6 = i + i5 + 1;
                if (i6 < byteArray.length()) {
                    i4 += byteArray.get(i6) & 255;
                }
            }
            if (((byteArray.length() - i) - i3) - 1 >= i4) {
                return new int[]{i4, i3 + 1};
            }
            throw new InvalidTLVException("insufficient remaining value, long form len: ".concat(String.valueOf(i4)));
        } else if ((byteArray.length() - i) - 1 >= i2) {
            return new int[]{i2, 1};
        } else {
            throw new InvalidTLVException("insufficient remaining value, len: ".concat(String.valueOf(i2)));
        }
    }
}

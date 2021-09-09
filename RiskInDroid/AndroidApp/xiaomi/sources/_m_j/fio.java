package _m_j;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.util.Arrays;

public final class fio {
    public static ECPublicKey O000000o(byte[] bArr, ECParameterSpec eCParameterSpec) throws Exception {
        if (bArr[0] == 4) {
            int bitLength = ((eCParameterSpec.getOrder().bitLength() + 8) - 1) / 8;
            if (bArr.length == (bitLength * 2) + 1) {
                int i = bitLength + 1;
                return (ECPublicKey) KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i)), new BigInteger(1, Arrays.copyOfRange(bArr, i, bitLength + i))), eCParameterSpec));
            }
            throw new IllegalArgumentException("Invalid uncompressedPoint encoding, not the correct size");
        }
        throw new IllegalArgumentException("Invalid uncompressedPoint encoding, no uncompressed point indicator");
    }

    private static byte[] O000000o(char[] cArr) throws IllegalArgumentException {
        int length = cArr.length;
        if ((length & 1) == 0) {
            byte[] bArr = new byte[(length >> 1)];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i + 1;
                i = i3 + 1;
                bArr[i2] = (byte) (((O000000o(cArr[i], i) << 4) | O000000o(cArr[i3], i3)) & 255);
                i2++;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Odd number of characters.");
    }

    private static int O000000o(char c, int i) throws IllegalArgumentException {
        int digit = Character.digit(c, 16);
        if (digit != -1) {
            return digit;
        }
        throw new IllegalArgumentException("Illegal hexadecimal character " + c + " at index " + i);
    }

    public static byte[] O000000o(ECPublicKey eCPublicKey) throws IllegalArgumentException {
        ECPoint w = eCPublicKey.getW();
        String bigInteger = w.getAffineX().toString(16);
        String bigInteger2 = w.getAffineY().toString(16);
        StringBuilder sb = new StringBuilder();
        sb.append("04");
        for (int i = 0; i < 64 - bigInteger.length(); i++) {
            sb.append(0);
        }
        sb.append(bigInteger);
        for (int i2 = 0; i2 < 64 - bigInteger2.length(); i2++) {
            sb.append(0);
        }
        sb.append(bigInteger2);
        return O000000o(sb.toString().toCharArray());
    }

    public static byte[] O000000o(ECPrivateKey eCPrivateKey) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        String bigInteger = eCPrivateKey.getS().toString(16);
        for (int i = 0; i < 64 - bigInteger.length(); i++) {
            sb.append(0);
        }
        sb.append(bigInteger);
        return O000000o(sb.toString().toCharArray());
    }
}

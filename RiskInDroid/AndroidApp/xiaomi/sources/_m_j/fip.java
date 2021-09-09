package _m_j;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

public final class fip {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f16403O000000o = new byte[0];
    private final String O00000Oo;
    private SecretKey O00000o = null;
    private final Provider O00000o0;

    public static fip O000000o(String str) throws NoSuchAlgorithmException {
        Mac.getInstance(str);
        return new fip(str);
    }

    public final void O000000o(byte[] bArr, byte[] bArr2) {
        Mac mac;
        byte[] bArr3 = bArr2 == null ? f16403O000000o : (byte[]) bArr2.clone();
        byte[] bArr4 = f16403O000000o;
        try {
            if (this.O00000o0 != null) {
                mac = Mac.getInstance(this.O00000Oo, this.O00000o0);
            } else {
                mac = Mac.getInstance(this.O00000Oo);
            }
            if (bArr3.length == 0) {
                bArr3 = new byte[mac.getMacLength()];
                Arrays.fill(bArr3, (byte) 0);
            }
            mac.init(new SecretKeySpec(bArr3, this.O00000Oo));
            bArr4 = mac.doFinal(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr4, this.O00000Oo);
            Arrays.fill(bArr4, (byte) 0);
            if (secretKeySpec.getAlgorithm().equals(this.O00000Oo)) {
                this.O00000o = secretKeySpec;
                Arrays.fill(bArr4, (byte) 0);
                return;
            }
            throw new InvalidKeyException("Algorithm for the provided key must match the algorithm for this Hkdf. Expected " + this.O00000Oo + " but found " + secretKeySpec.getAlgorithm());
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Unexpected exception", e);
        } catch (Throwable th) {
            Arrays.fill(bArr4, (byte) 0);
            throw th;
        }
    }

    private fip(String str) {
        if (str.startsWith("Hmac")) {
            this.O00000Oo = str;
            this.O00000o0 = null;
            return;
        }
        throw new IllegalArgumentException("Invalid algorithm " + str + ". Hkdf may only be used with Hmac algorithms.");
    }

    public final byte[] O000000o(byte[] bArr, int i) throws IllegalStateException {
        byte[] bArr2;
        int i2;
        byte[] bArr3 = new byte[i];
        try {
            if (this.O00000o == null) {
                throw new IllegalStateException("Hkdf has not been initialized");
            } else if (i < 0) {
                throw new IllegalArgumentException("Length must be a non-negative value.");
            } else if (bArr3.length >= i + 0) {
                Mac O000000o2 = O000000o();
                if (i <= O000000o2.getMacLength() * 255) {
                    bArr2 = f16403O000000o;
                    byte b = 1;
                    for (int i3 = 0; i3 < i; i3 = i2) {
                        O000000o2.update(bArr2);
                        O000000o2.update(bArr);
                        O000000o2.update(b);
                        bArr2 = O000000o2.doFinal();
                        i2 = i3;
                        int i4 = 0;
                        while (i4 < bArr2.length && i2 < i) {
                            bArr3[i2] = bArr2[i4];
                            i4++;
                            i2++;
                        }
                        b = (byte) (b + 1);
                    }
                    Arrays.fill(bArr2, (byte) 0);
                    return bArr3;
                }
                throw new IllegalArgumentException("Requested keys may not be longer than 255 times the underlying HMAC length.");
            } else {
                throw new ShortBufferException();
            }
        } catch (ShortBufferException e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            Arrays.fill(bArr2, (byte) 0);
            throw th;
        }
    }

    private Mac O000000o() {
        Mac mac;
        try {
            if (this.O00000o0 != null) {
                mac = Mac.getInstance(this.O00000Oo, this.O00000o0);
            } else {
                mac = Mac.getInstance(this.O00000Oo);
            }
            mac.init(this.O00000o);
            return mac;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e2) {
            throw new RuntimeException(e2);
        }
    }
}

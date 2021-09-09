package _m_j;

import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.bouncycastle.crypto.InvalidCipherTextException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class fir {
    public static KeyPair O000000o() {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("EC");
            instance.initialize(new ECGenParameterSpec("secp256r1"));
            return instance.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidAlgorithmParameterException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] O000000o(PublicKey publicKey) {
        byte[] O000000o2 = fio.O000000o((ECPublicKey) publicKey);
        return O000000o2.length == 65 ? Arrays.copyOfRange(O000000o2, 1, 65) : O000000o2;
    }

    public static SecretKey O000000o(PublicKey publicKey, PrivateKey privateKey) {
        try {
            KeyAgreement instance = KeyAgreement.getInstance("ECDH");
            instance.init(privateKey);
            instance.doPhase(publicKey, true);
            return instance.generateSecret("ECDH");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fir.O000000o(javax.crypto.SecretKey, boolean, byte[], byte[]):_m_j.fid
     arg types: [javax.crypto.SecretKey, int, byte[], byte[]]
     candidates:
      _m_j.fir.O000000o(javax.crypto.SecretKey, byte[], byte[], byte[]):_m_j.fin
      _m_j.fir.O000000o(javax.crypto.SecretKey, boolean, byte[], byte[]):_m_j.fid */
    public static fin O000000o(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3) throws InvalidCipherTextException {
        fid O000000o2 = O000000o(secretKey, true, bArr, bArr3);
        byte[] bArr4 = new byte[O000000o2.O000000o(bArr2.length)];
        O000000o2.O000000o(bArr2, bArr2.length);
        int O00000Oo = (O000000o2.O00000Oo(bArr4, 0) + 0) - 4;
        byte[] bArr5 = new byte[O00000Oo];
        byte[] bArr6 = new byte[4];
        System.arraycopy(bArr4, 0, bArr5, 0, bArr5.length);
        System.arraycopy(bArr4, O00000Oo, bArr6, 0, 4);
        return new fin(bArr5, bArr6);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fir.O000000o(javax.crypto.SecretKey, boolean, byte[], byte[]):_m_j.fid
     arg types: [javax.crypto.SecretKey, int, byte[], ?[OBJECT, ARRAY]]
     candidates:
      _m_j.fir.O000000o(javax.crypto.SecretKey, byte[], byte[], byte[]):_m_j.fin
      _m_j.fir.O000000o(javax.crypto.SecretKey, boolean, byte[], byte[]):_m_j.fid */
    private static byte[] O00000Oo(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3) throws InvalidCipherTextException {
        fid O000000o2 = O000000o(secretKey, false, bArr, (byte[]) null);
        byte[] bArr4 = new byte[(bArr2.length + bArr3.length)];
        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, bArr2.length, bArr3.length);
        byte[] bArr5 = new byte[O000000o2.O000000o(bArr4.length)];
        O000000o2.O000000o(bArr4, bArr4.length);
        O000000o2.O00000Oo(bArr5, 0);
        return bArr5;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            return O000000o(new SecretKeySpec(bArr, "AES"), bArr2, bArr3, (byte[]) null).O000000o();
        } catch (InvalidCipherTextException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] O00000Oo(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            return O00000Oo(new SecretKeySpec(bArr, "AES"), bArr2, Arrays.copyOfRange(bArr3, 0, bArr3.length - 4), Arrays.copyOfRange(bArr3, bArr3.length - 4, bArr3.length));
        } catch (InvalidCipherTextException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] O000000o(byte[] bArr) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
        byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        fht fht = new fht(byteArrayOutputStream);
        fhn fhn = new fhn();
        fhn.O000000o(new fho(new BigInteger(1, copyOfRange)));
        fhn.O000000o(new fho(new BigInteger(1, copyOfRange2)));
        try {
            fht.O000000o(new fhu(fhn));
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            fht.f16387O000000o.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return byteArray;
    }

    public static boolean O000000o(byte[] bArr, byte[] bArr2, PublicKey publicKey) {
        try {
            Signature instance = Signature.getInstance("SHA256WithECDSA");
            instance.initVerify(publicKey);
            instance.update(bArr);
            return instance.verify(bArr2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return false;
        } catch (SignatureException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public static byte[] O000000o(String str) {
        byte[] bArr = new byte[6];
        String[] split = str.split("[:]");
        int length = split.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) Integer.parseInt(split[i], 16);
            i++;
            i2++;
        }
        return bArr;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(bArr, "HmacSHA256"));
            return instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static fid O000000o(SecretKey secretKey, boolean z, byte[] bArr, byte[] bArr2) {
        fia fia = new fia();
        fia.O000000o(z, new fih(secretKey.getEncoded()));
        fid fid = new fid(fia);
        fig fig = new fig(new fih(secretKey.getEncoded()), bArr, bArr2);
        fid.f16394O000000o = z;
        fig fig2 = fig;
        fid.O00000Oo = fig2.O00000Oo;
        fid.O00000o0 = fig2.f16397O000000o;
        fid.O00000o = fig2.O00000o / 8;
        fih fih = fig2.O00000o0;
        if (fih != null) {
            fid.O00000oO = fih;
        }
        if (fid.O00000Oo == null || fid.O00000Oo.length < 7 || fid.O00000Oo.length > 13) {
            throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
        }
        fid.O000000o();
        return fid;
    }
}

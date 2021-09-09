package com.xiaomi.smarthome.uwb.lib.auth;

import _m_j.fij;
import _m_j.fio;
import _m_j.fip;
import _m_j.fir;
import _m_j.gsy;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPrivateKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class TestCase {
    public static void start() {
        ECPublicKey eCPublicKey;
        KeyPair O000000o2 = fir.O000000o();
        byte[] bArr = new byte[65];
        bArr[0] = 4;
        System.arraycopy(ByteUtils.stringToBytes("C69E64BF44A97A87A2550B723071F37EE3E711F06BB9A65E16222988B9D51F4833327587CD9FA0C8FBD1F1224A5D881312314BC45DED4C18DE8D9714F9AB086C"), 0, bArr, 1, 64);
        ECPublicKey eCPublicKey2 = null;
        try {
            eCPublicKey = fio.O000000o(bArr, ((ECPublicKey) O000000o2.getPublic()).getParams());
        } catch (Exception e) {
            e.printStackTrace();
            eCPublicKey = null;
        }
        ECPrivateKey privateKey = getPrivateKey(ByteUtils.stringToBytes("C6E27F6CB0D9177A0F0DA12E26424593FCEFCCDF83C9A9B56E90D9DC8DFD9B3E"), O000000o2);
        byte[] bArr2 = new byte[65];
        bArr2[0] = 4;
        System.arraycopy(ByteUtils.stringToBytes("43E1892DEFDF7ADE5869EE6FA29BDBF3787E3263406AE90B46158A34BB04ED78E760B7C1DCA1E86C11B038E9D3461155603E653B956EBF3BF127A6ED10483907"), 0, bArr2, 1, 64);
        try {
            eCPublicKey2 = fio.O000000o(bArr2, ((ECPublicKey) O000000o2.getPublic()).getParams());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ECPrivateKey privateKey2 = getPrivateKey(ByteUtils.stringToBytes("DFE637303654C5530B35DBBAD65A36FABC2C49DF9C6E015DAA28816DF6270A44"), O000000o2);
        byte[] stringToBytes = ByteUtils.stringToBytes("1481051BBDD9D835ACCD7FBE229BA3E2");
        byte[] deriveSessionKey = deriveSessionKey(fir.O000000o(eCPublicKey, privateKey2).getEncoded(), stringToBytes);
        deriveSessionKey(fir.O000000o(eCPublicKey2, privateKey).getEncoded(), stringToBytes);
        ByteUtils.stringToBytes("214E60B64432A5F5A729E1A784EDCE56");
        ByteUtils.stringToBytes("55E86821602F8940DBFFD66982E21355");
        byte[] stringToBytes2 = ByteUtils.stringToBytes("ED169DF1010B5F9360C1934A84A32DD4");
        byte[] stringToBytes3 = ByteUtils.stringToBytes("7F2F8DE930067D7214BC9114A109D02C");
        byte[] stringToBytes4 = ByteUtils.stringToBytes("E24BE4");
        aes128Encode(deriveSessionKey, stringToBytes3);
        aes128Encode(deriveSessionKey, stringToBytes2);
        fir.O00000Oo(deriveSessionKey, fij.O00000o0(stringToBytes2), fir.O000000o(deriveSessionKey, fij.O00000o0(stringToBytes2), deriveStrangerSpecificKey(ByteUtils.stringToBytes("8FA660EA169A45C2CB9609FDBE77C514"), stringToBytes4)));
        gsy.O000000o(3, "", "end");
    }

    private static ECPrivateKey getPrivateKey(byte[] bArr, KeyPair keyPair) {
        try {
            return (ECPrivateKey) KeyFactory.getInstance("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, bArr), ((ECPrivateKey) keyPair.getPrivate()).getParams()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static byte[] deriveSessionKey(byte[] bArr, byte[] bArr2) {
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(bArr, bArr2);
            return O000000o2.O000000o("".getBytes(), 16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] aes128Encode(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        byte[] bArr4 = null;
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            bArr4 = instance.doFinal(bArr2);
            AESDUtile.encrypt(bArr2, bArr, AESDUtile.decodeHex("e3205234a872012af4f3ac5dbd9c810c"));
            gsy.O000000o(6, "", "");
            return bArr4;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return bArr4;
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return bArr4;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return bArr4;
        } catch (InvalidAlgorithmParameterException e4) {
            e4.printStackTrace();
            return bArr4;
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            return bArr4;
        } catch (BadPaddingException e6) {
            e6.printStackTrace();
            return bArr4;
        }
    }

    private static byte[] deriveStrangerSpecificKey(byte[] bArr, byte[] bArr2) {
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(bArr, bArr2);
            return O000000o2.O000000o("uwb_stranger_specific_secret".getBytes(), 16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

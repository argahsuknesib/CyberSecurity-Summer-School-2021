package com.tiqiaa.icontrol.util;

import _m_j.bdf;
import android.util.Base64;
import com.imi.fastjson.serializer.SerializerFeature;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DTOUtil {
    public static String getResponesJson(ResponseDTO responseDTO) throws DataProcessException {
        byte[] bArr;
        String O000000o2 = bdf.O000000o(responseDTO, SerializerFeature.WriteNullStringAsEmpty);
        try {
            bArr = O000000o2.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = O000000o2.getBytes();
        }
        byte[] zipAndEncode = zipAndEncode(bArr);
        try {
            String md5 = getMD5(zipAndEncode);
            HashMap hashMap = new HashMap();
            hashMap.put("md5", md5);
            hashMap.put("response_params", Base64Helper.encoder(zipAndEncode));
            return bdf.O000000o(hashMap);
        } catch (NoSuchAlgorithmException unused) {
            throw new DataProcessException();
        }
    }

    public static String getRequestJson(RequestDTO requestDTO) throws DataProcessException {
        byte[] bArr;
        String O000000o2 = bdf.O000000o(requestDTO, SerializerFeature.WriteNullStringAsEmpty);
        if (TiqiaaService.TEST_MODE) {
            LogUtil.v("", "getRequestJson.............原始数据  request_json -> " + TQJSON.toJSONString(requestDTO));
            LogUtil.v("RequestJson", "getRequestJson.............request_json = ".concat(String.valueOf(O000000o2)));
        }
        try {
            bArr = O000000o2.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = O000000o2.getBytes();
        }
        LogUtil.d("", "原始数据byte[] -> " + bArr.length);
        byte[] zipAndEncode = zipAndEncode(bArr);
        LogUtil.d("", "压缩&&加密后数据byte[] -> " + zipAndEncode.length);
        try {
            String md5 = getMD5(zipAndEncode);
            HashMap hashMap = new HashMap();
            hashMap.put("md5", md5);
            hashMap.put("request_params", Base64Helper.encoder(zipAndEncode));
            return bdf.O000000o(hashMap);
        } catch (NoSuchAlgorithmException unused) {
            throw new DataProcessException();
        }
    }

    private static byte[] zipAndEncode(byte[] bArr) throws DataProcessException {
        try {
            return ZipUtil.zip(SafeUtil.encoder(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataProcessException();
        }
    }

    public static byte[] decodeAndUnzip(byte[] bArr) throws DataProcessException {
        try {
            byte[] decoder = SafeUtil.decoder(ZipUtil.unZip(bArr));
            LogUtil.d("", "明文数据byte[] -> " + (decoder.length / 1024) + " K");
            return decoder;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataProcessException();
        }
    }

    public static class ZipUtil {
        public static byte[] zip(byte[] bArr) throws Exception {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            WeakRefHandler.add(byteArrayOutputStream);
            WeakRefHandler.add(gZIPOutputStream);
            return byteArray;
        }

        public static byte[] unZip(byte[] bArr) throws Exception {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[512];
            while (true) {
                int read = gZIPInputStream.read(bArr2, 0, 512);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    WeakRefHandler.add(bArr2);
                    WeakRefHandler.add(gZIPInputStream);
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        }
    }

    static class SafeUtil {
        static String DES_ALGORITHM = "DES";

        private SafeUtil() {
        }

        public static byte[] encoder(byte[] bArr) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
            SecretKey generateKey = generateKey("icontrol");
            Cipher instance = Cipher.getInstance(DES_ALGORITHM);
            instance.init(1, generateKey);
            byte[] doFinal = instance.doFinal(bArr);
            WeakRefHandler.add(bArr);
            WeakRefHandler.add(generateKey);
            WeakRefHandler.add(instance);
            return doFinal;
        }

        public static byte[] decoder(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
            SecretKey generateKey = generateKey("icontrol");
            Cipher.getInstance(DES_ALGORITHM);
            Cipher instance = Cipher.getInstance(DES_ALGORITHM);
            instance.init(2, generateKey);
            byte[] doFinal = instance.doFinal(bArr);
            WeakRefHandler.add(bArr);
            WeakRefHandler.add(generateKey);
            WeakRefHandler.add(instance);
            return doFinal;
        }

        private static SecretKey generateKey(String str) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
            SecretKeyFactory instance = SecretKeyFactory.getInstance(DES_ALGORITHM);
            DESKeySpec dESKeySpec = new DESKeySpec(str.getBytes());
            SecretKey generateSecret = instance.generateSecret(dESKeySpec);
            WeakRefHandler.add(instance);
            WeakRefHandler.add(dESKeySpec);
            return generateSecret;
        }
    }

    public static class Base64Helper {
        public static String encoder(byte[] bArr) {
            return Base64.encodeToString(bArr, 0).trim();
        }

        public static byte[] decoder(String str) {
            return Base64.decode(str, 0);
        }
    }

    public static boolean verifyMD5(String str, String str2) throws NoSuchAlgorithmException {
        if (!(str == null || str2 == null)) {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(Base64Helper.decoder(str));
            String encoder = Base64Helper.encoder(instance.digest());
            LogUtil.d("", "md5_now=".concat(String.valueOf(encoder)));
            if (encoder.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static String getMD5(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr);
        return Base64Helper.encoder(instance.digest());
    }

    public static class DataProcessException extends Exception {
        private static final long serialVersionUID = 1;

        public DataProcessException() {
            super("网络传输数据解析或者打包异常");
        }
    }
}

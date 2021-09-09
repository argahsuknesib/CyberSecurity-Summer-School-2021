package com.mibi.sdk.common;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import com.mibi.sdk.common.utils.MibiLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Coder {
    private static final String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    private static final String[] HEX_DIGITS_UPPERCASE = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static final byte[] encodeMD5Bytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String encodeMD5(String str) {
        byte[] encodeMD5Bytes = encodeMD5Bytes(str);
        if (encodeMD5Bytes != null) {
            return byteArrayToString(encodeMD5Bytes);
        }
        return null;
    }

    public static final String encodeMD5(File file) {
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                fileInputStream.close();
                return byteArrayToString(instance.digest());
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return null;
            } catch (IOException e4) {
                e4.printStackTrace();
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return null;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public static String byteArrayToString(byte[] bArr) {
        return byteArrayToString(bArr, false);
    }

    public static String byteArrayToString(byte[] bArr, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte byteToHexString : bArr) {
            stringBuffer.append(byteToHexString(byteToHexString, z));
        }
        return stringBuffer.toString();
    }

    public static String byteToHexString(byte b) {
        return byteToHexString(b, false);
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:0:0x0000 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    public static String byteToHexString(byte b, boolean z) {
        if (b < 0) {
            b += 256;
        }
        int i = b / 16;
        int i2 = b % 16;
        if (z) {
            return HEX_DIGITS_UPPERCASE[i] + HEX_DIGITS_UPPERCASE[i2];
        }
        return HEX_DIGITS[i] + HEX_DIGITS[i2];
    }

    public static final String encodeSHA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA");
            instance.update(str.getBytes());
            return byteArrayToString(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final byte[] encodeSHABytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA");
            instance.update(str.getBytes());
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String encodeBase64(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    public static final String encodeBase64(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static final byte[] encodeBase64Bytes(String str) {
        return Base64.encode(str.getBytes(), 2);
    }

    public static final String decodeBase64(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static final byte[] decodeBase64Bytes(String str) {
        return Base64.decode(str, 0);
    }

    public static final OutputStream encodeBase64Stream(OutputStream outputStream) {
        return new Base64OutputStream(outputStream, 2);
    }

    public static final InputStream decodeBase64Stream(InputStream inputStream) {
        return new Base64InputStream(inputStream, 0);
    }

    public static final String encodeAES(String str, String str2) {
        byte[] decodeBase64Bytes;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (decodeBase64Bytes = decodeBase64Bytes(str2)) != null && decodeBase64Bytes.length == 16) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(decodeBase64Bytes, "AES");
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(1, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
                return encodeBase64(instance.doFinal(str.getBytes()));
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            }
        }
        return null;
    }

    public static final String decodeAES(String str, String str2) {
        byte[] decodeBase64Bytes;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (decodeBase64Bytes = decodeBase64Bytes(str2)) != null && decodeBase64Bytes.length == 16) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(decodeBase64Bytes, "AES");
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(2, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
                byte[] decodeBase64Bytes2 = decodeBase64Bytes(str);
                if (decodeBase64Bytes2 == null) {
                    return null;
                }
                return new String(instance.doFinal(decodeBase64Bytes2));
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            } catch (IllegalArgumentException e) {
                MibiLog.e("Coder", e.getMessage());
            } catch (Exception e2) {
                MibiLog.e("Coder", e2.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x00f5 A[SYNTHETIC, Splitter:B:102:0x00f5] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x00fa A[Catch:{ Exception -> 0x0103 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x00ff A[Catch:{ Exception -> 0x0103 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x010c A[SYNTHETIC, Splitter:B:115:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0111 A[Catch:{ Exception -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0116 A[Catch:{ Exception -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0123 A[SYNTHETIC, Splitter:B:128:0x0123] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0128 A[Catch:{ Exception -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x012d A[Catch:{ Exception -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x013a A[SYNTHETIC, Splitter:B:141:0x013a] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x013f A[Catch:{ Exception -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0144 A[Catch:{ Exception -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x014c A[SYNTHETIC, Splitter:B:151:0x014c] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0151 A[Catch:{ Exception -> 0x015a }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0156 A[Catch:{ Exception -> 0x015a }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00c7 A[SYNTHETIC, Splitter:B:76:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00cc A[Catch:{ Exception -> 0x00d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00d1 A[Catch:{ Exception -> 0x00d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00de A[SYNTHETIC, Splitter:B:89:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00e3 A[Catch:{ Exception -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00e8 A[Catch:{ Exception -> 0x00ec }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:99:0x00f0=Splitter:B:99:0x00f0, B:73:0x00c2=Splitter:B:73:0x00c2, B:138:0x0135=Splitter:B:138:0x0135, B:112:0x0107=Splitter:B:112:0x0107, B:86:0x00d9=Splitter:B:86:0x00d9, B:125:0x011e=Splitter:B:125:0x011e} */
    public static boolean encodeFileAES(String str, String str2, String str3) {
        byte[] decodeBase64Bytes;
        CipherInputStream cipherInputStream;
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (decodeBase64Bytes = decodeBase64Bytes(str3)) == null || decodeBase64Bytes.length != 16) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(decodeBase64Bytes, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    cipherInputStream = new CipherInputStream(fileInputStream2, instance);
                    while (true) {
                        try {
                            int read = cipherInputStream.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                                fileOutputStream.flush();
                            } else {
                                fileOutputStream.flush();
                                try {
                                    fileInputStream2.close();
                                    fileOutputStream.close();
                                    cipherInputStream.close();
                                    return true;
                                } catch (Exception unused) {
                                    return false;
                                }
                            }
                        } catch (InvalidKeyException e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (cipherInputStream != null) {
                            }
                            return false;
                        } catch (InvalidAlgorithmParameterException e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (cipherInputStream != null) {
                            }
                            return false;
                        } catch (NoSuchAlgorithmException e3) {
                            e = e3;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (cipherInputStream != null) {
                            }
                            return false;
                        } catch (NoSuchPaddingException e4) {
                            e = e4;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (cipherInputStream != null) {
                            }
                            return false;
                        } catch (FileNotFoundException e5) {
                            e = e5;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (cipherInputStream != null) {
                            }
                            return false;
                        } catch (IOException e6) {
                            e = e6;
                            fileInputStream = fileInputStream2;
                            try {
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                if (cipherInputStream != null) {
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                if (cipherInputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (cipherInputStream != null) {
                            }
                            throw th;
                        }
                    }
                } catch (InvalidKeyException e7) {
                    e = e7;
                    cipherInputStream = null;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                            return false;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (cipherInputStream != null) {
                        cipherInputStream.close();
                    }
                    return false;
                } catch (InvalidAlgorithmParameterException e8) {
                    e = e8;
                    cipherInputStream = null;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                            return false;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (cipherInputStream != null) {
                        cipherInputStream.close();
                    }
                    return false;
                } catch (NoSuchAlgorithmException e9) {
                    e = e9;
                    cipherInputStream = null;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused4) {
                            return false;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (cipherInputStream != null) {
                        cipherInputStream.close();
                    }
                    return false;
                } catch (NoSuchPaddingException e10) {
                    e = e10;
                    cipherInputStream = null;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused5) {
                            return false;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (cipherInputStream != null) {
                        cipherInputStream.close();
                    }
                    return false;
                } catch (FileNotFoundException e11) {
                    e = e11;
                    cipherInputStream = null;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused6) {
                            return false;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (cipherInputStream != null) {
                        cipherInputStream.close();
                    }
                    return false;
                } catch (IOException e12) {
                    e = e12;
                    cipherInputStream = null;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused7) {
                            return false;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (cipherInputStream != null) {
                        cipherInputStream.close();
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    cipherInputStream = null;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused8) {
                            return false;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (cipherInputStream != null) {
                        cipherInputStream.close();
                    }
                    throw th;
                }
            } catch (InvalidKeyException e13) {
                e = e13;
                fileOutputStream = null;
                cipherInputStream = null;
                fileInputStream = fileInputStream2;
                e.printStackTrace();
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                if (cipherInputStream != null) {
                }
                return false;
            } catch (InvalidAlgorithmParameterException e14) {
                e = e14;
                fileOutputStream = null;
                cipherInputStream = null;
                fileInputStream = fileInputStream2;
                e.printStackTrace();
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                if (cipherInputStream != null) {
                }
                return false;
            } catch (NoSuchAlgorithmException e15) {
                e = e15;
                fileOutputStream = null;
                cipherInputStream = null;
                fileInputStream = fileInputStream2;
                e.printStackTrace();
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                if (cipherInputStream != null) {
                }
                return false;
            } catch (NoSuchPaddingException e16) {
                e = e16;
                fileOutputStream = null;
                cipherInputStream = null;
                fileInputStream = fileInputStream2;
                e.printStackTrace();
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                if (cipherInputStream != null) {
                }
                return false;
            } catch (FileNotFoundException e17) {
                e = e17;
                fileOutputStream = null;
                cipherInputStream = null;
                fileInputStream = fileInputStream2;
                e.printStackTrace();
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                if (cipherInputStream != null) {
                }
                return false;
            } catch (IOException e18) {
                e = e18;
                fileOutputStream = null;
                cipherInputStream = null;
                fileInputStream = fileInputStream2;
                e.printStackTrace();
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                if (cipherInputStream != null) {
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                cipherInputStream = null;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                if (cipherInputStream != null) {
                }
                throw th;
            }
        } catch (InvalidKeyException e19) {
            e = e19;
            fileOutputStream = null;
            cipherInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            if (cipherInputStream != null) {
            }
            return false;
        } catch (InvalidAlgorithmParameterException e20) {
            e = e20;
            fileOutputStream = null;
            cipherInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            if (cipherInputStream != null) {
            }
            return false;
        } catch (NoSuchAlgorithmException e21) {
            e = e21;
            fileOutputStream = null;
            cipherInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            if (cipherInputStream != null) {
            }
            return false;
        } catch (NoSuchPaddingException e22) {
            e = e22;
            fileOutputStream = null;
            cipherInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            if (cipherInputStream != null) {
            }
            return false;
        } catch (FileNotFoundException e23) {
            e = e23;
            fileOutputStream = null;
            cipherInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            if (cipherInputStream != null) {
            }
            return false;
        } catch (IOException e24) {
            e = e24;
            fileOutputStream = null;
            cipherInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            if (cipherInputStream != null) {
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            cipherInputStream = null;
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            if (cipherInputStream != null) {
            }
            throw th;
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [javax.crypto.CipherOutputStream] */
    /* JADX WARN: Type inference failed for: r0v6, types: [javax.crypto.CipherOutputStream] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c3 A[SYNTHETIC, Splitter:B:59:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00cb A[Catch:{ Exception -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d0 A[Catch:{ Exception -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00db A[SYNTHETIC, Splitter:B:71:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e3 A[Catch:{ Exception -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e8 A[Catch:{ Exception -> 0x00df }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static boolean decodeFileAES(String str, String str2, String str3) {
        byte[] decodeBase64Bytes;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        CipherOutputStream cipherOutputStream;
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (decodeBase64Bytes = decodeBase64Bytes(str3)) == null || decodeBase64Bytes.length != 16) {
            return false;
        }
        ? r0 = 0;
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (!file.exists() || !file.isFile()) {
                cipherOutputStream = null;
                fileInputStream = null;
            } else {
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file2.createNewFile();
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(decodeBase64Bytes, "AES");
                        IvParameterSpec ivParameterSpec = new IvParameterSpec("0102030405060708".getBytes());
                        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        instance.init(2, secretKeySpec, ivParameterSpec);
                        cipherOutputStream = new CipherOutputStream(fileOutputStream, instance);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                cipherOutputStream.write(bArr, 0, read);
                                cipherOutputStream.flush();
                            }
                            r0 = fileOutputStream;
                        } catch (Exception e) {
                            r0 = cipherOutputStream;
                            e = e;
                            try {
                                e.printStackTrace();
                                if (r0 != 0) {
                                }
                                if (fileOutputStream != null) {
                                }
                                if (fileInputStream != null) {
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                r0 = r0;
                                if (r0 != 0) {
                                }
                                if (fileOutputStream != null) {
                                }
                                if (fileInputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            r0 = cipherOutputStream;
                            th = th2;
                            if (r0 != 0) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (r0 != 0) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        return false;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                    e.printStackTrace();
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return false;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            return false;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            }
            if (cipherOutputStream != null) {
                try {
                    cipherOutputStream.close();
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return false;
                }
            }
            if (r0 != 0) {
                r0.close();
            }
            if (fileInputStream == null) {
                return true;
            }
            fileInputStream.close();
            return true;
        } catch (Exception e7) {
            e = e7;
            fileInputStream = null;
            fileOutputStream = null;
            e.printStackTrace();
            if (r0 != 0) {
            }
            if (fileOutputStream != null) {
            }
            if (fileInputStream != null) {
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            fileOutputStream = null;
            if (r0 != 0) {
            }
            if (fileOutputStream != null) {
            }
            if (fileInputStream != null) {
            }
            throw th;
        }
    }
}

package com.xiaomi.mico.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStoreHelper {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025 A[SYNTHETIC, Splitter:B:15:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0031 A[SYNTHETIC, Splitter:B:24:0x0031] */
    public static <T> String encode(T t) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(t);
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return byteArrayToHexString(byteArrayOutputStream.toByteArray());
            } catch (IOException unused) {
                if (objectOutputStream != null) {
                }
                return null;
            } catch (Throwable th) {
                th = th;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                }
                throw th;
            }
        } catch (IOException unused2) {
            objectOutputStream = null;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002d A[SYNTHETIC, Splitter:B:17:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0034 A[SYNTHETIC, Splitter:B:22:0x0034] */
    public static <T> T decode(String str) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(hexStringToByteArray(str));
        T t = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                t = objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e = e;
                try {
                    e.printStackTrace();
                    if (objectInputStream != null) {
                    }
                    return t;
                } catch (Throwable th) {
                    th = th;
                    if (objectInputStream != null) {
                    }
                    throw th;
                }
            }
            try {
                objectInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (IOException | ClassNotFoundException e3) {
            e = e3;
            objectInputStream = null;
            e.printStackTrace();
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            return t;
        } catch (Throwable th2) {
            objectInputStream = null;
            th = th2;
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        return t;
    }

    private static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            byte b2 = b & 255;
            if (b2 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(b2));
        }
        return sb.toString();
    }

    private static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}

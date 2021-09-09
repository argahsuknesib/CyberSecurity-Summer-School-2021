package _m_j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class ayv {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f12713O000000o = 1015808;

    public interface O000000o {
        void result(String str, int i);
    }

    public static String O000000o(byte[] bArr, String str, boolean z) {
        File file = new File(str);
        if (!file.exists()) {
            return "";
        }
        double length = (double) file.length();
        Double.isNaN(length);
        double d = (double) f12713O000000o;
        Double.isNaN(d);
        Math.ceil((length * 1.0d) / d);
        FileInputStream fileInputStream = new FileInputStream(file);
        String str2 = file.getParent() + "/" + System.currentTimeMillis() + str.substring(str.lastIndexOf("."));
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        int i = f12713O000000o;
        byte[] bArr2 = new byte[i];
        byte[] bArr3 = new byte[i];
        while (true) {
            int read = fileInputStream.read(bArr2);
            if (read <= 0) {
                break;
            } else if (read < f12713O000000o) {
                int i2 = read % 16;
                int i3 = (i2 == 0 ? 0 : 16 - i2) + read;
                byte[] bArr4 = new byte[i3];
                System.arraycopy(bArr2, 0, bArr4, 0, read);
                O000000o(fileOutputStream, bArr4, new byte[i3], z, bArr);
            } else {
                O000000o(fileOutputStream, bArr2, bArr3, z, bArr);
            }
        }
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
        return str2;
    }

    private static void O000000o(FileOutputStream fileOutputStream, byte[] bArr, byte[] bArr2, boolean z, byte[] bArr3) {
        byte[] bArr4;
        int i;
        if (z) {
            int length = 16 - (bArr.length % 16);
            byte[] bArr5 = bArr;
            int i2 = 0;
            while (i2 < length) {
                byte[] bArr6 = new byte[(bArr5.length + 1)];
                System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
                System.arraycopy(new byte[]{(byte) length}, 0, bArr6, bArr5.length, 1);
                i2++;
                bArr5 = bArr6;
            }
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, "AES");
                Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
                instance.init(1, secretKeySpec);
                bArr4 = instance.doFinal(bArr5);
            } catch (Exception e) {
                e.printStackTrace();
                bArr4 = new byte[0];
            }
        } else {
            byte[] bArr7 = null;
            int length2 = bArr.length - 1;
            while (true) {
                if (length2 < 0) {
                    i = -1;
                    break;
                } else if (bArr[length2] != 0) {
                    i = length2 + 1;
                    break;
                } else {
                    length2--;
                }
            }
            if (i > 0) {
                bArr7 = new byte[i];
                System.arraycopy(bArr, 0, bArr7, 0, i);
            }
            try {
                SecretKeySpec secretKeySpec2 = new SecretKeySpec(bArr3, "AES");
                Cipher instance2 = Cipher.getInstance("AES/ECB/NoPadding");
                instance2.init(2, secretKeySpec2);
                bArr4 = instance2.doFinal(bArr7);
            } catch (Exception e2) {
                e2.printStackTrace();
                bArr4 = new byte[0];
            }
        }
        System.arraycopy(bArr4, 0, bArr2, 0, bArr2.length);
        fileOutputStream.write(bArr2);
    }
}

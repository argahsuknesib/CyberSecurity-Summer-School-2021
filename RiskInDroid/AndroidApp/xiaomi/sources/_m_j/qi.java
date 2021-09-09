package _m_j;

import android.util.Base64;
import com.amap.location.security.Core;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class qi {
    public static byte[] O000000o(String str) throws Exception {
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        while (true) {
            stringBuffer.append(str);
            if (stringBuffer.length() >= 16) {
                break;
            }
            str = "0";
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        return O00000Oo(stringBuffer.toString());
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    private static byte[] O00000Oo(String str) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        instance.update(str.getBytes());
        byte[] digest = instance.digest();
        StringBuffer stringBuffer = new StringBuffer("");
        for (byte b : digest) {
            int i = b;
            if (b < 0) {
                i = b + 256;
            }
            if (i < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(i));
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        return stringBuffer.toString().getBytes();
    }

    public static byte[] O000000o(String str, byte[] bArr) throws Exception {
        byte[] O000000o2 = O000000o(str);
        String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
        byte[] bArr2 = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            bArr2[i] = Byte.parseByte(split[i]);
        }
        String[] split2 = new StringBuffer(new String(Base64.decode(bArr2, 2))).reverse().toString().split(",");
        byte[] bArr3 = new byte[split2.length];
        for (int i2 = 0; i2 < split2.length; i2++) {
            bArr3[i2] = Byte.parseByte(split2[i2]);
        }
        return Core.cole(bArr, O000000o2, bArr3);
    }
}

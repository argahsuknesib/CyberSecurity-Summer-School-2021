package miui.systemui.controls;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SignatureUtil {
    private static final String[] HEX = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    private SignatureUtil() {
    }

    public static boolean compareSignatures(String str, String str2, PackageManager packageManager) throws PackageManager.NameNotFoundException {
        return TextUtils.equals(getSignature(str, packageManager), getSignature(str2, packageManager));
    }

    private static String getSignature(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
        Signature[] signatureArr;
        SigningInfo signingInfo = packageManager.getPackageInfo(str, 134217728).signingInfo;
        if (signingInfo.hasMultipleSigners()) {
            signatureArr = signingInfo.getApkContentsSigners();
        } else {
            signatureArr = signingInfo.getSigningCertificateHistory();
        }
        return getStringSignatures(toByteArrayList(signatureArr));
    }

    private static List<byte[]> toByteArrayList(Signature[] signatureArr) {
        if (signatureArr == null) {
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        for (Signature byteArray : signatureArr) {
            linkedList.add(byteArray.toByteArray());
        }
        return linkedList;
    }

    private static String getStringSignatures(List<byte[]> list) {
        if (list != null && !list.isEmpty()) {
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                for (byte[] update : list) {
                    instance.update(update);
                }
                return toHexString(instance.digest());
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    private static String toHexString(byte[] bArr) {
        Objects.requireNonNull(bArr);
        StringBuilder sb = new StringBuilder();
        for (byte hexString : bArr) {
            sb.append(toHexString(hexString));
        }
        return sb.toString();
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:0:0x0000 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    private static String toHexString(byte b) {
        if (b < 0) {
            b += 256;
        }
        return HEX[b / 16] + HEX[b % 16];
    }
}

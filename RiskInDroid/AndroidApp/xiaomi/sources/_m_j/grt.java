package _m_j;

import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public final class grt {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Random f18189O000000o = new SecureRandom();

    private static String O000000o(String str) {
        try {
            return String.valueOf(grs.O000000o(MessageDigest.getInstance("SHA1").digest(str.getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            throw new IllegalStateException("failed to SHA1");
        }
    }

    public static String O000000o(String str, String str2, Map<String, String> map, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList.add(str.toUpperCase());
            }
            if (str2 != null) {
                arrayList.add(Uri.parse(str2).getEncodedPath());
            }
            boolean z = true;
            if (!map.isEmpty()) {
                for (Map.Entry entry : new TreeMap(map).entrySet()) {
                    arrayList.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
                }
            }
            arrayList.add(str3);
            StringBuilder sb = new StringBuilder();
            for (String str4 : arrayList) {
                if (!z) {
                    sb.append('&');
                }
                sb.append(str4);
                z = false;
            }
            return O000000o(sb.toString());
        }
        throw new InvalidParameterException("security is not nullable");
    }

    public static String O000000o(long j) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeLong(f18189O000000o.nextLong());
            dataOutputStream.writeInt((int) ((System.currentTimeMillis() + j) / 60000));
            dataOutputStream.flush();
        } catch (IOException unused) {
        }
        return String.valueOf(grs.O000000o(byteArrayOutputStream.toByteArray()));
    }

    public static String O00000Oo(long j) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeLong(f18189O000000o.nextLong());
            dataOutputStream.writeInt((int) (j / 60000));
            dataOutputStream.flush();
        } catch (IOException unused) {
        }
        return String.valueOf(grs.O000000o(byteArrayOutputStream.toByteArray()));
    }
}

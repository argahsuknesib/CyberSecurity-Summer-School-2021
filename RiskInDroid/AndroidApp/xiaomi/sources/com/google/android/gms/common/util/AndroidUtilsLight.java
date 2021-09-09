package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AndroidUtilsLight {
    public static MessageDigest getMessageDigest(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static byte[] getPackageCertificateHashBytes(Context context, String str) throws PackageManager.NameNotFoundException {
        return getPackageCertificateHashBytes(context, str, "SHA1");
    }

    public static byte[] getPackageCertificateHashBytes(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        MessageDigest messageDigest;
        PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
        if (packageInfo.signatures == null || packageInfo.signatures.length != 1 || (messageDigest = getMessageDigest(str2)) == null) {
            return null;
        }
        return messageDigest.digest(packageInfo.signatures[0].toByteArray());
    }
}

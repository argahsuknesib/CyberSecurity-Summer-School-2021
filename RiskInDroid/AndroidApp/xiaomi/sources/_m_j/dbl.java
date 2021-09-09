package _m_j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;

public class dbl {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f14453O000000o = "_m_j.dbl";

    public static boolean O000000o(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            if (signatureArr == null) {
                return false;
            }
            for (Signature byteArray : signatureArr) {
                if ("18da2bf10352443a00a5e046d9fca6bd".equals(dbu.O000000o(byteArray.toByteArray()))) {
                    dbt.O000000o(f14453O000000o, "check pass");
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}

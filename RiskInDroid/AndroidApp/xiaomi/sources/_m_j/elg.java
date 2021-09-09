package _m_j;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;

public final class elg {
    public static boolean O000000o() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Exception e) {
            duv.O000000o(e);
            return true;
        }
    }

    public static boolean O00000Oo() {
        try {
            return !Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            gsy.O000000o(6, "XMPush-", "check SDCard is busy: ".concat(String.valueOf(e)));
            return true;
        }
    }

    private static long O00000o() {
        File externalStorageDirectory;
        if (!O00000Oo() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && !TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            try {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static boolean O00000o0() {
        if (!O00000Oo()) {
            return !((O00000o() > 102400 ? 1 : (O00000o() == 102400 ? 0 : -1)) <= 0) && !O000000o();
        }
    }
}

package _m_j;

import android.text.TextUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class djc {
    private static SimpleDateFormat O00000o = new SimpleDateFormat("yy.MM.dd.HH");

    /* renamed from: O000000o  reason: collision with root package name */
    String f14712O000000o = "Tracer.File";
    int O00000Oo = 4096;
    int O00000o0 = 10;
    private int O00000oO = Integer.MAX_VALUE;
    private int O00000oo = Integer.MAX_VALUE;
    private long O0000O0o = 10000;
    private File O0000OOo;
    private long O0000Oo = Long.MAX_VALUE;
    private String O0000Oo0 = ".log";

    public djc(File file, int i, int i2, int i3, String str, long j, String str2, long j2) {
        this.O0000OOo = file;
        this.O00000oo = i;
        this.O00000oO = i2;
        this.O00000Oo = i3;
        this.f14712O000000o = str;
        this.O0000O0o = j;
        this.O00000o0 = 10;
        this.O0000Oo0 = str2;
        this.O0000Oo = j2;
    }

    /* access modifiers changed from: package-private */
    public final File[] O000000o(long j) {
        File file;
        File file2;
        File file3 = this.O0000OOo;
        if (file3 != null) {
            file3.mkdirs();
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        String str = "com.tencent.mobileqq_connectSdk." + new SimpleDateFormat("yy.MM.dd.HH").format(instance.getTime()) + ".log";
        try {
            file = new File(file3, str);
        } catch (Throwable th) {
            diz.O00000Oo("openSDK_LOG", "getWorkFile,get old sdcard file exception:", th);
            file = file3;
        }
        String O000000o2 = djp.O000000o();
        if (!TextUtils.isEmpty(O000000o2) || O000000o2 != null) {
            try {
                File file4 = new File(O000000o2, djd.O0000o0O);
                if (!file4.exists()) {
                    file4.mkdirs();
                }
                file2 = new File(file4, str);
            } catch (Exception e) {
                diz.O00000Oo("openSDK_LOG", "getWorkFile,get app specific file exception:", e);
            }
            return new File[]{file, file2};
        }
        file2 = null;
        return new File[]{file, file2};
    }
}

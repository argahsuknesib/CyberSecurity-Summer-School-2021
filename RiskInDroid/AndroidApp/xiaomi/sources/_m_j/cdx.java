package _m_j;

import android.content.Context;
import java.io.IOException;
import java.util.zip.ZipFile;

public class cdx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static cdx f13671O000000o;
    protected String[] O00000Oo;

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0059 A[SYNTHETIC, Splitter:B:30:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0065 A[SYNTHETIC, Splitter:B:37:0x0065] */
    public static String O000000o(Context context) {
        ZipFile zipFile;
        cdx cdx = f13671O000000o;
        if (cdx == null || cdx.O00000Oo == null) {
            return null;
        }
        try {
            zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
            int i = 0;
            while (i < f13671O000000o.O00000Oo.length) {
                try {
                    if (zipFile.getEntry("META-INF/michannel_" + f13671O000000o.O00000Oo[i]) != null) {
                        String str = f13671O000000o.O00000Oo[i];
                        try {
                            zipFile.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return str;
                    }
                    i++;
                } catch (IOException e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            try {
                zipFile.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (IOException e5) {
            e = e5;
            zipFile = null;
            e.printStackTrace();
            if (zipFile != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            zipFile = null;
            if (zipFile != null) {
            }
            throw th;
        }
        return null;
    }
}

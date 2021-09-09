package _m_j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;

public final class clh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f14063O000000o = false;

    public static synchronized void O000000o(final dty dty) {
        synchronized (clh.class) {
            if (!f14063O000000o) {
                f14063O000000o = true;
                new Thread() {
                    /* class _m_j.clh.AnonymousClass1 */

                    public final void run() {
                        clh.O00000Oo(dty);
                    }
                }.run();
            }
        }
    }

    public static void O00000Oo(dty dty) {
        File[] listFiles = new File(me.O000000o(dty.getDid())).listFiles(new FilenameFilter() {
            /* class _m_j.clh.AnonymousClass2 */

            public final boolean accept(File file, String str) {
                return str.endsWith(".tmp") || str.endsWith(".aac") || str.endsWith(".h264") || str.endsWith(".mp4");
            }
        });
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.getAbsolutePath().endsWith(".mp4")) {
                    long j = 0;
                    try {
                        if (file.exists()) {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            fileInputStream.close();
                            j = (long) fileInputStream.available();
                        }
                        if (j < 10240) {
                            file.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    file.delete();
                }
            }
        }
    }
}

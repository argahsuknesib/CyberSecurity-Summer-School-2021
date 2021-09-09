package _m_j;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class esw {
    private static final Set<String> O00000oO = Collections.synchronizedSet(new HashSet());

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f15780O000000o;
    private FileLock O00000Oo;
    private RandomAccessFile O00000o;
    private String O00000o0;

    private esw(Context context) {
        this.f15780O000000o = context;
    }

    /* JADX INFO: finally extract failed */
    public static esw O000000o(Context context, File file) {
        duv.O00000o0("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (O00000oO.add(str)) {
            esw esw = new esw(context);
            esw.O00000o0 = str;
            try {
                esw.O00000o = new RandomAccessFile(file2, "rw");
                esw.O00000Oo = esw.O00000o.getChannel().lock();
                duv.O00000o0("Locked: " + str + " :" + esw.O00000Oo);
                if (esw.O00000Oo == null) {
                    RandomAccessFile randomAccessFile = esw.O00000o;
                    if (randomAccessFile != null) {
                        ele.O000000o(randomAccessFile);
                    }
                    O00000oO.remove(esw.O00000o0);
                }
                return esw;
            } catch (Throwable th) {
                if (esw.O00000Oo == null) {
                    RandomAccessFile randomAccessFile2 = esw.O00000o;
                    if (randomAccessFile2 != null) {
                        ele.O000000o(randomAccessFile2);
                    }
                    O00000oO.remove(esw.O00000o0);
                }
                throw th;
            }
        } else {
            throw new IOException("abtain lock failure");
        }
    }

    public final void O000000o() {
        duv.O00000o0("unLock: " + this.O00000Oo);
        FileLock fileLock = this.O00000Oo;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.O00000Oo.release();
            } catch (IOException unused) {
            }
            this.O00000Oo = null;
        }
        RandomAccessFile randomAccessFile = this.O00000o;
        if (randomAccessFile != null) {
            ele.O000000o(randomAccessFile);
        }
        O00000oO.remove(this.O00000o0);
    }
}

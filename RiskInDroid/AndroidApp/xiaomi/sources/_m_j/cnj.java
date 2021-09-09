package _m_j;

import _m_j.cot;
import android.graphics.Bitmap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class cnj implements cni {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Bitmap.CompressFormat f14143O000000o = Bitmap.CompressFormat.PNG;
    protected final File O00000Oo;
    protected final cnp O00000o;
    protected final File O00000o0;
    protected int O00000oO = 32768;
    protected Bitmap.CompressFormat O00000oo = f14143O000000o;
    protected int O0000O0o = 100;

    public final void O000000o() {
    }

    public cnj(File file, File file2, cnp cnp) {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        } else if (cnp != null) {
            this.O00000Oo = file;
            this.O00000o0 = file2;
            this.O00000o = cnp;
        } else {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
    }

    public final File O000000o(String str) {
        return O00000Oo(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    public final boolean O000000o(String str, InputStream inputStream, cot.O000000o o000000o) throws IOException {
        boolean z;
        BufferedOutputStream bufferedOutputStream;
        File O00000Oo2 = O00000Oo(str);
        File file = new File(O00000Oo2.getAbsolutePath() + ".tmp");
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.O00000oO);
            z = cot.O000000o(inputStream, bufferedOutputStream, o000000o, this.O00000oO);
            try {
                cot.O000000o(bufferedOutputStream);
                if (z && !file.renameTo(O00000Oo2)) {
                    z = false;
                }
                if (!z) {
                    file.delete();
                }
                return z;
            } catch (Throwable th) {
                th = th;
                if (z && !file.renameTo(O00000Oo2)) {
                    z = false;
                }
                if (!z) {
                    file.delete();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
            z = false;
            if (!z) {
            }
            throw th;
        }
    }

    public final boolean O000000o(String str, Bitmap bitmap) throws IOException {
        File O00000Oo2 = O00000Oo(str);
        File file = new File(O00000Oo2.getAbsolutePath() + ".tmp");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.O00000oO);
        try {
            boolean compress = bitmap.compress(this.O00000oo, this.O0000O0o, bufferedOutputStream);
            cot.O000000o(bufferedOutputStream);
            if (compress && !file.renameTo(O00000Oo2)) {
                compress = false;
            }
            if (!compress) {
                file.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th) {
            cot.O000000o(bufferedOutputStream);
            file.delete();
            throw th;
        }
    }

    private File O00000Oo(String str) {
        File file;
        String O000000o2 = this.O00000o.O000000o(str);
        File file2 = this.O00000Oo;
        if (!file2.exists() && !this.O00000Oo.mkdirs() && (file = this.O00000o0) != null && (file.exists() || this.O00000o0.mkdirs())) {
            file2 = this.O00000o0;
        }
        return new File(file2, O000000o2);
    }
}

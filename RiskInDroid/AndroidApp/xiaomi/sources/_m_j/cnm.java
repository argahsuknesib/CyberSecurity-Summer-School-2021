package _m_j;

import _m_j.cnl;
import _m_j.cot;
import android.graphics.Bitmap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class cnm implements cni {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Bitmap.CompressFormat f14149O000000o = Bitmap.CompressFormat.PNG;
    protected cnl O00000Oo;
    protected int O00000o = 32768;
    protected final cnp O00000o0;
    protected Bitmap.CompressFormat O00000oO = f14149O000000o;
    protected int O00000oo = 100;
    private File O0000O0o;

    public cnm(File file, File file2, cnp cnp, long j, int i) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        } else if (j < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        } else if (i < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        } else if (cnp != null) {
            long j2 = j == 0 ? Long.MAX_VALUE : j;
            int i2 = i == 0 ? Integer.MAX_VALUE : i;
            this.O0000O0o = file2;
            this.O00000o0 = cnp;
            O000000o(file, file2, j2, i2);
        } else {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
    }

    private void O000000o(File file, File file2, long j, int i) throws IOException {
        try {
            this.O00000Oo = cnl.O000000o(file, j, i);
        } catch (IOException e) {
            cou.O000000o(e);
            if (file2 != null) {
                O000000o(file2, null, j, i);
            }
            if (this.O00000Oo == null) {
                throw e;
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [_m_j.cnl$O00000o0] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002e  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final File O000000o(String str) {
        Throwable th;
        cnl.O00000o0 o00000o0;
        ? r0 = 0;
        try {
            o00000o0 = this.O00000Oo.O000000o(O00000Oo(str));
            if (o00000o0 != null) {
                try {
                    r0 = o00000o0.f14148O000000o[0];
                } catch (IOException e) {
                    e = e;
                    try {
                        cou.O000000o(e);
                        if (o00000o0 != null) {
                            o00000o0.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        r0 = o00000o0;
                        th = th3;
                        if (r0 != 0) {
                        }
                        throw th;
                    }
                }
            }
            if (o00000o0 != null) {
                o00000o0.close();
            }
            return r0;
        } catch (IOException e2) {
            e = e2;
            o00000o0 = null;
            cou.O000000o(e);
            if (o00000o0 != null) {
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    public final boolean O000000o(String str, InputStream inputStream, cot.O000000o o000000o) throws IOException {
        cnl.O000000o O00000Oo2 = this.O00000Oo.O00000Oo(O00000Oo(str));
        if (O00000Oo2 == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(O00000Oo2.O000000o(), this.O00000o);
        try {
            boolean O000000o2 = cot.O000000o(inputStream, bufferedOutputStream, o000000o, this.O00000o);
            cot.O000000o(bufferedOutputStream);
            if (O000000o2) {
                O00000Oo2.O00000Oo();
            } else {
                O00000Oo2.O00000o0();
            }
            return O000000o2;
        } catch (Throwable th) {
            cot.O000000o(bufferedOutputStream);
            O00000Oo2.O00000o0();
            throw th;
        }
    }

    public final boolean O000000o(String str, Bitmap bitmap) throws IOException {
        cnl.O000000o O00000Oo2 = this.O00000Oo.O00000Oo(O00000Oo(str));
        if (O00000Oo2 == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(O00000Oo2.O000000o(), this.O00000o);
        try {
            boolean compress = bitmap.compress(this.O00000oO, this.O00000oo, bufferedOutputStream);
            if (compress) {
                O00000Oo2.O00000Oo();
            } else {
                O00000Oo2.O00000o0();
            }
            return compress;
        } finally {
            cot.O000000o(bufferedOutputStream);
        }
    }

    public final void O000000o() {
        try {
            this.O00000Oo.close();
        } catch (IOException e) {
            cou.O000000o(e);
        }
        this.O00000Oo = null;
    }

    private String O00000Oo(String str) {
        return this.O00000o0.O000000o(str);
    }
}

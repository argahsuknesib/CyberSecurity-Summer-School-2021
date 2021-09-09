package com.nostra13.universalimageloader.core;

import _m_j.cnv;
import _m_j.cnw;
import _m_j.cny;
import _m_j.cnz;
import _m_j.cod;
import _m_j.cog;
import _m_j.coh;
import _m_j.cok;
import _m_j.coo;
import _m_j.cop;
import _m_j.cot;
import _m_j.cou;
import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public final class LoadAndDisplayImageTask implements cot.O000000o, Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ImageLoaderConfiguration f5357O000000o;
    public final String O00000Oo;
    final cnw O00000o;
    final cok O00000o0;
    final coo O00000oO;
    final cop O00000oo;
    private final cny O0000O0o;
    private final cnz O0000OOo;
    private final ImageDownloader O0000Oo;
    private final Handler O0000Oo0;
    private final ImageDownloader O0000OoO;
    private final ImageDownloader O0000Ooo;
    private LoadedFrom O0000o = LoadedFrom.NETWORK;
    private final String O0000o0;
    private final cog O0000o00;
    private final cod O0000o0O;
    private final boolean O0000o0o;

    public LoadAndDisplayImageTask(cny cny, cnz cnz, Handler handler) {
        this.O0000O0o = cny;
        this.O0000OOo = cnz;
        this.O0000Oo0 = handler;
        this.f5357O000000o = cny.f14159O000000o;
        this.O0000Oo = this.f5357O000000o.O0000o0o;
        this.O0000OoO = this.f5357O000000o.O0000oO;
        this.O0000Ooo = this.f5357O000000o.O0000oOO;
        this.O0000o00 = this.f5357O000000o.O0000o;
        this.O00000Oo = cnz.f14161O000000o;
        this.O0000o0 = cnz.O00000Oo;
        this.O00000o0 = cnz.O00000o0;
        this.O0000o0O = cnz.O00000o;
        this.O00000o = cnz.O00000oO;
        this.O00000oO = cnz.O00000oo;
        this.O00000oo = cnz.O0000O0o;
        this.O0000o0o = this.O00000o.O0000oO;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:44|45|(2:47|(1:49)(1:50))|51|52) */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f8, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fc, code lost:
        if (r7.O0000o0o == false) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0102, code lost:
        if (O0000o0() != false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0105, code lost:
        O000000o(new com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.AnonymousClass3(r7), false, r7.O0000Oo0, r7.O0000O0o);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0114, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0115, code lost:
        r0.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0118, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x00fa */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cf A[Catch:{ TaskCancelledException -> 0x00fa }] */
    public final void run() {
        if (!O000000o() && !O00000Oo()) {
            ReentrantLock reentrantLock = this.O0000OOo.O0000OOo;
            cou.O000000o("Start display image task [%s]", this.O0000o0);
            if (reentrantLock.isLocked()) {
                cou.O000000o("Image already is loading. Waiting... [%s]", this.O0000o0);
            }
            reentrantLock.lock();
            O0000O0o();
            Bitmap O000000o2 = this.f5357O000000o.O0000o0.O000000o(this.O0000o0);
            if (O000000o2 != null) {
                if (!O000000o2.isRecycled()) {
                    this.O0000o = LoadedFrom.MEMORY_CACHE;
                    cou.O000000o("...Get cached bitmap from memory after waiting. [%s]", this.O0000o0);
                    if (O000000o2 != null && this.O00000o.O000000o()) {
                        cou.O000000o("PostProcess image before displaying [%s]", this.O0000o0);
                        O000000o2 = this.O00000o.O0000o0o.O000000o();
                        if (O000000o2 == null) {
                            cou.O00000o("Post-processor returned null [%s]", this.O0000o0);
                        }
                    }
                    O0000O0o();
                    O0000o00();
                    reentrantLock.unlock();
                    O000000o(new cnv(O000000o2, this.O0000OOo, this.O0000O0o, this.O0000o), this.O0000o0o, this.O0000Oo0, this.O0000O0o);
                }
            }
            O000000o2 = O00000o0();
            if (O000000o2 == null) {
                reentrantLock.unlock();
                return;
            }
            O0000O0o();
            O0000o00();
            if (this.O00000o.O0000o0O != null) {
                cou.O000000o("PreProcess image before caching in memory [%s]", this.O0000o0);
                O000000o2 = this.O00000o.O0000o0O.O000000o();
                if (O000000o2 == null) {
                    cou.O00000o("Pre-processor returned null [%s]", this.O0000o0);
                }
            }
            if (O000000o2 != null && this.O00000o.O0000OOo) {
                cou.O000000o("Cache image in memory [%s]", this.O0000o0);
                this.f5357O000000o.O0000o0.O000000o(this.O0000o0, O000000o2);
            }
            cou.O000000o("PostProcess image before displaying [%s]", this.O0000o0);
            O000000o2 = this.O00000o.O0000o0o.O000000o();
            if (O000000o2 == null) {
            }
            O0000O0o();
            O0000o00();
            reentrantLock.unlock();
            O000000o(new cnv(O000000o2, this.O0000OOo, this.O0000O0o, this.O0000o), this.O0000o0o, this.O0000Oo0, this.O0000O0o);
        }
    }

    private boolean O000000o() {
        AtomicBoolean atomicBoolean = this.O0000O0o.O0000O0o;
        if (atomicBoolean.get()) {
            synchronized (this.O0000O0o.O0000Oo) {
                if (atomicBoolean.get()) {
                    cou.O000000o("ImageLoader is paused. Waiting...  [%s]", this.O0000o0);
                    try {
                        this.O0000O0o.O0000Oo.wait();
                        cou.O000000o(".. Resume loading [%s]", this.O0000o0);
                    } catch (InterruptedException unused) {
                        cou.O00000o("Task was interrupted [%s]", this.O0000o0);
                        return true;
                    }
                }
            }
        }
        return O0000OOo();
    }

    private boolean O00000Oo() {
        if (!(this.O00000o.O0000Ooo > 0)) {
            return false;
        }
        cou.O000000o("Delay %d ms before loading...  [%s]", Integer.valueOf(this.O00000o.O0000Ooo), this.O0000o0);
        try {
            Thread.sleep((long) this.O00000o.O0000Ooo);
            return O0000OOo();
        } catch (InterruptedException unused) {
            cou.O00000o("Task was interrupted [%s]", this.O0000o0);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r1.getHeight() > 0) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cb, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ca A[ExcHandler: TaskCancelledException (r0v1 'e' com.nostra13.universalimageloader.core.LoadAndDisplayImageTask$TaskCancelledException A[CUSTOM_DECLARE]), Splitter:B:1:0x0001] */
    private Bitmap O00000o0() throws TaskCancelledException {
        Bitmap bitmap;
        File O000000o2;
        try {
            File O000000o3 = this.f5357O000000o.O0000o0O.O000000o(this.O00000Oo);
            if (O000000o3 == null || !O000000o3.exists() || O000000o3.length() <= 0) {
                bitmap = null;
            } else {
                cou.O000000o("Load image from disk cache [%s]", this.O0000o0);
                this.O0000o = LoadedFrom.DISC_CACHE;
                O0000O0o();
                bitmap = O000000o(ImageDownloader.Scheme.FILE.wrap(O000000o3.getAbsolutePath()));
            }
            if (bitmap != null) {
                if (bitmap.getWidth() > 0) {
                }
            }
            cou.O000000o("Load image from network [%s]", this.O0000o0);
            this.O0000o = LoadedFrom.NETWORK;
            String str = this.O00000Oo;
            if (this.O00000o.O0000Oo0 && O00000o() && (O000000o2 = this.f5357O000000o.O0000o0O.O000000o(this.O00000Oo)) != null) {
                str = ImageDownloader.Scheme.FILE.wrap(O000000o2.getAbsolutePath());
            }
            O0000O0o();
            bitmap = O000000o(str);
            if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                O000000o(FailReason.FailType.DECODING_ERROR, (Throwable) null);
            }
        } catch (IllegalStateException unused) {
            bitmap = null;
            O000000o(FailReason.FailType.NETWORK_DENIED, (Throwable) null);
            return bitmap;
        } catch (TaskCancelledException e) {
        } catch (IOException e2) {
            IOException iOException = e2;
            bitmap = null;
            IOException e3 = iOException;
            cou.O000000o(e3);
            O000000o(FailReason.FailType.IO_ERROR, e3);
            return bitmap;
        } catch (OutOfMemoryError e4) {
            OutOfMemoryError outOfMemoryError = e4;
            bitmap = null;
            OutOfMemoryError e5 = outOfMemoryError;
            cou.O000000o(e5);
            O000000o(FailReason.FailType.OUT_OF_MEMORY, e5);
            return bitmap;
        } catch (Throwable th) {
            Throwable th2 = th;
            bitmap = null;
            Throwable th3 = th2;
            cou.O000000o(th3);
            O000000o(FailReason.FailType.UNKNOWN, th3);
            return bitmap;
        }
        return bitmap;
    }

    private Bitmap O000000o(String str) throws IOException {
        String str2 = str;
        return this.O0000o00.O000000o(new coh(this.O0000o0, str2, this.O00000Oo, this.O0000o0O, this.O00000o0.O00000o0(), O00000oo(), this.O00000o));
    }

    private boolean O00000o() throws TaskCancelledException {
        cou.O000000o("Cache image on disk [%s]", this.O0000o0);
        try {
            boolean O00000oO2 = O00000oO();
            if (!O00000oO2) {
                return O00000oO2;
            }
            int i = this.f5357O000000o.O00000o;
            int i2 = this.f5357O000000o.O00000oO;
            if (i <= 0 && i2 <= 0) {
                return O00000oO2;
            }
            cou.O000000o("Resize image in disk cache [%s]", this.O0000o0);
            File O000000o2 = this.f5357O000000o.O0000o0O.O000000o(this.O00000Oo);
            if (O000000o2 == null || !O000000o2.exists()) {
                return O00000oO2;
            }
            cod cod = new cod(i, i2);
            cnw.O000000o o000000o = new cnw.O000000o();
            cnw cnw = this.O00000o;
            o000000o.f14157O000000o = cnw.f14156O000000o;
            o000000o.O00000Oo = cnw.O00000Oo;
            o000000o.O00000o0 = cnw.O00000o0;
            o000000o.O00000o = cnw.O00000o;
            o000000o.O00000oO = cnw.O00000oO;
            o000000o.O00000oo = cnw.O00000oo;
            o000000o.O0000O0o = cnw.O0000O0o;
            o000000o.O0000OOo = cnw.O0000OOo;
            o000000o.O0000Oo0 = cnw.O0000Oo0;
            o000000o.O0000Oo = cnw.O0000Oo;
            o000000o.O0000OoO = cnw.O0000OoO;
            o000000o.O0000Ooo = cnw.O0000Ooo;
            o000000o.O0000o00 = cnw.O0000o00;
            o000000o.O0000o0 = cnw.O0000o0;
            o000000o.O0000o0O = cnw.O0000o0O;
            o000000o.O0000o0o = cnw.O0000o0o;
            o000000o.O0000o = cnw.O0000o;
            o000000o.O0000oO0 = cnw.O0000oO0;
            o000000o.O0000oO = cnw.O0000oO;
            o000000o.O0000Oo = ImageScaleType.IN_SAMPLE_INT;
            Bitmap O000000o3 = this.O0000o00.O000000o(new coh(this.O0000o0, ImageDownloader.Scheme.FILE.wrap(O000000o2.getAbsolutePath()), this.O00000Oo, cod, ViewScaleType.FIT_INSIDE, O00000oo(), o000000o.O000000o()));
            if (!(O000000o3 == null || this.f5357O000000o.O00000oo == null)) {
                cou.O000000o("Process image before cache on disk [%s]", this.O0000o0);
                O000000o3 = this.f5357O000000o.O00000oo.O000000o();
                if (O000000o3 == null) {
                    cou.O00000o("Bitmap processor for disk cache returned null [%s]", this.O0000o0);
                }
            }
            if (O000000o3 == null) {
                return O00000oO2;
            }
            this.f5357O000000o.O0000o0O.O000000o(this.O00000Oo, O000000o3);
            O000000o3.recycle();
            return O00000oO2;
        } catch (IOException e) {
            cou.O000000o(e);
            return false;
        }
    }

    private boolean O00000oO() throws IOException {
        InputStream stream = O00000oo().getStream(this.O00000Oo, this.O00000o.O0000o0);
        if (stream == null) {
            cou.O00000o("No stream for image [%s]", this.O0000o0);
            return false;
        }
        try {
            return this.f5357O000000o.O0000o0O.O000000o(this.O00000Oo, stream, this);
        } finally {
            cot.O000000o(stream);
        }
    }

    public final boolean O000000o(final int i, final int i2) {
        boolean z;
        if (!this.O0000o0o) {
            if (O0000o0() || O0000OOo()) {
                z = false;
            } else {
                if (this.O00000oo != null) {
                    O000000o(new Runnable() {
                        /* class com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.AnonymousClass1 */

                        public final void run() {
                            LoadAndDisplayImageTask.this.O00000o0.O00000o();
                        }
                    }, false, this.O0000Oo0, this.O0000O0o);
                }
                z = true;
            }
            return z;
        }
    }

    private void O000000o(final FailReason.FailType failType, final Throwable th) {
        if (!this.O0000o0o && !O0000o0() && !O0000OOo()) {
            O000000o(new Runnable() {
                /* class com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.AnonymousClass2 */

                public final void run() {
                    cnw cnw = LoadAndDisplayImageTask.this.O00000o;
                    if ((cnw.O00000oo == null && cnw.O00000o0 == 0) ? false : true) {
                        cok cok = LoadAndDisplayImageTask.this.O00000o0;
                        cnw cnw2 = LoadAndDisplayImageTask.this.O00000o;
                        cok.O000000o(cnw2.O00000o0 != 0 ? LoadAndDisplayImageTask.this.f5357O000000o.f5352O000000o.getDrawable(cnw2.O00000o0) : cnw2.O00000oo);
                    }
                    LoadAndDisplayImageTask.this.O00000oO.onLoadingFailed(LoadAndDisplayImageTask.this.O00000Oo, LoadAndDisplayImageTask.this.O00000o0.O00000o(), new FailReason(failType, th));
                }
            }, false, this.O0000Oo0, this.O0000O0o);
        }
    }

    private ImageDownloader O00000oo() {
        if (this.O0000O0o.O0000OOo.get()) {
            return this.O0000OoO;
        }
        if (this.O0000O0o.O0000Oo0.get()) {
            return this.O0000Ooo;
        }
        return this.O0000Oo;
    }

    private void O0000O0o() throws TaskCancelledException {
        O0000Oo0();
        O0000OoO();
    }

    private boolean O0000OOo() {
        return O0000Oo() || O0000Ooo();
    }

    private void O0000Oo0() throws TaskCancelledException {
        if (O0000Oo()) {
            throw new TaskCancelledException();
        }
    }

    private boolean O0000Oo() {
        if (!this.O00000o0.O00000oO()) {
            return false;
        }
        cou.O000000o("ImageAware was collected by GC. Task is cancelled. [%s]", this.O0000o0);
        return true;
    }

    private void O0000OoO() throws TaskCancelledException {
        if (O0000Ooo()) {
            throw new TaskCancelledException();
        }
    }

    private boolean O0000Ooo() {
        if (!(!this.O0000o0.equals(this.O0000O0o.O000000o(this.O00000o0)))) {
            return false;
        }
        cou.O000000o("ImageAware is reused for another image. Task is cancelled. [%s]", this.O0000o0);
        return true;
    }

    private void O0000o00() throws TaskCancelledException {
        if (O0000o0()) {
            throw new TaskCancelledException();
        }
    }

    private boolean O0000o0() {
        if (!Thread.interrupted()) {
            return false;
        }
        cou.O000000o("Task was interrupted [%s]", this.O0000o0);
        return true;
    }

    public static void O000000o(Runnable runnable, boolean z, Handler handler, cny cny) {
        if (z) {
            runnable.run();
        } else if (handler == null) {
            cny.O000000o(runnable);
        } else {
            handler.post(runnable);
        }
    }

    class TaskCancelledException extends Exception {
        TaskCancelledException() {
        }
    }
}

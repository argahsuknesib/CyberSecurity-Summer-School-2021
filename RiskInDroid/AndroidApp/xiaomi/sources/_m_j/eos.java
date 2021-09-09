package _m_j;

import _m_j.elo;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.hx;
import com.xiaomi.push.service.at;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public abstract class eos extends elo.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f15682O000000o;
    protected Context O00000Oo;

    public eos(Context context, int i) {
        this.f15682O000000o = i;
        this.O00000Oo = context;
    }

    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:32|33|38|39|(0)|46|47|23|48|49) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|(3:16|17|(2:19|20))|21|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:50|51|52|(2:56|57)|58|59|60) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x0090 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x00a4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0087 A[SYNTHETIC, Splitter:B:41:0x0087] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:46:0x0090=Splitter:B:46:0x0090, B:38:0x0082=Splitter:B:38:0x0082, B:21:0x0064=Splitter:B:21:0x0064, B:58:0x00a4=Splitter:B:58:0x00a4} */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static void O000000o(Context context, hx hxVar, String str) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        BufferedOutputStream bufferedOutputStream;
        byte[] O00000Oo2 = eon.O00000Oo(str, eru.O000000o(hxVar));
        if (O00000Oo2 != null && O00000Oo2.length != 0) {
            synchronized (eoo.f15679O000000o) {
                ? r0 = 0;
                try {
                    File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    ele.O00000o0(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                    } catch (IOException e) {
                        e = e;
                        bufferedOutputStream = null;
                        try {
                            e.printStackTrace();
                            if (r0 != 0) {
                            }
                            ele.O000000o(bufferedOutputStream);
                            ele.O000000o(randomAccessFile);
                        } catch (Throwable th) {
                            th = th;
                            fileLock = r0;
                            r0 = bufferedOutputStream;
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            ele.O000000o((Closeable) r0);
                            ele.O000000o(randomAccessFile);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileLock = null;
                        fileLock.release();
                        ele.O000000o((Closeable) r0);
                        ele.O000000o(randomAccessFile);
                        throw th;
                    }
                    try {
                        File file2 = new File(context.getExternalFilesDir(null), "push_cdata.data");
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, true));
                        try {
                            bufferedOutputStream.write(eli.O000000o(O00000Oo2.length));
                            bufferedOutputStream.write(O00000Oo2);
                            bufferedOutputStream.flush();
                            file2.setLastModified(0);
                            if (fileLock != null) {
                                if (fileLock.isValid()) {
                                    fileLock.release();
                                }
                            }
                            ele.O000000o(bufferedOutputStream);
                        } catch (IOException e2) {
                            e = e2;
                            r0 = fileLock;
                            e.printStackTrace();
                            if (r0 != 0) {
                            }
                            ele.O000000o(bufferedOutputStream);
                            ele.O000000o(randomAccessFile);
                        } catch (Throwable th3) {
                            th = th3;
                            r0 = bufferedOutputStream;
                            fileLock.release();
                            ele.O000000o((Closeable) r0);
                            ele.O000000o(randomAccessFile);
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedOutputStream = null;
                        r0 = fileLock;
                        e.printStackTrace();
                        if (r0 != 0) {
                            if (r0.isValid()) {
                                r0.release();
                            }
                        }
                        ele.O000000o(bufferedOutputStream);
                        ele.O000000o(randomAccessFile);
                    } catch (Throwable th4) {
                        th = th4;
                        fileLock.release();
                        ele.O000000o((Closeable) r0);
                        ele.O000000o(randomAccessFile);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                    e.printStackTrace();
                    if (r0 != 0) {
                    }
                    ele.O000000o(bufferedOutputStream);
                    ele.O000000o(randomAccessFile);
                } catch (Throwable th5) {
                    th = th5;
                    fileLock = null;
                    randomAccessFile = null;
                    fileLock.release();
                    ele.O000000o((Closeable) r0);
                    ele.O000000o(randomAccessFile);
                    throw th;
                }
                ele.O000000o(randomAccessFile);
            }
        }
    }

    public abstract String O000000o();

    public abstract hr O00000Oo();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.at.a(int, boolean):boolean
     arg types: [int, int]
     candidates:
      com.xiaomi.push.service.at.a(int, int):int
      com.xiaomi.push.service.at.a(com.xiaomi.push.hv, int):int
      com.xiaomi.push.service.at.a(int, long):long
      com.xiaomi.push.service.at.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.at.a(java.util.List<android.util.Pair<com.xiaomi.push.hv, java.lang.Integer>>, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>):void
      com.xiaomi.push.service.at.a(int, boolean):boolean */
    public void run() {
        String O000000o2 = O000000o();
        if (!TextUtils.isEmpty(O000000o2)) {
            Context context = this.O00000Oo;
            String valueOf = String.valueOf(a());
            long j = (long) this.f15682O000000o;
            boolean z = false;
            if (at.a(context).a(hu.aY.a(), false) && ((Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !elm.O000000o(context, valueOf, j))) {
                z = true;
            }
            if (z) {
                duv.O000000o("DC run job mutual: " + a());
                return;
            }
            eol eol = eom.O000000o().f15678O000000o;
            String O000000o3 = eol == null ? "" : eol.O000000o();
            if (!TextUtils.isEmpty(O000000o3)) {
                hx hxVar = new hx();
                hxVar.f64a = O000000o2;
                hxVar.O000000o(System.currentTimeMillis());
                hxVar.f63a = O00000Oo();
                O000000o(this.O00000Oo, hxVar, O000000o3);
            }
        }
    }

    public static void O000000o(Context context, hx hxVar) {
        eol eol = eom.O000000o().f15678O000000o;
        String O000000o2 = eol == null ? "" : eol.O000000o();
        if (!TextUtils.isEmpty(O000000o2) && !TextUtils.isEmpty(hxVar.f64a)) {
            O000000o(context, hxVar, O000000o2);
        }
    }
}

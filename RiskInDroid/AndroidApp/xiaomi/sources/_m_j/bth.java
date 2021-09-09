package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.loc.cg;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

public class bth {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public static WeakReference<btb> f13268O000000o;

    public static void O000000o(final Context context) {
        bsf.O00000o().submit(new Runnable() {
            /* class _m_j.bth.AnonymousClass2 */

            public final void run() {
                try {
                    btb O000000o2 = bti.O000000o(bth.f13268O000000o);
                    bti.O000000o(context, O000000o2, bsd.O0000OOo, 1000, 307200, "2");
                    if (O000000o2.O0000O0o == null) {
                        O000000o2.O0000O0o = new btj(new btn(context, new btk(new bto(new btr()))));
                    }
                    O000000o2.O0000OOo = 3600000;
                    if (TextUtils.isEmpty(O000000o2.O0000Oo0)) {
                        O000000o2.O0000Oo0 = "cKey";
                    }
                    if (O000000o2.O00000oo == null) {
                        O000000o2.O00000oo = new btv(context, O000000o2.O0000OOo, O000000o2.O0000Oo0, new bts(30, O000000o2.f13260O000000o, new cg(context)));
                    }
                    btc.O000000o(O000000o2);
                } catch (Throwable th) {
                    bsf.O00000Oo(th, "stm", "usd");
                }
            }
        });
    }

    static /* synthetic */ void O000000o(Context context, byte[] bArr) throws IOException {
        btb O000000o2 = bti.O000000o(f13268O000000o);
        bti.O000000o(context, O000000o2, bsd.O0000OOo, 1000, 307200, "2");
        if (O000000o2.O00000oO == null) {
            O000000o2.O00000oO = new bry();
        }
        Random random = new Random();
        try {
            btc.O000000o(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, O000000o2);
        } catch (Throwable th) {
            bsf.O00000Oo(th, "stm", "wts");
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000d */
    public static synchronized void O000000o(final List<btg> list, final Context context) {
        synchronized (bth.class) {
            if (list.size() == 0) {
                return;
            }
            bsf.O00000o().submit(new Runnable() {
                /* class _m_j.bth.AnonymousClass1 */

                /* JADX WARNING: Removed duplicated region for block: B:30:0x0048 A[SYNTHETIC, Splitter:B:30:0x0048] */
                /* JADX WARNING: Removed duplicated region for block: B:39:0x0058 A[SYNTHETIC, Splitter:B:39:0x0058] */
                public final void run() {
                    ByteArrayOutputStream byteArrayOutputStream;
                    Throwable th;
                    try {
                        synchronized (bth.class) {
                            byte[] bArr = new byte[0];
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    for (btg btg : list) {
                                        if (btg != null) {
                                            byteArrayOutputStream.write(btg.O000000o());
                                        }
                                    }
                                    bArr = byteArrayOutputStream.toByteArray();
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    try {
                                        bsf.O00000Oo(th, "stm", "aStB");
                                        if (byteArrayOutputStream != null) {
                                        }
                                        bth.O000000o(context, bArr);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        if (byteArrayOutputStream != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Throwable th5) {
                                byteArrayOutputStream = null;
                                th = th5;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable th6) {
                                        th6.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                            bth.O000000o(context, bArr);
                        }
                        th.printStackTrace();
                        bth.O000000o(context, bArr);
                    } catch (Throwable th7) {
                        bsf.O00000Oo(th7, "stm", "apb");
                    }
                }
            });
        }
    }
}

package com.amap.api.services.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.a.bq;

public class aa {

    /* renamed from: a  reason: collision with root package name */
    public static by f3268a;
    private static aa b;
    /* access modifiers changed from: private */
    public static Context c;
    /* access modifiers changed from: private */
    public a d;
    private HandlerThread e = new HandlerThread("manifestThread") {
        /* class com.amap.api.services.a.aa.AnonymousClass1 */

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
            if (com.amap.api.services.a.aa.a(r7.f3269a) == null) goto L_0x005c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
            com.amap.api.services.a.aa.a(r7.f3269a).sendMessage(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            java.lang.Thread.sleep(10000);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
            r0.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
            if (com.amap.api.services.a.aa.a(r7.f3269a) != null) goto L_0x0053;
         */
        public void run() {
            Thread.currentThread().setName("ManifestConfigThread");
            Message message = new Message();
            try {
                bq.a a2 = bq.a(aa.c, r.a(false), "11K;001", null);
                if (!(a2 == null || a2.x == null)) {
                    message.obj = new ab(a2.x.b, a2.x.f3343a);
                }
                message.what = 3;
            } catch (Throwable th) {
                message.what = 3;
                if (aa.this.d != null) {
                    aa.this.d.sendMessage(message);
                }
                throw th;
            }
        }
    };

    private aa(Context context) {
        c = context;
        f3268a = r.a(false);
        try {
            this.d = new a(Looper.getMainLooper());
            this.e.start();
        } catch (Throwable th) {
            s.a(th, "ManifestConfig", "ManifestConfig");
        }
    }

    public static aa a(Context context) {
        if (b == null) {
            b = new aa(context);
        }
        return b;
    }

    class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        String f3270a = "handleMessage";

        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    ab abVar = (ab) message.obj;
                    if (abVar == null) {
                        abVar = new ab(false, false);
                    }
                    cl.a(aa.c, r.a(abVar.a()));
                    aa.f3268a = r.a(abVar.a());
                } catch (Throwable th) {
                    s.a(th, "ManifestConfig", this.f3270a);
                }
            }
        }
    }
}

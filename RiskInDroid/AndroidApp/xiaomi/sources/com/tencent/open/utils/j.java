package com.tencent.open.utils;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class j {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Executor f5879O000000o = O00000Oo();
    private static Object O00000Oo = new Object();
    private static HandlerThread O00000o;
    private static Handler O00000o0;

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.concurrent.Executor] */
    /* JADX WARNING: Multi-variable type inference failed */
    private static Executor O00000Oo() {
        ThreadPoolExecutor threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 11) {
            threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
        } else {
            try {
                Field declaredField = AsyncTask.class.getDeclaredField("sExecutor");
                declaredField.setAccessible(true);
                threadPoolExecutor = (Executor) declaredField.get(null);
            } catch (Exception unused) {
                threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
        }
        if (threadPoolExecutor instanceof ThreadPoolExecutor) {
            threadPoolExecutor.setCorePoolSize(3);
        }
        return threadPoolExecutor;
    }

    private static Handler O00000o0() {
        if (O00000o0 == null) {
            synchronized (j.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                O00000o = handlerThread;
                handlerThread.start();
                O00000o0 = new Handler(O00000o.getLooper());
            }
        }
        return O00000o0;
    }

    public static void O000000o(Runnable runnable) {
        O00000o0().post(runnable);
    }

    public static Executor O000000o() {
        return new a();
    }

    static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final Queue<Runnable> f5880a;
        Runnable b;

        private a() {
            this.f5880a = new LinkedList();
        }

        public synchronized void execute(final Runnable runnable) {
            this.f5880a.offer(new Runnable() {
                /* class com.tencent.open.utils.j.a.AnonymousClass1 */

                public final void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void a() {
            Runnable poll = this.f5880a.poll();
            this.b = poll;
            if (poll != null) {
                j.f5879O000000o.execute(this.b);
            }
        }
    }
}

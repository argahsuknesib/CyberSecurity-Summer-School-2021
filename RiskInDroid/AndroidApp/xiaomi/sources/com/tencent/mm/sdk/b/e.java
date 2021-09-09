package com.tencent.mm.sdk.b;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mm.sdk.b.g;
import junit.framework.Assert;

final class e extends Handler implements g.a {
    private Looper aN = getLooper();
    private Handler.Callback aO;
    a aP;

    public interface a {
        void a(Runnable runnable, g gVar);

        void b(Runnable runnable, g gVar);
    }

    e(Looper looper, a aVar) {
        super(looper);
        this.aP = aVar;
    }

    e(a aVar) {
        this.aP = aVar;
    }

    public final void c(Runnable runnable, g gVar) {
        a aVar = this.aP;
        if (aVar != null) {
            aVar.b(runnable, gVar);
        }
    }

    public final void dispatchMessage(Message message) {
        if (message.getCallback() == null && this.aO == null) {
            System.currentTimeMillis();
            Debug.threadCpuTimeNanos();
            handleMessage(message);
            if (this.aP != null) {
                this.aN.getThread();
                System.currentTimeMillis();
                Debug.threadCpuTimeNanos();
                return;
            }
            return;
        }
        super.dispatchMessage(message);
    }

    public final void handleMessage(Message message) {
    }

    public final boolean sendMessageAtTime(Message message, long j) {
        a aVar;
        Assert.assertTrue("msg is null", message != null);
        Runnable callback = message.getCallback();
        if (callback == null) {
            return super.sendMessageAtTime(message, j);
        }
        long uptimeMillis = j - SystemClock.uptimeMillis();
        g gVar = new g(this.aN.getThread(), message.getTarget() == null ? this : message.getTarget(), callback, message.obj, this);
        if (uptimeMillis > 0) {
            gVar.aY = uptimeMillis;
        }
        Message obtain = Message.obtain(message.getTarget(), gVar);
        obtain.what = message.what;
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.obj = message.obj;
        obtain.replyTo = message.replyTo;
        obtain.setData(message.getData());
        message.recycle();
        a aVar2 = this.aP;
        if (aVar2 != null) {
            aVar2.a(callback, gVar);
        }
        boolean sendMessageAtTime = super.sendMessageAtTime(obtain, j);
        if (!sendMessageAtTime && (aVar = this.aP) != null) {
            aVar.b(callback, gVar);
        }
        return sendMessageAtTime;
    }

    public final String toString() {
        return "MMInnerHandler{listener = " + this.aP + "}";
    }
}

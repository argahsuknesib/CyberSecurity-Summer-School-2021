package _m_j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.LinkedList;

public class gaz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f17475O000000o = "gaz";
    private static final Object O00000Oo = new Object();
    private static final LinkedList<Runnable> O00000o = new LinkedList<>();
    private static Object O00000o0 = new Object();
    private static Handler O00000oO = null;
    private static final LinkedList<Runnable> O00000oo = new LinkedList<>();
    private static boolean O0000O0o = true;
    private static final gay O0000OOo = new gay();
    private static int O0000Oo0 = 0;

    private static Handler O00000Oo() {
        Handler handler;
        synchronized (O00000Oo) {
            if (O00000oO == null) {
                HandlerThread handlerThread = new HandlerThread("queued-work-looper", -2);
                handlerThread.start();
                O00000oO = new O000000o(handlerThread.getLooper());
            }
            handler = O00000oO;
        }
        return handler;
    }

    public static void O000000o(Runnable runnable) {
        synchronized (O00000Oo) {
            O00000o.add(runnable);
        }
    }

    public static void O00000Oo(Runnable runnable) {
        synchronized (O00000Oo) {
            O00000o.remove(runnable);
        }
    }

    public static void O000000o(Runnable runnable, boolean z) {
        Handler O00000Oo2 = O00000Oo();
        synchronized (O00000Oo) {
            O00000oo.add(runnable);
            if (!z || !O0000O0o) {
                O00000Oo2.sendEmptyMessage(1);
            } else {
                O00000Oo2.sendEmptyMessageDelayed(1, 100);
            }
        }
    }

    public static void O000000o() {
        LinkedList linkedList;
        synchronized (O00000o0) {
            synchronized (O00000Oo) {
                linkedList = (LinkedList) O00000oo.clone();
                O00000oo.clear();
                O00000Oo().removeMessages(1);
            }
            if (linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        }
    }

    static class O000000o extends Handler {
        O000000o(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                gaz.O000000o();
            }
        }
    }
}

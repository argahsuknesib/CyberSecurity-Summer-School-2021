package _m_j;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;

public class eso {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile Handler f15774O000000o;
    private static volatile Handler O00000Oo;
    private static final Object O00000o0 = new Object();

    public static Handler O000000o() {
        if (O00000Oo == null) {
            synchronized (O00000o0) {
                if (O00000Oo == null) {
                    HandlerThread handlerThread = new HandlerThread("receiver_task");
                    handlerThread.start();
                    O00000Oo = new Handler(handlerThread.getLooper());
                }
            }
        }
        return O00000Oo;
    }

    private static Handler O00000Oo() {
        if (f15774O000000o == null) {
            synchronized (eso.class) {
                if (f15774O000000o == null) {
                    HandlerThread handlerThread = new HandlerThread("handle_receiver");
                    handlerThread.start();
                    f15774O000000o = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f15774O000000o;
    }

    public static Intent O000000o(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (context == null) {
            return null;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, null, O00000Oo());
    }

    public static void O000000o(Context context, Class<?> cls) {
        if (context != null) {
            O00000Oo().post(new esp(context, new ComponentName(context, cls)));
        }
    }
}

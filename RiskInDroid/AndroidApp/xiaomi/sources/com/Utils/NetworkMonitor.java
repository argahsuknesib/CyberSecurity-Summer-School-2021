package com.Utils;

import _m_j.ckh;
import _m_j.gsy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class NetworkMonitor extends BroadcastReceiver {
    private static volatile NetworkMonitor O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    private int f3113O000000o = 0;
    private WeakReference<Context> O00000o;
    private CopyOnWriteArraySet<O000000o> O00000o0 = new CopyOnWriteArraySet<>();

    public interface O000000o {
        void onChange(int i);

        void onConnected(int i);

        void onConnecting(int i);

        void onDisconnected(int i);
    }

    public static NetworkMonitor O000000o() {
        synchronized (NetworkMonitor.class) {
            if (O00000Oo == null) {
                O00000Oo = new NetworkMonitor();
            }
        }
        return O00000Oo;
    }

    private NetworkMonitor() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ckh.O000000o().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.f3113O000000o = activeNetworkInfo.getType();
        }
    }

    public final void O000000o(O000000o o000000o) {
        if (o000000o != null) {
            this.O00000o0.add(o000000o);
        }
    }

    public final void O00000Oo(O000000o o000000o) {
        this.O00000o0.remove(o000000o);
    }

    public final void O000000o(Context context) {
        Context applicationContext = context.getApplicationContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        applicationContext.registerReceiver(this, intentFilter);
        this.O00000o = new WeakReference<>(applicationContext);
    }

    public final void O00000Oo() {
        Context context;
        WeakReference<Context> weakReference = this.O00000o;
        if (weakReference != null && (context = weakReference.get()) != null) {
            try {
                context.unregisterReceiver(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (this.O00000o0.isEmpty()) {
            gsy.O000000o(3, "NetworkMonitor", "NetworkMonitor.onReceive, mListener is empty");
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction())) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                gsy.O000000o(3, "NetworkMonitor", "NetworkMonitor.onReceive, disconnected");
                Iterator<O000000o> it = this.O00000o0.iterator();
                while (it.hasNext()) {
                    it.next().onDisconnected(-1);
                }
                this.f3113O000000o = -1;
                return;
            }
            int type = activeNetworkInfo.getType();
            int i = this.f3113O000000o;
            if (!(type == i || i == -1)) {
                gsy.O000000o(3, "NetworkMonitor", "NetworkMonitor.onReceive, connected, type = ".concat(String.valueOf(type)));
                Iterator<O000000o> it2 = this.O00000o0.iterator();
                while (it2.hasNext()) {
                    it2.next().onChange(type);
                }
            }
            if (activeNetworkInfo.isConnected()) {
                if (this.f3113O000000o != type) {
                    gsy.O000000o(3, "NetworkMonitor", "NetworkMonitor.onReceive, connected, type = ".concat(String.valueOf(type)));
                    Iterator<O000000o> it3 = this.O00000o0.iterator();
                    while (it3.hasNext()) {
                        it3.next().onConnected(type);
                    }
                } else {
                    return;
                }
            } else if (activeNetworkInfo.isConnectedOrConnecting()) {
                if (this.f3113O000000o != type) {
                    gsy.O000000o(3, "NetworkMonitor", "NetworkMonitor.onReceive, connecting, type = ".concat(String.valueOf(type)));
                    Iterator<O000000o> it4 = this.O00000o0.iterator();
                    while (it4.hasNext()) {
                        it4.next().onConnecting(type);
                    }
                } else {
                    return;
                }
            } else if (this.f3113O000000o != type) {
                gsy.O000000o(3, "NetworkMonitor", "NetworkMonitor.onReceive, disconnected, type = ".concat(String.valueOf(type)));
                Iterator<O000000o> it5 = this.O00000o0.iterator();
                while (it5.hasNext()) {
                    it5.next().onDisconnected(type);
                }
            } else {
                return;
            }
            this.f3113O000000o = type;
        }
    }
}

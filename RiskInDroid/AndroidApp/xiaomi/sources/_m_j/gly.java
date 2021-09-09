package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.smarthome.library.bluetooth.connect.IBleConnectObserver;
import java.util.ArrayList;
import java.util.List;

public class gly implements IBleConnectObserver {
    private static volatile gly O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    List<O000000o> f18003O000000o = new ArrayList();
    private Handler O00000o = new Handler(Looper.getMainLooper());
    private O00000Oo O00000o0;

    private gly() {
        if (this.O00000o0 == null) {
            this.O00000o0 = new O00000Oo(this, (byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.xiaomi.smarthome.bluetooth.connect_status_changed");
            intentFilter.addAction("com.xiaomi.smarthome.bluetooth.character_changed");
            gnl.O000000o(this.O00000o0, intentFilter);
        }
    }

    public final void O000000o(String str) {
        O000000o o000000o;
        int i = 0;
        while (true) {
            if (i >= this.f18003O000000o.size()) {
                o000000o = null;
                break;
            } else if (this.f18003O000000o.get(i).f18005O000000o.equals(str)) {
                o000000o = this.f18003O000000o.remove(i);
                break;
            } else {
                i++;
            }
        }
        if (o000000o == null) {
            o000000o = new O000000o(str);
        }
        this.f18003O000000o.add(0, o000000o);
        if (this.f18003O000000o.size() > 5) {
            gnk.O00000oO(String.format("BleConnectObserver reach limit", new Object[0]));
            for (O000000o o000000o2 : this.f18003O000000o) {
                gnk.O00000oO(String.format(">>> mac = %s", o000000o2.f18005O000000o));
            }
        }
        while (this.f18003O000000o.size() > 5) {
            List<O000000o> list = this.f18003O000000o;
            glw.O000000o().disconnect(list.remove(list.size() - 1).f18005O000000o);
        }
    }

    public static gly O000000o() {
        if (O00000Oo == null) {
            synchronized (gly.class) {
                if (O00000Oo == null) {
                    O00000Oo = new gly();
                }
            }
        }
        return O00000Oo;
    }

    public void reportAction(final String str) {
        this.O00000o.post(new Runnable() {
            /* class _m_j.gly.AnonymousClass1 */

            public final void run() {
                if (gnl.O00000o0(str)) {
                    gly.this.O000000o(str);
                }
            }
        });
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f18005O000000o;

        O000000o(String str) {
            this.f18005O000000o = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f18005O000000o.equals(((O000000o) obj).f18005O000000o);
        }

        public final int hashCode() {
            return this.f18005O000000o.hashCode();
        }
    }

    class O00000Oo extends BroadcastReceiver {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(gly gly, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.hasExtra("key_device_address")) {
                String action = intent.getAction();
                if ("com.xiaomi.smarthome.bluetooth.connect_status_changed".equals(action) && intent.hasExtra("key_connect_status")) {
                    gly gly = gly.this;
                    String stringExtra = intent.getStringExtra("key_device_address");
                    int intExtra = intent.getIntExtra("key_connect_status", 0);
                    if (intExtra == 16) {
                        gly.O000000o(stringExtra);
                    } else if (intExtra == 32) {
                        for (int i = 0; i < gly.f18003O000000o.size(); i++) {
                            if (gly.f18003O000000o.get(i).f18005O000000o.equals(stringExtra)) {
                                gly.f18003O000000o.remove(i);
                                return;
                            }
                        }
                    }
                } else if ("com.xiaomi.smarthome.bluetooth.character_changed".equals(action)) {
                    gly.this.O000000o(intent.getStringExtra("key_device_address"));
                }
            }
        }
    }
}

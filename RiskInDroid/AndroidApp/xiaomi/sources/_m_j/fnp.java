package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceSearch;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.device.TemporaryDevice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fnp extends DeviceSearch<Device> {
    private static volatile fnp O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, TemporaryDevice> f16708O000000o = new HashMap();
    public SharedPreferences O00000Oo;

    public final void O000000o(Collection<? extends Device> collection, DeviceSearch.REMOTESTATE remotestate) {
    }

    public final void O00000o() {
    }

    private fnp() {
        ft O000000o2 = ft.O000000o(CommonApplication.getAppContext());
        IntentFilter intentFilter = new IntentFilter("action_on_login_success");
        intentFilter.addAction("action_on_logout");
        O000000o2.O000000o(new O000000o(this, (byte) 0), intentFilter);
        O0000O0o();
    }

    public static fnp O00000oo() {
        if (O00000o0 == null) {
            synchronized (fnp.class) {
                if (O00000o0 == null) {
                    O00000o0 = new fnp();
                }
            }
        }
        return O00000o0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, boolean):boolean
     arg types: [android.content.SharedPreferences, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, boolean):boolean */
    public final boolean O000000o(String str) {
        SharedPreferences sharedPreferences = this.O00000Oo;
        if (sharedPreferences == null) {
            return false;
        }
        return gpy.O00000Oo(sharedPreferences, str, false);
    }

    public final void O000000o(String str, boolean z) {
        SharedPreferences sharedPreferences = this.O00000Oo;
        if (sharedPreferences != null) {
            gpy.O000000o(sharedPreferences, str, z);
            if (!z) {
                fno.O000000o().O0000OOo();
            }
        }
    }

    public final void O0000O0o() {
        gqe.O000000o(new gqe() {
            /* class _m_j.fnp.AnonymousClass1 */

            public final void O000000o() {
                if (CoreApi.O000000o().O0000Ooo()) {
                    String O0000o0 = CoreApi.O000000o().O0000o0();
                    fnp.this.O00000Oo = CommonApplication.getAppContext().getSharedPreferences("temporary_device".concat(String.valueOf(O0000o0)), 0);
                    return;
                }
                fnp.this.O00000Oo = null;
            }
        }, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public final void O00000Oo() {
        this.O0000O0o = true;
    }

    public final List<Device> O00000o0() {
        if (!CoreApi.O000000o().O0000Ooo()) {
            return Collections.EMPTY_LIST;
        }
        fvo.O000000o();
        if (!fvo.O00000o0()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (Device next : this.f16708O000000o.values()) {
            if (O000000o(next.model)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(fnp fnp, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("action_on_login_success".equals(action)) {
                fnp.this.O0000O0o();
            } else if ("action_on_logout".equals(action)) {
                fnp.this.O00000Oo = null;
            }
        }
    }
}

package _m_j;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.client.IClientApi;
import com.xiaomi.smarthome.core.entity.message.CoreMessageType;
import com.xiaomi.smarthome.core.server.CoreAsyncTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class fcy {
    private static volatile fcy O00000Oo;
    private static Object O00000o0 = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<Integer, fcw> f16093O000000o = new ConcurrentHashMap();

    private fcy() {
    }

    public static fcy O000000o() {
        if (O00000Oo == null) {
            synchronized (O00000o0) {
                if (O00000Oo == null) {
                    O00000Oo = new fcy();
                }
            }
        }
        return O00000Oo;
    }

    public static Handler O00000Oo() {
        return CommonApplication.getGlobalWorkerHandler();
    }

    public static void O000000o(CoreAsyncTask coreAsyncTask) {
        CommonApplication.getGlobalWorkerHandler().post(coreAsyncTask);
    }

    public final boolean O000000o(int i) {
        return this.f16093O000000o.containsKey(Integer.valueOf(i));
    }

    public final IClientApi O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<Integer, fcw> value : this.f16093O000000o.entrySet()) {
            fcw fcw = (fcw) value.getValue();
            if (!TextUtils.isEmpty(fcw.O00000Oo()) && fcw.O00000Oo().equalsIgnoreCase(str)) {
                return fcw.O000000o();
            }
        }
        return null;
    }

    public final List<IClientApi> O00000o0() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, fcw> value : this.f16093O000000o.entrySet()) {
            arrayList.add(((fcw) value.getValue()).O000000o());
        }
        return arrayList;
    }

    public final void O000000o(CoreMessageType coreMessageType, Bundle bundle) {
        for (Map.Entry value : this.f16093O000000o.entrySet()) {
            try {
                ((fcw) value.getValue()).O000000o().onCoreMessage(coreMessageType, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    public static String[] O00000Oo(int i) {
        try {
            return CommonApplication.getAppContext().getPackageManager().getPackagesForUid(i);
        } catch (Exception e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    public final class O000000o implements IBinder.DeathRecipient {
        private int O00000Oo;

        public O000000o(int i) {
            this.O00000Oo = i;
        }

        public final void binderDied() {
            fcw fcw = fcy.this.f16093O000000o.get(Integer.valueOf(this.O00000Oo));
            fcy fcy = fcy.this;
            int i = this.O00000Oo;
            if (fcy.f16093O000000o.containsKey(Integer.valueOf(i))) {
                fcy.f16093O000000o.remove(Integer.valueOf(i));
            }
            if (fcw != null) {
                ft O000000o2 = ft.O000000o(CommonApplication.getAppContext());
                Intent intent = new Intent("action.coremanager.process_dead");
                intent.putExtra("process_name", fcw.O00000Oo());
                O000000o2.O000000o(intent);
            }
        }
    }
}

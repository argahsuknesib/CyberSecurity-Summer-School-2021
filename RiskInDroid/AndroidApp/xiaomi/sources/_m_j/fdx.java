package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class fdx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Map<String, List<O00000Oo>> f16138O000000o = new ConcurrentHashMap();
    private static O000000o O00000Oo;

    public static synchronized void O000000o(String str, UUID uuid, UUID uuid2, IBleResponse iBleResponse) {
        synchronized (fdx.class) {
            if (!TextUtils.isEmpty(str) && uuid != null) {
                if (uuid2 != null) {
                    List list = f16138O000000o.get(str);
                    O00000Oo o00000Oo = new O00000Oo(uuid, uuid2);
                    if (list == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(o00000Oo);
                        f16138O000000o.put(str, arrayList);
                    } else if (!O000000o(list, o00000Oo)) {
                        list.add(o00000Oo);
                    }
                    if (f16138O000000o.size() > 0) {
                        O000000o();
                    }
                    if (iBleResponse != null) {
                        try {
                            iBleResponse.onResponse(0, null);
                            return;
                        } catch (RemoteException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            }
            if (iBleResponse != null) {
                try {
                    iBleResponse.onResponse(-1, null);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static synchronized void O000000o(String str, UUID uuid, UUID uuid2) {
        synchronized (fdx.class) {
            List list = f16138O000000o.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    O00000Oo o00000Oo = (O00000Oo) it.next();
                    if (o00000Oo.f16139O000000o.equals(uuid) && o00000Oo.O00000Oo.equals(uuid2)) {
                        it.remove();
                    }
                }
                if (list.size() == 0) {
                    f16138O000000o.remove(str);
                }
            }
            if (f16138O000000o.size() == 0) {
                O00000Oo();
            }
        }
    }

    private static boolean O000000o(List<O00000Oo> list, O00000Oo o00000Oo) {
        if (!(list == null || list.size() == 0)) {
            for (O00000Oo next : list) {
                if (o00000Oo.f16139O000000o.equals(next.f16139O000000o) && o00000Oo.O00000Oo.equals(next.O00000Oo)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static synchronized void O000000o() {
        synchronized (fdx.class) {
            if (O00000Oo == null) {
                O00000Oo = new O000000o((byte) 0);
                gnl.O000000o(O00000Oo, new IntentFilter("com.xiaomi.smarthome.bluetooth.character_changed"));
            }
        }
    }

    private static synchronized void O00000Oo() {
        synchronized (fdx.class) {
            if (O00000Oo != null) {
                gnl.O000000o(O00000Oo);
                O00000Oo = null;
            }
        }
    }

    static class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            List<O00000Oo> list;
            if ("com.xiaomi.smarthome.bluetooth.character_changed".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("key_device_address");
                UUID uuid = (UUID) intent.getSerializableExtra("key_service_uuid");
                UUID uuid2 = (UUID) intent.getSerializableExtra("key_character_uuid");
                byte[] byteArrayExtra = intent.getByteArrayExtra("key_character_value");
                if (stringExtra != null && uuid != null && uuid2 != null && byteArrayExtra != null && (list = fdx.f16138O000000o.get(stringExtra)) != null && list.size() > 0) {
                    for (O00000Oo o00000Oo : list) {
                        if (uuid.equals(o00000Oo.f16139O000000o) && uuid2.equals(o00000Oo.O00000Oo)) {
                            fec.O00000o0().O000000o(stringExtra, uuid, uuid2, byteArrayExtra);
                            return;
                        }
                    }
                }
            }
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        protected UUID f16139O000000o;
        protected UUID O00000Oo;

        public O00000Oo(UUID uuid, UUID uuid2) {
            this.f16139O000000o = uuid;
            this.O00000Oo = uuid2;
        }
    }
}

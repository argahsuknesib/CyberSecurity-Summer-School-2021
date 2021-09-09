package com.miot.spec;

import _m_j.cmh;
import _m_j.cmp;
import _m_j.cmt;
import _m_j.cmv;
import _m_j.cmw;
import _m_j.cmx;
import _m_j.cnb;
import _m_j.cnc;
import _m_j.cnd;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.Toast;
import com.miot.spec.exception.ProtocolVersionIsLowException;
import com.miot.spec.exception.SpecException;
import com.xiaomi.smarthome.R;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class SpecManager {
    public static Context O00000oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, cmx> f5245O000000o;
    public Map<String, String> O00000Oo;
    public Set<String> O00000o;
    public Map<String, Integer> O00000o0;
    Handler O00000oO;
    public SpecReceiver O0000O0o;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final SpecManager f5247O000000o = new SpecManager((byte) 0);
    }

    /* synthetic */ SpecManager(byte b) {
        this();
    }

    public final void O000000o() {
        this.O00000oO.post(new Runnable(R.string.api_tip_title) {
            /* class com.miot.spec.SpecManager.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ int f5246O000000o = R.string.api_tip_title;

            public final void run() {
                Toast.makeText(SpecManager.O00000oo, this.f5246O000000o, 0).show();
            }
        });
    }

    private SpecManager() {
        this.f5245O000000o = new ConcurrentHashMap();
        this.O00000Oo = new ConcurrentHashMap();
        this.O00000o0 = new ConcurrentHashMap();
        this.O00000o = new HashSet();
        this.O00000oO = new Handler(Looper.getMainLooper());
        this.O0000O0o = null;
    }

    public final void O000000o(String str, cmx cmx) {
        byte[] O000000o2 = cmx.O000000o();
        this.O00000Oo.put(cnc.O000000o(O000000o2) + str, cmx.O00000o());
        this.f5245O000000o.put(cmx.O00000o(), cmx);
        cnd.O000000o("SpecManager", "sendPacket ,value is :" + cnb.O000000o(O000000o2), new Object[0]);
        Intent intent = new Intent("action.miot.write.specv2.ble.data");
        intent.putExtra("mac", str);
        intent.putExtra("value", O000000o2);
        O00000oo.sendBroadcast(intent);
    }

    static void O000000o(String str) {
        Intent intent = new Intent("com.xiaomi.smarthome.ble.spec.notify");
        intent.putExtra("json", str);
        cnd.O000000o("SpecManager", "notify spec message to Rn, json=".concat(String.valueOf(str)), new Object[0]);
        O00000oo.sendBroadcast(intent);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(SpecException specException) {
        Map<String, cmx> map = this.f5245O000000o;
        if (map != null && !map.isEmpty()) {
            for (String remove : this.f5245O000000o.keySet()) {
                cmx remove2 = this.f5245O000000o.remove(remove);
                if (remove2 != null) {
                    try {
                        remove2.O000000o(specException.getErrorCode(), specException.getMessage());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public class SpecReceiver extends BroadcastReceiver {
        public SpecReceiver() {
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("action.miot.receive.specv2.ble.data".equals(action)) {
                String stringExtra = intent.getStringExtra("mac");
                byte[] byteArrayExtra = intent.getByteArrayExtra("value");
                SpecManager specManager = SpecManager.this;
                cnd.O000000o("SpecManager", "receivePacket, value is " + cnb.O000000o(byteArrayExtra), new Object[0]);
                try {
                    cmv O000000o2 = cmw.O000000o(stringExtra, byteArrayExtra);
                    if (O000000o2 == null) {
                        cnd.O00000Oo("SpecManager", "receivePacket value parse result is null and return,value:" + cnb.O000000o(byteArrayExtra), new Object[0]);
                        return;
                    }
                    cnd.O000000o("SpecManager", "receive packet,after parse byte[],the content is: %s", O000000o2.toString());
                    if (O000000o2.O000000o() == 4) {
                        cmt cmt = (cmt) O000000o2;
                        List<cmh> list = cmt.f14130O000000o;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("mac", cmt.O00000Oo());
                            jSONObject.put("opcode", cmt.O000000o());
                            jSONObject.put("objects", cmh.O000000o(list));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        SpecManager.O000000o(jSONObject.toString());
                    } else if (O000000o2.O000000o() == 7) {
                        cmp cmp = (cmp) O000000o2;
                        List<cmh> list2 = cmp.f14128O000000o;
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("mac", cmp.O00000Oo());
                            jSONObject2.put("opcode", cmp.O000000o());
                            jSONObject2.put("siid", cmp.O00000o0);
                            jSONObject2.put("eiid", cmp.O00000Oo);
                            jSONObject2.put("objects", cmh.O000000o(list2));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        jSONObject2.keys();
                        SpecManager.O000000o(jSONObject2.toString());
                    } else {
                        cmx remove = specManager.f5245O000000o.remove(O000000o2.O00000o0());
                        if (remove != null) {
                            try {
                                remove.O000000o(O000000o2);
                            } catch (RemoteException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                } catch (ProtocolVersionIsLowException e4) {
                    cnd.O000000o("SpecManager", "receive Packet, app protocol version < firmware protocol version, you should upgrade app", new Object[0]);
                    e4.printStackTrace();
                    specManager.O000000o(e4);
                }
            } else if ("action.miot.write.specv2.ble.data.resp".equals(action)) {
                String stringExtra2 = intent.getStringExtra("mac");
                int intExtra = intent.getIntExtra("code", -1);
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("value");
                cnd.O000000o("SpecManager", "SpecReceiver ACTION_WRITE_SPEC_BLE_DATA_RESP, write callback code %d, send data:%s", Integer.valueOf(intExtra), cnb.O000000o(byteArrayExtra2));
                cmx cmx = SpecManager.this.f5245O000000o.get(SpecManager.this.O00000Oo.get(cnc.O000000o(byteArrayExtra2) + stringExtra2));
                if (cmx != null) {
                    try {
                        cmx.O000000o(intExtra, (String) null);
                    } catch (RemoteException e5) {
                        e5.printStackTrace();
                    }
                }
            } else if ("com.xiaomi.smarthome.support.ble.spec.protocol".equals(action)) {
                String stringExtra3 = intent.getStringExtra("mac");
                cnd.O000000o("SpecManager", "receive support ble spec device mac", new Object[0]);
                if (!TextUtils.isEmpty(stringExtra3)) {
                    SpecManager.this.O00000o.add(stringExtra3);
                }
            } else if ("com.xiaomi.smarthome.bluetooth.connect_status_changed".endsWith(action)) {
                String stringExtra4 = intent.getStringExtra("key_device_address");
                if (intent.getIntExtra("key_connect_status", 0) == 32) {
                    SpecManager.this.O00000o0.remove(stringExtra4);
                }
            }
        }
    }

    public final void O000000o(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000o0.put(str, Integer.valueOf(i));
        }
    }
}

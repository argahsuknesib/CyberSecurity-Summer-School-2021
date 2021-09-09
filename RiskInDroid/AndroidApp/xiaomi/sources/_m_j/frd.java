package _m_j;

import _m_j.fno;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DevicelibApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class frd extends frb {
    public static Stack<frf> O00000oO = new Stack<>();

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f16957O000000o = false;
    public final List<List<Device>> O00000Oo = new ArrayList();
    public frf O00000o;
    public final Map<String, List<Device>> O00000o0 = new ConcurrentHashMap();
    public final Handler O00000oo;
    private AtomicBoolean O0000O0o = new AtomicBoolean(false);
    private fno.O000000o O0000OOo = new fno.O000000o() {
        /* class _m_j.frd.AnonymousClass3 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            frd.this.O00000oo.sendMessage(frd.this.O00000oo.obtainMessage(2, ""));
        }
    };

    public frd() {
        HandlerThread handlerThread = new HandlerThread("DevicePropSubscriber");
        handlerThread.start();
        this.O00000oo = new Handler(handlerThread.getLooper()) {
            /* class _m_j.frd.AnonymousClass1 */

            public final void handleMessage(Message message) {
                if (!frd.this.f16957O000000o) {
                    int i = message.what;
                    if (i == 1) {
                        String str = (String) message.obj;
                        frd frd = frd.this;
                        frd.O000000o(frd.O00000o0.get(str), str);
                    } else if (i == 2) {
                        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
                        frd frd2 = frd.this;
                        ArrayList arrayList = new ArrayList();
                        HashMap hashMap = new HashMap();
                        for (Map.Entry<String, List<Device>> value : frd2.O00000o0.entrySet()) {
                            for (Device device : (List) value.getValue()) {
                                hashMap.put(device.did, device);
                            }
                        }
                        for (List<Device> it : frd2.O00000Oo) {
                            for (Device device2 : it) {
                                hashMap.put(device2.did, device2);
                            }
                        }
                        for (Map.Entry<String, Device> value2 : O0000O0o.entrySet()) {
                            Device device3 = (Device) value2.getValue();
                            if (device3 != null && !TextUtils.isEmpty(device3.did) && hashMap.get(device3.did) == null) {
                                arrayList.add(device3);
                            }
                        }
                        gsy.O00000Oo("DevicePropSubscriber", "onRefreshClientDeviceSuccess all device size=" + O0000O0o.size());
                        frd.this.O000000o(arrayList);
                        frd.this.O000000o(O0000O0o);
                    } else if (i == 3) {
                        frd.this.O000000o((List) message.obj);
                    }
                }
            }
        };
    }

    public final void O000000o(List<Device> list) {
        if (list.size() > 300) {
            int i = 0;
            while (i < list.size()) {
                int i2 = i + 300;
                O000000o(new ArrayList(list.subList(i, Math.min(i2, list.size()))), null);
                i = i2;
            }
            return;
        }
        O000000o(list, null);
    }

    public final void init(List<Device> list, frf frf) {
        if (!this.O0000O0o.getAndSet(true)) {
            fno.O000000o().O000000o(this.O0000OOo);
            this.O00000o = frf;
            O00000oO.push(this.O00000o);
            Handler handler = this.O00000oo;
            handler.sendMessage(handler.obtainMessage(3, list));
        }
    }

    public final void O000000o(final List<Device> list, String str) {
        List<String> O000000o2;
        gsy.O000000o(3, "DevicePropSubscriber", "subscribe subid=".concat(String.valueOf(str)));
        if (list != null && list.size() != 0 && this.O00000o != null) {
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < list.size(); i++) {
                Device device = list.get(i);
                if (!(device == null || (O000000o2 = this.O00000o.O000000o(device.did)) == null)) {
                    O000000o2.add("event.dev_online");
                    O000000o2.add("event.dev_offline");
                    JSONArray jSONArray = new JSONArray();
                    for (String next : O000000o2) {
                        if (!TextUtils.isEmpty(next)) {
                            if (!next.startsWith("prop.") && !next.startsWith("event.")) {
                                next = "prop.".concat(String.valueOf(next));
                            }
                            jSONArray.put(next);
                        }
                    }
                    try {
                        jSONObject.put(device.did, jSONArray);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (jSONObject.keys() != null && jSONObject.keys().hasNext()) {
                this.O00000Oo.add(list);
                gsy.O000000o(3, "DevicePropSubscriber", jSONObject.toString());
                fre O000000o3 = fre.O000000o();
                AnonymousClass2 r2 = new frg() {
                    /* class _m_j.frd.AnonymousClass2 */

                    public final void O000000o(String str) {
                        frd.this.O00000Oo.remove(list);
                        frd.this.O00000o0.put(str, list);
                        gsy.O000000o(3, "DevicePropSubscriber", "subscribe onSuccess subid=" + str + "  SubscriberInterface" + frd.this.O00000o);
                        frd.this.O00000oo.sendMessageDelayed(frd.this.O00000oo.obtainMessage(1, str), 120000);
                    }

                    public final void O000000o(fso fso) {
                        String str;
                        frd.this.O00000Oo.remove(list);
                        frd.this.O00000o0.put("", list);
                        frd.this.O00000oo.sendMessageDelayed(frd.this.O00000oo.obtainMessage(1, ""), 5000);
                        LogType logType = LogType.PUSH;
                        StringBuilder sb = new StringBuilder("startSubscribeBatch fail =");
                        if (fso == null) {
                            str = null;
                        } else {
                            str = fso.f17063O000000o + "," + fso.O00000Oo;
                        }
                        sb.append(str);
                        sb.append(" mDeviceSubscriberInterface:");
                        sb.append(frd.this.O00000o);
                        gsy.O00000Oo(logType, "DevicePropSubscriber", sb.toString());
                    }

                    public final void O000000o(String str, String str2, JSONArray jSONArray) {
                        StringBuilder sb = new StringBuilder("subscribe onReceive did=");
                        sb.append(str);
                        sb.append(",model=");
                        sb.append(str2);
                        sb.append(", prop=");
                        sb.append(jSONArray == null ? null : jSONArray.toString());
                        gsy.O000000o(3, "DevicePropSubscriber", sb.toString());
                        frd.this.O00000o.O000000o(str, jSONArray);
                    }
                };
                if (!CoreApi.O000000o().O0000Ooo()) {
                    r2.O000000o(new fso(-1, "not logged in"));
                } else {
                    DevicelibApi.subscribeDeviceBatchV2(CommonApplication.getAppContext(), jSONObject, str, 180, new fsm<String, fso>(r2, 180) {
                        /* class _m_j.fre.AnonymousClass4 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ frg f16965O000000o;
                        final /* synthetic */ int O00000Oo = 180;

                        {
                            this.f16965O000000o = r2;
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            final String str = (String) obj;
                            if (TextUtils.isEmpty(str)) {
                                frg frg = this.f16965O000000o;
                                if (frg != null) {
                                    frg.O000000o(new fso(-1, "subId return null"));
                                    return;
                                }
                                return;
                            }
                            Runnable runnable = fre.this.O00000oO.get(str);
                            if (runnable == null) {
                                synchronized (fre.f16961O000000o) {
                                    runnable = fre.this.O00000oO.get(str);
                                    if (runnable == null) {
                                        runnable = new Runnable() {
                                            /* class _m_j.fre.AnonymousClass4.AnonymousClass1 */

                                            public final void run() {
                                                fre.this.O00000Oo(str);
                                                fre.this.O00000oO.remove(str);
                                            }
                                        };
                                        fre.this.O00000oO.put(str, runnable);
                                    }
                                }
                            }
                            CommonApplication.getGlobalWorkerHandler().removeCallbacks(runnable);
                            CommonApplication.getGlobalWorkerHandler().postDelayed(runnable, ((long) this.O00000Oo) * 1000);
                            fre.this.O00000o.put(str, this.f16965O000000o);
                            frg frg2 = this.f16965O000000o;
                            if (frg2 != null) {
                                frg2.O000000o(str);
                            }
                        }

                        public final void onFailure(fso fso) {
                            frg frg = this.f16965O000000o;
                            if (frg != null) {
                                frg.O000000o(fso);
                            }
                        }
                    });
                }
            }
        }
    }

    public final void destroy() {
        try {
            this.O00000oo.removeMessages(1);
            O00000oO.remove(this.O00000o);
            fno.O000000o().O00000Oo(this.O0000OOo);
            for (String next : this.O00000o0.keySet()) {
                DevicelibApi.unsubscribeDeviceBatchV2(CommonApplication.getAppContext(), next, new fsm<Void, fso>(next, null) {
                    /* class _m_j.fre.AnonymousClass5 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String f16967O000000o;
                    final /* synthetic */ frh O00000Oo = null;

                    {
                        this.f16967O000000o = r2;
                    }

                    public final void onFailure(fso fso) {
                        frh frh = this.O00000Oo;
                        if (frh != null) {
                            frh.O000000o(new fso(-1, ""));
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        fre.this.O00000Oo(this.f16967O000000o);
                        frh frh = this.O00000Oo;
                        if (frh != null) {
                            frh.O000000o();
                        }
                    }
                });
            }
            this.O00000o0.clear();
            this.O00000oo.getLooper().quitSafely();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f16957O000000o = true;
    }

    public final void O000000o(Map<String, Device> map) {
        if (map != null && !map.isEmpty()) {
            Iterator<String> it = this.O00000o0.keySet().iterator();
            while (it.hasNext()) {
                List list = this.O00000o0.get(it.next());
                if (list == null || list.size() == 0) {
                    it.remove();
                } else {
                    int i = 0;
                    while (i < list.size()) {
                        Device device = (Device) list.get(i);
                        if (device == null) {
                            list.remove(i);
                            i--;
                            if (list.size() == 0) {
                                it.remove();
                            }
                        } else if (!map.containsKey(device.did)) {
                            list.remove(i);
                            i--;
                            if (list.size() == 0) {
                                it.remove();
                            }
                        }
                        i++;
                    }
                }
            }
        }
    }

    public static JSONArray O000000o(String str) {
        if (TextUtils.isEmpty(str) || O000000o() == null) {
            return null;
        }
        return O000000o().O00000Oo(str);
    }

    private static frf O000000o() {
        try {
            return O00000oO.peek();
        } catch (EmptyStackException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package _m_j;

import android.os.Handler;
import android.text.TextUtils;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.device.MiTVDevice;
import com.xiaomi.smarthome.device.Device;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class fjg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f16465O000000o = "_miio._udp.local.";
    public static String O00000Oo = "_rc._tcp.local.";
    private static volatile fjg O0000OOo;
    private static Object O0000Oo0 = new Object();
    public gpq O00000o = new gpq("DiscoverManager");
    public isq O00000o0;
    public Handler O00000oO;
    public List<WeakReference<fja>> O00000oo = new ArrayList();
    public ConcurrentMap<String, Device> O0000O0o = new ConcurrentHashMap();

    private fjg() {
    }

    public static fjg O000000o() {
        if (O0000OOo == null) {
            synchronized (fjg.class) {
                if (O0000OOo == null) {
                    O0000OOo = new fjg();
                }
            }
        }
        return O0000OOo;
    }

    public final synchronized void O000000o(fja fja) {
        if (fja != null) {
            this.O00000oo.add(new WeakReference(fja));
        }
    }

    public final void O00000Oo() {
        fjn.O000000o().O00000Oo();
        this.O0000O0o.clear();
    }

    public final void O000000o(final Device device) {
        if (device != null && !TextUtils.isEmpty(device.getDid()) && device.getModel().contains("robot")) {
            MiioLocalAPI.O000000o(device.getLocalIP(), new dxe(new fjo<String>() {
                /* class _m_j.fjg.AnonymousClass3 */

                public final /* synthetic */ void O000000o(Object obj) {
                    String str = (String) obj;
                    Device device = fjg.this.O0000O0o.get(device.getDid());
                    if (device == null) {
                        device.setToken(str);
                        fjg.this.O0000O0o.put(device.getDid(), device);
                        for (WeakReference next : fjg.this.O00000oo) {
                            if (next.get() != null) {
                                ((fja) next.get()).O000000o(device);
                            }
                        }
                        return;
                    }
                    device.setToken(str);
                }

                public final void O000000o(int i) {
                    if (fjg.this.O0000O0o.remove(device.getDid()) != null) {
                        for (WeakReference next : fjg.this.O00000oo) {
                            if (next.get() != null) {
                                ((fja) next.get()).O00000Oo(device);
                            }
                        }
                    }
                }

                public final void O000000o(int i, Object obj) {
                    if (fjg.this.O0000O0o.remove(device.getDid()) != null) {
                        for (WeakReference next : fjg.this.O00000oo) {
                            if (next.get() != null) {
                                ((fja) next.get()).O00000Oo(device);
                            }
                        }
                    }
                }
            }) {
                /* class _m_j.fjh.AnonymousClass2 */

                /* renamed from: O000000o */
                final /* synthetic */ fjo f16474O000000o;

                {
                    this.f16474O000000o = r2;
                }

                public final void onResponse(String str) {
                    gsy.O000000o(3, "scan2", str);
                    fjh.O000000o(str, new fjo<JSONObject>() {
                        /* class _m_j.fjh.AnonymousClass2.AnonymousClass1 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            String optString = ((JSONObject) obj).optString("token");
                            if (AnonymousClass2.this.f16474O000000o != null) {
                                AnonymousClass2.this.f16474O000000o.O000000o(optString);
                            }
                        }

                        public final void O000000o(int i) {
                            if (AnonymousClass2.this.f16474O000000o != null) {
                                AnonymousClass2.this.f16474O000000o.O000000o(i);
                            }
                        }

                        public final void O000000o(int i, Object obj) {
                            if (AnonymousClass2.this.f16474O000000o != null) {
                                AnonymousClass2.this.f16474O000000o.O000000o(i, obj);
                            }
                        }
                    });
                }
            }, 9);
        }
    }

    public final void O000000o(ServiceInfo serviceInfo) {
        String O00000Oo2 = fjb.O00000Oo(serviceInfo.O00000o0());
        if (this.O0000O0o.containsKey(O00000Oo2)) {
            Device device = this.O0000O0o.get(O00000Oo2);
            this.O0000O0o.remove(O00000Oo2);
            for (WeakReference next : this.O00000oo) {
                if (next.get() != null) {
                    ((fja) next.get()).O00000Oo(device);
                }
            }
        }
    }

    class O000000o implements iss {
        private O000000o() {
        }

        /* synthetic */ O000000o(fjg fjg, byte b) {
            this();
        }

        public final void O000000o(ServiceEvent serviceEvent) {
            fjg.this.O000000o(fjb.O000000o(serviceEvent.O00000o().O00000o0(), serviceEvent._source.getHostAddress()));
        }

        public final void O00000Oo(ServiceEvent serviceEvent) {
            fjg.this.O000000o(serviceEvent.O00000o());
        }

        public final void O00000o0(ServiceEvent serviceEvent) {
            fjg.this.O000000o(fjb.O000000o(serviceEvent.O00000o().O00000o0(), serviceEvent.O00000o().O00000oo().getHostAddress()));
        }
    }

    class O00000Oo implements iss {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(fjg fjg, byte b) {
            this();
        }

        public final void O000000o(final ServiceEvent serviceEvent) {
            goq.O000000o(new Runnable() {
                /* class _m_j.fjg.O00000Oo.AnonymousClass1 */

                public final void run() {
                    ServiceInfo O000000o2 = fjg.this.O00000o0.O000000o(fjg.O00000Oo, serviceEvent.O00000o().O00000o0());
                    if (O000000o2 != null) {
                        MiTVDevice O00000Oo2 = fjg.O00000Oo(O000000o2);
                        fjn.O000000o().O000000o(O00000Oo2);
                        fjg.this.O000000o(O00000Oo2);
                    }
                }
            });
        }

        public final void O00000Oo(ServiceEvent serviceEvent) {
            ServiceInfo O00000o;
            if (serviceEvent != null && (O00000o = serviceEvent.O00000o()) != null) {
                fjn.O000000o().O00000Oo(fjg.O00000Oo(O00000o));
                fjg.this.O000000o(O00000o);
            }
        }

        public final void O00000o0(ServiceEvent serviceEvent) {
            ServiceInfo O00000o;
            if (serviceEvent != null && (O00000o = serviceEvent.O00000o()) != null) {
                MiTVDevice O00000Oo = fjg.O00000Oo(O00000o);
                fjn.O000000o().O000000o(O00000Oo);
                fjg.this.O000000o(O00000Oo);
            }
        }
    }

    public static MiTVDevice O00000Oo(ServiceInfo serviceInfo) {
        MiTVDevice miTVDevice = new MiTVDevice();
        miTVDevice.setMac(serviceInfo.O000000o("mac"));
        miTVDevice.setBssid(serviceInfo.O000000o("mac"));
        String O00000Oo2 = gog.O00000Oo(CommonApplication.getAppContext());
        if (!TextUtils.isEmpty(O00000Oo2)) {
            miTVDevice.setBssid(O00000Oo2.toUpperCase());
        }
        String O00000o02 = gog.O00000o0(CommonApplication.getAppContext());
        if (!TextUtils.isEmpty(O00000o02)) {
            miTVDevice.setSsid(O00000o02);
        }
        miTVDevice.setName(serviceInfo.O00000o0());
        String O000000o2 = serviceInfo.O000000o("rid");
        if (!TextUtils.isEmpty(miTVDevice.getMac()) && !TextUtils.isEmpty(O000000o2)) {
            miTVDevice.setDid("mitv." + fjb.O000000o(miTVDevice.getMac()) + ":" + serviceInfo.O000000o("rid"));
        }
        InetAddress O00000oo2 = serviceInfo.O00000oo();
        if (O00000oo2 != null) {
            miTVDevice.setLocalIP(O00000oo2.getHostAddress());
        }
        miTVDevice.toggleOnline(true);
        miTVDevice.setResetFlag(1);
        miTVDevice.setLocation(Device.Location.LOCAL);
        miTVDevice.setPid(2);
        miTVDevice.O000000o();
        int i = 0;
        miTVDevice.toggleCanAuth(false);
        miTVDevice.setShared(true);
        miTVDevice.toggleCanUseNotBind(true);
        miTVDevice.toggleOnline(true);
        try {
            i = Integer.valueOf(serviceInfo.O000000o("platform_id")).intValue();
        } catch (Exception unused) {
        }
        if (i < 600) {
            miTVDevice.setModel("xiaomi.tvbox.v1");
        } else {
            miTVDevice.setModel("xiaomi.tv.v1");
        }
        if (i > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("platform", i);
            } catch (JSONException unused2) {
            }
            miTVDevice.setExtraInfo(jSONObject.toString());
        }
        return miTVDevice;
    }
}

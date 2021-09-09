package _m_j;

import _m_j.gti;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class gtj {
    private static gtj O0000OoO;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f18250O000000o = false;
    public boolean O00000Oo = false;
    public boolean O00000o = true;
    AtomicBoolean O00000o0 = new AtomicBoolean(false);
    public boolean O00000oO = false;
    public boolean O00000oo = false;
    public boolean O0000O0o = false;
    public List<O000000o> O0000OOo = new ArrayList();
    O00000Oo O0000Oo;
    public Handler O0000Oo0 = new Handler(Looper.getMainLooper()) {
        /* class _m_j.gtj.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                gtj.this.O00000Oo = false;
                CameraRouterFactory.getCameraManagerApi().swapCameraDeviceOpManager();
                gti.O000000o();
                Iterator<O000000o> it = gtj.this.O0000OOo.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } else if (i == 2) {
                gtj.this.f18250O000000o = false;
                if (((Class) message.obj).equals(gti.class)) {
                    gtj.this.O00000oO = false;
                }
                if (!gtj.this.O00000oO) {
                    if (gtj.this.O00000oo) {
                        gti.O000000o();
                    }
                    for (O000000o O000000o2 : gtj.this.O0000OOo) {
                        O000000o2.O000000o();
                    }
                    ft.O000000o(gkv.f17949O000000o).O000000o(new Intent("get_camera_success"));
                }
            } else if (i == 4) {
                gtj gtj = gtj.this;
                if (gtj.O00000o0.getAndSet(false)) {
                    List<Device> homeDeviceList = CameraRouterFactory.getCameraManagerApi().getHomeDeviceList();
                    gti O000000o3 = gti.O000000o();
                    HashMap hashMap = new HashMap();
                    for (int i2 = 0; i2 < homeDeviceList.size(); i2++) {
                        Device device = homeDeviceList.get(i2);
                        if (device != null && !device.model.contains("mxiang.camera.mwc10") && !device.model.contains("mxiang.camera.mwc11")) {
                            hashMap.put(homeDeviceList.get(i2).did, Integer.valueOf(i2));
                        }
                    }
                    int i3 = 0;
                    while (i3 < O000000o3.O00000o0.size()) {
                        gti.O000000o o000000o = O000000o3.O00000o0.get(i3);
                        if (o000000o == null || !hashMap.containsKey(o000000o.f18248O000000o)) {
                            O000000o3.O00000oO.add(O000000o3.O00000o0.remove(i3));
                            i3--;
                        } else {
                            hashMap.remove(O000000o3.O00000o0.get(i3).f18248O000000o);
                        }
                        i3++;
                    }
                    if (hashMap.size() != 0) {
                        for (String str : hashMap.keySet()) {
                            gti.O000000o o000000o2 = null;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= O000000o3.O00000oO.size()) {
                                    break;
                                } else if (O000000o3.O00000oO.get(i4).f18248O000000o.equals(str)) {
                                    o000000o2 = O000000o3.O00000oO.remove(i4);
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            if (o000000o2 == null) {
                                o000000o2 = new gti.O000000o();
                                o000000o2.f18248O000000o = str;
                            }
                            Device O00000o0 = fno.O000000o().O00000o0(o000000o2.f18248O000000o);
                            if (O00000o0 != null) {
                                Map<String, Long> supportCameraModelsCameraDeviceOpManager = CameraRouterFactory.getCameraManagerApi().getSupportCameraModelsCameraDeviceOpManager();
                                if (supportCameraModelsCameraDeviceOpManager == null || !supportCameraModelsCameraDeviceOpManager.containsKey(O00000o0.model)) {
                                    O000000o3.O00000o0.add(o000000o2);
                                } else {
                                    O000000o3.O00000o0.add(0, o000000o2);
                                }
                            }
                        }
                    }
                    gsy.O000000o(6, "AllCameraGroup", O000000o3.O00000o.size() + ", " + O000000o3.O00000o0.size());
                    for (O000000o O000000o4 : gtj.O0000OOo) {
                        O000000o4.O000000o();
                    }
                    gtj.f18250O000000o = false;
                    gtj.O0000Oo.sendEmptyMessage(3);
                    return;
                }
                gtj.f18250O000000o = false;
                gkv.f17949O000000o.sendBroadcast(new Intent("refresh_list"));
                gti.O000000o().O000000o(new fsm<Void, fso>() {
                    /* class _m_j.gtj.AnonymousClass2 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    }
                });
            }
        }
    };
    private HandlerThread O0000Ooo = new gpq("camera_list_info");

    public interface O000000o {
        void O000000o();
    }

    public static gtj O000000o() {
        if (O0000OoO == null) {
            O0000OoO = new gtj();
        }
        return O0000OoO;
    }

    class O00000Oo extends Handler {
        O00000Oo(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                gti O000000o2 = gti.O000000o();
                String string = O000000o2.f18243O000000o.getString(gti.O00000Oo(), "");
                if (!TextUtils.isEmpty(string)) {
                    O000000o2.O00000oo.sendMessage(O000000o2.O00000oo.obtainMessage(3, O000000o2.O000000o(string)));
                }
                gtj.this.O0000Oo0.sendMessage(gtj.this.O0000Oo0.obtainMessage(1));
                gsy.O000000o(6, "device_rpc", "Refresh Cache complete");
                fuj.O000000o().O000000o(gkv.f17949O000000o, new String[]{"20"}, new fsm<ArrayList<fui>, fso>(new fsm<Void, fso>() {
                    /* class _m_j.gtj.O00000Oo.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        gtj.this.O00000oo = false;
                        gtj.this.O0000Oo0.sendMessage(gtj.this.O0000Oo0.obtainMessage(2, gti.class));
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        gtj.this.O00000oo = true;
                        gtj.this.O0000Oo0.sendMessage(gtj.this.O0000Oo0.obtainMessage(2, gti.class));
                    }
                }) {
                    /* class _m_j.gti.AnonymousClass4 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ fsm f18247O000000o;

                    {
                        this.f18247O000000o = r2;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        fui fui;
                        ArrayList arrayList = (ArrayList) obj;
                        if (arrayList != null && arrayList.size() > 0 && (fui = (fui) arrayList.get(0)) != null && fui.O00000o0 != null && fui.O00000o0.size() > 0 && TextUtils.equals(gti.O00000Oo(), fui.O00000o0.get(0).f17182O000000o)) {
                            String str = fui.O00000o0.get(0).O00000Oo;
                            List<O000000o> O000000o2 = gti.this.O000000o(str);
                            gti.this.O00000Oo(str);
                            gti.this.O00000oo.sendMessage(gti.this.O00000oo.obtainMessage(3, O000000o2));
                        }
                        this.f18247O000000o.onSuccess(null);
                    }

                    public final void onFailure(fso fso) {
                        this.f18247O000000o.onFailure(fso);
                    }
                });
            } else if (i == 3) {
                gsy.O000000o(6, "device_rpc", "Start Refresh PROP");
                CameraRouterFactory.getCameraManagerApi().loadAllCameraCloudStorageInfoFromServer(new fsm<Void, fso>() {
                    /* class _m_j.gtj.O00000Oo.AnonymousClass2 */

                    public final void onFailure(fso fso) {
                        gsy.O00000Oo("refresh", "loadAllCameraCloudStorageInfoFromServer onFailure:" + fso.f17063O000000o);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        gsy.O00000Oo("refresh", "loadAllCameraCloudStorageInfoFromServer onSuccess");
                    }
                });
                CameraRouterFactory.getCameraManagerApi().updateDevicePropsCameraDeviceOpManager(new fsm<Void, fso>() {
                    /* class _m_j.gtj.O00000Oo.AnonymousClass3 */

                    public final void onFailure(fso fso) {
                        gtj.this.O0000Oo0.post(new Runnable() {
                            /* class _m_j.gtj.O00000Oo.AnonymousClass3.AnonymousClass2 */

                            public final void run() {
                                for (O000000o O000000o2 : gtj.this.O0000OOo) {
                                    O000000o2.O000000o();
                                }
                            }
                        });
                        gtj.this.f18250O000000o = false;
                        gtj.this.O00000o = false;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        gtj.this.O0000Oo0.post(new Runnable() {
                            /* class _m_j.gtj.O00000Oo.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                for (O000000o O000000o2 : gtj.this.O0000OOo) {
                                    O000000o2.O000000o();
                                }
                            }
                        });
                        gtj.this.f18250O000000o = false;
                        gtj.this.O0000O0o = true;
                        gtj.this.O00000o = true;
                    }
                });
            }
        }
    }

    gtj() {
        this.O0000Ooo.start();
        this.O0000Oo = new O00000Oo(this.O0000Ooo.getLooper());
    }

    public final void O00000Oo() {
        if (!this.f18250O000000o) {
            this.f18250O000000o = true;
            this.O00000oO = true;
            this.O0000O0o = false;
            this.O00000oo = false;
            this.O00000Oo = false;
            this.O0000Oo.sendEmptyMessage(0);
        }
    }

    public final void O00000o0() {
        this.O00000o0.set(true);
        if (!this.f18250O000000o) {
            this.f18250O000000o = true;
            this.O0000Oo0.sendEmptyMessage(4);
        }
    }
}

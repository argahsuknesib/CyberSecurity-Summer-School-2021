package _m_j;

import _m_j.fno;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import org.json.JSONException;
import org.json.JSONObject;

public final class geb extends gdy {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f17582O000000o = false;
    public LinkedList<O000000o> O00000Oo = new LinkedList<>();
    fno.O000000o O00000o = new fno.O000000o() {
        /* class _m_j.geb.AnonymousClass1 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3) {
                geb.this.f17582O000000o = true;
                fno.O000000o().O00000Oo(geb.this.O00000o);
                CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
                    /* class _m_j.geb.AnonymousClass1.AnonymousClass1 */

                    public final void onCoreReady() {
                        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o() {
                            /* class _m_j.geb.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                            public final void onPluginCacheReady() {
                                CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O00oOooO() {
                                    /* class _m_j.geb.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    public final void O000000o() {
                                        O000000o o000000o;
                                        do {
                                            try {
                                                o000000o = geb.this.O00000Oo.removeLast();
                                                geb.O000000o(o000000o.O00000Oo, o000000o.O00000o0, geb.this.O00000o0);
                                                continue;
                                            } catch (NoSuchElementException unused) {
                                                o000000o = null;
                                                continue;
                                            }
                                        } while (o000000o != null);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        }
    };
    public HashSet<gea> O00000o0 = new HashSet<>();

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f17593O000000o;
        public String O00000Oo;
        public boolean O00000o0;

        O000000o() {
        }
    }

    public final boolean onReceiveMessage(String str, String str2) {
        O000000o o000000o = new O000000o();
        o000000o.f17593O000000o = str;
        o000000o.O00000Oo = str2;
        o000000o.O00000o0 = false;
        O000000o(o000000o);
        return true;
    }

    public final boolean onReceiveNotifiedMessage(String str, String str2) {
        this.f17582O000000o = false;
        O000000o o000000o = new O000000o();
        o000000o.f17593O000000o = str;
        o000000o.O00000Oo = str2;
        o000000o.O00000o0 = true;
        O000000o(o000000o);
        return true;
    }

    private void O000000o(final O000000o o000000o) {
        if (!fkl.O000000o().O00000o0()) {
            PluginDeviceManager.instance.updateConfig(false, null);
            fkl.O000000o().O00000Oo();
        }
        try {
            JSONObject jSONObject = new JSONObject(o000000o.O00000Oo);
            final String optString = jSONObject.optString("did");
            if (TextUtils.isEmpty(optString)) {
                gva.O000000o().gotoMyScene();
                return;
            }
            final String optString2 = jSONObject.optString("alertType");
            if (fno.O000000o().O000000o(optString) != null) {
                CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O00oOooO() {
                    /* class _m_j.geb.AnonymousClass3 */

                    public final void O000000o() {
                        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o() {
                            /* class _m_j.geb.AnonymousClass3.AnonymousClass1 */

                            public final void onPluginCacheReady() {
                                if (!TextUtils.isEmpty(optString2)) {
                                    ged.O000000o().O000000o(o000000o.f17593O000000o, optString, optString2);
                                }
                                geb.O000000o(o000000o.O00000Oo, o000000o.O00000o0, geb.this.O00000o0);
                            }
                        });
                    }
                });
            } else if (!this.f17582O000000o) {
                CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
                    /* class _m_j.geb.AnonymousClass2 */

                    public final void onCoreReady() {
                        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o() {
                            /* class _m_j.geb.AnonymousClass2.AnonymousClass1 */

                            public final void onPluginCacheReady() {
                                CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O00oOooO() {
                                    /* class _m_j.geb.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                    public final void O000000o() {
                                        if (!TextUtils.isEmpty(optString2)) {
                                            ged.O000000o().O000000o(o000000o.f17593O000000o, optString, optString2);
                                        }
                                        geb.this.O00000Oo.addFirst(o000000o);
                                        fno.O000000o().O000000o(geb.this.O00000o);
                                        fno.O000000o().O0000Oo0();
                                    }
                                });
                            }
                        });
                    }
                });
            }
        } catch (Exception | JSONException unused) {
        }
    }

    public static void O000000o(String str, String str2, String str3, long j, String str4, boolean z) {
        if (fno.O000000o().O000000o(str2) == null) {
            try {
                fbt fbt = new fbt(ServiceApplication.getAppContext(), "/message/MessageCenterActivity");
                fbt.O00000Oo(268435456);
                fbs.O000000o(fbt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ged.O000000o(str, str2, str3, j, str4, z);
        }
    }

    public static void O000000o(String str, boolean z, HashSet<gea> hashSet) {
        try {
            if (gfr.O0000OOo || gfr.O0000o0o) {
                gsy.O00000Oo("ScenePushListener", "dispatchMessage:".concat(String.valueOf(str)));
            }
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString("model");
            final String optString2 = jSONObject.optString("did");
            final String optString3 = jSONObject.optString("event");
            final long optLong = jSONObject.optLong("time");
            final String optString4 = jSONObject.optString("extra");
            final boolean z2 = z;
            final HashSet<gea> hashSet2 = hashSet;
            final String str2 = str;
            CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
                /* class _m_j.geb.AnonymousClass4 */

                public final void onCoreReady() {
                    boolean z;
                    Device O000000o2;
                    if (!CoreApi.O000000o().O00000o(optString)) {
                        HashSet hashSet = hashSet2;
                        if (hashSet != null) {
                            Iterator it = hashSet.iterator();
                            gea gea = null;
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                gea gea2 = (gea) it.next();
                                String str = optString;
                                String str2 = optString3;
                                String O000000o3 = gea2.O000000o();
                                List<String> O00000Oo2 = gea2.O00000Oo();
                                boolean z2 = false;
                                if (!TextUtils.isEmpty(O000000o3) && !O00000Oo2.isEmpty() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && O000000o3.equals(str)) {
                                    Iterator<String> it2 = O00000Oo2.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            if (it2.next().equals(str2)) {
                                                z = true;
                                                break;
                                            }
                                        } else {
                                            z = false;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        z2 = true;
                                        continue;
                                    } else {
                                        continue;
                                    }
                                }
                                if (z2) {
                                    gea = gea2;
                                    break;
                                }
                            }
                            if (gea != null) {
                                gsy.O00000Oo("ScenePushListener", "targetCallback isNotified:" + z2);
                                return;
                            }
                            gsy.O00000Oo("ScenePushListener", "targetCallback is null");
                            return;
                        }
                        gsy.O00000Oo("ScenePushListener", "not plugin and pushCallbacks is null");
                    } else if (!"mxiang.camera.mwc11".equals(optString) || (O000000o2 = fno.O000000o().O000000o(optString2)) == null) {
                        geb.O000000o(optString, optString2, optString3, optLong, optString4, z2);
                    } else {
                        geb.O000000o("mxiang.camera.mwc10", O000000o2.parentId, optString3, optLong, optString4, z2);
                    }
                }
            });
        } catch (Exception | JSONException unused) {
        }
    }
}

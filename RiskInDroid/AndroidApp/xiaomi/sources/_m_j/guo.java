package _m_j;

import _m_j.exo;
import android.content.Context;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class guo {

    /* renamed from: O000000o  reason: collision with root package name */
    static guo f18306O000000o;
    public List<PluginDownloadTask> O00000Oo;
    int O00000o = 0;
    ger O00000o0;
    int O00000oO = 0;
    int O00000oo = 0;
    boolean O0000O0o = true;
    boolean O0000OOo = true;
    ger O0000Oo;
    boolean O0000Oo0 = true;
    MLAlertDialog O0000OoO = null;
    private Context O0000Ooo = ServiceApplication.getAppContext();
    private HashMap<String, List<gup>> O0000o00 = new HashMap<>();

    public static guo O000000o() {
        if (f18306O000000o == null) {
            f18306O000000o = new guo();
        }
        return f18306O000000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O000000o(android.content.Context, java.lang.String):int
      _m_j.gpv.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String):boolean
      _m_j.gpv.O000000o(java.lang.String, boolean):boolean */
    private guo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("loc_pincode_new");
        arrayList.add("loc_setting_btn_detail_setting");
        arrayList.add("red_point_setting_page");
        new ger(arrayList, gpv.O000000o("loc_pincode_new", true));
    }

    public final void O00000Oo() {
        int i;
        LogType logType = LogType.GENERAL;
        gsy.O000000o(logType, "MessageCenter", "notifyUpdateListenerIfNeeded   " + this.O00000o + "***" + this.O00000oo + "***" + this.O00000oO);
        LogType logType2 = LogType.GENERAL;
        gsy.O000000o(logType2, "MessageCenter", "notifyUpdateListenerIfNeeded   " + this.O0000O0o + "&&&&&&" + this.O0000Oo0 + "&&&&&&" + this.O0000OOo);
        if (this.O0000Oo == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("loc_setting_btn_check_update");
            arrayList.add("loc_setting_btn_detail_setting");
            arrayList.add("red_point_setting_page");
            this.O0000Oo = new ger(arrayList, false);
        }
        if (this.O00000o == 1 || this.O00000oO == 1) {
            if (this.O00000o == 1 && !this.O0000O0o) {
                this.O0000Oo.O000000o(true);
                O00000o0();
                return;
            } else if (this.O00000o == 1 && this.O0000O0o) {
                this.O0000Oo.O000000o("loc_setting_btn_check_update", true);
                this.O0000Oo.O000000o("loc_setting_btn_detail_setting", true);
                this.O0000Oo.O000000o("red_point_setting_page", false);
                return;
            } else if (this.O00000oO == 1 && !this.O0000OOo) {
                this.O0000Oo.O000000o(true);
                O00000o0();
                return;
            } else if (this.O00000oO == 1 && this.O0000OOo) {
                this.O0000Oo.O000000o("loc_setting_btn_check_update", true);
                this.O0000Oo.O000000o("loc_setting_btn_detail_setting", true);
                this.O0000Oo.O000000o("red_point_setting_page", false);
                O00000o0();
                return;
            }
        }
        int i2 = this.O00000o;
        if (i2 == 3 || (i = this.O00000oO) == 3) {
            this.O0000Oo.O000000o("loc_setting_btn_check_update", false);
            this.O0000Oo.O000000o("loc_setting_btn_detail_setting", false);
            this.O0000Oo.O000000o("red_point_setting_page", false);
            O00000o0();
        } else if (i2 == 2 && i == 2) {
            this.O0000Oo.O000000o(false);
            O00000o0();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        this.O00000o = 0;
        this.O00000oO = 0;
        this.O00000oo = 0;
        this.O0000O0o = true;
        this.O0000OOo = true;
        this.O0000Oo0 = true;
    }

    public final void O00000o() {
        if (!fka.O000000o(CommonApplication.getAppContext())) {
            gsy.O00000o0(LogType.PLUGIN, "MessageCenter", "checkRnSdkUpdate: isNetActiveAndAvailable = false,just return");
        } else {
            CoreApi.O000000o().O000000o(this.O0000Ooo, new CoreApi.O0000o00() {
                /* class _m_j.$$Lambda$guo$TNcCRORY5Js881xMbbmWTlsZRFE */

                public final void onAccountReady(boolean z, String str) {
                    guo.this.O000000o(z, str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(boolean z, String str) {
        ServiceApplication.getStateNotifier().O000000o(new exo.O000000o() {
            /* class _m_j.guo.AnonymousClass6 */

            public final void onLoginSuccess() {
                gsy.O00000o0(LogType.PLUGIN, "MessageCenter", " start checkRnSdkUpdate");
                CoreApi.O000000o().O000000o((CoreApi.O0000Oo0) null);
            }

            public final void onLoginFailed() {
                gsy.O00000o0(LogType.PLUGIN, "MessageCenter", "checkRnSdkUpdate:onLoginFailed, try update next time");
            }
        });
    }

    public final void O000000o(String str, Object obj, boolean z) {
        final List list = this.O0000o00.get(str);
        if (list != null) {
            final String str2 = str;
            final Object obj2 = obj;
            final boolean z2 = z;
            ServiceApplication.getGlobalHandler().post(new Runnable() {
                /* class _m_j.guo.AnonymousClass8 */

                public final void run() {
                    for (gup gup : list) {
                        if (str2.equals("new_message")) {
                            gup.O000000o(((Integer) obj2).intValue());
                        } else if (str2.equals("new_update")) {
                            gup.O000000o(((Boolean) obj2).booleanValue(), z2);
                        } else if (str2.equals("new_feedback")) {
                            gup.O00000Oo(((Integer) obj2).intValue());
                        } else if (str2.equals("new_sign_notify")) {
                            gup.O00000Oo(((Boolean) obj2).booleanValue(), z2);
                        }
                    }
                }
            });
        }
    }

    public final void O000000o(String str, gup gup) {
        List list = this.O0000o00.get(str);
        if (list == null) {
            list = new ArrayList();
            this.O0000o00.put(str, list);
        }
        if (!list.contains(gup)) {
            list.add(gup);
        }
    }
}

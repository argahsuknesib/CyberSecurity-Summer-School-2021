package _m_j;

import _m_j.fny;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.auth.ThirdAuthMainActivity;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.authorization.page.DeviceAuthMasterListActivity;
import com.xiaomi.smarthome.device.authorization.page.DeviceAuthSlaveListActivity;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.international.SelectServerActivity;
import com.xiaomi.smarthome.international.ServerHelper$2;
import com.xiaomi.smarthome.international.ServerLocationIncompatibleActivity;
import io.reactivex.Observable;
import java.util.List;

@RouterService
public class ghv implements hsp {
    public void clearTempSubtitle() {
        fra.O000000o();
        fra.O0000O0o();
    }

    public void forceRefresh() {
        fra.O000000o().O00000o();
    }

    public void sendRefreshMsg() {
        fra.O000000o().O00000Oo();
    }

    public void destroyDeviceListSwitch() {
        fra O000000o2 = fra.O000000o();
        O000000o2.O00000oo.removeCallbacksAndMessages(null);
        if (O000000o2.O00000oO != null) {
            O000000o2.O00000oO.destroy();
            O000000o2.O00000oO = null;
        }
        fra.f16942O000000o = null;
    }

    public boolean isDeviceListSwitchInit() {
        return fra.O000000o().O0000O0o;
    }

    public void syncServer(boolean z) {
        gjh.O000000o();
        gjh.O000000o(z);
    }

    public boolean getShopDebugMode() {
        return hta.O000000o();
    }

    public void gotoSelectServerPage(Context context, int i, hsq hsq, String str) {
        gjk.O000000o(context, i, hsq, str);
    }

    public boolean isCN() {
        return gjg.O00000Oo();
    }

    public Observable<String> getServerName(ServerBean serverBean) {
        return gjh.O000000o().O000000o(serverBean);
    }

    public ServerBean getCountryForRecommend() {
        return gjg.O000000o();
    }

    public boolean checkIfSupportVoiceCtrl(String str) {
        fny.O000000o();
        return fny.O000000o(str);
    }

    public void updateDeviceProps(List<String> list) {
        fra.O000000o().O000000o(list);
    }

    public void updateDevicePropsByDevice(List<Device> list) {
        fra.O000000o().O00000Oo(list);
    }

    public boolean checkVoiceCtrlAuthorized(String str) {
        fny.O000000o o000000o = fny.O000000o().O00000Oo;
        if (o000000o.f16730O000000o.size() != 0) {
            int i = 0;
            while (i < o000000o.f16730O000000o.size()) {
                fnx fnx = o000000o.f16730O000000o.get(i);
                if (fnx == null || !TextUtils.equals(str, fnx.f16727O000000o)) {
                    i++;
                } else if (fnx.O00000oO != -1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void addDenyModels(String str) {
        DeviceAuthMasterListActivity.denyModels.add(str);
    }

    public void addLocalDeny() {
        DeviceAuthMasterListActivity.addLocalDeny();
    }

    public Class<?> getServerSelectActivity(Context context) {
        return SelectServerActivity.class;
    }

    public Class<?> getDeviceAuthSlaveListActivity() {
        return DeviceAuthSlaveListActivity.class;
    }

    public Class<?> getThirdAuthMainActivity() {
        return ThirdAuthMainActivity.class;
    }

    public boolean clearAppData(Context context) {
        return hgh.O000000o(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, boolean):boolean
     arg types: [android.content.SharedPreferences, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, boolean):boolean */
    public void gotoServerLocationIncompatiblePage(Context context, ServerBean serverBean) {
        gjk.O000000o();
        if (!gpy.O00000Oo(gjk.f17848O000000o, "pref_key_ignore", false)) {
            AnonymousClass1 r0 = new hsq() {
                /* class _m_j.ghv.AnonymousClass1 */

                public final void O000000o() {
                }

                public final void O00000Oo() {
                }
            };
            if (serverBean == null) {
                r0.O00000Oo();
                return;
            }
            gpr gpr = new gpr(r0);
            ft O000000o2 = ft.O000000o(context);
            ServerHelper$2 serverHelper$2 = new ServerHelper$2(O000000o2, gpr);
            IntentFilter intentFilter = new IntentFilter("action_select_server_local_broadcast_complete");
            intentFilter.addAction("action_select_server_local_broadcast_complete_final");
            O000000o2.O000000o(serverHelper$2, intentFilter);
            Intent intent = new Intent(context, ServerLocationIncompatibleActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("server", serverBean);
            context.startActivity(intent);
        }
    }

    public boolean isMiLoggedInWithoutCoreService(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.xiaomi.smarthome.account", 0);
        if (!TextUtils.isEmpty(gpy.O00000Oo(sharedPreferences, "mi_account", "")) || !TextUtils.isEmpty(gpy.O00000Oo(sharedPreferences, "mi_account_encrypt", ""))) {
            return true;
        }
        return false;
    }
}

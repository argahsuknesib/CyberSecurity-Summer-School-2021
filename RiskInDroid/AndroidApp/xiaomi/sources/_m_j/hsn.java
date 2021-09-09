package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import io.reactivex.Observable;
import java.util.List;

public final class hsn implements hsp {
    public final void addDenyModels(String str) {
    }

    public final void addLocalDeny() {
    }

    public final boolean checkIfSupportVoiceCtrl(String str) {
        return false;
    }

    public final boolean checkVoiceCtrlAuthorized(String str) {
        return false;
    }

    public final boolean clearAppData(Context context) {
        return false;
    }

    public final void clearTempSubtitle() {
    }

    public final void destroyDeviceListSwitch() {
    }

    public final void forceRefresh() {
    }

    public final Class<?> getDeviceAuthSlaveListActivity() {
        return null;
    }

    public final Class<?> getServerSelectActivity(Context context) {
        return null;
    }

    public final Class<?> getThirdAuthMainActivity() {
        return null;
    }

    public final void gotoSelectServerPage(Context context, int i, hsq hsq, String str) {
    }

    public final void gotoServerLocationIncompatiblePage(Context context, ServerBean serverBean) {
    }

    public final boolean isCN() {
        return true;
    }

    public final boolean isDeviceListSwitchInit() {
        return false;
    }

    public final boolean isMiLoggedInWithoutCoreService(Context context) {
        return false;
    }

    public final void sendRefreshMsg() {
    }

    public final void syncServer(boolean z) {
    }

    public final void updateDeviceProps(List<String> list) {
    }

    public final void updateDevicePropsByDevice(List<Device> list) {
    }

    public final Observable<String> getServerName(ServerBean serverBean) {
        return Observable.just("");
    }
}

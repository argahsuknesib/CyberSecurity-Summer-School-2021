package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import io.reactivex.Observable;
import java.util.List;

public interface hsp {
    void addDenyModels(String str);

    void addLocalDeny();

    boolean checkIfSupportVoiceCtrl(String str);

    boolean checkVoiceCtrlAuthorized(String str);

    boolean clearAppData(Context context);

    void clearTempSubtitle();

    void destroyDeviceListSwitch();

    void forceRefresh();

    Class<?> getDeviceAuthSlaveListActivity();

    Observable<String> getServerName(ServerBean serverBean);

    Class<?> getServerSelectActivity(Context context);

    Class<?> getThirdAuthMainActivity();

    void gotoSelectServerPage(Context context, int i, hsq hsq, String str);

    void gotoServerLocationIncompatiblePage(Context context, ServerBean serverBean);

    boolean isCN();

    boolean isDeviceListSwitchInit();

    boolean isMiLoggedInWithoutCoreService(Context context);

    void sendRefreshMsg();

    void syncServer(boolean z);

    void updateDeviceProps(List<String> list);

    void updateDevicePropsByDevice(List<Device> list);
}

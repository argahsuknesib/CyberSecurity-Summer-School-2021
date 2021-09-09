package _m_j;

import _m_j.fuf;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import com.xiaomi.smarthome.smartconfig.callback.ConfigNetRequest;
import java.util.List;
import java.util.Set;

public interface hvb {
    void addBlackList(PushBindEntity pushBindEntity);

    void addTags(Set<String> set, String str, boolean z, huf huf);

    void addToLauncher(Activity activity, boolean z, Device device, Intent intent, String str, hul<Void> hul);

    void bind(String str);

    void bindDeviceToHome(Device device, huf huf);

    void bleDisconnect(String str);

    String buildHomeMIHost(Context context);

    boolean checkAndRequestCameraPermission(Activity activity, htz htz, String str);

    boolean checkLocationGroupGranted();

    boolean checkPassedForCamera(Activity activity, boolean z, huf huf);

    boolean checkScanWifiLocationPermission(Activity activity, boolean z, int i);

    boolean checkScanWifiLocationPermissionAndShowDialog(Activity activity, int i, hui hui);

    <T> void commonRequestHandle(String str, String str2, List<gkw> list, Callback<T> callback, Parser<T> parser);

    void createWifiScanHomelog();

    void endConnect(Context context, String str, String str2);

    void enterPlugin(Device device, Activity activity, hul hul);

    void forcePinCodeSettingForKorean(Device device);

    int generateNonce();

    Context getAppContext();

    boolean getAutoConnectNew(boolean z);

    List<String> getDefaultRecommendTags();

    void getDeviceDetailPageUrl(Context context, String str, View view);

    void getDeviceDetailPageUrl(String str, huf huf);

    Handler getGlobalWorkerHandler();

    void getLocalDeviceListAll(String str, hua<List<Device>, hud> hua);

    void getLocalMiRouterDetail(hul<fuf.O00000o0> hul);

    void getLoginInfo(hua<huv, hud> hua);

    List<String> getRecommendTags(Device device);

    Class<?> getSmartHomeMainActivity();

    void initHomeManager();

    boolean isChinaMainLand(ServerBean serverBean);

    boolean isEurope(Context context);

    boolean isEurope(ServerBean serverBean);

    boolean isLocationEnabled();

    boolean isLoginSuccess();

    Boolean isMiAccountSystem(Context context);

    boolean isMiLoggedIn();

    boolean isNetworkConnected(Context context);

    boolean isWifi();

    void onConnectivityChange();

    void onFinishSmartConfig(String str, boolean z);

    void onScanResultAvailable();

    void onStartCommand();

    void onStartSmartConfig(String str);

    void open(Context context, String str);

    void popActivity(Activity activity);

    void pushActivity(Activity activity);

    void refreshDevice(String str);

    void requestDeviceImage(String str, hua<String, hud> hua);

    void resetCurrentTag();

    void sendBrodCard(String str);

    void sendMessage(Context context, String str, int i, Intent intent, Device device, boolean z, huk huk);

    void sendSmartHomeRequest(ConfigNetRequest configNetRequest, huc huc);

    void showAddRoomDialog(Context context, List<String> list, huf huf);

    void startCheck(hum hum);

    void startConnect(Context context, String str, String str2);

    void startLogin(Context context, int i, huj huj);

    void uploadBluetoothExceptionLog(String str);
}

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
import com.xiaomi.smarthome.framework.page.EmptyPlaceholderActivity;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import com.xiaomi.smarthome.smartconfig.callback.ConfigNetRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class huq implements hvb {
    public final void addBlackList(PushBindEntity pushBindEntity) {
    }

    public final void addTags(Set<String> set, String str, boolean z, huf huf) {
    }

    public final void addToLauncher(Activity activity, boolean z, Device device, Intent intent, String str, hul<Void> hul) {
    }

    public final void bind(String str) {
    }

    public final void bindDeviceToHome(Device device, huf huf) {
    }

    public final void bleDisconnect(String str) {
    }

    public final String buildHomeMIHost(Context context) {
        return "";
    }

    public final boolean checkAndRequestCameraPermission(Activity activity, htz htz, String str) {
        return false;
    }

    public final boolean checkLocationGroupGranted() {
        return false;
    }

    public final boolean checkPassedForCamera(Activity activity, boolean z, huf huf) {
        return false;
    }

    public final boolean checkScanWifiLocationPermission(Activity activity, boolean z, int i) {
        return false;
    }

    public final boolean checkScanWifiLocationPermissionAndShowDialog(Activity activity, int i, hui hui) {
        return false;
    }

    public final <T> void commonRequestHandle(String str, String str2, List<gkw> list, Callback<T> callback, Parser<T> parser) {
    }

    public final void createWifiScanHomelog() {
    }

    public final void endConnect(Context context, String str, String str2) {
    }

    public final void enterPlugin(Device device, Activity activity, hul hul) {
    }

    public final void forcePinCodeSettingForKorean(Device device) {
    }

    public final int generateNonce() {
        return 0;
    }

    public final Context getAppContext() {
        return null;
    }

    public final boolean getAutoConnectNew(boolean z) {
        return false;
    }

    public final void getDeviceDetailPageUrl(Context context, String str, View view) {
    }

    public final void getDeviceDetailPageUrl(String str, huf huf) {
    }

    public final Handler getGlobalWorkerHandler() {
        return null;
    }

    public final void getLocalDeviceListAll(String str, hua<List<Device>, hud> hua) {
    }

    public final void getLocalMiRouterDetail(hul<fuf.O00000o0> hul) {
    }

    public final void getLoginInfo(hua<huv, hud> hua) {
    }

    public final void initHomeManager() {
    }

    public final boolean isChinaMainLand(ServerBean serverBean) {
        return false;
    }

    public final boolean isEurope(Context context) {
        return false;
    }

    public final boolean isEurope(ServerBean serverBean) {
        return false;
    }

    public final boolean isLocationEnabled() {
        return false;
    }

    public final boolean isLoginSuccess() {
        return false;
    }

    public final boolean isMiLoggedIn() {
        return false;
    }

    public final boolean isNetworkConnected(Context context) {
        return false;
    }

    public final boolean isWifi() {
        return false;
    }

    public final void onConnectivityChange() {
    }

    public final void onFinishSmartConfig(String str, boolean z) {
    }

    public final void onScanResultAvailable() {
    }

    public final void onStartCommand() {
    }

    public final void onStartSmartConfig(String str) {
    }

    public final void open(Context context, String str) {
    }

    public final void popActivity(Activity activity) {
    }

    public final void pushActivity(Activity activity) {
    }

    public final void refreshDevice(String str) {
    }

    public final void requestDeviceImage(String str, hua<String, hud> hua) {
    }

    public final void resetCurrentTag() {
    }

    public final void sendBrodCard(String str) {
    }

    public final void sendMessage(Context context, String str, int i, Intent intent, Device device, boolean z, huk huk) {
    }

    public final void sendSmartHomeRequest(ConfigNetRequest configNetRequest, huc huc) {
    }

    public final void showAddRoomDialog(Context context, List<String> list, huf huf) {
    }

    public final void startCheck(hum hum) {
    }

    public final void startConnect(Context context, String str, String str2) {
    }

    public final void startLogin(Context context, int i, huj huj) {
    }

    public final void uploadBluetoothExceptionLog(String str) {
    }

    public final Boolean isMiAccountSystem(Context context) {
        return Boolean.FALSE;
    }

    public final List<String> getDefaultRecommendTags() {
        return new ArrayList();
    }

    public final List<String> getRecommendTags(Device device) {
        return new ArrayList();
    }

    public final Class<?> getSmartHomeMainActivity() {
        return EmptyPlaceholderActivity.class;
    }
}

package com.xiaomi.smarthome.frame.plugin.host;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.FaceManagerCallback;
import com.xiaomi.smarthome.device.api.IXmPluginHostActivity;
import com.xiaomi.smarthome.device.api.RecommendSceneItem;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.device.api.XmPluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public abstract class PluginActivityHostApi {
    public abstract void addToLauncher(DeviceStat deviceStat);

    public abstract void clickHotSpotAd(Activity activity, String str, String str2);

    public abstract void createSceneFrom(Activity activity, String str, String str2, IXmPluginHostActivity.AsyncCallback<String> asyncCallback);

    public abstract void getDeviceRecommendScenes(String str, IXmPluginHostActivity.AsyncCallback<List<RecommendSceneItem>> asyncCallback);

    public abstract List<SceneInfo> getSceneByDid(String str);

    public abstract void goBleMeshDeviceUpdateActivity(Activity activity, String str);

    public abstract void goBleOtaDeviceUpdateActivity(Activity activity, int i, String str, String str2, String str3, String str4);

    public abstract void goToLockWifiConfigStep(Activity activity, String str, String str2);

    public abstract void goUpdateActivity(Activity activity, DeviceStat deviceStat);

    public abstract void goUpdateActivity(Activity activity, DeviceStat deviceStat, Intent intent);

    public abstract void goUpdateActivity(Activity activity, String str);

    public abstract void loadUrl(String str, String str2);

    public abstract void loadUrl(String str, String str2, boolean z);

    public abstract void loadWebView(String str, String str2);

    public abstract void modifySceneName(SceneInfo sceneInfo, IXmPluginHostActivity.AsyncCallback<Void> asyncCallback);

    public abstract void onDeviceReady(Activity activity, String str, String str2, boolean z, IXmPluginHostActivity.AsyncCallback<Void> asyncCallback);

    public abstract void openAddIRController(Activity activity, DeviceStat deviceStat, int i, String[] strArr, Bundle bundle);

    public abstract void openBtGatewayActivity(Activity activity, String str);

    public abstract void openCloudVideoExoPlayerActivity(Activity activity, String str, String str2, String str3);

    public abstract void openCloudVideoListActivity(Activity activity, String str, String str2);

    public abstract void openCloudVideoListActivityForResult(Activity activity, String str, String str2, int i);

    public abstract void openCloudVideoPlayerActivity(Activity activity, String str, String str2, String str3);

    public abstract void openCloudVideoWebActivity(Activity activity, String str, String str2, String str3);

    public abstract void openFaceEmptyActivity(Activity activity, String str);

    public abstract void openFaceManagerActivity(int i, Activity activity, String str, String str2);

    public abstract void openFaceManagerActivity(Activity activity, String str);

    public abstract void openFaceManagerImpl(Activity activity, String str);

    public abstract void openFeedbackActivity(Activity activity, DeviceStat deviceStat);

    public abstract void openGatewaySubDeviceList(Activity activity, String str);

    public abstract void openHelpActivity(Activity activity, DeviceStat deviceStat);

    public abstract void openMarkFaceDialog(Activity activity, String str, String str2, FaceManagerCallback faceManagerCallback);

    public abstract void openMoreMenu(Activity activity, DeviceStat deviceStat, ArrayList<String> arrayList, ArrayList<Intent> arrayList2, boolean z, int i);

    public abstract void openMoreMenu(Activity activity, DeviceStat deviceStat, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i);

    public abstract void openMoreMenu(Activity activity, DeviceStat deviceStat, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent);

    public abstract void openMoreMenu(Activity activity, DeviceStat deviceStat, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent, String str);

    public abstract void openMoreMenu(Activity activity, String str, ArrayList<String> arrayList, ArrayList<Intent> arrayList2, boolean z, int i);

    public abstract void openMoreMenu2(Activity activity, DeviceStat deviceStat, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent);

    public abstract void openMoreMenu2(Activity activity, DeviceStat deviceStat, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent, Intent intent2);

    public abstract void openNetworkInfoActivity(Activity activity, String str);

    public abstract void openOneTimePasswordActivity(Activity activity, String str, int i, int i2);

    public abstract void openOpHistoryActivity(Activity activity, String str);

    public abstract void openPluginRecommendScene(Activity activity, String str, int i);

    public abstract void openPowerSwitchNameActivity(Activity activity, String str, String str2);

    public abstract void openReplaceFaceDialog(Activity activity, String str, String str2, String str3, String str4, FaceManagerCallback faceManagerCallback);

    public abstract void openRnPlugin(Activity activity, String str, Intent intent);

    public abstract void openScanBarcodePage(Activity activity, Bundle bundle, int i);

    public abstract void openSceneActivity(Activity activity, DeviceStat deviceStat, String str);

    public abstract void openScreenDeviceLinkageSettingActivity(Activity activity, String str, boolean z);

    public abstract void openScreenDeviceLinkageSettingActivity(Activity activity, String str, boolean z, int i, String str2);

    public abstract void openShareDeviceActivity(Activity activity, String str);

    public abstract void openShareMediaActivity(Activity activity, String str, String str2, String str3, Bitmap bitmap, DeviceStat deviceStat);

    public abstract void openShareMediaActivity(Activity activity, String str, String str2, String str3, Bitmap bitmap, String str4, Bitmap bitmap2, DeviceStat deviceStat);

    public abstract void openShareMediaActivity(Activity activity, String str, String str2, String str3, DeviceStat deviceStat);

    public abstract void openSharePictureActivity(Activity activity, String str, String str2, String str3);

    public abstract void openShopActivity(String str);

    public abstract void openVerfyPincode(Activity activity, Bundle bundle, int i);

    public abstract void openVirtualGroupInitActivity(Activity activity, String str, int i);

    public abstract void openWxBindActivity(Activity activity, int i);

    public abstract void reportHotSpotAdShow(String str, String str2);

    public abstract void sendPluginAdRequest(Activity activity, String str, String str2);

    public abstract void setSceneEnabled(SceneInfo sceneInfo, boolean z, IXmPluginHostActivity.AsyncCallback<Void> asyncCallback);

    public abstract void share(Activity activity, String str, String str2, String str3, String str4, String str5, Bitmap bitmap);

    public abstract void showBannerAd(Activity activity, ViewGroup viewGroup, String str, String str2);

    public abstract void showBottomDialogAd(Activity activity, String str, String str2);

    public abstract void showBottomFlowAd(Activity activity, String str, String str2);

    public abstract void showNoticeAd(Activity activity, ViewGroup viewGroup, String str, String str2);

    public abstract void showPopAd(Activity activity, String str, String str2);

    public abstract void showUserLicenseDialog(Activity activity, String str, View.OnClickListener onClickListener, String str2);

    public abstract void showUserLicenseDialog(Activity activity, String str, String str2, Spanned spanned, String str3, Spanned spanned2, View.OnClickListener onClickListener, String str4, Intent intent);

    public abstract void showUserLicenseDialog(Activity activity, String str, String str2, String str3, View.OnClickListener onClickListener);

    public abstract void showUserLicenseHtmlDialog(Activity activity, String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, String str6);

    public abstract void showUserLicenseUriDialog(Activity activity, String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, String str6, Intent intent);

    public abstract void showUserLicenseUriDialogV2(Activity activity, String str, boolean z, String str2, String str3, View.OnClickListener onClickListener, String str4, Intent intent);

    public abstract void startAddRoom(Activity activity);

    public abstract void startCreateSceneByDid(Activity activity, String str);

    public abstract void startEditCustomScene(Activity activity);

    public abstract void startEditRecommendScenes(Activity activity, RecommendSceneItem recommendSceneItem, String str, String str2);

    public abstract void startEditScene(Activity activity, int i);

    public abstract void startEditScene(Activity activity, String str);

    public abstract void startLoadScene(IXmPluginHostActivity.AsyncCallback asyncCallback);

    @Deprecated
    public abstract void startLoadScene(XmPluginBaseActivity xmPluginBaseActivity);

    public abstract void startRecommendSceneDetailActivityBy(Activity activity, String str, int i);

    public abstract void startSearchNewDevice(String str, String str2, IXmPluginHostActivity.DeviceFindCallback deviceFindCallback);

    public abstract void startSetTimerCountDown(Activity activity, String str, String str2, String str3, String str4, String str5, boolean z);

    public abstract void startSetTimerCountDownV2(Activity activity, String str, String str2, String str3, String str4, String str5, boolean z, String str6);

    public abstract void startSetTimerCountDownV2(Activity activity, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7);

    public abstract void startSetTimerList(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public abstract void startSetTimerList(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    public abstract void startSetTimerListV2(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11);

    public abstract void startSetTimerListV3(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    public abstract void startSetTimerListV3(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11);

    public abstract void startSetTimerListV4(Activity activity, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, String str8, JSONObject jSONObject);

    public abstract void stopPluginAd(String str);

    public abstract void updatePluginRecommendScenes(Activity activity, String str, IXmPluginHostActivity.AsyncCallback<String> asyncCallback);
}

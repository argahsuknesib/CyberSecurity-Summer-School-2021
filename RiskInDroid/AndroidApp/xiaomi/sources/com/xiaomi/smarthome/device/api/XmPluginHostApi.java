package com.xiaomi.smarthome.device.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothRecord;
import com.xiaomi.smarthome.camera.HLSDownloader;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.IXmStreamClient;
import com.xiaomi.smarthome.camera.XmAAcCodec;
import com.xiaomi.smarthome.camera.XmCameraP2p;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmP2PInfo;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.exopackage.MJExoPlayer;
import com.xiaomi.smarthome.device.api.printer.PrinterControl;
import com.xiaomi.smarthome.device.api.spec.operation.ActionParam;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.device.api.spec.operation.controller.DeviceController;
import com.xiaomi.smarthome.plugin.devicesubscribe.PluginSubscribeCallback;
import com.xiaomi.smarthome.plugin.devicesubscribe.PluginUnSubscribeCallback;
import com.xiaomi.smarthome.plugin.service.HostService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class XmPluginHostApi {
    protected static XmPluginHostApi sXmPluginHostApi;

    public abstract void addRecord(XmPluginPackage xmPluginPackage, String str, Object obj, JSONObject jSONObject);

    @Deprecated
    public abstract void addRecord(String str, String str2, Object obj, JSONObject jSONObject);

    @Deprecated
    public abstract void addRecordV2(XmPluginPackage xmPluginPackage, String str, String str2, Object obj, JSONObject jSONObject);

    public abstract void addRoom(RoomStat roomStat, Callback<RoomStat> callback);

    public abstract void addTag(String str, String str2);

    public abstract void addToLauncher(XmPluginPackage xmPluginPackage, String str, Intent intent);

    public abstract Application application();

    public abstract void bindService(Context context, XmPluginPackage xmPluginPackage, HostService hostService, Class cls, ServiceConnection serviceConnection, int i, Callback<Bundle> callback);

    @Deprecated
    public abstract boolean bindService(Intent intent, XmPluginPackage xmPluginPackage, Class cls, ServiceConnection serviceConnection, int i);

    public abstract void bleSpecOperation(String str, int i, String str2, Callback<Bundle> callback);

    @Deprecated
    public abstract <T> void callHttpApi(String str, String str2, String str3, List<NameValuePair> list, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callHttpApiV13(String str, String str2, String str3, List<KeyValuePair> list, Callback<T> callback, Parser<T> parser);

    @Deprecated
    public abstract <T> void callLocalHttpApi(String str, String str2, String str3, List<NameValuePair> list, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callLocalHttpApiV13(String str, String str2, String str3, List<KeyValuePair> list, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callMethod(String str, String str2, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callMethod(String str, String str2, JSONArray jSONArray, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callMethod(String str, String str2, JSONObject jSONObject, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callMethod(String str, String str2, Object[] objArr, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callMethodFromCloud(String str, String str2, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callMethodFromCloud(String str, String str2, Object obj, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callMethodFromLocal(String str, String str2, Callback<T> callback, Parser<T> parser);

    public abstract void callRemoteAsync(String[] strArr, int i, Object obj, Callback<JSONObject> callback);

    public abstract void callRemoteAsync(String[] strArr, int i, Object obj, Callback<JSONObject> callback, Callback<JSONObject> callback2);

    @Deprecated
    public abstract <T> void callRouterRemoteApi(String str, String str2, String str3, boolean z, List<NameValuePair> list, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callRouterRemoteApiV13(String str, String str2, String str3, boolean z, List<KeyValuePair> list, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callSmartHomeApi(String str, String str2, String str3, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callSmartHomeApi(String str, String str2, String str3, String str4, String str5, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callSmartHomeApi(String str, String str2, String str3, String str4, JSONObject jSONObject, Callback<T> callback, Parser<T> parser);

    public abstract <T> void callSmartHomeApi(String str, String str2, JSONObject jSONObject, Callback<T> callback, Parser<T> parser);

    public abstract void cancelDownloadBleFirmware(String str);

    public abstract void cancelDownloadFile(String str, String str2, boolean z, String str3, ICloudDataCallback iCloudDataCallback);

    public abstract boolean checkAndRequestPermisson(Activity activity, boolean z, Callback<List<String>> callback, String... strArr);

    public abstract boolean checkAndShowVoiceCtrlAuthorizePageIfNeed(Activity activity, String str, int i);

    @Deprecated
    public abstract void checkLocalRouterInfo(String str, Callback<Void> callback);

    public abstract void closeCameraFloatingView(String str);

    public abstract void closeCameraFloatingWindow(String str);

    public abstract void closeCameraFrameSender(String str);

    public abstract void connectBand(String str, Callback<Integer> callback);

    public abstract Context context();

    public abstract XmAAcCodec createAAcCodec(boolean z, int i, int i2, int i3);

    public abstract XmCameraP2p createCameraP2p(XmP2PInfo xmP2PInfo, int i);

    public abstract IXmConnectionClient createConnectionClient(XmP2PInfo xmP2PInfo, DeviceStat deviceStat, String str, boolean z);

    public abstract IXmConnectionClient createConnectionClient(XmP2PInfo xmP2PInfo, DeviceStat deviceStat, boolean z);

    public abstract void createDeviceGroup(Context context, String str);

    public abstract MJExoPlayer createExoPlayer(Context context, ViewGroup viewGroup, AttributeSet attributeSet, int i);

    public abstract XmMp4Record createMp4Record();

    public abstract XmVideoViewGl createMp4View(Context context, FrameLayout frameLayout, boolean z);

    public abstract IXmStreamClient createStreamClient(String str, String str2, DeviceStat deviceStat);

    public abstract XmVideoViewGl createVideoView(Context context, FrameLayout frameLayout, boolean z, int i);

    public abstract XmVideoViewGl createVideoViewOnFront(Context context, FrameLayout frameLayout, boolean z, int i);

    public abstract IWXAPI createWXAPI(Context context, boolean z);

    public abstract void deInitBandManager();

    public abstract String decodeBarcode(Bitmap bitmap);

    public abstract void deleteCard(String str, Callback<Boolean> callback);

    public abstract void deleteRoom(List<String> list, Callback<Void> callback);

    public abstract void deviceRename(String str, String str2);

    public abstract void doAction(Context context, ActionParam actionParam, Callback<ActionParam> callback);

    public abstract void downloadBleFirmware(String str, Response.BleUpgradeResponse bleUpgradeResponse);

    public abstract void downloadFirmware(String str, Response.FirmwareUpgradeResponse firmwareUpgradeResponse);

    public abstract void editSceneV2(String str, int i, String str2, String str3, String str4, String str5, JSONObject jSONObject, JSONArray jSONArray, Callback<JSONObject> callback);

    public abstract Bitmap encodeBarcode(String str, int i, int i2);

    public abstract String generateRequestUrl(String str, JSONObject jSONObject, JSONObject jSONObject2);

    public abstract String generateRequestUrl2(String str, String str2, String str3, boolean z, String str4);

    public abstract String getAccountId();

    public abstract void getAllCards(Callback<String> callback);

    public abstract int getApiLevel();

    public abstract void getAppConfig(String str, String str2, String str3, Callback<String> callback);

    public abstract void getAreaPropInfo(String str, String str2, String str3, String str4, String str5, Callback<String> callback);

    public abstract void getBindKey(String str, Callback<String> callback);

    public abstract List<DeviceStat> getBleGatewayDeviceList();

    public abstract void getBleGatewaySubDevices(List<String> list, Callback<List<DeviceStat>> callback);

    public abstract void getBleMeshFirmwareUpdateInfo(String str, String str2, Callback<BleMeshFirmwareUpdateInfo> callback);

    public abstract void getBluetoothFirmwareUpdateInfo(String str, Callback<BtFirmwareUpdateInfo> callback);

    public abstract void getBluetoothFirmwareUpdateInfoV2(String str, String str2, int i, Callback<BtFirmwareUpdateInfoV2> callback);

    public abstract String getChannel();

    public abstract String getCloudImageUrl(String str, String str2, String str3);

    public abstract void getCloudVideoFile(Context context, String str, ICloudDataCallback iCloudDataCallback);

    public abstract void getCloudVideoFile(String str, String str2, String str3, ICloudDataCallback iCloudDataCallback);

    public abstract void getCloudVideoFile(String str, String str2, String str3, boolean z, ICloudDataCallback iCloudDataCallback);

    public abstract void getControllableDevices(String str, Callback<JSONObject> callback);

    public abstract List<DeviceStat> getCurrentHomeDevicesWithModel(String str);

    public abstract List<DeviceStat> getCurrentHomeDevicesWithPid(int i);

    public abstract String getCurrentServer();

    public abstract void getDefaultCardAndActivateInfo(Callback<String> callback);

    public abstract DeviceStat getDeviceByDid(String str);

    public abstract List<DeviceStat> getDeviceList();

    public abstract List<DeviceStat> getDeviceListV2(List<String> list);

    public abstract String getDevicePincode(String str);

    public abstract JSONArray getDeviceProp(String str);

    public abstract void getDeviceRealIconByModel(String str, Callback<Bitmap> callback);

    public abstract DeviceTag getDeviceTagByDid(String str);

    public abstract int getDrawableResIdByName(XmPluginPackage xmPluginPackage, String str);

    public abstract void getFile(String str, String str2, String str3, ICloudDataCallback iCloudDataCallback);

    public abstract List<DeviceStat> getFilterBluetoothDeviceList(String str);

    public abstract void getFirmwareUpdateInfoCommon(String str, Callback<FirmwareUpdateInfo> callback);

    public abstract Typeface getFont(String str);

    @Deprecated
    public abstract String getGlobalSettingServer();

    @Deprecated
    public abstract String getGlobalSettingServer(boolean z);

    public abstract HLSDownloader getHLSDownloader(String str);

    public abstract List<DeviceStat> getIrDevList();

    public abstract Location getLastLocation();

    public abstract String getLightDeviceGroupModel(String str);

    public abstract int getMiHomeNotificationIcon();

    public abstract String getOauthServiceToken();

    public abstract String getOauthUserId();

    public abstract PrinterControl getPrinterControl();

    public abstract ProductInfo getProductInfo(String str);

    public abstract String getProperty(String str, String str2);

    public abstract void getPropertyValues(Context context, List<PropertyParam> list, Callback<List<PropertyParam>> callback);

    public abstract String getQrDebugModePackageName();

    public abstract void getRechargeBalances(int i, double d, double d2, Callback<JSONObject> callback);

    public abstract void getRecommendScenes(String str, String str2, Callback<JSONObject> callback);

    public abstract void getRecommendScenes2(String str, String str2, Callback<JSONObject> callback);

    public abstract List<String> getRecommendTags(String str);

    public abstract List<RoomStat> getRoomAll();

    public abstract String getRouterFileDownloadUrl(String str);

    public abstract void getServerName(Callback<String> callback);

    public abstract void getServiceToken(String str, Callback<JSONObject> callback);

    public abstract Locale getSettingLocale();

    public abstract DeviceController getSpecDeviceController(String str);

    public abstract List<DeviceStat> getSubDeviceByParentDid(String str);

    @Deprecated
    public abstract long getUTCTimeInMillis();

    public abstract int getUsePreviewConfig();

    public abstract void getUserConfigV5(XmPluginPackage xmPluginPackage, String str, int[] iArr, Callback<Map<String, Object>> callback);

    public abstract void getUserInfo(String str, Callback<UserInfo> callback);

    public abstract String getVirtualGroupStatus(String str);

    public abstract void getWxPushSwitchState(String str, String str2, Callback<Boolean> callback);

    public abstract void gotoAuthManagerPage(Activity activity, String str);

    public abstract void gotoFeedback(Activity activity, String str, String str2, XmPluginPackage xmPluginPackage);

    public abstract void gotoPage(Context context, XmPluginPackage xmPluginPackage, Uri uri, Callback<Void> callback);

    public abstract void initBandManager(String str, String str2, Callback<Boolean> callback);

    public abstract void initCameraFrameSender(String str);

    public abstract void invalideOauthServiceToken();

    public abstract boolean isAmerica(Context context);

    public abstract boolean isChinaMainLand(Context context);

    public abstract boolean isDarkMode(Activity activity);

    public abstract boolean isEurope(Context context);

    public abstract boolean isGPSLocationEnable();

    public abstract boolean isIndia(Context context);

    public abstract boolean isInternationalServer(Context context);

    public abstract boolean isKorea(Context context);

    @Deprecated
    public abstract boolean isLocalMiRouter();

    public abstract boolean isModelSupport(String str);

    public abstract boolean isNetworkLocationEnabled();

    public abstract boolean isRNPluginDarkMode();

    public abstract boolean isRussia(Context context);

    public abstract boolean isSingapore(Context context);

    public abstract boolean isTW(Context context);

    public abstract boolean isUsrExpPlanEnabled(String str);

    public abstract void issueDoorCard(Callback<Boolean> callback);

    public abstract void loadBitmap(String str, Callback<Bitmap> callback);

    @Deprecated
    public abstract void loadLibrary(XmPluginPackage xmPluginPackage, String str);

    @Deprecated
    public abstract void loadLibrary(String str, String str2, ClassLoader classLoader);

    public abstract void localPing(String str, Callback<Void> callback);

    public abstract void localPingWithParams(String str, int i, int i2, Callback<Void> callback);

    public abstract void log(String str, String str2);

    public abstract void logByModel(String str, String str2);

    public abstract void logForModel(String str, String str2);

    public abstract void modDeviceName(String str, String str2, Callback<Void> callback);

    public abstract void notifyBluetoothBinded(String str, String str2);

    @Deprecated
    public abstract void notifyLocalWifiConnect(boolean z);

    public abstract void onRNRuntimeReuseDisable(int i);

    public abstract void openCameraFloatingView(String str);

    public abstract void openCameraFloatingWindow(String str);

    public abstract void openXiaoAiLearnPage(Activity activity, String str, boolean z);

    @Deprecated
    public abstract void pauseDownload(long... jArr);

    @Deprecated
    public abstract Cursor queryDownload(boolean z, long... jArr);

    @Deprecated
    public abstract void recordCalculateEvent(String str, String str2, long j);

    @Deprecated
    public abstract void recordCalculateEvent(String str, String str2, long j, Map<String, String> map);

    @Deprecated
    public abstract void recordCountEvent(String str, String str2);

    @Deprecated
    public abstract void recordCountEvent(String str, String str2, Map<String, String> map);

    @Deprecated
    public abstract void recordNumericPropertyEvent(String str, String str2, long j);

    @Deprecated
    public abstract void recordStringPropertyEvent(String str, String str2, String str3);

    public abstract void refreshDeviceListUi();

    @Deprecated
    public abstract void removeDownload(long... jArr);

    public abstract void removeTag(String str);

    public abstract void renameRoom(String str, String str2, Callback<Void> callback);

    public abstract void reportBluetoothRecords(String str, String str2, List<XmBluetoothRecord> list, Callback<List<Boolean>> callback);

    public abstract void requestLocation(Callback<Location> callback);

    @Deprecated
    public abstract void restartDownload(long... jArr);

    @Deprecated
    public abstract void resumeDownload(long... jArr);

    public abstract void reverseGeo(double d, double d2, Callback<Address> callback);

    public abstract void saveStringToNotesAppOnMIUI(String str, Callback<Void> callback);

    public abstract void sendCameraFrame(String str, byte[] bArr, long j, int i, long j2, int i2, boolean z, int i3, int i4);

    public abstract void sendCameraFrame(String str, byte[] bArr, long j, int i, long j2, boolean z, int i2, int i3);

    public abstract void sendFeedbackLog(String str, String str2);

    public abstract byte[] sendImageDownloadRequest(Context context, String str);

    public abstract void sendMessage(String str, int i, Intent intent, DeviceStat deviceStat, MessageCallback messageCallback);

    public abstract void setBleDeviceSubtitle(String str, String str2);

    public abstract void setDefaultCard(String str, Callback<Boolean> callback);

    public abstract void setPropertyValue(Context context, PropertyParam propertyParam, Callback<PropertyParam> callback);

    public abstract void setSubDeviceShownMode(XmPluginPackage xmPluginPackage, boolean z, String str, Context context, Callback<Void> callback);

    public abstract void setUserConfigV5(XmPluginPackage xmPluginPackage, String str, int i, Map<String, Object> map, Callback<int[]> callback);

    public abstract void setUserDeviceData(String str, String str2, String str3, String str4, long j, Object obj, Callback<JSONArray> callback);

    public abstract void setUsrExpPlanEnabled(String str, boolean z);

    public abstract void setWxPush(Activity activity, String str, String str2, boolean z, int i, Callback<Boolean> callback);

    public abstract void startActivity(Context context, XmPluginPackage xmPluginPackage, Intent intent, String str, Class cls);

    @Deprecated
    public abstract long startDownload(Uri uri, String str, String str2, String str3);

    public abstract void startService(Context context, XmPluginPackage xmPluginPackage, HostService hostService, Intent intent, Class cls, Callback<Bundle> callback);

    @Deprecated
    public abstract void startService(Intent intent, XmPluginPackage xmPluginPackage, Class cls);

    public abstract void statReport(String str, String str2, Map<String, Object> map);

    public abstract void stopService(Context context, XmPluginPackage xmPluginPackage, HostService hostService, Intent intent, Class cls, Callback<Bundle> callback);

    @Deprecated
    public abstract boolean stopService(Intent intent, XmPluginPackage xmPluginPackage, Class cls);

    public abstract void subscribeDevice(String str, int i, List<String> list, int i2, Callback<Void> callback);

    public abstract void subscribeDeviceV2(String str, int i, List<String> list, int i2, PluginSubscribeCallback pluginSubscribeCallback);

    public abstract void unBindDevice(String str, int i, Callback<Void> callback);

    public abstract void unbindService(Context context, XmPluginPackage xmPluginPackage, HostService hostService, Class cls, ServiceConnection serviceConnection, Callback<Bundle> callback);

    public abstract void unsubscribeDevice(String str, int i, List<String> list, Callback<Void> callback);

    public abstract void unsubscribeDeviceV2(String str, int i, List<String> list, String str2, PluginUnSubscribeCallback pluginUnSubscribeCallback);

    public abstract void updateCard(String str, Callback<Boolean> callback);

    public abstract void updateDevice(List<String> list, Callback<List<DeviceStat>> callback);

    public abstract void updateDeviceList(Callback<Void> callback);

    public abstract void updateDeviceProperties(String str, JSONObject jSONObject);

    public abstract void updateP2pPwd(DeviceStat deviceStat, int i, Callback<XmP2PInfo> callback);

    public abstract void updateSubDevice(XmPluginPackage xmPluginPackage, String[] strArr, Callback<List<DeviceStat>> callback);

    public abstract void uploadImageFile(String str, String str2, String str3, String str4, JSONObject jSONObject, List<String> list, ICloudDataCallback<JSONObject> iCloudDataCallback);

    public abstract int videoConverter(String str, String str2);

    public abstract void visualSecureBind(String str);

    public static XmPluginHostApi instance() {
        return sXmPluginHostApi;
    }

    public void getSubDevice(String str, String[] strArr, Callback<List<DeviceStat>> callback) {
        JSONObject jSONObject = new JSONObject();
        if (strArr != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String put : strArr) {
                    jSONArray.put(put);
                }
                jSONObject.put("dids", jSONArray);
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                    return;
                }
            }
        }
        WifiInfo connectionInfo = ((WifiManager) context().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        String bssid = connectionInfo != null ? connectionInfo.getBSSID() : null;
        if (!TextUtils.isEmpty(bssid)) {
            jSONObject.put("uid", bssid.toUpperCase());
        }
        callSmartHomeApi(str, "/home/sub_device_list", jSONObject, callback, new Parser<List<DeviceStat>>() {
            /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass1 */

            public List<DeviceStat> parse(String str) throws JSONException {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("list");
                if (optJSONArray == null) {
                    return arrayList;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    DeviceStat deviceStat = new DeviceStat();
                    deviceStat.did = jSONObject.optString("did");
                    deviceStat.model = jSONObject.optString("model");
                    deviceStat.name = jSONObject.optString("name");
                    deviceStat.bindFlag = jSONObject.optInt("adminFlag");
                    deviceStat.authFlag = jSONObject.optInt("shareFlag");
                    deviceStat.ip = jSONObject.optString("localip");
                    deviceStat.mac = jSONObject.optString("mac");
                    deviceStat.parentModel = jSONObject.optString("parent_model");
                    deviceStat.parentId = jSONObject.optString("parent_id");
                    deviceStat.isOnline = jSONObject.optBoolean("isOnline");
                    arrayList.add(deviceStat);
                }
                return arrayList;
            }
        });
    }

    public void addRecordV3(XmPluginPackage xmPluginPackage, String str, String str2, Object obj, JSONObject jSONObject) {
        if (str != null) {
            String trim = str.toLowerCase().trim();
            if (!trim.isEmpty()) {
                str2 = trim + ":" + str2;
            }
        }
        addRecord(xmPluginPackage, str2, obj, jSONObject);
    }

    @Deprecated
    public void loadScene(String str, int i, String str2, String str3, Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("st_id", i);
            jSONObject.put("identify", str2);
            if (str3 != null && !str3.equals("")) {
                jSONObject.put("name", str3);
            }
            callSmartHomeApi(str, "/scene/list", jSONObject, callback, new Parser<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass2 */

                public JSONObject parse(String str) throws JSONException {
                    return new JSONObject(str);
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    @Deprecated
    public void editScene(String str, int i, int i2, String str2, String str3, JSONObject jSONObject, JSONArray jSONArray, Callback<JSONObject> callback) {
        if (i2 >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("us_id", String.valueOf(i2));
                jSONObject2.put("identify", str2);
                jSONObject2.put("name", str3);
                jSONObject2.put("st_id", i);
                jSONObject2.put("setting", jSONObject);
                jSONObject2.put("authed", jSONArray);
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                    return;
                }
            }
            callSmartHomeApi(str, "/scene/edit", jSONObject2, callback, new Parser<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass3 */

                public JSONObject parse(String str) throws JSONException {
                    return new JSONObject(str);
                }
            });
        } else if (callback != null) {
            callback.onFailure(-1, "us_id is illegal");
        }
    }

    @Deprecated
    public void editTimerScene(String str, String str2, int i, String str3, JSONObject jSONObject, JSONArray jSONArray, Callback<JSONObject> callback) {
        if (i >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("us_id", String.valueOf(i));
                jSONObject2.put("identify", str2);
                jSONObject2.put("name", str3);
                jSONObject2.put("st_id", 8);
                jSONObject2.put("setting", jSONObject);
                jSONObject2.put("authed", jSONArray);
                callSmartHomeApi(str, "/scene/edit", jSONObject2, callback, new Parser<JSONObject>() {
                    /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass4 */

                    public JSONObject parse(String str) throws JSONException {
                        return new JSONObject(str);
                    }
                });
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                }
            }
        } else if (callback != null) {
            callback.onFailure(-1, "us_id is illegal");
        }
    }

    public void editTimerScene(String str, String str2, String str3, String str4, JSONObject jSONObject, JSONArray jSONArray, Callback<JSONObject> callback) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str3) && !TextUtils.equals("0", str3)) {
                jSONObject2.put("us_id", str3);
            }
            jSONObject2.put("identify", str2);
            jSONObject2.put("name", str4);
            jSONObject2.put("st_id", 8);
            jSONObject2.put("setting", jSONObject);
            jSONObject2.put("authed", jSONArray);
            callSmartHomeApi(str, "/scene/edit", jSONObject2, callback, new Parser<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass5 */

                public JSONObject parse(String str) throws JSONException {
                    return new JSONObject(str);
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public void loadTimerScenes(String str, String str2, Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identify", str2);
            jSONObject.put("st_id", 8);
            callSmartHomeApi(str, "/scene/list", jSONObject, callback, new Parser<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass6 */

                public JSONObject parse(String str) throws JSONException {
                    return new JSONObject(str);
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    @Deprecated
    public void loadTimerScene(String str, String str2, String str3, Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identify", str2);
            if (str3 != null && !str3.equals("")) {
                jSONObject.put("name", str3);
            }
            callSmartHomeApi(str, "/scene/list", jSONObject, callback, new Parser<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass7 */

                public JSONObject parse(String str) throws JSONException {
                    return new JSONObject(str);
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    @Deprecated
    public void getTimerScene(String str, String str2, int i, Callback<JSONObject> callback) {
        if (i >= 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("identify", str2);
                jSONObject.put("us_id", String.valueOf(i));
                callSmartHomeApi(str, "/scene/get", jSONObject, callback, new Parser<JSONObject>() {
                    /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass8 */

                    public JSONObject parse(String str) throws JSONException {
                        return new JSONObject(str);
                    }
                });
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                }
            }
        } else if (callback != null) {
            callback.onFailure(-1, "us_id is illegal");
        }
    }

    @Deprecated
    public void getTimerScene(String str, String str2, String str3, Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identify", str2);
            if (!TextUtils.isEmpty(str3) && !TextUtils.equals("0", str3)) {
                jSONObject.put("us_id", str3);
            }
            callSmartHomeApi(str, "/scene/get", jSONObject, callback, new Parser<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass9 */

                public JSONObject parse(String str) throws JSONException {
                    return new JSONObject(str);
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    @Deprecated
    public void delScene(String str, String str2, int i, Callback<JSONObject> callback) {
        if (i > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("identify", str2);
                jSONObject.put("us_id", String.valueOf(i));
                callSmartHomeApi(str, "/scene/delete", jSONObject, callback, new Parser<JSONObject>() {
                    /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass10 */

                    public JSONObject parse(String str) throws JSONException {
                        return new JSONObject(str);
                    }
                });
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                }
            }
        } else if (callback != null) {
            callback.onFailure(-1, "us_id is illegal");
        }
    }

    public void setScene(String str, String str2, String str3, int i, JSONObject jSONObject, JSONArray jSONArray, Callback<Void> callback) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("identify", str2);
            jSONObject2.put("name", str3);
            jSONObject2.put("st_id", i);
            jSONObject2.put("setting", jSONObject);
            jSONObject2.put("authed", jSONArray);
            jSONObject2.put("setting", jSONObject);
            callSmartHomeApi(str, "/scene/idfy_edit", jSONObject2, callback, (Parser) null);
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public void getScene(String str, String str2, Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identify", str2);
            callSmartHomeApi(str, "/scene/idfy_get", jSONObject, callback, new Parser<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass11 */

                public JSONObject parse(String str) throws JSONException {
                    return new JSONObject(str);
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public void startScene(String str, String str2, String str3, Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identify", str2);
            jSONObject.put("key", str3);
            callSmartHomeApi(str, "/scene/idfy_start", jSONObject, callback, new Parser<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass12 */

                public JSONObject parse(String str) throws JSONException {
                    return new JSONObject(str);
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public void reportGPSInfo(String str, String str2, double d, double d2, String str3, String str4, String str5, String str6, String str7, Callback<Void> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            jSONObject.put("lng", d);
            jSONObject.put("lat", d2);
            jSONObject.put("adminArea", str3);
            jSONObject.put("countryCode", str4);
            jSONObject.put("locality", str5);
            jSONObject.put("thoroughfare", str6);
            jSONObject.put("language", "zh_CN");
            jSONObject.put("subLocality", str7);
            callSmartHomeApi(str, "/location/set", jSONObject, callback, (Parser) null);
        } catch (JSONException e) {
            callback.onFailure(-1, e.toString());
        }
    }

    public void getWeatherInfo(String str, String str2, Callback<WeatherInfo> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            callSmartHomeApi(str, "/location/weather", jSONObject, callback, new Parser<WeatherInfo>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass13 */

                public WeatherInfo parse(String str) throws JSONException {
                    JSONObject jSONObject = new JSONObject(str);
                    WeatherInfo weatherInfo = new WeatherInfo();
                    JSONObject optJSONObject = jSONObject.optJSONObject("aqi");
                    weatherInfo.aqi.city = optJSONObject.optString("city");
                    weatherInfo.aqi.city_id = optJSONObject.optString("city_id");
                    weatherInfo.aqi.pub_time = optJSONObject.optString("pub_time");
                    weatherInfo.aqi.aqi = optJSONObject.optString("aqi");
                    weatherInfo.aqi.pm25 = optJSONObject.optString("pm25");
                    weatherInfo.aqi.pm10 = optJSONObject.optString("pm10");
                    weatherInfo.aqi.so2 = optJSONObject.optString("so2");
                    weatherInfo.aqi.no2 = optJSONObject.optString("no2");
                    weatherInfo.aqi.src = optJSONObject.optString("src");
                    weatherInfo.aqi.spot = optJSONObject.optString("spot");
                    return weatherInfo;
                }
            });
        } catch (JSONException e) {
            callback.onFailure(-1, e.toString());
        }
    }

    @Deprecated
    public void getUpdateInfo(String str, String str2, int i, Callback<DeviceUpdateInfo> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            jSONObject.put("pid", i);
            callSmartHomeApi(str, "/home/checkversion", jSONObject, callback, new Parser<DeviceUpdateInfo>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass14 */

                public DeviceUpdateInfo parse(String str) throws JSONException {
                    DeviceUpdateInfo deviceUpdateInfo = new DeviceUpdateInfo();
                    JSONObject jSONObject = new JSONObject(str);
                    deviceUpdateInfo.mHasNewFirmware = !jSONObject.optBoolean("updating") && !jSONObject.optBoolean("isLatest");
                    deviceUpdateInfo.mCurVersion = jSONObject.optString("curr");
                    deviceUpdateInfo.mNewVersion = jSONObject.optString("latest");
                    deviceUpdateInfo.mUpdateDes = jSONObject.optString("description");
                    deviceUpdateInfo.mForce = jSONObject.optInt("force");
                    return deviceUpdateInfo;
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public void loadScene(String str, int i, String str2, String str3, String str4, Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("st_id", i);
            jSONObject.put("did", str2);
            jSONObject.put("identify", str3);
            callSmartHomeApi(str, "/scene/list", jSONObject, callback, new Parser<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass15 */

                public JSONObject parse(String str) throws JSONException {
                    return new JSONObject(str);
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    @Deprecated
    public void editScene(String str, int i, int i2, String str2, String str3, String str4, JSONObject jSONObject, JSONArray jSONArray, Callback<JSONObject> callback) {
        if (i2 >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("us_id", String.valueOf(i2));
                jSONObject2.put("identify", str3);
                if (str4 != null) {
                    jSONObject2.put("name", str4);
                }
                jSONObject2.put("st_id", i);
                jSONObject2.put("setting", jSONObject);
                jSONObject2.put("authed", jSONArray);
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                    return;
                }
            }
            callSmartHomeApi(str, "/scene/edit", jSONObject2, callback, new Parser<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass16 */

                public JSONObject parse(String str) throws JSONException {
                    return new JSONObject(str);
                }
            });
        } else if (callback != null) {
            callback.onFailure(-1, "us_id is illegal");
        }
    }

    public void editScene(String str, int i, String str2, String str3, String str4, String str5, JSONObject jSONObject, JSONArray jSONArray, Callback<JSONObject> callback) {
        if (!TextUtils.isEmpty(str2)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("us_id", str2);
                jSONObject2.put("identify", str4);
                if (str5 != null) {
                    jSONObject2.put("name", str5);
                }
                jSONObject2.put("st_id", i);
                jSONObject2.put("setting", jSONObject);
                jSONObject2.put("authed", jSONArray);
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                    return;
                }
            }
            callSmartHomeApi(str, "/scene/edit", jSONObject2, callback, new Parser<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass17 */

                public JSONObject parse(String str) throws JSONException {
                    return new JSONObject(str);
                }
            });
        } else if (callback != null) {
            callback.onFailure(-1, "us_id is illegal");
        }
    }

    @Deprecated
    public void delScene(String str, int i, Callback<JSONObject> callback) {
        if (i > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("us_id", String.valueOf(i));
                callSmartHomeApi(str, "/scene/delete", jSONObject, callback, new Parser<JSONObject>() {
                    /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass18 */

                    public JSONObject parse(String str) throws JSONException {
                        return new JSONObject(str);
                    }
                });
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                }
            }
        } else if (callback != null) {
            callback.onFailure(-1, "us_id is illegal");
        }
    }

    public void delScene(String str, String str2, Callback<JSONObject> callback) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.equals("0", str2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("us_id", str2);
                callSmartHomeApi(str, "/scene/delete", jSONObject, callback, new Parser<JSONObject>() {
                    /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass19 */

                    public JSONObject parse(String str) throws JSONException {
                        return new JSONObject(str);
                    }
                });
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                }
            }
        } else if (callback != null) {
            callback.onFailure(-1, "us_id is illegal");
        }
    }

    public void delScenes(String str, List<String> list, Callback<JSONObject> callback) {
        if (list != null && list.size() != 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                for (String next : list) {
                    if (!TextUtils.isEmpty(next) && !TextUtils.equals("0", next)) {
                        jSONArray.put(next);
                    }
                }
                if (jSONArray.length() != 0) {
                    jSONObject.put("us_id", jSONArray);
                    callSmartHomeApi(str, "/scene/delete", jSONObject, callback, new Parser<JSONObject>() {
                        /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass20 */

                        public JSONObject parse(String str) throws JSONException {
                            return new JSONObject(str);
                        }
                    });
                } else if (callback != null) {
                    callback.onFailure(-1, "has illegal id");
                }
            } catch (JSONException unused) {
                if (callback != null) {
                    callback.onFailure(-1, "json exception");
                }
            }
        } else if (callback != null) {
            callback.onFailure(-1, "us_ids is null");
        }
    }

    public void reportGPSInfo(final String str, final Callback<Void> callback) {
        if (!TextUtils.isEmpty(str)) {
            final DeviceStat deviceByDid = getDeviceByDid(str);
            if (deviceByDid != null) {
                requestLocation(new Callback<Location>() {
                    /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass21 */

                    public void onSuccess(Location location) {
                        if (location == null) {
                            Callback callback = callback;
                            if (callback != null) {
                                callback.onFailure(-1, "");
                                return;
                            }
                            return;
                        }
                        Address address = null;
                        try {
                            List<Address> fromLocation = new Geocoder(XmPluginHostApi.this.context()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                            if (fromLocation != null && fromLocation.size() > 0) {
                                address = fromLocation.get(0);
                            }
                        } catch (IOException unused) {
                        }
                        if (address == null) {
                            Callback callback2 = callback;
                            if (callback2 != null) {
                                callback2.onFailure(-1, "");
                                return;
                            }
                            return;
                        }
                        XmPluginHostApi.this.reportGPSInfo(deviceByDid.model, str, location.getLongitude(), location.getLatitude(), address.getAdminArea(), address.getCountryCode(), address.getLocality(), address.getThoroughfare(), address.getSubLocality(), callback);
                    }

                    public void onFailure(int i, String str) {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onFailure(i, str);
                        }
                    }
                });
            } else if (callback != null) {
                callback.onFailure(-1, "");
            }
        } else if (callback != null) {
            callback.onFailure(-1, "");
        }
    }

    public void reportDeviceGPSInfo(final String str, final Callback<JSONObject> callback) {
        if (!TextUtils.isEmpty(str)) {
            final DeviceStat deviceByDid = getDeviceByDid(str);
            if (deviceByDid != null) {
                requestLocation(new Callback<Location>() {
                    /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass22 */

                    public void onSuccess(Location location) {
                        if (location == null) {
                            Callback callback = callback;
                            if (callback != null) {
                                callback.onFailure(-1, "");
                                return;
                            }
                            return;
                        }
                        Address address = null;
                        try {
                            List<Address> fromLocation = new Geocoder(XmPluginHostApi.this.context()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                            if (fromLocation != null && fromLocation.size() > 0) {
                                address = fromLocation.get(0);
                            }
                        } catch (IOException unused) {
                        }
                        if (address == null) {
                            Callback callback2 = callback;
                            if (callback2 != null) {
                                callback2.onFailure(-1, "");
                                return;
                            }
                            return;
                        }
                        String adminArea = address.getAdminArea();
                        String countryCode = address.getCountryCode();
                        String locality = address.getLocality();
                        String thoroughfare = address.getThoroughfare();
                        String subLocality = address.getSubLocality();
                        final JSONObject jSONObject = new JSONObject();
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append(location.getLongitude());
                            jSONObject.put("longitude", sb.toString());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(location.getLatitude());
                            jSONObject.put("latitude", sb2.toString());
                            jSONObject.put("adminArea", String.valueOf(adminArea));
                            jSONObject.put("countryCode", String.valueOf(countryCode));
                            jSONObject.put("locality", String.valueOf(locality));
                            jSONObject.put("thoroughfare", String.valueOf(thoroughfare));
                            jSONObject.put("subLocality", String.valueOf(subLocality));
                            XmPluginHostApi.this.reportGPSInfo(deviceByDid.model, str, location.getLongitude(), location.getLatitude(), adminArea, countryCode, locality, thoroughfare, subLocality, new Callback<Void>() {
                                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass22.AnonymousClass1 */

                                public void onSuccess(Void voidR) {
                                    callback.onSuccess(jSONObject);
                                }

                                public void onFailure(int i, String str) {
                                    callback.onFailure(i, str);
                                }
                            });
                        } catch (JSONException e) {
                            callback.onFailure(-1, e.toString());
                        }
                    }

                    public void onFailure(int i, String str) {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onFailure(i, str);
                        }
                    }
                });
            } else if (callback != null) {
                callback.onFailure(-1, "");
            }
        } else if (callback != null) {
            callback.onFailure(-1, "");
        }
    }

    public Intent getBroadCastIntent(DeviceStat deviceStat) {
        Intent intent = new Intent("com.xiaomi.smarthome.RECEIVE_MESSAGE");
        if (deviceStat != null) {
            intent.putExtra("device_id", deviceStat.did);
            intent.putExtra("device_mac", deviceStat.mac);
            intent.putExtra("user_model", deviceStat.model);
        }
        return intent;
    }

    public void getUserDeviceData(String str, String str2, String str3, String str4, long j, long j2, Callback<JSONArray> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            jSONObject.put("type", str3);
            jSONObject.put("key", str4);
            jSONObject.put("time_start", j);
            jSONObject.put("time_end", j2);
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
                return;
            }
        }
        callSmartHomeApi(str, "/user/get_user_device_data", jSONObject, callback, new Parser<JSONArray>() {
            /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass23 */

            public JSONArray parse(String str) throws JSONException {
                return new JSONObject(str).getJSONArray("result");
            }
        });
    }

    @Deprecated
    public void setUserConfig(String str, String str2, int i, Map<String, Object> map, Callback<Boolean> callback) {
        if (callback != null) {
            callback.onFailure(-1, "This API is forbidden, please use setUserConfigV2 instead");
        }
    }

    @Deprecated
    public void getUserConfig(String str, String str2, int[] iArr, Callback<Map<String, Object>> callback) {
        if (callback != null) {
            callback.onFailure(-1, "API forbidden, please use getUserConfigV2 instead!");
        }
    }

    public void getVirtualDevicesByDid(String str, String str2, Callback<List<DeviceStat>> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "get");
            jSONObject.put("masterDid", str2);
            callSmartHomeApi(str, "/home/virtualdevicectr", jSONObject, callback, new Parser<List<DeviceStat>>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass24 */

                public List<DeviceStat> parse(String str) throws JSONException {
                    JSONObject jSONObject = new JSONObject(str);
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = jSONObject.optJSONArray("members");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(XmPluginHostApi.this.getDeviceByDid(optJSONArray.optString(i)));
                        }
                    }
                    return arrayList;
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public void setUserConfigV2(XmPluginPackage xmPluginPackage, String str, int i, int i2, Map<String, Object> map, Callback<Boolean> callback) {
        if (i != 0 && i != 1) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("component_id", i);
                jSONObject.put("key", i2);
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry next : map.entrySet()) {
                    jSONObject2.put((String) next.getKey(), next.getValue());
                }
                jSONObject.put("data", jSONObject2);
                callSmartHomeApi(str, "/user/set_user_config", jSONObject, callback, new Parser<Boolean>() {
                    /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass25 */

                    public Boolean parse(String str) throws JSONException {
                        return Boolean.valueOf(new JSONObject(str).optInt("result") != 0);
                    }
                });
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                }
            }
        } else if (callback != null) {
            callback.onFailure(-1, "App id invalid, value 0 and 1 are reserved.");
        }
    }

    public void setUserConfigV3(XmPluginPackage xmPluginPackage, String str, int i, Map<String, Object> map, Callback<Boolean> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", i);
            jSONObject.put("model", str);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                jSONObject2.put((String) next.getKey(), next.getValue());
            }
            jSONObject.put("data", jSONObject2);
            callSmartHomeApi(str, "/user/set_third_user_config", jSONObject, callback, new Parser<Boolean>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass26 */

                public Boolean parse(String str) throws JSONException {
                    return Boolean.valueOf(new JSONObject(str).optInt("result") != 0);
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public void getUserConfigV2(XmPluginPackage xmPluginPackage, String str, int i, int[] iArr, Callback<Map<String, Object>> callback) {
        if (i != 0 && i != 1) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("component_id", i);
                JSONArray jSONArray = new JSONArray();
                for (int put : iArr) {
                    jSONArray.put(put);
                }
                jSONObject.put("keys", jSONArray);
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                    return;
                }
            }
            callSmartHomeApi(str, "/user/get_user_config", jSONObject, callback, new Parser<Map<String, Object>>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass27 */

                public Map<String, Object> parse(String str) throws JSONException {
                    JSONObject jSONObject = new JSONObject(str);
                    HashMap hashMap = new HashMap();
                    JSONObject optJSONObject = jSONObject.optJSONObject("result");
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, optJSONObject.get(next));
                        }
                    }
                    return hashMap;
                }
            });
        } else if (callback != null) {
            callback.onFailure(-1, "App id invalid, 0 and 1 are reserved.");
        }
    }

    public void getUserConfigV3(XmPluginPackage xmPluginPackage, String str, int i, int[] iArr, Callback<Map<String, Object>> callback) {
        if (i != 0 && i != 1) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("component_id", i);
                JSONArray jSONArray = new JSONArray();
                for (int put : iArr) {
                    jSONArray.put(put);
                }
                jSONObject.put("keys", jSONArray);
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                    return;
                }
            }
            callSmartHomeApi(str, "/user/get_user_config", jSONObject, callback, new Parser<Map<String, Object>>() {
                /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass28 */

                public Map<String, Object> parse(String str) throws JSONException {
                    JSONObject jSONObject = new JSONObject(str);
                    HashMap hashMap = new HashMap();
                    JSONArray optJSONArray = jSONObject.optJSONArray("result");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        hashMap.put((String) jSONObject2.get("key"), jSONObject2);
                    }
                    return hashMap;
                }
            });
        } else if (callback != null) {
            callback.onFailure(-1, "App id invalid, 0 and 1 are reserved.");
        }
    }

    public void getUserConfigV4(XmPluginPackage xmPluginPackage, String str, int[] iArr, Callback<Map<String, Object>> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (int put : iArr) {
                jSONArray.put(put);
            }
            jSONObject.put("keys", jSONArray);
            jSONObject.put("model", str);
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
                return;
            }
        }
        callSmartHomeApi(str, "/user/get_third_user_config", jSONObject, callback, new Parser<Map<String, Object>>() {
            /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass29 */

            public Map<String, Object> parse(String str) throws JSONException {
                JSONObject jSONObject = new JSONObject(str);
                HashMap hashMap = new HashMap();
                JSONArray optJSONArray = jSONObject.optJSONArray("result");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    Object obj = jSONObject2.get("key");
                    if (!obj.equals(JSONObject.NULL)) {
                        hashMap.put((String) obj, jSONObject2);
                    }
                }
                return hashMap;
            }
        });
    }

    public void batchGetDeviceProps(String str, JSONArray jSONArray, Callback<String> callback) {
        callSmartHomeApi(str, "/device/batchdevicedatas", jSONArray.toString(), callback, new Parser<String>() {
            /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass30 */

            public String parse(String str) throws JSONException {
                return str;
            }
        });
    }

    public void setDeviceProps(String str, JSONObject jSONObject, Callback<String> callback) {
        callSmartHomeApi(str, "/v2/device/set_props", jSONObject.toString(), callback, new Parser<String>() {
            /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass31 */

            public String parse(String str) throws JSONException {
                return str;
            }
        });
    }

    public void shareSecurityKey(String str, String str2, String str3, int i, long j, long j2, List<Integer> list, boolean z, Callback<Void> callback) {
        final Callback<Void> callback2 = callback;
        final String str4 = str2;
        final int i2 = i;
        final long j3 = j;
        final long j4 = j2;
        final List<Integer> list2 = list;
        final boolean z2 = z;
        final String str5 = str;
        AnonymousClass32 r0 = new Callback<String>() {
            /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass32 */

            public void onSuccess(String str) {
                if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("-1") || str.equalsIgnoreCase("0")) {
                    Callback callback = callback2;
                    if (callback != null) {
                        callback.onFailure(-9999, "shareUid is invalid");
                        return;
                    }
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "bleshare");
                    jSONObject.put("did", str4);
                    jSONObject.put("userid", str);
                    jSONObject.put("status", i2);
                    jSONObject.put("active_time", j3);
                    jSONObject.put("expire_time", j4);
                    if (list2 != null && list2.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < list2.size(); i++) {
                            if (i == 0) {
                                sb.append(list2.get(i));
                            } else {
                                sb.append(",");
                                sb.append(list2.get(i));
                            }
                        }
                        jSONObject.put("weekdays", sb.toString());
                    }
                    jSONObject.put("readonly", z2);
                    XmPluginHostApi.this.callSmartHomeApi(str5, "/share/bluetoothkeyshare", jSONObject, callback2, (Parser) null);
                } catch (JSONException e) {
                    Callback callback2 = callback2;
                    if (callback2 != null) {
                        callback2.onFailure(-1, e.toString());
                    }
                }
            }

            public void onFailure(int i, String str) {
                Callback callback = callback2;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        };
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", str3);
        } catch (JSONException unused) {
        }
        callSmartHomeApi(str, "/home/profile", jSONObject, r0, new Parser<String>() {
            /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass33 */

            public String parse(String str) throws JSONException {
                return new JSONObject(str).optString("userid");
            }
        });
    }

    public void updateSecurityKey(String str, String str2, String str3, int i, long j, long j2, List<Integer> list, Callback<Void> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "update");
            jSONObject.put("did", str2);
            jSONObject.put("keyid", str3);
            jSONObject.put("status", i);
            jSONObject.put("active_time", j);
            jSONObject.put("expire_time", j2);
            if (list != null && list.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (i2 == 0) {
                        sb.append(list.get(i2));
                    } else {
                        sb.append(",");
                        sb.append(list.get(i2));
                    }
                }
                jSONObject.put("weekdays", sb.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callSmartHomeApi(str, "/share/bluetoothkeyshare", jSONObject, callback, (Parser) null);
    }

    public void deleteSecurityKey(String str, String str2, String str3, Callback<Void> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "bledelete");
            jSONObject.put("did", str2);
            jSONObject.put("keyid", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callSmartHomeApi(str, "/share/bluetoothkeyshare", jSONObject, callback, (Parser) null);
    }

    public void getSecurityKey(String str, String str2, Callback<List<SecurityKeyInfo>> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "get");
            jSONObject.put("did", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callSmartHomeApi(str, "/share/bluetoothkeyshare", jSONObject, callback, new Parser<List<SecurityKeyInfo>>() {
            /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass34 */

            public List<SecurityKeyInfo> parse(String str) throws JSONException {
                String[] split;
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("bleshare");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                SecurityKeyInfo securityKeyInfo = new SecurityKeyInfo();
                                securityKeyInfo.keyId = optJSONObject.optString("keyid");
                                securityKeyInfo.shareUid = optJSONObject.optString("shareuid");
                                securityKeyInfo.status = optJSONObject.optInt("status");
                                securityKeyInfo.activeTime = optJSONObject.optLong("active_time");
                                securityKeyInfo.expireTime = optJSONObject.optLong("expire_time");
                                securityKeyInfo.isoutofdate = optJSONObject.optInt("isoutofdate");
                                String optString = optJSONObject.optString("weekdays");
                                if (!TextUtils.isEmpty(optString) && (split = optString.split(",")) != null && split.length > 0) {
                                    securityKeyInfo.weekdays = new ArrayList();
                                    for (String valueOf : split) {
                                        securityKeyInfo.weekdays.add(Integer.valueOf(valueOf));
                                    }
                                }
                                arrayList.add(securityKeyInfo);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return arrayList;
            }
        });
    }

    public void getUTCFromServer(String str, Callback<Long> callback) {
        callSmartHomeApi(str, "/device/get_utc_time", new JSONObject(), callback, new Parser<Long>() {
            /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass35 */

            public Long parse(String str) throws JSONException {
                return Long.valueOf(new JSONObject(str).optLong("result", -1));
            }
        });
    }

    public void getBleLockBindInfo(String str, String str2, Callback<String> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callSmartHomeApi(str, "/device/blelockbindinfo", jSONObject, callback, new Parser<String>() {
            /* class com.xiaomi.smarthome.device.api.XmPluginHostApi.AnonymousClass36 */

            public String parse(String str) throws JSONException {
                return new JSONObject(str).optString("bindtime");
            }
        });
    }
}

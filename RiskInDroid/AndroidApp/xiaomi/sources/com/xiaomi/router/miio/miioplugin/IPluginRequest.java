package com.xiaomi.router.miio.miioplugin;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import com.xiaomi.smarthome.ad.api.Advertisement;
import com.xiaomi.smarthome.ad.api.IAdCallback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.IBleCallback;
import com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback;
import com.xiaomi.smarthome.device.api.ISceneCallback;
import com.xiaomi.smarthome.device.api.ISceneInfoCallback;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.List;

public interface IPluginRequest extends IInterface {
    void addDeviceToMain(String str, String str2, IPluginCallback iPluginCallback) throws RemoteException;

    void addRecord(String str, String str2) throws RemoteException;

    void addRoom(RoomStatus roomStatus, IPluginCallbackRoomStatus iPluginCallbackRoomStatus) throws RemoteException;

    void addTag(String str, String str2) throws RemoteException;

    void addToLauncher(String str, Intent intent) throws RemoteException;

    void bleMeshConnect(String str, String str2, IBleCallback iBleCallback) throws RemoteException;

    void bleSpecOperation(String str, int i, String str2, IPluginCallback2 iPluginCallback2) throws RemoteException;

    void bleStandardAuthConnect(String str, IBleCallback iBleCallback) throws RemoteException;

    void callBleApi(String str, int i, Bundle bundle, IBleCallback iBleCallback) throws RemoteException;

    void callRemoteAsync(String[] strArr, int i, String str, IPluginCallback iPluginCallback, IPluginCallback iPluginCallback2) throws RemoteException;

    boolean checkIfSupportVoiceCtrl(String str) throws RemoteException;

    boolean checkIfVoiceCtrlAuthorizedExpired(String str) throws RemoteException;

    void checkLocalRouterInfo(String str, IPluginCallback iPluginCallback) throws RemoteException;

    boolean checkVoiceCtrlAuthorized(String str) throws RemoteException;

    void closeCameraFloatingWindow(String str) throws RemoteException;

    void connectBand(String str, IPluginCallback iPluginCallback) throws RemoteException;

    void deInitBandManager() throws RemoteException;

    void delDeviceBatch(List<String> list, IPluginCallback iPluginCallback) throws RemoteException;

    void deleteCard(String str, IPluginCallback iPluginCallback) throws RemoteException;

    void deleteRooms(List<String> list, IPluginCallback2 iPluginCallback2) throws RemoteException;

    void downloadRnExtModules() throws RemoteException;

    String getAccountId() throws RemoteException;

    void getAllCards(IPluginCallback iPluginCallback) throws RemoteException;

    int getApiLevel() throws RemoteException;

    List<DeviceStatus> getBleGatewayDeviceList() throws RemoteException;

    void getBleGatewaySubDevices(List<String> list, IPluginCallbackDeviceList iPluginCallbackDeviceList) throws RemoteException;

    List<DeviceStatus> getCurrentHomeDevicesWithModel(String str) throws RemoteException;

    List<DeviceStatus> getCurrentHomeDevicesWithPid(int i) throws RemoteException;

    void getDefaultCardAndActivateInfo(IPluginCallback iPluginCallback) throws RemoteException;

    DeviceStatus getDevice(String str) throws RemoteException;

    List<DeviceStatus> getDeviceList() throws RemoteException;

    List<DeviceStatus> getDeviceListV2(List<String> list) throws RemoteException;

    String getDevicePincode(String str) throws RemoteException;

    String getDevicePropByDid(String str) throws RemoteException;

    void getDeviceRealIconByModel(String str, IPluginCallback3 iPluginCallback3) throws RemoteException;

    void getDeviceStatus(String str, DeviceStatus deviceStatus) throws RemoteException;

    DeviceTagInfo getDeviceTagInfo(String str) throws RemoteException;

    List<DeviceStatus> getFilterBluetoothDeviceList(String str) throws RemoteException;

    boolean getFreqCameraRedDotVisible() throws RemoteException;

    Home getHomeByDid(String str) throws RemoteException;

    List<DeviceStat> getIrDevList() throws RemoteException;

    Location getLastLocation() throws RemoteException;

    String getLightDeviceGroupModel(String str) throws RemoteException;

    int getMainProcessId() throws RemoteException;

    String getMediaButtonModel() throws RemoteException;

    String getOauthServiceToken() throws RemoteException;

    String getOauthUserId() throws RemoteException;

    String getPluginProcessName(int i, String str) throws RemoteException;

    String getQrDebugModePackageName() throws RemoteException;

    List<String> getRecommendTags(String str) throws RemoteException;

    List<RoomStatus> getRoomAll() throws RemoteException;

    Room getRoomByDid(String str) throws RemoteException;

    String getRouterFileDownloadUrl(String str) throws RemoteException;

    List<SceneInfo> getSceneByDid(String str) throws RemoteException;

    String getSpecInstanceStr(String str) throws RemoteException;

    String getSpecProptyValueFromSpecCard(String str) throws RemoteException;

    List<DeviceStatus> getSubDeviceByParentDid(String str) throws RemoteException;

    int getUsePreviewConfig() throws RemoteException;

    void getUserInfo(String str, IPluginCallbackUserInfo iPluginCallbackUserInfo) throws RemoteException;

    String getVirtualGroupStatus(String str) throws RemoteException;

    void getWatchControllableDevices(String str, IPluginCallback iPluginCallback) throws RemoteException;

    void gotoPage(Uri uri) throws RemoteException;

    boolean hasSceneOnline(String str, String str2) throws RemoteException;

    void initBandManager(String str, String str2, IPluginCallback iPluginCallback) throws RemoteException;

    void invalideOauthServiceToken() throws RemoteException;

    void isBleGatewayExistInDeviceList(IBleCallback iBleCallback) throws RemoteException;

    boolean isGPSLocationEnable() throws RemoteException;

    boolean isLocalMiRouter() throws RemoteException;

    boolean isNetworkLocationEnabled() throws RemoteException;

    boolean isNotificationBarOpBtnEnabled(String str, String str2) throws RemoteException;

    boolean isRNPluginDarkMode() throws RemoteException;

    boolean isUsrExpPlanEnabled(String str) throws RemoteException;

    void issueDoorCard(IPluginCallback iPluginCallback) throws RemoteException;

    void loadBitmap(String str, IPluginCallback3 iPluginCallback3) throws RemoteException;

    void loadRecommendScenes(String str, IRecommendSceneItemCallback iRecommendSceneItemCallback) throws RemoteException;

    void loadUrl(String str, String str2) throws RemoteException;

    void loadUrlPro(String str, String str2, boolean z) throws RemoteException;

    void loadWebView(String str, String str2) throws RemoteException;

    void log(String str, String str2) throws RemoteException;

    void logByModel(String str, String str2) throws RemoteException;

    void modDeviceName(String str, String str2, IPluginCallback iPluginCallback) throws RemoteException;

    void notifyBluetoothBinded(String str, String str2) throws RemoteException;

    void onRNRuntimeReuseDisable(int i) throws RemoteException;

    void openCameraFloatingWindow(String str) throws RemoteException;

    void queryAd(String str, String str2, IAdCallback iAdCallback) throws RemoteException;

    void recordCalculateEvent(String str, String str2, long j) throws RemoteException;

    void recordCountEvent(String str, String str2) throws RemoteException;

    void recordNumericPropertyEvent(String str, String str2, long j) throws RemoteException;

    void recordStringPropertyEvent(String str, String str2, String str3) throws RemoteException;

    void refreshDeviceListUi() throws RemoteException;

    void refreshScene(String str, ISceneCallback iSceneCallback) throws RemoteException;

    void refreshServiceTokenBySystemAccountNew(String str, MiServiceTokenInfo miServiceTokenInfo, IPluginCallback2 iPluginCallback2) throws RemoteException;

    void registerMediaButtonReceiver(String str) throws RemoteException;

    void removeTag(String str) throws RemoteException;

    void renameBluetoothDevice(String str, String str2) throws RemoteException;

    void reportAdClick() throws RemoteException;

    void reportAdClose(Advertisement advertisement) throws RemoteException;

    void reportAdShow(Advertisement advertisement) throws RemoteException;

    void reportHotSpotShow() throws RemoteException;

    void requestLocation(ILocationCallback iLocationCallback) throws RemoteException;

    void requestPermission(String[] strArr, IPluginCallback iPluginCallback) throws RemoteException;

    void reverseGeo(double d, double d2, IPluginCallback2 iPluginCallback2) throws RemoteException;

    void revokePrivacyLicense(String str, IPluginCallback iPluginCallback) throws RemoteException;

    void roomRename(String str, String str2, IPluginCallback2 iPluginCallback2) throws RemoteException;

    void secureConnect(String str, IBleCallback iBleCallback) throws RemoteException;

    void securityChipConnect(String str, IBleCallback iBleCallback) throws RemoteException;

    void securityChipSharedDeviceConnect(String str, IBleCallback iBleCallback) throws RemoteException;

    void sendFeedbackLog(String str, String str2) throws RemoteException;

    void sendMessage(String str, int i, Intent intent, IPluginCallback2 iPluginCallback2) throws RemoteException;

    void sendPluginAdRequest(String str, String str2) throws RemoteException;

    void setBleDeviceSubtitle(String str, String str2) throws RemoteException;

    void setDefaultCard(String str, IPluginCallback iPluginCallback) throws RemoteException;

    void setFreqCameraRedDotVisible(boolean z) throws RemoteException;

    void setSubDeviceShownMode(String str, boolean z, IPluginCallback iPluginCallback) throws RemoteException;

    void setUsrExpPlanEnabled(String str, boolean z) throws RemoteException;

    void startSearchNewDevice(String str, IPluginCallback2 iPluginCallback2) throws RemoteException;

    void statReport(String str, String str2, String str3) throws RemoteException;

    void stopPluginAd(String str) throws RemoteException;

    void subscribeDevice(String str, int i, List<String> list, int i2, IPluginCallback iPluginCallback) throws RemoteException;

    void subscribeDeviceV2(String str, int i, List<String> list, int i2, IPluginCallback2 iPluginCallback2) throws RemoteException;

    void unBindDevice(String str, int i, IPluginCallback iPluginCallback) throws RemoteException;

    void unRegisterMediaButtonReceiver(String str) throws RemoteException;

    void unsubscribeDevice(String str, int i, List<String> list, IPluginCallback iPluginCallback) throws RemoteException;

    void unsubscribeDeviceV2(String str, int i, List<String> list, String str2, IPluginCallback2 iPluginCallback2) throws RemoteException;

    void updateCard(String str, IPluginCallback iPluginCallback) throws RemoteException;

    void updateDevice(List<String> list, IPluginCallbackDeviceList iPluginCallbackDeviceList) throws RemoteException;

    void updateDeviceList(IPluginCallback iPluginCallback) throws RemoteException;

    void updateDeviceProperties(String str, String str2) throws RemoteException;

    void updateDeviceStatus(DeviceStatus deviceStatus, IPluginCallback iPluginCallback) throws RemoteException;

    void updateScene(String str, IPluginCallback iPluginCallback) throws RemoteException;

    void updateSceneItem(SceneInfo sceneInfo, ISceneInfoCallback iSceneInfoCallback) throws RemoteException;

    void updateSubDevice(String[] strArr, IPluginCallbackDeviceList iPluginCallbackDeviceList) throws RemoteException;

    void visualSecureBind(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IPluginRequest {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.router.miio.miioplugin.IPluginRequest");
        }

        public static IPluginRequest asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.router.miio.miioplugin.IPluginRequest");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPluginRequest)) {
                return new Proxy(iBinder);
            }
            return (IPluginRequest) queryLocalInterface;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.xiaomi.router.miio.miioplugin.DeviceStatus] */
        /* JADX WARN: Type inference failed for: r4v4, types: [com.xiaomi.router.miio.miioplugin.RoomStatus] */
        /* JADX WARN: Type inference failed for: r4v13, types: [android.content.Intent] */
        /* JADX WARN: Type inference failed for: r4v16, types: [android.net.Uri] */
        /* JADX WARN: Type inference failed for: r4v19, types: [android.content.Intent] */
        /* JADX WARN: Type inference failed for: r4v24, types: [com.xiaomi.smarthome.device.api.SceneInfo] */
        /* JADX WARN: Type inference failed for: r4v27, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r4v31, types: [com.xiaomi.smarthome.ad.api.Advertisement] */
        /* JADX WARN: Type inference failed for: r4v34, types: [com.xiaomi.smarthome.ad.api.Advertisement] */
        /* JADX WARN: Type inference failed for: r4v38, types: [com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo] */
        /* JADX WARN: Type inference failed for: r4v41 */
        /* JADX WARN: Type inference failed for: r4v42 */
        /* JADX WARN: Type inference failed for: r4v43 */
        /* JADX WARN: Type inference failed for: r4v44 */
        /* JADX WARN: Type inference failed for: r4v45 */
        /* JADX WARN: Type inference failed for: r4v46 */
        /* JADX WARN: Type inference failed for: r4v47 */
        /* JADX WARN: Type inference failed for: r4v48 */
        /* JADX WARN: Type inference failed for: r4v49 */
        /* JADX WARN: Type inference failed for: r4v50 */
        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) throws android.os.RemoteException {
            /*
                r8 = this;
                r2 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r6 = 1
                java.lang.String r3 = "com.xiaomi.router.miio.miioplugin.IPluginRequest"
                if (r9 == r2) goto L_0x0ae9
                r2 = 0
                r4 = 0
                switch(r9) {
                    case 1: goto L_0x0adb;
                    case 2: goto L_0x0aba;
                    case 3: goto L_0x0aa1;
                    case 4: goto L_0x0a93;
                    case 5: goto L_0x0a81;
                    case 6: goto L_0x0a73;
                    case 7: goto L_0x0a5d;
                    case 8: goto L_0x0a43;
                    case 9: goto L_0x0a22;
                    case 10: goto L_0x0a07;
                    case 11: goto L_0x09ec;
                    case 12: goto L_0x09da;
                    case 13: goto L_0x09c8;
                    case 14: goto L_0x09b2;
                    case 15: goto L_0x098a;
                    case 16: goto L_0x096c;
                    case 17: goto L_0x0944;
                    case 18: goto L_0x091c;
                    case 19: goto L_0x090e;
                    case 20: goto L_0x08f7;
                    case 21: goto L_0x08e9;
                    case 22: goto L_0x08db;
                    case 23: goto L_0x08cd;
                    case 24: goto L_0x08bb;
                    case 25: goto L_0x08a9;
                    case 26: goto L_0x0893;
                    case 27: goto L_0x087d;
                    case 28: goto L_0x0867;
                    case 29: goto L_0x0855;
                    case 30: goto L_0x083b;
                    case 31: goto L_0x0821;
                    case 32: goto L_0x080f;
                    case 33: goto L_0x07fd;
                    case 34: goto L_0x07eb;
                    case 35: goto L_0x07ce;
                    case 36: goto L_0x07bc;
                    case 37: goto L_0x07a6;
                    case 38: goto L_0x0798;
                    case 39: goto L_0x077f;
                    case 40: goto L_0x0756;
                    case 41: goto L_0x0740;
                    case 42: goto L_0x072a;
                    case 43: goto L_0x06fe;
                    case 44: goto L_0x06e8;
                    case 45: goto L_0x06d6;
                    case 46: goto L_0x06c4;
                    case 47: goto L_0x06b2;
                    case 48: goto L_0x0699;
                    case 49: goto L_0x0683;
                    case 50: goto L_0x0662;
                    case 51: goto L_0x064c;
                    case 52: goto L_0x0636;
                    case 53: goto L_0x0619;
                    case 54: goto L_0x05fe;
                    case 55: goto L_0x05e3;
                    case 56: goto L_0x05d1;
                    case 57: goto L_0x05bf;
                    case 58: goto L_0x05b1;
                    case 59: goto L_0x059f;
                    case 60: goto L_0x0589;
                    case 61: goto L_0x057b;
                    case 62: goto L_0x0569;
                    case 63: goto L_0x0557;
                    case 64: goto L_0x0549;
                    case 65: goto L_0x053b;
                    case 66: goto L_0x052d;
                    case 67: goto L_0x051f;
                    case 68: goto L_0x0509;
                    case 69: goto L_0x04d5;
                    case 70: goto L_0x04bf;
                    case 71: goto L_0x04a9;
                    case 72: goto L_0x0497;
                    case 73: goto L_0x0485;
                    case 74: goto L_0x0473;
                    case 75: goto L_0x045d;
                    case 76: goto L_0x044b;
                    case 77: goto L_0x043d;
                    case 78: goto L_0x0423;
                    case 79: goto L_0x040a;
                    case 80: goto L_0x0400;
                    case 81: goto L_0x03e7;
                    case 82: goto L_0x03dd;
                    case 83: goto L_0x03c7;
                    case 84: goto L_0x03b1;
                    case 85: goto L_0x03a3;
                    case 86: goto L_0x0395;
                    case 87: goto L_0x0383;
                    case 88: goto L_0x036d;
                    case 89: goto L_0x035b;
                    case 90: goto L_0x0345;
                    case 91: goto L_0x032f;
                    case 92: goto L_0x031d;
                    case 93: goto L_0x02ff;
                    case 94: goto L_0x02ed;
                    case 95: goto L_0x02d7;
                    case 96: goto L_0x02bd;
                    case 97: goto L_0x02ab;
                    case 98: goto L_0x0296;
                    case 99: goto L_0x0284;
                    case 100: goto L_0x0276;
                    case 101: goto L_0x025c;
                    case 102: goto L_0x024a;
                    case 103: goto L_0x0238;
                    case 104: goto L_0x0226;
                    case 105: goto L_0x0210;
                    case 106: goto L_0x01f6;
                    case 107: goto L_0x01ec;
                    case 108: goto L_0x01d6;
                    case 109: goto L_0x01c4;
                    case 110: goto L_0x01b2;
                    case 111: goto L_0x019c;
                    case 112: goto L_0x0186;
                    case 113: goto L_0x0170;
                    case 114: goto L_0x015e;
                    case 115: goto L_0x0150;
                    case 116: goto L_0x013a;
                    case 117: goto L_0x0130;
                    case 118: goto L_0x0126;
                    case 119: goto L_0x0101;
                    case 120: goto L_0x00eb;
                    case 121: goto L_0x00cd;
                    case 122: goto L_0x00b7;
                    case 123: goto L_0x00a9;
                    case 124: goto L_0x0097;
                    case 125: goto L_0x0085;
                    case 126: goto L_0x0077;
                    case 127: goto L_0x0066;
                    case 128: goto L_0x0058;
                    case 129: goto L_0x004a;
                    case 130: goto L_0x003c;
                    case 131: goto L_0x002e;
                    case 132: goto L_0x0024;
                    case 133: goto L_0x0012;
                    default: goto L_0x000d;
                }
            L_0x000d:
                boolean r0 = super.onTransact(r9, r10, r11, r12)
                return r0
            L_0x0012:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.sendFeedbackLog(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0024:
                r10.enforceInterface(r3)
                r8.invalideOauthServiceToken()
                r11.writeNoException()
                return r6
            L_0x002e:
                r10.enforceInterface(r3)
                java.lang.String r0 = r8.getOauthServiceToken()
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x003c:
                r10.enforceInterface(r3)
                java.lang.String r0 = r8.getOauthUserId()
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x004a:
                r10.enforceInterface(r3)
                int r0 = r10.readInt()
                r8.onRNRuntimeReuseDisable(r0)
                r11.writeNoException()
                return r6
            L_0x0058:
                r10.enforceInterface(r3)
                boolean r0 = r8.isRNPluginDarkMode()
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x0066:
                r10.enforceInterface(r3)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0070
                r2 = 1
            L_0x0070:
                r8.setFreqCameraRedDotVisible(r2)
                r11.writeNoException()
                return r6
            L_0x0077:
                r10.enforceInterface(r3)
                boolean r0 = r8.getFreqCameraRedDotVisible()
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x0085:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.util.List r0 = r8.getCurrentHomeDevicesWithModel(r0)
                r11.writeNoException()
                r11.writeTypedList(r0)
                return r6
            L_0x0097:
                r10.enforceInterface(r3)
                int r0 = r10.readInt()
                java.util.List r0 = r8.getCurrentHomeDevicesWithPid(r0)
                r11.writeNoException()
                r11.writeTypedList(r0)
                return r6
            L_0x00a9:
                r10.enforceInterface(r3)
                java.lang.String r0 = r8.getQrDebugModePackageName()
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x00b7:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r2 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.statReport(r0, r2, r1)
                r11.writeNoException()
                return r6
            L_0x00cd:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                int r2 = r10.readInt()
                java.lang.String r3 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback2 r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback2.Stub.asInterface(r1)
                r8.bleSpecOperation(r0, r2, r3, r1)
                r11.writeNoException()
                return r6
            L_0x00eb:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.revokePrivacyLicense(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0101:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                int r2 = r10.readInt()
                if (r2 == 0) goto L_0x0117
                android.os.Parcelable$Creator<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo> r2 = com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r10)
                r4 = r2
                com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo r4 = (com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo) r4
            L_0x0117:
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback2 r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback2.Stub.asInterface(r1)
                r8.refreshServiceTokenBySystemAccountNew(r0, r4, r1)
                r11.writeNoException()
                return r6
            L_0x0126:
                r10.enforceInterface(r3)
                r8.refreshDeviceListUi()
                r11.writeNoException()
                return r6
            L_0x0130:
                r10.enforceInterface(r3)
                r8.downloadRnExtModules()
                r11.writeNoException()
                return r6
            L_0x013a:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.smarthome.device.api.IBleCallback r1 = com.xiaomi.smarthome.device.api.IBleCallback.Stub.asInterface(r1)
                r8.bleStandardAuthConnect(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0150:
                r10.enforceInterface(r3)
                int r0 = r8.getUsePreviewConfig()
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x015e:
                r10.enforceInterface(r3)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r0 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r0)
                r8.getDefaultCardAndActivateInfo(r0)
                r11.writeNoException()
                return r6
            L_0x0170:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.updateCard(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0186:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.setDefaultCard(r0, r1)
                r11.writeNoException()
                return r6
            L_0x019c:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.deleteCard(r0, r1)
                r11.writeNoException()
                return r6
            L_0x01b2:
                r10.enforceInterface(r3)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r0 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r0)
                r8.issueDoorCard(r0)
                r11.writeNoException()
                return r6
            L_0x01c4:
                r10.enforceInterface(r3)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r0 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r0)
                r8.getAllCards(r0)
                r11.writeNoException()
                return r6
            L_0x01d6:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.connectBand(r0, r1)
                r11.writeNoException()
                return r6
            L_0x01ec:
                r10.enforceInterface(r3)
                r8.deInitBandManager()
                r11.writeNoException()
                return r6
            L_0x01f6:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r2 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.initBandManager(r0, r2, r1)
                r11.writeNoException()
                return r6
            L_0x0210:
                r10.enforceInterface(r3)
                java.util.ArrayList r0 = r10.createStringArrayList()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallbackDeviceList r1 = com.xiaomi.router.miio.miioplugin.IPluginCallbackDeviceList.Stub.asInterface(r1)
                r8.getBleGatewaySubDevices(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0226:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r0 = r8.getSpecProptyValueFromSpecCard(r0)
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x0238:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r0 = r8.getSpecInstanceStr(r0)
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x024a:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r0 = r8.getVirtualGroupStatus(r0)
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x025c:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r2 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.smarthome.device.api.IBleCallback r1 = com.xiaomi.smarthome.device.api.IBleCallback.Stub.asInterface(r1)
                r8.bleMeshConnect(r0, r2, r1)
                r11.writeNoException()
                return r6
            L_0x0276:
                r10.enforceInterface(r3)
                java.util.List r0 = r8.getBleGatewayDeviceList()
                r11.writeNoException()
                r11.writeTypedList(r0)
                return r6
            L_0x0284:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.util.List r0 = r8.getFilterBluetoothDeviceList(r0)
                r11.writeNoException()
                r11.writeTypedList(r0)
                return r6
            L_0x0296:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x02a4
                r2 = 1
            L_0x02a4:
                r8.setUsrExpPlanEnabled(r0, r2)
                r11.writeNoException()
                return r6
            L_0x02ab:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                boolean r0 = r8.isUsrExpPlanEnabled(r0)
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x02bd:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r2 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.addDeviceToMain(r0, r2, r1)
                r11.writeNoException()
                return r6
            L_0x02d7:
                r10.enforceInterface(r3)
                java.lang.String[] r0 = r10.createStringArray()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.requestPermission(r0, r1)
                r11.writeNoException()
                return r6
            L_0x02ed:
                r10.enforceInterface(r3)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.smarthome.device.api.IBleCallback r0 = com.xiaomi.smarthome.device.api.IBleCallback.Stub.asInterface(r0)
                r8.isBleGatewayExistInDeviceList(r0)
                r11.writeNoException()
                return r6
            L_0x02ff:
                r10.enforceInterface(r3)
                double r2 = r10.readDouble()
                double r4 = r10.readDouble()
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback2 r7 = com.xiaomi.router.miio.miioplugin.IPluginCallback2.Stub.asInterface(r0)
                r0 = r8
                r1 = r2
                r3 = r4
                r5 = r7
                r0.reverseGeo(r1, r3, r5)
                r11.writeNoException()
                return r6
            L_0x031d:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.logByModel(r0, r1)
                r11.writeNoException()
                return r6
            L_0x032f:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.smarthome.device.api.IBleCallback r1 = com.xiaomi.smarthome.device.api.IBleCallback.Stub.asInterface(r1)
                r8.securityChipSharedDeviceConnect(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0345:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.smarthome.device.api.IBleCallback r1 = com.xiaomi.smarthome.device.api.IBleCallback.Stub.asInterface(r1)
                r8.securityChipConnect(r0, r1)
                r11.writeNoException()
                return r6
            L_0x035b:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                boolean r0 = r8.checkIfSupportVoiceCtrl(r0)
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x036d:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.getWatchControllableDevices(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0383:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r0 = r8.getDevicePropByDid(r0)
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x0395:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                r8.closeCameraFloatingWindow(r0)
                r11.writeNoException()
                return r6
            L_0x03a3:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                r8.openCameraFloatingWindow(r0)
                r11.writeNoException()
                return r6
            L_0x03b1:
                r10.enforceInterface(r3)
                java.util.ArrayList r0 = r10.createStringArrayList()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.delDeviceBatch(r0, r1)
                r11.writeNoException()
                return r6
            L_0x03c7:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback3 r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback3.Stub.asInterface(r1)
                r8.getDeviceRealIconByModel(r0, r1)
                r11.writeNoException()
                return r6
            L_0x03dd:
                r10.enforceInterface(r3)
                r8.reportHotSpotShow()
                r11.writeNoException()
                return r6
            L_0x03e7:
                r10.enforceInterface(r3)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x03f9
                android.os.Parcelable$Creator<com.xiaomi.smarthome.ad.api.Advertisement> r0 = com.xiaomi.smarthome.ad.api.Advertisement.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                r4 = r0
                com.xiaomi.smarthome.ad.api.Advertisement r4 = (com.xiaomi.smarthome.ad.api.Advertisement) r4
            L_0x03f9:
                r8.reportAdClose(r4)
                r11.writeNoException()
                return r6
            L_0x0400:
                r10.enforceInterface(r3)
                r8.reportAdClick()
                r11.writeNoException()
                return r6
            L_0x040a:
                r10.enforceInterface(r3)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x041c
                android.os.Parcelable$Creator<com.xiaomi.smarthome.ad.api.Advertisement> r0 = com.xiaomi.smarthome.ad.api.Advertisement.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                r4 = r0
                com.xiaomi.smarthome.ad.api.Advertisement r4 = (com.xiaomi.smarthome.ad.api.Advertisement) r4
            L_0x041c:
                r8.reportAdShow(r4)
                r11.writeNoException()
                return r6
            L_0x0423:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r2 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.smarthome.ad.api.IAdCallback r1 = com.xiaomi.smarthome.ad.api.IAdCallback.Stub.asInterface(r1)
                r8.queryAd(r0, r2, r1)
                r11.writeNoException()
                return r6
            L_0x043d:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                r8.stopPluginAd(r0)
                r11.writeNoException()
                return r6
            L_0x044b:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.sendPluginAdRequest(r0, r1)
                r11.writeNoException()
                return r6
            L_0x045d:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback3 r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback3.Stub.asInterface(r1)
                r8.loadBitmap(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0473:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                boolean r0 = r8.checkIfVoiceCtrlAuthorizedExpired(r0)
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x0485:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                boolean r0 = r8.checkVoiceCtrlAuthorized(r0)
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x0497:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r0 = r8.getDevicePincode(r0)
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x04a9:
                r10.enforceInterface(r3)
                int r0 = r10.readInt()
                java.lang.String r1 = r10.readString()
                java.lang.String r0 = r8.getPluginProcessName(r0, r1)
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x04bf:
                r10.enforceInterface(r3)
                java.util.ArrayList r0 = r10.createStringArrayList()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallbackDeviceList r1 = com.xiaomi.router.miio.miioplugin.IPluginCallbackDeviceList.Stub.asInterface(r1)
                r8.updateDevice(r0, r1)
                r11.writeNoException()
                return r6
            L_0x04d5:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                int r3 = r10.readInt()
                int r5 = r10.readInt()
                if (r5 == 0) goto L_0x04ee
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r10)
                android.os.Bundle r4 = (android.os.Bundle) r4
            L_0x04ee:
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.smarthome.device.api.IBleCallback r1 = com.xiaomi.smarthome.device.api.IBleCallback.Stub.asInterface(r1)
                r8.callBleApi(r0, r3, r4, r1)
                r11.writeNoException()
                if (r4 == 0) goto L_0x0505
                r11.writeInt(r6)
                r4.writeToParcel(r11, r6)
                goto L_0x0508
            L_0x0505:
                r11.writeInt(r2)
            L_0x0508:
                return r6
            L_0x0509:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.smarthome.device.api.IBleCallback r1 = com.xiaomi.smarthome.device.api.IBleCallback.Stub.asInterface(r1)
                r8.secureConnect(r0, r1)
                r11.writeNoException()
                return r6
            L_0x051f:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                r8.visualSecureBind(r0)
                r11.writeNoException()
                return r6
            L_0x052d:
                r10.enforceInterface(r3)
                java.lang.String r0 = r8.getMediaButtonModel()
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x053b:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                r8.unRegisterMediaButtonReceiver(r0)
                r11.writeNoException()
                return r6
            L_0x0549:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                r8.registerMediaButtonReceiver(r0)
                r11.writeNoException()
                return r6
            L_0x0557:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.setBleDeviceSubtitle(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0569:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.renameBluetoothDevice(r0, r1)
                r11.writeNoException()
                return r6
            L_0x057b:
                r10.enforceInterface(r3)
                int r0 = r8.getMainProcessId()
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x0589:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                boolean r0 = r8.isNotificationBarOpBtnEnabled(r0, r1)
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x059f:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.util.List r0 = r8.getRecommendTags(r0)
                r11.writeNoException()
                r11.writeStringList(r0)
                return r6
            L_0x05b1:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                r8.removeTag(r0)
                r11.writeNoException()
                return r6
            L_0x05bf:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.addTag(r0, r1)
                r11.writeNoException()
                return r6
            L_0x05d1:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r0 = r8.getLightDeviceGroupModel(r0)
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x05e3:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                com.xiaomi.router.miio.miioplugin.DeviceTagInfo r0 = r8.getDeviceTagInfo(r0)
                r11.writeNoException()
                if (r0 == 0) goto L_0x05fa
                r11.writeInt(r6)
                r0.writeToParcel(r11, r6)
                goto L_0x05fd
            L_0x05fa:
                r11.writeInt(r2)
            L_0x05fd:
                return r6
            L_0x05fe:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                com.xiaomi.router.miio.miioplugin.DeviceStatus r0 = r8.getDevice(r0)
                r11.writeNoException()
                if (r0 == 0) goto L_0x0615
                r11.writeInt(r6)
                r0.writeToParcel(r11, r6)
                goto L_0x0618
            L_0x0615:
                r11.writeInt(r2)
            L_0x0618:
                return r6
            L_0x0619:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                int r3 = r10.readInt()
                if (r3 == 0) goto L_0x0627
                r2 = 1
            L_0x0627:
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.setSubDeviceShownMode(r0, r2, r1)
                r11.writeNoException()
                return r6
            L_0x0636:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                boolean r0 = r8.hasSceneOnline(r0, r1)
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x064c:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.updateScene(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0662:
                r10.enforceInterface(r3)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0674
                android.os.Parcelable$Creator<com.xiaomi.smarthome.device.api.SceneInfo> r0 = com.xiaomi.smarthome.device.api.SceneInfo.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                r4 = r0
                com.xiaomi.smarthome.device.api.SceneInfo r4 = (com.xiaomi.smarthome.device.api.SceneInfo) r4
            L_0x0674:
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.smarthome.device.api.ISceneInfoCallback r0 = com.xiaomi.smarthome.device.api.ISceneInfoCallback.Stub.asInterface(r0)
                r8.updateSceneItem(r4, r0)
                r11.writeNoException()
                return r6
            L_0x0683:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback r1 = com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback.Stub.asInterface(r1)
                r8.loadRecommendScenes(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0699:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r3 = r10.readString()
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x06ab
                r2 = 1
            L_0x06ab:
                r8.loadUrlPro(r0, r3, r2)
                r11.writeNoException()
                return r6
            L_0x06b2:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.loadUrl(r0, r1)
                r11.writeNoException()
                return r6
            L_0x06c4:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.loadWebView(r0, r1)
                r11.writeNoException()
                return r6
            L_0x06d6:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.notifyBluetoothBinded(r0, r1)
                r11.writeNoException()
                return r6
            L_0x06e8:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback2 r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback2.Stub.asInterface(r1)
                r8.startSearchNewDevice(r0, r1)
                r11.writeNoException()
                return r6
            L_0x06fe:
                r10.enforceInterface(r3)
                java.lang.String[] r2 = r10.createStringArray()
                int r3 = r10.readInt()
                java.lang.String r4 = r10.readString()
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r5 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r7 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r0)
                r0 = r8
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r7
                r0.callRemoteAsync(r1, r2, r3, r4, r5)
                r11.writeNoException()
                return r6
            L_0x072a:
                r10.enforceInterface(r3)
                java.lang.String[] r0 = r10.createStringArray()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallbackDeviceList r1 = com.xiaomi.router.miio.miioplugin.IPluginCallbackDeviceList.Stub.asInterface(r1)
                r8.updateSubDevice(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0740:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallbackUserInfo r1 = com.xiaomi.router.miio.miioplugin.IPluginCallbackUserInfo.Stub.asInterface(r1)
                r8.getUserInfo(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0756:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                int r2 = r10.readInt()
                int r3 = r10.readInt()
                if (r3 == 0) goto L_0x0770
                android.os.Parcelable$Creator r3 = android.content.Intent.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r10)
                r4 = r3
                android.content.Intent r4 = (android.content.Intent) r4
            L_0x0770:
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback2 r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback2.Stub.asInterface(r1)
                r8.sendMessage(r0, r2, r4, r1)
                r11.writeNoException()
                return r6
            L_0x077f:
                r10.enforceInterface(r3)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0791
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                r4 = r0
                android.net.Uri r4 = (android.net.Uri) r4
            L_0x0791:
                r8.gotoPage(r4)
                r11.writeNoException()
                return r6
            L_0x0798:
                r10.enforceInterface(r3)
                boolean r0 = r8.isLocalMiRouter()
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x07a6:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.checkLocalRouterInfo(r0, r1)
                r11.writeNoException()
                return r6
            L_0x07bc:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r0 = r8.getRouterFileDownloadUrl(r0)
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x07ce:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                int r2 = r10.readInt()
                if (r2 == 0) goto L_0x07e4
                android.os.Parcelable$Creator r2 = android.content.Intent.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r10)
                r4 = r1
                android.content.Intent r4 = (android.content.Intent) r4
            L_0x07e4:
                r8.addToLauncher(r0, r4)
                r11.writeNoException()
                return r6
            L_0x07eb:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.log(r0, r1)
                r11.writeNoException()
                return r6
            L_0x07fd:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.updateDeviceProperties(r0, r1)
                r11.writeNoException()
                return r6
            L_0x080f:
                r10.enforceInterface(r3)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r0 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r0)
                r8.updateDeviceList(r0)
                r11.writeNoException()
                return r6
            L_0x0821:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                int r2 = r10.readInt()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.unBindDevice(r0, r2, r1)
                r11.writeNoException()
                return r6
            L_0x083b:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r2 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.modDeviceName(r0, r2, r1)
                r11.writeNoException()
                return r6
            L_0x0855:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.addRecord(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0867:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r2 = r10.readString()
                long r3 = r10.readLong()
                r8.recordNumericPropertyEvent(r0, r2, r3)
                r11.writeNoException()
                return r6
            L_0x087d:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r2 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.recordStringPropertyEvent(r0, r2, r1)
                r11.writeNoException()
                return r6
            L_0x0893:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r2 = r10.readString()
                long r3 = r10.readLong()
                r8.recordCalculateEvent(r0, r2, r3)
                r11.writeNoException()
                return r6
            L_0x08a9:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.recordCountEvent(r0, r1)
                r11.writeNoException()
                return r6
            L_0x08bb:
                r10.enforceInterface(r3)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.ILocationCallback r0 = com.xiaomi.router.miio.miioplugin.ILocationCallback.Stub.asInterface(r0)
                r8.requestLocation(r0)
                r11.writeNoException()
                return r6
            L_0x08cd:
                r10.enforceInterface(r3)
                java.util.List r0 = r8.getIrDevList()
                r11.writeNoException()
                r11.writeTypedList(r0)
                return r6
            L_0x08db:
                r10.enforceInterface(r3)
                boolean r0 = r8.isGPSLocationEnable()
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x08e9:
                r10.enforceInterface(r3)
                boolean r0 = r8.isNetworkLocationEnabled()
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x08f7:
                r10.enforceInterface(r3)
                android.location.Location r0 = r8.getLastLocation()
                r11.writeNoException()
                if (r0 == 0) goto L_0x090a
                r11.writeInt(r6)
                r0.writeToParcel(r11, r6)
                goto L_0x090d
            L_0x090a:
                r11.writeInt(r2)
            L_0x090d:
                return r6
            L_0x090e:
                r10.enforceInterface(r3)
                java.lang.String r0 = r8.getAccountId()
                r11.writeNoException()
                r11.writeString(r0)
                return r6
            L_0x091c:
                r10.enforceInterface(r3)
                java.lang.String r2 = r10.readString()
                int r3 = r10.readInt()
                java.util.ArrayList r4 = r10.createStringArrayList()
                java.lang.String r5 = r10.readString()
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback2 r7 = com.xiaomi.router.miio.miioplugin.IPluginCallback2.Stub.asInterface(r0)
                r0 = r8
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r7
                r0.unsubscribeDeviceV2(r1, r2, r3, r4, r5)
                r11.writeNoException()
                return r6
            L_0x0944:
                r10.enforceInterface(r3)
                java.lang.String r2 = r10.readString()
                int r3 = r10.readInt()
                java.util.ArrayList r4 = r10.createStringArrayList()
                int r5 = r10.readInt()
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback2 r7 = com.xiaomi.router.miio.miioplugin.IPluginCallback2.Stub.asInterface(r0)
                r0 = r8
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r7
                r0.subscribeDeviceV2(r1, r2, r3, r4, r5)
                r11.writeNoException()
                return r6
            L_0x096c:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                int r2 = r10.readInt()
                java.util.ArrayList r3 = r10.createStringArrayList()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r1)
                r8.unsubscribeDevice(r0, r2, r3, r1)
                r11.writeNoException()
                return r6
            L_0x098a:
                r10.enforceInterface(r3)
                java.lang.String r2 = r10.readString()
                int r3 = r10.readInt()
                java.util.ArrayList r4 = r10.createStringArrayList()
                int r5 = r10.readInt()
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r7 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r0)
                r0 = r8
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r7
                r0.subscribeDevice(r1, r2, r3, r4, r5)
                r11.writeNoException()
                return r6
            L_0x09b2:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.smarthome.device.api.ISceneCallback r1 = com.xiaomi.smarthome.device.api.ISceneCallback.Stub.asInterface(r1)
                r8.refreshScene(r0, r1)
                r11.writeNoException()
                return r6
            L_0x09c8:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.util.List r0 = r8.getSceneByDid(r0)
                r11.writeNoException()
                r11.writeTypedList(r0)
                return r6
            L_0x09da:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.util.List r0 = r8.getSubDeviceByParentDid(r0)
                r11.writeNoException()
                r11.writeTypedList(r0)
                return r6
            L_0x09ec:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                com.xiaomi.smarthome.homeroom.model.Room r0 = r8.getRoomByDid(r0)
                r11.writeNoException()
                if (r0 == 0) goto L_0x0a03
                r11.writeInt(r6)
                r0.writeToParcel(r11, r6)
                goto L_0x0a06
            L_0x0a03:
                r11.writeInt(r2)
            L_0x0a06:
                return r6
            L_0x0a07:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                com.xiaomi.smarthome.homeroom.model.Home r0 = r8.getHomeByDid(r0)
                r11.writeNoException()
                if (r0 == 0) goto L_0x0a1e
                r11.writeInt(r6)
                r0.writeToParcel(r11, r6)
                goto L_0x0a21
            L_0x0a1e:
                r11.writeInt(r2)
            L_0x0a21:
                return r6
            L_0x0a22:
                r10.enforceInterface(r3)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0a34
                android.os.Parcelable$Creator<com.xiaomi.router.miio.miioplugin.RoomStatus> r0 = com.xiaomi.router.miio.miioplugin.RoomStatus.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                r4 = r0
                com.xiaomi.router.miio.miioplugin.RoomStatus r4 = (com.xiaomi.router.miio.miioplugin.RoomStatus) r4
            L_0x0a34:
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallbackRoomStatus r0 = com.xiaomi.router.miio.miioplugin.IPluginCallbackRoomStatus.Stub.asInterface(r0)
                r8.addRoom(r4, r0)
                r11.writeNoException()
                return r6
            L_0x0a43:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                java.lang.String r2 = r10.readString()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback2 r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback2.Stub.asInterface(r1)
                r8.roomRename(r0, r2, r1)
                r11.writeNoException()
                return r6
            L_0x0a5d:
                r10.enforceInterface(r3)
                java.util.ArrayList r0 = r10.createStringArrayList()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback2 r1 = com.xiaomi.router.miio.miioplugin.IPluginCallback2.Stub.asInterface(r1)
                r8.deleteRooms(r0, r1)
                r11.writeNoException()
                return r6
            L_0x0a73:
                r10.enforceInterface(r3)
                java.util.List r0 = r8.getRoomAll()
                r11.writeNoException()
                r11.writeTypedList(r0)
                return r6
            L_0x0a81:
                r10.enforceInterface(r3)
                java.util.ArrayList r0 = r10.createStringArrayList()
                java.util.List r0 = r8.getDeviceListV2(r0)
                r11.writeNoException()
                r11.writeTypedList(r0)
                return r6
            L_0x0a93:
                r10.enforceInterface(r3)
                java.util.List r0 = r8.getDeviceList()
                r11.writeNoException()
                r11.writeTypedList(r0)
                return r6
            L_0x0aa1:
                r10.enforceInterface(r3)
                java.lang.String r0 = r10.readString()
                com.xiaomi.router.miio.miioplugin.DeviceStatus r1 = new com.xiaomi.router.miio.miioplugin.DeviceStatus
                r1.<init>()
                r8.getDeviceStatus(r0, r1)
                r11.writeNoException()
                r11.writeInt(r6)
                r1.writeToParcel(r11, r6)
                return r6
            L_0x0aba:
                r10.enforceInterface(r3)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0acc
                android.os.Parcelable$Creator<com.xiaomi.router.miio.miioplugin.DeviceStatus> r0 = com.xiaomi.router.miio.miioplugin.DeviceStatus.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                r4 = r0
                com.xiaomi.router.miio.miioplugin.DeviceStatus r4 = (com.xiaomi.router.miio.miioplugin.DeviceStatus) r4
            L_0x0acc:
                android.os.IBinder r0 = r10.readStrongBinder()
                com.xiaomi.router.miio.miioplugin.IPluginCallback r0 = com.xiaomi.router.miio.miioplugin.IPluginCallback.Stub.asInterface(r0)
                r8.updateDeviceStatus(r4, r0)
                r11.writeNoException()
                return r6
            L_0x0adb:
                r10.enforceInterface(r3)
                int r0 = r8.getApiLevel()
                r11.writeNoException()
                r11.writeInt(r0)
                return r6
            L_0x0ae9:
                r11.writeString(r3)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.router.miio.miioplugin.IPluginRequest.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        static class Proxy implements IPluginRequest {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.router.miio.miioplugin.IPluginRequest";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int getApiLevel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateDeviceStatus(DeviceStatus deviceStatus, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    if (deviceStatus != null) {
                        obtain.writeInt(1);
                        deviceStatus.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getDeviceStatus(String str, DeviceStatus deviceStatus) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        deviceStatus.O000000o(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<DeviceStatus> getDeviceList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DeviceStatus.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<DeviceStatus> getDeviceListV2(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStringList(list);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DeviceStatus.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<RoomStatus> getRoomAll() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(RoomStatus.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void deleteRooms(List<String> list, IPluginCallback2 iPluginCallback2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStringList(list);
                    obtain.writeStrongBinder(iPluginCallback2 != null ? iPluginCallback2.asBinder() : null);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void roomRename(String str, String str2, IPluginCallback2 iPluginCallback2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iPluginCallback2 != null ? iPluginCallback2.asBinder() : null);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addRoom(RoomStatus roomStatus, IPluginCallbackRoomStatus iPluginCallbackRoomStatus) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    if (roomStatus != null) {
                        obtain.writeInt(1);
                        roomStatus.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iPluginCallbackRoomStatus != null ? iPluginCallbackRoomStatus.asBinder() : null);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Home getHomeByDid(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Home.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Room getRoomByDid(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Room.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<DeviceStatus> getSubDeviceByParentDid(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DeviceStatus.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<SceneInfo> getSceneByDid(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(SceneInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void refreshScene(String str, ISceneCallback iSceneCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iSceneCallback != null ? iSceneCallback.asBinder() : null);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void subscribeDevice(String str, int i, List<String> list, int i2, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStringList(list);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unsubscribeDevice(String str, int i, List<String> list, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStringList(list);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void subscribeDeviceV2(String str, int i, List<String> list, int i2, IPluginCallback2 iPluginCallback2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStringList(list);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iPluginCallback2 != null ? iPluginCallback2.asBinder() : null);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unsubscribeDeviceV2(String str, int i, List<String> list, String str2, IPluginCallback2 iPluginCallback2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStringList(list);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iPluginCallback2 != null ? iPluginCallback2.asBinder() : null);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccountId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location getLastLocation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isNetworkLocationEnabled() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    boolean z = false;
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isGPSLocationEnable() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    boolean z = false;
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<DeviceStat> getIrDevList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DeviceStat.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestLocation(ILocationCallback iLocationCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStrongBinder(iLocationCallback != null ? iLocationCallback.asBinder() : null);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void recordCountEvent(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void recordCalculateEvent(String str, String str2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void recordStringPropertyEvent(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void recordNumericPropertyEvent(String str, String str2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addRecord(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void modDeviceName(String str, String str2, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unBindDevice(String str, int i, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateDeviceList(IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateDeviceProperties(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void log(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addToLauncher(String str, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getRouterFileDownloadUrl(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void checkLocalRouterInfo(String str, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLocalMiRouter() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    boolean z = false;
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void gotoPage(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void sendMessage(String str, int i, Intent intent, IPluginCallback2 iPluginCallback2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iPluginCallback2 != null ? iPluginCallback2.asBinder() : null);
                    this.mRemote.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getUserInfo(String str, IPluginCallbackUserInfo iPluginCallbackUserInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPluginCallbackUserInfo != null ? iPluginCallbackUserInfo.asBinder() : null);
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateSubDevice(String[] strArr, IPluginCallbackDeviceList iPluginCallbackDeviceList) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(iPluginCallbackDeviceList != null ? iPluginCallbackDeviceList.asBinder() : null);
                    this.mRemote.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void callRemoteAsync(String[] strArr, int i, String str, IPluginCallback iPluginCallback, IPluginCallback iPluginCallback2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    if (iPluginCallback2 != null) {
                        iBinder = iPluginCallback2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startSearchNewDevice(String str, IPluginCallback2 iPluginCallback2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPluginCallback2 != null ? iPluginCallback2.asBinder() : null);
                    this.mRemote.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void notifyBluetoothBinded(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void loadWebView(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void loadUrl(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void loadUrlPro(String str, String str2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void loadRecommendScenes(String str, IRecommendSceneItemCallback iRecommendSceneItemCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iRecommendSceneItemCallback != null ? iRecommendSceneItemCallback.asBinder() : null);
                    this.mRemote.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateSceneItem(SceneInfo sceneInfo, ISceneInfoCallback iSceneInfoCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    if (sceneInfo != null) {
                        obtain.writeInt(1);
                        sceneInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iSceneInfoCallback != null ? iSceneInfoCallback.asBinder() : null);
                    this.mRemote.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateScene(String str, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasSceneOnline(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.mRemote.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setSubDeviceShownMode(String str, boolean z, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DeviceStatus getDevice(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DeviceStatus.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DeviceTagInfo getDeviceTagInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DeviceTagInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getLightDeviceGroupModel(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addTag(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeTag(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<String> getRecommendTags(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isNotificationBarOpBtnEnabled(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.mRemote.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getMainProcessId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void renameBluetoothDevice(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(62, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setBleDeviceSubtitle(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerMediaButtonReceiver(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unRegisterMediaButtonReceiver(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getMediaButtonModel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void visualSecureBind(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(67, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void secureConnect(String str, IBleCallback iBleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBleCallback != null ? iBleCallback.asBinder() : null);
                    this.mRemote.transact(68, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void callBleApi(String str, int i, Bundle bundle, IBleCallback iBleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBleCallback != null ? iBleCallback.asBinder() : null);
                    this.mRemote.transact(69, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateDevice(List<String> list, IPluginCallbackDeviceList iPluginCallbackDeviceList) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStringList(list);
                    obtain.writeStrongBinder(iPluginCallbackDeviceList != null ? iPluginCallbackDeviceList.asBinder() : null);
                    this.mRemote.transact(70, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getPluginProcessName(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(71, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getDevicePincode(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(72, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean checkVoiceCtrlAuthorized(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(73, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean checkIfVoiceCtrlAuthorizedExpired(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(74, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void loadBitmap(String str, IPluginCallback3 iPluginCallback3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPluginCallback3 != null ? iPluginCallback3.asBinder() : null);
                    this.mRemote.transact(75, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void sendPluginAdRequest(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(76, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopPluginAd(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(77, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void queryAd(String str, String str2, IAdCallback iAdCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iAdCallback != null ? iAdCallback.asBinder() : null);
                    this.mRemote.transact(78, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void reportAdShow(Advertisement advertisement) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    if (advertisement != null) {
                        obtain.writeInt(1);
                        advertisement.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(79, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void reportAdClick() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(80, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void reportAdClose(Advertisement advertisement) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    if (advertisement != null) {
                        obtain.writeInt(1);
                        advertisement.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(81, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void reportHotSpotShow() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(82, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getDeviceRealIconByModel(String str, IPluginCallback3 iPluginCallback3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPluginCallback3 != null ? iPluginCallback3.asBinder() : null);
                    this.mRemote.transact(83, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void delDeviceBatch(List<String> list, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStringList(list);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(84, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void openCameraFloatingWindow(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(85, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void closeCameraFloatingWindow(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(86, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getDevicePropByDid(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(87, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getWatchControllableDevices(String str, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(88, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean checkIfSupportVoiceCtrl(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(89, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void securityChipConnect(String str, IBleCallback iBleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBleCallback != null ? iBleCallback.asBinder() : null);
                    this.mRemote.transact(90, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void securityChipSharedDeviceConnect(String str, IBleCallback iBleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBleCallback != null ? iBleCallback.asBinder() : null);
                    this.mRemote.transact(91, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void logByModel(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(92, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void reverseGeo(double d, double d2, IPluginCallback2 iPluginCallback2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeStrongBinder(iPluginCallback2 != null ? iPluginCallback2.asBinder() : null);
                    this.mRemote.transact(93, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void isBleGatewayExistInDeviceList(IBleCallback iBleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStrongBinder(iBleCallback != null ? iBleCallback.asBinder() : null);
                    this.mRemote.transact(94, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestPermission(String[] strArr, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(95, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addDeviceToMain(String str, String str2, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(96, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isUsrExpPlanEnabled(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(97, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setUsrExpPlanEnabled(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(98, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<DeviceStatus> getFilterBluetoothDeviceList(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(99, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DeviceStatus.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<DeviceStatus> getBleGatewayDeviceList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(100, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DeviceStatus.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void bleMeshConnect(String str, String str2, IBleCallback iBleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iBleCallback != null ? iBleCallback.asBinder() : null);
                    this.mRemote.transact(101, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getVirtualGroupStatus(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(102, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getSpecInstanceStr(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(103, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getSpecProptyValueFromSpecCard(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(104, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getBleGatewaySubDevices(List<String> list, IPluginCallbackDeviceList iPluginCallbackDeviceList) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStringList(list);
                    obtain.writeStrongBinder(iPluginCallbackDeviceList != null ? iPluginCallbackDeviceList.asBinder() : null);
                    this.mRemote.transact(105, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void initBandManager(String str, String str2, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(106, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void deInitBandManager() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(107, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void connectBand(String str, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(108, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAllCards(IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(109, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void issueDoorCard(IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(110, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void deleteCard(String str, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(111, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setDefaultCard(String str, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(112, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateCard(String str, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(113, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getDefaultCardAndActivateInfo(IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(114, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getUsePreviewConfig() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(115, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void bleStandardAuthConnect(String str, IBleCallback iBleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBleCallback != null ? iBleCallback.asBinder() : null);
                    this.mRemote.transact(116, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void downloadRnExtModules() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(117, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void refreshDeviceListUi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(118, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void refreshServiceTokenBySystemAccountNew(String str, MiServiceTokenInfo miServiceTokenInfo, IPluginCallback2 iPluginCallback2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    if (miServiceTokenInfo != null) {
                        obtain.writeInt(1);
                        miServiceTokenInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iPluginCallback2 != null ? iPluginCallback2.asBinder() : null);
                    this.mRemote.transact(119, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void revokePrivacyLicense(String str, IPluginCallback iPluginCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPluginCallback != null ? iPluginCallback.asBinder() : null);
                    this.mRemote.transact(120, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void bleSpecOperation(String str, int i, String str2, IPluginCallback2 iPluginCallback2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iPluginCallback2 != null ? iPluginCallback2.asBinder() : null);
                    this.mRemote.transact(121, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void statReport(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(122, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getQrDebugModePackageName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(123, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<DeviceStatus> getCurrentHomeDevicesWithPid(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeInt(i);
                    this.mRemote.transact(124, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DeviceStatus.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<DeviceStatus> getCurrentHomeDevicesWithModel(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    this.mRemote.transact(125, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DeviceStatus.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getFreqCameraRedDotVisible() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    boolean z = false;
                    this.mRemote.transact(126, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setFreqCameraRedDotVisible(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(127, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isRNPluginDarkMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    boolean z = false;
                    this.mRemote.transact(NotificationCompat.FLAG_HIGH_PRIORITY, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRNRuntimeReuseDisable(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeInt(i);
                    this.mRemote.transact(129, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getOauthUserId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(130, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getOauthServiceToken() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(131, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void invalideOauthServiceToken() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    this.mRemote.transact(132, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void sendFeedbackLog(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(133, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

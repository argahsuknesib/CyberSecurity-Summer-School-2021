package com.xiaomi.smarthome.core.server;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.client.IClientApi;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.entity.account.AccountType;
import com.xiaomi.smarthome.core.entity.account.OAuthAccount;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.entity.device.ScanType;
import com.xiaomi.smarthome.core.entity.globaldynamicsetting.CTAInfo;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.core.server.IServerHandle;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.bluetooth.IBleMeshUpgradeResponse;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest;
import com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse;
import com.xiaomi.smarthome.core.server.bluetooth.SearchResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam;
import com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.List;
import java.util.Map;

public interface ICoreApi extends IInterface {
    void addClassicBtResponse(IClassicBtResponse iClassicBtResponse) throws RemoteException;

    void addContextByActionCode(int i, String str, String str2) throws RemoteException;

    void addContextToActionById(int i, String str, String str2) throws RemoteException;

    void addContextToCurrentAction(String str, String str2) throws RemoteException;

    void addProcessContext(String str, String str2) throws RemoteException;

    void addStatRecord(StatType statType, String str, String str2, String str3, String str4, boolean z) throws RemoteException;

    void appendContextToCurrentAction(String str, String str2) throws RemoteException;

    void applicationEnterBackground() throws RemoteException;

    void applicationEnterForground() throws RemoteException;

    IServerHandle batchRpcAsync(List<BatchRpcParam> list, IClientCallback iClientCallback) throws RemoteException;

    void beginProcess(String str, int i) throws RemoteException;

    ISecureConnectHandler bleComboStandardAuth(String str, BleComboWifiConfig bleComboWifiConfig, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException;

    ISecureConnectHandler bleMeshBind(String str, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException;

    ISecureConnectHandler bleMeshConnect(String str, String str2, String str3, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException;

    ISecureConnectHandler bleStandardAuthBind(String str, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException;

    ISecureConnectHandler bleStandardAuthConnect(String str, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException;

    void callBluetoothApi(String str, int i, Bundle bundle, IBleResponse iBleResponse) throws RemoteException;

    void cancelBleMeshUpgrade(String str) throws RemoteException;

    void cancelPluginDownload(String str, PluginDownloadTask pluginDownloadTask, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle clearAccount(IClientCallback iClientCallback) throws RemoteException;

    void clearAllMiServiceTokenInSystem() throws RemoteException;

    void clearMiServiceTokenInSystem(String str) throws RemoteException;

    void clearPluginConfig(IClientCallback iClientCallback) throws RemoteException;

    void clearWhiteList() throws RemoteException;

    IServerHandle debugPluginPackage(IClientCallback iClientCallback) throws RemoteException;

    IServerHandle delDeviceBatch(List<String> list, IClientCallback iClientCallback) throws RemoteException;

    void deletePlugin(String str, IClientCallback iClientCallback) throws RemoteException;

    void downloadCloudVideoIntoCloudSetting(String str, String str2, boolean z, long j, long j2) throws RemoteException;

    void downloadPlugin(List<String> list, boolean z, IClientCallback iClientCallback) throws RemoteException;

    void dumpPlugin(IClientCallback iClientCallback) throws RemoteException;

    void finishCurrentAction(int i) throws RemoteException;

    void finishCurrentActionWithContext(int i, Map map) throws RemoteException;

    String finishProcess(int i) throws RemoteException;

    void flushLog() throws RemoteException;

    void forceUpdateScene() throws RemoteException;

    void gc() throws RemoteException;

    int get13OptimizeBleLoginConnectRetryDelay(String str) throws RemoteException;

    int get6OptimizeBleLoginConnectRetryDelay(String str) throws RemoteException;

    AccountType getAccountType() throws RemoteException;

    void getBluetoothCache(String str, int i, Bundle bundle) throws RemoteException;

    String getBluetoothGatewayDevices() throws RemoteException;

    IClassicBtRequest getClassicBtRequestImpl() throws RemoteException;

    PluginPackageInfo getDownloadPackageInfo(String str) throws RemoteException;

    PluginDeviceInfo getExtraPluginInfo(String str) throws RemoteException;

    CTAInfo getGlobalSettingCTA() throws RemoteException;

    Bundle getGlobalSettingLocale() throws RemoteException;

    ServerBean getGlobalSettingServer() throws RemoteException;

    String getGlobalSettingServerEnv() throws RemoteException;

    String getHomeId() throws RemoteException;

    PluginPackageInfo getInstallPackageInfo(String str) throws RemoteException;

    void getLatestPluginInfo(String str, IClientCallback iClientCallback) throws RemoteException;

    LoginMiAccount getMiAccount() throws RemoteException;

    String getMiId() throws RemoteException;

    String getModelByProductId(int i) throws RemoteException;

    String getModelBySSID(String str) throws RemoteException;

    OAuthAccount getOAuthAccount() throws RemoteException;

    int getOptimizeBleLoginConnectRetryTimes() throws RemoteException;

    PluginDeviceInfo getPluginInfo(String str) throws RemoteException;

    PluginPackageInfo getPluginInstalledPackageInfo(long j) throws RemoteException;

    int getProductIdByModel(String str) throws RemoteException;

    HomeDeviceInfo getSharedHomeDeviceInfo(String str) throws RemoteException;

    void installPlugin(String str, boolean z, IClientCallback iClientCallback) throws RemoteException;

    boolean is13OptimizeBleLoginConnectModel(String str) throws RemoteException;

    boolean is6OptimizeBleLoginConnectModel(String str) throws RemoteException;

    boolean isBooleanValue(String str) throws RemoteException;

    boolean isLoggedIn() throws RemoteException;

    boolean isMiLoggedIn() throws RemoteException;

    boolean isPluginForceUpdating(String str) throws RemoteException;

    boolean isServicePromoteSuccess() throws RemoteException;

    void loadHomeDeviceList(long j, long j2, IClientCallback iClientCallback) throws RemoteException;

    void localPing(String str, IClientCallback iClientCallback) throws RemoteException;

    void localPingWithParams(String str, int i, int i2, IClientCallback iClientCallback) throws RemoteException;

    byte[] miotBleDecryptSync(String str, byte[] bArr) throws RemoteException;

    byte[] miotBleEncryptSync(String str, byte[] bArr) throws RemoteException;

    boolean needSecurityChipCheck(String str) throws RemoteException;

    void onActivityResume(String str) throws RemoteException;

    boolean postStatRecord(String str, boolean z) throws RemoteException;

    IBleChannelWriter registerChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException;

    void registerClientApi(IClientApi iClientApi) throws RemoteException;

    IBleChannelWriter registerSecureAuthChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException;

    IServerHandle renameDevice(String str, String str2, IClientCallback iClientCallback) throws RemoteException;

    void report_spec_result(long j, String str, boolean z, int i, String str2, String str3, String str4) throws RemoteException;

    void resetCore() throws RemoteException;

    IServerHandle rpcAsync(String str, String str2, String str3, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle rpcAsyncToCloud(String str, String str2, String str3, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle rpcAsyncToLocal(String str, String str2, String str3, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle scanDeviceList(ScanType scanType, IClientCallback iClientCallback) throws RemoteException;

    void searchBluetoothDevice(SearchRequest searchRequest, SearchResponse searchResponse) throws RemoteException;

    void searchMiioBluetoothDevice(SearchRequest searchRequest, IBleResponse iBleResponse) throws RemoteException;

    ISecureConnectHandler secureConnect(String str, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException;

    ISecureConnectHandler securityChipConnect(String str, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException;

    ISecureConnectHandler securityChipPincodeConnect(String str, String str2, String str3, int i, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException;

    ISecureConnectHandler securityChipSharedDeviceConnect(String str, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException;

    IServerHandle sendMiRechargeRequest(NetRequest netRequest, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle sendMiShopRequest(NetRequest netRequest, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle sendRouterRequest(NetRequest netRequest, String str, boolean z, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle sendSmartHomeRequest(NetRequest netRequest, Crypto crypto, IClientCallback iClientCallback) throws RemoteException;

    boolean setAlertConfigs(String str, int i, boolean z) throws RemoteException;

    void setBluetoothCache(String str, int i, Bundle bundle) throws RemoteException;

    void setCurrentHome(HomeDeviceInfo homeDeviceInfo) throws RemoteException;

    IServerHandle setGlobalSettingCTA(boolean z, boolean z2, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle setGlobalSettingLocale(Bundle bundle, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle setGlobalSettingServer(ServerBean serverBean, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle setGlobalSettingServerEnv(String str, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle setMiAccount(LoginMiAccount loginMiAccount, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle setMiServiceTokenTmp(MiServiceTokenInfo miServiceTokenInfo, IClientCallback iClientCallback) throws RemoteException;

    IServerHandle setOAuthAccount(OAuthAccount oAuthAccount, IClientCallback iClientCallback) throws RemoteException;

    void setScanTimePeriod(int i) throws RemoteException;

    int startAction(int i) throws RemoteException;

    void startBleMeshUpgrade(String str, String str2, String str3, String str4, IBleMeshUpgradeResponse iBleMeshUpgradeResponse) throws RemoteException;

    void startMcuUpgrade(String str, String str2, String str3, boolean z, String str4, int i, IBleMeshUpgradeResponse iBleMeshUpgradeResponse) throws RemoteException;

    void startScanWithCallback(int i, IClientCallback iClientCallback) throws RemoteException;

    void startScanWithModel(String str, IClientCallback iClientCallback) throws RemoteException;

    void stopScan() throws RemoteException;

    void stopSearchBluetoothDevice() throws RemoteException;

    String takeStatSession(long j, long j2) throws RemoteException;

    void unRegisterSecureAuthChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException;

    void updateActionResultByCode(int i, int i2) throws RemoteException;

    void updateActionResultById(int i, int i2) throws RemoteException;

    void updateBooleanValue(String str, boolean z) throws RemoteException;

    IServerHandle updateDeviceBatch(List<String> list, IClientCallback iClientCallback) throws RemoteException;

    void updatePluginConfig(boolean z, IClientCallback iClientCallback) throws RemoteException;

    void updateRnSdk(long j, IClientCallback iClientCallback) throws RemoteException;

    void updateWhiteList(boolean z) throws RemoteException;

    void uploadLogFile(String str, String str2, String[] strArr, boolean z, IClientCallback iClientCallback) throws RemoteException;

    void uploadStat() throws RemoteException;

    void writeLog(int i, String str, String str2, String str3) throws RemoteException;

    public static abstract class Stub extends Binder implements ICoreApi {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.core.server.ICoreApi");
        }

        public static ICoreApi asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.core.server.ICoreApi");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ICoreApi)) {
                return new Proxy(iBinder);
            }
            return (ICoreApi) queryLocalInterface;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v1, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v3, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v5, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v7, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v9, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v11, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v13, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v15, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v17, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v19, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v21, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v23, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v25, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v27, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v29, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v31, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v33, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v35, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v37, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v39, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v41, types: [com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask] */
        /* JADX WARN: Type inference failed for: r7v44, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v46 */
        /* JADX WARN: Type inference failed for: r7v47 */
        /* JADX WARN: Type inference failed for: r7v48, types: [com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest] */
        /* JADX WARN: Type inference failed for: r7v51, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r7v54, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v56, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r7v59, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r7v62, types: [com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest] */
        /* JADX WARN: Type inference failed for: r7v65, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v67, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v69, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v71, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v73, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v75, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v77, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v81, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v83, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v85, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v88, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v90, types: [com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo] */
        /* JADX WARN: Type inference failed for: r7v95 */
        /* JADX WARN: Type inference failed for: r7v96 */
        /* JADX WARN: Type inference failed for: r7v97 */
        /* JADX WARN: Type inference failed for: r7v98 */
        /* JADX WARN: Type inference failed for: r7v99 */
        /* JADX WARN: Type inference failed for: r7v100 */
        /* JADX WARN: Type inference failed for: r7v101 */
        /* JADX WARN: Type inference failed for: r7v102 */
        /* JADX WARN: Type inference failed for: r7v103 */
        /* JADX WARN: Type inference failed for: r7v104 */
        /* JADX WARN: Type inference failed for: r7v105 */
        /* JADX WARN: Type inference failed for: r7v106 */
        /* JADX WARN: Type inference failed for: r7v107 */
        /* JADX WARN: Type inference failed for: r7v108 */
        /* JADX WARN: Type inference failed for: r7v109 */
        /* JADX WARN: Type inference failed for: r7v110 */
        /* JADX WARN: Type inference failed for: r7v111 */
        /* JADX WARN: Type inference failed for: r7v112 */
        /* JADX WARN: Type inference failed for: r7v113 */
        /* JADX WARN: Type inference failed for: r7v114 */
        /* JADX WARN: Type inference failed for: r7v115 */
        /* JADX WARN: Type inference failed for: r7v116 */
        /* JADX WARN: Type inference failed for: r7v117 */
        /* JADX WARN: Type inference failed for: r7v118 */
        /* JADX WARN: Type inference failed for: r7v119 */
        /* JADX WARN: Type inference failed for: r7v120 */
        /* JADX WARN: Type inference failed for: r7v121 */
        /* JADX WARN: Type inference failed for: r7v122 */
        /* JADX WARN: Type inference failed for: r7v123 */
        /* JADX WARN: Type inference failed for: r7v124 */
        /* JADX WARN: Type inference failed for: r7v125 */
        /* JADX WARN: Type inference failed for: r7v126 */
        /* JADX WARN: Type inference failed for: r7v127 */
        /* JADX WARN: Type inference failed for: r7v128 */
        /* JADX WARN: Type inference failed for: r7v129 */
        /* JADX WARN: Type inference failed for: r7v130 */
        /* JADX WARN: Type inference failed for: r7v131 */
        /* JADX WARN: Type inference failed for: r7v132 */
        /* JADX WARN: Type inference failed for: r7v133 */
        /* JADX WARN: Type inference failed for: r7v134 */
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
        public boolean onTransact(int r15, android.os.Parcel r16, android.os.Parcel r17, int r18) throws android.os.RemoteException {
            /*
                r14 = this;
                r9 = r14
                r0 = r15
                r1 = r16
                r10 = r17
                r2 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r11 = 1
                java.lang.String r3 = "com.xiaomi.smarthome.core.server.ICoreApi"
                if (r0 == r2) goto L_0x0dcb
                r2 = 0
                r7 = 0
                switch(r0) {
                    case 1: goto L_0x0db9;
                    case 2: goto L_0x0daf;
                    case 3: goto L_0x0d9d;
                    case 4: goto L_0x0d88;
                    case 5: goto L_0x0d7a;
                    case 6: goto L_0x0d63;
                    case 7: goto L_0x0d55;
                    case 8: goto L_0x0d47;
                    case 9: goto L_0x0d39;
                    case 10: goto L_0x0d0d;
                    case 11: goto L_0x0ce1;
                    case 12: goto L_0x0cb5;
                    case 13: goto L_0x0c9e;
                    case 14: goto L_0x0c87;
                    case 15: goto L_0x0c6b;
                    case 16: goto L_0x0c61;
                    case 17: goto L_0x0c53;
                    case 18: goto L_0x0c17;
                    case 19: goto L_0x0be0;
                    case 20: goto L_0x0bb4;
                    case 21: goto L_0x0b88;
                    case 22: goto L_0x0b5c;
                    case 23: goto L_0x0b34;
                    case 24: goto L_0x0b0c;
                    case 25: goto L_0x0ae4;
                    case 26: goto L_0x0ac0;
                    case 27: goto L_0x0aa0;
                    case 28: goto L_0x0a7e;
                    case 29: goto L_0x0a5e;
                    case 30: goto L_0x0a48;
                    case 31: goto L_0x0a2a;
                    case 32: goto L_0x0a1c;
                    case 33: goto L_0x0a05;
                    case 34: goto L_0x09d9;
                    case 35: goto L_0x09c2;
                    case 36: goto L_0x0996;
                    case 37: goto L_0x0988;
                    case 38: goto L_0x0968;
                    case 39: goto L_0x0951;
                    case 40: goto L_0x0925;
                    case 41: goto L_0x0914;
                    case 42: goto L_0x090a;
                    case 43: goto L_0x08fc;
                    case 44: goto L_0x08e6;
                    case 45: goto L_0x08d0;
                    case 46: goto L_0x08c6;
                    case 47: goto L_0x08ad;
                    case 48: goto L_0x089b;
                    case 49: goto L_0x0880;
                    case 50: goto L_0x0865;
                    case 51: goto L_0x0853;
                    case 52: goto L_0x0841;
                    case 53: goto L_0x082f;
                    case 54: goto L_0x081d;
                    case 55: goto L_0x0800;
                    case 56: goto L_0x07ea;
                    case 57: goto L_0x07cd;
                    case 58: goto L_0x07b7;
                    case 59: goto L_0x07a1;
                    case 60: goto L_0x077c;
                    case 61: goto L_0x0761;
                    case 62: goto L_0x0746;
                    case 63: goto L_0x072b;
                    case 64: goto L_0x070f;
                    case 65: goto L_0x06fd;
                    case 66: goto L_0x06c4;
                    case 67: goto L_0x06ab;
                    case 68: goto L_0x0695;
                    case 69: goto L_0x068b;
                    case 70: goto L_0x066a;
                    case 71: goto L_0x0660;
                    case 72: goto L_0x062b;
                    case 73: goto L_0x05fb;
                    case 74: goto L_0x05ce;
                    case 75: goto L_0x05ad;
                    case 76: goto L_0x058c;
                    case 77: goto L_0x056f;
                    case 78: goto L_0x054f;
                    case 79: goto L_0x052f;
                    case 80: goto L_0x0519;
                    case 81: goto L_0x04e9;
                    case 82: goto L_0x04a5;
                    case 83: goto L_0x0475;
                    case 84: goto L_0x0445;
                    case 85: goto L_0x0406;
                    case 86: goto L_0x03de;
                    case 87: goto L_0x03a7;
                    case 88: goto L_0x0399;
                    case 89: goto L_0x0369;
                    case 90: goto L_0x0339;
                    case 91: goto L_0x0323;
                    case 92: goto L_0x030d;
                    case 93: goto L_0x02cd;
                    case 94: goto L_0x02bf;
                    case 95: goto L_0x02b5;
                    case 96: goto L_0x02ab;
                    case 97: goto L_0x029d;
                    case 98: goto L_0x0293;
                    case 99: goto L_0x0289;
                    case 100: goto L_0x026f;
                    case 101: goto L_0x0265;
                    case 102: goto L_0x0238;
                    case 103: goto L_0x0224;
                    case 104: goto L_0x0212;
                    case 105: goto L_0x01f7;
                    case 106: goto L_0x01de;
                    case 107: goto L_0x01c0;
                    case 108: goto L_0x01ae;
                    case 109: goto L_0x019c;
                    case 110: goto L_0x018a;
                    case 111: goto L_0x0178;
                    case 112: goto L_0x0166;
                    case 113: goto L_0x0154;
                    case 114: goto L_0x013e;
                    case 115: goto L_0x0130;
                    case 116: goto L_0x0116;
                    case 117: goto L_0x0104;
                    case 118: goto L_0x00f2;
                    case 119: goto L_0x00dc;
                    case 120: goto L_0x00b3;
                    case 121: goto L_0x00a1;
                    case 122: goto L_0x008f;
                    case 123: goto L_0x007d;
                    case 124: goto L_0x006b;
                    case 125: goto L_0x005d;
                    case 126: goto L_0x004b;
                    case 127: goto L_0x0018;
                    default: goto L_0x0013;
                }
            L_0x0013:
                boolean r0 = super.onTransact(r15, r16, r17, r18)
                return r0
            L_0x0018:
                r1.enforceInterface(r3)
                long r3 = r16.readLong()
                java.lang.String r5 = r16.readString()
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x002b
                r6 = 1
                goto L_0x002c
            L_0x002b:
                r6 = 0
            L_0x002c:
                int r7 = r16.readInt()
                java.lang.String r8 = r16.readString()
                java.lang.String r12 = r16.readString()
                java.lang.String r13 = r16.readString()
                r0 = r14
                r1 = r3
                r3 = r5
                r4 = r6
                r5 = r7
                r6 = r8
                r7 = r12
                r8 = r13
                r0.report_spec_result(r1, r3, r4, r5, r6, r7, r8)
                r17.writeNoException()
                return r11
            L_0x004b:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                boolean r0 = r14.needSecurityChipCheck(r0)
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x005d:
                r1.enforceInterface(r3)
                int r0 = r14.getOptimizeBleLoginConnectRetryTimes()
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x006b:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r0 = r14.get13OptimizeBleLoginConnectRetryDelay(r0)
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x007d:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                boolean r0 = r14.is13OptimizeBleLoginConnectModel(r0)
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x008f:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r0 = r14.get6OptimizeBleLoginConnectRetryDelay(r0)
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x00a1:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                boolean r0 = r14.is6OptimizeBleLoginConnectModel(r0)
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x00b3:
                r1.enforceInterface(r3)
                java.lang.String r3 = r16.readString()
                java.lang.String r4 = r16.readString()
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x00c6
                r5 = 1
                goto L_0x00c7
            L_0x00c6:
                r5 = 0
            L_0x00c7:
                long r6 = r16.readLong()
                long r12 = r16.readLong()
                r0 = r14
                r1 = r3
                r2 = r4
                r3 = r5
                r4 = r6
                r6 = r12
                r0.downloadCloudVideoIntoCloudSetting(r1, r2, r3, r4, r6)
                r17.writeNoException()
                return r11
            L_0x00dc:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                java.lang.String r2 = r16.readString()
                java.lang.String r1 = r16.readString()
                r14.addContextByActionCode(r0, r2, r1)
                r17.writeNoException()
                return r11
            L_0x00f2:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r1 = r16.readInt()
                r14.updateActionResultByCode(r0, r1)
                r17.writeNoException()
                return r11
            L_0x0104:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r1 = r16.readInt()
                r14.updateActionResultById(r0, r1)
                r17.writeNoException()
                return r11
            L_0x0116:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                java.lang.Class r2 = r14.getClass()
                java.lang.ClassLoader r2 = r2.getClassLoader()
                java.util.HashMap r1 = r1.readHashMap(r2)
                r14.finishCurrentActionWithContext(r0, r1)
                r17.writeNoException()
                return r11
            L_0x0130:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                r14.finishCurrentAction(r0)
                r17.writeNoException()
                return r11
            L_0x013e:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                java.lang.String r2 = r16.readString()
                java.lang.String r1 = r16.readString()
                r14.addContextToActionById(r0, r2, r1)
                r17.writeNoException()
                return r11
            L_0x0154:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                java.lang.String r1 = r16.readString()
                r14.appendContextToCurrentAction(r0, r1)
                r17.writeNoException()
                return r11
            L_0x0166:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                java.lang.String r1 = r16.readString()
                r14.addContextToCurrentAction(r0, r1)
                r17.writeNoException()
                return r11
            L_0x0178:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                int r0 = r14.startAction(r0)
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x018a:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                java.lang.String r1 = r16.readString()
                r14.addProcessContext(r0, r1)
                r17.writeNoException()
                return r11
            L_0x019c:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                java.lang.String r0 = r14.finishProcess(r0)
                r17.writeNoException()
                r10.writeString(r0)
                return r11
            L_0x01ae:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r1 = r16.readInt()
                r14.beginProcess(r0, r1)
                r17.writeNoException()
                return r11
            L_0x01c0:
                r1.enforceInterface(r3)
                long r2 = r16.readLong()
                long r4 = r16.readLong()
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r6 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r0)
                r0 = r14
                r1 = r2
                r3 = r4
                r5 = r6
                r0.loadHomeDeviceList(r1, r3, r5)
                r17.writeNoException()
                return r11
            L_0x01de:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x01f0
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo> r0 = com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                r7 = r0
                com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo r7 = (com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo) r7
            L_0x01f0:
                r14.setCurrentHome(r7)
                r17.writeNoException()
                return r11
            L_0x01f7:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo r0 = r14.getSharedHomeDeviceInfo(r0)
                r17.writeNoException()
                if (r0 == 0) goto L_0x020e
                r10.writeInt(r11)
                r0.writeToParcel(r10, r11)
                goto L_0x0211
            L_0x020e:
                r10.writeInt(r2)
            L_0x0211:
                return r11
            L_0x0212:
                r1.enforceInterface(r3)
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse r0 = com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse.Stub.asInterface(r0)
                r14.addClassicBtResponse(r0)
                r17.writeNoException()
                return r11
            L_0x0224:
                r1.enforceInterface(r3)
                com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest r0 = r14.getClassicBtRequestImpl()
                r17.writeNoException()
                if (r0 == 0) goto L_0x0234
                android.os.IBinder r7 = r0.asBinder()
            L_0x0234:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0238:
                r1.enforceInterface(r3)
                java.lang.String r3 = r16.readString()
                java.lang.String r4 = r16.readString()
                java.lang.String[] r5 = r16.createStringArray()
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x024f
                r6 = 1
                goto L_0x0250
            L_0x024f:
                r6 = 0
            L_0x0250:
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r7 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r0)
                r0 = r14
                r1 = r3
                r2 = r4
                r3 = r5
                r4 = r6
                r5 = r7
                r0.uploadLogFile(r1, r2, r3, r4, r5)
                r17.writeNoException()
                return r11
            L_0x0265:
                r1.enforceInterface(r3)
                r14.flushLog()
                r17.writeNoException()
                return r11
            L_0x026f:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                java.lang.String r2 = r16.readString()
                java.lang.String r3 = r16.readString()
                java.lang.String r1 = r16.readString()
                r14.writeLog(r0, r2, r3, r1)
                r17.writeNoException()
                return r11
            L_0x0289:
                r1.enforceInterface(r3)
                r14.applicationEnterBackground()
                r17.writeNoException()
                return r11
            L_0x0293:
                r1.enforceInterface(r3)
                r14.applicationEnterForground()
                r17.writeNoException()
                return r11
            L_0x029d:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                r14.onActivityResume(r0)
                r17.writeNoException()
                return r11
            L_0x02ab:
                r1.enforceInterface(r3)
                r14.resetCore()
                r17.writeNoException()
                return r11
            L_0x02b5:
                r1.enforceInterface(r3)
                r14.forceUpdateScene()
                r17.writeNoException()
                return r11
            L_0x02bf:
                r1.enforceInterface(r3)
                java.lang.String r0 = r14.getBluetoothGatewayDevices()
                r17.writeNoException()
                r10.writeString(r0)
                return r11
            L_0x02cd:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r2 = r16.readInt()
                if (r2 == 0) goto L_0x02e3
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig> r2 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig r2 = (com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig) r2
                goto L_0x02e4
            L_0x02e3:
                r2 = r7
            L_0x02e4:
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x02f3
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions> r3 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions r3 = (com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions) r3
                goto L_0x02f4
            L_0x02f3:
                r3 = r7
            L_0x02f4:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse r1 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler r0 = r14.bleComboStandardAuth(r0, r2, r3, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0309
                android.os.IBinder r7 = r0.asBinder()
            L_0x0309:
                r10.writeStrongBinder(r7)
                return r11
            L_0x030d:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                byte[] r1 = r16.createByteArray()
                byte[] r0 = r14.miotBleDecryptSync(r0, r1)
                r17.writeNoException()
                r10.writeByteArray(r0)
                return r11
            L_0x0323:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                byte[] r1 = r16.createByteArray()
                byte[] r0 = r14.miotBleEncryptSync(r0, r1)
                r17.writeNoException()
                r10.writeByteArray(r0)
                return r11
            L_0x0339:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r2 = r16.readInt()
                if (r2 == 0) goto L_0x034f
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions> r2 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions r2 = (com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions) r2
                goto L_0x0350
            L_0x034f:
                r2 = r7
            L_0x0350:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse r1 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler r0 = r14.bleStandardAuthConnect(r0, r2, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0365
                android.os.IBinder r7 = r0.asBinder()
            L_0x0365:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0369:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r2 = r16.readInt()
                if (r2 == 0) goto L_0x037f
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions> r2 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions r2 = (com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions) r2
                goto L_0x0380
            L_0x037f:
                r2 = r7
            L_0x0380:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse r1 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler r0 = r14.bleStandardAuthBind(r0, r2, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0395
                android.os.IBinder r7 = r0.asBinder()
            L_0x0395:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0399:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                r14.cancelBleMeshUpgrade(r0)
                r17.writeNoException()
                return r11
            L_0x03a7:
                r1.enforceInterface(r3)
                java.lang.String r3 = r16.readString()
                java.lang.String r4 = r16.readString()
                java.lang.String r5 = r16.readString()
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x03be
                r6 = 1
                goto L_0x03bf
            L_0x03be:
                r6 = 0
            L_0x03bf:
                java.lang.String r7 = r16.readString()
                int r8 = r16.readInt()
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.bluetooth.IBleMeshUpgradeResponse r12 = com.xiaomi.smarthome.core.server.bluetooth.IBleMeshUpgradeResponse.Stub.asInterface(r0)
                r0 = r14
                r1 = r3
                r2 = r4
                r3 = r5
                r4 = r6
                r5 = r7
                r6 = r8
                r7 = r12
                r0.startMcuUpgrade(r1, r2, r3, r4, r5, r6, r7)
                r17.writeNoException()
                return r11
            L_0x03de:
                r1.enforceInterface(r3)
                java.lang.String r2 = r16.readString()
                java.lang.String r3 = r16.readString()
                java.lang.String r4 = r16.readString()
                java.lang.String r5 = r16.readString()
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.bluetooth.IBleMeshUpgradeResponse r6 = com.xiaomi.smarthome.core.server.bluetooth.IBleMeshUpgradeResponse.Stub.asInterface(r0)
                r0 = r14
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r6
                r0.startBleMeshUpgrade(r1, r2, r3, r4, r5)
                r17.writeNoException()
                return r11
            L_0x0406:
                r1.enforceInterface(r3)
                java.lang.String r2 = r16.readString()
                java.lang.String r3 = r16.readString()
                java.lang.String r4 = r16.readString()
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x0425
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions> r0 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions r0 = (com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions) r0
                r5 = r0
                goto L_0x0426
            L_0x0425:
                r5 = r7
            L_0x0426:
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse r6 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse.Stub.asInterface(r0)
                r0 = r14
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r6
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler r0 = r0.bleMeshConnect(r1, r2, r3, r4, r5)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0441
                android.os.IBinder r7 = r0.asBinder()
            L_0x0441:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0445:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r2 = r16.readInt()
                if (r2 == 0) goto L_0x045b
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions> r2 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions r2 = (com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions) r2
                goto L_0x045c
            L_0x045b:
                r2 = r7
            L_0x045c:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse r1 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler r0 = r14.bleMeshBind(r0, r2, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0471
                android.os.IBinder r7 = r0.asBinder()
            L_0x0471:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0475:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r2 = r16.readInt()
                if (r2 == 0) goto L_0x048b
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions> r2 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions r2 = (com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions) r2
                goto L_0x048c
            L_0x048b:
                r2 = r7
            L_0x048c:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse r1 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler r0 = r14.securityChipSharedDeviceConnect(r0, r2, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x04a1
                android.os.IBinder r7 = r0.asBinder()
            L_0x04a1:
                r10.writeStrongBinder(r7)
                return r11
            L_0x04a5:
                r1.enforceInterface(r3)
                java.lang.String r2 = r16.readString()
                java.lang.String r3 = r16.readString()
                java.lang.String r4 = r16.readString()
                int r5 = r16.readInt()
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x04c8
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions> r0 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions r0 = (com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions) r0
                r6 = r0
                goto L_0x04c9
            L_0x04c8:
                r6 = r7
            L_0x04c9:
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse r8 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse.Stub.asInterface(r0)
                r0 = r14
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r6
                r6 = r8
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler r0 = r0.securityChipPincodeConnect(r1, r2, r3, r4, r5, r6)
                r17.writeNoException()
                if (r0 == 0) goto L_0x04e5
                android.os.IBinder r7 = r0.asBinder()
            L_0x04e5:
                r10.writeStrongBinder(r7)
                return r11
            L_0x04e9:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r2 = r16.readInt()
                if (r2 == 0) goto L_0x04ff
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions> r2 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions r2 = (com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions) r2
                goto L_0x0500
            L_0x04ff:
                r2 = r7
            L_0x0500:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse r1 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler r0 = r14.securityChipConnect(r0, r2, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0515
                android.os.IBinder r7 = r0.asBinder()
            L_0x0515:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0519:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader r1 = com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader.Stub.asInterface(r1)
                r14.unRegisterSecureAuthChannelReader(r0, r1)
                r17.writeNoException()
                return r11
            L_0x052f:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader r1 = com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter r0 = r14.registerSecureAuthChannelReader(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x054b
                android.os.IBinder r7 = r0.asBinder()
            L_0x054b:
                r10.writeStrongBinder(r7)
                return r11
            L_0x054f:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader r1 = com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter r0 = r14.registerChannelReader(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x056b
                android.os.IBinder r7 = r0.asBinder()
            L_0x056b:
                r10.writeStrongBinder(r7)
                return r11
            L_0x056f:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r3 = r16.readInt()
                int r1 = r16.readInt()
                if (r1 == 0) goto L_0x0581
                r2 = 1
            L_0x0581:
                boolean r0 = r14.setAlertConfigs(r0, r3, r2)
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x058c:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x059e
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest> r0 = com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                r7 = r0
                com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest r7 = (com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest) r7
            L_0x059e:
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.bluetooth.IBleResponse r0 = com.xiaomi.smarthome.core.server.bluetooth.IBleResponse.Stub.asInterface(r0)
                r14.searchMiioBluetoothDevice(r7, r0)
                r17.writeNoException()
                return r11
            L_0x05ad:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r2 = r16.readInt()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x05c7
                android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r3.createFromParcel(r1)
                r7 = r1
                android.os.Bundle r7 = (android.os.Bundle) r7
            L_0x05c7:
                r14.setBluetoothCache(r0, r2, r7)
                r17.writeNoException()
                return r11
            L_0x05ce:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r3 = r16.readInt()
                int r4 = r16.readInt()
                if (r4 == 0) goto L_0x05e8
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r4.createFromParcel(r1)
                r7 = r1
                android.os.Bundle r7 = (android.os.Bundle) r7
            L_0x05e8:
                r14.getBluetoothCache(r0, r3, r7)
                r17.writeNoException()
                if (r7 == 0) goto L_0x05f7
                r10.writeInt(r11)
                r7.writeToParcel(r10, r11)
                goto L_0x05fa
            L_0x05f7:
                r10.writeInt(r2)
            L_0x05fa:
                return r11
            L_0x05fb:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r2 = r16.readInt()
                if (r2 == 0) goto L_0x0611
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions> r2 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions r2 = (com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions) r2
                goto L_0x0612
            L_0x0611:
                r2 = r7
            L_0x0612:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse r1 = com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler r0 = r14.secureConnect(r0, r2, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0627
                android.os.IBinder r7 = r0.asBinder()
            L_0x0627:
                r10.writeStrongBinder(r7)
                return r11
            L_0x062b:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r3 = r16.readInt()
                int r4 = r16.readInt()
                if (r4 == 0) goto L_0x0645
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r1)
                r7 = r4
                android.os.Bundle r7 = (android.os.Bundle) r7
            L_0x0645:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.bluetooth.IBleResponse r1 = com.xiaomi.smarthome.core.server.bluetooth.IBleResponse.Stub.asInterface(r1)
                r14.callBluetoothApi(r0, r3, r7, r1)
                r17.writeNoException()
                if (r7 == 0) goto L_0x065c
                r10.writeInt(r11)
                r7.writeToParcel(r10, r11)
                goto L_0x065f
            L_0x065c:
                r10.writeInt(r2)
            L_0x065f:
                return r11
            L_0x0660:
                r1.enforceInterface(r3)
                r14.stopSearchBluetoothDevice()
                r17.writeNoException()
                return r11
            L_0x066a:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x067c
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest> r0 = com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                r7 = r0
                com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest r7 = (com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest) r7
            L_0x067c:
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.server.bluetooth.SearchResponse r0 = com.xiaomi.smarthome.core.server.bluetooth.SearchResponse.Stub.asInterface(r0)
                r14.searchBluetoothDevice(r7, r0)
                r17.writeNoException()
                return r11
            L_0x068b:
                r1.enforceInterface(r3)
                r14.uploadStat()
                r17.writeNoException()
                return r11
            L_0x0695:
                r1.enforceInterface(r3)
                long r2 = r16.readLong()
                long r0 = r16.readLong()
                java.lang.String r0 = r14.takeStatSession(r2, r0)
                r17.writeNoException()
                r10.writeString(r0)
                return r11
            L_0x06ab:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r1 = r16.readInt()
                if (r1 == 0) goto L_0x06b9
                r2 = 1
            L_0x06b9:
                boolean r0 = r14.postStatRecord(r0, r2)
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x06c4:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x06d6
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.entity.statistic.StatType> r0 = com.xiaomi.smarthome.core.entity.statistic.StatType.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.xiaomi.smarthome.core.entity.statistic.StatType r0 = (com.xiaomi.smarthome.core.entity.statistic.StatType) r0
                r7 = r0
            L_0x06d6:
                java.lang.String r3 = r16.readString()
                java.lang.String r4 = r16.readString()
                java.lang.String r5 = r16.readString()
                java.lang.String r6 = r16.readString()
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x06ee
                r8 = 1
                goto L_0x06ef
            L_0x06ee:
                r8 = 0
            L_0x06ef:
                r0 = r14
                r1 = r7
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r6
                r6 = r8
                r0.addStatRecord(r1, r2, r3, r4, r5, r6)
                r17.writeNoException()
                return r11
            L_0x06fd:
                r1.enforceInterface(r3)
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r0 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r0)
                r14.dumpPlugin(r0)
                r17.writeNoException()
                return r11
            L_0x070f:
                r1.enforceInterface(r3)
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r0 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r0)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.debugPluginPackage(r0)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0727
                android.os.IBinder r7 = r0.asBinder()
            L_0x0727:
                r10.writeStrongBinder(r7)
                return r11
            L_0x072b:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo r0 = r14.getDownloadPackageInfo(r0)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0742
                r10.writeInt(r11)
                r0.writeToParcel(r10, r11)
                goto L_0x0745
            L_0x0742:
                r10.writeInt(r2)
            L_0x0745:
                return r11
            L_0x0746:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo r0 = r14.getInstallPackageInfo(r0)
                r17.writeNoException()
                if (r0 == 0) goto L_0x075d
                r10.writeInt(r11)
                r0.writeToParcel(r10, r11)
                goto L_0x0760
            L_0x075d:
                r10.writeInt(r2)
            L_0x0760:
                return r11
            L_0x0761:
                r1.enforceInterface(r3)
                long r0 = r16.readLong()
                com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo r0 = r14.getPluginInstalledPackageInfo(r0)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0778
                r10.writeInt(r11)
                r0.writeToParcel(r10, r11)
                goto L_0x077b
            L_0x0778:
                r10.writeInt(r2)
            L_0x077b:
                return r11
            L_0x077c:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r2 = r16.readInt()
                if (r2 == 0) goto L_0x0792
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask> r2 = com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r1)
                r7 = r2
                com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask r7 = (com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask) r7
            L_0x0792:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                r14.cancelPluginDownload(r0, r7, r1)
                r17.writeNoException()
                return r11
            L_0x07a1:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                r14.getLatestPluginInfo(r0, r1)
                r17.writeNoException()
                return r11
            L_0x07b7:
                r1.enforceInterface(r3)
                long r2 = r16.readLong()
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r0 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r0)
                r14.updateRnSdk(r2, r0)
                r17.writeNoException()
                return r11
            L_0x07cd:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x07db
                r2 = 1
            L_0x07db:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                r14.installPlugin(r0, r2, r1)
                r17.writeNoException()
                return r11
            L_0x07ea:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                r14.deletePlugin(r0, r1)
                r17.writeNoException()
                return r11
            L_0x0800:
                r1.enforceInterface(r3)
                java.util.ArrayList r0 = r16.createStringArrayList()
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x080e
                r2 = 1
            L_0x080e:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                r14.downloadPlugin(r0, r2, r1)
                r17.writeNoException()
                return r11
            L_0x081d:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                boolean r0 = r14.isPluginForceUpdating(r0)
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x082f:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                java.lang.String r0 = r14.getModelBySSID(r0)
                r17.writeNoException()
                r10.writeString(r0)
                return r11
            L_0x0841:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r0 = r14.getProductIdByModel(r0)
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x0853:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                java.lang.String r0 = r14.getModelByProductId(r0)
                r17.writeNoException()
                r10.writeString(r0)
                return r11
            L_0x0865:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo r0 = r14.getExtraPluginInfo(r0)
                r17.writeNoException()
                if (r0 == 0) goto L_0x087c
                r10.writeInt(r11)
                r0.writeToParcel(r10, r11)
                goto L_0x087f
            L_0x087c:
                r10.writeInt(r2)
            L_0x087f:
                return r11
            L_0x0880:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo r0 = r14.getPluginInfo(r0)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0897
                r10.writeInt(r11)
                r0.writeToParcel(r10, r11)
                goto L_0x089a
            L_0x0897:
                r10.writeInt(r2)
            L_0x089a:
                return r11
            L_0x089b:
                r1.enforceInterface(r3)
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r0 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r0)
                r14.clearPluginConfig(r0)
                r17.writeNoException()
                return r11
            L_0x08ad:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x08b7
                r2 = 1
            L_0x08b7:
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r0 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r0)
                r14.updatePluginConfig(r2, r0)
                r17.writeNoException()
                return r11
            L_0x08c6:
                r1.enforceInterface(r3)
                r14.stopScan()
                r17.writeNoException()
                return r11
            L_0x08d0:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                r14.startScanWithModel(r0, r1)
                r17.writeNoException()
                return r11
            L_0x08e6:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                r14.startScanWithCallback(r0, r1)
                r17.writeNoException()
                return r11
            L_0x08fc:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                r14.setScanTimePeriod(r0)
                r17.writeNoException()
                return r11
            L_0x090a:
                r1.enforceInterface(r3)
                r14.clearWhiteList()
                r17.writeNoException()
                return r11
            L_0x0914:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x091e
                r2 = 1
            L_0x091e:
                r14.updateWhiteList(r2)
                r17.writeNoException()
                return r11
            L_0x0925:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x0937
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                android.os.Bundle r0 = (android.os.Bundle) r0
                goto L_0x0938
            L_0x0937:
                r0 = r7
            L_0x0938:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.setGlobalSettingLocale(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x094d
                android.os.IBinder r7 = r0.asBinder()
            L_0x094d:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0951:
                r1.enforceInterface(r3)
                android.os.Bundle r0 = r14.getGlobalSettingLocale()
                r17.writeNoException()
                if (r0 == 0) goto L_0x0964
                r10.writeInt(r11)
                r0.writeToParcel(r10, r11)
                goto L_0x0967
            L_0x0964:
                r10.writeInt(r2)
            L_0x0967:
                return r11
            L_0x0968:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.setGlobalSettingServerEnv(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0984
                android.os.IBinder r7 = r0.asBinder()
            L_0x0984:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0988:
                r1.enforceInterface(r3)
                java.lang.String r0 = r14.getGlobalSettingServerEnv()
                r17.writeNoException()
                r10.writeString(r0)
                return r11
            L_0x0996:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x09a8
                android.os.Parcelable$Creator<com.xiaomi.smarthome.frame.server_compact.ServerBean> r0 = com.xiaomi.smarthome.frame.server_compact.ServerBean.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.xiaomi.smarthome.frame.server_compact.ServerBean r0 = (com.xiaomi.smarthome.frame.server_compact.ServerBean) r0
                goto L_0x09a9
            L_0x09a8:
                r0 = r7
            L_0x09a9:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.setGlobalSettingServer(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x09be
                android.os.IBinder r7 = r0.asBinder()
            L_0x09be:
                r10.writeStrongBinder(r7)
                return r11
            L_0x09c2:
                r1.enforceInterface(r3)
                com.xiaomi.smarthome.frame.server_compact.ServerBean r0 = r14.getGlobalSettingServer()
                r17.writeNoException()
                if (r0 == 0) goto L_0x09d5
                r10.writeInt(r11)
                r0.writeToParcel(r10, r11)
                goto L_0x09d8
            L_0x09d5:
                r10.writeInt(r2)
            L_0x09d8:
                return r11
            L_0x09d9:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x09e4
                r0 = 1
                goto L_0x09e5
            L_0x09e4:
                r0 = 0
            L_0x09e5:
                int r3 = r16.readInt()
                if (r3 == 0) goto L_0x09ec
                r2 = 1
            L_0x09ec:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.setGlobalSettingCTA(r0, r2, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0a01
                android.os.IBinder r7 = r0.asBinder()
            L_0x0a01:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0a05:
                r1.enforceInterface(r3)
                com.xiaomi.smarthome.core.entity.globaldynamicsetting.CTAInfo r0 = r14.getGlobalSettingCTA()
                r17.writeNoException()
                if (r0 == 0) goto L_0x0a18
                r10.writeInt(r11)
                r0.writeToParcel(r10, r11)
                goto L_0x0a1b
            L_0x0a18:
                r10.writeInt(r2)
            L_0x0a1b:
                return r11
            L_0x0a1c:
                r1.enforceInterface(r3)
                boolean r0 = r14.isServicePromoteSuccess()
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x0a2a:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r2 = r16.readInt()
                int r3 = r16.readInt()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                r14.localPingWithParams(r0, r2, r3, r1)
                r17.writeNoException()
                return r11
            L_0x0a48:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                r14.localPing(r0, r1)
                r17.writeNoException()
                return r11
            L_0x0a5e:
                r1.enforceInterface(r3)
                java.util.ArrayList r0 = r16.createStringArrayList()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.updateDeviceBatch(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0a7a
                android.os.IBinder r7 = r0.asBinder()
            L_0x0a7a:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0a7e:
                r1.enforceInterface(r3)
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam> r0 = com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam.CREATOR
                java.util.ArrayList r0 = r1.createTypedArrayList(r0)
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.batchRpcAsync(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0a9c
                android.os.IBinder r7 = r0.asBinder()
            L_0x0a9c:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0aa0:
                r1.enforceInterface(r3)
                java.util.ArrayList r0 = r16.createStringArrayList()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.delDeviceBatch(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0abc
                android.os.IBinder r7 = r0.asBinder()
            L_0x0abc:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0ac0:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                java.lang.String r2 = r16.readString()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.renameDevice(r0, r2, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0ae0
                android.os.IBinder r7 = r0.asBinder()
            L_0x0ae0:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0ae4:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                java.lang.String r2 = r16.readString()
                java.lang.String r3 = r16.readString()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.rpcAsyncToCloud(r0, r2, r3, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0b08
                android.os.IBinder r7 = r0.asBinder()
            L_0x0b08:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0b0c:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                java.lang.String r2 = r16.readString()
                java.lang.String r3 = r16.readString()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.rpcAsyncToLocal(r0, r2, r3, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0b30
                android.os.IBinder r7 = r0.asBinder()
            L_0x0b30:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0b34:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                java.lang.String r2 = r16.readString()
                java.lang.String r3 = r16.readString()
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.rpcAsync(r0, r2, r3, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0b58
                android.os.IBinder r7 = r0.asBinder()
            L_0x0b58:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0b5c:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x0b6e
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.entity.device.ScanType> r0 = com.xiaomi.smarthome.core.entity.device.ScanType.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.xiaomi.smarthome.core.entity.device.ScanType r0 = (com.xiaomi.smarthome.core.entity.device.ScanType) r0
                goto L_0x0b6f
            L_0x0b6e:
                r0 = r7
            L_0x0b6f:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.scanDeviceList(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0b84
                android.os.IBinder r7 = r0.asBinder()
            L_0x0b84:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0b88:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x0b9a
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.entity.net.NetRequest> r0 = com.xiaomi.smarthome.core.entity.net.NetRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.xiaomi.smarthome.core.entity.net.NetRequest r0 = (com.xiaomi.smarthome.core.entity.net.NetRequest) r0
                goto L_0x0b9b
            L_0x0b9a:
                r0 = r7
            L_0x0b9b:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.sendMiShopRequest(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0bb0
                android.os.IBinder r7 = r0.asBinder()
            L_0x0bb0:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0bb4:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x0bc6
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.entity.net.NetRequest> r0 = com.xiaomi.smarthome.core.entity.net.NetRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.xiaomi.smarthome.core.entity.net.NetRequest r0 = (com.xiaomi.smarthome.core.entity.net.NetRequest) r0
                goto L_0x0bc7
            L_0x0bc6:
                r0 = r7
            L_0x0bc7:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.sendMiRechargeRequest(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0bdc
                android.os.IBinder r7 = r0.asBinder()
            L_0x0bdc:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0be0:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x0bf2
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.entity.net.NetRequest> r0 = com.xiaomi.smarthome.core.entity.net.NetRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.xiaomi.smarthome.core.entity.net.NetRequest r0 = (com.xiaomi.smarthome.core.entity.net.NetRequest) r0
                goto L_0x0bf3
            L_0x0bf2:
                r0 = r7
            L_0x0bf3:
                java.lang.String r3 = r16.readString()
                int r4 = r16.readInt()
                if (r4 == 0) goto L_0x0bfe
                r2 = 1
            L_0x0bfe:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.sendRouterRequest(r0, r3, r2, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0c13
                android.os.IBinder r7 = r0.asBinder()
            L_0x0c13:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0c17:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x0c29
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.entity.net.NetRequest> r0 = com.xiaomi.smarthome.core.entity.net.NetRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.xiaomi.smarthome.core.entity.net.NetRequest r0 = (com.xiaomi.smarthome.core.entity.net.NetRequest) r0
                goto L_0x0c2a
            L_0x0c29:
                r0 = r7
            L_0x0c2a:
                int r2 = r16.readInt()
                if (r2 == 0) goto L_0x0c39
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.entity.net.Crypto> r2 = com.xiaomi.smarthome.core.entity.net.Crypto.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r1)
                com.xiaomi.smarthome.core.entity.net.Crypto r2 = (com.xiaomi.smarthome.core.entity.net.Crypto) r2
                goto L_0x0c3a
            L_0x0c39:
                r2 = r7
            L_0x0c3a:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.sendSmartHomeRequest(r0, r2, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0c4f
                android.os.IBinder r7 = r0.asBinder()
            L_0x0c4f:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0c53:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                r14.clearMiServiceTokenInSystem(r0)
                r17.writeNoException()
                return r11
            L_0x0c61:
                r1.enforceInterface(r3)
                r14.clearAllMiServiceTokenInSystem()
                r17.writeNoException()
                return r11
            L_0x0c6b:
                r1.enforceInterface(r3)
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r0 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r0)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.clearAccount(r0)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0c83
                android.os.IBinder r7 = r0.asBinder()
            L_0x0c83:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0c87:
                r1.enforceInterface(r3)
                com.xiaomi.smarthome.core.entity.account.OAuthAccount r0 = r14.getOAuthAccount()
                r17.writeNoException()
                if (r0 == 0) goto L_0x0c9a
                r10.writeInt(r11)
                r0.writeToParcel(r10, r11)
                goto L_0x0c9d
            L_0x0c9a:
                r10.writeInt(r2)
            L_0x0c9d:
                return r11
            L_0x0c9e:
                r1.enforceInterface(r3)
                com.xiaomi.youpin.login.entity.account.LoginMiAccount r0 = r14.getMiAccount()
                r17.writeNoException()
                if (r0 == 0) goto L_0x0cb1
                r10.writeInt(r11)
                r0.writeToParcel(r10, r11)
                goto L_0x0cb4
            L_0x0cb1:
                r10.writeInt(r2)
            L_0x0cb4:
                return r11
            L_0x0cb5:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x0cc7
                android.os.Parcelable$Creator<com.xiaomi.smarthome.core.entity.account.OAuthAccount> r0 = com.xiaomi.smarthome.core.entity.account.OAuthAccount.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.xiaomi.smarthome.core.entity.account.OAuthAccount r0 = (com.xiaomi.smarthome.core.entity.account.OAuthAccount) r0
                goto L_0x0cc8
            L_0x0cc7:
                r0 = r7
            L_0x0cc8:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.setOAuthAccount(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0cdd
                android.os.IBinder r7 = r0.asBinder()
            L_0x0cdd:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0ce1:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x0cf3
                android.os.Parcelable$Creator<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo> r0 = com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo r0 = (com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo) r0
                goto L_0x0cf4
            L_0x0cf3:
                r0 = r7
            L_0x0cf4:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.setMiServiceTokenTmp(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0d09
                android.os.IBinder r7 = r0.asBinder()
            L_0x0d09:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0d0d:
                r1.enforceInterface(r3)
                int r0 = r16.readInt()
                if (r0 == 0) goto L_0x0d1f
                android.os.Parcelable$Creator<com.xiaomi.youpin.login.entity.account.LoginMiAccount> r0 = com.xiaomi.youpin.login.entity.account.LoginMiAccount.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.xiaomi.youpin.login.entity.account.LoginMiAccount r0 = (com.xiaomi.youpin.login.entity.account.LoginMiAccount) r0
                goto L_0x0d20
            L_0x0d1f:
                r0 = r7
            L_0x0d20:
                android.os.IBinder r1 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientCallback r1 = com.xiaomi.smarthome.core.client.IClientCallback.Stub.asInterface(r1)
                com.xiaomi.smarthome.core.server.IServerHandle r0 = r14.setMiAccount(r0, r1)
                r17.writeNoException()
                if (r0 == 0) goto L_0x0d35
                android.os.IBinder r7 = r0.asBinder()
            L_0x0d35:
                r10.writeStrongBinder(r7)
                return r11
            L_0x0d39:
                r1.enforceInterface(r3)
                java.lang.String r0 = r14.getMiId()
                r17.writeNoException()
                r10.writeString(r0)
                return r11
            L_0x0d47:
                r1.enforceInterface(r3)
                boolean r0 = r14.isMiLoggedIn()
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x0d55:
                r1.enforceInterface(r3)
                java.lang.String r0 = r14.getHomeId()
                r17.writeNoException()
                r10.writeString(r0)
                return r11
            L_0x0d63:
                r1.enforceInterface(r3)
                com.xiaomi.smarthome.core.entity.account.AccountType r0 = r14.getAccountType()
                r17.writeNoException()
                if (r0 == 0) goto L_0x0d76
                r10.writeInt(r11)
                r0.writeToParcel(r10, r11)
                goto L_0x0d79
            L_0x0d76:
                r10.writeInt(r2)
            L_0x0d79:
                return r11
            L_0x0d7a:
                r1.enforceInterface(r3)
                boolean r0 = r14.isLoggedIn()
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x0d88:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                int r1 = r16.readInt()
                if (r1 == 0) goto L_0x0d96
                r2 = 1
            L_0x0d96:
                r14.updateBooleanValue(r0, r2)
                r17.writeNoException()
                return r11
            L_0x0d9d:
                r1.enforceInterface(r3)
                java.lang.String r0 = r16.readString()
                boolean r0 = r14.isBooleanValue(r0)
                r17.writeNoException()
                r10.writeInt(r0)
                return r11
            L_0x0daf:
                r1.enforceInterface(r3)
                r14.gc()
                r17.writeNoException()
                return r11
            L_0x0db9:
                r1.enforceInterface(r3)
                android.os.IBinder r0 = r16.readStrongBinder()
                com.xiaomi.smarthome.core.client.IClientApi r0 = com.xiaomi.smarthome.core.client.IClientApi.Stub.asInterface(r0)
                r14.registerClientApi(r0)
                r17.writeNoException()
                return r11
            L_0x0dcb:
                r10.writeString(r3)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.core.server.ICoreApi.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        static class Proxy implements ICoreApi {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.core.server.ICoreApi";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void registerClientApi(IClientApi iClientApi) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeStrongBinder(iClientApi != null ? iClientApi.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void gc() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isBooleanValue(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(3, obtain, obtain2, 0);
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

            public void updateBooleanValue(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLoggedIn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    boolean z = false;
                    this.mRemote.transact(5, obtain, obtain2, 0);
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

            public AccountType getAccountType() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? AccountType.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getHomeId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isMiLoggedIn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    boolean z = false;
                    this.mRemote.transact(8, obtain, obtain2, 0);
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

            public String getMiId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle setMiAccount(LoginMiAccount loginMiAccount, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    if (loginMiAccount != null) {
                        obtain.writeInt(1);
                        loginMiAccount.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle setMiServiceTokenTmp(MiServiceTokenInfo miServiceTokenInfo, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    if (miServiceTokenInfo != null) {
                        obtain.writeInt(1);
                        miServiceTokenInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle setOAuthAccount(OAuthAccount oAuthAccount, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    if (oAuthAccount != null) {
                        obtain.writeInt(1);
                        oAuthAccount.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public LoginMiAccount getMiAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? LoginMiAccount.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public OAuthAccount getOAuthAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? OAuthAccount.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle clearAccount(IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearAllMiServiceTokenInSystem() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearMiServiceTokenInSystem(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle sendSmartHomeRequest(NetRequest netRequest, Crypto crypto, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    if (netRequest != null) {
                        obtain.writeInt(1);
                        netRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (crypto != null) {
                        obtain.writeInt(1);
                        crypto.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle sendRouterRequest(NetRequest netRequest, String str, boolean z, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    int i = 1;
                    if (netRequest != null) {
                        obtain.writeInt(1);
                        netRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle sendMiRechargeRequest(NetRequest netRequest, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    if (netRequest != null) {
                        obtain.writeInt(1);
                        netRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle sendMiShopRequest(NetRequest netRequest, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    if (netRequest != null) {
                        obtain.writeInt(1);
                        netRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle scanDeviceList(ScanType scanType, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    if (scanType != null) {
                        obtain.writeInt(1);
                        scanType.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle rpcAsync(String str, String str2, String str3, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle rpcAsyncToLocal(String str, String str2, String str3, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle rpcAsyncToCloud(String str, String str2, String str3, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle renameDevice(String str, String str2, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle delDeviceBatch(List<String> list, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeStringList(list);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle batchRpcAsync(List<BatchRpcParam> list, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeTypedList(list);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle updateDeviceBatch(List<String> list, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeStringList(list);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void localPing(String str, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void localPingWithParams(String str, int i, int i2, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isServicePromoteSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    boolean z = false;
                    this.mRemote.transact(32, obtain, obtain2, 0);
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

            public CTAInfo getGlobalSettingCTA() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? CTAInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle setGlobalSettingCTA(boolean z, boolean z2, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    int i = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ServerBean getGlobalSettingServer() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? ServerBean.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle setGlobalSettingServer(ServerBean serverBean, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    if (serverBean != null) {
                        obtain.writeInt(1);
                        serverBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getGlobalSettingServerEnv() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle setGlobalSettingServerEnv(String str, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getGlobalSettingLocale() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle setGlobalSettingLocale(Bundle bundle, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateWhiteList(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearWhiteList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setScanTimePeriod(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(i);
                    this.mRemote.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startScanWithCallback(int i, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startScanWithModel(String str, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopScan() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updatePluginConfig(boolean z, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearPluginConfig(IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PluginDeviceInfo getPluginInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    this.mRemote.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? PluginDeviceInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PluginDeviceInfo getExtraPluginInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    this.mRemote.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? PluginDeviceInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getModelByProductId(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(i);
                    this.mRemote.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getProductIdByModel(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    this.mRemote.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getModelBySSID(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    this.mRemote.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isPluginForceUpdating(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(54, obtain, obtain2, 0);
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

            public void downloadPlugin(List<String> list, boolean z, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeStringList(list);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void deletePlugin(String str, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void installPlugin(String str, boolean z, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateRnSdk(long j, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeLong(j);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getLatestPluginInfo(String str, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void cancelPluginDownload(String str, PluginDownloadTask pluginDownloadTask, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    if (pluginDownloadTask != null) {
                        obtain.writeInt(1);
                        pluginDownloadTask.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PluginPackageInfo getPluginInstalledPackageInfo(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeLong(j);
                    this.mRemote.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? PluginPackageInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PluginPackageInfo getInstallPackageInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    this.mRemote.transact(62, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? PluginPackageInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PluginPackageInfo getDownloadPackageInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    this.mRemote.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? PluginPackageInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IServerHandle debugPluginPackage(IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                    return IServerHandle.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void dumpPlugin(IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addStatRecord(StatType statType, String str, String str2, String str3, String str4, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    int i = 1;
                    if (statType != null) {
                        obtain.writeInt(1);
                        statType.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean postStatRecord(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    boolean z2 = true;
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(67, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String takeStatSession(long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(68, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void uploadStat() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(69, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void searchBluetoothDevice(SearchRequest searchRequest, SearchResponse searchResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    if (searchRequest != null) {
                        obtain.writeInt(1);
                        searchRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(searchResponse != null ? searchResponse.asBinder() : null);
                    this.mRemote.transact(70, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopSearchBluetoothDevice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(71, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void callBluetoothApi(String str, int i, Bundle bundle, IBleResponse iBleResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBleResponse != null ? iBleResponse.asBinder() : null);
                    this.mRemote.transact(72, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ISecureConnectHandler secureConnect(String str, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    if (secureConnectOptions != null) {
                        obtain.writeInt(1);
                        secureConnectOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iSecureConnectResponse != null ? iSecureConnectResponse.asBinder() : null);
                    this.mRemote.transact(73, obtain, obtain2, 0);
                    obtain2.readException();
                    return ISecureConnectHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getBluetoothCache(String str, int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(74, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setBluetoothCache(String str, int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(75, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void searchMiioBluetoothDevice(SearchRequest searchRequest, IBleResponse iBleResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    if (searchRequest != null) {
                        obtain.writeInt(1);
                        searchRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBleResponse != null ? iBleResponse.asBinder() : null);
                    this.mRemote.transact(76, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setAlertConfigs(String str, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    boolean z2 = true;
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(77, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBleChannelWriter registerChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBleChannelReader != null ? iBleChannelReader.asBinder() : null);
                    this.mRemote.transact(78, obtain, obtain2, 0);
                    obtain2.readException();
                    return IBleChannelWriter.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBleChannelWriter registerSecureAuthChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBleChannelReader != null ? iBleChannelReader.asBinder() : null);
                    this.mRemote.transact(79, obtain, obtain2, 0);
                    obtain2.readException();
                    return IBleChannelWriter.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unRegisterSecureAuthChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBleChannelReader != null ? iBleChannelReader.asBinder() : null);
                    this.mRemote.transact(80, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ISecureConnectHandler securityChipConnect(String str, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    if (secureConnectOptions != null) {
                        obtain.writeInt(1);
                        secureConnectOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iSecureConnectResponse != null ? iSecureConnectResponse.asBinder() : null);
                    this.mRemote.transact(81, obtain, obtain2, 0);
                    obtain2.readException();
                    return ISecureConnectHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ISecureConnectHandler securityChipPincodeConnect(String str, String str2, String str3, int i, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    if (secureConnectOptions != null) {
                        obtain.writeInt(1);
                        secureConnectOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iSecureConnectResponse != null ? iSecureConnectResponse.asBinder() : null);
                    this.mRemote.transact(82, obtain, obtain2, 0);
                    obtain2.readException();
                    return ISecureConnectHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ISecureConnectHandler securityChipSharedDeviceConnect(String str, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    if (secureConnectOptions != null) {
                        obtain.writeInt(1);
                        secureConnectOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iSecureConnectResponse != null ? iSecureConnectResponse.asBinder() : null);
                    this.mRemote.transact(83, obtain, obtain2, 0);
                    obtain2.readException();
                    return ISecureConnectHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ISecureConnectHandler bleMeshBind(String str, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    if (secureConnectOptions != null) {
                        obtain.writeInt(1);
                        secureConnectOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iSecureConnectResponse != null ? iSecureConnectResponse.asBinder() : null);
                    this.mRemote.transact(84, obtain, obtain2, 0);
                    obtain2.readException();
                    return ISecureConnectHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ISecureConnectHandler bleMeshConnect(String str, String str2, String str3, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (secureConnectOptions != null) {
                        obtain.writeInt(1);
                        secureConnectOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iSecureConnectResponse != null ? iSecureConnectResponse.asBinder() : null);
                    this.mRemote.transact(85, obtain, obtain2, 0);
                    obtain2.readException();
                    return ISecureConnectHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startBleMeshUpgrade(String str, String str2, String str3, String str4, IBleMeshUpgradeResponse iBleMeshUpgradeResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeStrongBinder(iBleMeshUpgradeResponse != null ? iBleMeshUpgradeResponse.asBinder() : null);
                    this.mRemote.transact(86, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startMcuUpgrade(String str, String str2, String str3, boolean z, String str4, int i, IBleMeshUpgradeResponse iBleMeshUpgradeResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str4);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBleMeshUpgradeResponse != null ? iBleMeshUpgradeResponse.asBinder() : null);
                    this.mRemote.transact(87, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void cancelBleMeshUpgrade(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    this.mRemote.transact(88, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ISecureConnectHandler bleStandardAuthBind(String str, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    if (secureConnectOptions != null) {
                        obtain.writeInt(1);
                        secureConnectOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iSecureConnectResponse != null ? iSecureConnectResponse.asBinder() : null);
                    this.mRemote.transact(89, obtain, obtain2, 0);
                    obtain2.readException();
                    return ISecureConnectHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ISecureConnectHandler bleStandardAuthConnect(String str, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    if (secureConnectOptions != null) {
                        obtain.writeInt(1);
                        secureConnectOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iSecureConnectResponse != null ? iSecureConnectResponse.asBinder() : null);
                    this.mRemote.transact(90, obtain, obtain2, 0);
                    obtain2.readException();
                    return ISecureConnectHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public byte[] miotBleEncryptSync(String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(91, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public byte[] miotBleDecryptSync(String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(92, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ISecureConnectHandler bleComboStandardAuth(String str, BleComboWifiConfig bleComboWifiConfig, SecureConnectOptions secureConnectOptions, ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    if (bleComboWifiConfig != null) {
                        obtain.writeInt(1);
                        bleComboWifiConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (secureConnectOptions != null) {
                        obtain.writeInt(1);
                        secureConnectOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iSecureConnectResponse != null ? iSecureConnectResponse.asBinder() : null);
                    this.mRemote.transact(93, obtain, obtain2, 0);
                    obtain2.readException();
                    return ISecureConnectHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getBluetoothGatewayDevices() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(94, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void forceUpdateScene() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(95, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resetCore() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(96, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onActivityResume(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    this.mRemote.transact(97, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void applicationEnterForground() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(98, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void applicationEnterBackground() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(99, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void writeLog(int i, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(100, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void flushLog() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(101, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void uploadLogFile(String str, String str2, String[] strArr, boolean z, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(102, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IClassicBtRequest getClassicBtRequestImpl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(103, obtain, obtain2, 0);
                    obtain2.readException();
                    return IClassicBtRequest.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addClassicBtResponse(IClassicBtResponse iClassicBtResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeStrongBinder(iClassicBtResponse != null ? iClassicBtResponse.asBinder() : null);
                    this.mRemote.transact(104, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public HomeDeviceInfo getSharedHomeDeviceInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    this.mRemote.transact(105, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? HomeDeviceInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCurrentHome(HomeDeviceInfo homeDeviceInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    if (homeDeviceInfo != null) {
                        obtain.writeInt(1);
                        homeDeviceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(106, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void loadHomeDeviceList(long j, long j2, IClientCallback iClientCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeStrongBinder(iClientCallback != null ? iClientCallback.asBinder() : null);
                    this.mRemote.transact(107, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void beginProcess(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(108, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String finishProcess(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(i);
                    this.mRemote.transact(109, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addProcessContext(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(110, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int startAction(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(i);
                    this.mRemote.transact(111, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addContextToCurrentAction(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(112, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void appendContextToCurrentAction(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(113, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addContextToActionById(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(114, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void finishCurrentAction(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(i);
                    this.mRemote.transact(115, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void finishCurrentActionWithContext(int i, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(i);
                    obtain.writeMap(map);
                    this.mRemote.transact(116, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateActionResultById(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(117, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateActionResultByCode(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(118, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addContextByActionCode(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(119, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void downloadCloudVideoIntoCloudSetting(String str, String str2, boolean z, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(120, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean is6OptimizeBleLoginConnectModel(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(121, obtain, obtain2, 0);
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

            public int get6OptimizeBleLoginConnectRetryDelay(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    this.mRemote.transact(122, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean is13OptimizeBleLoginConnectModel(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(123, obtain, obtain2, 0);
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

            public int get13OptimizeBleLoginConnectRetryDelay(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
                    this.mRemote.transact(124, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getOptimizeBleLoginConnectRetryTimes() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    this.mRemote.transact(125, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean needSecurityChipCheck(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeString(str);
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

            public void report_spec_result(long j, String str, boolean z, int i, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.ICoreApi");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(127, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

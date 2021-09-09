package com.xiaomi.smarthome.core.server;

import _m_j.dxe;
import _m_j.eyr;
import _m_j.fcn;
import _m_j.fcw;
import _m_j.fcx;
import _m_j.fcy;
import _m_j.fde;
import _m_j.fdg;
import _m_j.fdh;
import _m_j.fdi;
import _m_j.fdk;
import _m_j.fdm;
import _m_j.fdn;
import _m_j.fdo;
import _m_j.fdp;
import _m_j.fdq;
import _m_j.fdr;
import _m_j.fds;
import _m_j.fdt;
import _m_j.fec;
import _m_j.fen;
import _m_j.feo;
import _m_j.fes;
import _m_j.few;
import _m_j.ffq;
import _m_j.ffr;
import _m_j.fgo;
import _m_j.fiy;
import _m_j.fjc;
import _m_j.fjd;
import _m_j.fjh;
import _m_j.fjo;
import _m_j.fjp;
import _m_j.fjq;
import _m_j.fjt;
import _m_j.fju;
import _m_j.fjx;
import _m_j.fkc;
import _m_j.fkf;
import _m_j.fkg;
import _m_j.fkh;
import _m_j.fki;
import _m_j.fkj;
import _m_j.fkl;
import _m_j.fkm;
import _m_j.fkn;
import _m_j.fko;
import _m_j.fkt;
import _m_j.fkw;
import _m_j.fky;
import _m_j.flb;
import _m_j.fld;
import _m_j.flj;
import _m_j.flm;
import _m_j.fln;
import _m_j.flq;
import _m_j.flt;
import _m_j.flu;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsp;
import _m_j.fsr;
import _m_j.ft;
import _m_j.ftf;
import _m_j.ftm;
import _m_j.ftn;
import _m_j.gfr;
import _m_j.gle;
import _m_j.gnk;
import _m_j.gnn;
import _m_j.gog;
import _m_j.gor;
import _m_j.grr;
import _m_j.gsn;
import _m_j.gsr;
import _m_j.gsy;
import _m_j.hhc;
import _m_j.hsi;
import _m_j.hvg;
import _m_j.hxi;
import _m_j.hxt;
import _m_j.hyi;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.MemoryFile;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.miio.MiioLocalErrorCode;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.MessageReceiver;
import com.xiaomi.smarthome.core.client.IClientApi;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.account.AccountType;
import com.xiaomi.smarthome.core.entity.account.OAuthAccount;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.entity.device.ScanType;
import com.xiaomi.smarthome.core.entity.globaldynamicsetting.CTAInfo;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.core.entity.plugin.DownloadPluginDebugPackageResult;
import com.xiaomi.smarthome.core.entity.plugin.DownloadPluginResult;
import com.xiaomi.smarthome.core.entity.plugin.DownloadRnSdkResult;
import com.xiaomi.smarthome.core.entity.plugin.InstallPluginResult;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.entity.plugin.UpdatePluginConfigResult;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.core.server.ICoreApi;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.bluetooth.IBleMeshUpgradeResponse;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest;
import com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse;
import com.xiaomi.smarthome.core.server.bluetooth.SearchResponse;
import com.xiaomi.smarthome.core.server.debug.NetRequestWarningActivity;
import com.xiaomi.smarthome.core.server.internal.bluetooth.ClassicBtService;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.BleSecureConnectManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam;
import com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.DynamicFeatureManager;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CoreApiStub extends ICoreApi.Stub {
    boolean mIsPromoteSuccess = false;
    private Map<String, Boolean> statusMap = new ConcurrentHashMap();

    public OAuthAccount getOAuthAccount() throws RemoteException {
        return null;
    }

    public IBleChannelWriter registerChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException {
        return null;
    }

    public void registerClientApi(final IClientApi iClientApi) {
        try {
            final int callingPid = getCallingPid();
            final int callingUid = getCallingUid();
            if (gfr.O0000Ooo) {
                gsy.O000000o(3, "login", "CoreApiStub registerClientApi in");
            }
            new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass1 */

                public void onCancel() {
                }

                public void run() {
                    if (gfr.O0000Ooo) {
                        gsy.O000000o(3, "login", "ClientApiStub registerClientApi CoreAsyncTask in");
                    }
                    fcy O000000o2 = fcy.O000000o();
                    IClientApi iClientApi = iClientApi;
                    int i = callingPid;
                    int i2 = callingUid;
                    fcw fcw = O000000o2.f16093O000000o.get(Integer.valueOf(i));
                    if (fcw == null) {
                        fcw = new fcw();
                    }
                    fcw fcw2 = fcw;
                    fcw2.O000000o(iClientApi, i, i2, ftm.O000000o(CommonApplication.getAppContext(), i), fcy.O00000Oo(i2), System.currentTimeMillis());
                    O000000o2.f16093O000000o.put(Integer.valueOf(i), fcw2);
                    try {
                        fcy.O000000o o000000o = new fcy.O000000o(i);
                        iClientApi.asBinder().linkToDeath(o000000o, 0);
                        fcw2.O000000o(o000000o);
                    } catch (RemoteException unused) {
                    }
                    CoreApi O000000o3 = CoreApi.O000000o();
                    if (O000000o3.O00000o0()) {
                        try {
                            iClientApi.onAccountReady(O000000o3.O0000Ooo(), O000000o3.O0000o0());
                        } catch (RemoteException e) {
                            gsy.O000000o(6, "CoreApiStub", Log.getStackTraceString(e));
                        }
                    }
                    if (O000000o3.O00000o()) {
                        try {
                            iClientApi.onGlobalDynamicSettingReady();
                        } catch (RemoteException e2) {
                            gsy.O000000o(6, "CoreApiStub", Log.getStackTraceString(e2));
                        }
                    }
                    if (O000000o3.O00000oO()) {
                        try {
                            iClientApi.onStatisticReady();
                        } catch (RemoteException e3) {
                            gsy.O000000o(6, "CoreApiStub", Log.getStackTraceString(e3));
                        }
                    }
                    if (O000000o3.O00000oo()) {
                        try {
                            iClientApi.onPluginReady();
                        } catch (RemoteException e4) {
                            gsy.O000000o(6, "CoreApiStub", Log.getStackTraceString(e4));
                        }
                    }
                    if (O000000o3.O0000O0o()) {
                        try {
                            iClientApi.onCoreReady();
                        } catch (RemoteException e5) {
                            gsy.O000000o(6, "CoreApiStub", Log.getStackTraceString(e5));
                        }
                    }
                }
            }.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gc() throws RemoteException {
        if (fsr.O0000O0o || fsr.O0000Oo0) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass2 */

                public final void run() {
                    System.gc();
                }
            });
        }
    }

    public boolean isBooleanValue(String str) throws RemoteException {
        try {
            int callingPid = getCallingPid();
            if (!fcy.O000000o().O000000o(callingPid)) {
                return false;
            }
            if ("KEY.IS_DEVELOPER".equals(str)) {
                return flq.O000000o().O00000o0;
            }
            if ("KEY.IS_SCAN".equals(str)) {
                if (!flq.O000000o().O00000Oo(callingPid, getCallingUid())) {
                    return false;
                }
                return flt.O000000o();
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public void updateBooleanValue(String str, boolean z) throws RemoteException {
        int callingPid = getCallingPid();
        if (!TextUtils.isEmpty(str)) {
            gsy.O000000o(3, "CoreApiStub", "update boolean value key=" + str + ",value =" + z);
            if (fcy.O000000o().O000000o(callingPid)) {
                this.statusMap.put(str, Boolean.valueOf(z));
                gsy.O000000o(3, "CoreApiStub", "update2 boolean value key=" + str + ",value =" + z);
            }
        }
    }

    public boolean isLoggedIn() throws RemoteException {
        int callingPid = getCallingPid();
        getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            return false;
        }
        return fdk.O000000o().O0000OOo();
    }

    public AccountType getAccountType() throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O00000Oo(callingPid, callingUid)) {
            return fdk.O000000o().O00000o0();
        }
        return null;
    }

    public String getHomeId() throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O00000Oo(callingPid, callingUid)) {
            return fdk.O000000o().O00000o();
        }
        return "";
    }

    public boolean isMiLoggedIn() throws RemoteException {
        getCallingPid();
        getCallingUid();
        return fdk.O000000o().O0000Oo0();
    }

    public String getMiId() {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O00000Oo(callingPid, callingUid)) {
            return fdk.O000000o().O0000Oo();
        }
        return "0";
    }

    public IServerHandle setMiAccount(final LoginMiAccount loginMiAccount, final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O000000o(callingPid, callingUid)) {
            if (iClientCallback != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("error", new Error(-3, "core service : permission deny"));
                try {
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass3 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass3 */

                public void onCancel() {
                }

                public void run() {
                    fdk.O000000o().O00000oo();
                    fdk.O000000o().O000000o(loginMiAccount);
                    fdk.O000000o().O0000O0o();
                    fdt.O000000o().O000000o(false);
                    fdr.O000000o().O00000Oo();
                    fdo.O000000o().O000000o(false);
                    fdm.O000000o().O000000o(false);
                    fdn.O000000o().O000000o(false);
                    fln.O000000o();
                    ffr.O000000o();
                    fjd.O000000o().O0000O0o();
                    fjx O000000o2 = fjx.O000000o();
                    O000000o2.O00000Oo = new ConcurrentHashMap();
                    O000000o2.O00000o0 = null;
                    O000000o2.O00000o = new HashSet();
                    flq.O000000o().O00000Oo();
                    if (iClientCallback != null) {
                        try {
                            iClientCallback.onSuccess(new Bundle());
                        } catch (RemoteException e) {
                            Log.e("CoreApiStub", "fatal", e);
                        }
                    }
                }
            };
            r0.execute();
            return r0;
        }
    }

    public IServerHandle setMiServiceTokenTmp(final MiServiceTokenInfo miServiceTokenInfo, final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O000000o(callingPid, callingUid)) {
            if (iClientCallback != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("error", new Error(-3, "core service : permission deny"));
                try {
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass4 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass4 */

                public void onCancel() {
                }

                public void run() {
                    MiServiceTokenInfo miServiceTokenInfo = miServiceTokenInfo;
                    if (miServiceTokenInfo != null && !TextUtils.isEmpty(miServiceTokenInfo.f12086O000000o) && !TextUtils.isEmpty(miServiceTokenInfo.O00000o0) && !TextUtils.isEmpty(miServiceTokenInfo.O00000o) && !TextUtils.isEmpty(miServiceTokenInfo.O00000oo)) {
                        fdk.O000000o().O000000o(miServiceTokenInfo.f12086O000000o, miServiceTokenInfo.O00000o0, miServiceTokenInfo.O00000Oo, miServiceTokenInfo.O00000o, miServiceTokenInfo.O00000oo, miServiceTokenInfo.O00000oO);
                        fdk.O000000o().O0000O0o();
                        if (miServiceTokenInfo.f12086O000000o.equalsIgnoreCase("xiaomiio")) {
                            fdt.O000000o().O000000o(false);
                            fdr.O000000o().O00000Oo();
                            fln.O000000o();
                        }
                        if (iClientCallback != null) {
                            try {
                                iClientCallback.onSuccess(new Bundle());
                            } catch (RemoteException e) {
                                Log.e("CoreApiStub", "fatal", e);
                            }
                        }
                    } else if (iClientCallback != null) {
                        try {
                            iClientCallback.onFailure(new Bundle());
                        } catch (RemoteException e2) {
                            Log.e("CoreApiStub", "fatal", e2);
                        }
                    }
                }
            };
            r0.execute();
            return r0;
        }
    }

    public IServerHandle setOAuthAccount(final OAuthAccount oAuthAccount, final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O000000o(callingPid, callingUid)) {
            if (iClientCallback != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("error", new Error(-3, "core service : permission deny"));
                try {
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass5 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass5 */

                public void onCancel() {
                }

                public void run() {
                    fdk.O000000o().O00000oo();
                    fdk.O000000o().O000000o(oAuthAccount);
                    fdk.O000000o().O0000O0o();
                    fdt.O000000o().O000000o(false);
                    fdr.O000000o().O00000Oo();
                    fdo.O000000o().O000000o(false);
                    fdm.O000000o().O000000o(false);
                    fdn.O000000o().O000000o(false);
                    fln.O000000o();
                    if (iClientCallback != null) {
                        try {
                            iClientCallback.onSuccess(new Bundle());
                        } catch (RemoteException e) {
                            Log.e("CoreApiStub", "fatal", e);
                        }
                    }
                }
            };
            r0.execute();
            return r0;
        }
    }

    public LoginMiAccount getMiAccount() throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O00000Oo(callingPid, callingUid)) {
            return fdk.O000000o().O00000oO();
        }
        return null;
    }

    public IServerHandle clearAccount(final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O000000o(callingPid, callingUid)) {
            if (iClientCallback != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("error", new Error(-3, "core service : permission deny"));
                try {
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass6 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass6 */

                public void onCancel() {
                }

                public void run() {
                    if (fdk.O000000o().O0000OoO()) {
                        fdk.O000000o().O0000o00();
                    }
                    fdk.O000000o().O00000oo();
                    fdt.O000000o().O000000o(false);
                    fdr.O000000o().O00000Oo();
                    fdo.O000000o().O000000o(false);
                    fdm.O000000o().O000000o(false);
                    fdn.O000000o().O000000o(false);
                    fln.O000000o();
                    ffr.O000000o();
                    if (iClientCallback != null) {
                        try {
                            iClientCallback.onSuccess(new Bundle());
                        } catch (RemoteException e) {
                            Log.e("CoreApiStub", "fatal", e);
                        }
                    }
                }
            };
            r0.execute();
            return r0;
        }
    }

    public void clearAllMiServiceTokenInSystem() throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
            fdk.O000000o().O0000o00();
        }
    }

    public void clearMiServiceTokenInSystem(String str) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
            fdk.O000000o().O00000o0(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c  */
    public IServerHandle sendSmartHomeRequest(final NetRequest netRequest, final Crypto crypto, final IClientCallback iClientCallback) throws RemoteException {
        boolean z;
        fcw fcw;
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fsr.O0000O0o || fsr.O0000Oo0) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) CoreService.getAppContext().getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == callingPid && "com.xiaomi.smarthome".equals(next.processName)) {
                    z = true;
                    break;
                }
            }
            if (z && !flm.O000000o(CoreService.getAppContext())) {
                fcy O000000o2 = fcy.O000000o();
                if (!TextUtils.isEmpty("com.xiaomi.smarthome")) {
                    Iterator<Map.Entry<Integer, fcw>> it2 = O000000o2.f16093O000000o.entrySet().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        fcw = (fcw) it2.next().getValue();
                        if (!TextUtils.isEmpty(fcw.O00000Oo()) && fcw.O00000Oo().equalsIgnoreCase("com.xiaomi.smarthome")) {
                            break;
                        }
                    }
                    if (fcw != null) {
                        long currentTimeMillis = System.currentTimeMillis() - fcw.O00000o0();
                        if (0 < currentTimeMillis && currentTimeMillis <= 200) {
                            Intent intent = new Intent(CoreService.getAppContext(), NetRequestWarningActivity.class);
                            intent.addFlags(268435456);
                            intent.putExtra("item", "time:" + currentTimeMillis + "\nrequest:" + netRequest.O00000Oo + " " + netRequest.O00000oO);
                            CoreService.getAppContext().startActivity(intent);
                        }
                    }
                }
                fcw = null;
                if (fcw != null) {
                }
            }
        }
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O00000Oo(callingPid, callingUid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("error", new NetError(-3, "core service : permission deny"));
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass7 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass7 */
                fdi mNetHandle;

                public void onCancel() {
                    fdi fdi = this.mNetHandle;
                    if (fdi != null) {
                        fdi.O000000o();
                    }
                }

                public void run() {
                    fdi fdi;
                    Request request;
                    if (crypto == Crypto.RC4) {
                        AccountType O00000o0 = fdk.O000000o().O00000o0();
                        if (O00000o0 == AccountType.MI) {
                            this.mNetHandle = fdt.O000000o().O000000o(netRequest, new fdh<NetResult, NetError>() {
                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass7.AnonymousClass1 */

                                public final /* synthetic */ void onFailure(Error error) {
                                    NetError netError = (NetError) error;
                                    if (iClientCallback != null) {
                                        try {
                                            Bundle bundle = new Bundle();
                                            bundle.putParcelable("error", netError);
                                            iClientCallback.onFailure(bundle);
                                        } catch (RemoteException e) {
                                            Log.e("CoreApiStub", "fatal", e);
                                        }
                                    }
                                }

                                /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x003f */
                                public final /* synthetic */ void onSuccess(Object obj) {
                                    NetResult netResult;
                                    netResult = (NetResult) obj;
                                    if (iClientCallback != null) {
                                        try {
                                            Bundle bundle = new Bundle();
                                            bundle.putParcelable("result", netResult);
                                            iClientCallback.onSuccess(bundle);
                                        } catch (TransactionTooLargeException ) {
                                            try {
                                                Bundle bundle2 = new Bundle();
                                                MiHomeMemoryFile miHomeMemoryFile = new MiHomeMemoryFile();
                                                Parcel obtain = Parcel.obtain();
                                                obtain.writeParcelable(netResult, 0);
                                                byte[] marshall = obtain.marshall();
                                                if (gnn.O00000Oo) {
                                                    try {
                                                        Method method = miHomeMemoryFile.O00000oO;
                                                        miHomeMemoryFile.f6788O000000o = method.invoke(null, "shared-" + new Random().nextInt(100), Integer.valueOf(marshall.length));
                                                        ((ByteBuffer) miHomeMemoryFile.O00000o.invoke(miHomeMemoryFile.f6788O000000o, new Object[0])).put(marshall);
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                } else {
                                                    try {
                                                        miHomeMemoryFile.O00000Oo = new MemoryFile("shared-" + new Random().nextInt(100), marshall.length);
                                                        miHomeMemoryFile.O00000Oo.writeBytes(marshall, 0, 0, marshall.length);
                                                    } catch (IOException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                                obtain.recycle();
                                                bundle2.putParcelable("result_file", miHomeMemoryFile);
                                                iClientCallback.onSuccess(bundle2);
                                            } catch (Exception e3) {
                                                Log.e("CoreApiStub", "fatal", e3);
                                            }
                                        } catch (Exception e4) {
                                            Log.e("CoreApiStub", "fatal" + netRequest.O00000Oo + netRequest.O00000oO, e4);
                                        }
                                    }
                                }
                            });
                        } else if (O00000o0 == AccountType.WX) {
                            fdr O000000o2 = fdr.O000000o();
                            NetRequest netRequest = netRequest;
                            AnonymousClass2 r2 = new fdh<NetResult, NetError>() {
                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass7.AnonymousClass2 */

                                public final /* synthetic */ void onFailure(Error error) {
                                    NetError netError = (NetError) error;
                                    if (iClientCallback != null) {
                                        try {
                                            Bundle bundle = new Bundle();
                                            bundle.putParcelable("error", netError);
                                            iClientCallback.onFailure(bundle);
                                        } catch (RemoteException e) {
                                            Log.e("CoreApiStub", "fatal", e);
                                        }
                                    }
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    NetResult netResult = (NetResult) obj;
                                    if (iClientCallback != null) {
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("result", netResult);
                                        try {
                                            iClientCallback.onSuccess(bundle);
                                        } catch (RemoteException e) {
                                            Log.e("CoreApiStub", "fatal", e);
                                        }
                                    }
                                }
                            };
                            if (netRequest == null) {
                                r2.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
                                fdi = new fdi(null);
                            } else {
                                String O000000o3 = fdr.O000000o(netRequest);
                                if (netRequest.f6729O000000o.equals("POST")) {
                                    RequestBody O00000Oo = flj.O00000Oo(netRequest.O00000oO);
                                    Request.Builder headers = new Request.Builder().url(O000000o3).headers(flj.O000000o(netRequest.O00000o));
                                    if (O00000Oo == null) {
                                        O00000Oo = new FormBody.Builder().build();
                                    }
                                    request = headers.post(O00000Oo).build();
                                } else {
                                    request = netRequest.f6729O000000o.equals("GET") ? new Request.Builder().url(flj.O000000o(O000000o3, netRequest.O00000oO)).headers(flj.O000000o(netRequest.O00000o)).build() : null;
                                }
                                if (request == null) {
                                    r2.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
                                    fdi = new fdi(null);
                                } else {
                                    Call newCall = O000000o2.f16123O000000o.newCall(request);
                                    newCall.enqueue(new Callback(r2) {
                                        /* class _m_j.fdr.AnonymousClass2 */

                                        /* renamed from: O000000o  reason: collision with root package name */
                                        final /* synthetic */ fdh f16125O000000o;

                                        {
                                            this.f16125O000000o = r2;
                                        }

                                        public final void onFailure(Call call, IOException iOException) {
                                            fdh fdh = this.f16125O000000o;
                                            if (fdh != null) {
                                                fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), iOException == null ? "net request failure" : iOException.getMessage()));
                                            }
                                        }

                                        public final void onResponse(Call call, Response response) throws IOException {
                                            if (!response.isSuccessful()) {
                                                if (response.code() == 401) {
                                                    try {
                                                        response.body().string();
                                                    } catch (Exception unused) {
                                                    }
                                                }
                                                fdh fdh = this.f16125O000000o;
                                                if (fdh != null) {
                                                    fdh.onFailure(new NetError(response.code(), ""));
                                                    return;
                                                }
                                                return;
                                            }
                                            try {
                                                String string = response.body().string();
                                                if ((gfr.O0000OOo || gfr.O0000Oo) && !TextUtils.isEmpty(string)) {
                                                    gsy.O000000o(3, "CoreService", string);
                                                }
                                                NetResult netResult = new NetResult();
                                                netResult.O00000o0 = string;
                                                fdh fdh2 = this.f16125O000000o;
                                                if (fdh2 != null) {
                                                    fdh2.onSuccess(netResult);
                                                }
                                            } catch (Exception e) {
                                                fdh fdh3 = this.f16125O000000o;
                                                if (fdh3 != null) {
                                                    fdh3.onFailure(new NetError(ErrorCode.INVALID.getCode(), e.getMessage()));
                                                }
                                            }
                                        }
                                    });
                                    fdi = new fdi(newCall);
                                }
                            }
                            this.mNetHandle = fdi;
                        } else if (iClientCallback != null) {
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("error", new NetError(-9999, "unknown account type:".concat(String.valueOf(O00000o0))));
                                iClientCallback.onFailure(bundle);
                            } catch (RemoteException e) {
                                Log.e("CoreApiStub", "fatal", e);
                            }
                        }
                    } else if (crypto == Crypto.NONE) {
                        this.mNetHandle = fds.O000000o().O000000o(netRequest, new fdh<NetResult, NetError>() {
                            /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass7.AnonymousClass3 */

                            public final /* synthetic */ void onFailure(Error error) {
                                NetError netError = (NetError) error;
                                if (iClientCallback != null) {
                                    try {
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("error", netError);
                                        iClientCallback.onFailure(bundle);
                                    } catch (RemoteException e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                NetResult netResult = (NetResult) obj;
                                if (iClientCallback != null) {
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable("result", netResult);
                                    try {
                                        iClientCallback.onSuccess(bundle);
                                    } catch (RemoteException e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }
                        });
                    } else if (crypto == Crypto.AES) {
                        this.mNetHandle = fdp.O000000o().O000000o(netRequest, new fdh<NetResult, NetError>() {
                            /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass7.AnonymousClass4 */

                            public final /* synthetic */ void onFailure(Error error) {
                                NetError netError = (NetError) error;
                                if (iClientCallback != null) {
                                    try {
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("error", netError);
                                        iClientCallback.onFailure(bundle);
                                    } catch (RemoteException e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                NetResult netResult = (NetResult) obj;
                                if (iClientCallback != null) {
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable("result", netResult);
                                    try {
                                        iClientCallback.onSuccess(bundle);
                                    } catch (RemoteException e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }
                        });
                    } else if (crypto == Crypto.HTTPS) {
                        this.mNetHandle = fdq.O000000o().O000000o(netRequest, new fdh<NetResult, NetError>() {
                            /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass7.AnonymousClass5 */

                            public final /* synthetic */ void onFailure(Error error) {
                                NetError netError = (NetError) error;
                                if (iClientCallback != null) {
                                    try {
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("error", netError);
                                        iClientCallback.onFailure(bundle);
                                    } catch (RemoteException e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                NetResult netResult = (NetResult) obj;
                                if (iClientCallback != null) {
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable("result", netResult);
                                    try {
                                        iClientCallback.onSuccess(bundle);
                                    } catch (RemoteException e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }
                        });
                    } else if (iClientCallback != null) {
                        try {
                            Bundle bundle2 = new Bundle();
                            bundle2.putParcelable("error", new NetError(-9999, "crypto not support"));
                            iClientCallback.onFailure(bundle2);
                        } catch (RemoteException e2) {
                            Log.e("CoreApiStub", "fatal", e2);
                        }
                    }
                }
            };
            r0.execute();
            return r0;
        }
    }

    public IServerHandle sendRouterRequest(NetRequest netRequest, String str, boolean z, IClientCallback iClientCallback) throws RemoteException {
        if (ftn.O0000O0o(CoreService.getAppContext())) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-3, "core service : not support router request in Europe"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        }
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else if (!flq.O000000o().O00000Oo(callingPid, callingUid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelable("error", new NetError(-3, "core service : permission deny"));
                    iClientCallback.onFailure(bundle3);
                } catch (RemoteException e3) {
                    Log.e("CoreApiStub", "fatal", e3);
                }
            }
            return null;
        } else {
            final NetRequest netRequest2 = netRequest;
            final String str2 = str;
            final boolean z2 = z;
            final IClientCallback iClientCallback2 = iClientCallback;
            AnonymousClass8 r1 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass8 */
                fdi mNetHandle;

                public void onCancel() {
                    fdi fdi = this.mNetHandle;
                    if (fdi != null) {
                        fdi.O000000o();
                    }
                }

                public void run() {
                    this.mNetHandle = fdo.O000000o().O000000o(netRequest2, str2, z2, new fdh<NetResult, NetError>() {
                        /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass8.AnonymousClass1 */

                        public final /* synthetic */ void onFailure(Error error) {
                            NetError netError = (NetError) error;
                            if (iClientCallback2 != null) {
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable("error", netError);
                                    iClientCallback2.onFailure(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            NetResult netResult = (NetResult) obj;
                            if (iClientCallback2 != null) {
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("result", netResult);
                                try {
                                    iClientCallback2.onSuccess(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }
                    });
                }
            };
            r1.execute();
            return r1;
        }
    }

    public IServerHandle sendMiRechargeRequest(final NetRequest netRequest, final IClientCallback iClientCallback) throws RemoteException {
        if (ftn.O0000O0o(CoreService.getAppContext())) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-3, "core service : not support mi recharge request in Europe"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        }
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else if (!flq.O000000o().O00000Oo(callingPid, callingUid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelable("error", new NetError(-3, "core service : permission deny"));
                    iClientCallback.onFailure(bundle3);
                } catch (RemoteException e3) {
                    Log.e("CoreApiStub", "fatal", e3);
                }
            }
            return null;
        } else {
            AnonymousClass9 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass9 */
                fdi mNetHandle;

                public void onCancel() {
                    fdi fdi = this.mNetHandle;
                    if (fdi != null) {
                        fdi.O000000o();
                    }
                }

                public void run() {
                    fdi fdi;
                    Request request;
                    fdm O000000o2 = fdm.O000000o();
                    NetRequest netRequest = netRequest;
                    AnonymousClass1 r3 = new fdh<NetResult, NetError>() {
                        /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass9.AnonymousClass1 */

                        public final /* synthetic */ void onFailure(Error error) {
                            NetError netError = (NetError) error;
                            if (iClientCallback != null) {
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable("error", netError);
                                    iClientCallback.onFailure(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            NetResult netResult = (NetResult) obj;
                            if (iClientCallback != null) {
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("result", netResult);
                                try {
                                    iClientCallback.onSuccess(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }
                    };
                    if (netRequest == null) {
                        r3.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
                        fdi = new fdi(null);
                    } else if (fju.O000000o().O00000oO()) {
                        r3.onFailure(new NetError(ErrorCode.INVALID.getCode(), "international not support mirecharge-api"));
                        fdi = new fdi(null);
                    } else {
                        String O000000o3 = fdm.O000000o(netRequest);
                        if (!O000000o2.O00000Oo()) {
                            if (!fcn.O000000o().O0000OOo()) {
                                r3.onFailure(new NetError(ErrorCode.INVALID.getCode(), "not loggedin"));
                                fdi = new fdi(null);
                            } else {
                                String O00000Oo = fcn.O000000o().O00000Oo();
                                O000000o2.O00000o0 = fcn.O000000o().O00000Oo("mipaycom");
                                if (TextUtils.isEmpty(O00000Oo) || O000000o2.O00000o0 == null) {
                                    O000000o2.O00000o0();
                                    r3.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
                                    fdi = new fdi(null);
                                } else {
                                    gsr.O000000o(O000000o2.O00000Oo);
                                    gsr.O000000o(O000000o2.O00000Oo, "https://web.recharge.mipay.com", "userId", O00000Oo, "web.recharge.pay.xiaomi.com", "/");
                                    gsr.O000000o(O000000o2.O00000Oo, "https://web.recharge.mipay.com", "serviceToken", O000000o2.O00000o0.O00000o0, O000000o2.O00000o0.O00000oo, "/");
                                    O000000o2.O000000o(true);
                                }
                            }
                        }
                        if (netRequest.f6729O000000o.equals("POST")) {
                            Request.Builder url = new Request.Builder().url(O000000o3);
                            if (netRequest.O00000o != null) {
                                url.headers(flj.O000000o(netRequest.O00000o));
                            }
                            if (netRequest.O00000oO != null) {
                                url.post(flj.O00000Oo(netRequest.O00000oO));
                            }
                            request = url.build();
                        } else if (netRequest.f6729O000000o.equals("GET")) {
                            Request.Builder builder = new Request.Builder();
                            if (netRequest.O00000o != null) {
                                builder.headers(flj.O000000o(netRequest.O00000o));
                            }
                            if (netRequest.O00000oO != null) {
                                builder.url(flj.O000000o(O000000o3, netRequest.O00000oO));
                            }
                            request = builder.build();
                        } else {
                            request = null;
                        }
                        if (request == null) {
                            r3.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
                            fdi = new fdi(null);
                        } else {
                            Call newCall = O000000o2.f16108O000000o.newCall(request);
                            newCall.enqueue(new Callback(r3) {
                                /* class _m_j.fdm.AnonymousClass2 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ fdh f16110O000000o;

                                {
                                    this.f16110O000000o = r2;
                                }

                                public final void onFailure(Call call, IOException iOException) {
                                    fdh fdh = this.f16110O000000o;
                                    if (fdh != null) {
                                        fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), iOException == null ? "net request failure" : iOException.getMessage()));
                                    }
                                }

                                public final void onResponse(Call call, Response response) throws IOException {
                                    if (!response.isSuccessful()) {
                                        if (response.code() == 401) {
                                            fdm.this.O00000o0();
                                        }
                                        fdh fdh = this.f16110O000000o;
                                        if (fdh != null) {
                                            fdh.onFailure(new NetError(response.code(), ""));
                                            return;
                                        }
                                        return;
                                    }
                                    try {
                                        String string = response.body().string();
                                        NetResult netResult = new NetResult();
                                        netResult.O00000o0 = string;
                                        fdh fdh2 = this.f16110O000000o;
                                        if (fdh2 != null) {
                                            fdh2.onSuccess(netResult);
                                        }
                                    } catch (Exception e) {
                                        fdh fdh3 = this.f16110O000000o;
                                        if (fdh3 != null) {
                                            fdh3.onFailure(new NetError(ErrorCode.INVALID.getCode(), e.getMessage()));
                                        }
                                    }
                                }
                            });
                            fdi = new fdi(newCall);
                        }
                    }
                    this.mNetHandle = fdi;
                }
            };
            r0.execute();
            return r0;
        }
    }

    public IServerHandle sendMiShopRequest(final NetRequest netRequest, final IClientCallback iClientCallback) throws RemoteException {
        if (ftn.O0000O0o(CoreService.getAppContext())) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-3, "core service : not support mishop request in Europe"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        }
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else if (!flq.O000000o().O00000Oo(callingPid, callingUid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelable("error", new NetError(-3, "core service : permission deny"));
                    iClientCallback.onFailure(bundle3);
                } catch (RemoteException e3) {
                    Log.e("CoreApiStub", "fatal", e3);
                }
            }
            return null;
        } else {
            AnonymousClass10 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass10 */
                fdi mNetHandle;

                public void onCancel() {
                    fdi fdi = this.mNetHandle;
                    if (fdi != null) {
                        fdi.O000000o();
                    }
                }

                public void run() {
                    fdi fdi;
                    Request request;
                    fdn O000000o2 = fdn.O000000o();
                    NetRequest netRequest = netRequest;
                    AnonymousClass1 r3 = new fdh<NetResult, NetError>() {
                        /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass10.AnonymousClass1 */

                        public final /* synthetic */ void onFailure(Error error) {
                            NetError netError = (NetError) error;
                            if (iClientCallback != null) {
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable("error", netError);
                                    iClientCallback.onFailure(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            NetResult netResult = (NetResult) obj;
                            if (iClientCallback != null) {
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("result", netResult);
                                try {
                                    iClientCallback.onSuccess(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }
                    };
                    if (netRequest == null) {
                        r3.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
                        fdi = new fdi(null);
                    } else if (fju.O000000o().O00000oO()) {
                        r3.onFailure(new NetError(ErrorCode.INVALID.getCode(), "international not support mirecharge-api"));
                        fdi = new fdi(null);
                    } else {
                        String O000000o3 = fdn.O000000o(netRequest);
                        if (!O000000o2.O00000Oo()) {
                            if (!fcn.O000000o().O0000OOo()) {
                                r3.onFailure(new NetError(ErrorCode.INVALID.getCode(), "not loggedin"));
                                fdi = new fdi(null);
                            } else {
                                String O00000Oo = fcn.O000000o().O00000Oo();
                                O000000o2.O00000o0 = fcn.O000000o().O00000Oo("xiaomiio");
                                if (TextUtils.isEmpty(O00000Oo) || O000000o2.O00000o0 == null) {
                                    O000000o2.O00000o0();
                                    r3.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
                                    fdi = new fdi(null);
                                } else {
                                    gsr.O000000o(O000000o2.O00000Oo);
                                    gsr.O000000o(O000000o2.O00000Oo, "https://shopapi.io.mi.com", "userId", O00000Oo, ".io.mi.com", "/");
                                    gsr.O000000o(O000000o2.O00000Oo, "https://shopapi.io.mi.com", "serviceToken", O000000o2.O00000o0.O00000o0, O000000o2.O00000o0.O00000oo, "/");
                                    O000000o2.O000000o(true);
                                }
                            }
                        }
                        if (netRequest.f6729O000000o.equals("POST")) {
                            Request.Builder url = new Request.Builder().url(O000000o3);
                            if (netRequest.O00000o != null) {
                                url.headers(flj.O000000o(netRequest.O00000o));
                            }
                            if (netRequest.O00000oO != null) {
                                url.post(flj.O00000Oo(netRequest.O00000oO));
                            }
                            request = url.build();
                        } else if (netRequest.f6729O000000o.equals("GET")) {
                            Request.Builder builder = new Request.Builder();
                            if (netRequest.O00000o != null) {
                                builder.headers(flj.O000000o(netRequest.O00000o));
                            }
                            if (netRequest.O00000oO != null) {
                                builder.url(flj.O000000o(O000000o3, netRequest.O00000oO));
                            }
                            request = builder.build();
                        } else {
                            request = null;
                        }
                        if (request == null) {
                            r3.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
                            fdi = new fdi(null);
                        } else {
                            Call newCall = O000000o2.f16111O000000o.newCall(request);
                            newCall.enqueue(new Callback(r3) {
                                /* class _m_j.fdn.AnonymousClass2 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ fdh f16113O000000o;

                                {
                                    this.f16113O000000o = r2;
                                }

                                public final void onFailure(Call call, IOException iOException) {
                                    fdh fdh = this.f16113O000000o;
                                    if (fdh != null) {
                                        fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), iOException == null ? "net request failure" : iOException.getMessage()));
                                    }
                                }

                                public final void onResponse(Call call, Response response) throws IOException {
                                    if (!response.isSuccessful()) {
                                        if (response.code() == 401) {
                                            fdn.this.O00000o0();
                                        }
                                        fdh fdh = this.f16113O000000o;
                                        if (fdh != null) {
                                            fdh.onFailure(new NetError(response.code(), ""));
                                            return;
                                        }
                                        return;
                                    }
                                    try {
                                        String string = response.body().string();
                                        NetResult netResult = new NetResult();
                                        netResult.O00000o0 = string;
                                        fdh fdh2 = this.f16113O000000o;
                                        if (fdh2 != null) {
                                            fdh2.onSuccess(netResult);
                                        }
                                    } catch (Exception e) {
                                        fdh fdh3 = this.f16113O000000o;
                                        if (fdh3 != null) {
                                            fdh3.onFailure(new NetError(ErrorCode.INVALID.getCode(), e.getMessage()));
                                        }
                                    }
                                }
                            });
                            fdi = new fdi(newCall);
                        }
                    }
                    this.mNetHandle = fdi;
                }
            };
            r0.execute();
            return r0;
        }
    }

    public IServerHandle scanDeviceList(final ScanType scanType, final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O00000Oo(callingPid, callingUid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("error", new NetError(-3, "core service : permission deny"));
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass11 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass11 */

                public void onCancel() {
                }

                public void run() {
                    fjd.O000000o().O000000o(scanType, iClientCallback);
                }
            };
            r0.execute();
            return r0;
        }
    }

    public IServerHandle batchRpcAsync(final List<BatchRpcParam> list, final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O00000Oo(callingPid, callingUid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("error", new NetError(-3, "core service : permission deny"));
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass12 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass12 */
                fjc mDeviceHandle;

                public void onCancel() {
                    fjc fjc = this.mDeviceHandle;
                    if (fjc != null) {
                        fjc.O000000o();
                    }
                }

                public void run() {
                    AnonymousClass1 r0 = new fjo<String>() {
                        /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass12.AnonymousClass1 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            String str = (String) obj;
                            if (iClientCallback != null) {
                                Bundle bundle = new Bundle();
                                bundle.putString("result", str);
                                try {
                                    iClientCallback.onSuccess(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }

                        public final void O000000o(int i) {
                            if (iClientCallback != null) {
                                try {
                                    Error error = new Error(i, "unknown error");
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable("error", error);
                                    iClientCallback.onFailure(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }

                        public final void O000000o(int i, Object obj) {
                            if (iClientCallback != null) {
                                try {
                                    Error error = new Error(i, "unknown error");
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable("error", error);
                                    iClientCallback.onFailure(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }
                    };
                    fjp fjp = new fjp();
                    List list = list;
                    fjp.O00000o = System.currentTimeMillis();
                    fjc fjc = null;
                    if (list == null || list.size() == 0) {
                        r0.O000000o(0, "empty request");
                    } else {
                        ArrayList arrayList = null;
                        ArrayList arrayList2 = null;
                        for (int i = 0; i < list.size(); i++) {
                            BatchRpcParam batchRpcParam = (BatchRpcParam) list.get(i);
                            Device O000000o2 = fjd.O000000o().O000000o(batchRpcParam.f6888O000000o);
                            if (O000000o2 != null) {
                                if (gog.O000000o(CommonApplication.getAppContext()) == null || !O000000o2.isLocal()) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    if (!TextUtils.isEmpty(batchRpcParam.f6888O000000o)) {
                                        if (batchRpcParam.f6888O000000o.startsWith("mitv.")) {
                                            batchRpcParam.f6888O000000o = URLEncoder.encode(batchRpcParam.f6888O000000o);
                                        }
                                        arrayList.add(batchRpcParam);
                                    }
                                } else {
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList();
                                    }
                                    arrayList2.add(batchRpcParam);
                                }
                                fjp.O00000Oo.put(batchRpcParam.f6888O000000o, batchRpcParam.f6888O000000o);
                            }
                        }
                        fjp.O00000o0 = r0;
                        if (!(arrayList == null || arrayList.size() == 0)) {
                            fjq O000000o3 = fjq.O000000o();
                            String O00000Oo = fjp.O00000Oo(arrayList);
                            fjp.AnonymousClass2 r3 = new fjo<String>(arrayList) {
                                /* class _m_j.fjp.AnonymousClass2 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ List f16486O000000o;

                                {
                                    this.f16486O000000o = r2;
                                }

                                public final /* synthetic */ void O000000o(Object obj) {
                                    String str = (String) obj;
                                    gsy.O000000o(3, "BatchRpcApi", "batchRpcAsync response:".concat(String.valueOf(str)));
                                    fjp.this.O000000o(this.f16486O000000o, str);
                                }

                                public final void O000000o(int i) {
                                    gsy.O000000o(6, "BatchRpcApi", "batchrpc fail response:".concat(String.valueOf(i)));
                                    for (BatchRpcParam batchRpcParam : this.f16486O000000o) {
                                        fjp.this.f16484O000000o.put(batchRpcParam.f6888O000000o, Boolean.FALSE);
                                        fjp.this.O00000Oo.remove(batchRpcParam.f6888O000000o);
                                    }
                                    fjp.this.O000000o();
                                }

                                public final void O000000o(int i, Object obj) {
                                    StringBuilder sb = new StringBuilder("batchrpc fail response:");
                                    sb.append(i);
                                    sb.append(", msg=");
                                    sb.append(obj == null ? "" : obj.toString());
                                    gsy.O000000o(6, "BatchRpcApi", sb.toString());
                                    for (BatchRpcParam batchRpcParam : this.f16486O000000o) {
                                        fjp.this.f16484O000000o.put(batchRpcParam.f6888O000000o, Boolean.FALSE);
                                        fjp.this.O00000Oo.remove(batchRpcParam.f6888O000000o);
                                    }
                                    fjp.this.O000000o();
                                }
                            };
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(new KeyValuePair("data", O00000Oo));
                            NetRequest O000000o4 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/batchrpc").O000000o(arrayList3).O000000o();
                            if (fdk.O000000o().O00000o0() == AccountType.MI) {
                                fjc = new fjc(fdt.O000000o().O000000o(O000000o4, new fdh<NetResult, NetError>(r3) {
                                    /* class _m_j.fjq.AnonymousClass1 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ fjo f16488O000000o;

                                    {
                                        this.f16488O000000o = r2;
                                    }

                                    public final /* synthetic */ void onFailure(Error error) {
                                        NetError netError = (NetError) error;
                                        fjo fjo = this.f16488O000000o;
                                        if (fjo != null) {
                                            fjo.O000000o(netError.f6718O000000o, netError.O00000Oo);
                                        }
                                    }

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        NetResult netResult = (NetResult) obj;
                                        fjo fjo = this.f16488O000000o;
                                        if (fjo != null) {
                                            fjo.O000000o(netResult.O00000o0);
                                        }
                                    }
                                }));
                            } else {
                                r3.O000000o(-9999, "Account type not supported!");
                            }
                        }
                        fjp.O000000o(arrayList2);
                    }
                    this.mDeviceHandle = fjc;
                }
            };
            r0.execute();
            return r0;
        }
    }

    public boolean isUpgradingFirmware(String str) {
        if (ffq.O000000o().O00000Oo()) {
            return true;
        }
        Map<String, Boolean> map = this.statusMap;
        Boolean bool = map.get(str + "#KEY.IS_UPGRADING_FIRMWARE");
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public Bundle buildRpcErrorBundle(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("error", new NetError(i, str));
        return bundle;
    }

    public int getPluginRecordVersion(String str) {
        PluginPackageInfo O00000Oo = fkl.O000000o().O00000Oo(str);
        if (O00000Oo != null) {
            return O00000Oo.O00000oO();
        }
        return -1;
    }

    public String getAccountTypeStr() {
        try {
            return String.valueOf(fdk.O000000o().O00000o0());
        } catch (Exception unused) {
            return "";
        }
    }

    public IServerHandle rpcAsync(String str, String str2, String str3, IClientCallback iClientCallback) throws RemoteException {
        try {
            if (!fjt.O000000o(str, str2, str3)) {
                if (iClientCallback != null) {
                    try {
                        iClientCallback.onFailure(buildRpcErrorBundle(-97, "core service : two same rpc requests can not be send in 1 second!"));
                    } catch (RemoteException e) {
                        Log.e("CoreApiStub", "fatal", e);
                    }
                }
                return null;
            }
            int callingPid = getCallingPid();
            int callingUid = getCallingUid();
            if (!fcy.O000000o().O000000o(callingPid)) {
                if (iClientCallback != null) {
                    try {
                        iClientCallback.onFailure(buildRpcErrorBundle(-2, "core service : process not register"));
                    } catch (RemoteException e2) {
                        Log.e("CoreApiStub", "fatal", e2);
                    }
                }
                return null;
            } else if (!flq.O000000o().O00000Oo(callingPid, callingUid)) {
                if (iClientCallback != null) {
                    try {
                        iClientCallback.onFailure(buildRpcErrorBundle(-3, "core service : permission deny"));
                    } catch (RemoteException e3) {
                        Log.e("CoreApiStub", "fatal", e3);
                    }
                }
                return null;
            } else {
                final String str4 = str;
                final IClientCallback iClientCallback2 = iClientCallback;
                final String str5 = str3;
                final String str6 = str2;
                AnonymousClass13 r4 = new CoreAsyncTask() {
                    /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass13 */
                    fjc mDeviceHandle;

                    public void onCancel() {
                        fjc fjc = this.mDeviceHandle;
                        if (fjc != null) {
                            fjc.O000000o();
                        }
                    }

                    public void run() {
                        Device O000000o2 = fjd.O000000o().O000000o(str4);
                        if (O000000o2 != null) {
                            final long currentTimeMillis = System.currentTimeMillis();
                            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                            final Device device = O000000o2;
                            final AtomicBoolean atomicBoolean2 = atomicBoolean;
                            AnonymousClass1 r2 = new fjo<String>() {
                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass13.AnonymousClass1 */

                                public final /* synthetic */ void O000000o(Object obj) {
                                    String str = (String) obj;
                                    if (iClientCallback2 != null) {
                                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                                        Bundle bundle = new Bundle();
                                        bundle.putString("result", str);
                                        try {
                                            int O00000Oo2 = fjt.O00000Oo(str);
                                            ErrorCode valueof = ErrorCode.valueof(O00000Oo2);
                                            iClientCallback2.onSuccess(bundle);
                                            if (valueof != ErrorCode.SUCCESS) {
                                                if (device != null) {
                                                    if (!device.isOnline() || fjt.O00000oO(device.getDid())) {
                                                        gsy.O00000o0(LogType.DEVICE_CONTROL, "rpcAsync", "RPC: onSuccess,device is offline ,but has error,not report");
                                                        return;
                                                    }
                                                }
                                                if (CoreApiStub.this.isUpgradingFirmware(str4)) {
                                                    gsy.O00000o0(LogType.DEVICE_CONTROL, "rpcAsync", "RPC: onSuccess, is upgrading firmware,not report");
                                                    return;
                                                } else if (O00000Oo2 == -3 && device != null) {
                                                    fjt.O00000o0(device.getDid());
                                                }
                                            }
                                            if (!(O00000Oo2 == -3 || device == null)) {
                                                fjt.O00000o(device.getDid());
                                            }
                                            gsy.O000000o(LogType.DEVICE_CONTROL, "RPC", String.format("%s\t%s\t%s\t%s\t%s", Long.valueOf(currentTimeMillis), device.getModel(), str4, str5, str));
                                            if (atomicBoolean2.get()) {
                                                hxi.O0000Oo.O000000o(currentTimeMillis, device.getModel(), str4, str, str5, fjt.O000000o(O00000Oo2), CoreApiStub.this.getPluginRecordVersion(device.getModel()), CoreApiStub.this.getAccountTypeStr());
                                                return;
                                            }
                                            hxi.O0000Oo.O000000o(currentTimeMillis, device.getModel(), O00000Oo2, str4, str, str5, CoreApiStub.this.getPluginRecordVersion(device.getModel()));
                                        } catch (Exception e) {
                                            Log.e("CoreApiStub", "fatal", e);
                                        }
                                    }
                                }

                                public final void O000000o(int i) {
                                    gsy.O000000o(6, "RPC", "error: " + i + "   errorInfo: unknown error");
                                    if (iClientCallback2 != null) {
                                        try {
                                            long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                                            iClientCallback2.onFailure(CoreApiStub.this.buildRpcErrorBundle(i, "unknown error"));
                                            if (device != null) {
                                                if (!device.isOnline()) {
                                                    gsy.O00000o0(LogType.DEVICE_CONTROL, "rpcAsync", "RPC: on failure ,device is offline but has error,not report");
                                                    return;
                                                }
                                            }
                                            if (CoreApiStub.this.isUpgradingFirmware(str4)) {
                                                gsy.O00000o0(LogType.DEVICE_CONTROL, "rpcAsync", "RPC: onFailure, is upgrading firmware,not report");
                                            } else if (atomicBoolean2.get()) {
                                                hxi.O0000Oo.O000000o(currentTimeMillis, device.getModel(), str4, null, str5, fjt.O000000o(i), CoreApiStub.this.getPluginRecordVersion(device.getModel()), CoreApiStub.this.getAccountTypeStr());
                                            } else {
                                                hxi.O0000Oo.O000000o(currentTimeMillis, device.getModel(), i, str4, (String) null, str5, CoreApiStub.this.getPluginRecordVersion(device.getModel()));
                                            }
                                        } catch (Exception e) {
                                            Log.e("CoreApiStub", "fatal", e);
                                        }
                                    }
                                }

                                public final void O000000o(int i, Object obj) {
                                    String obj2 = obj == null ? "unknown error" : obj.toString();
                                    gsy.O000000o(6, "RPC", "error: " + i + "   errorInfo: " + obj2);
                                    if (iClientCallback2 != null) {
                                        try {
                                            long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                                            iClientCallback2.onFailure(CoreApiStub.this.buildRpcErrorBundle(i, obj2));
                                            Device O000000o2 = fjd.O000000o().O000000o(str4);
                                            if (O000000o2 != null && !O000000o2.isOnline()) {
                                                return;
                                            }
                                            if (CoreApiStub.this.isUpgradingFirmware(str4)) {
                                                gsy.O00000o0(LogType.DEVICE_CONTROL, "rpcAsync", "RPC: onFailure2, is upgrading firmware,not report");
                                                return;
                                            }
                                            int O000000o3 = fjt.O000000o(obj2);
                                            gsy.O000000o(6, "RPC", "rpc specific errorcode = ".concat(String.valueOf(O000000o3)));
                                            if (atomicBoolean2.get()) {
                                                hxi.O0000Oo.O000000o(currentTimeMillis, device.getModel(), str4, obj2, str5, fjt.O000000o(O000000o3), CoreApiStub.this.getPluginRecordVersion(device.getModel()), CoreApiStub.this.getAccountTypeStr());
                                            } else {
                                                hxi.O0000Oo.O000000o(currentTimeMillis, device.getModel(), O000000o3, str4, obj2, str5, CoreApiStub.this.getPluginRecordVersion(device.getModel()));
                                            }
                                        } catch (RemoteException e) {
                                            Log.e("CoreApiStub", "fatal", e);
                                        }
                                    }
                                }
                            };
                            if (str4.startsWith("mitv.")) {
                                this.mDeviceHandle = fjq.O000000o().O00000Oo(URLEncoder.encode(str4), str5, r2);
                            } else if (gog.O000000o(CoreService.getAppContext()) == null || !O000000o2.isLocal()) {
                                gsy.O00000Oo("RPC", "rpc is from cloud...");
                                this.mDeviceHandle = fjq.O000000o().O000000o(str4, str5, r2);
                            } else {
                                atomicBoolean.set(false);
                                gsy.O00000Oo("RPC", "rpc is from native...");
                                fjh.O000000o().O000000o(O000000o2.getLocalIP(), str4, str6, str5, r2);
                            }
                        } else if (iClientCallback2 != null) {
                            try {
                                iClientCallback2.onFailure(CoreApiStub.this.buildRpcErrorBundle(-9999, "Device does not exist!"));
                            } catch (Exception e) {
                                Log.e("CoreApiStub", "fatal", e);
                            }
                        }
                    }
                };
                r4.execute();
                return r4;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public IServerHandle rpcAsyncToLocal(String str, String str2, String str3, IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O00000Oo(callingPid, callingUid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("error", new NetError(-3, "core service : permission deny"));
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            final String str4 = str;
            final IClientCallback iClientCallback2 = iClientCallback;
            final String str5 = str3;
            final String str6 = str2;
            AnonymousClass14 r1 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass14 */
                fjc mDeviceHandle;

                public void onCancel() {
                    fjc fjc = this.mDeviceHandle;
                    if (fjc != null) {
                        fjc.O000000o();
                    }
                }

                public void run() {
                    final Device O000000o2 = fjd.O000000o().O000000o(str4);
                    if (O000000o2 != null) {
                        final long currentTimeMillis = System.currentTimeMillis();
                        AnonymousClass1 r9 = new fjo<String>() {
                            /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass14.AnonymousClass1 */

                            public final /* synthetic */ void O000000o(Object obj) {
                                String str;
                                String str2 = (String) obj;
                                if (iClientCallback2 != null) {
                                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("result", str2);
                                    try {
                                        iClientCallback2.onSuccess(bundle);
                                        int O00000Oo2 = fjt.O00000Oo(str2);
                                        if (ErrorCode.valueof(O00000Oo2) != ErrorCode.SUCCESS) {
                                            str = str5;
                                        } else {
                                            str = "";
                                        }
                                        hxi.O0000Oo.O000000o(currentTimeMillis, O000000o2.getModel(), O00000Oo2, str4, str2, str, CoreApiStub.this.getPluginRecordVersion(O000000o2.getModel()));
                                    } catch (Exception e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }

                            public final void O000000o(int i) {
                                gsy.O000000o(6, "RPC", "error: " + i + "   errorInfo: unknown error");
                                if (iClientCallback2 != null) {
                                    try {
                                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                                        Error error = new Error(i, "unknown error");
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("error", error);
                                        iClientCallback2.onFailure(bundle);
                                        hxi.O0000Oo.O000000o(currentTimeMillis, O000000o2.getModel(), i, str4, (String) null, str5, CoreApiStub.this.getPluginRecordVersion(O000000o2.getModel()));
                                    } catch (Exception e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }

                            public final void O000000o(int i, Object obj) {
                                String obj2 = obj == null ? "unknown error" : obj.toString();
                                gsy.O000000o(6, "RPC", "error: " + i + "   errorInfo: " + obj2);
                                if (iClientCallback2 != null) {
                                    try {
                                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                                        Error error = new Error(i, obj2);
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("error", error);
                                        iClientCallback2.onFailure(bundle);
                                        int O000000o2 = fjt.O000000o(obj2);
                                        gsy.O000000o(6, "RPC", "rpc specific errorcode = ".concat(String.valueOf(O000000o2)));
                                        hxi.O0000Oo.O000000o(currentTimeMillis, O000000o2.getModel(), O000000o2, str4, obj2, str5, CoreApiStub.this.getPluginRecordVersion(O000000o2.getModel()));
                                    } catch (RemoteException e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }
                        };
                        if (str4.startsWith("mitv.")) {
                            this.mDeviceHandle = fjq.O000000o().O00000Oo(URLEncoder.encode(str4), str5, r9);
                        } else if (gog.O000000o(CoreService.getAppContext()) == null || !O000000o2.isLocal()) {
                            r9.O000000o(-9999, "current phone's wifi cannot use or current device is not local device,  isLocal: " + O000000o2.isLocal());
                        } else {
                            gsy.O00000Oo("RPC", "rpc is from native...");
                            fjh.O000000o().O000000o(O000000o2.getLocalIP(), str4, str6, str5, r9);
                        }
                    } else if (iClientCallback2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("error", new NetError(-9999, "Device does not exist!"));
                        try {
                            iClientCallback2.onFailure(bundle);
                        } catch (Exception e) {
                            Log.e("CoreApiStub", "fatal", e);
                        }
                    }
                }
            };
            r1.execute();
            return r1;
        }
    }

    public IServerHandle rpcAsyncToCloud(String str, String str2, String str3, IClientCallback iClientCallback) throws RemoteException {
        if (!fjt.O000000o(str, str2, str3)) {
            if (iClientCallback != null) {
                try {
                    iClientCallback.onFailure(buildRpcErrorBundle(-97, "core service : two same rpc requests can not be send in 1 second!"));
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        }
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else if (!flq.O000000o().O00000Oo(callingPid, callingUid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("error", new NetError(-3, "core service : permission deny"));
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e3) {
                    Log.e("CoreApiStub", "fatal", e3);
                }
            }
            return null;
        } else {
            final String str4 = str;
            final IClientCallback iClientCallback2 = iClientCallback;
            final String str5 = str2;
            final String str6 = str3;
            AnonymousClass15 r4 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass15 */
                fjc mDeviceHandle;

                public void onCancel() {
                    fjc fjc = this.mDeviceHandle;
                    if (fjc != null) {
                        fjc.O000000o();
                    }
                }

                public void run() {
                    if (fjd.O000000o().O000000o(str4) != null) {
                        AnonymousClass1 r0 = new fjo<String>() {
                            /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass15.AnonymousClass1 */

                            public final /* synthetic */ void O000000o(Object obj) {
                                String str = (String) obj;
                                if (iClientCallback2 != null) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("result", str);
                                    try {
                                        iClientCallback2.onSuccess(bundle);
                                    } catch (RemoteException e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }

                            public final void O000000o(int i) {
                                if (iClientCallback2 != null) {
                                    try {
                                        Error error = new Error(i, "unknown error");
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("error", error);
                                        iClientCallback2.onFailure(bundle);
                                    } catch (RemoteException e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }

                            public final void O000000o(int i, Object obj) {
                                if (iClientCallback2 != null) {
                                    try {
                                        Error error = new Error(i, "unknown error");
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("error", error);
                                        iClientCallback2.onFailure(bundle);
                                    } catch (RemoteException e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }
                        };
                        if (str4.startsWith("mitv.")) {
                            this.mDeviceHandle = fjq.O000000o().O00000Oo(URLEncoder.encode(str4), str6, r0);
                            return;
                        }
                        this.mDeviceHandle = fjq.O000000o().O000000o(str4, str6, r0);
                    } else if (iClientCallback2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("error", new NetError(-9999, "Device does not exist!"));
                        try {
                            iClientCallback2.onFailure(bundle);
                        } catch (RemoteException e) {
                            Log.e("CoreApiStub", "fatal", e);
                        }
                    }
                }
            };
            r4.execute();
            return r4;
        }
    }

    public void localPing(final String str, final IClientCallback iClientCallback) {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
        } else if (flq.O000000o().O00000Oo(callingPid, callingUid)) {
            new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass16 */
                fdi mNetHandle;

                public void onCancel() {
                    fdi fdi = this.mNetHandle;
                    if (fdi != null) {
                        fdi.O000000o();
                    }
                }

                public void run() {
                    final Device O000000o2 = fjd.O000000o().O000000o(str);
                    if (O000000o2 != null) {
                        MiioLocalAPI.O000000o(O000000o2.getLocalIP(), new dxe() {
                            /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass16.AnonymousClass1 */

                            public final void onResponse(String str) {
                                try {
                                    int optInt = new JSONObject(str).optInt("code");
                                    if (optInt == MiioLocalErrorCode.SUCCESS.getCode() || optInt == MiioLocalErrorCode.PERMISSION_DENIED.getCode()) {
                                        O000000o2.setLocation(Device.Location.LOCAL);
                                        if (iClientCallback != null) {
                                            Bundle bundle = new Bundle();
                                            bundle.putString("result", "ping local sucess");
                                            try {
                                                iClientCallback.onSuccess(bundle);
                                                return;
                                            } catch (RemoteException e) {
                                                Log.e("CoreApiStub", "fatal", e);
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                if (iClientCallback != null) {
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putParcelable("error", new NetError(-9999, "ping time out"));
                                    try {
                                        iClientCallback.onFailure(bundle2);
                                    } catch (RemoteException e3) {
                                        Log.e("CoreApiStub", "fatal", e3);
                                    }
                                }
                            }
                        }, 1);
                    } else if (iClientCallback != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("error", new NetError(-9999, "Device does not exist!"));
                        try {
                            iClientCallback.onFailure(bundle);
                        } catch (RemoteException e) {
                            Log.e("CoreApiStub", "fatal", e);
                        }
                    }
                }
            }.execute();
        } else if (iClientCallback != null) {
            try {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("error", new NetError(-3, "core service : permission deny"));
                iClientCallback.onFailure(bundle2);
            } catch (RemoteException e2) {
                Log.e("CoreApiStub", "fatal", e2);
            }
        }
    }

    public void localPingWithParams(String str, int i, int i2, IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
        } else if (flq.O000000o().O00000Oo(callingPid, callingUid)) {
            final String str2 = str;
            final IClientCallback iClientCallback2 = iClientCallback;
            final int i3 = i;
            final int i4 = i2;
            new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass17 */
                fdi mNetHandle;

                public void onCancel() {
                    fdi fdi = this.mNetHandle;
                    if (fdi != null) {
                        fdi.O000000o();
                    }
                }

                public void run() {
                    final Device O000000o2 = fjd.O000000o().O000000o(str2);
                    if (O000000o2 != null) {
                        MiioLocalAPI.O000000o(O000000o2.getLocalIP(), new dxe() {
                            /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass17.AnonymousClass1 */

                            public final void onResponse(String str) {
                                try {
                                    int optInt = new JSONObject(str).optInt("code");
                                    if (optInt == MiioLocalErrorCode.SUCCESS.getCode() || optInt == MiioLocalErrorCode.PERMISSION_DENIED.getCode()) {
                                        O000000o2.setLocation(Device.Location.LOCAL);
                                        if (iClientCallback2 != null) {
                                            Bundle bundle = new Bundle();
                                            bundle.putString("result", "ping local sucess");
                                            try {
                                                iClientCallback2.onSuccess(bundle);
                                                return;
                                            } catch (RemoteException e) {
                                                Log.e("CoreApiStub", "fatal", e);
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                if (iClientCallback2 != null) {
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putParcelable("error", new NetError(-9999, "ping time out"));
                                    try {
                                        iClientCallback2.onFailure(bundle2);
                                    } catch (RemoteException e3) {
                                        Log.e("CoreApiStub", "fatal", e3);
                                    }
                                }
                            }
                        }, i3, i4);
                    } else if (iClientCallback2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("error", new NetError(-9999, "Device does not exist!"));
                        try {
                            iClientCallback2.onFailure(bundle);
                        } catch (RemoteException e) {
                            Log.e("CoreApiStub", "fatal", e);
                        }
                    }
                }
            }.execute();
        } else if (iClientCallback != null) {
            try {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("error", new NetError(-3, "core service : permission deny"));
                iClientCallback.onFailure(bundle2);
            } catch (RemoteException e2) {
                Log.e("CoreApiStub", "fatal", e2);
            }
        }
    }

    public IServerHandle renameDevice(final String str, final String str2, final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O00000Oo(callingPid, callingUid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("error", new NetError(-3, "core service : permission deny"));
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass18 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass18 */
                fdi mNetHandle;

                public void onCancel() {
                    fdi fdi = this.mNetHandle;
                    if (fdi != null) {
                        fdi.O000000o();
                    }
                }

                public void run() {
                    fjd O000000o2 = fjd.O000000o();
                    String str = str;
                    String str2 = str2;
                    IClientCallback iClientCallback = iClientCallback;
                    fjq.O000000o();
                    this.mNetHandle = fjq.O000000o(str, str2, new fdh<NetResult, NetError>(str, str2, iClientCallback) {
                        /* class _m_j.fjd.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ String f16455O000000o;
                        final /* synthetic */ String O00000Oo;
                        final /* synthetic */ IClientCallback O00000o0;

                        {
                            this.f16455O000000o = r2;
                            this.O00000Oo = r3;
                            this.O00000o0 = r4;
                        }

                        public final /* synthetic */ void onFailure(Error error) {
                            NetError netError = (NetError) error;
                            if (this.O00000o0 != null) {
                                Bundle bundle = new Bundle();
                                if (netError != null) {
                                    bundle.putParcelable("error", netError);
                                }
                                try {
                                    this.O00000o0.onFailure(bundle);
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            fjd.this.f16443O000000o.post(new Runnable() {
                                /* class _m_j.fjd.AnonymousClass3.AnonymousClass1 */

                                public final void run() {
                                    fjd.this.O000000o(AnonymousClass3.this.f16455O000000o, AnonymousClass3.this.O00000Oo);
                                    if (AnonymousClass3.this.O00000o0 != null) {
                                        Bundle bundle = new Bundle();
                                        bundle.putString("result", "success");
                                        try {
                                            AnonymousClass3.this.O00000o0.onSuccess(bundle);
                                        } catch (RemoteException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            });
                        }
                    });
                }
            };
            r0.execute();
            return r0;
        }
    }

    public IServerHandle delDeviceBatch(final List<String> list, final IClientCallback iClientCallback) {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O00000Oo(callingPid, callingUid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("error", new NetError(-3, "core service : permission deny"));
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass19 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass19 */
                fdi mNetHandle;

                public void onCancel() {
                    fdi fdi = this.mNetHandle;
                    if (fdi != null) {
                        fdi.O000000o();
                    }
                }

                public void run() {
                    this.mNetHandle = fjd.O000000o().O000000o(list, iClientCallback);
                }
            };
            r0.execute();
            return r0;
        }
    }

    public IServerHandle updateDeviceBatch(final List<String> list, final IClientCallback iClientCallback) {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O00000Oo(callingPid, callingUid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("error", new NetError(-3, "core service : permission deny"));
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass20 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass20 */
                fdi mNetHandle;

                public void onCancel() {
                    fdi fdi = this.mNetHandle;
                    if (fdi != null) {
                        fdi.O000000o();
                    }
                }

                public void run() {
                    fjd O000000o2 = fjd.O000000o();
                    List list = list;
                    IClientCallback iClientCallback = iClientCallback;
                    fjq.O000000o();
                    this.mNetHandle = fjq.O000000o(list, new fdh<ArrayList<Device>, NetError>(iClientCallback) {
                        /* class _m_j.fjd.AnonymousClass7 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ IClientCallback f16460O000000o;

                        {
                            this.f16460O000000o = r2;
                        }

                        public final /* synthetic */ void onFailure(Error error) {
                            final NetError netError = (NetError) error;
                            fjd.this.f16443O000000o.post(new Runnable() {
                                /* class _m_j.fjd.AnonymousClass7.AnonymousClass2 */

                                public final void run() {
                                    if (AnonymousClass7.this.f16460O000000o != null) {
                                        Bundle bundle = new Bundle();
                                        NetError netError = netError;
                                        if (netError != null) {
                                            bundle.putParcelable("error", netError);
                                        }
                                        try {
                                            AnonymousClass7.this.f16460O000000o.onFailure(bundle);
                                        } catch (RemoteException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            });
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            final ArrayList arrayList = (ArrayList) obj;
                            fjd.this.f16443O000000o.post(new Runnable() {
                                /* class _m_j.fjd.AnonymousClass7.AnonymousClass1 */

                                public final void run() {
                                    if (AnonymousClass7.this.f16460O000000o != null) {
                                        Bundle bundle = new Bundle();
                                        ArrayList arrayList = arrayList;
                                        if (arrayList != null && arrayList.size() > 0) {
                                            bundle.putParcelableArrayList("result", arrayList);
                                        }
                                        try {
                                            AnonymousClass7.this.f16460O000000o.onSuccess(bundle);
                                        } catch (RemoteException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            });
                        }
                    });
                }
            };
            r0.execute();
            return r0;
        }
    }

    public boolean isServicePromoteSuccess() {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O00000Oo(callingPid, callingUid)) {
            return this.mIsPromoteSuccess;
        }
        return false;
    }

    public void setPromoteStatus(boolean z) {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O00000Oo(callingPid, callingUid)) {
            this.mIsPromoteSuccess = z;
        }
    }

    public CTAInfo getGlobalSettingCTA() throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid) || !flq.O000000o().O00000Oo(callingPid, callingUid)) {
            return null;
        }
        boolean O00000Oo = fju.O000000o().O00000Oo();
        boolean O00000o0 = fju.O000000o().O00000o0();
        CTAInfo cTAInfo = new CTAInfo();
        cTAInfo.O000000o(O00000Oo);
        cTAInfo.O00000Oo(O00000o0);
        return cTAInfo;
    }

    public IServerHandle setGlobalSettingCTA(final boolean z, final boolean z2, final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new Error(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O000000o(callingPid, callingUid)) {
            if (iClientCallback != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("error", new Error(-3, "core service : permission deny"));
                try {
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass21 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass21 */

                public void onCancel() {
                }

                public void run() {
                    boolean O00000Oo = fju.O000000o().O00000Oo();
                    boolean O00000o0 = fju.O000000o().O00000o0();
                    boolean O00000Oo2 = fiy.O000000o().O00000Oo();
                    fju.O000000o().O000000o(z, z2);
                    if (z2) {
                        fiy.O000000o().O00000o0();
                    }
                    if (iClientCallback != null) {
                        try {
                            iClientCallback.onSuccess(new Bundle());
                        } catch (RemoteException e) {
                            Log.e("CoreApiStub", "fatal", e);
                        }
                    }
                    if (!O00000o0 || (O00000Oo && !O00000Oo2)) {
                        ft.O000000o(CoreService.getAppContext()).O000000o(new Intent("CTAManager.onCTAReadyInternal"));
                    }
                }
            };
            r0.execute();
            return r0;
        }
    }

    public ServerBean getGlobalSettingServer() throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O00000Oo(callingPid, callingUid)) {
            return fju.O000000o().O00000o();
        }
        return null;
    }

    public IServerHandle setGlobalSettingServer(final ServerBean serverBean, final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new Error(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O000000o(callingPid, callingUid)) {
            if (iClientCallback != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("error", new Error(-3, "core service : permission deny"));
                try {
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass22 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass22 */

                public void onCancel() {
                }

                public void run() {
                    ServerBean O00000o = fju.O000000o().O00000o();
                    ServerBean serverBean = serverBean;
                    fju.O000000o().O000000o(serverBean);
                    if (iClientCallback != null) {
                        try {
                            iClientCallback.onSuccess(new Bundle());
                        } catch (RemoteException e) {
                            Log.e("CoreApiStub", "fatal", e);
                        }
                    }
                    if (serverBean != null || O00000o != null) {
                        if (O00000o == null || serverBean == null || !O00000o.O00000Oo.equals(serverBean.O00000Oo)) {
                            fkl O000000o2 = fkl.O000000o();
                            if (!O000000o2.O00000o0()) {
                                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "onServerChanged failed, not init");
                            } else {
                                Message obtain = Message.obtain();
                                obtain.what = 4;
                                obtain.obj = new Pair(O00000o, serverBean);
                                O000000o2.O0000O0o.sendMessage(obtain);
                            }
                            PluginDeviceManager.instance.clearConfig();
                            fjd.O000000o().O00000oo();
                            fdt.O000000o().O000000o(false);
                            fdr.O000000o().O00000Oo();
                            fdp.O000000o().O000000o(false);
                            fdq.O000000o().O000000o(false);
                            fds.O000000o().O000000o(false);
                            fdo.O000000o().O000000o(false);
                            fdm.O000000o().O000000o(false);
                            fdn.O000000o().O000000o(false);
                            fln.O000000o();
                            for (IClientApi onServerChanged : fcy.O000000o().O00000o0()) {
                                try {
                                    onServerChanged.onServerChanged(O00000o, serverBean);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            };
            r0.execute();
            return r0;
        }
    }

    public String getGlobalSettingServerEnv() throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O00000Oo(callingPid, callingUid)) {
            return fju.O000000o().O00000oo();
        }
        return "";
    }

    public IServerHandle setGlobalSettingServerEnv(final String str, final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new Error(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
            return null;
        } else if (!flq.O000000o().O000000o(callingPid, callingUid)) {
            if (iClientCallback != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("error", new Error(-3, "core service : permission deny"));
                try {
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
            return null;
        } else {
            AnonymousClass23 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass23 */

                public void onCancel() {
                }

                public void run() {
                    String O00000oo = fju.O000000o().O00000oo();
                    String str = str;
                    fju.O000000o().O000000o(str);
                    fdt.O000000o().O000000o(false);
                    fdq.O000000o().O000000o(false);
                    fdp.O000000o().O000000o(false);
                    fds.O000000o().O000000o(false);
                    if (iClientCallback != null) {
                        try {
                            iClientCallback.onSuccess(new Bundle());
                        } catch (RemoteException e) {
                            Log.e("CoreApiStub", "fatal", e);
                        }
                    }
                    if (!TextUtils.isEmpty(O00000oo) || TextUtils.isEmpty(str)) {
                    }
                }
            };
            r0.execute();
            return r0;
        }
    }

    public Bundle getGlobalSettingLocale() throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid) || !flq.O000000o().O00000Oo(callingPid, callingUid)) {
            return null;
        }
        Locale O0000O0o = fju.O000000o().O0000O0o();
        Bundle bundle = new Bundle();
        if (O0000O0o != null) {
            bundle.putSerializable("result", O0000O0o);
        }
        return bundle;
    }

    public IServerHandle setGlobalSettingLocale(final Bundle bundle, final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("error", new Error(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle2);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                    gsy.O00000Oo("LanguageUtil", "setGlobalSettingLocale Exception");
                }
            }
            return null;
        } else if (!flq.O000000o().O000000o(callingPid, callingUid)) {
            if (iClientCallback != null) {
                Bundle bundle3 = new Bundle();
                bundle3.putParcelable("error", new Error(-3, "core service : permission deny"));
                try {
                    iClientCallback.onFailure(bundle3);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                    gsy.O00000Oo("LanguageUtil", "setGlobalSettingLocale Exception");
                }
            }
            return null;
        } else {
            AnonymousClass24 r0 = new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass24 */

                public void onCancel() {
                }

                public void run() {
                    if (bundle != null) {
                        Locale O0000O0o = fju.O000000o().O0000O0o();
                        Locale locale = (Locale) bundle.getSerializable("result");
                        if (locale == null) {
                            fju.O000000o().O0000Oo0();
                        } else {
                            fju.O000000o().O000000o(locale);
                        }
                        fdt.O000000o().O000000o(false);
                        fdr.O000000o().O00000Oo();
                        fdp.O000000o().O000000o(false);
                        fdq.O000000o().O000000o(false);
                        fds.O000000o().O000000o(false);
                        fdo.O000000o().O000000o(false);
                        fdm.O000000o().O000000o(false);
                        fdn.O000000o().O000000o(false);
                        fln.O000000o();
                        PluginDeviceManager.instance.clearConfig();
                        if (iClientCallback != null) {
                            try {
                                iClientCallback.onSuccess(new Bundle());
                            } catch (RemoteException e) {
                                Log.e("CoreApiStub", "fatal", e);
                                gsy.O00000Oo("LanguageUtil", "2690 Exception");
                            }
                        }
                        if (locale != null) {
                            boolean z = true;
                            if (O0000O0o != locale && (O0000O0o == null || locale == null || !O0000O0o.getLanguage().equalsIgnoreCase(locale.getLanguage()) || !O0000O0o.getCountry().equalsIgnoreCase(locale.getCountry()))) {
                                z = false;
                            }
                            if (z) {
                                return;
                            }
                        }
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("result", O0000O0o);
                        Bundle bundle2 = new Bundle();
                        bundle2.putSerializable("result", locale);
                        for (IClientApi onLocaleChanged : fcy.O000000o().O00000o0()) {
                            try {
                                onLocaleChanged.onLocaleChanged(bundle, bundle2);
                            } catch (Exception e2) {
                                gsy.O00000Oo("LanguageUtil", e2.toString());
                            }
                        }
                    } else if (iClientCallback != null) {
                        try {
                            Bundle bundle3 = new Bundle();
                            bundle3.putParcelable("error", new Error(-999, "core service : bundle is null"));
                            iClientCallback.onFailure(bundle3);
                        } catch (RemoteException e3) {
                            Log.e("CoreApiStub", "fatal", e3);
                            gsy.O00000Oo("LanguageUtil", "2722setGlobalSettingLocale Exception");
                        }
                    }
                }
            };
            r0.execute();
            return r0;
        }
    }

    public void updateWhiteList(final boolean z) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
            new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass25 */

                public void onCancel() {
                }

                public void run() {
                    if (flq.O000000o().O00000o0()) {
                        flq.O000000o();
                    }
                }
            }.execute();
        }
    }

    public void clearWhiteList() throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
            new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass26 */

                public void onCancel() {
                }

                public void run() {
                    SharedPreferences sharedPreferences;
                    if (flq.O000000o().O00000o0()) {
                        flq O000000o2 = flq.O000000o();
                        O000000o2.O00000Oo.clear();
                        if (O000000o2.f16582O000000o != null && (sharedPreferences = O000000o2.f16582O000000o) != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.clear();
                            edit.commit();
                        }
                    }
                }
            }.execute();
        }
    }

    public void setScanTimePeriod(int i) {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O00000Oo(callingPid, callingUid)) {
            flt.O000000o(i);
        }
    }

    public void startScanWithCallback(int i, IClientCallback iClientCallback) {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O00000Oo(callingPid, callingUid)) {
            flt.O000000o(i, iClientCallback);
        }
    }

    public void startScanWithModel(String str, IClientCallback iClientCallback) {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O00000Oo(callingPid, callingUid)) {
            flt.O000000o(str, iClientCallback);
        }
    }

    public void stopScan() {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O00000Oo(callingPid, callingUid)) {
            flt.O00000Oo();
        }
    }

    public void updatePluginConfig(final boolean z, final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
        } else if (flq.O000000o().O000000o(callingPid, callingUid)) {
            new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass27 */

                public void onCancel() {
                }

                public void run() {
                    PluginDeviceManager.instance.updateConfig(z, new fkn() {
                        /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass27.AnonymousClass1 */

                        public final void O000000o(boolean z, boolean z2) {
                            if (iClientCallback != null) {
                                Bundle bundle = new Bundle();
                                UpdatePluginConfigResult updatePluginConfigResult = new UpdatePluginConfigResult();
                                updatePluginConfigResult.f6740O000000o = z;
                                updatePluginConfigResult.O00000Oo = z2;
                                bundle.putParcelable("result", updatePluginConfigResult);
                                try {
                                    iClientCallback.onSuccess(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }

                        public final void O000000o(fdg fdg) {
                            if (iClientCallback != null) {
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("error", new PluginError(fdg.f16100O000000o, fdg.O00000Oo));
                                try {
                                    iClientCallback.onFailure(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }
                    });
                }
            }.execute();
        } else if (iClientCallback != null) {
            try {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("error", new PluginError(-1, "core service permission deny"));
                iClientCallback.onFailure(bundle2);
            } catch (RemoteException e2) {
                Log.e("CoreApiStub", "fatal", e2);
            }
        }
    }

    public void clearPluginConfig(IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
        } else if (flq.O000000o().O000000o(callingPid, callingUid)) {
            PluginDeviceManager.instance.clearConfig();
            Bundle bundle2 = new Bundle();
            if (iClientCallback != null) {
                try {
                    iClientCallback.onSuccess(bundle2);
                } catch (RemoteException e2) {
                    Log.e("CoreApiStub", "fatal", e2);
                }
            }
        } else if (iClientCallback != null) {
            try {
                Bundle bundle3 = new Bundle();
                bundle3.putParcelable("error", new PluginError(-1, "core service permission deny"));
                iClientCallback.onFailure(bundle3);
            } catch (RemoteException e3) {
                Log.e("CoreApiStub", "fatal", e3);
            }
        }
    }

    public PluginDeviceInfo getPluginInfo(String str) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
            return PluginDeviceManager.instance.getPluginInfo(str);
        }
        return null;
    }

    public PluginDeviceInfo getExtraPluginInfo(String str) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
            return PluginDeviceManager.instance.getExtraPluginInfo(str);
        }
        return null;
    }

    public String getModelByProductId(int i) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
            return PluginDeviceManager.instance.getModelByProductId(i);
        }
        return "";
    }

    public int getProductIdByModel(String str) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
            return PluginDeviceManager.instance.getProductIdByModel(str);
        }
        return 0;
    }

    public String getModelBySSID(String str) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
            return PluginDeviceManager.instance.getModelBySSID(str);
        }
        return "";
    }

    public boolean isPluginForceUpdating(String str) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid) || !flq.O000000o().O000000o(callingPid, callingUid)) {
            return false;
        }
        fkl O000000o2 = fkl.O000000o();
        if (!(str == null || O000000o2.f16519O000000o == null)) {
            boolean z = false;
            for (Map.Entry<fki, List<fki>> value : O000000o2.f16519O000000o.f16512O000000o.entrySet()) {
                Iterator it = ((List) value.getValue()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        fki fki = (fki) it.next();
                        if (fki != null && fki.O0000OOo() && fki.f16517O000000o.equalsIgnoreCase(str)) {
                            z = true;
                            continue;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z) {
                    break;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public void downloadPlugin(final List<String> list, final boolean z, final IClientCallback iClientCallback) throws RemoteException {
        int callingPid = getCallingPid();
        int callingUid = getCallingUid();
        if (!fcy.O000000o().O000000o(callingPid)) {
            if (iClientCallback != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("error", new PluginError(-2, "core service : process not register"));
                    iClientCallback.onFailure(bundle);
                } catch (RemoteException e) {
                    Log.e("CoreApiStub", "fatal", e);
                }
            }
        } else if (flq.O000000o().O000000o(callingPid, callingUid)) {
            new CoreAsyncTask() {
                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass28 */

                public void onCancel() {
                }

                public void run() {
                    AnonymousClass1 r0 = new fkh() {
                        /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass28.AnonymousClass1 */

                        public final void O000000o(ArrayList<PluginDownloadTask> arrayList) {
                            if (iClientCallback != null) {
                                Bundle bundle = new Bundle();
                                DownloadPluginResult downloadPluginResult = new DownloadPluginResult();
                                downloadPluginResult.f6733O000000o = 1;
                                downloadPluginResult.O00000o = arrayList;
                                bundle.putParcelable("result", downloadPluginResult);
                                try {
                                    iClientCallback.onSuccess(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }

                        public final void O00000Oo(ArrayList<PluginDownloadTask> arrayList) {
                            if (iClientCallback != null) {
                                Bundle bundle = new Bundle();
                                DownloadPluginResult downloadPluginResult = new DownloadPluginResult();
                                downloadPluginResult.f6733O000000o = 7;
                                downloadPluginResult.O00000o = arrayList;
                                bundle.putParcelable("result", downloadPluginResult);
                                try {
                                    iClientCallback.onSuccess(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }

                        public final void O000000o(String str, float f) {
                            if (iClientCallback != null) {
                                Bundle bundle = new Bundle();
                                DownloadPluginResult downloadPluginResult = new DownloadPluginResult();
                                downloadPluginResult.f6733O000000o = 3;
                                downloadPluginResult.O00000oO = f;
                                downloadPluginResult.O00000o0 = str;
                                bundle.putParcelable("result", downloadPluginResult);
                                try {
                                    iClientCallback.onSuccess(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }

                        public final void O000000o(String str) {
                            if (iClientCallback != null) {
                                Bundle bundle = new Bundle();
                                DownloadPluginResult downloadPluginResult = new DownloadPluginResult();
                                downloadPluginResult.f6733O000000o = 4;
                                downloadPluginResult.O00000o0 = str;
                                bundle.putParcelable("result", downloadPluginResult);
                                try {
                                    iClientCallback.onSuccess(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }

                        public final void O000000o(String str, int i) {
                            if (iClientCallback != null) {
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("error", new PluginError(i, "Down error"));
                                DownloadPluginResult downloadPluginResult = new DownloadPluginResult();
                                downloadPluginResult.O00000o0 = str;
                                bundle.putParcelable("result", downloadPluginResult);
                                try {
                                    iClientCallback.onFailure(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }

                        public final void O00000Oo(String str) {
                            if (iClientCallback != null) {
                                Bundle bundle = new Bundle();
                                DownloadPluginResult downloadPluginResult = new DownloadPluginResult();
                                downloadPluginResult.f6733O000000o = 6;
                                downloadPluginResult.O00000o0 = str;
                                bundle.putParcelable("result", downloadPluginResult);
                                try {
                                    iClientCallback.onSuccess(bundle);
                                } catch (RemoteException e) {
                                    Log.e("CoreApiStub", "fatal", e);
                                }
                            }
                        }
                    };
                    fkl O000000o2 = fkl.O000000o();
                    List<String> list = list;
                    boolean z = z;
                    if (!O000000o2.O00000o0()) {
                        gsy.O00000o0(LogType.PLUGIN, "PluginManager", "downloadPlugin failed, not init");
                        r0.O000000o("", -1);
                        return;
                    }
                    fkl.AnonymousClass8 r4 = new fkh(r0) {
                        /* class _m_j.fkl.AnonymousClass8 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ fkh f16532O000000o;

                        {
                            this.f16532O000000o = r2;
                        }

                        public final void O000000o(ArrayList<PluginDownloadTask> arrayList) {
                            if (this.f16532O000000o != null) {
                                fkl.this.O00000oO.post(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                                      (wrap: android.os.Handler : 0x0006: IGET  (r0v2 android.os.Handler) = (wrap: _m_j.fkl : 0x0004: IGET  (r0v1 _m_j.fkl) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O00000Oo _m_j.fkl) _m_j.fkl.O00000oO android.os.Handler)
                                      (wrap: _m_j.-$$Lambda$fkl$8$KzTif5a1PyAu-BfSW5j6pefE73g : 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$8$KzTif5a1PyAu-BfSW5j6pefE73g) = 
                                      (wrap: _m_j.fkh : 0x0008: IGET  (r1v0 _m_j.fkh) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O000000o _m_j.fkh)
                                      (r4v0 'arrayList' java.util.ArrayList<com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask>)
                                     call: _m_j.-$$Lambda$fkl$8$KzTif5a1PyAu-BfSW5j6pefE73g.<init>(_m_j.fkh, java.util.ArrayList):void type: CONSTRUCTOR)
                                     type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: _m_j.fkl.8.O000000o(java.util.ArrayList<com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask>):void, dex: classes7.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$8$KzTif5a1PyAu-BfSW5j6pefE73g) = 
                                      (wrap: _m_j.fkh : 0x0008: IGET  (r1v0 _m_j.fkh) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O000000o _m_j.fkh)
                                      (r4v0 'arrayList' java.util.ArrayList<com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask>)
                                     call: _m_j.-$$Lambda$fkl$8$KzTif5a1PyAu-BfSW5j6pefE73g.<init>(_m_j.fkh, java.util.ArrayList):void type: CONSTRUCTOR in method: _m_j.fkl.8.O000000o(java.util.ArrayList<com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask>):void, dex: classes7.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 107 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$fkl$8$KzTif5a1PyAu-BfSW5j6pefE73g, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 113 more
                                    */
                                /*
                                    this = this;
                                    _m_j.fkh r0 = r3.f16532O000000o
                                    if (r0 == 0) goto L_0x0012
                                    _m_j.fkl r0 = _m_j.fkl.this
                                    android.os.Handler r0 = r0.O00000oO
                                    _m_j.fkh r1 = r3.f16532O000000o
                                    _m_j.-$$Lambda$fkl$8$KzTif5a1PyAu-BfSW5j6pefE73g r2 = new _m_j.-$$Lambda$fkl$8$KzTif5a1PyAu-BfSW5j6pefE73g
                                    r2.<init>(r1, r4)
                                    r0.post(r2)
                                L_0x0012:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: _m_j.fkl.AnonymousClass8.O000000o(java.util.ArrayList):void");
                            }

                            public final void O00000Oo(ArrayList<PluginDownloadTask> arrayList) {
                                if (this.f16532O000000o != null) {
                                    fkl.this.O00000oO.post(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                                          (wrap: android.os.Handler : 0x0006: IGET  (r0v2 android.os.Handler) = (wrap: _m_j.fkl : 0x0004: IGET  (r0v1 _m_j.fkl) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O00000Oo _m_j.fkl) _m_j.fkl.O00000oO android.os.Handler)
                                          (wrap: _m_j.-$$Lambda$fkl$8$vGrb0uGrDLKMn8lU--WddzBzjL0 : 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$8$vGrb0uGrDLKMn8lU--WddzBzjL0) = 
                                          (wrap: _m_j.fkh : 0x0008: IGET  (r1v0 _m_j.fkh) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O000000o _m_j.fkh)
                                          (r4v0 'arrayList' java.util.ArrayList<com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask>)
                                         call: _m_j.-$$Lambda$fkl$8$vGrb0uGrDLKMn8lU--WddzBzjL0.<init>(_m_j.fkh, java.util.ArrayList):void type: CONSTRUCTOR)
                                         type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: _m_j.fkl.8.O00000Oo(java.util.ArrayList<com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask>):void, dex: classes7.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$8$vGrb0uGrDLKMn8lU--WddzBzjL0) = 
                                          (wrap: _m_j.fkh : 0x0008: IGET  (r1v0 _m_j.fkh) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O000000o _m_j.fkh)
                                          (r4v0 'arrayList' java.util.ArrayList<com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask>)
                                         call: _m_j.-$$Lambda$fkl$8$vGrb0uGrDLKMn8lU--WddzBzjL0.<init>(_m_j.fkh, java.util.ArrayList):void type: CONSTRUCTOR in method: _m_j.fkl.8.O00000Oo(java.util.ArrayList<com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask>):void, dex: classes7.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 107 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$fkl$8$vGrb0uGrDLKMn8lU--WddzBzjL0, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 113 more
                                        */
                                    /*
                                        this = this;
                                        _m_j.fkh r0 = r3.f16532O000000o
                                        if (r0 == 0) goto L_0x0012
                                        _m_j.fkl r0 = _m_j.fkl.this
                                        android.os.Handler r0 = r0.O00000oO
                                        _m_j.fkh r1 = r3.f16532O000000o
                                        _m_j.-$$Lambda$fkl$8$vGrb0uGrDLKMn8lU--WddzBzjL0 r2 = new _m_j.-$$Lambda$fkl$8$vGrb0uGrDLKMn8lU--WddzBzjL0
                                        r2.<init>(r1, r4)
                                        r0.post(r2)
                                    L_0x0012:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: _m_j.fkl.AnonymousClass8.O00000Oo(java.util.ArrayList):void");
                                }

                                public final void O000000o(String str, float f) {
                                    if (this.f16532O000000o != null) {
                                        fkl.this.O00000oO.post(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                                              (wrap: android.os.Handler : 0x0006: IGET  (r0v2 android.os.Handler) = (wrap: _m_j.fkl : 0x0004: IGET  (r0v1 _m_j.fkl) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O00000Oo _m_j.fkl) _m_j.fkl.O00000oO android.os.Handler)
                                              (wrap: _m_j.-$$Lambda$fkl$8$-PRPx5kdUOo1pj1fKP6qgIso8Ao : 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$8$-PRPx5kdUOo1pj1fKP6qgIso8Ao) = 
                                              (wrap: _m_j.fkh : 0x0008: IGET  (r1v0 _m_j.fkh) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O000000o _m_j.fkh)
                                              (r4v0 'str' java.lang.String)
                                              (r5v0 'f' float)
                                             call: _m_j.-$$Lambda$fkl$8$-PRPx5kdUOo1pj1fKP6qgIso8Ao.<init>(_m_j.fkh, java.lang.String, float):void type: CONSTRUCTOR)
                                             type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: _m_j.fkl.8.O000000o(java.lang.String, float):void, dex: classes7.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$8$-PRPx5kdUOo1pj1fKP6qgIso8Ao) = 
                                              (wrap: _m_j.fkh : 0x0008: IGET  (r1v0 _m_j.fkh) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O000000o _m_j.fkh)
                                              (r4v0 'str' java.lang.String)
                                              (r5v0 'f' float)
                                             call: _m_j.-$$Lambda$fkl$8$-PRPx5kdUOo1pj1fKP6qgIso8Ao.<init>(_m_j.fkh, java.lang.String, float):void type: CONSTRUCTOR in method: _m_j.fkl.8.O000000o(java.lang.String, float):void, dex: classes7.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	... 107 more
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$fkl$8$-PRPx5kdUOo1pj1fKP6qgIso8Ao, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                            	... 113 more
                                            */
                                        /*
                                            this = this;
                                            _m_j.fkh r0 = r3.f16532O000000o
                                            if (r0 == 0) goto L_0x0012
                                            _m_j.fkl r0 = _m_j.fkl.this
                                            android.os.Handler r0 = r0.O00000oO
                                            _m_j.fkh r1 = r3.f16532O000000o
                                            _m_j.-$$Lambda$fkl$8$-PRPx5kdUOo1pj1fKP6qgIso8Ao r2 = new _m_j.-$$Lambda$fkl$8$-PRPx5kdUOo1pj1fKP6qgIso8Ao
                                            r2.<init>(r1, r4, r5)
                                            r0.post(r2)
                                        L_0x0012:
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: _m_j.fkl.AnonymousClass8.O000000o(java.lang.String, float):void");
                                    }

                                    public final void O000000o(String str) {
                                        if (this.f16532O000000o != null) {
                                            fkl.this.O00000oO.post(
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                                                  (wrap: android.os.Handler : 0x0006: IGET  (r0v2 android.os.Handler) = (wrap: _m_j.fkl : 0x0004: IGET  (r0v1 _m_j.fkl) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O00000Oo _m_j.fkl) _m_j.fkl.O00000oO android.os.Handler)
                                                  (wrap: _m_j.-$$Lambda$fkl$8$EBZZz8PdRh3pME8dFXidRZba3Ms : 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$8$EBZZz8PdRh3pME8dFXidRZba3Ms) = 
                                                  (wrap: _m_j.fkh : 0x0008: IGET  (r1v0 _m_j.fkh) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O000000o _m_j.fkh)
                                                  (r4v0 'str' java.lang.String)
                                                 call: _m_j.-$$Lambda$fkl$8$EBZZz8PdRh3pME8dFXidRZba3Ms.<init>(_m_j.fkh, java.lang.String):void type: CONSTRUCTOR)
                                                 type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: _m_j.fkl.8.O000000o(java.lang.String):void, dex: classes7.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$8$EBZZz8PdRh3pME8dFXidRZba3Ms) = 
                                                  (wrap: _m_j.fkh : 0x0008: IGET  (r1v0 _m_j.fkh) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O000000o _m_j.fkh)
                                                  (r4v0 'str' java.lang.String)
                                                 call: _m_j.-$$Lambda$fkl$8$EBZZz8PdRh3pME8dFXidRZba3Ms.<init>(_m_j.fkh, java.lang.String):void type: CONSTRUCTOR in method: _m_j.fkl.8.O000000o(java.lang.String):void, dex: classes7.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                	... 107 more
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$fkl$8$EBZZz8PdRh3pME8dFXidRZba3Ms, state: NOT_LOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                	... 113 more
                                                */
                                            /*
                                                this = this;
                                                _m_j.fkh r0 = r3.f16532O000000o
                                                if (r0 == 0) goto L_0x0012
                                                _m_j.fkl r0 = _m_j.fkl.this
                                                android.os.Handler r0 = r0.O00000oO
                                                _m_j.fkh r1 = r3.f16532O000000o
                                                _m_j.-$$Lambda$fkl$8$EBZZz8PdRh3pME8dFXidRZba3Ms r2 = new _m_j.-$$Lambda$fkl$8$EBZZz8PdRh3pME8dFXidRZba3Ms
                                                r2.<init>(r1, r4)
                                                r0.post(r2)
                                            L_0x0012:
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: _m_j.fkl.AnonymousClass8.O000000o(java.lang.String):void");
                                        }

                                        public final void O000000o(String str, int i) {
                                            if (this.f16532O000000o != null) {
                                                fkl.this.O00000oO.post(
                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                                                      (wrap: android.os.Handler : 0x0006: IGET  (r0v2 android.os.Handler) = (wrap: _m_j.fkl : 0x0004: IGET  (r0v1 _m_j.fkl) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O00000Oo _m_j.fkl) _m_j.fkl.O00000oO android.os.Handler)
                                                      (wrap: _m_j.-$$Lambda$fkl$8$USL02Ah12ZbpbUdSfA3pu8boWeA : 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$8$USL02Ah12ZbpbUdSfA3pu8boWeA) = 
                                                      (wrap: _m_j.fkh : 0x0008: IGET  (r1v0 _m_j.fkh) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O000000o _m_j.fkh)
                                                      (r4v0 'str' java.lang.String)
                                                      (r5v0 'i' int)
                                                     call: _m_j.-$$Lambda$fkl$8$USL02Ah12ZbpbUdSfA3pu8boWeA.<init>(_m_j.fkh, java.lang.String, int):void type: CONSTRUCTOR)
                                                     type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: _m_j.fkl.8.O000000o(java.lang.String, int):void, dex: classes7.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$8$USL02Ah12ZbpbUdSfA3pu8boWeA) = 
                                                      (wrap: _m_j.fkh : 0x0008: IGET  (r1v0 _m_j.fkh) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O000000o _m_j.fkh)
                                                      (r4v0 'str' java.lang.String)
                                                      (r5v0 'i' int)
                                                     call: _m_j.-$$Lambda$fkl$8$USL02Ah12ZbpbUdSfA3pu8boWeA.<init>(_m_j.fkh, java.lang.String, int):void type: CONSTRUCTOR in method: _m_j.fkl.8.O000000o(java.lang.String, int):void, dex: classes7.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                    	... 107 more
                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$fkl$8$USL02Ah12ZbpbUdSfA3pu8boWeA, state: NOT_LOADED
                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                    	... 113 more
                                                    */
                                                /*
                                                    this = this;
                                                    _m_j.fkh r0 = r3.f16532O000000o
                                                    if (r0 == 0) goto L_0x0012
                                                    _m_j.fkl r0 = _m_j.fkl.this
                                                    android.os.Handler r0 = r0.O00000oO
                                                    _m_j.fkh r1 = r3.f16532O000000o
                                                    _m_j.-$$Lambda$fkl$8$USL02Ah12ZbpbUdSfA3pu8boWeA r2 = new _m_j.-$$Lambda$fkl$8$USL02Ah12ZbpbUdSfA3pu8boWeA
                                                    r2.<init>(r1, r4, r5)
                                                    r0.post(r2)
                                                L_0x0012:
                                                    return
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: _m_j.fkl.AnonymousClass8.O000000o(java.lang.String, int):void");
                                            }

                                            public final void O00000Oo(String str) {
                                                if (this.f16532O000000o != null) {
                                                    fkl.this.O00000oO.post(
                                                    /*  JADX ERROR: Method code generation error
                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                                                          (wrap: android.os.Handler : 0x0006: IGET  (r0v2 android.os.Handler) = (wrap: _m_j.fkl : 0x0004: IGET  (r0v1 _m_j.fkl) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O00000Oo _m_j.fkl) _m_j.fkl.O00000oO android.os.Handler)
                                                          (wrap: _m_j.-$$Lambda$fkl$8$b_fUzsrdPN5b0ymHmXOhY2S1UXc : 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$8$b_fUzsrdPN5b0ymHmXOhY2S1UXc) = 
                                                          (wrap: _m_j.fkh : 0x0008: IGET  (r1v0 _m_j.fkh) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O000000o _m_j.fkh)
                                                          (r4v0 'str' java.lang.String)
                                                         call: _m_j.-$$Lambda$fkl$8$b_fUzsrdPN5b0ymHmXOhY2S1UXc.<init>(_m_j.fkh, java.lang.String):void type: CONSTRUCTOR)
                                                         type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: _m_j.fkl.8.O00000Oo(java.lang.String):void, dex: classes7.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$8$b_fUzsrdPN5b0ymHmXOhY2S1UXc) = 
                                                          (wrap: _m_j.fkh : 0x0008: IGET  (r1v0 _m_j.fkh) = (r3v0 'this' _m_j.fkl$8 A[THIS]) _m_j.fkl.8.O000000o _m_j.fkh)
                                                          (r4v0 'str' java.lang.String)
                                                         call: _m_j.-$$Lambda$fkl$8$b_fUzsrdPN5b0ymHmXOhY2S1UXc.<init>(_m_j.fkh, java.lang.String):void type: CONSTRUCTOR in method: _m_j.fkl.8.O00000Oo(java.lang.String):void, dex: classes7.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                        	... 107 more
                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$fkl$8$b_fUzsrdPN5b0ymHmXOhY2S1UXc, state: NOT_LOADED
                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	... 113 more
                                                        */
                                                    /*
                                                        this = this;
                                                        _m_j.fkh r0 = r3.f16532O000000o
                                                        if (r0 == 0) goto L_0x0012
                                                        _m_j.fkl r0 = _m_j.fkl.this
                                                        android.os.Handler r0 = r0.O00000oO
                                                        _m_j.fkh r1 = r3.f16532O000000o
                                                        _m_j.-$$Lambda$fkl$8$b_fUzsrdPN5b0ymHmXOhY2S1UXc r2 = new _m_j.-$$Lambda$fkl$8$b_fUzsrdPN5b0ymHmXOhY2S1UXc
                                                        r2.<init>(r1, r4)
                                                        r0.post(r2)
                                                    L_0x0012:
                                                        return
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: _m_j.fkl.AnonymousClass8.O00000Oo(java.lang.String):void");
                                                }
                                            };
                                            if (list.size() == 1 && O000000o2.O0000Oo0.get(list.get(0)) == null && fkc.O000000o().O000000o((String) list.get(0))) {
                                                O000000o2.O000000o((String) list.get(0), r4);
                                                return;
                                            }
                                            JSONArray jSONArray = new JSONArray();
                                            HashMap hashMap = new HashMap();
                                            for (String str : list) {
                                                jSONArray.put(O000000o2.O000000o(str));
                                                hashMap.put(str, new fki(str));
                                            }
                                            r4.O000000o(fkl.O000000o((HashMap<String, fki>) hashMap));
                                            fko O000000o3 = fko.O000000o();
                                            grr.O000000o();
                                            O000000o3.O000000o(jSONArray, grr.O0000o0O(), new fde<List<fkt>, fdg>(hashMap, r4, z) {
                                                /* class _m_j.fkl.AnonymousClass2 */

                                                /* renamed from: O000000o  reason: collision with root package name */
                                                final /* synthetic */ HashMap f16521O000000o;
                                                final /* synthetic */ fkh O00000Oo;
                                                final /* synthetic */ boolean O00000o0;

                                                {
                                                    this.f16521O000000o = r2;
                                                    this.O00000Oo = r3;
                                                    this.O00000o0 = r4;
                                                }

                                                /* JADX WARNING: Code restructure failed: missing block: B:50:0x017e, code lost:
                                                    if (android.text.TextUtils.isEmpty(r0.O00000oo()) == false) goto L_0x019e;
                                                 */
                                                /* JADX WARNING: Removed duplicated region for block: B:56:0x01aa  */
                                                /* JADX WARNING: Removed duplicated region for block: B:62:0x0216  */
                                                public final /* synthetic */ void onSuccess(Object obj) {
                                                    HashMap hashMap = new HashMap();
                                                    for (fkt fkt : (List) obj) {
                                                        fki fki = (fki) this.f16521O000000o.get(fkt.f16552O000000o);
                                                        if (fki != null) {
                                                            fki.O00000o(fkt.O0000Ooo);
                                                            fki.O000000o(fkt.O00000o0);
                                                            fki.O00000Oo(fkt.O00000o);
                                                            fki.O000000o(fkt.O0000OoO);
                                                            fki.O00000Oo(fkt.O0000OOo);
                                                            fki.O00000o0(fkt.O0000Oo0);
                                                            fki.O00000o0(fkt.O0000Oo);
                                                            fki.O00000o0 = fkt.O00000oo;
                                                            fki.O00000o = fkt.O0000O0o;
                                                            fki.O000000o(fkt.O000000o());
                                                        }
                                                        hashMap.put(fkt.f16552O000000o, fkt);
                                                    }
                                                    this.O00000Oo.O00000Oo(fkl.O000000o((HashMap<String, fki>) this.f16521O000000o));
                                                    for (Map.Entry entry : this.f16521O000000o.entrySet()) {
                                                        String str = (String) entry.getKey();
                                                        final fkt fkt2 = (fkt) hashMap.get(str);
                                                        if (fkt2 != null) {
                                                            final long j = fkt2.O00000o0;
                                                            long j2 = fkt2.O00000o;
                                                            String str2 = fkt2.O0000OoO;
                                                            fki fki2 = (fki) entry.getValue();
                                                            if (fkt2.O00000Oo == 1) {
                                                                fkl.O00000o(str + " downloadPluginInternal has Newest Package id  - " + j2);
                                                                boolean z = this.O00000o0;
                                                                if ("rn".equalsIgnoreCase(str2)) {
                                                                    z = true;
                                                                } else if (Arrays.binarySearch(DeviceConstant.supportNativePlugin(), str) >= 0) {
                                                                    this.O00000Oo.O000000o(str);
                                                                }
                                                                if (fkt2.O000000o() || gog.O00000oo(fkl.this.O00000o0) || z) {
                                                                    fki fki3 = fki2;
                                                                    String str3 = "rn";
                                                                    final long j3 = j2;
                                                                    long j4 = j2;
                                                                    final String str4 = str2;
                                                                    final fki fki4 = fki3;
                                                                    fki fki5 = fki3;
                                                                    fki5.O000000o(new fki.O000000o() {
                                                                        /* class _m_j.fkl.AnonymousClass2.AnonymousClass1 */

                                                                        /* access modifiers changed from: package-private */
                                                                        public final void O000000o(fki fki) {
                                                                            fki.O00000Oo = System.currentTimeMillis();
                                                                            fkl.O00000o("downloadPluginInternal onStart task:".concat(String.valueOf(fki)));
                                                                        }

                                                                        /* access modifiers changed from: package-private */
                                                                        public final void O000000o(fki fki, float f) {
                                                                            AnonymousClass2.this.O00000Oo.O000000o(fki.f16517O000000o, f);
                                                                        }

                                                                        /* access modifiers changed from: package-private */
                                                                        public final void O000000o(fki fki, PluginPackageInfo pluginPackageInfo) {
                                                                            fkl.this.O00000Oo(pluginPackageInfo);
                                                                            AnonymousClass2.this.O00000Oo.O000000o(fki.f16517O000000o);
                                                                            if ("rn".equalsIgnoreCase(fki.O00000o()) && fki.O00000Oo() == fkt2.O00000o0 && pluginPackageInfo != null) {
                                                                                pluginPackageInfo.O000000o(fkt2.O00000oo);
                                                                            }
                                                                            try {
                                                                                JSONObject jSONObject = new JSONObject();
                                                                                jSONObject.put("plugin_id", j);
                                                                                jSONObject.put("package_id", j3);
                                                                                jSONObject.put("download_type", "remote");
                                                                                fld.O00000o0().O000000o(StatType.EVENT.getValue(), "mihome", "plugin_download_success", jSONObject.toString(), null, false);
                                                                            } catch (Exception unused) {
                                                                            }
                                                                            fkl.O00000o("downloadPluginInternal success task:" + fki + " pluginPackageInfo:" + pluginPackageInfo);
                                                                            if ("rn".equalsIgnoreCase(str4)) {
                                                                                fkl.O000000o("download_plugin", fki4, 0);
                                                                            }
                                                                        }

                                                                        /* access modifiers changed from: package-private */
                                                                        public final void O000000o(fki fki, int i) {
                                                                            AnonymousClass2.this.O00000Oo.O000000o(fki.f16517O000000o, i);
                                                                            fkl.O00000o("downloadPluginInternal onFailure task:" + fki + ", error:" + i);
                                                                            if (!"rn".equalsIgnoreCase(str4)) {
                                                                                return;
                                                                            }
                                                                            if (i > 0) {
                                                                                fkl.O000000o("download_plugin", fki4, -30000 - i);
                                                                            } else {
                                                                                fkl.O000000o("download_plugin", fki4, i - 40000);
                                                                            }
                                                                        }

                                                                        /* access modifiers changed from: package-private */
                                                                        public final void O00000Oo(fki fki) {
                                                                            AnonymousClass2.this.O00000Oo.O00000Oo(fki.f16517O000000o);
                                                                            fkl.O00000o("downloadPluginInternal onCancel task:".concat(String.valueOf(fki)));
                                                                            if ("rn".equalsIgnoreCase(str4)) {
                                                                                fkl.O000000o("download_plugin", fki4, -1008);
                                                                            }
                                                                        }
                                                                    });
                                                                    fkl fkl = fkl.this;
                                                                    if (fki5 != null) {
                                                                        if (fki5.O00000Oo() > 0) {
                                                                            if (fki5.O00000o0() > 0) {
                                                                                if (!TextUtils.isEmpty(fki5.O00000o())) {
                                                                                    if (TextUtils.isEmpty(fki5.O00000oO())) {
                                                                                    }
                                                                                    if (!str3.equalsIgnoreCase(fki5.O00000o())) {
                                                                                        hsi.O000000o O000000o2 = fkl.O000000o(fkl.O00000o0);
                                                                                        long longValue = ((Long) fki5.O000000o("rnSdkApiLevel", 0L)).longValue();
                                                                                        if (O000000o2 == null || longValue > O000000o2.f598O000000o) {
                                                                                            fkl.O000000o(longValue, fki5);
                                                                                            hsi.O000000o("start to install new sdk ", Long.valueOf(longValue));
                                                                                        } else {
                                                                                            fki5.O00000Oo("rnSdkApiLevel", Long.valueOf(O000000o2.f598O000000o));
                                                                                            hsi.O000000o("plugin manager start to download plugin");
                                                                                            fkl.O000000o(fki5);
                                                                                            fkl.O000000o(O000000o2.f598O000000o, (fki) null);
                                                                                            hsi.O000000o("found sdk", Long.valueOf(longValue), " matched ", Long.valueOf(O000000o2.f598O000000o), O000000o2.O00000o0);
                                                                                        }
                                                                                    } else {
                                                                                        fkl.O000000o(fki5);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        if (fki5.O0000Oo() != null) {
                                                                            fkl.O00000o("startPluginDownloadTaskInternal validate ".concat(String.valueOf(fki5)));
                                                                            fki5.O0000Oo().O000000o(fki5, -662);
                                                                        }
                                                                        if (!str3.equalsIgnoreCase(fki5.O00000o())) {
                                                                        }
                                                                    }
                                                                    fkl.O00000o("downloadPluginInternal start download package  - ".concat(String.valueOf(j4)));
                                                                } else {
                                                                    fkl.O00000o("downloadPluginInternal tempDownloadImmediately false");
                                                                }
                                                            } else {
                                                                this.O00000Oo.O000000o(str, -661);
                                                            }
                                                        } else if (Arrays.binarySearch(DeviceConstant.supportNativePlugin(), str) >= 0) {
                                                            this.O00000Oo.O000000o(str);
                                                        } else {
                                                            this.O00000Oo.O000000o((String) null, -666);
                                                            fkl.O00000o("downloadPluginInternal updatePlugin result is null model:".concat(String.valueOf(str)));
                                                            fkl.O000000o("download_plugin", (fki) entry.getValue(), -1007, 0);
                                                        }
                                                    }
                                                }

                                                public final void onFailure(fdg fdg) {
                                                    StringBuilder sb = new StringBuilder("downloadPluginInternal fetch plugin error, ");
                                                    sb.append(fdg == null ? "" : fdg.toString());
                                                    fkl.O00000o(sb.toString());
                                                    this.O00000Oo.O000000o((String) null, -662);
                                                    int i = fdg.f16100O000000o;
                                                    Iterator it = this.f16521O000000o.entrySet().iterator();
                                                    if (it.hasNext()) {
                                                        Map.Entry entry = (Map.Entry) it.next();
                                                        if (i > 0) {
                                                            fkl.O000000o("download_plugin", (fki) entry.getValue(), -10000 - i);
                                                        } else {
                                                            fkl.O000000o("download_plugin", (fki) entry.getValue(), i - 200000);
                                                        }
                                                    }
                                                }
                                            });
                                        }
                                    }.execute();
                                } else if (iClientCallback != null) {
                                    try {
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putParcelable("error", new PluginError(-3, "core service permission deny"));
                                        iClientCallback.onFailure(bundle2);
                                    } catch (RemoteException e2) {
                                        Log.e("CoreApiStub", "fatal", e2);
                                    }
                                }
                            }

                            public void deletePlugin(final String str, final IClientCallback iClientCallback) throws RemoteException {
                                if (fcy.O000000o().O000000o(getCallingPid())) {
                                    new CoreAsyncTask() {
                                        /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass29 */

                                        public void onCancel() {
                                        }

                                        public void run() {
                                            fkl O000000o2 = fkl.O000000o();
                                            String str = str;
                                            AnonymousClass1 r2 = new fkl.O0000OOo() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass29.AnonymousClass1 */

                                                public final void O000000o(String str) {
                                                    if (iClientCallback != null) {
                                                        try {
                                                            iClientCallback.onSuccess(new Bundle());
                                                        } catch (RemoteException e) {
                                                            Log.e("CoreApiStub", "fatal", e);
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                }

                                                public final void O00000Oo(String str) {
                                                    if (iClientCallback != null) {
                                                        try {
                                                            iClientCallback.onFailure(new Bundle());
                                                        } catch (RemoteException e) {
                                                            Log.e("CoreApiStub", "fatal", e);
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                }
                                            };
                                            if (!O000000o2.O00000o0()) {
                                                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "deletePlugin failed, not init");
                                                r2.O00000Oo("not init");
                                                return;
                                            }
                                            O000000o2.O0000O0o.obtainMessage(26, new Object[]{str, new fkl.O0000OOo(r2) {
                                                /* class _m_j.fkl.AnonymousClass7 */

                                                /* renamed from: O000000o  reason: collision with root package name */
                                                final /* synthetic */ O0000OOo f16531O000000o;

                                                {
                                                    this.f16531O000000o = r2;
                                                }

                                                public final void O000000o(String str) {
                                                    fkl.this.O00000oO.post(
                                                    /*  JADX ERROR: Method code generation error
                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
                                                          (wrap: android.os.Handler : 0x0002: IGET  (r0v1 android.os.Handler) = (wrap: _m_j.fkl : 0x0000: IGET  (r0v0 _m_j.fkl) = (r3v0 'this' _m_j.fkl$7 A[THIS]) _m_j.fkl.7.O00000Oo _m_j.fkl) _m_j.fkl.O00000oO android.os.Handler)
                                                          (wrap: _m_j.-$$Lambda$fkl$7$e3m9eKSi2nIdu-Qc4PZTqqMak8M : 0x0008: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$7$e3m9eKSi2nIdu-Qc4PZTqqMak8M) = 
                                                          (wrap: _m_j.fkl$O0000OOo : 0x0004: IGET  (r1v0 _m_j.fkl$O0000OOo) = (r3v0 'this' _m_j.fkl$7 A[THIS]) _m_j.fkl.7.O000000o _m_j.fkl$O0000OOo)
                                                          (r4v0 'str' java.lang.String)
                                                         call: _m_j.-$$Lambda$fkl$7$e3m9eKSi2nIdu-Qc4PZTqqMak8M.<init>(_m_j.fkl$O0000OOo, java.lang.String):void type: CONSTRUCTOR)
                                                         type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: _m_j.fkl.7.O000000o(java.lang.String):void, dex: classes7.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                        	at jadx.core.codegen.InsnGen.filledNewArray(InsnGen.java:595)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$7$e3m9eKSi2nIdu-Qc4PZTqqMak8M) = 
                                                          (wrap: _m_j.fkl$O0000OOo : 0x0004: IGET  (r1v0 _m_j.fkl$O0000OOo) = (r3v0 'this' _m_j.fkl$7 A[THIS]) _m_j.fkl.7.O000000o _m_j.fkl$O0000OOo)
                                                          (r4v0 'str' java.lang.String)
                                                         call: _m_j.-$$Lambda$fkl$7$e3m9eKSi2nIdu-Qc4PZTqqMak8M.<init>(_m_j.fkl$O0000OOo, java.lang.String):void type: CONSTRUCTOR in method: _m_j.fkl.7.O000000o(java.lang.String):void, dex: classes7.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                        	... 115 more
                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$fkl$7$e3m9eKSi2nIdu-Qc4PZTqqMak8M, state: NOT_LOADED
                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	... 121 more
                                                        */
                                                    /*
                                                        this = this;
                                                        _m_j.fkl r0 = _m_j.fkl.this
                                                        android.os.Handler r0 = r0.O00000oO
                                                        _m_j.fkl$O0000OOo r1 = r3.f16531O000000o
                                                        _m_j.-$$Lambda$fkl$7$e3m9eKSi2nIdu-Qc4PZTqqMak8M r2 = new _m_j.-$$Lambda$fkl$7$e3m9eKSi2nIdu-Qc4PZTqqMak8M
                                                        r2.<init>(r1, r4)
                                                        r0.post(r2)
                                                        return
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: _m_j.fkl.AnonymousClass7.O000000o(java.lang.String):void");
                                                }

                                                public final void O00000Oo(String str) {
                                                    fkl.this.O00000oO.post(
                                                    /*  JADX ERROR: Method code generation error
                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
                                                          (wrap: android.os.Handler : 0x0002: IGET  (r0v1 android.os.Handler) = (wrap: _m_j.fkl : 0x0000: IGET  (r0v0 _m_j.fkl) = (r3v0 'this' _m_j.fkl$7 A[THIS]) _m_j.fkl.7.O00000Oo _m_j.fkl) _m_j.fkl.O00000oO android.os.Handler)
                                                          (wrap: _m_j.-$$Lambda$fkl$7$3kIE2VtHWJAE56SP-jIEqS5LnVU : 0x0008: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$7$3kIE2VtHWJAE56SP-jIEqS5LnVU) = 
                                                          (wrap: _m_j.fkl$O0000OOo : 0x0004: IGET  (r1v0 _m_j.fkl$O0000OOo) = (r3v0 'this' _m_j.fkl$7 A[THIS]) _m_j.fkl.7.O000000o _m_j.fkl$O0000OOo)
                                                          (r4v0 'str' java.lang.String)
                                                         call: _m_j.-$$Lambda$fkl$7$3kIE2VtHWJAE56SP-jIEqS5LnVU.<init>(_m_j.fkl$O0000OOo, java.lang.String):void type: CONSTRUCTOR)
                                                         type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: _m_j.fkl.7.O00000Oo(java.lang.String):void, dex: classes7.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                        	at jadx.core.codegen.InsnGen.filledNewArray(InsnGen.java:595)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$7$3kIE2VtHWJAE56SP-jIEqS5LnVU) = 
                                                          (wrap: _m_j.fkl$O0000OOo : 0x0004: IGET  (r1v0 _m_j.fkl$O0000OOo) = (r3v0 'this' _m_j.fkl$7 A[THIS]) _m_j.fkl.7.O000000o _m_j.fkl$O0000OOo)
                                                          (r4v0 'str' java.lang.String)
                                                         call: _m_j.-$$Lambda$fkl$7$3kIE2VtHWJAE56SP-jIEqS5LnVU.<init>(_m_j.fkl$O0000OOo, java.lang.String):void type: CONSTRUCTOR in method: _m_j.fkl.7.O00000Oo(java.lang.String):void, dex: classes7.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                        	... 115 more
                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$fkl$7$3kIE2VtHWJAE56SP-jIEqS5LnVU, state: NOT_LOADED
                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	... 121 more
                                                        */
                                                    /*
                                                        this = this;
                                                        _m_j.fkl r0 = _m_j.fkl.this
                                                        android.os.Handler r0 = r0.O00000oO
                                                        _m_j.fkl$O0000OOo r1 = r3.f16531O000000o
                                                        _m_j.-$$Lambda$fkl$7$3kIE2VtHWJAE56SP-jIEqS5LnVU r2 = new _m_j.-$$Lambda$fkl$7$3kIE2VtHWJAE56SP-jIEqS5LnVU
                                                        r2.<init>(r1, r4)
                                                        r0.post(r2)
                                                        return
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: _m_j.fkl.AnonymousClass7.O00000Oo(java.lang.String):void");
                                                }
                                            }}).sendToTarget();
                                        }
                                    }.execute();
                                } else if (iClientCallback != null) {
                                    try {
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("error", new NetError(-2, "core service : process not register"));
                                        iClientCallback.onFailure(bundle);
                                    } catch (RemoteException e) {
                                        Log.e("CoreApiStub", "fatal", e);
                                    }
                                }
                            }

                            public void installPlugin(final String str, final boolean z, final IClientCallback iClientCallback) throws RemoteException {
                                int callingPid = getCallingPid();
                                int callingUid = getCallingUid();
                                if (!fcy.O000000o().O000000o(callingPid)) {
                                    if (iClientCallback != null) {
                                        try {
                                            Bundle bundle = new Bundle();
                                            bundle.putParcelable("error", new PluginError(-2, "core service : process not register"));
                                            iClientCallback.onFailure(bundle);
                                        } catch (RemoteException e) {
                                            Log.e("CoreApiStub", "fatal", e);
                                        }
                                    }
                                } else if (flq.O000000o().O000000o(callingPid, callingUid)) {
                                    new CoreAsyncTask() {
                                        /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass30 */

                                        public void onCancel() {
                                        }

                                        public void run() {
                                            long j;
                                            long j2;
                                            AnonymousClass1 r1 = new fkj() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass30.AnonymousClass1 */

                                                public final void O000000o(String str) {
                                                    if (iClientCallback != null) {
                                                        Bundle bundle = new Bundle();
                                                        InstallPluginResult installPluginResult = new InstallPluginResult();
                                                        installPluginResult.f6735O000000o = 1;
                                                        installPluginResult.O00000Oo = str;
                                                        bundle.putParcelable("result", installPluginResult);
                                                        try {
                                                            iClientCallback.onSuccess(bundle);
                                                        } catch (RemoteException e) {
                                                            Log.e("CoreApiStub", "fatal", e);
                                                        }
                                                    }
                                                }

                                                public final void O00000Oo(String str) {
                                                    if (iClientCallback != null) {
                                                        Bundle bundle = new Bundle();
                                                        InstallPluginResult installPluginResult = new InstallPluginResult();
                                                        installPluginResult.f6735O000000o = 2;
                                                        installPluginResult.O00000Oo = str;
                                                        bundle.putParcelable("result", installPluginResult);
                                                        try {
                                                            iClientCallback.onSuccess(bundle);
                                                        } catch (RemoteException e) {
                                                            Log.e("CoreApiStub", "fatal", e);
                                                            Log.e("fatal", "onSuccess", e);
                                                        }
                                                    }
                                                }

                                                public final void O000000o(String str, int i) {
                                                    if (iClientCallback != null) {
                                                        Bundle bundle = new Bundle();
                                                        bundle.putParcelable("error", new PluginError(i, "install fail"));
                                                        try {
                                                            iClientCallback.onFailure(bundle);
                                                        } catch (RemoteException e) {
                                                            Log.e("CoreApiStub", "fatal", e);
                                                        }
                                                    }
                                                }
                                            };
                                            fkl O000000o2 = fkl.O000000o();
                                            String str = str;
                                            fkl.O00000o("1-installPlugin...".concat(String.valueOf(str)));
                                            if (!O000000o2.O00000o0()) {
                                                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "installPlugin failed, not init");
                                                r1.O000000o("", -1);
                                                return;
                                            }
                                            fkl.AnonymousClass9 r11 = new fkj(r1, str) {
                                                /* class _m_j.fkl.AnonymousClass9 */

                                                /* renamed from: O000000o  reason: collision with root package name */
                                                final /* synthetic */ fkj f16533O000000o;
                                                final /* synthetic */ String O00000Oo;

                                                {
                                                    this.f16533O000000o = r2;
                                                    this.O00000Oo = r3;
                                                }

                                                public final void O000000o(String str) {
                                                    if (this.f16533O000000o != null) {
                                                        fkl.this.O00000oO.post(
                                                        /*  JADX ERROR: Method code generation error
                                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                                                              (wrap: android.os.Handler : 0x0006: IGET  (r0v2 android.os.Handler) = (wrap: _m_j.fkl : 0x0004: IGET  (r0v1 _m_j.fkl) = (r3v0 'this' _m_j.fkl$9 A[THIS]) _m_j.fkl.9.O00000o0 _m_j.fkl) _m_j.fkl.O00000oO android.os.Handler)
                                                              (wrap: _m_j.-$$Lambda$fkl$9$6vOE1_ifhppN3BZr5siekdRP5-8 : 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$9$6vOE1_ifhppN3BZr5siekdRP5-8) = 
                                                              (wrap: _m_j.fkj : 0x0008: IGET  (r1v0 _m_j.fkj) = (r3v0 'this' _m_j.fkl$9 A[THIS]) _m_j.fkl.9.O000000o _m_j.fkj)
                                                              (r4v0 'str' java.lang.String)
                                                             call: _m_j.-$$Lambda$fkl$9$6vOE1_ifhppN3BZr5siekdRP5-8.<init>(_m_j.fkj, java.lang.String):void type: CONSTRUCTOR)
                                                             type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: _m_j.fkl.9.O000000o(java.lang.String):void, dex: classes7.dex
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$9$6vOE1_ifhppN3BZr5siekdRP5-8) = 
                                                              (wrap: _m_j.fkj : 0x0008: IGET  (r1v0 _m_j.fkj) = (r3v0 'this' _m_j.fkl$9 A[THIS]) _m_j.fkl.9.O000000o _m_j.fkj)
                                                              (r4v0 'str' java.lang.String)
                                                             call: _m_j.-$$Lambda$fkl$9$6vOE1_ifhppN3BZr5siekdRP5-8.<init>(_m_j.fkj, java.lang.String):void type: CONSTRUCTOR in method: _m_j.fkl.9.O000000o(java.lang.String):void, dex: classes7.dex
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                            	... 107 more
                                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$fkl$9$6vOE1_ifhppN3BZr5siekdRP5-8, state: NOT_LOADED
                                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                            	... 113 more
                                                            */
                                                        /*
                                                            this = this;
                                                            _m_j.fkj r0 = r3.f16533O000000o
                                                            if (r0 == 0) goto L_0x0012
                                                            _m_j.fkl r0 = _m_j.fkl.this
                                                            android.os.Handler r0 = r0.O00000oO
                                                            _m_j.fkj r1 = r3.f16533O000000o
                                                            _m_j.-$$Lambda$fkl$9$6vOE1_ifhppN3BZr5siekdRP5-8 r2 = new _m_j.-$$Lambda$fkl$9$6vOE1_ifhppN3BZr5siekdRP5-8
                                                            r2.<init>(r1, r4)
                                                            r0.post(r2)
                                                        L_0x0012:
                                                            return
                                                        */
                                                        throw new UnsupportedOperationException("Method not decompiled: _m_j.fkl.AnonymousClass9.O000000o(java.lang.String):void");
                                                    }

                                                    public final void O00000Oo(String str) {
                                                        fkl.O000000o(this.O00000Oo, 0);
                                                        if (this.f16533O000000o != null) {
                                                            fkl.this.O00000oO.post(
                                                            /*  JADX ERROR: Method code generation error
                                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                                                                  (wrap: android.os.Handler : 0x000c: IGET  (r0v3 android.os.Handler) = (wrap: _m_j.fkl : 0x000a: IGET  (r0v2 _m_j.fkl) = (r3v0 'this' _m_j.fkl$9 A[THIS]) _m_j.fkl.9.O00000o0 _m_j.fkl) _m_j.fkl.O00000oO android.os.Handler)
                                                                  (wrap: _m_j.-$$Lambda$fkl$9$EshJfjnDWfN5KhVcjV6ipKvrOaw : 0x0012: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$9$EshJfjnDWfN5KhVcjV6ipKvrOaw) = 
                                                                  (wrap: _m_j.fkj : 0x000e: IGET  (r1v1 _m_j.fkj) = (r3v0 'this' _m_j.fkl$9 A[THIS]) _m_j.fkl.9.O000000o _m_j.fkj)
                                                                  (r4v0 'str' java.lang.String)
                                                                 call: _m_j.-$$Lambda$fkl$9$EshJfjnDWfN5KhVcjV6ipKvrOaw.<init>(_m_j.fkj, java.lang.String):void type: CONSTRUCTOR)
                                                                 type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: _m_j.fkl.9.O00000Oo(java.lang.String):void, dex: classes7.dex
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$9$EshJfjnDWfN5KhVcjV6ipKvrOaw) = 
                                                                  (wrap: _m_j.fkj : 0x000e: IGET  (r1v1 _m_j.fkj) = (r3v0 'this' _m_j.fkl$9 A[THIS]) _m_j.fkl.9.O000000o _m_j.fkj)
                                                                  (r4v0 'str' java.lang.String)
                                                                 call: _m_j.-$$Lambda$fkl$9$EshJfjnDWfN5KhVcjV6ipKvrOaw.<init>(_m_j.fkj, java.lang.String):void type: CONSTRUCTOR in method: _m_j.fkl.9.O00000Oo(java.lang.String):void, dex: classes7.dex
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                	... 107 more
                                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$fkl$9$EshJfjnDWfN5KhVcjV6ipKvrOaw, state: NOT_LOADED
                                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                	... 113 more
                                                                */
                                                            /*
                                                                this = this;
                                                                java.lang.String r0 = r3.O00000Oo
                                                                r1 = 0
                                                                _m_j.fkl.O000000o(r0, r1)
                                                                _m_j.fkj r0 = r3.f16533O000000o
                                                                if (r0 == 0) goto L_0x0018
                                                                _m_j.fkl r0 = _m_j.fkl.this
                                                                android.os.Handler r0 = r0.O00000oO
                                                                _m_j.fkj r1 = r3.f16533O000000o
                                                                _m_j.-$$Lambda$fkl$9$EshJfjnDWfN5KhVcjV6ipKvrOaw r2 = new _m_j.-$$Lambda$fkl$9$EshJfjnDWfN5KhVcjV6ipKvrOaw
                                                                r2.<init>(r1, r4)
                                                                r0.post(r2)
                                                            L_0x0018:
                                                                return
                                                            */
                                                            throw new UnsupportedOperationException("Method not decompiled: _m_j.fkl.AnonymousClass9.O00000Oo(java.lang.String):void");
                                                        }

                                                        public final void O000000o(String str, int i) {
                                                            fkl.O000000o(this.O00000Oo, -1);
                                                            if (this.f16533O000000o != null) {
                                                                fkl.this.O00000oO.post(
                                                                /*  JADX ERROR: Method code generation error
                                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                                                                      (wrap: android.os.Handler : 0x000c: IGET  (r0v3 android.os.Handler) = (wrap: _m_j.fkl : 0x000a: IGET  (r0v2 _m_j.fkl) = (r3v0 'this' _m_j.fkl$9 A[THIS]) _m_j.fkl.9.O00000o0 _m_j.fkl) _m_j.fkl.O00000oO android.os.Handler)
                                                                      (wrap: _m_j.-$$Lambda$fkl$9$pI99cOQgbu6wUy7xU87GoIfH_vY : 0x0012: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$9$pI99cOQgbu6wUy7xU87GoIfH_vY) = 
                                                                      (wrap: _m_j.fkj : 0x000e: IGET  (r1v1 _m_j.fkj) = (r3v0 'this' _m_j.fkl$9 A[THIS]) _m_j.fkl.9.O000000o _m_j.fkj)
                                                                      (r4v0 'str' java.lang.String)
                                                                      (r5v0 'i' int)
                                                                     call: _m_j.-$$Lambda$fkl$9$pI99cOQgbu6wUy7xU87GoIfH_vY.<init>(_m_j.fkj, java.lang.String, int):void type: CONSTRUCTOR)
                                                                     type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: _m_j.fkl.9.O000000o(java.lang.String, int):void, dex: classes7.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r2v0 _m_j.-$$Lambda$fkl$9$pI99cOQgbu6wUy7xU87GoIfH_vY) = 
                                                                      (wrap: _m_j.fkj : 0x000e: IGET  (r1v1 _m_j.fkj) = (r3v0 'this' _m_j.fkl$9 A[THIS]) _m_j.fkl.9.O000000o _m_j.fkj)
                                                                      (r4v0 'str' java.lang.String)
                                                                      (r5v0 'i' int)
                                                                     call: _m_j.-$$Lambda$fkl$9$pI99cOQgbu6wUy7xU87GoIfH_vY.<init>(_m_j.fkj, java.lang.String, int):void type: CONSTRUCTOR in method: _m_j.fkl.9.O000000o(java.lang.String, int):void, dex: classes7.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                    	... 107 more
                                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$fkl$9$pI99cOQgbu6wUy7xU87GoIfH_vY, state: NOT_LOADED
                                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                    	... 113 more
                                                                    */
                                                                /*
                                                                    this = this;
                                                                    java.lang.String r0 = r3.O00000Oo
                                                                    r1 = -1
                                                                    _m_j.fkl.O000000o(r0, r1)
                                                                    _m_j.fkj r0 = r3.f16533O000000o
                                                                    if (r0 == 0) goto L_0x0018
                                                                    _m_j.fkl r0 = _m_j.fkl.this
                                                                    android.os.Handler r0 = r0.O00000oO
                                                                    _m_j.fkj r1 = r3.f16533O000000o
                                                                    _m_j.-$$Lambda$fkl$9$pI99cOQgbu6wUy7xU87GoIfH_vY r2 = new _m_j.-$$Lambda$fkl$9$pI99cOQgbu6wUy7xU87GoIfH_vY
                                                                    r2.<init>(r1, r4, r5)
                                                                    r0.post(r2)
                                                                L_0x0018:
                                                                    return
                                                                */
                                                                throw new UnsupportedOperationException("Method not decompiled: _m_j.fkl.AnonymousClass9.O000000o(java.lang.String, int):void");
                                                            }
                                                        };
                                                        PluginPackageInfo pluginPackageInfo = O000000o2.O0000Oo0.get(str);
                                                        r11.O000000o(str);
                                                        if (DynamicFeatureManager.instance.isDynamicFeature(str)) {
                                                            DynamicFeatureManager.instance.installPlugin(str, new DynamicFeatureManager.O000000o(str, r11, str) {
                                                                /* class _m_j.fkl.AnonymousClass1 */

                                                                /* renamed from: O000000o  reason: collision with root package name */
                                                                final /* synthetic */ fkj f16520O000000o;
                                                                final /* synthetic */ String O00000Oo;

                                                                {
                                                                    this.f16520O000000o = r3;
                                                                    this.O00000Oo = r4;
                                                                }

                                                                public final void onSuccess(String str, PluginPackageInfo pluginPackageInfo) {
                                                                    fkl.this.O000000o(pluginPackageInfo);
                                                                    fkj fkj = this.f16520O000000o;
                                                                    if (fkj != null) {
                                                                        fkj.O00000Oo(this.O00000Oo);
                                                                    }
                                                                }

                                                                public final void onFailure(String str, int i) {
                                                                    fkj fkj = this.f16520O000000o;
                                                                    if (fkj != null) {
                                                                        fkj.O000000o(this.O00000Oo, -712);
                                                                    }
                                                                }
                                                            });
                                                        } else if (pluginPackageInfo == null) {
                                                            fkl.O00000o("installPlugin onFailure downInfo == null record:".concat(String.valueOf(str)));
                                                            fkl.O00000Oo(str, -1001);
                                                            r11.O000000o(str, -703);
                                                        } else if (pluginPackageInfo.O00000Oo() <= 0) {
                                                            fkl.O00000o("installPluginInternal installingPackageInfo is null pluginRecord:" + str + "  installingPackageInfo:" + pluginPackageInfo);
                                                            fkl.O00000Oo(str, -1002);
                                                            r11.O000000o(str, -703);
                                                        } else if (pluginPackageInfo.O0000Ooo()) {
                                                        } else {
                                                            if (pluginPackageInfo.O0000o0O()) {
                                                                long O000000o3 = pluginPackageInfo.O000000o();
                                                                long O00000Oo = pluginPackageInfo.O00000Oo();
                                                                String O000000o4 = O000000o2.O000000o(O000000o3, O00000Oo);
                                                                if (!new File(O000000o4, "android").exists()) {
                                                                    j2 = O00000Oo;
                                                                    j = O000000o3;
                                                                    O000000o4 = O000000o2.O000000o(O000000o3, O00000Oo, "rn");
                                                                } else {
                                                                    j2 = O00000Oo;
                                                                    j = O000000o3;
                                                                }
                                                                String str2 = O000000o4;
                                                                fkl fkl = O000000o2;
                                                                long j3 = j;
                                                                long j4 = j2;
                                                                String O00000Oo2 = fkl.O00000Oo(j3, j4, "rn");
                                                                if (!fkl.O000000o(j3, j4, str2, O00000Oo2)) {
                                                                    fkl.O00000o("installPluginInternal installRNPackage false pluginRecord:" + str + "  installedPackagePath:" + O00000Oo2);
                                                                    fkl.O00000Oo(str, -1005);
                                                                    r11.O000000o(str, -704);
                                                                    return;
                                                                }
                                                                String str3 = O00000Oo2;
                                                                PluginPackageInfo O000000o5 = fky.O000000o(O000000o2.O00000o0, j, j2, "rn", str3);
                                                                if (O000000o5 == null) {
                                                                    fkl.O00000o("installPluginInternal rawInfo is null pluginRecord:" + str + "  installedPackagePath:" + str3);
                                                                    fkl.O00000Oo(str, -1006);
                                                                    fkw.O00000Oo(str3);
                                                                    r11.O000000o(str, -702);
                                                                    return;
                                                                }
                                                                O000000o2.O000000o(O000000o5);
                                                                try {
                                                                    JSONObject jSONObject = new JSONObject();
                                                                    jSONObject.put("plugin_id", j);
                                                                    jSONObject.put("package_id", j2);
                                                                    jSONObject.put("package_type", "rn");
                                                                    fld.O00000o0().O000000o(StatType.EVENT.getValue(), "mihome", "plugin_install_success", jSONObject.toString(), null, false);
                                                                } catch (Exception unused) {
                                                                }
                                                                fkl.O00000o("install package success - " + pluginPackageInfo.O00000Oo());
                                                                r11.O00000Oo(str);
                                                            } else if (Arrays.binarySearch(DeviceConstant.supportNativePlugin(), str) >= 0) {
                                                                r11.O00000Oo(str);
                                                            } else if (pluginPackageInfo.O0000o00()) {
                                                            } else {
                                                                if (pluginPackageInfo.O0000o0()) {
                                                                    fkl.O00000o("start install package, model - " + str + ", package id - " + pluginPackageInfo.O00000Oo());
                                                                    long O000000o6 = pluginPackageInfo.O000000o();
                                                                    long O00000Oo3 = pluginPackageInfo.O00000Oo();
                                                                    String O0000O0o = pluginPackageInfo.O0000O0o();
                                                                    String O00000o = pluginPackageInfo.O00000o();
                                                                    long j5 = O00000Oo3;
                                                                    long j6 = O000000o6;
                                                                    String O00000Oo4 = O000000o2.O00000Oo(O000000o6, j5, O0000O0o);
                                                                    fkw.O00000Oo(O00000o, O00000Oo4);
                                                                    PluginPackageInfo O000000o7 = fky.O000000o(O000000o2.O00000o0, j6, j5, O0000O0o, O00000Oo4);
                                                                    if (O000000o7 == null) {
                                                                        fkw.O00000Oo(O00000Oo4);
                                                                        fkl.O00000o("installPluginInternal isMinApiLevelValid RN rawInfo is null pluginRecord:" + str + "  installingPackageInfo:" + pluginPackageInfo);
                                                                        r11.O000000o(str, -710);
                                                                    } else if (!fky.O000000o(O000000o7)) {
                                                                        fkw.O00000Oo(O00000Oo4);
                                                                        fkl.O00000o("installPluginInternal validatePackage  model:" + str + "  rawInfo:" + O000000o7);
                                                                        r11.O000000o(str, -707);
                                                                    } else {
                                                                        fkm.O000000o();
                                                                        fkm.O000000o(O000000o2.O00000o0, j6, j5, O00000Oo4);
                                                                        O000000o2.O000000o(O000000o7);
                                                                        try {
                                                                            JSONObject jSONObject2 = new JSONObject();
                                                                            jSONObject2.put("plugin_id", j6);
                                                                            jSONObject2.put("package_id", j5);
                                                                            fld.O00000o0().O000000o(StatType.EVENT.getValue(), "mihome", "plugin_install_success", jSONObject2.toString(), null, false);
                                                                        } catch (Exception unused2) {
                                                                        }
                                                                        fcx.f16092O000000o.O000000o(O000000o7);
                                                                        fkl.O00000o("install package success - " + pluginPackageInfo.O00000Oo());
                                                                        r11.O00000Oo(str);
                                                                    }
                                                                } else {
                                                                    fkl.O00000o("installPluginInternal not rn nor mpk pluginRecord:".concat(String.valueOf(str)));
                                                                    r11.O000000o(str, -711);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }.execute();
                                            } else if (iClientCallback != null) {
                                                try {
                                                    Bundle bundle2 = new Bundle();
                                                    bundle2.putParcelable("error", new PluginError(-3, "core service permission deny"));
                                                    iClientCallback.onFailure(bundle2);
                                                } catch (RemoteException e2) {
                                                    Log.e("CoreApiStub", "fatal", e2);
                                                }
                                            }
                                        }

                                        public void updateRnSdk(final long j, final IClientCallback iClientCallback) throws RemoteException {
                                            int callingPid = getCallingPid();
                                            int callingUid = getCallingUid();
                                            if (!fcy.O000000o().O000000o(callingPid)) {
                                                if (iClientCallback != null) {
                                                    try {
                                                        Bundle bundle = new Bundle();
                                                        bundle.putParcelable("error", new DownloadRnSdkResult(-2, "core service : process not register"));
                                                        iClientCallback.onFailure(bundle);
                                                    } catch (RemoteException e) {
                                                        Log.e("CoreApiStub", "fatal", e);
                                                    }
                                                }
                                            } else if (flq.O000000o().O000000o(callingPid, callingUid)) {
                                                new CoreAsyncTask() {
                                                    /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass31 */

                                                    public void onCancel() {
                                                    }

                                                    public void run() {
                                                        fkl O000000o2 = fkl.O000000o();
                                                        long j = j;
                                                        AnonymousClass1 r3 = new fkl.O0000Oo0() {
                                                            /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass31.AnonymousClass1 */

                                                            public final void O000000o(DownloadRnSdkResult downloadRnSdkResult) {
                                                                if (iClientCallback != null) {
                                                                    Bundle bundle = new Bundle();
                                                                    bundle.putParcelable("result", downloadRnSdkResult);
                                                                    try {
                                                                        iClientCallback.onSuccess(bundle);
                                                                    } catch (RemoteException e) {
                                                                        Log.e("CoreApiStub", "fatal", e);
                                                                    }
                                                                }
                                                            }

                                                            public final void O00000Oo(DownloadRnSdkResult downloadRnSdkResult) {
                                                                if (iClientCallback != null) {
                                                                    Bundle bundle = new Bundle();
                                                                    bundle.putParcelable("error", downloadRnSdkResult);
                                                                    try {
                                                                        iClientCallback.onFailure(bundle);
                                                                    } catch (RemoteException e) {
                                                                        Log.e("CoreApiStub", "fatal", e);
                                                                    }
                                                                }
                                                            }
                                                        };
                                                        if (!O000000o2.O00000o0()) {
                                                            gsy.O00000o0(LogType.PLUGIN, "PluginManager", "checkToUpdateRnSdk failed, not init");
                                                            r3.O00000Oo(new DownloadRnSdkResult(-1, "not init"));
                                                            return;
                                                        }
                                                        fkl.O0000Oo o0000Oo = O000000o2.O0000Oo.get(Long.valueOf(j));
                                                        if (o0000Oo != null) {
                                                            o0000Oo.O0000Oo = r3;
                                                            if (o0000Oo.O0000O0o == 1) {
                                                                o0000Oo.O0000O0o = 0;
                                                            }
                                                            O000000o2.O000000o(o0000Oo);
                                                            return;
                                                        }
                                                        fkl.O0000Oo o0000Oo2 = new fkl.O0000Oo();
                                                        o0000Oo2.O0000Oo = r3;
                                                        o0000Oo2.O00000o0 = 0;
                                                        String string = O000000o2.O00000o.getString(fkl.O000000o(j), "");
                                                        if (!TextUtils.isEmpty(string) && string.startsWith("#")) {
                                                            long O000000o3 = hhc.O000000o((Object) string.substring(1));
                                                            if (O000000o3 > 0 && O000000o2.O00000Oo(j)) {
                                                                o0000Oo2.O00000o0 = O000000o3;
                                                            }
                                                        }
                                                        o0000Oo2.O00000Oo = j;
                                                        o0000Oo2.O0000O0o = 0;
                                                        O000000o2.O0000Oo.put(Long.valueOf(o0000Oo2.O00000Oo), o0000Oo2);
                                                        O000000o2.O000000o(o0000Oo2);
                                                    }
                                                }.execute();
                                            } else if (iClientCallback != null) {
                                                try {
                                                    Bundle bundle2 = new Bundle();
                                                    bundle2.putParcelable("error", new DownloadRnSdkResult(-1, "core service permission deny"));
                                                    iClientCallback.onFailure(bundle2);
                                                } catch (RemoteException e2) {
                                                    Log.e("CoreApiStub", "fatal", e2);
                                                }
                                            }
                                        }

                                        public void getLatestPluginInfo(final String str, final IClientCallback iClientCallback) throws RemoteException {
                                            int callingPid = getCallingPid();
                                            int callingUid = getCallingUid();
                                            if (!fcy.O000000o().O000000o(callingPid)) {
                                                if (iClientCallback != null) {
                                                    try {
                                                        Bundle bundle = new Bundle();
                                                        bundle.putParcelable("error", new PluginError(-2, "core service : process not register"));
                                                        iClientCallback.onFailure(bundle);
                                                    } catch (RemoteException e) {
                                                        Log.e("CoreApiStub", "fatal", e);
                                                    }
                                                }
                                            } else if (flq.O000000o().O000000o(callingPid, callingUid)) {
                                                new CoreAsyncTask() {
                                                    /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass32 */

                                                    public void onCancel() {
                                                    }

                                                    public void run() {
                                                        fkl O000000o2 = fkl.O000000o();
                                                        String str = str;
                                                        AnonymousClass1 r2 = new fde<List<fkt>, fdg>() {
                                                            /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass32.AnonymousClass1 */

                                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                                List list = (List) obj;
                                                                if (list == null || list.size() == 0) {
                                                                    Bundle bundle = new Bundle();
                                                                    bundle.putParcelable("error", new PluginError(-3, "result is empty"));
                                                                    try {
                                                                        iClientCallback.onFailure(bundle);
                                                                    } catch (RemoteException unused) {
                                                                    }
                                                                } else {
                                                                    Bundle bundle2 = new Bundle();
                                                                    bundle2.putLong("packageId", ((fkt) list.get(0)).O00000o);
                                                                    bundle2.putInt("version", ((fkt) list.get(0)).O00000oo);
                                                                    try {
                                                                        iClientCallback.onSuccess(bundle2);
                                                                    } catch (RemoteException unused2) {
                                                                    }
                                                                }
                                                            }

                                                            public final void onFailure(fdg fdg) {
                                                                Bundle bundle = new Bundle();
                                                                bundle.putParcelable("error", new PluginError(fdg.f16100O000000o, fdg.O00000Oo));
                                                                try {
                                                                    iClientCallback.onFailure(bundle);
                                                                } catch (RemoteException unused) {
                                                                }
                                                            }
                                                        };
                                                        fko O000000o3 = fko.O000000o();
                                                        JSONArray put = new JSONArray().put(O000000o2.O000000o(str));
                                                        grr.O000000o();
                                                        O000000o3.O000000o(put, grr.O0000o0O(), r2);
                                                    }
                                                }.execute();
                                            } else if (iClientCallback != null) {
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putParcelable("error", new PluginError(-3, "core service : permission deny"));
                                                try {
                                                    iClientCallback.onFailure(bundle2);
                                                } catch (RemoteException e2) {
                                                    Log.e("CoreApiStub", "fatal", e2);
                                                }
                                            }
                                        }

                                        public void cancelPluginDownload(final String str, final PluginDownloadTask pluginDownloadTask, final IClientCallback iClientCallback) throws RemoteException {
                                            int callingPid = getCallingPid();
                                            int callingUid = getCallingUid();
                                            if (!fcy.O000000o().O000000o(callingPid)) {
                                                if (iClientCallback != null) {
                                                    try {
                                                        Bundle bundle = new Bundle();
                                                        bundle.putParcelable("error", new PluginError(-2, "core service : process not register"));
                                                        iClientCallback.onFailure(bundle);
                                                    } catch (RemoteException e) {
                                                        Log.e("CoreApiStub", "fatal", e);
                                                    }
                                                }
                                            } else if (flq.O000000o().O000000o(callingPid, callingUid)) {
                                                new CoreAsyncTask() {
                                                    /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass33 */

                                                    public void onCancel() {
                                                    }

                                                    public void run() {
                                                        AnonymousClass1 r0 = new fkf() {
                                                            /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass33.AnonymousClass1 */

                                                            public final void O000000o() {
                                                                if (iClientCallback != null) {
                                                                    try {
                                                                        iClientCallback.onSuccess(new Bundle());
                                                                    } catch (RemoteException e) {
                                                                        Log.e("CoreApiStub", "fatal", e);
                                                                    }
                                                                }
                                                            }

                                                            public final void O00000Oo() {
                                                                if (iClientCallback != null) {
                                                                    try {
                                                                        Bundle bundle = new Bundle();
                                                                        bundle.putParcelable("error", new PluginError(-999, ""));
                                                                        iClientCallback.onFailure(bundle);
                                                                    } catch (RemoteException e) {
                                                                        Log.e("CoreApiStub", "fatal", e);
                                                                    }
                                                                }
                                                            }
                                                        };
                                                        fkl O000000o2 = fkl.O000000o();
                                                        PluginDownloadTask pluginDownloadTask = pluginDownloadTask;
                                                        if (!O000000o2.O00000o0()) {
                                                            gsy.O00000o0(LogType.PLUGIN, "PluginManager", "cancelPluginDownload failed, not init");
                                                            r0.O00000Oo();
                                                            return;
                                                        }
                                                        fkg fkg = O000000o2.f16519O000000o;
                                                        if (pluginDownloadTask == null) {
                                                            r0.O00000Oo();
                                                            return;
                                                        }
                                                        List list = fkg.f16512O000000o.get(Long.valueOf(pluginDownloadTask.O00000o));
                                                        if (list != null) {
                                                            fki fki = null;
                                                            Iterator it = list.iterator();
                                                            while (true) {
                                                                if (!it.hasNext()) {
                                                                    break;
                                                                }
                                                                fki fki2 = (fki) it.next();
                                                                if (fki2.O000000o() == pluginDownloadTask.O00000oo) {
                                                                    fki = fki2;
                                                                    break;
                                                                }
                                                            }
                                                            if (fki == null) {
                                                                r0.O00000Oo();
                                                            } else if (list.size() > 1) {
                                                                if (fki.O0000Oo() != null) {
                                                                    fki.O0000Oo().O00000Oo(fki);
                                                                }
                                                                list.remove(fki);
                                                                r0.O000000o();
                                                            } else {
                                                                gsn O0000Oo0 = fki.O0000Oo0();
                                                                if (O0000Oo0 != null) {
                                                                    O0000Oo0.O000000o();
                                                                }
                                                                r0.O000000o();
                                                            }
                                                        } else {
                                                            r0.O00000Oo();
                                                        }
                                                    }
                                                }.execute();
                                            } else if (iClientCallback != null) {
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putParcelable("error", new PluginError(-3, "core service : permission deny"));
                                                try {
                                                    iClientCallback.onFailure(bundle2);
                                                } catch (RemoteException e2) {
                                                    Log.e("CoreApiStub", "fatal", e2);
                                                }
                                            }
                                        }

                                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
                                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo} */
                                        /* JADX WARNING: Multi-variable type inference failed */
                                        public PluginPackageInfo getPluginInstalledPackageInfo(long j) throws RemoteException {
                                            int callingPid = getCallingPid();
                                            int callingUid = getCallingUid();
                                            PluginPackageInfo pluginPackageInfo = null;
                                            if (!fcy.O000000o().O000000o(callingPid) || !flq.O000000o().O000000o(callingPid, callingUid)) {
                                                return null;
                                            }
                                            Iterator<Map.Entry<String, PluginPackageInfo>> it = fkl.O000000o().O0000OOo.entrySet().iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                Map.Entry next = it.next();
                                                if (((PluginPackageInfo) next.getValue()).O00000Oo() == j) {
                                                    pluginPackageInfo = next.getValue();
                                                    break;
                                                }
                                            }
                                            return pluginPackageInfo == null ? DynamicFeatureManager.instance.getDownloadPluginPackageInfo(j) : pluginPackageInfo;
                                        }

                                        public PluginPackageInfo getInstallPackageInfo(String str) throws RemoteException {
                                            int callingPid = getCallingPid();
                                            int callingUid = getCallingUid();
                                            if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
                                                return fkl.O000000o().O00000Oo(str);
                                            }
                                            return null;
                                        }

                                        public PluginPackageInfo getDownloadPackageInfo(String str) throws RemoteException {
                                            int callingPid = getCallingPid();
                                            int callingUid = getCallingUid();
                                            if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
                                                return fkl.O000000o().O00000o0(str);
                                            }
                                            return null;
                                        }

                                        public IServerHandle debugPluginPackage(final IClientCallback iClientCallback) throws RemoteException {
                                            if (fsr.O0000Oo0 || fsr.O0000O0o) {
                                                int callingPid = getCallingPid();
                                                int callingUid = getCallingUid();
                                                if (!fcy.O000000o().O000000o(callingPid)) {
                                                    if (iClientCallback != null) {
                                                        try {
                                                            Bundle bundle = new Bundle();
                                                            bundle.putParcelable("error", new PluginError(-2, "core service : process not register"));
                                                            iClientCallback.onFailure(bundle);
                                                        } catch (RemoteException e) {
                                                            Log.e("CoreApiStub", "fatal", e);
                                                        }
                                                    }
                                                    return null;
                                                } else if (!flq.O000000o().O000000o(callingPid, callingUid)) {
                                                    if (iClientCallback != null) {
                                                        Bundle bundle2 = new Bundle();
                                                        bundle2.putParcelable("error", new PluginError(-3, "core service : permission deny"));
                                                        try {
                                                            iClientCallback.onFailure(bundle2);
                                                        } catch (RemoteException e2) {
                                                            Log.e("CoreApiStub", "fatal", e2);
                                                        }
                                                    }
                                                    return null;
                                                } else {
                                                    AnonymousClass34 r0 = new CoreAsyncTask() {
                                                        /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass34 */

                                                        public void onCancel() {
                                                        }

                                                        public void run() {
                                                            fkl O000000o2 = fkl.O000000o();
                                                            AnonymousClass1 r1 = new fkl.O00000Oo() {
                                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass34.AnonymousClass1 */

                                                                public final void O000000o() {
                                                                    if (iClientCallback != null) {
                                                                        Bundle bundle = new Bundle();
                                                                        DownloadPluginDebugPackageResult downloadPluginDebugPackageResult = new DownloadPluginDebugPackageResult();
                                                                        downloadPluginDebugPackageResult.f6732O000000o = 1;
                                                                        bundle.putParcelable("result", downloadPluginDebugPackageResult);
                                                                        try {
                                                                            iClientCallback.onSuccess(bundle);
                                                                        } catch (RemoteException e) {
                                                                            Log.e("CoreApiStub", "fatal", e);
                                                                        }
                                                                    }
                                                                }

                                                                public final void O000000o(String str) {
                                                                    if (iClientCallback != null) {
                                                                        Bundle bundle = new Bundle();
                                                                        DownloadPluginDebugPackageResult downloadPluginDebugPackageResult = new DownloadPluginDebugPackageResult();
                                                                        downloadPluginDebugPackageResult.f6732O000000o = 2;
                                                                        downloadPluginDebugPackageResult.O00000Oo = str;
                                                                        bundle.putParcelable("result", downloadPluginDebugPackageResult);
                                                                        try {
                                                                            iClientCallback.onSuccess(bundle);
                                                                        } catch (RemoteException e) {
                                                                            Log.e("CoreApiStub", "fatal", e);
                                                                        }
                                                                    }
                                                                }

                                                                public final void O00000Oo() {
                                                                    if (iClientCallback != null) {
                                                                        Bundle bundle = new Bundle();
                                                                        DownloadPluginDebugPackageResult downloadPluginDebugPackageResult = new DownloadPluginDebugPackageResult();
                                                                        downloadPluginDebugPackageResult.f6732O000000o = 3;
                                                                        bundle.putParcelable("result", downloadPluginDebugPackageResult);
                                                                        try {
                                                                            iClientCallback.onSuccess(bundle);
                                                                        } catch (RemoteException e) {
                                                                            Log.e("CoreApiStub", "fatal", e);
                                                                        }
                                                                    }
                                                                }

                                                                public final void O00000Oo(String str) {
                                                                    if (iClientCallback != null) {
                                                                        Bundle bundle = new Bundle();
                                                                        DownloadPluginDebugPackageResult downloadPluginDebugPackageResult = new DownloadPluginDebugPackageResult();
                                                                        downloadPluginDebugPackageResult.f6732O000000o = 4;
                                                                        downloadPluginDebugPackageResult.O00000Oo = str;
                                                                        bundle.putParcelable("result", downloadPluginDebugPackageResult);
                                                                        try {
                                                                            iClientCallback.onSuccess(bundle);
                                                                        } catch (RemoteException e) {
                                                                            Log.e("CoreApiStub", "fatal", e);
                                                                        }
                                                                    }
                                                                }
                                                            };
                                                            if (!O000000o2.O00000o0()) {
                                                                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "downloadDebugPackage failed, not init");
                                                                r1.O000000o("not init");
                                                                return;
                                                            }
                                                            fkl.O0000O0o o0000O0o = new fkl.O0000O0o((byte) 0);
                                                            o0000O0o.f16535O000000o = new fkl.O00000o0(r1) {
                                                                /* class _m_j.fkl.AnonymousClass6 */

                                                                /* renamed from: O000000o  reason: collision with root package name */
                                                                final /* synthetic */ O00000Oo f16526O000000o;

                                                                {
                                                                    this.f16526O000000o = r2;
                                                                }

                                                                /* access modifiers changed from: package-private */
                                                                public final void O000000o() {
                                                                    if (this.f16526O000000o != null) {
                                                                        fkl.this.O00000oO.post(new Runnable() {
                                                                            /* class _m_j.fkl.AnonymousClass6.AnonymousClass1 */

                                                                            public final void run() {
                                                                                AnonymousClass6.this.f16526O000000o.O000000o();
                                                                            }
                                                                        });
                                                                    }
                                                                }

                                                                /* access modifiers changed from: package-private */
                                                                public final void O000000o(final String str) {
                                                                    if (this.f16526O000000o != null) {
                                                                        fkl.this.O00000oO.post(new Runnable() {
                                                                            /* class _m_j.fkl.AnonymousClass6.AnonymousClass2 */

                                                                            public final void run() {
                                                                                AnonymousClass6.this.f16526O000000o.O000000o(str);
                                                                            }
                                                                        });
                                                                    }
                                                                }

                                                                /* access modifiers changed from: package-private */
                                                                public final void O00000Oo() {
                                                                    if (this.f16526O000000o != null) {
                                                                        fkl.this.O00000oO.post(new Runnable() {
                                                                            /* class _m_j.fkl.AnonymousClass6.AnonymousClass3 */

                                                                            public final void run() {
                                                                                AnonymousClass6.this.f16526O000000o.O00000Oo();
                                                                            }
                                                                        });
                                                                    }
                                                                }

                                                                /* access modifiers changed from: package-private */
                                                                public final void O00000Oo(final String str) {
                                                                    if (this.f16526O000000o != null) {
                                                                        fkl.this.O00000oO.post(new Runnable() {
                                                                            /* class _m_j.fkl.AnonymousClass6.AnonymousClass4 */

                                                                            public final void run() {
                                                                                AnonymousClass6.this.f16526O000000o.O00000Oo(str);
                                                                            }
                                                                        });
                                                                    }
                                                                }
                                                            };
                                                            O000000o2.O0000O0o.obtainMessage(18, o0000O0o).sendToTarget();
                                                        }
                                                    };
                                                    r0.execute();
                                                    return r0;
                                                }
                                            } else {
                                                if (iClientCallback != null) {
                                                    try {
                                                        Bundle bundle3 = new Bundle();
                                                        bundle3.putParcelable("error", new PluginError(-999, "core service : only for debug or sdk"));
                                                        iClientCallback.onFailure(bundle3);
                                                    } catch (RemoteException e3) {
                                                        Log.e("CoreApiStub", "fatal", e3);
                                                    }
                                                }
                                                return null;
                                            }
                                        }

                                        public void dumpPlugin(final IClientCallback iClientCallback) throws RemoteException {
                                            int callingPid = getCallingPid();
                                            int callingUid = getCallingUid();
                                            if (!fcy.O000000o().O000000o(callingPid)) {
                                                if (iClientCallback != null) {
                                                    try {
                                                        Bundle bundle = new Bundle();
                                                        bundle.putParcelable("error", new PluginError(-2, "core service : process not register"));
                                                        iClientCallback.onFailure(bundle);
                                                    } catch (RemoteException e) {
                                                        Log.e("CoreApiStub", "fatal", e);
                                                    }
                                                }
                                            } else if (flq.O000000o().O000000o(callingPid, callingUid)) {
                                                new CoreAsyncTask() {
                                                    /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass35 */

                                                    public void onCancel() {
                                                    }

                                                    public void run() {
                                                        PluginDeviceManager.instance.dumpPlugin();
                                                        fkl O000000o2 = fkl.O000000o();
                                                        gsy.O000000o(3, "PluginManager", "-----------------------------dumpPlugin DownPluginPackageInfo--------------------------");
                                                        for (Map.Entry<String, PluginPackageInfo> value : O000000o2.O0000Oo0.entrySet()) {
                                                            gsy.O000000o(3, "PluginManager", ((PluginPackageInfo) value.getValue()).O0000o0o());
                                                        }
                                                        gsy.O000000o(3, "PluginManager", "-----------------------------dumpPlugin InstallPluginPackageInfo--------------------------");
                                                        for (Map.Entry<String, PluginPackageInfo> value2 : O000000o2.O0000OOo.entrySet()) {
                                                            gsy.O000000o(3, "PluginManager", ((PluginPackageInfo) value2.getValue()).O0000o0o());
                                                        }
                                                        if (iClientCallback != null) {
                                                            try {
                                                                iClientCallback.onSuccess(new Bundle());
                                                            } catch (RemoteException e) {
                                                                Log.e("CoreApiStub", "fatal", e);
                                                            }
                                                        }
                                                    }
                                                }.execute();
                                            } else if (iClientCallback != null) {
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putParcelable("error", new PluginError(-3, "core service : permission deny"));
                                                try {
                                                    iClientCallback.onFailure(bundle2);
                                                } catch (RemoteException e2) {
                                                    Log.e("CoreApiStub", "fatal", e2);
                                                }
                                            }
                                        }

                                        public void addStatRecord(StatType statType, String str, String str2, String str3, String str4, boolean z) throws RemoteException {
                                            if (!ftn.O0000O0o(CoreService.getAppContext())) {
                                                int callingPid = getCallingPid();
                                                int callingUid = getCallingUid();
                                                if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
                                                    final StatType statType2 = statType;
                                                    final String str5 = str2;
                                                    final String str6 = str;
                                                    final String str7 = str3;
                                                    final String str8 = str4;
                                                    final boolean z2 = z;
                                                    new CoreAsyncTask() {
                                                        /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass36 */

                                                        public void onCancel() {
                                                        }

                                                        public void run() {
                                                            if (statType2 != null && !TextUtils.isEmpty(str5)) {
                                                                fld.O00000o0().O000000o(statType2.getValue(), str6, str5, str7, str8, z2);
                                                            }
                                                        }
                                                    }.execute();
                                                }
                                            }
                                        }

                                        public boolean postStatRecord(final String str, final boolean z) throws RemoteException {
                                            if (!z && TextUtils.isEmpty(str)) {
                                                return false;
                                            }
                                            if (!fld.O000000o()) {
                                                if ("~#INITIALIZE#~".equals(str)) {
                                                    return fld.O00000Oo();
                                                }
                                                return false;
                                            } else if ("~#INITIALIZE#~".equals(str)) {
                                                return true;
                                            } else {
                                                int callingPid = getCallingPid();
                                                int callingUid = getCallingUid();
                                                if (!fcy.O000000o().O000000o(callingPid) || !flq.O000000o().O000000o(callingPid, callingUid)) {
                                                    return false;
                                                }
                                                new CoreAsyncTask() {
                                                    /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass37 */

                                                    public void onCancel() {
                                                    }

                                                    public void run() {
                                                        fld O00000o0 = fld.O00000o0();
                                                        String str = str;
                                                        if (O00000o0.O00000Oo != null) {
                                                            O00000o0.O00000Oo.obtainMessage(3, str).sendToTarget();
                                                        } else if (O00000o0.O00000oo != null) {
                                                            O00000o0.O00000oo.O000000o(str);
                                                        }
                                                    }
                                                }.execute();
                                                return true;
                                            }
                                        }

                                        public String takeStatSession(long j, long j2) throws RemoteException {
                                            return hyi.O000000o(j, j2);
                                        }

                                        public void uploadStat() throws RemoteException {
                                            int callingPid = getCallingPid();
                                            int callingUid = getCallingUid();
                                            if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
                                                new CoreAsyncTask() {
                                                    /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass38 */

                                                    public void onCancel() {
                                                    }

                                                    public void run() {
                                                        fld.O00000o0().O00000o();
                                                    }
                                                }.execute();
                                            }
                                        }

                                        public void searchBluetoothDevice(SearchRequest searchRequest, SearchResponse searchResponse) throws RemoteException {
                                            fec.O000000o(CoreService.getAppContext()).O000000o(searchRequest, searchResponse);
                                        }

                                        public void stopSearchBluetoothDevice() throws RemoteException {
                                            fec.O000000o(CoreService.getAppContext()).O0000O0o();
                                        }

                                        public void callBluetoothApi(String str, int i, Bundle bundle, IBleResponse iBleResponse) throws RemoteException {
                                            if (bundle != null) {
                                                bundle.setClassLoader(getClass().getClassLoader());
                                            }
                                            fec.O000000o(CoreService.getAppContext()).O000000o(str, i, bundle, iBleResponse);
                                        }

                                        public ISecureConnectHandler secureConnect(String str, SecureConnectOptions secureConnectOptions, final ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                                            return BleSecureConnectManager.O000000o(str, secureConnectOptions, new gle() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass39 */

                                                public final void O000000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onConnectResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        th.printStackTrace();
                                                    }
                                                }

                                                public final void O00000Oo(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onAuthResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o0(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onBindResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onLastResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }
                                            });
                                        }

                                        public ISecureConnectHandler securityChipConnect(String str, SecureConnectOptions secureConnectOptions, final ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                                            return BleSecureConnectManager.O00000Oo(str, secureConnectOptions, new gle() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass40 */

                                                public final void O000000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onConnectResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        th.printStackTrace();
                                                    }
                                                }

                                                public final void O00000Oo(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onAuthResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o0(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onBindResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onLastResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }
                                            });
                                        }

                                        public ISecureConnectHandler securityChipPincodeConnect(String str, String str2, String str3, int i, SecureConnectOptions secureConnectOptions, final ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                                            return BleSecureConnectManager.O000000o(str, str2, str3, i, secureConnectOptions, new gle() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass41 */

                                                public final void O000000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onConnectResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        th.printStackTrace();
                                                    }
                                                }

                                                public final void O00000Oo(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onAuthResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o0(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onBindResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onLastResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }
                                            });
                                        }

                                        public ISecureConnectHandler securityChipSharedDeviceConnect(String str, SecureConnectOptions secureConnectOptions, final ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                                            return BleSecureConnectManager.O00000o0(str, secureConnectOptions, new gle() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass42 */

                                                public final void O000000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onConnectResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        th.printStackTrace();
                                                    }
                                                }

                                                public final void O00000Oo(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onAuthResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o0(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onBindResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onLastResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }
                                            });
                                        }

                                        public ISecureConnectHandler bleMeshBind(String str, SecureConnectOptions secureConnectOptions, final ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                                            return BleSecureConnectManager.O00000o(str, secureConnectOptions, new gle() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass43 */

                                                public final void O000000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onConnectResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        th.printStackTrace();
                                                    }
                                                }

                                                public final void O00000Oo(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onAuthResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o0(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onBindResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onLastResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }
                                            });
                                        }

                                        public ISecureConnectHandler bleMeshConnect(final String str, final String str2, String str3, SecureConnectOptions secureConnectOptions, final ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                                            return BleSecureConnectManager.O000000o(str, str2, str3, secureConnectOptions, new gle() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass44 */

                                                public final void O000000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onConnectResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        th.printStackTrace();
                                                    }
                                                }

                                                public final void O00000Oo(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onAuthResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o0(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onBindResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o(int i, Bundle bundle) {
                                                    if (i == 0) {
                                                        fgo.O000000o(str, str2, (feo<Void, fes>) null);
                                                    }
                                                    try {
                                                        iSecureConnectResponse.onLastResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }
                                            });
                                        }

                                        public ISecureConnectHandler bleStandardAuthBind(String str, SecureConnectOptions secureConnectOptions, final ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                                            return BleSecureConnectManager.O00000oO(str, secureConnectOptions, new gle() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass45 */

                                                public final void O000000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onConnectResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        th.printStackTrace();
                                                    }
                                                }

                                                public final void O00000Oo(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onAuthResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o0(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onBindResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onLastResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }
                                            });
                                        }

                                        public ISecureConnectHandler bleStandardAuthConnect(String str, SecureConnectOptions secureConnectOptions, final ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                                            return BleSecureConnectManager.O00000oo(str, secureConnectOptions, new gle() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass46 */

                                                public final void O000000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onConnectResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        th.printStackTrace();
                                                    }
                                                }

                                                public final void O00000Oo(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onAuthResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o0(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onBindResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onLastResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }
                                            });
                                        }

                                        public ISecureConnectHandler bleComboStandardAuth(String str, BleComboWifiConfig bleComboWifiConfig, SecureConnectOptions secureConnectOptions, final ISecureConnectResponse iSecureConnectResponse) throws RemoteException {
                                            return BleSecureConnectManager.O000000o(str, bleComboWifiConfig, secureConnectOptions, new gle() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass47 */

                                                public final void O000000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onConnectResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        th.printStackTrace();
                                                    }
                                                }

                                                public final void O00000Oo(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onAuthResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o0(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onBindResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }

                                                public final void O00000o(int i, Bundle bundle) {
                                                    try {
                                                        iSecureConnectResponse.onLastResponse(i, bundle);
                                                    } catch (Throwable th) {
                                                        gnk.O00000Oo(gnk.O00000Oo(th));
                                                    }
                                                }
                                            });
                                        }

                                        public String getBluetoothGatewayDevices() throws RemoteException {
                                            List<Device> O0000OOo = fec.O000000o(CoreService.getAppContext()).O0000OOo();
                                            JSONArray jSONArray = new JSONArray();
                                            for (Device next : O0000OOo) {
                                                JSONObject jSONObject = new JSONObject();
                                                try {
                                                    jSONObject.putOpt("did", next.getDid());
                                                    jSONObject.putOpt("model", next.getModel());
                                                } catch (JSONException e) {
                                                    gnk.O00000Oo(gnk.O00000Oo(e));
                                                }
                                                jSONArray.put(jSONObject);
                                            }
                                            return jSONArray.toString();
                                        }

                                        public void startBleMeshUpgrade(String str, String str2, String str3, String str4, IBleMeshUpgradeResponse iBleMeshUpgradeResponse) throws RemoteException {
                                            fec.O000000o(CoreService.getAppContext()).O000000o(str, str2, str3, str4, iBleMeshUpgradeResponse);
                                        }

                                        public void startMcuUpgrade(String str, String str2, String str3, boolean z, String str4, int i, IBleMeshUpgradeResponse iBleMeshUpgradeResponse) throws RuntimeException {
                                            fec.O000000o(CoreService.getAppContext()).O000000o(str, str2, str3, z, str4, i, iBleMeshUpgradeResponse);
                                        }

                                        public void cancelBleMeshUpgrade(String str) throws RemoteException {
                                            fec.O000000o(CoreService.getAppContext()).O000000o(str);
                                        }

                                        public void getBluetoothCache(String str, int i, Bundle bundle) throws RemoteException {
                                            fec.O000000o(CoreService.getAppContext()).O000000o(str, i, bundle);
                                        }

                                        public void setBluetoothCache(String str, int i, Bundle bundle) throws RemoteException {
                                            if (bundle != null) {
                                                bundle.setClassLoader(getClass().getClassLoader());
                                            }
                                            fec.O000000o(CoreService.getAppContext()).O00000Oo(str, i, bundle);
                                        }

                                        public void searchMiioBluetoothDevice(SearchRequest searchRequest, IBleResponse iBleResponse) throws RemoteException {
                                            if (searchRequest != null && iBleResponse != null) {
                                                fec.O000000o(CoreService.getAppContext()).O000000o(searchRequest, iBleResponse);
                                            }
                                        }

                                        public boolean setAlertConfigs(String str, int i, boolean z) throws RemoteException {
                                            String str2;
                                            fen O000000o2 = fen.O000000o();
                                            if (!(O000000o2.f16184O000000o != null && O000000o2.O00000Oo >= 15)) {
                                                return false;
                                            }
                                            if (i == 1) {
                                                str2 = "alert_incall_enabled_in_contacts";
                                            } else if (i == 2) {
                                                str2 = "alert_incall_enabled_no_contacts";
                                            } else if (i == 3) {
                                                str2 = "alert_alarm_enabled";
                                            } else if (i == 4) {
                                                str2 = "alert_sms_enabled_in_contacts";
                                            } else if (i != 5) {
                                                return false;
                                            } else {
                                                str2 = "alert_sms_enabled_no_contacts";
                                            }
                                            return O000000o2.f16184O000000o.setSettings(str, str2, z);
                                        }

                                        public IBleChannelWriter registerSecureAuthChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException {
                                            return few.O00000Oo().O00000Oo(str, iBleChannelReader);
                                        }

                                        public void unRegisterSecureAuthChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException {
                                            few.O00000Oo().O000000o(str, iBleChannelReader);
                                        }

                                        public void forceUpdateScene() throws RemoteException {
                                            flb.O000000o().O00000Oo();
                                        }

                                        public void resetCore() throws RemoteException {
                                            try {
                                                flb O000000o2 = flb.O000000o();
                                                flb.f16560O000000o = null;
                                                try {
                                                    if (O000000o2.O00000o0 != null) {
                                                        O000000o2.O00000o0.quit();
                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            } catch (Exception unused) {
                                            }
                                        }

                                        public void onActivityResume(final String str) throws RemoteException {
                                            final int callingPid = getCallingPid();
                                            final int callingUid = getCallingUid();
                                            if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
                                                new CoreAsyncTask() {
                                                    /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass48 */

                                                    public void onCancel() {
                                                    }

                                                    public void run() {
                                                        try {
                                                            fcy.O000000o().O000000o("com.xiaomi.smarthome").onActivityResume(callingPid, callingUid, str);
                                                        } catch (Exception unused) {
                                                        }
                                                    }
                                                }.execute();
                                            }
                                        }

                                        public void applicationEnterForground() throws RemoteException {
                                            int callingPid = getCallingPid();
                                            int callingUid = getCallingUid();
                                            if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
                                                new CoreAsyncTask() {
                                                    /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass49 */

                                                    public void onCancel() {
                                                    }

                                                    public void run() {
                                                        fjd.O000000o().O0000OOo();
                                                    }
                                                }.execute();
                                            }
                                        }

                                        public void applicationEnterBackground() {
                                            int callingPid = getCallingPid();
                                            int callingUid = getCallingUid();
                                            if (fcy.O000000o().O000000o(callingPid) && flq.O000000o().O000000o(callingPid, callingUid)) {
                                                new CoreAsyncTask() {
                                                    /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass50 */

                                                    public void onCancel() {
                                                    }

                                                    public void run() {
                                                        fjd.O000000o().O0000Oo0();
                                                    }
                                                }.execute();
                                            }
                                        }

                                        public void writeLog(int i, String str, String str2, String str3) throws RemoteException {
                                            ftf.O000000o().O000000o(i, str, str2, str3);
                                        }

                                        public void flushLog() throws RemoteException {
                                            ftf.O000000o().O00000o();
                                        }

                                        public void uploadLogFile(String str, String str2, String[] strArr, boolean z, final IClientCallback iClientCallback) throws RemoteException {
                                            ftf O000000o2 = ftf.O000000o();
                                            AnonymousClass51 r6 = new fsm<Void, fso>() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass51 */

                                                public final void onFailure(fso fso) {
                                                    try {
                                                        iClientCallback.onFailure(null);
                                                    } catch (RemoteException e) {
                                                        Log.e("CoreApiStub", "fatal", e);
                                                    }
                                                }

                                                public final /* synthetic */ void onSuccess(Object obj) {
                                                    try {
                                                        iClientCallback.onSuccess(null);
                                                    } catch (RemoteException e) {
                                                        Log.e("CoreApiStub", "fatal", e);
                                                    }
                                                }
                                            };
                                            if (!O000000o2.O00000oO) {
                                                return;
                                            }
                                            if (!Environment.getExternalStorageState().equals("mounted")) {
                                                r6.sendFailureMessage(new fso(-999, "SDCardBusy"));
                                            } else {
                                                gor.O000000o(new AsyncTask<Void, Void, String>(str2, strArr, z, str, r6) {
                                                    /* class _m_j.ftf.AnonymousClass6 */

                                                    /* renamed from: O000000o  reason: collision with root package name */
                                                    final /* synthetic */ String f17098O000000o;
                                                    final /* synthetic */ String[] O00000Oo;
                                                    final /* synthetic */ String O00000o;
                                                    final /* synthetic */ boolean O00000o0;
                                                    final /* synthetic */ fsm O00000oO;

                                                    {
                                                        this.f17098O000000o = r2;
                                                        this.O00000Oo = r3;
                                                        this.O00000o0 = r4;
                                                        this.O00000o = r5;
                                                        this.O00000oO = r6;
                                                    }

                                                    /* access modifiers changed from: protected */
                                                    public final /* synthetic */ void onPostExecute(Object obj) {
                                                        if (!TextUtils.isEmpty((String) obj)) {
                                                            fsm fsm = this.O00000oO;
                                                            if (fsm != null) {
                                                                fsm.sendSuccessMessage(null);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        fsm fsm2 = this.O00000oO;
                                                        if (fsm2 != null) {
                                                            fsm2.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
                                                        }
                                                    }

                                                    /* access modifiers changed from: protected */
                                                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                                                        String O000000o2 = ftf.this.O000000o(this.O00000Oo, this.O00000o0);
                                                        if (TextUtils.isEmpty(O000000o2)) {
                                                            return "emptyFilePath";
                                                        }
                                                        if (ftf.this.O000000o(O000000o2, this.O00000o)) {
                                                            return O000000o2;
                                                        }
                                                        return null;
                                                    }
                                                }, new Void[0]);
                                            }
                                        }

                                        public IClassicBtRequest getClassicBtRequestImpl() throws RemoteException {
                                            return ClassicBtService.getInstance();
                                        }

                                        public void addClassicBtResponse(IClassicBtResponse iClassicBtResponse) throws RemoteException {
                                            ClassicBtService.getInstance().setClassicBtResponse(iClassicBtResponse);
                                        }

                                        public HomeDeviceInfo getSharedHomeDeviceInfo(String str) throws RemoteException {
                                            return fjx.O000000o().O00000Oo.get(str);
                                        }

                                        public void setCurrentHome(HomeDeviceInfo homeDeviceInfo) throws RemoteException {
                                            fjx O000000o2 = fjx.O000000o();
                                            Home O00000Oo = homeDeviceInfo == null ? null : homeDeviceInfo.O00000Oo();
                                            gsy.O00000Oo(LogType.HOME_ROOM, fjx.f16504O000000o, "setCurrentHome ".concat(String.valueOf(O00000Oo)));
                                            O000000o2.O00000o0 = O00000Oo;
                                            synchronized (O000000o2) {
                                                if (O00000Oo != null) {
                                                    if (!O000000o2.O00000o.contains(O00000Oo)) {
                                                        O000000o2.O00000o.add(O00000Oo);
                                                    }
                                                }
                                            }
                                            O000000o2.O00000Oo();
                                        }

                                        public void loadHomeDeviceList(long j, long j2, final IClientCallback iClientCallback) throws RemoteException {
                                            fjx.O000000o().O000000o(j, j2, new fdh<ArrayList<Device>, NetError>() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass52 */

                                                public final /* synthetic */ void onFailure(Error error) {
                                                    IClientCallback iClientCallback = iClientCallback;
                                                    if (iClientCallback != null) {
                                                        try {
                                                            iClientCallback.onFailure(null);
                                                        } catch (RemoteException e) {
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                }

                                                public final /* synthetic */ void onSuccess(Object obj) {
                                                    IClientCallback iClientCallback = iClientCallback;
                                                    if (iClientCallback != null) {
                                                        try {
                                                            iClientCallback.onSuccess(null);
                                                        } catch (RemoteException e) {
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                }
                                            });
                                        }

                                        public byte[] miotBleEncryptSync(String str, byte[] bArr) throws RemoteException {
                                            return fec.O000000o(CoreService.getAppContext()).O000000o(str, bArr);
                                        }

                                        public byte[] miotBleDecryptSync(String str, byte[] bArr) throws RemoteException {
                                            return fec.O000000o(CoreService.getAppContext()).O00000Oo(str, bArr);
                                        }

                                        public void beginProcess(String str, int i) throws RemoteException {
                                            hvg.O000000o(CoreService.getAppContext()).O000000o(str, i);
                                        }

                                        public String finishProcess(int i) throws RemoteException {
                                            return hvg.O000000o(CoreService.getAppContext()).O000000o(i);
                                        }

                                        public void addProcessContext(String str, String str2) throws RemoteException {
                                            hvg.O000000o(CoreService.getAppContext()).O000000o(str, str2);
                                        }

                                        public int startAction(int i) throws RemoteException {
                                            return hvg.O000000o(CoreService.getAppContext()).O00000Oo(i);
                                        }

                                        public void addContextToCurrentAction(String str, String str2) throws RemoteException {
                                            hvg.O000000o(CoreService.getAppContext()).O00000Oo(str, str2);
                                        }

                                        public void appendContextToCurrentAction(String str, String str2) throws RemoteException {
                                            hvg.O000000o(CoreService.getAppContext()).O00000o0(str, str2);
                                        }

                                        public void addContextToActionById(int i, String str, String str2) throws RemoteException {
                                            hvg.O000000o(CoreService.getAppContext()).O000000o(i, str, str2);
                                        }

                                        public void finishCurrentAction(int i) throws RemoteException {
                                            hvg.O000000o(CoreService.getAppContext()).O00000o0(i);
                                        }

                                        public void finishCurrentActionWithContext(int i, Map map) throws RemoteException {
                                            HashMap hashMap = new HashMap(map.size());
                                            for (Map.Entry entry : map.entrySet()) {
                                                hashMap.put(entry.getKey().toString(), entry.getValue().toString());
                                            }
                                            hvg.O000000o(CoreService.getAppContext()).O000000o(i, map);
                                        }

                                        public void updateActionResultById(int i, int i2) throws RemoteException {
                                            hvg.O000000o(CoreService.getAppContext()).O000000o(i, i2);
                                        }

                                        public void updateActionResultByCode(int i, int i2) throws RemoteException {
                                            hvg.O000000o(CoreService.getAppContext()).O00000Oo(i, i2);
                                        }

                                        public void addContextByActionCode(int i, String str, String str2) throws RemoteException {
                                            hvg.O000000o(CoreService.getAppContext()).O00000Oo(i, str, str2);
                                        }

                                        public void downloadCloudVideoIntoCloudSetting(String str, String str2, boolean z, long j, long j2) {
                                            fsp.O000000o().O0000OOo.downloadCloudVideoIntoCloudSetting(str, str2, z, j, j2, new com.xiaomi.smarthome.device.api.Callback<Bundle>() {
                                                /* class com.xiaomi.smarthome.core.server.CoreApiStub.AnonymousClass53 */

                                                public final /* synthetic */ void onSuccess(Object obj) {
                                                    Bundle bundle = (Bundle) obj;
                                                    int i = bundle.getInt("errorCode");
                                                    int i2 = bundle.getInt("status");
                                                    String string = bundle.getString("fileId");
                                                    Intent intent = new Intent();
                                                    intent.setAction(MessageReceiver.CLOUD_VIDEO_DOWNLOAD_LISTENER_NAME);
                                                    intent.putExtra("errorCode", i);
                                                    intent.putExtra("status", i2);
                                                    intent.putExtra("fileId", string);
                                                    try {
                                                        CommonApplication.getApplication().sendBroadcast(intent);
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }

                                                public final void onFailure(int i, String str) {
                                                    Bundle bundle = new Bundle();
                                                    bundle.putInt("status", 0);
                                                    bundle.putInt("errorCode", i);
                                                    Intent intent = new Intent();
                                                    intent.setAction(MessageReceiver.CLOUD_VIDEO_DOWNLOAD_LISTENER_NAME);
                                                    intent.putExtra("errorCode", i);
                                                    intent.putExtra("status", 0);
                                                    intent.putExtra("fileId", str);
                                                    try {
                                                        CommonApplication.getApplication().sendBroadcast(intent);
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            });
                                        }

                                        public boolean is6OptimizeBleLoginConnectModel(String str) {
                                            return eyr.O000000o(str, true, 100, eyr.O00000Oo().O00oOooo);
                                        }

                                        public int get6OptimizeBleLoginConnectRetryDelay(String str) {
                                            eyr O00000Oo = eyr.O00000Oo();
                                            if (eyr.O000000o(str, O00000Oo.O00oOooo)) {
                                                return O00000Oo.O000O00o;
                                            }
                                            return 2000;
                                        }

                                        public boolean is13OptimizeBleLoginConnectModel(String str) {
                                            return eyr.O000000o(str, true, 100, eyr.O00000Oo().O000O0OO);
                                        }

                                        public int get13OptimizeBleLoginConnectRetryDelay(String str) {
                                            eyr O00000Oo = eyr.O00000Oo();
                                            if (eyr.O000000o(str, O00000Oo.O000O0OO)) {
                                                return O00000Oo.O000O0Oo;
                                            }
                                            return 2000;
                                        }

                                        public int getOptimizeBleLoginConnectRetryTimes() {
                                            return eyr.O00000Oo().O00oOoOo;
                                        }

                                        public boolean needSecurityChipCheck(String str) {
                                            eyr O00000Oo = eyr.O00000Oo();
                                            return eyr.O000000o(str, O00000Oo.O000Oo0o, O00000Oo.O000OoO0, O00000Oo.O000Oo0O);
                                        }

                                        public void report_spec_result(long j, String str, boolean z, int i, String str2, String str3, String str4) throws RemoteException {
                                            hxt hxt = hxi.O0000Oo;
                                            if (!flu.O00000oO().O00000o0() && !gfr.f17662O000000o) {
                                                if (j >= 60000) {
                                                    j = -1;
                                                }
                                                hxt.f960O000000o.O000000o("report_spec_result", "time", Long.valueOf(j), "api", str, "model", str2, "result", Integer.valueOf(z ? 1 : 0), "device_num", Integer.valueOf(i), "payload", str3, "response", str4);
                                            }
                                        }
                                    }

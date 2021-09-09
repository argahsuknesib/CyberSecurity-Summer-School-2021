package com.xiaomi.smarthome.service.tasks;

import _m_j.dcp;
import _m_j.ezu;
import _m_j.faw;
import _m_j.fno;
import _m_j.gpu;
import _m_j.gpy;
import _m_j.grr;
import _m_j.gsf;
import _m_j.gsy;
import _m_j.hsc;
import _m_j.hsd;
import _m_j.hse;
import _m_j.hsf;
import _m_j.hsg;
import _m_j.hsh;
import _m_j.hxi;
import _m_j.hzg;
import _m_j.hzj;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.miot.service.ICallback;
import com.xiaomi.miot.service.IMiuiService;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class ServiceManager extends IMiuiService.Stub {
    private hsg getNearListTask;
    private long lastRefreshTime = 0;
    public ThreadPoolExecutor mExecutor = new ThreadPoolExecutor(1, 5, 90, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(256));
    private String[] mPackageConfig;
    private boolean mSytemConfig;

    public ServiceManager() {
        if (ezu.O000000o()) {
            new AppConfigHelper(CommonApplication.getAppContext()).O000000o("miuiservice_check", "1", "en", "cardControl/miuiservice_check.json", new AppConfigHelper.O00000Oo() {
                /* class com.xiaomi.smarthome.service.tasks.ServiceManager.AnonymousClass1 */

                public final boolean O000000o(String str) throws Exception {
                    return ServiceManager.this.parseLanguage(str);
                }

                public final boolean O00000Oo(String str) throws Exception {
                    return ServiceManager.this.parseLanguage(str);
                }
            }, new AppConfigHelper.O000000o() {
                /* class com.xiaomi.smarthome.service.tasks.ServiceManager.AnonymousClass2 */

                public final void onFailure(gsf gsf, Exception exc, Response response) {
                }

                /* renamed from: O000000o */
                public final void onSuccess(String str, Response response) {
                    ServiceManager.this.parseLanguage(str);
                }
            }, $$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE);
        }
    }

    public boolean parseLanguage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mSytemConfig = jSONObject.optBoolean("any_system");
            JSONArray optJSONArray = jSONObject.optJSONArray("allow_packagename");
            this.mPackageConfig = new String[optJSONArray.length()];
            for (int i = 0; i < this.mPackageConfig.length; i++) {
                this.mPackageConfig[i] = optJSONArray.optString(i);
            }
            Arrays.sort(this.mPackageConfig);
            return true;
        } catch (Throwable th) {
            gsy.O00000o0(LogType.CARD, "ServiceManager", Log.getStackTraceString(th));
            return false;
        }
    }

    public void isLogin(ICallback iCallback) throws RemoteException {
        if (isMiuiProcess()) {
            this.mExecutor.execute(new hsh(iCallback));
        }
    }

    public void getDeviceList(ICallback iCallback) throws RemoteException {
        if (checkAccess() && this.mExecutor != null) {
            this.mExecutor.execute(new hsf(iCallback, gpy.O000000o(CommonApplication.getAppContext(), "cache_data_timerequest", "force_update_data_completed") + 86400000 < System.currentTimeMillis(), false));
        }
    }

    private boolean checkAccess() {
        return ezu.O000000o() && isMiuiProcess();
    }

    private boolean isMiuiProcess() {
        String[] strArr;
        boolean O00000oO = grr.O00000oO();
        String[] packagesForUid = CommonApplication.getAppContext().getPackageManager().getPackagesForUid(getCallingUid());
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodName = (stackTrace.length <= 3 || stackTrace[3] == null) ? "noMethod" : stackTrace[3].getMethodName();
        gsy.O00000o0(LogType.DEVICE_CONTROL, "ServiceManager", methodName + "  " + this.mSytemConfig + "  miui:" + O00000oO + "  packages:" + Arrays.toString(packagesForUid) + Arrays.toString(this.mPackageConfig));
        if (packagesForUid == null || packagesForUid.length <= 0 || (strArr = this.mPackageConfig) == null) {
            return this.mSytemConfig || O00000oO;
        }
        if (strArr.length == 0) {
            return this.mSytemConfig || O00000oO;
        }
        for (String binarySearch : packagesForUid) {
            if (Arrays.binarySearch(this.mPackageConfig, binarySearch) >= 0) {
                return this.mSytemConfig || O00000oO;
            }
        }
        return false;
    }

    public void getDeviceListFilterKey(ICallback iCallback, boolean z) throws RemoteException {
        if (checkAccess()) {
            ThreadPoolExecutor threadPoolExecutor = this.mExecutor;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.execute(new hsf(iCallback, z, true));
            }
            hxi.O00000oO.O000000o();
        }
    }

    public void getDeviceListPropOrder(ICallback iCallback, boolean z) throws RemoteException {
        if (checkAccess()) {
            ThreadPoolExecutor threadPoolExecutor = this.mExecutor;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.execute(new hsf(iCallback, z, true, true));
            }
            hxi.O00000oO.O000000o();
        }
    }

    public void getDeviceCount(ICallback iCallback, boolean z) throws RemoteException {
        ThreadPoolExecutor threadPoolExecutor;
        if (checkAccess() && (threadPoolExecutor = this.mExecutor) != null) {
            threadPoolExecutor.execute(new hse(iCallback, z));
        }
    }

    public void setDeviceOn(String str, boolean z, ICallback iCallback) throws RemoteException {
        if (checkAccess()) {
            this.lastRefreshTime = System.currentTimeMillis();
            this.mExecutor.execute(new hsd(str, z, iCallback));
        }
    }

    public void scanNearList(boolean z, boolean z2, int i, ICallback iCallback) throws RemoteException {
        if (checkAccess()) {
            fno.O000000o().O000000o(new fno.O00000o(z, z2, i, iCallback) {
                /* class com.xiaomi.smarthome.service.tasks.$$Lambda$ServiceManager$loAWmuRIzU7pM5y7Xs84wHEM0 */
                private final /* synthetic */ boolean f$1;
                private final /* synthetic */ boolean f$2;
                private final /* synthetic */ int f$3;
                private final /* synthetic */ ICallback f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void onDeviceReady(Map map) {
                    ServiceManager.this.lambda$scanNearList$0$ServiceManager(this.f$1, this.f$2, this.f$3, this.f$4, map);
                }
            });
        }
    }

    public /* synthetic */ void lambda$scanNearList$0$ServiceManager(boolean z, boolean z2, int i, ICallback iCallback, Map map) {
        gsy.O00000o0(LogType.DEVICE_CONTROL, "ServiceManager", "scanNearList onDeviceReady");
        if (this.getNearListTask == null) {
            this.getNearListTask = new hsg();
        }
        this.getNearListTask.O000000o(z, z2, i, iCallback, false);
    }

    public void scanNearListFilterKey(boolean z, boolean z2, int i, ICallback iCallback) throws RemoteException {
        if (checkAccess()) {
            fno.O000000o().O000000o(new fno.O00000o(z, z2, i, iCallback) {
                /* class com.xiaomi.smarthome.service.tasks.$$Lambda$ServiceManager$gjgLBsFg15IwKMFJSGcyGRgOctg */
                private final /* synthetic */ boolean f$1;
                private final /* synthetic */ boolean f$2;
                private final /* synthetic */ int f$3;
                private final /* synthetic */ ICallback f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void onDeviceReady(Map map) {
                    ServiceManager.this.lambda$scanNearListFilterKey$1$ServiceManager(this.f$1, this.f$2, this.f$3, this.f$4, map);
                }
            });
        }
    }

    public /* synthetic */ void lambda$scanNearListFilterKey$1$ServiceManager(boolean z, boolean z2, int i, ICallback iCallback, Map map) {
        gsy.O00000o0(LogType.DEVICE_CONTROL, "ServiceManager", "scanNearList onDeviceReady");
        if (this.getNearListTask == null) {
            this.getNearListTask = new hsg();
        }
        this.getNearListTask.O000000o(z, z2, i, iCallback, true);
    }

    public void stopScanNear() {
        if (this.getNearListTask == null) {
            this.getNearListTask = new hsg();
        }
        hsg hsg = this.getNearListTask;
        gsy.O000000o(3, "MiuiService", "stopScanNear");
        hsg.O0000OOo.run();
    }

    public void isSameCard(String str, ICallback iCallback) throws RemoteException {
        if (iCallback != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("same", faw.O00000o0().isSameCard(fno.O000000o().O000000o(str)));
            iCallback.onSuccess(bundle);
        }
    }

    public void getDeviceDesc(final boolean z, final ICallback iCallback) throws RemoteException {
        if (checkAccess()) {
            fno.O000000o().O000000o(new fno.O00000o() {
                /* class com.xiaomi.smarthome.service.tasks.ServiceManager.AnonymousClass3 */

                public final void onDeviceReady(Map<String, Device> map) {
                    gsy.O00000o0(LogType.DEVICE_CONTROL, "ServiceManager", "getDeviceDesc onDeviceReady");
                    if (fno.O000000o().O00000oO().size() == 0) {
                        gsy.O00000o0(LogType.DEVICE_CONTROL, "ServiceManager", "getDeviceDesc onDeviceReady size = 0");
                        try {
                            ServiceManager.this.getDeviceList(new ICallback.Stub() {
                                /* class com.xiaomi.smarthome.service.tasks.ServiceManager.AnonymousClass3.AnonymousClass1 */

                                public void onSuccess(Bundle bundle) throws RemoteException {
                                    ServiceManager.this.mExecutor.execute(new hsc(iCallback, z, "/v2/home/get_negative_screen_desc", "{}"));
                                }

                                public void onFailure(Bundle bundle) throws RemoteException {
                                    gsy.O00000o0(LogType.DEVICE_CONTROL, "ServiceManager", "getDeviceDesc onDeviceReady onFailure");
                                    iCallback.onFailure(bundle);
                                }
                            });
                        } catch (RemoteException e) {
                            gsy.O000000o(6, "ServiceManager", Log.getStackTraceString(e));
                        }
                    } else {
                        ServiceManager.this.mExecutor.execute(new hsc(iCallback, z, "/v2/home/get_negative_screen_desc", "{}"));
                    }
                }
            });
        }
    }

    public void initUwb(Bundle bundle, ICallback iCallback) {
        gsy.O00000o0(LogType.DEVICE_CONTROL, "ServiceManager", "initUwb");
        dcp.O000000o().O000000o(CommonApplication.getApplication());
        hzg O000000o2 = hzj.O000000o();
        if (O000000o2 != null) {
            O000000o2.init();
        }
    }

    public void getAccess(Bundle bundle) {
        gsy.O00000o0(LogType.DEVICE_CONTROL, "ServiceManager", "getAccess ".concat(String.valueOf(bundle)));
        if (bundle != null) {
            bundle.putBoolean("cta", ezu.O000000o());
            bundle.putBoolean("lock_screen", gpu.O000000o(CommonApplication.getApplication(), 10020));
        }
    }
}

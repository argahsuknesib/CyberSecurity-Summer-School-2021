package com.xiaomi.smarthome;

import _m_j.exs;
import _m_j.exu;
import _m_j.fkv;
import _m_j.gfr;
import _m_j.gsf;
import _m_j.gsy;
import android.util.Log;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.tencent.tinker.loader.SystemClassLoaderAdder;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerTestDexLoad;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.api.ProgressCallback;
import com.xiaomi.smarthome.library.log.LogType;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public enum ExternalLoadManager {
    instance;
    
    public static final File OPTIMIZE_DIR = CommonApplication.getAppContext().getDir("app_dex", 0);
    private final Map<String, O000000o> loadCache = new HashMap();
    private final SplitInstallManager manager = SplitInstallManagerFactory.create(CommonApplication.getAppContext());

    public final void downExternal(final String str, final fkv<O000000o, Integer> fkv) {
        final O000000o loadInfo = getLoadInfo(str);
        if (loadInfo.f4013O000000o == 2 || loadInfo.f4013O000000o == 3) {
            dispatchCallback(str, fkv, loadInfo);
        } else if (!gfr.O0000oO0) {
            new AppConfigHelper(CommonApplication.getAppContext()).O000000o("apk_external", "3", "en", "cardControl/apk_external.json", new AppConfigHelper.O000000o() {
                /* class com.xiaomi.smarthome.ExternalLoadManager.AnonymousClass1 */

                /* renamed from: O000000o */
                public final void onSuccess(String str, Response response) {
                    gsy.O00000o0(LogType.PLUGIN, "ExternalLoadManager", "onSuccess ".concat(String.valueOf(str)));
                    ExternalLoadManager.this.parseConfig(str, loadInfo, str, fkv);
                }

                public final void onFailure(gsf gsf, Exception exc, Response response) {
                    LogType logType = LogType.PLUGIN;
                    gsy.O00000o0(logType, "ExternalLoadManager", "onFailure " + Log.getStackTraceString(exc));
                    ExternalLoadManager externalLoadManager = ExternalLoadManager.this;
                    String str = str;
                    fkv fkv = fkv;
                    O000000o o000000o = loadInfo;
                    o000000o.f4013O000000o = 4;
                    externalLoadManager.dispatchCallback(str, fkv, o000000o);
                }
            });
        } else if ("amap2d".equals(str)) {
            loadInfo.f4013O000000o = 2;
            dispatchCallback(str, fkv, loadInfo);
            loadInfo.f4013O000000o = 3;
            dispatchCallback(str, fkv, loadInfo);
        } else {
            loadInfo.f4013O000000o = 1;
            dispatchCallback(str, fkv, loadInfo);
            $$Lambda$ExternalLoadManager$SMMa51ouO7doINS00cv1M35nqj8 r7 = new SplitInstallStateUpdatedListener(str, fkv, loadInfo) {
                /* class com.xiaomi.smarthome.$$Lambda$ExternalLoadManager$SMMa51ouO7doINS00cv1M35nqj8 */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ fkv f$2;
                private final /* synthetic */ ExternalLoadManager.O000000o f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onStateUpdate(Object obj) {
                    ExternalLoadManager.this.lambda$downExternal$0$ExternalLoadManager(this.f$1, this.f$2, this.f$3, (SplitInstallSessionState) obj);
                }
            };
            this.manager.registerListener(r7);
            Task<Integer> startInstall = this.manager.startInstall(SplitInstallRequest.newBuilder().addModule(str).build());
            String str2 = str;
            $$Lambda$ExternalLoadManager$SMMa51ouO7doINS00cv1M35nqj8 r3 = r7;
            fkv<O000000o, Integer> fkv2 = fkv;
            O000000o o000000o = loadInfo;
            startInstall.addOnFailureListener(new OnFailureListener(str2, r3, fkv2, o000000o) {
                /* class com.xiaomi.smarthome.$$Lambda$ExternalLoadManager$R6umZxXHjHYjXfwPm_eWMFnSCL4 */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ SplitInstallStateUpdatedListener f$2;
                private final /* synthetic */ fkv f$3;
                private final /* synthetic */ ExternalLoadManager.O000000o f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void onFailure(Exception exc) {
                    ExternalLoadManager.this.lambda$downExternal$1$ExternalLoadManager(this.f$1, this.f$2, this.f$3, this.f$4, exc);
                }
            });
            startInstall.addOnSuccessListener(new OnSuccessListener(str2, r3, fkv2, o000000o) {
                /* class com.xiaomi.smarthome.$$Lambda$ExternalLoadManager$oG5DY7kyZp6vHOYoc8KWVC_jfwY */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ SplitInstallStateUpdatedListener f$2;
                private final /* synthetic */ fkv f$3;
                private final /* synthetic */ ExternalLoadManager.O000000o f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void onSuccess(Object obj) {
                    ExternalLoadManager.this.lambda$downExternal$3$ExternalLoadManager(this.f$1, this.f$2, this.f$3, this.f$4, (Integer) obj);
                }
            });
        }
    }

    public final void dispatchCallback(String str, fkv<O000000o, Integer> fkv, O000000o o000000o) {
        if (fkv != null) {
            try {
                fkv.call(o000000o);
            } catch (Throwable th) {
                gsy.O00000o0(LogType.PLUGIN, "ExternalLoadManager", "dispatchCallback", Log.getStackTraceString(th));
            }
        }
    }

    public final void parseConfig(final String str, final O000000o o000000o, String str2, final fkv<O000000o, Integer> fkv) {
        gsy.O000000o(4, "ExternalLoadManager", "parseConfig content:".concat(String.valueOf(str2)));
        try {
            o000000o.f4013O000000o = 1;
            dispatchCallback(str, fkv, o000000o);
            String optString = new JSONObject(str2).optString(str);
            exu.O000000o o000000o2 = exu.f15933O000000o;
            exu O000000o2 = exu.O000000o.O000000o();
            O000000o2.O000000o(new File(CommonApplication.getAppContext().getExternalCacheDir().toString() + File.separator + "app_download" + File.separator + optString.hashCode() + ".apk"), optString, new ProgressCallback<File>() {
                /* class com.xiaomi.smarthome.ExternalLoadManager.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    File file = (File) obj;
                    TinkerDexOptimizer.optimizeAll(CommonApplication.getAppContext(), Collections.singleton(file), ExternalLoadManager.OPTIMIZE_DIR, (TinkerDexOptimizer.ResultCallback) null);
                    String absolutePath = file.getAbsolutePath();
                    try {
                        new exs(absolutePath, absolutePath + "_so").run();
                    } catch (Throwable th) {
                        gsy.O00000o0(LogType.PLUGIN, "ExternalLoadManager", "CopySoTask", Log.getStackTraceString(th));
                    }
                    ExternalLoadManager externalLoadManager = ExternalLoadManager.this;
                    String str = str;
                    fkv fkv = fkv;
                    O000000o o000000o = o000000o;
                    o000000o.O00000Oo = file;
                    o000000o.f4013O000000o = 2;
                    externalLoadManager.dispatchCallback(str, fkv, o000000o);
                }

                public final void onProgress(long j, long j2) {
                    ExternalLoadManager externalLoadManager = ExternalLoadManager.this;
                    String str = str;
                    fkv fkv = fkv;
                    O000000o o000000o = o000000o;
                    o000000o.O00000o0 = ((float) j) / ((float) j2);
                    o000000o.f4013O000000o = 1;
                    externalLoadManager.dispatchCallback(str, fkv, o000000o);
                }

                public final void onFailure(int i, String str) {
                    LogType logType = LogType.PLUGIN;
                    gsy.O00000o0(logType, "ExternalLoadManager", "parseConfig onFailure " + i + str);
                    ExternalLoadManager externalLoadManager = ExternalLoadManager.this;
                    String str2 = str;
                    fkv fkv = fkv;
                    O000000o o000000o = o000000o;
                    o000000o.f4013O000000o = 4;
                    externalLoadManager.dispatchCallback(str2, fkv, o000000o);
                }
            });
        } catch (JSONException e) {
            o000000o.f4013O000000o = 4;
            dispatchCallback(str, fkv, o000000o);
            gsy.O00000o0(LogType.PLUGIN, "ExternalLoadManager", "parseConfig", Log.getStackTraceString(e));
        }
    }

    public final void loadExternal(String str, fkv<O000000o, Integer> fkv) {
        downExternal(str, new fkv(str, fkv) {
            /* class com.xiaomi.smarthome.$$Lambda$ExternalLoadManager$cxq1BCfZQiP2e4WiUQOvgc0FJWs */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ fkv f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object call(Object obj) {
                return ExternalLoadManager.this.lambda$loadExternal$4$ExternalLoadManager(this.f$1, this.f$2, (ExternalLoadManager.O000000o) obj);
            }
        });
    }

    public final O000000o getLoadInfo(String str) {
        O000000o o000000o = this.loadCache.get(str);
        if (o000000o != null) {
            return o000000o;
        }
        Map<String, O000000o> map = this.loadCache;
        O000000o o000000o2 = new O000000o(0);
        map.put(str, o000000o2);
        return o000000o2;
    }

    private int install(File file) {
        if (gfr.O0000oO0) {
            return 3;
        }
        try {
            TinkerTestDexLoad.isPatch = true;
            SystemClassLoaderAdder.installDexes(CommonApplication.getApplication(), (BaseDexClassLoader) getClass().getClassLoader(), OPTIMIZE_DIR, Collections.singletonList(file), true);
            return 3;
        } catch (Throwable th) {
            gsy.O00000o0(LogType.PLUGIN, "ExternalLoadManager", Log.getStackTraceString(th));
            return 4;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f4013O000000o;
        File O00000Oo;
        public float O00000o0;

        public O000000o(int i) {
            this.f4013O000000o = i;
        }

        public final String toString() {
            return "LoadInfo{status=" + this.f4013O000000o + ", file=" + this.O00000Oo + ", progress=" + this.O00000o0 + '}';
        }
    }
}

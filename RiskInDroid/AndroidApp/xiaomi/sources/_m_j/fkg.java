package _m_j;

import _m_j.fkg;
import _m_j.gsj;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.library.log.LogType;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.net.CookieManager;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.json.JSONObject;

public final class fkg {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Map<fki, List<fki>> f16512O000000o = new ConcurrentHashMap();
    public final Context O00000Oo;
    private OkHttpClient O00000o;
    private final String O00000o0;

    public static class O000000o {
        /* access modifiers changed from: package-private */
        public void O000000o() {
        }

        /* access modifiers changed from: package-private */
        public void O000000o(float f) {
        }

        /* access modifiers changed from: package-private */
        public void O000000o(gsn gsn) {
        }

        /* access modifiers changed from: package-private */
        public void O00000Oo() {
        }

        /* access modifiers changed from: package-private */
        public void O00000o0() {
        }
    }

    public fkg(Context context, String str) {
        this.O00000Oo = context;
        this.O00000o0 = str;
    }

    public final void O000000o(String str, fki fki) {
        fki fki2 = fki;
        final long O00000o02 = fki.O00000o0();
        List list = this.f16512O000000o.get(fki2);
        if (list == null || list.size() <= 0) {
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.f16512O000000o.put(fki2, list);
            }
            list.add(fki2);
            final String O00000o2 = fki.O00000o();
            O000000o("startPluginDownloadTaskInternalExec-startDownloadFileInternal...url: " + fki.O00000oO());
            final fki fki3 = fki;
            final String str2 = str;
            final String str3 = this.O00000o0 + File.separator + O00000o02 + ".raw";
            O000000o(fki.O00000oO(), fki.O00000oo(), fki.O0000O0o(), str3, new O000000o() {
                /* class _m_j.fkg.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public final void O000000o(gsn gsn) {
                    List<fki> list = fkg.this.f16512O000000o.get(fki3);
                    if (list != null) {
                        for (fki fki : list) {
                            if (fki.O0000Oo() != null) {
                                fki.O000000o(gsn);
                            }
                        }
                    }
                }

                /* access modifiers changed from: package-private */
                public final void O000000o() {
                    List<fki> list = fkg.this.f16512O000000o.get(fki3);
                    if (list != null) {
                        for (fki fki : list) {
                            if (fki.O0000Oo() != null && !((Boolean) fki.O000000o("started", Boolean.FALSE)).booleanValue()) {
                                fki.O0000Oo().O000000o(fki);
                            }
                        }
                    }
                }

                /* access modifiers changed from: package-private */
                public final void O000000o(float f) {
                    List<fki> list = fkg.this.f16512O000000o.get(fki3);
                    if (list != null) {
                        for (fki fki : list) {
                            if (fki.O0000Oo() != null) {
                                fki.O0000Oo().O000000o(fki, ((Boolean) fki.O000000o("download_sdk", Boolean.FALSE)).booleanValue() ? (0.8f * f) + 0.2f : f);
                            }
                        }
                    }
                }

                /* access modifiers changed from: package-private */
                public final void O00000Oo() {
                    boolean z;
                    List<fki> list = fkg.this.f16512O000000o.get(fki3);
                    if (list != null) {
                        if ("rn".equalsIgnoreCase(O00000o2)) {
                            fkw.O00000Oo(str2);
                            z = false;
                            try {
                                if (fla.O000000o(str3, str2, null) && fkw.O00000oO(new File(str2, "conf.json").getAbsolutePath()).exists()) {
                                    z = true;
                                }
                            } catch (Exception e) {
                                fkg.O000000o(Log.getStackTraceString(e));
                            }
                            HashSet hashSet = new HashSet();
                            for (fki fki : list) {
                                hashSet.add(fki.f16517O000000o);
                            }
                            new fkk(new File(str2)).O000000o(hashSet).O000000o(fki3.O00000o0).O00000Oo();
                        } else {
                            z = fkw.O00000Oo(str3, str2);
                        }
                        fkw.O00000Oo(str3);
                        if (z) {
                            fkg.O000000o("plugin manager download plugin success");
                            PluginPackageInfo O000000o2 = fky.O000000o(fkg.this.O00000Oo, fki3.O00000Oo(), fki3.O00000o0(), fki3.O00000o(), str2);
                            if (O000000o2 == null) {
                                fkw.O00000Oo(str2);
                                fkg.O000000o("startPluginDownloadTaskInternalExec packageInfo null");
                            } else {
                                Context context = fkg.this.O00000Oo;
                                String developerInfo = PluginDeviceManager.instance.getDeveloperInfo(O000000o2.O0000Oo0());
                                if (!fky.O000000o(context, O000000o2, developerInfo)) {
                                    fkw.O00000Oo(str2);
                                    fkg.O000000o("startPluginDownloadTaskInternalExec validateSignature fail:" + O000000o2.O0000o0o() + developerInfo);
                                    fkg.O000000o(list, -670);
                                } else if (!fky.O000000o(O000000o2)) {
                                    fkw.O00000Oo(str2);
                                    fkg.O000000o("startPluginDownloadTaskInternalExec validatePackage fail:" + O000000o2.O0000o0o() + developerInfo);
                                    fkg.O000000o(list, -708);
                                } else {
                                    for (fki fki2 : list) {
                                        if (fki2.O0000Oo() != null) {
                                            fki2.O0000Oo().O000000o(fki2, O000000o2);
                                        }
                                    }
                                }
                            }
                        } else {
                            fkg.O000000o("plugin manager download plugin fail");
                            fkw.O00000Oo(str2);
                            fkg.O000000o(list, -669);
                        }
                        fkg.this.f16512O000000o.remove(fki3);
                    }
                }

                /* access modifiers changed from: package-private */
                public final void O00000o0() {
                    List list = fkg.this.f16512O000000o.get(fki3);
                    if (list != null) {
                        fkg.O000000o(list, -663);
                        fkg.this.f16512O000000o.remove(fki3);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("plugin_id", fki3.O00000Oo());
                            jSONObject.put("package_id", O00000o02);
                            jSONObject.put("ip", gog.O00000oO(fkg.this.O00000Oo));
                            jSONObject.put("url", fki3.O00000oO());
                            jSONObject.put("safe_url", fki3.O00000oo());
                            hxi.O0000Oo.O000000o(3, fki3.f16517O000000o);
                            fld.O00000o0().O000000o(StatType.EVENT.getValue(), "mihome", "plugin_download_failed", jSONObject.toString(), null, false);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
            return;
        }
        fki2.O000000o(((fki) list.get(0)).O0000Oo0());
        list.add(fki2);
        O000000o("startPluginDownloadTaskInternalExec-startDownloadFileInternal same packageId ".concat(String.valueOf(O00000o02)));
    }

    public static void O000000o(List<fki> list, int i) {
        for (fki next : list) {
            if (next.O0000Oo() != null) {
                next.O0000Oo().O000000o(next, i);
            }
        }
    }

    public final void O000000o(String str, String str2, long j, String str3, O000000o o000000o) {
        O000000o o000000o2 = o000000o;
        File O00000oO = fkw.O00000oO(str3);
        if (O00000oO == null) {
            fkw.O00000Oo(str3);
            o000000o.O00000o0();
            O000000o("start down createFileIfNotExists onFailure url:".concat(String.valueOf(str)));
        } else if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
            String str4 = TextUtils.isEmpty(str2) ? str : str2;
            gsj.O000000o o000000o3 = new gsj.O000000o();
            o000000o3.f18212O000000o = "GET";
            gsj O000000o2 = o000000o3.O00000Oo(str4).O000000o();
            if (gsm.O00000Oo(O00000oO)) {
                O000000o("start down plugin and external url:".concat(String.valueOf(str)));
                O000000o("start downExternal(amap2d) & downloadRnExtModules");
                final Disposable subscribe = Observable.zip(Observable.create(new ObservableOnSubscribe() {
                    /* class _m_j.$$Lambda$fkg$JkBuxl81wHhMHJt7CgBZZr2y4nk */

                    public final void subscribe(ObservableEmitter observableEmitter) {
                        fkg.this.O00000Oo(observableEmitter);
                    }
                }), Observable.create(new ObservableOnSubscribe() {
                    /* class _m_j.$$Lambda$fkg$qbR1bOsVLXXURVp4hbMh_egXQ0 */

                    public final void subscribe(ObservableEmitter observableEmitter) {
                        fkg.this.O000000o(observableEmitter);
                    }
                }), Observable.create(new ObservableOnSubscribe(O000000o2, O00000oO, o000000o, j, str3, str2, str) {
                    /* class _m_j.$$Lambda$fkg$KlPL5dx3qslbSbr60L_JG7BQcFA */
                    private final /* synthetic */ gsj f$1;
                    private final /* synthetic */ File f$2;
                    private final /* synthetic */ fkg.O000000o f$3;
                    private final /* synthetic */ long f$4;
                    private final /* synthetic */ String f$5;
                    private final /* synthetic */ String f$6;
                    private final /* synthetic */ String f$7;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                        this.f$5 = r7;
                        this.f$6 = r8;
                        this.f$7 = r9;
                    }

                    public final void subscribe(ObservableEmitter observableEmitter) {
                        fkg.this.O000000o(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, observableEmitter);
                    }
                }), $$Lambda$fkg$ky854xXIKFLEEqDbxWeZ6KbLrc.INSTANCE).subscribe(new Consumer(o000000o2) {
                    /* class _m_j.$$Lambda$fkg$CKhIpG63sgdgwpmL3mgKTG0Vxkk */
                    private final /* synthetic */ fkg.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void accept(Object obj) {
                        fkg.this.O000000o(this.f$1, (Integer) obj);
                    }
                }, new Consumer(o000000o2) {
                    /* class _m_j.$$Lambda$fkg$7fjQKy_DUNdbMdBKo_DAPdmEc */
                    private final /* synthetic */ fkg.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void accept(Object obj) {
                        fkg.this.O000000o(this.f$1, (Throwable) obj);
                    }
                });
                o000000o2.O000000o(new gsn() {
                    /* class _m_j.fkg.AnonymousClass3 */

                    public final void O000000o() {
                        subscribe.dispose();
                    }
                });
                o000000o.O000000o();
                return;
            }
            o000000o.O00000o0();
        } else {
            fkw.O00000Oo(str3);
            o000000o.O00000o0();
            O000000o("start down isEmpty safeUrl url:".concat(String.valueOf(str)));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(ObservableEmitter observableEmitter) throws Exception {
        ExternalLoadManager.instance.downExternal("amap2d", new fkv(observableEmitter) {
            /* class _m_j.$$Lambda$fkg$94pEHiEaqE7AYLGh5dN2z78dtE */
            private final /* synthetic */ ObservableEmitter f$1;

            {
                this.f$1 = r2;
            }

            public final Object call(Object obj) {
                return fkg.this.O000000o(this.f$1, (ExternalLoadManager.O000000o) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer O000000o(ObservableEmitter observableEmitter, ExternalLoadManager.O000000o o000000o) throws RuntimeException {
        O000000o("downExternal(amap2d)  result:".concat(String.valueOf(o000000o)));
        if (o000000o.f4013O000000o == 2 || o000000o.f4013O000000o == 3) {
            observableEmitter.onNext(2);
            observableEmitter.onComplete();
        } else if (o000000o.f4013O000000o == 4) {
            observableEmitter.tryOnError(new Exception("downExternal(amap2d) fail"));
        }
        return Integer.valueOf(o000000o.f4013O000000o);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer O000000o(ObservableEmitter observableEmitter, Integer num) throws RuntimeException {
        O000000o("downloadRnExtModules result:".concat(String.valueOf(num)));
        if (num.intValue() == 0) {
            observableEmitter.tryOnError(new Exception("downloadRnExtModules fail"));
        } else {
            observableEmitter.onNext(num);
            observableEmitter.onComplete();
        }
        return num;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(gsj gsj, File file, O000000o o000000o, long j, String str, String str2, String str3, ObservableEmitter observableEmitter) throws Exception {
        final O000000o o000000o2 = o000000o;
        final long j2 = j;
        final ObservableEmitter observableEmitter2 = observableEmitter;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        gsg.O000000o(O000000o(), gsj, new gsm(file) {
            /* class _m_j.fkg.AnonymousClass2 */
            private float O0000o00 = 0.0f;

            public final /* synthetic */ void onSuccess(Object obj, Response response) {
                O000000o((File) obj);
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
            /* JADX WARNING: Removed duplicated region for block: B:13:0x0021  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
            /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
            public final void onProgress(long j, long j2) {
                float f;
                float f2;
                float f3;
                if (o000000o2 != null) {
                    long j3 = j2;
                    if (j3 > 0) {
                        f2 = (float) j;
                        f3 = (float) j3;
                    } else if (j2 > 0) {
                        f2 = (float) j;
                        f3 = (float) j2;
                    } else {
                        f = 0.0f;
                        if (f >= 0.0f) {
                            f = 0.0f;
                        } else if (1.0f < f) {
                            f = 1.0f;
                        }
                        if (((double) (f - this.O0000o00)) < 0.01d) {
                            o000000o2.O000000o(f);
                            this.O0000o00 = f;
                            return;
                        }
                        return;
                    }
                    f = f2 / f3;
                    if (f >= 0.0f) {
                    }
                    if (((double) (f - this.O0000o00)) < 0.01d) {
                    }
                }
            }

            public final void O000000o(File file) {
                fkg.O000000o("startDownloadFileInternal onSuccess startDownloadFileInternal-file download onSuccess...");
                observableEmitter2.onNext(1);
                observableEmitter2.onComplete();
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                fkg.O000000o("startDownloadFileInternal onFailure " + gsf + " e:" + Log.getStackTraceString(exc));
                fkw.O00000Oo(str4);
                if (TextUtils.isEmpty(str5)) {
                    fkg.O000000o("startDownloadFileInternal onFailure safeUrl is empty...");
                    observableEmitter2.tryOnError(exc);
                    return;
                }
                File O00000oO2 = fkw.O00000oO(str4);
                if (O00000oO2 == null) {
                    fkg.O000000o("startDownloadFileInternal onFailure downloadingFileHttp is null...");
                    fkw.O00000Oo(str4);
                    observableEmitter2.tryOnError(new Exception("downloadingFileHttp == null"));
                    return;
                }
                fkg.O000000o("startDownloadFileInternal onFailure will downloadPlugin by http...");
                gsj.O000000o o000000o = new gsj.O000000o();
                o000000o.f18212O000000o = "GET";
                o000000o2.O000000o(gsg.O000000o(fkg.this.O000000o(), o000000o.O00000Oo(str6).O000000o(), new gsm(O00000oO2) {
                    /* class _m_j.fkg.AnonymousClass2.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj, Response response) {
                        O000000o((File) obj);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
                    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029  */
                    public final void onProgress(long j, long j2) {
                        float f;
                        float f2;
                        float f3;
                        if (o000000o2 != null) {
                            if (j2 > 0) {
                                f2 = (float) j;
                                f3 = (float) j2;
                            } else if (j2 > 0) {
                                f2 = (float) j;
                                f3 = (float) j2;
                            } else {
                                f = 0.0f;
                                if (f >= 0.0f) {
                                    f = 0.0f;
                                } else if (1.0f < f) {
                                    f = 1.0f;
                                }
                                o000000o2.O000000o(f);
                            }
                            f = f2 / f3;
                            if (f >= 0.0f) {
                            }
                            o000000o2.O000000o(f);
                        }
                    }

                    public final void O000000o(File file) {
                        fkg.O000000o("startDownloadFileInternal onSuccess startDownloadFileInternal-file retry download onSuccess");
                        observableEmitter2.onNext(1);
                        observableEmitter2.onComplete();
                    }

                    public final void onFailure(gsf gsf, Exception exc, Response response) {
                        fkg.O000000o("startDownloadFileInternal onFailure 2 error:" + gsf + " e:" + Log.getStackTraceString(exc));
                        fkw.O00000Oo(str4);
                        observableEmitter2.tryOnError(exc);
                    }
                }));
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(O000000o o000000o, Integer num) throws Exception {
        O000000o("startDownloadFileInternal onSuccess:".concat(String.valueOf(num)));
        if (o000000o != null) {
            o000000o.O00000Oo();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(O000000o o000000o, Throwable th) throws Exception {
        O000000o("startDownloadFileInternal onFailure:" + Log.getStackTraceString(th));
        if (o000000o != null) {
            o000000o.O00000o0();
        }
    }

    public final OkHttpClient O000000o() {
        if (this.O00000o == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            fkb.O000000o(builder);
            this.O00000o = builder.dispatcher(new Dispatcher(goq.O000000o())).connectTimeout(20, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).cookieJar(new JavaNetCookieJar(new CookieManager())).build();
        }
        return this.O00000o;
    }

    public static void O000000o(String str) {
        gsy.O00000o0(LogType.PLUGIN, "PluginManager", "DownTask", str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(ObservableEmitter observableEmitter) throws Exception {
        fcx.f16092O000000o.O000000o(new fkv(observableEmitter) {
            /* class _m_j.$$Lambda$fkg$He9nQyVACk_ZaQkx9xNFhucDqs */
            private final /* synthetic */ ObservableEmitter f$1;

            {
                this.f$1 = r2;
            }

            public final Object call(Object obj) {
                return fkg.this.O000000o(this.f$1, (Integer) obj);
            }
        });
    }
}

package _m_j;

import _m_j.gfg;
import _m_j.gsj;
import _m_j.gye;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.library.log.LogType;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.BiFunction;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Response;

@RouterService
public class gfa implements gye {
    private static gfa sInstance;
    private Context mAppContext = ServiceApplication.getAppContext();
    public volatile gsm mAppUpdateFileAsyncHandler = null;
    public volatile WeakReference<gye.O00000o> mCallbackRef = null;
    private OkHttpClient mOkHttpClient;
    Handler mUiHandler = new Handler(Looper.getMainLooper());
    O00000o mWorkerHandler;
    gpq mWorkerThread = new gpq("UpdateWorker");
    private Map<String, Long> otaStartTimeMap = new HashMap();

    static /* synthetic */ void lambda$checkAppUpdate$6(Boolean bool) throws Exception {
    }

    static /* synthetic */ void lambda$null$1(gye.O00000Oo o00000Oo, gew gew) {
    }

    static /* synthetic */ void lambda$null$2(gye.O00000Oo o00000Oo, gew gew) {
    }

    static /* synthetic */ void lambda$null$3(gye.O00000Oo o00000Oo, gew gew) {
    }

    private gfa() {
        this.mWorkerThread.start();
        this.mWorkerHandler = new O00000o(this.mWorkerThread.getLooper());
    }

    public Long getOtaStartTimeByDid(String str) {
        return this.otaStartTimeMap.get(str);
    }

    public void removeOtaStartTime(String str) {
        this.otaStartTimeMap.remove(str);
    }

    public void putOtaStartTime(String str, long j) {
        this.otaStartTimeMap.put(str, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public void writeLog(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        gsy.O00000o0(LogType.GENERAL, "Wifi-OTA", str);
    }

    @cug
    public static gfa getInstance() {
        if (sInstance == null) {
            sInstance = new gfa();
        }
        return sInstance;
    }

    private OkHttpClient getClient() {
        return gse.O000000o();
    }

    public void setUpdateDialogFlag(int i, int i2) {
        gpy.O00000Oo(this.mAppContext, "pref_update_flag", "update_dialog_flag".concat(String.valueOf(i)), i2);
    }

    public int getUpdateDialogFlag(int i) {
        return gpy.O000000o(this.mAppContext, "pref_update_flag", "update_dialog_flag".concat(String.valueOf(i)), 0);
    }

    public void checkFirmwareUpdate(final String str, int i, final gye.O00000o0 o00000o0) {
        if (!TextUtils.isEmpty(str)) {
            gfb.O000000o().O000000o(this.mAppContext, str, new fsm<gfh, fso>() {
                /* class _m_j.gfa.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    gfh gfh = (gfh) obj;
                    if (gfh != null) {
                        gey gey = new gey();
                        gey.f17608O000000o = str;
                        gey.O00000oO = gfh.O00000o;
                        gey.O00000Oo = gfh.f17654O000000o;
                        gey.O00000o0 = gfh.O00000Oo;
                        gey.O00000o = gfh.O00000o0;
                        gey.O00000oo = gfh.O00000oO;
                        gey.O0000OOo = gfh.O0000O0o;
                        gey.O0000O0o = gfh.O00000oo;
                        gey.O0000Oo0 = gfh.O0000OOo;
                        if ("installing".equals(gey.O0000OOo)) {
                            gey.O00000Oo = true;
                        } else if ("failed".equals(gey.O0000OOo)) {
                            gfa.this.writeLog("checkFirmwareUpdate onSuccess,but ota status is :failed, trigger onFailure!", new Object[0]);
                            onFailure(new fso(-1, "ota failed"));
                            return;
                        }
                        if (gey.O00000oO) {
                            gye.O00000o0 o00000o0 = o00000o0;
                            if (o00000o0 != null) {
                                o00000o0.O00000Oo(gey);
                                return;
                            }
                            return;
                        }
                        gye.O00000o0 o00000o02 = o00000o0;
                        if (o00000o02 != null) {
                            o00000o02.O000000o(gey);
                        }
                    } else if (o00000o0 != null) {
                        gfa.this.writeLog("checkFirmwareUpdate onSuccess,but result is null", new Object[0]);
                        o00000o0.O000000o(-1);
                    }
                }

                public final void onFailure(fso fso) {
                    if (o00000o0 != null) {
                        gfa.this.writeLog("checkFirmwareUpdate onFailure,error detail: %s", fso.toString());
                        o00000o0.O000000o(fso.f17063O000000o);
                    }
                }
            });
        } else if (o00000o0 != null) {
            o00000o0.O000000o(-1);
        }
    }

    public void checkAllFirmwareUpdate(List<KeyValuePair> list, final gye.O000000o o000000o) {
        gfb.O000000o().O000000o(this.mAppContext, list, new fsm<gfg, fso>() {
            /* class _m_j.gfa.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                gfg gfg = (gfg) obj;
                if (gfg == null) {
                    gye.O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.O000000o();
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int size = gfg.O00000o.size();
                for (int i = 0; i < size; i++) {
                    gfg.O000000o o000000o2 = gfg.O00000o.get(i);
                    gey gey = new gey();
                    gey.f17608O000000o = o000000o2.f17653O000000o;
                    gey.O00000oO = o000000o2.O00000oO;
                    gey.O00000Oo = o000000o2.O00000Oo;
                    gey.O00000o0 = o000000o2.O00000o0;
                    gey.O00000o = o000000o2.O00000o;
                    gey.O00000oo = o000000o2.O00000oo;
                    gey.O0000OOo = o000000o2.O0000OOo;
                    gey.O0000O0o = o000000o2.O0000O0o;
                    gey.O0000Oo0 = o000000o2.O0000Oo0;
                    gey.O0000Oo = o000000o2.O0000Oo;
                    if ("installing".equals(gey.O0000OOo)) {
                        gey.O00000Oo = true;
                    }
                    arrayList.add(gey);
                }
                if (arrayList.size() <= 0) {
                    gye.O000000o o000000o3 = o000000o;
                    if (o000000o3 != null) {
                        o000000o3.O000000o(gfg.f17652O000000o, gfg.O00000Oo, gfg.O00000o0);
                        return;
                    }
                    return;
                }
                gye.O000000o o000000o4 = o000000o;
                if (o000000o4 != null) {
                    o000000o4.O000000o(gfg.f17652O000000o, gfg.O00000Oo, gfg.O00000o0, arrayList);
                }
            }

            public final void onFailure(fso fso) {
                gfa gfa = gfa.this;
                gfa.writeLog("checkAllFirmwareUpdate(UpdateManager) onFailure :" + fso.toString(), new Object[0]);
                gye.O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }
        });
    }

    @SuppressLint({"CheckResult"})
    public void checkAppUpdate(Activity activity, gye.O00000Oo o00000Oo) {
        grr.O000000o();
        int O00000o02 = grr.O00000o0(this.mAppContext);
        grr.O000000o();
        String O00000o2 = grr.O00000o(this.mAppContext);
        Observable.zip(checkAppGrayUpdate(O00000o2, O00000o02).onErrorReturnItem(geu.f17605O000000o), checkAppReleaseUpdate(O00000o2, O00000o02).onErrorReturnItem(gew.f17607O000000o), new BiFunction(activity, o00000Oo) {
            /* class _m_j.$$Lambda$gfa$sahuQmx4CqocgRNQ6V734dEu7G0 */
            private final /* synthetic */ Activity f$0;
            private final /* synthetic */ gye.O00000Oo f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object apply(Object obj, Object obj2) {
                return gfa.lambda$checkAppUpdate$5(this.f$0, this.f$1, (geu) obj, (gew) obj2);
            }
        }).subscribe($$Lambda$gfa$F6Jgb976l9MzddoP0J_1B_5cS0A.INSTANCE, $$Lambda$Jxp4LOjD5wh7hYvpBAWXzgH0LNY.INSTANCE);
    }

    static /* synthetic */ Boolean lambda$checkAppUpdate$5(Activity activity, gye.O00000Oo o00000Oo, geu geu, gew gew) throws Exception {
        if (geu == geu.f17605O000000o && gew == gew.f17607O000000o) {
            o00000Oo.getClass();
            activity.runOnUiThread(new Runnable() {
                /* class _m_j.$$Lambda$9uphL0EWe7fTaMckjXNQKrflDZo */

                public final void run() {
                    gye.O00000Oo.this.O000000o();
                }
            });
            gsy.O000000o(LogType.GENERAL, "UpdateManager", "checkAppUpdate: latest");
        } else if (geu != geu.f17605O000000o && gew != gew.f17607O000000o) {
            if (geu.O00000o0 > gew.O00000o) {
                activity.runOnUiThread(new Runnable(geu) {
                    /* class _m_j.$$Lambda$gfa$ueCwfRM6asf9IM5tLt8A0YhB63M */
                    private final /* synthetic */ geu f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        gye.O00000Oo.this.O000000o(this.f$1);
                    }
                });
            } else {
                activity.runOnUiThread(new Runnable(gew) {
                    /* class _m_j.$$Lambda$gfa$bJop9DeHw0k9dlkVRkxybdZRW8k */
                    private final /* synthetic */ gew f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        gfa.lambda$null$1(gye.O00000Oo.this, this.f$1);
                    }
                });
            }
            LogType logType = LogType.GENERAL;
            gsy.O000000o(logType, "UpdateManager", "checkAppUpdate: compare grey: " + geu + " ; release: " + gew);
        } else if (gew != gew.f17607O000000o) {
            if (gew.O00000o0) {
                activity.runOnUiThread(new Runnable(gew) {
                    /* class _m_j.$$Lambda$gfa$a23HW8pz9GwewXqGrVPa7J2jj8 */
                    private final /* synthetic */ gew f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        gfa.lambda$null$2(gye.O00000Oo.this, this.f$1);
                    }
                });
            } else {
                activity.runOnUiThread(new Runnable(gew) {
                    /* class _m_j.$$Lambda$gfa$H0puxgZVukWz5G4LOIaukH7aPpM */
                    private final /* synthetic */ gew f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        gfa.lambda$null$3(gye.O00000Oo.this, this.f$1);
                    }
                });
            }
            gsy.O000000o(LogType.GENERAL, "UpdateManager", "checkAppUpdate: release update: ".concat(String.valueOf(gew)));
        } else {
            activity.runOnUiThread(new Runnable(geu) {
                /* class _m_j.$$Lambda$gfa$I5zAj9oJpCNvzMT6FMR_3mKGBjA */
                private final /* synthetic */ geu f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    gye.O00000Oo.this.O000000o(this.f$1);
                }
            });
            gsy.O000000o(LogType.GENERAL, "UpdateManager", "checkAppUpdate: grey update: ".concat(String.valueOf(geu)));
        }
        return Boolean.TRUE;
    }

    private Observable<geu> checkAppGrayUpdate(String str, int i) {
        return Observable.create(new ObservableOnSubscribe(ServiceApplication.getAppContext().getPackageName() + ".gray", str, i) {
            /* class _m_j.$$Lambda$gfa$BO2m3Tv5uvV9y5boV0iQTaA61cQ */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                gfa.this.lambda$checkAppGrayUpdate$7$gfa(this.f$1, this.f$2, this.f$3, observableEmitter);
            }
        });
    }

    public /* synthetic */ void lambda$checkAppGrayUpdate$7$gfa(String str, String str2, int i, final ObservableEmitter observableEmitter) throws Exception {
        gfb.O000000o().O000000o(this.mAppContext, str, str2, i, new fsm<gfc, fso>() {
            /* class _m_j.gfa.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                gfc gfc = (gfc) obj;
                if (observableEmitter.isDisposed()) {
                    return;
                }
                if (gfc == null) {
                    observableEmitter.onError(new Exception("result == null"));
                    return;
                }
                geu geu = new geu();
                geu.O00000Oo = gfc.f17648O000000o >= 0;
                geu.O00000o0 = gfc.O00000Oo;
                geu.O00000o = gfc.O00000o0;
                geu.O00000oO = gfc.O00000o;
                geu.O00000oo = gfc.O00000oO;
                geu.O0000O0o = gfc.O00000oo;
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "UpdateManager", gfc.O0000O0o + " checkAppGrayUpdate---" + geu.toString());
                if (!geu.O00000Oo || gfc.O0000O0o == 0) {
                    observableEmitter.onNext(geu.f17605O000000o);
                } else {
                    observableEmitter.onNext(geu);
                }
                observableEmitter.onComplete();
            }

            public final void onFailure(fso fso) {
                if (!observableEmitter.isDisposed()) {
                    observableEmitter.onError(new Exception(fso.O00000Oo));
                }
            }
        });
    }

    private Observable<gew> checkAppReleaseUpdate(String str, int i) {
        return Observable.create(new ObservableOnSubscribe(str, i) {
            /* class _m_j.$$Lambda$gfa$1GunL9moA5SvWY1F089jM9YKsMI */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                gfa.this.lambda$checkAppReleaseUpdate$8$gfa(this.f$1, this.f$2, observableEmitter);
            }
        });
    }

    public /* synthetic */ void lambda$checkAppReleaseUpdate$8$gfa(String str, int i, final ObservableEmitter observableEmitter) throws Exception {
        gfb.O000000o().O00000Oo(ServiceApplication.getAppContext(), str, i, new fsm<gfe, fso>() {
            /* class _m_j.gfa.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                gfe gfe = (gfe) obj;
                if (observableEmitter.isDisposed()) {
                    return;
                }
                if (gfe == null) {
                    observableEmitter.onError(new Exception("result == null"));
                    return;
                }
                gew gew = new gew();
                gew.O00000Oo = gfe.f17650O000000o >= 0;
                gew.O00000o0 = false;
                gew.O00000o = gfe.O00000o0;
                gew.O00000oO = gfe.O00000o;
                gew.O00000oo = gfe.O00000oO;
                gew.O0000O0o = gfe.O00000oo;
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "UpdateManager", "checkAppReleaseUpdate---" + gew.toString());
                if (gew.O00000Oo) {
                    observableEmitter.onNext(gew);
                } else {
                    observableEmitter.onNext(gew.f17607O000000o);
                }
                observableEmitter.onComplete();
            }

            public final void onFailure(fso fso) {
                if (!observableEmitter.isDisposed()) {
                    observableEmitter.onError(new Exception(fso.O00000Oo));
                }
            }
        });
    }

    public void startFirmwareUpdateInternal(String str, int i, String str2, final gye.O0000OOo o0000OOo) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            gfb.O000000o();
            gfb.O000000o(this.mAppContext, str, i, new fsm<Void, fso>() {
                /* class _m_j.gfa.AnonymousClass5 */

                public final void onFailure(fso fso) {
                    gye.O0000OOo o0000OOo = o0000OOo;
                    if (o0000OOo != null) {
                        o0000OOo.O00000Oo();
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    gye.O0000OOo o0000OOo = o0000OOo;
                    if (o0000OOo != null) {
                        o0000OOo.O000000o();
                    }
                }
            });
        } else if (o0000OOo != null) {
            o0000OOo.O00000Oo();
        }
    }

    public void startFirmwareUpdatePollInternal(String str, int i, String str2, gye.O0000Oo o0000Oo) {
        O00000o0 o00000o0 = new O00000o0(this, (byte) 0);
        o00000o0.f17632O000000o = str;
        o00000o0.O00000Oo = i;
        o00000o0.O00000o0 = str2;
        o00000o0.O00000o = 0;
        o00000o0.O00000oO = true;
        o00000o0.O0000O0o = o0000Oo;
        this.mWorkerHandler.obtainMessage(3, o00000o0).sendToTarget();
    }

    public void doFirmwareUpdatePollInternal(final O00000o0 o00000o0) {
        if (!o00000o0.O00000oO) {
            writeLog("doFirmwareUpdatePollInternal ,but pollEnabled is False!!!", new Object[0]);
            return;
        }
        o00000o0.O00000o++;
        if (o00000o0.O00000o > o00000o0.O00000oo) {
            writeLog("doFirmwareUpdatePollInternal did=%s, pollCount >60, stop upgrade!", o00000o0.f17632O000000o);
            gsy.O00000o0(LogType.GENERAL, "UpdateManager", "timeOutCount over: " + o00000o0.O00000o);
            this.mWorkerHandler.removeMessages(3, o00000o0);
            o00000o0.O00000oO = false;
            processFirmwareUpdatePollFailureInternal(o00000o0);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        checkFirmwareUpdate(o00000o0.f17632O000000o, o00000o0.O00000Oo, new gye.O00000o0() {
            /* class _m_j.gfa.AnonymousClass6 */

            public final void O000000o(gey gey) {
                String str;
                String str2;
                gfa.this.writeLog("checkFirmwareUpdate(UpdateManager) onUpdate firmwareInfo=%s".concat(String.valueOf(gey)), new Object[0]);
                if (TextUtils.isEmpty(gey.O00000o0) || !o00000o0.O00000oO) {
                    gfa.this.doSendNextMessage(currentTimeMillis, o00000o0);
                    return;
                }
                if (gey.O0000Oo0 > 0) {
                    o00000o0.O00000oo = gey.O0000Oo0;
                    LogType logType = LogType.GENERAL;
                    gsy.O00000o0(logType, "UpdateManager", "timeOutCount init : " + gey.O0000Oo0);
                }
                if (gey.O00000o0.startsWith("_")) {
                    str = gey.O00000o0.substring(1);
                } else {
                    str = gey.O00000o0;
                }
                if (o00000o0.O00000o0.startsWith("_")) {
                    str2 = o00000o0.O00000o0.substring(1);
                } else {
                    str2 = o00000o0.O00000o0;
                }
                if (str.equalsIgnoreCase(str2)) {
                    gfa.this.mWorkerHandler.removeMessages(3, o00000o0);
                    o00000o0.O00000oO = false;
                    gsy.O00000o0(LogType.GENERAL, "UpdateManager", "equalsIgnoreCase: ");
                    gfa.this.processFirmwareUpdatePollSuccessInternal(o00000o0);
                    return;
                }
                if ("gateway_busy".equals(gey.O0000OOo)) {
                    o00000o0.O00000o = 0;
                    gfa.this.doSendNextMessage(System.currentTimeMillis() + 2000, o00000o0);
                } else {
                    gfa.this.doSendNextMessage(currentTimeMillis, o00000o0);
                }
                gfa.this.processFirmwareUpdatePollProgressInternal(o00000o0, ((float) gey.O0000O0o) / 100.0f, gey.O0000OOo);
            }

            public final void O00000Oo(gey gey) {
                String str;
                String str2;
                gfa.this.writeLog("checkFirmwareUpdate(UpdateManager) onLatest firmwareInfo=%s".concat(String.valueOf(gey)), new Object[0]);
                gfa.this.doSendNextMessage(currentTimeMillis, o00000o0);
                if (!TextUtils.isEmpty(gey.O00000o0) && o00000o0.O00000oO) {
                    if (gey.O00000o0.startsWith("_")) {
                        str = gey.O00000o0.substring(1);
                    } else {
                        str = gey.O00000o0;
                    }
                    if (o00000o0.O00000o0.startsWith("_")) {
                        str2 = o00000o0.O00000o0.substring(1);
                    } else {
                        str2 = o00000o0.O00000o0;
                    }
                    if (str.equalsIgnoreCase(str2)) {
                        gfa.this.mWorkerHandler.removeMessages(3, o00000o0);
                        O00000o0 o00000o0 = o00000o0;
                        o00000o0.O00000oO = false;
                        gfa.this.processFirmwareUpdatePollSuccessInternal(o00000o0);
                    }
                }
            }

            public final void O000000o(int i) {
                gfa.this.writeLog("checkFirmwareUpdate(UpdateManager) onCheckFailure errorCode=%d", Integer.valueOf(i));
                gfa.this.mWorkerHandler.removeMessages(3, o00000o0);
                if (i == -12) {
                    gfa.this.doSendNextMessage(System.currentTimeMillis() + 2000, o00000o0);
                    return;
                }
                O00000o0 o00000o0 = o00000o0;
                o00000o0.O00000oO = false;
                gfa.this.processFirmwareUpdatePollFailureInternal(o00000o0);
            }
        });
    }

    public void doSendNextMessage(long j, O00000o0 o00000o0) {
        long currentTimeMillis = 2000 - (System.currentTimeMillis() - j);
        if (currentTimeMillis < 0) {
            currentTimeMillis = 0;
        }
        O00000o o00000o = this.mWorkerHandler;
        o00000o.sendMessageDelayed(o00000o.obtainMessage(3, o00000o0), currentTimeMillis);
    }

    public void processFirmwareUpdatePollProgressInternal(O00000o0 o00000o0, float f, String str) {
        if (o00000o0 != null && o00000o0.O0000O0o != null) {
            o00000o0.O0000O0o.O000000o(f, str);
        }
    }

    public void processFirmwareUpdatePollSuccessInternal(O00000o0 o00000o0) {
        if (o00000o0 != null && o00000o0.O0000O0o != null) {
            o00000o0.O0000O0o.O000000o();
        }
    }

    public void processFirmwareUpdatePollFailureInternal(O00000o0 o00000o0) {
        if (o00000o0 != null && o00000o0.O0000O0o != null) {
            o00000o0.O0000O0o.O00000Oo();
        }
    }

    public void startFirmwareUpdate(String str, int i, String str2, final gye.O0000O0o o0000O0o) {
        O000000o o000000o = new O000000o(this, (byte) 0);
        o000000o.f17629O000000o = str;
        o000000o.O00000Oo = i;
        o000000o.O00000o0 = str2;
        o000000o.O00000o = new gye.O0000OOo() {
            /* class _m_j.gfa.AnonymousClass7 */

            public final void O000000o() {
                if (o0000O0o != null) {
                    gfa.this.mUiHandler.post(new Runnable() {
                        /* class _m_j.gfa.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            o0000O0o.O000000o();
                        }
                    });
                }
            }

            public final void O00000Oo() {
                if (o0000O0o != null) {
                    gfa.this.mUiHandler.post(new Runnable() {
                        /* class _m_j.gfa.AnonymousClass7.AnonymousClass2 */

                        public final void run() {
                            o0000O0o.O00000Oo();
                        }
                    });
                }
            }
        };
        this.mWorkerHandler.obtainMessage(1, o000000o).sendToTarget();
    }

    public void startFirmwareUpdatePoll(String str, int i, String str2, final gye.O0000Oo0 o0000Oo0) {
        O00000Oo o00000Oo = new O00000Oo(this, (byte) 0);
        o00000Oo.f17630O000000o = str;
        o00000Oo.O00000Oo = i;
        o00000Oo.O00000o0 = str2;
        o00000Oo.O00000o = new gye.O0000Oo() {
            /* class _m_j.gfa.AnonymousClass8 */

            public final void O000000o(final float f, final String str) {
                if (o0000Oo0 != null) {
                    gfa.this.mUiHandler.post(new Runnable() {
                        /* class _m_j.gfa.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            o0000Oo0.O000000o(f);
                        }
                    });
                }
            }

            public final void O000000o() {
                if (o0000Oo0 != null) {
                    gfa.this.mUiHandler.post(new Runnable() {
                        /* class _m_j.gfa.AnonymousClass8.AnonymousClass2 */

                        public final void run() {
                            o0000Oo0.O000000o();
                        }
                    });
                }
            }

            public final void O00000Oo() {
                if (o0000Oo0 != null) {
                    gfa.this.mUiHandler.post(new Runnable() {
                        /* class _m_j.gfa.AnonymousClass8.AnonymousClass3 */

                        public final void run() {
                            o0000Oo0.O00000Oo();
                        }
                    });
                }
            }
        };
        this.mWorkerHandler.obtainMessage(2, o00000Oo).sendToTarget();
    }

    private String getAppDownloadLocalDir() {
        File[] O00000Oo2 = ContextCompat.O00000Oo(ServiceApplication.getAppContext());
        if (("mounted".equals(Environment.getExternalStorageState()) || !goa.O000000o()) && O00000Oo2.length > 0) {
            return O00000Oo2[0].getAbsolutePath();
        }
        return ServiceApplication.getAppContext().getCacheDir().getPath() + File.separator + "app";
    }

    private String getAppDownloadLocalName(int i) {
        return "SmartHome_" + i + ".apk";
    }

    public void destroy() {
        if (this.mAppUpdateFileAsyncHandler != null) {
            this.mAppUpdateFileAsyncHandler.O0000OoO = true;
            this.mAppUpdateFileAsyncHandler = null;
        }
    }

    public void setAppDownloadCallback(gye.O00000o o00000o) {
        this.mCallbackRef = new WeakReference<>(o00000o);
    }

    public void startDownloadApp(String str, int i, long j) {
        String str2 = null;
        gye.O00000o o00000o = this.mCallbackRef == null ? null : this.mCallbackRef.get();
        if (!TextUtils.isEmpty(str)) {
            String appDownloadLocalDir = getAppDownloadLocalDir();
            if (TextUtils.isEmpty(appDownloadLocalDir)) {
                if (o00000o != null) {
                    o00000o.O000000o();
                }
                gsy.O00000o0(LogType.GENERAL, "UpdateManager", "UpdateManager.startDownloadApp localDir:".concat(String.valueOf(appDownloadLocalDir)));
                return;
            }
            this.mCallbackRef = new WeakReference<>(o00000o);
            if (this.mAppUpdateFileAsyncHandler == null) {
                final String str3 = appDownloadLocalDir + File.separator + getAppDownloadLocalName(i);
                long j2 = 0;
                File file = new File(str3);
                if (file.exists()) {
                    j2 = file.length();
                }
                File O00000o02 = fws.O00000o0(str3);
                if (O00000o02 == null) {
                    fws.O000000o(str3);
                    if (o00000o != null) {
                        o00000o.O000000o();
                        return;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                StringBuffer stringBuffer = new StringBuffer("bytes=");
                int i2 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
                if (j2 != -1) {
                    if (j2 == -1) {
                        stringBuffer.append(new StringBuilder("--1").toString());
                        str2 = stringBuffer.toString();
                    } else {
                        stringBuffer.append(j2 + "-");
                        str2 = stringBuffer.toString();
                    }
                }
                hashMap.put("Range", str2);
                gsj.O000000o o000000o = new gsj.O000000o();
                o000000o.f18212O000000o = "GET";
                final String str4 = str;
                gsj O000000o2 = o000000o.O000000o(hashMap).O00000Oo(str).O000000o();
                final long j3 = j;
                final int i3 = i;
                this.mAppUpdateFileAsyncHandler = new gsm(O00000o02) {
                    /* class _m_j.gfa.AnonymousClass9 */

                    public final /* synthetic */ void onSuccess(Object obj, Response response) {
                        O000000o((File) obj);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
                    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029  */
                    public final void onProgress(long j, long j2) {
                        float f;
                        float f2;
                        float f3;
                        gye.O00000o o00000o = gfa.this.mCallbackRef.get();
                        if (o00000o != null) {
                            long j3 = j3;
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
                                gsy.O00000o0(LogType.GENERAL, "UpdateManager", "UpdateManager app download onProgress ".concat(String.valueOf(f)));
                                o00000o.O000000o(f);
                            }
                            f = f2 / f3;
                            if (f >= 0.0f) {
                            }
                            gsy.O00000o0(LogType.GENERAL, "UpdateManager", "UpdateManager app download onProgress ".concat(String.valueOf(f)));
                            o00000o.O000000o(f);
                        }
                    }

                    public final void O000000o(File file) {
                        gfa.this.mCallbackRef.get();
                        gfa.this.mAppUpdateFileAsyncHandler = null;
                    }

                    public final void onFailure(gsf gsf, Exception exc, Response response) {
                        LogType logType = LogType.GENERAL;
                        gsy.O00000o0(logType, "UpdateManager", "UpdateManager app download onFailure " + gsf.O00000Oo);
                        fws.O000000o(str3);
                        if (gsf.f18205O000000o == 416) {
                            gfa gfa = gfa.this;
                            gfa.mAppUpdateFileAsyncHandler = null;
                            gfa.startDownloadApp(str4, i3, j3);
                            return;
                        }
                        gye.O00000o o00000o = gfa.this.mCallbackRef.get();
                        if (o00000o != null) {
                            o00000o.O000000o();
                        }
                        gfa.this.mAppUpdateFileAsyncHandler = null;
                    }
                };
                gsg.O000000o(getClient(), O000000o2, this.mAppUpdateFileAsyncHandler);
            }
        } else if (o00000o != null) {
            o00000o.O000000o();
        }
    }

    public void destroyUpdateItemHelper() {
        gez.O000000o().O000000o(true);
    }

    class O00000o extends Handler {
        O00000o(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 && (message.obj instanceof O00000o0)) {
                        gfa.this.doFirmwareUpdatePollInternal((O00000o0) message.obj);
                    }
                } else if (message.obj instanceof O00000Oo) {
                    O00000Oo o00000Oo = (O00000Oo) message.obj;
                    gfa.this.startFirmwareUpdatePollInternal(o00000Oo.f17630O000000o, o00000Oo.O00000Oo, o00000Oo.O00000o0, o00000Oo.O00000o);
                }
            } else if (message.obj instanceof O000000o) {
                O000000o o000000o = (O000000o) message.obj;
                gfa.this.startFirmwareUpdateInternal(o000000o.f17629O000000o, o000000o.O00000Oo, o000000o.O00000o0, o000000o.O00000o);
            }
        }
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f17629O000000o;
        int O00000Oo;
        gye.O0000OOo O00000o;
        String O00000o0;

        private O000000o() {
        }

        /* synthetic */ O000000o(gfa gfa, byte b) {
            this();
        }
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f17630O000000o;
        int O00000Oo;
        gye.O0000Oo O00000o;
        String O00000o0;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(gfa gfa, byte b) {
            this();
        }
    }

    class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        String f17632O000000o;
        int O00000Oo;
        int O00000o;
        String O00000o0;
        boolean O00000oO;
        int O00000oo;
        gye.O0000Oo O0000O0o;

        private O00000o0() {
            this.O00000oo = 60;
        }

        /* synthetic */ O00000o0(gfa gfa, byte b) {
            this();
        }
    }
}

package _m_j;

import _m_j.geq;
import _m_j.guj;
import _m_j.guk;
import _m_j.gul;
import _m_j.guo;
import _m_j.guv;
import _m_j.gyc;
import _m_j.gyd;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.messagecenter.TypeListMsgCacheManager;
import com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity;
import com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import com.xiaomi.smarthome.miio.db.record.MessageRecordTypeList;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@RouterService
public class gun implements guz {
    public boolean clickCommonMessage(JSONObject jSONObject) {
        return gug.O000000o(jSONObject);
    }

    public void gotoMyScene() {
        gug.O000000o();
    }

    public gul getShareMessageByRecord(MessageRecord messageRecord) {
        return new guv().O000000o(messageRecord);
    }

    public gul getHomeShareMessageByRecord(MessageRecord messageRecord) {
        return new guk().O000000o(messageRecord);
    }

    public gul getHomeFastConnectMessageByRecord(MessageRecord messageRecord) {
        return new guj().O000000o(messageRecord);
    }

    public void alertFastConnectSuccessDialog(Activity activity, gul gul) {
        if (gul instanceof guj.O000000o) {
            gsy.O00000o0(LogType.KUAILIAN, "wugan", "alert wugan config sussess dialog");
            guj.O000000o(activity, (guj.O000000o) gul);
        }
    }

    public Class<?> getMessageCenterActivity() {
        return MessageCenterActivity.class;
    }

    public Class<?> getMessageCenterDeviceListActivityNew() {
        return MessageCenterDeviceListActivityNew.class;
    }

    public void checkNewMessage() {
        guo O000000o2 = guo.O000000o();
        Observable.create(new ObservableOnSubscribe<Object>() {
            /* class _m_j.guo.AnonymousClass2 */

            public final void subscribe(final ObservableEmitter observableEmitter) {
                fru.O000000o().O000000o(ServiceApplication.getAppContext(), gvb.O000000o(), new fsm<JSONArray, fso>() {
                    /* class _m_j.guo.AnonymousClass2.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        observableEmitter.onNext((JSONArray) obj);
                        observableEmitter.onComplete();
                    }

                    public final void onFailure(fso fso) {
                        observableEmitter.onNext(new JSONArray());
                        observableEmitter.onComplete();
                    }
                });
            }
        }).onErrorReturn(new Function<Throwable, Object>() {
            /* class _m_j.guo.AnonymousClass1 */

            public final /* synthetic */ Object apply(Object obj) {
                return new JSONArray();
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    public void checkNewMessageForProfile(long j, int i) {
        guo.O000000o();
        LogType logType = LogType.GENERAL;
        gsy.O000000o(logType, "MessageCenter", "-----checkNewMessageForProfile timeStamp" + j + "  type  " + i);
        gui.O000000o(j, i);
    }

    public boolean isHomeShareMessage(gul gul) {
        return gul instanceof guk.O000000o;
    }

    public boolean isShareMessage(gul gul) {
        return gul instanceof guv.O000000o;
    }

    public long getHomeOwner(gul gul) {
        return ((guk.O000000o) gul).O00000Oo;
    }

    public long getHomeId(gul gul) {
        return ((guk.O000000o) gul).f18300O000000o;
    }

    public Device getShareMessageDevice(gul gul) {
        return ((guv.O000000o) gul).f18320O000000o;
    }

    public int getShareMessageInvitedId(gul gul) {
        return (int) ((guv.O000000o) gul).O00000Oo;
    }

    public String getShareMessageMsgId(gul gul) {
        return ((guv.O000000o) gul).O00000o0();
    }

    public void checkAndShow(CommonActivity commonActivity) {
        gxc.O000000o(commonActivity);
    }

    public void setUserInfoToSecurityCenter(Context context, boolean z, String str, String str2) {
        gxc.O000000o(context, z, str, str2);
    }

    public void setRedPointView(String str, gus gus) {
        ges O000000o2 = ges.O000000o();
        O000000o2.O00000o0.put(str, gus);
        O000000o2.O00000Oo(str);
    }

    public void setRedPointViewOld(String str, gus gus) {
        eyp.O000000o().O00000Oo.put(str, gus);
    }

    public void removeRedPointView(String str) {
        ges.O000000o().O000000o(str);
    }

    public void removeRedPointViewOld(String str) {
        eyp.O000000o().O00000Oo.remove(str);
    }

    public void notifyRedPointChanged(String str) {
        ges.O000000o().O00000Oo(str);
    }

    public void notifyRedPointChangedOld(String str) {
        boolean z;
        eyp O000000o2 = eyp.O000000o();
        List<gut> list = O000000o2.f15950O000000o.get(str);
        if (list != null) {
            z = false;
            for (gut O000000o3 : list) {
                z |= O000000o3.O000000o();
            }
        } else {
            z = false;
        }
        if (O000000o2.O00000Oo.get(str) == null) {
            return;
        }
        if (z) {
            O000000o2.O00000Oo.get(str).showRedPoint(true);
        } else {
            O000000o2.O00000Oo.get(str).showRedPoint(false);
        }
    }

    public void checkModelUpdate(Activity activity) {
        guo O000000o2 = guo.O000000o();
        gsy.O000000o(LogType.GENERAL, "MessageCenter", "checkModelUpdate");
        O000000o2.O00000o = 0;
        gyh.O000000o().batchCheckModelUpdate(new gyd.O000000o(new WeakReference(activity)) {
            /* class _m_j.guo.AnonymousClass4 */

            /* renamed from: O000000o */
            final /* synthetic */ WeakReference f18311O000000o;

            {
                this.f18311O000000o = r2;
            }

            public final void O000000o(List<gyf> list) {
                if (list == null || list.size() <= 0) {
                    guo guo = guo.this;
                    guo.O00000o = 2;
                    guo.O00000Oo();
                    return;
                }
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        break;
                    }
                    gyf gyf = list.get(i);
                    if (!gyf.O0000OOo) {
                        try {
                            Device O000000o2 = fno.O000000o().O000000o(gyf.O00000Oo);
                            if (O000000o2 != null) {
                                if (O000000o2.isOnline) {
                                    z = true;
                                    break;
                                }
                            }
                        } catch (Exception unused) {
                            continue;
                        }
                    }
                    i++;
                }
                if (!z) {
                    guo guo2 = guo.this;
                    guo2.O00000o = 2;
                    guo2.O00000Oo();
                    return;
                }
                geq O000000o3 = geq.O000000o();
                AnonymousClass1 r1 = new geq.O000000o() {
                    /* class _m_j.guo.AnonymousClass4.AnonymousClass1 */

                    public final void O000000o(boolean z) {
                        guo.this.O0000O0o = z;
                    }
                };
                O000000o3.f17600O000000o = list;
                goq.O000000o(new Runnable(r1) {
                    /* class _m_j.geq.AnonymousClass1 */

                    /* renamed from: O000000o */
                    final /* synthetic */ O000000o f17601O000000o;

                    {
                        this.f17601O000000o = r2;
                    }

                    public final void run() {
                        boolean O00000Oo2 = geq.this.O00000Oo();
                        O000000o o000000o = this.f17601O000000o;
                        if (o000000o != null) {
                            o000000o.O000000o(O00000Oo2);
                        }
                    }
                });
                gyh.O000000o().isAllModelUpdateIgnoreAsync(new gyd.O00000Oo(this.f18311O000000o) {
                    /* class _m_j.$$Lambda$guo$4$VFCtclNeIKI9PGp5gNLG6ul5d2g */
                    private final /* synthetic */ WeakReference f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onResult(boolean z) {
                        guo.AnonymousClass4.this.O000000o(this.f$1, z);
                    }
                });
            }

            /* access modifiers changed from: public */
            private /* synthetic */ void O000000o(WeakReference weakReference, final boolean z) {
                Activity activity = (Activity) weakReference.get();
                if (activity != null && !activity.isFinishing()) {
                    activity.runOnUiThread(new Runnable() {
                        /* class _m_j.guo.AnonymousClass4.AnonymousClass2 */

                        public final void run() {
                            boolean z = z;
                            if (z) {
                                if (z) {
                                    guo.this.O00000o = 3;
                                } else {
                                    guo.this.O00000o = 1;
                                }
                                guo.this.O00000Oo();
                                guo.this.O00000o = 3;
                            } else {
                                guo.this.O00000o = 1;
                            }
                            guo.this.O00000Oo();
                        }
                    });
                }
            }

            public final void O000000o() {
                guo guo = guo.this;
                guo.O00000o = 2;
                guo.O00000Oo();
            }
        });
    }

    public void checkAppUpdate(Activity activity) {
        guo O000000o2 = guo.O000000o();
        gsy.O000000o(LogType.GENERAL, "MessageCenter", "checkAppUpdate");
        WeakReference weakReference = new WeakReference(activity);
        gyc O00000Oo = gyh.O00000Oo();
        O00000Oo.checkUpdate(new gyc.O000000o(O00000Oo, weakReference) {
            /* class _m_j.guo.AnonymousClass5 */

            /* renamed from: O000000o */
            final /* synthetic */ gyc f18314O000000o;
            final /* synthetic */ WeakReference O00000Oo;

            {
                this.f18314O000000o = r2;
                this.O00000Oo = r3;
            }

            public final void O000000o() {
                if (this.f18314O000000o.hasNewVersion()) {
                    guo.this.O00000oO = 1;
                    Activity activity = (Activity) this.O00000Oo.get();
                    if (activity != null && !activity.isFinishing()) {
                        boolean isNewVersionIgnore = this.f18314O000000o.isNewVersionIgnore();
                        guo guo = guo.this;
                        geq.O000000o();
                        guo.O0000OOo = gyh.O00000Oo().hasNewVersion() && gpv.O000000o(ServiceApplication.getAppContext(), "setting_main_app_update_ignore_prefix") == gyh.O00000Oo().getNewVersionCode();
                        if (this.f18314O000000o.getmForceUpdate() == 1) {
                            Activity activity2 = (Activity) this.O00000Oo.get();
                            if (activity2 != null && !activity2.isFinishing()) {
                                this.f18314O000000o.showForceUpdateDialog(activity2);
                            } else {
                                return;
                            }
                        } else if (this.f18314O000000o.getmForceUpdate() == 2) {
                            Activity activity3 = (Activity) this.O00000Oo.get();
                            if (activity3 != null && !activity3.isFinishing()) {
                                this.f18314O000000o.showHalfForceUpdateDialog(activity3);
                            } else {
                                return;
                            }
                        } else if (isNewVersionIgnore) {
                            guo.this.O00000oO = 3;
                        }
                    } else {
                        return;
                    }
                } else {
                    guo.this.O00000oO = 2;
                }
                guo.this.O00000Oo();
            }

            public final void O00000Oo() {
                guo guo = guo.this;
                guo.O00000oO = 2;
                guo.O00000Oo();
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
     arg types: [java.util.ArrayList<java.lang.String>, int, _m_j.guo$7]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void */
    public void checkPluginUpdate() {
        guo O000000o2 = guo.O000000o();
        if (O000000o2.O00000oo != 0) {
            LogType logType = LogType.GENERAL;
            gsy.O00000o0(logType, "MessageCenter", "checkPluginUpdate checked " + O000000o2.O00000oo);
            return;
        }
        gsy.O000000o(LogType.GENERAL, "MessageCenter", "checkPluginUpdate");
        O000000o2.O0000OOo = true;
        CoreApi.O000000o().O000000o((List<String>) hgy.O000000o(), false, (CoreApi.O0000O0o) new CoreApi.O0000O0o() {
            /* class _m_j.guo.AnonymousClass7 */

            public final void O000000o() {
            }

            public final void O000000o(String str) {
            }

            public final void O000000o(String str, float f) {
            }

            public final void O000000o(List<PluginDownloadTask> list) {
            }

            public final void O00000Oo(List<PluginDownloadTask> list) {
                boolean z;
                guo.this.O00000Oo = list;
                boolean z2 = false;
                boolean z3 = true;
                for (PluginDownloadTask next : list) {
                    if (CoreApi.O000000o().O0000Oo(next.f6738O000000o) != null) {
                        z3 = gyh.O000000o().isPluginUpdateIgnore(next.f6738O000000o, next.O00000Oo) & z3;
                        z2 = true;
                    }
                }
                if (z2) {
                    if (z3) {
                        guo.this.O00000oo = 3;
                    } else {
                        guo.this.O00000oo = 1;
                    }
                    guo guo = guo.this;
                    geq.O000000o();
                    boolean z4 = true;
                    for (PluginDownloadTask next2 : list) {
                        if (CoreApi.O000000o().O0000Oo(next2.f6738O000000o) != null) {
                            String str = next2.f6738O000000o;
                            int i = next2.O00000Oo;
                            if (!TextUtils.isEmpty(str)) {
                                String O000000o2 = gpv.O000000o(ServiceApplication.getAppContext(), "setting_main_plugin_update_ignore_prefix".concat(String.valueOf(str)), (String) null);
                                LogType logType = LogType.GENERAL;
                                gsy.O000000o(logType, "ProfileRedPointManager", "isPluginUpdateIgnore" + str + "****** ignoreVersion   " + O000000o2 + "   currVersion" + i);
                                if (!TextUtils.isEmpty(O000000o2) && O000000o2.equals(String.valueOf(i))) {
                                    z = true;
                                    z4 &= z;
                                }
                            }
                            z = false;
                            z4 &= z;
                        }
                    }
                    guo.O0000Oo0 = z4;
                } else {
                    guo.this.O00000oo = 2;
                }
                guo.this.O00000Oo();
            }

            public final void O000000o(PluginError pluginError) {
                guo guo = guo.this;
                guo.O00000oo = 2;
                guo.O00000Oo();
            }
        });
    }

    public void checkRnSdkUpdate() {
        guo.O000000o().O00000o();
    }

    public void checkRnConfigUpdate() {
        guo.O000000o();
        hmq.O000000o().checkRnConfigUpdate();
    }

    public void miuiP0msgResolver(Context context, Intent intent, String str) {
        gxb gxb = new gxb(context, intent.getStringExtra("uid"), str);
        gxa gxa = new gxa(context, intent.getStringExtra("srv"), str);
        gwz gwz = new gwz(context, intent.getStringExtra("did"), intent.getStringExtra("homeid"), intent.getStringExtra("extra"));
        gxb.O000000o(gxa);
        gxa.O000000o(gwz);
        gxb.O00000Oo();
    }

    public void messageCenterDestroy() {
        guo O000000o2 = guo.O000000o();
        gsy.O00000Oo("MessageCenter", "destroy");
        O000000o2.O00000o0();
        O000000o2.O0000Oo = null;
        O000000o2.O00000o0 = null;
        guo.f18306O000000o = null;
    }

    public void clearRedPointListener() {
        ges O000000o2 = ges.O000000o();
        gsy.O00000Oo("MessageCenter", "clearRedPointListener");
        O000000o2.O00000o0.clear();
        O000000o2.O00000Oo.clear();
        ges.f17603O000000o = null;
    }

    public Map<String, gus> getRedPointViewMap() {
        return ges.O000000o().O00000o0;
    }

    public void removeRedPointViewNew(String str) {
        ges.O000000o().O000000o(str);
    }

    public void clearRedPointListenerOld() {
        eyp O000000o2 = eyp.O000000o();
        O000000o2.O00000Oo.clear();
        O000000o2.f15950O000000o.clear();
    }

    public void notifyViewClicked(String str) {
        ges O000000o2 = ges.O000000o();
        if (O000000o2.O00000Oo.containsKey(str)) {
            for (guu O00000Oo : O000000o2.O00000Oo.get(str)) {
                O00000Oo.O00000Oo(str);
            }
        }
        O000000o2.O00000Oo(str);
    }

    public void removeDeviceAllPushMessages(String str) {
        TypeListMsgCacheManager O000000o2 = TypeListMsgCacheManager.O000000o();
        if (!TextUtils.isEmpty(str)) {
            goq.O000000o(new Runnable(str) {
                /* class com.xiaomi.smarthome.messagecenter.TypeListMsgCacheManager.AnonymousClass2 */

                /* renamed from: O000000o */
                final /* synthetic */ String f9423O000000o;

                {
                    this.f9423O000000o = r2;
                }

                public final void run() {
                    TypeListMsgCacheManager typeListMsgCacheManager = TypeListMsgCacheManager.this;
                    if (Looper.getMainLooper() != Looper.myLooper()) {
                        List<MessageRecordTypeList> queryAllByRange = MessageRecordTypeList.queryAllByRange(System.currentTimeMillis() / 1000, 0, 5000);
                        if (!(queryAllByRange == null || typeListMsgCacheManager.f9421O000000o == null)) {
                            typeListMsgCacheManager.f9421O000000o = queryAllByRange;
                        }
                        typeListMsgCacheManager.O00000Oo = new ArrayList();
                        typeListMsgCacheManager.O00000o0 = new ArrayList();
                        typeListMsgCacheManager.O000000o(queryAllByRange, typeListMsgCacheManager.O00000Oo, typeListMsgCacheManager.O00000o0);
                        Iterator<Pair<O000000o, List<gul>>> it = TypeListMsgCacheManager.this.O00000Oo.iterator();
                        ArrayList arrayList = new ArrayList();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Pair next = it.next();
                            if (TextUtils.equals(this.f9423O000000o, ((O000000o) next.first).f9424O000000o)) {
                                int i = 0;
                                while (i < ((List) next.second).size()) {
                                    try {
                                        arrayList.add(((gul) ((List) next.second).get(i)).O00000o0());
                                        i++;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                it.remove();
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            MessageRecordTypeList.batchDelete(arrayList);
                        }
                        TypeListMsgCacheManager.this.f9421O000000o.clear();
                        TypeListMsgCacheManager.this.O00000Oo.clear();
                        TypeListMsgCacheManager.this.O00000o0.clear();
                        return;
                    }
                    throw new RuntimeException();
                }
            });
        }
    }

    public void registerListener(String str, guu guu) {
        ges.O000000o().O000000o(str, guu);
    }

    public void registerListenerOld(String str, gut gut) {
        eyp O000000o2 = eyp.O000000o();
        List list = O000000o2.f15950O000000o.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        list.add(gut);
        O000000o2.f15950O000000o.put(str, list);
    }

    public void unregisterListener(String str, guu guu) {
        ges O000000o2 = ges.O000000o();
        List list = O000000o2.O00000Oo.get(str);
        if (list != null) {
            list.remove(guu);
        }
        O000000o2.O00000Oo(str);
    }

    public void unregisterListenerOld(String str, gut gut) {
        List list = eyp.O000000o().f15950O000000o.get(str);
        if (list != null) {
            list.remove(gut);
        }
    }

    public void checkFeedback() {
        hyv.O000000o().getRedDotCount(ServiceApplication.getAppContext(), new fsm<Integer, fso>() {
            /* class _m_j.guo.AnonymousClass3 */

            public final void onFailure(fso fso) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                guo.this.O000000o("new_feedback", (Integer) obj, false);
            }
        });
    }

    public void setSignStateTodayIgnore() {
        guo.O000000o();
        gpy.O000000o(ServiceApplication.getAppContext(), "prefs_sign_state", "sign_state_ignore_key", System.currentTimeMillis());
    }

    public void postEvent(String str, Object obj, boolean z) {
        guo.O000000o().O000000o(str, obj, z);
    }

    public void setAllModelUpdateIgnore() {
        geq.O000000o().O00000o0();
    }

    public void setAllPluginUpdateIgnore() {
        geq.O000000o().O00000o();
    }

    public void ignoreThisNewVersion() {
        geq.O000000o().O00000oO();
    }

    public List<PluginDownloadTask> getLastCheckUpdateInfos() {
        return guo.O000000o().O00000Oo;
    }

    public void registerListener(String str, gup gup) {
        guo.O000000o().O000000o(str, gup);
    }

    public void unregisterListener(String str, gup gup) {
        guo.O000000o().O000000o(str, gup);
    }
}

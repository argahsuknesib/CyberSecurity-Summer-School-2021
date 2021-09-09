package _m_j;

import _m_j.gzq;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.adapter.MainCameraCardModel;
import com.xiaomi.smarthome.newui.mainpage.devicepage.ThrottleFirstAndLastObserver;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.DevicePageRoomPresenter$bindIntents$dataSetChanged$6$lazyRenderDevicesData$1$1;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.DevicePageRoomPresenter$bindIntents$initialState$1$commonDeviceCache$1;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.DevicePageRoomPresenter$bindIntents$initialState$1$otherDeviceCache$2$1;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.DeviceRoomRenderState;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DevicePageRoomPresenter;", "Lcom/hannesdorfmann/mosby3/mvi/MviBasePresenter;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomPageView;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState;", "()V", "bindIntents", "", "refreshIrBindCount", "Companion", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hia extends ayp<hib, DeviceRoomRenderState> {
    public static final O000000o O00000Oo = new O000000o((byte) 0);

    /* access modifiers changed from: private */
    public static final boolean O000000o(int i) {
        return i == 3;
    }

    /* access modifiers changed from: private */
    public static final boolean O00000o0(int i) {
        return i == 2;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DevicePageRoomPresenter$Companion;", "", "()V", "TAG", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    /* access modifiers changed from: private */
    public static final Observable O000000o(hib hib) {
        ixe.O00000o(hib, "view");
        return hib.O000000o();
    }

    public final void O00000o0() {
        Observable observable;
        List list;
        Observable O000000o2 = O000000o($$Lambda$hia$D4HZysAnu0WhCLlZgrYYnEjbILU.INSTANCE);
        CommonApplication application = CommonApplication.getApplication();
        ixe.O00000Oo(application, "getApplication()");
        Observable mergeWith = O000000o2.mergeWith(new hne("action_favorite_update", application).map($$Lambda$hia$QM0Fn1yNbbGtSz6ahU0cGPgSWqk.INSTANCE));
        CommonApplication application2 = CommonApplication.getApplication();
        ixe.O00000Oo(application2, "getApplication()");
        Observable doOnNext = mergeWith.mergeWith(new hne("action_freq_camera_update", application2).map($$Lambda$hia$NAU07SrWGPkBdvuckWmQA8Nubv4.INSTANCE)).lift($$Lambda$hia$geM85Hz92adMFUwiWO60La3WYnU.INSTANCE).filter($$Lambda$hia$EOJsAqSoJY4kuSDAvUHSbbOX1pg.INSTANCE).map($$Lambda$hia$YW14HosudAVlISaZCLHjeEWLEnU.INSTANCE).doOnNext(new Consumer() {
            /* class _m_j.$$Lambda$hia$Eo35cliMTvE5cOPfGk9mKZa6vak */

            public final void accept(Object obj) {
                hia.O000000o(hia.this, (DeviceRoomRenderState) obj);
            }
        });
        CommonApplication application3 = CommonApplication.getApplication();
        ixe.O00000Oo(application3, "getApplication()");
        Observable map = new hne("app_state_changed", application3).map($$Lambda$hia$GOu3UOetMHAXVDMXTEA0KAWc.INSTANCE).filter($$Lambda$hia$g58aw2LfdubPV3pWyd3L_6Q5ce8.INSTANCE).doOnNext($$Lambda$hia$MEbTzGu_txFDyZxSm7p4JR_WE_0.INSTANCE).map($$Lambda$hia$TEl_tFhoV5HlXD5OflnTHwFHLyI.INSTANCE);
        CommonApplication application4 = CommonApplication.getApplication();
        ixe.O00000Oo(application4, "getApplication()");
        Observable map2 = new hne("app_state_changed", application4).map($$Lambda$hia$Tmagat66GlhL95NC5AFsh904zRE.INSTANCE).filter($$Lambda$hia$o4TInSgIB1ewqrPxuKo0lTlsYbI.INSTANCE).doOnNext($$Lambda$hia$w7cRFd0W3C4TIGdukoZwyhsI4gc.INSTANCE).map($$Lambda$hia$MNFH8mlBXW2BbDDB3HNaUPOTLC0.INSTANCE);
        gzq.O000000o o000000o = gzq.f18638O000000o;
        Observable doOnNext2 = gzq.O00000Oo.map($$Lambda$hia$5q36lj7QS8DJkDwKqayqvWRM0_I.INSTANCE).doOnNext($$Lambda$hia$_4qyKyjuZJEQxy3ghnFUj_rSJJA.INSTANCE);
        if (ServiceApplication.getStateNotifier().f15923O000000o == 3) {
            observable = Observable.just(DeviceRoomRenderState.LogoutState.f10365O000000o);
            ixe.O00000Oo(observable, "{\n            Observable.just(DeviceRoomRenderState.LogoutState)\n        }");
        } else {
            hfz hfz = hfz.f18889O000000o;
            ArrayList<MainPageDeviceModel> O000000o3 = hfz.O000000o();
            if (O000000o3 == null) {
                list = EmptyList.f15376O000000o;
            } else {
                list = O000000o3;
            }
            Collection collection = list;
            if (collection == null || collection.isEmpty()) {
                observable = Observable.just(DeviceRoomRenderState.LoadingState.f10364O000000o);
                ixe.O00000Oo(observable, "{\n                Observable.just(DeviceRoomRenderState.LoadingState)\n            }");
            } else {
                observable = Observable.fromCallable(new Callable(list) {
                    /* class _m_j.$$Lambda$hia$Phb3Fah3MlJ5WKor6fR34fmLNk */
                    private final /* synthetic */ List f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final Object call() {
                        return hia.O000000o(this.f$0);
                    }
                });
                ixe.O00000Oo(observable, "{\n                Observable.fromCallable {\n                    val commonPage = PageBean.commonDefault\n                    val commonDeviceCache = listOf(RoomRenderData(commonPage) { commonDeviceViewCache.filter { it.freqFlag } })\n\n                    val otherDeviceCache: List<RoomRenderData> = MainPageCacheStore.indicatorPages?.filter { it.id != commonPage.id }?.map { RoomRenderData(it) { emptyList() } }\n                            ?: emptyList()\n\n                    val commonUsedScenes = MainPageCacheStore.commonScenes ?: ArrayList()\n                    val freqCameras = MainPageCacheStore.freqCameras ?: ArrayList()\n\n                    MiJiaLog.writeLogOnGrey(LogType.DEVICE_LIST,TAG, \"intent-viewCache used: \")\n                    DeviceRoomRenderState.DeviceRoomState(HomeManager.getInstance().currentHome, commonDeviceCache + otherDeviceCache, commonUsedScenes, freqCameras)\n                }\n            }");
            }
        }
        O000000o(Observable.merge(iuo.O000000o((Object[]) new Observable[]{observable, map2, map, doOnNext2, doOnNext})).doOnNext($$Lambda$hia$g0gbzTQihqH8eka16X3dIPh5SX8.INSTANCE).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()), $$Lambda$hia$KS6mg01rkt0daGe2_uZEd8ftws.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final Boolean O000000o(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000Oo(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public static final Observer O000000o(Observer observer) {
        ixe.O00000o(observer, "observer");
        return new ThrottleFirstAndLastObserver(observer, 1000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public static final boolean O000000o(Boolean bool) {
        ixe.O00000o(bool, "it");
        return ServiceApplication.getStateNotifier().f15923O000000o == 4;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Boolean]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    public static final DeviceRoomRenderState O00000Oo(Boolean bool) {
        ixe.O00000o(bool, "it");
        try {
            PageBean.O000000o o000000o = PageBean.CREATOR;
            Context appContext = CommonApplication.getAppContext();
            ixe.O00000Oo(appContext, "getAppContext()");
            List<PageBean> O000000o2 = PageBean.O000000o.O000000o(appContext);
            gsy.O00000Oo(LogType.DEVICE_LIST, "DevicePageRoomPresenter", ixe.O000000o("intent-dataSetChanged: ", (Object) Boolean.valueOf(CoreApi.O000000o().O0000Ooo())));
            hfz hfz = hfz.f18889O000000o;
            hfz.O00000Oo(new ArrayList(O000000o2));
            hfz hfz2 = hfz.f18889O000000o;
            gfz gfz = gfz.f17670O000000o;
            PageBean.O000000o o000000o2 = PageBean.CREATOR;
            Collection arrayList = new ArrayList();
            for (Device O000000o3 : gfz.O000000o(PageBean.O000000o.O000000o())) {
                MainPageDeviceModel O000000o4 = MainPageDeviceModel.CREATOR.O000000o(O000000o3);
                if (O000000o4 != null) {
                    arrayList.add(O000000o4);
                }
            }
            hfz.O000000o(new ArrayList((List) arrayList));
            hfx hfx = hfx.f18878O000000o;
            List<CommonUsedScene> O000000o5 = hfx.O000000o(ggb.O00000Oo().O0000Oo0());
            hfz hfz3 = hfz.f18889O000000o;
            hfz.O00000o0(new ArrayList(O000000o5));
            List<MainCameraCardModel> O000000o6 = hfy.f18887O000000o.O000000o(ggb.O00000Oo().O0000Oo0());
            hfz hfz4 = hfz.f18889O000000o;
            hfz.O00000o(new ArrayList(O000000o6));
            Iterable<PageBean> iterable = O000000o2;
            Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
            for (PageBean pageBean : iterable) {
                arrayList2.add(new hid(pageBean, new DevicePageRoomPresenter$bindIntents$dataSetChanged$6$lazyRenderDevicesData$1$1(pageBean)));
            }
            return new DeviceRoomRenderState.DeviceRoomState(ggb.O00000Oo().O0000Oo0(), (List) arrayList2, O000000o5, O000000o6);
        } catch (Exception e) {
            gsy.O00000Oo(LogType.DEVICE_LIST, "DevicePageRoomPresenter", Log.getStackTraceString(e));
            return DeviceRoomRenderState.ErrorState.f10363O000000o;
        }
    }

    /* access modifiers changed from: private */
    public static final Integer O00000o0(Intent intent) {
        ixe.O00000o(intent, "it");
        return Integer.valueOf(intent.getIntExtra("current_state", 2));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    public static final void O00000Oo(int i) {
        gsy.O00000Oo(LogType.DEVICE_LIST, "DevicePageRoomPresenter", ixe.O000000o("intent-logoutStateChange ", (Object) Integer.valueOf(i)));
    }

    /* access modifiers changed from: private */
    public static final DeviceRoomRenderState.LogoutState O000000o(Integer num) {
        ixe.O00000o(num, "it");
        return DeviceRoomRenderState.LogoutState.f10365O000000o;
    }

    /* access modifiers changed from: private */
    public static final Integer O00000o(Intent intent) {
        ixe.O00000o(intent, "it");
        return Integer.valueOf(intent.getIntExtra("current_state", 3));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    public static final void O00000o(int i) {
        gsy.O00000Oo(LogType.DEVICE_LIST, "DevicePageRoomPresenter", ixe.O000000o("intent-loginStateChange ", (Object) Integer.valueOf(i)));
    }

    /* access modifiers changed from: private */
    public static final DeviceRoomRenderState.LoadingState O00000Oo(Integer num) {
        ixe.O00000o(num, "it");
        return DeviceRoomRenderState.LoadingState.f10364O000000o;
    }

    /* access modifiers changed from: private */
    public static final DeviceRoomRenderState.LoadingState O00000oO(Intent intent) {
        ixe.O00000o(intent, "it");
        return DeviceRoomRenderState.LoadingState.f10364O000000o;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(DeviceRoomRenderState.LoadingState loadingState) {
        gsy.O00000Oo(LogType.DEVICE_LIST, "DevicePageRoomPresenter", "intent-homeChange: ");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O00000Oo(java.util.Collection, java.lang.Iterable):java.util.List<T>
     arg types: [java.util.List, java.util.List]
     candidates:
      _m_j.iuy.O00000Oo(java.lang.Iterable, java.lang.Object):int
      _m_j.iuy.O00000Oo(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O00000Oo(java.util.Collection, java.lang.Iterable):java.util.List<T> */
    /* access modifiers changed from: private */
    public static final DeviceRoomRenderState.DeviceRoomState O000000o(List list) {
        List list2;
        ixe.O00000o(list, "$commonDeviceViewCache");
        PageBean.O000000o o000000o = PageBean.CREATOR;
        PageBean O000000o2 = PageBean.O000000o.O000000o();
        List O000000o3 = iuo.O000000o(new hid(O000000o2, new DevicePageRoomPresenter$bindIntents$initialState$1$commonDeviceCache$1(list)));
        hfz hfz = hfz.f18889O000000o;
        ArrayList<PageBean> O00000Oo2 = hfz.O00000Oo();
        if (O00000Oo2 == null) {
            list2 = null;
        } else {
            Collection arrayList = new ArrayList();
            for (Object next : O00000Oo2) {
                if (!ixe.O000000o((Object) ((PageBean) next).O00000Oo, (Object) O000000o2.O00000Oo)) {
                    arrayList.add(next);
                }
            }
            Iterable<PageBean> iterable = (List) arrayList;
            Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
            for (PageBean hid : iterable) {
                arrayList2.add(new hid(hid, DevicePageRoomPresenter$bindIntents$initialState$1$otherDeviceCache$2$1.f10361O000000o));
            }
            list2 = (List) arrayList2;
        }
        if (list2 == null) {
            list2 = EmptyList.f15376O000000o;
        }
        hfz hfz2 = hfz.f18889O000000o;
        ArrayList<CommonUsedScene> O00000o0 = hfz.O00000o0();
        if (O00000o0 == null) {
            O00000o0 = new ArrayList<>();
        }
        hfz hfz3 = hfz.f18889O000000o;
        ArrayList<MainCameraCardModel> O00000oo = hfz.O00000oo();
        if (O00000oo == null) {
            O00000oo = new ArrayList<>();
        }
        gsy.O00000Oo(LogType.DEVICE_LIST, "DevicePageRoomPresenter", "intent-viewCache used: ");
        return new DeviceRoomRenderState.DeviceRoomState(ggb.O00000Oo().O0000Oo0(), iuo.O00000Oo((Collection) O000000o3, (Iterable) list2), O00000o0, O00000oo);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    public static final void O000000o(DeviceRoomRenderState deviceRoomRenderState) {
        gsy.O00000Oo(LogType.DEVICE_LIST, "DevicePageRoomPresenter", ixe.O000000o("intent-event: ", (Object) deviceRoomRenderState.getClass().getSimpleName()));
    }

    /* access modifiers changed from: private */
    public static final void O000000o(hib hib, DeviceRoomRenderState deviceRoomRenderState) {
        ixe.O00000o(hib, "view");
        ixe.O00000o(deviceRoomRenderState, "viewState");
        hib.O000000o(deviceRoomRenderState);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(hia hia, DeviceRoomRenderState deviceRoomRenderState) {
        ixe.O00000o(hia, "this$0");
        fqw.O00000oO();
    }
}

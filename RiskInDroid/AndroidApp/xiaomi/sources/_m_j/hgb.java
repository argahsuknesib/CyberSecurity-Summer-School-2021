package _m_j;

import _m_j.hgc;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class hgb extends ayp<hgg, hgd> {
    public final void O00000o0() {
        if (gfr.O0000OOo) {
            gsy.O000000o("MVI-DevicePagePresenter", "bindIntents:");
        }
        Observable<R> doOnNext = Observable.merge(new hne("app_state_changed", CommonApplication.getApplication(), (byte) 0).map($$Lambda$hgb$KsYCkhjigSuaF8XFQyxOf8yDdHA.INSTANCE).filter($$Lambda$hgb$k1Fku9alEbrokIR1QK4I99SDPEI.INSTANCE).doOnNext($$Lambda$hgb$avRVCjGnHb1HykbFaE1bp5EXBMI.INSTANCE).map($$Lambda$hgb$850ZLjUaAXpBCZPlThbtxiQj8.INSTANCE).subscribeOn(AndroidSchedulers.mainThread()), O000000o($$Lambda$hgb$tNlDjJXN846yb1Acug_nCdN48E.INSTANCE).flatMap(new Function() {
            /* class _m_j.$$Lambda$hgb$DTyq28BhCYRTktBxrW2HEGlwMJk */

            public final Object apply(Object obj) {
                return hgb.this.O000000o((Boolean) obj);
            }
        }).map($$Lambda$hgb$kjpLWB5i7F4haE7ToKGAxKrzd4.INSTANCE).subscribeOn(AndroidSchedulers.mainThread()).doOnNext($$Lambda$hgb$FrgvWOo37K7gs_Azo_6fDZOWip0.INSTANCE), gzv.O000000o().f18673O000000o.flatMap(new Function() {
            /* class _m_j.$$Lambda$hgb$NGyhYbxSeTTQH7H2cDY47BEZZoc */

            public final Object apply(Object obj) {
                return hgb.this.O00000Oo((PageBean) obj);
            }
        }).map($$Lambda$hgb$xhXDfF6SijqiialFXjyVc2nZnwo.INSTANCE).subscribeOn(AndroidSchedulers.mainThread()).doOnNext($$Lambda$hgb$TQppG2DoaW1IbmhHjs3J7Wanls4.INSTANCE)).observeOn(Schedulers.trampoline()).doOnNext($$Lambda$hgb$C0z7MmAa6xGFUH37eK7uz0YWLkg.INSTANCE);
        List<MainPageDeviceModel> O000000o2 = O000000o(gfz.f17670O000000o.O000000o(PageBean.O00000Oo()));
        Collections.sort(O000000o2, new Comparator<MainPageDeviceModel>() {
            /* class _m_j.hgb.AnonymousClass1 */

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                MainPageDeviceModel mainPageDeviceModel = (MainPageDeviceModel) obj;
                MainPageDeviceModel mainPageDeviceModel2 = (MainPageDeviceModel) obj2;
                if (mainPageDeviceModel.O0000Ooo == null || mainPageDeviceModel2.O0000Ooo == null) {
                    return 0;
                }
                return mainPageDeviceModel.O0000Ooo.compareTo(mainPageDeviceModel2.O0000Ooo);
            }
        });
        O000000o(doOnNext.scan(O000000o((hgd) null, new hgc.O000000o(O000000o2)), new BiFunction() {
            /* class _m_j.$$Lambda$hgb$jo3JMJOAiitmgzsUqUVAdl9GTfY */

            public final Object apply(Object obj, Object obj2) {
                return hgb.this.O000000o((hgd) obj, (hgc) obj2);
            }
        }).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()), $$Lambda$8Z9X5UfbXeaPQpCxxdgIZgLHGhE.INSTANCE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O000000o(Boolean bool) throws Exception {
        return O000000o(gzv.O000000o().O00000Oo());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ hgc O00000o0(List list) throws Exception {
        return new hgc.O000000o(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O00000Oo(PageBean pageBean) throws Exception {
        return O000000o(gzv.O000000o().O00000Oo());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ hgc O00000Oo(List list) throws Exception {
        return new hgc.O000000o(list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O00000o0(Integer num) throws Exception {
        return num.intValue() == 3;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ hgc O000000o(Integer num) throws Exception {
        return new hgc.O000000o(null);
    }

    /* access modifiers changed from: private */
    public hgd O000000o(hgd hgd, hgc hgc) {
        return (hgd) hgc.O000000o(hgd);
    }

    private static Observable<List<MainPageDeviceModel>> O000000o(PageBean pageBean) {
        return Observable.create(new ObservableOnSubscribe() {
            /* class _m_j.$$Lambda$hgb$Mwyp_W3dWUVEw3JujEE9CXNpmxc */

            public final void subscribe(ObservableEmitter observableEmitter) {
                hgb.O000000o(PageBean.this, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).onErrorReturn($$Lambda$hgb$SyPxobPhc4kEDYhA0YBBVWwn2E.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(PageBean pageBean, ObservableEmitter observableEmitter) throws Exception {
        if (!observableEmitter.isDisposed()) {
            observableEmitter.onNext(O000000o(gfz.f17670O000000o.O000000o(pageBean)));
            observableEmitter.onComplete();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List O000000o(Throwable th) throws Exception {
        return new ArrayList();
    }

    private static List<MainPageDeviceModel> O000000o(List<Device> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                MainPageDeviceModel O000000o2 = MainPageDeviceModel.O000000o(list.get(i));
                if (O000000o2 != null) {
                    arrayList.add(O000000o2);
                }
            }
        }
        return arrayList;
    }
}

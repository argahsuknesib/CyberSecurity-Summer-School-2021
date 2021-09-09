package _m_j;

import _m_j.ggr;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$1;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$cateOrderJson$1;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$freqCameraOrderJson$1;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$roomOrderJson$1;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$mHomesListOrder$2;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$mHomesOrdersMap$2;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$mParser$1$1;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$parseHomeOrder$1;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$parseHomeOrder$2;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$parseHomeOrder$3;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$parseHomeOrder$4;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$saveHomeListOrderToCache$1;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$syncOrderToServer$orders$1;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$syncOrderToServer$orders$2;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$syncOrderToServer$orders$3;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$syncOrderToServer$orders$4;
import com.xiaomi.smarthome.homeroom.device_order.DeviceOrderSourceUnion$syncSingleOwnerOrderFromServer$param$1$1;
import com.xiaomi.smarthome.homeroom.model.Room;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0012\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120(J/\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120(0*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0(2\u0006\u0010-\u001a\u00020.H\u0000¢\u0006\u0002\b/J\u0018\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020.H\u0002J\u0016\u00104\u001a\u00020!2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040(H\u0002J\u0010\u00106\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0004H\u0002JT\u00107\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\nj\b\u0012\u0004\u0012\u00020\u0012`\u000b0*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0(2\b\b\u0002\u00108\u001a\u00020.2\b\b\u0002\u00109\u001a\u00020.2\b\b\u0002\u0010:\u001a\u00020.2\b\b\u0002\u0010;\u001a\u00020.H\u0002J(\u0010<\u001a\b\u0012\u0004\u0012\u00020.0=2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020\u0004H\u0007JV\u0010A\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\nj\b\u0012\u0004\u0012\u00020\u0012`\u000b0*2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u00108\u001a\u00020.2\b\b\u0002\u00109\u001a\u00020.2\b\b\u0002\u0010:\u001a\u00020.2\b\b\u0002\u0010;\u001a\u00020.2\b\b\u0002\u0010@\u001a\u00020\u0004J2\u0010B\u001a\b\u0012\u0004\u0012\u00020.0=2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040(J\"\u0010F\u001a\b\u0012\u0004\u0012\u00020.0=2\u0006\u0010$\u001a\u00020\u00042\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040(J,\u0010G\u001a\b\u0012\u0004\u0012\u00020.0=2\u0006\u0010$\u001a\u00020\u00042\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040(2\b\b\u0002\u0010@\u001a\u00020\u0004J\"\u0010H\u001a\b\u0012\u0004\u0012\u00020.0=2\u0006\u0010$\u001a\u00020\u00042\f\u0010E\u001a\b\u0012\u0004\u0012\u00020I0(R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR7\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012`\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R>\u0010\u001d\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020\u0012 \u001f*\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u000b0\nj\b\u0012\u0004\u0012\u00020\u0012`\u000b0\u001eX\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/device_order/DeviceOrderSourceUnion;", "", "()V", "GET_ORDER_PATH", "", "HOME_ORDER_KEY_PREFIX", "PREFS_HOME_ORDER", "SET_ORDER_PATH", "TAG", "mHomesListOrder", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMHomesListOrder", "()Ljava/util/ArrayList;", "mHomesListOrder$delegate", "Lkotlin/Lazy;", "mHomesOrdersMap", "Ljava/util/HashMap;", "Lcom/xiaomi/smarthome/homeroom/device_order/HomeOrder;", "Lkotlin/collections/HashMap;", "getMHomesOrdersMap", "()Ljava/util/HashMap;", "mHomesOrdersMap$delegate", "mOrderExecutor", "Ljava/util/concurrent/ExecutorService;", "mOrderSchedule", "Lio/reactivex/Scheduler;", "mOrderThreadId", "", "mParser", "Lcom/xiaomi/smarthome/frame/JsonParser;", "kotlin.jvm.PlatformType", "assertThread", "", "name", "dumpHomeOrderJson", "homeId", "getCachedHomeListOrder", "getCachedHomeOrder", "getCachedHomeOrders", "", "getHomeOrders", "Lio/reactivex/Observable;", "homeParams", "Lcom/xiaomi/smarthome/homeroom/device_order/OrderCompat$HomeParam;", "needCache", "", "getHomeOrders$smarthome_home_release", "parseHomeOrder", "json", "Lorg/json/JSONObject;", "isCached", "saveHomeListOrderToCache", "homeIds", "saveHomeOrderCache", "syncOrderFromServer", "needRoomOrder", "needFrontOrder", "needCateOrder", "needFreqCameraOrder", "syncOrderToServer", "Lio/reactivex/Single;", "orderData", "Lcom/xiaomi/smarthome/homeroom/device_order/Order;", "source", "syncSingleOwnerOrderFromServer", "updateCategoryOrder", "cateId", "parent_id", "orderList", "updateFreqCameraOrder", "updateFrontOrder", "updateRoomOrder", "Lcom/xiaomi/smarthome/homeroom/model/Room;", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ggl {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ggl f17743O000000o = new ggl();
    private static long O00000Oo = -10;
    private static final Scheduler O00000o;
    private static final ExecutorService O00000o0;
    private static final itz O00000oO = iua.O000000o(f17743O000000o, DeviceOrderSourceUnion$mHomesListOrder$2.f8966O000000o);
    private static final itz O00000oo = iua.O000000o(f17743O000000o, DeviceOrderSourceUnion$mHomesOrdersMap$2.f8968O000000o);
    private static final fss<ArrayList<ggo>> O0000O0o = $$Lambda$ggl$boO3vFHTyv2Vh8IgL3J2DWXYVg.INSTANCE;

    /* access modifiers changed from: private */
    public static final List O00000o(List list) {
        ixe.O00000o(list, "it");
        return list;
    }

    private ggl() {
    }

    /* access modifiers changed from: private */
    public static final Thread O000000o(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("DeviceOrderSourceUnion");
        O00000Oo = thread.getId();
        return thread;
    }

    public static ArrayList<String> O000000o() {
        return (ArrayList) O00000oO.O000000o();
    }

    static {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor($$Lambda$ggl$mfv2nR1VJ78Sf86WYs4HynMOJww.INSTANCE);
        ixe.O00000Oo(newSingleThreadExecutor, "newSingleThreadExecutor { Thread(it).apply { name = TAG;mOrderThreadId = id } }");
        O00000o0 = newSingleThreadExecutor;
        Scheduler from = Schedulers.from(newSingleThreadExecutor);
        ixe.O00000Oo(from, "from(mOrderExecutor)");
        O00000o = from;
    }

    static HashMap<String, ggo> O00000Oo() {
        return (HashMap) O00000oo.O000000o();
    }

    public static Observable<List<ggo>> O000000o(List<ggr.O000000o> list, boolean z) {
        ixe.O00000o(list, "homeParams");
        Observable<List<ggo>> subscribeOn = Observable.just(1).observeOn(O00000o).flatMap(new Function(list, z) {
            /* class _m_j.$$Lambda$ggl$39vi5PEl3_ASROCyZD0sogthFj0 */
            private final /* synthetic */ List f$0;
            private final /* synthetic */ boolean f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object apply(Object obj) {
                return ggl.O000000o(this.f$0, this.f$1, (Integer) obj);
            }
        }).map($$Lambda$ggl$t3H2cPlZtSinwJvLWB3UCCc7uo.INSTANCE).map($$Lambda$ggl$RZj04NB8InWZ912S2bCwaQZ8_68.INSTANCE).subscribeOn(Schedulers.io());
        ixe.O00000Oo(subscribeOn, "just(1)\n                .observeOn(mOrderSchedule)\n                .flatMap {\n                    assertThread(\"getLatestHomeOrder flatMap\")\n\n                    val cache: Observable<List<HomeOrder>> =\n                            Observable.defer {\n                                if (needCache && mHomesListOrder.isNotEmpty()) {\n                                    val allCachedHomeOrders = arrayListOf<HomeOrder>()\n                                    homeParams.forEach {\n                                        allCachedHomeOrders.addAll(\n                                                it.homeIds.map { id ->\n                                                    mHomesOrdersMap[id]\n                                                            ?: HomeOrder(homeId = id, isCached = true)\n                                                }\n                                        )\n                                    }\n                                    Observable.just(allCachedHomeOrders)\n                                } else Observable.empty()\n                            }\n\n\n                    val syncFromServer = syncOrderFromServer(homeParams)\n                            .observeOn(mOrderSchedule)\n                            .doOnNext { orderList ->\n                                //保存服务器拉下来的数据\n                                orderList.filter { !TextUtils.isEmpty(it.homeId) }.forEach { homeOrder ->\n                                    if (!homeOrder.isCached) {\n                                        assertThread(\"getLatestHomeOrder flatMap save\")\n\n                                        val frontOrders = homeOrder.frontOrder.orders\n                                        val isEmptyFrontOrder = frontOrders.size == 1 && frontOrders.filterNot { did -> TextUtils.equals(did, \"-\") }.isEmpty()\n                                        if (isEmptyFrontOrder) {\n                                            //如果排序是服务器返回的，并且常用排序只有\"-\" ,说明没拉下来默认的常用排序，这时候如果有常用排序缓存的话，替换为缓存的排序\n                                            val cachedHomeOrder = mHomesOrdersMap[homeOrder.homeId]\n                                            if (cachedHomeOrder != null && !(cachedHomeOrder.frontOrder.orders.size == 1 && cachedHomeOrder.frontOrder.orders[0] == \"-\")) {\n                                                homeOrder.isCached = true\n                                                frontOrders.clear()\n                                                frontOrders.addAll(cachedHomeOrder.frontOrder.orders)\n                                            }\n                                        }\n\n                                        mHomesOrdersMap[homeOrder.homeId] = homeOrder\n                                        saveHomeOrderCache(homeOrder.homeId)\n\n                                        mHomesListOrder.clear()\n                                        mHomesListOrder.addAll(orderList.map { it.homeId })\n                                        saveHomeListOrderToCache(mHomesListOrder)\n\n                                    }\n                                }\n\n                            }.onErrorResumeNext(cache.map { order -> ArrayList(order) })\n\n\n                    if (needCache) {\n                        return@flatMap Observable.concat(cache, syncFromServer)\n                    }\n                    return@flatMap syncFromServer\n\n                }\n                .map { it.map { order -> order.copy() } }//make a copy\n                .map {\n                    it\n                }\n                .subscribeOn(Schedulers.io())");
        return subscribeOn;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    /* access modifiers changed from: private */
    public static final ObservableSource O000000o(List list, boolean z, Integer num) {
        Observable observable;
        ixe.O00000o(list, "$homeParams");
        ixe.O00000o(num, "it");
        O00000Oo("getLatestHomeOrder flatMap");
        Observable defer = Observable.defer(new Callable(z, list) {
            /* class _m_j.$$Lambda$ggl$hw9kLJZ7SctpGGRjwGv2D3vqUs */
            private final /* synthetic */ boolean f$0;
            private final /* synthetic */ List f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object call() {
                return ggl.O000000o(this.f$0, this.f$1);
            }
        });
        ixe.O00000Oo(defer, "defer {\n                                if (needCache && mHomesListOrder.isNotEmpty()) {\n                                    val allCachedHomeOrders = arrayListOf<HomeOrder>()\n                                    homeParams.forEach {\n                                        allCachedHomeOrders.addAll(\n                                                it.homeIds.map { id ->\n                                                    mHomesOrdersMap[id]\n                                                            ?: HomeOrder(homeId = id, isCached = true)\n                                                }\n                                        )\n                                    }\n                                    Observable.just(allCachedHomeOrders)\n                                } else Observable.empty()\n                            }");
        if (list.isEmpty()) {
            observable = Observable.empty();
            ixe.O00000Oo(observable, "empty()");
        } else {
            Iterable<ggr.O000000o> iterable = list;
            Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
            for (ggr.O000000o o000000o : iterable) {
                ixe.O00000o(o000000o, "homeParams");
                ixe.O00000o("", "source");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("owner_uid", o000000o.f17749O000000o);
                jSONObject.put("home_id", ggv.O000000o(o000000o.O00000Oo, DeviceOrderSourceUnion$syncSingleOwnerOrderFromServer$param$1$1.f8983O000000o));
                jSONObject.put("platform", "android");
                jSONObject.put("source", "");
                jSONObject.put("get_room_order", true);
                jSONObject.put("get_front_order", true);
                jSONObject.put("get_cate_order", true);
                jSONObject.put("get_freq_camera_order", true);
                jSONObject.put("get_default_camera_switch", true);
                Observable onErrorReturn = fsv.O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/home/get_union_order").O000000o(iuo.O000000o(new KeyValuePair("data", jSONObject.toString()))).O000000o(), $$Lambda$ggl$DDLqVEM4lNv8QY5kb6YEYcBPw5k.INSTANCE).onErrorReturn(new Function() {
                    /* class _m_j.$$Lambda$ggl$_dOkvlE4fbWMFc9bVs0lB7HLv9U */

                    public final Object apply(Object obj) {
                        return ggl.O000000o(ggr.O000000o.this, (Throwable) obj);
                    }
                });
                ixe.O00000Oo(onErrorReturn, "fetch(request) {\n            val homeOrders = mParser.parse(it)\n            homeOrders\n        }.onErrorReturn {\n            it.printStackTrace()\n            homeParams.homeIds.mapTo(arrayListOf<HomeOrder>()) { id ->\n                mHomesOrdersMap[id] ?: HomeOrder(homeId = id, isCached = true)\n            }\n        }");
                arrayList.add(onErrorReturn);
            }
            observable = Observable.zip((List) arrayList, new O000000o());
            ixe.O00000Oo(observable, "zip(homeOrderRequests, object : Function<Array<Any>, ArrayList<HomeOrder>> {\n            override fun apply(t: Array<Any>): ArrayList<HomeOrder> {\n                val totalHomeOrders = arrayListOf<HomeOrder>()\n                for (list in t) {\n                    totalHomeOrders.addAll(list as Collection<HomeOrder>)\n                }\n                return totalHomeOrders\n            }\n\n        })");
        }
        Observable onErrorResumeNext = observable.observeOn(O00000o).doOnNext($$Lambda$ggl$HXJ0xBEhSQEDRwfgkhnKbIGYydw.INSTANCE).onErrorResumeNext(defer.map($$Lambda$ggl$bu6BR6EpLLJJrsO2DAClaLcu4pM.INSTANCE));
        if (z) {
            return Observable.concat(defer, onErrorResumeNext);
        }
        return onErrorResumeNext;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void
     arg types: [java.lang.String, int, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int]
     candidates:
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList<_m_j.ggs>, java.util.HashSet<_m_j.ggj>, _m_j.ggm, _m_j.ggt):void
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void */
    /* access modifiers changed from: private */
    public static final ObservableSource O000000o(boolean z, List list) {
        Observable observable;
        ixe.O00000o(list, "$homeParams");
        if (!z || !(!O000000o().isEmpty())) {
            observable = Observable.empty();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Iterable<String> iterable = ((ggr.O000000o) it.next()).O00000Oo;
                Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
                for (String str : iterable) {
                    ggo ggo = O00000Oo().get(str);
                    if (ggo == null) {
                        ggo = new ggo(str, true, (ggn) null, (ArrayList) null, (HashSet) null, (ggm) null, 124);
                    }
                    arrayList2.add(ggo);
                }
                arrayList.addAll((List) arrayList2);
            }
            observable = Observable.just(arrayList);
        }
        return observable;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f8 A[LOOP:3: B:32:0x00f2->B:34:0x00f8, LOOP_END] */
    public static final void O000000o(ArrayList arrayList) {
        boolean z;
        ggo ggo;
        ixe.O00000Oo(arrayList, "orderList");
        Iterable<ggo> iterable = arrayList;
        Collection arrayList2 = new ArrayList();
        for (Object next : iterable) {
            if (true ^ TextUtils.isEmpty(((ggo) next).f17746O000000o)) {
                arrayList2.add(next);
            }
        }
        for (ggo ggo2 : (List) arrayList2) {
            if (!ggo2.O00000Oo) {
                O00000Oo("getLatestHomeOrder flatMap save");
                ArrayList<String> arrayList3 = ggo2.O00000o0.f17745O000000o;
                if (arrayList3.size() == 1) {
                    Collection arrayList4 = new ArrayList();
                    for (Object next2 : arrayList3) {
                        if (!TextUtils.equals((String) next2, "-")) {
                            arrayList4.add(next2);
                        }
                    }
                    if (((List) arrayList4).isEmpty()) {
                        z = true;
                        if (z && (ggo = O00000Oo().get(ggo2.f17746O000000o)) != null && (ggo.O00000o0.f17745O000000o.size() != 1 || !ixe.O000000o((Object) ggo.O00000o0.f17745O000000o.get(0), (Object) "-"))) {
                            ggo2.O00000Oo = true;
                            arrayList3.clear();
                            arrayList3.addAll(ggo.O00000o0.f17745O000000o);
                        }
                        O00000Oo().put(ggo2.f17746O000000o, ggo2);
                        f17743O000000o.O00000o0(ggo2.f17746O000000o);
                        O000000o().clear();
                        ArrayList<String> O000000o2 = O000000o();
                        Collection arrayList5 = new ArrayList(iuo.O000000o(iterable, 10));
                        for (ggo ggo3 : iterable) {
                            arrayList5.add(ggo3.f17746O000000o);
                        }
                        O000000o2.addAll((List) arrayList5);
                        O000000o((List<String>) O000000o());
                    }
                }
                z = false;
                ggo2.O00000Oo = true;
                arrayList3.clear();
                arrayList3.addAll(ggo.O00000o0.f17745O000000o);
                O00000Oo().put(ggo2.f17746O000000o, ggo2);
                f17743O000000o.O00000o0(ggo2.f17746O000000o);
                O000000o().clear();
                ArrayList<String> O000000o22 = O000000o();
                Collection arrayList52 = new ArrayList(iuo.O000000o(iterable, 10));
                while (r4.hasNext()) {
                }
                O000000o22.addAll((List) arrayList52);
                O000000o((List<String>) O000000o());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final ArrayList O00000Oo(List list) {
        ixe.O00000o(list, "order");
        return new ArrayList(list);
    }

    /* access modifiers changed from: private */
    public static final List O00000o0(List list) {
        ixe.O00000o(list, "it");
        Iterable<ggo> iterable = list;
        Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
        for (ggo O000000o2 : iterable) {
            arrayList.add(ggo.O000000o(O000000o2.f17746O000000o, O000000o2.O00000Oo, O000000o2.O00000o0, O000000o2.O00000o, O000000o2.O00000oO, O000000o2.O00000oo, O000000o2.O0000O0o));
        }
        return (List) arrayList;
    }

    private static void O00000Oo(String str) {
        boolean z = Thread.currentThread().getId() == O00000Oo;
        if (gfr.f17662O000000o && !z) {
            gsy.O000000o(6, "DeviceOrderSourceUnion", "assertThread >> " + str + ":  was invoked unsafely!");
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u0001J+\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"com/xiaomi/smarthome/homeroom/device_order/DeviceOrderSourceUnion$syncOrderFromServer$1", "Lio/reactivex/functions/Function;", "", "", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/homeroom/device_order/HomeOrder;", "Lkotlin/collections/ArrayList;", "apply", "t", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o implements Function<Object[], ArrayList<ggo>> {
        O000000o() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            Object[] objArr = (Object[]) obj;
            ixe.O00000o(objArr, "t");
            ArrayList arrayList = new ArrayList();
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj2 = objArr[i];
                i++;
                arrayList.addAll((Collection) obj2);
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: private */
    public static final ArrayList O000000o(JSONObject jSONObject) {
        return O0000O0o.parse(jSONObject);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void
     arg types: [java.lang.String, int, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int]
     candidates:
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList<_m_j.ggs>, java.util.HashSet<_m_j.ggj>, _m_j.ggm, _m_j.ggt):void
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void */
    /* access modifiers changed from: private */
    public static final ArrayList O000000o(ggr.O000000o o000000o, Throwable th) {
        ixe.O00000o(o000000o, "$homeParams");
        ixe.O00000o(th, "it");
        th.printStackTrace();
        Collection arrayList = new ArrayList();
        for (String str : o000000o.O00000Oo) {
            ggo ggo = O00000Oo().get(str);
            if (ggo == null) {
                ggo = new ggo(str, true, (ggn) null, (ArrayList) null, (HashSet) null, (ggm) null, 124);
            }
            arrayList.add(ggo);
        }
        return (ArrayList) arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public static Single<Boolean> O000000o(String str, ggq ggq, String str2) {
        JSONArray jSONArray;
        String str3;
        ixe.O00000o(str, "homeId");
        ixe.O00000o(ggq, "orderData");
        ixe.O00000o(str2, "source");
        O00000Oo("syncOrderToServer");
        boolean z = ggq instanceof ggn;
        if (z) {
            ggo ggo = O00000Oo().get(str);
            if (ggo == null) {
                Single<Boolean> just = Single.just(Boolean.FALSE);
                ixe.O00000Oo(just, "just(false)");
                return just;
            }
            jSONArray = ggv.O000000o(ggo.O00000o0.f17745O000000o, DeviceOrderSourceUnion$syncOrderToServer$orders$1.f8977O000000o);
        } else if (ggq instanceof ggo) {
            ggo ggo2 = O00000Oo().get(str);
            if (ggo2 == null) {
                Single<Boolean> just2 = Single.just(Boolean.FALSE);
                ixe.O00000Oo(just2, "just(false)");
                return just2;
            }
            jSONArray = ggv.O000000o(ggo2.O00000o, DeviceOrderSourceUnion$syncOrderToServer$orders$2.f8978O000000o);
        } else if (ggq instanceof ggj) {
            ggo ggo3 = O00000Oo().get(str);
            if (ggo3 == null) {
                Single<Boolean> just3 = Single.just(Boolean.FALSE);
                ixe.O00000Oo(just3, "just(false)");
                return just3;
            }
            jSONArray = ggv.O000000o(iuo.O00000o0(ggo3.O00000oO), DeviceOrderSourceUnion$syncOrderToServer$orders$3.f8980O000000o);
        } else if (ggq instanceof ggm) {
            ggo ggo4 = O00000Oo().get(str);
            if (ggo4 == null) {
                Single<Boolean> just4 = Single.just(Boolean.FALSE);
                ixe.O00000Oo(just4, "just(false)");
                return just4;
            }
            jSONArray = ggv.O000000o(ggo4.O00000oo.f17744O000000o, DeviceOrderSourceUnion$syncOrderToServer$orders$4.f8982O000000o);
        } else {
            Single<Boolean> just5 = Single.just(Boolean.FALSE);
            ixe.O00000Oo(just5, "just(false)");
            return just5;
        }
        if (z) {
            str3 = "front";
        } else if (ggq instanceof ggo) {
            str3 = "room";
        } else if (ggq instanceof ggj) {
            str3 = "category";
        } else if (ggq instanceof ggm) {
            str3 = "freqcamera";
        } else {
            Single<Boolean> just6 = Single.just(Boolean.FALSE);
            ixe.O00000Oo(just6, "just(false)");
            return just6;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("home_id", iyo.O000000o(str));
        jSONObject.put("platform", "android");
        jSONObject.put("type", str3);
        jSONObject.put("order_data", jSONArray);
        if (ixe.O000000o((Object) str3, (Object) "front")) {
            jSONObject.put("source", str2);
        }
        Single<Boolean> first = fsv.O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/home/set_union_order").O000000o(iuo.O000000o(new KeyValuePair("data", jSONObject.toString()))).O000000o(), $$Lambda$ggl$y_ZtE0dBtTZwK_iBU4AzkoWRrFM.INSTANCE).first(Boolean.FALSE);
        ixe.O00000Oo(first, "fetch(request) { it.optInt(\"code\", -1) == 0 }.first(false)");
        return first;
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000Oo(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optInt("code", -1) == 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public static String O000000o(String str) {
        String O00000o02 = gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_home_order_union", ixe.O000000o("home_order_key_prefix_union_", (Object) str), "{}");
        ixe.O00000Oo(O00000o02, "getSettingString(ServiceApplication.getAppContext(),\n                PREFS_HOME_ORDER, HOME_ORDER_KEY_PREFIX + homeId, \"{}\")");
        return O00000o02;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public static String O00000o0() {
        String O00000o02 = gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_home_order_union", ixe.O000000o("home_order_key_prefix_union_", (Object) gpp.O00000Oo(CoreApi.O000000o().O0000o0())), "[]");
        if (TextUtils.equals(O00000o02, "[]")) {
            O00000o02 = gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_home_order_union", ixe.O000000o("home_order_key_prefix_union_", (Object) CoreApi.O000000o().O0000o0()), "[]");
        }
        ixe.O00000Oo(O00000o02, "cache");
        return O00000o02;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    private static void O000000o(List<String> list) {
        if (!list.isEmpty()) {
            gpy.O000000o(ServiceApplication.getAppContext(), "prefs_home_order_union", ixe.O000000o("home_order_key_prefix_union_", (Object) gpp.O00000Oo(CoreApi.O000000o().O0000o0())), ggv.O000000o(list, DeviceOrderSourceUnion$saveHomeListOrderToCache$1.f8976O000000o).toString());
        }
    }

    /* access modifiers changed from: private */
    public static final ArrayList O00000o0(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("info");
            if (optJSONArray != null) {
                ggv.O000000o(optJSONArray, arrayList, DeviceOrderSourceUnion$mParser$1$1.f8969O000000o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public static ggo O000000o(JSONObject jSONObject, boolean z) {
        ggn ggn = new ggn();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ggm ggm = new ggm(null, ixe.O000000o((Object) jSONObject.optString("default_camera_switch", "off"), (Object) "on"), 1);
        JSONArray optJSONArray = jSONObject.optJSONArray("front_order");
        if (optJSONArray != null) {
            ggv.O000000o(optJSONArray, ggn.f17745O000000o, DeviceOrderSourceUnion$parseHomeOrder$1.f8970O000000o);
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("room_order");
        if (optJSONArray2 != null) {
            ggv.O000000o(optJSONArray2, arrayList, DeviceOrderSourceUnion$parseHomeOrder$2.f8971O000000o);
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("cate_order");
        if (optJSONArray3 != null) {
            ggv.O000000o(optJSONArray3, arrayList2, DeviceOrderSourceUnion$parseHomeOrder$3.f8973O000000o);
        }
        JSONArray optJSONArray4 = jSONObject.optJSONArray("freq_camera_order");
        if (optJSONArray4 != null) {
            ggv.O000000o(optJSONArray4, ggm.f17744O000000o, DeviceOrderSourceUnion$parseHomeOrder$4.f8975O000000o);
        }
        String optString = jSONObject.optString("home_id");
        ixe.O00000Oo(optString, "homeId");
        boolean optBoolean = jSONObject.optBoolean("choosed", false);
        String optString2 = jSONObject.optString("source", "");
        ixe.O00000Oo(optString2, "json.optString(\"source\", \"\")");
        String optString3 = jSONObject.optString("other", "");
        ixe.O00000Oo(optString3, "json.optString(\"other\", \"\")");
        ggt ggt = new ggt(optString, optBoolean, optString2, optString3);
        return new ggo(optString, z, ggn, arrayList, iuo.O00000Oo((Iterable) arrayList2), ggm, ggt);
    }

    public static /* synthetic */ Single O000000o(String str, List list) {
        ixe.O00000o(str, "homeId");
        ixe.O00000o(list, "orderList");
        ixe.O00000o("", "source");
        Single onErrorReturn = Single.just(1).observeOn(O00000o).flatMap(new Function(str, list, "") {
            /* class _m_j.$$Lambda$ggl$GRAVZOUVG0Mi3h44dqfjipnYY0 */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ List f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object apply(Object obj) {
                return ggl.O000000o(this.f$0, this.f$1, this.f$2, (Integer) obj);
            }
        }).onErrorReturn($$Lambda$ggl$HXBuou8NEn5Xypo9u9EXYfMlGA4.INSTANCE);
        ixe.O00000Oo(onErrorReturn, "just(1)\n                .observeOn(mOrderSchedule)\n                .flatMap {\n                    mHomesOrdersMap[homeId]?.frontOrder?.apply {\n                        this.orders.clear()\n                        this.orders.addAll(orderList.filterNotNull())\n                        saveHomeOrderCache(homeId)\n                        return@flatMap syncOrderToServer(homeId, this, source)\n                    }\n                    return@flatMap Single.just(false)\n                }.onErrorReturn { false }");
        return onErrorReturn;
    }

    /* access modifiers changed from: private */
    public static final SingleSource O000000o(String str, List list, String str2, Integer num) {
        ggn ggn;
        ixe.O00000o(str, "$homeId");
        ixe.O00000o(list, "$orderList");
        ixe.O00000o(str2, "$source");
        ixe.O00000o(num, "it");
        ggo ggo = O00000Oo().get(str);
        if (ggo == null || (ggn = ggo.O00000o0) == null) {
            return Single.just(Boolean.FALSE);
        }
        ggn.f17745O000000o.clear();
        ggn.f17745O000000o.addAll(iuo.O000000o((Iterable) list));
        f17743O000000o.O00000o0(str);
        return O000000o(str, ggn, str2);
    }

    /* access modifiers changed from: private */
    public static final Boolean O000000o(Throwable th) {
        ixe.O00000o(th, "it");
        return Boolean.FALSE;
    }

    public static Single<Boolean> O00000Oo(String str, List<? extends Room> list) {
        ixe.O00000o(str, "homeId");
        ixe.O00000o(list, "orderList");
        Single<Boolean> onErrorReturn = Single.just(1).observeOn(O00000o).flatMap(new Function(str, list) {
            /* class _m_j.$$Lambda$ggl$ZX802WQ1zxHVgiKikvp7BLIzMZg */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ List f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object apply(Object obj) {
                return ggl.O000000o(this.f$0, this.f$1, (Integer) obj);
            }
        }).onErrorReturn($$Lambda$ggl$jkRvmSYQ_8OCPkQdvlL_OJXcfdI.INSTANCE);
        ixe.O00000Oo(onErrorReturn, "just(1)\n                .observeOn(mOrderSchedule)\n                .flatMap {\n                    var homeOrder = mHomesOrdersMap[homeId]\n                    if (homeOrder == null) {\n                        //新建的家庭\n                        homeOrder = HomeOrder(homeId, false)\n                        mHomesOrdersMap[homeId] = homeOrder\n                    }\n\n                    homeOrder.roomOrders.clear()\n                    homeOrder.roomOrders.addAll(orderList.filterNotNull().map { RoomOrder(it.id, ArrayList(it.dids.filterNotNull())) })\n\n                    saveHomeOrderCache(homeId)\n                    return@flatMap syncOrderToServer(homeId, homeOrder)\n                }.onErrorReturn { false }");
        return onErrorReturn;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void
     arg types: [java.lang.String, int, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int]
     candidates:
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList<_m_j.ggs>, java.util.HashSet<_m_j.ggj>, _m_j.ggm, _m_j.ggt):void
      _m_j.ggo.<init>(java.lang.String, boolean, _m_j.ggn, java.util.ArrayList, java.util.HashSet, _m_j.ggm, int):void */
    /* access modifiers changed from: private */
    public static final SingleSource O000000o(String str, List list, Integer num) {
        ixe.O00000o(str, "$homeId");
        ixe.O00000o(list, "$orderList");
        ixe.O00000o(num, "it");
        ggo ggo = O00000Oo().get(str);
        if (ggo == null) {
            ggo = new ggo(str, false, (ggn) null, (ArrayList) null, (HashSet) null, (ggm) null, 124);
            O00000Oo().put(str, ggo);
        }
        ggo.O00000o.clear();
        ArrayList<ggs> arrayList = ggo.O00000o;
        Iterable<Room> O000000o2 = iuo.O000000o((Iterable) list);
        Collection arrayList2 = new ArrayList(iuo.O000000o(O000000o2, 10));
        for (Room room : O000000o2) {
            String id = room.getId();
            ixe.O00000Oo(id, "it.id");
            List<String> dids = room.getDids();
            ixe.O00000Oo(dids, "it.dids");
            arrayList2.add(new ggs(id, new ArrayList(iuo.O000000o((Iterable) dids))));
        }
        arrayList.addAll((List) arrayList2);
        f17743O000000o.O00000o0(str);
        return O000000o(str, ggo, "");
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000Oo(Throwable th) {
        ixe.O00000o(th, "it");
        return Boolean.FALSE;
    }

    public static Single<Boolean> O000000o(String str, String str2, String str3, List<String> list) {
        ixe.O00000o(str, "homeId");
        ixe.O00000o(str2, "cateId");
        ixe.O00000o(str3, "parent_id");
        ixe.O00000o(list, "orderList");
        Single<Boolean> onErrorReturn = Single.just(1).observeOn(O00000o).flatMap(new Function(str, str2, str3, list) {
            /* class _m_j.$$Lambda$ggl$tSfshJHFyLKCKxEf5Q87Q050E */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ List f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object apply(Object obj) {
                return ggl.O000000o(this.f$0, this.f$1, this.f$2, this.f$3, (Integer) obj);
            }
        }).onErrorReturn($$Lambda$ggl$sLBydCCEI8yd9MJlUlDQCFkAlDY.INSTANCE);
        ixe.O00000Oo(onErrorReturn, "just(1)\n                .observeOn(mOrderSchedule)\n                .flatMap {\n                    var cateOrder = mHomesOrdersMap[homeId]?.cateOrders?.find { it.cateId == cateId }\n                    if (cateOrder == null) {\n                        //从无到有的品类排序(eg.原没有进行过该品类的排序)\n                        cateOrder = CateOrder(cateId, arrayListOf(), parent_id)\n                        mHomesOrdersMap[homeId]?.cateOrders?.add(cateOrder)\n                    }\n\n                    cateOrder.apply {\n                        this.orders.clear()\n                        this.orders.addAll(orderList.filterNotNull())\n                    }\n\n                    saveHomeOrderCache(homeId)\n                    return@flatMap syncOrderToServer(homeId, cateOrder)\n                }.onErrorReturn { false }");
        return onErrorReturn;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: _m_j.ggj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: _m_j.ggj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: _m_j.ggj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: _m_j.ggj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: _m_j.ggj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: _m_j.ggj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: _m_j.ggj} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    public static final SingleSource O000000o(String str, String str2, String str3, List list, Integer num) {
        HashSet<ggj> hashSet;
        Iterable iterable;
        ixe.O00000o(str, "$homeId");
        ixe.O00000o(str2, "$cateId");
        ixe.O00000o(str3, "$parent_id");
        ixe.O00000o(list, "$orderList");
        ixe.O00000o(num, "it");
        ggo ggo = O00000Oo().get(str);
        ggj ggj = null;
        if (!(ggo == null || (iterable = ggo.O00000oO) == null)) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (ixe.O000000o((Object) next.f17741O000000o, (Object) str2)) {
                    ggj = next;
                    break;
                }
            }
            ggj = ggj;
        }
        if (ggj == null) {
            ggj = new ggj(str2, new ArrayList(), str3);
            ggo ggo2 = O00000Oo().get(str);
            if (!(ggo2 == null || (hashSet = ggo2.O00000oO) == null)) {
                hashSet.add(ggj);
            }
        }
        ggj.O00000Oo.clear();
        ggj.O00000Oo.addAll(iuo.O000000o((Iterable) list));
        f17743O000000o.O00000o0(str);
        return O000000o(str, ggj, "");
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000o0(Throwable th) {
        ixe.O00000o(th, "it");
        return Boolean.FALSE;
    }

    public static Single<Boolean> O00000o0(String str, List<String> list) {
        ixe.O00000o(str, "homeId");
        ixe.O00000o(list, "orderList");
        Single<Boolean> onErrorReturn = Single.just(1).observeOn(O00000o).flatMap(new Function(str, list) {
            /* class _m_j.$$Lambda$ggl$OQrQkP8ewDwjF4ZJmpRxajjX_g */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ List f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object apply(Object obj) {
                return ggl.O00000Oo(this.f$0, this.f$1, (Integer) obj);
            }
        }).onErrorReturn($$Lambda$ggl$xjF26RjDeaq_v5ZgIOAf0NJumO8.INSTANCE);
        ixe.O00000Oo(onErrorReturn, "just(1)\n                .observeOn(mOrderSchedule)\n                .flatMap {\n                    val homeOrder = mHomesOrdersMap[homeId] ?: return@flatMap Single.just(false)\n                    val freqCameraOrder = homeOrder.freqCameraOrder\n                    freqCameraOrder.orders.clear()\n                    freqCameraOrder.orders.addAll(orderList)\n\n                    saveHomeOrderCache(homeId)\n                    return@flatMap syncOrderToServer(homeId, freqCameraOrder)\n                }.onErrorReturn { false }");
        return onErrorReturn;
    }

    /* access modifiers changed from: private */
    public static final SingleSource O00000Oo(String str, List list, Integer num) {
        ixe.O00000o(str, "$homeId");
        ixe.O00000o(list, "$orderList");
        ixe.O00000o(num, "it");
        ggo ggo = O00000Oo().get(str);
        if (ggo == null) {
            return Single.just(Boolean.FALSE);
        }
        ggm ggm = ggo.O00000oo;
        ggm.f17744O000000o.clear();
        ggm.f17744O000000o.addAll(list);
        f17743O000000o.O00000o0(str);
        return O000000o(str, ggm, "");
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000o(Throwable th) {
        ixe.O00000o(th, "it");
        return Boolean.FALSE;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    private final void O00000o0(String str) {
        String str2;
        JSONObject jSONObject;
        String jSONObject2;
        O00000Oo("dumpHomeOrderJson");
        if (TextUtils.isEmpty(str)) {
            str2 = ggb.O00000Oo().O0000OOo();
            ixe.O00000Oo(str2, "getInstance().currentHomeId");
        } else {
            ixe.O000000o((Object) str);
            str2 = str;
        }
        ggo ggo = O00000Oo().get(str2);
        if (ggo == null) {
            jSONObject = null;
        } else {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("home_id", ggo.f17746O000000o);
            jSONObject3.put("front_order", ggv.O000000o(ggo.O00000o0.f17745O000000o, DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$1.f8960O000000o));
            jSONObject3.put("room_order", ggv.O000000o(ggo.O00000o, DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$roomOrderJson$1.f8964O000000o));
            jSONObject3.put("cate_order", ggv.O000000o(iuo.O00000o0(ggo.O00000oO), DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$cateOrderJson$1.f8961O000000o));
            jSONObject3.put("freq_camera_order", ggv.O000000o(ggo.O00000oo.f17744O000000o, DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$freqCameraOrderJson$1.f8963O000000o));
            jSONObject3.put("default_camera_switch", ggo.O00000oo.O00000Oo ? "on" : "off");
            jSONObject = jSONObject3;
        }
        String str3 = "";
        if (!(jSONObject == null || (jSONObject2 = jSONObject.toString()) == null)) {
            str3 = jSONObject2;
        }
        if (!TextUtils.isEmpty(str3)) {
            gpy.O000000o(ServiceApplication.getAppContext(), "prefs_home_order_union", ixe.O000000o("home_order_key_prefix_union_", (Object) str), str3);
        }
    }
}

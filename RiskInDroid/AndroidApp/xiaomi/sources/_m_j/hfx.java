package _m_j;

import android.content.Intent;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.ApiErrorWrapper;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\n2\u0006\u0010\u0012\u001a\u00020\u0004J\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000eJ\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000eJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\bJ\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u000eJ\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/cache/FavoriteSceneManager;", "", "()V", "ACTION_FAVORITE_UPDATE", "", "TAG", "latestFavoriteScene", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "execute", "Lio/reactivex/Observable;", "", "scene", "getLatestFavorite", "", "home", "Lcom/xiaomi/smarthome/homeroom/model/Home;", "getUnFavoriteFromServer", "homeId", "markAsFavorite", "scenes", "markAsUnFavorite", "notifyDataChanged", "", "rename", "saveOrder", "order", "syncLatestFromServer", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hfx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final hfx f18878O000000o = new hfx();
    public static final CopyOnWriteArrayList<CommonUsedScene> O00000Oo;

    private hfx() {
    }

    static {
        hfz hfz = hfz.f18889O000000o;
        Collection O00000o02 = hfz.O00000o0();
        if (O00000o02 == null) {
            O00000o02 = EmptyList.f15376O000000o;
        }
        O00000Oo = new CopyOnWriteArrayList<>(O00000o02);
    }

    public static List<CommonUsedScene> O000000o(Home home) {
        return (home == null || !home.isOwner()) ? EmptyList.f15376O000000o : iuo.O00000o0((Iterable) O00000Oo);
    }

    public static Observable<Boolean> O000000o(CommonUsedScene commonUsedScene) {
        ixe.O00000o(commonUsedScene, "scene");
        Observable<Boolean> create = Observable.create(new ObservableOnSubscribe() {
            /* class _m_j.$$Lambda$hfx$0TZ80U8a0I2iBGzGc_OdnJxc6c8 */

            public final void subscribe(ObservableEmitter observableEmitter) {
                hfx.O000000o(CommonUsedScene.this, observableEmitter);
            }
        });
        ixe.O00000Oo(create, "create {\n            if (scene.sceneType == 1) {\n                SceneRouterFactory.getSceneBridge().miioSceneStart(null, scene.sceneId.toString(), object : AsyncCallback<Void, Error>() {\n                    override fun onSuccess(result: Void?) {\n                        if (it.isDisposed) return\n                        it.onNext(true)\n                        it.onComplete()\n                    }\n\n                    override fun onFailure(error: Error) {\n                        if (it.isDisposed) return\n                        it.onError(ApiErrorWrapper(error))\n                    }\n                })\n            } else {\n                SceneRouterFactory.getSceneBridge().runSpecScene(null, scene.sceneId, object : AsyncCallback<JSONObject, Error>() {\n                    override fun onSuccess(result: JSONObject?) {\n                        if (it.isDisposed) return\n                        it.onNext(true)\n                        it.onComplete()\n                    }\n\n                    override fun onFailure(error: Error) {\n                        if (it.isDisposed) return\n                        it.onError(ApiErrorWrapper(error))\n                    }\n                })\n            }\n        }");
        return create;
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/cache/FavoriteSceneManager$execute$1$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Ljava/lang/Void;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o extends fsm<Void, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter<Boolean> f18879O000000o;

        O000000o(ObservableEmitter<Boolean> observableEmitter) {
            this.f18879O000000o = observableEmitter;
        }

        public final void onFailure(fso fso) {
            ixe.O00000o(fso, "error");
            if (!this.f18879O000000o.isDisposed()) {
                this.f18879O000000o.onError(new ApiErrorWrapper(fso));
            }
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            if (!this.f18879O000000o.isDisposed()) {
                this.f18879O000000o.onNext(Boolean.TRUE);
                this.f18879O000000o.onComplete();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(CommonUsedScene commonUsedScene, ObservableEmitter observableEmitter) {
        ixe.O00000o(commonUsedScene, "$scene");
        ixe.O00000o(observableEmitter, "it");
        if (commonUsedScene.O00000o0 == 1) {
            hor.O000000o().miioSceneStart(null, String.valueOf(commonUsedScene.f11134O000000o), new O000000o(observableEmitter));
        } else {
            hor.O000000o().runSpecScene(null, commonUsedScene.f11134O000000o, new O00000Oo(observableEmitter));
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/cache/FavoriteSceneManager$execute$1$2", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Lorg/json/JSONObject;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo extends fsm<JSONObject, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter<Boolean> f18880O000000o;

        O00000Oo(ObservableEmitter<Boolean> observableEmitter) {
            this.f18880O000000o = observableEmitter;
        }

        public final void onFailure(fso fso) {
            ixe.O00000o(fso, "error");
            if (!this.f18880O000000o.isDisposed()) {
                this.f18880O000000o.onError(new ApiErrorWrapper(fso));
            }
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            if (!this.f18880O000000o.isDisposed()) {
                this.f18880O000000o.onNext(Boolean.TRUE);
                this.f18880O000000o.onComplete();
            }
        }
    }

    public static Observable<List<CommonUsedScene>> O00000Oo(Home home) {
        if (home == null || !home.isOwner()) {
            Observable<List<CommonUsedScene>> just = Observable.just(EmptyList.f15376O000000o);
            ixe.O00000Oo(just, "just(emptyList())");
            return just;
        }
        Observable<List<CommonUsedScene>> create = Observable.create(new ObservableOnSubscribe(home.getId()) {
            /* class _m_j.$$Lambda$hfx$QdcxL3wRQqEdg_rGbiaCncuheOg */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                hfx.O000000o(Home.this, this.f$1, observableEmitter);
            }
        });
        ixe.O00000Oo(create, "create {\n            SceneRouterFactory.getSceneBridge().getCommonUsedSceneList(null, home.id, object : AsyncCallback<List<CommonUsedScene>?, Error?>() {\n                override fun onSuccess(result: List<CommonUsedScene>?) {\n                    if (HomeManager.getInstance().currentHomeId != id) {\n                        it.onNext(emptyList())\n                        it.onComplete()\n                    } else {\n                        if (it.isDisposed) return\n                        val latest = result ?: emptyList()\n                        if (latestFavoriteScene != latest) {\n                            latestFavoriteScene.clear()\n                            latestFavoriteScene.addAll(latest)\n                        }\n                        it.onNext(latest)\n                        notifyDataChanged()\n                    }\n                }\n\n                override fun onFailure(error: Error?) {\n                    if (it.isDisposed) return\n                    it.onError(ApiErrorWrapper(error!!))\n                }\n            })\n        }");
        return create;
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/cache/FavoriteSceneManager$syncLatestFromServer$1$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000Oo extends fsm<List<? extends CommonUsedScene>, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ String f18885O000000o;
        final /* synthetic */ ObservableEmitter<List<CommonUsedScene>> O00000Oo;

        O0000Oo(String str, ObservableEmitter<List<CommonUsedScene>> observableEmitter) {
            this.f18885O000000o = str;
            this.O00000Oo = observableEmitter;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
        public final /* synthetic */ void onSuccess(Object obj) {
            List list = (List) obj;
            if (!ixe.O000000o((Object) ggb.O00000Oo().O0000OOo(), (Object) this.f18885O000000o)) {
                this.O00000Oo.onNext(EmptyList.f15376O000000o);
                this.O00000Oo.onComplete();
            } else if (!this.O00000Oo.isDisposed()) {
                if (list == null) {
                    list = EmptyList.f15376O000000o;
                }
                if (!ixe.O000000o(hfx.O00000Oo, list)) {
                    hfx.O00000Oo.clear();
                    hfx.O00000Oo.addAll(list);
                }
                this.O00000Oo.onNext(list);
                hfx hfx = hfx.f18878O000000o;
                hfx.O000000o();
            }
        }

        public final void onFailure(fso fso) {
            if (!this.O00000Oo.isDisposed()) {
                ObservableEmitter<List<CommonUsedScene>> observableEmitter = this.O00000Oo;
                ixe.O000000o(fso);
                observableEmitter.onError(new ApiErrorWrapper(fso));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Home home, String str, ObservableEmitter observableEmitter) {
        ixe.O00000o(observableEmitter, "it");
        hor.O000000o().getCommonUsedSceneList(null, home.getId(), new O0000Oo(str, observableEmitter));
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/cache/FavoriteSceneManager$getUnFavoriteFromServer$1$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 extends fsm<List<? extends CommonUsedScene>, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter<List<CommonUsedScene>> f18882O000000o;

        O00000o0(ObservableEmitter<List<CommonUsedScene>> observableEmitter) {
            this.f18882O000000o = observableEmitter;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            List list = (List) obj;
            if (!this.f18882O000000o.isDisposed()) {
                ObservableEmitter<List<CommonUsedScene>> observableEmitter = this.f18882O000000o;
                if (list == null) {
                    list = EmptyList.f15376O000000o;
                }
                observableEmitter.onNext(list);
                this.f18882O000000o.onComplete();
            }
        }

        public final void onFailure(fso fso) {
            if (!this.f18882O000000o.isDisposed()) {
                ObservableEmitter<List<CommonUsedScene>> observableEmitter = this.f18882O000000o;
                ixe.O000000o(fso);
                observableEmitter.onError(new ApiErrorWrapper(fso));
            }
        }
    }

    public static Observable<List<CommonUsedScene>> O000000o(String str) {
        ixe.O00000o(str, "homeId");
        Observable<List<CommonUsedScene>> create = Observable.create(new ObservableOnSubscribe(str) {
            /* class _m_j.$$Lambda$hfx$ECkCFc9L0SVJvZUKTSunzb_Tuz0 */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                hfx.O000000o(this.f$0, observableEmitter);
            }
        });
        ixe.O00000Oo(create, "create {\n            SceneRouterFactory.getSceneBridge().getUncommonUsedSceneList(null, homeId, object : AsyncCallback<List<CommonUsedScene>?, Error?>() {\n                override fun onSuccess(result: List<CommonUsedScene>?) {\n                    if (it.isDisposed) return\n                    it.onNext(result ?: emptyList())\n                    it.onComplete()\n                }\n\n                override fun onFailure(error: Error?) {\n                    if (it.isDisposed) return\n                    it.onError(ApiErrorWrapper(error!!))\n                }\n            })\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(String str, ObservableEmitter observableEmitter) {
        ixe.O00000o(str, "$homeId");
        ixe.O00000o(observableEmitter, "it");
        hor.O000000o().getUncommonUsedSceneList(null, str, new O00000o0(observableEmitter));
    }

    public static Observable<Boolean> O000000o(String str, List<? extends CommonUsedScene> list) {
        ixe.O00000o(str, "homeId");
        ixe.O00000o(list, "order");
        List O00000o02 = iuo.O00000o0((Iterable) O00000Oo);
        O00000Oo.clear();
        O00000Oo.addAll(list);
        O000000o();
        Observable<Boolean> create = Observable.create(new ObservableOnSubscribe(str, list, O00000o02) {
            /* class _m_j.$$Lambda$hfx$hFXnIc9A5prfVAJiKYWCF5zGt2s */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ List f$1;
            private final /* synthetic */ List f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                hfx.O000000o(this.f$0, this.f$1, this.f$2, observableEmitter);
            }
        });
        ixe.O00000Oo(create, "create {\n            SceneRouterFactory.getSceneBridge().changeCommonUsedSceneOrder(null, homeId, order.map { it.sceneId }, object : AsyncCallback<JSONObject, Error>() {\n                override fun onSuccess(result: JSONObject?) {\n                    if (it.isDisposed) return\n                    it.onNext(true)\n                    it.onComplete()\n                }\n\n                override fun onFailure(error: Error) {\n                    if (it.isDisposed) return\n                    it.onError(ApiErrorWrapper(error))\n\n                    latestFavoriteScene.clear()\n                    latestFavoriteScene.addAll(prev)\n                    notifyDataChanged()\n                }\n            })\n        }");
        return create;
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/cache/FavoriteSceneManager$saveOrder$1$2", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Lorg/json/JSONObject;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000Oo0 extends fsm<JSONObject, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter<Boolean> f18886O000000o;
        final /* synthetic */ List<CommonUsedScene> O00000Oo;

        /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.xiaomi.smarthome.scene.bean.CommonUsedScene>, java.util.List<? extends com.xiaomi.smarthome.scene.bean.CommonUsedScene>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        O0000Oo0(ObservableEmitter<Boolean> observableEmitter, List<? extends CommonUsedScene> r2) {
            this.f18886O000000o = observableEmitter;
            this.O00000Oo = r2;
        }

        public final void onFailure(fso fso) {
            ixe.O00000o(fso, "error");
            if (!this.f18886O000000o.isDisposed()) {
                this.f18886O000000o.onError(new ApiErrorWrapper(fso));
                hfx.O00000Oo.clear();
                hfx.O00000Oo.addAll(this.O00000Oo);
                hfx hfx = hfx.f18878O000000o;
                hfx.O000000o();
            }
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            if (!this.f18886O000000o.isDisposed()) {
                this.f18886O000000o.onNext(Boolean.TRUE);
                this.f18886O000000o.onComplete();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(String str, List list, List list2, ObservableEmitter observableEmitter) {
        ixe.O00000o(str, "$homeId");
        ixe.O00000o(list, "$order");
        ixe.O00000o(list2, "$prev");
        ixe.O00000o(observableEmitter, "it");
        hol O000000o2 = hor.O000000o();
        Iterable<CommonUsedScene> iterable = list;
        Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
        for (CommonUsedScene commonUsedScene : iterable) {
            arrayList.add(Long.valueOf(commonUsedScene.f11134O000000o));
        }
        O000000o2.changeCommonUsedSceneOrder(null, str, (List) arrayList, new O0000Oo0(observableEmitter, list2));
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/cache/FavoriteSceneManager$rename$1$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Lorg/json/JSONObject;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000OOo extends fsm<JSONObject, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter<Boolean> f18884O000000o;

        O0000OOo(ObservableEmitter<Boolean> observableEmitter) {
            this.f18884O000000o = observableEmitter;
        }

        public final void onFailure(fso fso) {
            ixe.O00000o(fso, "error");
            if (!this.f18884O000000o.isDisposed()) {
                this.f18884O000000o.onError(new ApiErrorWrapper(fso));
                hfx hfx = hfx.f18878O000000o;
                hfx.O000000o();
            }
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            if (!this.f18884O000000o.isDisposed()) {
                this.f18884O000000o.onNext(Boolean.TRUE);
                this.f18884O000000o.onComplete();
            }
        }
    }

    public static Observable<Boolean> O00000Oo(CommonUsedScene commonUsedScene) {
        ixe.O00000o(commonUsedScene, "scene");
        Observable<Boolean> doOnNext = Observable.create(new ObservableOnSubscribe() {
            /* class _m_j.$$Lambda$hfx$j6juFfGLO4c5XxlHx63u8B_Kz_E */

            public final void subscribe(ObservableEmitter observableEmitter) {
                hfx.O00000Oo(CommonUsedScene.this, observableEmitter);
            }
        }).doOnNext(new Consumer() {
            /* class _m_j.$$Lambda$hfx$Q2IpVG2cdI6uDxJPnkhteoabRs */

            public final void accept(Object obj) {
                hfx.O000000o(CommonUsedScene.this, (Boolean) obj);
            }
        });
        ixe.O00000Oo(doOnNext, "create<Boolean> {\n            SceneRouterFactory.getSceneBridge().updateCommonUseName(null, scene, object : AsyncCallback<JSONObject, Error>() {\n                override fun onSuccess(result: JSONObject?) {\n                    if (it.isDisposed) return\n                    it.onNext(true)\n                    it.onComplete()\n                }\n\n                override fun onFailure(error: Error) {\n                    if (it.isDisposed) return\n                    it.onError(ApiErrorWrapper(error))\n                    notifyDataChanged()\n                }\n            })\n        }.doOnNext {\n            SceneRouterFactory.getSceneBridge().replaceLiteScene(scene)\n            SceneRouterFactory.getSceneBridge().updateLiteScene()\n        }");
        return doOnNext;
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(CommonUsedScene commonUsedScene, ObservableEmitter observableEmitter) {
        ixe.O00000o(commonUsedScene, "$scene");
        ixe.O00000o(observableEmitter, "it");
        hor.O000000o().updateCommonUseName(null, commonUsedScene, new O0000OOo(observableEmitter));
    }

    /* access modifiers changed from: private */
    public static final void O000000o(CommonUsedScene commonUsedScene, Boolean bool) {
        ixe.O00000o(commonUsedScene, "$scene");
        hor.O000000o().replaceLiteScene(commonUsedScene);
        hor.O000000o().updateLiteScene();
    }

    public static Observable<Boolean> O000000o(List<? extends CommonUsedScene> list) {
        ixe.O00000o(list, "scenes");
        List O00000o02 = iuo.O00000o0((Iterable) list);
        O00000Oo.removeAll(O00000o02);
        O000000o();
        Observable<Boolean> create = Observable.create(new ObservableOnSubscribe(list, O00000o02) {
            /* class _m_j.$$Lambda$hfx$o68Z8Jk5wvJzhGKblTDvCY50lhU */
            private final /* synthetic */ List f$0;
            private final /* synthetic */ List f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                hfx.O000000o(this.f$0, this.f$1, observableEmitter);
            }
        });
        ixe.O00000Oo(create, "create {\n            SceneRouterFactory.getSceneBridge().setUncommonUse(null, HomeManager.getInstance().currentHomeId,scenes, object : AsyncCallback<JSONObject, Error>() {\n                override fun onSuccess(result: JSONObject?) {\n                    if (it.isDisposed) return\n                    it.onNext(true)\n                    it.onComplete()\n                }\n\n                override fun onFailure(error: Error) {\n                    if (it.isDisposed) return\n                    it.onError(ApiErrorWrapper(error))\n                    latestFavoriteScene.addAll(temp)\n                    notifyDataChanged()\n                }\n            })\n        }");
        return create;
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/cache/FavoriteSceneManager$markAsUnFavorite$1$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Lorg/json/JSONObject;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000O0o extends fsm<JSONObject, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter<Boolean> f18883O000000o;
        final /* synthetic */ List<CommonUsedScene> O00000Oo;

        /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.xiaomi.smarthome.scene.bean.CommonUsedScene>, java.util.List<? extends com.xiaomi.smarthome.scene.bean.CommonUsedScene>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        O0000O0o(ObservableEmitter<Boolean> observableEmitter, List<? extends CommonUsedScene> r2) {
            this.f18883O000000o = observableEmitter;
            this.O00000Oo = r2;
        }

        public final void onFailure(fso fso) {
            ixe.O00000o(fso, "error");
            if (!this.f18883O000000o.isDisposed()) {
                this.f18883O000000o.onError(new ApiErrorWrapper(fso));
                hfx.O00000Oo.addAll(this.O00000Oo);
                hfx hfx = hfx.f18878O000000o;
                hfx.O000000o();
            }
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            if (!this.f18883O000000o.isDisposed()) {
                this.f18883O000000o.onNext(Boolean.TRUE);
                this.f18883O000000o.onComplete();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(List list, List list2, ObservableEmitter observableEmitter) {
        ixe.O00000o(list, "$scenes");
        ixe.O00000o(list2, "$temp");
        ixe.O00000o(observableEmitter, "it");
        hor.O000000o().setUncommonUse(null, ggb.O00000Oo().O0000OOo(), list, new O0000O0o(observableEmitter, list2));
    }

    public static Observable<Boolean> O00000Oo(List<? extends CommonUsedScene> list) {
        ixe.O00000o(list, "scenes");
        List O00000o02 = iuo.O00000o0((Iterable) list);
        O00000Oo.addAll(O00000o02);
        O000000o();
        Observable<Boolean> create = Observable.create(new ObservableOnSubscribe(list, O00000o02) {
            /* class _m_j.$$Lambda$hfx$CX1ZC0zhRNe_Tg7BWKd1arZs3U */
            private final /* synthetic */ List f$0;
            private final /* synthetic */ List f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                hfx.O00000Oo(this.f$0, this.f$1, observableEmitter);
            }
        });
        ixe.O00000Oo(create, "create {\n            SceneRouterFactory.getSceneBridge().setCommonUse(null, HomeManager.getInstance().currentHomeId,scenes, object : AsyncCallback<JSONObject, Error>() {\n                override fun onSuccess(result: JSONObject?) {\n                    if (it.isDisposed) return\n                    it.onNext(true)\n                    it.onComplete()\n                }\n\n                override fun onFailure(error: Error) {\n                    if (it.isDisposed) return\n                    it.onError(ApiErrorWrapper(error))\n                    latestFavoriteScene.removeAll(temp)\n                    notifyDataChanged()\n                }\n            })\n        }");
        return create;
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/cache/FavoriteSceneManager$markAsFavorite$1$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Lorg/json/JSONObject;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o extends fsm<JSONObject, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter<Boolean> f18881O000000o;
        final /* synthetic */ List<CommonUsedScene> O00000Oo;

        /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.xiaomi.smarthome.scene.bean.CommonUsedScene>, java.util.List<? extends com.xiaomi.smarthome.scene.bean.CommonUsedScene>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        O00000o(ObservableEmitter<Boolean> observableEmitter, List<? extends CommonUsedScene> r2) {
            this.f18881O000000o = observableEmitter;
            this.O00000Oo = r2;
        }

        public final void onFailure(fso fso) {
            ixe.O00000o(fso, "error");
            if (!this.f18881O000000o.isDisposed()) {
                this.f18881O000000o.onError(new ApiErrorWrapper(fso));
                hfx.O00000Oo.removeAll(this.O00000Oo);
                hfx hfx = hfx.f18878O000000o;
                hfx.O000000o();
            }
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            if (!this.f18881O000000o.isDisposed()) {
                this.f18881O000000o.onNext(Boolean.TRUE);
                this.f18881O000000o.onComplete();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(List list, List list2, ObservableEmitter observableEmitter) {
        ixe.O00000o(list, "$scenes");
        ixe.O00000o(list2, "$temp");
        ixe.O00000o(observableEmitter, "it");
        hor.O000000o().setCommonUse(null, ggb.O00000Oo().O0000OOo(), list, new O00000o(observableEmitter, list2));
    }

    public static void O000000o() {
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("action_favorite_update"));
    }
}

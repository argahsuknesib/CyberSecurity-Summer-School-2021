package _m_j;

import _m_j.gwl;
import _m_j.gwm;
import _m_j.gwn;
import _m_j.gwo;
import com.xiaomi.smarthome.R;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0014R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\r0\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePresent;", "Landroidx/lifecycle/ViewModel;", "()V", "mDataStateHolder", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState$FaceStatusDataState;", "kotlin.jvm.PlatformType", "mDisposables", "Lio/reactivex/disposables/CompositeDisposable;", "mFacePrivacyApi", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyApi;", "mStateDispatcher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState;", "renderView", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePresent$RenderView;", "bindView", "", "dispatchEvent", "event", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyEvent;", "onCleared", "Companion", "RenderView", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class gwl extends fm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18411O000000o = new O000000o((byte) 0);
    private O00000Oo O00000Oo;
    private CompositeDisposable O00000o = new CompositeDisposable();
    private final gwm O00000o0 = gwm.O000000o();
    private final PublishSubject<gwo> O00000oO;
    private final BehaviorSubject<gwo.O00000Oo> O00000oo;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePresent$RenderView;", "", "render", "", "state", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState;", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O00000Oo {
        void render(gwo gwo);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePresent$Companion;", "", "()V", "TAG", "", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    public gwl() {
        PublishSubject<gwo> create = PublishSubject.create();
        ixe.O00000Oo(create, "create<FacePrivacyState>()");
        this.O00000oO = create;
        BehaviorSubject<gwo.O00000Oo> create2 = BehaviorSubject.create();
        ixe.O00000Oo(create2, "create<FacePrivacyState.FaceStatusDataState>()");
        this.O00000oo = create2;
    }

    public final void O000000o(O00000Oo o00000Oo) {
        ixe.O00000o(o00000Oo, "renderView");
        this.O00000Oo = o00000Oo;
        this.O00000o.add(this.O00000oO.observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$gwl$1kp7FEoGzflurCtemzeQ4zet5EY */

            public final void accept(Object obj) {
                gwl.O000000o(gwl.O00000Oo.this, (gwo) obj);
            }
        }));
    }

    /* access modifiers changed from: private */
    public static final void O000000o(O00000Oo o00000Oo, gwo gwo) {
        ixe.O00000o(o00000Oo, "$renderView");
        ixe.O00000Oo(gwo, "it");
        o00000Oo.render(gwo);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, _m_j.gwn]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void O000000o(gwn gwn) {
        ixe.O00000o(gwn, "event");
        gsy.O000000o(3, "FacePresent", ixe.O000000o("dispatchEvent: ", (Object) gwn));
        if (gwn instanceof gwn.O000000o) {
            this.O00000oO.onNext(gwo.O00000o0.f18424O000000o);
            this.O00000o.add(this.O00000o0.O00000Oo().map($$Lambda$gwl$a4eY7nj6QnQ_fhNsRlw8pwXuwoY.INSTANCE).doOnNext(new Consumer() {
                /* class _m_j.$$Lambda$gwl$a8K13KUJd6VactY49NWJWwfYmn8 */

                public final void accept(Object obj) {
                    gwl.O000000o(gwl.this, (gwo.O00000Oo) obj);
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                /* class _m_j.$$Lambda$gwl$oWwPPRVj1fNGADMX6wi8wGken2U */

                public final void accept(Object obj) {
                    gwl.O00000Oo(gwl.this, (gwo.O00000Oo) obj);
                }
            }, new Consumer() {
                /* class _m_j.$$Lambda$gwl$GPlt16clm46s5N_AgPDoyHNLjs */

                public final void accept(Object obj) {
                    gwl.O000000o(gwl.this, (Throwable) obj);
                }
            }));
        } else if (gwn instanceof gwn.O00000Oo) {
            this.O00000oO.onNext(gwo.O00000o0.f18424O000000o);
            gwn.O00000Oo o00000Oo = (gwn.O00000Oo) gwn;
            String str = o00000Oo.f18420O000000o;
            boolean z = o00000Oo.O00000Oo;
            this.O00000o.add(this.O00000o0.O000000o(str, z).flatMap(new Function(str, z) {
                /* class _m_j.$$Lambda$gwl$FkbvcaPMpRU6oA1ylNA_Wks3z5c */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ boolean f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final Object apply(Object obj) {
                    return gwl.O000000o(gwl.this, this.f$1, this.f$2, (Boolean) obj);
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                /* class _m_j.$$Lambda$gwl$BCKXuKS7OfqGZG9YgsBT72BvIQ */

                public final void accept(Object obj) {
                    gwl.O000000o(gwl.this, (gwo) obj);
                }
            }, new Consumer() {
                /* class _m_j.$$Lambda$gwl$GHdoe6XcxRLa7Xc2USgjCAvBX5U */

                public final void accept(Object obj) {
                    gwl.O00000Oo(gwl.this, (Throwable) obj);
                }
            }));
        }
    }

    /* access modifiers changed from: private */
    public static final gwo.O00000Oo O000000o(List list) {
        ixe.O00000o(list, "faceStatuses");
        return new gwo.O00000Oo(list);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(gwl gwl, gwo.O00000Oo o00000Oo) {
        ixe.O00000o(gwl, "this$0");
        gwl.O00000oo.onNext(o00000Oo);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(gwl gwl, Throwable th) {
        ixe.O00000o(gwl, "this$0");
        PublishSubject<gwo> publishSubject = gwl.O00000oO;
        ixe.O00000Oo(th, "it");
        publishSubject.onNext(new gwo.O000000o(th));
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(gwl gwl, gwo.O00000Oo o00000Oo) {
        ixe.O00000o(gwl, "this$0");
        gwl.O00000oO.onNext(o00000Oo);
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
    public static final ObservableSource O000000o(gwl gwl, String str, boolean z, Boolean bool) {
        ixe.O00000o(gwl, "this$0");
        ixe.O00000o(str, "$did");
        ixe.O00000o(bool, "isSuccess");
        gwo.O00000Oo value = gwl.O00000oo.getValue();
        ixe.O000000o(value);
        if (!bool.booleanValue()) {
            return Observable.just(new gwo.O00000o(R.string.failed, null, 2), value);
        }
        Iterable<gwm.O000000o> iterable = value.f18422O000000o;
        Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
        for (gwm.O000000o o000000o : iterable) {
            if (ixe.O000000o((Object) o000000o.f18418O000000o.did, (Object) str)) {
                o000000o = new gwm.O000000o(o000000o.f18418O000000o, Boolean.valueOf(z));
            }
            arrayList.add(o000000o);
        }
        return Observable.just(new gwo.O00000Oo((List) arrayList)).doOnNext(new Consumer() {
            /* class _m_j.$$Lambda$gwl$Ot02TOuOc7ckFiHKo0_LKCdSoww */

            public final void accept(Object obj) {
                gwl.O00000o0(gwl.this, (gwo.O00000Oo) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final void O00000o0(gwl gwl, gwo.O00000Oo o00000Oo) {
        ixe.O00000o(gwl, "this$0");
        gwl.O00000oo.onNext(o00000Oo);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(gwl gwl, gwo gwo) {
        ixe.O00000o(gwl, "this$0");
        gwl.O00000oO.onNext(gwo);
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(gwl gwl, Throwable th) {
        ixe.O00000o(gwl, "this$0");
        PublishSubject<gwo> publishSubject = gwl.O00000oO;
        ixe.O00000Oo(th, "it");
        publishSubject.onNext(new gwo.O000000o(th));
    }

    public final void onCleared() {
        super.onCleared();
        this.O00000o.clear();
    }
}

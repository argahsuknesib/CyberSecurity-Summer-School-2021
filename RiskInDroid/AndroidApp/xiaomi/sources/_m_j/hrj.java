package _m_j;

import _m_j.hnz;
import com.xiaomi.smarthome.application.ServiceApplication;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class hrj {
    private static volatile hrj O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<hog> f562O000000o = new ArrayList<>();

    private hrj() {
    }

    public static hrj O000000o() {
        if (O00000Oo == null) {
            synchronized (hrj.class) {
                if (O00000Oo == null) {
                    O00000Oo = new hrj();
                }
            }
        }
        return O00000Oo;
    }

    public final boolean O00000Oo() {
        ArrayList<hog> arrayList = this.f562O000000o;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ArrayList O000000o(ArrayList arrayList, HashMap hashMap) throws Exception {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            hog hog = new hog();
            hog.O00000o0 = (hof) arrayList.get(i);
            if (hashMap.containsKey(((hof) arrayList.get(i)).O00000Oo)) {
                hoh hoh = (hoh) hashMap.get(((hof) arrayList.get(i)).O00000Oo);
                if (hoh.O00000o0) {
                    hog.O00000o = hoh;
                    arrayList2.add(hog);
                }
            } else if (((hof) arrayList.get(i)).O00000Oo.longValue() != 1323546968961712128L) {
                arrayList2.add(hog);
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(fsm fsm, Exception exc) throws Exception {
        if (fsm != null) {
            fsm.onFailure(new fso(-900, exc.getMessage()));
        }
        this.f562O000000o.clear();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(fsm fsm, ArrayList arrayList) throws Exception {
        if (arrayList != null && arrayList.size() > 0) {
            this.f562O000000o.clear();
            this.f562O000000o.addAll(arrayList);
        }
        if (fsm != null) {
            fsm.onSuccess(this.f562O000000o);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(final String str, final ObservableEmitter observableEmitter) throws Exception {
        hnz.O000000o(ServiceApplication.getAppContext(), str, 1, (fsm<JSONObject, fso>) new fsy<JSONObject, fso>() {
            /* class _m_j.hrj.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("scene_list");
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter.onNext(hoh.O000000o(optJSONArray, str));
                    }
                }
            }

            public final void onFailure(fso fso) {
                if (!observableEmitter.isDisposed()) {
                    ObservableEmitter observableEmitter = observableEmitter;
                    observableEmitter.onError(new Exception("error code" + fso.f17063O000000o));
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hnz.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean, int):io.reactivex.Observable<_m_j.hnz$O000000o<_m_j.hof>>
     arg types: [android.content.Context, java.lang.String, java.lang.String, int, int]
     candidates:
      _m_j.hnz.O000000o(android.content.Context, int, java.lang.String, int, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      _m_j.hnz.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean, _m_j.hnz$O000000o):io.reactivex.ObservableSource
      _m_j.hnz.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean, int):io.reactivex.Observable<_m_j.hnz$O000000o<_m_j.hof>> */
    public final void O000000o(String str, String str2, fsm<ArrayList<hog>, fso> fsm) {
        Observable.zip(hnz.O000000o(ServiceApplication.getAppContext(), str, str2, false, 1).concatMap(new Function(new ArrayList()) {
            /* class _m_j.$$Lambda$hrj$dJgBWSRA5vLzKKgb08IFWW5kh0 */
            private final /* synthetic */ ArrayList f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return this.f$0.addAll(((hnz.O000000o) obj).O00000Oo);
            }
        }), Observable.create(new ObservableOnSubscribe(str) {
            /* class _m_j.$$Lambda$hrj$dL6Fr7TP5442ZUNtckptTi1_SRs */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                hrj.this.O000000o(this.f$1, observableEmitter);
            }
        }), $$Lambda$hrj$_nBXBhCupSDPUEUZIgVPmUQsvk.INSTANCE).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(fsm) {
            /* class _m_j.$$Lambda$hrj$Q47uwUsnpZIBnh4xZcjtkRHW7b0 */
            private final /* synthetic */ fsm f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                hrj.this.O000000o(this.f$1, (ArrayList) obj);
            }
        }, new Consumer(fsm) {
            /* class _m_j.$$Lambda$hrj$z4goadMZCyRCzDMDcbtIa3jXVY8 */
            private final /* synthetic */ fsm f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                hrj.this.O000000o(this.f$1, (Exception) obj);
            }
        });
    }
}

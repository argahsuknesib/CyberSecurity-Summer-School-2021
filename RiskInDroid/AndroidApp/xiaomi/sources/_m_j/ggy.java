package _m_j;

import _m_j.gsj;
import android.text.TextUtils;
import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ggy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile ggy f17765O000000o;
    private final BehaviorSubject<List<O000000o>> O00000Oo = BehaviorSubject.create();
    private Disposable O00000o0;

    private ggy() {
    }

    public static ggy O000000o() {
        if (f17765O000000o == null) {
            synchronized (ggy.class) {
                if (f17765O000000o == null) {
                    f17765O000000o = new ggy();
                }
            }
        }
        return f17765O000000o;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List O000000o(JSONObject jSONObject) throws JSONException {
        gsy.O00000Oo("XiaoAiGoodRecommendApi", "getYouPinGoods: ".concat(String.valueOf(jSONObject)));
        ArrayList arrayList = new ArrayList();
        if (TextUtils.equals(jSONObject.getString("result"), "ok")) {
            JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("list");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                arrayList.add(new O000000o(jSONObject2.getString("name"), jSONObject2.getString("summary"), jSONObject2.getLong("priceMin"), jSONObject2.getString("img800s"), jSONObject2.getString("url")));
            }
        }
        return arrayList;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f17767O000000o;
        final String O00000Oo;
        final String O00000o;
        final long O00000o0;
        final String O00000oO;

        O000000o(String str, String str2, long j, String str3, String str4) {
            this.f17767O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = j;
            this.O00000o = str3;
            this.O00000oO = str4;
        }
    }

    public final void O00000Oo() {
        if (!this.O00000Oo.hasValue()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new gsi("gIds", "100328"));
            arrayList.add(new gsi("source", "mico_xiaoaikuailian"));
            gsj.O000000o o000000o = new gsj.O000000o();
            o000000o.f18212O000000o = "GET";
            gsj.O000000o O00000Oo2 = o000000o.O00000Oo(hka.O000000o() + "/cgi-op/api/v1/youpin/goodsCard");
            O00000Oo2.O00000oO = arrayList;
            Observable subscribeOn = fsv.O000000o(O00000Oo2.O000000o(), $$Lambda$ggy$jvhkLC106bR5DEHHzVDclOvns5g.INSTANCE).subscribeOn(Schedulers.io());
            BehaviorSubject<List<O000000o>> behaviorSubject = this.O00000Oo;
            behaviorSubject.getClass();
            this.O00000o0 = subscribeOn.subscribe(new Consumer() {
                /* class _m_j.$$Lambda$0QD_bvzn6C4nj2EF1sNcbmJnU */

                public final void accept(Object obj) {
                    BehaviorSubject.this.onNext((List) obj);
                }
            }, new Consumer<Throwable>() {
                /* class _m_j.ggy.AnonymousClass1 */

                public final /* synthetic */ void accept(Object obj) throws Exception {
                    gsy.O000000o(3, "XiaoAiGoodRecommendApi", "accept: " + Log.getStackTraceString((Throwable) obj));
                }
            });
        }
    }
}

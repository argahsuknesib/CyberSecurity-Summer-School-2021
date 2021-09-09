package _m_j;

import _m_j.fpu;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.ApiErrorWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fpu {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Subject<String> f16887O000000o = PublishSubject.create();
    public final Subject<O000000o> O00000Oo = BehaviorSubject.create();

    @SuppressLint({"CheckResult"})
    public fpu() {
        Observable<R> observeOn = this.f16887O000000o.debounce(200, TimeUnit.MILLISECONDS).filter($$Lambda$fpu$3PUD5JNHhqDAhqnWySFEpYEd614.INSTANCE).switchMap(new Function<String, ObservableSource<O000000o>>() {
            /* class _m_j.fpu.AnonymousClass1 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                return fpu.this.O00000Oo((String) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
        Subject<O000000o> subject = this.O00000Oo;
        subject.getClass();
        observeOn.subscribe(new Consumer() {
            /* class _m_j.$$Lambda$wDzLnNDibeuO4uVJ8EmrR3xiIM8 */

            public final void accept(Object obj) {
                Subject.this.onNext((fpu.O000000o) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O00000o0(String str) throws Exception {
        return !str.isEmpty();
    }

    public final void O000000o(String str) {
        this.f16887O000000o.onNext(str);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f16890O000000o;
        public final List<Integer> O00000Oo;
        public final String O00000o;
        public final boolean O00000o0;

        O000000o(String str, List<Integer> list, boolean z, String str2) {
            this.f16890O000000o = str;
            this.O00000Oo = list;
            this.O00000o0 = z;
            this.O00000o = str2;
        }
    }

    public final Observable<O000000o> O00000Oo(final String str) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("input", str);
        } catch (JSONException unused) {
        }
        return fsv.O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/product/serach_product").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O000000o(), new fss<O000000o>() {
            /* class _m_j.fpu.AnonymousClass2 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                gsy.O00000Oo("ChooseDeviceSearchApi", "queryFromServer param: " + jSONObject + " ; response: " + jSONObject);
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("related");
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
                }
                return new O000000o(str, arrayList, true, null);
            }
        }).onErrorReturn(new Function(str) {
            /* class _m_j.$$Lambda$fpu$ekuf_lyX1GIIjV89EVS9fpuQMQ */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return fpu.O000000o(this.f$0, (Throwable) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ O000000o O000000o(String str, Throwable th) throws Exception {
        String str2;
        if (th instanceof ApiErrorWrapper) {
            ApiErrorWrapper apiErrorWrapper = (ApiErrorWrapper) th;
            str2 = apiErrorWrapper.mExtra;
            if (TextUtils.isEmpty(str2)) {
                str2 = apiErrorWrapper.detail;
            }
        } else {
            str2 = th.getMessage();
        }
        gsy.O00000Oo("ChooseDeviceSearchApi", "queryFromServer error: ".concat(String.valueOf(str2)));
        return new O000000o(str, null, false, CommonApplication.getAppContext().getString(R.string.device_choose_search_net_error_result));
    }
}

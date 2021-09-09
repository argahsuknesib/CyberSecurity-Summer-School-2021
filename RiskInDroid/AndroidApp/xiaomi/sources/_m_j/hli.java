package _m_j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.webkit.JavascriptInterface;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class hli {
    protected WeakReference<Activity> mActivityRef;
    protected final Subject<String> mResultSubject = BehaviorSubject.create();
    public WeakReference<CommonWebView> mWebViewRef;

    public List<String> getExtraParam() {
        return null;
    }

    public hli(WeakReference<CommonWebView> weakReference, WeakReference<Activity> weakReference2) {
        this.mWebViewRef = weakReference;
        this.mActivityRef = weakReference2;
    }

    @JavascriptInterface
    @SuppressLint({"CheckResult"})
    public final void then(final String str, final String str2) {
        this.mResultSubject.observeOn(AndroidSchedulers.mainThread()).filter(new Predicate<String>() {
            /* class _m_j.hli.AnonymousClass3 */

            public final /* synthetic */ boolean test(Object obj) throws Exception {
                Activity activity = hli.this.mActivityRef.get();
                return (activity == null || hli.this.mWebViewRef.get() == null || activity.isDestroyed()) ? false : true;
            }
        }).subscribe(new Consumer<String>() {
            /* class _m_j.hli.AnonymousClass1 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                String str = (String) obj;
                gsy.O00000Oo("JsPromise", "accept then : result: ".concat(String.valueOf(str)));
                hlp.O000000o(hli.this.mWebViewRef.get(), str, hli.this.getMergedParams(str));
            }
        }, new Consumer<Throwable>() {
            /* class _m_j.hli.AnonymousClass2 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                Throwable th = (Throwable) obj;
                gsy.O00000Oo("JsPromise", "accept then : error: " + th.getLocalizedMessage());
                hlp.O000000o(hli.this.mWebViewRef.get(), str2, hli.this.getMergedParams(th.getLocalizedMessage()));
            }
        });
    }

    public String[] getMergedParams(String str) {
        ArrayList arrayList = new ArrayList();
        List<String> extraParam = getExtraParam();
        if (extraParam != null) {
            arrayList.addAll(extraParam);
        }
        arrayList.add(str);
        String[] strArr = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            strArr[i] = (String) arrayList.get(i);
        }
        return strArr;
    }
}

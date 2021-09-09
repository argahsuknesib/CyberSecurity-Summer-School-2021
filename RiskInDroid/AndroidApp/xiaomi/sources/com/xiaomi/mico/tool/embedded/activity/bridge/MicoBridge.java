package com.xiaomi.mico.tool.embedded.activity.bridge;

import _m_j.dgb;
import _m_j.oOOO00o0;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.xiaomi.mico.api.AccountInfo;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.tool.embedded.activity.bridge.MicoBridge;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MicoBridge {
    protected Activity context;
    public LocationListener mLocationListener;
    protected TitleBar titleBar;
    private WebView webView;

    public MicoBridge(WebView webView2, Activity activity, TitleBar titleBar2) {
        this.webView = webView2;
        this.context = activity;
        this.titleBar = titleBar2;
    }

    /* access modifiers changed from: package-private */
    public void evaluateJavascript(String str, String str2) {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            Object[] objArr = {"evaluateJavascript callBack=%s data=%s", str, str2};
            webView2.post(new Runnable(str, str2) {
                /* class com.xiaomi.mico.tool.embedded.activity.bridge.$$Lambda$MicoBridge$_yd5BuFjrWSFGNRXypa7n0BewAs */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    MicoBridge.this.lambda$evaluateJavascript$0$MicoBridge(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$evaluateJavascript$0$MicoBridge(String str, String str2) {
        this.webView.loadUrl(String.format("javascript:%s('%s')", str, str2));
    }

    @JavascriptInterface
    public void getServiceToken(String str, String str2) {
        new Object[1][0] = "getServiceToken";
        if (this.webView != null) {
            LoginManager.getInstance().refreshServiceToken(str).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1(str, str2) {
                /* class com.xiaomi.mico.tool.embedded.activity.bridge.$$Lambda$MicoBridge$MMSYQMno6I6S7HY6dXIwLjJk2U */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void call(Object obj) {
                    MicoBridge.this.lambda$getServiceToken$1$MicoBridge(this.f$1, this.f$2, (String) obj);
                }
            }, new Action1(str2) {
                /* class com.xiaomi.mico.tool.embedded.activity.bridge.$$Lambda$MicoBridge$kVGlFB2e44cJ8gMhcXYHkqqEJUw */
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void call(Object obj) {
                    MicoBridge.this.lambda$getServiceToken$2$MicoBridge(this.f$1, (Throwable) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$getServiceToken$1$MicoBridge(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            String currentMicoID = MicoManager.getInstance().getCurrentMicoID();
            AccountInfo.ServiceInfo serviceInfo = LoginManager.getInstance().getServiceInfo(str);
            AccountInfo.PassportInfo passportInfo = LoginManager.getInstance().getPassportInfo();
            if (serviceInfo != null && passportInfo != null) {
                evaluateJavascript(str2, buildTokenResult(serviceInfo.getServiceToken(), passportInfo.getCUserId(), currentMicoID));
                return;
            }
            return;
        }
        evaluateJavascript(str2, "{}");
    }

    public /* synthetic */ void lambda$getServiceToken$2$MicoBridge(String str, Throwable th) {
        Object[] objArr = {"refreshServiceToken error", th};
        evaluateJavascript(str, "{}");
    }

    private String buildTokenResult(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ServiceToken", str);
            jSONObject.put("cUserId", str2);
            jSONObject.put("deviceId", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void getCityName(String str) {
        new Object[1][0] = "getCityName";
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.post(new Runnable(str) {
                /* class com.xiaomi.mico.tool.embedded.activity.bridge.$$Lambda$MicoBridge$gpMD39Yb43y3M5R6isbyGovjJWY */
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    MicoBridge.this.lambda$getCityName$5$MicoBridge(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$getCityName$5$MicoBridge(String str) {
        Observable.just(dgb.f14595O000000o).compose(new ObservableTransformer<T, Boolean>(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) {
            /* class _m_j.dgb.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ String[] f14596O000000o;

            {
                this.f14596O000000o = r2;
            }

            public final ObservableSource<Boolean> apply(Observable<T> observable) {
                Observable<T> observable2;
                dgb dgb = dgb.this;
                String[] strArr = this.f14596O000000o;
                if (strArr == null || strArr.length == 0) {
                    throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
                }
                Observable<?> O000000o2 = dgb.O000000o(strArr);
                if (observable == null) {
                    observable2 = Observable.just(dgb.f14595O000000o);
                } else {
                    observable2 = Observable.merge(observable, O000000o2);
                }
                return observable2.flatMap(new Function<Object, Observable<dga>>(strArr) {
                    /* class _m_j.dgb.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String[] f14598O000000o;

                    {
                        this.f14598O000000o = r2;
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006c, code lost:
                        if (r7.getActivity().getPackageManager().isPermissionRevokedByPolicy(r6, r7.getActivity().getPackageName()) != false) goto L_0x0070;
                     */
                    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
                    /* JADX WARNING: Removed duplicated region for block: B:13:0x0050  */
                    public final /* synthetic */ Object apply(Object obj) throws Exception {
                        boolean z;
                        dgb dgb = dgb.this;
                        String[] strArr = this.f14598O000000o;
                        ArrayList arrayList = new ArrayList(strArr.length);
                        ArrayList arrayList2 = new ArrayList();
                        int length = strArr.length;
                        for (int i = 0; i < length; i++) {
                            String str = strArr[i];
                            dgb.O00000Oo.O000000o("Requesting permission ".concat(String.valueOf(str)));
                            boolean z2 = true;
                            if (dgb.O000000o()) {
                                if (!(dgb.O00000Oo.getActivity().checkSelfPermission(str) == 0)) {
                                    z = false;
                                    if (!z) {
                                        arrayList.add(Observable.just(new dga(str, true, false)));
                                    } else {
                                        if (dgb.O000000o()) {
                                            dgc dgc = dgb.O00000Oo;
                                        }
                                        z2 = false;
                                        if (z2) {
                                            arrayList.add(Observable.just(new dga(str, false, false)));
                                        } else {
                                            PublishSubject publishSubject = dgb.O00000Oo.f14599O000000o.get(str);
                                            if (publishSubject == null) {
                                                arrayList2.add(str);
                                                publishSubject = PublishSubject.create();
                                                dgb.O00000Oo.f14599O000000o.put(str, publishSubject);
                                            }
                                            arrayList.add(publishSubject);
                                        }
                                    }
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            String[] strArr2 = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                            dgc dgc2 = dgb.O00000Oo;
                            dgc2.O000000o("requestPermissionsFromFragment " + TextUtils.join(", ", strArr2));
                            dgb.O00000Oo.requestPermissions(strArr2, 42);
                        }
                        return Observable.concat(Observable.fromIterable(arrayList));
                    }
                }).buffer(this.f14596O000000o.length).flatMap(new Function<List<dga>, ObservableSource<Boolean>>() {
                    /* class _m_j.dgb.AnonymousClass1.AnonymousClass1 */

                    public final /* synthetic */ Object apply(Object obj) throws Exception {
                        List<dga> list = (List) obj;
                        if (list.isEmpty()) {
                            return Observable.empty();
                        }
                        for (dga dga : list) {
                            if (!dga.O00000Oo) {
                                return Observable.just(Boolean.FALSE);
                            }
                        }
                        return Observable.just(Boolean.TRUE);
                    }
                });
            }
        }).subscribe(new Consumer(str) {
            /* class com.xiaomi.mico.tool.embedded.activity.bridge.$$Lambda$MicoBridge$BhRGsacRIidwsr9C4ts10suH20k */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                MicoBridge.this.lambda$null$3$MicoBridge(this.f$1, (Boolean) obj);
            }
        }, new Consumer(str) {
            /* class com.xiaomi.mico.tool.embedded.activity.bridge.$$Lambda$MicoBridge$WnzbiqFxqjbhvBMM2AoHqn7WvYo */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                MicoBridge.this.lambda$null$4$MicoBridge(this.f$1, (Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$null$3$MicoBridge(String str, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            getCurrentCity(str);
        } else {
            evaluateJavascript(str, "");
        }
    }

    public /* synthetic */ void lambda$null$4$MicoBridge(String str, Throwable th) throws Exception {
        Object[] objArr = {"RxPermissions request error", th};
        evaluateJavascript(str, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.String):int
     arg types: [android.app.Activity, java.lang.String]
     candidates:
      _m_j.oOOO00o0.O000000o(android.app.Activity, _m_j.d):void
      _m_j.oOOO00o0.O000000o(android.app.Activity, java.lang.String):boolean
      androidx.core.content.ContextCompat.O000000o(android.content.Context, int):android.graphics.drawable.Drawable
      androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.Class):T
      androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.String):int */
    @SuppressLint({"MissingPermission"})
    private void getCurrentCity(final String str) {
        new Object[1][0] = "getCurrentCity";
        final LocationManager locationManager = (LocationManager) this.context.getSystemService("location");
        this.mLocationListener = new LocationListener() {
            /* class com.xiaomi.mico.tool.embedded.activity.bridge.MicoBridge.AnonymousClass1 */

            public void onProviderEnabled(String str) {
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            public void onLocationChanged(Location location) {
                locationManager.removeUpdates(MicoBridge.this.mLocationListener);
                rx.Observable observeOn = rx.Observable.unsafeCreate(new Observable.OnSubscribe(location, str) {
                    /* class com.xiaomi.mico.tool.embedded.activity.bridge.$$Lambda$MicoBridge$1$RxvpY_JgNE6gbgbQp1JRfD9aY */
                    private final /* synthetic */ Location f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void call(Object obj) {
                        MicoBridge.AnonymousClass1.this.lambda$onLocationChanged$0$MicoBridge$1(this.f$1, this.f$2, (Subscriber) obj);
                    }
                }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
                String str = str;
                observeOn.subscribe(new Action1(str) {
                    /* class com.xiaomi.mico.tool.embedded.activity.bridge.$$Lambda$MicoBridge$1$XG1FOPSU4i8lqDzGm98YbbZl8V4 */
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void call(Object obj) {
                        MicoBridge.AnonymousClass1.this.lambda$onLocationChanged$1$MicoBridge$1(this.f$1, (Address) obj);
                    }
                }, new Action1(str) {
                    /* class com.xiaomi.mico.tool.embedded.activity.bridge.$$Lambda$MicoBridge$1$BV7Cvj7cm6AbwHwbRwwMJu0L4M */
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void call(Object obj) {
                        MicoBridge.AnonymousClass1.this.lambda$onLocationChanged$2$MicoBridge$1(this.f$1, (Throwable) obj);
                    }
                });
            }

            public /* synthetic */ void lambda$onLocationChanged$0$MicoBridge$1(Location location, String str, Subscriber subscriber) {
                try {
                    subscriber.onNext(new Geocoder(MicoBridge.this.context, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 10).get(0));
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                    MicoBridge.this.evaluateJavascript(str, "");
                }
            }

            public /* synthetic */ void lambda$onLocationChanged$1$MicoBridge$1(String str, Address address) {
                String adminArea = address.getAdminArea();
                if (TextUtils.isEmpty(adminArea)) {
                    adminArea = "";
                }
                MicoBridge.this.evaluateJavascript(str, adminArea);
            }

            public /* synthetic */ void lambda$onLocationChanged$2$MicoBridge$1(String str, Throwable th) {
                Object[] objArr = {"getFromLocation error", th};
                MicoBridge.this.evaluateJavascript(str, "");
            }

            public void onProviderDisabled(String str) {
                MicoBridge.this.evaluateJavascript(str, "");
            }
        };
        if (oOOO00o0.O000000o((Context) this.context, "android.permission.ACCESS_FINE_LOCATION") == 0 || oOOO00o0.O000000o((Context) this.context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            locationManager.requestLocationUpdates("network", 0, 0.0f, this.mLocationListener);
            return;
        }
        new Object[1][0] = "no permission ACCESS_FINE_LOCATION";
        evaluateJavascript(str, "");
    }

    @JavascriptInterface
    public void closeWebviewByJs() {
        new Object[1][0] = "closeWebviewByJs";
        if (this.webView != null) {
            this.context.finish();
        }
    }

    @JavascriptInterface
    public void setBackButtonStatus(boolean z) {
        this.context.runOnUiThread(new Runnable(z) {
            /* class com.xiaomi.mico.tool.embedded.activity.bridge.$$Lambda$MicoBridge$LfL0enhTNptTD7npBVlSGfO8pU */
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MicoBridge.this.lambda$setBackButtonStatus$6$MicoBridge(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$setBackButtonStatus$6$MicoBridge(boolean z) {
        new Object[1][0] = "setBackButtonStatus, show:".concat(String.valueOf(z));
        this.titleBar.showLeftButton(z);
        this.titleBar.showLeftIcon(z);
    }

    public void recycle() {
        this.webView = null;
        this.context = null;
    }
}

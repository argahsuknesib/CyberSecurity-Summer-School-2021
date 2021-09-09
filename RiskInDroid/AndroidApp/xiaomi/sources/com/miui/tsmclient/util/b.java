package com.miui.tsmclient.util;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.miui.tsmclient.entity.VersionControlInfo;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.net.TSMAuthContants;
import com.miui.tsmclient.net.TSMAuthManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f5264a;
    /* access modifiers changed from: private */
    public TSMAuthManager b = new TSMAuthManager();
    private Subscription c;
    private Subscription d;
    /* access modifiers changed from: private */
    public Map<String, Boolean> e = new HashMap();
    private VersionControlInfo f;

    public interface a {
        void onFailure(Integer num);

        void onSuccess(VersionControlInfo versionControlInfo);
    }

    private b() {
    }

    public static long a(Context context, String str) {
        return PrefUtils.getLong(context, "key_version_control_id_".concat(String.valueOf(str)), 0);
    }

    public static b a() {
        if (f5264a == null) {
            synchronized (b.class) {
                if (f5264a == null) {
                    f5264a = new b();
                }
            }
        }
        return f5264a;
    }

    public static String a(long j) {
        if (j <= 0) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_protocol_id", j);
            return jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e("upload phone number failed with an JSONException", e2);
            return "";
        }
    }

    public static void a(Context context, String str, long j) {
        PrefUtils.putLong(context, "key_version_control_id_".concat(String.valueOf(str)), j);
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        this.e.put(str, Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public boolean a(String str) {
        Boolean bool;
        Map<String, Boolean> map = this.e;
        if (map == null || (bool = map.get(str)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public void a(final Context context, final long j, final a aVar) {
        this.d = Observable.fromCallable(new Callable<JSONObject>() {
            /* class com.miui.tsmclient.util.b.AnonymousClass6 */

            /* renamed from: a */
            public JSONObject call() throws Exception {
                return b.this.b.confirmProtocolVersion(context, j);
            }
        }).map(new Func1<JSONObject, Boolean>() {
            /* class com.miui.tsmclient.util.b.AnonymousClass5 */

            /* renamed from: a */
            public Boolean call(JSONObject jSONObject) {
                return Boolean.TRUE;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Boolean>() {
            /* class com.miui.tsmclient.util.b.AnonymousClass7 */

            /* renamed from: a */
            public void onNext(Boolean bool) {
                a aVar;
                LogUtils.d("confirmProtocolVersion onNext called!");
                if (bool.booleanValue() && (aVar = aVar) != null) {
                    aVar.onSuccess(null);
                }
            }

            public void onCompleted() {
                LogUtils.d("confirmProtocolVersion onCompleted called!");
            }

            public void onError(Throwable th) {
                LogUtils.e("confirmProtocolVersion onError called! throwable:".concat(String.valueOf(th)));
                if (th instanceof AuthApiException) {
                    AuthApiException authApiException = (AuthApiException) th;
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.onFailure(Integer.valueOf(authApiException.mErrorCode));
                    }
                }
            }
        });
    }

    public void a(final Context context, final String str, final TSMAuthContants.ActionType actionType, final a aVar) {
        final String concat = "key_match_".concat(String.valueOf(str));
        this.c = Observable.fromCallable(new Callable<JSONObject>() {
            /* class com.miui.tsmclient.util.b.AnonymousClass3 */

            /* renamed from: a */
            public JSONObject call() throws Exception {
                return b.this.b.queryAllServiceProtocol(context, str, actionType);
            }
        }).flatMap(new Func1<JSONObject, Observable<VersionControlInfo>>() {
            /* class com.miui.tsmclient.util.b.AnonymousClass2 */

            /* renamed from: a */
            public Observable<VersionControlInfo> call(JSONObject jSONObject) {
                LogUtils.d("queryAllServiceProtocol api response: ".concat(String.valueOf(jSONObject)));
                if (jSONObject == null || !jSONObject.has("protocols")) {
                    return Observable.empty();
                }
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("protocols");
                    return Observable.from((List) new Gson().fromJson(jSONArray.toString(), new TypeToken<ArrayList<VersionControlInfo>>() {
                        /* class com.miui.tsmclient.util.b.AnonymousClass2.AnonymousClass1 */
                    }.getType()));
                } catch (Exception e) {
                    LogUtils.e("queryAllServiceProtocol response parse failed!", e);
                    return Observable.empty();
                }
            }
        }).filter(new Func1<VersionControlInfo, Boolean>() {
            /* class com.miui.tsmclient.util.b.AnonymousClass1 */

            /* renamed from: a */
            public Boolean call(VersionControlInfo versionControlInfo) {
                return Boolean.valueOf(versionControlInfo != null && TextUtils.equals(str, versionControlInfo.mServiceName));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<VersionControlInfo>() {
            /* class com.miui.tsmclient.util.b.AnonymousClass4 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.miui.tsmclient.util.b.a(com.miui.tsmclient.util.b, java.lang.String, boolean):void
             arg types: [com.miui.tsmclient.util.b, java.lang.String, int]
             candidates:
              com.miui.tsmclient.util.b.a(android.content.Context, java.lang.String, long):void
              com.miui.tsmclient.util.b.a(android.content.Context, long, com.miui.tsmclient.util.b$a):void
              com.miui.tsmclient.util.b.a(com.miui.tsmclient.util.b, java.lang.String, boolean):void */
            /* renamed from: a */
            public void onNext(VersionControlInfo versionControlInfo) {
                LogUtils.d("queryAllServiceProtocol onNext called!");
                if (aVar != null) {
                    b.this.a(versionControlInfo);
                    aVar.onSuccess(versionControlInfo);
                    b.this.a(concat, true);
                }
            }

            public void onCompleted() {
                LogUtils.d("queryAllServiceProtocol onCompleted called!");
                if (!b.this.a(concat)) {
                    aVar.onFailure(-2);
                    b.this.e.clear();
                }
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.miui.tsmclient.util.b.a(com.miui.tsmclient.util.b, java.lang.String, boolean):void
             arg types: [com.miui.tsmclient.util.b, java.lang.String, int]
             candidates:
              com.miui.tsmclient.util.b.a(android.content.Context, java.lang.String, long):void
              com.miui.tsmclient.util.b.a(android.content.Context, long, com.miui.tsmclient.util.b$a):void
              com.miui.tsmclient.util.b.a(com.miui.tsmclient.util.b, java.lang.String, boolean):void */
            public void onError(Throwable th) {
                LogUtils.e("queryAllServiceProtocol onError called! throwable:".concat(String.valueOf(th)));
                b.this.a(concat, true);
                a aVar = aVar;
                if (aVar == null) {
                    return;
                }
                if (th instanceof AuthApiException) {
                    aVar.onFailure(Integer.valueOf(((AuthApiException) th).mErrorCode));
                } else {
                    aVar.onFailure(-1);
                }
            }
        });
    }

    public void a(VersionControlInfo versionControlInfo) {
        this.f = versionControlInfo;
    }

    public void b(Context context, String str, long j) {
        a(context, j, (a) null);
    }
}

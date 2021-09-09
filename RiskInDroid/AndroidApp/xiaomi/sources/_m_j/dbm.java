package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WbAppInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONObject;

public class dbm {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f14454O000000o = "_m_j.dbm";
    private static dbm O00000Oo;
    private Context O00000o0;

    private dbm(Context context) {
        this.O00000o0 = context.getApplicationContext();
    }

    public static synchronized dbm O000000o(Context context) {
        dbm dbm;
        synchronized (dbm.class) {
            if (O00000Oo == null) {
                O00000Oo = new dbm(context);
            }
            dbm = O00000Oo;
        }
        return dbm;
    }

    public final synchronized WbAppInfo O000000o() {
        return O00000o0(this.O00000o0);
    }

    public static WbAppInfo O00000Oo(Context context) {
        return O00000o0(context);
    }

    private static WbAppInfo O00000o0(Context context) {
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        WbAppInfo wbAppInfo = null;
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            for (ResolveInfo next : queryIntentServices) {
                if (!(next.serviceInfo == null || next.serviceInfo.applicationInfo == null || TextUtils.isEmpty(next.serviceInfo.packageName))) {
                    String str = next.serviceInfo.packageName;
                    WbAppInfo O000000o2 = O000000o(context, str);
                    if (O000000o2 != null) {
                        wbAppInfo = O000000o2;
                    }
                    if ("com.sina.weibo".equals(str) || "com.sina.weibog3".equals(str)) {
                        break;
                    }
                }
            }
        }
        return wbAppInfo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092 A[SYNTHETIC, Splitter:B:40:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009e A[SYNTHETIC, Splitter:B:47:0x009e] */
    private static WbAppInfo O000000o(Context context, String str) {
        InputStream inputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArr = new byte[4096];
            inputStream = context.createPackageContext(str, 2).getAssets().open("weibo_for_sdk.json");
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = inputStream.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    dbl.O000000o(context, str);
                }
                JSONObject jSONObject = new JSONObject(sb.toString());
                int optInt = jSONObject.optInt("support_api", -1);
                String optString = jSONObject.optString("authActivityName", null);
                if (optInt != -1) {
                    if (!TextUtils.isEmpty(optString)) {
                        WbAppInfo wbAppInfo = new WbAppInfo();
                        wbAppInfo.setPackageName(str);
                        wbAppInfo.setSupportVersion(optInt);
                        wbAppInfo.setAuthActivityName(optString);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return wbAppInfo;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (Exception e3) {
                e = e3;
                try {
                    dbt.O00000o0(f14454O000000o, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            inputStream = null;
            dbt.O00000o0(f14454O000000o, e.getMessage());
            if (inputStream != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }
}

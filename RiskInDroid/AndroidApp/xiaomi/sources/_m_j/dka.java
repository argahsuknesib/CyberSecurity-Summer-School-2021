package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

public final class dka {
    private static dka O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public final dim f14734O000000o;

    private dka(String str, Context context) {
        djk.f14720O000000o = context.getApplicationContext();
        diz.O00000o0("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        dim dim = new dim(str, context);
        diz.O00000o0("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
        this.f14734O000000o = dim;
    }

    public static synchronized dka O000000o(String str, Context context) {
        synchronized (dka.class) {
            djk.f14720O000000o = context.getApplicationContext();
            diz.O00000o0("openSDK_LOG.Tencent", "createInstance()  -- start, appId = ".concat(String.valueOf(str)));
            if (TextUtils.isEmpty(str)) {
                diz.O00000oO("openSDK_LOG.Tencent", "appId should not be empty!");
                return null;
            }
            if (O00000Oo == null) {
                O00000Oo = new dka(str, context);
            } else {
                String str2 = O00000Oo.f14734O000000o.f14689O000000o.f14674O000000o;
                diz.O00000o0("openSDK_LOG.Tencent", "getAppId() appid =".concat(String.valueOf(str2)));
                if (!str.equals(str2)) {
                    dka dka = O00000Oo;
                    diz.O00000o0("openSDK_LOG.Tencent", "logout()");
                    dka.f14734O000000o.f14689O000000o.O000000o(null, "0");
                    dka.f14734O000000o.f14689O000000o.O00000o0 = null;
                    String str3 = dka.f14734O000000o.f14689O000000o.f14674O000000o;
                    SharedPreferences.Editor edit = dij.O00000Oo().edit();
                    edit.remove(dij.O00000Oo(str3));
                    edit.remove(dij.O00000Oo(str3));
                    edit.remove(dij.O000000o(str3));
                    edit.apply();
                    diz.O00000o0("QQToken", "removeSession sucess");
                    O00000Oo = new dka(str, context);
                }
            }
            if (!O000000o(context, str)) {
                return null;
            }
            djl.O000000o(context, str);
            diz.O00000o0("openSDK_LOG.Tencent", "createInstance()  -- end");
            dka dka2 = O00000Oo;
            return dka2;
        }
    }

    private static boolean O000000o(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), NotificationCompat.FLAG_HIGH_PRIORITY);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), NotificationCompat.FLAG_HIGH_PRIORITY);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                diz.O00000oO("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n".concat(String.valueOf("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档." + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>")));
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            diz.O00000oO("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity".concat(String.valueOf(("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>")));
            return false;
        }
    }

    public static boolean O000000o(int i, int i2, Intent intent, djz djz) {
        StringBuilder sb = new StringBuilder("onActivityResultData() reqcode = ");
        sb.append(i);
        sb.append(", resultcode = ");
        sb.append(i2);
        sb.append(", data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? false");
        diz.O00000o0("openSDK_LOG.Tencent", sb.toString());
        return diq.O000000o().O000000o(i, i2, intent, djz);
    }
}

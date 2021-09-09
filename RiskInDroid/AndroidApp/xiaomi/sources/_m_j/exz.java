package _m_j;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import okhttp3.Response;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u000bJ\u0010\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0006j\b\u0012\u0004\u0012\u00020\r`\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R>\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u00072\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/xiaomi/smarthome/FunctionShowManager;", "", "()V", "TAG", "", "controlServiceBrandDisable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "controlServiceBrandEnable", "controlServiceChannels", "controlServiceDefault", "", "controlServiceGMS", "", "controlServiceGooglePlay", "controlServiceMiui", "controlServiceModelDisable", "controlServiceModelEnable", "controlServicePackage", "controlServiceShow", "<set-?>", "padPlugin", "getPadPlugin", "()Ljava/util/ArrayList;", "sleepMode", "getSleepMode", "()Z", "controlServiceEnable", "notDialogPlugin", "model", "parseConfig", "t", "showPlugin", "", "intent", "Landroid/content/Intent;", "smarthome-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class exz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final exz f15941O000000o = new exz();
    private static final ArrayList<String> O00000Oo = new ArrayList<>();
    private static ArrayList<Integer> O00000o = new ArrayList<>();
    private static ArrayList<String> O00000o0 = iuo.O00000o0("GooglePlay");
    private static ArrayList<String> O00000oO = new ArrayList<>();
    private static ArrayList<String> O00000oo = new ArrayList<>();
    private static ArrayList<String> O0000O0o = new ArrayList<>();
    private static ArrayList<String> O0000OOo = new ArrayList<>();
    private static boolean O0000Oo;
    private static boolean O0000Oo0;
    private static boolean O0000OoO;
    private static boolean O0000Ooo = true;
    private static ArrayList<String> O0000o0 = new ArrayList<>();
    private static boolean O0000o00 = true;

    private exz() {
    }

    static {
        new AppConfigHelper(CommonApplication.getAppContext()).O000000o("mijia_function_show_config", "2", "en", null, new AppConfigHelper.O00000Oo() {
            /* class _m_j.exz.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
             arg types: [java.lang.String, java.lang.String]
             candidates:
              _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
              _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
              _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
              _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
            public final boolean O000000o(String str) throws Exception {
                gsy.O00000o0(LogType.SCENE, "FunctionShowManager", ixe.O000000o("processCache ", (Object) str));
                exz exz = exz.f15941O000000o;
                return exz.O000000o(str);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
             arg types: [java.lang.String, java.lang.String]
             candidates:
              _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
              _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
              _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
              _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
            public final boolean O00000Oo(String str) throws Exception {
                gsy.O00000o0(LogType.SCENE, "FunctionShowManager", ixe.O000000o("processAssets ", (Object) str));
                exz exz = exz.f15941O000000o;
                return exz.O000000o(str);
            }
        }, new AppConfigHelper.O000000o() {
            /* class _m_j.exz.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
             arg types: [java.lang.String, java.lang.String]
             candidates:
              _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
              _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
              _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
              _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
            /* renamed from: O000000o */
            public final void onSuccess(String str, Response response) {
                gsy.O00000o0(LogType.SCENE, "FunctionShowManager", ixe.O000000o("onSuccess ", (Object) str));
                exz exz = exz.f15941O000000o;
                exz.O000000o(str);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
             arg types: [java.lang.String, java.lang.Exception]
             candidates:
              _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
              _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
              _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
              _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
            public final void onFailure(gsf gsf, Exception exc, Response response) {
                gsy.O00000o0(LogType.SCENE, "FunctionShowManager", ixe.O000000o("onFailure ", (Object) exc));
            }
        }, $$Lambda$exz$Y9dZBsiFk7ZwgHMrB7EkG5NnUC4.INSTANCE);
    }

    public static ArrayList<String> O000000o() {
        return O0000o0;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Runnable runnable) {
        runnable.run();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public static boolean O000000o(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(str);
            O0000o00 = jSONObject.optInt("sleep_mode") == 1;
            fli.O000000o(jSONObject.optJSONArray("padplugin_disable"), O0000o0);
            JSONObject optJSONObject = jSONObject.optJSONObject("control_service");
            if (optJSONObject != null) {
                O0000Oo = optJSONObject.optBoolean("showall");
                O0000Oo0 = optJSONObject.optBoolean("miui");
                O0000Ooo = optJSONObject.optBoolean("default");
                O0000OoO = optJSONObject.optBoolean("googleplay");
                fli.O00000Oo(optJSONObject.optJSONArray("gms_status"), O00000o);
                fli.O000000o(optJSONObject.optJSONArray("channels"), O00000o0);
                fli.O000000o(optJSONObject.optJSONArray("packages"), O00000Oo);
                fli.O000000o(optJSONObject.optJSONArray("brand_enable"), O00000oO);
                fli.O000000o(optJSONObject.optJSONArray("brand_disable"), O00000oo);
                fli.O000000o(optJSONObject.optJSONArray("model_enable"), O0000O0o);
                fli.O000000o(optJSONObject.optJSONArray("model_disable"), O0000OOo);
                O00000o.trimToSize();
                O00000o0.trimToSize();
                O00000Oo.trimToSize();
                O00000oO.trimToSize();
                O00000oo.trimToSize();
                O0000O0o.trimToSize();
                O0000OOo.trimToSize();
            }
            return true;
        } catch (Throwable th) {
            Log.e("FunctionShowManager", ixe.O000000o("parseConfig:", (Object) str), th);
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Boolean]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public static boolean O00000Oo() {
        int i;
        Object obj;
        boolean z = true;
        if (O0000Oo) {
            return true;
        }
        if (grr.O00000oO()) {
            gsy.O00000o0(LogType.CARD, "FunctionShowManager", ixe.O000000o("controlServiceEnable miui:", (Object) Boolean.valueOf(grr.O00000oO())));
            return true;
        }
        Context appContext = CommonApplication.getAppContext();
        String installerPackageName = appContext.getPackageManager().getInstallerPackageName(appContext.getPackageName());
        if (installerPackageName == null) {
            installerPackageName = "";
        }
        try {
            Result.O000000o o000000o = Result.f15374O000000o;
            i = Result.O00000o0(Integer.valueOf(GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(appContext)));
        } catch (Throwable th) {
            Result.O000000o o000000o2 = Result.f15374O000000o;
            i = Result.O00000o0(iue.O000000o(th));
        }
        if (Result.O00000Oo(i) != null) {
            i = -1;
        }
        int intValue = ((Number) i).intValue();
        LogType logType = LogType.CARD;
        gsy.O00000o0(logType, "FunctionShowManager", "controlServiceEnable miui:" + grr.O00000oO() + " channel:" + ((Object) gfr.O0000o0O) + " installerPackage:" + installerPackageName + " gmsAvailable:" + intValue + " model:" + ((Object) Build.MODEL) + " brand:" + ((Object) Build.BRAND));
        if (O0000O0o.size() != 0) {
            ArrayList<String> arrayList = O0000O0o;
            if (arrayList.contains(Build.BRAND + '/' + ((Object) Build.MODEL))) {
                return true;
            }
        }
        if (O0000OOo.size() != 0) {
            ArrayList<String> arrayList2 = O0000OOo;
            if (arrayList2.contains(Build.BRAND + '/' + ((Object) Build.MODEL))) {
                return false;
            }
        }
        if (O00000oO.size() != 0 && O00000oO.contains(Build.BRAND)) {
            return true;
        }
        if ((O00000oo.size() != 0 && O00000oo.contains(Build.BRAND)) || O0000Oo0) {
            return false;
        }
        if (O00000o0.size() != 0 && !O00000o0.contains(gfr.O0000o0O)) {
            return false;
        }
        if (O00000Oo.size() != 0 && !O00000Oo.contains(installerPackageName)) {
            return false;
        }
        if (O00000o.size() != 0 && !O00000o.contains(Integer.valueOf(intValue))) {
            return false;
        }
        if (O0000OoO) {
            try {
                Result.O000000o o000000o3 = Result.f15374O000000o;
                if (appContext.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled) {
                    z = false;
                }
                obj = Result.O00000o0(Boolean.valueOf(z));
            } catch (Throwable th2) {
                Result.O000000o o000000o4 = Result.f15374O000000o;
                obj = Result.O00000o0(iue.O000000o(th2));
            }
            if (Result.O00000Oo(obj) != null) {
                obj = Boolean.TRUE;
            }
            if (((Boolean) obj).booleanValue()) {
                return false;
            }
        }
        return O0000Ooo;
    }

    public static void O000000o(Intent intent, String str) {
        hyy.O000000o(intent, !iuo.O000000o(O0000o0, str));
    }

    public static boolean O00000Oo(String str) {
        return iuo.O000000o(O0000o0, str);
    }
}

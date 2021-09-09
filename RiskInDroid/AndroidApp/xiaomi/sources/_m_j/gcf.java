package _m_j;

import _m_j.gcg;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.Utils.MediaStoreUtil;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.AbsRNVideoView;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class gcf implements gcg.O000000o {
    private static volatile gcf O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public HashMap<String, gcg> f17513O000000o = new HashMap<>();
    public HashMap<String, View> O00000Oo = new HashMap<>();
    public HashMap<String, gcd> O00000o0 = new HashMap<>();

    public static gcf O000000o() {
        if (O00000o == null) {
            synchronized (gcf.class) {
                if (O00000o == null) {
                    O00000o = new gcf();
                }
            }
        }
        return O00000o;
    }

    public static String O000000o(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("--")) {
            return str.substring(0, str.indexOf("--"));
        }
        return str;
    }

    public final void O000000o(String str, gcg gcg, String str2) {
        wd.O00000o("RN_CAMERA", "startConnect:" + str + " do realConnection");
        O000000o(str, str2);
        if (gcg != null) {
            gcg.O000000o(str);
        }
    }

    public final boolean O00000Oo(String str) {
        gcd gcd = this.O00000o0.get(str);
        if (gcd == null) {
            return true;
        }
        return gcd.O00000oO;
    }

    public final void O000000o(String str, boolean z) {
        gcd gcd = this.O00000o0.get(str);
        if (gcd == null) {
            gcd gcd2 = new gcd();
            gcd2.O0000Oo0 = z;
            this.O00000o0.put(str, gcd2);
            return;
        }
        gcd.O0000Oo0 = z;
    }

    private void O000000o(String str, String str2) {
        gcd gcd = this.O00000o0.get(str);
        if (gcd == null) {
            gcd = new gcd();
            this.O00000o0.put(str, gcd);
        }
        gcd.f17511O000000o = str2;
    }

    public static void O000000o(WritableMap writableMap, String str) {
        ReactContext currentReactContext;
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not send event, eventName: ".concat(String.valueOf(str)));
        } else if (hmq.O00000o0().isConfigPlugin()) {
            if (writableMap == null) {
                writableMap = Arguments.createMap();
            }
            gbu.O000000o("rncamera will send event, eventName: ".concat(String.valueOf(str)));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        } else {
            gbu.O00000Oo("rncamera can not send event, eventName: ".concat(String.valueOf(str)));
        }
    }

    public static void O000000o(String str, Callback callback) {
        callback.invoke(Boolean.TRUE, str);
    }

    public static void O00000Oo(String str, Callback callback) {
        callback.invoke(Boolean.FALSE, str);
    }

    public final void O00000o0(String str) {
        gbu.O00000o0("释放连接");
        this.O00000o0.remove(str);
        gcg remove = this.f17513O000000o.remove(str);
        if (remove != null) {
            remove.O00000o();
        }
    }

    public static int O00000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1293551627:
                if (str.equals("ObjectMotion")) {
                    c = 4;
                    break;
                }
                break;
            case -740191200:
                if (str.equals("KnownFace")) {
                    c = 1;
                    break;
                }
                break;
            case 2088:
                if (str.equals("AI")) {
                    c = 5;
                    break;
                }
                break;
            case 2181757:
                if (str.equals("Face")) {
                    c = 2;
                    break;
                }
                break;
            case 722651973:
                if (str.equals("PeopleMotion")) {
                    c = 3;
                    break;
                }
                break;
            case 1316906260:
                if (str.equals("BabyCry")) {
                    c = 0;
                    break;
                }
                break;
        }
        if (c == 0) {
            return 1;
        }
        if (c == 1) {
            return 2;
        }
        if (c == 2) {
            return 3;
        }
        if (c == 3) {
            return 4;
        }
        if (c != 4) {
            return c != 5 ? 7 : 6;
        }
        return 5;
    }

    public static void O000000o(String[] strArr) {
        if (strArr != null && strArr.length > 1) {
            Arrays.sort(strArr, new Comparator<String>() {
                /* class _m_j.gcf.AnonymousClass8 */

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return gcf.O00000o((String) obj) - gcf.O00000o((String) obj2);
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void O000000o(DeviceStat deviceStat, int i, boolean z) {
        ReactContext currentReactContext;
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show alarm videos");
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_device_did", deviceStat.did);
        intent.putExtra("is_v4", false);
        intent.setClass(currentReactContext, ((gdu) gdv.f17570O000000o.getUiInterface()).O00000o0(deviceStat.model, deviceStat.version));
        intent.putExtra("is_from_rn", true);
        intent.putExtra("localAlarmEventType", i);
        intent.putExtra("isNewPlugin", z);
        currentActivity.startActivity(intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void O000000o(DeviceStat deviceStat, String str) {
        ReactContext currentReactContext;
        int i;
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show playback videos");
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            return;
        }
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i = jSONObject.getInt("sdcardStatus");
            try {
                z = jSONObject.optBoolean("isVip");
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i = 0;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_device_did", deviceStat.did);
        intent.putExtra("is_v4", true);
        intent.setClass(currentReactContext, ((gdu) gdv.f17570O000000o.getUiInterface()).O0000o00());
        intent.putExtra("is_from_rn", true);
        intent.putExtra("sdcardGetSuccess", true);
        intent.putExtra("sdcardStatus", i);
        intent.putExtra("isVip", z);
        currentActivity.startActivity(intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gdu.O00000Oo(android.content.Context, java.lang.String, java.lang.String):void
     arg types: [android.app.Activity, java.lang.String, java.lang.String]
     candidates:
      _m_j.gdu.O00000Oo(android.app.Activity, java.lang.String, java.lang.String):void
      _m_j.gdu.O00000Oo(android.content.Context, java.lang.String, java.lang.String):void */
    public static void O00000Oo(DeviceStat deviceStat, String str) {
        ReactContext currentReactContext;
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show cloud storage setting");
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
        } else if (deviceStat == null) {
            gbu.O00000Oo("empty device stat");
        } else {
            cid O000000o2 = cid.O000000o(deviceStat, deviceStat.did);
            if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && !O000000o2.isShared()) {
                ((gdu) gdv.f17570O000000o.getUiInterface()).O00000Oo((Context) currentActivity, deviceStat.did, str);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void O000000o(DeviceStat deviceStat) {
        ReactContext currentReactContext;
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show playback videos");
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_device_did", deviceStat.did);
        intent.putExtra("is_v4", true);
        intent.setClass(currentReactContext, ((gdu) gdv.f17570O000000o.getUiInterface()).O0000o0());
        intent.putExtra("is_from_rn", true);
        currentActivity.startActivity(intent);
    }

    private static String O000000o(Uri uri, ContentResolver contentResolver) {
        String[] strArr = {"_data"};
        Cursor query = contentResolver.query(uri, strArr, null, null, null);
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex(strArr[0]));
        query.close();
        return string;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void O00000o0(DeviceStat deviceStat, String str) {
        ReactContext currentReactContext;
        String str2;
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show playback videos");
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            return;
        }
        try {
            str2 = O000000o(Uri.parse(new JSONObject(str).getString("fileUrl")), currentActivity.getContentResolver());
        } catch (Exception unused) {
            str2 = "";
        }
        Intent intent = new Intent();
        intent.putExtra("extra_device_did", deviceStat.did);
        intent.putExtra("is_v4", true);
        intent.setClass(currentReactContext, ((gdu) gdv.f17570O000000o.getUiInterface()).O0000o0O());
        intent.putExtra("is_from_rn", true);
        intent.putExtra("file_path", str2);
        currentActivity.startActivity(intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void O00000o(DeviceStat deviceStat, String str) {
        ReactContext currentReactContext;
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show playback videos");
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            return;
        }
        MediaStoreUtil.O00000Oo o00000Oo = null;
        int i = 0;
        try {
            String optString = new JSONObject(str).optString("albumName");
            if (TextUtils.isEmpty(optString)) {
                optString = "Xiaomi/local/" + deviceStat.did;
            }
            List<MediaStoreUtil.O00000Oo> O000000o2 = MediaStoreUtil.O000000o(CommonApplication.getAppContext(), optString);
            List<MediaStoreUtil.O00000Oo> O00000Oo2 = MediaStoreUtil.O00000Oo(CommonApplication.getAppContext(), optString);
            for (MediaStoreUtil.O00000Oo next : O000000o2) {
                if (next.O0000O0o > i) {
                    i = next.O0000O0o;
                    o00000Oo = next;
                }
            }
            for (MediaStoreUtil.O00000Oo next2 : O00000Oo2) {
                if (next2.O0000O0o > i) {
                    i = next2.O0000O0o;
                    o00000Oo = next2;
                }
            }
            if (o00000Oo == null) {
                gbu.O00000Oo("no media file found");
                return;
            }
            String O000000o3 = O000000o(Uri.parse(o00000Oo.O00000Oo), currentActivity.getContentResolver());
            Intent intent = new Intent();
            intent.putExtra("extra_device_did", deviceStat.did);
            intent.putExtra("is_v4", true);
            intent.setClass(currentReactContext, ((gdu) gdv.f17570O000000o.getUiInterface()).O0000o0O());
            intent.putExtra("is_from_rn", true);
            intent.putExtra("file_path", O000000o3);
            currentActivity.startActivity(intent);
        } catch (Exception e) {
            gbu.O00000Oo("get media file failed: " + e.getMessage());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gdu.O00000o0(android.content.Context, java.lang.String, java.lang.String):void
     arg types: [android.app.Activity, java.lang.String, java.lang.String]
     candidates:
      _m_j.gdu.O00000o0(android.app.Activity, java.lang.String, java.lang.String):void
      _m_j.gdu.O00000o0(android.content.Context, java.lang.String, java.lang.String):void */
    public static void O00000oO(DeviceStat deviceStat, String str) {
        ReactContext currentReactContext;
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show cloud storage setting");
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
        } else if (deviceStat == null) {
            gbu.O00000Oo("empty device stat");
        } else if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            ((gdu) gdv.f17570O000000o.getUiInterface()).O00000o0((Context) currentActivity, deviceStat.did, str);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public static void O000000o(DeviceStat deviceStat, boolean z, String str, String str2) {
        ReactContext currentReactContext;
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show face recognize");
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
        } else if (deviceStat == null) {
            gbu.O00000Oo("empty device stat");
        } else {
            cid O000000o2 = cid.O000000o(deviceStat, deviceStat.did);
            if (!z) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_vip_user", false);
                    jSONObject.put("is_from_camera", true);
                    jSONObject.put("faceState", str);
                    jSONObject.put("cloudUrl", str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (TextUtils.equals("Acquired", str)) {
                    fsp.O000000o().O0000Oo.openFaceManagerImpl(currentActivity, O000000o2.getDid());
                } else {
                    fsp.O000000o().O0000Oo.openFaceManagerActivity(546, currentActivity, O000000o2.getDid(), jSONObject.toString());
                }
            } else {
                fsp.O000000o().O0000Oo.openFaceManagerActivity(currentActivity, O000000o2.getDid());
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gcf.O00000Oo(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gcf.O00000Oo(com.xiaomi.smarthome.device.api.DeviceStat, java.lang.String):void
      _m_j.gcf.O00000Oo(java.lang.String, com.facebook.react.bridge.Callback):void
      _m_j.gcf.O00000Oo(java.lang.String, int):void
      _m_j.gcg.O000000o.O00000Oo(java.lang.String, int):void
      _m_j.gcf.O00000Oo(java.lang.String, boolean):void */
    public final void O000000o(String str, String str2, Callback callback) {
        ReactContext currentReactContext;
        View view = this.O00000Oo.get(str);
        if (view == null || !(view instanceof AbsRNVideoView)) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        gcg gcg = this.f17513O000000o.get(str);
        if (gcg == null) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show cloud storage setting");
            callback.invoke(Boolean.FALSE);
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            callback.invoke(Boolean.FALSE);
            return;
        }
        gcd gcd = this.O00000o0.get(str);
        if (!(gcd == null ? false : gcd.O0000O0o)) {
            O00000Oo(str, true);
            if (gcg == null || !gcg.O00000oo()) {
                O00000Oo(str, false);
                callback.invoke(Boolean.FALSE);
                return;
            }
            ((AbsRNVideoView) view).O000000o(new XmVideoViewGl.PhotoSnapCallback(str, gcg, currentActivity, str2, callback) {
                /* class _m_j.$$Lambda$gcf$ZZ3gqHzwIkm_onj9g7NZZ4QigjI */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ gcg f$2;
                private final /* synthetic */ Activity f$3;
                private final /* synthetic */ String f$4;
                private final /* synthetic */ Callback f$5;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                }

                public final void onSnap(Bitmap bitmap) {
                    gcf.this.O000000o(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, bitmap);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(String str, gcg gcg, Activity activity, String str2, Callback callback, Bitmap bitmap) {
        goq.O000000o(new Runnable(str, gcg, bitmap, activity, str2, callback) {
            /* class _m_j.$$Lambda$gcf$HjYRDk179gLN0XvngVqHWz_6c */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ gcg f$2;
            private final /* synthetic */ Bitmap f$3;
            private final /* synthetic */ Activity f$4;
            private final /* synthetic */ String f$5;
            private final /* synthetic */ Callback f$6;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
            }

            public final void run() {
                gcf.this.O000000o(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
            }
        });
    }

    private void O00000Oo(String str, boolean z) {
        gcd gcd = this.O00000o0.get(str);
        if (gcd == null) {
            gcd = new gcd();
            this.O00000o0.put(str, gcd);
        }
        gcd.O0000O0o = z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
     arg types: [int, java.lang.String]
     candidates:
      _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
    public static void O00000o0(String str, Callback callback) {
        ReactContext currentReactContext;
        if (callback != null) {
            ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
            if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "rncamera ReactInstanceManager is null, can not show alarm videos"));
                gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show alarm videos");
                return;
            }
            Activity currentActivity = currentReactContext.getCurrentActivity();
            if (currentActivity == null || currentActivity.isFinishing()) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "the activity to which the reactContext currently attached is null"));
                gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            } else if (mk.O000000o(currentActivity)) {
                CommonApplication.getGlobalHandler().postDelayed(new Runnable(str) {
                    /* class _m_j.$$Lambda$gcf$amGXHW_XSvHTO8e1X1tWZuqySbw */
                    private final /* synthetic */ String f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void run() {
                        XmPluginHostApi.instance().openCameraFloatingWindow(this.f$0);
                    }
                }, 500);
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) "start float window success"));
                currentActivity.finish();
            } else {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "the activity to which the reactContext currently attached is null"));
            }
        }
    }

    public final void O000000o(String str, VideoFrame videoFrame) {
        View view;
        boolean z;
        if (this.O00000Oo.get(str) != null && ((z = (view = this.O00000Oo.get(str)) instanceof AbsRNVideoView))) {
            DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(O000000o(str));
            if (deviceByDid == null) {
                gbu.O00000Oo("empty device stat");
                return;
            }
            cid O000000o2 = cid.O000000o(deviceByDid, str);
            if (O000000o2 != null && DeviceModelManager.getInstance().isHualaiCamera(O000000o2.getModel()) && z) {
                videoFrame.videoType = ((AbsRNVideoView) view).getVideoCodec();
            }
            gcd gcd = this.O00000o0.get(str);
            String str2 = null;
            int i = 0;
            if (gcd != null) {
                str2 = gcd.O0000o00;
                i = gcd.O0000o0;
            }
            gcg gcg = this.f17513O000000o.get(str);
            if (gcg != null && !TextUtils.isEmpty(str2)) {
                int O0000Oo0 = gcg.O0000Oo0();
                if (!(O0000Oo0 == i || gcd == null)) {
                    gcd.O0000o0 = O0000Oo0;
                }
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("currentMoveType", O0000Oo0);
                O000000o(createMap, str2);
            }
            ((AbsRNVideoView) view).O000000o(videoFrame);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gcf.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gcf.O000000o(android.net.Uri, android.content.ContentResolver):java.lang.String
      _m_j.gcf.O000000o(com.facebook.react.bridge.WritableMap, java.lang.String):void
      _m_j.gcf.O000000o(com.xiaomi.smarthome.device.api.DeviceStat, java.lang.String):void
      _m_j.gcf.O000000o(java.lang.String, com.facebook.react.bridge.Callback):void
      _m_j.gcf.O000000o(java.lang.String, java.lang.String):void
      _m_j.gcf.O000000o(java.lang.String, int):void
      _m_j.gcf.O000000o(java.lang.String, com.xiaomi.smarthome.camera.VideoFrame):void
      _m_j.gcf.O000000o(java.lang.String, byte[]):void
      _m_j.gcg.O000000o.O000000o(java.lang.String, int):void
      _m_j.gcg.O000000o.O000000o(java.lang.String, com.xiaomi.smarthome.camera.VideoFrame):void
      _m_j.gcg.O000000o.O000000o(java.lang.String, byte[]):void
      _m_j.gcf.O000000o(java.lang.String, boolean):void */
    public final void O000000o(String str, int i, int i2) {
        if (!O00000Oo(str) && i2 == -20009 && i == 0) {
            O000000o(str, true);
        }
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(O000000o(str));
        if (deviceByDid == null) {
            gbu.O00000Oo("empty device stat");
            return;
        }
        cid O000000o2 = cid.O000000o(deviceByDid, str);
        if (!O00000Oo(str) && i2 == -90 && O000000o2.deviceStat().isOnline) {
            O000000o2.O0000oo();
        }
        gbu.O00000o0("rncamera connectState changed ".concat(String.valueOf(i)));
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("state", i);
        createMap.putString("error", String.valueOf(i2));
        gcd gcd = this.O00000o0.get(str);
        O000000o(createMap, gcd == null ? "" : gcd.f17511O000000o);
    }

    public final boolean O00000o0(String str, int i) {
        gcd gcd = this.O00000o0.get(str);
        if (gcd == null) {
            return false;
        }
        List<Integer> list = gcd.O0000Ooo;
        String str2 = gcd.O0000OoO;
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str2) || !list.contains(Integer.valueOf(i))) {
            return false;
        }
        return true;
    }

    public final void O000000o(String str, byte[] bArr, int i, int i2) {
        String encodeToString = Base64.encodeToString(bArr, 2);
        gcd gcd = this.O00000o0.get(str);
        if (gcd != null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("ts", (double) i);
            createMap.putInt("tss", i2);
            createMap.putString("data", encodeToString);
            O000000o(createMap, gcd.O0000OoO);
        }
    }

    public final void O000000o(String str, int i) {
        long j = (long) i;
        WritableMap createMap = Arguments.createMap();
        createMap.putString("data", String.valueOf(j));
        gcd gcd = this.O00000o0.get(str);
        O000000o(createMap, gcd == null ? "" : gcd.O00000o);
    }

    public final void O000000o(String str, int i, byte[] bArr) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("command", String.valueOf(i));
        try {
            createMap.putString("data", new JSONObject(new String(bArr)).toString());
        } catch (Exception unused) {
            createMap.putString("data", Base64.encodeToString(bArr, 2));
        }
        gcd gcd = this.O00000o0.get(str);
        O000000o(createMap, gcd == null ? "" : gcd.O00000Oo);
    }

    public final void O00000oO(String str) {
        gcd gcd = this.O00000o0.get(str);
        O000000o(Arguments.createMap(), gcd == null ? "" : gcd.O0000OOo);
    }

    public final void O00000Oo(String str, int i) {
        gcd gcd = this.O00000o0.get(str);
        String str2 = gcd == null ? "" : gcd.O00000oo;
        WritableMap createMap = Arguments.createMap();
        createMap.putString("recordTime", String.valueOf(i));
        O000000o(createMap, str2);
    }

    public final void O000000o(String str, byte[] bArr) {
        WritableMap createMap = Arguments.createMap();
        try {
            String str2 = new String(bArr);
            new JSONObject(str2);
            createMap.putString("data", str2);
        } catch (Exception unused) {
            createMap.putString("data", Base64.encodeToString(bArr, 2));
        }
        gcd gcd = this.O00000o0.get(str);
        O000000o(createMap, gcd == null ? "" : gcd.O00000o0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gcf.O00000Oo(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gcf.O00000Oo(com.xiaomi.smarthome.device.api.DeviceStat, java.lang.String):void
      _m_j.gcf.O00000Oo(java.lang.String, com.facebook.react.bridge.Callback):void
      _m_j.gcf.O00000Oo(java.lang.String, int):void
      _m_j.gcg.O000000o.O00000Oo(java.lang.String, int):void
      _m_j.gcf.O00000Oo(java.lang.String, boolean):void */
    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|(3:20|21|22)(1:42)) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        O00000Oo(r3, false);
        r8.invoke(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r1 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0054, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f A[SYNTHETIC, Splitter:B:26:0x004f] */
    public /* synthetic */ void O000000o(String str, gcg gcg, Bitmap bitmap, Activity activity, String str2, Callback callback) {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str2) || bitmap == null) {
            O00000Oo(str, false);
            callback.invoke(Boolean.FALSE);
            return;
        }
        fkw.O00000o(str2);
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        if (bitmap != null) {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(str2);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        } else {
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        O00000Oo(str, false);
        callback.invoke(Boolean.TRUE);
    }
}

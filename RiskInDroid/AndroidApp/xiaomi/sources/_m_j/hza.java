package _m_j;

import android.app.Application;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.library.log.LogType;

public final class hza {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Handler f1007O000000o = new Handler(Looper.getMainLooper()) {
        /* class _m_j.hza.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 1005001) {
                try {
                    gsy.O00000o0(LogType.MIJIA_WIDGET, "zhudong_send", "sendRefreshWidgetBroadcast-msg_update_miui_widget");
                    hza.O000000o(message, "com.xiaomi.smarthome.miui.widget.refresh_widget");
                } catch (Exception unused) {
                }
            }
        }
    };

    public static void O000000o(Message message, String str) {
        try {
            Application application = (Application) message.obj;
            if (application != null && application.getBaseContext() != null) {
                if (O00000Oo(application)) {
                    Intent intent = new Intent(str);
                    intent.setComponent(new ComponentName(application.getPackageName(), "com.xiaomi.smarthome.miui.widget.MiJiaBigWidgetProvider"));
                    application.sendBroadcast(intent);
                }
                if (O00000o0(application)) {
                    Intent intent2 = new Intent(str);
                    intent2.setComponent(new ComponentName(application.getPackageName(), "com.xiaomi.smarthome.miui.widget.MiJiaMiddleWidgetProvider"));
                    application.sendBroadcast(intent2);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void O000000o(Application application) {
        try {
            if (O00000Oo(application) || O00000o0(application)) {
                f1007O000000o.removeMessages(1005001);
                Message obtainMessage = f1007O000000o.obtainMessage();
                obtainMessage.obj = application;
                obtainMessage.what = 1005001;
                f1007O000000o.sendMessageDelayed(obtainMessage, 800);
                return;
            }
            gsy.O00000o0(LogType.MIJIA_WIDGET, "zhudong_widgetUtils", "没有任何widget组件，不发送广播");
        } catch (Exception unused) {
        }
    }

    private static boolean O00000Oo(Application application) {
        try {
            if (AppWidgetManager.getInstance(application).getAppWidgetIds(new ComponentName(application.getPackageName(), "com.xiaomi.smarthome.miui.widget.MiJiaBigWidgetProvider")).length > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            gsy.O00000o0(LogType.MIJIA_WIDGET, "zhudong_containBigWidget_exception:", e.getMessage());
            return false;
        }
    }

    private static boolean O00000o0(Application application) {
        try {
            if (AppWidgetManager.getInstance(application).getAppWidgetIds(new ComponentName(application.getPackageName(), "com.xiaomi.smarthome.miui.widget.MiJiaMiddleWidgetProvider")).length > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            gsy.O00000o0(LogType.MIJIA_WIDGET, "zhudong_containMiddleWidget_exception:", e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, boolean):boolean
     arg types: [android.content.SharedPreferences, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, boolean):boolean */
    public static boolean O000000o(Context context) {
        if (context == null) {
            return false;
        }
        return gpy.O00000Oo(context.getSharedPreferences("pref_mijia_widget_provider", 0), "pref_key_is_first_launch", true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.SharedPreferences, java.lang.String, boolean):void
     arg types: [android.content.SharedPreferences, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String):long
      _m_j.gpy.O000000o(android.content.SharedPreferences, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.SharedPreferences, java.lang.String, boolean):void */
    public static void O00000Oo(Context context) {
        if (context != null) {
            gpy.O000000o(context.getSharedPreferences("pref_mijia_widget_provider", 0), "pref_key_is_first_launch", false);
        }
    }
}

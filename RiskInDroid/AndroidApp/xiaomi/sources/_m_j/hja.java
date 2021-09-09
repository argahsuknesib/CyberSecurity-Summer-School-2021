package _m_j;

import _m_j.hja;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.notify_permission.NotifySnakeBar;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/xiaomi/smarthome/notify_permission/NotifyOpenGuideHelper;", "", "()V", "Companion", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hja {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18973O000000o = new O000000o((byte) 0);
    public static NotifySnakeBar O00000Oo;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ'\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000f\"\u00020\u0004¢\u0006\u0002\u0010\u0010J'\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000f\"\u00020\u0004¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\nJ\b\u0010\u001e\u001a\u00020\nH\u0002J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010$\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/xiaomi/smarthome/notify_permission/NotifyOpenGuideHelper$Companion;", "", "()V", "IS_OPEN_GUIDE_SHOW", "", "SPFS_GUIDE", "TAG", "snakeBar", "Lcom/xiaomi/smarthome/notify_permission/NotifySnakeBar;", "areAppNotificationsEnable", "", "context", "Landroid/content/Context;", "areNotificationChannelsEnableAll", "channels", "", "(Landroid/content/Context;[Ljava/lang/String;)Z", "areNotificationChannelsEnableAny", "createTextViewAlignLeft", "Landroid/widget/TextView;", "dismissSnakeBar", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "isNotificationChannelEnableInvoked", "channel", "isNotifyOpenGuideHaveShown", "openNotificationSettingPage", "setNotifyOpenGuideHaveShown", "shown", "shouldShowGuide", "showDismissNotifySnakeBarDialog", "showGotoNotifySettingDialog", "showGotoNotifySettingDialogForSmart", "showOpenNotifyTutorialIfNeeded", "showSnakeBar", "switchToMySceneListAndShowGuideDialog", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        /* access modifiers changed from: private */
        public static final void O000000o(DialogInterface dialogInterface, int i) {
        }

        private O000000o() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.Boolean]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public static boolean O000000o() {
            Context appContext = CommonApplication.getAppContext();
            ixe.O00000Oo(appContext, "getAppContext()");
            ixe.O00000o(appContext, "context");
            if (!a.O000000o(appContext).O000000o()) {
                Context appContext2 = CommonApplication.getAppContext();
                ixe.O00000Oo(appContext2, "getAppContext()");
                boolean z = appContext2.getApplicationContext().getSharedPreferences("spfs_notify_open_guide", 0).getBoolean("is_open_guide_show", false);
                gsy.O00000Oo(LogType.GENERAL, "NotificationPermissionHelper", ixe.O000000o("isNotifyOpenGuideHaveShown: ", (Object) Boolean.valueOf(z)));
                if (!z) {
                    return true;
                }
            }
            return false;
        }

        public static void O000000o(FragmentActivity fragmentActivity) {
            ixe.O00000o(fragmentActivity, "activity");
            Context context = fragmentActivity;
            MLAlertDialog.Builder O000000o2 = new MLAlertDialog.Builder(context).O000000o((int) R.string.notify_dialog_message_open_title);
            TextView O00000Oo = O00000Oo(context);
            O00000Oo.setText((int) R.string.notify_dialog_message_open_body_samrt);
            iuh iuh = iuh.f1631O000000o;
            O000000o2.O000000o(O00000Oo).O000000o((int) R.string.notify_dialog_btn_open, new DialogInterface.OnClickListener() {
                /* class _m_j.$$Lambda$hja$O000000o$oY9_ytRLdIuSo0JUqaV0ScIzlig */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    hja.O000000o.O000000o(FragmentActivity.this, dialogInterface, i);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, $$Lambda$hja$O000000o$P3CQy8MTuTb7v9q8934dzttcg.INSTANCE).O000000o(false).O00000oo();
        }

        /* access modifiers changed from: private */
        public static final void O000000o(FragmentActivity fragmentActivity, DialogInterface dialogInterface, int i) {
            ixe.O00000o(fragmentActivity, "$activity");
            O000000o o000000o = hja.f18973O000000o;
            O00000Oo();
            O000000o o000000o2 = hja.f18973O000000o;
            O00000o(fragmentActivity);
        }

        public static void O00000Oo(FragmentActivity fragmentActivity) {
            ixe.O00000o(fragmentActivity, "activity");
            Context context = fragmentActivity;
            MLAlertDialog.Builder O000000o2 = new MLAlertDialog.Builder(context).O000000o((int) R.string.notify_dialog_message_open_title);
            TextView O00000Oo = O00000Oo(context);
            O00000Oo.setText((int) R.string.notify_dialog_message_open_body);
            iuh iuh = iuh.f1631O000000o;
            O000000o2.O000000o(O00000Oo).O000000o((int) R.string.notify_dialog_btn_open, new DialogInterface.OnClickListener() {
                /* class _m_j.$$Lambda$hja$O000000o$5WRXxITDXN7BkunzKqzJb080W9E */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    hja.O000000o.O00000Oo(FragmentActivity.this, dialogInterface, i);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class _m_j.$$Lambda$hja$O000000o$WxWiQixu5tSrktgKdDMD8sZRCmE */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    hja.O000000o.O00000o0(FragmentActivity.this, dialogInterface, i);
                }
            }).O000000o(false).O00000oo();
        }

        /* access modifiers changed from: private */
        public static final void O00000Oo(FragmentActivity fragmentActivity, DialogInterface dialogInterface, int i) {
            ixe.O00000o(fragmentActivity, "$activity");
            O000000o o000000o = hja.f18973O000000o;
            O00000Oo();
            O000000o o000000o2 = hja.f18973O000000o;
            O00000o(fragmentActivity);
        }

        /* access modifiers changed from: private */
        public static final void O00000o0(FragmentActivity fragmentActivity, DialogInterface dialogInterface, int i) {
            ixe.O00000o(fragmentActivity, "$activity");
            O000000o o000000o = hja.f18973O000000o;
            O00000o0(fragmentActivity);
        }

        private static TextView O00000Oo(Context context) {
            TextView textView = new TextView(context);
            int dimension = (int) context.getResources().getDimension(R.dimen.mj_dialog_common_padding);
            textView.setPadding(dimension, 0, dimension, 0);
            textView.setTextColor(context.getResources().getColor(R.color.mj_color_gray_normal));
            textView.setTextSize(13.0f);
            textView.setGravity(8388611);
            return textView;
        }

        private static void O00000o(FragmentActivity fragmentActivity) {
            ixe.O00000o(fragmentActivity, "activity");
            Intent intent = new Intent();
            if (Build.VERSION.SDK_INT >= 26) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", fragmentActivity.getPackageName());
            } else if (Build.VERSION.SDK_INT >= 21) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", fragmentActivity.getPackageName());
                intent.putExtra("app_uid", fragmentActivity.getApplicationInfo().uid);
            } else {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", fragmentActivity.getPackageName(), null));
            }
            intent.setFlags(268435456);
            try {
                fragmentActivity.startActivity(intent);
            } catch (Exception unused) {
                Context context = fragmentActivity;
                hte.O000000o(context, (int) R.string.failed);
                O00000Oo();
                O000000o(context);
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
        public static void O000000o(Context context) {
            ixe.O00000o(context, "context");
            context.getApplicationContext().getSharedPreferences("spfs_notify_open_guide", 0).edit().putBoolean("is_open_guide_show", true).apply();
            gsy.O00000Oo(LogType.GENERAL, "NotificationPermissionHelper", ixe.O000000o("setNotifyOpenGuideHaveShown: ", (Object) Boolean.TRUE));
        }

        static void O00000o0(FragmentActivity fragmentActivity) {
            if (hja.O00000Oo == null) {
                hja.O00000Oo = new NotifySnakeBar(fragmentActivity);
            }
            NotifySnakeBar notifySnakeBar = hja.O00000Oo;
            if (notifySnakeBar != null) {
                notifySnakeBar.e_();
            }
        }

        private static void O00000Oo() {
            NotifySnakeBar notifySnakeBar = hja.O00000Oo;
            if (notifySnakeBar != null) {
                notifySnakeBar.O00000Oo();
            }
            hja.O00000Oo = null;
        }
    }
}

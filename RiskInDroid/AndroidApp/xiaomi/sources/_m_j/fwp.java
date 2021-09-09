package _m_j;

import _m_j.fwp;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.lang.ref.WeakReference;
import java.util.List;

public final class fwp {

    public interface O000000o {
        void O000000o();

        void O00000Oo();

        void O00000o();

        void O00000o0();
    }

    public static boolean O000000o(final Activity activity, O000000o o000000o, String str, String... strArr) {
        if (fwq.O000000o(strArr)) {
            o000000o.O000000o();
            return true;
        }
        View inflate = LayoutInflater.from(activity).inflate((int) R.layout.permisson_request_dialog_view, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.subtitle1)).setText(str);
        new MLAlertDialog.Builder(activity).O000000o(inflate).O000000o(false).O00000Oo(false).O000000o((int) R.string.next, new DialogInterface.OnClickListener(activity, o000000o, strArr) {
            /* class _m_j.$$Lambda$fwp$RZVUfNqXktew0o6l0nxbLQcjSLA */
            private final /* synthetic */ Activity f$0;
            private final /* synthetic */ fwp.O000000o f$1;
            private final /* synthetic */ String[] f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                fwp.O000000o(this.f$0, this.f$1, this.f$2, dialogInterface, i);
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class _m_j.fwp.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                activity.finish();
            }
        }).O00000oo();
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(Activity activity, O000000o o000000o, String[] strArr, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        activity.getApplication().getResources().getString(R.string.permission_successfully);
        String string = activity.getApplication().getResources().getString(R.string.permission_failure);
        String string2 = activity.getApplication().getResources().getString(R.string.tips);
        String string3 = activity.getApplication().getResources().getString(R.string.permission_tips_camera_msg);
        WeakReference weakReference = new WeakReference(activity);
        ind.O00000Oo((Activity) weakReference.get()).O000000o(strArr).O000000o((inh) null).O000000o(new inc() {
            /* class _m_j.$$Lambda$fwp$fEo5PZjNeWqyjmFk8KGzOXVrHFM */

            public final void onAction(List list) {
                fwp.O000000o.this.O000000o();
            }
        }).O00000Oo(new inc(true, string, weakReference, string2, string3, o000000o) {
            /* class _m_j.$$Lambda$fwp$DdVH9IVvz1aFtH5_uPENcapDjk */
            private final /* synthetic */ boolean f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ WeakReference f$2;
            private final /* synthetic */ String f$3;
            private final /* synthetic */ String f$4;
            private final /* synthetic */ fwp.O000000o f$5;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void onAction(List list) {
                fwp.O000000o(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, list);
            }
        }).O000000o();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(boolean z, String str, WeakReference weakReference, String str2, String str3, O000000o o000000o, List list) {
        if (!z) {
            gqg.O00000Oo(str);
            return;
        }
        Activity activity = (Activity) weakReference.get();
        if (activity != null && !activity.isFinishing() && Build.VERSION.SDK_INT >= 17 && !activity.isDestroyed()) {
            if (ind.O000000o(activity, list)) {
                String format = String.format(str3, TextUtils.join("\n", ing.O000000o(activity, list)));
                inj O000000o2 = ind.O000000o(activity);
                new MLAlertDialog.Builder(activity).O000000o(false).O000000o(str2).O00000Oo(format).O000000o((int) R.string.setting, new DialogInterface.OnClickListener(o000000o) {
                    /* class _m_j.$$Lambda$fwp$I5sFPp_49bY3T6ouNUz0UvN950 */
                    private final /* synthetic */ fwp.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        fwp.O00000Oo(inj.this, this.f$1, dialogInterface, i);
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener(o000000o) {
                    /* class _m_j.$$Lambda$fwp$ZUQkHRVrSXprDQ2Gc2fOyNb6OQ */
                    private final /* synthetic */ fwp.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$1.O00000o0();
                    }
                }).O00000o().show();
                return;
            }
            gqg.O00000Oo(str);
            o000000o.O00000Oo();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000Oo(inj inj, O000000o o000000o, DialogInterface dialogInterface, int i) {
        inj.O00000Oo();
        o000000o.O00000o();
    }
}

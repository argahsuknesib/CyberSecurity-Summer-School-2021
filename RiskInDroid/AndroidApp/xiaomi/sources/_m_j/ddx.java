package _m_j;

import _m_j.ddt;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.smarthome.uwb.ui.manager.UwbPermissionDialog$showUwbPermissionDialog$showDialog$4;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/smarthome/uwb/ui/manager/UwbPermissionDialog;", "", "()V", "showUwbPermissionDialog", "", "context", "Landroid/app/Activity;", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ddx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ddx f14529O000000o = new ddx();

    private ddx() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private static final iwc<Integer, iuh> O000000o(Activity activity, int i) {
        hxi.O0000o00.O000000o();
        Context context = activity;
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context);
        builder.O000000o(activity.getString(R.string.uwb_permit_dialog_title));
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.uwb_permit_dialog_layout, (ViewGroup) null, false);
        View findViewById = inflate.findViewById(R.id.permit_group_home);
        View findViewById2 = inflate.findViewById(R.id.permit_group_all);
        findViewById.setOnClickListener(new View.OnClickListener(findViewById, findViewById2) {
            /* class _m_j.$$Lambda$ddx$95Qz20y821gu8lFHPIsaybzzs */
            private final /* synthetic */ View f$0;
            private final /* synthetic */ View f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ddx.O000000o(this.f$0, this.f$1, view);
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener(findViewById, findViewById2) {
            /* class _m_j.$$Lambda$ddx$zjBQMOHhiKf3TlRaMbF2kr51NT4 */
            private final /* synthetic */ View f$0;
            private final /* synthetic */ View f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ddx.O00000Oo(this.f$0, this.f$1, view);
            }
        });
        if (i == 1) {
            findViewById.performClick();
        } else {
            findViewById2.performClick();
        }
        builder.O000000o(inflate);
        builder.O00000Oo(17039360, (DialogInterface.OnClickListener) null);
        builder.O000000o((int) R.string.confirm, new DialogInterface.OnClickListener(findViewById) {
            /* class _m_j.$$Lambda$ddx$4dTpB01haA9QuPP5UtNwE0RXqM */
            private final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                ddx.O000000o(this.f$0, dialogInterface, i);
            }
        });
        builder.O00000oo();
        return new UwbPermissionDialog$showUwbPermissionDialog$showDialog$4(findViewById, findViewById2);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(View view, View view2, View view3) {
        hxi.O00000o.f952O000000o.O000000o("uwb_click_permit_same_home", new Object[0]);
        view.setSelected(true);
        view2.setSelected(false);
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(View view, View view2, View view3) {
        hxi.O00000o.f952O000000o.O000000o("uwb_click_permit_all", new Object[0]);
        view.setSelected(false);
        view2.setSelected(true);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(View view, DialogInterface dialogInterface, int i) {
        ixe.O00000o(dialogInterface, "dialog");
        Set<String> O00000o0 = hzq.O00000o0();
        ddt.O000000o o000000o = ddt.O000000o.f14519O000000o;
        boolean isSelected = view.isSelected();
        ixe.O00000Oo(O00000o0, "tagIds");
        ddt.O000000o.O000000o(isSelected ? 1 : 0, O00000o0).subscribe($$Lambda$ddx$d986f8XRmi17iljUJxM_vdv4.INSTANCE, $$Lambda$ddx$S7nGIHnsbEy8LqErnzFYYDf40.INSTANCE);
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Boolean bool) {
        gqg.O00000Oo((int) R.string.action_success);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Throwable th) {
        gqg.O00000Oo((int) R.string.action_fail);
    }

    @SuppressLint({"CheckResult"})
    public static void O000000o(Activity activity) {
        ixe.O00000o(activity, "context");
        ddt.O000000o o000000o = ddt.O000000o.f14519O000000o;
        int O000000o2 = ddt.O000000o.O000000o();
        if (O000000o2 != -1) {
            iwc<Integer, iuh> O000000o3 = O000000o(activity, O000000o2);
            ddt.O000000o o000000o2 = ddt.O000000o.f14519O000000o;
            ddt.O000000o.O00000Oo().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(activity, O000000o3) {
                /* class _m_j.$$Lambda$ddx$rEmwyt7VbXl0Za1ghTNXgyzvNys */
                private final /* synthetic */ Activity f$0;
                private final /* synthetic */ iwc f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void accept(Object obj) {
                    ddx.O000000o(this.f$0, this.f$1, (Integer) obj);
                }
            }, $$Lambda$ddx$sdCvMu1USg4FC_4VICiYoTawjEI.INSTANCE);
            return;
        }
        ddt.O000000o o000000o3 = ddt.O000000o.f14519O000000o;
        ddt.O000000o.O00000Oo().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(activity) {
            /* class _m_j.$$Lambda$ddx$2ZXlKZnF_KVVHrnoY7hm2ZLbTk */
            private final /* synthetic */ Activity f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                ddx.O000000o(this.f$0, (Integer) obj);
            }
        }, $$Lambda$ddx$KIyBjabIv70mt7ixu65i4M0EQK4.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Activity activity, iwc iwc, Integer num) {
        ixe.O00000o(activity, "$context");
        ixe.O00000o(iwc, "$handler");
        if (!activity.isDestroyed()) {
            ixe.O00000Oo(num, "permit");
            iwc.invoke(num);
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(Throwable th) {
        gqg.O00000Oo((int) R.string.action_fail);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Activity activity, Integer num) {
        ixe.O00000o(activity, "$context");
        if (!activity.isDestroyed()) {
            ixe.O00000Oo(num, "permit");
            O000000o(activity, num.intValue());
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000o0(Throwable th) {
        gqg.O00000Oo((int) R.string.action_fail);
    }
}

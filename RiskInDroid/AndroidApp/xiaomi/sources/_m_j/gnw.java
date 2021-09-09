package _m_j;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;

public final class gnw extends DialogFragment {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f18062O000000o;

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        dismiss();
    }

    public final void onStart() {
        super.onStart();
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (getActivity() != null) {
            View inflate = LayoutInflater.from(CommonApplication.getAppContext()).inflate((int) R.layout.mj_float_feed_back_dialog, (ViewGroup) null);
            this.f18062O000000o = inflate.findViewById(R.id.ll_root);
            ((TextView) inflate.findViewById(R.id.tv_dialog_feed_back)).setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gnw.AnonymousClass1 */

                public final void onClick(View view) {
                    try {
                        hxi.O00000o.f952O000000o.O000000o("feedback_shortcut_feedback_click", new Object[0]);
                        gnw.this.getContext().sendBroadcast(new Intent("action_go_feed_back_activity"));
                        gnw.this.dismiss();
                    } catch (Exception unused) {
                    }
                }
            });
            ((TextView) inflate.findViewById(R.id.tv_close_float)).setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gnw.AnonymousClass2 */

                public final void onClick(View view) {
                    try {
                        hxi.O00000o.f952O000000o.O000000o("feedback_shortcut_turnoff_feature_click", new Object[0]);
                        new gnv().show(gnw.this.getActivity().getFragmentManager(), "ConfirmCloseFloatDialog");
                        gnw.this.dismiss();
                    } catch (Exception unused) {
                    }
                }
            });
            ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
                /* class _m_j.$$Lambda$gnw$085OVdJzOCViCg_rwv8KbLYbJ58 */

                public final void onClick(View view) {
                    gnw.this.O000000o(view);
                }
            });
            builder.setView(inflate);
        }
        setCancelable(true);
        AlertDialog create = builder.create();
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (hyy.O000000o()) {
                this.f18062O000000o.setBackgroundResource(R.drawable.mj_float_center_dialog_bg);
                window.setGravity(17);
            } else {
                this.f18062O000000o.setBackgroundResource(R.drawable.mj_float_common_dialog_bg);
                window.setGravity(80);
            }
        }
        return create;
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public final void onResume() {
        Window window = getDialog().getWindow();
        if (hyy.O000000o()) {
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = gnx.O000000o(getActivity());
            attributes.height = -2;
            window.setAttributes(attributes);
        } else {
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            attributes2.width = -1;
            attributes2.height = -2;
            window.setAttributes(attributes2);
        }
        super.onResume();
    }

    public final void show(FragmentManager fragmentManager, String str) {
        try {
            hxi.O00000oO.f958O000000o.O000000o("feedback_shortcut_show", new Object[0]);
            super.show(fragmentManager, str);
        } catch (Exception unused) {
        }
    }
}

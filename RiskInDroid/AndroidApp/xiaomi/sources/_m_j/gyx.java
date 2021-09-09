package _m_j;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class gyx extends dz {

    /* renamed from: O000000o  reason: collision with root package name */
    public Runnable f18604O000000o = null;
    public boolean O00000Oo = false;

    public final void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (getActivity() != null) {
            View inflate = getActivity().getLayoutInflater().inflate((int) R.layout.dialog_main_connect_login, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.common_bottom_tv);
            textView.setText((int) R.string.sendprint_gologin);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gyx.AnonymousClass1 */

                public final void onClick(View view) {
                    if (gyx.this.f18604O000000o != null) {
                        gyx.this.f18604O000000o.run();
                    }
                    gyx gyx = gyx.this;
                    gyx.O00000Oo = true;
                    gyx.dismiss();
                }
            });
            builder.setView(inflate);
        }
        setCancelable(true);
        AlertDialog create = builder.create();
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.mj_color_black_00_transparent);
        }
        return create;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (getActivity() != null && !getActivity().isFinishing() && !this.O00000Oo) {
            getActivity().finish();
        }
    }
}

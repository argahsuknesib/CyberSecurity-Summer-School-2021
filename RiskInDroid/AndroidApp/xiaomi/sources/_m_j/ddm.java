package _m_j;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class ddm extends dz {

    /* renamed from: O000000o  reason: collision with root package name */
    public Runnable f14500O000000o = null;

    public final void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = gpc.O000000o(218.3f);
            window.setAttributes(attributes);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (getActivity() != null) {
            View inflate = getActivity().getLayoutInflater().inflate((int) R.layout.miconnect_confirm_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.common_tile_tv)).setText((int) R.string.miconnect_exit_confirm_title);
            ((TextView) inflate.findViewById(R.id.cancel_exit)).setOnClickListener(new View.OnClickListener() {
                /* class _m_j.ddm.AnonymousClass1 */

                public final void onClick(View view) {
                    ddm.this.dismiss();
                }
            });
            ((TextView) inflate.findViewById(R.id.confirm_exit)).setOnClickListener(new View.OnClickListener() {
                /* class _m_j.ddm.AnonymousClass2 */

                public final void onClick(View view) {
                    ddm.this.dismiss();
                    if (ddm.this.f14500O000000o != null) {
                        ddm.this.f14500O000000o.run();
                    }
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
}

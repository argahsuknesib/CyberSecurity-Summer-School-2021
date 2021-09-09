package _m_j;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class hab extends dz {

    /* renamed from: O000000o  reason: collision with root package name */
    public View.OnClickListener f18684O000000o;
    public View.OnClickListener O00000Oo;

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
            View inflate = getActivity().getLayoutInflater().inflate((int) R.layout.dialog_mainconnect_ignore_confirm, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.common_tile_tv)).setText((int) R.string.main_connect_ignore_top);
            ((TextView) inflate.findViewById(R.id.cancel_exit)).setOnClickListener(this.f18684O000000o);
            ((TextView) inflate.findViewById(R.id.confirm_exit)).setOnClickListener(this.O00000Oo);
            builder.setView(inflate);
        }
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        create.setOnKeyListener(new DialogInterface.OnKeyListener() {
            /* class _m_j.hab.AnonymousClass1 */

            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || hab.this.f18684O000000o == null) {
                    return true;
                }
                hab.this.f18684O000000o.onClick(null);
                return true;
            }
        });
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.mj_color_black_00_transparent);
        }
        return create;
    }
}

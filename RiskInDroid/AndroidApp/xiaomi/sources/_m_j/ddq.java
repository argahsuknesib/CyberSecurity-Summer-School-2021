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

public final class ddq extends dz {

    /* renamed from: O000000o  reason: collision with root package name */
    public Runnable f14512O000000o;
    private TextView O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;

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
            View inflate = getActivity().getLayoutInflater().inflate((int) R.layout.miconnect_no_wifi_dialog, (ViewGroup) null);
            this.O00000o0 = (TextView) inflate.findViewById(R.id.content);
            this.O00000o0.setText((int) R.string.miconnect_ble_no_data_network);
            this.O00000Oo = (TextView) inflate.findViewById(R.id.common_tile_tv);
            this.O00000Oo.setText((int) R.string.miconnect_ble_no_data_network_tip);
            this.O00000o = (TextView) inflate.findViewById(R.id.common_bottom_tv);
            this.O00000o.setText((int) R.string.miconnect_ble_no_data_network_to_settting);
            this.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.ddq.AnonymousClass1 */

                public final void onClick(View view) {
                    if (ddq.this.f14512O000000o != null) {
                        ddq.this.f14512O000000o.run();
                    }
                    ddq.this.dismiss();
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
        if (getActivity() != null && !getActivity().isFinishing()) {
            getActivity().finish();
        }
    }
}

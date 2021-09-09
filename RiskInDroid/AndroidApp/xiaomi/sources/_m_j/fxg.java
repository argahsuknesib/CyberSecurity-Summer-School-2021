package _m_j;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class fxg extends dz {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f17368O000000o;
    public int O00000Oo;
    private TextView O00000o;
    public O000000o O00000o0;
    private Button O00000oO;
    private Button O00000oo;

    public interface O000000o {
        void O000000o();

        void O000000o(int i);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (getActivity() != null) {
            View inflate = getActivity().getLayoutInflater().inflate((int) R.layout.dialog_wearables_common, (ViewGroup) null);
            this.O00000o = (TextView) inflate.findViewById(R.id.tv_dialog_message);
            this.O00000oO = (Button) inflate.findViewById(R.id.btn_dialog_left);
            this.O00000oo = (Button) inflate.findViewById(R.id.btn_dialog_right);
            this.O00000oO.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.fxg.AnonymousClass1 */

                public final void onClick(View view) {
                    if (fxg.this.O00000o0 != null) {
                        fxg.this.O00000o0.O000000o();
                    }
                }
            });
            this.O00000oo.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.fxg.AnonymousClass2 */

                public final void onClick(View view) {
                    if (fxg.this.O00000o0 != null) {
                        fxg.this.O00000o0.O000000o(fxg.this.f17368O000000o);
                    }
                }
            });
            builder.setView(inflate);
        }
        setCancelable(false);
        AlertDialog create = builder.create();
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        return create;
    }

    public final void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
        }
        int i = this.f17368O000000o;
        int i2 = this.O00000Oo;
        if (i == 1) {
            this.O00000o.setText((int) R.string.rn_wearables_unlogin_mijia);
            this.O00000oO.setText((int) R.string.rn_wearables_cancel);
            this.O00000oo.setText((int) R.string.rn_wearables_login);
        } else if (i == 2) {
            this.O00000o.setText((int) R.string.rn_wearables_account_not_same_no_device);
            this.O00000oO.setText((int) R.string.rn_wearables_cancel);
            this.O00000oo.setText((int) R.string.rn_wearables_back_to_wear_app);
        } else if (i == 3) {
            this.O00000o.setText(getString(R.string.rn_wearables_account_not_same_have_device, Integer.valueOf(i2)));
            this.O00000oO.setText((int) R.string.rn_wearables_cancel);
            this.O00000oo.setText((int) R.string.rn_wearables_continue);
        } else if (i == 4) {
            this.O00000o.setText((int) R.string.rn_wearables_current_account_no_lock_device);
            this.O00000oO.setText((int) R.string.rn_wearables_cancel);
            this.O00000oo.setText((int) R.string.rn_wearables_back_to_wear_app);
        }
    }
}

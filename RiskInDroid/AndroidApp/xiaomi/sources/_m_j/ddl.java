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

public final class ddl extends dz {

    /* renamed from: O000000o  reason: collision with root package name */
    public View.OnClickListener f14499O000000o = null;

    public final void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = gpc.O000000o(240.0f);
            window.setAttributes(attributes);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (getActivity() != null) {
            View inflate = getActivity().getLayoutInflater().inflate((int) R.layout.miconnect_region_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.common_tile_tv)).setText((int) R.string.miconnect_check_region_title);
            TextView textView = (TextView) inflate.findViewById(R.id.common_bottom_tv);
            textView.setText((int) R.string.miconnect_see_it_in_mijia);
            textView.setOnClickListener(this.f14499O000000o);
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

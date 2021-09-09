package _m_j;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;

public final class ddk extends dz {

    /* renamed from: O000000o  reason: collision with root package name */
    public View.OnClickListener f14498O000000o = null;
    public String O00000Oo;

    public final void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (getActivity() != null) {
            View inflate = getActivity().getLayoutInflater().inflate((int) R.layout.miconnect_ap_failed_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.common_bottom_tv);
            textView.setText((int) R.string.miui_connect_retry);
            textView.setOnClickListener(this.f14498O000000o);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_fail_hint);
            String string = getString(R.string.kuailian_connect_fail_reason_content);
            if (!TextUtils.isEmpty(this.O00000Oo) && DeviceFactory.O00000Oo(this.O00000Oo)) {
                string = string.substring(0, string.lastIndexOf("\n"));
            }
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(this.O00000Oo);
            if (O00000oO != null && O00000oO.O00000o() == 23) {
                string = string + getString(R.string.moxiang_camera_connect_fail_reason);
            }
            textView2.setText(string);
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

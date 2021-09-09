package _m_j;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.listcamera.adapter.CameraLargeAdapter;

public final class gtm extends CameraLargeAdapter.O000000o {
    public View O00000Oo;
    public TextView O00000o;
    public TextView O00000o0;
    private LayoutInflater O00000oO;
    private LinearLayout O00000oo;

    public gtm(View view) {
        super(view, CameraLargeAdapter.ViewType.CHILD_OPERATION);
        this.O00000oO = LayoutInflater.from(view.getContext());
        this.O00000oo = (LinearLayout) view.findViewById(R.id.deivce_control_container);
        this.O00000Oo = view.findViewById(R.id.device_info_container);
        this.O00000o0 = (TextView) view.findViewById(R.id.button_title);
        this.O00000o = (TextView) view.findViewById(R.id.button_desc);
    }
}

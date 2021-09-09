package _m_j;

import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class exd {

    /* renamed from: O000000o  reason: collision with root package name */
    public TextView f15913O000000o = ((TextView) this.O0000O0o.findViewById(R.id.viewhelper_brief));
    public TextView O00000Oo;
    public TextView O00000o;
    public TextView O00000o0;
    public TextView O00000oO;
    public TextView O00000oo = ((TextView) this.O0000O0o.findViewById(R.id.viewhelper_title));
    private View O0000O0o;

    public exd(View view) {
        this.O0000O0o = view.findViewById(R.id.viewhelper_vertical_content_root);
        TextView textView = (TextView) this.O0000O0o.findViewById(R.id.tv_viewhelper_price);
        this.O00000o0 = textView;
        textView.setTag(67108864, Boolean.TRUE);
        this.O00000oO = (TextView) this.O0000O0o.findViewById(R.id.tv_viewhelper_price_qi);
        this.O00000o = (TextView) this.O0000O0o.findViewById(R.id.tv_viewhelper_marketprice);
        this.O00000Oo = (TextView) this.O0000O0o.findViewById(R.id.tv_btnTxt);
        this.O0000O0o.setMinimumHeight(dul.O000000o(view.getContext(), 114.0f));
    }
}

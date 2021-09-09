package _m_j;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class ewy {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f15907O000000o;
    private TextView O00000Oo;
    private TextView O00000o;
    private TextView O00000o0 = ((TextView) this.f15907O000000o.findViewById(R.id.viewhelper_small_tp_title));
    private TextView O00000oO;
    private Context O00000oo;

    public ewy(View view) {
        this.f15907O000000o = view.findViewById(R.id.viewhelper_small_tp_rootview);
        View findViewById = this.f15907O000000o.findViewById(R.id.layout_viewhelper_small_tp_price);
        TextView textView = (TextView) findViewById.findViewById(R.id.tv_viewhelper_price);
        this.O00000o = textView;
        textView.setTag(67108864, Boolean.TRUE);
        this.O00000oO = (TextView) findViewById.findViewById(R.id.tv_viewhelper_price_qi);
        this.O00000Oo = (TextView) findViewById.findViewById(R.id.tv_viewhelper_marketprice);
        dun.O000000o(this.O00000oo, this.O00000o);
        dun.O000000o(this.O00000oo, this.O00000Oo);
        this.O00000oo = this.O00000oo;
    }
}

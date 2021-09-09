package _m_j;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class ewx {

    /* renamed from: O000000o  reason: collision with root package name */
    public RelativeLayout f15906O000000o;
    public RelativeLayout O00000Oo;
    public TextView O00000o = ((TextView) this.O00000o0.findViewById(R.id.viewhelper_big_tcp_brif));
    public View O00000o0;
    public TextView O00000oO;
    public TextView O00000oo;
    public TextView O0000O0o = ((TextView) this.O00000o0.findViewById(R.id.viewhelper_big_tcp_title));
    public TextView O0000OOo;
    public TextView O0000Oo;
    public TextView O0000Oo0;
    public TextView O0000OoO;
    private Context O0000Ooo;

    public ewx(View view, Context context) {
        this.O00000o0 = view.findViewById(R.id.viewhelper_big_tcp_root);
        TextView textView = (TextView) this.O00000o0.findViewById(R.id.viewhelper_big_tcp_price_txt_bottom);
        this.O0000OOo = textView;
        textView.setTag(67108864, Boolean.TRUE);
        this.O0000Oo0 = (TextView) this.O00000o0.findViewById(R.id.viewhelper_big_tcp_price_qi_bottom);
        this.O00000oO = (TextView) this.O00000o0.findViewById(R.id.viewhelper_big_tcp_marketprice_txt_bottom);
        this.f15906O000000o = (RelativeLayout) this.O00000o0.findViewById(R.id.viewhelper_big_tcp_price_layout_bottom);
        this.O0000OoO = (TextView) this.O00000o0.findViewById(R.id.viewhelper_big_tcp_price_txt_right);
        this.O0000Oo = (TextView) this.O00000o0.findViewById(R.id.viewhelper_big_tcp_price_qi_right);
        this.O00000oo = (TextView) this.O00000o0.findViewById(R.id.viewhelper_big_tcp_marketprice_txt_right);
        this.O00000Oo = (RelativeLayout) this.O00000o0.findViewById(R.id.viewhelper_big_tcp_price_layout_right);
        dun.O000000o(this.O0000Ooo, this.O0000OOo);
        dun.O000000o(this.O0000Ooo, this.O00000oO);
        dun.O000000o(this.O0000Ooo, this.O0000OoO);
        dun.O000000o(this.O0000Ooo, this.O00000oo);
        this.O0000Ooo = context;
    }
}

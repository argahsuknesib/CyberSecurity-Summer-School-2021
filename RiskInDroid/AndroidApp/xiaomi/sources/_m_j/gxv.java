package _m_j;

import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class gxv extends gxr {
    public TextView O00000Oo;
    public TextView O00000o;
    public TextView O00000o0;

    public gxv(View view) {
        super(view);
        this.O00000Oo = (TextView) view.findViewById(R.id.day);
        this.O00000o0 = (TextView) view.findViewById(R.id.month);
        this.O00000o = (TextView) view.findViewById(R.id.weekday);
    }
}

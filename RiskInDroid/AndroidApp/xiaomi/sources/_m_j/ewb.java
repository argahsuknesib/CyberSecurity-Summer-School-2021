package _m_j;

import _m_j.ewr;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.List;

public final class ewb extends euk<ewr, vr> {
    private ImageView O00000o;
    private CustomTextView O00000o0;

    public final int O000000o() {
        return 5;
    }

    public final int O00000Oo() {
        return R.layout.title_view;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        ewr ewr = (ewr) obj;
        View view = vrVar.itemView;
        this.O00000o = (ImageView) view.findViewById(R.id.iv_bg);
        if (!TextUtils.isEmpty(ewr.O0000O0o)) {
            duh.O000000o().O000000o(ewr.O0000O0o, this.O00000o);
        }
        this.O00000o0 = (CustomTextView) view.findViewById(R.id.titleText);
        List<ewr.O000000o> list = ewr.O0000oo0;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(list.get(0).O00000o)) {
            this.O00000o0.setText("");
        } else {
            this.O00000o0.setText(list.get(0).O00000o);
        }
        if (!TextUtils.isEmpty(ewr.O0000Oo0)) {
            this.O00000o0.setTextColor(Color.parseColor(ewr.O0000Oo0));
        }
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewr) obj, i);
    }
}

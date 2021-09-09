package _m_j;

import android.content.Context;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import java.util.List;

public final class gin extends eza<gir> {
    public final int O000000o() {
        return R.layout.item_ir_matching_device;
    }

    public final /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
        gir gir = (gir) obj;
        ezc.O000000o(R.id.ir_matching_device_type_text, this.f15967O000000o.getResources().getString(gir.O00000Oo));
        ((ImageView) ezc.O000000o((int) R.id.ir_matching_device_type_icon)).setImageResource(gir.O00000o0);
    }

    public gin(Context context, List<gir> list) {
        super(context, list);
    }
}

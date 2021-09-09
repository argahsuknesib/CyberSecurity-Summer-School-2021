package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.infrared.bean.IRSTBData;
import java.util.List;

public final class gip extends eza<IRSTBData> {
    public final int O000000o() {
        return R.layout.item_ir_select_stb_center;
    }

    public final /* bridge */ /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
        ezc.O000000o(R.id.ir_select_stb_brand_text, ((IRSTBData) obj).O00000oO);
    }

    public gip(Context context, List<IRSTBData> list) {
        super(context, list);
    }
}

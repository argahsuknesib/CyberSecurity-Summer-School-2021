package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.infrared.bean.NameIdEntity;
import java.util.List;

public final class gio extends eza<NameIdEntity> {
    public final int O000000o() {
        return R.layout.item_ir_select_brand;
    }

    public final /* bridge */ /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
        ezc.O000000o(R.id.ir_select_tv_brand_text, ((NameIdEntity) obj).O00000Oo);
    }

    public gio(Context context, List<NameIdEntity> list) {
        super(context, list);
    }
}

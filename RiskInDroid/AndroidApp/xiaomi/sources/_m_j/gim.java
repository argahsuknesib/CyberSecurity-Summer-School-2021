package _m_j;

import android.content.Context;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.infrared.bean.IRBrandType;
import java.util.List;

public final class gim extends eza<IRBrandType> {
    private final boolean O00000o0 = ftl.O00000Oo();

    public final int O000000o() {
        return R.layout.item_ir_select_brand_title;
    }

    public final /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
        String str;
        IRBrandType iRBrandType = (IRBrandType) obj;
        ezc.O000000o(R.id.ir_select_tv_brand_text, iRBrandType.f9036O000000o);
        View O000000o2 = ezc.O000000o((int) R.id.brand_title_root);
        if (this.O00000o0) {
            str = iRBrandType.f9036O000000o;
        } else {
            str = iRBrandType.O00000o;
        }
        char charAt = iRBrandType.O00000oO.charAt(0);
        gsy.O000000o(3, "IRMatchingBrandAdapter", "convert: " + this.O00000o0 + " mBrandName  " + str);
        if (O000000o(charAt) == i) {
            O000000o2.setVisibility(0);
            ezc.O000000o(R.id.ir_select_tv_brand_position_text, iRBrandType.O00000oO);
            ezc.O000000o(R.id.ir_select_tv_brand_text, str);
            return;
        }
        O000000o2.setVisibility(8);
        ezc.O000000o(R.id.ir_select_tv_brand_text, str);
    }

    public gim(Context context, List<IRBrandType> list) {
        super(context, list);
    }

    public final int O000000o(int i) {
        for (int i2 = 0; i2 < getCount(); i2++) {
            if (((IRBrandType) this.O00000Oo.get(i2)).O00000oO.toUpperCase().charAt(0) == i) {
                return i2;
            }
        }
        return -1;
    }
}

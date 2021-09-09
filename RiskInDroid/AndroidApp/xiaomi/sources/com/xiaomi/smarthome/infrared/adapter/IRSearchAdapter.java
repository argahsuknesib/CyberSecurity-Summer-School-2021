package com.xiaomi.smarthome.infrared.adapter;

import _m_j.eza;
import _m_j.ezc;
import _m_j.ftl;
import android.content.Context;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.infrared.bean.IRBrandType;

public final class IRSearchAdapter extends eza<IRBrandType> {
    private final boolean O00000o0 = ftl.O00000Oo();

    public final int O000000o() {
        return R.layout.item_ir_select_brand;
    }

    public final /* bridge */ /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
        String str;
        IRBrandType iRBrandType = (IRBrandType) obj;
        if (this.O00000o0) {
            str = iRBrandType.f9036O000000o;
        } else {
            str = iRBrandType.O00000o;
        }
        ezc.O000000o(R.id.ir_select_tv_brand_text, str);
    }

    public IRSearchAdapter(Context context) {
        super(context, null);
    }
}

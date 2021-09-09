package com.xiaomi.smarthome.miui.widget;

import _m_j.gpn;
import _m_j.gyy;
import _m_j.gyz;
import _m_j.gza;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import java.util.List;

public class MiJiaMiddleWidgetProvider extends MiJiaWidgetProvider {
    public final String O000000o() {
        return "zhudong_middle";
    }

    public final int O00000Oo() {
        return 0;
    }

    public final int O00000o0() {
        return 4;
    }

    public final int O000000o(List<GridViewData> list) {
        return gpn.O00000Oo(list) <= 2 ? R.layout.mijia_app_widget_max_two_layout : R.layout.mijia_app_widget_normal_layout;
    }

    public final gza O00000Oo(List<GridViewData> list) {
        if (gpn.O00000Oo(list) <= 2) {
            return gyy.O000000o();
        }
        return gyz.O000000o();
    }
}

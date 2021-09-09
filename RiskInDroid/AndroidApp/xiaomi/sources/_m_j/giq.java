package _m_j;

import android.content.Context;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.infrared.bean.IRKeyValue;
import com.xiaomi.smarthome.infrared.bean.IRType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class giq extends ezb<IRKeyValue> {
    protected Map<String, IRKeyValue> O0000OOo = new LinkedHashMap();
    private IRType O0000Oo0;

    public final int O00000o0(int i) {
        return R.layout.study_key_item;
    }

    public final /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
        IRKeyValue iRKeyValue = (IRKeyValue) obj;
        TextView textView = (TextView) ezc.O000000o((int) R.id.ir_study_text_btn);
        ezc.O000000o(R.id.ir_study_text_btn, gjd.O000000o(iRKeyValue));
        if (this.O0000Oo0 == IRType.Unknown) {
            return;
        }
        if (this.O0000OOo.containsKey(iRKeyValue.O00000o)) {
            textView.setSelected(true);
            textView.setTextColor(this.f15968O000000o.getResources().getColor(R.color.mj_color_green_normal));
            return;
        }
        textView.setSelected(false);
        textView.setTextColor(this.f15968O000000o.getResources().getColor(R.color.mj_color_black));
    }

    public giq(Context context, List<IRKeyValue> list, Map<String, IRKeyValue> map, IRType iRType) {
        super(context, list);
        this.O0000OOo = map;
        this.O0000Oo0 = iRType;
    }
}

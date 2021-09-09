package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.infrared.bean.NameIdEntity;
import com.xiaomi.smarthome.infrared.utils.CharacterParser;
import java.util.List;

public final class gil extends eza<NameIdEntity> {
    public final int O000000o() {
        return R.layout.item_ir_select_brand;
    }

    public final /* bridge */ /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
        ezc.O000000o(R.id.ir_select_tv_brand_text, ((NameIdEntity) obj).O00000Oo);
    }

    public gil(Context context, List<NameIdEntity> list) {
        super(context, list);
    }

    public final int O000000o(int i) {
        for (int i2 = 0; i2 < getCount(); i2++) {
            String upperCase = CharacterParser.O000000o().O000000o(((NameIdEntity) this.O00000Oo.get(i2)).O00000Oo).substring(0, 1).toUpperCase();
            if ((upperCase.matches("[A-Z]") ? upperCase.toUpperCase() : "#").toUpperCase().charAt(0) == i) {
                return i2;
            }
        }
        return -1;
    }
}

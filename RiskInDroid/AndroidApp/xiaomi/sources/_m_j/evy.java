package _m_j;

import android.view.View;
import android.widget.ImageView;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;

public final class evy extends euk<ewo, vr> {
    public final int O000000o() {
        return 17;
    }

    public final int O00000Oo() {
        return R.layout.quick_enter_list_item;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        ewo ewo = (ewo) obj;
        View view = vrVar.itemView;
        if (ewo.f15895O000000o.size() > 0) {
            dui O000000o2 = duh.O000000o();
            String str = ewo.f15895O000000o.get(0).f15896O000000o;
            Option option = new Option();
            option.O00000Oo = R.drawable.default_pic_small_inverse;
            O000000o2.O000000o(str, (ImageView) view.findViewById(R.id.product_image_one), option);
            ((CustomTextView) view.findViewById(R.id.product_name_one)).setText(ewo.f15895O000000o.get(0).O00000o0);
        }
        if (ewo.f15895O000000o.size() > 1) {
            dui O000000o3 = duh.O000000o();
            String str2 = ewo.f15895O000000o.get(1).f15896O000000o;
            Option option2 = new Option();
            option2.O00000Oo = R.drawable.default_pic_small_inverse;
            O000000o3.O000000o(str2, (ImageView) view.findViewById(R.id.product_image_two), option2);
            ((CustomTextView) view.findViewById(R.id.product_name_two)).setText(ewo.f15895O000000o.get(1).O00000o0);
            vrVar.O00000Oo(R.id.layout_contain_two, true);
        } else {
            vrVar.O00000Oo(R.id.layout_contain_two, false);
        }
        if (ewo.f15895O000000o.size() > 2) {
            dui O000000o4 = duh.O000000o();
            String str3 = ewo.f15895O000000o.get(2).f15896O000000o;
            Option option3 = new Option();
            option3.O00000Oo = R.drawable.default_pic_small_inverse;
            O000000o4.O000000o(str3, (ImageView) view.findViewById(R.id.product_image_three), option3);
            ((CustomTextView) view.findViewById(R.id.product_name_three)).setText(ewo.f15895O000000o.get(2).O00000o0);
            vrVar.O00000Oo(R.id.layout_contain_three, true);
        } else {
            vrVar.O00000Oo(R.id.layout_contain_three, false);
        }
        if (ewo.f15895O000000o.size() > 3) {
            dui O000000o5 = duh.O000000o();
            String str4 = ewo.f15895O000000o.get(3).f15896O000000o;
            Option option4 = new Option();
            option4.O00000Oo = R.drawable.default_pic_small_inverse;
            O000000o5.O000000o(str4, (ImageView) view.findViewById(R.id.product_image_four), option4);
            ((CustomTextView) view.findViewById(R.id.product_name_four)).setText(ewo.f15895O000000o.get(3).O00000o0);
            vrVar.O00000Oo(R.id.layout_contain_four, true);
            return;
        }
        vrVar.O00000Oo(R.id.layout_contain_four, false);
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewo) obj, i);
    }
}

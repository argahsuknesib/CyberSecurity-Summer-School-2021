package _m_j;

import _m_j.dup;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.xiaomi.shopviews.model.HomeSectionItem;
import com.xiaomi.smarthome.R;

public final class ewu {

    /* renamed from: O000000o  reason: collision with root package name */
    private ImageView f15905O000000o;

    public ewu(View view) {
        this.f15905O000000o = (ImageView) view.findViewById(R.id.listitem_home_tag_image);
    }

    public final void O000000o(HomeSectionItem homeSectionItem) {
        String str = homeSectionItem.mProductTag;
        if (!TextUtils.isEmpty(str)) {
            dup.O000000o O000000o2 = dup.O000000o(str);
            if (O000000o2 != null) {
                int i = O000000o2.O00000Oo;
                int i2 = O000000o2.f14954O000000o;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15905O000000o.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(i, i2);
                }
                layoutParams.width = i;
                layoutParams.height = i2;
                this.f15905O000000o.setLayoutParams(layoutParams);
            }
            this.f15905O000000o.setVisibility(0);
            return;
        }
        this.f15905O000000o.setVisibility(8);
    }
}

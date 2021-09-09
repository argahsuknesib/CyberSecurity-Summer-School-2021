package _m_j;

import _m_j.dup;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;

public final class exc {

    /* renamed from: O000000o  reason: collision with root package name */
    public LinearLayout f15912O000000o;
    private Context O00000Oo;

    public exc(View view) {
        this.f15912O000000o = (LinearLayout) view.findViewById(R.id.viewhelper_product_tag_array_root);
        this.O00000Oo = view.getContext();
    }

    public final void O000000o(ArrayList<String> arrayList) {
        Context context;
        this.f15912O000000o.removeAllViews();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next) && (context = this.O00000Oo) != null) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 16;
                this.f15912O000000o.addView(imageView, layoutParams);
                if (!TextUtils.isEmpty(next)) {
                    dup.O000000o O000000o2 = dup.O000000o(next);
                    if (O000000o2 != null) {
                        int i = O000000o2.O00000Oo;
                        int i2 = O000000o2.f14954O000000o;
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                        if (layoutParams2 == null) {
                            layoutParams2 = new LinearLayout.LayoutParams(i, i2);
                            layoutParams2.gravity = 16;
                        }
                        layoutParams2.width = i;
                        layoutParams2.height = i2;
                        imageView.setLayoutParams(layoutParams2);
                    }
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
        }
    }
}

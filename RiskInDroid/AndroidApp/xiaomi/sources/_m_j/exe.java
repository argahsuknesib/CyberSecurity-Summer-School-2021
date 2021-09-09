package _m_j;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.shopviews.adapter.adapter.BasePageAdapter;
import com.xiaomi.shopviews.model.HomeSectionItem;
import com.xiaomi.smarthome.R;

public final class exe extends BasePageAdapter<HomeSectionItem> {
    private boolean O00000Oo = false;
    private int O00000o = 2;
    private int O00000o0 = 1;
    private ImageView O00000oO;
    private Context O00000oo;
    private ewu O0000O0o;
    private ewx O0000OOo;

    public final /* synthetic */ View O000000o(Context context, Object obj, ViewGroup viewGroup) {
        final HomeSectionItem homeSectionItem = (HomeSectionItem) obj;
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.listitem_one_type1, (ViewGroup) null);
        this.O00000oO = (ImageView) inflate.findViewById(R.id.iv_list_one_type1_product);
        duq.O000000o();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O00000oO.getLayoutParams();
        layoutParams.width = dul.O000000o(context, 300.0f);
        layoutParams.height = (dul.O000000o(context, 300.0f) * this.O00000o0) / this.O00000o;
        this.O0000OOo = new ewx(inflate, context);
        this.O0000O0o = new ewu(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.exe.AnonymousClass1 */

            public final void onClick(View view) {
            }
        });
        if (this.O00000Oo) {
            this.O0000OOo.O00000o0.setVisibility(8);
        }
        return inflate;
    }

    public final /* synthetic */ void O000000o(View view, Object obj) {
        RelativeLayout.LayoutParams layoutParams;
        HomeSectionItem homeSectionItem = (HomeSectionItem) obj;
        if (homeSectionItem != null) {
            ColorDrawable colorDrawable = new ColorDrawable(ewe.f15881O000000o);
            dui O000000o2 = duh.O000000o();
            String str = homeSectionItem.mImageUrl;
            ImageView imageView = this.O00000oO;
            Option option = new Option();
            option.O00000o0 = colorDrawable;
            option.O00000oO = colorDrawable;
            O000000o2.O000000o(str, imageView, option);
            if (this.O00000Oo) {
                this.O0000OOo.O00000o0.setVisibility(8);
                return;
            }
            this.O0000OOo.O00000o0.setVisibility(0);
            ewx ewx = this.O0000OOo;
            ewx.O0000O0o.setText(!TextUtils.isEmpty(homeSectionItem.mProductName) ? homeSectionItem.mProductName : "");
            if (TextUtils.isEmpty(homeSectionItem.mProductBrief)) {
                ewx.O00000o.setVisibility(8);
                ewx.f15906O000000o.setVisibility(0);
                ewx.O00000Oo.setVisibility(8);
                ewv.O000000o(ewx.O0000OOo, ewx.O00000oO, ewx.O0000Oo0, homeSectionItem);
            } else {
                ewx.O00000o.setVisibility(0);
                ewx.f15906O000000o.setVisibility(8);
                ewx.O00000Oo.setVisibility(0);
                ewx.O00000o.setText(homeSectionItem.mProductBrief);
                ewv.O000000o(ewx.O0000OoO, ewx.O00000oo, ewx.O0000Oo, homeSectionItem);
                if (!homeSectionItem.showPriceQi) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ewx.O0000OoO.getLayoutParams();
                    layoutParams2.addRule(11);
                    ewx.O0000OoO.setLayoutParams(layoutParams2);
                    layoutParams = (RelativeLayout.LayoutParams) ewx.O00000oo.getLayoutParams();
                    layoutParams.addRule(11);
                } else {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) ewx.O0000OoO.getLayoutParams();
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams3.removeRule(11);
                    } else {
                        layoutParams3.addRule(11, 0);
                    }
                    ewx.O0000OoO.setLayoutParams(layoutParams3);
                    layoutParams = (RelativeLayout.LayoutParams) ewx.O00000oo.getLayoutParams();
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams.removeRule(11);
                    } else {
                        layoutParams.addRule(11, 0);
                    }
                }
                ewx.O00000oo.setLayoutParams(layoutParams);
            }
            this.O0000O0o.O000000o(homeSectionItem);
        }
    }

    public exe(Context context, boolean z) {
        super(context);
        this.O00000oo = context;
        this.O00000Oo = z;
    }

    public final int getCount() {
        if (this.f3589O000000o.size() != 1) {
            return this.f3589O000000o.size() == 0 ? 0 : 500;
        }
        return 1;
    }

    /* renamed from: O00000Oo */
    public final HomeSectionItem O000000o(int i) {
        return (HomeSectionItem) super.O000000o(O00000o0(i));
    }

    public final int getItemPosition(Object obj) {
        if (getCount() > 0) {
            return this.f3589O000000o.contains(((View) obj).getTag()) ? -1 : -2;
        }
        return super.getItemPosition(obj);
    }

    public final CharSequence getPageTitle(int i) {
        return ((HomeSectionItem) this.f3589O000000o.get(i)).mTitle;
    }

    public final int O00000o0(int i) {
        return i % this.f3589O000000o.size();
    }
}

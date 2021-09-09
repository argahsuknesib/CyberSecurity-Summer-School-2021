package _m_j;

import _m_j.ewr;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.bingoogolapple.bgabanner.BGABanner;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public final class euo extends euk<ewr, vr> {
    eum O00000o0;

    public final int O000000o() {
        return 2;
    }

    public final int O00000Oo() {
        return R.layout.advertise_gallery_item;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061  */
    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        ArrayList arrayList;
        char c;
        final ewr ewr = (ewr) obj;
        BGABanner bGABanner = (BGABanner) vrVar.itemView.findViewById(R.id.banner);
        if (ewr.O0000o != 0) {
            bGABanner.setAutoPlayInterval(ewr.O0000o);
        }
        int i2 = Resources.getSystem().getDisplayMetrics().widthPixels;
        if (i2 != 0) {
            int i3 = (i2 * 20) / 72;
            String str = ewr.O00000Oo;
            int hashCode = str.hashCode();
            if (hashCode != -1684161233) {
                if (hashCode != 739542390) {
                    if (hashCode == 1275590406 && str.equals("slider_with_dot_middle")) {
                        c = 1;
                        if (c != 0) {
                            if (c == 1) {
                                i3 = (i2 * 40) / 72;
                            } else if (c == 2) {
                                i3 = (i2 * 80) / 72;
                            }
                        }
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bGABanner.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = i3;
                        bGABanner.setLayoutParams(layoutParams);
                    }
                } else if (str.equals("slider_with_dot_small")) {
                    c = 0;
                    if (c != 0) {
                    }
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bGABanner.getLayoutParams();
                    layoutParams2.width = -1;
                    layoutParams2.height = i3;
                    bGABanner.setLayoutParams(layoutParams2);
                }
            } else if (str.equals("slider_with_dot_big")) {
                c = 2;
                if (c != 0) {
                }
                FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) bGABanner.getLayoutParams();
                layoutParams22.width = -1;
                layoutParams22.height = i3;
                bGABanner.setLayoutParams(layoutParams22);
            }
            c = 65535;
            if (c != 0) {
            }
            FrameLayout.LayoutParams layoutParams222 = (FrameLayout.LayoutParams) bGABanner.getLayoutParams();
            layoutParams222.width = -1;
            layoutParams222.height = i3;
            bGABanner.setLayoutParams(layoutParams222);
        }
        final Option option = new Option();
        option.O00000Oo = R.drawable.default_pic_small_inverse;
        bGABanner.setAdapter(new BGABanner.O000000o<ImageView, ewr.O000000o>() {
            /* class _m_j.euo.AnonymousClass1 */

            public final /* synthetic */ void O000000o(View view, Object obj) {
                ImageView imageView = (ImageView) view;
                ewr.O000000o o000000o = (ewr.O000000o) obj;
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                duh.O000000o().O000000o(o000000o.O00000Oo, imageView, option);
                euo euo = euo.this;
                String str = ewr.O00000Oo;
                if (euo.O00000o0 != null) {
                    euo.O00000o0.O000000o(str, o000000o);
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{0}}, new int[]{euo.this.f2565O000000o.getColor(R.color.product_detail_recommend_togetherbuy_tip_textcolor)});
                        RippleDrawable rippleDrawable = (RippleDrawable) euo.this.f2565O000000o.getDrawable(euo.this.f2565O000000o.obtainStyledAttributes(new int[]{R.attr.selectableItemBackground}).getResourceId(0, 0));
                        rippleDrawable.setColor(colorStateList);
                        imageView.setForeground(rippleDrawable);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    imageView.setBackground(euo.this.f2565O000000o.getResources().getDrawable(R.drawable.item_spot_touch_rectanle_whitebg));
                }
            }
        });
        if (ewr.O0000oo0 == null || ewr.O0000oo0.size() != 1) {
            bGABanner.setAutoPlayAble(true);
        } else {
            bGABanner.setAutoPlayAble(false);
        }
        List list = ewr.O0000oo0;
        bGABanner.O00000o0 = new ArrayList();
        if (list == null) {
            list = new ArrayList();
            arrayList = new ArrayList();
        } else {
            arrayList = null;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            bGABanner.O00000o0.add(View.inflate(bGABanner.getContext(), R.layout.bga_banner_item_image, null));
        }
        if (bGABanner.O00000o && bGABanner.O00000o0.size() < 3) {
            bGABanner.O00000Oo = new ArrayList(bGABanner.O00000o0);
            bGABanner.O00000Oo.add(View.inflate(bGABanner.getContext(), R.layout.bga_banner_item_image, null));
            if (bGABanner.O00000Oo.size() == 2) {
                bGABanner.O00000Oo.add(View.inflate(bGABanner.getContext(), R.layout.bga_banner_item_image, null));
            }
        }
        bGABanner.O000000o(bGABanner.O00000o0, list, arrayList);
        bGABanner.setDelegate(new BGABanner.O00000o0() {
            /* class _m_j.euo.AnonymousClass2 */

            public final void O000000o(Object obj, int i) {
                euo euo = euo.this;
                String str = ewr.O00000Oo;
                ewr.O000000o o000000o = (ewr.O000000o) obj;
                if (euo.O00000o0 != null) {
                    euo.O00000o0.O000000o(str, o000000o, "");
                }
                euo euo2 = euo.this;
                String format = String.format("place%s_click", Integer.valueOf(i + 1));
                if (euo2.O00000o0 != null) {
                    euo2.O00000o0.O000000o(format, "navigation_bar");
                }
            }
        });
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewr) obj, i);
    }

    public euo(eum eum) {
        this.O00000o0 = eum;
    }
}

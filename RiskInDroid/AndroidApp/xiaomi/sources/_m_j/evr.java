package _m_j;

import _m_j.ewr;
import _m_j.ews;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.gson.Gson;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.shopviews.widget.view.BGABanner;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public final class evr extends euk<ewr, vr> {
    public eum O00000o0;

    public final int O000000o() {
        return 1;
    }

    public final int O00000Oo() {
        return R.layout.widget_item_banner;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        ArrayList arrayList;
        boolean z;
        ews ews;
        final ewr ewr = (ewr) obj;
        View view = vrVar.itemView;
        final Option option = new Option();
        option.O00000Oo = R.drawable.default_pic_small_inverse;
        BGABanner bGABanner = (BGABanner) view.findViewById(R.id.banner);
        if (ewr.O0000o != 0) {
            bGABanner.setAutoPlayInterval(ewr.O0000o);
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.layout_quick_enter_container);
        int i2 = Resources.getSystem().getDisplayMetrics().widthPixels;
        if (i2 != 0) {
            int i3 = (i2 * 71) / 72;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bGABanner.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = i3;
            bGABanner.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams2.topMargin = i3 - dul.O000000o(eui.f15823O000000o, 62.5f);
            frameLayout.setLayoutParams(layoutParams2);
        }
        bGABanner.setAdapter(new BGABanner.O000000o<ImageView, ewr.O000000o>() {
            /* class _m_j.evr.AnonymousClass1 */

            public final /* synthetic */ void O000000o(View view, Object obj, final int i) {
                ImageView imageView = (ImageView) view;
                final ewr.O000000o o000000o = (ewr.O000000o) obj;
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                duh.O000000o().O000000o(o000000o.O00000Oo, imageView, option);
                evr evr = evr.this;
                String str = ewr.O00000Oo;
                if (evr.O00000o0 != null) {
                    evr.O00000o0.O000000o(str, o000000o);
                }
                if (TextUtils.isEmpty(Build.MODEL) || !Build.MODEL.toLowerCase().contains("vivo") || !Build.MODEL.toLowerCase().contains("x9")) {
                    uo.O000000o(evr.this.f2565O000000o).O00000o0().O000000o(o000000o.O00000Oo).O000000o(new vk<Bitmap>() {
                        /* class _m_j.evr.AnonymousClass1.AnonymousClass1 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            Bitmap bitmap = (Bitmap) obj;
                            if (i == 0 && o000000o.O000O0o0 == -1 && evr.this.O00000o0 != null) {
                                o000000o.O000O0o0 = evr.O000000o(bitmap);
                                evr.this.O00000o0.O000000o(ewr.O0000oo0.get(i).O000O0o0);
                            }
                            if (o000000o.O000O0o0 == -1) {
                                o000000o.O000O0o0 = evr.O000000o(bitmap);
                            }
                        }
                    });
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
        String str = null;
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
            /* class _m_j.evr.AnonymousClass2 */

            public final void O000000o(Object obj) {
                evr evr = evr.this;
                String str = ewr.O00000Oo;
                ewr.O000000o o000000o = (ewr.O000000o) obj;
                if (evr.O00000o0 != null) {
                    evr.O00000o0.O000000o(str, o000000o, "");
                }
            }
        });
        bGABanner.setOnPageChangeListener(new ViewPager.O0000O0o() {
            /* class _m_j.evr.AnonymousClass3 */

            public final void onPageScrollStateChanged(int i) {
            }

            public final void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageSelected(int i) {
                if (evr.this.O00000o0 != null) {
                    evr.this.O00000o0.O000000o(ewr.O0000oo0.get(i).O000O0o0);
                }
            }
        });
        if (ewr.O0000oo0 != null && ewr.O0000oo0.size() > 0) {
            str = ewr.O0000oo0.get(0).O000O0Oo;
        }
        if (TextUtils.isEmpty(ewr.O00000oo) || (ews = (ews) new Gson().fromJson(ewr.O00000oo, ews.class)) == null) {
            z = false;
        } else {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (!TextUtils.isEmpty(ews.f15903O000000o)) {
                duh.O000000o().O000000o(ews.f15903O000000o, imageView, new Option());
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(4);
            }
            final List<ews.O000000o> list2 = ews.O00000Oo;
            if (list2 == null || list2.size() <= 0) {
                z = false;
            } else {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_contain_one);
                duh.O000000o().O000000o(list2.get(0).O00000Oo, (ImageView) view.findViewById(R.id.product_image_one), option);
                ((CustomTextView) view.findViewById(R.id.product_name_one)).setText(list2.get(0).O00000o);
                if (!TextUtils.isEmpty(list2.get(0).O00000oO)) {
                    ((CustomTextView) view.findViewById(R.id.product_name_one)).setTextColor(Color.parseColor(list2.get(0).O00000oO));
                }
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.evr.AnonymousClass4 */

                    public final void onClick(View view) {
                        evr.this.O000000o(ewr.O00000Oo, (ews.O000000o) list2.get(0));
                    }
                });
                O000000o(ewr.O00000Oo, list2.get(0), str);
                z = true;
            }
            if (list2.size() > 1) {
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.layout_contain_two);
                duh.O000000o().O000000o(list2.get(1).O00000Oo, (ImageView) view.findViewById(R.id.product_image_two), option);
                ((CustomTextView) view.findViewById(R.id.product_name_two)).setText(list2.get(1).O00000o);
                if (!TextUtils.isEmpty(list2.get(1).O00000oO)) {
                    ((CustomTextView) view.findViewById(R.id.product_name_two)).setTextColor(Color.parseColor(list2.get(1).O00000oO));
                }
                linearLayout2.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.evr.AnonymousClass5 */

                    public final void onClick(View view) {
                        evr.this.O000000o(ewr.O00000Oo, (ews.O000000o) list2.get(1));
                    }
                });
                O000000o(ewr.O00000Oo, list2.get(1), str);
            }
            if (list2.size() > 2) {
                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.layout_contain_three);
                duh.O000000o().O000000o(list2.get(2).O00000Oo, (ImageView) view.findViewById(R.id.product_image_three), option);
                ((CustomTextView) view.findViewById(R.id.product_name_three)).setText(list2.get(2).O00000o);
                if (!TextUtils.isEmpty(list2.get(2).O00000oO)) {
                    ((CustomTextView) view.findViewById(R.id.product_name_three)).setTextColor(Color.parseColor(list2.get(2).O00000oO));
                }
                linearLayout3.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.evr.AnonymousClass6 */

                    public final void onClick(View view) {
                        evr.this.O000000o(ewr.O00000Oo, (ews.O000000o) list2.get(2));
                    }
                });
                O000000o(ewr.O00000Oo, list2.get(2), str);
            }
            if (list2.size() > 3) {
                LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.layout_contain_four);
                duh.O000000o().O000000o(list2.get(3).O00000Oo, (ImageView) view.findViewById(R.id.product_image_four), option);
                ((CustomTextView) view.findViewById(R.id.product_name_four)).setText(list2.get(3).O00000o);
                if (!TextUtils.isEmpty(list2.get(3).O00000oO)) {
                    ((CustomTextView) view.findViewById(R.id.product_name_four)).setTextColor(Color.parseColor(list2.get(3).O00000oO));
                }
                linearLayout4.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.evr.AnonymousClass7 */

                    public final void onClick(View view) {
                        evr.this.O000000o(ewr.O00000Oo, (ews.O000000o) list2.get(3));
                    }
                });
                O000000o(ewr.O00000Oo, list2.get(3), str);
            }
        }
        if (z) {
            frameLayout.setVisibility(0);
            return;
        }
        bGABanner.setPointTopBottomMargin(dul.O000000o(bGABanner.getContext(), 20.0f));
        frameLayout.setVisibility(8);
        ((RelativeLayout.LayoutParams) bGABanner.getLayoutParams()).bottomMargin = 0;
        RecyclerView.LayoutParams layoutParams3 = (RecyclerView.LayoutParams) view.getLayoutParams();
        layoutParams3.bottomMargin = dul.O000000o(bGABanner.getContext(), 35.0f);
        view.setLayoutParams(layoutParams3);
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewr) obj, i);
    }

    public evr(eum eum) {
        this.O00000o0 = eum;
    }

    public final void O000000o(String str, ews.O000000o o000000o) {
        eum eum = this.O00000o0;
        if (eum != null) {
            eum.O000000o(str, o000000o, "");
        }
    }

    private void O000000o(String str, ews.O000000o o000000o, String str2) {
        eum eum = this.O00000o0;
        if (eum != null) {
            eum.O00000Oo(str, o000000o, str2);
        }
    }

    public static int O000000o(Bitmap bitmap) {
        int[] iArr;
        Bitmap bitmap2 = bitmap;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        bitmapDrawable.draw(canvas);
        int intrinsicWidth = bitmapDrawable.getIntrinsicWidth();
        int i = 22;
        int[] iArr2 = {0, 4, 9, 13, 18, 23, 28, 33, 38, 43, 48, 53, 58, 63, 68, 73, 78, 83, 88, 93, 98, 103};
        int[] iArr3 = {0, intrinsicWidth / 8, (intrinsicWidth * 2) / 8, (intrinsicWidth * 3) / 8, (intrinsicWidth * 4) / 8, (intrinsicWidth * 5) / 8, (intrinsicWidth * 6) / 8, (intrinsicWidth * 7) / 8, intrinsicWidth - 1};
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double d = 0.0d;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 9; i2 < i4; i4 = 9) {
            double d2 = d;
            int i5 = 0;
            while (i5 < i) {
                if (iArr3[i2] >= width || iArr2[i5] >= height) {
                    iArr = iArr3;
                } else {
                    i3++;
                    Integer valueOf = Integer.valueOf(bitmap2.getPixel(iArr3[i2], iArr2[i5]));
                    iArr = iArr3;
                    double intValue = (double) (((valueOf.intValue() | -16711681) >> 16) & 255);
                    Double.isNaN(intValue);
                    double intValue2 = (double) (((valueOf.intValue() | -65281) >> 8) & 255);
                    Double.isNaN(intValue2);
                    double d3 = d2 + (intValue * 0.299d) + (intValue2 * 0.587d);
                    double intValue3 = (double) ((valueOf.intValue() | -256) & 255);
                    Double.isNaN(intValue3);
                    d2 = d3 + (intValue3 * 0.114d);
                }
                i5++;
                iArr3 = iArr;
                i = 22;
            }
            i2++;
            d = d2;
            i = 22;
        }
        double d4 = (double) i3;
        Double.isNaN(d4);
        return ((double) ((int) (d / d4))) >= 128.0d ? 1 : 0;
    }
}

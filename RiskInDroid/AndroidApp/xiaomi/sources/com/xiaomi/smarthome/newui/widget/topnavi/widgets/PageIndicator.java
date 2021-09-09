package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import _m_j.gpc;
import _m_j.hhu;
import _m_j.hhx;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import com.xiaomi.smarthome.newui.widget.topnavi.indicator.MagicIndicator;
import com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.CommonNavigator;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.PageIndicator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PageIndicator extends MagicIndicator {
    public ViewPager O00000Oo;
    private O000000o O00000o0;

    private void setCategoryCutOff(List<PageBean> list) {
    }

    public PageIndicator(Context context) {
        this(context, null);
    }

    public PageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        CommonNavigator commonNavigator = new CommonNavigator(context);
        O000000o o000000o = new O000000o(this, (byte) 0);
        this.O00000o0 = o000000o;
        commonNavigator.setAdapter(o000000o);
        commonNavigator.setCompactMode(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        commonNavigator.setLayoutParams(layoutParams);
        setNavigator(commonNavigator);
    }

    public void setCurrentItem(int i) {
        ViewPager viewPager = this.O00000Oo;
        if (viewPager != null) {
            viewPager.setCurrentItem(i);
        }
    }

    public final void O000000o(List<PageBean> list) {
        this.O00000o0.O000000o(list);
        setCategoryCutOff(list);
    }

    class O000000o extends hhu {
        private ArrayList<PageBean> O00000o0;

        private O000000o() {
            this.O00000o0 = new ArrayList<>();
        }

        /* synthetic */ O000000o(PageIndicator pageIndicator, byte b) {
            this();
        }

        public final int O000000o() {
            ArrayList<PageBean> arrayList = this.O00000o0;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        public final hhx O000000o(Context context, int i) {
            String str;
            IndicatorTab indicatorTab = new IndicatorTab(context);
            indicatorTab.setNormalColor(context.getResources().getColor(R.color.mj_color_black_40_transparent));
            indicatorTab.setSelectedColor(context.getResources().getColor(R.color.mj_color_black_70_transparent));
            PageBean pageBean = this.O00000o0.get(i);
            indicatorTab.setText(pageBean != null ? pageBean.f10340O000000o : "");
            if (Build.VERSION.SDK_INT >= 24) {
                str = CommonApplication.getApplication().getResources().getConfiguration().getLocales().get(0).getLanguage();
            } else {
                str = CommonApplication.getApplication().getResources().getConfiguration().locale.getLanguage();
            }
            if (TextUtils.equals(str, Locale.CHINESE.getLanguage())) {
                indicatorTab.setTextSize(1, 22.0f);
            } else {
                indicatorTab.setTextSize(1, 20.0f);
            }
            indicatorTab.setOnClickListener(new View.OnClickListener(i) {
                /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.$$Lambda$PageIndicator$O000000o$Yib6DJYCzaSt1XLSu1eP3XQS3Jg */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    PageIndicator.O000000o.this.O000000o(this.f$1, view);
                }
            });
            int O00000o02 = gpc.O00000o0(context, 8.0f);
            indicatorTab.setPadding(i == 0 ? 0 : O00000o02, 0, O00000o02, 0);
            indicatorTab.setIncludeFontPadding(false);
            return indicatorTab;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, View view) {
            if (PageIndicator.this.O00000Oo != null && PageIndicator.this.O00000Oo.getCurrentItem() != i) {
                PageIndicator.this.O00000Oo.setCurrentItem(i);
            }
        }

        public final void O000000o(List<PageBean> list) {
            if (!this.O00000o0.equals(list)) {
                this.O00000o0 = new ArrayList<>(list);
                this.f18954O000000o.notifyChanged();
            }
        }
    }
}

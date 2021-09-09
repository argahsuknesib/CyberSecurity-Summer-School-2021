package com.xiaomi.smarthome.scene.widget;

import _m_j.gpc;
import _m_j.hrn;
import _m_j.hrr;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.scene.widget.SceneTabIndicator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SceneTabIndicator extends MagicIndicator {

    /* renamed from: O000000o  reason: collision with root package name */
    public ViewPager f11333O000000o;
    private O000000o O00000Oo;

    public SceneTabIndicator(Context context) {
        this(context, null);
    }

    public SceneTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        CommonNavigator commonNavigator = new CommonNavigator(context);
        O000000o o000000o = new O000000o(this, (byte) 0);
        this.O00000Oo = o000000o;
        commonNavigator.setAdapter(o000000o);
        commonNavigator.setCompactMode(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        commonNavigator.setLayoutParams(layoutParams);
        setNavigator(commonNavigator);
    }

    public void setCurrentItem(int i) {
        ViewPager viewPager = this.f11333O000000o;
        if (viewPager != null) {
            viewPager.setCurrentItem(i);
        }
    }

    public final void O000000o(List<String> list) {
        this.O00000Oo.O000000o(list);
    }

    class O000000o extends hrn {
        private ArrayList<String> O00000o0;

        private O000000o() {
            this.O00000o0 = new ArrayList<>();
        }

        /* synthetic */ O000000o(SceneTabIndicator sceneTabIndicator, byte b) {
            this();
        }

        public final int O000000o() {
            ArrayList<String> arrayList = this.O00000o0;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        public final hrr O000000o(Context context, int i) {
            String str;
            IndicatorTab indicatorTab = new IndicatorTab(context);
            indicatorTab.setNormalColor(context.getResources().getColor(R.color.mj_color_black_40_transparent));
            indicatorTab.setSelectedColor(context.getResources().getColor(R.color.mj_color_black_70_transparent));
            String str2 = this.O00000o0.get(i);
            if (str2 == null) {
                str2 = "";
            }
            indicatorTab.setText(str2);
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
                /* class com.xiaomi.smarthome.scene.widget.$$Lambda$SceneTabIndicator$O000000o$SV_n1IjIk_O2ioY3_Urktz1_Gis */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    SceneTabIndicator.O000000o.this.O000000o(this.f$1, view);
                }
            });
            int O00000o02 = gpc.O00000o0(context, 8.0f);
            indicatorTab.setPadding(i == 0 ? 0 : O00000o02, 0, O00000o02, 0);
            indicatorTab.setIncludeFontPadding(false);
            return indicatorTab;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, View view) {
            if (SceneTabIndicator.this.f11333O000000o != null && SceneTabIndicator.this.f11333O000000o.getCurrentItem() != i) {
                SceneTabIndicator.this.f11333O000000o.setCurrentItem(i);
            }
        }

        public final void O000000o(List<String> list) {
            if (!this.O00000o0.equals(list)) {
                this.O00000o0 = new ArrayList<>(list);
                this.f569O000000o.notifyChanged();
            }
        }
    }
}

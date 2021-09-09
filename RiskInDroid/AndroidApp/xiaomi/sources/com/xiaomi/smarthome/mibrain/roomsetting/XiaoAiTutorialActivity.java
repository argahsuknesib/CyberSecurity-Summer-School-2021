package com.xiaomi.smarthome.mibrain.roomsetting;

import _m_j.chm;
import _m_j.gpc;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mibigkoo.convenientbanner.ConvenientBanner;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.util.Arrays;
import java.util.List;

public class XiaoAiTutorialActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<O000000o> f9507O000000o = Arrays.asList(new O000000o(0, R.string.xiaoai_setting_tutorial_1, R.drawable.xiaoai_turital_illustrator_1), new O000000o(1, R.string.xiaoai_setting_tutorial_2, R.drawable.xiaoai_turital_illustrator_2));
    @BindView(4914)
    ConvenientBanner banner;
    @BindView(5009)
    View close;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_xiao_ai_tutorial);
        ButterKnife.bind(this);
        this.close.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.roomsetting.$$Lambda$XiaoAiTutorialActivity$YeGplaauclEjvoDb7J1usERRXJU */

            public final void onClick(View view) {
                XiaoAiTutorialActivity.this.O000000o(view);
            }
        });
        this.banner.O000000o($$Lambda$XiaoAiTutorialActivity$ny6EXfhOc6nkwfYCnFxByJ0pFc.INSTANCE, this.f9507O000000o).O000000o(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL).O000000o(new int[]{R.drawable.mj_dot_indicator_unselected, R.drawable.xiaoai_tutital_dot_indicator_selected});
        this.banner.setCanLoop(false);
        this.banner.setcurrentitem(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        finish();
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object O000000o() {
        return new O00000Oo();
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f9508O000000o;
        int O00000Oo = 0;
        int O00000o;
        int O00000o0;

        public O000000o(int i, int i2, int i3) {
            this.f9508O000000o = i;
            this.O00000o0 = i2;
            this.O00000o = i3;
        }
    }

    static class O00000Oo implements chm<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        View f9509O000000o;

        O00000Oo() {
        }

        public final /* synthetic */ void O000000o(Context context, int i, Object obj) {
            ViewGroup.LayoutParams layoutParams;
            O000000o o000000o = (O000000o) obj;
            TextView textView = (TextView) this.f9509O000000o.findViewById(R.id.desc);
            ImageView imageView = (ImageView) this.f9509O000000o.findViewById(R.id.img);
            if (i == 0) {
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = gpc.O000000o(context, 288.0f);
                    layoutParams2.height = gpc.O000000o(context, 230.0f);
                    imageView.setLayoutParams(layoutParams2);
                }
            } else if (i == 1 && (layoutParams = imageView.getLayoutParams()) != null) {
                layoutParams.width = gpc.O000000o(context, 248.0f);
                layoutParams.height = gpc.O000000o(context, 236.0f);
                imageView.setLayoutParams(layoutParams);
            }
            textView.setText(o000000o.O00000o0);
            imageView.setImageResource(o000000o.O00000o);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View O000000o(Context context, ViewGroup viewGroup) {
            this.f9509O000000o = LayoutInflater.from(context).inflate((int) R.layout.xiaoai_banner_item, viewGroup, false);
            return this.f9509O000000o;
        }
    }
}

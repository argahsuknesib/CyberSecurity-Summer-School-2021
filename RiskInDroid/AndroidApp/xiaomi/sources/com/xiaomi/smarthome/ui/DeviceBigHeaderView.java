package com.xiaomi.smarthome.ui;

import _m_j.gpc;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import java.util.List;

public class DeviceBigHeaderView extends HorizontalScrollView {

    /* renamed from: O000000o  reason: collision with root package name */
    private LinearLayout f11903O000000o = new LinearLayout(getContext());
    private List<O000000o> O00000Oo;

    public DeviceBigHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11903O000000o.setOrientation(0);
        this.f11903O000000o.setGravity(17);
        addView(this.f11903O000000o, new FrameLayout.LayoutParams(-1, -1));
        setFillViewport(false);
        setHorizontalScrollBarEnabled(false);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.LinearLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void setModel(List<O000000o> list) {
        this.O00000Oo = list;
        List<O000000o> list2 = this.O00000Oo;
        if (list2 != null && !list2.isEmpty()) {
            this.f11903O000000o.removeAllViews();
            for (int i = 0; i < this.O00000Oo.size(); i++) {
                O000000o o000000o = this.O00000Oo.get(i);
                if (o000000o != null) {
                    View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.device_info_list_item, (ViewGroup) this.f11903O000000o, false);
                    DeviceFactory.O00000Oo(o000000o.f11904O000000o, (SimpleDraweeView) inflate.findViewById(R.id.device_img));
                    ((TextView) inflate.findViewById(R.id.device_name_tv)).setText(o000000o.O00000Oo);
                    this.f11903O000000o.addView(inflate);
                }
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11903O000000o.getLayoutParams();
            if (this.f11903O000000o.getChildCount() <= 2) {
                layoutParams.gravity = 17;
            } else {
                layoutParams.gravity = 19;
                if (this.f11903O000000o.getChildCount() >= 3) {
                    layoutParams.leftMargin = gpc.O000000o(45.0f);
                    LinearLayout linearLayout = this.f11903O000000o;
                    linearLayout.setPadding(linearLayout.getPaddingLeft(), this.f11903O000000o.getPaddingTop(), gpc.O000000o(60.0f), this.f11903O000000o.getPaddingBottom());
                }
            }
            requestLayout();
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f11904O000000o;
        final String O00000Oo;

        public O000000o(String str, String str2) {
            this.f11904O000000o = str;
            this.O00000Oo = str2;
        }
    }
}

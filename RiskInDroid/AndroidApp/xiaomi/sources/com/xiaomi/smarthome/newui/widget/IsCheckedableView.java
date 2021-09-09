package com.xiaomi.smarthome.newui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class IsCheckedableView extends RelativeLayout implements Checkable {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f10312O000000o;
    private ImageView O00000Oo;
    private boolean O00000o;
    private View O00000o0;

    public IsCheckedableView(Context context) {
        super(context);
        O000000o(context);
    }

    public IsCheckedableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public IsCheckedableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.newui.widget.IsCheckedableView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O000000o(Context context) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.item_window_home_list_v2, (ViewGroup) this, true);
        this.f10312O000000o = (TextView) inflate.findViewById(R.id.name);
        this.O00000Oo = (ImageView) inflate.findViewById(R.id.icon);
        this.O00000o0 = inflate.findViewById(R.id.divider_item);
    }

    public void setChecked(boolean z) {
        Resources resources;
        int i;
        this.O00000o = z;
        this.O00000Oo.setVisibility(this.O00000o ? 0 : 4);
        TextView textView = this.f10312O000000o;
        if (z) {
            resources = getResources();
            i = R.color.mj_color_green_normal;
        } else {
            resources = getResources();
            i = R.color.mj_color_black;
        }
        textView.setTextColor(resources.getColor(i));
    }

    public boolean isChecked() {
        return this.O00000o;
    }

    public void toggle() {
        setChecked(this.O00000o);
    }

    public void setText(String str) {
        this.f10312O000000o.setText(str);
    }

    public void setDividerVisivle(boolean z) {
        this.O00000o0.setVisibility(z ? 0 : 8);
    }

    public void setActivated(boolean z) {
        super.setActivated(z);
    }
}

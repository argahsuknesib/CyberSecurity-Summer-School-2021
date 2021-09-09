package com.xiaomi.smarthome.newui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.widget.FixedTextView;

public class ChangeHomeListItemView extends RelativeLayout implements Checkable {

    /* renamed from: O000000o  reason: collision with root package name */
    private FixedTextView f10083O000000o;
    private TextView O00000Oo;
    private RelativeLayout O00000o;
    private ImageView O00000o0;
    private View O00000oO;
    private View O00000oo;
    private boolean O0000O0o;

    public ChangeHomeListItemView(Context context) {
        super(context);
        O000000o(context);
    }

    public ChangeHomeListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public ChangeHomeListItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.newui.ChangeHomeListItemView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O000000o(Context context) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.item_change_home_list, (ViewGroup) this, true);
        this.O00000o = (RelativeLayout) inflate.findViewById(R.id.root);
        this.f10083O000000o = (FixedTextView) inflate.findViewById(R.id.name);
        this.O00000Oo = (TextView) inflate.findViewById(R.id.subtitle);
        this.O00000o0 = (ImageView) inflate.findViewById(R.id.icon);
        this.O00000oO = inflate.findViewById(R.id.divider_item);
        this.O00000oo = inflate.findViewById(R.id.top_space);
    }

    public void setChecked(boolean z) {
        Resources resources;
        int i;
        this.O0000O0o = z;
        this.O00000o0.setVisibility(this.O0000O0o ? 0 : 4);
        this.f10083O000000o.setTextColor(z ? getResources().getColor(R.color.mj_color_green_normal) : getResources().getColor(R.color.mj_color_black));
        this.O00000Oo.setTextColor(z ? getResources().getColor(R.color.mj_color_green_normal) : getResources().getColor(R.color.mj_color_gray_lighter));
        RelativeLayout relativeLayout = this.O00000o;
        if (z) {
            resources = getResources();
            i = R.color.mj_color_home_list_selected;
        } else {
            resources = getResources();
            i = R.color.mj_color_dialog_bg_nor;
        }
        relativeLayout.setBackgroundColor(resources.getColor(i));
    }

    public boolean isChecked() {
        return this.O0000O0o;
    }

    public void toggle() {
        setChecked(this.O0000O0o);
    }

    public void setText(String str) {
        this.f10083O000000o.setText(str, 7);
    }

    public void setSubText(String str) {
        this.O00000Oo.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        if (str != null) {
            this.O00000Oo.setText(str);
        }
    }

    public void setDividerVisivle(boolean z) {
        this.O00000oO.setVisibility(z ? 0 : 8);
    }

    public void setTopSpaceVisivle(boolean z) {
        this.O00000oo.setVisibility(z ? 0 : 8);
    }

    public void setActivated(boolean z) {
        super.setActivated(z);
    }
}

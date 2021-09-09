package com.wx.wheelview.widget;

import _m_j.dtt;
import _m_j.dtx;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

public class WheelViewDialog implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f5950O000000o;
    public String O00000Oo;
    private View O00000o;
    private TextView O00000o0 = new TextView(this.O0000Oo);
    private View O00000oO;
    private WheelView<String> O00000oo;
    private WheelView.O00000o0 O0000O0o;
    private TextView O0000OOo;
    private Context O0000Oo;
    private AlertDialog O0000Oo0;

    public WheelViewDialog(Context context) {
        this.O0000Oo = context;
        LinearLayout linearLayout = new LinearLayout(this.O0000Oo);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(dtx.O000000o(this.O0000Oo, 20.0f), 0, dtx.O000000o(this.O0000Oo, 20.0f), 0);
        this.O00000o0.setTextColor(dtt.O00000oo);
        this.O00000o0.setTextSize(2, 16.0f);
        this.O00000o0.setGravity(17);
        linearLayout.addView(this.O00000o0, new LinearLayout.LayoutParams(-1, dtx.O000000o(this.O0000Oo, 50.0f)));
        this.O00000o = new View(this.O0000Oo);
        this.O00000o.setBackgroundColor(dtt.O00000oo);
        linearLayout.addView(this.O00000o, new LinearLayout.LayoutParams(-1, dtx.O000000o(this.O0000Oo, 2.0f)));
        this.O00000oo = new WheelView<>(this.O0000Oo);
        this.O00000oo.setSkin(WheelView.Skin.Holo);
        this.O00000oo.setWheelAdapter(new ArrayWheelAdapter(this.O0000Oo));
        this.O0000O0o = new WheelView.O00000o0();
        WheelView.O00000o0 o00000o0 = this.O0000O0o;
        o00000o0.O00000o0 = -7829368;
        o00000o0.O0000OOo = 1.2f;
        this.O00000oo.setStyle(o00000o0);
        this.O00000oo.setOnWheelItemSelectedListener(new WheelView.O00000Oo<String>() {
            /* class com.wx.wheelview.widget.WheelViewDialog.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ void onItemSelected(int i, Object obj) {
                WheelViewDialog wheelViewDialog = WheelViewDialog.this;
                wheelViewDialog.f5950O000000o = i;
                wheelViewDialog.O00000Oo = (String) obj;
            }
        });
        linearLayout.addView(this.O00000oo, new ViewGroup.MarginLayoutParams(-1, -2));
        this.O00000oO = new View(this.O0000Oo);
        this.O00000oO.setBackgroundColor(dtt.O00000oo);
        linearLayout.addView(this.O00000oO, new LinearLayout.LayoutParams(-1, dtx.O000000o(this.O0000Oo, 1.0f)));
        this.O0000OOo = new TextView(this.O0000Oo);
        this.O0000OOo.setTextColor(dtt.O00000oo);
        this.O0000OOo.setTextSize(2, 12.0f);
        this.O0000OOo.setGravity(17);
        this.O0000OOo.setClickable(true);
        this.O0000OOo.setOnClickListener(this);
        this.O0000OOo.setText("OK");
        linearLayout.addView(this.O0000OOo, new LinearLayout.LayoutParams(-1, dtx.O000000o(this.O0000Oo, 45.0f)));
        this.O0000Oo0 = new AlertDialog.Builder(this.O0000Oo).create();
        this.O0000Oo0.setView(linearLayout);
        this.O0000Oo0.setCanceledOnTouchOutside(false);
    }

    public void onClick(View view) {
        if (this.O0000Oo0.isShowing()) {
            this.O0000Oo0.dismiss();
        }
    }
}

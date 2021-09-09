package com.xiaomi.smarthome.newui.card;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.card.yeelight.VerticalSeekBar;

public class BrightIndicateView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public VerticalSeekBar f10207O000000o;
    private ImageView O00000Oo;
    private ImageView O00000o;
    private ImageView O00000o0;

    public BrightIndicateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    public BrightIndicateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public BrightIndicateView(Context context) {
        super(context);
        O000000o(context);
    }

    public final void O000000o() {
        this.O00000Oo.setImageResource(R.drawable.bright_indicate_triangle_black);
        this.O00000o0.setImageResource(R.drawable.bright_indicate_add_black);
        this.O00000o.setImageResource(R.drawable.bright_indicate_dec_black);
        this.f10207O000000o.post(new Runnable() {
            /* class com.xiaomi.smarthome.newui.card.BrightIndicateView.AnonymousClass1 */

            public final void run() {
                Rect bounds = BrightIndicateView.this.f10207O000000o.getProgressDrawable().getBounds();
                Drawable drawable = BrightIndicateView.this.getResources().getDrawable(R.drawable.seekbar_drawable_black);
                BrightIndicateView.this.f10207O000000o.setProgressDrawable(drawable);
                drawable.setBounds(bounds);
            }
        });
    }

    public final void O00000Oo() {
        this.O00000Oo.setImageResource(R.drawable.bright_indicate_triangle_white);
        this.O00000o0.setImageResource(R.drawable.bright_indicate_add_white);
        this.O00000o.setImageResource(R.drawable.bright_indicate_dec_white);
        this.f10207O000000o.post(new Runnable() {
            /* class com.xiaomi.smarthome.newui.card.BrightIndicateView.AnonymousClass2 */

            public final void run() {
                Rect bounds = BrightIndicateView.this.f10207O000000o.getProgressDrawable().getBounds();
                Drawable drawable = BrightIndicateView.this.getResources().getDrawable(R.drawable.seekbar_drawable_white);
                BrightIndicateView.this.f10207O000000o.setProgressDrawable(drawable);
                drawable.setBounds(bounds);
            }
        });
    }

    public void setValue(int i) {
        if (i <= 1) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.f10207O000000o.setProgress(i);
        Resources resources = getContext().getResources();
        float dimension = resources.getDimension(R.dimen.bright_indicate_length);
        float dimension2 = resources.getDimension(R.dimen.bright_indicate_margin_top);
        this.O00000Oo.setY((((dimension * ((float) (100 - i))) / 100.0f) + dimension2) - (resources.getDimension(R.dimen.bright_indicate_triangle_size_height) / 2.0f));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.newui.card.BrightIndicateView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O000000o(Context context) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.widget_bright_indicate, (ViewGroup) this, true);
        this.f10207O000000o = (VerticalSeekBar) inflate.findViewById(R.id.bringt_seek_bar);
        this.O00000Oo = (ImageView) inflate.findViewById(R.id.bringt_seek_indicate);
        this.O00000o0 = (ImageView) inflate.findViewById(R.id.bringt_add);
        this.O00000o = (ImageView) inflate.findViewById(R.id.bringt_dec);
    }
}

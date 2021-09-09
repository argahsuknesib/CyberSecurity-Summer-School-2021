package com.mi.global.shop.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mi.global.shop.adapter.DeliveryPopAdapter;
import com.xiaomi.smarthome.R;

public class PopSpinnerView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public TextView f4959O000000o;
    public PopupWindow O00000Oo;
    public DeliveryPopAdapter O00000o;
    ListView O00000o0;
    public O000000o O00000oO;
    private final int O00000oo = 12;
    private ImageView O0000O0o;
    private int O0000OOo = -1;

    public interface O000000o {
        String O000000o(int i);
    }

    public PopSpinnerView(Context context) {
        super(context);
        O000000o(context);
    }

    public PopSpinnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public PopSpinnerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(final Context context) {
        LayoutInflater.from(context).inflate((int) R.layout.shop_pop_spinerview, this);
        this.O0000O0o = (ImageView) findViewById(R.id.iv_arrow);
        this.f4959O000000o = (TextView) findViewById(R.id.tv_content);
        setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.widget.PopSpinnerView.AnonymousClass1 */

            public final void onClick(View view) {
                View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_pop_layout, (ViewGroup) null);
                PopSpinnerView popSpinnerView = PopSpinnerView.this;
                popSpinnerView.O00000o0 = (ListView) inflate.findViewById(R.id.lv);
                popSpinnerView.O00000o0.setAdapter((ListAdapter) popSpinnerView.O00000o);
                popSpinnerView.O00000o0.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.mi.global.shop.widget.PopSpinnerView.AnonymousClass2 */

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (PopSpinnerView.this.O00000o.f4736O000000o.get(i).isServiceable) {
                            PopSpinnerView.this.O00000o.O00000Oo = PopSpinnerView.this.O00000o.f4736O000000o.get(i).id;
                            PopSpinnerView.this.f4959O000000o.setText(PopSpinnerView.this.O00000oO.O000000o(i));
                            PopSpinnerView.this.O00000o.notifyDataSetChanged();
                            new Handler().postDelayed(new Runnable() {
                                /* class com.mi.global.shop.widget.PopSpinnerView.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    if (PopSpinnerView.this.O00000Oo != null) {
                                        PopSpinnerView.this.O00000Oo.dismiss();
                                    }
                                }
                            }, 300);
                        }
                    }
                });
                PopSpinnerView popSpinnerView2 = PopSpinnerView.this;
                popSpinnerView2.O00000Oo = new PopupWindow(inflate, -1, -2);
                popSpinnerView2.O00000Oo.setFocusable(true);
                popSpinnerView2.O00000Oo.setOutsideTouchable(true);
                popSpinnerView2.O00000Oo.setBackgroundDrawable(new BitmapDrawable());
                popSpinnerView2.O00000Oo.setAnimationStyle(0);
                popSpinnerView2.O00000Oo.showAsDropDown(popSpinnerView2.f4959O000000o, 0, -1);
            }
        });
    }

    public void setContent(String str) {
        this.f4959O000000o.setText(str);
    }

    public String getContent() {
        CharSequence text = this.f4959O000000o.getText();
        if (text == null) {
            return "";
        }
        return text.toString();
    }

    public int getSelectIndex() {
        return this.O0000OOo;
    }

    public void setSelectIndex(int i) {
        this.O0000OOo = i;
    }

    public void setSelectId(String str) {
        this.O00000o.O00000Oo = str;
    }
}

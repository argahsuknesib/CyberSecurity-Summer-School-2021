package com.xiaomi.smarthome.camera.view.widget;

import _m_j.gpc;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class DirectPushItemView extends LinearLayout {
    ImageView imageView;
    TextView textView;

    public DirectPushItemView(Context context) {
        this(context, null);
    }

    public DirectPushItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DirectPushItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        setPadding(gpc.O000000o(10.0f), gpc.O000000o(10.0f), 0, gpc.O000000o(10.0f));
        setBackgroundResource(R.drawable.direct_push_item_bg);
        this.textView = new TextView(context);
        this.textView.setTextColor(getResources().getColor(R.color.mj_color_gray_heavy));
        this.textView.setMaxLines(2);
        this.textView.setText((int) R.string.safe_password_direct_push);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.textView, layoutParams);
        this.imageView = new ImageView(context);
        this.imageView.setPadding(0, 0, gpc.O000000o(8.0f), 0);
        this.imageView.setImageResource(R.drawable.camera_direct_push_close);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = gpc.O000000o(5.0f);
        addView(this.imageView, layoutParams2);
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        ImageView imageView2 = this.imageView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(onClickListener);
        }
    }

    public void setTextClickListener(View.OnClickListener onClickListener) {
        TextView textView2 = this.textView;
        if (textView2 != null) {
            textView2.setOnClickListener(onClickListener);
        }
    }
}

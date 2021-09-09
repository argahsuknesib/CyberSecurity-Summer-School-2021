package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class EmptyView extends RelativeLayout {
    TextView emptyMessage;
    ImageView imageView;
    View rootView;

    public EmptyView(Context context) {
        super(context);
        initView(context);
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public EmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate((int) R.layout.view_comm_empty, this);
        this.emptyMessage = (TextView) findViewById(R.id.empty_message);
        this.imageView = (ImageView) findViewById(R.id.img_empty);
        this.rootView = findViewById(R.id.empty_root);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setIconResource(int i) {
        this.imageView.setImageResource(i);
    }

    public void setEmptyMessage(int i) {
        this.emptyMessage.setText(i);
    }

    public void setEmptyMessage(CharSequence charSequence) {
        this.emptyMessage.setText(charSequence);
    }

    public void setIconBackgroundRes(int i) {
        this.imageView.setBackgroundResource(i);
    }

    public void setBackgroundRes(int i) {
        if (i != -1) {
            this.rootView.setBackgroundResource(i);
        }
    }
}

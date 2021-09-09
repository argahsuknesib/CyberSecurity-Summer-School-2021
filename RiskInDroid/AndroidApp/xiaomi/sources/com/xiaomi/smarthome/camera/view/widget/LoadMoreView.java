package com.xiaomi.smarthome.camera.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class LoadMoreView extends FrameLayout {
    ProgressBar mProgressBar;
    TextView mTitleView;

    public LoadMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mProgressBar = (ProgressBar) findViewById(R.id.indeterminate_progress);
        this.mTitleView = (TextView) findViewById(R.id.title);
    }

    public void setLoadingData() {
        this.mProgressBar.setVisibility(0);
        this.mTitleView.setText((int) R.string.mj_loading);
    }

    public void setLoadingMore() {
        this.mProgressBar.setVisibility(8);
        this.mTitleView.setText((int) R.string.loading_more);
    }

    public void setLoadingNone() {
        this.mProgressBar.setVisibility(8);
        this.mTitleView.setText((int) R.string.alarm_none_data);
    }
}

package com.xiaomi.mico.common.editorbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class ActionBar extends FrameLayout {
    TextView mCancel;
    private Finishing mFinishing;
    TextView mSelect;
    private Selector mSelector;
    TextView mTitle;

    public ActionBar(Context context) {
        super(context);
    }

    public ActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mTitle = (TextView) findViewById(R.id.action_bar_title);
        this.mCancel = (TextView) findViewById(R.id.action_bar_cancel);
        this.mCancel.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.editorbar.$$Lambda$ActionBar$N6MWG_CwXdTwmxhKZNEg_chFqgA */

            public final void onClick(View view) {
                ActionBar.this.lambda$onFinishInflate$0$ActionBar(view);
            }
        });
        this.mSelect = (TextView) findViewById(R.id.action_bar_select);
        this.mSelect.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.editorbar.$$Lambda$ActionBar$Babi94H90AkUdfKMxps40vczt2E */

            public final void onClick(View view) {
                ActionBar.this.lambda$onFinishInflate$1$ActionBar(view);
            }
        });
    }

    /* renamed from: onClick */
    public void lambda$onFinishInflate$1$ActionBar(View view) {
        int id = view.getId();
        if (id == R.id.action_bar_cancel) {
            Finishing finishing = this.mFinishing;
            if (finishing != null) {
                finishing.finishAction();
            }
        } else if (id != R.id.action_bar_select) {
        } else {
            if (this.mSelector.getSelectedCount() < this.mSelector.getTotalCount()) {
                this.mSelector.selectAll();
            } else {
                this.mSelector.selectNone();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setFinishing(Finishing finishing) {
        this.mFinishing = finishing;
    }

    /* access modifiers changed from: package-private */
    public void setSelector(Selector selector) {
        this.mSelector = selector;
    }

    /* access modifiers changed from: package-private */
    public void onCountChange(int i, int i2) {
        updateStatus(i, i2);
    }

    /* access modifiers changed from: package-private */
    public void startAction() {
        updateStatus(this.mSelector.getSelectedCount(), this.mSelector.getTotalCount());
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.mico_action_bar_in));
    }

    /* access modifiers changed from: package-private */
    public void finishAction() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.mico_action_bar_out));
    }

    private void updateStatus(int i, int i2) {
        if (i == 0) {
            this.mTitle.setText((int) R.string.common_select_0);
        } else {
            this.mTitle.setText(getContext().getResources().getQuantityString(R.plurals.common_select_n, i, Integer.valueOf(i)));
        }
        if (i < i2) {
            this.mSelect.setText((int) R.string.common_select_all);
        } else {
            this.mSelect.setText((int) R.string.common_select_none);
        }
    }
}

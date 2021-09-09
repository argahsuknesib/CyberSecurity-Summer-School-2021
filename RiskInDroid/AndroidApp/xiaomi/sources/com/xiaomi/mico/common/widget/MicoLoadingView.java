package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.smarthome.R;

public class MicoLoadingView extends RelativeLayout {
    protected Button mButton;
    protected TextView mError;
    protected View mErrorContainer;
    protected View mProgressContainer;

    public MicoLoadingView(Context context) {
        super(context);
        init(context, null);
    }

    public MicoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.mico.common.widget.MicoLoadingView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate((int) R.layout.mico_loading_view, (ViewGroup) this, true);
        this.mProgressContainer = findViewById(R.id.mico_loadingview_progress_container);
        this.mErrorContainer = findViewById(R.id.mico_loadingview_txtcontainer);
        this.mError = (TextView) findViewById(R.id.mico_loadingview_txterror);
        this.mButton = (Button) findViewById(R.id.mico_loadingview_button);
        this.mProgressContainer.setVisibility(8);
        this.mErrorContainer.setVisibility(8);
        if (isInEditMode()) {
            setVisibility(8);
        }
    }

    public void startLoading(boolean z, boolean z2) {
        this.mProgressContainer.setVisibility(z ? 0 : 8);
        if (z) {
            updateProgressStyle(z2);
        }
    }

    public void stopLoading() {
        this.mProgressContainer.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void updateProgressStyle(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(z ? 13 : 12);
        this.mProgressContainer.setLayoutParams(layoutParams);
    }

    public void showErrorWithActionButton(String str, String str2, Handler.Callback callback) {
        if (getContext() != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getContext().getString(R.string.common_reload);
            }
            showError(str, false, str2, callback);
        }
    }

    private void showError(String str, boolean z, String str2, final Handler.Callback callback) {
        this.mProgressContainer.setVisibility(8);
        if (z) {
            this.mErrorContainer.setVisibility(8);
            ToastUtil.showToast(str);
            return;
        }
        this.mErrorContainer.setVisibility(0);
        this.mError.setText(str);
        if (callback != null) {
            this.mButton.setVisibility(0);
            this.mButton.setText(str2);
            this.mButton.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.common.widget.MicoLoadingView.AnonymousClass1 */

                public void onClick(View view) {
                    callback.handleMessage(null);
                }
            });
            return;
        }
        this.mButton.setVisibility(8);
    }
}

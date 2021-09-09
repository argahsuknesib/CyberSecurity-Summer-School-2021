package com.mibi.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class SimpleProgressDialog extends Dialog {
    private TextView mMessageView;
    private ImageView mProgressStatus;

    public SimpleProgressDialog(Context context) {
        super(context, -1);
        init();
    }

    private void init() {
        Log.d("SimpleProgressDialog", "init");
        Window window = getWindow();
        if (window != null) {
            window.setGravity(81);
            int dimension = (int) getContext().getResources().getDimension(R.dimen.mibi_simple_progress_dialog_padding);
            window.setLayout(-1, (int) getContext().getResources().getDimension(R.dimen.mibi_simple_progress_dialog_height));
            window.getDecorView().setPadding(dimension, 0, dimension, dimension);
            window.setWindowAnimations(2132738439);
            View findViewById = window.getDecorView().findViewById(16908310);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
        setCanceledOnTouchOutside(false);
        View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.mibi_simple_dialog_progress, (ViewGroup) null);
        this.mMessageView = (TextView) inflate.findViewById(R.id.mibi_message);
        this.mProgressStatus = (ImageView) inflate.findViewById(R.id.progress_circle);
        setContentView(inflate);
    }

    private Animation createProgressAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        return rotateAnimation;
    }

    public void show() {
        super.show();
        this.mProgressStatus.startAnimation(createProgressAnimation());
    }

    public void setMessage(String str) {
        this.mMessageView.setText(str);
    }
}

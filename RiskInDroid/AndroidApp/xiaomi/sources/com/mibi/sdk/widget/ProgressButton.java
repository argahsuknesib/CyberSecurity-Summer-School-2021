package com.mibi.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;

public class ProgressButton extends FrameLayout {
    private Animation mAnimation;
    private Button mButton;
    private ImageView mProgressCircleView;

    public interface IOnClickListener {
        void onClick(View view);
    }

    public ProgressButton(Context context) {
        this(context, null);
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843067, R.attr.btnText});
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.mibi_progress_button, this);
        this.mButton = (Button) inflate.findViewById(R.id.button);
        this.mProgressCircleView = (ImageView) inflate.findViewById(R.id.progress_circle);
        if (!TextUtils.isEmpty(string)) {
            this.mButton.setText(string);
        }
        this.mAnimation = createProgressAnimation();
    }

    public void startProgress() {
        this.mButton.setVisibility(4);
        this.mProgressCircleView.setVisibility(0);
        this.mProgressCircleView.startAnimation(this.mAnimation);
    }

    public void stopProgress() {
        this.mButton.setVisibility(0);
        this.mProgressCircleView.setVisibility(4);
        this.mProgressCircleView.clearAnimation();
    }

    public void setText(CharSequence charSequence) {
        this.mButton.setText(charSequence);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new IllegalStateException("should not use this method,use setClickListener instead");
    }

    public void setClickListener(final IOnClickListener iOnClickListener) {
        this.mButton.setOnClickListener(new View.OnClickListener() {
            /* class com.mibi.sdk.widget.ProgressButton.AnonymousClass1 */

            public void onClick(View view) {
                iOnClickListener.onClick(view);
            }
        });
    }

    private Animation createProgressAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        return rotateAnimation;
    }
}

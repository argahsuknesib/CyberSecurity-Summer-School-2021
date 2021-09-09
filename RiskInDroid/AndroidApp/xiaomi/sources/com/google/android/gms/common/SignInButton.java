package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.dynamic.RemoteCreator;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements View.OnClickListener {
    private int mColor;
    private int mSize;
    private View zzbw;
    private View.OnClickListener zzbx;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbx = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.buttonSize, R.attr.colorScheme, R.attr.scopeUris}, 0, 0);
        try {
            this.mSize = obtainStyledAttributes.getInt(0, 0);
            this.mColor = obtainStyledAttributes.getInt(1, 2);
            obtainStyledAttributes.recycle();
            setStyle(this.mSize, this.mColor);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.zzbx;
        if (onClickListener != null && view == this.zzbw) {
            onClickListener.onClick(this);
        }
    }

    public final void setColorScheme(int i) {
        setStyle(this.mSize, i);
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.zzbw.setEnabled(z);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzbx = onClickListener;
        View view = this.zzbw;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        setStyle(this.mSize, this.mColor);
    }

    public final void setSize(int i) {
        setStyle(i, this.mColor);
    }

    public final void setStyle(int i, int i2) {
        this.mSize = i;
        this.mColor = i2;
        Context context = getContext();
        View view = this.zzbw;
        if (view != null) {
            removeView(view);
        }
        try {
            this.zzbw = SignInButtonCreator.createView(context, this.mSize, this.mColor);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i3 = this.mSize;
            int i4 = this.mColor;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            signInButtonImpl.configure(context.getResources(), i3, i4);
            this.zzbw = signInButtonImpl;
        }
        addView(this.zzbw);
        this.zzbw.setEnabled(isEnabled());
        this.zzbw.setOnClickListener(this);
    }

    @Deprecated
    public final void setStyle(int i, int i2, Scope[] scopeArr) {
        setStyle(i, i2);
    }
}

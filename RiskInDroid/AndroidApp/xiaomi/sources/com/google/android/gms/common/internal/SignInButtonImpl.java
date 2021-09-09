package com.google.android.gms.common.internal;

import _m_j.ab;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.common.util.DeviceProperties;
import com.xiaomi.smarthome.R;

public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, null);
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private static int zza(int i, int i2, int i3, int i4) {
        if (i == 0) {
            return i2;
        }
        if (i == 1) {
            return i3;
        }
        if (i == 2) {
            return i4;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unknown color scheme: ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    public final void configure(Resources resources, int i, int i2) {
        int i3;
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i4 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i4);
        setMinWidth(i4);
        int zza = zza(i2, R.drawable.common_google_signin_btn_icon_dark, R.drawable.common_google_signin_btn_icon_light, R.drawable.common_google_signin_btn_icon_light);
        int zza2 = zza(i2, R.drawable.common_google_signin_btn_text_dark, R.drawable.common_google_signin_btn_text_light, R.drawable.common_google_signin_btn_text_light);
        if (i == 0 || i == 1) {
            zza = zza2;
        } else if (i != 2) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Unknown button size: ");
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        }
        Drawable O00000oo = ab.O00000oo(resources.getDrawable(zza));
        ab.O000000o(O00000oo, resources.getColorStateList(R.color.common_google_signin_btn_tint));
        ab.O000000o(O00000oo, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(O00000oo);
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zza(i2, R.color.common_google_signin_btn_text_dark, R.color.common_google_signin_btn_text_light, R.color.common_google_signin_btn_text_light))));
        if (i == 0) {
            i3 = R.string.common_signin_button_text;
        } else if (i == 1) {
            i3 = R.string.common_signin_button_text_long;
        } else if (i == 2) {
            setText((CharSequence) null);
            setTransformationMethod(null);
            if (!DeviceProperties.isWearable(getContext())) {
                setGravity(19);
                return;
            }
            return;
        } else {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Unknown button size: ");
            sb2.append(i);
            throw new IllegalStateException(sb2.toString());
        }
        setText(resources.getString(i3));
        setTransformationMethod(null);
        if (!DeviceProperties.isWearable(getContext())) {
        }
    }

    public final void configure(Resources resources, SignInButtonConfig signInButtonConfig) {
        configure(resources, signInButtonConfig.getButtonSize(), signInButtonConfig.getColorScheme());
    }
}

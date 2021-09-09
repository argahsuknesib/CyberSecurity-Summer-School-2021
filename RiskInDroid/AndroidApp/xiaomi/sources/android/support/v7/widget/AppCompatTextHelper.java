package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.text.AllCapsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

@TargetApi(9)
@RequiresApi(9)
class AppCompatTextHelper {
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableTopTint;
    final TextView mView;

    static AppCompatTextHelper create(TextView textView) {
        if (Build.VERSION.SDK_INT >= 17) {
            return new AppCompatTextHelperV17(textView);
        }
        return new AppCompatTextHelper(textView);
    }

    AppCompatTextHelper(TextView textView) {
        this.mView = textView;
    }

    /* access modifiers changed from: package-private */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        boolean z;
        ColorStateList colorStateList;
        boolean z2;
        boolean z3;
        AttributeSet attributeSet2 = attributeSet;
        int i2 = i;
        Context context = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet2, new int[]{16842804, 16843117, 16843118, 16843119, 16843120, 16843666, 16843667}, i2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(3)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(4, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(2, 0));
        }
        obtainStyledAttributes.recycle();
        boolean z4 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        ColorStateList colorStateList2 = null;
        if (resourceId != -1) {
            TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, resourceId, new int[]{16842901, 16842902, 16842903, 16842904, 16842906, 16842907, 16843105, 16843106, 16843107, 16843108, 16843692, 16844165, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.textAllCaps, R.attr.textLocale});
            if (z4 || !obtainStyledAttributes2.hasValue(14)) {
                z2 = false;
                z = false;
            } else {
                z = obtainStyledAttributes2.getBoolean(14, false);
                z2 = true;
            }
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList colorStateList3 = obtainStyledAttributes2.hasValue(3) ? obtainStyledAttributes2.getColorStateList(3) : null;
                if (obtainStyledAttributes2.hasValue(4)) {
                    colorStateList2 = obtainStyledAttributes2.getColorStateList(4);
                }
                ColorStateList colorStateList4 = colorStateList2;
                colorStateList2 = colorStateList3;
                colorStateList = colorStateList4;
            } else {
                colorStateList = null;
            }
            obtainStyledAttributes2.recycle();
        } else {
            colorStateList = null;
            z2 = false;
            z = false;
        }
        TintTypedArray obtainStyledAttributes3 = TintTypedArray.obtainStyledAttributes(context, attributeSet2, new int[]{16842901, 16842902, 16842903, 16842904, 16842906, 16842907, 16843105, 16843106, 16843107, 16843108, 16843692, 16844165, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.textAllCaps, R.attr.textLocale}, i2, 0);
        if (z4 || !obtainStyledAttributes3.hasValue(14)) {
            z3 = z2;
        } else {
            z = obtainStyledAttributes3.getBoolean(14, false);
            z3 = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (obtainStyledAttributes3.hasValue(3)) {
                colorStateList2 = obtainStyledAttributes3.getColorStateList(3);
            }
            if (obtainStyledAttributes3.hasValue(4)) {
                colorStateList = obtainStyledAttributes3.getColorStateList(4);
            }
        }
        obtainStyledAttributes3.recycle();
        if (colorStateList2 != null) {
            this.mView.setTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.mView.setHintTextColor(colorStateList);
        }
        if (!z4 && z3) {
            setAllCaps(z);
        }
    }

    /* access modifiers changed from: package-private */
    public void onSetTextAppearance(Context context, int i) {
        ColorStateList colorStateList;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, new int[]{16842901, 16842902, 16842903, 16842904, 16842906, 16842907, 16843105, 16843106, 16843107, 16843108, 16843692, 16844165, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.textAllCaps, R.attr.textLocale});
        if (obtainStyledAttributes.hasValue(14)) {
            setAllCaps(obtainStyledAttributes.getBoolean(14, false));
        }
        if (Build.VERSION.SDK_INT < 23 && obtainStyledAttributes.hasValue(3) && (colorStateList = obtainStyledAttributes.getColorStateList(3)) != null) {
            this.mView.setTextColor(colorStateList);
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public void setAllCaps(boolean z) {
        TextView textView = this.mView;
        textView.setTransformationMethod(z ? new AllCapsTransformationMethod(textView.getContext()) : null);
    }

    /* access modifiers changed from: package-private */
    public void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
    }

    /* access modifiers changed from: package-private */
    public final void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    protected static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList tintList = appCompatDrawableManager.getTintList(context, i);
        if (tintList == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }
}

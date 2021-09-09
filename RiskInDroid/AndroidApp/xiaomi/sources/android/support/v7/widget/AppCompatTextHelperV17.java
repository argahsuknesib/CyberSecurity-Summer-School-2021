package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

@TargetApi(17)
@RequiresApi(17)
class AppCompatTextHelperV17 extends AppCompatTextHelper {
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableStartTint;

    AppCompatTextHelperV17(TextView textView) {
        super(textView);
    }

    /* access modifiers changed from: package-private */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, i);
        Context context = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842804, 16843117, 16843118, 16843119, 16843120, 16843666, 16843667}, i, 0);
        if (obtainStyledAttributes.hasValue(5)) {
            this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(5, 0));
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(6, 0));
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public void applyCompoundDrawablesTints() {
        super.applyCompoundDrawablesTints();
        if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
            applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
        }
    }
}

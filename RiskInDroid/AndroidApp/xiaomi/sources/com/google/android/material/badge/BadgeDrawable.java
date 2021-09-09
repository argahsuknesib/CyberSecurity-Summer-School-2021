package com.google.android.material.badge;

import _m_j.cb;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    private static final int DEFAULT_STYLE = 2132739099;
    private static final int DEFAULT_THEME_ATTR = 2131820655;
    private WeakReference<View> anchorViewRef;
    private final Rect badgeBounds = new Rect();
    private float badgeCenterX;
    private float badgeCenterY;
    private final float badgeRadius;
    private final float badgeWidePadding;
    private final float badgeWithTextRadius;
    private final WeakReference<Context> contextRef;
    private float cornerRadius;
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;
    private final SavedState savedState;
    private final MaterialShapeDrawable shapeDrawable = new MaterialShapeDrawable();
    private final TextDrawableHelper textDrawableHelper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        return false;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.google.android.material.badge.BadgeDrawable.SavedState.AnonymousClass1 */

            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int alpha = 255;
        public int backgroundColor;
        public int badgeGravity;
        public int badgeTextColor;
        public int contentDescriptionExceedsMaxBadgeNumberRes;
        public CharSequence contentDescriptionNumberless;
        public int contentDescriptionQuantityStrings;
        public int horizontalOffset;
        public boolean isVisible;
        public int maxCharacterCount;
        public int number = -1;
        public int verticalOffset;

        public final int describeContents() {
            return 0;
        }

        public SavedState(Context context) {
            this.badgeTextColor = new TextAppearance(context, 2132738763).textColor.getDefaultColor();
            this.contentDescriptionNumberless = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = R.plurals.mtrl_badge_content_description;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R.string.mtrl_exceed_max_badge_number_content_description;
            this.isVisible = true;
        }

        protected SavedState(Parcel parcel) {
            this.backgroundColor = parcel.readInt();
            this.badgeTextColor = parcel.readInt();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = parcel.readInt();
            this.horizontalOffset = parcel.readInt();
            this.verticalOffset = parcel.readInt();
            this.isVisible = parcel.readInt() != 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeString(this.contentDescriptionNumberless.toString());
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeInt(this.badgeGravity);
            parcel.writeInt(this.horizontalOffset);
            parcel.writeInt(this.verticalOffset);
            parcel.writeInt(this.isVisible ? 1 : 0);
        }
    }

    public SavedState getSavedState() {
        return this.savedState;
    }

    static BadgeDrawable createFromSavedState(Context context, SavedState savedState2) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.restoreFromSavedState(savedState2);
        return badgeDrawable;
    }

    public static BadgeDrawable create(Context context) {
        return createFromAttributes(context, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    public static BadgeDrawable createFromResource(Context context, int i) {
        AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i, "badge");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = DEFAULT_STYLE;
        }
        return createFromAttributes(context, parseDrawableXml, DEFAULT_THEME_ATTR, styleAttribute);
    }

    private static BadgeDrawable createFromAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.loadDefaultStateFromAttributes(context, attributeSet, i, i2);
        return badgeDrawable;
    }

    public void setVisible(boolean z) {
        setVisible(z, false);
        this.savedState.isVisible = z;
        if (BadgeUtils.USE_COMPAT_PARENT && getCustomBadgeParent() != null && !z) {
            ((ViewGroup) getCustomBadgeParent().getParent()).invalidate();
        }
    }

    private void restoreFromSavedState(SavedState savedState2) {
        setMaxCharacterCount(savedState2.maxCharacterCount);
        if (savedState2.number != -1) {
            setNumber(savedState2.number);
        }
        setBackgroundColor(savedState2.backgroundColor);
        setBadgeTextColor(savedState2.badgeTextColor);
        setBadgeGravity(savedState2.badgeGravity);
        setHorizontalOffset(savedState2.horizontalOffset);
        setVerticalOffset(savedState2.verticalOffset);
        setVisible(savedState2.isVisible);
    }

    private void loadDefaultStateFromAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, new int[]{R.attr.backgroundColor, R.attr.badgeGravity, R.attr.badgeTextColor, R.attr.horizontalOffset, R.attr.maxCharacterCount, R.attr.number, R.attr.verticalOffset}, i, i2, new int[0]);
        setMaxCharacterCount(obtainStyledAttributes.getInt(4, 4));
        if (obtainStyledAttributes.hasValue(5)) {
            setNumber(obtainStyledAttributes.getInt(5, 0));
        }
        setBackgroundColor(readColorFromAttributes(context, obtainStyledAttributes, 0));
        if (obtainStyledAttributes.hasValue(2)) {
            setBadgeTextColor(readColorFromAttributes(context, obtainStyledAttributes, 2));
        }
        setBadgeGravity(obtainStyledAttributes.getInt(1, 8388661));
        setHorizontalOffset(obtainStyledAttributes.getDimensionPixelOffset(3, 0));
        setVerticalOffset(obtainStyledAttributes.getDimensionPixelOffset(6, 0));
        obtainStyledAttributes.recycle();
    }

    private static int readColorFromAttributes(Context context, TypedArray typedArray, int i) {
        return MaterialResources.getColorStateList(context, typedArray, i).getDefaultColor();
    }

    private BadgeDrawable(Context context) {
        this.contextRef = new WeakReference<>(context);
        ThemeEnforcement.checkMaterialTheme(context);
        Resources resources = context.getResources();
        this.badgeRadius = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.badgeWidePadding = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.badgeWithTextRadius = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        this.textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
        this.savedState = new SavedState(context);
        setTextAppearanceResource(2132738763);
    }

    @Deprecated
    public void updateBadgeCoordinates(View view, ViewGroup viewGroup) {
        if (viewGroup instanceof FrameLayout) {
            updateBadgeCoordinates(view, (FrameLayout) viewGroup);
            return;
        }
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void updateBadgeCoordinates(View view) {
        updateBadgeCoordinates(view, (FrameLayout) null);
    }

    public void updateBadgeCoordinates(View view, FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference<>(view);
        if (!BadgeUtils.USE_COMPAT_PARENT || frameLayout != null) {
            this.customBadgeParentRef = new WeakReference<>(frameLayout);
        } else {
            tryWrapAnchorInCompatParent(view);
        }
        if (!BadgeUtils.USE_COMPAT_PARENT) {
            updateAnchorParentToNotClip(view);
        }
        updateCenterAndBounds();
        invalidateSelf();
    }

    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void tryWrapAnchorInCompatParent(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
            if (weakReference == null || weakReference.get() != viewGroup) {
                updateAnchorParentToNotClip(view);
                final FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R.id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, indexOfChild);
                this.customBadgeParentRef = new WeakReference<>(frameLayout);
                frameLayout.post(new Runnable() {
                    /* class com.google.android.material.badge.BadgeDrawable.AnonymousClass1 */

                    public void run() {
                        BadgeDrawable.this.updateBadgeCoordinates(view, frameLayout);
                    }
                });
            }
        }
    }

    private static void updateAnchorParentToNotClip(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public void setBackgroundColor(int i) {
        this.savedState.backgroundColor = i;
        ColorStateList valueOf = ColorStateList.valueOf(i);
        if (this.shapeDrawable.getFillColor() != valueOf) {
            this.shapeDrawable.setFillColor(valueOf);
            invalidateSelf();
        }
    }

    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    public void setBadgeTextColor(int i) {
        this.savedState.badgeTextColor = i;
        if (this.textDrawableHelper.getTextPaint().getColor() != i) {
            this.textDrawableHelper.getTextPaint().setColor(i);
            invalidateSelf();
        }
    }

    public boolean hasNumber() {
        return this.savedState.number != -1;
    }

    public int getNumber() {
        if (!hasNumber()) {
            return 0;
        }
        return this.savedState.number;
    }

    public void setNumber(int i) {
        int max = Math.max(0, i);
        if (this.savedState.number != max) {
            this.savedState.number = max;
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public void clearNumber() {
        this.savedState.number = -1;
        invalidateSelf();
    }

    public int getMaxCharacterCount() {
        return this.savedState.maxCharacterCount;
    }

    public void setMaxCharacterCount(int i) {
        if (this.savedState.maxCharacterCount != i) {
            this.savedState.maxCharacterCount = i;
            updateMaxBadgeNumber();
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public int getBadgeGravity() {
        return this.savedState.badgeGravity;
    }

    public void setBadgeGravity(int i) {
        if (this.savedState.badgeGravity != i) {
            this.savedState.badgeGravity = i;
            WeakReference<View> weakReference = this.anchorViewRef;
            if (weakReference != null && weakReference.get() != null) {
                View view = this.anchorViewRef.get();
                WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
                updateBadgeCoordinates(view, weakReference2 != null ? weakReference2.get() : null);
            }
        }
    }

    public int getAlpha() {
        return this.savedState.alpha;
    }

    public void setAlpha(int i) {
        this.savedState.alpha = i;
        this.textDrawableHelper.getTextPaint().setAlpha(i);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.shapeDrawable.draw(canvas);
            if (hasNumber()) {
                drawText(canvas);
            }
        }
    }

    public void onTextSizeChange() {
        invalidateSelf();
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void setContentDescriptionNumberless(CharSequence charSequence) {
        this.savedState.contentDescriptionNumberless = charSequence;
    }

    public void setContentDescriptionQuantityStringsResource(int i) {
        this.savedState.contentDescriptionQuantityStrings = i;
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(int i) {
        this.savedState.contentDescriptionExceedsMaxBadgeNumberRes = i;
    }

    public CharSequence getContentDescription() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!hasNumber()) {
            return this.savedState.contentDescriptionNumberless;
        }
        if (this.savedState.contentDescriptionQuantityStrings <= 0 || (context = this.contextRef.get()) == null) {
            return null;
        }
        if (getNumber() <= this.maxBadgeNumber) {
            return context.getResources().getQuantityString(this.savedState.contentDescriptionQuantityStrings, getNumber(), Integer.valueOf(getNumber()));
        }
        return context.getString(this.savedState.contentDescriptionExceedsMaxBadgeNumberRes, Integer.valueOf(this.maxBadgeNumber));
    }

    public void setHorizontalOffset(int i) {
        this.savedState.horizontalOffset = i;
        updateCenterAndBounds();
    }

    public int getHorizontalOffset() {
        return this.savedState.horizontalOffset;
    }

    public void setVerticalOffset(int i) {
        this.savedState.verticalOffset = i;
        updateCenterAndBounds();
    }

    public int getVerticalOffset() {
        return this.savedState.verticalOffset;
    }

    private void setTextAppearanceResource(int i) {
        Context context = this.contextRef.get();
        if (context != null) {
            setTextAppearance(new TextAppearance(context, i));
        }
    }

    private void setTextAppearance(TextAppearance textAppearance) {
        Context context;
        if (this.textDrawableHelper.getTextAppearance() != textAppearance && (context = this.contextRef.get()) != null) {
            this.textDrawableHelper.setTextAppearance(textAppearance, context);
            updateCenterAndBounds();
        }
    }

    private void updateCenterAndBounds() {
        Context context = this.contextRef.get();
        WeakReference<View> weakReference = this.anchorViewRef;
        ViewGroup viewGroup = null;
        View view = weakReference != null ? weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.badgeBounds);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
            if (weakReference2 != null) {
                viewGroup = weakReference2.get();
            }
            if (viewGroup != null || BadgeUtils.USE_COMPAT_PARENT) {
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) view.getParent();
                }
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            calculateCenterAndBounds(context, rect2, view);
            BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
            this.shapeDrawable.setCornerSize(this.cornerRadius);
            if (!rect.equals(this.badgeBounds)) {
                this.shapeDrawable.setBounds(this.badgeBounds);
            }
        }
    }

    private void calculateCenterAndBounds(Context context, Rect rect, View view) {
        float f;
        float f2;
        int i = this.savedState.badgeGravity;
        if (i == 8388691 || i == 8388693) {
            this.badgeCenterY = (float) (rect.bottom - this.savedState.verticalOffset);
        } else {
            this.badgeCenterY = (float) (rect.top + this.savedState.verticalOffset);
        }
        if (getNumber() <= 9) {
            this.cornerRadius = !hasNumber() ? this.badgeRadius : this.badgeWithTextRadius;
            float f3 = this.cornerRadius;
            this.halfBadgeHeight = f3;
            this.halfBadgeWidth = f3;
        } else {
            this.cornerRadius = this.badgeWithTextRadius;
            this.halfBadgeHeight = this.cornerRadius;
            this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.badgeWidePadding;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(hasNumber() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
        int i2 = this.savedState.badgeGravity;
        if (i2 == 8388659 || i2 == 8388691) {
            if (cb.O0000Oo0(view) == 0) {
                f = (((float) rect.left) - this.halfBadgeWidth) + ((float) dimensionPixelSize) + ((float) this.savedState.horizontalOffset);
            } else {
                f = ((((float) rect.right) + this.halfBadgeWidth) - ((float) dimensionPixelSize)) - ((float) this.savedState.horizontalOffset);
            }
            this.badgeCenterX = f;
            return;
        }
        if (cb.O0000Oo0(view) == 0) {
            f2 = ((((float) rect.right) + this.halfBadgeWidth) - ((float) dimensionPixelSize)) - ((float) this.savedState.horizontalOffset);
        } else {
            f2 = (((float) rect.left) - this.halfBadgeWidth) + ((float) dimensionPixelSize) + ((float) this.savedState.horizontalOffset);
        }
        this.badgeCenterX = f2;
    }

    private void drawText(Canvas canvas) {
        Rect rect = new Rect();
        String badgeText = getBadgeText();
        this.textDrawableHelper.getTextPaint().getTextBounds(badgeText, 0, badgeText.length(), rect);
        canvas.drawText(badgeText, this.badgeCenterX, this.badgeCenterY + ((float) (rect.height() / 2)), this.textDrawableHelper.getTextPaint());
    }

    private String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) {
            return NumberFormat.getInstance().format((long) getNumber());
        }
        Context context = this.contextRef.get();
        if (context == null) {
            return "";
        }
        return context.getString(R.string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.maxBadgeNumber), "+");
    }

    private void updateMaxBadgeNumber() {
        double maxCharacterCount = (double) getMaxCharacterCount();
        Double.isNaN(maxCharacterCount);
        this.maxBadgeNumber = ((int) Math.pow(10.0d, maxCharacterCount - 1.0d)) - 1;
    }
}

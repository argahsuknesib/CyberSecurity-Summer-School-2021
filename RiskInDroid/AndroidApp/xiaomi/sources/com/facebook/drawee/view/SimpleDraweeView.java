package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequest;
import com.xiaomi.smarthome.R;

public class SimpleDraweeView extends GenericDraweeView {
    private static Supplier<? extends AbstractDraweeControllerBuilder> sDraweecontrollerbuildersupplier;
    private AbstractDraweeControllerBuilder mControllerBuilder;

    public static void initialize(Supplier<? extends AbstractDraweeControllerBuilder> supplier) {
        sDraweecontrollerbuildersupplier = supplier;
    }

    public static void shutDown() {
        sDraweecontrollerbuildersupplier = null;
    }

    public SimpleDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        init(context, null);
    }

    public SimpleDraweeView(Context context) {
        super(context);
        init(context, null);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    @TargetApi(21)
    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int resourceId;
        if (!isInEditMode()) {
            Preconditions.checkNotNull(sDraweecontrollerbuildersupplier, "SimpleDraweeView was not initialized!");
            this.mControllerBuilder = (AbstractDraweeControllerBuilder) sDraweecontrollerbuildersupplier.get();
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.actualImageResource, R.attr.actualImageScaleType, R.attr.actualImageUri, R.attr.backgroundImage, R.attr.fadeDuration, R.attr.failureImage, R.attr.failureImageScaleType, R.attr.overlayImage, R.attr.placeholderImage, R.attr.placeholderImageScaleType, R.attr.pressedStateOverlayImage, R.attr.progressBarAutoRotateInterval, R.attr.progressBarImage, R.attr.progressBarImageScaleType, R.attr.retryImage, R.attr.retryImageScaleType, R.attr.roundAsCircle, R.attr.roundBottomEnd, R.attr.roundBottomLeft, R.attr.roundBottomRight, R.attr.roundBottomStart, R.attr.roundTopEnd, R.attr.roundTopLeft, R.attr.roundTopRight, R.attr.roundTopStart, R.attr.roundWithOverlayColor, R.attr.roundedCornerRadius, R.attr.roundingBorderColor, R.attr.roundingBorderPadding, R.attr.roundingBorderWidth, R.attr.viewAspectRatio});
                try {
                    if (obtainStyledAttributes.hasValue(2)) {
                        setImageURI(Uri.parse(obtainStyledAttributes.getString(2)), (Object) null);
                    } else if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, -1)) != -1) {
                        setActualImageResource(resourceId);
                    }
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.mControllerBuilder;
    }

    public void setImageRequest(ImageRequest imageRequest) {
        setController(this.mControllerBuilder.setImageRequest(imageRequest).setOldController(getController()).build());
    }

    public void setImageURI(Uri uri) {
        setImageURI(uri, (Object) null);
    }

    public void setImageURI(String str) {
        setImageURI(str, (Object) null);
    }

    public void setImageURI(Uri uri, Object obj) {
        setController(this.mControllerBuilder.setCallerContext(obj).setUri(uri).setOldController(getController()).build());
    }

    public void setImageURI(String str, Object obj) {
        setImageURI(str != null ? Uri.parse(str) : null, obj);
    }

    public void setActualImageResource(int i) {
        setActualImageResource(i, null);
    }

    public void setActualImageResource(int i, Object obj) {
        setImageURI(UriUtil.getUriForResourceId(i), obj);
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
    }
}

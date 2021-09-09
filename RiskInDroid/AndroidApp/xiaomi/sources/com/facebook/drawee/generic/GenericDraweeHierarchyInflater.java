package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.infer.annotation.ReturnsOwnership;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;

public class GenericDraweeHierarchyInflater {
    public static GenericDraweeHierarchy inflateHierarchy(Context context, AttributeSet attributeSet) {
        return inflateBuilder(context, attributeSet).build();
    }

    public static GenericDraweeHierarchyBuilder inflateBuilder(Context context, AttributeSet attributeSet) {
        return updateBuilder(new GenericDraweeHierarchyBuilder(context.getResources()), context, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    public static GenericDraweeHierarchyBuilder updateBuilder(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, Context context, AttributeSet attributeSet) {
        int i;
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        boolean z6;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = genericDraweeHierarchyBuilder;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        boolean z7 = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, new int[]{R.attr.actualImageScaleType, R.attr.backgroundImage, R.attr.fadeDuration, R.attr.failureImage, R.attr.failureImageScaleType, R.attr.overlayImage, R.attr.placeholderImage, R.attr.placeholderImageScaleType, R.attr.pressedStateOverlayImage, R.attr.progressBarAutoRotateInterval, R.attr.progressBarImage, R.attr.progressBarImageScaleType, R.attr.retryImage, R.attr.retryImageScaleType, R.attr.roundAsCircle, R.attr.roundBottomEnd, R.attr.roundBottomLeft, R.attr.roundBottomRight, R.attr.roundBottomStart, R.attr.roundTopEnd, R.attr.roundTopLeft, R.attr.roundTopRight, R.attr.roundTopStart, R.attr.roundWithOverlayColor, R.attr.roundedCornerRadius, R.attr.roundingBorderColor, R.attr.roundingBorderPadding, R.attr.roundingBorderWidth, R.attr.viewAspectRatio});
            try {
                int indexCount = obtainStyledAttributes.getIndexCount();
                i = 0;
                int i4 = 0;
                boolean z8 = true;
                boolean z9 = true;
                boolean z10 = true;
                boolean z11 = true;
                boolean z12 = true;
                boolean z13 = true;
                boolean z14 = true;
                boolean z15 = true;
                int i5 = 0;
                while (i4 < indexCount) {
                    int index = obtainStyledAttributes.getIndex(i4);
                    if (index == 0) {
                        genericDraweeHierarchyBuilder2.setActualImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                    } else if (index == 6) {
                        genericDraweeHierarchyBuilder2.setPlaceholderImage(getDrawable(context2, obtainStyledAttributes, index));
                    } else if (index == 8) {
                        genericDraweeHierarchyBuilder2.setPressedStateOverlay(getDrawable(context2, obtainStyledAttributes, index));
                    } else if (index == 10) {
                        genericDraweeHierarchyBuilder2.setProgressBarImage(getDrawable(context2, obtainStyledAttributes, index));
                    } else if (index == 2) {
                        genericDraweeHierarchyBuilder2.setFadeDuration(obtainStyledAttributes.getInt(index, z7 ? 1 : 0));
                    } else if (index == 28) {
                        genericDraweeHierarchyBuilder2.setDesiredAspectRatio(obtainStyledAttributes.getFloat(index, 0.0f));
                    } else if (index == 7) {
                        genericDraweeHierarchyBuilder2.setPlaceholderImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                    } else if (index == 12) {
                        genericDraweeHierarchyBuilder2.setRetryImage(getDrawable(context2, obtainStyledAttributes, index));
                    } else if (index == 13) {
                        genericDraweeHierarchyBuilder2.setRetryImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                    } else if (index == 3) {
                        genericDraweeHierarchyBuilder2.setFailureImage(getDrawable(context2, obtainStyledAttributes, index));
                    } else if (index == 4) {
                        genericDraweeHierarchyBuilder2.setFailureImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                    } else if (index == 11) {
                        genericDraweeHierarchyBuilder2.setProgressBarImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                    } else {
                        if (index == 9) {
                            i = obtainStyledAttributes.getInteger(index, i);
                        } else if (index == 1) {
                            genericDraweeHierarchyBuilder2.setBackground(getDrawable(context2, obtainStyledAttributes, index));
                        } else if (index == 5) {
                            genericDraweeHierarchyBuilder2.setOverlay(getDrawable(context2, obtainStyledAttributes, index));
                        } else if (index == 14) {
                            getRoundingParams(genericDraweeHierarchyBuilder).setRoundAsCircle(obtainStyledAttributes.getBoolean(index, z7));
                        } else if (index == 24) {
                            i5 = obtainStyledAttributes.getDimensionPixelSize(index, i5);
                        } else {
                            int i6 = i5;
                            if (index == 20) {
                                i5 = i6;
                                z8 = obtainStyledAttributes.getBoolean(index, z8);
                            } else if (index == 21) {
                                i5 = i6;
                                z10 = obtainStyledAttributes.getBoolean(index, z10);
                            } else if (index == 16) {
                                i5 = i6;
                                z14 = obtainStyledAttributes.getBoolean(index, z14);
                            } else if (index == 17) {
                                i5 = i6;
                                z12 = obtainStyledAttributes.getBoolean(index, z12);
                            } else if (index == 22) {
                                i5 = i6;
                                z9 = obtainStyledAttributes.getBoolean(index, z9);
                            } else if (index == 19) {
                                i5 = i6;
                                z11 = obtainStyledAttributes.getBoolean(index, z11);
                            } else {
                                if (index == 18) {
                                    z6 = obtainStyledAttributes.getBoolean(index, z15);
                                } else {
                                    z6 = z15;
                                    if (index == 15) {
                                        z13 = obtainStyledAttributes.getBoolean(index, z13);
                                    } else {
                                        if (index == 23) {
                                            i3 = i6;
                                            getRoundingParams(genericDraweeHierarchyBuilder).setOverlayColor(obtainStyledAttributes.getColor(index, 0));
                                        } else {
                                            i3 = i6;
                                            if (index == 27) {
                                                getRoundingParams(genericDraweeHierarchyBuilder).setBorderWidth((float) obtainStyledAttributes.getDimensionPixelSize(index, 0));
                                            } else if (index == 25) {
                                                getRoundingParams(genericDraweeHierarchyBuilder).setBorderColor(obtainStyledAttributes.getColor(index, 0));
                                            } else if (index == 26) {
                                                getRoundingParams(genericDraweeHierarchyBuilder).setPadding((float) obtainStyledAttributes.getDimensionPixelSize(index, 0));
                                                i5 = i3;
                                                z15 = z6;
                                                i4++;
                                                context2 = context;
                                                z7 = false;
                                            }
                                        }
                                        i5 = i3;
                                        z15 = z6;
                                        i4++;
                                        context2 = context;
                                        z7 = false;
                                    }
                                }
                                i5 = i6;
                                z15 = z6;
                            }
                        }
                        i4++;
                        context2 = context;
                        z7 = false;
                    }
                    z6 = z15;
                    i3 = i5;
                    i5 = i3;
                    z15 = z6;
                    i4++;
                    context2 = context;
                    z7 = false;
                }
                boolean z16 = z15;
                int i7 = i5;
                obtainStyledAttributes.recycle();
                if (Build.VERSION.SDK_INT >= 17) {
                    z5 = true;
                    if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
                        z = z8 && z11;
                        z4 = z10 && z9;
                        boolean z17 = z12 && z16;
                        if (!z14 || !z13) {
                            z5 = false;
                        }
                        i2 = i7;
                        boolean z18 = z17;
                        z2 = z5;
                        z3 = z18;
                    }
                } else {
                    z5 = true;
                }
                z = z8 && z9;
                z4 = z10 && z11;
                boolean z19 = z12 && z13;
                if (!z14 || !z16) {
                    z5 = false;
                }
                z2 = z5;
                z3 = z19;
                i2 = i7;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                if (Build.VERSION.SDK_INT >= 17) {
                    context.getResources().getConfiguration().getLayoutDirection();
                }
                throw th;
            }
        } else {
            z3 = true;
            i2 = 0;
            z4 = true;
            z2 = true;
            z = true;
            i = 0;
        }
        if (genericDraweeHierarchyBuilder.getProgressBarImage() != null && i > 0) {
            genericDraweeHierarchyBuilder2.setProgressBarImage(new AutoRotateDrawable(genericDraweeHierarchyBuilder.getProgressBarImage(), i));
        }
        if (i2 > 0) {
            getRoundingParams(genericDraweeHierarchyBuilder).setCornersRadii(z ? (float) i2 : 0.0f, z4 ? (float) i2 : 0.0f, z3 ? (float) i2 : 0.0f, z2 ? (float) i2 : 0.0f);
        }
        return genericDraweeHierarchyBuilder2;
    }

    @ReturnsOwnership
    private static RoundingParams getRoundingParams(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        if (genericDraweeHierarchyBuilder.getRoundingParams() == null) {
            genericDraweeHierarchyBuilder.setRoundingParams(new RoundingParams());
        }
        return genericDraweeHierarchyBuilder.getRoundingParams();
    }

    private static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    private static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                return ScalingUtils.ScaleType.FIT_XY;
            case 1:
                return ScalingUtils.ScaleType.FIT_START;
            case 2:
                return ScalingUtils.ScaleType.FIT_CENTER;
            case 3:
                return ScalingUtils.ScaleType.FIT_END;
            case 4:
                return ScalingUtils.ScaleType.CENTER;
            case 5:
                return ScalingUtils.ScaleType.CENTER_INSIDE;
            case 6:
                return ScalingUtils.ScaleType.CENTER_CROP;
            case 7:
                return ScalingUtils.ScaleType.FOCUS_CROP;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return ScalingUtils.ScaleType.FIT_BOTTOM_START;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }
}

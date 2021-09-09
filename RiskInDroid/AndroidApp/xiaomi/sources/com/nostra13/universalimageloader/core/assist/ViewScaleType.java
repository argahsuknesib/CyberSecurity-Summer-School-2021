package com.nostra13.universalimageloader.core.assist;

import android.widget.ImageView;

public enum ViewScaleType {
    FIT_INSIDE,
    CROP;

    /* renamed from: com.nostra13.universalimageloader.core.assist.ViewScaleType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5362O000000o = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f5362O000000o[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            f5362O000000o[ImageView.ScaleType.FIT_XY.ordinal()] = 2;
            f5362O000000o[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            f5362O000000o[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            f5362O000000o[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 5;
            f5362O000000o[ImageView.ScaleType.MATRIX.ordinal()] = 6;
            f5362O000000o[ImageView.ScaleType.CENTER.ordinal()] = 7;
            try {
                f5362O000000o[ImageView.ScaleType.CENTER_CROP.ordinal()] = 8;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static ViewScaleType fromImageView(ImageView imageView) {
        int i = AnonymousClass1.f5362O000000o[imageView.getScaleType().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            return FIT_INSIDE;
        }
        return CROP;
    }
}

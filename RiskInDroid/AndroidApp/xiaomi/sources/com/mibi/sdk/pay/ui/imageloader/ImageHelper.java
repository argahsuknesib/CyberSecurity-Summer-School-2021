package com.mibi.sdk.pay.ui.imageloader;

import android.content.Context;
import com.mibi.sdk.common.Utils;

public class ImageHelper {
    private static IImageLoader sImageLoader;

    private ImageHelper() {
    }

    public static String getAbsoluteUrl(String str) {
        return Utils.joinUrl("http://file.market.xiaomi.com/mfc/download/", str);
    }

    private static void checkImageLoader() {
        if (sImageLoader == null) {
            sImageLoader = new IImageLoaderImpl();
        }
    }

    public static void setImageLoader(IImageLoader iImageLoader) {
        sImageLoader = iImageLoader;
    }

    public static IImageLoader get(Context context) {
        checkImageLoader();
        return sImageLoader.get(context);
    }
}

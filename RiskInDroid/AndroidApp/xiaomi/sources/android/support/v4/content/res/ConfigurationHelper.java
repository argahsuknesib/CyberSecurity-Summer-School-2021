package android.support.v4.content.res;

import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;

public final class ConfigurationHelper {
    private static final ConfigurationHelperImpl IMPL;

    interface ConfigurationHelperImpl {
        int getDensityDpi(@NonNull Resources resources);

        int getScreenHeightDp(@NonNull Resources resources);

        int getScreenWidthDp(@NonNull Resources resources);

        int getSmallestScreenWidthDp(@NonNull Resources resources);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            IMPL = new JellybeanMr1Impl();
        } else if (i >= 13) {
            IMPL = new HoneycombMr2Impl();
        } else {
            IMPL = new GingerbreadImpl();
        }
    }

    private ConfigurationHelper() {
    }

    static class GingerbreadImpl implements ConfigurationHelperImpl {
        GingerbreadImpl() {
        }

        public int getScreenHeightDp(@NonNull Resources resources) {
            return ConfigurationHelperGingerbread.getScreenHeightDp(resources);
        }

        public int getScreenWidthDp(@NonNull Resources resources) {
            return ConfigurationHelperGingerbread.getScreenWidthDp(resources);
        }

        public int getSmallestScreenWidthDp(@NonNull Resources resources) {
            return ConfigurationHelperGingerbread.getSmallestScreenWidthDp(resources);
        }

        public int getDensityDpi(@NonNull Resources resources) {
            return ConfigurationHelperGingerbread.getDensityDpi(resources);
        }
    }

    static class HoneycombMr2Impl extends GingerbreadImpl {
        HoneycombMr2Impl() {
        }

        public int getScreenHeightDp(@NonNull Resources resources) {
            return ConfigurationHelperHoneycombMr2.getScreenHeightDp(resources);
        }

        public int getScreenWidthDp(@NonNull Resources resources) {
            return ConfigurationHelperHoneycombMr2.getScreenWidthDp(resources);
        }

        public int getSmallestScreenWidthDp(@NonNull Resources resources) {
            return ConfigurationHelperHoneycombMr2.getSmallestScreenWidthDp(resources);
        }
    }

    static class JellybeanMr1Impl extends HoneycombMr2Impl {
        JellybeanMr1Impl() {
        }

        public int getDensityDpi(@NonNull Resources resources) {
            return ConfigurationHelperJellybeanMr1.getDensityDpi(resources);
        }
    }

    public static int getScreenHeightDp(@NonNull Resources resources) {
        return IMPL.getScreenHeightDp(resources);
    }

    public static int getScreenWidthDp(@NonNull Resources resources) {
        return IMPL.getScreenWidthDp(resources);
    }

    public static int getSmallestScreenWidthDp(@NonNull Resources resources) {
        return IMPL.getSmallestScreenWidthDp(resources);
    }

    public static int getDensityDpi(@NonNull Resources resources) {
        return IMPL.getDensityDpi(resources);
    }
}

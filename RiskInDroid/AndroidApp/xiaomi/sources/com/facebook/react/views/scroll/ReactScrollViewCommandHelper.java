package com.facebook.react.views.scroll;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;

public class ReactScrollViewCommandHelper {

    public interface ScrollCommandHandler<T> {
        void flashScrollIndicators(Object obj);

        void scrollTo(Object obj, ScrollToCommandData scrollToCommandData);

        void scrollToEnd(Object obj, ScrollToEndCommandData scrollToEndCommandData);
    }

    public static class ScrollToCommandData {
        public final boolean mAnimated;
        public final int mDestX;
        public final int mDestY;

        ScrollToCommandData(int i, int i2, boolean z) {
            this.mDestX = i;
            this.mDestY = i2;
            this.mAnimated = z;
        }
    }

    public static class ScrollToEndCommandData {
        public final boolean mAnimated;

        ScrollToEndCommandData(boolean z) {
            this.mAnimated = z;
        }
    }

    public static Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("scrollTo", 1, "scrollToEnd", 2, "flashScrollIndicators", 3);
    }

    public static <T> void receiveCommand(ScrollCommandHandler scrollCommandHandler, Object obj, int i, ReadableArray readableArray) {
        Assertions.assertNotNull(scrollCommandHandler);
        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(readableArray);
        if (i == 1) {
            scrollTo(scrollCommandHandler, obj, readableArray);
        } else if (i == 2) {
            scrollToEnd(scrollCommandHandler, obj, readableArray);
        } else if (i == 3) {
            scrollCommandHandler.flashScrollIndicators(obj);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", Integer.valueOf(i), scrollCommandHandler.getClass().getSimpleName()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    public static <T> void receiveCommand(ScrollCommandHandler scrollCommandHandler, Object obj, String str, ReadableArray readableArray) {
        char c;
        Assertions.assertNotNull(scrollCommandHandler);
        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(readableArray);
        int hashCode = str.hashCode();
        if (hashCode != -402165208) {
            if (hashCode != 28425985) {
                if (hashCode == 2055114131 && str.equals("scrollToEnd")) {
                    c = 1;
                    if (c != 0) {
                        scrollTo(scrollCommandHandler, obj, readableArray);
                        return;
                    } else if (c == 1) {
                        scrollToEnd(scrollCommandHandler, obj, readableArray);
                        return;
                    } else if (c == 2) {
                        scrollCommandHandler.flashScrollIndicators(obj);
                        return;
                    } else {
                        throw new IllegalArgumentException(String.format("Unsupported command %s received by %s.", str, scrollCommandHandler.getClass().getSimpleName()));
                    }
                }
            } else if (str.equals("flashScrollIndicators")) {
                c = 2;
                if (c != 0) {
                }
            }
        } else if (str.equals("scrollTo")) {
            c = 0;
            if (c != 0) {
            }
        }
        c = 65535;
        if (c != 0) {
        }
    }

    private static <T> void scrollTo(ScrollCommandHandler<T> scrollCommandHandler, T t, ReadableArray readableArray) {
        scrollCommandHandler.scrollTo(t, new ScrollToCommandData(Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(0))), Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(1))), readableArray.getBoolean(2)));
    }

    private static <T> void scrollToEnd(ScrollCommandHandler<T> scrollCommandHandler, T t, ReadableArray readableArray) {
        scrollCommandHandler.scrollToEnd(t, new ScrollToEndCommandData(readableArray.getBoolean(0)));
    }
}

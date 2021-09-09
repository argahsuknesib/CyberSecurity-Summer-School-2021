package com.horcrux.svg;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;

class SvgViewModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "RNSVGSvgViewManager";
    }

    SvgViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public static void toDataURL(final int i, final ReadableMap readableMap, final Callback callback, final int i2) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.horcrux.svg.SvgViewModule.AnonymousClass1 */

            public final void run() {
                SvgView svgViewByTag = SvgViewManager.getSvgViewByTag(i);
                if (svgViewByTag == null) {
                    SvgViewManager.runWhenViewIsAvailable(i, new Runnable() {
                        /* class com.horcrux.svg.SvgViewModule.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            SvgView svgViewByTag = SvgViewManager.getSvgViewByTag(i);
                            if (svgViewByTag != null) {
                                svgViewByTag.setToDataUrlTask(new Runnable() {
                                    /* class com.horcrux.svg.SvgViewModule.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        SvgViewModule.toDataURL(i, readableMap, callback, i2 + 1);
                                    }
                                });
                            }
                        }
                    });
                } else if (svgViewByTag.notRendered()) {
                    svgViewByTag.setToDataUrlTask(new Runnable() {
                        /* class com.horcrux.svg.SvgViewModule.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            SvgViewModule.toDataURL(i, readableMap, callback, i2 + 1);
                        }
                    });
                } else {
                    ReadableMap readableMap = readableMap;
                    if (readableMap != null) {
                        callback.invoke(svgViewByTag.toDataURL(readableMap.getInt("width"), readableMap.getInt("height")));
                        return;
                    }
                    callback.invoke(svgViewByTag.toDataURL());
                }
            }
        });
    }

    @ReactMethod
    public void toDataURL(int i, ReadableMap readableMap, Callback callback) {
        toDataURL(i, readableMap, callback, 0);
    }
}

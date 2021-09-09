package com.airbnb.android.react.lottie;

import _m_j.cb;
import _m_j.nu;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import java.util.WeakHashMap;

public class LottieAnimationViewManager extends SimpleViewManager<LottieAnimationView> {
    private static final String TAG = "LottieAnimationViewManager";
    private Map<LottieAnimationView, nu> propManagersMap = new WeakHashMap();

    public String getName() {
        return "LottieAnimationView";
    }

    @ReactProp(name = "cacheStrategy")
    public void setCacheStrategy(LottieAnimationView lottieAnimationView, String str) {
    }

    public Map<String, Object> getExportedViewConstants() {
        return MapBuilder.builder().put("VERSION", 1).build();
    }

    public LottieAnimationView createViewInstance(ThemedReactContext themedReactContext) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(themedReactContext);
        lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return lottieAnimationView;
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("play", 1, "reset", 2);
    }

    public void receiveCommand(final LottieAnimationView lottieAnimationView, int i, final ReadableArray readableArray) {
        if (i == 1) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.airbnb.android.react.lottie.LottieAnimationViewManager.AnonymousClass1 */

                public final void run() {
                    int i = readableArray.getInt(0);
                    int i2 = readableArray.getInt(1);
                    if (!(i == -1 || i2 == -1)) {
                        lottieAnimationView.setMinAndMaxFrame(readableArray.getInt(0), readableArray.getInt(1));
                    }
                    if (cb.O000OO0o(lottieAnimationView)) {
                        lottieAnimationView.setProgress(0.0f);
                        lottieAnimationView.playAnimation();
                    }
                }
            });
        } else if (i == 2) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.airbnb.android.react.lottie.LottieAnimationViewManager.AnonymousClass2 */

                public final void run() {
                    if (cb.O000OO0o(lottieAnimationView)) {
                        lottieAnimationView.cancelAnimation();
                        lottieAnimationView.setProgress(0.0f);
                    }
                }
            });
        }
    }

    @ReactProp(name = "sourceName")
    public void setSourceName(LottieAnimationView lottieAnimationView, String str) {
        if (!TextUtils.isEmpty(str)) {
            nu orCreatePropertyManager = getOrCreatePropertyManager(lottieAnimationView);
            orCreatePropertyManager.O0000O0o = str;
            orCreatePropertyManager.O00000oo = true;
            return;
        }
        Log.e("LottieView", "warning! sourceName should not be empty(e.g: \"\")! skip setting!");
    }

    @ReactProp(name = "sourceJson")
    public void setSourceJson(LottieAnimationView lottieAnimationView, String str) {
        getOrCreatePropertyManager(lottieAnimationView).O00000Oo = str;
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(LottieAnimationView lottieAnimationView, String str) {
        ImageView.ScaleType scaleType;
        if ("cover".equals(str)) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        } else if ("contain".equals(str)) {
            scaleType = ImageView.ScaleType.CENTER_INSIDE;
        } else {
            scaleType = "center".equals(str) ? ImageView.ScaleType.CENTER : null;
        }
        getOrCreatePropertyManager(lottieAnimationView).O0000Oo0 = scaleType;
    }

    @ReactProp(name = "progress")
    public void setProgress(LottieAnimationView lottieAnimationView, float f) {
        getOrCreatePropertyManager(lottieAnimationView).O00000o0 = Float.valueOf(f);
    }

    @ReactProp(name = "speed")
    public void setSpeed(LottieAnimationView lottieAnimationView, double d) {
        getOrCreatePropertyManager(lottieAnimationView).O00000oO = Float.valueOf((float) d);
    }

    @ReactProp(name = "loop")
    public void setLoop(LottieAnimationView lottieAnimationView, boolean z) {
        getOrCreatePropertyManager(lottieAnimationView).O00000o = Boolean.valueOf(z);
    }

    @ReactProp(name = "hardwareAccelerationAndroid")
    public void setHardwareAcceleration(LottieAnimationView lottieAnimationView, boolean z) {
        getOrCreatePropertyManager(lottieAnimationView).O0000OOo = Boolean.valueOf(z);
    }

    @ReactProp(name = "imageAssetsFolder")
    public void setImageAssetsFolder(LottieAnimationView lottieAnimationView, String str) {
        getOrCreatePropertyManager(lottieAnimationView).O0000Oo = str;
    }

    @ReactProp(name = "enableMergePathsAndroidForKitKatAndAbove")
    public void setEnableMergePaths(LottieAnimationView lottieAnimationView, boolean z) {
        getOrCreatePropertyManager(lottieAnimationView).O0000OoO = Boolean.valueOf(z);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(LottieAnimationView lottieAnimationView) {
        super.onAfterUpdateTransaction((View) lottieAnimationView);
        nu orCreatePropertyManager = getOrCreatePropertyManager(lottieAnimationView);
        LottieAnimationView lottieAnimationView2 = orCreatePropertyManager.f2208O000000o.get();
        if (lottieAnimationView2 != null) {
            if (orCreatePropertyManager.O00000Oo != null) {
                lottieAnimationView2.setAnimationFromJson(orCreatePropertyManager.O00000Oo, Integer.toString(orCreatePropertyManager.O00000Oo.hashCode()));
                orCreatePropertyManager.O00000Oo = null;
            }
            if (orCreatePropertyManager.O00000oo) {
                lottieAnimationView2.setAnimation(orCreatePropertyManager.O0000O0o);
                orCreatePropertyManager.O00000oo = false;
            }
            if (orCreatePropertyManager.O00000o0 != null) {
                lottieAnimationView2.setProgress(orCreatePropertyManager.O00000o0.floatValue());
                orCreatePropertyManager.O00000o0 = null;
            }
            if (orCreatePropertyManager.O00000o != null) {
                lottieAnimationView2.loop(orCreatePropertyManager.O00000o.booleanValue());
                orCreatePropertyManager.O00000o = null;
            }
            if (orCreatePropertyManager.O00000oO != null) {
                lottieAnimationView2.setSpeed(orCreatePropertyManager.O00000oO.floatValue());
                orCreatePropertyManager.O00000oO = null;
            }
            if (orCreatePropertyManager.O0000OOo != null) {
                lottieAnimationView2.useHardwareAcceleration(orCreatePropertyManager.O0000OOo.booleanValue());
                orCreatePropertyManager.O0000OOo = null;
            }
            if (orCreatePropertyManager.O0000Oo0 != null) {
                lottieAnimationView2.setScaleType(orCreatePropertyManager.O0000Oo0);
                orCreatePropertyManager.O0000Oo0 = null;
            }
            if (orCreatePropertyManager.O0000Oo != null) {
                lottieAnimationView2.setImageAssetsFolder(orCreatePropertyManager.O0000Oo);
                orCreatePropertyManager.O0000Oo = null;
            }
            if (orCreatePropertyManager.O0000OoO != null) {
                lottieAnimationView2.enableMergePathsForKitKatAndAbove(orCreatePropertyManager.O0000OoO.booleanValue());
                orCreatePropertyManager.O0000OoO = null;
            }
        }
    }

    private nu getOrCreatePropertyManager(LottieAnimationView lottieAnimationView) {
        nu nuVar = this.propManagersMap.get(lottieAnimationView);
        if (nuVar != null) {
            return nuVar;
        }
        nu nuVar2 = new nu(lottieAnimationView);
        this.propManagersMap.put(lottieAnimationView, nuVar2);
        return nuVar2;
    }
}

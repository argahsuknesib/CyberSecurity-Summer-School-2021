package com.facebook.react.views.view;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaConstants;
import java.util.Locale;
import java.util.Map;

@ReactModule(name = "RCTView")
public class ReactViewManager extends ViewGroupManager<ReactViewGroup> {
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3, 4, 5};
    private ReadableMap mNativeBackground;
    private ReadableMap mNativeForeground;

    public String getName() {
        return "RCTView";
    }

    @ReactProp(name = "collapsable")
    public void setCollapsable(ReactViewGroup reactViewGroup, boolean z) {
    }

    @ReactProp(name = "accessible")
    public void setAccessible(ReactViewGroup reactViewGroup, boolean z) {
        reactViewGroup.setFocusable(z);
    }

    @ReactProp(name = "hasTVPreferredFocus")
    public void setTVPreferredFocus(ReactViewGroup reactViewGroup, boolean z) {
        if (z) {
            reactViewGroup.setFocusable(true);
            reactViewGroup.setFocusableInTouchMode(true);
            reactViewGroup.requestFocus();
        }
    }

    @ReactProp(defaultInt = -1, name = "nextFocusDown")
    public void nextFocusDown(ReactViewGroup reactViewGroup, int i) {
        reactViewGroup.setNextFocusDownId(i);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusForward")
    public void nextFocusForward(ReactViewGroup reactViewGroup, int i) {
        reactViewGroup.setNextFocusForwardId(i);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusLeft")
    public void nextFocusLeft(ReactViewGroup reactViewGroup, int i) {
        reactViewGroup.setNextFocusLeftId(i);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusRight")
    public void nextFocusRight(ReactViewGroup reactViewGroup, int i) {
        reactViewGroup.setNextFocusRightId(i);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusUp")
    public void nextFocusUp(ReactViewGroup reactViewGroup, int i) {
        reactViewGroup.setNextFocusUpId(i);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius", "borderTopStartRadius", "borderTopEndRadius", "borderBottomStartRadius", "borderBottomEndRadius"})
    public void setBorderRadius(ReactViewGroup reactViewGroup, int i, float f) {
        if (!YogaConstants.isUndefined(f) && f < 0.0f) {
            f = Float.NaN;
        }
        if (!YogaConstants.isUndefined(f)) {
            f = PixelUtil.toPixelFromDIP(f);
        }
        if (i == 0) {
            reactViewGroup.setBorderRadius(f);
        } else {
            reactViewGroup.setBorderRadius(f, i - 1);
        }
        ReadableMap readableMap = this.mNativeBackground;
        if (readableMap != null) {
            setNativeBackground(reactViewGroup, readableMap);
        }
        ReadableMap readableMap2 = this.mNativeForeground;
        if (readableMap2 != null) {
            setNativeForeground(reactViewGroup, readableMap2);
        }
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setBorderStyle(str);
    }

    @ReactProp(name = "hitSlop")
    public void setHitSlop(ReactViewGroup reactViewGroup, ReadableMap readableMap) {
        if (readableMap == null) {
            reactViewGroup.setHitSlopRect(null);
            return;
        }
        int i = 0;
        int pixelFromDIP = readableMap.hasKey("left") ? (int) PixelUtil.toPixelFromDIP(readableMap.getDouble("left")) : 0;
        int pixelFromDIP2 = readableMap.hasKey("top") ? (int) PixelUtil.toPixelFromDIP(readableMap.getDouble("top")) : 0;
        int pixelFromDIP3 = readableMap.hasKey("right") ? (int) PixelUtil.toPixelFromDIP(readableMap.getDouble("right")) : 0;
        if (readableMap.hasKey("bottom")) {
            i = (int) PixelUtil.toPixelFromDIP(readableMap.getDouble("bottom"));
        }
        reactViewGroup.setHitSlopRect(new Rect(pixelFromDIP, pixelFromDIP2, pixelFromDIP3, i));
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(ReactViewGroup reactViewGroup, String str) {
        if (str == null) {
            reactViewGroup.setPointerEvents(PointerEvents.AUTO);
        } else {
            reactViewGroup.setPointerEvents(PointerEvents.valueOf(str.toUpperCase(Locale.US).replace("-", "_")));
        }
    }

    @ReactProp(name = "nativeBackgroundAndroid")
    public void setNativeBackground(ReactViewGroup reactViewGroup, ReadableMap readableMap) {
        Drawable drawable;
        this.mNativeBackground = readableMap;
        if (readableMap == null) {
            drawable = null;
        } else {
            drawable = ReactDrawableHelper.createDrawableFromJSDescription(reactViewGroup, readableMap);
        }
        reactViewGroup.setTranslucentBackgroundDrawable(drawable);
    }

    @ReactProp(name = "nativeForegroundAndroid")
    @TargetApi(23)
    public void setNativeForeground(ReactViewGroup reactViewGroup, ReadableMap readableMap) {
        Drawable drawable;
        this.mNativeForeground = readableMap;
        if (readableMap == null) {
            drawable = null;
        } else {
            drawable = ReactDrawableHelper.createDrawableFromJSDescription(reactViewGroup, readableMap);
        }
        reactViewGroup.setForeground(drawable);
    }

    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(ReactViewGroup reactViewGroup, boolean z) {
        reactViewGroup.setRemoveClippedSubviews(z);
    }

    @ReactProp(name = "needsOffscreenAlphaCompositing")
    public void setNeedsOffscreenAlphaCompositing(ReactViewGroup reactViewGroup, boolean z) {
        reactViewGroup.setNeedsOffscreenAlphaCompositing(z);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth", "borderStartWidth", "borderEndWidth"})
    public void setBorderWidth(ReactViewGroup reactViewGroup, int i, float f) {
        if (!YogaConstants.isUndefined(f) && f < 0.0f) {
            f = Float.NaN;
        }
        if (!YogaConstants.isUndefined(f)) {
            f = PixelUtil.toPixelFromDIP(f);
        }
        reactViewGroup.setBorderWidth(SPACING_TYPES[i], f);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor", "borderStartColor", "borderEndColor"})
    public void setBorderColor(ReactViewGroup reactViewGroup, int i, Integer num) {
        float f = Float.NaN;
        float intValue = num == null ? Float.NaN : (float) (num.intValue() & 16777215);
        if (num != null) {
            f = (float) (num.intValue() >>> 24);
        }
        reactViewGroup.setBorderColor(SPACING_TYPES[i], intValue, f);
    }

    @ReactProp(name = "focusable")
    public void setFocusable(final ReactViewGroup reactViewGroup, boolean z) {
        if (z) {
            reactViewGroup.setOnClickListener(new View.OnClickListener() {
                /* class com.facebook.react.views.view.ReactViewManager.AnonymousClass1 */

                public void onClick(View view) {
                    ((UIManagerModule) ((ReactContext) reactViewGroup.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ViewGroupClickEvent(reactViewGroup.getId()));
                }
            });
            reactViewGroup.setFocusable(true);
            return;
        }
        reactViewGroup.setOnClickListener(null);
        reactViewGroup.setClickable(false);
    }

    @ReactProp(name = "overflow")
    public void setOverflow(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setOverflow(str);
    }

    @ReactProp(name = "backfaceVisibility")
    public void setBackfaceVisibility(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setBackfaceVisibility(str);
    }

    public void setOpacity(ReactViewGroup reactViewGroup, float f) {
        reactViewGroup.setOpacityIfPossible(f);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.react.uimanager.BaseViewManager.setTransform(android.view.View, com.facebook.react.bridge.ReadableArray):void
     arg types: [com.facebook.react.views.view.ReactViewGroup, com.facebook.react.bridge.ReadableArray]
     candidates:
      com.facebook.react.views.view.ReactViewManager.setTransform(com.facebook.react.views.view.ReactViewGroup, com.facebook.react.bridge.ReadableArray):void
      com.facebook.react.uimanager.BaseViewManager.setTransform(android.view.View, com.facebook.react.bridge.ReadableArray):void */
    public void setTransform(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        super.setTransform((View) reactViewGroup, readableArray);
        reactViewGroup.setBackfaceVisibilityDependantOpacity();
    }

    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactViewGroup(themedReactContext);
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("hotspotUpdate", 1, "setPressed", 2);
    }

    public void receiveCommand(ReactViewGroup reactViewGroup, int i, ReadableArray readableArray) {
        if (i == 1) {
            handleHotspotUpdate(reactViewGroup, readableArray);
        } else if (i == 2) {
            handleSetPressed(reactViewGroup, readableArray);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    public void receiveCommand(ReactViewGroup reactViewGroup, String str, ReadableArray readableArray) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -1639565984) {
            if (hashCode == -399823752 && str.equals("hotspotUpdate")) {
                c = 0;
                if (c == 0) {
                    handleHotspotUpdate(reactViewGroup, readableArray);
                    return;
                } else if (c == 1) {
                    handleSetPressed(reactViewGroup, readableArray);
                    return;
                } else {
                    return;
                }
            }
        } else if (str.equals("setPressed")) {
            c = 1;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
    }

    private void handleSetPressed(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 1) {
            throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
        }
        reactViewGroup.setPressed(readableArray.getBoolean(0));
    }

    private void handleHotspotUpdate(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 2) {
            throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'updateHotspot' command");
        } else if (Build.VERSION.SDK_INT >= 21) {
            reactViewGroup.drawableHotspotChanged(PixelUtil.toPixelFromDIP(readableArray.getDouble(0)), PixelUtil.toPixelFromDIP(readableArray.getDouble(1)));
        }
    }

    public void addView(ReactViewGroup reactViewGroup, View view, int i) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            reactViewGroup.addViewWithSubviewClippingEnabled(view, i);
        } else {
            reactViewGroup.addView(view, i);
        }
    }

    public int getChildCount(ReactViewGroup reactViewGroup) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            return reactViewGroup.getAllChildrenCount();
        }
        return reactViewGroup.getChildCount();
    }

    public View getChildAt(ReactViewGroup reactViewGroup, int i) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            return reactViewGroup.getChildAtWithSubviewClippingEnabled(i);
        }
        return reactViewGroup.getChildAt(i);
    }

    public void removeViewAt(ReactViewGroup reactViewGroup, int i) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            View childAt = getChildAt(reactViewGroup, i);
            if (childAt.getParent() != null) {
                reactViewGroup.removeView(childAt);
            }
            reactViewGroup.removeViewWithSubviewClippingEnabled(childAt);
            return;
        }
        reactViewGroup.removeViewAt(i);
    }

    public void removeAllViews(ReactViewGroup reactViewGroup) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            reactViewGroup.removeAllViewsWithSubviewClippingEnabled();
        } else {
            reactViewGroup.removeAllViews();
        }
    }
}

package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.scrollview;

import _m_j.cb;
import _m_j.gdm;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.views.scroll.FpsListener;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.yoga.YogaConstants;
import java.util.Map;

@ReactModule(name = "MIOTAndroidScrollView")
public class MIOTScrollViewManager extends ViewGroupManager<gdm> implements ReactScrollViewCommandHelper.ScrollCommandHandler<gdm> {
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    private FpsListener mFpsListener;

    public String getName() {
        return "MIOTAndroidScrollView";
    }

    public MIOTScrollViewManager() {
        this(null);
    }

    public MIOTScrollViewManager(FpsListener fpsListener) {
        this.mFpsListener = null;
        this.mFpsListener = fpsListener;
    }

    public gdm createViewInstance(ThemedReactContext themedReactContext) {
        return new gdm(themedReactContext, this.mFpsListener);
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(gdm gdm, boolean z) {
        gdm.setScrollEnabled(z);
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(gdm gdm, boolean z) {
        gdm.setVerticalScrollBarEnabled(z);
    }

    @ReactProp(name = "decelerationRate")
    public void setDecelerationRate(gdm gdm, float f) {
        gdm.setDecelerationRate(f);
    }

    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(gdm gdm, boolean z) {
        gdm.setRemoveClippedSubviews(z);
    }

    @ReactProp(name = "sendMomentumEvents")
    public void setSendMomentumEvents(gdm gdm, boolean z) {
        gdm.setSendMomentumEvents(z);
    }

    @ReactProp(name = "pagingEnabled")
    public void setPagingEnabled(gdm gdm, boolean z) {
        gdm.setPagingEnabled(z);
    }

    @ReactProp(customType = "Color", defaultInt = 0, name = "endFillColor")
    public void setBottomFillColor(gdm gdm, int i) {
        gdm.setEndFillColor(i);
    }

    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(gdm gdm, String str) {
        gdm.setOverScrollMode(ReactScrollViewHelper.parseOverScrollMode(str));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o0(android.view.View, boolean):void
     arg types: [_m_j.gdm, boolean]
     candidates:
      _m_j.cb.O00000o0(android.view.View, float):void
      _m_j.cb.O00000o0(android.view.View, int):void
      _m_j.cb.O00000o0(android.view.View, boolean):void */
    @ReactProp(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(gdm gdm, boolean z) {
        cb.O00000o0((View) gdm, z);
    }

    public Map<String, Integer> getCommandsMap() {
        return ReactScrollViewCommandHelper.getCommandsMap();
    }

    public void receiveCommand(gdm gdm, int i, ReadableArray readableArray) {
        ReactScrollViewCommandHelper.receiveCommand(this, gdm, i, readableArray);
    }

    public void flashScrollIndicators(gdm gdm) {
        gdm.O000000o();
    }

    public void scrollTo(gdm gdm, ReactScrollViewCommandHelper.ScrollToCommandData scrollToCommandData) {
        if (scrollToCommandData.mAnimated) {
            gdm.smoothScrollTo(scrollToCommandData.mDestX, scrollToCommandData.mDestY);
        } else {
            gdm.scrollTo(scrollToCommandData.mDestX, scrollToCommandData.mDestY);
        }
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(gdm gdm, int i, float f) {
        if (!YogaConstants.isUndefined(f)) {
            f = PixelUtil.toPixelFromDIP(f);
        }
        if (i == 0) {
            gdm.setBorderRadius(f);
            return;
        }
        gdm.f17562O000000o.setBorderRadius(f, i - 1);
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(gdm gdm, String str) {
        gdm.setBorderStyle(str);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(gdm gdm, int i, float f) {
        if (!YogaConstants.isUndefined(f)) {
            f = PixelUtil.toPixelFromDIP(f);
        }
        gdm.f17562O000000o.setBorderWidth(SPACING_TYPES[i], f);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(gdm gdm, int i, Integer num) {
        float f = Float.NaN;
        float intValue = num == null ? Float.NaN : (float) (num.intValue() & 16777215);
        if (num != null) {
            f = (float) (num.intValue() >>> 24);
        }
        gdm.f17562O000000o.setBorderColor(SPACING_TYPES[i], intValue, f);
    }

    @ReactProp(name = "overflow")
    public void setOverflow(gdm gdm, String str) {
        gdm.setOverflow(str);
    }

    public void scrollToEnd(gdm gdm, ReactScrollViewCommandHelper.ScrollToEndCommandData scrollToEndCommandData) {
        int height = gdm.getChildAt(0).getHeight() + gdm.getPaddingBottom();
        if (scrollToEndCommandData.mAnimated) {
            gdm.smoothScrollTo(gdm.getScrollX(), height);
        } else {
            gdm.scrollTo(gdm.getScrollX(), height);
        }
    }

    @ReactProp(name = "persistentScrollbar")
    public void setPersistentScrollbar(gdm gdm, boolean z) {
        gdm.setScrollbarFadingEnabled(!z);
    }

    @ReactProp(name = "scrollYDuration")
    public void setScrollYDuration(gdm gdm, int i) {
        gdm.setScrollYDuration(i);
    }

    @ReactProp(name = "offsetPercent")
    public void setOffsetPercent(gdm gdm, float f) {
        gdm.setOffsetPercent(f);
    }

    @ReactProp(name = "snapHeight")
    public void setSnapHeight(gdm gdm, int i) {
        gdm.setSnapHeight((int) (((float) i) * DisplayMetricsHolder.getScreenDisplayMetrics().density));
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return createExportedCustomDirectEventTypeConstants();
    }

    public static Map<String, Object> createExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put(ScrollEventType.SCROLL.getJSEventName(), MapBuilder.of("registrationName", "onScroll")).put(ScrollEventType.BEGIN_DRAG.getJSEventName(), MapBuilder.of("registrationName", "onScrollBeginDrag")).put(ScrollEventType.END_DRAG.getJSEventName(), MapBuilder.of("registrationName", "onScrollEndDrag")).put(ScrollEventType.MOMENTUM_BEGIN.getJSEventName(), MapBuilder.of("registrationName", "onMomentumScrollBegin")).put(ScrollEventType.MOMENTUM_END.getJSEventName(), MapBuilder.of("registrationName", "onMomentumScrollEnd")).build();
    }
}

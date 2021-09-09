package com.facebook.react.views.drawer;

import android.os.Build;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.drawer.events.DrawerClosedEvent;
import com.facebook.react.views.drawer.events.DrawerOpenedEvent;
import com.facebook.react.views.drawer.events.DrawerSlideEvent;
import com.facebook.react.views.drawer.events.DrawerStateChangedEvent;
import java.util.Map;

@ReactModule(name = "AndroidDrawerLayout")
public class ReactDrawerLayoutManager extends ViewGroupManager<ReactDrawerLayout> {
    public String getName() {
        return "AndroidDrawerLayout";
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.setDrawerListener(new DrawerEventEmitter(reactDrawerLayout, ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher()));
    }

    /* access modifiers changed from: protected */
    public ReactDrawerLayout createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactDrawerLayout(themedReactContext);
    }

    @ReactProp(name = "drawerPosition")
    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, Dynamic dynamic) {
        if (dynamic.isNull()) {
            reactDrawerLayout.setDrawerPosition(8388611);
        } else if (dynamic.getType() == ReadableType.Number) {
            int asInt = dynamic.asInt();
            if (8388611 == asInt || 8388613 == asInt) {
                reactDrawerLayout.setDrawerPosition(asInt);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Unknown drawerPosition ".concat(String.valueOf(asInt)));
        } else if (dynamic.getType() == ReadableType.String) {
            String asString = dynamic.asString();
            if (asString.equals("left")) {
                reactDrawerLayout.setDrawerPosition(8388611);
            } else if (asString.equals("right")) {
                reactDrawerLayout.setDrawerPosition(8388613);
            } else {
                throw new JSApplicationIllegalArgumentException("drawerPosition must be 'left' or 'right', received".concat(String.valueOf(asString)));
            }
        } else {
            throw new JSApplicationIllegalArgumentException("drawerPosition must be a string or int");
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "drawerWidth")
    public void getDrawerWidth(ReactDrawerLayout reactDrawerLayout, float f) {
        int i;
        if (Float.isNaN(f)) {
            i = -1;
        } else {
            i = Math.round(PixelUtil.toPixelFromDIP(f));
        }
        reactDrawerLayout.setDrawerWidth(i);
    }

    @ReactProp(name = "drawerLockMode")
    public void setDrawerLockMode(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str == null || "unlocked".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(0);
        } else if ("locked-closed".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(1);
        } else if ("locked-open".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(2);
        } else {
            throw new JSApplicationIllegalArgumentException("Unknown drawerLockMode ".concat(String.valueOf(str)));
        }
    }

    public void setElevation(ReactDrawerLayout reactDrawerLayout, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            Class<ReactDrawerLayout> cls = ReactDrawerLayout.class;
            try {
                cls.getMethod("setDrawerElevation", Float.TYPE).invoke(reactDrawerLayout, Float.valueOf(PixelUtil.toPixelFromDIP(f)));
            } catch (Exception e) {
                FLog.w("ReactNative", "setDrawerElevation is not available in this version of the support lib.", e);
            }
        }
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("openDrawer", 1, "closeDrawer", 2);
    }

    public void receiveCommand(ReactDrawerLayout reactDrawerLayout, int i, ReadableArray readableArray) {
        if (i == 1) {
            reactDrawerLayout.openDrawer();
        } else if (i == 2) {
            reactDrawerLayout.closeDrawer();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    public void receiveCommand(ReactDrawerLayout reactDrawerLayout, String str, ReadableArray readableArray) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -258774775) {
            if (hashCode == -83186725 && str.equals("openDrawer")) {
                c = 0;
                if (c == 0) {
                    reactDrawerLayout.openDrawer();
                    return;
                } else if (c == 1) {
                    reactDrawerLayout.closeDrawer();
                    return;
                } else {
                    return;
                }
            }
        } else if (str.equals("closeDrawer")) {
            c = 1;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
    }

    public Map getExportedViewConstants() {
        return MapBuilder.of("DrawerPosition", MapBuilder.of("Left", 8388611, "Right", 8388613));
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("topDrawerSlide", MapBuilder.of("registrationName", "onDrawerSlide"), "topDrawerOpen", MapBuilder.of("registrationName", "onDrawerOpen"), "topDrawerClose", MapBuilder.of("registrationName", "onDrawerClose"), "topDrawerStateChanged", MapBuilder.of("registrationName", "onDrawerStateChanged"));
    }

    public void addView(ReactDrawerLayout reactDrawerLayout, View view, int i) {
        if (getChildCount(reactDrawerLayout) >= 2) {
            throw new JSApplicationIllegalArgumentException("The Drawer cannot have more than two children");
        } else if (i == 0 || i == 1) {
            reactDrawerLayout.addView(view, i);
            reactDrawerLayout.setDrawerProperties();
        } else {
            throw new JSApplicationIllegalArgumentException("The only valid indices for drawer's child are 0 or 1. Got " + i + " instead.");
        }
    }

    public static class DrawerEventEmitter implements DrawerLayout.O00000o0 {
        private final DrawerLayout mDrawerLayout;
        private final EventDispatcher mEventDispatcher;

        public DrawerEventEmitter(DrawerLayout drawerLayout, EventDispatcher eventDispatcher) {
            this.mDrawerLayout = drawerLayout;
            this.mEventDispatcher = eventDispatcher;
        }

        public void onDrawerSlide(View view, float f) {
            this.mEventDispatcher.dispatchEvent(new DrawerSlideEvent(this.mDrawerLayout.getId(), f));
        }

        public void onDrawerOpened(View view) {
            this.mEventDispatcher.dispatchEvent(new DrawerOpenedEvent(this.mDrawerLayout.getId()));
        }

        public void onDrawerClosed(View view) {
            this.mEventDispatcher.dispatchEvent(new DrawerClosedEvent(this.mDrawerLayout.getId()));
        }

        public void onDrawerStateChanged(int i) {
            this.mEventDispatcher.dispatchEvent(new DrawerStateChangedEvent(this.mDrawerLayout.getId(), i));
        }
    }
}

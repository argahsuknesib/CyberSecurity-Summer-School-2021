package com.facebook.react.views.switchview;

import android.view.View;
import android.widget.CompoundButton;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;

public class ReactSwitchManager extends SimpleViewManager<ReactSwitch> {
    private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new CompoundButton.OnCheckedChangeListener() {
        /* class com.facebook.react.views.switchview.ReactSwitchManager.AnonymousClass1 */

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ((UIManagerModule) ((ReactContext) compoundButton.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSwitchEvent(compoundButton.getId(), z));
        }
    };

    public String getName() {
        return "AndroidSwitch";
    }

    static class ReactSwitchShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
        private int mHeight;
        private boolean mMeasured;
        private int mWidth;

        private ReactSwitchShadowNode() {
            initMeasureFunction();
        }

        private void initMeasureFunction() {
            setMeasureFunction(this);
        }

        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            if (!this.mMeasured) {
                ReactSwitch reactSwitch = new ReactSwitch(getThemedContext());
                reactSwitch.setShowText(false);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                reactSwitch.measure(makeMeasureSpec, makeMeasureSpec);
                this.mWidth = reactSwitch.getMeasuredWidth();
                this.mHeight = reactSwitch.getMeasuredHeight();
                this.mMeasured = true;
            }
            return YogaMeasureOutput.make(this.mWidth, this.mHeight);
        }
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactSwitchShadowNode();
    }

    public Class getShadowNodeClass() {
        return ReactSwitchShadowNode.class;
    }

    /* access modifiers changed from: protected */
    public ReactSwitch createViewInstance(ThemedReactContext themedReactContext) {
        ReactSwitch reactSwitch = new ReactSwitch(themedReactContext);
        reactSwitch.setShowText(false);
        return reactSwitch;
    }

    @ReactProp(defaultBoolean = false, name = "disabled")
    public void setDisabled(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setEnabled(!z);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setEnabled(z);
    }

    @ReactProp(name = "on")
    public void setOn(ReactSwitch reactSwitch, boolean z) {
        setValue(reactSwitch, z);
    }

    @ReactProp(name = "value")
    public void setValue(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setOnCheckedChangeListener(null);
        reactSwitch.setOn(z);
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSwitch reactSwitch, Integer num) {
        setThumbColor(reactSwitch, num);
    }

    @ReactProp(customType = "Color", name = "thumbColor")
    public void setThumbColor(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setThumbColor(num);
    }

    @ReactProp(customType = "Color", name = "trackColorForFalse")
    public void setTrackColorForFalse(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setTrackColorForFalse(num);
    }

    @ReactProp(customType = "Color", name = "trackColorForTrue")
    public void setTrackColorForTrue(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setTrackColorForTrue(num);
    }

    @ReactProp(customType = "Color", name = "trackTintColor")
    public void setTrackTintColor(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setTrackColor(num);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactSwitch reactSwitch) {
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }
}

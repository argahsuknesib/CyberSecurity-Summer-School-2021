package dk.madslee.imageCapInsets;

import android.graphics.Rect;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RCTImageCapInsetManager extends SimpleViewManager<RCTImageCapInsetView> {
    public String getName() {
        return "RCTImageCapInset";
    }

    /* access modifiers changed from: protected */
    public RCTImageCapInsetView createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTImageCapInsetView(themedReactContext);
    }

    @ReactProp(name = "capInsets")
    public void setCapInsets(RCTImageCapInsetView rCTImageCapInsetView, ReadableMap readableMap) {
        int i = 0;
        int i2 = readableMap.hasKey("top") ? readableMap.getInt("top") : 0;
        int i3 = readableMap.hasKey("left") ? readableMap.getInt("left") : 0;
        int i4 = readableMap.hasKey("right") ? readableMap.getInt("right") : 0;
        if (readableMap.hasKey("bottom")) {
            i = readableMap.getInt("bottom");
        }
        rCTImageCapInsetView.setCapInsets(new Rect(i3, i2, i4, i));
    }

    @ReactProp(name = "source")
    public void setSource(RCTImageCapInsetView rCTImageCapInsetView, ReadableMap readableMap) {
        rCTImageCapInsetView.setSource(readableMap.getString("uri"));
    }
}

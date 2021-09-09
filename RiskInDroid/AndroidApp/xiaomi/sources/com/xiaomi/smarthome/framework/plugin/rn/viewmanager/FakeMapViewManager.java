package com.xiaomi.smarthome.framework.plugin.rn.viewmanager;

import _m_j.fyf;
import android.view.View;
import android.widget.TextView;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.xiaomi.smarthome.R;
import java.util.Map;

public class FakeMapViewManager extends SimpleViewManager {
    private static String REACT_CLASS = "MHMapView";
    private ThemedReactContext mReactContext;

    public void addEventEmitters(ThemedReactContext themedReactContext, View view) {
    }

    @ReactProp(name = "allowsBackgroundLocationUpdates")
    public void allowsBackgroundLocationUpdates(View view, boolean z) {
    }

    @ReactProp(name = "annotations")
    public void annotations(View view, ReadableArray readableArray) {
    }

    @ReactProp(name = "centerCoordinate")
    public void centerCoordinate(View view, ReadableMap readableMap) {
    }

    @ReactProp(name = "circles")
    public void circles(View view, ReadableArray readableArray) {
    }

    @ReactProp(name = "compassOrigin")
    public void compassOrigin(View view, ReadableMap readableMap) {
    }

    @ReactProp(name = "desiredAccuracy")
    public void desiredAccuracy(View view, boolean z) {
    }

    @ReactProp(name = "distanceFilter")
    public void distanceFilter(View view, double d) {
    }

    @ReactProp(name = "headingFilter")
    public void headingFilter(View view, double d) {
    }

    @ReactProp(name = "language")
    public void mapLanguage(View view, int i) {
    }

    @ReactProp(name = "mapType")
    public void mapType(View view, int i) {
    }

    @ReactProp(name = "multiPolylines")
    public void multiPolylines(View view, ReadableArray readableArray) {
    }

    @ReactProp(name = "pausesLocationUpdatesAutomatically")
    public void pausesLocationUpdatesAutomatically(View view, boolean z) {
    }

    @ReactProp(name = "polylines")
    public void polylines(View view, ReadableArray readableArray) {
    }

    @ReactProp(name = "scaleOrigin")
    public void scaleOrigin(View view, int i) {
    }

    @ReactProp(name = "logoPosition")
    public void setLogoPosition(View view, int i) {
    }

    @ReactProp(name = "showsCompass")
    public void showsCompass(View view, boolean z) {
    }

    @ReactProp(name = "showsScale")
    public void showsScale(View view, boolean z) {
    }

    @ReactProp(name = "showsUserLocation")
    public void showsUserLocation(View view, boolean z) {
    }

    @ReactProp(name = "trafficEnabled")
    public void trafficEnabled(View view, boolean z) {
    }

    @ReactProp(name = "userLocation")
    public void userLocation(View view, ReadableMap readableMap) {
    }

    @ReactProp(name = "userLocationRepresentation")
    public void userLocationRepresentation(View view, ReadableMap readableMap) {
    }

    @ReactProp(name = "userTrackingMode")
    public void userTrackingMode(View view, String str) {
    }

    @ReactProp(name = "zoomEnabled")
    public void zoomEnabled(View view, boolean z) {
    }

    @ReactProp(name = "zoomLevel")
    public void zoomLevel(View view, double d) {
    }

    public String getName() {
        return REACT_CLASS;
    }

    public View createViewInstance(ThemedReactContext themedReactContext) {
        this.mReactContext = themedReactContext;
        TextView textView = new TextView(themedReactContext);
        textView.setText((int) R.string.mapview_not_supported);
        return textView;
    }

    private int getColor(ReadableMap readableMap, String str) {
        ReadableArray O00000Oo = fyf.O00000Oo(readableMap, str);
        double[] dArr = {1.0d, 1.0d, 1.0d, 1.0d};
        if (O00000Oo != null) {
            for (int i = 0; i < O00000Oo.size(); i++) {
                dArr[i] = O00000Oo.getDouble(i);
            }
        }
        return (((int) ((dArr[3] * 255.0d) + 0.5d)) << 24) | (((int) ((dArr[0] * 255.0d) + 0.5d)) << 16) | (((int) ((dArr[1] * 255.0d) + 0.5d)) << 8) | ((int) ((dArr[2] * 255.0d) + 0.5d));
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onUpdateUserLocation", MapBuilder.of("registrationName", "onUpdateUserLocation")).put("onSelectAnnotationView", MapBuilder.of("registrationName", "onSelectAnnotationView")).put("onLongPressedAtCoordinate", MapBuilder.of("registrationName", "onLongPressedAtCoordinate")).put("onSingleTappedAtCoordinate", MapBuilder.of("registrationName", "onSingleTappedAtCoordinate")).put("onMapWillZoomByUser", MapBuilder.of("registrationName", "onMapWillZoomByUser")).put("onMapDidZoomByUser", MapBuilder.of("registrationName", "onMapDidZoomByUser")).build();
    }
}

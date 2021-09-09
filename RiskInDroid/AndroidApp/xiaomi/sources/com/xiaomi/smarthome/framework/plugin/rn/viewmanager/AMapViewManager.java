package com.xiaomi.smarthome.framework.plugin.rn.viewmanager;

import _m_j.fyc;
import _m_j.fyf;
import _m_j.gth;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.maps2d.model.Polyline;
import com.amap.api.maps2d.model.PolylineOptions;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class AMapViewManager extends SimpleViewManager {
    private static String REACT_CLASS = "MHMapView";
    public ThemedReactContext mReactContext;

    @ReactProp(name = "allowsBackgroundLocationUpdates")
    public void allowsBackgroundLocationUpdates(View view, boolean z) {
    }

    @ReactProp(name = "compassOrigin")
    public void compassOrigin(View view, ReadableMap readableMap) {
    }

    @ReactProp(name = "distanceFilter")
    public void distanceFilter(View view, double d) {
    }

    @ReactProp(name = "headingFilter")
    public void headingFilter(View view, double d) {
    }

    @ReactProp(name = "pausesLocationUpdatesAutomatically")
    public void pausesLocationUpdatesAutomatically(View view, boolean z) {
    }

    @ReactProp(name = "polylines")
    public void polylines(View view, ReadableArray readableArray) {
    }

    @ReactProp(name = "userTrackingMode")
    public void userTrackingMode(View view, String str) {
    }

    public String getName() {
        return REACT_CLASS;
    }

    public View createViewInstance(ThemedReactContext themedReactContext) {
        this.mReactContext = themedReactContext;
        LocationSource rNMapView = new RNMapView(themedReactContext);
        boolean z = true;
        rNMapView.getMap().getUiSettings().setAllGesturesEnabled(true);
        rNMapView.getMap().getUiSettings().setZoomControlsEnabled(false);
        rNMapView.getMap().setLocationSource(rNMapView);
        Locale settingLocale = XmPluginHostApi.instance().getSettingLocale();
        if (settingLocale == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                settingLocale = CommonApplication.getAppContext().getResources().getConfiguration().getLocales().get(0);
            } else {
                settingLocale = Locale.getDefault();
            }
        }
        if (settingLocale != null && !Locale.CHINESE.getLanguage().equalsIgnoreCase(settingLocale.getLanguage())) {
            z = false;
        }
        if (z) {
            rNMapView.getMap().setMapLanguage("zh_cn");
        } else {
            rNMapView.getMap().setMapLanguage("en");
        }
        return rNMapView;
    }

    @ReactProp(name = "showsUserLocation")
    public void showsUserLocation(View view, boolean z) {
        ((MapView) view).getMap().setMyLocationEnabled(z);
    }

    @ReactProp(name = "trafficEnabled")
    public void trafficEnabled(View view, boolean z) {
        ((MapView) view).getMap().setTrafficEnabled(z);
    }

    @ReactProp(name = "scaleOrigin")
    public void scaleOrigin(View view, int i) {
        ((MapView) view).getMap().getUiSettings().setZoomPosition(i);
    }

    @ReactProp(name = "showsScale")
    public void showsScale(View view, boolean z) {
        ((MapView) view).getMap().getUiSettings().setScaleControlsEnabled(z);
    }

    @ReactProp(name = "showsCompass")
    public void showsCompass(View view, boolean z) {
        ((MapView) view).getMap().getUiSettings().setCompassEnabled(z);
    }

    @ReactProp(name = "zoomEnabled")
    public void zoomEnabled(View view, boolean z) {
        ((MapView) view).getMap().getUiSettings().setZoomControlsEnabled(z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double
     arg types: [com.facebook.react.bridge.ReadableMap, java.lang.String, int]
     candidates:
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, int):int
      _m_j.fyf.O000000o(int, int, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double */
    @ReactProp(name = "userLocation")
    public void userLocation(View view, ReadableMap readableMap) {
        double d;
        double d2;
        RNMapView rNMapView = (RNMapView) view;
        if (rNMapView.O00000Oo != null && readableMap != null) {
            ReadableMap O00000o0 = fyf.O00000o0(readableMap, "location");
            AMapLocation aMapLocation = new AMapLocation("");
            if (O00000o0 == null) {
                d = fyf.O000000o(readableMap, "latitude", 0.0d);
            } else {
                d = fyf.O000000o(O00000o0, "latitude", 0.0d);
            }
            aMapLocation.setLatitude(d);
            if (O00000o0 == null) {
                d2 = fyf.O000000o(readableMap, "longitude", 0.0d);
            } else {
                d2 = fyf.O000000o(O00000o0, "longitude", 0.0d);
            }
            aMapLocation.setLongitude(d2);
            rNMapView.O00000Oo.onLocationChanged(aMapLocation);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double
     arg types: [com.facebook.react.bridge.ReadableMap, java.lang.String, int]
     candidates:
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, int):int
      _m_j.fyf.O000000o(int, int, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double */
    @ReactProp(name = "annotations")
    public void annotations(View view, ReadableArray readableArray) {
        AMapViewManager aMapViewManager = this;
        ReadableArray readableArray2 = readableArray;
        Iterator<Marker> it = ((RNMapView) view).O00000oO.iterator();
        while (it.hasNext()) {
            Marker next = it.next();
            if (next != null) {
                next.remove();
            }
        }
        if (readableArray2 != null && readableArray.size() != 0) {
            int i = 0;
            while (i < readableArray.size()) {
                ReadableMap map = readableArray2.getMap(i);
                fyf.O000000o(map, "id", "");
                String O000000o2 = fyf.O000000o(map, "title", "");
                String O000000o3 = fyf.O000000o(map, "subtitle", "");
                boolean O000000o4 = fyf.O000000o(map, "canShowCallout");
                String O000000o5 = fyf.O000000o(fyf.O00000Oo(map, "image"));
                double O000000o6 = fyf.O000000o(map, "zIndex", 0.0d);
                boolean O000000o7 = fyf.O000000o(map, "lockedToScreen");
                ReadableMap O00000o0 = fyf.O00000o0(map, "coordinate");
                double O000000o8 = fyf.O000000o(O00000o0, "latitude", 0.0d);
                double O000000o9 = fyf.O000000o(O00000o0, "longitude", 0.0d);
                ReadableMap O00000o02 = fyf.O00000o0(map, "lockedScreenPoint");
                final MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.draggable(!O000000o7);
                markerOptions.anchor((float) fyf.O000000o(O00000o02, "x", 0.0d), (float) fyf.O000000o(O00000o02, "y", 0.0d));
                markerOptions.title(O000000o2);
                markerOptions.snippet(O000000o3);
                markerOptions.position(new LatLng(O000000o8, O000000o9));
                markerOptions.zIndex((float) O000000o6);
                markerOptions.visible(O000000o4);
                final View view2 = view;
                getBitmap(view.getContext(), Uri.parse(O000000o5), new gth.O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.AMapViewManager.AnonymousClass1 */

                    public final void onBitmapLoaded(Bitmap bitmap, long j) {
                        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
                        ((RNMapView) view2).O00000oO.add(view2.getMap().addMarker(markerOptions));
                    }
                });
                i++;
                readableArray2 = readableArray;
                aMapViewManager = this;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double
     arg types: [com.facebook.react.bridge.ReadableMap, java.lang.String, int]
     candidates:
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, int):int
      _m_j.fyf.O000000o(int, int, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double */
    @ReactProp(name = "circles")
    public void circles(View view, ReadableArray readableArray) {
        ReadableArray readableArray2 = readableArray;
        RNMapView rNMapView = (RNMapView) view;
        Iterator<Circle> it = rNMapView.O00000o.iterator();
        while (it.hasNext()) {
            it.next().remove();
        }
        if (readableArray2 != null && readableArray.size() != 0) {
            int i = 0;
            while (i < readableArray.size()) {
                ReadableMap map = readableArray2.getMap(i);
                fyf.O000000o(map, "id", "");
                double O000000o2 = fyf.O000000o(map, "radius", 0.0d);
                double O000000o3 = fyf.O000000o(map, "lineWidth", 0.0d);
                double O000000o4 = fyf.O000000o(map, "zIndex", 0.0d);
                ReadableMap O00000o0 = fyf.O00000o0(map, "coordinate");
                double O000000o5 = fyf.O000000o(O00000o0, "latitude", 0.0d);
                double O000000o6 = fyf.O000000o(O00000o0, "longitude", 0.0d);
                CircleOptions circleOptions = new CircleOptions();
                circleOptions.fillColor(getColor(map, "fillColor"));
                circleOptions.strokeColor(getColor(map, "strokeColor"));
                circleOptions.strokeWidth((float) O000000o3);
                circleOptions.radius(O000000o2);
                circleOptions.zIndex((float) O000000o4);
                circleOptions.center(new LatLng(O000000o5, O000000o6));
                rNMapView.O00000o.add(((MapView) view).getMap().addCircle(circleOptions));
                i++;
                readableArray2 = readableArray;
            }
        }
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

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double
     arg types: [com.facebook.react.bridge.ReadableMap, java.lang.String, int]
     candidates:
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, int):int
      _m_j.fyf.O000000o(int, int, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double */
    @ReactProp(name = "multiPolylines")
    public void multiPolylines(View view, ReadableArray readableArray) {
        ReadableArray readableArray2 = readableArray;
        RNMapView rNMapView = (RNMapView) view;
        Iterator<Polyline> it = rNMapView.O00000o0.iterator();
        while (it.hasNext()) {
            it.next().remove();
        }
        if (readableArray2 != null && readableArray.size() != 0) {
            int i = 0;
            while (i < readableArray.size()) {
                PolylineOptions polylineOptions = new PolylineOptions();
                ReadableMap map = readableArray2.getMap(i);
                fyf.O000000o(map, "id", "");
                double O000000o2 = fyf.O000000o(map, "renderLineWidth", 0.0d);
                ReadableArray O00000Oo = fyf.O00000Oo(map, "colors");
                double O000000o3 = fyf.O000000o(map, "zIndex", 0.0d);
                ReadableArray O00000Oo2 = fyf.O00000Oo(map, "coordinates");
                if (O00000Oo2 != null) {
                    int i2 = 0;
                    while (i2 < O00000Oo2.size()) {
                        ReadableMap map2 = O00000Oo2.getMap(i2);
                        polylineOptions.add(new LatLng(fyf.O000000o(map2, "latitude", 0.0d), fyf.O000000o(map2, "longitude", 0.0d)));
                        i2++;
                        i = i;
                        rNMapView = rNMapView;
                    }
                }
                RNMapView rNMapView2 = rNMapView;
                int i3 = i;
                if (O00000Oo != null && O00000Oo.size() > 0) {
                    polylineOptions.color((int) ((long) O00000Oo.getDouble(0)));
                }
                polylineOptions.width((float) O000000o2);
                polylineOptions.zIndex((float) O000000o3);
                rNMapView = rNMapView2;
                rNMapView.O00000o0.add(((MapView) view).getMap().addPolyline(polylineOptions));
                i = i3 + 1;
                readableArray2 = readableArray;
            }
        }
    }

    @ReactProp(name = "userLocationRepresentation")
    public void userLocationRepresentation(final View view, ReadableMap readableMap) {
        final MyLocationStyle myLocationStyle = new MyLocationStyle();
        getBitmap(view.getContext(), Uri.parse(fyf.O000000o(fyf.O00000Oo(readableMap, "image"))), new gth.O000000o() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.AMapViewManager.AnonymousClass2 */

            public final void onBitmapLoaded(Bitmap bitmap, long j) {
                myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromBitmap(bitmap));
                view.getMap().setMyLocationStyle(myLocationStyle);
            }
        });
    }

    @ReactProp(name = "mapType")
    public void mapType(View view, int i) {
        AMap map = ((MapView) view).getMap();
        int i2 = 1;
        if (i == 1) {
            i2 = 2;
        }
        map.setMapType(i2);
    }

    @ReactProp(name = "language")
    public void mapLanguage(View view, int i) {
        if (i == 1) {
            ((MapView) view).getMap().setMapLanguage("en");
        } else {
            ((MapView) view).getMap().setMapLanguage("zh_cn");
        }
    }

    @ReactProp(name = "logoPosition")
    public void setLogoPosition(View view, int i) {
        if (i == 1) {
            ((MapView) view).getMap().getUiSettings().setLogoPosition(1);
        } else if (i != 2) {
            ((MapView) view).getMap().getUiSettings().setLogoPosition(0);
        } else {
            ((MapView) view).getMap().getUiSettings().setLogoPosition(2);
        }
    }

    @ReactProp(name = "desiredAccuracy")
    public void desiredAccuracy(View view, boolean z) {
        ((RNMapView) view).f8475O000000o.setLocationMode(z ? AMapLocationClientOption.AMapLocationMode.Hight_Accuracy : AMapLocationClientOption.AMapLocationMode.Battery_Saving);
    }

    @ReactProp(name = "zoomLevel")
    public void zoomLevel(View view, double d) {
        fyc.O00000o("AMapViewManager", "zoomLevel exec  view is not instanceof MapView...");
    }

    @ReactProp(name = "centerCoordinate")
    public void centerCoordinate(View view, ReadableMap readableMap) {
        if (readableMap != null) {
            fyc.O00000o("AMapViewManager", "centerCoordinate exec  view is not instanceof MapView...");
        } else {
            fyc.O00000Oo("AMapViewManager", "centerCoordinate exec... centerCoordinate is null...");
        }
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onUpdateUserLocation", MapBuilder.of("registrationName", "onUpdateUserLocation")).put("onSelectAnnotationView", MapBuilder.of("registrationName", "onSelectAnnotationView")).put("onLongPressedAtCoordinate", MapBuilder.of("registrationName", "onLongPressedAtCoordinate")).put("onSingleTappedAtCoordinate", MapBuilder.of("registrationName", "onSingleTappedAtCoordinate")).put("onMapWillZoomByUser", MapBuilder.of("registrationName", "onMapWillZoomByUser")).put("onMapDidZoomByUser", MapBuilder.of("registrationName", "onMapDidZoomByUser")).build();
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, final View view) {
        AMap map = ((MapView) view).getMap();
        map.setOnMapLongClickListener(new AMap.OnMapLongClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.AMapViewManager.AnonymousClass3 */
        });
        map.setOnMyLocationChangeListener(new AMap.OnMyLocationChangeListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.AMapViewManager.AnonymousClass4 */
        });
        map.setOnMapClickListener(new AMap.OnMapClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.AMapViewManager.AnonymousClass5 */
        });
        map.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.AMapViewManager.AnonymousClass6 */
        });
        map.setOnCameraChangeListener(new AMap.OnCameraChangeListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.AMapViewManager.AnonymousClass7 */
        });
    }

    public void getBitmap(Context context, Uri uri, final gth.O000000o o000000o) {
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).setProgressiveRenderingEnabled(true).build(), context).subscribe(new BaseBitmapDataSubscriber() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.AMapViewManager.AnonymousClass8 */

            public final void onNewResultImpl(Bitmap bitmap) {
                o000000o.onBitmapLoaded(bitmap, 0);
            }

            public final void onFailureImpl(DataSource dataSource) {
                o000000o.onBitmapLoaded(null, 0);
            }
        }, CallerThreadExecutor.getInstance());
    }

    public static class RNMapView extends MapView implements LocationSource {

        /* renamed from: O000000o  reason: collision with root package name */
        public AMapLocationClientOption f8475O000000o;
        public LocationSource.OnLocationChangedListener O00000Oo;
        public ArrayList<Circle> O00000o = new ArrayList<>();
        public ArrayList<Polyline> O00000o0 = new ArrayList<>();
        public ArrayList<Marker> O00000oO = new ArrayList<>();
        private float O00000oo = -1000.0f;

        public RNMapView(Context context) {
            super(context);
        }
    }
}

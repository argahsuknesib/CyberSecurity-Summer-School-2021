package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper;

import _m_j.gbu;
import _m_j.gcr;
import _m_j.gcs;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.util.ArrayList;

@ReactModule(name = "MHSweepingMapManager")
public class MiotMapSweeperModule extends ReactContextBaseJavaModule {
    public MiotMapSweeperModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        gbu.O000000o("MHSweepingMapManager init ...");
        return "MHSweepingMapManager";
    }

    @ReactMethod
    public void positionWithImageName(String str, int i, Callback callback) {
        gcs gcs;
        ZoomMapSweeperView zoomMapSweeperView = (ZoomMapSweeperView) getCurrentActivity().findViewById(i);
        if (callback != null) {
            if (zoomMapSweeperView == null) {
                callback.invoke(Boolean.FALSE, generateWritableMap(-1, "cannot get view by view id, view id is ".concat(String.valueOf(i))));
                return;
            }
            WritableMap createMap = Arguments.createMap();
            CommonSweeperView commonSweeperView = zoomMapSweeperView.getMapSweeperView().f8599O000000o.get(str);
            if (commonSweeperView != null) {
                gcs = commonSweeperView.getCurrentPosition();
            } else {
                gcs = null;
            }
            if (gcs == null) {
                callback.invoke(Boolean.FALSE, generateWritableMap(-1, "cannot get image from imageName, imageName is ".concat(String.valueOf(str))));
                return;
            }
            createMap.putInt("code", 0);
            createMap.putInt("x", gcs.f17542O000000o);
            createMap.putInt("y", gcs.O00000Oo);
            callback.invoke(Boolean.TRUE, createMap);
        }
    }

    @ReactMethod
    public void cleanMapView(int i) {
        final ZoomMapSweeperView zoomMapSweeperView = (ZoomMapSweeperView) getCurrentActivity().findViewById(i);
        if (zoomMapSweeperView == null) {
            gbu.O00000Oo("can not findView by id, id is ".concat(String.valueOf(i)));
        } else {
            zoomMapSweeperView.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper.MiotMapSweeperModule.AnonymousClass1 */

                public final void run() {
                    MiotMapSweeperModule.this.cleanMapView(zoomMapSweeperView);
                }
            });
        }
    }

    public void cleanMapView(ZoomMapSweeperView zoomMapSweeperView) {
        gcr gcr = new gcr(null, null, "", 1, 1, 0, 1, 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(gcr);
        zoomMapSweeperView.getMapSweeperView().O000000o(arrayList);
        zoomMapSweeperView.getMapSweeperView().O000000o();
        zoomMapSweeperView.getMapSweeperView().O00000Oo();
        zoomMapSweeperView.O000000o(1.0f, 0.0f, 0.0f);
        zoomMapSweeperView.getRootView().invalidate();
        zoomMapSweeperView.invalidate();
    }

    private WritableMap generateWritableMap(int i, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("code", i);
        createMap.putString("message", str);
        return createMap;
    }
}

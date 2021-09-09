package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper;

import _m_j.fyf;
import _m_j.gbu;
import _m_j.gcr;
import _m_j.gcs;
import _m_j.gfr;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.ArrayList;
import java.util.Map;

public class MiotMapSweeperViewManager extends SimpleViewManager<ZoomMapSweeperView> {
    private Handler mHandler = null;
    public ZoomMapSweeperView mZoomMapSweeperView;
    private int maxPointX = -1;
    private int maxPointY = -1;
    private int minPointX = -1;
    private int minPointY = -1;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f8604O000000o;
        public gcs O00000Oo;
    }

    public String getName() {
        return "MHSweepingMap";
    }

    private void initHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper.MiotMapSweeperViewManager.AnonymousClass1 */

                public final void handleMessage(Message message) {
                    if (message.what == 1001 && MiotMapSweeperViewManager.this.mZoomMapSweeperView != null) {
                        O000000o o000000o = (O000000o) message.obj;
                        MapSweeperView mapSweeperView = MiotMapSweeperViewManager.this.mZoomMapSweeperView.getMapSweeperView();
                        gcs gcs = o000000o.O00000Oo;
                        String str = o000000o.f8604O000000o;
                        if (gcs != null) {
                            CommonSweeperView commonSweeperView = mapSweeperView.f8599O000000o.get(str);
                            if (commonSweeperView != null) {
                                commonSweeperView.O000000o(gcs.f17542O000000o, gcs.O00000Oo);
                            }
                            gcs O000000o2 = gcs.O000000o(gcs, mapSweeperView.O00000Oo);
                            if (commonSweeperView != null) {
                                commonSweeperView.O00000Oo(mapSweeperView.O000000o(O000000o2.f17542O000000o), mapSweeperView.O000000o(O000000o2.O00000Oo));
                            }
                        }
                    }
                }
            };
        }
    }

    /* access modifiers changed from: protected */
    public ZoomMapSweeperView createViewInstance(ThemedReactContext themedReactContext) {
        this.mZoomMapSweeperView = new ZoomMapSweeperView(themedReactContext);
        initData();
        return this.mZoomMapSweeperView;
    }

    private void initData() {
        this.minPointX = -1;
        this.maxPointX = -1;
        this.minPointY = -1;
        this.maxPointY = -1;
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("addMapWithPoints", 1, "cleanMapView", 2);
    }

    @ReactProp(customType = "Color", name = "wallColor")
    public void setWallColor(ZoomMapSweeperView zoomMapSweeperView, Integer num) {
        zoomMapSweeperView.getMapSweeperView().setWallColor(num.intValue());
    }

    @ReactProp(customType = "Color", name = "floorColor")
    public void setFloorColor(ZoomMapSweeperView zoomMapSweeperView, Integer num) {
        zoomMapSweeperView.getMapSweeperView().setFloorColor(num.intValue());
    }

    @ReactProp(customType = "Color", name = "lineColor")
    public void setLineColor(ZoomMapSweeperView zoomMapSweeperView, Integer num) {
        zoomMapSweeperView.getMapSweeperView().setLineColor(num.intValue());
    }

    @ReactProp(name = "imageSources")
    public void setImageSources(ZoomMapSweeperView zoomMapSweeperView, ReadableArray readableArray) {
        ReadableArray readableArray2 = readableArray;
        if (readableArray2 != null && readableArray.size() != 0) {
            gbu.O000000o("MiotMapSweeperViewManager-->setImages...");
            if (gfr.O0000OOo || gfr.O0000o0o) {
                gbu.O000000o("MiotMapSweeperViewManager-->setImages..." + readableArray.toString());
            }
            int size = readableArray.size();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                ReadableMap map = readableArray2.getMap(i2);
                ReadableArray O00000Oo = fyf.O00000Oo(map, "source");
                ReadableArray O00000Oo2 = fyf.O00000Oo(map, "bgSource");
                String O000000o2 = fyf.O000000o(map, "name", "");
                int O000000o3 = fyf.O000000o(fyf.O00000o0(map, "position"), "x", -1);
                int O000000o4 = fyf.O000000o(fyf.O00000o0(map, "position"), "y", -1);
                int O000000o5 = fyf.O000000o(map, "rotation", i);
                gcr gcr = new gcr(O00000Oo, O00000Oo2, O000000o2, O000000o3, O000000o4, O000000o5, fyf.O000000o(fyf.O00000o0(map, "size"), "w", -1), fyf.O000000o(fyf.O00000o0(map, "size"), "h", -1));
                if (gcr.f17541O000000o != null && gcr.f17541O000000o.size() > 0 && !TextUtils.isEmpty(gcr.O00000o0)) {
                    arrayList.add(gcr);
                }
                i2++;
                i = 0;
            }
            zoomMapSweeperView.getMapSweeperView().O000000o(arrayList);
        }
    }

    public void receiveCommand(ZoomMapSweeperView zoomMapSweeperView, int i, ReadableArray readableArray) {
        gbu.O000000o("MiotMapSweeperViewManager commandId=" + i + "   args=" + readableArray.toString());
        if (i == 1) {
            if (readableArray != null && readableArray.size() != 0) {
                addMapWithPoints(fyf.O000000o(readableArray.getMap(0), "points", ""), fyf.O000000o(readableArray.getMap(0), "name", ""), fyf.O000000o(readableArray.getMap(0), "autoCenter"), fyf.O000000o(readableArray.getMap(0), "scaleToFit"));
            } else {
                return;
            }
        } else if (i == 2) {
            cleanMapView(zoomMapSweeperView);
        }
        zoomMapSweeperView.getRootView().invalidate();
        zoomMapSweeperView.invalidate();
    }

    private void addMapWithPoints(String str, String str2, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str) && this.mZoomMapSweeperView != null) {
            String[] split = str.trim().split("\\s+");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < split.length; i += 3) {
                gcs gcs = new gcs(Integer.parseInt(split[i]), Integer.parseInt(split[i + 1]), Integer.parseInt(split[i + 2]));
                updataMinAndMaxPoint(gcs);
                if (gcs.O00000o0 == 2 || gcs.O00000o0 == 4) {
                    arrayList.add(gcs);
                } else if (gcs.O00000o0 == 1 || gcs.O00000o0 == 3) {
                    arrayList2.add(gcs);
                }
            }
            autoScallZoomMapSweeperView(z, z2);
            this.mZoomMapSweeperView.getMapSweeperView().O000000o(arrayList, arrayList2);
            if (TextUtils.isEmpty(str2)) {
                this.mZoomMapSweeperView.getMapSweeperView().O00000Oo(arrayList2);
            } else {
                this.mZoomMapSweeperView.getMapSweeperView().O000000o(arrayList2, str2);
            }
        }
    }

    private void autoScallZoomMapSweeperView(boolean z, boolean z2) {
        float f;
        float f2;
        if (!z2 || !this.mZoomMapSweeperView.O0000Oo0) {
            gbu.O000000o("MiotMapSweeperViewManager  scaleToFit=" + z2 + "  isScallEnable=" + this.mZoomMapSweeperView.O0000Oo0);
            return;
        }
        int i = this.maxPointX - this.minPointX;
        int i2 = this.maxPointY - this.minPointY;
        int abs = Math.abs(Math.max(i, i2));
        if (abs == 0) {
            abs = 10;
        }
        int i3 = 256 / abs;
        if (i3 < 2) {
            i3 = 2;
        } else if (((float) i3) > 10.0f) {
            i3 = 10;
        }
        this.mZoomMapSweeperView.setMaxZoom((float) i3);
        if (z) {
            int i4 = i3 - 1;
            int i5 = this.minPointX + (i >> 1);
            int i6 = this.minPointY + (i2 >> 1);
            gcs O000000o2 = gcs.O000000o(new gcs(i5 - 128, i6 - 128, 0), this.mZoomMapSweeperView.getMapSweeperView().getMapPointScale());
            int left = this.mZoomMapSweeperView.getMapSweeperView().getLeft();
            int top = this.mZoomMapSweeperView.getMapSweeperView().getTop();
            if (left == 0) {
                f = (float) (this.mZoomMapSweeperView.getMapSweeperView().getViewWidth() / 2);
            } else {
                f = ((float) left) + ((float) (this.mZoomMapSweeperView.getMapSweeperView().getViewWidth() / 2));
            }
            if (top == 0) {
                f2 = (float) (this.mZoomMapSweeperView.getMapSweeperView().getViewHeight() / 2);
            } else {
                f2 = ((float) (this.mZoomMapSweeperView.getMapSweeperView().getViewHeight() / 2)) + ((float) top);
            }
            float f3 = (float) i4;
            float width = ((float) this.mZoomMapSweeperView.getWidth()) - ((((float) this.mZoomMapSweeperView.getWidth()) * 0.5f) / f3);
            float width2 = (((float) this.mZoomMapSweeperView.getWidth()) * 0.5f) / f3;
            if (f < width2 || f > width) {
                f = (width2 + width) / 2.0f;
            }
            float height = ((float) this.mZoomMapSweeperView.getHeight()) - ((((float) this.mZoomMapSweeperView.getHeight()) * 0.5f) / f3);
            float height2 = (((float) this.mZoomMapSweeperView.getHeight()) * 0.5f) / f3;
            if (f2 < height2 || f2 > height) {
                f2 = (height2 + height) / 2.0f;
            }
            float f4 = f + ((float) O000000o2.f17542O000000o);
            float f5 = f2 + ((float) O000000o2.O00000Oo);
            if (gfr.O0000OOo || gfr.O0000Oo) {
                gbu.O000000o("MiotMapSweeperViewManager 移动中心位置  centerPointX=" + i5 + "  centerPointY=" + i6 + "  devidePoint.pointX=" + O000000o2.f17542O000000o + "  devidePoint.pointY=" + O000000o2.O00000Oo + "  tempCenterX=" + f4 + "  tempCenterY=" + f5 + "  checkBigX=" + width + "  checkSmallX=" + width2 + "  checkBigY=" + height + "  checkSmallY=" + height2);
            }
            this.mZoomMapSweeperView.O000000o(f3, f4, f5);
        } else {
            ZoomMapSweeperView zoomMapSweeperView = this.mZoomMapSweeperView;
            zoomMapSweeperView.O000000o((float) (i3 - 1), zoomMapSweeperView.O00000o, this.mZoomMapSweeperView.O00000oO);
        }
        this.mZoomMapSweeperView.getMapSweeperView().O000000o(1000L);
        gbu.O000000o("MiotMapSweeperViewManager  minPointX=" + this.minPointX + "  maxPointX=" + this.maxPointX + "  minPointY=" + this.minPointY + "  maxPointY=" + this.maxPointY + "  d=" + i3);
    }

    private void cleanMapView(ZoomMapSweeperView zoomMapSweeperView) {
        gcr gcr = new gcr(null, null, "", 1, 1, 0, 1, 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(gcr);
        zoomMapSweeperView.getMapSweeperView().O000000o(arrayList);
        zoomMapSweeperView.getMapSweeperView().O000000o();
        zoomMapSweeperView.getMapSweeperView().O00000Oo();
    }

    private void updataMinAndMaxPoint(gcs gcs) {
        if (this.minPointX == -1) {
            this.minPointX = gcs.f17542O000000o;
        }
        if (this.minPointY == -1) {
            this.minPointY = gcs.O00000Oo;
        }
        if (this.maxPointX == -1) {
            this.maxPointX = gcs.f17542O000000o;
        }
        if (this.maxPointY == -1) {
            this.maxPointY = gcs.O00000Oo;
        }
        if (gcs.f17542O000000o < this.minPointX) {
            this.minPointX = gcs.f17542O000000o;
        } else if (gcs.f17542O000000o > this.maxPointX) {
            this.maxPointX = gcs.f17542O000000o;
        }
        if (gcs.O00000Oo < this.minPointY) {
            this.minPointY = gcs.O00000Oo;
        } else if (gcs.O00000Oo > this.maxPointY) {
            this.maxPointY = gcs.O00000Oo;
        }
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ZoomMapSweeperView zoomMapSweeperView) {
        super.onAfterUpdateTransaction((View) zoomMapSweeperView);
        zoomMapSweeperView.getRootView().invalidate();
        zoomMapSweeperView.invalidate();
        gbu.O000000o("MiotMapSweeperViewManager-->onAfterUpdateTransaction...");
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        gbu.O000000o("MiotMapSweeperViewManager-->onCatalystInstanceDestroy...");
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1001);
        }
        this.mZoomMapSweeperView = null;
    }
}

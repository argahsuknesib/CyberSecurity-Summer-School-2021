package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper;

import _m_j.gbu;
import _m_j.gcr;
import _m_j.gcs;
import _m_j.gpc;
import _m_j.gsy;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSweeperView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    Map<String, CommonSweeperView> f8599O000000o;
    float O00000Oo;
    private MapBackgroundView O00000o;
    private Context O00000o0;
    private MapView O00000oO;
    private Map<String, gcr> O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private final Runnable O0000Oo;
    private boolean O0000Oo0;

    public MapSweeperView(Context context) {
        this(context, null);
    }

    public MapSweeperView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapSweeperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8599O000000o = new HashMap();
        this.O00000oo = new HashMap();
        this.O00000Oo = 1.0f;
        this.O0000Oo0 = true;
        this.O0000Oo = new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper.MapSweeperView.AnonymousClass1 */

            public final void run() {
                MapSweeperView mapSweeperView = MapSweeperView.this;
                mapSweeperView.measure(View.MeasureSpec.makeMeasureSpec(mapSweeperView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(MapSweeperView.this.getHeight(), 1073741824));
                MapSweeperView mapSweeperView2 = MapSweeperView.this;
                mapSweeperView2.layout(mapSweeperView2.getLeft(), MapSweeperView.this.getTop(), MapSweeperView.this.getRight(), MapSweeperView.this.getBottom());
            }
        };
        this.O00000o0 = context;
        this.O00000o = new MapBackgroundView(context);
        this.O00000oO = new MapView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.O00000o, layoutParams);
        addView(this.O00000oO, layoutParams);
    }

    public final void O000000o(List<gcr> list) {
        List<gcr> list2 = list;
        if (list.size() != 0) {
            if (this.f8599O000000o == null) {
                this.f8599O000000o = new HashMap();
            }
            if (this.O00000oo == null) {
                this.O00000oo = new HashMap();
            }
            O00000o0();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.O00000oo.put(list2.get(i).O00000o0, list2.get(i));
            }
            for (Map.Entry next : this.O00000oo.entrySet()) {
                String str = (String) next.getKey();
                gcr gcr = (gcr) next.getValue();
                CommonSweeperView commonSweeperView = this.f8599O000000o.get(str);
                if (gcr != null) {
                    if (commonSweeperView == null) {
                        CommonSweeperView commonSweeperView2 = new CommonSweeperView(this.O00000o0);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        if (gcr != null) {
                            if (commonSweeperView2.getChildCount() > 0) {
                                commonSweeperView2.removeAllViews();
                            }
                            int i2 = 20;
                            int i3 = gcr.O0000OOo <= 0 ? 20 : gcr.O0000OOo;
                            if (gcr.O0000O0o > 0) {
                                i2 = gcr.O0000O0o;
                            }
                            commonSweeperView2.O00000Oo = commonSweeperView2.O000000o(gcr.O00000Oo, gcr.O00000oo);
                            if (commonSweeperView2.O00000Oo != null) {
                                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(gpc.O00000o0(commonSweeperView2.f8596O000000o, (float) i2), gpc.O00000o0(commonSweeperView2.f8596O000000o, (float) i3));
                                layoutParams2.addRule(13, -1);
                                commonSweeperView2.O00000o = layoutParams2.width;
                                commonSweeperView2.O00000oO = layoutParams2.height;
                                layoutParams2.width = layoutParams2.width < 3 ? layoutParams2.width : layoutParams2.width - 2;
                                layoutParams2.height = layoutParams2.height < 3 ? layoutParams2.height : layoutParams2.height - 2;
                                commonSweeperView2.O00000Oo.setVisibility(4);
                                commonSweeperView2.addView(commonSweeperView2.O00000Oo, layoutParams2);
                            }
                            commonSweeperView2.O00000o0 = commonSweeperView2.O000000o(gcr.f17541O000000o, gcr.O00000oo);
                            if (commonSweeperView2.O00000o0 != null) {
                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(gpc.O00000o0(commonSweeperView2.f8596O000000o, (float) i2), gpc.O00000o0(commonSweeperView2.f8596O000000o, (float) i3));
                                layoutParams3.addRule(13, -1);
                                commonSweeperView2.O00000o = layoutParams3.width;
                                commonSweeperView2.O00000oO = layoutParams3.height;
                                commonSweeperView2.O00000o0.setVisibility(4);
                                commonSweeperView2.addView(commonSweeperView2.O00000o0, layoutParams3);
                            }
                            commonSweeperView2.O00000oo.sendEmptyMessageDelayed(2, 500);
                            commonSweeperView2.O00000oo.sendEmptyMessageDelayed(3, 500);
                            int i4 = 126;
                            int i5 = gcr.O00000o < 0 ? 126 : gcr.O00000o;
                            if (gcr.O00000oO >= 0) {
                                i4 = gcr.O00000oO;
                            }
                            commonSweeperView2.O000000o(i5, i4);
                        }
                        addView(commonSweeperView2, layoutParams);
                        this.f8599O000000o.put(gcr.O00000o0, commonSweeperView2);
                        if (!this.O0000Oo0) {
                            O000000o(commonSweeperView2, gcr);
                        }
                    } else {
                        if (gcr != null) {
                            if (commonSweeperView.O00000Oo != null) {
                                if (gcr.O00000Oo != null && gcr.O00000Oo.size() > 0) {
                                    commonSweeperView.O00000Oo.setSource(gcr.O00000Oo);
                                    commonSweeperView.O00000Oo.maybeUpdateView();
                                }
                                if (gcr.O00000Oo == null) {
                                    commonSweeperView.O00000Oo();
                                    commonSweeperView.O00000Oo.setVisibility(4);
                                } else {
                                    commonSweeperView.O00000Oo.setVisibility(0);
                                    commonSweeperView.O000000o();
                                }
                            }
                            if (commonSweeperView.O00000o0 != null) {
                                commonSweeperView.O00000o0.setSource(gcr.f17541O000000o);
                                commonSweeperView.O00000o0.maybeUpdateView();
                                if (gcr.f17541O000000o == null) {
                                    commonSweeperView.O00000o0.setVisibility(4);
                                } else {
                                    commonSweeperView.O00000o0.setVisibility(0);
                                    O000000o(commonSweeperView, gcr);
                                }
                            }
                        }
                        O000000o(commonSweeperView, gcr);
                    }
                } else if (commonSweeperView != null) {
                    this.f8599O000000o.remove(str);
                    removeView(commonSweeperView);
                }
            }
        }
    }

    private void O000000o(CommonSweeperView commonSweeperView, gcr gcr) {
        if (gcr != null && commonSweeperView != null && gcr.O00000o >= 0 && gcr.O00000oO >= 0) {
            gcs gcs = new gcs(gcr.O00000o, gcr.O00000oO, 1);
            commonSweeperView.O000000o(gcr.O00000o, gcr.O00000oO);
            gcs.O000000o(gcs, this.O00000Oo);
            commonSweeperView.O00000Oo(O000000o(gcs.f17542O000000o), O000000o(gcs.O00000Oo));
        }
    }

    private void O00000o0() {
        for (Map.Entry<String, gcr> key : this.O00000oo.entrySet()) {
            this.O00000oo.put((String) key.getKey(), null);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.O0000O0o, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.O0000OOo, 1073741824);
        this.O00000Oo = ((float) this.O0000O0o) / 255.0f;
        super.onMeasure(makeMeasureSpec2, makeMeasureSpec);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O0000Oo0) {
            this.O0000Oo0 = false;
            for (Map.Entry next : this.O00000oo.entrySet()) {
                gcr gcr = (gcr) next.getValue();
                CommonSweeperView commonSweeperView = this.f8599O000000o.get((String) next.getKey());
                if (commonSweeperView != null) {
                    O000000o(commonSweeperView, gcr);
                }
            }
        }
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.O0000Oo);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        gsy.O000000o(4, "lvjie", "MapSweeperView-->mIsFirstInit=" + this.O0000Oo0 + "   hasWindowFocus=" + z);
    }

    public final void O000000o(List<gcs> list, String str) {
        if (list.size() != 0) {
            CommonSweeperView commonSweeperView = this.f8599O000000o.get(str);
            int size = list.size();
            if (commonSweeperView != null) {
                int i = size - 1;
                commonSweeperView.O000000o(list.get(i).f17542O000000o, list.get(i).O00000Oo);
            }
            List<gcs> O000000o2 = gcs.O000000o(list, this.O00000Oo);
            if (commonSweeperView != null) {
                int i2 = size - 1;
                commonSweeperView.O00000Oo(O000000o(O000000o2.get(i2).f17542O000000o), O000000o(O000000o2.get(i2).O00000Oo));
            }
        }
    }

    public final void O000000o(List<gcs> list, List<gcs> list2) {
        List<gcs> O000000o2 = gcs.O000000o(list, this.O00000Oo);
        List<gcs> O000000o3 = gcs.O000000o(list2, this.O00000Oo);
        MapBackgroundView mapBackgroundView = this.O00000o;
        if (O000000o2 != null && O000000o2.size() > 0) {
            int size = O000000o2.size();
            for (int i = 0; i < size; i++) {
                mapBackgroundView.O00000Oo.put(O000000o2.get(i).O000000o(), O000000o2.get(i));
            }
        }
        if (O000000o3 != null && O000000o3.size() > 0) {
            int size2 = O000000o3.size();
            for (int i2 = 0; i2 < size2; i2++) {
                mapBackgroundView.O00000o0.put(O000000o3.get(i2).O000000o(), O000000o3.get(i2));
            }
        }
        mapBackgroundView.invalidate();
    }

    /* access modifiers changed from: package-private */
    public final int O000000o(int i) {
        return (this.O0000OOo >> 1) - i;
    }

    public final void O00000Oo(List<gcs> list) {
        if (list.size() != 0) {
            gcs.O000000o(list, this.O00000Oo);
        }
    }

    public final void O000000o() {
        MapView mapView = this.O00000oO;
        if (mapView != null) {
            if (mapView.f8601O000000o != null) {
                mapView.f8601O000000o.reset();
                mapView.invalidate();
            }
            mapView.O00000Oo = true;
        }
    }

    public final void O00000Oo() {
        MapBackgroundView mapBackgroundView = this.O00000o;
        if (mapBackgroundView != null) {
            if (mapBackgroundView.f8598O000000o != null) {
                mapBackgroundView.f8598O000000o.clear();
            }
            if (mapBackgroundView.O00000Oo != null) {
                mapBackgroundView.O00000Oo.clear();
            }
            if (mapBackgroundView.O00000o0 != null) {
                mapBackgroundView.O00000o0.clear();
            }
            mapBackgroundView.invalidate();
        }
    }

    public void setWallColor(int i) {
        this.O00000o.setSquareColor(i);
    }

    public void setFloorColor(int i) {
        this.O00000o.setFloorColor(i);
    }

    public void setLineColor(int i) {
        this.O00000oO.setLineColor(i);
    }

    public void setWidth(int i) {
        this.O0000OOo = i;
    }

    public void setHeight(int i) {
        this.O0000O0o = i;
    }

    public int getViewHeight() {
        return this.O0000O0o;
    }

    public int getViewWidth() {
        return this.O0000OOo;
    }

    public float getMapPointScale() {
        return this.O00000Oo;
    }

    public final void O000000o(long j) {
        Map<String, CommonSweeperView> map = this.f8599O000000o;
        if (map != null) {
            for (Map.Entry<String, CommonSweeperView> value : map.entrySet()) {
                CommonSweeperView commonSweeperView = (CommonSweeperView) value.getValue();
                if (commonSweeperView != null) {
                    gbu.O000000o("CommonSweeperView startSweeperCircularAnimatorDelayed...");
                    commonSweeperView.O00000oo.sendEmptyMessageDelayed(1, j);
                }
            }
        }
    }
}

package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.jiqid.writepad.view.manager;

import _m_j.gac;
import _m_j.gag;
import _m_j.md;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.jiqid.writepad.view.widget.OrbitView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class OrbitViewManager extends ViewGroupManager<OrbitView> {
    public String getName() {
        return "MHOrbitView";
    }

    /* access modifiers changed from: protected */
    public OrbitView createViewInstance(ThemedReactContext themedReactContext) {
        return new OrbitView(themedReactContext);
    }

    @ReactProp(customType = "Color", name = "lineColor")
    public void setLineColor(OrbitView orbitView, int i) {
        orbitView.setLineColor(i);
    }

    @ReactProp(name = "lineWidth")
    public void setLineWidth(OrbitView orbitView, float f) {
        orbitView.setLineWidth(f);
    }

    @ReactProp(name = "scale")
    public void setScale(OrbitView orbitView, float f) {
        orbitView.setScale(f);
    }

    @ReactProp(name = "deviceWidth")
    public void setDeviceWidth(OrbitView orbitView, int i) {
        orbitView.setDeviceWidth(i);
    }

    @ReactProp(name = "deviceHeight")
    public void setDeviceHeight(OrbitView orbitView, int i) {
        orbitView.setDeviceHeight(i);
    }

    @ReactProp(name = "maxPressure")
    public void setMaxPressure(OrbitView orbitView, int i) {
        orbitView.setDevicePressure(i);
    }

    @ReactProp(name = "revokeTimes")
    public void setRevokeTimes(OrbitView orbitView, int i) {
        orbitView.setRevokeTimes(i);
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("displayPoints", 1, "revoke", 2, "clear", 3);
    }

    public void receiveCommand(OrbitView orbitView, int i, ReadableArray readableArray) {
        ReadableArray array;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    orbitView.O0000o0 = null;
                    orbitView.O0000o0o = null;
                    if (orbitView.O0000Ooo != null) {
                        orbitView.O0000Ooo.recycle();
                        orbitView.O0000Ooo = null;
                    }
                    if (orbitView.O0000o0O != null) {
                        orbitView.O0000o0O.recycle();
                        orbitView.O0000o0O = null;
                    }
                    if (orbitView.O0000o00 != null) {
                        orbitView.O0000o00.recycle();
                        orbitView.O0000o00 = null;
                    }
                    if (orbitView.O0000oO0 != null) {
                        orbitView.O0000oO0.clear();
                    }
                    orbitView.O0000OoO = null;
                    orbitView.invalidate();
                }
            } else if (orbitView.O000000o()) {
                orbitView.O0000oO0.removeLast();
                if (orbitView.O0000oO0 != null && orbitView.O0000oO0.size() > 0) {
                    orbitView.O0000Ooo = orbitView.O0000oO0.getLast().copy(Bitmap.Config.ARGB_8888, true);
                    orbitView.O0000o0.setBitmap(orbitView.O0000Ooo);
                    orbitView.invalidate();
                }
            }
        } else if (readableArray != null && (array = readableArray.getArray(0)) != null) {
            List<md> O000000o2 = gag.O000000o(array);
            if (O000000o2.size() > 0) {
                int i2 = (int) (orbitView.O00000oO * ((float) orbitView.f8433O000000o));
                int i3 = (int) (orbitView.O00000oO * ((float) orbitView.O00000Oo));
                if (orbitView.O0000Ooo == null) {
                    orbitView.O0000Ooo = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                }
                if (orbitView.O0000o0 == null) {
                    orbitView.O0000o0 = new Canvas(orbitView.O0000Ooo);
                }
                if (orbitView.O0000o00 == null) {
                    orbitView.O0000o00 = Bitmap.createBitmap((int) (orbitView.O00000o * ((float) orbitView.f8433O000000o)), (int) (orbitView.O00000o * ((float) orbitView.O00000Oo)), Bitmap.Config.ARGB_8888);
                }
                if (orbitView.O0000o0O == null) {
                    orbitView.O0000o0O = gac.O000000o(orbitView.O0000OOo, orbitView.O0000o00);
                }
                if (orbitView.O0000o0o == null) {
                    orbitView.O0000o0o = new Canvas(orbitView.O0000o0O);
                }
                if (orbitView.O0000OoO != null) {
                    O000000o2.add(0, orbitView.O0000OoO);
                }
                int i4 = 0;
                while (i4 < O000000o2.size() - 1) {
                    md mdVar = O000000o2.get(i4);
                    i4++;
                    md mdVar2 = O000000o2.get(i4);
                    if (!(mdVar == null || mdVar2 == null)) {
                        if (mdVar.O00000o <= 0 && mdVar2.O00000o > 0) {
                            orbitView.O0000O0o.moveTo(mdVar.f2180O000000o * orbitView.O00000oO, mdVar.O00000Oo * orbitView.O00000oO);
                        }
                        if (mdVar.O00000o > 0 && mdVar2.O00000o > 0) {
                            if (orbitView.O00000oo != null) {
                                orbitView.O00000oo.setStrokeWidth(orbitView.O0000Oo0 * (mdVar.O00000o0 / ((float) orbitView.O00000o0)));
                                orbitView.O00000oo.setColor(orbitView.O0000Oo);
                            }
                            OrbitView.O000000o(new float[]{mdVar.f2180O000000o * orbitView.O00000oO, mdVar.O00000Oo * orbitView.O00000oO, mdVar2.f2180O000000o * orbitView.O00000oO, mdVar2.O00000Oo * orbitView.O00000oO}, orbitView.O0000o0, orbitView.O00000oo);
                            OrbitView.O000000o(new float[]{mdVar.f2180O000000o * orbitView.O00000o, mdVar.O00000Oo * orbitView.O00000o, mdVar2.f2180O000000o * orbitView.O00000o, mdVar2.O00000Oo * orbitView.O00000o}, orbitView.O0000o0o, orbitView.O00000oo);
                        }
                        if (mdVar.O00000o <= 0 && mdVar2.O00000o <= 0 && orbitView.O0000O0o != null) {
                            orbitView.O0000O0o.reset();
                        }
                        if (mdVar.O00000o > 0 && mdVar2.O00000o <= 0 && orbitView.O0000Ooo != null) {
                            Bitmap copy = orbitView.O0000Ooo.copy(Bitmap.Config.ARGB_8888, true);
                            if (orbitView.O0000oO0 == null) {
                                orbitView.O0000oO0 = new LinkedList<>();
                            } else if (orbitView.O0000oO0.size() > orbitView.O0000o) {
                                orbitView.O0000oO0.removeFirst();
                            }
                            orbitView.O0000oO0.add(copy);
                        }
                    }
                }
                orbitView.O0000OoO = O000000o2.get(O000000o2.size() - 1);
                orbitView.invalidate();
            }
        }
    }
}

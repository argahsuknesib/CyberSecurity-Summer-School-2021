package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

public class ShapeData {
    private boolean closed;
    private final List<CubicCurveData> curves = new ArrayList();
    private PointF initialPoint;

    public ShapeData(PointF pointF, boolean z, List<CubicCurveData> list) {
        this.initialPoint = pointF;
        this.closed = z;
        this.curves.addAll(list);
    }

    public ShapeData() {
    }

    private void setInitialPoint(float f, float f2) {
        if (this.initialPoint == null) {
            this.initialPoint = new PointF();
        }
        this.initialPoint.set(f, f2);
    }

    public PointF getInitialPoint() {
        return this.initialPoint;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<CubicCurveData> getCurves() {
        return this.curves;
    }

    public void interpolateBetween(ShapeData shapeData, ShapeData shapeData2, float f) {
        if (this.initialPoint == null) {
            this.initialPoint = new PointF();
        }
        this.closed = shapeData.isClosed() || shapeData2.isClosed();
        if (shapeData.getCurves().size() != shapeData2.getCurves().size()) {
            L.warn("Curves must have the same number of control points. Shape 1: " + shapeData.getCurves().size() + "\tShape 2: " + shapeData2.getCurves().size());
        }
        if (this.curves.isEmpty()) {
            int min = Math.min(shapeData.getCurves().size(), shapeData2.getCurves().size());
            for (int i = 0; i < min; i++) {
                this.curves.add(new CubicCurveData());
            }
        }
        PointF initialPoint2 = shapeData.getInitialPoint();
        PointF initialPoint3 = shapeData2.getInitialPoint();
        setInitialPoint(MiscUtils.lerp(initialPoint2.x, initialPoint3.x, f), MiscUtils.lerp(initialPoint2.y, initialPoint3.y, f));
        for (int size = this.curves.size() - 1; size >= 0; size--) {
            CubicCurveData cubicCurveData = shapeData.getCurves().get(size);
            CubicCurveData cubicCurveData2 = shapeData2.getCurves().get(size);
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF controlPoint2 = cubicCurveData.getControlPoint2();
            PointF vertex = cubicCurveData.getVertex();
            PointF controlPoint12 = cubicCurveData2.getControlPoint1();
            PointF controlPoint22 = cubicCurveData2.getControlPoint2();
            PointF vertex2 = cubicCurveData2.getVertex();
            this.curves.get(size).setControlPoint1(MiscUtils.lerp(controlPoint1.x, controlPoint12.x, f), MiscUtils.lerp(controlPoint1.y, controlPoint12.y, f));
            this.curves.get(size).setControlPoint2(MiscUtils.lerp(controlPoint2.x, controlPoint22.x, f), MiscUtils.lerp(controlPoint2.y, controlPoint22.y, f));
            this.curves.get(size).setVertex(MiscUtils.lerp(vertex.x, vertex2.x, f), MiscUtils.lerp(vertex.y, vertex2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.curves.size() + "closed=" + this.closed + '}';
    }
}

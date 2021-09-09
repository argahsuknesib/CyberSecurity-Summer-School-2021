package _m_j;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;
import com.horcrux.svg.VirtualView;

@SuppressLint({"ViewConstructor"})
class bai extends VirtualView {
    public void draw(Canvas canvas, Paint paint, float f) {
    }

    public Path getPath(Canvas canvas, Paint paint) {
        return null;
    }

    public int hitTest(float[] fArr) {
        return -1;
    }

    public boolean isResponsible() {
        return false;
    }

    bai(ReactContext reactContext) {
        super(reactContext);
    }
}

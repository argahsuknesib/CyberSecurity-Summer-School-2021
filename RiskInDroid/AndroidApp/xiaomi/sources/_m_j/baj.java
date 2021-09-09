package _m_j;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.horcrux.svg.VirtualView;

@SuppressLint({"ViewConstructor"})
public final class baj extends bai {
    public final void draw(Canvas canvas, Paint paint, float f) {
    }

    public baj(ReactContext reactContext) {
        super(reactContext);
    }

    public final void saveDefinition() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof VirtualView) {
                ((VirtualView) childAt).saveDefinition();
            }
        }
    }
}

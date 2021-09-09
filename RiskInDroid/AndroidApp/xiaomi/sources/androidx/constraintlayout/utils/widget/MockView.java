package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class MockView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    protected String f2798O000000o = null;
    private Paint O00000Oo = new Paint();
    private Paint O00000o = new Paint();
    private Paint O00000o0 = new Paint();
    private boolean O00000oO = true;
    private boolean O00000oo = true;
    private Rect O0000O0o = new Rect();
    private int O0000OOo = Color.argb(255, 0, 0, 0);
    private int O0000Oo = Color.argb(255, 50, 50, 50);
    private int O0000Oo0 = Color.argb(255, 200, 200, 200);
    private int O0000OoO = 4;

    public MockView(Context context) {
        super(context);
        O000000o(context, null);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mock_diagonalsColor, R.attr.mock_label, R.attr.mock_labelBackgroundColor, R.attr.mock_labelColor, R.attr.mock_showDiagonals, R.attr.mock_showLabel});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 1) {
                    this.f2798O000000o = obtainStyledAttributes.getString(index);
                } else if (index == 4) {
                    this.O00000oO = obtainStyledAttributes.getBoolean(index, this.O00000oO);
                } else if (index == 0) {
                    this.O0000OOo = obtainStyledAttributes.getColor(index, this.O0000OOo);
                } else if (index == 2) {
                    this.O0000Oo = obtainStyledAttributes.getColor(index, this.O0000Oo);
                } else if (index == 3) {
                    this.O0000Oo0 = obtainStyledAttributes.getColor(index, this.O0000Oo0);
                } else if (index == 5) {
                    this.O00000oo = obtainStyledAttributes.getBoolean(index, this.O00000oo);
                }
            }
        }
        if (this.f2798O000000o == null) {
            try {
                this.f2798O000000o = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.O00000Oo.setColor(this.O0000OOo);
        this.O00000Oo.setAntiAlias(true);
        this.O00000o0.setColor(this.O0000Oo0);
        this.O00000o0.setAntiAlias(true);
        this.O00000o.setColor(this.O0000Oo);
        this.O0000OoO = Math.round(((float) this.O0000OoO) * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.O00000oO) {
            width--;
            height--;
            float f = (float) width;
            float f2 = (float) height;
            canvas.drawLine(0.0f, 0.0f, f, f2, this.O00000Oo);
            Canvas canvas2 = canvas;
            float f3 = f;
            canvas2.drawLine(0.0f, f2, f3, 0.0f, this.O00000Oo);
            canvas2.drawLine(0.0f, 0.0f, f3, 0.0f, this.O00000Oo);
            float f4 = f;
            float f5 = f2;
            canvas2.drawLine(f4, 0.0f, f3, f5, this.O00000Oo);
            float f6 = f2;
            canvas2.drawLine(f4, f6, 0.0f, f5, this.O00000Oo);
            canvas2.drawLine(0.0f, f6, 0.0f, 0.0f, this.O00000Oo);
        }
        String str = this.f2798O000000o;
        if (str != null && this.O00000oo) {
            this.O00000o0.getTextBounds(str, 0, str.length(), this.O0000O0o);
            float width2 = ((float) (width - this.O0000O0o.width())) / 2.0f;
            float height2 = (((float) (height - this.O0000O0o.height())) / 2.0f) + ((float) this.O0000O0o.height());
            this.O0000O0o.offset((int) width2, (int) height2);
            Rect rect = this.O0000O0o;
            rect.set(rect.left - this.O0000OoO, this.O0000O0o.top - this.O0000OoO, this.O0000O0o.right + this.O0000OoO, this.O0000O0o.bottom + this.O0000OoO);
            canvas.drawRect(this.O0000O0o, this.O00000o);
            canvas.drawText(this.f2798O000000o, width2, height2, this.O00000o0);
        }
    }
}

package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.smarthome.R;

public class Placeholder extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    int f2808O000000o = -1;
    View O00000Oo = null;
    int O00000o0 = 4;

    public Placeholder(Context context) {
        super(context);
        O000000o(null);
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    private void O000000o(AttributeSet attributeSet) {
        super.setVisibility(this.O00000o0);
        this.f2808O000000o = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.content, R.attr.placeholder_emptyVisibility});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.f2808O000000o = obtainStyledAttributes.getResourceId(index, this.f2808O000000o);
                } else if (index == 1) {
                    this.O00000o0 = obtainStyledAttributes.getInt(index, this.O00000o0);
                }
            }
        }
    }

    public void setEmptyVisibility(int i) {
        this.O00000o0 = i;
    }

    public int getEmptyVisibility() {
        return this.O00000o0;
    }

    public View getContent() {
        return this.O00000Oo;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f2808O000000o != i) {
            View view = this.O00000Oo;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.LayoutParams) this.O00000Oo.getLayoutParams()).O000Ooo = false;
                this.O00000Oo = null;
            }
            this.f2808O000000o = i;
            if (i != -1 && (findViewById = ((View) getParent()).findViewById(i)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }
}

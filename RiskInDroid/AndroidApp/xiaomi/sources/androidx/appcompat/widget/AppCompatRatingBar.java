package androidx.appcompat.widget;

import _m_j.OOOO0;
import _m_j.Oo000;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import com.xiaomi.smarthome.R;

public class AppCompatRatingBar extends RatingBar {

    /* renamed from: O000000o  reason: collision with root package name */
    private final OOOO0 f2706O000000o;

    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Oo000.O000000o(this, getContext());
        this.f2706O000000o = new OOOO0(this);
        this.f2706O000000o.O000000o(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmap = this.f2706O000000o.f12325O000000o;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}

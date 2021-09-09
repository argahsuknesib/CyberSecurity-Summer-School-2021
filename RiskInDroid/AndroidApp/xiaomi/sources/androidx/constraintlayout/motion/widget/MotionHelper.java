package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.smarthome.R;

public class MotionHelper extends ConstraintHelper implements MotionLayout.O0000Oo0 {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f2777O000000o = false;
    boolean O00000Oo = false;
    private float O00000o;
    protected View[] O00000o0;

    public MotionHelper(Context context) {
        super(context);
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    public final void O000000o(AttributeSet attributeSet) {
        super.O000000o(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.onHide, R.attr.onShow});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 1) {
                    this.f2777O000000o = obtainStyledAttributes.getBoolean(index, this.f2777O000000o);
                } else if (index == 0) {
                    this.O00000Oo = obtainStyledAttributes.getBoolean(index, this.O00000Oo);
                }
            }
        }
    }

    public float getProgress() {
        return this.O00000o;
    }

    public void setProgress(float f) {
        this.O00000o = f;
        if (this.O0000OoO > 0) {
            this.O00000o0 = O00000o0((ConstraintLayout) getParent());
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i);
        }
    }
}

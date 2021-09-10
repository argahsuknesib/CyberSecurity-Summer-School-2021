package com.transitionseverywhere;

import _m_j.drn;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import com.xiaomi.smarthome.R;

@TargetApi(21)
public class ChangeTransform extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Property<View, Matrix> f5905O000000o;
    private static final String[] O00000o0 = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    public boolean O00000Oo = true;
    private Matrix O000O0o0 = new Matrix();
    private boolean O00oOoOo = true;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f5905O000000o = new Property<View, Matrix>(Matrix.class, "animationMatrix") {
                /* class com.transitionseverywhere.ChangeTransform.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ Object get(Object obj) {
                    return null;
                }

                public final /* synthetic */ void set(Object obj, Object obj2) {
                    drn.O000000o((View) obj, (Matrix) obj2);
                }
            };
        } else {
            f5905O000000o = null;
        }
    }

    public ChangeTransform() {
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.reparent, R.attr.reparentWithOverlay});
        this.O00000Oo = obtainStyledAttributes.getBoolean(1, true);
        this.O00oOoOo = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }
}

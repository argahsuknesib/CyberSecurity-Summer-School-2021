package com.transitionseverywhere;

import _m_j.drj;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.widget.ImageView;

@TargetApi(14)
public class ChangeImageTransform extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f5904O000000o = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    private static final Property<ImageView, Matrix> O00000Oo;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            O00000Oo = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
                /* class com.transitionseverywhere.ChangeImageTransform.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ Object get(Object obj) {
                    return null;
                }

                public final /* synthetic */ void set(Object obj, Object obj2) {
                    drj.O000000o((ImageView) obj, (Matrix) obj2);
                }
            };
        } else {
            O00000Oo = null;
        }
    }

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

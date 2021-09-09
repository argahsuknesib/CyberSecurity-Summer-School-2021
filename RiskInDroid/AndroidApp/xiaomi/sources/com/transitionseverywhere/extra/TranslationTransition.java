package com.transitionseverywhere.extra;

import _m_j.drk;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.transitionseverywhere.Transition;

@TargetApi(14)
public class TranslationTransition extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final drk<View> f5914O000000o;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f5914O000000o = new drk<View>() {
                /* class com.transitionseverywhere.extra.TranslationTransition.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ PointF O000000o(Object obj) {
                    return O000000o((View) obj);
                }

                public final /* synthetic */ Object get(Object obj) {
                    return O000000o((View) obj);
                }

                public final /* synthetic */ void set(Object obj, Object obj2) {
                    View view = (View) obj;
                    PointF pointF = (PointF) obj2;
                    view.setTranslationX(pointF.x);
                    view.setTranslationY(pointF.y);
                }

                private static PointF O000000o(View view) {
                    return new PointF(view.getTranslationX(), view.getTranslationY());
                }
            };
        } else {
            f5914O000000o = null;
        }
    }

    public TranslationTransition() {
    }

    public TranslationTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

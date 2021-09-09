package com.transitionseverywhere;

import _m_j.drn;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;

@TargetApi(14)
public class ChangeClipBounds extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Property<View, Rect> f5903O000000o;
    private static final String[] O00000Oo = {"android:clipBounds:clip"};

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f5903O000000o = new Property<View, Rect>(Rect.class, "clipBounds") {
                /* class com.transitionseverywhere.ChangeClipBounds.AnonymousClass1 */

                public final /* synthetic */ Object get(Object obj) {
                    return drn.O000000o((View) obj);
                }

                public final /* synthetic */ void set(Object obj, Object obj2) {
                    drn.O000000o((View) obj, (Rect) obj2);
                }
            };
        } else {
            f5903O000000o = null;
        }
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

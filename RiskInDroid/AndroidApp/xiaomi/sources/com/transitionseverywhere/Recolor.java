package com.transitionseverywhere;

import _m_j.dri;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.widget.TextView;

@TargetApi(14)
public class Recolor extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Property<TextView, Integer> f5908O000000o;
    public static final Property<ColorDrawable, Integer> O00000Oo;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f5908O000000o = new dri<TextView>() {
                /* class com.transitionseverywhere.Recolor.AnonymousClass1 */

                public final /* synthetic */ void O000000o(Object obj, int i) {
                    ((TextView) obj).setTextColor(i);
                }

                public final /* synthetic */ Integer O000000o(Object obj) {
                    return 0;
                }

                public final /* synthetic */ Object get(Object obj) {
                    return 0;
                }
            }.O000000o();
            O00000Oo = new dri<ColorDrawable>() {
                /* class com.transitionseverywhere.Recolor.AnonymousClass2 */

                public final /* synthetic */ Integer O000000o(Object obj) {
                    return Integer.valueOf(((ColorDrawable) obj).getColor());
                }

                public final /* synthetic */ void O000000o(Object obj, int i) {
                    ((ColorDrawable) obj).setColor(i);
                }

                public final /* synthetic */ Object get(Object obj) {
                    return Integer.valueOf(((ColorDrawable) obj).getColor());
                }
            }.O000000o();
            return;
        }
        f5908O000000o = null;
        O00000Oo = null;
    }

    public Recolor() {
    }

    public Recolor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

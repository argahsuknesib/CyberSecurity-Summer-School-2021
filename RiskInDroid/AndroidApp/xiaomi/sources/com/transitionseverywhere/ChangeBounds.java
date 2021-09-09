package com.transitionseverywhere;

import _m_j.drk;
import _m_j.drn;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

@TargetApi(14)
public class ChangeBounds extends Transition {
    private static final drk<O000000o> O000O0o;
    private static final drk<Drawable> O000O0o0;
    private static final drk<O000000o> O000O0oO;
    private static final drk<View> O000O0oo;
    private static final drk<View> O000OO00;
    private static final drk<View> O000OO0o;
    private static final String[] O00oOoOo = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: O000000o  reason: collision with root package name */
    int[] f5900O000000o = new int[2];
    boolean O00000Oo = false;
    boolean O00000o0 = false;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            O000O0o0 = new drk<Drawable>() {
                /* class com.transitionseverywhere.ChangeBounds.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                private Rect f5901O000000o = new Rect();

                public final /* synthetic */ void set(Object obj, Object obj2) {
                    Drawable drawable = (Drawable) obj;
                    PointF pointF = (PointF) obj2;
                    drawable.copyBounds(this.f5901O000000o);
                    this.f5901O000000o.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                    drawable.setBounds(this.f5901O000000o);
                }

                /* access modifiers changed from: private */
                /* renamed from: O000000o */
                public PointF get(Drawable drawable) {
                    drawable.copyBounds(this.f5901O000000o);
                    return new PointF((float) this.f5901O000000o.left, (float) this.f5901O000000o.top);
                }
            };
            O000O0o = new drk<O000000o>() {
                /* class com.transitionseverywhere.ChangeBounds.AnonymousClass2 */

                public final /* synthetic */ void set(Object obj, Object obj2) {
                    O000000o o000000o = (O000000o) obj;
                    PointF pointF = (PointF) obj2;
                    o000000o.f5902O000000o = Math.round(pointF.x);
                    o000000o.O00000Oo = Math.round(pointF.y);
                    o000000o.O00000oO = true;
                    if (o000000o.O00000oo) {
                        o000000o.O000000o();
                    }
                }
            };
            O000O0oO = new drk<O000000o>() {
                /* class com.transitionseverywhere.ChangeBounds.AnonymousClass3 */

                public final /* synthetic */ void set(Object obj, Object obj2) {
                    O000000o o000000o = (O000000o) obj;
                    PointF pointF = (PointF) obj2;
                    o000000o.O00000o0 = Math.round(pointF.x);
                    o000000o.O00000o = Math.round(pointF.y);
                    o000000o.O00000oo = true;
                    if (o000000o.O00000oO) {
                        o000000o.O000000o();
                    }
                }
            };
            O000O0oo = new drk<View>() {
                /* class com.transitionseverywhere.ChangeBounds.AnonymousClass4 */

                public final /* synthetic */ void set(Object obj, Object obj2) {
                    View view = (View) obj;
                    PointF pointF = (PointF) obj2;
                    drn.O000000o(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
                }
            };
            O000OO00 = new drk<View>() {
                /* class com.transitionseverywhere.ChangeBounds.AnonymousClass5 */

                public final /* synthetic */ void set(Object obj, Object obj2) {
                    View view = (View) obj;
                    PointF pointF = (PointF) obj2;
                    drn.O000000o(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
                }
            };
            O000OO0o = new drk<View>() {
                /* class com.transitionseverywhere.ChangeBounds.AnonymousClass6 */

                public final /* synthetic */ void set(Object obj, Object obj2) {
                    View view = (View) obj;
                    PointF pointF = (PointF) obj2;
                    int round = Math.round(pointF.x);
                    int round2 = Math.round(pointF.y);
                    drn.O000000o(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
                }
            };
            return;
        }
        O000O0o0 = null;
        O000O0o = null;
        O000O0oO = null;
        O000O0oo = null;
        O000OO00 = null;
        O000OO0o = null;
    }

    public ChangeBounds() {
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.resizeClip});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        this.O00000Oo = z;
    }

    static class O000000o extends AnimatorListenerAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        int f5902O000000o;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        boolean O00000oO;
        boolean O00000oo;
        private View O0000O0o;

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            drn.O000000o(this.O0000O0o, this.f5902O000000o, this.O00000Oo, this.O00000o0, this.O00000o);
            this.O00000oO = false;
            this.O00000oo = false;
        }
    }
}

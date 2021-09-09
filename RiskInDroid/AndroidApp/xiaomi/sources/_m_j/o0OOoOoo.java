package _m_j;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.content.ContextCompat;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class o0OOoOoo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final PorterDuff.Mode f2256O000000o = PorterDuff.Mode.SRC_IN;
    private static o0OOoOoo O00000Oo;
    private static final O00000o0 O00000o0 = new O00000o0();
    private WeakHashMap<Context, o0OO00o0<ColorStateList>> O00000o;
    private o0OO00OO<String, O00000o> O00000oO;
    private o0OO00o0<String> O00000oo;
    private final WeakHashMap<Context, o0O0o000<WeakReference<Drawable.ConstantState>>> O0000O0o = new WeakHashMap<>(0);
    private TypedValue O0000OOo;
    private O0000O0o O0000Oo;
    private boolean O0000Oo0;

    interface O00000o {
        Drawable O000000o(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    interface O0000O0o {
        ColorStateList O000000o(Context context, int i);

        PorterDuff.Mode O000000o(int i);

        Drawable O000000o(o0OOoOoo o0oooooo, Context context, int i);

        boolean O000000o(Context context, int i, Drawable drawable);

        boolean O00000Oo(Context context, int i, Drawable drawable);
    }

    public static synchronized o0OOoOoo O000000o() {
        o0OOoOoo o0oooooo;
        synchronized (o0OOoOoo.class) {
            if (O00000Oo == null) {
                o0OOoOoo o0oooooo2 = new o0OOoOoo();
                O00000Oo = o0oooooo2;
                if (Build.VERSION.SDK_INT < 24) {
                    o0oooooo2.O000000o("vector", new O0000OOo());
                    o0oooooo2.O000000o("animated-vector", new O00000Oo());
                    o0oooooo2.O000000o("animated-selector", new O000000o());
                }
            }
            o0oooooo = O00000Oo;
        }
        return o0oooooo;
    }

    public final synchronized void O000000o(O0000O0o o0000O0o) {
        this.O0000Oo = o0000O0o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.o0OOoOoo.O000000o(android.content.Context, int, boolean):android.graphics.drawable.Drawable
     arg types: [android.content.Context, int, int]
     candidates:
      _m_j.o0OOoOoo.O000000o(android.graphics.drawable.Drawable, _m_j.Oo00, int[]):void
      _m_j.o0OOoOoo.O000000o(android.content.Context, long, android.graphics.drawable.Drawable):boolean
      _m_j.o0OOoOoo.O000000o(android.content.Context, _m_j.o000, int):android.graphics.drawable.Drawable
      _m_j.o0OOoOoo.O000000o(android.content.Context, int, android.graphics.drawable.Drawable):boolean
      _m_j.o0OOoOoo.O000000o(android.content.Context, int, boolean):android.graphics.drawable.Drawable */
    public final synchronized Drawable O000000o(Context context, int i) {
        return O000000o(context, i, false);
    }

    public final synchronized void O000000o(Context context) {
        o0O0o000 o0o0o000 = this.O0000O0o.get(context);
        if (o0o0o000 != null) {
            o0o0o000.O00000o();
        }
    }

    private static long O000000o(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable O000000o(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList O00000Oo2 = O00000Oo(context, i);
        if (O00000Oo2 != null) {
            if (OOOOOo0.O00000o0(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable O00000oo2 = ab.O00000oo(drawable);
            ab.O000000o(O00000oo2, O00000Oo2);
            PorterDuff.Mode O000000o2 = O000000o(i);
            if (O000000o2 == null) {
                return O00000oo2;
            }
            ab.O000000o(O00000oo2, O000000o2);
            return O00000oo2;
        }
        O0000O0o o0000O0o = this.O0000Oo;
        if ((o0000O0o == null || !o0000O0o.O000000o(context, i, drawable)) && !O000000o(context, i, drawable) && z) {
            return null;
        }
        return drawable;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
     arg types: [int, android.util.TypedValue, int]
     candidates:
      ClspMth{android.content.res.Resources.getValue(java.lang.String, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
      ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException} */
    private Drawable O00000o0(Context context, int i) {
        int next;
        o0OO00OO<String, O00000o> o0oo00oo = this.O00000oO;
        if (o0oo00oo == null || o0oo00oo.isEmpty()) {
            return null;
        }
        o0OO00o0<String> o0oo00o0 = this.O00000oo;
        if (o0oo00o0 != null) {
            String O000000o2 = o0oo00o0.O000000o(i, null);
            if ("appcompat_skip_skip".equals(O000000o2) || (O000000o2 != null && this.O00000oO.get(O000000o2) == null)) {
                return null;
            }
        } else {
            this.O00000oo = new o0OO00o0<>();
        }
        if (this.O0000OOo == null) {
            this.O0000OOo = new TypedValue();
        }
        TypedValue typedValue = this.O0000OOo;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long O000000o3 = O000000o(typedValue);
        Drawable O000000o4 = O000000o(context, O000000o3);
        if (O000000o4 != null) {
            return O000000o4;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2) {
                    String name = xml.getName();
                    this.O00000oo.O00000o0(i, name);
                    O00000o o00000o = this.O00000oO.get(name);
                    if (o00000o != null) {
                        O000000o4 = o00000o.O000000o(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (O000000o4 != null) {
                        O000000o4.setChangingConfigurations(typedValue.changingConfigurations);
                        O000000o(context, O000000o3, O000000o4);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (O000000o4 == null) {
            this.O00000oo.O00000o0(i, "appcompat_skip_skip");
        }
        return O000000o4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        return null;
     */
    private synchronized Drawable O000000o(Context context, long j) {
        o0O0o000 o0o0o000 = this.O0000O0o.get(context);
        if (o0o0o000 == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) o0o0o000.O000000o(j, null);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int O000000o2 = o0O0Oo00.O000000o(o0o0o000.O00000o0, o0o0o000.O00000oO, j);
            if (O000000o2 >= 0 && o0o0o000.O00000o[O000000o2] != o0O0o000.f2242O000000o) {
                o0o0o000.O00000o[O000000o2] = o0O0o000.f2242O000000o;
                o0o0o000.O00000Oo = true;
            }
        }
    }

    private synchronized boolean O000000o(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        o0O0o000 o0o0o000 = this.O0000O0o.get(context);
        if (o0o0o000 == null) {
            o0o0o000 = new o0O0o000();
            this.O0000O0o.put(context, o0o0o000);
        }
        o0o0o000.O00000Oo(j, new WeakReference(constantState));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized Drawable O000000o(Context context, o000 o000, int i) {
        Drawable O00000o02 = O00000o0(context, i);
        if (O00000o02 == null) {
            O00000o02 = o000.O000000o(i);
        }
        if (O00000o02 == null) {
            return null;
        }
        return O000000o(context, i, false, O00000o02);
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(Context context, int i, Drawable drawable) {
        O0000O0o o0000O0o = this.O0000Oo;
        return o0000O0o != null && o0000O0o.O00000Oo(context, i, drawable);
    }

    private void O000000o(String str, O00000o o00000o) {
        if (this.O00000oO == null) {
            this.O00000oO = new o0OO00OO<>();
        }
        this.O00000oO.put(str, o00000o);
    }

    private PorterDuff.Mode O000000o(int i) {
        O0000O0o o0000O0o = this.O0000Oo;
        if (o0000O0o == null) {
            return null;
        }
        return o0000O0o.O000000o(i);
    }

    static class O00000o0 extends o0oOo0O0<Integer, PorterDuffColorFilter> {
        public O00000o0() {
            super(6);
        }

        static int O000000o(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    static void O000000o(Drawable drawable, Oo00 oo00, int[] iArr) {
        if (!OOOOOo0.O00000o0(drawable) || drawable.mutate() == drawable) {
            if (oo00.O00000o || oo00.O00000o0) {
                PorterDuffColorFilter porterDuffColorFilter = null;
                ColorStateList colorStateList = oo00.O00000o ? oo00.f12342O000000o : null;
                PorterDuff.Mode mode = oo00.O00000o0 ? oo00.O00000Oo : f2256O000000o;
                if (!(colorStateList == null || mode == null)) {
                    porterDuffColorFilter = O000000o(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(porterDuffColorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    public static synchronized PorterDuffColorFilter O000000o(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (o0OOoOoo.class) {
            porterDuffColorFilter = (PorterDuffColorFilter) O00000o0.get(Integer.valueOf(O00000o0.O000000o(i, mode)));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
                O00000o0.put(Integer.valueOf(O00000o0.O000000o(i, mode)), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    static class O0000OOo implements O00000o {
        O0000OOo() {
        }

        public final Drawable O000000o(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return jw.O000000o(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    static class O00000Oo implements O00000o {
        O00000Oo() {
        }

        public final Drawable O000000o(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return jq.O000000o(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    static class O000000o implements O00000o {
        O000000o() {
        }

        public final Drawable O000000o(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return OO000OO.O000000o(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
     arg types: [int, android.util.TypedValue, int]
     candidates:
      ClspMth{android.content.res.Resources.getValue(java.lang.String, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
      ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    public final synchronized Drawable O000000o(Context context, int i, boolean z) {
        Drawable O00000o02;
        boolean z2;
        if (!this.O0000Oo0) {
            this.O0000Oo0 = true;
            Drawable O000000o2 = O000000o(context, (int) R.drawable.abc_vector_test);
            if (O000000o2 != null) {
                if (!(O000000o2 instanceof jw)) {
                    if (!"android.graphics.drawable.VectorDrawable".equals(O000000o2.getClass().getName())) {
                        z2 = false;
                        if (z2) {
                        }
                    }
                }
                z2 = true;
                if (z2) {
                }
            }
            this.O0000Oo0 = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
        O00000o02 = O00000o0(context, i);
        if (O00000o02 == null) {
            if (this.O0000OOo == null) {
                this.O0000OOo = new TypedValue();
            }
            TypedValue typedValue = this.O0000OOo;
            context.getResources().getValue(i, typedValue, true);
            long O000000o3 = O000000o(typedValue);
            Drawable O000000o4 = O000000o(context, O000000o3);
            if (O000000o4 == null) {
                if (this.O0000Oo == null) {
                    O000000o4 = null;
                } else {
                    O000000o4 = this.O0000Oo.O000000o(this, context, i);
                }
                if (O000000o4 != null) {
                    O000000o4.setChangingConfigurations(typedValue.changingConfigurations);
                    O000000o(context, O000000o3, O000000o4);
                }
            }
            O00000o02 = O000000o4;
        }
        if (O00000o02 == null) {
            O00000o02 = ContextCompat.O000000o(context, i);
        }
        if (O00000o02 != null) {
            O00000o02 = O000000o(context, i, z, O00000o02);
        }
        if (O00000o02 != null) {
            OOOOOo0.O00000Oo(O00000o02);
        }
        return O00000o02;
    }

    /* access modifiers changed from: package-private */
    public final synchronized ColorStateList O00000Oo(Context context, int i) {
        ColorStateList colorStateList;
        o0OO00o0 o0oo00o0;
        ColorStateList colorStateList2 = null;
        if (this.O00000o == null || (o0oo00o0 = this.O00000o.get(context)) == null) {
            colorStateList = null;
        } else {
            colorStateList = (ColorStateList) o0oo00o0.O000000o(i, null);
        }
        if (colorStateList == null) {
            if (this.O0000Oo != null) {
                colorStateList2 = this.O0000Oo.O000000o(context, i);
            }
            colorStateList = colorStateList2;
            if (colorStateList != null) {
                if (this.O00000o == null) {
                    this.O00000o = new WeakHashMap<>();
                }
                o0OO00o0 o0oo00o02 = this.O00000o.get(context);
                if (o0oo00o02 == null) {
                    o0oo00o02 = new o0OO00o0();
                    this.O00000o.put(context, o0oo00o02);
                }
                o0oo00o02.O00000o0(i, colorStateList);
            }
        }
        return colorStateList;
    }
}

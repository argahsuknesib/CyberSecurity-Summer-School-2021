package _m_j;

import _m_j.s;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class jw extends jv {

    /* renamed from: O000000o  reason: collision with root package name */
    static final PorterDuff.Mode f2120O000000o = PorterDuff.Mode.SRC_IN;
    O0000Oo0 O00000Oo;
    boolean O00000o;
    private PorterDuffColorFilter O00000oO;
    private ColorFilter O00000oo;
    private boolean O0000O0o;
    private Drawable.ConstantState O0000OOo;
    private final Matrix O0000Oo;
    private final float[] O0000Oo0;
    private final Rect O0000OoO;

    public final /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    jw() {
        this.O00000o = true;
        this.O0000Oo0 = new float[9];
        this.O0000Oo = new Matrix();
        this.O0000OoO = new Rect();
        this.O00000Oo = new O0000Oo0();
    }

    jw(O0000Oo0 o0000Oo0) {
        this.O00000o = true;
        this.O0000Oo0 = new float[9];
        this.O0000Oo = new Matrix();
        this.O0000OoO = new Rect();
        this.O00000Oo = o0000Oo0;
        this.O00000oO = O000000o(o0000Oo0.O00000o0, o0000Oo0.O00000o);
    }

    public final Drawable mutate() {
        if (this.O00000o0 != null) {
            this.O00000o0.mutate();
            return this;
        }
        if (!this.O0000O0o && super.mutate() == this) {
            this.O00000Oo = new O0000Oo0(this.O00000Oo);
            this.O0000O0o = true;
        }
        return this;
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.O00000o0 != null && Build.VERSION.SDK_INT >= 24) {
            return new O0000Oo(this.O00000o0.getConstantState());
        }
        this.O00000Oo.f2125O000000o = getChangingConfigurations();
        return this.O00000Oo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00df, code lost:
        if ((r1 == r6.O00000oo.getWidth() && r3 == r6.O00000oo.getHeight()) == false) goto L_0x00e1;
     */
    public final void draw(Canvas canvas) {
        Paint paint;
        if (this.O00000o0 != null) {
            this.O00000o0.draw(canvas);
            return;
        }
        copyBounds(this.O0000OoO);
        if (this.O0000OoO.width() > 0 && this.O0000OoO.height() > 0) {
            ColorFilter colorFilter = this.O00000oo;
            if (colorFilter == null) {
                colorFilter = this.O00000oO;
            }
            canvas.getMatrix(this.O0000Oo);
            this.O0000Oo.getValues(this.O0000Oo0);
            boolean z = false;
            float abs = Math.abs(this.O0000Oo0[0]);
            float abs2 = Math.abs(this.O0000Oo0[4]);
            float abs3 = Math.abs(this.O0000Oo0[1]);
            float abs4 = Math.abs(this.O0000Oo0[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.O0000OoO.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.O0000OoO.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate((float) this.O0000OoO.left, (float) this.O0000OoO.top);
                if (Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && ab.O0000OOo(this) == 1) {
                    canvas.translate((float) this.O0000OoO.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.O0000OoO.offsetTo(0, 0);
                O0000Oo0 o0000Oo0 = this.O00000Oo;
                if (o0000Oo0.O00000oo != null) {
                }
                o0000Oo0.O00000oo = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
                o0000Oo0.O0000OoO = true;
                if (!this.O00000o) {
                    this.O00000Oo.O000000o(min, min2);
                } else {
                    O0000Oo0 o0000Oo02 = this.O00000Oo;
                    if (!(!o0000Oo02.O0000OoO && o0000Oo02.O0000O0o == o0000Oo02.O00000o0 && o0000Oo02.O0000OOo == o0000Oo02.O00000o && o0000Oo02.O0000Oo == o0000Oo02.O00000oO && o0000Oo02.O0000Oo0 == o0000Oo02.O00000Oo.getRootAlpha())) {
                        this.O00000Oo.O000000o(min, min2);
                        O0000Oo0 o0000Oo03 = this.O00000Oo;
                        o0000Oo03.O0000O0o = o0000Oo03.O00000o0;
                        o0000Oo03.O0000OOo = o0000Oo03.O00000o;
                        o0000Oo03.O0000Oo0 = o0000Oo03.O00000Oo.getRootAlpha();
                        o0000Oo03.O0000Oo = o0000Oo03.O00000oO;
                        o0000Oo03.O0000OoO = false;
                    }
                }
                O0000Oo0 o0000Oo04 = this.O00000Oo;
                Rect rect = this.O0000OoO;
                if (o0000Oo04.O00000Oo.getRootAlpha() < 255) {
                    z = true;
                }
                if (z || colorFilter != null) {
                    if (o0000Oo04.O0000Ooo == null) {
                        o0000Oo04.O0000Ooo = new Paint();
                        o0000Oo04.O0000Ooo.setFilterBitmap(true);
                    }
                    o0000Oo04.O0000Ooo.setAlpha(o0000Oo04.O00000Oo.getRootAlpha());
                    o0000Oo04.O0000Ooo.setColorFilter(colorFilter);
                    paint = o0000Oo04.O0000Ooo;
                } else {
                    paint = null;
                }
                canvas.drawBitmap(o0000Oo04.O00000oo, (Rect) null, rect, paint);
                canvas.restoreToCount(save);
            }
        }
    }

    public final int getAlpha() {
        if (this.O00000o0 != null) {
            return ab.O00000Oo(this.O00000o0);
        }
        return this.O00000Oo.O00000Oo.getRootAlpha();
    }

    public final void setAlpha(int i) {
        if (this.O00000o0 != null) {
            this.O00000o0.setAlpha(i);
        } else if (this.O00000Oo.O00000Oo.getRootAlpha() != i) {
            this.O00000Oo.O00000Oo.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.O00000o0 != null) {
            this.O00000o0.setColorFilter(colorFilter);
            return;
        }
        this.O00000oo = colorFilter;
        invalidateSelf();
    }

    public final ColorFilter getColorFilter() {
        if (this.O00000o0 != null) {
            return ab.O00000o(this.O00000o0);
        }
        return this.O00000oo;
    }

    private PorterDuffColorFilter O000000o(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void setTint(int i) {
        if (this.O00000o0 != null) {
            ab.O000000o(this.O00000o0, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.O00000o0 != null) {
            ab.O000000o(this.O00000o0, colorStateList);
            return;
        }
        O0000Oo0 o0000Oo0 = this.O00000Oo;
        if (o0000Oo0.O00000o0 != colorStateList) {
            o0000Oo0.O00000o0 = colorStateList;
            this.O00000oO = O000000o(colorStateList, o0000Oo0.O00000o);
            invalidateSelf();
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.O00000o0 != null) {
            ab.O000000o(this.O00000o0, mode);
            return;
        }
        O0000Oo0 o0000Oo0 = this.O00000Oo;
        if (o0000Oo0.O00000o != mode) {
            o0000Oo0.O00000o = mode;
            this.O00000oO = O000000o(o0000Oo0.O00000o0, mode);
            invalidateSelf();
        }
    }

    public final boolean isStateful() {
        if (this.O00000o0 != null) {
            return this.O00000o0.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        O0000Oo0 o0000Oo0 = this.O00000Oo;
        if (o0000Oo0 == null) {
            return false;
        }
        if (!o0000Oo0.O00000Oo.O000000o()) {
            return this.O00000Oo.O00000o0 != null && this.O00000Oo.O00000o0.isStateful();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        if (this.O00000o0 != null) {
            return this.O00000o0.setState(iArr);
        }
        boolean z = false;
        O0000Oo0 o0000Oo0 = this.O00000Oo;
        if (!(o0000Oo0.O00000o0 == null || o0000Oo0.O00000o == null)) {
            this.O00000oO = O000000o(o0000Oo0.O00000o0, o0000Oo0.O00000o);
            invalidateSelf();
            z = true;
        }
        if (!o0000Oo0.O00000Oo.O000000o()) {
            return z;
        }
        boolean O000000o2 = o0000Oo0.O00000Oo.O00000o0.O000000o(iArr);
        o0000Oo0.O0000OoO |= O000000o2;
        if (!O000000o2) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public final int getOpacity() {
        if (this.O00000o0 != null) {
            return this.O00000o0.getOpacity();
        }
        return -3;
    }

    public final int getIntrinsicWidth() {
        if (this.O00000o0 != null) {
            return this.O00000o0.getIntrinsicWidth();
        }
        return (int) this.O00000Oo.O00000Oo.O00000o;
    }

    public final int getIntrinsicHeight() {
        if (this.O00000o0 != null) {
            return this.O00000o0.getIntrinsicHeight();
        }
        return (int) this.O00000Oo.O00000Oo.O00000oO;
    }

    public final boolean canApplyTheme() {
        if (this.O00000o0 == null) {
            return false;
        }
        ab.O00000o0(this.O00000o0);
        return false;
    }

    public final boolean isAutoMirrored() {
        if (this.O00000o0 != null) {
            return ab.O000000o(this.O00000o0);
        }
        return this.O00000Oo.O00000oO;
    }

    public final void setAutoMirrored(boolean z) {
        if (this.O00000o0 != null) {
            ab.O000000o(this.O00000o0, z);
        } else {
            this.O00000Oo.O00000oO = z;
        }
    }

    public static jw O000000o(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            jw jwVar = new jw();
            jwVar.O00000o0 = m.O000000o(resources, i, theme);
            jwVar.O0000OOo = new O0000Oo(jwVar.O00000o0.getConstantState());
            return jwVar;
        }
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
                return O000000o(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (XmlPullParserException e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static jw O000000o(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        jw jwVar = new jw();
        jwVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return jwVar;
    }

    static int O000000o(int i, float f) {
        return (i & 16777215) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.O00000o0 != null) {
            this.O00000o0.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        ColorStateList colorStateList;
        Resources resources2 = resources;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AttributeSet attributeSet2 = attributeSet;
        Resources.Theme theme2 = theme;
        if (this.O00000o0 != null) {
            ab.O000000o(this.O00000o0, resources2, xmlPullParser2, attributeSet2, theme2);
            return;
        }
        O0000Oo0 o0000Oo0 = this.O00000Oo;
        o0000Oo0.O00000Oo = new O0000OOo();
        TypedArray O000000o2 = n.O000000o(resources2, theme2, attributeSet2, jo.f1991O000000o);
        O0000Oo0 o0000Oo02 = this.O00000Oo;
        O0000OOo o0000OOo = o0000Oo02.O00000Oo;
        int O000000o3 = n.O000000o(O000000o2, xmlPullParser2, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (O000000o3 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (O000000o3 == 5) {
            mode = PorterDuff.Mode.SRC_IN;
        } else if (O000000o3 != 9) {
            switch (O000000o3) {
                case 14:
                    mode = PorterDuff.Mode.MULTIPLY;
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                    mode = PorterDuff.Mode.SCREEN;
                    break;
                case 16:
                    mode = PorterDuff.Mode.ADD;
                    break;
            }
        } else {
            mode = PorterDuff.Mode.SRC_ATOP;
        }
        o0000Oo02.O00000o = mode;
        if (n.O000000o(xmlPullParser2, "tint")) {
            TypedValue typedValue = new TypedValue();
            O000000o2.getValue(1, typedValue);
            if (typedValue.type != 2) {
                colorStateList = (typedValue.type < 28 || typedValue.type > 31) ? h.O000000o(O000000o2.getResources(), O000000o2.getResourceId(1, 0), theme2) : ColorStateList.valueOf(typedValue.data);
            } else {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1" + ": " + typedValue);
            }
        } else {
            colorStateList = null;
        }
        if (colorStateList != null) {
            o0000Oo02.O00000o0 = colorStateList;
        }
        o0000Oo02.O00000oO = n.O000000o(O000000o2, xmlPullParser2, "autoMirrored", 5, o0000Oo02.O00000oO);
        o0000OOo.O00000oo = n.O000000o(O000000o2, xmlPullParser2, "viewportWidth", 7, o0000OOo.O00000oo);
        o0000OOo.O0000O0o = n.O000000o(O000000o2, xmlPullParser2, "viewportHeight", 8, o0000OOo.O0000O0o);
        if (o0000OOo.O00000oo <= 0.0f) {
            throw new XmlPullParserException(O000000o2.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (o0000OOo.O0000O0o > 0.0f) {
            o0000OOo.O00000o = O000000o2.getDimension(3, o0000OOo.O00000o);
            o0000OOo.O00000oO = O000000o2.getDimension(2, o0000OOo.O00000oO);
            if (o0000OOo.O00000o <= 0.0f) {
                throw new XmlPullParserException(O000000o2.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (o0000OOo.O00000oO > 0.0f) {
                o0000OOo.setAlpha(n.O000000o(O000000o2, xmlPullParser2, "alpha", 4, o0000OOo.getAlpha()));
                String string = O000000o2.getString(0);
                if (string != null) {
                    o0000OOo.O0000Oo0 = string;
                    o0000OOo.O0000OoO.put(string, o0000OOo);
                }
                O000000o2.recycle();
                o0000Oo0.f2125O000000o = getChangingConfigurations();
                o0000Oo0.O0000OoO = true;
                O00000Oo(resources, xmlPullParser, attributeSet, theme);
                this.O00000oO = O000000o(o0000Oo0.O00000o0, o0000Oo0.O00000o);
            } else {
                throw new XmlPullParserException(O000000o2.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(O000000o2.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    private void O00000Oo(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Resources resources2 = resources;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AttributeSet attributeSet2 = attributeSet;
        Resources.Theme theme2 = theme;
        O0000Oo0 o0000Oo0 = this.O00000Oo;
        O0000OOo o0000OOo = o0000Oo0.O00000Oo;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(o0000OOo.O00000o0);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        for (int i = 1; eventType != i && (xmlPullParser.getDepth() >= depth || eventType != 3); i = 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                O00000o0 o00000o0 = (O00000o0) arrayDeque.peek();
                if ("path".equals(name)) {
                    O00000Oo o00000Oo = new O00000Oo();
                    TypedArray O000000o2 = n.O000000o(resources2, theme2, attributeSet2, jo.O00000o0);
                    o00000Oo.O000000o(O000000o2, xmlPullParser2, theme2);
                    O000000o2.recycle();
                    o00000o0.O00000Oo.add(o00000Oo);
                    if (o00000Oo.getPathName() != null) {
                        o0000OOo.O0000OoO.put(o00000Oo.getPathName(), o00000Oo);
                    }
                    o0000Oo0.f2125O000000o = o00000Oo.O0000o0O | o0000Oo0.f2125O000000o;
                    z = false;
                } else if ("clip-path".equals(name)) {
                    O000000o o000000o = new O000000o();
                    if (n.O000000o(xmlPullParser2, "pathData")) {
                        TypedArray O000000o3 = n.O000000o(resources2, theme2, attributeSet2, jo.O00000o);
                        o000000o.O000000o(O000000o3, xmlPullParser2);
                        O000000o3.recycle();
                    }
                    o00000o0.O00000Oo.add(o000000o);
                    if (o000000o.getPathName() != null) {
                        o0000OOo.O0000OoO.put(o000000o.getPathName(), o000000o);
                    }
                    o0000Oo0.f2125O000000o = o000000o.O0000o0O | o0000Oo0.f2125O000000o;
                } else if ("group".equals(name)) {
                    O00000o0 o00000o02 = new O00000o0();
                    TypedArray O000000o4 = n.O000000o(resources2, theme2, attributeSet2, jo.O00000Oo);
                    o00000o02.O0000Ooo = null;
                    o00000o02.O00000o0 = n.O000000o(O000000o4, xmlPullParser2, "rotation", 5, o00000o02.O00000o0);
                    o00000o02.O00000o = O000000o4.getFloat(1, o00000o02.O00000o);
                    o00000o02.O00000oO = O000000o4.getFloat(2, o00000o02.O00000oO);
                    o00000o02.O00000oo = n.O000000o(O000000o4, xmlPullParser2, "scaleX", 3, o00000o02.O00000oo);
                    o00000o02.O0000O0o = n.O000000o(O000000o4, xmlPullParser2, "scaleY", 4, o00000o02.O0000O0o);
                    o00000o02.O0000OOo = n.O000000o(O000000o4, xmlPullParser2, "translateX", 6, o00000o02.O0000OOo);
                    o00000o02.O0000Oo0 = n.O000000o(O000000o4, xmlPullParser2, "translateY", 7, o00000o02.O0000Oo0);
                    String string = O000000o4.getString(0);
                    if (string != null) {
                        o00000o02.O0000o00 = string;
                    }
                    o00000o02.O000000o();
                    O000000o4.recycle();
                    o00000o0.O00000Oo.add(o00000o02);
                    arrayDeque.push(o00000o02);
                    if (o00000o02.getGroupName() != null) {
                        o0000OOo.O0000OoO.put(o00000o02.getGroupName(), o00000o02);
                    }
                    o0000Oo0.f2125O000000o = o00000o02.O0000OoO | o0000Oo0.f2125O000000o;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        if (this.O00000o0 != null) {
            this.O00000o0.setBounds(rect);
        }
    }

    public final int getChangingConfigurations() {
        if (this.O00000o0 != null) {
            return this.O00000o0.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.O00000Oo.getChangingConfigurations();
    }

    public final void invalidateSelf() {
        if (this.O00000o0 != null) {
            this.O00000o0.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final void scheduleSelf(Runnable runnable, long j) {
        if (this.O00000o0 != null) {
            this.O00000o0.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.O00000o0 != null) {
            return this.O00000o0.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        if (this.O00000o0 != null) {
            this.O00000o0.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    static class O0000Oo extends Drawable.ConstantState {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Drawable.ConstantState f2124O000000o;

        public O0000Oo(Drawable.ConstantState constantState) {
            this.f2124O000000o = constantState;
        }

        public final Drawable newDrawable() {
            jw jwVar = new jw();
            jwVar.O00000o0 = (VectorDrawable) this.f2124O000000o.newDrawable();
            return jwVar;
        }

        public final Drawable newDrawable(Resources resources) {
            jw jwVar = new jw();
            jwVar.O00000o0 = (VectorDrawable) this.f2124O000000o.newDrawable(resources);
            return jwVar;
        }

        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            jw jwVar = new jw();
            jwVar.O00000o0 = (VectorDrawable) this.f2124O000000o.newDrawable(resources, theme);
            return jwVar;
        }

        public final boolean canApplyTheme() {
            return this.f2124O000000o.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.f2124O000000o.getChangingConfigurations();
        }
    }

    static class O0000Oo0 extends Drawable.ConstantState {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2125O000000o;
        O0000OOo O00000Oo;
        PorterDuff.Mode O00000o;
        ColorStateList O00000o0;
        boolean O00000oO;
        Bitmap O00000oo;
        ColorStateList O0000O0o;
        PorterDuff.Mode O0000OOo;
        boolean O0000Oo;
        int O0000Oo0;
        boolean O0000OoO;
        Paint O0000Ooo;

        public O0000Oo0(O0000Oo0 o0000Oo0) {
            this.O00000o0 = null;
            this.O00000o = jw.f2120O000000o;
            if (o0000Oo0 != null) {
                this.f2125O000000o = o0000Oo0.f2125O000000o;
                this.O00000Oo = new O0000OOo(o0000Oo0.O00000Oo);
                if (o0000Oo0.O00000Oo.O00000Oo != null) {
                    this.O00000Oo.O00000Oo = new Paint(o0000Oo0.O00000Oo.O00000Oo);
                }
                if (o0000Oo0.O00000Oo.f2123O000000o != null) {
                    this.O00000Oo.f2123O000000o = new Paint(o0000Oo0.O00000Oo.f2123O000000o);
                }
                this.O00000o0 = o0000Oo0.O00000o0;
                this.O00000o = o0000Oo0.O00000o;
                this.O00000oO = o0000Oo0.O00000oO;
            }
        }

        public final void O000000o(int i, int i2) {
            this.O00000oo.eraseColor(0);
            this.O00000Oo.O000000o(new Canvas(this.O00000oo), i, i2);
        }

        public O0000Oo0() {
            this.O00000o0 = null;
            this.O00000o = jw.f2120O000000o;
            this.O00000Oo = new O0000OOo();
        }

        public final Drawable newDrawable() {
            return new jw(this);
        }

        public final Drawable newDrawable(Resources resources) {
            return new jw(this);
        }

        public final int getChangingConfigurations() {
            return this.f2125O000000o;
        }
    }

    static class O0000OOo {
        private static final Matrix O0000o0 = new Matrix();

        /* renamed from: O000000o  reason: collision with root package name */
        Paint f2123O000000o;
        Paint O00000Oo;
        float O00000o;
        final O00000o0 O00000o0;
        float O00000oO;
        float O00000oo;
        float O0000O0o;
        int O0000OOo;
        Boolean O0000Oo;
        String O0000Oo0;
        final o0O0OOO0<String, Object> O0000OoO;
        private final Path O0000Ooo;
        private int O0000o;
        private final Path O0000o00;
        private final Matrix O0000o0O;
        private PathMeasure O0000o0o;

        public O0000OOo() {
            this.O0000o0O = new Matrix();
            this.O00000o = 0.0f;
            this.O00000oO = 0.0f;
            this.O00000oo = 0.0f;
            this.O0000O0o = 0.0f;
            this.O0000OOo = 255;
            this.O0000Oo0 = null;
            this.O0000Oo = null;
            this.O0000OoO = new o0O0OOO0<>();
            this.O00000o0 = new O00000o0();
            this.O0000Ooo = new Path();
            this.O0000o00 = new Path();
        }

        public final void setRootAlpha(int i) {
            this.O0000OOo = i;
        }

        public final int getRootAlpha() {
            return this.O0000OOo;
        }

        public final void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public final float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public O0000OOo(O0000OOo o0000OOo) {
            this.O0000o0O = new Matrix();
            this.O00000o = 0.0f;
            this.O00000oO = 0.0f;
            this.O00000oo = 0.0f;
            this.O0000O0o = 0.0f;
            this.O0000OOo = 255;
            this.O0000Oo0 = null;
            this.O0000Oo = null;
            this.O0000OoO = new o0O0OOO0<>();
            this.O00000o0 = new O00000o0(o0000OOo.O00000o0, this.O0000OoO);
            this.O0000Ooo = new Path(o0000OOo.O0000Ooo);
            this.O0000o00 = new Path(o0000OOo.O0000o00);
            this.O00000o = o0000OOo.O00000o;
            this.O00000oO = o0000OOo.O00000oO;
            this.O00000oo = o0000OOo.O00000oo;
            this.O0000O0o = o0000OOo.O0000O0o;
            this.O0000o = o0000OOo.O0000o;
            this.O0000OOo = o0000OOo.O0000OOo;
            this.O0000Oo0 = o0000OOo.O0000Oo0;
            String str = o0000OOo.O0000Oo0;
            if (str != null) {
                this.O0000OoO.put(str, this);
            }
            this.O0000Oo = o0000OOo.O0000Oo;
        }

        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r11v2 */
        private void O000000o(O00000o0 o00000o0, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            O0000OOo o0000OOo;
            O0000OOo o0000OOo2 = this;
            O00000o0 o00000o02 = o00000o0;
            Canvas canvas2 = canvas;
            ColorFilter colorFilter2 = colorFilter;
            o00000o02.f2122O000000o.set(matrix);
            o00000o02.f2122O000000o.preConcat(o00000o02.O0000Oo);
            canvas.save();
            ? r11 = 0;
            int i3 = 0;
            while (i3 < o00000o02.O00000Oo.size()) {
                O00000o o00000o = o00000o02.O00000Oo.get(i3);
                if (o00000o instanceof O00000o0) {
                    O000000o((O00000o0) o00000o, o00000o02.f2122O000000o, canvas, i, i2, colorFilter);
                } else if (o00000o instanceof O0000O0o) {
                    O0000O0o o0000O0o = (O0000O0o) o00000o;
                    float f = ((float) i) / o0000OOo2.O00000oo;
                    float f2 = ((float) i2) / o0000OOo2.O0000O0o;
                    float min = Math.min(f, f2);
                    Matrix matrix2 = o00000o02.f2122O000000o;
                    o0000OOo2.O0000o0O.set(matrix2);
                    o0000OOo2.O0000o0O.postScale(f, f2);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    float f3 = min;
                    float f4 = (fArr[r11] * fArr[3]) - (fArr[1] * fArr[2]);
                    float max = Math.max((float) Math.hypot((double) fArr[r11], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
                    float abs = max > 0.0f ? Math.abs(f4) / max : 0.0f;
                    if (abs != 0.0f) {
                        o0000OOo = this;
                        o0000O0o.O000000o(o0000OOo.O0000Ooo);
                        Path path = o0000OOo.O0000Ooo;
                        o0000OOo.O0000o00.reset();
                        if (o0000O0o.O000000o()) {
                            o0000OOo.O0000o00.setFillType(o0000O0o.O0000o0 == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            o0000OOo.O0000o00.addPath(path, o0000OOo.O0000o0O);
                            canvas2.clipPath(o0000OOo.O0000o00);
                        } else {
                            O00000Oo o00000Oo = (O00000Oo) o0000O0o;
                            if (!(o00000Oo.O00000oo == 0.0f && o00000Oo.O0000O0o == 1.0f)) {
                                float f5 = (o00000Oo.O00000oo + o00000Oo.O0000OOo) % 1.0f;
                                float f6 = (o00000Oo.O0000O0o + o00000Oo.O0000OOo) % 1.0f;
                                if (o0000OOo.O0000o0o == null) {
                                    o0000OOo.O0000o0o = new PathMeasure();
                                }
                                o0000OOo.O0000o0o.setPath(o0000OOo.O0000Ooo, r11);
                                float length = o0000OOo.O0000o0o.getLength();
                                float f7 = f5 * length;
                                float f8 = f6 * length;
                                path.reset();
                                if (f7 > f8) {
                                    o0000OOo.O0000o0o.getSegment(f7, length, path, true);
                                    o0000OOo.O0000o0o.getSegment(0.0f, f8, path, true);
                                } else {
                                    o0000OOo.O0000o0o.getSegment(f7, f8, path, true);
                                }
                                path.rLineTo(0.0f, 0.0f);
                            }
                            o0000OOo.O0000o00.addPath(path, o0000OOo.O0000o0O);
                            if (o00000Oo.O00000o0.O00000o0()) {
                                i iVar = o00000Oo.O00000o0;
                                if (o0000OOo.O00000Oo == null) {
                                    o0000OOo.O00000Oo = new Paint(1);
                                    o0000OOo.O00000Oo.setStyle(Paint.Style.FILL);
                                }
                                Paint paint = o0000OOo.O00000Oo;
                                if (iVar.O000000o()) {
                                    Shader shader = iVar.f1061O000000o;
                                    shader.setLocalMatrix(o0000OOo.O0000o0O);
                                    paint.setShader(shader);
                                    paint.setAlpha(Math.round(o00000Oo.O00000oO * 255.0f));
                                } else {
                                    paint.setShader(null);
                                    paint.setAlpha(255);
                                    paint.setColor(jw.O000000o(iVar.O00000Oo, o00000Oo.O00000oO));
                                }
                                paint.setColorFilter(colorFilter2);
                                o0000OOo.O0000o00.setFillType(o00000Oo.O0000o0 == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas2.drawPath(o0000OOo.O0000o00, paint);
                            }
                            if (o00000Oo.f2121O000000o.O00000o0()) {
                                i iVar2 = o00000Oo.f2121O000000o;
                                if (o0000OOo.f2123O000000o == null) {
                                    o0000OOo.f2123O000000o = new Paint(1);
                                    o0000OOo.f2123O000000o.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint2 = o0000OOo.f2123O000000o;
                                if (o00000Oo.O0000Oo != null) {
                                    paint2.setStrokeJoin(o00000Oo.O0000Oo);
                                }
                                if (o00000Oo.O0000Oo0 != null) {
                                    paint2.setStrokeCap(o00000Oo.O0000Oo0);
                                }
                                paint2.setStrokeMiter(o00000Oo.O0000OoO);
                                if (iVar2.O000000o()) {
                                    Shader shader2 = iVar2.f1061O000000o;
                                    shader2.setLocalMatrix(o0000OOo.O0000o0O);
                                    paint2.setShader(shader2);
                                    paint2.setAlpha(Math.round(o00000Oo.O00000o * 255.0f));
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    paint2.setColor(jw.O000000o(iVar2.O00000Oo, o00000Oo.O00000o));
                                }
                                paint2.setColorFilter(colorFilter2);
                                paint2.setStrokeWidth(o00000Oo.O00000Oo * abs * f3);
                                canvas2.drawPath(o0000OOo.O0000o00, paint2);
                            }
                        }
                    } else {
                        o0000OOo = this;
                    }
                    i3++;
                    o0000OOo2 = o0000OOo;
                    r11 = 0;
                }
                o0000OOo = o0000OOo2;
                i3++;
                o0000OOo2 = o0000OOo;
                r11 = 0;
            }
            canvas.restore();
        }

        public final void O000000o(Canvas canvas, int i, int i2) {
            O000000o(this.O00000o0, O0000o0, canvas, i, i2, null);
        }

        public final boolean O000000o() {
            if (this.O0000Oo == null) {
                this.O0000Oo = Boolean.valueOf(this.O00000o0.O00000Oo());
            }
            return this.O0000Oo.booleanValue();
        }
    }

    static abstract class O00000o {
        public boolean O000000o(int[] iArr) {
            return false;
        }

        public boolean O00000Oo() {
            return false;
        }

        private O00000o() {
        }

        /* synthetic */ O00000o(byte b) {
            this();
        }
    }

    static class O00000o0 extends O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final Matrix f2122O000000o = new Matrix();
        final ArrayList<O00000o> O00000Oo = new ArrayList<>();
        float O00000o = 0.0f;
        float O00000o0 = 0.0f;
        float O00000oO = 0.0f;
        float O00000oo = 1.0f;
        float O0000O0o = 1.0f;
        float O0000OOo = 0.0f;
        final Matrix O0000Oo = new Matrix();
        float O0000Oo0 = 0.0f;
        int O0000OoO;
        int[] O0000Ooo;
        String O0000o00 = null;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000o0(O00000o0 o00000o0, o0O0OOO0<String, Object> o0o0ooo0) {
            super((byte) 0);
            O0000O0o o0000O0o;
            this.O00000o0 = o00000o0.O00000o0;
            this.O00000o = o00000o0.O00000o;
            this.O00000oO = o00000o0.O00000oO;
            this.O00000oo = o00000o0.O00000oo;
            this.O0000O0o = o00000o0.O0000O0o;
            this.O0000OOo = o00000o0.O0000OOo;
            this.O0000Oo0 = o00000o0.O0000Oo0;
            this.O0000Ooo = o00000o0.O0000Ooo;
            this.O0000o00 = o00000o0.O0000o00;
            this.O0000OoO = o00000o0.O0000OoO;
            String str = this.O0000o00;
            if (str != null) {
                o0o0ooo0.put(str, this);
            }
            this.O0000Oo.set(o00000o0.O0000Oo);
            ArrayList<O00000o> arrayList = o00000o0.O00000Oo;
            for (int i = 0; i < arrayList.size(); i++) {
                O00000o o00000o = arrayList.get(i);
                if (o00000o instanceof O00000o0) {
                    this.O00000Oo.add(new O00000o0((O00000o0) o00000o, o0o0ooo0));
                } else {
                    if (o00000o instanceof O00000Oo) {
                        o0000O0o = new O00000Oo((O00000Oo) o00000o);
                    } else if (o00000o instanceof O000000o) {
                        o0000O0o = new O000000o((O000000o) o00000o);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.O00000Oo.add(o0000O0o);
                    if (o0000O0o.O0000o00 != null) {
                        o0o0ooo0.put(o0000O0o.O0000o00, o0000O0o);
                    }
                }
            }
        }

        public O00000o0() {
            super((byte) 0);
        }

        public final String getGroupName() {
            return this.O0000o00;
        }

        public final Matrix getLocalMatrix() {
            return this.O0000Oo;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            this.O0000Oo.reset();
            this.O0000Oo.postTranslate(-this.O00000o, -this.O00000oO);
            this.O0000Oo.postScale(this.O00000oo, this.O0000O0o);
            this.O0000Oo.postRotate(this.O00000o0, 0.0f, 0.0f);
            this.O0000Oo.postTranslate(this.O0000OOo + this.O00000o, this.O0000Oo0 + this.O00000oO);
        }

        public final float getRotation() {
            return this.O00000o0;
        }

        public final void setRotation(float f) {
            if (f != this.O00000o0) {
                this.O00000o0 = f;
                O000000o();
            }
        }

        public final float getPivotX() {
            return this.O00000o;
        }

        public final void setPivotX(float f) {
            if (f != this.O00000o) {
                this.O00000o = f;
                O000000o();
            }
        }

        public final float getPivotY() {
            return this.O00000oO;
        }

        public final void setPivotY(float f) {
            if (f != this.O00000oO) {
                this.O00000oO = f;
                O000000o();
            }
        }

        public final float getScaleX() {
            return this.O00000oo;
        }

        public final void setScaleX(float f) {
            if (f != this.O00000oo) {
                this.O00000oo = f;
                O000000o();
            }
        }

        public final float getScaleY() {
            return this.O0000O0o;
        }

        public final void setScaleY(float f) {
            if (f != this.O0000O0o) {
                this.O0000O0o = f;
                O000000o();
            }
        }

        public final float getTranslateX() {
            return this.O0000OOo;
        }

        public final void setTranslateX(float f) {
            if (f != this.O0000OOo) {
                this.O0000OOo = f;
                O000000o();
            }
        }

        public final float getTranslateY() {
            return this.O0000Oo0;
        }

        public final void setTranslateY(float f) {
            if (f != this.O0000Oo0) {
                this.O0000Oo0 = f;
                O000000o();
            }
        }

        public final boolean O00000Oo() {
            for (int i = 0; i < this.O00000Oo.size(); i++) {
                if (this.O00000Oo.get(i).O00000Oo()) {
                    return true;
                }
            }
            return false;
        }

        public final boolean O000000o(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.O00000Oo.size(); i++) {
                z |= this.O00000Oo.get(i).O000000o(iArr);
            }
            return z;
        }
    }

    static abstract class O0000O0o extends O00000o {
        protected s.O00000Oo[] O0000Ooo = null;
        int O0000o0 = 0;
        String O0000o00;
        int O0000o0O;

        public boolean O000000o() {
            return false;
        }

        public O0000O0o() {
            super((byte) 0);
        }

        public O0000O0o(O0000O0o o0000O0o) {
            super((byte) 0);
            this.O0000o00 = o0000O0o.O0000o00;
            this.O0000o0O = o0000O0o.O0000o0O;
            this.O0000Ooo = s.O000000o(o0000O0o.O0000Ooo);
        }

        public final void O000000o(Path path) {
            path.reset();
            s.O00000Oo[] o00000OoArr = this.O0000Ooo;
            if (o00000OoArr != null) {
                s.O00000Oo.O000000o(o00000OoArr, path);
            }
        }

        public String getPathName() {
            return this.O0000o00;
        }

        public s.O00000Oo[] getPathData() {
            return this.O0000Ooo;
        }

        public void setPathData(s.O00000Oo[] o00000OoArr) {
            if (!s.O000000o(this.O0000Ooo, o00000OoArr)) {
                this.O0000Ooo = s.O000000o(o00000OoArr);
                return;
            }
            s.O00000Oo[] o00000OoArr2 = this.O0000Ooo;
            for (int i = 0; i < o00000OoArr.length; i++) {
                o00000OoArr2[i].f2447O000000o = o00000OoArr[i].f2447O000000o;
                for (int i2 = 0; i2 < o00000OoArr[i].O00000Oo.length; i2++) {
                    o00000OoArr2[i].O00000Oo[i2] = o00000OoArr[i].O00000Oo[i2];
                }
            }
        }
    }

    static class O000000o extends O0000O0o {
        public final boolean O000000o() {
            return true;
        }

        O000000o() {
        }

        O000000o(O000000o o000000o) {
            super(o000000o);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.O0000o00 = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.O0000Ooo = s.O00000Oo(string2);
            }
            this.O0000o0 = n.O000000o(typedArray, xmlPullParser, "fillType", 2, 0);
        }
    }

    static class O00000Oo extends O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        i f2121O000000o;
        float O00000Oo = 0.0f;
        float O00000o = 1.0f;
        i O00000o0;
        float O00000oO = 1.0f;
        float O00000oo = 0.0f;
        float O0000O0o = 1.0f;
        float O0000OOo = 0.0f;
        Paint.Join O0000Oo = Paint.Join.MITER;
        Paint.Cap O0000Oo0 = Paint.Cap.BUTT;
        float O0000OoO = 4.0f;
        private int[] O0000o0o;

        O00000Oo() {
        }

        O00000Oo(O00000Oo o00000Oo) {
            super(o00000Oo);
            this.O0000o0o = o00000Oo.O0000o0o;
            this.f2121O000000o = o00000Oo.f2121O000000o;
            this.O00000Oo = o00000Oo.O00000Oo;
            this.O00000o = o00000Oo.O00000o;
            this.O00000o0 = o00000Oo.O00000o0;
            this.O0000o0 = o00000Oo.O0000o0;
            this.O00000oO = o00000Oo.O00000oO;
            this.O00000oo = o00000Oo.O00000oo;
            this.O0000O0o = o00000Oo.O0000O0o;
            this.O0000OOo = o00000Oo.O0000OOo;
            this.O0000Oo0 = o00000Oo.O0000Oo0;
            this.O0000Oo = o00000Oo.O0000Oo;
            this.O0000OoO = o00000Oo.O0000OoO;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.O0000o0o = null;
            if (n.O000000o(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.O0000o00 = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.O0000Ooo = s.O00000Oo(string2);
                }
                this.O00000o0 = n.O000000o(typedArray, xmlPullParser, theme, "fillColor", 1);
                this.O00000oO = n.O000000o(typedArray, xmlPullParser, "fillAlpha", 12, this.O00000oO);
                int O000000o2 = n.O000000o(typedArray, xmlPullParser, "strokeLineCap", 8, -1);
                Paint.Cap cap = this.O0000Oo0;
                if (O000000o2 == 0) {
                    cap = Paint.Cap.BUTT;
                } else if (O000000o2 == 1) {
                    cap = Paint.Cap.ROUND;
                } else if (O000000o2 == 2) {
                    cap = Paint.Cap.SQUARE;
                }
                this.O0000Oo0 = cap;
                int O000000o3 = n.O000000o(typedArray, xmlPullParser, "strokeLineJoin", 9, -1);
                Paint.Join join = this.O0000Oo;
                if (O000000o3 == 0) {
                    join = Paint.Join.MITER;
                } else if (O000000o3 == 1) {
                    join = Paint.Join.ROUND;
                } else if (O000000o3 == 2) {
                    join = Paint.Join.BEVEL;
                }
                this.O0000Oo = join;
                this.O0000OoO = n.O000000o(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.O0000OoO);
                this.f2121O000000o = n.O000000o(typedArray, xmlPullParser, theme, "strokeColor", 3);
                this.O00000o = n.O000000o(typedArray, xmlPullParser, "strokeAlpha", 11, this.O00000o);
                this.O00000Oo = n.O000000o(typedArray, xmlPullParser, "strokeWidth", 4, this.O00000Oo);
                this.O0000O0o = n.O000000o(typedArray, xmlPullParser, "trimPathEnd", 6, this.O0000O0o);
                this.O0000OOo = n.O000000o(typedArray, xmlPullParser, "trimPathOffset", 7, this.O0000OOo);
                this.O00000oo = n.O000000o(typedArray, xmlPullParser, "trimPathStart", 5, this.O00000oo);
                this.O0000o0 = n.O000000o(typedArray, xmlPullParser, "fillType", 13, this.O0000o0);
            }
        }

        public final boolean O00000Oo() {
            return this.O00000o0.O00000Oo() || this.f2121O000000o.O00000Oo();
        }

        public final boolean O000000o(int[] iArr) {
            return this.f2121O000000o.O000000o(iArr) | this.O00000o0.O000000o(iArr);
        }

        /* access modifiers changed from: package-private */
        public final int getStrokeColor() {
            return this.f2121O000000o.O00000Oo;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeColor(int i) {
            this.f2121O000000o.O00000Oo = i;
        }

        /* access modifiers changed from: package-private */
        public final float getStrokeWidth() {
            return this.O00000Oo;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeWidth(float f) {
            this.O00000Oo = f;
        }

        /* access modifiers changed from: package-private */
        public final float getStrokeAlpha() {
            return this.O00000o;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeAlpha(float f) {
            this.O00000o = f;
        }

        /* access modifiers changed from: package-private */
        public final int getFillColor() {
            return this.O00000o0.O00000Oo;
        }

        /* access modifiers changed from: package-private */
        public final void setFillColor(int i) {
            this.O00000o0.O00000Oo = i;
        }

        /* access modifiers changed from: package-private */
        public final float getFillAlpha() {
            return this.O00000oO;
        }

        /* access modifiers changed from: package-private */
        public final void setFillAlpha(float f) {
            this.O00000oO = f;
        }

        /* access modifiers changed from: package-private */
        public final float getTrimPathStart() {
            return this.O00000oo;
        }

        /* access modifiers changed from: package-private */
        public final void setTrimPathStart(float f) {
            this.O00000oo = f;
        }

        /* access modifiers changed from: package-private */
        public final float getTrimPathEnd() {
            return this.O0000O0o;
        }

        /* access modifiers changed from: package-private */
        public final void setTrimPathEnd(float f) {
            this.O0000O0o = f;
        }

        /* access modifiers changed from: package-private */
        public final float getTrimPathOffset() {
            return this.O0000OOo;
        }

        /* access modifiers changed from: package-private */
        public final void setTrimPathOffset(float f) {
            this.O0000OOo = f;
        }
    }
}

package _m_j;

import _m_j.OO000o0;
import _m_j.OO00OO;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
public class OO000OO extends OO00OO implements ac {
    private static final String O00000o0 = "OO000OO";
    private O00000Oo O00000o;
    private O0000OOo O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private boolean O0000OOo;

    public boolean isStateful() {
        return true;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public OO000OO() {
        this(null, null);
    }

    OO000OO(O00000Oo o00000Oo, Resources resources) {
        super((byte) 0);
        this.O00000oo = -1;
        this.O0000O0o = -1;
        O000000o(new O00000Oo(o00000Oo, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static OO000OO O000000o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            OO000OO oo000oo = new OO000OO();
            TypedArray O000000o2 = n.O000000o(resources, theme, attributeSet, new int[]{16843036, 16843156, 16843157, 16843158, 16843532, 16843533});
            oo000oo.setVisible(O000000o2.getBoolean(1, true), true);
            O00000Oo o00000Oo = oo000oo.O00000o;
            if (Build.VERSION.SDK_INT >= 21) {
                o00000Oo.O00000oo |= O000000o2.getChangingConfigurations();
            }
            o00000Oo.O0000OoO = O000000o2.getBoolean(2, o00000Oo.O0000OoO);
            o00000Oo.O0000o0 = O000000o2.getBoolean(3, o00000Oo.O0000o0);
            o00000Oo.O000O0OO = O000000o2.getInt(4, o00000Oo.O000O0OO);
            o00000Oo.O000O0Oo = O000000o2.getInt(5, o00000Oo.O000O0Oo);
            oo000oo.setDither(O000000o2.getBoolean(0, o00000Oo.O00oOooO));
            oo000oo.f6710O000000o.O000000o(resources);
            O000000o2.recycle();
            oo000oo.O00000Oo(context, resources, xmlPullParser, attributeSet, theme);
            oo000oo.onStateChange(oo000oo.getState());
            return oo000oo;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.O00000oO != null && (visible || z2)) {
            if (z) {
                this.O00000oO.O000000o();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        O0000OOo o0000OOo = this.O00000oO;
        if (o0000OOo != null) {
            o0000OOo.O00000Oo();
            this.O00000oO = null;
            O000000o(this.O00000oo);
            this.O00000oo = -1;
            this.O0000O0o = -1;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00eb, code lost:
        if (O000000o(r2) == false) goto L_0x00ee;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    public boolean onStateChange(int[] iArr) {
        boolean z;
        int i;
        O00000Oo o00000Oo;
        int O000000o2;
        int O000000o3;
        int longValue;
        O0000OOo o0000OOo;
        int[] iArr2 = iArr;
        int O000000o4 = this.O00000o.O000000o(iArr2);
        boolean z2 = true;
        if (O000000o4 != this.O00000Oo) {
            O0000OOo o0000OOo2 = this.O00000oO;
            if (o0000OOo2 == null) {
                i = this.O00000Oo;
                this.O00000oO = null;
                this.O0000O0o = -1;
                this.O00000oo = -1;
                o00000Oo = this.O00000o;
                O000000o2 = o00000Oo.O000000o(i);
                O000000o3 = o00000Oo.O000000o(O000000o4);
                longValue = (int) o00000Oo.f6706O000000o.O000000o(O00000Oo.O000000o(O000000o2, O000000o3), -1L).longValue();
                if (longValue >= 0) {
                }
                z = false;
                if (!z) {
                }
                Drawable current = getCurrent();
                if (current == null) {
                }
            } else if (O000000o4 != this.O00000oo) {
                if (O000000o4 != this.O0000O0o || !o0000OOo2.O00000o0()) {
                    i = this.O00000oo;
                    o0000OOo2.O00000Oo();
                    this.O00000oO = null;
                    this.O0000O0o = -1;
                    this.O00000oo = -1;
                    o00000Oo = this.O00000o;
                    O000000o2 = o00000Oo.O000000o(i);
                    O000000o3 = o00000Oo.O000000o(O000000o4);
                    if (!(O000000o3 == 0 || O000000o2 == 0)) {
                        longValue = (int) o00000Oo.f6706O000000o.O000000o(O00000Oo.O000000o(O000000o2, O000000o3), -1L).longValue();
                        if (longValue >= 0) {
                            boolean z3 = (o00000Oo.f6706O000000o.O000000o(O00000Oo.O000000o(O000000o2, O000000o3), -1L).longValue() & 8589934592L) != 0;
                            O000000o(longValue);
                            Drawable current2 = getCurrent();
                            if (current2 instanceof AnimationDrawable) {
                                o0000OOo = new O00000o((AnimationDrawable) current2, (o00000Oo.f6706O000000o.O000000o(O00000Oo.O000000o(O000000o2, O000000o3), -1L).longValue() & 4294967296L) != 0, z3);
                            } else if (current2 instanceof jq) {
                                o0000OOo = new O00000o0((jq) current2);
                            } else if (current2 instanceof Animatable) {
                                o0000OOo = new O000000o((Animatable) current2);
                            }
                            o0000OOo.O000000o();
                            this.O00000oO = o0000OOo;
                            this.O0000O0o = i;
                            this.O00000oo = O000000o4;
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                    Drawable current3 = getCurrent();
                    return current3 == null ? z2 | current3.setState(iArr2) : z2;
                }
                o0000OOo2.O00000o();
                this.O00000oo = this.O0000O0o;
                this.O0000O0o = O000000o4;
            }
            z = true;
            if (!z) {
            }
            Drawable current32 = getCurrent();
            if (current32 == null) {
            }
        }
        z2 = false;
        Drawable current322 = getCurrent();
        if (current322 == null) {
        }
    }

    static abstract class O0000OOo {
        public abstract void O000000o();

        public abstract void O00000Oo();

        public void O00000o() {
        }

        public boolean O00000o0() {
            return false;
        }

        private O0000OOo() {
        }

        /* synthetic */ O0000OOo(byte b) {
            this();
        }
    }

    static class O000000o extends O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Animatable f6705O000000o;

        O000000o(Animatable animatable) {
            super((byte) 0);
            this.f6705O000000o = animatable;
        }

        public final void O000000o() {
            this.f6705O000000o.start();
        }

        public final void O00000Oo() {
            this.f6705O000000o.stop();
        }
    }

    static class O00000o extends O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        private final ObjectAnimator f6707O000000o;
        private final boolean O00000Oo;

        O00000o(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super((byte) 0);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            O0000O0o o0000O0o = new O0000O0o(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) o0000O0o.f6709O000000o);
            ofInt.setInterpolator(o0000O0o);
            this.O00000Oo = z2;
            this.f6707O000000o = ofInt;
        }

        public final boolean O00000o0() {
            return this.O00000Oo;
        }

        public final void O000000o() {
            this.f6707O000000o.start();
        }

        public final void O00000o() {
            this.f6707O000000o.reverse();
        }

        public final void O00000Oo() {
            this.f6707O000000o.cancel();
        }
    }

    static class O00000o0 extends O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        private final jq f6708O000000o;

        O00000o0(jq jqVar) {
            super((byte) 0);
            this.f6708O000000o = jqVar;
        }

        public final void O000000o() {
            this.f6708O000000o.start();
        }

        public final void O00000Oo() {
            this.f6708O000000o.stop();
        }
    }

    private void O00000Oo(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int next;
        AttributeSet attributeSet2 = attributeSet;
        int depth2 = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1 && ((depth = xmlPullParser.getDepth()) >= depth2 || next2 != 3)) {
                if (next2 == 2 && depth <= depth2) {
                    if (xmlPullParser.getName().equals("item")) {
                        TypedArray O000000o2 = n.O000000o(resources, theme, attributeSet2, new int[]{16842960, 16843161});
                        int resourceId = O000000o2.getResourceId(0, 0);
                        Drawable drawable = null;
                        int resourceId2 = O000000o2.getResourceId(1, -1);
                        if (resourceId2 > 0) {
                            drawable = o0OOoOoo.O000000o().O000000o(context, resourceId2);
                        }
                        O000000o2.recycle();
                        int attributeCount = attributeSet.getAttributeCount();
                        int[] iArr = new int[attributeCount];
                        int i = 0;
                        for (int i2 = 0; i2 < attributeCount; i2++) {
                            int attributeNameResource = attributeSet2.getAttributeNameResource(i2);
                            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                                int i3 = i + 1;
                                if (!attributeSet2.getAttributeBooleanValue(i2, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr[i] = attributeNameResource;
                                i = i3;
                            }
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr, i);
                        if (drawable == null) {
                            do {
                                next = xmlPullParser.next();
                            } while (next == 4);
                            if (next != 2) {
                                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                            } else if (xmlPullParser.getName().equals("vector")) {
                                drawable = jw.O000000o(resources, xmlPullParser, attributeSet, theme);
                            } else if (Build.VERSION.SDK_INT >= 21) {
                                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                            } else {
                                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                            }
                        }
                        if (drawable != null) {
                            this.O00000o.O000000o(trimStateSet, drawable, resourceId);
                        } else {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                    } else if (xmlPullParser.getName().equals("transition")) {
                        O00000o0(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            }
        }
    }

    private int O00000o0(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray O000000o2 = n.O000000o(resources, theme, attributeSet, new int[]{16843161, 16843849, 16843850, 16843851});
        int resourceId = O000000o2.getResourceId(2, -1);
        int resourceId2 = O000000o2.getResourceId(1, -1);
        int resourceId3 = O000000o2.getResourceId(0, -1);
        Drawable O000000o3 = resourceId3 > 0 ? o0OOoOoo.O000000o().O000000o(context, resourceId3) : null;
        boolean z = O000000o2.getBoolean(3, false);
        O000000o2.recycle();
        if (O000000o3 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                O000000o3 = jq.O000000o(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                O000000o3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                O000000o3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (O000000o3 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.O00000o.O000000o(resourceId, resourceId2, O000000o3, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    public Drawable mutate() {
        if (!this.O0000OOo && super.mutate() == this) {
            this.O00000o.O000000o();
            this.O0000OOo = true;
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public O00000Oo O00000Oo() {
        return new O00000Oo(this.O00000o, this, null);
    }

    static class O00000Oo extends OO00OO.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        o0O0o000<Long> f6706O000000o;
        o0OO00o0<Integer> O00000Oo;

        static long O000000o(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        O00000Oo(O00000Oo o00000Oo, OO000OO oo000oo, Resources resources) {
            super(o00000Oo, oo000oo, resources);
            if (o00000Oo != null) {
                this.f6706O000000o = o00000Oo.f6706O000000o;
                this.O00000Oo = o00000Oo.O00000Oo;
                return;
            }
            this.f6706O000000o = new o0O0o000<>();
            this.O00000Oo = new o0OO00o0<>();
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            this.f6706O000000o = this.f6706O000000o.clone();
            this.O00000Oo = this.O00000Oo.clone();
        }

        /* access modifiers changed from: package-private */
        public final int O000000o(int i, int i2, Drawable drawable, boolean z) {
            int O000000o2 = super.O000000o(drawable);
            long O000000o3 = O000000o(i, i2);
            long j = z ? 8589934592L : 0;
            long j2 = (long) O000000o2;
            this.f6706O000000o.O00000o0(O000000o3, Long.valueOf(j2 | j));
            if (z) {
                this.f6706O000000o.O00000o0(O000000o(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return O000000o2;
        }

        /* access modifiers changed from: package-private */
        public final int O000000o(int[] iArr) {
            int O00000Oo2 = super.O00000Oo(iArr);
            if (O00000Oo2 >= 0) {
                return O00000Oo2;
            }
            return super.O00000Oo(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        public final int O000000o(int i) {
            if (i < 0) {
                return 0;
            }
            return this.O00000Oo.O000000o(i, 0).intValue();
        }

        public final Drawable newDrawable() {
            return new OO000OO(this, null);
        }

        public final Drawable newDrawable(Resources resources) {
            return new OO000OO(this, resources);
        }

        /* access modifiers changed from: package-private */
        public final int O000000o(int[] iArr, Drawable drawable, int i) {
            int O000000o2 = O000000o(drawable);
            this.O000OO[O000000o2] = iArr;
            this.O00000Oo.O00000Oo(O000000o2, Integer.valueOf(i));
            return O000000o2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(OO000o0.O00000Oo o00000Oo) {
        super.O000000o(o00000Oo);
        if (o00000Oo instanceof O00000Oo) {
            this.O00000o = (O00000Oo) o00000Oo;
        }
    }

    static class O0000O0o implements TimeInterpolator {

        /* renamed from: O000000o  reason: collision with root package name */
        int f6709O000000o;
        private int[] O00000Oo;
        private int O00000o0;

        O0000O0o(AnimationDrawable animationDrawable, boolean z) {
            O000000o(animationDrawable, z);
        }

        private int O000000o(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.O00000o0 = numberOfFrames;
            int[] iArr = this.O00000Oo;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.O00000Oo = new int[numberOfFrames];
            }
            int[] iArr2 = this.O00000Oo;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f6709O000000o = i;
            return i;
        }

        public final float getInterpolation(float f) {
            int i = (int) ((f * ((float) this.f6709O000000o)) + 0.5f);
            int i2 = this.O00000o0;
            int[] iArr = this.O00000Oo;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.f6709O000000o) : 0.0f);
        }
    }
}

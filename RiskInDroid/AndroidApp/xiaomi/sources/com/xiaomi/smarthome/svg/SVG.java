package com.xiaomi.smarthome.svg;

import _m_j.hyj;
import _m_j.hyk;
import _m_j.hyl;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.svg.CSSParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class SVG {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final List<O00OO0O> f11866O000000o = new ArrayList(0);
    public O00O00o0 O00000Oo = null;
    String O00000o = "";
    public hyl O00000o0 = null;
    String O00000oO = "";
    public CSSParser.O00000o O00000oo = new CSSParser.O00000o();
    private float O0000O0o = 96.0f;

    public enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    public interface O000O0o0 {
        void O000000o(Matrix matrix);
    }

    public interface O000OOo0 {
    }

    public interface O000o000 {
        void O000000o();

        void O000000o(float f, float f2);

        void O000000o(float f, float f2, float f3, float f4);

        void O000000o(float f, float f2, float f3, float f4, float f5, float f6);

        void O000000o(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);

        void O00000Oo(float f, float f2);
    }

    public interface O00O00o {
        void O000000o(String str);

        void O000000o(Set<String> set);

        Set<String> O00000Oo();

        void O00000Oo(Set<String> set);

        Set<String> O00000o();

        void O00000o(Set<String> set);

        String O00000o0();

        void O00000o0(Set<String> set);

        Set<String> O00000oO();

        Set<String> O00000oo();
    }

    public interface O00O0Oo0 {
        List<O00OO0O> O000000o();

        void O000000o(O00OO0O o00oo0o) throws SAXException;
    }

    public interface O00OoO0o {
        O00o000 O0000O0o();
    }

    public interface O00o000 {
    }

    public enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    public static SVG O000000o(String str) throws IOException, SAXException, ParserConfigurationException {
        return new SVGParser().O000000o(new ByteArrayInputStream(str.getBytes()));
    }

    public static SVG O000000o(Context context, int i) throws IOException, SAXException, ParserConfigurationException {
        return new SVGParser().O000000o(context.getResources().openRawResource(i));
    }

    public final void O000000o(Canvas canvas, PreserveAspectRatio preserveAspectRatio, RectF rectF, hyj hyj) {
        hyk hyk = new hyk(canvas, O000000o.O000000o(rectF.left, rectF.top, rectF.right, rectF.bottom), this.O0000O0o);
        hyk.O00000o = hyj;
        hyk.O000000o(this, preserveAspectRatio);
    }

    public final float O000000o() {
        if (this.O00000Oo != null) {
            return O000000o(this.O0000O0o).O00000o0;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public final float O00000Oo() {
        if (this.O00000Oo != null) {
            return O000000o(this.O0000O0o).O00000o;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public final O00OO0O O00000Oo(String str) {
        if (str == null || str.length() <= 1 || !str.startsWith("#")) {
            return null;
        }
        String substring = str.substring(1);
        if (substring.equals(this.O00000Oo.O0000o0o)) {
            return this.O00000Oo;
        }
        return O000000o(this.O00000Oo, substring);
    }

    private O000000o O000000o(float f) {
        float f2;
        O000OO00 o000oo00 = this.O00000Oo.O00000o0;
        O000OO00 o000oo002 = this.O00000Oo.O00000o;
        if (o000oo00 == null || o000oo00.O000000o() || o000oo00.O00000Oo == Unit.percent || o000oo00.O00000Oo == Unit.em || o000oo00.O00000Oo == Unit.ex) {
            return new O000000o(-1.0f, -1.0f, -1.0f, -1.0f);
        }
        float O000000o2 = o000oo00.O000000o(f);
        if (o000oo002 == null) {
            f2 = this.O00000Oo.O0000ooO != null ? (this.O00000Oo.O0000ooO.O00000o * O000000o2) / this.O00000Oo.O0000ooO.O00000o0 : O000000o2;
        } else if (o000oo002.O000000o() || o000oo002.O00000Oo == Unit.percent || o000oo002.O00000Oo == Unit.em || o000oo002.O00000Oo == Unit.ex) {
            return new O000000o(-1.0f, -1.0f, -1.0f, -1.0f);
        } else {
            f2 = o000oo002.O000000o(f);
        }
        return new O000000o(0.0f, 0.0f, O000000o2, f2);
    }

    public final boolean O00000o0() {
        CSSParser.O00000o o00000o = this.O00000oo;
        return !(o00000o.f11861O000000o == null || o00000o.f11861O000000o.isEmpty());
    }

    public static class O000000o implements Cloneable {

        /* renamed from: O000000o  reason: collision with root package name */
        public float f11868O000000o;
        public float O00000Oo;
        public float O00000o;
        public float O00000o0;

        public O000000o(float f, float f2, float f3, float f4) {
            this.f11868O000000o = f;
            this.O00000Oo = f2;
            this.O00000o0 = f3;
            this.O00000o = f4;
        }

        public static O000000o O000000o(float f, float f2, float f3, float f4) {
            return new O000000o(f, f2, f3 - f, f4 - f2);
        }

        public final float O000000o() {
            return this.f11868O000000o + this.O00000o0;
        }

        public final float O00000Oo() {
            return this.O00000Oo + this.O00000o;
        }

        public final void O000000o(O000000o o000000o) {
            float f = o000000o.f11868O000000o;
            if (f < this.f11868O000000o) {
                this.f11868O000000o = f;
            }
            float f2 = o000000o.O00000Oo;
            if (f2 < this.O00000Oo) {
                this.O00000Oo = f2;
            }
            if (o000000o.O000000o() > O000000o()) {
                this.O00000o0 = o000000o.O000000o() - this.f11868O000000o;
            }
            if (o000000o.O00000Oo() > O00000Oo()) {
                this.O00000o = o000000o.O00000Oo() - this.O00000Oo;
            }
        }

        public final String toString() {
            return "[" + this.f11868O000000o + " " + this.O00000Oo + " " + this.O00000o0 + " " + this.O00000o + "]";
        }
    }

    public static class Style implements Cloneable {

        /* renamed from: O000000o  reason: collision with root package name */
        public long f11895O000000o = 0;
        public O00OOOo O00000Oo;
        public Float O00000o;
        public FillRule O00000o0;
        public O00OOOo O00000oO;
        public Float O00000oo;
        public O000OO00 O0000O0o;
        public LineCaps O0000OOo;
        public Float O0000Oo;
        public LineJoin O0000Oo0;
        public O000OO00[] O0000OoO;
        public O000OO00 O0000Ooo;
        public Integer O0000o;
        public O0000O0o O0000o0;
        public Float O0000o00;
        public List<String> O0000o0O;
        public O000OO00 O0000o0o;
        public TextDecoration O0000oO;
        public FontStyle O0000oO0;
        public TextDirection O0000oOO;
        public TextAnchor O0000oOo;
        public O00000Oo O0000oo;
        public Boolean O0000oo0;
        public String O0000ooO;
        public String O0000ooo;
        public Boolean O000O00o;
        public O00OOOo O000O0OO;
        public Float O000O0Oo;
        public String O000O0o;
        public FillRule O000O0o0;
        public O00OOOo O000O0oO;
        public Float O000O0oo;
        public VectorEffect O000OO;
        public O00OOOo O000OO00;
        public Float O000OO0o;
        public String O00oOoOo;
        public String O00oOooO;
        public Boolean O00oOooo;

        public enum FillRule {
            NonZero,
            EvenOdd
        }

        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        public enum LineCaps {
            Butt,
            Round,
            Square
        }

        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        public enum TextDirection {
            LTR,
            RTL
        }

        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        protected Style() {
        }

        public static Style O000000o() {
            Style style = new Style();
            style.f11895O000000o = -1;
            style.O00000Oo = O0000O0o.O00000Oo;
            style.O00000o0 = FillRule.NonZero;
            Float valueOf = Float.valueOf(1.0f);
            style.O00000o = valueOf;
            style.O00000oO = null;
            style.O00000oo = valueOf;
            style.O0000O0o = new O000OO00(1.0f);
            style.O0000OOo = LineCaps.Butt;
            style.O0000Oo0 = LineJoin.Miter;
            style.O0000Oo = Float.valueOf(4.0f);
            style.O0000OoO = null;
            style.O0000Ooo = new O000OO00(0.0f);
            style.O0000o00 = valueOf;
            style.O0000o0 = O0000O0o.O00000Oo;
            style.O0000o0O = null;
            style.O0000o0o = new O000OO00(12.0f, Unit.pt);
            style.O0000o = 400;
            style.O0000oO0 = FontStyle.Normal;
            style.O0000oO = TextDecoration.None;
            style.O0000oOO = TextDirection.LTR;
            style.O0000oOo = TextAnchor.Start;
            style.O0000oo0 = Boolean.TRUE;
            style.O0000oo = null;
            style.O0000ooO = null;
            style.O0000ooo = null;
            style.O00oOooO = null;
            style.O00oOooo = Boolean.TRUE;
            style.O000O00o = Boolean.TRUE;
            style.O000O0OO = O0000O0o.O00000Oo;
            style.O000O0Oo = valueOf;
            style.O00oOoOo = null;
            style.O000O0o0 = FillRule.NonZero;
            style.O000O0o = null;
            style.O000O0oO = null;
            style.O000O0oo = valueOf;
            style.O000OO00 = null;
            style.O000OO0o = valueOf;
            style.O000OO = VectorEffect.None;
            return style;
        }

        public final void O000000o(boolean z) {
            this.O00oOooo = Boolean.TRUE;
            this.O0000oo0 = z ? Boolean.TRUE : Boolean.FALSE;
            this.O0000oo = null;
            this.O00oOoOo = null;
            this.O0000o00 = Float.valueOf(1.0f);
            this.O000O0OO = O0000O0o.O00000Oo;
            this.O000O0Oo = Float.valueOf(1.0f);
            this.O000O0o = null;
            this.O000O0oO = null;
            this.O000O0oo = Float.valueOf(1.0f);
            this.O000OO00 = null;
            this.O000OO0o = Float.valueOf(1.0f);
            this.O000OO = VectorEffect.None;
        }

        public final Object clone() {
            try {
                Style style = (Style) super.clone();
                if (this.O0000OoO != null) {
                    style.O0000OoO = (O000OO00[]) this.O0000OoO.clone();
                }
                return style;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    public static abstract class O00OOOo implements Cloneable {
        protected O00OOOo() {
        }
    }

    public static class O0000O0o extends O00OOOo {
        public static final O0000O0o O00000Oo = new O0000O0o(0);

        /* renamed from: O000000o  reason: collision with root package name */
        public int f11872O000000o;

        public O0000O0o(int i) {
            this.f11872O000000o = i;
        }

        public final String toString() {
            return String.format("#%06x", Integer.valueOf(this.f11872O000000o));
        }
    }

    public static class O0000OOo extends O00OOOo {

        /* renamed from: O000000o  reason: collision with root package name */
        private static O0000OOo f11873O000000o = new O0000OOo();

        private O0000OOo() {
        }

        public static O0000OOo O000000o() {
            return f11873O000000o;
        }
    }

    public static class O000OOo extends O00OOOo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11881O000000o;
        public O00OOOo O00000Oo;

        public O000OOo(String str, O00OOOo o00OOOo) {
            this.f11881O000000o = str;
            this.O00000Oo = o00OOOo;
        }

        public final String toString() {
            return this.f11881O000000o + " " + this.O00000Oo;
        }
    }

    public static class O000OO00 implements Cloneable {

        /* renamed from: O000000o  reason: collision with root package name */
        float f11878O000000o = 0.0f;
        Unit O00000Oo = Unit.px;

        public O000OO00(float f, Unit unit) {
            this.f11878O000000o = f;
            this.O00000Oo = unit;
        }

        public O000OO00(float f) {
            this.f11878O000000o = f;
            this.O00000Oo = Unit.px;
        }

        public final float O000000o(hyk hyk) {
            switch (AnonymousClass1.f11867O000000o[this.O00000Oo.ordinal()]) {
                case 1:
                    return this.f11878O000000o;
                case 2:
                    return this.f11878O000000o * hyk.O000000o();
                case 3:
                    return this.f11878O000000o * (hyk.O00000o0.O00000o.getTextSize() / 2.0f);
                case 4:
                    return this.f11878O000000o * hyk.O00000Oo;
                case 5:
                    return (this.f11878O000000o * hyk.O00000Oo) / 2.54f;
                case 6:
                    return (this.f11878O000000o * hyk.O00000Oo) / 25.4f;
                case 7:
                    return (this.f11878O000000o * hyk.O00000Oo) / 72.0f;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return (this.f11878O000000o * hyk.O00000Oo) / 6.0f;
                case 9:
                    O000000o O00000Oo2 = hyk.O00000Oo();
                    if (O00000Oo2 == null) {
                        return this.f11878O000000o;
                    }
                    return (this.f11878O000000o * O00000Oo2.O00000o0) / 100.0f;
                default:
                    return this.f11878O000000o;
            }
        }

        public final float O00000Oo(hyk hyk) {
            if (this.O00000Oo != Unit.percent) {
                return O000000o(hyk);
            }
            O000000o O00000Oo2 = hyk.O00000Oo();
            if (O00000Oo2 == null) {
                return this.f11878O000000o;
            }
            return (this.f11878O000000o * O00000Oo2.O00000o) / 100.0f;
        }

        public final float O00000o0(hyk hyk) {
            if (this.O00000Oo != Unit.percent) {
                return O000000o(hyk);
            }
            O000000o O00000Oo2 = hyk.O00000Oo();
            if (O00000Oo2 == null) {
                return this.f11878O000000o;
            }
            float f = O00000Oo2.O00000o0;
            float f2 = O00000Oo2.O00000o;
            if (f == f2) {
                return (this.f11878O000000o * f) / 100.0f;
            }
            return (this.f11878O000000o * ((float) (Math.sqrt((double) ((f * f) + (f2 * f2))) / 1.414213562373095d))) / 100.0f;
        }

        public final float O000000o(hyk hyk, float f) {
            if (this.O00000Oo == Unit.percent) {
                return (this.f11878O000000o * f) / 100.0f;
            }
            return O000000o(hyk);
        }

        public final float O000000o(float f) {
            int i = AnonymousClass1.f11867O000000o[this.O00000Oo.ordinal()];
            if (i == 1) {
                return this.f11878O000000o;
            }
            switch (i) {
                case 4:
                    return this.f11878O000000o * f;
                case 5:
                    return (this.f11878O000000o * f) / 2.54f;
                case 6:
                    return (this.f11878O000000o * f) / 25.4f;
                case 7:
                    return (this.f11878O000000o * f) / 72.0f;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return (this.f11878O000000o * f) / 6.0f;
                default:
                    return this.f11878O000000o;
            }
        }

        public final boolean O000000o() {
            return this.f11878O000000o == 0.0f;
        }

        public final boolean O00000Oo() {
            return this.f11878O000000o < 0.0f;
        }

        public final String toString() {
            return String.valueOf(this.f11878O000000o) + this.O00000Oo;
        }
    }

    /* renamed from: com.xiaomi.smarthome.svg.SVG$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f11867O000000o = new int[Unit.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f11867O000000o[Unit.px.ordinal()] = 1;
            f11867O000000o[Unit.em.ordinal()] = 2;
            f11867O000000o[Unit.ex.ordinal()] = 3;
            f11867O000000o[Unit.in.ordinal()] = 4;
            f11867O000000o[Unit.cm.ordinal()] = 5;
            f11867O000000o[Unit.mm.ordinal()] = 6;
            f11867O000000o[Unit.pt.ordinal()] = 7;
            f11867O000000o[Unit.pc.ordinal()] = 8;
            f11867O000000o[Unit.percent.ordinal()] = 9;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public O000OO00 f11869O000000o;
        public O000OO00 O00000Oo;
        public O000OO00 O00000o;
        public O000OO00 O00000o0;

        public O00000Oo(O000OO00 o000oo00, O000OO00 o000oo002, O000OO00 o000oo003, O000OO00 o000oo004) {
            this.f11869O000000o = o000oo00;
            this.O00000Oo = o000oo002;
            this.O00000o0 = o000oo003;
            this.O00000o = o000oo004;
        }
    }

    public static class O00OO0O {
        public SVG O0000oOo;
        public O00O0Oo0 O0000oo0;

        protected O00OO0O() {
        }

        public String toString() {
            return getClass().getSimpleName();
        }
    }

    public static class O00O0o0 extends O00OO0O {
        public Boolean O0000o = null;
        public String O0000o0o = null;
        public Style O0000oO = null;
        public Style O0000oO0 = null;
        public List<String> O0000oOO = null;

        protected O00O0o0() {
        }
    }

    public static class O00O0o00 extends O00O0o0 {
        public O000000o O0000o0O = null;

        protected O00O0o00() {
        }
    }

    public static class O00O0OOo extends O00O0o00 implements O00O00o {
        public Set<String> O0000OOo = null;
        public Set<String> O0000Oo = null;
        public String O0000Oo0 = null;
        public Set<String> O0000OoO = null;
        public Set<String> O0000Ooo = null;

        protected O00O0OOo() {
        }

        public final void O000000o(Set<String> set) {
            this.O0000OOo = set;
        }

        public final Set<String> O00000Oo() {
            return this.O0000OOo;
        }

        public final void O000000o(String str) {
            this.O0000Oo0 = str;
        }

        public final String O00000o0() {
            return this.O0000Oo0;
        }

        public final void O00000Oo(Set<String> set) {
            this.O0000Oo = set;
        }

        public final Set<String> O00000o() {
            return this.O0000Oo;
        }

        public final void O00000o0(Set<String> set) {
            this.O0000OoO = set;
        }

        public final Set<String> O00000oO() {
            return this.O0000OoO;
        }

        public final void O00000o(Set<String> set) {
            this.O0000Ooo = set;
        }

        public final Set<String> O00000oo() {
            return this.O0000Ooo;
        }
    }

    public static class O00O0O0o extends O00O0o00 implements O00O00o, O00O0Oo0 {
        public Set<String> O0000Oo = null;
        public List<O00OO0O> O0000Oo0 = new ArrayList();
        public String O0000OoO = null;
        public Set<String> O0000Ooo = null;
        public Set<String> O0000o0 = null;
        public Set<String> O0000o00 = null;

        public final Set<String> O00000o() {
            return null;
        }

        protected O00O0O0o() {
        }

        public final List<O00OO0O> O000000o() {
            return this.O0000Oo0;
        }

        public void O000000o(O00OO0O o00oo0o) throws SAXException {
            this.O0000Oo0.add(o00oo0o);
        }

        public final void O000000o(Set<String> set) {
            this.O0000Oo = set;
        }

        public final Set<String> O00000Oo() {
            return this.O0000Oo;
        }

        public final void O000000o(String str) {
            this.O0000OoO = str;
        }

        public final String O00000o0() {
            return this.O0000OoO;
        }

        public final void O00000Oo(Set<String> set) {
            this.O0000Ooo = set;
        }

        public final void O00000o0(Set<String> set) {
            this.O0000o00 = set;
        }

        public final Set<String> O00000oO() {
            return this.O0000o00;
        }

        public final void O00000o(Set<String> set) {
            this.O0000o0 = set;
        }

        public final Set<String> O00000oo() {
            return this.O0000o0;
        }
    }

    public static class O00OOo0 extends O00O0O0o {
        public PreserveAspectRatio O0000oo = null;

        protected O00OOo0() {
        }
    }

    public static class O00Oo00 extends O00OOo0 {
        public O000000o O0000ooO;

        protected O00Oo00() {
        }
    }

    public static class O00O00o0 extends O00Oo00 {

        /* renamed from: O000000o  reason: collision with root package name */
        public O000OO00 f11886O000000o;
        public O000OO00 O00000Oo;
        public O000OO00 O00000o;
        public O000OO00 O00000o0;
        public String O00000oO;

        protected O00O00o0() {
        }
    }

    public static class O000O0OO extends O00O0O0o implements O000O0o0 {
        public Matrix O00000Oo;
        public String O00000o0;

        protected O000O0OO() {
        }

        public final void O000000o(Matrix matrix) {
            this.O00000Oo = matrix;
        }
    }

    public static class O0000Oo0 extends O000O0OO implements O000OOo0 {
        protected O0000Oo0() {
        }
    }

    public static class O0000o extends O00O0o00 implements O000OOo0 {
        protected O0000o() {
        }
    }

    public static class O0000o0 extends O000O0OO implements O000OOo0 {
        protected O0000o0() {
        }
    }

    public static class O0000o00 extends O0000o implements O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public float[] f11875O000000o;
        public String O00000Oo;
        public String O00000o0;

        protected O0000o00() {
        }
    }

    public static abstract class O000O00o extends O00O0OOo implements O000O0o0 {
        public Matrix O00000oO;

        protected O000O00o() {
        }

        public final void O000000o(Matrix matrix) {
            this.O00000oO = matrix;
        }
    }

    public static class O00o0 extends O000O0OO {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11892O000000o;
        public O000OO00 O00000o;
        public O000OO00 O00000oO;
        public O000OO00 O00000oo;
        public O000OO00 O0000O0o;

        protected O00o0() {
        }
    }

    public static class O000Oo0 extends O000O00o {

        /* renamed from: O000000o  reason: collision with root package name */
        public O00O0Oo f11882O000000o;
        public Float O00000Oo;

        protected O000Oo0() {
        }
    }

    public static class oooOoO extends O000O00o {

        /* renamed from: O000000o  reason: collision with root package name */
        public O000OO00 f11897O000000o;
        public O000OO00 O00000Oo;
        public O000OO00 O00000o;
        public O000OO00 O00000o0;
        public O000OO00 O00000oo;
        public O000OO00 O0000O0o;

        protected oooOoO() {
        }
    }

    public static class O00000o0 extends O000O00o {

        /* renamed from: O000000o  reason: collision with root package name */
        public O000OO00 f11871O000000o;
        public O000OO00 O00000Oo;
        public O000OO00 O00000o0;

        protected O00000o0() {
        }
    }

    public static class O0000Oo extends O000O00o {

        /* renamed from: O000000o  reason: collision with root package name */
        public O000OO00 f11874O000000o;
        public O000OO00 O00000Oo;
        public O000OO00 O00000o;
        public O000OO00 O00000o0;

        protected O0000Oo() {
        }
    }

    public static class O000OO0o extends O000O00o {

        /* renamed from: O000000o  reason: collision with root package name */
        public O000OO00 f11879O000000o;
        public O000OO00 O00000Oo;
        public O000OO00 O00000o;
        public O000OO00 O00000o0;

        protected O000OO0o() {
        }
    }

    public static class O000o0 extends O000O00o {

        /* renamed from: O000000o  reason: collision with root package name */
        public float[] f11883O000000o;

        protected O000o0() {
        }
    }

    public static class O000o extends O000o0 {
        protected O000o() {
        }
    }

    public static class O00OoOO0 extends O00O0O0o {
        protected O00OoOO0() {
        }

        public final void O000000o(O00OO0O o00oo0o) throws SAXException {
            if (o00oo0o instanceof O00OoO0o) {
                this.O0000Oo0.add(o00oo0o);
                return;
            }
            throw new SAXException("Text content elements cannot contain " + o00oo0o + " elements.");
        }
    }

    public static class O00o0000 extends O00OoOO0 {
        public List<O000OO00> O00000Oo;
        public List<O000OO00> O00000o;
        public List<O000OO00> O00000o0;
        public List<O000OO00> O00000oO;

        protected O00o0000() {
        }
    }

    public static class O00Oo extends O00o0000 implements O000O0o0, O00o000 {

        /* renamed from: O000000o  reason: collision with root package name */
        public Matrix f11888O000000o;

        protected O00Oo() {
        }

        public final void O000000o(Matrix matrix) {
            this.f11888O000000o = matrix;
        }
    }

    public static class O00Oo0o0 extends O00o0000 implements O00OoO0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public O00o000 f11890O000000o;

        protected O00Oo0o0() {
        }

        public final O00o000 O0000O0o() {
            return this.f11890O000000o;
        }
    }

    public static class O00o00 extends O00OO0O implements O00OoO0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11893O000000o;
        private O00o000 O00000Oo;

        public O00o00(String str) {
            this.f11893O000000o = str;
        }

        public final String toString() {
            return getClass().getSimpleName() + " '" + this.f11893O000000o + "'";
        }

        public final O00o000 O0000O0o() {
            return this.O00000Oo;
        }
    }

    public static class O00Oo0OO extends O00OoOO0 implements O00OoO0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11889O000000o;
        public O00o000 O00000Oo;

        protected O00Oo0OO() {
        }

        public final O00o000 O0000O0o() {
            return this.O00000Oo;
        }
    }

    public static class O00Ooo00 extends O00OoOO0 implements O00OoO0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11891O000000o;
        public O000OO00 O00000Oo;
        public O00o000 O00000o0;

        protected O00Ooo00() {
        }

        public final O00o000 O0000O0o() {
            return this.O00000o0;
        }
    }

    public static class O00Oo00o extends O000O0OO {
        protected O00Oo00o() {
        }
    }

    public static class O00Oo0 extends O00Oo00 implements O000OOo0 {
        protected O00Oo0() {
        }
    }

    public static class O000OO extends O00Oo00 implements O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f11877O000000o;
        public O000OO00 O00000Oo;
        public O000OO00 O00000o;
        public O000OO00 O00000o0;
        public O000OO00 O00000oO;
        public Float O00000oo;

        protected O000OO() {
        }
    }

    public static class O00oOooO extends O00O0o0 implements O00O0Oo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<O00OO0O> f11894O000000o = new ArrayList();
        public Boolean O00000Oo;
        public GradientSpread O00000o;
        public Matrix O00000o0;
        public String O00000oO;

        protected O00oOooO() {
        }

        public final List<O00OO0O> O000000o() {
            return this.f11894O000000o;
        }

        public final void O000000o(O00OO0O o00oo0o) throws SAXException {
            if (o00oo0o instanceof O00O00Oo) {
                this.f11894O000000o.add(o00oo0o);
                return;
            }
            throw new SAXException("Gradient elements cannot contain " + o00oo0o + " elements.");
        }
    }

    public static class O00O00Oo extends O00O0o0 implements O00O0Oo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public Float f11885O000000o;

        public final void O000000o(O00OO0O o00oo0o) throws SAXException {
        }

        protected O00O00Oo() {
        }

        public final List<O00OO0O> O000000o() {
            return SVG.f11866O000000o;
        }
    }

    public static class O00O0o extends O00oOooO {
        public O000OO00 O00000oo;
        public O000OO00 O0000O0o;
        public O000OO00 O0000OOo;
        public O000OO00 O0000Oo0;

        protected O00O0o() {
        }
    }

    public static class O00OOo extends O00oOooO {
        public O000OO00 O00000oo;
        public O000OO00 O0000O0o;
        public O000OO00 O0000OOo;
        public O000OO00 O0000Oo;
        public O000OO00 O0000Oo0;

        protected O00OOo() {
        }
    }

    public static class O00000o extends O000O0OO implements O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public Boolean f11870O000000o;

        protected O00000o() {
        }
    }

    public static class O000o00 extends O00Oo00 implements O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public Boolean f11884O000000o;
        public Boolean O00000Oo;
        public O000OO00 O00000o;
        public Matrix O00000o0;
        public O000OO00 O00000oO;
        public O000OO00 O00000oo;
        public O000OO00 O0000O0o;
        public String O0000OOo;

        protected O000o00() {
        }
    }

    public static class O000O0o extends O00OOo0 implements O000O0o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11876O000000o;
        public O000OO00 O00000Oo;
        public O000OO00 O00000o;
        public O000OO00 O00000o0;
        public O000OO00 O00000oO;
        public Matrix O00000oo;

        protected O000O0o() {
        }

        public final void O000000o(Matrix matrix) {
            this.O00000oo = matrix;
        }
    }

    public static class O00oo000 extends O00Oo00 implements O000OOo0 {
        protected O00oo000() {
        }
    }

    public static class O000OOOo extends O00O0O0o implements O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public Boolean f11880O000000o;
        public Boolean O00000Oo;
        public O000OO00 O00000o;
        public O000OO00 O00000o0;
        public O000OO00 O00000oO;
        public O000OO00 O00000oo;

        protected O000OOOo() {
        }
    }

    public static class O00O000o extends O00O0o0 implements O00O0Oo0 {
        public final void O000000o(O00OO0O o00oo0o) throws SAXException {
        }

        protected O00O000o() {
        }

        public final List<O00OO0O> O000000o() {
            return SVG.f11866O000000o;
        }
    }

    public static class O00O0Oo implements O000o000 {

        /* renamed from: O000000o  reason: collision with root package name */
        List<Byte> f11887O000000o;
        private List<Float> O00000Oo;

        public O00O0Oo() {
            this.f11887O000000o = null;
            this.O00000Oo = null;
            this.f11887O000000o = new ArrayList();
            this.O00000Oo = new ArrayList();
        }

        public final void O000000o(float f, float f2) {
            this.f11887O000000o.add((byte) 0);
            this.O00000Oo.add(Float.valueOf(f));
            this.O00000Oo.add(Float.valueOf(f2));
        }

        public final void O00000Oo(float f, float f2) {
            this.f11887O000000o.add((byte) 1);
            this.O00000Oo.add(Float.valueOf(f));
            this.O00000Oo.add(Float.valueOf(f2));
        }

        public final void O000000o(float f, float f2, float f3, float f4, float f5, float f6) {
            this.f11887O000000o.add((byte) 2);
            this.O00000Oo.add(Float.valueOf(f));
            this.O00000Oo.add(Float.valueOf(f2));
            this.O00000Oo.add(Float.valueOf(f3));
            this.O00000Oo.add(Float.valueOf(f4));
            this.O00000Oo.add(Float.valueOf(f5));
            this.O00000Oo.add(Float.valueOf(f6));
        }

        public final void O000000o(float f, float f2, float f3, float f4) {
            this.f11887O000000o.add((byte) 3);
            this.O00000Oo.add(Float.valueOf(f));
            this.O00000Oo.add(Float.valueOf(f2));
            this.O00000Oo.add(Float.valueOf(f3));
            this.O00000Oo.add(Float.valueOf(f4));
        }

        public final void O000000o(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.f11887O000000o.add(Byte.valueOf(((z ? (char) 2 : 0) | true) | z2 ? (byte) 1 : 0));
            this.O00000Oo.add(Float.valueOf(f));
            this.O00000Oo.add(Float.valueOf(f2));
            this.O00000Oo.add(Float.valueOf(f3));
            this.O00000Oo.add(Float.valueOf(f4));
            this.O00000Oo.add(Float.valueOf(f5));
        }

        public final void O000000o() {
            this.f11887O000000o.add((byte) 8);
        }

        public final void O000000o(O000o000 o000o000) {
            Iterator<Float> it = this.O00000Oo.iterator();
            for (Byte byteValue : this.f11887O000000o) {
                byte byteValue2 = byteValue.byteValue();
                if (byteValue2 == 0) {
                    o000o000.O000000o(it.next().floatValue(), it.next().floatValue());
                } else if (byteValue2 == 1) {
                    o000o000.O00000Oo(it.next().floatValue(), it.next().floatValue());
                } else if (byteValue2 == 2) {
                    o000o000.O000000o(it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue());
                } else if (byteValue2 == 3) {
                    o000o000.O000000o(it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue());
                } else if (byteValue2 != 8) {
                    o000o000.O000000o(it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), (byteValue2 & 2) != 0, (byteValue2 & 1) != 0, it.next().floatValue(), it.next().floatValue());
                } else {
                    o000o000.O000000o();
                }
            }
        }
    }

    private O00O0o0 O000000o(O00O0Oo0 o00O0Oo0, String str) {
        O00O0o0 O000000o2;
        O00O0o0 o00O0o0 = (O00O0o0) o00O0Oo0;
        if (str.equals(o00O0o0.O0000o0o)) {
            return o00O0o0;
        }
        for (O00OO0O next : o00O0Oo0.O000000o()) {
            if (next instanceof O00O0o0) {
                O00O0o0 o00O0o02 = (O00O0o0) next;
                if (str.equals(o00O0o02.O0000o0o)) {
                    return o00O0o02;
                }
                if ((next instanceof O00O0Oo0) && (O000000o2 = O000000o((O00O0Oo0) next, str)) != null) {
                    return O000000o2;
                }
            }
        }
        return null;
    }
}

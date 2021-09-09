package _m_j;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import com.xiaomi.smarthome.svg.CSSParser;
import com.xiaomi.smarthome.svg.PreserveAspectRatio;
import com.xiaomi.smarthome.svg.SVG;
import com.xiaomi.smarthome.svg.SVGParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

public final class hyk {

    /* renamed from: O000000o  reason: collision with root package name */
    public Canvas f981O000000o;
    public float O00000Oo;
    public hyj O00000o = hyj.O00000o;
    public O0000Oo0 O00000o0;
    private SVG.O000000o O00000oO;
    private boolean O00000oo;
    private SVG O0000O0o;
    private Stack<O0000Oo0> O0000OOo;
    private Stack<Matrix> O0000Oo;
    private Stack<SVG.O00O0Oo0> O0000Oo0;
    private Stack<Canvas> O0000OoO;
    private Stack<Bitmap> O0000Ooo;

    private static int O000000o(float f) {
        int i = (int) (f * 256.0f);
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    public class O0000Oo0 implements Cloneable {

        /* renamed from: O000000o  reason: collision with root package name */
        public SVG.Style f989O000000o;
        public boolean O00000Oo;
        public Paint O00000o = new Paint();
        public boolean O00000o0;
        public Paint O00000oO;
        public SVG.O000000o O00000oo;
        public SVG.O000000o O0000O0o;
        public boolean O0000OOo;
        public boolean O0000Oo0;

        public O0000Oo0() {
            this.O00000o.setFlags(385);
            this.O00000o.setStyle(Paint.Style.FILL);
            this.O00000o.setTypeface(Typeface.DEFAULT);
            this.O00000oO = new Paint();
            this.O00000oO.setFlags(385);
            this.O00000oO.setStyle(Paint.Style.STROKE);
            this.O00000oO.setTypeface(Typeface.DEFAULT);
            this.f989O000000o = SVG.Style.O000000o();
        }

        /* access modifiers changed from: protected */
        public final Object clone() {
            try {
                O0000Oo0 o0000Oo0 = (O0000Oo0) super.clone();
                o0000Oo0.f989O000000o = (SVG.Style) this.f989O000000o.clone();
                o0000Oo0.O00000o = new Paint(this.O00000o);
                o0000Oo0.O00000oO = new Paint(this.O00000oO);
                return o0000Oo0;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    public hyk(Canvas canvas, SVG.O000000o o000000o, float f) {
        this.f981O000000o = canvas;
        this.O00000Oo = f;
        this.O00000oO = o000000o;
    }

    public final float O000000o() {
        return this.O00000o0.O00000o.getTextSize();
    }

    public final SVG.O000000o O00000Oo() {
        if (this.O00000o0.O0000O0o != null) {
            return this.O00000o0.O0000O0o;
        }
        return this.O00000o0.O00000oo;
    }

    public final void O000000o(SVG svg, PreserveAspectRatio preserveAspectRatio) {
        this.O0000O0o = svg;
        this.O00000oo = true;
        SVG.O00O00o0 o00O00o0 = svg.O00000Oo;
        if (o00O00o0 == null) {
            O000000o("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        this.O00000o0 = new O0000Oo0();
        this.O0000OOo = new Stack<>();
        O000000o(this.O00000o0, SVG.Style.O000000o());
        O0000Oo0 o0000Oo0 = this.O00000o0;
        o0000Oo0.O00000oo = this.O00000oO;
        o0000Oo0.O0000OOo = false;
        o0000Oo0.O0000Oo0 = this.O00000oo;
        this.O0000OOo.push((O0000Oo0) o0000Oo0.clone());
        this.O0000OoO = new Stack<>();
        this.O0000Ooo = new Stack<>();
        this.O0000Oo = new Stack<>();
        this.O0000Oo0 = new Stack<>();
        O00000Oo((SVG.O00OO0O) o00O00o0);
        SVG.O000000o o000000o = o00O00o0.O0000ooO;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = o00O00o0.O0000oo;
        }
        O000000o(o00O00o0, o000000o, preserveAspectRatio);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0Oo0, boolean):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo0, int]
     candidates:
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OO0O, _m_j.hyk$O0000Oo0):_m_j.hyk$O0000Oo0
      _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, com.xiaomi.smarthome.svg.SVG$O00O0o0):void
      _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, com.xiaomi.smarthome.svg.SVG$Style):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, _m_j.hyk$O00000Oo):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, com.xiaomi.smarthome.svg.SVG$O00O0o00):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, java.lang.String):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o00, android.graphics.Path):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o00, com.xiaomi.smarthome.svg.SVG$O000000o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, com.xiaomi.smarthome.svg.SVG$O00O0o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, com.xiaomi.smarthome.svg.SVG$O00OOo):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OoOO0, _m_j.hyk$O0000o00):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OoOO0, java.lang.StringBuilder):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, java.lang.String):void
      _m_j.hyk.O000000o(java.lang.String, java.lang.Object[]):void
      _m_j.hyk.O000000o(boolean, com.xiaomi.smarthome.svg.SVG$O00O000o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$Style, long):boolean
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG, com.xiaomi.smarthome.svg.PreserveAspectRatio):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0Oo0, boolean):void */
    private void O000000o(SVG.O00OO0O o00oo0o) {
        Path.FillType fillType;
        Bitmap bitmap;
        int indexOf;
        if (!(o00oo0o instanceof SVG.O000OOo0)) {
            O00000o();
            O00000Oo(o00oo0o);
            if (o00oo0o instanceof SVG.O00O00o0) {
                O000000o((SVG.O00O00o0) o00oo0o);
            } else {
                float f = 0.0f;
                if (o00oo0o instanceof SVG.O00o0) {
                    SVG.O00o0 o00o0 = (SVG.O00o0) o00oo0o;
                    O00000o0("Use render", new Object[0]);
                    if ((o00o0.O00000oo == null || !o00o0.O00000oo.O000000o()) && (o00o0.O0000O0o == null || !o00o0.O0000O0o.O000000o())) {
                        O000000o(this.O00000o0, o00o0);
                        if (O0000Ooo()) {
                            SVG.O00OO0O O00000Oo2 = o00o0.O0000oOo.O00000Oo(o00o0.f11892O000000o);
                            if (O00000Oo2 == null) {
                                O00000Oo("Use reference '%s' not found", o00o0.f11892O000000o);
                            } else {
                                if (o00o0.O00000Oo != null) {
                                    this.f981O000000o.concat(o00o0.O00000Oo);
                                }
                                Matrix matrix = new Matrix();
                                matrix.preTranslate(o00o0.O00000o != null ? o00o0.O00000o.O000000o(this) : 0.0f, o00o0.O00000oO != null ? o00o0.O00000oO.O00000Oo(this) : 0.0f);
                                this.f981O000000o.concat(matrix);
                                O00000o(o00o0);
                                boolean O0000O0o2 = O0000O0o();
                                O000000o((SVG.O00O0Oo0) o00o0);
                                if (O00000Oo2 instanceof SVG.O00O00o0) {
                                    O00000o();
                                    O000000o((SVG.O00O00o0) O00000Oo2);
                                    O00000oO();
                                } else if (O00000Oo2 instanceof SVG.O00Oo0) {
                                    SVG.O000OO00 o000oo00 = o00o0.O00000oo != null ? o00o0.O00000oo : new SVG.O000OO00(100.0f, SVG.Unit.percent);
                                    SVG.O000OO00 o000oo002 = o00o0.O0000O0o != null ? o00o0.O0000O0o : new SVG.O000OO00(100.0f, SVG.Unit.percent);
                                    O00000o();
                                    SVG.O00Oo0 o00Oo0 = (SVG.O00Oo0) O00000Oo2;
                                    O00000o0("Symbol render", new Object[0]);
                                    if ((o000oo00 == null || !o000oo00.O000000o()) && (o000oo002 == null || !o000oo002.O000000o())) {
                                        PreserveAspectRatio preserveAspectRatio = o00Oo0.O0000oo != null ? o00Oo0.O0000oo : PreserveAspectRatio.O00000oO;
                                        O000000o(this.O00000o0, o00Oo0);
                                        this.O00000o0.O00000oo = new SVG.O000000o(0.0f, 0.0f, o000oo00 != null ? o000oo00.O000000o(this) : this.O00000o0.O00000oo.O00000o0, o000oo002 != null ? o000oo002.O000000o(this) : this.O00000o0.O00000oo.O00000o);
                                        if (!this.O00000o0.f989O000000o.O0000oo0.booleanValue()) {
                                            O000000o(this.O00000o0.O00000oo.f11868O000000o, this.O00000o0.O00000oo.O00000Oo, this.O00000o0.O00000oo.O00000o0, this.O00000o0.O00000oo.O00000o);
                                        }
                                        if (o00Oo0.O0000ooO != null) {
                                            this.f981O000000o.concat(O000000o(this.O00000o0.O00000oo, o00Oo0.O0000ooO, preserveAspectRatio));
                                            this.O00000o0.O0000O0o = o00Oo0.O0000ooO;
                                        }
                                        boolean O0000O0o3 = O0000O0o();
                                        O000000o((SVG.O00O0Oo0) o00Oo0, true);
                                        if (O0000O0o3) {
                                            O00000Oo((SVG.O00O0o00) o00Oo0);
                                        }
                                        O000000o((SVG.O00O0o00) o00Oo0);
                                    }
                                    O00000oO();
                                } else {
                                    O000000o(O00000Oo2);
                                }
                                O00000oo();
                                if (O0000O0o2) {
                                    O00000Oo((SVG.O00O0o00) o00o0);
                                }
                                O000000o((SVG.O00O0o00) o00o0);
                            }
                        }
                    }
                } else if (o00oo0o instanceof SVG.O00Oo00o) {
                    SVG.O00Oo00o o00Oo00o = (SVG.O00Oo00o) o00oo0o;
                    O00000o0("Switch render", new Object[0]);
                    O000000o(this.O00000o0, o00Oo00o);
                    if (O0000Ooo()) {
                        if (o00Oo00o.O00000Oo != null) {
                            this.f981O000000o.concat(o00Oo00o.O00000Oo);
                        }
                        O00000o(o00Oo00o);
                        boolean O0000O0o4 = O0000O0o();
                        O000000o(o00Oo00o);
                        if (O0000O0o4) {
                            O00000Oo((SVG.O00O0o00) o00Oo00o);
                        }
                        O000000o((SVG.O00O0o00) o00Oo00o);
                    }
                } else if (o00oo0o instanceof SVG.O000O0OO) {
                    O000000o((SVG.O000O0OO) o00oo0o);
                } else if (o00oo0o instanceof SVG.O000O0o) {
                    SVG.O000O0o o000O0o = (SVG.O000O0o) o00oo0o;
                    O00000o0("Image render", new Object[0]);
                    if (!(o000O0o.O00000o == null || o000O0o.O00000o.O000000o() || o000O0o.O00000oO == null || o000O0o.O00000oO.O000000o() || o000O0o.f11876O000000o == null)) {
                        PreserveAspectRatio preserveAspectRatio2 = o000O0o.O0000oo != null ? o000O0o.O0000oo : PreserveAspectRatio.O00000oO;
                        String str = o000O0o.f11876O000000o;
                        if (str.startsWith("data:") && str.length() >= 14 && (indexOf = str.indexOf(44)) != -1 && indexOf >= 12 && ";base64".equals(str.substring(indexOf - 7, indexOf))) {
                            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
                            bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                        } else {
                            bitmap = null;
                        }
                        if (bitmap == null) {
                            if (this.O0000O0o.O00000o0 != null) {
                                bitmap = null;
                            }
                        }
                        if (bitmap == null) {
                            O00000Oo("Could not locate image '%s'", o000O0o.f11876O000000o);
                        } else {
                            O000000o(this.O00000o0, o000O0o);
                            if (O0000Ooo() && O00000o0()) {
                                if (o000O0o.O00000oo != null) {
                                    this.f981O000000o.concat(o000O0o.O00000oo);
                                }
                                this.O00000o0.O00000oo = new SVG.O000000o(o000O0o.O00000Oo != null ? o000O0o.O00000Oo.O000000o(this) : 0.0f, o000O0o.O00000o0 != null ? o000O0o.O00000o0.O00000Oo(this) : 0.0f, o000O0o.O00000o.O000000o(this), o000O0o.O00000oO.O000000o(this));
                                if (!this.O00000o0.f989O000000o.O0000oo0.booleanValue()) {
                                    O000000o(this.O00000o0.O00000oo.f11868O000000o, this.O00000o0.O00000oo.O00000Oo, this.O00000o0.O00000oo.O00000o0, this.O00000o0.O00000oo.O00000o);
                                }
                                o000O0o.O0000o0O = new SVG.O000000o(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
                                this.f981O000000o.concat(O000000o(this.O00000o0.O00000oo, o000O0o.O0000o0O, preserveAspectRatio2));
                                O000000o((SVG.O00O0o00) o000O0o);
                                O00000o(o000O0o);
                                boolean O0000O0o5 = O0000O0o();
                                O0000o00();
                                this.f981O000000o.drawBitmap(bitmap, 0.0f, 0.0f, this.O00000o0.O00000o);
                                if (O0000O0o5) {
                                    O00000Oo((SVG.O00O0o00) o000O0o);
                                }
                            }
                        }
                    }
                } else if (o00oo0o instanceof SVG.O000Oo0) {
                    SVG.O000Oo0 o000Oo0 = (SVG.O000Oo0) o00oo0o;
                    O00000o0("Path render", new Object[0]);
                    O000000o(this.O00000o0, o000Oo0);
                    if (O0000Ooo() && O00000o0() && (this.O00000o0.O00000o0 || this.O00000o0.O00000Oo)) {
                        if (o000Oo0.O00000oO != null) {
                            this.f981O000000o.concat(o000Oo0.O00000oO);
                        }
                        Path path = new O00000o0(o000Oo0.f11882O000000o).f986O000000o;
                        if (o000Oo0.O0000o0O == null) {
                            o000Oo0.O0000o0O = O00000Oo(path);
                        }
                        O000000o((SVG.O00O0o00) o000Oo0);
                        O00000o0((SVG.O00O0o00) o000Oo0);
                        O00000o(o000Oo0);
                        boolean O0000O0o6 = O0000O0o();
                        if (this.O00000o0.O00000Oo) {
                            if (this.O00000o0.f989O000000o.O00000o0 == null || AnonymousClass1.O00000o[this.O00000o0.f989O000000o.O00000o0.ordinal()] != 1) {
                                fillType = Path.FillType.WINDING;
                            } else {
                                fillType = Path.FillType.EVEN_ODD;
                            }
                            path.setFillType(fillType);
                            O000000o(o000Oo0, path);
                        }
                        if (this.O00000o0.O00000o0) {
                            O000000o(path);
                        }
                        O000000o((SVG.O000O00o) o000Oo0);
                        if (O0000O0o6) {
                            O00000Oo((SVG.O00O0o00) o000Oo0);
                        }
                    }
                } else if (o00oo0o instanceof SVG.oooOoO) {
                    SVG.oooOoO oooooo = (SVG.oooOoO) o00oo0o;
                    O00000o0("Rect render", new Object[0]);
                    if (oooooo.O00000o0 != null && oooooo.O00000o != null && !oooooo.O00000o0.O000000o() && !oooooo.O00000o.O000000o()) {
                        O000000o(this.O00000o0, oooooo);
                        if (O0000Ooo() && O00000o0()) {
                            if (oooooo.O00000oO != null) {
                                this.f981O000000o.concat(oooooo.O00000oO);
                            }
                            Path O000000o2 = O000000o(oooooo);
                            O000000o((SVG.O00O0o00) oooooo);
                            O00000o0((SVG.O00O0o00) oooooo);
                            O00000o(oooooo);
                            boolean O0000O0o7 = O0000O0o();
                            if (this.O00000o0.O00000Oo) {
                                O000000o(oooooo, O000000o2);
                            }
                            if (this.O00000o0.O00000o0) {
                                O000000o(O000000o2);
                            }
                            if (O0000O0o7) {
                                O00000Oo((SVG.O00O0o00) oooooo);
                            }
                        }
                    }
                } else if (o00oo0o instanceof SVG.O00000o0) {
                    SVG.O00000o0 o00000o0 = (SVG.O00000o0) o00oo0o;
                    O00000o0("Circle render", new Object[0]);
                    if (o00000o0.O00000o0 != null && !o00000o0.O00000o0.O000000o()) {
                        O000000o(this.O00000o0, o00000o0);
                        if (O0000Ooo() && O00000o0()) {
                            if (o00000o0.O00000oO != null) {
                                this.f981O000000o.concat(o00000o0.O00000oO);
                            }
                            Path O000000o3 = O000000o(o00000o0);
                            O000000o((SVG.O00O0o00) o00000o0);
                            O00000o0((SVG.O00O0o00) o00000o0);
                            O00000o(o00000o0);
                            boolean O0000O0o8 = O0000O0o();
                            if (this.O00000o0.O00000Oo) {
                                O000000o(o00000o0, O000000o3);
                            }
                            if (this.O00000o0.O00000o0) {
                                O000000o(O000000o3);
                            }
                            if (O0000O0o8) {
                                O00000Oo((SVG.O00O0o00) o00000o0);
                            }
                        }
                    }
                } else if (o00oo0o instanceof SVG.O0000Oo) {
                    SVG.O0000Oo o0000Oo = (SVG.O0000Oo) o00oo0o;
                    O00000o0("Ellipse render", new Object[0]);
                    if (o0000Oo.O00000o0 != null && o0000Oo.O00000o != null && !o0000Oo.O00000o0.O000000o() && !o0000Oo.O00000o.O000000o()) {
                        O000000o(this.O00000o0, o0000Oo);
                        if (O0000Ooo() && O00000o0()) {
                            if (o0000Oo.O00000oO != null) {
                                this.f981O000000o.concat(o0000Oo.O00000oO);
                            }
                            Path O000000o4 = O000000o(o0000Oo);
                            O000000o((SVG.O00O0o00) o0000Oo);
                            O00000o0((SVG.O00O0o00) o0000Oo);
                            O00000o(o0000Oo);
                            boolean O0000O0o9 = O0000O0o();
                            if (this.O00000o0.O00000Oo) {
                                O000000o(o0000Oo, O000000o4);
                            }
                            if (this.O00000o0.O00000o0) {
                                O000000o(O000000o4);
                            }
                            if (O0000O0o9) {
                                O00000Oo((SVG.O00O0o00) o0000Oo);
                            }
                        }
                    }
                } else if (o00oo0o instanceof SVG.O000OO0o) {
                    SVG.O000OO0o o000OO0o = (SVG.O000OO0o) o00oo0o;
                    O00000o0("Line render", new Object[0]);
                    O000000o(this.O00000o0, o000OO0o);
                    if (O0000Ooo() && O00000o0() && this.O00000o0.O00000o0) {
                        if (o000OO0o.O00000oO != null) {
                            this.f981O000000o.concat(o000OO0o.O00000oO);
                        }
                        float O00000o02 = o000OO0o.f11879O000000o == null ? 0.0f : o000OO0o.f11879O000000o.O00000o0(this);
                        float O00000o03 = o000OO0o.O00000Oo == null ? 0.0f : o000OO0o.O00000Oo.O00000o0(this);
                        float O00000o04 = o000OO0o.O00000o0 == null ? 0.0f : o000OO0o.O00000o0.O00000o0(this);
                        if (o000OO0o.O00000o != null) {
                            f = o000OO0o.O00000o.O00000o0(this);
                        }
                        if (o000OO0o.O0000o0O == null) {
                            o000OO0o.O0000o0O = new SVG.O000000o(Math.min(O00000o02, O00000o03), Math.min(O00000o03, f), Math.abs(O00000o04 - O00000o02), Math.abs(f - O00000o03));
                        }
                        Path path2 = new Path();
                        path2.moveTo(O00000o02, O00000o03);
                        path2.lineTo(O00000o04, f);
                        O000000o((SVG.O00O0o00) o000OO0o);
                        O00000o0((SVG.O00O0o00) o000OO0o);
                        O00000o(o000OO0o);
                        boolean O0000O0o10 = O0000O0o();
                        O000000o(path2);
                        O000000o((SVG.O000O00o) o000OO0o);
                        if (O0000O0o10) {
                            O00000Oo((SVG.O00O0o00) o000OO0o);
                        }
                    }
                } else if (o00oo0o instanceof SVG.O000o) {
                    SVG.O000o o000o = (SVG.O000o) o00oo0o;
                    O00000o0("Polygon render", new Object[0]);
                    O000000o(this.O00000o0, o000o);
                    if (O0000Ooo() && O00000o0() && (this.O00000o0.O00000o0 || this.O00000o0.O00000Oo)) {
                        if (o000o.O00000oO != null) {
                            this.f981O000000o.concat(o000o.O00000oO);
                        }
                        if (o000o.f11883O000000o.length >= 2) {
                            Path O00000Oo3 = O00000Oo((SVG.O000o0) o000o);
                            O000000o((SVG.O00O0o00) o000o);
                            O00000o0((SVG.O00O0o00) o000o);
                            O00000o(o000o);
                            boolean O0000O0o11 = O0000O0o();
                            if (this.O00000o0.O00000Oo) {
                                O000000o(o000o, O00000Oo3);
                            }
                            if (this.O00000o0.O00000o0) {
                                O000000o(O00000Oo3);
                            }
                            O000000o((SVG.O000O00o) o000o);
                            if (O0000O0o11) {
                                O00000Oo((SVG.O00O0o00) o000o);
                            }
                        }
                    }
                } else if (o00oo0o instanceof SVG.O000o0) {
                    SVG.O000o0 o000o0 = (SVG.O000o0) o00oo0o;
                    O00000o0("PolyLine render", new Object[0]);
                    O000000o(this.O00000o0, o000o0);
                    if (O0000Ooo() && O00000o0() && (this.O00000o0.O00000o0 || this.O00000o0.O00000Oo)) {
                        if (o000o0.O00000oO != null) {
                            this.f981O000000o.concat(o000o0.O00000oO);
                        }
                        if (o000o0.f11883O000000o.length >= 2) {
                            Path O00000Oo4 = O00000Oo(o000o0);
                            O000000o((SVG.O00O0o00) o000o0);
                            O00000o0((SVG.O00O0o00) o000o0);
                            O00000o(o000o0);
                            boolean O0000O0o12 = O0000O0o();
                            if (this.O00000o0.O00000Oo) {
                                O000000o(o000o0, O00000Oo4);
                            }
                            if (this.O00000o0.O00000o0) {
                                O000000o(O00000Oo4);
                            }
                            O000000o((SVG.O000O00o) o000o0);
                            if (O0000O0o12) {
                                O00000Oo((SVG.O00O0o00) o000o0);
                            }
                        }
                    }
                } else if (o00oo0o instanceof SVG.O00Oo) {
                    SVG.O00Oo o00Oo = (SVG.O00Oo) o00oo0o;
                    O00000o0("Text render", new Object[0]);
                    O000000o(this.O00000o0, o00Oo);
                    if (O0000Ooo()) {
                        if (o00Oo.f11888O000000o != null) {
                            this.f981O000000o.concat(o00Oo.f11888O000000o);
                        }
                        float O000000o5 = (o00Oo.O00000Oo == null || o00Oo.O00000Oo.size() == 0) ? 0.0f : ((SVG.O000OO00) o00Oo.O00000Oo.get(0)).O000000o(this);
                        float O00000Oo5 = (o00Oo.O00000o0 == null || o00Oo.O00000o0.size() == 0) ? 0.0f : ((SVG.O000OO00) o00Oo.O00000o0.get(0)).O00000Oo(this);
                        float O000000o6 = (o00Oo.O00000o == null || o00Oo.O00000o.size() == 0) ? 0.0f : ((SVG.O000OO00) o00Oo.O00000o.get(0)).O000000o(this);
                        if (!(o00Oo.O00000oO == null || o00Oo.O00000oO.size() == 0)) {
                            f = ((SVG.O000OO00) o00Oo.O00000oO.get(0)).O00000Oo(this);
                        }
                        SVG.Style.TextAnchor O0000OoO2 = O0000OoO();
                        if (O0000OoO2 != SVG.Style.TextAnchor.Start) {
                            float O000000o7 = O000000o((SVG.O00OoOO0) o00Oo);
                            if (O0000OoO2 == SVG.Style.TextAnchor.Middle) {
                                O000000o7 /= 2.0f;
                            }
                            O000000o5 -= O000000o7;
                        }
                        if (o00Oo.O0000o0O == null) {
                            O0000Oo o0000Oo2 = new O0000Oo(O000000o5, O00000Oo5);
                            O000000o(o00Oo, o0000Oo2);
                            o00Oo.O0000o0O = new SVG.O000000o(o0000Oo2.O00000o0.left, o0000Oo2.O00000o0.top, o0000Oo2.O00000o0.width(), o0000Oo2.O00000o0.height());
                        }
                        O000000o((SVG.O00O0o00) o00Oo);
                        O00000o0((SVG.O00O0o00) o00Oo);
                        O00000o(o00Oo);
                        boolean O0000O0o13 = O0000O0o();
                        O000000o(o00Oo, new O0000O0o(O000000o5 + O000000o6, O00000Oo5 + f));
                        if (O0000O0o13) {
                            O00000Oo((SVG.O00O0o00) o00Oo);
                        }
                    }
                }
            }
            O00000oO();
        }
    }

    private void O000000o(SVG.O00O0Oo0 o00O0Oo0, boolean z) {
        if (z) {
            O000000o(o00O0Oo0);
        }
        for (SVG.O00OO0O O000000o2 : o00O0Oo0.O000000o()) {
            O000000o(O000000o2);
        }
        if (z) {
            O00000oo();
        }
    }

    private void O00000o() {
        this.f981O000000o.save();
        this.O0000OOo.push(this.O00000o0);
        this.O00000o0 = (O0000Oo0) this.O00000o0.clone();
    }

    private void O00000oO() {
        this.f981O000000o.restore();
        this.O00000o0 = this.O0000OOo.pop();
    }

    private void O000000o(SVG.O00O0Oo0 o00O0Oo0) {
        this.O0000Oo0.push(o00O0Oo0);
        this.O0000Oo.push(this.f981O000000o.getMatrix());
    }

    private void O00000oo() {
        this.O0000Oo0.pop();
        this.O0000Oo.pop();
    }

    private void O000000o(O0000Oo0 o0000Oo0, SVG.O00O0o0 o00O0o0) {
        o0000Oo0.f989O000000o.O000000o(o00O0o0.O0000oo0 == null);
        if (o00O0o0.O0000oO0 != null) {
            O000000o(o0000Oo0, o00O0o0.O0000oO0);
        }
        if (this.O0000O0o.O00000o0()) {
            for (CSSParser.O00000o0 next : this.O0000O0o.O00000oo.f11861O000000o) {
                if (CSSParser.O000000o(next.f11862O000000o, o00O0o0)) {
                    O000000o(o0000Oo0, next.O00000Oo);
                }
            }
        }
        if (o00O0o0.O0000oO != null) {
            O000000o(o0000Oo0, o00O0o0.O0000oO);
        }
    }

    private void O00000Oo(SVG.O00OO0O o00oo0o) {
        if (o00oo0o instanceof SVG.O00O0o0) {
            SVG.O00O0o0 o00O0o0 = (SVG.O00O0o0) o00oo0o;
            if (o00O0o0.O0000o != null) {
                this.O00000o0.O0000OOo = o00O0o0.O0000o.booleanValue();
            }
        }
    }

    private void O000000o(SVG.O00O0o00 o00O0o00, Path path) {
        if (this.O00000o0.f989O000000o.O00000Oo instanceof SVG.O000OOo) {
            SVG.O00OO0O O00000Oo2 = this.O0000O0o.O00000Oo(((SVG.O000OOo) this.O00000o0.f989O000000o.O00000Oo).f11881O000000o);
            if (O00000Oo2 instanceof SVG.O000o00) {
                O000000o(o00O0o00, path, (SVG.O000o00) O00000Oo2);
                return;
            }
        }
        this.f981O000000o.drawPath(path, this.O00000o0.O00000o);
    }

    private void O000000o(Path path) {
        if (this.O00000o0.f989O000000o.O000OO == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.f981O000000o.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.f981O000000o.setMatrix(new Matrix());
            Shader shader = this.O00000o0.O00000oO.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.f981O000000o.drawPath(path2, this.O00000o0.O00000oO);
            this.f981O000000o.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.f981O000000o.drawPath(path, this.O00000o0.O00000oO);
    }

    public static void O000000o(String str, Object... objArr) {
        gsy.O000000o(5, "SVGAndroidRenderer", String.format(str, objArr));
    }

    public static void O00000Oo(String str, Object... objArr) {
        gsy.O000000o(6, "SVGAndroidRenderer", String.format(str, objArr));
    }

    public static void O00000o0(String str, Object... objArr) {
        gsy.O000000o(3, "SVGAndroidRenderer", String.format(str, objArr));
    }

    private void O000000o(SVG.O00O00o0 o00O00o0) {
        O000000o(o00O00o0, o00O00o0.O0000ooO, o00O00o0.O0000oo);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0Oo0, boolean):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00O00o0, int]
     candidates:
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OO0O, _m_j.hyk$O0000Oo0):_m_j.hyk$O0000Oo0
      _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, com.xiaomi.smarthome.svg.SVG$O00O0o0):void
      _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, com.xiaomi.smarthome.svg.SVG$Style):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, _m_j.hyk$O00000Oo):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, com.xiaomi.smarthome.svg.SVG$O00O0o00):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, java.lang.String):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o00, android.graphics.Path):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o00, com.xiaomi.smarthome.svg.SVG$O000000o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, com.xiaomi.smarthome.svg.SVG$O00O0o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, com.xiaomi.smarthome.svg.SVG$O00OOo):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OoOO0, _m_j.hyk$O0000o00):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OoOO0, java.lang.StringBuilder):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, java.lang.String):void
      _m_j.hyk.O000000o(java.lang.String, java.lang.Object[]):void
      _m_j.hyk.O000000o(boolean, com.xiaomi.smarthome.svg.SVG$O00O000o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$Style, long):boolean
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG, com.xiaomi.smarthome.svg.PreserveAspectRatio):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0Oo0, boolean):void */
    private void O000000o(SVG.O00O00o0 o00O00o0, SVG.O000000o o000000o, PreserveAspectRatio preserveAspectRatio) {
        O00000o0("Svg render", new Object[0]);
        if (preserveAspectRatio == null) {
            preserveAspectRatio = o00O00o0.O0000oo != null ? o00O00o0.O0000oo : PreserveAspectRatio.O00000oO;
        }
        O000000o(this.O00000o0, o00O00o0);
        if (O0000Ooo()) {
            if (!this.O00000o0.f989O000000o.O0000oo0.booleanValue()) {
                O000000o(this.O00000o0.O00000oo.f11868O000000o, this.O00000o0.O00000oo.O00000Oo, this.O00000o0.O00000oo.O00000o0, this.O00000o0.O00000oo.O00000o);
            }
            O000000o(o00O00o0, this.O00000o0.O00000oo);
            if (o000000o != null) {
                this.f981O000000o.concat(O000000o(this.O00000o0.O00000oo, o000000o, preserveAspectRatio));
                this.O00000o0.O0000O0o = o00O00o0.O0000ooO;
            }
            boolean O0000O0o2 = O0000O0o();
            O0000o00();
            O000000o((SVG.O00O0Oo0) o00O00o0, true);
            if (O0000O0o2) {
                O00000Oo((SVG.O00O0o00) o00O00o0);
            }
            O000000o((SVG.O00O0o00) o00O00o0);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0Oo0, boolean):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000O0OO, int]
     candidates:
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OO0O, _m_j.hyk$O0000Oo0):_m_j.hyk$O0000Oo0
      _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, com.xiaomi.smarthome.svg.SVG$O00O0o0):void
      _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, com.xiaomi.smarthome.svg.SVG$Style):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, _m_j.hyk$O00000Oo):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, com.xiaomi.smarthome.svg.SVG$O00O0o00):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, java.lang.String):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o00, android.graphics.Path):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o00, com.xiaomi.smarthome.svg.SVG$O000000o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, com.xiaomi.smarthome.svg.SVG$O00O0o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, com.xiaomi.smarthome.svg.SVG$O00OOo):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OoOO0, _m_j.hyk$O0000o00):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OoOO0, java.lang.StringBuilder):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, java.lang.String):void
      _m_j.hyk.O000000o(java.lang.String, java.lang.Object[]):void
      _m_j.hyk.O000000o(boolean, com.xiaomi.smarthome.svg.SVG$O00O000o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$Style, long):boolean
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG, com.xiaomi.smarthome.svg.PreserveAspectRatio):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0Oo0, boolean):void */
    private void O000000o(SVG.O000O0OO o000o0oo) {
        float[] fArr;
        O00000o0("Group render", new Object[0]);
        O000000o(this.O00000o0, o000o0oo);
        if (O0000Ooo()) {
            if (o000o0oo.O00000Oo != null) {
                this.f981O000000o.concat(o000o0oo.O00000Oo);
            }
            if (o000o0oo.O00000o0 != null) {
                SVG.O00OO0O O00000Oo2 = o000o0oo.O0000oOo.O00000Oo(o000o0oo.O00000o0);
                if (O00000Oo2 instanceof SVG.O0000o0) {
                    for (SVG.O00OO0O next : ((SVG.O0000o0) O00000Oo2).O0000Oo0) {
                        if ((next instanceof SVG.O0000o00) && (fArr = ((SVG.O0000o00) next).f11875O000000o) != null && fArr.length >= 20) {
                            fArr[4] = fArr[4] * 255.0f;
                            fArr[9] = fArr[9] * 255.0f;
                            fArr[14] = fArr[14] * 255.0f;
                            this.O00000o0.O00000o.setColorFilter(new ColorMatrixColorFilter(fArr));
                            this.O00000o0.O00000oO.setColorFilter(new ColorMatrixColorFilter(fArr));
                        }
                    }
                }
            }
            O00000o(o000o0oo);
            boolean O0000O0o2 = O0000O0o();
            O000000o((SVG.O00O0Oo0) o000o0oo, true);
            if (O0000O0o2) {
                O00000Oo((SVG.O00O0o00) o000o0oo);
            }
            O000000o((SVG.O00O0o00) o000o0oo);
            this.O00000o0.O00000o.setColorFilter(null);
            this.O00000o0.O00000oO.setColorFilter(null);
        }
    }

    private void O000000o(SVG.O00O0o00 o00O0o00) {
        if (o00O0o00.O0000oo0 != null && o00O0o00.O0000o0O != null) {
            Matrix matrix = new Matrix();
            if (this.O0000Oo.peek().invert(matrix)) {
                float[] fArr = {o00O0o00.O0000o0O.f11868O000000o, o00O0o00.O0000o0O.O00000Oo, o00O0o00.O0000o0O.O000000o(), o00O0o00.O0000o0O.O00000Oo, o00O0o00.O0000o0O.O000000o(), o00O0o00.O0000o0O.O00000Oo(), o00O0o00.O0000o0O.f11868O000000o, o00O0o00.O0000o0O.O00000Oo()};
                matrix.preConcat(this.f981O000000o.getMatrix());
                matrix.mapPoints(fArr);
                RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                for (int i = 2; i <= 6; i += 2) {
                    if (fArr[i] < rectF.left) {
                        rectF.left = fArr[i];
                    }
                    if (fArr[i] > rectF.right) {
                        rectF.right = fArr[i];
                    }
                    int i2 = i + 1;
                    if (fArr[i2] < rectF.top) {
                        rectF.top = fArr[i2];
                    }
                    if (fArr[i2] > rectF.bottom) {
                        rectF.bottom = fArr[i2];
                    }
                }
                SVG.O00O0o00 o00O0o002 = (SVG.O00O0o00) this.O0000Oo0.peek();
                if (o00O0o002.O0000o0O == null) {
                    o00O0o002.O0000o0O = SVG.O000000o.O000000o(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    o00O0o002.O0000o0O.O000000o(SVG.O000000o.O000000o(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    private boolean O0000O0o() {
        if (!O0000OOo()) {
            return false;
        }
        this.f981O000000o.saveLayerAlpha(null, O000000o(this.O00000o0.f989O000000o.O0000o00.floatValue()), 31);
        this.O0000OOo.push(this.O00000o0);
        this.O00000o0 = (O0000Oo0) this.O00000o0.clone();
        if (this.O00000o0.f989O000000o.O000O0o != null && this.O00000o0.O0000Oo0) {
            if (!(this.O0000O0o.O00000Oo(this.O00000o0.f989O000000o.O000O0o) instanceof SVG.O000OOOo)) {
                O00000Oo("Mask reference '%s' not found", this.O00000o0.f989O000000o.O000O0o);
                this.O00000o0.f989O000000o.O000O0o = null;
                return true;
            }
            this.O0000OoO.push(this.f981O000000o);
            O0000Oo0();
        }
        return true;
    }

    private void O00000Oo(SVG.O00O0o00 o00O0o00) {
        if (this.O00000o0.f989O000000o.O000O0o != null && this.O00000o0.O0000Oo0) {
            SVG.O00OO0O O00000Oo2 = this.O0000O0o.O00000Oo(this.O00000o0.f989O000000o.O000O0o);
            O0000Oo0();
            O000000o((SVG.O000OOOo) O00000Oo2, o00O0o00);
            Bitmap O0000Oo2 = O0000Oo();
            this.f981O000000o = this.O0000OoO.pop();
            this.f981O000000o.save();
            this.f981O000000o.setMatrix(new Matrix());
            this.f981O000000o.drawBitmap(O0000Oo2, 0.0f, 0.0f, this.O00000o0.O00000o);
            O0000Oo2.recycle();
            this.f981O000000o.restore();
        }
        O00000oO();
    }

    private boolean O0000OOo() {
        if (this.O00000o0.f989O000000o.O000O0o != null && !this.O00000o0.O0000Oo0) {
            O000000o("Masks are not supported when using getPicture()", new Object[0]);
        }
        if (this.O00000o0.f989O000000o.O0000o00.floatValue() < 1.0f) {
            return true;
        }
        if (this.O00000o0.f989O000000o.O000O0o == null || !this.O00000o0.O0000Oo0) {
            return false;
        }
        return true;
    }

    private void O0000Oo0() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f981O000000o.getWidth(), this.f981O000000o.getHeight(), Bitmap.Config.ARGB_8888);
            this.O0000Ooo.push(createBitmap);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setMatrix(this.f981O000000o.getMatrix());
            this.f981O000000o = canvas;
        } catch (OutOfMemoryError e) {
            O00000Oo("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e;
        }
    }

    private Bitmap O0000Oo() {
        Bitmap pop = this.O0000Ooo.pop();
        Bitmap pop2 = this.O0000Ooo.pop();
        int width = pop.getWidth();
        int height = pop.getHeight();
        int[] iArr = new int[width];
        int[] iArr2 = new int[width];
        int i = 0;
        while (i < height) {
            pop.getPixels(iArr, 0, width, 0, i, width, 1);
            int i2 = i;
            pop2.getPixels(iArr2, 0, width, 0, i, width, 1);
            for (int i3 = 0; i3 < width; i3++) {
                int i4 = iArr[i3];
                int i5 = i4 & 255;
                int i6 = (i4 >> 8) & 255;
                int i7 = (i4 >> 16) & 255;
                int i8 = (i4 >> 24) & 255;
                if (i8 == 0) {
                    iArr2[i3] = 0;
                } else {
                    int i9 = iArr2[i3];
                    iArr2[i3] = (i9 & 16777215) | (((((i9 >> 24) & 255) * (((((i7 * 6963) + (i6 * 23442)) + (i5 * 2362)) * i8) / 8355840)) / 255) << 24);
                }
            }
            pop2.setPixels(iArr2, 0, width, 0, i2, width, 1);
            i = i2 + 1;
        }
        pop.recycle();
        return pop2;
    }

    private void O000000o(SVG.O00Oo00o o00Oo00o) {
        Set<String> O00000o2;
        String language = Locale.getDefault().getLanguage();
        hyl hyl = this.O0000O0o.O00000o0;
        for (SVG.O00OO0O next : o00Oo00o.O0000Oo0) {
            if (next instanceof SVG.O00O00o) {
                SVG.O00O00o o00O00o = (SVG.O00O00o) next;
                if (o00O00o.O00000o0() == null && ((O00000o2 = o00O00o.O00000o()) == null || (!O00000o2.isEmpty() && O00000o2.contains(language)))) {
                    Set<String> O00000Oo2 = o00O00o.O00000Oo();
                    if (O00000Oo2 == null || (!O00000Oo2.isEmpty() && SVGParser.f11898O000000o.containsAll(O00000Oo2))) {
                        Set<String> O00000oO2 = o00O00o.O00000oO();
                        if (O00000oO2 != null) {
                            if (!O00000oO2.isEmpty() && hyl != null) {
                                Iterator<String> it = O00000oO2.iterator();
                                if (it.hasNext()) {
                                    it.next();
                                }
                            }
                        }
                        Set<String> O00000oo2 = o00O00o.O00000oo();
                        if (O00000oo2 != null) {
                            if (!O00000oo2.isEmpty() && hyl != null) {
                                Iterator<String> it2 = O00000oo2.iterator();
                                if (it2.hasNext()) {
                                    it2.next();
                                    this.O00000o0.f989O000000o.O0000o.intValue();
                                    String.valueOf(this.O00000o0.f989O000000o.O0000oO0);
                                }
                            }
                        }
                        O000000o(next);
                        return;
                    }
                }
            }
        }
    }

    private static SVG.O000000o O00000Oo(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.O000000o(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private List<O00000Oo> O000000o(SVG.O000o0 o000o0) {
        SVG.O000o0 o000o02 = o000o0;
        int length = o000o02.f11883O000000o.length;
        int i = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        O00000Oo o00000Oo = new O00000Oo(o000o02.f11883O000000o[0], o000o02.f11883O000000o[1], 0.0f, 0.0f);
        float f = 0.0f;
        float f2 = 0.0f;
        while (i < length) {
            f = o000o02.f11883O000000o[i];
            f2 = o000o02.f11883O000000o[i + 1];
            o00000Oo.O000000o(f, f2);
            arrayList.add(o00000Oo);
            i += 2;
            o00000Oo = new O00000Oo(f, f2, f - o00000Oo.f984O000000o, f2 - o00000Oo.O00000Oo);
        }
        if (!(o000o02 instanceof SVG.O000o)) {
            arrayList.add(o00000Oo);
        } else if (!(f == o000o02.f11883O000000o[0] || f2 == o000o02.f11883O000000o[1])) {
            float f3 = o000o02.f11883O000000o[0];
            float f4 = o000o02.f11883O000000o[1];
            o00000Oo.O000000o(f3, f4);
            arrayList.add(o00000Oo);
            O00000Oo o00000Oo2 = new O00000Oo(f3, f4, f3 - o00000Oo.f984O000000o, f4 - o00000Oo.O00000Oo);
            o00000Oo2.O000000o((O00000Oo) arrayList.get(0));
            arrayList.add(o00000Oo2);
            arrayList.set(0, o00000Oo2);
        }
        return arrayList;
    }

    private SVG.Style.TextAnchor O0000OoO() {
        if (this.O00000o0.f989O000000o.O0000oOO == SVG.Style.TextDirection.LTR || this.O00000o0.f989O000000o.O0000oOo == SVG.Style.TextAnchor.Middle) {
            return this.O00000o0.f989O000000o.O0000oOo;
        }
        return this.O00000o0.f989O000000o.O0000oOo == SVG.Style.TextAnchor.Start ? SVG.Style.TextAnchor.End : SVG.Style.TextAnchor.Start;
    }

    class O0000O0o extends O0000o00 {
        public float O00000Oo;
        public float O00000o0;

        public O0000O0o(float f, float f2) {
            super(hyk.this, (byte) 0);
            this.O00000Oo = f;
            this.O00000o0 = f2;
        }

        public void O000000o(String str) {
            hyk.O00000o0("TextSequence render", new Object[0]);
            if (hyk.this.O00000o0()) {
                if (hyk.this.O00000o0.O00000Oo) {
                    hyk.this.f981O000000o.drawText(str, this.O00000Oo, this.O00000o0, hyk.this.O00000o0.O00000o);
                }
                if (hyk.this.O00000o0.O00000o0) {
                    hyk.this.f981O000000o.drawText(str, this.O00000Oo, this.O00000o0, hyk.this.O00000o0.O00000oO);
                }
            }
            this.O00000Oo += hyk.this.O00000o0.O00000o.measureText(str);
        }
    }

    abstract class O0000o00 {
        public abstract void O000000o(String str);

        public boolean O000000o(SVG.O00OoOO0 o00OoOO0) {
            return true;
        }

        private O0000o00() {
        }

        /* synthetic */ O0000o00(hyk hyk, byte b) {
            this();
        }
    }

    private void O000000o(SVG.O00OoOO0 o00OoOO0, O0000o00 o0000o00) {
        float f;
        float f2;
        float f3;
        if (O0000Ooo()) {
            Iterator it = o00OoOO0.O0000Oo0.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.O00OO0O o00oo0o = (SVG.O00OO0O) it.next();
                if (o00oo0o instanceof SVG.O00o00) {
                    o0000o00.O000000o(O000000o(((SVG.O00o00) o00oo0o).f11893O000000o, z, !it.hasNext()));
                } else if (o0000o00.O000000o((SVG.O00OoOO0) o00oo0o)) {
                    float f4 = 0.0f;
                    if (o00oo0o instanceof SVG.O00Ooo00) {
                        O00000o();
                        SVG.O00Ooo00 o00Ooo00 = (SVG.O00Ooo00) o00oo0o;
                        O00000o0("TextPath render", new Object[0]);
                        O000000o(this.O00000o0, o00Ooo00);
                        if (O0000Ooo() && O00000o0()) {
                            SVG.O00OO0O O00000Oo2 = o00Ooo00.O0000oOo.O00000Oo(o00Ooo00.f11891O000000o);
                            if (O00000Oo2 == null) {
                                O00000Oo("TextPath reference '%s' not found", o00Ooo00.f11891O000000o);
                            } else {
                                SVG.O000Oo0 o000Oo0 = (SVG.O000Oo0) O00000Oo2;
                                Path path = new O00000o0(o000Oo0.f11882O000000o).f986O000000o;
                                if (o000Oo0.O00000oO != null) {
                                    path.transform(o000Oo0.O00000oO);
                                }
                                PathMeasure pathMeasure = new PathMeasure(path, false);
                                if (o00Ooo00.O00000Oo != null) {
                                    f4 = o00Ooo00.O00000Oo.O000000o(this, pathMeasure.getLength());
                                }
                                SVG.Style.TextAnchor O0000OoO2 = O0000OoO();
                                if (O0000OoO2 != SVG.Style.TextAnchor.Start) {
                                    float O000000o2 = O000000o((SVG.O00OoOO0) o00Ooo00);
                                    if (O0000OoO2 == SVG.Style.TextAnchor.Middle) {
                                        O000000o2 /= 2.0f;
                                    }
                                    f4 -= O000000o2;
                                }
                                O00000o0((SVG.O00O0o00) o00Ooo00.O00000o0);
                                boolean O0000O0o2 = O0000O0o();
                                O000000o(o00Ooo00, new O00000o(path, f4));
                                if (O0000O0o2) {
                                    O00000Oo((SVG.O00O0o00) o00Ooo00);
                                }
                            }
                        }
                    } else if (o00oo0o instanceof SVG.O00Oo0o0) {
                        O00000o0("TSpan render", new Object[0]);
                        O00000o();
                        SVG.O00Oo0o0 o00Oo0o0 = (SVG.O00Oo0o0) o00oo0o;
                        O000000o(this.O00000o0, o00Oo0o0);
                        if (O0000Ooo()) {
                            boolean z2 = o0000o00 instanceof O0000O0o;
                            if (z2) {
                                float O000000o3 = (o00Oo0o0.O00000Oo == null || o00Oo0o0.O00000Oo.size() == 0) ? ((O0000O0o) o0000o00).O00000Oo : ((SVG.O000OO00) o00Oo0o0.O00000Oo.get(0)).O000000o(this);
                                f2 = (o00Oo0o0.O00000o0 == null || o00Oo0o0.O00000o0.size() == 0) ? ((O0000O0o) o0000o00).O00000o0 : ((SVG.O000OO00) o00Oo0o0.O00000o0.get(0)).O00000Oo(this);
                                f = (o00Oo0o0.O00000o == null || o00Oo0o0.O00000o.size() == 0) ? 0.0f : ((SVG.O000OO00) o00Oo0o0.O00000o.get(0)).O000000o(this);
                                if (!(o00Oo0o0.O00000oO == null || o00Oo0o0.O00000oO.size() == 0)) {
                                    f4 = ((SVG.O000OO00) o00Oo0o0.O00000oO.get(0)).O00000Oo(this);
                                }
                                float f5 = O000000o3;
                                f3 = f4;
                                f4 = f5;
                            } else {
                                f3 = 0.0f;
                                f2 = 0.0f;
                                f = 0.0f;
                            }
                            O00000o0((SVG.O00O0o00) o00Oo0o0.f11890O000000o);
                            if (z2) {
                                O0000O0o o0000O0o = (O0000O0o) o0000o00;
                                o0000O0o.O00000Oo = f4 + f;
                                o0000O0o.O00000o0 = f2 + f3;
                            }
                            boolean O0000O0o3 = O0000O0o();
                            O000000o(o00Oo0o0, o0000o00);
                            if (O0000O0o3) {
                                O00000Oo((SVG.O00O0o00) o00Oo0o0);
                            }
                        }
                        O00000oO();
                    } else if (o00oo0o instanceof SVG.O00Oo0OO) {
                        O00000o();
                        SVG.O00Oo0OO o00Oo0OO = (SVG.O00Oo0OO) o00oo0o;
                        O000000o(this.O00000o0, o00Oo0OO);
                        if (O0000Ooo()) {
                            O00000o0((SVG.O00O0o00) o00Oo0OO.O00000Oo);
                            SVG.O00OO0O O00000Oo3 = o00oo0o.O0000oOo.O00000Oo(o00Oo0OO.f11889O000000o);
                            if (O00000Oo3 == null || !(O00000Oo3 instanceof SVG.O00OoOO0)) {
                                O00000Oo("Tref reference '%s' not found", o00Oo0OO.f11889O000000o);
                            } else {
                                StringBuilder sb = new StringBuilder();
                                O000000o((SVG.O00OoOO0) O00000Oo3, sb);
                                if (sb.length() > 0) {
                                    o0000o00.O000000o(sb.toString());
                                }
                            }
                        }
                    }
                    O00000oO();
                }
                z = false;
            }
        }
    }

    class O00000o extends O0000O0o {
        private Path O00000oo;

        public O00000o(Path path, float f) {
            super(f, 0.0f);
            this.O00000oo = path;
        }

        public final void O000000o(String str) {
            if (hyk.this.O00000o0()) {
                if (hyk.this.O00000o0.O00000Oo) {
                    hyk.this.f981O000000o.drawTextOnPath(str, this.O00000oo, this.O00000Oo, this.O00000o0, hyk.this.O00000o0.O00000o);
                }
                if (hyk.this.O00000o0.O00000o0) {
                    hyk.this.f981O000000o.drawTextOnPath(str, this.O00000oo, this.O00000Oo, this.O00000o0, hyk.this.O00000o0.O00000oO);
                }
            }
            this.O00000Oo += hyk.this.O00000o0.O00000o.measureText(str);
        }
    }

    private float O000000o(SVG.O00OoOO0 o00OoOO0) {
        O0000o0 o0000o0 = new O0000o0(this, (byte) 0);
        O000000o(o00OoOO0, o0000o0);
        return o0000o0.f990O000000o;
    }

    class O0000o0 extends O0000o00 {

        /* renamed from: O000000o  reason: collision with root package name */
        public float f990O000000o;

        private O0000o0() {
            super(hyk.this, (byte) 0);
            this.f990O000000o = 0.0f;
        }

        /* synthetic */ O0000o0(hyk hyk, byte b) {
            this();
        }

        public final void O000000o(String str) {
            this.f990O000000o += hyk.this.O00000o0.O00000o.measureText(str);
        }
    }

    class O0000Oo extends O0000o00 {

        /* renamed from: O000000o  reason: collision with root package name */
        float f988O000000o;
        float O00000Oo;
        RectF O00000o0 = new RectF();

        public O0000Oo(float f, float f2) {
            super(hyk.this, (byte) 0);
            this.f988O000000o = f;
            this.O00000Oo = f2;
        }

        public final boolean O000000o(SVG.O00OoOO0 o00OoOO0) {
            if (!(o00OoOO0 instanceof SVG.O00Ooo00)) {
                return true;
            }
            SVG.O00Ooo00 o00Ooo00 = (SVG.O00Ooo00) o00OoOO0;
            SVG.O00OO0O O00000Oo2 = o00OoOO0.O0000oOo.O00000Oo(o00Ooo00.f11891O000000o);
            if (O00000Oo2 == null) {
                hyk.O00000Oo("TextPath path reference '%s' not found", o00Ooo00.f11891O000000o);
                return false;
            }
            SVG.O000Oo0 o000Oo0 = (SVG.O000Oo0) O00000Oo2;
            Path path = new O00000o0(o000Oo0.f11882O000000o).f986O000000o;
            if (o000Oo0.O00000oO != null) {
                path.transform(o000Oo0.O00000oO);
            }
            RectF rectF = new RectF();
            path.computeBounds(rectF, true);
            this.O00000o0.union(rectF);
            return false;
        }

        public final void O000000o(String str) {
            if (hyk.this.O00000o0()) {
                Rect rect = new Rect();
                hyk.this.O00000o0.O00000o.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.f988O000000o, this.O00000Oo);
                this.O00000o0.union(rectF);
            }
            this.f988O000000o += hyk.this.O00000o0.O00000o.measureText(str);
        }
    }

    private void O000000o(SVG.O00OoOO0 o00OoOO0, StringBuilder sb) {
        Iterator it = o00OoOO0.O0000Oo0.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVG.O00OO0O o00oo0o = (SVG.O00OO0O) it.next();
            if (o00oo0o instanceof SVG.O00OoOO0) {
                O000000o((SVG.O00OoOO0) o00oo0o, sb);
            } else if (o00oo0o instanceof SVG.O00o00) {
                sb.append(O000000o(((SVG.O00o00) o00oo0o).f11893O000000o, z, !it.hasNext()));
            }
            z = false;
        }
    }

    private String O000000o(String str, boolean z, boolean z2) {
        if (this.O00000o0.O0000OOo) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z2) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    private boolean O0000Ooo() {
        if (this.O00000o0.f989O000000o.O00oOooo != null) {
            return this.O00000o0.f989O000000o.O00oOooo.booleanValue();
        }
        return true;
    }

    public final boolean O00000o0() {
        if (this.O00000o0.f989O000000o.O000O00o != null) {
            return this.O00000o0.f989O000000o.O000O00o.booleanValue();
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        if (r10 != 8) goto L_0x0088;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e  */
    private static Matrix O000000o(SVG.O000000o o000000o, SVG.O000000o o000000o2, PreserveAspectRatio preserveAspectRatio) {
        int i;
        float f;
        float f2;
        Matrix matrix = new Matrix();
        if (!(preserveAspectRatio == null || preserveAspectRatio.f11865O000000o == null)) {
            float f3 = o000000o.O00000o0 / o000000o2.O00000o0;
            float f4 = o000000o.O00000o / o000000o2.O00000o;
            float f5 = -o000000o2.f11868O000000o;
            float f6 = -o000000o2.O00000Oo;
            if (!preserveAspectRatio.equals(PreserveAspectRatio.O00000o)) {
                float max = preserveAspectRatio.O00000Oo == PreserveAspectRatio.Scale.Slice ? Math.max(f3, f4) : Math.min(f3, f4);
                float f7 = o000000o.O00000o0 / max;
                float f8 = o000000o.O00000o / max;
                switch (preserveAspectRatio.f11865O000000o) {
                    case XMidYMin:
                    case XMidYMid:
                    case XMidYMax:
                        f2 = (o000000o2.O00000o0 - f7) / 2.0f;
                        f5 -= f2;
                        i = AnonymousClass1.f982O000000o[preserveAspectRatio.f11865O000000o.ordinal()];
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 5) {
                                    if (i != 6) {
                                        if (i != 7) {
                                            break;
                                        }
                                    }
                                }
                            }
                            f = o000000o2.O00000o - f8;
                            f6 -= f;
                            matrix.preTranslate(o000000o.f11868O000000o, o000000o.O00000Oo);
                            matrix.preScale(max, max);
                            matrix.preTranslate(f5, f6);
                            break;
                        }
                        f = (o000000o2.O00000o - f8) / 2.0f;
                        f6 -= f;
                        matrix.preTranslate(o000000o.f11868O000000o, o000000o.O00000Oo);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f5, f6);
                    case XMaxYMin:
                    case XMaxYMid:
                    case XMaxYMax:
                        f2 = o000000o2.O00000o0 - f7;
                        f5 -= f2;
                        i = AnonymousClass1.f982O000000o[preserveAspectRatio.f11865O000000o.ordinal()];
                        if (i != 2) {
                        }
                        f = (o000000o2.O00000o - f8) / 2.0f;
                        f6 -= f;
                        matrix.preTranslate(o000000o.f11868O000000o, o000000o.O00000Oo);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f5, f6);
                        break;
                    default:
                        i = AnonymousClass1.f982O000000o[preserveAspectRatio.f11865O000000o.ordinal()];
                        if (i != 2) {
                        }
                        f = (o000000o2.O00000o - f8) / 2.0f;
                        f6 -= f;
                        matrix.preTranslate(o000000o.f11868O000000o, o000000o.O00000Oo);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f5, f6);
                        break;
                }
            } else {
                matrix.preTranslate(o000000o.f11868O000000o, o000000o.O00000Oo);
                matrix.preScale(f3, f4);
                matrix.preTranslate(f5, f6);
                return matrix;
            }
        }
        return matrix;
    }

    private static boolean O000000o(SVG.Style style, long j) {
        return (j & style.f11895O000000o) != 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, boolean, com.xiaomi.smarthome.svg.SVG$O00OOOo):void
     arg types: [_m_j.hyk$O0000Oo0, int, com.xiaomi.smarthome.svg.SVG$O00OOOo]
     candidates:
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.PreserveAspectRatio):android.graphics.Matrix
      _m_j.hyk.O000000o(java.lang.String, java.lang.Integer, com.xiaomi.smarthome.svg.SVG$Style$FontStyle):android.graphics.Typeface
      _m_j.hyk.O000000o(java.lang.String, boolean, boolean):java.lang.String
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000O00o, android.graphics.Path, android.graphics.Matrix):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, android.graphics.Path, android.graphics.Matrix):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o0, com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.PreserveAspectRatio):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o00, android.graphics.Path, com.xiaomi.smarthome.svg.SVG$O000o00):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo, android.graphics.Path, android.graphics.Matrix):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, android.graphics.Path, android.graphics.Matrix):void
      _m_j.hyk.O000000o(boolean, com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.SVG$O000OOo):void
      _m_j.hyk.O000000o(boolean, com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.SVG$O00O0o):void
      _m_j.hyk.O000000o(boolean, com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.SVG$O00OOo):void
      _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, boolean, com.xiaomi.smarthome.svg.SVG$O00OOOo):void */
    private void O000000o(O0000Oo0 o0000Oo0, SVG.Style style) {
        Typeface typeface;
        SVG svg;
        if (O000000o(style, 4096)) {
            o0000Oo0.f989O000000o.O0000o0 = style.O0000o0;
        }
        if (O000000o(style, 2048)) {
            o0000Oo0.f989O000000o.O0000o00 = style.O0000o00;
        }
        boolean z = false;
        if (O000000o(style, 1)) {
            o0000Oo0.f989O000000o.O00000Oo = style.O00000Oo;
            o0000Oo0.O00000Oo = style.O00000Oo != null;
        }
        if (O000000o(style, 4)) {
            o0000Oo0.f989O000000o.O00000o = style.O00000o;
        }
        if (O000000o(style, 6149)) {
            O000000o(o0000Oo0, true, o0000Oo0.f989O000000o.O00000Oo);
        }
        if (O000000o(style, 2)) {
            o0000Oo0.f989O000000o.O00000o0 = style.O00000o0;
        }
        if (O000000o(style, 8)) {
            o0000Oo0.f989O000000o.O00000oO = style.O00000oO;
            o0000Oo0.O00000o0 = style.O00000oO != null;
        }
        if (O000000o(style, 16)) {
            o0000Oo0.f989O000000o.O00000oo = style.O00000oo;
        }
        if (O000000o(style, 6168)) {
            O000000o(o0000Oo0, false, o0000Oo0.f989O000000o.O00000oO);
        }
        if (O000000o(style, 34359738368L)) {
            o0000Oo0.f989O000000o.O000OO = style.O000OO;
        }
        if (O000000o(style, 32)) {
            o0000Oo0.f989O000000o.O0000O0o = style.O0000O0o;
            o0000Oo0.O00000oO.setStrokeWidth(o0000Oo0.f989O000000o.O0000O0o.O00000o0(this));
        }
        if (O000000o(style, 64)) {
            o0000Oo0.f989O000000o.O0000OOo = style.O0000OOo;
            int i = AnonymousClass1.O00000Oo[style.O0000OOo.ordinal()];
            if (i == 1) {
                o0000Oo0.O00000oO.setStrokeCap(Paint.Cap.BUTT);
            } else if (i == 2) {
                o0000Oo0.O00000oO.setStrokeCap(Paint.Cap.ROUND);
            } else if (i == 3) {
                o0000Oo0.O00000oO.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (O000000o(style, 128)) {
            o0000Oo0.f989O000000o.O0000Oo0 = style.O0000Oo0;
            int i2 = AnonymousClass1.O00000o0[style.O0000Oo0.ordinal()];
            if (i2 == 1) {
                o0000Oo0.O00000oO.setStrokeJoin(Paint.Join.MITER);
            } else if (i2 == 2) {
                o0000Oo0.O00000oO.setStrokeJoin(Paint.Join.ROUND);
            } else if (i2 == 3) {
                o0000Oo0.O00000oO.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (O000000o(style, 256)) {
            o0000Oo0.f989O000000o.O0000Oo = style.O0000Oo;
            o0000Oo0.O00000oO.setStrokeMiter(style.O0000Oo.floatValue());
        }
        if (O000000o(style, 512)) {
            o0000Oo0.f989O000000o.O0000OoO = style.O0000OoO;
        }
        if (O000000o(style, 1024)) {
            o0000Oo0.f989O000000o.O0000Ooo = style.O0000Ooo;
        }
        if (O000000o(style, 1536)) {
            if (o0000Oo0.f989O000000o.O0000OoO == null) {
                o0000Oo0.O00000oO.setPathEffect(null);
            } else {
                int length = o0000Oo0.f989O000000o.O0000OoO.length;
                int i3 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i3];
                float f = 0.0f;
                for (int i4 = 0; i4 < i3; i4++) {
                    fArr[i4] = o0000Oo0.f989O000000o.O0000OoO[i4 % length].O00000o0(this);
                    f += fArr[i4];
                }
                if (f == 0.0f) {
                    o0000Oo0.O00000oO.setPathEffect(null);
                } else {
                    float O00000o02 = o0000Oo0.f989O000000o.O0000Ooo.O00000o0(this);
                    if (O00000o02 < 0.0f) {
                        O00000o02 = (O00000o02 % f) + f;
                    }
                    o0000Oo0.O00000oO.setPathEffect(new DashPathEffect(fArr, O00000o02));
                }
            }
        }
        if (O000000o(style, 16384)) {
            float O000000o2 = O000000o();
            o0000Oo0.f989O000000o.O0000o0o = style.O0000o0o;
            o0000Oo0.O00000o.setTextSize(style.O0000o0o.O000000o(this, O000000o2));
            o0000Oo0.O00000oO.setTextSize(style.O0000o0o.O000000o(this, O000000o2));
        }
        if (O000000o(style, 8192)) {
            o0000Oo0.f989O000000o.O0000o0O = style.O0000o0O;
        }
        if (O000000o(style, 32768)) {
            if (style.O0000o.intValue() == -1 && o0000Oo0.f989O000000o.O0000o.intValue() > 100) {
                SVG.Style style2 = o0000Oo0.f989O000000o;
                style2.O0000o = Integer.valueOf(style2.O0000o.intValue() - 100);
            } else if (style.O0000o.intValue() != 1 || o0000Oo0.f989O000000o.O0000o.intValue() >= 900) {
                o0000Oo0.f989O000000o.O0000o = style.O0000o;
            } else {
                SVG.Style style3 = o0000Oo0.f989O000000o;
                style3.O0000o = Integer.valueOf(style3.O0000o.intValue() + 100);
            }
        }
        if (O000000o(style, 65536)) {
            o0000Oo0.f989O000000o.O0000oO0 = style.O0000oO0;
        }
        if (O000000o(style, 106496)) {
            if (o0000Oo0.f989O000000o.O0000o0O != null && (svg = this.O0000O0o) != null) {
                hyl hyl = svg.O00000o0;
                typeface = null;
                for (String O000000o3 : o0000Oo0.f989O000000o.O0000o0O) {
                    typeface = O000000o(O000000o3, o0000Oo0.f989O000000o.O0000o, o0000Oo0.f989O000000o.O0000oO0);
                    if (typeface == null && hyl != null) {
                        o0000Oo0.f989O000000o.O0000o.intValue();
                        String.valueOf(o0000Oo0.f989O000000o.O0000oO0);
                        typeface = null;
                        continue;
                    }
                    if (typeface != null) {
                        break;
                    }
                }
            } else {
                typeface = null;
            }
            if (typeface == null) {
                typeface = O000000o("sans-serif", o0000Oo0.f989O000000o.O0000o, o0000Oo0.f989O000000o.O0000oO0);
            }
            o0000Oo0.O00000o.setTypeface(typeface);
            o0000Oo0.O00000oO.setTypeface(typeface);
        }
        if (O000000o(style, 131072)) {
            o0000Oo0.f989O000000o.O0000oO = style.O0000oO;
            o0000Oo0.O00000o.setStrikeThruText(style.O0000oO == SVG.Style.TextDecoration.LineThrough);
            o0000Oo0.O00000o.setUnderlineText(style.O0000oO == SVG.Style.TextDecoration.Underline);
            if (Build.VERSION.SDK_INT >= 17) {
                o0000Oo0.O00000oO.setStrikeThruText(style.O0000oO == SVG.Style.TextDecoration.LineThrough);
                Paint paint = o0000Oo0.O00000oO;
                if (style.O0000oO == SVG.Style.TextDecoration.Underline) {
                    z = true;
                }
                paint.setUnderlineText(z);
            }
        }
        if (O000000o(style, 68719476736L)) {
            o0000Oo0.f989O000000o.O0000oOO = style.O0000oOO;
        }
        if (O000000o(style, 262144)) {
            o0000Oo0.f989O000000o.O0000oOo = style.O0000oOo;
        }
        if (O000000o(style, (long) PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            o0000Oo0.f989O000000o.O0000oo0 = style.O0000oo0;
        }
        if (O000000o(style, 2097152)) {
            o0000Oo0.f989O000000o.O0000ooO = style.O0000ooO;
        }
        if (O000000o(style, 4194304)) {
            o0000Oo0.f989O000000o.O0000ooo = style.O0000ooo;
        }
        if (O000000o(style, 8388608)) {
            o0000Oo0.f989O000000o.O00oOooO = style.O00oOooO;
        }
        if (O000000o(style, 16777216)) {
            o0000Oo0.f989O000000o.O00oOooo = style.O00oOooo;
        }
        if (O000000o(style, 33554432)) {
            o0000Oo0.f989O000000o.O000O00o = style.O000O00o;
        }
        if (O000000o(style, 1048576)) {
            o0000Oo0.f989O000000o.O0000oo = style.O0000oo;
        }
        if (O000000o(style, 268435456)) {
            o0000Oo0.f989O000000o.O00oOoOo = style.O00oOoOo;
        }
        if (O000000o(style, 536870912)) {
            o0000Oo0.f989O000000o.O000O0o0 = style.O000O0o0;
        }
        if (O000000o(style, 1073741824)) {
            o0000Oo0.f989O000000o.O000O0o = style.O000O0o;
        }
        if (O000000o(style, 67108864)) {
            o0000Oo0.f989O000000o.O000O0OO = style.O000O0OO;
        }
        if (O000000o(style, 134217728)) {
            o0000Oo0.f989O000000o.O000O0Oo = style.O000O0Oo;
        }
        if (O000000o(style, 8589934592L)) {
            o0000Oo0.f989O000000o.O000OO00 = style.O000OO00;
        }
        if (O000000o(style, 17179869184L)) {
            o0000Oo0.f989O000000o.O000OO0o = style.O000OO0o;
        }
    }

    private void O000000o(O0000Oo0 o0000Oo0, boolean z, SVG.O00OOOo o00OOOo) {
        int i;
        float floatValue = (z ? o0000Oo0.f989O000000o.O00000o : o0000Oo0.f989O000000o.O00000oo).floatValue();
        if (o00OOOo instanceof SVG.O0000O0o) {
            i = ((SVG.O0000O0o) o00OOOo).f11872O000000o;
        } else if (o00OOOo instanceof SVG.O0000OOo) {
            i = o0000Oo0.f989O000000o.O0000o0.f11872O000000o;
        } else {
            return;
        }
        int O000000o2 = i | (O000000o(floatValue) << 24);
        if (z) {
            o0000Oo0.O00000o.setColor(this.O00000o.O000000o(O000000o2));
        } else {
            o0000Oo0.O00000oO.setColor(this.O00000o.O000000o(O000000o2));
        }
    }

    private static Typeface O000000o(String str, Integer num, SVG.Style.FontStyle fontStyle) {
        int i = 1;
        boolean z = fontStyle == SVG.Style.FontStyle.Italic;
        if (num.intValue() <= 500) {
            i = z ? 2 : 0;
        } else if (z) {
            i = 3;
        }
        if (str.equals("serif")) {
            return Typeface.create(Typeface.SERIF, i);
        }
        if (str.equals("sans-serif")) {
            return Typeface.create(Typeface.SANS_SERIF, i);
        }
        if (str.equals("monospace")) {
            return Typeface.create(Typeface.MONOSPACE, i);
        }
        if (str.equals("cursive")) {
            return Typeface.create(Typeface.SANS_SERIF, i);
        }
        if (str.equals("fantasy")) {
            return Typeface.create(Typeface.SANS_SERIF, i);
        }
        return null;
    }

    /* renamed from: _m_j.hyk$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] O00000Oo = new int[SVG.Style.LineCaps.values().length];
        static final /* synthetic */ int[] O00000o = new int[SVG.Style.FillRule.values().length];
        static final /* synthetic */ int[] O00000o0 = new int[SVG.Style.LineJoin.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|(2:1|2)|3|5|6|7|9|10|(2:11|12)|13|15|16|17|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|(2:1|2)|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0081 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x008b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00ab */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c1 */
        static {
            try {
                O00000o[SVG.Style.FillRule.EvenOdd.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000o[SVG.Style.FillRule.NonZero.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            O00000o0[SVG.Style.LineJoin.Miter.ordinal()] = 1;
            try {
                O00000o0[SVG.Style.LineJoin.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                O00000o0[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            O00000Oo[SVG.Style.LineCaps.Butt.ordinal()] = 1;
            O00000Oo[SVG.Style.LineCaps.Round.ordinal()] = 2;
            O00000Oo[SVG.Style.LineCaps.Square.ordinal()] = 3;
            f982O000000o = new int[PreserveAspectRatio.Alignment.values().length];
            f982O000000o[PreserveAspectRatio.Alignment.XMidYMin.ordinal()] = 1;
            f982O000000o[PreserveAspectRatio.Alignment.XMidYMid.ordinal()] = 2;
            f982O000000o[PreserveAspectRatio.Alignment.XMidYMax.ordinal()] = 3;
            f982O000000o[PreserveAspectRatio.Alignment.XMaxYMin.ordinal()] = 4;
            f982O000000o[PreserveAspectRatio.Alignment.XMaxYMid.ordinal()] = 5;
            f982O000000o[PreserveAspectRatio.Alignment.XMaxYMax.ordinal()] = 6;
            f982O000000o[PreserveAspectRatio.Alignment.XMinYMid.ordinal()] = 7;
            f982O000000o[PreserveAspectRatio.Alignment.XMinYMax.ordinal()] = 8;
        }
    }

    private void O000000o(float f, float f2, float f3, float f4) {
        float f5 = f3 + f;
        float f6 = f4 + f2;
        if (this.O00000o0.f989O000000o.O0000oo != null) {
            f += this.O00000o0.f989O000000o.O0000oo.O00000o.O000000o(this);
            f2 += this.O00000o0.f989O000000o.O0000oo.f11869O000000o.O00000Oo(this);
            f5 -= this.O00000o0.f989O000000o.O0000oo.O00000Oo.O000000o(this);
            f6 -= this.O00000o0.f989O000000o.O0000oo.O00000o0.O00000Oo(this);
        }
        this.f981O000000o.clipRect(f, f2, f5, f6);
    }

    private void O0000o00() {
        int i;
        if (this.O00000o0.f989O000000o.O000OO00 instanceof SVG.O0000O0o) {
            i = ((SVG.O0000O0o) this.O00000o0.f989O000000o.O000OO00).f11872O000000o;
        } else if (this.O00000o0.f989O000000o.O000OO00 instanceof SVG.O0000OOo) {
            i = this.O00000o0.f989O000000o.O0000o0.f11872O000000o;
        } else {
            return;
        }
        if (this.O00000o0.f989O000000o.O000OO0o != null) {
            i |= O000000o(this.O00000o0.f989O000000o.O000OO0o.floatValue()) << 24;
        }
        this.f981O000000o.drawColor(this.O00000o.O000000o(i));
    }

    class O00000o0 implements SVG.O000o000 {

        /* renamed from: O000000o  reason: collision with root package name */
        Path f986O000000o = new Path();
        float O00000Oo;
        float O00000o0;

        public O00000o0(SVG.O00O0Oo o00O0Oo) {
            o00O0Oo.O000000o(this);
        }

        public final void O000000o(float f, float f2) {
            this.f986O000000o.moveTo(f, f2);
            this.O00000Oo = f;
            this.O00000o0 = f2;
        }

        public final void O00000Oo(float f, float f2) {
            this.f986O000000o.lineTo(f, f2);
            this.O00000Oo = f;
            this.O00000o0 = f2;
        }

        public final void O000000o(float f, float f2, float f3, float f4, float f5, float f6) {
            this.f986O000000o.cubicTo(f, f2, f3, f4, f5, f6);
            this.O00000Oo = f5;
            this.O00000o0 = f6;
        }

        public final void O000000o(float f, float f2, float f3, float f4) {
            this.f986O000000o.quadTo(f, f2, f3, f4);
            this.O00000Oo = f3;
            this.O00000o0 = f4;
        }

        public final void O000000o(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            hyk.O000000o(this.O00000Oo, this.O00000o0, f, f2, f3, z, z2, f4, f5, this);
            this.O00000Oo = f4;
            this.O00000o0 = f5;
        }

        public final void O000000o() {
            this.f986O000000o.close();
        }
    }

    public static void O000000o(float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, float f6, float f7, SVG.O000o000 o000o000) {
        float f8;
        float f9;
        SVG.O000o000 o000o0002;
        double d;
        float f10 = f5;
        boolean z3 = z2;
        float f11 = f6;
        float f12 = f7;
        if (f != f11 || f2 != f12) {
            if (f3 == 0.0f) {
                f9 = f11;
                f8 = f12;
                o000o0002 = o000o000;
            } else if (f4 == 0.0f) {
                o000o0002 = o000o000;
                f9 = f11;
                f8 = f12;
            } else {
                float abs = Math.abs(f3);
                float abs2 = Math.abs(f4);
                double d2 = (double) f10;
                Double.isNaN(d2);
                double radians = (double) ((float) Math.toRadians(d2 % 360.0d));
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d3 = (double) (f - f11);
                Double.isNaN(d3);
                double d4 = d3 / 2.0d;
                double d5 = (double) (f2 - f12);
                Double.isNaN(d5);
                double d6 = d5 / 2.0d;
                double d7 = (cos * d4) + (sin * d6);
                double d8 = ((-sin) * d4) + (d6 * cos);
                double d9 = (double) (abs * abs);
                double d10 = (double) (abs2 * abs2);
                double d11 = d7 * d7;
                double d12 = d8 * d8;
                Double.isNaN(d9);
                Double.isNaN(d10);
                double d13 = (d11 / d9) + (d12 / d10);
                if (d13 > 1.0d) {
                    abs *= (float) Math.sqrt(d13);
                    abs2 *= (float) Math.sqrt(d13);
                    d9 = (double) (abs * abs);
                    d10 = (double) (abs2 * abs2);
                }
                double d14 = -1.0d;
                double d15 = z == z3 ? -1.0d : 1.0d;
                double d16 = d9 * d10;
                double d17 = d9 * d12;
                double d18 = d10 * d11;
                double d19 = ((d16 - d17) - d18) / (d17 + d18);
                if (d19 < 0.0d) {
                    d19 = 0.0d;
                }
                double sqrt = d15 * Math.sqrt(d19);
                double d20 = (double) abs;
                Double.isNaN(d20);
                double d21 = (double) abs2;
                Double.isNaN(d21);
                double d22 = ((d20 * d8) / d21) * sqrt;
                Double.isNaN(d21);
                Double.isNaN(d20);
                float f13 = abs;
                float f14 = abs2;
                double d23 = sqrt * (-((d21 * d7) / d20));
                double d24 = (double) (f + f6);
                Double.isNaN(d24);
                float f15 = f13;
                double d25 = (double) (f2 + f7);
                Double.isNaN(d25);
                double d26 = (d24 / 2.0d) + ((cos * d22) - (sin * d23));
                double d27 = (d25 / 2.0d) + (sin * d22) + (cos * d23);
                Double.isNaN(d20);
                double d28 = (d7 - d22) / d20;
                Double.isNaN(d21);
                double d29 = (d8 - d23) / d21;
                Double.isNaN(d20);
                double d30 = ((-d7) - d22) / d20;
                Double.isNaN(d21);
                double d31 = ((-d8) - d23) / d21;
                double d32 = (d28 * d28) + (d29 * d29);
                double degrees = Math.toDegrees((d29 < 0.0d ? -1.0d : 1.0d) * Math.acos(d28 / Math.sqrt(d32)));
                double sqrt2 = Math.sqrt(d32 * ((d30 * d30) + (d31 * d31)));
                double d33 = (d28 * d30) + (d29 * d31);
                if ((d28 * d31) - (d29 * d30) >= 0.0d) {
                    d14 = 1.0d;
                }
                double degrees2 = Math.toDegrees(d14 * Math.acos(d33 / sqrt2));
                if (z2 || degrees2 <= 0.0d) {
                    d = 360.0d;
                    if (z2 && degrees2 < 0.0d) {
                        degrees2 += 360.0d;
                    }
                } else {
                    d = 360.0d;
                    degrees2 -= 360.0d;
                }
                double d34 = degrees2 % d;
                int ceil = (int) Math.ceil(Math.abs(d34) / 90.0d);
                double radians2 = Math.toRadians(degrees % d);
                double radians3 = Math.toRadians(d34);
                double d35 = (double) ceil;
                Double.isNaN(d35);
                float f16 = (float) (radians3 / d35);
                double d36 = (double) f16;
                Double.isNaN(d36);
                double d37 = d36 / 2.0d;
                double sin2 = (Math.sin(d37) * 1.3333333333333333d) / (Math.cos(d37) + 1.0d);
                float[] fArr = new float[(ceil * 6)];
                int i = 0;
                int i2 = 0;
                while (i < ceil) {
                    int i3 = ceil;
                    double d38 = (double) (((float) i) * f16);
                    Double.isNaN(d38);
                    double d39 = d38 + radians2;
                    double cos2 = Math.cos(d39);
                    double sin3 = Math.sin(d39);
                    int i4 = i2 + 1;
                    double d40 = radians2;
                    fArr[i2] = (float) (cos2 - (sin2 * sin3));
                    int i5 = i4 + 1;
                    double d41 = d27;
                    fArr[i4] = (float) (sin3 + (cos2 * sin2));
                    Double.isNaN(d36);
                    double d42 = d39 + d36;
                    double cos3 = Math.cos(d42);
                    double sin4 = Math.sin(d42);
                    int i6 = i5 + 1;
                    fArr[i5] = (float) (cos3 + (sin2 * sin4));
                    int i7 = i6 + 1;
                    fArr[i6] = (float) (sin4 - (sin2 * cos3));
                    int i8 = i7 + 1;
                    fArr[i7] = (float) cos3;
                    i2 = i8 + 1;
                    fArr[i8] = (float) sin4;
                    i++;
                    radians2 = d40;
                    ceil = i3;
                    f16 = f16;
                    d36 = d36;
                    d27 = d41;
                }
                double d43 = d27;
                Matrix matrix = new Matrix();
                matrix.postScale(f15, f14);
                matrix.postRotate(f5);
                matrix.postTranslate((float) d26, (float) d43);
                matrix.mapPoints(fArr);
                fArr[fArr.length - 2] = f6;
                fArr[fArr.length - 1] = f7;
                for (int i9 = 0; i9 < fArr.length; i9 += 6) {
                    o000o000.O000000o(fArr[i9], fArr[i9 + 1], fArr[i9 + 2], fArr[i9 + 3], fArr[i9 + 4], fArr[i9 + 5]);
                }
                return;
            }
            o000o0002.O00000Oo(f9, f8);
        }
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public float f984O000000o;
        public float O00000Oo;
        public float O00000o = 0.0f;
        public float O00000o0 = 0.0f;

        public O00000Oo(float f, float f2, float f3, float f4) {
            this.f984O000000o = f;
            this.O00000Oo = f2;
            double sqrt = Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
            if (sqrt != 0.0d) {
                double d = (double) f3;
                Double.isNaN(d);
                this.O00000o0 = (float) (d / sqrt);
                double d2 = (double) f4;
                Double.isNaN(d2);
                this.O00000o = (float) (d2 / sqrt);
            }
        }

        public final void O000000o(float f, float f2) {
            float f3 = f - this.f984O000000o;
            float f4 = f2 - this.O00000Oo;
            double sqrt = Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
            if (sqrt != 0.0d) {
                float f5 = this.O00000o0;
                double d = (double) f3;
                Double.isNaN(d);
                this.O00000o0 = f5 + ((float) (d / sqrt));
                float f6 = this.O00000o;
                double d2 = (double) f4;
                Double.isNaN(d2);
                this.O00000o = f6 + ((float) (d2 / sqrt));
            }
        }

        public final void O000000o(O00000Oo o00000Oo) {
            this.O00000o0 += o00000Oo.O00000o0;
            this.O00000o += o00000Oo.O00000o;
        }

        public final String toString() {
            return "(" + this.f984O000000o + "," + this.O00000Oo + " " + this.O00000o0 + "," + this.O00000o + ")";
        }
    }

    class O000000o implements SVG.O000o000 {

        /* renamed from: O000000o  reason: collision with root package name */
        List<O00000Oo> f983O000000o = new ArrayList();
        private float O00000o;
        private float O00000o0;
        private O00000Oo O00000oO = null;
        private boolean O00000oo = false;
        private boolean O0000O0o = true;
        private int O0000OOo = -1;
        private boolean O0000Oo0;

        public O000000o(SVG.O00O0Oo o00O0Oo) {
            o00O0Oo.O000000o(this);
            if (this.O0000Oo0) {
                this.O00000oO.O000000o(this.f983O000000o.get(this.O0000OOo));
                this.f983O000000o.set(this.O0000OOo, this.O00000oO);
                this.O0000Oo0 = false;
            }
            O00000Oo o00000Oo = this.O00000oO;
            if (o00000Oo != null) {
                this.f983O000000o.add(o00000Oo);
            }
        }

        public final void O000000o(float f, float f2) {
            if (this.O0000Oo0) {
                this.O00000oO.O000000o(this.f983O000000o.get(this.O0000OOo));
                this.f983O000000o.set(this.O0000OOo, this.O00000oO);
                this.O0000Oo0 = false;
            }
            O00000Oo o00000Oo = this.O00000oO;
            if (o00000Oo != null) {
                this.f983O000000o.add(o00000Oo);
            }
            this.O00000o0 = f;
            this.O00000o = f2;
            this.O00000oO = new O00000Oo(f, f2, 0.0f, 0.0f);
            this.O0000OOo = this.f983O000000o.size();
        }

        public final void O00000Oo(float f, float f2) {
            this.O00000oO.O000000o(f, f2);
            this.f983O000000o.add(this.O00000oO);
            this.O00000oO = new O00000Oo(f, f2, f - this.O00000oO.f984O000000o, f2 - this.O00000oO.O00000Oo);
            this.O0000Oo0 = false;
        }

        public final void O000000o(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.O0000O0o || this.O00000oo) {
                this.O00000oO.O000000o(f, f2);
                this.f983O000000o.add(this.O00000oO);
                this.O00000oo = false;
            }
            this.O00000oO = new O00000Oo(f5, f6, f5 - f3, f6 - f4);
            this.O0000Oo0 = false;
        }

        public final void O000000o(float f, float f2, float f3, float f4) {
            this.O00000oO.O000000o(f, f2);
            this.f983O000000o.add(this.O00000oO);
            this.O00000oO = new O00000Oo(f3, f4, f3 - f, f4 - f2);
            this.O0000Oo0 = false;
        }

        public final void O000000o(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.O00000oo = true;
            this.O0000O0o = false;
            hyk.O000000o(this.O00000oO.f984O000000o, this.O00000oO.O00000Oo, f, f2, f3, z, z2, f4, f5, this);
            this.O0000O0o = true;
            this.O0000Oo0 = false;
        }

        public final void O000000o() {
            this.f983O000000o.add(this.O00000oO);
            O00000Oo(this.O00000o0, this.O00000o);
            this.O0000Oo0 = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0117 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    private void O000000o(SVG.O000O00o o000O00o) {
        SVG.O000OO o000oo;
        SVG.O000OO o000oo2;
        SVG.O000OO o000oo3;
        List<O00000Oo> list;
        int size;
        SVG.O000O00o o000O00o2 = o000O00o;
        if (this.O00000o0.f989O000000o.O0000ooO != null || this.O00000o0.f989O000000o.O0000ooo != null || this.O00000o0.f989O000000o.O00oOooO != null) {
            if (this.O00000o0.f989O000000o.O0000ooO != null) {
                SVG.O00OO0O O00000Oo2 = o000O00o2.O0000oOo.O00000Oo(this.O00000o0.f989O000000o.O0000ooO);
                if (O00000Oo2 != null) {
                    o000oo = (SVG.O000OO) O00000Oo2;
                    if (this.O00000o0.f989O000000o.O0000ooo != null) {
                        SVG.O00OO0O O00000Oo3 = o000O00o2.O0000oOo.O00000Oo(this.O00000o0.f989O000000o.O0000ooo);
                        if (O00000Oo3 != null) {
                            o000oo2 = (SVG.O000OO) O00000Oo3;
                            if (this.O00000o0.f989O000000o.O00oOooO != null) {
                                SVG.O00OO0O O00000Oo4 = o000O00o2.O0000oOo.O00000Oo(this.O00000o0.f989O000000o.O00oOooO);
                                if (O00000Oo4 != null) {
                                    o000oo3 = (SVG.O000OO) O00000Oo4;
                                    if (!(o000O00o2 instanceof SVG.O000Oo0)) {
                                        list = new O000000o(((SVG.O000Oo0) o000O00o2).f11882O000000o).f983O000000o;
                                    } else if (o000O00o2 instanceof SVG.O000OO0o) {
                                        SVG.O000OO0o o000OO0o = (SVG.O000OO0o) o000O00o2;
                                        float O000000o2 = o000OO0o.f11879O000000o != null ? o000OO0o.f11879O000000o.O000000o(this) : 0.0f;
                                        float O00000Oo5 = o000OO0o.O00000Oo != null ? o000OO0o.O00000Oo.O00000Oo(this) : 0.0f;
                                        float O000000o3 = o000OO0o.O00000o0 != null ? o000OO0o.O00000o0.O000000o(this) : 0.0f;
                                        float O00000Oo6 = o000OO0o.O00000o != null ? o000OO0o.O00000o.O00000Oo(this) : 0.0f;
                                        ArrayList arrayList = new ArrayList(2);
                                        float f = O000000o3 - O000000o2;
                                        float f2 = O00000Oo6 - O00000Oo5;
                                        float f3 = O000000o2;
                                        float f4 = O00000Oo5;
                                        float f5 = f;
                                        O00000Oo o00000Oo = r0;
                                        float f6 = f2;
                                        O00000Oo o00000Oo2 = new O00000Oo(f3, f4, f5, f6);
                                        arrayList.add(o00000Oo);
                                        arrayList.add(new O00000Oo(O000000o3, O00000Oo6, f5, f6));
                                        list = arrayList;
                                    } else {
                                        list = O000000o((SVG.O000o0) o000O00o2);
                                    }
                                    if (list != null && (size = list.size()) != 0) {
                                        SVG.Style style = this.O00000o0.f989O000000o;
                                        SVG.Style style2 = this.O00000o0.f989O000000o;
                                        this.O00000o0.f989O000000o.O00oOooO = null;
                                        style2.O0000ooo = null;
                                        style.O0000ooO = null;
                                        if (o000oo != null) {
                                            O000000o(o000oo, (O00000Oo) list.get(0));
                                        }
                                        if (o000oo2 != null) {
                                            for (int i = 1; i < size - 1; i++) {
                                                O000000o(o000oo2, (O00000Oo) list.get(i));
                                            }
                                        }
                                        if (o000oo3 == null) {
                                            O000000o(o000oo3, (O00000Oo) list.get(size - 1));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                O00000Oo("Marker reference '%s' not found", this.O00000o0.f989O000000o.O00oOooO);
                            }
                            o000oo3 = null;
                            if (!(o000O00o2 instanceof SVG.O000Oo0)) {
                            }
                            if (list != null) {
                                SVG.Style style3 = this.O00000o0.f989O000000o;
                                SVG.Style style22 = this.O00000o0.f989O000000o;
                                this.O00000o0.f989O000000o.O00oOooO = null;
                                style22.O0000ooo = null;
                                style3.O0000ooO = null;
                                if (o000oo != null) {
                                }
                                if (o000oo2 != null) {
                                }
                                if (o000oo3 == null) {
                                }
                            } else {
                                return;
                            }
                        } else {
                            O00000Oo("Marker reference '%s' not found", this.O00000o0.f989O000000o.O0000ooo);
                        }
                    }
                    o000oo2 = null;
                    if (this.O00000o0.f989O000000o.O00oOooO != null) {
                    }
                    o000oo3 = null;
                    if (!(o000O00o2 instanceof SVG.O000Oo0)) {
                    }
                    if (list != null) {
                    }
                } else {
                    O00000Oo("Marker reference '%s' not found", this.O00000o0.f989O000000o.O0000ooO);
                }
            }
            o000oo = null;
            if (this.O00000o0.f989O000000o.O0000ooo != null) {
            }
            o000oo2 = null;
            if (this.O00000o0.f989O000000o.O00oOooO != null) {
            }
            o000oo3 = null;
            if (!(o000O00o2 instanceof SVG.O000Oo0)) {
            }
            if (list != null) {
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0Oo0, boolean):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000OO, int]
     candidates:
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OO0O, _m_j.hyk$O0000Oo0):_m_j.hyk$O0000Oo0
      _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, com.xiaomi.smarthome.svg.SVG$O00O0o0):void
      _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, com.xiaomi.smarthome.svg.SVG$Style):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, _m_j.hyk$O00000Oo):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, com.xiaomi.smarthome.svg.SVG$O00O0o00):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, java.lang.String):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o00, android.graphics.Path):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o00, com.xiaomi.smarthome.svg.SVG$O000000o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, com.xiaomi.smarthome.svg.SVG$O00O0o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, com.xiaomi.smarthome.svg.SVG$O00OOo):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OoOO0, _m_j.hyk$O0000o00):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OoOO0, java.lang.StringBuilder):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, java.lang.String):void
      _m_j.hyk.O000000o(java.lang.String, java.lang.Object[]):void
      _m_j.hyk.O000000o(boolean, com.xiaomi.smarthome.svg.SVG$O00O000o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$Style, long):boolean
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG, com.xiaomi.smarthome.svg.PreserveAspectRatio):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0Oo0, boolean):void */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011e, code lost:
        if (r5 != 8) goto L_0x0128;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0140  */
    private void O000000o(SVG.O000OO o000oo, O00000Oo o00000Oo) {
        float f;
        PreserveAspectRatio preserveAspectRatio;
        boolean O0000O0o2;
        float f2;
        float f3;
        float f4;
        O00000o();
        float f5 = 0.0f;
        if (o000oo.O00000oo != null) {
            if (!Float.isNaN(o000oo.O00000oo.floatValue())) {
                f = o000oo.O00000oo.floatValue();
            } else if (!(o00000Oo.O00000o0 == 0.0f && o00000Oo.O00000o == 0.0f)) {
                f = (float) Math.toDegrees(Math.atan2((double) o00000Oo.O00000o, (double) o00000Oo.O00000o0));
            }
            float O000000o2 = !o000oo.f11877O000000o ? 1.0f : this.O00000o0.f989O000000o.O0000O0o.O000000o(this.O00000Oo);
            this.O00000o0 = O00000o0((SVG.O00OO0O) o000oo);
            Matrix matrix = new Matrix();
            matrix.preTranslate(o00000Oo.f984O000000o, o00000Oo.O00000Oo);
            matrix.preRotate(f);
            matrix.preScale(O000000o2, O000000o2);
            float O000000o3 = o000oo.O00000Oo == null ? o000oo.O00000Oo.O000000o(this) : 0.0f;
            float O00000Oo2 = o000oo.O00000o0 == null ? o000oo.O00000o0.O00000Oo(this) : 0.0f;
            float f6 = 3.0f;
            float O000000o4 = o000oo.O00000o == null ? o000oo.O00000o.O000000o(this) : 3.0f;
            if (o000oo.O00000oO != null) {
                f6 = o000oo.O00000oO.O00000Oo(this);
            }
            SVG.O000000o o000000o = o000oo.O0000ooO == null ? o000oo.O0000ooO : this.O00000o0.O00000oo;
            float f7 = O000000o4 / o000000o.O00000o0;
            float f8 = f6 / o000000o.O00000o;
            preserveAspectRatio = o000oo.O0000oo == null ? o000oo.O0000oo : PreserveAspectRatio.O00000oO;
            if (!preserveAspectRatio.equals(PreserveAspectRatio.O00000o)) {
                f7 = preserveAspectRatio.O00000Oo == PreserveAspectRatio.Scale.Slice ? Math.max(f7, f8) : Math.min(f7, f8);
                f8 = f7;
            }
            matrix.preTranslate((-O000000o3) * f7, (-O00000Oo2) * f8);
            this.f981O000000o.concat(matrix);
            if (!this.O00000o0.f989O000000o.O0000oo0.booleanValue()) {
                float f9 = o000000o.O00000o0 * f7;
                float f10 = o000000o.O00000o * f8;
                switch (preserveAspectRatio.f11865O000000o) {
                    case XMidYMin:
                    case XMidYMid:
                    case XMidYMax:
                        f4 = (O000000o4 - f9) / 2.0f;
                        f2 = 0.0f - f4;
                        break;
                    case XMaxYMin:
                    case XMaxYMid:
                    case XMaxYMax:
                        f4 = O000000o4 - f9;
                        f2 = 0.0f - f4;
                        break;
                    default:
                        f2 = 0.0f;
                        break;
                }
                int i = AnonymousClass1.f982O000000o[preserveAspectRatio.f11865O000000o.ordinal()];
                if (i != 2) {
                    if (i != 3) {
                        if (i != 5) {
                            if (i != 6) {
                                if (i != 7) {
                                }
                            }
                        }
                    }
                    f3 = f6 - f10;
                    f5 = 0.0f - f3;
                    O000000o(f2, f5, O000000o4, f6);
                }
                f3 = (f6 - f10) / 2.0f;
                f5 = 0.0f - f3;
                O000000o(f2, f5, O000000o4, f6);
            }
            matrix.reset();
            matrix.preScale(f7, f8);
            this.f981O000000o.concat(matrix);
            O0000O0o2 = O0000O0o();
            O000000o((SVG.O00O0Oo0) o000oo, false);
            if (O0000O0o2) {
                O00000Oo((SVG.O00O0o00) o000oo);
            }
            O00000oO();
        }
        f = 0.0f;
        if (!o000oo.f11877O000000o) {
        }
        this.O00000o0 = O00000o0((SVG.O00OO0O) o000oo);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(o00000Oo.f984O000000o, o00000Oo.O00000Oo);
        matrix2.preRotate(f);
        matrix2.preScale(O000000o2, O000000o2);
        if (o000oo.O00000Oo == null) {
        }
        if (o000oo.O00000o0 == null) {
        }
        float f62 = 3.0f;
        if (o000oo.O00000o == null) {
        }
        if (o000oo.O00000oO != null) {
        }
        if (o000oo.O0000ooO == null) {
        }
        float f72 = O000000o4 / o000000o.O00000o0;
        float f82 = f62 / o000000o.O00000o;
        if (o000oo.O0000oo == null) {
        }
        if (!preserveAspectRatio.equals(PreserveAspectRatio.O00000o)) {
        }
        matrix2.preTranslate((-O000000o3) * f72, (-O00000Oo2) * f82);
        this.f981O000000o.concat(matrix2);
        if (!this.O00000o0.f989O000000o.O0000oo0.booleanValue()) {
        }
        matrix2.reset();
        matrix2.preScale(f72, f82);
        this.f981O000000o.concat(matrix2);
        O0000O0o2 = O0000O0o();
        O000000o((SVG.O00O0Oo0) o000oo, false);
        if (O0000O0o2) {
        }
        O00000oO();
    }

    private O0000Oo0 O00000o0(SVG.O00OO0O o00oo0o) {
        O0000Oo0 o0000Oo0 = new O0000Oo0();
        O000000o(o0000Oo0, SVG.Style.O000000o());
        return O000000o(o00oo0o, o0000Oo0);
    }

    private O0000Oo0 O000000o(SVG.O00OO0O o00oo0o, O0000Oo0 o0000Oo0) {
        ArrayList<SVG.O00O0o0> arrayList = new ArrayList<>();
        while (true) {
            if (o00oo0o instanceof SVG.O00O0o0) {
                arrayList.add(0, (SVG.O00O0o0) o00oo0o);
            }
            if (o00oo0o.O0000oo0 == null) {
                break;
            }
            o00oo0o = (SVG.O00OO0O) o00oo0o.O0000oo0;
        }
        for (SVG.O00O0o0 O000000o2 : arrayList) {
            O000000o(o0000Oo0, O000000o2);
        }
        o0000Oo0.O0000O0o = this.O0000O0o.O00000Oo.O0000ooO;
        if (o0000Oo0.O0000O0o == null) {
            o0000Oo0.O0000O0o = this.O00000oO;
        }
        o0000Oo0.O00000oo = this.O00000oO;
        o0000Oo0.O0000Oo0 = this.O00000o0.O0000Oo0;
        return o0000Oo0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyk.O000000o(boolean, com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.SVG$O000OOo):void
     arg types: [int, com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.SVG$O000OOo]
     candidates:
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.PreserveAspectRatio):android.graphics.Matrix
      _m_j.hyk.O000000o(java.lang.String, java.lang.Integer, com.xiaomi.smarthome.svg.SVG$Style$FontStyle):android.graphics.Typeface
      _m_j.hyk.O000000o(java.lang.String, boolean, boolean):java.lang.String
      _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, boolean, com.xiaomi.smarthome.svg.SVG$O00OOOo):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000O00o, android.graphics.Path, android.graphics.Matrix):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, android.graphics.Path, android.graphics.Matrix):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o0, com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.PreserveAspectRatio):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o00, android.graphics.Path, com.xiaomi.smarthome.svg.SVG$O000o00):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo, android.graphics.Path, android.graphics.Matrix):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, android.graphics.Path, android.graphics.Matrix):void
      _m_j.hyk.O000000o(boolean, com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.SVG$O00O0o):void
      _m_j.hyk.O000000o(boolean, com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.SVG$O00OOo):void
      _m_j.hyk.O000000o(boolean, com.xiaomi.smarthome.svg.SVG$O000000o, com.xiaomi.smarthome.svg.SVG$O000OOo):void */
    private void O00000o0(SVG.O00O0o00 o00O0o00) {
        if (this.O00000o0.f989O000000o.O00000Oo instanceof SVG.O000OOo) {
            O000000o(true, o00O0o00.O0000o0O, (SVG.O000OOo) this.O00000o0.f989O000000o.O00000Oo);
        }
        if (this.O00000o0.f989O000000o.O00000oO instanceof SVG.O000OOo) {
            O000000o(false, o00O0o00.O0000o0O, (SVG.O000OOo) this.O00000o0.f989O000000o.O00000oO);
        }
    }

    private void O000000o(boolean z, SVG.O000000o o000000o, SVG.O000OOo o000OOo) {
        SVG.O00OO0O O00000Oo2 = this.O0000O0o.O00000Oo(o000OOo.f11881O000000o);
        if (O00000Oo2 == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = o000OOo.f11881O000000o;
            O00000Oo("%s reference '%s' not found", objArr);
            if (o000OOo.O00000Oo != null) {
                O000000o(this.O00000o0, z, o000OOo.O00000Oo);
            } else if (z) {
                this.O00000o0.O00000Oo = false;
            } else {
                this.O00000o0.O00000o0 = false;
            }
        } else {
            if (O00000Oo2 instanceof SVG.O00O0o) {
                O000000o(z, o000000o, (SVG.O00O0o) O00000Oo2);
            }
            if (O00000Oo2 instanceof SVG.O00OOo) {
                O000000o(z, o000000o, (SVG.O00OOo) O00000Oo2);
            }
            if (O00000Oo2 instanceof SVG.O00O000o) {
                O000000o(z, (SVG.O00O000o) O00000Oo2);
            }
        }
    }

    private void O000000o(boolean z, SVG.O000000o o000000o, SVG.O00O0o o00O0o) {
        float f;
        float f2;
        float f3;
        float f4;
        SVG.O000000o o000000o2 = o000000o;
        SVG.O00O0o o00O0o2 = o00O0o;
        if (o00O0o2.O00000oO != null) {
            O000000o(o00O0o2, o00O0o2.O00000oO);
        }
        int i = 0;
        boolean z2 = o00O0o2.O00000Oo != null && o00O0o2.O00000Oo.booleanValue();
        Paint paint = z ? this.O00000o0.O00000o : this.O00000o0.O00000oO;
        float f5 = 0.0f;
        if (z2) {
            SVG.O000000o O00000Oo2 = O00000Oo();
            float O000000o2 = o00O0o2.O00000oo != null ? o00O0o2.O00000oo.O000000o(this) : 0.0f;
            float O00000Oo3 = o00O0o2.O0000O0o != null ? o00O0o2.O0000O0o.O00000Oo(this) : 0.0f;
            float O000000o3 = o00O0o2.O0000OOo != null ? o00O0o2.O0000OOo.O000000o(this) : O00000Oo2.O00000o0;
            if (o00O0o2.O0000Oo0 != null) {
                f5 = o00O0o2.O0000Oo0.O00000Oo(this);
            }
            f = f5;
            f2 = O000000o3;
            f4 = O000000o2;
            f3 = O00000Oo3;
        } else {
            float O000000o4 = o00O0o2.O00000oo != null ? o00O0o2.O00000oo.O000000o(this, 1.0f) : 0.0f;
            float O000000o5 = o00O0o2.O0000O0o != null ? o00O0o2.O0000O0o.O000000o(this, 1.0f) : 0.0f;
            float O000000o6 = o00O0o2.O0000OOo != null ? o00O0o2.O0000OOo.O000000o(this, 1.0f) : 1.0f;
            if (o00O0o2.O0000Oo0 != null) {
                f5 = o00O0o2.O0000Oo0.O000000o(this, 1.0f);
            }
            f = f5;
            f4 = O000000o4;
            f3 = O000000o5;
            f2 = O000000o6;
        }
        O00000o();
        this.O00000o0 = O00000o0(o00O0o2);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(o000000o2.f11868O000000o, o000000o2.O00000Oo);
            matrix.preScale(o000000o2.O00000o0, o000000o2.O00000o);
        }
        if (o00O0o2.O00000o0 != null) {
            matrix.preConcat(o00O0o2.O00000o0);
        }
        int size = o00O0o2.f11894O000000o.size();
        if (size == 0) {
            O00000oO();
            if (z) {
                this.O00000o0.O00000Oo = false;
            } else {
                this.O00000o0.O00000o0 = false;
            }
        } else {
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f6 = -1.0f;
            for (SVG.O00OO0O o00oo0o : o00O0o2.f11894O000000o) {
                SVG.O00O00Oo o00O00Oo = (SVG.O00O00Oo) o00oo0o;
                if (i == 0 || o00O00Oo.f11885O000000o.floatValue() >= f6) {
                    fArr[i] = o00O00Oo.f11885O000000o.floatValue();
                    f6 = o00O00Oo.f11885O000000o.floatValue();
                } else {
                    fArr[i] = f6;
                }
                O00000o();
                O000000o(this.O00000o0, o00O00Oo);
                SVG.O0000O0o o0000O0o = (SVG.O0000O0o) this.O00000o0.f989O000000o.O000O0OO;
                if (o0000O0o == null) {
                    o0000O0o = SVG.O0000O0o.O00000Oo;
                }
                iArr[i] = o0000O0o.f11872O000000o | (O000000o(this.O00000o0.f989O000000o.O000O0Oo.floatValue()) << 24);
                i++;
                O00000oO();
            }
            if ((f4 == f2 && f3 == f) || size == 1) {
                O00000oO();
                paint.setColor(this.O00000o.O000000o(iArr[size - 1]));
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            if (o00O0o2.O00000o != null) {
                if (o00O0o2.O00000o == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (o00O0o2.O00000o == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            O00000oO();
            LinearGradient linearGradient = new LinearGradient(f4, f3, f2, f, iArr, fArr, tileMode);
            linearGradient.setLocalMatrix(matrix);
            paint.setShader(linearGradient);
        }
    }

    private void O000000o(boolean z, SVG.O000000o o000000o, SVG.O00OOo o00OOo) {
        float f;
        float f2;
        float f3;
        SVG.O000000o o000000o2 = o000000o;
        SVG.O00OOo o00OOo2 = o00OOo;
        if (o00OOo2.O00000oO != null) {
            O000000o(o00OOo2, o00OOo2.O00000oO);
        }
        int i = 0;
        boolean z2 = o00OOo2.O00000Oo != null && o00OOo2.O00000Oo.booleanValue();
        Paint paint = z ? this.O00000o0.O00000o : this.O00000o0.O00000oO;
        if (z2) {
            SVG.O000OO00 o000oo00 = new SVG.O000OO00(50.0f, SVG.Unit.percent);
            float O000000o2 = o00OOo2.O00000oo != null ? o00OOo2.O00000oo.O000000o(this) : o000oo00.O000000o(this);
            float O00000Oo2 = o00OOo2.O0000O0o != null ? o00OOo2.O0000O0o.O00000Oo(this) : o000oo00.O00000Oo(this);
            if (o00OOo2.O0000OOo != null) {
                o000oo00 = o00OOo2.O0000OOo;
            }
            f = o000oo00.O00000o0(this);
            f3 = O000000o2;
            f2 = O00000Oo2;
        } else {
            float O000000o3 = o00OOo2.O00000oo != null ? o00OOo2.O00000oo.O000000o(this, 1.0f) : 0.5f;
            float O000000o4 = o00OOo2.O0000O0o != null ? o00OOo2.O0000O0o.O000000o(this, 1.0f) : 0.5f;
            f3 = O000000o3;
            f = o00OOo2.O0000OOo != null ? o00OOo2.O0000OOo.O000000o(this, 1.0f) : 0.5f;
            f2 = O000000o4;
        }
        O00000o();
        this.O00000o0 = O00000o0(o00OOo2);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(o000000o2.f11868O000000o, o000000o2.O00000Oo);
            matrix.preScale(o000000o2.O00000o0, o000000o2.O00000o);
        }
        if (o00OOo2.O00000o0 != null) {
            matrix.preConcat(o00OOo2.O00000o0);
        }
        int size = o00OOo2.f11894O000000o.size();
        if (size == 0) {
            O00000oO();
            if (z) {
                this.O00000o0.O00000Oo = false;
            } else {
                this.O00000o0.O00000o0 = false;
            }
        } else {
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f4 = -1.0f;
            for (SVG.O00OO0O o00oo0o : o00OOo2.f11894O000000o) {
                SVG.O00O00Oo o00O00Oo = (SVG.O00O00Oo) o00oo0o;
                if (i == 0 || o00O00Oo.f11885O000000o.floatValue() >= f4) {
                    fArr[i] = o00O00Oo.f11885O000000o.floatValue();
                    f4 = o00O00Oo.f11885O000000o.floatValue();
                } else {
                    fArr[i] = f4;
                }
                O00000o();
                O000000o(this.O00000o0, o00O00Oo);
                SVG.O0000O0o o0000O0o = (SVG.O0000O0o) this.O00000o0.f989O000000o.O000O0OO;
                if (o0000O0o == null) {
                    o0000O0o = SVG.O0000O0o.O00000Oo;
                }
                iArr[i] = o0000O0o.f11872O000000o | (O000000o(this.O00000o0.f989O000000o.O000O0Oo.floatValue()) << 24);
                i++;
                O00000oO();
            }
            if (f == 0.0f || size == 1) {
                O00000oO();
                paint.setColor(this.O00000o.O000000o(iArr[size - 1]));
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            if (o00OOo2.O00000o != null) {
                if (o00OOo2.O00000o == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (o00OOo2.O00000o == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            O00000oO();
            RadialGradient radialGradient = new RadialGradient(f3, f2, f, iArr, fArr, tileMode);
            radialGradient.setLocalMatrix(matrix);
            paint.setShader(radialGradient);
        }
    }

    private void O000000o(SVG.O00oOooO o00oOooO, String str) {
        while (true) {
            SVG.O00OO0O O00000Oo2 = o00oOooO.O0000oOo.O00000Oo(str);
            if (O00000Oo2 == null) {
                O000000o("Gradient reference '%s' not found", str);
                return;
            } else if (!(O00000Oo2 instanceof SVG.O00oOooO)) {
                O00000Oo("Gradient href attributes must point to other gradient elements", new Object[0]);
                return;
            } else if (O00000Oo2 == o00oOooO) {
                O00000Oo("Circular reference in gradient href attribute '%s'", str);
                return;
            } else {
                SVG.O00oOooO o00oOooO2 = (SVG.O00oOooO) O00000Oo2;
                if (o00oOooO.O00000Oo == null) {
                    o00oOooO.O00000Oo = o00oOooO2.O00000Oo;
                }
                if (o00oOooO.O00000o0 == null) {
                    o00oOooO.O00000o0 = o00oOooO2.O00000o0;
                }
                if (o00oOooO.O00000o == null) {
                    o00oOooO.O00000o = o00oOooO2.O00000o;
                }
                if (o00oOooO.f11894O000000o.isEmpty()) {
                    o00oOooO.f11894O000000o = o00oOooO2.f11894O000000o;
                }
                try {
                    if (o00oOooO instanceof SVG.O00O0o) {
                        O000000o((SVG.O00O0o) o00oOooO, (SVG.O00O0o) O00000Oo2);
                    } else {
                        O000000o((SVG.O00OOo) o00oOooO, (SVG.O00OOo) O00000Oo2);
                    }
                } catch (ClassCastException unused) {
                }
                if (o00oOooO2.O00000oO != null) {
                    str = o00oOooO2.O00000oO;
                } else {
                    return;
                }
            }
        }
    }

    private static void O000000o(SVG.O00O0o o00O0o, SVG.O00O0o o00O0o2) {
        if (o00O0o.O00000oo == null) {
            o00O0o.O00000oo = o00O0o2.O00000oo;
        }
        if (o00O0o.O0000O0o == null) {
            o00O0o.O0000O0o = o00O0o2.O0000O0o;
        }
        if (o00O0o.O0000OOo == null) {
            o00O0o.O0000OOo = o00O0o2.O0000OOo;
        }
        if (o00O0o.O0000Oo0 == null) {
            o00O0o.O0000Oo0 = o00O0o2.O0000Oo0;
        }
    }

    private static void O000000o(SVG.O00OOo o00OOo, SVG.O00OOo o00OOo2) {
        if (o00OOo.O00000oo == null) {
            o00OOo.O00000oo = o00OOo2.O00000oo;
        }
        if (o00OOo.O0000O0o == null) {
            o00OOo.O0000O0o = o00OOo2.O0000O0o;
        }
        if (o00OOo.O0000OOo == null) {
            o00OOo.O0000OOo = o00OOo2.O0000OOo;
        }
        if (o00OOo.O0000Oo0 == null) {
            o00OOo.O0000Oo0 = o00OOo2.O0000Oo0;
        }
        if (o00OOo.O0000Oo == null) {
            o00OOo.O0000Oo = o00OOo2.O0000Oo;
        }
    }

    private void O000000o(boolean z, SVG.O00O000o o00O000o) {
        boolean z2 = true;
        if (z) {
            if (O000000o(o00O000o.O0000oO0, 2147483648L)) {
                this.O00000o0.f989O000000o.O00000Oo = o00O000o.O0000oO0.O000O0oO;
                O0000Oo0 o0000Oo0 = this.O00000o0;
                if (o00O000o.O0000oO0.O000O0oO == null) {
                    z2 = false;
                }
                o0000Oo0.O00000Oo = z2;
            }
            if (O000000o(o00O000o.O0000oO0, 4294967296L)) {
                this.O00000o0.f989O000000o.O00000o = o00O000o.O0000oO0.O000O0oo;
            }
            if (O000000o(o00O000o.O0000oO0, 6442450944L)) {
                O0000Oo0 o0000Oo02 = this.O00000o0;
                O000000o(o0000Oo02, z, o0000Oo02.f989O000000o.O00000Oo);
                return;
            }
            return;
        }
        if (O000000o(o00O000o.O0000oO0, 2147483648L)) {
            this.O00000o0.f989O000000o.O00000oO = o00O000o.O0000oO0.O000O0oO;
            O0000Oo0 o0000Oo03 = this.O00000o0;
            if (o00O000o.O0000oO0.O000O0oO == null) {
                z2 = false;
            }
            o0000Oo03.O00000o0 = z2;
        }
        if (O000000o(o00O000o.O0000oO0, 4294967296L)) {
            this.O00000o0.f989O000000o.O00000oo = o00O000o.O0000oO0.O000O0oo;
        }
        if (O000000o(o00O000o.O0000oO0, 6442450944L)) {
            O0000Oo0 o0000Oo04 = this.O00000o0;
            O000000o(o0000Oo04, z, o0000Oo04.f989O000000o.O00000oO);
        }
    }

    private void O00000o(SVG.O00O0o00 o00O0o00) {
        O000000o(o00O0o00, o00O0o00.O0000o0O);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OO0O, boolean, android.graphics.Path, android.graphics.Matrix):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00OO0O, int, android.graphics.Path, android.graphics.Matrix]
     candidates:
      _m_j.hyk.O000000o(float, float, float, float):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OO0O, boolean, android.graphics.Path, android.graphics.Matrix):void */
    private void O000000o(SVG.O00O0o00 o00O0o00, SVG.O000000o o000000o) {
        if (this.O00000o0.f989O000000o.O00oOoOo != null) {
            SVG.O00OO0O O00000Oo2 = o00O0o00.O0000oOo.O00000Oo(this.O00000o0.f989O000000o.O00oOoOo);
            if (O00000Oo2 == null) {
                O00000Oo("ClipPath reference '%s' not found", this.O00000o0.f989O000000o.O00oOoOo);
                return;
            }
            SVG.O00000o o00000o = (SVG.O00000o) O00000Oo2;
            if (o00000o.O0000Oo0.isEmpty()) {
                this.f981O000000o.clipRect(0, 0, 0, 0);
                return;
            }
            boolean z = o00000o.f11870O000000o == null || o00000o.f11870O000000o.booleanValue();
            if (!(o00O0o00 instanceof SVG.O000O0OO) || z) {
                O0000o0();
                if (!z) {
                    Matrix matrix = new Matrix();
                    matrix.preTranslate(o000000o.f11868O000000o, o000000o.O00000Oo);
                    matrix.preScale(o000000o.O00000o0, o000000o.O00000o);
                    this.f981O000000o.concat(matrix);
                }
                if (o00000o.O00000Oo != null) {
                    this.f981O000000o.concat(o00000o.O00000Oo);
                }
                this.O00000o0 = O00000o0((SVG.O00OO0O) o00000o);
                O00000o(o00000o);
                Path path = new Path();
                for (SVG.O00OO0O O000000o2 : o00000o.O0000Oo0) {
                    O000000o(O000000o2, true, path, new Matrix());
                }
                this.f981O000000o.clipPath(path);
                O0000o0O();
                return;
            }
            O000000o("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", o00O0o00.getClass().getSimpleName());
        }
    }

    private void O000000o(SVG.O00OO0O o00oo0o, boolean z, Path path, Matrix matrix) {
        if (O0000Ooo()) {
            O0000o0();
            if (o00oo0o instanceof SVG.O00o0) {
                if (z) {
                    O000000o((SVG.O00o0) o00oo0o, path, matrix);
                } else {
                    O00000Oo("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (o00oo0o instanceof SVG.O000Oo0) {
                O000000o((SVG.O000Oo0) o00oo0o, path, matrix);
            } else if (o00oo0o instanceof SVG.O00Oo) {
                O000000o((SVG.O00Oo) o00oo0o, path, matrix);
            } else if (o00oo0o instanceof SVG.O000O00o) {
                O000000o((SVG.O000O00o) o00oo0o, path, matrix);
            } else {
                O00000Oo("Invalid %s element found in clipPath definition", o00oo0o.getClass().getSimpleName());
            }
            O0000o0O();
        }
    }

    private void O0000o0() {
        this.f981O000000o.save();
        this.O0000OOo.push(this.O00000o0);
        this.O00000o0 = (O0000Oo0) this.O00000o0.clone();
    }

    private void O0000o0O() {
        this.f981O000000o.restore();
        this.O00000o0 = this.O0000OOo.pop();
    }

    private Path.FillType O0000o0o() {
        if (this.O00000o0.f989O000000o.O000O0o0 == null) {
            return Path.FillType.WINDING;
        }
        if (AnonymousClass1.O00000o[this.O00000o0.f989O000000o.O000O0o0.ordinal()] != 1) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    private void O000000o(SVG.O000Oo0 o000Oo0, Path path, Matrix matrix) {
        O000000o(this.O00000o0, o000Oo0);
        if (O0000Ooo() && O00000o0()) {
            if (o000Oo0.O00000oO != null) {
                matrix.preConcat(o000Oo0.O00000oO);
            }
            Path path2 = new O00000o0(o000Oo0.f11882O000000o).f986O000000o;
            if (o000Oo0.O0000o0O == null) {
                o000Oo0.O0000o0O = O00000Oo(path2);
            }
            O00000o(o000Oo0);
            path.setFillType(O0000o0o());
            path.addPath(path2, matrix);
        }
    }

    private void O000000o(SVG.O000O00o o000O00o, Path path, Matrix matrix) {
        Path path2;
        O000000o(this.O00000o0, o000O00o);
        if (O0000Ooo() && O00000o0()) {
            if (o000O00o.O00000oO != null) {
                matrix.preConcat(o000O00o.O00000oO);
            }
            if (o000O00o instanceof SVG.oooOoO) {
                path2 = O000000o((SVG.oooOoO) o000O00o);
            } else if (o000O00o instanceof SVG.O00000o0) {
                path2 = O000000o((SVG.O00000o0) o000O00o);
            } else if (o000O00o instanceof SVG.O0000Oo) {
                path2 = O000000o((SVG.O0000Oo) o000O00o);
            } else if (o000O00o instanceof SVG.O000o0) {
                path2 = O00000Oo((SVG.O000o0) o000O00o);
            } else {
                return;
            }
            O00000o(o000O00o);
            path.setFillType(path2.getFillType());
            path.addPath(path2, matrix);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OO0O, boolean, android.graphics.Path, android.graphics.Matrix):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00OO0O, int, android.graphics.Path, android.graphics.Matrix]
     candidates:
      _m_j.hyk.O000000o(float, float, float, float):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OO0O, boolean, android.graphics.Path, android.graphics.Matrix):void */
    private void O000000o(SVG.O00o0 o00o0, Path path, Matrix matrix) {
        O000000o(this.O00000o0, o00o0);
        if (O0000Ooo() && O00000o0()) {
            if (o00o0.O00000Oo != null) {
                matrix.preConcat(o00o0.O00000Oo);
            }
            SVG.O00OO0O O00000Oo2 = o00o0.O0000oOo.O00000Oo(o00o0.f11892O000000o);
            if (O00000Oo2 == null) {
                O00000Oo("Use reference '%s' not found", o00o0.f11892O000000o);
                return;
            }
            O00000o(o00o0);
            O000000o(O00000Oo2, false, path, matrix);
        }
    }

    private void O000000o(SVG.O00Oo o00Oo, Path path, Matrix matrix) {
        O000000o(this.O00000o0, o00Oo);
        if (O0000Ooo()) {
            if (o00Oo.f11888O000000o != null) {
                matrix.preConcat(o00Oo.f11888O000000o);
            }
            float f = 0.0f;
            float O000000o2 = (o00Oo.O00000Oo == null || o00Oo.O00000Oo.size() == 0) ? 0.0f : ((SVG.O000OO00) o00Oo.O00000Oo.get(0)).O000000o(this);
            float O00000Oo2 = (o00Oo.O00000o0 == null || o00Oo.O00000o0.size() == 0) ? 0.0f : ((SVG.O000OO00) o00Oo.O00000o0.get(0)).O00000Oo(this);
            float O000000o3 = (o00Oo.O00000o == null || o00Oo.O00000o.size() == 0) ? 0.0f : ((SVG.O000OO00) o00Oo.O00000o.get(0)).O000000o(this);
            if (!(o00Oo.O00000oO == null || o00Oo.O00000oO.size() == 0)) {
                f = ((SVG.O000OO00) o00Oo.O00000oO.get(0)).O00000Oo(this);
            }
            if (this.O00000o0.f989O000000o.O0000oOo != SVG.Style.TextAnchor.Start) {
                float O000000o4 = O000000o((SVG.O00OoOO0) o00Oo);
                if (this.O00000o0.f989O000000o.O0000oOo == SVG.Style.TextAnchor.Middle) {
                    O000000o4 /= 2.0f;
                }
                O000000o2 -= O000000o4;
            }
            if (o00Oo.O0000o0O == null) {
                O0000Oo o0000Oo = new O0000Oo(O000000o2, O00000Oo2);
                O000000o(o00Oo, o0000Oo);
                o00Oo.O0000o0O = new SVG.O000000o(o0000Oo.O00000o0.left, o0000Oo.O00000o0.top, o0000Oo.O00000o0.width(), o0000Oo.O00000o0.height());
            }
            O00000o(o00Oo);
            Path path2 = new Path();
            O000000o(o00Oo, new O0000OOo(O000000o2 + O000000o3, O00000Oo2 + f, path2));
            path.setFillType(O0000o0o());
            path.addPath(path2, matrix);
        }
    }

    class O0000OOo extends O0000o00 {

        /* renamed from: O000000o  reason: collision with root package name */
        public float f987O000000o;
        public float O00000Oo;
        public Path O00000o0;

        public O0000OOo(float f, float f2, Path path) {
            super(hyk.this, (byte) 0);
            this.f987O000000o = f;
            this.O00000Oo = f2;
            this.O00000o0 = path;
        }

        public final boolean O000000o(SVG.O00OoOO0 o00OoOO0) {
            if (!(o00OoOO0 instanceof SVG.O00Ooo00)) {
                return true;
            }
            hyk.O000000o("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        public final void O000000o(String str) {
            if (hyk.this.O00000o0()) {
                Path path = new Path();
                hyk.this.O00000o0.O00000o.getTextPath(str, 0, str.length(), this.f987O000000o, this.O00000Oo, path);
                this.O00000o0.addPath(path);
            }
            this.f987O000000o += hyk.this.O00000o0.O00000o.measureText(str);
        }
    }

    private Path O000000o(SVG.oooOoO oooooo) {
        float f;
        float f2;
        Path path;
        SVG.oooOoO oooooo2 = oooooo;
        if (oooooo2.O00000oo == null && oooooo2.O0000O0o == null) {
            f2 = 0.0f;
            f = 0.0f;
        } else {
            if (oooooo2.O00000oo == null) {
                f2 = oooooo2.O0000O0o.O00000Oo(this);
            } else if (oooooo2.O0000O0o == null) {
                f2 = oooooo2.O00000oo.O000000o(this);
            } else {
                f2 = oooooo2.O00000oo.O000000o(this);
                f = oooooo2.O0000O0o.O00000Oo(this);
            }
            f = f2;
        }
        float min = Math.min(f2, oooooo2.O00000o0.O000000o(this) / 2.0f);
        float min2 = Math.min(f, oooooo2.O00000o.O00000Oo(this) / 2.0f);
        float O000000o2 = oooooo2.f11897O000000o != null ? oooooo2.f11897O000000o.O000000o(this) : 0.0f;
        float O00000Oo2 = oooooo2.O00000Oo != null ? oooooo2.O00000Oo.O00000Oo(this) : 0.0f;
        float O000000o3 = oooooo2.O00000o0.O000000o(this);
        float O00000Oo3 = oooooo2.O00000o.O00000Oo(this);
        if (oooooo2.O0000o0O == null) {
            oooooo2.O0000o0O = new SVG.O000000o(O000000o2, O00000Oo2, O000000o3, O00000Oo3);
        }
        float f3 = O000000o2 + O000000o3;
        float f4 = O00000Oo2 + O00000Oo3;
        Path path2 = new Path();
        if (min == 0.0f || min2 == 0.0f) {
            path = path2;
            path.moveTo(O000000o2, O00000Oo2);
            path.lineTo(f3, O00000Oo2);
            path.lineTo(f3, f4);
            path.lineTo(O000000o2, f4);
            path.lineTo(O000000o2, O00000Oo2);
        } else {
            float f5 = min * 0.5522848f;
            float f6 = 0.5522848f * min2;
            float f7 = O00000Oo2 + min2;
            path2.moveTo(O000000o2, f7);
            float f8 = f7 - f6;
            float f9 = O000000o2 + min;
            float f10 = f9 - f5;
            path2.cubicTo(O000000o2, f8, f10, O00000Oo2, f9, O00000Oo2);
            float f11 = f3 - min;
            path2.lineTo(f11, O00000Oo2);
            float f12 = f11 + f5;
            float f13 = f7;
            path2.cubicTo(f12, O00000Oo2, f3, f8, f3, f13);
            float f14 = f4 - min2;
            path2.lineTo(f3, f14);
            float f15 = f6 + f14;
            path = path2;
            path2.cubicTo(f3, f15, f12, f4, f11, f4);
            path.lineTo(f9, f4);
            path.cubicTo(f10, f4, O000000o2, f15, O000000o2, f14);
            path.lineTo(O000000o2, f13);
        }
        path.close();
        return path;
    }

    private Path O000000o(SVG.O00000o0 o00000o0) {
        SVG.O00000o0 o00000o02 = o00000o0;
        float f = 0.0f;
        float O000000o2 = o00000o02.f11871O000000o != null ? o00000o02.f11871O000000o.O000000o(this) : 0.0f;
        if (o00000o02.O00000Oo != null) {
            f = o00000o02.O00000Oo.O00000Oo(this);
        }
        float O00000o02 = o00000o02.O00000o0.O00000o0(this);
        float f2 = O000000o2 - O00000o02;
        float f3 = f - O00000o02;
        float f4 = O000000o2 + O00000o02;
        float f5 = f + O00000o02;
        if (o00000o02.O0000o0O == null) {
            float f6 = 2.0f * O00000o02;
            o00000o02.O0000o0O = new SVG.O000000o(f2, f3, f6, f6);
        }
        float f7 = 0.5522848f * O00000o02;
        Path path = new Path();
        path.moveTo(O000000o2, f3);
        float f8 = O000000o2 + f7;
        float f9 = f - f7;
        Path path2 = path;
        path2.cubicTo(f8, f3, f4, f9, f4, f);
        float f10 = f + f7;
        path2.cubicTo(f4, f10, f8, f5, O000000o2, f5);
        float f11 = O000000o2 - f7;
        path2.cubicTo(f11, f5, f2, f10, f2, f);
        path2.cubicTo(f2, f9, f11, f3, O000000o2, f3);
        path.close();
        return path;
    }

    private Path O000000o(SVG.O0000Oo o0000Oo) {
        SVG.O0000Oo o0000Oo2 = o0000Oo;
        float f = 0.0f;
        float O000000o2 = o0000Oo2.f11874O000000o != null ? o0000Oo2.f11874O000000o.O000000o(this) : 0.0f;
        if (o0000Oo2.O00000Oo != null) {
            f = o0000Oo2.O00000Oo.O00000Oo(this);
        }
        float O000000o3 = o0000Oo2.O00000o0.O000000o(this);
        float O00000Oo2 = o0000Oo2.O00000o.O00000Oo(this);
        float f2 = O000000o2 - O000000o3;
        float f3 = f - O00000Oo2;
        float f4 = O000000o2 + O000000o3;
        float f5 = f + O00000Oo2;
        if (o0000Oo2.O0000o0O == null) {
            o0000Oo2.O0000o0O = new SVG.O000000o(f2, f3, O000000o3 * 2.0f, 2.0f * O00000Oo2);
        }
        float f6 = O000000o3 * 0.5522848f;
        float f7 = 0.5522848f * O00000Oo2;
        Path path = new Path();
        path.moveTo(O000000o2, f3);
        float f8 = O000000o2 + f6;
        float f9 = f - f7;
        Path path2 = path;
        path.cubicTo(f8, f3, f4, f9, f4, f);
        float f10 = f7 + f;
        Path path3 = path2;
        path3.cubicTo(f4, f10, f8, f5, O000000o2, f5);
        float f11 = O000000o2 - f6;
        path3.cubicTo(f11, f5, f2, f10, f2, f);
        path3.cubicTo(f2, f9, f11, f3, O000000o2, f3);
        path2.close();
        return path2;
    }

    private Path O00000Oo(SVG.O000o0 o000o0) {
        Path path = new Path();
        path.moveTo(o000o0.f11883O000000o[0], o000o0.f11883O000000o[1]);
        for (int i = 2; i < o000o0.f11883O000000o.length; i += 2) {
            path.lineTo(o000o0.f11883O000000o[i], o000o0.f11883O000000o[i + 1]);
        }
        if (o000o0 instanceof SVG.O000o) {
            path.close();
        }
        if (o000o0.O0000o0O == null) {
            o000o0.O0000o0O = O00000Oo(path);
        }
        path.setFillType(O0000o0o());
        return path;
    }

    private void O000000o(SVG.O00O0o00 o00O0o00, Path path, SVG.O000o00 o000o00) {
        float f;
        float f2;
        float f3;
        float f4;
        SVG.O00O0o00 o00O0o002 = o00O0o00;
        SVG.O000o00 o000o002 = o000o00;
        boolean z = o000o002.f11884O000000o != null && o000o002.f11884O000000o.booleanValue();
        if (o000o002.O0000OOo != null) {
            O000000o(o000o002, o000o002.O0000OOo);
        }
        if (z) {
            f4 = o000o002.O00000o != null ? o000o002.O00000o.O000000o(this) : 0.0f;
            float O00000Oo2 = o000o002.O00000oO != null ? o000o002.O00000oO.O00000Oo(this) : 0.0f;
            f2 = o000o002.O00000oo != null ? o000o002.O00000oo.O000000o(this) : 0.0f;
            f = O00000Oo2;
            f3 = o000o002.O0000O0o != null ? o000o002.O0000O0o.O00000Oo(this) : 0.0f;
        } else {
            float O000000o2 = o000o002.O00000o != null ? o000o002.O00000o.O000000o(this, 1.0f) : 0.0f;
            float O000000o3 = o000o002.O00000oO != null ? o000o002.O00000oO.O000000o(this, 1.0f) : 0.0f;
            float O000000o4 = o000o002.O00000oo != null ? o000o002.O00000oo.O000000o(this, 1.0f) : 0.0f;
            float O000000o5 = o000o002.O0000O0o != null ? o000o002.O0000O0o.O000000o(this, 1.0f) : 0.0f;
            f4 = (O000000o2 * o00O0o002.O0000o0O.O00000o0) + o00O0o002.O0000o0O.f11868O000000o;
            float f5 = (O000000o3 * o00O0o002.O0000o0O.O00000o) + o00O0o002.O0000o0O.O00000Oo;
            float f6 = O000000o4 * o00O0o002.O0000o0O.O00000o0;
            f3 = O000000o5 * o00O0o002.O0000o0O.O00000o;
            float f7 = f6;
            f = f5;
            f2 = f7;
        }
        if (f2 != 0.0f && f3 != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = o000o002.O0000oo != null ? o000o002.O0000oo : PreserveAspectRatio.O00000oO;
            O00000o();
            this.f981O000000o.clipPath(path);
            O0000Oo0 o0000Oo0 = new O0000Oo0();
            O000000o(o0000Oo0, SVG.Style.O000000o());
            o0000Oo0.f989O000000o.O0000oo0 = Boolean.FALSE;
            this.O00000o0 = O000000o(o000o002, o0000Oo0);
            SVG.O000000o o000000o = o00O0o002.O0000o0O;
            if (o000o002.O00000o0 != null) {
                this.f981O000000o.concat(o000o002.O00000o0);
                Matrix matrix = new Matrix();
                if (o000o002.O00000o0.invert(matrix)) {
                    float[] fArr = {o00O0o002.O0000o0O.f11868O000000o, o00O0o002.O0000o0O.O00000Oo, o00O0o002.O0000o0O.O000000o(), o00O0o002.O0000o0O.O00000Oo, o00O0o002.O0000o0O.O000000o(), o00O0o002.O0000o0O.O00000Oo(), o00O0o002.O0000o0O.f11868O000000o, o00O0o002.O0000o0O.O00000Oo()};
                    matrix.mapPoints(fArr);
                    RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                    for (int i = 2; i <= 6; i += 2) {
                        if (fArr[i] < rectF.left) {
                            rectF.left = fArr[i];
                        }
                        if (fArr[i] > rectF.right) {
                            rectF.right = fArr[i];
                        }
                        int i2 = i + 1;
                        if (fArr[i2] < rectF.top) {
                            rectF.top = fArr[i2];
                        }
                        if (fArr[i2] > rectF.bottom) {
                            rectF.bottom = fArr[i2];
                        }
                    }
                    o000000o = new SVG.O000000o(rectF.left, rectF.top, rectF.right - rectF.left, rectF.bottom - rectF.top);
                }
            }
            float floor = f4 + (((float) Math.floor((double) ((o000000o.f11868O000000o - f4) / f2))) * f2);
            float O000000o6 = o000000o.O000000o();
            float O00000Oo3 = o000000o.O00000Oo();
            SVG.O000000o o000000o2 = new SVG.O000000o(0.0f, 0.0f, f2, f3);
            for (float floor2 = f + (((float) Math.floor((double) ((o000000o.O00000Oo - f) / f3))) * f3); floor2 < O00000Oo3; floor2 += f3) {
                for (float f8 = floor; f8 < O000000o6; f8 += f2) {
                    o000000o2.f11868O000000o = f8;
                    o000000o2.O00000Oo = floor2;
                    O00000o();
                    if (!this.O00000o0.f989O000000o.O0000oo0.booleanValue()) {
                        O000000o(o000000o2.f11868O000000o, o000000o2.O00000Oo, o000000o2.O00000o0, o000000o2.O00000o);
                    }
                    if (o000o002.O0000ooO != null) {
                        this.f981O000000o.concat(O000000o(o000000o2, o000o002.O0000ooO, preserveAspectRatio));
                    } else {
                        boolean z2 = o000o002.O00000Oo == null || o000o002.O00000Oo.booleanValue();
                        this.f981O000000o.translate(f8, floor2);
                        if (!z2) {
                            this.f981O000000o.scale(o00O0o002.O0000o0O.O00000o0, o00O0o002.O0000o0O.O00000o);
                        }
                    }
                    boolean O0000O0o2 = O0000O0o();
                    for (SVG.O00OO0O O000000o7 : o000o002.O0000Oo0) {
                        O000000o(O000000o7);
                    }
                    if (O0000O0o2) {
                        O00000Oo((SVG.O00O0o00) o000o002);
                    }
                    O00000oO();
                }
            }
            O00000oO();
        }
    }

    private void O000000o(SVG.O000o00 o000o00, String str) {
        while (true) {
            SVG.O00OO0O O00000Oo2 = o000o00.O0000oOo.O00000Oo(str);
            if (O00000Oo2 == null) {
                O000000o("Pattern reference '%s' not found", str);
                return;
            } else if (!(O00000Oo2 instanceof SVG.O000o00)) {
                O00000Oo("Pattern href attributes must point to other pattern elements", new Object[0]);
                return;
            } else if (O00000Oo2 == o000o00) {
                O00000Oo("Circular reference in pattern href attribute '%s'", str);
                return;
            } else {
                SVG.O000o00 o000o002 = (SVG.O000o00) O00000Oo2;
                if (o000o00.f11884O000000o == null) {
                    o000o00.f11884O000000o = o000o002.f11884O000000o;
                }
                if (o000o00.O00000Oo == null) {
                    o000o00.O00000Oo = o000o002.O00000Oo;
                }
                if (o000o00.O00000o0 == null) {
                    o000o00.O00000o0 = o000o002.O00000o0;
                }
                if (o000o00.O00000o == null) {
                    o000o00.O00000o = o000o002.O00000o;
                }
                if (o000o00.O00000oO == null) {
                    o000o00.O00000oO = o000o002.O00000oO;
                }
                if (o000o00.O00000oo == null) {
                    o000o00.O00000oo = o000o002.O00000oo;
                }
                if (o000o00.O0000O0o == null) {
                    o000o00.O0000O0o = o000o002.O0000O0o;
                }
                if (o000o00.O0000Oo0.isEmpty()) {
                    o000o00.O0000Oo0 = o000o002.O0000Oo0;
                }
                if (o000o00.O0000ooO == null) {
                    o000o00.O0000ooO = o000o002.O0000ooO;
                }
                if (o000o00.O0000oo == null) {
                    o000o00.O0000oo = o000o002.O0000oo;
                }
                if (o000o002.O0000OOo != null) {
                    str = o000o002.O0000OOo;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0Oo0, boolean):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000OOOo, int]
     candidates:
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OO0O, _m_j.hyk$O0000Oo0):_m_j.hyk$O0000Oo0
      _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, com.xiaomi.smarthome.svg.SVG$O00O0o0):void
      _m_j.hyk.O000000o(_m_j.hyk$O0000Oo0, com.xiaomi.smarthome.svg.SVG$Style):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, _m_j.hyk$O00000Oo):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, com.xiaomi.smarthome.svg.SVG$O00O0o00):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, java.lang.String):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o00, android.graphics.Path):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o00, com.xiaomi.smarthome.svg.SVG$O000000o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, com.xiaomi.smarthome.svg.SVG$O00O0o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, com.xiaomi.smarthome.svg.SVG$O00OOo):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OoOO0, _m_j.hyk$O0000o00):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00OoOO0, java.lang.StringBuilder):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, java.lang.String):void
      _m_j.hyk.O000000o(java.lang.String, java.lang.Object[]):void
      _m_j.hyk.O000000o(boolean, com.xiaomi.smarthome.svg.SVG$O00O000o):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$Style, long):boolean
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG, com.xiaomi.smarthome.svg.PreserveAspectRatio):void
      _m_j.hyk.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0Oo0, boolean):void */
    private void O000000o(SVG.O000OOOo o000OOOo, SVG.O00O0o00 o00O0o00) {
        float f;
        float f2;
        O00000o0("Mask render", new Object[0]);
        boolean z = true;
        if (o000OOOo.f11880O000000o != null && o000OOOo.f11880O000000o.booleanValue()) {
            f2 = o000OOOo.O00000oO != null ? o000OOOo.O00000oO.O000000o(this) : o00O0o00.O0000o0O.O00000o0;
            f = o000OOOo.O00000oo != null ? o000OOOo.O00000oo.O00000Oo(this) : o00O0o00.O0000o0O.O00000o;
            if (o000OOOo.O00000o0 != null) {
                o000OOOo.O00000o0.O000000o(this);
            }
            if (o000OOOo.O00000o != null) {
                o000OOOo.O00000o.O00000Oo(this);
            }
        } else {
            if (o000OOOo.O00000o0 != null) {
                o000OOOo.O00000o0.O000000o(this, 1.0f);
            }
            if (o000OOOo.O00000o != null) {
                o000OOOo.O00000o.O000000o(this, 1.0f);
            }
            float f3 = 1.2f;
            float O000000o2 = o000OOOo.O00000oO != null ? o000OOOo.O00000oO.O000000o(this, 1.0f) : 1.2f;
            if (o000OOOo.O00000oo != null) {
                f3 = o000OOOo.O00000oo.O000000o(this, 1.0f);
            }
            f2 = O000000o2 * o00O0o00.O0000o0O.O00000o0;
            f = f3 * o00O0o00.O0000o0O.O00000o;
        }
        if (f2 != 0.0f && f != 0.0f) {
            O00000o();
            this.O00000o0 = O00000o0((SVG.O00OO0O) o000OOOo);
            this.O00000o0.f989O000000o.O0000o00 = Float.valueOf(1.0f);
            if (o000OOOo.O00000Oo != null && !o000OOOo.O00000Oo.booleanValue()) {
                z = false;
            }
            if (!z) {
                this.f981O000000o.translate(o00O0o00.O0000o0O.f11868O000000o, o00O0o00.O0000o0O.O00000Oo);
                this.f981O000000o.scale(o00O0o00.O0000o0O.O00000o0, o00O0o00.O0000o0O.O00000o);
            }
            O000000o((SVG.O00O0Oo0) o000OOOo, false);
            O00000oO();
        }
    }
}

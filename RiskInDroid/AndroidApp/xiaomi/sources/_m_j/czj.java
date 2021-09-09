package _m_j;

import _m_j.czi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;

public final class czj extends daf {
    protected static final Region O0000O0o = new Region();
    protected static final Region O0000OOo = new Region(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f14408O000000o = 1;
    protected int O00000Oo = 1;
    protected int O00000o = 0;
    protected int O00000o0 = 0;
    protected int O00000oO;
    protected int O00000oo;
    protected List<Integer> O0000Oo;
    protected List<Path> O0000Oo0;
    protected List<Path> O0000OoO;
    protected List<String> O0000Ooo;
    private Bitmap O0000o0;
    private boolean O0000o0O;

    private boolean O000000o() {
        Integer num;
        Integer num2;
        Integer num3;
        int i;
        int i2;
        int i3;
        int i4;
        List<Path> list = this.O0000Oo0;
        Integer num4 = null;
        if (list != null) {
            Integer num5 = null;
            num2 = null;
            num = null;
            for (Path path : list) {
                O0000O0o.setPath(path, O0000OOo);
                Rect bounds = O0000O0o.getBounds();
                num4 = Integer.valueOf(Math.min(num4 == null ? bounds.top : num4.intValue(), bounds.top));
                num5 = Integer.valueOf(Math.min(num5 == null ? bounds.left : num5.intValue(), bounds.left));
                num2 = Integer.valueOf(Math.max(num2 == null ? bounds.right : num2.intValue(), bounds.right));
                num = Integer.valueOf(Math.max(num == null ? bounds.bottom : num.intValue(), bounds.bottom));
            }
            num3 = num4;
            num4 = num5;
        } else {
            num3 = null;
            num2 = null;
            num = null;
        }
        if (num4 == null) {
            i = 0;
        } else {
            i = num4.intValue();
        }
        this.O00000o0 = i;
        if (num3 == null) {
            i2 = 0;
        } else {
            i2 = num3.intValue();
        }
        this.O00000o = i2;
        if (num2 == null) {
            i3 = 0;
        } else {
            i3 = num2.intValue() - this.O00000o0;
        }
        this.f14408O000000o = i3;
        if (num == null) {
            i4 = 0;
        } else {
            i4 = num.intValue() - this.O00000o;
        }
        this.O00000Oo = i4;
        if (this.O00000oO == 0) {
            this.O00000oO = this.f14408O000000o;
        }
        if (this.O00000oo == 0) {
            this.O00000oo = this.O00000Oo;
        }
        Rect bounds2 = getBounds();
        if (this.f14408O000000o == 0 || this.O00000Oo == 0) {
            if (this.O00000oO == 0) {
                this.O00000oO = 1;
            }
            if (this.O00000oo == 0) {
                this.O00000oo = 1;
            }
            this.O00000Oo = 1;
            this.f14408O000000o = 1;
            return false;
        }
        super.setBounds(bounds2.left, bounds2.top, bounds2.left + this.f14408O000000o, bounds2.top + this.O00000Oo);
        return true;
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        List<Path> list = this.O0000OoO;
        if (list == null || list.size() <= 0 || (i5 == this.f14408O000000o && i6 == this.O00000Oo)) {
            super.setBounds(i, i2, i3, i4);
            return;
        }
        int i7 = this.O00000o0;
        int i8 = this.O00000o;
        float f = (float) i5;
        float f2 = (f * 1.0f) / ((float) this.O00000oO);
        float f3 = (float) i6;
        float f4 = (f3 * 1.0f) / ((float) this.O00000oo);
        List<Path> list2 = this.O0000OoO;
        List<String> list3 = this.O0000Ooo;
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f4);
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT > 16) {
            for (Path transform : list2) {
                Path path = new Path();
                transform.transform(matrix, path);
                arrayList.add(path);
            }
        } else {
            for (String O00000Oo2 : list3) {
                Path path2 = new Path();
                czi.O00000Oo[] O00000Oo3 = czi.O00000Oo(O00000Oo2);
                czi.O000000o(f2, f4, O00000Oo3);
                czi.O00000Oo.O000000o(O00000Oo3, path2);
                arrayList.add(path2);
            }
        }
        this.O0000Oo0 = arrayList;
        if (!O000000o()) {
            this.f14408O000000o = i5;
            this.O00000Oo = i6;
            this.O00000o0 = (int) (((((float) i7) * 1.0f) * f) / ((float) this.O00000oO));
            this.O00000o = (int) (((((float) i8) * 1.0f) * f3) / ((float) this.O00000oo));
            super.setBounds(i, i2, i3, i4);
        }
    }

    public final void setBounds(Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final boolean O000000o(String... strArr) {
        this.O00000oo = 0;
        this.O00000oO = 0;
        this.O0000Ooo = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.O0000OoO = arrayList;
        this.O0000Oo0 = arrayList;
        for (String str : strArr) {
            this.O0000Ooo.add(str);
            this.O0000OoO.add(czi.O000000o(str));
        }
        return O000000o();
    }

    public final void O000000o(int i, int i2, int i3, int i4) {
        this.O00000o0 = i;
        this.O00000o = i2;
        this.f14408O000000o = i3;
        this.O00000oO = i3;
        this.O00000Oo = i4;
        this.O00000oo = i4;
        Rect bounds = getBounds();
        super.setBounds(bounds.left, bounds.top, bounds.left + i3, bounds.top + i4);
    }

    public final void O000000o(int... iArr) {
        this.O0000Oo = new ArrayList();
        for (int valueOf : iArr) {
            this.O0000Oo.add(Integer.valueOf(valueOf));
        }
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (this.O0000o00.getAlpha() == 255) {
            canvas.save();
            canvas.translate((float) (bounds.left - this.O00000o0), (float) (bounds.top - this.O00000o));
            if (this.O0000Oo0 != null) {
                for (int i = 0; i < this.O0000Oo0.size(); i++) {
                    List<Integer> list = this.O0000Oo;
                    if (list != null && i < list.size()) {
                        this.O0000o00.setColor(this.O0000Oo.get(i).intValue());
                    }
                    canvas.drawPath(this.O0000Oo0.get(i), this.O0000o00);
                }
                this.O0000o00.setAlpha(255);
            }
            canvas.restore();
            return;
        }
        Bitmap bitmap = this.O0000o0;
        if (!(bitmap != null && width == bitmap.getWidth() && height == this.O0000o0.getHeight())) {
            this.O0000o0 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            this.O0000o0O = true;
        }
        if (this.O0000o0O) {
            this.O0000o0.eraseColor(0);
            O000000o(new Canvas(this.O0000o0));
            this.O0000o0O = false;
        }
        canvas.drawBitmap(this.O0000o0, (float) bounds.left, (float) bounds.top, this.O0000o00);
    }

    public final void O000000o(int i) {
        Rect bounds = getBounds();
        float width = (((float) i) * 1.0f) / ((float) bounds.width());
        setBounds((int) (((float) bounds.left) * width), (int) (((float) bounds.top) * width), (int) (((float) bounds.right) * width), (int) (((float) bounds.bottom) * width));
    }

    private void O000000o(Canvas canvas) {
        canvas.translate((float) (-this.O00000o0), (float) (-this.O00000o));
        if (this.O0000Oo0 != null) {
            for (int i = 0; i < this.O0000Oo0.size(); i++) {
                List<Integer> list = this.O0000Oo;
                if (list != null && i < list.size()) {
                    this.O0000o00.setColor(this.O0000Oo.get(i).intValue());
                }
                canvas.drawPath(this.O0000Oo0.get(i), this.O0000o00);
            }
        }
    }
}

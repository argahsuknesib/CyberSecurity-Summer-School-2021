package _m_j;

import _m_j.vf;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class vf<T extends vf<T>> implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f2547O000000o = 1.0f;
    protected uv O00000Oo;
    protected int O00000o;
    public Drawable O00000o0;
    public Drawable O00000oO;
    protected int O00000oo;
    protected int O0000O0o = -1;
    protected int O0000OOo = -1;
    private boolean O0000Oo = true;
    protected Map<Class<?>, uu<?>> O0000Oo0 = new HashMap();
    private Priority O0000OoO = Priority.NORMAL;
    private ur O0000Ooo = vn.O000000o();
    private boolean O0000o0 = true;
    private Class<?> O0000o00 = Object.class;
    private int O0000o0O;
    private ut O0000o0o = new ut();

    public final T O000000o() {
        this.O0000o0O = 1;
        this.O0000Oo0.clear();
        return this;
    }

    public final boolean O00000Oo() {
        return this.O0000o0O == 1;
    }

    public final boolean O00000o0() {
        return this.O0000o0O == 2;
    }

    public final boolean O00000o() {
        return this.O0000o0O == 3;
    }

    public final boolean O00000oO() {
        return this.O0000o0O == 4;
    }

    public final T O000000o(Drawable drawable) {
        this.O00000oO = drawable;
        return this;
    }

    public final T O000000o(int i) {
        this.O00000oo = i;
        return this;
    }

    public final T O00000Oo(Drawable drawable) {
        this.O00000o0 = drawable;
        return this;
    }

    public final T O00000Oo(int i) {
        this.O00000o = i;
        return this;
    }

    private T O000000o(int i, int i2) {
        this.O0000OOo = i;
        this.O0000O0o = i2;
        return this;
    }

    public final T O00000o0(int i) {
        return O000000o(i, i);
    }

    public final T O000000o(uu<Bitmap> uuVar) {
        if (uuVar instanceof us) {
            Iterator<? extends uu> it = ((us) uuVar).O00000Oo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                uu uuVar2 = (uu) it.next();
                if (!(uuVar2 instanceof vd)) {
                    if (!(uuVar2 instanceof va)) {
                        if (!(uuVar2 instanceof vb)) {
                            if (uuVar2 instanceof vc) {
                                this.O0000o0O = 1;
                                break;
                            }
                        } else {
                            this.O0000o0O = 4;
                            break;
                        }
                    } else {
                        this.O0000o0O = 2;
                        break;
                    }
                } else {
                    this.O0000o0O = 3;
                    break;
                }
            }
        }
        this.O0000Oo0.put(Bitmap.class, uuVar);
        return this;
    }

    public final uv O00000oo() {
        return this.O00000Oo;
    }

    public final T O000000o(uv uvVar) {
        this.O00000Oo = uvVar;
        return this;
    }

    public T O00000Oo(vf<?> vfVar) {
        int i;
        int i2 = vfVar.O00000oo;
        if (i2 != -1) {
            this.O00000oo = i2;
        }
        Drawable drawable = vfVar.O00000oO;
        if (drawable != null) {
            this.O00000oO = drawable;
        }
        int i3 = vfVar.O00000o;
        if (i3 != -1) {
            this.O00000o = i3;
        }
        Drawable drawable2 = vfVar.O00000o0;
        if (drawable2 != null) {
            this.O00000o0 = drawable2;
        }
        if (vfVar.O00000Oo()) {
            this.O0000o0O = 1;
        } else if (vfVar.O00000o0()) {
            this.O0000o0O = 2;
        } else if (vfVar.O00000o()) {
            this.O0000o0O = 3;
        } else if (vfVar.O00000oO()) {
            this.O0000o0O = 4;
        }
        if (vfVar.O0000Oo0.size() > 0) {
            this.O0000Oo0 = vfVar.O0000Oo0;
        }
        int i4 = vfVar.O0000OOo;
        if (!(i4 == -1 || (i = vfVar.O0000O0o) == -1)) {
            O000000o(i4, i);
        }
        if (vfVar.O00000Oo == uv.O00000Oo) {
            this.O00000Oo = uv.O00000Oo;
        } else {
            this.O00000Oo = uv.f2544O000000o;
        }
        return this;
    }
}

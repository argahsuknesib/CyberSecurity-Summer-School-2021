package _m_j;

import android.database.Cursor;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class bpy {

    /* renamed from: O000000o  reason: collision with root package name */
    public bqe f13191O000000o;
    public int O00000Oo = -1;
    protected final Method O00000o;
    protected final String O00000o0;
    protected final Method O00000oO;
    protected final Field O00000oo;
    protected final bph O0000O0o;
    private final Object O0000OOo;

    bpy(Class<?> cls, Field field) {
        this.O00000oo = field;
        this.O0000O0o = bpi.O000000o(field.getType());
        this.O00000o0 = bpz.O000000o(field);
        bph bph = this.O0000O0o;
        if (bph != null) {
            this.O0000OOo = bph.O000000o(bpz.O00000o0(field));
        } else {
            this.O0000OOo = null;
        }
        this.O00000o = bpz.O000000o(cls, field);
        this.O00000oO = bpz.O00000Oo(cls, field);
    }

    public void O000000o(Object obj, Cursor cursor, int i) {
        this.O00000Oo = i;
        Object O000000o2 = this.O0000O0o.O000000o(cursor, i);
        if (O000000o2 != null || this.O0000OOo != null) {
            Method method = this.O00000oO;
            if (method != null) {
                try {
                    Object[] objArr = new Object[1];
                    if (O000000o2 == null) {
                        O000000o2 = this.O0000OOo;
                    }
                    objArr[0] = O000000o2;
                    method.invoke(obj, objArr);
                } catch (Throwable th) {
                    brm.O000000o(th.getMessage(), th);
                }
            } else {
                try {
                    this.O00000oo.setAccessible(true);
                    Field field = this.O00000oo;
                    if (O000000o2 == null) {
                        O000000o2 = this.O0000OOo;
                    }
                    field.set(obj, O000000o2);
                } catch (Throwable th2) {
                    brm.O000000o(th2.getMessage(), th2);
                }
            }
        }
    }

    public Object O000000o(Object obj) {
        return this.O0000O0o.O000000o(O00000Oo(obj));
    }

    public final Object O00000Oo(Object obj) {
        if (obj != null) {
            Method method = this.O00000o;
            if (method != null) {
                try {
                    return method.invoke(obj, new Object[0]);
                } catch (Throwable th) {
                    brm.O000000o(th.getMessage(), th);
                }
            } else {
                try {
                    this.O00000oo.setAccessible(true);
                    return this.O00000oo.get(obj);
                } catch (Throwable th2) {
                    brm.O000000o(th2.getMessage(), th2);
                }
            }
        }
        return null;
    }

    public final String O000000o() {
        return this.O00000o0;
    }

    public Object O00000Oo() {
        return this.O0000OOo;
    }

    public final Field O00000o0() {
        return this.O00000oo;
    }

    public final bph O00000o() {
        return this.O0000O0o;
    }

    public ColumnDbType O00000oO() {
        return this.O0000O0o.O000000o();
    }
}

package _m_j;

import android.database.Cursor;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import com.lidroid.xutils.exception.DbException;
import java.lang.reflect.Field;
import java.util.List;

public final class bqb extends bpy {
    public final String O0000OOo;
    private final bph O0000Oo0 = bpi.O000000o(bqf.O000000o(bpz.O000000o(this), this.O0000OOo).O00000oo.getType());

    public final Object O00000Oo() {
        return null;
    }

    bqb(Class<?> cls, Field field) {
        super(cls, field);
        this.O0000OOo = bpz.O00000Oo(field);
    }

    public final void O000000o(Object obj, Cursor cursor, int i) {
        Object O000000o2;
        Object O000000o3 = this.O0000Oo0.O000000o(cursor, i);
        if (O000000o3 != null) {
            Class<?> type = this.O00000oo.getType();
            Object obj2 = null;
            if (type.equals(bpt.class)) {
                obj2 = new bpt(this, O000000o3);
            } else {
                if (type.equals(List.class)) {
                    try {
                        bpt bpt = new bpt(this, O000000o3);
                        bqe bqe = bpt.f13186O000000o.f13191O000000o;
                        if (bqe != null) {
                            O000000o2 = bqe.f13194O000000o.O00000Oo(bpu.O000000o(bpz.O000000o(bpt.f13186O000000o)).O000000o(bpt.f13186O000000o.O0000OOo, "=", bpt.O00000Oo));
                        }
                    } catch (DbException e) {
                        brm.O000000o(e.getMessage(), e);
                    }
                } else {
                    try {
                        bpt bpt2 = new bpt(this, O000000o3);
                        bqe bqe2 = bpt2.f13186O000000o.f13191O000000o;
                        if (bqe2 != null) {
                            O000000o2 = bqe2.f13194O000000o.O000000o(bpu.O000000o(bpz.O000000o(bpt2.f13186O000000o)).O000000o(bpt2.f13186O000000o.O0000OOo, "=", bpt2.O00000Oo));
                        }
                    } catch (DbException e2) {
                        brm.O000000o(e2.getMessage(), e2);
                    }
                }
                obj2 = O000000o2;
            }
            if (this.O00000oO != null) {
                try {
                    this.O00000oO.invoke(obj, obj2);
                } catch (Throwable th) {
                    brm.O000000o(th.getMessage(), th);
                }
            } else {
                try {
                    this.O00000oo.setAccessible(true);
                    this.O00000oo.set(obj, obj2);
                } catch (Throwable th2) {
                    brm.O000000o(th2.getMessage(), th2);
                }
            }
        }
    }

    public final Object O000000o(Object obj) {
        Object O00000Oo = O00000Oo(obj);
        if (O00000Oo == null) {
            return null;
        }
        Class<?> type = this.O00000oo.getType();
        if (type.equals(bpt.class)) {
            return ((bpt) O00000Oo).O00000Oo;
        }
        if (type.equals(List.class)) {
            try {
                List list = (List) O00000Oo;
                if (list.size() <= 0) {
                    return null;
                }
                bpy O000000o2 = bqf.O000000o(bpz.O000000o(this), this.O0000OOo);
                Object O000000o3 = O000000o2.O000000o(list.get(0));
                bqe bqe = this.f13191O000000o;
                if (bqe != null && (O000000o2 instanceof bqc)) {
                    for (Object next : list) {
                        if (O000000o2.O000000o(next) == null) {
                            bqe.f13194O000000o.O000000o(next);
                        }
                    }
                }
                return O000000o2.O000000o(list.get(0));
            } catch (Throwable th) {
                brm.O000000o(th.getMessage(), th);
                return null;
            }
        } else {
            try {
                bpy O000000o4 = bqf.O000000o(type, this.O0000OOo);
                Object O000000o5 = O000000o4.O000000o(O00000Oo);
                bqe bqe2 = this.f13191O000000o;
                if (bqe2 != null && O000000o5 == null && (O000000o4 instanceof bqc)) {
                    bqe2.f13194O000000o.O000000o(O00000Oo);
                }
                return O000000o4.O000000o(O00000Oo);
            } catch (Throwable th2) {
                brm.O000000o(th2.getMessage(), th2);
                return null;
            }
        }
    }

    public final ColumnDbType O00000oO() {
        return this.O0000Oo0.O000000o();
    }
}

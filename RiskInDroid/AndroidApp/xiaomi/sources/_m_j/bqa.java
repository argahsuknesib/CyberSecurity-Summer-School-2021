package _m_j;

import android.database.Cursor;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import com.lidroid.xutils.exception.DbException;
import java.lang.reflect.Field;
import java.util.List;

public final class bqa extends bpy {
    public final String O0000OOo;
    private final String O0000Oo0;

    public final Object O000000o(Object obj) {
        return null;
    }

    public final Object O00000Oo() {
        return null;
    }

    bqa(Class<?> cls, Field field) {
        super(cls, field);
        bov bov = (bov) field.getAnnotation(bov.class);
        this.O0000Oo0 = bov.O000000o();
        this.O0000OOo = bov.O00000Oo();
    }

    public final void O000000o(Object obj, Cursor cursor, int i) {
        Object O000000o2;
        Class<?> type = this.O00000oo.getType();
        Object O000000o3 = bqf.O000000o(obj.getClass(), this.O0000Oo0).O000000o(obj);
        Object obj2 = null;
        if (type.equals(bps.class)) {
            obj2 = new bps(this, O000000o3);
        } else {
            if (type.equals(List.class)) {
                try {
                    bps bps = new bps(this, O000000o3);
                    bqe bqe = bps.f13185O000000o.f13191O000000o;
                    if (bqe != null) {
                        O000000o2 = bqe.f13194O000000o.O00000Oo(bpu.O000000o(bpz.O000000o(bps.f13185O000000o)).O000000o(bps.f13185O000000o.O0000OOo, "=", bps.O00000Oo));
                    }
                } catch (DbException e) {
                    brm.O000000o(e.getMessage(), e);
                }
            } else {
                try {
                    bps bps2 = new bps(this, O000000o3);
                    bqe bqe2 = bps2.f13185O000000o.f13191O000000o;
                    if (bqe2 != null) {
                        O000000o2 = bqe2.f13194O000000o.O000000o(bpu.O000000o(bpz.O000000o(bps2.f13185O000000o)).O000000o(bps2.f13185O000000o.O0000OOo, "=", bps2.O00000Oo));
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

    public final ColumnDbType O00000oO() {
        return ColumnDbType.TEXT;
    }
}

package _m_j;

import java.lang.reflect.Field;
import java.util.HashSet;

public final class bqc extends bpy {
    private static final HashSet<String> O0000OoO = new HashSet<>(2);
    private static final HashSet<String> O0000Ooo = new HashSet<>(4);
    private String O0000OOo = this.O00000oo.getType().getName();
    private boolean O0000Oo = false;
    private boolean O0000Oo0 = false;

    bqc(Class<?> cls, Field field) {
        super(cls, field);
    }

    public final boolean O00000oo() {
        if (!this.O0000Oo0) {
            boolean z = true;
            this.O0000Oo0 = true;
            if (this.O00000oo.getAnnotation(boy.class) != null || !O0000Ooo.contains(this.O0000OOo)) {
                z = false;
            }
            this.O0000Oo = z;
        }
        return this.O0000Oo;
    }

    public final void O000000o(Object obj, long j) {
        Object valueOf = Long.valueOf(j);
        if (O0000OoO.contains(this.O0000OOo)) {
            valueOf = Integer.valueOf((int) j);
        }
        if (this.O00000oO != null) {
            try {
                this.O00000oO.invoke(obj, valueOf);
            } catch (Throwable th) {
                brm.O000000o(th.getMessage(), th);
            }
        } else {
            try {
                this.O00000oo.setAccessible(true);
                this.O00000oo.set(obj, valueOf);
            } catch (Throwable th2) {
                brm.O000000o(th2.getMessage(), th2);
            }
        }
    }

    public final Object O000000o(Object obj) {
        Object O000000o2 = super.O000000o(obj);
        if (O000000o2 == null) {
            return null;
        }
        if (!O00000oo() || (!O000000o2.equals(0) && !O000000o2.equals(0L))) {
            return O000000o2;
        }
        return null;
    }

    static {
        O0000OoO.add(Integer.TYPE.getName());
        O0000OoO.add(Integer.class.getName());
        O0000Ooo.addAll(O0000OoO);
        O0000Ooo.add(Long.TYPE.getName());
        O0000Ooo.add(Long.class.getName());
    }
}

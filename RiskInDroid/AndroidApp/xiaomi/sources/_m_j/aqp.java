package _m_j;

import com.fasterxml.jackson.databind.JsonMappingException;

public abstract class aqp {
    public abstract ajz<Object> O000000o(Class<?> cls);

    public abstract aqp O000000o(Class<?> cls, ajz<Object> ajz);

    public final O00000o O000000o(Class<?> cls, akf akf, ajr ajr) throws JsonMappingException {
        ajz<Object> O000000o2 = akf.O000000o(cls, ajr);
        return new O00000o(O000000o2, O000000o(cls, O000000o2));
    }

    public final O00000o O000000o(ajv ajv, akf akf, ajr ajr) throws JsonMappingException {
        ajz<Object> O000000o2 = akf.O000000o(ajv, ajr);
        return new O00000o(O000000o2, O000000o(ajv.O00000Oo(), O000000o2));
    }

    public static aqp O000000o() {
        return O00000Oo.f12529O000000o;
    }

    public static final class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final ajz<Object> f12530O000000o;
        public final aqp O00000Oo;

        public O00000o(ajz<Object> ajz, aqp aqp) {
            this.f12530O000000o = ajz;
            this.O00000Oo = aqp;
        }
    }

    static final class O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Class<?> f12533O000000o;
        public final ajz<Object> O00000Oo;

        public O0000OOo(Class<?> cls, ajz<Object> ajz) {
            this.f12533O000000o = cls;
            this.O00000Oo = ajz;
        }
    }

    static final class O00000Oo extends aqp {

        /* renamed from: O000000o  reason: collision with root package name */
        protected static final O00000Oo f12529O000000o = new O00000Oo();

        public final ajz<Object> O000000o(Class<?> cls) {
            return null;
        }

        private O00000Oo() {
        }

        public final aqp O000000o(Class<?> cls, ajz<Object> ajz) {
            return new O0000O0o(cls, ajz);
        }
    }

    static final class O0000O0o extends aqp {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Class<?> f12532O000000o;
        private final ajz<Object> O00000Oo;

        public O0000O0o(Class<?> cls, ajz<Object> ajz) {
            this.f12532O000000o = cls;
            this.O00000Oo = ajz;
        }

        public final ajz<Object> O000000o(Class<?> cls) {
            if (cls == this.f12532O000000o) {
                return this.O00000Oo;
            }
            return null;
        }

        public final aqp O000000o(Class<?> cls, ajz<Object> ajz) {
            return new O000000o(this.f12532O000000o, this.O00000Oo, cls, ajz);
        }
    }

    static final class O000000o extends aqp {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Class<?> f12528O000000o;
        private final Class<?> O00000Oo;
        private final ajz<Object> O00000o;
        private final ajz<Object> O00000o0;

        public O000000o(Class<?> cls, ajz<Object> ajz, Class<?> cls2, ajz<Object> ajz2) {
            this.f12528O000000o = cls;
            this.O00000o0 = ajz;
            this.O00000Oo = cls2;
            this.O00000o = ajz2;
        }

        public final ajz<Object> O000000o(Class<?> cls) {
            if (cls == this.f12528O000000o) {
                return this.O00000o0;
            }
            if (cls == this.O00000Oo) {
                return this.O00000o;
            }
            return null;
        }

        public final aqp O000000o(Class<?> cls, ajz<Object> ajz) {
            return new O00000o0(new O0000OOo[]{new O0000OOo(this.f12528O000000o, this.O00000o0), new O0000OOo(this.O00000Oo, this.O00000o)});
        }
    }

    static final class O00000o0 extends aqp {

        /* renamed from: O000000o  reason: collision with root package name */
        private final O0000OOo[] f12531O000000o;

        public O00000o0(O0000OOo[] o0000OOoArr) {
            this.f12531O000000o = o0000OOoArr;
        }

        public final ajz<Object> O000000o(Class<?> cls) {
            for (O0000OOo o0000OOo : this.f12531O000000o) {
                if (o0000OOo.f12533O000000o == cls) {
                    return o0000OOo.O00000Oo;
                }
            }
            return null;
        }

        public final aqp O000000o(Class<?> cls, ajz<Object> ajz) {
            O0000OOo[] o0000OOoArr = this.f12531O000000o;
            int length = o0000OOoArr.length;
            if (length == 8) {
                return this;
            }
            O0000OOo[] o0000OOoArr2 = new O0000OOo[(length + 1)];
            System.arraycopy(o0000OOoArr, 0, o0000OOoArr2, 0, length);
            o0000OOoArr2[length] = new O0000OOo(cls, ajz);
            return new O00000o0(o0000OOoArr2);
        }
    }
}

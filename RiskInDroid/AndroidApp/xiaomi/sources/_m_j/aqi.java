package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;

public abstract class aqi {
    public static apt O000000o(apt apt, Class<?>[] clsArr) {
        if (clsArr.length == 1) {
            return new O00000Oo(apt, clsArr[0]);
        }
        return new O000000o(apt, clsArr);
    }

    static final class O00000Oo extends apt {
        protected final Class<?> O0000oO;
        protected final apt O0000oO0;

        protected O00000Oo(apt apt, Class<?> cls) {
            super(apt);
            this.O0000oO0 = apt;
            this.O0000oO = cls;
        }

        public final void O000000o(ajz<Object> ajz) {
            this.O0000oO0.O000000o(ajz);
        }

        public final void O00000Oo(ajz<Object> ajz) {
            this.O0000oO0.O00000Oo(ajz);
        }

        public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws Exception {
            Class<?> O00000o = akf.O00000o();
            if (O00000o == null || this.O0000oO.isAssignableFrom(O00000o)) {
                this.O0000oO0.O000000o(obj, jsonGenerator, akf);
            }
        }

        public final /* synthetic */ apt O000000o(atb atb) {
            return new O00000Oo(this.O0000oO0.O000000o(atb), this.O0000oO);
        }
    }

    static final class O000000o extends apt {
        protected final Class<?>[] O0000oO;
        protected final apt O0000oO0;

        protected O000000o(apt apt, Class<?>[] clsArr) {
            super(apt);
            this.O0000oO0 = apt;
            this.O0000oO = clsArr;
        }

        public final void O000000o(ajz<Object> ajz) {
            this.O0000oO0.O000000o(ajz);
        }

        public final void O00000Oo(ajz<Object> ajz) {
            this.O0000oO0.O00000Oo(ajz);
        }

        public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws Exception {
            Class<?> O00000o = akf.O00000o();
            if (O00000o != null) {
                int i = 0;
                int length = this.O0000oO.length;
                while (i < length && !this.O0000oO[i].isAssignableFrom(O00000o)) {
                    i++;
                }
                if (i == length) {
                    return;
                }
            }
            this.O0000oO0.O000000o(obj, jsonGenerator, akf);
        }

        public final /* synthetic */ apt O000000o(atb atb) {
            return new O000000o(this.O0000oO0.O000000o(atb), this.O0000oO);
        }
    }
}

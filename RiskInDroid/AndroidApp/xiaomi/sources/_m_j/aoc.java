package _m_j;

import _m_j.aoc;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

public interface aoc<T extends aoc<T>> {
    T O000000o(JsonAutoDetect.Visibility visibility);

    T O000000o(JsonAutoDetect jsonAutoDetect);

    boolean O000000o(anl anl);

    boolean O000000o(anm anm);

    boolean O000000o(ann ann);

    T O00000Oo(JsonAutoDetect.Visibility visibility);

    boolean O00000Oo(ann ann);

    T O00000o(JsonAutoDetect.Visibility visibility);

    T O00000o0(JsonAutoDetect.Visibility visibility);

    boolean O00000o0(ann ann);

    T O00000oO(JsonAutoDetect.Visibility visibility);

    @JsonAutoDetect(O000000o = JsonAutoDetect.Visibility.PUBLIC_ONLY, O00000Oo = JsonAutoDetect.Visibility.PUBLIC_ONLY, O00000o = JsonAutoDetect.Visibility.ANY, O00000o0 = JsonAutoDetect.Visibility.ANY, O00000oO = JsonAutoDetect.Visibility.PUBLIC_ONLY)
    public static class O000000o implements aoc<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        protected static final O000000o f12500O000000o = new O000000o((JsonAutoDetect) O000000o.class.getAnnotation(JsonAutoDetect.class));
        protected final JsonAutoDetect.Visibility O00000Oo;
        protected final JsonAutoDetect.Visibility O00000o;
        protected final JsonAutoDetect.Visibility O00000o0;
        protected final JsonAutoDetect.Visibility O00000oO;
        protected final JsonAutoDetect.Visibility O00000oo;

        public static O000000o O000000o() {
            return f12500O000000o;
        }

        private O000000o(JsonAutoDetect jsonAutoDetect) {
            this.O00000Oo = jsonAutoDetect.O000000o();
            this.O00000o0 = jsonAutoDetect.O00000Oo();
            this.O00000o = jsonAutoDetect.O00000o0();
            this.O00000oO = jsonAutoDetect.O00000o();
            this.O00000oo = jsonAutoDetect.O00000oO();
        }

        private O000000o(JsonAutoDetect.Visibility visibility, JsonAutoDetect.Visibility visibility2, JsonAutoDetect.Visibility visibility3, JsonAutoDetect.Visibility visibility4, JsonAutoDetect.Visibility visibility5) {
            this.O00000Oo = visibility;
            this.O00000o0 = visibility2;
            this.O00000o = visibility3;
            this.O00000oO = visibility4;
            this.O00000oo = visibility5;
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000oo */
        public O000000o O000000o(JsonAutoDetect.Visibility visibility) {
            if (visibility == JsonAutoDetect.Visibility.DEFAULT) {
                visibility = f12500O000000o.O00000Oo;
            }
            JsonAutoDetect.Visibility visibility2 = visibility;
            if (this.O00000Oo == visibility2) {
                return this;
            }
            return new O000000o(visibility2, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo);
        }

        /* access modifiers changed from: private */
        /* renamed from: O0000O0o */
        public O000000o O00000Oo(JsonAutoDetect.Visibility visibility) {
            if (visibility == JsonAutoDetect.Visibility.DEFAULT) {
                visibility = f12500O000000o.O00000o0;
            }
            JsonAutoDetect.Visibility visibility2 = visibility;
            if (this.O00000o0 == visibility2) {
                return this;
            }
            return new O000000o(this.O00000Oo, visibility2, this.O00000o, this.O00000oO, this.O00000oo);
        }

        /* access modifiers changed from: private */
        /* renamed from: O0000OOo */
        public O000000o O00000o0(JsonAutoDetect.Visibility visibility) {
            if (visibility == JsonAutoDetect.Visibility.DEFAULT) {
                visibility = f12500O000000o.O00000o;
            }
            JsonAutoDetect.Visibility visibility2 = visibility;
            if (this.O00000o == visibility2) {
                return this;
            }
            return new O000000o(this.O00000Oo, this.O00000o0, visibility2, this.O00000oO, this.O00000oo);
        }

        /* access modifiers changed from: private */
        /* renamed from: O0000Oo0 */
        public O000000o O00000o(JsonAutoDetect.Visibility visibility) {
            if (visibility == JsonAutoDetect.Visibility.DEFAULT) {
                visibility = f12500O000000o.O00000oO;
            }
            JsonAutoDetect.Visibility visibility2 = visibility;
            if (this.O00000oO == visibility2) {
                return this;
            }
            return new O000000o(this.O00000Oo, this.O00000o0, this.O00000o, visibility2, this.O00000oo);
        }

        /* access modifiers changed from: private */
        /* renamed from: O0000Oo */
        public O000000o O00000oO(JsonAutoDetect.Visibility visibility) {
            if (visibility == JsonAutoDetect.Visibility.DEFAULT) {
                visibility = f12500O000000o.O00000oo;
            }
            JsonAutoDetect.Visibility visibility2 = visibility;
            if (this.O00000oo == visibility2) {
                return this;
            }
            return new O000000o(this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, visibility2);
        }

        public final boolean O000000o(anm anm) {
            return this.O00000oO.isVisible(anm.O0000OoO());
        }

        public final boolean O000000o(anl anl) {
            return this.O00000oo.isVisible(anl.O00000oo());
        }

        public final boolean O000000o(ann ann) {
            return this.O00000Oo.isVisible(ann.O00000oo());
        }

        public final boolean O00000Oo(ann ann) {
            return this.O00000o0.isVisible(ann.O00000oo());
        }

        public final boolean O00000o0(ann ann) {
            return this.O00000o.isVisible(ann.O00000oo());
        }

        public String toString() {
            return "[Visibility: getter: " + this.O00000Oo + ", isGetter: " + this.O00000o0 + ", setter: " + this.O00000o + ", creator: " + this.O00000oO + ", field: " + this.O00000oo + "]";
        }

        public final /* synthetic */ aoc O000000o(JsonAutoDetect jsonAutoDetect) {
            return jsonAutoDetect != null ? O000000o(jsonAutoDetect.O000000o()).O00000Oo(jsonAutoDetect.O00000Oo()).O00000o0(jsonAutoDetect.O00000o0()).O00000o(jsonAutoDetect.O00000o()).O00000oO(jsonAutoDetect.O00000oO()) : this;
        }
    }
}

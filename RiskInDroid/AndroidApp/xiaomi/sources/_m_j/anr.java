package _m_j;

import java.lang.annotation.Annotation;
import java.util.HashMap;

public final class anr implements ast {

    /* renamed from: O000000o  reason: collision with root package name */
    protected HashMap<Class<? extends Annotation>, Annotation> f12488O000000o;

    public anr() {
    }

    private anr(HashMap<Class<? extends Annotation>, Annotation> hashMap) {
        this.f12488O000000o = hashMap;
    }

    public final <A extends Annotation> A O000000o(Class cls) {
        HashMap<Class<? extends Annotation>, Annotation> hashMap = this.f12488O000000o;
        if (hashMap == null) {
            return null;
        }
        return (Annotation) hashMap.get(cls);
    }

    public static anr O000000o(anr anr, anr anr2) {
        HashMap<Class<? extends Annotation>, Annotation> hashMap;
        HashMap<Class<? extends Annotation>, Annotation> hashMap2;
        if (anr == null || (hashMap = anr.f12488O000000o) == null || hashMap.isEmpty()) {
            return anr2;
        }
        if (anr2 == null || (hashMap2 = anr2.f12488O000000o) == null || hashMap2.isEmpty()) {
            return anr;
        }
        HashMap hashMap3 = new HashMap();
        for (Annotation next : anr2.f12488O000000o.values()) {
            hashMap3.put(next.annotationType(), next);
        }
        for (Annotation next2 : anr.f12488O000000o.values()) {
            hashMap3.put(next2.annotationType(), next2);
        }
        return new anr(hashMap3);
    }

    public final int O000000o() {
        HashMap<Class<? extends Annotation>, Annotation> hashMap = this.f12488O000000o;
        if (hashMap == null) {
            return 0;
        }
        return hashMap.size();
    }

    public final void O000000o(Annotation annotation) {
        HashMap<Class<? extends Annotation>, Annotation> hashMap = this.f12488O000000o;
        if (hashMap == null || !hashMap.containsKey(annotation.annotationType())) {
            O00000o0(annotation);
        }
    }

    public final void O00000Oo(Annotation annotation) {
        O00000o0(annotation);
    }

    public final String toString() {
        HashMap<Class<? extends Annotation>, Annotation> hashMap = this.f12488O000000o;
        if (hashMap == null) {
            return "[null]";
        }
        return hashMap.toString();
    }

    private void O00000o0(Annotation annotation) {
        if (this.f12488O000000o == null) {
            this.f12488O000000o = new HashMap<>();
        }
        this.f12488O000000o.put(annotation.annotationType(), annotation);
    }
}

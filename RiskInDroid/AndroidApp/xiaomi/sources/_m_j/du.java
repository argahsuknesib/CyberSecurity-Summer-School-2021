package _m_j;

public abstract class du<T> {
    final String mPropertyName;

    public abstract float getValue(Object obj);

    public abstract void setValue(Object obj, float f);

    public du(String str) {
        this.mPropertyName = str;
    }

    public static <T> du<T> createFloatPropertyCompat(final O0OOo<T> o0OOo) {
        return new du<T>(o0OOo.getName()) {
            /* class _m_j.du.AnonymousClass1 */

            public final void setValue(T t, float f) {
            }

            public final float getValue(T t) {
                return ((Float) o0OOo.get(t)).floatValue();
            }
        };
    }
}

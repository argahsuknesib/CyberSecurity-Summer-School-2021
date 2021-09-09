package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

@GwtCompatible(emulated = true)
public final class Predicates {

    enum ObjectPredicate implements Predicate<Object> {
        ALWAYS_TRUE {
            public final boolean apply(Object obj) {
                return true;
            }

            public final String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE {
            public final boolean apply(Object obj) {
                return false;
            }

            public final String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL {
            public final boolean apply(Object obj) {
                return obj == null;
            }

            public final String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL {
            public final boolean apply(Object obj) {
                return obj != null;
            }

            public final String toString() {
                return "Predicates.notNull()";
            }
        };

        /* access modifiers changed from: package-private */
        public <T> Predicate<T> withNarrowedType() {
            return this;
        }
    }

    private Predicates() {
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysTrue() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysFalse() {
        return ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> isNull() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> notNull() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return new NotPredicate(predicate);
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> iterable) {
        return new AndPredicate(defensiveCopy(iterable));
    }

    @SafeVarargs
    public static <T> Predicate<T> and(Predicate<? super T>... predicateArr) {
        return new AndPredicate(defensiveCopy(predicateArr));
    }

    public static <T> Predicate<T> and(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new AndPredicate(asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }

    public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> iterable) {
        return new OrPredicate(defensiveCopy(iterable));
    }

    @SafeVarargs
    public static <T> Predicate<T> or(Predicate<? super T>... predicateArr) {
        return new OrPredicate(defensiveCopy(predicateArr));
    }

    public static <T> Predicate<T> or(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new OrPredicate(asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }

    public static <T> Predicate<T> equalTo(T t) {
        return t == null ? isNull() : new IsEqualToPredicate(t);
    }

    @GwtIncompatible
    public static Predicate<Object> instanceOf(Class<?> cls) {
        return new InstanceOfPredicate(cls);
    }

    @GwtIncompatible
    @Beta
    public static Predicate<Class<?>> subtypeOf(Class<?> cls) {
        return new SubtypeOfPredicate(cls);
    }

    public static <T> Predicate<T> in(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    public static <A, B> Predicate<A> compose(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new CompositionPredicate(predicate, function);
    }

    @GwtIncompatible
    public static Predicate<CharSequence> containsPattern(String str) {
        return new ContainsPatternFromStringPredicate(str);
    }

    @GwtIncompatible("java.util.regex.Pattern")
    public static Predicate<CharSequence> contains(Pattern pattern) {
        return new ContainsPatternPredicate(new JdkPattern(pattern));
    }

    static class NotPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Predicate<T> predicate;

        public /* synthetic */ boolean test(T t) {
            return Predicate.CC.$default$test(this, t);
        }

        NotPredicate(Predicate<T> predicate2) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate2);
        }

        public boolean apply(T t) {
            return !this.predicate.apply(t);
        }

        public int hashCode() {
            return this.predicate.hashCode() ^ -1;
        }

        public boolean equals(Object obj) {
            if (obj instanceof NotPredicate) {
                return this.predicate.equals(((NotPredicate) obj).predicate);
            }
            return false;
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }
    }

    static class AndPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        public /* synthetic */ boolean test(T t) {
            return Predicate.CC.$default$test(this, t);
        }

        private AndPredicate(List<? extends Predicate<? super T>> list) {
            this.components = list;
        }

        public boolean apply(T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (!((Predicate) this.components.get(i)).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public boolean equals(Object obj) {
            if (obj instanceof AndPredicate) {
                return this.components.equals(((AndPredicate) obj).components);
            }
            return false;
        }

        public String toString() {
            return Predicates.toStringHelper("and", this.components);
        }
    }

    static class OrPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        public /* synthetic */ boolean test(T t) {
            return Predicate.CC.$default$test(this, t);
        }

        private OrPredicate(List<? extends Predicate<? super T>> list) {
            this.components = list;
        }

        public boolean apply(T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (((Predicate) this.components.get(i)).apply(t)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        public boolean equals(Object obj) {
            if (obj instanceof OrPredicate) {
                return this.components.equals(((OrPredicate) obj).components);
            }
            return false;
        }

        public String toString() {
            return Predicates.toStringHelper("or", this.components);
        }
    }

    public static String toStringHelper(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (Object next : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(next);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    static class IsEqualToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        public /* synthetic */ boolean test(T t) {
            return Predicate.CC.$default$test(this, t);
        }

        private IsEqualToPredicate(T t) {
            this.target = t;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public boolean apply(T r2) {
            /*
                r1 = this;
                T r0 = r1.target
                boolean r2 = r0.equals(r2)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Predicates.IsEqualToPredicate.apply(java.lang.Object):boolean");
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public boolean equals(java.lang.Object r2) {
            /*
                r1 = this;
                boolean r0 = r2 instanceof com.google.common.base.Predicates.IsEqualToPredicate
                if (r0 == 0) goto L_0x000f
                com.google.common.base.Predicates$IsEqualToPredicate r2 = (com.google.common.base.Predicates.IsEqualToPredicate) r2
                T r0 = r1.target
                T r2 = r2.target
                boolean r2 = r0.equals(r2)
                return r2
            L_0x000f:
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Predicates.IsEqualToPredicate.equals(java.lang.Object):boolean");
        }

        public String toString() {
            return "Predicates.equalTo(" + ((Object) this.target) + ")";
        }
    }

    @GwtIncompatible
    static class InstanceOfPredicate implements Predicate<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        public /* synthetic */ boolean test(T t) {
            return Predicate.CC.$default$test(this, t);
        }

        private InstanceOfPredicate(Class<?> cls) {
            this.clazz = (Class) Preconditions.checkNotNull(cls);
        }

        public boolean apply(Object obj) {
            return this.clazz.isInstance(obj);
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof InstanceOfPredicate) || this.clazz != ((InstanceOfPredicate) obj).clazz) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.clazz.getName() + ")";
        }
    }

    @GwtIncompatible
    static class SubtypeOfPredicate implements Predicate<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        public /* synthetic */ boolean test(T t) {
            return Predicate.CC.$default$test(this, t);
        }

        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Class<?>) ((Class) obj));
        }

        private SubtypeOfPredicate(Class<?> cls) {
            this.clazz = (Class) Preconditions.checkNotNull(cls);
        }

        public boolean apply(Class<?> cls) {
            return this.clazz.isAssignableFrom(cls);
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SubtypeOfPredicate) || this.clazz != ((SubtypeOfPredicate) obj).clazz) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.clazz.getName() + ")";
        }
    }

    static class InPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        public /* synthetic */ boolean test(T t) {
            return Predicate.CC.$default$test(this, t);
        }

        private InPredicate(Collection<?> collection) {
            this.target = (Collection) Preconditions.checkNotNull(collection);
        }

        public boolean apply(T t) {
            try {
                return this.target.contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof InPredicate) {
                return this.target.equals(((InPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }
    }

    static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {
        private static final long serialVersionUID = 0;
        final Function<A, ? extends B> f;
        final Predicate<B> p;

        public /* synthetic */ boolean test(T t) {
            return Predicate.CC.$default$test(this, t);
        }

        private CompositionPredicate(Predicate<B> predicate, Function<A, ? extends B> function) {
            this.p = (Predicate) Preconditions.checkNotNull(predicate);
            this.f = (Function) Preconditions.checkNotNull(function);
        }

        public boolean apply(A a2) {
            return this.p.apply(this.f.apply(a2));
        }

        public boolean equals(Object obj) {
            if (obj instanceof CompositionPredicate) {
                CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
                if (!this.f.equals(compositionPredicate.f) || !this.p.equals(compositionPredicate.p)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f.hashCode() ^ this.p.hashCode();
        }

        public String toString() {
            return this.p + "(" + this.f + ")";
        }
    }

    @GwtIncompatible
    static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        final CommonPattern pattern;

        public /* synthetic */ boolean test(T t) {
            return Predicate.CC.$default$test(this, t);
        }

        ContainsPatternPredicate(CommonPattern commonPattern) {
            this.pattern = (CommonPattern) Preconditions.checkNotNull(commonPattern);
        }

        public boolean apply(CharSequence charSequence) {
            return this.pattern.matcher(charSequence).find();
        }

        public int hashCode() {
            return Objects.hashCode(this.pattern.pattern(), Integer.valueOf(this.pattern.flags()));
        }

        public boolean equals(Object obj) {
            if (obj instanceof ContainsPatternPredicate) {
                ContainsPatternPredicate containsPatternPredicate = (ContainsPatternPredicate) obj;
                if (!Objects.equal(this.pattern.pattern(), containsPatternPredicate.pattern.pattern()) || this.pattern.flags() != containsPatternPredicate.pattern.flags()) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String toString() {
            String toStringHelper = MoreObjects.toStringHelper(this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString();
            return "Predicates.contains(" + toStringHelper + ")";
        }
    }

    @GwtIncompatible
    static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        ContainsPatternFromStringPredicate(String str) {
            super(Platform.compilePattern(str));
        }

        public String toString() {
            return "Predicates.containsPattern(" + this.pattern.pattern() + ")";
        }
    }

    private static <T> List<Predicate<? super T>> asList(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return Arrays.asList(predicate, predicate2);
    }

    private static <T> List<T> defensiveCopy(T... tArr) {
        return defensiveCopy(Arrays.asList(tArr));
    }

    static <T> List<T> defensiveCopy(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T checkNotNull : iterable) {
            arrayList.add(Preconditions.checkNotNull(checkNotNull));
        }
        return arrayList;
    }
}

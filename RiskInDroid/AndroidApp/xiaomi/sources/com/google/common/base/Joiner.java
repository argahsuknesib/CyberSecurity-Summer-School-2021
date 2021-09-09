package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

@GwtCompatible
public class Joiner {
    public final String separator;

    public static Joiner on(String str) {
        return new Joiner(str);
    }

    public static Joiner on(char c) {
        return new Joiner(String.valueOf(c));
    }

    private Joiner(String str) {
        this.separator = (String) Preconditions.checkNotNull(str);
    }

    private Joiner(Joiner joiner) {
        this.separator = joiner.separator;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.util.Iterator<?>):A
     arg types: [A, java.util.Iterator<?>]
     candidates:
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.lang.Iterable<?>):A
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.lang.Object[]):A
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.lang.Iterable<?>):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.util.Iterator<?>):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.lang.Object[]):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.util.Iterator<?>):A */
    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a2, Iterable<?> iterable) throws IOException {
        return appendTo((Appendable) a2, iterable.iterator());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: A
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public <A extends java.lang.Appendable> A appendTo(A r2, java.util.Iterator<?> r3) throws java.io.IOException {
        /*
            r1 = this;
            com.google.common.base.Preconditions.checkNotNull(r2)
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r3.next()
            java.lang.CharSequence r0 = r1.toString(r0)
            r2.append(r0)
        L_0x0014:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x002b
            java.lang.String r0 = r1.separator
            r2.append(r0)
            java.lang.Object r0 = r3.next()
            java.lang.CharSequence r0 = r1.toString(r0)
            r2.append(r0)
            goto L_0x0014
        L_0x002b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.util.Iterator):java.lang.Appendable");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.lang.Iterable<?>):A
     arg types: [A, java.util.List]
     candidates:
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.util.Iterator<?>):A
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.lang.Object[]):A
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.lang.Iterable<?>):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.util.Iterator<?>):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.lang.Object[]):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.lang.Iterable<?>):A */
    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a2, Object[] objArr) throws IOException {
        return appendTo((Appendable) a2, (Iterable<?>) Arrays.asList(objArr));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.lang.Iterable<?>):A
     arg types: [A, java.lang.Iterable<java.lang.Object>]
     candidates:
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.util.Iterator<?>):A
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.lang.Object[]):A
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.lang.Iterable<?>):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.util.Iterator<?>):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.lang.Object[]):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.lang.Iterable<?>):A */
    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a2, Object obj, Object obj2, Object... objArr) throws IOException {
        return appendTo((Appendable) a2, (Iterable<?>) iterable(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Iterable<?> iterable) {
        return appendTo(sb, iterable.iterator());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.util.Iterator<?>):A
     arg types: [java.lang.StringBuilder, java.util.Iterator<?>]
     candidates:
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.lang.Iterable<?>):A
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.lang.Object[]):A
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.lang.Iterable<?>):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.util.Iterator<?>):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.lang.Object[]):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.util.Iterator<?>):A */
    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Iterator<?> it) {
        try {
            appendTo((Appendable) sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Object[] objArr) {
        return appendTo(sb, (Iterable<?>) Arrays.asList(objArr));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.lang.Iterable<?>):java.lang.StringBuilder
     arg types: [java.lang.StringBuilder, java.lang.Iterable<java.lang.Object>]
     candidates:
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.lang.Iterable<?>):A
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.util.Iterator<?>):A
      com.google.common.base.Joiner.appendTo(java.lang.Appendable, java.lang.Object[]):A
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.util.Iterator<?>):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.lang.Object[]):java.lang.StringBuilder
      com.google.common.base.Joiner.appendTo(java.lang.StringBuilder, java.lang.Iterable<?>):java.lang.StringBuilder */
    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Object obj, Object obj2, Object... objArr) {
        return appendTo(sb, (Iterable<?>) iterable(obj, obj2, objArr));
    }

    public final String join(Iterable<?> iterable) {
        return join(iterable.iterator());
    }

    public final String join(Iterator<?> it) {
        return appendTo(new StringBuilder(), it).toString();
    }

    public final String join(Object[] objArr) {
        return join(Arrays.asList(objArr));
    }

    public final String join(Object obj, Object obj2, Object... objArr) {
        return join(iterable(obj, obj2, objArr));
    }

    public Joiner useForNull(final String str) {
        Preconditions.checkNotNull(str);
        return new Joiner(this) {
            /* class com.google.common.base.Joiner.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public CharSequence toString(Object obj) {
                return obj == null ? str : Joiner.this.toString(obj);
            }

            public Joiner useForNull(String str) {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            public Joiner skipNulls() {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    public Joiner skipNulls() {
        return new Joiner(this) {
            /* class com.google.common.base.Joiner.AnonymousClass2 */

            /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Not class type: A
                	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
                	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
                	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
                	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
                	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
                	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
                */
            public <A extends java.lang.Appendable> A appendTo(A r3, java.util.Iterator<?> r4) throws java.io.IOException {
                /*
                    r2 = this;
                    java.lang.String r0 = "appendable"
                    com.google.common.base.Preconditions.checkNotNull(r3, r0)
                    java.lang.String r0 = "parts"
                    com.google.common.base.Preconditions.checkNotNull(r4, r0)
                L_0x000a:
                    boolean r0 = r4.hasNext()
                    if (r0 == 0) goto L_0x001f
                    java.lang.Object r0 = r4.next()
                    if (r0 == 0) goto L_0x000a
                    com.google.common.base.Joiner r1 = com.google.common.base.Joiner.this
                    java.lang.CharSequence r0 = r1.toString(r0)
                    r3.append(r0)
                L_0x001f:
                    boolean r0 = r4.hasNext()
                    if (r0 == 0) goto L_0x003c
                    java.lang.Object r0 = r4.next()
                    if (r0 == 0) goto L_0x001f
                    com.google.common.base.Joiner r1 = com.google.common.base.Joiner.this
                    java.lang.String r1 = r1.separator
                    r3.append(r1)
                    com.google.common.base.Joiner r1 = com.google.common.base.Joiner.this
                    java.lang.CharSequence r0 = r1.toString(r0)
                    r3.append(r0)
                    goto L_0x001f
                L_0x003c:
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Joiner.AnonymousClass2.appendTo(java.lang.Appendable, java.util.Iterator):java.lang.Appendable");
            }

            public Joiner useForNull(String str) {
                throw new UnsupportedOperationException("already specified skipNulls");
            }

            public MapJoiner withKeyValueSeparator(String str) {
                throw new UnsupportedOperationException("can't use .skipNulls() with maps");
            }
        };
    }

    public MapJoiner withKeyValueSeparator(char c) {
        return withKeyValueSeparator(String.valueOf(c));
    }

    public MapJoiner withKeyValueSeparator(String str) {
        return new MapJoiner(str);
    }

    public static final class MapJoiner {
        private final Joiner joiner;
        private final String keyValueSeparator;

        private MapJoiner(Joiner joiner2, String str) {
            this.joiner = joiner2;
            this.keyValueSeparator = (String) Preconditions.checkNotNull(str);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.lang.Iterable<? extends java.util.Map$Entry<?, ?>>):A
         arg types: [A, java.util.Set<java.util.Map$Entry<?, ?>>]
         candidates:
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.util.Iterator<? extends java.util.Map$Entry<?, ?>>):A
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.util.Map<?, ?>):A
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.lang.Iterable<? extends java.util.Map$Entry<?, ?>>):java.lang.StringBuilder
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.util.Iterator<? extends java.util.Map$Entry<?, ?>>):java.lang.StringBuilder
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.util.Map<?, ?>):java.lang.StringBuilder
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.lang.Iterable<? extends java.util.Map$Entry<?, ?>>):A */
        @CanIgnoreReturnValue
        public final <A extends Appendable> A appendTo(A a2, Map<?, ?> map) throws IOException {
            return appendTo((Appendable) a2, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.lang.Iterable<? extends java.util.Map$Entry<?, ?>>):java.lang.StringBuilder
         arg types: [java.lang.StringBuilder, java.util.Set<java.util.Map$Entry<?, ?>>]
         candidates:
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.lang.Iterable<? extends java.util.Map$Entry<?, ?>>):A
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.util.Iterator<? extends java.util.Map$Entry<?, ?>>):A
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.util.Map<?, ?>):A
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.util.Iterator<? extends java.util.Map$Entry<?, ?>>):java.lang.StringBuilder
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.util.Map<?, ?>):java.lang.StringBuilder
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.lang.Iterable<? extends java.util.Map$Entry<?, ?>>):java.lang.StringBuilder */
        @CanIgnoreReturnValue
        public final StringBuilder appendTo(StringBuilder sb, Map<?, ?> map) {
            return appendTo(sb, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.util.Iterator<? extends java.util.Map$Entry<?, ?>>):A
         arg types: [A, java.util.Iterator<? extends java.util.Map$Entry<?, ?>>]
         candidates:
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.lang.Iterable<? extends java.util.Map$Entry<?, ?>>):A
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.util.Map<?, ?>):A
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.lang.Iterable<? extends java.util.Map$Entry<?, ?>>):java.lang.StringBuilder
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.util.Iterator<? extends java.util.Map$Entry<?, ?>>):java.lang.StringBuilder
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.util.Map<?, ?>):java.lang.StringBuilder
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.util.Iterator<? extends java.util.Map$Entry<?, ?>>):A */
        @CanIgnoreReturnValue
        @Beta
        public final <A extends Appendable> A appendTo(A a2, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return appendTo((Appendable) a2, iterable.iterator());
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: A
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        public final <A extends java.lang.Appendable> A appendTo(A r4, java.util.Iterator<? extends java.util.Map.Entry<?, ?>> r5) throws java.io.IOException {
            /*
                r3 = this;
                com.google.common.base.Preconditions.checkNotNull(r4)
                boolean r0 = r5.hasNext()
                if (r0 == 0) goto L_0x0061
                java.lang.Object r0 = r5.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                com.google.common.base.Joiner r1 = r3.joiner
                java.lang.Object r2 = r0.getKey()
                java.lang.CharSequence r1 = r1.toString(r2)
                r4.append(r1)
                java.lang.String r1 = r3.keyValueSeparator
                r4.append(r1)
                com.google.common.base.Joiner r1 = r3.joiner
                java.lang.Object r0 = r0.getValue()
                java.lang.CharSequence r0 = r1.toString(r0)
                r4.append(r0)
            L_0x002e:
                boolean r0 = r5.hasNext()
                if (r0 == 0) goto L_0x0061
                com.google.common.base.Joiner r0 = r3.joiner
                java.lang.String r0 = r0.separator
                r4.append(r0)
                java.lang.Object r0 = r5.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                com.google.common.base.Joiner r1 = r3.joiner
                java.lang.Object r2 = r0.getKey()
                java.lang.CharSequence r1 = r1.toString(r2)
                r4.append(r1)
                java.lang.String r1 = r3.keyValueSeparator
                r4.append(r1)
                com.google.common.base.Joiner r1 = r3.joiner
                java.lang.Object r0 = r0.getValue()
                java.lang.CharSequence r0 = r1.toString(r0)
                r4.append(r0)
                goto L_0x002e
            L_0x0061:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.util.Iterator):java.lang.Appendable");
        }

        @CanIgnoreReturnValue
        @Beta
        public final StringBuilder appendTo(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return appendTo(sb, iterable.iterator());
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.util.Iterator<? extends java.util.Map$Entry<?, ?>>):A
         arg types: [java.lang.StringBuilder, java.util.Iterator<? extends java.util.Map$Entry<?, ?>>]
         candidates:
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.lang.Iterable<? extends java.util.Map$Entry<?, ?>>):A
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.util.Map<?, ?>):A
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.lang.Iterable<? extends java.util.Map$Entry<?, ?>>):java.lang.StringBuilder
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.util.Iterator<? extends java.util.Map$Entry<?, ?>>):java.lang.StringBuilder
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.StringBuilder, java.util.Map<?, ?>):java.lang.StringBuilder
          com.google.common.base.Joiner.MapJoiner.appendTo(java.lang.Appendable, java.util.Iterator<? extends java.util.Map$Entry<?, ?>>):A */
        @CanIgnoreReturnValue
        @Beta
        public final StringBuilder appendTo(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                appendTo((Appendable) sb, it);
                return sb;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public final String join(Map<?, ?> map) {
            return join(map.entrySet());
        }

        @Beta
        public final String join(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return join(iterable.iterator());
        }

        @Beta
        public final String join(Iterator<? extends Map.Entry<?, ?>> it) {
            return appendTo(new StringBuilder(), it).toString();
        }

        public final MapJoiner useForNull(String str) {
            return new MapJoiner(this.joiner.useForNull(str), this.keyValueSeparator);
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence toString(Object obj) {
        Preconditions.checkNotNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    private static Iterable<Object> iterable(final Object obj, final Object obj2, final Object[] objArr) {
        Preconditions.checkNotNull(objArr);
        return new AbstractList<Object>() {
            /* class com.google.common.base.Joiner.AnonymousClass3 */

            public final int size() {
                return objArr.length + 2;
            }

            public final Object get(int i) {
                if (i == 0) {
                    return obj;
                }
                if (i != 1) {
                    return objArr[i - 2];
                }
                return obj2;
            }
        };
    }
}

package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;

@Beta
public final class Parameter implements AnnotatedElement {
    private final AnnotatedType annotatedType;
    private final ImmutableList<Annotation> annotations;
    private final Invokable<?, ?> declaration;
    private final int position;
    private final TypeToken<?> type;

    Parameter(Invokable<?, ?> invokable, int i, TypeToken<?> typeToken, Annotation[] annotationArr, AnnotatedType annotatedType2) {
        this.declaration = invokable;
        this.position = i;
        this.type = typeToken;
        this.annotations = ImmutableList.copyOf(annotationArr);
        this.annotatedType = annotatedType2;
    }

    public final TypeToken<?> getType() {
        return this.type;
    }

    public final Invokable<?, ?> getDeclaringInvokable() {
        return this.declaration;
    }

    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return getAnnotation(cls) != null;
    }

    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        Preconditions.checkNotNull(cls);
        UnmodifiableIterator<Annotation> it = this.annotations.iterator();
        while (it.hasNext()) {
            Annotation next = it.next();
            if (cls.isInstance(next)) {
                return (Annotation) cls.cast(next);
            }
        }
        return null;
    }

    public final Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    public final <A extends Annotation> A[] getAnnotationsByType(Class<A> cls) {
        return getDeclaredAnnotationsByType(cls);
    }

    public final Annotation[] getDeclaredAnnotations() {
        ImmutableList<Annotation> immutableList = this.annotations;
        return (Annotation[]) immutableList.toArray(new Annotation[immutableList.size()]);
    }

    public final <A extends Annotation> A getDeclaredAnnotation(Class<A> cls) {
        Preconditions.checkNotNull(cls);
        return (Annotation) FluentIterable.from(this.annotations).filter(cls).first().orNull();
    }

    public final <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> cls) {
        return (Annotation[]) FluentIterable.from(this.annotations).filter(cls).toArray(cls);
    }

    public final AnnotatedType getAnnotatedType() {
        return this.annotatedType;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Parameter) {
            Parameter parameter = (Parameter) obj;
            if (this.position != parameter.position || !this.declaration.equals(parameter.declaration)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.position;
    }

    public final String toString() {
        return this.type + " arg" + this.position;
    }
}

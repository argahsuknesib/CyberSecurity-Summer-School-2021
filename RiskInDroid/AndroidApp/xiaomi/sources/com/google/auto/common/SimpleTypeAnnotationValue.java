package com.google.auto.common;

import com.google.common.base.Preconditions;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.AnnotationValueVisitor;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;

public final class SimpleTypeAnnotationValue implements AnnotationValue {
    private final TypeMirror value;

    private SimpleTypeAnnotationValue(TypeMirror typeMirror) {
        Preconditions.checkArgument(typeMirror.getKind().isPrimitive() || typeMirror.getKind().equals(TypeKind.DECLARED) || typeMirror.getKind().equals(TypeKind.ARRAY), "value must be a primitive, array, or declared type, but was %s (%s)", typeMirror.getKind(), typeMirror);
        if (typeMirror.getKind().equals(TypeKind.DECLARED)) {
            Preconditions.checkArgument(MoreTypes.asDeclared(typeMirror).getTypeArguments().isEmpty(), "value must not be a parameterized type: %s", typeMirror);
        }
        this.value = typeMirror;
    }

    public static AnnotationValue of(TypeMirror typeMirror) {
        return new SimpleTypeAnnotationValue(typeMirror);
    }

    public final TypeMirror getValue() {
        return this.value;
    }

    public final String toString() {
        return this.value + ".class";
    }

    public final <R, P> R accept(AnnotationValueVisitor<R, P> annotationValueVisitor, P p) {
        return annotationValueVisitor.visitType(getValue(), p);
    }
}

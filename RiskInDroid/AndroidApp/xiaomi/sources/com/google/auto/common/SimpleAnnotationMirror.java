package com.google.auto.common;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.util.ElementFilter;

public final class SimpleAnnotationMirror implements AnnotationMirror {
    private final TypeElement annotationType;
    private final ImmutableMap<ExecutableElement, ? extends AnnotationValue> elementValues;
    private final ImmutableMap<String, ? extends AnnotationValue> namedValues;

    static /* synthetic */ ExecutableElement lambda$new$0(ExecutableElement executableElement) {
        return executableElement;
    }

    private SimpleAnnotationMirror(TypeElement typeElement, Map<String, ? extends AnnotationValue> map) {
        Preconditions.checkArgument(typeElement.getKind().equals(ElementKind.ANNOTATION_TYPE), "annotationType must be an annotation: %s", typeElement);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(map);
        ArrayList arrayList = new ArrayList();
        for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
            String obj = executableElement.getSimpleName().toString();
            if (linkedHashMap2.containsKey(obj)) {
                linkedHashMap.put(obj, linkedHashMap2.remove(obj));
            } else if (executableElement.getDefaultValue() != null) {
                linkedHashMap.put(obj, executableElement.getDefaultValue());
            } else {
                arrayList.add(obj);
            }
        }
        Preconditions.checkArgument(linkedHashMap2.isEmpty(), "namedValues has entries for members that are not in %s: %s", typeElement, linkedHashMap2);
        Preconditions.checkArgument(arrayList.isEmpty(), "namedValues is missing entries for: %s", arrayList);
        this.annotationType = typeElement;
        this.namedValues = ImmutableMap.copyOf(map);
        this.elementValues = (ImmutableMap) ElementFilter.methodsIn(typeElement.getEnclosedElements()).stream().collect(ImmutableMap.toImmutableMap($$Lambda$SimpleAnnotationMirror$w__eFBjV9m1lpGPBFxprZMqwJ8.INSTANCE, new Function(linkedHashMap) {
            /* class com.google.auto.common.$$Lambda$SimpleAnnotationMirror$UB0XDZaEec7eqFlNYR8OgycSdzg */
            private final /* synthetic */ Map f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return SimpleAnnotationMirror.lambda$new$1(this.f$0, (ExecutableElement) obj);
            }
        }));
    }

    static /* synthetic */ AnnotationValue lambda$new$1(Map map, ExecutableElement executableElement) {
        return (AnnotationValue) map.get(executableElement.getSimpleName().toString());
    }

    public static AnnotationMirror of(TypeElement typeElement) {
        return of(typeElement, ImmutableMap.of());
    }

    public static AnnotationMirror of(TypeElement typeElement, Map<String, ? extends AnnotationValue> map) {
        return new SimpleAnnotationMirror(typeElement, map);
    }

    public final DeclaredType getAnnotationType() {
        return MoreTypes.asDeclared(this.annotationType.asType());
    }

    public final Map<ExecutableElement, ? extends AnnotationValue> getElementValues() {
        return this.elementValues;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("@");
        sb.append((CharSequence) this.annotationType.getQualifiedName());
        if (!this.namedValues.isEmpty()) {
            sb.append('(');
            sb.append(Joiner.on(", ").withKeyValueSeparator(" = ").join(this.namedValues));
            sb.append(')');
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof AnnotationMirror) && AnnotationMirrors.equivalence().equivalent(this, (AnnotationMirror) obj);
    }

    public final int hashCode() {
        return AnnotationMirrors.equivalence().hash(this);
    }
}

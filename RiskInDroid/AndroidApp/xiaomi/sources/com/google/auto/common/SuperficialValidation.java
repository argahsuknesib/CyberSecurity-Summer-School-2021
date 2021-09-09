package com.google.auto.common;

import java.util.List;
import java.util.Map;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.AnnotationValueVisitor;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.AbstractElementVisitor6;
import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.lang.model.util.SimpleTypeVisitor6;

public final class SuperficialValidation {
    private static final ElementVisitor<Boolean, Void> ELEMENT_VALIDATING_VISITOR = new AbstractElementVisitor6<Boolean, Void>() {
        /* class com.google.auto.common.SuperficialValidation.AnonymousClass1 */

        public final Boolean visitPackage(PackageElement packageElement, Void voidR) {
            return Boolean.valueOf(SuperficialValidation.validateAnnotations(packageElement.getAnnotationMirrors()));
        }

        public final Boolean visitType(TypeElement typeElement, Void voidR) {
            return Boolean.valueOf(SuperficialValidation.isValidBaseElement(typeElement) && SuperficialValidation.validateElements(typeElement.getTypeParameters()) && SuperficialValidation.validateTypes(typeElement.getInterfaces()) && SuperficialValidation.validateType(typeElement.getSuperclass()));
        }

        public final Boolean visitVariable(VariableElement variableElement, Void voidR) {
            return Boolean.valueOf(SuperficialValidation.isValidBaseElement(variableElement));
        }

        public final Boolean visitExecutable(ExecutableElement executableElement, Void voidR) {
            AnnotationValue defaultValue = executableElement.getDefaultValue();
            return Boolean.valueOf(SuperficialValidation.isValidBaseElement(executableElement) && (defaultValue == null || SuperficialValidation.validateAnnotationValue(defaultValue, executableElement.getReturnType())) && SuperficialValidation.validateType(executableElement.getReturnType()) && SuperficialValidation.validateTypes(executableElement.getThrownTypes()) && SuperficialValidation.validateElements(executableElement.getTypeParameters()) && SuperficialValidation.validateElements(executableElement.getParameters()));
        }

        public final Boolean visitTypeParameter(TypeParameterElement typeParameterElement, Void voidR) {
            return Boolean.valueOf(SuperficialValidation.isValidBaseElement(typeParameterElement) && SuperficialValidation.validateTypes(typeParameterElement.getBounds()));
        }

        public final Boolean visitUnknown(Element element, Void voidR) {
            return Boolean.TRUE;
        }
    };
    private static final TypeVisitor<Boolean, Void> TYPE_VALIDATING_VISITOR = new SimpleTypeVisitor6<Boolean, Void>() {
        /* class com.google.auto.common.SuperficialValidation.AnonymousClass2 */

        /* access modifiers changed from: protected */
        public final Boolean defaultAction(TypeMirror typeMirror, Void voidR) {
            return Boolean.TRUE;
        }

        public final Boolean visitArray(ArrayType arrayType, Void voidR) {
            return Boolean.valueOf(SuperficialValidation.validateType(arrayType.getComponentType()));
        }

        public final Boolean visitDeclared(DeclaredType declaredType, Void voidR) {
            return Boolean.valueOf(SuperficialValidation.validateTypes(declaredType.getTypeArguments()));
        }

        public final Boolean visitError(ErrorType errorType, Void voidR) {
            return Boolean.FALSE;
        }

        public final Boolean visitUnknown(TypeMirror typeMirror, Void voidR) {
            return defaultAction(typeMirror, voidR);
        }

        public final Boolean visitWildcard(WildcardType wildcardType, Void voidR) {
            TypeMirror extendsBound = wildcardType.getExtendsBound();
            TypeMirror superBound = wildcardType.getSuperBound();
            return Boolean.valueOf((extendsBound == null || SuperficialValidation.validateType(extendsBound)) && (superBound == null || SuperficialValidation.validateType(superBound)));
        }

        public final Boolean visitExecutable(ExecutableType executableType, Void voidR) {
            return Boolean.valueOf(SuperficialValidation.validateTypes(executableType.getParameterTypes()) && SuperficialValidation.validateType(executableType.getReturnType()) && SuperficialValidation.validateTypes(executableType.getThrownTypes()) && SuperficialValidation.validateTypes(executableType.getTypeVariables()));
        }
    };
    private static final AnnotationValueVisitor<Boolean, TypeMirror> VALUE_VALIDATING_VISITOR = new SimpleAnnotationValueVisitor6<Boolean, TypeMirror>() {
        /* class com.google.auto.common.SuperficialValidation.AnonymousClass3 */

        public final /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
            return visitArray((List<? extends AnnotationValue>) list, (TypeMirror) obj);
        }

        /* access modifiers changed from: protected */
        public final Boolean defaultAction(Object obj, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(obj.getClass(), typeMirror));
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.auto.common.SuperficialValidation.3.defaultAction(java.lang.Object, javax.lang.model.type.TypeMirror):java.lang.Boolean
         arg types: [javax.lang.model.element.AnnotationValue, javax.lang.model.type.TypeMirror]
         candidates:
          com.google.auto.common.SuperficialValidation.3.defaultAction(java.lang.Object, java.lang.Object):java.lang.Object
          com.google.auto.common.SuperficialValidation.3.defaultAction(java.lang.Object, javax.lang.model.type.TypeMirror):java.lang.Boolean */
        public final Boolean visitUnknown(AnnotationValue annotationValue, TypeMirror typeMirror) {
            return defaultAction((Object) annotationValue, typeMirror);
        }

        public final Boolean visitAnnotation(AnnotationMirror annotationMirror, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.equivalence().equivalent(annotationMirror.getAnnotationType(), typeMirror) && SuperficialValidation.validateAnnotation(annotationMirror));
        }

        public final Boolean visitArray(List<? extends AnnotationValue> list, TypeMirror typeMirror) {
            if (!typeMirror.getKind().equals(TypeKind.ARRAY)) {
                return Boolean.FALSE;
            }
            try {
                TypeMirror componentType = MoreTypes.asArray(typeMirror).getComponentType();
                for (AnnotationValue accept : list) {
                    if (!((Boolean) accept.accept(this, componentType)).booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            } catch (IllegalArgumentException unused) {
                return Boolean.FALSE;
            }
        }

        public final Boolean visitEnumConstant(VariableElement variableElement, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.equivalence().equivalent(variableElement.asType(), typeMirror) && SuperficialValidation.validateElement(variableElement));
        }

        public final Boolean visitType(TypeMirror typeMirror, TypeMirror typeMirror2) {
            return Boolean.valueOf(SuperficialValidation.validateType(typeMirror));
        }

        public final Boolean visitBoolean(boolean z, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Boolean.TYPE, typeMirror));
        }

        public final Boolean visitByte(byte b, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Byte.TYPE, typeMirror));
        }

        public final Boolean visitChar(char c, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Character.TYPE, typeMirror));
        }

        public final Boolean visitDouble(double d, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Double.TYPE, typeMirror));
        }

        public final Boolean visitFloat(float f, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Float.TYPE, typeMirror));
        }

        public final Boolean visitInt(int i, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Integer.TYPE, typeMirror));
        }

        public final Boolean visitLong(long j, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Long.TYPE, typeMirror));
        }

        public final Boolean visitShort(short s, TypeMirror typeMirror) {
            return Boolean.valueOf(MoreTypes.isTypeOf(Short.TYPE, typeMirror));
        }
    };

    public static boolean validateElements(Iterable<? extends Element> iterable) {
        for (Element validateElement : iterable) {
            if (!validateElement(validateElement)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateElement(Element element) {
        return ((Boolean) element.accept(ELEMENT_VALIDATING_VISITOR, (Object) null)).booleanValue();
    }

    public static boolean isValidBaseElement(Element element) {
        return validateType(element.asType()) && validateAnnotations(element.getAnnotationMirrors()) && validateElements(element.getEnclosedElements());
    }

    public static boolean validateTypes(Iterable<? extends TypeMirror> iterable) {
        for (TypeMirror validateType : iterable) {
            if (!validateType(validateType)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateType(TypeMirror typeMirror) {
        return ((Boolean) typeMirror.accept(TYPE_VALIDATING_VISITOR, (Object) null)).booleanValue();
    }

    public static boolean validateAnnotations(Iterable<? extends AnnotationMirror> iterable) {
        for (AnnotationMirror validateAnnotation : iterable) {
            if (!validateAnnotation(validateAnnotation)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateAnnotation(AnnotationMirror annotationMirror) {
        return validateType(annotationMirror.getAnnotationType()) && validateAnnotationValues(annotationMirror.getElementValues());
    }

    private static boolean validateAnnotationValues(Map<? extends ExecutableElement, ? extends AnnotationValue> map) {
        for (Map.Entry next : map.entrySet()) {
            if (!validateAnnotationValue((AnnotationValue) next.getValue(), ((ExecutableElement) next.getKey()).getReturnType())) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateAnnotationValue(AnnotationValue annotationValue, TypeMirror typeMirror) {
        return ((Boolean) annotationValue.accept(VALUE_VALIDATING_VISITOR, typeMirror)).booleanValue();
    }
}

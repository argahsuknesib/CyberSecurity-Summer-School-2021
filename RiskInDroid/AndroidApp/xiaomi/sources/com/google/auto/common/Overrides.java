package com.google.auto.common;

import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleTypeVisitor6;
import javax.lang.model.util.Types;

abstract class Overrides {
    /* access modifiers changed from: package-private */
    public abstract boolean overrides(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement);

    Overrides() {
    }

    static class NativeOverrides extends Overrides {
        private final Elements elementUtils;

        NativeOverrides(Elements elements) {
            this.elementUtils = elements;
        }

        /* access modifiers changed from: package-private */
        public boolean overrides(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement) {
            return this.elementUtils.overrides(executableElement, executableElement2, typeElement);
        }
    }

    static class ExplicitOverrides extends Overrides {
        public final Types typeUtils;

        ExplicitOverrides(Types types) {
            this.typeUtils = types;
        }

        public boolean overrides(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement) {
            if (!executableElement.getSimpleName().equals(executableElement2.getSimpleName()) || executableElement.getEnclosingElement().equals(executableElement2.getEnclosingElement()) || executableElement2.getModifiers().contains(Modifier.STATIC)) {
                return false;
            }
            Visibility ofElement = Visibility.ofElement(executableElement2);
            Visibility ofElement2 = Visibility.ofElement(executableElement);
            if (ofElement.equals(Visibility.PRIVATE) || ofElement2.compareTo((Enum) ofElement) < 0 || !isSubsignature(executableElement, executableElement2, typeElement) || !MoreElements.methodVisibleFromPackage(executableElement2, MoreElements.getPackage(executableElement)) || !(executableElement2.getEnclosingElement() instanceof TypeElement)) {
                return false;
            }
            TypeElement asType = MoreElements.asType(executableElement2.getEnclosingElement());
            Types types = this.typeUtils;
            if (!types.isSubtype(types.erasure(typeElement.asType()), this.typeUtils.erasure(asType.asType()))) {
                return false;
            }
            if (!typeElement.getKind().isClass()) {
                return typeElement.getKind().isInterface();
            }
            if (asType.getKind().isClass()) {
                if (!executableElement2.getEnclosingElement().equals(methodFromSuperclasses(typeElement, executableElement2).getEnclosingElement())) {
                    return true;
                }
                return false;
            } else if (!asType.getKind().isInterface()) {
                return false;
            } else {
                if (!executableElement.getModifiers().contains(Modifier.ABSTRACT)) {
                    return true;
                }
                if (!executableElement2.getEnclosingElement().equals(methodFromSuperinterfaces(typeElement, executableElement2).getEnclosingElement())) {
                    return true;
                }
                return false;
            }
        }

        private boolean isSubsignature(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement) {
            DeclaredType asDeclared = MoreTypes.asDeclared(typeElement.asType());
            try {
                return this.typeUtils.isSubsignature(MoreTypes.asExecutable(this.typeUtils.asMemberOf(asDeclared, executableElement)), MoreTypes.asExecutable(this.typeUtils.asMemberOf(asDeclared, executableElement2)));
            } catch (IllegalArgumentException unused) {
                int size = executableElement.getParameters().size();
                if (executableElement2.getParameters().size() != size) {
                    return false;
                }
                ImmutableList<TypeMirror> erasedParameterTypes = erasedParameterTypes(executableElement, typeElement);
                ImmutableList<TypeMirror> erasedParameterTypes2 = erasedParameterTypes(executableElement2, typeElement);
                if (erasedParameterTypes == null || erasedParameterTypes2 == null) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    if (!this.typeUtils.isSameType(erasedParameterTypes.get(i), erasedParameterTypes2.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public ImmutableList<TypeMirror> erasedParameterTypes(ExecutableElement executableElement, TypeElement typeElement) {
            if (executableElement.getParameters().isEmpty()) {
                return ImmutableList.of();
            }
            return new TypeSubstVisitor().erasedParameterTypes(executableElement, typeElement);
        }

        class TypeSubstVisitor extends SimpleTypeVisitor6<TypeMirror, Void> {
            private final Map<TypeParameterElement, TypeMirror> typeBindings;

            /* access modifiers changed from: protected */
            public TypeMirror defaultAction(TypeMirror typeMirror, Void voidR) {
                return typeMirror;
            }

            private TypeSubstVisitor() {
                this.typeBindings = Maps.newLinkedHashMap();
            }

            /* access modifiers changed from: package-private */
            public ImmutableList<TypeMirror> erasedParameterTypes(ExecutableElement executableElement, TypeElement typeElement) {
                if (executableElement.getEnclosingElement().equals(typeElement)) {
                    ImmutableList.Builder builder = ImmutableList.builder();
                    for (VariableElement asType : executableElement.getParameters()) {
                        builder.add((Object) ExplicitOverrides.this.typeUtils.erasure((TypeMirror) visit(asType.asType())));
                    }
                    return builder.build();
                }
                ArrayList<TypeMirror> newArrayList = Lists.newArrayList();
                if (typeElement.getSuperclass().getKind() == TypeKind.DECLARED) {
                    newArrayList.add(typeElement.getSuperclass());
                }
                newArrayList.addAll(typeElement.getInterfaces());
                for (TypeMirror asDeclared : newArrayList) {
                    DeclaredType asDeclared2 = MoreTypes.asDeclared(asDeclared);
                    TypeElement asType2 = MoreElements.asType(asDeclared2.asElement());
                    List typeArguments = asDeclared2.getTypeArguments();
                    List typeParameters = asType2.getTypeParameters();
                    Verify.verify(typeArguments.size() == typeParameters.size());
                    for (int i = 0; i < typeArguments.size(); i++) {
                        this.typeBindings.put(typeParameters.get(i), typeArguments.get(i));
                    }
                    ImmutableList<TypeMirror> erasedParameterTypes = erasedParameterTypes(executableElement, asType2);
                    if (erasedParameterTypes != null) {
                        return erasedParameterTypes;
                    }
                }
                return null;
            }

            public TypeMirror visitTypeVariable(TypeVariable typeVariable, Void voidR) {
                TypeParameterElement asElement = ExplicitOverrides.this.typeUtils.asElement(typeVariable);
                if (asElement instanceof TypeParameterElement) {
                    TypeParameterElement typeParameterElement = asElement;
                    if (this.typeBindings.containsKey(typeParameterElement)) {
                        return (TypeMirror) visit(this.typeBindings.get(typeParameterElement));
                    }
                }
                return (TypeMirror) visit(ExplicitOverrides.this.typeUtils.erasure(typeVariable.getUpperBound()));
            }

            public TypeMirror visitDeclared(DeclaredType declaredType, Void voidR) {
                if (declaredType.getTypeArguments().isEmpty()) {
                    return declaredType;
                }
                ArrayList newArrayList = Lists.newArrayList();
                for (TypeMirror visit : declaredType.getTypeArguments()) {
                    newArrayList.add(visit(visit));
                }
                return ExplicitOverrides.this.typeUtils.getDeclaredType(ExplicitOverrides.this.asTypeElement(declaredType), (TypeMirror[]) newArrayList.toArray(new TypeMirror[0]));
            }

            public TypeMirror visitArray(ArrayType arrayType, Void voidR) {
                return ExplicitOverrides.this.typeUtils.getArrayType((TypeMirror) visit(arrayType.getComponentType()));
            }
        }

        /* access modifiers changed from: package-private */
        public ExecutableElement methodFromSuperclasses(TypeElement typeElement, ExecutableElement executableElement) {
            while (typeElement != null) {
                ExecutableElement methodInType = methodInType(typeElement, executableElement);
                if (methodInType != null) {
                    return methodInType;
                }
                typeElement = superclass(typeElement);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public ExecutableElement methodFromSuperinterfaces(TypeElement typeElement, ExecutableElement executableElement) {
            TypeElement superclass;
            TypeElement asType = MoreElements.asType(executableElement.getEnclosingElement());
            Preconditions.checkArgument(asType.getKind().isInterface());
            TypeMirror erasure = this.typeUtils.erasure(asType.asType());
            ImmutableList of = ImmutableList.of(typeElement);
            while (!of.isEmpty()) {
                ImmutableList.Builder builder = ImmutableList.builder();
                UnmodifiableIterator it = of.iterator();
                while (it.hasNext()) {
                    TypeElement typeElement2 = (TypeElement) it.next();
                    if (this.typeUtils.isAssignable(this.typeUtils.erasure(typeElement2.asType()), erasure)) {
                        ExecutableElement methodInType = methodInType(typeElement2, executableElement);
                        if (methodInType != null) {
                            return methodInType;
                        }
                        builder.addAll((Iterable) superinterfaces(typeElement2));
                    }
                    if (typeElement2.getKind().isClass() && (superclass = superclass(typeElement2)) != null) {
                        builder.add((Object) superclass);
                    }
                }
                of = builder.build();
            }
            return null;
        }

        private ExecutableElement methodInType(TypeElement typeElement, ExecutableElement executableElement) {
            int size = executableElement.getParameters().size();
            ImmutableList<TypeMirror> erasedParameterTypes = erasedParameterTypes(executableElement, typeElement);
            if (erasedParameterTypes == null) {
                return null;
            }
            for (ExecutableElement executableElement2 : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
                if (executableElement2.getSimpleName().equals(executableElement.getSimpleName()) && executableElement2.getParameters().size() == size) {
                    int i = 0;
                    while (i < size) {
                        if (this.typeUtils.isSameType(erasedParameterTypes.get(i), this.typeUtils.erasure(((VariableElement) executableElement2.getParameters().get(i)).asType()))) {
                            i++;
                        }
                    }
                    return executableElement2;
                }
            }
            return null;
        }

        private TypeElement superclass(TypeElement typeElement) {
            TypeMirror superclass = typeElement.getSuperclass();
            if (superclass.getKind() == TypeKind.DECLARED) {
                return MoreElements.asType(this.typeUtils.asElement(superclass));
            }
            return null;
        }

        private ImmutableList<TypeElement> superinterfaces(TypeElement typeElement) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (TypeMirror asElement : typeElement.getInterfaces()) {
                builder.add((Object) MoreElements.asType(this.typeUtils.asElement(asElement)));
            }
            return builder.build();
        }

        public TypeElement asTypeElement(TypeMirror typeMirror) {
            return MoreElements.asType(MoreTypes.asDeclared(typeMirror).asElement());
        }
    }
}

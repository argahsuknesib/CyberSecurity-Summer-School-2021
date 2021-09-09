package com.google.auto.common;

import com.google.auto.common.Overrides;
import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.SetMultimap;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleElementVisitor6;
import javax.lang.model.util.Types;

@Beta
public final class MoreElements {
    public static PackageElement getPackage(Element element) {
        while (element.getKind() != ElementKind.PACKAGE) {
            element = element.getEnclosingElement();
        }
        return (PackageElement) element;
    }

    static final class PackageElementVisitor extends CastingElementVisitor<PackageElement> {
        public static final PackageElementVisitor INSTANCE = new PackageElementVisitor();

        public final PackageElement visitPackage(PackageElement packageElement, Void voidR) {
            return packageElement;
        }

        PackageElementVisitor() {
            super("package element");
        }
    }

    public static PackageElement asPackage(Element element) {
        return (PackageElement) element.accept(PackageElementVisitor.INSTANCE, (Object) null);
    }

    static final class TypeElementVisitor extends CastingElementVisitor<TypeElement> {
        public static final TypeElementVisitor INSTANCE = new TypeElementVisitor();

        public final TypeElement visitType(TypeElement typeElement, Void voidR) {
            return typeElement;
        }

        TypeElementVisitor() {
            super("type element");
        }
    }

    public static boolean isType(Element element) {
        return element.getKind().isClass() || element.getKind().isInterface();
    }

    public static TypeElement asType(Element element) {
        return (TypeElement) element.accept(TypeElementVisitor.INSTANCE, (Object) null);
    }

    static final class VariableElementVisitor extends CastingElementVisitor<VariableElement> {
        public static final VariableElementVisitor INSTANCE = new VariableElementVisitor();

        public final VariableElement visitVariable(VariableElement variableElement, Void voidR) {
            return variableElement;
        }

        VariableElementVisitor() {
            super("variable element");
        }
    }

    public static VariableElement asVariable(Element element) {
        return (VariableElement) element.accept(VariableElementVisitor.INSTANCE, (Object) null);
    }

    static final class ExecutableElementVisitor extends CastingElementVisitor<ExecutableElement> {
        public static final ExecutableElementVisitor INSTANCE = new ExecutableElementVisitor();

        public final ExecutableElement visitExecutable(ExecutableElement executableElement, Void voidR) {
            return executableElement;
        }

        ExecutableElementVisitor() {
            super("executable element");
        }
    }

    public static ExecutableElement asExecutable(Element element) {
        return (ExecutableElement) element.accept(ExecutableElementVisitor.INSTANCE, (Object) null);
    }

    public static boolean isAnnotationPresent(Element element, Class<? extends Annotation> cls) {
        return getAnnotationMirror(element, cls).isPresent();
    }

    public static Optional<AnnotationMirror> getAnnotationMirror(Element element, Class<? extends Annotation> cls) {
        String canonicalName = cls.getCanonicalName();
        for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
            if (asType(annotationMirror.getAnnotationType().asElement()).getQualifiedName().contentEquals(canonicalName)) {
                return Optional.of(annotationMirror);
            }
        }
        return Optional.absent();
    }

    public static <T extends Element> Predicate<T> hasModifiers(Modifier... modifierArr) {
        return hasModifiers(ImmutableSet.copyOf(modifierArr));
    }

    public static <T extends Element> Predicate<T> hasModifiers(final Set<Modifier> set) {
        return new Predicate<T>() {
            /* class com.google.auto.common.MoreElements.AnonymousClass1 */

            public /* synthetic */ boolean test(T t) {
                return Predicate.CC.$default$test(this, t);
            }

            public final boolean apply(T t) {
                return t.getModifiers().containsAll(set);
            }
        };
    }

    @Deprecated
    public static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Elements elements) {
        return getLocalAndInheritedMethods(typeElement, new Overrides.NativeOverrides(elements));
    }

    public static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Types types, Elements elements) {
        return getLocalAndInheritedMethods(typeElement, new Overrides.ExplicitOverrides(types));
    }

    private static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Overrides overrides) {
        LinkedHashMultimap create = LinkedHashMultimap.create();
        getLocalAndInheritedMethods(getPackage(typeElement), typeElement, create);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Collection copyOf : create.asMap().values()) {
            ImmutableList copyOf2 = ImmutableList.copyOf(copyOf);
            int i = 0;
            while (i < copyOf2.size()) {
                ExecutableElement executableElement = (ExecutableElement) copyOf2.get(i);
                i++;
                for (int i2 = i; i2 < copyOf2.size(); i2++) {
                    if (overrides.overrides((ExecutableElement) copyOf2.get(i2), executableElement, typeElement)) {
                        linkedHashSet.add(executableElement);
                    }
                }
            }
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(create.values());
        linkedHashSet2.removeAll(linkedHashSet);
        return ImmutableSet.copyOf((Collection) linkedHashSet2);
    }

    private static void getLocalAndInheritedMethods(PackageElement packageElement, TypeElement typeElement, SetMultimap<String, ExecutableElement> setMultimap) {
        for (TypeMirror asTypeElement : typeElement.getInterfaces()) {
            getLocalAndInheritedMethods(packageElement, MoreTypes.asTypeElement(asTypeElement), setMultimap);
        }
        if (typeElement.getSuperclass().getKind() != TypeKind.NONE) {
            getLocalAndInheritedMethods(packageElement, MoreTypes.asTypeElement(typeElement.getSuperclass()), setMultimap);
        }
        for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
            if (!executableElement.getModifiers().contains(Modifier.STATIC) && methodVisibleFromPackage(executableElement, packageElement)) {
                setMultimap.put(executableElement.getSimpleName().toString(), executableElement);
            }
        }
    }

    /* renamed from: com.google.auto.common.MoreElements$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$auto$common$Visibility = new int[Visibility.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$google$auto$common$Visibility[Visibility.PRIVATE.ordinal()] = 1;
            $SwitchMap$com$google$auto$common$Visibility[Visibility.DEFAULT.ordinal()] = 2;
        }
    }

    static boolean methodVisibleFromPackage(ExecutableElement executableElement, PackageElement packageElement) {
        int i = AnonymousClass2.$SwitchMap$com$google$auto$common$Visibility[Visibility.ofElement(executableElement).ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return true;
        }
        return getPackage(executableElement).equals(packageElement);
    }

    static abstract class CastingElementVisitor<T> extends SimpleElementVisitor6<T, Void> {
        private final String label;

        CastingElementVisitor(String str) {
            this.label = str;
        }

        /* access modifiers changed from: protected */
        public final T defaultAction(Element element, Void voidR) {
            throw new IllegalArgumentException(element + " does not represent a " + this.label);
        }
    }

    private MoreElements() {
    }
}

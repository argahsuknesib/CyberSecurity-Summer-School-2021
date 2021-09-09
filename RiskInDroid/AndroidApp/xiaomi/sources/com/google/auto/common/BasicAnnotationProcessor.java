package com.google.auto.common;

import com.google.common.base.Ascii;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleElementVisitor6;
import javax.tools.Diagnostic;

public abstract class BasicAnnotationProcessor extends AbstractProcessor {
    private final Set<ElementName> deferredElementNames = new LinkedHashSet();
    private Elements elements;
    private final SetMultimap<ProcessingStep, ElementName> elementsDeferredBySteps = LinkedHashMultimap.create();
    private Messager messager;
    private ImmutableList<? extends ProcessingStep> steps;

    public interface ProcessingStep {
        Set<? extends Class<? extends Annotation>> annotations();

        Set<? extends Element> process(SetMultimap<Class<? extends Annotation>, Element> setMultimap);
    }

    /* access modifiers changed from: protected */
    public abstract Iterable<? extends ProcessingStep> initSteps();

    /* access modifiers changed from: protected */
    @Deprecated
    public void postProcess() {
    }

    public final synchronized void init(ProcessingEnvironment processingEnvironment) {
        BasicAnnotationProcessor.super.init(processingEnvironment);
        this.elements = processingEnvironment.getElementUtils();
        this.messager = processingEnvironment.getMessager();
        this.steps = ImmutableList.copyOf(initSteps());
    }

    /* access modifiers changed from: protected */
    public void postRound(RoundEnvironment roundEnvironment) {
        if (!roundEnvironment.processingOver()) {
            postProcess();
        }
    }

    private ImmutableSet<? extends Class<? extends Annotation>> getSupportedAnnotationClasses() {
        Preconditions.checkState(this.steps != null);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<? extends ProcessingStep> it = this.steps.iterator();
        while (it.hasNext()) {
            builder.addAll((Iterable) ((ProcessingStep) it.next()).annotations());
        }
        return builder.build();
    }

    public final ImmutableSet<String> getSupportedAnnotationTypes() {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<? extends Class<? extends Annotation>> it = getSupportedAnnotationClasses().iterator();
        while (it.hasNext()) {
            builder.add((Object) ((Class) it.next()).getCanonicalName());
        }
        return builder.build();
    }

    public final boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        boolean z = true;
        Preconditions.checkState(this.elements != null);
        Preconditions.checkState(this.messager != null);
        if (this.steps == null) {
            z = false;
        }
        Preconditions.checkState(z);
        ImmutableMap<String, Optional<? extends Element>> deferredElements = deferredElements();
        this.deferredElementNames.clear();
        if (roundEnvironment.processingOver()) {
            postRound(roundEnvironment);
            reportMissingElements(deferredElements, this.elementsDeferredBySteps.values());
            return false;
        }
        process(validElements(deferredElements, roundEnvironment));
        postRound(roundEnvironment);
        return false;
    }

    private ImmutableMap<String, Optional<? extends Element>> deferredElements() {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (ElementName next : this.deferredElementNames) {
            builder.put(next.name(), next.getElement(this.elements));
        }
        return builder.build();
    }

    private void reportMissingElements(Map<String, ? extends Optional<? extends Element>> map, Collection<ElementName> collection) {
        if (!collection.isEmpty()) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            builder.putAll(map);
            for (ElementName next : collection) {
                if (!map.containsKey(next.name())) {
                    builder.put(next.name(), next.getElement(this.elements));
                }
            }
            map = builder.build();
        }
        for (Map.Entry next2 : map.entrySet()) {
            Optional optional = (Optional) next2.getValue();
            if (optional.isPresent()) {
                Messager messager2 = this.processingEnv.getMessager();
                Diagnostic.Kind kind = Diagnostic.Kind.ERROR;
                messager2.printMessage(kind, processingErrorMessage("this " + Ascii.toLowerCase(((Element) optional.get()).getKind().name())), (Element) optional.get());
            } else {
                this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, processingErrorMessage((String) next2.getKey()));
            }
        }
    }

    private String processingErrorMessage(String str) {
        return String.format("[%s:MiscError] %s was unable to process %s because not all of its dependencies could be resolved. Check for compilation errors or a circular dependency with generated code.", getClass().getSimpleName(), getClass().getCanonicalName(), str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
     arg types: [java.lang.Class, javax.lang.model.element.PackageElement]
     candidates:
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V> */
    private ImmutableSetMultimap<Class<? extends Annotation>, Element> validElements(ImmutableMap<String, Optional<? extends Element>> immutableMap, RoundEnvironment roundEnvironment) {
        Object obj;
        ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
        UnmodifiableIterator<Map.Entry<String, Optional<? extends Element>>> it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            Optional optional = (Optional) next.getValue();
            if (optional.isPresent()) {
                findAnnotatedElements((Element) optional.get(), getSupportedAnnotationClasses(), builder);
            } else {
                this.deferredElementNames.add(ElementName.forTypeName((String) next.getKey()));
            }
        }
        ImmutableSetMultimap build = builder.build();
        ImmutableSetMultimap.Builder builder2 = ImmutableSetMultimap.builder();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        UnmodifiableIterator<? extends Class<? extends Annotation>> it2 = getSupportedAnnotationClasses().iterator();
        while (it2.hasNext()) {
            Class cls = (Class) it2.next();
            TypeElement typeElement = this.elements.getTypeElement(cls.getCanonicalName());
            if (typeElement == null) {
                obj = ImmutableSet.of();
            } else {
                obj = roundEnvironment.getElementsAnnotatedWith(typeElement);
            }
            UnmodifiableIterator it3 = Sets.union(obj, build.get((Object) cls)).iterator();
            while (it3.hasNext()) {
                PackageElement packageElement = (Element) it3.next();
                boolean z = false;
                if (packageElement.getKind().equals(ElementKind.PACKAGE)) {
                    PackageElement packageElement2 = packageElement;
                    ElementName forPackageName = ElementName.forPackageName(packageElement2.getQualifiedName().toString());
                    if (linkedHashSet.contains(forPackageName) || (!this.deferredElementNames.contains(forPackageName) && SuperficialValidation.validateElement(packageElement2))) {
                        z = true;
                    }
                    if (z) {
                        builder2.put((Class<? extends Annotation>) cls, (Element) packageElement2);
                        linkedHashSet.add(forPackageName);
                    } else {
                        this.deferredElementNames.add(forPackageName);
                    }
                } else {
                    TypeElement enclosingType = getEnclosingType(packageElement);
                    ElementName forTypeName = ElementName.forTypeName(enclosingType.getQualifiedName().toString());
                    if (linkedHashSet.contains(forTypeName) || (!this.deferredElementNames.contains(forTypeName) && SuperficialValidation.validateElement(enclosingType))) {
                        z = true;
                    }
                    if (z) {
                        builder2.put((Class<? extends Annotation>) cls, (Element) packageElement);
                        linkedHashSet.add(forTypeName);
                    } else {
                        this.deferredElementNames.add(forTypeName);
                    }
                }
            }
        }
        return builder2.build();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.SetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V>
     arg types: [com.google.common.collect.ImmutableSetMultimap<java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element>, com.google.common.base.Predicate]
     candidates:
      com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.ListMultimap, com.google.common.base.Predicate):com.google.common.collect.ListMultimap<K, V>
      com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.Multimap, com.google.common.base.Predicate):com.google.common.collect.Multimap<K, V>
      com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.SetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.SetMultimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Set<V>
     arg types: [com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable]
     candidates:
      com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
      com.google.common.collect.SetMultimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Set<V> */
    private void process(ImmutableSetMultimap<Class<? extends Annotation>, Element> immutableSetMultimap) {
        UnmodifiableIterator<? extends ProcessingStep> it = this.steps.iterator();
        while (it.hasNext()) {
            ProcessingStep processingStep = (ProcessingStep) it.next();
            ImmutableSetMultimap build = new ImmutableSetMultimap.Builder().putAll((Multimap) indexByAnnotation(this.elementsDeferredBySteps.get(processingStep))).putAll((Multimap) Multimaps.filterKeys((SetMultimap) immutableSetMultimap, Predicates.in(processingStep.annotations()))).build();
            if (build.isEmpty()) {
                this.elementsDeferredBySteps.removeAll((Object) processingStep);
            } else {
                this.elementsDeferredBySteps.replaceValues(processingStep, (Iterable<? extends ElementName>) Iterables.transform(processingStep.process(build), new Function<Element, ElementName>() {
                    /* class com.google.auto.common.BasicAnnotationProcessor.AnonymousClass1 */

                    public ElementName apply(Element element) {
                        return ElementName.forAnnotatedElement(element);
                    }
                }));
            }
        }
    }

    private ImmutableSetMultimap<Class<? extends Annotation>, Element> indexByAnnotation(Set<ElementName> set) {
        ImmutableSet<? extends Class<? extends Annotation>> supportedAnnotationClasses = getSupportedAnnotationClasses();
        ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
        for (ElementName element : set) {
            Optional<? extends Element> element2 = element.getElement(this.elements);
            if (element2.isPresent()) {
                findAnnotatedElements(element2.get(), supportedAnnotationClasses, builder);
            }
        }
        return builder.build();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
     arg types: [java.lang.Class, javax.lang.model.element.Element]
     candidates:
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V> */
    private static void findAnnotatedElements(Element element, ImmutableSet<? extends Class<? extends Annotation>> immutableSet, ImmutableSetMultimap.Builder<Class<? extends Annotation>, Element> builder) {
        for (Element element2 : element.getEnclosedElements()) {
            if (!element2.getKind().isClass() && !element2.getKind().isInterface()) {
                findAnnotatedElements(element2, immutableSet, builder);
            }
        }
        if (element instanceof ExecutableElement) {
            for (Element findAnnotatedElements : ((ExecutableElement) element).getParameters()) {
                findAnnotatedElements(findAnnotatedElements, immutableSet, builder);
            }
        }
        UnmodifiableIterator<? extends Class<? extends Annotation>> it = immutableSet.iterator();
        while (it.hasNext()) {
            Class cls = (Class) it.next();
            if (MoreElements.isAnnotationPresent(element, cls)) {
                builder.put((Class<? extends Annotation>) cls, element);
            }
        }
    }

    public static TypeElement getEnclosingType(Element element) {
        return (TypeElement) element.accept(new SimpleElementVisitor6<TypeElement, Void>() {
            /* class com.google.auto.common.BasicAnnotationProcessor.AnonymousClass2 */

            public final TypeElement visitType(TypeElement typeElement, Void voidR) {
                return typeElement;
            }

            /* access modifiers changed from: protected */
            public final TypeElement defaultAction(Element element, Void voidR) {
                return (TypeElement) element.getEnclosingElement().accept(this, voidR);
            }

            public final TypeElement visitPackage(PackageElement packageElement, Void voidR) {
                throw new IllegalArgumentException();
            }
        }, (Object) null);
    }

    static final class ElementName {
        private final Kind kind;
        private final String name;

        enum Kind {
            PACKAGE_NAME,
            TYPE_NAME
        }

        private ElementName(Kind kind2, String str) {
            this.kind = (Kind) Preconditions.checkNotNull(kind2);
            this.name = (String) Preconditions.checkNotNull(str);
        }

        static ElementName forPackageName(String str) {
            return new ElementName(Kind.PACKAGE_NAME, str);
        }

        static ElementName forTypeName(String str) {
            return new ElementName(Kind.TYPE_NAME, str);
        }

        static ElementName forAnnotatedElement(Element element) {
            if (element.getKind() == ElementKind.PACKAGE) {
                return forPackageName(((PackageElement) element).getQualifiedName().toString());
            }
            return forTypeName(BasicAnnotationProcessor.getEnclosingType(element).getQualifiedName().toString());
        }

        /* access modifiers changed from: package-private */
        public final String name() {
            return this.name;
        }

        /* access modifiers changed from: package-private */
        public final Optional<? extends Element> getElement(Elements elements) {
            PackageElement packageElement;
            if (this.kind == Kind.PACKAGE_NAME) {
                packageElement = elements.getPackageElement(this.name);
            } else {
                packageElement = elements.getTypeElement(this.name);
            }
            return Optional.fromNullable(packageElement);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ElementName)) {
                return false;
            }
            ElementName elementName = (ElementName) obj;
            if (this.kind != elementName.kind || !this.name.equals(elementName.name)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Objects.hash(this.kind, this.name);
        }
    }
}

package com.google.auto.service.processor;

import com.google.auto.common.AnnotationMirrors;
import com.google.auto.common.MoreElements;
import com.google.auto.common.MoreTypes;
import com.google.auto.service.AutoService;
import com.google.auto.service.processor.AutoServiceProcessor;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedOptions;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor8;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedOptions({"debug", "verify"})
public class AutoServiceProcessor extends AbstractProcessor {
    private Multimap<String, String> providers = HashMultimap.create();

    public ImmutableSet<String> getSupportedAnnotationTypes() {
        return ImmutableSet.of(AutoService.class.getName());
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        try {
            return processImpl(set, roundEnvironment);
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            fatalError(stringWriter.toString());
            return true;
        }
    }

    private boolean processImpl(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (roundEnvironment.processingOver()) {
            generateConfigFiles();
            return true;
        }
        processAnnotations(set, roundEnvironment);
        return true;
    }

    private void processAnnotations(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<TypeElement> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(AutoService.class);
        log(set.toString());
        log(elementsAnnotatedWith.toString());
        for (TypeElement typeElement : elementsAnnotatedWith) {
            TypeElement typeElement2 = typeElement;
            AnnotationMirror annotationMirror = MoreElements.getAnnotationMirror(typeElement, AutoService.class).get();
            ImmutableSet<DeclaredType> valueFieldOfClasses = getValueFieldOfClasses(annotationMirror);
            if (valueFieldOfClasses.isEmpty()) {
                error("No service interfaces provided for element!", typeElement, annotationMirror);
            } else {
                for (DeclaredType asTypeElement : valueFieldOfClasses) {
                    TypeElement asTypeElement2 = MoreTypes.asTypeElement(asTypeElement);
                    log("provider interface: " + asTypeElement2.getQualifiedName());
                    log("provider implementer: " + typeElement2.getQualifiedName());
                    if (checkImplementer(typeElement2, asTypeElement2)) {
                        this.providers.put(getBinaryName(asTypeElement2), getBinaryName(typeElement2));
                    } else {
                        error("ServiceProviders must implement their service provider interface. " + typeElement2.getQualifiedName() + " does not implement " + asTypeElement2.getQualifiedName(), typeElement, annotationMirror);
                    }
                }
            }
        }
    }

    private void generateConfigFiles() {
        Filer filer = this.processingEnv.getFiler();
        for (String next : this.providers.keySet()) {
            String concat = "META-INF/services/".concat(String.valueOf(next));
            log("Working on resource file: ".concat(String.valueOf(concat)));
            try {
                TreeSet newTreeSet = Sets.newTreeSet();
                try {
                    FileObject resource = filer.getResource(StandardLocation.CLASS_OUTPUT, "", concat);
                    log("Looking for existing resource file at " + resource.toUri());
                    Set<String> readServiceFile = ServicesFiles.readServiceFile(resource.openInputStream());
                    log("Existing service entries: ".concat(String.valueOf(readServiceFile)));
                    newTreeSet.addAll(readServiceFile);
                } catch (IOException unused) {
                    log("Resource file did not already exist.");
                }
                HashSet hashSet = new HashSet(this.providers.get(next));
                if (newTreeSet.containsAll(hashSet)) {
                    log("No new service entries being added.");
                    return;
                }
                newTreeSet.addAll(hashSet);
                log("New service file contents: ".concat(String.valueOf(newTreeSet)));
                FileObject createResource = filer.createResource(StandardLocation.CLASS_OUTPUT, "", concat, new Element[0]);
                OutputStream openOutputStream = createResource.openOutputStream();
                ServicesFiles.writeServiceFile(newTreeSet, openOutputStream);
                openOutputStream.close();
                log("Wrote to: " + createResource.toUri());
            } catch (IOException e) {
                fatalError("Unable to create " + concat + ", " + e);
                return;
            }
        }
    }

    private boolean checkImplementer(TypeElement typeElement, TypeElement typeElement2) {
        String str = (String) this.processingEnv.getOptions().get("verify");
        if (str == null || !Boolean.valueOf(str).booleanValue()) {
            return true;
        }
        return this.processingEnv.getTypeUtils().isSubtype(typeElement.asType(), typeElement2.asType());
    }

    private String getBinaryName(TypeElement typeElement) {
        return getBinaryNameImpl(typeElement, typeElement.getSimpleName().toString());
    }

    private String getBinaryNameImpl(TypeElement typeElement, String str) {
        PackageElement enclosingElement;
        while (true) {
            enclosingElement = typeElement.getEnclosingElement();
            if (enclosingElement instanceof PackageElement) {
                break;
            }
            typeElement = (TypeElement) enclosingElement;
            str = typeElement.getSimpleName() + "$" + str;
        }
        PackageElement packageElement = enclosingElement;
        if (packageElement.isUnnamed()) {
            return str;
        }
        return packageElement.getQualifiedName() + "." + str;
    }

    private ImmutableSet<DeclaredType> getValueFieldOfClasses(AnnotationMirror annotationMirror) {
        return (ImmutableSet) AnnotationMirrors.getAnnotationValue(annotationMirror, "value").accept(new SimpleAnnotationValueVisitor8<ImmutableSet<DeclaredType>, Void>() {
            /* class com.google.auto.service.processor.AutoServiceProcessor.AnonymousClass1 */

            public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
                return visitArray((List<? extends AnnotationValue>) list, (Void) obj);
            }

            public ImmutableSet<DeclaredType> visitType(TypeMirror typeMirror, Void voidR) {
                return ImmutableSet.of(MoreTypes.asDeclared(typeMirror));
            }

            public ImmutableSet<DeclaredType> visitArray(List<? extends AnnotationValue> list, Void voidR) {
                return (ImmutableSet) list.stream().flatMap(new Function() {
                    /* class com.google.auto.service.processor.$$Lambda$AutoServiceProcessor$1$EKVwPyX4p6l2GcsBXdQApcF_0Zk */

                    public final Object apply(Object obj) {
                        return AutoServiceProcessor.AnonymousClass1.this.lambda$visitArray$0$AutoServiceProcessor$1((AnnotationValue) obj);
                    }
                }).collect(ImmutableSet.toImmutableSet());
            }

            public /* synthetic */ Stream lambda$visitArray$0$AutoServiceProcessor$1(AnnotationValue annotationValue) {
                return ((ImmutableSet) annotationValue.accept(this, (Object) null)).stream();
            }
        }, (Object) null);
    }

    private void log(String str) {
        if (this.processingEnv.getOptions().containsKey("debug")) {
            this.processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, str);
        }
    }

    private void error(String str, Element element, AnnotationMirror annotationMirror) {
        this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, str, element, annotationMirror);
    }

    private void fatalError(String str) {
        this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "FATAL ERROR: ".concat(String.valueOf(str)));
    }
}

package com.google.auto.common;

import java.util.Optional;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

public final class GeneratedAnnotations {
    private GeneratedAnnotations() {
    }

    @Deprecated
    public static Optional<TypeElement> generatedAnnotation(Elements elements) {
        TypeElement typeElement = elements.getTypeElement("javax.annotation.processing.Generated");
        if (typeElement != null) {
            return Optional.of(typeElement);
        }
        return Optional.ofNullable(elements.getTypeElement("javax.annotation.Generated"));
    }

    public static Optional<TypeElement> generatedAnnotation(Elements elements, SourceVersion sourceVersion) {
        return Optional.ofNullable(elements.getTypeElement(sourceVersion.compareTo(SourceVersion.RELEASE_8) > 0 ? "javax.annotation.processing.Generated" : "javax.annotation.Generated"));
    }
}

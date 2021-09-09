package com.google.auto.common;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import java.util.Optional;
import java.util.function.Function;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

public final class GeneratedAnnotationSpecs {
    private GeneratedAnnotationSpecs() {
    }

    @Deprecated
    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, Class<?> cls) {
        return generatedAnnotationSpecBuilder(elements, cls).map($$Lambda$GeneratedAnnotationSpecs$M6opZya8CNYuC2PK3RfVwXq0r2I.INSTANCE);
    }

    @Deprecated
    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, Class<?> cls, String str) {
        return generatedAnnotationSpecBuilder(elements, cls).map(new Function(str) {
            /* class com.google.auto.common.$$Lambda$GeneratedAnnotationSpecs$ozDHBZRnCt1UM6WEUcc6ChBrFI */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return ((AnnotationSpec.Builder) obj).addMember("comments", "$S", new Object[]{this.f$0}).build();
            }
        });
    }

    private static Optional<AnnotationSpec.Builder> generatedAnnotationSpecBuilder(Elements elements, Class<?> cls) {
        return GeneratedAnnotations.generatedAnnotation(elements).map(new Function(cls) {
            /* class com.google.auto.common.$$Lambda$GeneratedAnnotationSpecs$xYb19lJcpHzJMLzL6q1dh9wwsY4 */
            private final /* synthetic */ Class f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return AnnotationSpec.builder(ClassName.get((TypeElement) obj)).addMember("value", "$S", new Object[]{this.f$0.getCanonicalName()});
            }
        });
    }

    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, SourceVersion sourceVersion, Class<?> cls) {
        return generatedAnnotationSpecBuilder(elements, sourceVersion, cls).map($$Lambda$GeneratedAnnotationSpecs$M6opZya8CNYuC2PK3RfVwXq0r2I.INSTANCE);
    }

    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, SourceVersion sourceVersion, Class<?> cls, String str) {
        return generatedAnnotationSpecBuilder(elements, sourceVersion, cls).map(new Function(str) {
            /* class com.google.auto.common.$$Lambda$GeneratedAnnotationSpecs$DFhvX9UWY6WZPg1KAAtRkSOnw8 */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return ((AnnotationSpec.Builder) obj).addMember("comments", "$S", new Object[]{this.f$0}).build();
            }
        });
    }

    private static Optional<AnnotationSpec.Builder> generatedAnnotationSpecBuilder(Elements elements, SourceVersion sourceVersion, Class<?> cls) {
        return GeneratedAnnotations.generatedAnnotation(elements, sourceVersion).map(new Function(cls) {
            /* class com.google.auto.common.$$Lambda$GeneratedAnnotationSpecs$PqbkjZnROsGkGnp3KvI3PUAobKc */
            private final /* synthetic */ Class f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return AnnotationSpec.builder(ClassName.get((TypeElement) obj)).addMember("value", "$S", new Object[]{this.f$0.getCanonicalName()});
            }
        });
    }
}

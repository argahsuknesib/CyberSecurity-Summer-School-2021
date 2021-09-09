package com.google.auto.common;

import com.google.common.base.Enums;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;

public enum Visibility {
    PRIVATE,
    DEFAULT,
    PROTECTED,
    PUBLIC;
    
    private static final ElementKind MODULE = ((ElementKind) Enums.getIfPresent(ElementKind.class, "MODULE").orNull());

    public static Visibility ofElement(Element element) {
        Preconditions.checkNotNull(element);
        if (element.getKind().equals(ElementKind.PACKAGE) || element.getKind().equals(MODULE)) {
            return PUBLIC;
        }
        Set modifiers = element.getModifiers();
        if (modifiers.contains(Modifier.PRIVATE)) {
            return PRIVATE;
        }
        if (modifiers.contains(Modifier.PROTECTED)) {
            return PROTECTED;
        }
        if (modifiers.contains(Modifier.PUBLIC)) {
            return PUBLIC;
        }
        return DEFAULT;
    }

    public static Visibility effectiveVisibilityOfElement(Element element) {
        Preconditions.checkNotNull(element);
        Visibility visibility = PUBLIC;
        while (element != null) {
            visibility = (Visibility) Ordering.natural().min(visibility, ofElement(element));
            element = element.getEnclosingElement();
        }
        return visibility;
    }
}

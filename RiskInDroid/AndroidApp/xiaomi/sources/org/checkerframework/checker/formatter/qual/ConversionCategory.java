package org.checkerframework.checker.formatter.qual;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public enum ConversionCategory {
    GENERAL(null, "bBhHsS"),
    CHAR(new Class[]{Character.class, Byte.class, Short.class, Integer.class}, "cC"),
    INT(new Class[]{Byte.class, Short.class, Integer.class, Long.class, BigInteger.class}, "doxX"),
    FLOAT(new Class[]{Float.class, Double.class, BigDecimal.class}, "eEfgGaA"),
    TIME(new Class[]{Long.class, Calendar.class, Date.class}, "tT"),
    CHAR_AND_INT(new Class[]{Byte.class, Short.class, Integer.class}, null),
    INT_AND_TIME(new Class[]{Long.class}, null),
    NULL(new Class[0], null),
    UNUSED(null, null);
    
    public final String chars;
    public final Class<? extends Object>[] types;

    private ConversionCategory(Class<? extends Object>[] clsArr, String str) {
        this.types = clsArr;
        this.chars = str;
    }

    public static ConversionCategory fromConversionChar(char c) {
        ConversionCategory[] conversionCategoryArr = {GENERAL, CHAR, INT, FLOAT, TIME};
        for (int i = 0; i < 5; i++) {
            ConversionCategory conversionCategory = conversionCategoryArr[i];
            if (conversionCategory.chars.contains(String.valueOf(c))) {
                return conversionCategory;
            }
        }
        throw new IllegalArgumentException();
    }

    private static <E> Set<E> arrayToSet(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    public static boolean isSubsetOf(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        return intersect(conversionCategory, conversionCategory2) == conversionCategory;
    }

    public static ConversionCategory intersect(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3 = UNUSED;
        if (conversionCategory == conversionCategory3) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory3) {
            return conversionCategory;
        }
        ConversionCategory conversionCategory4 = GENERAL;
        if (conversionCategory == conversionCategory4) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory4) {
            return conversionCategory;
        }
        Set arrayToSet = arrayToSet(conversionCategory.types);
        arrayToSet.retainAll(arrayToSet(conversionCategory2.types));
        ConversionCategory[] conversionCategoryArr = {CHAR, INT, FLOAT, TIME, CHAR_AND_INT, INT_AND_TIME, NULL};
        for (int i = 0; i < 7; i++) {
            ConversionCategory conversionCategory5 = conversionCategoryArr[i];
            if (arrayToSet(conversionCategory5.types).equals(arrayToSet)) {
                return conversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    public static ConversionCategory union(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3 = UNUSED;
        if (conversionCategory == conversionCategory3 || conversionCategory2 == conversionCategory3) {
            return UNUSED;
        }
        ConversionCategory conversionCategory4 = GENERAL;
        if (conversionCategory == conversionCategory4 || conversionCategory2 == conversionCategory4) {
            return GENERAL;
        }
        if ((conversionCategory == CHAR_AND_INT && conversionCategory2 == INT_AND_TIME) || (conversionCategory == INT_AND_TIME && conversionCategory2 == CHAR_AND_INT)) {
            return INT;
        }
        Set arrayToSet = arrayToSet(conversionCategory.types);
        arrayToSet.addAll(arrayToSet(conversionCategory2.types));
        ConversionCategory[] conversionCategoryArr = {NULL, CHAR_AND_INT, INT_AND_TIME, CHAR, INT, FLOAT, TIME};
        for (int i = 0; i < 7; i++) {
            ConversionCategory conversionCategory5 = conversionCategoryArr[i];
            if (arrayToSet(conversionCategory5.types).equals(arrayToSet)) {
                return conversionCategory5;
            }
        }
        return GENERAL;
    }

    private String className(Class<?> cls) {
        if (cls == Boolean.class) {
            return "boolean";
        }
        if (cls == Character.class) {
            return "char";
        }
        if (cls == Byte.class) {
            return "byte";
        }
        if (cls == Short.class) {
            return "short";
        }
        if (cls == Integer.class) {
            return "int";
        }
        if (cls == Long.class) {
            return "long";
        }
        if (cls == Float.class) {
            return "float";
        }
        if (cls == Double.class) {
            return "double";
        }
        return cls.getSimpleName();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(name());
        sb.append(" conversion category (one of: ");
        Class<? extends Object>[] clsArr = this.types;
        int length = clsArr.length;
        int i = 0;
        boolean z = true;
        while (i < length) {
            Class<? extends Object> cls = clsArr[i];
            if (!z) {
                sb.append(", ");
            }
            sb.append(className(cls));
            i++;
            z = false;
        }
        sb.append(")");
        return sb.toString();
    }
}

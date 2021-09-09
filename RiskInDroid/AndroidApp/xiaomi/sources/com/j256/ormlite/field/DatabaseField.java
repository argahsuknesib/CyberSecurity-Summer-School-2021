package com.j256.ormlite.field;

import com.j256.ormlite.field.types.VoidType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseField {
    boolean allowGeneratedIdInsert() default false;

    boolean canBeNull() default true;

    String columnDefinition() default "";

    String columnName() default "";

    DataType dataType() default DataType.UNKNOWN;

    String defaultValue() default "__ormlite__ no default value string was specified";

    boolean foreign() default false;

    boolean foreignAutoCreate() default false;

    boolean foreignAutoRefresh() default false;

    String foreignColumnName() default "";

    String format() default "";

    String fullColumnDefinition() default "";

    boolean generatedId() default false;

    String generatedIdSequence() default "";

    boolean id() default false;

    boolean index() default false;

    String indexName() default "";

    int maxForeignAutoRefreshLevel() default 2;

    boolean persisted() default true;

    Class<? extends DataPersister> persisterClass() default VoidType.class;

    boolean readOnly() default false;

    boolean throwIfNull() default false;

    boolean unique() default false;

    boolean uniqueCombo() default false;

    boolean uniqueIndex() default false;

    String uniqueIndexName() default "";

    String unknownEnumName() default "";

    boolean useGetSet() default false;

    boolean version() default false;

    int width() default 0;
}

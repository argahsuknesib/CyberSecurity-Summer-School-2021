package com.j256.ormlite.field;

import java.lang.reflect.Field;
import java.sql.SQLException;

public interface DataPersister extends FieldConverter {
    Object convertIdNumber(Number number);

    boolean dataIsEqual(Object obj, Object obj2);

    Object generateId();

    String[] getAssociatedClassNames();

    Class<?>[] getAssociatedClasses();

    int getDefaultWidth();

    Class<?> getPrimaryClass();

    String getSqlOtherType();

    boolean isAppropriateId();

    boolean isArgumentHolderRequired();

    boolean isComparable();

    boolean isEscapedDefaultValue();

    boolean isEscapedValue();

    boolean isPrimitive();

    boolean isSelfGeneratedId();

    boolean isValidForField(Field field);

    boolean isValidForVersion();

    boolean isValidGeneratedType();

    Object makeConfigObject(FieldType fieldType) throws SQLException;

    Object moveToNextValue(Object obj) throws SQLException;
}

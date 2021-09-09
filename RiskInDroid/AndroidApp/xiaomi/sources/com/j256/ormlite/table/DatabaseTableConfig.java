package com.j256.ormlite.table;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.JavaxPersistenceConfigurer;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DatabaseTableConfig<T> {
    private static JavaxPersistenceConfigurer javaxPersistenceConfigurer;
    private Constructor<T> constructor;
    private Class<T> dataClass;
    private DatabaseType databaseType;
    private List<DatabaseFieldConfig> fieldConfigs;
    private FieldType[] fieldTypes;
    private String tableName;

    static {
        try {
            Class.forName("javax.persistence.Entity");
            javaxPersistenceConfigurer = (JavaxPersistenceConfigurer) Class.forName("com.j256.ormlite.misc.JavaxPersistenceImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            javaxPersistenceConfigurer = null;
        }
    }

    public DatabaseTableConfig() {
    }

    public DatabaseTableConfig(DatabaseType databaseType2, Class cls, List<DatabaseFieldConfig> list) {
        this(cls, extractTableName(databaseType2, cls), list);
    }

    public DatabaseTableConfig(Class cls, String str, List<DatabaseFieldConfig> list) {
        this.dataClass = cls;
        this.tableName = str;
        this.fieldConfigs = list;
    }

    private DatabaseTableConfig(DatabaseType databaseType2, Class<T> cls, String str, FieldType[] fieldTypeArr) {
        this.databaseType = databaseType2;
        this.dataClass = cls;
        this.tableName = str;
        this.fieldTypes = fieldTypeArr;
    }

    public void initialize() {
        Class<T> cls = this.dataClass;
        if (cls == null) {
            throw new IllegalStateException("dataClass was never set on " + getClass().getSimpleName());
        } else if (this.tableName == null) {
            this.tableName = extractTableName(this.databaseType, cls);
        }
    }

    public void setDatabaseType(DatabaseType databaseType2) {
        this.databaseType = databaseType2;
    }

    public Class<T> getDataClass() {
        return this.dataClass;
    }

    public void setDataClass(Class<T> cls) {
        this.dataClass = cls;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public void setFieldConfigs(List<DatabaseFieldConfig> list) {
        this.fieldConfigs = list;
    }

    public void extractFieldTypes(ConnectionSource connectionSource) throws SQLException {
        if (this.fieldTypes == null) {
            List<DatabaseFieldConfig> list = this.fieldConfigs;
            if (list == null) {
                this.fieldTypes = extractFieldTypes(connectionSource, this.dataClass, this.tableName);
            } else {
                this.fieldTypes = convertFieldConfigs(connectionSource, this.tableName, list);
            }
        }
    }

    public FieldType[] getFieldTypes(DatabaseType databaseType2) throws SQLException {
        FieldType[] fieldTypeArr = this.fieldTypes;
        if (fieldTypeArr != null) {
            return fieldTypeArr;
        }
        throw new SQLException("Field types have not been extracted in table config");
    }

    public List<DatabaseFieldConfig> getFieldConfigs() {
        return this.fieldConfigs;
    }

    public Constructor<T> getConstructor() {
        if (this.constructor == null) {
            this.constructor = findNoArgConstructor(this.dataClass);
        }
        return this.constructor;
    }

    public void setConstructor(Constructor<T> constructor2) {
        this.constructor = constructor2;
    }

    public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        DatabaseType databaseType2 = connectionSource.getDatabaseType();
        String extractTableName = extractTableName(databaseType2, cls);
        if (databaseType2.isEntityNamesMustBeUpCase()) {
            extractTableName = databaseType2.upCaseEntityName(extractTableName);
        }
        return new DatabaseTableConfig<>(databaseType2, cls, extractTableName, extractFieldTypes(connectionSource, cls, extractTableName));
    }

    public static <T> String extractTableName(DatabaseType databaseType2, Class<T> cls) {
        JavaxPersistenceConfigurer javaxPersistenceConfigurer2;
        DatabaseTable databaseTable = (DatabaseTable) cls.getAnnotation(DatabaseTable.class);
        String tableName2 = (databaseTable == null || databaseTable.tableName() == null || databaseTable.tableName().length() <= 0) ? null : databaseTable.tableName();
        if (tableName2 == null && (javaxPersistenceConfigurer2 = javaxPersistenceConfigurer) != null) {
            tableName2 = javaxPersistenceConfigurer2.getEntityName(cls);
        }
        if (tableName2 != null) {
            return tableName2;
        }
        if (databaseType2 == null) {
            return cls.getSimpleName().toLowerCase(Locale.ENGLISH);
        }
        return databaseType2.downCaseString(cls.getSimpleName(), true);
    }

    public static <T> Constructor<T> findNoArgConstructor(Class<T> cls) {
        try {
            for (Constructor<T> constructor2 : cls.getDeclaredConstructors()) {
                if (constructor2.getParameterTypes().length == 0) {
                    if (!constructor2.isAccessible()) {
                        try {
                            constructor2.setAccessible(true);
                        } catch (SecurityException unused) {
                            throw new IllegalArgumentException("Could not open access to constructor for ".concat(String.valueOf(cls)));
                        }
                    }
                    return constructor2;
                }
            }
            if (cls.getEnclosingClass() == null) {
                throw new IllegalArgumentException("Can't find a no-arg constructor for ".concat(String.valueOf(cls)));
            }
            throw new IllegalArgumentException("Can't find a no-arg constructor for " + cls + ".  Missing static on inner class?");
        } catch (Exception e) {
            throw new IllegalArgumentException("Can't lookup declared constructors for ".concat(String.valueOf(cls)), e);
        }
    }

    private static <T> FieldType[] extractFieldTypes(ConnectionSource connectionSource, Class<T> cls, String str) throws SQLException {
        ArrayList arrayList = new ArrayList();
        for (Class<T> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            for (Field createFieldType : cls2.getDeclaredFields()) {
                FieldType createFieldType2 = FieldType.createFieldType(connectionSource, str, createFieldType, cls);
                if (createFieldType2 != null) {
                    arrayList.add(createFieldType2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
        }
        throw new IllegalArgumentException("No fields have a " + DatabaseField.class.getSimpleName() + " annotation in " + cls);
    }

    private FieldType[] convertFieldConfigs(ConnectionSource connectionSource, String str, List<DatabaseFieldConfig> list) throws SQLException {
        ArrayList arrayList = new ArrayList();
        for (DatabaseFieldConfig next : list) {
            FieldType fieldType = null;
            Class<T> cls = this.dataClass;
            while (true) {
                if (cls == null) {
                    break;
                }
                try {
                    Field declaredField = cls.getDeclaredField(next.getFieldName());
                    if (declaredField != null) {
                        fieldType = new FieldType(connectionSource, str, declaredField, next, this.dataClass);
                        break;
                    }
                    cls = cls.getSuperclass();
                } catch (NoSuchFieldException unused) {
                }
            }
            if (fieldType != null) {
                arrayList.add(fieldType);
            } else {
                throw new SQLException("Could not find declared field with name '" + next.getFieldName() + "' for " + this.dataClass);
            }
        }
        if (!arrayList.isEmpty()) {
            return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
        }
        throw new SQLException("No fields were configured for class " + this.dataClass);
    }
}

package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TableInfo<T, ID> {
    private static final FieldType[] NO_FOREIGN_COLLECTIONS = new FieldType[0];
    private final BaseDaoImpl<T, ID> baseDaoImpl;
    private final Constructor<T> constructor;
    private final Class<T> dataClass;
    private final DatabaseType databaseType;
    private Map<String, FieldType> fieldNameMap;
    private final FieldType[] fieldTypes;
    private final boolean foreignAutoCreate;
    private final FieldType[] foreignCollections;
    private final FieldType idField;
    private final String tableName;

    public TableInfo(ConnectionSource connectionSource, BaseDaoImpl baseDaoImpl2, Class cls) throws SQLException {
        this(connectionSource.getDatabaseType(), baseDaoImpl2, DatabaseTableConfig.fromClass(connectionSource, cls));
    }

    public TableInfo(DatabaseType databaseType2, BaseDaoImpl baseDaoImpl2, DatabaseTableConfig databaseTableConfig) throws SQLException {
        this.databaseType = databaseType2;
        this.baseDaoImpl = baseDaoImpl2;
        this.dataClass = databaseTableConfig.getDataClass();
        this.tableName = databaseTableConfig.getTableName();
        this.fieldTypes = databaseTableConfig.getFieldTypes(databaseType2);
        FieldType fieldType = null;
        boolean z = false;
        int i = 0;
        for (FieldType fieldType2 : this.fieldTypes) {
            if (fieldType2.isId() || fieldType2.isGeneratedId() || fieldType2.isGeneratedIdSequence()) {
                if (fieldType == null) {
                    fieldType = fieldType2;
                } else {
                    throw new SQLException("More than 1 idField configured for class " + this.dataClass + " (" + fieldType + "," + fieldType2 + ")");
                }
            }
            z = fieldType2.isForeignAutoCreate() ? true : z;
            if (fieldType2.isForeignCollection()) {
                i++;
            }
        }
        this.idField = fieldType;
        this.constructor = databaseTableConfig.getConstructor();
        this.foreignAutoCreate = z;
        if (i == 0) {
            this.foreignCollections = NO_FOREIGN_COLLECTIONS;
            return;
        }
        this.foreignCollections = new FieldType[i];
        int i2 = 0;
        for (FieldType fieldType3 : this.fieldTypes) {
            if (fieldType3.isForeignCollection()) {
                this.foreignCollections[i2] = fieldType3;
                i2++;
            }
        }
    }

    public Class<T> getDataClass() {
        return this.dataClass;
    }

    public String getTableName() {
        return this.tableName;
    }

    public FieldType[] getFieldTypes() {
        return this.fieldTypes;
    }

    public FieldType getFieldTypeByColumnName(String str) {
        int i = 0;
        if (this.fieldNameMap == null) {
            HashMap hashMap = new HashMap();
            for (FieldType fieldType : this.fieldTypes) {
                hashMap.put(this.databaseType.downCaseString(fieldType.getColumnName(), true), fieldType);
            }
            this.fieldNameMap = hashMap;
        }
        FieldType fieldType2 = this.fieldNameMap.get(this.databaseType.downCaseString(str, true));
        if (fieldType2 != null) {
            return fieldType2;
        }
        FieldType[] fieldTypeArr = this.fieldTypes;
        int length = fieldTypeArr.length;
        while (i < length) {
            FieldType fieldType3 = fieldTypeArr[i];
            if (!fieldType3.getFieldName().equals(str)) {
                i++;
            } else {
                throw new IllegalArgumentException("You should use columnName '" + fieldType3.getColumnName() + "' for table " + this.tableName + " instead of fieldName '" + fieldType3.getFieldName() + "'");
            }
        }
        throw new IllegalArgumentException("Unknown column name '" + str + "' in table " + this.tableName);
    }

    public FieldType getIdField() {
        return this.idField;
    }

    public Constructor<T> getConstructor() {
        return this.constructor;
    }

    public String objectToString(T t) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(t.getClass().getSimpleName());
        FieldType[] fieldTypeArr = this.fieldTypes;
        int length = fieldTypeArr.length;
        int i = 0;
        while (i < length) {
            FieldType fieldType = fieldTypeArr[i];
            sb.append(' ');
            sb.append(fieldType.getColumnName());
            sb.append('=');
            try {
                sb.append(fieldType.extractJavaFieldValue(t));
                i++;
            } catch (Exception e) {
                throw new IllegalStateException("Could not generate toString of field ".concat(String.valueOf(fieldType)), e);
            }
        }
        return sb.toString();
    }

    public T createObject() throws SQLException {
        T t;
        ObjectFactory<T> objectFactory = null;
        try {
            if (this.baseDaoImpl != null) {
                objectFactory = this.baseDaoImpl.getObjectFactory();
            }
            if (objectFactory == null) {
                t = this.constructor.newInstance(new Object[0]);
            } else {
                t = objectFactory.createObject(this.constructor, this.baseDaoImpl.getDataClass());
            }
            wireNewInstance(this.baseDaoImpl, t);
            return t;
        } catch (Exception e) {
            throw SqlExceptionUtil.create("Could not create object for " + this.constructor.getDeclaringClass(), e);
        }
    }

    public boolean isUpdatable() {
        return this.idField != null && this.fieldTypes.length > 1;
    }

    public boolean isForeignAutoCreate() {
        return this.foreignAutoCreate;
    }

    public FieldType[] getForeignCollections() {
        return this.foreignCollections;
    }

    public boolean hasColumnName(String str) {
        for (FieldType columnName : this.fieldTypes) {
            if (columnName.getColumnName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static <T, ID> void wireNewInstance(BaseDaoImpl<T, ID> baseDaoImpl2, T t) {
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(baseDaoImpl2);
        }
    }
}

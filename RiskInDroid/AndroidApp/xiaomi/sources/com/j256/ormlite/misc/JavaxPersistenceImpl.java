package com.j256.ormlite.misc;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataPersisterManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import java.lang.reflect.Field;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

public class JavaxPersistenceImpl implements JavaxPersistenceConfigurer {
    public DatabaseFieldConfig createFieldConfig(DatabaseType databaseType, Field field) {
        FetchType fetch;
        Column annotation = field.getAnnotation(Column.class);
        Basic annotation2 = field.getAnnotation(Basic.class);
        Id annotation3 = field.getAnnotation(Id.class);
        GeneratedValue annotation4 = field.getAnnotation(GeneratedValue.class);
        OneToOne annotation5 = field.getAnnotation(OneToOne.class);
        ManyToOne annotation6 = field.getAnnotation(ManyToOne.class);
        JoinColumn annotation7 = field.getAnnotation(JoinColumn.class);
        Enumerated annotation8 = field.getAnnotation(Enumerated.class);
        Version annotation9 = field.getAnnotation(Version.class);
        if (annotation == null && annotation2 == null && annotation3 == null && annotation5 == null && annotation6 == null && annotation8 == null && annotation9 == null) {
            return null;
        }
        DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
        String name = field.getName();
        if (databaseType.isEntityNamesMustBeUpCase()) {
            name = databaseType.upCaseEntityName(name);
        }
        databaseFieldConfig.setFieldName(name);
        if (annotation != null) {
            if (stringNotEmpty(annotation.name())) {
                databaseFieldConfig.setColumnName(annotation.name());
            }
            if (stringNotEmpty(annotation.columnDefinition())) {
                databaseFieldConfig.setColumnDefinition(annotation.columnDefinition());
            }
            databaseFieldConfig.setWidth(annotation.length());
            databaseFieldConfig.setCanBeNull(annotation.nullable());
            databaseFieldConfig.setUnique(annotation.unique());
        }
        if (annotation2 != null) {
            databaseFieldConfig.setCanBeNull(annotation2.optional());
        }
        boolean z = true;
        if (annotation3 != null) {
            if (annotation4 == null) {
                databaseFieldConfig.setId(true);
            } else {
                databaseFieldConfig.setGeneratedId(true);
            }
        }
        if (!(annotation5 == null && annotation6 == null)) {
            if (Collection.class.isAssignableFrom(field.getType()) || ForeignCollection.class.isAssignableFrom(field.getType())) {
                databaseFieldConfig.setForeignCollection(true);
                if (annotation7 != null && stringNotEmpty(annotation7.name())) {
                    databaseFieldConfig.setForeignCollectionColumnName(annotation7.name());
                }
                if (!(annotation6 == null || (fetch = annotation6.fetch()) == null || fetch != FetchType.EAGER)) {
                    databaseFieldConfig.setForeignCollectionEager(true);
                }
            } else {
                databaseFieldConfig.setForeign(true);
                if (annotation7 != null) {
                    if (stringNotEmpty(annotation7.name())) {
                        databaseFieldConfig.setColumnName(annotation7.name());
                    }
                    databaseFieldConfig.setCanBeNull(annotation7.nullable());
                    databaseFieldConfig.setUnique(annotation7.unique());
                }
            }
        }
        if (annotation8 != null) {
            EnumType value = annotation8.value();
            if (value == null || value != EnumType.STRING) {
                databaseFieldConfig.setDataType(DataType.ENUM_INTEGER);
            } else {
                databaseFieldConfig.setDataType(DataType.ENUM_STRING);
            }
        }
        if (annotation9 != null) {
            databaseFieldConfig.setVersion(true);
        }
        if (databaseFieldConfig.getDataPersister() == null) {
            databaseFieldConfig.setDataPersister(DataPersisterManager.lookupForField(field));
        }
        if (DatabaseFieldConfig.findGetMethod(field, databaseType, false) == null || DatabaseFieldConfig.findSetMethod(field, databaseType, false) == null) {
            z = false;
        }
        databaseFieldConfig.setUseGetSet(z);
        return databaseFieldConfig;
    }

    public String getEntityName(Class<?> cls) {
        Entity annotation = cls.getAnnotation(Entity.class);
        Table annotation2 = cls.getAnnotation(Table.class);
        if (annotation != null && stringNotEmpty(annotation.name())) {
            return annotation.name();
        }
        if (annotation2 == null || !stringNotEmpty(annotation2.name())) {
            return null;
        }
        return annotation2.name();
    }

    private boolean stringNotEmpty(String str) {
        return str != null && str.length() > 0;
    }
}

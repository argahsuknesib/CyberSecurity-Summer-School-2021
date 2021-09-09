package com.j256.ormlite.android;

import android.os.Build;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.ArrayList;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class DatabaseTableConfigUtil {
    private static Class<?> annotationFactoryClazz;
    private static Class<?> annotationMemberClazz;
    private static final int[] configFieldNums;
    private static Field elementsField;
    private static Field nameField;
    private static Field valueField;
    private static int workedC;

    static {
        if (Build.VERSION.SDK_INT >= 14 || System.getProperty("ormlite.annotation.hack.disable") != null) {
            configFieldNums = null;
        } else {
            configFieldNums = lookupClasses();
        }
    }

    public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        String extractTableName = DatabaseTableConfig.extractTableName(databaseType, cls);
        ArrayList arrayList = new ArrayList();
        for (Class<T> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            for (Field configFromField : cls2.getDeclaredFields()) {
                DatabaseFieldConfig configFromField2 = configFromField(databaseType, extractTableName, configFromField);
                if (configFromField2 != null && configFromField2.isPersisted()) {
                    arrayList.add(configFromField2);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return new DatabaseTableConfig<>(cls, extractTableName, arrayList);
    }

    public static int getWorkedC() {
        return workedC;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private static int[] lookupClasses() {
        Object obj;
        annotationFactoryClazz = Class.forName("org.apache.harmony.lang.annotation.AnnotationFactory");
        annotationMemberClazz = Class.forName("org.apache.harmony.lang.annotation.AnnotationMember");
        Class<?> cls = Class.forName("[Lorg.apache.harmony.lang.annotation.AnnotationMember;");
        try {
            Field declaredField = annotationFactoryClazz.getDeclaredField("elements");
            elementsField = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = annotationMemberClazz.getDeclaredField("name");
            nameField = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = annotationMemberClazz.getDeclaredField("value");
            valueField = declaredField3;
            declaredField3.setAccessible(true);
            InvocationHandler invocationHandler = Proxy.getInvocationHandler((DatabaseField) DatabaseFieldSample.class.getDeclaredField("field").getAnnotation(DatabaseField.class));
            if (invocationHandler.getClass() == annotationFactoryClazz && (obj = elementsField.get(invocationHandler)) != null) {
                if (obj.getClass() == cls) {
                    Object[] objArr = (Object[]) obj;
                    int[] iArr = new int[objArr.length];
                    for (int i = 0; i < objArr.length; i++) {
                        iArr[i] = configFieldNameToNum((String) nameField.get(objArr[i]));
                    }
                    return iArr;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return null;
    }

    private static int configFieldNameToNum(String str) {
        if (str.equals("columnName")) {
            return 1;
        }
        if (str.equals("dataType")) {
            return 2;
        }
        if (str.equals("defaultValue")) {
            return 3;
        }
        if (str.equals("width")) {
            return 4;
        }
        if (str.equals("canBeNull")) {
            return 5;
        }
        if (str.equals("id")) {
            return 6;
        }
        if (str.equals("generatedId")) {
            return 7;
        }
        if (str.equals("generatedIdSequence")) {
            return 8;
        }
        if (str.equals("foreign")) {
            return 9;
        }
        if (str.equals("useGetSet")) {
            return 10;
        }
        if (str.equals("unknownEnumName")) {
            return 11;
        }
        if (str.equals("throwIfNull")) {
            return 12;
        }
        if (str.equals("persisted")) {
            return 13;
        }
        if (str.equals("format")) {
            return 14;
        }
        if (str.equals("unique")) {
            return 15;
        }
        if (str.equals("uniqueCombo")) {
            return 16;
        }
        if (str.equals("index")) {
            return 17;
        }
        if (str.equals("uniqueIndex")) {
            return 18;
        }
        if (str.equals("indexName")) {
            return 19;
        }
        if (str.equals("uniqueIndexName")) {
            return 20;
        }
        if (str.equals("foreignAutoRefresh")) {
            return 21;
        }
        if (str.equals("maxForeignAutoRefreshLevel")) {
            return 22;
        }
        if (str.equals("persisterClass")) {
            return 23;
        }
        if (str.equals("allowGeneratedIdInsert")) {
            return 24;
        }
        if (str.equals("columnDefinition")) {
            return 25;
        }
        if (str.equals("fullColumnDefinition")) {
            return 30;
        }
        if (str.equals("foreignAutoCreate")) {
            return 26;
        }
        if (str.equals("version")) {
            return 27;
        }
        if (str.equals("foreignColumnName")) {
            return 28;
        }
        if (str.equals("readOnly")) {
            return 29;
        }
        throw new IllegalStateException("Could not find support for DatabaseField ".concat(String.valueOf(str)));
    }

    private static DatabaseFieldConfig configFromField(DatabaseType databaseType, String str, Field field) throws SQLException {
        if (configFieldNums == null) {
            return DatabaseFieldConfig.fromField(databaseType, str, field);
        }
        DatabaseField databaseField = (DatabaseField) field.getAnnotation(DatabaseField.class);
        DatabaseFieldConfig databaseFieldConfig = null;
        if (databaseField != null) {
            try {
                databaseFieldConfig = buildConfig(databaseField, str, field);
            } catch (Exception unused) {
            }
        }
        if (databaseFieldConfig == null) {
            return DatabaseFieldConfig.fromField(databaseType, str, field);
        }
        workedC++;
        return databaseFieldConfig;
    }

    private static DatabaseFieldConfig buildConfig(DatabaseField databaseField, String str, Field field) throws Exception {
        Object obj;
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(databaseField);
        if (invocationHandler.getClass() != annotationFactoryClazz || (obj = elementsField.get(invocationHandler)) == null) {
            return null;
        }
        DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig(field.getName());
        Object[] objArr = (Object[]) obj;
        for (int i = 0; i < configFieldNums.length; i++) {
            Object obj2 = valueField.get(objArr[i]);
            if (obj2 != null) {
                assignConfigField(configFieldNums[i], databaseFieldConfig, field, obj2);
            }
        }
        return databaseFieldConfig;
    }

    private static void assignConfigField(int i, DatabaseFieldConfig databaseFieldConfig, Field field, Object obj) {
        switch (i) {
            case 1:
                databaseFieldConfig.setColumnName(valueIfNotBlank((String) obj));
                return;
            case 2:
                databaseFieldConfig.setDataType((DataType) obj);
                return;
            case 3:
                String str = (String) obj;
                if (str != null && !str.equals("__ormlite__ no default value string was specified")) {
                    databaseFieldConfig.setDefaultValue(str);
                    return;
                }
                return;
            case 4:
                databaseFieldConfig.setWidth(((Integer) obj).intValue());
                return;
            case 5:
                databaseFieldConfig.setCanBeNull(((Boolean) obj).booleanValue());
                return;
            case 6:
                databaseFieldConfig.setId(((Boolean) obj).booleanValue());
                return;
            case 7:
                databaseFieldConfig.setGeneratedId(((Boolean) obj).booleanValue());
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                databaseFieldConfig.setGeneratedIdSequence(valueIfNotBlank((String) obj));
                return;
            case 9:
                databaseFieldConfig.setForeign(((Boolean) obj).booleanValue());
                return;
            case 10:
                databaseFieldConfig.setUseGetSet(((Boolean) obj).booleanValue());
                return;
            case 11:
                databaseFieldConfig.setUnknownEnumValue(DatabaseFieldConfig.findMatchingEnumVal(field, (String) obj));
                return;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                databaseFieldConfig.setThrowIfNull(((Boolean) obj).booleanValue());
                return;
            case 13:
                databaseFieldConfig.setPersisted(((Boolean) obj).booleanValue());
                return;
            case 14:
                databaseFieldConfig.setFormat(valueIfNotBlank((String) obj));
                return;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                databaseFieldConfig.setUnique(((Boolean) obj).booleanValue());
                return;
            case 16:
                databaseFieldConfig.setUniqueCombo(((Boolean) obj).booleanValue());
                return;
            case 17:
                databaseFieldConfig.setIndex(((Boolean) obj).booleanValue());
                return;
            case 18:
                databaseFieldConfig.setUniqueIndex(((Boolean) obj).booleanValue());
                return;
            case 19:
                databaseFieldConfig.setIndexName(valueIfNotBlank((String) obj));
                return;
            case 20:
                databaseFieldConfig.setUniqueIndexName(valueIfNotBlank((String) obj));
                return;
            case 21:
                databaseFieldConfig.setForeignAutoRefresh(((Boolean) obj).booleanValue());
                return;
            case 22:
                databaseFieldConfig.setMaxForeignAutoRefreshLevel(((Integer) obj).intValue());
                return;
            case 23:
                databaseFieldConfig.setPersisterClass((Class) obj);
                return;
            case 24:
                databaseFieldConfig.setAllowGeneratedIdInsert(((Boolean) obj).booleanValue());
                return;
            case 25:
                databaseFieldConfig.setColumnDefinition(valueIfNotBlank((String) obj));
                return;
            case 26:
                databaseFieldConfig.setForeignAutoCreate(((Boolean) obj).booleanValue());
                return;
            case 27:
                databaseFieldConfig.setVersion(((Boolean) obj).booleanValue());
                return;
            case 28:
                databaseFieldConfig.setForeignColumnName(valueIfNotBlank((String) obj));
                return;
            case 29:
                databaseFieldConfig.setReadOnly(((Boolean) obj).booleanValue());
                return;
            case 30:
                databaseFieldConfig.setFullColumnDefinition(valueIfNotBlank((String) obj));
                return;
            default:
                throw new IllegalStateException("Could not find support for DatabaseField number ".concat(String.valueOf(i)));
        }
    }

    private static String valueIfNotBlank(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return str;
    }

    static class DatabaseFieldSample {
        @DatabaseField
        String field;

        private DatabaseFieldSample() {
        }
    }
}

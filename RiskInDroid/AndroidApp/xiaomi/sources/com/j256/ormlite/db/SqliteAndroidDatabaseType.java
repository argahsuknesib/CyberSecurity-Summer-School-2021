package com.j256.ormlite.db;

import com.j256.ormlite.android.DatabaseTableConfigUtil;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.field.types.SqlDateStringType;
import com.j256.ormlite.field.types.SqlDateType;
import com.j256.ormlite.field.types.TimeStampStringType;
import com.j256.ormlite.field.types.TimeStampType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

public class SqliteAndroidDatabaseType extends BaseSqliteDatabaseType {
    public String getDatabaseName() {
        return "Android SQLite";
    }

    /* access modifiers changed from: protected */
    public String getDriverClassName() {
        return null;
    }

    public boolean isBatchUseTransaction() {
        return true;
    }

    public boolean isDatabaseUrlThisType(String str, String str2) {
        return true;
    }

    public boolean isNestedSavePointsSupported() {
        return false;
    }

    public void loadDriver() {
    }

    /* access modifiers changed from: protected */
    public void appendDateType(StringBuilder sb, FieldType fieldType, int i) {
        appendStringType(sb, fieldType, i);
    }

    public void appendEscapedEntityName(StringBuilder sb, String str) {
        sb.append('`');
        sb.append(str);
        sb.append('`');
    }

    /* access modifiers changed from: protected */
    public void appendBooleanType(StringBuilder sb, FieldType fieldType, int i) {
        appendShortType(sb, fieldType, i);
    }

    public DataPersister getDataPersister(DataPersister dataPersister, FieldType fieldType) {
        if (dataPersister == null) {
            return super.getDataPersister(dataPersister, fieldType);
        }
        if (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[dataPersister.getSqlType().ordinal()] != 1) {
            return super.getDataPersister(dataPersister, fieldType);
        }
        if (dataPersister instanceof TimeStampType) {
            return TimeStampStringType.getSingleton();
        }
        if (dataPersister instanceof SqlDateType) {
            return SqlDateStringType.getSingleton();
        }
        return DateStringType.getSingleton();
    }

    /* renamed from: com.j256.ormlite.db.SqliteAndroidDatabaseType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];

        static {
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return DatabaseTableConfigUtil.fromClass(connectionSource, cls);
    }
}

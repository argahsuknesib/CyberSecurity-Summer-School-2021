package com.j256.ormlite.db;

import com.j256.ormlite.db.BaseDatabaseType;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BigDecimalStringType;
import java.util.List;

public abstract class BaseSqliteDatabaseType extends BaseDatabaseType {
    private static final FieldConverter booleanConverter = new BaseDatabaseType.BooleanNumberFieldConverter();

    /* access modifiers changed from: protected */
    public boolean generatedIdSqlAtEnd() {
        return false;
    }

    public boolean isCreateIfNotExistsSupported() {
        return true;
    }

    public boolean isCreateTableReturnsZero() {
        return false;
    }

    public boolean isVarcharFieldWidthSupported() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void appendLongType(StringBuilder sb, FieldType fieldType, int i) {
        if (fieldType.getSqlType() != SqlType.LONG || !fieldType.isGeneratedId()) {
            sb.append("BIGINT");
        } else {
            sb.append("INTEGER");
        }
    }

    /* access modifiers changed from: protected */
    public void configureGeneratedId(String str, StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        if (fieldType.getSqlType() == SqlType.INTEGER || fieldType.getSqlType() == SqlType.LONG) {
            sb.append("PRIMARY KEY AUTOINCREMENT ");
            return;
        }
        throw new IllegalArgumentException("Sqlite requires that auto-increment generated-id be integer or long type");
    }

    /* renamed from: com.j256.ormlite.db.BaseSqliteDatabaseType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 1;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 2;
        }
    }

    public FieldConverter getFieldConverter(DataPersister dataPersister, FieldType fieldType) {
        int i = AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[dataPersister.getSqlType().ordinal()];
        if (i == 1) {
            return booleanConverter;
        }
        if (i != 2) {
            return super.getFieldConverter(dataPersister, fieldType);
        }
        return BigDecimalStringType.getSingleton();
    }

    public void appendInsertNoColumns(StringBuilder sb) {
        sb.append("DEFAULT VALUES");
    }
}

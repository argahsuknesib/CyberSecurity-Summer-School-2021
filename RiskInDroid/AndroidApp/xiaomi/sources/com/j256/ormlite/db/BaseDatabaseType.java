package com.j256.ormlite.db;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public abstract class BaseDatabaseType implements DatabaseType {
    protected static String DEFAULT_SEQUENCE_SUFFIX = "_id_seq";
    protected Driver driver;

    private void appendCanBeNull(StringBuilder sb, FieldType fieldType) {
    }

    public void appendCreateTableSuffix(StringBuilder sb) {
    }

    public void appendSelectNextValFromSequence(StringBuilder sb, String str) {
    }

    /* access modifiers changed from: protected */
    public void configureId(StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3) {
    }

    public void dropColumnArg(FieldType fieldType, List<String> list, List<String> list2) {
    }

    public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean generatedIdSqlAtEnd() {
        return true;
    }

    public String getCommentLinePrefix() {
        return "-- ";
    }

    public DataPersister getDataPersister(DataPersister dataPersister, FieldType fieldType) {
        return dataPersister;
    }

    /* access modifiers changed from: protected */
    public abstract String getDriverClassName();

    public FieldConverter getFieldConverter(DataPersister dataPersister, FieldType fieldType) {
        return dataPersister;
    }

    public String getPingStatement() {
        return "SELECT 1";
    }

    public boolean isAllowGeneratedIdInsertSupported() {
        return true;
    }

    public boolean isBatchUseTransaction() {
        return false;
    }

    public boolean isCreateIfNotExistsSupported() {
        return false;
    }

    public boolean isCreateTableReturnsNegative() {
        return false;
    }

    public boolean isCreateTableReturnsZero() {
        return true;
    }

    public boolean isEntityNamesMustBeUpCase() {
        return false;
    }

    public boolean isIdSequenceNeeded() {
        return false;
    }

    public boolean isLimitAfterSelect() {
        return false;
    }

    public boolean isLimitSqlSupported() {
        return true;
    }

    public boolean isNestedSavePointsSupported() {
        return true;
    }

    public boolean isOffsetLimitArgument() {
        return false;
    }

    public boolean isOffsetSqlSupported() {
        return true;
    }

    public boolean isSelectSequenceBeforeInsert() {
        return false;
    }

    public boolean isTruncateSupported() {
        return false;
    }

    public boolean isVarcharFieldWidthSupported() {
        return true;
    }

    public void loadDriver() throws SQLException {
        String driverClassName = getDriverClassName();
        if (driverClassName != null) {
            try {
                Class.forName(driverClassName);
            } catch (ClassNotFoundException e) {
                throw SqlExceptionUtil.create("Driver class was not found for " + getDatabaseName() + " database.  Missing jar with class " + driverClassName + ".", e);
            }
        }
    }

    public void setDriver(Driver driver2) {
        this.driver = driver2;
    }

    public void appendColumnArg(String str, StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3, List<String> list4) throws SQLException {
        appendEscapedEntityName(sb, fieldType.getColumnName());
        sb.append(' ');
        DataPersister dataPersister = fieldType.getDataPersister();
        int width = fieldType.getWidth();
        if (width == 0) {
            width = dataPersister.getDefaultWidth();
        }
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[dataPersister.getSqlType().ordinal()]) {
            case 1:
                appendStringType(sb, fieldType, width);
                break;
            case 2:
                appendLongStringType(sb, fieldType, width);
                break;
            case 3:
                appendBooleanType(sb, fieldType, width);
                break;
            case 4:
                appendDateType(sb, fieldType, width);
                break;
            case 5:
                appendCharType(sb, fieldType, width);
                break;
            case 6:
                appendByteType(sb, fieldType, width);
                break;
            case 7:
                appendByteArrayType(sb, fieldType, width);
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                appendShortType(sb, fieldType, width);
                break;
            case 9:
                appendIntegerType(sb, fieldType, width);
                break;
            case 10:
                appendLongType(sb, fieldType, width);
                break;
            case 11:
                appendFloatType(sb, fieldType, width);
                break;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                appendDoubleType(sb, fieldType, width);
                break;
            case 13:
                appendSerializableType(sb, fieldType, width);
                break;
            case 14:
                appendBigDecimalNumericType(sb, fieldType, width);
                break;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                appendUuidNativeType(sb, fieldType, width);
                break;
            case 16:
                String sqlOtherType = dataPersister.getSqlOtherType();
                if (sqlOtherType != null) {
                    sb.append(sqlOtherType);
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown SQL-type " + dataPersister.getSqlType());
        }
        sb.append(' ');
        if (fieldType.isGeneratedIdSequence() && !fieldType.isSelfGeneratedId()) {
            configureGeneratedIdSequence(sb, fieldType, list2, list, list4);
        } else if (fieldType.isGeneratedId() && !fieldType.isSelfGeneratedId()) {
            configureGeneratedId(str, sb, fieldType, list2, list3, list, list4);
        } else if (fieldType.isId()) {
            configureId(sb, fieldType, list2, list, list4);
        }
        if (!fieldType.isGeneratedId()) {
            Object defaultValue = fieldType.getDefaultValue();
            if (defaultValue != null) {
                sb.append("DEFAULT ");
                appendDefaultValue(sb, fieldType, defaultValue);
                sb.append(' ');
            }
            if (fieldType.isCanBeNull()) {
                appendCanBeNull(sb, fieldType);
            } else {
                sb.append("NOT NULL ");
            }
            if (fieldType.isUnique()) {
                addSingleUnique(sb, fieldType, list, list3);
            }
        }
    }

    /* renamed from: com.j256.ormlite.db.BaseDatabaseType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.STRING.ordinal()] = 1;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 3;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 4;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 5;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 6;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 7;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 8;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 9;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 10;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 11;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 12;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 13;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 14;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UUID.ordinal()] = 15;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.OTHER.ordinal()] = 16;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 17;
        }
    }

    /* access modifiers changed from: protected */
    public void appendStringType(StringBuilder sb, FieldType fieldType, int i) {
        if (isVarcharFieldWidthSupported()) {
            sb.append("VARCHAR(");
            sb.append(i);
            sb.append(')');
            return;
        }
        sb.append("VARCHAR");
    }

    /* access modifiers changed from: protected */
    public void appendUuidNativeType(StringBuilder sb, FieldType fieldType, int i) {
        throw new UnsupportedOperationException("UUID is not supported by this database type");
    }

    /* access modifiers changed from: protected */
    public void appendLongStringType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("TEXT");
    }

    /* access modifiers changed from: protected */
    public void appendDateType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("TIMESTAMP");
    }

    /* access modifiers changed from: protected */
    public void appendBooleanType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("BOOLEAN");
    }

    /* access modifiers changed from: protected */
    public void appendCharType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("CHAR");
    }

    /* access modifiers changed from: protected */
    public void appendByteType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("TINYINT");
    }

    /* access modifiers changed from: protected */
    public void appendShortType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("SMALLINT");
    }

    private void appendIntegerType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("INTEGER");
    }

    /* access modifiers changed from: protected */
    public void appendLongType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("BIGINT");
    }

    private void appendFloatType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("FLOAT");
    }

    private void appendDoubleType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("DOUBLE PRECISION");
    }

    /* access modifiers changed from: protected */
    public void appendByteArrayType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("BLOB");
    }

    /* access modifiers changed from: protected */
    public void appendSerializableType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("BLOB");
    }

    /* access modifiers changed from: protected */
    public void appendBigDecimalNumericType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("NUMERIC");
    }

    private void appendDefaultValue(StringBuilder sb, FieldType fieldType, Object obj) {
        if (fieldType.isEscapedDefaultValue()) {
            appendEscapedWord(sb, obj.toString());
        } else {
            sb.append(obj);
        }
    }

    /* access modifiers changed from: protected */
    public void configureGeneratedIdSequence(StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3) throws SQLException {
        throw new SQLException("GeneratedIdSequence is not supported by database " + getDatabaseName() + " for field " + fieldType);
    }

    /* access modifiers changed from: protected */
    public void configureGeneratedId(String str, StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        throw new IllegalStateException("GeneratedId is not supported by database " + getDatabaseName() + " for field " + fieldType);
    }

    public void addPrimaryKeySql(FieldType[] fieldTypeArr, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        StringBuilder sb = null;
        for (FieldType fieldType : fieldTypeArr) {
            if ((!fieldType.isGeneratedId() || generatedIdSqlAtEnd() || fieldType.isSelfGeneratedId()) && fieldType.isId()) {
                if (sb == null) {
                    sb = new StringBuilder(48);
                    sb.append("PRIMARY KEY (");
                } else {
                    sb.append(',');
                }
                appendEscapedEntityName(sb, fieldType.getColumnName());
            }
        }
        if (sb != null) {
            sb.append(") ");
            list.add(sb.toString());
        }
    }

    public void addUniqueComboSql(FieldType[] fieldTypeArr, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        StringBuilder sb = null;
        for (FieldType fieldType : fieldTypeArr) {
            if (fieldType.isUniqueCombo()) {
                if (sb == null) {
                    sb = new StringBuilder(48);
                    sb.append("UNIQUE (");
                } else {
                    sb.append(',');
                }
                appendEscapedEntityName(sb, fieldType.getColumnName());
            }
        }
        if (sb != null) {
            sb.append(") ");
            list.add(sb.toString());
        }
    }

    public void appendEscapedWord(StringBuilder sb, String str) {
        sb.append('\'');
        sb.append(str);
        sb.append('\'');
    }

    public void appendEscapedEntityName(StringBuilder sb, String str) {
        sb.append('`');
        int indexOf = str.indexOf(46);
        if (indexOf > 0) {
            sb.append(str.substring(0, indexOf));
            sb.append("`.`");
            sb.append(str.substring(indexOf + 1));
        } else {
            sb.append(str);
        }
        sb.append('`');
    }

    public String generateIdSequenceName(String str, FieldType fieldType) {
        String str2 = str + DEFAULT_SEQUENCE_SUFFIX;
        return isEntityNamesMustBeUpCase() ? upCaseEntityName(str2) : str2;
    }

    public void appendLimitValue(StringBuilder sb, long j, Long l) {
        sb.append("LIMIT ");
        sb.append(j);
        sb.append(' ');
    }

    public void appendOffsetValue(StringBuilder sb, long j) {
        sb.append("OFFSET ");
        sb.append(j);
        sb.append(' ');
    }

    public String upCaseEntityName(String str) {
        return upCaseString(str, true);
    }

    public String upCaseString(String str, boolean z) {
        if (z) {
            return str.toUpperCase(Locale.ENGLISH);
        }
        return str.toUpperCase();
    }

    public String downCaseString(String str, boolean z) {
        if (z) {
            return str.toLowerCase(Locale.ENGLISH);
        }
        return str.toLowerCase();
    }

    public boolean isCreateIndexIfNotExistsSupported() {
        return isCreateIfNotExistsSupported();
    }

    public void appendInsertNoColumns(StringBuilder sb) {
        sb.append("() VALUES ()");
    }

    private void addSingleUnique(StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" UNIQUE (");
        appendEscapedEntityName(sb2, fieldType.getColumnName());
        sb2.append(')');
        list.add(sb2.toString());
    }

    public static class BooleanNumberFieldConverter extends BaseFieldConverter {
        protected BooleanNumberFieldConverter() {
        }

        public SqlType getSqlType() {
            return SqlType.BOOLEAN;
        }

        public Object parseDefaultString(FieldType fieldType, String str) {
            byte b;
            if (Boolean.parseBoolean(str)) {
                b = 1;
            } else {
                b = 0;
            }
            return Byte.valueOf(b);
        }

        public Object javaToSqlArg(FieldType fieldType, Object obj) {
            return Byte.valueOf(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
        }

        public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
            return Byte.valueOf(databaseResults.getByte(i));
        }

        public Object sqlArgToJava(FieldType fieldType, Object obj, int i) {
            return ((Byte) obj).byteValue() == 1 ? Boolean.TRUE : Boolean.FALSE;
        }

        public Object resultStringToJava(FieldType fieldType, String str, int i) {
            return sqlArgToJava(fieldType, Byte.valueOf(Byte.parseByte(str)), i);
        }
    }
}

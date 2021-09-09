package com.j256.ormlite.field;

import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;

public class DatabaseFieldConfigLoader {
    private static final DataPersister DEFAULT_DATA_PERSISTER = DatabaseFieldConfig.DEFAULT_DATA_TYPE.getDataPersister();

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053 A[RETURN] */
    public static DatabaseFieldConfig fromReader(BufferedReader bufferedReader) throws SQLException {
        DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
        boolean z = false;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.equals("# --field-end--")) {
                    if (!z) {
                        return databaseFieldConfig;
                    }
                    return null;
                } else if (readLine.length() != 0 && !readLine.startsWith("#") && !readLine.equals("# --field-start--")) {
                    String[] split = readLine.split("=", -2);
                    if (split.length == 2) {
                        readField(databaseFieldConfig, split[0], split[1]);
                        z = true;
                    } else {
                        throw new SQLException("DatabaseFieldConfig reading from stream cannot parse line: ".concat(String.valueOf(readLine)));
                    }
                }
            } catch (IOException e) {
                throw SqlExceptionUtil.create("Could not read DatabaseFieldConfig from stream", e);
            }
        }
        if (!z) {
        }
    }

    public static void write(BufferedWriter bufferedWriter, DatabaseFieldConfig databaseFieldConfig, String str) throws SQLException {
        try {
            writeConfig(bufferedWriter, databaseFieldConfig, str);
        } catch (IOException e) {
            throw SqlExceptionUtil.create("Could not write config to writer", e);
        }
    }

    public static void writeConfig(BufferedWriter bufferedWriter, DatabaseFieldConfig databaseFieldConfig, String str) throws IOException {
        bufferedWriter.append((CharSequence) "# --field-start--");
        bufferedWriter.newLine();
        if (databaseFieldConfig.getFieldName() != null) {
            bufferedWriter.append((CharSequence) "fieldName").append('=').append((CharSequence) databaseFieldConfig.getFieldName());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getColumnName() != null) {
            bufferedWriter.append((CharSequence) "columnName").append('=').append((CharSequence) databaseFieldConfig.getColumnName());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getDataPersister() != DEFAULT_DATA_PERSISTER) {
            DataType[] values = DataType.values();
            int length = values.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                DataType dataType = values[i];
                if (dataType.getDataPersister() == databaseFieldConfig.getDataPersister()) {
                    bufferedWriter.append((CharSequence) "dataPersister").append('=').append((CharSequence) dataType.name());
                    bufferedWriter.newLine();
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                throw new IllegalArgumentException("Unknown data persister field: " + databaseFieldConfig.getDataPersister());
            }
        }
        if (databaseFieldConfig.getDefaultValue() != null) {
            bufferedWriter.append((CharSequence) "defaultValue").append('=').append((CharSequence) databaseFieldConfig.getDefaultValue());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getWidth() != 0) {
            bufferedWriter.append((CharSequence) "width").append('=').append((CharSequence) Integer.toString(databaseFieldConfig.getWidth()));
            bufferedWriter.newLine();
        }
        if (!databaseFieldConfig.isCanBeNull()) {
            bufferedWriter.append((CharSequence) "canBeNull").append('=').append((CharSequence) Boolean.toString(databaseFieldConfig.isCanBeNull()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isId()) {
            bufferedWriter.append((CharSequence) "id").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isGeneratedId()) {
            bufferedWriter.append((CharSequence) "generatedId").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getGeneratedIdSequence() != null) {
            bufferedWriter.append((CharSequence) "generatedIdSequence").append('=').append((CharSequence) databaseFieldConfig.getGeneratedIdSequence());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeign()) {
            bufferedWriter.append((CharSequence) "foreign").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isUseGetSet()) {
            bufferedWriter.append((CharSequence) "useGetSet").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getUnknownEnumValue() != null) {
            bufferedWriter.append((CharSequence) "unknownEnumValue").append('=').append((CharSequence) databaseFieldConfig.getUnknownEnumValue().getDeclaringClass().getName()).append('#').append((CharSequence) databaseFieldConfig.getUnknownEnumValue().name());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isThrowIfNull()) {
            bufferedWriter.append((CharSequence) "throwIfNull").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getFormat() != null) {
            bufferedWriter.append((CharSequence) "format").append('=').append((CharSequence) databaseFieldConfig.getFormat());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isUnique()) {
            bufferedWriter.append((CharSequence) "unique").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isUniqueCombo()) {
            bufferedWriter.append((CharSequence) "uniqueCombo").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        String indexName = databaseFieldConfig.getIndexName(str);
        if (indexName != null) {
            bufferedWriter.append((CharSequence) "indexName").append('=').append((CharSequence) indexName);
            bufferedWriter.newLine();
        }
        String uniqueIndexName = databaseFieldConfig.getUniqueIndexName(str);
        if (uniqueIndexName != null) {
            bufferedWriter.append((CharSequence) "uniqueIndexName").append('=').append((CharSequence) uniqueIndexName);
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeignAutoRefresh()) {
            bufferedWriter.append((CharSequence) "foreignAutoRefresh").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getMaxForeignAutoRefreshLevel() != -1) {
            bufferedWriter.append((CharSequence) "maxForeignAutoRefreshLevel").append('=').append((CharSequence) Integer.toString(databaseFieldConfig.getMaxForeignAutoRefreshLevel()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getPersisterClass() != DatabaseFieldConfig.DEFAULT_PERSISTER_CLASS) {
            bufferedWriter.append((CharSequence) "persisterClass").append('=').append((CharSequence) databaseFieldConfig.getPersisterClass().getName());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isAllowGeneratedIdInsert()) {
            bufferedWriter.append((CharSequence) "allowGeneratedIdInsert").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getColumnDefinition() != null) {
            bufferedWriter.append((CharSequence) "columnDefinition").append('=').append((CharSequence) databaseFieldConfig.getColumnDefinition());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getFullColumnDefinition() != null) {
            bufferedWriter.append((CharSequence) "fullColumnDefinition").append('=').append((CharSequence) databaseFieldConfig.getFullColumnDefinition());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeignAutoCreate()) {
            bufferedWriter.append((CharSequence) "foreignAutoCreate").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isVersion()) {
            bufferedWriter.append((CharSequence) "version").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        String foreignColumnName = databaseFieldConfig.getForeignColumnName();
        if (foreignColumnName != null) {
            bufferedWriter.append((CharSequence) "foreignColumnName").append('=').append((CharSequence) foreignColumnName);
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isReadOnly()) {
            bufferedWriter.append((CharSequence) "readOnly").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeignCollection()) {
            bufferedWriter.append((CharSequence) "foreignCollection").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeignCollectionEager()) {
            bufferedWriter.append((CharSequence) "foreignCollectionEager").append('=').append((CharSequence) "true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getForeignCollectionMaxEagerLevel() != 1) {
            bufferedWriter.append((CharSequence) "foreignCollectionMaxEagerLevel").append('=').append((CharSequence) Integer.toString(databaseFieldConfig.getForeignCollectionMaxEagerLevel()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getForeignCollectionColumnName() != null) {
            bufferedWriter.append((CharSequence) "foreignCollectionColumnName").append('=').append((CharSequence) databaseFieldConfig.getForeignCollectionColumnName());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getForeignCollectionOrderColumnName() != null) {
            bufferedWriter.append((CharSequence) "foreignCollectionOrderColumnName").append('=').append((CharSequence) databaseFieldConfig.getForeignCollectionOrderColumnName());
            bufferedWriter.newLine();
        }
        if (!databaseFieldConfig.isForeignCollectionOrderAscending()) {
            bufferedWriter.append((CharSequence) "foreignCollectionOrderAscending").append('=').append((CharSequence) Boolean.toString(databaseFieldConfig.isForeignCollectionOrderAscending()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getForeignCollectionForeignFieldName() != null) {
            bufferedWriter.append((CharSequence) "foreignCollectionForeignFieldName").append('=').append((CharSequence) databaseFieldConfig.getForeignCollectionForeignFieldName());
            bufferedWriter.newLine();
        }
        bufferedWriter.append((CharSequence) "# --field-end--");
        bufferedWriter.newLine();
    }

    private static void readField(DatabaseFieldConfig databaseFieldConfig, String str, String str2) {
        if (str.equals("fieldName")) {
            databaseFieldConfig.setFieldName(str2);
        } else if (str.equals("columnName")) {
            databaseFieldConfig.setColumnName(str2);
        } else if (str.equals("dataPersister")) {
            databaseFieldConfig.setDataPersister(DataType.valueOf(str2).getDataPersister());
        } else if (str.equals("defaultValue")) {
            databaseFieldConfig.setDefaultValue(str2);
        } else if (str.equals("width")) {
            databaseFieldConfig.setWidth(Integer.parseInt(str2));
        } else if (str.equals("canBeNull")) {
            databaseFieldConfig.setCanBeNull(Boolean.parseBoolean(str2));
        } else if (str.equals("id")) {
            databaseFieldConfig.setId(Boolean.parseBoolean(str2));
        } else if (str.equals("generatedId")) {
            databaseFieldConfig.setGeneratedId(Boolean.parseBoolean(str2));
        } else if (str.equals("generatedIdSequence")) {
            databaseFieldConfig.setGeneratedIdSequence(str2);
        } else if (str.equals("foreign")) {
            databaseFieldConfig.setForeign(Boolean.parseBoolean(str2));
        } else if (str.equals("useGetSet")) {
            databaseFieldConfig.setUseGetSet(Boolean.parseBoolean(str2));
        } else if (str.equals("unknownEnumValue")) {
            String[] split = str2.split("#", -2);
            if (split.length == 2) {
                try {
                    Object[] enumConstants = Class.forName(split[0]).getEnumConstants();
                    if (enumConstants != null) {
                        boolean z = false;
                        for (Enum enumR : (Enum[]) enumConstants) {
                            if (enumR.name().equals(split[1])) {
                                databaseFieldConfig.setUnknownEnumValue(enumR);
                                z = true;
                            }
                        }
                        if (!z) {
                            throw new IllegalArgumentException("Invalid enum value name for unknownEnumvalue: ".concat(String.valueOf(str2)));
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Invalid class is not an Enum for unknownEnumValue: ".concat(String.valueOf(str2)));
                } catch (ClassNotFoundException unused) {
                    throw new IllegalArgumentException("Unknown class specified for unknownEnumValue: ".concat(String.valueOf(str2)));
                }
            } else {
                throw new IllegalArgumentException("Invalid value for unknownEnumValue which should be in class#name format: ".concat(String.valueOf(str2)));
            }
        } else if (str.equals("throwIfNull")) {
            databaseFieldConfig.setThrowIfNull(Boolean.parseBoolean(str2));
        } else if (str.equals("format")) {
            databaseFieldConfig.setFormat(str2);
        } else if (str.equals("unique")) {
            databaseFieldConfig.setUnique(Boolean.parseBoolean(str2));
        } else if (str.equals("uniqueCombo")) {
            databaseFieldConfig.setUniqueCombo(Boolean.parseBoolean(str2));
        } else if (str.equals("index")) {
            databaseFieldConfig.setIndex(Boolean.parseBoolean(str2));
        } else if (str.equals("indexName")) {
            databaseFieldConfig.setIndex(true);
            databaseFieldConfig.setIndexName(str2);
        } else if (str.equals("uniqueIndex")) {
            databaseFieldConfig.setUniqueIndex(Boolean.parseBoolean(str2));
        } else if (str.equals("uniqueIndexName")) {
            databaseFieldConfig.setUniqueIndex(true);
            databaseFieldConfig.setUniqueIndexName(str2);
        } else if (str.equals("foreignAutoRefresh")) {
            databaseFieldConfig.setForeignAutoRefresh(Boolean.parseBoolean(str2));
        } else if (str.equals("maxForeignAutoRefreshLevel")) {
            databaseFieldConfig.setMaxForeignAutoRefreshLevel(Integer.parseInt(str2));
        } else if (str.equals("persisterClass")) {
            try {
                databaseFieldConfig.setPersisterClass(Class.forName(str2));
            } catch (ClassNotFoundException unused2) {
                throw new IllegalArgumentException("Could not find persisterClass: ".concat(String.valueOf(str2)));
            }
        } else if (str.equals("allowGeneratedIdInsert")) {
            databaseFieldConfig.setAllowGeneratedIdInsert(Boolean.parseBoolean(str2));
        } else if (str.equals("columnDefinition")) {
            databaseFieldConfig.setColumnDefinition(str2);
        } else if (str.equals("fullColumnDefinition")) {
            databaseFieldConfig.setFullColumnDefinition(str2);
        } else if (str.equals("foreignAutoCreate")) {
            databaseFieldConfig.setForeignAutoCreate(Boolean.parseBoolean(str2));
        } else if (str.equals("version")) {
            databaseFieldConfig.setVersion(Boolean.parseBoolean(str2));
        } else if (str.equals("foreignColumnName")) {
            databaseFieldConfig.setForeignColumnName(str2);
        } else if (str.equals("readOnly")) {
            databaseFieldConfig.setReadOnly(Boolean.parseBoolean(str2));
        } else if (str.equals("foreignCollection")) {
            databaseFieldConfig.setForeignCollection(Boolean.parseBoolean(str2));
        } else if (str.equals("foreignCollectionEager")) {
            databaseFieldConfig.setForeignCollectionEager(Boolean.parseBoolean(str2));
        } else if (str.equals("maxEagerForeignCollectionLevel")) {
            databaseFieldConfig.setForeignCollectionMaxEagerLevel(Integer.parseInt(str2));
        } else if (str.equals("foreignCollectionMaxEagerLevel")) {
            databaseFieldConfig.setForeignCollectionMaxEagerLevel(Integer.parseInt(str2));
        } else if (str.equals("foreignCollectionColumnName")) {
            databaseFieldConfig.setForeignCollectionColumnName(str2);
        } else if (str.equals("foreignCollectionOrderColumn")) {
            databaseFieldConfig.setForeignCollectionOrderColumnName(str2);
        } else if (str.equals("foreignCollectionOrderColumnName")) {
            databaseFieldConfig.setForeignCollectionOrderColumnName(str2);
        } else if (str.equals("foreignCollectionOrderAscending")) {
            databaseFieldConfig.setForeignCollectionOrderAscending(Boolean.parseBoolean(str2));
        } else if (str.equals("foreignCollectionForeignColumnName")) {
            databaseFieldConfig.setForeignCollectionForeignFieldName(str2);
        } else if (str.equals("foreignCollectionForeignFieldName")) {
            databaseFieldConfig.setForeignCollectionForeignFieldName(str2);
        }
    }
}

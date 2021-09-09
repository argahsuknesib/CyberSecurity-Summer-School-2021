package com.j256.ormlite.table;

import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTableConfigLoader {
    public static List<DatabaseTableConfig<?>> loadDatabaseConfigFromReader(BufferedReader bufferedReader) throws SQLException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            DatabaseTableConfig fromReader = fromReader(bufferedReader);
            if (fromReader == null) {
                return arrayList;
            }
            arrayList.add(fromReader);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f A[RETURN] */
    public static <T> DatabaseTableConfig<T> fromReader(BufferedReader bufferedReader) throws SQLException {
        DatabaseTableConfig<T> databaseTableConfig = new DatabaseTableConfig<>();
        boolean z = false;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.equals("# --table-end--")) {
                    if (!z) {
                        return databaseTableConfig;
                    }
                    return null;
                } else if (readLine.equals("# --table-fields-start--")) {
                    readFields(bufferedReader, databaseTableConfig);
                } else if (readLine.length() != 0 && !readLine.startsWith("#") && !readLine.equals("# --table-start--")) {
                    String[] split = readLine.split("=", -2);
                    if (split.length == 2) {
                        readTableField(databaseTableConfig, split[0], split[1]);
                        z = true;
                    } else {
                        throw new SQLException("DatabaseTableConfig reading from stream cannot parse line: ".concat(String.valueOf(readLine)));
                    }
                }
            } catch (IOException e) {
                throw SqlExceptionUtil.create("Could not read DatabaseTableConfig from stream", e);
            }
        }
        if (!z) {
        }
    }

    public static <T> void write(BufferedWriter bufferedWriter, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        try {
            writeConfig(bufferedWriter, databaseTableConfig);
        } catch (IOException e) {
            throw SqlExceptionUtil.create("Could not write config to writer", e);
        }
    }

    private static <T> void writeConfig(BufferedWriter bufferedWriter, DatabaseTableConfig<T> databaseTableConfig) throws IOException, SQLException {
        bufferedWriter.append((CharSequence) "# --table-start--");
        bufferedWriter.newLine();
        if (databaseTableConfig.getDataClass() != null) {
            bufferedWriter.append((CharSequence) "dataClass").append('=').append((CharSequence) databaseTableConfig.getDataClass().getName());
            bufferedWriter.newLine();
        }
        if (databaseTableConfig.getTableName() != null) {
            bufferedWriter.append((CharSequence) "tableName").append('=').append((CharSequence) databaseTableConfig.getTableName());
            bufferedWriter.newLine();
        }
        bufferedWriter.append((CharSequence) "# --table-fields-start--");
        bufferedWriter.newLine();
        if (databaseTableConfig.getFieldConfigs() != null) {
            for (DatabaseFieldConfig write : databaseTableConfig.getFieldConfigs()) {
                DatabaseFieldConfigLoader.write(bufferedWriter, write, databaseTableConfig.getTableName());
            }
        }
        bufferedWriter.append((CharSequence) "# --table-fields-end--");
        bufferedWriter.newLine();
        bufferedWriter.append((CharSequence) "# --table-end--");
        bufferedWriter.newLine();
    }

    private static <T> void readTableField(DatabaseTableConfig<T> databaseTableConfig, String str, String str2) {
        if (str.equals("dataClass")) {
            try {
                databaseTableConfig.setDataClass(Class.forName(str2));
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("Unknown class specified for dataClass: ".concat(String.valueOf(str2)));
            }
        } else if (str.equals("tableName")) {
            databaseTableConfig.setTableName(str2);
        }
    }

    private static <T> void readFields(BufferedReader bufferedReader, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        DatabaseFieldConfig fromReader;
        ArrayList arrayList = new ArrayList();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.equals("# --table-fields-end--") || (fromReader = DatabaseFieldConfigLoader.fromReader(bufferedReader)) == null) {
                    databaseTableConfig.setFieldConfigs(arrayList);
                } else {
                    arrayList.add(fromReader);
                }
            } catch (IOException e) {
                throw SqlExceptionUtil.create("Could not read next field from config file", e);
            }
        }
        databaseTableConfig.setFieldConfigs(arrayList);
    }
}

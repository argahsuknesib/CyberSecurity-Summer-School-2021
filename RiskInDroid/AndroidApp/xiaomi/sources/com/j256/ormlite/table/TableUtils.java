package com.j256.ormlite.table;

import android.support.v4.app.NotificationCompat;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class TableUtils {
    private static Logger logger = LoggerFactory.getLogger(TableUtils.class);
    private static final FieldType[] noFieldTypes = new FieldType[0];

    private TableUtils() {
    }

    public static <T> int createTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return doCreateTable(DaoManager.createDao(connectionSource, cls), false);
    }

    public static int createTable(Dao<?, ?> dao) throws SQLException {
        return doCreateTable(dao, false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return doCreateTable(DaoManager.createDao(connectionSource, cls), true);
    }

    public static <T> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return doCreateTable(DaoManager.createDao(connectionSource, databaseTableConfig), false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return doCreateTable(DaoManager.createDao(connectionSource, databaseTableConfig), true);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        if (createDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), false);
        }
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), false);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), false);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource.getDatabaseType(), (BaseDaoImpl) null, databaseTableConfig), false);
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, Class<T> cls, boolean z) throws SQLException {
        return dropTable(DaoManager.createDao(connectionSource, cls), z);
    }

    public static <T, ID> int dropTable(Dao<T, ID> dao, boolean z) throws SQLException {
        ConnectionSource connectionSource = dao.getConnectionSource();
        Class<T> dataClass = dao.getDataClass();
        DatabaseType databaseType = connectionSource.getDatabaseType();
        if (dao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) dao).getTableInfo(), z);
        }
        return doDropTable(databaseType, connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, dataClass), z);
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doDropTable(databaseType, connectionSource, new TableInfo(databaseType, (BaseDaoImpl) null, databaseTableConfig), z);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        String extractTableName = DatabaseTableConfig.extractTableName(databaseType, cls);
        if (databaseType.isEntityNamesMustBeUpCase()) {
            extractTableName = databaseType.upCaseEntityName(extractTableName);
        }
        return clearTable(connectionSource, extractTableName);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return clearTable(connectionSource, databaseTableConfig.getTableName());
    }

    private static <T> int clearTable(ConnectionSource connectionSource, String str) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        StringBuilder sb = new StringBuilder(48);
        if (databaseType.isTruncateSupported()) {
            sb.append("TRUNCATE TABLE ");
        } else {
            sb.append("DELETE FROM ");
        }
        databaseType.appendEscapedEntityName(sb, str);
        String sb2 = sb.toString();
        logger.info("clearing table '{}' with '{}", str, sb2);
        CompiledStatement compiledStatement = null;
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(str);
        try {
            compiledStatement = readWriteConnection.compileStatement(sb2, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1, false);
            return compiledStatement.runExecute();
        } finally {
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    private static <T, ID> int doDropTable(DatabaseType databaseType, ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        logger.info("dropping table '{}'", tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        addDropIndexStatements(databaseType, tableInfo, arrayList);
        addDropTableStatements(databaseType, tableInfo, arrayList);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(tableInfo.getTableName());
        try {
            return doStatements(readWriteConnection, "drop", arrayList, z, databaseType.isCreateTableReturnsNegative(), false);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    private static <T, ID> void addDropIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        HashSet<String> hashSet = new HashSet<>();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            String indexName = fieldType.getIndexName();
            if (indexName != null) {
                hashSet.add(indexName);
            }
            String uniqueIndexName = fieldType.getUniqueIndexName();
            if (uniqueIndexName != null) {
                hashSet.add(uniqueIndexName);
            }
        }
        StringBuilder sb = new StringBuilder(48);
        for (String str : hashSet) {
            logger.info("dropping index '{}' for table '{}", str, tableInfo.getTableName());
            sb.append("DROP INDEX ");
            databaseType.appendEscapedEntityName(sb, str);
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private static <T, ID> void addCreateIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, boolean z, boolean z2) {
        String str;
        HashMap hashMap = new HashMap();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            if (z2) {
                str = fieldType.getUniqueIndexName();
            } else {
                str = fieldType.getIndexName();
            }
            if (str != null) {
                List list2 = (List) hashMap.get(str);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(str, list2);
                }
                list2.add(fieldType.getColumnName());
            }
        }
        StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        for (Map.Entry entry : hashMap.entrySet()) {
            logger.info("creating index '{}' for table '{}", entry.getKey(), tableInfo.getTableName());
            sb.append("CREATE ");
            if (z2) {
                sb.append("UNIQUE ");
            }
            sb.append("INDEX ");
            if (z && databaseType.isCreateIndexIfNotExistsSupported()) {
                sb.append("IF NOT EXISTS ");
            }
            databaseType.appendEscapedEntityName(sb, (String) entry.getKey());
            sb.append(" ON ");
            databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
            sb.append(" ( ");
            boolean z3 = true;
            for (String str2 : (List) entry.getValue()) {
                if (z3) {
                    z3 = false;
                } else {
                    sb.append(", ");
                }
                databaseType.appendEscapedEntityName(sb, str2);
            }
            sb.append(" )");
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private static <T, ID> void addDropTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (FieldType dropColumnArg : tableInfo.getFieldTypes()) {
            databaseType.dropColumnArg(dropColumnArg, arrayList, arrayList2);
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("DROP TABLE ");
        databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(' ');
        list.addAll(arrayList);
        list.add(sb.toString());
        list.addAll(arrayList2);
    }

    private static <T, ID> int doCreateTable(Dao<T, ID> dao, boolean z) throws SQLException {
        if (dao instanceof BaseDaoImpl) {
            return doCreateTable(dao.getConnectionSource(), ((BaseDaoImpl) dao).getTableInfo(), z);
        }
        return doCreateTable(dao.getConnectionSource(), new TableInfo(dao.getConnectionSource(), (BaseDaoImpl) null, dao.getDataClass()), z);
    }

    private static <T, ID> int doCreateTable(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        logger.info("creating table '{}'", tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        addCreateTableStatements(databaseType, tableInfo, arrayList, arrayList2, z);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(tableInfo.getTableName());
        try {
            return doStatements(readWriteConnection, "create", arrayList, false, databaseType.isCreateTableReturnsNegative(), databaseType.isCreateTableReturnsZero()) + doCreateTestQueries(readWriteConnection, databaseType, arrayList2);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[ADDED_TO_REGION] */
    private static int doStatements(DatabaseConnection databaseConnection, String str, Collection<String> collection, boolean z, boolean z2, boolean z3) throws SQLException {
        int i;
        int i2 = 0;
        for (String next : collection) {
            CompiledStatement compiledStatement = null;
            try {
                compiledStatement = databaseConnection.compileStatement(next, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1, false);
                i = compiledStatement.runExecute();
                try {
                    logger.info("executed {} table statement changed {} rows: {}", str, Integer.valueOf(i), next);
                } catch (SQLException e) {
                    e = e;
                }
            } catch (SQLException e2) {
                e = e2;
                i = 0;
                if (z) {
                    try {
                        logger.info("ignoring {} error '{}' for statement: {}", str, e, next);
                        IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                        if (i >= 0) {
                        }
                        i2++;
                    } catch (Throwable th) {
                        IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                        throw th;
                    }
                } else {
                    throw SqlExceptionUtil.create("SQL statement failed: ".concat(String.valueOf(next)), e);
                }
            }
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            if (i >= 0) {
                if (!z2) {
                    throw new SQLException("SQL statement " + next + " updated " + i + " rows, we were expecting >= 0");
                }
            } else if (i > 0 && z3) {
                throw new SQLException("SQL statement updated " + i + " rows, we were expecting == 0: " + next);
            }
            i2++;
        }
        return i2;
    }

    private static int doCreateTestQueries(DatabaseConnection databaseConnection, DatabaseType databaseType, List<String> list) throws SQLException {
        int i = 0;
        for (String next : list) {
            CompiledStatement compiledStatement = null;
            try {
                CompiledStatement compileStatement = databaseConnection.compileStatement(next, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
                try {
                    DatabaseResults runQuery = compileStatement.runQuery(null);
                    int i2 = 0;
                    for (boolean first = runQuery.first(); first; first = runQuery.next()) {
                        i2++;
                    }
                    logger.info("executing create table after-query got {} results: {}", Integer.valueOf(i2), next);
                    IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
                    i++;
                } catch (SQLException e) {
                    e = e;
                    compiledStatement = compileStatement;
                    try {
                        throw SqlExceptionUtil.create("executing create table after-query failed: ".concat(String.valueOf(next)), e);
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    compiledStatement = compileStatement;
                    IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                    throw th;
                }
            } catch (SQLException e2) {
                e = e2;
                throw SqlExceptionUtil.create("executing create table after-query failed: ".concat(String.valueOf(next)), e);
            }
        }
        return i;
    }

    private static <T, ID> List<String> addCreateTableStatements(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        ArrayList arrayList = new ArrayList();
        addCreateTableStatements(connectionSource.getDatabaseType(), tableInfo, arrayList, new ArrayList(), z);
        return arrayList;
    }

    private static <T, ID> void addCreateTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, List<String> list2, boolean z) throws SQLException {
        FieldType[] fieldTypeArr;
        int i;
        int i2;
        boolean z2;
        DatabaseType databaseType2 = databaseType;
        List<String> list3 = list;
        boolean z3 = z;
        StringBuilder sb = new StringBuilder(256);
        sb.append("CREATE TABLE ");
        if (z3 && databaseType.isCreateIfNotExistsSupported()) {
            sb.append("IF NOT EXISTS ");
        }
        databaseType2.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(" (");
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        FieldType[] fieldTypes = tableInfo.getFieldTypes();
        int length = fieldTypes.length;
        boolean z4 = true;
        int i3 = 0;
        while (i3 < length) {
            FieldType fieldType = fieldTypes[i3];
            if (!fieldType.isForeignCollection()) {
                if (z4) {
                    z2 = false;
                } else {
                    sb.append(", ");
                    z2 = z4;
                }
                String columnDefinition = fieldType.getColumnDefinition();
                if (columnDefinition == null) {
                    i2 = i3;
                    i = length;
                    fieldTypeArr = fieldTypes;
                    databaseType.appendColumnArg(tableInfo.getTableName(), sb, fieldType, arrayList, arrayList2, arrayList3, list2);
                } else {
                    i2 = i3;
                    i = length;
                    fieldTypeArr = fieldTypes;
                    databaseType2.appendEscapedEntityName(sb, fieldType.getColumnName());
                    sb.append(' ');
                    sb.append(columnDefinition);
                    sb.append(' ');
                }
                z4 = z2;
            } else {
                i2 = i3;
                i = length;
                fieldTypeArr = fieldTypes;
            }
            i3 = i2 + 1;
            length = i;
            fieldTypes = fieldTypeArr;
        }
        DatabaseType databaseType3 = databaseType;
        String str = ", ";
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        ArrayList arrayList6 = arrayList3;
        List<String> list4 = list2;
        databaseType3.addPrimaryKeySql(tableInfo.getFieldTypes(), arrayList4, arrayList5, arrayList6, list4);
        databaseType3.addUniqueComboSql(tableInfo.getFieldTypes(), arrayList4, arrayList5, arrayList6, list4);
        for (String append : arrayList) {
            sb.append(str);
            sb.append(append);
        }
        sb.append(") ");
        databaseType2.appendCreateTableSuffix(sb);
        list3.addAll(arrayList2);
        list3.add(sb.toString());
        list3.addAll(arrayList3);
        TableInfo<T, ID> tableInfo2 = tableInfo;
        addCreateIndexStatements(databaseType2, tableInfo2, list3, z3, false);
        addCreateIndexStatements(databaseType2, tableInfo2, list3, z3, true);
    }
}

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DatabaseResultsMapper;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.dao.RawRowObjectMapper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.mapped.MappedCreate;
import com.j256.ormlite.stmt.mapped.MappedDelete;
import com.j256.ormlite.stmt.mapped.MappedDeleteCollection;
import com.j256.ormlite.stmt.mapped.MappedQueryForFieldEq;
import com.j256.ormlite.stmt.mapped.MappedRefresh;
import com.j256.ormlite.stmt.mapped.MappedUpdate;
import com.j256.ormlite.stmt.mapped.MappedUpdateId;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class StatementExecutor<T, ID> implements GenericRowMapper<String[]> {
    private static Logger logger = LoggerFactory.getLogger(StatementExecutor.class);
    private static final FieldType[] noFieldTypes = new FieldType[0];
    private String countStarQuery;
    private final Dao<T, ID> dao;
    private final DatabaseType databaseType;
    private FieldType[] ifExistsFieldTypes;
    private String ifExistsQuery;
    private final ThreadLocal<Boolean> localIsInBatchMode = new ThreadLocal<Boolean>() {
        /* class com.j256.ormlite.stmt.StatementExecutor.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };
    private MappedDelete<T, ID> mappedDelete;
    private MappedCreate<T, ID> mappedInsert;
    private MappedQueryForFieldEq<T, ID> mappedQueryForId;
    private MappedRefresh<T, ID> mappedRefresh;
    private MappedUpdate<T, ID> mappedUpdate;
    private MappedUpdateId<T, ID> mappedUpdateId;
    private PreparedQuery<T> preparedQueryForAll;
    private RawRowMapper<T> rawRowMapper;
    private final TableInfo<T, ID> tableInfo;

    public StatementExecutor(DatabaseType databaseType2, TableInfo<T, ID> tableInfo2, Dao<T, ID> dao2) {
        this.databaseType = databaseType2;
        this.tableInfo = tableInfo2;
        this.dao = dao2;
    }

    public T queryForId(DatabaseConnection databaseConnection, ID id, ObjectCache objectCache) throws SQLException {
        if (this.mappedQueryForId == null) {
            this.mappedQueryForId = MappedQueryForFieldEq.build(this.databaseType, this.tableInfo, null);
        }
        return this.mappedQueryForId.execute(databaseConnection, id, objectCache);
    }

    public T queryForFirst(DatabaseConnection databaseConnection, PreparedStmt<T> preparedStmt, ObjectCache objectCache) throws SQLException {
        DatabaseResults databaseResults;
        CompiledStatement compile = preparedStmt.compile(databaseConnection, StatementBuilder.StatementType.SELECT);
        try {
            compile.setMaxRows(1);
            databaseResults = compile.runQuery(objectCache);
            try {
                if (databaseResults.first()) {
                    logger.debug("query-for-first of '{}' returned at least 1 result", preparedStmt.getStatement());
                    T mapRow = preparedStmt.mapRow(databaseResults);
                    IOUtils.closeThrowSqlException(databaseResults, "results");
                    IOUtils.closeThrowSqlException(compile, "compiled statement");
                    return mapRow;
                }
                logger.debug("query-for-first of '{}' returned at 0 results", preparedStmt.getStatement());
                IOUtils.closeThrowSqlException(databaseResults, "results");
                IOUtils.closeThrowSqlException(compile, "compiled statement");
                return null;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(databaseResults, "results");
                IOUtils.closeThrowSqlException(compile, "compiled statement");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            databaseResults = null;
            IOUtils.closeThrowSqlException(databaseResults, "results");
            IOUtils.closeThrowSqlException(compile, "compiled statement");
            throw th;
        }
    }

    public List<T> queryForAll(ConnectionSource connectionSource, ObjectCache objectCache) throws SQLException {
        prepareQueryForAll();
        return query(connectionSource, this.preparedQueryForAll, objectCache);
    }

    public long queryForCountStar(DatabaseConnection databaseConnection) throws SQLException {
        if (this.countStarQuery == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("SELECT COUNT(*) FROM ");
            this.databaseType.appendEscapedEntityName(sb, this.tableInfo.getTableName());
            this.countStarQuery = sb.toString();
        }
        long queryForLong = databaseConnection.queryForLong(this.countStarQuery);
        logger.debug("query of '{}' returned {}", this.countStarQuery, Long.valueOf(queryForLong));
        return queryForLong;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:7:0x0021 */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.j256.ormlite.dao.ObjectCache] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.j256.ormlite.support.DatabaseResults, java.io.Closeable] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    public long queryForLong(com.j256.ormlite.support.DatabaseConnection r7, com.j256.ormlite.stmt.PreparedStmt<T> r8) throws java.sql.SQLException {
        /*
            r6 = this;
            java.lang.String r0 = "compiled statement"
            java.lang.String r1 = "results"
            com.j256.ormlite.stmt.StatementBuilder$StatementType r2 = com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT_LONG
            com.j256.ormlite.support.CompiledStatement r7 = r8.compile(r7, r2)
            r2 = 0
            com.j256.ormlite.support.DatabaseResults r2 = r7.runQuery(r2)     // Catch:{ all -> 0x0039 }
            boolean r3 = r2.first()     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x0021
            r8 = 0
            long r3 = r2.getLong(r8)     // Catch:{ all -> 0x0039 }
            com.j256.ormlite.misc.IOUtils.closeThrowSqlException(r2, r1)
            com.j256.ormlite.misc.IOUtils.closeThrowSqlException(r7, r0)
            return r3
        L_0x0021:
            java.sql.SQLException r3 = new java.sql.SQLException     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            java.lang.String r5 = "No result found in queryForLong: "
            r4.<init>(r5)     // Catch:{ all -> 0x0039 }
            java.lang.String r8 = r8.getStatement()     // Catch:{ all -> 0x0039 }
            r4.append(r8)     // Catch:{ all -> 0x0039 }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x0039 }
            r3.<init>(r8)     // Catch:{ all -> 0x0039 }
            throw r3     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r8 = move-exception
            com.j256.ormlite.misc.IOUtils.closeThrowSqlException(r2, r1)
            com.j256.ormlite.misc.IOUtils.closeThrowSqlException(r7, r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.StatementExecutor.queryForLong(com.j256.ormlite.support.DatabaseConnection, com.j256.ormlite.stmt.PreparedStmt):long");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    public long queryForLong(DatabaseConnection databaseConnection, String str, String[] strArr) throws SQLException {
        CompiledStatement compiledStatement;
        logger.debug("executing raw query for long: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseResults databaseResults = null;
        try {
            compiledStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr);
                databaseResults = compiledStatement.runQuery(null);
                if (databaseResults.first()) {
                    long j = databaseResults.getLong(0);
                    IOUtils.closeThrowSqlException(databaseResults, "results");
                    IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                    return j;
                }
                throw new SQLException("No result found in queryForLong: ".concat(String.valueOf(str)));
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(databaseResults, "results");
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
            IOUtils.closeThrowSqlException(databaseResults, "results");
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            throw th;
        }
    }

    public List<T> query(ConnectionSource connectionSource, PreparedStmt<T> preparedStmt, ObjectCache objectCache) throws SQLException {
        SelectIterator<T, ID> buildIterator = buildIterator(null, connectionSource, preparedStmt, objectCache, -1);
        try {
            ArrayList arrayList = new ArrayList();
            while (buildIterator.hasNextThrow()) {
                arrayList.add(buildIterator.nextThrow());
            }
            logger.debug("query of '{}' returned {} results", preparedStmt.getStatement(), Integer.valueOf(arrayList.size()));
            return arrayList;
        } finally {
            IOUtils.closeThrowSqlException(buildIterator, "iterator");
        }
    }

    public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> baseDaoImpl, ConnectionSource connectionSource, int i, ObjectCache objectCache) throws SQLException {
        prepareQueryForAll();
        return buildIterator(baseDaoImpl, connectionSource, this.preparedQueryForAll, objectCache, i);
    }

    public GenericRowMapper<T> getSelectStarRowMapper() throws SQLException {
        prepareQueryForAll();
        return this.preparedQueryForAll;
    }

    public RawRowMapper<T> getRawRowMapper() {
        if (this.rawRowMapper == null) {
            this.rawRowMapper = new RawRowMapperImpl(this.tableInfo);
        }
        return this.rawRowMapper;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> baseDaoImpl, ConnectionSource connectionSource, PreparedStmt<T> preparedStmt, ObjectCache objectCache, int i) throws SQLException {
        CompiledStatement compiledStatement;
        ConnectionSource connectionSource2 = connectionSource;
        DatabaseConnection readOnlyConnection = connectionSource2.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            compiledStatement = preparedStmt.compile(readOnlyConnection, StatementBuilder.StatementType.SELECT, i);
            try {
                SelectIterator selectIterator = new SelectIterator(this.tableInfo.getDataClass(), baseDaoImpl, preparedStmt, connectionSource, readOnlyConnection, compiledStatement, preparedStmt.getStatement(), objectCache);
                IOUtils.closeThrowSqlException(null, "compiled statement");
                return selectIterator;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                if (readOnlyConnection != null) {
                    connectionSource2.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            if (readOnlyConnection != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055  */
    public GenericRawResults<String[]> queryRaw(ConnectionSource connectionSource, String str, String[] strArr, ObjectCache objectCache) throws SQLException {
        CompiledStatement compiledStatement;
        ConnectionSource connectionSource2 = connectionSource;
        String[] strArr2 = strArr;
        logger.debug("executing raw query for: {}", str);
        if (strArr2.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr2);
        }
        DatabaseConnection readOnlyConnection = connectionSource2.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr2);
                RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compiledStatement, this, objectCache);
                IOUtils.closeThrowSqlException(null, "compiled statement");
                return rawResultsImpl;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                if (readOnlyConnection != null) {
                    connectionSource2.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            if (readOnlyConnection != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    public <UO> GenericRawResults<UO> queryRaw(ConnectionSource connectionSource, String str, RawRowMapper rawRowMapper2, String[] strArr, ObjectCache objectCache) throws SQLException {
        CompiledStatement compiledStatement;
        ConnectionSource connectionSource2 = connectionSource;
        String[] strArr2 = strArr;
        logger.debug("executing raw query for: {}", str);
        if (strArr2.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr2);
        }
        DatabaseConnection readOnlyConnection = connectionSource2.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr2);
                RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compiledStatement, new UserRawRowMapper(rawRowMapper2, this), objectCache);
                IOUtils.closeThrowSqlException(null, "compiled statement");
                return rawResultsImpl;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                if (readOnlyConnection != null) {
                    connectionSource2.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            if (readOnlyConnection != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005c  */
    public <UO> GenericRawResults<UO> queryRaw(ConnectionSource connectionSource, String str, DataType[] dataTypeArr, RawRowObjectMapper<UO> rawRowObjectMapper, String[] strArr, ObjectCache objectCache) throws SQLException {
        CompiledStatement compiledStatement;
        ConnectionSource connectionSource2 = connectionSource;
        String[] strArr2 = strArr;
        logger.debug("executing raw query for: {}", str);
        if (strArr2.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr2);
        }
        DatabaseConnection readOnlyConnection = connectionSource2.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr2);
                RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compiledStatement, new UserRawRowObjectMapper(rawRowObjectMapper, dataTypeArr), objectCache);
                IOUtils.closeThrowSqlException(null, "compiled statement");
                return rawResultsImpl;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                if (readOnlyConnection != null) {
                    connectionSource2.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            if (readOnlyConnection != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    public GenericRawResults<Object[]> queryRaw(ConnectionSource connectionSource, String str, DataType[] dataTypeArr, String[] strArr, ObjectCache objectCache) throws SQLException {
        CompiledStatement compiledStatement;
        ConnectionSource connectionSource2 = connectionSource;
        String[] strArr2 = strArr;
        logger.debug("executing raw query for: {}", str);
        if (strArr2.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr2);
        }
        DatabaseConnection readOnlyConnection = connectionSource2.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr2);
                RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, Object[].class, compiledStatement, new ObjectArrayRowMapper(dataTypeArr), objectCache);
                IOUtils.closeThrowSqlException(null, "compiled statement");
                return rawResultsImpl;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                if (readOnlyConnection != null) {
                    connectionSource2.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            if (readOnlyConnection != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    public <UO> GenericRawResults<UO> queryRaw(ConnectionSource connectionSource, String str, DatabaseResultsMapper databaseResultsMapper, String[] strArr, ObjectCache objectCache) throws SQLException {
        CompiledStatement compiledStatement;
        ConnectionSource connectionSource2 = connectionSource;
        String[] strArr2 = strArr;
        logger.debug("executing raw query for: {}", str);
        if (strArr2.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr2);
        }
        DatabaseConnection readOnlyConnection = connectionSource2.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr2);
                RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, Object[].class, compiledStatement, new UserDatabaseResultsMapper(databaseResultsMapper), objectCache);
                IOUtils.closeThrowSqlException(null, "compiled statement");
                return rawResultsImpl;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                if (readOnlyConnection != null) {
                    connectionSource2.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            if (readOnlyConnection != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    public int updateRaw(DatabaseConnection databaseConnection, String str, String[] strArr) throws SQLException {
        logger.debug("running raw update statement: {}", str);
        if (strArr.length > 0) {
            logger.trace("update arguments: {}", (Object) strArr);
        }
        CompiledStatement compileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.UPDATE, noFieldTypes, -1, false);
        try {
            assignStatementArguments(compileStatement, strArr);
            return compileStatement.runUpdate();
        } finally {
            IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
        }
    }

    public int executeRawNoArgs(DatabaseConnection databaseConnection, String str) throws SQLException {
        logger.debug("running raw execute statement: {}", str);
        return databaseConnection.executeStatement(str, -1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    public int executeRaw(DatabaseConnection databaseConnection, String str, String[] strArr) throws SQLException {
        logger.debug("running raw execute statement: {}", str);
        if (strArr.length > 0) {
            logger.trace("execute arguments: {}", (Object) strArr);
        }
        CompiledStatement compileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1, false);
        try {
            assignStatementArguments(compileStatement, strArr);
            return compileStatement.runExecute();
        } finally {
            IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
        }
    }

    public int create(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedInsert == null) {
            this.mappedInsert = MappedCreate.build(this.databaseType, this.tableInfo);
        }
        int insert = this.mappedInsert.insert(this.databaseType, databaseConnection, t, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return insert;
    }

    public int update(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedUpdate == null) {
            this.mappedUpdate = MappedUpdate.build(this.databaseType, this.tableInfo);
        }
        int update = this.mappedUpdate.update(databaseConnection, t, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return update;
    }

    public int updateId(DatabaseConnection databaseConnection, T t, ID id, ObjectCache objectCache) throws SQLException {
        if (this.mappedUpdateId == null) {
            this.mappedUpdateId = MappedUpdateId.build(this.databaseType, this.tableInfo);
        }
        int execute = this.mappedUpdateId.execute(databaseConnection, t, id, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return execute;
    }

    public int update(DatabaseConnection databaseConnection, PreparedUpdate<T> preparedUpdate) throws SQLException {
        CompiledStatement compile = preparedUpdate.compile(databaseConnection, StatementBuilder.StatementType.UPDATE);
        try {
            int runUpdate = compile.runUpdate();
            if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
                this.dao.notifyChanges();
            }
            return runUpdate;
        } finally {
            IOUtils.closeThrowSqlException(compile, "compiled statement");
        }
    }

    public int refresh(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedRefresh == null) {
            this.mappedRefresh = MappedRefresh.build(this.databaseType, this.tableInfo);
        }
        return this.mappedRefresh.executeRefresh(databaseConnection, t, objectCache);
    }

    public int delete(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedDelete == null) {
            this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo);
        }
        int delete = this.mappedDelete.delete(databaseConnection, t, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return delete;
    }

    public int deleteById(DatabaseConnection databaseConnection, ID id, ObjectCache objectCache) throws SQLException {
        if (this.mappedDelete == null) {
            this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo);
        }
        int deleteById = this.mappedDelete.deleteById(databaseConnection, id, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return deleteById;
    }

    public int deleteObjects(DatabaseConnection databaseConnection, Collection<T> collection, ObjectCache objectCache) throws SQLException {
        int deleteObjects = MappedDeleteCollection.deleteObjects(this.databaseType, this.tableInfo, databaseConnection, collection, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return deleteObjects;
    }

    public int deleteIds(DatabaseConnection databaseConnection, Collection<ID> collection, ObjectCache objectCache) throws SQLException {
        int deleteIds = MappedDeleteCollection.deleteIds(this.databaseType, this.tableInfo, databaseConnection, collection, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return deleteIds;
    }

    public int delete(DatabaseConnection databaseConnection, PreparedDelete<T> preparedDelete) throws SQLException {
        CompiledStatement compile = preparedDelete.compile(databaseConnection, StatementBuilder.StatementType.DELETE);
        try {
            int runUpdate = compile.runUpdate();
            if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
                this.dao.notifyChanges();
            }
            return runUpdate;
        } finally {
            IOUtils.closeThrowSqlException(compile, "compiled statement");
        }
    }

    public <CT> CT callBatchTasks(ConnectionSource connectionSource, Callable<CT> callable) throws SQLException {
        CT doCallBatchTasks;
        if (!connectionSource.isSingleConnection(this.tableInfo.getTableName())) {
            return doCallBatchTasks(connectionSource, callable);
        }
        synchronized (this) {
            doCallBatchTasks = doCallBatchTasks(connectionSource, callable);
        }
        return doCallBatchTasks;
    }

    private <CT> CT doCallBatchTasks(ConnectionSource connectionSource, Callable<CT> callable) throws SQLException {
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        boolean z = false;
        try {
            this.localIsInBatchMode.set(Boolean.TRUE);
            z = connectionSource.saveSpecialConnection(readWriteConnection);
            return doCallBatchTasks(readWriteConnection, z, callable);
        } finally {
            if (z) {
                connectionSource.clearSpecialConnection(readWriteConnection);
            }
            connectionSource.releaseConnection(readWriteConnection);
            this.localIsInBatchMode.set(Boolean.FALSE);
            Dao<T, ID> dao2 = this.dao;
            if (dao2 != null) {
                dao2.notifyChanges();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057  */
    private <CT> CT doCallBatchTasks(DatabaseConnection databaseConnection, boolean z, Callable<CT> callable) throws SQLException {
        if (this.databaseType.isBatchUseTransaction()) {
            return TransactionManager.callInTransaction(databaseConnection, z, this.databaseType, callable);
        }
        boolean z2 = false;
        try {
            if (databaseConnection.isAutoCommitSupported() && databaseConnection.isAutoCommit()) {
                databaseConnection.setAutoCommit(false);
                try {
                    logger.debug("disabled auto-commit on table {} before batch tasks", this.tableInfo.getTableName());
                    z2 = true;
                } catch (Throwable th) {
                    th = th;
                    z2 = true;
                    if (z2) {
                        databaseConnection.setAutoCommit(true);
                        logger.debug("re-enabled auto-commit on table {} after batch tasks", this.tableInfo.getTableName());
                    }
                    throw th;
                }
            }
            CT call = callable.call();
            if (z2) {
                databaseConnection.setAutoCommit(true);
                logger.debug("re-enabled auto-commit on table {} after batch tasks", this.tableInfo.getTableName());
            }
            return call;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e2) {
            throw SqlExceptionUtil.create("Batch tasks callable threw non-SQL exception", e2);
        } catch (Throwable th2) {
            th = th2;
            if (z2) {
            }
            throw th;
        }
    }

    public String[] mapRow(DatabaseResults databaseResults) throws SQLException {
        int columnCount = databaseResults.getColumnCount();
        String[] strArr = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            strArr[i] = databaseResults.getString(i);
        }
        return strArr;
    }

    public boolean ifExists(DatabaseConnection databaseConnection, ID id) throws SQLException {
        if (this.ifExistsQuery == null) {
            QueryBuilder queryBuilder = new QueryBuilder(this.databaseType, this.tableInfo, this.dao);
            queryBuilder.selectRaw("COUNT(*)");
            queryBuilder.where().eq(this.tableInfo.getIdField().getColumnName(), new SelectArg());
            this.ifExistsQuery = queryBuilder.prepareStatementString();
            this.ifExistsFieldTypes = new FieldType[]{this.tableInfo.getIdField()};
        }
        long queryForLong = databaseConnection.queryForLong(this.ifExistsQuery, new Object[]{this.tableInfo.getIdField().convertJavaFieldToSqlArgValue(id)}, this.ifExistsFieldTypes);
        logger.debug("query of '{}' returned {}", this.ifExistsQuery, Long.valueOf(queryForLong));
        return queryForLong != 0;
    }

    private void assignStatementArguments(CompiledStatement compiledStatement, String[] strArr) throws SQLException {
        for (int i = 0; i < strArr.length; i++) {
            compiledStatement.setObject(i, strArr[i], SqlType.STRING);
        }
    }

    private void prepareQueryForAll() throws SQLException {
        if (this.preparedQueryForAll == null) {
            this.preparedQueryForAll = new QueryBuilder(this.databaseType, this.tableInfo, this.dao).prepare();
        }
    }

    static class UserRawRowMapper<UO> implements GenericRowMapper<UO> {
        private String[] columnNames;
        private final RawRowMapper<UO> mapper;
        private final GenericRowMapper<String[]> stringRowMapper;

        public UserRawRowMapper(RawRowMapper<UO> rawRowMapper, GenericRowMapper<String[]> genericRowMapper) {
            this.mapper = rawRowMapper;
            this.stringRowMapper = genericRowMapper;
        }

        public UO mapRow(DatabaseResults databaseResults) throws SQLException {
            return this.mapper.mapRow(getColumnNames(databaseResults), this.stringRowMapper.mapRow(databaseResults));
        }

        private String[] getColumnNames(DatabaseResults databaseResults) throws SQLException {
            String[] strArr = this.columnNames;
            if (strArr != null) {
                return strArr;
            }
            this.columnNames = databaseResults.getColumnNames();
            return this.columnNames;
        }
    }

    static class UserRawRowObjectMapper<UO> implements GenericRowMapper<UO> {
        private String[] columnNames;
        private final DataType[] columnTypes;
        private final RawRowObjectMapper<UO> mapper;

        public UserRawRowObjectMapper(RawRowObjectMapper<UO> rawRowObjectMapper, DataType[] dataTypeArr) {
            this.mapper = rawRowObjectMapper;
            this.columnTypes = dataTypeArr;
        }

        public UO mapRow(DatabaseResults databaseResults) throws SQLException {
            int columnCount = databaseResults.getColumnCount();
            Object[] objArr = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                DataType[] dataTypeArr = this.columnTypes;
                if (i >= dataTypeArr.length) {
                    objArr[i] = null;
                } else {
                    objArr[i] = dataTypeArr[i].getDataPersister().resultToJava(null, databaseResults, i);
                }
            }
            return this.mapper.mapRow(getColumnNames(databaseResults), this.columnTypes, objArr);
        }

        private String[] getColumnNames(DatabaseResults databaseResults) throws SQLException {
            String[] strArr = this.columnNames;
            if (strArr != null) {
                return strArr;
            }
            this.columnNames = databaseResults.getColumnNames();
            return this.columnNames;
        }
    }

    static class ObjectArrayRowMapper implements GenericRowMapper<Object[]> {
        private final DataType[] columnTypes;

        public ObjectArrayRowMapper(DataType[] dataTypeArr) {
            this.columnTypes = dataTypeArr;
        }

        public Object[] mapRow(DatabaseResults databaseResults) throws SQLException {
            DataType dataType;
            int columnCount = databaseResults.getColumnCount();
            Object[] objArr = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                DataType[] dataTypeArr = this.columnTypes;
                if (i >= dataTypeArr.length) {
                    dataType = DataType.STRING;
                } else {
                    dataType = dataTypeArr[i];
                }
                objArr[i] = dataType.getDataPersister().resultToJava(null, databaseResults, i);
            }
            return objArr;
        }
    }

    static class UserDatabaseResultsMapper<UO> implements GenericRowMapper<UO> {
        public final DatabaseResultsMapper<UO> mapper;

        private UserDatabaseResultsMapper(DatabaseResultsMapper<UO> databaseResultsMapper) {
            this.mapper = databaseResultsMapper;
        }

        public UO mapRow(DatabaseResults databaseResults) throws SQLException {
            return this.mapper.mapRow(databaseResults);
        }
    }
}

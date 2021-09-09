package com.j256.ormlite.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.StatementExecutor;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.ObjectFactory;
import com.j256.ormlite.table.TableInfo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseDaoImpl<T, ID> implements Dao<T, ID> {
    private static final Object constantObject = new Object();
    private static final ThreadLocal<List<BaseDaoImpl<?, ?>>> daoConfigLevelLocal = new ThreadLocal<List<BaseDaoImpl<?, ?>>>() {
        /* class com.j256.ormlite.dao.BaseDaoImpl.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final List<BaseDaoImpl<?, ?>> initialValue() {
            return new ArrayList(10);
        }
    };
    private static ReferenceObjectCache defaultObjectCache;
    protected ConnectionSource connectionSource;
    private Map<Dao.DaoObserver, Object> daoObserverMap;
    protected final Class<T> dataClass;
    protected DatabaseType databaseType;
    private boolean initialized;
    protected CloseableIterator<T> lastIterator;
    ObjectCache objectCache;
    protected ObjectFactory<T> objectFactory;
    protected StatementExecutor<T, ID> statementExecutor;
    protected DatabaseTableConfig<T> tableConfig;
    protected TableInfo<T, ID> tableInfo;

    protected BaseDaoImpl(Class<T> cls) throws SQLException {
        this(null, cls, null);
    }

    protected BaseDaoImpl(ConnectionSource connectionSource2, Class<T> cls) throws SQLException {
        this(connectionSource2, cls, null);
    }

    protected BaseDaoImpl(ConnectionSource connectionSource2, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        this(connectionSource2, databaseTableConfig.getDataClass(), databaseTableConfig);
    }

    private BaseDaoImpl(ConnectionSource connectionSource2, Class<T> cls, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        this.dataClass = cls;
        this.tableConfig = databaseTableConfig;
        if (connectionSource2 != null) {
            this.connectionSource = connectionSource2;
            initialize();
        }
    }

    public void initialize() throws SQLException {
        BaseDaoImpl baseDaoImpl;
        if (!this.initialized) {
            ConnectionSource connectionSource2 = this.connectionSource;
            if (connectionSource2 != null) {
                this.databaseType = connectionSource2.getDatabaseType();
                if (this.databaseType != null) {
                    DatabaseTableConfig<T> databaseTableConfig = this.tableConfig;
                    if (databaseTableConfig == null) {
                        this.tableInfo = new TableInfo<>(this.connectionSource, this, this.dataClass);
                    } else {
                        databaseTableConfig.extractFieldTypes(this.connectionSource);
                        this.tableInfo = new TableInfo<>(this.databaseType, this, this.tableConfig);
                    }
                    this.statementExecutor = new StatementExecutor<>(this.databaseType, this.tableInfo, this);
                    List list = daoConfigLevelLocal.get();
                    list.add(this);
                    if (list.size() <= 1) {
                        int i = 0;
                        while (i < list.size()) {
                            try {
                                baseDaoImpl = (BaseDaoImpl) list.get(i);
                                DaoManager.registerDao(this.connectionSource, baseDaoImpl);
                                for (FieldType configDaoInformation : baseDaoImpl.getTableInfo().getFieldTypes()) {
                                    configDaoInformation.configDaoInformation(this.connectionSource, baseDaoImpl.getDataClass());
                                }
                                baseDaoImpl.initialized = true;
                                i++;
                            } catch (SQLException e) {
                                DaoManager.unregisterDao(this.connectionSource, baseDaoImpl);
                                throw e;
                            } catch (Throwable th) {
                                list.clear();
                                daoConfigLevelLocal.remove();
                                throw th;
                            }
                        }
                        list.clear();
                        daoConfigLevelLocal.remove();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("connectionSource is getting a null DatabaseType in " + getClass().getSimpleName());
            }
            throw new IllegalStateException("connectionSource was never set on " + getClass().getSimpleName());
        }
    }

    public T queryForId(ID id) throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.queryForId(readOnlyConnection, id, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public T queryForFirst(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.queryForFirst(readOnlyConnection, preparedQuery, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public List<T> queryForAll() throws SQLException {
        checkForInitialized();
        return this.statementExecutor.queryForAll(this.connectionSource, this.objectCache);
    }

    public List<T> queryForEq(String str, Object obj) throws SQLException {
        return queryBuilder().where().eq(str, obj).query();
    }

    public QueryBuilder<T, ID> queryBuilder() {
        checkForInitialized();
        return new QueryBuilder<>(this.databaseType, this.tableInfo, this);
    }

    public UpdateBuilder<T, ID> updateBuilder() {
        checkForInitialized();
        return new UpdateBuilder<>(this.databaseType, this.tableInfo, this);
    }

    public DeleteBuilder<T, ID> deleteBuilder() {
        checkForInitialized();
        return new DeleteBuilder<>(this.databaseType, this.tableInfo, this);
    }

    public List<T> query(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        return this.statementExecutor.query(this.connectionSource, preparedQuery, this.objectCache);
    }

    public List<T> queryForMatching(T t) throws SQLException {
        return queryForMatching(t, false);
    }

    public List<T> queryForMatchingArgs(T t) throws SQLException {
        return queryForMatching(t, true);
    }

    public List<T> queryForFieldValues(Map<String, Object> map) throws SQLException {
        return queryForFieldValues(map, false);
    }

    public List<T> queryForFieldValuesArgs(Map<String, Object> map) throws SQLException {
        return queryForFieldValues(map, true);
    }

    public T queryForSameId(T t) throws SQLException {
        Object extractId;
        checkForInitialized();
        if (t == null || (extractId = extractId(t)) == null) {
            return null;
        }
        return queryForId(extractId);
    }

    public int create(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(this);
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.create(readWriteConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int create(final Collection<?> collection) throws SQLException {
        checkForInitialized();
        for (Object next : collection) {
            if (next instanceof BaseDaoEnabled) {
                ((BaseDaoEnabled) next).setDao(this);
            }
        }
        final DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return ((Integer) callBatchTasks(new Callable<Integer>() {
                /* class com.j256.ormlite.dao.BaseDaoImpl.AnonymousClass2 */

                public Integer call() throws SQLException {
                    int i = 0;
                    for (Object create : collection) {
                        i += BaseDaoImpl.this.statementExecutor.create(readWriteConnection, create, BaseDaoImpl.this.objectCache);
                    }
                    return Integer.valueOf(i);
                }
            })).intValue();
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public synchronized T createIfNotExists(T t) throws SQLException {
        if (t == null) {
            return null;
        }
        T queryForSameId = queryForSameId(t);
        if (queryForSameId != null) {
            return queryForSameId;
        }
        create((Object) t);
        return t;
    }

    public synchronized Dao.CreateOrUpdateStatus createOrUpdate(T t) throws SQLException {
        if (t == null) {
            return new Dao.CreateOrUpdateStatus(false, false, 0);
        }
        Object extractId = extractId(t);
        if (extractId != null) {
            if (idExists(extractId)) {
                return new Dao.CreateOrUpdateStatus(false, true, update((Object) t));
            }
        }
        return new Dao.CreateOrUpdateStatus(true, false, create((Object) t));
    }

    public int update(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(this);
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.update(readWriteConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int updateId(T t, ID id) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.updateId(readWriteConnection, t, id, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int update(PreparedUpdate<T> preparedUpdate) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.update(readWriteConnection, preparedUpdate);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int refresh(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(this);
        }
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.refresh(readOnlyConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public int delete(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.delete(readWriteConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int deleteById(ID id) throws SQLException {
        checkForInitialized();
        if (id == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.deleteById(readWriteConnection, id, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int delete(Collection<T> collection) throws SQLException {
        checkForInitialized();
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.deleteObjects(readWriteConnection, collection, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int deleteIds(Collection<ID> collection) throws SQLException {
        checkForInitialized();
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.deleteIds(readWriteConnection, collection, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int delete(PreparedDelete<T> preparedDelete) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.delete(readWriteConnection, preparedDelete);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public CloseableIterator<T> iterator() {
        return iterator(-1);
    }

    public CloseableIterator<T> closeableIterator() {
        return iterator(-1);
    }

    public CloseableIterator<T> iterator(int i) {
        checkForInitialized();
        this.lastIterator = createIterator(i);
        return this.lastIterator;
    }

    public CloseableWrappedIterable<T> getWrappedIterable() {
        checkForInitialized();
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() {
            /* class com.j256.ormlite.dao.BaseDaoImpl.AnonymousClass3 */

            public Iterator<T> iterator() {
                return closeableIterator();
            }

            public CloseableIterator<T> closeableIterator() {
                try {
                    return BaseDaoImpl.this.createIterator(-1);
                } catch (Exception e) {
                    throw new IllegalStateException("Could not build iterator for " + BaseDaoImpl.this.dataClass, e);
                }
            }
        });
    }

    public CloseableWrappedIterable<T> getWrappedIterable(final PreparedQuery<T> preparedQuery) {
        checkForInitialized();
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() {
            /* class com.j256.ormlite.dao.BaseDaoImpl.AnonymousClass4 */

            public Iterator<T> iterator() {
                return closeableIterator();
            }

            public CloseableIterator<T> closeableIterator() {
                try {
                    return BaseDaoImpl.this.createIterator(preparedQuery, -1);
                } catch (Exception e) {
                    throw new IllegalStateException("Could not build prepared-query iterator for " + BaseDaoImpl.this.dataClass, e);
                }
            }
        });
    }

    public void closeLastIterator() throws IOException {
        CloseableIterator<T> closeableIterator = this.lastIterator;
        if (closeableIterator != null) {
            closeableIterator.close();
            this.lastIterator = null;
        }
    }

    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery) throws SQLException {
        return iterator(preparedQuery, -1);
    }

    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery, int i) throws SQLException {
        checkForInitialized();
        this.lastIterator = createIterator(preparedQuery, i);
        return this.lastIterator;
    }

    public GenericRawResults<String[]> queryRaw(String str, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, strArr, this.objectCache);
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not perform raw query for ".concat(String.valueOf(str)), e);
        }
    }

    public <GR> GenericRawResults<GR> queryRaw(String str, RawRowMapper<GR> rawRowMapper, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, rawRowMapper, strArr, this.objectCache);
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not perform raw query for ".concat(String.valueOf(str)), e);
        }
    }

    public <UO> GenericRawResults<UO> queryRaw(String str, DataType[] dataTypeArr, RawRowObjectMapper<UO> rawRowObjectMapper, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, dataTypeArr, rawRowObjectMapper, strArr, this.objectCache);
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not perform raw query for ".concat(String.valueOf(str)), e);
        }
    }

    public GenericRawResults<Object[]> queryRaw(String str, DataType[] dataTypeArr, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, dataTypeArr, strArr, this.objectCache);
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not perform raw query for ".concat(String.valueOf(str)), e);
        }
    }

    public <UO> GenericRawResults<UO> queryRaw(String str, DatabaseResultsMapper<UO> databaseResultsMapper, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, databaseResultsMapper, strArr, this.objectCache);
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not perform raw query for ".concat(String.valueOf(str)), e);
        }
    }

    public long queryRawValue(String str, String... strArr) throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            long queryForLong = this.statementExecutor.queryForLong(readOnlyConnection, str, strArr);
            this.connectionSource.releaseConnection(readOnlyConnection);
            return queryForLong;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not perform raw value query for ".concat(String.valueOf(str)), e);
        } catch (Throwable th) {
            this.connectionSource.releaseConnection(readOnlyConnection);
            throw th;
        }
    }

    public int executeRaw(String str, String... strArr) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            int executeRaw = this.statementExecutor.executeRaw(readWriteConnection, str, strArr);
            this.connectionSource.releaseConnection(readWriteConnection);
            return executeRaw;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not run raw execute statement ".concat(String.valueOf(str)), e);
        } catch (Throwable th) {
            this.connectionSource.releaseConnection(readWriteConnection);
            throw th;
        }
    }

    public int executeRawNoArgs(String str) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            int executeRawNoArgs = this.statementExecutor.executeRawNoArgs(readWriteConnection, str);
            this.connectionSource.releaseConnection(readWriteConnection);
            return executeRawNoArgs;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not run raw execute statement ".concat(String.valueOf(str)), e);
        } catch (Throwable th) {
            this.connectionSource.releaseConnection(readWriteConnection);
            throw th;
        }
    }

    public int updateRaw(String str, String... strArr) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            int updateRaw = this.statementExecutor.updateRaw(readWriteConnection, str, strArr);
            this.connectionSource.releaseConnection(readWriteConnection);
            return updateRaw;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not run raw update statement ".concat(String.valueOf(str)), e);
        } catch (Throwable th) {
            this.connectionSource.releaseConnection(readWriteConnection);
            throw th;
        }
    }

    public <CT> CT callBatchTasks(Callable<CT> callable) throws SQLException {
        checkForInitialized();
        return this.statementExecutor.callBatchTasks(this.connectionSource, callable);
    }

    public String objectToString(T t) {
        checkForInitialized();
        return this.tableInfo.objectToString(t);
    }

    public boolean objectsEqual(T t, T t2) throws SQLException {
        checkForInitialized();
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            if (!fieldType.getDataPersister().dataIsEqual(fieldType.extractJavaFieldValue(t), fieldType.extractJavaFieldValue(t2))) {
                return false;
            }
        }
        return true;
    }

    public ID extractId(T t) throws SQLException {
        checkForInitialized();
        FieldType idField = this.tableInfo.getIdField();
        if (idField != null) {
            return idField.extractJavaFieldValue(t);
        }
        throw new SQLException("Class " + this.dataClass + " does not have an id field");
    }

    public Class<T> getDataClass() {
        return this.dataClass;
    }

    public FieldType findForeignFieldType(Class<?> cls) {
        checkForInitialized();
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            if (fieldType.getType() == cls) {
                return fieldType;
            }
        }
        return null;
    }

    public boolean isUpdatable() {
        return this.tableInfo.isUpdatable();
    }

    public boolean isTableExists() throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return readOnlyConnection.isTableExists(this.tableInfo.getTableName());
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public long countOf() throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.queryForCountStar(readOnlyConnection);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public long countOf(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        if (preparedQuery.getType() == StatementBuilder.StatementType.SELECT_LONG) {
            DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
            try {
                return this.statementExecutor.queryForLong(readOnlyConnection, preparedQuery);
            } finally {
                this.connectionSource.releaseConnection(readOnlyConnection);
            }
        } else {
            throw new IllegalArgumentException("Prepared query is not of type " + StatementBuilder.StatementType.SELECT_LONG + ", you need to call QueryBuilder.setCountOf(true)");
        }
    }

    public void assignEmptyForeignCollection(T t, String str) throws SQLException {
        makeEmptyForeignCollection(t, str);
    }

    public <FT> ForeignCollection<FT> getEmptyForeignCollection(String str) throws SQLException {
        return makeEmptyForeignCollection(null, str);
    }

    public void setObjectCache(boolean z) throws SQLException {
        if (!z) {
            ObjectCache objectCache2 = this.objectCache;
            if (objectCache2 != null) {
                objectCache2.clear(this.dataClass);
                this.objectCache = null;
            }
        } else if (this.objectCache != null) {
        } else {
            if (this.tableInfo.getIdField() != null) {
                synchronized (BaseDaoImpl.class) {
                    if (defaultObjectCache == null) {
                        defaultObjectCache = ReferenceObjectCache.makeWeakCache();
                    }
                    this.objectCache = defaultObjectCache;
                }
                this.objectCache.registerClass(this.dataClass);
                return;
            }
            throw new SQLException("Class " + this.dataClass + " must have an id field to enable the object cache");
        }
    }

    public void setObjectCache(ObjectCache objectCache2) throws SQLException {
        if (objectCache2 == null) {
            ObjectCache objectCache3 = this.objectCache;
            if (objectCache3 != null) {
                objectCache3.clear(this.dataClass);
                this.objectCache = null;
                return;
            }
            return;
        }
        ObjectCache objectCache4 = this.objectCache;
        if (!(objectCache4 == null || objectCache4 == objectCache2)) {
            objectCache4.clear(this.dataClass);
        }
        if (this.tableInfo.getIdField() != null) {
            this.objectCache = objectCache2;
            this.objectCache.registerClass(this.dataClass);
            return;
        }
        throw new SQLException("Class " + this.dataClass + " must have an id field to enable the object cache");
    }

    public ObjectCache getObjectCache() {
        return this.objectCache;
    }

    public void clearObjectCache() {
        ObjectCache objectCache2 = this.objectCache;
        if (objectCache2 != null) {
            objectCache2.clear(this.dataClass);
        }
    }

    public static synchronized void clearAllInternalObjectCaches() {
        synchronized (BaseDaoImpl.class) {
            if (defaultObjectCache != null) {
                defaultObjectCache.clearAll();
                defaultObjectCache = null;
            }
        }
    }

    public T mapSelectStarRow(DatabaseResults databaseResults) throws SQLException {
        return this.statementExecutor.getSelectStarRowMapper().mapRow(databaseResults);
    }

    public void notifyChanges() {
        Map<Dao.DaoObserver, Object> map = this.daoObserverMap;
        if (map != null) {
            for (Dao.DaoObserver onChange : map.keySet()) {
                onChange.onChange();
            }
        }
    }

    public void registerObserver(Dao.DaoObserver daoObserver) {
        if (this.daoObserverMap == null) {
            synchronized (this) {
                if (this.daoObserverMap == null) {
                    this.daoObserverMap = new ConcurrentHashMap();
                }
            }
        }
        this.daoObserverMap.put(daoObserver, constantObject);
    }

    public void unregisterObserver(Dao.DaoObserver daoObserver) {
        Map<Dao.DaoObserver, Object> map = this.daoObserverMap;
        if (map != null) {
            synchronized (map) {
                this.daoObserverMap.remove(daoObserver);
            }
        }
    }

    public GenericRowMapper<T> getSelectStarRowMapper() throws SQLException {
        return this.statementExecutor.getSelectStarRowMapper();
    }

    public RawRowMapper<T> getRawRowMapper() {
        return this.statementExecutor.getRawRowMapper();
    }

    public boolean idExists(ID id) throws SQLException {
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.ifExists(readOnlyConnection, id);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public DatabaseConnection startThreadConnection() throws SQLException {
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        this.connectionSource.saveSpecialConnection(readWriteConnection);
        return readWriteConnection;
    }

    public void endThreadConnection(DatabaseConnection databaseConnection) throws SQLException {
        this.connectionSource.clearSpecialConnection(databaseConnection);
        this.connectionSource.releaseConnection(databaseConnection);
    }

    public void setAutoCommit(DatabaseConnection databaseConnection, boolean z) throws SQLException {
        databaseConnection.setAutoCommit(z);
    }

    public boolean isAutoCommit(DatabaseConnection databaseConnection) throws SQLException {
        return databaseConnection.isAutoCommit();
    }

    public void commit(DatabaseConnection databaseConnection) throws SQLException {
        databaseConnection.commit(null);
    }

    public void rollBack(DatabaseConnection databaseConnection) throws SQLException {
        databaseConnection.rollback(null);
    }

    public ObjectFactory<T> getObjectFactory() {
        return this.objectFactory;
    }

    public void setObjectFactory(ObjectFactory<T> objectFactory2) {
        checkForInitialized();
        this.objectFactory = objectFactory2;
    }

    public DatabaseTableConfig<T> getTableConfig() {
        return this.tableConfig;
    }

    public TableInfo<T, ID> getTableInfo() {
        return this.tableInfo;
    }

    public ConnectionSource getConnectionSource() {
        return this.connectionSource;
    }

    public void setConnectionSource(ConnectionSource connectionSource2) {
        this.connectionSource = connectionSource2;
    }

    public void setTableConfig(DatabaseTableConfig<T> databaseTableConfig) {
        this.tableConfig = databaseTableConfig;
    }

    public String getTableName() {
        return this.tableInfo.getTableName();
    }

    static <T, ID> Dao<T, ID> createDao(ConnectionSource connectionSource2, Class<T> cls) throws SQLException {
        return new BaseDaoImpl<T, ID>(connectionSource2, cls) {
            /* class com.j256.ormlite.dao.BaseDaoImpl.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ Iterator iterator() {
                return BaseDaoImpl.super.iterator();
            }
        };
    }

    static <T, ID> Dao<T, ID> createDao(ConnectionSource connectionSource2, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return new BaseDaoImpl<T, ID>(connectionSource2, databaseTableConfig) {
            /* class com.j256.ormlite.dao.BaseDaoImpl.AnonymousClass6 */

            public final /* bridge */ /* synthetic */ Iterator iterator() {
                return BaseDaoImpl.super.iterator();
            }
        };
    }

    /* access modifiers changed from: protected */
    public void checkForInitialized() {
        if (!this.initialized) {
            throw new IllegalStateException("you must call initialize() before you can use the dao");
        }
    }

    private <FT> ForeignCollection<FT> makeEmptyForeignCollection(T t, String str) throws SQLException {
        Object obj;
        checkForInitialized();
        if (t == null) {
            obj = null;
        } else {
            obj = extractId(t);
        }
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            if (fieldType.getColumnName().equals(str)) {
                BaseForeignCollection buildForeignCollection = fieldType.buildForeignCollection(t, obj);
                if (t != null) {
                    fieldType.assignField(t, buildForeignCollection, true, null);
                }
                return buildForeignCollection;
            }
        }
        throw new IllegalArgumentException("Could not find a field named ".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: package-private */
    public CloseableIterator<T> createIterator(int i) {
        try {
            return this.statementExecutor.buildIterator(this, this.connectionSource, i, this.objectCache);
        } catch (Exception e) {
            throw new IllegalStateException("Could not build iterator for " + this.dataClass, e);
        }
    }

    /* access modifiers changed from: package-private */
    public CloseableIterator<T> createIterator(PreparedQuery<T> preparedQuery, int i) throws SQLException {
        try {
            return this.statementExecutor.buildIterator(this, this.connectionSource, preparedQuery, this.objectCache, i);
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not build prepared-query iterator for " + this.dataClass, e);
        }
    }

    private List<T> queryForMatching(T t, boolean z) throws SQLException {
        checkForInitialized();
        QueryBuilder queryBuilder = queryBuilder();
        Where where = queryBuilder.where();
        int i = 0;
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            Object fieldValueIfNotDefault = fieldType.getFieldValueIfNotDefault(t);
            if (fieldValueIfNotDefault != null) {
                if (z) {
                    fieldValueIfNotDefault = new SelectArg(fieldValueIfNotDefault);
                }
                where.eq(fieldType.getColumnName(), fieldValueIfNotDefault);
                i++;
            }
        }
        if (i == 0) {
            return Collections.emptyList();
        }
        where.and(i);
        return queryBuilder.query();
    }

    private List<T> queryForFieldValues(Map<String, Object> map, boolean z) throws SQLException {
        checkForInitialized();
        QueryBuilder queryBuilder = queryBuilder();
        Where where = queryBuilder.where();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (z) {
                value = new SelectArg(value);
            }
            where.eq((String) next.getKey(), value);
        }
        if (map.size() == 0) {
            return Collections.emptyList();
        }
        where.and(map.size());
        return queryBuilder.query();
    }
}

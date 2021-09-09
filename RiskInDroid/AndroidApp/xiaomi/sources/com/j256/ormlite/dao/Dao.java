package com.j256.ormlite.dao;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.ObjectFactory;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public interface Dao<T, ID> extends CloseableIterable<T> {

    public interface DaoObserver {
        void onChange();
    }

    void assignEmptyForeignCollection(T t, String str) throws SQLException;

    <CT> CT callBatchTasks(Callable<CT> callable) throws Exception;

    void clearObjectCache();

    void closeLastIterator() throws IOException;

    void commit(DatabaseConnection databaseConnection) throws SQLException;

    long countOf() throws SQLException;

    long countOf(PreparedQuery<T> preparedQuery) throws SQLException;

    int create(MessageRecord messageRecord) throws SQLException;

    int create(Collection<MessageRecord> collection) throws SQLException;

    T createIfNotExists(T t) throws SQLException;

    CreateOrUpdateStatus createOrUpdate(T t) throws SQLException;

    int delete(PreparedDelete<MessageRecord> preparedDelete) throws SQLException;

    int delete(MessageRecord messageRecord) throws SQLException;

    int delete(Collection<MessageRecord> collection) throws SQLException;

    DeleteBuilder<T, ID> deleteBuilder();

    int deleteById(ID id) throws SQLException;

    int deleteIds(Collection<ID> collection) throws SQLException;

    void endThreadConnection(DatabaseConnection databaseConnection) throws SQLException;

    int executeRaw(String str, String... strArr) throws SQLException;

    int executeRawNoArgs(String str) throws SQLException;

    ID extractId(T t) throws SQLException;

    FieldType findForeignFieldType(Class<?> cls);

    ConnectionSource getConnectionSource();

    Class<T> getDataClass();

    <FT> ForeignCollection<FT> getEmptyForeignCollection(String str) throws SQLException;

    ObjectCache getObjectCache();

    RawRowMapper<T> getRawRowMapper();

    GenericRowMapper<T> getSelectStarRowMapper() throws SQLException;

    String getTableName();

    CloseableWrappedIterable<T> getWrappedIterable();

    CloseableWrappedIterable<T> getWrappedIterable(PreparedQuery<T> preparedQuery);

    boolean idExists(ID id) throws SQLException;

    boolean isAutoCommit(DatabaseConnection databaseConnection) throws SQLException;

    boolean isTableExists() throws SQLException;

    boolean isUpdatable();

    CloseableIterator<T> iterator();

    CloseableIterator<T> iterator(int i);

    CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery) throws SQLException;

    CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery, int i) throws SQLException;

    T mapSelectStarRow(DatabaseResults databaseResults) throws SQLException;

    void notifyChanges();

    String objectToString(T t);

    boolean objectsEqual(T t, T t2) throws SQLException;

    List<T> query(PreparedQuery<T> preparedQuery) throws SQLException;

    QueryBuilder<T, ID> queryBuilder();

    List<T> queryForAll() throws SQLException;

    List<T> queryForEq(String str, Object obj) throws SQLException;

    List<T> queryForFieldValues(Map<String, Object> map) throws SQLException;

    List<T> queryForFieldValuesArgs(Map<String, Object> map) throws SQLException;

    T queryForFirst(PreparedQuery<T> preparedQuery) throws SQLException;

    T queryForId(ID id) throws SQLException;

    List<T> queryForMatching(T t) throws SQLException;

    List<T> queryForMatchingArgs(T t) throws SQLException;

    T queryForSameId(T t) throws SQLException;

    <UO> GenericRawResults<UO> queryRaw(String str, DatabaseResultsMapper<UO> databaseResultsMapper, String... strArr) throws SQLException;

    <UO> GenericRawResults<UO> queryRaw(String str, RawRowMapper<UO> rawRowMapper, String... strArr) throws SQLException;

    <UO> GenericRawResults<UO> queryRaw(String str, DataType[] dataTypeArr, RawRowObjectMapper<UO> rawRowObjectMapper, String... strArr) throws SQLException;

    GenericRawResults<Object[]> queryRaw(String str, DataType[] dataTypeArr, String... strArr) throws SQLException;

    GenericRawResults<String[]> queryRaw(String str, String... strArr) throws SQLException;

    long queryRawValue(String str, String... strArr) throws SQLException;

    int refresh(T t) throws SQLException;

    void registerObserver(DaoObserver daoObserver);

    void rollBack(DatabaseConnection databaseConnection) throws SQLException;

    void setAutoCommit(DatabaseConnection databaseConnection, boolean z) throws SQLException;

    void setObjectCache(ObjectCache objectCache) throws SQLException;

    void setObjectCache(boolean z) throws SQLException;

    void setObjectFactory(ObjectFactory<T> objectFactory);

    DatabaseConnection startThreadConnection() throws SQLException;

    void unregisterObserver(DaoObserver daoObserver);

    int update(PreparedUpdate<T> preparedUpdate) throws SQLException;

    int update(T t) throws SQLException;

    UpdateBuilder<T, ID> updateBuilder();

    int updateId(T t, ID id) throws SQLException;

    int updateRaw(String str, String... strArr) throws SQLException;

    public static class CreateOrUpdateStatus {
        private boolean created;
        private int numLinesChanged;
        private boolean updated;

        public CreateOrUpdateStatus(boolean z, boolean z2, int i) {
            this.created = z;
            this.updated = z2;
            this.numLinesChanged = i;
        }

        public boolean isCreated() {
            return this.created;
        }

        public boolean isUpdated() {
            return this.updated;
        }

        public int getNumLinesChanged() {
            return this.numLinesChanged;
        }
    }
}

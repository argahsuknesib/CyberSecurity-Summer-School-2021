package com.j256.ormlite.dao;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DaoManager {
    private static Map<ClassConnectionSource, Dao<?, ?>> classMap;
    private static Map<Class<?>, DatabaseTableConfig<?>> configMap;
    private static Logger logger = LoggerFactory.getLogger(DaoManager.class);
    private static Map<TableConfigConnectionSource, Dao<?, ?>> tableConfigMap;

    public static synchronized <D extends Dao<T, ?>, T> D createDao(ConnectionSource connectionSource, Class cls) throws SQLException {
        D d;
        D d2;
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                D lookupDao = lookupDao(new ClassConnectionSource(connectionSource, cls));
                if (lookupDao != null) {
                    return lookupDao;
                }
                D d3 = (Dao) createDaoFromConfig(connectionSource, cls);
                if (d3 != null) {
                    return d3;
                }
                DatabaseTable databaseTable = (DatabaseTable) cls.getAnnotation(DatabaseTable.class);
                if (!(databaseTable == null || databaseTable.daoClass() == Void.class)) {
                    if (databaseTable.daoClass() != BaseDaoImpl.class) {
                        Class<?> daoClass = databaseTable.daoClass();
                        Object[] objArr = {connectionSource, cls};
                        Constructor<?> findConstructor = findConstructor(daoClass, objArr);
                        if (findConstructor == null) {
                            objArr = new Object[]{connectionSource};
                            findConstructor = findConstructor(daoClass, objArr);
                            if (findConstructor == null) {
                                throw new SQLException("Could not find public constructor with ConnectionSource and optional Class parameters " + daoClass + ".  Missing static on class?");
                            }
                        }
                        try {
                            d = (Dao) findConstructor.newInstance(objArr);
                            logger.debug("created dao for class {} from constructor", cls);
                            registerDao(connectionSource, d);
                            return d;
                        } catch (Exception e) {
                            throw SqlExceptionUtil.create("Could not call the constructor in class ".concat(String.valueOf(daoClass)), e);
                        }
                    }
                }
                DatabaseTableConfig extractDatabaseTableConfig = connectionSource.getDatabaseType().extractDatabaseTableConfig(connectionSource, cls);
                if (extractDatabaseTableConfig == null) {
                    d2 = BaseDaoImpl.createDao(connectionSource, cls);
                } else {
                    d2 = BaseDaoImpl.createDao(connectionSource, extractDatabaseTableConfig);
                }
                d = d2;
                logger.debug("created dao for class {} with reflection", cls);
                registerDao(connectionSource, d);
                return d;
            }
            throw new IllegalArgumentException("connectionSource argument cannot be null");
        }
    }

    public static synchronized <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource connectionSource, Class<T> cls) {
        D lookupDao;
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                lookupDao = lookupDao(new ClassConnectionSource(connectionSource, cls));
            } else {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
        }
        return lookupDao;
    }

    public static synchronized <D extends Dao<T, ?>, T> D createDao(ConnectionSource connectionSource, DatabaseTableConfig databaseTableConfig) throws SQLException {
        D doCreateDao;
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                doCreateDao = doCreateDao(connectionSource, databaseTableConfig);
            } else {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
        }
        return doCreateDao;
    }

    public static synchronized <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) {
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                D lookupDao = lookupDao(new TableConfigConnectionSource(connectionSource, databaseTableConfig));
                if (lookupDao == null) {
                    return null;
                }
                return lookupDao;
            }
            throw new IllegalArgumentException("connectionSource argument cannot be null");
        }
    }

    public static synchronized void registerDao(ConnectionSource connectionSource, Dao<?, ?> dao) {
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                addDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
            } else {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
        }
    }

    public static synchronized void unregisterDao(ConnectionSource connectionSource, Dao<?, ?> dao) {
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                removeDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
            } else {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
        }
    }

    public static synchronized void registerDaoWithTableConfig(ConnectionSource connectionSource, Dao<?, ?> dao) {
        DatabaseTableConfig tableConfig;
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            } else if (!(dao instanceof BaseDaoImpl) || (tableConfig = ((BaseDaoImpl) dao).getTableConfig()) == null) {
                addDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
            } else {
                addDaoToTableMap(new TableConfigConnectionSource(connectionSource, tableConfig), dao);
            }
        }
    }

    public static synchronized void clearCache() {
        synchronized (DaoManager.class) {
            if (configMap != null) {
                configMap.clear();
                configMap = null;
            }
            clearDaoCache();
        }
    }

    public static synchronized void clearDaoCache() {
        synchronized (DaoManager.class) {
            if (classMap != null) {
                classMap.clear();
                classMap = null;
            }
            if (tableConfigMap != null) {
                tableConfigMap.clear();
                tableConfigMap = null;
            }
        }
    }

    public static synchronized void addCachedDatabaseConfigs(Collection<DatabaseTableConfig<?>> collection) {
        HashMap hashMap;
        synchronized (DaoManager.class) {
            if (configMap == null) {
                hashMap = new HashMap();
            } else {
                hashMap = new HashMap(configMap);
            }
            for (DatabaseTableConfig next : collection) {
                hashMap.put(next.getDataClass(), next);
                logger.info("Loaded configuration for {}", next.getDataClass());
            }
            configMap = hashMap;
        }
    }

    private static void addDaoToClassMap(ClassConnectionSource classConnectionSource, Dao<?, ?> dao) {
        if (classMap == null) {
            classMap = new HashMap();
        }
        classMap.put(classConnectionSource, dao);
    }

    private static void removeDaoToClassMap(ClassConnectionSource classConnectionSource, Dao<?, ?> dao) {
        Map<ClassConnectionSource, Dao<?, ?>> map = classMap;
        if (map != null) {
            map.remove(classConnectionSource);
        }
    }

    private static void addDaoToTableMap(TableConfigConnectionSource tableConfigConnectionSource, Dao<?, ?> dao) {
        if (tableConfigMap == null) {
            tableConfigMap = new HashMap();
        }
        tableConfigMap.put(tableConfigConnectionSource, dao);
    }

    private static <T> Dao<?, ?> lookupDao(ClassConnectionSource classConnectionSource) {
        if (classMap == null) {
            classMap = new HashMap();
        }
        Dao<?, ?> dao = classMap.get(classConnectionSource);
        if (dao == null) {
            return null;
        }
        return dao;
    }

    private static <T> Dao<?, ?> lookupDao(TableConfigConnectionSource tableConfigConnectionSource) {
        if (tableConfigMap == null) {
            tableConfigMap = new HashMap();
        }
        Dao<?, ?> dao = tableConfigMap.get(tableConfigConnectionSource);
        if (dao == null) {
            return null;
        }
        return dao;
    }

    private static Constructor<?> findConstructor(Class<?> cls, Object[] objArr) {
        boolean z;
        for (Constructor<?> constructor : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == objArr.length) {
                int i = 0;
                while (true) {
                    if (i >= parameterTypes.length) {
                        z = true;
                        break;
                    } else if (!parameterTypes[i].isAssignableFrom(objArr[i].getClass())) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return constructor;
                }
            }
        }
        return null;
    }

    private static <D, T> D createDaoFromConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        DatabaseTableConfig databaseTableConfig;
        Map<Class<?>, DatabaseTableConfig<?>> map = configMap;
        if (map == null || (databaseTableConfig = map.get(cls)) == null) {
            return null;
        }
        return doCreateDao(connectionSource, databaseTableConfig);
    }

    private static <D extends Dao<T, ?>, T> D doCreateDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        D d;
        TableConfigConnectionSource tableConfigConnectionSource = new TableConfigConnectionSource(connectionSource, databaseTableConfig);
        D lookupDao = lookupDao(tableConfigConnectionSource);
        if (lookupDao != null) {
            return lookupDao;
        }
        Class<T> dataClass = databaseTableConfig.getDataClass();
        ClassConnectionSource classConnectionSource = new ClassConnectionSource(connectionSource, dataClass);
        D lookupDao2 = lookupDao(classConnectionSource);
        if (lookupDao2 != null) {
            addDaoToTableMap(tableConfigConnectionSource, lookupDao2);
            return lookupDao2;
        }
        DatabaseTable databaseTable = (DatabaseTable) databaseTableConfig.getDataClass().getAnnotation(DatabaseTable.class);
        if (databaseTable == null || databaseTable.daoClass() == Void.class || databaseTable.daoClass() == BaseDaoImpl.class) {
            d = BaseDaoImpl.createDao(connectionSource, databaseTableConfig);
        } else {
            Class<?> daoClass = databaseTable.daoClass();
            Object[] objArr = {connectionSource, databaseTableConfig};
            Constructor<?> findConstructor = findConstructor(daoClass, objArr);
            if (findConstructor != null) {
                try {
                    d = (Dao) findConstructor.newInstance(objArr);
                } catch (Exception e) {
                    throw SqlExceptionUtil.create("Could not call the constructor in class ".concat(String.valueOf(daoClass)), e);
                }
            } else {
                throw new SQLException("Could not find public constructor with ConnectionSource, DatabaseTableConfig parameters in class ".concat(String.valueOf(daoClass)));
            }
        }
        addDaoToTableMap(tableConfigConnectionSource, d);
        logger.debug("created dao for class {} from table config", dataClass);
        if (lookupDao(classConnectionSource) == null) {
            addDaoToClassMap(classConnectionSource, d);
        }
        return d;
    }

    static class ClassConnectionSource {
        Class<?> clazz;
        ConnectionSource connectionSource;

        public ClassConnectionSource(ConnectionSource connectionSource2, Class<?> cls) {
            this.connectionSource = connectionSource2;
            this.clazz = cls;
        }

        public int hashCode() {
            return ((this.clazz.hashCode() + 31) * 31) + this.connectionSource.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClassConnectionSource classConnectionSource = (ClassConnectionSource) obj;
            if (this.clazz.equals(classConnectionSource.clazz) && this.connectionSource.equals(classConnectionSource.connectionSource)) {
                return true;
            }
            return false;
        }
    }

    static class TableConfigConnectionSource {
        ConnectionSource connectionSource;
        DatabaseTableConfig<?> tableConfig;

        public TableConfigConnectionSource(ConnectionSource connectionSource2, DatabaseTableConfig<?> databaseTableConfig) {
            this.connectionSource = connectionSource2;
            this.tableConfig = databaseTableConfig;
        }

        public int hashCode() {
            return ((this.tableConfig.hashCode() + 31) * 31) + this.connectionSource.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TableConfigConnectionSource tableConfigConnectionSource = (TableConfigConnectionSource) obj;
            if (this.tableConfig.equals(tableConfigConnectionSource.tableConfig) && this.connectionSource.equals(tableConfigConnectionSource.connectionSource)) {
                return true;
            }
            return false;
        }
    }
}

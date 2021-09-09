package com.j256.ormlite.support;

import com.j256.ormlite.misc.SqlExceptionUtil;
import java.lang.reflect.Constructor;
import java.sql.SQLException;

public class ReflectionDatabaseConnectionProxyFactory implements DatabaseConnectionProxyFactory {
    private final Constructor<? extends DatabaseConnection> constructor;
    private final Class<? extends DatabaseConnection> proxyClass;

    public ReflectionDatabaseConnectionProxyFactory(Class<? extends DatabaseConnection> cls) throws IllegalArgumentException {
        this.proxyClass = cls;
        try {
            this.constructor = cls.getConstructor(DatabaseConnection.class);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Could not find constructor with DatabaseConnection argument in ".concat(String.valueOf(cls)));
        }
    }

    public DatabaseConnection createProxy(DatabaseConnection databaseConnection) throws SQLException {
        try {
            return (DatabaseConnection) this.constructor.newInstance(databaseConnection);
        } catch (Exception e) {
            throw SqlExceptionUtil.create("Could not create a new instance of " + this.proxyClass, e);
        }
    }
}

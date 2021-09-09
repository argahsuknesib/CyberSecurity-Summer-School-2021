package com.j256.ormlite.support;

import java.sql.SQLException;

public interface DatabaseConnectionProxyFactory {
    DatabaseConnection createProxy(DatabaseConnection databaseConnection) throws SQLException;
}

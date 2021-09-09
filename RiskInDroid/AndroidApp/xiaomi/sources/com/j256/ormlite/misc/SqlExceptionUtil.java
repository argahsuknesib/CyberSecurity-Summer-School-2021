package com.j256.ormlite.misc;

import java.sql.SQLException;

public class SqlExceptionUtil {
    private SqlExceptionUtil() {
    }

    public static SQLException create(String str, Throwable th) {
        SQLException sQLException;
        if (th instanceof SQLException) {
            sQLException = new SQLException(str, ((SQLException) th).getSQLState());
        } else {
            sQLException = new SQLException(str);
        }
        sQLException.initCause(th);
        return sQLException;
    }
}

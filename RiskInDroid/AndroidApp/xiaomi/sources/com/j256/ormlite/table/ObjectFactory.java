package com.j256.ormlite.table;

import java.lang.reflect.Constructor;
import java.sql.SQLException;

public interface ObjectFactory<T> {
    T createObject(Constructor<T> constructor, Class<T> cls) throws SQLException;
}

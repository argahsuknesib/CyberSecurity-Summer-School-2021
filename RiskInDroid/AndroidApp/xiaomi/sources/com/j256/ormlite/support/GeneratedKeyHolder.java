package com.j256.ormlite.support;

import java.sql.SQLException;

public interface GeneratedKeyHolder {
    void addKey(Number number) throws SQLException;
}

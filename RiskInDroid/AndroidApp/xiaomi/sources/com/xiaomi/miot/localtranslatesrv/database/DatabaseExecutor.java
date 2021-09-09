package com.xiaomi.miot.localtranslatesrv.database;

import com.xiaomi.miot.localtranslatesrv.core.metaDatas.TranslateConfig;
import java.sql.SQLException;

public interface DatabaseExecutor {
    String getSpecTypeByModel(String str) throws SQLException;

    boolean hasTargetModel(String str) throws SQLException;

    boolean hasTranslateRule(String str) throws SQLException;

    TranslateConfig queryTranslateConfig(String str) throws SQLException;
}

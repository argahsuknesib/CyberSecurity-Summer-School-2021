package com.j256.ormlite.android.apptools;

import android.content.Context;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class OrmLitePreparedQueryLoader<T, ID> extends BaseOrmLiteLoader<T, ID> {
    private PreparedQuery<T> preparedQuery;

    public OrmLitePreparedQueryLoader(Context context) {
        super(context);
    }

    public OrmLitePreparedQueryLoader(Context context, Dao<T, ID> dao, PreparedQuery<T> preparedQuery2) {
        super(context, dao);
        this.preparedQuery = preparedQuery2;
    }

    public List<T> loadInBackground() {
        if (this.dao == null) {
            throw new IllegalStateException("Dao is not initialized.");
        } else if (this.preparedQuery != null) {
            try {
                return this.dao.query(this.preparedQuery);
            } catch (SQLException e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
        } else {
            throw new IllegalStateException("PreparedQuery is not initialized.");
        }
    }

    public void setPreparedQuery(PreparedQuery<T> preparedQuery2) {
        this.preparedQuery = preparedQuery2;
    }

    public PreparedQuery<T> getPreparedQuery() {
        return this.preparedQuery;
    }
}

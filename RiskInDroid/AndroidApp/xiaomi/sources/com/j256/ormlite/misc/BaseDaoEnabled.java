package com.j256.ormlite.misc;

import com.j256.ormlite.dao.Dao;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import java.sql.SQLException;

public abstract class BaseDaoEnabled<T, ID> {
    protected transient Dao<T, ID> dao;

    public int create() throws SQLException {
        checkForDao();
        return this.dao.create((MessageRecord) this);
    }

    public int refresh() throws SQLException {
        checkForDao();
        return this.dao.refresh(this);
    }

    public int update() throws SQLException {
        checkForDao();
        return this.dao.update(this);
    }

    public int updateId(ID id) throws SQLException {
        checkForDao();
        return this.dao.updateId(this, id);
    }

    public int delete() throws SQLException {
        checkForDao();
        return this.dao.delete((MessageRecord) this);
    }

    public String objectToString() {
        try {
            checkForDao();
            return this.dao.objectToString(this);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ID extractId() throws SQLException {
        checkForDao();
        return this.dao.extractId(this);
    }

    public boolean objectsEqual(T t) throws SQLException {
        checkForDao();
        return this.dao.objectsEqual(this, t);
    }

    public void setDao(Dao<T, ID> dao2) {
        this.dao = dao2;
    }

    public Dao<T, ID> getDao() {
        return this.dao;
    }

    private void checkForDao() throws SQLException {
        if (this.dao == null) {
            throw new SQLException("Dao has not been set on " + getClass() + " object: " + this);
        }
    }
}

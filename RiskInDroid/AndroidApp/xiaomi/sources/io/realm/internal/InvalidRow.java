package io.realm.internal;

import _m_j.isi;
import io.realm.RealmFieldType;
import java.util.Date;

public enum InvalidRow implements isi {
    INSTANCE;

    public final boolean isAttached() {
        return false;
    }

    public final long getColumnCount() {
        throw getStubException();
    }

    public final String getColumnName(long j) {
        throw getStubException();
    }

    public final long getColumnIndex(String str) {
        throw getStubException();
    }

    public final RealmFieldType getColumnType(long j) {
        throw getStubException();
    }

    public final Table getTable() {
        throw getStubException();
    }

    public final long getIndex() {
        throw getStubException();
    }

    public final long getLong(long j) {
        throw getStubException();
    }

    public final boolean getBoolean(long j) {
        throw getStubException();
    }

    public final float getFloat(long j) {
        throw getStubException();
    }

    public final double getDouble(long j) {
        throw getStubException();
    }

    public final Date getDate(long j) {
        throw getStubException();
    }

    public final String getString(long j) {
        throw getStubException();
    }

    public final byte[] getBinaryByteArray(long j) {
        throw getStubException();
    }

    public final long getLink(long j) {
        throw getStubException();
    }

    public final boolean isNullLink(long j) {
        throw getStubException();
    }

    public final OsList getModelList(long j) {
        throw getStubException();
    }

    public final OsList getValueList(long j, RealmFieldType realmFieldType) {
        throw getStubException();
    }

    public final void setLong(long j, long j2) {
        throw getStubException();
    }

    public final void setBoolean(long j, boolean z) {
        throw getStubException();
    }

    public final void setFloat(long j, float f) {
        throw getStubException();
    }

    public final void setDouble(long j, double d) {
        throw getStubException();
    }

    public final void setDate(long j, Date date) {
        throw getStubException();
    }

    public final void setString(long j, String str) {
        throw getStubException();
    }

    public final void setBinaryByteArray(long j, byte[] bArr) {
        throw getStubException();
    }

    public final void setLink(long j, long j2) {
        throw getStubException();
    }

    public final void nullifyLink(long j) {
        throw getStubException();
    }

    public final boolean isNull(long j) {
        throw getStubException();
    }

    public final void setNull(long j) {
        throw getStubException();
    }

    public final void checkIfAttached() {
        throw getStubException();
    }

    public final boolean hasColumn(String str) {
        throw getStubException();
    }

    private RuntimeException getStubException() {
        return new IllegalStateException("Object is no longer managed by Realm. Has it been deleted?");
    }
}

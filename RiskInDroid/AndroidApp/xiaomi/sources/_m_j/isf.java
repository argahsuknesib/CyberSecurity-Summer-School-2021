package _m_j;

import io.realm.RealmFieldType;
import io.realm.internal.OsList;
import io.realm.internal.OsResults;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.Table;
import java.lang.ref.WeakReference;
import java.util.Date;

public final class isf implements isi {

    /* renamed from: O000000o  reason: collision with root package name */
    public OsResults f1602O000000o;
    public WeakReference<O000000o> O00000Oo;
    private OsSharedRealm O00000o;
    public boolean O00000o0;
    private iro<isf> O00000oO;

    public interface O000000o {
        void O000000o(isi isi);
    }

    public final boolean isAttached() {
        return false;
    }

    public final long getColumnCount() {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final String getColumnName(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final long getColumnIndex(String str) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final RealmFieldType getColumnType(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final Table getTable() {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final long getIndex() {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final long getLong(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final boolean getBoolean(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final float getFloat(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final double getDouble(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final Date getDate(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final String getString(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final byte[] getBinaryByteArray(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final boolean isNullLink(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final OsList getModelList(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final OsList getValueList(long j, RealmFieldType realmFieldType) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final boolean isNull(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public final void O000000o() {
        this.f1602O000000o.O000000o(this, this.O00000oO);
        this.f1602O000000o = null;
        this.O00000oO = null;
        this.O00000o.removePendingRow(this);
    }
}

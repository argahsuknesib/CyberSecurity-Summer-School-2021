package _m_j;

import io.realm.RealmFieldType;
import io.realm.internal.OsList;
import io.realm.internal.Table;
import java.util.Date;

public interface isi {
    byte[] getBinaryByteArray(long j);

    boolean getBoolean(long j);

    long getColumnCount();

    long getColumnIndex(String str);

    String getColumnName(long j);

    RealmFieldType getColumnType(long j);

    Date getDate(long j);

    double getDouble(long j);

    float getFloat(long j);

    long getIndex();

    long getLong(long j);

    OsList getModelList(long j);

    String getString(long j);

    Table getTable();

    OsList getValueList(long j, RealmFieldType realmFieldType);

    boolean isAttached();

    boolean isNull(long j);

    boolean isNullLink(long j);
}

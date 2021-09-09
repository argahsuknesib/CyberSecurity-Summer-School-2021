package _m_j;

import android.database.Cursor;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public final class bpe implements bph<byte[]> {
    public final /* bridge */ /* synthetic */ Object O000000o(Object obj) {
        return (byte[]) obj;
    }

    public final /* bridge */ /* synthetic */ Object O000000o(String str) {
        return null;
    }

    public final ColumnDbType O000000o() {
        return ColumnDbType.BLOB;
    }

    public final /* synthetic */ Object O000000o(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getBlob(i);
    }
}

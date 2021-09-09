package _m_j;

import android.database.Cursor;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public final class bpq implements bph<String> {
    public final /* bridge */ /* synthetic */ Object O000000o(Object obj) {
        return (String) obj;
    }

    public final /* bridge */ /* synthetic */ Object O000000o(String str) {
        return str;
    }

    public final ColumnDbType O000000o() {
        return ColumnDbType.TEXT;
    }

    public final /* synthetic */ Object O000000o(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getString(i);
    }
}

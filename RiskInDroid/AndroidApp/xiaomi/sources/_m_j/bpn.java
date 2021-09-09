package _m_j;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public final class bpn implements bph<Long> {
    public final /* bridge */ /* synthetic */ Object O000000o(Object obj) {
        return (Long) obj;
    }

    public final ColumnDbType O000000o() {
        return ColumnDbType.INTEGER;
    }

    public final /* synthetic */ Object O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Long.valueOf(str);
    }

    public final /* synthetic */ Object O000000o(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i));
    }
}

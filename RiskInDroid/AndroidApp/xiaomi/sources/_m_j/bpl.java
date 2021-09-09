package _m_j;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public final class bpl implements bph<Float> {
    public final /* bridge */ /* synthetic */ Object O000000o(Object obj) {
        return (Float) obj;
    }

    public final ColumnDbType O000000o() {
        return ColumnDbType.REAL;
    }

    public final /* synthetic */ Object O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Float.valueOf(str);
    }

    public final /* synthetic */ Object O000000o(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i));
    }
}

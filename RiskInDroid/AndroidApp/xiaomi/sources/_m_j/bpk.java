package _m_j;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public final class bpk implements bph<Double> {
    public final /* bridge */ /* synthetic */ Object O000000o(Object obj) {
        return (Double) obj;
    }

    public final ColumnDbType O000000o() {
        return ColumnDbType.REAL;
    }

    public final /* synthetic */ Object O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Double.valueOf(str);
    }

    public final /* synthetic */ Object O000000o(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i));
    }
}

package _m_j;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import java.util.Date;

public final class bpj implements bph<Date> {
    public final /* synthetic */ Object O000000o(Object obj) {
        Date date = (Date) obj;
        if (date == null) {
            return null;
        }
        return Long.valueOf(date.getTime());
    }

    public final ColumnDbType O000000o() {
        return ColumnDbType.INTEGER;
    }

    public final /* synthetic */ Object O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new Date(Long.valueOf(str).longValue());
    }

    public final /* synthetic */ Object O000000o(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return new Date(cursor.getLong(i));
    }
}

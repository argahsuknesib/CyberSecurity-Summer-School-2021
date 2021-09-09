package _m_j;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public final class bpd implements bph<Boolean> {
    public final /* synthetic */ Object O000000o(Object obj) {
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            return null;
        }
        return Integer.valueOf(bool.booleanValue() ? 1 : 0);
    }

    public final ColumnDbType O000000o() {
        return ColumnDbType.INTEGER;
    }

    public final /* synthetic */ Object O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Boolean.valueOf(str.length() == 1 ? "1".equals(str) : Boolean.valueOf(str).booleanValue());
    }

    public final /* synthetic */ Object O000000o(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        int i2 = cursor.getInt(i);
        boolean z = true;
        if (i2 != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}

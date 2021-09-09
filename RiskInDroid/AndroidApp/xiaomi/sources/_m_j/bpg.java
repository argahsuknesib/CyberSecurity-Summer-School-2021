package _m_j;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public final class bpg implements bph<Character> {
    public final /* synthetic */ Object O000000o(Object obj) {
        Character ch = (Character) obj;
        if (ch == null) {
            return null;
        }
        return Integer.valueOf(ch.charValue());
    }

    public final ColumnDbType O000000o() {
        return ColumnDbType.INTEGER;
    }

    public final /* synthetic */ Object O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    public final /* synthetic */ Object O000000o(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Character.valueOf((char) cursor.getInt(i));
    }
}

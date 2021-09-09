package _m_j;

import _m_j.end;
import android.content.Context;
import android.database.Cursor;
import java.util.List;

public final class emy extends end.O00000Oo<Long> {

    /* renamed from: O000000o  reason: collision with root package name */
    private long f15639O000000o = 0;
    private String O00000oo;

    public emy(String str, List<String> list, String str2) {
        super(str, list, null, null, null, null, null, 0);
        this.O00000oo = str2;
    }

    public final Object O000000o() {
        return Long.valueOf(this.f15639O000000o);
    }

    public final void O000000o(Context context, List<Long> list) {
        if (context != null && list != null && list.size() > 0) {
            this.f15639O000000o = list.get(0).longValue();
        }
    }

    public final /* synthetic */ Object O000000o(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }
}

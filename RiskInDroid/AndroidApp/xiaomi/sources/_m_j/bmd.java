package _m_j;

import _m_j.bls;
import android.database.Cursor;
import com.ishumei.O000O00000OoO.O000O00000OoO.O0000O000000oO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bmd {

    /* renamed from: O000000o  reason: collision with root package name */
    O0000O000000oO f13092O000000o = bls.O000000o.f13076O000000o.f13075O000000o;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f13093O000000o;
        String O00000Oo;
        String O00000o0;

        public O000000o(int i, String str, String str2) {
            this.f13093O000000o = i;
            this.O00000Oo = str;
            this.O00000o0 = str2;
        }
    }

    public final List<O000000o> O000000o() {
        Cursor O000000o2 = this.f13092O000000o.O000000o("upload_checker", new StringBuilder("2").toString());
        if (O000000o2 == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (O000000o2.moveToNext()) {
            arrayList.add(new O000000o(O000000o2.getInt(0), O000000o2.getString(1), O000000o2.getString(2)));
        }
        try {
            O000000o2.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final void O000000o(int i) {
        this.f13092O000000o.O000000o("upload_checker", "id = ?", new String[]{String.valueOf(i)});
    }
}

package _m_j;

import _m_j.iry;
import _m_j.iso;
import io.realm.RealmFieldType;
import java.util.List;
import java.util.Locale;
import java.util.Set;

final class ism extends iso {
    private final iso.O000000o O0000OOo;
    private final String O0000Oo0;

    ism(iso.O000000o o000000o, String str, String str2, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        super(str2, set, null);
        this.O0000Oo0 = str;
        this.O0000OOo = o000000o;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(List<String> list) {
        long j;
        int size = list.size();
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        String str = null;
        RealmFieldType realmFieldType = null;
        String str2 = this.O0000Oo0;
        int i = 0;
        while (i < size) {
            str = list.get(i);
            if (str == null || str.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            iry O00000Oo = this.O0000OOo.O00000Oo();
            if (O00000Oo != null) {
                iry.O000000o o000000o = O00000Oo.f1594O000000o.get(str);
                if (o000000o != null) {
                    RealmFieldType realmFieldType2 = o000000o.O00000Oo;
                    if (i < size - 1) {
                        O000000o(str2, str, realmFieldType2);
                        str2 = o000000o.O00000o0;
                    }
                    jArr[i] = o000000o.f1595O000000o;
                    if (realmFieldType2 != RealmFieldType.LINKING_OBJECTS) {
                        j = 0;
                    } else {
                        j = this.O0000OOo.O00000o0();
                    }
                    jArr2[i] = j;
                    i++;
                    realmFieldType = realmFieldType2;
                } else {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in class '%s'.", str, str2));
                }
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: class '%s' not found in this schema.", str2));
            }
        }
        O000000o(str2, str, realmFieldType, jArr, jArr2);
    }
}

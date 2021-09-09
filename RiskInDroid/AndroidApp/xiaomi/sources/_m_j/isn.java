package _m_j;

import io.realm.RealmFieldType;
import io.realm.internal.Table;
import java.util.List;
import java.util.Locale;
import java.util.Set;

final class isn extends iso {
    private final Table O0000OOo;

    isn(Table table, String str, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        super(str, set, null);
        this.O0000OOo = table;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(List<String> list) {
        int size = list.size();
        long[] jArr = new long[size];
        String str = null;
        Table table = this.O0000OOo;
        String str2 = null;
        RealmFieldType realmFieldType = null;
        int i = 0;
        while (i < size) {
            str2 = list.get(i);
            if (str2 == null || str2.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            str = Table.O00000Oo(table.O000000o());
            long O000000o2 = table.O000000o(str2);
            if (O000000o2 >= 0) {
                realmFieldType = table.O00000Oo(O000000o2);
                if (i < size - 1) {
                    O000000o(str, str2, realmFieldType);
                    table = table.O00000o0(O000000o2);
                }
                jArr[i] = O000000o2;
                i++;
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in table '%s'.", str2, str));
            }
        }
        O000000o(str, str2, realmFieldType, jArr, new long[size]);
    }
}

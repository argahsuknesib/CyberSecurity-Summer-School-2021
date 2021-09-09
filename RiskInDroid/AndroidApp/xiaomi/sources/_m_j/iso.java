package _m_j;

import io.realm.RealmFieldType;
import io.realm.internal.Table;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public abstract class iso {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Set<RealmFieldType> f1606O000000o;
    public static final Set<RealmFieldType> O00000Oo;
    public static final Set<RealmFieldType> O00000o;
    public static final Set<RealmFieldType> O00000o0;
    public static final Set<RealmFieldType> O00000oO = Collections.emptySet();
    public String O00000oo;
    public long[] O0000O0o;
    private final List<String> O0000OOo;
    private final Set<RealmFieldType> O0000Oo;
    private final Set<RealmFieldType> O0000Oo0;
    private RealmFieldType O0000OoO;
    private long[] O0000Ooo;

    public interface O000000o {
        boolean O000000o();

        iry O00000Oo();

        long O00000o0();
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o(List<String> list);

    static {
        HashSet hashSet = new HashSet(3);
        hashSet.add(RealmFieldType.OBJECT);
        hashSet.add(RealmFieldType.LIST);
        hashSet.add(RealmFieldType.LINKING_OBJECTS);
        f1606O000000o = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(RealmFieldType.OBJECT);
        hashSet2.add(RealmFieldType.LIST);
        O00000Oo = Collections.unmodifiableSet(hashSet2);
        HashSet hashSet3 = new HashSet(1);
        hashSet3.add(RealmFieldType.LIST);
        O00000o0 = Collections.unmodifiableSet(hashSet3);
        HashSet hashSet4 = new HashSet(1);
        hashSet4.add(RealmFieldType.OBJECT);
        O00000o = Collections.unmodifiableSet(hashSet4);
    }

    public static iso O000000o(O000000o o000000o, Table table, String str, Set<RealmFieldType> set) {
        if (o000000o == null || !o000000o.O000000o()) {
            if (set == null) {
                set = O00000Oo;
            }
            return new isn(table, str, set, null);
        }
        String O00000Oo2 = Table.O00000Oo(table.O000000o());
        if (set == null) {
            set = f1606O000000o;
        }
        return new ism(o000000o, O00000Oo2, str, set, null);
    }

    protected iso(String str, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Invalid query: field name is empty");
        } else if (!str.endsWith(".")) {
            this.O0000OOo = Arrays.asList(str.split("\\."));
            if (this.O0000OOo.size() > 0) {
                this.O0000Oo0 = set;
                this.O0000Oo = set2;
                return;
            }
            throw new IllegalArgumentException("Invalid query: Empty field descriptor");
        } else {
            throw new IllegalArgumentException("Invalid query: field name must not end with a period ('.')");
        }
    }

    public final RealmFieldType O000000o() {
        O00000Oo();
        return this.O0000OoO;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String str, String str2, RealmFieldType realmFieldType) {
        O000000o(str, str2, realmFieldType, this.O0000Oo0);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String str, String str2, RealmFieldType realmFieldType, long[] jArr, long[] jArr2) {
        Set<RealmFieldType> set = this.O0000Oo;
        if (set != null && set.size() > 0) {
            O000000o(str, str2, realmFieldType, this.O0000Oo);
        }
        this.O00000oo = str2;
        this.O0000OoO = realmFieldType;
        this.O0000O0o = jArr;
        this.O0000Ooo = jArr2;
    }

    private static void O000000o(String str, String str2, RealmFieldType realmFieldType, Set<RealmFieldType> set) {
        if (!set.contains(realmFieldType)) {
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' in class '%s' is of invalid type '%s'.", str2, str, realmFieldType.toString()));
        }
    }

    public final void O00000Oo() {
        if (this.O0000OoO == null) {
            O000000o(this.O0000OOo);
        }
    }
}

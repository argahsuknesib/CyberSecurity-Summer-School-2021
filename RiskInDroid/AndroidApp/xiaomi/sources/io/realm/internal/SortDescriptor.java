package io.realm.internal;

import _m_j.iso;
import io.realm.RealmFieldType;
import io.realm.Sort;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Keep
public class SortDescriptor {
    static final Set<RealmFieldType> DISTINCT_VALID_FIELD_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(RealmFieldType.BOOLEAN, RealmFieldType.INTEGER, RealmFieldType.STRING, RealmFieldType.DATE)));
    static final Set<RealmFieldType> SORT_VALID_FIELD_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(RealmFieldType.BOOLEAN, RealmFieldType.INTEGER, RealmFieldType.FLOAT, RealmFieldType.DOUBLE, RealmFieldType.STRING, RealmFieldType.DATE)));
    private final boolean[] ascendings;
    private final long[][] columnIndices;
    private final Table table;

    public static SortDescriptor getInstanceForSort(iso.O000000o o000000o, Table table2, String str, Sort sort) {
        return getInstanceForSort(o000000o, table2, new String[]{str}, new Sort[]{sort});
    }

    public static SortDescriptor getInstanceForSort(iso.O000000o o000000o, Table table2, String[] strArr, Sort[] sortArr) {
        if (sortArr == null || sortArr.length == 0) {
            throw new IllegalArgumentException("You must provide at least one sort order.");
        } else if (strArr.length == sortArr.length) {
            return getInstance(o000000o, table2, strArr, sortArr, iso.O00000o, SORT_VALID_FIELD_TYPES, "Sort is not supported");
        } else {
            throw new IllegalArgumentException("Number of fields and sort orders do not match.");
        }
    }

    public static SortDescriptor getInstanceForDistinct(iso.O000000o o000000o, Table table2, String str) {
        return getInstanceForDistinct(o000000o, table2, new String[]{str});
    }

    public static SortDescriptor getInstanceForDistinct(iso.O000000o o000000o, Table table2, String[] strArr) {
        return getInstance(o000000o, table2, strArr, null, iso.O00000oO, DISTINCT_VALID_FIELD_TYPES, "Distinct is not supported");
    }

    private static SortDescriptor getInstance(iso.O000000o o000000o, Table table2, String[] strArr, Sort[] sortArr, Set<RealmFieldType> set, Set<RealmFieldType> set2, String str) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("You must provide at least one field name.");
        }
        long[][] jArr = new long[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            iso O000000o2 = iso.O000000o(o000000o, table2, strArr[i], set);
            checkFieldType(O000000o2, set2, str, strArr[i]);
            O000000o2.O00000Oo();
            jArr[i] = Arrays.copyOf(O000000o2.O0000O0o, O000000o2.O0000O0o.length);
        }
        return new SortDescriptor(table2, jArr, sortArr);
    }

    static SortDescriptor getTestInstance(Table table2, long[] jArr) {
        return new SortDescriptor(table2, new long[][]{jArr}, null);
    }

    private static void checkFieldType(iso iso, Set<RealmFieldType> set, String str, String str2) {
        if (!set.contains(iso.O000000o())) {
            Locale locale = Locale.US;
            iso.O00000Oo();
            throw new IllegalArgumentException(String.format(locale, "%s on '%s' field '%s' in '%s'.", str, iso.O000000o(), iso.O00000oo, str2));
        }
    }

    private SortDescriptor(Table table2, long[][] jArr, Sort[] sortArr) {
        this.table = table2;
        this.columnIndices = jArr;
        if (sortArr != null) {
            this.ascendings = new boolean[sortArr.length];
            for (int i = 0; i < sortArr.length; i++) {
                this.ascendings[i] = sortArr[i].getValue();
            }
            return;
        }
        this.ascendings = null;
    }

    /* access modifiers changed from: package-private */
    public long[][] getColumnIndices() {
        return this.columnIndices;
    }

    /* access modifiers changed from: package-private */
    public boolean[] getAscendings() {
        return this.ascendings;
    }

    private long getTablePtr() {
        return this.table.getNativePtr();
    }
}

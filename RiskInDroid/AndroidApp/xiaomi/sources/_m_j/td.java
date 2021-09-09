package _m_j;

public final class td {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String[] f2492O000000o = {"ID", "type", "value", "time", "size"};

    public static String O000000o(String str) {
        return "create table if not exists " + str + " (ID integer PRIMARY KEY AUTOINCREMENT NOT NULL, type integer, value blob, time long, size integer);";
    }
}

package _m_j;

import android.database.Cursor;

interface ipb {
    boolean O000000o() throws Throwable;

    public static class O000000o {
        public static void O000000o(Cursor cursor) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int type = cursor.getType(0);
                if (type != 0 && type != 4) {
                    cursor.getString(0);
                }
            }
        }
    }
}

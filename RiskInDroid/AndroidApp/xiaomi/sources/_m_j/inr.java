package _m_j;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.provider.ContactsContract;

final class inr implements inv {

    /* renamed from: O000000o  reason: collision with root package name */
    private ContentResolver f1504O000000o;

    inr(ContentResolver contentResolver) {
        this.f1504O000000o = contentResolver;
    }

    public final boolean O000000o() throws Throwable {
        Cursor query = this.f1504O000000o.query(ContactsContract.Data.CONTENT_URI, new String[]{"raw_contact_id"}, "mimetype=? and data1=?", new String[]{"vnd.android.cursor.item/name", "PERMISSION"}, null);
        if (query != null) {
            if (query.moveToFirst()) {
                long j = query.getLong(0);
                query.close();
                ContentValues contentValues = new ContentValues();
                contentValues.put("raw_contact_id", Long.valueOf(j));
                contentValues.put("data1", "PERMISSION");
                contentValues.put("data2", "PERMISSION");
                contentValues.put("mimetype", "vnd.android.cursor.item/name");
                if (ContentUris.parseId(this.f1504O000000o.insert(ContactsContract.Data.CONTENT_URI, contentValues)) > 0) {
                    return true;
                }
                return false;
            }
            query.close();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("raw_contact_id", Long.valueOf(ContentUris.parseId(this.f1504O000000o.insert(ContactsContract.RawContacts.CONTENT_URI, contentValues2))));
            contentValues2.put("data1", "PERMISSION");
            contentValues2.put("data2", "PERMISSION");
            contentValues2.put("mimetype", "vnd.android.cursor.item/name");
            if (ContentUris.parseId(this.f1504O000000o.insert(ContactsContract.Data.CONTENT_URI, contentValues2)) > 0) {
                return true;
            }
        }
        return false;
    }
}

package _m_j;

import _m_j.ipb;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

final class iov implements ipb {

    /* renamed from: O000000o  reason: collision with root package name */
    private ContentResolver f1525O000000o;

    iov(Context context) {
        this.f1525O000000o = context.getContentResolver();
    }

    /* JADX INFO: finally extract failed */
    public final boolean O000000o() throws Throwable {
        Cursor query = this.f1525O000000o.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"_id", "data1"}, null, null, null);
        if (query == null) {
            return false;
        }
        try {
            ipb.O000000o.O000000o(query);
            query.close();
            return true;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }
}

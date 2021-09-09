package _m_j;

import _m_j.inv;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.Telephony;

final class ioa implements inv {

    /* renamed from: O000000o  reason: collision with root package name */
    private ContentResolver f1512O000000o;

    ioa(Context context) {
        this.f1512O000000o = context.getContentResolver();
    }

    /* JADX INFO: finally extract failed */
    public final boolean O000000o() throws Throwable {
        Cursor query = this.f1512O000000o.query(Telephony.Sms.CONTENT_URI, new String[]{"_id", "address", "person", "body"}, null, null, null);
        if (query == null) {
            return false;
        }
        try {
            inv.O000000o.O000000o(query);
            query.close();
            return true;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }
}

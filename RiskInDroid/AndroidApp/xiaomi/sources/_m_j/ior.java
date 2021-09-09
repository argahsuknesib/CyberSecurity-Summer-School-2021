package _m_j;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CalendarContract;
import java.util.TimeZone;

final class ior implements ipb {

    /* renamed from: O000000o  reason: collision with root package name */
    private ContentResolver f1521O000000o;

    ior(Context context) {
        this.f1521O000000o = context.getContentResolver();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    public final boolean O000000o() throws Throwable {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", "PERMISSION");
            contentValues.put("account_name", "permission@gmail.com");
            contentValues.put("account_type", "LOCAL");
            contentValues.put("calendar_displayName", "PERMISSION");
            contentValues.put("visible", (Integer) 1);
            contentValues.put("calendar_color", (Integer) -16776961);
            contentValues.put("calendar_access_level", (Integer) 700);
            contentValues.put("sync_events", (Integer) 1);
            contentValues.put("calendar_timezone", timeZone.getID());
            contentValues.put("ownerAccount", "PERMISSION");
            boolean z = false;
            contentValues.put("canOrganizerRespond", (Integer) 0);
            if (ContentUris.parseId(this.f1521O000000o.insert(CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", "PERMISSION").appendQueryParameter("account_type", "LOCAL").build(), contentValues)) > 0) {
                z = true;
            }
            return z;
        } finally {
            this.f1521O000000o.delete(CalendarContract.Calendars.CONTENT_URI.buildUpon().build(), "account_name=?", new String[]{"permission@gmail.com"});
        }
    }
}

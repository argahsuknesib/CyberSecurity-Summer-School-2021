package _m_j;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CallLog;

final class iot implements ipb {

    /* renamed from: O000000o  reason: collision with root package name */
    private ContentResolver f1523O000000o;

    iot(Context context) {
        this.f1523O000000o = context.getContentResolver();
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
            ContentValues contentValues = new ContentValues();
            boolean z = true;
            contentValues.put("type", (Integer) 1);
            contentValues.put("number", "1");
            contentValues.put("date", (Integer) 20080808);
            contentValues.put("new", "0");
            if (ContentUris.parseId(this.f1523O000000o.insert(CallLog.Calls.CONTENT_URI, contentValues)) <= 0) {
                z = false;
            }
            return z;
        } finally {
            this.f1523O000000o.delete(CallLog.Calls.CONTENT_URI, "number=?", new String[]{"1"});
        }
    }
}

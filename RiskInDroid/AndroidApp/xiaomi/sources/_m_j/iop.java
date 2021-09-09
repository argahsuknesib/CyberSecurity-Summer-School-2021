package _m_j;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.VoicemailContract;
import android.text.TextUtils;

final class iop implements ipb {

    /* renamed from: O000000o  reason: collision with root package name */
    private ContentResolver f1519O000000o;

    iop(Context context) {
        this.f1519O000000o = context.getContentResolver();
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
            Uri uri = VoicemailContract.Voicemails.CONTENT_URI;
            ContentValues contentValues = new ContentValues();
            contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("number", "1");
            contentValues.put("duration", (Integer) 1);
            contentValues.put("source_package", "permission");
            contentValues.put("source_data", "permission");
            contentValues.put("is_read", (Integer) 0);
            return this.f1519O000000o.delete(uri, "_id=?", new String[]{Long.toString(ContentUris.parseId(this.f1519O000000o.insert(uri, contentValues)))}) > 0;
        } catch (Exception e) {
            String message = e.getMessage();
            return !TextUtils.isEmpty(message) && !message.toLowerCase().contains("add_voicemail");
        }
    }
}

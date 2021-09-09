package com.xiaomi.smarthome.download;

import _m_j.frm;
import _m_j.gsy;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.io.File;

public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    frm f7309O000000o = null;

    public void onReceive(Context context, Intent intent) {
        Intent intent2;
        String string;
        if (this.f7309O000000o == null) {
            this.f7309O000000o = new RealSystemFacade(context);
        }
        String action = intent.getAction();
        gsy.O000000o(2, "DownloadManager", "action: ".concat(String.valueOf(action)));
        if (action.equals("local_wifi_connected")) {
            O000000o(context);
        } else if (action.equals("local_wifi_disconnected")) {
            context.stopService(new Intent(context, DownloadService.class));
        } else if (action.equals("android.intent.action.DOWNLOAD_WAKEUP")) {
            O000000o(context);
        } else if (action.equals("android.intent.action.DOWNLOAD_OPEN") || action.equals("android.intent.action.DOWNLOAD_LIST") || action.equals("android.intent.action.DOWNLOAD_HIDE")) {
            Uri data = intent.getData();
            String action2 = intent.getAction();
            if (action2.equals("android.intent.action.DOWNLOAD_OPEN")) {
                gsy.O000000o(2, "DownloadManager", "Receiver open for ".concat(String.valueOf(data)));
            } else if (action2.equals("android.intent.action.DOWNLOAD_LIST")) {
                gsy.O000000o(2, "DownloadManager", "Receiver list for ".concat(String.valueOf(data)));
            } else {
                gsy.O000000o(2, "DownloadManager", "Receiver hide for ".concat(String.valueOf(data)));
            }
            Cursor query = context.getContentResolver().query(data, null, null, null, null);
            if (query != null) {
                try {
                    if (!query.moveToFirst()) {
                        query.close();
                        return;
                    }
                    if (action2.equals("android.intent.action.DOWNLOAD_OPEN")) {
                        String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                        string = query.getString(query.getColumnIndexOrThrow("mimetype"));
                        Uri parse = Uri.parse(string2);
                        if (parse.getScheme() == null) {
                            parse = Uri.fromFile(new File(string2));
                        }
                        Intent intent3 = new Intent("android.intent.action.VIEW");
                        intent3.setDataAndType(parse, string);
                        intent3.setFlags(268435456);
                        context.startActivity(intent3);
                        O000000o(context, data, query);
                    } else if (action2.equals("android.intent.action.DOWNLOAD_LIST")) {
                        String string3 = query.getString(query.getColumnIndexOrThrow("notificationpackage"));
                        if (string3 != null) {
                            String string4 = query.getString(query.getColumnIndexOrThrow("notificationclass"));
                            if (query.getInt(query.getColumnIndex("is_public_api")) != 0) {
                                intent2 = new Intent("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
                                intent2.setPackage(string3);
                            } else if (string4 != null) {
                                Intent intent4 = new Intent("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
                                intent4.setClassName(string3, string4);
                                if (intent.getBooleanExtra("multiple", true)) {
                                    intent4.setData(Downloads.CONTENT_URI);
                                } else {
                                    intent4.setData(ContentUris.withAppendedId(Downloads.CONTENT_URI, query.getLong(query.getColumnIndexOrThrow("_id"))));
                                }
                                intent2 = intent4;
                            }
                            this.f7309O000000o.O000000o(intent2);
                        }
                    } else {
                        O000000o(context, data, query);
                    }
                    query.close();
                } catch (ActivityNotFoundException e) {
                    Log.d("DownloadManager", "no activity for ".concat(String.valueOf(string)), e);
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
        }
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
    private void O000000o(Context context, Uri uri, Cursor cursor) {
        this.f7309O000000o.O000000o(ContentUris.parseId(uri));
        int i = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
        int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("visibility"));
        if (Downloads.isStatusCompleted(i) && i2 == 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("visibility", (Integer) 0);
            context.getContentResolver().update(uri, contentValues, null, null);
        }
    }

    private static void O000000o(Context context) {
        context.startService(new Intent(context, DownloadService.class));
    }
}

package com.amap.location.offline;

import _m_j.op;
import _m_j.os;
import _m_j.pg;
import _m_j.ph;
import _m_j.pi;
import _m_j.sb;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class OfflineProvider extends ContentProvider {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f3554O000000o;
    private ph O00000Oo;

    private synchronized void O000000o() {
        if (this.O00000Oo == null) {
            this.O00000Oo = ph.O000000o();
            this.O00000Oo.O000000o(this.f3554O000000o, new pg(), new pi());
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        synchronized (this) {
            this.f3554O000000o = getContext().getApplicationContext();
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.sb.O000000o(boolean, _m_j.op):android.database.Cursor
     arg types: [int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.sb.O000000o(java.lang.String, java.lang.String):_m_j.os
      _m_j.sb.O000000o(boolean, _m_j.op):android.database.Cursor */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.sb.O000000o(boolean, _m_j.op):android.database.Cursor
     arg types: [int, _m_j.op]
     candidates:
      _m_j.sb.O000000o(java.lang.String, java.lang.String):_m_j.os
      _m_j.sb.O000000o(boolean, _m_j.op):android.database.Cursor */
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        O000000o();
        if (!this.O00000Oo.O00000o0()) {
            return sb.O000000o(false, (op) null);
        }
        if (strArr2 == null || strArr2.length < 5) {
            return sb.O000000o(true, (op) null);
        }
        String str3 = strArr2[0];
        os O000000o2 = sb.O000000o(strArr2[1], strArr2[2]);
        try {
            i = Integer.parseInt(strArr2[4]);
        } catch (Exception unused) {
            i = 0;
        }
        return sb.O000000o(true, this.O00000Oo.O000000o(O000000o2, i, false, str3));
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        O000000o();
        if (!this.O00000Oo.O00000o0()) {
            return 0;
        }
        if (strArr != null && strArr.length >= 5) {
            String str2 = strArr[0];
            os O000000o2 = sb.O000000o(strArr[1], strArr[2]);
            op O000000o3 = sb.O000000o(strArr[3]);
            if (O000000o3 != null) {
                this.O00000Oo.O000000o(O000000o2, O000000o3, str2);
            }
        }
        return 1;
    }
}

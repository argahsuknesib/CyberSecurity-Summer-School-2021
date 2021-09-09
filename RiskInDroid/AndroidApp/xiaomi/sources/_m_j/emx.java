package _m_j;

import _m_j.end;
import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.bs;

public final class emx extends emz {
    public emx(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
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
    public final void O000000o(Context context, Object obj) {
        ena ena;
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long O000000o2 = enj.O000000o(this.O00000o);
            long j = emv.O00000Oo;
            if (O000000o2 > j) {
                double d = (double) (O000000o2 - j);
                Double.isNaN(d);
                double d2 = (double) j;
                Double.isNaN(d2);
                double d3 = (double) longValue;
                Double.isNaN(d3);
                long j2 = (long) (((d * 1.2d) / d2) * d3);
                if (this.O00000oo != null && this.O00000oo.length > 0) {
                    this.O00000oo[0] = String.valueOf(j2);
                }
                emr O000000o3 = emr.O000000o(context);
                String str = "begin delete " + j2 + "noUpload messages , because db size is " + O000000o2 + "B";
                if (O000000o3.O000000o() && !TextUtils.isEmpty(str)) {
                    ht O000000o4 = eni.O000000o(O000000o3.f15633O000000o, str);
                    if (O000000o3.O000000o() && bs.a(O000000o4.g)) {
                        String O00000Oo = O000000o3.O00000Oo();
                        Context context2 = O000000o3.f15633O000000o;
                        byte[] O000000o5 = eru.O000000o(O000000o4);
                        if (O000000o5 == null || O000000o5.length <= 0) {
                            ena = null;
                        } else {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("status", (Integer) 0);
                            contentValues.put("messageId", "");
                            contentValues.put("messageItemId", O000000o4.f);
                            contentValues.put("messageItem", O000000o5);
                            contentValues.put("appId", emr.O000000o(context2).O00000o0);
                            contentValues.put("packageName", emr.O000000o(context2).O00000Oo);
                            contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
                            contentValues.put("uploadTimestamp", (Integer) 0);
                            ena = new ena(O00000Oo, contentValues, "a job build to insert message to db");
                        }
                        end.O000000o(O000000o3.f15633O000000o).O000000o((end.O000000o) ena);
                    }
                }
                super.O000000o(context, obj);
                return;
            }
            duv.O00000Oo("db size is suitable");
        }
    }
}

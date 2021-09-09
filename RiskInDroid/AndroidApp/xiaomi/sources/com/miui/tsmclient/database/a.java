package com.miui.tsmclient.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoFactory;
import com.miui.tsmclient.util.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class a {
    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        int delete = context.getContentResolver().delete(DatabaseConstants.CONTENT_URI_CACHE, null, null);
        LogUtils.i("delete all cards, cache count: ".concat(String.valueOf(delete)));
        return delete;
    }

    private static CardInfo a(Context context, String str, JSONObject jSONObject) {
        JSONObject b;
        CardInfo makeCardInfo = CardInfoFactory.makeCardInfo(str, jSONObject);
        if (jSONObject.has("cardName") && (b = b(context, "product_".concat(String.valueOf(str)))) != null) {
            LogUtils.d("product:" + b.toString());
            makeCardInfo.mCardSubName = b.optString("product_name");
        }
        return makeCardInfo;
    }

    public static List<CardInfo> a(Context context, String str) {
        String str2 = null;
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            str2 = "key IN ('" + str + "')";
        }
        Cursor query = context.getContentResolver().query(DatabaseConstants.CONTENT_URI_CACHE, DatabaseConstants.PROJECTION_CACHE, str2, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    int columnIndex = query.getColumnIndex("key");
                    int columnIndex2 = query.getColumnIndex("value");
                    String string = query.getString(columnIndex);
                    Object nextValue = new JSONTokener(query.getString(columnIndex2)).nextValue();
                    if (nextValue instanceof JSONObject) {
                        CardInfo a2 = a(context, string, (JSONObject) nextValue);
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    } else if (nextValue instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) nextValue;
                        for (int i = 0; i < jSONArray.length(); i++) {
                            CardInfo a3 = a(context, string, jSONArray.getJSONObject(i));
                            if (a3 != null) {
                                arrayList.add(a3);
                            }
                        }
                    }
                } catch (JSONException e) {
                    LogUtils.e("invalid JSON format", e);
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
        }
        return arrayList;
    }

    public static void a(Context context, CardInfo cardInfo) {
        if (context != null && cardInfo != null && cardInfo.mCardType != null) {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("key", cardInfo.mCardType);
            contentValues.put("value", cardInfo.serialize().toString());
            context.getContentResolver().insert(DatabaseConstants.CONTENT_URI_CACHE, contentValues);
            context.getContentResolver().notifyChange(DatabaseConstants.PUBLIC_CONTENT_URI, null);
        }
    }

    public static void a(Context context, List<? extends CardInfo> list, String str) {
        if (context != null) {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("key", str);
            JSONArray jSONArray = new JSONArray();
            for (CardInfo serialize : list) {
                jSONArray.put(serialize.serialize());
            }
            contentValues.put("value", jSONArray.toString());
            context.getContentResolver().insert(DatabaseConstants.CONTENT_URI_CACHE, contentValues);
            context.getContentResolver().notifyChange(DatabaseConstants.PUBLIC_CONTENT_URI, null);
        }
    }

    public static JSONObject b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor query = context.getContentResolver().query(DatabaseConstants.CONTENT_URI_CACHE, DatabaseConstants.PROJECTION_CACHE, "key ='" + str + "'", null, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    JSONObject jSONObject = new JSONObject(query.getString(query.getColumnIndex("value")));
                    query.close();
                    return jSONObject;
                }
            } catch (JSONException e) {
                LogUtils.e("invalid jsonobject readed from db", e);
            } catch (Throwable th) {
                query.close();
                throw th;
            }
            query.close();
        }
        return null;
    }

    public static void b(Context context, CardInfo cardInfo) {
        List<CardInfo> a2;
        if (context != null && cardInfo != null && (a2 = a(context, cardInfo.getCardType())) != null) {
            Iterator<CardInfo> it = a2.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().mAid, cardInfo.mAid)) {
                    it.remove();
                    a(context, a2, cardInfo.getCardType());
                    return;
                }
            }
        }
    }
}

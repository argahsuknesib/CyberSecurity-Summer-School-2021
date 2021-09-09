package com.mi.global.shop.util;

import _m_j.cbm;
import _m_j.ccr;
import _m_j.ceg;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;

public class SkinUtil {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f4935O000000o = "SkinUtil";
    public static HashMap<String, String> O00000Oo = new HashMap<>();
    public static String O00000o;
    public static String O00000o0;
    public static boolean O00000oO = false;
    public static int O00000oo;
    public static O000000o O0000O0o;
    private static final String[] O0000OOo = {".gif", ".png", ".jpg"};

    public interface O000000o {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public static void O000000o(Context context) {
        O00000oO = false;
        O00000Oo.clear();
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                O00000o0 = externalFilesDir.getAbsolutePath() + "/skin/";
                File file = new File(O00000o0);
                if (!file.exists()) {
                    file.mkdir();
                }
                boolean O000000o2 = cbm.O00000o0.O000000o(context, "pref_skin_switch", false);
                boolean O000000o3 = cbm.O00000o0.O000000o(context, "pref_skin_completed", false);
                if (O000000o2 && O000000o3) {
                    long O000000o4 = cbm.O00000o0.O000000o(context, "pref_skin_start_time");
                    long O000000o5 = cbm.O00000o0.O000000o(context, "pref_skin_end_time");
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    String str = f4935O000000o;
                    ccr.O00000Oo(str, "now:" + currentTimeMillis + "###end:" + O000000o5);
                    if (currentTimeMillis >= O000000o4 && currentTimeMillis < O000000o5) {
                        O00000oO = true;
                    }
                }
                if (O00000oO) {
                    O00000o = String.format("%s%s/", O00000o0, cbm.O00000o0.O00000Oo(context, "pref_skin_theme", ""));
                    HashMap<String, String> hashMap = O00000Oo;
                    hashMap.put("KEY_HEADER_STATUSBAR", O00000o + "1");
                    HashMap<String, String> hashMap2 = O00000Oo;
                    hashMap2.put("KEY_HEADER_TITLE_BG", O00000o + "header_title_bg.jpg");
                    HashMap<String, String> hashMap3 = O00000Oo;
                    hashMap3.put("KEY_HEADER_TITLE_ICON", O00000o + "header_title_icon.png");
                    HashMap<String, String> hashMap4 = O00000Oo;
                    hashMap4.put("KEY_HEADER_CART_ICON", O00000o + "header_cart_icon.png");
                    HashMap<String, String> hashMap5 = O00000Oo;
                    hashMap5.put("KEY_TAB_BG", O00000o + "bottom_tab_bg");
                    HashMap<String, String> hashMap6 = O00000Oo;
                    hashMap6.put("KEY_TAB_STORE_NORMAL", O00000o + "icon_main_home_normal");
                    HashMap<String, String> hashMap7 = O00000Oo;
                    hashMap7.put("KEY_TAB_STORE_SELECTED", O00000o + "icon_main_home_selected");
                    HashMap<String, String> hashMap8 = O00000Oo;
                    hashMap8.put("KEY_TAB_PRODUCTS_NORMAL", O00000o + "icon_main_category_normal");
                    HashMap<String, String> hashMap9 = O00000Oo;
                    hashMap9.put("KEY_TAB_PRODUCTS_SELECTED", O00000o + "icon_main_category_selected");
                    HashMap<String, String> hashMap10 = O00000Oo;
                    hashMap10.put("KEY_TAB_DISCOVER_NORMAL", O00000o + "icon_main_discover_normal");
                    HashMap<String, String> hashMap11 = O00000Oo;
                    hashMap11.put("KEY_TAB_DISCOVER_SELECTED", O00000o + "icon_main_discover_selected");
                    HashMap<String, String> hashMap12 = O00000Oo;
                    hashMap12.put("KEY_TAB_ACCOUNT_NORMAL", O00000o + "icon_main_account_normal");
                    HashMap<String, String> hashMap13 = O00000Oo;
                    hashMap13.put("KEY_TAB_ACCOUNT_SELECTED", O00000o + "icon_main_account_selected");
                    HashMap<String, String> hashMap14 = O00000Oo;
                    hashMap14.put("KEY_TAB_SERVICE_NORMAL", O00000o + "icon_main_service_normal");
                    HashMap<String, String> hashMap15 = O00000Oo;
                    hashMap15.put("KEY_TAB_SERVICE_SELECTED", O00000o + "icon_main_service_selected");
                    HashMap<String, String> hashMap16 = O00000Oo;
                    hashMap16.put("KEY_ACCOUNT_INFO_BG", O00000o + "account_info_bg.jpg");
                    HashMap<String, String> hashMap17 = O00000Oo;
                    hashMap17.put("KEY_ACCOUNT_INDIA_3X_INFO_BG", O00000o + "account_india_3x_info_bg.png");
                    HashMap<String, String> hashMap18 = O00000Oo;
                    hashMap18.put("KEY_ACCOUNT_AWAITING_PAYMENT_ICON", O00000o + "icon_order_awaiting_payment.png");
                    HashMap<String, String> hashMap19 = O00000Oo;
                    hashMap19.put("KEY_ACCOUNT_SHIPPING_ICON", O00000o + "icon_order_shipping.png");
                    HashMap<String, String> hashMap20 = O00000Oo;
                    hashMap20.put("KEY_ACCOUNT_RETURNS_ICON", O00000o + "icon_order_returns.png");
                    HashMap<String, String> hashMap21 = O00000Oo;
                    hashMap21.put("KEY_TAB_STORE_REGISTE", O00000o + "icon_home_register.jpg");
                    HashMap<String, String> hashMap22 = O00000Oo;
                    hashMap22.put("KEY_TAB_STORE_STAR_PRODUCTS", O00000o + "icon_home_star_products.jpg");
                    HashMap<String, String> hashMap23 = O00000Oo;
                    hashMap23.put("KEY_TAB_STORE_STAR_ACCESSORIES", O00000o + "icon_home_star_accessories.jpg");
                    HashMap<String, String> hashMap24 = O00000Oo;
                    hashMap24.put("KEY_FESTIVAL_TITLE_GIF_BG", O00000o + "festival_title_bg.gif");
                    HashMap<String, String> hashMap25 = O00000Oo;
                    hashMap25.put("KEY_FESTIVAL_PULL_BG", O00000o + "festival_pull_bg.jpg");
                    HashMap<String, String> hashMap26 = O00000Oo;
                    hashMap26.put("KEY_FESTIVAL_PULL_GIF_ITEM", O00000o + "festival_pull_item.gif");
                }
            }
        } catch (Exception unused) {
        }
    }

    public static Uri O000000o(String str) {
        HashMap<String, String> hashMap = O00000Oo;
        if (hashMap == null) {
            return null;
        }
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str2);
        if (file.exists()) {
            return Uri.fromFile(file);
        }
        return null;
    }

    public static class DownloadCompletedReceiver extends BroadcastReceiver {
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
         arg types: [android.content.Context, java.lang.String, int]
         candidates:
          _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
          _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
          _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
                long O000000o2 = cbm.O00000o0.O000000o(context, "pref_skin_download_id");
                if (O000000o2 == intent.getLongExtra("extra_download_id", 0)) {
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(O000000o2);
                    Cursor query2 = ((DownloadManager) context.getSystemService("download")).query(query);
                    if (query2 == null) {
                        O000000o(context);
                        return;
                    }
                    if (query2.moveToFirst()) {
                        int i = query2.getInt(query2.getColumnIndex("status"));
                        int columnIndex = query2.getColumnIndex("local_uri");
                        if (i == 8) {
                            ccr.O00000Oo(SkinUtil.f4935O000000o, "skin download success");
                            String string = query2.getString(columnIndex);
                            String O00000Oo = cbm.O00000o0.O00000Oo(context, "pref_skin_md5", "");
                            if (TextUtils.isEmpty(O00000Oo) || TextUtils.isEmpty(string)) {
                                O000000o(context);
                            } else {
                                String substring = string.substring(string.lastIndexOf(47) + 1);
                                if (ceg.O000000o(SkinUtil.O00000o0 + substring, O00000Oo)) {
                                    ccr.O00000Oo(SkinUtil.f4935O000000o, "skin check md5 success");
                                    File file = new File(String.format("%s%s/", SkinUtil.O00000o0, cbm.O00000o0.O00000Oo(context, "pref_skin_theme", "")));
                                    if (file.exists()) {
                                        cbm.O000000o.O00000Oo(file);
                                    }
                                    file.mkdir();
                                    if (cbm.O000000o.O000000o(SkinUtil.O00000o0 + substring, file.getAbsolutePath())) {
                                        ccr.O00000Oo(SkinUtil.f4935O000000o, "skin unzip success");
                                        cbm.O00000o0.O00000Oo(context, "pref_skin_completed", true);
                                        SkinUtil.O000000o(context);
                                        if (SkinUtil.O0000O0o != null) {
                                            O000000o o000000o = SkinUtil.O0000O0o;
                                        }
                                    } else {
                                        ccr.O00000Oo(SkinUtil.f4935O000000o, "skin unzip fail");
                                    }
                                }
                                ccr.O00000Oo(SkinUtil.f4935O000000o, "skin check md5 fail");
                                O000000o(context);
                            }
                        } else if (i == 16) {
                            ccr.O00000Oo(SkinUtil.f4935O000000o, "skin download fail");
                            O000000o(context);
                        }
                    }
                    query2.close();
                }
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
         arg types: [android.content.Context, java.lang.String, int]
         candidates:
          _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
          _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
          _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
         arg types: [android.content.Context, java.lang.String, long]
         candidates:
          _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
          _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
          _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
          _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void */
        private static void O000000o(Context context) {
            SkinUtil.O0000O0o = null;
            cbm.O00000o0.O00000Oo(context, "pref_skin_switch", false);
            cbm.O00000o0.O00000Oo(context, "pref_skin_completed", false);
            cbm.O00000o0.O000000o(context, "pref_skin_start_time", (Long) 0L);
            cbm.O00000o0.O000000o(context, "pref_skin_end_time", (Long) 0L);
            cbm.O00000o0.O000000o(context, "pref_skin_download_url", "");
            cbm.O00000o0.O000000o(context, "pref_skin_theme", "");
            cbm.O00000o0.O000000o(context, "pref_skin_md5", "");
        }
    }
}

package com.facebook.messenger;

import _m_j.kj;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.messenger.MessengerThreadParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MessengerUtils {
    public static void shareToMessenger(Activity activity, int i, ShareToMessengerParams shareToMessengerParams) {
        if (!hasMessengerInstalled(activity)) {
            openMessengerInPlayStore(activity);
        } else if (getAllAvailableProtocolVersions(activity).contains(20150314)) {
            shareToMessenger20150314(activity, i, shareToMessengerParams);
        } else {
            openMessengerInPlayStore(activity);
        }
    }

    private static void shareToMessenger20150314(Activity activity, int i, ShareToMessengerParams shareToMessengerParams) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setFlags(1);
            intent.setPackage("com.facebook.orca");
            intent.putExtra("android.intent.extra.STREAM", shareToMessengerParams.uri);
            intent.setType(shareToMessengerParams.mimeType);
            String applicationId = FacebookSdk.getApplicationId();
            if (applicationId != null) {
                intent.putExtra("com.facebook.orca.extra.PROTOCOL_VERSION", 20150314);
                intent.putExtra("com.facebook.orca.extra.APPLICATION_ID", applicationId);
                intent.putExtra("com.facebook.orca.extra.METADATA", shareToMessengerParams.metaData);
                intent.putExtra("com.facebook.orca.extra.EXTERNAL_URI", shareToMessengerParams.externalUri);
            }
            activity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException unused) {
            activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage("com.facebook.orca"));
        }
    }

    public static MessengerThreadParams getMessengerThreadParamsForIntent(Intent intent) {
        Set<String> categories = intent.getCategories();
        if (categories == null || !categories.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314")) {
            return null;
        }
        Bundle O000000o2 = kj.O000000o(intent);
        String string = O000000o2.getString("com.facebook.orca.extra.THREAD_TOKEN");
        String string2 = O000000o2.getString("com.facebook.orca.extra.METADATA");
        String string3 = O000000o2.getString("com.facebook.orca.extra.PARTICIPANTS");
        boolean z = O000000o2.getBoolean("com.facebook.orca.extra.IS_REPLY");
        boolean z2 = O000000o2.getBoolean("com.facebook.orca.extra.IS_COMPOSE");
        MessengerThreadParams.Origin origin = MessengerThreadParams.Origin.UNKNOWN;
        if (z) {
            origin = MessengerThreadParams.Origin.REPLY_FLOW;
        } else if (z2) {
            origin = MessengerThreadParams.Origin.COMPOSE_FLOW;
        }
        return new MessengerThreadParams(origin, string, string2, parseParticipants(string3));
    }

    public static void finishShareToMessenger(Activity activity, ShareToMessengerParams shareToMessengerParams) {
        Intent intent = activity.getIntent();
        Set<String> categories = intent.getCategories();
        if (categories == null) {
            activity.setResult(0, null);
            activity.finish();
        } else if (categories.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314")) {
            Bundle O000000o2 = kj.O000000o(intent);
            Intent intent2 = new Intent();
            if (categories.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314")) {
                intent2.putExtra("com.facebook.orca.extra.PROTOCOL_VERSION", 20150314);
                intent2.putExtra("com.facebook.orca.extra.THREAD_TOKEN", O000000o2.getString("com.facebook.orca.extra.THREAD_TOKEN"));
                intent2.setDataAndType(shareToMessengerParams.uri, shareToMessengerParams.mimeType);
                intent2.setFlags(1);
                intent2.putExtra("com.facebook.orca.extra.APPLICATION_ID", FacebookSdk.getApplicationId());
                intent2.putExtra("com.facebook.orca.extra.METADATA", shareToMessengerParams.metaData);
                intent2.putExtra("com.facebook.orca.extra.EXTERNAL_URI", shareToMessengerParams.externalUri);
                activity.setResult(-1, intent2);
                activity.finish();
                return;
            }
            throw new RuntimeException();
        } else {
            activity.setResult(0, null);
            activity.finish();
        }
    }

    public static boolean hasMessengerInstalled(Context context) {
        return FacebookSignatureValidator.validateSignature(context, "com.facebook.orca");
    }

    public static void openMessengerInPlayStore(Context context) {
        try {
            startViewUri(context, "market://details?id=com.facebook.orca");
        } catch (ActivityNotFoundException unused) {
            startViewUri(context, "http://play.google.com/store/apps/details?id=com.facebook.orca");
        }
    }

    private static Set<Integer> getAllAvailableProtocolVersions(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        HashSet hashSet = new HashSet();
        Cursor query = contentResolver.query(Uri.parse("content://com.facebook.orca.provider.MessengerPlatformProvider/versions"), new String[]{"version"}, null, null, null);
        if (query != null) {
            try {
                int columnIndex = query.getColumnIndex("version");
                while (query.moveToNext()) {
                    hashSet.add(Integer.valueOf(query.getInt(columnIndex)));
                }
            } finally {
                query.close();
            }
        }
        return hashSet;
    }

    private static void startViewUri(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    private static List<String> parseParticipants(String str) {
        if (str == null || str.length() == 0) {
            return Collections.emptyList();
        }
        String[] split = str.split(",");
        ArrayList arrayList = new ArrayList();
        for (String trim : split) {
            arrayList.add(trim.trim());
        }
        return arrayList;
    }
}

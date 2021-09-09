package com.miui.tsmclient.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.miui.tsmclient.entity.CardInfoManager;
import com.miui.tsmclient.util.ResUtils;

public class TSMPublicProvider extends ContentProvider {
    public Bundle call(String str, String str2, Bundle bundle) {
        String str3;
        Context context = getContext();
        Bundle bundle2 = new Bundle();
        if ("cards_info".equals(str)) {
            int issuedTransCardsCount = CardInfoManager.getInstance(context).getIssuedTransCardsCount() + 0;
            int bankCardsCount = CardInfoManager.getInstance(context).getBankCardsCount();
            String str4 = "";
            if (bankCardsCount == 0) {
                str3 = str4;
            } else {
                str3 = bankCardsCount + ResUtils.getString(context, "bank_card_unit");
            }
            bundle2.putString("bank_cards_count", str3);
            int mifareCardsCount = issuedTransCardsCount + bankCardsCount + CardInfoManager.getInstance(context).getMifareCardsCount();
            if (mifareCardsCount != 0) {
                str4 = mifareCardsCount + ResUtils.getString(context, "card_unit");
            }
            bundle2.putString("all_cards_count", str4);
        }
        return bundle2;
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

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}

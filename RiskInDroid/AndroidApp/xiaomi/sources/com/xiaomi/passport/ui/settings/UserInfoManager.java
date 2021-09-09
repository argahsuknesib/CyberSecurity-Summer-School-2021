package com.xiaomi.passport.ui.settings;

import _m_j.ft;
import android.content.Context;
import android.content.Intent;

public class UserInfoManager {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f6312O000000o;

    public UserInfoManager(Context context) {
        this.f6312O000000o = context;
    }

    public enum UserInfoType {
        Modify_User_Phone("Modify_User_Phone"),
        Modify_User_Email("Modify_User_Email"),
        Modify_User_Password("Modify_User_Password");
        
        private String typeName;

        private UserInfoType(String str) {
            this.typeName = str;
        }

        public final String getTypeName() {
            return this.typeName;
        }
    }

    static void O000000o(Context context, boolean z, int i) {
        Intent intent = new Intent("action_local_account_change_Phone");
        intent.putExtra("result", z);
        intent.putExtra("result_code", i);
        ft.O000000o(context).O000000o(intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void O000000o(Context context) {
        Intent intent = new Intent("action_local_account_change_email");
        intent.putExtra("result", true);
        intent.putExtra("result_code", -1);
        ft.O000000o(context).O000000o(intent);
    }

    static void O00000Oo(Context context, boolean z, int i) {
        Intent intent = new Intent("action_local_account_change_password");
        intent.putExtra("result", z);
        intent.putExtra("result_code", i);
        ft.O000000o(context).O000000o(intent);
    }
}

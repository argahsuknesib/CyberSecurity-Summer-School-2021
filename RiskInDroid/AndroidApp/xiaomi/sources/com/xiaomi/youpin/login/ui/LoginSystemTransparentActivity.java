package com.xiaomi.youpin.login.ui;

import _m_j.ft;
import _m_j.icm;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;

public class LoginSystemTransparentActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        icm.O00000Oo(this);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26 || !icm.O000000o(this)) {
            setRequestedOrientation(1);
        }
        Intent intent = ((XmAccountVisibility) getIntent().getParcelableExtra("XmAccountVisibility")).O00000oo;
        intent.putExtra("descriptionTextOverride", "是否允许小米有品访问您的系统小米帐号？");
        startActivityForResult(intent, 100);
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
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("authAccount");
                String stringExtra2 = intent.getStringExtra("accountType");
                ft O000000o2 = ft.O000000o(getApplicationContext());
                Intent intent2 = new Intent("mijia.access.xm_account");
                intent2.putExtra("mijia.access.xm_account.param.is_success", true);
                intent2.putExtra("mijia.access.xm_account.param.account_name", stringExtra);
                intent2.putExtra("mijia.access.xm_account.param.account_type", stringExtra2);
                O000000o2.O000000o(intent2);
            } else {
                ft O000000o3 = ft.O000000o(getApplicationContext());
                Intent intent3 = new Intent("mijia.access.xm_account");
                intent3.putExtra("mijia.access.xm_account.param.is_success", false);
                O000000o3.O000000o(intent3);
            }
            finish();
        }
    }
}

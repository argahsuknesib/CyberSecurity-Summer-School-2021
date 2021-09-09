package com.xiaomi.smarthome;

import _m_j.cmc;
import _m_j.gpv;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class YoupinPopupActivity extends BaseActivity {
    public static boolean shouldCheckYoupinShowReq() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_youpin_popup);
        overridePendingTransition(0, 0);
        findViewById(R.id.experience).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.YoupinPopupActivity.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
             arg types: [java.lang.String, int]
             candidates:
              _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
              _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
              _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
            public final void onClick(View view) {
                gpv.O00000Oo("yp_popup_has_shown", true);
                cmc.O000000o("https://home.mi.com/shop/promotion");
                YoupinPopupActivity.this.doCancel();
            }
        });
        findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.YoupinPopupActivity.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
             arg types: [java.lang.String, int]
             candidates:
              _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
              _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
              _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
            public final void onClick(View view) {
                gpv.O00000Oo("yp_popup_has_shown", true);
                YoupinPopupActivity.this.doCancel();
            }
        });
        findViewById(R.id.background_bg).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.YoupinPopupActivity.AnonymousClass3 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
             arg types: [java.lang.String, int]
             candidates:
              _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
              _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
              _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
            public final void onClick(View view) {
                gpv.O00000Oo("yp_popup_has_shown", true);
                cmc.O000000o("https://home.mi.com/shop/promotion");
                YoupinPopupActivity.this.doCancel();
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
    public void onBackPressed() {
        gpv.O00000Oo("yp_popup_has_shown", true);
        doCancel();
    }

    public void doCancel() {
        finish();
        overridePendingTransition(0, 0);
    }

    public static boolean copyApkFromAssets(Context context, String str, String str2) {
        try {
            InputStream open = context.getAssets().open(str);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    open.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}

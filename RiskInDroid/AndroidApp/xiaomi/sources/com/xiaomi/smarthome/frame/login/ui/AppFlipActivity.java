package com.xiaomi.smarthome.frame.login.ui;

import _m_j.ezu;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gty;
import _m_j.ibr;
import _m_j.ibx;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Formatter;

public class AppFlipActivity extends AppCompatActivity {
    public static final String TAG = "AppFlipActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    private String f7532O000000o;
    private String O00000Oo;
    private int[] O00000o0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_app_flip);
        Intent intent = getIntent();
        final Intent intent2 = new Intent();
        if (!intent.hasExtra("CLIENT_ID") || intent.getExtras() == null) {
            gsy.O000000o(3, TAG, "couldn't find extra CLIENT_ID");
            gqg.O00000Oo("Did not received clientID");
            intent2.putExtra("ERROR_TYPE", 1);
            intent2.putExtra("ERROR_CODE", 10);
            setResult(-2, intent2);
            finish();
            return;
        }
        this.f7532O000000o = intent.getStringExtra("CLIENT_ID");
        String[] stringArray = intent.getExtras().getStringArray("SCOPE");
        this.O00000Oo = intent.getExtras().getString("REDIRECT_URI");
        if (stringArray != null) {
            try {
                this.O00000o0 = new int[stringArray.length];
                for (int i = 0; i < stringArray.length; i++) {
                    this.O00000o0[i] = Integer.valueOf(stringArray[i]).intValue();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ComponentName callingActivity = getCallingActivity();
        gsy.O00000Oo(LogType.LOGIN, TAG, "Checking intent sender cert and package name...\n");
        if (!O000000o(callingActivity) || !TextUtils.equals(this.f7532O000000o, "2882303761518143100")) {
            gqg.O00000Oo("Sender cert or name mismatch!");
            gsy.O000000o(6, TAG, "Intent sender certificate or package ID or clientId mismatch!");
            intent2.putExtra("ERROR_TYPE", 1);
            intent2.putExtra("ERROR_CODE", 8);
            setResult(-2, intent2);
            finish();
            return;
        }
        gsy.O00000Oo(LogType.LOGIN, TAG, "Certificate match\n");
        if (!ezu.O000000o()) {
            gsy.O00000Oo(LogType.LOGIN, TAG, "CTA not passed yet");
            intent2.putExtra("ERROR_TYPE", 1);
            intent2.putExtra("ERROR_CODE", 5);
            setResult(-2, intent2);
            finish();
            return;
        }
        gty.O000000o().getAuthorizationCode(this, this.f7532O000000o, this.O00000o0, this.O00000Oo, new ibr() {
            /* class com.xiaomi.smarthome.frame.login.ui.AppFlipActivity.AnonymousClass1 */

            public final void O000000o(ibx ibx) {
                if (ibx == null || TextUtils.isEmpty(ibx.O0000Oo0)) {
                    AppFlipActivity.this.setResult(0);
                } else {
                    LogType logType = LogType.LOGIN;
                    String str = AppFlipActivity.TAG;
                    gsy.O00000Oo(logType, str, "getAuthorizationCode success " + ibx.O0000Oo0);
                    Intent intent = new Intent();
                    intent.putExtra("AUTHORIZATION_CODE", ibx.O0000Oo0);
                    AppFlipActivity.this.setResult(-1, intent);
                }
                AppFlipActivity.this.finish();
            }

            public final void O000000o(int i, String str) {
                LogType logType = LogType.LOGIN;
                String str2 = AppFlipActivity.TAG;
                gsy.O00000Oo(logType, str2, "onLoginFail: i = " + i + " msg = " + str);
                intent2.putExtra("ERROR_TYPE", 2);
                intent2.putExtra("ERROR_CODE", 13);
                AppFlipActivity.this.setResult(-2, intent2);
                AppFlipActivity.this.finish();
            }
        });
    }

    private boolean O000000o(ComponentName componentName) {
        if (componentName == null) {
            return false;
        }
        String packageName = componentName.getPackageName();
        if (!"com.google.android.googlequicksearchbox".equalsIgnoreCase(packageName)) {
            return false;
        }
        try {
            return "F0:FD:6C:5B:41:0F:25:CB:25:C3:B5:33:46:C8:97:2F:AE:30:F8:EE:74:11:DF:91:04:80:AD:6B:2D:60:DB:83".equalsIgnoreCase(O000000o(getApplicationContext(), packageName));
        } catch (PackageManager.NameNotFoundException e) {
            gsy.O000000o(6, TAG, "No such app is installed ".concat(String.valueOf(e)));
            return false;
        }
    }

    private static String O000000o(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            return O000000o(MessageDigest.getInstance("SHA-256").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (NoSuchAlgorithmException | CertificateException e) {
            Log.e(TAG, "Failed to process the certificate", e);
            return null;
        }
    }

    private static String O000000o(byte[] bArr) {
        Formatter formatter = new Formatter();
        for (int i = 0; i < bArr.length - 1; i++) {
            formatter.format("%02x:", Byte.valueOf(bArr[i]));
        }
        formatter.format("%02x", Byte.valueOf(bArr[bArr.length - 1]));
        return formatter.toString().toUpperCase();
    }
}

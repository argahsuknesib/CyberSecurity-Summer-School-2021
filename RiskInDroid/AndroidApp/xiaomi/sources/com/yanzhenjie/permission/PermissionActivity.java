package com.yanzhenjie.permission;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;

public final class PermissionActivity extends AppCompatActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private static O000000o f12245O000000o;

    public interface O000000o {
        void O00000Oo(String[] strArr);
    }

    public static void requestPermission(Context context, String[] strArr, O000000o o000000o) {
        f12245O000000o = o000000o;
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("KEY_INPUT_PERMISSIONS", strArr);
        context.startActivity(intent);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024 | 256);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(3);
        }
        String[] stringArrayExtra = getIntent().getStringArrayExtra("KEY_INPUT_PERMISSIONS");
        if (stringArrayExtra == null || f12245O000000o == null) {
            f12245O000000o = null;
            finish();
            return;
        }
        requestPermissions(stringArrayExtra, 1);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        O000000o o000000o = f12245O000000o;
        if (o000000o != null) {
            o000000o.O00000Oo(strArr);
            f12245O000000o = null;
        }
        finish();
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}

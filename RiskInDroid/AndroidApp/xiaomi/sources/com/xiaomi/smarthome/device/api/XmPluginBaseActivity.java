package com.xiaomi.smarthome.device.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.xiaomi.plugin.core.XmPluginPackage;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public class XmPluginBaseActivity extends FragmentActivity implements IXmPluginActivity {
    public static String FINISH_TAG = "xmplugin_finish";
    public static String LAST_FINISH_ACTIVITY = "xmplugin_last_finish_activity";
    public static int START_ACTIVITY_TAG = 10000;
    protected DeviceStat mDeviceStat;
    public Handler mHandler;
    protected IXmPluginHostActivity mHostActivity;
    protected FragmentActivity mMainActivity;
    protected XmPluginPackage mPluginPackage;

    public View getTitleBar() {
        return null;
    }

    public void handleMessage(Message message) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    @Deprecated
    public void onSceneLoaded(boolean z) {
    }

    static class ActivityHandler extends Handler {
        WeakReference<XmPluginBaseActivity> mRefActivity;

        private ActivityHandler(XmPluginBaseActivity xmPluginBaseActivity) {
            this.mRefActivity = new WeakReference<>(xmPluginBaseActivity);
        }

        public void handleMessage(Message message) {
            XmPluginBaseActivity xmPluginBaseActivity;
            WeakReference<XmPluginBaseActivity> weakReference = this.mRefActivity;
            if (weakReference != null && (xmPluginBaseActivity = weakReference.get()) != null && !xmPluginBaseActivity.isFinishing()) {
                xmPluginBaseActivity.handleMessage(message);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isLocalLaunch() {
        return this.mMainActivity == null;
    }

    public void attach(IXmPluginHostActivity iXmPluginHostActivity, XmPluginPackage xmPluginPackage, DeviceStat deviceStat) {
        this.mHostActivity = iXmPluginHostActivity;
        this.mMainActivity = iXmPluginHostActivity.activity();
        this.mPluginPackage = xmPluginPackage;
        this.mDeviceStat = deviceStat;
        attachBaseContext(this.mMainActivity);
    }

    public Activity activity() {
        if (isLocalLaunch()) {
            return this;
        }
        return this.mMainActivity;
    }

    public DeviceStat getDeviceStat() {
        return this.mDeviceStat;
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
    public void finishParent(String str) {
        Intent intent = new Intent();
        intent.putExtra(FINISH_TAG, true);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(LAST_FINISH_ACTIVITY, str);
        }
        activity().setResult(-1, intent);
        finish();
    }

    public void setContentView(View view) {
        if (isLocalLaunch()) {
            super.setContentView(view);
        } else {
            this.mMainActivity.setContentView(view);
        }
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (isLocalLaunch()) {
            super.setContentView(view, layoutParams);
        } else {
            this.mMainActivity.setContentView(view, layoutParams);
        }
    }

    public void setContentView(int i) {
        if (isLocalLaunch()) {
            super.setContentView(i);
        } else {
            this.mMainActivity.setContentView(i);
        }
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (isLocalLaunch()) {
            super.addContentView(view, layoutParams);
        } else {
            this.mMainActivity.addContentView(view, layoutParams);
        }
    }

    public Looper getMainLooper() {
        if (isLocalLaunch()) {
            return super.getMainLooper();
        }
        return this.mMainActivity.getMainLooper();
    }

    public View findViewById(int i) {
        if (isLocalLaunch()) {
            return super.findViewById(i);
        }
        return this.mMainActivity.findViewById(i);
    }

    public Intent getIntent() {
        if (isLocalLaunch()) {
            return super.getIntent();
        }
        return this.mMainActivity.getIntent();
    }

    public void setIntent(Intent intent) {
        if (isLocalLaunch()) {
            super.setIntent(intent);
        } else {
            this.mMainActivity.setIntent(intent);
        }
    }

    public ClassLoader getClassLoader() {
        if (isLocalLaunch()) {
            return super.getClassLoader();
        }
        return this.mMainActivity.getClassLoader();
    }

    public Resources getResources() {
        if (isLocalLaunch()) {
            return super.getResources();
        }
        return this.mMainActivity.getResources();
    }

    public AssetManager getAssets() {
        if (isLocalLaunch()) {
            return super.getAssets();
        }
        return this.mMainActivity.getAssets();
    }

    public String getPackageName() {
        if (isLocalLaunch()) {
            return super.getPackageName();
        }
        XmPluginPackage xmPluginPackage = this.mPluginPackage;
        if (xmPluginPackage != null) {
            return xmPluginPackage.packageName;
        }
        return this.mMainActivity.getPackageName();
    }

    public LayoutInflater getLayoutInflater() {
        if (isLocalLaunch()) {
            return super.getLayoutInflater();
        }
        return this.mMainActivity.getLayoutInflater();
    }

    public MenuInflater getMenuInflater() {
        if (isLocalLaunch()) {
            return super.getMenuInflater();
        }
        return this.mMainActivity.getMenuInflater();
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        if (isLocalLaunch()) {
            return super.getSharedPreferences(str, i);
        }
        return this.mMainActivity.getSharedPreferences(str, i);
    }

    public Context getApplicationContext() {
        if (isLocalLaunch()) {
            return super.getApplicationContext();
        }
        return this.mMainActivity.getApplicationContext();
    }

    public WindowManager getWindowManager() {
        if (isLocalLaunch()) {
            return super.getWindowManager();
        }
        return this.mMainActivity.getWindowManager();
    }

    public Window getWindow() {
        if (isLocalLaunch()) {
            return super.getWindow();
        }
        return this.mMainActivity.getWindow();
    }

    public Object getSystemService(String str) {
        if (isLocalLaunch()) {
            return super.getSystemService(str);
        }
        return this.mMainActivity.getSystemService(str);
    }

    public void finish() {
        if (isLocalLaunch()) {
            super.finish();
        } else {
            this.mMainActivity.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        if (isLocalLaunch()) {
            super.onCreate(bundle);
        }
        this.mHandler = new ActivityHandler();
    }

    public void onBackPressed() {
        if (isLocalLaunch()) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (isLocalLaunch()) {
            super.onActivityResult(i, i2, intent);
        }
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra(FINISH_TAG, false);
            String name = getClass().getName();
            String stringExtra = intent.getStringExtra(LAST_FINISH_ACTIVITY);
            if (booleanExtra && !name.equals(stringExtra)) {
                finishParent(stringExtra);
            }
        }
    }

    public void onStart() {
        if (isLocalLaunch()) {
            super.onStart();
        }
    }

    public void onRestart() {
        if (isLocalLaunch()) {
            super.onRestart();
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (isLocalLaunch()) {
            super.onRestoreInstanceState(bundle);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (isLocalLaunch()) {
            super.onSaveInstanceState(bundle);
        }
    }

    public void onNewIntent(Intent intent) {
        if (isLocalLaunch()) {
            super.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (isLocalLaunch()) {
            super.onResume();
        }
    }

    public void onPause() {
        if (isLocalLaunch()) {
            super.onPause();
        }
    }

    public void onStop() {
        if (isLocalLaunch()) {
            super.onStop();
        }
    }

    public void onDestroy() {
        if (isLocalLaunch()) {
            super.onDestroy();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isLocalLaunch()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isLocalLaunch()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (isLocalLaunch()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isLocalLaunch()) {
            return super.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (isLocalLaunch()) {
            return super.onKeyUp(i, keyEvent);
        }
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        if (isLocalLaunch()) {
            return super.onKeyLongPress(i, keyEvent);
        }
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        if (isLocalLaunch()) {
            return super.onKeyMultiple(i, i2, keyEvent);
        }
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        if (isLocalLaunch()) {
            return super.onKeyShortcut(i, keyEvent);
        }
        return false;
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        if (isLocalLaunch()) {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (isLocalLaunch()) {
            super.onWindowFocusChanged(z);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (isLocalLaunch()) {
            return super.onCreateOptionsMenu(menu);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (isLocalLaunch()) {
            return onOptionsItemSelected(menuItem);
        }
        return false;
    }

    public void onContentChanged() {
        if (isLocalLaunch()) {
            super.onContentChanged();
        } else {
            this.mHostActivity.setTitleBarPadding(getTitleBar());
        }
    }

    public void startActivity(Intent intent, String str) {
        startActivityForResult(intent, str, START_ACTIVITY_TAG);
    }

    public void startActivityForResult(Intent intent, String str, int i) {
        if (isLocalLaunch()) {
            intent.setClassName(getPackageName(), str);
            DeviceStat deviceStat = this.mDeviceStat;
            if (deviceStat != null) {
                intent.putExtra("extra_device_did", deviceStat.did);
            }
            startActivityForResult(intent, i);
            return;
        }
        XmPluginPackage xmPluginPackage = this.mPluginPackage;
        if (xmPluginPackage == null) {
            this.mHostActivity.startActivityForResult(intent, "", str, i);
        } else {
            this.mHostActivity.startActivityForResult(intent, xmPluginPackage.packageName, str, i);
        }
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (isLocalLaunch()) {
            super.startActivityForResult(intent, i, bundle);
        } else {
            this.mMainActivity.startActivityForResult(intent, i, bundle);
        }
    }

    public FragmentManager getSupportFragmentManager() {
        if (isLocalLaunch()) {
            return super.getSupportFragmentManager();
        }
        return this.mMainActivity.getSupportFragmentManager();
    }

    public LoaderManager getSupportLoaderManager() {
        if (isLocalLaunch()) {
            return super.getSupportLoaderManager();
        }
        return this.mMainActivity.getSupportLoaderManager();
    }

    public void setResult0(int i) {
        if (isLocalLaunch()) {
            super.setResult(i);
        } else {
            this.mMainActivity.setResult(i);
        }
    }

    public void setResult0(int i, Intent intent) {
        if (isLocalLaunch()) {
            super.setResult(i, intent);
        } else {
            this.mMainActivity.setResult(i, intent);
        }
    }

    public IXmPluginHostActivity hostActivity() {
        return this.mHostActivity;
    }

    public XmPluginPackage pluginPackage() {
        return this.mPluginPackage;
    }

    public boolean isFinishing() {
        if (isLocalLaunch()) {
            return super.isFinishing();
        }
        return this.mMainActivity.isFinishing();
    }

    public boolean isChangingConfigurations() {
        if (isLocalLaunch()) {
            return super.isChangingConfigurations();
        }
        return this.mMainActivity.isChangingConfigurations();
    }

    public int getRequestedOrientation() {
        if (isLocalLaunch()) {
            return super.getRequestedOrientation();
        }
        return this.mMainActivity.getRequestedOrientation();
    }

    public int getTaskId() {
        if (isLocalLaunch()) {
            return super.getTaskId();
        }
        return this.mMainActivity.getTaskId();
    }

    public boolean isTaskRoot() {
        if (isLocalLaunch()) {
            return super.isTaskRoot();
        }
        return this.mMainActivity.isTaskRoot();
    }

    public SharedPreferences getPreferences(int i) {
        if (isLocalLaunch()) {
            return super.getPreferences(i);
        }
        return this.mMainActivity.getPreferences(i);
    }

    public void setRequestedOrientation(int i) {
        if (!isLocalLaunch()) {
            this.mMainActivity.setRequestedOrientation(i);
        } else if (Build.VERSION.SDK_INT != 26 || !isTranslucentOrFloating()) {
            super.setRequestedOrientation(i);
        }
    }

    public android.app.LoaderManager getLoaderManager() {
        if (isLocalLaunch()) {
            return super.getLoaderManager();
        }
        return this.mMainActivity.getLoaderManager();
    }

    public View getCurrentFocus() {
        if (isLocalLaunch()) {
            return super.getCurrentFocus();
        }
        return this.mMainActivity.getCurrentFocus();
    }

    public void onPostCreate(Bundle bundle) {
        if (isLocalLaunch()) {
            super.onPostCreate(bundle);
        }
    }

    public void onPostResume() {
        if (isLocalLaunch()) {
            super.onPostResume();
        }
    }

    public void onUserLeaveHint() {
        if (isLocalLaunch()) {
            super.onUserLeaveHint();
        }
    }

    private boolean isTranslucentOrFloating() {
        boolean z = false;
        try {
            TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            boolean booleanValue = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
                return booleanValue;
            } catch (Exception e) {
                boolean z2 = booleanValue;
                e = e;
                z = z2;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return z;
        }
    }
}

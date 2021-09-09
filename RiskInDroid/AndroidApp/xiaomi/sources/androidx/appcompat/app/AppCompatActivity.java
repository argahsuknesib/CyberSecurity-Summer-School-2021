package androidx.appcompat.app;

import _m_j.O0o0000;
import _m_j.OO00O0o;
import _m_j.OoO0o;
import _m_j.OooOO;
import _m_j.e;
import _m_j.o000;
import _m_j.oOOO00o0;
import _m_j.oOOO0o00;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

public class AppCompatActivity extends FragmentActivity implements OoO0o, e.O000000o {
    private O0o0000 mDelegate;
    private Resources mResources;

    /* access modifiers changed from: protected */
    public void onNightModeChanged(int i) {
    }

    public void onPrepareSupportNavigateUpTaskStack(e eVar) {
    }

    public void onSupportActionModeFinished(OO00O0o oO00O0o) {
    }

    public void onSupportActionModeStarted(OO00O0o oO00O0o) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public OO00O0o onWindowStartingSupportActionMode(OO00O0o.O000000o o000000o) {
        return null;
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    public AppCompatActivity() {
    }

    public AppCompatActivity(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().O000000o(context));
    }

    public void onCreate(Bundle bundle) {
        O0o0000 delegate = getDelegate();
        delegate.O0000OoO();
        delegate.O00000o0();
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        getDelegate().O000000o(i);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().O00000o();
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().O000000o();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().O000000o(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().O00000Oo();
    }

    public void setContentView(int i) {
        getDelegate().O00000o0(i);
    }

    public void setContentView(View view) {
        getDelegate().O000000o(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().O000000o(view, layoutParams);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().O00000Oo(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        getDelegate().O000000o(configuration);
    }

    public void onPostResume() {
        super.onPostResume();
        getDelegate().O0000O0o();
    }

    public void onStart() {
        super.onStart();
        getDelegate().O00000oO();
    }

    public void onStop() {
        super.onStop();
        getDelegate().O00000oo();
    }

    public <T extends View> T findViewById(int i) {
        return getDelegate().O00000Oo(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.O00000o0() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public void onDestroy() {
        super.onDestroy();
        getDelegate().O0000Oo0();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().O000000o(charSequence);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().O00000o(i);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().O0000OOo();
    }

    public void invalidateOptionsMenu() {
        getDelegate().O0000OOo();
    }

    public OO00O0o startSupportActionMode(OO00O0o.O000000o o000000o) {
        return getDelegate().O000000o(o000000o);
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            e O000000o2 = e.O000000o(this);
            onCreateSupportNavigateUpTaskStack(O000000o2);
            onPrepareSupportNavigateUpTaskStack(O000000o2);
            if (!O000000o2.f15113O000000o.isEmpty()) {
                Intent[] intentArr = (Intent[]) O000000o2.f15113O000000o.toArray(new Intent[O000000o2.f15113O000000o.size()]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                ContextCompat.O000000o(O000000o2.O00000Oo, intentArr, (Bundle) null);
                try {
                    oOOO00o0.O000000o((Activity) this);
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            } else {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
    }

    public Intent getSupportParentActivityIntent() {
        return oOOO0o00.O000000o(this);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    public OooOO.O000000o getDrawerToggleDelegate() {
        return getDelegate().O0000Oo();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate();
    }

    public O0o0000 getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = O0o0000.O000000o(this, this);
        }
        return this.mDelegate;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.O000000o(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public Resources getResources() {
        if (this.mResources == null && o000.O000000o()) {
            this.mResources = new o000(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        Window window;
        return Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.O0000O0o()) {
            super.openOptionsMenu();
        }
    }

    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.O0000OOo()) {
            super.closeOptionsMenu();
        }
    }

    public void onCreateSupportNavigateUpTaskStack(e eVar) {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = oOOO0o00.O000000o(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(eVar.O00000Oo.getPackageManager());
            }
            eVar.O000000o(component);
            eVar.f15113O000000o.add(supportParentActivityIntent);
        }
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            return shouldUpRecreateTask(intent);
        }
        String action = getIntent().getAction();
        return action != null && !action.equals("android.intent.action.MAIN");
    }

    public void supportNavigateUpTo(Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            navigateUpTo(intent);
            return;
        }
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
    }
}

package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import com.xiaomi.smarthome.R;
import java.lang.Thread;

@TargetApi(9)
@RequiresApi(9)
abstract class AppCompatDelegateImplBase extends AppCompatDelegate {
    private static final boolean SHOULD_INSTALL_EXCEPTION_HANDLER;
    private static boolean sInstalledExceptionHandler = true;
    private static final int[] sWindowBackgroundStyleable = {16842836};
    ActionBar mActionBar;
    final AppCompatCallback mAppCompatCallback;
    final Window.Callback mAppCompatWindowCallback;
    final Context mContext;
    boolean mHasActionBar;
    private boolean mIsDestroyed;
    boolean mIsFloating;
    private boolean mIsStarted;
    MenuInflater mMenuInflater;
    final Window.Callback mOriginalWindowCallback = this.mWindow.getCallback();
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private CharSequence mTitle;
    final Window mWindow;
    boolean mWindowNoTitle;

    public boolean applyDayNight() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    /* access modifiers changed from: package-private */
    public abstract void initWindowDecorActionBar();

    public boolean isHandleNativeActionModesEnabled() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    /* access modifiers changed from: package-private */
    public abstract boolean onMenuOpened(int i, Menu menu);

    /* access modifiers changed from: package-private */
    public abstract void onPanelClosed(int i, Menu menu);

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public abstract void onTitleChanged(CharSequence charSequence);

    public void setHandleNativeActionModesEnabled(boolean z) {
    }

    public void setLocalNightMode(int i) {
    }

    /* access modifiers changed from: package-private */
    public abstract ActionMode startSupportActionModeFromWindow(ActionMode.Callback callback);

    static {
        boolean z = Build.VERSION.SDK_INT < 21;
        SHOULD_INSTALL_EXCEPTION_HANDLER = z;
        if (z && !sInstalledExceptionHandler) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                /* class android.support.v7.app.AppCompatDelegateImplBase.AnonymousClass1 */

                public final void uncaughtException(Thread thread, Throwable th) {
                    if (shouldWrapException(th)) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }

                private boolean shouldWrapException(Throwable th) {
                    String message;
                    if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null || (!message.contains("drawable") && !message.contains("Drawable"))) {
                        return false;
                    }
                    return true;
                }
            });
        }
    }

    AppCompatDelegateImplBase(Context context, Window window, AppCompatCallback appCompatCallback) {
        this.mContext = context;
        this.mWindow = window;
        this.mAppCompatCallback = appCompatCallback;
        Window.Callback callback = this.mOriginalWindowCallback;
        if (!(callback instanceof AppCompatWindowCallbackBase)) {
            this.mAppCompatWindowCallback = wrapWindowCallback(callback);
            this.mWindow.setCallback(this.mAppCompatWindowCallback);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, sWindowBackgroundStyleable);
            Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
            if (drawableIfKnown != null) {
                this.mWindow.setBackgroundDrawable(drawableIfKnown);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* access modifiers changed from: package-private */
    public Window.Callback wrapWindowCallback(Window.Callback callback) {
        return new AppCompatWindowCallbackBase(callback);
    }

    public ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    /* access modifiers changed from: package-private */
    public final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            initWindowDecorActionBar();
            ActionBar actionBar = this.mActionBar;
            this.mMenuInflater = new SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : this.mContext);
        }
        return this.mMenuInflater;
    }

    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    /* access modifiers changed from: package-private */
    public final Context getActionBarThemedContext() {
        ActionBar supportActionBar = getSupportActionBar();
        Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
        return themedContext == null ? this.mContext : themedContext;
    }

    class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        ActionBarDrawableToggleImpl() {
        }

        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public Context getActionBarThemedContext() {
            return AppCompatDelegateImplBase.this.getActionBarThemedContext();
        }

        public boolean isNavigationVisible() {
            ActionBar supportActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar supportActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i);
            }
        }

        public void setActionBarDescription(int i) {
            ActionBar supportActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    public void onStart() {
        this.mIsStarted = true;
    }

    public void onStop() {
        this.mIsStarted = false;
    }

    public void onDestroy() {
        this.mIsDestroyed = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    /* access modifiers changed from: package-private */
    public final boolean isStarted() {
        return this.mIsStarted;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        onTitleChanged(charSequence);
    }

    /* access modifiers changed from: package-private */
    public final CharSequence getTitle() {
        Window.Callback callback = this.mOriginalWindowCallback;
        if (callback instanceof Activity) {
            return ((Activity) callback).getTitle();
        }
        return this.mTitle;
    }

    class AppCompatWindowCallbackBase extends WindowCallbackWrapper {
        public void onContentChanged() {
        }

        AppCompatWindowCallbackBase(Window.Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplBase.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImplBase.this.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImplBase.this.onMenuOpened(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImplBase.this.onPanelClosed(i, menu);
        }
    }
}

package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.UiModeManager;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatDelegateImplV14;
import android.view.ActionMode;
import android.view.Window;

@TargetApi(23)
@RequiresApi(23)
class AppCompatDelegateImplV23 extends AppCompatDelegateImplV14 {
    private final UiModeManager mUiModeManager;

    AppCompatDelegateImplV23(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.mUiModeManager = (UiModeManager) context.getSystemService("uimode");
    }

    /* access modifiers changed from: package-private */
    public Window.Callback wrapWindowCallback(Window.Callback callback) {
        return new AppCompatWindowCallbackV23(callback);
    }

    /* access modifiers changed from: package-private */
    public int mapNightMode(int i) {
        if (i == 0 && this.mUiModeManager.getNightMode() == 0) {
            return -1;
        }
        return super.mapNightMode(i);
    }

    class AppCompatWindowCallbackV23 extends AppCompatDelegateImplV14.AppCompatWindowCallbackV14 {
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        AppCompatWindowCallbackV23(Window.Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!AppCompatDelegateImplV23.this.isHandleNativeActionModesEnabled() || i != 0) {
                return super.onWindowStartingActionMode(callback, i);
            }
            return startAsSupportActionMode(callback);
        }
    }
}

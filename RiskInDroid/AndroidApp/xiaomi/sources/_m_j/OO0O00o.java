package _m_j;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class OO0O00o implements Window.Callback {
    public final Window.Callback O00000Oo;

    public OO0O00o(Window.Callback callback) {
        if (callback != null) {
            this.O00000Oo = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.O00000Oo.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.O00000Oo.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.O00000Oo.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.O00000Oo.dispatchTrackballEvent(motionEvent);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.O00000Oo.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.O00000Oo.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public View onCreatePanelView(int i) {
        return this.O00000Oo.onCreatePanelView(i);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.O00000Oo.onCreatePanelMenu(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.O00000Oo.onPreparePanel(i, view, menu);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.O00000Oo.onMenuOpened(i, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.O00000Oo.onMenuItemSelected(i, menuItem);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.O00000Oo.onWindowAttributesChanged(layoutParams);
    }

    public void onContentChanged() {
        this.O00000Oo.onContentChanged();
    }

    public void onWindowFocusChanged(boolean z) {
        this.O00000Oo.onWindowFocusChanged(z);
    }

    public void onAttachedToWindow() {
        this.O00000Oo.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.O00000Oo.onDetachedFromWindow();
    }

    public void onPanelClosed(int i, Menu menu) {
        this.O00000Oo.onPanelClosed(i, menu);
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.O00000Oo.onSearchRequested(searchEvent);
    }

    public boolean onSearchRequested() {
        return this.O00000Oo.onSearchRequested();
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.O00000Oo.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.O00000Oo.onWindowStartingActionMode(callback, i);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.O00000Oo.onActionModeStarted(actionMode);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.O00000Oo.onActionModeFinished(actionMode);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        this.O00000Oo.onProvideKeyboardShortcuts(list, menu, i);
    }

    public void onPointerCaptureChanged(boolean z) {
        this.O00000Oo.onPointerCaptureChanged(z);
    }
}

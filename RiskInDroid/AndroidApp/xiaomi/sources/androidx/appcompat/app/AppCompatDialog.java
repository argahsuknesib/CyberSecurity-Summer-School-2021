package androidx.appcompat.app;

import _m_j.O0o0000;
import _m_j.OO00O0o;
import _m_j.OoO0o;
import _m_j.bl;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;

public class AppCompatDialog extends Dialog implements OoO0o {
    private O0o0000 mDelegate;
    private final bl.O000000o mKeyDispatcher;

    public void onSupportActionModeFinished(OO00O0o oO00O0o) {
    }

    public void onSupportActionModeStarted(OO00O0o oO00O0o) {
    }

    public OO00O0o onWindowStartingSupportActionMode(OO00O0o.O000000o o000000o) {
        return null;
    }

    public AppCompatDialog(Context context) {
        this(context, 0);
    }

    public AppCompatDialog(Context context, int i) {
        super(context, getThemeResId(context, i));
        this.mKeyDispatcher = new bl.O000000o() {
            /* class androidx.appcompat.app.AppCompatDialog.AnonymousClass1 */

            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return AppCompatDialog.this.superDispatchKeyEvent(keyEvent);
            }
        };
        O0o0000 delegate = getDelegate();
        delegate.O000000o(getThemeResId(context, i));
        delegate.O00000o0();
    }

    protected AppCompatDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mKeyDispatcher = new bl.O000000o() {
            /* class androidx.appcompat.app.AppCompatDialog.AnonymousClass1 */

            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return AppCompatDialog.this.superDispatchKeyEvent(keyEvent);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getDelegate().O0000OoO();
        super.onCreate(bundle);
        getDelegate().O00000o0();
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().O000000o();
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

    public <T extends View> T findViewById(int i) {
        return getDelegate().O00000Oo(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().O000000o(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().O000000o(getContext().getString(i));
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().O00000Oo(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().O00000oo();
    }

    public void dismiss() {
        super.dismiss();
        getDelegate().O0000Oo0();
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().O00000o(i);
    }

    public void invalidateOptionsMenu() {
        getDelegate().O0000OOo();
    }

    public O0o0000 getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = O0o0000.O000000o(this, this);
        }
        return this.mDelegate;
    }

    private static int getThemeResId(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: package-private */
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return bl.O000000o(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }
}

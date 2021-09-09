package androidx.core.app;

import _m_j.bl;
import _m_j.fa;
import _m_j.fb;
import _m_j.fk;
import _m_j.o0OO00OO;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.Lifecycle;

public class ComponentActivity extends Activity implements bl.O000000o, fa {
    private o0OO00OO<Class<? extends O000000o>, O000000o> mExtraDataMap = new o0OO00OO<>();
    private fb mLifecycleRegistry = new fb(this);

    @Deprecated
    public static class O000000o {
    }

    @Deprecated
    public void putExtraData(O000000o o000000o) {
        this.mExtraDataMap.put(o000000o.getClass(), o000000o);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fk.O000000o(this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.O000000o(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public <T extends O000000o> T getExtraData(Class<T> cls) {
        return (O000000o) this.mExtraDataMap.get(cls);
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !bl.O000000o(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !bl.O000000o(decorView, keyEvent)) {
            return bl.O000000o(this, decorView, this, keyEvent);
        }
        return true;
    }
}

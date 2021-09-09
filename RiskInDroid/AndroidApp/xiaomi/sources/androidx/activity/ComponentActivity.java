package androidx.activity;

import _m_j.O0Oo;
import _m_j.ey;
import _m_j.fa;
import _m_j.fb;
import _m_j.fk;
import _m_j.fp;
import _m_j.fq;
import _m_j.ht;
import _m_j.hu;
import _m_j.hv;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.Lifecycle;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements O0Oo, fa, fq, hv {
    private int mContentLayoutId;
    private final fb mLifecycleRegistry;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final hu mSavedStateRegistryController;
    private fp mViewModelStore;

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Object f2628O000000o;
        fp O00000Oo;

        O000000o() {
        }
    }

    public ComponentActivity() {
        this.mLifecycleRegistry = new fb(this);
        this.mSavedStateRegistryController = hu.O000000o(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() {
            /* class androidx.activity.ComponentActivity.AnonymousClass1 */

            public final void run() {
                ComponentActivity.super.onBackPressed();
            }
        });
        if (getLifecycle() != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                getLifecycle().O000000o(new ey() {
                    /* class androidx.activity.ComponentActivity.AnonymousClass2 */

                    public final void O000000o(fa faVar, Lifecycle.Event event) {
                        if (event == Lifecycle.Event.ON_STOP) {
                            Window window = ComponentActivity.this.getWindow();
                            View peekDecorView = window != null ? window.peekDecorView() : null;
                            if (peekDecorView != null) {
                                peekDecorView.cancelPendingInputEvents();
                            }
                        }
                    }
                });
            }
            getLifecycle().O000000o(new ey() {
                /* class androidx.activity.ComponentActivity.AnonymousClass3 */

                public final void O000000o(fa faVar, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY && !ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.getViewModelStore().O000000o();
                    }
                }
            });
            if (19 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23) {
                getLifecycle().O000000o(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public ComponentActivity(int i) {
        this();
        this.mContentLayoutId = i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSavedStateRegistryController.O000000o(bundle);
        fk.O000000o(this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof fb) {
            ((fb) lifecycle).O000000o(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.O00000Oo(bundle);
    }

    public final Object onRetainNonConfigurationInstance() {
        O000000o o000000o;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        fp fpVar = this.mViewModelStore;
        if (fpVar == null && (o000000o = (O000000o) getLastNonConfigurationInstance()) != null) {
            fpVar = o000000o.O00000Oo;
        }
        if (fpVar == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        O000000o o000000o2 = new O000000o();
        o000000o2.f2628O000000o = onRetainCustomNonConfigurationInstance;
        o000000o2.O00000Oo = fpVar;
        return o000000o2;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        O000000o o000000o = (O000000o) getLastNonConfigurationInstance();
        if (o000000o != null) {
            return o000000o.f2628O000000o;
        }
        return null;
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public fp getViewModelStore() {
        if (getApplication() != null) {
            if (this.mViewModelStore == null) {
                O000000o o000000o = (O000000o) getLastNonConfigurationInstance();
                if (o000000o != null) {
                    this.mViewModelStore = o000000o.O00000Oo;
                }
                if (this.mViewModelStore == null) {
                    this.mViewModelStore = new fp();
                }
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.O000000o();
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final ht getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f690O000000o;
    }
}

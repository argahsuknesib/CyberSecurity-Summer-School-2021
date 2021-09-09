package com.xiaomi.smarthome.newui.page;

import _m_j.OO0O00o;
import _m_j.ee;
import _m_j.ei;
import _m_j.ez;
import _m_j.fa;
import _m_j.fi;
import _m_j.hgo;
import _m_j.ixe;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u001a\b&\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\"H\u0017J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020\t2\u0006\u0010$\u001a\u00020'H\u0004J\u0016\u0010(\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\rJ\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\tH\u0014J\b\u0010-\u001a\u00020\tH\u0014J\b\u0010.\u001a\u00020\"H\u0014J\u0010\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\"2\u0006\u00103\u001a\u000204H\u0015J\u0010\u00105\u001a\u00020\r2\u0006\u00106\u001a\u000207H$J\u0010\u00108\u001a\u00020\"2\u0006\u00103\u001a\u000204H\u0015J\u0010\u00109\u001a\u00020\"2\u0006\u00103\u001a\u000204H\u0015J\u0010\u0010:\u001a\u00020\"2\u0006\u00103\u001a\u000204H\u0015J\u0010\u0010;\u001a\u00020\"2\u0006\u00103\u001a\u000204H\u0015J\u0010\u0010<\u001a\u00020\"2\u0006\u00103\u001a\u000204H\u0015J\u0006\u0010=\u001a\u00020\"J\b\u0010>\u001a\u00020\"H\u0002J\b\u0010?\u001a\u00020\"H\u0017J\b\u0010@\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/IPage;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/xiaomi/smarthome/newui/page/ConfigurationObserverFragment2$OnConfigurationChangeListener;", "base", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "configurationObserverTag", "", "isDestroy", "", "originWindowCallback", "Landroid/view/Window$Callback;", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "touchOffsetX", "", "touchOffsetY", "wrappedCallback", "calcMenuMaxHeight", "", "()Ljava/lang/Integer;", "createWrapperCallback", "com/xiaomi/smarthome/newui/page/IPage$createWrapperCallback$1", "originCallback", "(Landroid/view/Window$Callback;)Lcom/xiaomi/smarthome/newui/page/IPage$createWrapperCallback$1;", "dip2px", "context", "Landroid/content/Context;", "dpValue", "dismiss", "", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "Landroid/view/MotionEvent;", "getMenuMaxHeight", "decor", "injectConfigurationChangeObserverIfNeededIn", "install", "interceptKeyEvent", "interceptTouchEvent", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onCreateView", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "releaseWindowCallback", "removeConfigurationObserverIfNeeded", "show", "uninstall", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class IPage implements ez, hgo.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private Window.Callback f10268O000000o;
    private Window.Callback O00000Oo;
    final FragmentActivity O00000o;
    private boolean O00000o0;
    public View O00000oO;
    float O00000oo;
    float O0000O0o;
    private final String O0000OOo = ixe.O000000o("com.xiaomi.smarthome.newui.page.ConfigurationObserverFragment : ", (Object) Integer.valueOf(hashCode()));

    /* access modifiers changed from: protected */
    public abstract View O000000o(ViewGroup viewGroup);

    public void O000000o(Configuration configuration) {
        ixe.O00000o(configuration, "newConfig");
    }

    /* access modifiers changed from: protected */
    public boolean O00000o() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean O0000O0o() {
        return true;
    }

    /* access modifiers changed from: protected */
    @fi(O000000o = Lifecycle.Event.ON_CREATE)
    public void onCreate(fa faVar) {
        ixe.O00000o(faVar, "owner");
    }

    /* access modifiers changed from: protected */
    @fi(O000000o = Lifecycle.Event.ON_PAUSE)
    public void onPause(fa faVar) {
        ixe.O00000o(faVar, "owner");
    }

    /* access modifiers changed from: protected */
    @fi(O000000o = Lifecycle.Event.ON_START)
    public void onResume(fa faVar) {
        ixe.O00000o(faVar, "owner");
    }

    /* access modifiers changed from: protected */
    @fi(O000000o = Lifecycle.Event.ON_START)
    public void onStart(fa faVar) {
        ixe.O00000o(faVar, "owner");
    }

    /* access modifiers changed from: protected */
    @fi(O000000o = Lifecycle.Event.ON_STOP)
    public void onStop(fa faVar) {
        ixe.O00000o(faVar, "owner");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public IPage(FragmentActivity fragmentActivity) {
        ixe.O00000o(fragmentActivity, "base");
        this.O00000o = fragmentActivity;
    }

    public Integer O00000o0() {
        return Integer.valueOf(O000000o(this.O00000o, 360.0f));
    }

    public void e_() {
        if (this.O00000o0) {
            O00000Oo();
            return;
        }
        if (this.f10268O000000o == null) {
            this.O00000o.getLifecycle().O000000o(this);
            Window.Callback callback = this.O00000o.getWindow().getCallback();
            if (callback == null) {
                callback = this.O00000o;
            }
            this.O00000Oo = callback;
            this.f10268O000000o = new O000000o(this, callback);
            this.O00000o.getWindow().setCallback(this.f10268O000000o);
            ee supportFragmentManager = this.O00000o.getSupportFragmentManager();
            ixe.O00000Oo(supportFragmentManager, "base.supportFragmentManager");
            if (supportFragmentManager.O000000o(this.O0000OOo) == null && !supportFragmentManager.O0000O0o()) {
                hgo hgo = new hgo();
                hgo.f18900O000000o = this;
                ei O000000o2 = supportFragmentManager.O000000o();
                O000000o2.O000000o(hgo, this.O0000OOo);
                O000000o2.O00000o0();
            }
        }
        ViewGroup viewGroup = (ViewGroup) this.O00000o.findViewById(16908290);
        ixe.O00000Oo(viewGroup, "container");
        this.O00000oO = O000000o(viewGroup);
        viewGroup.addView(this.O00000oO);
    }

    public void O00000Oo() {
        if (this.O00000oO != null) {
            ((ViewGroup) this.O00000o.findViewById(16908290)).removeView(this.O00000oO);
        }
        O00000oo();
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/xiaomi/smarthome/newui/page/IPage$createWrapperCallback$1", "Landroidx/appcompat/view/WindowCallbackWrapper;", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "Landroid/view/MotionEvent;", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o extends OO0O00o {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ IPage f10269O000000o;
        final /* synthetic */ Window.Callback O00000o0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O000000o(IPage iPage, Window.Callback callback) {
            super(callback);
            this.f10269O000000o = iPage;
            this.O00000o0 = callback;
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            ixe.O00000o(keyEvent, "event");
            if (!this.f10269O000000o.O0000O0o()) {
                return this.O00000o0.dispatchKeyEvent(keyEvent);
            }
            IPage iPage = this.f10269O000000o;
            ixe.O00000o(keyEvent, "event");
            if (4 != keyEvent.getKeyCode()) {
                return true;
            }
            iPage.O00000Oo();
            return true;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            ixe.O00000o(motionEvent, "event");
            if (!this.f10269O000000o.O00000o()) {
                return this.O00000o0.dispatchTouchEvent(motionEvent);
            }
            IPage iPage = this.f10269O000000o;
            ixe.O00000o(motionEvent, "event");
            View view = iPage.O00000oO;
            if (view == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                View decorView = iPage.O00000o.getWindow().getDecorView();
                ixe.O00000Oo(decorView, "base.window.decorView");
                iPage.O00000oo = ((float) decorView.getScrollX()) - ((float) view.getLeft());
                iPage.O0000O0o = ((float) decorView.getScrollY()) - ((float) view.getTop());
            }
            motionEvent.offsetLocation(iPage.O00000oo, iPage.O0000O0o);
            return view.dispatchTouchEvent(motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000oo() {
        this.O00000o.getLifecycle().O00000Oo(this);
        Window.Callback callback = this.O00000Oo;
        if (callback != null) {
            this.O00000o.getWindow().setCallback(callback);
            this.O00000Oo = null;
        }
        this.f10268O000000o = null;
        O00000oO();
    }

    /* access modifiers changed from: protected */
    @fi(O000000o = Lifecycle.Event.ON_DESTROY)
    public void onDestroy(fa faVar) {
        ixe.O00000o(faVar, "owner");
        O00000Oo();
        this.O00000o0 = true;
    }

    private final void O00000oO() {
        ee supportFragmentManager = this.O00000o.getSupportFragmentManager();
        ixe.O00000Oo(supportFragmentManager, "base.supportFragmentManager");
        Fragment O000000o2 = supportFragmentManager.O000000o(this.O0000OOo);
        if (O000000o2 != null && !supportFragmentManager.O0000O0o()) {
            ei O000000o3 = this.O00000o.getSupportFragmentManager().O000000o();
            O000000o3.O000000o(O000000o2);
            O000000o3.O00000o0();
        }
    }

    public final int O000000o(Context context, View view) {
        int i;
        ixe.O00000o(context, "context");
        ixe.O00000o(view, "decor");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            int O000000o2 = (displayMetrics.heightPixels - rect.top) - O000000o(context, 76.0f);
            Integer O00000o02 = O00000o0();
            if (O00000o02 == null) {
                i = 0;
            } else {
                i = O00000o02.intValue();
            }
            if (O000000o2 <= i) {
                return O000000o2;
            }
            if (O00000o02 == null) {
                return 0;
            }
            return O00000o02.intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    private static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}

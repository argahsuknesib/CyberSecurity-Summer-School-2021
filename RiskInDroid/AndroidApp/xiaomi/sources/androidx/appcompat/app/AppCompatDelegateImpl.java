package androidx.appcompat.app;

import _m_j.O0o;
import _m_j.O0o0;
import _m_j.O0o00;
import _m_j.O0o0000;
import _m_j.OO0000;
import _m_j.OO0000o;
import _m_j.OO00O0o;
import _m_j.OO00OOO;
import _m_j.OO00Oo0;
import _m_j.OO0O00o;
import _m_j.OO0o00;
import _m_j.OO0o000;
import _m_j.OOO0o0;
import _m_j.OOOOO00;
import _m_j.OOo000;
import _m_j.Oo;
import _m_j.Oo0OOo;
import _m_j.OoO0o;
import _m_j.OooOO;
import _m_j.bd;
import _m_j.bl;
import _m_j.bm;
import _m_j.bw;
import _m_j.cb;
import _m_j.ce;
import _m_j.cf;
import _m_j.cg;
import _m_j.ci;
import _m_j.cw;
import _m_j.fa;
import _m_j.g;
import _m_j.m;
import _m_j.o00;
import _m_j.o000;
import _m_j.o0OO00OO;
import _m_j.oOOO00o0;
import _m_j.oOOO0o00;
import _m_j.ooO0Ooo;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import com.xiaomi.smarthome.R;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public final class AppCompatDelegateImpl extends O0o0000 implements LayoutInflater.Factory2, MenuBuilder.O000000o {
    private static final o0OO00OO<String, Integer> O0000ooo = new o0OO00OO<>();
    private static final boolean O000O00o = (!"robolectric".equals(Build.FINGERPRINT));
    private static final boolean O000O0OO;
    private static boolean O000O0Oo = true;
    private static final boolean O00oOooO = (Build.VERSION.SDK_INT < 21);
    private static final int[] O00oOooo = {16842836};
    final Object O00000o;
    final Context O00000oO;
    Window O00000oo;
    final OoO0o O0000O0o;
    ActionBar O0000OOo;
    OO00O0o O0000Oo;
    MenuInflater O0000Oo0;
    ActionBarContextView O0000OoO;
    PopupWindow O0000Ooo;
    boolean O0000o;
    ce O0000o0;
    Runnable O0000o00;
    boolean O0000o0O;
    ViewGroup O0000o0o;
    boolean O0000oO;
    boolean O0000oO0;
    boolean O0000oOO;
    boolean O0000oOo;
    boolean O0000oo;
    boolean O0000oo0;
    int O0000ooO;
    private OOOOO00 O000O0o;
    private CharSequence O000O0o0;
    private O00000Oo O000O0oO;
    private O0000o00 O000O0oo;
    private View O000OO;
    private boolean O000OO00;
    private TextView O000OO0o;
    private boolean O000OOOo;
    private boolean O000OOo;
    private boolean O000OOo0;
    private PanelFeatureState[] O000OOoO;
    private PanelFeatureState O000OOoo;
    private boolean O000Oo0;
    private boolean O000Oo00;
    private boolean O000Oo0O;
    private boolean O000Oo0o;
    private boolean O000OoO;
    private int O000OoO0;
    private boolean O000OoOO;
    private O0000OOo O000OoOo;
    private final Runnable O000Ooo;
    private O0000OOo O000Ooo0;
    private boolean O000OooO;
    private Rect O000Oooo;
    private O0o00 O000o00;
    private Rect O000o000;
    private int O00O0Oo;
    private O00000o O00oOoOo;

    static {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 17) {
            z = true;
        }
        O000O0OO = z;
        if (O00oOooO && !O000O0Oo) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass1 */

                public final void uncaughtException(Thread thread, Throwable th) {
                    String message;
                    boolean z = false;
                    if ((th instanceof Resources.NotFoundException) && (message = th.getMessage()) != null && (message.contains("drawable") || message.contains("Drawable"))) {
                        z = true;
                    }
                    if (z) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    public AppCompatDelegateImpl(Activity activity, OoO0o ooO0o) {
        this(activity, null, ooO0o, activity);
    }

    public AppCompatDelegateImpl(Dialog dialog, OoO0o ooO0o) {
        this(dialog.getContext(), dialog.getWindow(), ooO0o, dialog);
    }

    private AppCompatDelegateImpl(Context context, Window window, OoO0o ooO0o, Object obj) {
        Integer num;
        AppCompatActivity appCompatActivity = null;
        this.O0000o0 = null;
        this.O0000o0O = true;
        this.O000OoO0 = -100;
        this.O000Ooo = new Runnable() {
            /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass2 */

            public final void run() {
                if ((AppCompatDelegateImpl.this.O0000ooO & 1) != 0) {
                    AppCompatDelegateImpl.this.O0000O0o(0);
                }
                if ((AppCompatDelegateImpl.this.O0000ooO & 4096) != 0) {
                    AppCompatDelegateImpl.this.O0000O0o(108);
                }
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.O0000oo = false;
                appCompatDelegateImpl.O0000ooO = 0;
            }
        };
        this.O00000oO = context;
        this.O0000O0o = ooO0o;
        this.O00000o = obj;
        if (this.O000OoO0 == -100 && (this.O00000o instanceof Dialog)) {
            Context context2 = this.O00000oO;
            while (true) {
                if (context2 != null) {
                    if (!(context2 instanceof AppCompatActivity)) {
                        if (!(context2 instanceof ContextWrapper)) {
                            break;
                        }
                        context2 = ((ContextWrapper) context2).getBaseContext();
                    } else {
                        appCompatActivity = (AppCompatActivity) context2;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (appCompatActivity != null) {
                this.O000OoO0 = appCompatActivity.getDelegate().O0000o00();
            }
        }
        if (this.O000OoO0 == -100 && (num = O0000ooo.get(this.O00000o.getClass().getName())) != null) {
            this.O000OoO0 = num.intValue();
            O0000ooo.remove(this.O00000o.getClass().getName());
        }
        if (window != null) {
            O000000o(window);
        }
        OOO0o0.O000000o();
    }

    public final Context O000000o(Context context) {
        this.O000Oo0 = true;
        int O000000o2 = O000000o(context, O000O00o());
        Configuration configuration = null;
        if (O000O0OO && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(O000000o(context, O000000o2, (Configuration) null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            try {
                ((androidx.appcompat.view.ContextThemeWrapper) context).applyOverrideConfiguration(O000000o(context, O000000o2, (Configuration) null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!O000O00o) {
            return super.O000000o(context);
        }
        try {
            Configuration configuration2 = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration3 = context.getResources().getConfiguration();
            if (!configuration2.equals(configuration3)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (!(configuration3 == null || configuration2.diff(configuration3) == 0)) {
                    if (configuration2.fontScale != configuration3.fontScale) {
                        configuration.fontScale = configuration3.fontScale;
                    }
                    if (configuration2.mcc != configuration3.mcc) {
                        configuration.mcc = configuration3.mcc;
                    }
                    if (configuration2.mnc != configuration3.mnc) {
                        configuration.mnc = configuration3.mnc;
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        LocaleList locales = configuration2.getLocales();
                        LocaleList locales2 = configuration3.getLocales();
                        if (!locales.equals(locales2)) {
                            configuration.setLocales(locales2);
                            configuration.locale = configuration3.locale;
                        }
                    } else if (!bd.O000000o(configuration2.locale, configuration3.locale)) {
                        configuration.locale = configuration3.locale;
                    }
                    if (configuration2.touchscreen != configuration3.touchscreen) {
                        configuration.touchscreen = configuration3.touchscreen;
                    }
                    if (configuration2.keyboard != configuration3.keyboard) {
                        configuration.keyboard = configuration3.keyboard;
                    }
                    if (configuration2.keyboardHidden != configuration3.keyboardHidden) {
                        configuration.keyboardHidden = configuration3.keyboardHidden;
                    }
                    if (configuration2.navigation != configuration3.navigation) {
                        configuration.navigation = configuration3.navigation;
                    }
                    if (configuration2.navigationHidden != configuration3.navigationHidden) {
                        configuration.navigationHidden = configuration3.navigationHidden;
                    }
                    if (configuration2.orientation != configuration3.orientation) {
                        configuration.orientation = configuration3.orientation;
                    }
                    if ((configuration2.screenLayout & 15) != (configuration3.screenLayout & 15)) {
                        configuration.screenLayout |= configuration3.screenLayout & 15;
                    }
                    if ((configuration2.screenLayout & 192) != (configuration3.screenLayout & 192)) {
                        configuration.screenLayout |= configuration3.screenLayout & 192;
                    }
                    if ((configuration2.screenLayout & 48) != (configuration3.screenLayout & 48)) {
                        configuration.screenLayout |= configuration3.screenLayout & 48;
                    }
                    if ((configuration2.screenLayout & 768) != (configuration3.screenLayout & 768)) {
                        configuration.screenLayout |= configuration3.screenLayout & 768;
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        if ((configuration2.colorMode & 3) != (configuration3.colorMode & 3)) {
                            configuration.colorMode |= configuration3.colorMode & 3;
                        }
                        if ((configuration2.colorMode & 12) != (configuration3.colorMode & 12)) {
                            configuration.colorMode |= configuration3.colorMode & 12;
                        }
                    }
                    if ((configuration2.uiMode & 15) != (configuration3.uiMode & 15)) {
                        configuration.uiMode |= configuration3.uiMode & 15;
                    }
                    if ((configuration2.uiMode & 48) != (configuration3.uiMode & 48)) {
                        configuration.uiMode |= configuration3.uiMode & 48;
                    }
                    if (configuration2.screenWidthDp != configuration3.screenWidthDp) {
                        configuration.screenWidthDp = configuration3.screenWidthDp;
                    }
                    if (configuration2.screenHeightDp != configuration3.screenHeightDp) {
                        configuration.screenHeightDp = configuration3.screenHeightDp;
                    }
                    if (configuration2.smallestScreenWidthDp != configuration3.smallestScreenWidthDp) {
                        configuration.smallestScreenWidthDp = configuration3.smallestScreenWidthDp;
                    }
                    if (Build.VERSION.SDK_INT >= 17 && configuration2.densityDpi != configuration3.densityDpi) {
                        configuration.densityDpi = configuration3.densityDpi;
                    }
                }
            }
            Configuration O000000o3 = O000000o(context, O000000o2, configuration);
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 2132738831);
            contextThemeWrapper.applyOverrideConfiguration(O000000o3);
            boolean z = false;
            try {
                if (context.getTheme() != null) {
                    z = true;
                }
            } catch (NullPointerException unused3) {
            }
            if (z) {
                Resources.Theme theme = contextThemeWrapper.getTheme();
                if (Build.VERSION.SDK_INT >= 29) {
                    theme.rebase();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    m.O00000Oo.O000000o.O000000o(theme);
                }
            }
            return super.O000000o(contextThemeWrapper);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Application failed to obtain resources from itself", e);
        }
    }

    public final void O00000o0() {
        this.O000Oo0 = true;
        O000000o(false);
        O0000oo0();
        Object obj = this.O00000o;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = oOOO0o00.O00000Oo((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar actionBar = this.O0000OOo;
                if (actionBar == null) {
                    this.O000OooO = true;
                } else {
                    actionBar.O00000Oo(true);
                }
            }
            synchronized (O0o0000.O00000o0) {
                O0o0000.O000000o(this);
                O0o0000.O00000Oo.add(new WeakReference(this));
            }
        }
        this.O000Oo0O = true;
    }

    public final void O00000o() {
        O0000oo();
    }

    public final ActionBar O000000o() {
        O0000oOO();
        return this.O0000OOo;
    }

    private void O0000oOO() {
        O0000oo();
        if (this.O0000o && this.O0000OOo == null) {
            Object obj = this.O00000o;
            if (obj instanceof Activity) {
                this.O0000OOo = new OO0000((Activity) obj, this.O0000oO0);
            } else if (obj instanceof Dialog) {
                this.O0000OOo = new OO0000((Dialog) obj);
            }
            ActionBar actionBar = this.O0000OOo;
            if (actionBar != null) {
                actionBar.O00000Oo(this.O000OooO);
            }
        }
    }

    public final void O000000o(Toolbar toolbar) {
        if (this.O00000o instanceof Activity) {
            ActionBar O000000o2 = O000000o();
            if (!(O000000o2 instanceof OO0000)) {
                this.O0000Oo0 = null;
                if (O000000o2 != null) {
                    O000000o2.O0000OoO();
                }
                if (toolbar != null) {
                    O0o o0o = new O0o(toolbar, O00oOooO(), this.O00oOoOo);
                    this.O0000OOo = o0o;
                    this.O00000oo.setCallback(o0o.O00000o0);
                } else {
                    this.O0000OOo = null;
                    this.O00000oo.setCallback(this.O00oOoOo);
                }
                O0000OOo();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    private Context O0000oOo() {
        ActionBar O000000o2 = O000000o();
        Context O00000oO2 = O000000o2 != null ? O000000o2.O00000oO() : null;
        return O00000oO2 == null ? this.O00000oO : O00000oO2;
    }

    public final MenuInflater O00000Oo() {
        if (this.O0000Oo0 == null) {
            O0000oOO();
            ActionBar actionBar = this.O0000OOo;
            this.O0000Oo0 = new SupportMenuInflater(actionBar != null ? actionBar.O00000oO() : this.O00000oO);
        }
        return this.O0000Oo0;
    }

    public final <T extends View> T O00000Oo(int i) {
        O0000oo();
        return this.O00000oo.findViewById(i);
    }

    public final void O000000o(Configuration configuration) {
        ActionBar O000000o2;
        if (this.O0000o && this.O000OO00 && (O000000o2 = O000000o()) != null) {
            O000000o2.O000000o(configuration);
        }
        OOO0o0.O00000Oo().O000000o(this.O00000oO);
        O000000o(false);
    }

    public final void O00000oO() {
        this.O000Oo0o = true;
        O000000o(true);
    }

    public final void O00000oo() {
        this.O000Oo0o = false;
        ActionBar O000000o2 = O000000o();
        if (O000000o2 != null) {
            O000000o2.O00000o0(false);
        }
    }

    public final void O0000O0o() {
        ActionBar O000000o2 = O000000o();
        if (O000000o2 != null) {
            O000000o2.O00000o0(true);
        }
    }

    public final void O000000o(View view) {
        O0000oo();
        ViewGroup viewGroup = (ViewGroup) this.O0000o0o.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.O00oOoOo.O00000Oo.onContentChanged();
    }

    public final void O00000o0(int i) {
        O0000oo();
        ViewGroup viewGroup = (ViewGroup) this.O0000o0o.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.O00000oO).inflate(i, viewGroup);
        this.O00oOoOo.O00000Oo.onContentChanged();
    }

    public final void O000000o(View view, ViewGroup.LayoutParams layoutParams) {
        O0000oo();
        ViewGroup viewGroup = (ViewGroup) this.O0000o0o.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.O00oOoOo.O00000Oo.onContentChanged();
    }

    public final void O00000Oo(View view, ViewGroup.LayoutParams layoutParams) {
        O0000oo();
        ((ViewGroup) this.O0000o0o.findViewById(16908290)).addView(view, layoutParams);
        this.O00oOoOo.O00000Oo.onContentChanged();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    public final void O0000Oo0() {
        ActionBar actionBar;
        O0000OOo o0000OOo;
        O0000OOo o0000OOo2;
        if (this.O00000o instanceof Activity) {
            synchronized (O0o0000.O00000o0) {
                O0o0000.O000000o(this);
            }
        }
        if (this.O0000oo) {
            this.O00000oo.getDecorView().removeCallbacks(this.O000Ooo);
        }
        this.O000Oo0o = false;
        this.O0000oo0 = true;
        if (this.O000OoO0 != -100) {
            Object obj = this.O00000o;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                O0000ooo.put(this.O00000o.getClass().getName(), Integer.valueOf(this.O000OoO0));
                actionBar = this.O0000OOo;
                if (actionBar != null) {
                    actionBar.O0000OoO();
                }
                o0000OOo = this.O000OoOo;
                if (o0000OOo != null) {
                    o0000OOo.O00000oO();
                }
                o0000OOo2 = this.O000Ooo0;
                if (o0000OOo2 == null) {
                    o0000OOo2.O00000oO();
                    return;
                }
                return;
            }
        }
        O0000ooo.remove(this.O00000o.getClass().getName());
        actionBar = this.O0000OOo;
        if (actionBar != null) {
        }
        o0000OOo = this.O000OoOo;
        if (o0000OOo != null) {
        }
        o0000OOo2 = this.O000Ooo0;
        if (o0000OOo2 == null) {
        }
    }

    public final void O000000o(int i) {
        this.O00O0Oo = i;
    }

    private void O0000oo0() {
        if (this.O00000oo == null) {
            Object obj = this.O00000o;
            if (obj instanceof Activity) {
                O000000o(((Activity) obj).getWindow());
            }
        }
        if (this.O00000oo == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private void O000000o(Window window) {
        if (this.O00000oo == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof O00000o)) {
                this.O00oOoOo = new O00000o(callback);
                window.setCallback(this.O00oOoOo);
                Oo O000000o2 = Oo.O000000o(this.O00000oO, (AttributeSet) null, O00oOooo);
                Drawable O00000Oo2 = O000000o2.O00000Oo(0);
                if (O00000Oo2 != null) {
                    window.setBackgroundDrawable(O00000Oo2);
                }
                O000000o2.f12340O000000o.recycle();
                this.O00000oo = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private void O0000oo() {
        if (!this.O000OO00) {
            this.O0000o0o = O0000ooO();
            CharSequence O00oOooO2 = O00oOooO();
            if (!TextUtils.isEmpty(O00oOooO2)) {
                OOOOO00 ooooo00 = this.O000O0o;
                if (ooooo00 != null) {
                    ooooo00.setWindowTitle(O00oOooO2);
                } else {
                    ActionBar actionBar = this.O0000OOo;
                    if (actionBar != null) {
                        actionBar.O00000Oo(O00oOooO2);
                    } else {
                        TextView textView = this.O000OO0o;
                        if (textView != null) {
                            textView.setText(O00oOooO2);
                        }
                    }
                }
            }
            O0000ooo();
            this.O000OO00 = true;
            PanelFeatureState O00000oo2 = O00000oo(0);
            if (this.O0000oo0) {
                return;
            }
            if (O00000oo2 == null || O00000oo2.O0000Oo == null) {
                O0000OOo(108);
            }
        }
    }

    private ViewGroup O0000ooO() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.O00000oO.obtainStyledAttributes(new int[]{16842839, 16842926, R.attr.actionBarDivider, R.attr.actionBarItemBackground, R.attr.actionBarPopupTheme, R.attr.actionBarSize, R.attr.actionBarSplitStyle, R.attr.actionBarStyle, R.attr.actionBarTabBarStyle, R.attr.actionBarTabStyle, R.attr.actionBarTabTextStyle, R.attr.actionBarTheme, R.attr.actionBarWidgetTheme, R.attr.actionButtonStyle, R.attr.actionDropDownStyle, R.attr.actionMenuTextAppearance, R.attr.actionMenuTextColor, R.attr.actionModeBackground, R.attr.actionModeCloseButtonStyle, R.attr.actionModeCloseDrawable, R.attr.actionModeCopyDrawable, R.attr.actionModeCutDrawable, R.attr.actionModeFindDrawable, R.attr.actionModePasteDrawable, R.attr.actionModePopupWindowStyle, R.attr.actionModeSelectAllDrawable, R.attr.actionModeShareDrawable, R.attr.actionModeSplitBackground, R.attr.actionModeStyle, R.attr.actionModeWebSearchDrawable, R.attr.actionOverflowButtonStyle, R.attr.actionOverflowMenuStyle, R.attr.activityChooserViewStyle, R.attr.alertDialogButtonGroupStyle, R.attr.alertDialogCenterButtons, R.attr.alertDialogStyle, R.attr.alertDialogTheme, R.attr.autoCompleteTextViewStyle, R.attr.borderlessButtonStyle, R.attr.buttonBarButtonStyle, R.attr.buttonBarNegativeButtonStyle, R.attr.buttonBarNeutralButtonStyle, R.attr.buttonBarPositiveButtonStyle, R.attr.buttonBarStyle, R.attr.buttonStyle, R.attr.buttonStyleSmall, R.attr.checkboxStyle, R.attr.checkedTextViewStyle, R.attr.colorAccent, R.attr.colorBackgroundFloating, R.attr.colorButtonNormal, R.attr.colorControlActivated, R.attr.colorControlHighlight, R.attr.colorControlNormal, R.attr.colorError, R.attr.colorPrimary, R.attr.colorPrimaryDark, R.attr.colorSwitchThumbNormal, R.attr.controlBackground, R.attr.dialogCornerRadius, R.attr.dialogPreferredPadding, R.attr.dialogTheme, R.attr.dividerHorizontal, R.attr.dividerVertical, R.attr.dropDownListViewStyle, R.attr.dropdownListPreferredItemHeight, R.attr.editTextBackground, R.attr.editTextColor, R.attr.editTextStyle, R.attr.homeAsUpIndicator, R.attr.imageButtonStyle, R.attr.listChoiceBackgroundIndicator, R.attr.listChoiceIndicatorMultipleAnimated, R.attr.listChoiceIndicatorSingleAnimated, R.attr.listDividerAlertDialog, R.attr.listMenuViewStyle, R.attr.listPopupWindowStyle, R.attr.listPreferredItemHeight, R.attr.listPreferredItemHeightLarge, R.attr.listPreferredItemHeightSmall, R.attr.listPreferredItemPaddingEnd, R.attr.listPreferredItemPaddingLeft, R.attr.listPreferredItemPaddingRight, R.attr.listPreferredItemPaddingStart, R.attr.panelBackground, R.attr.panelMenuListTheme, R.attr.panelMenuListWidth, R.attr.popupMenuStyle, R.attr.popupWindowStyle, R.attr.radioButtonStyle, R.attr.ratingBarStyle, R.attr.ratingBarStyleIndicator, R.attr.ratingBarStyleSmall, R.attr.searchViewStyle, R.attr.seekBarStyle, R.attr.selectableItemBackground, R.attr.selectableItemBackgroundBorderless, R.attr.spinnerDropDownItemStyle, R.attr.spinnerStyle, R.attr.switchStyle, R.attr.textAppearanceLargePopupMenu, R.attr.textAppearanceListItem, R.attr.textAppearanceListItemSecondary, R.attr.textAppearanceListItemSmall, R.attr.textAppearancePopupMenuHeader, R.attr.textAppearanceSearchResultSubtitle, R.attr.textAppearanceSearchResultTitle, R.attr.textAppearanceSmallPopupMenu, R.attr.textColorAlertDialogListItem, R.attr.textColorSearchUrl, R.attr.toolbarNavigationButtonStyle, R.attr.toolbarStyle, R.attr.tooltipForegroundColor, R.attr.tooltipFrameBackground, R.attr.viewInflaterClass, R.attr.windowActionBar, R.attr.windowActionBarOverlay, R.attr.windowActionModeOverlay, R.attr.windowFixedHeightMajor, R.attr.windowFixedHeightMinor, R.attr.windowFixedWidthMajor, R.attr.windowFixedWidthMinor, R.attr.windowMinWidthMajor, R.attr.windowMinWidthMinor, R.attr.windowNoTitle});
        if (obtainStyledAttributes.hasValue(115)) {
            if (obtainStyledAttributes.getBoolean(124, false)) {
                O00000o(1);
            } else if (obtainStyledAttributes.getBoolean(115, false)) {
                O00000o(108);
            }
            if (obtainStyledAttributes.getBoolean(116, false)) {
                O00000o(109);
            }
            if (obtainStyledAttributes.getBoolean(117, false)) {
                O00000o(10);
            }
            this.O0000oOO = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
            O0000oo0();
            this.O00000oo.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.O00000oO);
            if (this.O0000oOo) {
                viewGroup = this.O0000oO ? (ViewGroup) from.inflate((int) R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate((int) R.layout.abc_screen_simple, (ViewGroup) null);
            } else if (this.O0000oOO) {
                viewGroup = (ViewGroup) from.inflate((int) R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.O0000oO0 = false;
                this.O0000o = false;
            } else if (this.O0000o) {
                TypedValue typedValue = new TypedValue();
                this.O00000oO.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new androidx.appcompat.view.ContextThemeWrapper(this.O00000oO, typedValue.resourceId);
                } else {
                    context = this.O00000oO;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate((int) R.layout.abc_screen_toolbar, (ViewGroup) null);
                this.O000O0o = (OOOOO00) viewGroup.findViewById(R.id.decor_content_parent);
                this.O000O0o.setWindowCallback(this.O00000oo.getCallback());
                if (this.O0000oO0) {
                    this.O000O0o.O000000o(109);
                }
                if (this.O000OOOo) {
                    this.O000O0o.O000000o(2);
                }
                if (this.O000OOo0) {
                    this.O000O0o.O000000o(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    cb.O000000o(viewGroup, new bw() {
                        /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass3 */

                        public final ci onApplyWindowInsets(View view, ci ciVar) {
                            int i = ciVar.O00000Oo.O0000O0o().O00000o0;
                            int O000000o2 = AppCompatDelegateImpl.this.O000000o(ciVar, (Rect) null);
                            if (i != O000000o2) {
                                ciVar = ciVar.O000000o(ciVar.O00000Oo.O0000O0o().O00000Oo, O000000o2, ciVar.O00000Oo.O0000O0o().O00000o, ciVar.O00000Oo.O0000O0o().O00000oO);
                            }
                            return cb.O000000o(view, ciVar);
                        }
                    });
                } else if (viewGroup instanceof OOo000) {
                    ((OOo000) viewGroup).setOnFitSystemWindowsListener(new OOo000.O000000o() {
                        /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass4 */

                        public final void O000000o(Rect rect) {
                            rect.top = AppCompatDelegateImpl.this.O000000o((ci) null, rect);
                        }
                    });
                }
                if (this.O000O0o == null) {
                    this.O000OO0o = (TextView) viewGroup.findViewById(R.id.title);
                }
                o00.O00000Oo(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.O00000oo.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.O00000oo.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.O000000o() {
                    /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass5 */

                    public final void O000000o() {
                        AppCompatDelegateImpl.this.O0000oO();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.O0000o + ", windowActionBarOverlay: " + this.O0000oO0 + ", android:windowIsFloating: " + this.O0000oOO + ", windowActionModeOverlay: " + this.O0000oO + ", windowNoTitle: " + this.O0000oOo + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void O0000ooo() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.O0000o0o.findViewById(16908290);
        View decorView = this.O00000oo.getDecorView();
        contentFrameLayout.O000000o(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.O00000oO.obtainStyledAttributes(new int[]{16842839, 16842926, R.attr.actionBarDivider, R.attr.actionBarItemBackground, R.attr.actionBarPopupTheme, R.attr.actionBarSize, R.attr.actionBarSplitStyle, R.attr.actionBarStyle, R.attr.actionBarTabBarStyle, R.attr.actionBarTabStyle, R.attr.actionBarTabTextStyle, R.attr.actionBarTheme, R.attr.actionBarWidgetTheme, R.attr.actionButtonStyle, R.attr.actionDropDownStyle, R.attr.actionMenuTextAppearance, R.attr.actionMenuTextColor, R.attr.actionModeBackground, R.attr.actionModeCloseButtonStyle, R.attr.actionModeCloseDrawable, R.attr.actionModeCopyDrawable, R.attr.actionModeCutDrawable, R.attr.actionModeFindDrawable, R.attr.actionModePasteDrawable, R.attr.actionModePopupWindowStyle, R.attr.actionModeSelectAllDrawable, R.attr.actionModeShareDrawable, R.attr.actionModeSplitBackground, R.attr.actionModeStyle, R.attr.actionModeWebSearchDrawable, R.attr.actionOverflowButtonStyle, R.attr.actionOverflowMenuStyle, R.attr.activityChooserViewStyle, R.attr.alertDialogButtonGroupStyle, R.attr.alertDialogCenterButtons, R.attr.alertDialogStyle, R.attr.alertDialogTheme, R.attr.autoCompleteTextViewStyle, R.attr.borderlessButtonStyle, R.attr.buttonBarButtonStyle, R.attr.buttonBarNegativeButtonStyle, R.attr.buttonBarNeutralButtonStyle, R.attr.buttonBarPositiveButtonStyle, R.attr.buttonBarStyle, R.attr.buttonStyle, R.attr.buttonStyleSmall, R.attr.checkboxStyle, R.attr.checkedTextViewStyle, R.attr.colorAccent, R.attr.colorBackgroundFloating, R.attr.colorButtonNormal, R.attr.colorControlActivated, R.attr.colorControlHighlight, R.attr.colorControlNormal, R.attr.colorError, R.attr.colorPrimary, R.attr.colorPrimaryDark, R.attr.colorSwitchThumbNormal, R.attr.controlBackground, R.attr.dialogCornerRadius, R.attr.dialogPreferredPadding, R.attr.dialogTheme, R.attr.dividerHorizontal, R.attr.dividerVertical, R.attr.dropDownListViewStyle, R.attr.dropdownListPreferredItemHeight, R.attr.editTextBackground, R.attr.editTextColor, R.attr.editTextStyle, R.attr.homeAsUpIndicator, R.attr.imageButtonStyle, R.attr.listChoiceBackgroundIndicator, R.attr.listChoiceIndicatorMultipleAnimated, R.attr.listChoiceIndicatorSingleAnimated, R.attr.listDividerAlertDialog, R.attr.listMenuViewStyle, R.attr.listPopupWindowStyle, R.attr.listPreferredItemHeight, R.attr.listPreferredItemHeightLarge, R.attr.listPreferredItemHeightSmall, R.attr.listPreferredItemPaddingEnd, R.attr.listPreferredItemPaddingLeft, R.attr.listPreferredItemPaddingRight, R.attr.listPreferredItemPaddingStart, R.attr.panelBackground, R.attr.panelMenuListTheme, R.attr.panelMenuListWidth, R.attr.popupMenuStyle, R.attr.popupWindowStyle, R.attr.radioButtonStyle, R.attr.ratingBarStyle, R.attr.ratingBarStyleIndicator, R.attr.ratingBarStyleSmall, R.attr.searchViewStyle, R.attr.seekBarStyle, R.attr.selectableItemBackground, R.attr.selectableItemBackgroundBorderless, R.attr.spinnerDropDownItemStyle, R.attr.spinnerStyle, R.attr.switchStyle, R.attr.textAppearanceLargePopupMenu, R.attr.textAppearanceListItem, R.attr.textAppearanceListItemSecondary, R.attr.textAppearanceListItemSmall, R.attr.textAppearancePopupMenuHeader, R.attr.textAppearanceSearchResultSubtitle, R.attr.textAppearanceSearchResultTitle, R.attr.textAppearanceSmallPopupMenu, R.attr.textColorAlertDialogListItem, R.attr.textColorSearchUrl, R.attr.toolbarNavigationButtonStyle, R.attr.toolbarStyle, R.attr.tooltipForegroundColor, R.attr.tooltipFrameBackground, R.attr.viewInflaterClass, R.attr.windowActionBar, R.attr.windowActionBarOverlay, R.attr.windowActionModeOverlay, R.attr.windowFixedHeightMajor, R.attr.windowFixedHeightMinor, R.attr.windowFixedWidthMajor, R.attr.windowFixedWidthMinor, R.attr.windowMinWidthMajor, R.attr.windowMinWidthMinor, R.attr.windowNoTitle});
        obtainStyledAttributes.getValue(122, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(123, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(120)) {
            obtainStyledAttributes.getValue(120, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(121)) {
            obtainStyledAttributes.getValue(121, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(118)) {
            obtainStyledAttributes.getValue(118, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(119)) {
            obtainStyledAttributes.getValue(119, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public final boolean O00000o(int i) {
        int O0000Oo02 = O0000Oo0(i);
        if (this.O0000oOo && O0000Oo02 == 108) {
            return false;
        }
        if (this.O0000o && O0000Oo02 == 1) {
            this.O0000o = false;
        }
        if (O0000Oo02 == 1) {
            O00oOooo();
            this.O0000oOo = true;
            return true;
        } else if (O0000Oo02 == 2) {
            O00oOooo();
            this.O000OOOo = true;
            return true;
        } else if (O0000Oo02 == 5) {
            O00oOooo();
            this.O000OOo0 = true;
            return true;
        } else if (O0000Oo02 == 10) {
            O00oOooo();
            this.O0000oO = true;
            return true;
        } else if (O0000Oo02 == 108) {
            O00oOooo();
            this.O0000o = true;
            return true;
        } else if (O0000Oo02 != 109) {
            return this.O00000oo.requestFeature(O0000Oo02);
        } else {
            O00oOooo();
            this.O0000oO0 = true;
            return true;
        }
    }

    public final void O000000o(CharSequence charSequence) {
        this.O000O0o0 = charSequence;
        OOOOO00 ooooo00 = this.O000O0o;
        if (ooooo00 != null) {
            ooooo00.setWindowTitle(charSequence);
            return;
        }
        ActionBar actionBar = this.O0000OOo;
        if (actionBar != null) {
            actionBar.O00000Oo(charSequence);
            return;
        }
        TextView textView = this.O000OO0o;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    private CharSequence O00oOooO() {
        Object obj = this.O00000o;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.O000O0o0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void
     arg types: [androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, int]
     candidates:
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.content.Context, int):int
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, boolean):boolean
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(_m_j.ci, android.graphics.Rect):int
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, android.view.KeyEvent):boolean
      _m_j.O0o0000.O000000o(android.app.Activity, _m_j.OoO0o):_m_j.O0o0000
      _m_j.O0o0000.O000000o(android.app.Dialog, _m_j.OoO0o):_m_j.O0o0000
      _m_j.O0o0000.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void */
    /* access modifiers changed from: package-private */
    public final void O00000oO(int i) {
        if (i == 108) {
            ActionBar O000000o2 = O000000o();
            if (O000000o2 != null) {
                O000000o2.O00000o(false);
            }
        } else if (i == 0) {
            PanelFeatureState O00000oo2 = O00000oo(i);
            if (O00000oo2.O0000o0O) {
                O000000o(O00000oo2, false);
            }
        }
    }

    public final OO00O0o O000000o(OO00O0o.O000000o o000000o) {
        OoO0o ooO0o;
        if (o000000o != null) {
            OO00O0o oO00O0o = this.O0000Oo;
            if (oO00O0o != null) {
                oO00O0o.O00000o0();
            }
            O00000o0 o00000o0 = new O00000o0(o000000o);
            ActionBar O000000o2 = O000000o();
            if (O000000o2 != null) {
                this.O0000Oo = O000000o2.O000000o(o00000o0);
                OO00O0o oO00O0o2 = this.O0000Oo;
                if (!(oO00O0o2 == null || (ooO0o = this.O0000O0o) == null)) {
                    ooO0o.onSupportActionModeStarted(oO00O0o2);
                }
            }
            if (this.O0000Oo == null) {
                this.O0000Oo = O00000Oo(o00000o0);
            }
            return this.O0000Oo;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public final void O0000OOo() {
        ActionBar O000000o2 = O000000o();
        if (O000000o2 == null || !O000000o2.O0000Oo0()) {
            O0000OOo(0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f  */
    private OO00O0o O00000Oo(OO00O0o.O000000o o000000o) {
        OO00O0o oO00O0o;
        OO00O0o oO00O0o2;
        OoO0o ooO0o;
        Context context;
        O0000o();
        OO00O0o oO00O0o3 = this.O0000Oo;
        if (oO00O0o3 != null) {
            oO00O0o3.O00000o0();
        }
        OoO0o ooO0o2 = this.O0000O0o;
        if (ooO0o2 != null && !this.O0000oo0) {
            try {
                oO00O0o = ooO0o2.onWindowStartingSupportActionMode(o000000o);
            } catch (AbstractMethodError unused) {
            }
            if (oO00O0o == null) {
                this.O0000Oo = oO00O0o;
            } else {
                boolean z = true;
                if (this.O0000OoO == null) {
                    if (this.O0000oOO) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = this.O00000oO.getTheme();
                        theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Resources.Theme newTheme = this.O00000oO.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            context = new androidx.appcompat.view.ContextThemeWrapper(this.O00000oO, 0);
                            context.getTheme().setTo(newTheme);
                        } else {
                            context = this.O00000oO;
                        }
                        this.O0000OoO = new ActionBarContextView(context);
                        this.O0000Ooo = new PopupWindow(context, (AttributeSet) null, (int) R.attr.actionModePopupWindowStyle);
                        cw.O000000o(this.O0000Ooo, 2);
                        this.O0000Ooo.setContentView(this.O0000OoO);
                        this.O0000Ooo.setWidth(-1);
                        context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                        this.O0000OoO.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        this.O0000Ooo.setHeight(-2);
                        this.O0000o00 = new Runnable() {
                            /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass6 */

                            public final void run() {
                                AppCompatDelegateImpl.this.O0000Ooo.showAtLocation(AppCompatDelegateImpl.this.O0000OoO, 55, 0, 0);
                                AppCompatDelegateImpl.this.O0000o();
                                if (AppCompatDelegateImpl.this.O0000o0o()) {
                                    AppCompatDelegateImpl.this.O0000OoO.setAlpha(0.0f);
                                    AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                                    appCompatDelegateImpl.O0000o0 = cb.O0000o(appCompatDelegateImpl.O0000OoO).O000000o(1.0f);
                                    AppCompatDelegateImpl.this.O0000o0.O000000o(new cg() {
                                        /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass6.AnonymousClass1 */

                                        public final void O000000o(View view) {
                                            AppCompatDelegateImpl.this.O0000OoO.setVisibility(0);
                                        }

                                        public final void O00000Oo(View view) {
                                            AppCompatDelegateImpl.this.O0000OoO.setAlpha(1.0f);
                                            AppCompatDelegateImpl.this.O0000o0.O000000o((cf) null);
                                            AppCompatDelegateImpl.this.O0000o0 = null;
                                        }
                                    });
                                    return;
                                }
                                AppCompatDelegateImpl.this.O0000OoO.setAlpha(1.0f);
                                AppCompatDelegateImpl.this.O0000OoO.setVisibility(0);
                            }
                        };
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.O0000o0o.findViewById(R.id.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(O0000oOo()));
                            this.O0000OoO = (ActionBarContextView) viewStubCompat.O000000o();
                        }
                    }
                }
                if (this.O0000OoO != null) {
                    O0000o();
                    this.O0000OoO.O00000o0();
                    Context context2 = this.O0000OoO.getContext();
                    ActionBarContextView actionBarContextView = this.O0000OoO;
                    if (this.O0000Ooo != null) {
                        z = false;
                    }
                    OO00OOO oo00ooo = new OO00OOO(context2, actionBarContextView, o000000o, z);
                    if (o000000o.O000000o(oo00ooo, oo00ooo.O00000Oo())) {
                        oo00ooo.O00000o();
                        this.O0000OoO.O000000o(oo00ooo);
                        this.O0000Oo = oo00ooo;
                        if (O0000o0o()) {
                            this.O0000OoO.setAlpha(0.0f);
                            this.O0000o0 = cb.O0000o(this.O0000OoO).O000000o(1.0f);
                            this.O0000o0.O000000o(new cg() {
                                /* class androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass7 */

                                public final void O000000o(View view) {
                                    AppCompatDelegateImpl.this.O0000OoO.setVisibility(0);
                                    AppCompatDelegateImpl.this.O0000OoO.sendAccessibilityEvent(32);
                                    if (AppCompatDelegateImpl.this.O0000OoO.getParent() instanceof View) {
                                        cb.O0000ooO((View) AppCompatDelegateImpl.this.O0000OoO.getParent());
                                    }
                                }

                                public final void O00000Oo(View view) {
                                    AppCompatDelegateImpl.this.O0000OoO.setAlpha(1.0f);
                                    AppCompatDelegateImpl.this.O0000o0.O000000o((cf) null);
                                    AppCompatDelegateImpl.this.O0000o0 = null;
                                }
                            });
                        } else {
                            this.O0000OoO.setAlpha(1.0f);
                            this.O0000OoO.setVisibility(0);
                            this.O0000OoO.sendAccessibilityEvent(32);
                            if (this.O0000OoO.getParent() instanceof View) {
                                cb.O0000ooO((View) this.O0000OoO.getParent());
                            }
                        }
                        if (this.O0000Ooo != null) {
                            this.O00000oo.getDecorView().post(this.O0000o00);
                        }
                    } else {
                        this.O0000Oo = null;
                    }
                }
            }
            oO00O0o2 = this.O0000Oo;
            if (!(oO00O0o2 == null || (ooO0o = this.O0000O0o) == null)) {
                ooO0o.onSupportActionModeStarted(oO00O0o2);
            }
            return this.O0000Oo;
        }
        oO00O0o = null;
        if (oO00O0o == null) {
        }
        oO00O0o2 = this.O0000Oo;
        ooO0o.onSupportActionModeStarted(oO00O0o2);
        return this.O0000Oo;
    }

    /* access modifiers changed from: package-private */
    public final boolean O0000o0o() {
        ViewGroup viewGroup;
        return this.O000OO00 && (viewGroup = this.O0000o0o) != null && cb.O000O0oO(viewGroup);
    }

    /* access modifiers changed from: package-private */
    public final void O0000o() {
        ce ceVar = this.O0000o0;
        if (ceVar != null) {
            ceVar.O00000Oo();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(int i, KeyEvent keyEvent) {
        ActionBar O000000o2 = O000000o();
        if (O000000o2 != null && O000000o2.O000000o(i, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.O000OOoo;
        if (panelFeatureState == null || !O000000o(panelFeatureState, keyEvent.getKeyCode(), keyEvent)) {
            if (this.O000OOoo == null) {
                PanelFeatureState O00000oo2 = O00000oo(0);
                O00000Oo(O00000oo2, keyEvent);
                boolean O000000o3 = O000000o(O00000oo2, keyEvent.getKeyCode(), keyEvent);
                O00000oo2.O0000o00 = false;
                if (O000000o3) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.O000OOoo;
        if (panelFeatureState2 != null) {
            panelFeatureState2.O0000o0 = true;
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void
     arg types: [androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, int]
     candidates:
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.content.Context, int):int
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, boolean):boolean
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(_m_j.ci, android.graphics.Rect):int
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, android.view.KeyEvent):boolean
      _m_j.O0o0000.O000000o(android.app.Activity, _m_j.OoO0o):_m_j.O0o0000
      _m_j.O0o0000.O000000o(android.app.Dialog, _m_j.OoO0o):_m_j.O0o0000
      _m_j.O0o0000.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0118 A[RETURN] */
    public final boolean O000000o(KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        View decorView;
        Object obj = this.O00000o;
        boolean z4 = true;
        if (((obj instanceof bl.O000000o) || (obj instanceof AppCompatDialog)) && (decorView = this.O00000oo.getDecorView()) != null && bl.O000000o(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.O00oOoOo.O00000Oo.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            if (keyCode == 4) {
                if ((keyEvent.getFlags() & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                    z4 = false;
                }
                this.O000Oo00 = z4;
            } else if (keyCode == 82) {
                if (keyEvent.getRepeatCount() == 0) {
                    PanelFeatureState O00000oo2 = O00000oo(0);
                    if (!O00000oo2.O0000o0O) {
                        O00000Oo(O00000oo2, keyEvent);
                    }
                }
                return true;
            }
            return false;
        }
        if (keyCode == 4) {
            boolean z5 = this.O000Oo00;
            this.O000Oo00 = false;
            PanelFeatureState O00000oo3 = O00000oo(0);
            if (O00000oo3 == null || !O00000oo3.O0000o0O) {
                OO00O0o oO00O0o = this.O0000Oo;
                if (oO00O0o != null) {
                    oO00O0o.O00000o0();
                } else {
                    ActionBar O000000o2 = O000000o();
                    if (O000000o2 == null || !O000000o2.O0000Oo()) {
                        z = false;
                        if (!z) {
                            return true;
                        }
                    }
                }
                z = true;
                if (!z) {
                    return false;
                }
            } else {
                if (!z5) {
                    O000000o(O00000oo3, true);
                }
                return true;
            }
        } else if (keyCode == 82) {
            if (this.O0000Oo == null) {
                PanelFeatureState O00000oo4 = O00000oo(0);
                OOOOO00 ooooo00 = this.O000O0o;
                if (ooooo00 != null && ooooo00.O00000Oo() && !ViewConfiguration.get(this.O00000oO).hasPermanentMenuKey()) {
                    if (this.O000O0o.O00000o0()) {
                        z2 = this.O000O0o.O00000oo();
                    } else if (!this.O0000oo0 && O00000Oo(O00000oo4, keyEvent)) {
                        z2 = this.O000O0o.O00000oO();
                    }
                    if (z2) {
                    }
                } else if (O00000oo4.O0000o0O || O00000oo4.O0000o0) {
                    z2 = O00000oo4.O0000o0O;
                    O000000o(O00000oo4, true);
                    if (z2) {
                        AudioManager audioManager = (AudioManager) this.O00000oO.getApplicationContext().getSystemService("audio");
                        if (audioManager != null) {
                            audioManager.playSoundEffect(0);
                        } else {
                            Log.w("AppCompatDelegate", "Couldn't get audio manager");
                        }
                    }
                } else if (O00000oo4.O0000o00) {
                    if (O00000oo4.O0000oO0) {
                        O00000oo4.O0000o00 = false;
                        z3 = O00000Oo(O00000oo4, keyEvent);
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        O000000o(O00000oo4, keyEvent);
                        z2 = true;
                        if (z2) {
                        }
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
            return true;
        }
        return false;
    }

    private View O000000o(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.O000o00 == null) {
            String string = this.O00000oO.obtainStyledAttributes(new int[]{16842839, 16842926, R.attr.actionBarDivider, R.attr.actionBarItemBackground, R.attr.actionBarPopupTheme, R.attr.actionBarSize, R.attr.actionBarSplitStyle, R.attr.actionBarStyle, R.attr.actionBarTabBarStyle, R.attr.actionBarTabStyle, R.attr.actionBarTabTextStyle, R.attr.actionBarTheme, R.attr.actionBarWidgetTheme, R.attr.actionButtonStyle, R.attr.actionDropDownStyle, R.attr.actionMenuTextAppearance, R.attr.actionMenuTextColor, R.attr.actionModeBackground, R.attr.actionModeCloseButtonStyle, R.attr.actionModeCloseDrawable, R.attr.actionModeCopyDrawable, R.attr.actionModeCutDrawable, R.attr.actionModeFindDrawable, R.attr.actionModePasteDrawable, R.attr.actionModePopupWindowStyle, R.attr.actionModeSelectAllDrawable, R.attr.actionModeShareDrawable, R.attr.actionModeSplitBackground, R.attr.actionModeStyle, R.attr.actionModeWebSearchDrawable, R.attr.actionOverflowButtonStyle, R.attr.actionOverflowMenuStyle, R.attr.activityChooserViewStyle, R.attr.alertDialogButtonGroupStyle, R.attr.alertDialogCenterButtons, R.attr.alertDialogStyle, R.attr.alertDialogTheme, R.attr.autoCompleteTextViewStyle, R.attr.borderlessButtonStyle, R.attr.buttonBarButtonStyle, R.attr.buttonBarNegativeButtonStyle, R.attr.buttonBarNeutralButtonStyle, R.attr.buttonBarPositiveButtonStyle, R.attr.buttonBarStyle, R.attr.buttonStyle, R.attr.buttonStyleSmall, R.attr.checkboxStyle, R.attr.checkedTextViewStyle, R.attr.colorAccent, R.attr.colorBackgroundFloating, R.attr.colorButtonNormal, R.attr.colorControlActivated, R.attr.colorControlHighlight, R.attr.colorControlNormal, R.attr.colorError, R.attr.colorPrimary, R.attr.colorPrimaryDark, R.attr.colorSwitchThumbNormal, R.attr.controlBackground, R.attr.dialogCornerRadius, R.attr.dialogPreferredPadding, R.attr.dialogTheme, R.attr.dividerHorizontal, R.attr.dividerVertical, R.attr.dropDownListViewStyle, R.attr.dropdownListPreferredItemHeight, R.attr.editTextBackground, R.attr.editTextColor, R.attr.editTextStyle, R.attr.homeAsUpIndicator, R.attr.imageButtonStyle, R.attr.listChoiceBackgroundIndicator, R.attr.listChoiceIndicatorMultipleAnimated, R.attr.listChoiceIndicatorSingleAnimated, R.attr.listDividerAlertDialog, R.attr.listMenuViewStyle, R.attr.listPopupWindowStyle, R.attr.listPreferredItemHeight, R.attr.listPreferredItemHeightLarge, R.attr.listPreferredItemHeightSmall, R.attr.listPreferredItemPaddingEnd, R.attr.listPreferredItemPaddingLeft, R.attr.listPreferredItemPaddingRight, R.attr.listPreferredItemPaddingStart, R.attr.panelBackground, R.attr.panelMenuListTheme, R.attr.panelMenuListWidth, R.attr.popupMenuStyle, R.attr.popupWindowStyle, R.attr.radioButtonStyle, R.attr.ratingBarStyle, R.attr.ratingBarStyleIndicator, R.attr.ratingBarStyleSmall, R.attr.searchViewStyle, R.attr.seekBarStyle, R.attr.selectableItemBackground, R.attr.selectableItemBackgroundBorderless, R.attr.spinnerDropDownItemStyle, R.attr.spinnerStyle, R.attr.switchStyle, R.attr.textAppearanceLargePopupMenu, R.attr.textAppearanceListItem, R.attr.textAppearanceListItemSecondary, R.attr.textAppearanceListItemSmall, R.attr.textAppearancePopupMenuHeader, R.attr.textAppearanceSearchResultSubtitle, R.attr.textAppearanceSearchResultTitle, R.attr.textAppearanceSmallPopupMenu, R.attr.textColorAlertDialogListItem, R.attr.textColorSearchUrl, R.attr.toolbarNavigationButtonStyle, R.attr.toolbarStyle, R.attr.tooltipForegroundColor, R.attr.tooltipFrameBackground, R.attr.viewInflaterClass, R.attr.windowActionBar, R.attr.windowActionBarOverlay, R.attr.windowActionModeOverlay, R.attr.windowFixedHeightMajor, R.attr.windowFixedHeightMinor, R.attr.windowFixedWidthMajor, R.attr.windowFixedWidthMinor, R.attr.windowMinWidthMajor, R.attr.windowMinWidthMinor, R.attr.windowNoTitle}).getString(114);
            if (string == null) {
                this.O000o00 = new O0o00();
            } else {
                try {
                    this.O000o00 = (O0o00) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.O000o00 = new O0o00();
                }
            }
        }
        if (O00oOooO) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z2 = O000000o((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = false;
        }
        return this.O000o00.createView(view, str, context, attributeSet, z, O00oOooO, true, o000.O000000o());
    }

    private boolean O000000o(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.O00000oo.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || cb.O000OO0o((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public final void O0000OoO() {
        LayoutInflater from = LayoutInflater.from(this.O00000oO);
        if (from.getFactory() == null) {
            bm.O000000o(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return O000000o(view, str, context, attributeSet);
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void
     arg types: [androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, int]
     candidates:
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.content.Context, int):int
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, boolean):boolean
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(_m_j.ci, android.graphics.Rect):int
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, android.view.KeyEvent):boolean
      _m_j.O0o0000.O000000o(android.app.Activity, _m_j.OoO0o):_m_j.O0o0000
      _m_j.O0o0000.O000000o(android.app.Dialog, _m_j.OoO0o):_m_j.O0o0000
      _m_j.O0o0000.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void */
    private void O000000o(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (!panelFeatureState.O0000o0O && !this.O0000oo0) {
            if (panelFeatureState.f2667O000000o == 0) {
                if ((this.O00000oO.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback callback = this.O00000oo.getCallback();
            if (callback == null || callback.onMenuOpened(panelFeatureState.f2667O000000o, panelFeatureState.O0000Oo)) {
                WindowManager windowManager = (WindowManager) this.O00000oO.getSystemService("window");
                if (windowManager != null && O00000Oo(panelFeatureState, keyEvent)) {
                    if (panelFeatureState.O0000O0o == null || panelFeatureState.O0000o) {
                        if (panelFeatureState.O0000O0o == null) {
                            O000000o(panelFeatureState);
                            if (panelFeatureState.O0000O0o == null) {
                                return;
                            }
                        } else if (panelFeatureState.O0000o && panelFeatureState.O0000O0o.getChildCount() > 0) {
                            panelFeatureState.O0000O0o.removeAllViews();
                        }
                        if (!O00000o0(panelFeatureState) || !panelFeatureState.O000000o()) {
                            panelFeatureState.O0000o = true;
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams2 = panelFeatureState.O0000OOo.getLayoutParams();
                        if (layoutParams2 == null) {
                            layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                        }
                        panelFeatureState.O0000O0o.setBackgroundResource(panelFeatureState.O00000Oo);
                        ViewParent parent = panelFeatureState.O0000OOo.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(panelFeatureState.O0000OOo);
                        }
                        panelFeatureState.O0000O0o.addView(panelFeatureState.O0000OOo, layoutParams2);
                        if (!panelFeatureState.O0000OOo.hasFocus()) {
                            panelFeatureState.O0000OOo.requestFocus();
                        }
                    } else if (!(panelFeatureState.O0000Oo0 == null || (layoutParams = panelFeatureState.O0000Oo0.getLayoutParams()) == null || layoutParams.width != -1)) {
                        i = -1;
                        panelFeatureState.O0000o0 = false;
                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, panelFeatureState.O00000o, panelFeatureState.O00000oO, 1002, 8519680, -3);
                        layoutParams3.gravity = panelFeatureState.O00000o0;
                        layoutParams3.windowAnimations = panelFeatureState.O00000oo;
                        windowManager.addView(panelFeatureState.O0000O0o, layoutParams3);
                        panelFeatureState.O0000o0O = true;
                        return;
                    }
                    i = -2;
                    panelFeatureState.O0000o0 = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, panelFeatureState.O00000o, panelFeatureState.O00000oO, 1002, 8519680, -3);
                    layoutParams32.gravity = panelFeatureState.O00000o0;
                    layoutParams32.windowAnimations = panelFeatureState.O00000oo;
                    windowManager.addView(panelFeatureState.O0000O0o, layoutParams32);
                    panelFeatureState.O0000o0O = true;
                    return;
                }
                return;
            }
            O000000o(panelFeatureState, true);
        }
    }

    private boolean O000000o(PanelFeatureState panelFeatureState) {
        panelFeatureState.O000000o(O0000oOo());
        panelFeatureState.O0000O0o = new O0000Oo(panelFeatureState.O0000Ooo);
        panelFeatureState.O00000o0 = 81;
        return true;
    }

    private boolean O00000Oo(PanelFeatureState panelFeatureState) {
        Context context = this.O00000oO;
        if ((panelFeatureState.f2667O000000o == 0 || panelFeatureState.f2667O000000o == 108) && this.O000O0o != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme2);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        panelFeatureState.O000000o(menuBuilder);
        return true;
    }

    private boolean O00000o0(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.O0000Oo0 != null) {
            panelFeatureState.O0000OOo = panelFeatureState.O0000Oo0;
            return true;
        } else if (panelFeatureState.O0000Oo == null) {
            return false;
        } else {
            if (this.O000O0oo == null) {
                this.O000O0oo = new O0000o00();
            }
            panelFeatureState.O0000OOo = (View) panelFeatureState.O000000o(this.O000O0oo);
            if (panelFeatureState.O0000OOo != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void
     arg types: [androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, int]
     candidates:
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.content.Context, int):int
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, boolean):boolean
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(_m_j.ci, android.graphics.Rect):int
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, android.view.KeyEvent):boolean
      _m_j.O0o0000.O000000o(android.app.Activity, _m_j.OoO0o):_m_j.O0o0000
      _m_j.O0o0000.O000000o(android.app.Dialog, _m_j.OoO0o):_m_j.O0o0000
      _m_j.O0o0000.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void */
    private boolean O00000Oo(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        OOOOO00 ooooo00;
        OOOOO00 ooooo002;
        OOOOO00 ooooo003;
        if (this.O0000oo0) {
            return false;
        }
        if (panelFeatureState.O0000o00) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.O000OOoo;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            O000000o(panelFeatureState2, false);
        }
        Window.Callback callback = this.O00000oo.getCallback();
        if (callback != null) {
            panelFeatureState.O0000Oo0 = callback.onCreatePanelView(panelFeatureState.f2667O000000o);
        }
        boolean z = panelFeatureState.f2667O000000o == 0 || panelFeatureState.f2667O000000o == 108;
        if (z && (ooooo003 = this.O000O0o) != null) {
            ooooo003.O0000O0o();
        }
        if (panelFeatureState.O0000Oo0 == null && (!z || !(this.O0000OOo instanceof O0o))) {
            if (panelFeatureState.O0000Oo == null || panelFeatureState.O0000oO0) {
                if (panelFeatureState.O0000Oo == null) {
                    O00000Oo(panelFeatureState);
                    if (panelFeatureState.O0000Oo == null) {
                        return false;
                    }
                }
                if (z && this.O000O0o != null) {
                    if (this.O000O0oO == null) {
                        this.O000O0oO = new O00000Oo();
                    }
                    this.O000O0o.O000000o(panelFeatureState.O0000Oo, this.O000O0oO);
                }
                panelFeatureState.O0000Oo.stopDispatchingItemsChanged();
                if (!callback.onCreatePanelMenu(panelFeatureState.f2667O000000o, panelFeatureState.O0000Oo)) {
                    panelFeatureState.O000000o((MenuBuilder) null);
                    if (z && (ooooo002 = this.O000O0o) != null) {
                        ooooo002.O000000o(null, this.O000O0oO);
                    }
                    return false;
                }
                panelFeatureState.O0000oO0 = false;
            }
            panelFeatureState.O0000Oo.stopDispatchingItemsChanged();
            if (panelFeatureState.O0000oO != null) {
                panelFeatureState.O0000Oo.restoreActionViewStates(panelFeatureState.O0000oO);
                panelFeatureState.O0000oO = null;
            }
            if (!callback.onPreparePanel(0, panelFeatureState.O0000Oo0, panelFeatureState.O0000Oo)) {
                if (z && (ooooo00 = this.O000O0o) != null) {
                    ooooo00.O000000o(null, this.O000O0oO);
                }
                panelFeatureState.O0000Oo.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.O0000o0o = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.O0000Oo.setQwertyMode(panelFeatureState.O0000o0o);
            panelFeatureState.O0000Oo.startDispatchingItemsChanged();
        }
        panelFeatureState.O0000o00 = true;
        panelFeatureState.O0000o0 = false;
        this.O000OOoo = panelFeatureState;
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(MenuBuilder menuBuilder) {
        if (!this.O000OOo) {
            this.O000OOo = true;
            this.O000O0o.O0000OOo();
            Window.Callback callback = this.O00000oo.getCallback();
            if (callback != null && !this.O0000oo0) {
                callback.onPanelClosed(108, menuBuilder);
            }
            this.O000OOo = false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void
     arg types: [androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, int]
     candidates:
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.content.Context, int):int
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, boolean):boolean
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(_m_j.ci, android.graphics.Rect):int
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, android.view.KeyEvent):boolean
      _m_j.O0o0000.O000000o(android.app.Activity, _m_j.OoO0o):_m_j.O0o0000
      _m_j.O0o0000.O000000o(android.app.Dialog, _m_j.OoO0o):_m_j.O0o0000
      _m_j.O0o0000.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void */
    /* access modifiers changed from: package-private */
    public final void O0000oO0() {
        O000000o(O00000oo(0), true);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(PanelFeatureState panelFeatureState, boolean z) {
        OOOOO00 ooooo00;
        if (!z || panelFeatureState.f2667O000000o != 0 || (ooooo00 = this.O000O0o) == null || !ooooo00.O00000o0()) {
            WindowManager windowManager = (WindowManager) this.O00000oO.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.O0000o0O || panelFeatureState.O0000O0o == null)) {
                windowManager.removeView(panelFeatureState.O0000O0o);
                if (z) {
                    O000000o(panelFeatureState.f2667O000000o, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.O0000o00 = false;
            panelFeatureState.O0000o0 = false;
            panelFeatureState.O0000o0O = false;
            panelFeatureState.O0000OOo = null;
            panelFeatureState.O0000o = true;
            if (this.O000OOoo == panelFeatureState) {
                this.O000OOoo = null;
                return;
            }
            return;
        }
        O000000o(panelFeatureState.O0000Oo);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.O000OOoO;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.O0000Oo;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.O0000o0O) && !this.O0000oo0) {
            this.O00oOoOo.O00000Oo.onPanelClosed(i, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public final PanelFeatureState O000000o(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.O000OOoO;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.O0000Oo == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final PanelFeatureState O00000oo(int i) {
        PanelFeatureState[] panelFeatureStateArr = this.O000OOoO;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.O000OOoO = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    private boolean O000000o(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.O0000o00 || O00000Oo(panelFeatureState, keyEvent)) && panelFeatureState.O0000Oo != null) {
            return panelFeatureState.O0000Oo.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    private void O0000OOo(int i) {
        this.O0000ooO = (1 << i) | this.O0000ooO;
        if (!this.O0000oo) {
            cb.O000000o(this.O00000oo.getDecorView(), this.O000Ooo);
            this.O0000oo = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O0000O0o(int i) {
        PanelFeatureState O00000oo2;
        PanelFeatureState O00000oo3 = O00000oo(i);
        if (O00000oo3.O0000Oo != null) {
            Bundle bundle = new Bundle();
            O00000oo3.O0000Oo.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                O00000oo3.O0000oO = bundle;
            }
            O00000oo3.O0000Oo.stopDispatchingItemsChanged();
            O00000oo3.O0000Oo.clear();
        }
        O00000oo3.O0000oO0 = true;
        O00000oo3.O0000o = true;
        if ((i == 108 || i == 0) && this.O000O0o != null && (O00000oo2 = O00000oo(0)) != null) {
            O00000oo2.O0000o00 = false;
            O00000Oo(O00000oo2, (KeyEvent) null);
        }
    }

    private void O00oOooo() {
        if (this.O000OO00) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private static int O0000Oo0(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O0000oO() {
        OOOOO00 ooooo00 = this.O000O0o;
        if (ooooo00 != null) {
            ooooo00.O0000OOo();
        }
        if (this.O0000Ooo != null) {
            this.O00000oo.getDecorView().removeCallbacks(this.O0000o00);
            if (this.O0000Ooo.isShowing()) {
                try {
                    this.O0000Ooo.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.O0000Ooo = null;
        }
        O0000o();
        PanelFeatureState O00000oo2 = O00000oo(0);
        if (O00000oo2 != null && O00000oo2.O0000Oo != null) {
            O00000oo2.O0000Oo.close();
        }
    }

    public final boolean O0000Ooo() {
        return O000000o(true);
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(boolean z) {
        if (this.O0000oo0) {
            return false;
        }
        int O000O00o2 = O000O00o();
        boolean O000000o2 = O000000o(O000000o(this.O00000oO, O000O00o2), z);
        if (O000O00o2 == 0) {
            O00000Oo(this.O00000oO).O00000o();
        } else {
            O0000OOo o0000OOo = this.O000OoOo;
            if (o0000OOo != null) {
                o0000OOo.O00000oO();
            }
        }
        if (O000O00o2 == 3) {
            O00000o0(this.O00000oO).O00000o();
        } else {
            O0000OOo o0000OOo2 = this.O000Ooo0;
            if (o0000OOo2 != null) {
                o0000OOo2.O00000oO();
            }
        }
        return O000000o2;
    }

    public final int O0000o00() {
        return this.O000OoO0;
    }

    private int O000000o(Context context, int i) {
        if (i == -100) {
            return -1;
        }
        if (i != -1) {
            if (i != 0) {
                if (!(i == 1 || i == 2)) {
                    if (i == 3) {
                        return O00000o0(context).O000000o();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) {
                return O00000Oo(context).O000000o();
            } else {
                return -1;
            }
        }
        return i;
    }

    private int O000O00o() {
        int i = this.O000OoO0;
        return i != -100 ? i : O0o0000.f6697O000000o;
    }

    private static Configuration O000000o(Context context, int i, Configuration configuration) {
        int i2 = i != 1 ? i != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & -49);
        return configuration2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    private boolean O000000o(int i, boolean z) {
        boolean z2;
        Configuration O000000o2 = O000000o(this.O00000oO, i, (Configuration) null);
        boolean O000O0OO2 = O000O0OO();
        int i2 = this.O00000oO.getResources().getConfiguration().uiMode & 48;
        int i3 = O000000o2.uiMode & 48;
        if (i2 != i3 && z && !O000O0OO2 && this.O000Oo0 && (O000O00o || this.O000Oo0O)) {
            Object obj = this.O00000o;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                oOOO00o0.O00000oO((Activity) this.O00000o);
                z2 = true;
                if (!z2 && i2 != i3) {
                    O00000Oo(i3, O000O0OO2);
                    z2 = true;
                }
                if (z2) {
                    Object obj2 = this.O00000o;
                    if (obj2 instanceof AppCompatActivity) {
                        ((AppCompatActivity) obj2).onNightModeChanged(i);
                    }
                }
                return z2;
            }
        }
        z2 = false;
        O00000Oo(i3, O000O0OO2);
        z2 = true;
        if (z2) {
        }
        return z2;
    }

    private void O00000Oo(int i, boolean z) {
        Resources resources = this.O00000oO.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration, null);
        if (Build.VERSION.SDK_INT < 26) {
            O0o0.O000000o(resources);
        }
        int i2 = this.O00O0Oo;
        if (i2 != 0) {
            this.O00000oO.setTheme(i2);
            if (Build.VERSION.SDK_INT >= 23) {
                this.O00000oO.getTheme().applyStyle(this.O00O0Oo, true);
            }
        }
        if (z) {
            Object obj = this.O00000o;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof fa) {
                    if (((fa) activity).getLifecycle().O000000o().isAtLeast(Lifecycle.State.STARTED)) {
                        activity.onConfigurationChanged(configuration);
                    }
                } else if (this.O000Oo0o) {
                    activity.onConfigurationChanged(configuration);
                }
            }
        }
    }

    private O0000OOo O00000Oo(Context context) {
        if (this.O000OoOo == null) {
            this.O000OoOo = new O0000Oo0(ooO0Ooo.O000000o(context));
        }
        return this.O000OoOo;
    }

    private O0000OOo O00000o0(Context context) {
        if (this.O000Ooo0 == null) {
            this.O000Ooo0 = new O0000O0o(context);
        }
        return this.O000Ooo0;
    }

    private boolean O000O0OO() {
        int i;
        if (!this.O000OoOO && (this.O00000o instanceof Activity)) {
            PackageManager packageManager = this.O00000oO.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    i = 269221888;
                } else {
                    i = Build.VERSION.SDK_INT >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.O00000oO, this.O00000o.getClass()), i);
                this.O000OoO = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                this.O000OoO = false;
            }
        }
        this.O000OoOO = true;
        return this.O000OoO;
    }

    class O00000o0 implements OO00O0o.O000000o {
        private OO00O0o.O000000o O00000Oo;

        public O00000o0(OO00O0o.O000000o o000000o) {
            this.O00000Oo = o000000o;
        }

        public final boolean O000000o(OO00O0o oO00O0o, Menu menu) {
            return this.O00000Oo.O000000o(oO00O0o, menu);
        }

        public final boolean O00000Oo(OO00O0o oO00O0o, Menu menu) {
            cb.O0000ooO(AppCompatDelegateImpl.this.O0000o0o);
            return this.O00000Oo.O00000Oo(oO00O0o, menu);
        }

        public final boolean O000000o(OO00O0o oO00O0o, MenuItem menuItem) {
            return this.O00000Oo.O000000o(oO00O0o, menuItem);
        }

        public final void O000000o(OO00O0o oO00O0o) {
            this.O00000Oo.O000000o(oO00O0o);
            if (AppCompatDelegateImpl.this.O0000Ooo != null) {
                AppCompatDelegateImpl.this.O00000oo.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.O0000o00);
            }
            if (AppCompatDelegateImpl.this.O0000OoO != null) {
                AppCompatDelegateImpl.this.O0000o();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.O0000o0 = cb.O0000o(appCompatDelegateImpl.O0000OoO).O000000o(0.0f);
                AppCompatDelegateImpl.this.O0000o0.O000000o(new cg() {
                    /* class androidx.appcompat.app.AppCompatDelegateImpl.O00000o0.AnonymousClass1 */

                    public final void O00000Oo(View view) {
                        AppCompatDelegateImpl.this.O0000OoO.setVisibility(8);
                        if (AppCompatDelegateImpl.this.O0000Ooo != null) {
                            AppCompatDelegateImpl.this.O0000Ooo.dismiss();
                        } else if (AppCompatDelegateImpl.this.O0000OoO.getParent() instanceof View) {
                            cb.O0000ooO((View) AppCompatDelegateImpl.this.O0000OoO.getParent());
                        }
                        AppCompatDelegateImpl.this.O0000OoO.removeAllViews();
                        AppCompatDelegateImpl.this.O0000o0.O000000o((cf) null);
                        AppCompatDelegateImpl.this.O0000o0 = null;
                        cb.O0000ooO(AppCompatDelegateImpl.this.O0000o0o);
                    }
                });
            }
            if (AppCompatDelegateImpl.this.O0000O0o != null) {
                AppCompatDelegateImpl.this.O0000O0o.onSupportActionModeFinished(AppCompatDelegateImpl.this.O0000Oo);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl2.O0000Oo = null;
            cb.O0000ooO(appCompatDelegateImpl2.O0000o0o);
        }
    }

    final class O0000o00 implements OO0o000.O000000o {
        O0000o00() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void
         arg types: [androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, int]
         candidates:
          androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.content.Context, int):int
          androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void
          androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, boolean):boolean
          androidx.appcompat.app.AppCompatDelegateImpl.O000000o(_m_j.ci, android.graphics.Rect):int
          androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
          androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, android.view.KeyEvent):boolean
          _m_j.O0o0000.O000000o(android.app.Activity, _m_j.OoO0o):_m_j.O0o0000
          _m_j.O0o0000.O000000o(android.app.Dialog, _m_j.OoO0o):_m_j.O0o0000
          _m_j.O0o0000.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
          androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void */
        public final void O000000o(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState O000000o2 = appCompatDelegateImpl.O000000o((Menu) menuBuilder);
            if (O000000o2 == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImpl.this.O000000o(O000000o2.f2667O000000o, O000000o2, rootMenu);
                AppCompatDelegateImpl.this.O000000o(O000000o2, true);
                return;
            }
            AppCompatDelegateImpl.this.O000000o(O000000o2, z);
        }

        public final boolean O000000o(MenuBuilder menuBuilder) {
            Window.Callback callback;
            if (menuBuilder != menuBuilder.getRootMenu() || !AppCompatDelegateImpl.this.O0000o || (callback = AppCompatDelegateImpl.this.O00000oo.getCallback()) == null || AppCompatDelegateImpl.this.O0000oo0) {
                return true;
            }
            callback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    final class O00000Oo implements OO0o000.O000000o {
        O00000Oo() {
        }

        public final boolean O000000o(MenuBuilder menuBuilder) {
            Window.Callback callback = AppCompatDelegateImpl.this.O00000oo.getCallback();
            if (callback == null) {
                return true;
            }
            callback.onMenuOpened(108, menuBuilder);
            return true;
        }

        public final void O000000o(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.O000000o(menuBuilder);
        }
    }

    public static final class PanelFeatureState {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2667O000000o;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        int O00000oO;
        int O00000oo;
        ViewGroup O0000O0o;
        View O0000OOo;
        MenuBuilder O0000Oo;
        View O0000Oo0;
        ListMenuPresenter O0000OoO;
        Context O0000Ooo;
        boolean O0000o = false;
        boolean O0000o0;
        boolean O0000o00;
        boolean O0000o0O;
        public boolean O0000o0o;
        Bundle O0000oO;
        boolean O0000oO0;

        PanelFeatureState(int i) {
            this.f2667O000000o = i;
        }

        public final boolean O000000o() {
            if (this.O0000OOo == null) {
                return false;
            }
            if (this.O0000Oo0 == null && this.O0000OoO.O000000o().getCount() <= 0) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(2132738819, true);
            }
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.O0000Ooo = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(new int[]{16842839, 16842926, R.attr.actionBarDivider, R.attr.actionBarItemBackground, R.attr.actionBarPopupTheme, R.attr.actionBarSize, R.attr.actionBarSplitStyle, R.attr.actionBarStyle, R.attr.actionBarTabBarStyle, R.attr.actionBarTabStyle, R.attr.actionBarTabTextStyle, R.attr.actionBarTheme, R.attr.actionBarWidgetTheme, R.attr.actionButtonStyle, R.attr.actionDropDownStyle, R.attr.actionMenuTextAppearance, R.attr.actionMenuTextColor, R.attr.actionModeBackground, R.attr.actionModeCloseButtonStyle, R.attr.actionModeCloseDrawable, R.attr.actionModeCopyDrawable, R.attr.actionModeCutDrawable, R.attr.actionModeFindDrawable, R.attr.actionModePasteDrawable, R.attr.actionModePopupWindowStyle, R.attr.actionModeSelectAllDrawable, R.attr.actionModeShareDrawable, R.attr.actionModeSplitBackground, R.attr.actionModeStyle, R.attr.actionModeWebSearchDrawable, R.attr.actionOverflowButtonStyle, R.attr.actionOverflowMenuStyle, R.attr.activityChooserViewStyle, R.attr.alertDialogButtonGroupStyle, R.attr.alertDialogCenterButtons, R.attr.alertDialogStyle, R.attr.alertDialogTheme, R.attr.autoCompleteTextViewStyle, R.attr.borderlessButtonStyle, R.attr.buttonBarButtonStyle, R.attr.buttonBarNegativeButtonStyle, R.attr.buttonBarNeutralButtonStyle, R.attr.buttonBarPositiveButtonStyle, R.attr.buttonBarStyle, R.attr.buttonStyle, R.attr.buttonStyleSmall, R.attr.checkboxStyle, R.attr.checkedTextViewStyle, R.attr.colorAccent, R.attr.colorBackgroundFloating, R.attr.colorButtonNormal, R.attr.colorControlActivated, R.attr.colorControlHighlight, R.attr.colorControlNormal, R.attr.colorError, R.attr.colorPrimary, R.attr.colorPrimaryDark, R.attr.colorSwitchThumbNormal, R.attr.controlBackground, R.attr.dialogCornerRadius, R.attr.dialogPreferredPadding, R.attr.dialogTheme, R.attr.dividerHorizontal, R.attr.dividerVertical, R.attr.dropDownListViewStyle, R.attr.dropdownListPreferredItemHeight, R.attr.editTextBackground, R.attr.editTextColor, R.attr.editTextStyle, R.attr.homeAsUpIndicator, R.attr.imageButtonStyle, R.attr.listChoiceBackgroundIndicator, R.attr.listChoiceIndicatorMultipleAnimated, R.attr.listChoiceIndicatorSingleAnimated, R.attr.listDividerAlertDialog, R.attr.listMenuViewStyle, R.attr.listPopupWindowStyle, R.attr.listPreferredItemHeight, R.attr.listPreferredItemHeightLarge, R.attr.listPreferredItemHeightSmall, R.attr.listPreferredItemPaddingEnd, R.attr.listPreferredItemPaddingLeft, R.attr.listPreferredItemPaddingRight, R.attr.listPreferredItemPaddingStart, R.attr.panelBackground, R.attr.panelMenuListTheme, R.attr.panelMenuListWidth, R.attr.popupMenuStyle, R.attr.popupWindowStyle, R.attr.radioButtonStyle, R.attr.ratingBarStyle, R.attr.ratingBarStyleIndicator, R.attr.ratingBarStyleSmall, R.attr.searchViewStyle, R.attr.seekBarStyle, R.attr.selectableItemBackground, R.attr.selectableItemBackgroundBorderless, R.attr.spinnerDropDownItemStyle, R.attr.spinnerStyle, R.attr.switchStyle, R.attr.textAppearanceLargePopupMenu, R.attr.textAppearanceListItem, R.attr.textAppearanceListItemSecondary, R.attr.textAppearanceListItemSmall, R.attr.textAppearancePopupMenuHeader, R.attr.textAppearanceSearchResultSubtitle, R.attr.textAppearanceSearchResultTitle, R.attr.textAppearanceSmallPopupMenu, R.attr.textColorAlertDialogListItem, R.attr.textColorSearchUrl, R.attr.toolbarNavigationButtonStyle, R.attr.toolbarStyle, R.attr.tooltipForegroundColor, R.attr.tooltipFrameBackground, R.attr.viewInflaterClass, R.attr.windowActionBar, R.attr.windowActionBarOverlay, R.attr.windowActionModeOverlay, R.attr.windowFixedHeightMajor, R.attr.windowFixedHeightMinor, R.attr.windowFixedWidthMajor, R.attr.windowFixedWidthMinor, R.attr.windowMinWidthMajor, R.attr.windowMinWidthMinor, R.attr.windowNoTitle});
            this.O00000Oo = obtainStyledAttributes.getResourceId(84, 0);
            this.O00000oo = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.O0000Oo;
            if (menuBuilder != menuBuilder2) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(this.O0000OoO);
                }
                this.O0000Oo = menuBuilder;
                if (menuBuilder != null && (listMenuPresenter = this.O0000OoO) != null) {
                    menuBuilder.addMenuPresenter(listMenuPresenter);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final OO0o00 O000000o(OO0o000.O000000o o000000o) {
            if (this.O0000Oo == null) {
                return null;
            }
            if (this.O0000OoO == null) {
                this.O0000OoO = new ListMenuPresenter(this.O0000Ooo);
                this.O0000OoO.setCallback(o000000o);
                this.O0000Oo.addMenuPresenter(this.O0000OoO);
            }
            return this.O0000OoO.O000000o(this.O0000O0o);
        }

        @SuppressLint({"BanParcelableUsage"})
        static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                /* class androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.AnonymousClass1 */

                public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.O000000o(parcel, classLoader);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SavedState[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return SavedState.O000000o(parcel, null);
                }
            };

            /* renamed from: O000000o  reason: collision with root package name */
            int f2668O000000o;
            boolean O00000Oo;
            Bundle O00000o0;

            public int describeContents() {
                return 0;
            }

            SavedState() {
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f2668O000000o);
                parcel.writeInt(this.O00000Oo ? 1 : 0);
                if (this.O00000Oo) {
                    parcel.writeBundle(this.O00000o0);
                }
            }

            static SavedState O000000o(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f2668O000000o = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.O00000Oo = z;
                if (savedState.O00000Oo) {
                    savedState.O00000o0 = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    class O0000Oo extends ContentFrameLayout {
        public O0000Oo(Context context) {
            super(context);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.O000000o(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    AppCompatDelegateImpl.this.O0000oO0();
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(OO0000o.O00000Oo(getContext(), i));
        }
    }

    class O00000o extends OO0O00o {
        public final void onContentChanged() {
        }

        O00000o(Window.Callback callback) {
            super(callback);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.O000000o(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.O000000o(keyEvent.getKeyCode(), keyEvent);
        }

        public final boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public final boolean onPreparePanel(int i, View view, Menu menu) {
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

        public final boolean onMenuOpened(int i, Menu menu) {
            ActionBar O000000o2;
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i == 108 && (O000000o2 = appCompatDelegateImpl.O000000o()) != null) {
                O000000o2.O00000o(true);
            }
            return true;
        }

        public final void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.O00000oO(i);
        }

        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.O0000o0O) {
                return O000000o(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        private ActionMode O000000o(ActionMode.Callback callback) {
            OO00Oo0.O000000o o000000o = new OO00Oo0.O000000o(AppCompatDelegateImpl.this.O00000oO, callback);
            OO00O0o O000000o2 = AppCompatDelegateImpl.this.O000000o(o000000o);
            if (O000000o2 != null) {
                return o000000o.O00000Oo(O000000o2);
            }
            return null;
        }

        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!AppCompatDelegateImpl.this.O0000o0O || i != 0) {
                return super.onWindowStartingActionMode(callback, i);
            }
            return O000000o(callback);
        }

        public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            PanelFeatureState O00000oo = AppCompatDelegateImpl.this.O00000oo(0);
            if (O00000oo == null || O00000oo.O0000Oo == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, O00000oo.O0000Oo, i);
            }
        }
    }

    abstract class O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        private BroadcastReceiver f2662O000000o;

        /* access modifiers changed from: package-private */
        public abstract int O000000o();

        /* access modifiers changed from: package-private */
        public abstract void O00000Oo();

        /* access modifiers changed from: package-private */
        public abstract IntentFilter O00000o0();

        O0000OOo() {
        }

        /* access modifiers changed from: package-private */
        public final void O00000o() {
            O00000oO();
            IntentFilter O00000o0 = O00000o0();
            if (O00000o0 != null && O00000o0.countActions() != 0) {
                if (this.f2662O000000o == null) {
                    this.f2662O000000o = new BroadcastReceiver() {
                        /* class androidx.appcompat.app.AppCompatDelegateImpl.O0000OOo.AnonymousClass1 */

                        public final void onReceive(Context context, Intent intent) {
                            O0000OOo.this.O00000Oo();
                        }
                    };
                }
                AppCompatDelegateImpl.this.O00000oO.registerReceiver(this.f2662O000000o, O00000o0);
            }
        }

        /* access modifiers changed from: package-private */
        public final void O00000oO() {
            if (this.f2662O000000o != null) {
                try {
                    AppCompatDelegateImpl.this.O00000oO.unregisterReceiver(this.f2662O000000o);
                } catch (IllegalArgumentException unused) {
                }
                this.f2662O000000o = null;
            }
        }
    }

    class O0000Oo0 extends O0000OOo {
        private final ooO0Ooo O00000o0;

        O0000Oo0(ooO0Ooo ooo0ooo) {
            super();
            this.O00000o0 = ooo0ooo;
        }

        public final int O000000o() {
            long j;
            long j2;
            ooO0Ooo ooo0ooo = this.O00000o0;
            ooO0Ooo.O000000o o000000o = ooo0ooo.O00000Oo;
            boolean z = false;
            if (ooo0ooo.O00000Oo.O00000oo > System.currentTimeMillis()) {
                z = o000000o.f2360O000000o;
            } else {
                Location location = null;
                Location O000000o2 = g.O000000o(ooo0ooo.f2359O000000o, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? ooo0ooo.O000000o("network") : null;
                if (g.O000000o(ooo0ooo.f2359O000000o, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    location = ooo0ooo.O000000o("gps");
                }
                if (location == null || O000000o2 == null ? location != null : location.getTime() > O000000o2.getTime()) {
                    O000000o2 = location;
                }
                if (O000000o2 != null) {
                    ooO0Ooo.O000000o o000000o2 = ooo0ooo.O00000Oo;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (Oo0OOo.f12346O000000o == null) {
                        Oo0OOo.f12346O000000o = new Oo0OOo();
                    }
                    Oo0OOo oo0OOo = Oo0OOo.f12346O000000o;
                    Oo0OOo oo0OOo2 = oo0OOo;
                    oo0OOo2.O000000o(currentTimeMillis - 86400000, O000000o2.getLatitude(), O000000o2.getLongitude());
                    long j3 = oo0OOo.O00000Oo;
                    oo0OOo2.O000000o(currentTimeMillis, O000000o2.getLatitude(), O000000o2.getLongitude());
                    if (oo0OOo.O00000o == 1) {
                        z = true;
                    }
                    long j4 = oo0OOo.O00000o0;
                    long j5 = oo0OOo.O00000Oo;
                    ooO0Ooo.O000000o o000000o3 = o000000o;
                    long j6 = j4;
                    oo0OOo.O000000o(currentTimeMillis + 86400000, O000000o2.getLatitude(), O000000o2.getLongitude());
                    long j7 = oo0OOo.O00000o0;
                    if (j6 != -1) {
                        j = j5;
                        if (j != -1) {
                            j2 = (currentTimeMillis > j ? 0 + j7 : currentTimeMillis > j6 ? 0 + j : 0 + j6) + 60000;
                            o000000o2.f2360O000000o = z;
                            o000000o2.O00000Oo = j3;
                            o000000o2.O00000o0 = j6;
                            o000000o2.O00000o = j;
                            o000000o2.O00000oO = j7;
                            o000000o2.O00000oo = j2;
                            z = o000000o3.f2360O000000o;
                        }
                    } else {
                        j = j5;
                    }
                    j2 = 43200000 + currentTimeMillis;
                    o000000o2.f2360O000000o = z;
                    o000000o2.O00000Oo = j3;
                    o000000o2.O00000o0 = j6;
                    o000000o2.O00000o = j;
                    o000000o2.O00000oO = j7;
                    o000000o2.O00000oo = j2;
                    z = o000000o3.f2360O000000o;
                } else {
                    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                    int i = Calendar.getInstance().get(11);
                    if (i < 6 || i >= 22) {
                        z = true;
                    }
                }
            }
            if (z) {
                return 2;
            }
            return 1;
        }

        public final void O00000Oo() {
            AppCompatDelegateImpl.this.O000000o(true);
        }

        /* access modifiers changed from: package-private */
        public final IntentFilter O00000o0() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }
    }

    class O0000O0o extends O0000OOo {
        private final PowerManager O00000o0;

        O0000O0o(Context context) {
            super();
            this.O00000o0 = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        public final int O000000o() {
            if (Build.VERSION.SDK_INT < 21 || !this.O00000o0.isPowerSaveMode()) {
                return 1;
            }
            return 2;
        }

        public final void O00000Oo() {
            AppCompatDelegateImpl.this.O000000o(true);
        }

        /* access modifiers changed from: package-private */
        public final IntentFilter O00000o0() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }
    }

    public final OooOO.O000000o O0000Oo() {
        return new O000000o();
    }

    class O000000o implements OooOO.O000000o {
        O000000o() {
        }

        public final void O000000o(int i) {
            ActionBar O000000o2 = AppCompatDelegateImpl.this.O000000o();
            if (O000000o2 != null) {
                O000000o2.O000000o(i);
            }
        }
    }

    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState O000000o2;
        Window.Callback callback = this.O00000oo.getCallback();
        if (callback == null || this.O0000oo0 || (O000000o2 = O000000o((Menu) menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return callback.onMenuItemSelected(O000000o2.f2667O000000o, menuItem);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void
     arg types: [androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, int]
     candidates:
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.content.Context, int):int
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, boolean):boolean
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(_m_j.ci, android.graphics.Rect):int
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(int, android.view.KeyEvent):boolean
      _m_j.O0o0000.O000000o(android.app.Activity, _m_j.OoO0o):_m_j.O0o0000
      _m_j.O0o0000.O000000o(android.app.Dialog, _m_j.OoO0o):_m_j.O0o0000
      _m_j.O0o0000.O000000o(android.view.View, android.view.ViewGroup$LayoutParams):void
      androidx.appcompat.app.AppCompatDelegateImpl.O000000o(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, boolean):void */
    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        OOOOO00 ooooo00 = this.O000O0o;
        if (ooooo00 == null || !ooooo00.O00000Oo() || (ViewConfiguration.get(this.O00000oO).hasPermanentMenuKey() && !this.O000O0o.O00000o())) {
            PanelFeatureState O00000oo2 = O00000oo(0);
            O00000oo2.O0000o = true;
            O000000o(O00000oo2, false);
            O000000o(O00000oo2, (KeyEvent) null);
            return;
        }
        Window.Callback callback = this.O00000oo.getCallback();
        if (this.O000O0o.O00000o0()) {
            this.O000O0o.O00000oo();
            if (!this.O0000oo0) {
                callback.onPanelClosed(108, O00000oo(0).O0000Oo);
            }
        } else if (callback != null && !this.O0000oo0) {
            if (this.O0000oo && (1 & this.O0000ooO) != 0) {
                this.O00000oo.getDecorView().removeCallbacks(this.O000Ooo);
                this.O000Ooo.run();
            }
            PanelFeatureState O00000oo3 = O00000oo(0);
            if (O00000oo3.O0000Oo != null && !O00000oo3.O0000oO0 && callback.onPreparePanel(0, O00000oo3.O0000Oo0, O00000oo3.O0000Oo)) {
                callback.onMenuOpened(108, O00000oo3.O0000Oo);
                this.O000O0o.O00000oO();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int O000000o(ci ciVar, Rect rect) {
        int i;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        if (ciVar != null) {
            i = ciVar.O00000Oo.O0000O0o().O00000o0;
        } else {
            i = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.O0000OoO;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.O0000OoO.getLayoutParams();
            boolean z3 = true;
            if (this.O0000OoO.isShown()) {
                if (this.O000Oooo == null) {
                    this.O000Oooo = new Rect();
                    this.O000o000 = new Rect();
                }
                Rect rect2 = this.O000Oooo;
                Rect rect3 = this.O000o000;
                if (ciVar == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(ciVar.O00000Oo.O0000O0o().O00000Oo, ciVar.O00000Oo.O0000O0o().O00000o0, ciVar.O00000Oo.O0000O0o().O00000o, ciVar.O00000Oo.O0000O0o().O00000oO);
                }
                o00.O000000o(this.O0000o0o, rect2, rect3);
                int i6 = rect2.top;
                int i7 = rect2.left;
                int i8 = rect2.right;
                ci O00oOooO2 = cb.O00oOooO(this.O0000o0o);
                if (O00oOooO2 == null) {
                    i2 = 0;
                } else {
                    i2 = O00oOooO2.O00000Oo.O0000O0o().O00000Oo;
                }
                if (O00oOooO2 == null) {
                    i3 = 0;
                } else {
                    i3 = O00oOooO2.O00000Oo.O0000O0o().O00000o;
                }
                if (marginLayoutParams.topMargin == i6 && marginLayoutParams.leftMargin == i7 && marginLayoutParams.rightMargin == i8) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i6;
                    marginLayoutParams.leftMargin = i7;
                    marginLayoutParams.rightMargin = i8;
                    z2 = true;
                }
                if (i6 <= 0 || this.O000OO != null) {
                    View view = this.O000OO;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        if (!(marginLayoutParams2.height == marginLayoutParams.topMargin && marginLayoutParams2.leftMargin == i2 && marginLayoutParams2.rightMargin == i3)) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = i2;
                            marginLayoutParams2.rightMargin = i3;
                            this.O000OO.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    this.O000OO = new View(this.O00000oO);
                    this.O000OO.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i2;
                    layoutParams.rightMargin = i3;
                    this.O0000o0o.addView(this.O000OO, -1, layoutParams);
                }
                z = this.O000OO != null;
                if (z && this.O000OO.getVisibility() != 0) {
                    View view2 = this.O000OO;
                    if ((cb.O0000oo(view2) & 8192) == 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i4 = ContextCompat.O00000o0(this.O00000oO, R.color.abc_decor_view_status_guard_light);
                    } else {
                        i4 = ContextCompat.O00000o0(this.O00000oO, R.color.abc_decor_view_status_guard);
                    }
                    view2.setBackgroundColor(i4);
                }
                if (!this.O0000oO && z) {
                    i = 0;
                }
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            if (z2) {
                this.O0000OoO.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.O000OO;
        if (view3 != null) {
            if (!z) {
                i5 = 8;
            }
            view3.setVisibility(i5);
        }
        return i;
    }
}

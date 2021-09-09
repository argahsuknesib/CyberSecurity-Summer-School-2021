package com.swmansion.rnscreens;

import _m_j.dfz;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.facebook.react.views.text.ReactFontManager;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import java.util.ArrayList;

public class ScreenStackHeaderConfig extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    final ArrayList<ScreenStackHeaderSubview> f5791O000000o = new ArrayList<>(3);
    public boolean O00000Oo = true;
    private int O00000o;
    private String O00000o0;
    private String O00000oO;
    private float O00000oo;
    private int O0000O0o;
    private boolean O0000OOo;
    private boolean O0000Oo;
    private boolean O0000Oo0;
    private int O0000OoO;
    private final Toolbar O0000Ooo;
    private View.OnClickListener O0000o0 = new View.OnClickListener() {
        /* class com.swmansion.rnscreens.ScreenStackHeaderConfig.AnonymousClass1 */

        public final void onClick(View view) {
            ScreenStackHeaderConfig.this.getScreenStack().O000000o(ScreenStackHeaderConfig.this.getScreenFragment());
        }
    };
    private boolean O0000o00 = false;

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public ScreenStackHeaderConfig(Context context) {
        super(context);
        setVisibility(8);
        this.O0000Ooo = new Toolbar(context);
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16843827, typedValue, true)) {
            this.O0000Ooo.setBackgroundColor(typedValue.data);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O0000o00 = true;
        O000000o();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O0000o00 = false;
    }

    private Screen getScreen() {
        ViewParent parent = getParent();
        if (parent instanceof Screen) {
            return (Screen) parent;
        }
        return null;
    }

    public ScreenStack getScreenStack() {
        Screen screen = getScreen();
        if (screen == null) {
            return null;
        }
        ScreenContainer container = screen.getContainer();
        if (container instanceof ScreenStack) {
            return (ScreenStack) container;
        }
        return null;
    }

    public dfz getScreenFragment() {
        ViewParent parent = getParent();
        if (!(parent instanceof Screen)) {
            return null;
        }
        Fragment fragment = ((Screen) parent).getFragment();
        if (fragment instanceof dfz) {
            return (dfz) fragment;
        }
        return null;
    }

    public final void O000000o() {
        boolean z;
        boolean z2;
        Drawable navigationIcon;
        Screen screen = (Screen) getParent();
        ScreenStack screenStack = getScreenStack();
        if (screenStack == null || screenStack.getRootScreen() == screen) {
            z = true;
        } else {
            z = false;
        }
        if (screenStack == null || screenStack.getTopScreen() == screen) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.O0000o00 && z2) {
            if (!this.O0000OOo) {
                if (this.O0000Ooo.getParent() == null) {
                    getScreenFragment().O000000o(this.O0000Ooo);
                }
                AppCompatActivity appCompatActivity = (AppCompatActivity) getScreenFragment().getActivity();
                appCompatActivity.setSupportActionBar(this.O0000Ooo);
                ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                supportActionBar.O000000o(!z && !this.O0000Oo0);
                this.O0000Ooo.setNavigationOnClickListener(this.O0000o0);
                getScreenFragment().O000000o(this.O0000Oo);
                supportActionBar.O000000o(this.O00000o0);
                TextView titleTextView = getTitleTextView();
                int i = this.O00000o;
                if (i != 0) {
                    this.O0000Ooo.setTitleTextColor(i);
                }
                if (titleTextView != null) {
                    if (this.O00000oO != null) {
                        titleTextView.setTypeface(ReactFontManager.getInstance().getTypeface(this.O00000oO, 0, getContext().getAssets()));
                    }
                    float f = this.O00000oo;
                    if (f > 0.0f) {
                        titleTextView.setTextSize(f);
                    }
                }
                int i2 = this.O0000O0o;
                if (i2 != 0) {
                    this.O0000Ooo.setBackgroundColor(i2);
                }
                if (!(this.O0000OoO == 0 || (navigationIcon = this.O0000Ooo.getNavigationIcon()) == null)) {
                    navigationIcon.setColorFilter(this.O0000OoO, PorterDuff.Mode.SRC_ATOP);
                }
                for (int childCount = this.O0000Ooo.getChildCount() - 1; childCount >= 0; childCount--) {
                    if (this.O0000Ooo.getChildAt(childCount) instanceof ScreenStackHeaderSubview) {
                        this.O0000Ooo.removeViewAt(childCount);
                    }
                }
                int size = this.f5791O000000o.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ScreenStackHeaderSubview screenStackHeaderSubview = this.f5791O000000o.get(i3);
                    ScreenStackHeaderSubview.Type type = screenStackHeaderSubview.getType();
                    Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-1);
                    int i4 = AnonymousClass2.f5793O000000o[type.ordinal()];
                    if (i4 == 1) {
                        this.O0000Ooo.setNavigationIcon((Drawable) null);
                        this.O0000Ooo.setTitle((CharSequence) null);
                        layoutParams.f2633O000000o = 3;
                    } else if (i4 != 2) {
                        if (i4 == 3) {
                            layoutParams.width = -1;
                            this.O0000Ooo.setTitle((CharSequence) null);
                        } else if (i4 != 4) {
                        }
                        layoutParams.f2633O000000o = 1;
                    } else {
                        layoutParams.f2633O000000o = 5;
                    }
                    screenStackHeaderSubview.setLayoutParams(layoutParams);
                    this.O0000Ooo.addView(screenStackHeaderSubview);
                }
            } else if (this.O0000Ooo.getParent() != null) {
                getScreenFragment().O00000Oo();
            }
        }
    }

    /* renamed from: com.swmansion.rnscreens.ScreenStackHeaderConfig$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5793O000000o = new int[ScreenStackHeaderSubview.Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f5793O000000o[ScreenStackHeaderSubview.Type.LEFT.ordinal()] = 1;
            f5793O000000o[ScreenStackHeaderSubview.Type.RIGHT.ordinal()] = 2;
            f5793O000000o[ScreenStackHeaderSubview.Type.TITLE.ordinal()] = 3;
            try {
                f5793O000000o[ScreenStackHeaderSubview.Type.CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        if (getParent() != null) {
            O000000o();
        }
    }

    public int getConfigSubviewsCount() {
        return this.f5791O000000o.size();
    }

    private TextView getTitleTextView() {
        int childCount = this.O0000Ooo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.O0000Ooo.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (textView.getText().equals(this.O0000Ooo.getTitle())) {
                    return textView;
                }
            }
        }
        return null;
    }

    public void setTitle(String str) {
        this.O00000o0 = str;
    }

    public void setTitleFontFamily(String str) {
        this.O00000oO = str;
    }

    public void setTitleFontSize(float f) {
        this.O00000oo = f;
    }

    public void setTitleColor(int i) {
        this.O00000o = i;
    }

    public void setTintColor(int i) {
        this.O0000OoO = i;
    }

    public void setBackgroundColor(int i) {
        this.O0000O0o = i;
    }

    public void setHideShadow(boolean z) {
        this.O0000Oo = z;
    }

    public void setGestureEnabled(boolean z) {
        this.O00000Oo = z;
    }

    public void setHideBackButton(boolean z) {
        this.O0000Oo0 = z;
    }

    public void setHidden(boolean z) {
        this.O0000OOo = z;
    }
}

package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

public class ContextThemeWrapper extends ContextWrapper {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f2672O000000o;
    private Resources.Theme O00000Oo;
    private Configuration O00000o;
    private LayoutInflater O00000o0;
    private Resources O00000oO;

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context context, int i) {
        super(context);
        this.f2672O000000o = i;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.O00000Oo = theme;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.O00000oO != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.O00000o == null) {
            this.O00000o = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    public void setTheme(int i) {
        if (this.f2672O000000o != i) {
            this.f2672O000000o = i;
            O000000o();
        }
    }

    public int getThemeResId() {
        return this.f2672O000000o;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.O00000Oo;
        if (theme != null) {
            return theme;
        }
        if (this.f2672O000000o == 0) {
            this.f2672O000000o = 2132738832;
        }
        O000000o();
        return this.O00000Oo;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.O00000o0 == null) {
            this.O00000o0 = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.O00000o0;
    }

    private void O000000o() {
        if (this.O00000Oo == null) {
            this.O00000Oo = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.O00000Oo.setTo(theme);
            }
        }
        this.O00000Oo.applyStyle(this.f2672O000000o, true);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        if (this.O00000oO == null) {
            if (this.O00000o == null) {
                this.O00000oO = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.O00000oO = createConfigurationContext(this.O00000o).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration = new Configuration(resources.getConfiguration());
                configuration.updateFrom(this.O00000o);
                this.O00000oO = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration);
            }
        }
        return this.O00000oO;
    }
}

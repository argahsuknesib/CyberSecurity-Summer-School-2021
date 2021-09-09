package _m_j;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.gyf.immersionbar.BarHide;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import java.util.Map;

@TargetApi(19)
public final class awb implements awc {

    /* renamed from: O000000o  reason: collision with root package name */
    Activity f12656O000000o;
    Fragment O00000Oo;
    Window O00000o;
    android.app.Fragment O00000o0;
    awb O00000oO;
    boolean O00000oo;
    boolean O0000O0o;
    boolean O0000OOo;
    avv O0000Oo;
    avw O0000Oo0;
    int O0000OoO;
    awa O0000Ooo;
    int O0000o;
    boolean O0000o0;
    boolean O0000o00;
    int O0000o0O;
    int O0000o0o;
    private ViewGroup O0000oO;
    int O0000oO0;
    private ViewGroup O0000oOO;
    private boolean O0000oOo;
    private int O0000oo;
    private int O0000oo0;
    private Map<String, avw> O0000ooO;
    private int O0000ooo;
    private boolean O00oOooO;

    public final void O000000o() {
        if (Build.VERSION.SDK_INT >= 19 && this.O0000Oo0.O000OO0o) {
            if (this.O0000Oo0.O0000o00 && this.O0000Oo0.f12649O000000o != 0) {
                O000000o(this.O0000Oo0.f12649O000000o > -4539718, this.O0000Oo0.O0000o0O);
            }
            if (this.O0000Oo0.O0000o0 && this.O0000Oo0.O00000Oo != 0) {
                boolean z = this.O0000Oo0.O00000Oo > -4539718;
                float f = this.O0000Oo0.O0000o0o;
                this.O0000Oo0.O0000Ooo = z;
                if (z) {
                    if (!(awg.O00000Oo() || Build.VERSION.SDK_INT >= 26)) {
                        this.O0000Oo0.O00000oo = f;
                    }
                }
                avw avw = this.O0000Oo0;
                avw.O00000oo = avw.O0000O0o;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                O0000o0O();
                awb awb = this.O00000oO;
                if (awb != null) {
                    if (this.O00000oo) {
                        awb.O0000Oo0 = this.O0000Oo0;
                    }
                    if (this.O0000OOo) {
                        awb awb2 = this.O00000oO;
                        if (awb2.O0000o0) {
                            awb2.O0000Oo0.O000O0o0 = false;
                        }
                    }
                }
            }
            O00000Oo();
            O00000o0();
            if (Build.VERSION.SDK_INT >= 19) {
                if (this.O00000oo) {
                    awb awb3 = this.O00000oO;
                    if (awb3 != null) {
                        if (awb3.O0000Oo0.O000O0o0) {
                            awb awb4 = this.O00000oO;
                            if (awb4.O0000Ooo == null) {
                                awb4.O0000Ooo = new awa(awb4);
                            }
                            awb awb5 = this.O00000oO;
                            awb5.O0000Ooo.O000000o(awb5.O0000Oo0.O000O0o);
                        } else {
                            awa awa = this.O00000oO.O0000Ooo;
                            if (awa != null) {
                                awa.O000000o();
                            }
                        }
                    }
                } else if (this.O0000Oo0.O000O0o0) {
                    if (this.O0000Ooo == null) {
                        this.O0000Ooo = new awa(this);
                    }
                    this.O0000Ooo.O000000o(this.O0000Oo0.O000O0o);
                } else {
                    awa awa2 = this.O0000Ooo;
                    if (awa2 != null) {
                        awa2.O000000o();
                    }
                }
            }
            if (this.O0000Oo0.O0000oOO.size() != 0) {
                for (Map.Entry next : this.O0000Oo0.O0000oOO.entrySet()) {
                    View view = (View) next.getKey();
                    Integer valueOf = Integer.valueOf(this.O0000Oo0.f12649O000000o);
                    Integer valueOf2 = Integer.valueOf(this.O0000Oo0.O0000oO0);
                    for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                        Integer num = (Integer) entry.getKey();
                        valueOf2 = (Integer) entry.getValue();
                        valueOf = num;
                    }
                    if (view != null) {
                        if (Math.abs(this.O0000Oo0.O0000oOo - 0.0f) == 0.0f) {
                            view.setBackgroundColor(q.O000000o(valueOf.intValue(), valueOf2.intValue(), this.O0000Oo0.O00000o));
                        } else {
                            view.setBackgroundColor(q.O000000o(valueOf.intValue(), valueOf2.intValue(), this.O0000Oo0.O0000oOo));
                        }
                    }
                }
            }
            this.O0000o00 = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        int i;
        if (Build.VERSION.SDK_INT < 21 || awg.O00000o()) {
            O0000O0o();
            i = 256;
        } else {
            O00000oO();
            i = O00000o0(O00000Oo(O00000oo()));
        }
        this.O0000oO.setSystemUiVisibility(O000000o(i));
        O00000o();
        if (this.O0000Oo0.O000OO != null) {
            awe.O000000o().O000000o(this.f12656O000000o.getApplication());
        }
    }

    private void O00000o() {
        if (awg.O00000Oo()) {
            awl.O000000o(this.O00000o, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", this.O0000Oo0.O0000OoO);
            if (this.O0000Oo0.O000O0oO) {
                awl.O000000o(this.O00000o, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", this.O0000Oo0.O0000Ooo);
            }
        }
        if (!awg.O00000oO()) {
            return;
        }
        if (this.O0000Oo0.O000O0OO != 0) {
            awl.O000000o(this.f12656O000000o, this.O0000Oo0.O000O0OO);
        } else {
            awl.O000000o(this.f12656O000000o, this.O0000Oo0.O0000OoO);
        }
    }

    private void O00000oO() {
        if (Build.VERSION.SDK_INT >= 28 && !this.O0000o00) {
            WindowManager.LayoutParams attributes = this.O00000o.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.O00000o.setAttributes(attributes);
        }
    }

    private int O00000oo() {
        if (!this.O0000o00) {
            this.O0000Oo0.O00000o0 = this.O00000o.getNavigationBarColor();
        }
        int i = 1280;
        if (this.O0000Oo0.O0000OOo && this.O0000Oo0.O000O0oO) {
            i = 1792;
        }
        this.O00000o.clearFlags(67108864);
        if (this.O0000Oo.O00000o0) {
            this.O00000o.clearFlags(134217728);
        }
        this.O00000o.addFlags(Integer.MIN_VALUE);
        if (this.O0000Oo0.O0000o) {
            this.O00000o.setStatusBarColor(q.O000000o(this.O0000Oo0.f12649O000000o, this.O0000Oo0.O0000oO0, this.O0000Oo0.O00000o));
        } else {
            this.O00000o.setStatusBarColor(q.O000000o(this.O0000Oo0.f12649O000000o, 0, this.O0000Oo0.O00000o));
        }
        if (this.O0000Oo0.O000O0oO) {
            this.O00000o.setNavigationBarColor(q.O000000o(this.O0000Oo0.O00000Oo, this.O0000Oo0.O0000oO, this.O0000Oo0.O00000oo));
        } else {
            this.O00000o.setNavigationBarColor(this.O0000Oo0.O00000o0);
        }
        return i;
    }

    private void O0000O0o() {
        this.O00000o.addFlags(67108864);
        O0000OOo();
        if (this.O0000Oo.O00000o0 || awg.O00000o()) {
            if (!this.O0000Oo0.O000O0oO || !this.O0000Oo0.O000O0oo) {
                this.O00000o.clearFlags(134217728);
            } else {
                this.O00000o.addFlags(134217728);
            }
            if (this.O0000oo0 == 0) {
                this.O0000oo0 = this.O0000Oo.O00000o;
            }
            if (this.O0000oo == 0) {
                this.O0000oo = this.O0000Oo.O00000oO;
            }
            O0000Oo0();
        }
    }

    private void O0000OOo() {
        View findViewById = this.O0000oO.findViewById(avy.f12651O000000o);
        if (findViewById == null) {
            findViewById = new View(this.f12656O000000o);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.O0000Oo.f12648O000000o);
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(avy.f12651O000000o);
            this.O0000oO.addView(findViewById);
        }
        if (this.O0000Oo0.O0000o) {
            findViewById.setBackgroundColor(q.O000000o(this.O0000Oo0.f12649O000000o, this.O0000Oo0.O0000oO0, this.O0000Oo0.O00000o));
        } else {
            findViewById.setBackgroundColor(q.O000000o(this.O0000Oo0.f12649O000000o, 0, this.O0000Oo0.O00000o));
        }
    }

    private void O0000Oo0() {
        FrameLayout.LayoutParams layoutParams;
        View findViewById = this.O0000oO.findViewById(avy.O00000Oo);
        if (findViewById == null) {
            findViewById = new View(this.f12656O000000o);
            findViewById.setId(avy.O00000Oo);
            this.O0000oO.addView(findViewById);
        }
        if (this.O0000Oo.O000000o()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.O0000Oo.O00000o);
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.O0000Oo.O00000oO, -1);
            layoutParams.gravity = 8388613;
        }
        findViewById.setLayoutParams(layoutParams);
        findViewById.setBackgroundColor(q.O000000o(this.O0000Oo0.O00000Oo, this.O0000Oo0.O0000oO, this.O0000Oo0.O00000oo));
        if (!this.O0000Oo0.O000O0oO || !this.O0000Oo0.O000O0oo || this.O0000Oo0.O0000Oo0) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    /* renamed from: _m_j.awb$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12658O000000o = new int[BarHide.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f12658O000000o[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            f12658O000000o[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            f12658O000000o[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            try {
                f12658O000000o[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private int O000000o(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            int i2 = AnonymousClass2.f12658O000000o[this.O0000Oo0.O0000Oo.ordinal()];
            if (i2 == 1) {
                i |= 518;
            } else if (i2 == 2) {
                i |= 1028;
            } else if (i2 == 3) {
                i |= 514;
            } else if (i2 == 4) {
                i |= 0;
            }
        }
        return i | 4096;
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT < 21 || awg.O00000o()) {
                O0000Oo();
            } else {
                O0000Ooo();
            }
            O0000o0o();
        }
    }

    private void O0000Oo() {
        if (this.O0000Oo0.O00oOoOo) {
            this.O00oOooO = true;
            this.O0000oOO.post(this);
            return;
        }
        this.O00oOooO = false;
        O0000OoO();
    }

    public final void run() {
        O0000OoO();
    }

    private void O0000OoO() {
        O0000o0O();
        O0000o00();
        if (!this.O00000oo && awg.O00000o()) {
            O0000o0();
        }
    }

    private void O0000Ooo() {
        int i;
        O0000o0O();
        if (O000000o(this.O0000oO.findViewById(16908290))) {
            O000000o(0, 0, 0);
            return;
        }
        if (!this.O0000Oo0.O0000ooo || this.O0000ooo != 4) {
            i = 0;
        } else {
            i = this.O0000Oo.f12648O000000o;
        }
        if (this.O0000Oo0.O00oOoOo) {
            i = this.O0000Oo.f12648O000000o + this.O0000OoO;
        }
        O000000o(i, 0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070  */
    private void O0000o00() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (O000000o(this.O0000oO.findViewById(16908290))) {
            O000000o(0, 0, 0);
            return;
        }
        if (!this.O0000Oo0.O0000ooo || this.O0000ooo != 4) {
            i = 0;
        } else {
            i = this.O0000Oo.f12648O000000o;
        }
        if (this.O0000Oo0.O00oOoOo) {
            i = this.O0000Oo.f12648O000000o + this.O0000OoO;
        }
        if (this.O0000Oo.O00000o0 && this.O0000Oo0.O000O0oO && this.O0000Oo0.O000O0oo) {
            if (this.O0000Oo0.O0000OOo) {
                i3 = 0;
            } else if (this.O0000Oo.O000000o()) {
                i2 = this.O0000Oo.O00000o;
                i3 = 0;
                if (!this.O0000Oo0.O0000Oo0) {
                    if (this.O0000Oo.O000000o()) {
                        i4 = i3;
                    }
                } else if (!this.O0000Oo.O000000o()) {
                    i4 = this.O0000Oo.O00000oO;
                } else {
                    i4 = i3;
                }
                O000000o(i, i4, i2);
            } else {
                i3 = this.O0000Oo.O00000oO;
            }
            i2 = 0;
            if (!this.O0000Oo0.O0000Oo0) {
            }
            O000000o(i, i4, i2);
        }
        i2 = 0;
        O000000o(i, i4, i2);
    }

    private void O0000o0() {
        View findViewById = this.O0000oO.findViewById(avy.O00000Oo);
        if (!this.O0000Oo0.O000O0oO || !this.O0000Oo0.O000O0oo) {
            avz.O000000o().O00000Oo(this);
            findViewById.setVisibility(8);
        } else if (findViewById != null) {
            avz.O000000o().O000000o(this);
            avz.O000000o().O000000o(this.f12656O000000o.getApplication());
        }
    }

    private void O0000o0O() {
        this.O0000Oo = new avv(this.f12656O000000o);
        if (!this.O0000o00 || this.O00oOooO) {
            this.O0000OoO = this.O0000Oo.O00000Oo;
        }
    }

    public final void O000000o(boolean z) {
        View findViewById = this.O0000oO.findViewById(avy.O00000Oo);
        if (findViewById != null) {
            this.O0000Oo = new avv(this.f12656O000000o);
            int paddingBottom = this.O0000oOO.getPaddingBottom();
            int paddingRight = this.O0000oOO.getPaddingRight();
            if (!z) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
                if (!O000000o(this.O0000oO.findViewById(16908290))) {
                    if (this.O0000oo0 == 0) {
                        this.O0000oo0 = this.O0000Oo.O00000o;
                    }
                    if (this.O0000oo == 0) {
                        this.O0000oo = this.O0000Oo.O00000oO;
                    }
                    if (!this.O0000Oo0.O0000Oo0) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                        if (this.O0000Oo.O000000o()) {
                            layoutParams.gravity = 80;
                            layoutParams.height = this.O0000oo0;
                            if (!this.O0000Oo0.O0000OOo) {
                                paddingBottom = this.O0000oo0;
                                paddingRight = 0;
                                findViewById.setLayoutParams(layoutParams);
                            }
                        } else {
                            layoutParams.gravity = 8388613;
                            layoutParams.width = this.O0000oo;
                            if (!this.O0000Oo0.O0000OOo) {
                                paddingRight = this.O0000oo;
                                paddingBottom = 0;
                                findViewById.setLayoutParams(layoutParams);
                            }
                        }
                        paddingBottom = 0;
                        paddingRight = 0;
                        findViewById.setLayoutParams(layoutParams);
                    }
                    O000000o(this.O0000oOO.getPaddingTop(), paddingRight, paddingBottom);
                }
            }
            paddingBottom = 0;
            paddingRight = 0;
            O000000o(this.O0000oOO.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    private int O00000Oo(int i) {
        return (Build.VERSION.SDK_INT < 23 || !this.O0000Oo0.O0000OoO) ? i : i | 8192;
    }

    private int O00000o0(int i) {
        return (Build.VERSION.SDK_INT < 26 || !this.O0000Oo0.O0000Ooo) ? i : i | 16;
    }

    private void O0000o0o() {
        int O00000Oo2 = this.O0000Oo0.O000O00o ? O00000Oo(this.f12656O000000o) : 0;
        int i = this.O0000ooo;
        if (i == 1) {
            O000000o(this.f12656O000000o, O00000Oo2, this.O0000Oo0.O00oOooO);
        } else if (i == 2) {
            O00000Oo(this.f12656O000000o, O00000Oo2, this.O0000Oo0.O00oOooO);
        } else if (i == 3) {
            O00000o0(this.f12656O000000o, O00000Oo2, this.O0000Oo0.O00oOooo);
        }
    }

    private void O000000o(int i, int i2, int i3) {
        ViewGroup viewGroup = this.O0000oOO;
        if (viewGroup != null) {
            viewGroup.setPadding(0, i, i2, i3);
        }
        this.O0000o0O = 0;
        this.O0000o0o = i;
        this.O0000o = i2;
        this.O0000oO0 = i3;
    }

    private static boolean O0000o() {
        return awg.O00000Oo() || awg.O00000oO() || Build.VERSION.SDK_INT >= 23;
    }

    private static void O000000o(Activity activity, final int i, View... viewArr) {
        if (Build.VERSION.SDK_INT >= 19 && activity != null) {
            if (i < 0) {
                i = 0;
            }
            for (int i2 = 0; i2 <= 0; i2++) {
                final View view = viewArr[i2];
                if (view != null) {
                    final Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() != i) {
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i));
                        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-1, -2);
                        }
                        if (layoutParams.height == -2 || layoutParams.height == -1) {
                            view.post(new Runnable() {
                                /* class _m_j.awb.AnonymousClass1 */

                                public final void run() {
                                    layoutParams.height = (view.getHeight() + i) - num.intValue();
                                    View view = view;
                                    view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                                    view.setLayoutParams(layoutParams);
                                }
                            });
                        } else {
                            layoutParams.height += i - num.intValue();
                            view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                            view.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
        }
    }

    private static void O00000Oo(Activity activity, int i, View... viewArr) {
        if (Build.VERSION.SDK_INT >= 19 && activity != null) {
            if (i < 0) {
                i = 0;
            }
            for (int i2 = 0; i2 <= 0; i2++) {
                View view = viewArr[i2];
                if (view != null) {
                    Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() != i) {
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i));
                        Object layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (marginLayoutParams.topMargin + i) - num.intValue(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                        view.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }

    private static void O00000o0(Activity activity, int i, View... viewArr) {
        if (Build.VERSION.SDK_INT >= 19 && activity != null) {
            if (i < 0) {
                i = 0;
            }
            for (int i2 = 0; i2 <= 0; i2++) {
                View view = viewArr[i2];
                if (view != null) {
                    Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() != i) {
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i));
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-1, 0);
                        }
                        layoutParams.height = i;
                        view.setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    public static boolean O000000o(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (((childAt instanceof DrawerLayout) && O000000o(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    @TargetApi(14)
    public static int O00000Oo(Activity activity) {
        return new avv(activity).f12648O000000o;
    }

    awb(Activity activity) {
        this.O0000oOo = false;
        this.O00000oo = false;
        this.O0000O0o = false;
        this.O0000OOo = false;
        this.O0000oo0 = 0;
        this.O0000oo = 0;
        this.O0000OoO = 0;
        this.O0000Ooo = null;
        this.O0000ooO = new HashMap();
        this.O0000ooo = 0;
        this.O0000o00 = false;
        this.O00oOooO = false;
        this.O0000o0 = false;
        this.O0000o0O = 0;
        this.O0000o0o = 0;
        this.O0000o = 0;
        this.O0000oO0 = 0;
        this.O0000oOo = true;
        this.f12656O000000o = activity;
        O000000o(this.f12656O000000o.getWindow());
    }

    private void O000000o(Window window) {
        this.O00000o = window;
        this.O0000Oo0 = new avw();
        this.O0000oO = (ViewGroup) this.O00000o.getDecorView();
        this.O0000oOO = (ViewGroup) this.O0000oO.findViewById(16908290);
    }

    public final awb O000000o(boolean z, float f) {
        this.O0000Oo0.O0000OoO = z;
        if (!z || O0000o()) {
            avw avw = this.O0000Oo0;
            avw.O000O0OO = avw.O000O0Oo;
            avw avw2 = this.O0000Oo0;
            avw2.O00000o = avw2.O00000oO;
        } else {
            this.O0000Oo0.O00000o = f;
        }
        return this;
    }

    public static awb O000000o(Activity activity) {
        awk O000000o2 = awk.O000000o();
        awk.O000000o(activity, "activity is null");
        String str = O000000o2.f12663O000000o + System.identityHashCode(activity);
        if (activity instanceof FragmentActivity) {
            ee supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            awm awm = (awm) supportFragmentManager.O000000o(str);
            if (awm == null && (awm = O000000o2.O00000o.get(supportFragmentManager)) == null) {
                awm = new awm();
                O000000o2.O00000o.put(supportFragmentManager, awm);
                supportFragmentManager.O000000o().O000000o(awm, str).O00000o0();
                O000000o2.O00000Oo.obtainMessage(2, supportFragmentManager).sendToTarget();
            }
            if (awm.f12666O000000o == null) {
                awm.f12666O000000o = new awd(activity);
            }
            return awm.f12666O000000o.f12659O000000o;
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        awj awj = (awj) fragmentManager.findFragmentByTag(str);
        if (awj == null && (awj = O000000o2.O00000o0.get(fragmentManager)) == null) {
            awj = new awj();
            O000000o2.O00000o0.put(fragmentManager, awj);
            fragmentManager.beginTransaction().add(awj, str).commitAllowingStateLoss();
            O000000o2.O00000Oo.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (awj.f12662O000000o == null) {
            awj.f12662O000000o = new awd(activity);
        }
        return awj.f12662O000000o.f12659O000000o;
    }

    public final awb O00000Oo(View view) {
        if (view == null || view == null) {
            return this;
        }
        if (this.O0000ooo == 0) {
            this.O0000ooo = 1;
        }
        avw avw = this.O0000Oo0;
        avw.O00oOooO = view;
        avw.O0000o = true;
        return this;
    }
}

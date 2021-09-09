package _m_j;

import _m_j.OO0o000;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuBuilder;
import com.xiaomi.smarthome.R;

public class OO0Oo0 {

    /* renamed from: O000000o  reason: collision with root package name */
    protected View f12305O000000o;
    protected int O00000Oo;
    private final Context O00000o;
    PopupWindow.OnDismissListener O00000o0;
    private final MenuBuilder O00000oO;
    private final boolean O00000oo;
    private final int O0000O0o;
    private final int O0000OOo;
    private OO0o000.O000000o O0000Oo;
    private boolean O0000Oo0;
    private OO0Oo00 O0000OoO;
    private final PopupWindow.OnDismissListener O0000Ooo;

    public OO0Oo0(Context context, MenuBuilder menuBuilder, View view, boolean z) {
        this(context, menuBuilder, view, z, R.attr.actionOverflowMenuStyle, 0);
    }

    public OO0Oo0(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.O00000Oo = 8388611;
        this.O0000Ooo = new PopupWindow.OnDismissListener() {
            /* class _m_j.OO0Oo0.AnonymousClass1 */

            public final void onDismiss() {
                OO0Oo0.this.O00000o();
            }
        };
        this.O00000o = context;
        this.O00000oO = menuBuilder;
        this.f12305O000000o = view;
        this.O00000oo = z;
        this.O0000O0o = i;
        this.O0000OOo = i2;
    }

    public final void O000000o(boolean z) {
        this.O0000Oo0 = z;
        OO0Oo00 oO0Oo00 = this.O0000OoO;
        if (oO0Oo00 != null) {
            oO0Oo00.O000000o(z);
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v9, types: [_m_j.OO0Oo00] */
    /* JADX WARN: Type inference failed for: r7v1, types: [_m_j.OOO000o] */
    /* JADX WARN: Type inference failed for: r1v13, types: [_m_j.OO0O0o0] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    public final _m_j.OO0Oo00 O000000o() {
        /*
            r14 = this;
            _m_j.OO0Oo00 r0 = r14.O0000OoO
            if (r0 != 0) goto L_0x0083
            android.content.Context r0 = r14.O00000o
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r2 < r3) goto L_0x0021
            r0.getRealSize(r1)
            goto L_0x0024
        L_0x0021:
            r0.getSize(r1)
        L_0x0024:
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.O00000o
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2132017175(0x7f140017, float:1.967262E38)
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x003d
            r0 = 1
            goto L_0x003e
        L_0x003d:
            r0 = 0
        L_0x003e:
            if (r0 == 0) goto L_0x0051
            _m_j.OO0O0o0 r0 = new _m_j.OO0O0o0
            android.content.Context r2 = r14.O00000o
            android.view.View r3 = r14.f12305O000000o
            int r4 = r14.O0000O0o
            int r5 = r14.O0000OOo
            boolean r6 = r14.O00000oo
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0063
        L_0x0051:
            _m_j.OOO000o r0 = new _m_j.OOO000o
            android.content.Context r8 = r14.O00000o
            androidx.appcompat.view.menu.MenuBuilder r9 = r14.O00000oO
            android.view.View r10 = r14.f12305O000000o
            int r11 = r14.O0000O0o
            int r12 = r14.O0000OOo
            boolean r13 = r14.O00000oo
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x0063:
            androidx.appcompat.view.menu.MenuBuilder r1 = r14.O00000oO
            r0.O000000o(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.O0000Ooo
            r0.O000000o(r1)
            android.view.View r1 = r14.f12305O000000o
            r0.O000000o(r1)
            _m_j.OO0o000$O000000o r1 = r14.O0000Oo
            r0.setCallback(r1)
            boolean r1 = r14.O0000Oo0
            r0.O000000o(r1)
            int r1 = r14.O00000Oo
            r0.O000000o(r1)
            r14.O0000OoO = r0
        L_0x0083:
            _m_j.OO0Oo00 r0 = r14.O0000OoO
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.OO0Oo0.O000000o():_m_j.OO0Oo00");
    }

    public final boolean O00000Oo() {
        if (O00000oO()) {
            return true;
        }
        if (this.f12305O000000o == null) {
            return false;
        }
        O000000o(0, 0, false, false);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, int i2, boolean z, boolean z2) {
        OO0Oo00 O000000o2 = O000000o();
        O000000o2.O00000Oo(z2);
        if (z) {
            if ((bk.O000000o(this.O00000Oo, cb.O0000Oo0(this.f12305O000000o)) & 7) == 5) {
                i -= this.f12305O000000o.getWidth();
            }
            O000000o2.O00000Oo(i);
            O000000o2.O00000o0(i2);
            int i3 = (int) ((this.O00000o.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            O000000o2.O0000O0o = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        O000000o2.a_();
    }

    public final void O00000o0() {
        if (O00000oO()) {
            this.O0000OoO.O00000Oo();
        }
    }

    /* access modifiers changed from: protected */
    public void O00000o() {
        this.O0000OoO = null;
        PopupWindow.OnDismissListener onDismissListener = this.O00000o0;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final boolean O00000oO() {
        OO0Oo00 oO0Oo00 = this.O0000OoO;
        return oO0Oo00 != null && oO0Oo00.O00000o0();
    }

    public final void O000000o(OO0o000.O000000o o000000o) {
        this.O0000Oo = o000000o;
        OO0Oo00 oO0Oo00 = this.O0000OoO;
        if (oO0Oo00 != null) {
            oO0Oo00.setCallback(o000000o);
        }
    }
}

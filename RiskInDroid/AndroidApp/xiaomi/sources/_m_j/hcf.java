package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.card.BaseCardRender;
import com.xiaomi.smarthome.newui.widget.cards.UpdateInterceptor;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class hcf<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> implements hcy<T>, UpdateInterceptor {

    /* renamed from: O000000o  reason: collision with root package name */
    public final T[] f18773O000000o;
    public int O00000Oo;
    public String O00000o;
    public List<hdb> O00000o0;
    public double O00000oO;
    protected hhk O00000oo;
    protected BaseCardRender<C, E, T> O0000O0o;
    public Activity O0000OOo;
    protected final int O0000Oo = 200;
    public boolean O0000Oo0 = false;
    public Map<View, ValueAnimator> O0000OoO = new ArrayMap();
    public final E O0000Ooo;
    public View.OnClickListener O0000o0 = new View.OnClickListener() {
        /* class _m_j.hcf.AnonymousClass1 */

        public final void onClick(final View view) {
            hzf.O00000oO(view);
            ValueAnimator valueAnimator = hcf.this.O0000OoO.get(view);
            if (valueAnimator != null) {
                valueAnimator.cancel();
                valueAnimator = null;
            }
            if (valueAnimator == null) {
                valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimator.setDuration(200L);
            }
            valueAnimator.removeAllListeners();
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class _m_j.hcf.AnonymousClass1.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 0.5f) {
                        float f = 1.0f - floatValue;
                        view.setScaleX(f);
                        view.setScaleY(f);
                        return;
                    }
                    view.setScaleX(floatValue);
                    view.setScaleY(floatValue);
                }
            });
            valueAnimator.start();
        }
    };
    public ViewGroup O0000o00;
    protected BaseCardRender.DataInitState O0000o0O = BaseCardRender.DataInitState.NOT;

    public void O000000o() {
    }

    public void O00000Oo() {
    }

    public void onUpdateViewBackgroud(View view, int i, int i2) {
    }

    public void onUpdateViewScale(View view, int i, float f) {
    }

    public void onUpdateViewTransitionY(View view, int i, float f) {
    }

    public void onUpdateViewZ(View view, int i, float f) {
    }

    public hcf(E e, T[] tArr) {
        this.O0000Ooo = e;
        this.f18773O000000o = tArr;
        if (e != null) {
            this.O00000Oo = e.O00000Oo;
            this.O00000oO = e.f18769O000000o;
            this.O00000o0 = e.O00000o;
            this.O00000o = e.O00000oO;
        }
    }

    public final void O000000o(BaseCardRender.DataInitState dataInitState) {
        this.O0000o0O = dataInitState;
    }

    public final void O000000o(hhk hhk) {
        this.O00000oo = hhk;
    }

    public static String O000000o(String str) {
        double d;
        double d2;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.equals("null")) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (int length = str.length(); length > 0; length -= 2) {
                sb.append(str.substring(length - 2, length));
            }
            String sb2 = sb.reverse().toString();
            long j = 0;
            for (int i = 0; i < sb2.length(); i++) {
                char charAt = sb2.charAt(i);
                if (charAt < '0' || charAt > '9') {
                    if (charAt >= 'a' && charAt <= 'f') {
                        d = (double) j;
                        double d3 = (double) ((charAt - 'a') + 10);
                        double pow = Math.pow(16.0d, (double) i);
                        Double.isNaN(d3);
                        d2 = d3 * pow;
                        Double.isNaN(d);
                    }
                } else {
                    d = (double) j;
                    double d4 = (double) (charAt - '0');
                    double pow2 = Math.pow(16.0d, (double) i);
                    Double.isNaN(d4);
                    d2 = d4 * pow2;
                    Double.isNaN(d);
                }
                j = (long) (d + d2);
            }
            return String.valueOf(j);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public final View O000000o(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        inflate.setTag(-3837, this.O0000Ooo);
        viewGroup.addView(inflate);
        this.O0000OOo = (Activity) viewGroup.getContext();
        return inflate;
    }

    public static int O00000Oo(String str) {
        Resources resources = CommonApplication.getAppContext().getResources();
        if (TextUtils.isEmpty(str)) {
            return resources.getColor(R.color.mj_com_facebook_blue);
        }
        int identifier = resources.getIdentifier(str, "color", CommonApplication.getAppContext().getPackageName());
        return identifier == 0 ? resources.getColor(R.color.mj_com_facebook_blue) : identifier;
    }

    public void O000000o(View view) {
        View.OnClickListener onClickListener = this.O0000o0;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        Device device = this.O0000O0o.O00000oO;
        gsy.O000000o(4, "mijia-card", "card click model:" + device.model + " did:" + device.did + " cardType:" + ((Object) this.O0000Ooo) + " anim:" + this.O0000o0);
    }

    public void onUpdateViewAlpha(View view, int i, float f) {
        if (cb.O0000OOo(view) != f) {
            cb.O00000o0(view, f);
        }
    }

    public static boolean O000000o(hdi hdi) {
        return hdi == null || JSONObject.NULL.equals(hdi.f18812O000000o) || "".equals(hdi.f18812O000000o);
    }

    public void O00000o0() {
        Map<View, ValueAnimator> map = this.O0000OoO;
        for (ValueAnimator cancel : map.values()) {
            cancel.cancel();
        }
        map.clear();
        hhk hhk = this.O00000oo;
        if (hhk != null) {
            hhk.setCallback(null);
        }
        this.O0000OOo = null;
        this.O00000oo = null;
        this.O0000Oo0 = true;
    }

    public void O000000o(ViewGroup viewGroup, int i, int i2) {
        this.O0000Oo0 = false;
        this.O0000o00 = viewGroup;
    }

    public final View O00000o() {
        return this.O0000O0o.O00000o();
    }

    public final void O000000o(BaseCardRender baseCardRender) {
        this.O0000O0o = baseCardRender;
    }

    public final Device O00000oO() {
        return this.O0000O0o.O00000oO;
    }

    public final C O00000oo() {
        return this.O0000O0o.O00000Oo;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: E
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
    public final void O000000o(_m_j.hdb r10, com.xiaomi.smarthome.device.Device r11, T r12, java.lang.Object r13, _m_j.fsm<org.json.JSONObject, _m_j.fso> r14) {
        /*
            r9 = this;
            com.xiaomi.smarthome.newui.card.BaseCardRender<C, E, T> r14 = r9.O0000O0o
            _m_j.hdg r14 = r14.O0000OOo
            if (r14 != 0) goto L_0x0011
            E r0 = r9.O0000Ooo
            r5 = 0
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r0.O000000o(r1, r2, r3, r4, r5)
            return
        L_0x0011:
            com.xiaomi.smarthome.newui.card.BaseCardRender<C, E, T> r14 = r9.O0000O0o
            _m_j.hdg r0 = r14.O0000OOo
            E r1 = r9.O0000Ooo
            _m_j.hcf$2 r14 = new _m_j.hcf$2
            r4 = 0
            r2 = r14
            r3 = r9
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r10
            r2.<init>(r4, r5, r6, r7, r8)
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r0.sendRequest(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.hcf.O000000o(_m_j.hdb, com.xiaomi.smarthome.device.Device, java.lang.Object, java.lang.Object, _m_j.fsm):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: E
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public boolean O000000o(com.xiaomi.smarthome.device.Device r4, _m_j.hdb r5) {
        /*
            r3 = this;
            boolean r0 = r4.isOnline
            r1 = 0
            if (r0 == 0) goto L_0x002e
            boolean r0 = r4.isSharedReadOnly()
            if (r0 != 0) goto L_0x002e
            com.xiaomi.smarthome.newui.card.BaseCardRender$DataInitState r0 = r3.O0000o0O
            com.xiaomi.smarthome.newui.card.BaseCardRender$DataInitState r2 = com.xiaomi.smarthome.newui.card.BaseCardRender.DataInitState.NOT
            if (r0 == r2) goto L_0x002e
            com.xiaomi.smarthome.newui.card.BaseCardRender$DataInitState r0 = r3.O0000o0O
            com.xiaomi.smarthome.newui.card.BaseCardRender$DataInitState r2 = com.xiaomi.smarthome.newui.card.BaseCardRender.DataInitState.DOING
            if (r0 != r2) goto L_0x0018
            goto L_0x002e
        L_0x0018:
            java.util.List<_m_j.hdb> r0 = r3.O00000o0
            if (r0 == 0) goto L_0x002c
            int r0 = r0.size()
            if (r0 == 0) goto L_0x002c
            E r0 = r3.O0000Ooo
            boolean r4 = r0.O000000o(r4, r5)
            if (r4 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            return r1
        L_0x002c:
            r4 = 1
            return r4
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.hcf.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hdb):boolean");
    }
}

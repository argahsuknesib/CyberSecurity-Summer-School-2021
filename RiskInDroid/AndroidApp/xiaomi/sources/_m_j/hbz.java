package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.content.Context;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.card.BaseCardRender;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class hbz<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends BaseCardRender<C, E, T> {
    public hbz(C c, ArrayList<? extends hcf<C, E, T>> arrayList, ViewGroup viewGroup, Context context, Device device) {
        super(c, arrayList, viewGroup, context, device);
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
    protected final void O000000o(android.view.ViewGroup r11, com.xiaomi.smarthome.device.Device r12) {
        /*
            r10 = this;
            r0 = 2132153825(0x7f1615e1, float:1.994978E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            java.lang.String r1 = r12.getName()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0017
            return
        L_0x0017:
            r0.setText(r1)
            r1 = 2132153935(0x7f16164f, float:1.9950003E38)
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            com.xiaomi.smarthome.device.Device r2 = r10.O00000oO
            boolean r2 = r2 instanceof com.xiaomi.smarthome.device.BleDevice
            r3 = 2131952158(0x7f13021e, float:1.954075E38)
            r4 = 0
            if (r2 == 0) goto L_0x0083
            r5 = 0
            java.util.ArrayList r2 = r10.f10206O000000o
            java.util.Iterator r2 = r2.iterator()
        L_0x0035:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0053
            java.lang.Object r7 = r2.next()
            _m_j.hcf r7 = (_m_j.hcf) r7
            E r8 = r7.O0000Ooo
            T[] r7 = r7.f18773O000000o
            java.lang.Object r7 = _m_j.hfa.O000000o(r7)
            long r7 = r8.O00000oO(r12, r7)
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x0035
            r5 = r7
            goto L_0x0035
        L_0x0053:
            boolean r2 = _m_j.hcg.O000000o(r5)
            if (r2 == 0) goto L_0x0077
            if (r1 == 0) goto L_0x0077
            r1.setVisibility(r4)
            android.content.res.Resources r2 = r11.getResources()
            int r2 = r2.getColor(r3)
            r1.setTextColor(r2)
            android.content.res.Resources r2 = r11.getResources()
            r4 = 2132678939(0x7f1e191b, float:2.1014838E38)
            java.lang.String r2 = r2.getString(r4)
            r1.setText(r2)
        L_0x0077:
            android.content.res.Resources r11 = r11.getResources()
            int r11 = r11.getColor(r3)
            r0.setTextColor(r11)
            goto L_0x00d4
        L_0x0083:
            com.xiaomi.smarthome.device.Device r2 = r10.O00000oO
            boolean r2 = r2.isOnline
            r5 = 2132674191(0x7f1e068f, float:2.1005208E38)
            if (r2 != 0) goto L_0x00ab
            if (r1 == 0) goto L_0x009c
            r1.setVisibility(r4)
            android.content.res.Resources r2 = r11.getResources()
            java.lang.String r2 = r2.getString(r5)
            r1.setText(r2)
        L_0x009c:
            android.content.res.Resources r11 = r11.getResources()
            r1 = 2131952203(0x7f13024b, float:1.9540842E38)
            int r11 = r11.getColor(r1)
            r0.setTextColor(r11)
            goto L_0x00d4
        L_0x00ab:
            com.xiaomi.smarthome.newui.card.BaseCardRender$DataInitState r2 = r10.O00000oo
            com.xiaomi.smarthome.newui.card.BaseCardRender$DataInitState r6 = com.xiaomi.smarthome.newui.card.BaseCardRender.DataInitState.NOT
            if (r2 != r6) goto L_0x00c2
            if (r1 == 0) goto L_0x00c9
            r1.setVisibility(r4)
            android.content.res.Resources r2 = r11.getResources()
            java.lang.String r2 = r2.getString(r5)
            r1.setText(r2)
            goto L_0x00c9
        L_0x00c2:
            if (r1 == 0) goto L_0x00c9
            r2 = 8
            r1.setVisibility(r2)
        L_0x00c9:
            android.content.res.Resources r11 = r11.getResources()
            int r11 = r11.getColor(r3)
            r0.setTextColor(r11)
        L_0x00d4:
            boolean r11 = _m_j.gfr.O0000Oo0
            if (r11 != 0) goto L_0x00fe
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.CharSequence r1 = r0.getText()
            r11.append(r1)
            _m_j.hcc r1 = r10.O00000Oo
            boolean r1 = r1 instanceof _m_j.hep
            if (r1 == 0) goto L_0x00ed
            java.lang.String r1 = "/Spec/"
            goto L_0x00ef
        L_0x00ed:
            java.lang.String r1 = "/Profile/"
        L_0x00ef:
            r11.append(r1)
            java.lang.String r12 = r12.did
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r0.setText(r11)
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.hbz.O000000o(android.view.ViewGroup, com.xiaomi.smarthome.device.Device):void");
    }

    public final BaseCardRender.LayoutPosition O000000o(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return BaseCardRender.LayoutPosition.CONTENT;
        }
        if (viewGroup.getId() == R.id.ll_title_content) {
            return BaseCardRender.LayoutPosition.TITLE;
        }
        return BaseCardRender.LayoutPosition.CONTENT;
    }

    public final void O000000o(String str, Object obj) {
        gsy.O00000Oo("mijia-card", "BaseCardRender notifyChange prop:" + str + " value:" + obj + " did:" + this.O00000oO.did);
        if (this.O00000o0 != null) {
            this.O00000o0.post(new Runnable() {
                /* class _m_j.$$Lambda$hbz$NnyyxdD8JpihsrQb4vpt_XDm4k */

                public final void run() {
                    hbz.this.O0000O0o();
                }
            });
        }
    }

    public final void O000000o(hhd hhd) {
        if (this.f10206O000000o != null) {
            Iterator it = this.f10206O000000o.iterator();
            while (it.hasNext()) {
                ((hcf) it.next()).O000000o(hhd);
            }
        }
    }

    /* access modifiers changed from: private */
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
    public /* synthetic */ void O0000O0o() {
        /*
            r6 = this;
            android.view.ViewGroup r0 = r6.O00000o0
            com.xiaomi.smarthome.device.Device r1 = r6.O00000oO
            r6.O000000o(r0, r1)
            java.util.ArrayList r0 = r6.f10206O000000o
            java.util.Iterator r0 = r0.iterator()
        L_0x000d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.next()
            _m_j.hcf r1 = (_m_j.hcf) r1
            com.xiaomi.smarthome.newui.card.BaseCardRender$DataInitState r2 = r6.O00000oo
            r1.O000000o(r2)
            T[] r2 = r1.f18773O000000o
            java.lang.Object r2 = _m_j.hfa.O000000o(r2)
            E r3 = r1.O0000Ooo
            com.xiaomi.smarthome.device.Device r4 = r6.O00000oO
            T[] r5 = r1.f18773O000000o
            java.lang.Object r5 = _m_j.hfa.O000000o(r5)
            java.lang.Object r3 = r3.O00000Oo(r4, r5)
            r1.O000000o(r2, r3)
            goto L_0x000d
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.hbz.O0000O0o():void");
    }
}

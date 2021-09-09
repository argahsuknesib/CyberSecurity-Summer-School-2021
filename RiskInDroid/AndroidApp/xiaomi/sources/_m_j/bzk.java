package _m_j;

import android.content.Intent;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.buy.model.OrderPaymentInfo;
import com.mi.global.shop.model.cod.Result;
import com.mi.global.shop.widget.CommonButton;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.CustomTextView;
import com.squareup.wire.Wire;
import com.xiaomi.smarthome.R;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class bzk implements TextWatcher, View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public Handler f13480O000000o = null;
    public TimerTask O00000Oo = null;
    public View O00000o = null;
    public Timer O00000o0 = null;
    public ConfirmActivity O00000oO = null;
    public OrderPaymentInfo O00000oo = null;
    public String O0000O0o = null;
    public LinearLayout O0000OOo = null;
    public LinearLayout O0000Oo = null;
    public LinearLayout O0000Oo0 = null;
    public CommonButton O0000OoO = null;
    public CustomTextView O0000Ooo = null;
    public CustomEditTextView O0000o = null;
    public CommonButton O0000o0 = null;
    public CustomTextView O0000o00 = null;
    public CustomTextView O0000o0O = null;
    public CustomTextView O0000o0o = null;
    public CustomTextView O0000oO = null;
    public SimpleDraweeView O0000oO0 = null;
    public CustomTextView O0000oOO = null;
    public CustomEditTextView O0000oOo = null;
    private boolean O0000oo0 = false;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public bzk(ConfirmActivity confirmActivity, View view, OrderPaymentInfo orderPaymentInfo) {
        this.O00000o = view;
        this.O00000oO = confirmActivity;
        this.O00000oo = orderPaymentInfo;
        OrderPaymentInfo orderPaymentInfo2 = this.O00000oo;
        if (orderPaymentInfo2 != null) {
            this.O0000O0o = cav.O00000oO(orderPaymentInfo2.f4866O000000o);
        }
    }

    public final void O000000o() {
        OrderPaymentInfo orderPaymentInfo = this.O00000oo;
        if (orderPaymentInfo != null) {
            int i = orderPaymentInfo.O0000o0O;
            if (i == 0) {
                O00000oo();
            } else if (i == 1) {
                O0000OOo();
            } else if (i == 2) {
                O0000O0o();
            } else if (i == 3) {
                O00000oO();
            }
        }
    }

    private void O00000oO() {
        this.O0000OOo.setVisibility(8);
        this.O0000Oo0.setVisibility(8);
        this.O0000Oo.setVisibility(8);
        this.O0000Ooo.setVisibility(0);
    }

    private void O00000oo() {
        OrderPaymentInfo orderPaymentInfo = this.O00000oo;
        if (orderPaymentInfo != null && orderPaymentInfo.O0000o0O == 0) {
            this.O0000OoO.setOnClickListener(this);
            this.O0000OoO.setEnabled(true);
        }
        this.O0000OOo.setVisibility(8);
        this.O0000Oo0.setVisibility(8);
        this.O0000Oo.setVisibility(0);
        ImageView imageView = (ImageView) this.O0000Oo.findViewById(R.id.buy_confirm_cod_confirm_pic_noverify);
        CustomTextView customTextView = (CustomTextView) this.O0000Oo.findViewById(R.id.buy_confirm_cod_confirm_tip_noverify);
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (customTextView != null) {
            customTextView.setVisibility(0);
        }
        this.O0000Ooo.setVisibility(8);
    }

    private void O0000O0o() {
        this.O0000OOo.setVisibility(8);
        this.O0000Oo0.setVisibility(0);
        this.O0000Oo.setVisibility(0);
        this.O0000Ooo.setVisibility(8);
    }

    public final void O00000Oo() {
        cbq.O000000o(this.O0000O0o, this.O0000oO0);
    }

    public final void O00000o0() {
        if (this.O0000O0o != null) {
            ccr.O00000Oo("CODViewHelper", "refreshPic");
            this.O0000O0o = cav.O00000oO(this.O00000oo.f4866O000000o);
            O00000Oo();
        }
    }

    private void O0000OOo() {
        this.O0000OOo.setVisibility(0);
        this.O0000Oo0.setVisibility(8);
        this.O0000Oo.setVisibility(0);
        this.O0000Ooo.setVisibility(8);
        this.O0000o0O.setVisibility(8);
        this.O0000o00.setText(byl.O00000oO().getString(R.string.user_address_phoneareacode) + this.O00000oo.O00000o0);
    }

    public final void O00000o() {
        Timer timer = this.O00000o0;
        if (timer != null) {
            timer.cancel();
        }
        Handler handler = this.f13480O000000o;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.android.volley.Request] */
    /* JADX WARN: Type inference failed for: r11v1, types: [_m_j.cah] */
    /* JADX WARN: Type inference failed for: r5v12, types: [_m_j.cai] */
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
    public final void onClick(android.view.View r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            com.mi.global.shop.widget.CommonButton r2 = r0.O0000o0
            java.lang.String r3 = "phone"
            java.lang.String r4 = "order_id"
            r5 = 0
            r6 = 1
            if (r1 != r2) goto L_0x00d7
            com.mi.global.shop.buy.model.OrderPaymentInfo r1 = r0.O00000oo
            int r2 = r1.O0000o0o
            int r2 = r2 + r6
            r1.O0000o0o = r2
            com.mi.global.shop.widget.CommonButton r1 = r0.O0000o0
            com.mi.global.shop.buy.ConfirmActivity r2 = r0.O00000oO
            r7 = 2132673206(0x7f1e02b6, float:2.100321E38)
            java.lang.String r2 = r2.getString(r7)
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r7 = 60
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6[r5] = r7
            java.lang.String r2 = java.lang.String.format(r2, r6)
            r1.setText(r2)
            com.mi.global.shop.widget.CommonButton r1 = r0.O0000o0
            r1.setEnabled(r5)
            com.mi.global.shop.widget.CommonButton r1 = r0.O0000o0
            java.lang.String r2 = "#ffffffff"
            int r2 = android.graphics.Color.parseColor(r2)
            r1.setTextColor(r2)
            java.util.Timer r1 = r0.O00000o0
            if (r1 == 0) goto L_0x0048
            r1.cancel()
        L_0x0048:
            java.util.Timer r1 = new java.util.Timer
            r1.<init>()
            r0.O00000o0 = r1
            _m_j.bzk$1 r1 = new _m_j.bzk$1
            r1.<init>()
            r0.f13480O000000o = r1
            _m_j.bzk$5 r1 = new _m_j.bzk$5
            r1.<init>()
            r0.O00000Oo = r1
            java.util.Timer r5 = r0.O00000o0
            java.util.TimerTask r6 = r0.O00000Oo
            r7 = 1000(0x3e8, double:4.94E-321)
            r9 = 1000(0x3e8, double:4.94E-321)
            r5.schedule(r6, r7, r9)
            java.lang.String r1 = _m_j.cav.O00000oo()
            android.net.Uri r1 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r1 = r1.buildUpon()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            com.mi.global.shop.buy.model.OrderPaymentInfo r5 = r0.O00000oo
            java.lang.String r5 = r5.f4866O000000o
            r2.put(r4, r5)
            com.mi.global.shop.buy.model.OrderPaymentInfo r4 = r0.O00000oo
            java.lang.String r4 = r4.O00000o0
            r2.put(r3, r4)
            boolean r3 = _m_j.byl.O0000OoO()
            java.lang.String r4 = "UTF-8"
            if (r3 == 0) goto L_0x00ad
            _m_j.cai r3 = new _m_j.cai
            r6 = 1
            java.lang.String r7 = r1.toString()
            java.util.Map r1 = _m_j.cbh.O000000o(r2)
            java.lang.String r8 = _m_j.cbh.O000000o(r1, r4)
            _m_j.bzk$6 r9 = new _m_j.bzk$6
            r9.<init>()
            _m_j.bzk$7 r10 = new _m_j.bzk$7
            r10.<init>()
            r5 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            goto L_0x00cc
        L_0x00ad:
            _m_j.cah r3 = new _m_j.cah
            r12 = 1
            java.lang.String r13 = r1.toString()
            java.util.Map r1 = _m_j.cbh.O000000o(r2)
            java.lang.String r14 = _m_j.cbh.O000000o(r1, r4)
            _m_j.bzk$8 r15 = new _m_j.bzk$8
            r15.<init>()
            _m_j.bzk$9 r1 = new _m_j.bzk$9
            r1.<init>()
            r11 = r3
            r16 = r1
            r11.<init>(r12, r13, r14, r15, r16)
        L_0x00cc:
            java.lang.String r1 = "CODViewHelper"
            r3.setTag(r1)
            com.android.volley.RequestQueue r1 = _m_j.ced.f13683O000000o
            r1.add(r3)
            return
        L_0x00d7:
            com.mi.global.shop.widget.CommonButton r2 = r0.O0000OoO
            r7 = 2
            if (r1 != r2) goto L_0x0181
            com.mi.global.shop.buy.model.OrderPaymentInfo r1 = r0.O00000oo
            int r1 = r1.O0000o0O
            if (r1 == 0) goto L_0x015f
            java.lang.String r2 = "code"
            if (r1 == r6) goto L_0x0129
            if (r1 == r7) goto L_0x00ea
            goto L_0x0180
        L_0x00ea:
            r0.O0000oo0 = r6
            android.view.View r1 = r0.O00000o
            r5 = 2132148913(0x7f1602b1, float:1.9939817E38)
            android.view.View r1 = r1.findViewById(r5)
            com.mi.global.shop.widget.CustomEditTextView r1 = (com.mi.global.shop.widget.CustomEditTextView) r1
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = _m_j.cav.O0000OOo()
            android.net.Uri r5 = android.net.Uri.parse(r5)
            android.net.Uri$Builder r5 = r5.buildUpon()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            com.mi.global.shop.buy.model.OrderPaymentInfo r7 = r0.O00000oo
            java.lang.String r7 = r7.f4866O000000o
            r6.put(r4, r7)
            com.mi.global.shop.buy.model.OrderPaymentInfo r4 = r0.O00000oo
            java.lang.String r4 = r4.O00000o0
            r6.put(r3, r4)
            r6.put(r2, r1)
            java.lang.String r1 = r5.toString()
            r0.O000000o(r1, r6)
            return
        L_0x0129:
            r0.O0000oo0 = r5
            com.mi.global.shop.widget.CustomEditTextView r1 = r0.O0000o
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = _m_j.cav.O0000O0o()
            android.net.Uri r5 = android.net.Uri.parse(r5)
            android.net.Uri$Builder r5 = r5.buildUpon()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            com.mi.global.shop.buy.model.OrderPaymentInfo r7 = r0.O00000oo
            java.lang.String r7 = r7.f4866O000000o
            r6.put(r4, r7)
            com.mi.global.shop.buy.model.OrderPaymentInfo r4 = r0.O00000oo
            java.lang.String r4 = r4.O00000o0
            r6.put(r3, r4)
            r6.put(r2, r1)
            java.lang.String r1 = r5.toString()
            r0.O000000o(r1, r6)
            return
        L_0x015f:
            r0.O0000oo0 = r5
            java.lang.String r1 = _m_j.cav.O0000Oo0()
            android.net.Uri r1 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r1 = r1.buildUpon()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            com.mi.global.shop.buy.model.OrderPaymentInfo r3 = r0.O00000oo
            java.lang.String r3 = r3.f4866O000000o
            r2.put(r4, r3)
            java.lang.String r1 = r1.toString()
            r0.O000000o(r1, r2)
        L_0x0180:
            return
        L_0x0181:
            com.mi.global.shop.widget.CustomTextView r2 = r0.O0000o0O
            if (r1 != r2) goto L_0x0194
            com.mi.global.shop.buy.model.OrderPaymentInfo r1 = r0.O00000oo
            r1.O0000o0O = r7
            com.mi.global.shop.buy.ConfirmActivity r1 = r0.O00000oO
            _m_j.bzk$10 r2 = new _m_j.bzk$10
            r2.<init>()
            r1.runOnUiThread(r2)
            return
        L_0x0194:
            com.mi.global.shop.widget.CustomTextView r2 = r0.O0000oOO
            if (r1 != r2) goto L_0x01a7
            com.mi.global.shop.buy.model.OrderPaymentInfo r1 = r0.O00000oo
            r1.O0000o0O = r6
            com.mi.global.shop.buy.ConfirmActivity r1 = r0.O00000oO
            _m_j.bzk$11 r2 = new _m_j.bzk$11
            r2.<init>()
            r1.runOnUiThread(r2)
            return
        L_0x01a7:
            com.mi.global.shop.widget.CustomTextView r2 = r0.O0000o0o
            if (r1 != r2) goto L_0x01bc
            android.content.Intent r1 = new android.content.Intent
            com.mi.global.shop.buy.ConfirmActivity r2 = r0.O00000oO
            java.lang.Class<com.mi.global.shop.buy.cod.ChangeTelAcitivty> r3 = com.mi.global.shop.buy.cod.ChangeTelAcitivty.class
            r1.<init>(r2, r3)
            com.mi.global.shop.buy.ConfirmActivity r2 = r0.O00000oO
            r3 = 102(0x66, float:1.43E-43)
            r2.startActivityForResult(r1, r3)
            return
        L_0x01bc:
            com.mi.global.shop.widget.CustomTextView r2 = r0.O0000oO
            if (r1 != r2) goto L_0x01c3
            r17.O00000o0()
        L_0x01c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.bzk.onClick(android.view.View):void");
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.android.volley.Request] */
    /* JADX WARN: Type inference failed for: r10v1, types: [_m_j.cah] */
    /* JADX WARN: Type inference failed for: r4v3, types: [_m_j.cai] */
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
    private void O000000o(java.lang.String r17, java.util.Map<java.lang.String, java.lang.String> r18) {
        /*
            r16 = this;
            r0 = r16
            java.lang.String r1 = java.lang.String.valueOf(r17)
            java.lang.String r2 = "doCODRequest url:"
            java.lang.String r1 = r2.concat(r1)
            java.lang.String r2 = "CODViewHelper"
            _m_j.ccr.O00000Oo(r2, r1)
            com.mi.global.shop.widget.CommonButton r1 = r0.O0000OoO
            r3 = 0
            r1.setEnabled(r3)
            boolean r1 = _m_j.byl.O0000OoO()
            java.lang.String r3 = "UTF-8"
            if (r1 == 0) goto L_0x003b
            _m_j.cai r1 = new _m_j.cai
            r5 = 1
            java.util.Map r4 = _m_j.cbh.O000000o(r18)
            java.lang.String r7 = _m_j.cbh.O000000o(r4, r3)
            _m_j.bzk$12 r8 = new _m_j.bzk$12
            r8.<init>()
            _m_j.bzk$2 r9 = new _m_j.bzk$2
            r9.<init>()
            r4 = r1
            r6 = r17
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x0056
        L_0x003b:
            _m_j.cah r1 = new _m_j.cah
            r11 = 1
            java.util.Map r4 = _m_j.cbh.O000000o(r18)
            java.lang.String r13 = _m_j.cbh.O000000o(r4, r3)
            _m_j.bzk$3 r14 = new _m_j.bzk$3
            r14.<init>()
            _m_j.bzk$4 r15 = new _m_j.bzk$4
            r15.<init>()
            r10 = r1
            r12 = r17
            r10.<init>(r11, r12, r13, r14, r15)
        L_0x0056:
            r1.setTag(r2)
            com.android.volley.RequestQueue r2 = _m_j.ced.f13683O000000o
            r2.add(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.bzk.O000000o(java.lang.String, java.util.Map):void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public final void O000000o(String str) {
        Intent intent = new Intent();
        intent.putExtra("result", str);
        intent.putExtra("cod", true);
        this.O00000oO.setResult(-1, intent);
        StringBuilder sb = new StringBuilder(cav.O0000Oo());
        sb.append('/');
        sb.append(this.O00000oo.f4866O000000o);
        sb.append("?status=");
        sb.append(this.O0000oo0 ? "2" : "1");
        Intent intent2 = new Intent(this.O00000oO, WebActivity.class);
        intent2.putExtra("url", sb.toString());
        this.O00000oO.startActivity(intent2);
        this.O00000oO.finish();
    }

    public static JSONObject O000000o(Result result) {
        JSONObject jSONObject = new JSONObject();
        if (result == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("url", Wire.get(result.url, ""));
            jSONObject.put("refresh", Wire.get(result.refresh, Result.DEFAULT_REFRESH));
            JSONObject jSONObject2 = new JSONObject();
            if (result.support != null) {
                jSONObject2.put("codstatus", Wire.get(result.support.codstatus, ""));
            }
            jSONObject.put("support", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final void afterTextChanged(Editable editable) {
        if (editable != null) {
            if (editable.toString().getBytes().length == 0) {
                this.O0000OoO.setEnabled(false);
            } else {
                this.O0000OoO.setEnabled(true);
            }
        }
    }
}

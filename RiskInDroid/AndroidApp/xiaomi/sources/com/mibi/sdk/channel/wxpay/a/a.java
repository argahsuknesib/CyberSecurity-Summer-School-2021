package com.mibi.sdk.channel.wxpay.a;

import _m_j.cfh;
import _m_j.chh;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.WXUtils;
import com.mibi.sdk.channel.wxpay.b.a;
import com.mibi.sdk.channel.wxpay.b.b;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.MemoryStorage;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.component.MarketUtils;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.mvp.lifecycle.ILifeCycleListener;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xiaomi.smarthome.R;

public final class a extends Model<Void> implements ILifeCycleListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile Activity f5122O000000o;
    public O000000o O00000Oo;
    /* access modifiers changed from: private */
    public c O00000o = c.INIT;
    private String O00000o0;

    public interface O000000o {
        void O000000o(boolean z);
    }

    enum c {
        INIT,
        STARTED,
        FINISHED,
        GO_INSTALL,
        INSTALLING
    }

    public final void handleResult(int i, int i2, Bundle bundle) {
    }

    public final void onPause() {
    }

    public a(Session session) {
        super(session);
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<Void> iResultCallback) {
        super.request(bundle, iResultCallback);
        Log.d("WxpayModel", "request wxpay");
        this.O00000o0 = bundle.getString("processId");
        if (!TextUtils.isEmpty(this.O00000o0)) {
            O000000o();
            return;
        }
        throw new IllegalStateException();
    }

    private void O000000o() {
        Log.d("WxpayModel", "checkInstall");
        if (MarketUtils.isAppInstalled(getContext(), "com.tencent.mm")) {
            Log.d("WxpayModel", "wx installed");
            this.O00000o = c.INIT;
            this.O00000Oo.O000000o(false);
            O000000o(this.O00000o0);
            return;
        }
        Log.d("WxpayModel", "wx is not installed");
        this.O00000o = c.GO_INSTALL;
        this.O00000Oo.O000000o(true);
        cfh.O000000o(this.f5122O000000o, new O00000o(this, (byte) 0));
    }

    private void O000000o(String str) {
        Log.d("WxpayModel", "requestServer");
        MemoryStorage memoryStorage = getSession().getMemoryStorage();
        long j = memoryStorage.getLong(str, "rechargeValue");
        boolean z = memoryStorage.getBoolean(str, "isPartnerAccount");
        SortedParameter sortedParameter = new SortedParameter();
        sortedParameter.add("processId", str);
        sortedParameter.add("chargeFee", Long.valueOf(j * 1));
        sortedParameter.add("channel", "WXPAY");
        if (z) {
            boolean z2 = memoryStorage.getBoolean(str, "useGiftcard");
            boolean z3 = memoryStorage.getBoolean(str, "usePartnerGiftcard");
            sortedParameter.add("useGiftcard", Boolean.valueOf(z2));
            sortedParameter.add("usePartnerGiftcard", Boolean.valueOf(z3));
            com.mibi.sdk.channel.wxpay.b.a aVar = new com.mibi.sdk.channel.wxpay.b.a(getContext(), getSession(), str);
            aVar.setParams(sortedParameter);
            chh.O000000o(aVar).O000000o(new O00000Oo(this, getContext(), (byte) 0));
            return;
        }
        b bVar = new b(getContext(), getSession());
        bVar.setParams(sortedParameter);
        chh.O000000o(bVar).O000000o(new O0000O0o(this, getContext(), (byte) 0));
    }

    class O0000O0o extends RxBaseErrorHandleTaskListener<b.a> {
        /* synthetic */ O0000O0o(a aVar, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            Log.d("WxpayModel", "start wxpay");
            new Thread(new O00000o0(a.this, (b.a) obj, (byte) 0)).start();
        }

        private O0000O0o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            Log.d("WxpayModel", "request wxpay error:" + i + " ,errorDesc:" + str);
            a.this.getCallback().onFailed(i, str, th);
        }
    }

    class O00000Oo extends RxBaseErrorHandleTaskListener<a.C0040a> {
        /* synthetic */ O00000Oo(a aVar, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            a.C0040a aVar = (a.C0040a) obj;
            Log.d("WxpayModel", "start wxpay");
            a aVar2 = a.this;
            b.a aVar3 = new b.a();
            aVar3.f5130a = aVar.f5129a;
            aVar3.b = aVar.b;
            aVar3.c = aVar.c;
            aVar3.d = aVar.d;
            aVar3.e = aVar.e;
            aVar3.f = aVar.f;
            aVar3.g = aVar.g;
            new Thread(new O00000o0(aVar2, aVar3, (byte) 0)).start();
        }

        private O00000Oo(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            Log.d("WxpayModel", "request wxpay error:" + i + " ,errorDesc:" + str);
            a.this.getCallback().onFailed(i, str, th);
        }
    }

    class O00000o implements cfh.O000000o {
        private O00000o() {
        }

        /* synthetic */ O00000o(a aVar, byte b) {
            this();
        }

        public final void O000000o() {
            Log.d("WxpayModel", "onConfirm");
            c unused = a.this.O00000o = c.INSTALLING;
        }

        public final void O00000Oo() {
            Log.d("WxpayModel", "onCancel");
            c unused = a.this.O00000o = c.FINISHED;
            a.this.getCallback().onFailed(0, "user canceled", null);
        }
    }

    class O00000o0 implements Runnable {
        private b.a O00000Oo;

        /* synthetic */ O00000o0(a aVar, b.a aVar2, byte b) {
            this(aVar2);
        }

        private O00000o0(b.a aVar) {
            this.O00000Oo = aVar;
        }

        public final void run() {
            Log.d("WxpayModel", "start wx pay");
            Context applicationContext = a.this.getContext().getApplicationContext();
            PayReq payReq = new PayReq();
            payReq.appId = this.O00000Oo.f5130a;
            payReq.partnerId = this.O00000Oo.b;
            payReq.prepayId = this.O00000Oo.c;
            payReq.packageValue = this.O00000Oo.d;
            payReq.nonceStr = this.O00000Oo.e;
            payReq.timeStamp = this.O00000Oo.f;
            payReq.sign = this.O00000Oo.g;
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(applicationContext, null);
            createWXAPI.registerApp(this.O00000Oo.f5130a);
            boolean sendReq = createWXAPI.sendReq(payReq);
            if (sendReq) {
                WXUtils.putString(applicationContext, "prepayid", this.O00000Oo.c);
                WXUtils.putString(applicationContext, "appid", this.O00000Oo.f5130a);
                c unused = a.this.O00000o = c.STARTED;
            } else {
                a.this.getCallback().onFailed(0, "wxpay error", null);
                c unused2 = a.this.O00000o = c.FINISHED;
            }
            Log.d("WxpayModel", "prePayId is null ? " + TextUtils.isEmpty(this.O00000Oo.c) + " ; appId is null ? " + TextUtils.isEmpty(this.O00000Oo.f5130a));
            Log.d("WxpayModel", "WeiXin sendSuccess = ".concat(String.valueOf(sendReq)));
        }
    }

    public final void onResume() {
        Log.d("WxpayModel", "onResume");
        if (this.O00000o == c.INSTALLING) {
            O000000o();
        } else if (this.O00000o == c.STARTED) {
            Log.d("WxpayModel", "checkResult");
            String string = WXUtils.getString(getContext(), "prepayid");
            String string2 = WXUtils.getString(getContext(), string);
            if (TextUtils.isEmpty(string2)) {
                Log.d("WxpayModel", "has not received result from weiChat");
                getCallback().onFailed(9825, "open WeChat failed", null);
                return;
            }
            if (!TextUtils.isEmpty(string)) {
                WXUtils.removeString(getContext(), "prepayid");
                WXUtils.removeString(getContext(), string);
                int parseInt = Integer.parseInt(string2);
                if (parseInt == -2) {
                    getCallback().onFailed(0, "WeChat return cancel", null);
                } else if (parseInt == -1) {
                    String string3 = getContext().getResources().getString(R.string.mibi_paytool_weixin);
                    getCallback().onFailed(11, getContext().getResources().getString(R.string.mibi_paytool_error_msp, string3), null);
                } else if (parseInt == 0) {
                    if (getSession().getMemoryStorage().getLong(this.O00000o0, "payment_denomination_mibi") >= 0) {
                        getCallback().onSuccess(null);
                    } else {
                        throw new IllegalArgumentException("denominationMibi should be greater than 0 when return from weixin pay");
                    }
                }
            } else {
                Log.d("WxpayModel", "prePayId error : prePayId is null ? " + TextUtils.isEmpty(string));
                getCallback().onFailed(0, "prePayId error", null);
            }
            this.O00000o = c.FINISHED;
        }
    }

    public final void onDestroy() {
        this.f5122O000000o = null;
    }
}

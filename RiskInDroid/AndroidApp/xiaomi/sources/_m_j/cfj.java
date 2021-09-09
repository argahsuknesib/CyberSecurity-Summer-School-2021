package _m_j;

import _m_j.cfg;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.channel.wxpay.a.a;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.model.IBaseModel;

public final class cfj extends BaseMvpPresenter<cfg.O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public Activity f13716O000000o;
    private String O00000Oo;

    public cfj(Class<cfg.O000000o> cls) {
        super(cls);
    }

    public final void onInit(Bundle bundle) {
        super.onInit(bundle);
        this.O00000Oo = getArguments().getString("processId");
        if (!TextUtils.isEmpty(this.O00000Oo)) {
            Log.d("WxpayChannelPresenter", "requestWxpayChannel");
            a aVar = new a(getSession());
            aVar.f5122O000000o = this.f13716O000000o;
            addLifeCycleListener(aVar);
            Bundle bundle2 = new Bundle();
            bundle2.putString("processId", this.O00000Oo);
            aVar.O00000Oo = new O000000o(this, (byte) 0);
            aVar.request(bundle2, new O00000Oo(this, (byte) 0));
            return;
        }
        throw new IllegalStateException("processId is null");
    }

    class O00000Oo implements IBaseModel.IResultCallback<Void> {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(cfj cfj, byte b) {
            this();
        }

        public final void onFailed(int i, String str, Throwable th) {
            Log.d("WxpayChannelPresenter", "requestWxpayChannel failed:".concat(String.valueOf(str)), th);
            ((cfg.O000000o) cfj.this.getView()).a(i, str, th);
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Log.d("WxpayChannelPresenter", "requestWxpayChannel success");
            ((cfg.O000000o) cfj.this.getView()).a();
        }
    }

    class O000000o implements a.O000000o {
        private O000000o() {
        }

        /* synthetic */ O000000o(cfj cfj, byte b) {
            this();
        }

        public final void O000000o(boolean z) {
            if (z) {
                ((cfg.O000000o) cfj.this.getView()).a(false);
            } else {
                ((cfg.O000000o) cfj.this.getView()).a(true);
            }
        }
    }

    public final void onRelease() {
        super.onRelease();
        this.f13716O000000o = null;
    }
}

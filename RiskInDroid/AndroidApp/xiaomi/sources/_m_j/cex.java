package _m_j;

import _m_j.cfa;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.model.IBaseModel;

public final class cex extends BaseMvpPresenter<cfa.O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public Activity f13700O000000o;
    private String O00000Oo;

    public cex(Class<cfa.O000000o> cls) {
        super(cls);
    }

    public final void onInit(Bundle bundle) {
        super.onInit(bundle);
        this.O00000Oo = getArguments().getString("processId");
        if (!TextUtils.isEmpty(this.O00000Oo)) {
            Log.d("AlipayChannelPresenter", "requestAlipayChannel");
            cey cey = new cey(getSession());
            cey.f13702O000000o = this.f13700O000000o;
            addLifeCycleListener(cey);
            Bundle bundle2 = new Bundle();
            bundle2.putString("processId", this.O00000Oo);
            cey.request(bundle2, new O000000o(this, (byte) 0));
            return;
        }
        throw new IllegalStateException("processId is null");
    }

    class O000000o implements IBaseModel.IResultCallback<Void> {
        private O000000o() {
        }

        /* synthetic */ O000000o(cex cex, byte b) {
            this();
        }

        public final void onFailed(int i, String str, Throwable th) {
            Log.d("AlipayChannelPresenter", "requestAlipayChannel failed:".concat(String.valueOf(str)), th);
            ((cfa.O000000o) cex.this.getView()).a(i, str, th);
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Log.d("AlipayChannelPresenter", "requestAlipayChannel success");
            ((cfa.O000000o) cex.this.getView()).a();
        }
    }

    public final void onRelease() {
        super.onRelease();
        this.f13700O000000o = null;
    }
}

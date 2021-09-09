package _m_j;

import _m_j.cfd;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.model.IBaseModel;

public final class cfe extends BaseMvpPresenter<cfd.O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public Activity f13712O000000o;
    private String O00000Oo;

    public cfe(Class<cfd.O000000o> cls) {
        super(cls);
    }

    public final void onInit(Bundle bundle) {
        super.onInit(bundle);
        boolean z = bundle != null;
        Log.d("MipayChannelPresenter", "savedState == null ? ".concat(String.valueOf(z)));
        if (!z) {
            this.O00000Oo = getArguments().getString("processId");
        } else {
            this.O00000Oo = bundle.getString("processId");
        }
        Log.d("MipayChannelPresenter", "requestMipayChannel");
        cfc cfc = new cfc(getSession());
        cfc.f13708O000000o = this.f13712O000000o;
        Bundle bundle2 = new Bundle();
        bundle2.putString("processId", this.O00000Oo);
        bundle2.putBoolean("isRestored", z);
        addLifeCycleListener(cfc);
        cfc.request(bundle2, new O000000o(this, (byte) 0));
    }

    public final void onSave(Bundle bundle) {
        super.onSave(bundle);
        bundle.putString("processId", this.O00000Oo);
    }

    class O000000o implements IBaseModel.IResultCallback<Bundle> {
        private O000000o() {
        }

        /* synthetic */ O000000o(cfe cfe, byte b) {
            this();
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Log.d("MipayChannelPresenter", "requestMipayChannel success");
            ((cfd.O000000o) cfe.this.getView()).a((Bundle) obj);
        }

        public final void onFailed(int i, String str, Throwable th) {
            Log.d("MipayChannelPresenter", "requestMipayChannel failed:".concat(String.valueOf(i)), th);
            ((cfd.O000000o) cfe.this.getView()).a(i, str, th);
        }
    }

    public final void handleResult(int i, int i2, Bundle bundle) {
        Log.d("MipayChannelPresenter", "handleResult");
        super.handleResult(i, i2, bundle);
    }

    public final void onRelease() {
        super.onRelease();
        this.f13712O000000o = null;
    }
}

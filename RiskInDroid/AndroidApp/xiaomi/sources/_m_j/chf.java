package _m_j;

import _m_j.che;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.component.OrderBean;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.auth.CheckAuthModel;
import com.mibi.sdk.model.domain.UpdateDomainModel;
import com.mibi.sdk.model.progress.StartProcessModel;
import com.mibi.sdk.qrpay.b.a;
import com.mibi.sdk.qrpay.b.b;
import com.mibi.sdk.qrpay.b.e;
import com.mibi.sdk.qrpay.b.g;
import com.xiaomi.smarthome.R;

public final class chf extends BaseMvpPresenter<che.O00000Oo> implements che.O000000o {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13813O000000o;
    /* access modifiers changed from: private */
    public String O00000Oo;

    public chf() {
        super(che.O00000Oo.class);
    }

    public final void onInit(Bundle bundle) {
        super.onInit(bundle);
        StringBuilder sb = new StringBuilder("saveState == null ? ");
        sb.append(bundle == null);
        Log.d("QrPayPresenter", sb.toString());
        if (bundle == null) {
            OrderBean orderBean = (OrderBean) getArguments().getParcelable("orderBean");
            if (orderBean != null) {
                SortedParameter sortedParameter = new SortedParameter();
                sortedParameter.add("payment_pay_order", orderBean.mOrder);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("sortedParams", sortedParameter);
                new UpdateDomainModel(getSession()).request(bundle2, new O00000o0(this, (byte) 0));
                return;
            }
            throw new IllegalStateException("orderBean is null");
        }
        this.f13813O000000o = bundle.getString("processId");
    }

    public final String O000000o() {
        return this.f13813O000000o;
    }

    class O00000o0 implements IBaseModel.IResultCallback<Void> {
        private O00000o0() {
        }

        /* synthetic */ O00000o0(chf chf, byte b) {
            this();
        }

        public final void onFailed(int i, String str, Throwable th) {
            Log.d("QrPayPresenter", "Domain failed:" + i + ",errorDesc:" + str);
            ((che.O00000Oo) chf.this.getView()).a(i, str, th);
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Log.d("QrPayPresenter", "Domain onSuccess");
            new StartProcessModel(chf.this.getSession()).request(null, new O00000o(chf.this, (byte) 0));
        }
    }

    class O00000o implements IBaseModel.IResultCallback<String> {
        private O00000o() {
        }

        /* synthetic */ O00000o(chf chf, byte b) {
            this();
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            String str = (String) obj;
            Log.d("QrPayPresenter", "StartProcess onSuccess");
            chf.this.getSession().getMemoryStorage().put(str, "orderBean", chf.this.getArguments().getParcelable("orderBean"));
            String unused = chf.this.f13813O000000o = str;
            chf.O00000oO(chf.this);
        }

        public final void onFailed(int i, String str, Throwable th) {
            MibiLog.d("QrPayPresenter", "StartProcess failed:" + i + ",errorDesc:" + str);
            ((che.O00000Oo) chf.this.getView()).a(i, str, th);
        }
    }

    class O00000Oo implements IBaseModel.IResultCallback<Bundle> {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(chf chf, byte b) {
            this();
        }

        public final void onFailed(int i, String str, Throwable th) {
            Log.d("QrPayPresenter", "CheckOrder failed:" + i + ",errorDesc:" + str);
            ((che.O00000Oo) chf.this.getView()).a(i, str, th);
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Log.d("QrPayPresenter", "CheckOrder onSuccess");
            OrderBean orderBean = (OrderBean) chf.this.getArguments().getParcelable("orderBean");
            if (orderBean != null) {
                String str = orderBean.mChannel;
                if (orderBean.mIsNoAccount) {
                    chf.this.O000000o(str);
                    return;
                }
                String unused = chf.this.O00000Oo = str;
                chf.O0000OOo(chf.this);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("processId", this.f13813O000000o);
        if ("ALI_QR".equals(str)) {
            new cgz(getSession()).request(bundle, new IBaseModel.IResultCallback<a.C0043a>() {
                /* class _m_j.chf.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    MibiLog.d("QrPayPresenter", "get alipay qr_code success");
                    Bundle bundle = new Bundle();
                    bundle.putString("qrCode", ((a.C0043a) obj).f5169a);
                    ((che.O00000Oo) chf.this.getView()).a(bundle);
                }

                public final void onFailed(int i, String str, Throwable th) {
                    MibiLog.d("QrPayPresenter", "get alipay qr_code failed errorCode : " + i + " ; errorDesc : " + str, th);
                    ((che.O00000Oo) chf.this.getView()).a(i, str, th);
                }
            });
        } else if ("WX_QR".equals(str)) {
            new chd(getSession()).request(bundle, new IBaseModel.IResultCallback<g.a>() {
                /* class _m_j.chf.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    MibiLog.d("QrPayPresenter", "get wxpay qr_code success");
                    Bundle bundle = new Bundle();
                    bundle.putString("qrCode", ((g.a) obj).f5175a);
                    ((che.O00000Oo) chf.this.getView()).a(bundle);
                }

                public final void onFailed(int i, String str, Throwable th) {
                    MibiLog.d("QrPayPresenter", "get wxpay qr_code failed errorCode : " + i + " ; errorDesc : " + str, th);
                    ((che.O00000Oo) chf.this.getView()).a(i, str, th);
                }
            });
        } else if ("MI_QR".equals(str)) {
            new cha(getSession()).request(bundle, new IBaseModel.IResultCallback<b.a>() {
                /* class _m_j.chf.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    MibiLog.d("QrPayPresenter", "get mibi pay qr_code success");
                    Bundle bundle = new Bundle();
                    bundle.putString("qrCode", ((b.a) obj).f5170a);
                    ((che.O00000Oo) chf.this.getView()).a(bundle);
                }

                public final void onFailed(int i, String str, Throwable th) {
                    MibiLog.d("QrPayPresenter", "get mibi pay qr_code failed errorCode : " + i + " ; errorDesc : " + str, th);
                    ((che.O00000Oo) chf.this.getView()).a(i, str, th);
                }
            });
        } else if ("UNITED_QR".equals(str)) {
            new chc(getSession()).request(bundle, new IBaseModel.IResultCallback<e.a>() {
                /* class _m_j.chf.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    e.a aVar = (e.a) obj;
                    MibiLog.d("QrPayPresenter", "get united pay qr_code success");
                    Bundle bundle = new Bundle();
                    bundle.putString("qrCode", aVar.f5174a);
                    bundle.putSerializable("qrChannels", aVar.b);
                    ((che.O00000Oo) chf.this.getView()).a(bundle);
                }

                public final void onFailed(int i, String str, Throwable th) {
                    MibiLog.d("QrPayPresenter", "get united pay qr_code failed errorCode : " + i + " ; errorDesc : " + str, th);
                    ((che.O00000Oo) chf.this.getView()).a(i, str, th);
                }
            });
        } else {
            ((che.O00000Oo) getView()).a(9831, str + " not supported", new IllegalArgumentException("qr pay channel not supported"));
        }
    }

    class O000000o implements CheckAuthModel.ICheckAuthCallback {
        private O000000o() {
        }

        /* synthetic */ O000000o(chf chf, byte b) {
            this();
        }

        public final void onSuccess() {
            Log.d("QrPayPresenter", "CheckAuthCallback onSuccess");
            chf chf = chf.this;
            chf.O000000o(chf.O00000Oo);
        }

        public final void onAccountFrozen() {
            Log.d("QrPayPresenter", "onAccountFrozen");
            ((che.O00000Oo) chf.this.getView()).a(0, "account frozen", null);
        }

        public final void onPasswordCheck() {
            Log.d("QrPayPresenter", "onPasswordCheck");
            ((che.O00000Oo) chf.this.getView()).onPasswordCheck();
        }

        public final void onSMSCodeCheck(Bundle bundle) {
            Log.d("QrPayPresenter", "onSMSCodeCheck");
            ((che.O00000Oo) chf.this.getView()).onSMSCodeCheck(bundle);
        }

        public final void onBindPhoneCheck(Bundle bundle) {
            Log.d("QrPayPresenter", "onBindPhoneCheck");
            ((che.O00000Oo) chf.this.getView()).onBindPhoneCheck(bundle);
        }

        public final void onProcessExpired() {
            Log.d("QrPayPresenter", "onProcessExpired");
            ((che.O00000Oo) chf.this.getView()).a(9800, chf.this.getContext().getResources().getString(R.string.mibi_msg_process_expired), null);
        }

        public final void onAuthCheckError(int i, String str, Throwable th) {
            Log.d("QrPayPresenter", "onAuthCheckError:".concat(String.valueOf(i)));
            ((che.O00000Oo) chf.this.getView()).a(i, str, th);
        }
    }

    public final void handleResult(int i, int i2, Bundle bundle) {
        super.handleResult(i, i2, bundle);
        Log.d("QrPayPresenter", "requestCode : " + i + " ; resultCode : " + i2);
        if (i != 201 && i != 202) {
            return;
        }
        if (i2 == -1) {
            Log.d("QrPayPresenter", "start pay from checkauth");
            O000000o(this.O00000Oo);
        } else if (i2 == 9) {
            Log.d("QrPayPresenter", "account frozen");
            ((che.O00000Oo) getView()).onAccountFrozen();
        } else if (i2 != 1104) {
            StringBuilder sb = new StringBuilder("check auth error data == null ? ");
            sb.append(bundle == null);
            Log.d("QrPayPresenter", sb.toString());
            ((che.O00000Oo) getView()).a(i2, bundle);
        } else {
            int i3 = bundle.getInt("code");
            if (i3 == 7001) {
                Log.d("QrPayPresenter", "need check sms from checkauth");
                ((che.O00000Oo) getView()).onSMSCodeCheck(bundle);
            } else if (i3 == 7002) {
                Log.e("QrPayPresenter", "need bind phone from checkauth");
                ((che.O00000Oo) getView()).onBindPhoneCheck(bundle);
            } else if (i3 == 1985) {
                Log.e("QrPayPresenter", "need check password from checkauth");
                ((che.O00000Oo) getView()).onPasswordCheck();
            } else {
                Log.e("QrPayPresenter", "check auth risk error,this should not be happened:".concat(String.valueOf(i3)));
                ((che.O00000Oo) getView()).a(i2, bundle);
            }
        }
    }

    public final void onSave(Bundle bundle) {
        super.onSave(bundle);
        bundle.putString("processId", this.f13813O000000o);
    }

    static /* synthetic */ void O00000oO(chf chf) {
        OrderBean orderBean = (OrderBean) chf.getArguments().getParcelable("orderBean");
        if (orderBean != null) {
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", chf.f13813O000000o);
            sortedParameter.add("payChannel", orderBean.mChannel);
            Bundle bundle = new Bundle();
            sortedParameter.add("order", orderBean.mOrder);
            bundle.putSerializable("sortedParams", sortedParameter);
            O00000Oo o00000Oo = new O00000Oo(chf, (byte) 0);
            if (orderBean.mIsNoAccount) {
                new chb(chf.getSession()).request(bundle, o00000Oo);
            } else {
                new cgy(chf.getSession()).request(bundle, o00000Oo);
            }
        } else {
            throw new IllegalStateException("orderBean is null");
        }
    }

    static /* synthetic */ void O0000OOo(chf chf) {
        if (!((OrderBean) chf.getSession().getMemoryStorage().get(chf.f13813O000000o, "orderBean")).mIsNoAccount) {
            CheckAuthModel checkAuthModel = new CheckAuthModel(chf.getSession());
            Bundle bundle = new Bundle();
            bundle.putString("processId", chf.f13813O000000o);
            checkAuthModel.checkAuth(bundle, new O000000o(chf, (byte) 0));
            return;
        }
        throw new IllegalStateException("no account should not startCheckAuth");
    }
}

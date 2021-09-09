package _m_j;

import _m_j.cgn;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.component.OrderBean;
import com.mibi.sdk.component.recharge.Recharge;
import com.mibi.sdk.component.recharge.RechargeManager;
import com.mibi.sdk.component.recharge.RechargeType;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.auth.CheckAuthModel;
import com.mibi.sdk.model.domain.UpdateDomainModel;
import com.mibi.sdk.model.progress.StartProcessModel;
import com.mibi.sdk.pay.model.DoPayModel;
import com.mibi.sdk.pay.task.RxAccountGetRechargeTypeTask;
import com.mibi.sdk.pay.task.RxStartAccountPaymentTask;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;

public final class cgo extends BaseMvpPresenter<cgn.O00000Oo> implements cgn.O000000o {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13777O000000o;
    /* access modifiers changed from: private */
    public Intent O00000Oo;
    /* access modifiers changed from: private */
    public boolean O00000o0;

    public cgo() {
        super(cgn.O00000Oo.class);
    }

    public final void onInit(Bundle bundle) {
        super.onInit(bundle);
        StringBuilder sb = new StringBuilder("saveState == null ? ");
        sb.append(bundle == null);
        MibiLog.d("PreparePresenter", sb.toString());
        if (bundle == null) {
            OrderBean orderBean = (OrderBean) getArguments().getParcelable("orderBean");
            if (orderBean != null) {
                this.O00000o0 = orderBean.mUseUi;
                SortedParameter sortedParameter = new SortedParameter();
                sortedParameter.add("payment_pay_order", orderBean.mOrder);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("sortedParams", sortedParameter);
                new UpdateDomainModel(getSession()).request(bundle2, new O00000o(this, (byte) 0));
                return;
            }
            throw new IllegalStateException("orderBean is null");
        }
        this.f13777O000000o = bundle.getString("processId");
        this.O00000o0 = bundle.getBoolean("mibi_use_ui");
    }

    public final String O000000o() {
        return this.f13777O000000o;
    }

    class O00000o implements IBaseModel.IResultCallback<Void> {
        private O00000o() {
        }

        /* synthetic */ O00000o(cgo cgo, byte b) {
            this();
        }

        public final void onFailed(int i, String str, Throwable th) {
            MibiLog.d("PreparePresenter", "Domain failed:" + i + ",errorDesc:" + str, th);
            ((cgn.O00000Oo) cgo.this.getView()).a(i, str, th);
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            MibiLog.d("PreparePresenter", "Domain onSuccess");
            new StartProcessModel(cgo.this.getSession()).request(null, new O0000OOo(cgo.this, (byte) 0));
        }
    }

    class O0000OOo implements IBaseModel.IResultCallback<String> {
        private O0000OOo() {
        }

        /* synthetic */ O0000OOo(cgo cgo, byte b) {
            this();
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            String str = (String) obj;
            MibiLog.d("PreparePresenter", "StartProcess onSuccess");
            cgo.this.getSession().getMemoryStorage().put(str, "orderBean", cgo.this.getArguments().getParcelable("orderBean"));
            String unused = cgo.this.f13777O000000o = str;
            cgo.O00000oO(cgo.this);
        }

        public final void onFailed(int i, String str, Throwable th) {
            MibiLog.d("PreparePresenter", "StartProcess failed:" + i + ",errorDesc:" + str);
            if (i == 1993) {
                ((cgn.O00000Oo) cgo.this.getView()).onAccountFrozen();
            } else {
                ((cgn.O00000Oo) cgo.this.getView()).a(i, str, th);
            }
        }
    }

    class O00000Oo implements IBaseModel.IResultCallback<Bundle> {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(cgo cgo, byte b) {
            this();
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Bundle bundle = (Bundle) obj;
            MibiLog.d("PreparePresenter", "CheckOrder onSuccess");
            if (bundle == null) {
                cgo.O0000OOo(cgo.this);
                return;
            }
            OrderBean orderBean = (OrderBean) cgo.this.getArguments().getParcelable("orderBean");
            if (orderBean != null) {
                ArrayList arrayList = (ArrayList) bundle.getSerializable("recharge_types");
                if (arrayList == null) {
                    throw new IllegalStateException("rechargesFromServer should not be null");
                } else if (!cgo.this.O00000o0) {
                    Recharge O000000o2 = cgo.O000000o(orderBean.mChannel, arrayList);
                    if (O000000o2 == null) {
                        MibiLog.e("PreparePresenter", "recharge is null");
                        ((cgn.O00000Oo) cgo.this.getView()).a(9836, "no available channel", null);
                        return;
                    }
                    Intent entryIntent = O000000o2.getEntryIntent(true);
                    entryIntent.putExtra("processId", cgo.this.f13777O000000o);
                    if (orderBean.mIsNoAccount) {
                        ((cgn.O00000Oo) cgo.this.getView()).a(entryIntent);
                        return;
                    }
                    Intent unused = cgo.this.O00000Oo = entryIntent;
                    cgo.O0000OOo(cgo.this);
                } else if (orderBean.mIsNoAccount) {
                    ((cgn.O00000Oo) cgo.this.getView()).a(arrayList);
                } else {
                    MibiLog.d("PreparePresenter", "use account, use ui");
                    ((cgn.O00000Oo) cgo.this.getView()).a((RxStartAccountPaymentTask.Result) cgo.this.getSession().getMemoryStorage().getSerializable(cgo.this.f13777O000000o, "pay_type_result"), (RxAccountGetRechargeTypeTask.Result) bundle.getSerializable("recharge_types_result"));
                }
            } else {
                throw new IllegalStateException();
            }
        }

        public final void onFailed(int i, String str, Throwable th) {
            MibiLog.d("PreparePresenter", "CheckOrder failed:" + i + ",errorDesc:" + str);
            ((cgn.O00000Oo) cgo.this.getView()).a(i, str, th);
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo() {
        if (this.O00000Oo != null) {
            MibiLog.d("PreparePresenter", "go third pay:" + this.O00000Oo.getAction());
            ((cgn.O00000Oo) getView()).a(this.O00000Oo);
            return;
        }
        MibiLog.d("PreparePresenter", "go direct pay");
        OrderBean orderBean = (OrderBean) getSession().getMemoryStorage().get(this.f13777O000000o, "orderBean");
        Bundle bundle = new Bundle();
        bundle.putString("processId", this.f13777O000000o);
        bundle.putBoolean("useBalance", orderBean.mUseBalance);
        bundle.putBoolean("useGiftcard", orderBean.mUseGiftcard);
        bundle.putBoolean("usePartnerGiftcard", orderBean.mUseParterGiftcard);
        bundle.putLong("discountGiftcardId", 0);
        new DoPayModel(getSession()).request(bundle, new O00000o0(this, (byte) 0));
    }

    class O00000o0 implements IBaseModel.IResultCallback<Bundle> {
        private O00000o0() {
        }

        /* synthetic */ O00000o0(cgo cgo, byte b) {
            this();
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            MibiLog.d("PreparePresenter", "do direct pay success");
            ((cgn.O00000Oo) cgo.this.getView()).a((Bundle) obj);
        }

        public final void onFailed(int i, String str, Throwable th) {
            MibiLog.d("PreparePresenter", "do direct failed:" + i + ",desc:" + str, th);
            ((cgn.O00000Oo) cgo.this.getView()).a(i, str, th);
        }
    }

    class O000000o implements CheckAuthModel.ICheckAuthCallback {
        private O000000o() {
        }

        /* synthetic */ O000000o(cgo cgo, byte b) {
            this();
        }

        public final void onSuccess() {
            MibiLog.d("PreparePresenter", "CheckAuthCallback onSuccess");
            cgo.this.O00000Oo();
        }

        public final void onAccountFrozen() {
            MibiLog.d("PreparePresenter", "onAccountFrozen");
            ((cgn.O00000Oo) cgo.this.getView()).a(9801, "account frozen", null);
        }

        public final void onPasswordCheck() {
            MibiLog.d("PreparePresenter", "onPasswordCheck");
            ((cgn.O00000Oo) cgo.this.getView()).onPasswordCheck();
        }

        public final void onSMSCodeCheck(Bundle bundle) {
            MibiLog.d("PreparePresenter", "onSMSCodeCheck");
            ((cgn.O00000Oo) cgo.this.getView()).onSMSCodeCheck(bundle);
        }

        public final void onBindPhoneCheck(Bundle bundle) {
            MibiLog.d("PreparePresenter", "onBindPhoneCheck");
            ((cgn.O00000Oo) cgo.this.getView()).onBindPhoneCheck(bundle);
        }

        public final void onProcessExpired() {
            MibiLog.d("PreparePresenter", "onProcessExpired");
            ((cgn.O00000Oo) cgo.this.getView()).a(9800, cgo.this.getContext().getResources().getString(R.string.mibi_msg_process_expired), null);
        }

        public final void onAuthCheckError(int i, String str, Throwable th) {
            MibiLog.d("PreparePresenter", "onAuthCheckError:".concat(String.valueOf(i)));
            ((cgn.O00000Oo) cgo.this.getView()).a(i, str, th);
        }
    }

    private void O00000o0() {
        MibiLog.d("PreparePresenter", "start query");
        cgm cgm = new cgm(getSession());
        Bundle bundle = new Bundle();
        bundle.putString("processId", this.f13777O000000o);
        cgm.request(bundle, new O0000O0o(this, (byte) 0));
    }

    class O0000O0o implements IBaseModel.IResultCallback<Bundle> {
        private O0000O0o() {
        }

        /* synthetic */ O0000O0o(cgo cgo, byte b) {
            this();
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            MibiLog.d("PreparePresenter", "query success");
            ((cgn.O00000Oo) cgo.this.getView()).a((Bundle) obj);
        }

        public final void onFailed(int i, String str, Throwable th) {
            MibiLog.d("PreparePresenter", "query error:" + i + ",errorDesc:" + str);
            ((cgn.O00000Oo) cgo.this.getView()).a(i, str, th);
        }
    }

    public final void handleResult(int i, int i2, Bundle bundle) {
        super.handleResult(i, i2, bundle);
        MibiLog.d("PreparePresenter", "requestCode : " + i + " ; resultCode : " + i2);
        if (i != 100) {
            boolean z = true;
            if (i == 201 || i == 202) {
                if (i2 == -1) {
                    MibiLog.d("PreparePresenter", "start pay from checkauth");
                    O00000Oo();
                } else if (i2 == 9) {
                    MibiLog.d("PreparePresenter", "account frozen");
                    ((cgn.O00000Oo) getView()).onAccountFrozen();
                } else if (i2 != 1104) {
                    StringBuilder sb = new StringBuilder("check auth error data == null ? ");
                    if (bundle != null) {
                        z = false;
                    }
                    sb.append(z);
                    MibiLog.d("PreparePresenter", sb.toString());
                    ((cgn.O00000Oo) getView()).a(i2, bundle);
                } else {
                    int i3 = bundle.getInt("code");
                    if (i3 == 7001) {
                        MibiLog.d("PreparePresenter", "need check sms from checkauth");
                        ((cgn.O00000Oo) getView()).onSMSCodeCheck(bundle);
                    } else if (i3 == 7002) {
                        MibiLog.e("PreparePresenter", "need bind phone from checkauth");
                        ((cgn.O00000Oo) getView()).onBindPhoneCheck(bundle);
                    } else if (i3 == 1985) {
                        MibiLog.e("PreparePresenter", "need check password from checkauth");
                        ((cgn.O00000Oo) getView()).onPasswordCheck();
                    } else {
                        MibiLog.e("PreparePresenter", "check auth risk error,this should not be happened:".concat(String.valueOf(i3)));
                        ((cgn.O00000Oo) getView()).a(i2, bundle);
                    }
                }
            } else if (i == 203) {
                if (i2 == -1) {
                    MibiLog.d("PreparePresenter", "account ui pay success");
                    if (bundle.getBoolean("isDirectPay")) {
                        ((cgn.O00000Oo) getView()).a(bundle.getBundle("result"));
                        return;
                    }
                    ((cgn.O00000Oo) getView()).a();
                    O00000o0();
                    return;
                }
                MibiLog.d("PreparePresenter", "account ui failed resultCode : ".concat(String.valueOf(i2)));
                ((cgn.O00000Oo) getView()).a(i2, bundle);
            } else if (i != 204) {
            } else {
                if (i2 == -1) {
                    Recharge recharge = RechargeManager.get().getRecharge(bundle.getString("recharge_pay_type_chosen"));
                    if (recharge == null) {
                        MibiLog.e("PreparePresenter", "recharge is null");
                        ((cgn.O00000Oo) getView()).a(9836, "no available channel", null);
                        return;
                    }
                    Intent entryIntent = recharge.getEntryIntent(true);
                    entryIntent.putExtra("processId", this.f13777O000000o);
                    ((cgn.O00000Oo) getView()).a(entryIntent);
                    return;
                }
                ((cgn.O00000Oo) getView()).a(i2, bundle);
                MibiLog.d("PreparePresenter", "select channel, nothing");
            }
        } else if (i2 == -1) {
            ((cgn.O00000Oo) getView()).a();
            O00000o0();
        } else {
            MibiLog.d("PreparePresenter", "pay error");
            ((cgn.O00000Oo) getView()).a(i2, bundle);
        }
    }

    public final void onSave(Bundle bundle) {
        super.onSave(bundle);
        bundle.putString("processId", this.f13777O000000o);
        bundle.putBoolean("mibi_use_ui", this.O00000o0);
    }

    static /* synthetic */ void O00000oO(cgo cgo) {
        OrderBean orderBean = (OrderBean) cgo.getArguments().getParcelable("orderBean");
        if (orderBean != null) {
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", cgo.f13777O000000o);
            sortedParameter.add("payChannel", orderBean.mChannel);
            sortedParameter.add("useBalance", Boolean.valueOf(orderBean.mUseBalance));
            sortedParameter.add("useGiftcard", Boolean.valueOf(orderBean.mUseGiftcard));
            sortedParameter.add("usePartnerGiftcard", Boolean.valueOf(orderBean.mUseParterGiftcard));
            Bundle bundle = new Bundle();
            sortedParameter.add("channels", RechargeManager.get().getChannels(cgo.getContext()));
            sortedParameter.add("order", orderBean.mOrder);
            bundle.putSerializable("sortedParams", sortedParameter);
            O00000Oo o00000Oo = new O00000Oo(cgo, (byte) 0);
            if (orderBean.mIsNoAccount) {
                new cgl(cgo.getSession()).request(bundle, o00000Oo);
                return;
            }
            sortedParameter.add("useBalance", Boolean.valueOf(orderBean.mUseBalance));
            sortedParameter.add("useGiftcard", Boolean.valueOf(orderBean.mUseGiftcard));
            sortedParameter.add("usePartnerGiftcard", Boolean.valueOf(orderBean.mUseParterGiftcard));
            new cgk(cgo.getSession(), cgo.O00000o0).request(bundle, o00000Oo);
            return;
        }
        throw new IllegalStateException("orderBean is null");
    }

    static /* synthetic */ void O0000OOo(cgo cgo) {
        if (!((OrderBean) cgo.getSession().getMemoryStorage().get(cgo.f13777O000000o, "orderBean")).mIsNoAccount) {
            CheckAuthModel checkAuthModel = new CheckAuthModel(cgo.getSession());
            Bundle bundle = new Bundle();
            bundle.putString("processId", cgo.f13777O000000o);
            checkAuthModel.checkAuth(bundle, new O000000o(cgo, (byte) 0));
            return;
        }
        throw new IllegalStateException("no account should not startCheckAuth");
    }

    static /* synthetic */ Recharge O000000o(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, ((RechargeType) it.next()).mType)) {
                MibiLog.d("PreparePresenter", "there's recharge in the server list");
                return RechargeManager.get().getRecharge(str);
            }
        }
        MibiLog.d("PreparePresenter", "there's no recharge in the server list");
        return null;
    }
}

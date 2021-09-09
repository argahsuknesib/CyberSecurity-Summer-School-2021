package _m_j;

import _m_j.cgs;
import _m_j.cgt;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.component.OrderBean;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.domain.UpdateDomainModel;
import com.mibi.sdk.model.progress.StartProcessModel;
import com.mibi.sdk.qrSignDeduct.b.a;

public final class cgu extends BaseMvpPresenter<cgt.O000000o> {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13791O000000o;
    /* access modifiers changed from: private */
    public String O00000Oo;

    public cgu() {
        super(cgt.O000000o.class);
    }

    public final void onInit(Bundle bundle) {
        super.onInit(bundle);
        StringBuilder sb = new StringBuilder("savedState == null ? ");
        sb.append(bundle == null);
        MibiLog.d("QrSignDeductPre", sb.toString());
        if (bundle == null) {
            OrderBean orderBean = (OrderBean) getArguments().getParcelable("orderBean");
            if (orderBean != null) {
                this.O00000Oo = orderBean.mChannel;
                SortedParameter sortedParameter = new SortedParameter();
                sortedParameter.add("payment_pay_order", orderBean.mOrder);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("sortedParams", sortedParameter);
                new UpdateDomainModel(getSession()).request(bundle2, new O00000Oo(this, (byte) 0));
                return;
            }
            throw new IllegalStateException("orderBean is null");
        }
        this.f13791O000000o = bundle.getString("processId");
        this.O00000Oo = bundle.getString("deductChannel");
    }

    class O00000Oo implements IBaseModel.IResultCallback<Void> {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(cgu cgu, byte b) {
            this();
        }

        public final void onFailed(int i, String str, Throwable th) {
            Log.d("QrSignDeductPre", "Domain failed:" + i + ",errorDesc:" + str);
            ((cgt.O000000o) cgu.this.getView()).a(i, str, th);
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Log.d("QrSignDeductPre", "Domain onSuccess");
            new StartProcessModel(cgu.this.getSession()).request(null, new O00000o0(cgu.this, (byte) 0));
        }
    }

    class O00000o0 implements IBaseModel.IResultCallback<String> {
        private O00000o0() {
        }

        /* synthetic */ O00000o0(cgu cgu, byte b) {
            this();
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            String str = (String) obj;
            Log.d("QrSignDeductPre", "StartProcess onSuccess");
            cgu.this.getSession().getMemoryStorage().put(str, "orderBean", cgu.this.getArguments().getParcelable("orderBean"));
            String unused = cgu.this.f13791O000000o = str;
            if ("UNITED_QR".equals(cgu.this.O00000Oo)) {
                cgu.O00000oo(cgu.this);
                return;
            }
            String str2 = "qr sign-deduct not suuported for " + cgu.this.O00000Oo;
            MibiLog.d("QrSignDeductPre", str2);
            ((cgt.O000000o) cgu.this.getView()).a(9831, str2, new IllegalArgumentException(str2));
        }

        public final void onFailed(int i, String str, Throwable th) {
            MibiLog.d("QrSignDeductPre", "StartProcess failed:" + i + ",errorDesc:" + str);
            ((cgt.O000000o) cgu.this.getView()).a(i, str, th);
        }
    }

    class O000000o implements cgs.O00000Oo {
        private O000000o() {
        }

        /* synthetic */ O000000o(cgu cgu, byte b) {
            this();
        }

        public final void O000000o(int i, String str, Throwable th) {
            MibiLog.d("QrSignDeductPre", "CheckOrder failed:" + i + ",errorDesc:" + str);
            ((cgt.O000000o) cgu.this.getView()).a(i, str, th);
        }

        public final void O000000o(a.C0042a aVar) {
            MibiLog.d("QrSignDeductPre", "CheckOrder onSuccess");
            Bundle bundle = new Bundle();
            bundle.putString("qrCode", aVar.f5165a);
            bundle.putSerializable("qrChannels", aVar.b);
            ((cgt.O000000o) cgu.this.getView()).a(bundle);
        }
    }

    public final void onSave(Bundle bundle) {
        super.onSave(bundle);
        bundle.putString("processId", this.f13791O000000o);
        bundle.putString("deductChannel", this.O00000Oo);
    }

    static /* synthetic */ void O00000oo(cgu cgu) {
        OrderBean orderBean = (OrderBean) cgu.getArguments().getParcelable("orderBean");
        if (orderBean != null) {
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", cgu.f13791O000000o);
            sortedParameter.add("payChannel", orderBean.mChannel);
            O000000o o000000o = new O000000o(cgu, (byte) 0);
            cgs cgs = new cgs(cgu.getSession());
            String str = cgu.f13791O000000o;
            String str2 = orderBean.mOrder;
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException(new StringBuilder("CheckUnitedSignDeductOrderModel  processId can't be null").toString());
            } else if (!TextUtils.isEmpty(str2)) {
                cgs.O00000Oo = o000000o;
                cgs.O000000o o000000o2 = new cgs.O000000o(cgs, cgs.getContext(), (byte) 0);
                SortedParameter sortedParameter2 = new SortedParameter();
                sortedParameter2.add("deductSignOrder", str2);
                sortedParameter2.add("processId", str);
                cgs.f13789O000000o.setParams(sortedParameter2);
                chh.O000000o(cgs.f13789O000000o).O000000o(o000000o2);
            } else {
                throw new IllegalArgumentException(new StringBuilder("CheckUnitedSignDeductOrderModel  order can't be null").toString());
            }
        } else {
            throw new IllegalStateException("orderBean is null");
        }
    }
}

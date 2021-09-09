package _m_j;

import _m_j.cgv;
import _m_j.cgw;
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
import com.mibi.sdk.qrdeduct.b.b;

public final class cgx extends BaseMvpPresenter<cgw.O000000o> {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13797O000000o;
    /* access modifiers changed from: private */
    public String O00000Oo;

    public cgx() {
        super(cgw.O000000o.class);
    }

    public final void onInit(Bundle bundle) {
        super.onInit(bundle);
        StringBuilder sb = new StringBuilder("savedState == null ? ");
        sb.append(bundle == null);
        MibiLog.d("QrDeductPresenter", sb.toString());
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
        this.f13797O000000o = bundle.getString("processId");
        this.O00000Oo = bundle.getString("deductChannel");
    }

    class O00000Oo implements IBaseModel.IResultCallback<Void> {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(cgx cgx, byte b) {
            this();
        }

        public final void onFailed(int i, String str, Throwable th) {
            Log.d("QrDeductPresenter", "Domain failed:" + i + ",errorDesc:" + str);
            ((cgw.O000000o) cgx.this.getView()).a(i, str, th);
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Log.d("QrDeductPresenter", "Domain onSuccess");
            new StartProcessModel(cgx.this.getSession()).request(null, new O00000o0(cgx.this, (byte) 0));
        }
    }

    class O00000o0 implements IBaseModel.IResultCallback<String> {
        private O00000o0() {
        }

        /* synthetic */ O00000o0(cgx cgx, byte b) {
            this();
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            String str = (String) obj;
            Log.d("QrDeductPresenter", "StartProcess onSuccess");
            cgx.this.getSession().getMemoryStorage().put(str, "orderBean", cgx.this.getArguments().getParcelable("orderBean"));
            String unused = cgx.this.f13797O000000o = str;
            if ("UNITED_QR".equals(cgx.this.O00000Oo)) {
                cgx.O00000oo(cgx.this);
                return;
            }
            String str2 = "qr deduct not suuported for " + cgx.this.O00000Oo;
            MibiLog.d("QrDeductPresenter", str2);
            ((cgw.O000000o) cgx.this.getView()).a(9831, str2, new IllegalArgumentException(str2));
        }

        public final void onFailed(int i, String str, Throwable th) {
            MibiLog.d("QrDeductPresenter", "StartProcess failed:" + i + ",errorDesc:" + str);
            ((cgw.O000000o) cgx.this.getView()).a(i, str, th);
        }
    }

    class O000000o implements cgv.O00000Oo {
        private O000000o() {
        }

        /* synthetic */ O000000o(cgx cgx, byte b) {
            this();
        }

        public final void O000000o(int i, String str, Throwable th) {
            Log.d("QrDeductPresenter", "CheckOrder failed:" + i + ",errorDesc:" + str);
            ((cgw.O000000o) cgx.this.getView()).a(i, str, th);
        }

        public final void O000000o(b.a aVar) {
            Log.d("QrDeductPresenter", "CheckOrder onSuccess");
            Bundle bundle = new Bundle();
            bundle.putString("qrCode", aVar.f5167a);
            bundle.putSerializable("qrChannels", aVar.b);
            ((cgw.O000000o) cgx.this.getView()).a(bundle);
        }
    }

    public final void onSave(Bundle bundle) {
        super.onSave(bundle);
        bundle.putString("processId", this.f13797O000000o);
        bundle.putString("deductChannel", this.O00000Oo);
    }

    static /* synthetic */ void O00000oo(cgx cgx) {
        OrderBean orderBean = (OrderBean) cgx.getArguments().getParcelable("orderBean");
        if (orderBean != null) {
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", cgx.f13797O000000o);
            sortedParameter.add("payChannel", orderBean.mChannel);
            O000000o o000000o = new O000000o(cgx, (byte) 0);
            cgv cgv = new cgv(cgx.getSession());
            String str = cgx.f13797O000000o;
            String str2 = orderBean.mOrder;
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException(new StringBuilder("CheckUnitedDeductOrderModel  processId can't be null").toString());
            } else if (!TextUtils.isEmpty(str2)) {
                cgv.O00000Oo = o000000o;
                cgv.O000000o o000000o2 = new cgv.O000000o(cgv, cgv.getContext(), (byte) 0);
                SortedParameter sortedParameter2 = new SortedParameter();
                sortedParameter2.add("deductSignOrder", str2);
                sortedParameter2.add("processId", str);
                cgv.f13795O000000o.setParams(sortedParameter2);
                chh.O000000o(cgv.f13795O000000o).O000000o(o000000o2);
            } else {
                throw new IllegalArgumentException(new StringBuilder("CheckUnitedDeductOrderModel  order can't be null").toString());
            }
        } else {
            throw new IllegalStateException("orderBean is null");
        }
    }
}

package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.deduct.d.d;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public final class cfw extends Model {

    /* renamed from: O000000o  reason: collision with root package name */
    private d f13738O000000o;
    /* access modifiers changed from: private */
    public O00000Oo O00000Oo;

    public interface O00000Oo {
        void O000000o(int i, String str);

        void O000000o(d.a aVar);
    }

    public cfw(Session session) {
        super(session);
        if (this.f13738O000000o == null) {
            this.f13738O000000o = new d(getContext(), getSession());
        }
    }

    public final void O000000o(String str, String str2, O00000Oo o00000Oo) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(new StringBuilder("RequestDeductTypeListModel  processId can't be null").toString());
        } else if (!TextUtils.isEmpty(str2)) {
            this.O00000Oo = o00000Oo;
            O000000o o000000o = new O000000o(this, getContext(), (byte) 0);
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", str);
            sortedParameter.add("channels", str2);
            this.f13738O000000o.setParams(sortedParameter);
            chh.O000000o(this.f13738O000000o).O000000o(o000000o);
        } else {
            throw new IllegalArgumentException(new StringBuilder("RequestDeductTypeListModel  channels can't be null").toString());
        }
    }

    class O000000o extends RxBaseErrorHandleTaskListener<d.a> {
        /* synthetic */ O000000o(cfw cfw, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            cfw.this.O00000Oo.O000000o((d.a) obj);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cfw.this.O00000Oo.O000000o(i, str);
        }
    }
}

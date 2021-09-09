package _m_j;

import com.xiaomi.smarthome.R;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0016J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/mi/global/shop/buy/BFLDialogFragment;", "Lcom/mi/global/shop/voice/dialog/BaseDialogFragment;", "()V", "mConvertListener", "Lcom/mi/global/shop/voice/dialog/ViewConvertListener;", "convertView", "", "holder", "Lcom/mi/global/shop/voice/dialog/ViewHolder;", "dialogFragment", "setConvertListener", "convertListener", "setLayoutId", "layoutId", "", "setUpLayoutId", "Companion", "shopsdk_release"}, k = 1, mv = {1, 1, 15})
public final class byv extends cbs {
    public static final O000000o O00000Oo = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    cbt f13427O000000o;
    private HashMap O00000oo;

    public final void O00000o0() {
        HashMap hashMap = this.O00000oo;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O00000o0();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/mi/global/shop/buy/BFLDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/mi/global/shop/buy/BFLDialogFragment;", "shopsdk_release"}, k = 1, mv = {1, 1, 15})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    public final void O000000o(cbu cbu, cbs cbs) {
        ixe.O00000o0(cbu, "holder");
        ixe.O00000o0(cbs, "dialogFragment");
        cbt cbt = this.f13427O000000o;
        if (cbt != null) {
            try {
                cbt.O000000o(cbu, cbs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final int O000000o() {
        return this.O00000o0;
    }

    public final byv O00000Oo() {
        this.O00000o0 = R.layout.shop_layout_dialog_bfl_otp_failed;
        return this;
    }
}

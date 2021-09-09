package com.xiaomi.passport.ui.internal;

import _m_j.ehg;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/xiaomi/accountsdk/account/data/ActivatorPhoneInfo;", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PhoneViewWrapper$1 extends Lambda implements iwc<List<? extends ActivatorPhoneInfo>, iuh> {
    final /* synthetic */ ehg this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneViewWrapper$1(ehg ehg) {
        super(1);
        this.this$0 = ehg;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final /* synthetic */ Object invoke(Object obj) {
        Editable editable;
        List<? extends ActivatorPhoneInfo> list = (List) obj;
        ixe.O00000o0(list, "it");
        ehg ehg = this.this$0;
        ehg.O00000Oo = list;
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (ActivatorPhoneInfo activatorPhoneInfo : list) {
                String str = activatorPhoneInfo.phone;
                ixe.O000000o((Object) str, "it.phone");
                arrayList.add(str);
            }
            ehg.O000000o o000000o = new ehg.O000000o(ehg, arrayList, ehg.O00000o, arrayList);
            AutoCompleteTextView autoCompleteTextView = ehg.O00000oO;
            if (autoCompleteTextView != null) {
                autoCompleteTextView.setAdapter(o000000o);
            }
            if (autoCompleteTextView != null) {
                autoCompleteTextView.setThreshold(0);
            }
            if (autoCompleteTextView != null) {
                autoCompleteTextView.setOnItemClickListener(new ehg.O000000o.C0102O000000o(o000000o, autoCompleteTextView));
            }
            if (autoCompleteTextView != null) {
                editable = autoCompleteTextView.getText();
            } else {
                editable = null;
            }
            if (TextUtils.isEmpty(editable) && o000000o.getCount() > 0) {
                o000000o.O000000o(autoCompleteTextView, 0);
            }
        }
        return iuh.f1631O000000o;
    }
}

package _m_j;

import _m_j.ehc;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"countryCodeWithPrefix", "", "Lcom/xiaomi/passport/ui/internal/PhoneNumUtil$CountryPhoneNumData;", "getCountryCodeWithPrefix", "(Lcom/xiaomi/passport/ui/internal/PhoneNumUtil$CountryPhoneNumData;)Ljava/lang/String;", "smartGetCountryCodeData", "context", "Landroid/content/Context;", "icOrIso", "client-ui_release"}, k = 2, mv = {1, 1, 10})
public final class ege {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.util.List<_m_j.ehc$O000000o>, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [_m_j.ehc$O000000o, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public static final ehc.O000000o O000000o(Context context, String str) {
        ixe.O00000o0(context, "context");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<ehc.O000000o> O000000o2 = ehc.O000000o(context);
        ixe.O000000o((Object) O000000o2, "sortedData");
        Collection arrayList = new ArrayList();
        Iterator it = O000000o2.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                return (ehc.O000000o) iuo.O000000o((List) arrayList, 0);
            }
            Object next = it.next();
            ehc.O000000o o000000o = (ehc.O000000o) next;
            ixe.O000000o((Object) o000000o, "it");
            if (ixe.O000000o((Object) str, (Object) O000000o(o000000o)) || ixe.O000000o((Object) str, (Object) o000000o.O00000o0)) {
                z = true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
    }

    public static final String O000000o(ehc.O000000o o000000o) {
        ixe.O00000o0(o000000o, "$receiver");
        return "+" + o000000o.O00000Oo;
    }
}

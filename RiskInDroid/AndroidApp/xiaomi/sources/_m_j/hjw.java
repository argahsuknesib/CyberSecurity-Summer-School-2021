package _m_j;

import _m_j.hjq;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u0010*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0010B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/operation/helper/CommonShownHelper;", "E", "Lcom/xiaomi/smarthome/operation/beans/IAdOperation;", "Lcom/xiaomi/smarthome/operation/helper/IShownHelper;", "cacheKey", "", "(Ljava/lang/String;)V", "haveOperationShown", "", "ops", "", "isOperationShown", "hash", "setOperationHaveShown", "", "shown", "Companion", "smarthome-operation_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hjw<E extends hjq> implements hjz<E> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f19005O000000o = new O000000o((byte) 0);
    private final String O00000Oo;

    public hjw(String str) {
        ixe.O00000o(str, "cacheKey");
        this.O00000Oo = str;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/operation/helper/CommonShownHelper$Companion;", "", "()V", "IS_OPERATION_SHOWN_SET_SUFFIX", "", "smarthome-operation_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final boolean O000000o(List<? extends E> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        String valueOf = String.valueOf(list.hashCode());
        if (TextUtils.isEmpty(valueOf)) {
            return false;
        }
        return ServiceApplication.getAppContext().getSharedPreferences(ixe.O000000o(this.O00000Oo, (Object) "_is_operation_shown_set"), 0).getBoolean(valueOf, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void O00000Oo(List<? extends E> list) {
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            ServiceApplication.getAppContext().getSharedPreferences(ixe.O000000o(this.O00000Oo, (Object) "_is_operation_shown_set"), 0).edit().putBoolean(String.valueOf(list.hashCode()), true).apply();
        }
    }
}

package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.flexible_layout.FlexSize;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/xiaomi/smarthome/newui/utils/MainListFlexQuery;", "", "()V", "Companion", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hha {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18928O000000o = new O000000o((byte) 0);
    public static final Map<FlexSize, hhb> O00000Oo = ivb.O000000o(iuf.O000000o(FlexSize.Normal, new hhb(3, 2, 1)), iuf.O000000o(FlexSize.W530dp, new hhb(5, 3, 2)), iuf.O000000o(FlexSize.W780dp, new hhb(5, 4, 3)), iuf.O000000o(FlexSize.W960dp, new hhb(6, 4, 3)), iuf.O000000o(FlexSize.W1280dp, new hhb(8, 4, 3)));

    public static final hhb O000000o() {
        return O000000o.O000000o();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/xiaomi/smarthome/newui/utils/MainListFlexQuery$Companion;", "", "()V", "dimensMap", "", "Lcom/xiaomi/smarthome/flexible_layout/FlexSize;", "Lcom/xiaomi/smarthome/newui/utils/MainListFlexSize;", "dimen", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, com.xiaomi.smarthome.flexible_layout.FlexSize]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public static hhb O000000o() {
            Context appContext = CommonApplication.getAppContext();
            Map<FlexSize, hhb> map = hha.O00000Oo;
            FlexSize.O000000o o000000o = FlexSize.Companion;
            ixe.O00000Oo(appContext, "context");
            hhb hhb = map.get(FlexSize.O000000o.O000000o(appContext));
            gsy.O00000o0(LogType.MAIN_PAGE, "MainListFlexQuery", String.valueOf(hhb));
            if (hhb != null) {
                return hhb;
            }
            FlexSize.O000000o o000000o2 = FlexSize.Companion;
            throw new IllegalStateException(ixe.O000000o("illegal flex size: ", (Object) FlexSize.O000000o.O000000o(appContext)).toString());
        }
    }
}

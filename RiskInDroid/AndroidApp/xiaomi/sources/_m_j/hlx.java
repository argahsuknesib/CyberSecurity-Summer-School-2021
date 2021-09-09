package _m_j;

import com.xiaomi.smarthome.operation.provider.seq.ThirdPartOperationProvider$1;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/xiaomi/smarthome/operation/provider/seq/ThirdPartOperationProvider;", "Lcom/xiaomi/smarthome/operation/provider/seq/CommonBaseOperationProvider;", "Lcom/xiaomi/smarthome/operation/beans/thirdpart/ThirdBannerItem;", "()V", "parse", "", "string", "", "smarthome-operation_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hlx extends hlt<hjv> {
    public hlx() {
        super("thirdPart", "/newoperation/banners/v2", ivb.O000000o(iuf.O000000o("type", ThirdPartOperationProvider$1.f10536O000000o)));
    }

    public final List<hjv> O000000o(String str) {
        ixe.O00000o(str, "string");
        List<hjv> O000000o2 = hjv.O000000o(str);
        ixe.O00000Oo(O000000o2, "parse(string)");
        return O000000o2;
    }
}

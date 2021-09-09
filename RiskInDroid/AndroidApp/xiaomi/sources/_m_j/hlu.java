package _m_j;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/operation/provider/seq/CommonOperationProvider;", "Lcom/xiaomi/smarthome/operation/provider/seq/CommonBaseOperationProvider;", "Lcom/xiaomi/smarthome/operation/beans/common/CommonAdOperation;", "cacheKey", "", "params", "", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/util/Map;)V", "parse", "", "string", "smarthome-operation_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hlu extends hlt<hjr> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public hlu(String str, Map<String, ? extends iwb<String>> map) {
        super(str, "/cgi-op/api/v1/recommendation/banner", map);
        ixe.O00000o(str, "cacheKey");
    }

    public final List<hjr> O000000o(String str) {
        ixe.O00000o(str, "string");
        List<hjr> O000000o2 = hjr.O000000o(str);
        ixe.O00000Oo(O000000o2, "parse(string)");
        return O000000o2;
    }
}

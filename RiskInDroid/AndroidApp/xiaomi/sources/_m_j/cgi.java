package _m_j;

import com.mibi.sdk.component.recharge.BaseRechargeMethodParser;
import com.mibi.sdk.component.recharge.RechargeMethod;
import com.mibi.sdk.deduct.j;

public final class cgi extends BaseRechargeMethodParser {
    public final RechargeMethod newRechargeMethod() {
        return new j();
    }
}

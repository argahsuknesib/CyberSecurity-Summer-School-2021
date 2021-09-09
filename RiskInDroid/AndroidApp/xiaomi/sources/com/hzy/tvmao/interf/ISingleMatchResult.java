package com.hzy.tvmao.interf;

import com.kookong.app.data.RcTestRemoteKeyV3;
import java.util.List;

public interface ISingleMatchResult {
    void onError();

    void onMatchedIR(String str);

    void onNextGroupKey(List<RcTestRemoteKeyV3> list);

    void onNotMatchIR();
}

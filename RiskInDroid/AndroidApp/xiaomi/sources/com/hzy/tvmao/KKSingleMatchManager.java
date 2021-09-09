package com.hzy.tvmao;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.b.ae;
import com.hzy.tvmao.interf.ISingleMatchResult;
import com.hzy.tvmao.utils.LogUtil;
import com.kookong.app.data.RcTestRemoteKeyV3;
import java.util.List;

public class KKSingleMatchManager {
    private String deviceType;
    private boolean isZipCode;
    private String mr;
    private a onGetSingleKeyDataListener;
    public ae singleKeyControl;
    private String testPower;

    public interface a {
        void a(String str, String str2, String str3, boolean z, a.c cVar);
    }

    public KKSingleMatchManager() {
        this(false);
    }

    public KKSingleMatchManager(boolean z) {
        initManager(z);
        this.onGetSingleKeyDataListener = new a(this);
    }

    private void initManager(boolean z) {
        this.isZipCode = z;
        this.singleKeyControl = new ae();
    }

    public void getMatchKey(int i, String str, boolean z, ISingleMatchResult iSingleMatchResult) {
        this.mr = str;
        this.deviceType = String.valueOf(i);
        this.testPower = z ? "0" : "1";
        LogUtil.d("首次获取测试按键   deviceType：" + i + ",allRemote：" + this.mr + ",testSwitch：" + z);
        getSingleKey(this.deviceType, this.mr, this.testPower, iSingleMatchResult);
    }

    public void keyIsWorking(RcTestRemoteKeyV3 rcTestRemoteKeyV3, ISingleMatchResult iSingleMatchResult) {
        String str = "null";
        if ("按键响应：cname=".concat(String.valueOf(rcTestRemoteKeyV3)) != null) {
            if ((rcTestRemoteKeyV3.displayName + ",remoteid=" + rcTestRemoteKeyV3) != null) {
                str = rcTestRemoteKeyV3.remoteIds;
            }
        }
        LogUtil.d(str);
        if (rcTestRemoteKeyV3.remoteIds.trim().split(",").length == 1) {
            LogUtil.d("测试按键只有一个remoteId，直接命中");
            iSingleMatchResult.onMatchedIR(rcTestRemoteKeyV3.remoteIds);
            return;
        }
        String packageWorkMr = packageWorkMr(rcTestRemoteKeyV3);
        LogUtil.d("按键组拼mr mr=".concat(String.valueOf(packageWorkMr)));
        getSingleKey(this.deviceType, packageWorkMr, this.testPower, iSingleMatchResult);
    }

    public void groupKeyNotWork(List<RcTestRemoteKeyV3> list, ISingleMatchResult iSingleMatchResult) {
        String packageAllKeyMr = packageAllKeyMr(list);
        LogUtil.d("一组按键都不好用： mr=".concat(String.valueOf(packageAllKeyMr)));
        getSingleKey(this.deviceType, packageAllKeyMr, this.testPower, iSingleMatchResult);
    }

    private String packageWorkMr(RcTestRemoteKeyV3 rcTestRemoteKeyV3) {
        this.mr += "_" + rcTestRemoteKeyV3.remoteIds + "|" + rcTestRemoteKeyV3.functionId + "|1";
        return this.mr;
    }

    private String packageAllKeyMr(List<RcTestRemoteKeyV3> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            RcTestRemoteKeyV3 rcTestRemoteKeyV3 = list.get(i);
            int i3 = rcTestRemoteKeyV3.functionId;
            stringBuffer.append(rcTestRemoteKeyV3.remoteIds);
            if (i < list.size() - 1) {
                stringBuffer.append(",");
            }
            i++;
            i2 = i3;
        }
        stringBuffer.append("|");
        stringBuffer.append(i2);
        stringBuffer.append("|0");
        this.mr += "_" + stringBuffer.toString();
        return this.mr;
    }

    private void getSingleKey(String str, String str2, String str3, ISingleMatchResult iSingleMatchResult) {
        this.onGetSingleKeyDataListener.a(str, str3, str2, this.isZipCode, new b(this, iSingleMatchResult));
    }

    public KKSingleMatchManager setOnGetSingleKeyDataListener(a aVar) {
        if (aVar != null) {
            this.onGetSingleKeyDataListener = aVar;
            return this;
        }
        throw new IllegalArgumentException("onGetSingleKeyDataListener can not be null.");
    }
}

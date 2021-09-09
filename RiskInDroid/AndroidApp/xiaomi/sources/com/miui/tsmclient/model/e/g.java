package com.miui.tsmclient.model.e;

import com.miui.tsmclient.model.e.h;
import com.miui.tsmclient.seitsm.TsmRpcModels;

public enum g {
    ISSUE(h.a.INSTALL, TsmRpcModels.SeOperationType.INSTALL, "api/%s/se/pullBusCardPersoData", "pullPersoData"),
    TRANSFER_IN(h.a.TRANSFER_IN, TsmRpcModels.SeOperationType.SHIFT_IN, "api/%s/se/pullBusCardShiftInData", "pullBusCardTransfer"),
    TRANSFER_OUT(h.a.TRANSFER_OUT, TsmRpcModels.SeOperationType.SHIFT_OUT, "api/%s/se/pullBusCardShiftOutData", "pullBusCardTransfer"),
    RECHARGE(h.a.RECHARGE, TsmRpcModels.SeOperationType.TOPUP, "api/%s/se/pullBusCardTopUpData", "pullBusCardTopUp"),
    OUT_ISSUE(h.a.OUT_INSTALL, TsmRpcModels.SeOperationType.OUT_INSTALL, "api/%s/se/pullBusCardPersoData", "pullBusCardOutInstall"),
    OUT_RECHARGE(h.a.OUT_RECHARGE, TsmRpcModels.SeOperationType.OUT_TOPUP, "api/%s/se/pullBusCardTopUpData", "pullBusCardOutTopUp"),
    OUT_RETURN(h.a.OUT_RETURN, TsmRpcModels.SeOperationType.OUT_RETURN, "api/%s/se/pullBusCardReturnData", "pullBusCardOutReturn");
    
    private h.a h;
    private TsmRpcModels.SeOperationType i;
    private String j;
    private String k;

    private g(h.a aVar, TsmRpcModels.SeOperationType seOperationType, String str, String str2) {
        this.h = aVar;
        this.i = seOperationType;
        this.j = str;
        this.k = str2;
    }

    public final h.a a() {
        return this.h;
    }

    public final TsmRpcModels.SeOperationType b() {
        return this.i;
    }

    public final String c() {
        return this.k;
    }

    public final String d() {
        return this.j;
    }
}

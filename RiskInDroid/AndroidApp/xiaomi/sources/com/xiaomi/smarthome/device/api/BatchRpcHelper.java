package com.xiaomi.smarthome.device.api;

import _m_j.fsm;
import _m_j.fso;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BatchRpcHelper {
    private List<BatchRpcParam> batchData = new ArrayList();

    public BatchRpcHelper addBatchRequest(String str, String str2, JSONArray jSONArray) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        BatchRpcParam batchRpcParam = new BatchRpcParam();
        batchRpcParam.f6888O000000o = str;
        batchRpcParam.O00000Oo = str2;
        batchRpcParam.O00000o0 = jSONArray;
        this.batchData.add(batchRpcParam);
        return this;
    }

    public void commit(fsm<JSONObject, fso> fsm) {
        if (this.batchData.size() <= 20) {
            CoreApi.O000000o().O000000o(this.batchData, fsm);
        } else if (fsm != null) {
            fsm.onFailure(new fso(0, "too many rpc requests, cannot be more than 20"));
        }
    }
}

package com.tiqiaa.icontrol.util;

import _m_j.bdf;
import _m_j.boi;
import _m_j.bqh;
import _m_j.bqm;
import android.content.Context;
import com.lidroid.xutils.http.client.HttpRequest;
import com.tiqiaa.irdnasdk.IrDnaSdkHelper;
import com.tiqiaa.util.NetUtil;

public class NetUtils {
    private Context context;
    private boi httpUtils = new boi((byte) 0);

    public NetUtils(Context context2) {
        this.context = context2;
    }

    public void doPost(String str, Object obj, bqm<String> bqm) {
        try {
            bqh bqh = new bqh();
            bqh.O000000o("token", IrDnaSdkHelper.getToken(0));
            if (obj != null) {
                bqh.O000000o("params", NetUtil.encode(this.context, bdf.O000000o(obj), 0));
                LogUtil.e("NetUtils", "\r\nrequest param:" + bdf.O000000o(obj));
            }
            this.httpUtils.O000000o(HttpRequest.HttpMethod.POST, str, bqh, bqm);
        } catch (Exception e) {
            e.printStackTrace();
            bqm.onFailure(null, e.toString());
        }
    }

    public void doPostTv(String str, RequestDTO requestDTO, bqm<String> bqm) {
        try {
            LogUtil.d("NetUtils", "postRequest..............01");
            String requestJson = DTOUtil.getRequestJson(requestDTO);
            bqh bqh = new bqh();
            bqh.O000000o("client_request_params", requestJson);
            this.httpUtils.O000000o(HttpRequest.HttpMethod.POST, str, bqh, bqm);
        } catch (Exception e) {
            e.printStackTrace();
            bqm.onFailure(null, e.toString());
        }
    }
}

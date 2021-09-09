package com.xiaomi.smarthome.wxapi;

import _m_j.cmc;
import _m_j.egt;
import _m_j.eig;
import _m_j.ezv;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.ft;
import _m_j.ftn;
import _m_j.gpc;
import _m_j.gty;
import _m_j.hst;
import _m_j.iah;
import _m_j.iai;
import _m_j.jgc;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class WXEntryActivity extends FragmentActivity implements IWXAPIEventHandler {

    /* renamed from: O000000o  reason: collision with root package name */
    private IWXAPI f12042O000000o;

    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        this.f12042O000000o = ServiceApplication.getIWXAPI();
        this.f12042O000000o.handleIntent(getIntent(), this);
        ft.O000000o(this).O000000o(new Intent("action.wx.login.start"));
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f12042O000000o.handleIntent(intent, this);
    }

    public void onBackPressed() {
        super.onBackPressed();
        O000000o(-9999);
    }

    public void onReq(BaseReq baseReq) {
        ShowMessageFromWX.Req req = (ShowMessageFromWX.Req) baseReq;
        WXMediaMessage wXMediaMessage = req.message;
        if (4 != req.getType()) {
            return;
        }
        if (ezv.O000000o(ServiceApplication.getAppContext()) && (ezv.O00000Oo(ServiceApplication.getAppContext()) || ftn.O000000o(ServiceApplication.getAppContext()) == null)) {
            fbt fbt = new fbt(this, "SmartHomeMainActivity");
            fbt.O00000Oo(67108864);
            fbs.O000000o(fbt);
            finish();
        } else if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            gty.O000000o().startLogin(this, 1, null);
            finish();
        } else {
            try {
                JSONObject jSONObject = new JSONObject(wXMediaMessage.messageExt);
                String str = "";
                if (jSONObject.has("shareTypeCompact")) {
                    str = jSONObject.optString("shareTypeCompact");
                } else if (jSONObject.has("type")) {
                    str = jSONObject.optString("type");
                }
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1788317377) {
                    if (hashCode != -709557578) {
                        if (hashCode == 996485613) {
                            if (str.equals("just_open_home_page")) {
                                c = 2;
                            }
                        }
                    } else if (str.equals("share_device")) {
                        c = 1;
                    }
                } else if (str.equals("share_home")) {
                    c = 0;
                }
                if (c == 0) {
                    fbt fbt2 = new fbt(this, "SmartHomeMainActivity");
                    fbt2.O00000Oo(67108864);
                    fbt2.O000000o("source", 16);
                    fbt2.O000000o("miniProgramV2", jSONObject.optString("miniProgramV2"));
                    fbt2.O000000o("share_mi_id", jSONObject.optString("miId"));
                    fbt2.O000000o("share_key", jSONObject.optString("shareKey"));
                    fbt2.O000000o("share_home_id", jSONObject.optString("homeId"));
                    fbt2.O000000o("share_home_name", jSONObject.optString("homeName"));
                    fbt2.O000000o("share_home_show_accept_dialog", jSONObject.optBoolean("showAcceptDialog", true));
                    fbs.O000000o(fbt2);
                    finish();
                } else if (c == 1) {
                    fbt fbt3 = new fbt(this, "SmartHomeMainActivity");
                    fbt3.O00000Oo(67108864);
                    fbt3.O000000o("source", 14);
                    fbt3.O000000o("miniProgramV2", jSONObject.optString("miniProgramV2"));
                    fbt3.O000000o("share_mi_id", jSONObject.optString("miId"));
                    fbt3.O000000o("device_id", jSONObject.optString("did"));
                    fbs.O000000o(fbt3);
                    finish();
                } else if (c != 2) {
                    fbt fbt4 = new fbt(this, "SmartHomeMainActivity");
                    fbt4.O00000Oo(67108864);
                    fbs.O000000o(fbt4);
                    finish();
                } else {
                    fbt fbt5 = new fbt(this, "SmartHomeMainActivity");
                    fbt5.O00000Oo(67108864);
                    fbt5.O000000o("source", 19);
                    fbt5.O000000o("share_mi_id", jSONObject.optString("miId"));
                    fbs.O000000o(fbt5);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            finish();
        }
    }

    public void onResp(BaseResp baseResp) {
        int i;
        iai iai;
        if (baseResp.getType() == 2) {
            if (baseResp.errCode != 0) {
                cmc.O00000oO();
                hst.O000000o(this, false, baseResp.transaction, baseResp.errCode, "");
            } else {
                cmc.O00000oO();
                hst.O000000o(this, true, baseResp.transaction, baseResp.errCode, "");
            }
        }
        boolean z = baseResp instanceof SendAuth.Resp;
        if (z) {
            SendAuth.Resp resp = (SendAuth.Resp) baseResp;
            if (resp.errCode == 0) {
                String str = resp.code;
                String str2 = resp.state;
                iai = new iai();
                iai.f1091O000000o = true;
                iai.O00000Oo = str;
                iai.O00000o0 = str2;
            } else {
                iai = new iai();
                iai.f1091O000000o = false;
            }
            jgc.O000000o().O00000o(iai);
        } else if (baseResp instanceof WXLaunchMiniProgram.Resp) {
            WXLaunchMiniProgram.Resp resp2 = (WXLaunchMiniProgram.Resp) baseResp;
            if (resp2.getType() == 19 && (i = resp2.errCode) == 0) {
                jgc.O000000o().O00000o(iah.O000000o(String.valueOf(i), resp2.extMsg));
            }
        }
        if (baseResp.errCode != 0 || !z) {
            overridePendingTransition(R.anim.activity_anim_empty, R.anim.activity_anim_empty);
            finish();
            O000000o(baseResp.errCode);
            if (baseResp.getType() == 2) {
                int i2 = baseResp.errCode;
                String str3 = baseResp.errStr;
                ft O000000o2 = ft.O000000o(getApplicationContext());
                Intent intent = new Intent("com.xiaomi.smarthome.action.SHARE_RESULT");
                intent.putExtra("result_code", i2);
                intent.putExtra("message", str3);
                intent.putExtra("extras", (Bundle) null);
                O000000o2.O000000o(intent);
            }
        } else {
            overridePendingTransition(R.anim.activity_anim_empty, R.anim.activity_anim_empty);
            finish();
            SendAuth.Resp resp3 = (SendAuth.Resp) baseResp;
            O000000o(true, resp3.errCode, resp3.code, resp3.state);
        }
        egt egt = egt.f15254O000000o;
        egt egt2 = egt.f15254O000000o;
        ((eig) egt.O000000o("WECHAT_AUTH_PROVIDER")).O000000o(this, getIntent());
        finish();
    }

    private void O000000o(int i) {
        O000000o(false, i, null, null);
    }

    private void O000000o(boolean z, int i, String str, String str2) {
        ft O000000o2 = ft.O000000o(this);
        Intent intent = new Intent("action.wx.login.complete");
        intent.putExtra("login_success", z);
        intent.putExtra("auth_code", str);
        intent.putExtra("error_code", i);
        intent.putExtra("state", str2);
        O000000o2.O000000o(intent);
    }
}

package _m_j;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.authlib.IAuthCallBack;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class ghm implements hso {
    public void setAppId(String str) {
        fak.O000000o().f16002O000000o = str;
    }

    public void setAppSign(String str) {
        fak.O000000o().O00000o = str;
    }

    public void setPackageName(String str) {
        fak.O000000o().O00000o0 = str;
    }

    public fsn deleteAuthV2(List<String> list, fsm fsm) {
        return fak.O000000o().O000000o(list, fsm);
    }

    public fsn getAuthV2(fsm fsm) {
        return fak.O000000o().O00000Oo(fsm);
    }

    public fsn authV2(String str, String str2, String str3, String str4, String str5, fsm fsm) {
        return fak.O000000o().O000000o(str, str2, str3, str4, str5, fsm);
    }

    public void handleAuthSuccess(int i) {
        IAuthCallBack iAuthCallBack = fak.O000000o().O00000oO;
        if (iAuthCallBack != null) {
            try {
                iAuthCallBack.onSuccess(101, new Bundle());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleAuthFail(int i) {
        IAuthCallBack iAuthCallBack = fak.O000000o().O00000oO;
        if (iAuthCallBack != null) {
            try {
                iAuthCallBack.onFail(-113, new Bundle());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public String getAuthAppId() {
        return fak.O000000o().f16002O000000o;
    }

    public String getAuthAppName() {
        return fak.O000000o().O00000Oo.f16000O000000o;
    }

    public void clear() {
        fak.O000000o();
        fak.O00000o();
    }

    public void checkPrivacy(int i, String str, fsm<? super JSONObject, fso> fsm) {
        hji O000000o2 = hji.O000000o();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("client", 0);
            jSONObject.put("privacy_id", i);
            jSONObject.put("ver", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        fdt.O000000o().O000000o(new NetRequest.O000000o().O00000Oo("/v2/user/get_privacy_changes").O000000o("POST").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O000000o(), new fdh<NetResult, NetError>(fsm) {
            /* class _m_j.hji.AnonymousClass3 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ fsm f18988O000000o;

            {
                this.f18988O000000o = r2;
            }

            public final /* synthetic */ void onFailure(Error error) {
                fso fso;
                NetError netError = (NetError) error;
                fsm fsm = this.f18988O000000o;
                if (netError == null) {
                    fso = new fso(-1, null);
                } else {
                    fso = new fso(netError.f6718O000000o, netError.O00000Oo);
                }
                fsm.sendFailureMessage(fso);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                try {
                    this.f18988O000000o.sendSuccessMessage(new JSONObject(((NetResult) obj).O00000o0).optJSONObject("result"));
                } catch (Exception e) {
                    this.f18988O000000o.sendFailureMessage(new fso(-1, Log.getStackTraceString(e)));
                }
            }
        });
    }
}

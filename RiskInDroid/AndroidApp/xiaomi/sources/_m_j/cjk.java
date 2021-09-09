package _m_j;

import com.xiaomi.smarthome.camera.IXmConnectionClient;
import org.json.JSONException;
import org.json.JSONObject;

public final class cjk implements cjj {

    /* renamed from: O000000o  reason: collision with root package name */
    public IXmConnectionClient f13942O000000o;

    public cjk(IXmConnectionClient iXmConnectionClient) {
        this.f13942O000000o = iXmConnectionClient;
    }

    public final void O000000o(int i) {
        this.f13942O000000o.sendP2pCmd(265, O000000o("videoquality", i), (IXmConnectionClient.XmActionCallback) null);
    }

    public final void O000000o() {
        this.f13942O000000o.sendP2pCmd(262, O000000o("speakerStart", 1), new IXmConnectionClient.XmActionCallback(null) {
            /* class _m_j.cjk.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ IXmConnectionClient.XmActionCallback f13943O000000o = null;

            public final void onSuccess(String str, Object obj) {
                cjk.this.f13942O000000o.setCallStatus(true);
                IXmConnectionClient.XmActionCallback xmActionCallback = this.f13943O000000o;
                if (xmActionCallback != null) {
                    xmActionCallback.onSuccess(str, obj);
                }
            }

            public final void onFailed(int i, String str) {
                IXmConnectionClient.XmActionCallback xmActionCallback = this.f13943O000000o;
                if (xmActionCallback != null) {
                    xmActionCallback.onFailed(i, str);
                }
            }
        });
        this.f13942O000000o.sendP2pCmd(260, "", (IXmConnectionClient.XmActionCallback) null);
    }

    public final void O00000Oo() {
        this.f13942O000000o.sendP2pCmd(264, O000000o("speakerStop", 1), (IXmConnectionClient.XmActionCallback) null);
    }

    public final void O000000o(boolean z) {
        this.f13942O000000o.sendP2pCmd(z ? 260 : 261, "", (IXmConnectionClient.XmActionCallback) null);
    }

    public final void O00000Oo(boolean z) {
        this.f13942O000000o.sendP2pCmd(z ? 258 : 259, "", (IXmConnectionClient.XmActionCallback) null);
    }

    public final void O000000o(int i, IXmConnectionClient.XmActionCallback xmActionCallback) {
        this.f13942O000000o.sendP2pCmd(274, O000000o("operation", i), xmActionCallback);
    }

    private static String O000000o(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, i);
        } catch (JSONException e) {
            wd.O00000o("XmConnectionClientAssist", "JSONException:" + e.getLocalizedMessage());
        }
        return jSONObject.toString();
    }
}

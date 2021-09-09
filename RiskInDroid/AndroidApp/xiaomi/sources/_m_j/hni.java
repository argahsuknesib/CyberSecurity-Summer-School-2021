package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hni {
    private static volatile hni O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Handler f19080O000000o = new Handler(Looper.getMainLooper()) {
        /* class _m_j.hni.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                hni.this.O00000o0();
            }
        }
    };
    private List<O000000o> O00000o0 = new CopyOnWriteArrayList();

    public interface O000000o {
        void O000000o(List<SceneApi.O000OOOo> list);
    }

    public static hni O000000o() {
        if (O00000Oo == null) {
            synchronized (hni.class) {
                if (O00000Oo == null) {
                    O00000Oo = new hni();
                }
            }
        }
        return O00000Oo;
    }

    private hni() {
    }

    public final void O00000Oo() {
        this.f19080O000000o.removeMessages(1);
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("user_scene_switch_changed");
        try {
            jSONObject.put("pushId", ezo.O000000o().getPushId());
            jSONObject.put("events", jSONArray);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/mipush/user_event_unsub").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.hni.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, (fsm) null);
    }

    public final void O00000o0() {
        O000000o(new frg() {
            /* class _m_j.hni.AnonymousClass3 */

            public final void O000000o(fso fso) {
            }

            public final void O000000o(String str, String str2, JSONArray jSONArray) {
            }

            public final void O000000o(String str) {
                hni.this.f19080O000000o.removeMessages(1);
                hni.this.f19080O000000o.sendMessageDelayed(hni.this.f19080O000000o.obtainMessage(1), 180000);
            }
        });
    }

    private void O000000o(final frg frg) {
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            frg.O000000o(new fso(-1, "not logged in"));
        } else {
            O000000o(ServiceApplication.getAppContext(), 180, new fsm<JSONObject, fso>() {
                /* class _m_j.hni.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    frg frg;
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null && (frg = frg) != null) {
                        frg.O000000o(jSONObject.toString());
                    }
                }

                public final void onFailure(fso fso) {
                    frg frg = frg;
                    if (frg != null) {
                        frg.O000000o(fso);
                    }
                }
            });
        }
    }

    private void O000000o(Context context, int i, fsm<JSONObject, fso> fsm) {
        if (TextUtils.isEmpty(ezo.O000000o().getPushId())) {
            this.f19080O000000o.removeMessages(1);
            this.f19080O000000o.sendEmptyMessageDelayed(1, 500);
            return;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("user_scene_switch_changed");
        try {
            jSONObject.put("pushId", ezo.O000000o().getPushId());
            jSONObject.put("expire", 180);
            jSONObject.put("events", jSONArray);
            jSONObject.put("client", 0);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/mipush/user_event_sub").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.hni.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final void O000000o(List<SceneApi.O000OOOo> list) {
        for (O000000o next : this.O00000o0) {
            if (next != null) {
                next.O000000o(list);
            }
        }
    }

    public final void O000000o(O000000o o000000o) {
        synchronized (this.O00000o0) {
            if (!this.O00000o0.contains(o000000o)) {
                this.O00000o0.add(o000000o);
            }
        }
    }

    public final void O00000Oo(O000000o o000000o) {
        synchronized (this.O00000o0) {
            this.O00000o0.remove(o000000o);
        }
    }
}

package _m_j;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class clm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f14083O000000o = "clm";
    public List<O000000o> O00000Oo = new ArrayList();
    private Handler O00000o = null;
    public dty O00000o0;

    public interface O000000o {
        void onPropertyChanged(dty dty, HashSet<String> hashSet);
    }

    public clm(dty dty) {
        this.O00000o0 = dty;
        HandlerThread handlerThread = new HandlerThread("subscribe_thread");
        handlerThread.start();
        this.O00000o = new Handler(handlerThread.getLooper()) {
            /* class _m_j.clm.AnonymousClass1 */

            public final void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    clm.this.O000000o();
                } else if (i == 2) {
                    Intent intent = (Intent) message.obj;
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("data");
                        civ.O000000o(clm.f14083O000000o, stringExtra);
                        cll O000000o2 = clm.this.O00000o0.O000000o();
                        try {
                            JSONArray jSONArray = new JSONArray(stringExtra);
                            if (jSONArray.length() != 0) {
                                HashSet hashSet = new HashSet();
                                int length = jSONArray.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                    String string = jSONObject.getString("key");
                                    if (!TextUtils.isEmpty(string)) {
                                        if (string.startsWith("prop.")) {
                                            string = string.substring(5);
                                        }
                                        Object obj = jSONObject.get("value");
                                        if (obj instanceof JSONArray) {
                                            obj = ((JSONArray) obj).getString(0);
                                        }
                                        O000000o2.O00000Oo(string, obj);
                                        hashSet.add(string);
                                    }
                                }
                                if (clm.this.O00000Oo != null && !clm.this.O00000Oo.isEmpty()) {
                                    for (int i3 = 0; i3 < clm.this.O00000Oo.size(); i3++) {
                                        O000000o o000000o = clm.this.O00000Oo.get(i3);
                                        if (o000000o != null) {
                                            o000000o.onPropertyChanged(clm.this.O00000o0, hashSet);
                                        }
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (i == 4) {
                    clm.this.O00000Oo();
                }
            }
        };
    }

    public final void O000000o(O000000o o000000o) {
        if (o000000o != null) {
            if (this.O00000Oo == null) {
                this.O00000Oo = new ArrayList();
            }
            if (!this.O00000Oo.contains(o000000o)) {
                this.O00000Oo.add(o000000o);
            }
        }
    }

    public final void O00000Oo(O000000o o000000o) {
        List<O000000o> list;
        if (o000000o != null && (list = this.O00000Oo) != null) {
            list.remove(o000000o);
        }
    }

    public final void O000000o(String str) {
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        if (this.O00000Oo != null) {
            for (int i = 0; i < this.O00000Oo.size(); i++) {
                O000000o o000000o = this.O00000Oo.get(i);
                if (o000000o != null) {
                    o000000o.onPropertyChanged(this.O00000o0, hashSet);
                }
            }
        }
    }

    public final void O000000o() {
        dty dty;
        XmPluginHostApi instance = XmPluginHostApi.instance();
        if (instance != null && (dty = this.O00000o0) != null && dty.getDid() != null) {
            this.O00000o.sendEmptyMessageDelayed(1, 180000);
            instance.subscribeDevice(this.O00000o0.getDid(), 0, this.O00000o0.O000000o().O000000o(), 3, null);
        }
    }

    public final void O00000Oo() {
        dty dty;
        XmPluginHostApi instance = XmPluginHostApi.instance();
        if (instance != null && (dty = this.O00000o0) != null && dty.getDid() != null) {
            this.O00000o.sendEmptyMessageDelayed(4, 180000);
            instance.subscribeDevice(this.O00000o0.getDid(), 0, this.O00000o0.O000000o().O00000Oo(), 3, null);
        }
    }

    public final void O000000o(Intent intent) {
        Message obtainMessage = this.O00000o.obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.obj = intent;
        this.O00000o.removeMessages(2);
        this.O00000o.sendMessage(obtainMessage);
    }
}

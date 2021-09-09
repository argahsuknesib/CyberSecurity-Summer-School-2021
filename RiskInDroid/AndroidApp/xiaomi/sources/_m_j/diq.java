package _m_j;

import android.content.Intent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class diq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static diq f14693O000000o;
    private Map<String, O000000o> O00000Oo = Collections.synchronizedMap(new HashMap());

    public static diq O000000o() {
        if (f14693O000000o == null) {
            f14693O000000o = new diq();
        }
        return f14693O000000o;
    }

    private diq() {
        if (this.O00000Oo == null) {
            this.O00000Oo = Collections.synchronizedMap(new HashMap());
        }
    }

    public final Object O000000o(djz djz) {
        O000000o put;
        String O000000o2 = djn.O000000o(11101);
        if (O000000o2 == null) {
            diz.O00000oO("openSDK_LOG.UIListenerManager", new StringBuilder("setListener action is null! rquestCode=11101").toString());
            return null;
        }
        synchronized (this.O00000Oo) {
            put = this.O00000Oo.put(O000000o2, new O000000o(11101, djz));
        }
        if (put == null) {
            return null;
        }
        return put.O00000Oo;
    }

    public final djz O000000o(String str) {
        O000000o o000000o;
        if (str == null) {
            diz.O00000oO("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.O00000Oo) {
            o000000o = this.O00000Oo.get(str);
            this.O00000Oo.remove(str);
        }
        if (o000000o == null) {
            return null;
        }
        return o000000o.O00000Oo;
    }

    public static void O000000o(Intent intent, djz djz) {
        diz.O00000o0("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (intent == null) {
            djz.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra("key_action");
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra("key_error_code", 0);
            if (intExtra == 0) {
                String stringExtra2 = intent.getStringExtra("key_response");
                if (stringExtra2 != null) {
                    try {
                        djz.onComplete(djp.O00000o(stringExtra2));
                    } catch (JSONException e) {
                        djz.onError(new dkb(-4, "服务器返回数据格式有误!", stringExtra2));
                        diz.O00000Oo("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                    }
                } else {
                    diz.O00000Oo("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                    djz.onComplete(new JSONObject());
                }
            } else {
                diz.O00000oO("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = ".concat(String.valueOf(intExtra)));
                djz.onError(new dkb(intExtra, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
            }
        } else if ("action_share".equals(stringExtra)) {
            String stringExtra3 = intent.getStringExtra("result");
            String stringExtra4 = intent.getStringExtra("response");
            if ("cancel".equals(stringExtra3)) {
                djz.onCancel();
            } else if ("error".equals(stringExtra3)) {
                djz.onError(new dkb(-6, "unknown error", String.valueOf(stringExtra4)));
            } else if ("complete".equals(stringExtra3)) {
                try {
                    djz.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    djz.onError(new dkb(-4, "json error", String.valueOf(stringExtra4)));
                }
            }
        }
    }

    public final boolean O000000o(int i, int i2, Intent intent, djz djz) {
        djz djz2;
        diz.O00000o0("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i + " res=" + i2);
        String O000000o2 = djn.O000000o(i);
        if (O000000o2 == null) {
            diz.O00000oO("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=".concat(String.valueOf(i)));
            djz2 = null;
        } else {
            djz2 = O000000o(O000000o2);
        }
        if (djz2 != null) {
            djz = djz2;
        } else if (djz == null) {
            diz.O00000oO("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
            return false;
        } else if (i == 11101) {
            diz.O00000oO("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11105) {
            diz.O00000oO("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11106) {
            diz.O00000oO("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        }
        if (i2 != -1) {
            djz.onCancel();
        } else if (intent == null) {
            djz.onError(new dkb(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
            return true;
        } else {
            String stringExtra = intent.getStringExtra("key_action");
            if ("action_login".equals(stringExtra)) {
                int intExtra = intent.getIntExtra("key_error_code", 0);
                if (intExtra == 0) {
                    String stringExtra2 = intent.getStringExtra("key_response");
                    if (stringExtra2 != null) {
                        try {
                            djz.onComplete(djp.O00000o(stringExtra2));
                        } catch (JSONException e) {
                            djz.onError(new dkb(-4, "服务器返回数据格式有误!", stringExtra2));
                            diz.O00000Oo("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                        }
                    } else {
                        diz.O00000Oo("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                        djz.onComplete(new JSONObject());
                    }
                } else {
                    diz.O00000oO("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = ".concat(String.valueOf(intExtra)));
                    djz.onError(new dkb(intExtra, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
                }
            } else if ("action_share".equals(stringExtra) || "action_request_avatar".equals(stringExtra) || "action_request_dynamic_avatar".equals(stringExtra) || "action_request_set_emotion".equals(stringExtra)) {
                String stringExtra3 = intent.getStringExtra("result");
                String stringExtra4 = intent.getStringExtra("response");
                if ("cancel".equals(stringExtra3)) {
                    djz.onCancel();
                } else if ("error".equals(stringExtra3)) {
                    djz.onError(new dkb(-6, "unknown error", String.valueOf(stringExtra4)));
                } else if ("complete".equals(stringExtra3)) {
                    try {
                        djz.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        djz.onError(new dkb(-4, "json error", String.valueOf(stringExtra4)));
                    }
                }
            } else {
                int intExtra2 = intent.getIntExtra("key_error_code", 0);
                if (intExtra2 == 0) {
                    String stringExtra5 = intent.getStringExtra("key_response");
                    if (stringExtra5 != null) {
                        try {
                            djz.onComplete(djp.O00000o(stringExtra5));
                        } catch (JSONException unused) {
                            djz.onError(new dkb(-4, "服务器返回数据格式有误!", stringExtra5));
                        }
                    } else {
                        djz.onComplete(new JSONObject());
                    }
                } else {
                    djz.onError(new dkb(intExtra2, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
                }
            }
        }
        return true;
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f14694O000000o = 11101;
        public djz O00000Oo;

        public O000000o(int i, djz djz) {
            this.O00000Oo = djz;
        }
    }
}

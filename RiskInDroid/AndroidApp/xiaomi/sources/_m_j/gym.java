package _m_j;

import _m_j.fan;
import _m_j.fno;
import _m_j.gsj;
import _m_j.gyt;
import _m_j.gyu;
import _m_j.hlz;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gym {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f18554O000000o = "2882303761517625813";
    public static String O00000Oo = "com.miot.xiaomi.WeChat-miniAPP";
    public static int O00000o = 20;
    public static String O00000o0 = "75EF37F7110FFBE8C3B60E5D312F68BF";
    private static String O0000oo = "https://openapp.io.mi.com";
    private static gym O0000oo0 = null;
    private static String O0000ooO = "https://wx.api.home.mi.com/wx/v1/";
    private static String O0000ooo = "https://wx.api.home.mi.com/wx/v2/";
    public List<gys> O00000oO = new ArrayList();
    public List<String> O00000oo = new ArrayList();
    public Map<String, fan.O000000o> O0000O0o = new HashMap();
    public Map<String, Integer> O0000OOo = new HashMap();
    Map<String, String> O0000Oo = new HashMap();
    Map<String, Bitmap> O0000Oo0 = new HashMap();
    public gyn O0000OoO;
    public String O0000Ooo = null;
    public boolean O0000o = true;
    public boolean O0000o0 = true;
    public String O0000o00 = null;
    int O0000o0O = 0;
    public boolean O0000o0o = true;
    public gyr O0000oO;
    public fno.O000000o O0000oO0 = new fno.O000000o() {
        /* class _m_j.gym.AnonymousClass1 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            fno.O000000o().O00000Oo(gym.this.O0000oO0);
            gym.this.O000000o(false);
        }
    };
    public int O0000oOO = 0;
    public int O0000oOo = 0;

    private gym() {
        hsl.O000000o().setAppId(f18554O000000o);
        hsl.O000000o().setAppSign(O00000o0);
        hsl.O000000o().setPackageName(O00000Oo);
    }

    public static gym O000000o() {
        if (O0000oo0 == null) {
            O0000oo0 = new gym();
        }
        return O0000oo0;
    }

    public final void O000000o(boolean z) {
        final Map<String, Device> O0000O0o2 = fno.O000000o().O0000O0o();
        if (O0000O0o2 != null && O0000O0o2.size() != 0) {
            HashSet hashSet = new HashSet();
            for (Map.Entry<String, Device> value : O0000O0o2.entrySet()) {
                Device device = (Device) value.getValue();
                if (device.isOwner()) {
                    hashSet.add(device.model);
                }
            }
            O000000o(hashSet, new fsm<gyt, fso>() {
                /* class _m_j.gym.AnonymousClass10 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List<gys> list;
                    gyt gyt = (gyt) obj;
                    if (gyt != null && gyt.f18586O000000o != null && gyt.f18586O000000o.size() > 0) {
                        gym gym = gym.this;
                        Map map = O0000O0o2;
                        List<gyt.O000000o> list2 = gyt.f18586O000000o;
                        if (map == null || map.size() == 0) {
                            list = gym.O00000oO;
                        } else if (list2 == null || list2.size() == 0) {
                            list = gym.O00000oO;
                        } else {
                            HashSet hashSet = new HashSet();
                            for (gyt.O000000o next : list2) {
                                if (next.O00000o0) {
                                    hashSet.add(next.f18587O000000o);
                                }
                            }
                            for (Map.Entry value : map.entrySet()) {
                                Device device = (Device) value.getValue();
                                if (hashSet.contains(device.model) && device.isOwner()) {
                                    gym.O00000oO.add(new gys(device));
                                }
                            }
                            list = gym.O00000oO;
                        }
                        gym.O00000oO = list;
                        gym.this.O00000oo = gym.O000000o(gyt.f18586O000000o);
                        if (gym.this.O00000oo != null && gym.this.O00000oo.size() > 0) {
                            gym gym2 = gym.this;
                            gym2.O00000Oo(gym2.O00000oo);
                        }
                        Map map2 = O0000O0o2;
                        if (map2 != null && map2.size() > 0) {
                            hsl.O000000o().getAuthV2(new fsm<JSONObject, fso>() {
                                /* class _m_j.gym.AnonymousClass16 */

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    fan fan;
                                    JSONArray optJSONArray;
                                    JSONObject jSONObject = (JSONObject) obj;
                                    try {
                                        fan = new fan();
                                        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("auth_list")) == null)) {
                                            for (int i = 0; i < optJSONArray.length(); i++) {
                                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                                fan.O000000o o000000o = new fan.O000000o();
                                                o000000o.f16025O000000o = optJSONObject.optInt("scope");
                                                o000000o.O00000Oo = optJSONObject.optString("did");
                                                o000000o.O00000o0 = optJSONObject.optString("access_token");
                                                o000000o.O00000o = optJSONObject.optLong("expire_at");
                                                fan.f16024O000000o.add(o000000o);
                                            }
                                        }
                                    } catch (Exception unused) {
                                        fan = null;
                                    }
                                    if (fan != null) {
                                        if (fan.f16024O000000o != null && fan.f16024O000000o.size() > 0) {
                                            for (fan.O000000o next : fan.f16024O000000o) {
                                                if (next.f16025O000000o == 7 && gym.O000000o(next.O00000o)) {
                                                    gym.this.O0000O0o.put(next.O00000Oo, next);
                                                }
                                            }
                                        }
                                        gym.this.O0000o0o = false;
                                    }
                                    gym.this.O000000o(0);
                                }

                                public final void onFailure(fso fso) {
                                    if (gym.this.O0000OoO != null) {
                                        gym.this.O0000OoO.onError(false);
                                    }
                                }
                            });
                        } else if (gym.this.O0000OoO != null) {
                            gym.this.O0000OoO.onError(false);
                        }
                    } else if (gym.this.O0000OoO != null) {
                        gym.this.O0000OoO.onError(false);
                    }
                }

                public final void onFailure(fso fso) {
                    if (gym.this.O0000OoO != null) {
                        gym.this.O0000OoO.onError(false);
                    }
                }
            });
        } else if (z) {
            fno.O000000o().O000000o(this.O0000oO0);
            fno.O000000o().O0000Oo0();
        } else {
            gyn gyn = this.O0000OoO;
            if (gyn != null) {
                gyn.onSuccess(new ArrayList(), 0, false);
            }
        }
    }

    public static List<String> O000000o(List<gyt.O000000o> list) {
        ArrayList arrayList = new ArrayList();
        for (gyt.O000000o next : list) {
            if (next.O00000o0) {
                arrayList.add(next.f18587O000000o);
            }
        }
        return arrayList;
    }

    public final void O00000Oo() {
        if (TextUtils.isEmpty(this.O0000Ooo)) {
            gyl.O000000o().O000000o(new ftt<ShareUserRecord>() {
                /* class _m_j.gym.AnonymousClass11 */

                public final void O000000o(int i) {
                }

                public final void O000000o(int i, Object obj) {
                }

                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    ShareUserRecord shareUserRecord = (ShareUserRecord) obj;
                    gym.this.O0000Ooo = shareUserRecord.nickName;
                    gym.this.O0000o00 = shareUserRecord.url;
                }
            });
        }
    }

    public final void O000000o(gys gys, String str, boolean z, boolean z2, gyr gyr) {
        this.O0000oO = gyr;
        String str2 = this.O0000Oo.get(gys.O00000o0.model);
        if (this.O0000Oo0.get(str2) == null || this.O0000Oo0.get(str2).isRecycled()) {
            O000000o(str2);
        }
        Map<String, fan.O000000o> map = this.O0000O0o;
        if (map == null || map.size() <= 0 || !this.O0000O0o.containsKey(gys.O00000o0.did) || TextUtils.isEmpty(this.O0000O0o.get(gys.O00000o0.did).O00000o0) || !O000000o(this.O0000O0o.get(gys.O00000o0.did).O00000o)) {
            O00000Oo(gys.O00000o0, "state", str, z, z2);
        } else {
            O000000o(gys.O00000o0, this.O0000O0o.get(gys.O00000o0.did).O00000o0, str, z, z2);
        }
    }

    public static boolean O000000o(long j) {
        return j >= System.currentTimeMillis() / 1000;
    }

    public static void O000000o(List<String> list, fsm fsm) {
        hsl.O000000o().deleteAuthV2(list, fsm);
    }

    public final void O00000o0() {
        this.O0000Oo0.clear();
        O00000o();
        hsl.O000000o().clear();
        if (O0000oo0 != null) {
            O0000oo0 = null;
        }
    }

    public final void O00000o() {
        this.O0000o0O = 0;
        this.O0000o0 = true;
        this.O0000o0o = true;
        this.O0000o = false;
        this.O00000oO.clear();
        this.O0000O0o.clear();
        this.O0000OOo.clear();
    }

    public final void O00000oO() {
        O000000o(this.O0000o0O);
    }

    public final fsn O000000o(HashSet<String> hashSet, fsm<gyt, fso> fsm) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("models", jSONArray);
        } catch (JSONException unused) {
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/product/infomation").O000000o(arrayList).O000000o(), new fss<gyt>() {
            /* class _m_j.gym.AnonymousClass12 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                gyt gyt = new gyt();
                if (jSONObject == null) {
                    return null;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                if (optJSONArray != null) {
                    LogType logType = LogType.GENERAL;
                    gsy.O000000o(logType, "SupportWechatAppInfos", "SupportWechatAppInfos:" + gyt.toString());
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        gyt.O000000o o000000o = new gyt.O000000o();
                        o000000o.f18587O000000o = optJSONObject.optString("model");
                        o000000o.O00000Oo = optJSONObject.optInt("pdid");
                        o000000o.O00000o0 = optJSONObject.optBoolean("supportWechatApp");
                        gyt.f18586O000000o.add(o000000o);
                    }
                } else {
                    gsy.O000000o(LogType.GENERAL, "SupportWechatAppInfos", "SupportWechatAppInfos is null");
                }
                return gyt;
            }
        }, Crypto.RC4, fsm);
    }

    private void O00000o0(List<String> list, fsm<gyu, fso> fsm) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dids", jSONArray);
        } catch (JSONException unused) {
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/gettokencount").O000000o(arrayList).O000000o(), new fss<gyu>() {
            /* class _m_j.gym.AnonymousClass13 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                gyu gyu = new gyu();
                if (jSONObject == null) {
                    return null;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("result");
                if (optJSONArray != null) {
                    LogType logType = LogType.GENERAL;
                    gsy.O000000o(logType, "TokenCountInfo", "TokenCountInfo:" + gyu.toString());
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        gyu.O000000o o000000o = new gyu.O000000o();
                        o000000o.f18589O000000o = optJSONObject.optString("did");
                        o000000o.O00000Oo = optJSONObject.optInt("times");
                        gyu.f18588O000000o.add(o000000o);
                    }
                } else {
                    gsy.O000000o(LogType.GENERAL, "TokenCountInfo", "TokenCountInfo is null");
                }
                return gyu;
            }
        }, Crypto.RC4, fsm);
    }

    private void O00000Oo(Device device, String str, String str2, boolean z, boolean z2) {
        final Device device2 = device;
        final String str3 = str2;
        final boolean z3 = z;
        final boolean z4 = z2;
        hsl.O000000o().authV2("token", device.did, "7", O0000oo, str, new fsm() {
            /* class _m_j.gym.AnonymousClass14 */

            public final void onSuccess(Object obj) {
                if (gym.this.O0000oO != null && TextUtils.equals(gym.this.O0000oO.O00000Oo, device2.did)) {
                    gym.this.O0000oO.O00000Oo();
                }
            }

            public final void onFailure(fso fso) {
                fso fso2 = fso;
                if (fso2.f17063O000000o != 404 || TextUtils.isEmpty(fso2.O00000o0)) {
                    gym.this.O000000o(device2, "", str3, z3, z4);
                    return;
                }
                String str = fso2.O00000o0;
                if (str.contains("access_token")) {
                    String[] split = str.split("&");
                    for (int i = 0; i < split.length; i++) {
                        if (split[i].contains("access_token")) {
                            String substring = str.substring(str.indexOf("access_token=") + 13, split[i].length());
                            fan.O000000o o000000o = new fan.O000000o();
                            o000000o.O00000Oo = device2.did;
                            o000000o.O00000o0 = URLDecoder.decode(substring);
                            o000000o.f16025O000000o = 7;
                            o000000o.O00000o = (System.currentTimeMillis() / 1000) + 352800;
                            gym.this.O0000O0o.put(device2.did, o000000o);
                            gym.this.O000000o(device2, o000000o.O00000o0, str3, z3, z4);
                            return;
                        }
                    }
                }
                gym.this.O000000o(device2, "", str3, z3, z4);
            }
        });
    }

    public final void O000000o(Device device, String str, String str2, boolean z, boolean z2) {
        Device device2 = device;
        if (device2 == null || TextUtils.isEmpty(str)) {
            gyr gyr = this.O0000oO;
            if (gyr != null && TextUtils.equals(gyr.O00000Oo, device2.did)) {
                this.O0000oO.O00000Oo();
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        String sb2 = sb.toString();
        final Device device3 = device;
        final String str3 = str;
        final String str4 = sb2;
        final boolean z3 = z2;
        final String str5 = str2;
        O000000o(z, z2, device2.did, device2.name, str, str5, this.O0000Ooo, sb2, new fsm() {
            /* class _m_j.gym.AnonymousClass15 */

            public final void onSuccess(Object obj) {
                Bitmap bitmap;
                if (gym.this.O0000oO != null && TextUtils.equals(gym.this.O0000oO.O00000Oo, device3.did)) {
                    gym.this.O0000oO.O000000o();
                }
                IWXAPI iwxapi = ServiceApplication.getIWXAPI();
                WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
                wXMiniProgramObject.miniprogramType = 0;
                wXMiniProgramObject.webpageUrl = "https://mijiayoupin.com/shop/main";
                wXMiniProgramObject.userName = "gh_b1cd5e842bf2";
                StringBuilder sb = new StringBuilder("pages/index/index");
                sb.append("?token=");
                sb.append(str3);
                if (!TextUtils.isEmpty(gym.this.O0000Ooo)) {
                    sb.append("&userId=");
                    sb.append(gym.this.O0000Ooo);
                }
                if (!TextUtils.isEmpty(gym.this.O0000o00)) {
                    sb.append("&userAvatar=");
                    sb.append(gym.this.O0000o00);
                }
                sb.append("&miId=");
                sb.append(fdk.O000000o().O0000Oo());
                sb.append("&did=");
                sb.append(device3.did);
                if (!TextUtils.isEmpty(device3.name)) {
                    sb.append("&name=");
                    sb.append(device3.name);
                }
                if (!TextUtils.isEmpty(device3.model)) {
                    sb.append("&model=");
                    sb.append(device3.model);
                }
                sb.append("&sign=");
                sb.append(str4);
                sb.append("&isSupportPermissionCtrl=");
                sb.append(z3 ? "1" : "0");
                if (!TextUtils.isEmpty(str5)) {
                    sb.append("&shareKey=");
                    sb.append(str5);
                }
                if (gym.this.O0000Oo.containsKey(device3.model) && !TextUtils.isEmpty(gym.this.O0000Oo.get(device3.model))) {
                    sb.append("&icon=");
                    sb.append(gym.this.O0000Oo.get(device3.model));
                }
                wXMiniProgramObject.path = sb.toString();
                gsy.O000000o(6, "wxmini", wXMiniProgramObject.path);
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
                wXMediaMessage.title = ServiceApplication.getAppContext().getString(R.string.share_wx_mini_title);
                wXMediaMessage.description = "";
                if (gym.this.O0000Oo0.get(gym.this.O0000Oo.get(device3.model)) != null && !gym.this.O0000Oo0.get(gym.this.O0000Oo.get(device3.model)).isRecycled()) {
                    bitmap = gym.this.O0000Oo0.get(gym.this.O0000Oo.get(device3.model));
                } else if (gym.this.O0000Oo0.get("default") == null || gym.this.O0000Oo0.get("default").isRecycled()) {
                    bitmap = gym.O000000o(BitmapFactory.decodeResource(ServiceApplication.getAppContext().getResources(), R.drawable.device_list_phone_no));
                } else {
                    bitmap = gym.this.O0000Oo0.get("default");
                }
                wXMediaMessage.setThumbImage(bitmap);
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = String.valueOf(System.currentTimeMillis());
                req.message = wXMediaMessage;
                req.scene = 0;
                iwxapi.sendReq(req);
            }

            public final void onFailure(fso fso) {
                if (gym.this.O0000oO != null && TextUtils.equals(gym.this.O0000oO.O00000Oo, device3.did)) {
                    gym.this.O0000oO.O00000Oo();
                }
                if (!TextUtils.isEmpty(fso.O00000Oo)) {
                    gsy.O000000o(6, "share", fso.O00000Oo);
                }
            }
        });
    }

    public final void O000000o(final int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = O00000o * i; i2 < this.O00000oO.size(); i2++) {
            int i3 = O00000o;
            if (i2 >= (i * i3) + i3) {
                break;
            }
            arrayList.add(this.O00000oO.get(i2).O00000o0.did);
        }
        this.O0000o0o = true;
        O00000o0(arrayList, new fsm<gyu, fso>() {
            /* class _m_j.gym.AnonymousClass17 */

            public final /* synthetic */ void onSuccess(Object obj) {
                gyu gyu = (gyu) obj;
                if (!(gyu == null || gyu.f18588O000000o == null)) {
                    for (int i = 0; i < gyu.f18588O000000o.size(); i++) {
                        gym.this.O0000OOo.put(gyu.f18588O000000o.get(i).f18589O000000o, Integer.valueOf(gyu.f18588O000000o.get(i).O00000Oo));
                    }
                }
                if ((i + 1) * gym.O00000o >= gym.this.O00000oO.size()) {
                    gym gym = gym.this;
                    gym.O0000o0 = false;
                    gym.O0000o = false;
                } else {
                    gym.this.O0000o = true;
                }
                gym gym2 = gym.this;
                if (gym2.O0000O0o != null && gym2.O0000O0o.size() > 0) {
                    for (int i2 = gym2.O0000o0O * gym.O00000o; i2 < gym2.O00000oO.size(); i2++) {
                        if (gym2.O0000O0o.containsKey(gym2.O00000oO.get(i2).O00000o0.did) && !TextUtils.isEmpty(gym2.O0000O0o.get(gym2.O00000oO.get(i2).O00000o0.did).O00000o0)) {
                            gym2.O00000oO.get(i2).f18585O000000o = true;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                if (gym2.O0000OOo != null && gym2.O0000OOo.size() > 0) {
                    for (int i3 = gym2.O0000o0O * gym.O00000o; i3 < gym2.O00000oO.size(); i3++) {
                        if (gym2.O0000OOo.get(gym2.O00000oO.get(i3).O00000o0.did) != null) {
                            gym2.O00000oO.get(i3).O00000Oo = gym2.O0000OOo.get(gym2.O00000oO.get(i3).O00000o0.did).intValue();
                            arrayList.add(gym2.O00000oO.get(i3));
                        }
                    }
                }
                if (gym2.O0000OoO != null) {
                    gym2.O0000OoO.onSuccess(arrayList, gym2.O0000o0O, gym2.O0000o0);
                }
                gym2.O0000o0O++;
                gym2.O0000o0o = false;
            }

            public final void onFailure(fso fso) {
                gym gym = gym.this;
                gym.O0000o0o = false;
                gym.O0000o = false;
                if (gym.O0000OoO != null) {
                    gym.this.O0000OoO.onError(gym.this.O0000o0);
                }
            }
        });
    }

    public final void O000000o(final String str) {
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(str), ServiceApplication.getAppContext()).subscribe(new BaseBitmapDataSubscriber() {
            /* class _m_j.gym.AnonymousClass2 */

            public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            }

            public final void onNewResultImpl(final Bitmap bitmap) {
                ServiceApplication.getGlobalHandler().post(new Runnable() {
                    /* class _m_j.gym.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        gym.this.O0000Oo0.put(str, gym.O000000o(bitmap));
                    }
                });
            }
        }, Executors.newCachedThreadPool());
    }

    public final void O00000Oo(List<String> list) {
        if (this.O0000Oo0.get("default") == null || this.O0000Oo0.get("default").isRecycled()) {
            this.O0000Oo0.put("default", O000000o(BitmapFactory.decodeResource(ServiceApplication.getAppContext().getResources(), R.drawable.device_list_phone_no)));
        }
        hlz.O000000o(list, new fsm<hlz.O000000o[], fso>() {
            /* class _m_j.gym.AnonymousClass3 */

            public final void onFailure(fso fso) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                for (hlz.O000000o o000000o : (hlz.O000000o[]) obj) {
                    if (o000000o != null) {
                        gym.this.O0000Oo.put(o000000o.O00000o0, o000000o.f19057O000000o);
                        gym.this.O000000o(o000000o.f19057O000000o);
                    }
                }
            }
        });
    }

    private void O000000o(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, final fsm fsm) {
        String str7;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new gsi("did", str));
        arrayList.add(new gsi("name", str2));
        arrayList.add(new gsi("token", str3));
        arrayList.add(new gsi("shareKey", str4));
        arrayList.add(new gsi("userId", str5));
        arrayList.add(new gsi("sign", str6));
        String str8 = "1";
        arrayList.add(new gsi("isSupportWxShare", z ? str8 : "0"));
        if (!z2) {
            str8 = "0";
        }
        arrayList.add(new gsi("isSupportPermissionCtrl", str8));
        if (TextUtils.isEmpty(str4)) {
            str7 = O0000ooO;
        } else {
            str7 = O0000ooo;
        }
        gsj.O000000o o000000o = new gsj.O000000o();
        o000000o.f18212O000000o = "POST";
        gsj.O000000o O00000Oo2 = o000000o.O00000Oo(str7 + "authorize");
        O00000Oo2.O00000oO = arrayList;
        gsg.O00000Oo(O00000Oo2.O000000o(), new gsl() {
            /* class _m_j.gym.AnonymousClass4 */

            public final void onSuccess(Object obj, Response response) {
            }

            public final void processResponse(Response response) {
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string());
                    if (!jSONObject.isNull("code")) {
                        final int optInt = jSONObject.optInt("code");
                        final String optString = jSONObject.optString("message");
                        if (optInt != 1) {
                            if (optInt != 2) {
                                ServiceApplication.getGlobalHandler().post(new Runnable() {
                                    /* class _m_j.gym.AnonymousClass4.AnonymousClass2 */

                                    public final void run() {
                                        fsm.onFailure(new fso(optInt, optString));
                                    }
                                });
                                return;
                            }
                        }
                        ServiceApplication.getGlobalHandler().post(new Runnable() {
                            /* class _m_j.gym.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                fsm.onSuccess(optString);
                            }
                        });
                        return;
                    }
                    ServiceApplication.getGlobalHandler().post(new Runnable() {
                        /* class _m_j.gym.AnonymousClass4.AnonymousClass3 */

                        public final void run() {
                            fsm.onFailure(new fso(-999, "status is empty"));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    ServiceApplication.getGlobalHandler().post(new Runnable("") {
                        /* class _m_j.gym.AnonymousClass4.AnonymousClass4 */

                        public final void run() {
                            fsm.onFailure(new fso(-999, ""));
                        }
                    });
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }

            public final void processFailure(Call call, IOException iOException) {
                ServiceApplication.getGlobalHandler().post(new Runnable() {
                    /* class _m_j.gym.AnonymousClass4.AnonymousClass5 */

                    public final void run() {
                        fsm.onFailure(new fso(-999, "network error"));
                    }
                });
            }

            public final void onFailure(final gsf gsf, Exception exc, Response response) {
                ServiceApplication.getGlobalHandler().post(new Runnable() {
                    /* class _m_j.gym.AnonymousClass4.AnonymousClass6 */

                    public final void run() {
                        fsm.onFailure(new fso(gsf.f18205O000000o, gsf.O00000Oo));
                    }
                });
            }
        });
    }

    public final void O00000Oo(List<String> list, final fsm fsm) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new gsi("dids", list.get(i)));
        }
        gsj.O000000o o000000o = new gsj.O000000o();
        o000000o.f18212O000000o = "POST";
        gsj.O000000o O00000Oo2 = o000000o.O00000Oo(O0000ooO + "unauthorize");
        O00000Oo2.O00000oO = arrayList;
        gsg.O00000Oo(O00000Oo2.O000000o(), new gsl() {
            /* class _m_j.gym.AnonymousClass5 */

            public final void onSuccess(Object obj, Response response) {
            }

            public final void processResponse(Response response) {
                try {
                    final JSONObject jSONObject = new JSONObject(response.body().string());
                    if (!jSONObject.isNull("code")) {
                        final int optInt = jSONObject.optInt("code");
                        final String optString = jSONObject.optString("message");
                        gsy.O000000o(6, "wxmini", "code= " + optInt + " , message= " + optString);
                        ServiceApplication.getGlobalHandler().post(new Runnable() {
                            /* class _m_j.gym.AnonymousClass5.AnonymousClass1 */

                            public final void run() {
                                fsm.onFailure(new fso(optInt, optString));
                            }
                        });
                    } else if (jSONObject.isNull("warnings")) {
                        ServiceApplication.getGlobalHandler().post(new Runnable() {
                            /* class _m_j.gym.AnonymousClass5.AnonymousClass4 */

                            public final void run() {
                                fsm.onFailure(new fso(-999, "unknown error"));
                            }
                        });
                    } else if (jSONObject.optInt("warnings") == 0) {
                        ServiceApplication.getGlobalHandler().post(new Runnable() {
                            /* class _m_j.gym.AnonymousClass5.AnonymousClass2 */

                            public final void run() {
                                fsm.onSuccess(jSONObject);
                            }
                        });
                    } else {
                        ServiceApplication.getGlobalHandler().post(new Runnable() {
                            /* class _m_j.gym.AnonymousClass5.AnonymousClass3 */

                            public final void run() {
                                fsm.onFailure(new fso(-999, "warnings is not 0"));
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }

            public final void processFailure(Call call, IOException iOException) {
                ServiceApplication.getGlobalHandler().post(new Runnable() {
                    /* class _m_j.gym.AnonymousClass5.AnonymousClass5 */

                    public final void run() {
                        fsm.onFailure(new fso(-999, "network error"));
                    }
                });
            }

            public final void onFailure(final gsf gsf, Exception exc, Response response) {
                ServiceApplication.getGlobalHandler().post(new Runnable() {
                    /* class _m_j.gym.AnonymousClass5.AnonymousClass6 */

                    public final void run() {
                        fsm.onFailure(new fso(gsf.f18205O000000o, gsf.O00000Oo));
                    }
                });
            }
        });
    }

    public static Bitmap O000000o(Bitmap bitmap) {
        double width = (double) bitmap.getWidth();
        Double.isNaN(width);
        int i = (int) (width * 1.25d);
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(i, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(ServiceApplication.getAppContext().getResources().getColor(R.color.mj_color_white));
        canvas.drawRect(0.0f, 0.0f, (float) i, (float) height, paint);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        canvas.drawBitmap(bitmap, ((float) (i - bitmap.getWidth())) * 0.5f, ((float) (height - bitmap.getHeight())) * 0.5f, paint2);
        return createBitmap;
    }

    public final fsn O000000o(String str, fsm fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/share/get_wechatshare_key").O000000o(arrayList).O000000o(), new fss<frw>() {
            /* class _m_j.gym.AnonymousClass8 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return frw.O000000o(jSONObject);
            }
        }, Crypto.RC4, fsm);
    }
}

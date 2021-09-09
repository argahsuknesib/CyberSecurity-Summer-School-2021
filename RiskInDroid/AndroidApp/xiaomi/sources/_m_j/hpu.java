package _m_j;

import _m_j.gof;
import _m_j.hqa;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hpu {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f502O000000o = "hpu";
    public static volatile hpu O00000o0;
    public hqa O00000Oo;
    public String O00000o = null;
    public ArrayList<O000000o> O00000oO = new ArrayList<>();
    public hqa.O00000Oo O00000oo;
    public boolean O0000O0o = false;
    public Handler O0000OOo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.hpu.AnonymousClass2 */

        public final void handleMessage(Message message) {
            SharedPreferences O00000o0;
            if (message.what == 1) {
                hpu hpu = hpu.this;
                String str = "";
                if (ServiceApplication.getStateNotifier().f15923O000000o == 4 && (O00000o0 = hpu.O00000o0()) != null) {
                    str = O00000o0.getString(CoreApi.O000000o().O0000o0() + "recommend_scene_info_sp", str);
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        hpu.O00000Oo = hqa.O000000o(new JSONObject(str));
                        for (int i = 0; i < hpu.O00000oO.size(); i++) {
                            hpu.O00000oO.get(i).O000000o(2);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                hob.O000000o().O000000o(ServiceApplication.getAppContext(), new fsm<JSONObject, fso>() {
                    /* class _m_j.hpu.AnonymousClass3 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        try {
                            String O0000o0 = CoreApi.O000000o().O0000o0();
                            if (!TextUtils.isEmpty(O0000o0)) {
                                SharedPreferences.Editor edit = hpu.O00000o0().edit();
                                edit.putString(O0000o0 + "recommend_scene_info_sp", jSONObject.toString()).apply();
                            }
                            hpu.this.O00000Oo = hqa.O000000o(jSONObject);
                            hpu.this.O0000O0o = true;
                            for (int i = 0; i < hpu.this.O00000oO.size(); i++) {
                                hpu.this.O00000oO.get(i).O000000o(1);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    public final void onFailure(fso fso) {
                        hpu.this.O0000O0o = false;
                        for (int i = 0; i < hpu.this.O00000oO.size(); i++) {
                            hpu.this.O00000oO.get(i).O000000o();
                        }
                    }
                });
            }
        }
    };
    public WeakReference<MLAlertDialog> O0000Oo;
    hnx O0000Oo0;
    public hnj O0000OoO;
    public boolean O0000Ooo = false;

    public interface O000000o {
        void O000000o();

        void O000000o(int i);
    }

    public interface O00000Oo {
        void O000000o(File file);
    }

    public static hpu O000000o() {
        if (O00000o0 == null) {
            synchronized (hpu.class) {
                if (O00000o0 == null) {
                    O00000o0 = new hpu();
                }
            }
        }
        return O00000o0;
    }

    public static boolean O000000o(String str) {
        return new File(O00000Oo(str)).exists();
    }

    public final void O000000o(String str, O00000Oo o00000Oo) {
        String O00000Oo2 = O00000Oo(str);
        final File file = new File(O00000Oo2);
        if (file.exists()) {
            o00000Oo.O000000o(file);
            return;
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        File externalFilesDir = ServiceApplication.getAppContext().getExternalFilesDir("/recommend_video/");
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        final WeakReference weakReference = new WeakReference(o00000Oo);
        O000000o(str, O00000Oo2, new gof.O00000Oo.O000000o() {
            /* class _m_j.hpu.AnonymousClass1 */

            public final void O000000o() {
                O00000Oo o00000Oo = (O00000Oo) weakReference.get();
                if (o00000Oo != null) {
                    gsy.O00000Oo(hpu.f502O000000o, "downLoadVideo onSuccess");
                    o00000Oo.O000000o(file);
                }
            }

            public final void O00000Oo() {
                if (((O00000Oo) weakReference.get()) != null) {
                    gsy.O00000Oo(hpu.f502O000000o, "downLoadVideo onFailed");
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        });
    }

    private static String O00000Oo(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return ServiceApplication.getAppContext().getExternalFilesDir("/recommend_video/").getPath() + "/" + System.currentTimeMillis() + ".mp4";
            }
            return ServiceApplication.getAppContext().getExternalFilesDir("/recommend_video/").getPath() + "/" + gpp.O000000o(str) + ".mp4";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static void O000000o(String str, String str2, gof.O00000Oo.O000000o o000000o) {
        File file = new File(str2);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        gor.O000000o(new gof.O00000Oo(ServiceApplication.getAppContext(), str, file, o000000o), new Object[0]);
    }

    private hpu() {
    }

    private void O000000o(final List<String> list, final fsm<List<hpy>, fso> fsm) {
        new JsonObject().add("detail", O000000o(list));
        O000000o(list);
        new fsk<List<hpy>>() {
            /* class _m_j.hpu.AnonymousClass5 */
        };
        new Object() {
            /* class _m_j.hpu.AnonymousClass6 */
        };
        if (cmd.O000000o() != null) {
            gsy.O00000Oo("YoupinApiHelper", "sendMijiaShopRequest");
        }
    }

    private static JsonObject O000000o(List<String> list) {
        JsonObject jsonObject = new JsonObject();
        int i = 0;
        while (i < list.size()) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("model", "Shopv2");
            jsonObject2.addProperty("action", "getDetail");
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("gid", list.get(i));
            jsonObject2.add("parameters", jsonObject3);
            StringBuilder sb = new StringBuilder("gid");
            i++;
            sb.append(i);
            jsonObject.add(sb.toString(), jsonObject2);
        }
        return jsonObject;
    }

    public final void O000000o(final Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            final XQProgressDialog xQProgressDialog = new XQProgressDialog(context);
            xQProgressDialog.setMessage(context.getString(R.string.get_data_from_server));
            xQProgressDialog.setCancelable(false);
            xQProgressDialog.show();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.opt(i).toString());
            }
            O000000o().O000000o(arrayList, new fsm<List<hpy>, fso>() {
                /* class _m_j.hpu.AnonymousClass8 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    Context context = context;
                    if ((context instanceof BaseActivity) && ((BaseActivity) context).isValid()) {
                        hpu O000000o2 = hpu.O000000o();
                        Context context2 = context;
                        O000000o2.O0000Oo0 = new hnx(list);
                        MLAlertDialog O00000o = new MLAlertDialog.Builder(context2).O000000o(O000000o2.O0000Oo0, new DialogInterface.OnClickListener(list) {
                            /* class _m_j.hpu.AnonymousClass7 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ List f509O000000o;

                            {
                                this.f509O000000o = r2;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                hjp.O000000o(((hpy) this.f509O000000o.get(i)).O00000o0);
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                            }
                        }).O000000o((int) R.string.smarthome_choose_good_dialog_title).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000o();
                        O000000o2.O0000Oo = new WeakReference<>(O00000o);
                        O00000o.show();
                    }
                    xQProgressDialog.dismiss();
                }

                public final void onFailure(fso fso) {
                    xQProgressDialog.dismiss();
                }
            });
        }
    }

    public static boolean O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str) && O00000Oo(str2, str) <= 0) {
            return false;
        }
        return true;
    }

    private static int O00000Oo(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        String[] split = str.split("[._]");
        String[] split2 = str2.split("[._]");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        while (i < min) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt != parseInt2) {
                    return parseInt - parseInt2;
                }
                i++;
            } catch (Exception e) {
                gnk.O00000Oo(gnk.O00000Oo(e));
                return 0;
            }
        }
        return split.length - split2.length;
    }

    public static String O000000o(Device device) {
        if (device != null && !TextUtils.isEmpty(device.extra)) {
            try {
                JSONObject jSONObject = new JSONObject(device.extra);
                if (jSONObject.has("fw_version")) {
                    return jSONObject.optString("fw_version");
                }
                return "";
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static void O00000Oo() {
        O00000o0 = null;
    }

    static SharedPreferences O00000o0() {
        String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
        if (!TextUtils.isEmpty(O000000o2)) {
            return ServiceApplication.getAppContext().getSharedPreferences("recommend_scene_sp_name_".concat(String.valueOf(O000000o2)), 0);
        }
        return null;
    }
}

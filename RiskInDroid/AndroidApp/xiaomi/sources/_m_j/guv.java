package _m_j;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class guv extends gum {

    public static class O000000o extends gul {

        /* renamed from: O000000o  reason: collision with root package name */
        Device f18320O000000o;
        long O00000Oo;
        private int O00000o;
        private String O00000o0;
        private String O00000oO;

        public O000000o(String str, long j, String str2, String str3, int i) {
            this.f18320O000000o = DeviceFactory.O00000oo(str3, str);
            this.O00000Oo = j;
            this.O00000o0 = str3;
            this.O00000o = i;
            this.O00000oO = str2;
        }

        public final long O000000o() {
            return this.O00000oo.receiveTime;
        }

        public final void O00000oO(TextView textView) {
            String str;
            if (!O00000o(textView)) {
                textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + this.O00000oo.title);
            } else if (O0000OOo() && this.O0000O0o != null) {
                String optString = this.O0000O0o.optString("user_name");
                String optString2 = this.O0000O0o.optString("title");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    String O000000o2 = gqb.O000000o(textView.getContext(), optString, textView.getTextSize(), textView, 5);
                    if (optString2.contains("%s")) {
                        str = optString2.replace("%s", O000000o2);
                    } else {
                        str = O000000o2 + optString2;
                    }
                    textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + str);
                } else if (!TextUtils.isEmpty(optString2)) {
                    textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + optString2);
                }
            }
        }

        public final void O000000o(SimpleDraweeView simpleDraweeView) {
            Device device = this.f18320O000000o;
            if (device != null) {
                DeviceFactory.O000000o(device, simpleDraweeView, new gnz(simpleDraweeView.getResources().getColor(R.color.mj_color_black_30_transparent)));
            } else {
                simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.device_list_phone_no));
            }
        }

        public final void O000000o(TextView textView) {
            Device device;
            if (!O00000o(textView) && (device = this.f18320O000000o) != null) {
                textView.setText(device.name);
            }
        }

        public final void O00000Oo(TextView textView) {
            if (!O0000OOo()) {
                textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + this.O00000oo.content);
            } else if (this.O0000O0o != null && !this.O0000O0o.isNull("content")) {
                textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + this.O0000O0o.optString("content"));
            } else if (this.f18320O000000o != null) {
                textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + this.f18320O000000o.name);
            }
        }

        public final void O00000o0(TextView textView) {
            if (O00000Oo() || !this.O00000oO.equals("share_request")) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            int i = this.O00000o;
            if (i == 1) {
                textView.setText((int) R.string.smarthome_share_accepted);
            } else if (i == 2) {
                textView.setText((int) R.string.smarthome_share_rejected);
            } else {
                textView.setText((int) R.string.smarthome_share_expired);
            }
        }

        public final boolean O00000Oo() {
            String str;
            if (O00000oo() || (str = this.O00000oO) == null || this.O00000o > 0 || !str.equals("share_request")) {
                return false;
            }
            return true;
        }

        public final String O00000o0() {
            if (this.O00000oo == null) {
                return null;
            }
            return this.O00000oo.msgId;
        }

        public final void O000000o(Activity activity) {
            guq.O000000o(O00000o0());
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
         arg types: [java.lang.String, int]
         candidates:
          org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject */
        public final void O00000oO() {
            if (this.O0000O0o != null) {
                try {
                    this.O0000O0o.put("expire_time", 1L);
                    this.O00000oo.params = this.O0000O0o.toString();
                    this.O00000oo.update();
                } catch (JSONException unused) {
                }
            }
        }

        public final void O000000o(final XQProgressDialog xQProgressDialog) {
            fru.O000000o();
            fru.O000000o(ServiceApplication.getAppContext(), "accept", this.O00000oo.msgId, (int) this.O00000Oo, new fsm<Void, fso>() {
                /* class _m_j.guv.O000000o.AnonymousClass1 */

                public final void onFailure(fso fso) {
                    Dialog dialog = xQProgressDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    if (fso.f17063O000000o == -6) {
                        izb.O000000o(ServiceApplication.getAppContext(), (int) R.string.smarthome_share_expired_toast, 0).show();
                        O000000o.this.O00000oO();
                        return;
                    }
                    izb.O000000o(ServiceApplication.getAppContext(), (int) R.string.handle_error, 0).show();
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    MessageRecord.delete(O000000o.this.O00000oo.msgId);
                    Dialog dialog = xQProgressDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    fno.O000000o().O0000Oo0();
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050 A[Catch:{ JSONException -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057 A[Catch:{ JSONException -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f A[Catch:{ JSONException -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067 A[Catch:{ JSONException -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e A[Catch:{ JSONException -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073 A[Catch:{ JSONException -> 0x008d }] */
    public final gul O000000o(MessageRecord messageRecord) {
        String str;
        O000000o o000000o;
        JSONArray optJSONArray;
        String optString;
        MessageRecord messageRecord2 = messageRecord;
        try {
            JSONObject jSONObject = new JSONObject(messageRecord2.params);
            long j = 0;
            if (jSONObject.has("inv_id")) {
                j = jSONObject.optLong("inv_id");
            }
            long j2 = j;
            if (jSONObject.has("did")) {
                optString = jSONObject.optString("did");
            } else if (jSONObject.isNull("dids") || (optJSONArray = jSONObject.optJSONArray("dids")) == null || optJSONArray.length() <= 0) {
                str = null;
                int optInt = !jSONObject.has("status") ? jSONObject.optInt("status") : 0;
                String optString2 = !jSONObject.has("type") ? jSONObject.optString("type", "") : null;
                String optString3 = !jSONObject.has("model") ? jSONObject.optString("model") : null;
                o000000o = new O000000o(optString3, j2, optString2, str, optInt);
                if (o000000o.f18320O000000o != null && CoreApi.O000000o().O00000oO(optString3) == null) {
                    return null;
                }
                o000000o.O00000oo = messageRecord2;
                return o000000o;
            } else {
                optString = optJSONArray.optString(0);
            }
            str = optString;
            if (!jSONObject.has("status")) {
            }
            if (!jSONObject.has("type")) {
            }
            if (!jSONObject.has("model")) {
            }
            o000000o = new O000000o(optString3, j2, optString2, str, optInt);
            try {
                if (o000000o.f18320O000000o != null) {
                }
                o000000o.O00000oo = messageRecord2;
                return o000000o;
            } catch (JSONException unused) {
                return o000000o;
            }
        } catch (JSONException unused2) {
            return null;
        }
    }
}

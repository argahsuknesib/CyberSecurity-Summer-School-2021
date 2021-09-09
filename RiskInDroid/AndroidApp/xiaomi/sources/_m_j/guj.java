package _m_j;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.library.common.dialog.BottomBaseDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.messagecenter.ui.FastConnectFAQActivity;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import org.json.JSONException;
import org.json.JSONObject;

public final class guj extends gum {

    /* renamed from: O000000o  reason: collision with root package name */
    static BottomBaseDialog f18292O000000o;

    public final gul O000000o(MessageRecord messageRecord) {
        return new O000000o(messageRecord);
    }

    public class O000000o extends gul {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18296O000000o;
        public String O00000Oo;
        String O00000o;
        public String O00000o0;
        private JSONObject O0000OOo = null;
        private int O0000Oo = -1;
        private String O0000Oo0;

        public final void O000000o(XQProgressDialog xQProgressDialog) {
        }

        public final boolean O00000Oo() {
            return false;
        }

        public final void O00000o0(TextView textView) {
        }

        public O000000o(MessageRecord messageRecord) {
            this.O00000oo = messageRecord;
            try {
                if (!TextUtils.isEmpty(messageRecord.params)) {
                    JSONObject jSONObject = new JSONObject(messageRecord.params);
                    if (!jSONObject.isNull("body")) {
                        this.O0000OOo = jSONObject.getJSONObject("body");
                        if (this.O0000OOo != null) {
                            this.f18296O000000o = this.O0000OOo.optString("router_model", "");
                            this.O00000Oo = this.O0000OOo.optString("router_id", "");
                            this.O00000o0 = this.O0000OOo.optString("device_id", "");
                            this.O00000o = this.O0000OOo.optString("device_model", "");
                            this.O0000Oo = this.O0000OOo.optInt("status", -1);
                            JSONObject jSONObject2 = this.O0000OOo.getJSONObject("home");
                            if (jSONObject2 != null) {
                                String optString = jSONObject2.optString("homeName", "");
                                String optString2 = jSONObject2.optString("roomName", "");
                                optString2 = TextUtils.isEmpty(optString2) ? ServiceApplication.getAppContext().getString(R.string.default_room) : optString2;
                                if (optString != null && optString2 != null) {
                                    this.O0000Oo0 = String.format("%s-%s", optString2, optString);
                                }
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public final void O000000o(SimpleDraweeView simpleDraweeView) {
            DeviceFactory.O00000Oo(this.f18296O000000o, simpleDraweeView);
        }

        public final void O000000o(final TextView textView) {
            SpannableString spannableString;
            if (this.O0000Oo == 0) {
                String str = this.O00000oo.content;
                String string = ServiceApplication.getAppContext().getString(R.string.watch_fast_connect_faq);
                final AnonymousClass1 r2 = new View.OnClickListener() {
                    /* class _m_j.guj.O000000o.AnonymousClass1 */

                    public final void onClick(View view) {
                        FastConnectFAQActivity.invokeResultActivity((Activity) textView.getContext(), O000000o.this.O00000o0, O000000o.this.O00000Oo, 145);
                    }
                };
                if (TextUtils.isEmpty(string)) {
                    spannableString = new SpannableString(str);
                } else {
                    int length = str.length();
                    spannableString = new SpannableString(String.valueOf(str) + String.valueOf(string));
                    spannableString.setSpan(new hwy(Color.parseColor("#628CF6"), Color.parseColor("#A00000FF")) {
                        /* class _m_j.guj.O000000o.AnonymousClass2 */

                        public final void O000000o(View view) {
                            r2.onClick(view);
                        }
                    }, length, string.length() + length, 17);
                }
                textView.setText(spannableString);
                return;
            }
            textView.setText(this.O00000oo.content);
        }

        public final void O00000Oo(TextView textView) {
            if (this.O0000Oo0 == null) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(this.O0000Oo0);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
         arg types: [java.lang.String, int]
         candidates:
          _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
          _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
        public final void O000000o(Activity activity) {
            gsy.O00000Oo("wugan", String.format("fast connect message click, device_did=%s,device_model=%s,router_did=%s,router_model=%s,status=%d", this.O00000o0, this.O00000o, this.O00000Oo, this.f18296O000000o, Integer.valueOf(this.O0000Oo)));
            int i = this.O0000Oo;
            if (i == 2) {
                if (ggb.O00000Oo().O0000o00(this.O00000o0) != null) {
                    Intent intent = new Intent();
                    Device O000000o2 = fno.O000000o().O000000o(this.O00000o0);
                    PluginApi.getInstance().sendMessage(activity, this.O00000o, 1, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O000000o2), null, false, new SendMessageCallback() {
                        /* class _m_j.guj.O000000o.AnonymousClass3 */
                    });
                } else if (activity != null) {
                    fbs.O000000o(new fbt(activity, "initDeviceRoomActivity").O000000o("device_id", this.O00000o0));
                }
            } else if (i == 3) {
                fbs.O000000o(new fbt(activity, "ResetDevicePage").O000000o("model", this.O00000o).O000000o("from_miui", false));
            }
        }

        public final boolean O00000o(TextView textView) {
            textView.setText(String.format("%s | %s", gou.O000000o(this.O00000oo.receiveTime * 1000), this.O00000oo.content));
            return true;
        }

        public final long O000000o() {
            return this.O00000oo.receiveTime;
        }

        public final String O00000o0() {
            return this.O00000oo.msgId;
        }
    }

    public static void O000000o(String str) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 != null) {
            O000000o2.scrollTo = true;
            O000000o2.isNew = true;
            fno.O000000o().O0000Oo0(O000000o2.did);
        }
    }

    public static void O000000o(final Activity activity, final O000000o o000000o) {
        gsy.O00000o0(LogType.KUAILIAN, "wugan", "alert wugan config sussess dialog");
        AnonymousClass1 r0 = new BottomBaseDialog(activity) {
            /* class _m_j.guj.AnonymousClass1 */

            public final View O000000o() {
                View inflate = LayoutInflater.from(activity).inflate((int) R.layout.dialog_fast_connect_success, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_device_name)).setText(DeviceFactory.O0000OoO(o000000o.O00000o));
                DeviceFactory.O00000Oo(o000000o.O00000o, (SimpleDraweeView) inflate.findViewById(R.id.device_img));
                if (!TextUtils.isEmpty(o000000o.O00000o0)) {
                    guj.O000000o(o000000o.O00000o0);
                }
                ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.guj.AnonymousClass1.AnonymousClass1 */

                    public final void onClick(View view) {
                        if (guj.f18292O000000o != null) {
                            guj.f18292O000000o.dismiss();
                            guj.f18292O000000o = null;
                        }
                    }
                });
                ((TextView) inflate.findViewById(R.id.tv_ok)).setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.guj.AnonymousClass1.AnonymousClass2 */

                    public final void onClick(View view) {
                        if (guj.f18292O000000o != null) {
                            guj.f18292O000000o.dismiss();
                            guj.f18292O000000o = null;
                        }
                        o000000o.O000000o(activity);
                    }
                });
                return inflate;
            }
        };
        f18292O000000o = r0;
        r0.show();
    }
}

package _m_j;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.push.PushType;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import org.json.JSONException;
import org.json.JSONObject;

public final class guh extends gum {

    public class O000000o extends gul {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18285O000000o;
        public String O00000Oo;
        public long O00000o0;
        private String O00000oO;
        private Device O0000OOo;
        private long O0000Oo;
        private String O0000Oo0;
        private long O0000OoO;
        private String O0000Ooo;
        private String O0000o00;

        public final void O000000o(XQProgressDialog xQProgressDialog) {
        }

        public final boolean O00000Oo() {
            return false;
        }

        public O000000o() {
        }

        public final void O000000o(MessageRecord messageRecord, String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, String str6) {
            this.O0000OOo = DeviceFactory.O00000oo(str2, str);
            this.O00000oo = messageRecord;
            this.f18285O000000o = str;
            this.O00000Oo = str2;
            this.O0000Oo0 = str3;
            this.O0000Oo = j;
            this.O0000Ooo = str4;
            this.O0000o00 = str5;
            this.O00000oO = str6;
            this.O00000o0 = j2;
            this.O0000OoO = j3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6  */
        public final void O000000o(final Activity activity, boolean z) {
            JSONObject jSONObject;
            Device device;
            PluginDeviceInfo O00000oO2;
            guq.O000000o(O00000o0());
            try {
                jSONObject = new JSONObject(this.O00000oO);
                String optString = jSONObject.optString("event");
                if (!TextUtils.isEmpty(optString) && "voicecall".equals(optString)) {
                    jSONObject.put("event", "voicecall_msgcenter");
                }
            } catch (Exception unused) {
                jSONObject = null;
            }
            String str = this.O00000oO;
            if (jSONObject != null) {
                str = jSONObject.toString();
            }
            String str2 = this.f18285O000000o;
            try {
                device = fno.O000000o().O000000o(new JSONObject(str).optString("did"));
                try {
                    if ("mxiang.camera.mwc11".equals(this.f18285O000000o)) {
                        str2 = "mxiang.camera.mwc10";
                        device = device != null ? fno.O000000o().O000000o(device.parentId) : null;
                    }
                    if (device == null) {
                        Home O00000o2 = ggb.O00000Oo().O00000o(String.valueOf(this.O00000o0));
                        if (z && O00000o2 != null) {
                            if (!O00000o2.isOwner()) {
                                final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(activity, activity.getString(R.string.loading_data) + activity.getString(R.string.plugin));
                                O000000o2.show();
                                ggw.O000000o().O000000o(this.O00000o0, new fsm() {
                                    /* class _m_j.guh.O000000o.AnonymousClass1 */

                                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                     method: _m_j.guh.O000000o.O000000o(android.app.Activity, boolean):void
                                     arg types: [android.app.Activity, int]
                                     candidates:
                                      _m_j.gul.O000000o(android.widget.TextView, java.lang.String):boolean
                                      _m_j.guh.O000000o.O000000o(android.app.Activity, boolean):void */
                                    public final void onSuccess(Object obj) {
                                        if (!activity.isFinishing() && !activity.isDestroyed()) {
                                            O000000o2.dismiss();
                                            O000000o.this.O000000o(activity, false);
                                        }
                                    }

                                    public final void onFailure(fso fso) {
                                        if (!activity.isFinishing() && !activity.isDestroyed()) {
                                            O000000o2.dismiss();
                                            hte.O000000o(ServiceApplication.getAppContext(), (int) R.string.loading_failed);
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        hte.O000000o(ServiceApplication.getAppContext(), (int) R.string.device_out_of_date);
                        return;
                    }
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    O00000oO2 = CoreApi.O000000o().O00000oO(str2);
                    if (O00000oO2 == null) {
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                device = null;
                e.printStackTrace();
                O00000oO2 = CoreApi.O000000o().O00000oO(str2);
                if (O00000oO2 == null) {
                }
            }
            O00000oO2 = CoreApi.O000000o().O00000oO(str2);
            if (O00000oO2 == null) {
                ezo.O000000o().dispatchMessage("", str, false);
            } else {
                guh.O000000o(activity, str, O00000oO2, device, null);
            }
        }

        public final boolean O00000o() {
            if (this.O00000oo == null || TextUtils.isEmpty(this.O00000oo.is_new) || this.O00000oo.receiveTime < 1479106800 || !TextUtils.equals(this.O00000oo.is_new, "1")) {
                return false;
            }
            if (TextUtils.equals(this.O00000oo.messageType, "6")) {
                return gui.O000000o(this.O00000Oo, this.O00000oo.receiveTime);
            }
            return true;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.guh.O000000o.O000000o(android.app.Activity, boolean):void
         arg types: [android.app.Activity, int]
         candidates:
          _m_j.gul.O000000o(android.widget.TextView, java.lang.String):boolean
          _m_j.guh.O000000o.O000000o(android.app.Activity, boolean):void */
        public final void O000000o(Activity activity) {
            O000000o(activity, true);
        }

        public final long O000000o() {
            return this.O00000oo.receiveTime;
        }

        public final void O000000o(SimpleDraweeView simpleDraweeView) {
            Device device = this.O0000OOo;
            if (device != null) {
                DeviceFactory.O000000o(device, simpleDraweeView, new gnz(simpleDraweeView.getResources().getColor(R.color.mj_color_black_30_transparent)));
            } else if (TextUtils.isEmpty(this.O00000oo.img_url) || this.O00000oo.img_url.equals("0")) {
                simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.device_list_phone_no));
            } else {
                gyl.O000000o();
                gyl.O00000Oo(this.O00000oo.img_url, simpleDraweeView, new gnz(simpleDraweeView.getResources().getColor(R.color.mj_color_black_30_transparent)));
            }
        }

        public final void O000000o(TextView textView) {
            if (!O00000o(textView)) {
                textView.setText(this.O00000oo.title);
            }
        }

        public final void O00000Oo(TextView textView) {
            if (!O0000OOo()) {
                textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + this.O00000oo.content);
            } else if (this.O0000O0o == null || this.O0000O0o.isNull("content")) {
                textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + this.O00000oo.title);
            } else {
                textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + this.O0000O0o.optString("content"));
            }
        }

        public final void O00000o0(TextView textView) {
            if (textView != null) {
                textView.setVisibility(8);
            }
        }

        public final String O00000o0() {
            if (this.O00000oo == null) {
                return null;
            }
            return this.O00000oo.msgId;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c3  */
    public static void O000000o(Activity activity, String str, PluginDeviceInfo pluginDeviceInfo, Device device, SendMessageCallback sendMessageCallback) {
        Intent intent;
        Intent intent2;
        Activity activity2 = activity;
        Device device2 = device;
        XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(activity2, activity2.getString(R.string.plugin_downloading) + pluginDeviceInfo.O0000Oo0() + activity2.getString(R.string.plugin));
        PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
        boolean z = CoreApi.O000000o().O0000Oo(device2.model) == null && CoreApi.O000000o().O0000OoO(device2.model) == null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("did");
            String optString2 = jSONObject.optString("event");
            long optLong = jSONObject.optLong("time");
            String optString3 = jSONObject.optString("extra");
            String optString4 = jSONObject.optString("from_where");
            if (!TextUtils.isEmpty(optString2) || !TextUtils.isEmpty(optString3)) {
                Intent intent3 = new Intent();
                intent3.putExtra("did", optString);
                intent3.putExtra("event", optString2);
                intent3.putExtra("time", optLong);
                intent3.putExtra("extra", optString3);
                intent3.putExtra("isNotified", false);
                intent3.putExtra("type", "ScenePush");
                intent = intent3;
            } else {
                intent = null;
            }
            if (intent != null) {
                try {
                    if (!TextUtils.isEmpty(optString4)) {
                        intent.putExtra("from_where", optString4);
                    }
                } catch (JSONException e) {
                    e = e;
                    intent2 = intent;
                    e.printStackTrace();
                    intent = intent2;
                    final PluginDownloadTask pluginDownloadTask2 = pluginDownloadTask;
                    final Activity activity3 = activity;
                    final XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    final PluginDeviceInfo pluginDeviceInfo2 = pluginDeviceInfo;
                    final SendMessageCallback sendMessageCallback2 = sendMessageCallback;
                    final boolean z2 = z;
                    PluginApi.getInstance().sendMessage(activity, pluginDeviceInfo.O00000Oo(), intent == null ? 1 : 2, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device2), null, false, new SendMessageCallback() {
                        /* class _m_j.guh.AnonymousClass1 */

                        public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                            pluginDownloadTask.O000000o(pluginDownloadTask2);
                            if (!activity3.isFinishing()) {
                                if (Build.VERSION.SDK_INT < 17 || !activity3.isDestroyed()) {
                                    XQProgressHorizontalDialog xQProgressHorizontalDialog = xQProgressHorizontalDialog;
                                    if (xQProgressHorizontalDialog != null) {
                                        xQProgressHorizontalDialog.O000000o(100, 0);
                                        XQProgressHorizontalDialog xQProgressHorizontalDialog2 = xQProgressHorizontalDialog;
                                        xQProgressHorizontalDialog2.f9117O000000o = false;
                                        xQProgressHorizontalDialog2.setCancelable(true);
                                        xQProgressHorizontalDialog.show();
                                        xQProgressHorizontalDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                            /* class _m_j.guh.AnonymousClass1.AnonymousClass1 */

                                            public final void onCancel(DialogInterface dialogInterface) {
                                                CoreApi.O000000o().O000000o(pluginDeviceInfo2.O00000Oo(), pluginDownloadTask2);
                                            }
                                        });
                                    }
                                    SendMessageCallback sendMessageCallback = sendMessageCallback2;
                                    if (sendMessageCallback != null) {
                                        sendMessageCallback.onDownloadStart(str, pluginDownloadTask);
                                    }
                                }
                            }
                        }

                        public final void onDownloadProgress(String str, float f) {
                            if (z2) {
                                int i = (int) (100.0f * f);
                                if (i >= 99) {
                                    i = 99;
                                }
                                XQProgressHorizontalDialog xQProgressHorizontalDialog = xQProgressHorizontalDialog;
                                if (xQProgressHorizontalDialog != null) {
                                    xQProgressHorizontalDialog.O000000o(100, i);
                                }
                            } else {
                                XQProgressHorizontalDialog xQProgressHorizontalDialog2 = xQProgressHorizontalDialog;
                                if (xQProgressHorizontalDialog2 != null) {
                                    xQProgressHorizontalDialog2.O000000o(100, (int) (100.0f * f));
                                }
                            }
                            SendMessageCallback sendMessageCallback = sendMessageCallback2;
                            if (sendMessageCallback != null) {
                                sendMessageCallback.onDownloadProgress(str, f);
                            }
                        }

                        public final void onDownloadSuccess(String str) {
                            XQProgressHorizontalDialog xQProgressHorizontalDialog;
                            if (!z2 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog) != null) {
                                xQProgressHorizontalDialog.dismiss();
                            }
                            SendMessageCallback sendMessageCallback = sendMessageCallback2;
                            if (sendMessageCallback != null) {
                                sendMessageCallback.onDownloadSuccess(str);
                            }
                        }

                        public final void onDownloadFailure(PluginError pluginError) {
                            XQProgressHorizontalDialog xQProgressHorizontalDialog;
                            if (!z2 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog) != null) {
                                xQProgressHorizontalDialog.dismiss();
                            }
                            SendMessageCallback sendMessageCallback = sendMessageCallback2;
                            if (sendMessageCallback != null) {
                                sendMessageCallback.onDownloadFailure(pluginError);
                            }
                        }

                        public final void onDownloadCancel() {
                            XQProgressHorizontalDialog xQProgressHorizontalDialog;
                            if (!z2 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog) != null) {
                                xQProgressHorizontalDialog.dismiss();
                            }
                            SendMessageCallback sendMessageCallback = sendMessageCallback2;
                            if (sendMessageCallback != null) {
                                sendMessageCallback.onDownloadCancel();
                            }
                        }

                        public final void onSendSuccess(Bundle bundle) {
                            XQProgressHorizontalDialog xQProgressHorizontalDialog;
                            if (z2 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog) != null) {
                                xQProgressHorizontalDialog.dismiss();
                            }
                            SendMessageCallback sendMessageCallback = sendMessageCallback2;
                            if (sendMessageCallback != null) {
                                sendMessageCallback.onSendSuccess(bundle);
                            }
                        }

                        public final void onSendFailure(fso fso) {
                            XQProgressHorizontalDialog xQProgressHorizontalDialog;
                            if (z2 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog) != null) {
                                xQProgressHorizontalDialog.dismiss();
                            }
                            SendMessageCallback sendMessageCallback = sendMessageCallback2;
                            if (sendMessageCallback != null) {
                                sendMessageCallback.onSendFailure(fso);
                            }
                        }

                        public final void onSendCancel() {
                            XQProgressHorizontalDialog xQProgressHorizontalDialog;
                            if (z2 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog) != null) {
                                xQProgressHorizontalDialog.dismiss();
                            }
                            SendMessageCallback sendMessageCallback = sendMessageCallback2;
                            if (sendMessageCallback != null) {
                                sendMessageCallback.onSendCancel();
                            }
                        }
                    });
                }
            }
        } catch (JSONException e2) {
            e = e2;
            intent2 = null;
            e.printStackTrace();
            intent = intent2;
            final PluginDownloadTask pluginDownloadTask22 = pluginDownloadTask;
            final Activity activity32 = activity;
            final XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
            final PluginDeviceInfo pluginDeviceInfo22 = pluginDeviceInfo;
            final SendMessageCallback sendMessageCallback22 = sendMessageCallback;
            final boolean z22 = z;
            PluginApi.getInstance().sendMessage(activity, pluginDeviceInfo.O00000Oo(), intent == null ? 1 : 2, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device2), null, false, new SendMessageCallback() {
                /* class _m_j.guh.AnonymousClass1 */

                public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                    pluginDownloadTask.O000000o(pluginDownloadTask22);
                    if (!activity32.isFinishing()) {
                        if (Build.VERSION.SDK_INT < 17 || !activity32.isDestroyed()) {
                            XQProgressHorizontalDialog xQProgressHorizontalDialog = xQProgressHorizontalDialog2;
                            if (xQProgressHorizontalDialog != null) {
                                xQProgressHorizontalDialog.O000000o(100, 0);
                                XQProgressHorizontalDialog xQProgressHorizontalDialog2 = xQProgressHorizontalDialog2;
                                xQProgressHorizontalDialog2.f9117O000000o = false;
                                xQProgressHorizontalDialog2.setCancelable(true);
                                xQProgressHorizontalDialog2.show();
                                xQProgressHorizontalDialog2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                    /* class _m_j.guh.AnonymousClass1.AnonymousClass1 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        CoreApi.O000000o().O000000o(pluginDeviceInfo22.O00000Oo(), pluginDownloadTask22);
                                    }
                                });
                            }
                            SendMessageCallback sendMessageCallback = sendMessageCallback22;
                            if (sendMessageCallback != null) {
                                sendMessageCallback.onDownloadStart(str, pluginDownloadTask);
                            }
                        }
                    }
                }

                public final void onDownloadProgress(String str, float f) {
                    if (z22) {
                        int i = (int) (100.0f * f);
                        if (i >= 99) {
                            i = 99;
                        }
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = xQProgressHorizontalDialog2;
                        if (xQProgressHorizontalDialog != null) {
                            xQProgressHorizontalDialog.O000000o(100, i);
                        }
                    } else {
                        XQProgressHorizontalDialog xQProgressHorizontalDialog2 = xQProgressHorizontalDialog2;
                        if (xQProgressHorizontalDialog2 != null) {
                            xQProgressHorizontalDialog2.O000000o(100, (int) (100.0f * f));
                        }
                    }
                    SendMessageCallback sendMessageCallback = sendMessageCallback22;
                    if (sendMessageCallback != null) {
                        sendMessageCallback.onDownloadProgress(str, f);
                    }
                }

                public final void onDownloadSuccess(String str) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (!z22 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    SendMessageCallback sendMessageCallback = sendMessageCallback22;
                    if (sendMessageCallback != null) {
                        sendMessageCallback.onDownloadSuccess(str);
                    }
                }

                public final void onDownloadFailure(PluginError pluginError) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (!z22 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    SendMessageCallback sendMessageCallback = sendMessageCallback22;
                    if (sendMessageCallback != null) {
                        sendMessageCallback.onDownloadFailure(pluginError);
                    }
                }

                public final void onDownloadCancel() {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (!z22 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    SendMessageCallback sendMessageCallback = sendMessageCallback22;
                    if (sendMessageCallback != null) {
                        sendMessageCallback.onDownloadCancel();
                    }
                }

                public final void onSendSuccess(Bundle bundle) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (z22 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    SendMessageCallback sendMessageCallback = sendMessageCallback22;
                    if (sendMessageCallback != null) {
                        sendMessageCallback.onSendSuccess(bundle);
                    }
                }

                public final void onSendFailure(fso fso) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (z22 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    SendMessageCallback sendMessageCallback = sendMessageCallback22;
                    if (sendMessageCallback != null) {
                        sendMessageCallback.onSendFailure(fso);
                    }
                }

                public final void onSendCancel() {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (z22 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    SendMessageCallback sendMessageCallback = sendMessageCallback22;
                    if (sendMessageCallback != null) {
                        sendMessageCallback.onSendCancel();
                    }
                }
            });
        }
        final PluginDownloadTask pluginDownloadTask222 = pluginDownloadTask;
        final Activity activity322 = activity;
        final XQProgressHorizontalDialog xQProgressHorizontalDialog22 = O000000o2;
        final PluginDeviceInfo pluginDeviceInfo222 = pluginDeviceInfo;
        final SendMessageCallback sendMessageCallback222 = sendMessageCallback;
        final boolean z222 = z;
        PluginApi.getInstance().sendMessage(activity, pluginDeviceInfo.O00000Oo(), intent == null ? 1 : 2, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device2), null, false, new SendMessageCallback() {
            /* class _m_j.guh.AnonymousClass1 */

            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                pluginDownloadTask.O000000o(pluginDownloadTask222);
                if (!activity322.isFinishing()) {
                    if (Build.VERSION.SDK_INT < 17 || !activity322.isDestroyed()) {
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = xQProgressHorizontalDialog22;
                        if (xQProgressHorizontalDialog != null) {
                            xQProgressHorizontalDialog.O000000o(100, 0);
                            XQProgressHorizontalDialog xQProgressHorizontalDialog2 = xQProgressHorizontalDialog22;
                            xQProgressHorizontalDialog2.f9117O000000o = false;
                            xQProgressHorizontalDialog2.setCancelable(true);
                            xQProgressHorizontalDialog22.show();
                            xQProgressHorizontalDialog22.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                /* class _m_j.guh.AnonymousClass1.AnonymousClass1 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    CoreApi.O000000o().O000000o(pluginDeviceInfo222.O00000Oo(), pluginDownloadTask222);
                                }
                            });
                        }
                        SendMessageCallback sendMessageCallback = sendMessageCallback222;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onDownloadStart(str, pluginDownloadTask);
                        }
                    }
                }
            }

            public final void onDownloadProgress(String str, float f) {
                if (z222) {
                    int i = (int) (100.0f * f);
                    if (i >= 99) {
                        i = 99;
                    }
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = xQProgressHorizontalDialog22;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.O000000o(100, i);
                    }
                } else {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog2 = xQProgressHorizontalDialog22;
                    if (xQProgressHorizontalDialog2 != null) {
                        xQProgressHorizontalDialog2.O000000o(100, (int) (100.0f * f));
                    }
                }
                SendMessageCallback sendMessageCallback = sendMessageCallback222;
                if (sendMessageCallback != null) {
                    sendMessageCallback.onDownloadProgress(str, f);
                }
            }

            public final void onDownloadSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (!z222 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog22) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
                SendMessageCallback sendMessageCallback = sendMessageCallback222;
                if (sendMessageCallback != null) {
                    sendMessageCallback.onDownloadSuccess(str);
                }
            }

            public final void onDownloadFailure(PluginError pluginError) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (!z222 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog22) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
                SendMessageCallback sendMessageCallback = sendMessageCallback222;
                if (sendMessageCallback != null) {
                    sendMessageCallback.onDownloadFailure(pluginError);
                }
            }

            public final void onDownloadCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (!z222 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog22) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
                SendMessageCallback sendMessageCallback = sendMessageCallback222;
                if (sendMessageCallback != null) {
                    sendMessageCallback.onDownloadCancel();
                }
            }

            public final void onSendSuccess(Bundle bundle) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (z222 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog22) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
                SendMessageCallback sendMessageCallback = sendMessageCallback222;
                if (sendMessageCallback != null) {
                    sendMessageCallback.onSendSuccess(bundle);
                }
            }

            public final void onSendFailure(fso fso) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (z222 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog22) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
                SendMessageCallback sendMessageCallback = sendMessageCallback222;
                if (sendMessageCallback != null) {
                    sendMessageCallback.onSendFailure(fso);
                }
            }

            public final void onSendCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (z222 && (xQProgressHorizontalDialog = xQProgressHorizontalDialog22) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
                SendMessageCallback sendMessageCallback = sendMessageCallback222;
                if (sendMessageCallback != null) {
                    sendMessageCallback.onSendCancel();
                }
            }
        });
    }

    public final gul O000000o(MessageRecord messageRecord) {
        O000000o o000000o;
        O000000o o000000o2;
        MessageRecord messageRecord2 = messageRecord;
        try {
            JSONObject jSONObject = new JSONObject(messageRecord2.params);
            if (PushType.INNER_JUMP.getValue().equals(jSONObject.optString("type"))) {
                o000000o = new O000000o();
                try {
                    String optString = jSONObject.optString("body");
                    if (TextUtils.isEmpty(optString)) {
                        return null;
                    }
                    Uri parse = Uri.parse(new JSONObject(optString).optString("url"));
                    String queryParameter = parse.getQueryParameter("device_model");
                    String queryParameter2 = parse.getQueryParameter("device_id");
                    long j = messageRecord2.receiveTime;
                    long j2 = messageRecord2.homeId;
                    long j3 = messageRecord2.homeOwner;
                    O000000o o000000o3 = o000000o;
                    String str = messageRecord2.params;
                    String str2 = optString;
                    String str3 = str;
                    O000000o o000000o4 = o000000o;
                    try {
                        o000000o3.O000000o(messageRecord, queryParameter, queryParameter2, "", j, "", j2, j3, str3, str2);
                        return o000000o4;
                    } catch (JSONException e) {
                        e = e;
                        o000000o = o000000o4;
                        Log.e("DevicePushMessage", "fatal", e);
                        return o000000o;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    Log.e("DevicePushMessage", "fatal", e);
                    return o000000o;
                }
            } else {
                String optString2 = jSONObject.optString("body");
                if (TextUtils.isEmpty(optString2)) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject(optString2);
                String optString3 = jSONObject2.optString("model");
                String optString4 = jSONObject2.optString("did");
                String optString5 = jSONObject2.optString("event");
                long optLong = jSONObject2.optLong("time");
                String optString6 = jSONObject2.optString("extra");
                long j4 = messageRecord2.homeId;
                long j5 = messageRecord2.homeOwner;
                O000000o o000000o5 = new O000000o();
                try {
                    o000000o2 = o000000o5;
                } catch (JSONException e3) {
                    e = e3;
                    o000000o2 = o000000o5;
                    o000000o = o000000o2;
                    Log.e("DevicePushMessage", "fatal", e);
                    return o000000o;
                }
                try {
                    o000000o5.O000000o(messageRecord, optString3, optString4, optString5, optLong, optString6, j4, j5, messageRecord2.params, optString2);
                    return o000000o2;
                } catch (JSONException e4) {
                    e = e4;
                    o000000o = o000000o2;
                    Log.e("DevicePushMessage", "fatal", e);
                    return o000000o;
                }
            }
        } catch (JSONException e5) {
            e = e5;
            o000000o = null;
            Log.e("DevicePushMessage", "fatal", e);
            return o000000o;
        }
    }
}

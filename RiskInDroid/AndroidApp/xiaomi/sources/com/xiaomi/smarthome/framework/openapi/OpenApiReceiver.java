package com.xiaomi.smarthome.framework.openapi;

import _m_j.ezq;
import _m_j.ezt;
import _m_j.fkw;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fvj;
import _m_j.gfr;
import _m_j.gsy;
import _m_j.izb;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.plugin.DownloadPluginDebugPackageResult;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class OpenApiReceiver extends BroadcastReceiver {
    public void onReceive(final Context context, final Intent intent) {
        ezt.O000000o().startCheck(new ezq() {
            /* class com.xiaomi.smarthome.framework.openapi.OpenApiReceiver.AnonymousClass1 */

            public final void O000000o() {
            }

            public final void O00000Oo() {
            }

            public final void O00000o0() {
                OpenApiReceiver openApiReceiver = OpenApiReceiver.this;
                Context context = context;
                Intent intent = intent;
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    if (action.equals("com.xiaomi.smarthome.action.OPEN_API")) {
                        String stringExtra = intent.getStringExtra("type");
                        String stringExtra2 = intent.getStringExtra("sub_type");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            if (!TextUtils.isEmpty(stringExtra2) && stringExtra.equalsIgnoreCase("plugin_debug")) {
                                if (gfr.O0000OOo || gfr.O0000Oo) {
                                    try {
                                        if (stringExtra2.equalsIgnoreCase("install_debug_package")) {
                                            return;
                                        }
                                        if (stringExtra2.equalsIgnoreCase("debug_package")) {
                                            CoreApi O000000o2 = CoreApi.O000000o();
                                            try {
                                                O000000o2.O00000Oo().debugPluginPackage(new IClientCallback.Stub(new CoreApi.O00000o0() {
                                                    /* class com.xiaomi.smarthome.framework.openapi.OpenApiReceiver.AnonymousClass2 */

                                                    public final void O000000o() {
                                                        izb.O000000o(CommonApplication.getAppContext(), "从SD卡读取成功", 0).show();
                                                    }

                                                    public final void O000000o(String str) {
                                                        izb.O000000o(CommonApplication.getAppContext(), "从SD卡读取失败:".concat(String.valueOf(str)), 0).show();
                                                    }

                                                    public final void O00000Oo() {
                                                        izb.O000000o(CommonApplication.getAppContext(), "安装成功", 0).show();
                                                    }

                                                    public final void O00000Oo(String str) {
                                                        izb.O000000o(CommonApplication.getAppContext(), "安装失败:".concat(String.valueOf(str)), 0).show();
                                                    }

                                                    public final void O00000o0(String str) {
                                                        izb.O000000o(CommonApplication.getAppContext(), "失败:".concat(String.valueOf(str)), 0).show();
                                                    }
                                                }, new Handler(Looper.getMainLooper())) {
                                                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass58 */
                                                    final /* synthetic */ O00000o0 val$callback;
                                                    final /* synthetic */ Handler val$uiHandler;

                                                    {
                                                        this.val$callback = r2;
                                                        this.val$uiHandler = r3;
                                                    }

                                                    public void onSuccess(Bundle bundle) {
                                                        if (this.val$callback != null) {
                                                            bundle.setClassLoader(DownloadPluginDebugPackageResult.class.getClassLoader());
                                                            final DownloadPluginDebugPackageResult downloadPluginDebugPackageResult = (DownloadPluginDebugPackageResult) bundle.getParcelable("result");
                                                            if (downloadPluginDebugPackageResult.f6732O000000o == 1) {
                                                                this.val$uiHandler.post(new Runnable() {
                                                                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass58.AnonymousClass1 */

                                                                    public final void run() {
                                                                        AnonymousClass58.this.val$callback.O000000o();
                                                                    }
                                                                });
                                                            } else if (downloadPluginDebugPackageResult.f6732O000000o == 2) {
                                                                this.val$uiHandler.post(new Runnable() {
                                                                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass58.AnonymousClass2 */

                                                                    public final void run() {
                                                                        AnonymousClass58.this.val$callback.O000000o(downloadPluginDebugPackageResult.O00000Oo);
                                                                    }
                                                                });
                                                            } else if (downloadPluginDebugPackageResult.f6732O000000o == 3) {
                                                                this.val$uiHandler.post(new Runnable() {
                                                                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass58.AnonymousClass3 */

                                                                    public final void run() {
                                                                        AnonymousClass58.this.val$callback.O00000Oo();
                                                                    }
                                                                });
                                                            } else if (downloadPluginDebugPackageResult.f6732O000000o == 4) {
                                                                this.val$uiHandler.post(new Runnable() {
                                                                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass58.AnonymousClass4 */

                                                                    public final void run() {
                                                                        AnonymousClass58.this.val$callback.O00000Oo(downloadPluginDebugPackageResult.O00000Oo);
                                                                    }
                                                                });
                                                            }
                                                        }
                                                    }

                                                    public void onFailure(Bundle bundle) {
                                                        bundle.setClassLoader(Error.class.getClassLoader());
                                                        PluginError pluginError = (PluginError) bundle.getParcelable("error");
                                                        O00000o0 o00000o0 = this.val$callback;
                                                        if (o00000o0 != null) {
                                                            o00000o0.O00000o0(pluginError.O00000Oo);
                                                        }
                                                    }
                                                });
                                                return;
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                                return;
                                            }
                                        } else if (stringExtra2.equalsIgnoreCase("dump_plugin")) {
                                            CoreApi O000000o3 = CoreApi.O000000o();
                                            try {
                                                O000000o3.O00000Oo().dumpPlugin(new IClientCallback.Stub(new fsm<Void, fso>() {
                                                    /* class com.xiaomi.smarthome.framework.openapi.OpenApiReceiver.AnonymousClass3 */

                                                    public final void onFailure(fso fso) {
                                                    }

                                                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                                    }
                                                }) {
                                                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass59 */
                                                    final /* synthetic */ fsm val$callback;

                                                    {
                                                        this.val$callback = r2;
                                                    }

                                                    public void onSuccess(Bundle bundle) {
                                                        fsm fsm = this.val$callback;
                                                        if (fsm != null) {
                                                            fsm.sendSuccessMessage(null);
                                                        }
                                                    }

                                                    public void onFailure(Bundle bundle) {
                                                        fsm fsm = this.val$callback;
                                                        if (fsm != null) {
                                                            fsm.sendFailureMessage(new fso(-1, ""));
                                                        }
                                                    }
                                                });
                                                return;
                                            } catch (Throwable th2) {
                                                th2.printStackTrace();
                                                return;
                                            }
                                        } else if (stringExtra2.equalsIgnoreCase("send_message")) {
                                            String stringExtra3 = intent.getStringExtra("model");
                                            String stringExtra4 = intent.getStringExtra("did");
                                            if (!CoreApi.O000000o().O00000o(stringExtra3)) {
                                                izb.O000000o(CommonApplication.getAppContext(), "不是插件", 0).show();
                                                return;
                                            }
                                            Device O000000o4 = fno.O000000o().O000000o(stringExtra4);
                                            if (O000000o4 == null) {
                                                O000000o4 = fno.O000000o().O00000Oo(stringExtra4);
                                            }
                                            if (O000000o4 == null) {
                                                izb.O000000o(CommonApplication.getAppContext(), "无此设备", 0).show();
                                                return;
                                            }
                                            Intent intent2 = new Intent();
                                            PluginApi.getInstance().sendMessage(context, stringExtra3, 1, intent2, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O000000o4), null, false, null);
                                            return;
                                        } else if (stringExtra2.equalsIgnoreCase("device_list")) {
                                            Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
                                            Map<String, Device> O00000Oo2 = fno.O000000o().O00000Oo();
                                            JSONArray jSONArray = new JSONArray();
                                            for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
                                                Device device = (Device) value.getValue();
                                                JSONObject jSONObject = new JSONObject();
                                                jSONObject.put("did", device.did);
                                                jSONObject.put("model", device.model);
                                                jSONArray.put(jSONObject);
                                            }
                                            for (Map.Entry<String, Device> value2 : O00000Oo2.entrySet()) {
                                                Device device2 = (Device) value2.getValue();
                                                JSONObject jSONObject2 = new JSONObject();
                                                jSONObject2.put("did", device2.did);
                                                jSONObject2.put("model", device2.model);
                                                jSONArray.put(jSONObject2);
                                            }
                                            try {
                                                String format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis()));
                                                FileOutputStream fileOutputStream = new FileOutputStream(fkw.O00000oO("/sdcard/SmartHome/plugin/devicelist/" + format + ".json"));
                                                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                                                outputStreamWriter.write(jSONArray.toString());
                                                outputStreamWriter.close();
                                                fileOutputStream.close();
                                            } catch (Exception unused) {
                                            }
                                            gsy.O000000o(3, "SmartHome-device_list", jSONArray.toString());
                                            return;
                                        } else {
                                            return;
                                        }
                                    } catch (Exception unused2) {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    fvj.O000000o(intent);
                }
            }
        });
        ezt.O000000o().setKillProcess(false);
    }
}

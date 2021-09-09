package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera;

import _m_j.cki;
import _m_j.ftd;
import _m_j.fwz;
import _m_j.fyc;
import _m_j.gbq;
import _m_j.gbt;
import _m_j.gbu;
import _m_j.gbv;
import _m_j.gbz;
import _m_j.gdt;
import _m_j.gdu;
import _m_j.gdv;
import _m_j.goq;
import _m_j.gpg;
import _m_j.grv;
import _m_j.gsy;
import _m_j.hyy;
import _m_j.iam;
import _m_j.ul;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.brentvatne.exoplayer.ExoPlayerView;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBaseJavaModule;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.receiver.CloudVideoDownloadReceiver;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "MHCameraSDK")
public class RNCameraManagerModule extends MIOTBaseJavaModule {
    public static String TAG = "RNCameraManagerModule";
    private static volatile String mCurrentDid = "null";
    private static volatile boolean mCurrentIsVideo = false;
    public static volatile iam mLruCacheCommon;
    private static String[] sDevicePassWhitelist = {"isa.camera.isc5", "isa.camera.isc5c1", "isa.camera.df3"};
    public CloudVideoDownloadReceiver mDownloadVideoProgressReceiver = new CloudVideoDownloadReceiver();
    Handler mMainHandler = new Handler(Looper.getMainLooper());

    public String getName() {
        return "MHCameraSDK";
    }

    public RNCameraManagerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void startConnect(final String str, final String str2) {
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass1 */

            public final void run() {
                CameraRouterFactory.getRNCameraApi().startConnect(str, str2);
            }
        });
    }

    @ReactMethod
    public void sendServerCmd(String str, int i, String str2, Callback callback) {
        final String str3 = str;
        final int i2 = i;
        final String str4 = str2;
        final Callback callback2 = callback;
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass12 */

            public final void run() {
                CameraRouterFactory.getRNCameraApi().sendServerCmd(str3, i2, str4, callback2);
            }
        });
    }

    @ReactMethod
    public void sendServerCmdWithBase64Param(String str, int i, String str2, Callback callback) {
        try {
            final byte[] decode = Base64.decode(str2, 2);
            final String str3 = str;
            final int i2 = i;
            final Callback callback2 = callback;
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass23 */

                public final void run() {
                    CameraRouterFactory.getRNCameraApi().sendServerCmdWithByteArray(str3, i2, decode, callback2);
                }
            });
        } catch (Exception e) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.getMessage()));
        }
    }

    @ReactMethod
    public void release(final String str) {
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass29 */

            public final void run() {
                CameraRouterFactory.getRNCameraApi().release(str);
            }
        });
    }

    @ReactMethod
    public void bindP2PCommandReceiveWithDid(final String str, final String str2) {
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass30 */

            public final void run() {
                CameraRouterFactory.getRNCameraApi().bindP2PCommandReceiveWithDid(str, str2);
            }
        });
    }

    @ReactMethod
    public void bindBpsDataCallback(final String str, final String str2) {
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass31 */

            public final void run() {
                CameraRouterFactory.getRNCameraApi().bindBpsDataCallback(str, str2);
            }
        });
    }

    @ReactMethod
    public void bindRDTDataReceiveCallback(final String str, final String str2) {
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass32 */

            public final void run() {
                CameraRouterFactory.getRNCameraApi().bindRDTDataReceiveCallback(str, str2);
            }
        });
    }

    @ReactMethod
    public void sendRDTCommandToDevice(final String str, final String str2, final Callback callback) {
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass33 */

            public final void run() {
                CameraRouterFactory.getRNCameraApi().sendRDTCommandToDevice(str, str2, callback);
            }
        });
    }

    @ReactMethod
    public void getCurrentFrameInfo(final String str, final Callback callback) {
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass34 */

            public final void run() {
                CameraRouterFactory.getRNCameraApi().getCurrentFrameInfo(str, callback);
            }
        });
    }

    @ReactMethod
    public void loadMonitoringDetail(String str, String str2, final Callback callback) {
        final DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str2);
        if (deviceByDid != null) {
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass2 */

                public final void run() {
                    CameraRouterFactory.getRNCameraApi().loadMonitoringDetail(deviceByDid, callback);
                }
            });
        }
    }

    @ReactMethod
    public void showAlarmVideos(String str, final int i, final boolean z) {
        final DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass3 */

                public final void run() {
                    CameraRouterFactory.getRNCameraApi().showAlarmVideos(deviceByDid, i, z);
                }
            });
        }
    }

    @ReactMethod
    public void showPlaybackVideos(String str, final String str2) {
        final DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass4 */

                public final void run() {
                    CameraRouterFactory.getRNCameraApi().showPlaybackVideos(deviceByDid, str2);
                }
            });
        }
    }

    @ReactMethod
    public void showCloudStorage(String str, boolean z, boolean z2, String str2) {
        final DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            final boolean z3 = z;
            final boolean z4 = z2;
            final String str3 = str2;
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass5 */

                public final void run() {
                    CameraRouterFactory.getRNCameraApi().showCloudStorage(deviceByDid, z3, z4, str3);
                }
            });
        }
    }

    @ReactMethod
    public void showCloudStorageSetting(String str, final String str2) {
        final DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass6 */

                public final void run() {
                    CameraRouterFactory.getRNCameraApi().showCloudStorageSetting(deviceByDid, str2);
                }
            });
        }
    }

    @ReactMethod
    public void getAlbumName(String str, final Callback callback) {
        if (XmPluginHostApi.instance().getDeviceByDid(str) != null) {
            final String concat = "Xiaomi/local/".concat(String.valueOf(str));
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass7 */

                public final void run() {
                    try {
                        if (callback != null) {
                            callback.invoke(Boolean.TRUE, concat);
                        }
                    } catch (Exception e) {
                        String str = RNCameraManagerModule.TAG;
                        fyc.O00000Oo(str, "Exception = " + e.toString());
                        if (callback != null) {
                            gbq.O000000o(-1, e.toString());
                        }
                    }
                }
            });
        }
    }

    @ReactMethod
    public void showAlbum(String str, final String str2) {
        final DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass8 */

                public final void run() {
                    CameraRouterFactory.getRNCameraApi().showAlbum(deviceByDid, str2);
                }
            });
        }
    }

    @ReactMethod
    public void showAlbumMediaFile(String str, final String str2) {
        final DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass9 */

                public final void run() {
                    CameraRouterFactory.getRNCameraApi().showAlbumMediaFile(deviceByDid, str2);
                }
            });
        }
    }

    @ReactMethod
    public void showLastAlbumMediaFile(String str, final String str2) {
        final DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass10 */

                public final void run() {
                    CameraRouterFactory.getRNCameraApi().showLastAlbumMediaFile(deviceByDid, str2);
                }
            });
        }
    }

    @ReactMethod
    public void showOperationBannerPage(String str, final String str2) {
        final DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass11 */

                public final void run() {
                    CameraRouterFactory.getRNCameraApi().showOperationBannerPage(deviceByDid, str2);
                }
            });
        }
    }

    @ReactMethod
    public void showFaceRecognize(String str, boolean z, String str2, String str3) {
        final DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            final boolean z2 = z;
            final String str4 = str2;
            final String str5 = str3;
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass13 */

                public final void run() {
                    CameraRouterFactory.getRNCameraApi().showFaceRecognize(deviceByDid, z2, str4, str5);
                }
            });
        }
    }

    @ReactMethod
    public void enterFullscreenForPad(final boolean z) {
        ReactContext currentReactContext;
        if (hyy.O000000o()) {
            cki.O00000o0(TAG, "setFullScreenForPad:%b", Boolean.valueOf(z));
            ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
            if (reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null) {
                gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show face recognize");
                return;
            }
            final Activity currentActivity = currentReactContext.getCurrentActivity();
            if (currentActivity != null) {
                this.mMainHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass14 */

                    public final void run() {
                        hyy.O000000o(currentActivity, z);
                    }
                });
            }
        }
    }

    @ReactMethod
    public void startRecord(String str, String str2, String str3, int i, int i2, Callback callback) {
        Callback callback2 = callback;
        if (str2.contains(getFilesPath().getAbsolutePath())) {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final int i3 = i;
            final int i4 = i2;
            final Callback callback3 = callback;
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass15 */

                public final void run() {
                    CameraRouterFactory.getRNCameraApi().startRecord(str4, str5, str6, i3, i4, callback3);
                }
            });
        } else if (callback2 != null) {
            callback2.invoke(Boolean.FALSE, gbq.O000000o(-4, "invalid path, only allow inner storage path"));
        }
    }

    @ReactMethod
    public void stopRecord(final String str, final Callback callback) {
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass16 */

            public final void run() {
                CameraRouterFactory.getRNCameraApi().stopRecord(str, callback);
            }
        });
    }

    @ReactMethod
    public void snapShot(String str, String str2, Callback callback) {
        if (str2.contains(getFilesPath().getAbsolutePath())) {
            CameraRouterFactory.getRNCameraApi().snapShot(str, str2, callback);
        } else if (callback != null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "invalid path, only allow inner storage path"));
        }
    }

    @ReactMethod
    public void ffmpegCommand(final String str, String str2, final Callback callback) {
        goq.O00000oO(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass17 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
             arg types: [int, java.lang.String]
             candidates:
              _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
              _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
              _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
            public final void run() {
                int videoConverter = XmPluginHostApi.instance().videoConverter(fwz.O000000o().O00000Oo().O0000o00.did, str);
                if (videoConverter == 0) {
                    callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) ""));
                    return;
                }
                callback.invoke(Boolean.FALSE, gbq.O000000o(videoConverter, "excute ffmpeg command failed"));
            }
        });
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
    @ReactMethod
    public void openAlarmVideoPlayer(String str) {
        DeviceStat deviceStat;
        Activity activity;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Intent intent = new Intent();
            ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
            if (reactInstanceManager != null) {
                ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                if (currentReactContext != null) {
                    Activity currentActivity = currentReactContext.getCurrentActivity();
                    if (currentActivity == null) {
                        gbu.O00000Oo("the activity to which the reactContext currently attached is null");
                        return;
                    }
                    String optString = jSONObject.optString("did");
                    if (TextUtils.isEmpty(optString)) {
                        gbz.O000000o();
                        return;
                    }
                    DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(optString);
                    if (deviceByDid == null) {
                        gbz.O000000o();
                        return;
                    }
                    String str2 = "localRecognizeEvents";
                    String str3 = "isNewPlugin";
                    String str4 = "did";
                    if (TextUtils.equals("chuangmi.camera.ipc009", deviceByDid.model)) {
                        try {
                            deviceStat = deviceByDid;
                            if (!isFirmWareCloudVersion(deviceByDid.version, "3.4.2_0200")) {
                                long optLong = jSONObject.optLong("time");
                                boolean optBoolean = jSONObject.optBoolean("skipPwd");
                                intent.putExtra("time", optLong);
                                intent.putExtra("push", true);
                                intent.putExtra("check", true);
                                intent.putExtra("extra_device_did", optString);
                                intent.putExtra("is_v4", true);
                                intent.setClass(currentActivity, ((gdu) gdv.f17570O000000o.getUiInterface()).O0000oOo());
                                intent.setFlags(67108864);
                                intent.addFlags(268435456);
                                intent.putExtra("skipPwd", optBoolean);
                                intent.putExtra("isFromRn", true);
                                currentActivity.startActivity(intent);
                                return;
                            }
                        } catch (Exception unused) {
                            return;
                        }
                    } else {
                        deviceStat = deviceByDid;
                    }
                    long optLong2 = jSONObject.optLong("createTime");
                    String optString2 = jSONObject.optString("fileId");
                    int optInt = jSONObject.optInt("offset");
                    Activity activity2 = currentActivity;
                    boolean optBoolean2 = jSONObject.optBoolean("isAlarm", true);
                    double optDouble = jSONObject.optDouble("startDuration");
                    String optString3 = jSONObject.optString(str4);
                    boolean optBoolean3 = jSONObject.optBoolean("skipPwd", false);
                    String str5 = str3;
                    String str6 = "skipPwd";
                    boolean optBoolean4 = jSONObject.optBoolean(str5);
                    String str7 = str5;
                    String str8 = str2;
                    int optInt2 = jSONObject.optInt(str8);
                    intent.putExtra("fileId", optString2);
                    intent.putExtra("createTime", optLong2);
                    intent.putExtra("isAlarm", optBoolean2);
                    intent.putExtra("offset", optInt);
                    intent.putExtra("startDuration", optDouble);
                    intent.putExtra("isFromRn", true);
                    intent.putExtra(str7, optBoolean4);
                    intent.putExtra(str8, optInt2);
                    intent.putExtra("extra_device_did", optString3);
                    if (optBoolean2) {
                        activity = activity2;
                        intent.setClass(activity, ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o(deviceStat.model));
                    } else {
                        activity = activity2;
                        intent.setClass(activity, ((gdu) gdv.f17570O000000o.getUiInterface()).O00000Oo(deviceStat.model));
                    }
                    intent.putExtra(str6, optBoolean3);
                    intent.putExtra("is_from_rn", true);
                    intent.setFlags(67108864);
                    intent.addFlags(268435456);
                    activity.startActivity(intent);
                    return;
                }
            }
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show cloud storage setting");
        } catch (Exception unused2) {
        }
    }

    public Map<String, Object> getConstants() {
        return super.getConstants();
    }

    @ReactMethod
    public void downloadM3U8ToMP4(String str, String str2, String str3, boolean z, String str4, String str5, String str6) {
        String str7 = TAG;
        StringBuilder sb = new StringBuilder("downloadM3U8ToMP4 params= did=");
        sb.append(str2);
        sb.append(" model=");
        sb.append(str);
        sb.append(" fileId=");
        sb.append(str3);
        sb.append(" videoCodec=");
        String str8 = str4;
        sb.append(str8);
        sb.append(" isAlarm=");
        sb.append(z);
        sb.append(" filePath=");
        String str9 = str5;
        sb.append(str9);
        sb.append(" eventName=");
        String str10 = str6;
        sb.append(str10);
        fyc.O00000Oo(str7, sb.toString());
        CameraRouterFactory.getRNCameraApi().downloadM3U8ToMP4(str, str2, str3, z, str8, str9, str10);
    }

    @ReactMethod
    public void downloadM3U8ToMP4V2(String str, String str2, String str3, boolean z, String str4, String str5, boolean z2, String str6) {
        String str7 = TAG;
        StringBuilder sb = new StringBuilder("downloadM3U8ToMP4 params= did=");
        sb.append(str2);
        sb.append(" model=");
        sb.append(str);
        sb.append(" fileId=");
        sb.append(str3);
        sb.append(" videoCodec=");
        String str8 = str4;
        sb.append(str8);
        sb.append(" isAlarm=");
        boolean z3 = z;
        sb.append(z3);
        sb.append(" filePath=");
        String str9 = str5;
        sb.append(str9);
        sb.append(" eventName=");
        String str10 = str6;
        sb.append(str10);
        sb.append(" transcode=");
        boolean z4 = z2;
        sb.append(z4);
        fyc.O00000Oo(str7, sb.toString());
        CameraRouterFactory.getRNCameraApi().downloadM3U8ToMP4V2(str, str2, str3, z3, str8, str9, z4, str10);
    }

    @ReactMethod
    public void cancelDownloadM3U8ToMP4V2(String str, String str2, String str3, boolean z, String str4) {
        String str5 = TAG;
        fyc.O00000Oo(str5, "cancelDownloadM3U8ToMP4V2 model=" + str + " did=" + str2 + " fileId=" + str3 + " callbackName=" + str4 + " isAlarm=" + z);
        CameraRouterFactory.getRNCameraApi().cancelDownloadM3U8ToMP4V2(str, str2, str3, z, str4);
    }

    @ReactMethod
    public void getVideoFileUrl(String str, String str2, String str3, boolean z, String str4, Callback callback) {
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final boolean z2 = z;
        final String str8 = str4;
        final Callback callback2 = callback;
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass18 */

            public final void run() {
                try {
                    String str = RNCameraManagerModule.TAG;
                    fyc.O00000Oo(str, "getVideoFileUrl params= did=" + str5 + " model=" + str6 + " fileId=" + str7 + " isAlarm=" + z2 + " videoCodec=" + str8);
                    String O000000o2 = ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o(str5, str6, str7, z2, str8);
                    fyc.O00000Oo(RNCameraManagerModule.TAG, "requestUrl = ".concat(String.valueOf(O000000o2)));
                    if (callback2 != null) {
                        callback2.invoke(Boolean.TRUE, O000000o2);
                    }
                } catch (Exception e) {
                    String str2 = RNCameraManagerModule.TAG;
                    fyc.O00000Oo(str2, "Exception = " + e.toString());
                    Callback callback = callback2;
                    if (callback != null) {
                        callback.invoke(Boolean.FALSE, e.toString());
                    }
                }
            }
        });
    }

    @ReactMethod
    public void getfileIdImage(String str, String str2, String str3, Callback callback) {
        final String str4 = str3;
        final String str5 = str;
        final Callback callback2 = callback;
        final String str6 = str2;
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass19 */

            public final void run() {
                final String md5 = RNCameraManagerModule.this.getMD5(str4);
                try {
                    RNCameraManagerModule.this.initDiskCache(str5, false);
                    String O000000o2 = RNCameraManagerModule.mLruCacheCommon.O000000o(md5);
                    if (O000000o2 != null) {
                        callback2.invoke(Boolean.TRUE, O000000o2);
                        return;
                    }
                    goq.O00000oO(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass19.AnonymousClass1 */

                        public final void run() {
                            try {
                                String videoSnapshotUrl = CameraRouterFactory.getRNCameraApi().getVideoSnapshotUrl(str6, str5, str4);
                                if (TextUtils.isEmpty(videoSnapshotUrl)) {
                                    RNCameraManagerModule.this.mMainHandler.post(new Runnable() {
                                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass19.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            callback2.invoke(Boolean.FALSE, null);
                                        }
                                    });
                                    return;
                                }
                                byte[] sendImageDownloadRequest = XmPluginHostApi.instance().sendImageDownloadRequest(CommonApplication.getAppContext(), videoSnapshotUrl);
                                iam.O000000o O00000Oo2 = RNCameraManagerModule.mLruCacheCommon.O00000Oo(md5);
                                OutputStream O000000o2 = O00000Oo2.O000000o();
                                O000000o2.write(sendImageDownloadRequest);
                                O000000o2.flush();
                                O000000o2.close();
                                O00000Oo2.O00000Oo();
                                final String O000000o3 = RNCameraManagerModule.mLruCacheCommon.O000000o(md5);
                                if (O000000o3 != null) {
                                    RNCameraManagerModule.this.mMainHandler.post(new Runnable() {
                                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass19.AnonymousClass1.AnonymousClass2 */

                                        public final void run() {
                                            callback2.invoke(Boolean.TRUE, O000000o3);
                                        }
                                    });
                                } else {
                                    RNCameraManagerModule.this.mMainHandler.post(new Runnable() {
                                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass19.AnonymousClass1.AnonymousClass3 */

                                        public final void run() {
                                            callback2.invoke(Boolean.FALSE, null);
                                        }
                                    });
                                }
                            } catch (Exception unused) {
                                callback2.invoke(Boolean.FALSE, null);
                            }
                        }
                    });
                } catch (Exception e) {
                    String str = RNCameraManagerModule.TAG;
                    fyc.O00000o(str, "Exception=" + e.toString());
                    callback2.invoke(Boolean.FALSE, null);
                }
            }
        });
    }

    @ReactMethod
    public void getFaceImgWithDid(String str, String str2, String str3, Callback callback) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Callback callback2 = callback;
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass20 */

            public final void run() {
                String str = RNCameraManagerModule.TAG;
                fyc.O00000Oo(str, "did=" + str4 + " model=" + str5 + " faceId=" + str6);
                final String md5 = RNCameraManagerModule.this.getMD5(str6);
                try {
                    RNCameraManagerModule.this.initDiskCache(str4, false);
                    final String O000000o2 = RNCameraManagerModule.mLruCacheCommon.O000000o(md5);
                    if (O000000o2 != null) {
                        fyc.O00000Oo(RNCameraManagerModule.TAG, "true cache=".concat(String.valueOf(O000000o2)));
                        callback2.invoke(Boolean.TRUE, O000000o2);
                        return;
                    }
                    goq.O00000oO(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass20.AnonymousClass1 */

                        public final void run() {
                            try {
                                String faceImg = CameraRouterFactory.getRNCameraApi().getFaceImg(str4, str5, str6);
                                fyc.O00000Oo(RNCameraManagerModule.TAG, "SnapshotUrl=".concat(String.valueOf(faceImg)));
                                if (TextUtils.isEmpty(faceImg)) {
                                    RNCameraManagerModule.this.mMainHandler.post(new Runnable() {
                                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass20.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            String str = RNCameraManagerModule.TAG;
                                            fyc.O00000Oo(str, "false filePath=" + O000000o2);
                                            callback2.invoke(Boolean.FALSE, null);
                                        }
                                    });
                                    return;
                                }
                                byte[] sendImageDownloadRequest = XmPluginHostApi.instance().sendImageDownloadRequest(CommonApplication.getAppContext(), faceImg);
                                fyc.O00000Oo(RNCameraManagerModule.TAG, "outData=".concat(String.valueOf(sendImageDownloadRequest)));
                                iam.O000000o O00000Oo2 = RNCameraManagerModule.mLruCacheCommon.O00000Oo(md5);
                                OutputStream O000000o2 = O00000Oo2.O000000o();
                                O000000o2.write(sendImageDownloadRequest);
                                O000000o2.flush();
                                O000000o2.close();
                                O00000Oo2.O00000Oo();
                                final String O000000o3 = RNCameraManagerModule.mLruCacheCommon.O000000o(md5);
                                if (O000000o3 != null) {
                                    RNCameraManagerModule.this.mMainHandler.post(new Runnable() {
                                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass20.AnonymousClass1.AnonymousClass2 */

                                        public final void run() {
                                            String str = RNCameraManagerModule.TAG;
                                            fyc.O00000Oo(str, "true=" + O000000o3);
                                            callback2.invoke(Boolean.TRUE, O000000o3);
                                        }
                                    });
                                } else {
                                    RNCameraManagerModule.this.mMainHandler.post(new Runnable() {
                                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass20.AnonymousClass1.AnonymousClass3 */

                                        public final void run() {
                                            String str = RNCameraManagerModule.TAG;
                                            fyc.O00000Oo(str, "false filePath=" + O000000o3);
                                            callback2.invoke(Boolean.FALSE, null);
                                        }
                                    });
                                }
                            } catch (Exception e) {
                                RNCameraManagerModule.this.mMainHandler.post(new Runnable() {
                                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass20.AnonymousClass1.AnonymousClass4 */

                                    public final void run() {
                                        String str = RNCameraManagerModule.TAG;
                                        fyc.O00000o(str, "Exception=" + e.toString());
                                        callback2.invoke(Boolean.FALSE, null);
                                    }
                                });
                            }
                        }
                    });
                } catch (Exception e) {
                    String str2 = RNCameraManagerModule.TAG;
                    fyc.O00000o(str2, "Exception=" + e.toString());
                    callback2.invoke(Boolean.FALSE, null);
                }
            }
        });
    }

    @ReactMethod
    public void getCommonImgWithParams(String str, String str2, String str3, String str4, String str5, Callback callback) {
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final Callback callback2 = callback;
        final String str9 = str4;
        final String str10 = str5;
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass21 */

            public final void run() {
                String str = RNCameraManagerModule.TAG;
                fyc.O00000Oo(str, "getCommonImgWithParams did=" + str6 + " model=" + str7 + " imgId=" + str8);
                final String md5 = RNCameraManagerModule.this.getMD5(str8);
                try {
                    RNCameraManagerModule.this.initDiskCache(str6, false);
                    final String O000000o2 = RNCameraManagerModule.mLruCacheCommon.O000000o(md5);
                    if (O000000o2 != null) {
                        fyc.O00000Oo(RNCameraManagerModule.TAG, "true cache=".concat(String.valueOf(O000000o2)));
                        callback2.invoke(Boolean.TRUE, O000000o2);
                        return;
                    }
                    goq.O00000oO(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass21.AnonymousClass1 */

                        public final void run() {
                            try {
                                String generateRequestUrl = XmPluginHostApi.instance().generateRequestUrl(str7, new JSONObject(str9), new JSONObject(str10));
                                fyc.O00000Oo(RNCameraManagerModule.TAG, "getCommonImgWithParams SnapshotUrl=".concat(String.valueOf(generateRequestUrl)));
                                if (TextUtils.isEmpty(generateRequestUrl)) {
                                    RNCameraManagerModule.this.mMainHandler.post(new Runnable() {
                                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass21.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            String str = RNCameraManagerModule.TAG;
                                            fyc.O00000Oo(str, "false filePath=" + O000000o2);
                                            callback2.invoke(Boolean.FALSE, null);
                                        }
                                    });
                                    return;
                                }
                                byte[] sendImageDownloadRequest = XmPluginHostApi.instance().sendImageDownloadRequest(CommonApplication.getAppContext(), generateRequestUrl);
                                fyc.O00000Oo(RNCameraManagerModule.TAG, "outData=".concat(String.valueOf(sendImageDownloadRequest)));
                                iam.O000000o O00000Oo2 = RNCameraManagerModule.mLruCacheCommon.O00000Oo(md5);
                                OutputStream O000000o2 = O00000Oo2.O000000o();
                                O000000o2.write(sendImageDownloadRequest);
                                O000000o2.flush();
                                O000000o2.close();
                                O00000Oo2.O00000Oo();
                                final String O000000o3 = RNCameraManagerModule.mLruCacheCommon.O000000o(md5);
                                if (O000000o3 != null) {
                                    RNCameraManagerModule.this.mMainHandler.post(new Runnable() {
                                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass21.AnonymousClass1.AnonymousClass2 */

                                        public final void run() {
                                            String str = RNCameraManagerModule.TAG;
                                            fyc.O00000Oo(str, "true=" + O000000o3);
                                            callback2.invoke(Boolean.TRUE, O000000o3);
                                        }
                                    });
                                } else {
                                    RNCameraManagerModule.this.mMainHandler.post(new Runnable() {
                                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass21.AnonymousClass1.AnonymousClass3 */

                                        public final void run() {
                                            String str = RNCameraManagerModule.TAG;
                                            fyc.O00000Oo(str, "false filePath=" + O000000o3);
                                            callback2.invoke(Boolean.FALSE, null);
                                        }
                                    });
                                }
                            } catch (Exception e) {
                                RNCameraManagerModule.this.mMainHandler.post(new Runnable() {
                                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass21.AnonymousClass1.AnonymousClass4 */

                                    public final void run() {
                                        String str = RNCameraManagerModule.TAG;
                                        fyc.O00000o(str, "Exception=" + e.toString());
                                        callback2.invoke(Boolean.FALSE, null);
                                    }
                                });
                            }
                        }
                    });
                } catch (Exception e) {
                    String str2 = RNCameraManagerModule.TAG;
                    fyc.O00000o(str2, "Exception=" + e.toString());
                    callback2.invoke(Boolean.FALSE, null);
                }
            }
        });
    }

    @ReactMethod
    public void setTimelinePlaybackMode(String str, boolean z) {
        CameraRouterFactory.getRNCameraApi().setTimelinePlaybackMode(str, z);
    }

    @ReactMethod
    public void bindTimelinePlaybackEndListener(String str, String str2) {
        CameraRouterFactory.getRNCameraApi().bindTimelinePlaybackEndListener(str, str2);
    }

    @ReactMethod
    public void getCurrentSpeakerVolumn(String str, Callback callback) {
        if (callback != null) {
            int currentSpeakerVolume = CameraRouterFactory.getRNCameraApi().getCurrentSpeakerVolume(str);
            if (currentSpeakerVolume <= 0) {
                callback.invoke(Boolean.FALSE, null);
                return;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("volume", currentSpeakerVolume);
            callback.invoke(Boolean.TRUE, createMap);
        }
    }

    @ReactMethod
    public void setCurrentDeviceIsMissFirmware(String str, boolean z) {
        CameraRouterFactory.getRNCameraApi().setCurrentDeviceIsMissFirmware(str, z);
    }

    @ReactMethod
    public void showNASSettingPage(String str) {
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            CameraRouterFactory.getRNCameraApi().showNASSettingPage(deviceByDid);
        }
    }

    @ReactMethod
    public void openFloatWindow(String str, Callback callback) {
        CameraRouterFactory.getRNCameraApi().openFloatWindow(str, callback);
    }

    @ReactMethod
    public void closeFloatWindow(String str) {
        XmPluginHostApi.instance().closeCameraFloatingWindow(str);
    }

    @ReactMethod
    public void tryBindAlarmNotifyWithWechatMijia(String str, final Callback callback) {
        DeviceStat deviceByDid;
        ReactContext currentReactContext;
        if (callback != null && (deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str)) != null) {
            ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
            if (reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null) {
                gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show alarm videos");
                return;
            }
            Activity currentActivity = currentReactContext.getCurrentActivity();
            if (currentActivity == null) {
                gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            } else {
                XmPluginHostApi.instance().setWxPush(currentActivity, deviceByDid.model, deviceByDid.did, true, 4369, new com.xiaomi.smarthome.device.api.Callback<Boolean>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass22 */

                    public final void onFailure(int i, String str) {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(i, str));
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
                     arg types: [int, java.lang.String]
                     candidates:
                      _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
                      _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
                      _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
                    public final /* synthetic */ void onSuccess(Object obj) {
                        callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) "bind success"));
                    }
                });
            }
        }
    }

    @ReactMethod
    public void requestDeviceP2pInfo(String str, final Callback callback) {
        DeviceStat deviceByDid;
        boolean z;
        if (!TextUtils.isEmpty(str) && callback != null && (deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str)) != null) {
            String str2 = deviceByDid.model;
            String[] strArr = sDevicePassWhitelist;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (TextUtils.equals(str2, strArr[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                callback.invoke(Boolean.FALSE, "not in white list, cannot request device password");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", str);
                String devicePincode = XmPluginHostApi.instance().getDevicePincode(str);
                if (!TextUtils.isEmpty(devicePincode)) {
                    jSONObject.put("pincode", devicePincode);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            XmPluginHostApi.instance().callSmartHomeApi(deviceByDid.model, "/device/devicepass", jSONObject, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass24 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    callback.invoke(Boolean.TRUE, ((JSONObject) obj).toString());
                }

                public final void onFailure(int i, String str) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(i, str));
                }
            }, Parser.DEFAULT_PARSER);
        }
    }

    @ReactMethod
    public void decryptBigFile(String str, String str2, String str3, Callback callback) {
        CameraRouterFactory.getRNCameraApi().decryptBigFile(str, str2, str3, callback);
    }

    @ReactMethod
    public void decryptSmallFile(String str, String str2, String str3, Callback callback) {
        CameraRouterFactory.getRNCameraApi().decryptSmallFile(str, str2, str3, callback);
    }

    @ReactMethod
    public void markCurrrentDeviceRdtDataEncrypted(boolean z, String str) {
        CameraRouterFactory.getRNCameraApi().markCurrrentDeviceRdtDataEncrypted(z, str);
    }

    @ReactMethod
    public void setGeneralIjkPlayerEnable(boolean z, String str) {
        CameraRouterFactory.getRNCameraApi().setGeneralIjkPlayerEnable(z, str);
    }

    @ReactMethod
    public void setHSVideoEnable(boolean z, String str) {
        CameraRouterFactory.getRNCameraApi().setHSVideoEnable(z, str);
    }

    @ReactMethod
    public void markCurrentDeviceHualaiEncrypted(boolean z, String str) {
        CameraRouterFactory.getRNCameraApi().markCurrentDeviceHualaiEncrypted(z, str);
    }

    @ReactMethod
    public void setCurrentDeviceUseFixedRdtChannel(boolean z, String str) {
        CameraRouterFactory.getRNCameraApi().setCurrentDeviceUseFixedRdtChannel(z, str);
    }

    @ReactMethod
    public void setCurrentVoiceChangerType(int i, int i2, int i3, String str) {
        CameraRouterFactory.getRNCameraApi().setCurrentVoiceChangerType(i, i2, i3, str);
    }

    @ReactMethod
    public void setCurrentDeviceUseFixedUid(boolean z) {
        DeviceModelManager.getInstance().setUseFixedDeviceUid(z);
    }

    @ReactMethod
    public void showScreenLinkagePage(boolean z, int i, String str) {
        ReactContext currentReactContext;
        ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
        if (reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show alarm videos");
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            return;
        }
        Intent intent = new Intent(currentActivity, ((gdu) gdv.f17570O000000o.getUiInterface()).O00000oO());
        intent.putExtra("extra_device_did", str);
        intent.putExtra("extra_multi_choice", z);
        intent.putExtra("extra_max_length", i);
        currentActivity.startActivity(intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
     arg types: [int, java.lang.String]
     candidates:
      _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
    @ReactMethod
    public void launchRecommend(String str, String str2, String str3, Callback callback) {
        ReactContext currentReactContext;
        ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
        if (reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show alarm videos");
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            return;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt / 1000 == 2) {
                Intent intent = new Intent(currentActivity, ((gdu) gdv.f17570O000000o.getUiInterface()).O00000oo());
                intent.putExtra("sr_id", parseInt);
                intent.putExtra("did", str2);
                currentActivity.startActivity(intent);
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) "success"));
                return;
            }
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "aSrId is not supported"));
        } catch (Exception e) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.getMessage()));
        }
    }

    @ReactMethod
    public void downloadCloudVideoIntoCloudSetting(String str, String str2, boolean z, double d, double d2, boolean z2, String str3, Callback callback) {
        final boolean z3 = z2;
        final String str4 = str2;
        final String str5 = str;
        final boolean z4 = z;
        final double d3 = d;
        final double d4 = d2;
        final Callback callback2 = callback;
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass25 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
             arg types: [int, java.lang.String]
             candidates:
              _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
              _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
              _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
            public final void run() {
                if (RNCameraManagerModule.this.mDownloadVideoProgressReceiver != null) {
                    if (!z3) {
                        CloudVideoDownloadReceiver.O00000Oo(str4);
                        if (CloudVideoDownloadReceiver.O000000o()) {
                            try {
                                CommonApplication.getApplication().unregisterReceiver(RNCameraManagerModule.this.mDownloadVideoProgressReceiver);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        if (CloudVideoDownloadReceiver.O000000o()) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("com.xiaomi.smarthome.camera.CloudVideoDownloadReceiver");
                            try {
                                CommonApplication.getApplication().registerReceiver(RNCameraManagerModule.this.mDownloadVideoProgressReceiver, intentFilter);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        CloudVideoDownloadReceiver.O000000o(str4);
                        if (CoreApi.O000000o().O000000o(str5, str4, z4, (long) d3, (long) d4) < 0) {
                            callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "download cloudvideo error"));
                            return;
                        }
                        callback2.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) "add into download list"));
                    }
                }
            }
        });
    }

    @ReactMethod
    public void openCloudSettingDownloadListPage(String str) {
        CameraRouterFactory.getRNCameraApi().openCloudSettingDownloadListPage(getCurrentActivity(), str);
    }

    @ReactMethod
    public void downloadCloudVideoMp4(String str, String str2, String str3, Callback callback) {
        final String str4 = str3;
        final String str5 = str;
        final Callback callback2 = callback;
        final String str6 = str2;
        this.mMainHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass26 */

            public final void run() {
                final String md5 = RNCameraManagerModule.this.getMD5(str4);
                RNCameraManagerModule.this.initDiskCache(str5, true);
                try {
                    String O000000o2 = RNCameraManagerModule.mLruCacheCommon.O000000o(md5);
                    if (!TextUtils.isEmpty(O000000o2)) {
                        if (callback2 != null) {
                            callback2.invoke(Boolean.TRUE, O000000o2);
                            return;
                        }
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("did", str5);
                    jSONObject.put("fileId", str6);
                    jSONObject.put("stoId", str4);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                String jSONObject2 = jSONObject.toString();
                if (RNCameraManagerModule.this.getReactApplicationContext() == null) {
                    Callback callback = callback2;
                    if (callback != null) {
                        callback.invoke(Boolean.FALSE, "null context");
                        return;
                    }
                    return;
                }
                XmPluginHostApi.instance().getCloudVideoFile(RNCameraManagerModule.this.getReactApplicationContext(), jSONObject2, new ICloudDataCallback<String>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass26.AnonymousClass1 */

                    public final void onCloudDataProgress(int i) {
                    }

                    public final /* synthetic */ void onCloudDataSuccess(Object obj, Object obj2) {
                        final String str = (String) obj;
                        if (callback2 == null) {
                            return;
                        }
                        if (TextUtils.isEmpty(str)) {
                            callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "download file failed"));
                            return;
                        }
                        goq.O00000oO(new Runnable() {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass26.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                try {
                                    iam.O000000o O00000Oo2 = RNCameraManagerModule.mLruCacheCommon.O00000Oo(md5);
                                    OutputStream O000000o2 = O00000Oo2.O000000o();
                                    boolean O000000o3 = ftd.O000000o(O000000o2, str);
                                    gpg.O000000o(O000000o2);
                                    if (!O000000o3) {
                                        callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "copy file failed"));
                                        return;
                                    }
                                    new File(str).delete();
                                    O00000Oo2.O00000Oo();
                                    String O000000o4 = RNCameraManagerModule.mLruCacheCommon.O000000o(md5);
                                    if (!TextUtils.isEmpty(O000000o4)) {
                                        callback2.invoke(Boolean.TRUE, O000000o4);
                                        return;
                                    }
                                    callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "save file failed"));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "save file failed"));
                                }
                            }
                        });
                    }

                    public final void onCloudDataFailed(int i, String str) {
                        if (callback2 != null) {
                            callback2.invoke(Boolean.FALSE, gbq.O000000o(i, str));
                        }
                    }
                });
            }
        });
    }

    @ReactMethod
    public void convertG711VideoIntoAACVideo(String str, ReadableMap readableMap, Callback callback) {
        if (!gbt.O00000Oo(getFilesPath().toString(), str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "invalid file path, expected begin with Host.file.storageBasePath"));
            return;
        }
        CameraRouterFactory.getRNCameraApi().convertG711VideoIntoAACVideo(str, readableMap, callback);
    }

    @ReactMethod
    public void reactNativeVideoScreenShot(int i, final String str, final Callback callback) {
        ExoPlayerView exoPlayerView;
        if (callback != null) {
            if (!gbt.O00000Oo(getFilesPath().toString(), str)) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "imagePath is not valid; not startWith Host.file.baseStoragePath"));
                return;
            }
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null || currentActivity.isFinishing()) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "null activity"));
                return;
            }
            View findViewById = currentActivity.findViewById(i);
            if (findViewById == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "cannot find view"));
                return;
            }
            if (findViewById instanceof ViewGroup) {
                View childAt = ((ViewGroup) findViewById).getChildAt(0);
                if ((childAt instanceof ul) && (exoPlayerView = ((ul) childAt).getExoPlayerView()) != null && exoPlayerView.getVideoSurfaceView() != null && (exoPlayerView.getVideoSurfaceView() instanceof TextureView)) {
                    final Bitmap bitmap = ((TextureView) exoPlayerView.getVideoSurfaceView()).getBitmap();
                    goq.O00000oO(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass27 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
                         arg types: [int, java.lang.String]
                         candidates:
                          _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
                          _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
                          _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
                        public final void run() {
                            if (RNCameraManagerModule.saveBitmapToPath(bitmap, str) == 0) {
                                callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) "snapshot and save success"));
                                return;
                            }
                            callback.invoke(Boolean.FALSE, gbq.O000000o(0, (Object) "snapshot success but save failed"));
                        }
                    });
                    return;
                }
            }
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "react native video get exoPlayer error"));
        }
    }

    public static int saveBitmapToPath(Bitmap bitmap, String str) {
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                return 0;
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    @ReactMethod
    public void convertH26xVideoIntoMp4(ReadableMap readableMap, Callback callback) {
        if (callback != null) {
            if (readableMap == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "empty param"));
                return;
            }
            String str = "";
            String string = readableMap.hasKey("videoPath") ? readableMap.getString("videoPath") : str;
            String string2 = readableMap.hasKey("targetPath") ? readableMap.getString("targetPath") : str;
            if (readableMap.hasKey("aacAudioPath")) {
                str = readableMap.getString("aacAudioPath");
            }
            int i = readableMap.hasKey("videoType") ? readableMap.getInt("videoType") : -1;
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "empty param"));
                return;
            }
            if (!(gbt.O00000Oo(getFilesPath().toString(), string) && gbt.O00000Oo(getFilesPath().toString(), string2))) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "invalid video path or targetPath"));
            } else if (TextUtils.isEmpty(str) || !gbt.O00000Oo(getFilesPath().toString(), str)) {
                CameraRouterFactory.getRNCameraApi().convertH26xVideoIntoMp4(i, string, string2, str, readableMap, callback);
            } else {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "invalid audio path"));
            }
        }
    }

    @ReactMethod
    public void setFrameFilter(ReadableMap readableMap, String str, String str2) {
        int O00000Oo;
        if (readableMap == null) {
            CameraRouterFactory.getRNCameraApi().cancleFrameFilter(str2);
            return;
        }
        JSONArray O000000o2 = gbv.O000000o(gbv.O00000oO(readableMap, "timestamp_s"));
        ArrayList arrayList = new ArrayList();
        if (O000000o2.length() != 0) {
            for (int i = 0; i < O000000o2.length(); i++) {
                int optInt = O000000o2.optInt(i);
                if (optInt != 0) {
                    arrayList.add(Integer.valueOf(optInt));
                }
            }
        }
        if (arrayList.size() == 0 && (O00000Oo = gbv.O00000Oo(readableMap, "timestamp_s")) != 0) {
            arrayList.add(Integer.valueOf(O00000Oo));
        }
        if (arrayList.size() == 0) {
            CameraRouterFactory.getRNCameraApi().cancleFrameFilter(str2);
        } else {
            CameraRouterFactory.getRNCameraApi().setFrameFilter(str2, arrayList, str);
        }
    }

    @ReactMethod
    public void callTutkSpecial(ReadableMap readableMap, String str, Callback callback) {
        String O000000o2 = gbv.O000000o(readableMap, "name");
        if (!TextUtils.isEmpty(O000000o2)) {
            CameraRouterFactory.getRNCameraApi().callTutkSpecialCmd(O000000o2, str, callback);
        } else if (callback != null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "tutk command param : name is null"));
        }
    }

    @ReactMethod
    public void sendAudioData(String str, String str2, int i, String str3, Callback callback) {
        CameraRouterFactory.getRNCameraApi().sendAudioData(str, str2, i, str3, callback);
    }

    @ReactMethod
    public void bindMoveTypeChangeCallback(String str, String str2) {
        CameraRouterFactory.getRNCameraApi().bindMoveTypeChangeCallback(str, str2);
    }

    @ReactMethod
    public void uploadImageToCameraServer(String str, String str2, final Callback callback) {
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("model", deviceByDid.model);
                jSONObject.put("did", deviceByDid.did);
                ArrayList arrayList = new ArrayList();
                arrayList.add(str2);
                XmPluginHostApi.instance().uploadImageFile(deviceByDid.model, deviceByDid.did, "business.smartcamera", "/miot/camera/app/v1/add/photo", jSONObject, arrayList, new ICloudDataCallback<JSONObject>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule.AnonymousClass28 */

                    public final void onCloudDataProgress(int i) {
                    }

                    public final /* synthetic */ void onCloudDataSuccess(Object obj, Object obj2) {
                        JSONObject jSONObject = (JSONObject) obj;
                        Callback callback = callback;
                        if (callback != null) {
                            callback.invoke(Boolean.TRUE, gbq.O000000o(0, jSONObject));
                        }
                        String str = RNCameraManagerModule.TAG;
                        gsy.O00000Oo(str, "uploadImageFile result:" + jSONObject + ":" + obj2);
                    }

                    public final void onCloudDataFailed(int i, String str) {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.invoke(Boolean.FALSE, gbq.O000000o(i, str));
                        }
                        String str2 = RNCameraManagerModule.TAG;
                        gsy.O00000Oo(str2, "uploadImageFile errorCode" + i + ":" + str);
                    }
                });
            } catch (JSONException e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (callback != null) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-1001, e.getLocalizedMessage()));
                }
            }
        } else if (callback != null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "deviceStat is null"));
        }
    }

    public void initDiskCache(String str, boolean z) {
        if (!mCurrentDid.equals(str) || mLruCacheCommon == null || z != mCurrentIsVideo) {
            String absolutePath = getFilesPath().getAbsolutePath();
            mCurrentDid = str == null ? "null" : str;
            mCurrentIsVideo = z;
            if (mLruCacheCommon != null) {
                try {
                    mLruCacheCommon.O00000o0();
                    mLruCacheCommon.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(absolutePath);
                sb.append(File.separator);
                sb.append(z ? "commonImages" : "cloudVideos");
                sb.append(File.separator);
                sb.append(str);
                mLruCacheCommon = iam.O000000o(new File(sb.toString()), z ? 209715200 : 104857600);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public String getMD5(String str) {
        try {
            return grv.O000000o(str).toLowerCase();
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean isFirmWareCloudVersion(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.equals(str, str2)) {
                return true;
            }
            Pattern compile = Pattern.compile("[._]+");
            String[] split = compile.split(str);
            String[] split2 = compile.split(str2);
            int min = Math.min(split.length, split2.length);
            for (int i = 0; i < min; i++) {
                if (split[i].compareTo(split2[i]) > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onCatalystInstanceDestroy() {
        try {
            CommonApplication.getApplication().unregisterReceiver(this.mDownloadVideoProgressReceiver);
        } catch (Exception unused) {
        }
        this.mDownloadVideoProgressReceiver = null;
    }
}

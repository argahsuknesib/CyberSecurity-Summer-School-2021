package com.xiaomi.smarthome.camera.api;

import _m_j.cid;
import _m_j.cim;
import _m_j.civ;
import _m_j.cki;
import _m_j.ckr;
import _m_j.clf;
import _m_j.cug;
import _m_j.fkw;
import _m_j.fww;
import _m_j.fyc;
import _m_j.gbq;
import _m_j.gbu;
import _m_j.gcd;
import _m_j.gce;
import _m_j.gcf;
import _m_j.gcg;
import _m_j.gci;
import _m_j.gdu;
import _m_j.gdv;
import _m_j.gkv;
import _m_j.goq;
import _m_j.gsy;
import _m_j.hmq;
import _m_j.hte;
import _m_j.jha;
import _m_j.jhz;
import _m_j.jib;
import _m_j.jii;
import _m_j.jip;
import _m_j.jiu;
import _m_j.mk;
import _m_j.wd;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewManager;
import com.mijia.camera.MediaRemuxing;
import com.mijia.camera.nas.NASInfo;
import com.mijia.model.alarmcloud.AlarmCloudCallback;
import com.mijia.model.alarmcloud.AlarmCloudManager;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.mijia.model.alarmcloud.FaceInfoMeta;
import com.sankuai.waimai.router.annotation.RouterService;
import com.tutk.DecryptUtil;
import com.tutk.P2PInfoImp;
import com.xiaomi.aaccodec.G711;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmP2PInfo;
import com.xiaomi.smarthome.camera.view.widget.XmLoadingDialog;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.AbsRNVideoView;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.HSVideoViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.RNCameraViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.RTSPViewManager;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class RNCameraApiImpl implements IRNCameraApi {
    private static final RNCameraApiImpl INSTANCE = new RNCameraApiImpl();

    @cug
    public static RNCameraApiImpl provideInstance() {
        return INSTANCE;
    }

    public void initRNCameraFrameSender(DeviceStat deviceStat) {
        fww.O000000o();
        XmPluginHostApi.instance().initCameraFrameSender(deviceStat.did);
    }

    public void RNCameraStartRequestData(DeviceStat deviceStat, Intent intent) {
        cid cid;
        fww O000000o2 = fww.O000000o();
        gsy.O000000o(3, "RNCameraFrameManager", "startRequestData:" + deviceStat.toString());
        if (intent != null) {
            O000000o2.O00000o0 = intent.getIntExtra("request_frame_rate", 1);
            O000000o2.O00000o = intent.getBooleanExtra("mute", true);
        }
        if (TextUtils.isEmpty(deviceStat.parentId)) {
            cid = cid.O000000o(deviceStat, deviceStat.did);
        } else {
            DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(deviceStat.parentId);
            cid = cid.O000000o(deviceByDid, deviceStat.parentId + "--" + deviceStat.did);
        }
        if (cid == null) {
            try {
                gsy.O00000Oo("RNCameraFrameManager", "startRequestDataEx cameraDevice return null");
            } catch (Exception e) {
                gsy.O000000o(6, "RNCameraFrameManager", "JSONException:" + e.getLocalizedMessage());
            }
        } else {
            civ.O000000o(cid.getModel());
            gsy.O00000Oo("RNCameraFrameManager", "startRequestDataEx");
            String str = deviceStat.did;
            gci gci = (gci) O000000o2.f17335O000000o.get(str);
            if (gci != null) {
                O000000o2.O000000o(gci);
                gsy.O00000Oo("RNCameraFrameManager", "playerEx not null");
            } else if (!cid.O00000o) {
                cid.O00000Oo(new Callback<Void>(cid, str) {
                    /* class _m_j.fww.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ cid f17336O000000o;
                    final /* synthetic */ String O00000Oo;

                    public final void onFailure(int i, String str) {
                    }

                    {
                        this.f17336O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        gci gci = new gci(this.f17336O000000o, new gci.O000000o() {
                            /* class _m_j.fww.AnonymousClass1.AnonymousClass1 */

                            public final void O000000o(VideoFrame videoFrame) {
                                XmPluginHostApi.instance().sendCameraFrame(AnonymousClass1.this.O00000Oo, videoFrame.data, videoFrame.num, videoFrame.size, videoFrame.timeStamp, videoFrame.videoType, videoFrame.isIFrame, videoFrame.width, videoFrame.height);
                            }
                        }, this.f17336O000000o.O00000o);
                        fww.this.f17335O000000o.put(this.O00000Oo, gci);
                        fww.this.O000000o(gci);
                    }
                });
            } else {
                gci gci2 = new gci(cid, new gci.O000000o(str) {
                    /* class _m_j.fww.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String f17338O000000o;

                    {
                        this.f17338O000000o = r2;
                    }

                    public final void O000000o(VideoFrame videoFrame) {
                        XmPluginHostApi.instance().sendCameraFrame(this.f17338O000000o, videoFrame.data, videoFrame.num, videoFrame.size, videoFrame.timeStamp, videoFrame.videoType, videoFrame.isIFrame, videoFrame.width, videoFrame.height);
                    }
                }, cid.O00000o);
                O000000o2.f17335O000000o.put(str, gci2);
                O000000o2.O000000o(gci2);
            }
        }
    }

    public void stopRNCameraPlay(DeviceStat deviceStat) {
        fww O000000o2 = fww.O000000o();
        if (cid.O000000o(deviceStat, deviceStat.did) != null) {
            try {
                gsy.O00000Oo("RNCameraFrameManager", "stopPlayEx");
                gci gci = (gci) O000000o2.f17335O000000o.get(deviceStat.did);
                if (gci != null && gci.f17534O000000o != null) {
                    gsy.O00000Oo("RNCameraAllPagePlayerEx", "stopPlay");
                    try {
                        gci.O00000Oo = false;
                        gci.O00000o.O00000oO();
                        gci.f17534O000000o.pauseRN(gci);
                        gci.f17534O000000o.releaseRN(false, gci);
                        gci.f17534O000000o.setStreamClient(null);
                    } catch (Exception e) {
                        gsy.O000000o(6, "RNCameraAllPagePlayerEx", "stopPlay:" + e.getLocalizedMessage());
                    }
                }
            } catch (Exception e2) {
                gsy.O000000o(6, "RNCameraFrameManager", "JSONException:" + e2.getLocalizedMessage());
            }
        }
    }

    public void stopRequestRNCameraData(DeviceStat deviceStat) {
        fww O000000o2 = fww.O000000o();
        if (cid.O000000o(deviceStat, deviceStat.did) != null) {
            try {
                gsy.O00000Oo("RNCameraFrameManager", "stopRequestDataEx");
                gci gci = (gci) O000000o2.f17335O000000o.get(deviceStat.did);
                if (!(gci == null || gci.f17534O000000o == null)) {
                    gsy.O00000Oo("RNCameraAllPagePlayerEx", "release");
                    try {
                        gci.f17534O000000o.releaseRN(false, gci);
                        gci.O00000o0.O000O00o();
                    } catch (Exception e) {
                        gsy.O000000o(6, "RNCameraAllPagePlayerEx", "release:" + e.getLocalizedMessage());
                    }
                }
                XmPluginHostApi.instance().closeCameraFrameSender(deviceStat.did);
                O000000o2.f17335O000000o.remove(deviceStat.did);
            } catch (Exception e2) {
                gsy.O000000o(6, "RNCameraFrameManager", "JSONException:" + e2.getLocalizedMessage());
            }
        }
    }

    public void startRNCall(DeviceStat deviceStat) {
        fww O000000o2 = fww.O000000o();
        cid O000000o3 = cid.O000000o(deviceStat, deviceStat.did);
        if (O000000o3 != null) {
            try {
                gsy.O00000Oo("RNCameraFrameManager", "startRNCall");
                gci gci = (gci) O000000o2.f17335O000000o.get(deviceStat.did);
                if (gci != null) {
                    SharedPreferences sharedPreferences = gkv.f17949O000000o.getSharedPreferences("AUDIO_CONFIG_P", 0);
                    try {
                        String[] split = sharedPreferences.getString("AUDIO_CONFIG" + O000000o3.getModel(), "3#1#0#1027").split("#");
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int parseInt4 = Integer.parseInt(split[3]);
                        gci.f17534O000000o.setCallStatus(true);
                        gci.O00000o.O000000o(parseInt, parseInt2, parseInt3, parseInt4);
                        if (gci.O00000o != null) {
                            gci.O00000o.O00000Oo();
                        }
                    } catch (Exception e) {
                        cki.O00000o0("RNCameraFrameManager", "Exception:" + e.getLocalizedMessage());
                    }
                }
            } catch (Exception e2) {
                gsy.O000000o(6, "RNCameraFrameManager", "JSONException:" + e2.getLocalizedMessage());
            }
        }
    }

    public void stopRNCall(DeviceStat deviceStat) {
        fww O000000o2 = fww.O000000o();
        if (cid.O000000o(deviceStat, deviceStat.did) != null) {
            try {
                gsy.O00000Oo("RNCameraFrameManager", "stopRNCall");
                gci gci = (gci) O000000o2.f17335O000000o.get(deviceStat.did);
                if (gci != null && gci.O00000o != null) {
                    gci.O00000o.O00000o0();
                    if (cim.O000000o()) {
                        gci.O00000o.O00000o();
                    }
                    gci.f17534O000000o.setCallStatus(false);
                }
            } catch (Exception e) {
                gsy.O000000o(6, "RNCameraFrameManager", "JSONException:" + e.getLocalizedMessage());
            }
        }
    }

    public ViewManager createRNCameraViewManager() {
        return new RNCameraViewManager();
    }

    public ViewManager createHSVideoViewManager() {
        return new HSVideoViewManager();
    }

    public ViewManager createRTSPViewManager() {
        return new RTSPViewManager();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gcf.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gcf.O000000o(android.net.Uri, android.content.ContentResolver):java.lang.String
      _m_j.gcf.O000000o(com.facebook.react.bridge.WritableMap, java.lang.String):void
      _m_j.gcf.O000000o(com.xiaomi.smarthome.device.api.DeviceStat, java.lang.String):void
      _m_j.gcf.O000000o(java.lang.String, com.facebook.react.bridge.Callback):void
      _m_j.gcf.O000000o(java.lang.String, java.lang.String):void
      _m_j.gcf.O000000o(java.lang.String, int):void
      _m_j.gcf.O000000o(java.lang.String, com.xiaomi.smarthome.camera.VideoFrame):void
      _m_j.gcf.O000000o(java.lang.String, byte[]):void
      _m_j.gcg.O000000o.O000000o(java.lang.String, int):void
      _m_j.gcg.O000000o.O000000o(java.lang.String, com.xiaomi.smarthome.camera.VideoFrame):void
      _m_j.gcg.O000000o.O000000o(java.lang.String, byte[]):void
      _m_j.gcf.O000000o(java.lang.String, boolean):void */
    public void startConnect(String str, String str2) {
        gcf O000000o2 = gcf.O000000o();
        gbu.O00000o0("rncamera startconnect");
        wd.O00000o("RN_CAMERA", "startConnect:".concat(String.valueOf(str)));
        gcg gcg = O000000o2.f17513O000000o.get(str);
        if (!(gcg == null || gcg.O0000o00() == O000000o2.O00000Oo(str))) {
            O000000o2.O00000o0(str);
            gcg = null;
            wd.O00000o("RN_CAMERA", "startConnect:" + str + " firmware platform changed");
        }
        gcg gcg2 = gcg;
        boolean z = true;
        if (gcg2 == null) {
            DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(gcf.O000000o(str));
            if (deviceByDid == null) {
                wd.O00000o("RN_CAMERA", "startConnect:" + str + " get null deviceStat by parentId");
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("state", 0);
                createMap.putString("error", "1");
                gcf.O000000o(createMap, str2);
                return;
            }
            cid O000000o3 = cid.O000000o(deviceByDid, str);
            wd.O00000o("RN_CAMERA", "startConnect:" + str + " first enter");
            if (O000000o2.O00000Oo(str)) {
                wd.O00000o("RN_CAMERA", "startConnect:" + str + " miss platform");
                gcg O000000o4 = gce.O000000o(O000000o3, true);
                O000000o4.O000000o(O000000o2);
                O000000o2.f17513O000000o.put(str, O000000o4);
                O000000o2.O000000o(str, O000000o4, str2);
            } else if (DeviceModelManager.getInstance().isNeedFixedUid(str)) {
                wd.O00000o("RN_CAMERA", "huali direct connect mode: startConnect:" + O000000o3.getDid() + " tutk platform with fixed uid for hualai");
                P2PInfoImp p2PInfoImp = new P2PInfoImp();
                p2PInfoImp.setDid(O000000o3.mDeviceStat.did);
                p2PInfoImp.setModel(O000000o3.mDeviceStat.model);
                p2PInfoImp.setOnLine(O000000o3.mDeviceStat.isOnline);
                p2PInfoImp.setPwd("1234");
                p2PInfoImp.setUid(DeviceModelManager.getInstance().getHualaiFixedUid());
                O000000o3.O00000oO = p2PInfoImp;
                gcg O000000o5 = gce.O000000o(O000000o3, false);
                O000000o5.O000000o(O000000o2);
                O000000o2.f17513O000000o.put(str, O000000o5);
                O000000o2.O000000o(str, false);
                O000000o2.O000000o(str, O000000o5, str2);
            } else {
                wd.O00000o("RN_CAMERA", "startConnect:" + str + " tutk platform begin update password");
                O000000o3.O00000Oo(new Callback<Void>(str, O000000o3, str2) {
                    /* class _m_j.gcf.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String f17514O000000o;
                    final /* synthetic */ cid O00000Oo;
                    final /* synthetic */ String O00000o0;

                    {
                        this.f17514O000000o = r2;
                        this.O00000Oo = r3;
                        this.O00000o0 = r4;
                    }

                    public final void onFailure(int i, String str) {
                        wd.O00000o("RN_CAMERA", "startConnect:" + this.f17514O000000o + " tutk platform update password failed: errorCode-" + i + " errorInfo:" + str);
                        WritableMap createMap = Arguments.createMap();
                        createMap.putInt("state", 0);
                        createMap.putString("error", "1");
                        gcf.O000000o(createMap, this.O00000o0);
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.gcf.O000000o(java.lang.String, boolean):void
                     arg types: [java.lang.String, int]
                     candidates:
                      _m_j.gcf.O000000o(android.net.Uri, android.content.ContentResolver):java.lang.String
                      _m_j.gcf.O000000o(com.facebook.react.bridge.WritableMap, java.lang.String):void
                      _m_j.gcf.O000000o(com.xiaomi.smarthome.device.api.DeviceStat, java.lang.String):void
                      _m_j.gcf.O000000o(java.lang.String, com.facebook.react.bridge.Callback):void
                      _m_j.gcf.O000000o(java.lang.String, java.lang.String):void
                      _m_j.gcf.O000000o(java.lang.String, int):void
                      _m_j.gcf.O000000o(java.lang.String, com.xiaomi.smarthome.camera.VideoFrame):void
                      _m_j.gcf.O000000o(java.lang.String, byte[]):void
                      _m_j.gcg.O000000o.O000000o(java.lang.String, int):void
                      _m_j.gcg.O000000o.O000000o(java.lang.String, com.xiaomi.smarthome.camera.VideoFrame):void
                      _m_j.gcg.O000000o.O000000o(java.lang.String, byte[]):void
                      _m_j.gcf.O000000o(java.lang.String, boolean):void */
                    public final /* synthetic */ void onSuccess(Object obj) {
                        wd.O00000o("RN_CAMERA", "startConnect:" + this.f17514O000000o + " tutk platform update password success");
                        gcg O000000o2 = gce.O000000o(this.O00000Oo, false);
                        O000000o2.O000000o(gcf.this);
                        gcf.this.f17513O000000o.put(this.f17514O000000o, O000000o2);
                        gcf.this.O000000o(this.f17514O000000o, false);
                        gcf.this.O000000o(this.f17514O000000o, O000000o2, this.O00000o0);
                    }
                });
            }
        } else {
            wd.O00000o("RN_CAMERA", "startConnect:" + str + " reConnect");
            if (O000000o2.O00000Oo(str)) {
                z = false;
            } else {
                gcd gcd = O000000o2.O00000o0.get(str);
                if (gcd != null) {
                    z = gcd.O0000Oo0;
                }
            }
            if (z) {
                wd.O00000o("RN_CAMERA", "startConnect:" + str + " reConnect should update pwd");
                DeviceStat deviceByDid2 = XmPluginHostApi.instance().getDeviceByDid(gcf.O000000o(str));
                if (deviceByDid2 == null) {
                    wd.O00000o("RN_CAMERA", "startConnect:" + str + " get null deviceStat by parentId");
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putInt("state", 0);
                    createMap2.putString("error", "1");
                    gcf.O000000o(createMap2, str2);
                    return;
                }
                cid O000000o6 = cid.O000000o(deviceByDid2, str);
                O000000o6.O00000Oo(new Callback<Void>(str, gcg2, O000000o6, str2) {
                    /* class _m_j.gcf.AnonymousClass5 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String f17521O000000o;
                    final /* synthetic */ gcg O00000Oo;
                    final /* synthetic */ String O00000o;
                    final /* synthetic */ cid O00000o0;

                    {
                        this.f17521O000000o = r2;
                        this.O00000Oo = r3;
                        this.O00000o0 = r4;
                        this.O00000o = r5;
                    }

                    public final void onFailure(int i, String str) {
                        wd.O00000o("RN_CAMERA", "startConnect:" + this.f17521O000000o + " reConnect update pwd fail error:" + i + " errorInfo:" + str);
                        WritableMap createMap = Arguments.createMap();
                        createMap.putInt("state", 0);
                        createMap.putString("error", "1");
                        gcf.O000000o(createMap, this.O00000o);
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.gcf.O000000o(java.lang.String, boolean):void
                     arg types: [java.lang.String, int]
                     candidates:
                      _m_j.gcf.O000000o(android.net.Uri, android.content.ContentResolver):java.lang.String
                      _m_j.gcf.O000000o(com.facebook.react.bridge.WritableMap, java.lang.String):void
                      _m_j.gcf.O000000o(com.xiaomi.smarthome.device.api.DeviceStat, java.lang.String):void
                      _m_j.gcf.O000000o(java.lang.String, com.facebook.react.bridge.Callback):void
                      _m_j.gcf.O000000o(java.lang.String, java.lang.String):void
                      _m_j.gcf.O000000o(java.lang.String, int):void
                      _m_j.gcf.O000000o(java.lang.String, com.xiaomi.smarthome.camera.VideoFrame):void
                      _m_j.gcf.O000000o(java.lang.String, byte[]):void
                      _m_j.gcg.O000000o.O000000o(java.lang.String, int):void
                      _m_j.gcg.O000000o.O000000o(java.lang.String, com.xiaomi.smarthome.camera.VideoFrame):void
                      _m_j.gcg.O000000o.O000000o(java.lang.String, byte[]):void
                      _m_j.gcf.O000000o(java.lang.String, boolean):void */
                    public final /* synthetic */ void onSuccess(Object obj) {
                        wd.O00000o("RN_CAMERA", "startConnect:" + this.f17521O000000o + " reConnect update pwd success");
                        this.O00000Oo.O000000o(this.O00000o0.O00000oO);
                        gcf.this.O000000o(this.f17521O000000o, false);
                        gcf.this.O000000o(this.f17521O000000o, this.O00000Oo, this.O00000o);
                    }
                });
            }
            O000000o2.O000000o(str, gcg2, str2);
        }
    }

    public void sendServerCmd(String str, int i, String str2, com.facebook.react.bridge.Callback callback) {
        gcf O000000o2 = gcf.O000000o();
        gcg gcg = O000000o2.f17513O000000o.get(str);
        if (gcg != null) {
            gcg.O000000o(i, str2, new gcg.O00000Oo(callback) {
                /* class _m_j.gcf.AnonymousClass7 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ com.facebook.react.bridge.Callback f17523O000000o;

                {
                    this.f17523O000000o = r2;
                }

                public final void O000000o(String str) {
                    gcf.O000000o(str, this.f17523O000000o);
                }

                public final void O000000o(int i, String str) {
                    gcf.O00000Oo(String.valueOf(i), this.f17523O000000o);
                }
            });
        }
    }

    public void sendServerCmdWithByteArray(String str, int i, byte[] bArr, com.facebook.react.bridge.Callback callback) {
        gcf O000000o2 = gcf.O000000o();
        gcg gcg = O000000o2.f17513O000000o.get(str);
        if (gcg != null) {
            gcg.O000000o(i, bArr, new gcg.O00000Oo(callback) {
                /* class _m_j.gcf.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ com.facebook.react.bridge.Callback f17518O000000o;

                {
                    this.f17518O000000o = r2;
                }

                public final void O000000o(String str) {
                    gcf.O000000o(str, this.f17518O000000o);
                }

                public final void O000000o(int i, String str) {
                    gcf.O00000Oo(String.valueOf(i), this.f17518O000000o);
                }
            });
        }
    }

    public void release(String str) {
        gcf.O000000o().O00000o0(str);
    }

    public void bindP2PCommandReceiveWithDid(String str, String str2) {
        gcf O000000o2 = gcf.O000000o();
        gcd gcd = O000000o2.O00000o0.get(str);
        if (gcd == null) {
            gcd = new gcd();
            O000000o2.O00000o0.put(str, gcd);
        }
        gcd.O00000Oo = str2;
    }

    public void bindBpsDataCallback(String str, String str2) {
        gcf O000000o2 = gcf.O000000o();
        gcd gcd = O000000o2.O00000o0.get(str);
        if (gcd == null) {
            gcd = new gcd();
            O000000o2.O00000o0.put(str, gcd);
        }
        gcd.O00000o = str2;
    }

    public void bindRDTDataReceiveCallback(String str, String str2) {
        gcf O000000o2 = gcf.O000000o();
        gcd gcd = O000000o2.O00000o0.get(str);
        if (gcd == null) {
            gcd = new gcd();
            O000000o2.O00000o0.put(str, gcd);
        }
        gcd.O00000o0 = str2;
    }

    public void sendRDTCommandToDevice(String str, String str2, com.facebook.react.bridge.Callback callback) {
        byte[] bArr;
        gcf O000000o2 = gcf.O000000o();
        gcg gcg = O000000o2.f17513O000000o.get(str);
        if (gcg != null) {
            try {
                new JSONObject(str2);
                bArr = str2.getBytes();
            } catch (JSONException unused) {
                bArr = Base64.decode(str2, 2);
            }
            gcd gcd = O000000o2.O00000o0.get(str);
            gcg.O000000o(bArr, gcd == null ? false : gcd.O0000Oo, new gcg.O00000Oo(callback) {
                /* class _m_j.gcf.AnonymousClass6 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ com.facebook.react.bridge.Callback f17522O000000o;

                {
                    this.f17522O000000o = r2;
                }

                public final void O000000o(String str) {
                    gcf.O000000o(str, this.f17522O000000o);
                }

                public final void O000000o(int i, String str) {
                    gcf.O00000Oo(String.valueOf(i), this.f17522O000000o);
                }
            });
        }
    }

    public void getCurrentFrameInfo(String str, com.facebook.react.bridge.Callback callback) {
        gcg gcg = gcf.O000000o().f17513O000000o.get(str);
        if (gcg == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.PARAMS_ERROR, "video is not start"));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", gcg.O0000O0o());
            jSONObject.put("timestamp_ms", gcg.O0000OOo());
            jSONObject.put("isLivePlay", gcg.O0000Oo());
            jSONObject.put("moveType", gcg.O0000Oo0());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callback.invoke(Boolean.TRUE, jSONObject.toString());
    }

    public void loadMonitoringDetail(DeviceStat deviceStat, com.facebook.react.bridge.Callback callback) {
        gcf O000000o2 = gcf.O000000o();
        if (deviceStat != null) {
            cid.O000000o(deviceStat, deviceStat.did).O00000oo().getEventList("Default", 0, new Date().getTime(), new AlarmCloudCallback<ArrayList<AlarmVideo>>(callback) {
                /* class _m_j.gcf.AnonymousClass9 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ com.facebook.react.bridge.Callback f17524O000000o;

                {
                    this.f17524O000000o = r2;
                }

                /* JADX WARNING: Removed duplicated region for block: B:53:0x00bb  */
                /* JADX WARNING: Removed duplicated region for block: B:55:0x00cd  */
                public final /* synthetic */ void onSuccess(Object obj, long j, boolean z) {
                    boolean z2;
                    String str;
                    String str2;
                    ArrayList arrayList = (ArrayList) obj;
                    JSONObject jSONObject = new JSONObject();
                    if (arrayList != null && arrayList.size() > 0) {
                        AlarmVideo alarmVideo = (AlarmVideo) arrayList.get(0);
                        String[] split = alarmVideo.eventType.split(":");
                        gcf.O000000o(split);
                        if (split.length > 0) {
                            str = split[0];
                        } else {
                            str = "";
                        }
                        if (str.equals("BabyCry") || str.equals("KnownFace") || str.equals("Face") || str.equals("PeopleMotion") || str.equals("ObjectMotion") || str.equals("AI")) {
                            try {
                                jSONObject.put("eventType", str);
                                jSONObject.put("createTime", alarmVideo.createTime);
                                try {
                                    if (str.equals("KnownFace") || str.equals("Face")) {
                                        if (alarmVideo.fileIdMetaResult != null || alarmVideo.fileIdMetaResult.faceInfoMetas != null || alarmVideo.fileIdMetaResult.faceInfoMetas.size() != 0) {
                                            Iterator<FaceInfoMeta> it = alarmVideo.fileIdMetaResult.faceInfoMetas.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                FaceInfoMeta next = it.next();
                                                if (next != null && next.matched) {
                                                    str2 = next.figureName;
                                                    break;
                                                }
                                            }
                                            jSONObject.put("faceUserName", str2);
                                        }
                                        str2 = "";
                                        jSONObject.put("faceUserName", str2);
                                    }
                                    z2 = true;
                                } catch (Exception unused) {
                                    z2 = true;
                                    gbu.O00000Oo("RnCameraManager", "Exception in put ");
                                    if (!z2) {
                                    }
                                }
                            } catch (Exception unused2) {
                                z2 = false;
                                gbu.O00000Oo("RnCameraManager", "Exception in put ");
                                if (!z2) {
                                }
                            }
                            if (!z2) {
                                this.f17524O000000o.invoke(Boolean.TRUE, jSONObject.toString());
                                return;
                            }
                            this.f17524O000000o.invoke(Boolean.FALSE, "");
                            return;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                }

                public final void onFailure(int i, String str) {
                    gbu.O00000o0("onFailure" + i + "--" + str);
                    this.f17524O000000o.invoke(Boolean.FALSE, "");
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    gbu.O00000o0("onSuccess");
                }
            });
        } else if (callback != null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "empty deviceStat"));
        }
    }

    public void showAlarmVideos(DeviceStat deviceStat, int i, boolean z) {
        gcf.O000000o();
        gcf.O000000o(deviceStat, i, z);
    }

    public void showPlaybackVideos(DeviceStat deviceStat, String str) {
        gcf.O000000o();
        gcf.O000000o(deviceStat, str);
    }

    public void showCloudStorage(DeviceStat deviceStat, boolean z, boolean z2, String str) {
        ReactContext currentReactContext;
        DeviceStat deviceStat2 = deviceStat;
        gcf O000000o2 = gcf.O000000o();
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show cloud storage");
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
        } else if (deviceStat2 == null) {
            gbu.O00000Oo("empty deviceStat");
        } else {
            cid O000000o3 = cid.O000000o(deviceStat2, deviceStat2.did);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", O000000o3.getDid());
                jSONObject.put("region", Locale.getDefault().getCountry());
            } catch (Exception unused) {
            }
            XmLoadingDialog show = XmLoadingDialog.show(currentActivity, currentActivity.getString(R.string.mj_loading));
            show.show();
            XmPluginHostApi.instance().callSmartHomeApi(O000000o3.getModel(), "business.smartcamera.", "/miot/camera/app/v1/vip/status", "GET", jSONObject.toString(), new Callback<JSONObject>(currentActivity, show, O000000o3, str) {
                /* class _m_j.gcf.AnonymousClass10 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Activity f17515O000000o;
                final /* synthetic */ XmLoadingDialog O00000Oo;
                final /* synthetic */ String O00000o;
                final /* synthetic */ cid O00000o0;

                {
                    this.f17515O000000o = r2;
                    this.O00000Oo = r3;
                    this.O00000o0 = r4;
                    this.O00000o = r5;
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.gdu.O000000o(android.content.Context, java.lang.String, java.lang.String):void
                 arg types: [android.app.Activity, java.lang.String, java.lang.String]
                 candidates:
                  _m_j.gdu.O000000o(android.app.Activity, java.lang.String, java.lang.String):void
                  _m_j.gdu.O000000o(android.content.Context, java.lang.String, java.lang.String):void */
                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject optJSONObject;
                    JSONObject jSONObject = (JSONObject) obj;
                    if (!this.f17515O000000o.isFinishing()) {
                        this.O00000Oo.dismiss();
                        if (!(jSONObject == null || jSONObject.optInt("code", -1) != 0 || (optJSONObject = jSONObject.optJSONObject("data")) == null)) {
                            boolean optBoolean = optJSONObject.optBoolean("vip");
                            boolean optBoolean2 = optJSONObject.optBoolean("closeWindow");
                            if (optBoolean || !optBoolean2) {
                                fbt fbt = new fbt(this.f17515O000000o, "CloudVideoListActivity");
                                fbt.O000000o("did", this.O00000o0.getDid());
                                fbt.O000000o("is_hs_panorama_video", gce.O00000Oo);
                                if (!TextUtils.isEmpty(this.O00000o0.getName())) {
                                    fbt.O000000o("title", this.O00000o0.getName());
                                }
                                fbs.O000000o(fbt);
                                return;
                            }
                        }
                        ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o((Context) this.f17515O000000o, this.O00000o0.getDid(), this.O00000o);
                    }
                }

                public final void onFailure(int i, String str) {
                    if (!this.f17515O000000o.isFinishing()) {
                        this.O00000Oo.dismiss();
                        fbt fbt = new fbt(this.f17515O000000o, "CloudVideoListActivity");
                        fbt.O000000o("did", this.O00000o0.getDid());
                        fbt.O000000o("is_hs_panorama_video", gce.O00000Oo);
                        if (!TextUtils.isEmpty(this.O00000o0.getName())) {
                            fbt.O000000o("title", this.O00000o0.getName());
                        }
                        fbs.O000000o(fbt);
                    }
                }
            }, Parser.DEFAULT_PARSER);
            O000000o3.O00000oO().O00000oo();
        }
    }

    public void showCloudStorageSetting(DeviceStat deviceStat, String str) {
        gcf.O000000o();
        gcf.O00000Oo(deviceStat, str);
    }

    public void showAlbum(DeviceStat deviceStat, String str) {
        gcf.O000000o();
        gcf.O000000o(deviceStat);
    }

    public void showAlbumMediaFile(DeviceStat deviceStat, String str) {
        gcf.O000000o();
        gcf.O00000o0(deviceStat, str);
    }

    public void showLastAlbumMediaFile(DeviceStat deviceStat, String str) {
        gcf.O000000o();
        gcf.O00000o(deviceStat, str);
    }

    public void showOperationBannerPage(DeviceStat deviceStat, String str) {
        gcf.O000000o();
        gcf.O00000oO(deviceStat, str);
    }

    public void showFaceRecognize(DeviceStat deviceStat, boolean z, String str, String str2) {
        gcf.O000000o();
        gcf.O000000o(deviceStat, z, str, str2);
    }

    public void startRecord(String str, String str2, String str3, int i, int i2, com.facebook.react.bridge.Callback callback) {
        ReactContext currentReactContext;
        int i3;
        int i4;
        String str4 = str;
        int i5 = i;
        int i6 = i2;
        com.facebook.react.bridge.Callback callback2 = callback;
        gcf O000000o2 = gcf.O000000o();
        if (new File(str2).getParentFile() == null) {
            fkw.O00000o(str2);
        }
        gcg gcg = O000000o2.f17513O000000o.get(str4);
        if (gcg == null) {
            callback2.invoke(Boolean.FALSE, -1);
            return;
        }
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show cloud storage setting");
            callback2.invoke(Boolean.FALSE, -2);
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            callback2.invoke(Boolean.FALSE, -3);
            return;
        }
        if (i5 == 4) {
            i3 = 1;
        } else if (i5 == 5) {
            i3 = 2;
        } else {
            callback2.invoke(Boolean.FALSE, -4);
            return;
        }
        if (i6 == 0) {
            i4 = 8000;
        } else if (i6 == 3) {
            i4 = 16000;
        } else {
            callback2.invoke(Boolean.FALSE, -5);
            return;
        }
        if (gcg.O00000oO()) {
            callback2.invoke(Boolean.FALSE, -6);
        } else if (!TextUtils.isEmpty(str2)) {
            gcd gcd = O000000o2.O00000o0.get(str4);
            if (gcd == null) {
                gcd = new gcd();
                O000000o2.O00000o0.put(str4, gcd);
            }
            gcd.O00000oo = str3;
            View view = O000000o2.O00000Oo.get(str4);
            int recordingVideoWidth = (view == null || !(view instanceof AbsRNVideoView)) ? 0 : ((AbsRNVideoView) view).getRecordingVideoWidth();
            View view2 = O000000o2.O00000Oo.get(str4);
            int recordingVideoHeight = (view2 == null || !(view2 instanceof AbsRNVideoView)) ? 0 : ((AbsRNVideoView) view2).getRecordingVideoHeight();
            View view3 = O000000o2.O00000Oo.get(str4);
            if (!gcg.O000000o(str2, i3, i4, recordingVideoWidth, recordingVideoHeight, (view3 == null || !(view3 instanceof AbsRNVideoView)) ? 0 : ((AbsRNVideoView) view3).getFps())) {
                callback2.invoke(Boolean.FALSE, -10);
            } else {
                callback2.invoke(Boolean.TRUE, 0);
            }
        } else {
            hte.O000000o(currentActivity, (int) R.string.snip_video_failed);
            callback2.invoke(Boolean.FALSE, -11);
        }
    }

    public void stopRecord(String str, com.facebook.react.bridge.Callback callback) {
        ReactContext currentReactContext;
        gcf O000000o2 = gcf.O000000o();
        if (callback != null) {
            gcg gcg = O000000o2.f17513O000000o.get(str);
            if (gcg == null) {
                callback.invoke(Boolean.FALSE, 1);
                return;
            }
            ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
            if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
                gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show cloud storage setting");
                return;
            }
            Activity currentActivity = currentReactContext.getCurrentActivity();
            if (currentActivity == null) {
                callback.invoke(Boolean.FALSE, 2);
                gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            } else if (gcg.O00000oO()) {
                gcg.O000000o(new XmMp4Record.IRecordListener(callback, currentActivity) {
                    /* class _m_j.gcf.AnonymousClass11 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ com.facebook.react.bridge.Callback f17516O000000o;
                    final /* synthetic */ Activity O00000Oo;

                    {
                        this.f17516O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final void onSuccess(String str) {
                        this.f17516O000000o.invoke(Boolean.TRUE, "success");
                    }

                    public final void onFailed(int i, String str) {
                        wd.O00000o("RN_CAMERA", "录制失败：code " + i + " info:" + str);
                        this.O00000Oo.runOnUiThread(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: INVOKE  
                              (wrap: android.app.Activity : 0x001b: IGET  (r4v2 android.app.Activity) = (r2v0 'this' _m_j.gcf$11 A[THIS]) _m_j.gcf.11.O00000Oo android.app.Activity)
                              (wrap: _m_j.-$$Lambda$gcf$11$McuvRa0g4jW3OF1UdXNkc46dSzI : 0x0021: CONSTRUCTOR  (r1v2 _m_j.-$$Lambda$gcf$11$McuvRa0g4jW3OF1UdXNkc46dSzI) = 
                              (wrap: com.facebook.react.bridge.Callback : 0x001d: IGET  (r0v2 com.facebook.react.bridge.Callback) = (r2v0 'this' _m_j.gcf$11 A[THIS]) _m_j.gcf.11.O000000o com.facebook.react.bridge.Callback)
                              (r3v0 'i' int)
                             call: _m_j.-$$Lambda$gcf$11$McuvRa0g4jW3OF1UdXNkc46dSzI.<init>(com.facebook.react.bridge.Callback, int):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.app.Activity.runOnUiThread(java.lang.Runnable):void in method: _m_j.gcf.11.onFailed(int, java.lang.String):void, dex: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0021: CONSTRUCTOR  (r1v2 _m_j.-$$Lambda$gcf$11$McuvRa0g4jW3OF1UdXNkc46dSzI) = 
                              (wrap: com.facebook.react.bridge.Callback : 0x001d: IGET  (r0v2 com.facebook.react.bridge.Callback) = (r2v0 'this' _m_j.gcf$11 A[THIS]) _m_j.gcf.11.O000000o com.facebook.react.bridge.Callback)
                              (r3v0 'i' int)
                             call: _m_j.-$$Lambda$gcf$11$McuvRa0g4jW3OF1UdXNkc46dSzI.<init>(com.facebook.react.bridge.Callback, int):void type: CONSTRUCTOR in method: _m_j.gcf.11.onFailed(int, java.lang.String):void, dex: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 83 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$gcf$11$McuvRa0g4jW3OF1UdXNkc46dSzI, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 89 more
                            */
                        /*
                            this = this;
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            java.lang.String r1 = "录制失败：code "
                            r0.<init>(r1)
                            r0.append(r3)
                            java.lang.String r1 = " info:"
                            r0.append(r1)
                            r0.append(r4)
                            java.lang.String r4 = r0.toString()
                            java.lang.String r0 = "RN_CAMERA"
                            _m_j.wd.O00000o(r0, r4)
                            android.app.Activity r4 = r2.O00000Oo
                            com.facebook.react.bridge.Callback r0 = r2.f17516O000000o
                            _m_j.-$$Lambda$gcf$11$McuvRa0g4jW3OF1UdXNkc46dSzI r1 = new _m_j.-$$Lambda$gcf$11$McuvRa0g4jW3OF1UdXNkc46dSzI
                            r1.<init>(r0, r3)
                            r4.runOnUiThread(r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: _m_j.gcf.AnonymousClass11.onFailed(int, java.lang.String):void");
                    }
                });
            }
        }
    }

    public void snapShot(String str, String str2, com.facebook.react.bridge.Callback callback) {
        gcf.O000000o().O000000o(str, str2, callback);
    }

    public void downloadM3U8ToMP4(String str, String str2, String str3, boolean z, String str4, String str5, String str6) {
        final String str7 = str6;
        clf.O000000o().O000000o(str, str2, str3, z, str4, str5, false, new clf.O000000o() {
            /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass1 */

            public void onStart() {
                fyc.O00000Oo("RNCameraApiImpl", "downloadM3U8ToMP4 onStart");
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("state", "onStart");
                        createMap.putString("errorInfo", "");
                        createMap.putInt("progress", 0);
                        gcf.O000000o();
                        gcf.O000000o(createMap, str7);
                    }
                });
            }

            public void onComplete() {
                fyc.O00000Oo("RNCameraApiImpl", "downloadM3U8ToMP4 onComplete");
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass1.AnonymousClass2 */

                    public void run() {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("state", "onComplete");
                        createMap.putString("errorInfo", "");
                        createMap.putInt("progress", 100);
                        gcf.O000000o();
                        gcf.O000000o(createMap, str7);
                    }
                });
            }

            public void onError(final int i, final String str) {
                fyc.O00000Oo("RNCameraApiImpl", "downloadM3U8ToMP4 onProgress onError = code:" + i + " errInfo:" + str);
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass1.AnonymousClass3 */

                    public void run() {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("state", "onError");
                        createMap.putString("errorInfo", "code:" + i + " errInfo:" + str);
                        createMap.putInt("progress", 0);
                        gcf.O000000o();
                        gcf.O000000o(createMap, str7);
                    }
                });
            }

            public void onProgress(final int i) {
                fyc.O00000Oo("RNCameraApiImpl", "downloadM3U8ToMP4 onProgress progress = ".concat(String.valueOf(i)));
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass1.AnonymousClass4 */

                    public void run() {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("state", "onProgress");
                        createMap.putString("errorInfo", "");
                        createMap.putInt("progress", i);
                        gcf.O000000o();
                        gcf.O000000o(createMap, str7);
                    }
                });
            }
        });
    }

    public void downloadM3U8ToMP4V2(String str, String str2, final String str3, boolean z, String str4, String str5, boolean z2, String str6) {
        final String str7 = str6;
        AnonymousClass2 r8 = new clf.O000000o() {
            /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass2 */

            public void onStart() {
                fyc.O00000Oo("RNCameraApiImpl", "downloadM3U8ToMP4 onStart");
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass2.AnonymousClass1 */

                    public void run() {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("state", "onStart");
                        createMap.putString("errorInfo", "");
                        createMap.putString("fileId", str3);
                        createMap.putInt("progress", 0);
                        gcf.O000000o();
                        gcf.O000000o(createMap, str7);
                    }
                });
            }

            public void onComplete() {
                fyc.O00000Oo("RNCameraApiImpl", "downloadM3U8ToMP4 onComplete");
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass2.AnonymousClass2 */

                    public void run() {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("state", "onComplete");
                        createMap.putString("fileId", str3);
                        createMap.putString("errorInfo", "");
                        createMap.putInt("progress", 100);
                        gcf.O000000o();
                        gcf.O000000o(createMap, str7);
                    }
                });
            }

            public void onError(final int i, final String str) {
                fyc.O00000Oo("RNCameraApiImpl", "downloadM3U8ToMP4 onProgress onError = code:" + i + " errInfo:" + str);
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass2.AnonymousClass3 */

                    public void run() {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("state", "onError");
                        createMap.putString("errorInfo", "code:" + i + " errInfo:" + str);
                        createMap.putString("fileId", str3);
                        createMap.putInt("progress", 0);
                        gcf.O000000o();
                        gcf.O000000o(createMap, str7);
                    }
                });
            }

            public void onProgress(final int i) {
                fyc.O00000Oo("RNCameraApiImpl", "downloadM3U8ToMP4 onProgress progress = ".concat(String.valueOf(i)));
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass2.AnonymousClass4 */

                    public void run() {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("state", "onProgress");
                        createMap.putString("errorInfo", "");
                        createMap.putString("fileId", str3);
                        createMap.putInt("progress", i);
                        gcf.O000000o();
                        gcf.O000000o(createMap, str7);
                    }
                });
            }
        };
        clf.O000000o().O000000o(str, str2, str3, z, str4, str5, z2, r8);
    }

    public void cancelDownloadM3U8ToMP4V2(String str, String str2, final String str3, boolean z, final String str4) {
        String str5 = str3;
        String str6 = str4;
        boolean z2 = z;
        String str7 = str2;
        XmPluginHostApi.instance().cancelDownloadFile(str5, str6, z2, str7, new ICloudDataCallback(new clf.O000000o() {
            /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass3 */

            public void onProgress(int i) {
            }

            public void onStart() {
            }

            public void onComplete() {
                fyc.O00000Oo("RNCameraApiImpl", "cancelDownloadM3U8ToMP4V2 onComplete");
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass3.AnonymousClass1 */

                    public void run() {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("state", "onComplete");
                        createMap.putString("fileId", str3);
                        gcf.O000000o();
                        gcf.O000000o(createMap, str4);
                    }
                });
            }

            public void onError(final int i, final String str) {
                fyc.O00000Oo("RNCameraApiImpl", "cancelDownloadM3U8ToMP4V2 onProgress onError = code:" + i + " errInfo:" + str);
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass3.AnonymousClass2 */

                    public void run() {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("state", "onError");
                        createMap.putString("errorInfo", "code:" + i + " errInfo:" + str);
                        createMap.putString("fileId", str3);
                        gcf.O000000o();
                        gcf.O000000o(createMap, str4);
                    }
                });
            }
        }) {
            /* class _m_j.clf.AnonymousClass10 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O000000o f14038O000000o;

            public final void onCloudDataProgress(int i) {
            }

            {
                this.f14038O000000o = r2;
            }

            public final void onCloudDataSuccess(Object obj, Object obj2) {
                O000000o o000000o = this.f14038O000000o;
                if (o000000o != null) {
                    o000000o.onComplete();
                }
            }

            public final void onCloudDataFailed(int i, String str) {
                O000000o o000000o = this.f14038O000000o;
                if (o000000o != null) {
                    o000000o.onError(i, str);
                }
            }
        });
    }

    public String getVideoSnapshotUrl(String str, String str2, String str3) {
        return AlarmCloudManager.getVideoSnapshotUrl(str, str2, str3);
    }

    public String getFaceImg(String str, String str2, String str3) {
        return AlarmCloudManager.getFaceImg(str, str2, str3);
    }

    public void setTimelinePlaybackMode(String str, boolean z) {
        gcg gcg;
        gcf O000000o2 = gcf.O000000o();
        if (!TextUtils.isEmpty(str) && (gcg = O000000o2.f17513O000000o.get(str)) != null) {
            gcg.O00000Oo(z);
        }
    }

    public void bindTimelinePlaybackEndListener(String str, String str2) {
        gcf O000000o2 = gcf.O000000o();
        if (!TextUtils.isEmpty(str)) {
            gcd gcd = O000000o2.O00000o0.get(str);
            if (gcd == null) {
                gcd = new gcd();
                O000000o2.O00000o0.put(str, gcd);
            }
            gcd.O0000OOo = str2;
        }
    }

    public int getCurrentSpeakerVolume(String str) {
        gcg gcg;
        gcf O000000o2 = gcf.O000000o();
        if (!TextUtils.isEmpty(str) && (gcg = O000000o2.f17513O000000o.get(str)) != null) {
            return gcg.O0000Ooo();
        }
        return 0;
    }

    public void setCurrentDeviceIsMissFirmware(String str, boolean z) {
        gcf O000000o2 = gcf.O000000o();
        if (!TextUtils.isEmpty(str)) {
            gcd gcd = O000000o2.O00000o0.get(str);
            if (gcd == null) {
                gcd = new gcd();
                O000000o2.O00000o0.put(str, gcd);
            }
            gcd.O00000oO = z;
        }
    }

    public void showNASSettingPage(DeviceStat deviceStat) {
        ReactContext currentReactContext;
        gcf O000000o2 = gcf.O000000o();
        ReactInstanceManager instanceManager = hmq.O00000o0().getInstanceManager();
        if (instanceManager == null || (currentReactContext = instanceManager.getCurrentReactContext()) == null) {
            gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show alarm videos");
            return;
        }
        Activity currentActivity = currentReactContext.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            gbu.O00000Oo("the activity to which the reactContext currently attached is null");
            return;
        }
        XmLoadingDialog show = XmLoadingDialog.show(currentActivity, currentActivity.getString(R.string.mj_loading));
        show.show();
        if (deviceStat == null) {
            gbu.O00000Oo("empty device stat");
        } else {
            cid.O000000o(deviceStat, deviceStat.did).O0000oO0().O000000o(new Callback<NASInfo>(currentActivity, show, deviceStat, DeviceConstant.isNewPlayback(deviceStat.model)) {
                /* class _m_j.gcf.AnonymousClass12 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Activity f17517O000000o;
                final /* synthetic */ XmLoadingDialog O00000Oo;
                final /* synthetic */ boolean O00000o;
                final /* synthetic */ DeviceStat O00000o0;

                {
                    this.f17517O000000o = r2;
                    this.O00000Oo = r3;
                    this.O00000o0 = r4;
                    this.O00000o = r5;
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
                public final /* synthetic */ void onSuccess(Object obj) {
                    NASInfo nASInfo = (NASInfo) obj;
                    if (!this.f17517O000000o.isFinishing()) {
                        this.O00000Oo.dismiss();
                        if (nASInfo == null || nASInfo.O00000o == 0) {
                            Intent intent = new Intent();
                            intent.setClass(this.f17517O000000o, ((gdu) gdv.f17570O000000o.getUiInterface()).O0000o());
                            intent.putExtra("extra_device_did", this.O00000o0.did);
                            intent.putExtra("is_v4", this.O00000o);
                            this.f17517O000000o.startActivity(intent);
                            return;
                        }
                        Intent intent2 = new Intent();
                        intent2.setClass(this.f17517O000000o, ((gdu) gdv.f17570O000000o.getUiInterface()).O0000o0o());
                        intent2.putExtra("extra_device_did", this.O00000o0.did);
                        intent2.putExtra("is_v4", this.O00000o);
                        intent2.putExtra("is_from_rn", true);
                        intent2.putExtra("nasInfo", nASInfo);
                        this.f17517O000000o.startActivity(intent2);
                    }
                }

                public final void onFailure(int i, String str) {
                    if (!this.f17517O000000o.isFinishing()) {
                        this.O00000Oo.dismiss();
                        hte.O000000o(this.f17517O000000o, (int) R.string.retrieve_data_fail);
                    }
                }
            });
        }
    }

    public void openFloatWindow(String str, com.facebook.react.bridge.Callback callback) {
        gcf.O000000o();
        gcf.O00000o0(str, callback);
    }

    public void decryptBigFile(String str, String str2, String str3, com.facebook.react.bridge.Callback callback) {
        if (callback != null) {
            DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str3);
            if (deviceByDid == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "query deviceStat is null"));
                return;
            }
            XmP2PInfo xmP2PInfo = cid.O000000o(deviceByDid, deviceByDid.did).O00000oO;
            if (xmP2PInfo == null || xmP2PInfo.getShareKey() == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "query shareKey from mijiacameraDevice is null"));
                return;
            }
            try {
                callback.invoke(Boolean.TRUE, Base64.encode(DecryptUtil.decryptBigFile(Base64.decode(str, 2), Base64.decode(str2, 2), xmP2PInfo.getShareKey()), 2));
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.getMessage()));
            }
        }
    }

    public void decryptSmallFile(String str, String str2, String str3, com.facebook.react.bridge.Callback callback) {
        if (callback != null && callback != null) {
            DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str3);
            if (deviceByDid == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "query deviceStat is null"));
                return;
            }
            XmP2PInfo xmP2PInfo = cid.O000000o(deviceByDid, deviceByDid.did).O00000oO;
            if (xmP2PInfo == null || xmP2PInfo.getShareKey() == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "query shareKey from mijiacameraDevice is null"));
                return;
            }
            try {
                callback.invoke(Boolean.TRUE, Base64.encode(DecryptUtil.decryptSmallFile(Base64.decode(str, 2), Base64.decode(str2, 2), xmP2PInfo.getShareKey()), 2));
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.getMessage()));
            }
        }
    }

    public void markCurrrentDeviceRdtDataEncrypted(boolean z, String str) {
        if (!TextUtils.isEmpty(str)) {
            gcf O000000o2 = gcf.O000000o();
            gcd gcd = O000000o2.O00000o0.get(str);
            if (gcd == null) {
                gcd = new gcd();
                O000000o2.O00000o0.put(str, gcd);
            }
            gcd.O0000Oo = z;
        }
    }

    public void setGeneralIjkPlayerEnable(boolean z, String str) {
        gce.f17512O000000o = z;
    }

    public void setHSVideoEnable(boolean z, String str) {
        gce.O00000Oo = z;
    }

    public void markCurrentDeviceHualaiEncrypted(boolean z, String str) {
        gcg gcg;
        if (!TextUtils.isEmpty(str) && (gcg = gcf.O000000o().f17513O000000o.get(str)) != null) {
            gcg.O00000o0(z);
        }
    }

    public void setCurrentDeviceUseFixedRdtChannel(boolean z, String str) {
        gcg gcg;
        if (!TextUtils.isEmpty(str) && (gcg = gcf.O000000o().f17513O000000o.get(str)) != null) {
            gcg.O00000o(z);
        }
    }

    public void setCurrentVoiceChangerType(int i, int i2, int i3, String str) {
        gcg gcg;
        if (!TextUtils.isEmpty(str) && (gcg = gcf.O000000o().f17513O000000o.get(str)) != null) {
            gcg.O000000o(i, i2, i3);
        }
    }

    public void openCloudSettingDownloadListPage(Activity activity, String str) {
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (activity != null && deviceByDid != null) {
            Intent intent = new Intent();
            intent.putExtra("did", deviceByDid.did);
            intent.putExtra("title", deviceByDid.name);
            intent.putExtra("is_hs_panorama_video", gce.O00000Oo);
            intent.setClass(activity, ((gdu) gdv.f17570O000000o.getUiInterface()).O00000Oo());
            intent.putExtra("uid", deviceByDid.userId);
            activity.startActivity(intent);
        }
    }

    public void convertG711VideoIntoAACVideo(String str, ReadableMap readableMap, com.facebook.react.bridge.Callback callback) {
        final int i;
        final int i2;
        final int i3;
        String str2;
        int i4;
        int i5;
        int i6 = 16000;
        if (readableMap != null) {
            i3 = (!readableMap.hasKey("sampleRate") || (i5 = readableMap.getInt("sampleRate")) == 0 || i5 != 3) ? 8000 : 16000;
            if (readableMap.hasKey("bitRate")) {
                int i7 = readableMap.getInt("bitRate");
                if (i7 == 0) {
                    i6 = 8000;
                } else if (i7 != 1 && i7 == 2) {
                    i6 = 32000;
                }
            }
            if (!readableMap.hasKey("channel") || (i4 = readableMap.getInt("channel")) == 0 || i4 != 1) {
                i = i6;
                i2 = 1;
            } else {
                i = i6;
                i2 = 2;
            }
        } else {
            i3 = 8000;
            i2 = 1;
            i = 16000;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
        } else {
            str2 = str;
        }
        if (TextUtils.isEmpty(str2)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "invalid file path, has no postFix name"));
            return;
        }
        final File file = new File(str);
        final File file2 = new File(str2 + ".g711");
        final String str3 = str2;
        final String str4 = str;
        final com.facebook.react.bridge.Callback callback2 = callback;
        goq.O00000oO(new Runnable() {
            /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass4 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
             arg types: [int, java.lang.String]
             candidates:
              _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
              _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
              _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
            public void run() {
                if (mk.O000000o(str3, file, file2, i3, i2, i)) {
                    File file = new File(str4);
                    if (file.delete() && file2.renameTo(file)) {
                        callback2.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) "convert video file success"));
                    } else {
                        callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "convert video file success but rename failed"));
                    }
                } else {
                    callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "convert video file failed please check logcat with filter g711"));
                }
            }
        });
    }

    public void convertH26xVideoIntoMp4(int i, String str, String str2, String str3, ReadableMap readableMap, com.facebook.react.bridge.Callback callback) {
        if (i == 4 || i == 5) {
            final String str4 = str;
            final int i2 = i;
            final String str5 = str3;
            final String str6 = str2;
            final com.facebook.react.bridge.Callback callback2 = callback;
            goq.O00000o(new Runnable() {
                /* class com.xiaomi.smarthome.camera.api.RNCameraApiImpl.AnonymousClass5 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
                 arg types: [int, java.lang.String]
                 candidates:
                  _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
                  _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
                  _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
                public void run() {
                    try {
                        String str = str4;
                        int i = i2;
                        String str2 = str5;
                        String str3 = str6;
                        if (!TextUtils.isEmpty(str)) {
                            if (!TextUtils.isEmpty(str3)) {
                                jip jip = null;
                                if (i == 4) {
                                    jiu jiu = new jiu(new jhz(str));
                                    if (!TextUtils.isEmpty(str2)) {
                                        jip = new jip(new jhz(str2));
                                    }
                                    jib jib = new jib();
                                    jib.O000000o(jiu);
                                    if (jip != null) {
                                        jib.O000000o(jip);
                                    }
                                    jha O000000o2 = new jii().O000000o(jib);
                                    FileChannel channel = new FileOutputStream(new File(str3)).getChannel();
                                    O000000o2.writeContainer(channel);
                                    channel.close();
                                } else if (i == 5) {
                                    MediaRemuxing.remuxing(CommonApplication.getAppContext(), str, str3);
                                } else {
                                    throw new Exception("invalid videoCodec");
                                }
                            }
                        }
                        callback2.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) "convert success"));
                    } catch (Exception e) {
                        callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, e.getMessage()));
                    }
                }
            });
            return;
        }
        callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "invalid video codec"));
    }

    public boolean inRNExoSoftDecodeList() {
        return ckr.O000000o();
    }

    public byte[] encodeG711(byte[] bArr, int i, int i2) {
        return G711.encode(bArr, i, i2);
    }

    public int decodeG711(byte[] bArr, int i, int i2, byte[] bArr2) {
        return G711.decode(bArr, i, i2, bArr2);
    }

    public void clearRNCameraFactory() {
        gce.O000000o();
    }

    public void setFrameFilter(String str, List<Integer> list, String str2) {
        gcf O000000o2 = gcf.O000000o();
        gcd gcd = O000000o2.O00000o0.get(str);
        if (gcd == null) {
            gcd = new gcd();
            O000000o2.O00000o0.put(str, gcd);
        }
        gcd.O0000Ooo = list;
        gcd.O0000OoO = str2;
    }

    public void cancleFrameFilter(String str) {
        gcd gcd = gcf.O000000o().O00000o0.get(str);
        if (gcd != null) {
            gcd.O0000Ooo = null;
            gcd.O0000OoO = null;
        }
    }

    public void callTutkSpecialCmd(String str, String str2, com.facebook.react.bridge.Callback callback) {
        gcf O000000o2 = gcf.O000000o();
        gcg gcg = O000000o2.f17513O000000o.get(str2);
        if (gcg != null) {
            gcg.O000000o(str, new gcg.O00000Oo(callback) {
                /* class _m_j.gcf.AnonymousClass3 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ com.facebook.react.bridge.Callback f17519O000000o;

                {
                    this.f17519O000000o = r2;
                }

                public final void O000000o(String str) {
                    com.facebook.react.bridge.Callback callback = this.f17519O000000o;
                    if (callback != null) {
                        callback.invoke(Boolean.TRUE, str);
                    }
                }

                public final void O000000o(int i, String str) {
                    com.facebook.react.bridge.Callback callback = this.f17519O000000o;
                    if (callback != null) {
                        callback.invoke(Boolean.FALSE, Integer.valueOf(i));
                    }
                }
            });
        } else if (callback != null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "get empty cameraPlayer"));
        }
    }

    public void sendAudioData(String str, String str2, int i, String str3, com.facebook.react.bridge.Callback callback) {
        gcf O000000o2 = gcf.O000000o();
        gcg gcg = O000000o2.f17513O000000o.get(str3);
        if (gcg != null) {
            gcg.O000000o(str, i, new gcg.O00000Oo(callback) {
                /* class _m_j.gcf.AnonymousClass4 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ com.facebook.react.bridge.Callback f17520O000000o;

                {
                    this.f17520O000000o = r2;
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
                 arg types: [int, java.lang.String]
                 candidates:
                  _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
                  _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
                  _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
                public final void O000000o(String str) {
                    com.facebook.react.bridge.Callback callback = this.f17520O000000o;
                    if (callback != null) {
                        callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) str));
                    }
                }

                public final void O000000o(int i, String str) {
                    com.facebook.react.bridge.Callback callback = this.f17520O000000o;
                    if (callback != null) {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(i, str));
                    }
                }
            });
        }
    }

    public void bindMoveTypeChangeCallback(String str, String str2) {
        gcf O000000o2 = gcf.O000000o();
        gcd gcd = O000000o2.O00000o0.get(str);
        if (gcd == null) {
            gcd = new gcd();
            O000000o2.O00000o0.put(str, gcd);
        }
        gcd.O0000o00 = str2;
    }
}

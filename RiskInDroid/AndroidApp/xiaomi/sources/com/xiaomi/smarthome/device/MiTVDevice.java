package com.xiaomi.smarthome.device;

import _m_j.fmo;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.ftt;
import _m_j.fuc;
import _m_j.goq;
import _m_j.gsy;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.MitvDeviceRecommendManager;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import org.json.JSONObject;

public class MiTVDevice extends MiioDeviceV2 {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f6971O000000o = "MiTVDevice";
    static int O00000Oo = 1;
    public String active_mac = "";
    String fw_version = "";
    public boolean isLocalSearchDevice = false;
    int mIndex;
    volatile boolean mIsAliveChecking = false;
    boolean mIsStatusUpdated = false;
    boolean mIsUpdateRecommend = false;
    public int mLocalStatus = 0;
    Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        /* class com.xiaomi.smarthome.device.MiTVDevice.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                gsy.O00000Oo(MiTVDevice.f6971O000000o, "handleMessage time out");
                MiTVDevice.this.location = Device.Location.REMOTE;
            } else if (i == 2) {
                gsy.O00000Oo(MiTVDevice.f6971O000000o, "handleMessage ok");
                MiTVDevice.this.location = Device.Location.LOCAL;
                MiTVDevice.this.isOnline = true;
            }
        }
    };
    MitvDeviceRecommendManager.O000000o mMiTVRecommend;
    public MitvDeviceRecommendManager.MiTVRecommendItem mMiTVRecommendItem;
    int mPlatformId;
    public int mShowOfflineDialog = 1;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public Bitmap f6978O000000o;
        public String O00000Oo;
    }

    public void initialLocal() {
    }

    public MiTVDevice() {
        this.canUseNotBind = true;
        this.canAuth = false;
    }

    public void parseExtra(String str) {
        super.parseExtra(str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.active_mac = jSONObject.optString("active_mac");
                if (!TextUtils.isEmpty(this.active_mac)) {
                    this.active_mac = this.active_mac.toLowerCase();
                }
                this.fw_version = jSONObject.optString("fw_version");
                this.mPlatformId = jSONObject.optInt("platform");
            } catch (Exception unused) {
            }
        }
    }

    public final void O000000o(final String str) {
        if (!this.mIsAliveChecking) {
            this.mIsAliveChecking = true;
            try {
                goq.O000000o(new Runnable() {
                    /* class com.xiaomi.smarthome.device.MiTVDevice.AnonymousClass2 */

                    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
                        r0 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
                        r4 = com.xiaomi.smarthome.device.MiTVDevice.f6971O000000o;
                        _m_j.gsy.O00000Oo(r4, "Connect to server success2" + r2);
                        r7.O00000Oo.mMainHandler.sendEmptyMessage(1);
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0094, code lost:
                        r7.O00000Oo.mIsAliveChecking = false;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0098, code lost:
                        if (r3 != null) goto L_0x009a;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
                        r3.close();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009e, code lost:
                        throw r0;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
                        return;
                     */
                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0070 */
                    public final void run() {
                        SocketChannel socketChannel = null;
                        SocketChannel open = SocketChannel.open();
                        open.configureBlocking(false);
                        open.connect(new InetSocketAddress(str, 6095));
                        int i = 0;
                        while (i < 5 && !open.finishConnect()) {
                            i++;
                            Thread.sleep(50);
                        }
                        if (i == 5) {
                            String str = MiTVDevice.f6971O000000o;
                            gsy.O00000Oo(str, "Connect to server failed2!" + str);
                            MiTVDevice.this.mMainHandler.sendEmptyMessage(1);
                        } else {
                            String str2 = MiTVDevice.f6971O000000o;
                            gsy.O00000Oo(str2, "Connect to server success2" + str);
                            MiTVDevice.this.mMainHandler.sendEmptyMessage(2);
                        }
                        MiTVDevice.this.mIsAliveChecking = false;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setLaunchParams(Intent intent) {
        super.setLaunchParams(intent);
        if (intent != null && this.location == Device.Location.LOCAL && MitvDeviceRecommendManager.O000000o().O00000oo != null) {
            intent.putExtra("newPictureFile", MitvDeviceRecommendManager.O000000o().O00000oo);
            MitvDeviceRecommendManager O000000o2 = MitvDeviceRecommendManager.O000000o();
            O000000o2.O00000oo = null;
            O000000o2.O00000oO = System.currentTimeMillis() / 1000;
            PreferenceManager.getDefaultSharedPreferences(CommonApplication.getAppContext()).edit().putLong("pref_last_scan_time", O000000o2.O00000oO).apply();
        }
    }

    public final CharSequence O000000o(Context context) {
        int size;
        if (!this.mIsStatusUpdated) {
            O000000o(this.ip);
            this.mIsStatusUpdated = true;
        }
        if (this.mLocalStatus == 3) {
            return context.getString(R.string.offline_device);
        }
        if (this.location == Device.Location.LOCAL && MitvDeviceRecommendManager.O000000o().O00000oo != null) {
            return context.getString(R.string.mitv_new_picture_title);
        }
        if (this.mMiTVRecommendItem == null) {
            if (this.mIsUpdateRecommend) {
                MitvDeviceRecommendManager O000000o2 = MitvDeviceRecommendManager.O000000o();
                MitvDeviceRecommendManager.O000000o o000000o = O000000o2.O00000o0.get(this.did);
                if (o000000o == null) {
                    o000000o = O000000o2.O00000o.get(this.model);
                }
                this.mMiTVRecommend = o000000o;
            } else {
                this.mIsUpdateRecommend = true;
                MitvDeviceRecommendManager O000000o3 = MitvDeviceRecommendManager.O000000o();
                O000000o3.O00000Oo();
                MitvDeviceRecommendManager.O000000o o000000o2 = O000000o3.O00000o0.get(this.did);
                if (o000000o2 == null) {
                    o000000o2 = O000000o3.O00000o.get(this.model);
                }
                if (o000000o2 == null && !O000000o3.f6979O000000o) {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
                        Device device = (Device) value.getValue();
                        if (device instanceof MiTVDevice) {
                            arrayList.add(device.did);
                        }
                    }
                    if (arrayList.size() != 0) {
                        O000000o3.f6979O000000o = true;
                        CommonApplication.getGlobalWorkerHandler().post(new Runnable(arrayList) {
                            /* class com.xiaomi.smarthome.device.MitvDeviceRecommendManager.AnonymousClass2 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ ArrayList f6981O000000o;

                            {
                                this.f6981O000000o = r2;
                            }

                            public final void run() {
                                fuc.O000000o().O000000o(CommonApplication.getAppContext(), this.f6981O000000o, new fsm<JSONObject, fso>() {
                                    /* class com.xiaomi.smarthome.device.MitvDeviceRecommendManager.AnonymousClass2.AnonymousClass1 */

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        MitvDeviceRecommendManager.this.f6979O000000o = false;
                                        if (jSONObject != null) {
                                            try {
                                                FileOutputStream openFileOutput = CommonApplication.getAppContext().openFileOutput("mitv_recommend", 0);
                                                DataOutputStream dataOutputStream = new DataOutputStream(openFileOutput);
                                                byte[] bytes = jSONObject.toString().getBytes("UTF-8");
                                                dataOutputStream.writeLong(new Date().getTime());
                                                dataOutputStream.writeInt(bytes.length);
                                                dataOutputStream.write(bytes);
                                                openFileOutput.close();
                                            } catch (Exception unused) {
                                            }
                                            MitvDeviceRecommendManager.this.O000000o(jSONObject);
                                            ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                        }
                                    }

                                    public final void onFailure(fso fso) {
                                        MitvDeviceRecommendManager.this.f6979O000000o = false;
                                    }
                                });
                            }
                        });
                    }
                }
                this.mMiTVRecommend = o000000o2;
            }
            this.mIndex = (int) (Math.random() * 100.0d);
            MitvDeviceRecommendManager.O000000o o000000o3 = this.mMiTVRecommend;
            if (o000000o3 != null && (size = o000000o3.O00000o0.size()) > 0) {
                try {
                    this.mMiTVRecommendItem = this.mMiTVRecommend.O00000o0.get(this.mIndex % size);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        MitvDeviceRecommendManager.MiTVRecommendItem miTVRecommendItem = this.mMiTVRecommendItem;
        return miTVRecommendItem != null ? miTVRecommendItem.O00000oO : "";
    }

    public boolean isLocal() {
        return this.location == Device.Location.LOCAL;
    }

    public final boolean O000000o() {
        if (!TextUtils.isEmpty(this.fw_version) && this.fw_version.compareTo("16777496") >= 0) {
            return true;
        }
        return false;
    }

    public final void O000000o(Context context, final fmo fmo) {
        DeviceRouterFactory.getDeviceHelper().bindMiTVDevice(context, this, new ftt<Void>() {
            /* class com.xiaomi.smarthome.device.MiTVDevice.AnonymousClass4 */

            public final void O000000o(int i) {
                fmo fmo = fmo;
                if (fmo != null) {
                    fmo.O00000Oo();
                }
            }

            public final void O000000o(int i, Object obj) {
                fmo fmo = fmo;
                if (fmo != null) {
                    fmo.O00000Oo();
                }
            }

            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                fmo fmo = fmo;
                if (fmo != null) {
                    fmo.O000000o();
                }
            }
        });
    }
}

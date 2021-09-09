package com.xiaomi.smarthome.framework.update;

import _m_j.fap;
import _m_j.fat;
import _m_j.feo;
import _m_j.fes;
import _m_j.fgo;
import _m_j.flu;
import _m_j.fpo;
import _m_j.gfk;
import _m_j.gfl;
import _m_j.gfr;
import _m_j.gmc;
import _m_j.gsy;
import _m_j.hxi;
import _m_j.hxt;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothDevice;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfo;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.McuUpdateInfo;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.log.LogType;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class BleUpgradePresenter extends gfl {
    public static int O0000oO0 = 4;

    /* renamed from: O000000o  reason: collision with root package name */
    public Device f8642O000000o;
    public BleMeshFirmwareUpdateInfo O00000Oo;
    public gfk O00000o;
    public volatile boolean O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo = null;
    public long O0000Oo = -1;
    public long O0000Oo0 = -1;
    public long O0000OoO = -1;
    public String O0000Ooo;
    public int O0000o = -1;
    public Handler O0000o0 = new Handler(Looper.getMainLooper()) {
        /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 1 && BleUpgradePresenter.this.O0000o00 < 60) {
                BleUpgradePresenter.this.O0000o00++;
                BleUpgradePresenter.this.O00000o.showProgress(BleUpgradePresenter.this.O0000o00);
                BleUpgradePresenter.this.O0000o0.sendEmptyMessageDelayed(1, 1000);
            }
        }
    };
    public int O0000o00 = -1;
    public int O0000o0O;
    public Map<Integer, Long> O0000o0o = new HashMap();
    private int O0000oOO;
    private String O0000oOo;
    private Context O0000oo;
    private boolean O0000oo0 = true;

    public static void O000000o(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        gsy.O00000o0(LogType.OTA, "Ble-OTA", str);
    }

    public BleUpgradePresenter(Context context, gfk gfk, int i, Device device, String str, String str2, String str3) {
        String str4 = null;
        this.O0000oo = context;
        this.O00000o = gfk;
        this.f8642O000000o = device;
        this.O0000O0o = device.model;
        this.O0000o0O = i;
        this.O0000Ooo = this.f8642O000000o.version;
        this.O00000oO = URLUtil.isNetworkUrl(str) ? str : str4;
        this.O0000oOo = str2;
        this.O00000oo = str3;
        this.O0000oo0 = !O00000o0();
        if (O000000o()) {
            this.O00000Oo = new BleMeshFirmwareUpdateInfo();
            BleMeshFirmwareUpdateInfo bleMeshFirmwareUpdateInfo = this.O00000Oo;
            bleMeshFirmwareUpdateInfo.version = str2;
            bleMeshFirmwareUpdateInfo.safeUrl = str;
            bleMeshFirmwareUpdateInfo.md5 = str3;
        }
        O000000o("ble ota presenter model %s,testVersion name %s, file md5 %s,test Url %s", this.O0000O0o, str2, str3, str);
    }

    public final boolean O000000o() {
        return !TextUtils.isEmpty(this.O00000oO) && URLUtil.isNetworkUrl(this.O00000oO);
    }

    public final void O00000Oo() {
        this.O0000Oo0 = System.currentTimeMillis();
        Observable.just(this.f8642O000000o).observeOn(Schedulers.io()).flatMap(new Function<Device, ObservableSource<Boolean>>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass25 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                return BleUpgradePresenter.this.O000000o((Device) obj);
            }
        }).flatMap(new Function<Boolean, ObservableSource<String>>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass24 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                long currentTimeMillis = System.currentTimeMillis() - BleUpgradePresenter.this.O0000Oo0;
                BleUpgradePresenter.this.O0000Oo0 = System.currentTimeMillis();
                BleUpgradePresenter.this.O0000o0o.put(1, Long.valueOf(currentTimeMillis));
                gfk gfk = BleUpgradePresenter.this.O00000o;
                gfk.showLog("设备连接时间" + (currentTimeMillis / 1000) + "秒");
                BleUpgradePresenter bleUpgradePresenter = BleUpgradePresenter.this;
                fat fat = fat.O000000o.f16039O000000o;
                bleUpgradePresenter.O0000OOo = fat.O000000o(BleUpgradePresenter.this.f8642O000000o.mac);
                BleUpgradePresenter bleUpgradePresenter2 = BleUpgradePresenter.this;
                return Observable.create(new ObservableOnSubscribe<String>(bleUpgradePresenter2.f8642O000000o) {
                    /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass18 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ Device f8652O000000o;

                    {
                        this.f8652O000000o = r2;
                    }

                    public final void subscribe(final ObservableEmitter<String> observableEmitter) throws Exception {
                        XmBluetoothManager.getInstance().getBleMeshFirmwareVersion(this.f8652O000000o.mac, new Response.BleReadFirmwareVersionResponse() {
                            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass18.AnonymousClass1 */

                            public final /* synthetic */ void onResponse(int i, Object obj) {
                                String str = (String) obj;
                                if (i == 0) {
                                    BleUpgradePresenter.O000000o("ota read ble version %s", str);
                                    AnonymousClass18.this.f8652O000000o.version = str;
                                    BleUpgradePresenter.this.O0000Ooo = str;
                                    observableEmitter.onNext(str);
                                    observableEmitter.onComplete();
                                    return;
                                }
                                BleUpgradePresenter.O000000o(String.format("read version error, code:%d", Integer.valueOf(i)), new Object[0]);
                                observableEmitter.onError(new OTAException(-200, "read firmware version fail,code=".concat(String.valueOf(i))));
                            }
                        });
                    }
                });
            }
        }).flatMap(new Function<String, ObservableSource<Boolean>>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass23 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                long currentTimeMillis = System.currentTimeMillis() - BleUpgradePresenter.this.O0000Oo0;
                BleUpgradePresenter.this.O0000Oo0 = System.currentTimeMillis();
                BleUpgradePresenter.this.O0000o0o.put(2, Long.valueOf(currentTimeMillis));
                gfk gfk = BleUpgradePresenter.this.O00000o;
                gfk.showLog("读取固件版本号时间" + (currentTimeMillis / 1000) + "秒");
                BleUpgradePresenter bleUpgradePresenter = BleUpgradePresenter.this;
                return Observable.create(new ObservableOnSubscribe<Boolean>(bleUpgradePresenter.f8642O000000o) {
                    /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass20 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ Device f8658O000000o;

                    {
                        this.f8658O000000o = r2;
                    }

                    public final void subscribe(final ObservableEmitter<Boolean> observableEmitter) throws Exception {
                        XmPluginHostApi.instance().getBleMeshFirmwareUpdateInfo(this.f8658O000000o.model, this.f8658O000000o.did, new Callback<BleMeshFirmwareUpdateInfo>() {
                            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass20.AnonymousClass1 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                BleMeshFirmwareUpdateInfo bleMeshFirmwareUpdateInfo = (BleMeshFirmwareUpdateInfo) obj;
                                if (bleMeshFirmwareUpdateInfo != null) {
                                    BleUpgradePresenter.O000000o("ota read online version ,update info =" + bleMeshFirmwareUpdateInfo.toString(), new Object[0]);
                                    BleUpgradePresenter.this.O00000Oo = bleMeshFirmwareUpdateInfo;
                                    if (BleUpgradePresenter.this.O00000Oo.mcuUpdateInfo != null) {
                                        BleUpgradePresenter.this.O00000Oo.mcuUpdateInfo.currentMcuVersion = BleUpgradePresenter.this.O0000OOo;
                                    }
                                    observableEmitter.onNext(Boolean.TRUE);
                                    observableEmitter.onComplete();
                                    return;
                                }
                                observableEmitter.onError(new OTAException(1));
                            }

                            public final void onFailure(int i, String str) {
                                BleUpgradePresenter.O000000o(String.format("requestUpdateInfo error, error code: %d ,errorMsg: %s", Integer.valueOf(i), str), new Object[0]);
                                ObservableEmitter observableEmitter = observableEmitter;
                                observableEmitter.onError(new OTAException(-201, i + ":" + str));
                            }
                        });
                    }
                });
            }
        }).subscribe(new Observer<Boolean>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass12 */

            public final /* bridge */ /* synthetic */ void onNext(Object obj) {
            }

            public final void onSubscribe(Disposable disposable) {
            }

            public final void onError(Throwable th) {
                if (th instanceof OTAException) {
                    int code = ((OTAException) th).getCode();
                    hxt hxt = hxi.O0000Oo;
                    String str = BleUpgradePresenter.this.O0000O0o;
                    String message = th.getMessage();
                    if (!hxt.O000000o(str) && !flu.O00000oO().O00000o0() && !gfr.f17662O000000o) {
                        hxt.f960O000000o.O000000o("ble_update_result", "model", str, "errorcode", Integer.valueOf(code), "desc", message);
                    }
                    BleUpgradePresenter.this.O00000o.onCheckFail(code);
                    BleUpgradePresenter.O000000o("checkIfNeedUpdate,code=".concat(String.valueOf(code)), new Object[0]);
                    return;
                }
                BleUpgradePresenter.O000000o("checkIfNeedUpdate error:" + Log.getStackTraceString(th), new Object[0]);
                BleUpgradePresenter.this.O00000o.onCheckFail(-1);
            }

            public final void onComplete() {
                long currentTimeMillis = System.currentTimeMillis() - BleUpgradePresenter.this.O0000Oo0;
                BleUpgradePresenter bleUpgradePresenter = BleUpgradePresenter.this;
                bleUpgradePresenter.O0000Oo0 = -1;
                gfk gfk = bleUpgradePresenter.O00000o;
                gfk.showLog("读取远程版本号时间" + (currentTimeMillis / 1000) + "秒");
                BleUpgradePresenter.this.O0000o0o.put(3, Long.valueOf(currentTimeMillis));
                BleUpgradePresenter.this.O00000o.checkBleUpdateInfo(BleUpgradePresenter.this.O0000Ooo, BleUpgradePresenter.this.O00000Oo);
            }
        });
    }

    public final boolean O00000o0() {
        return XmBluetoothManager.getInstance().getConnectStatus(this.f8642O000000o.mac) == 2;
    }

    public final boolean O00000o() {
        BleMeshFirmwareUpdateInfo bleMeshFirmwareUpdateInfo = this.O00000Oo;
        if (bleMeshFirmwareUpdateInfo == null || fpo.O000000o(bleMeshFirmwareUpdateInfo.version, this.O0000Ooo) <= 0) {
            return false;
        }
        return true;
    }

    public final Observable<Boolean> O000000o(final Device device) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass8 */

            public final void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                if (BleUpgradePresenter.this.O00000o0()) {
                    BleUpgradePresenter.O000000o("ble Connect:already connected", new Object[0]);
                    observableEmitter.onNext(Boolean.TRUE);
                    observableEmitter.onComplete();
                    return;
                }
                BleUpgradePresenter bleUpgradePresenter = BleUpgradePresenter.this;
                bleUpgradePresenter.O000000o(device, bleUpgradePresenter.O0000o0O, observableEmitter);
            }
        });
    }

    public final void O000000o(final Device device, int i, final ObservableEmitter<Boolean> observableEmitter) {
        final String str = device.mac;
        if (i == 0) {
            XmBluetoothManager.getInstance().secureConnect(str, new Response.BleConnectResponse() {
                /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass9 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    if (-10 == i) {
                        XmBluetoothManager.getInstance().removeToken(str);
                        BleUpgradePresenter.this.O000000o(device, 0, observableEmitter);
                    } else if (i == 0) {
                        observableEmitter.onNext(Boolean.TRUE);
                        observableEmitter.onComplete();
                    } else {
                        BleUpgradePresenter.O000000o(String.format("%s ,connect  fail,secureConnect, error code %d", "Ble-OTA", Integer.valueOf(i)), new Object[0]);
                        String O000000o2 = gmc.O000000o(i);
                        gfk gfk = BleUpgradePresenter.this.O00000o;
                        gfk.showLog("blue tooth error: code " + i + ",msg:" + O000000o2);
                        ObservableEmitter observableEmitter = observableEmitter;
                        observableEmitter.onError(new OTAException(i, i + ":" + O000000o2));
                    }
                }
            });
        } else if (i == 1) {
            XmBluetoothManager.getInstance().securityChipConnect(str, new Response.BleConnectResponse() {
                /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass10 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    if (i == 0) {
                        observableEmitter.onNext(Boolean.TRUE);
                        observableEmitter.onComplete();
                        return;
                    }
                    BleUpgradePresenter.O000000o(String.format("%s ,connect fail,securityChipConnect, error code %d", "Ble-OTA", Integer.valueOf(i)), new Object[0]);
                    String O000000o2 = gmc.O000000o(i);
                    gfk gfk = BleUpgradePresenter.this.O00000o;
                    gfk.showLog("blue tooth error: code " + i + ",msg:" + O000000o2);
                    ObservableEmitter observableEmitter = observableEmitter;
                    observableEmitter.onError(new OTAException(i, i + ":" + O000000o2));
                }
            });
        } else if (i == 2) {
            XmBluetoothManager.getInstance().securityChipSharedDeviceConnect(str, new Response.BleConnectResponse() {
                /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass11 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    if (i == 0) {
                        observableEmitter.onNext(Boolean.TRUE);
                        observableEmitter.onComplete();
                        return;
                    }
                    BleUpgradePresenter.O000000o(String.format("%s ,connect fail,securityChipSharedDeviceConnect, error code %d", "Ble-OTA", Integer.valueOf(i)), new Object[0]);
                    String O000000o2 = gmc.O000000o(i);
                    gfk gfk = BleUpgradePresenter.this.O00000o;
                    gfk.showLog("blue tooth error: code " + i + ",msg:" + O000000o2);
                    ObservableEmitter observableEmitter = observableEmitter;
                    observableEmitter.onError(new OTAException(i, i + ":" + O000000o2));
                }
            });
        } else if (i == 3) {
            XmBluetoothManager.getInstance().connect(str, new Response.BleConnectResponse() {
                /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass13 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    if (i == 0) {
                        observableEmitter.onNext(Boolean.TRUE);
                        observableEmitter.onComplete();
                        return;
                    }
                    BleUpgradePresenter.O000000o(String.format("%s ,connect  fail,normal connect, error code %d", "Ble-OTA", Integer.valueOf(i)), new Object[0]);
                    String O000000o2 = gmc.O000000o(i);
                    gfk gfk = BleUpgradePresenter.this.O00000o;
                    gfk.showLog("blue tooth error: code " + i + ",msg:" + O000000o2);
                    ObservableEmitter observableEmitter = observableEmitter;
                    observableEmitter.onError(new OTAException(i, i + ":" + O000000o2));
                }
            });
        } else if (i == 4) {
            XmBluetoothManager.getInstance().bleStandardAuthConnect(str, new Response.BleConnectResponse() {
                /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass14 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    if (i == 0) {
                        observableEmitter.onNext(Boolean.TRUE);
                        observableEmitter.onComplete();
                        return;
                    }
                    BleUpgradePresenter.O000000o(String.format("%s ,connect fail,bleStandardAuth connect, error code %d", "Ble-OTA", Integer.valueOf(i)), new Object[0]);
                    String O000000o2 = gmc.O000000o(i);
                    gfk gfk = BleUpgradePresenter.this.O00000o;
                    gfk.showLog("blue tooth error: code " + i + ",msg:" + O000000o2);
                    ObservableEmitter observableEmitter = observableEmitter;
                    observableEmitter.onError(new OTAException(i, i + ":" + O000000o2));
                }
            });
        } else if (i == 5) {
            XmBluetoothManager.getInstance().bleMeshConnect(str, device.did, new Response.BleConnectResponse() {
                /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass15 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    if (i == 0) {
                        observableEmitter.onNext(Boolean.TRUE);
                        observableEmitter.onComplete();
                        return;
                    }
                    BleUpgradePresenter.O000000o(String.format("%s ,connect fail,bleMesh connect, error code %d", "Ble-OTA", Integer.valueOf(i)), new Object[0]);
                    String O000000o2 = gmc.O000000o(i);
                    gfk gfk = BleUpgradePresenter.this.O00000o;
                    gfk.showLog("blue tooth error: code " + i + ",msg:" + O000000o2);
                    ObservableEmitter observableEmitter = observableEmitter;
                    observableEmitter.onError(new OTAException(i, i + ":" + O000000o2));
                }
            });
        }
    }

    public final Observable<Boolean> O00000oO() {
        return Observable.create(new ObservableOnSubscribe<Boolean>(false) {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass17 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ boolean f8651O000000o = false;

            public final void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                observableEmitter.onNext(Boolean.valueOf(this.f8651O000000o));
                observableEmitter.onComplete();
            }
        });
    }

    public final Observable<String> O00000oo() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass19 */

            public final void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                BleUpgradePresenter.O000000o("create null observable", new Object[0]);
                observableEmitter.onNext("");
                observableEmitter.onComplete();
            }
        });
    }

    static class DeviceNoFoundException extends Exception {
        DeviceNoFoundException(String str) {
            super(str);
        }
    }

    public final synchronized void O000000o(int i) {
        this.O0000oOO = i;
    }

    private synchronized int O0000Oo0() {
        return this.O0000oOO;
    }

    public final void O0000O0o() {
        this.O00000o0 = true;
        int O0000Oo02 = O0000Oo0();
        if (O0000Oo02 != 1) {
            if (O0000Oo02 == 2) {
                O000000o("onDestroy cancelBleMeshUpgrade", new Object[0]);
                XmBluetoothManager.getInstance().cancelBleMeshUpgrade(this.f8642O000000o.mac);
            }
            O000000o("onDestroy", new Object[0]);
        } else if (this.O00000Oo != null) {
            XmPluginHostApi.instance().cancelDownloadBleFirmware(TextUtils.isEmpty(this.O00000oO) ? this.O00000Oo.safeUrl : this.O00000oO);
            O000000o("onDestroy cancelDownloadBleFirmware", new Object[0]);
        }
        if (this.O0000oo0) {
            XmBluetoothManager.getInstance().disconnect(this.f8642O000000o.mac);
        }
        fap.O000000o.f16027O000000o.O000000o(this.f8642O000000o.mac).O000000o(false);
    }

    public final boolean O0000OOo() {
        return O0000Oo0() != 0;
    }

    public final void O000000o(final BleMeshFirmwareUpdateInfo bleMeshFirmwareUpdateInfo) {
        fap.O000000o.f16027O000000o.O000000o(this.f8642O000000o.mac).O000000o(true);
        final long currentTimeMillis = System.currentTimeMillis();
        this.O00000o.onUpgrading();
        if (bleMeshFirmwareUpdateInfo != null && this.O00000Oo == null) {
            this.O00000Oo = bleMeshFirmwareUpdateInfo;
        }
        Observable.just(this.f8642O000000o).observeOn(Schedulers.io()).flatMap(new Function<Device, ObservableSource<Boolean>>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass5 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                return BleUpgradePresenter.this.O000000o((Device) obj);
            }
        }).flatMap(new Function<Boolean, ObservableSource<String>>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass4 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                McuUpdateInfo mcuUpdateInfo = bleMeshFirmwareUpdateInfo.mcuUpdateInfo;
                if (mcuUpdateInfo != null) {
                    BleUpgradePresenter bleUpgradePresenter = BleUpgradePresenter.this;
                    if ((bleUpgradePresenter.O00000Oo == null || bleUpgradePresenter.O00000Oo.mcuUpdateInfo == null || fpo.O000000o(bleUpgradePresenter.O00000Oo.mcuUpdateInfo.version, bleUpgradePresenter.O00000Oo.mcuUpdateInfo.currentMcuVersion) <= 0) ? false : true) {
                        return Observable.create(new ObservableOnSubscribe<String>(mcuUpdateInfo.url, mcuUpdateInfo.md5) {
                            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass7 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ String f8680O000000o;
                            final /* synthetic */ String O00000Oo;

                            {
                                this.f8680O000000o = r2;
                                this.O00000Oo = r3;
                            }

                            public final void subscribe(final ObservableEmitter<String> observableEmitter) throws Exception {
                                BleUpgradePresenter.O000000o("start download mcu firmware,mcuUrl=%s,fileMd5=%s", this.f8680O000000o, this.O00000Oo);
                                BleUpgradePresenter.this.O000000o(this.f8680O000000o, new Response.FirmwareUpgradeResponse() {
                                    /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass7.AnonymousClass1 */

                                    public final void onResponse(int i, String str, String str2) {
                                        if (i != 0 || TextUtils.isEmpty(str)) {
                                            observableEmitter.onError(new OTAException(-606));
                                        } else if (TextUtils.isEmpty(AnonymousClass7.this.O00000Oo) || TextUtils.equals(AnonymousClass7.this.O00000Oo, str2)) {
                                            observableEmitter.onNext(str);
                                            observableEmitter.onComplete();
                                        } else {
                                            observableEmitter.onError(new OTAException(-607));
                                        }
                                    }

                                    public final void onProgress(int i) {
                                        BleUpgradePresenter.O000000o("download mcu firmware progress =".concat(String.valueOf(i)), new Object[0]);
                                    }
                                });
                            }
                        });
                    }
                }
                BleUpgradePresenter.O000000o("mcuUpdateInfo is null or current mcu version latest, no need mcu upgrade", new Object[0]);
                return BleUpgradePresenter.this.O00000oo();
            }
        }).flatMap(new Function<String, ObservableSource<String>>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass3 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    return BleUpgradePresenter.this.O00000oo();
                }
                return Observable.create(new ObservableOnSubscribe<String>(str) {
                    /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass6 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String f8678O000000o;

                    {
                        this.f8678O000000o = r2;
                    }

                    public final void subscribe(final ObservableEmitter<String> observableEmitter) throws Exception {
                        if (!new File(this.f8678O000000o).exists()) {
                            BleUpgradePresenter.O000000o("local mcu file not exist", new Object[0]);
                            observableEmitter.onError(new OTAException(-608));
                            return;
                        }
                        McuUpdateInfo mcuUpdateInfo = BleUpgradePresenter.this.O00000Oo.mcuUpdateInfo;
                        final boolean O00000o = BleUpgradePresenter.this.O00000o();
                        final int i = 40;
                        if (!O00000o) {
                            i = 100;
                        }
                        BleUpgradePresenter.O000000o("startMcuUpgrade, current mcu version %s, currentFirmware Version %s", mcuUpdateInfo.currentMcuVersion, BleUpgradePresenter.this.O0000Ooo);
                        XmBluetoothManager.getInstance().startMcuUpgrade(BleUpgradePresenter.this.f8642O000000o.mac, mcuUpdateInfo.currentMcuVersion, BleUpgradePresenter.this.O0000Ooo, O00000o, this.f8678O000000o, BleUpgradePresenter.this.O00000Oo.timeout, new Response.BleUpgradeResponse() {
                            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass6.AnonymousClass1 */

                            public final /* synthetic */ void onResponse(int i, Object obj) {
                                String str = (String) obj;
                                if (i == 0) {
                                    BleUpgradePresenter.O000000o("mcu upgrade success!", new Object[0]);
                                    BleUpgradePresenter.this.O0000o0.removeMessages(1);
                                    observableEmitter.onNext("not empty");
                                    observableEmitter.onComplete();
                                } else if (i != 4) {
                                    BleUpgradePresenter.O000000o("mcu upgrade fail, code=%d,msg =%s", Integer.valueOf(i), str);
                                    observableEmitter.onError(new OTAException(i, str));
                                } else if (O00000o) {
                                    BleUpgradePresenter.this.O0000o00 = 40;
                                    BleUpgradePresenter.this.O0000o0.sendEmptyMessageDelayed(1, 1500);
                                } else {
                                    BleUpgradePresenter.this.O00000o.onInstalling();
                                }
                            }

                            public final void onProgress(int i) {
                                BleUpgradePresenter.O000000o("send mcu data ,progress=".concat(String.valueOf(i)), new Object[0]);
                                if (i > 0 && i < 100) {
                                    BleUpgradePresenter.this.O00000o.showProgress((i * i) / 100);
                                }
                            }

                            public final boolean isMeshDevice() {
                                return BleUpgradePresenter.this.O0000o0O == 5;
                            }
                        });
                    }
                });
            }
        }).flatMap(new Function<String, ObservableSource<String>>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass2 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis > 1000) {
                    BleUpgradePresenter.this.O0000o0o.put(1, Long.valueOf(currentTimeMillis));
                }
                return Observable.create(new ObservableOnSubscribe<String>() {
                    /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass2.AnonymousClass1 */

                    public final void subscribe(final ObservableEmitter<String> observableEmitter) throws Exception {
                        BleUpgradePresenter.O000000o("start downloadFirmware ", new Object[0]);
                        if (BleUpgradePresenter.this.O00000o0) {
                            observableEmitter.onError(new OTAException(2));
                        } else if (BleUpgradePresenter.this.O00000Oo != null || BleUpgradePresenter.this.O000000o()) {
                            BleUpgradePresenter.this.O000000o(1);
                            BleUpgradePresenter.this.O0000oO = 1;
                            String str = TextUtils.isEmpty(BleUpgradePresenter.this.O00000oO) ? BleUpgradePresenter.this.O00000Oo.safeUrl : BleUpgradePresenter.this.O00000oO;
                            if (TextUtils.isEmpty(str)) {
                                BleUpgradePresenter.O000000o("start download Firmware,but url is null!", new Object[0]);
                                observableEmitter.onError(new OTAException(-303));
                                return;
                            }
                            final long currentTimeMillis = System.currentTimeMillis();
                            BleUpgradePresenter.this.O000000o(str, new Response.FirmwareUpgradeResponse() {
                                /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                public final void onResponse(int i, String str, String str2) {
                                    String str3 = BleUpgradePresenter.this.O000000o() ? BleUpgradePresenter.this.O00000oo : BleUpgradePresenter.this.O00000Oo.md5;
                                    BleUpgradePresenter.O000000o("download firmware ,remote md5 %s,download fileMd5 %s", str3, str2);
                                    if (i != 0 || TextUtils.isEmpty(str)) {
                                        BleUpgradePresenter.O000000o(String.format("downloadFirmware failed,error code: %d , path: %s", Integer.valueOf(i), str), new Object[0]);
                                        observableEmitter.onError(new OTAException(-301));
                                        return;
                                    }
                                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                                    gfk gfk = BleUpgradePresenter.this.O00000o;
                                    gfk.showLog("下载固件时间" + (currentTimeMillis / 1000) + "秒");
                                    File file = new File(str);
                                    if (file.exists()) {
                                        gfk gfk2 = BleUpgradePresenter.this.O00000o;
                                        gfk2.showLog("固件大小" + (file.length() / 1024) + "kb");
                                    }
                                    if (str3 == null || (!TextUtils.isEmpty(str3) && str3.equals(str2))) {
                                        observableEmitter.onNext(str);
                                        observableEmitter.onComplete();
                                        BleUpgradePresenter.this.O00000o.showLog("固件md5 校验通过");
                                        BleUpgradePresenter.this.O0000o0o.put(4, Long.valueOf(currentTimeMillis));
                                        return;
                                    }
                                    observableEmitter.onError(new OTAException(-302));
                                }

                                public final void onProgress(int i) {
                                    BleUpgradePresenter.O000000o("downloadFirmware,progress:".concat(String.valueOf(i)), new Object[0]);
                                }
                            });
                        } else {
                            observableEmitter.onError(new OTAException(1));
                        }
                    }
                });
            }
        }).flatMap(new Function<String, ObservableSource<Boolean>>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass29 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                final String str = (String) obj;
                if (new File(str).exists()) {
                    return Observable.create(new ObservableOnSubscribe<Boolean>() {
                        /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass29.AnonymousClass1 */

                        public final void subscribe(final ObservableEmitter<Boolean> observableEmitter) throws Exception {
                            if (!BleUpgradePresenter.this.O00000o()) {
                                BleUpgradePresenter.O000000o("current firmware version(%s) is latest, and no need firmware upgrade ", BleUpgradePresenter.this.O0000Ooo);
                                observableEmitter.onNext(Boolean.FALSE);
                                observableEmitter.onComplete();
                                return;
                            }
                            BleUpgradePresenter.O000000o("startBleMeshUpgrade ", new Object[0]);
                            if (BleUpgradePresenter.this.O00000o0) {
                                observableEmitter.onError(new OTAException(2));
                                return;
                            }
                            BleUpgradePresenter.this.O000000o(2);
                            BleUpgradePresenter.this.O0000Oo = System.currentTimeMillis();
                            final int i = 100;
                            if (BleUpgradePresenter.this.O0000o00 > 0) {
                                i = 100 - BleUpgradePresenter.this.O0000o00;
                            }
                            XmBluetoothManager.getInstance().startBleMeshUpgrade(BleUpgradePresenter.this.f8642O000000o.mac, BleUpgradePresenter.this.f8642O000000o.did, BleUpgradePresenter.this.O0000Ooo, str, new Response.BleUpgradeResponse() {
                                /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass29.AnonymousClass1.AnonymousClass1 */

                                public final void onProgress(int i) {
                                    if (BleUpgradePresenter.this.O0000o != i) {
                                        BleUpgradePresenter.this.O0000o = i;
                                        BleUpgradePresenter.O000000o("startBleMeshUpgrade, progress:".concat(String.valueOf(i)), new Object[0]);
                                        if (i <= 100) {
                                            int i2 = i;
                                            BleUpgradePresenter.this.O00000o.showProgress((100 - i2) + ((i2 * i) / 100));
                                        }
                                        if (i == 100) {
                                            BleUpgradePresenter.this.O00000o.onInstalling();
                                        }
                                        if (BleUpgradePresenter.this.O0000Oo > 0 && i > 99) {
                                            long currentTimeMillis = System.currentTimeMillis() - BleUpgradePresenter.this.O0000Oo;
                                            BleUpgradePresenter.this.O0000Oo = -1;
                                            gfk gfk = BleUpgradePresenter.this.O00000o;
                                            gfk.showLog("ota 固件传输成功到开始切换固件耗时：" + (currentTimeMillis / 1000) + "秒");
                                            BleUpgradePresenter.this.O0000o0o.put(5, Long.valueOf(currentTimeMillis));
                                            BleUpgradePresenter.this.O0000OoO = System.currentTimeMillis();
                                        }
                                    }
                                }

                                public final boolean isMeshDevice() {
                                    return BleUpgradePresenter.this.O0000o0O == 5;
                                }

                                public final /* synthetic */ void onResponse(int i, Object obj) {
                                    BleUpgradePresenter.this.O000000o(0);
                                    if (i == 0) {
                                        observableEmitter.onNext(Boolean.TRUE);
                                        observableEmitter.onComplete();
                                        return;
                                    }
                                    String format = String.format("upgrade error,error code:%d", Integer.valueOf(i));
                                    BleUpgradePresenter.O000000o(format, new Object[0]);
                                    observableEmitter.onError(new OTAException(i, format));
                                }
                            });
                        }
                    });
                }
                throw new Exception("upgrade file not exist.");
            }
        }).flatMap(new Function<Boolean, ObservableSource<Boolean>>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass28 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                if (!((Boolean) obj).booleanValue()) {
                    return BleUpgradePresenter.this.O00000oO();
                }
                BleUpgradePresenter bleUpgradePresenter = BleUpgradePresenter.this;
                return Observable.create(new ObservableOnSubscribe<Boolean>(bleUpgradePresenter.f8642O000000o) {
                    /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass16 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ Device f8650O000000o;

                    {
                        this.f8650O000000o = r2;
                    }

                    public final void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                        if (!BleUpgradePresenter.this.O00000o0()) {
                            BleUpgradePresenter.O000000o("disconnect:already disconnected", new Object[0]);
                        } else {
                            BleUpgradePresenter.O000000o("start disconnect", new Object[0]);
                            XmBluetoothManager.getInstance().disconnect(this.f8650O000000o.mac);
                        }
                        observableEmitter.onNext(Boolean.TRUE);
                        observableEmitter.onComplete();
                    }
                });
            }
        }).delay(5, TimeUnit.SECONDS).flatMap(new Function<Boolean, ObservableSource<Boolean>>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass27 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                if (!((Boolean) obj).booleanValue()) {
                    return BleUpgradePresenter.this.O00000oO();
                }
                BleUpgradePresenter bleUpgradePresenter = BleUpgradePresenter.this;
                Device device = bleUpgradePresenter.f8642O000000o;
                if (bleUpgradePresenter.O00000Oo == null || bleUpgradePresenter.O00000Oo.timeout <= 32) {
                    BleUpgradePresenter.O0000oO0 = 4;
                } else {
                    BleUpgradePresenter.O0000oO0 = bleUpgradePresenter.O00000Oo.timeout / 8;
                }
                BleUpgradePresenter.O000000o("firmware install retry count = " + BleUpgradePresenter.O0000oO0, new Object[0]);
                return Observable.create(new ObservableOnSubscribe<Boolean>(device) {
                    /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass22 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    public AtomicBoolean f8663O000000o = new AtomicBoolean(false);
                    final /* synthetic */ Device O00000Oo;

                    {
                        this.O00000Oo = r2;
                    }

                    public final void subscribe(final ObservableEmitter<Boolean> observableEmitter) throws Exception {
                        XmBluetoothManager.getInstance().startScan(5000, 1, new XmBluetoothManager.BluetoothSearchResponse() {
                            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass22.AnonymousClass1 */

                            public final void onSearchStarted() {
                                BleUpgradePresenter.O000000o("onSearchStarted: start search", new Object[0]);
                            }

                            public final void onDeviceFounded(XmBluetoothDevice xmBluetoothDevice) {
                                if (AnonymousClass22.this.f8663O000000o.get()) {
                                    BleUpgradePresenter.O000000o("onDeviceFounded: device already found,just ignore", new Object[0]);
                                } else if (xmBluetoothDevice != null && xmBluetoothDevice.device != null && !TextUtils.isEmpty(AnonymousClass22.this.O00000Oo.mac) && AnonymousClass22.this.O00000Oo.mac.equalsIgnoreCase(xmBluetoothDevice.device.getAddress())) {
                                    AnonymousClass22.this.f8663O000000o.set(true);
                                    if (!(BleUpgradePresenter.this.O00000Oo == null || BleUpgradePresenter.this.f8642O000000o == null)) {
                                        fgo.O00000Oo(BleUpgradePresenter.this.f8642O000000o.did, BleUpgradePresenter.this.O00000Oo.version, new feo<Void, fes>() {
                                            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass22.AnonymousClass1.AnonymousClass1 */

                                            public final void O000000o(fes fes) {
                                                String str;
                                                StringBuilder sb = new StringBuilder("report ble firmware version fail, ");
                                                if (fes != null) {
                                                    str = fes.O00000Oo;
                                                } else {
                                                    str = "no detail message";
                                                }
                                                sb.append(str);
                                                BleUpgradePresenter.O000000o(sb.toString(), new Object[0]);
                                            }

                                            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                                                BleUpgradePresenter.O000000o("report ble firmware version success", new Object[0]);
                                            }
                                        });
                                        BleUpgradePresenter.O000000o("found device success, report ble firmware version=%s, did=%s", BleUpgradePresenter.this.O00000Oo.version, BleUpgradePresenter.this.f8642O000000o.did);
                                    }
                                    if (BleUpgradePresenter.this.O0000OoO > 0) {
                                        long currentTimeMillis = System.currentTimeMillis() - BleUpgradePresenter.this.O0000OoO;
                                        gfk gfk = BleUpgradePresenter.this.O00000o;
                                        gfk.showLog("切换固件激活耗时：" + (currentTimeMillis / 1000) + "秒");
                                        BleUpgradePresenter.this.O0000o0o.put(6, Long.valueOf(currentTimeMillis));
                                    }
                                    BleUpgradePresenter.O000000o("onDeviceFounded: device found, upgrade success", new Object[0]);
                                    XmBluetoothManager.getInstance().stopScan();
                                    if (!observableEmitter.isDisposed()) {
                                        observableEmitter.onNext(Boolean.TRUE);
                                        observableEmitter.onComplete();
                                    }
                                }
                            }

                            public final void onSearchStopped() {
                                if (!AnonymousClass22.this.f8663O000000o.get()) {
                                    BleUpgradePresenter.O000000o("onSearchStopped: haven't found target device yet", new Object[0]);
                                    observableEmitter.onError(new DeviceNoFoundException("onSearchStopped,haven't found target device yet"));
                                }
                            }

                            public final void onSearchCanceled() {
                                if (!AnonymousClass22.this.f8663O000000o.get()) {
                                    BleUpgradePresenter.O000000o("onSearchCanceled: haven't found target device yet", new Object[0]);
                                    observableEmitter.onError(new DeviceNoFoundException("onSearchCanceled,haven't found target device yet"));
                                }
                            }
                        });
                    }
                }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
                    /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass21 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    public AtomicInteger f8660O000000o = new AtomicInteger(BleUpgradePresenter.O0000oO0);

                    public final /* synthetic */ Object apply(Object obj) throws Exception {
                        return ((Observable) obj).takeWhile(new Predicate<Throwable>() {
                            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass21.AnonymousClass2 */

                            public final /* synthetic */ boolean test(Object obj) throws Exception {
                                Throwable th = (Throwable) obj;
                                if ((th instanceof DeviceNoFoundException) && AnonymousClass21.this.f8660O000000o.getAndDecrement() > 0) {
                                    return true;
                                }
                                throw new Exception(th.getCause());
                            }
                        }).flatMap(new Function<Throwable, ObservableSource<?>>() {
                            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass21.AnonymousClass1 */

                            public final /* synthetic */ Object apply(Object obj) throws Exception {
                                BleUpgradePresenter.O000000o("retry startScan after 3 seconds", new Object[0]);
                                return Observable.timer(3, TimeUnit.SECONDS);
                            }
                        });
                    }
                });
            }
        }).subscribe(new Observer<Boolean>() {
            /* class com.xiaomi.smarthome.framework.update.BleUpgradePresenter.AnonymousClass26 */

            public final /* bridge */ /* synthetic */ void onNext(Object obj) {
            }

            public final void onSubscribe(Disposable disposable) {
            }

            public final void onError(Throwable th) {
                BleUpgradePresenter.this.O000000o(0);
                if (th instanceof OTAException) {
                    int code = ((OTAException) th).getCode();
                    BleUpgradePresenter.O000000o("start upgrade failed ,code =".concat(String.valueOf(code)), new Object[0]);
                    hxi.O0000Oo.O00000o0(BleUpgradePresenter.this.O0000O0o, code);
                    BleUpgradePresenter.this.O00000o.onUpgradeFail(code);
                } else {
                    BleUpgradePresenter.this.O00000o.onUpgradeFail(-1);
                }
                BleUpgradePresenter.O000000o("start upgrade failed, error msg:" + th.getMessage(), new Object[0]);
                BleUpgradePresenter.this.O00000o.showLog(th.getMessage());
            }

            public final void onComplete() {
                BleUpgradePresenter.this.O000000o(0);
                BleUpgradePresenter.O000000o("upgrade finished.", new Object[0]);
                BleUpgradePresenter.this.O00000o.onSuccess();
                BleUpgradePresenter bleUpgradePresenter = BleUpgradePresenter.this;
                for (Map.Entry next : bleUpgradePresenter.O0000o0o.entrySet()) {
                    BleUpgradePresenter.O000000o("reportSuccessTime, step %d, time %s", next.getKey(), String.valueOf(next.getValue()));
                    hxt hxt = hxi.O0000Oo;
                    String str = bleUpgradePresenter.O0000O0o;
                    int intValue = ((Integer) next.getKey()).intValue();
                    long longValue = ((Long) next.getValue()).longValue();
                    if (!hxt.O000000o(str) && !flu.O00000oO().O00000o0() && !gfr.f17662O000000o) {
                        hxt.f960O000000o.O000000o("ble_update_result", "errorcode", 0, "model", str, "step", Integer.valueOf(intValue), "duration", Long.valueOf(longValue));
                    }
                }
                bleUpgradePresenter.O0000o0o.clear();
                hxi.O0000Oo.O00000o0(BleUpgradePresenter.this.O0000O0o, 0);
            }
        });
    }
}

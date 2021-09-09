package com.xiaomi.smarthome.controls;

import _m_j.cub;
import _m_j.exx;
import _m_j.exz;
import _m_j.eyi;
import _m_j.ezu;
import _m_j.fad;
import _m_j.fbl;
import _m_j.fkl;
import _m_j.fml;
import _m_j.fno;
import _m_j.ft;
import _m_j.ggb;
import _m_j.gsy;
import _m_j.gzt;
import _m_j.hca;
import _m_j.hcc;
import _m_j.hcz;
import _m_j.hda;
import _m_j.hfa;
import _m_j.hxi;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.controls.Control;
import android.service.controls.ControlsProviderService;
import android.service.controls.actions.ControlAction;
import android.service.controls.templates.ControlButton;
import android.service.controls.templates.ControlTemplate;
import android.service.controls.templates.StatelessTemplate;
import android.service.controls.templates.ToggleTemplate;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.activity.SystemUIJumperActivity;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.controls.MiControlsProviderService;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.function.Consumer;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@SuppressLint({"NewApi"})
public class MiControlsProviderService extends ControlsProviderService {
    public List<String> controlIds;
    public BroadcastReceiver mCTA = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.controls.MiControlsProviderService.AnonymousClass2 */

        public void onReceive(Context context, Intent intent) {
            MiControlsProviderService miControlsProviderService = MiControlsProviderService.this;
            miControlsProviderService.mCTA = null;
            ft.O000000o(miControlsProviderService.getApplicationContext()).O000000o(MiControlsProviderService.this.mCTA);
            hcz.getInstance().registerStateChangedListener(MiControlsProviderService.this.mListener);
        }
    };
    private HashMap<String, String> mCacheProps = new HashMap<>();
    public hda mListener = new hda() {
        /* class com.xiaomi.smarthome.controls.$$Lambda$MiControlsProviderService$nCS4kRfs28XU1ejZf356lwf5gZQ */

        public final void onStateChanged(String str, String str2, Object obj) {
            MiControlsProviderService.this.lambda$new$1$MiControlsProviderService(str, str2, obj);
        }
    };
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.controls.MiControlsProviderService.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            MiControlsProviderService.this.startActivity(intent);
        }
    };
    private Flow.Subscriber<? super Control> subscriber;

    public interface Callback<T> {
        void call(T t);
    }

    private String getControlId(String str) {
        return str;
    }

    public /* synthetic */ void lambda$new$1$MiControlsProviderService(String str, String str2, Object obj) {
        CommonApplication.getGlobalWorkerHandler().post(new Runnable(str, str2) {
            /* class com.xiaomi.smarthome.controls.$$Lambda$MiControlsProviderService$uNh0oUSogStG9joL1_3Wmzp6vg */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                MiControlsProviderService.this.lambda$null$0$MiControlsProviderService(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$null$0$MiControlsProviderService(String str, String str2) {
        Device O000000o2;
        if (this.controlIds != null && this.subscriber != null) {
            gsy.O000000o(4, "ControlsProviderService", "MiControlsProviderService   OnStateChangedListener:" + str + " prop:" + str2);
            if (str != null) {
                String controlId = getControlId(str);
                if (this.controlIds.contains(controlId) && (O000000o2 = fno.O000000o().O000000o(controlId)) != null) {
                    notifyControlId(O000000o2, false, this.subscriber, this.controlIds.size(), this.controlIds.indexOf(str));
                    return;
                }
                return;
            }
            notifyControlIds(this.controlIds, this.subscriber);
        }
    }

    public void onCreate() {
        super.onCreate();
        registerReceiver(this.mReceiver, new IntentFilter("com.xiaomi.smarthome.action.viewdevice"));
        if (ezu.O000000o()) {
            this.mCTA.onReceive(this, new Intent("action_disclaim_local_broadcast_complete"));
        } else {
            ft.O000000o(this).O000000o(this.mCTA, new IntentFilter("action_disclaim_local_broadcast_complete"));
        }
        exx.O000000o(false);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        StringBuilder sb = new StringBuilder("onStartCommand:");
        sb.append(intent == null ? "null" : intent.getDataString());
        gsy.O000000o(4, "ControlsProviderService", sb.toString());
        return super.onStartCommand(intent, i, i2);
    }

    @SuppressLint({"Override"})
    public Flow.Publisher<Control> createPublisherForAllAvailable() {
        return new Flow.Publisher() {
            /* class com.xiaomi.smarthome.controls.$$Lambda$MiControlsProviderService$zWugc5QGO1C2ATnXvZlDZFIaKqQ */

            public final void subscribe(Flow.Subscriber subscriber) {
                MiControlsProviderService.this.lambda$createPublisherForAllAvailable$2$MiControlsProviderService(subscriber);
            }
        };
    }

    public /* synthetic */ void lambda$createPublisherForAllAvailable$2$MiControlsProviderService(final Flow.Subscriber subscriber2) {
        if (!ezu.O000000o()) {
            gsy.O00000o0(LogType.CARD, "ControlsProviderService", "MiControlsProviderService   createPublisherForAllAvailable CTACheck false");
            return;
        }
        exz exz = exz.f15941O000000o;
        if (!exz.O00000Oo()) {
            gsy.O00000o0(LogType.CARD, "ControlsProviderService", "createPublisherForAllAvailable forbidShow");
            return;
        }
        subscriber2.onSubscribe(new Flow.Subscription() {
            /* class com.xiaomi.smarthome.controls.MiControlsProviderService.AnonymousClass3 */

            public void request(long j) {
                LogType logType = LogType.CARD;
                gsy.O00000o0(logType, "ControlsProviderService", "MiControlsProviderService createPublisherForAllAvailable request " + j + " subscriber:" + subscriber2);
                new fbl(new Runnable(subscriber2) {
                    /* class com.xiaomi.smarthome.controls.$$Lambda$MiControlsProviderService$3$q3uCLT4TxnQMxX9V3VxsNLewd8Y */
                    private final /* synthetic */ Flow.Subscriber f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        MiControlsProviderService.AnonymousClass3.this.lambda$request$1$MiControlsProviderService$3(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$request$1$MiControlsProviderService$3(Flow.Subscriber subscriber) {
                gsy.O000000o(4, "ControlsProviderService", "MiControlsProviderService createPublisherForAllAvailable onSpecReady");
                CommonApplication.getGlobalWorkerHandler().post(new Runnable(subscriber) {
                    /* class com.xiaomi.smarthome.controls.$$Lambda$MiControlsProviderService$3$uTqOJbvyD59yTsEKUPMB5P2zxg */
                    private final /* synthetic */ Flow.Subscriber f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        MiControlsProviderService.AnonymousClass3.this.lambda$null$0$MiControlsProviderService$3(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$null$0$MiControlsProviderService$3(Flow.Subscriber subscriber) {
                List<GridViewData> list;
                if (fad.O000000o().isEnableMiuiWidgetMemoryOpt()) {
                    list = fad.O000000o().getMiuiCacheDeviceList();
                } else {
                    list = ggb.O00000Oo().O0000o0();
                }
                if (list == null) {
                    gsy.O00000o0(LogType.CARD, "ControlsProviderService", "createPublisherForAllAvailable receive device refresh success data is null");
                    return;
                }
                LogType logType = LogType.CARD;
                gsy.O00000o0(logType, "ControlsProviderService", "createPublisherForAllAvailable receive device refresh success size:" + list.size());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    Device device = ((GridViewData) list.get(i)).O00000Oo;
                    if (device != null) {
                        arrayList.add(device.did);
                    }
                }
                MiControlsProviderService.this.notifyControlIds(arrayList, subscriber);
                MiControlsProviderService.this.controlIds = arrayList;
                subscriber.onComplete();
                gsy.O000000o(4, "ControlsProviderService", "MiControlsProviderService  createPublisherForAllAvailable.onComplete");
            }

            public void cancel() {
                gsy.O00000o0(LogType.CARD, "ControlsProviderService", "MiControlsProviderService createPublisherForAllAvailable cancel");
            }
        });
        gsy.O00000o0(LogType.CARD, "ControlsProviderService", "MiControlsProviderService  createPublisherForAllAvailable.subscribe");
    }

    @SuppressLint({"Override"})
    public Flow.Publisher<Control> createPublisherFor(List<String> list) {
        return new Flow.Publisher(list) {
            /* class com.xiaomi.smarthome.controls.$$Lambda$MiControlsProviderService$945iTIqn1xvqgUc9oQACdrLD7dw */
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(Flow.Subscriber subscriber) {
                MiControlsProviderService.this.lambda$createPublisherFor$3$MiControlsProviderService(this.f$1, subscriber);
            }
        };
    }

    public void notifyControlIds(List<String> list, Flow.Subscriber<? super Control> subscriber2) {
        int size;
        if (list != null && (size = list.size()) != 0) {
            for (int i = 0; i < size; i++) {
                Device O000000o2 = fno.O000000o().O000000o(list.get(i));
                if (O000000o2 != null && !fml.O000000o(O000000o2.did)) {
                    notifyControlId(O000000o2, true, subscriber2, size, i);
                }
            }
        }
    }

    private void notifyControlId(Device device, boolean z, Flow.Subscriber<? super Control> subscriber2, int i, int i2) {
        ControlTemplate controlTemplate;
        String str;
        String str2;
        String str3;
        Device device2 = device;
        Flow.Subscriber<? super Control> subscriber3 = subscriber2;
        hcc gridCard = eyi.getInstance().getGridCard(device2);
        ArrayList<Pair> deviceRenderData = eyi.getInstance().getDeviceRenderData(device2, gridCard);
        Pair O000000o2 = gzt.O000000o(device2, deviceRenderData);
        String O000000o3 = gzt.O000000o(device2.model, deviceRenderData);
        if (O000000o2 != null) {
            if (device2 == null || device2.isSetPinCode != 0) {
                controlTemplate = new StatelessTemplate(device2.did);
            } else {
                controlTemplate = new ToggleTemplate(device2.did, new ControlButton(O000000o2.first == State.SELECTED, ""));
            }
            List O000000o4 = gridCard.O000000o();
            if (TextUtils.isEmpty(O000000o3) && O000000o4.size() > 0) {
                hcc.O000000o o000000o = (hcc.O000000o) O000000o4.get(0);
                Object propKey = eyi.getPropKey(o000000o, 0, device2);
                O000000o3 = o000000o.O000000o(device2, propKey, o000000o.O00000Oo(device2, propKey));
            }
            str = String.valueOf(O000000o2.first);
        } else {
            if (TextUtils.isEmpty(O000000o3)) {
                if (device2 instanceof BleDevice) {
                    O000000o3 = getApplicationContext().getString(R.string.device_group_title_bluetooth);
                } else {
                    O000000o3 = getApplicationContext().getString(R.string.list_device_online);
                }
            }
            str = O000000o3;
            controlTemplate = new StatelessTemplate(device2.did);
            O000000o3 = str;
        }
        Icon O0000oO = DeviceFactory.O0000oO(device2.model);
        int i3 = 4;
        if (subscriber3 == this.subscriber) {
            String str4 = this.mCacheProps.get(device2.did);
            if (z || !TextUtils.equals(str4, str)) {
                this.mCacheProps.put(device2.did, str);
                gsy.O000000o(4, "ControlsProviderService", "MiControlsProviderService.createPublisherFor  generateControl onNext device:" + device2 + " template:" + controlTemplate + " current:" + str + " cache:" + str4 + " icon:" + O0000oO);
            } else {
                gsy.O000000o(4, "ControlsProviderService", "MiControlsProviderService  generateControl cache device:" + device2 + " template:" + controlTemplate + " current:" + str + " icon:" + O0000oO);
                return;
            }
        } else {
            gsy.O000000o(4, "ControlsProviderService", "MiControlsProviderService.createPublisherForAllAvailable  generateControl onNext device:" + device2 + " template:" + controlTemplate + " current:" + str + " icon:" + O0000oO);
        }
        PendingIntent activity = PendingIntent.getActivity(getApplicationContext(), device2.did.hashCode(), getPluginIntent(device2, i, i2), 134217728);
        if (fad.O000000o().isEnableMiuiWidgetMemoryOpt()) {
            str2 = fad.O000000o().getHomeNameByDid(device2.did);
        } else {
            Home O0000o0 = ggb.O00000Oo().O0000o0(device2.did);
            if (O0000o0 == null) {
                str2 = "";
            } else {
                ggb.O00000Oo();
                str2 = ggb.O000000o(O0000o0);
            }
        }
        if (str2 == null) {
            str2 = "";
        }
        if (fad.O000000o().isEnableMiuiWidgetMemoryOpt()) {
            str3 = fad.O000000o().getRoomNameByDid(device2.did);
        } else {
            str3 = ggb.O00000Oo().O0000o0O(device2.did);
        }
        if (str3 == null) {
            str3 = "";
        }
        Control.StatefulBuilder zone = new Control.StatefulBuilder(device2.did, activity).setCustomIcon(O0000oO).setTitle(device.getName()).setSubtitle(str3).setZone(str2);
        if (O000000o3 == null) {
            O000000o3 = "";
        }
        Control.StatefulBuilder deviceType = zone.setStatusText(O000000o3).setDeviceType(getType(device));
        if (device2.isOnline) {
            i3 = 1;
        }
        Control.StatefulBuilder status = deviceType.setStatus(i3);
        status.setControlTemplate(controlTemplate);
        subscriber3.onNext(status.build());
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private int getType(Device device) {
        char c;
        String O00000Oo = hfa.O00000Oo(device);
        if (O00000Oo == null) {
            return 0;
        }
        switch (O00000Oo.hashCode()) {
            case -2001695995:
                if (O00000Oo.equals("air-conditioner")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1948787488:
                if (O00000Oo.equals("microwave-oven")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -1626910882:
                if (O00000Oo.equals("humidifier")) {
                    c = 12;
                    break;
                }
                c = 65535;
                break;
            case -1435719957:
                if (O00000Oo.equals("air-fresh")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1367751899:
                if (O00000Oo.equals("camera")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1317750766:
                if (O00000Oo.equals("television")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case -1266285051:
                if (O00000Oo.equals("fridge")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -1221255523:
                if (O00000Oo.equals("heater")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1134801837:
                if (O00000Oo.equals("kettle")) {
                    c = 13;
                    break;
                }
                c = 65535;
                break;
            case -1005516787:
                if (O00000Oo.equals("outlet")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case -889473228:
                if (O00000Oo.equals("switch")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -824080459:
                if (O00000Oo.equals("vacuum")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case -794987636:
                if (O00000Oo.equals("washer")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 101139:
                if (O00000Oo.equals("fan")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case 3208476:
                if (O00000Oo.equals("hood")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 3327275:
                if (O00000Oo.equals("lock")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 102970646:
                if (O00000Oo.equals("light")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 890135974:
                if (O00000Oo.equals("dishwasher")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case 1024828111:
                if (O00000Oo.equals("air-purifier")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1126995602:
                if (O00000Oo.equals("curtain")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1202172337:
                if (O00000Oo.equals("doorbell")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case 1587965599:
                if (O00000Oo.equals("dehumidifier")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1953901587:
                if (O00000Oo.equals("water-heater")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 13;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 50;
            case 6:
                return 36;
            case 7:
                return 6;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return 24;
            case 9:
                return 51;
            case 10:
                return 8;
            case 11:
                return 10;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return 11;
            case 13:
                return 12;
            case 14:
                return 45;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return 14;
            case 16:
                return 15;
            case 17:
                return 48;
            case 18:
                return 21;
            case 19:
                return 22;
            case 20:
                return 32;
            case 21:
                return 31;
            case 22:
                return 23;
            default:
                return 0;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mReceiver);
        if (this.mCTA == null) {
            hcz.getInstance().unregisterStateChangedListener(this.mListener);
        } else {
            ft.O000000o(this).O000000o(this.mCTA);
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
    private Intent getPluginIntent(Device device, int i, int i2) {
        Intent intent = new Intent("com.xiaomi.smarthome.action.viewdevice");
        Class O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.device.utils.DeviceLauncher2");
        if (O00000Oo != null) {
            intent.setComponent(new ComponentName(getPackageName(), O00000Oo.getName()));
        } else {
            intent.setComponent(new ComponentName(getPackageName(), "com.xiaomi.smarthome.device.utils.DeviceLauncher2"));
        }
        intent.putExtra("from", "MiControlsProviderService");
        intent.putExtra("total", i);
        intent.putExtra("serial", i2);
        intent.putExtra("device_id", device.did);
        intent.putExtra("source_tag", "short_cut");
        intent.putExtra("user_model", device.model);
        intent.putExtra("timestamp", System.currentTimeMillis());
        intent.putExtra("from_main_activity", true);
        intent.setFlags(268435456);
        intent.setFlags(4194304);
        return intent;
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
    @SuppressLint({"Override"})
    public void performControlAction(String str, ControlAction controlAction, Consumer<Integer> consumer) {
        String str2 = str;
        Consumer<Integer> consumer2 = consumer;
        if (!fkl.O000000o().O00000o0()) {
            PluginDeviceManager.instance.updateConfig(false, null);
            fkl.O000000o().O00000Oo();
        }
        Device O000000o2 = fno.O000000o().O000000o(str2);
        hcc gridCard = eyi.getInstance().getGridCard(O000000o2);
        ArrayList<Pair> deviceRenderData = eyi.getInstance().getDeviceRenderData(O000000o2, gridCard);
        Pair O000000o3 = gzt.O000000o(O000000o2, deviceRenderData);
        if (O000000o3 == null) {
            gsy.O000000o(6, "ControlsProviderService", "performControlAction controlId:".concat(String.valueOf(str)));
            return;
        }
        if (this.controlIds != null) {
            String str3 = O000000o2.model;
            int size = this.controlIds.size();
            int indexOf = this.controlIds.indexOf(str2);
            hxi.O00000o.f952O000000o.O000000o("miui_card_control", "model", str3, "type", "control_service", "total", Integer.valueOf(size), "serial", Integer.valueOf(indexOf));
        }
        if (getType(O000000o2) != 50 || Build.VERSION.SDK_INT <= 26 || O000000o2.model.equalsIgnoreCase("mxiang.camera.mwc10") || O000000o2.model.equalsIgnoreCase("mxiang.camera.mwc11")) {
            int indexOf2 = deviceRenderData.indexOf(O000000o3);
            eyi.getInstance().toggleButton(O000000o2, indexOf2, (hcc.O000000o) gridCard.O000000o().get(indexOf2), null);
        } else {
            gsy.O00000Oo("ControlsProviderService", "TYPE_CAMERA");
            if (!((KeyguardManager) getSystemService("keyguard")).isKeyguardLocked()) {
                hca.O000000o(str);
            } else {
                Intent intent = new Intent(this, SystemUIJumperActivity.class);
                intent.putExtra("controlId", str2);
                intent.putExtra("from_system_ui", true);
                intent.addFlags(268468224);
                startActivity(intent);
            }
            sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
        consumer2.accept(1);
        gsy.O000000o(4, "ControlsProviderService", "MiControlsProviderService  performControlAction s:" + str2 + "  controlAction:" + controlAction + " consumer:" + consumer2);
    }

    public /* synthetic */ void lambda$createPublisherFor$3$MiControlsProviderService(final List list, final Flow.Subscriber subscriber2) {
        exz exz = exz.f15941O000000o;
        if (!exz.O00000Oo()) {
            gsy.O00000o0(LogType.CARD, "ControlsProviderService", "createPublisherFor forbidShow");
            return;
        }
        if (list != null) {
            int size = list.size();
            hxi.O00000o0.f957O000000o.O000000o("miui_card_control_show", "total", Integer.valueOf(size));
        }
        this.controlIds = list;
        this.subscriber = subscriber2;
        if (!ezu.O000000o()) {
            gsy.O00000o0(LogType.CARD, "ControlsProviderService", "MiControlsProviderService   createPublisherFor CTACheck false");
            return;
        }
        subscriber2.onSubscribe(new Flow.Subscription() {
            /* class com.xiaomi.smarthome.controls.MiControlsProviderService.AnonymousClass4 */

            public void request(long j) {
                LogType logType = LogType.CARD;
                gsy.O00000o0(logType, "ControlsProviderService", "MiControlsProviderService createPublisherFor request " + j + " subscriber:" + subscriber2);
                new fbl(new Runnable(list, subscriber2) {
                    /* class com.xiaomi.smarthome.controls.$$Lambda$MiControlsProviderService$4$sSPWaqKgCuA2NlmyZ7btHBRE9Jg */
                    private final /* synthetic */ List f$1;
                    private final /* synthetic */ Flow.Subscriber f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        MiControlsProviderService.AnonymousClass4.this.lambda$request$1$MiControlsProviderService$4(this.f$1, this.f$2);
                    }
                });
            }

            public /* synthetic */ void lambda$null$0$MiControlsProviderService$4(List list, Flow.Subscriber subscriber) {
                MiControlsProviderService.this.notifyControlIds(list, subscriber);
            }

            public /* synthetic */ void lambda$request$1$MiControlsProviderService$4(List list, Flow.Subscriber subscriber) {
                CommonApplication.getGlobalWorkerHandler().post(new Runnable(list, subscriber) {
                    /* class com.xiaomi.smarthome.controls.$$Lambda$MiControlsProviderService$4$vMiT1UndkGpYsZqa7TdvGDPRO5k */
                    private final /* synthetic */ List f$1;
                    private final /* synthetic */ Flow.Subscriber f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        MiControlsProviderService.AnonymousClass4.this.lambda$null$0$MiControlsProviderService$4(this.f$1, this.f$2);
                    }
                });
                gsy.O00000o0(LogType.CARD, "ControlsProviderService", "MiControlsProviderService createPublisherFor onSpecReady");
            }

            public void cancel() {
                gsy.O00000o0(LogType.CARD, "ControlsProviderService", "MiControlsProviderService createPublisherFor cancel");
            }
        });
        gsy.O00000o0(LogType.CARD, "ControlsProviderService", "MiControlsProviderService   createPublisherFor.subscribe".concat(String.valueOf(list)));
    }
}

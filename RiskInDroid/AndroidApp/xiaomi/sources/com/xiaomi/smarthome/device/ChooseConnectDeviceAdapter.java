package com.xiaomi.smarthome.device;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fmd;
import _m_j.fnh;
import _m_j.fno;
import _m_j.foc;
import _m_j.fod;
import _m_j.fqy;
import _m_j.ftn;
import _m_j.ftt;
import _m_j.gnl;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.hna;
import _m_j.htt;
import _m_j.htx;
import _m_j.hty;
import _m_j.hvg;
import _m_j.hxc;
import _m_j.hxi;
import _m_j.izb;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.ScanResult;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.ListItemView;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.MiSimpleDraweeView;
import com.xiaomi.smarthome.service.DeviceObserveService;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class ChooseConnectDeviceAdapter extends BaseAdapter {
    private static Object O0000o0 = new Object();
    private static List<Object> O0000o00 = new ArrayList();

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f6906O000000o;
    public final Fragment O00000Oo;
    public String O00000o = null;
    public boolean O00000o0 = false;
    public String O00000oO = null;
    public DeviceScanManager O00000oo;
    public View.OnClickListener O0000O0o;
    public long O0000OOo;
    public int O0000Oo = 3;
    public Map<String, Long> O0000Oo0 = new HashMap();
    public int O0000OoO = 3;
    private boolean O0000Ooo;
    private Map<String, Integer> O0000o = new HashMap();
    private MLAlertDialog O0000o0O;
    private int O0000o0o;
    private float O0000oO0 = -1.0f;

    public enum ScanDeviceType {
        AP,
        AP_DIRECT,
        BLE,
        MI_TV,
        AIOT
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public ChooseConnectDeviceAdapter(Context context, Fragment fragment, Intent intent, int i) {
        this.f6906O000000o = context;
        this.O00000Oo = fragment;
        this.O0000Ooo = false;
        if (intent != null) {
            this.O00000o = intent.getStringExtra("bssid");
            this.O00000oO = intent.getStringExtra("password");
            this.O00000o0 = intent.getBooleanExtra("from_miui", false);
            this.O0000o0o = i;
        }
        this.O0000OOo = System.currentTimeMillis();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        final int i2 = i;
        View inflate = view == null ? LayoutInflater.from(this.f6906O000000o).inflate(this.O0000o0o, viewGroup, false) : view;
        TextView textView = (TextView) inflate.findViewById(R.id.name);
        TextView textView2 = (TextView) inflate.findViewById(R.id.name_status);
        MiSimpleDraweeView miSimpleDraweeView = (MiSimpleDraweeView) inflate.findViewById(R.id.image);
        View findViewById = inflate.findViewById(R.id.divider);
        if (i2 == this.O0000Oo && this.O0000o0o == R.layout.choose_device_scan_list_item) {
            textView.setText(((Object) this.f6906O000000o.getText(R.string.device_choose_expand_more)) + " (" + (O0000o00.size() - 3) + ")");
            textView2.setVisibility(8);
            miSimpleDraweeView.setVisibility(4);
            ((ImageView) inflate.findViewById(R.id.more_image)).setVisibility(0);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    if (ChooseConnectDeviceAdapter.this.O0000O0o != null) {
                        ChooseConnectDeviceAdapter.this.O0000O0o.onClick(view);
                    }
                }
            });
            return inflate;
        }
        if (TextUtils.isEmpty(miSimpleDraweeView.model)) {
            miSimpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(miSimpleDraweeView.getResources()).setFadeDuration(200).setPlaceholderImage(miSimpleDraweeView.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
        }
        textView2.setVisibility(8);
        Object obj = O0000o00.get(i2);
        String str = "";
        if (obj instanceof PushBindEntity) {
            final PushBindEntity pushBindEntity = (PushBindEntity) obj;
            DeviceFactory.O00000Oo(pushBindEntity.f11457O000000o.O00000Oo(), miSimpleDraweeView);
            Integer num = this.O0000o.get(pushBindEntity.O0000OOo);
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(pushBindEntity.f11457O000000o.O00000Oo());
            if (num == null || num.intValue() <= 1) {
                textView.setText(pushBindEntity.f11457O000000o.O0000Oo0());
            } else {
                if (!TextUtils.isEmpty(pushBindEntity.O0000Ooo)) {
                    str = pushBindEntity.O0000Ooo;
                } else if (TextUtils.isEmpty(pushBindEntity.O00000o0) || O00000oO2 == null || O00000oO2.O00000o() != 0) {
                    String str2 = pushBindEntity.O00000o;
                    if (str2 != null && str2.length() > 2) {
                        str = str2.substring(str2.length() - 2, str2.length()).replace(":", str);
                    }
                } else {
                    String str3 = pushBindEntity.O00000o0;
                    if (str3.length() > 4) {
                        str = str3.substring(str3.length() - 4);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    textView.setText(pushBindEntity.f11457O000000o.O0000Oo0() + "(" + str + ")");
                } else {
                    textView.setText(pushBindEntity.f11457O000000o.O0000Oo0());
                }
            }
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass8 */

                public final void onClick(View view) {
                    ChooseConnectDeviceAdapter.this.O000000o(ScanDeviceType.AIOT, pushBindEntity.f11457O000000o.O00000Oo(), null, null, null, pushBindEntity, i2);
                }
            });
        } else if (obj instanceof ScanResult) {
            final ScanResult scanResult = (ScanResult) obj;
            if (this.O0000Oo0.get(scanResult.BSSID) == null) {
                this.O0000Oo0.put(scanResult.BSSID, Long.valueOf(System.currentTimeMillis()));
            }
            if (!DeviceFactory.O00000oo(scanResult)) {
                final String O0000Ooo2 = DeviceFactory.O0000Ooo(scanResult.SSID);
                DeviceFactory.O000000o(O0000Ooo2, miSimpleDraweeView, (int) R.drawable.device_list_phone_no);
                Integer num2 = this.O0000o.get(O0000Ooo2);
                if (num2 == null || num2.intValue() <= 1) {
                    textView.setText(DeviceFactory.O0000Ooo(scanResult));
                } else {
                    textView.setText(String.format("%s(%s)", DeviceFactory.O0000Ooo(scanResult), DeviceFactory.O0000Oo(scanResult)));
                }
                inflate.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass9 */

                    public final void onClick(View view) {
                        ChooseConnectDeviceAdapter.this.O000000o(ScanDeviceType.AP, O0000Ooo2, scanResult, null, null, null, i2);
                    }
                });
            } else {
                final String O00000o2 = DeviceFactory.O00000o(scanResult);
                DeviceFactory.O000000o(O00000o2, miSimpleDraweeView, (int) R.drawable.device_list_phone_no);
                Integer num3 = this.O0000o.get(O00000o2);
                if (num3 == null || num3.intValue() <= 1) {
                    textView.setText(DeviceFactory.O0000Ooo(scanResult));
                } else {
                    textView.setText(String.format("%s(%s)", DeviceFactory.O0000Ooo(scanResult), DeviceFactory.O0000Oo(scanResult)));
                }
                inflate.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass10 */

                    public final void onClick(View view) {
                        ChooseConnectDeviceAdapter.this.O000000o(ScanDeviceType.AP_DIRECT, O00000o2, scanResult, null, null, null, i2);
                    }
                });
            }
        } else if (obj instanceof BleDevice) {
            final BleDevice bleDevice = (BleDevice) obj;
            DeviceFactory.O00000Oo(bleDevice.model, miSimpleDraweeView);
            textView.setText(bleDevice.O0000OOo());
            int O0000Oo02 = bleDevice.O0000Oo0();
            Integer num4 = this.O0000o.get(bleDevice.model);
            if ((num4 != null ? num4.intValue() : 0) > 1 && bleDevice.model.startsWith("xiaomi.wifispeaker.") && bleDevice.O00000Oo() != null) {
                String str4 = bleDevice.O00000Oo().O00000o;
                gsy.O000000o(LogType.KUAILIAN, "DeviceAdapter", String.format("model =%s, bleMac = %s, comboKey=%s", bleDevice.model, bleDevice.O00000Oo().O00000o, bleDevice.O00000Oo().O00000oo));
                textView.setText(String.format("%s(%s)", bleDevice.O0000OOo(), str4.substring(0, 5).replace(":", str)));
            } else if (O0000Oo02 != 1) {
                textView2.setVisibility(0);
                if (this.O0000Ooo) {
                    textView2.setText(this.f6906O000000o.getResources().getQuantityString(R.plurals.choose_device_device_count, O0000Oo02, Integer.valueOf(O0000Oo02)));
                } else {
                    textView2.setText(String.valueOf(O0000Oo02));
                }
            }
            if (this.O0000Oo0.get(bleDevice.mac) == null) {
                this.O0000Oo0.put(bleDevice.mac, Long.valueOf(System.currentTimeMillis()));
            }
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass11 */

                public final void onClick(View view) {
                    ChooseConnectDeviceAdapter.this.O000000o(ScanDeviceType.BLE, bleDevice.model, null, bleDevice, null, null, i2);
                }
            });
        } else if (obj instanceof MiTVDevice) {
            final MiTVDevice miTVDevice = (MiTVDevice) obj;
            DeviceFactory.O00000Oo(miTVDevice.model, miSimpleDraweeView);
            textView.setText(miTVDevice.name);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass12 */

                public final void onClick(View view) {
                    ChooseConnectDeviceAdapter.this.O000000o(ScanDeviceType.MI_TV, miTVDevice.name, null, null, miTVDevice, null, i2);
                }
            });
        } else if (obj instanceof XiaomiRedMiRouter15) {
            final XiaomiRedMiRouter15 xiaomiRedMiRouter15 = (XiaomiRedMiRouter15) obj;
            Integer num5 = this.O0000o.get(xiaomiRedMiRouter15.mRealModel);
            PluginDeviceInfo O00000oO3 = CoreApi.O000000o().O00000oO(xiaomiRedMiRouter15.mRealModel);
            if (O00000oO3 == null) {
                textView.setText(str);
            } else if (num5 == null || num5.intValue() <= 1) {
                textView.setText(O00000oO3.O0000Oo0());
            } else {
                textView.setText(String.format("%s(%s)", O00000oO3.O0000Oo0(), DeviceFactory.O00000o0(xiaomiRedMiRouter15.bssid, xiaomiRedMiRouter15.O000000o())));
            }
            DeviceFactory.O00000Oo(xiaomiRedMiRouter15.mRealModel, miSimpleDraweeView);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass13 */

                public final void onClick(View view) {
                    ChooseConnectDeviceAdapter.this.O000000o(xiaomiRedMiRouter15);
                }
            });
        }
        if (findViewById != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            if (i2 == getCount() - 1) {
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = gpc.O000000o(this.f6906O000000o, 13.0f);
            }
        }
        if (inflate instanceof ListItemView) {
            ((ListItemView) inflate).setPosition(i2);
        }
        return inflate;
    }

    public final void O000000o(XiaomiRedMiRouter15 xiaomiRedMiRouter15) {
        hna.O00000Oo().getActionByDeviceRenderer(xiaomiRedMiRouter15, this.f6906O000000o, xiaomiRedMiRouter15.O00000Oo());
    }

    public final int getCount() {
        if (this.O0000o0o != R.layout.choose_device_scan_list_item) {
            return O0000o00.size();
        }
        int size = O0000o00.size();
        int i = this.O0000Oo;
        return size < i + 2 ? O0000o00.size() : i + 1;
    }

    public final void O000000o(Collection<?> collection) {
        String str;
        synchronized (O0000o0) {
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            for (Object next : collection) {
                if (next instanceof PushBindEntity) {
                    PushBindEntity pushBindEntity = (PushBindEntity) next;
                    String O00000Oo2 = pushBindEntity.f11457O000000o.O00000Oo();
                    gsy.O000000o(LogType.KUAILIAN, "ConnectAdapter", "push bind detail=" + pushBindEntity.toString());
                    if (O00000Oo2.startsWith("xiaomi.wifispeaker.")) {
                        if (!TextUtils.isEmpty(pushBindEntity.O0000Ooo)) {
                            hashMap.put(O00000Oo2 + pushBindEntity.O0000Ooo, pushBindEntity);
                        } else {
                            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(O00000Oo2);
                            if (O00000oO2 != null && O00000oO2.O00000o() == 0) {
                                hashSet.add(pushBindEntity.O00000o0);
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object next2 : collection) {
                if (next2 instanceof BleDeviceGroup) {
                    gsy.O000000o(LogType.KUAILIAN, "ConnectAdapter", String.format("bleDeviceGourp bssid=%s,mac=%s,did=%s", ((BleDeviceGroup) next2).bssid, ((BleDeviceGroup) next2).mac, ((BleDeviceGroup) next2).did));
                    BleDeviceGroup bleDeviceGroup = (BleDeviceGroup) next2;
                    if (!bleDeviceGroup.model.startsWith("xiaomi.wifispeaker.") || bleDeviceGroup.O00000Oo() == null) {
                        str = "";
                    } else {
                        str = bleDeviceGroup.model + bleDeviceGroup.O00000Oo().O00000o.substring(0, 5).replace(":", "");
                    }
                    if (TextUtils.isEmpty(str)) {
                        arrayList.add(next2);
                    } else if (hashMap.get(str) == null) {
                        arrayList.add(next2);
                    }
                } else if (next2 instanceof ScanResult) {
                    String str2 = ((ScanResult) next2).SSID;
                    if (!hashSet.contains(str2)) {
                        arrayList.add(next2);
                    } else {
                        gsy.O000000o(LogType.KUAILIAN, "ConnectAdapter", String.format("wif ScanResult 存在重复： ssid=%s, bssid=%s", str2, ((ScanResult) next2).BSSID));
                    }
                } else {
                    arrayList.add(next2);
                }
            }
            O00000o0(arrayList);
            O00000Oo(arrayList);
        }
        super.notifyDataSetChanged();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        r2 = true;
     */
    private static void O00000Oo(Collection<?> collection) {
        boolean z;
        int size = O0000o00.size() - 1;
        while (true) {
            boolean z2 = false;
            if (size < 0) {
                break;
            }
            Object obj = O0000o00.get(size);
            Iterator<?> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if ((!(obj instanceof BleDeviceGroup) || !(next instanceof BleDeviceGroup) || !TextUtils.equals(((BleDeviceGroup) obj).mac, ((BleDeviceGroup) next).mac)) && ((!(obj instanceof ScanResult) || !(next instanceof ScanResult) || !TextUtils.equals(((ScanResult) obj).BSSID, ((ScanResult) next).BSSID)) && (!(obj instanceof PushBindEntity) || !(next instanceof PushBindEntity) || !TextUtils.equals(((PushBindEntity) obj).O00000o0, ((PushBindEntity) next).O00000o0)))) {
                }
            }
            if (!z2) {
                O0000o00.remove(obj);
            }
            size--;
        }
        for (Object next2 : collection) {
            Iterator<Object> it2 = O0000o00.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                Object next3 = it2.next();
                if ((!(next3 instanceof BleDeviceGroup) || !(next2 instanceof BleDeviceGroup) || !TextUtils.equals(((BleDeviceGroup) next3).mac, ((BleDeviceGroup) next2).mac)) && ((!(next3 instanceof ScanResult) || !(next2 instanceof ScanResult) || !TextUtils.equals(((ScanResult) next3).BSSID, ((ScanResult) next2).BSSID)) && (!(next3 instanceof PushBindEntity) || !(next2 instanceof PushBindEntity) || !TextUtils.equals(((PushBindEntity) next3).O00000o0, ((PushBindEntity) next2).O00000o0)))) {
                }
            }
            z = true;
            if (!z) {
                O0000o00.add(next2);
            }
        }
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, com.xiaomi.smarthome.smartconfig.PushBindEntity]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0316  */
    public final void O000000o(ScanDeviceType scanDeviceType, String str, ScanResult scanResult, BleDevice bleDevice, MiTVDevice miTVDevice, PushBindEntity pushBindEntity, int i) {
        int i2;
        PluginDeviceInfo pluginDeviceInfo;
        ArrayList<String> arrayList;
        List<Device> O0000Ooo2;
        final String str2 = str;
        final ScanResult scanResult2 = scanResult;
        final BleDevice bleDevice2 = bleDevice;
        final MiTVDevice miTVDevice2 = miTVDevice;
        PushBindEntity pushBindEntity2 = pushBindEntity;
        int count = getCount();
        if (this.O0000o0o == R.layout.choose_device_scan_list_item) {
            int i3 = i + 1;
            hxi.O00000o.f952O000000o.O000000o("adddevice_home_nearbydevice_click", "model", str2, "serial", Integer.valueOf(i3), "total", Integer.valueOf(Math.min(3, count)), "count", Integer.valueOf(count), "type", Integer.valueOf(Math.min(i3 - 1, 9)));
            i2 = 8;
        } else {
            int i4 = i + 1;
            i2 = 8;
            hxi.O00000o.f952O000000o.O000000o("adddevice_nearby_devicelist_click", "model", str2, "serial", Integer.valueOf(i4), "total", Integer.valueOf(count), "type", Integer.valueOf(Math.min(i4 - 1, 9)));
        }
        if (!TextUtils.isEmpty(str)) {
            pluginDeviceInfo = CoreApi.O000000o().O00000oO(str2);
        } else {
            pluginDeviceInfo = bleDevice2 != null ? CoreApi.O000000o().O00000oO(bleDevice2.model) : null;
        }
        if (pluginDeviceInfo != null && !pluginDeviceInfo.O000000o()) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass14 */

                public final void run() {
                    izb.O000000o(CommonApplication.getAppContext(), CommonApplication.getAppContext().getResources().getString(R.string.device_not_support_now), 0).show();
                }
            });
        } else if (pluginDeviceInfo == null || pluginDeviceInfo.O00000o() != 19) {
            htx O000000o2 = hty.O000000o();
            if (O000000o2 != null) {
                O000000o2.setDevicePlusType(6);
                Object[] objArr = new Object[1];
                objArr[0] = str2 != null ? str2 : "";
                O000000o2.smartConfigLog("DEVICE_CONFIG", "用户在附近设备入口，开始配网，model：%s", objArr);
            }
            hxi.O00000o.f952O000000o.O000000o("add_near_device", "model", str2);
            hvg.O000000o(this.f6906O000000o).O000000o(str2);
            int i5 = AnonymousClass7.f6919O000000o[scanDeviceType.ordinal()];
            if (i5 == 1) {
                String str3 = "connect_unique";
                hxc.O000000o().O000000o(str2, pushBindEntity2.O0000OoO ? 10 : 8);
                fbt fbt = new fbt(this.f6906O000000o, "PushBindConfigActivity");
                fbt.O000000o("bind_aiot_wifi", (Parcelable) pushBindEntity2);
                if (pushBindEntity2.O0000OoO) {
                    i2 = 10;
                }
                fbt.O000000o("connect_source", i2);
                String uuid = UUID.randomUUID().toString();
                fbt.O000000o(str3, uuid);
                hxi.O00000o.O000000o(str2, i2, uuid);
                fbt.O000000o(600);
                fbs.O000000o(fbt);
            } else if (i5 == 2 || i5 == 3) {
                if (scanResult2 != null) {
                    DeviceObserveService O000000o3 = DeviceObserveService.O000000o();
                    String str4 = scanResult2.SSID;
                    if (O000000o3.O00000Oo != null) {
                        O000000o3.O00000Oo.put(str4, Long.valueOf(System.currentTimeMillis()));
                        O000000o3.O00000o();
                    }
                    if (DeviceFactory.O00000oO(scanResult) == DeviceFactory.AP_TYPE.AP_MIBAP && gnl.O000000o() && !gnl.O00000Oo()) {
                        fmd.O000000o(new BleResponse() {
                            /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass2 */

                            public final void onResponse(int i, Object obj) {
                                fbt smartConfigRequest;
                                htx O000000o2 = hty.O000000o();
                                if (O000000o2 != null && (smartConfigRequest = O000000o2.getSmartConfigRequest(ChooseConnectDeviceAdapter.this.f6906O000000o, scanResult2, str2, ChooseConnectDeviceAdapter.this.O00000o, ChooseConnectDeviceAdapter.this.O00000oO)) != null) {
                                    smartConfigRequest.O000000o("connect_source", 1);
                                    String uuid = UUID.randomUUID().toString();
                                    smartConfigRequest.O000000o("connect_unique", uuid);
                                    hxi.O00000o.O000000o(str2, 1, uuid);
                                    smartConfigRequest.O000000o("from_miui", ChooseConnectDeviceAdapter.this.O00000o0);
                                    smartConfigRequest.O000000o(600);
                                    fbs.O000000o(smartConfigRequest);
                                    hxc.O000000o().O000000o(str2, 1);
                                    Long l = ChooseConnectDeviceAdapter.this.O0000Oo0.get(scanResult2.BSSID);
                                    if (l != null) {
                                        hxc.O000000o().O000000o(str2, BindStep.STEP_SCAN_DEVICE, ChooseConnectDeviceAdapter.this.O0000OOo, l.longValue());
                                    }
                                }
                            }
                        });
                    } else if (htt.O000000o(str)) {
                        O000000o(this.f6906O000000o, str2, scanResult2);
                    } else if (htt.O00000Oo(str)) {
                        O00000Oo(this.f6906O000000o, str2, scanResult2);
                    } else {
                        htx O000000o4 = hty.O000000o();
                        if (O000000o4 != null) {
                            String str5 = "connect_unique";
                            fbt smartConfigRequest = O000000o4.getSmartConfigRequest(this.f6906O000000o, scanResult, str, this.O00000o, this.O00000oO);
                            if (smartConfigRequest != null) {
                                smartConfigRequest.O000000o("from_miui", this.O00000o0);
                                smartConfigRequest.O000000o("connect_source", 1);
                                String uuid2 = UUID.randomUUID().toString();
                                smartConfigRequest.O000000o(str5, uuid2);
                                hxi.O00000o.O000000o(str2, 1, uuid2);
                                smartConfigRequest.O000000o(600);
                                fbs.O000000o(smartConfigRequest);
                                hxc.O000000o().O000000o(str2, 1);
                                Long l = this.O0000Oo0.get(scanResult2.BSSID);
                                if (l != null) {
                                    hxc.O000000o().O000000o(str, BindStep.STEP_SCAN_DEVICE, this.O0000OOo, l.longValue());
                                }
                            }
                        }
                    }
                }
            } else if (i5 != 4) {
                if (i5 == 5) {
                    if (miTVDevice.isBinded() || !miTVDevice.isLocal() || !miTVDevice2.isOnline) {
                        fnh.O000000o().O00000Oo(miTVDevice2.did);
                        DeviceScanManager deviceScanManager = this.O00000oo;
                        if (deviceScanManager != null) {
                            deviceScanManager.removeMitv(miTVDevice2);
                        }
                        fno.O000000o().O000000o(miTVDevice2);
                        izb.O000000o(this.f6906O000000o, (int) R.string.smarthome_add_divece_suscess, 0).show();
                        return;
                    }
                    DeviceRouterFactory.getDeviceHelper().bindMiTVDevice(this.f6906O000000o, miTVDevice2, new ftt<Void>() {
                        /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass15 */

                        public final void O000000o(int i) {
                        }

                        public final void O000000o(int i, Object obj) {
                        }

                        public final /* synthetic */ void O000000o(Object obj) {
                            if (ChooseConnectDeviceAdapter.this.O00000oo != null) {
                                ChooseConnectDeviceAdapter.this.O00000oo.removeMitv(miTVDevice2);
                            }
                            izb.O000000o(ChooseConnectDeviceAdapter.this.f6906O000000o, (int) R.string.smarthome_add_divece_suscess, 0).show();
                        }
                    });
                }
            } else if (!"ryeex.bracelet.sake".equals(bleDevice2.model) || (O0000Ooo2 = fno.O000000o().O0000Ooo("ryeex.bracelet.sake")) == null || O0000Ooo2.size() <= 0) {
                String str6 = bleDevice2.model;
                PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(str6);
                if (O00000oO2 != null && O00000oO2.O00000o() == 4) {
                    gsy.O00000o0(LogType.KUAILIAN, "DeviceAdapter", "click ble device, scType is QR_CAMEAR(4),model=".concat(String.valueOf(str6)));
                    fbt fbt2 = new fbt(this.f6906O000000o, "SmartConfigMainActivity");
                    fbt2.O000000o("strategy_id", 9);
                    fbt2.O000000o("use_reset_page", false);
                    fbt2.O000000o("connect_source", 1);
                    fbt2.O000000o("connect_unique", UUID.randomUUID().toString());
                    fbt2.O000000o("model", str6);
                    if (!TextUtils.isEmpty(this.O00000o)) {
                        fbt2.O000000o("bssid", this.O00000o);
                        fbt2.O000000o("password", this.O00000oO);
                    }
                    fbt2.O000000o("from_miui", this.O00000o0);
                    fbt2.O000000o(600);
                    fbs.O000000o(fbt2);
                } else if (foc.O00000Oo(bleDevice2.mac) == 1 || !(bleDevice2 == null || bleDevice.O00000Oo() == null || bleDevice.O00000Oo().O00000oo == null)) {
                    if (!gnl.O000000o() || gnl.O00000Oo()) {
                        O000000o(bleDevice2);
                    } else {
                        fmd.O000000o(new BleResponse() {
                            /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass4 */

                            public final void onResponse(int i, Object obj) {
                                ChooseConnectDeviceAdapter.this.O000000o(bleDevice2);
                            }
                        });
                    }
                } else if (ftn.O00000o(CoreApi.O000000o().O0000ooO())) {
                    MLAlertDialog mLAlertDialog = this.O0000o0O;
                    if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
                        this.O0000o0O.dismiss();
                    }
                    this.O0000o0O = new MLAlertDialog.Builder(this.f6906O000000o).O000000o(this.f6906O000000o.getString(R.string.license_title)).O000000o(O00000Oo(bleDevice2)).O00000Oo(this.f6906O000000o.getString(R.string.license_negative_btn), (DialogInterface.OnClickListener) null).O000000o(this.f6906O000000o.getString(R.string.license_positive_btn), new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            BleDevice bleDevice = bleDevice2;
                            ArrayList<String> O0000o00 = (!(bleDevice instanceof BleDeviceGroup) || ((BleDeviceGroup) bleDevice).O0000o00().size() <= 0) ? null : ((BleDeviceGroup) bleDevice2).O0000o00();
                            if (CoreApi.O000000o().O00000o(bleDevice2.model)) {
                                Intent intent = new Intent();
                                fqy.O000000o(intent, 1);
                                hxi.O00000o.O000000o(bleDevice2.model, 1, intent.getStringExtra("connect_unique"));
                                fod.O000000o(ChooseConnectDeviceAdapter.this.f6906O000000o, bleDevice2, intent, O0000o00);
                                hxc.O000000o().O000000o(bleDevice2.model, 1);
                                Long l = ChooseConnectDeviceAdapter.this.O0000Oo0.get(bleDevice2.mac);
                                if (l != null) {
                                    hxc.O000000o().O000000o(bleDevice2.model, BindStep.STEP_SCAN_DEVICE, ChooseConnectDeviceAdapter.this.O0000OOo, l.longValue());
                                    return;
                                }
                                return;
                            }
                            Intent actionByDeviceRenderer = hna.O00000Oo().getActionByDeviceRenderer(bleDevice2, ChooseConnectDeviceAdapter.this.f6906O000000o, null);
                            if (actionByDeviceRenderer != null) {
                                ChooseConnectDeviceAdapter.this.O00000Oo.startActivity(actionByDeviceRenderer);
                            }
                        }
                    }).O00000oo();
                } else {
                    if (bleDevice2 instanceof BleDeviceGroup) {
                        BleDeviceGroup bleDeviceGroup = (BleDeviceGroup) bleDevice2;
                        if (bleDeviceGroup.O0000o00().size() > 0) {
                            arrayList = bleDeviceGroup.O0000o00();
                            if (!CoreApi.O000000o().O00000o(bleDevice2.model)) {
                                Intent intent = new Intent();
                                fqy.O000000o(intent, 1);
                                hxi.O00000o.O000000o(bleDevice2.model, 1, intent.getStringExtra("connect_unique"));
                                fod.O000000o(this.f6906O000000o, bleDevice2, intent, arrayList);
                                hxc.O000000o().O000000o(bleDevice2.model, 1);
                                Long l2 = this.O0000Oo0.get(bleDevice2.mac);
                                if (l2 != null) {
                                    hxc.O000000o().O000000o(bleDevice2.model, BindStep.STEP_SCAN_DEVICE, this.O0000OOo, l2.longValue());
                                    return;
                                }
                                return;
                            }
                            Intent actionByDeviceRenderer = hna.O00000Oo().getActionByDeviceRenderer(bleDevice2, this.f6906O000000o, null);
                            if (actionByDeviceRenderer != null) {
                                this.O00000Oo.startActivity(actionByDeviceRenderer);
                                return;
                            }
                            return;
                        }
                    }
                    arrayList = null;
                    if (!CoreApi.O000000o().O00000o(bleDevice2.model)) {
                    }
                }
            } else {
                Context context = this.f6906O000000o;
                izb.O000000o(context, context.getResources().getText(R.string.already_bind_one_device), 0).show();
            }
        } else {
            O000000o(new XiaomiRedMiRouter15(scanResult2.SSID, pluginDeviceInfo.O00000Oo()));
        }
    }

    /* renamed from: com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f6919O000000o = new int[ScanDeviceType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f6919O000000o[ScanDeviceType.AIOT.ordinal()] = 1;
            f6919O000000o[ScanDeviceType.AP.ordinal()] = 2;
            f6919O000000o[ScanDeviceType.AP_DIRECT.ordinal()] = 3;
            f6919O000000o[ScanDeviceType.BLE.ordinal()] = 4;
            f6919O000000o[ScanDeviceType.MI_TV.ordinal()] = 5;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, android.net.wifi.ScanResult]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
    public static void O000000o(Context context, String str, ScanResult scanResult) {
        fbt fbt = new fbt(context, "ConfigRouterStationActivity");
        fbt.O000000o("model", str);
        fbt.O000000o("mac", scanResult.BSSID);
        fbt.O000000o("scanResult", (Parcelable) scanResult);
        fbs.O000000o(fbt);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, android.net.wifi.ScanResult]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
    public static void O00000Oo(Context context, String str, ScanResult scanResult) {
        fbt fbt = new fbt(context, "ConfigRouterSubDeviceActivity");
        fbt.O000000o("device_model", str);
        fbt.O000000o("key_qrcode_oob", "");
        fbt.O000000o("mac", scanResult.BSSID);
        fbt.O000000o("scanResult", (Parcelable) scanResult);
        fbs.O000000o(fbt);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002c, code lost:
        if (_m_j.fea.O000000o(r9.O00000Oo().f6871O000000o.O0000Oo0) == false) goto L_0x0031;
     */
    public final void O000000o(BleDevice bleDevice) {
        int i;
        gsy.O000000o(4, "ChooseDevice", "Config Comb device BEGIN.");
        boolean z = false;
        if (bleDevice.O00000Oo() == null || bleDevice.O00000Oo().f6871O000000o == null) {
            i = 0;
        } else {
            i = bleDevice.O00000Oo().f6871O000000o.O0000OOo;
        }
        z = true;
        if ((i == 0 || i == 2) && z) {
            fbt fbt = new fbt(this.f6906O000000o, "SmartConfigMainActivity");
            fbt.O000000o("connect_source", 1);
            String uuid = UUID.randomUUID().toString();
            fbt.O000000o("connect_unique", uuid);
            hxi.O00000o.O000000o(bleDevice.model, 1, uuid);
            fbt.O000000o("strategy_id", 13);
            fbt.O000000o("model", bleDevice.model);
            fbt.O000000o("combo_ble_mac", bleDevice.mac);
            if (bleDevice.O00000Oo() != null) {
                fbt.O000000o("combo_ble_key", bleDevice.O00000Oo().O00000oo);
            }
            if (!TextUtils.isEmpty(this.O00000o)) {
                fbt.O000000o("bssid", this.O00000o);
                fbt.O000000o("password", this.O00000oO);
            }
            fbt.O000000o("from_miui", this.O00000o0);
            fbt.O000000o(600);
            fbs.O000000o(fbt);
            hxc.O000000o().O000000o(bleDevice.model, 1);
            Long l = this.O0000Oo0.get(bleDevice.mac);
            if (l != null) {
                hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_SCAN_DEVICE, this.O0000OOo, l.longValue());
                return;
            }
            return;
        }
        gsy.O000000o(6, "ChooseDevice", "don't support authMode: ".concat(String.valueOf(i)));
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass3 */

            public final void run() {
                izb.O000000o(CommonApplication.getAppContext(), CommonApplication.getAppContext().getResources().getString(R.string.device_not_support_now), 0).show();
            }
        });
    }

    private void O00000o0(Collection<?> collection) {
        this.O0000o.clear();
        for (Object next : collection) {
            if (next instanceof PushBindEntity) {
                O000000o(((PushBindEntity) next).O0000OOo);
            } else if (next instanceof ScanResult) {
                O000000o(DeviceFactory.O0000Ooo(((ScanResult) next).SSID));
            } else if (next instanceof XiaomiRedMiRouter15) {
                O000000o(((XiaomiRedMiRouter15) next).mRealModel);
            } else if ((next instanceof BleDeviceGroup) && DeviceScanManager.isSpecialBleGroup((BleDevice) next)) {
                O000000o(((BleDeviceGroup) next).model);
            }
        }
    }

    private void O000000o(String str) {
        int i;
        Integer num = this.O0000o.get(str);
        if (num == null) {
            i = 1;
        } else {
            i = Integer.valueOf(num.intValue() + 1);
        }
        this.O0000o.put(str, i);
    }

    private SpannableStringBuilder O00000Oo(final BleDevice bleDevice) {
        String string = this.f6906O000000o.getString(R.string.license_content);
        int indexOf = string.indexOf("#start#");
        int indexOf2 = string.indexOf("#end#") - 7;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string.replace("#start#", "").replace("#end#", ""));
        AnonymousClass6 r0 = new ClickableSpan() {
            /* class com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter.AnonymousClass6 */

            public final void onClick(View view) {
                fbt fbt = new fbt(ChooseConnectDeviceAdapter.this.f6906O000000o, "GDPRLicenseActivity");
                fbt.O00000Oo(268435456).O000000o("key_model", bleDevice.model);
                fbs.O000000o(fbt);
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor("#0099ff"));
                textPaint.setUnderlineText(false);
            }
        };
        if (indexOf >= 0 && indexOf2 > 0) {
            try {
                spannableStringBuilder.setSpan(r0, indexOf, indexOf2, 33);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return spannableStringBuilder;
    }
}

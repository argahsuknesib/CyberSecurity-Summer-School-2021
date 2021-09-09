package com.xiaomi.smarthome.wificonfig;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fcb;
import _m_j.fmw;
import _m_j.fnn;
import _m_j.fno;
import _m_j.fuf;
import _m_j.gfq;
import _m_j.gnn;
import _m_j.gog;
import _m_j.gri;
import _m_j.gsy;
import _m_j.gty;
import _m_j.gwi;
import _m_j.gwj;
import _m_j.htp;
import _m_j.huh;
import _m_j.hul;
import _m_j.hvb;
import _m_j.iab;
import _m_j.iae;
import _m_j.iag;
import _m_j.jdn;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshLinearLayout;
import com.xiaomi.smarthome.library.common.widget.ExpandListView;
import com.xiaomi.smarthome.library.common.widget.PieProgressBar;
import com.xiaomi.smarthome.library.common.widget.ResizeLayout;
import com.xiaomi.smarthome.library.common.widget.SlideImageView;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.WifiInfo;
import com.xiaomi.smarthome.wificonfig.BaseWifiSettingUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BaseWifiSetting extends CommonActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    protected WifiManager f11915O000000o;
    protected ConnectivityManager O00000Oo;
    protected List<iag.O000000o> O00000o = new ArrayList();
    protected List<iag.O000000o> O00000o0 = new ArrayList();
    protected int O00000oO = -1;
    ScanResult O00000oo;
    String O0000O0o;
    String O0000OOo;
    protected boolean O0000Oo = false;
    String O0000Oo0;
    protected boolean O0000OoO = false;
    protected Class<?> O0000Ooo = null;
    protected long O0000o;
    protected String O0000o0;
    protected boolean O0000o00 = false;
    protected State O0000o0O;
    protected boolean O0000o0o;
    TextView O0000oO;
    protected fuf.O00000o0 O0000oO0;
    boolean O0000oOO = false;
    protected boolean O0000oOo = true;
    protected Handler O0000oo = new Handler() {
        /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass12 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Removed duplicated region for block: B:167:0x0400  */
        /* JADX WARNING: Removed duplicated region for block: B:219:0x066f A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:220:0x0670  */
        /* JADX WARNING: Removed duplicated region for block: B:237:0x06db  */
        /* JADX WARNING: Removed duplicated region for block: B:256:0x076a  */
        /* JADX WARNING: Removed duplicated region for block: B:265:0x0796  */
        /* JADX WARNING: Removed duplicated region for block: B:271:0x07f7  */
        public final void handleMessage(Message message) {
            ScanResult scanResult;
            List<ScanResult> scanResults;
            int i;
            ScanResult scanResult2;
            boolean z;
            int i2;
            int i3;
            boolean z2;
            String str;
            ScanResult scanResult3;
            float f;
            float f2;
            Message message2 = message;
            char c = 3;
            WifiInfo wifiInfo = null;
            boolean z3 = true;
            switch (message2.what) {
                case 100:
                case 104:
                    if (!BaseWifiSetting.this.mIsDestory) {
                        android.net.wifi.WifiInfo connectionInfo = BaseWifiSetting.this.f11915O000000o.getConnectionInfo();
                        if (BaseWifiSetting.this.O0000o0O == State.SCANNING || BaseWifiSetting.this.O0000o0O == State.RECANNINGINPUT) {
                            if (BaseWifiSetting.this.O00000oO != -1) {
                                if (BaseWifiSetting.this.O0000Oo) {
                                    if (BaseWifiSetting.this.O00000oO < BaseWifiSetting.this.O00000o.size()) {
                                        scanResult = BaseWifiSetting.this.O00000o.get(BaseWifiSetting.this.O00000oO).f1089O000000o;
                                        scanResults = BaseWifiSetting.this.f11915O000000o.getScanResults();
                                        BaseWifiSetting.this.O00000o0.clear();
                                        BaseWifiSetting.this.m5GScanResult.clear();
                                        BaseWifiSetting.this.O00000o.clear();
                                        HashMap hashMap = new HashMap();
                                        HashMap hashMap2 = new HashMap();
                                        String str2 = null;
                                        i = 0;
                                        while (i < scanResults.size()) {
                                            if (!TextUtils.isEmpty(scanResults.get(i).SSID) && !DeviceFactory.O00000oo(scanResults.get(i))) {
                                                boolean O00000o0 = iag.O00000o0(scanResults.get(i));
                                                boolean z4 = gfq.O000000o().O000000o(scanResults.get(i).BSSID) != null;
                                                if (connectionInfo != null && iag.O000000o(connectionInfo.getSSID(), scanResults.get(i).SSID) && O00000o0 && scanResults.get(i).frequency > 5000) {
                                                    String[] split = scanResults.get(i).BSSID.split("\\:");
                                                    Object[] objArr = new Object[6];
                                                    objArr[0] = split[0];
                                                    objArr[1] = split[1];
                                                    objArr[2] = split[2];
                                                    objArr[c] = split[c];
                                                    objArr[4] = split[4];
                                                    objArr[5] = Integer.valueOf(Integer.valueOf(split[5], 16).intValue() - 1);
                                                    str2 = String.format("%1$s:%2$s:%3$s:%4$s:%5$s:%6$x", objArr);
                                                }
                                                if (scanResults.get(i).frequency > 5000 || scanResults.get(i).capabilities.contains("WEP") || scanResults.get(i).capabilities.contains("EAP") || scanResults.get(i).capabilities.contains("WAPI-KEY") || scanResults.get(i).capabilities.contains("WAPI-PSK") || scanResults.get(i).capabilities.contains("WAPI-CERT") || iag.O00000Oo(scanResults.get(i)) == 0 || scanResults.get(i).level == 0 || BaseWifiSetting.this.isContainUnsupportChar(scanResults.get(i).SSID)) {
                                                    iag.O000000o o000000o = new iag.O000000o();
                                                    o000000o.O00000o0 = O00000o0;
                                                    o000000o.O00000Oo = z4;
                                                    o000000o.f1089O000000o = scanResults.get(i);
                                                    if (scanResults.get(i).frequency > 5000) {
                                                        BaseWifiSetting.this.m5GScanResult.add(o000000o);
                                                    }
                                                    if (!hashMap2.containsKey(scanResults.get(i).SSID)) {
                                                        BaseWifiSetting.this.O00000o.add(o000000o);
                                                        hashMap2.put(scanResults.get(i).SSID, o000000o);
                                                    } else if (iag.O00000Oo(scanResults.get(i).level) > iag.O00000Oo(((iag.O000000o) hashMap2.get(scanResults.get(i).SSID)).f1089O000000o.level)) {
                                                        iag.O000000o o000000o2 = (iag.O000000o) hashMap2.get(scanResults.get(i).SSID);
                                                        hashMap.remove(o000000o.f1089O000000o.SSID);
                                                        hashMap.put(scanResults.get(i).SSID, o000000o);
                                                        BaseWifiSetting.this.O00000o.remove(o000000o2);
                                                        BaseWifiSetting.this.O00000o.add(o000000o2);
                                                    }
                                                } else {
                                                    iag.O000000o o000000o3 = new iag.O000000o();
                                                    o000000o3.O00000o0 = O00000o0;
                                                    o000000o3.O00000Oo = z4;
                                                    o000000o3.f1089O000000o = scanResults.get(i);
                                                    if (!hashMap.containsKey(scanResults.get(i).SSID)) {
                                                        BaseWifiSetting.this.O00000o0.add(o000000o3);
                                                        hashMap.put(scanResults.get(i).SSID, o000000o3);
                                                    } else if (iag.O00000Oo(scanResults.get(i).level) > iag.O00000Oo(((iag.O000000o) hashMap.get(scanResults.get(i).SSID)).f1089O000000o.level)) {
                                                        iag.O000000o o000000o4 = (iag.O000000o) hashMap.get(scanResults.get(i).SSID);
                                                        hashMap.remove(o000000o4.f1089O000000o.SSID);
                                                        hashMap.put(scanResults.get(i).SSID, o000000o3);
                                                        BaseWifiSetting.this.O00000o0.remove(o000000o4);
                                                        BaseWifiSetting.this.O00000o.remove(o000000o4);
                                                        BaseWifiSetting.this.O00000o.add(o000000o3);
                                                    }
                                                }
                                            }
                                            i++;
                                            c = 3;
                                        }
                                        AnonymousClass1 r3 = new Comparator<iag.O000000o>() {
                                            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass12.AnonymousClass1 */

                                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                                return ((iag.O000000o) obj).f1089O000000o.SSID.compareTo(((iag.O000000o) obj2).f1089O000000o.SSID);
                                            }
                                        };
                                        Collections.sort(BaseWifiSetting.this.O00000o0, r3);
                                        Collections.sort(BaseWifiSetting.this.O00000o, r3);
                                        if (!BaseWifiSetting.this.O000000o()) {
                                            if (BaseWifiSetting.this.O00000oO != -1) {
                                                if (scanResult != null) {
                                                    int i4 = 0;
                                                    while (i4 < BaseWifiSetting.this.O00000o0.size()) {
                                                        if (scanResult.BSSID.equalsIgnoreCase(BaseWifiSetting.this.O00000o0.get(i4).f1089O000000o.BSSID)) {
                                                            BaseWifiSetting baseWifiSetting = BaseWifiSetting.this;
                                                            baseWifiSetting.O00000oO = i4;
                                                            baseWifiSetting.mWifiChooser.setText(BaseWifiSetting.this.O00000o0.get(i4).f1089O000000o.SSID);
                                                        } else if (str2 == null || !scanResult.BSSID.equalsIgnoreCase(str2)) {
                                                            i4++;
                                                        } else {
                                                            BaseWifiSetting baseWifiSetting2 = BaseWifiSetting.this;
                                                            baseWifiSetting2.O00000oO = i4;
                                                            baseWifiSetting2.mWifiChooser.setText(BaseWifiSetting.this.O00000o0.get(i4).f1089O000000o.SSID);
                                                        }
                                                        z2 = true;
                                                        if (!z2) {
                                                            BaseWifiSetting baseWifiSetting3 = BaseWifiSetting.this;
                                                            baseWifiSetting3.O00000oO = -1;
                                                            baseWifiSetting3.mWifiChooser.setText((int) R.string.wifi_setting_choose);
                                                        }
                                                    }
                                                }
                                                z2 = false;
                                                if (!z2) {
                                                }
                                            } else {
                                                if (!(connectionInfo == null || connectionInfo.getBSSID() == null)) {
                                                    int i5 = 0;
                                                    while (i5 < BaseWifiSetting.this.O00000o0.size()) {
                                                        if (connectionInfo.getBSSID().equalsIgnoreCase(BaseWifiSetting.this.O00000o0.get(i5).f1089O000000o.BSSID)) {
                                                            BaseWifiSetting baseWifiSetting4 = BaseWifiSetting.this;
                                                            baseWifiSetting4.O00000oO = i5;
                                                            baseWifiSetting4.mWifiChooser.setText(BaseWifiSetting.this.O00000o0.get(i5).f1089O000000o.SSID);
                                                        } else if (str2 == null || !BaseWifiSetting.this.O00000o0.get(i5).f1089O000000o.BSSID.equalsIgnoreCase(str2)) {
                                                            i5++;
                                                        } else {
                                                            BaseWifiSetting baseWifiSetting5 = BaseWifiSetting.this;
                                                            baseWifiSetting5.O00000oO = i5;
                                                            baseWifiSetting5.mWifiChooser.setText(BaseWifiSetting.this.O00000o0.get(i5).f1089O000000o.SSID);
                                                        }
                                                        z = true;
                                                        if (!TextUtils.isEmpty(BaseWifiSetting.this.O0000OOo)) {
                                                            i2 = 0;
                                                            while (true) {
                                                                if (i2 < BaseWifiSetting.this.O00000o0.size()) {
                                                                    if (BaseWifiSetting.this.O0000OOo.equalsIgnoreCase(BaseWifiSetting.this.O00000o0.get(i2).f1089O000000o.BSSID)) {
                                                                        i3 = -1;
                                                                    } else {
                                                                        i2++;
                                                                    }
                                                                }
                                                            }
                                                            if (i2 != i3) {
                                                                BaseWifiSetting baseWifiSetting6 = BaseWifiSetting.this;
                                                                baseWifiSetting6.O00000oO = i2;
                                                                if (baseWifiSetting6.O0000Oo0 != null) {
                                                                    gwj.O000000o o000000o5 = new gwj.O000000o();
                                                                    o000000o5.O00000oO = BaseWifiSetting.this.O00000o0.get(BaseWifiSetting.this.O00000oO).f1089O000000o.BSSID;
                                                                    if (o000000o5.O00000oO == null) {
                                                                        o000000o5.O00000oO = "";
                                                                    }
                                                                    o000000o5.O00000o0 = BaseWifiSetting.this.O00000o0.get(BaseWifiSetting.this.O00000oO).f1089O000000o.SSID;
                                                                    o000000o5.O00000oo = BaseWifiSetting.this.O00000o0.get(BaseWifiSetting.this.O00000oO).f1089O000000o.capabilities;
                                                                    o000000o5.O00000o = BaseWifiSetting.this.O0000Oo0;
                                                                    o000000o5.O00000Oo = true;
                                                                    gfq.O000000o().O000000o(o000000o5);
                                                                }
                                                            } else if (!z) {
                                                                BaseWifiSetting baseWifiSetting7 = BaseWifiSetting.this;
                                                                baseWifiSetting7.O00000oO = -1;
                                                                baseWifiSetting7.mWifiChooser.setText((int) R.string.wifi_setting_choose);
                                                            }
                                                        }
                                                        i3 = -1;
                                                        i2 = -1;
                                                        if (i2 != i3) {
                                                        }
                                                    }
                                                }
                                                z = false;
                                                if (!TextUtils.isEmpty(BaseWifiSetting.this.O0000OOo)) {
                                                }
                                                i3 = -1;
                                                i2 = -1;
                                                if (i2 != i3) {
                                                }
                                            }
                                            BaseWifiSetting.this.mScanWifi.setVisibility(8);
                                            BaseWifiSetting.this.O0000o0O = State.INPUT;
                                            if (BaseWifiSetting.this.O00000oO != -1 && !fmw.O000000o().O000000o(BaseWifiSetting.this.O00000o0.get(BaseWifiSetting.this.O00000oO).f1089O000000o.BSSID)) {
                                                BaseWifiSetting.this.O0000OoO = false;
                                            }
                                            BaseWifiSetting baseWifiSetting8 = BaseWifiSetting.this;
                                            if (baseWifiSetting8.O00000oO == -1) {
                                                scanResult2 = null;
                                            } else {
                                                scanResult2 = BaseWifiSetting.this.O00000o0.get(BaseWifiSetting.this.O00000oO).f1089O000000o;
                                            }
                                            baseWifiSetting8.checkShowPassword(scanResult2);
                                            BaseWifiSetting.this.checkConfirmEnabled();
                                            BaseWifiSetting.this.mPasswordEditor.setEnabled(true);
                                            BaseWifiSetting.this.mWifiChooser.setEnabled(true);
                                            BaseWifiSetting.this.findViewById(R.id.wifi_ssid_toggle).setEnabled(true);
                                            BaseWifiSetting.this.mPasswordToggle.setEnabled(true);
                                            BaseWifiSetting.this.O0000oo.removeMessages(104);
                                            if (BaseWifiSetting.this.mSmartConfigList.getVisibility() == 0) {
                                                BaseWifiSetting.this.mConnAdapter.notifyDataSetChanged();
                                                BaseWifiSetting.this.mUnConnectAdapter.notifyDataSetChanged();
                                                BaseWifiSetting.this.mSmartConfigList.O00000Oo();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    BaseWifiSetting.this.O00000oO = -1;
                                } else if (BaseWifiSetting.this.O00000oO < BaseWifiSetting.this.O00000o0.size()) {
                                    scanResult = BaseWifiSetting.this.O00000o0.get(BaseWifiSetting.this.O00000oO).f1089O000000o;
                                    scanResults = BaseWifiSetting.this.f11915O000000o.getScanResults();
                                    BaseWifiSetting.this.O00000o0.clear();
                                    BaseWifiSetting.this.m5GScanResult.clear();
                                    BaseWifiSetting.this.O00000o.clear();
                                    HashMap hashMap3 = new HashMap();
                                    HashMap hashMap22 = new HashMap();
                                    String str22 = null;
                                    i = 0;
                                    while (i < scanResults.size()) {
                                    }
                                    AnonymousClass1 r32 = new Comparator<iag.O000000o>() {
                                        /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass12.AnonymousClass1 */

                                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                                            return ((iag.O000000o) obj).f1089O000000o.SSID.compareTo(((iag.O000000o) obj2).f1089O000000o.SSID);
                                        }
                                    };
                                    Collections.sort(BaseWifiSetting.this.O00000o0, r32);
                                    Collections.sort(BaseWifiSetting.this.O00000o, r32);
                                    if (!BaseWifiSetting.this.O000000o()) {
                                    }
                                } else {
                                    BaseWifiSetting.this.O00000oO = -1;
                                }
                            }
                            scanResult = null;
                            scanResults = BaseWifiSetting.this.f11915O000000o.getScanResults();
                            BaseWifiSetting.this.O00000o0.clear();
                            BaseWifiSetting.this.m5GScanResult.clear();
                            BaseWifiSetting.this.O00000o.clear();
                            HashMap hashMap32 = new HashMap();
                            HashMap hashMap222 = new HashMap();
                            String str222 = null;
                            i = 0;
                            while (i < scanResults.size()) {
                            }
                            AnonymousClass1 r322 = new Comparator<iag.O000000o>() {
                                /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass12.AnonymousClass1 */

                                public final /* synthetic */ int compare(Object obj, Object obj2) {
                                    return ((iag.O000000o) obj).f1089O000000o.SSID.compareTo(((iag.O000000o) obj2).f1089O000000o.SSID);
                                }
                            };
                            Collections.sort(BaseWifiSetting.this.O00000o0, r322);
                            Collections.sort(BaseWifiSetting.this.O00000o, r322);
                            if (!BaseWifiSetting.this.O000000o()) {
                            }
                        } else if (BaseWifiSetting.this.O0000o0O == State.RESCANNING) {
                            BaseWifiSetting baseWifiSetting9 = BaseWifiSetting.this;
                            baseWifiSetting9.O000000o(baseWifiSetting9.O0000o0);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                    break;
                case 101:
                    NetworkInfo networkInfo = (NetworkInfo) message2.obj;
                    NetworkInfo.DetailedState detailedState = networkInfo.getDetailedState();
                    gsy.O00000Oo(LogType.KUAILIAN, "WifiState", detailedState.toString());
                    android.net.wifi.WifiInfo connectionInfo2 = BaseWifiSetting.this.f11915O000000o.getConnectionInfo();
                    if (!(detailedState == NetworkInfo.DetailedState.DISCONNECTED && BaseWifiSetting.this.O0000o0O == State.DEVICE_SEARCHING)) {
                        if (connectionInfo2 != null && !TextUtils.isEmpty(connectionInfo2.getSSID()) && !connectionInfo2.getSSID().contains("<unknown ssid>") && detailedState == NetworkInfo.DetailedState.CONNECTED && networkInfo.isConnected()) {
                            if (BaseWifiSetting.this.O0000o0O == State.CONNECTTING || BaseWifiSetting.this.O0000o0O == State.DEVICE_CONNECTING || BaseWifiSetting.this.O0000o0O == State.DEVICE_SEARCHING) {
                                gsy.O00000Oo(LogType.KUAILIAN, "MSG", "Wifi Connected");
                                LogType logType = LogType.KUAILIAN;
                                StringBuilder sb = new StringBuilder("state = ");
                                if (BaseWifiSetting.this.O0000o0O != State.DEVICE_CONNECTING) {
                                    z3 = false;
                                }
                                sb.append(z3);
                                gsy.O00000Oo(logType, "MSG", sb.toString());
                                if (BaseWifiSetting.this.O0000o0O == State.DEVICE_CONNECTING || BaseWifiSetting.this.O0000o0O == State.DEVICE_SEARCHING) {
                                    BaseWifiSetting.this.O0000oo.removeMessages(103);
                                    BaseWifiSetting.this.onHandleMessage(message2);
                                    return;
                                }
                                if (BaseWifiSetting.this.O0000oO0 != null) {
                                    Iterator<WifiInfo> it = BaseWifiSetting.this.O0000oO0.f17173O000000o.iterator();
                                    while (it.hasNext()) {
                                        WifiInfo next = it.next();
                                        if (next.f11472O000000o > 0 && next.f11472O000000o < 20) {
                                            wifiInfo = next;
                                        }
                                    }
                                    str = wifiInfo.O00000o0;
                                } else {
                                    if (BaseWifiSetting.this.O0000Oo) {
                                        scanResult3 = BaseWifiSetting.this.O00000o.get(BaseWifiSetting.this.O00000oO).f1089O000000o;
                                    } else {
                                        scanResult3 = BaseWifiSetting.this.O00000o0.get(BaseWifiSetting.this.O00000oO).f1089O000000o;
                                    }
                                    str = scanResult3.SSID;
                                }
                                if (connectionInfo2 != null && iag.O000000o(connectionInfo2.getSSID(), str)) {
                                    BaseWifiSetting.this.saveWifiItem();
                                    fnn.O000000o().O000000o(BaseWifiSetting.this.mLastNetwork);
                                    BaseWifiSetting.this.O0000oo.removeMessages(103);
                                    BaseWifiSetting.this.onWifiConnectionSuccess();
                                    return;
                                } else if (!BaseWifiSetting.this.O0000oo.hasMessages(103) && BaseWifiSetting.this.O0000o0O == State.CONNECTTING) {
                                    BaseWifiSetting.this.onWifiConnectionFailed();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    break;
                case 102:
                    int wifiState = BaseWifiSetting.this.f11915O000000o.getWifiState();
                    gsy.O00000Oo(LogType.KUAILIAN, "WifiStateChanged", String.valueOf(wifiState));
                    if (wifiState == 3 && BaseWifiSetting.this.O0000o0O == State.SCANNING) {
                        BaseWifiSetting.this.f11915O000000o.startScan();
                        return;
                    }
                    return;
                case 103:
                    if (BaseWifiSetting.this.O0000o0O == State.DEVICE_CONNECTING) {
                        BaseWifiSetting.this.onHandleMessage(message2);
                        return;
                    } else if (BaseWifiSetting.this.O0000o0O == State.CONNECTTING) {
                        BaseWifiSetting.this.onWifiConnectionFailed();
                        return;
                    } else {
                        return;
                    }
                case 106:
                    if (((Boolean) message2.obj).booleanValue()) {
                        BaseWifiSetting.this.switchToDownloadingPage();
                        return;
                    } else if (BaseWifiSetting.this.O0000oo0) {
                        BaseWifiSetting.this.switchToFinalStepRescan();
                        return;
                    } else {
                        BaseWifiSetting.this.switchToFinalStep(false);
                        return;
                    }
                case 107:
                    BaseWifiSetting.this.mTopView.requestLayout();
                    return;
                case 108:
                    if (message2.arg1 == 0) {
                        BaseWifiSetting.this.onWifiConnectionSuccess();
                        return;
                    }
                    return;
                case 109:
                    BaseWifiSetting.this.startNetworkTest();
                    return;
                case 110:
                    BaseWifiSetting.this.switchToFouthStep();
                    return;
                case 111:
                    if ("yunyi.camera.v1".equals(BaseWifiSetting.this.O0000O0o) || "yunyi.camera.v2".equals(BaseWifiSetting.this.O0000O0o) || "chuangmi.camera.xiaobai".equals(BaseWifiSetting.this.O0000O0o)) {
                        f2 = ((float) (System.currentTimeMillis() - BaseWifiSetting.this.O0000o)) * 100.0f;
                        f = 120000.0f;
                    } else {
                        f2 = ((float) (System.currentTimeMillis() - BaseWifiSetting.this.O0000o)) * 100.0f;
                        f = 70000.0f;
                    }
                    float f3 = f2 / f;
                    if (f3 <= 101.0f) {
                        BaseWifiSetting.this.mFouthProgress.setPercent(f3);
                        BaseWifiSetting.this.mFouthMainSubView.setText(BaseWifiSetting.this.getConnStatusText());
                        BaseWifiSetting baseWifiSetting10 = BaseWifiSetting.this;
                        if (baseWifiSetting10.mDeviceCount > 0) {
                            baseWifiSetting10.mFouthMainSubView.setText(baseWifiSetting10.getResources().getQuantityString(R.plurals.kuailian_sub_main_device_complete, baseWifiSetting10.mDeviceCount, Integer.valueOf(baseWifiSetting10.mDeviceCount)));
                            baseWifiSetting10.mSubMainTitleView.setText((int) R.string.kuailian_sub_main_device_count);
                            baseWifiSetting10.mSubMainTitleView.setOnClickListener(null);
                            baseWifiSetting10.mStep = 3;
                            baseWifiSetting10.O0000oO.setVisibility(8);
                            baseWifiSetting10.mBtnProgressView.setVisibility(8);
                        }
                        BaseWifiSetting.this.O0000oo.sendEmptyMessageDelayed(111, 100);
                        return;
                    } else if (BaseWifiSetting.this.mDeviceCount > 0) {
                        BaseWifiSetting.this.switchToDownloadingPage();
                        return;
                    } else if (BaseWifiSetting.this.O0000oo0) {
                        BaseWifiSetting.this.switchToFinalStepRescan();
                        return;
                    } else {
                        BaseWifiSetting.this.switchToFinalStep(false);
                        return;
                    }
                case 113:
                    float currentTimeMillis = (((float) (System.currentTimeMillis() - BaseWifiSetting.this.O0000o)) * 100.0f) / 30000.0f;
                    if (currentTimeMillis > 101.0f) {
                        BaseWifiSetting.this.switchToFinalStep(false);
                        return;
                    }
                    BaseWifiSetting.this.mConfirmProgressView.setPercent(currentTimeMillis);
                    BaseWifiSetting.this.O0000oo.sendEmptyMessageDelayed(113, 100);
                    return;
                case 116:
                    BaseWifiSetting.this.mRouterView.setVisibility(8);
                    if ("yunyi.camera.v1".equals(BaseWifiSetting.this.O0000O0o) || "yunyi.camera.v2".equals(BaseWifiSetting.this.O0000O0o)) {
                        BaseWifiSetting.this.switchToSecondStep();
                        return;
                    } else {
                        BaseWifiSetting.this.switchToFirstStep();
                        return;
                    }
                case 117:
                    float currentTimeMillis2 = (((float) (System.currentTimeMillis() - BaseWifiSetting.this.O0000o)) * 100.0f) / 30000.0f;
                    if (currentTimeMillis2 <= 101.0f) {
                        BaseWifiSetting.this.mRouterProgress.setPercent(currentTimeMillis2);
                        BaseWifiSetting.this.O0000oo.sendEmptyMessageDelayed(117, 100);
                        return;
                    }
                    return;
                case 118:
                    BaseWifiSetting.this.mDownloadProgress.setPercent(((Float) message2.obj).floatValue() * 100.0f);
                    return;
                case 119:
                    float currentTimeMillis3 = (((float) (System.currentTimeMillis() - BaseWifiSetting.this.O0000o)) * 100.0f) / 30000.0f;
                    if (currentTimeMillis3 > 101.0f) {
                        BaseWifiSetting.this.switchToFinalStep(false);
                        fmw.O000000o().O00000Oo();
                        return;
                    }
                    BaseWifiSetting.this.mRescanDeviceProgress.setPercent(currentTimeMillis3);
                    BaseWifiSetting.this.O0000oo.sendEmptyMessageDelayed(119, 100);
                    return;
            }
            BaseWifiSetting.this.onHandleMessage(message2);
        }
    };
    protected boolean O0000oo0 = true;
    private boolean O0000ooO;
    private TextView O0000ooo;
    private SimpleDraweeView O000O00o;
    private View[] O000O0OO = new View[6];
    private Button O000O0Oo;
    private Dialog O000O0o;
    private View O000O0o0;
    private ImageView O000O0oO;
    private ImageView O000O0oo;
    private TextView O000OO;
    private SlideImageView O000OO00;
    private ImageView O000OO0o;
    private TextView O000OOOo;
    private TextView O000OOo;
    private TextView O000OOo0;
    private TextView O000OOoO;
    private TextView O000OOoo;
    private View O000Oo0;
    private boolean O000Oo00 = false;
    private TextView O000Oo0O;
    private TextView O000Oo0o;
    private boolean O000OoO = false;
    private TextView O000OoO0;
    private BroadcastReceiver O000OoOO = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                BaseWifiSetting.this.O0000oo.sendEmptyMessage(100);
            } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    Message obtainMessage = BaseWifiSetting.this.O0000oo.obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.obj = (NetworkInfo) parcelableExtra;
                    BaseWifiSetting.this.O0000oo.sendMessage(obtainMessage);
                }
            } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                BaseWifiSetting.this.O0000oo.sendEmptyMessage(102);
            }
        }
    };
    private View O00O0Oo;
    private CheckBox O00oOoOo;
    private TextView O00oOooO;
    private TextView O00oOooo;
    public List<iag.O000000o> m5GScanResult = new ArrayList();
    public Button mBtnProgressView;
    public PieProgressBar mConfirmProgressView;
    public BaseAdapter mConnAdapter;
    public ListView mConnectList;
    public List<Device> mConnectedDevice = new ArrayList();
    public CheckBox mCreateLauncher;
    public int mDeviceCount = 0;
    public PieProgressBar mDownloadProgress;
    public View mFinalErrorContainer;
    public TextView mFouthMainSubView;
    public PieProgressBar mFouthProgress;
    public View mInputMarginView;
    public boolean mIsActivityFinished = false;
    public boolean mIsDestory = false;
    public int mLastNetwork = -1;
    public TextView mMainTitleView;
    public EditText mPasswordEditor;
    public EditText mPasswordEditorAbove;
    public ImageView mPasswordToggle;
    public PieProgressBar mRescanDeviceProgress;
    public PieProgressBar mRouterProgress;
    public TextView mRouterSwitchTitle;
    public boolean mRouterTest = false;
    public View mRouterView;
    public View mScanWifi;
    public CustomPullDownRefreshLinearLayout mSmartConfigList;
    public View mStartDownloadPluginPage;
    public int mStep;
    public TextView mSubMainTitleView;
    public View mTopMarginView;
    public ResizeLayout mTopView;
    public BaseAdapter mUnConnectAdapter;
    public ListView mUnConnectList;
    public TextView mWifiChooser;

    enum State {
        SCANNING,
        INPUT,
        RECANNINGINPUT,
        RESCANNING,
        CONNECTTING,
        CONNECTTING_AP,
        DEVICE_CONNECTING,
        DEVICE_SEARCHING,
        STOP_CONNECTION,
        RESCAN_DEVICE
    }

    public String getConnStatusText() {
        return null;
    }

    public String getErrorResultStr() {
        return "";
    }

    public void onHandleMessage(Message message) {
    }

    public void onStopConnection() {
    }

    public boolean setFailTextBtn(TextView textView) {
        return false;
    }

    public void startConnection() {
    }

    public boolean isContainUnsupportChar(String str) {
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            if ((b & 128) != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
    public void onBackPressed() {
        O00000o();
        if (this.O0000o0O == State.INPUT && this.mSmartConfigList.getVisibility() == 0) {
            O00000o0();
        } else if (this.O0000o0O == State.CONNECTTING) {
            this.O0000o0O = State.INPUT;
            switchToSecondStep();
            onStopConnection();
        } else if (this.O0000o0O == State.INPUT) {
            O000000o(false, false);
        } else {
            O000000o(false, true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z, boolean z2) {
        O00000o();
        if (z2) {
            gfq.O000000o().O00000Oo(gog.O00000Oo(this));
        }
        setResult(z ? -1 : 0, getIntent());
        finish();
        this.mIsActivityFinished = true;
    }

    public void onDeviceConnectionSuccess() {
        if (!this.O0000oo.hasMessages(111) || this.O00000oo != null) {
            O00000o();
            Message obtainMessage = this.O0000oo.obtainMessage();
            obtainMessage.what = 106;
            obtainMessage.obj = Boolean.TRUE;
            this.O0000oo.sendMessage(obtainMessage);
        }
    }

    public void onDeviceConnectionSuccess(List<Device> list, boolean z) {
        if (this.O0000oo.hasMessages(111) || this.O0000oo.hasMessages(119)) {
            if (z) {
                O00000o();
                Message obtainMessage = this.O0000oo.obtainMessage();
                obtainMessage.what = 106;
                obtainMessage.obj = Boolean.TRUE;
                this.O0000oo.sendMessage(obtainMessage);
            }
            this.mConnectedDevice.clear();
            this.mConnectedDevice.addAll(list);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void */
    public void onDeviceConnectionSuccessBind() {
        O00000o();
        O000000o(4, false);
        this.O000OOoO.setText(String.format(getString(R.string.kuailian_main_title_4), new Object[0]));
        ScanResult scanResult = this.O00000oo;
        if (scanResult == null || DeviceFactory.O00000Oo(scanResult) != "zhimi.airpurifier.v1") {
            this.O000OOoo.setText((int) R.string.kuailian_sub_main_title_4);
        } else {
            this.O000OOoo.setText((int) R.string.kuailian_sub_main_title_4_zhimi);
        }
        this.mConfirmProgressView.setPercentView((TextView) findViewById(R.id.confirm_progress_text));
        this.mConfirmProgressView.setOri(false);
        this.O0000o = System.currentTimeMillis();
        this.O0000oo.sendEmptyMessageDelayed(113, 100);
    }

    public void removeAllMsg() {
        this.O0000oo.removeMessages(111);
        this.O0000oo.removeMessages(113);
        this.O0000oo.removeMessages(104);
        this.O0000oo.removeMessages(103);
        this.O0000oo.removeMessages(109);
        this.O0000oo.removeMessages(110);
        this.O0000oo.removeMessages(111);
        this.O0000oo.removeMessages(112);
        this.O0000oo.removeMessages(114);
        this.O0000oo.removeMessages(111);
        iab.O000000o().O00000o0();
        iab.O000000o().O0000OOo = null;
    }

    public void onDeviceConnectionError() {
        if (!this.O0000oo.hasMessages(111)) {
            Message obtainMessage = this.O0000oo.obtainMessage();
            obtainMessage.what = 106;
            obtainMessage.obj = Boolean.FALSE;
            this.O0000oo.sendMessage(obtainMessage);
        }
    }

    public void onDeviceFindDevices(int i) {
        this.mDeviceCount = i;
    }

    private void O00000o() {
        removeAllMsg();
        iae.O00000o0.clear();
        iae.O00000oo.clear();
        fmw.O000000o().O00000Oo();
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0443  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x046f A[EDGE_INSN: B:60:0x046f->B:47:0x046f ?: BREAK  , SYNTHETIC] */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        this.mIsDestory = false;
        setContentView((int) R.layout.new_wifi_setting_layout);
        this.O000Oo00 = getIntent().getBooleanExtra("gotoBindView", false);
        this.f11915O000000o = (WifiManager) getApplicationContext().getSystemService("wifi");
        this.O00000Oo = (ConnectivityManager) getSystemService("connectivity");
        registerReceiver(this.O000OoOO, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        registerReceiver(this.O000OoOO, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        registerReceiver(this.O000OoOO, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        if (!(getIntent() == null || getIntent().getParcelableExtra("scanResult") == null)) {
            this.O00000oo = (ScanResult) getIntent().getParcelableExtra("scanResult");
        }
        if (getIntent() != null) {
            this.O0000O0o = getIntent().getStringExtra("model");
            if (!TextUtils.isEmpty(this.O0000O0o)) {
                SmartConfigRouterFactory.getStatPageV2Manager().reportKuailianOldResult(this.O0000O0o, "BaseWifiSetting", "onCreate");
            }
        }
        if (getIntent() != null) {
            this.O0000OOo = getIntent().getStringExtra("bssid");
        }
        if (getIntent() != null) {
            this.O0000Oo0 = getIntent().getStringExtra("password");
        }
        try {
            this.O0000OoO = O00000oo();
            if (iag.O000000o()) {
                this.O0000OoO = false;
            }
        } catch (Error unused) {
        }
        if (SmartConfigRouterFactory.getCoreApiManager().isInternationalServer()) {
            ServerBean globalSettingServer = SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingServer();
            if (globalSettingServer == null) {
                str = "";
            } else {
                str = globalSettingServer.f7546O000000o;
            }
            MiioLocalAPI.O000000o(str);
            this.O0000OoO = false;
        }
        if (Long.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()).longValue() > 2147483647L) {
            this.O0000OoO = false;
        }
        if (gnn.O00000oO) {
            this.O0000OoO = false;
        }
        this.O0000oO = (TextView) findViewById(R.id.finish_title);
        this.mMainTitleView = (TextView) findViewById(R.id.kuailian_common_main_title);
        this.mSubMainTitleView = (TextView) findViewById(R.id.kuailian_common_main_sub_title);
        this.O0000ooo = (TextView) findViewById(R.id.kuailian_common_main_sub_title_0);
        this.O00oOooO = (TextView) findViewById(R.id.kuailian_common_main_sub_title_1);
        this.O00oOooo = (TextView) findViewById(R.id.kuailian_common_main_sub_title_2);
        this.O0000ooo.setVisibility(8);
        this.O00oOooO.setVisibility(8);
        this.O00oOooo.setVisibility(8);
        this.mTopView = (ResizeLayout) findViewById(R.id.top_view);
        this.mTopView.setResizeListener(new ResizeLayout.O000000o() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass11 */

            public final void O000000o(int i, int i2) {
                int i3 = i - i2;
                if (i3 > 0) {
                    ViewGroup.LayoutParams layoutParams = BaseWifiSetting.this.mTopMarginView.getLayoutParams();
                    layoutParams.height = gri.O000000o(167.0f);
                    BaseWifiSetting.this.mTopMarginView.setLayoutParams(layoutParams);
                    ViewGroup.LayoutParams layoutParams2 = BaseWifiSetting.this.mInputMarginView.getLayoutParams();
                    layoutParams2.height = gri.O000000o(60.3f);
                    BaseWifiSetting.this.mInputMarginView.setLayoutParams(layoutParams2);
                    if (BaseWifiSetting.this.O0000o0O == State.INPUT) {
                        BaseWifiSetting.this.mSubMainTitleView.setVisibility(0);
                        BaseWifiSetting.this.mMainTitleView.setVisibility(0);
                    }
                } else if (i3 < 0) {
                    ViewGroup.LayoutParams layoutParams3 = BaseWifiSetting.this.mTopMarginView.getLayoutParams();
                    layoutParams3.height = gri.O000000o(10.0f);
                    BaseWifiSetting.this.mTopMarginView.setLayoutParams(layoutParams3);
                    ViewGroup.LayoutParams layoutParams4 = BaseWifiSetting.this.mInputMarginView.getLayoutParams();
                    layoutParams4.height = gri.O000000o(10.0f);
                    BaseWifiSetting.this.mInputMarginView.setLayoutParams(layoutParams4);
                    BaseWifiSetting.this.mSubMainTitleView.setVisibility(8);
                    BaseWifiSetting.this.mMainTitleView.setVisibility(8);
                }
                BaseWifiSetting.this.O0000oo.sendEmptyMessage(107);
            }
        });
        this.mTopMarginView = findViewById(R.id.top_view_margin);
        this.mInputMarginView = findViewById(R.id.input_view_margin);
        this.O000O00o = (SimpleDraweeView) findViewById(R.id.kuailian_common_icon);
        this.O000O00o.setHierarchy(new GenericDraweeHierarchyBuilder(this.O000O00o.getResources()).setFadeDuration(200).setPlaceholderImage(this.O000O00o.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
        this.mBtnProgressView = (Button) findViewById(R.id.next_btn);
        this.O000O0Oo = (Button) findViewById(R.id.next_btn_2);
        this.O0000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass13 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
             arg types: [int, int]
             candidates:
              com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
              com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
            public final void onClick(View view) {
                if (BaseWifiSetting.this.mStep == 2 && BaseWifiSetting.this.mFinalErrorContainer.getVisibility() == 0) {
                    BaseWifiSetting.this.switchToFouthStep();
                } else if (BaseWifiSetting.this.mStartDownloadPluginPage.getVisibility() == 0) {
                    BaseWifiSetting.this.O000000o(true, false);
                } else {
                    BaseWifiSetting.this.switchToSecondStep();
                    BaseWifiSetting.this.onStopConnection();
                    fmw.O000000o().O00000Oo();
                }
            }
        });
        this.mBtnProgressView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass14 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
             arg types: [int, int]
             candidates:
              com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
              com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
            public final void onClick(View view) {
                if (iag.O00000Oo(BaseWifiSetting.this.getApplicationContext()) && !Settings.canDrawOverlays(BaseWifiSetting.this.getApplicationContext())) {
                    MLAlertDialog.Builder builder = new MLAlertDialog.Builder(BaseWifiSetting.this.getContext());
                    builder.O00000Oo(BaseWifiSetting.this.getResources().getString(R.string.float_tip));
                    builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass14.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                            intent.setData(Uri.parse("package:" + BaseWifiSetting.this.getPackageName()));
                            BaseWifiSetting.this.startActivityForResult(intent, 100);
                        }
                    });
                    builder.O000000o(true);
                    builder.O00000o().show();
                } else if (BaseWifiSetting.this.mStep == 0) {
                    BaseWifiSetting.this.mRouterSwitchTitle.setVisibility(8);
                    if (BaseWifiSetting.this.O0000oO0 != null) {
                        BaseWifiSetting baseWifiSetting = BaseWifiSetting.this;
                        baseWifiSetting.O0000OoO = false;
                        if (baseWifiSetting.O0000oOo) {
                            BaseWifiSetting.this.switchToThirdStep();
                        } else {
                            BaseWifiSetting.this.switchToFouthStep();
                        }
                    } else if (BaseWifiSetting.this.mRouterTest) {
                        BaseWifiSetting.this.switchToSecondStep();
                    } else {
                        BaseWifiSetting.this.switchToSecondStep();
                    }
                } else if (BaseWifiSetting.this.mStep == 1) {
                    if (BaseWifiSetting.this.O0000o0o) {
                        BaseWifiSetting baseWifiSetting2 = BaseWifiSetting.this;
                        baseWifiSetting2.O0000o0 = baseWifiSetting2.mPasswordEditor.getText().toString();
                    }
                    if (BaseWifiSetting.this.O0000oOo) {
                        BaseWifiSetting.this.switchToThirdStep();
                    } else {
                        BaseWifiSetting.this.switchToFouthStep();
                    }
                } else if (BaseWifiSetting.this.mStep != 5 && BaseWifiSetting.this.mStep == 3) {
                    BaseWifiSetting.this.O000000o(false, false);
                }
            }
        });
        this.O000O0OO[0] = findViewById(R.id.first_step);
        this.mRouterSwitchTitle = (TextView) findViewById(R.id.router_switch_btn);
        this.mRouterSwitchTitle.setVisibility(4);
        this.O000O0OO[1] = findViewById(R.id.second_step);
        this.mPasswordToggle = (ImageView) findViewById(R.id.wifi_password_toggle);
        this.mPasswordEditor = (EditText) findViewById(R.id.wifi_password_editor);
        this.O000O0o0 = findViewById(R.id.wifi_setting_pass_container);
        this.mSmartConfigList = (CustomPullDownRefreshLinearLayout) findViewById(R.id.wifi_refresh_container);
        this.mSmartConfigList.setScrollView((ScrollView) findViewById(R.id.wifi_list_scroll_view));
        this.mSmartConfigList.setRefreshListener(new CustomPullDownRefreshLinearLayout.O00000o0() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass15 */

            public final void O000000o() {
                BaseWifiSetting.this.f11915O000000o.startScan();
                BaseWifiSetting.this.O0000o0O = State.RECANNINGINPUT;
            }
        });
        this.mConnectList = (ExpandListView) findViewById(R.id.conn_wifi_list);
        this.mUnConnectList = (ExpandListView) findViewById(R.id.unconn_wifi_list);
        this.mPasswordEditorAbove = (EditText) findViewById(R.id.wifi_password_editor_above);
        this.mPasswordEditor.setVisibility(8);
        ScanResult scanResult = this.O00000oo;
        if (scanResult != null) {
            this.O0000O0o = DeviceFactory.O00000Oo(scanResult);
        }
        this.mScanWifi = findViewById(R.id.searching_text);
        this.mPasswordToggle.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass16 */

            public final void onClick(View view) {
                if (BaseWifiSetting.this.O0000o0o) {
                    int selectionStart = BaseWifiSetting.this.mPasswordEditor.getSelectionStart();
                    if (!BaseWifiSetting.this.mPasswordToggle.isSelected()) {
                        BaseWifiSetting.this.mPasswordEditor.setInputType(144);
                        BaseWifiSetting.this.mPasswordToggle.setSelected(true);
                    } else {
                        BaseWifiSetting.this.mPasswordEditor.setInputType(129);
                        BaseWifiSetting.this.mPasswordToggle.setSelected(false);
                    }
                    BaseWifiSetting.this.mPasswordEditor.setSelection(selectionStart);
                }
            }
        });
        this.mPasswordToggle.setSelected(false);
        this.mPasswordEditor.setInputType(129);
        this.mPasswordEditorAbove.setInputType(129);
        this.mPasswordEditorAbove.setFocusable(false);
        this.mPasswordEditorAbove.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass17 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                BaseWifiSetting baseWifiSetting = BaseWifiSetting.this;
                baseWifiSetting.O0000o0o = true;
                baseWifiSetting.mPasswordEditor.setVisibility(0);
                BaseWifiSetting.this.mPasswordEditorAbove.setVisibility(8);
                BaseWifiSetting.this.mPasswordEditor.requestFocus();
                BaseWifiSetting.this.mPasswordToggle.setEnabled(true);
                BaseWifiSetting.this.mBtnProgressView.setEnabled(false);
                return false;
            }
        });
        this.mWifiChooser = (TextView) findViewById(R.id.login_wifi_ssid_chooser);
        this.mWifiChooser.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass18 */

            public final void onClick(View view) {
                BaseWifiSetting.this.mPasswordEditorAbove.clearFocus();
                BaseWifiSetting.this.O00000Oo();
                BaseWifiSetting baseWifiSetting = BaseWifiSetting.this;
                baseWifiSetting.mConnAdapter = new O000000o();
                BaseWifiSetting.this.mConnectList.setAdapter((ListAdapter) BaseWifiSetting.this.mConnAdapter);
                BaseWifiSetting baseWifiSetting2 = BaseWifiSetting.this;
                baseWifiSetting2.mUnConnectAdapter = new O00000Oo();
                BaseWifiSetting.this.mUnConnectList.setAdapter((ListAdapter) BaseWifiSetting.this.mUnConnectAdapter);
            }
        });
        findViewById(R.id.wifi_ssid_toggle).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass19 */

            public final void onClick(View view) {
                BaseWifiSetting.this.O00000Oo();
                BaseWifiSetting baseWifiSetting = BaseWifiSetting.this;
                baseWifiSetting.mConnAdapter = new O000000o();
                BaseWifiSetting.this.mConnectList.setAdapter((ListAdapter) BaseWifiSetting.this.mConnAdapter);
                BaseWifiSetting baseWifiSetting2 = BaseWifiSetting.this;
                baseWifiSetting2.mUnConnectAdapter = new O00000Oo();
                BaseWifiSetting.this.mUnConnectList.setAdapter((ListAdapter) BaseWifiSetting.this.mUnConnectAdapter);
            }
        });
        findViewById(R.id.wifi_ssid_toggle).setEnabled(false);
        this.O00oOoOo = (CheckBox) findViewById(R.id.check_box_save_passwd);
        this.O00oOoOo.setChecked(true);
        this.O000O0OO[2] = findViewById(R.id.third_step);
        this.O000O0oO = (ImageView) findViewById(R.id.left_icon_view);
        this.O000O0oo = (ImageView) findViewById(R.id.right_icon_view);
        this.O000OO00 = (SlideImageView) findViewById(R.id.center_icon_view);
        this.O000OO0o = (ImageView) findViewById(R.id.center_result_view);
        this.O000OO = (TextView) findViewById(R.id.connecting_main_title);
        this.O000OOOo = (TextView) findViewById(R.id.connecting_main_sub_title);
        this.O000O0OO[3] = findViewById(R.id.fouth_step);
        this.mFouthProgress = (PieProgressBar) findViewById(R.id.kuailian_progress);
        this.O000OOo0 = (TextView) findViewById(R.id.kuailianing_main_title);
        this.mFouthMainSubView = (TextView) findViewById(R.id.kuailianing_main_sub_title);
        this.O000OOo = (TextView) findViewById(R.id.connecting_progress);
        this.O000O0OO[4] = findViewById(R.id.fifth_step);
        this.O000OOoO = (TextView) findViewById(R.id.confirm_main_title);
        this.O000OOoo = (TextView) findViewById(R.id.confirm_main_sub_title);
        this.mConfirmProgressView = (PieProgressBar) findViewById(R.id.confirm_progress);
        this.O000O0OO[5] = findViewById(R.id.final_step);
        this.mFinalErrorContainer = findViewById(R.id.finish_error_btn_container);
        this.O000Oo0 = findViewById(R.id.finish_success_btn);
        this.O000Oo0O = (TextView) findViewById(R.id.retry_btn);
        this.O000Oo0o = (TextView) findViewById(R.id.cancel_btn);
        this.O000OoO0 = (TextView) findViewById(R.id.finish_success_btn);
        this.mCreateLauncher = (CheckBox) findViewById(R.id.check_box_create_launcher);
        this.mRouterView = findViewById(R.id.router_test_step);
        this.mRouterProgress = (PieProgressBar) findViewById(R.id.router_test_progress);
        this.mStartDownloadPluginPage = findViewById(R.id.start_download_plugin_step);
        this.mDownloadProgress = (PieProgressBar) findViewById(R.id.download_progress);
        this.O00O0Oo = findViewById(R.id.rescan_device_step);
        this.mRescanDeviceProgress = (PieProgressBar) findViewById(R.id.rescan_device_progress);
        this.O0000ooO = false;
        Iterator<Map.Entry<String, Device>> it = fno.O000000o().O0000O0o().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                Device device = (Device) it.next().getValue();
                if ("xiaomi.router.v1".equals(device.model) || "xiaomi.router.v2".equals(device.model) || "xiaomi.router.mv1".equals(device.model)) {
                    this.O0000ooO = true;
                }
                if (!it.hasNext()) {
                    break;
                }
            }
        }
        this.O0000ooO = true;
        if ("yunyi.camera.v1".equals(this.O0000O0o) || "yunyi.camera.v2".equals(this.O0000O0o)) {
            switchToFirstStep();
            fcb.O000000o().O000000o("set_use_tag_time", System.currentTimeMillis());
        } else if (this.O0000ooO) {
            switchToRouterTestStep();
        } else {
            switchToSecondStep();
        }
    }

    public void onResume() {
        super.onResume();
        if (!SmartConfigRouterFactory.getSmartConfigManager().isMiLoggedIn()) {
            Dialog dialog = this.O000O0o;
            if (dialog == null) {
                this.O000O0o = gty.O000000o().showLoginDialog(this, true);
                this.O000O0o.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass22 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        BaseWifiSetting.this.finish();
                    }
                });
            } else if (!dialog.isShowing()) {
                this.O000O0o.show();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.O000OoOO);
        this.mIsDestory = true;
        gwi.O000000o(this);
        gwi.O00000Oo(this);
    }

    private void O000000o(int i, boolean z) {
        this.O0000ooo.setVisibility(8);
        this.O00oOooO.setVisibility(8);
        this.O00oOooo.setVisibility(8);
        for (int i2 = 0; i2 < 6; i2++) {
            if (i2 == i) {
                View[] viewArr = this.O000O0OO;
                if (viewArr[i2] != null) {
                    viewArr[i2].setVisibility(0);
                    if (z) {
                        this.O000O0OO[i2].startAnimation(AnimationUtils.loadAnimation(this, R.anim.show));
                    }
                }
            } else {
                View[] viewArr2 = this.O000O0OO;
                if (viewArr2[i2] != null) {
                    if (z && viewArr2[i2].getVisibility() == 0) {
                        this.O000O0OO[i2].startAnimation(AnimationUtils.loadAnimation(this, R.anim.disappear));
                    }
                    this.O000O0OO[i2].setVisibility(8);
                }
            }
        }
    }

    private void O00000oO() {
        this.mMainTitleView.setText("");
        this.mSubMainTitleView.setText("");
        this.O000O00o.setVisibility(8);
        this.mBtnProgressView.setVisibility(8);
        this.O0000oO.setVisibility(8);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void */
    public void switchToRouterTestStep() {
        O000000o(-1, false);
        this.O000O0Oo.setVisibility(8);
        this.mBtnProgressView.setText((int) R.string.next_button);
        this.mRouterTest = true;
        O00000oO();
        this.mRouterView.setVisibility(0);
        this.mRouterProgress.setPercentView((TextView) findViewById(R.id.router_test_progress_test));
        this.mRouterProgress.setDuration(30);
        this.mRouterProgress.startPercentAnim();
        this.O0000o = System.currentTimeMillis();
        this.O0000oo.sendEmptyMessageDelayed(116, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
        this.O0000oo.sendEmptyMessageDelayed(117, 100);
        SmartConfigRouterFactory.getSmartConfigManager().getLocalMiRouterDetail(new hul<fuf.O00000o0>() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass23 */

            public final void O00000Oo(int i) {
            }

            public final /* synthetic */ void O000000o(Object obj) {
                boolean z;
                fuf.O00000o0 o00000o0 = (fuf.O00000o0) obj;
                Iterator<WifiInfo> it = o00000o0.f17173O000000o.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    WifiInfo next = it.next();
                    if (next.f11472O000000o > 0 && next.f11472O000000o < 20 && next.O00000Oo && !TextUtils.isEmpty(next.O00000o0)) {
                        z = true;
                        break;
                    }
                }
                if (!BaseWifiSetting.this.mIsActivityFinished) {
                    if (z) {
                        BaseWifiSetting.this.O0000oO0 = o00000o0;
                    }
                    BaseWifiSetting.this.O0000oo.removeMessages(116);
                    BaseWifiSetting.this.O0000oo.removeMessages(117);
                    BaseWifiSetting.this.mRouterView.setVisibility(8);
                    BaseWifiSetting.this.mBtnProgressView.setVisibility(0);
                    BaseWifiSetting.this.switchToFirstStep();
                }
            }

            public final void O000000o(int i) {
                if (BaseWifiSetting.this.O0000oo.hasMessages(116)) {
                    BaseWifiSetting.this.O0000oo.removeMessages(116);
                    BaseWifiSetting.this.mRouterView.setVisibility(8);
                    BaseWifiSetting.this.mBtnProgressView.setVisibility(0);
                    BaseWifiSetting.this.switchToSecondStep();
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void */
    public void switchToFirstStep() {
        String str;
        O000000o(0, false);
        this.mRouterView.setVisibility(8);
        this.mStep = 0;
        this.O000O00o.setVisibility(0);
        this.mBtnProgressView.setVisibility(0);
        String str2 = this.O0000O0o;
        if (str2 == null) {
            str = getString(R.string.terminal_feedback);
            DeviceFactory.O000000o(this.O0000O0o, this.O000O00o, (int) R.drawable.kuailian_common_icon);
        } else {
            Device O0000o0O2 = DeviceFactory.O0000o0O(str2);
            if (O0000o0O2 != null) {
                str = O0000o0O2.name;
            } else {
                str = SmartConfigRouterFactory.getSmartConfigManager().getAppContext().getString(R.string.other_device);
            }
            DeviceFactory.O000000o(this.O0000O0o, this.O000O00o, (int) R.drawable.kuailian_common_icon);
            this.O000O0Oo.setVisibility(8);
            this.mBtnProgressView.setText((int) R.string.next_button);
            if (this.O0000oO0 == null && this.O0000O0o.equals("yunyi.camera.v1")) {
                this.mBtnProgressView.setText((int) R.string.use_normal_wificonfig);
                this.mBtnProgressView.setVisibility(8);
                this.O0000oO.setVisibility(8);
                this.O000O0Oo.setVisibility(0);
                this.O000O0Oo.setText((int) R.string.next_button);
                this.O000O0Oo.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass24 */

                    public final void onClick(View view) {
                        if (!iag.O00000Oo(BaseWifiSetting.this.getApplicationContext()) || Settings.canDrawOverlays(BaseWifiSetting.this.getApplicationContext())) {
                            BaseWifiSetting baseWifiSetting = BaseWifiSetting.this;
                            baseWifiSetting.O0000oOO = true;
                            baseWifiSetting.O0000OoO = false;
                            baseWifiSetting.switchToRouterTestStep();
                            return;
                        }
                        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(BaseWifiSetting.this.getContext());
                        builder.O00000Oo(BaseWifiSetting.this.getResources().getString(R.string.float_tip));
                        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass24.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                                intent.setData(Uri.parse("package:" + BaseWifiSetting.this.getPackageName()));
                                BaseWifiSetting.this.startActivityForResult(intent, 100);
                            }
                        });
                        builder.O000000o(true);
                        builder.O00000o().show();
                    }
                });
            }
        }
        this.mMainTitleView.setText(String.format(getString(R.string.kuailian_main_title_3), str));
        this.mSubMainTitleView.setText((int) R.string.kuailian_sub_main_title_1);
        if (this.O0000oO0 != null) {
            this.mRouterSwitchTitle.setVisibility(0);
            this.mMainTitleView.setText(String.format(getString(R.string.router_test_info), str));
            Iterator<WifiInfo> it = this.O0000oO0.f17173O000000o.iterator();
            WifiInfo wifiInfo = null;
            while (it.hasNext()) {
                WifiInfo next = it.next();
                if (next.f11472O000000o > 0 && next.f11472O000000o < 20) {
                    wifiInfo = next;
                }
            }
            if (wifiInfo == null) {
                this.O0000oO0 = null;
                switchToSecondStep();
                return;
            }
            this.mSubMainTitleView.setText(String.format(getString(R.string.router_test_sub_info), wifiInfo.O00000o0));
            SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(getString(R.string.router_test_switch));
            valueOf.setSpan(new ClickableSpan() {
                /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass25 */

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(BaseWifiSetting.this.getResources().getColor(R.color.mj_color_class_text_27));
                    textPaint.setUnderlineText(true);
                }

                public final void onClick(View view) {
                    BaseWifiSetting baseWifiSetting = BaseWifiSetting.this;
                    baseWifiSetting.O0000oO0 = null;
                    baseWifiSetting.mRouterSwitchTitle.setVisibility(8);
                    BaseWifiSetting.this.switchToSecondStep();
                }
            }, 0, valueOf.length(), 33);
            this.mRouterSwitchTitle.setHighlightColor(0);
            this.mRouterSwitchTitle.setText(valueOf);
            this.mRouterSwitchTitle.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void */
    public void switchToSecondStep() {
        this.mRouterView.setVisibility(8);
        O000000o(1, false);
        this.mStep = 1;
        this.O000O0Oo.setVisibility(8);
        this.mBtnProgressView.setText((int) R.string.next_button);
        this.mMainTitleView.setVisibility(0);
        this.mMainTitleView.setText(String.format(getString(R.string.kuailian_main_title_2), new Object[0]));
        this.O000O00o.setVisibility(0);
        this.O000O00o.setImageURI(htp.O000000o(R.drawable.kuailian_wifi_icon));
        this.O0000oO.setVisibility(8);
        this.mSubMainTitleView.setVisibility(0);
        this.mSubMainTitleView.setText((int) R.string.kuailian_sub_main_title_2);
        this.O000O0OO[5].setVisibility(8);
        this.mFinalErrorContainer.setVisibility(8);
        int wifiState = this.f11915O000000o.getWifiState();
        if (wifiState == 3) {
            this.f11915O000000o.startScan();
            this.O0000oo.sendEmptyMessageDelayed(104, 10000);
        } else if ((wifiState == 4 || wifiState == 1) && wifiState == 1) {
            this.f11915O000000o.setWifiEnabled(true);
        }
        this.O0000o0O = State.SCANNING;
        this.mWifiChooser.setText("");
        this.mScanWifi.setVisibility(0);
        this.mBtnProgressView.setEnabled(false);
        this.O000O0o0.setVisibility(8);
        this.O00oOoOo.setVisibility(8);
        this.mBtnProgressView.setVisibility(0);
        this.mPasswordEditor.setText("");
        this.mPasswordEditor.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass26 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                BaseWifiSetting.this.checkConfirmEnabled();
            }
        });
        this.mPasswordToggle.setSelected(false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void */
    public void switchToThirdStep() {
        WifiConfiguration wifiConfiguration;
        boolean z;
        boolean z2;
        this.mMainTitleView.setVisibility(8);
        this.mSubMainTitleView.setVisibility(8);
        this.O0000ooo.setVisibility(8);
        this.O00oOooO.setVisibility(8);
        this.O00oOooo.setVisibility(8);
        this.O000O00o.setVisibility(8);
        O000000o(2, true);
        this.mStep = 2;
        EditText editText = this.mPasswordEditor;
        if (editText != null) {
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        this.O000O0oO.setImageResource(R.drawable.kuailian_phone_icon);
        this.O000O0oo.setImageResource(R.drawable.kuailian_router_icon);
        this.O000OO00.setVisibility(0);
        this.O000OO0o.setVisibility(8);
        fuf.O00000o0 o00000o0 = this.O0000oO0;
        if (o00000o0 != null) {
            Iterator<WifiInfo> it = o00000o0.f17173O000000o.iterator();
            WifiInfo wifiInfo = null;
            while (it.hasNext()) {
                WifiInfo next = it.next();
                if (next.f11472O000000o > 0 && next.f11472O000000o < 20) {
                    wifiInfo = next;
                }
            }
            android.net.wifi.WifiInfo connectionInfo = this.f11915O000000o.getConnectionInfo();
            if (connectionInfo != null && connectionInfo.getSSID() != null) {
                if (iag.O000000o(connectionInfo.getSSID(), wifiInfo.O00000o0)) {
                    this.O0000oo.sendEmptyMessageDelayed(108, 1000);
                    saveWifiItem();
                } else {
                    this.O0000o0O = State.CONNECTTING;
                    String str = wifiInfo.O00000o0;
                    String str2 = wifiInfo.O00000oO;
                    String str3 = wifiInfo.O0000O0o;
                    SmartConfigRouterFactory.getStatPageV2Manager().reportKuailianOldResult(str, "BaseWifiSetting", "connectXiaomiRouter");
                    if (this.f11915O000000o.isWifiEnabled()) {
                        Iterator<WifiConfiguration> it2 = this.f11915O000000o.getConfiguredNetworks().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                wifiConfiguration = null;
                                break;
                            }
                            wifiConfiguration = it2.next();
                            if (wifiConfiguration.SSID != null && wifiConfiguration.SSID.equals(iag.O000000o(str)) && iag.O000000o(wifiConfiguration) == iag.O00000Oo(str3)) {
                                break;
                            }
                        }
                        if (wifiConfiguration == null) {
                            WifiConfiguration wifiConfiguration2 = new WifiConfiguration();
                            iag.O000000o(wifiConfiguration2, str, str2, str3);
                            int addNetwork = this.f11915O000000o.addNetwork(wifiConfiguration2);
                            if (Build.VERSION.SDK_INT > 9) {
                                Class<?> cls = Class.forName(WifiManager.class.getName());
                                gsy.O000000o(4, "111", "class3:" + cls.getName());
                                Method[] methods = cls.getMethods();
                                int i = 0;
                                while (true) {
                                    if (i >= methods.length) {
                                        z = false;
                                        break;
                                    } else if ((methods[i].getName().equalsIgnoreCase("connect") || methods[i].getName().equalsIgnoreCase("connectNetwork")) && methods[i].getParameterTypes()[0].getName().equals("int")) {
                                        z = true;
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                                if (z) {
                                    methods[i].setAccessible(true);
                                    if (!methods[i].getName().equalsIgnoreCase("connect")) {
                                        methods[i].invoke(this.f11915O000000o, Integer.valueOf(addNetwork));
                                    } else if (methods[i].getParameterTypes().length > 2) {
                                        methods[i].invoke(this.f11915O000000o, null, Integer.valueOf(addNetwork), null);
                                    } else {
                                        methods[i].invoke(this.f11915O000000o, Integer.valueOf(addNetwork), null);
                                    }
                                } else {
                                    this.f11915O000000o.enableNetwork(addNetwork, true);
                                }
                            } else {
                                this.f11915O000000o.enableNetwork(addNetwork, true);
                            }
                        } else if (Build.VERSION.SDK_INT > 9) {
                            try {
                                Class<?> cls2 = Class.forName(WifiManager.class.getName());
                                gsy.O000000o(4, "111", "class3:" + cls2.getName());
                                Method[] methods2 = cls2.getMethods();
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= methods2.length) {
                                        z2 = false;
                                        break;
                                    } else if ((methods2[i2].getName().equalsIgnoreCase("connect") || methods2[i2].getName().equalsIgnoreCase("connectNetwork")) && methods2[i2].getParameterTypes()[0].getName().equals("int")) {
                                        z2 = true;
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                if (z2) {
                                    methods2[i2].setAccessible(true);
                                    if (!methods2[i2].getName().equalsIgnoreCase("connect")) {
                                        methods2[i2].invoke(this.f11915O000000o, Integer.valueOf(wifiConfiguration.networkId));
                                    } else if (methods2[i2].getParameterTypes().length > 2) {
                                        methods2[i2].invoke(this.f11915O000000o, null, Integer.valueOf(wifiConfiguration.networkId), null);
                                    } else {
                                        methods2[i2].invoke(this.f11915O000000o, Integer.valueOf(wifiConfiguration.networkId), null);
                                    }
                                } else {
                                    this.f11915O000000o.enableNetwork(wifiConfiguration.networkId, true);
                                }
                            } catch (Exception unused) {
                            }
                        } else {
                            this.f11915O000000o.enableNetwork(wifiConfiguration.networkId, true);
                        }
                        this.O0000oo.sendEmptyMessageDelayed(103, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                    }
                }
            } else {
                return;
            }
        } else {
            O000000o(this.O0000o0);
        }
        this.mBtnProgressView.setVisibility(8);
        this.O0000oO.setVisibility(0);
        this.O0000oO.setText((int) R.string.sh_common_cancel);
        this.O000OO.setText((int) R.string.kuailian_connectting_router);
        this.O000OOOo.setText("");
        this.O000OO00.startConnection();
    }

    public void startNetworkTest() {
        this.O000O0oO.setImageResource(R.drawable.kuailian_router_icon);
        this.O000O0oo.setImageResource(R.drawable.kuailian_icon_cloud);
        this.O000OO.setText((int) R.string.kuailian_connectting_cloud);
        this.O000OOOo.setText("");
        this.O000OO00.setVisibility(0);
        this.O000OO0o.setVisibility(8);
        iab.O000000o().O0000OOo = new iab.O000000o() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass27 */

            public final void O000000o() {
                iab.O000000o().O00000o0();
                iab.O000000o().O0000OOo = null;
                if (BaseWifiSetting.this.mStep != 1) {
                    BaseWifiSetting.this.onNetworkConnectionSuccess();
                }
            }

            public final void O000000o(int i) {
                iab.O000000o().O00000o0();
                iab.O000000o().O0000OOo = null;
                if (i == 1) {
                    BaseWifiSetting.this.onNetworkConnectionFailed(R.string.kuailian_network_dns_error);
                } else {
                    BaseWifiSetting.this.onNetworkConnectionFailed(R.string.kuailian_network_slow);
                }
            }
        };
        iab O000000o2 = iab.O000000o();
        O000000o2.O00000Oo = 0;
        O000000o2.O00000o0 = 0;
        O000000o2.O00000o = 0;
        O000000o2.O00000oO = 0;
        O000000o2.O00000oo = new iab.O00000Oo(O000000o2.O0000O0o.getLooper());
        O000000o2.O00000oo.sendEmptyMessageDelayed(1, 1000);
        this.O000OO00.startConnection();
    }

    public void onWifiConnectionSuccess() {
        this.O000OO00.stopConnection();
        this.O000OO00.setVisibility(8);
        this.O000OO0o.setVisibility(0);
        this.O000OO0o.setImageResource(R.drawable.connection_success);
        this.O000OO.setText((int) R.string.kuailian_success);
        this.O000OOOo.setText((int) R.string.kuailian_success_phone_router);
        this.O0000oo.sendEmptyMessageDelayed(109, 1000);
    }

    public void onNetworkConnectionSuccess() {
        this.O000OO00.stopConnection();
        this.O000OO00.setVisibility(8);
        this.O0000oO.setVisibility(8);
        this.O000OO0o.setVisibility(0);
        this.O000OO0o.setImageResource(R.drawable.connection_success);
        this.O000OO.setText((int) R.string.kuailian_success);
        this.O000OOOo.setText((int) R.string.kuailian_success_phone_cloud);
        this.O0000oo.sendEmptyMessageDelayed(110, 1000);
    }

    public void onNetworkConnectionFailed(int i) {
        this.O000OO00.stopConnection();
        this.O000OO00.setVisibility(8);
        this.O000OO0o.setVisibility(0);
        this.O000OO0o.setImageResource(R.drawable.connection_failed);
        this.O000OO.setText((int) R.string.kuailian_failed);
        this.O000OOOo.setText(i);
        this.O000O0OO[5].setVisibility(0);
        this.mFinalErrorContainer.setVisibility(0);
        this.O000Oo0.setVisibility(8);
        this.O000Oo0o.setText((int) R.string.kuailian_cancel);
        this.O000Oo0O.setText((int) R.string.kuailian_retry_network);
        this.O000Oo0o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass28 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
             arg types: [int, int]
             candidates:
              com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
              com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
            public final void onClick(View view) {
                BaseWifiSetting.this.O000000o(false, false);
            }
        });
        this.O000Oo0O.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass2 */

            public final void onClick(View view) {
                BaseWifiSetting.this.switchToSecondStep();
            }
        });
        this.O0000oO.setVisibility(0);
        this.O0000oO.setText((int) R.string.kuailian_still_connect);
    }

    public void onWifiConnectionFailed() {
        if (this.O000O0OO[5] != null) {
            this.O000OO00.stopConnection();
            this.O000OO00.setVisibility(8);
            this.O0000o0O = State.STOP_CONNECTION;
            this.O000OO0o.setVisibility(0);
            this.O000OO0o.setImageResource(R.drawable.connection_failed);
            this.O000OO.setText((int) R.string.kuailian_falied_router);
            this.O000OOOo.setText((int) R.string.kuailian_failed_phone_router);
            this.O0000oO.setVisibility(8);
            this.O000O0OO[5].setVisibility(0);
            this.mFinalErrorContainer.setVisibility(0);
            this.mCreateLauncher.setVisibility(8);
            this.O000Oo0.setVisibility(8);
            this.O000Oo0o.setText((int) R.string.kuailian_cancel);
            this.O000Oo0O.setText((int) R.string.kuailian_retry_network);
            this.O000Oo0o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass3 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
                 arg types: [int, int]
                 candidates:
                  com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
                  com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
                public final void onClick(View view) {
                    BaseWifiSetting.this.O000000o(false, false);
                }
            });
            this.O000Oo0O.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass4 */

                public final void onClick(View view) {
                    BaseWifiSetting.this.switchToSecondStep();
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void */
    public void switchToFouthStep() {
        if (this.O0000oOO) {
            goCameraBarcodeConnection();
            return;
        }
        O000000o(3, false);
        this.mStep = 3;
        this.mFouthProgress.setPercentView(this.O000OOo);
        this.O0000o = System.currentTimeMillis();
        this.mMainTitleView.setVisibility(8);
        this.mSubMainTitleView.setVisibility(8);
        this.O0000ooo.setVisibility(8);
        this.O00oOooO.setVisibility(8);
        this.O00oOooo.setVisibility(8);
        this.O000O00o.setVisibility(8);
        this.O0000oo.sendEmptyMessageDelayed(111, 100);
        String str = this.O0000O0o;
        if (str == null) {
            this.O000OOo0.setText(String.format(getString(R.string.kuailian_main_title_3), getString(R.string.terminal_feedback)));
        } else {
            Device O0000o0O2 = DeviceFactory.O0000o0O(str);
            if (O0000o0O2 != null) {
                this.O000OOo0.setText(String.format(getString(R.string.kuailian_main_title_3), O0000o0O2.name));
            } else {
                this.O000OOo0.setText(String.format(getString(R.string.kuailian_main_title_3), SmartConfigRouterFactory.getSmartConfigManager().getAppContext().getString(R.string.other_device)));
            }
        }
        saveWifiItem();
        startConnection();
        this.O0000o0O = State.DEVICE_CONNECTING;
        this.O0000oO.setVisibility(0);
        this.O0000oO.setText((int) R.string.sh_common_cancel);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void */
    public void switchToFinalStepRescan() {
        O000000o(5, false);
        this.O0000oO.setVisibility(4);
        this.mBtnProgressView.setVisibility(8);
        this.mSubMainTitleView.setVisibility(8);
        this.mFinalErrorContainer.setVisibility(8);
        O00000oO();
        if (this.O0000o0O != State.STOP_CONNECTION) {
            this.O0000o0O = State.STOP_CONNECTION;
            fmw.O000000o().O00000Oo();
            this.mCreateLauncher.setVisibility(8);
            this.O000O00o.setVisibility(0);
            this.mMainTitleView.setVisibility(0);
            this.mMainTitleView.setText((int) R.string.connect_timeout);
            this.O000O00o.setImageURI(htp.O000000o(R.drawable.kuailian_failed_icon));
            this.O000OoO0.setVisibility(0);
            this.O000OoO0.setText((int) R.string.wifi_rescan_wifi);
            this.O000OoO0.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass5 */

                public final void onClick(View view) {
                    fmw O000000o2 = fmw.O000000o();
                    BaseWifiSetting baseWifiSetting = BaseWifiSetting.this;
                    O000000o2.O000000o(baseWifiSetting, baseWifiSetting.O00000oo);
                    BaseWifiSetting.this.switchToRescanStep();
                }
            });
            fmw.O000000o().O00000oo();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void */
    public void switchToRescanStep() {
        O000000o(-1, false);
        this.O000O00o.setVisibility(8);
        this.mMainTitleView.setVisibility(8);
        this.mSubMainTitleView.setVisibility(8);
        this.O00O0Oo.setVisibility(0);
        this.mRescanDeviceProgress.setPercentView((TextView) findViewById(R.id.rescan_device_progress_text));
        this.O0000oO.setVisibility(0);
        this.O0000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass6 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
             arg types: [int, int]
             candidates:
              com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
              com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
            public final void onClick(View view) {
                BaseWifiSetting.this.O000000o(false, false);
            }
        });
        this.O0000o = System.currentTimeMillis();
        this.O0000o0O = State.RESCAN_DEVICE;
        this.O0000oo.sendEmptyMessage(119);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void */
    public void switchToFinalStep(boolean z) {
        O000000o(5, false);
        this.O0000oO.setVisibility(4);
        this.mBtnProgressView.setVisibility(8);
        this.mStartDownloadPluginPage.setVisibility(8);
        this.O00O0Oo.setVisibility(8);
        if (this.O0000o0O != State.STOP_CONNECTION) {
            this.O0000o0O = State.STOP_CONNECTION;
            fmw.O000000o().O00000Oo();
            if (z) {
                this.mCreateLauncher.setVisibility(0);
                this.mCreateLauncher.setChecked(true);
                this.mMainTitleView.setText(String.format(getString(R.string.kuailian_success), new Object[0]));
                this.O000O00o.setVisibility(0);
                this.mMainTitleView.setVisibility(0);
                this.mSubMainTitleView.setVisibility(8);
                this.O0000ooo.setVisibility(8);
                this.O00oOooO.setVisibility(8);
                this.O00oOooo.setVisibility(8);
                this.O000O00o.setImageURI(htp.O000000o(R.drawable.kuailian_success_icon));
                this.mFinalErrorContainer.setVisibility(8);
                this.O000OoO0.setVisibility(0);
                this.O000OoO0.setText((int) R.string.common_finish);
                this.O000OoO0.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass7 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
                     arg types: [int, int]
                     candidates:
                      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
                      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
                    public final void onClick(View view) {
                        if (BaseWifiSetting.this.mCreateLauncher.isChecked()) {
                            final XQProgressDialog O000000o2 = XQProgressDialog.O000000o(BaseWifiSetting.this.getContext(), null, BaseWifiSetting.this.getString(R.string.creating));
                            final boolean[] zArr = new boolean[BaseWifiSetting.this.mConnectedDevice.size()];
                            for (int i = 0; i < zArr.length; i++) {
                                zArr[i] = false;
                            }
                            for (final int i2 = 0; i2 < BaseWifiSetting.this.mConnectedDevice.size(); i2++) {
                                hvb smartConfigManager = SmartConfigRouterFactory.getSmartConfigManager();
                                BaseWifiSetting baseWifiSetting = BaseWifiSetting.this;
                                smartConfigManager.addToLauncher(baseWifiSetting, false, baseWifiSetting.mConnectedDevice.get(i2), null, "smart_config", new hul<Void>() {
                                    /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass7.AnonymousClass1 */

                                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
                                     arg types: [int, int]
                                     candidates:
                                      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
                                      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
                                    public final void O000000o(int i) {
                                        zArr[i2] = true;
                                        int i2 = 0;
                                        while (i2 < BaseWifiSetting.this.mConnectedDevice.size()) {
                                            if (zArr[i2]) {
                                                i2++;
                                            } else {
                                                return;
                                            }
                                        }
                                        O000000o2.dismiss();
                                        BaseWifiSetting.this.O000000o(false, false);
                                    }

                                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
                                     arg types: [int, int]
                                     candidates:
                                      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
                                      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
                                    public final void O00000Oo(int i) {
                                        zArr[i2] = true;
                                        int i2 = 0;
                                        while (i2 < BaseWifiSetting.this.mConnectedDevice.size()) {
                                            if (zArr[i2]) {
                                                i2++;
                                            } else {
                                                return;
                                            }
                                        }
                                        O000000o2.dismiss();
                                        BaseWifiSetting.this.O000000o(false, false);
                                    }

                                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
                                     arg types: [int, int]
                                     candidates:
                                      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
                                      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
                                    public final /* synthetic */ void O000000o(Object obj) {
                                        zArr[i2] = true;
                                        int i = 0;
                                        while (i < BaseWifiSetting.this.mConnectedDevice.size()) {
                                            if (zArr[i]) {
                                                i++;
                                            } else {
                                                return;
                                            }
                                        }
                                        O000000o2.dismiss();
                                        BaseWifiSetting.this.O000000o(false, false);
                                    }
                                });
                            }
                            return;
                        }
                        BaseWifiSetting.this.O000000o(false, false);
                    }
                });
                return;
            }
            this.mCreateLauncher.setVisibility(8);
            this.mMainTitleView.setText(String.format(getString(R.string.kuailian_failed), new Object[0]));
            onStopConnection();
            this.mSubMainTitleView.setVisibility(0);
            this.mSubMainTitleView.setText(getErrorResultStr());
            gfq.O000000o().O00000Oo(gog.O00000Oo(this));
            this.O000O00o.setVisibility(0);
            this.mMainTitleView.setVisibility(0);
            this.O000O00o.setImageURI(htp.O000000o(R.drawable.kuailian_failed_icon));
            this.mFinalErrorContainer.setVisibility(0);
            this.O000Oo0.setVisibility(8);
            this.O000Oo0o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass8 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
                 arg types: [int, int]
                 candidates:
                  com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
                  com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
                public final void onClick(View view) {
                    BaseWifiSetting.this.O000000o(false, false);
                }
            });
            if (!setFailTextBtn(this.O000Oo0O)) {
                this.O000Oo0O.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass9 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
                     arg types: [int, int]
                     candidates:
                      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
                      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
                    public final void onClick(View view) {
                        BaseWifiSetting.this.O000000o(false, false);
                        fbt fbt = new fbt(BaseWifiSetting.this, "ChooseDeviceActivity");
                        if (BaseWifiSetting.this.O0000O0o != null) {
                            fbt.O000000o("model", BaseWifiSetting.this.O0000O0o);
                        }
                        if (BaseWifiSetting.this.O00000oo != null) {
                            fbt.O000000o("model", DeviceFactory.O00000Oo(BaseWifiSetting.this.O00000oo));
                        }
                        fbs.O000000o(fbt);
                        BaseWifiSetting.this.finish();
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void */
    public void switchToDownloadingPage() {
        O000000o(-1, false);
        this.O000O00o.setVisibility(8);
        this.mMainTitleView.setVisibility(8);
        this.O00O0Oo.setVisibility(8);
        this.mStartDownloadPluginPage.setVisibility(0);
        this.O0000oo.removeMessages(119);
        this.mDownloadProgress.setPercentView((TextView) findViewById(R.id.download_progress_text));
        if (this.mConnectedDevice.size() <= 0) {
            this.mStartDownloadPluginPage.setVisibility(8);
            switchToFinalStep(true);
        } else if (SmartConfigRouterFactory.getCoreApiManager().getInstallInfo(this.mConnectedDevice.get(0).model).O00000Oo()) {
            this.mStartDownloadPluginPage.setVisibility(8);
            switchToFinalStep(true);
        } else {
            SmartConfigRouterFactory.getCoreApiManager().downloadPlugin(this.mConnectedDevice.get(0).model, new huh() {
                /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass10 */

                public final void O000000o() {
                }

                public final void O000000o(float f) {
                    Message obtainMessage = BaseWifiSetting.this.O0000oo.obtainMessage();
                    obtainMessage.obj = Float.valueOf(f);
                    obtainMessage.what = 118;
                    BaseWifiSetting.this.O0000oo.sendMessage(obtainMessage);
                }

                public final void O000000o(String str) {
                    BaseWifiSetting.this.switchToFinalStep(true);
                }

                public final void O00000Oo() {
                    BaseWifiSetting.this.switchToFinalStep(true);
                }

                public final void O00000o0() {
                    BaseWifiSetting.this.switchToFinalStep(true);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o() {
        if (this.O00000o0.size() != 0) {
            return false;
        }
        new MLAlertDialog.Builder(this).O00000Oo((int) R.string.get_wifi_scan_result_error).O000000o((int) R.string.wifi_rescan_wifi, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass21 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                BaseWifiSetting.this.mScanWifi.setVisibility(0);
                BaseWifiSetting.this.f11915O000000o.startScan();
                BaseWifiSetting.this.mPasswordEditor.setEnabled(false);
                BaseWifiSetting.this.mWifiChooser.setEnabled(false);
                BaseWifiSetting.this.mBtnProgressView.setEnabled(false);
                BaseWifiSetting.this.mPasswordToggle.setEnabled(false);
                BaseWifiSetting.this.O0000o0O = State.SCANNING;
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.AnonymousClass20 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
             arg types: [int, int]
             candidates:
              com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
              com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
            public final void onClick(DialogInterface dialogInterface, int i) {
                BaseWifiSetting.this.O000000o(false, true);
            }
        }).O000000o(false).O00000oo();
        this.O0000o0O = State.INPUT;
        return true;
    }

    public void checkConfirmEnabled() {
        if (this.O00000oO != -1 && this.O0000o0O == State.INPUT && (this.O000O0o0.getVisibility() == 8 || this.mPasswordEditorAbove.getVisibility() == 0 || !TextUtils.isEmpty(this.mPasswordEditor.getText().toString()))) {
            this.mBtnProgressView.setEnabled(true);
        } else {
            this.mBtnProgressView.setEnabled(false);
        }
    }

    public void checkShowPassword(ScanResult scanResult) {
        if (scanResult == null) {
            this.O000O0o0.setVisibility(8);
            this.O00oOoOo.setVisibility(8);
        } else if (iag.O00000Oo(scanResult) == 0) {
            this.O000O0o0.setVisibility(8);
            this.O00oOoOo.setVisibility(8);
            this.O0000o00 = true;
        } else {
            this.O0000o00 = false;
            gwj.O000000o O000000o2 = gfq.O000000o().O000000o(scanResult.BSSID);
            if (this.O0000OoO) {
                String str = scanResult.SSID;
                WifiConfiguration wifiConfiguration = null;
                Iterator<WifiConfiguration> it = this.f11915O000000o.getConfiguredNetworks().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WifiConfiguration next = it.next();
                    if (next.SSID.equalsIgnoreCase(iag.O000000o(str))) {
                        wifiConfiguration = next;
                        break;
                    }
                }
                if (wifiConfiguration != null) {
                    O000000o(false);
                    return;
                }
            }
            if (O000000o2 != null) {
                this.O0000o0 = O000000o2.O00000o;
                O000000o(false);
                return;
            }
            O000000o(true);
        }
    }

    private void O000000o(boolean z) {
        this.O000O0o0.setVisibility(0);
        this.O00oOoOo.setVisibility(0);
        this.O0000o0o = z;
        if (!z) {
            this.mPasswordEditorAbove.setText("123456");
            this.mPasswordEditorAbove.setVisibility(0);
            this.mPasswordEditor.setVisibility(8);
            this.mPasswordToggle.setEnabled(false);
            this.mBtnProgressView.setEnabled(true);
        } else {
            this.mPasswordEditor.setVisibility(0);
            this.mPasswordEditorAbove.setVisibility(8);
            this.mPasswordToggle.setEnabled(true);
            this.mBtnProgressView.setEnabled(false);
        }
        if (!this.O000OoO) {
            this.O000OoO = true;
            fbs.O000000o(new fbt(this, "BlankActivity"));
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String str) {
        ScanResult scanResult;
        WifiConfiguration wifiConfiguration;
        int i;
        boolean z;
        boolean z2;
        if (this.f11915O000000o.isWifiEnabled()) {
            InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService("input_method");
            if (inputMethodManager.isActive() && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            this.O0000o0O = State.CONNECTTING;
            this.mPasswordEditor.setEnabled(false);
            this.mWifiChooser.setEnabled(false);
            findViewById(R.id.wifi_ssid_toggle).setEnabled(false);
            this.mBtnProgressView.setEnabled(false);
            this.mPasswordToggle.setEnabled(false);
            int i2 = this.O00000oO;
            if (i2 != -1) {
                if (this.O0000Oo) {
                    scanResult = this.O00000o.get(i2).f1089O000000o;
                } else {
                    scanResult = this.O00000o0.get(i2).f1089O000000o;
                }
                if (!this.f11915O000000o.isWifiEnabled()) {
                    this.f11915O000000o.setWifiEnabled(true);
                    this.O0000o0O = State.RESCANNING;
                    return;
                }
                if (scanResult != null) {
                    SmartConfigRouterFactory.getStatPageV2Manager().reportKuailianOldResult(scanResult.SSID, "BaseWifiSetting", "connectToWifi2138");
                }
                Iterator<WifiConfiguration> it = this.f11915O000000o.getConfiguredNetworks().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        wifiConfiguration = null;
                        break;
                    }
                    wifiConfiguration = it.next();
                    if (wifiConfiguration.SSID != null && wifiConfiguration.SSID.equals(iag.O000000o(scanResult.SSID)) && iag.O000000o(wifiConfiguration) == iag.O00000Oo(scanResult)) {
                        break;
                    }
                }
                if (this.f11915O000000o.getConnectionInfo() == null || this.f11915O000000o.getConnectionInfo().getBSSID() == null) {
                    i = -1;
                } else {
                    i = -1;
                    for (int i3 = 0; i3 < this.m5GScanResult.size(); i3++) {
                        if (this.f11915O000000o.getConnectionInfo().getBSSID().equalsIgnoreCase(this.m5GScanResult.get(i3).f1089O000000o.BSSID)) {
                            i = i3;
                        }
                    }
                }
                if (wifiConfiguration != null) {
                    android.net.wifi.WifiInfo connectionInfo = this.f11915O000000o.getConnectionInfo();
                    if (connectionInfo != null && iag.O000000o(connectionInfo.getSSID(), scanResult.SSID) && connectionInfo.getNetworkId() != -1) {
                        saveWifiItem();
                        this.O0000oo.sendEmptyMessageDelayed(108, 1000);
                        return;
                    } else if (Build.VERSION.SDK_INT > 9) {
                        try {
                            Class<?> cls = Class.forName(WifiManager.class.getName());
                            gsy.O000000o(4, "111", "class3:" + cls.getName());
                            Method[] methods = cls.getMethods();
                            int i4 = 0;
                            while (true) {
                                if (i4 >= methods.length) {
                                    z2 = false;
                                    break;
                                } else if ((methods[i4].getName().equalsIgnoreCase("connect") || methods[i4].getName().equalsIgnoreCase("connectNetwork")) && methods[i4].getParameterTypes()[0].getName().equals("int")) {
                                    z2 = true;
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            if (z2) {
                                methods[i4].setAccessible(true);
                                if (!methods[i4].getName().equalsIgnoreCase("connect")) {
                                    methods[i4].invoke(this.f11915O000000o, Integer.valueOf(wifiConfiguration.networkId));
                                } else if (methods[i4].getParameterTypes().length > 2) {
                                    methods[i4].invoke(this.f11915O000000o, null, Integer.valueOf(wifiConfiguration.networkId), null);
                                } else {
                                    methods[i4].invoke(this.f11915O000000o, Integer.valueOf(wifiConfiguration.networkId), null);
                                }
                            } else {
                                this.f11915O000000o.enableNetwork(wifiConfiguration.networkId, true);
                            }
                        } catch (Exception unused) {
                        }
                    } else {
                        this.f11915O000000o.enableNetwork(wifiConfiguration.networkId, true);
                    }
                } else {
                    WifiConfiguration wifiConfiguration2 = new WifiConfiguration();
                    O000000o(wifiConfiguration2, scanResult, str);
                    int addNetwork = this.f11915O000000o.addNetwork(wifiConfiguration2);
                    if (Build.VERSION.SDK_INT > 9) {
                        try {
                            Class<?> cls2 = Class.forName(WifiManager.class.getName());
                            gsy.O000000o(4, "111", "class3:" + cls2.getName());
                            Method[] methods2 = cls2.getMethods();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= methods2.length) {
                                    z = false;
                                    break;
                                } else if ((methods2[i5].getName().equalsIgnoreCase("connect") || methods2[i5].getName().equalsIgnoreCase("connectNetwork")) && methods2[i5].getParameterTypes()[0].getName().equals("int")) {
                                    z = true;
                                    break;
                                } else {
                                    i5++;
                                }
                            }
                            if (z) {
                                methods2[i5].setAccessible(true);
                                if (!methods2[i5].getName().equalsIgnoreCase("connect")) {
                                    methods2[i5].invoke(this.f11915O000000o, Integer.valueOf(addNetwork));
                                } else if (methods2[i5].getParameterTypes().length > 2) {
                                    methods2[i5].invoke(this.f11915O000000o, null, Integer.valueOf(addNetwork), null);
                                } else {
                                    methods2[i5].invoke(this.f11915O000000o, Integer.valueOf(addNetwork), null);
                                }
                            } else {
                                this.f11915O000000o.enableNetwork(addNetwork, true);
                            }
                        } catch (Exception unused2) {
                        }
                    } else {
                        this.f11915O000000o.enableNetwork(addNetwork, true);
                    }
                }
                if (i != -1) {
                    this.mLastNetwork = this.f11915O000000o.getConnectionInfo().getNetworkId();
                }
                if (TextUtils.isEmpty(str)) {
                    this.O0000o0o = false;
                } else {
                    this.O0000o0o = true;
                }
                this.O0000oo.sendEmptyMessageDelayed(103, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
            }
        }
    }

    public void disableCurrentNetwork() {
        this.f11915O000000o.disconnect();
    }

    public boolean connectToWifi(ScanResult scanResult, String str) {
        WifiConfiguration wifiConfiguration;
        boolean z;
        boolean z2;
        ScanResult scanResult2 = scanResult;
        if (scanResult2 != null) {
            SmartConfigRouterFactory.getStatPageV2Manager().reportKuailianOldResult(scanResult2.SSID, "BaseWifiSetting", "connectToWifi2304");
        }
        if (!this.f11915O000000o.isWifiEnabled()) {
            return false;
        }
        Iterator<WifiConfiguration> it = this.f11915O000000o.getConfiguredNetworks().iterator();
        while (true) {
            if (!it.hasNext()) {
                wifiConfiguration = null;
                break;
            }
            wifiConfiguration = it.next();
            if (wifiConfiguration.SSID != null && wifiConfiguration.SSID.equals(iag.O000000o(scanResult2.SSID)) && iag.O000000o(wifiConfiguration) == iag.O00000Oo(scanResult)) {
                break;
            }
        }
        if (wifiConfiguration == null) {
            WifiConfiguration wifiConfiguration2 = new WifiConfiguration();
            O000000o(wifiConfiguration2, scanResult2, str);
            int addNetwork = this.f11915O000000o.addNetwork(wifiConfiguration2);
            if (Build.VERSION.SDK_INT <= 9 || Build.VERSION.SDK_INT >= 23) {
                this.f11915O000000o.enableNetwork(addNetwork, true);
            } else {
                Class<?> cls = Class.forName(WifiManager.class.getName());
                gsy.O000000o(4, "111", "class3:" + cls.getName());
                Method[] methods = cls.getMethods();
                int i = 0;
                while (true) {
                    if (i >= methods.length) {
                        z = false;
                        break;
                    } else if ((methods[i].getName().equalsIgnoreCase("connect") || methods[i].getName().equalsIgnoreCase("connectNetwork")) && methods[i].getParameterTypes()[0].getName().equals("int")) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    methods[i].setAccessible(true);
                    if (!methods[i].getName().equalsIgnoreCase("connect")) {
                        methods[i].invoke(this.f11915O000000o, Integer.valueOf(addNetwork));
                    } else if (methods[i].getParameterTypes().length > 2) {
                        methods[i].invoke(this.f11915O000000o, null, Integer.valueOf(addNetwork), null);
                    } else {
                        methods[i].invoke(this.f11915O000000o, Integer.valueOf(addNetwork), null);
                    }
                } else {
                    this.f11915O000000o.enableNetwork(addNetwork, true);
                }
            }
        } else if (Build.VERSION.SDK_INT <= 9 || Build.VERSION.SDK_INT >= 23) {
            this.f11915O000000o.enableNetwork(wifiConfiguration.networkId, true);
        } else {
            try {
                Class<?> cls2 = Class.forName(WifiManager.class.getName());
                gsy.O000000o(4, "111", "class3:" + cls2.getName());
                Method[] methods2 = cls2.getMethods();
                int i2 = 0;
                while (true) {
                    if (i2 >= methods2.length) {
                        z2 = false;
                        break;
                    } else if ((methods2[i2].getName().equalsIgnoreCase("connect") || methods2[i2].getName().equalsIgnoreCase("connectNetwork")) && methods2[i2].getParameterTypes()[0].getName().equals("int")) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    methods2[i2].setAccessible(true);
                    if (!methods2[i2].getName().equalsIgnoreCase("connect")) {
                        methods2[i2].invoke(this.f11915O000000o, Integer.valueOf(wifiConfiguration.networkId));
                    } else if (methods2[i2].getParameterTypes().length > 2) {
                        methods2[i2].invoke(this.f11915O000000o, null, Integer.valueOf(wifiConfiguration.networkId), null);
                    } else {
                        methods2[i2].invoke(this.f11915O000000o, Integer.valueOf(wifiConfiguration.networkId), null);
                    }
                } else {
                    this.f11915O000000o.enableNetwork(wifiConfiguration.networkId, true);
                }
            } catch (Exception unused) {
            }
        }
        this.O0000oo.sendEmptyMessageDelayed(103, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
        return false;
    }

    private boolean O00000oo() {
        try {
            Class<?> cls = Class.forName("com.miui.whetstone.WhetstoneManager");
            if (((Integer) cls.getDeclaredMethod("getSmartConfigLevel", new Class[0]).invoke(null, new Object[0])).intValue() != 2) {
                return false;
            }
            this.O0000Ooo = cls;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void saveWifiItem() {
        ScanResult scanResult;
        if (!this.O0000OoO || this.O0000o0o || this.O0000o00 || this.O0000oO0 != null) {
            fuf.O00000o0 o00000o0 = this.O0000oO0;
            if (o00000o0 != null) {
                WifiInfo wifiInfo = null;
                Iterator<WifiInfo> it = o00000o0.f17173O000000o.iterator();
                while (it.hasNext()) {
                    WifiInfo next = it.next();
                    if (next.f11472O000000o > 0 && next.f11472O000000o < 20) {
                        wifiInfo = next;
                    }
                }
                gwj.O000000o o000000o = new gwj.O000000o();
                o000000o.O00000oO = gog.O00000Oo(this);
                if (o000000o.O00000oO == null) {
                    o000000o.O00000oO = "";
                }
                o000000o.O00000o0 = wifiInfo.O00000o0;
                if (wifiInfo.O0000O0o.equalsIgnoreCase("psk2")) {
                    o000000o.O00000oo = "[WPA2-PSK-CCMP]";
                } else if (wifiInfo.O0000O0o.equalsIgnoreCase("mixed-psk")) {
                    o000000o.O00000oo = "[WPA-PSK-CCMP+TKIP]";
                } else {
                    o000000o.O00000oo = "";
                }
                o000000o.O00000o = wifiInfo.O00000oO;
                o000000o.O00000Oo = true;
                o000000o.f18408O000000o = this.f11915O000000o.getConnectionInfo().getNetworkId();
                gfq.O000000o().O000000o(o000000o);
                return;
            }
            if (this.O0000Oo) {
                scanResult = this.O00000o.get(this.O00000oO).f1089O000000o;
            } else {
                scanResult = this.O00000o0.get(this.O00000oO).f1089O000000o;
            }
            gwj.O000000o o000000o2 = new gwj.O000000o();
            o000000o2.O00000oO = scanResult.BSSID;
            if (o000000o2.O00000oO == null) {
                o000000o2.O00000oO = "";
            }
            o000000o2.O00000o0 = scanResult.SSID;
            o000000o2.O00000oo = scanResult.capabilities;
            o000000o2.O00000o = this.O0000o0;
            o000000o2.O00000Oo = true;
            o000000o2.f18408O000000o = this.f11915O000000o.getConnectionInfo().getNetworkId();
            gfq.O000000o().O000000o(o000000o2);
        }
    }

    private static void O000000o(WifiConfiguration wifiConfiguration, ScanResult scanResult, String str) {
        int O00000Oo2 = iag.O00000Oo(scanResult);
        wifiConfiguration.SSID = iag.O000000o(scanResult.SSID);
        wifiConfiguration.BSSID = scanResult.BSSID;
        if (O00000Oo2 != 0) {
            if (O00000Oo2 == 1) {
                wifiConfiguration.hiddenSSID = true;
                String[] strArr = wifiConfiguration.wepKeys;
                strArr[0] = jdn.f1779O000000o + str + jdn.f1779O000000o;
                wifiConfiguration.allowedAuthAlgorithms.set(1);
                wifiConfiguration.allowedGroupCiphers.set(3);
                wifiConfiguration.allowedGroupCiphers.set(2);
                wifiConfiguration.allowedGroupCiphers.set(0);
                wifiConfiguration.allowedGroupCiphers.set(1);
                wifiConfiguration.allowedKeyManagement.set(0);
                wifiConfiguration.wepTxKeyIndex = 0;
            } else if (O00000Oo2 != 2) {
                return;
            }
            wifiConfiguration.preSharedKey = jdn.f1779O000000o + str + jdn.f1779O000000o;
            wifiConfiguration.allowedKeyManagement.set(1);
            BaseWifiSettingUtils.TKIPType O000000o2 = iag.O000000o(scanResult);
            if (O000000o2 == BaseWifiSettingUtils.TKIPType.TKIP_CCMP) {
                wifiConfiguration.allowedGroupCiphers.set(3);
                wifiConfiguration.allowedGroupCiphers.set(2);
                wifiConfiguration.allowedPairwiseCiphers.set(2);
                wifiConfiguration.allowedPairwiseCiphers.set(1);
            } else if (O000000o2 == BaseWifiSettingUtils.TKIPType.TKIP) {
                wifiConfiguration.allowedGroupCiphers.set(2);
                wifiConfiguration.allowedPairwiseCiphers.set(1);
            } else if (O000000o2 == BaseWifiSettingUtils.TKIPType.CCMP) {
                wifiConfiguration.allowedGroupCiphers.set(3);
                wifiConfiguration.allowedPairwiseCiphers.set(2);
            }
            wifiConfiguration.status = 0;
            return;
        }
        wifiConfiguration.allowedKeyManagement.set(0);
    }

    public static void startConnectWifi(int i, WifiManager wifiManager) {
        boolean z;
        if (Build.VERSION.SDK_INT > 10) {
            try {
                Class<?> cls = Class.forName(WifiManager.class.getName());
                gsy.O000000o(4, "111", "class3:" + cls.getName());
                Method[] methods = cls.getMethods();
                int i2 = 0;
                while (true) {
                    if (i2 >= methods.length) {
                        z = false;
                        break;
                    } else if ((methods[i2].getName().equalsIgnoreCase("connect") || methods[i2].getName().equalsIgnoreCase("connectNetwork")) && methods[i2].getParameterTypes()[0].getName().equals("int")) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    methods[i2].setAccessible(true);
                    if (methods[i2].getName().equalsIgnoreCase("connect")) {
                        methods[i2].invoke(wifiManager, Integer.valueOf(i), null);
                        return;
                    }
                    methods[i2].invoke(wifiManager, Integer.valueOf(i));
                }
            } catch (Exception unused) {
            }
        } else {
            wifiManager.enableNetwork(i, true);
        }
    }

    class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f11960O000000o;
        public ImageView O00000Oo;
        public TextView O00000o;
        public ImageView O00000o0;

        O00000o0() {
        }
    }

    class O000000o extends BaseAdapter {
        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        O000000o() {
        }

        public final int getCount() {
            return BaseWifiSetting.this.O00000o0.size();
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(BaseWifiSetting.this).inflate((int) R.layout.kuailian_wifi_item, (ViewGroup) null);
                O00000o0 o00000o0 = new O00000o0();
                o00000o0.f11960O000000o = (TextView) view.findViewById(R.id.wifi_name);
                o00000o0.O00000Oo = (ImageView) view.findViewById(R.id.miwif_tag);
                o00000o0.O00000o = (TextView) view.findViewById(R.id.security_name);
                o00000o0.O00000o0 = (ImageView) view.findViewById(R.id.wifi_signal_level);
                view.setTag(o00000o0);
            }
            O00000o0 o00000o02 = (O00000o0) view.getTag();
            o00000o02.f11960O000000o.setText(BaseWifiSetting.this.O00000o0.get(i).f1089O000000o.SSID);
            if (BaseWifiSetting.this.O00000o0.get(i).O00000o0) {
                o00000o02.O00000Oo.setVisibility(0);
            } else {
                o00000o02.O00000Oo.setVisibility(8);
            }
            TextView textView = o00000o02.O00000o;
            BaseWifiSetting baseWifiSetting = BaseWifiSetting.this;
            textView.setText(iag.O000000o(baseWifiSetting, baseWifiSetting.O00000o0.get(i)));
            o00000o02.O00000o0.setImageResource(iag.O000000o(iag.O00000Oo(BaseWifiSetting.this.O00000o0.get(i).f1089O000000o.level)));
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    if (!TextUtils.isEmpty(BaseWifiSetting.this.O0000OOo) && !BaseWifiSetting.this.O0000OOo.equalsIgnoreCase(BaseWifiSetting.this.O00000o0.get(i).f1089O000000o.BSSID)) {
                        new MLAlertDialog.Builder(BaseWifiSetting.this).O00000Oo((int) R.string.kuailian_conn_error_router).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o.AnonymousClass1.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (BaseWifiSetting.this.O00000oO != i) {
                                    BaseWifiSetting.this.mPasswordEditor.setText("");
                                }
                                BaseWifiSetting.this.O00000oO = i;
                                BaseWifiSetting.this.mWifiChooser.setText(BaseWifiSetting.this.O00000o0.get(i).f1089O000000o.SSID);
                                BaseWifiSetting.this.checkShowPassword(BaseWifiSetting.this.O00000o0.get(BaseWifiSetting.this.O00000oO).f1089O000000o);
                                BaseWifiSetting.this.checkConfirmEnabled();
                                BaseWifiSetting.this.O0000Oo = false;
                                BaseWifiSetting.this.O00000o0();
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).O00000oo();
                    } else if (iag.O00000Oo(BaseWifiSetting.this.O00000o0.get(i).f1089O000000o) == 0) {
                        new MLAlertDialog.Builder(BaseWifiSetting.this).O000000o((int) R.string.kuailian_unsafe_wifi).O00000Oo((int) R.string.kuailian_unsafe_wifi_content).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o.AnonymousClass1.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (BaseWifiSetting.this.O00000oO != i) {
                                    BaseWifiSetting.this.mPasswordEditor.setText("");
                                }
                                BaseWifiSetting.this.O00000oO = i;
                                BaseWifiSetting.this.mWifiChooser.setText(BaseWifiSetting.this.O00000o0.get(i).f1089O000000o.SSID);
                                BaseWifiSetting.this.checkShowPassword(BaseWifiSetting.this.O00000o0.get(BaseWifiSetting.this.O00000oO).f1089O000000o);
                                BaseWifiSetting.this.checkConfirmEnabled();
                                BaseWifiSetting.this.O00000o0();
                                BaseWifiSetting.this.O0000Oo = false;
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o.AnonymousClass1.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).O00000oo();
                    } else {
                        if (BaseWifiSetting.this.O00000oO != i) {
                            BaseWifiSetting.this.mPasswordEditor.setText("");
                        }
                        BaseWifiSetting.this.O00000oO = i;
                        BaseWifiSetting.this.mWifiChooser.setText(BaseWifiSetting.this.O00000o0.get(i).f1089O000000o.SSID);
                        BaseWifiSetting.this.checkShowPassword(BaseWifiSetting.this.O00000o0.get(BaseWifiSetting.this.O00000oO).f1089O000000o);
                        BaseWifiSetting.this.checkConfirmEnabled();
                        BaseWifiSetting.this.O0000Oo = false;
                        BaseWifiSetting.this.O00000o0();
                    }
                }
            });
            return view;
        }
    }

    class O00000Oo extends BaseAdapter {
        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        O00000Oo() {
        }

        public final int getCount() {
            return BaseWifiSetting.this.O00000o.size();
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(BaseWifiSetting.this).inflate((int) R.layout.kuailian_wifi_item, (ViewGroup) null);
                O00000o0 o00000o0 = new O00000o0();
                o00000o0.f11960O000000o = (TextView) view.findViewById(R.id.wifi_name);
                o00000o0.O00000Oo = (ImageView) view.findViewById(R.id.miwif_tag);
                o00000o0.O00000o = (TextView) view.findViewById(R.id.security_name);
                o00000o0.O00000o0 = (ImageView) view.findViewById(R.id.wifi_signal_level);
                view.setTag(o00000o0);
            }
            O00000o0 o00000o02 = (O00000o0) view.getTag();
            o00000o02.f11960O000000o.setText(BaseWifiSetting.this.O00000o.get(i).f1089O000000o.SSID);
            o00000o02.f11960O000000o.setTextColor(BaseWifiSetting.this.getResources().getColor(R.color.mj_color_gray_lighter));
            if (BaseWifiSetting.this.O00000o.get(i).O00000o0) {
                o00000o02.O00000Oo.setVisibility(0);
            } else {
                o00000o02.O00000Oo.setVisibility(8);
            }
            o00000o02.O00000o0.setImageResource(iag.O000000o(iag.O00000Oo(BaseWifiSetting.this.O00000o.get(i).f1089O000000o.level)));
            TextView textView = o00000o02.O00000o;
            BaseWifiSetting baseWifiSetting = BaseWifiSetting.this;
            textView.setText(iag.O000000o(baseWifiSetting, baseWifiSetting.O00000o.get(i)));
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O00000Oo.AnonymousClass1 */

                public final void onClick(View view) {
                    ScanResult scanResult = BaseWifiSetting.this.O00000o.get(i).f1089O000000o;
                    if (scanResult.frequency > 5000 || scanResult.capabilities.contains("WEP") || scanResult.capabilities.contains("EAP") || scanResult.capabilities.contains("WAPI-KEY") || scanResult.capabilities.contains("WAPI-PSK") || scanResult.capabilities.contains("WAPI-CERT") || scanResult.level == 0 || DeviceFactory.O00000oo(scanResult)) {
                        new MLAlertDialog.Builder(BaseWifiSetting.this).O00000Oo((int) R.string.kuailian_unconn_reason).O000000o((int) R.string.confirm_button, (DialogInterface.OnClickListener) null).O00000oo();
                    } else if (BaseWifiSetting.this.isContainUnsupportChar(BaseWifiSetting.this.O00000o.get(i).f1089O000000o.SSID)) {
                        new MLAlertDialog.Builder(BaseWifiSetting.this).O000000o((int) R.string.kuailian_contain_unsupport_char).O00000Oo((int) R.string.kuailian_unsafe_wifi_content).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O00000Oo.AnonymousClass1.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (BaseWifiSetting.this.O00000oO != i) {
                                    BaseWifiSetting.this.mPasswordEditor.setText("");
                                }
                                BaseWifiSetting.this.O00000oO = i;
                                BaseWifiSetting.this.mWifiChooser.setText(BaseWifiSetting.this.O00000o.get(i).f1089O000000o.SSID);
                                BaseWifiSetting.this.checkShowPassword(BaseWifiSetting.this.O00000o.get(BaseWifiSetting.this.O00000oO).f1089O000000o);
                                BaseWifiSetting.this.checkConfirmEnabled();
                                BaseWifiSetting.this.O00000o0();
                                BaseWifiSetting.this.O0000Oo = true;
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O00000Oo.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).O00000oo();
                    } else {
                        new MLAlertDialog.Builder(BaseWifiSetting.this).O000000o((int) R.string.kuailian_unsafe_wifi).O00000Oo((int) R.string.kuailian_unsafe_wifi_content_1).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O00000Oo.AnonymousClass1.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (BaseWifiSetting.this.O00000oO != i) {
                                    BaseWifiSetting.this.mPasswordEditor.setText("");
                                }
                                BaseWifiSetting.this.O00000oO = i;
                                BaseWifiSetting.this.mWifiChooser.setText(BaseWifiSetting.this.O00000o.get(i).f1089O000000o.SSID);
                                BaseWifiSetting.this.checkShowPassword(BaseWifiSetting.this.O00000o.get(BaseWifiSetting.this.O00000oO).f1089O000000o);
                                BaseWifiSetting.this.checkConfirmEnabled();
                                BaseWifiSetting.this.O00000o0();
                                BaseWifiSetting.this.O0000Oo = true;
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O00000Oo.AnonymousClass1.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).O00000oo();
                    }
                }
            });
            return view;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        this.mSmartConfigList.setVisibility(0);
        this.mSmartConfigList.startAnimation(AnimationUtils.loadAnimation(this, R.anim.v5_dialog_enter));
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        this.mSmartConfigList.setVisibility(8);
        this.mSmartConfigList.startAnimation(AnimationUtils.loadAnimation(this, R.anim.v5_dialog_exit));
    }

    public long getStartTime() {
        return this.O0000o;
    }

    public String getConnDeviceModel() {
        return this.O0000O0o;
    }

    public void goCameraBarcodeConnection() {
        String str;
        String str2;
        ScanResult scanResult;
        WifiManager wifiManager = (WifiManager) getSystemService("wifi");
        if (wifiManager.isWifiEnabled() || this.O00000oO != -1) {
            this.O0000o = System.currentTimeMillis();
            android.net.wifi.WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                gwj.O000000o O000000o2 = gfq.O000000o().O000000o(connectionInfo.getBSSID());
                if (O000000o2 != null) {
                    str = O000000o2.O00000o0;
                    str2 = O000000o2.O00000o;
                } else {
                    if (this.O0000Oo) {
                        scanResult = this.O00000o.get(this.O00000oO).f1089O000000o;
                    } else {
                        scanResult = this.O00000o0.get(this.O00000oO).f1089O000000o;
                    }
                    str = scanResult.SSID;
                    str2 = this.O0000o0;
                }
                Intent intent = new Intent(this, CameraBarcodeGenActivity.class);
                intent.putExtra("ssid", str);
                intent.putExtra("password", str2);
                startActivityForResult(intent, 1);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(int, boolean):void
      com.xiaomi.smarthome.wificonfig.BaseWifiSetting.O000000o(boolean, boolean):void */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 != -1) {
            O000000o(true, true);
        } else if (intent == null) {
            O000000o(true, false);
        } else if ("retry".equals(intent.getStringExtra("ret"))) {
            this.O0000oOO = true;
            this.O0000OoO = false;
            switchToSecondStep();
        } else {
            O000000o(true, false);
        }
    }

    public void getSelectSSIDAndPasswd(Map<String, String> map) {
        ScanResult scanResult;
        fuf.O00000o0 o00000o0 = this.O0000oO0;
        if (o00000o0 != null) {
            WifiInfo wifiInfo = null;
            Iterator<WifiInfo> it = o00000o0.f17173O000000o.iterator();
            while (it.hasNext()) {
                WifiInfo next = it.next();
                if (next.f11472O000000o > 0 && next.f11472O000000o < 20) {
                    wifiInfo = next;
                }
            }
            if (wifiInfo != null) {
                map.put("ssid", wifiInfo.O00000o0);
                map.put("passwd", wifiInfo.O00000oO);
                return;
            }
            return;
        }
        if (this.O0000Oo) {
            scanResult = this.O00000o.get(this.O00000oO).f1089O000000o;
        } else {
            scanResult = this.O00000o0.get(this.O00000oO).f1089O000000o;
        }
        gwj.O000000o O000000o2 = gfq.O000000o().O000000o(scanResult.BSSID);
        if (O000000o2 != null) {
            map.put("ssid", O000000o2.O00000o0);
            map.put("passwd", O000000o2.O00000o);
            return;
        }
        map.put("ssid", scanResult.SSID);
        map.put("passwd", this.O0000o0);
    }
}

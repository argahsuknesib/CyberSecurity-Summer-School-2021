package com.xiaomi.smarthome.miio;

import _m_j.dxc;
import _m_j.dxe;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fmw;
import _m_j.fnn;
import _m_j.gfq;
import _m_j.gog;
import _m_j.gri;
import _m_j.gsy;
import _m_j.gty;
import _m_j.gwj;
import _m_j.htq;
import _m_j.hua;
import _m_j.hud;
import _m_j.iae;
import _m_j.izb;
import _m_j.jdn;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.google.android.exoplayer2.C;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseWhiteActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.BtnAndProgressView;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshLinearLayout;
import com.xiaomi.smarthome.library.common.widget.ExpandListView;
import com.xiaomi.smarthome.library.common.widget.WaveView;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WifiSetting extends BaseWhiteActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    ScanResult f9515O000000o;
    String O00000Oo;
    private CheckBox O00000o;
    private View[] O00000o0 = new View[6];
    private View O00000oO;
    private boolean O00000oo = false;
    private Dialog O0000O0o;
    private boolean O0000OOo = false;
    private BroadcastReceiver O0000Oo0 = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                WifiSetting.this.mHandler.sendEmptyMessage(100);
            } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    Message obtainMessage = WifiSetting.this.mHandler.obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.obj = (NetworkInfo) parcelableExtra;
                    WifiSetting.this.mHandler.sendMessage(obtainMessage);
                }
            } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                WifiSetting.this.mHandler.sendEmptyMessage(102);
            }
        }
    };
    public List<O00000Oo> m5GScanResult = new ArrayList();
    public BtnAndProgressView mBtnProgressView;
    public boolean mChooseUnconnWifi = false;
    public BaseAdapter mConnAdapter;
    public ListView mConnectList;
    public int mDeviceCount = 0;
    public View mFirstAnimView;
    public Handler mHandler = new Handler() {
        /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass9 */

        /* JADX WARNING: Code restructure failed: missing block: B:141:0x054e, code lost:
            r5 = true;
         */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x045e  */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x048f  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x0492 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x0493  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x01c0  */
        public final void handleMessage(Message message) {
            ScanResult scanResult;
            List<ScanResult> scanResults;
            int i;
            WifiSetting wifiSetting;
            boolean z;
            ScanResult scanResult2;
            ScanResult scanResult3;
            Message message2 = message;
            char c = 3;
            boolean z2 = false;
            switch (message2.what) {
                case 100:
                case 104:
                    if (!WifiSetting.this.mIsDestory) {
                        WifiInfo connectionInfo = WifiSetting.this.mWifiManager.getConnectionInfo();
                        if (WifiSetting.this.mState == State.SCANNING || WifiSetting.this.mState == State.RECANNINGINPUT) {
                            if (WifiSetting.this.mPosition != -1) {
                                if (WifiSetting.this.mChooseUnconnWifi) {
                                    if (WifiSetting.this.mPosition < WifiSetting.this.mUnconnectResult.size()) {
                                        scanResult = WifiSetting.this.mUnconnectResult.get(WifiSetting.this.mPosition).f9548O000000o;
                                        scanResults = WifiSetting.this.mWifiManager.getScanResults();
                                        WifiSetting.this.mScanResult.clear();
                                        WifiSetting.this.m5GScanResult.clear();
                                        WifiSetting.this.mUnconnectResult.clear();
                                        HashMap hashMap = new HashMap();
                                        HashMap hashMap2 = new HashMap();
                                        i = 0;
                                        String str = null;
                                        while (i < scanResults.size()) {
                                            if (!TextUtils.isEmpty(scanResults.get(i).SSID) && !DeviceFactory.O00000oo(scanResults.get(i))) {
                                                boolean isMiwifi = WifiSetting.this.isMiwifi(scanResults.get(i));
                                                boolean z3 = gfq.O000000o().O000000o(scanResults.get(i).BSSID) != null;
                                                if (connectionInfo != null && WifiSetting.O000000o(connectionInfo.getSSID(), scanResults.get(i).SSID) && isMiwifi && scanResults.get(i).frequency > 5000) {
                                                    String[] split = scanResults.get(i).BSSID.split("\\:");
                                                    Object[] objArr = new Object[6];
                                                    objArr[0] = split[0];
                                                    objArr[1] = split[1];
                                                    objArr[2] = split[2];
                                                    objArr[c] = split[c];
                                                    objArr[4] = split[4];
                                                    objArr[5] = Integer.valueOf(Integer.valueOf(split[5], 16).intValue() - 1);
                                                    str = String.format("%1$s:%2$s:%3$s:%4$s:%5$s:%6$x", objArr);
                                                }
                                                if (scanResults.get(i).frequency > 5000 || scanResults.get(i).capabilities.contains("WEP") || scanResults.get(i).capabilities.contains("EAP") || scanResults.get(i).capabilities.contains("WAPI-KEY") || scanResults.get(i).capabilities.contains("WAPI-PSK") || scanResults.get(i).capabilities.contains("WAPI-CERT") || WifiSetting.getSecurity(scanResults.get(i)) == 0 || scanResults.get(i).level == 0) {
                                                    O00000Oo o00000Oo = new O00000Oo();
                                                    o00000Oo.O00000o0 = isMiwifi;
                                                    o00000Oo.O00000Oo = z3;
                                                    o00000Oo.f9548O000000o = scanResults.get(i);
                                                    if (scanResults.get(i).frequency > 5000) {
                                                        WifiSetting.this.m5GScanResult.add(o00000Oo);
                                                    }
                                                    if (!hashMap2.containsKey(scanResults.get(i).SSID)) {
                                                        WifiSetting.this.mUnconnectResult.add(o00000Oo);
                                                        hashMap2.put(scanResults.get(i).SSID, o00000Oo);
                                                    } else if (WifiSetting.calculateSignalLevel(scanResults.get(i).level, 100) > WifiSetting.calculateSignalLevel(((O00000Oo) hashMap2.get(scanResults.get(i).SSID)).f9548O000000o.level, 100)) {
                                                        O00000Oo o00000Oo2 = (O00000Oo) hashMap2.get(scanResults.get(i).SSID);
                                                        hashMap.remove(o00000Oo.f9548O000000o.SSID);
                                                        hashMap.put(scanResults.get(i).SSID, o00000Oo);
                                                        WifiSetting.this.mUnconnectResult.remove(o00000Oo2);
                                                        WifiSetting.this.mUnconnectResult.add(o00000Oo2);
                                                    }
                                                } else {
                                                    O00000Oo o00000Oo3 = new O00000Oo();
                                                    o00000Oo3.O00000o0 = isMiwifi;
                                                    o00000Oo3.O00000Oo = z3;
                                                    o00000Oo3.f9548O000000o = scanResults.get(i);
                                                    if (!hashMap.containsKey(scanResults.get(i).SSID)) {
                                                        WifiSetting.this.mScanResult.add(o00000Oo3);
                                                        hashMap.put(scanResults.get(i).SSID, o00000Oo3);
                                                    } else if (WifiSetting.calculateSignalLevel(scanResults.get(i).level, 100) > WifiSetting.calculateSignalLevel(((O00000Oo) hashMap.get(scanResults.get(i).SSID)).f9548O000000o.level, 100)) {
                                                        O00000Oo o00000Oo4 = (O00000Oo) hashMap.get(scanResults.get(i).SSID);
                                                        hashMap.remove(o00000Oo4.f9548O000000o.SSID);
                                                        hashMap.put(scanResults.get(i).SSID, o00000Oo3);
                                                        WifiSetting.this.mScanResult.remove(o00000Oo4);
                                                        WifiSetting.this.mUnconnectResult.remove(o00000Oo4);
                                                        WifiSetting.this.mUnconnectResult.add(o00000Oo4);
                                                    } else {
                                                        WifiSetting.this.mScanResult.remove(hashMap.get(scanResults.get(i).SSID));
                                                        WifiSetting.this.mUnconnectResult.remove(hashMap.get(scanResults.get(i).SSID));
                                                        WifiSetting.this.mUnconnectResult.add(hashMap.get(scanResults.get(i).SSID));
                                                    }
                                                }
                                            }
                                            i++;
                                            c = 3;
                                        }
                                        AnonymousClass1 r3 = new Comparator<O00000Oo>() {
                                            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass9.AnonymousClass1 */

                                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                                return ((O00000Oo) obj).f9548O000000o.SSID.compareTo(((O00000Oo) obj2).f9548O000000o.SSID);
                                            }
                                        };
                                        Collections.sort(WifiSetting.this.mScanResult, r3);
                                        Collections.sort(WifiSetting.this.mUnconnectResult, r3);
                                        wifiSetting = WifiSetting.this;
                                        if (wifiSetting.mScanResult.size() == 0) {
                                            new MLAlertDialog.Builder(wifiSetting).O00000Oo((int) R.string.get_wifi_scan_result_error).O000000o((int) R.string.wifi_rescan_wifi, new DialogInterface.OnClickListener() {
                                                /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass13 */

                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    WifiSetting.this.mScanWifi.setVisibility(0);
                                                    WifiSetting.this.mWifiManager.startScan();
                                                    WifiSetting.this.mPasswordEditor.setEnabled(false);
                                                    WifiSetting.this.mWifiChooser.setEnabled(false);
                                                    WifiSetting.this.mBtnProgressView.setEnabled(false);
                                                    WifiSetting.this.mPasswordToggle.setEnabled(false);
                                                    WifiSetting.this.mState = State.SCANNING;
                                                }
                                            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                                                /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass12 */

                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    WifiSetting.this.O000000o(true);
                                                }
                                            }).O000000o(false).O00000oo();
                                            wifiSetting.mState = State.INPUT;
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (!z) {
                                            if (WifiSetting.this.mPosition != -1) {
                                                if (scanResult != null) {
                                                    int i2 = 0;
                                                    while (true) {
                                                        if (i2 < WifiSetting.this.mScanResult.size()) {
                                                            if (scanResult.BSSID.equalsIgnoreCase(WifiSetting.this.mScanResult.get(i2).f9548O000000o.BSSID)) {
                                                                WifiSetting wifiSetting2 = WifiSetting.this;
                                                                wifiSetting2.mPosition = i2;
                                                                wifiSetting2.mWifiChooser.setText(WifiSetting.this.mScanResult.get(i2).f9548O000000o.SSID);
                                                            } else if (str == null || !scanResult.BSSID.equalsIgnoreCase(str)) {
                                                                i2++;
                                                            } else {
                                                                WifiSetting wifiSetting3 = WifiSetting.this;
                                                                wifiSetting3.mPosition = i2;
                                                                wifiSetting3.mWifiChooser.setText(WifiSetting.this.mScanResult.get(i2).f9548O000000o.SSID);
                                                            }
                                                        }
                                                    }
                                                    z2 = true;
                                                }
                                                if (!z2) {
                                                    WifiSetting wifiSetting4 = WifiSetting.this;
                                                    wifiSetting4.mPosition = -1;
                                                    wifiSetting4.mWifiChooser.setText((int) R.string.wifi_setting_choose);
                                                }
                                            } else {
                                                if (!(connectionInfo == null || connectionInfo.getBSSID() == null)) {
                                                    int i3 = 0;
                                                    while (true) {
                                                        if (i3 < WifiSetting.this.mScanResult.size()) {
                                                            if (!connectionInfo.getBSSID().equalsIgnoreCase(WifiSetting.this.mScanResult.get(i3).f9548O000000o.BSSID)) {
                                                                if (str != null && WifiSetting.this.mScanResult.get(i3).f9548O000000o.BSSID.equalsIgnoreCase(str)) {
                                                                    WifiSetting wifiSetting5 = WifiSetting.this;
                                                                    wifiSetting5.mPosition = i3;
                                                                    wifiSetting5.mWifiChooser.setText(WifiSetting.this.mScanResult.get(i3).f9548O000000o.SSID);
                                                                    break;
                                                                } else {
                                                                    i3++;
                                                                }
                                                            } else {
                                                                WifiSetting wifiSetting6 = WifiSetting.this;
                                                                wifiSetting6.mPosition = i3;
                                                                wifiSetting6.mWifiChooser.setText(WifiSetting.this.mScanResult.get(i3).f9548O000000o.SSID);
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (!z2) {
                                                    WifiSetting wifiSetting7 = WifiSetting.this;
                                                    wifiSetting7.mPosition = -1;
                                                    wifiSetting7.mWifiChooser.setText((int) R.string.wifi_setting_choose);
                                                }
                                            }
                                            WifiSetting.this.mScanWifi.setVisibility(8);
                                            WifiSetting.this.mState = State.INPUT;
                                            WifiSetting wifiSetting8 = WifiSetting.this;
                                            if (wifiSetting8.mPosition == -1) {
                                                scanResult2 = null;
                                            } else {
                                                scanResult2 = WifiSetting.this.mScanResult.get(WifiSetting.this.mPosition).f9548O000000o;
                                            }
                                            wifiSetting8.checkShowPassword(scanResult2);
                                            WifiSetting.this.checkConfirmEnabled();
                                            WifiSetting.this.mPasswordEditor.setEnabled(true);
                                            WifiSetting.this.mWifiChooser.setEnabled(true);
                                            WifiSetting.this.findViewById(R.id.wifi_ssid_toggle).setEnabled(true);
                                            WifiSetting.this.mPasswordToggle.setEnabled(true);
                                            WifiSetting.this.mHandler.removeMessages(104);
                                            if (WifiSetting.this.mSmartConfigList.getVisibility() == 0) {
                                                WifiSetting.this.mConnAdapter.notifyDataSetChanged();
                                                WifiSetting.this.mUnConnectAdapter.notifyDataSetChanged();
                                                WifiSetting.this.mSmartConfigList.O00000Oo();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    WifiSetting.this.mPosition = -1;
                                } else if (WifiSetting.this.mPosition < WifiSetting.this.mScanResult.size()) {
                                    scanResult = WifiSetting.this.mScanResult.get(WifiSetting.this.mPosition).f9548O000000o;
                                    scanResults = WifiSetting.this.mWifiManager.getScanResults();
                                    WifiSetting.this.mScanResult.clear();
                                    WifiSetting.this.m5GScanResult.clear();
                                    WifiSetting.this.mUnconnectResult.clear();
                                    HashMap hashMap3 = new HashMap();
                                    HashMap hashMap22 = new HashMap();
                                    i = 0;
                                    String str2 = null;
                                    while (i < scanResults.size()) {
                                    }
                                    AnonymousClass1 r32 = new Comparator<O00000Oo>() {
                                        /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass9.AnonymousClass1 */

                                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                                            return ((O00000Oo) obj).f9548O000000o.SSID.compareTo(((O00000Oo) obj2).f9548O000000o.SSID);
                                        }
                                    };
                                    Collections.sort(WifiSetting.this.mScanResult, r32);
                                    Collections.sort(WifiSetting.this.mUnconnectResult, r32);
                                    wifiSetting = WifiSetting.this;
                                    if (wifiSetting.mScanResult.size() == 0) {
                                    }
                                    if (!z) {
                                    }
                                } else {
                                    WifiSetting.this.mPosition = -1;
                                }
                            }
                            scanResult = null;
                            scanResults = WifiSetting.this.mWifiManager.getScanResults();
                            WifiSetting.this.mScanResult.clear();
                            WifiSetting.this.m5GScanResult.clear();
                            WifiSetting.this.mUnconnectResult.clear();
                            HashMap hashMap32 = new HashMap();
                            HashMap hashMap222 = new HashMap();
                            i = 0;
                            String str22 = null;
                            while (i < scanResults.size()) {
                            }
                            AnonymousClass1 r322 = new Comparator<O00000Oo>() {
                                /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass9.AnonymousClass1 */

                                public final /* synthetic */ int compare(Object obj, Object obj2) {
                                    return ((O00000Oo) obj).f9548O000000o.SSID.compareTo(((O00000Oo) obj2).f9548O000000o.SSID);
                                }
                            };
                            Collections.sort(WifiSetting.this.mScanResult, r322);
                            Collections.sort(WifiSetting.this.mUnconnectResult, r322);
                            wifiSetting = WifiSetting.this;
                            if (wifiSetting.mScanResult.size() == 0) {
                            }
                            if (!z) {
                            }
                        } else if (WifiSetting.this.mState == State.RESCANNING) {
                            WifiSetting wifiSetting9 = WifiSetting.this;
                            wifiSetting9.connectToWifi(wifiSetting9.mPasswd);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                    break;
                case 101:
                    NetworkInfo.DetailedState detailedState = ((NetworkInfo) message2.obj).getDetailedState();
                    if (detailedState == NetworkInfo.DetailedState.OBTAINING_IPADDR && WifiSetting.this.mState == State.CONNECTTING) {
                        WifiSetting.this.mHandler.removeMessages(103);
                    }
                    if (detailedState == NetworkInfo.DetailedState.CONNECTED && WifiSetting.this.mState == State.CONNECTTING) {
                        WifiInfo connectionInfo2 = WifiSetting.this.mWifiManager.getConnectionInfo();
                        if (WifiSetting.this.mChooseUnconnWifi) {
                            scanResult3 = WifiSetting.this.mUnconnectResult.get(WifiSetting.this.mPosition).f9548O000000o;
                        } else {
                            scanResult3 = WifiSetting.this.mScanResult.get(WifiSetting.this.mPosition).f9548O000000o;
                        }
                        if (connectionInfo2 == null || !WifiSetting.O000000o(connectionInfo2.getSSID(), scanResult3.SSID)) {
                            WifiSetting.this.mHandler.sendEmptyMessage(103);
                            return;
                        }
                        WifiSetting.this.saveWifiItem();
                        fnn.O000000o().O000000o(WifiSetting.this.mLastNetwork);
                        WifiSetting.this.mHandler.removeMessages(103);
                        WifiSetting.this.switchToNetworkTestStep();
                        return;
                    }
                    return;
                case 102:
                    if (WifiSetting.this.mWifiManager.getWifiState() == 3 && WifiSetting.this.mState == State.SCANNING) {
                        WifiSetting.this.mWifiManager.startScan();
                        return;
                    }
                    return;
                case 103:
                    WifiSetting.this.mState = State.INPUT;
                    WifiSetting.this.mPasswordEditor.setEnabled(true);
                    WifiSetting.this.mWifiChooser.setEnabled(true);
                    WifiSetting.this.findViewById(R.id.wifi_ssid_toggle).setEnabled(true);
                    WifiSetting.this.mBtnProgressView.O000000o();
                    WifiSetting.this.mBtnProgressView.setEnabled(true);
                    WifiSetting.this.mPasswordToggle.setEnabled(true);
                    izb.O000000o(WifiSetting.this, (int) R.string.wifi_setting_connection_failed, 0).show();
                    return;
                case 105:
                default:
                    return;
                case 106:
                    if (((Boolean) message2.obj).booleanValue()) {
                        WifiSetting.this.switchToFinalStep(true);
                        return;
                    } else {
                        WifiSetting.this.switchToFinalStep(false);
                        return;
                    }
            }
        }
    };
    public int mIconWidth;
    public boolean mIsDestory = false;
    public boolean mIsShowPasswd;
    public int mLastNetwork = -1;
    public TextView mMainTitleView;
    public String mPasswd;
    public EditText mPasswordEditor;
    public EditText mPasswordEditorAbove;
    public ToggleButton mPasswordToggle;
    public int mPosition = -1;
    public List<O00000Oo> mScanResult = new ArrayList();
    public View mScanWifi;
    public CustomPullDownRefreshLinearLayout mSmartConfigList;
    public State mState;
    public int mStep;
    public TextView mSubMainTitleView;
    public BaseAdapter mUnConnectAdapter;
    public ListView mUnConnectList;
    public List<O00000Oo> mUnconnectResult = new ArrayList();
    public WaveView mWaveView;
    public TextView mWifiChooser;
    public WifiManager mWifiManager;

    enum PskType {
        UNKNOWN,
        WPA,
        WPA2,
        WPA_WPA2
    }

    enum State {
        SCANNING,
        INPUT,
        RECANNINGINPUT,
        RESCANNING,
        CONNECTTING,
        CONNECTTING_AP
    }

    enum TKIPType {
        TKIP_CCMP,
        TKIP,
        CCMP,
        NONE
    }

    public static int calculateSignalLevel(int i, int i2) {
        if (i <= -100) {
            return 0;
        }
        if (i >= -55) {
            return 100;
        }
        return (int) ((((float) (i - -100)) * 100.0f) / 45.0f);
    }

    public int getSignalLevel(int i) {
        return i > 80 ? R.drawable.wifi_strength_5 : i > 60 ? R.drawable.wifi_strength_4 : i > 40 ? R.drawable.wifi_strength_3 : i > 20 ? R.drawable.wifi_strength_2 : R.drawable.wifi_strength_1;
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public ScanResult f9548O000000o;
        public boolean O00000Oo;
        public boolean O00000o0;

        O00000Oo() {
        }
    }

    public void onBackPressed() {
        this.mHandler.removeMessages(104);
        this.mHandler.removeMessages(103);
        if (this.mState == State.INPUT && this.mSmartConfigList.getVisibility() == 0) {
            O00000o0();
        } else if (this.mState == State.CONNECTTING) {
            this.mState = State.INPUT;
            switchToSecondStep();
        } else if (this.mState == State.INPUT) {
            O000000o(false);
        } else {
            O000000o(true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z) {
        O00000o();
        if (z) {
            gfq.O000000o().O00000Oo(gog.O00000Oo(this));
        }
        setResult(0, getIntent());
        finish();
    }

    public void onDeviceConnectionSuccess() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 106;
        obtainMessage.obj = Boolean.TRUE;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void onDeviceConnectionError() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 106;
        obtainMessage.obj = Boolean.FALSE;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void onDeviceFindDevices(int i) {
        this.mDeviceCount = i;
    }

    private void O00000o() {
        this.mHandler.removeMessages(103);
        fmw.O000000o().O00000Oo();
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        this.mIsDestory = false;
        setContentView((int) R.layout.wifi_setting_layout);
        this.O0000OOo = getIntent().getBooleanExtra("gotoBindView", false);
        this.mWifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        registerReceiver(this.O0000Oo0, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        registerReceiver(this.O0000Oo0, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        registerReceiver(this.O0000Oo0, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        if (!(getIntent() == null || getIntent().getParcelableExtra("scanResult") == null)) {
            this.f9515O000000o = (ScanResult) getIntent().getParcelableExtra("scanResult");
        }
        if (getIntent() != null) {
            this.O00000Oo = getIntent().getStringExtra("model");
        }
        try {
            this.O00000oo = false;
        } catch (Exception unused) {
        }
        this.mMainTitleView = (TextView) findViewById(R.id.main_title);
        this.mSubMainTitleView = (TextView) findViewById(R.id.main_sub_title);
        this.mBtnProgressView = (BtnAndProgressView) findViewById(R.id.next_btn);
        this.mBtnProgressView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass4 */

            public final void onClick(View view) {
                if (WifiSetting.this.mStep == 0) {
                    WifiSetting.this.switchToSecondStep();
                } else if (WifiSetting.this.mStep == 1) {
                    if (WifiSetting.this.mIsShowPasswd) {
                        WifiSetting wifiSetting = WifiSetting.this;
                        wifiSetting.mPasswd = wifiSetting.mPasswordEditor.getText().toString();
                    }
                    WifiSetting wifiSetting2 = WifiSetting.this;
                    wifiSetting2.connectToWifi(wifiSetting2.mPasswd);
                    WifiSetting.this.mBtnProgressView.O00000Oo();
                }
            }
        });
        this.mBtnProgressView.setListener(new BtnAndProgressView.O000000o() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass5 */

            public final void O00000o0() {
                WifiSetting.this.mSubMainTitleView.setText((int) R.string.kuailian_sub_main_title_3_2);
                WifiSetting.this.O000000o();
            }

            public final void O00000o() {
                WifiSetting.this.mSubMainTitleView.setText((int) R.string.kuailian_sub_main_title_3_3);
                WifiSetting.this.O000000o();
            }

            public final void O00000Oo() {
                WifiSetting.this.mSubMainTitleView.setText((int) R.string.kuailian_sub_main_title_3_1);
                WifiSetting.this.O000000o();
            }

            public final void O00000oO() {
                WifiSetting.this.mSubMainTitleView.setText((int) R.string.kuailian_sub_main_title_3_4);
                WifiSetting.this.O000000o();
            }

            public final void O0000O0o() {
                WifiSetting.this.switchToFinalStep(false);
            }

            public final void O00000oo() {
                Message obtainMessage = WifiSetting.this.mHandler.obtainMessage();
                obtainMessage.what = 106;
                if (WifiSetting.this.mDeviceCount > 0) {
                    obtainMessage.obj = Boolean.TRUE;
                    WifiSetting.this.mHandler.sendMessage(obtainMessage);
                    return;
                }
                obtainMessage.obj = Boolean.FALSE;
                WifiSetting.this.mHandler.sendMessage(obtainMessage);
            }

            public final void O000000o() {
                WifiSetting.this.switchToPage(2, true);
                WifiSetting wifiSetting = WifiSetting.this;
                wifiSetting.mStep = 2;
                if (wifiSetting.O00000Oo == null) {
                    WifiSetting.this.mMainTitleView.setText(String.format(WifiSetting.this.getString(R.string.kuailian_main_title_3), WifiSetting.this.getString(R.string.terminal_feedback)));
                } else {
                    Device O0000o0O = DeviceFactory.O0000o0O(WifiSetting.this.O00000Oo);
                    if (O0000o0O != null) {
                        WifiSetting.this.mMainTitleView.setText(String.format(WifiSetting.this.getString(R.string.kuailian_main_title_3), O0000o0O.name));
                    } else {
                        WifiSetting.this.mMainTitleView.setText(String.format(WifiSetting.this.getString(R.string.kuailian_main_title_3), SmartConfigRouterFactory.getSmartConfigManager().getAppContext().getString(R.string.other_device)));
                    }
                }
                int O000000o2 = gri.O000000o(220.0f);
                WaveView waveView = WifiSetting.this.mWaveView;
                int i = (WifiSetting.this.mIconWidth / 2) + ((int) ((((((float) O000000o2) / 2.0f) - (((float) WifiSetting.this.mIconWidth) / 2.0f)) * 3.0f) / 11.0f));
                int i2 = O000000o2 / 2;
                if (!waveView.O00000o0) {
                    waveView.O00000oO = i;
                    waveView.O00000oo = i2;
                    waveView.O0000O0o = 16777215;
                    waveView.f9291O000000o = waveView.getMeasuredWidth();
                    waveView.O00000Oo = waveView.getMeasuredHeight();
                    waveView.O0000OoO = System.currentTimeMillis();
                    waveView.O0000Ooo = 0;
                    waveView.O00000o0 = true;
                    waveView.O00000o = false;
                    waveView.O0000o0O.sendEmptyMessage(1);
                }
                WifiSetting.this.startConnection();
            }
        });
        this.O00000o0[0] = findViewById(R.id.first_step);
        this.mFirstAnimView = findViewById(R.id.first_anim_view);
        this.O00000o0[1] = findViewById(R.id.second_step);
        this.mPasswordToggle = (ToggleButton) findViewById(R.id.wifi_password_toggle);
        this.mPasswordEditor = (EditText) findViewById(R.id.wifi_password_editor);
        this.O00000oO = findViewById(R.id.wifi_setting_pass_container);
        this.mSmartConfigList = (CustomPullDownRefreshLinearLayout) findViewById(R.id.wifi_refresh_container);
        this.mSmartConfigList.setScrollView((ScrollView) findViewById(R.id.wifi_list_scroll_view));
        this.mSmartConfigList.setRefreshListener(new CustomPullDownRefreshLinearLayout.O00000o0() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass6 */

            public final void O000000o() {
                WifiSetting.this.mWifiManager.startScan();
                WifiSetting.this.mState = State.RECANNINGINPUT;
            }
        });
        this.mConnectList = (ExpandListView) findViewById(R.id.conn_wifi_list);
        this.mUnConnectList = (ExpandListView) findViewById(R.id.unconn_wifi_list);
        this.mPasswordEditorAbove = (EditText) findViewById(R.id.wifi_password_editor_above);
        this.mPasswordEditor.setVisibility(8);
        ScanResult scanResult = this.f9515O000000o;
        if (scanResult != null) {
            this.O00000Oo = DeviceFactory.O00000Oo(scanResult);
        }
        this.mScanWifi = findViewById(R.id.searching_text);
        this.mPasswordToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass7 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (WifiSetting.this.mIsShowPasswd) {
                    int selectionStart = WifiSetting.this.mPasswordEditor.getSelectionStart();
                    if (z) {
                        WifiSetting.this.mPasswordEditor.setInputType(144);
                    } else {
                        WifiSetting.this.mPasswordEditor.setInputType(129);
                    }
                    WifiSetting.this.mPasswordEditor.setSelection(selectionStart);
                }
            }
        });
        this.mPasswordToggle.setChecked(false);
        this.mPasswordEditor.setInputType(129);
        this.mPasswordEditorAbove.setInputType(129);
        this.mPasswordEditorAbove.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass8 */

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    WifiSetting wifiSetting = WifiSetting.this;
                    wifiSetting.mIsShowPasswd = true;
                    wifiSetting.mPasswordEditor.setVisibility(0);
                    WifiSetting.this.mPasswordEditorAbove.setVisibility(8);
                    WifiSetting.this.mPasswordEditor.requestFocus();
                    WifiSetting.this.mPasswordToggle.setEnabled(true);
                }
            }
        });
        this.mWifiChooser = (TextView) findViewById(R.id.login_wifi_ssid_chooser);
        this.mWifiChooser.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass10 */

            public final void onClick(View view) {
                WifiSetting.this.O00000Oo();
                WifiSetting wifiSetting = WifiSetting.this;
                wifiSetting.mConnAdapter = new O000000o();
                WifiSetting.this.mConnectList.setAdapter((ListAdapter) WifiSetting.this.mConnAdapter);
                WifiSetting wifiSetting2 = WifiSetting.this;
                wifiSetting2.mUnConnectAdapter = new O00000o0();
                WifiSetting.this.mUnConnectList.setAdapter((ListAdapter) WifiSetting.this.mUnConnectAdapter);
            }
        });
        findViewById(R.id.wifi_ssid_toggle).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass11 */

            public final void onClick(View view) {
                WifiSetting.this.O00000Oo();
                WifiSetting wifiSetting = WifiSetting.this;
                wifiSetting.mConnAdapter = new O000000o();
                WifiSetting.this.mConnectList.setAdapter((ListAdapter) WifiSetting.this.mConnAdapter);
                WifiSetting wifiSetting2 = WifiSetting.this;
                wifiSetting2.mUnConnectAdapter = new O00000o0();
                WifiSetting.this.mUnConnectList.setAdapter((ListAdapter) WifiSetting.this.mUnConnectAdapter);
            }
        });
        findViewById(R.id.wifi_ssid_toggle).setEnabled(false);
        this.O00000o = (CheckBox) findViewById(R.id.check_box_save_passwd);
        this.O00000o.setChecked(true);
        this.O00000o0[5] = findViewById(R.id.network_test_step);
        this.O00000o0[2] = findViewById(R.id.third_step);
        this.mWaveView = (WaveView) findViewById(R.id.wave_icon);
        this.O00000o0[3] = findViewById(R.id.fouth_step);
        this.O00000o0[4] = findViewById(R.id.final_step);
        if (this.O0000OOo) {
            switchToSecondStep();
            return;
        }
        switchToPage(0, false);
        this.mStep = 0;
        String str2 = this.O00000Oo;
        if (str2 == null) {
            str = getString(R.string.terminal_feedback);
        } else {
            Device O0000o0O = DeviceFactory.O0000o0O(str2);
            if (O0000o0O != null) {
                str = O0000o0O.name;
            } else {
                str = SmartConfigRouterFactory.getSmartConfigManager().getAppContext().getString(R.string.other_device);
            }
        }
        this.mMainTitleView.setText(String.format(getString(R.string.kuailian_main_title_1), str));
        this.mSubMainTitleView.setText((int) R.string.kuailian_sub_main_title_1);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_fast);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass22 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                WifiSetting.this.mFirstAnimView.startAnimation(animation);
            }
        });
        this.mFirstAnimView.startAnimation(loadAnimation);
        new Thread(new Runnable() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass23 */

            public final void run() {
                try {
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    NetworkInterface networkInterface = null;
                    while (networkInterfaces.hasMoreElements()) {
                        networkInterface = networkInterfaces.nextElement();
                        if (networkInterface.getName().contains("wlan0")) {
                            break;
                        }
                    }
                    if (networkInterface.supportsMulticast()) {
                        gsy.O000000o(6, "Support", "Support Multicast");
                    }
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    String.format("%02x:%02x:%02x:%02x:%02x:%02x", Byte.valueOf(hardwareAddress[0]), Byte.valueOf(hardwareAddress[1]), Byte.valueOf(hardwareAddress[2]), Byte.valueOf(hardwareAddress[3]), Byte.valueOf(hardwareAddress[4]), Byte.valueOf(hardwareAddress[5]));
                    networkInterface.getInetAddresses();
                    DatagramSocket datagramSocket = new DatagramSocket();
                    datagramSocket.setReuseAddress(true);
                    DatagramPacket datagramPacket = new DatagramPacket(new byte[]{1, 1, 1}, 3, new InetSocketAddress("192.168.1.1", (int) C.MSG_CUSTOM_BASE));
                    WifiSetting.setSocketNetworkInterface(datagramSocket, networkInterface);
                    datagramSocket.send(datagramPacket);
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException unused) {
                }
            }
        }).start();
        startConnectionAsso();
    }

    public void onResume() {
        super.onResume();
        if (!SmartConfigRouterFactory.getSmartConfigManager().isMiLoggedIn()) {
            Dialog dialog = this.O0000O0o;
            if (dialog == null) {
                this.O0000O0o = gty.O000000o().showLoginDialog(this, true);
                this.O0000O0o.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass18 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        WifiSetting.this.finish();
                    }
                });
            } else if (!dialog.isShowing()) {
                this.O0000O0o.show();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.O0000Oo0);
        this.mIsDestory = true;
    }

    public void switchToPage(int i, boolean z) {
        for (int i2 = 0; i2 < 6; i2++) {
            if (i2 == i) {
                View[] viewArr = this.O00000o0;
                if (viewArr[i2] != null) {
                    viewArr[i2].setVisibility(0);
                    if (z) {
                        this.O00000o0[i2].startAnimation(AnimationUtils.loadAnimation(this, R.anim.show));
                    }
                }
            } else {
                View[] viewArr2 = this.O00000o0;
                if (viewArr2[i2] != null) {
                    if (z && viewArr2[i2].getVisibility() == 0) {
                        this.O00000o0[i2].startAnimation(AnimationUtils.loadAnimation(this, R.anim.disappear));
                    }
                    this.O00000o0[i2].setVisibility(8);
                }
            }
        }
    }

    public void switchToSecondStep() {
        this.mIconWidth = this.mFirstAnimView.getWidth();
        switchToPage(1, false);
        this.mStep = 1;
        this.mMainTitleView.setText(String.format(getString(R.string.kuailian_main_title_2), new Object[0]));
        this.mSubMainTitleView.setText((int) R.string.kuailian_sub_main_title_2);
        this.mBtnProgressView.O000000o();
        int wifiState = this.mWifiManager.getWifiState();
        if (wifiState == 3) {
            this.mWifiManager.startScan();
            this.mHandler.sendEmptyMessageDelayed(104, 10000);
        } else if ((wifiState == 4 || wifiState == 1) && wifiState == 1) {
            this.mWifiManager.setWifiEnabled(true);
        }
        this.mState = State.SCANNING;
        this.mWifiChooser.setText("");
        this.mScanWifi.setVisibility(0);
        this.mBtnProgressView.setEnabled(false);
        this.O00000oO.setVisibility(8);
        this.O00000o.setVisibility(8);
        this.mBtnProgressView.setVisibility(0);
        this.mPasswordEditor.setText("");
        this.mPasswordEditor.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass24 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                WifiSetting.this.checkConfirmEnabled();
            }
        });
        this.mPasswordToggle.setChecked(false);
    }

    public void switchToNetworkTestStep() {
        switchToPage(5, true);
        this.mMainTitleView.setText(String.format(getString(R.string.kuailian_network_test), new Object[0]));
        this.mSubMainTitleView.setVisibility(8);
    }

    public void switchToThirdStep() {
        BtnAndProgressView btnAndProgressView = this.mBtnProgressView;
        btnAndProgressView.O00000Oo = System.currentTimeMillis();
        btnAndProgressView.O00000o0 = 2;
        if (!btnAndProgressView.O00000oO.hasMessages(10)) {
            btnAndProgressView.O00000oO.sendEmptyMessage(10);
        }
    }

    public void switchToFinalStep(boolean z) {
        switchToPage(4, false);
        findViewById(R.id.finish_title).setVisibility(4);
        this.mBtnProgressView.setVisibility(8);
        this.mBtnProgressView.O000000o();
        if (z) {
            this.mMainTitleView.setText(String.format(getString(R.string.kuailian_success), new Object[0]));
            this.mSubMainTitleView.setVisibility(8);
            ((ImageView) findViewById(R.id.connection_success_icon)).setImageResource(R.drawable.kuailian_success_icon);
            findViewById(R.id.finish_error_btn_container).setVisibility(8);
            findViewById(R.id.finish_success_btn).setVisibility(0);
            findViewById(R.id.finish_success_btn).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass25 */

                public final void onClick(View view) {
                    WifiSetting.this.O000000o(false);
                }
            });
            return;
        }
        this.mMainTitleView.setText(String.format(getString(R.string.kuailian_failed), new Object[0]));
        this.mSubMainTitleView.setVisibility(0);
        this.mSubMainTitleView.setText((int) R.string.kuailian_get_error_help);
        gfq.O000000o().O00000Oo(gog.O00000Oo(this));
        ((ImageView) findViewById(R.id.connection_success_icon)).setImageResource(R.drawable.kuailian_failed_icon);
        this.mSubMainTitleView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass26 */

            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
                if (r11.equals("zhimi.airpurifier.v3") == false) goto L_0x0091;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x008e, code lost:
                if (r10.f9536O000000o.O00000Oo.equals("zhimi.airpurifier.v3") == false) goto L_0x0091;
             */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x0094  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5  */
            public final void onClick(View view) {
                String str = "http://v.youku.com/v_show/id_XODYwNTMxMjIw.html";
                if (WifiSetting.this.f9515O000000o != null) {
                    String O00000Oo = DeviceFactory.O00000Oo(WifiSetting.this.f9515O000000o);
                    if (!O00000Oo.equals("yunyi.camera.v1")) {
                        if (!O00000Oo.equals("chuangmi.plug.v1") && !O00000Oo.equals("chuangmi.plug.v2")) {
                            if (!O00000Oo.equals("zhimi.airpurifier.v1")) {
                                if (!O00000Oo.equals("zhimi.airpurifier.v2")) {
                                }
                            }
                            if (str == null) {
                                WifiSetting.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                                return;
                            }
                            fbs.O000000o(new fbt(WifiSetting.this, "FaqActivity"));
                            return;
                        }
                        str = "http://v.youku.com/v_show/id_XODU2NDA2OTIw.html​";
                        if (str == null) {
                        }
                    }
                } else {
                    if (WifiSetting.this.O00000Oo != null) {
                        if (!WifiSetting.this.O00000Oo.equals("yunyi.camera.v1")) {
                            if (!WifiSetting.this.O00000Oo.equals("chuangmi.plug.v1") && !WifiSetting.this.O00000Oo.equals("chuangmi.plug.v2")) {
                                if (!WifiSetting.this.O00000Oo.equals("zhimi.airpurifier.v1")) {
                                    if (!WifiSetting.this.O00000Oo.equals("zhimi.airpurifier.v2")) {
                                    }
                                }
                                if (str == null) {
                                }
                            }
                            str = "http://v.youku.com/v_show/id_XODU2NDA2OTIw.html​";
                            if (str == null) {
                            }
                        }
                    }
                    str = null;
                    if (str == null) {
                    }
                }
                str = "http://v.youku.com/v_show/id_XODU2NDA2MjA0.html";
                if (str == null) {
                }
            }
        });
        findViewById(R.id.finish_error_btn_container).setVisibility(0);
        findViewById(R.id.finish_success_btn).setVisibility(8);
        findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass27 */

            public final void onClick(View view) {
                WifiSetting.this.O000000o(false);
            }
        });
        findViewById(R.id.retry_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass2 */

            public final void onClick(View view) {
                WifiSetting.this.switchToSecondStep();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (this.mDeviceCount > 0) {
            this.mSubMainTitleView.setText((int) R.string.kuailian_sub_main_device_count);
            this.mSubMainTitleView.setOnClickListener(null);
            TextView textView = (TextView) findViewById(R.id.finish_title);
            textView.setVisibility(0);
            Resources resources = getResources();
            int i = this.mDeviceCount;
            SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(resources.getQuantityString(R.plurals.kuailian_sub_main_device_finish, i, Integer.valueOf(i)));
            valueOf.setSpan(new ClickableSpan() {
                /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass3 */

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(WifiSetting.this.getResources().getColor(R.color.mj_color_white_60_transparent));
                    textPaint.setUnderlineText(true);
                }

                public final void onClick(View view) {
                    WifiSetting.this.O000000o(false);
                }
            }, 0, valueOf.length(), 33);
            textView.setHighlightColor(0);
            textView.setText(valueOf);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void checkConfirmEnabled() {
        if (this.mPosition != -1 && this.mState == State.INPUT && (this.O00000oO.getVisibility() == 8 || this.mPasswordEditorAbove.getVisibility() == 0 || !TextUtils.isEmpty(this.mPasswordEditor.getText().toString()))) {
            this.mBtnProgressView.setEnabled(true);
        } else {
            this.mBtnProgressView.setEnabled(false);
        }
    }

    public void checkShowPassword(ScanResult scanResult) {
        if (scanResult == null) {
            this.O00000oO.setVisibility(8);
            this.O00000o.setVisibility(8);
        } else if (getSecurity(scanResult) == 0) {
            this.O00000oO.setVisibility(8);
            this.O00000o.setVisibility(8);
        } else {
            gwj.O000000o O000000o2 = gfq.O000000o().O000000o(scanResult.BSSID);
            if (O000000o2 != null && !TextUtils.isEmpty(O000000o2.O00000o)) {
                this.mPasswd = O000000o2.O00000o;
                O00000Oo(false);
            } else if (this.O00000oo) {
                String str = scanResult.SSID;
                WifiConfiguration wifiConfiguration = null;
                Iterator<WifiConfiguration> it = this.mWifiManager.getConfiguredNetworks().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WifiConfiguration next = it.next();
                    if (next.SSID.equalsIgnoreCase(O000000o(str))) {
                        wifiConfiguration = next;
                        break;
                    }
                }
                if (!(wifiConfiguration != null)) {
                    O00000Oo(true);
                } else {
                    O00000Oo(false);
                }
            } else {
                O00000Oo(true);
            }
        }
    }

    private void O00000Oo(boolean z) {
        this.O00000oO.setVisibility(0);
        this.O00000o.setVisibility(0);
        this.mIsShowPasswd = z;
        if (!z) {
            this.mPasswordEditorAbove.setText("123456");
            this.mPasswordEditorAbove.setVisibility(0);
            this.mPasswordEditor.setVisibility(8);
            this.mPasswordToggle.setEnabled(false);
            return;
        }
        this.mPasswordEditor.setVisibility(0);
        this.mPasswordEditorAbove.setVisibility(8);
        this.mPasswordToggle.setEnabled(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01f1, code lost:
        if (r7 != 2) goto L_0x02a4;
     */
    public void connectToWifi(String str) {
        ScanResult scanResult;
        WifiConfiguration wifiConfiguration;
        int i;
        boolean z;
        TKIPType tKIPType;
        boolean z2;
        String str2 = str;
        InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        this.mState = State.CONNECTTING;
        this.mPasswordEditor.setEnabled(false);
        this.mWifiChooser.setEnabled(false);
        findViewById(R.id.wifi_ssid_toggle).setEnabled(false);
        this.mBtnProgressView.setEnabled(false);
        this.mBtnProgressView.O00000Oo();
        this.mPasswordToggle.setEnabled(false);
        if (this.mChooseUnconnWifi) {
            scanResult = this.mUnconnectResult.get(this.mPosition).f9548O000000o;
        } else {
            scanResult = this.mScanResult.get(this.mPosition).f9548O000000o;
        }
        if (!this.mWifiManager.isWifiEnabled()) {
            this.mWifiManager.setWifiEnabled(true);
            this.mState = State.RESCANNING;
            return;
        }
        if (scanResult != null) {
            SmartConfigRouterFactory.getStatPageV2Manager().reportKuailianOldResult(scanResult.SSID, "WifiSetting", "connectToWifi");
        }
        Iterator<WifiConfiguration> it = this.mWifiManager.getConfiguredNetworks().iterator();
        while (true) {
            if (!it.hasNext()) {
                wifiConfiguration = null;
                break;
            }
            wifiConfiguration = it.next();
            if (wifiConfiguration.SSID != null && wifiConfiguration.SSID.equalsIgnoreCase(O000000o(scanResult.SSID)) && getAuthType(wifiConfiguration) == getSecurity(scanResult)) {
                break;
            }
        }
        if (this.mWifiManager.getConnectionInfo() == null || this.mWifiManager.getConnectionInfo().getBSSID() == null) {
            i = -1;
        } else {
            i = -1;
            for (int i2 = 0; i2 < this.m5GScanResult.size(); i2++) {
                if (this.mWifiManager.getConnectionInfo().getBSSID().equalsIgnoreCase(this.m5GScanResult.get(i2).f9548O000000o.BSSID)) {
                    i = i2;
                }
            }
        }
        if (wifiConfiguration != null) {
            WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
            if (connectionInfo != null && O000000o(connectionInfo.getSSID(), scanResult.SSID) && connectionInfo.getNetworkId() != -1) {
                saveWifiItem();
                this.mHandler.removeMessages(103);
                switchToNetworkTestStep();
                return;
            } else if (Build.VERSION.SDK_INT > 10) {
                try {
                    Class<?> cls = Class.forName(WifiManager.class.getName());
                    gsy.O000000o(4, "111", "class3:" + cls.getName());
                    Method[] methods = cls.getMethods();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= methods.length) {
                            z2 = false;
                            break;
                        } else if ((methods[i3].getName().equalsIgnoreCase("connect") || methods[i3].getName().equalsIgnoreCase("connectNetwork")) && methods[i3].getParameterTypes()[0].getName().equals("int")) {
                            z2 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (z2) {
                        methods[i3].setAccessible(true);
                        if (methods[i3].getName().equalsIgnoreCase("connect")) {
                            methods[i3].invoke(this.mWifiManager, Integer.valueOf(wifiConfiguration.networkId), null);
                        } else {
                            methods[i3].invoke(this.mWifiManager, Integer.valueOf(wifiConfiguration.networkId));
                        }
                    }
                } catch (Exception unused) {
                }
            } else {
                this.mWifiManager.enableNetwork(wifiConfiguration.networkId, true);
            }
        } else {
            WifiConfiguration wifiConfiguration2 = new WifiConfiguration();
            int security = getSecurity(scanResult);
            wifiConfiguration2.SSID = O000000o(scanResult.SSID);
            if (security != 0) {
                if (security == 1) {
                    wifiConfiguration2.hiddenSSID = true;
                    String[] strArr = wifiConfiguration2.wepKeys;
                    strArr[0] = jdn.f1779O000000o + str2 + jdn.f1779O000000o;
                    wifiConfiguration2.allowedAuthAlgorithms.set(1);
                    wifiConfiguration2.allowedGroupCiphers.set(3);
                    wifiConfiguration2.allowedGroupCiphers.set(2);
                    wifiConfiguration2.allowedGroupCiphers.set(0);
                    wifiConfiguration2.allowedGroupCiphers.set(1);
                    wifiConfiguration2.allowedKeyManagement.set(0);
                    wifiConfiguration2.wepTxKeyIndex = 0;
                }
                wifiConfiguration2.preSharedKey = jdn.f1779O000000o + str2 + jdn.f1779O000000o;
                wifiConfiguration2.allowedKeyManagement.set(1);
                boolean contains = scanResult.capabilities.contains("TKIP");
                boolean contains2 = scanResult.capabilities.contains("CCMP");
                if (contains && contains2) {
                    tKIPType = TKIPType.TKIP_CCMP;
                } else if (contains) {
                    tKIPType = TKIPType.TKIP;
                } else if (contains2) {
                    tKIPType = TKIPType.CCMP;
                } else {
                    tKIPType = TKIPType.NONE;
                }
                if (tKIPType == TKIPType.TKIP_CCMP) {
                    wifiConfiguration2.allowedGroupCiphers.set(3);
                    wifiConfiguration2.allowedGroupCiphers.set(2);
                    wifiConfiguration2.allowedPairwiseCiphers.set(2);
                    wifiConfiguration2.allowedPairwiseCiphers.set(1);
                } else if (tKIPType == TKIPType.TKIP) {
                    wifiConfiguration2.allowedGroupCiphers.set(2);
                    wifiConfiguration2.allowedPairwiseCiphers.set(1);
                } else if (tKIPType == TKIPType.CCMP) {
                    wifiConfiguration2.allowedGroupCiphers.set(3);
                    wifiConfiguration2.allowedPairwiseCiphers.set(2);
                }
                wifiConfiguration2.status = 0;
            } else {
                wifiConfiguration2.allowedKeyManagement.set(0);
            }
            int addNetwork = this.mWifiManager.addNetwork(wifiConfiguration2);
            Class<?> cls2 = Class.forName(WifiManager.class.getName());
            gsy.O000000o(4, "111", "class3:" + cls2.getName());
            Method[] methods2 = cls2.getMethods();
            int i4 = 0;
            while (true) {
                if (i4 >= methods2.length) {
                    z = false;
                    break;
                } else if ((methods2[i4].getName().equalsIgnoreCase("connect") || methods2[i4].getName().equalsIgnoreCase("connectNetwork")) && methods2[i4].getParameterTypes()[0].getName().equals("int")) {
                    z = true;
                    break;
                } else {
                    i4++;
                }
            }
            if (z) {
                methods2[i4].setAccessible(true);
                if (methods2[i4].getName().equalsIgnoreCase("connect")) {
                    methods2[i4].invoke(this.mWifiManager, Integer.valueOf(addNetwork), null);
                } else {
                    methods2[i4].invoke(this.mWifiManager, Integer.valueOf(addNetwork));
                }
            }
        }
        if (i != -1) {
            this.mLastNetwork = this.mWifiManager.getConnectionInfo().getNetworkId();
        }
        this.mHandler.sendEmptyMessageDelayed(103, 40000);
    }

    public static void setSocketNetworkInterface(DatagramSocket datagramSocket, NetworkInterface networkInterface) {
        boolean z;
        try {
            Method[] methods = Class.forName(DatagramSocket.class.getName()).getMethods();
            int i = 0;
            while (true) {
                if (i >= methods.length) {
                    z = false;
                    break;
                } else if (methods[i].getName().equalsIgnoreCase("setNetworkInterface")) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                methods[i].setAccessible(true);
                if (methods[i].getName().equalsIgnoreCase("setNetworkInterface")) {
                    methods[i].invoke(datagramSocket, networkInterface);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void saveWifiItem() {
        ScanResult scanResult;
        if (this.mChooseUnconnWifi) {
            scanResult = this.mUnconnectResult.get(this.mPosition).f9548O000000o;
        } else {
            scanResult = this.mScanResult.get(this.mPosition).f9548O000000o;
        }
        gwj.O000000o o000000o = new gwj.O000000o();
        o000000o.O00000oO = scanResult.BSSID;
        if (o000000o.O00000oO == null) {
            o000000o.O00000oO = "";
        }
        o000000o.O00000o0 = scanResult.SSID;
        o000000o.O00000oo = scanResult.capabilities;
        o000000o.O00000o = this.mPasswd;
        o000000o.O00000Oo = true;
        o000000o.f18408O000000o = this.mWifiManager.getConnectionInfo().getNetworkId();
        gfq.O000000o().O000000o(o000000o);
    }

    public static int getSecurity(ScanResult scanResult) {
        if (scanResult.capabilities.contains("WEP")) {
            return 1;
        }
        if (scanResult.capabilities.contains("PSK")) {
            return 2;
        }
        if (scanResult.capabilities.contains("EAP")) {
            return 3;
        }
        return scanResult.capabilities.contains("WAPI") ? 4 : 0;
    }

    private static String O000000o(String str) {
        return jdn.f1779O000000o + str + jdn.f1779O000000o;
    }

    static boolean O000000o(String str, String str2) {
        if (str.startsWith(jdn.f1779O000000o)) {
            str = str.substring(1, str.length() - 1);
        }
        if (str2.startsWith(jdn.f1779O000000o)) {
            str2 = str2.substring(1, str2.length() - 1);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static void startConnectWifi() {
        if (Build.VERSION.SDK_INT > 10) {
            try {
                Class<?> cls = Class.forName(WifiManager.class.getName());
                gsy.O000000o(4, "111", "class3:" + cls.getName());
                Method[] methods = cls.getMethods();
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= methods.length) {
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
                }
            } catch (Exception unused) {
            }
        }
    }

    public String long2Ip(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    public String getGatewayAddr() {
        return long2Ip((long) ((WifiManager) getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
    }

    public void startConnectionAsso() {
        getApplicationContext().getSystemService("wifi");
        setMiioRouter("renqiao", "12345678");
    }

    public void setMiioRouter(String str, String str2) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "miIO.config_router");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ssid", str);
            jSONObject2.put("passwd", str2);
            jSONObject.put("params", jSONObject2);
        } catch (JSONException unused) {
        }
        MiioLocalAPI.O000000o(getGatewayAddr(), new dxe() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass14 */

            public final void onResponse(String str) {
                htq.O000000o();
                htq.O00000o0(str, new hua<JSONObject, hud>() {
                    /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass14.AnonymousClass1 */

                    public final void O000000o(hud hud) {
                    }

                    public final /* synthetic */ void O000000o(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        String optString = jSONObject.optString("did");
                        MiioLocalAPI.O000000o(WifiSetting.this.getGatewayAddr(), jSONObject.toString(), Long.valueOf(optString).longValue(), jSONObject.optString("token"), new dxe() {
                            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass14.AnonymousClass1.AnonymousClass1 */

                            public final void onResponse(String str) {
                            }
                        });
                    }
                });
            }
        }, 9);
    }

    public void getConnectionState() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "miIO.wifi_assoc_state");
            new JSONObject();
            jSONObject.put("params", "");
        } catch (JSONException unused) {
        }
        MiioLocalAPI.O00000Oo(getGatewayAddr(), jSONObject.toString(), new dxe() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass15 */

            public final void onResponse(String str) {
            }
        });
    }

    public void stopConnection() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "miIO.stop_diag_mode");
            new JSONObject();
            jSONObject.put("params", "");
        } catch (JSONException unused) {
        }
        MiioLocalAPI.O00000Oo(getGatewayAddr(), jSONObject.toString(), new dxe() {
            /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass16 */

            public final void onResponse(String str) {
            }
        });
    }

    public void startConnection() {
        WifiInfo connectionInfo;
        gwj.O000000o O000000o2;
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        if (wifiManager.isWifiEnabled() && (connectionInfo = wifiManager.getConnectionInfo()) != null && (O000000o2 = gfq.O000000o().O000000o(connectionInfo.getBSSID())) != null) {
            ScanResult scanResult = this.f9515O000000o;
            int i = 0;
            String str = "";
            if (scanResult == null) {
                try {
                    i = Integer.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()).intValue();
                } catch (Exception unused) {
                }
                if (i > 0) {
                    String str2 = O000000o2.O00000o0;
                    if (O000000o2.O00000o != null) {
                        str = O000000o2.O00000o;
                    }
                    MiioLocalAPI.O000000o(str2, str, O000000o2.O00000oO, O000000o2.O00000oo, (long) i, new dxc() {
                        /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass17 */
                    });
                } else {
                    String str3 = O000000o2.O00000o0;
                    if (O000000o2.O00000o != null) {
                        str = O000000o2.O00000o;
                    }
                    MiioLocalAPI.O000000o(str3, str, O000000o2.O00000oO, O000000o2.O00000oo, new dxc() {
                        /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass19 */
                    });
                }
            } else {
                String O0000Oo = DeviceFactory.O0000Oo(scanResult);
                try {
                    i = Integer.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()).intValue();
                } catch (Exception unused2) {
                }
                if (i > 0) {
                    String str4 = O000000o2.O00000o0;
                    if (O000000o2.O00000o != null) {
                        str = O000000o2.O00000o;
                    }
                    MiioLocalAPI.O000000o(str4, str, O000000o2.O00000oO, O000000o2.O00000oo, O0000Oo, (long) i, new dxc() {
                        /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass20 */
                    });
                } else {
                    String str5 = O000000o2.O00000o0;
                    if (O000000o2.O00000o != null) {
                        str = O000000o2.O00000o;
                    }
                    MiioLocalAPI.O000000o(str5, str, O000000o2.O00000oO, O000000o2.O00000oo, O0000Oo, new dxc() {
                        /* class com.xiaomi.smarthome.miio.WifiSetting.AnonymousClass21 */
                    });
                }
            }
            iae.O00000oo.clear();
        }
    }

    public boolean isMiwifi(ScanResult scanResult) {
        try {
            Field declaredField = Class.forName(ScanResult.class.getName()).getDeclaredField("isXiaomiRouter");
            if (declaredField != null) {
                return declaredField.getBoolean(scanResult);
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException unused) {
            return false;
        }
    }

    class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f9549O000000o;
        public ImageView O00000Oo;
        public TextView O00000o;
        public ImageView O00000o0;

        O00000o() {
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
            return WifiSetting.this.mScanResult.size();
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(WifiSetting.this).inflate((int) R.layout.kuailian_wifi_item, (ViewGroup) null);
                O00000o o00000o = new O00000o();
                o00000o.f9549O000000o = (TextView) view.findViewById(R.id.wifi_name);
                o00000o.O00000Oo = (ImageView) view.findViewById(R.id.miwif_tag);
                o00000o.O00000o = (TextView) view.findViewById(R.id.security_name);
                o00000o.O00000o0 = (ImageView) view.findViewById(R.id.wifi_signal_level);
                view.setTag(o00000o);
            }
            O00000o o00000o2 = (O00000o) view.getTag();
            o00000o2.f9549O000000o.setText(WifiSetting.this.mScanResult.get(i).f9548O000000o.SSID);
            if (WifiSetting.this.mScanResult.get(i).O00000o0) {
                o00000o2.O00000Oo.setVisibility(0);
            } else {
                o00000o2.O00000Oo.setVisibility(8);
            }
            TextView textView = o00000o2.O00000o;
            WifiSetting wifiSetting = WifiSetting.this;
            textView.setText(wifiSetting.O000000o(wifiSetting.mScanResult.get(i)));
            ImageView imageView = o00000o2.O00000o0;
            WifiSetting wifiSetting2 = WifiSetting.this;
            imageView.setImageResource(wifiSetting2.getSignalLevel(WifiSetting.calculateSignalLevel(wifiSetting2.mScanResult.get(i).f9548O000000o.level, 100)));
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.WifiSetting.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    if (WifiSetting.this.mPosition != i) {
                        WifiSetting.this.mPasswordEditor.setText("");
                    }
                    WifiSetting.this.mPosition = i;
                    WifiSetting.this.mWifiChooser.setText(WifiSetting.this.mScanResult.get(i).f9548O000000o.SSID);
                    WifiSetting.this.checkShowPassword(WifiSetting.this.mScanResult.get(WifiSetting.this.mPosition).f9548O000000o);
                    WifiSetting.this.checkConfirmEnabled();
                    WifiSetting.this.mChooseUnconnWifi = false;
                    WifiSetting.this.O00000o0();
                }
            });
            return view;
        }
    }

    class O00000o0 extends BaseAdapter {
        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        O00000o0() {
        }

        public final int getCount() {
            return WifiSetting.this.mUnconnectResult.size();
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(WifiSetting.this).inflate((int) R.layout.kuailian_wifi_item, (ViewGroup) null);
                O00000o o00000o = new O00000o();
                o00000o.f9549O000000o = (TextView) view.findViewById(R.id.wifi_name);
                o00000o.O00000Oo = (ImageView) view.findViewById(R.id.miwif_tag);
                o00000o.O00000o = (TextView) view.findViewById(R.id.security_name);
                o00000o.O00000o0 = (ImageView) view.findViewById(R.id.wifi_signal_level);
                view.setTag(o00000o);
            }
            O00000o o00000o2 = (O00000o) view.getTag();
            o00000o2.f9549O000000o.setText(WifiSetting.this.mUnconnectResult.get(i).f9548O000000o.SSID);
            o00000o2.f9549O000000o.setTextColor(WifiSetting.this.getResources().getColor(R.color.mj_color_gray_lighter));
            if (WifiSetting.this.mUnconnectResult.get(i).O00000o0) {
                o00000o2.O00000Oo.setVisibility(0);
            } else {
                o00000o2.O00000Oo.setVisibility(8);
            }
            ImageView imageView = o00000o2.O00000o0;
            WifiSetting wifiSetting = WifiSetting.this;
            imageView.setImageResource(wifiSetting.getSignalLevel(WifiSetting.calculateSignalLevel(wifiSetting.mUnconnectResult.get(i).f9548O000000o.level, 100)));
            TextView textView = o00000o2.O00000o;
            WifiSetting wifiSetting2 = WifiSetting.this;
            textView.setText(wifiSetting2.O000000o(wifiSetting2.mUnconnectResult.get(i)));
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.WifiSetting.O00000o0.AnonymousClass1 */

                public final void onClick(View view) {
                    ScanResult scanResult = WifiSetting.this.mUnconnectResult.get(i).f9548O000000o;
                    if (scanResult.frequency > 5000 || scanResult.capabilities.contains("WEP") || scanResult.capabilities.contains("EAP") || scanResult.capabilities.contains("WAPI-KEY") || scanResult.capabilities.contains("WAPI-PSK") || scanResult.capabilities.contains("WAPI-CERT") || scanResult.level == 0 || DeviceFactory.O00000oo(scanResult)) {
                        new MLAlertDialog.Builder(WifiSetting.this).O00000Oo((int) R.string.kuailian_unconn_reason).O000000o((int) R.string.confirm_button, (DialogInterface.OnClickListener) null).O00000oo();
                    } else if (WifiSetting.getSecurity(WifiSetting.this.mUnconnectResult.get(i).f9548O000000o) == 0) {
                        new MLAlertDialog.Builder(WifiSetting.this).O000000o((int) R.string.kuailian_unsafe_wifi).O00000Oo((int) R.string.kuailian_unsafe_wifi_content).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.miio.WifiSetting.O00000o0.AnonymousClass1.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (WifiSetting.this.mPosition != i) {
                                    WifiSetting.this.mPasswordEditor.setText("");
                                }
                                WifiSetting.this.mPosition = i;
                                WifiSetting.this.mWifiChooser.setText(WifiSetting.this.mUnconnectResult.get(i).f9548O000000o.SSID);
                                WifiSetting.this.checkShowPassword(WifiSetting.this.mUnconnectResult.get(WifiSetting.this.mPosition).f9548O000000o);
                                WifiSetting.this.checkConfirmEnabled();
                                WifiSetting.this.O00000o0();
                                WifiSetting.this.mChooseUnconnWifi = true;
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.miio.WifiSetting.O00000o0.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).O00000oo();
                    } else {
                        new MLAlertDialog.Builder(WifiSetting.this).O000000o((int) R.string.kuailian_unsafe_wifi).O00000Oo((int) R.string.kuailian_unsafe_wifi_content_1).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.miio.WifiSetting.O00000o0.AnonymousClass1.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (WifiSetting.this.mPosition != i) {
                                    WifiSetting.this.mPasswordEditor.setText("");
                                }
                                WifiSetting.this.mPosition = i;
                                WifiSetting.this.mWifiChooser.setText(WifiSetting.this.mUnconnectResult.get(i).f9548O000000o.SSID);
                                WifiSetting.this.checkShowPassword(WifiSetting.this.mUnconnectResult.get(WifiSetting.this.mPosition).f9548O000000o);
                                WifiSetting.this.checkConfirmEnabled();
                                WifiSetting.this.O00000o0();
                                WifiSetting.this.mChooseUnconnWifi = true;
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.miio.WifiSetting.O00000o0.AnonymousClass1.AnonymousClass3 */

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

    /* access modifiers changed from: package-private */
    public final String O000000o(O00000Oo o00000Oo) {
        PskType pskType;
        int security = getSecurity(o00000Oo.f9548O000000o);
        String str = "";
        if (o00000Oo.O00000Oo && security != 0) {
            str = str + getString(R.string.kuailian_save_passwd) + "，";
        }
        if (security == 0) {
            return str + getString(R.string.kuailian_no_passwd);
        } else if (security == 2) {
            ScanResult scanResult = o00000Oo.f9548O000000o;
            boolean contains = scanResult.capabilities.contains("WPA-PSK");
            boolean contains2 = scanResult.capabilities.contains("WPA2-PSK");
            if (contains2 && contains) {
                pskType = PskType.WPA_WPA2;
            } else if (contains2) {
                pskType = PskType.WPA2;
            } else if (contains) {
                pskType = PskType.WPA;
            } else {
                pskType = PskType.UNKNOWN;
            }
            if (pskType == PskType.WPA) {
                return str + String.format(getString(R.string.kuailian_wifi_security_type), "WPA");
            } else if (pskType == PskType.WPA2) {
                return str + String.format(getString(R.string.kuailian_wifi_security_type), "WPA2");
            } else if (pskType != PskType.WPA_WPA2) {
                return str;
            } else {
                return str + String.format(getString(R.string.kuailian_wifi_security_type), "WPA_WPA2");
            }
        } else if (security == 1) {
            return str + String.format(getString(R.string.kuailian_wifi_security_type), "WEP");
        } else if (security == 3) {
            return str + String.format(getString(R.string.kuailian_wifi_security_type), "802.1X");
        } else if (security != 4) {
            return str;
        } else {
            return str + String.format(getString(R.string.kuailian_wifi_security_type), "WAPI");
        }
    }

    public int getAuthType(WifiConfiguration wifiConfiguration) {
        return wifiConfiguration.allowedKeyManagement.get(1) ? 2 : 0;
    }

    public void onDeviceConnectionSuccessBind() {
        switchToPage(3, false);
        this.mMainTitleView.setText(String.format(getString(R.string.kuailian_main_title_4), new Object[0]));
        ((AnimationDrawable) findViewById(R.id.no_device_title).getBackground()).start();
        this.mSubMainTitleView.setText((int) R.string.kuailian_sub_main_title_4);
        BtnAndProgressView btnAndProgressView = this.mBtnProgressView;
        btnAndProgressView.O00000o = 0;
        btnAndProgressView.O00000Oo = System.currentTimeMillis();
        btnAndProgressView.f9143O000000o = false;
        btnAndProgressView.O00000o0 = 4;
        if (!btnAndProgressView.O00000oO.hasMessages(10)) {
            btnAndProgressView.O00000oO.sendEmptyMessage(10);
        }
    }
}

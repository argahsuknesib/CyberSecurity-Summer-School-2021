package com.xiaomi.smarthome.smartconfig.step;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fmw;
import _m_j.gfq;
import _m_j.gnn;
import _m_j.gor;
import _m_j.gri;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.gwj;
import _m_j.htr;
import _m_j.hvd;
import _m_j.hze;
import _m_j.iag;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Message;
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
import android.view.animation.Animation;
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
import butterknife.BindView;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshLinearLayout;
import com.xiaomi.smarthome.library.common.widget.ResizeLayout;
import com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Deprecated
public class ChooseWifiStep extends SmartConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f11656O000000o = 200;
    public BaseAdapter O00000Oo = new O000000o();
    public WifiManager O00000o;
    public BaseAdapter O00000o0 = new O00000Oo();
    public ScanResult O00000oO;
    public List<iag.O000000o> O00000oo = new ArrayList();
    public List<iag.O000000o> O0000O0o = new ArrayList();
    public List<iag.O000000o> O0000OOo = new ArrayList();
    public boolean O0000Oo = false;
    public boolean O0000Oo0 = false;
    public boolean O0000OoO;
    private boolean O0000Ooo = false;
    @BindView(6293)
    CheckBox mCheckbox;
    @BindView(6363)
    ListView mConnectList;
    @BindView(6643)
    ImageView mDeviceIcon;
    @BindView(6925)
    TextView mDeviceInfo;
    @BindView(6290)
    CheckBox mLicenseCheckBox;
    @BindView(6098)
    TextView mLicenseTv;
    @BindView(6986)
    Button mNextBtn;
    @BindView(7808)
    EditText mPasswordEditor;
    @BindView(7809)
    EditText mPasswordEditorAbove;
    @BindView(7810)
    TextView mPasswordToggle;
    @BindView(6311)
    ResizeLayout mResizeLayout;
    @BindView(6920)
    View mReturnBtn;
    @BindView(7812)
    CustomPullDownRefreshLinearLayout mScanResultList;
    @BindView(7304)
    View mScanWifi;
    @BindView(7805)
    ScrollView mScrollWifiList;
    @BindView(7816)
    ImageView mShowScanResultToggle;
    @BindView(7517)
    View mTitleBar;
    @BindView(6310)
    View mTopContainer;
    @BindView(7554)
    View mTopMask;
    @BindView(7429)
    View mTvSubDesc;
    @BindView(7678)
    ListView mUnConnectList;
    @BindView(6835)
    TextView mWifiChooser;
    @BindView(7813)
    View mWifiPassContainer;

    public final void H_() {
    }

    public final void I_() {
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_CHOOSE_WIFI;
    }

    public final void O000000o(Message message) {
        int i = message.what;
        if (i == 100 || i == 104) {
            x_().removeMessages(100);
            x_().removeMessages(104);
            if (this.O0000Oo0) {
                this.O0000Oo0 = false;
                final ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                final ArrayList arrayList3 = new ArrayList();
                gor.O000000o(new AsyncTask<Void, Void, ScanResult>() {
                    /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ void onPostExecute(Object obj) {
                        ScanResult scanResult = (ScanResult) obj;
                        if (!ChooseWifiStep.this.O000OO00) {
                            ChooseWifiStep.this.O00000oo.clear();
                            ChooseWifiStep.this.O00000oo.addAll(arrayList);
                            ChooseWifiStep.this.O0000O0o.clear();
                            ChooseWifiStep.this.O0000O0o.addAll(arrayList2);
                            ChooseWifiStep.this.O0000OOo.clear();
                            ChooseWifiStep.this.O0000OOo.addAll(arrayList3);
                            if (!ChooseWifiStep.this.O00000Oo()) {
                                ChooseWifiStep chooseWifiStep = ChooseWifiStep.this;
                                chooseWifiStep.O00000oO = scanResult;
                                if (chooseWifiStep.O00000oO == null) {
                                    ChooseWifiStep.this.mWifiChooser.setText((int) R.string.click_to_choose_wlan);
                                } else {
                                    ChooseWifiStep.this.mWifiChooser.setText(ChooseWifiStep.this.O00000oO.SSID);
                                }
                                ChooseWifiStep.this.mScanWifi.setVisibility(8);
                                ChooseWifiStep chooseWifiStep2 = ChooseWifiStep.this;
                                chooseWifiStep2.O0000Oo0 = false;
                                if (chooseWifiStep2.O00000oO != null && !fmw.O000000o().O000000o(ChooseWifiStep.this.O00000oO.BSSID)) {
                                    htr.O000000o().O00000Oo("miui_class");
                                }
                                ChooseWifiStep chooseWifiStep3 = ChooseWifiStep.this;
                                chooseWifiStep3.O000000o(chooseWifiStep3.O00000oO);
                                ChooseWifiStep.this.O00000o();
                                ChooseWifiStep.this.mPasswordEditor.setEnabled(true);
                                ChooseWifiStep.this.mWifiChooser.setEnabled(true);
                                ChooseWifiStep.this.mShowScanResultToggle.setEnabled(true);
                                ChooseWifiStep.this.O00000Oo.notifyDataSetChanged();
                                ChooseWifiStep.this.O00000o0.notifyDataSetChanged();
                                ChooseWifiStep.this.mScanResultList.O00000Oo();
                            }
                        }
                    }

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        boolean z;
                        WifiInfo connectionInfo = ChooseWifiStep.this.O00000o.getConnectionInfo();
                        List<ScanResult> scanResults = ChooseWifiStep.this.O00000o.getScanResults();
                        if (scanResults == null) {
                            return null;
                        }
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        int i = 0;
                        String str = null;
                        int i2 = 0;
                        while (true) {
                            z = true;
                            if (i2 >= scanResults.size()) {
                                break;
                            }
                            if (!TextUtils.isEmpty(scanResults.get(i2).SSID) && !DeviceFactory.O0000OOo(scanResults.get(i2))) {
                                boolean O00000o02 = iag.O00000o0(scanResults.get(i2));
                                boolean z2 = gfq.O000000o().O000000o(scanResults.get(i2).BSSID) != null;
                                if (!z2) {
                                    z2 = iag.O000000o(ChooseWifiStep.this.O00000o, scanResults.get(i2).SSID) && htr.O000000o().O000000o("miui_class") != null;
                                }
                                if (connectionInfo != null && iag.O000000o(connectionInfo.getSSID(), scanResults.get(i2).SSID) && O00000o02 && scanResults.get(i2).frequency > 5000) {
                                    String[] split = scanResults.get(i2).BSSID.split("\\:");
                                    str = String.format("%1$s:%2$s:%3$s:%4$s:%5$s:%6$x", split[0], split[1], split[2], split[3], split[4], Integer.valueOf(Integer.valueOf(split[5], 16).intValue() - 1));
                                }
                                if ((scanResults.get(i2).frequency <= 5000 || ChooseWifiStep.this.O0000Oo) && !scanResults.get(i2).capabilities.contains("WEP") && !scanResults.get(i2).capabilities.contains("EAP") && !scanResults.get(i2).capabilities.contains("WAPI-KEY") && !scanResults.get(i2).capabilities.contains("WAPI-PSK") && !scanResults.get(i2).capabilities.contains("WAPI-CERT") && iag.O00000Oo(scanResults.get(i2)) != 0 && scanResults.get(i2).level != 0 && !iag.O00000o0(scanResults.get(i2).SSID)) {
                                    iag.O000000o o000000o = new iag.O000000o();
                                    o000000o.O00000o0 = O00000o02;
                                    o000000o.O00000Oo = z2;
                                    o000000o.f1089O000000o = scanResults.get(i2);
                                    if (!hashMap.containsKey(scanResults.get(i2).SSID)) {
                                        arrayList.add(o000000o);
                                        hashMap.put(scanResults.get(i2).SSID, o000000o);
                                    } else if (iag.O00000Oo(scanResults.get(i2).level) > iag.O00000Oo(((iag.O000000o) hashMap.get(scanResults.get(i2).SSID)).f1089O000000o.level)) {
                                        iag.O000000o o000000o2 = (iag.O000000o) hashMap.get(scanResults.get(i2).SSID);
                                        hashMap.remove(o000000o2.f1089O000000o.SSID);
                                        hashMap.put(scanResults.get(i2).SSID, o000000o);
                                        arrayList.remove(o000000o2);
                                        arrayList3.remove(o000000o2);
                                        arrayList3.add(o000000o);
                                    }
                                } else {
                                    iag.O000000o o000000o3 = new iag.O000000o();
                                    o000000o3.O00000o0 = O00000o02;
                                    o000000o3.O00000Oo = z2;
                                    o000000o3.f1089O000000o = scanResults.get(i2);
                                    if (scanResults.get(i2).frequency > 5000 && !ChooseWifiStep.this.O0000Oo) {
                                        arrayList2.add(o000000o3);
                                    }
                                    if (!hashMap2.containsKey(scanResults.get(i2).SSID)) {
                                        arrayList3.add(o000000o3);
                                        hashMap2.put(scanResults.get(i2).SSID, o000000o3);
                                    } else if (iag.O00000Oo(scanResults.get(i2).level) > iag.O00000Oo(((iag.O000000o) hashMap2.get(scanResults.get(i2).SSID)).f1089O000000o.level)) {
                                        iag.O000000o o000000o4 = (iag.O000000o) hashMap2.get(scanResults.get(i2).SSID);
                                        hashMap.remove(o000000o3.f1089O000000o.SSID);
                                        hashMap.put(scanResults.get(i2).SSID, o000000o3);
                                        arrayList3.remove(o000000o4);
                                        arrayList3.add(o000000o4);
                                    }
                                }
                            }
                            i2++;
                        }
                        AnonymousClass1 r0 = new Comparator<iag.O000000o>() {
                            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass1.AnonymousClass1 */

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                iag.O000000o o000000o = (iag.O000000o) obj;
                                iag.O000000o o000000o2 = (iag.O000000o) obj2;
                                if ((!o000000o.O00000Oo || !o000000o2.O00000Oo) && (o000000o.O00000Oo || o000000o2.O00000Oo)) {
                                    return o000000o.O00000Oo ? -1 : 1;
                                }
                                return o000000o.f1089O000000o.SSID.compareTo(o000000o2.f1089O000000o.SSID);
                            }
                        };
                        Collections.sort(arrayList, r0);
                        Collections.sort(arrayList3, r0);
                        if (ChooseWifiStep.this.O00000oO != null) {
                            while (i < arrayList.size() && !ChooseWifiStep.this.O00000oO.BSSID.equalsIgnoreCase(((iag.O000000o) arrayList.get(i)).f1089O000000o.BSSID)) {
                                if (str != null && ChooseWifiStep.this.O00000oO.BSSID.equalsIgnoreCase(str)) {
                                    return null;
                                }
                                i++;
                            }
                            return null;
                        }
                        String str2 = (String) htr.O000000o().O000000o("target_bssid");
                        if (!TextUtils.isEmpty(str2)) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= arrayList.size()) {
                                    break;
                                } else if (str2.equalsIgnoreCase(((iag.O000000o) arrayList.get(i3)).f1089O000000o.BSSID)) {
                                    ChooseWifiStep.this.O00000oO = ((iag.O000000o) arrayList.get(i3)).f1089O000000o;
                                    if (htr.O000000o().O000000o("target_passwd") != null) {
                                        gwj.O000000o o000000o5 = new gwj.O000000o();
                                        o000000o5.O00000oO = ChooseWifiStep.this.O00000oO.BSSID;
                                        if (o000000o5.O00000oO == null) {
                                            o000000o5.O00000oO = "";
                                        }
                                        o000000o5.O00000o0 = ChooseWifiStep.this.O00000oO.SSID;
                                        o000000o5.O00000oo = ChooseWifiStep.this.O00000oO.capabilities;
                                        o000000o5.O00000o = (String) htr.O000000o().O000000o("target_passwd");
                                        o000000o5.O00000Oo = true;
                                        gfq.O000000o().O000000o(o000000o5);
                                    }
                                } else {
                                    i3++;
                                }
                            }
                            if (!z || connectionInfo == null || connectionInfo.getBSSID() == null) {
                                return null;
                            }
                            while (i < arrayList.size()) {
                                if (connectionInfo.getBSSID().equalsIgnoreCase(((iag.O000000o) arrayList.get(i)).f1089O000000o.BSSID)) {
                                    return ((iag.O000000o) arrayList.get(i)).f1089O000000o;
                                }
                                if (str != null && ((iag.O000000o) arrayList.get(i)).f1089O000000o.BSSID.equalsIgnoreCase(str)) {
                                    return ((iag.O000000o) arrayList.get(i)).f1089O000000o;
                                }
                                i++;
                            }
                            return null;
                        }
                        z = false;
                        return !z ? null : null;
                    }
                }, new Void[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000Oo() {
        if (this.O00000oo.size() != 0) {
            return false;
        }
        if (!hze.O00000Oo(this.O000O0oo)) {
            new MLAlertDialog.Builder(this.O000O0oo).O00000Oo((int) R.string.open_location_permission).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass15 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", ChooseWifiStep.this.O000O0oo.getPackageName(), null));
                    ((SmartConfigMainActivity) ChooseWifiStep.this.O000O0oo).startActivityForResult(intent, ChooseWifiStep.f11656O000000o);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass14 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ChooseWifiStep.this.G_();
                }
            }).O000000o(false).O00000oo();
            return true;
        }
        new MLAlertDialog.Builder(this.O000O0oo).O00000Oo((int) R.string.get_wifi_scan_result_error).O000000o((int) R.string.wifi_rescan_wifi, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass13 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ChooseWifiStep chooseWifiStep = ChooseWifiStep.this;
                chooseWifiStep.mScanWifi.setVisibility(0);
                try {
                    chooseWifiStep.O00000o.startScan();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                chooseWifiStep.mPasswordEditor.setEnabled(false);
                chooseWifiStep.mWifiChooser.setEnabled(false);
                chooseWifiStep.mNextBtn.setEnabled(false);
                chooseWifiStep.mPasswordToggle.setEnabled(false);
                chooseWifiStep.O0000Oo0 = true;
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass12 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ChooseWifiStep.this.G_();
            }
        }).O000000o(false).O00000oo();
        return true;
    }

    public final void O000000o(int i, int i2, Intent intent) {
        super.O000000o(i, i2, intent);
        if (i == f11656O000000o) {
            G_();
        }
    }

    public final void O000000o(ScanResult scanResult) {
        if (scanResult == null) {
            this.mWifiPassContainer.setVisibility(8);
            this.mCheckbox.setVisibility(8);
        } else if (iag.O00000Oo(scanResult) == 0) {
            this.mWifiPassContainer.setVisibility(8);
            this.mCheckbox.setVisibility(8);
            this.mPasswordToggle.setEnabled(false);
        } else {
            gwj.O000000o O000000o2 = gfq.O000000o().O000000o(scanResult.BSSID);
            if (htr.O000000o().O000000o("miui_class") != null && iag.O000000o(this.O00000o, scanResult.SSID)) {
                O00000Oo(false);
            } else if (O000000o2 != null) {
                this.O0000OoO = true;
                O00000Oo(false);
            } else {
                O00000Oo(true);
            }
        }
    }

    public final boolean G_() {
        if (this.mScanResultList.getVisibility() == 0) {
            O0000OoO();
            return true;
        }
        SmartConfigRouterFactory.getStatPageV2Manager().page_wlan(this.O000OOOo, this.O000OO);
        b_(false);
        return true;
    }

    private void O00000Oo(boolean z) {
        this.mWifiPassContainer.setVisibility(0);
        this.mCheckbox.setVisibility(0);
        this.mCheckbox.setChecked(true);
        if (!z) {
            this.mPasswordEditorAbove.setInputType(129);
            this.mPasswordEditorAbove.setText("123456");
            this.mPasswordEditorAbove.setVisibility(0);
            this.mPasswordEditor.setVisibility(8);
            this.mPasswordToggle.setEnabled(false);
            this.mPasswordToggle.setText((int) R.string.smart_config_show_passwd);
            this.mPasswordToggle.setTextColor(this.O000O0oo.getResources().getColor(R.color.mj_color_gray_normal));
            this.mNextBtn.setEnabled(true);
        } else {
            this.mPasswordEditor.setVisibility(0);
            this.mPasswordEditorAbove.setVisibility(8);
            this.mPasswordToggle.setEnabled(true);
            this.mNextBtn.setEnabled(false);
            this.mPasswordToggle.setText((int) R.string.smart_config_hide_passwd);
            this.mPasswordToggle.setTextColor(-11371828);
            htr.O000000o().O00000Oo("miui_class");
        }
        if (!this.O0000Ooo) {
            this.O0000Ooo = true;
            fbs.O000000o(new fbt(this.O000O0oo, "BlankActivity"));
        }
    }

    public final void O00000o() {
        if (this.O00000oO == null || this.O0000Oo0 || !(this.mWifiPassContainer.getVisibility() == 8 || this.mPasswordEditorAbove.getVisibility() == 0 || !TextUtils.isEmpty(this.mPasswordEditor.getText().toString()))) {
            this.mNextBtn.setEnabled(false);
        } else {
            this.mNextBtn.setEnabled(true);
        }
    }

    public final void O000000o(Context context) {
        O000000o(context, (int) R.layout.smart_config_wifi_choose_ui);
        O000O0OO();
        SmartConfigRouterFactory.getStatPageV2Manager().page_wlan(this.O000OOOo, 0);
        gwg.O000000o((int) this.O000O0oo.getResources().getDimension(R.dimen.title_bar_top_padding), this.mTitleBar);
        this.O00000o = (WifiManager) context.getSystemService("wifi");
        this.mNextBtn.setText((int) R.string.next_button);
        this.mDeviceInfo.setText(String.format(context.getString(R.string.kuailian_main_title_2), new Object[0]));
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass16 */

            public final void onClick(View view) {
                ChooseWifiStep.this.G_();
            }
        });
        this.mResizeLayout.setResizeListener(new ResizeLayout.O000000o() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass17 */

            public final void O000000o(int i, int i2) {
                gsy.O000000o(6, "aaaa", "Resize");
            }
        });
        this.mDeviceIcon.setImageResource(R.drawable.kuailian_wifi_icon);
        this.mWifiChooser.setText("");
        this.mWifiChooser.setEnabled(false);
        this.mScanWifi.setVisibility(0);
        this.mNextBtn.setEnabled(false);
        this.mNextBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass18 */

            public final void onClick(View view) {
                if (ChooseWifiStep.this.mLicenseCheckBox.getVisibility() != 0 || ChooseWifiStep.this.mLicenseCheckBox.isChecked() || !(ChooseWifiStep.this.O000O0oo instanceof Activity)) {
                    ChooseWifiStep.this.O0000Oo0();
                    return;
                }
                MLAlertDialog.Builder O000000o2 = new MLAlertDialog.Builder((Activity) ChooseWifiStep.this.O000O0oo).O000000o(ChooseWifiStep.this.O000O0oo.getString(R.string.license_title));
                ChooseWifiStep chooseWifiStep = ChooseWifiStep.this;
                O000000o2.O000000o(chooseWifiStep.O000000o(chooseWifiStep.O000OOOo)).O00000Oo(ChooseWifiStep.this.O000O0oo.getString(R.string.license_negative_btn), (DialogInterface.OnClickListener) null).O000000o(ChooseWifiStep.this.O000O0oo.getString(R.string.license_positive_btn), new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass18.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ChooseWifiStep.this.O0000Oo0();
                    }
                }).O00000oo();
            }
        });
        this.mWifiPassContainer.setVisibility(8);
        this.mCheckbox.setVisibility(8);
        if (!gnn.O0000Oo0) {
            CheckBox checkBox = this.mCheckbox;
            checkBox.setPadding(checkBox.getPaddingLeft() + gri.O000000o(18.0f), this.mCheckbox.getPaddingTop(), this.mCheckbox.getPaddingRight(), this.mCheckbox.getPaddingBottom());
        }
        this.mPasswordEditor.setText("");
        final String str = (String) htr.O000000o().O000000o("device_model");
        if (str != null && DeviceFactory.O00000Oo(str)) {
            this.O0000Oo = true;
        }
        if (!SmartConfigRouterFactory.getSmartConfigManager().isEurope(SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingServer())) {
            this.mLicenseCheckBox.setVisibility(4);
            this.mLicenseTv.setVisibility(4);
            this.mLicenseCheckBox.setChecked(true);
        } else {
            this.mLicenseCheckBox.setChecked(false);
            this.mLicenseCheckBox.setVisibility(0);
            String string = this.O000O0oo.getString(R.string.kuailian_license);
            int indexOf = string.indexOf("#start#");
            int indexOf2 = string.indexOf("#end#") - 7;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) string.replace("#start#", "").replace("#end#", ""));
            AnonymousClass9 r0 = new ClickableSpan() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass9 */

                public final void onClick(View view) {
                    fbs.O000000o(new fbt(ChooseWifiStep.this.O000O0oo, "GDPRLicenseActivity").O000000o("key_model", str).O00000Oo(268435456));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ChooseWifiStep.this.O000O0oo.getResources().getColor(R.color.mj_color_highlight_blue_text_color));
                    textPaint.setUnderlineText(false);
                }
            };
            if (indexOf >= 0 && indexOf2 > 0) {
                try {
                    spannableStringBuilder.setSpan(r0, indexOf, indexOf2, 33);
                } catch (Exception unused) {
                }
            }
            this.mLicenseTv.setText(spannableStringBuilder);
            this.mLicenseTv.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (((Boolean) htr.O000000o().O000000o("camera_process", Boolean.FALSE)).booleanValue()) {
            this.mDeviceIcon.setVisibility(8);
            this.mTopContainer.setVisibility(0);
            this.mDeviceInfo.setText((int) R.string.kuailian_main_title_2);
            this.mNextBtn.setBackgroundResource(R.drawable.camera_refresh_bg);
            this.mNextBtn.setTextColor(-1);
            this.mCheckbox.setButtonDrawable((int) R.drawable.camera_check_icon);
        } else {
            this.mDeviceIcon.setVisibility(0);
            this.mTopContainer.setVisibility(8);
        }
        if (this.O0000Oo) {
            this.mTvSubDesc.setVisibility(0);
        } else {
            this.mTvSubDesc.setVisibility(8);
        }
        this.mPasswordEditor.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass19 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                ChooseWifiStep.this.O00000o();
                ChooseWifiStep.this.O0000OoO = false;
            }
        });
        this.mScanResultList.setScrollView(this.mScrollWifiList);
        this.mScanResultList.setRefreshListener(new CustomPullDownRefreshLinearLayout.O00000o0() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass2 */

            public final void O000000o() {
                try {
                    ChooseWifiStep.this.O00000o.startScan();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ChooseWifiStep.this.O0000Oo0 = true;
            }
        });
        this.mWifiChooser.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass3 */

            public final void onClick(View view) {
                SmartConfigRouterFactory.getStatClickManager().kuaiLianClick("adddevice_wlan_click.AP", ChooseWifiStep.this.O000OOOo);
                ChooseWifiStep.this.mPasswordEditorAbove.clearFocus();
                ChooseWifiStep.this.O0000Oo();
            }
        });
        this.mPasswordToggle.setEnabled(false);
        this.mPasswordToggle.setSelected(true);
        this.mPasswordToggle.setText((int) R.string.smart_config_hide_passwd);
        this.mPasswordToggle.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass4 */

            public final void onClick(View view) {
                int selectionStart = ChooseWifiStep.this.mPasswordEditor.getSelectionStart();
                if (!ChooseWifiStep.this.mPasswordToggle.isSelected()) {
                    ChooseWifiStep.this.mPasswordEditor.setInputType(144);
                    ChooseWifiStep.this.mPasswordToggle.setSelected(true);
                    ChooseWifiStep.this.mPasswordToggle.setText((int) R.string.smart_config_hide_passwd);
                } else {
                    ChooseWifiStep.this.mPasswordEditor.setInputType(129);
                    ChooseWifiStep.this.mPasswordToggle.setSelected(false);
                    ChooseWifiStep.this.mPasswordToggle.setText((int) R.string.smart_config_show_passwd);
                }
                ChooseWifiStep.this.mPasswordEditor.setSelection(selectionStart);
            }
        });
        this.mPasswordEditorAbove.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass5 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                new MLAlertDialog.Builder(ChooseWifiStep.this.O000O0oo).O00000Oo((int) R.string.smart_config_reinput_wifi_passwd).O000000o((int) R.string.smart_config_reinput, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass5.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ChooseWifiStep.this.mPasswordEditor.setVisibility(0);
                        ChooseWifiStep.this.mPasswordEditorAbove.setVisibility(8);
                        ChooseWifiStep.this.mPasswordEditor.requestFocus();
                        ChooseWifiStep.this.mPasswordToggle.setEnabled(true);
                        ChooseWifiStep.this.mPasswordToggle.setTextColor(-11371828);
                        ChooseWifiStep.this.mPasswordToggle.setText((int) R.string.smart_config_hide_passwd);
                        htr.O000000o().O00000Oo("miui_class");
                        dialogInterface.dismiss();
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass5.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).O00000o().show();
                return true;
            }
        });
        this.mShowScanResultToggle.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass6 */

            public final void onClick(View view) {
                ChooseWifiStep.this.O0000Oo();
                ChooseWifiStep chooseWifiStep = ChooseWifiStep.this;
                chooseWifiStep.O00000Oo = new O000000o();
                ChooseWifiStep.this.mConnectList.setAdapter((ListAdapter) ChooseWifiStep.this.O00000Oo);
                ChooseWifiStep chooseWifiStep2 = ChooseWifiStep.this;
                chooseWifiStep2.O00000o0 = new O00000Oo();
                ChooseWifiStep.this.mUnConnectList.setAdapter((ListAdapter) ChooseWifiStep.this.O00000o0);
            }
        });
        this.mShowScanResultToggle.setEnabled(false);
        this.O00000Oo = new O000000o();
        this.mConnectList.setAdapter((ListAdapter) this.O00000Oo);
        this.O00000o0 = new O00000Oo();
        this.mUnConnectList.setAdapter((ListAdapter) this.O00000o0);
        if (!O0000Ooo()) {
            new MLAlertDialog.Builder(this.O000O0oo).O00000Oo((int) R.string.open_wifi_failed).O000000o(false).O00000Oo((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ChooseWifiStep.this.G_();
                }
            }).O000000o(false).O00000oo();
        }
    }

    public final void O0000Oo0() {
        hvd statClickManager = SmartConfigRouterFactory.getStatClickManager();
        String str = this.O000OOOo;
        int i = 1;
        int i2 = this.O0000OoO ? 1 : 2;
        if (this.mPasswordToggle.getText().equals(this.O000O0oo.getString(R.string.smart_config_hide_passwd))) {
            i = 2;
        }
        statClickManager.adddevice_wlan_next_AP(str, i2, i);
        SmartConfigRouterFactory.getStatPageV2Manager().page_wlan(this.O000OOOo, this.O000OO);
        InputMethodManager inputMethodManager = (InputMethodManager) this.O000O0oo.getSystemService("input_method");
        if (inputMethodManager.isActive() && (this.O000O0oo instanceof Activity) && ((Activity) this.O000O0oo).getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(((Activity) this.O000O0oo).getCurrentFocus().getWindowToken(), 2);
        }
        String obj = this.mPasswordEditor.getText().toString();
        if (iag.O00000Oo(this.O00000oO) == 0) {
            O00000Oo("");
        }
        if (!TextUtils.isEmpty(obj) && this.mCheckbox.isChecked()) {
            O00000Oo(obj);
        }
        htr.O000000o().O00000Oo("selected_ap", this.O00000oO);
        htr.O000000o().O00000Oo("selected_ap_ssid", this.O00000oO.SSID);
        gwj.O000000o O000000o2 = gfq.O000000o().O000000o(this.O00000oO.BSSID);
        if (O000000o2 != null && (TextUtils.equals(O000000o2.O00000o, obj) || TextUtils.isEmpty(obj))) {
            htr.O000000o().O00000Oo("selected_ap_passwd", O000000o2.O00000o);
        } else if (!TextUtils.isEmpty(obj)) {
            htr.O000000o().O00000Oo("selected_ap_passwd", obj);
        }
        O000O0o();
    }

    public final SpannableStringBuilder O000000o(final String str) {
        String string = this.O000O0oo.getString(R.string.license_content);
        int indexOf = string.indexOf("#start#");
        int indexOf2 = string.indexOf("#end#") - 7;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string.replace("#start#", "").replace("#end#", ""));
        AnonymousClass8 r0 = new ClickableSpan() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass8 */

            public final void onClick(View view) {
                fbs.O000000o(new fbt(ChooseWifiStep.this.O000O0oo, "GDPRLicenseActivity").O000000o("key_model", str).O00000Oo(268435456));
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(ChooseWifiStep.this.O000O0oo.getResources().getColor(R.color.mj_color_highlight_blue_text_color));
                textPaint.setUnderlineText(false);
            }
        };
        if (indexOf > 0 && indexOf2 > 0) {
            try {
                spannableStringBuilder.setSpan(r0, indexOf, indexOf2, 33);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return spannableStringBuilder;
    }

    private void O00000Oo(String str) {
        gwj.O000000o o000000o = new gwj.O000000o();
        o000000o.O00000oO = this.O00000oO.BSSID;
        if (o000000o.O00000oO == null) {
            o000000o.O00000oO = "";
        }
        o000000o.O00000o0 = this.O00000oO.SSID;
        o000000o.O00000oo = this.O00000oO.capabilities;
        o000000o.O00000o = str;
        o000000o.O00000Oo = true;
        o000000o.f18408O000000o = this.O00000o.getConnectionInfo().getNetworkId();
        gfq.O000000o().O000000o(o000000o);
    }

    public final void O0000O0o() {
        if (x_() != null) {
            x_().removeMessages(104);
        }
    }

    class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f11692O000000o;
        public ImageView O00000Oo;
        public TextView O00000o;
        public ImageView O00000o0;

        O00000o0() {
        }
    }

    public final void O00000Oo(ScanResult scanResult) {
        SmartConfigRouterFactory.getStatClickManager().adddevice_network_wifi_AP(this.O000OOOo, scanResult.BSSID);
        if (this.O00000oO != scanResult) {
            this.mPasswordEditor.setText("");
        }
        this.O00000oO = scanResult;
        this.mWifiChooser.setText(this.O00000oO.SSID);
        O000000o(this.O00000oO);
        O00000o();
    }

    private boolean O0000Ooo() {
        int wifiState = this.O00000o.getWifiState();
        if (wifiState == 3) {
            try {
                this.O00000o.startScan();
                x_().sendEmptyMessageDelayed(104, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else if ((wifiState == 4 || wifiState == 1) && wifiState == 1) {
            return this.O00000o.setWifiEnabled(true);
        }
        this.O0000Oo0 = true;
        return true;
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
            return ChooseWifiStep.this.O00000oo.size();
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(ChooseWifiStep.this.O000O0oo).inflate((int) R.layout.kuailian_wifi_item, (ViewGroup) null);
                O00000o0 o00000o0 = new O00000o0();
                o00000o0.f11692O000000o = (TextView) view.findViewById(R.id.wifi_name);
                o00000o0.O00000Oo = (ImageView) view.findViewById(R.id.miwif_tag);
                o00000o0.O00000o = (TextView) view.findViewById(R.id.security_name);
                o00000o0.O00000o0 = (ImageView) view.findViewById(R.id.wifi_signal_level);
                view.setTag(o00000o0);
            }
            O00000o0 o00000o02 = (O00000o0) view.getTag();
            o00000o02.f11692O000000o.setText(ChooseWifiStep.this.O00000oo.get(i).f1089O000000o.SSID);
            if (ChooseWifiStep.this.O00000oo.get(i).O00000o0) {
                o00000o02.O00000Oo.setVisibility(0);
            } else {
                o00000o02.O00000Oo.setVisibility(8);
            }
            o00000o02.O00000o.setText(iag.O000000o(ChooseWifiStep.this.O000O0oo, ChooseWifiStep.this.O00000oo.get(i)));
            o00000o02.O00000o0.setImageResource(iag.O000000o(iag.O00000Oo(ChooseWifiStep.this.O00000oo.get(i).f1089O000000o.level)));
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    if (i < ChooseWifiStep.this.O00000oo.size()) {
                        String str = (String) htr.O000000o().O000000o("target_bssid");
                        if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(ChooseWifiStep.this.O00000oo.get(i).f1089O000000o.BSSID)) {
                            new MLAlertDialog.Builder(ChooseWifiStep.this.O000O0oo).O00000Oo((int) R.string.kuailian_conn_error_router).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.O000000o.AnonymousClass1.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ChooseWifiStep.this.O00000Oo(ChooseWifiStep.this.O00000oo.get(i).f1089O000000o);
                                    ChooseWifiStep.this.O0000OoO();
                                }
                            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.O000000o.AnonymousClass1.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).O00000oo();
                        } else if (iag.O00000Oo(ChooseWifiStep.this.O00000oo.get(i).f1089O000000o) == 0) {
                            new MLAlertDialog.Builder(ChooseWifiStep.this.O000O0oo).O000000o((int) R.string.kuailian_unsafe_wifi).O00000Oo((int) R.string.kuailian_unsafe_wifi_content).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.O000000o.AnonymousClass1.AnonymousClass4 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ChooseWifiStep.this.O00000Oo(ChooseWifiStep.this.O00000oo.get(i).f1089O000000o);
                                    htr.O000000o().O00000Oo("miui_class", null);
                                    ChooseWifiStep.this.O0000OoO();
                                }
                            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.O000000o.AnonymousClass1.AnonymousClass3 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).O00000oo();
                        } else {
                            ChooseWifiStep.this.O00000Oo(ChooseWifiStep.this.O00000oo.get(i).f1089O000000o);
                            ChooseWifiStep.this.O0000OoO();
                        }
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
            return ChooseWifiStep.this.O0000OOo.size();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(ChooseWifiStep.this.O000O0oo).inflate((int) R.layout.kuailian_wifi_item, (ViewGroup) null);
                O00000o0 o00000o0 = new O00000o0();
                o00000o0.f11692O000000o = (TextView) view.findViewById(R.id.wifi_name);
                o00000o0.O00000Oo = (ImageView) view.findViewById(R.id.miwif_tag);
                o00000o0.O00000o = (TextView) view.findViewById(R.id.security_name);
                o00000o0.O00000o0 = (ImageView) view.findViewById(R.id.wifi_signal_level);
                view.setTag(o00000o0);
            }
            O00000o0 o00000o02 = (O00000o0) view.getTag();
            final iag.O000000o o000000o = ChooseWifiStep.this.O0000OOo.get(i);
            o00000o02.f11692O000000o.setText(o000000o.f1089O000000o.SSID);
            o00000o02.f11692O000000o.setTextColor(ChooseWifiStep.this.O000O0oo.getResources().getColor(R.color.mj_color_gray_lighter));
            if (o000000o.O00000o0) {
                o00000o02.O00000Oo.setVisibility(0);
            } else {
                o00000o02.O00000Oo.setVisibility(8);
            }
            o00000o02.O00000o0.setImageResource(iag.O000000o(iag.O00000Oo(o000000o.f1089O000000o.level)));
            o00000o02.O00000o.setText(iag.O000000o(ChooseWifiStep.this.O000O0oo, ChooseWifiStep.this.O0000OOo.get(i)));
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.O00000Oo.AnonymousClass1 */

                public final void onClick(View view) {
                    ScanResult scanResult = o000000o.f1089O000000o;
                    if ((scanResult.frequency > 5000 && !ChooseWifiStep.this.O0000Oo) || scanResult.capabilities.contains("WEP") || scanResult.capabilities.contains("EAP") || scanResult.capabilities.contains("WAPI-KEY") || scanResult.capabilities.contains("WAPI-PSK") || scanResult.capabilities.contains("WAPI-CERT") || scanResult.level == 0 || DeviceFactory.O0000OOo(scanResult)) {
                        new MLAlertDialog.Builder(ChooseWifiStep.this.O000O0oo).O00000Oo((int) R.string.kuailian_unconn_reason).O000000o((int) R.string.confirm_button, (DialogInterface.OnClickListener) null).O00000oo();
                    } else if (iag.O00000o0(o000000o.f1089O000000o.SSID)) {
                        new MLAlertDialog.Builder(ChooseWifiStep.this.O000O0oo).O000000o((int) R.string.kuailian_contain_unsupport_char).O00000Oo((int) R.string.kuailian_unsafe_wifi_content).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.O00000Oo.AnonymousClass1.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ChooseWifiStep.this.O00000Oo(o000000o.f1089O000000o);
                                htr.O000000o().O00000Oo("miui_class", null);
                                ChooseWifiStep.this.O0000OoO();
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.O00000Oo.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).O00000oo();
                    } else {
                        new MLAlertDialog.Builder(ChooseWifiStep.this.O000O0oo).O000000o((int) R.string.kuailian_unsafe_wifi).O00000Oo((int) R.string.kuailian_unsafe_wifi_content_1).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.O00000Oo.AnonymousClass1.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ChooseWifiStep.this.O00000Oo(o000000o.f1089O000000o);
                                htr.O000000o().O00000Oo("miui_class", null);
                                ChooseWifiStep.this.O0000OoO();
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.O00000Oo.AnonymousClass1.AnonymousClass3 */

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
    public final void O0000Oo() {
        if (this.mScanResultList != null && this.O000O0oo != null) {
            SmartConfigRouterFactory.getStatPageV2Manager().page_router(this.O000OOOo, 0);
            this.mScanResultList.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.O000O0oo, R.anim.v5_dialog_enter);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass10 */

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    ChooseWifiStep.this.mTopMask.setVisibility(0);
                }
            });
            this.mScanResultList.startAnimation(loadAnimation);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O0000OoO() {
        if (this.mScanResultList != null && this.O000O0oo != null) {
            SmartConfigRouterFactory.getStatPageV2Manager().page_router(this.O000OOOo, this.O000OO);
            this.mScanResultList.setVisibility(8);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.O000O0oo, R.anim.v5_dialog_exit);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep.AnonymousClass11 */

                public final void onAnimationEnd(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                    ChooseWifiStep.this.mTopMask.setVisibility(8);
                }
            });
            this.mScanResultList.startAnimation(loadAnimation);
        }
    }
}

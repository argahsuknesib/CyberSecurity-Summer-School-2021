package com.xiaomi.smarthome.smartconfig.step;

import _m_j.dcp;
import _m_j.eyr;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fte;
import _m_j.fuf;
import _m_j.gfq;
import _m_j.gor;
import _m_j.gwg;
import _m_j.gwj;
import _m_j.htq;
import _m_j.htr;
import _m_j.hua;
import _m_j.hud;
import _m_j.hul;
import _m_j.hvg;
import _m_j.hvo;
import _m_j.iag;
import _m_j.jdn;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
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
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshLinearLayout;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.WifiInfo;
import com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ChooseWifiStepV2 extends SmartConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f11693O000000o = 200;
    public static int O00000Oo = 300;
    public View O00000o;
    public View O00000o0;
    public WifiManager O00000oO;
    public iag.O000000o O00000oo;
    public iag.O000000o O0000O0o;
    public iag.O000000o O0000OOo;
    public List<iag.O000000o> O0000Oo = new ArrayList();
    public List<iag.O000000o> O0000Oo0 = new ArrayList();
    public List<iag.O000000o> O0000OoO = new ArrayList();
    public List<iag.O000000o> O0000Ooo = new ArrayList();
    public String O0000o;
    public boolean O0000o0 = false;
    public fuf.O000000o O0000o00;
    public boolean O0000o0O = false;
    public boolean O0000o0o = false;
    public BaseAdapter O0000oO = new BaseAdapter() {
        /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass13 */

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getCount() {
            return ChooseWifiStepV2.this.O0000Oo0.size() + ChooseWifiStepV2.this.O0000Oo.size();
        }

        public final Object getItem(int i) {
            if (i < ChooseWifiStepV2.this.O0000Oo0.size()) {
                return ChooseWifiStepV2.this.O0000Oo0.get(i);
            }
            return ChooseWifiStepV2.this.O0000Oo.get(i - ChooseWifiStepV2.this.O0000Oo0.size());
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            iag.O000000o o000000o;
            if (ChooseWifiStepV2.this.O000O0oo == null) {
                return view;
            }
            if (view == null) {
                view = LayoutInflater.from(ChooseWifiStepV2.this.O000O0oo).inflate((int) R.layout.item_choose_other_wifi_step, viewGroup, false);
                O00000Oo o00000Oo = new O00000Oo((byte) 0);
                o00000Oo.f11728O000000o = view.findViewById(R.id.wifi_item);
                o00000Oo.O00000Oo = (TextView) view.findViewById(R.id.wifi_name);
                o00000Oo.O00000o0 = (TextView) view.findViewById(R.id.wifi_des);
                o00000Oo.O00000oO = (ImageView) view.findViewById(R.id.wifi_signal);
                view.setTag(o00000Oo);
            }
            O00000Oo o00000Oo2 = (O00000Oo) view.getTag();
            if (i < ChooseWifiStepV2.this.O0000Oo0.size()) {
                o000000o = ChooseWifiStepV2.this.O0000Oo0.get(i);
            } else {
                o000000o = ChooseWifiStepV2.this.O0000Oo.get(i - ChooseWifiStepV2.this.O0000Oo0.size());
            }
            o00000Oo2.O00000Oo.setText(o000000o.f1089O000000o.SSID);
            if (!TextUtils.isEmpty(o000000o.O00000oO)) {
                o00000Oo2.O00000o0.setVisibility(0);
                o00000Oo2.O00000o0.setText(o000000o.O00000oO);
            } else {
                o00000Oo2.O00000o0.setVisibility(8);
            }
            if (i < ChooseWifiStepV2.this.O0000Oo0.size()) {
                o00000Oo2.O00000oO.setVisibility(0);
                o00000Oo2.O00000Oo.setTextColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_black));
                o00000Oo2.O00000o0.setTextColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_gray_lighter));
                o00000Oo2.f11728O000000o.setEnabled(true);
                o00000Oo2.O00000oO.setImageResource(iag.O000000o(iag.O00000Oo(o000000o.f1089O000000o.level)));
                o00000Oo2.f11728O000000o.setOnClickListener(new View.OnClickListener(o000000o) {
                    /* class com.xiaomi.smarthome.smartconfig.step.$$Lambda$ChooseWifiStepV2$13$xdjOLeFZbq1761pKaQ9ywY3J4CA */
                    private final /* synthetic */ iag.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        ChooseWifiStepV2.AnonymousClass13.this.O00000Oo(this.f$1, view);
                    }
                });
            } else {
                o00000Oo2.O00000oO.setVisibility(8);
                o00000Oo2.O00000Oo.setTextColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_wifi_name_disable_text_color));
                o00000Oo2.O00000o0.setTextColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_wifi_name_disable_text_color));
                o00000Oo2.f11728O000000o.setOnClickListener(new View.OnClickListener(o000000o) {
                    /* class com.xiaomi.smarthome.smartconfig.step.$$Lambda$ChooseWifiStepV2$13$bc1AMwXihkCe_KSgyFonE3kkGsM */
                    private final /* synthetic */ iag.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        ChooseWifiStepV2.AnonymousClass13.this.O000000o(this.f$1, view);
                    }
                });
            }
            return view;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo(iag.O000000o o000000o, View view) {
            if (iag.O00000o0(o000000o.f1089O000000o.SSID)) {
                new MLAlertDialog.Builder(ChooseWifiStepV2.this.O000O0oo).O000000o((int) R.string.kuailian_contain_unsupport_char).O00000Oo((int) R.string.kuailian_unsafe_wifi_content).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener(o000000o) {
                    /* class com.xiaomi.smarthome.smartconfig.step.$$Lambda$ChooseWifiStepV2$13$maVjC7JDmYwFUyi6opmhhyVNwd4 */
                    private final /* synthetic */ iag.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ChooseWifiStepV2.AnonymousClass13.this.O00000Oo(this.f$1, dialogInterface, i);
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000oo();
            } else {
                ChooseWifiStepV2.this.O000000o(o000000o);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo(iag.O000000o o000000o, DialogInterface dialogInterface, int i) {
            ChooseWifiStepV2.this.O000000o(o000000o);
            htr.O000000o().O00000Oo("miui_class", null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(iag.O000000o o000000o, View view) {
            if ((ChooseWifiStepV2.O000000o(o000000o.f1089O000000o.frequency) && !ChooseWifiStepV2.this.O0000o0O) || ChooseWifiStepV2.O00000Oo(o000000o.f1089O000000o.capabilities) || o000000o.f1089O000000o.level == 0 || DeviceFactory.O0000OOo(o000000o.f1089O000000o)) {
                new MLAlertDialog.Builder(ChooseWifiStepV2.this.O000O0oo).O00000Oo((int) R.string.kuailian_unconn_reason).O000000o((int) R.string.confirm_button, (DialogInterface.OnClickListener) null).O00000oo();
            } else if (iag.O00000Oo(o000000o.f1089O000000o) == 0) {
                new MLAlertDialog.Builder(ChooseWifiStepV2.this.O000O0oo).O00000Oo((int) R.string.not_support_no_password_wifi).O000000o((int) R.string.confirm_button, (DialogInterface.OnClickListener) null).O00000oo();
            } else {
                new MLAlertDialog.Builder(ChooseWifiStepV2.this.O000O0oo).O000000o((int) R.string.kuailian_unsafe_wifi).O00000Oo((int) R.string.kuailian_unsafe_wifi_content_1).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener(o000000o) {
                    /* class com.xiaomi.smarthome.smartconfig.step.$$Lambda$ChooseWifiStepV2$13$E96A2Y3CKM4szv5Zf0SiwgHzbAE */
                    private final /* synthetic */ iag.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ChooseWifiStepV2.AnonymousClass13.this.O000000o(this.f$1, dialogInterface, i);
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000oo();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(iag.O000000o o000000o, DialogInterface dialogInterface, int i) {
            ChooseWifiStepV2.this.O000000o(o000000o);
            htr.O000000o().O00000Oo("miui_class", null);
        }
    };
    public BaseAdapter O0000oO0 = new BaseAdapter() {
        /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass5 */

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getCount() {
            return ChooseWifiStepV2.this.O0000OoO.size() + ChooseWifiStepV2.this.O0000Ooo.size();
        }

        public final Object getItem(int i) {
            if (i < ChooseWifiStepV2.this.O0000OoO.size()) {
                return ChooseWifiStepV2.this.O0000OoO.get(i);
            }
            return ChooseWifiStepV2.this.O0000Ooo.get(i - ChooseWifiStepV2.this.O0000OoO.size());
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            final iag.O000000o o000000o;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_choose_wifi_step, viewGroup, false);
                O00000Oo o00000Oo = new O00000Oo((byte) 0);
                o00000Oo.f11728O000000o = view.findViewById(R.id.wifi_item);
                o00000Oo.O00000Oo = (TextView) view.findViewById(R.id.wifi_name);
                o00000Oo.O00000o0 = (TextView) view.findViewById(R.id.wifi_des);
                o00000Oo.O00000o = (ImageView) view.findViewById(R.id.wifi_pointer);
                o00000Oo.O00000oO = (ImageView) view.findViewById(R.id.edit_wifi);
                o00000Oo.O00000oo = (ImageView) view.findViewById(R.id.img_wifi_signal);
                view.setTag(o00000Oo);
            }
            O00000Oo o00000Oo2 = (O00000Oo) view.getTag();
            if (i < ChooseWifiStepV2.this.O0000OoO.size()) {
                o000000o = ChooseWifiStepV2.this.O0000OoO.get(i);
            } else {
                o000000o = ChooseWifiStepV2.this.O0000Ooo.get(i - ChooseWifiStepV2.this.O0000OoO.size());
            }
            if (o000000o.O00000Oo) {
                if (!TextUtils.isEmpty(o000000o.O00000oO)) {
                    o00000Oo2.O00000o0.setVisibility(0);
                    o00000Oo2.O00000o0.setText(o000000o.O00000oO);
                    o00000Oo2.O00000o0.setTextColor(viewGroup.getContext().getResources().getColor(R.color.mj_color_gray_lighter));
                } else {
                    o00000Oo2.O00000o0.setVisibility(8);
                }
                o00000Oo2.O00000Oo.setText(o000000o.f1089O000000o.SSID);
                if (i < ChooseWifiStepV2.this.O0000OoO.size()) {
                    o00000Oo2.O00000oO.setVisibility(0);
                    o00000Oo2.O00000Oo.setTextColor(viewGroup.getContext().getResources().getColor(R.color.mj_color_black));
                    o00000Oo2.O00000o0.setTextColor(viewGroup.getContext().getResources().getColor(R.color.mj_color_gray_lighter));
                    o00000Oo2.f11728O000000o.setEnabled(true);
                    o00000Oo2.O00000o0.setVisibility(8);
                    o00000Oo2.O00000oO.setImageResource(R.drawable.edit_wifi_icon);
                    o00000Oo2.O00000oO.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass5.AnonymousClass1 */

                        public final void onClick(View view) {
                            SmartConfigRouterFactory.getStatClickManager().add_wlan_editor(ChooseWifiStepV2.this.O0000o);
                            ChooseWifiStepV2.this.O0000OOo = o000000o;
                            ChooseWifiStepV2 chooseWifiStepV2 = ChooseWifiStepV2.this;
                            chooseWifiStepV2.mScanResultListRoot.setVisibility(8);
                            chooseWifiStepV2.mSaveWifiViewRoot.setVisibility(8);
                            chooseWifiStepV2.mEditWifiViewRoot.setVisibility(0);
                            chooseWifiStepV2.mTitleTv.setText((int) R.string.edit_choose_wifi_title);
                            chooseWifiStepV2.mSubTitle.setVisibility(8);
                        }
                    });
                    o00000Oo2.f11728O000000o.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass5.AnonymousClass2 */

                        public final void onClick(View view) {
                            ChooseWifiStepV2.this.O0000O0o = o000000o;
                            ChooseWifiStepV2.this.O0000o0();
                            AnonymousClass5.this.notifyDataSetChanged();
                        }
                    });
                    if (ChooseWifiStepV2.this.O0000O0o == null || !o000000o.f1089O000000o.BSSID.equalsIgnoreCase(ChooseWifiStepV2.this.O0000O0o.f1089O000000o.BSSID)) {
                        o00000Oo2.O00000o.setVisibility(8);
                    } else {
                        o00000Oo2.O00000Oo.setTextColor(viewGroup.getContext().getResources().getColor(R.color.mj_color_text_blue_bg));
                        o00000Oo2.O00000o0.setTextColor(viewGroup.getContext().getResources().getColor(R.color.mj_color_text_blue_bg));
                        o00000Oo2.O00000o.setVisibility(0);
                    }
                } else {
                    o00000Oo2.O00000oO.setVisibility(8);
                    o00000Oo2.O00000o.setVisibility(8);
                    o00000Oo2.O00000Oo.setTextColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_wifi_name_disable_text_color));
                    o00000Oo2.O00000o0.setTextColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_wifi_name_disable_text_color));
                    o00000Oo2.f11728O000000o.setEnabled(false);
                }
                if (o000000o.O00000o0) {
                    o00000Oo2.O00000oO.setVisibility(8);
                    o00000Oo2.O00000o0.setVisibility(0);
                } else if (iag.O00000Oo(o000000o.f1089O000000o.level) < 60) {
                    o00000Oo2.O00000o0.setVisibility(0);
                    o00000Oo2.O00000o0.setText(viewGroup.getContext().getString(R.string.wifi_signal_weak_tip));
                }
                if ((DeviceFactory.O00000oO(o000000o.f1089O000000o.SSID) || ChooseWifiStepV2.O000000o(o000000o.f1089O000000o.frequency)) && !ChooseWifiStepV2.this.O0000o0O) {
                    o00000Oo2.O00000o0.setText((int) R.string.wifi_may_not_24G);
                    o00000Oo2.O00000o0.setVisibility(0);
                }
            } else {
                o00000Oo2.O00000oO.setVisibility(0);
                o00000Oo2.O00000Oo.setTextColor(viewGroup.getContext().getResources().getColor(R.color.mj_color_black));
                o00000Oo2.O00000o0.setTextColor(viewGroup.getContext().getResources().getColor(R.color.mj_color_text_blue_bg));
                o00000Oo2.f11728O000000o.setEnabled(true);
                o00000Oo2.O00000Oo.setText(o000000o.f1089O000000o.SSID);
                o00000Oo2.O00000o0.setVisibility(0);
                o00000Oo2.O00000o0.setText(viewGroup.getContext().getString(R.string.click_input_password));
                o00000Oo2.O00000oO.setOnClickListener(null);
                o00000Oo2.f11728O000000o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass5.AnonymousClass3 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O000000o(_m_j.iag$O000000o, boolean, com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2$O000000o):void
                     arg types: [_m_j.iag$O000000o, int, com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2$5$3$1]
                     candidates:
                      com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O000000o(int, int, android.content.Intent):void
                      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
                      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
                      com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O000000o(_m_j.iag$O000000o, boolean, com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2$O000000o):void */
                    public final void onClick(View view) {
                        ChooseWifiStepV2.this.O000000o(o000000o, false, (O000000o) new O000000o() {
                            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass5.AnonymousClass3.AnonymousClass1 */

                            public final void O000000o(String str) {
                                ChooseWifiStepV2.this.O0000OoO.clear();
                                ChooseWifiStepV2.this.O000000o(o000000o, str);
                                ChooseWifiStepV2.this.O0000O0o = o000000o;
                                ChooseWifiStepV2.this.O0000OoO.add(0, o000000o);
                                ChooseWifiStepV2.this.O000000o(ChooseWifiStepV2.this.O0000Oo0);
                                ChooseWifiStepV2.this.O0000oO.notifyDataSetChanged();
                                ChooseWifiStepV2.this.O0000oO0.notifyDataSetChanged();
                                ChooseWifiStepV2.this.O0000Oo0();
                                ((TextView) ChooseWifiStepV2.this.O00000o0.findViewById(R.id.list_title)).setText(ChooseWifiStepV2.this.O000O0oo.getString(R.string.kuailian_save_passwd));
                            }
                        });
                    }
                });
            }
            o00000Oo2.O00000oo.setVisibility(0);
            o00000Oo2.O00000oo.setImageResource(iag.O000000o(iag.O00000Oo(o000000o.f1089O000000o.level)));
            return view;
        }
    };
    @BindView(7601)
    ImageView ivCurrentWifiPointer;
    @BindView(6730)
    ImageView ivCurrentWifiSignl;
    @BindView(6800)
    LinearLayout llCurrentWifi;
    @BindView(6253)
    TextView mCannotFindTips;
    @BindView(6284)
    View mChangePasswordView;
    @BindView(6290)
    CheckBox mCheckBox;
    @BindView(6404)
    View mDeleteWifiView;
    @BindView(6476)
    View mEditWifiViewRoot;
    @BindView(6483)
    View mEmptyView;
    @BindView(6098)
    TextView mLicenseTv;
    @BindView(6986)
    Button mNextButton;
    @BindView(7028)
    ListView mOtherListView;
    @BindView(6920)
    View mReturnBt;
    @BindView(7260)
    View mSaveWifiViewRoot;
    @BindView(7259)
    ListView mSavedListView;
    @BindView(7812)
    CustomPullDownRefreshLinearLayout mScanResultListRoot;
    @BindView(7805)
    ScrollView mScrollWifiList;
    @BindView(6924)
    TextView mSubTitle;
    @BindView(7517)
    View mTitleBar;
    @BindView(6925)
    TextView mTitleTv;
    @BindView(7654)
    TextView mTxtChoose5GWifiTips;
    @BindView(7598)
    RelativeLayout rlCurrentWifiItem;
    @BindView(7600)
    TextView tvCurrentWifiName;

    interface O000000o {
        void O000000o(String str);
    }

    public static boolean O000000o(int i) {
        return i > 4900;
    }

    public final void H_() {
    }

    public final void I_() {
    }

    ChooseWifiStepV2() {
        this.O000Ooo = "camera-config :ChooseWifiStepV2";
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_CHOOSE_WIFI;
    }

    public final void O000000o(Message message) {
        int i = message.what;
        if (i == 100 || i == 104) {
            x_().removeMessages(100);
            x_().removeMessages(104);
            O0000oO0();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o(Context context) {
        int i;
        O000000o(context, (int) R.layout.smart_config_choose_wifi);
        O000000o("create step", new Object[0]);
        gwg.O000000o(this.mTitleBar);
        this.mTitleTv.setText((int) R.string.device_choose_wifi);
        this.O0000o = (String) htr.O000000o().O000000o("device_model");
        O000O0OO();
        if (TextUtils.isEmpty((String) htr.O000000o().O000000o("wifi_bind_key"))) {
            htq.O000000o().O000000o(new hua<String, hud>() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass3 */

                public final void O000000o(hud hud) {
                }

                public final /* synthetic */ void O000000o(Object obj) {
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        ChooseWifiStepV2.this.O000000o("get bindkey in chooseWifi: ".concat(String.valueOf(str)), new Object[0]);
                        htr.O000000o().O00000Oo("wifi_bind_key", str);
                    }
                }
            });
        }
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(201);
        SmartConfigRouterFactory.getSmartConfigManager().getLocalMiRouterDetail(new hul<fuf.O00000o0>() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass1 */

            public final /* synthetic */ void O000000o(Object obj) {
                fuf.O00000o0 o00000o0 = (fuf.O00000o0) obj;
                ArrayList<WifiInfo> arrayList = o00000o0.f17173O000000o;
                if (arrayList.size() > 2) {
                    ChooseWifiStepV2.this.O000000o("getLocalMiRouterDetail onSuccess , ssid 2G name: %s", arrayList.get(0).O00000o0, new Object[0]);
                    ChooseWifiStepV2.this.O000000o("getLocalMiRouterDetail onSuccess , ssid 5G name: %s", arrayList.get(1).O00000o0, new Object[0]);
                }
                ChooseWifiStepV2.this.O0000o00 = new fuf.O000000o();
                ChooseWifiStepV2.this.O0000o00.f17171O000000o = o00000o0.f17173O000000o.get(0).O00000o0;
                ChooseWifiStepV2.this.O0000o00.O00000Oo = o00000o0.f17173O000000o.get(0).O00000oO;
                ChooseWifiStepV2.this.O0000o00.O00000o0 = o00000o0.f17173O000000o.get(1).O00000o0;
                ChooseWifiStepV2.this.O0000o00.O00000o = o00000o0.f17173O000000o.get(1).O00000oO;
            }

            public final void O000000o(int i) {
                ChooseWifiStepV2.this.O000000o("getLocalMiRouterDetail onFail, error code %d", Integer.valueOf(i));
            }

            public final void O00000Oo(int i) {
                ChooseWifiStepV2.this.O000000o("getLocalMiRouterDetail onFail, error code %d", Integer.valueOf(i));
            }
        });
        SmartConfigRouterFactory.getStatPageV2Manager().page_wlan(this.O0000o, 0);
        if (((Boolean) htr.O000000o().O000000o("from_miui", Boolean.FALSE)).booleanValue()) {
            i = 4;
        } else if (SmartConfigMainActivity.DEVICE_FROM == 5) {
            i = 3;
        } else {
            i = SmartConfigMainActivity.DEVICE_FROM_APP_PLUS_TYPE == 6 ? 2 : 1;
        }
        O000000o("which from(1:handle add; 2:near by; 3:app auto found dialog; 4:miui dialog)= %d", Integer.valueOf(i));
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_wifi_show(this.O0000o, i);
        String str = this.O0000o;
        if (str != null && DeviceFactory.O00000Oo(str)) {
            this.O0000o0O = true;
        }
        if (this.O0000o != null) {
            PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.O0000o);
            if (pluginInfo != null) {
                this.mSubTitle.setText(pluginInfo.O0000Oo0());
            } else {
                this.mSubTitle.setVisibility(8);
            }
        } else {
            this.mSubTitle.setVisibility(8);
        }
        this.mNextButton.setEnabled(false);
        this.mNextButton.setTextColor(this.O000O0oo.getResources().getColor(R.color.mj_color_gray_lighter));
        final String str2 = this.O0000o;
        if (!SmartConfigRouterFactory.getSmartConfigManager().isEurope(SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingServer())) {
            this.mCheckBox.setVisibility(4);
            this.mLicenseTv.setVisibility(4);
            this.mCheckBox.setChecked(true);
        } else {
            this.mCheckBox.setChecked(false);
            this.mCheckBox.setVisibility(0);
            String string = this.O000O0oo.getString(R.string.kuailian_license);
            int indexOf = string.indexOf("#start#");
            int indexOf2 = string.indexOf("#end#") - 7;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) string.replace("#start#", "").replace("#end#", ""));
            AnonymousClass6 r2 = new ClickableSpan() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass6 */

                public final void onClick(View view) {
                    fbs.O000000o(new fbt(ChooseWifiStepV2.this.O000O0oo, "GDPRLicenseActivity").O000000o("key_model", str2).O00000Oo(268435456));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_highlight_blue_text_color));
                    textPaint.setUnderlineText(false);
                }
            };
            if (indexOf >= 0 && indexOf2 > 0) {
                try {
                    spannableStringBuilder.setSpan(r2, indexOf, indexOf2, 33);
                } catch (Exception unused) {
                }
            }
            this.mLicenseTv.setText(spannableStringBuilder);
            this.mLicenseTv.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.mReturnBt.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass12 */

            public final void onClick(View view) {
                ChooseWifiStepV2.this.G_();
            }
        });
        this.O00000oO = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        O0000o();
        this.mScanResultListRoot.setScrollView(this.mScrollWifiList);
        this.mScanResultListRoot.setRefreshListener(new CustomPullDownRefreshLinearLayout.O00000o0() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass23 */

            public final void O000000o() {
                ChooseWifiStepV2.this.O00000oO.startScan();
                ChooseWifiStepV2.this.O0000o0 = true;
            }
        });
        LayoutInflater from = LayoutInflater.from(this.O000O0oo);
        View inflate = from.inflate((int) R.layout.header_choose_wifi_step, (ViewGroup) this.mSavedListView, false);
        this.O00000o0 = inflate.findViewById(R.id.header_wrapper);
        this.mSavedListView.addHeaderView(inflate);
        this.O00000o0.setVisibility(8);
        View inflate2 = from.inflate((int) R.layout.footer_choose_wifi_step, (ViewGroup) this.mSavedListView, false);
        this.mSavedListView.addFooterView(inflate2);
        this.mCannotFindTips.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass24 */

            public final void onClick(View view) {
                ChooseWifiStepV2.this.O00000Oo();
            }
        });
        eyr.O00000Oo();
        if (eyr.O00000oo(this.O0000o)) {
            this.mTxtChoose5GWifiTips.setVisibility(0);
        } else {
            this.mTxtChoose5GWifiTips.setVisibility(8);
        }
        inflate2.findViewById(R.id.other_wifi).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass25 */

            public final void onClick(View view) {
                SmartConfigRouterFactory.getStatClickManager().add_near_wlan(ChooseWifiStepV2.this.O0000o);
                SmartConfigRouterFactory.getStatClickManager().adddevice_wifi_selectothers(ChooseWifiStepV2.this.O0000o);
                ChooseWifiStepV2 chooseWifiStepV2 = ChooseWifiStepV2.this;
                if (!chooseWifiStepV2.O0000o0o) {
                    chooseWifiStepV2.O0000o0o = true;
                    chooseWifiStepV2.mScanResultListRoot.O000000o();
                }
                chooseWifiStepV2.mSaveWifiViewRoot.setVisibility(8);
                chooseWifiStepV2.mEditWifiViewRoot.setVisibility(8);
                chooseWifiStepV2.mScanResultListRoot.setVisibility(0);
                chooseWifiStepV2.mTitleTv.setText((int) R.string.choose_other_wifi_title);
                chooseWifiStepV2.mSubTitle.setVisibility(8);
                chooseWifiStepV2.O0000oO.notifyDataSetChanged();
                chooseWifiStepV2.O000000o("user select other wifi ,size =%d", Integer.valueOf(chooseWifiStepV2.O0000oO.getCount()));
            }
        });
        this.O00000o = from.inflate((int) R.layout.header_choose_wifi_step, (ViewGroup) this.mOtherListView, false);
        this.mOtherListView.addHeaderView(this.O00000o);
        ((TextView) this.O00000o.findViewById(R.id.list_title)).setText(context.getString(R.string.near_wifi));
        this.O00000o.setVisibility(8);
        this.mSavedListView.setAdapter((ListAdapter) this.O0000oO0);
        this.mOtherListView.setAdapter((ListAdapter) this.O0000oO);
        this.mNextButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass26 */

            public final void onClick(View view) {
                ChooseWifiStepV2.this.O000000o("click next btn", new Object[0]);
                SmartConfigRouterFactory.getStatClickManager().adddevice_wifi_next(ChooseWifiStepV2.this.O0000o);
                if (ChooseWifiStepV2.this.mCheckBox.getVisibility() != 0 || ChooseWifiStepV2.this.mCheckBox.isChecked() || !(ChooseWifiStepV2.this.O000O0oo instanceof Activity)) {
                    ChooseWifiStepV2.this.O0000Oo();
                    return;
                }
                MLAlertDialog.Builder O000000o2 = new MLAlertDialog.Builder((Activity) ChooseWifiStepV2.this.O000O0oo).O000000o(ChooseWifiStepV2.this.O000O0oo.getString(R.string.license_title));
                ChooseWifiStepV2 chooseWifiStepV2 = ChooseWifiStepV2.this;
                O000000o2.O000000o(chooseWifiStepV2.O000000o(chooseWifiStepV2.O0000o)).O00000Oo(ChooseWifiStepV2.this.O000O0oo.getString(R.string.license_negative_btn), (DialogInterface.OnClickListener) null).O000000o(ChooseWifiStepV2.this.O000O0oo.getString(R.string.license_positive_btn), new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass26.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ChooseWifiStepV2.this.O0000Oo();
                    }
                }).O00000oo();
            }
        });
        this.mChangePasswordView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass27 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O000000o(_m_j.iag$O000000o, boolean, com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2$O000000o):void
             arg types: [_m_j.iag$O000000o, int, com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2$27$1]
             candidates:
              com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O000000o(int, int, android.content.Intent):void
              com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
              com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
              com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O000000o(_m_j.iag$O000000o, boolean, com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2$O000000o):void */
            public final void onClick(View view) {
                SmartConfigRouterFactory.getStatClickManager().adddevice_wifi_changepassword(ChooseWifiStepV2.this.O0000o);
                if (ChooseWifiStepV2.this.O0000OOo != null) {
                    ChooseWifiStepV2 chooseWifiStepV2 = ChooseWifiStepV2.this;
                    chooseWifiStepV2.O000000o(chooseWifiStepV2.O0000OOo, false, (O000000o) new O000000o() {
                        /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass27.AnonymousClass1 */

                        public final void O000000o(String str) {
                            ChooseWifiStepV2.this.O000000o(ChooseWifiStepV2.this.O0000OOo, str);
                            ChooseWifiStepV2.this.O0000o0O();
                        }
                    });
                }
            }
        });
        this.mDeleteWifiView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass28 */

            public final void onClick(View view) {
                SmartConfigRouterFactory.getStatClickManager().adddevice_wifi_delete(ChooseWifiStepV2.this.O0000o);
                ChooseWifiStepV2.this.O0000OoO();
            }
        });
        this.mNextButton.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass2 */

            public final void run() {
                if (SmartConfigRouterFactory.getSmartConfigManager().getAutoConnectNew(false) && ChooseWifiStepV2.this.O00000o()) {
                    ChooseWifiStepV2.this.O000000o("auto click next btn", new Object[0]);
                    ChooseWifiStepV2.this.mNextButton.performClick();
                }
            }
        });
        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O0000o, BindStep.STEP_INPUT_CONFIG);
    }

    public final SpannableStringBuilder O000000o(final String str) {
        String string = this.O000O0oo.getString(R.string.license_content);
        int indexOf = string.indexOf("#start#");
        int indexOf2 = string.indexOf("#end#") - 7;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string.replace("#start#", "").replace("#end#", ""));
        AnonymousClass4 r0 = new ClickableSpan() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass4 */

            public final void onClick(View view) {
                fbs.O000000o(new fbt(ChooseWifiStepV2.this.O000O0oo, "GDPRLicenseActivity").O000000o("key_model", str).O00000Oo(268435456));
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_highlight_blue_text_color));
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

    public final void O00000Oo() {
        String str;
        fbt fbt = new fbt(this.O000O0oo, "WebShellActivity");
        if (SmartConfigRouterFactory.getCoreApiManager().isInternationalServer()) {
            ServerBean globalSettingServer = SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingServer();
            StringBuilder sb = new StringBuilder("https://");
            if (globalSettingServer != null) {
                str = globalSettingServer.f7546O000000o + ".";
            } else {
                str = "";
            }
            sb.append(str);
            sb.append("home.mi.com/views/faqDetail.html?question=");
            sb.append(this.O000O0oo.getString(R.string.param_question_choose_wifi_tips));
            fbt.O000000o("url", sb.toString());
        } else {
            fbt.O000000o("url", "https://home.mi.com/views/faqDetail.html?question=" + this.O000O0oo.getString(R.string.param_question_choose_wifi_tips));
        }
        fbs.O000000o(fbt);
    }

    public final boolean O00000o() {
        android.net.wifi.WifiInfo connectionInfo = this.O00000oO.getConnectionInfo();
        try {
            if (SmartConfigRouterFactory.getSmartConfigManager().checkScanWifiLocationPermission((SmartConfigMainActivity) this.O000O0oo, false, R.string.open_location_permission)) {
                List<ScanResult> scanResults = this.O00000oO.getScanResults();
                if (!(connectionInfo == null || scanResults == null)) {
                    if (scanResults.size() != 0) {
                        for (ScanResult next : scanResults) {
                            if (next.BSSID.equalsIgnoreCase(connectionInfo.getBSSID())) {
                                if (O000000o(next) && !TextUtils.isEmpty(next.SSID)) {
                                    if (!DeviceFactory.O0000OOo(next)) {
                                        if (gfq.O000000o().O000000o(next.BSSID) != null) {
                                            iag.O000000o o000000o = new iag.O000000o();
                                            o000000o.f1089O000000o = next;
                                            o000000o.O00000Oo = true;
                                            this.O0000O0o = o000000o;
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private int O00000o(String str) {
        try {
            if (iag.O00000Oo(this.O0000O0o.f1089O000000o) == 0) {
                return -1;
            }
            Class<?> cls = Class.forName("android.net.wifi.MiuiWifiManager");
            Method method = cls.getMethod("verifyPreSharedKey", WifiConfiguration.class, String.class);
            WifiConfiguration wifiConfiguration = null;
            String str2 = jdn.f1779O000000o + this.O0000O0o.f1089O000000o.SSID + jdn.f1779O000000o;
            for (WifiConfiguration next : this.O00000oO.getConfiguredNetworks()) {
                if (next != null && !TextUtils.isEmpty(next.SSID) && next.SSID.equals(str2)) {
                    wifiConfiguration = next;
                }
            }
            if (wifiConfiguration == null) {
                return 1;
            }
            return ((Boolean) method.invoke(cls, new Object[]{wifiConfiguration, str})).booleanValue() ? 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final boolean G_() {
        if (this.mScanResultListRoot.getVisibility() == 0 || this.mEditWifiViewRoot.getVisibility() == 0) {
            O0000o0O();
        } else {
            b_(false);
        }
        SmartConfigRouterFactory.getStatPageV2Manager().page_wlan(this.O0000o, this.O000OO);
        return true;
    }

    private boolean O0000o() {
        int wifiState = this.O00000oO.getWifiState();
        if (wifiState == 3) {
            this.O0000o0 = true;
            O0000oO0();
        } else if ((wifiState == 4 || wifiState == 1) && wifiState == 1) {
            if (this.O00000oO.setWifiEnabled(true)) {
                this.O0000o0 = true;
                O0000oO0();
            } else {
                new MLAlertDialog.Builder(this.O000O0oo).O00000Oo((int) R.string.wifi_disable_hint).O000000o((int) R.string.setting, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass8 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            ((Activity) ChooseWifiStepV2.this.O000O0oo).startActivityForResult(new Intent("android.net.wifi.PICK_WIFI_NETWORK"), ChooseWifiStepV2.O00000Oo);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        dialogInterface.dismiss();
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ChooseWifiStepV2.this.b_(false);
                        dialogInterface.dismiss();
                    }
                }).O000000o(false).O00000oo();
            }
        }
        return true;
    }

    @SuppressLint({"StaticFieldLeak"})
    private void O0000oO0() {
        if (this.O0000o0 && this.O000O0oo != null) {
            this.O0000o0 = false;
            if (SmartConfigRouterFactory.getSmartConfigManager().checkScanWifiLocationPermission((SmartConfigMainActivity) this.O000O0oo, true, R.string.open_location_permission)) {
                final ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                final ArrayList arrayList3 = new ArrayList();
                final ArrayList arrayList4 = new ArrayList();
                gor.O000000o(new AsyncTask<Void, Void, ScanResult>() {
                    /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass9 */

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        return O000000o();
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:134:0x0366  */
                    /* JADX WARNING: Removed duplicated region for block: B:143:0x03ae  */
                    /* JADX WARNING: Removed duplicated region for block: B:183:0x03ab A[SYNTHETIC] */
                    private ScanResult O000000o() {
                        List<ScanResult> list;
                        boolean z;
                        int i;
                        boolean z2;
                        Context context = ChooseWifiStepV2.this.O000O0oo;
                        if (context == null) {
                            return null;
                        }
                        android.net.wifi.WifiInfo connectionInfo = ChooseWifiStepV2.this.O00000oO.getConnectionInfo();
                        try {
                            list = ChooseWifiStepV2.this.O00000oO.getScanResults();
                        } catch (Exception e) {
                            e.printStackTrace();
                            list = null;
                        }
                        if (list == null) {
                            ChooseWifiStepV2.this.mCannotFindTips.post(new Runnable() {
                                /* class com.xiaomi.smarthome.smartconfig.step.$$Lambda$ChooseWifiStepV2$9$wCDGqiqyGdtGkQ7N0wPO68h0NcE */

                                public final void run() {
                                    ChooseWifiStepV2.AnonymousClass9.this.O00000Oo();
                                }
                            });
                            return null;
                        }
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        PushBindEntity pushBindEntity = (PushBindEntity) htr.O000000o().O000000o("aiot_wifi");
                        String str = null;
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            ScanResult scanResult = (ScanResult) list.get(i2);
                            if (!TextUtils.isEmpty(scanResult.SSID) && scanResult.BSSID != null && !DeviceFactory.O0000OOo(scanResult) && (pushBindEntity == null || pushBindEntity.O00000oo == null || !pushBindEntity.O00000oo.equalsIgnoreCase(scanResult.BSSID))) {
                                boolean O00000o02 = iag.O00000o0(scanResult);
                                boolean z3 = gfq.O000000o().O000000o(scanResult.BSSID) != null;
                                iag.O000000o o000000o = new iag.O000000o();
                                o000000o.O00000Oo = z3;
                                o000000o.f1089O000000o = scanResult;
                                if (connectionInfo != null && iag.O000000o(connectionInfo.getSSID(), scanResult.SSID)) {
                                    String O00000o03 = dcp.O000000o().O00000o0(scanResult.SSID);
                                    if (!TextUtils.isEmpty(O00000o03)) {
                                        o000000o.O00000o = O00000o03;
                                        o000000o.O00000oO = context.getResources().getString(R.string.current_phone_wifi);
                                    }
                                    if (O00000o02 && ChooseWifiStepV2.O000000o(scanResult.frequency)) {
                                        String[] split = scanResult.BSSID.split("\\:");
                                        str = String.format("%1$s:%2$s:%3$s:%4$s:%5$s:%6$x", split[0], split[1], split[2], split[3], split[4], Integer.valueOf(Integer.valueOf(split[5], 16).intValue() - 1));
                                    }
                                }
                                if (!ChooseWifiStepV2.this.O000000o(scanResult)) {
                                    if (iag.O00000Oo(scanResult) == 0) {
                                        o000000o.O00000oO = context.getString(R.string.kuailian_no_passwd);
                                    } else if (ChooseWifiStepV2.O00000Oo(scanResult.capabilities)) {
                                        if (ChooseWifiStepV2.this.O000OO00) {
                                            return null;
                                        }
                                        o000000o.O00000oO = context.getString(R.string.kuailian_unconn_reason);
                                        if (z3) {
                                            arrayList4.add(o000000o);
                                        }
                                    } else if (!ChooseWifiStepV2.O000000o(scanResult.frequency) || ChooseWifiStepV2.this.O0000o0O) {
                                        if (iag.O00000o0(scanResult.SSID)) {
                                            if (ChooseWifiStepV2.this.O000OO00) {
                                                return null;
                                            }
                                            o000000o.O00000oO = context.getString(R.string.kuailian_contain_unsupport_char);
                                            if (z3) {
                                                arrayList3.add(o000000o);
                                            }
                                        } else if (ChooseWifiStepV2.this.O000OO00) {
                                            return null;
                                        } else {
                                            o000000o.O00000oO = context.getString(R.string.kuailian_unsafe_wifi);
                                            if (z3) {
                                                arrayList3.add(o000000o);
                                            }
                                        }
                                    } else if (ChooseWifiStepV2.this.O000OO00) {
                                        return null;
                                    } else {
                                        o000000o.O00000oO = context.getString(R.string.not_support_5g);
                                        if (z3) {
                                            arrayList4.add(o000000o);
                                        }
                                    }
                                    if (!hashMap2.containsKey(scanResult.SSID)) {
                                        arrayList2.add(o000000o);
                                        hashMap2.put(scanResult.SSID, o000000o);
                                    } else if (iag.O00000Oo(scanResult.level) > iag.O00000Oo(((iag.O000000o) hashMap2.get(scanResult.SSID)).f1089O000000o.level)) {
                                        iag.O000000o o000000o2 = (iag.O000000o) hashMap2.get(scanResult.SSID);
                                        arrayList2.remove(o000000o2);
                                        arrayList2.add(o000000o2);
                                    }
                                } else {
                                    if (z3 && TextUtils.isEmpty(o000000o.O00000o)) {
                                        arrayList3.add(o000000o);
                                        if (ChooseWifiStepV2.this.O000OO00) {
                                            return null;
                                        }
                                        o000000o.O00000oO = context.getString(R.string.kuailian_save_passwd);
                                    }
                                    if (!hashMap.containsKey(scanResult.SSID)) {
                                        arrayList.add(o000000o);
                                        hashMap.put(scanResult.SSID, o000000o);
                                    } else if (iag.O00000Oo(scanResult.level) > iag.O00000Oo(((iag.O000000o) hashMap.get(scanResult.SSID)).f1089O000000o.level)) {
                                        iag.O000000o o000000o3 = (iag.O000000o) hashMap.get(scanResult.SSID);
                                        hashMap.remove(o000000o3.f1089O000000o.SSID);
                                        hashMap.put(scanResult.SSID, o000000o);
                                        arrayList.remove(o000000o3);
                                        arrayList.add(o000000o3);
                                    }
                                }
                            }
                        }
                        ChooseWifiStepV2.this.O000000o(arrayList);
                        ChooseWifiStepV2.this.O000000o(arrayList2);
                        ChooseWifiStepV2.this.O000000o(arrayList3);
                        ChooseWifiStepV2.this.O000000o(arrayList4);
                        if (ChooseWifiStepV2.this.O0000O0o != null) {
                            int i3 = 0;
                            while (i3 < arrayList.size()) {
                                if (ChooseWifiStepV2.this.O0000O0o.f1089O000000o.BSSID.equalsIgnoreCase(((iag.O000000o) arrayList.get(i3)).f1089O000000o.BSSID)) {
                                    ChooseWifiStepV2.this.O0000O0o = (iag.O000000o) arrayList.get(i3);
                                } else if (ChooseWifiStepV2.this.O0000O0o.f1089O000000o.BSSID.equalsIgnoreCase(str)) {
                                    ChooseWifiStepV2.this.O0000O0o = (iag.O000000o) arrayList.get(i3);
                                } else {
                                    i3++;
                                }
                                z2 = true;
                            }
                            z2 = false;
                            if (!z2) {
                                ChooseWifiStepV2.this.O0000O0o = null;
                            }
                        } else {
                            String str2 = (String) htr.O000000o().O000000o("target_bssid");
                            if (!TextUtils.isEmpty(str2)) {
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= arrayList.size()) {
                                        break;
                                    } else if (str2.equalsIgnoreCase(((iag.O000000o) arrayList.get(i4)).f1089O000000o.BSSID)) {
                                        ChooseWifiStepV2.this.O0000O0o = (iag.O000000o) arrayList.get(i4);
                                        if (htr.O000000o().O000000o("target_passwd") != null) {
                                            gwj.O000000o o000000o4 = new gwj.O000000o();
                                            o000000o4.O00000oO = ChooseWifiStepV2.this.O0000O0o.f1089O000000o.BSSID;
                                            if (o000000o4.O00000oO == null) {
                                                o000000o4.O00000oO = "";
                                            }
                                            o000000o4.O00000o0 = ChooseWifiStepV2.this.O0000O0o.f1089O000000o.SSID;
                                            o000000o4.O00000oo = ChooseWifiStepV2.this.O0000O0o.f1089O000000o.capabilities;
                                            o000000o4.O00000o = (String) htr.O000000o().O000000o("target_passwd");
                                            z = true;
                                            o000000o4.O00000Oo = true;
                                            gfq.O000000o().O000000o(o000000o4);
                                        }
                                    } else {
                                        i4++;
                                    }
                                }
                                if (!(connectionInfo == null || connectionInfo.getSSID() == null)) {
                                    i = 0;
                                    while (true) {
                                        if (i < arrayList.size()) {
                                            z = false;
                                            break;
                                        } else if (iag.O000000o(connectionInfo.getSSID(), ((iag.O000000o) arrayList.get(i)).f1089O000000o.SSID)) {
                                            ChooseWifiStepV2.this.O00000oo = (iag.O000000o) arrayList.get(i);
                                            break;
                                        } else if (((iag.O000000o) arrayList.get(i)).f1089O000000o.BSSID.equalsIgnoreCase(str)) {
                                            ChooseWifiStepV2.this.O00000oo = (iag.O000000o) arrayList.get(i);
                                            break;
                                        } else {
                                            i++;
                                        }
                                    }
                                    if (!z) {
                                        ChooseWifiStepV2.this.O00000oo = null;
                                    }
                                }
                                if (ChooseWifiStepV2.this.O0000O0o == null && ChooseWifiStepV2.this.O0000Ooo()) {
                                    ChooseWifiStepV2 chooseWifiStepV2 = ChooseWifiStepV2.this;
                                    chooseWifiStepV2.O0000O0o = chooseWifiStepV2.O00000oo;
                                }
                                if (ChooseWifiStepV2.this.O0000O0o != null && ChooseWifiStepV2.this.O0000Ooo()) {
                                    for (iag.O000000o o000000o5 : arrayList3) {
                                        if (o000000o5.f1089O000000o.BSSID.equalsIgnoreCase(connectionInfo.getBSSID())) {
                                            arrayList3.remove(o000000o5);
                                            return null;
                                        } else if (o000000o5.f1089O000000o.BSSID.equalsIgnoreCase(str)) {
                                            arrayList3.remove(o000000o5);
                                            return null;
                                        }
                                    }
                                    return null;
                                }
                            }
                        }
                        z = true;
                        i = 0;
                        while (true) {
                            if (i < arrayList.size()) {
                            }
                            i++;
                        }
                        if (!z) {
                        }
                        ChooseWifiStepV2 chooseWifiStepV22 = ChooseWifiStepV2.this;
                        chooseWifiStepV22.O0000O0o = chooseWifiStepV22.O00000oo;
                        return ChooseWifiStepV2.this.O0000O0o != null ? null : null;
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O00000Oo() {
                        ChooseWifiStepV2.this.mCannotFindTips.setVisibility(0);
                    }

                    /* access modifiers changed from: protected */
                    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01b3, code lost:
                        if (((com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O00000Oo(r4.capabilities) || _m_j.iag.O00000Oo(r4) == 0 || r4.level == 0) ? false : true) == false) goto L_0x01b5;
                     */
                    public final /* synthetic */ void onPostExecute(Object obj) {
                        if (!ChooseWifiStepV2.this.O000OO00) {
                            ChooseWifiStepV2.this.O0000Oo0.clear();
                            ChooseWifiStepV2.this.O0000Oo0.addAll(arrayList);
                            ChooseWifiStepV2.this.O0000Oo.clear();
                            ChooseWifiStepV2.this.O0000Oo.addAll(arrayList2);
                            ChooseWifiStepV2.this.O0000OoO.clear();
                            ChooseWifiStepV2.this.O0000OoO.addAll(arrayList3);
                            ChooseWifiStepV2.this.O0000Ooo.clear();
                            ChooseWifiStepV2.this.O0000Ooo.addAll(arrayList4);
                            if (ChooseWifiStepV2.this.O0000o0o()) {
                                ChooseWifiStepV2.this.mScanResultListRoot.O00000Oo();
                                return;
                            }
                            if (ChooseWifiStepV2.this.O0000OoO.size() > 0 || ChooseWifiStepV2.this.O0000Oo.size() > 0) {
                                ChooseWifiStepV2.this.O00000o0.setVisibility(0);
                            }
                            if (ChooseWifiStepV2.this.O0000Oo0.size() > 0 || ChooseWifiStepV2.this.O0000Oo.size() > 0) {
                                ChooseWifiStepV2.this.mOtherListView.setVisibility(0);
                                ChooseWifiStepV2.this.O00000o.setVisibility(0);
                                ChooseWifiStepV2.this.mScrollWifiList.setBackgroundColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_gray_lightest));
                                ChooseWifiStepV2.this.mEmptyView.setVisibility(8);
                            } else if (ChooseWifiStepV2.this.O0000o0o) {
                                ChooseWifiStepV2.this.mOtherListView.setVisibility(8);
                                ChooseWifiStepV2.this.mEmptyView.setVisibility(0);
                                ChooseWifiStepV2.this.mScrollWifiList.setBackgroundColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_white));
                            }
                            ChooseWifiStepV2 chooseWifiStepV2 = ChooseWifiStepV2.this;
                            chooseWifiStepV2.O0000o0 = false;
                            chooseWifiStepV2.mCannotFindTips.setVisibility(8);
                            if (ChooseWifiStepV2.this.O0000OoO.size() == 0) {
                                ChooseWifiStepV2.this.O00000o0.setVisibility(8);
                                ChooseWifiStepV2.this.mCannotFindTips.setVisibility(0);
                            } else if (ChooseWifiStepV2.this.O0000O0o == null) {
                                ChooseWifiStepV2 chooseWifiStepV22 = ChooseWifiStepV2.this;
                                chooseWifiStepV22.O0000O0o = chooseWifiStepV22.O0000OoO.get(0);
                            }
                            if (ChooseWifiStepV2.this.O0000o00 != null && !ChooseWifiStepV2.this.O0000Ooo()) {
                                String str = ChooseWifiStepV2.this.O0000o00.f17171O000000o;
                                String str2 = ChooseWifiStepV2.this.O0000o00.O00000o0;
                                android.net.wifi.WifiInfo connectionInfo = ((WifiManager) ChooseWifiStepV2.this.O000O0oo.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                                if (connectionInfo != null && (iag.O000000o(str, connectionInfo.getSSID()) || iag.O000000o(str2, connectionInfo.getSSID()))) {
                                    ArrayList<iag.O000000o> arrayList = new ArrayList<>();
                                    arrayList.addAll(ChooseWifiStepV2.this.O0000Oo0);
                                    arrayList.addAll(ChooseWifiStepV2.this.O0000Oo);
                                    for (iag.O000000o o000000o : arrayList) {
                                        if (iag.O000000o(o000000o.f1089O000000o.SSID, str) || iag.O000000o(o000000o.f1089O000000o.SSID, str2)) {
                                            if (!TextUtils.isEmpty(str) && str.equals(str2)) {
                                                ScanResult scanResult = o000000o.f1089O000000o;
                                            }
                                            if (!ChooseWifiStepV2.this.O000000o(o000000o.f1089O000000o)) {
                                            }
                                            o000000o.O00000Oo = true;
                                            o000000o.O00000o0 = true;
                                            o000000o.O00000oO = ChooseWifiStepV2.this.O000O0oo.getResources().getString(R.string.choose_wifi_mirouter);
                                            ChooseWifiStepV2.this.O00000o0(o000000o.f1089O000000o.SSID);
                                            ChooseWifiStepV2.this.O0000Oo0.add(0, o000000o);
                                            ChooseWifiStepV2.this.O0000OoO.add(0, o000000o);
                                            ChooseWifiStepV2.this.O0000O0o = o000000o;
                                        }
                                    }
                                }
                            }
                            ChooseWifiStepV2.this.O0000Oo0();
                            ChooseWifiStepV2.this.O0000oO0.notifyDataSetChanged();
                            ChooseWifiStepV2.this.O0000oO.notifyDataSetChanged();
                            ChooseWifiStepV2.this.mScanResultListRoot.O00000Oo();
                            ChooseWifiStepV2.this.O0000o0();
                        }
                    }
                }, new Void[0]);
            }
        }
    }

    public static boolean O00000Oo(String str) {
        return str.contains("WEP") || str.contains("EAP") || str.contains("WAPI-KEY") || str.contains("WAPI-PSK") || str.contains("WAPI-CERT");
    }

    public final void O00000o0(String str) {
        Iterator<iag.O000000o> it = this.O0000Oo0.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            iag.O000000o next = it.next();
            if (next.f1089O000000o.SSID.equals(str)) {
                this.O0000Oo0.remove(next);
                break;
            }
        }
        for (iag.O000000o next2 : this.O0000OoO) {
            if (next2.f1089O000000o.SSID.equals(str)) {
                this.O0000OoO.remove(next2);
                return;
            }
        }
    }

    public final boolean O000000o(ScanResult scanResult) {
        return (!O000000o(scanResult.frequency) || this.O0000o0O) && !O00000Oo(scanResult.capabilities) && iag.O00000Oo(scanResult) != 0 && scanResult.level != 0;
    }

    public final void O000000o(List<iag.O000000o> list) {
        Collections.sort(list, new Comparator<iag.O000000o>() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass10 */

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                iag.O000000o o000000o = (iag.O000000o) obj;
                iag.O000000o o000000o2 = (iag.O000000o) obj2;
                if (!TextUtils.isEmpty(o000000o.O00000o) && TextUtils.isEmpty(o000000o2.O00000o)) {
                    return -1;
                }
                if (TextUtils.isEmpty(o000000o.O00000o) && !TextUtils.isEmpty(o000000o2.O00000o)) {
                    return 1;
                }
                if ((o000000o.O00000Oo && o000000o2.O00000Oo) || (!o000000o.O00000Oo && !o000000o2.O00000Oo)) {
                    return o000000o2.f1089O000000o.level - o000000o.f1089O000000o.level;
                }
                if (o000000o.O00000Oo) {
                    return -1;
                }
                return 1;
            }
        });
    }

    public final void O0000Oo0() {
        if (this.O0000O0o != null) {
            this.mNextButton.setEnabled(true);
            this.mNextButton.setTextColor(this.O000O0oo.getResources().getColor(R.color.mj_color_white_100_transparent));
            return;
        }
        this.mNextButton.setEnabled(false);
        this.mNextButton.setTextColor(this.O000O0oo.getResources().getColor(R.color.mj_color_gray_lighter));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O000000o(_m_j.iag$O000000o, boolean, com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2$O000000o):void
     arg types: [_m_j.iag$O000000o, int, com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2$11]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O000000o(_m_j.iag$O000000o, boolean, com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2$O000000o):void */
    public final void O0000Oo() {
        iag.O000000o o000000o = this.O0000O0o;
        if (o000000o != null && o000000o.f1089O000000o != null) {
            final iag.O000000o o000000o2 = this.O0000O0o;
            O000000o("goNext <<select wifi info>> ssid " + o000000o2.f1089O000000o.SSID, new Object[0]);
            htr.O000000o().O00000Oo("selected_ap", o000000o2.f1089O000000o);
            htr.O000000o().O00000Oo("selected_ap_ssid", o000000o2.f1089O000000o.SSID);
            htr.O000000o().O00000Oo("selected_ap_level", Integer.valueOf(o000000o2.f1089O000000o.level));
            SmartConfigRouterFactory.getStatPageV2Manager().page_wlan(this.O0000o, this.O000OO);
            gwj.O000000o O000000o2 = gfq.O000000o().O000000o(o000000o2.f1089O000000o.BSSID);
            String str = null;
            if (!TextUtils.isEmpty(this.O0000O0o.O00000o)) {
                str = this.O0000O0o.O00000o;
            }
            if (TextUtils.isEmpty(str) && O000000o2 != null) {
                str = O000000o2.O00000o;
            }
            if (TextUtils.isEmpty(str) && this.O0000O0o.O00000o0 && this.O0000o00 != null) {
                if (iag.O000000o(this.O0000O0o.f1089O000000o.SSID, this.O0000o00.f17171O000000o)) {
                    str = this.O0000o00.O00000Oo;
                } else if (iag.O000000o(this.O0000O0o.f1089O000000o.SSID, this.O0000o00.O00000o0)) {
                    str = this.O0000o00.O00000o;
                }
            }
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("ssid", o000000o2.f1089O000000o.SSID);
            hvo O000000o3 = hvg.O000000o(CommonApplication.getAppContext());
            StringBuilder sb = new StringBuilder();
            sb.append(o000000o2.f1089O000000o.level);
            O000000o3.O00000Oo("rssi", sb.toString());
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("bssid", fte.O000000o(o000000o2.f1089O000000o.BSSID));
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
            if (!TextUtils.isEmpty(str)) {
                int O00000o2 = O00000o(str);
                O000000o("goNext check Password result(1: correct; 0: wrong; -1: not support check) %d", Integer.valueOf(O00000o2));
                if (O00000o2 == -1) {
                    htr.O000000o().O00000Oo("selected_ap_passwd", str);
                    O000O0o();
                } else if (O00000o2 == 0) {
                    O000000o(o000000o2, true, (O000000o) new O000000o() {
                        /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass11 */

                        public final void O000000o(String str) {
                            ChooseWifiStepV2.this.O000000o(o000000o2, str);
                            htr.O000000o().O00000Oo("selected_ap_passwd", str);
                            ChooseWifiStepV2.this.O000O0o();
                        }
                    });
                } else if (O00000o2 == 1) {
                    htr.O000000o().O00000Oo("selected_ap_passwd", str);
                    O000O0o();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O000000o(_m_j.iag$O000000o, boolean, com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2$O000000o):void
     arg types: [_m_j.iag$O000000o, int, com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2$14]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.O000000o(_m_j.iag$O000000o, boolean, com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2$O000000o):void */
    public final void O000000o(final iag.O000000o o000000o) {
        SmartConfigRouterFactory.getStatClickManager().add_wlan_click();
        if (this.O0000OoO.contains(o000000o) || !TextUtils.isEmpty(o000000o.O00000o)) {
            this.O0000O0o = o000000o;
            this.O0000oO0.notifyDataSetChanged();
            O0000o0O();
            return;
        }
        O000000o(o000000o, false, (O000000o) new O000000o() {
            /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass14 */

            public final void O000000o(String str) {
                ChooseWifiStepV2.this.O000000o(o000000o, str);
                if (!ChooseWifiStepV2.this.O0000OoO.contains(o000000o)) {
                    ChooseWifiStepV2 chooseWifiStepV2 = ChooseWifiStepV2.this;
                    chooseWifiStepV2.O0000O0o = o000000o;
                    chooseWifiStepV2.O0000OoO.add(0, o000000o);
                    if (!ChooseWifiStepV2.this.O0000Oo0.contains(o000000o)) {
                        ChooseWifiStepV2.this.O0000Oo0.add(o000000o);
                    }
                    if (ChooseWifiStepV2.this.O0000Oo.contains(o000000o)) {
                        ChooseWifiStepV2.this.O0000Oo.remove(o000000o);
                    }
                    ChooseWifiStepV2 chooseWifiStepV22 = ChooseWifiStepV2.this;
                    chooseWifiStepV22.O000000o(chooseWifiStepV22.O0000Oo0);
                    ChooseWifiStepV2.this.O0000oO.notifyDataSetChanged();
                    ChooseWifiStepV2.this.O0000oO0.notifyDataSetChanged();
                }
                ChooseWifiStepV2.this.O0000o0O();
            }
        });
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        View f11728O000000o;
        TextView O00000Oo;
        ImageView O00000o;
        TextView O00000o0;
        ImageView O00000oO;
        ImageView O00000oo;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o(iag.O000000o o000000o, boolean z, final O000000o o000000o2) {
        if (o000000o != null && o000000o.f1089O000000o != null) {
            View inflate = LayoutInflater.from(this.O000O0oo).inflate((int) R.layout.dialog_choose_wifi_input, (ViewGroup) this.mSavedListView, false);
            int i = 8;
            inflate.findViewById(R.id.input_again_root_view).setVisibility(z ? 0 : 8);
            View findViewById = inflate.findViewById(R.id.wifi_name);
            if (!z) {
                i = 0;
            }
            findViewById.setVisibility(i);
            ((TextView) inflate.findViewById(R.id.wifi_name)).setText(o000000o.f1089O000000o.SSID);
            ((TextView) inflate.findViewById(R.id.input_again_wifi_name)).setText(o000000o.f1089O000000o.SSID);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.change_password_state);
            final EditText editText = (EditText) inflate.findViewById(R.id.password_input_et);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass15 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    editText.setInputType(z ? 144 : 129);
                    EditText editText = editText;
                    editText.setSelection(editText.getText().toString().length());
                }
            });
            checkBox.setChecked(true);
            final Button button = (Button) inflate.findViewById(R.id.right_button);
            button.setEnabled(false);
            final MLAlertDialog O00000o2 = new MLAlertDialog.Builder(this.O000O0oo).O000000o(inflate).O00000o();
            O00000o2.setCanceledOnTouchOutside(false);
            ((Button) inflate.findViewById(R.id.left_button)).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass16 */

                public final void onClick(View view) {
                    if (O00000o2.isShowing()) {
                        O00000o2.dismiss();
                    }
                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass17 */

                public final void onClick(View view) {
                    O000000o o000000o = o000000o2;
                    if (o000000o != null) {
                        o000000o.O000000o(editText.getText().toString());
                    }
                    if (O00000o2.isShowing()) {
                        O00000o2.dismiss();
                    }
                }
            });
            if (gfq.O000000o().O000000o(o000000o.f1089O000000o.BSSID) != null) {
                checkBox.setChecked(false);
                editText.setText("");
                editText.setSelection(editText.getText().toString().length());
            }
            editText.addTextChangedListener(new TextWatcher() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass18 */

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (ChooseWifiStepV2.this.O000O0oo != null) {
                        if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                            button.setEnabled(false);
                            button.setTextColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_black_30_transparent));
                            return;
                        }
                        button.setEnabled(true);
                        button.setTextColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_text_blue_bg));
                    }
                }
            });
            O00000o2.show();
            inflate.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass19 */

                public final void run() {
                    InputMethodManager inputMethodManager;
                    if (ChooseWifiStepV2.this.O000O0oo != null && (inputMethodManager = (InputMethodManager) ChooseWifiStepV2.this.O000O0oo.getSystemService("input_method")) != null) {
                        inputMethodManager.showSoftInput(editText, 0);
                    }
                }
            }, 100);
        }
    }

    public final void O0000OoO() {
        if (this.O000O0oo != null && this.O0000OOo != null) {
            new MLAlertDialog.Builder(this.O000O0oo).O00000Oo(this.O000O0oo.getResources().getString(R.string.sure_delete_wifi)).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass21 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (ChooseWifiStepV2.this.O0000OoO.contains(ChooseWifiStepV2.this.O0000OOo)) {
                        ChooseWifiStepV2.this.O0000OoO.remove(ChooseWifiStepV2.this.O0000OOo);
                        if (ChooseWifiStepV2.this.O0000OoO.size() == 0) {
                            ChooseWifiStepV2.this.mCannotFindTips.setVisibility(0);
                        }
                        ChooseWifiStepV2.O00000Oo(ChooseWifiStepV2.this.O0000OOo);
                        if (ChooseWifiStepV2.this.O0000O0o != null && ChooseWifiStepV2.this.O0000OOo.f1089O000000o.BSSID.equalsIgnoreCase(ChooseWifiStepV2.this.O0000O0o.f1089O000000o.BSSID)) {
                            if (ChooseWifiStepV2.this.O0000OoO.size() > 0) {
                                ChooseWifiStepV2 chooseWifiStepV2 = ChooseWifiStepV2.this;
                                chooseWifiStepV2.O0000O0o = chooseWifiStepV2.O0000OoO.get(0);
                            } else {
                                ChooseWifiStepV2.this.O0000O0o = null;
                            }
                        }
                        ChooseWifiStepV2 chooseWifiStepV22 = ChooseWifiStepV2.this;
                        chooseWifiStepV22.O000000o(chooseWifiStepV22.O0000Oo0);
                        ChooseWifiStepV2.this.O0000o0O();
                        ChooseWifiStepV2.this.O0000oO.notifyDataSetChanged();
                        ChooseWifiStepV2.this.O0000oO0.notifyDataSetChanged();
                    }
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass20 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_text_blue_bg), -1).O00000o().show();
        }
    }

    public final boolean O0000Ooo() {
        iag.O000000o o000000o = this.O00000oo;
        return o000000o != null && !TextUtils.isEmpty(o000000o.O00000o);
    }

    public final void O0000o0() {
        if (O0000Ooo()) {
            SmartConfigRouterFactory.getStatPageV2Manager().page_use_miui_wifi_pwd(this.O0000o);
            this.llCurrentWifi.setVisibility(0);
            this.tvCurrentWifiName.setText(this.O00000oo.f1089O000000o.SSID);
            this.ivCurrentWifiSignl.setImageResource(iag.O000000o(iag.O00000Oo(this.O00000oo.f1089O000000o.level)));
            iag.O000000o o000000o = this.O0000O0o;
            if (o000000o == null || o000000o == this.O00000oo) {
                this.O0000O0o = this.O00000oo;
                this.ivCurrentWifiPointer.setVisibility(0);
                this.tvCurrentWifiName.setTextColor(this.O000O0oo.getResources().getColor(R.color.mj_color_text_blue_bg));
            } else {
                this.ivCurrentWifiPointer.setVisibility(8);
                this.tvCurrentWifiName.setTextColor(this.O000O0oo.getResources().getColor(R.color.mj_color_black));
            }
            this.rlCurrentWifiItem.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2.AnonymousClass22 */

                public final void onClick(View view) {
                    ChooseWifiStepV2.this.ivCurrentWifiPointer.setVisibility(0);
                    ChooseWifiStepV2.this.tvCurrentWifiName.setTextColor(ChooseWifiStepV2.this.O000O0oo.getResources().getColor(R.color.mj_color_text_blue_bg));
                    ChooseWifiStepV2 chooseWifiStepV2 = ChooseWifiStepV2.this;
                    chooseWifiStepV2.O0000O0o = chooseWifiStepV2.O00000oo;
                    ChooseWifiStepV2.this.O0000Oo0();
                    ChooseWifiStepV2.this.O0000oO0.notifyDataSetChanged();
                }
            });
            return;
        }
        this.llCurrentWifi.setVisibility(8);
    }

    public final void O0000o0O() {
        this.mScanResultListRoot.setVisibility(8);
        this.mEditWifiViewRoot.setVisibility(8);
        this.mSaveWifiViewRoot.setVisibility(0);
        O0000Oo0();
        if (this.O0000OoO.size() > 0) {
            ((TextView) this.O00000o0.findViewById(R.id.list_title)).setText(this.O000O0oo.getString(R.string.kuailian_save_passwd));
            this.O00000o0.setVisibility(0);
        } else {
            this.O00000o0.setVisibility(8);
        }
        this.mTitleTv.setText((int) R.string.device_choose_wifi);
        if (!TextUtils.isEmpty(this.mSubTitle.getText())) {
            this.mSubTitle.setVisibility(0);
        }
        O0000o0();
    }

    public final void O000000o(iag.O000000o o000000o, String str) {
        if (this.O000O0oo != null) {
            o000000o.O00000Oo = true;
            if (TextUtils.isEmpty(o000000o.O00000o)) {
                o000000o.O00000oO = this.O000O0oo.getString(R.string.kuailian_save_passwd);
            }
            ScanResult scanResult = o000000o.f1089O000000o;
            gwj.O000000o o000000o2 = new gwj.O000000o();
            o000000o2.O00000oO = scanResult.BSSID;
            if (o000000o2.O00000oO == null) {
                o000000o2.O00000oO = "";
            }
            o000000o2.O00000o0 = scanResult.SSID;
            o000000o2.O00000oo = scanResult.capabilities;
            o000000o2.O00000o = str;
            o000000o2.O00000Oo = true;
            o000000o2.f18408O000000o = this.O00000oO.getConnectionInfo().getNetworkId();
            gfq.O000000o().O000000o(o000000o2);
        }
    }

    public static void O00000Oo(iag.O000000o o000000o) {
        o000000o.O00000oO = null;
        o000000o.O00000Oo = false;
        gfq.O000000o().O00000Oo(o000000o.f1089O000000o.BSSID);
    }

    /* access modifiers changed from: package-private */
    public final boolean O0000o0o() {
        if (this.O0000Oo0.size() == 0) {
            return SmartConfigRouterFactory.getSmartConfigManager().checkScanWifiLocationPermission((SmartConfigMainActivity) this.O000O0oo, false, R.string.open_location_permission);
        }
        return false;
    }

    public final void O000000o(int i, int i2, Intent intent) {
        super.O000000o(i, i2, intent);
        if (i == f11693O000000o) {
            b_(true);
        } else if (i == O00000Oo) {
            O0000o();
        }
    }

    public final void O0000O0o() {
        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O0000o, BindStep.STEP_INPUT_CONFIG);
        if (x_() != null) {
            x_().removeMessages(104);
        }
    }
}

package com.xiaomi.smarthome.device;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.ftn;
import _m_j.fvm;
import _m_j.gpc;
import _m_j.hmv;
import _m_j.hna;
import _m_j.hxi;
import _m_j.hxp;
import _m_j.hzf;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.choosedevice.ScanDeviceView;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.common.widget.FixHeightGridView;
import java.util.ArrayList;
import java.util.List;

public class ChooseConnectDevice extends fvm implements hmv, ScanDeviceView.O000000o {
    private static int O0000OOo = 10;

    /* renamed from: O000000o  reason: collision with root package name */
    public ChooseConnectDeviceAdapter f6900O000000o;
    public DeviceScanManager O00000Oo;
    private Dialog O00000o = null;
    private View O00000o0;
    private int O00000oO;
    private int O00000oo;
    private float O0000O0o;
    private List<Object> O0000Oo0 = new ArrayList();
    @BindView(5434)
    View inScanHint;
    @BindView(5088)
    TextView mHelpTips;
    @BindView(5224)
    FixHeightGridView mListView;
    @BindView(5640)
    Button mMoreDevice;
    @BindView(5819)
    ImageView mRadarBgImg;
    @BindView(5910)
    ImageView mRadarImage;
    @BindView(5890)
    TextView mScanDescTv;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    @SuppressLint({"SetTextI18n"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.O00000o0 == null) {
            this.O00000o0 = layoutInflater.inflate((int) R.layout.fragment_choose_connect_device, viewGroup, false);
            ButterKnife.bind(this, this.O00000o0);
            this.O00000o0.findViewById(R.id.scan_no_device_desc).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ChooseConnectDevice.AnonymousClass1 */

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
                public final void onClick(View view) {
                    String str;
                    hxi.O00000o.O00000Oo();
                    hxi.O00000o.O0000O0o(ChooseConnectDevice.this.f6900O000000o.getCount());
                    fbt fbt = new fbt(ChooseConnectDevice.this.getActivity(), "WebShellActivity");
                    ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                    if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                        StringBuilder sb = new StringBuilder("https://");
                        if (O0000ooO != null) {
                            str = O0000ooO.f7546O000000o + ".";
                        } else {
                            str = "";
                        }
                        sb.append(str);
                        sb.append("home.mi.com/views/faqDetail.html?question=");
                        sb.append(ChooseConnectDevice.this.getString(R.string.param_question_cannot_find_near_device));
                        fbt.O000000o("url", sb.toString());
                    } else {
                        fbt.O000000o("url", "https://home.mi.com/views/faqDetail.html?question=" + ChooseConnectDevice.this.getString(R.string.param_question_cannot_find_near_device));
                    }
                    fbt.O000000o("show_feedback", false);
                    fbs.O000000o(fbt);
                }
            });
            this.f6900O000000o = new ChooseConnectDeviceAdapter(this.mContext, this, getActivity().getIntent(), R.layout.choose_device_list_common_item);
            this.mHelpTips.setVisibility(0);
            this.mMoreDevice.setVisibility(8);
            this.mListView.setVisibility(0);
            this.mMoreDevice.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ChooseConnectDevice.AnonymousClass2 */

                public final void onClick(View view) {
                    hxi.O00000o.f952O000000o.O000000o("add_near_more", new Object[0]);
                    hxi.O00000o.f952O000000o.O000000o("adddevice_nearby_more_click", new Object[0]);
                    ChooseConnectDevice.this.mListView.setVisibility(0);
                }
            });
            this.mHelpTips.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ChooseConnectDevice.AnonymousClass3 */

                public final void onClick(View view) {
                    String str;
                    hxi.O00000o.O00000Oo();
                    hxi.O00000o.O0000O0o(ChooseConnectDevice.this.f6900O000000o.getCount());
                    ChooseConnectDevice chooseConnectDevice = ChooseConnectDevice.this;
                    fbt fbt = new fbt(chooseConnectDevice.getActivity(), "WebShellActivity");
                    ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                    if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                        StringBuilder sb = new StringBuilder("https://");
                        if (O0000ooO != null) {
                            str = O0000ooO.f7546O000000o + ".";
                        } else {
                            str = "";
                        }
                        sb.append(str);
                        sb.append("home.mi.com/views/faqDetail.html?question=");
                        sb.append(chooseConnectDevice.getString(R.string.param_question_cannot_find_near_device));
                        fbt.O000000o("url", sb.toString());
                    } else {
                        fbt.O000000o("url", "https://home.mi.com/views/faqDetail.html?question=" + chooseConnectDevice.getString(R.string.param_question_cannot_find_near_device));
                    }
                    fbs.O000000o(fbt);
                }
            });
            hna.O00000Oo().updateVirtualDeviceInfoIfNeeded();
            this.O00000oo = getResources().getDimensionPixelOffset(R.dimen.choose_device_common_item_width);
            this.O0000O0o = getResources().getDisplayMetrics().density;
            this.O00000oO = hzf.O000000o(getContext(), (int) (((float) this.O00000oo) / this.O0000O0o), O0000OOo);
            ChooseConnectDeviceAdapter chooseConnectDeviceAdapter = this.f6900O000000o;
            int i = this.O00000oO;
            chooseConnectDeviceAdapter.O0000OoO = i;
            this.mListView.setNumColumns(i);
            this.mListView.setAdapter((ListAdapter) this.f6900O000000o);
            this.mRadarImage.post(new Runnable() {
                /* class com.xiaomi.smarthome.device.ChooseConnectDevice.AnonymousClass4 */

                public final void run() {
                    ChooseConnectDevice chooseConnectDevice = ChooseConnectDevice.this;
                    if (chooseConnectDevice.isValid()) {
                        int i = gpc.O000000o(chooseConnectDevice.getContext()).x;
                        int width = chooseConnectDevice.mRadarBgImg.getWidth();
                        if (width != 0) {
                            int height = (chooseConnectDevice.mRadarBgImg.getHeight() * i) / width;
                            int O000000o2 = (height / 2) - gpc.O000000o(258.0f);
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) chooseConnectDevice.mRadarBgImg.getLayoutParams();
                            layoutParams.height = height;
                            layoutParams.width = i;
                            layoutParams.setMargins(0, -O000000o2, 0, 0);
                            chooseConnectDevice.mRadarBgImg.setLayoutParams(layoutParams);
                        }
                        int i2 = gpc.O000000o(chooseConnectDevice.getContext()).y;
                        int height2 = chooseConnectDevice.mRadarImage.getHeight();
                        int width2 = chooseConnectDevice.mRadarImage.getWidth();
                        if (height2 != 0 && width2 != 0) {
                            double d = (double) i2;
                            Double.isNaN(d);
                            int i3 = (int) (d * 0.9d);
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((width2 * i3) / height2, i3);
                            layoutParams2.setMargins(0, gpc.O000000o(258.0f) - i3, 0, 0);
                            chooseConnectDevice.mRadarImage.setLayoutParams(layoutParams2);
                            chooseConnectDevice.mRadarImage.setVisibility(0);
                            chooseConnectDevice.mRadarImage.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.device.ChooseConnectDevice.AnonymousClass5 */

                                public final void run() {
                                    ChooseConnectDevice chooseConnectDevice = ChooseConnectDevice.this;
                                    if (chooseConnectDevice.isValid()) {
                                        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 1.0f);
                                        rotateAnimation.setInterpolator(new LinearInterpolator());
                                        rotateAnimation.setDuration(5000);
                                        rotateAnimation.setRepeatCount(-1);
                                        rotateAnimation.setFillAfter(true);
                                        chooseConnectDevice.mRadarImage.setAnimation(rotateAnimation);
                                        chooseConnectDevice.mRadarImage.startAnimation(rotateAnimation);
                                    }
                                }
                            }, 200);
                        }
                    }
                }
            });
        }
        DeviceScanManager deviceScanManager = this.O00000Oo;
        if (deviceScanManager != null) {
            deviceScanManager.getScanCache(this);
        }
        return this.O00000o0;
    }

    public final void O000000o(int i) {
        if (isValid()) {
            if (i < 7 || (i == 7 && this.f6900O000000o.getCount() == 7)) {
                this.mHelpTips.setVisibility(0);
            } else if (i == 7 && this.f6900O000000o.getCount() > 7) {
                this.mHelpTips.setVisibility(8);
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            try {
                if (this.f6900O000000o != null) {
                    hxp hxp = hxi.O00000o0;
                    int count = this.f6900O000000o.getCount();
                    hxp.f957O000000o.O000000o("adddevice_nearbydevice_show", "nearby-device", Integer.valueOf(count));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        this.mRadarImage.clearAnimation();
    }

    public void onDestroy() {
        super.onDestroy();
        Dialog dialog = this.O00000o;
        if (dialog != null && dialog.isShowing()) {
            this.O00000o.dismiss();
            this.O00000o = null;
        }
    }

    public void onScan(List<?> list) {
        this.O0000Oo0.clear();
        this.O0000Oo0.addAll(list);
        if (this.inScanHint != null && this.mListView != null) {
            int size = list.size();
            if (size == 0) {
                this.inScanHint.setVisibility(0);
                this.mListView.setVisibility(8);
            } else {
                this.mListView.setVisibility(0);
                this.inScanHint.setVisibility(8);
                ChooseConnectDeviceAdapter chooseConnectDeviceAdapter = this.f6900O000000o;
                if (chooseConnectDeviceAdapter != null) {
                    chooseConnectDeviceAdapter.O000000o(list);
                }
            }
            O000000o(size);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int O000000o2 = hzf.O000000o(getContext(), (int) (((float) this.O00000oo) / this.O0000O0o), O0000OOo);
        if (this.O00000oO != O000000o2) {
            this.O00000oO = O000000o2;
            ChooseConnectDeviceAdapter chooseConnectDeviceAdapter = this.f6900O000000o;
            int i = this.O00000oO;
            chooseConnectDeviceAdapter.O0000OoO = i;
            this.mListView.setNumColumns(i);
            onScan(this.O0000Oo0);
        }
    }
}

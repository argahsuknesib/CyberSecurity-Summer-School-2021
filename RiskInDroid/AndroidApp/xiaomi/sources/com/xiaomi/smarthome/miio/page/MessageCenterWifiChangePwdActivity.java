package com.xiaomi.smarthome.miio.page;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.gou;
import _m_j.gqd;
import _m_j.gwg;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.PinnedSectionListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageCenterWifiChangePwdActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private PinnedSectionListView f9810O000000o;
    private O000000o O00000Oo;
    private TextView O00000o0;
    public O00000Oo mData;
    public View mHeaderView;
    public LayoutInflater mLayoutInflater;
    public View mTitleBar;
    public int mTitleBarHeight;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("message_record");
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        this.mData = O00000Oo.O000000o(stringExtra);
        if (this.mData == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.message_center_wifi_change_pwd);
        gwg.O00000o0(this);
        this.mLayoutInflater = LayoutInflater.from(this);
        this.mTitleBar = findViewById(R.id.title_bar);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterWifiChangePwdActivity.AnonymousClass1 */

            public final void onClick(View view) {
                MessageCenterWifiChangePwdActivity.this.finish();
            }
        });
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.f9810O000000o = (PinnedSectionListView) findViewById(R.id.message_detail_list);
        this.O00000Oo = new O000000o();
        this.f9810O000000o.setAdapter((ListAdapter) this.O00000Oo);
        this.mHeaderView = findViewById(R.id.header_view);
        this.O00000o0 = (TextView) this.mHeaderView.findViewById(R.id.date_time_tv);
        this.O00000o0.setText(gou.O00000Oo(this.mData.O00000oO * 1000));
        if (this.mTitleBar.getBackground() != null) {
            this.mTitleBar.getBackground().setAlpha(0);
        }
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterWifiChangePwdActivity.AnonymousClass2 */

            public final void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= 16) {
                    MessageCenterWifiChangePwdActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                MessageCenterWifiChangePwdActivity messageCenterWifiChangePwdActivity = MessageCenterWifiChangePwdActivity.this;
                messageCenterWifiChangePwdActivity.mTitleBarHeight = messageCenterWifiChangePwdActivity.mTitleBar.getHeight();
                if (gwg.O000000o((Activity) MessageCenterWifiChangePwdActivity.this)) {
                    MessageCenterWifiChangePwdActivity.this.mHeaderView.setPadding(MessageCenterWifiChangePwdActivity.this.mHeaderView.getPaddingLeft(), MessageCenterWifiChangePwdActivity.this.getResources().getDimensionPixelSize(R.dimen.title_bar_top_padding), MessageCenterWifiChangePwdActivity.this.mHeaderView.getPaddingRight(), MessageCenterWifiChangePwdActivity.this.mHeaderView.getPaddingBottom());
                }
            }
        });
    }

    class O000000o extends BaseAdapter implements PinnedSectionListView.O00000Oo {
        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        O000000o() {
        }

        public final int getCount() {
            return MessageCenterWifiChangePwdActivity.this.mData.O0000O0o.size();
        }

        public final Object getItem(int i) {
            if (i < 0 || i >= MessageCenterWifiChangePwdActivity.this.mData.O0000O0o.size()) {
                return null;
            }
            return MessageCenterWifiChangePwdActivity.this.mData.O0000O0o.get(i);
        }

        public final int getItemViewType(int i) {
            return ((O00000Oo.O000000o) getItem(i)).O00000oO;
        }

        /* renamed from: com.xiaomi.smarthome.miio.page.MessageCenterWifiChangePwdActivity$O000000o$O000000o  reason: collision with other inner class name */
        class C0084O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f9815O000000o;
            SimpleDraweeView O00000Oo;
            View O00000o;
            View O00000o0;
            TextView O00000oO;
            TextView O00000oo;
            TextView O0000O0o;

            C0084O000000o() {
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            C0084O000000o o000000o;
            if (view == null) {
                view = MessageCenterWifiChangePwdActivity.this.mLayoutInflater.inflate((int) R.layout.message_center_wifi_change_pwd_item, viewGroup, false);
                o000000o = new C0084O000000o();
                o000000o.f9815O000000o = (TextView) view.findViewById(R.id.status);
                o000000o.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.device_icon);
                o000000o.O00000Oo.setHierarchy(new GenericDraweeHierarchyBuilder(o000000o.O00000Oo.getResources()).setFadeDuration(200).setPlaceholderImage(o000000o.O00000Oo.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build());
                o000000o.O00000o = view.findViewById(R.id.section_ll);
                o000000o.O00000o0 = view.findViewById(R.id.content_ll);
                o000000o.O00000oO = (TextView) view.findViewById(R.id.device_status);
                o000000o.O00000oo = (TextView) view.findViewById(R.id.date_tv);
                o000000o.O0000O0o = (TextView) view.findViewById(R.id.reset_tv);
                view.setTag(o000000o);
            } else {
                o000000o = (C0084O000000o) view.getTag();
            }
            final O00000Oo.O000000o o000000o2 = (O00000Oo.O000000o) getItem(i);
            if (o000000o2.O00000oO == 0) {
                o000000o.O00000o.setVisibility(0);
                o000000o.O00000o0.setVisibility(8);
                if (o000000o2.O00000o == 0) {
                    o000000o.f9815O000000o.setText((int) R.string.wifi_pwd_changed_succ);
                } else {
                    o000000o.f9815O000000o.setText((int) R.string.wifi_pwd_changed_fail);
                }
            } else {
                o000000o.O00000o.setVisibility(8);
                o000000o.O00000o0.setVisibility(0);
                Device O00000oo = DeviceFactory.O00000oo(o000000o2.O00000Oo, o000000o2.f9817O000000o);
                if (O00000oo != null) {
                    DeviceFactory.O00000Oo(O00000oo.model, o000000o.O00000Oo);
                } else {
                    o000000o.O00000Oo.setImageURI(gqd.O000000o((int) R.drawable.mj_ic_launcher));
                }
                o000000o.O00000oO.setText(o000000o2.O00000o0);
                if (o000000o2.O00000o == 0) {
                    o000000o.O00000oo.setText(gou.O000000o(MessageCenterWifiChangePwdActivity.this.mData.O00000oO * 1000));
                    o000000o.O0000O0o.setVisibility(8);
                } else {
                    o000000o.O00000oo.setText(gou.O000000o(MessageCenterWifiChangePwdActivity.this.mData.O00000oo * 1000));
                    o000000o.O0000O0o.setVisibility(0);
                    o000000o.O0000O0o.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.miio.page.MessageCenterWifiChangePwdActivity.O000000o.AnonymousClass1 */

                        public final void onClick(View view) {
                            fbt fbt = new fbt(MessageCenterWifiChangePwdActivity.this, "ChooseDeviceActivity");
                            fbt.O000000o("model", o000000o2.f9817O000000o);
                            fbs.O000000o(fbt);
                        }
                    });
                }
            }
            return view;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f9816O000000o;
        int O00000Oo;
        String O00000o;
        String O00000o0;
        long O00000oO;
        long O00000oo;
        List<O000000o> O0000O0o = new ArrayList();

        public static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            String f9817O000000o;
            String O00000Oo;
            int O00000o = -1;
            String O00000o0;
            int O00000oO = 1;
        }

        private O00000Oo() {
        }

        public static O00000Oo O000000o(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                O00000Oo o00000Oo = new O00000Oo();
                o00000Oo.f9816O000000o = jSONObject.optString("type");
                o00000Oo.O00000Oo = jSONObject.optInt("sub_type");
                o00000Oo.O00000o0 = jSONObject.optString("title");
                o00000Oo.O00000o = jSONObject.optString("content");
                o00000Oo.O00000oO = jSONObject.optLong("sucTime");
                o00000Oo.O00000oo = jSONObject.optLong("failTime");
                JSONArray optJSONArray = jSONObject.optJSONArray("deviceList");
                if (optJSONArray != null) {
                    boolean z = false;
                    boolean z2 = false;
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            O000000o o000000o = new O000000o();
                            o000000o.f9817O000000o = optJSONObject.optString("model");
                            o000000o.O00000Oo = optJSONObject.optString("did");
                            o000000o.O00000o0 = optJSONObject.optString("name");
                            o00000Oo.O0000O0o.add(o000000o);
                            o000000o.O00000o = optJSONObject.optInt("status");
                            if (o000000o.O00000o == 0) {
                                z = true;
                            }
                            if (o000000o.O00000o == 1) {
                                z2 = true;
                            }
                        }
                    }
                    if (z) {
                        O000000o o000000o2 = new O000000o();
                        o000000o2.O00000oO = 0;
                        o000000o2.O00000o = 0;
                        o00000Oo.O0000O0o.add(o000000o2);
                    }
                    if (z2) {
                        O000000o o000000o3 = new O000000o();
                        o000000o3.O00000oO = 0;
                        o000000o3.O00000o = 1;
                        o00000Oo.O0000O0o.add(o000000o3);
                    }
                    Collections.sort(o00000Oo.O0000O0o, new Comparator<O000000o>() {
                        /* class com.xiaomi.smarthome.miio.page.MessageCenterWifiChangePwdActivity.O00000Oo.AnonymousClass1 */

                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                            O000000o o000000o = (O000000o) obj;
                            O000000o o000000o2 = (O000000o) obj2;
                            if (o000000o.O00000oO == 0 && o000000o.O00000o == 0) {
                                return -1;
                            }
                            if (o000000o2.O00000oO == 0 && o000000o2.O00000o == 0) {
                                return 1;
                            }
                            if (o000000o.O00000oO == 0 && o000000o.O00000o == 1) {
                                if (o000000o2.O00000o == 0) {
                                    return 1;
                                }
                                return -1;
                            } else if (o000000o2.O00000oO == 0 && o000000o2.O00000o == 1) {
                                if (o000000o.O00000o == 0) {
                                    return -1;
                                }
                                return 1;
                            } else if (o000000o.O00000oO != 1 || o000000o2.O00000oO != 1) {
                                return 0;
                            } else {
                                if (o000000o.O00000o == 1 && o000000o2.O00000o == 0) {
                                    return 1;
                                }
                                if (o000000o2.O00000o == 1 && o000000o.O00000o == 0) {
                                    return -1;
                                }
                                return 0;
                            }
                        }
                    });
                }
                return o00000Oo;
            } catch (JSONException unused) {
                return null;
            }
        }
    }
}

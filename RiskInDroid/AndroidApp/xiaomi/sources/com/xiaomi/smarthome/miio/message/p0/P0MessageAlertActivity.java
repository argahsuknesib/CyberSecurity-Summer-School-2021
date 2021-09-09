package com.xiaomi.smarthome.miio.message.p0;

import _m_j.ezo;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gou;
import _m_j.gpc;
import _m_j.gre;
import _m_j.grp;
import _m_j.guh;
import _m_j.gwg;
import _m_j.hlz;
import _m_j.hxi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity;
import com.xiaomi.smarthome.miio.message.p0.model.P0Message;
import com.xiaomi.smarthome.miio.message.p0.model.P0MessageList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class P0MessageAlertActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private P0MessageList f9724O000000o;
    private TextView O00000Oo;
    private View O00000o;
    private TextView O00000o0;
    public SimpleDraweeView mIcon;

    public void onCreate(Bundle bundle) {
        Device O000000o2;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.f9724O000000o = (P0MessageList) intent.getParcelableExtra("p0_msg_data");
        P0MessageList p0MessageList = this.f9724O000000o;
        if (p0MessageList == null || p0MessageList.f9729O000000o == null || this.f9724O000000o.f9729O000000o.isEmpty()) {
            finish();
            return;
        }
        setContentView((int) R.layout.activity_p0_message_alert_layout);
        this.O00000Oo = (TextView) findViewById(R.id.i_know_tips);
        this.O00000o0 = (TextView) findViewById(R.id.open_details);
        this.mIcon = (SimpleDraweeView) findViewById(R.id.icon);
        ViewStub viewStub = (ViewStub) findViewById(R.id.single_vs);
        ViewStub viewStub2 = (ViewStub) findViewById(R.id.triple_vs);
        gwg.O00000o0(this);
        int size = this.f9724O000000o.f9729O000000o.size();
        int i = R.id.device_name;
        boolean z = false;
        if (size > 1) {
            this.O00000o = viewStub2.inflate();
            P0MessageList p0MessageList2 = this.f9724O000000o;
            if (p0MessageList2 == null || p0MessageList2.f9729O000000o == null || this.f9724O000000o.f9729O000000o.isEmpty()) {
                finish();
                return;
            }
            this.mIcon.setImageResource(R.drawable.p0_msg_alert_icon);
            LayoutInflater from = LayoutInflater.from(getApplicationContext());
            ViewGroup viewGroup = (ViewGroup) this.O00000o;
            List<P0Message> list = this.f9724O000000o.f9729O000000o;
            int i2 = 3;
            int min = Math.min(list.size(), 3);
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            while (i3 < min && i3 < i2) {
                P0Message p0Message = list.get(i3);
                if (!(p0Message == null || (O000000o2 = fno.O000000o().O000000o(p0Message.f9728O000000o)) == null)) {
                    sb.append("/");
                    sb.append(O000000o2.model);
                    View inflate = from.inflate((int) R.layout.p0_message_alert_triple_item, viewGroup, z);
                    Room O0000o00 = ggb.O00000Oo().O0000o00(O000000o2.did);
                    Home O0000o0 = O0000o00 == null ? ggb.O00000Oo().O0000o0(O000000o2.did) : ggb.O00000Oo().O00000o(O0000o00.getParentid());
                    ((TextView) inflate.findViewById(i)).setText(p0Message.O00000Oo);
                    O000000o(O000000o2, (TextView) inflate.findViewById(R.id.home_room_name), O0000o0, O0000o00);
                    O000000o((TextView) inflate.findViewById(R.id.date_time), p0Message.O000000o());
                    if (i3 == min - 1) {
                        inflate.findViewById(R.id.divide_line).setVisibility(8);
                    }
                    viewGroup.addView(inflate);
                }
                i3++;
                i = R.id.device_name;
                z = false;
                i2 = 3;
            }
            int i4 = this.f9724O000000o.O00000Oo;
            if (i4 > 3) {
                gre gre = new gre(i4 < 10 ? String.valueOf(i4) : "9+");
                gre.f18178O000000o = -65536;
                gre.setBounds(0, 0, gpc.O000000o(15.0f), gpc.O000000o(15.0f));
                this.O00000o0.setCompoundDrawables(null, null, gre, null);
            }
            hxi.O00000o0.O00000o0(sb.toString(), min);
            this.O00000o0.setOnClickListener(new View.OnClickListener(sb) {
                /* class com.xiaomi.smarthome.miio.message.p0.$$Lambda$P0MessageAlertActivity$JlSaKCq1EhLkoDbFdgJPvGKljTE */
                private final /* synthetic */ StringBuilder f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    P0MessageAlertActivity.this.O00000Oo(this.f$1, view);
                }
            });
            this.O00000Oo.setOnClickListener(new View.OnClickListener(sb) {
                /* class com.xiaomi.smarthome.miio.message.p0.$$Lambda$P0MessageAlertActivity$0c7ENTvQd0o2YXj63GjQVJPiSw */
                private final /* synthetic */ StringBuilder f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    P0MessageAlertActivity.this.O000000o(this.f$1, view);
                }
            });
            return;
        }
        this.O00000o = viewStub.inflate();
        P0MessageList p0MessageList3 = this.f9724O000000o;
        if (p0MessageList3 == null || p0MessageList3.f9729O000000o == null || this.f9724O000000o.f9729O000000o.isEmpty()) {
            finish();
            return;
        }
        P0Message p0Message2 = this.f9724O000000o.f9729O000000o.get(0);
        if (p0Message2 == null) {
            finish();
            return;
        }
        final Device O000000o3 = fno.O000000o().O000000o(p0Message2.f9728O000000o);
        if (O000000o3 == null) {
            finish();
            return;
        }
        hxi.O00000o0.O00000o0(O000000o3.model, this.f9724O000000o.f9729O000000o.size());
        Room O0000o002 = ggb.O00000Oo().O0000o00(O000000o3.did);
        Home O0000o02 = O0000o002 == null ? ggb.O00000Oo().O0000o0(O000000o3.did) : ggb.O00000Oo().O00000o(O0000o002.getParentid());
        hlz.O000000o(O000000o3.model, new fsm<hlz.O000000o, fso>() {
            /* class com.xiaomi.smarthome.miio.message.p0.P0MessageAlertActivity.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                P0MessageAlertActivity.this.mIcon.setImageURI(((hlz.O000000o) obj).f19057O000000o);
            }

            public final void onFailure(fso fso) {
                DeviceFactory.O00000Oo(O000000o3.model, P0MessageAlertActivity.this.mIcon);
            }
        });
        ((TextView) this.O00000o.findViewById(R.id.device_name)).setText(p0Message2.O00000Oo);
        O000000o(O000000o3, (TextView) this.O00000o.findViewById(R.id.home_room_name), O0000o02, O0000o002);
        O000000o((TextView) this.O00000o.findViewById(R.id.date_time), p0Message2.O000000o());
        this.O00000o0.setOnClickListener(new View.OnClickListener(O000000o3, p0Message2) {
            /* class com.xiaomi.smarthome.miio.message.p0.$$Lambda$P0MessageAlertActivity$GzFitvhlTthho19AnaG5b8H1gHc */
            private final /* synthetic */ Device f$1;
            private final /* synthetic */ P0Message f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                P0MessageAlertActivity.this.O000000o(this.f$1, this.f$2, view);
            }
        });
        this.O00000Oo.setOnClickListener(new View.OnClickListener(O000000o3) {
            /* class com.xiaomi.smarthome.miio.message.p0.$$Lambda$P0MessageAlertActivity$XalvKPn_VJdlNNF9RsJyRbcPbtE */
            private final /* synthetic */ Device f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                P0MessageAlertActivity.this.O000000o(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Device device, View view) {
        finish();
        hxi.O00000o.O0000oO0(device.model);
    }

    private void O000000o(Device device, TextView textView, Home home, Room room) {
        if (home != null) {
            ggb.O00000Oo();
            String O000000o2 = ggb.O000000o(home);
            String string = room == null ? getResources().getString(R.string.default_room) : room.getName();
            SpannableString spannableString = new SpannableString(O000000o2 + " | " + string + " | " + device.name);
            spannableString.setSpan(new RelativeSizeSpan(0.8f), O000000o2.length(), O000000o2.length() + 3, 0);
            spannableString.setSpan(new grp(gpc.O000000o(5.0f)), O000000o2.length(), O000000o2.length() + 3, 33);
            RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.8f);
            int length = (O000000o2 + " | " + string).length();
            spannableString.setSpan(relativeSizeSpan, length, (O000000o2 + " | " + string + " | ").length(), 0);
            grp grp = new grp(gpc.O000000o(5.0f));
            int length2 = (O000000o2 + " | " + string).length();
            spannableString.setSpan(grp, length2, (O000000o2 + " | " + string + " | ").length(), 33);
            textView.setText(spannableString);
            return;
        }
        String string2 = getResources().getString(R.string.share_title);
        SpannableString spannableString2 = new SpannableString(string2 + " | " + device.name);
        spannableString2.setSpan(new RelativeSizeSpan(0.8f), string2.length(), string2.length() + 3, 0);
        spannableString2.setSpan(new grp(gpc.O000000o(5.0f)), string2.length(), string2.length() + 3, 33);
        textView.setText(spannableString2);
    }

    private static void O000000o(TextView textView, long j) {
        String str;
        String[] O00000o2 = gou.O00000o(j);
        if (O00000o2.length != 0) {
            String str2 = O00000o2[0];
            if (O00000o2.length < 2) {
                str = O00000o2[0];
            } else {
                str = O00000o2[0] + " | " + O00000o2[1];
            }
            SpannableString spannableString = new SpannableString(str);
            if (O00000o2.length >= 2) {
                spannableString.setSpan(new RelativeSizeSpan(0.8f), str2.length(), str2.length() + 3, 0);
                spannableString.setSpan(new grp(gpc.O000000o(4.0f)), str2.length(), str2.length() + 3, 33);
            }
            textView.setText(spannableString);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(StringBuilder sb, View view) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(this, MessageCenterActivity.class);
        startActivity(intent);
        finish();
        hxi.O00000o.O0000o(sb.toString());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(StringBuilder sb, View view) {
        finish();
        hxi.O00000o.O0000oO0(sb.toString());
    }

    public static void startActivity(Context context, P0MessageList p0MessageList) {
        if (p0MessageList != null && p0MessageList.f9729O000000o != null && !p0MessageList.f9729O000000o.isEmpty()) {
            Intent intent = new Intent(context, P0MessageAlertActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("p0_msg_data", p0MessageList);
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Device device, P0Message p0Message, View view) {
        if (!(p0Message == null || p0Message.O00000o0 == null || TextUtils.isEmpty(p0Message.O00000o0.params))) {
            try {
                JSONObject jSONObject = new JSONObject(p0Message.O00000o0.params);
                if (!jSONObject.isNull("body")) {
                    jSONObject = jSONObject.optJSONObject("body");
                }
                if (jSONObject != null) {
                    PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
                    final String jSONObject2 = jSONObject.toString();
                    if (O00000oO == null) {
                        ezo.O000000o().dispatchMessage("", jSONObject2, false);
                        finish();
                    } else {
                        if (!(CoreApi.O000000o().O0000Oo(device.model) == null && CoreApi.O000000o().O0000OoO(device.model) == null)) {
                            finish();
                        }
                        guh.O000000o(this, jSONObject2, O00000oO, device, new SendMessageCallback() {
                            /* class com.xiaomi.smarthome.miio.message.p0.P0MessageAlertActivity.AnonymousClass2 */

                            public final void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
                                ezo.O000000o().dispatchMessage("", jSONObject2, false);
                                ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                                    /* class com.xiaomi.smarthome.miio.message.p0.P0MessageAlertActivity.AnonymousClass2.AnonymousClass1 */

                                    public final void run() {
                                        P0MessageAlertActivity.this.finish();
                                    }
                                }, 300);
                            }
                        });
                    }
                } else {
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                finish();
            }
        }
        hxi.O00000o.O0000o(device.model);
    }
}

package com.xiaomi.smarthome.share;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.ggb;
import _m_j.ggc;
import _m_j.gpy;
import _m_j.grv;
import _m_j.gue;
import _m_j.gul;
import _m_j.gva;
import _m_j.hsr;
import _m_j.hxi;
import _m_j.izb;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.EllipsesProgressTextView;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import java.util.List;
import org.json.JSONObject;

public class ShareMsgAlertActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    XQProgressDialog f11368O000000o;
    private Button O00000Oo;
    private Button O00000o;
    private Button O00000o0;
    private View O00000oO;
    private View O00000oo;
    private EllipsesProgressTextView O0000O0o;
    private O000000o O0000OOo;
    private int O0000Oo0 = Color.parseColor("#F46666");
    public O00000Oo mHomeRoomReceiver;
    public int mMsgCount = 0;
    public List<gul> mMsgList;

    class O00000Oo extends BroadcastReceiver {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11380O000000o;

        O00000Oo() {
        }

        public final void onReceive(Context context, Intent intent) {
            Home O00000o = ggb.O00000Oo().O00000o(this.f11380O000000o);
            if (O00000o == null) {
                ShareMsgAlertActivity.this.finishSelf();
                return;
            }
            if (ShareMsgAlertActivity.this.f11368O000000o != null) {
                ShareMsgAlertActivity.this.f11368O000000o.dismiss();
            }
            ShareMsgAlertActivity.this.showChangeHomeDialog(O00000o);
            if (ShareMsgAlertActivity.this.mHomeRoomReceiver != null) {
                ft.O000000o(ShareMsgAlertActivity.this).O000000o(ShareMsgAlertActivity.this.mHomeRoomReceiver);
                ShareMsgAlertActivity.this.mHomeRoomReceiver = null;
            }
            ShareMsgAlertActivity.this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = hsr.f599O000000o;
        List<gul> list = hsr.O00000Oo;
        if (i <= 0 || list == null || list.isEmpty()) {
            finish();
            return;
        }
        setContentView((int) R.layout.activity_share_msg_alert_layout);
        this.O00000Oo = (Button) findViewById(R.id.button2);
        this.O00000o0 = (Button) findViewById(R.id.button3);
        this.O00000o0.setTextColor(getResources().getColor(R.color.mj_color_black));
        this.O00000o = (Button) findViewById(R.id.button1);
        this.O00000oo = findViewById(R.id.click_mask);
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.share.$$Lambda$ShareMsgAlertActivity$OFYovRCQAC4NEwsg7_nW3fvhES4 */

            public final void onClick(View view) {
                ShareMsgAlertActivity.this.O00000o(view);
            }
        });
        findViewById(R.id.topPanel).setVisibility(8);
        findViewById(R.id.contentPanel).setVisibility(8);
        findViewById(R.id.title_divider_line).setVisibility(8);
        this.O00000oO = getDialogContentView();
        this.O0000O0o = (EllipsesProgressTextView) this.O00000oO.findViewById(R.id.progress_tip);
        ((FrameLayout) findViewById(R.id.custom)).addView(this.O00000oO);
        this.mMsgCount = hsr.f599O000000o;
        this.mMsgList = hsr.O00000Oo;
        O000000o o000000o = new O000000o(0, this.mMsgCount, this.mMsgList, (byte) 0);
        if (!gva.O000000o().isHomeShareMessage(this.mMsgList.get(0))) {
            render(o000000o);
        } else if (o000000o.O00000o0 != null && !o000000o.O00000o0.isEmpty()) {
            final gul gul = o000000o.O00000o0.get(0);
            TextView textView = (TextView) this.O00000oO.findViewById(R.id.share_tip);
            textView.setSingleLine(false);
            textView.setTextSize(15.0f);
            if (o000000o.O00000Oo > 1) {
                textView.setText((int) R.string.multi_home_invite);
                this.O00000o.setText((int) R.string.look_up);
                this.O00000o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.share.ShareMsgAlertActivity.AnonymousClass1 */

                    public final void onClick(View view) {
                        Intent intent = new Intent(ShareMsgAlertActivity.this, MultiHomeManagerActivity.class);
                        intent.putExtra("from", 5);
                        ShareMsgAlertActivity.this.startActivity(intent);
                        ShareMsgAlertActivity.this.finishSelf();
                        hxi.O00000o.O0000o00();
                    }
                });
            } else {
                gul.O000000o(textView);
                this.O00000o.setText((int) R.string.family_accept);
                this.O00000o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.share.ShareMsgAlertActivity.AnonymousClass2 */

                    public final void onClick(View view) {
                        ShareMsgAlertActivity shareMsgAlertActivity = ShareMsgAlertActivity.this;
                        shareMsgAlertActivity.f11368O000000o = new XQProgressDialog(shareMsgAlertActivity);
                        ShareMsgAlertActivity.this.f11368O000000o.setCancelable(false);
                        ShareMsgAlertActivity.this.f11368O000000o.setMessage(ShareMsgAlertActivity.this.getResources().getString(R.string.loading_share_info));
                        ShareMsgAlertActivity.this.f11368O000000o.show();
                        long homeOwner = gva.O000000o().getHomeOwner(gul);
                        final long homeId = gva.O000000o().getHomeId(gul);
                        fru.O000000o().O000000o(homeOwner, homeId, 1, new fsm<JSONObject, fso>() {
                            /* class com.xiaomi.smarthome.share.ShareMsgAlertActivity.AnonymousClass2.AnonymousClass1 */

                            public final void onFailure(fso fso) {
                                ShareMsgAlertActivity.this.f11368O000000o.dismiss();
                                ShareMsgAlertActivity.this.finishSelf();
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                ShareMsgAlertActivity.this.findViewById(R.id.alert_dialog).setVisibility(8);
                                ShareMsgAlertActivity.this.mHomeRoomReceiver = new O00000Oo();
                                ShareMsgAlertActivity.this.mHomeRoomReceiver.f11380O000000o = String.valueOf(homeId);
                                ft.O000000o(ShareMsgAlertActivity.this).O000000o(ShareMsgAlertActivity.this.mHomeRoomReceiver, new IntentFilter("home_room_updated"));
                                ggb.O00000Oo().O00000o0();
                                ShareMsgAlertActivity.this.mHandler.postDelayed(new Runnable() {
                                    /* class com.xiaomi.smarthome.share.ShareMsgAlertActivity.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        ShareMsgAlertActivity.this.finishSelf();
                                    }
                                }, 6000);
                            }
                        });
                        hxi.O00000o.O0000o00();
                    }
                });
            }
            this.O00000o0.setVisibility(8);
            this.O00000oO.findViewById(R.id.device_img).setVisibility(8);
            this.O00000oO.findViewById(R.id.tv_share_title).setVisibility(8);
            this.O00000oO.findViewById(R.id.device_name).setVisibility(8);
            this.O00000Oo.setText((int) R.string.sh_common_cancel);
            this.O00000Oo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.share.$$Lambda$ShareMsgAlertActivity$JBrazAPf4oN0Q4jEi8aov7ii1U */

                public final void onClick(View view) {
                    ShareMsgAlertActivity.this.O00000o0(view);
                }
            });
            long homeId = gva.O000000o().getHomeId(gul);
            hxi.O00000o0.f957O000000o.O000000o("homeshare_acceptalert_show", "home_id", Long.valueOf(homeId));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mHomeRoomReceiver != null) {
            ft.O000000o(this).O000000o(this.mHomeRoomReceiver);
            this.mHomeRoomReceiver = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        finishSelf();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        finishSelf();
        hxi.O00000o.f952O000000o.O000000o("homeshare_acceptalert_cancel", new Object[0]);
    }

    public void showChangeHomeDialog(final Home home) {
        if (home != null) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            String string = getString(R.string.home_share_response_success1);
            ggb.O00000Oo();
            builder.O00000Oo(String.format(string, ggb.O000000o(home))).O000000o((int) R.string.view_now, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.share.ShareMsgAlertActivity.AnonymousClass4 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void
                 arg types: [android.content.Context, java.lang.String, java.lang.String, int]
                 candidates:
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, float):void
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):void
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void */
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Context appContext = ServiceApplication.getAppContext();
                    gpy.O00000Oo(appContext, "home_room_manager_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), "show_change_home_red_dot", false);
                    ggc.O000000o().O00000oo.onNext(Boolean.FALSE);
                    ShareMsgAlertActivity.this.finishSelf();
                    ggb.O00000Oo().O000000o(home.getId(), (fsm) null);
                    hxi.O00000o.O00000oO(1);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.share.ShareMsgAlertActivity.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ShareMsgAlertActivity.this.finishSelf();
                    hxi.O00000o.O0000Ooo();
                }
            }).O00000oo();
            hxi.O00000o0.f957O000000o.O000000o("homeshare_acceptsuccess_show", "from", 1);
        }
    }

    public void finishSelf() {
        finish();
        overridePendingTransition(0, 0);
    }

    public View getDialogContentView() {
        return LayoutInflater.from(getApplicationContext()).inflate((int) R.layout.share_notification_dialog_content_layout, (ViewGroup) null);
    }

    public void render(O000000o o000000o) {
        Device shareMessageDevice;
        if (o000000o != null) {
            View view = this.O00000oO;
            if (!(o000000o == null || view == null || o000000o.O00000o0 == null || o000000o.O00000o0.isEmpty())) {
                gul gul = o000000o.O00000o0.get(0);
                TextView textView = (TextView) view.findViewById(R.id.share_tip);
                if (o000000o.O00000Oo == 1) {
                    gul.O000000o(textView, getResources().getString(R.string.share_notification_tips_user));
                } else if (o000000o.O00000Oo > 1) {
                    textView.setText((int) R.string.share_notification_tips_multi_user);
                }
                if (this.O0000OOo == null) {
                    gul.O000000o((SimpleDraweeView) view.findViewById(R.id.device_img));
                }
                TextView textView2 = (TextView) view.findViewById(R.id.device_name);
                textView2.setTextColor(getResources().getColor(R.color.mj_color_gray_normal));
                if (o000000o.f11379O000000o == 0) {
                    if (gva.O000000o().isShareMessage(gul) && (shareMessageDevice = gva.O000000o().getShareMessageDevice(gul)) != null) {
                        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(shareMessageDevice.model);
                        if (O00000oO2 != null) {
                            textView2.setText(O00000oO2.O0000Oo0());
                        } else {
                            textView2.setText(shareMessageDevice.getName());
                        }
                    }
                } else if (o000000o.f11379O000000o == 1 || o000000o.f11379O000000o == 2) {
                    textView2.setText((int) R.string.updating_no_ellipse);
                } else if (o000000o.f11379O000000o == 3) {
                    textView2.setText((int) R.string.share_request_accepted);
                } else if (o000000o.f11379O000000o == 4) {
                    textView2.setText((int) R.string.share_request_accept_fail);
                    textView2.setTextColor(this.O0000Oo0);
                }
            }
            if (o000000o.O00000Oo > 1) {
                this.O00000Oo.setVisibility(8);
                this.O00000o.setVisibility(8);
                this.O00000o0.setVisibility(0);
                this.O00000o0.setText((int) R.string.look_up);
                this.O00000o0.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.share.$$Lambda$ShareMsgAlertActivity$uyma7KlPCnTKLWd6VYcnV_YDapE */

                    public final void onClick(View view) {
                        ShareMsgAlertActivity.this.O00000Oo(view);
                    }
                });
            } else {
                this.O00000Oo.setVisibility(0);
                this.O00000o.setVisibility(0);
                this.O00000o0.setVisibility(8);
                this.O00000Oo.setText((int) R.string.sh_common_cancel);
                this.O00000Oo.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.share.$$Lambda$ShareMsgAlertActivity$xKZNjLJ4QfZ6b9AthHjS_Gxa36Q */

                    public final void onClick(View view) {
                        ShareMsgAlertActivity.this.O000000o(view);
                    }
                });
                if (o000000o.O00000o0 != null && !o000000o.O00000o0.isEmpty()) {
                    this.O00000o.setOnClickListener(new View.OnClickListener(o000000o.O00000o0.get(0)) {
                        /* class com.xiaomi.smarthome.share.$$Lambda$ShareMsgAlertActivity$TMF9mOrjics4yLFDjkcQDY1H6ec */
                        private final /* synthetic */ gul f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            ShareMsgAlertActivity.this.O000000o(this.f$1, view);
                        }
                    });
                }
                this.O00000o.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
                if (o000000o.f11379O000000o == 1) {
                    this.O00000o.setEnabled(false);
                    this.O00000o.setTextColor(getResources().getColor(R.color.mj_color_green_heavy));
                    this.O00000o.setText((int) R.string.smarthome_share_accept);
                    if (!this.O0000O0o.isAnimating()) {
                        this.O0000O0o.startProgressAnim();
                    }
                    this.O0000O0o.setVisibility(0);
                } else if (o000000o.f11379O000000o == 2) {
                    this.O00000o.setEnabled(false);
                    this.O00000o.setText((int) R.string.mj_retry);
                    this.O00000o.setTextColor(getResources().getColor(R.color.mj_color_green_heavy));
                    if (!this.O0000O0o.isAnimating()) {
                        this.O0000O0o.startProgressAnim();
                    }
                    this.O0000O0o.setVisibility(0);
                } else if (o000000o.f11379O000000o == 3) {
                    this.O00000o.setEnabled(false);
                    this.O00000o.setText((int) R.string.smarthome_share_accept);
                    this.O00000o.setTextColor(getResources().getColor(R.color.mj_color_green_heavy));
                    this.O0000O0o.stopProgressAnim();
                    this.O0000O0o.setVisibility(8);
                } else if (o000000o.f11379O000000o == 4) {
                    this.O00000o.setEnabled(true);
                    this.O00000o.setText((int) R.string.mj_retry);
                    this.O0000O0o.stopProgressAnim();
                    this.O0000O0o.setVisibility(8);
                } else {
                    this.O00000o.setEnabled(true);
                    this.O00000o.setText((int) R.string.smarthome_share_accept);
                    this.O0000O0o.stopProgressAnim();
                    this.O0000O0o.setVisibility(8);
                }
            }
            this.O0000OOo = o000000o;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        fbt fbt = new fbt(this, "/message/MessageCenterListActivity");
        fbt.O000000o("message_type", 1);
        fbt.O000000o("message_title", getResources().getString(R.string.miio_setting_share));
        fbs.O000000o(fbt);
        finishSelf();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        finishSelf();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(gul gul, View view) {
        int shareMessageInvitedId = gva.O000000o().getShareMessageInvitedId(gul);
        final String O00000o02 = gul.O00000o0();
        final AnonymousClass5 r0 = new fsm() {
            /* class com.xiaomi.smarthome.share.ShareMsgAlertActivity.AnonymousClass5 */

            public final void onSuccess(Object obj) {
                if (ShareMsgAlertActivity.this.isValid()) {
                    ShareMsgAlertActivity.this.render(new O000000o(3, ShareMsgAlertActivity.this.mMsgCount, ShareMsgAlertActivity.this.mMsgList, (byte) 0));
                    gue.O000000o().sendBroadcastByShareMsg();
                    ShareMsgAlertActivity.this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.share.ShareMsgAlertActivity.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            if (ShareMsgAlertActivity.this.isValid()) {
                                ShareMsgAlertActivity.this.finishSelf();
                            }
                        }
                    }, 1000);
                }
            }

            public final void onFailure(fso fso) {
                if (ShareMsgAlertActivity.this.isValid()) {
                    ShareMsgAlertActivity.this.render(new O000000o(4, ShareMsgAlertActivity.this.mMsgCount, ShareMsgAlertActivity.this.mMsgList, (byte) 0));
                }
            }
        };
        fru.O000000o();
        fru.O000000o(ServiceApplication.getAppContext(), "accept", O00000o02, shareMessageInvitedId, new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.share.ShareMsgAlertActivity.AnonymousClass6 */

            public final /* synthetic */ void onSuccess(Object obj) {
                fsm fsm;
                Void voidR = (Void) obj;
                MessageRecord.delete(O00000o02);
                fno.O000000o().O0000Oo0();
                if (ShareMsgAlertActivity.this.isValid() && (fsm = r0) != null) {
                    fsm.onSuccess(voidR);
                }
            }

            public final void onFailure(final fso fso) {
                if (ShareMsgAlertActivity.this.isValid()) {
                    ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.share.ShareMsgAlertActivity.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            if (ShareMsgAlertActivity.this.isValid()) {
                                if (fso.f17063O000000o == -6) {
                                    izb.O000000o(ServiceApplication.getAppContext(), (int) R.string.smarthome_share_expired_toast, 0).show();
                                } else {
                                    izb.O000000o(ServiceApplication.getAppContext(), (int) R.string.handle_error, 0).show();
                                }
                                if (r0 != null) {
                                    r0.onFailure(fso);
                                }
                            }
                        }
                    }, 3000);
                }
            }
        });
        O000000o o000000o = this.O0000OOo;
        int i = 1;
        if (!(o000000o == null || o000000o.f11379O000000o == 0)) {
            i = 2;
        }
        render(new O000000o(i, this.mMsgCount, this.mMsgList, (byte) 0));
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f11379O000000o;
        public final int O00000Oo;
        public final List<gul> O00000o0;

        /* synthetic */ O000000o(int i, int i2, List list, byte b) {
            this(i, i2, list);
        }

        private O000000o(int i, int i2, List<gul> list) {
            this.f11379O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = list;
        }
    }
}

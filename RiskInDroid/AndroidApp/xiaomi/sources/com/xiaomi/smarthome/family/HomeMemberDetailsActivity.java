package com.xiaomi.smarthome.family;

import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.ggc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gyl;
import _m_j.hxi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.HomeMember;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import org.json.JSONObject;

public class HomeMemberDetailsActivity extends BaseActivity {
    public static String KEY_HOME_ID = "key_home_id";
    public static String KEY_HOME_MEMBER = "key_home_member";
    private static final String O0000Oo = "HomeMemberDetailsActivity";
    public static int PERMISSION_ADMIN = Home.PERMIT_HOME_OWNER;
    public static int PERMISSION_USER = Home.PERMIT_HOME_SHARE;

    /* renamed from: O000000o  reason: collision with root package name */
    ImageView f7319O000000o;
    TextView O00000Oo;
    SimpleDraweeView O00000o;
    ImageView O00000o0;
    TextView O00000oO;
    TextView O00000oo;
    TextView O0000O0o;
    TextView O0000OOo;
    TextView O0000Oo0;
    private int O0000OoO;
    public Home home;
    public HomeMember homeMember;

    public static void startActivity(Context context, HomeMember homeMember2, String str) {
        Intent intent = new Intent(context, HomeMemberDetailsActivity.class);
        intent.putExtra(KEY_HOME_MEMBER, homeMember2);
        intent.putExtra(KEY_HOME_ID, str);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_member_details);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra(KEY_HOME_ID);
        this.homeMember = (HomeMember) intent.getParcelableExtra(KEY_HOME_MEMBER);
        this.home = ggb.O00000Oo().O00000o(stringExtra);
        Home home2 = this.home;
        if (home2 == null || this.homeMember == null) {
            finish();
            gsy.O000000o(6, O0000Oo, "home or homeMember == null!");
            return;
        }
        this.O0000OoO = home2.getShareflag();
        this.f7319O000000o = (ImageView) findViewById(R.id.module_a_3_return_btn);
        this.f7319O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.family.HomeMemberDetailsActivity.AnonymousClass1 */

            public final void onClick(View view) {
                HomeMemberDetailsActivity.this.onBackClicked();
            }
        });
        this.O00000Oo = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000o0 = (ImageView) findViewById(R.id.module_a_3_right_btn);
        this.O00000o = (SimpleDraweeView) findViewById(R.id.sd_user_icon);
        this.O00000oO = (TextView) findViewById(R.id.tv_user_name);
        this.O00000oo = (TextView) findViewById(R.id.tv_user_id);
        this.O0000O0o = (TextView) findViewById(R.id.tv_user_identity);
        this.O0000OOo = (TextView) findViewById(R.id.tv_bottom_btn);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.family.HomeMemberDetailsActivity.AnonymousClass2 */

            public final void onClick(View view) {
                HomeMemberDetailsActivity.this.onBottomBtnClicked();
            }
        });
        this.O0000Oo0 = (TextView) findViewById(R.id.tv_invite);
        this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.family.HomeMemberDetailsActivity.AnonymousClass3 */

            public final void onClick(View view) {
                HomeMemberDetailsActivity.this.onReinvitingClicked();
            }
        });
        this.O00000o0.setVisibility(8);
        UserInfo userInfo = this.homeMember.O00000o0;
        if (userInfo != null) {
            gyl.O000000o();
            gyl.O00000Oo(userInfo.O00000o0, this.O00000o, null);
            this.O00000oO.setText(userInfo.O00000oO);
            this.O00000oo.setText(userInfo.f7549O000000o);
        }
        this.O00000Oo.setText((int) R.string.home_member_info);
        int i = this.O0000OoO;
        if (i == PERMISSION_USER) {
            this.O0000OOo.setVisibility(8);
            this.O0000Oo0.setVisibility(8);
        } else if (i == PERMISSION_ADMIN && this.homeMember.f8990O000000o != 10) {
            this.O0000OOo.setVisibility(0);
            if (this.homeMember.f8990O000000o == 2) {
                this.O0000OOo.setText((int) R.string.home_member_remove_member);
            } else if (this.homeMember.f8990O000000o == 0) {
                this.O0000OOo.setText((int) R.string.home_member_share_cancel);
                this.O00000Oo.setText((int) R.string.smarthome_to_user_status_waiting);
            } else if (this.homeMember.f8990O000000o == -1) {
                this.O00000Oo.setText((int) R.string.smarthome_share_expired);
                this.O0000OOo.setText((int) R.string.home_member_share_cancel);
                this.O0000Oo0.setVisibility(0);
            }
        }
        TextView textView = this.O0000O0o;
        HomeMember homeMember2 = this.homeMember;
        Resources resources = getResources();
        if (homeMember2.f8990O000000o == -1) {
            str = resources.getString(R.string.family_member);
        } else if (homeMember2.f8990O000000o == 0) {
            str = resources.getString(R.string.family_member);
        } else if (homeMember2.f8990O000000o == 2) {
            str = resources.getString(R.string.family_member);
        } else if (homeMember2.f8990O000000o == 10) {
            str = resources.getString(R.string.home_administrator);
        } else {
            str = "";
        }
        textView.setText(str);
    }

    public void onResume() {
        int i;
        super.onResume();
        int i2 = this.homeMember.f8990O000000o;
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 == 2) {
                    i = this.home.isOwner() ? 1 : 5;
                } else if (i2 == 10) {
                    i = this.home.isOwner() ? 6 : 4;
                }
                hxi.O00000o0.f957O000000o.O000000o("home_management_numberdetail_show", "type", Integer.valueOf(i));
            } else if (this.home.isOwner()) {
                i = 2;
                hxi.O00000o0.f957O000000o.O000000o("home_management_numberdetail_show", "type", Integer.valueOf(i));
            }
        } else if (this.home.isOwner()) {
            i = 3;
            hxi.O00000o0.f957O000000o.O000000o("home_management_numberdetail_show", "type", Integer.valueOf(i));
        }
        i = -1;
        hxi.O00000o0.f957O000000o.O000000o("home_management_numberdetail_show", "type", Integer.valueOf(i));
    }

    public void onBackClicked() {
        onBackPressed();
    }

    public void onReinvitingClicked() {
        UserInfo userInfo = this.homeMember.O00000o0;
        if (userInfo != null) {
            hxi.O00000o.O0000Oo0("3_2");
            ggc.O000000o().O000000o(userInfo, this.home.getId(), new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.family.HomeMemberDetailsActivity.AnonymousClass4 */

                public final void onFailure(fso fso) {
                    if (fso != null) {
                        gqg.O00000Oo(fso.O00000Oo);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    HomeMemberDetailsActivity.this.onBackPressed();
                }
            });
        }
    }

    public void onBottomBtnClicked() {
        String str;
        String str2;
        String str3;
        if (this.homeMember.f8990O000000o == 0 || this.homeMember.f8990O000000o == -1) {
            str3 = getString(R.string.share_home_cancel);
            str2 = getString(R.string.ok_button);
            str = getString(R.string.sh_common_cancel);
        } else {
            str3 = String.format(getString(R.string.home_member_remove_member_dialog_title), this.O00000oO.getText());
            str2 = getString(R.string.home_member_remove);
            str = getString(R.string.home_member_do_not_remove);
        }
        new MLAlertDialog.Builder(this).O00000o0().O00000Oo(str3).O000000o(str2, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.family.HomeMemberDetailsActivity.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ggc.O000000o().O000000o(HomeMemberDetailsActivity.this.homeMember.O00000Oo, HomeMemberDetailsActivity.this.home, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.family.HomeMemberDetailsActivity.AnonymousClass5.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        gqg.O00000Oo((int) R.string.toast_failed_retry);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        HomeMemberDetailsActivity.this.onBackPressed();
                    }
                });
            }
        }).O00000Oo(str, (DialogInterface.OnClickListener) null).O000000o(getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
        if (this.homeMember.f8990O000000o == 2) {
            hxi.O00000o.O0000Oo0("1");
        } else if (this.homeMember.f8990O000000o == 0) {
            hxi.O00000o.O0000Oo0("2");
        } else if (this.homeMember.f8990O000000o == -1) {
            hxi.O00000o.O0000Oo0("3_1");
        }
    }
}

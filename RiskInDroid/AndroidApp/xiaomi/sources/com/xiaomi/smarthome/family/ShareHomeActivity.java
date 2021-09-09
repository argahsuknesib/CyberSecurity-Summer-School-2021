package com.xiaomi.smarthome.family;

import _m_j.frs;
import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.ftn;
import _m_j.ftt;
import _m_j.ggc;
import _m_j.gqg;
import _m_j.gyl;
import _m_j.hxi;
import _m_j.hxk;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.HomeMember;
import com.xiaomi.smarthome.library.common.widget.ListItemView;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import org.json.JSONObject;

public class ShareHomeActivity extends BaseActivity implements View.OnClickListener {
    public static String KEY_HOME_ID = "key_home_id";
    public static String KEY_SHARE_NEED_FINISH = "key_share_need_finish";
    public static int MAX_HOME_MEMBER = 11;

    /* renamed from: O000000o  reason: collision with root package name */
    ImageView f7355O000000o;
    TextView O00000Oo;
    LinearLayout O00000o;
    ImageView O00000o0;
    LinearLayout O00000oO;
    LinearLayout O00000oo;
    ListItemView O0000O0o;
    LinearLayout O0000OOo;
    private frs O0000Oo;
    FrameLayout O0000Oo0;
    private boolean O0000OoO = false;
    private BroadcastReceiver O0000Ooo;
    public String homeId;
    public String nickName = null;
    public String userAvatar = null;

    public static void startActivity(Context context, String str) {
        LongSparseArray<HomeMember> O000000o2 = ggc.O000000o().O000000o(str);
        if (O000000o2 == null || O000000o2.size() < MAX_HOME_MEMBER) {
            Intent intent = new Intent(context, ShareHomeActivity.class);
            intent.putExtra(KEY_HOME_ID, str);
            context.startActivity(intent);
            return;
        }
        gqg.O00000Oo((int) R.string.home_member_max);
    }

    public static void startActivityForResult(Activity activity, String str, int i, boolean z) {
        LongSparseArray<HomeMember> O000000o2 = ggc.O000000o().O000000o(str);
        if (O000000o2 == null || O000000o2.size() < MAX_HOME_MEMBER) {
            Intent intent = new Intent(activity, ShareHomeActivity.class);
            intent.putExtra(KEY_HOME_ID, str);
            intent.putExtra(KEY_SHARE_NEED_FINISH, z);
            activity.startActivityForResult(intent, i);
            return;
        }
        gqg.O00000Oo((int) R.string.home_member_max);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.share_home_activity);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.homeId = intent.getStringExtra(KEY_HOME_ID);
        if (TextUtils.isEmpty(this.homeId)) {
            finish();
            return;
        }
        this.f7355O000000o = (ImageView) findViewById(R.id.module_a_3_return_btn);
        this.f7355O000000o.setOnClickListener(this);
        this.O00000Oo = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000o0 = (ImageView) findViewById(R.id.module_a_3_right_img_btn);
        this.O00000o = (LinearLayout) findViewById(R.id.share_friend);
        this.O00000o.setOnClickListener(this);
        this.O00000oO = (LinearLayout) findViewById(R.id.share_wx);
        this.O00000oO.setOnClickListener(this);
        this.O00000oo = (LinearLayout) findViewById(R.id.share_family);
        this.O0000O0o = (ListItemView) findViewById(R.id.last_title);
        this.O0000OOo = (LinearLayout) findViewById(R.id.last_list);
        this.O0000Oo0 = (FrameLayout) findViewById(R.id.fragment_container);
        this.O00000o0.setVisibility(8);
        this.O00000oo.setVisibility(8);
        this.O00000Oo.setText((int) R.string.home_member_share_to);
        this.O0000Oo = new frs();
        this.O0000OOo.setVisibility(8);
        this.O0000O0o.setVisibility(8);
        if (ftn.O00000oO(this)) {
            this.O00000oO.setVisibility(8);
        } else {
            this.O00000oO.setVisibility(0);
        }
        if (intent.hasExtra(KEY_SHARE_NEED_FINISH)) {
            this.O0000OoO = intent.getBooleanExtra(KEY_SHARE_NEED_FINISH, false);
            if (this.O0000OoO) {
                if (this.O0000Ooo != null) {
                    ft.O000000o(this).O000000o(this.O0000Ooo);
                }
                this.O0000Ooo = new BroadcastReceiver() {
                    /* class com.xiaomi.smarthome.family.ShareHomeActivity.AnonymousClass3 */

                    public final void onReceive(Context context, Intent intent) {
                        if (intent != null && TextUtils.equals(intent.getAction(), "com.xiaomi.smarthome.action.SHARE_RESULT")) {
                            int intExtra = intent.getIntExtra("result_code", -2);
                            intent.getStringExtra("message");
                            if (intExtra == 0) {
                                ShareHomeActivity.this.finish();
                            } else {
                                gqg.O00000Oo((int) R.string.home_share_canceled);
                            }
                        }
                    }
                };
                ft.O000000o(this).O000000o(this.O0000Ooo, new IntentFilter("com.xiaomi.smarthome.action.SHARE_RESULT"));
            }
        }
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            gyl.O000000o().O000000o(new ftt<ShareUserRecord>() {
                /* class com.xiaomi.smarthome.family.ShareHomeActivity.AnonymousClass1 */

                public final void O000000o(int i) {
                }

                public final void O000000o(int i, Object obj) {
                }

                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    ShareUserRecord shareUserRecord = (ShareUserRecord) obj;
                    ShareHomeActivity.this.nickName = shareUserRecord.nickName;
                    ShareHomeActivity.this.userAvatar = shareUserRecord.url;
                }
            });
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            onBackPressed();
            hxi.O00000o.f952O000000o.O000000o("homeshare_sharepage_back", new Object[0]);
        } else if (id == R.id.share_friend) {
            goUidFragment();
            hxk hxk = hxi.O00000o;
            String str = this.homeId;
            hxk.f952O000000o.O000000o("homeshare_sharepage_mi", "home_id", str);
        } else if (id == R.id.share_wx) {
            if (ServiceApplication.getIWXAPI().isWXAppInstalled()) {
                ggc O000000o2 = ggc.O000000o();
                String str2 = this.homeId;
                AnonymousClass2 r5 = new fsm<String, fso>() {
                    /* class com.xiaomi.smarthome.family.ShareHomeActivity.AnonymousClass2 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        ShareUserRecord shareUserRecord;
                        String str = (String) obj;
                        try {
                            if ((TextUtils.isEmpty(ShareHomeActivity.this.nickName) || TextUtils.isEmpty(ShareHomeActivity.this.userAvatar)) && (shareUserRecord = gyl.O000000o().f18543O000000o) != null) {
                                ShareHomeActivity.this.nickName = shareUserRecord.nickName;
                                ShareHomeActivity.this.userAvatar = shareUserRecord.url;
                            }
                        } catch (Exception unused) {
                        }
                        ggc.O000000o();
                        ggc.O000000o(str, ShareHomeActivity.this.homeId, ShareHomeActivity.this.userAvatar, ShareHomeActivity.this.nickName);
                    }

                    public final void onFailure(fso fso) {
                        if (fso != null && TextUtils.isEmpty(fso.O00000Oo)) {
                            gqg.O00000Oo(fso.O00000Oo);
                        }
                    }
                };
                fru.O000000o();
                fru.O000000o(str2, new fsm<JSONObject, fso>(r5) {
                    /* class _m_j.ggc.AnonymousClass9 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ fsm f17732O000000o;

                    {
                        this.f17732O000000o = r2;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        String optString = ((JSONObject) obj).optString("share_key");
                        if (!TextUtils.isEmpty(optString)) {
                            fsm fsm = this.f17732O000000o;
                            if (fsm != null) {
                                fsm.onSuccess(optString);
                            }
                        } else if (this.f17732O000000o != null) {
                            this.f17732O000000o.onFailure(new fso(-1, ServiceApplication.getAppContext().getString(R.string.share_wx_error)));
                        }
                    }

                    public final void onFailure(fso fso) {
                        int i;
                        if (fso != null && ((i = fso.f17063O000000o) == -4001004 || i == -6 || i == -12 || i == -11)) {
                            fso = new fso(-1, ServiceApplication.getAppContext().getString(R.string.share_wx_error));
                        }
                        fsm fsm = this.f17732O000000o;
                        if (fsm != null) {
                            fsm.onFailure(fso);
                        }
                    }
                });
            } else {
                getContext();
                gqg.O000000o(getString(R.string.mj_wx_not_installed));
            }
            hxk hxk2 = hxi.O00000o;
            String str3 = this.homeId;
            hxk2.f952O000000o.O000000o("homeshare_sharepage_wx", "home_id", str3);
        }
    }

    public void goUidFragment() {
        Fragment O000000o2 = getSupportFragmentManager().O000000o(frs.class.getSimpleName());
        if (O000000o2 == null) {
            this.O0000Oo0.setVisibility(0);
            getSupportFragmentManager().O000000o().O000000o((int) R.anim.fragment_right_in, (int) R.anim.fragment_left_out, (int) R.anim.fragment_left_in, (int) R.anim.fragment_right_out).O000000o(R.id.fragment_container, this.O0000Oo, frs.class.getSimpleName()).O000000o(frs.class.getSimpleName()).O00000Oo();
            return;
        }
        this.O0000Oo0.setVisibility(0);
        getSupportFragmentManager().O000000o().O000000o((int) R.anim.fragment_right_in, (int) R.anim.fragment_left_out, (int) R.anim.fragment_left_in, (int) R.anim.fragment_right_out).O00000o0(O000000o2).O00000Oo();
    }

    public String getHomeId() {
        return this.homeId;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.O0000Ooo != null && this.O0000OoO) {
            ft.O000000o(this).O000000o(this.O0000Ooo);
        }
    }
}

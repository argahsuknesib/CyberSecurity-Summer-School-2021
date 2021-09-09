package com.xiaomi.smarthome.framework.login.ui;

import _m_j.eez;
import _m_j.efk;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.ft;
import _m_j.fta;
import _m_j.ftn;
import _m_j.ftt;
import _m_j.ftw;
import _m_j.fwq;
import _m_j.gny;
import _m_j.gor;
import _m_j.gpg;
import _m_j.gqb;
import _m_j.gqz;
import _m_j.gsy;
import _m_j.gty;
import _m_j.gyl;
import _m_j.ibh;
import _m_j.icc;
import _m_j.inc;
import _m_j.izb;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tencent.bugly.crashreport.CrashReport;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.Gender;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.account.AccountType;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.RunningProcess;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.SimpleListDialog;
import com.xiaomi.smarthome.library.common.dialog.WheelDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.ListItemView;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import miui.vip.VipAchievement;
import miui.vip.VipUserInfo;
import okhttp3.Call;

public class LogoutActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    icc f7581O000000o;
    boolean O00000Oo = false;
    private TextView O00000o;
    Random O00000o0 = new Random();
    private TextView O00000oO;
    private ImageView O00000oo;
    private O00000Oo O0000O0o;
    private O00000Oo O0000OOo;
    private O00000Oo O0000Oo;
    private O00000Oo O0000Oo0;
    private O00000Oo O0000OoO;
    private O00000Oo O0000Ooo;
    private SimpleListDialog O0000o;
    private O00000Oo O0000o0;
    private O00000Oo O0000o00;
    private MLAlertDialog O0000o0O;
    private MLAlertDialog O0000o0o;
    private final DialogInterface.OnClickListener O0000oO = new DialogInterface.OnClickListener() {
        /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass1 */

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (!LogoutActivity.this.O00000Oo) {
                LogoutActivity logoutActivity = LogoutActivity.this;
                logoutActivity.O00000Oo = true;
                logoutActivity.showProgressDialog(true);
                LogoutActivity.this.processLogout();
            }
        }
    };
    private XQProgressDialog O0000oO0;
    private boolean O0000oOO = false;
    private gqz O0000oOo;
    private Context O0000oo;
    private final gqz.O000000o O0000oo0 = new gqz.O000000o() {
        /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass12 */

        public final void O000000o(String str) {
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                LogoutActivity.this.refreshAndChangeHeadIcon(str);
            }
        }
    };
    private XQProgressDialog O0000ooO;
    private boolean O0000ooo = false;
    private long O00oOooO;
    private BroadcastReceiver O00oOooo;
    public List<VipAchievement> mAchievementList;
    public String mBigHeadUrl;
    public WheelDialog mChangeBirthDialog;
    public SimpleListDialog mChangeSexDialog;
    public O00000Oo mEmailContainer;
    public SwitchButton mFBBindingSwitch;
    public O00000Oo mHeadContainer;
    public O00000Oo mNameContainer;
    public O00000Oo mPhoneContainer;
    public O00000Oo mPwdContainer;
    public O00000Oo mUidContainer;
    public String mUserName = "";
    public ShareUserRecord mUserRecord;
    public VipUserInfo mVipUserInfo;
    public SwitchButton mWXBindingSwitch;

    private static String O000000o(String str, int i, int i2) {
        if (TextUtils.isEmpty(str) || str.length() <= i + i2) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (i3 < i || i3 >= str.length() - i2) {
                sb.append(str.charAt(i3));
            } else {
                sb.append("*");
            }
        }
        return sb.toString();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O0000oo = this;
        setContentView((int) R.layout.logout_account_activity);
        this.O0000Oo0 = new O00000Oo(this, findViewById(R.id.head_profile_category), 0, (byte) 0);
        this.O0000Oo0.O000000o((int) R.string.account_basic_data);
        this.mHeadContainer = new O00000Oo(this, findViewById(R.id.head_container), 1, (byte) 0);
        this.mHeadContainer.O000000o((int) R.string.label_head);
        this.mHeadContainer.O00000o0();
        O00000Oo o00000Oo = this.mHeadContainer;
        if (o00000Oo.f7620O000000o != null) {
            o00000Oo.O00000Oo.setVisibility(0);
        }
        O00000Oo o00000Oo2 = this.mHeadContainer;
        String string = getString(R.string.label_head);
        if (!(string == null || string.length() == 0 || o00000Oo2.f7620O000000o == null)) {
            o00000Oo2.O00000Oo.setContentDescription(string);
        }
        this.mUidContainer = new O00000Oo(this, findViewById(R.id.uid_container), 2, (byte) 0);
        this.mUidContainer.O000000o((int) R.string.label_account_id);
        this.mUidContainer.O000000o();
        this.mUidContainer.O00000Oo();
        this.mNameContainer = new O00000Oo(this, findViewById(R.id.name_container), 3, (byte) 0);
        this.mNameContainer.O000000o((int) R.string.label_name);
        this.mNameContainer.O00000Oo();
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.O0000Oo = new O00000Oo(this, findViewById(R.id.account_binding_category), 4, (byte) 0);
            this.O0000Oo.O000000o((int) R.string.account_binding);
            this.O0000OoO = new O00000Oo(this, findViewById(R.id.wx_account_binding_container), 5, (byte) 0);
            this.O0000OoO.O000000o((int) R.string.account_wechat);
            this.O0000OoO.O00000Oo();
            this.mWXBindingSwitch = (SwitchButton) this.O0000OoO.O00000o(R.id.binding_switch);
            findViewById(R.id.fb_account_binding_container).setVisibility(8);
            if (CoreApi.O000000o().O0000Oo() != AccountType.MI) {
                this.O0000OoO.O00000o0(8);
                this.O0000Oo.O00000o0(8);
            }
            initWXBound(false);
            O000000o();
        } else {
            this.O0000Oo = new O00000Oo(this, findViewById(R.id.account_binding_category), 4, (byte) 0);
            this.O0000Oo.O000000o((int) R.string.account_binding);
            findViewById(R.id.wx_account_binding_container).setVisibility(8);
            this.O0000Ooo = new O00000Oo(this, findViewById(R.id.fb_account_binding_container), 5, (byte) 0);
            this.O0000Ooo.O000000o((int) R.string.account_fb);
            this.O0000Ooo.O00000Oo();
            this.mFBBindingSwitch = (SwitchButton) this.O0000Ooo.O00000o(R.id.binding_switch);
            initFBBound(false);
            O00000Oo();
        }
        this.O0000o00 = new O00000Oo(this, findViewById(R.id.account_security_category), 6, (byte) 0);
        this.O0000o00.O000000o((int) R.string.account_security);
        this.mPhoneContainer = new O00000Oo(this, findViewById(R.id.phone_container), 7, (byte) 0);
        this.mPhoneContainer.O000000o((int) R.string.label_phone);
        this.mPhoneContainer.O000000o();
        this.mPhoneContainer.O00000Oo();
        this.mEmailContainer = new O00000Oo(this, findViewById(R.id.email_container), 8, (byte) 0);
        this.mEmailContainer.O000000o((int) R.string.label_email);
        this.mEmailContainer.O000000o();
        this.mEmailContainer.O00000Oo();
        this.mPwdContainer = new O00000Oo(this, findViewById(R.id.pwd_container), 9, (byte) 0);
        this.mPwdContainer.O000000o((int) R.string.label_account_security);
        this.mPwdContainer.O00000Oo();
        this.O0000o0 = new O00000Oo(this, findViewById(R.id.account_vip_category), 10, (byte) 0);
        this.O0000O0o = new O00000Oo(this, findViewById(R.id.vip_level_container), 11, (byte) 0);
        this.O0000OOo = new O00000Oo(this, findViewById(R.id.vip_achievement_container), 12, (byte) 0);
        findViewById(R.id.account_vip_category).setVisibility(8);
        findViewById(R.id.vip_level_container).setVisibility(8);
        findViewById(R.id.vip_achievement_container).setVisibility(8);
        this.O00000o = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000o.setText((int) R.string.title_person_info);
        this.O00000oO = (TextView) findViewById(R.id.login_system_account_login_button);
        this.O00000oO.setText((int) R.string.miio_setting_logout);
        this.O00000oo = (ImageView) findViewById(R.id.module_a_3_return_btn);
        refreshUIByReloadingUserInfo();
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass33 */

            public final void onClick(View view) {
                LogoutActivity.this.finish();
            }
        });
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass34 */

            public final void onClick(View view) {
                LogoutActivity.this.finish();
            }
        });
        this.O00000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass35 */

            public final void onClick(View view) {
                LogoutActivity.this.showLogoutDialog();
            }
        });
        this.mNameContainer.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass2 */

            public final void onClick(View view) {
                LogoutActivity.this.showChangeNameDialog();
            }
        });
        this.mHeadContainer.O00000o(R.id.arrow).setVisibility(8);
        this.mHeadContainer.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass3 */

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("url", gqb.O0000O0o(LogoutActivity.this.mBigHeadUrl));
                intent.setClass(LogoutActivity.this, ImagePreviewActivity.class);
                LogoutActivity.this.startActivity(intent);
            }
        });
        O00000Oo o00000Oo3 = this.mHeadContainer;
        AnonymousClass4 r0 = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass4 */

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("url", gqb.O0000O0o(LogoutActivity.this.mBigHeadUrl));
                intent.setClass(LogoutActivity.this, ImagePreviewActivity.class);
                LogoutActivity.this.startActivity(intent);
            }
        };
        if (o00000Oo3.f7620O000000o != null) {
            o00000Oo3.O00000Oo.setOnClickListener(r0);
        }
        this.mPwdContainer.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass5 */

            public final void onClick(View view) {
                LogoutActivity.this.startChangePwdActivity();
            }
        });
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            O00000Oo o00000Oo4 = this.O0000o0;
            if (o00000Oo4 != null) {
                o00000Oo4.O00000o0(8);
            }
            O00000Oo o00000Oo5 = this.O0000O0o;
            if (o00000Oo5 != null) {
                o00000Oo5.O000000o(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass6 */

                    public final void onClick(View view) {
                        LogoutActivity.this.showVipLevel();
                    }
                });
            }
            O00000Oo o00000Oo6 = this.O0000OOo;
            if (o00000Oo6 != null) {
                o00000Oo6.O000000o(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass7 */

                    public final void onClick(View view) {
                        LogoutActivity.this.showVipAchievement();
                    }
                });
            }
            this.O0000OoO.O000000o(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass8 */

                public final void onClick(View view) {
                    LogoutActivity.this.mWXBindingSwitch.performClick();
                    if (LogoutActivity.this.mWXBindingSwitch.isChecked()) {
                        LogoutActivity.this.bindWechat();
                    } else {
                        LogoutActivity.this.unbindWechat();
                    }
                }
            });
            this.mWXBindingSwitch.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass9 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        LogoutActivity.this.bindWechat();
                    } else {
                        LogoutActivity.this.unbindWechat();
                    }
                }
            });
        } else {
            this.O0000Ooo.O000000o(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass10 */

                public final void onClick(View view) {
                    LogoutActivity.this.mFBBindingSwitch.performClick();
                    if (LogoutActivity.this.mFBBindingSwitch.isChecked()) {
                        LogoutActivity.this.bindFB();
                    } else {
                        LogoutActivity.this.unbindFB();
                    }
                }
            });
            this.mFBBindingSwitch.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass11 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        LogoutActivity.this.bindFB();
                    } else {
                        LogoutActivity.this.unbindFB();
                    }
                }
            });
        }
        this.O0000oOo = new gqz(this, this.O0000oo0);
        this.O00oOooO = this.O00000o0.nextLong();
        this.O00oOooo = new BroadcastReceiver() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass23 */

            public final void onReceive(Context context, Intent intent) {
                LogoutActivity.this.showProgressDialog(true);
                LogoutActivity.this.processLogout();
                fta fta = fta.O000000o.f17086O000000o;
                fta.O000000o((int) R.string.mi_validate_relogin);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("login_need_relogin");
        ft.O000000o(this).O000000o(this.O00oOooo, intentFilter);
    }

    public void onResume() {
        super.onResume();
        if (this.O0000ooo) {
            this.O0000ooo = false;
            XQProgressDialog xQProgressDialog = this.O0000ooO;
            if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
                this.O0000ooO.dismiss();
                initWXBound(false);
            }
        }
    }

    public void setVipInfo() {
        updateVipUserInfo();
        updateVipAchievementList();
    }

    public void updateVipUserInfo() {
        this.O0000o0.O00000o0(8);
        this.O0000O0o.O00000o0(8);
        this.O0000o0.O00000o0(8);
    }

    public void updateVipAchievementList() {
        ImageView[] imageViewArr = {(SimpleDraweeView) findViewById(R.id.usr_achievement_icon_1), (SimpleDraweeView) findViewById(R.id.usr_achievement_icon_2), (SimpleDraweeView) findViewById(R.id.usr_achievement_icon_3), (SimpleDraweeView) findViewById(R.id.usr_achievement_icon_4)};
        ImageView[] imageViewArr2 = {(SimpleDraweeView) findViewById(R.id.usr_achievement_icon_1_lock), (SimpleDraweeView) findViewById(R.id.usr_achievement_icon_2_lock), (SimpleDraweeView) findViewById(R.id.usr_achievement_icon_3_lock), (SimpleDraweeView) findViewById(R.id.usr_achievement_icon_4_lock)};
        if (this.mAchievementList != null) {
            int i = 0;
            while (i < 4 && i < this.mAchievementList.size()) {
                VipAchievement vipAchievement = this.mAchievementList.get(i);
                if (!(vipAchievement == null || imageViewArr[i] == null)) {
                    if (!TextUtils.isEmpty(vipAchievement.url)) {
                        imageViewArr[i].setImageURI(Uri.parse(vipAchievement.url));
                    }
                    imageViewArr2[i].setVisibility(vipAchievement.isOwned ? 8 : 0);
                    if (!vipAchievement.isOwned) {
                        imageViewArr2[i].setImageURI(Uri.parse("http://file.market.xiaomi.com/download/MiVip/0af465f08ba2c7effc250527f44bacd767340264c"));
                        if (imageViewArr2[i].getVisibility() != 0) {
                            imageViewArr2[i].setVisibility(0);
                        }
                    } else {
                        imageViewArr2[i].setVisibility(8);
                    }
                }
                i++;
            }
            return;
        }
        this.O0000OOo.O00000o0(8);
    }

    private void O000000o() {
        gty.O000000o().queryWxBind(new ibh<Boolean, Error>() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass31 */

            public final void onFailure(Error error) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                LogoutActivity.this.initWXBound(((Boolean) obj).booleanValue());
            }
        });
    }

    private void O00000Oo() {
        gty.O000000o().queryFacebookBind(new ibh<Boolean, Error>() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass32 */

            public final void onFailure(Error error) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                LogoutActivity.this.initFBBound(((Boolean) obj).booleanValue());
            }
        });
    }

    public void initWXBound(boolean z) {
        if (z) {
            this.mWXBindingSwitch.setChecked(true);
            this.O0000OoO.O00000Oo(R.string.account_bound);
            return;
        }
        this.mWXBindingSwitch.setChecked(false);
        this.O0000OoO.O00000Oo(R.string.account_unbound);
    }

    public void initFBBound(boolean z) {
        if (z) {
            this.mFBBindingSwitch.setChecked(true);
            this.O0000Ooo.O00000Oo(R.string.account_bound);
            return;
        }
        this.mFBBindingSwitch.setChecked(false);
        this.O0000Ooo.O00000Oo(R.string.account_unbound);
    }

    public String encodePhone(String str) {
        return O000000o(str, 3, 2);
    }

    public String encodeEmail(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = Pattern.compile("([\\S]*)@([\\S]*).com").matcher(str);
        if (!matcher.find() || matcher.groupCount() != 2) {
            return str;
        }
        return String.format("%s@%s.com", O000000o(matcher.group(1), 2, 1), O000000o(matcher.group(2), 1, 0));
    }

    static class O000000o extends ftt<ShareUserRecord> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<LogoutActivity> f7619O000000o;

        public final /* synthetic */ void O000000o(Object obj) {
            ShareUserRecord shareUserRecord = (ShareUserRecord) obj;
            LogoutActivity logoutActivity = this.f7619O000000o.get();
            if (logoutActivity != null && logoutActivity.isValid()) {
                logoutActivity.mUserRecord = shareUserRecord;
                logoutActivity.mUserName = gqb.O0000O0o(shareUserRecord.nickName);
                logoutActivity.mNameContainer.O000000o(logoutActivity.mUserName);
                logoutActivity.mUidContainer.O000000o(shareUserRecord.userId);
                gyl.O000000o();
                gyl.O00000Oo(shareUserRecord.url, logoutActivity.mHeadContainer.O00000Oo, new gny());
                if (!TextUtils.isEmpty(shareUserRecord.phone)) {
                    logoutActivity.mPhoneContainer.O000000o(logoutActivity.encodePhone(shareUserRecord.phone));
                    logoutActivity.mPhoneContainer.O00000o0(0);
                } else {
                    logoutActivity.mPhoneContainer.O00000o0(8);
                }
                if (!TextUtils.isEmpty(shareUserRecord.email)) {
                    logoutActivity.mEmailContainer.O000000o(logoutActivity.encodeEmail(shareUserRecord.email));
                    logoutActivity.mEmailContainer.O00000o0(0);
                } else {
                    logoutActivity.mEmailContainer.O00000o0(8);
                }
                logoutActivity.mPwdContainer.O00000o0();
                logoutActivity.mBigHeadUrl = shareUserRecord.url;
                ft.O000000o(logoutActivity).O000000o(new Intent("action_user_info_updated"));
            }
        }

        public O000000o(LogoutActivity logoutActivity) {
            this.f7619O000000o = new WeakReference<>(logoutActivity);
        }

        public final void O000000o(int i) {
            LogoutActivity logoutActivity = this.f7619O000000o.get();
            if (logoutActivity != null && logoutActivity.isValid()) {
                logoutActivity.mUserName = "";
                logoutActivity.mNameContainer.O00000Oo(R.string.not_set);
                logoutActivity.mUidContainer.O000000o("");
            }
        }

        public final void O000000o(int i, Object obj) {
            LogoutActivity logoutActivity = this.f7619O000000o.get();
            if (logoutActivity != null && logoutActivity.isValid()) {
                logoutActivity.mUserName = "";
                logoutActivity.mNameContainer.O00000Oo(R.string.not_set);
                logoutActivity.mUidContainer.O000000o("");
            }
        }
    }

    public void refreshUIByReloadingUserInfo() {
        gyl.O000000o().O000000o(new O000000o(this));
    }

    public void bindWechat() {
        startActivityForResult(new Intent(this.O0000oo, BindWxActivity.class), 102);
    }

    public void unbindWechat() {
        new MLAlertDialog.Builder(this).O000000o((int) R.string.account_unbind_alert_title).O00000Oo((int) R.string.account_unbind_alert_msg_wx).O000000o((int) R.string.account_unbind_alert_unbind, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass15 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                LogoutActivity.this.doUnbindWechat();
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass14 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                LogoutActivity.this.initWXBound(true);
            }
        }).O000000o(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass13 */

            public final void onCancel(DialogInterface dialogInterface) {
                LogoutActivity.this.initWXBound(true);
            }
        }).O00000oo();
    }

    public void doUnbindWechat() {
        gor.O000000o(new AsyncTask<Void, Void, Boolean>() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass16 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                Boolean bool = (Boolean) obj;
                super.onPostExecute(bool);
                if (!bool.booleanValue()) {
                    fta fta = fta.O000000o.f17086O000000o;
                    fta.O000000o((int) R.string.account_unbind_failed);
                }
                LogoutActivity.this.initWXBound(!bool.booleanValue());
            }

            private Boolean O000000o() {
                new efk(LogoutActivity.this);
                try {
                    final eez O000000o2 = eez.O000000o(LogoutActivity.this.getApplicationContext(), "passportapi");
                    return Boolean.valueOf(efk.O000000o("WEIXIN", O000000o2, new efk.O00000o0() {
                        /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass16.AnonymousClass1 */

                        public final void O000000o() {
                            O000000o2.O000000o(LogoutActivity.this.getApplicationContext());
                        }
                    }));
                } catch (IOException e) {
                    e.printStackTrace();
                    return Boolean.FALSE;
                }
            }
        }, new Void[0]);
    }

    public void bindFB() {
        this.O0000oOO = true;
        startActivityForResult(new Intent(this.O0000oo, BindFbActivity.class), 103);
    }

    public void unbindFB() {
        new MLAlertDialog.Builder(this).O000000o((int) R.string.account_unbind_alert_title).O00000Oo((int) R.string.account_unbind_alert_msg_fb).O000000o((int) R.string.account_unbind_alert_unbind, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass19 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                LogoutActivity.this.doUnbindFB();
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass18 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                LogoutActivity.this.initFBBound(true);
            }
        }).O000000o(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass17 */

            public final void onCancel(DialogInterface dialogInterface) {
                LogoutActivity.this.initFBBound(true);
            }
        }).O00000oo();
    }

    public void doUnbindFB() {
        gor.O000000o(new AsyncTask<Void, Void, Boolean>() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass20 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                Boolean bool = (Boolean) obj;
                super.onPostExecute(bool);
                if (!bool.booleanValue()) {
                    fta fta = fta.O000000o.f17086O000000o;
                    fta.O000000o((int) R.string.account_unbind_failed);
                }
                LogoutActivity.this.initFBBound(!bool.booleanValue());
            }

            private Boolean O000000o() {
                new efk(LogoutActivity.this);
                try {
                    final eez O000000o2 = eez.O000000o(LogoutActivity.this.getApplicationContext(), "passportapi");
                    return Boolean.valueOf(efk.O000000o("FB", O000000o2, new efk.O00000o0() {
                        /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass20.AnonymousClass1 */

                        public final void O000000o() {
                            O000000o2.O000000o(LogoutActivity.this.getApplicationContext());
                        }
                    }));
                } catch (IOException e) {
                    e.printStackTrace();
                    return Boolean.FALSE;
                }
            }
        }, new Void[0]);
    }

    public void startChangePwdActivity() {
        String str;
        String O0000o02 = CoreApi.O000000o().O0000o0();
        Locale O00oOooo2 = CoreApi.O000000o().O00oOooo();
        if (O00oOooo2 == null) {
            O00oOooo2 = Locale.getDefault();
        }
        fbt fbt = new fbt(this, "LoginH5HomeAcvtivity");
        fbt.O000000o("common_web_title", getApplicationContext().getString(R.string.label_account_security));
        if (TextUtils.isEmpty(O0000o02)) {
            str = "https://account.xiaomi.com/pass/auth/security/home";
        } else {
            String locale = O00oOooo2.toString();
            if ("zh".equalsIgnoreCase(O00oOooo2.getLanguage()) && "CN".equalsIgnoreCase(O00oOooo2.getCountry())) {
                locale = Locale.CHINA.toString();
            }
            str = "https://account.xiaomi.com/pass/auth/security/home?_locale=" + locale + "&userId=" + O0000o02;
        }
        fbt.O000000o("common_web_url", str);
        fbs.O000000o(fbt);
    }

    public void refreshAndChangeHeadIcon(final String str) {
        gor.O000000o(new AsyncTask<Object, Object, String>() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass21 */

            /* access modifiers changed from: protected */
            public final void onPreExecute() {
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                if (!TextUtils.isEmpty((String) obj)) {
                    izb.O000000o(LogoutActivity.this, (int) R.string.change_head_success, 0).show();
                    LogoutActivity.this.refreshUIByReloadingUserInfo();
                    return;
                }
                izb.O000000o(LogoutActivity.this, (int) R.string.change_head_fail, 0).show();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                if (decodeFile == null) {
                    return "";
                }
                String uploadXiaomiUserIcon = LogoutActivity.this.uploadXiaomiUserIcon(decodeFile);
                if (TextUtils.isEmpty(uploadXiaomiUserIcon) || decodeFile == null || decodeFile.isRecycled()) {
                    return uploadXiaomiUserIcon;
                }
                decodeFile.recycle();
                return uploadXiaomiUserIcon;
            }
        }, new Object[0]);
    }

    public String uploadXiaomiUserIcon(Bitmap bitmap) {
        try {
            String O0000o02 = CoreApi.O000000o().O0000o0();
            String O0000o2 = CoreApi.O000000o().O0000o();
            MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o("passportapi");
            return XMPassport.uploadXiaomiUserIcon(O0000o02, O0000o2, "xiaomiio", O000000o2.O00000o0, O000000o2.O00000o, bitmap);
        } catch (Exception e) {
            gsy.O00000o0(LogType.LOGIN, "", e.getMessage());
            return "";
        }
    }

    public void showProgressDialog(boolean z) {
        if (z) {
            if (this.O0000oO0 == null) {
                this.O0000oO0 = new XQProgressDialog(this);
                this.O0000oO0.setMessage(getString(R.string.login_passport_logouting));
                this.O0000oO0.setCancelable(true);
                this.O0000oO0.setDismissCallBack(new MLAlertDialog.O000000o() {
                    /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass22 */

                    public final void beforeDismissCallBack() {
                    }

                    public final void afterDismissCallBack() {
                        H h;
                        if (LogoutActivity.this.O00000Oo) {
                            if (LogoutActivity.this.f7581O000000o != null) {
                                icc icc = LogoutActivity.this.f7581O000000o;
                                if (icc.f1172O000000o != null && (h = icc.f1172O000000o.get()) != null && !(h instanceof icc.O000000o) && (h instanceof Call)) {
                                    ((Call) h).cancel();
                                }
                            }
                            LogoutActivity logoutActivity = LogoutActivity.this;
                            logoutActivity.O00000Oo = false;
                            logoutActivity.f7581O000000o = null;
                        }
                    }
                });
            }
            if (!this.O0000oO0.isShowing()) {
                this.O0000oO0.show();
                return;
            }
            return;
        }
        XQProgressDialog xQProgressDialog = this.O0000oO0;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O0000oO0.dismiss();
        }
    }

    public void showLogoutDialog() {
        if (this.O0000o0O == null) {
            this.O0000o0O = new MLAlertDialog.Builder(this).O000000o((int) R.string.setting_logout).O00000o0().O00000Oo(getResources().getString(R.string.setting_logout_message)).O000000o((int) R.string.ok_button, this.O0000oO).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000o();
        }
        this.O0000o0O.show();
    }

    public void showChangeNameDialog() {
        if (this.O0000o0o == null) {
            final ClientRemarkInputView clientRemarkInputView = (ClientRemarkInputView) LayoutInflater.from(this).inflate((int) R.layout.client_remark_input_view, (ViewGroup) null);
            this.O0000o0o = new MLAlertDialog.Builder(this).O000000o((int) R.string.input_nick_name).O000000o(clientRemarkInputView).O00000Oo(false).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass25 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (clientRemarkInputView.getInputText().length() > 20) {
                        izb.O000000o(LogoutActivity.this, (int) R.string.nick_too_long, 0).show();
                    } else {
                        clientRemarkInputView.O000000o(dialogInterface);
                    }
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass24 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                }
            }).O00000o();
            $$Lambda$LogoutActivity$52L9PrSXEe4IwfyL2JOGAwoAWjw r2 = new ClientRemarkInputView.O000000o() {
                /* class com.xiaomi.smarthome.framework.login.ui.$$Lambda$LogoutActivity$52L9PrSXEe4IwfyL2JOGAwoAWjw */

                public final void modifyBackName(String str) {
                    LogoutActivity.this.O000000o(str);
                }
            };
            MLAlertDialog mLAlertDialog = this.O0000o0o;
            String str = this.mUserName;
            clientRemarkInputView.O000000o(r2, mLAlertDialog, str, str);
        }
        this.O0000o0o.show();
        View view = this.O0000o0o.getView();
        if (view instanceof ClientRemarkInputView) {
            final ClientRemarkInputView clientRemarkInputView2 = (ClientRemarkInputView) view;
            clientRemarkInputView2.setInputText(this.mUserName);
            clientRemarkInputView2.setHint(this.mUserName);
            clientRemarkInputView2.setLimitSize(10);
            final EditText editText = clientRemarkInputView2.getEditText();
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(21)});
            final Button button = this.O0000o0o.getButton(-1);
            button.setEnabled(false);
            button.setTextColor(getResources().getColor(R.color.mj_color_dialog_button1_bg_nor));
            editText.addTextChangedListener(new TextWatcher() {
                /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass26 */

                public final void afterTextChanged(Editable editable) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    clientRemarkInputView2.setAlertText("");
                    button.setEnabled(true);
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    String obj = editText.getText().toString();
                    if (obj.length() > 0) {
                        if (gqb.O00000o0(obj)) {
                            clientRemarkInputView2.setAlertText(LogoutActivity.this.getString(R.string.tag_save_data_description));
                        } else if (gqb.O000000o((CharSequence) obj) > 20) {
                            clientRemarkInputView2.setAlertText(LogoutActivity.this.getString(R.string.room_name_too_long));
                        } else {
                            clientRemarkInputView2.setAlertText("");
                            button.setEnabled(true);
                            return;
                        }
                    }
                    button.setEnabled(false);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(final String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.mUserName)) {
            gor.O000000o(new AsyncTask<Object, Object, Boolean>() {
                /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass27 */

                /* access modifiers changed from: protected */
                public final void onPreExecute() {
                }

                /* access modifiers changed from: protected */
                public final /* synthetic */ Object doInBackground(Object[] objArr) {
                    return O000000o();
                }

                /* access modifiers changed from: protected */
                public final /* synthetic */ void onPostExecute(Object obj) {
                    if (((Boolean) obj).booleanValue()) {
                        izb.O000000o(LogoutActivity.this, (int) R.string.change_nick_success, 0).show();
                        LogoutActivity.this.refreshUIByReloadingUserInfo();
                        return;
                    }
                    izb.O000000o(LogoutActivity.this, (int) R.string.change_nick_fail, 0).show();
                }

                private Boolean O000000o() {
                    try {
                        String O0000o0 = CoreApi.O000000o().O0000o0();
                        String O0000o = CoreApi.O000000o().O0000o();
                        MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o("passportapi");
                        XMPassport.uploadXiaomiUserName(O0000o0, O0000o, "xiaomiio", O000000o2.O00000o0, O000000o2.O00000o, str);
                        LogoutActivity.this.mUserName = str;
                        return Boolean.TRUE;
                    } catch (Exception e) {
                        gsy.O00000o0(LogType.LOGIN, "", e.getMessage());
                        return Boolean.FALSE;
                    }
                }
            }, new Object[0]);
        }
    }

    public void uploadXiaomiUserGender(final Gender gender) {
        gor.O000000o(new AsyncTask<Object, Object, Boolean>() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass28 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    izb.O000000o(LogoutActivity.this, (int) R.string.change_sex_success, 0).show();
                    LogoutActivity.this.refreshUIByReloadingUserInfo();
                    return;
                }
                izb.O000000o(LogoutActivity.this, (int) R.string.change_sex_fail, 0).show();
            }

            private Boolean O000000o() {
                try {
                    String O0000o0 = CoreApi.O000000o().O0000o0();
                    String O0000o = CoreApi.O000000o().O0000o();
                    MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o("passportapi");
                    XMPassport.uploadXiaomiUserGender(O0000o0, O0000o, "xiaomiio", O000000o2.O00000o0, O000000o2.O00000o, gender);
                    return Boolean.TRUE;
                } catch (Exception e) {
                    gsy.O00000o0(LogType.LOGIN, "", e.getMessage());
                    return Boolean.FALSE;
                }
            }
        }, new Object[0]);
    }

    public void uploadXiaomiUserBirth(final Calendar calendar) {
        gor.O000000o(new AsyncTask<Object, Object, Boolean>() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass29 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    izb.O000000o(LogoutActivity.this, (int) R.string.change_birth_success, 0).show();
                    LogoutActivity.this.refreshUIByReloadingUserInfo();
                    return;
                }
                izb.O000000o(LogoutActivity.this, (int) R.string.change_birth_fail, 0).show();
            }

            private Boolean O000000o() {
                try {
                    String O0000o0 = CoreApi.O000000o().O0000o0();
                    String O0000o = CoreApi.O000000o().O0000o();
                    MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o("passportapi");
                    XMPassport.uploadXiaomiUserBirthday(O0000o0, O0000o, "xiaomiio", O000000o2.O00000o0, O000000o2.O00000o, calendar);
                    return Boolean.TRUE;
                } catch (Exception e) {
                    gsy.O00000o0(LogType.LOGIN, "", e.getMessage());
                    return Boolean.FALSE;
                }
            }
        }, new Object[0]);
    }

    public void processSelectHead(int i) {
        File externalCacheDir;
        if (i == 0) {
            gqz gqz = this.O0000oOo;
            File file = null;
            if (!(!Environment.getExternalStorageState().equals("mounted")) && (externalCacheDir = gqz.f18169O000000o.getExternalCacheDir()) != null) {
                if (externalCacheDir.isDirectory() || externalCacheDir.mkdirs()) {
                    gpg.O000000o(externalCacheDir);
                }
                file = new File(externalCacheDir, "images");
                if (file.isDirectory() || file.mkdirs()) {
                    gpg.O000000o(file);
                }
            }
            gqz.O00000Oo = gqz.O000000o(file, DateFormat.format("yyyyMMdd", System.currentTimeMillis()).toString() + ".jpg");
            fwq.O000000o(gqz.f18169O000000o, true, new inc() {
                /* class _m_j.gqz.AnonymousClass1 */

                public final void onAction(List<String> list) {
                    Activity activity = gqz.this.f18169O000000o;
                    String str = gqz.this.O00000Oo;
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", Uri.fromFile(new File(str)));
                    if (!gqz.O000000o(activity, intent)) {
                        izb.O000000o(activity, (int) R.string.unsupported_intent, 0).show();
                    } else {
                        activity.startActivityForResult(intent, 140);
                    }
                }
            });
        } else if (i == 1) {
            gqz gqz2 = this.O0000oOo;
            Intent intent = new Intent();
            intent.setType("image/jpeg");
            intent.setAction("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (!gqz.O000000o(gqz2.f18169O000000o, intent)) {
                izb.O000000o(gqz2.f18169O000000o, (int) R.string.unsupported_intent, 0).show();
            } else {
                gqz2.f18169O000000o.startActivityForResult(intent, 130);
            }
        }
    }

    public void processLogout() {
        CoreApi.O000000o().O0000Ooo();
        this.f7581O000000o = gty.O000000o().logout(new ibh<Void, Error>() {
            /* class com.xiaomi.smarthome.framework.login.ui.LogoutActivity.AnonymousClass30 */

            public final void onFailure(Error error) {
                LogoutActivity logoutActivity = LogoutActivity.this;
                logoutActivity.O00000Oo = false;
                logoutActivity.showProgressDialog(false);
                izb.O000000o(LogoutActivity.this, (int) R.string.status_error_cable_not_plugin_body, 0).show();
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                CrashReport.O000000o("");
                LogoutActivity logoutActivity = LogoutActivity.this;
                logoutActivity.O00000Oo = false;
                logoutActivity.showProgressDialog(false);
                LogoutActivity.this.finish();
                PluginApi.getInstance().exitProcess(RunningProcess.PLUGIN0);
                PluginApi.getInstance().exitProcess(RunningProcess.PLUGIN1);
                PluginApi.getInstance().exitProcess(RunningProcess.PLUGIN2);
                PluginApi.getInstance().exitProcess(RunningProcess.PLUGIN3);
                PluginRuntimeManager.getInstance().exitAllFrameProcess();
                PluginApi.getInstance().exitProcess(RunningProcess.CAMERA);
            }
        }, "LogoutActivity#processLogout");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 102) {
            if (i2 == -1) {
                initWXBound(true);
            } else {
                initWXBound(false);
            }
            O000000o();
        } else if (i == 103) {
            if (i2 == -1) {
                initFBBound(true);
            } else {
                initFBBound(false);
            }
            O00000Oo();
        }
        if (!this.O0000oOO) {
            gqz gqz = this.O0000oOo;
            if (i2 != -1) {
                return;
            }
            if (i == 130) {
                gqz.O000000o(intent.getData());
            } else if (i == 140) {
                if (!TextUtils.isEmpty(gqz.O00000Oo)) {
                    File file = new File(gqz.O00000Oo);
                    if (file.isFile()) {
                        gqz.O000000o(Uri.fromFile(file));
                    } else if (intent != null) {
                        gqz.O000000o(intent.getData());
                    }
                }
            } else if (i == 150 && !TextUtils.isEmpty(gqz.O00000o0)) {
                File file2 = new File(gqz.O00000o0);
                if (file2.isFile() && file2.exists() && gqz.O00000o != null) {
                    gqz.O00000o.O000000o(gqz.O00000o0);
                }
            }
        }
    }

    public void showVipLevel() {
        if (ftw.O000000o() != null) {
            ftw.O000000o().O000000o(this);
        }
    }

    public void showVipAchievement() {
        if (ftw.O000000o() != null) {
            ftw.O000000o().O00000Oo(this);
        }
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        View f7620O000000o;
        SimpleDraweeView O00000Oo;
        private ImageView O00000o;
        private TextView O00000oO;
        private TextView O00000oo;

        /* synthetic */ O00000Oo(LogoutActivity logoutActivity, View view, int i, byte b) {
            this(view, i);
        }

        private O00000Oo(View view, int i) {
            this.f7620O000000o = view;
            View view2 = this.f7620O000000o;
            if (view2 != null) {
                if (view2 instanceof ListItemView) {
                    ((ListItemView) view2).setPosition(i);
                }
                this.O00000o = (ImageView) this.f7620O000000o.findViewById(R.id.arrow);
                this.O00000Oo = (SimpleDraweeView) this.f7620O000000o.findViewById(R.id.icon);
                this.O00000oO = (TextView) this.f7620O000000o.findViewById(R.id.title);
                this.O00000oo = (TextView) this.f7620O000000o.findViewById(R.id.subtitle);
            }
        }

        public final void O000000o() {
            if (this.f7620O000000o != null) {
                this.O00000o.setVisibility(8);
                ((LinearLayout.LayoutParams) this.O00000oo.getLayoutParams()).rightMargin = (int) LogoutActivity.this.getResources().getDimension(R.dimen.std_list_content_margin_right);
                this.f7620O000000o.requestLayout();
            }
        }

        public final void O00000Oo() {
            View view = this.f7620O000000o;
            if (view != null) {
                view.setFocusable(true);
            }
        }

        public final void O00000o0() {
            if (this.f7620O000000o != null) {
                this.O00000oo.setVisibility(8);
            }
        }

        public final void O000000o(int i) {
            if (this.f7620O000000o != null) {
                this.O00000oO.setText(i);
            }
        }

        public final void O000000o(String str) {
            if (this.f7620O000000o != null) {
                this.O00000oo.setText(str);
            }
        }

        public final void O00000Oo(int i) {
            if (this.f7620O000000o != null) {
                this.O00000oo.setText(i);
            }
        }

        public final void O000000o(View.OnClickListener onClickListener) {
            View view = this.f7620O000000o;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }

        public final void O00000o0(int i) {
            View view = this.f7620O000000o;
            if (view != null) {
                view.setVisibility(i);
            }
        }

        public final View O00000o(int i) {
            View view = this.f7620O000000o;
            if (view == null) {
                return null;
            }
            return view.findViewById(i);
        }
    }

    private static void O000000o(Dialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        O000000o(this.O0000o0O);
        O000000o(this.O0000o0o);
        O000000o(this.O0000o);
        O000000o(this.O0000oO0);
        ft.O000000o(this).O000000o(this.O00oOooo);
    }
}

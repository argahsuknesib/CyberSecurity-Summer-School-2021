package com.xiaomi.smarthome.framework.page.privacyandlicense;

import _m_j.gnr;
import _m_j.gwc;
import _m_j.hxi;
import _m_j.hyy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.utils.DialogBase;

public final class UserLicenseDialog {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f7867O000000o;
    public String O00000Oo;
    public Spanned O00000o;
    public String O00000o0;
    public Spanned O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    TextView O0000Oo;
    public String O0000Oo0;
    public Context O0000OoO;
    public View.OnClickListener O0000Ooo;
    public int O0000o;
    public O000000o O0000o0;
    public View O0000o00;
    public String O0000o0O;
    public int O0000o0o;
    public Intent O0000oO0;

    class O00000Oo extends ClickableSpan {
        public void onClick(View view) {
        }

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(UserLicenseDialog userLicenseDialog, byte b) {
            this();
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#527acc"));
            textPaint.setUnderlineText(false);
        }
    }

    public final void O000000o() {
        if (this.O0000o0 == null) {
            this.O0000o0 = new O000000o(this.O0000OoO);
            this.O0000o0.setCancelable(false);
            this.O0000o0.show();
        }
    }

    class O000000o extends DialogBase {
        public O000000o(Context context) {
            super(context, 2132739282);
        }

        /* access modifiers changed from: protected */
        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            Window window = getWindow();
            if (window != null) {
                window.requestFeature(1);
                window.setBackgroundDrawableResource(17170445);
            }
            UserLicenseDialog userLicenseDialog = UserLicenseDialog.this;
            userLicenseDialog.O0000o00 = LayoutInflater.from(userLicenseDialog.O0000OoO.getApplicationContext()).inflate((int) R.layout.dialog_user_license, (ViewGroup) null);
            UserLicenseDialog userLicenseDialog2 = UserLicenseDialog.this;
            if (!TextUtils.isEmpty(userLicenseDialog2.f7867O000000o)) {
                ((TextView) userLicenseDialog2.O0000o00.findViewById(R.id.dialog_title)).setText(userLicenseDialog2.f7867O000000o);
            }
            if (TextUtils.isEmpty(userLicenseDialog2.O00000Oo) || TextUtils.isEmpty(userLicenseDialog2.O00000o0)) {
                String str = TextUtils.isEmpty(userLicenseDialog2.O00000Oo) ? userLicenseDialog2.O00000o0 : userLicenseDialog2.O00000Oo;
                String trim = str.trim();
                TextUtils.isEmpty(userLicenseDialog2.O00000Oo);
                userLicenseDialog2.O0000Oo = (TextView) userLicenseDialog2.O0000o00.findViewById(R.id.user_license_title);
                String O000000o2 = gwc.O000000o((int) R.string.have_read, trim.trim());
                int indexOf = O000000o2.indexOf(trim);
                int length = trim.length() + indexOf;
                SpannableString spannableString = new SpannableString(O000000o2);
                spannableString.setSpan(new ForegroundColorSpan(userLicenseDialog2.O0000OoO.getApplicationContext().getResources().getColor(R.color.mj_color_gray_normal)), 0, indexOf, 33);
                spannableString.setSpan(new ForegroundColorSpan(userLicenseDialog2.O0000OoO.getApplicationContext().getResources().getColor(R.color.mj_color_gray_normal)), length, O000000o2.length(), 33);
                spannableString.setSpan(new O00000Oo(str) {
                    /* class com.xiaomi.smarthome.framework.page.privacyandlicense.UserLicenseDialog.AnonymousClass3 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String f7870O000000o;

                    {
                        this.f7870O000000o = r2;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent(UserLicenseDialog.this.O0000OoO, PluginLicenseActivity.class);
                        if (!TextUtils.isEmpty(UserLicenseDialog.this.O0000Oo0)) {
                            intent.putExtra("license_html_content", UserLicenseDialog.this.O0000Oo0);
                        } else if (!TextUtils.isEmpty(UserLicenseDialog.this.O0000O0o)) {
                            intent.putExtra("license_uri", UserLicenseDialog.this.O0000O0o);
                        } else {
                            intent.putExtra("license_content", UserLicenseDialog.this.O00000oO);
                        }
                        intent.putExtra("title", this.f7870O000000o);
                        UserLicenseDialog.this.O0000OoO.startActivity(intent);
                    }
                }, indexOf, length, 33);
                userLicenseDialog2.O0000Oo.setMovementMethod(LinkMovementMethod.getInstance());
                userLicenseDialog2.O0000Oo.setText(spannableString);
            } else {
                String trim2 = userLicenseDialog2.O00000Oo.trim();
                String trim3 = userLicenseDialog2.O00000o0.trim();
                userLicenseDialog2.O0000Oo = (TextView) userLicenseDialog2.O0000o00.findViewById(R.id.user_license_title);
                String O000000o3 = gwc.O000000o((int) R.string.have_read_and, trim2, trim3);
                SpannableString spannableString2 = new SpannableString(O000000o3);
                int indexOf2 = O000000o3.indexOf(trim2);
                int length2 = trim2.length() + indexOf2;
                int indexOf3 = O000000o3.indexOf(trim3);
                int length3 = trim3.length() + indexOf3;
                spannableString2.setSpan(new ForegroundColorSpan(userLicenseDialog2.O0000OoO.getApplicationContext().getResources().getColor(R.color.mj_color_gray_normal)), 0, indexOf2, 33);
                spannableString2.setSpan(new ForegroundColorSpan(userLicenseDialog2.O0000OoO.getApplicationContext().getResources().getColor(R.color.mj_color_gray_normal)), length2, indexOf3, 33);
                spannableString2.setSpan(new ForegroundColorSpan(userLicenseDialog2.O0000OoO.getApplicationContext().getResources().getColor(R.color.mj_color_gray_normal)), length3, O000000o3.length(), 33);
                spannableString2.setSpan(new O00000Oo() {
                    /* class com.xiaomi.smarthome.framework.page.privacyandlicense.UserLicenseDialog.AnonymousClass1 */

                    public final void onClick(View view) {
                        Intent intent = new Intent(UserLicenseDialog.this.O0000OoO, PluginLicenseActivity.class);
                        intent.putExtra("title", UserLicenseDialog.this.O00000Oo);
                        if (!TextUtils.isEmpty(UserLicenseDialog.this.O0000OOo)) {
                            intent.putExtra("license_html_content", UserLicenseDialog.this.O0000OOo);
                        } else if (!TextUtils.isEmpty(UserLicenseDialog.this.O00000oo)) {
                            intent.putExtra("license_uri", UserLicenseDialog.this.O00000oo);
                        } else if (UserLicenseDialog.this.O0000o0o > 0) {
                            intent.putExtra("license_html_content_res", UserLicenseDialog.this.O0000o0o);
                        } else {
                            intent.putExtra("license_content", UserLicenseDialog.this.O00000o);
                        }
                        UserLicenseDialog.this.O0000OoO.startActivity(intent);
                    }
                }, indexOf2, length2, 33);
                spannableString2.setSpan(new O00000Oo() {
                    /* class com.xiaomi.smarthome.framework.page.privacyandlicense.UserLicenseDialog.AnonymousClass2 */

                    public final void onClick(View view) {
                        Intent intent = new Intent(UserLicenseDialog.this.O0000OoO, PluginLicenseActivity.class);
                        intent.putExtra("title", UserLicenseDialog.this.O00000o0);
                        if (!TextUtils.isEmpty(UserLicenseDialog.this.O0000Oo0)) {
                            intent.putExtra("license_html_content", UserLicenseDialog.this.O0000Oo0);
                        } else if (!TextUtils.isEmpty(UserLicenseDialog.this.O0000O0o)) {
                            intent.putExtra("license_uri", UserLicenseDialog.this.O0000O0o);
                        } else if (UserLicenseDialog.this.O0000o > 0) {
                            intent.putExtra("license_html_content_res", UserLicenseDialog.this.O0000o);
                        } else {
                            intent.putExtra("license_content", UserLicenseDialog.this.O00000oO);
                        }
                        UserLicenseDialog.this.O0000OoO.startActivity(intent);
                    }
                }, indexOf3, length3, 33);
                userLicenseDialog2.O0000Oo.setMovementMethod(LinkMovementMethod.getInstance());
                userLicenseDialog2.O0000Oo.setText(spannableString2);
            }
            Button button = (Button) userLicenseDialog2.O0000o00.findViewById(R.id.cancel);
            Button button2 = (Button) userLicenseDialog2.O0000o00.findViewById(R.id.agree);
            button.setText(gwc.O000000o((int) R.string.sh_common_cancel));
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.UserLicenseDialog.AnonymousClass4 */

                public final void onClick(View view) {
                    UserLicenseDialog.this.O0000o0.dismiss();
                    ((Activity) UserLicenseDialog.this.O0000OoO).finish();
                }
            });
            button2.setText(gwc.O000000o((int) R.string.agree_go_on));
            button2.setOnClickListener(new View.OnClickListener(button2) {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.UserLicenseDialog.AnonymousClass5 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Button f7872O000000o;

                {
                    this.f7872O000000o = r2;
                }

                public final void onClick(View view) {
                    if (UserLicenseDialog.this.O0000o0O != null) {
                        DeviceApi.getInstance().setUserLicenseConfig(UserLicenseDialog.this.O0000OoO, UserLicenseDialog.this.O0000o0O, "accept", null);
                    }
                    UserLicenseDialog.this.O0000o0.dismiss();
                    if (UserLicenseDialog.this.O0000Ooo != null) {
                        UserLicenseDialog.this.O0000Ooo.onClick(this.f7872O000000o);
                    }
                    if (UserLicenseDialog.this.O0000oO0 == null ? false : UserLicenseDialog.this.O0000oO0.getBooleanExtra("enable_privacy_setting", false)) {
                        gnr.O000000o o000000o = new gnr.O000000o(UserLicenseDialog.this.O0000o0O, UserLicenseDialog.this.O0000oO0, UserLicenseDialog.this.O0000OoO);
                        o000000o.setCancelable(false);
                        o000000o.show();
                        hxi.O0000Oo.O000000o(1);
                        return;
                    }
                    hxi.O0000Oo.O000000o(2);
                }
            });
            setContentView(UserLicenseDialog.this.O0000o00);
            hyy.O000000o(UserLicenseDialog.this.O0000OoO, this, 80);
        }
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f7873O000000o;
        public Spanned O00000Oo;
        public String O00000o;
        public Spanned O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;
        public int O0000OOo;
        public View.OnClickListener O0000Oo;
        public int O0000Oo0;
        public String O0000OoO;
        public Intent O0000Ooo;
        private String O0000o0;
        private String O0000o00;
        private Context O0000o0O;

        public Builder(Context context) {
            this.O0000o0O = context;
        }

        @Deprecated
        public final Builder O000000o(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.O0000o00 = this.O0000o0O.getApplicationContext().getString(R.string.dialog_license_title);
            return this;
        }

        @Deprecated
        public final Builder O000000o() {
            this.O0000o0 = this.O0000o0O.getApplicationContext().getString(R.string.dialog_privacy_title);
            return this;
        }

        public final UserLicenseDialog O00000Oo() {
            UserLicenseDialog userLicenseDialog = new UserLicenseDialog();
            userLicenseDialog.O0000OoO = this.O0000o0O;
            userLicenseDialog.O00000Oo = this.O0000o00;
            userLicenseDialog.O00000o = this.O00000Oo;
            userLicenseDialog.O00000o0 = this.O0000o0;
            userLicenseDialog.O00000oO = this.O00000o0;
            userLicenseDialog.f7867O000000o = this.f7873O000000o;
            userLicenseDialog.O0000Ooo = this.O0000Oo;
            userLicenseDialog.O0000o0O = this.O0000OoO;
            userLicenseDialog.O0000oO0 = this.O0000Ooo;
            userLicenseDialog.O00000oo = this.O00000o;
            userLicenseDialog.O0000O0o = this.O00000oO;
            userLicenseDialog.O0000OOo = this.O00000oo;
            userLicenseDialog.O0000Oo0 = this.O0000O0o;
            userLicenseDialog.O0000o0o = this.O0000OOo;
            userLicenseDialog.O0000o = this.O0000Oo0;
            return userLicenseDialog;
        }
    }
}

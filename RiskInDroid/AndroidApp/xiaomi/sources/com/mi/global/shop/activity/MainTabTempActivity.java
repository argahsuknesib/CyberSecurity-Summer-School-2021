package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.cad;
import _m_j.cak;
import _m_j.cal;
import _m_j.cam;
import _m_j.cap;
import _m_j.cav;
import _m_j.ccn;
import _m_j.ccr;
import _m_j.ccx;
import _m_j.ced;
import _m_j.cei;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.volley.Request;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.notice.NewNoticeData;
import com.mi.global.shop.newmodel.usercenter.NewUserInfoData;
import com.mi.global.shop.newmodel.usercenter.NewUserInfoResult;
import com.xiaomi.smarthome.R;

public class MainTabTempActivity extends BaseActivity {
    public static final String TAG = "MainTabTempActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f4641O000000o = false;
    private cap O00000Oo;
    public NewUserInfoData userInfoData;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_maintabs);
    }

    public void onLogin(String str, String str2, String str3) {
        super.onLogin(str, str2, str3);
        ccr.O00000Oo(TAG, "refresh userinfo after login");
        O00000Oo();
    }

    public void onLogout() {
        super.onLogout();
        ccr.O00000Oo(TAG, "Maintab logout start");
        ccr.O00000Oo(TAG, "Maintab logout end");
    }

    public void onResume() {
        super.onResume();
        updateUnpaidBadge();
        O00000Oo();
    }

    public void onPause() {
        super.onPause();
        ccr.O00000Oo(TAG, "on Resume finish");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        byl.O0000Oo().onActivityResult(i, i2, intent);
    }

    public void startCartActivity() {
        if (cad.O00000o()) {
            startActivityForResult(new Intent(this, ShoppingCartActivity.class), 22);
            return;
        }
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("url", cav.O000OOo());
        startActivity(intent);
    }

    public void finish() {
        super.finish();
        ccx.O0000Oo0();
    }

    public void showHomeNotice(NewNoticeData newNoticeData) {
        try {
            this.O00000Oo.O000000o(newNoticeData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void O00000Oo() {
        Request request;
        if (ccn.O0000o00().O0000o0O() && !TextUtils.isEmpty(ccn.O0000o00().O00000Oo())) {
            Uri.Builder buildUpon = Uri.parse(cav.O000OoOO()).buildUpon();
            buildUpon.appendQueryParameter("mUserId", cei.O000000o(ccn.O0000o00().O00000Oo()));
            buildUpon.appendQueryParameter("cUserId", cei.O00000Oo(ccn.O0000o00().O00000Oo()));
            buildUpon.appendQueryParameter("security", "true");
            AnonymousClass1 r1 = new cak<NewUserInfoResult>() {
                /* class com.mi.global.shop.activity.MainTabTempActivity.AnonymousClass1 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    NewUserInfoResult newUserInfoResult = (NewUserInfoResult) baseResult;
                    if (newUserInfoResult.data != null) {
                        if (newUserInfoResult.data.jsonUserInfoData == null) {
                            MainTabTempActivity.this.userInfoData = newUserInfoResult.data;
                        } else {
                            MainTabTempActivity.this.userInfoData = newUserInfoResult.data.jsonUserInfoData;
                        }
                        MainTabTempActivity mainTabTempActivity = MainTabTempActivity.this;
                        mainTabTempActivity.saveAndUpdateUnpaidNum(mainTabTempActivity.userInfoData.not_pay_order_count);
                    }
                }

                public final void O000000o(String str) {
                    ccr.O00000Oo(MainTabTempActivity.TAG, "RefreshUserInfo Exception:".concat(String.valueOf(str)));
                }
            };
            if (byl.O0000OoO()) {
                request = new cam(buildUpon.toString(), NewUserInfoResult.class, r1);
            } else {
                request = new cal(buildUpon.toString(), NewUserInfoResult.class, r1);
            }
            request.setTag(TAG);
            ced.f13683O000000o.add(request);
        }
    }
}

package com.mi.global.shop.activity;

import _m_j.bxq;
import _m_j.byl;
import _m_j.bzf;
import _m_j.cav;
import _m_j.cbe;
import _m_j.cbm;
import _m_j.cbq;
import _m_j.cbw;
import _m_j.ccn;
import _m_j.ccr;
import _m_j.cdy;
import _m_j.ee;
import _m_j.ei;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.account.activity.AccountActivity;
import com.mi.global.shop.newmodel.NewPageMessage;
import com.mi.global.shop.widget.BadgeView;
import com.mi.global.shop.widget.CustomInsetsFrameLayout;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.util.Device;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AccountActivity implements ccn.O000000o {
    private static int O00000oo = 0;
    private static Method O0000O0o = null;
    public static int shoppingCartNum = -1;
    public static int statusBarHeight = 0;
    public static int unpaidNum = -1;

    /* renamed from: O000000o  reason: collision with root package name */
    private View f4584O000000o;
    private View O00000Oo;
    private CustomTextView O00000o;
    private CustomInsetsFrameLayout O00000o0;
    private CustomTextView O00000oO;
    private View O0000OOo;
    private SimpleDraweeView O0000Oo;
    private SimpleDraweeView O0000Oo0;
    private SimpleDraweeView O0000OoO;
    private ProgressDialog O0000Ooo;
    public View mBackView;
    public View mCartView;
    public CustomTextView mForgetPwd;
    public View mOrderListView;
    public BadgeView orderListCountBv;
    public BadgeView shoppingCountBv;

    public Fragment newFragmentByTag(String str) {
        return null;
    }

    public void onInvalidAuthonToken() {
    }

    public void startCartActivity() {
    }

    public void updateCartAndAccount() {
    }

    public Resources getResources() {
        if (Build.VERSION.SDK_INT >= 24) {
            return getApplicationContext().getResources();
        }
        return super.getResources();
    }

    public static void onShopActivityCreate(Activity activity) {
        if (statusBarHeight == 0 && Device.O0000o00 >= 19) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                statusBarHeight = activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (Exception unused) {
            }
        }
        Window window = activity.getWindow();
        try {
            if (O0000O0o == null) {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                O00000oo = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                O0000O0o = window.getClass().getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            }
            O0000O0o.invoke(window, Integer.valueOf(O00000oo), Integer.valueOf(O00000oo));
            if (Build.VERSION.SDK_INT >= 23 && Device.O0000o0o) {
                window.getDecorView().setSystemUiVisibility(8192);
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cdy.O000000o(android.app.Activity, float):int
     arg types: [com.mi.global.shop.activity.BaseActivity, int]
     candidates:
      _m_j.cdy.O000000o(android.content.Context, float):int
      _m_j.cdy.O000000o(android.app.Activity, float):int */
    public void onCreate(Bundle bundle) {
        setTheme(2132738855);
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "STARTUP onCreate");
        super.onCreate(bundle);
        onShopActivityCreate(this);
        setContentView((int) R.layout.shop_base_activity);
        this.O00000o0 = (CustomInsetsFrameLayout) findViewById(R.id.content_container);
        this.O00000Oo = findViewById(R.id.title_bar_container);
        this.O00000o = (CustomTextView) findViewById(R.id.title_bar_title);
        this.O00000oO = (CustomTextView) findViewById(R.id.title_mi_text);
        this.O0000OOo = findViewById(R.id.title_bar_RL);
        this.O0000Oo0 = (SimpleDraweeView) findViewById(R.id.shopping_cart);
        this.O0000Oo = (SimpleDraweeView) findViewById(R.id.iv_title_bg);
        this.O0000OoO = (SimpleDraweeView) findViewById(R.id.iv_title_icon);
        this.mCartView = findViewById(R.id.title_bar_cart_view);
        this.mCartView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.BaseActivity.AnonymousClass1 */

            public final void onClick(View view) {
                BaseActivity.this.startCartActivity();
            }
        });
        this.mOrderListView = findViewById(R.id.iv_order_list);
        this.mOrderListView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.BaseActivity.AnonymousClass2 */

            public final void onClick(View view) {
                BaseActivity.this.startAllOrderActivity();
            }
        });
        this.mBackView = findViewById(R.id.title_bar_back);
        this.mForgetPwd = (CustomTextView) findViewById(R.id.title_bar_text_right);
        int i = statusBarHeight;
        if (i > 0) {
            new LinearLayout.LayoutParams(-1, i);
            this.O00000Oo.setPadding(0, statusBarHeight, 0, 0);
        }
        this.shoppingCountBv = new BadgeView(this, this.mCartView);
        this.shoppingCountBv.setTextColor(getResources().getColor(17170443));
        this.shoppingCountBv.setTextSize(2, 10.0f);
        this.shoppingCountBv.setBadgeBackgroundDrawable(getResources().getDrawable(R.drawable.shop_orangle_inner_solid_circle));
        this.shoppingCountBv.setmBadgePosition(2);
        this.shoppingCountBv.setBadgeMargin(0, cdy.O000000o((Activity) this, 5.0f));
        this.orderListCountBv = new BadgeView(this, this.mOrderListView);
        this.orderListCountBv.setTextColor(getResources().getColor(17170443));
        this.orderListCountBv.setTextSize(2, 10.0f);
        this.orderListCountBv.setBadgeBackgroundDrawable(getResources().getDrawable(R.drawable.shop_orangle_inner_solid_circle));
        this.orderListCountBv.setmBadgePosition(2);
        this.orderListCountBv.setBadgeMargin(0, cdy.O000000o((Activity) this, 5.0f));
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.BaseActivity.AnonymousClass3 */

            public final void onClick(View view) {
                BaseActivity.this.finish();
            }
        });
        if (ccn.O0000o00() != null) {
            ccn.O0000o00().O000000o((bxq.O000000o) this);
        }
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "STARTUP onCreate done");
    }

    public void startAllOrderActivity() {
        if (ccn.O0000o00().O0000o0O()) {
            Intent intent = new Intent(this, OrderListAcitvity.class);
            intent.putExtra("type", 0);
            startActivityForResult(intent, 1);
        } else if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
            gotoAccount();
        } else {
            byl.O00000o0();
        }
    }

    public void setTitle(CharSequence charSequence) {
        CustomTextView customTextView = this.O00000o;
        if (customTextView != null) {
            customTextView.setText(charSequence);
            super.setTitle(charSequence);
        }
    }

    public void setTitle(int i) {
        CustomTextView customTextView = this.O00000o;
        if (customTextView != null) {
            customTextView.setText(i);
            super.setTitle(i);
        }
    }

    public CustomTextView getMainTabTitle() {
        return this.O00000oO;
    }

    public void setMainTabTitle(String str) {
        this.O00000oO.setText(str);
    }

    public View getTitleBarContainer() {
        return this.O00000Oo;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void showFragment(String str, Bundle bundle, boolean z) {
        showFragment(str, null, bundle, z);
    }

    public void showFragment(String str, Bundle bundle, Bundle bundle2, boolean z) {
        View view = this.f4584O000000o;
        if (view == null) {
            ccr.O00000o0(com.mi.activity.BaseActivity.TAG, "mDecoratedView is NOT FOUND.");
        } else if (view.getId() <= 0) {
            throw new IllegalArgumentException("The activity in xml layout MUST has argument 'id'.");
        } else if (bundle == null) {
            ei O000000o2 = getSupportFragmentManager().O000000o();
            Fragment fragmentByTag = getFragmentByTag(str);
            if (fragmentByTag == null) {
                fragmentByTag = newFragmentByTag(str);
                if (bundle2 != null) {
                    fragmentByTag.setArguments(bundle2);
                }
            }
            if (fragmentByTag == null) {
                ccr.O00000o0(com.mi.activity.BaseActivity.TAG, "NO fragment found by tag: ".concat(String.valueOf(str)));
                return;
            }
            O000000o2.O0000Oo0 = 4099;
            O000000o2.O00000Oo(this.f4584O000000o.getId(), fragmentByTag, str);
            if (z) {
                O000000o2.O000000o((String) null);
            }
            O000000o2.O00000o0();
        }
    }

    public Fragment getFragmentByTag(String str) {
        return getSupportFragmentManager().O000000o(str);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i) {
        View inflate = View.inflate(this, i, null);
        if (inflate != null) {
            View view = this.f4584O000000o;
            if (view != null) {
                this.O00000o0.removeView(view);
            }
            this.O00000o0.addView(inflate);
            this.f4584O000000o = inflate;
            return;
        }
        View view2 = this.f4584O000000o;
        if (view2 != null) {
            this.O00000o0.removeView(view2);
            this.f4584O000000o = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(boolean z) {
        if (z) {
            this.mCartView.setVisibility(0);
            return;
        }
        this.mCartView.setVisibility(4);
        this.shoppingCountBv.hide();
    }

    public void updateCartBadgeViewVisble(final String str) {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "update cart visible:".concat(String.valueOf(str)));
        runOnUiThread(new Runnable() {
            /* class com.mi.global.shop.activity.BaseActivity.AnonymousClass4 */

            public final void run() {
                if (!cav.O0000Oo(str)) {
                    BaseActivity.this.O000000o(false);
                    return;
                }
                BaseActivity.this.O000000o(true);
                BaseActivity.this.updateShoppingCart();
            }
        });
    }

    private void O00000Oo(final int i) {
        runOnUiThread(new Runnable() {
            /* class com.mi.global.shop.activity.BaseActivity.AnonymousClass5 */

            public final void run() {
                if (i <= 0 || BaseActivity.this.mCartView.getVisibility() != 0) {
                    BaseActivity.this.shoppingCountBv.hide();
                    return;
                }
                BaseActivity.this.shoppingCountBv.show();
                BaseActivity.this.shoppingCountBv.setCount(i);
                BaseActivity.this.shoppingCountBv.invalidate();
            }
        });
    }

    private void O00000o0(final int i) {
        runOnUiThread(new Runnable() {
            /* class com.mi.global.shop.activity.BaseActivity.AnonymousClass6 */

            public final void run() {
                if (i <= 0 || BaseActivity.this.mOrderListView.getVisibility() != 0) {
                    BaseActivity.this.orderListCountBv.hide();
                    return;
                }
                BaseActivity.this.orderListCountBv.show();
                BaseActivity.this.orderListCountBv.setCount(i);
                BaseActivity.this.orderListCountBv.invalidate();
            }
        });
    }

    public int getShoppingCart() {
        return cbm.O00000o0.O000000o(this, "pref_key_shoppingcart_number", 0);
    }

    public void updateShoppingCart(int i) {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "update cart:".concat(String.valueOf(i)));
        if (shoppingCartNum != i) {
            shoppingCartNum = i;
            cbm.O00000o0.O00000Oo(this, "pref_key_shoppingcart_number", i);
        }
        O00000Oo(i);
    }

    public void saveAndUpdateUnpaidNum(int i) {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "update cart:".concat(String.valueOf(i)));
        if (unpaidNum != i) {
            unpaidNum = i;
            cbm.O00000o0.O00000Oo(this, "pref_key_unpaid_number", i);
        }
        O00000o0(i);
    }

    public void updateShoppingCart() {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "update cart as pref value");
        if (shoppingCartNum == -1) {
            shoppingCartNum = cbm.O00000o0.O000000o(this, "pref_key_shoppingcart_number", 0);
        }
        O00000Oo(shoppingCartNum);
    }

    public void updateUnpaidBadge() {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "update cart as pref value");
        if (ccn.O0000o00().O0000o0O()) {
            if (unpaidNum == -1) {
                unpaidNum = cbm.O00000o0.O000000o(this, "pref_key_unpaid_number", 0);
            }
            O00000o0(unpaidNum);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "onDestroy," + getClass().getName());
        ccn.O0000o00().O00000Oo((bxq.O000000o) this);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    public void onLogin(String str, String str2, String str3) {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, String.format("BaseActivity-onLogin:%s, %s, %s", str, str2, str3));
    }

    public void onUserInfoUpdate(String str, String str2, String str3, int i, String str4) {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, String.format("BaseActivity-userinfoupdate:%s, %s, %s,%d", str, str2, str3, Integer.valueOf(i)));
        updateShoppingCart(i);
    }

    public void onLogout() {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "logout");
        updateShoppingCart(0);
        saveAndUpdateUnpaidNum(0);
        cbw.O000000o(this);
        cbw.O00000Oo(this);
    }

    public void onPause() {
        super.onPause();
        cbe.O000000o();
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "onPause," + getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "onRestart," + getClass().getName());
    }

    public void onResume() {
        super.onResume();
        updateShoppingCart();
        if (!(this instanceof WebActivity)) {
            cbe.O00000Oo(getClass().getSimpleName());
        }
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "onResume," + getClass().getName());
    }

    public void onStart() {
        super.onStart();
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "onStart," + getClass().getName());
    }

    public void onStop() {
        super.onStop();
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "onStop," + getClass().getName());
    }

    public void onSaveInstanceState(Bundle bundle) {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "onSaveInstanceState , outState:".concat(String.valueOf(bundle)));
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "refreshFragment");
        ee supportFragmentManager = getSupportFragmentManager();
        new ArrayList();
        ArrayList<Fragment> arrayList = new ArrayList<>();
        List<Fragment> O00000oo2 = supportFragmentManager.O00000oo();
        if (O00000oo2 != null) {
            for (Fragment next : O00000oo2) {
                if (next != null && next.isVisible()) {
                    arrayList.add(next);
                }
            }
        }
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "Fragments size:" + arrayList.size());
        for (Fragment fragment : arrayList) {
            ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "get fragment:" + fragment.toString());
            if (fragment instanceof bzf) {
                ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "refreshFragment:" + fragment.toString());
                ((bzf) fragment).O000000o();
            }
        }
    }

    public void showPageNotice(NewPageMessage newPageMessage) {
        View findViewById = findViewById(R.id.notice_view);
        if (findViewById != null) {
            if (newPageMessage == null || TextUtils.isEmpty(newPageMessage.pagemsg)) {
                findViewById.setVisibility(8);
                return;
            }
            findViewById.setVisibility(0);
            ((CustomTextView) findViewById.findViewById(R.id.notice_text)).setText(newPageMessage.pagemsg);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById.findViewById(R.id.notice_icon);
            if (TextUtils.isEmpty(newPageMessage.icon)) {
                simpleDraweeView.setVisibility(8);
                return;
            }
            simpleDraweeView.setVisibility(0);
            cbq.O000000o(newPageMessage.icon, simpleDraweeView);
        }
    }

    public void initProgressDialog() {
        this.O0000Ooo = new ProgressDialog(this);
        this.O0000Ooo.setMessage(getString(R.string.please_wait));
        this.O0000Ooo.setIndeterminate(true);
        this.O0000Ooo.setCancelable(false);
        this.O0000Ooo.setCanceledOnTouchOutside(false);
    }

    public void showLoading() {
        if (isActivityAlive(this)) {
            ProgressDialog progressDialog = this.O0000Ooo;
            if (progressDialog != null) {
                progressDialog.show();
                return;
            }
            initProgressDialog();
            this.O0000Ooo.show();
        }
    }

    public void hideLoading() {
        ProgressDialog progressDialog;
        if (isActivityAlive(this) && (progressDialog = this.O0000Ooo) != null && progressDialog.isShowing()) {
            this.O0000Ooo.dismiss();
        }
    }

    public String getUpdateUrl() {
        return cav.O000OOoo();
    }

    public static boolean isActivityAlive(Context context) {
        if (context != null && (context instanceof Activity)) {
            if (Build.VERSION.SDK_INT >= 17) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return false;
                }
                return true;
            } else if (!((Activity) context).isFinishing()) {
                return true;
            }
        }
        return false;
    }

    public void appendOriginalUrl(Uri.Builder builder, Activity activity) {
        String stringExtra = activity.getIntent().getStringExtra("originalUrl");
        if (!TextUtils.isEmpty(stringExtra)) {
            builder.appendQueryParameter("originalUrl", stringExtra);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1 || i2 != 0) {
            return;
        }
        if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
            gotoAccount();
        } else {
            byl.O00000o0();
        }
    }
}

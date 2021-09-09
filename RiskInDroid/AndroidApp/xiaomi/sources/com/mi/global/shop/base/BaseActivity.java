package com.mi.global.shop.base;

import _m_j.byo;
import _m_j.byp;
import _m_j.byq;
import _m_j.byt;
import _m_j.ccr;
import _m_j.cdy;
import _m_j.cem;
import _m_j.ee;
import _m_j.ei;
import _m_j.ny;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.account.activity.AccountActivity;
import com.mi.global.shop.base.service.ConnectionHelperService;
import com.mi.global.shop.base.service.LoginManagerService;
import com.mi.global.shop.base.service.MiPushClientService;
import com.mi.global.shop.base.service.WebViewCookieManagerService;
import com.mi.global.shop.base.widget.BadgeView;
import com.mi.global.shop.base.widget.CustomEditTextView;
import com.mi.global.shop.base.widget.CustomInsetsFrameLayout;
import com.mi.util.Device;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AccountActivity implements byq {
    private static int sDarkModeFlag = 0;
    private static Method sExtraFlagField = null;
    public static int shoppingCartNum = -1;
    public static int statusBarHeight;
    @Autowired
    public ConnectionHelperService connectionHelperService;
    public ImageView dividerView;
    public SimpleDraweeView iv_title_bg;
    public SimpleDraweeView iv_title_icon;
    public LinearLayout layoutSearchContainer;
    private Dialog loadingDialog;
    @Autowired
    public LoginManagerService loginManagerService;
    public View mBackView;
    public View mCartView;
    private CustomInsetsFrameLayout mContentContainer;
    private View mDecoratedView;
    public CustomTextView mForgetPwd;
    public View mMessageView;
    private View mTitleBarContainer;
    private View mTitleBarRL;
    private CustomTextView mTitleTv;
    private CustomTextView mainTabCenterTitle;
    public CustomTextView mainTabTitle;
    public FrameLayout mainTabTitleContainer;
    public SimpleDraweeView messageBtn;
    public BadgeView messageCountBv;
    @Autowired
    public MiPushClientService miPushClientService;
    public String pageId;
    public SimpleDraweeView searchBtn;
    public View searchBtnContainer;
    public CustomEditTextView searchInputEtv;
    public SimpleDraweeView settingsBtn;
    public BadgeView shoppingCountBv;
    public SimpleDraweeView shopping_cart;
    @Autowired
    public WebViewCookieManagerService webViewCookieManagerService;

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.feature_base_base_activity;
    }

    /* access modifiers changed from: protected */
    public boolean needShowBadgeView() {
        return true;
    }

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
            if (sExtraFlagField == null) {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                sDarkModeFlag = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                sExtraFlagField = window.getClass().getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            }
            sExtraFlagField.invoke(window, Integer.valueOf(sDarkModeFlag), Integer.valueOf(sDarkModeFlag));
            if (Build.VERSION.SDK_INT >= 23 && Device.O0000o0o) {
                window.getDecorView().setSystemUiVisibility(8192);
            }
        } catch (Exception unused2) {
        }
    }

    public void onCreate(Bundle bundle) {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "STARTUP onCreate");
        super.onCreate(bundle);
        onShopActivityCreate(this);
        setContentView(getLayoutResId());
        ny.O000000o();
        this.loginManagerService = (LoginManagerService) ny.O000000o(LoginManagerService.class);
        ny.O000000o();
        this.connectionHelperService = (ConnectionHelperService) ny.O000000o(ConnectionHelperService.class);
        ny.O000000o();
        this.webViewCookieManagerService = (WebViewCookieManagerService) ny.O000000o(WebViewCookieManagerService.class);
        ny.O000000o();
        this.miPushClientService = (MiPushClientService) ny.O000000o(MiPushClientService.class);
        if (this.loginManagerService == null || this.connectionHelperService == null || this.webViewCookieManagerService == null) {
            throw new RuntimeException("调用方需要实现 globalShopBase 组件的 Service 包的所有接口。");
        }
        this.mContentContainer = (CustomInsetsFrameLayout) findViewById(R.id.content_container);
        this.mTitleBarContainer = findViewById(R.id.title_bar_container);
        this.mTitleTv = (CustomTextView) findViewById(R.id.title_bar_title);
        this.mainTabTitle = (CustomTextView) findViewById(R.id.title_mi_text);
        this.mainTabCenterTitle = (CustomTextView) findViewById(R.id.title_mi_center_text);
        this.mainTabTitleContainer = (FrameLayout) findViewById(R.id.layout_title_container);
        this.mTitleBarRL = findViewById(R.id.title_bar_RL);
        this.shopping_cart = (SimpleDraweeView) findViewById(R.id.shopping_cart);
        this.iv_title_bg = (SimpleDraweeView) findViewById(R.id.iv_title_bg);
        this.iv_title_icon = (SimpleDraweeView) findViewById(R.id.iv_title_icon);
        this.mCartView = findViewById(R.id.title_bar_cart_view);
        this.mMessageView = findViewById(R.id.title_bar_message_view);
        this.mCartView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.base.BaseActivity.AnonymousClass1 */

            public final void onClick(View view) {
                byp.O00000Oo("cart_click", getClass().getSimpleName());
                byp.O000000o("cart_click", "navigation_cart");
                BaseActivity.this.startCartActivity();
            }
        });
        this.mBackView = findViewById(R.id.title_bar_back);
        this.mForgetPwd = (CustomTextView) findViewById(R.id.title_bar_text_right);
        if (statusBarHeight > 0) {
            new View(this);
            new LinearLayout.LayoutParams(-1, statusBarHeight);
            this.mTitleBarContainer.setPadding(0, statusBarHeight, 0, 0);
            updateCustomContentMarginTop(false);
        }
        setBadgeView();
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.base.BaseActivity.AnonymousClass2 */

            public final void onClick(View view) {
                BaseActivity.this.finish();
                if (!TextUtils.isEmpty(BaseActivity.this.pageId)) {
                    byp.O000000o("return_click", BaseActivity.this.pageId);
                }
            }
        });
        this.loginManagerService.O000000o(this);
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "STARTUP onCreate done");
        this.messageBtn = (SimpleDraweeView) findViewById(R.id.message_btn);
        this.settingsBtn = (SimpleDraweeView) findViewById(R.id.settings_btn);
        this.searchBtn = (SimpleDraweeView) findViewById(R.id.search_btn);
        this.searchBtnContainer = findViewById(R.id.search_btn_container);
        this.layoutSearchContainer = (LinearLayout) findViewById(R.id.layout_search_container);
        this.searchInputEtv = (CustomEditTextView) findViewById(R.id.etv_search_input);
        this.dividerView = (ImageView) findViewById(R.id.iv_divider);
        updateHeaderSkinGif(null);
    }

    /* access modifiers changed from: protected */
    public void setSearchViewVisible(int i) {
        this.searchBtnContainer.setVisibility(i);
        this.layoutSearchContainer.setVisibility(i);
    }

    public void setTitle(CharSequence charSequence) {
        CustomTextView customTextView = this.mTitleTv;
        if (customTextView != null) {
            customTextView.setText(charSequence);
            super.setTitle(charSequence);
        }
    }

    public void setTitle(int i) {
        CustomTextView customTextView = this.mTitleTv;
        if (customTextView != null) {
            customTextView.setText(i);
            super.setTitle(i);
        }
    }

    public CustomTextView getMainTabTitle() {
        return this.mainTabTitle;
    }

    public void setMainTabTitle(String str) {
        this.mainTabTitle.setText(str);
    }

    public CustomTextView getMainTabCenterTitle() {
        return this.mainTabCenterTitle;
    }

    public void setMainTabCenterTitle(String str) {
        this.mainTabCenterTitle.setText(str);
    }

    public View getTitleBarContainer() {
        return this.mTitleBarContainer;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void showFragment(String str, Bundle bundle, boolean z) {
        showFragment(str, null, bundle, z);
    }

    public void showFragment(String str, Bundle bundle, Bundle bundle2, boolean z) {
        View view = this.mDecoratedView;
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
            O000000o2.O00000Oo(this.mDecoratedView.getId(), fragmentByTag, str);
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
    public void setCustomContentView(int i) {
        View inflate = View.inflate(this, i, null);
        if (inflate != null) {
            View view = this.mDecoratedView;
            if (view != null) {
                this.mContentContainer.removeView(view);
            }
            this.mContentContainer.addView(inflate);
            this.mDecoratedView = inflate;
            return;
        }
        View view2 = this.mDecoratedView;
        if (view2 != null) {
            this.mContentContainer.removeView(view2);
            this.mDecoratedView = null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cdy.O000000o(android.app.Activity, float):int
     arg types: [com.mi.global.shop.base.BaseActivity, int]
     candidates:
      _m_j.cdy.O000000o(android.content.Context, float):int
      _m_j.cdy.O000000o(android.app.Activity, float):int */
    /* access modifiers changed from: protected */
    public void updateCustomContentMarginTop(boolean z) {
        int i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentContainer.getLayoutParams();
        if (z) {
            i = 0;
        } else {
            i = statusBarHeight + cdy.O000000o((Activity) this, 45.0f);
        }
        layoutParams.topMargin = i;
        this.mContentContainer.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void setCartViewVisible(boolean z) {
        if (z) {
            this.mCartView.setVisibility(0);
            this.shoppingCountBv.setVisibility(0);
            updateShoppingCart();
            return;
        }
        this.mCartView.setVisibility(8);
        this.shoppingCountBv.setVisibility(8);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cdy.O000000o(android.app.Activity, float):int
     arg types: [com.mi.global.shop.base.BaseActivity, int]
     candidates:
      _m_j.cdy.O000000o(android.content.Context, float):int
      _m_j.cdy.O000000o(android.app.Activity, float):int */
    private void setBadgeView() {
        this.shoppingCountBv = new BadgeView(this, this.mCartView);
        this.shoppingCountBv.setTextColor(getResources().getColor(17170443));
        this.shoppingCountBv.setTextSize(2, 10.0f);
        this.shoppingCountBv.setBadgeBackgroundDrawable(getResources().getDrawable(R.drawable.feature_base_orangle_inner_solid_circle));
        this.shoppingCountBv.setmBadgePosition(2);
        this.shoppingCountBv.setBadgeMargin(0, cdy.O000000o((Activity) this, 5.0f));
        this.messageCountBv = new BadgeView(this, this.mMessageView);
        this.messageCountBv.setTextColor(getResources().getColor(17170443));
        this.messageCountBv.setTextSize(2, 10.0f);
        this.messageCountBv.setBadgeBackgroundDrawable(getResources().getDrawable(R.drawable.feature_base_orangle_inner_solid_circle));
        this.messageCountBv.setmBadgePosition(2);
        this.messageCountBv.setBadgeMargin(0, cdy.O000000o((Activity) this, 5.0f));
    }

    public void updateBadgeViewVisble(final String str) {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "update cart visible:".concat(String.valueOf(str)));
        runOnUiThread(new Runnable() {
            /* class com.mi.global.shop.base.BaseActivity.AnonymousClass3 */

            public final void run() {
                if (!BaseActivity.this.connectionHelperService.O00000Oo(str)) {
                    BaseActivity.this.setCartViewVisible(false);
                    return;
                }
                BaseActivity.this.setCartViewVisible(true);
                BaseActivity.this.updateShoppingCart();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void updateCartBadgeView(final int i) {
        runOnUiThread(new Runnable() {
            /* class com.mi.global.shop.base.BaseActivity.AnonymousClass4 */

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

    public void updateMessageBadgeView(final int i) {
        runOnUiThread(new Runnable() {
            /* class com.mi.global.shop.base.BaseActivity.AnonymousClass5 */

            public final void run() {
                PrintStream printStream = System.out;
                printStream.println("-----------messageBtn:" + BaseActivity.this.messageBtn.getVisibility());
                if (i <= 0 || BaseActivity.this.messageBtn.getVisibility() != 0) {
                    BaseActivity.this.messageCountBv.hide();
                    return;
                }
                BaseActivity.this.messageCountBv.show();
                BaseActivity.this.messageCountBv.setCount(i);
                BaseActivity.this.messageCountBv.invalidate();
            }
        });
    }

    public int getShoppingCart() {
        return byt.O00000Oo.O000000o(this, "pref_key_shoppingcart_number", 0);
    }

    public void updateShoppingCart(int i) {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "update cart:".concat(String.valueOf(i)));
        if (shoppingCartNum != i) {
            shoppingCartNum = i;
            byt.O00000Oo.O00000Oo(this, "pref_key_shoppingcart_number", i);
        }
        updateCartBadgeView(i);
    }

    public void updateShoppingCart() {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "update cart as pref value");
        if (shoppingCartNum == -1) {
            shoppingCartNum = byt.O00000Oo.O000000o(this, "pref_key_shoppingcart_number", 0);
        }
        updateCartBadgeView(shoppingCartNum);
    }

    public void onDestroy() {
        super.onDestroy();
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "onDestroy," + getClass().getName());
        this.loginManagerService.O00000Oo(this);
    }

    private void autoLogin() {
        this.webViewCookieManagerService.O000000o(this);
        this.webViewCookieManagerService.O00000Oo(this);
    }

    public void onLogin(String str, String str2, String str3) {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, String.format("BaseActivity-onLogin:%s, %s, %s", str, str2, str3));
        if (!TextUtils.isEmpty(str)) {
            cem.O000000o(this, "android.permission.READ_PHONE_STATE");
        }
    }

    public void onUserInfoUpdate(String str, String str2, String str3, int i, String str4) {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, String.format("BaseActivity-userinfoupdate:%s, %s, %s,%d", str, str2, str3, Integer.valueOf(i)));
        updateShoppingCart(i);
    }

    public void onLogout() {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "logout");
        updateShoppingCart(0);
        this.webViewCookieManagerService.O00000o0(this);
        this.webViewCookieManagerService.O00000o(this);
    }

    public void onPause() {
        super.onPause();
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "onPause," + getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "onRestart," + getClass().getName());
    }

    public void onResume() {
        super.onResume();
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
    public void refreshFragment() {
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "refreshFragment");
        ee supportFragmentManager = getSupportFragmentManager();
        new ArrayList();
        ArrayList<Fragment> arrayList = new ArrayList<>();
        List<Fragment> O00000oo = supportFragmentManager.O00000oo();
        if (O00000oo != null) {
            for (Fragment next : O00000oo) {
                if (next != null && next.isVisible()) {
                    arrayList.add(next);
                }
            }
        }
        ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "Fragments size:" + arrayList.size());
        for (Fragment fragment : arrayList) {
            ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "get fragment:" + fragment.toString());
            if (fragment instanceof byo) {
                ccr.O00000Oo(com.mi.activity.BaseActivity.TAG, "refreshFragment:" + fragment.toString());
            }
        }
    }

    private void updateHeaderSkinGif(Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            enableImmersionStyle();
            updateHeaderHeight();
        }
    }

    public void enableImmersionStyle() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(1280);
            getWindow().setStatusBarColor(0);
        } else if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
            getWindow().addFlags(134217728);
        }
        if (Build.VERSION.SDK_INT >= 23 && Device.O0000o0o) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cdy.O000000o(android.app.Activity, float):int
     arg types: [com.mi.global.shop.base.BaseActivity, int]
     candidates:
      _m_j.cdy.O000000o(android.content.Context, float):int
      _m_j.cdy.O000000o(android.app.Activity, float):int */
    public void updateHeaderHeight() {
        int i = statusBarHeight;
        if (i != 0) {
            int O000000o2 = i + cdy.O000000o((Activity) this, 45.0f);
            SimpleDraweeView simpleDraweeView = this.iv_title_bg;
            ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
            layoutParams.height = O000000o2;
            simpleDraweeView.setLayoutParams(layoutParams);
            this.mTitleBarContainer.setPadding(0, 0, 0, 0);
        }
    }

    public void initProgressDialog() {
        this.loadingDialog = new Dialog(this);
        this.loadingDialog.setCanceledOnTouchOutside(true);
        this.loadingDialog.getWindow().setDimAmount(0.0f);
        this.loadingDialog.getWindow().getDecorView().setBackgroundColor(0);
        this.loadingDialog.setContentView(((LayoutInflater) getSystemService("layout_inflater")).inflate((int) R.layout.feature_base_common_rabbit_loading_dialog, (ViewGroup) null));
    }

    public void showLoading() {
        if (isActivityAlive(this)) {
            Dialog dialog = this.loadingDialog;
            if (dialog != null) {
                dialog.show();
                setLoadingAnimStatus(true);
                return;
            }
            initProgressDialog();
            this.loadingDialog.show();
            setLoadingAnimStatus(true);
        }
    }

    public void hideLoading() {
        Dialog dialog;
        if (isActivityAlive(this) && (dialog = this.loadingDialog) != null && dialog.isShowing()) {
            setLoadingAnimStatus(false);
            this.loadingDialog.dismiss();
        }
    }

    private void setLoadingAnimStatus(boolean z) {
        ImageView imageView;
        Dialog dialog = this.loadingDialog;
        if (dialog != null && (imageView = (ImageView) dialog.findViewById(R.id.iv_rabbit)) != null) {
            if (z) {
                ((AnimationDrawable) imageView.getDrawable()).start();
            } else {
                ((AnimationDrawable) imageView.getDrawable()).stop();
            }
        }
    }

    public String getUpdateUrl() {
        return this.connectionHelperService.O00000o();
    }

    public static boolean isActivityAlive(Context context) {
        if (context != null && (context instanceof Activity)) {
            if (Build.VERSION.SDK_INT >= 17) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() || !activity.isDestroyed()) {
                    return true;
                }
                return false;
            } else if (!((Activity) context).isFinishing()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void setBackViewState(String str) {
        this.pageId = str;
    }
}

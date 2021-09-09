package com.xiaomi.mico.common.widget;

import _m_j.hxi;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.music.detail.StationDetailActivity;
import com.xiaomi.mico.setting.RechargeMiCoinActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import java.text.DecimalFormat;
import rx.functions.Action1;

public class OverallPurchaseHelper implements OnActivityResultListener {
    private CommonActivity context;
    public boolean getMiCoinBalanceSuccess;
    public float miCoinBalance;
    private PopupWindow popWindow;
    public final Music.Station station;
    private String stationAction;
    private TextView tvAccountBalance;
    private final Window window;

    static /* synthetic */ boolean lambda$showPopupView$0(View view, MotionEvent motionEvent) {
        return false;
    }

    public OverallPurchaseHelper(CommonActivity commonActivity, Music.Station station2, String str) {
        this.context = commonActivity;
        this.station = station2;
        this.window = commonActivity.getWindow();
        this.stationAction = str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void}
     arg types: [android.view.View, int, int, int]
     candidates:
      ClspMth{android.widget.PopupWindow.<init>(android.content.Context, android.util.AttributeSet, int, int):void}
      ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void} */
    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public void showPopupView() {
        View inflate = LayoutInflater.from(this.context).inflate((int) R.layout.popup_view_overall_purchase, (ViewGroup) null);
        this.popWindow = new PopupWindow(inflate, -1, -2, true);
        this.popWindow.setTouchInterceptor($$Lambda$OverallPurchaseHelper$Ca9YCykkmccgIIZmra0GUH3Eczs.INSTANCE);
        this.popWindow.setBackgroundDrawable(new ColorDrawable());
        this.popWindow.showAtLocation(getDecorView(), 81, 0, 0);
        this.popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$OverallPurchaseHelper$S_HPBDZJDEQlRfeTjeYSGw7dlQA */

            public final void onDismiss() {
                OverallPurchaseHelper.this.lambda$showPopupView$1$OverallPurchaseHelper();
            }
        });
        setWindowAlpha(0.5f);
        hxi.O00000o0.f957O000000o.O000000o("content_sound_buy pop", new Object[0]);
        initView(inflate);
        getMiCoinBalance();
    }

    public /* synthetic */ void lambda$showPopupView$1$OverallPurchaseHelper() {
        setWindowAlpha(1.0f);
    }

    private void getMiCoinBalance() {
        ApiHelper.getMiCoinBalance(new ApiRequest.Listener<Long>() {
            /* class com.xiaomi.mico.common.widget.OverallPurchaseHelper.AnonymousClass1 */

            public void onSuccess(Long l) {
                OverallPurchaseHelper.this.miCoinBalance = ((float) l.longValue()) / 100.0f;
                OverallPurchaseHelper overallPurchaseHelper = OverallPurchaseHelper.this;
                overallPurchaseHelper.getMiCoinBalanceSuccess = true;
                overallPurchaseHelper.updateUI();
            }

            public void onFailure(ApiError apiError) {
                OverallPurchaseHelper overallPurchaseHelper = OverallPurchaseHelper.this;
                overallPurchaseHelper.getMiCoinBalanceSuccess = false;
                overallPurchaseHelper.updateUI();
            }
        });
    }

    public void updateUI() {
        this.tvAccountBalance.setText(formatMiCoin(this.context, this.miCoinBalance));
    }

    private void initView(View view) {
        RxUtil.debounceClick(view.findViewById(R.id.purchaseByBalance), new Action1() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$OverallPurchaseHelper$D4zW67Q3EqDx_i1dWBlMcNpkHow */

            public final void call(Object obj) {
                OverallPurchaseHelper.this.lambda$initView$2$OverallPurchaseHelper((Void) obj);
            }
        });
        RxUtil.debounceClick(view.findViewById(R.id.purchaseByWXOrAli), new Action1() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$OverallPurchaseHelper$4uonr3yBkNsNU7EyCG44QHa3bw */

            public final void call(Object obj) {
                OverallPurchaseHelper.this.lambda$initView$3$OverallPurchaseHelper((Void) obj);
            }
        });
        this.tvAccountBalance = (TextView) view.findViewById(R.id.tvAccountBalance);
        RxUtil.debounceClick(view.findViewById(R.id.mico_purchaseall_close_pop_btn), new Action1() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$OverallPurchaseHelper$IKndIzhliUfzVNI6SE4kAQcy4xE */

            public final void call(Object obj) {
                OverallPurchaseHelper.this.lambda$initView$4$OverallPurchaseHelper((Void) obj);
            }
        });
    }

    public /* synthetic */ void lambda$initView$2$OverallPurchaseHelper(Void voidR) {
        handleBuyNowClick();
    }

    public /* synthetic */ void lambda$initView$3$OverallPurchaseHelper(Void voidR) {
        StationDetailActivity.gotoPay(this.context, this.station);
        CommonActivity commonActivity = this.context;
        if (commonActivity instanceof StationDetailActivity) {
            StationDetailActivity stationDetailActivity = (StationDetailActivity) commonActivity;
            stationDetailActivity.needRefreshData = true;
            stationDetailActivity.showPurchaseResultToast = true;
            hxi.O00000o.O0000Oo(2);
        }
    }

    public /* synthetic */ void lambda$initView$4$OverallPurchaseHelper(Void voidR) {
        release();
    }

    private void handleBuyNowClick() {
        if (isMiCoinBalanceEnough()) {
            buyBow();
        } else {
            RechargeMiCoinActivity.startForResult(this.context, this.miCoinBalance);
        }
        hxi.O00000o.O0000Oo(1);
    }

    private void buyBow() {
        if (this.getMiCoinBalanceSuccess) {
            this.popWindow.dismiss();
            SingleEpisodePurchaseHelper.purchaseAll(this.station.title, this.station.cover, this.station.origin, this.station.albumId, this.station.category, this.station.playSequence, this.stationAction, new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.common.widget.OverallPurchaseHelper.AnonymousClass2 */

                public void onSuccess(String str) {
                    OverallPurchaseHelper.this.station.bought = true;
                    SingleEpisodePurchaseHelper.showPurchaseSuccessToast();
                }

                public void onFailure(ApiError apiError) {
                    SingleEpisodePurchaseHelper.showPurchaseFailedToast();
                }
            });
        }
    }

    private boolean isMiCoinBalanceEnough() {
        Music.Station station2 = this.station;
        return station2 != null && this.miCoinBalance * 100.0f >= ((float) station2.salesPrice);
    }

    private void setWindowAlpha(float f) {
        Window window2 = this.window;
        if (window2 != null) {
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.alpha = f;
            this.window.setAttributes(attributes);
        }
    }

    private View getDecorView() {
        Window window2 = this.window;
        if (window2 == null) {
            return null;
        }
        return window2.getDecorView();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && i == 100) {
            this.miCoinBalance = intent.getFloatExtra("MI_COIN_BALANCE", 0.0f);
            updateUI();
        }
    }

    public void release() {
        PopupWindow popupWindow = this.popWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.popWindow.dismiss();
        }
    }

    private static String formatMiCoin(Context context2, float f) {
        return new DecimalFormat(context2.getString(R.string.single_episode_purchase_account_balance)).format((double) f);
    }
}

package com.xiaomi.mico.common.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiManager;
import com.xiaomi.mico.api.ApiProviderV2;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.service.PaymentService;
import com.xiaomi.mico.common.adapter.SingleEpisodePurchaseAdapter;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.GsonUtil;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.SingleEpisodePurchaseHelper;
import com.xiaomi.mico.music.detail.StationDetailActivity;
import com.xiaomi.mico.setting.RechargeMiCoinActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import rx.Observable;
import rx.functions.Action1;

public class SingleEpisodePurchaseHelper implements OnActivityResultListener {
    public CommonActivity context;
    public String contractId;
    public ArrayList<String> cpAlbumIds;
    public boolean getMiCoinBalanceSuccess;
    public boolean getUnpurchasedQuantitySuccess;
    public float miCoinBalance;
    public OnPurchaseResultListener onPurchaseResultListener;
    private PopupWindow popWindow;
    public int responseCount;
    private SingleEpisodePurchaseAdapter singleEpisodePurchaseAdapter;
    private final Music.Station startEpisode;
    private final Music.Station station;
    private String stationAction;
    public boolean supportContract;
    public SlidingButton switcher;
    private TextView tvAccountBalance;
    private TextView tvBuyNow;
    private final Window window;

    static /* synthetic */ boolean lambda$showPopupView$0(View view, MotionEvent motionEvent) {
        return false;
    }

    public SingleEpisodePurchaseHelper(CommonActivity commonActivity, Music.Station station2, Music.Station station3, String str, OnPurchaseResultListener onPurchaseResultListener2) {
        this.context = commonActivity;
        this.station = station2;
        this.startEpisode = station3;
        this.window = commonActivity.getWindow();
        this.stationAction = str;
        this.onPurchaseResultListener = onPurchaseResultListener2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void}
     arg types: [android.view.View, int, int, int]
     candidates:
      ClspMth{android.widget.PopupWindow.<init>(android.content.Context, android.util.AttributeSet, int, int):void}
      ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void} */
    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public void showPopupView() {
        View inflate = LayoutInflater.from(this.context).inflate((int) R.layout.popup_view_single_episode_purchase, (ViewGroup) null);
        this.popWindow = new PopupWindow(inflate, -1, -2, true);
        this.popWindow.setTouchInterceptor($$Lambda$SingleEpisodePurchaseHelper$e040pughyQYoSvW7GEBsL7fI7g.INSTANCE);
        this.popWindow.setBackgroundDrawable(new ColorDrawable());
        this.popWindow.showAtLocation(getDecorView(), 81, 0, 0);
        this.popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$SingleEpisodePurchaseHelper$MzHhVypz54JsbBWQ0GA6j3dP7w */

            public final void onDismiss() {
                SingleEpisodePurchaseHelper.this.lambda$showPopupView$1$SingleEpisodePurchaseHelper();
            }
        });
        setWindowAlpha(0.5f);
        this.context.showProgressDialog("");
        initView(inflate);
        getUnpurchasedQuantity();
        getMiCoinBalance();
        getContractState();
    }

    public /* synthetic */ void lambda$showPopupView$1$SingleEpisodePurchaseHelper() {
        setWindowAlpha(1.0f);
    }

    private void getContractState() {
        ApiHelper.getContractState(this.startEpisode.origin, this.startEpisode.albumId, new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.common.widget.SingleEpisodePurchaseHelper.AnonymousClass1 */

            public void onSuccess(String str) {
                SingleEpisodePurchaseHelper.this.responseCount++;
                SingleEpisodePurchaseHelper singleEpisodePurchaseHelper = SingleEpisodePurchaseHelper.this;
                singleEpisodePurchaseHelper.contractId = str;
                singleEpisodePurchaseHelper.supportContract = true;
                singleEpisodePurchaseHelper.updateUI();
            }

            public void onFailure(ApiError apiError) {
                SingleEpisodePurchaseHelper.this.responseCount++;
                SingleEpisodePurchaseHelper singleEpisodePurchaseHelper = SingleEpisodePurchaseHelper.this;
                singleEpisodePurchaseHelper.supportContract = false;
                singleEpisodePurchaseHelper.updateUI();
            }
        });
    }

    private void getUnpurchasedQuantity() {
        ApiHelper.getUnpurchasedQuantity(this.startEpisode.albumId, this.station.origin, this.startEpisode.episodesNum, this.station.playSequence, new ApiRequest.Listener<ArrayList<String>>() {
            /* class com.xiaomi.mico.common.widget.SingleEpisodePurchaseHelper.AnonymousClass2 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((ArrayList<String>) ((ArrayList) obj));
            }

            public void onSuccess(ArrayList<String> arrayList) {
                SingleEpisodePurchaseHelper.this.responseCount++;
                SingleEpisodePurchaseHelper singleEpisodePurchaseHelper = SingleEpisodePurchaseHelper.this;
                singleEpisodePurchaseHelper.cpAlbumIds = arrayList;
                singleEpisodePurchaseHelper.getUnpurchasedQuantitySuccess = true;
                singleEpisodePurchaseHelper.updateUI();
            }

            public void onFailure(ApiError apiError) {
                SingleEpisodePurchaseHelper.this.responseCount++;
                SingleEpisodePurchaseHelper singleEpisodePurchaseHelper = SingleEpisodePurchaseHelper.this;
                singleEpisodePurchaseHelper.getUnpurchasedQuantitySuccess = false;
                singleEpisodePurchaseHelper.updateUI();
            }
        });
    }

    private void updatePurchaseListAndTvBuyNow() {
        this.singleEpisodePurchaseAdapter.setData(getSingleEpisodePurchaseItems(this.context, getUnpurchasedNum(), ((float) this.station.salesPrice) / 100.0f));
        updateTvBuyNowText();
        updateTvBuyNowEnable();
    }

    private void updateTvBuyNowEnable() {
        TextView textView = this.tvBuyNow;
        if (textView != null) {
            textView.setEnabled(this.getMiCoinBalanceSuccess && this.getUnpurchasedQuantitySuccess);
        }
    }

    private void updateTvBuyNowText() {
        if (this.tvBuyNow != null) {
            this.tvBuyNow.setText(isMiCoinBalanceEnough() ? R.string.single_episode_purchase_buy_now : R.string.single_episode_purchase_recharge);
        }
    }

    private void getMiCoinBalance() {
        updateMiCoinAndBuyNow();
        ApiHelper.getMiCoinBalance(new ApiRequest.Listener<Long>() {
            /* class com.xiaomi.mico.common.widget.SingleEpisodePurchaseHelper.AnonymousClass3 */

            public void onSuccess(Long l) {
                SingleEpisodePurchaseHelper.this.responseCount++;
                SingleEpisodePurchaseHelper.this.miCoinBalance = ((float) l.longValue()) / 100.0f;
                SingleEpisodePurchaseHelper singleEpisodePurchaseHelper = SingleEpisodePurchaseHelper.this;
                singleEpisodePurchaseHelper.getMiCoinBalanceSuccess = true;
                singleEpisodePurchaseHelper.updateUI();
            }

            public void onFailure(ApiError apiError) {
                SingleEpisodePurchaseHelper.this.responseCount++;
                SingleEpisodePurchaseHelper singleEpisodePurchaseHelper = SingleEpisodePurchaseHelper.this;
                singleEpisodePurchaseHelper.getMiCoinBalanceSuccess = false;
                singleEpisodePurchaseHelper.updateUI();
            }
        });
    }

    public void updateUI() {
        if (this.responseCount >= 3) {
            updateMiCoinAndBuyNow();
            updatePurchaseListAndTvBuyNow();
            updateSwitcherStateAndTag(this.supportContract);
            this.context.dismissProgressDialog();
        }
    }

    private void updateMiCoinAndBuyNow() {
        this.tvAccountBalance.setText(formatMiCoin(this.context, this.miCoinBalance, R.string.single_episode_purchase_account_balance));
        updateTvBuyNowEnable();
        updateTvBuyNowText();
    }

    private void showEnsureDialog() {
        new MLAlertDialog.Builder(getActivity(this.context)).O000000o((int) R.string.single_episode_purchase_confirm_open).O00000Oo((int) R.string.single_episode_purchase_confirm_open_tip).O000000o(false).O00000Oo((int) R.string.single_episode_purchase_cancel_open, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$SingleEpisodePurchaseHelper$FI9qYpuTvlrcC_8nLa1dkK_z94U */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SingleEpisodePurchaseHelper.this.lambda$showEnsureDialog$2$SingleEpisodePurchaseHelper(dialogInterface, i);
            }
        }).O000000o((int) R.string.single_episode_purchase_confirm_open, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$SingleEpisodePurchaseHelper$yJLBm87lW1BS8Jwy3LtF4Wsytv8 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SingleEpisodePurchaseHelper.this.lambda$showEnsureDialog$3$SingleEpisodePurchaseHelper(dialogInterface, i);
            }
        }).O00000oo();
    }

    public /* synthetic */ void lambda$showEnsureDialog$2$SingleEpisodePurchaseHelper(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        updateSwitcherStateAndTag(false);
    }

    public /* synthetic */ void lambda$showEnsureDialog$3$SingleEpisodePurchaseHelper(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        setContractState();
    }

    public void updateSwitcherStateAndTag(boolean z) {
        this.switcher.setChecked(z, false);
    }

    private void setContractState() {
        ApiHelper.setContractState(this.station.origin, this.station.albumId, this.station.cover, this.contractId, this.switcher.isChecked(), new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.common.widget.SingleEpisodePurchaseHelper.AnonymousClass4 */

            public void onSuccess(String str) {
                SingleEpisodePurchaseHelper.this.contractId = str;
            }

            public void onFailure(ApiError apiError) {
                SingleEpisodePurchaseHelper singleEpisodePurchaseHelper = SingleEpisodePurchaseHelper.this;
                singleEpisodePurchaseHelper.updateSwitcherStateAndTag(!singleEpisodePurchaseHelper.switcher.isChecked());
            }
        });
    }

    private void initView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rlPrice);
        recyclerView.setLayoutManager(new GridLayoutManager(this.context, 2));
        this.singleEpisodePurchaseAdapter = new SingleEpisodePurchaseAdapter();
        this.singleEpisodePurchaseAdapter.setOnPurchaseChoiceChangeListener(new SingleEpisodePurchaseAdapter.OnPurchaseChoiceChangeListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$SingleEpisodePurchaseHelper$9lIIqUaEu9WoMJ2l7AsZ_IGRvi8 */

            public final void onPurchaseChoiceChange(SingleEpisodePurchaseHelper.SingleEpisodePurchaseItem singleEpisodePurchaseItem) {
                SingleEpisodePurchaseHelper.this.lambda$initView$4$SingleEpisodePurchaseHelper(singleEpisodePurchaseItem);
            }
        });
        recyclerView.setAdapter(this.singleEpisodePurchaseAdapter);
        this.switcher = ((TitleDescAndSwitcher) view.findViewById(R.id.sbAutoPurchase)).switcher;
        this.switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$SingleEpisodePurchaseHelper$vbSni4UC1vz3JT4PN94mI91x4WA */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SingleEpisodePurchaseHelper.this.lambda$initView$5$SingleEpisodePurchaseHelper(compoundButton, z);
            }
        });
        this.tvBuyNow = (TextView) view.findViewById(R.id.tvBuyNow);
        this.tvBuyNow.setEnabled(false);
        RxUtil.debounceClick(this.tvBuyNow, new Action1() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$SingleEpisodePurchaseHelper$YtjKFexqiXooTqI0mzUU_T66vZ0 */

            public final void call(Object obj) {
                SingleEpisodePurchaseHelper.this.lambda$initView$6$SingleEpisodePurchaseHelper((Void) obj);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.tvPurchaseStartBy);
        String str = this.startEpisode.title;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ClickableSpan() {
            /* class com.xiaomi.mico.common.widget.SingleEpisodePurchaseHelper.AnonymousClass5 */

            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SingleEpisodePurchaseHelper.this.context.getResources().getColor(R.color.mj_color_green_normal));
                textPaint.setUnderlineText(false);
            }
        }, 0, str.length(), 33);
        textView.append(spannableString);
        textView.append(this.context.getString(R.string.single_episode_purchase_purchase));
        this.tvAccountBalance = (TextView) view.findViewById(R.id.tvAccountBalance);
    }

    public /* synthetic */ void lambda$initView$4$SingleEpisodePurchaseHelper(SingleEpisodePurchaseItem singleEpisodePurchaseItem) {
        updateTvBuyNowText();
    }

    public /* synthetic */ void lambda$initView$5$SingleEpisodePurchaseHelper(CompoundButton compoundButton, boolean z) {
        if (z) {
            showEnsureDialog();
        } else {
            setContractState();
        }
    }

    public /* synthetic */ void lambda$initView$6$SingleEpisodePurchaseHelper(Void voidR) {
        handleBuyNowClick();
    }

    private void handleBuyNowClick() {
        if (this.tvBuyNow.getContext().getString(R.string.single_episode_purchase_buy_now).contentEquals(this.tvBuyNow.getText())) {
            buyBow();
        } else {
            RechargeMiCoinActivity.startForResult(this.context, this.miCoinBalance);
        }
    }

    private void buyBow() {
        SingleEpisodePurchaseItem currentPurchaseItem = this.singleEpisodePurchaseAdapter.getCurrentPurchaseItem();
        if (currentPurchaseItem != null) {
            this.popWindow.dismiss();
            CommonActivity commonActivity = this.context;
            if (commonActivity instanceof StationDetailActivity) {
                ((StationDetailActivity) commonActivity).needRefreshData = true;
            }
            this.context.showProgressDialog("");
            purchaseSingleEpisode(this.station.title, this.station.cover, this.station.origin, this.station.albumId, this.station.category, this.startEpisode.episodesNum, currentPurchaseItem.episodeCount, this.station.playSequence, GsonUtil.getGsonInstance().toJson(this.cpAlbumIds.subList(0, currentPurchaseItem.episodeCount)), this.stationAction, new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.common.widget.SingleEpisodePurchaseHelper.AnonymousClass6 */

                public void onSuccess(String str) {
                    SingleEpisodePurchaseHelper.this.context.dismissProgressDialog();
                    SingleEpisodePurchaseHelper.this.onPurchaseResultListener.onPurchaseSuccess();
                    SingleEpisodePurchaseHelper.showPurchaseSuccessToast();
                }

                public void onFailure(ApiError apiError) {
                    SingleEpisodePurchaseHelper.this.context.dismissProgressDialog();
                    SingleEpisodePurchaseHelper.this.onPurchaseResultListener.onPurchaseFailed();
                    SingleEpisodePurchaseHelper.showPurchaseFailedToast();
                }
            });
        }
    }

    public static void showPurchaseSuccessToast() {
        ToastUtil.showToast((int) R.string.common_purchase_success);
    }

    public static void showPurchaseFailedToast() {
        ToastUtil.showToast((int) R.string.common_purchase_failed);
    }

    private int getUnpurchasedNum() {
        return ContainerUtil.getSize(this.cpAlbumIds);
    }

    private boolean isMiCoinBalanceEnough() {
        SingleEpisodePurchaseItem currentPurchaseItem = this.singleEpisodePurchaseAdapter.getCurrentPurchaseItem();
        if (currentPurchaseItem != null && this.miCoinBalance < currentPurchaseItem.purchasePrice) {
            return false;
        }
        return true;
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

    private static Activity getActivity(Context context2) {
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        if (context2 instanceof ContextWrapper) {
            context2 = ((ContextWrapper) context2).getBaseContext();
        }
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        return null;
    }

    private static ArrayList<SingleEpisodePurchaseItem> getSingleEpisodePurchaseItems(Context context2, int i, float f) {
        ArrayList<SingleEpisodePurchaseItem> arrayList = new ArrayList<>();
        if (i <= 0) {
            return arrayList;
        }
        arrayList.add(new SingleEpisodePurchaseItem(context2, context2.getString(R.string.single_episode_purchase_this_episode), 1, f));
        String string = context2.getString(R.string.single_episode_purchase_last_episode);
        if (i >= 10) {
            arrayList.add(new SingleEpisodePurchaseItem(context2, String.format(string, 10), 10, f));
        }
        if (i >= 20) {
            arrayList.add(new SingleEpisodePurchaseItem(context2, String.format(string, 20), 20, f));
        }
        if ((i == 1 || i == 10 || i == 20) ? false : true) {
            if (i <= 100) {
                string = context2.getString(R.string.single_episode_purchase_all_in);
            }
            arrayList.add(new SingleEpisodePurchaseItem(context2, String.format(string, Integer.valueOf(Math.min(i, 100))), Math.min(i, 100), f));
        }
        return arrayList;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && i == 100) {
            this.miCoinBalance = intent.getFloatExtra("MI_COIN_BALANCE", 0.0f);
            updateMiCoinAndBuyNow();
        }
    }

    public void release() {
        PopupWindow popupWindow = this.popWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.popWindow.dismiss();
        }
    }

    public static class SingleEpisodePurchaseItem {
        int episodeCount;
        public boolean isSelected;
        public String purchaseCount;
        float purchasePrice;
        public String purchasePriceStr;

        SingleEpisodePurchaseItem(Context context, String str, int i, float f) {
            this.purchaseCount = str;
            this.purchasePrice = ((float) i) * f;
            this.episodeCount = i;
            this.purchasePriceStr = SingleEpisodePurchaseHelper.formatMiCoin(context, this.purchasePrice, R.string.single_episode_purchase_mi_bi);
        }
    }

    public static String formatMiCoin(Context context2, float f, int i) {
        return new DecimalFormat(context2.getString(i)).format((double) f);
    }

    private static ApiRequest purchaseSingleEpisode(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, String str7, String str8, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2, str3, str4, str5, i, i2, str6, str7, str8) {
            /* class com.xiaomi.mico.common.widget.$$Lambda$SingleEpisodePurchaseHelper$2pVgkErynYok5K2YrgCvBlHsTdE */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ String f$3;
            private final /* synthetic */ String f$4;
            private final /* synthetic */ int f$5;
            private final /* synthetic */ int f$6;
            private final /* synthetic */ String f$7;
            private final /* synthetic */ String f$8;
            private final /* synthetic */ String f$9;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
                this.f$7 = r8;
                this.f$8 = r9;
                this.f$9 = r10;
            }

            public final Observable observable(Object obj) {
                return ((PaymentService) obj).payForEpisodes(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, Integer.valueOf(this.f$5), Integer.valueOf(this.f$6), this.f$7, this.f$8, this.f$9, 0, "android", 1);
            }
        }, PaymentService.class, listener);
    }

    static ApiRequest purchaseAll(String str, String str2, String str3, String str4, String str5, String str6, String str7, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2, str3, str4, str5, str6, str7) {
            /* class com.xiaomi.mico.common.widget.$$Lambda$SingleEpisodePurchaseHelper$_6gwVB1A_KyaEaK5UtkObB0Yr8A */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ String f$3;
            private final /* synthetic */ String f$4;
            private final /* synthetic */ String f$5;
            private final /* synthetic */ String f$6;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
            }

            public final Observable observable(Object obj) {
                return ((PaymentService) obj).payForEpisodes(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, null, null, this.f$5, "ALL", this.f$6, 0, "android", 2);
            }
        }, PaymentService.class, listener);
    }
}

package com.xiaomi.mico.music.player;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

public class PlayerShutdownTimer extends LinearLayout {
    @BindView(5920)
    TextView btnClose;
    @BindView(5959)
    TextView cancelBtn;
    private Remote.Response.PlayerShutdownTimerResp data;
    @BindView(7351)
    TextView hint;
    @BindView(6427)
    TextView leftTime;
    @BindView(6428)
    LinearLayout leftTimeContainer;
    public MLAlertDialog mDlg;
    private Subscription mTimerSubscription;
    @BindView(7215)
    TextView time10;
    @BindView(7216)
    TextView time20;
    @BindView(7217)
    TextView time30;
    @BindView(7218)
    TextView time45;
    @BindView(7219)
    TextView time60;

    public PlayerShutdownTimer(Context context) {
        super(context);
    }

    public PlayerShutdownTimer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerShutdownTimer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setup(MLAlertDialog mLAlertDialog, Remote.Response.PlayerShutdownTimerResp playerShutdownTimerResp) {
        Subscription subscription = this.mTimerSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
            this.mTimerSubscription = null;
        }
        this.data = playerShutdownTimerResp;
        this.mDlg = mLAlertDialog;
        Window window = mLAlertDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.getDecorView().setPadding(0, 0, 0, 0);
        }
        this.leftTimeContainer.setVisibility(8);
        this.hint.setVisibility(0);
        Remote.Response.PlayerShutdownTimerResp playerShutdownTimerResp2 = this.data;
        if (playerShutdownTimerResp2 != null && playerShutdownTimerResp2.remainTime > 0 && this.data.type == 1) {
            this.leftTimeContainer.setVisibility(0);
            this.hint.setVisibility(8);
            this.mTimerSubscription = Observable.interval(0, 1, TimeUnit.SECONDS).take(playerShutdownTimerResp.remainTime).map(new Func1() {
                /* class com.xiaomi.mico.music.player.$$Lambda$PlayerShutdownTimer$U3l5e81ToLAMahlsXg_Iz2vZHgY */

                public final Object call(Object obj) {
                    return Long.valueOf(((long) Remote.Response.PlayerShutdownTimerResp.this.remainTime) - ((Long) obj).longValue());
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
                /* class com.xiaomi.mico.music.player.$$Lambda$PlayerShutdownTimer$ueheJs8b4RQuVSGCOvF8qb07U */

                public final void call(Object obj) {
                    PlayerShutdownTimer.this.lambda$setup$1$PlayerShutdownTimer((Long) obj);
                }
            }, $$Lambda$PlayerShutdownTimer$GpY8aXdpywyqwJGO_BEvZmv3vvk.INSTANCE, new Action0() {
                /* class com.xiaomi.mico.music.player.$$Lambda$PlayerShutdownTimer$dNmMvxnZrZz3NZwM_yuRXXGQnTs */

                public final void call() {
                    PlayerShutdownTimer.this.lambda$setup$4$PlayerShutdownTimer();
                }
            });
        }
    }

    public /* synthetic */ void lambda$setup$1$PlayerShutdownTimer(Long l) {
        String str;
        long longValue = l.longValue() / 3600;
        long longValue2 = l.longValue() % 3600;
        int i = (int) (longValue2 / 60);
        int i2 = (int) (longValue2 % 60);
        if (longValue > 0) {
            str = String.format("%s%s", Long.valueOf(longValue), getResources().getString(R.string.common_hour));
        } else {
            str = "";
        }
        if (i > 0) {
            str = String.format("%s%s%s", str, Integer.valueOf(i), getResources().getString(R.string.picker_minute));
        }
        String format = String.format("%s%s%s", str, Integer.valueOf(i2), getResources().getString(R.string.common_second));
        this.leftTime.setText(getResources().getString(R.string.player_shutdown_timer_left, format));
    }

    static /* synthetic */ void lambda$setup$2(Throwable th) {
        Object[] objArr = {"update left play time failed", th};
    }

    public /* synthetic */ void lambda$setup$4$PlayerShutdownTimer() {
        this.hint.postDelayed(new Runnable() {
            /* class com.xiaomi.mico.music.player.$$Lambda$PlayerShutdownTimer$cJ68XGX2IWcHuoHf60tX405UKw */

            public final void run() {
                PlayerShutdownTimer.this.lambda$null$3$PlayerShutdownTimer();
            }
        }, 800);
    }

    public /* synthetic */ void lambda$null$3$PlayerShutdownTimer() {
        this.hint.setVisibility(0);
        this.leftTimeContainer.setVisibility(8);
        this.mTimerSubscription = null;
    }

    @OnClick({7215, 7216, 7217, 7218, 7219})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.time10 || id == R.id.time20 || id == R.id.time30 || id == R.id.time45 || id == R.id.time60) {
            startTimer(Integer.valueOf(view.getTag().toString()).intValue());
        }
    }

    private void startTimer(final int i) {
        ApiHelper.setPlayerShutdownTimer(0, i, new ApiRequest.Listener<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.music.player.PlayerShutdownTimer.AnonymousClass1 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                PlayerShutdownTimer.this.mDlg.dismiss();
                ToastUtil.showToast(PlayerShutdownTimer.this.getResources().getString(R.string.music_player_shutdown_timer_save_success, Integer.valueOf(i)));
            }

            public void onFailure(ApiError apiError) {
                ToastUtil.showToast((int) R.string.common_save_fail1);
            }
        });
    }

    @OnClick({5959})
    public void onViewClicked() {
        ApiHelper.cancelPlayerShutdownTimer(new ApiRequest.Listener<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.music.player.PlayerShutdownTimer.AnonymousClass2 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                PlayerShutdownTimer.this.onClose();
                ToastUtil.showToast((int) R.string.music_player_shutdown_timer_canceled);
            }

            public void onFailure(ApiError apiError) {
                ToastUtil.showToast((int) R.string.common_save_fail1);
            }
        });
    }

    public void onClose() {
        Subscription subscription = this.mTimerSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
            this.mTimerSubscription = null;
        }
        MLAlertDialog mLAlertDialog = this.mDlg;
        if (mLAlertDialog != null) {
            mLAlertDialog.dismiss();
            this.mDlg = null;
        }
    }

    public void setCloseBtnClickListener(View.OnClickListener onClickListener) {
        this.btnClose.setOnClickListener(onClickListener);
    }
}

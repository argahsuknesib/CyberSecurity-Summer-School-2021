package com.xiaomi.mico.base;

import _m_j.ahh;
import _m_j.drr;
import _m_j.drs;
import _m_j.gsy;
import _m_j.gwg;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.ToggleButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.util.ImmersionUtil;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

public class MicoBaseActivity extends CommonActivity implements ApiRequest.ICleanQueue {
    private boolean hasInitVolume;
    public int mCurrentVolumeValue;
    private boolean mIsShowing = true;
    private BehaviorSubject<ActivityEvent> mLifeSubject = BehaviorSubject.create();
    public int mPrevVolumeValue;
    private PublishSubject<Boolean> mPublishSubject = PublishSubject.create();
    private ArrayList<WeakReference<ApiRequest>> mRequestQueue;
    public View mSoundBarView;
    private Subscription mVolumeChangeSubscription;
    private XQProgressDialog vLoadingDialog;

    public enum ActivityEvent {
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY
    }

    public Activity getContext() {
        return this;
    }

    public boolean isDarkMode() {
        return false;
    }

    public boolean needFitsSystemWindows() {
        return false;
    }

    public boolean needImmersiveStatusBar() {
        return true;
    }

    public boolean needSetStatusMode() {
        return true;
    }

    public void onPointerCaptureChanged(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void setTintColor(int i) {
    }

    public class SoundBarViewHolder_ViewBinding implements Unbinder {
        private SoundBarViewHolder target;

        public SoundBarViewHolder_ViewBinding(SoundBarViewHolder soundBarViewHolder, View view) {
            this.target = soundBarViewHolder;
            soundBarViewHolder.soundIndicator = (ToggleButton) Utils.findRequiredViewAsType(view, R.id.mico_sound_indicator, "field 'soundIndicator'", ToggleButton.class);
            soundBarViewHolder.seekbar = (SeekBar) Utils.findRequiredViewAsType(view, R.id.mico_seekbar, "field 'seekbar'", SeekBar.class);
        }

        public void unbind() {
            SoundBarViewHolder soundBarViewHolder = this.target;
            if (soundBarViewHolder != null) {
                this.target = null;
                soundBarViewHolder.soundIndicator = null;
                soundBarViewHolder.seekbar = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
        gsy.O00000Oo(LogType.GENERAL, "Activity %s onCreate", getClass().getSimpleName());
        if (ImmersionUtil.supportTranslucentStatus() && needImmersiveStatusBar()) {
            ImmersionUtil.setTranslucentStatus(this, true);
            if (needSetStatusMode()) {
                setStatusBarMode(isDarkMode());
            }
            if (needFitsSystemWindows()) {
                refreshStatusBar();
            }
        }
        gwg.O00000Oo(getWindow());
        gwg.O000000o(getContext(), (View) null);
        initVolumeChangeSubscription();
    }

    public void bindToLifecycle(ApiRequest apiRequest) {
        if (this.mRequestQueue == null) {
            this.mRequestQueue = new ArrayList<>();
        }
        this.mRequestQueue.add(new WeakReference(apiRequest));
    }

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
        Object[] objArr = {"Activity %s OnResume", getClass().getSimpleName()};
        this.mIsShowing = true;
    }

    public void onPause() {
        super.onPause();
        Object[] objArr = {"Activity %s OnPause", getClass().getSimpleName()};
        this.mIsShowing = false;
    }

    public <T> drr<T> bindToLifecycle() {
        return drs.O000000o(this.mLifeSubject, ActivityEvent.DESTROY);
    }

    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    public void onDestroy() {
        super.onDestroy();
        Object[] objArr = {"Activity %s onDestroy", getClass().getSimpleName()};
        Subscription subscription = this.mVolumeChangeSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        hideSoundBar();
        this.mLifeSubject.onNext(ActivityEvent.DESTROY);
        this.mLifeSubject = null;
        ArrayList<WeakReference<ApiRequest>> arrayList = this.mRequestQueue;
        if (arrayList != null) {
            Iterator<WeakReference<ApiRequest>> it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                if (next.get() != null) {
                    ((ApiRequest) next.get()).cancel();
                }
            }
            this.mRequestQueue.clear();
            this.mRequestQueue = null;
        }
    }

    public void setContentView(int i) {
        setContentView(LayoutInflater.from(this).inflate(i, (ViewGroup) null));
    }

    public void setContentView(View view) {
        super.setContentView(view);
    }

    /* access modifiers changed from: protected */
    public boolean isShowing() {
        return this.mIsShowing;
    }

    /* access modifiers changed from: protected */
    public void refreshStatusBar() {
        setTintColor(getStatusBarColor());
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.mj_color_gray_heavier);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            this.mPublishSubject.onNext(Boolean.TRUE);
            return true;
        } else if (i != 25) {
            return super.onKeyDown(i, keyEvent);
        } else {
            this.mPublishSubject.onNext(Boolean.FALSE);
            return true;
        }
    }

    public void showProgressDialog(CharSequence charSequence) {
        showProgressDialog(charSequence, false, null);
    }

    public void showProgressDialog(CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        if (isValid()) {
            if (this.vLoadingDialog == null) {
                this.vLoadingDialog = new XQProgressDialog(this);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                this.vLoadingDialog.setMessage(String.valueOf(charSequence));
            } else {
                this.vLoadingDialog.setMessage(getResources().getString(R.string.common_loading));
            }
            this.vLoadingDialog.show();
        }
    }

    public void dismissProgressDialog() {
        XQProgressDialog xQProgressDialog = this.vLoadingDialog;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    private void initVolumeChangeSubscription() {
        this.mVolumeChangeSubscription = this.mPublishSubject.throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).flatMap(new Func1<Boolean, Observable<Remote.Response.NullInfo>>() {
            /* class com.xiaomi.mico.base.MicoBaseActivity.AnonymousClass5 */

            public Observable<Remote.Response.NullInfo> call(Boolean bool) {
                MicoBaseActivity.this.showSoundBar();
                MicoBaseActivity micoBaseActivity = MicoBaseActivity.this;
                micoBaseActivity.mPrevVolumeValue = micoBaseActivity.mCurrentVolumeValue;
                MicoBaseActivity.this.mCurrentVolumeValue += (bool.booleanValue() ? 1 : -1) * 4;
                MicoBaseActivity micoBaseActivity2 = MicoBaseActivity.this;
                micoBaseActivity2.mCurrentVolumeValue = Math.min(micoBaseActivity2.mCurrentVolumeValue, 100);
                if (MicoBaseActivity.this.mCurrentVolumeValue < 0) {
                    ((Vibrator) MicoBaseActivity.this.getSystemService("vibrator")).vibrate(200);
                    MicoBaseActivity.this.mCurrentVolumeValue = 0;
                }
                PlayerManager.getInstance().modifyVolumeByValue(MicoBaseActivity.this.mCurrentVolumeValue).subscribeOn(Schedulers.newThread()).subscribe(new Action1<Remote.Response.NullInfo>() {
                    /* class com.xiaomi.mico.base.MicoBaseActivity.AnonymousClass5.AnonymousClass1 */

                    public void call(Remote.Response.NullInfo nullInfo) {
                    }
                }, new Action1<Throwable>() {
                    /* class com.xiaomi.mico.base.MicoBaseActivity.AnonymousClass5.AnonymousClass2 */

                    public void call(Throwable th) {
                        ahh.O000000o(th);
                    }
                });
                return Observable.just(null);
            }
        }).doOnNext(new Action1<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.base.MicoBaseActivity.AnonymousClass4 */

            public void call(Remote.Response.NullInfo nullInfo) {
                MicoBaseActivity.this.showSoundBar();
            }
        }).debounce(3, TimeUnit.SECONDS).doOnNext(new Action1<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.base.MicoBaseActivity.AnonymousClass3 */

            public void call(Remote.Response.NullInfo nullInfo) {
                MicoBaseActivity.this.hideSoundBar();
            }
        }).subscribe(new Action1<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.base.MicoBaseActivity.AnonymousClass1 */

            public void call(Remote.Response.NullInfo nullInfo) {
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.base.MicoBaseActivity.AnonymousClass2 */

            public void call(Throwable th) {
                ahh.O000000o(th);
                MicoBaseActivity.this.hideSoundBar();
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int
     arg types: [com.xiaomi.mico.base.MicoBaseActivity, int]
     candidates:
      com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.content.Context, float):int
      com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int */
    /* access modifiers changed from: private */
    @SuppressLint({"InflateParams"})
    public void showSoundBar() {
        boolean z = true;
        if (this.mSoundBarView == null) {
            WindowManager windowManager = getWindowManager();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = DisplayUtils.dip2px((Activity) this, 70.0f);
            layoutParams.width = -1;
            layoutParams.flags = 920;
            layoutParams.format = -3;
            layoutParams.gravity = 80;
            layoutParams.type = 1000;
            this.mSoundBarView = LayoutInflater.from(this).inflate((int) R.layout.mico_sound_track, (ViewGroup) null);
            View view = this.mSoundBarView;
            view.setTag(new SoundBarViewHolder(view));
            windowManager.addView(this.mSoundBarView, layoutParams);
            this.mCurrentVolumeValue = PlayerManager.getInstance().getVolume();
            Object[] objArr = {"start volume is %d", Integer.valueOf(this.mCurrentVolumeValue)};
        }
        SoundBarViewHolder soundBarViewHolder = (SoundBarViewHolder) this.mSoundBarView.getTag();
        soundBarViewHolder.seekbar.setProgress(this.mCurrentVolumeValue);
        ToggleButton toggleButton = soundBarViewHolder.soundIndicator;
        if (PlayerManager.getInstance().getVolume() != 0) {
            z = false;
        }
        toggleButton.setChecked(z);
    }

    public void hideSoundBar() {
        getContext().runOnUiThread(new Runnable() {
            /* class com.xiaomi.mico.base.MicoBaseActivity.AnonymousClass6 */

            public void run() {
                if (MicoBaseActivity.this.mSoundBarView != null) {
                    MicoBaseActivity.this.getWindowManager().removeView(MicoBaseActivity.this.mSoundBarView);
                    MicoBaseActivity.this.mSoundBarView = null;
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean canShowSoundBar() {
        return MicoManager.getInstance().hasValidMico();
    }

    static class SoundBarViewHolder {
        @BindView(6582)
        SeekBar seekbar;
        @BindView(6584)
        ToggleButton soundIndicator;

        SoundBarViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    /* access modifiers changed from: protected */
    public void setStatusBarMode(boolean z) {
        ImmersionUtil.setStatusBarMode(this, z);
    }
}

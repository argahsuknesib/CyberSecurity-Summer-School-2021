package com.xiaomi.mico.music.player;

import _m_j.gsy;
import _m_j.hxi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.music.player.PlayerStatusTrack;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class PlayerVolumeBar extends LinearLayout implements PlayerStatusTrack.onTrackListener {
    public int mCurrentVolumeValue;
    public boolean mIsDragging;
    private int mPrevVolumeValue;
    private PublishSubject<Boolean> mPublishSubject = PublishSubject.create();
    @BindView(6820)
    SeekBar mSeekBar;
    private Subscription mVolumeChangeSubscription;

    public PlayerVolumeBar(Context context) {
        super(context);
    }

    public PlayerVolumeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerVolumeBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
        this.mSeekBar.setMax(100);
        this.mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /* class com.xiaomi.mico.music.player.PlayerVolumeBar.AnonymousClass1 */

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                PlayerVolumeBar.this.mIsDragging = true;
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                PlayerVolumeBar playerVolumeBar = PlayerVolumeBar.this;
                playerVolumeBar.mIsDragging = false;
                playerVolumeBar.modifyVolume(seekBar.getProgress());
            }
        });
        this.mCurrentVolumeValue = PlayerManager.getInstance().getVolume();
        initVolumeChangeSubscription();
    }

    public void updatePlayerVolume(int i) {
        this.mSeekBar.setProgress((int) ((((float) (i - 4)) / 96.0f) * 100.0f));
    }

    /* access modifiers changed from: package-private */
    public void onResume() {
        PlayerStatusTrack.getInstance().register(this);
    }

    /* access modifiers changed from: package-private */
    public void onPause() {
        PlayerStatusTrack.getInstance().unregister(this);
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        Subscription subscription = this.mVolumeChangeSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onTrack(Remote.Response.PlayerStatus playerStatus) {
        updatePlayerVolume(playerStatus.volume);
        this.mCurrentVolumeValue = playerStatus.volume;
    }

    public void modifyVolume(int i) {
        if (i < 4) {
            i = 4;
        }
        gsy.O00000Oo("PlayerVolumeBar", "modifyVolume: ".concat(String.valueOf(i)));
        hxi.O00000o.f952O000000o.O000000o("content_playpage_volume control", "type", Integer.valueOf(i > this.mCurrentVolumeValue ? 1 : 2));
        this.mPrevVolumeValue = PlayerManager.getInstance().getVolume();
        this.mCurrentVolumeValue = i;
        this.mCurrentVolumeValue = Math.min(this.mCurrentVolumeValue, 100);
        PlayerManager.getInstance().modifyVolumeByValue(this.mCurrentVolumeValue).subscribeOn(Schedulers.newThread()).subscribe(new Action1<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.music.player.PlayerVolumeBar.AnonymousClass2 */

            public void call(Remote.Response.NullInfo nullInfo) {
                PlayerVolumeBar playerVolumeBar = PlayerVolumeBar.this;
                playerVolumeBar.updatePlayerVolume(playerVolumeBar.mCurrentVolumeValue);
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.music.player.PlayerVolumeBar.AnonymousClass3 */

            public void call(Throwable th) {
                gsy.O00000Oo("PlayerVolumeBar", "modifyVolume: ".concat(String.valueOf(th)));
                PlayerVolumeBar playerVolumeBar = PlayerVolumeBar.this;
                playerVolumeBar.updatePlayerVolume(playerVolumeBar.mCurrentVolumeValue);
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            this.mPublishSubject.onNext(Boolean.TRUE);
            return true;
        } else if (i != 25) {
            return false;
        } else {
            this.mPublishSubject.onNext(Boolean.FALSE);
            return true;
        }
    }

    private void initVolumeChangeSubscription() {
        this.mVolumeChangeSubscription = this.mPublishSubject.throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).flatMap(new Func1<Boolean, Observable<Remote.Response.NullInfo>>() {
            /* class com.xiaomi.mico.music.player.PlayerVolumeBar.AnonymousClass8 */

            public Observable<Remote.Response.NullInfo> call(Boolean bool) {
                PlayerVolumeBar.this.modifyVolume(PlayerVolumeBar.this.mCurrentVolumeValue + ((bool.booleanValue() ? 1 : -1) * 4));
                return Observable.just(null);
            }
        }).doOnNext(new Action1<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.music.player.PlayerVolumeBar.AnonymousClass7 */

            public void call(Remote.Response.NullInfo nullInfo) {
            }
        }).debounce(3, TimeUnit.SECONDS).doOnNext(new Action1<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.music.player.PlayerVolumeBar.AnonymousClass6 */

            public void call(Remote.Response.NullInfo nullInfo) {
            }
        }).subscribe(new Action1<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.music.player.PlayerVolumeBar.AnonymousClass4 */

            public void call(Remote.Response.NullInfo nullInfo) {
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.music.player.PlayerVolumeBar.AnonymousClass5 */

            public void call(Throwable th) {
                gsy.O00000Oo("PlayerVolumeBar", th.toString());
            }
        });
    }
}

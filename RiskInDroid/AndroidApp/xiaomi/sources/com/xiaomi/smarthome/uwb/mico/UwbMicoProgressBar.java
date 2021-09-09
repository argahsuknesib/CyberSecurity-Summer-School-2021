package com.xiaomi.smarthome.uwb.mico;

import _m_j.fg;
import _m_j.fh;
import _m_j.fm;
import _m_j.fo;
import _m_j.gsy;
import _m_j.ixc;
import _m_j.ixe;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00012B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0014H\u0002J\b\u00100\u001a\u00020-H\u0014J\u0010\u00101\u001a\u00020-2\b\u0010 \u001a\u0004\u0018\u00010!R\u000e\u0010\t\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00063"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/UwbMicoProgressBar;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MAX_PROGRESS", "mEndTime", "Landroid/widget/TextView;", "getMEndTime", "()Landroid/widget/TextView;", "setMEndTime", "(Landroid/widget/TextView;)V", "mInitTime", "getMInitTime", "setMInitTime", "mIsDragging", "", "mSeekBar", "Landroid/widget/SeekBar;", "getMSeekBar", "()Landroid/widget/SeekBar;", "setMSeekBar", "(Landroid/widget/SeekBar;)V", "mStatus", "getMStatus", "()I", "setMStatus", "(I)V", "playingData", "Lcom/xiaomi/mico/api/model/Remote$Response$PlayingData;", "getPlayingData", "()Lcom/xiaomi/mico/api/model/Remote$Response$PlayingData;", "setPlayingData", "(Lcom/xiaomi/mico/api/model/Remote$Response$PlayingData;)V", "viewModel", "Lcom/xiaomi/smarthome/uwb/mico/UwbMicoPlayerViewModel;", "getViewModel", "()Lcom/xiaomi/smarthome/uwb/mico/UwbMicoPlayerViewModel;", "setViewModel", "(Lcom/xiaomi/smarthome/uwb/mico/UwbMicoPlayerViewModel;)V", "notifyUpdatePlayerPosition", "", "position", "fromUser", "onFinishInflate", "updateProgress", "Companion", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoProgressBar extends RelativeLayout {
    public static final Companion Companion = new Companion(null);
    public final int MAX_PROGRESS;
    public TextView mEndTime;
    public TextView mInitTime;
    public boolean mIsDragging;
    public SeekBar mSeekBar;
    private int mStatus;
    private Remote.Response.PlayingData playingData;
    public UwbMicoPlayerViewModel viewModel;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UwbMicoProgressBar(Context context) {
        this(context, null, 0, 6, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UwbMicoProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        ixe.O00000o(context, "context");
    }

    public final void _$_clearFindViewByIdCache() {
    }

    public final TextView getMInitTime() {
        TextView textView = this.mInitTime;
        if (textView != null) {
            return textView;
        }
        ixe.O000000o("mInitTime");
        throw null;
    }

    public final void setMInitTime(TextView textView) {
        ixe.O00000o(textView, "<set-?>");
        this.mInitTime = textView;
    }

    public final TextView getMEndTime() {
        TextView textView = this.mEndTime;
        if (textView != null) {
            return textView;
        }
        ixe.O000000o("mEndTime");
        throw null;
    }

    public final void setMEndTime(TextView textView) {
        ixe.O00000o(textView, "<set-?>");
        this.mEndTime = textView;
    }

    public final SeekBar getMSeekBar() {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar != null) {
            return seekBar;
        }
        ixe.O000000o("mSeekBar");
        throw null;
    }

    public final void setMSeekBar(SeekBar seekBar) {
        ixe.O00000o(seekBar, "<set-?>");
        this.mSeekBar = seekBar;
    }

    public final Remote.Response.PlayingData getPlayingData() {
        return this.playingData;
    }

    public final void setPlayingData(Remote.Response.PlayingData playingData2) {
        this.playingData = playingData2;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/UwbMicoProgressBar$Companion;", "", "()V", "TAG", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(ixc ixc) {
            this();
        }

        private Companion() {
        }
    }

    public final UwbMicoPlayerViewModel getViewModel() {
        UwbMicoPlayerViewModel uwbMicoPlayerViewModel = this.viewModel;
        if (uwbMicoPlayerViewModel != null) {
            return uwbMicoPlayerViewModel;
        }
        ixe.O000000o("viewModel");
        throw null;
    }

    public final void setViewModel(UwbMicoPlayerViewModel uwbMicoPlayerViewModel) {
        ixe.O00000o(uwbMicoPlayerViewModel, "<set-?>");
        this.viewModel = uwbMicoPlayerViewModel;
    }

    public final int getMStatus() {
        return this.mStatus;
    }

    public final void setMStatus(int i) {
        this.mStatus = i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UwbMicoProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ixe.O00000o(context, "context");
        this.MAX_PROGRESS = 1000;
        this.mStatus = -1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UwbMicoProgressBar(Context context, AttributeSet attributeSet, int i, int i2, ixc ixc) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.player_control_bar_init_time);
        ixe.O00000Oo(findViewById, "findViewById(R.id.player_control_bar_init_time)");
        setMInitTime((TextView) findViewById);
        View findViewById2 = findViewById(R.id.player_control_bar_end_time);
        ixe.O00000Oo(findViewById2, "findViewById(R.id.player_control_bar_end_time)");
        setMEndTime((TextView) findViewById2);
        View findViewById3 = findViewById(R.id.player_control_bar_progress_seek);
        ixe.O00000Oo(findViewById3, "findViewById(R.id.player_control_bar_progress_seek)");
        setMSeekBar((SeekBar) findViewById3);
        getMInitTime().setText(CommonUtils.secondToTime(0));
        getMEndTime().setText(CommonUtils.secondToTime(0));
        getMSeekBar().setMax(this.MAX_PROGRESS);
        getMSeekBar().setOnSeekBarChangeListener(new UwbMicoProgressBar$onFinishInflate$1(this));
        Context context = getContext();
        if (context != null) {
            fm O000000o2 = fo.O000000o((UwbMicoActivity) context).O000000o(UwbMicoPlayerViewModel.class);
            ixe.O00000Oo(O000000o2, "of(context as UwbMicoActivity).get(UwbMicoPlayerViewModel::class.java)");
            setViewModel((UwbMicoPlayerViewModel) O000000o2);
            fg<Void> durationUpdateLiveData = getViewModel().getDurationUpdateLiveData();
            Context context2 = getContext();
            if (context2 != null) {
                durationUpdateLiveData.observe((UwbMicoActivity) context2, new fh() {
                    /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoProgressBar$eOmRJr5QSfGfe3zTFDbB90nNjls */

                    public final void onChanged(Object obj) {
                        UwbMicoProgressBar.m559onFinishInflate$lambda0(UwbMicoProgressBar.this, (Void) obj);
                    }
                });
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.uwb.mico.UwbMicoActivity");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.uwb.mico.UwbMicoActivity");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    /* renamed from: onFinishInflate$lambda-0  reason: not valid java name */
    public static final void m559onFinishInflate$lambda0(UwbMicoProgressBar uwbMicoProgressBar, Void voidR) {
        ixe.O00000o(uwbMicoProgressBar, "this$0");
        gsy.O000000o(4, "UwbMicoProgressBar", ixe.O000000o("onFinishInflate: durationUpdateLiveData更新事件 ", (Object) Integer.valueOf(uwbMicoProgressBar.getMStatus())));
        if (1 == uwbMicoProgressBar.getMStatus()) {
            uwbMicoProgressBar.updateProgress(uwbMicoProgressBar.getPlayingData());
        }
    }

    public final void updateProgress(Remote.Response.PlayingData playingData2) {
        long j;
        long j2;
        this.playingData = playingData2;
        if (playingData2 == null) {
            j = 0;
        } else {
            j = playingData2.position;
        }
        if (playingData2 == null) {
            j2 = 0;
        } else {
            j2 = playingData2.duration;
        }
        getMInitTime().setText(CommonUtils.secondToTime(j / 1000));
        getMEndTime().setText(CommonUtils.secondToTime(j2 / 1000));
        if (j2 > 0) {
            getMSeekBar().setProgress((int) ((((long) this.MAX_PROGRESS) * j) / j2));
        } else {
            getMSeekBar().setProgress(0);
        }
    }

    public final void notifyUpdatePlayerPosition(int i, boolean z) {
        gsy.O000000o(4, "UwbMicoProgressBar", "notifyUpdatePlayerPosition: " + i + ' ' + z);
        getViewModel().getPlayerPositionLiveData().postValue(new MusicEvent.PlayerPositionEvent(i, z));
    }
}

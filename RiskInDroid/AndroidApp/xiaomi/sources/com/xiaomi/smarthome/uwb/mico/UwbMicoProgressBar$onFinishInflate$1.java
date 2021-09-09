package com.xiaomi.smarthome.uwb.mico;

import _m_j.hxi;
import _m_j.ixe;
import android.widget.SeekBar;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.smarthome.uwb.mico.Command;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/xiaomi/smarthome/uwb/mico/UwbMicoProgressBar$onFinishInflate$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoProgressBar$onFinishInflate$1 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ UwbMicoProgressBar this$0;

    UwbMicoProgressBar$onFinishInflate$1(UwbMicoProgressBar uwbMicoProgressBar) {
        this.this$0 = uwbMicoProgressBar;
    }

    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        ixe.O00000o(seekBar, "seekBar");
        Remote.Response.PlayingData playingData = this.this$0.getPlayingData();
        long j = playingData == null ? 0 : playingData.duration;
        if (j > 0) {
            int i2 = (int) ((((long) i) * j) / ((long) this.this$0.MAX_PROGRESS));
            this.this$0.notifyUpdatePlayerPosition(i2, z);
            if (z) {
                this.this$0.getMInitTime().setText(CommonUtils.secondToTime(((long) i2) / 1000));
            }
        }
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        ixe.O00000o(seekBar, "seekBar");
        this.this$0.mIsDragging = true;
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        ixe.O00000o(seekBar, "seekBar");
        UwbMicoProgressBar uwbMicoProgressBar = this.this$0;
        uwbMicoProgressBar.mIsDragging = false;
        Remote.Response.PlayingData playingData = uwbMicoProgressBar.getPlayingData();
        long j = playingData == null ? 0 : playingData.duration;
        if (j > 0) {
            this.this$0.getViewModel().sendCommand(new Command.Seek((long) ((int) ((((long) seekBar.getProgress()) * j) / ((long) this.this$0.MAX_PROGRESS)))));
        }
        hxi.O00000o.f952O000000o.O000000o("uwb_mico_seek_bar_click", new Object[0]);
    }
}

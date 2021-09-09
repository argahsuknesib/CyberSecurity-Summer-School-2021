package com.xiaomi.smarthome.uwb.mico;

import _m_j.hzf;
import _m_j.ixe;
import android.widget.SeekBar;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.mico.Command;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/xiaomi/smarthome/uwb/mico/UwbMicoActivity$initView$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoActivity$initView$1 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ UwbMicoActivity this$0;

    public final void onStartTrackingTouch(SeekBar seekBar) {
        ixe.O00000o(seekBar, "seekBar");
    }

    UwbMicoActivity$initView$1(UwbMicoActivity uwbMicoActivity) {
        this.this$0 = uwbMicoActivity;
    }

    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        ixe.O00000o(seekBar, "seekBar");
        if (i < 6) {
            ((VolumeBar) this.this$0.findViewById(R.id.player_volume_bar)).setProgress(6);
        }
        if (z && i % 2 == 0) {
            hzf.O00000o((VolumeBar) this.this$0.findViewById(R.id.player_volume_bar));
        }
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        ixe.O00000o(seekBar, "seekBar");
        this.this$0.getMUwbMicoPlayerViewModel().sendCommand(new Command.ModifyVolumeByValue(seekBar.getProgress()));
        this.this$0.setLastModifyVolumeActionTime(System.currentTimeMillis());
    }
}

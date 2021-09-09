package com.xiaomi.smarthome.uwb.mico;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/MicoBaseAction;", "", "modifyVolumeByValue", "", "int", "", "next", "playOrPause", "play", "", "prev", "seek", "position", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface MicoBaseAction {
    void modifyVolumeByValue(int i);

    void next();

    void playOrPause(boolean z);

    void prev();

    void seek(long j);
}

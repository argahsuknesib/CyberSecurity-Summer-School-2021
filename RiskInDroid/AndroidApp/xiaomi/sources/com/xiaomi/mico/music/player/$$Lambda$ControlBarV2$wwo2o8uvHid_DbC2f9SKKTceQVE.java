package com.xiaomi.mico.music.player;

import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.smarthome.R;
import rx.functions.Action1;

/* renamed from: com.xiaomi.mico.music.player.-$$Lambda$ControlBarV2$wwo2o8uvHid_DbC2f9SKKTceQVE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ControlBarV2$wwo2o8uvHid_DbC2f9SKKTceQVE implements Action1 {
    public static final /* synthetic */ $$Lambda$ControlBarV2$wwo2o8uvHid_DbC2f9SKKTceQVE INSTANCE = new $$Lambda$ControlBarV2$wwo2o8uvHid_DbC2f9SKKTceQVE();

    private /* synthetic */ $$Lambda$ControlBarV2$wwo2o8uvHid_DbC2f9SKKTceQVE() {
    }

    public final void call(Object obj) {
        ToastUtil.showToast((int) R.string.music_channel_add_song_failed);
    }
}

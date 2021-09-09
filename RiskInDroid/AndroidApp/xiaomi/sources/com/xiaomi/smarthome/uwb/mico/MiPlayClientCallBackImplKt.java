package com.xiaomi.smarthome.uwb.mico;

import android.text.TextUtils;
import com.xiaomi.miplay.audioclient.MediaMetaData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0003"}, d2 = {"isEmpty", "", "Lcom/xiaomi/miplay/audioclient/MediaMetaData;", "uwb-mico_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class MiPlayClientCallBackImplKt {
    public static final boolean isEmpty(MediaMetaData mediaMetaData) {
        if (mediaMetaData == null) {
            return true;
        }
        if (!TextUtils.isEmpty(mediaMetaData.f6038O000000o) || !TextUtils.isEmpty(mediaMetaData.O00000Oo) || mediaMetaData.O00000o != 0 || !TextUtils.isEmpty(mediaMetaData.O00000oO) || !TextUtils.isEmpty(mediaMetaData.O00000oo) || mediaMetaData.O0000O0o != 0 || mediaMetaData.O0000OOo != 0 || mediaMetaData.O0000Oo0 != null) {
            return false;
        }
        return true;
    }
}

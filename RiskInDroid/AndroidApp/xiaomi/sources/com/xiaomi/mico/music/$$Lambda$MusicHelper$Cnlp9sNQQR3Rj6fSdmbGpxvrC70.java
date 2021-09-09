package com.xiaomi.mico.music;

import com.xiaomi.mico.music.channel.ChannelManager;
import rx.functions.Func1;

/* renamed from: com.xiaomi.mico.music.-$$Lambda$MusicHelper$Cnlp9sNQQR3Rj6fSdmbGpxvrC70  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$MusicHelper$Cnlp9sNQQR3Rj6fSdmbGpxvrC70 implements Func1 {
    public static final /* synthetic */ $$Lambda$MusicHelper$Cnlp9sNQQR3Rj6fSdmbGpxvrC70 INSTANCE = new $$Lambda$MusicHelper$Cnlp9sNQQR3Rj6fSdmbGpxvrC70();

    private /* synthetic */ $$Lambda$MusicHelper$Cnlp9sNQQR3Rj6fSdmbGpxvrC70() {
    }

    public final Object call(Object obj) {
        return ChannelManager.getInstance().createChannel((String) obj);
    }
}

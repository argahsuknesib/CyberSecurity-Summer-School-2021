package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Util;
import java.util.UUID;

public final class FrameworkMediaCrypto implements ExoMediaCrypto {
    public static final boolean WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC = ("Amazon".equals(Util.MANUFACTURER) && ("AFTM".equals(Util.MODEL) || "AFTB".equals(Util.MODEL)));
    public final boolean forceAllowInsecureDecoderComponents;
    public final byte[] sessionId;
    public final UUID uuid;

    public FrameworkMediaCrypto(UUID uuid2, byte[] bArr, boolean z) {
        this.uuid = uuid2;
        this.sessionId = bArr;
        this.forceAllowInsecureDecoderComponents = z;
    }
}

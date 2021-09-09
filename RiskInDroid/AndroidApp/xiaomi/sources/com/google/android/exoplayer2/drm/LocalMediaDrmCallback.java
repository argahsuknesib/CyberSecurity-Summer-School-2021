package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.UUID;

public final class LocalMediaDrmCallback implements MediaDrmCallback {
    private final byte[] keyResponse;

    public LocalMediaDrmCallback(byte[] bArr) {
        this.keyResponse = (byte[]) Assertions.checkNotNull(bArr);
    }

    public final byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws IOException {
        throw new UnsupportedOperationException();
    }

    public final byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws Exception {
        return this.keyResponse;
    }
}

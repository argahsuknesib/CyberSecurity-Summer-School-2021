package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DummyExoMediaDrm implements ExoMediaDrm {
    public final void acquire() {
    }

    public final void closeSession(byte[] bArr) {
    }

    public final Class<ExoMediaCrypto> getExoMediaCryptoType() {
        return null;
    }

    public final PersistableBundle getMetrics() {
        return null;
    }

    public final String getPropertyString(String str) {
        return "";
    }

    public final void release() {
    }

    public final void setOnEventListener(ExoMediaDrm.OnEventListener onEventListener) {
    }

    public final void setOnExpirationUpdateListener(ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
    }

    public final void setOnKeyStatusChangeListener(ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
    }

    public final void setPropertyByteArray(String str, byte[] bArr) {
    }

    public final void setPropertyString(String str, String str2) {
    }

    public static DummyExoMediaDrm getInstance() {
        return new DummyExoMediaDrm();
    }

    public final byte[] openSession() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    public final ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, List<DrmInitData.SchemeData> list, int i, HashMap<String, String> hashMap) {
        throw new IllegalStateException();
    }

    public final byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    public final ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        throw new IllegalStateException();
    }

    public final void provideProvisionResponse(byte[] bArr) {
        throw new IllegalStateException();
    }

    public final Map<String, String> queryKeyStatus(byte[] bArr) {
        throw new IllegalStateException();
    }

    public final void restoreKeys(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    public final byte[] getPropertyByteArray(String str) {
        return Util.EMPTY_BYTE_ARRAY;
    }

    public final ExoMediaCrypto createMediaCrypto(byte[] bArr) {
        throw new IllegalStateException();
    }
}

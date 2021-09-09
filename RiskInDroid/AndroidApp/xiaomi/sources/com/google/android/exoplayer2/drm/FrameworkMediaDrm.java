package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import android.os.PersistableBundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@TargetApi(23)
public final class FrameworkMediaDrm implements ExoMediaDrm {
    public static final ExoMediaDrm.Provider DEFAULT_PROVIDER = $$Lambda$FrameworkMediaDrm$fyEvjdXZtw4JXHhoyBbC_yZqs.INSTANCE;
    private final MediaDrm mediaDrm;
    private int referenceCount = 1;
    private final UUID uuid;

    static /* synthetic */ ExoMediaDrm lambda$static$0(UUID uuid2) {
        try {
            return newInstance(uuid2);
        } catch (UnsupportedDrmException unused) {
            Log.e("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid2 + ".");
            return new DummyExoMediaDrm();
        }
    }

    public static FrameworkMediaDrm newInstance(UUID uuid2) throws UnsupportedDrmException {
        try {
            return new FrameworkMediaDrm(uuid2);
        } catch (UnsupportedSchemeException e) {
            throw new UnsupportedDrmException(1, e);
        } catch (Exception e2) {
            throw new UnsupportedDrmException(2, e2);
        }
    }

    private FrameworkMediaDrm(UUID uuid2) throws UnsupportedSchemeException {
        Assertions.checkNotNull(uuid2);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uuid2), "Use C.CLEARKEY_UUID instead");
        this.uuid = uuid2;
        this.mediaDrm = new MediaDrm(adjustUuid(uuid2));
        if (C.WIDEVINE_UUID.equals(uuid2) && needsForceWidevineL3Workaround()) {
            forceWidevineL3(this.mediaDrm);
        }
    }

    public final void setOnEventListener(ExoMediaDrm.OnEventListener onEventListener) {
        this.mediaDrm.setOnEventListener(onEventListener == null ? null : new MediaDrm.OnEventListener(onEventListener) {
            /* class com.google.android.exoplayer2.drm.$$Lambda$FrameworkMediaDrm$ZhqohC_ggz8O8ICABXcUug2FsgA */
            private final /* synthetic */ ExoMediaDrm.OnEventListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                FrameworkMediaDrm.this.lambda$setOnEventListener$1$FrameworkMediaDrm(this.f$1, mediaDrm, bArr, i, i2, bArr2);
            }
        });
    }

    public /* synthetic */ void lambda$setOnEventListener$1$FrameworkMediaDrm(ExoMediaDrm.OnEventListener onEventListener, MediaDrm mediaDrm2, byte[] bArr, int i, int i2, byte[] bArr2) {
        onEventListener.onEvent(this, bArr, i, i2, bArr2);
    }

    public final void setOnKeyStatusChangeListener(ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
        if (Util.SDK_INT >= 23) {
            this.mediaDrm.setOnKeyStatusChangeListener(onKeyStatusChangeListener == null ? null : new MediaDrm.OnKeyStatusChangeListener(onKeyStatusChangeListener) {
                /* class com.google.android.exoplayer2.drm.$$Lambda$FrameworkMediaDrm$FRubkfdaAJXhD5lYFCf_Ks_2U1Y */
                private final /* synthetic */ ExoMediaDrm.OnKeyStatusChangeListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List list, boolean z) {
                    FrameworkMediaDrm.this.lambda$setOnKeyStatusChangeListener$2$FrameworkMediaDrm(this.f$1, mediaDrm, bArr, list, z);
                }
            }, (Handler) null);
            return;
        }
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ void lambda$setOnKeyStatusChangeListener$2$FrameworkMediaDrm(ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener, MediaDrm mediaDrm2, byte[] bArr, List list, boolean z) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MediaDrm.KeyStatus keyStatus = (MediaDrm.KeyStatus) it.next();
            arrayList.add(new ExoMediaDrm.KeyStatus(keyStatus.getStatusCode(), keyStatus.getKeyId()));
        }
        onKeyStatusChangeListener.onKeyStatusChange(this, bArr, arrayList, z);
    }

    public final void setOnExpirationUpdateListener(ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
        if (Util.SDK_INT >= 23) {
            this.mediaDrm.setOnExpirationUpdateListener(onExpirationUpdateListener == null ? null : new MediaDrm.OnExpirationUpdateListener(onExpirationUpdateListener) {
                /* class com.google.android.exoplayer2.drm.$$Lambda$FrameworkMediaDrm$ZS7zk6_etzj1vQq8b0VCYr8Vtck */
                private final /* synthetic */ ExoMediaDrm.OnExpirationUpdateListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onExpirationUpdate(MediaDrm mediaDrm, byte[] bArr, long j) {
                    FrameworkMediaDrm.this.lambda$setOnExpirationUpdateListener$3$FrameworkMediaDrm(this.f$1, mediaDrm, bArr, j);
                }
            }, (Handler) null);
            return;
        }
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ void lambda$setOnExpirationUpdateListener$3$FrameworkMediaDrm(ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener, MediaDrm mediaDrm2, byte[] bArr, long j) {
        onExpirationUpdateListener.onExpirationUpdate(this, bArr, j);
    }

    public final byte[] openSession() throws MediaDrmException {
        return this.mediaDrm.openSession();
    }

    public final void closeSession(byte[] bArr) {
        this.mediaDrm.closeSession(bArr);
    }

    public final ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, List<DrmInitData.SchemeData> list, int i, HashMap<String, String> hashMap) throws NotProvisionedException {
        String str;
        byte[] bArr2;
        DrmInitData.SchemeData schemeData = null;
        if (list != null) {
            schemeData = getSchemeData(this.uuid, list);
            bArr2 = adjustRequestInitData(this.uuid, (byte[]) Assertions.checkNotNull(schemeData.data));
            str = adjustRequestMimeType(this.uuid, schemeData.mimeType);
        } else {
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.mediaDrm.getKeyRequest(bArr, bArr2, str, i, hashMap);
        byte[] adjustRequestData = adjustRequestData(this.uuid, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeData != null && !TextUtils.isEmpty(schemeData.licenseServerUrl)) {
            defaultUrl = schemeData.licenseServerUrl;
        }
        return new ExoMediaDrm.KeyRequest(adjustRequestData, defaultUrl);
    }

    public final byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (C.CLEARKEY_UUID.equals(this.uuid)) {
            bArr2 = ClearKeyUtil.adjustResponseData(bArr2);
        }
        return this.mediaDrm.provideKeyResponse(bArr, bArr2);
    }

    public final ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.mediaDrm.getProvisionRequest();
        return new ExoMediaDrm.ProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    public final void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        this.mediaDrm.provideProvisionResponse(bArr);
    }

    public final Map<String, String> queryKeyStatus(byte[] bArr) {
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    public final synchronized void acquire() {
        Assertions.checkState(this.referenceCount > 0);
        this.referenceCount++;
    }

    public final synchronized void release() {
        int i = this.referenceCount - 1;
        this.referenceCount = i;
        if (i == 0) {
            this.mediaDrm.release();
        }
    }

    public final void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.mediaDrm.restoreKeys(bArr, bArr2);
    }

    @TargetApi(28)
    public final PersistableBundle getMetrics() {
        if (Util.SDK_INT < 28) {
            return null;
        }
        return this.mediaDrm.getMetrics();
    }

    public final String getPropertyString(String str) {
        return this.mediaDrm.getPropertyString(str);
    }

    public final byte[] getPropertyByteArray(String str) {
        return this.mediaDrm.getPropertyByteArray(str);
    }

    public final void setPropertyString(String str, String str2) {
        this.mediaDrm.setPropertyString(str, str2);
    }

    public final void setPropertyByteArray(String str, byte[] bArr) {
        this.mediaDrm.setPropertyByteArray(str, bArr);
    }

    public final FrameworkMediaCrypto createMediaCrypto(byte[] bArr) throws MediaCryptoException {
        return new FrameworkMediaCrypto(adjustUuid(this.uuid), bArr, Util.SDK_INT < 21 && C.WIDEVINE_UUID.equals(this.uuid) && "L3".equals(getPropertyString("securityLevel")));
    }

    public final Class<FrameworkMediaCrypto> getExoMediaCryptoType() {
        return FrameworkMediaCrypto.class;
    }

    private static DrmInitData.SchemeData getSchemeData(UUID uuid2, List<DrmInitData.SchemeData> list) {
        boolean z;
        if (!C.WIDEVINE_UUID.equals(uuid2)) {
            return list.get(0);
        }
        if (Util.SDK_INT >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = list.get(0);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= list.size()) {
                    z = true;
                    break;
                }
                DrmInitData.SchemeData schemeData2 = list.get(i);
                byte[] bArr = (byte[]) Util.castNonNull(schemeData2.data);
                if (!Util.areEqual(schemeData2.mimeType, schemeData.mimeType) || !Util.areEqual(schemeData2.licenseServerUrl, schemeData.licenseServerUrl) || !PsshAtomUtil.isPsshAtom(bArr)) {
                    z = false;
                } else {
                    i2 += bArr.length;
                    i++;
                }
            }
            z = false;
            if (z) {
                byte[] bArr2 = new byte[i2];
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    byte[] bArr3 = (byte[]) Util.castNonNull(list.get(i4).data);
                    int length = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i3, length);
                    i3 += length;
                }
                return schemeData.copyWithData(bArr2);
            }
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            DrmInitData.SchemeData schemeData3 = list.get(i5);
            int parseVersion = PsshAtomUtil.parseVersion((byte[]) Util.castNonNull(schemeData3.data));
            if (Util.SDK_INT < 23 && parseVersion == 0) {
                return schemeData3;
            }
            if (Util.SDK_INT >= 23 && parseVersion == 1) {
                return schemeData3;
            }
        }
        return list.get(0);
    }

    private static UUID adjustUuid(UUID uuid2) {
        return (Util.SDK_INT >= 27 || !C.CLEARKEY_UUID.equals(uuid2)) ? uuid2 : C.COMMON_PSSH_UUID;
    }

    private static byte[] adjustRequestInitData(UUID uuid2, byte[] bArr) {
        byte[] parseSchemeSpecificData;
        if (C.PLAYREADY_UUID.equals(uuid2)) {
            byte[] parseSchemeSpecificData2 = PsshAtomUtil.parseSchemeSpecificData(bArr, uuid2);
            if (parseSchemeSpecificData2 != null) {
                bArr = parseSchemeSpecificData2;
            }
            bArr = PsshAtomUtil.buildPsshAtom(C.PLAYREADY_UUID, addLaUrlAttributeIfMissing(bArr));
        }
        return (((Util.SDK_INT >= 23 || !C.WIDEVINE_UUID.equals(uuid2)) && (!C.PLAYREADY_UUID.equals(uuid2) || !"Amazon".equals(Util.MANUFACTURER) || (!"AFTB".equals(Util.MODEL) && !"AFTS".equals(Util.MODEL) && !"AFTM".equals(Util.MODEL) && !"AFTT".equals(Util.MODEL)))) || (parseSchemeSpecificData = PsshAtomUtil.parseSchemeSpecificData(bArr, uuid2)) == null) ? bArr : parseSchemeSpecificData;
    }

    private static String adjustRequestMimeType(UUID uuid2, String str) {
        return (Util.SDK_INT >= 26 || !C.CLEARKEY_UUID.equals(uuid2) || (!"video/mp4".equals(str) && !"audio/mp4".equals(str))) ? str : "cenc";
    }

    private static byte[] adjustRequestData(UUID uuid2, byte[] bArr) {
        return C.CLEARKEY_UUID.equals(uuid2) ? ClearKeyUtil.adjustRequestData(bArr) : bArr;
    }

    @SuppressLint({"WrongConstant"})
    private static void forceWidevineL3(MediaDrm mediaDrm2) {
        mediaDrm2.setPropertyString("securityLevel", "L3");
    }

    private static boolean needsForceWidevineL3Workaround() {
        return "ASUS_Z00AD".equals(Util.MODEL);
    }

    private static byte[] addLaUrlAttributeIfMissing(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
        short readLittleEndianShort = parsableByteArray.readLittleEndianShort();
        short readLittleEndianShort2 = parsableByteArray.readLittleEndianShort();
        if (readLittleEndianShort == 1 && readLittleEndianShort2 == 1) {
            String readString = parsableByteArray.readString(parsableByteArray.readLittleEndianShort(), Charset.forName("UTF-16LE"));
            if (readString.contains("<LA_URL>")) {
                return bArr;
            }
            int indexOf = readString.indexOf("</DATA>");
            if (indexOf == -1) {
                Log.w("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
            }
            String str = readString.substring(0, indexOf) + "<LA_URL>https://x</LA_URL>" + readString.substring(indexOf);
            int i = readLittleEndianInt + 52;
            ByteBuffer allocate = ByteBuffer.allocate(i);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(i);
            allocate.putShort((short) readLittleEndianShort);
            allocate.putShort((short) readLittleEndianShort2);
            allocate.putShort((short) (str.length() * 2));
            allocate.put(str.getBytes(Charset.forName("UTF-16LE")));
            return allocate.array();
        }
        Log.i("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
        return bArr;
    }
}

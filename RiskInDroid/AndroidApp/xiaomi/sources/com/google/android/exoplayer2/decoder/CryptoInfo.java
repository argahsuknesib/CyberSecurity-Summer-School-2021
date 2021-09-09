package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec;
import com.google.android.exoplayer2.util.Util;

public final class CryptoInfo {
    public int clearBlocks;
    public int encryptedBlocks;
    private final MediaCodec.CryptoInfo frameworkCryptoInfo = new MediaCodec.CryptoInfo();
    public byte[] iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;
    private final PatternHolderV24 patternHolder;

    public CryptoInfo() {
        this.patternHolder = Util.SDK_INT >= 24 ? new PatternHolderV24(this.frameworkCryptoInfo) : null;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.encryptedBlocks = i3;
        this.clearBlocks = i4;
        MediaCodec.CryptoInfo cryptoInfo = this.frameworkCryptoInfo;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (Util.SDK_INT >= 24) {
            this.patternHolder.set(i3, i4);
        }
    }

    public final MediaCodec.CryptoInfo getFrameworkCryptoInfo() {
        return this.frameworkCryptoInfo;
    }

    @Deprecated
    public final MediaCodec.CryptoInfo getFrameworkCryptoInfoV16() {
        return getFrameworkCryptoInfo();
    }

    public final void increaseClearDataFirstSubSampleBy(int i) {
        if (i != 0) {
            if (this.numBytesOfClearData == null) {
                this.numBytesOfClearData = new int[1];
                this.frameworkCryptoInfo.numBytesOfClearData = this.numBytesOfClearData;
            }
            int[] iArr = this.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
    }

    static final class PatternHolderV24 {
        private final MediaCodec.CryptoInfo frameworkCryptoInfo;
        private final MediaCodec.CryptoInfo.Pattern pattern;

        private PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
            this.frameworkCryptoInfo = cryptoInfo;
            this.pattern = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        public final void set(int i, int i2) {
            this.pattern.set(i, i2);
            this.frameworkCryptoInfo.setPattern(this.pattern);
        }
    }
}

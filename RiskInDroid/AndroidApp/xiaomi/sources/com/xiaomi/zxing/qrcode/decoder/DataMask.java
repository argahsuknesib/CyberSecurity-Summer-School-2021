package com.xiaomi.zxing.qrcode.decoder;

import _m_j.idm;

public enum DataMask {
    DATA_MASK_000 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    },
    DATA_MASK_001 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i, int i2) {
            return (i & 1) == 0;
        }
    },
    DATA_MASK_010 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i, int i2) {
            return i2 % 3 == 0;
        }
    },
    DATA_MASK_011 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    },
    DATA_MASK_100 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i, int i2) {
            return (((i / 2) + (i2 / 3)) & 1) == 0;
        }
    },
    DATA_MASK_101 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i, int i2) {
            int i3 = i * i2;
            return (i3 & 1) + (i3 % 3) == 0;
        }
    },
    DATA_MASK_110 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i, int i2) {
            int i3 = i * i2;
            return (((i3 & 1) + (i3 % 3)) & 1) == 0;
        }
    },
    DATA_MASK_111 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i, int i2) {
            return ((((i + i2) & 1) + ((i * i2) % 3)) & 1) == 0;
        }
    };

    /* access modifiers changed from: package-private */
    public abstract boolean isMasked(int i, int i2);

    public final void unmaskBitMatrix(idm idm, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (isMasked(i2, i3)) {
                    idm.O00000o0(i3, i2);
                }
            }
        }
    }
}

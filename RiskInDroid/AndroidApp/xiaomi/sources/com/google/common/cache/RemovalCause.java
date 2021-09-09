package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public enum RemovalCause {
    EXPLICIT {
        /* access modifiers changed from: package-private */
        public final boolean wasEvicted() {
            return false;
        }
    },
    REPLACED {
        /* access modifiers changed from: package-private */
        public final boolean wasEvicted() {
            return false;
        }
    },
    COLLECTED {
        /* access modifiers changed from: package-private */
        public final boolean wasEvicted() {
            return true;
        }
    },
    EXPIRED {
        /* access modifiers changed from: package-private */
        public final boolean wasEvicted() {
            return true;
        }
    },
    SIZE {
        /* access modifiers changed from: package-private */
        public final boolean wasEvicted() {
            return true;
        }
    };

    /* access modifiers changed from: package-private */
    public abstract boolean wasEvicted();
}

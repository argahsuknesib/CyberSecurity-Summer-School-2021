package android.support.v4.app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.v4.app.RemoteInputCompatBase;
import android.util.Log;

public final class RemoteInput extends RemoteInputCompatBase.RemoteInput {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final RemoteInputCompatBase.RemoteInput.Factory FACTORY = new RemoteInputCompatBase.RemoteInput.Factory() {
        /* class android.support.v4.app.RemoteInput.AnonymousClass1 */

        public final RemoteInput build(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
            return new RemoteInput(str, charSequence, charSequenceArr, z, bundle);
        }

        public final RemoteInput[] newArray(int i) {
            return new RemoteInput[i];
        }
    };
    private static final Impl IMPL;
    private final boolean mAllowFreeFormInput;
    private final CharSequence[] mChoices;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    interface Impl {
        void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle);

        Bundle getResultsFromIntent(Intent intent);
    }

    RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.mResultKey = str;
        this.mLabel = charSequence;
        this.mChoices = charSequenceArr;
        this.mAllowFreeFormInput = z;
        this.mExtras = bundle;
    }

    public final String getResultKey() {
        return this.mResultKey;
    }

    public final CharSequence getLabel() {
        return this.mLabel;
    }

    public final CharSequence[] getChoices() {
        return this.mChoices;
    }

    public final boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormInput;
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }

    public static final class Builder {
        private boolean mAllowFreeFormInput = true;
        private CharSequence[] mChoices;
        private Bundle mExtras = new Bundle();
        private CharSequence mLabel;
        private final String mResultKey;

        public Builder(String str) {
            if (str != null) {
                this.mResultKey = str;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        public final Builder setLabel(CharSequence charSequence) {
            this.mLabel = charSequence;
            return this;
        }

        public final Builder setChoices(CharSequence[] charSequenceArr) {
            this.mChoices = charSequenceArr;
            return this;
        }

        public final Builder setAllowFreeFormInput(boolean z) {
            this.mAllowFreeFormInput = z;
            return this;
        }

        public final Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                this.mExtras.putAll(bundle);
            }
            return this;
        }

        public final Bundle getExtras() {
            return this.mExtras;
        }

        public final RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormInput, this.mExtras);
        }
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return IMPL.getResultsFromIntent(intent);
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        IMPL.addResultsToIntent(remoteInputArr, intent, bundle);
    }

    static class ImplBase implements Impl {
        ImplBase() {
        }

        public Bundle getResultsFromIntent(Intent intent) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
            return null;
        }

        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        }
    }

    static class ImplJellybean implements Impl {
        ImplJellybean() {
        }

        public Bundle getResultsFromIntent(Intent intent) {
            return RemoteInputCompatJellybean.getResultsFromIntent(intent);
        }

        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            RemoteInputCompatJellybean.addResultsToIntent(remoteInputArr, intent, bundle);
        }
    }

    static class ImplApi20 implements Impl {
        ImplApi20() {
        }

        public Bundle getResultsFromIntent(Intent intent) {
            return RemoteInputCompatApi20.getResultsFromIntent(intent);
        }

        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            RemoteInputCompatApi20.addResultsToIntent(remoteInputArr, intent, bundle);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 20) {
            IMPL = new ImplApi20();
        } else if (Build.VERSION.SDK_INT >= 16) {
            IMPL = new ImplJellybean();
        } else {
            IMPL = new ImplBase();
        }
    }
}

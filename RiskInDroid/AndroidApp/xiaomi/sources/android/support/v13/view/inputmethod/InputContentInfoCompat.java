package android.support.v13.view.inputmethod;

import android.annotation.TargetApi;
import android.content.ClipDescription;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.os.BuildCompat;

@TargetApi(13)
@RequiresApi(13)
public final class InputContentInfoCompat {
    private final InputContentInfoCompatImpl mImpl;

    interface InputContentInfoCompatImpl {
        @NonNull
        Uri getContentUri();

        @NonNull
        ClipDescription getDescription();

        @Nullable
        Object getInputContentInfo();

        @Nullable
        Uri getLinkUri();

        void releasePermission();

        void requestPermission();
    }

    static final class BaseInputContentInfoCompatImpl implements InputContentInfoCompatImpl {
        @NonNull
        private final Uri mContentUri;
        @NonNull
        private final ClipDescription mDescription;
        @Nullable
        private final Uri mLinkUri;

        @Nullable
        public final Object getInputContentInfo() {
            return null;
        }

        public final void releasePermission() {
        }

        public final void requestPermission() {
        }

        public BaseInputContentInfoCompatImpl(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.mContentUri = uri;
            this.mDescription = clipDescription;
            this.mLinkUri = uri2;
        }

        @NonNull
        public final Uri getContentUri() {
            return this.mContentUri;
        }

        @NonNull
        public final ClipDescription getDescription() {
            return this.mDescription;
        }

        @Nullable
        public final Uri getLinkUri() {
            return this.mLinkUri;
        }
    }

    static final class Api25InputContentInfoCompatImpl implements InputContentInfoCompatImpl {
        @NonNull
        final Object mObject;

        public Api25InputContentInfoCompatImpl(@NonNull Object obj) {
            this.mObject = obj;
        }

        public Api25InputContentInfoCompatImpl(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.mObject = InputContentInfoCompatApi25.create(uri, clipDescription, uri2);
        }

        @NonNull
        public final Uri getContentUri() {
            return InputContentInfoCompatApi25.getContentUri(this.mObject);
        }

        @NonNull
        public final ClipDescription getDescription() {
            return InputContentInfoCompatApi25.getDescription(this.mObject);
        }

        @Nullable
        public final Uri getLinkUri() {
            return InputContentInfoCompatApi25.getLinkUri(this.mObject);
        }

        @Nullable
        public final Object getInputContentInfo() {
            return this.mObject;
        }

        public final void requestPermission() {
            InputContentInfoCompatApi25.requestPermission(this.mObject);
        }

        public final void releasePermission() {
            InputContentInfoCompatApi25.releasePermission(this.mObject);
        }
    }

    public InputContentInfoCompat(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
        if (BuildCompat.isAtLeastNMR1()) {
            this.mImpl = new Api25InputContentInfoCompatImpl(uri, clipDescription, uri2);
        } else {
            this.mImpl = new BaseInputContentInfoCompatImpl(uri, clipDescription, uri2);
        }
    }

    private InputContentInfoCompat(@NonNull InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.mImpl = inputContentInfoCompatImpl;
    }

    @NonNull
    public final Uri getContentUri() {
        return this.mImpl.getContentUri();
    }

    @NonNull
    public final ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    @Nullable
    public final Uri getLinkUri() {
        return this.mImpl.getLinkUri();
    }

    @Nullable
    public static InputContentInfoCompat wrap(@Nullable Object obj) {
        if (obj != null && BuildCompat.isAtLeastNMR1()) {
            return new InputContentInfoCompat(new Api25InputContentInfoCompatImpl(obj));
        }
        return null;
    }

    @Nullable
    public final Object unwrap() {
        return this.mImpl.getInputContentInfo();
    }

    public final void requestPermission() {
        this.mImpl.requestPermission();
    }

    public final void releasePermission() {
        this.mImpl.releasePermission();
    }
}

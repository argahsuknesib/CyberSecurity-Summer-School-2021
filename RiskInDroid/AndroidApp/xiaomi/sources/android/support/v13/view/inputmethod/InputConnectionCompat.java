package android.support.v13.view.inputmethod;

import android.annotation.TargetApi;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v13.view.inputmethod.InputConnectionCompatApi25;
import android.support.v4.os.BuildCompat;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

@TargetApi(13)
@RequiresApi(13)
public final class InputConnectionCompat {
    private static final InputConnectionCompatImpl IMPL;
    public static int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;

    interface InputConnectionCompatImpl {
        boolean commitContent(@NonNull InputConnection inputConnection, @NonNull InputContentInfoCompat inputContentInfoCompat, int i, @Nullable Bundle bundle);

        @NonNull
        InputConnection createWrapper(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull OnCommitContentListener onCommitContentListener);
    }

    public interface OnCommitContentListener {
        boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle);
    }

    static final class BaseInputContentInfoCompatImpl implements InputConnectionCompatImpl {
        private static String COMMIT_CONTENT_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
        private static String COMMIT_CONTENT_CONTENT_URI_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
        private static String COMMIT_CONTENT_DESCRIPTION_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
        private static String COMMIT_CONTENT_FLAGS_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
        private static String COMMIT_CONTENT_LINK_URI_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
        private static String COMMIT_CONTENT_OPTS_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
        private static String COMMIT_CONTENT_RESULT_RECEIVER = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";

        BaseInputContentInfoCompatImpl() {
        }

        public final boolean commitContent(@NonNull InputConnection inputConnection, @NonNull InputContentInfoCompat inputContentInfoCompat, int i, @Nullable Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(COMMIT_CONTENT_CONTENT_URI_KEY, inputContentInfoCompat.getContentUri());
            bundle2.putParcelable(COMMIT_CONTENT_DESCRIPTION_KEY, inputContentInfoCompat.getDescription());
            bundle2.putParcelable(COMMIT_CONTENT_LINK_URI_KEY, inputContentInfoCompat.getLinkUri());
            bundle2.putInt(COMMIT_CONTENT_FLAGS_KEY, i);
            bundle2.putParcelable(COMMIT_CONTENT_OPTS_KEY, bundle);
            return inputConnection.performPrivateCommand(COMMIT_CONTENT_ACTION, bundle2);
        }

        @NonNull
        public final InputConnection createWrapper(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull final OnCommitContentListener onCommitContentListener) {
            if (EditorInfoCompat.getContentMimeTypes(editorInfo).length == 0) {
                return inputConnection;
            }
            return new InputConnectionWrapper(inputConnection, false) {
                /* class android.support.v13.view.inputmethod.InputConnectionCompat.BaseInputContentInfoCompatImpl.AnonymousClass1 */

                public boolean performPrivateCommand(String str, Bundle bundle) {
                    if (BaseInputContentInfoCompatImpl.handlePerformPrivateCommand(str, bundle, onCommitContentListener)) {
                        return true;
                    }
                    return super.performPrivateCommand(str, bundle);
                }
            };
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
        static boolean handlePerformPrivateCommand(@Nullable String str, @NonNull Bundle bundle, @NonNull OnCommitContentListener onCommitContentListener) {
            ResultReceiver resultReceiver;
            if (!TextUtils.equals(COMMIT_CONTENT_ACTION, str) || bundle == null) {
                return false;
            }
            try {
                resultReceiver = (ResultReceiver) bundle.getParcelable(COMMIT_CONTENT_RESULT_RECEIVER);
                try {
                    boolean onCommitContent = onCommitContentListener.onCommitContent(new InputContentInfoCompat((Uri) bundle.getParcelable(COMMIT_CONTENT_CONTENT_URI_KEY), (ClipDescription) bundle.getParcelable(COMMIT_CONTENT_DESCRIPTION_KEY), (Uri) bundle.getParcelable(COMMIT_CONTENT_LINK_URI_KEY)), bundle.getInt(COMMIT_CONTENT_FLAGS_KEY), (Bundle) bundle.getParcelable(COMMIT_CONTENT_OPTS_KEY));
                    if (resultReceiver != null) {
                        resultReceiver.send(onCommitContent ? 1 : 0, null);
                    }
                    return onCommitContent;
                } catch (Throwable th) {
                    th = th;
                    if (resultReceiver != null) {
                        resultReceiver.send(0, null);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                resultReceiver = null;
                if (resultReceiver != null) {
                }
                throw th;
            }
        }
    }

    static final class Api25InputContentInfoCompatImpl implements InputConnectionCompatImpl {
        private Api25InputContentInfoCompatImpl() {
        }

        public final boolean commitContent(@NonNull InputConnection inputConnection, @NonNull InputContentInfoCompat inputContentInfoCompat, int i, @Nullable Bundle bundle) {
            return InputConnectionCompatApi25.commitContent(inputConnection, inputContentInfoCompat.unwrap(), i, bundle);
        }

        @Nullable
        public final InputConnection createWrapper(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo, @Nullable final OnCommitContentListener onCommitContentListener) {
            return InputConnectionCompatApi25.createWrapper(inputConnection, new InputConnectionCompatApi25.OnCommitContentListener() {
                /* class android.support.v13.view.inputmethod.InputConnectionCompat.Api25InputContentInfoCompatImpl.AnonymousClass1 */

                public boolean onCommitContent(Object obj, int i, Bundle bundle) {
                    return onCommitContentListener.onCommitContent(InputContentInfoCompat.wrap(obj), i, bundle);
                }
            });
        }
    }

    static {
        if (BuildCompat.isAtLeastNMR1()) {
            IMPL = new Api25InputContentInfoCompatImpl();
        } else {
            IMPL = new BaseInputContentInfoCompatImpl();
        }
    }

    public static boolean commitContent(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull InputContentInfoCompat inputContentInfoCompat, int i, @Nullable Bundle bundle) {
        boolean z;
        ClipDescription description = inputContentInfoCompat.getDescription();
        String[] contentMimeTypes = EditorInfoCompat.getContentMimeTypes(editorInfo);
        int length = contentMimeTypes.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (description.hasMimeType(contentMimeTypes[i2])) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            return false;
        }
        return IMPL.commitContent(inputConnection, inputContentInfoCompat, i, bundle);
    }

    @NonNull
    public static InputConnection createWrapper(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull OnCommitContentListener onCommitContentListener) {
        if (inputConnection == null) {
            throw new IllegalArgumentException("inputConnection must be non-null");
        } else if (editorInfo == null) {
            throw new IllegalArgumentException("editorInfo must be non-null");
        } else if (onCommitContentListener != null) {
            return IMPL.createWrapper(inputConnection, editorInfo, onCommitContentListener);
        } else {
            throw new IllegalArgumentException("onCommitContentListener must be non-null");
        }
    }
}

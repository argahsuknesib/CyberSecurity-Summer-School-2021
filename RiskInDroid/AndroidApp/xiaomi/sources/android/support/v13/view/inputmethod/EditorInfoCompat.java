package android.support.v13.view.inputmethod;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.os.BuildCompat;
import android.view.inputmethod.EditorInfo;

@TargetApi(13)
@RequiresApi(13)
public final class EditorInfoCompat {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final EditorInfoCompatImpl IMPL;

    interface EditorInfoCompatImpl {
        @NonNull
        String[] getContentMimeTypes(@NonNull EditorInfo editorInfo);

        void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr);
    }

    static {
        if (BuildCompat.isAtLeastNMR1()) {
            IMPL = new Api25EditorInfoCompatImpl();
        } else {
            IMPL = new BaseEditorInfoCompatImpl();
        }
    }

    static final class BaseEditorInfoCompatImpl implements EditorInfoCompatImpl {
        private static String CONTENT_MIME_TYPES_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";

        private BaseEditorInfoCompatImpl() {
        }

        public final void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, strArr);
        }

        @NonNull
        public final String[] getContentMimeTypes(@NonNull EditorInfo editorInfo) {
            if (editorInfo.extras == null) {
                return EditorInfoCompat.EMPTY_STRING_ARRAY;
            }
            String[] stringArray = editorInfo.extras.getStringArray(CONTENT_MIME_TYPES_KEY);
            if (stringArray != null) {
                return stringArray;
            }
            return EditorInfoCompat.EMPTY_STRING_ARRAY;
        }
    }

    static final class Api25EditorInfoCompatImpl implements EditorInfoCompatImpl {
        private Api25EditorInfoCompatImpl() {
        }

        public final void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
            EditorInfoCompatApi25.setContentMimeTypes(editorInfo, strArr);
        }

        @NonNull
        public final String[] getContentMimeTypes(@NonNull EditorInfo editorInfo) {
            String[] contentMimeTypes = EditorInfoCompatApi25.getContentMimeTypes(editorInfo);
            if (contentMimeTypes != null) {
                return contentMimeTypes;
            }
            return EditorInfoCompat.EMPTY_STRING_ARRAY;
        }
    }

    public static void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        IMPL.setContentMimeTypes(editorInfo, strArr);
    }

    @NonNull
    public static String[] getContentMimeTypes(EditorInfo editorInfo) {
        return IMPL.getContentMimeTypes(editorInfo);
    }
}

package android.support.v13.view.inputmethod;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.inputmethod.EditorInfo;

@TargetApi(25)
@RequiresApi(25)
final class EditorInfoCompatApi25 {
    EditorInfoCompatApi25() {
    }

    public static void setContentMimeTypes(EditorInfo editorInfo, String[] strArr) {
        editorInfo.contentMimeTypes = strArr;
    }

    public static String[] getContentMimeTypes(EditorInfo editorInfo) {
        return editorInfo.contentMimeTypes;
    }
}

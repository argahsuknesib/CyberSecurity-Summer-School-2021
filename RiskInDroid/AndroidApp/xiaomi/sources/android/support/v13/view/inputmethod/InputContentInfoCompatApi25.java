package android.support.v13.view.inputmethod;

import android.annotation.TargetApi;
import android.content.ClipDescription;
import android.net.Uri;
import android.support.annotation.RequiresApi;
import android.view.inputmethod.InputContentInfo;

@TargetApi(25)
@RequiresApi(25)
final class InputContentInfoCompatApi25 {
    InputContentInfoCompatApi25() {
    }

    public static Object create(Uri uri, ClipDescription clipDescription, Uri uri2) {
        return new InputContentInfo(uri, clipDescription, uri2);
    }

    public static Uri getContentUri(Object obj) {
        return ((InputContentInfo) obj).getContentUri();
    }

    public static ClipDescription getDescription(Object obj) {
        return ((InputContentInfo) obj).getDescription();
    }

    public static Uri getLinkUri(Object obj) {
        return ((InputContentInfo) obj).getLinkUri();
    }

    public static void requestPermission(Object obj) {
        ((InputContentInfo) obj).requestPermission();
    }

    public static void releasePermission(Object obj) {
        ((InputContentInfo) obj).releasePermission();
    }
}

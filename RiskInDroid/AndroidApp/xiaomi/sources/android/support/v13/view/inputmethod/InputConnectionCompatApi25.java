package android.support.v13.view.inputmethod;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

@TargetApi(25)
@RequiresApi(25)
final class InputConnectionCompatApi25 {

    public interface OnCommitContentListener {
        boolean onCommitContent(Object obj, int i, Bundle bundle);
    }

    InputConnectionCompatApi25() {
    }

    public static boolean commitContent(InputConnection inputConnection, Object obj, int i, Bundle bundle) {
        return inputConnection.commitContent((InputContentInfo) obj, i, bundle);
    }

    public static InputConnection createWrapper(InputConnection inputConnection, final OnCommitContentListener onCommitContentListener) {
        return new InputConnectionWrapper(inputConnection, false) {
            /* class android.support.v13.view.inputmethod.InputConnectionCompatApi25.AnonymousClass1 */

            public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
                if (onCommitContentListener.onCommitContent(inputContentInfo, i, bundle)) {
                    return true;
                }
                return super.commitContent(inputContentInfo, i, bundle);
            }
        };
    }
}

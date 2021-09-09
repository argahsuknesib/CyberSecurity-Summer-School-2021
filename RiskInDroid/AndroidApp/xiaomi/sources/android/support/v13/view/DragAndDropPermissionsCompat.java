package android.support.v13.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.os.BuildCompat;
import android.view.DragEvent;

@TargetApi(13)
@RequiresApi(13)
public final class DragAndDropPermissionsCompat {
    private static DragAndDropPermissionsCompatImpl IMPL;
    private Object mDragAndDropPermissions;

    interface DragAndDropPermissionsCompatImpl {
        void release(Object obj);

        Object request(Activity activity, DragEvent dragEvent);
    }

    static class BaseDragAndDropPermissionsCompatImpl implements DragAndDropPermissionsCompatImpl {
        public void release(Object obj) {
        }

        public Object request(Activity activity, DragEvent dragEvent) {
            return null;
        }

        BaseDragAndDropPermissionsCompatImpl() {
        }
    }

    static class Api24DragAndDropPermissionsCompatImpl extends BaseDragAndDropPermissionsCompatImpl {
        Api24DragAndDropPermissionsCompatImpl() {
        }

        public Object request(Activity activity, DragEvent dragEvent) {
            return DragAndDropPermissionsCompatApi24.request(activity, dragEvent);
        }

        public void release(Object obj) {
            DragAndDropPermissionsCompatApi24.release(obj);
        }
    }

    static {
        if (BuildCompat.isAtLeastN()) {
            IMPL = new Api24DragAndDropPermissionsCompatImpl();
        } else {
            IMPL = new BaseDragAndDropPermissionsCompatImpl();
        }
    }

    private DragAndDropPermissionsCompat(Object obj) {
        this.mDragAndDropPermissions = obj;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static DragAndDropPermissionsCompat request(Activity activity, DragEvent dragEvent) {
        Object request = IMPL.request(activity, dragEvent);
        if (request != null) {
            return new DragAndDropPermissionsCompat(request);
        }
        return null;
    }

    public final void release() {
        IMPL.release(this.mDragAndDropPermissions);
    }
}

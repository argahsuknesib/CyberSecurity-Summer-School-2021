package android.support.v13.view;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.support.annotation.RequiresApi;
import android.support.v4.os.BuildCompat;
import android.view.View;

@TargetApi(13)
@RequiresApi(13)
public class ViewCompat extends android.support.v4.view.ViewCompat {
    static ViewCompatImpl IMPL;

    interface ViewCompatImpl {
        void cancelDragAndDrop(View view);

        boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i);

        void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder);
    }

    static class BaseViewCompatImpl implements ViewCompatImpl {
        public void cancelDragAndDrop(View view) {
        }

        public void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
        }

        BaseViewCompatImpl() {
        }

        public boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
            return view.startDrag(clipData, dragShadowBuilder, obj, i);
        }
    }

    static class Api24ViewCompatImpl implements ViewCompatImpl {
        Api24ViewCompatImpl() {
        }

        public boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
            return ViewCompatApi24.startDragAndDrop(view, clipData, dragShadowBuilder, obj, i);
        }

        public void cancelDragAndDrop(View view) {
            ViewCompatApi24.cancelDragAndDrop(view);
        }

        public void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
            ViewCompatApi24.updateDragShadow(view, dragShadowBuilder);
        }
    }

    static {
        if (BuildCompat.isAtLeastN()) {
            IMPL = new Api24ViewCompatImpl();
        } else {
            IMPL = new BaseViewCompatImpl();
        }
    }

    public static boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        return IMPL.startDragAndDrop(view, clipData, dragShadowBuilder, obj, i);
    }

    public static void cancelDragAndDrop(View view) {
        IMPL.cancelDragAndDrop(view);
    }

    public static void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
        IMPL.updateDragShadow(view, dragShadowBuilder);
    }

    private ViewCompat() {
    }
}

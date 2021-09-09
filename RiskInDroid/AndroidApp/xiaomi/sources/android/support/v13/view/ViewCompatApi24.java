package android.support.v13.view;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(24)
@RequiresApi(24)
class ViewCompatApi24 {
    public static boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
    }

    public static void cancelDragAndDrop(View view) {
        view.cancelDragAndDrop();
    }

    public static void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
        view.updateDragShadow(dragShadowBuilder);
    }

    private ViewCompatApi24() {
    }
}

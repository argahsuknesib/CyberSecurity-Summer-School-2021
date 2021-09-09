package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ListView;

@TargetApi(9)
@RequiresApi(9)
class ListViewCompatGingerbread {
    ListViewCompatGingerbread() {
    }

    static void scrollListBy(ListView listView, int i) {
        View childAt;
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1 && (childAt = listView.getChildAt(0)) != null) {
            listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
        }
    }
}

package _m_j;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

public final class cv extends cr {
    private final ListView O00000oo;

    public cv(ListView listView) {
        super(listView);
        this.O00000oo = listView;
    }

    public final void O000000o(int i) {
        View childAt;
        ListView listView = this.O00000oo;
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1 && (childAt = listView.getChildAt(0)) != null) {
            listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[RETURN] */
    public final boolean O00000Oo(int i) {
        ListView listView = this.O00000oo;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 < count || listView.getChildAt(childCount - 1).getBottom() > listView.getHeight()) {
                return true;
            }
            return false;
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}

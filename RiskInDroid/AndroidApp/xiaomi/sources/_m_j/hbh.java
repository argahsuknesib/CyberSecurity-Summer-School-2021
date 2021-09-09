package _m_j;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/GroupDelegate;", "", "ids", "", "([I)V", "getVisibility", "", "container", "Landroid/view/View;", "setVisibility", "", "visibility", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hbh {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int[] f18740O000000o;

    public hbh(int[] iArr) {
        ixe.O00000o(iArr, "ids");
        this.f18740O000000o = iArr;
    }

    public final void O000000o(View view, int i) {
        ixe.O00000o(view, "container");
        int[] iArr = this.f18740O000000o;
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = iArr[i2];
            i2++;
            View findViewById = view.findViewById(i3);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
        }
    }

    public final int O000000o(View view) {
        ixe.O00000o(view, "container");
        int i = 0;
        if (this.f18740O000000o.length == 0) {
            return 8;
        }
        int[] iArr = this.f18740O000000o;
        int length = iArr.length;
        while (i < length) {
            int i2 = iArr[i];
            i++;
            View findViewById = view.findViewById(i2);
            if (findViewById != null) {
                return findViewById.getVisibility();
            }
        }
        return 8;
    }
}

package _m_j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.xiaomi.smarthome.R;

public final class eyz extends PopupWindow {

    /* renamed from: O000000o  reason: collision with root package name */
    public View.OnClickListener f15964O000000o;

    public eyz(Context context) {
        super(LayoutInflater.from(context.getApplicationContext()).inflate((int) R.layout.view_ad_pop, (ViewGroup) null), -2, -2);
        setTouchable(true);
        setFocusable(false);
        setOutsideTouchable(false);
    }
}

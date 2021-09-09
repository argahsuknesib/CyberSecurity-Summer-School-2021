package _m_j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.ExpandableItemIndicator;

public final class gqo extends ExpandableItemIndicator.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private ImageView f18153O000000o;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.ExpandableItemIndicator, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o(Context context, ExpandableItemIndicator expandableItemIndicator) {
        this.f18153O000000o = (ImageView) LayoutInflater.from(context).inflate((int) R.layout.sm_widget_expandable_item_indicator_imageview, (ViewGroup) expandableItemIndicator, true).findViewById(R.id.image_view);
    }

    public final void O000000o(boolean z) {
        this.f18153O000000o.setImageResource(z ? R.drawable.std_home_btn_expanding : R.drawable.std_home_btn_collasping);
    }
}

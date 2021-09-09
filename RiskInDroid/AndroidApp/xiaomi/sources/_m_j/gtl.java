package _m_j;

import _m_j.gti;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.common.widget.ListItemView;
import com.xiaomi.smarthome.listcamera.CameraSortActivity;
import java.util.ArrayList;
import java.util.List;

public final class gtl extends RecyclerView.O000000o<O000000o> implements axe<O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    CameraSortActivity f18263O000000o;
    public List<Device> O00000Oo = new ArrayList();

    public final /* bridge */ /* synthetic */ axj O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
        return null;
    }

    public final boolean O00000Oo(int i, int i2) {
        return false;
    }

    public final /* synthetic */ boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3) {
        O000000o o000000o = (O000000o) o000OOo0;
        ImageView imageView = o000000o.O00000o;
        if (imageView == null) {
            return false;
        }
        Rect rect = new Rect();
        o000000o.itemView.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        imageView.getGlobalVisibleRect(rect2);
        rect2.left -= rect.left;
        rect2.top -= rect.top;
        return rect2.contains(i2, i3);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        O000000o o000000o = (O000000o) o000OOo0;
        ((ListItemView) o000000o.O00000oO).setPosition(i);
        Device device = this.O00000Oo.get(i);
        if (device != null) {
            DeviceFactory.O00000Oo(device.model, o000000o.O00000o0);
            o000000o.f18264O000000o.setText(device.getName());
            if (device.isOnline) {
                o000000o.f18264O000000o.setTextColor(gkv.f17949O000000o.getResources().getColor(R.color.mj_color_black));
            } else {
                o000000o.f18264O000000o.setTextColor(gkv.f17949O000000o.getResources().getColor(R.color.mj_color_black_30_transparent));
            }
            o000000o.O00000Oo.setText(ggb.O00000Oo().O0000o0O(device.did));
        }
    }

    public gtl(CameraSortActivity cameraSortActivity) {
        this.f18263O000000o = cameraSortActivity;
        for (gti.O000000o o000000o : gti.O000000o().O00000o0()) {
            Device O000000o2 = fno.O000000o().O000000o(o000000o.f18248O000000o);
            if (O000000o2 != null) {
                this.O00000Oo.add(O000000o2);
            }
        }
        setHasStableIds(true);
    }

    public final long getItemId(int i) {
        return (long) this.O00000Oo.get(i).hashCode();
    }

    public final void b_(int i, int i2) {
        this.O00000Oo.add(i2, this.O00000Oo.remove(i));
        this.f18263O000000o.orderChanged();
    }

    public final int getItemCount() {
        return this.O00000Oo.size();
    }

    public static abstract class O00000Oo extends axz {
        public View O00000oO;

        public O00000Oo(View view) {
            super(view);
            this.O00000oO = view;
        }

        public View getSwipeableContainerView() {
            return this.O00000oO;
        }
    }

    public static class O000000o extends O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f18264O000000o;
        public TextView O00000Oo;
        public ImageView O00000o;
        public SimpleDraweeView O00000o0;

        public O000000o(View view) {
            super(view);
            this.f18264O000000o = (TextView) view.findViewById(R.id.name);
            this.O00000Oo = (TextView) view.findViewById(R.id.name_status);
            this.O00000o0 = (SimpleDraweeView) view.findViewById(R.id.image);
            this.O00000o = (ImageView) view.findViewById(R.id.img_handle);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.client_all_item_v2_sort, viewGroup, false));
    }
}

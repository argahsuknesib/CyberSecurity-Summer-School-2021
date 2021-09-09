package _m_j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/BaseFullScreenNoItemAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "desc", "", "(I)V", "getDesc", "()I", "getItemCount", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateViewHolder", "Lcom/xiaomi/smarthome/newui/adapter/BaseFullScreenNoItemAdapter$VH;", "parent", "Landroid/view/ViewGroup;", "viewType", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class hau extends gzm {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f18715O000000o;

    public int getItemCount() {
        return 1;
    }

    public hau(int i) {
        this.f18715O000000o = i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.device_main_item_empty_fullscreen, viewGroup, false);
        ixe.O00000Oo(inflate, "item");
        return new O000000o(inflate);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "holder");
        ((TextView) o000OOo0.itemView.findViewById(R.id.desc)).setText(this.f18715O000000o);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/BaseFullScreenNoItemAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o extends RecyclerView.O000OOo0 {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(View view) {
            super(view);
            ixe.O00000o(view, "itemView");
        }
    }
}

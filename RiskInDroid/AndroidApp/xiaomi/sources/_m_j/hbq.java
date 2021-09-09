package _m_j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0015B2\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/SimpleCardLayoutAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/CardPathDrawableDefaultOffsetAdapter;", "layoutId", "", "onBind", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "item", "", "(ILkotlin/jvm/functions/Function1;)V", "getItemCount", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "p1", "ViewHolder", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class hbq extends haw {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f18754O000000o = R.layout.device_main_logout_layout;
    private final iwc<View, iuh> O00000Oo;

    public int getItemCount() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [_m_j.iwc<android.view.View, _m_j.iuh>, _m_j.iwc<? super android.view.View, _m_j.iuh>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public hbq(int i, iwc<? super View, iuh> r2) {
        ixe.O00000o(r2, "onBind");
        this.O00000Oo = r2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f18754O000000o, viewGroup, false);
        ixe.O00000Oo(inflate, "item");
        return new O000000o(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "holder");
        iwc<View, iuh> iwc = this.O00000Oo;
        View view = o000OOo0.itemView;
        ixe.O00000Oo(view, "holder.itemView");
        iwc.invoke(view);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/SimpleCardLayoutAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/SimpleCardLayoutAdapter;Landroid/view/View;)V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ hbq f18755O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(hbq hbq, View view) {
            super(view);
            ixe.O00000o(hbq, "this$0");
            ixe.O00000o(view, "itemView");
            this.f18755O000000o = hbq;
        }
    }
}

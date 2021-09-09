package _m_j;

import android.view.View;
import android.widget.AdapterView;
import com.hannto.circledialog.params.ItemsParams;

public final class O0000o implements AdapterView.OnItemClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public final /* synthetic */ ItemsParams f5252O000000o;

    public O0000o(ItemsParams itemsParams) {
        this.f5252O000000o = itemsParams;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AdapterView.OnItemClickListener onItemClickListener = this.f5252O000000o.O00000o0;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(adapterView, view, i, j);
            this.f5252O000000o.O00000o0 = null;
        }
        this.f5252O000000o.O000000o();
    }
}

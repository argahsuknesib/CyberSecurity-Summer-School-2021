package _m_j;

import _m_j.ewr;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.adapter.countdown.CommentViewAdapter;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.List;

public final class eur extends euk<ewr, vr> {
    private eum O00000o0;

    public final int O000000o() {
        return 7;
    }

    public final int O00000Oo() {
        return R.layout.comment_list_item;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        ewr ewr = (ewr) obj;
        View view = vrVar.itemView;
        CustomTextView customTextView = (CustomTextView) view.findViewById(R.id.hot_reviews_title);
        if (!TextUtils.isEmpty(ewr.O00000o)) {
            customTextView.setVisibility(0);
            customTextView.setText(ewr.O00000o);
        } else {
            customTextView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(ewr.O0000Oo0)) {
            customTextView.setTextColor(Color.parseColor(ewr.O0000Oo0));
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        CommentViewAdapter commentViewAdapter = new CommentViewAdapter(view.getContext(), ewr, this.O00000o0);
        recyclerView.setAdapter(commentViewAdapter);
        List<ewr.O000000o> list = ewr.O0000oo0;
        if (list != null) {
            commentViewAdapter.f3895O000000o.clear();
            commentViewAdapter.f3895O000000o.addAll(list);
            commentViewAdapter.notifyDataSetChanged();
        }
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewr) obj, i);
    }

    public eur(eum eum) {
        this.O00000o0 = eum;
    }
}
